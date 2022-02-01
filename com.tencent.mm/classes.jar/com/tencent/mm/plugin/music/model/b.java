package com.tencent.mm.plugin.music.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class b
{
  private String album;
  private String kwj;
  private long offset;
  private int rko;
  private String title;
  public ArrayList<a> wkH;
  private LinkedList<Long> wkI;
  private String wkJ;
  private String wkK;
  private String wkL;
  private boolean wkM;
  
  private b()
  {
    AppMethodBeat.i(63007);
    this.wkI = new LinkedList();
    this.wkH = new ArrayList();
    this.rko = 0;
    this.wkM = false;
    AppMethodBeat.o(63007);
  }
  
  public static b a(String paramString1, String paramString2, String paramString3, boolean paramBoolean1, String paramString4, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(192467);
    b localb = new b();
    long l = bt.HI();
    if (!bt.isNullOrNil(paramString1)) {
      if (paramString1 == null)
      {
        ad.w("MicroMsg.Music.LyricObj", "parserLrc: but lrc or lrcMgr is null");
        ad.d("MicroMsg.Music.LyricObj", "getLrcMgr beg: src lrc = %s", new Object[] { paramString1 });
        ad.d("MicroMsg.Music.LyricObj", "parse finish: sentence size [%d], result:", new Object[] { Integer.valueOf(localb.wkH.size()) });
        label77:
        if (paramBoolean3)
        {
          if (!bt.isNullOrNil(paramString3)) {
            break label1000;
          }
          ad.w("MicroMsg.Music.LyricObj", "add lyric prefix: but prefix is empty, return");
        }
        label96:
        if ((!bt.isNullOrNil(paramString1)) && (paramBoolean3))
        {
          if (!bt.isNullOrNil(paramString2)) {
            break label1159;
          }
          ad.w("MicroMsg.Music.LyricObj", "add lyric prefix: but prefix is empty, return");
        }
      }
    }
    for (;;)
    {
      ad.d("MicroMsg.Music.LyricObj", "getLrcMgr finish: use %d ms", new Object[] { Long.valueOf(bt.aO(l)) });
      AppMethodBeat.o(192467);
      return localb;
      paramString4 = paramString1.replaceAll("\n", " ").replaceAll("\r", " ");
      Matcher localMatcher1 = Pattern.compile("(\\[((\\d{2}:\\d{2}(\\.\\d{2}){0,1}\\])|(al:|ar:|by:|offset:|re:|ti:|ve:))[^\\[]*)").matcher(paramString4);
      while (localMatcher1.find())
      {
        String str = localMatcher1.group();
        localMatcher1.start();
        localMatcher1.end();
        if (str == null)
        {
          ad.w("MicroMsg.Music.LyricObj", "parserLine fail: lrcMgr or str is null");
        }
        else if (str.startsWith("[ti:"))
        {
          localb.title = ii(str, "[ti:");
        }
        else if (str.startsWith("[ar:"))
        {
          localb.kwj = ii(str, "[ar:");
        }
        else if (str.startsWith("[al:"))
        {
          localb.album = ii(str, "[al:");
        }
        else if (str.startsWith("[by:"))
        {
          localb.wkJ = ii(str, "[by:");
        }
        else if (str.startsWith("[offset:"))
        {
          localb.offset = bt.getLong(ii(str, "[offset:"), 0L);
        }
        else if (str.startsWith("[re:"))
        {
          localb.wkK = ii(str, "[re:");
        }
        else if (str.startsWith("[ve:"))
        {
          localb.wkL = ii(str, "[ve:");
        }
        else
        {
          Pattern localPattern = Pattern.compile("\\[(\\d{2}:\\d{2}(\\.\\d{2}){0,1})\\]");
          Matcher localMatcher2 = localPattern.matcher(str);
          a locala = new a();
          label427:
          if (localMatcher2.find())
          {
            if (localMatcher2.groupCount() > 0) {
              locala.timestamp = asD(localMatcher2.group(1));
            }
            paramString4 = localPattern.split(str);
            if ((paramString4 != null) && (paramString4.length > 0))
            {
              localObject = paramString4[(paramString4.length - 1)];
              paramString4 = (String)localObject;
              if (localObject != null) {
                paramString4 = ((String)localObject).trim();
              }
              localObject = paramString4;
              if (bt.isNullOrNil(paramString4)) {
                localObject = " ";
              }
              locala.content = ((String)localObject);
              i = 0;
            }
            for (;;)
            {
              if (i < localb.wkI.size())
              {
                paramString4 = new a();
                paramString4.timestamp = ((Long)localb.wkI.get(i)).longValue();
                paramString4.content = locala.content;
                paramString4.wkN = true;
                i += 1;
                continue;
                localb.wkI.add(Long.valueOf(locala.timestamp));
                break;
              }
            }
            localb.wkI.clear();
            i = localb.wkH.size() - 1;
          }
          for (;;)
          {
            if ((i >= 0) && (((a)localb.wkH.get(i)).timestamp != locala.timestamp))
            {
              if (((a)localb.wkH.get(i)).timestamp < locala.timestamp) {
                localb.wkH.add(i + 1, locala);
              }
            }
            else
            {
              if (i >= 0) {
                break label427;
              }
              localb.wkH.add(0, locala);
              break label427;
              break;
            }
            i -= 1;
          }
        }
      }
      ad.d("MicroMsg.Music.LyricObj", "handle offset %d", new Object[] { Long.valueOf(localb.offset) });
      if (localb.offset != 0L)
      {
        i = 0;
        while (i < localb.wkH.size())
        {
          paramString4 = (a)localb.wkH.get(i);
          paramString4.timestamp += localb.offset;
          i += 1;
        }
        localb.offset = 0L;
      }
      int i = 0;
      while (i < localb.wkH.size() - 1)
      {
        paramString4 = (a)localb.wkH.get(i);
        if ((paramString4.wkN) && (paramString4.content.equals(((a)localb.wkH.get(i + 1)).content))) {
          paramString4.content = " ";
        }
        i += 1;
      }
      break;
      Object localObject = new a();
      ((a)localObject).timestamp = 0L;
      if (paramBoolean2) {
        ((a)localObject).content = paramString4;
      }
      for (;;)
      {
        if (((a)localObject).content == null) {
          break label998;
        }
        localb.wkH.add(localObject);
        break;
        if (!paramBoolean1) {
          ((a)localObject).content = aj.getContext().getString(2131761621);
        } else {
          ((a)localObject).content = aj.getContext().getString(2131761622);
        }
      }
      label998:
      break label77;
      label1000:
      paramString4 = new a();
      paramString4.timestamp = 0L;
      paramString4.content = aj.getContext().getString(2131764617, new Object[] { v.zf(paramString3) });
      if (localb.wkH.isEmpty())
      {
        localb.wkH.add(paramString4);
        break label96;
      }
      if (localb.wkH.size() == 1)
      {
        localb.wkH.add(0, paramString4);
        ((a)localb.wkH.get(1)).timestamp = 5000L;
        break label96;
      }
      localb.wkH.add(0, paramString4);
      ((a)localb.wkH.get(1)).timestamp = (3L * (((a)localb.wkH.get(2)).timestamp >> 2));
      break label96;
      label1159:
      paramString1 = new a();
      paramString1.timestamp = 0L;
      paramString1.content = paramString2;
      if (localb.wkH.isEmpty())
      {
        localb.wkH.add(paramString1);
      }
      else if (localb.wkH.size() == 1)
      {
        localb.wkH.add(0, paramString1);
        ((a)localb.wkH.get(1)).timestamp = 5000L;
      }
      else
      {
        localb.wkH.add(0, paramString1);
        ((a)localb.wkH.get(1)).timestamp = (3L * (((a)localb.wkH.get(2)).timestamp >> 2));
      }
    }
  }
  
  private static long asD(String paramString)
  {
    AppMethodBeat.i(63005);
    for (;;)
    {
      try
      {
        paramString = paramString.split(":");
        int k = e.eZ(paramString[0]);
        if (paramString.length <= 1) {
          break label145;
        }
        paramString = paramString[1].split("\\.");
        j = e.eZ(paramString[0]);
        if (paramString.length > 1)
        {
          i = e.eZ(paramString[1]);
          long l1 = k;
          long l2 = j * 1000;
          long l3 = i * 10;
          AppMethodBeat.o(63005);
          return l3 + (l2 + l1 * 60L * 1000L);
        }
      }
      catch (Exception paramString)
      {
        ad.printErrStackTrace("MicroMsg.Music.LyricObj", paramString, "", new Object[0]);
        ad.w("MicroMsg.Music.LyricObj", "strToLong error: %s", new Object[] { paramString.getLocalizedMessage() });
        AppMethodBeat.o(63005);
        return 0L;
      }
      int i = 0;
      continue;
      label145:
      i = 0;
      int j = 0;
    }
  }
  
  private static String ii(String paramString1, String paramString2)
  {
    AppMethodBeat.i(63004);
    if ((bt.isNullOrNil(paramString1)) || (bt.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(63004);
      return paramString1;
    }
    if (paramString2.length() >= paramString1.length() - 1)
    {
      AppMethodBeat.o(63004);
      return "";
    }
    String str = paramString1.substring(paramString2.length(), paramString1.length() - 1);
    ad.d("MicroMsg.Music.LyricObj", "str[%s] prefix[%s] attr[%s]", new Object[] { paramString1, paramString2, str });
    AppMethodBeat.o(63004);
    return str;
  }
  
  public final a Lo(int paramInt)
  {
    AppMethodBeat.i(63006);
    if ((paramInt < 0) || (paramInt >= this.wkH.size()))
    {
      AppMethodBeat.o(63006);
      return null;
    }
    a locala = (a)this.wkH.get(paramInt);
    AppMethodBeat.o(63006);
    return locala;
  }
  
  public static final class a
  {
    public String content;
    public long timestamp;
    public boolean wkN;
    
    public final String toString()
    {
      AppMethodBeat.i(63002);
      String str = String.format("[%d %s]", new Object[] { Long.valueOf(this.timestamp), this.content });
      AppMethodBeat.o(63002);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.b
 * JD-Core Version:    0.7.0.1
 */