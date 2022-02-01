package com.tencent.mm.plugin.music.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.w;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class b
{
  private String album;
  private String kzy;
  private long offset;
  private int rss;
  private String title;
  public ArrayList<a> wAq;
  private LinkedList<Long> wAr;
  private String wAs;
  private String wAt;
  private String wAu;
  private boolean wAv;
  
  private b()
  {
    AppMethodBeat.i(63007);
    this.wAr = new LinkedList();
    this.wAq = new ArrayList();
    this.rss = 0;
    this.wAv = false;
    AppMethodBeat.o(63007);
  }
  
  public static b a(String paramString1, String paramString2, String paramString3, boolean paramBoolean1, String paramString4, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(220680);
    b localb = new b();
    long l = bu.HQ();
    if (!bu.isNullOrNil(paramString1)) {
      if (paramString1 == null)
      {
        ae.w("MicroMsg.Music.LyricObj", "parserLrc: but lrc or lrcMgr is null");
        ae.d("MicroMsg.Music.LyricObj", "getLrcMgr beg: src lrc = %s", new Object[] { paramString1 });
        ae.d("MicroMsg.Music.LyricObj", "parse finish: sentence size [%d], result:", new Object[] { Integer.valueOf(localb.wAq.size()) });
        label77:
        if (paramBoolean3)
        {
          if (!bu.isNullOrNil(paramString3)) {
            break label1000;
          }
          ae.w("MicroMsg.Music.LyricObj", "add lyric prefix: but prefix is empty, return");
        }
        label96:
        if ((!bu.isNullOrNil(paramString1)) && (paramBoolean3))
        {
          if (!bu.isNullOrNil(paramString2)) {
            break label1159;
          }
          ae.w("MicroMsg.Music.LyricObj", "add lyric prefix: but prefix is empty, return");
        }
      }
    }
    for (;;)
    {
      ae.d("MicroMsg.Music.LyricObj", "getLrcMgr finish: use %d ms", new Object[] { Long.valueOf(bu.aO(l)) });
      AppMethodBeat.o(220680);
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
          ae.w("MicroMsg.Music.LyricObj", "parserLine fail: lrcMgr or str is null");
        }
        else if (str.startsWith("[ti:"))
        {
          localb.title = io(str, "[ti:");
        }
        else if (str.startsWith("[ar:"))
        {
          localb.kzy = io(str, "[ar:");
        }
        else if (str.startsWith("[al:"))
        {
          localb.album = io(str, "[al:");
        }
        else if (str.startsWith("[by:"))
        {
          localb.wAs = io(str, "[by:");
        }
        else if (str.startsWith("[offset:"))
        {
          localb.offset = bu.getLong(io(str, "[offset:"), 0L);
        }
        else if (str.startsWith("[re:"))
        {
          localb.wAt = io(str, "[re:");
        }
        else if (str.startsWith("[ve:"))
        {
          localb.wAu = io(str, "[ve:");
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
              locala.timestamp = atQ(localMatcher2.group(1));
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
              if (bu.isNullOrNil(paramString4)) {
                localObject = " ";
              }
              locala.content = ((String)localObject);
              i = 0;
            }
            for (;;)
            {
              if (i < localb.wAr.size())
              {
                paramString4 = new a();
                paramString4.timestamp = ((Long)localb.wAr.get(i)).longValue();
                paramString4.content = locala.content;
                paramString4.wAw = true;
                i += 1;
                continue;
                localb.wAr.add(Long.valueOf(locala.timestamp));
                break;
              }
            }
            localb.wAr.clear();
            i = localb.wAq.size() - 1;
          }
          for (;;)
          {
            if ((i >= 0) && (((a)localb.wAq.get(i)).timestamp != locala.timestamp))
            {
              if (((a)localb.wAq.get(i)).timestamp < locala.timestamp) {
                localb.wAq.add(i + 1, locala);
              }
            }
            else
            {
              if (i >= 0) {
                break label427;
              }
              localb.wAq.add(0, locala);
              break label427;
              break;
            }
            i -= 1;
          }
        }
      }
      ae.d("MicroMsg.Music.LyricObj", "handle offset %d", new Object[] { Long.valueOf(localb.offset) });
      if (localb.offset != 0L)
      {
        i = 0;
        while (i < localb.wAq.size())
        {
          paramString4 = (a)localb.wAq.get(i);
          paramString4.timestamp += localb.offset;
          i += 1;
        }
        localb.offset = 0L;
      }
      int i = 0;
      while (i < localb.wAq.size() - 1)
      {
        paramString4 = (a)localb.wAq.get(i);
        if ((paramString4.wAw) && (paramString4.content.equals(((a)localb.wAq.get(i + 1)).content))) {
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
        localb.wAq.add(localObject);
        break;
        if (!paramBoolean1) {
          ((a)localObject).content = ak.getContext().getString(2131761621);
        } else {
          ((a)localObject).content = ak.getContext().getString(2131761622);
        }
      }
      label998:
      break label77;
      label1000:
      paramString4 = new a();
      paramString4.timestamp = 0L;
      paramString4.content = ak.getContext().getString(2131764617, new Object[] { w.zP(paramString3) });
      if (localb.wAq.isEmpty())
      {
        localb.wAq.add(paramString4);
        break label96;
      }
      if (localb.wAq.size() == 1)
      {
        localb.wAq.add(0, paramString4);
        ((a)localb.wAq.get(1)).timestamp = 5000L;
        break label96;
      }
      localb.wAq.add(0, paramString4);
      ((a)localb.wAq.get(1)).timestamp = (3L * (((a)localb.wAq.get(2)).timestamp >> 2));
      break label96;
      label1159:
      paramString1 = new a();
      paramString1.timestamp = 0L;
      paramString1.content = paramString2;
      if (localb.wAq.isEmpty())
      {
        localb.wAq.add(paramString1);
      }
      else if (localb.wAq.size() == 1)
      {
        localb.wAq.add(0, paramString1);
        ((a)localb.wAq.get(1)).timestamp = 5000L;
      }
      else
      {
        localb.wAq.add(0, paramString1);
        ((a)localb.wAq.get(1)).timestamp = (3L * (((a)localb.wAq.get(2)).timestamp >> 2));
      }
    }
  }
  
  private static long atQ(String paramString)
  {
    AppMethodBeat.i(63005);
    for (;;)
    {
      try
      {
        paramString = paramString.split(":");
        int k = e.fe(paramString[0]);
        if (paramString.length <= 1) {
          break label145;
        }
        paramString = paramString[1].split("\\.");
        j = e.fe(paramString[0]);
        if (paramString.length > 1)
        {
          i = e.fe(paramString[1]);
          long l1 = k;
          long l2 = j * 1000;
          long l3 = i * 10;
          AppMethodBeat.o(63005);
          return l3 + (l2 + l1 * 60L * 1000L);
        }
      }
      catch (Exception paramString)
      {
        ae.printErrStackTrace("MicroMsg.Music.LyricObj", paramString, "", new Object[0]);
        ae.w("MicroMsg.Music.LyricObj", "strToLong error: %s", new Object[] { paramString.getLocalizedMessage() });
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
  
  private static String io(String paramString1, String paramString2)
  {
    AppMethodBeat.i(63004);
    if ((bu.isNullOrNil(paramString1)) || (bu.isNullOrNil(paramString2)))
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
    ae.d("MicroMsg.Music.LyricObj", "str[%s] prefix[%s] attr[%s]", new Object[] { paramString1, paramString2, str });
    AppMethodBeat.o(63004);
    return str;
  }
  
  public final a LT(int paramInt)
  {
    AppMethodBeat.i(63006);
    if ((paramInt < 0) || (paramInt >= this.wAq.size()))
    {
      AppMethodBeat.o(63006);
      return null;
    }
    a locala = (a)this.wAq.get(paramInt);
    AppMethodBeat.o(63006);
    return locala;
  }
  
  public static final class a
  {
    public String content;
    public long timestamp;
    public boolean wAw;
    
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