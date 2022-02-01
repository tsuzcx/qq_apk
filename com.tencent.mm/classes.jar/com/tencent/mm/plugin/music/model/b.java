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
  private int goS;
  private String jBo;
  private long offset;
  public ArrayList<a> tWB;
  private LinkedList<Long> tWC;
  private String tWD;
  private String tWE;
  private String tWF;
  private boolean tWG;
  private String title;
  
  private b()
  {
    AppMethodBeat.i(63007);
    this.tWC = new LinkedList();
    this.tWB = new ArrayList();
    this.goS = 0;
    this.tWG = false;
    AppMethodBeat.o(63007);
  }
  
  public static b a(String paramString1, String paramString2, String paramString3, boolean paramBoolean1, String paramString4, boolean paramBoolean2)
  {
    AppMethodBeat.i(63003);
    b localb = new b();
    long l = bt.GC();
    if (!bt.isNullOrNil(paramString1)) {
      if (paramString1 == null)
      {
        ad.w("MicroMsg.Music.LyricObj", "parserLrc: but lrc or lrcMgr is null");
        ad.d("MicroMsg.Music.LyricObj", "getLrcMgr beg: src lrc = %s", new Object[] { paramString1 });
        ad.d("MicroMsg.Music.LyricObj", "parse finish: sentence size [%d], result:", new Object[] { Integer.valueOf(localb.tWB.size()) });
        label77:
        if (!bt.isNullOrNil(paramString3)) {
          break label990;
        }
        ad.w("MicroMsg.Music.LyricObj", "add lyric prefix: but prefix is empty, return");
        label91:
        if (!bt.isNullOrNil(paramString1))
        {
          if (!bt.isNullOrNil(paramString2)) {
            break label1149;
          }
          ad.w("MicroMsg.Music.LyricObj", "add lyric prefix: but prefix is empty, return");
        }
      }
    }
    for (;;)
    {
      ad.d("MicroMsg.Music.LyricObj", "getLrcMgr finish: use %d ms", new Object[] { Long.valueOf(bt.aS(l)) });
      AppMethodBeat.o(63003);
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
          localb.title = hE(str, "[ti:");
        }
        else if (str.startsWith("[ar:"))
        {
          localb.jBo = hE(str, "[ar:");
        }
        else if (str.startsWith("[al:"))
        {
          localb.album = hE(str, "[al:");
        }
        else if (str.startsWith("[by:"))
        {
          localb.tWD = hE(str, "[by:");
        }
        else if (str.startsWith("[offset:"))
        {
          localb.offset = bt.getLong(hE(str, "[offset:"), 0L);
        }
        else if (str.startsWith("[re:"))
        {
          localb.tWE = hE(str, "[re:");
        }
        else if (str.startsWith("[ve:"))
        {
          localb.tWF = hE(str, "[ve:");
        }
        else
        {
          Pattern localPattern = Pattern.compile("\\[(\\d{2}:\\d{2}(\\.\\d{2}){0,1})\\]");
          Matcher localMatcher2 = localPattern.matcher(str);
          a locala = new a();
          label417:
          if (localMatcher2.find())
          {
            if (localMatcher2.groupCount() > 0) {
              locala.timestamp = aiJ(localMatcher2.group(1));
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
              if (i < localb.tWC.size())
              {
                paramString4 = new a();
                paramString4.timestamp = ((Long)localb.tWC.get(i)).longValue();
                paramString4.content = locala.content;
                paramString4.tWH = true;
                i += 1;
                continue;
                localb.tWC.add(Long.valueOf(locala.timestamp));
                break;
              }
            }
            localb.tWC.clear();
            i = localb.tWB.size() - 1;
          }
          for (;;)
          {
            if ((i >= 0) && (((a)localb.tWB.get(i)).timestamp != locala.timestamp))
            {
              if (((a)localb.tWB.get(i)).timestamp < locala.timestamp) {
                localb.tWB.add(i + 1, locala);
              }
            }
            else
            {
              if (i >= 0) {
                break label417;
              }
              localb.tWB.add(0, locala);
              break label417;
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
        while (i < localb.tWB.size())
        {
          paramString4 = (a)localb.tWB.get(i);
          paramString4.timestamp += localb.offset;
          i += 1;
        }
        localb.offset = 0L;
      }
      int i = 0;
      while (i < localb.tWB.size() - 1)
      {
        paramString4 = (a)localb.tWB.get(i);
        if ((paramString4.tWH) && (paramString4.content.equals(((a)localb.tWB.get(i + 1)).content))) {
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
          break label988;
        }
        localb.tWB.add(localObject);
        break;
        if (!paramBoolean1) {
          ((a)localObject).content = aj.getContext().getString(2131761621);
        } else {
          ((a)localObject).content = aj.getContext().getString(2131761622);
        }
      }
      label988:
      break label77;
      label990:
      paramString4 = new a();
      paramString4.timestamp = 0L;
      paramString4.content = aj.getContext().getString(2131764617, new Object[] { v.sh(paramString3) });
      if (localb.tWB.isEmpty())
      {
        localb.tWB.add(paramString4);
        break label91;
      }
      if (localb.tWB.size() == 1)
      {
        localb.tWB.add(0, paramString4);
        ((a)localb.tWB.get(1)).timestamp = 5000L;
        break label91;
      }
      localb.tWB.add(0, paramString4);
      ((a)localb.tWB.get(1)).timestamp = (3L * (((a)localb.tWB.get(2)).timestamp >> 2));
      break label91;
      label1149:
      paramString1 = new a();
      paramString1.timestamp = 0L;
      paramString1.content = paramString2;
      if (localb.tWB.isEmpty())
      {
        localb.tWB.add(paramString1);
      }
      else if (localb.tWB.size() == 1)
      {
        localb.tWB.add(0, paramString1);
        ((a)localb.tWB.get(1)).timestamp = 5000L;
      }
      else
      {
        localb.tWB.add(0, paramString1);
        ((a)localb.tWB.get(1)).timestamp = (3L * (((a)localb.tWB.get(2)).timestamp >> 2));
      }
    }
  }
  
  private static long aiJ(String paramString)
  {
    AppMethodBeat.i(63005);
    for (;;)
    {
      try
      {
        paramString = paramString.split(":");
        int k = e.ep(paramString[0]);
        if (paramString.length <= 1) {
          break label145;
        }
        paramString = paramString[1].split("\\.");
        j = e.ep(paramString[0]);
        if (paramString.length > 1)
        {
          i = e.ep(paramString[1]);
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
  
  private static String hE(String paramString1, String paramString2)
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
  
  public final a HN(int paramInt)
  {
    AppMethodBeat.i(63006);
    if ((paramInt < 0) || (paramInt >= this.tWB.size()))
    {
      AppMethodBeat.o(63006);
      return null;
    }
    a locala = (a)this.tWB.get(paramInt);
    AppMethodBeat.o(63006);
    return locala;
  }
  
  public static final class a
  {
    public String content;
    public boolean tWH;
    public long timestamp;
    
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