package com.tencent.mm.plugin.music.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class b
{
  private String album;
  private int gPA;
  private String kbK;
  private long offset;
  private String title;
  public ArrayList<a> vfm;
  private LinkedList<Long> vfn;
  private String vfo;
  private String vfp;
  private String vfq;
  private boolean vfr;
  
  private b()
  {
    AppMethodBeat.i(63007);
    this.vfn = new LinkedList();
    this.vfm = new ArrayList();
    this.gPA = 0;
    this.vfr = false;
    AppMethodBeat.o(63007);
  }
  
  public static b a(String paramString1, String paramString2, String paramString3, boolean paramBoolean1, String paramString4, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(195609);
    b localb = new b();
    long l = bs.Gn();
    if (!bs.isNullOrNil(paramString1)) {
      if (paramString1 == null)
      {
        ac.w("MicroMsg.Music.LyricObj", "parserLrc: but lrc or lrcMgr is null");
        ac.d("MicroMsg.Music.LyricObj", "getLrcMgr beg: src lrc = %s", new Object[] { paramString1 });
        ac.d("MicroMsg.Music.LyricObj", "parse finish: sentence size [%d], result:", new Object[] { Integer.valueOf(localb.vfm.size()) });
        label77:
        if (paramBoolean3)
        {
          if (!bs.isNullOrNil(paramString3)) {
            break label1000;
          }
          ac.w("MicroMsg.Music.LyricObj", "add lyric prefix: but prefix is empty, return");
        }
        label96:
        if ((!bs.isNullOrNil(paramString1)) && (paramBoolean3))
        {
          if (!bs.isNullOrNil(paramString2)) {
            break label1159;
          }
          ac.w("MicroMsg.Music.LyricObj", "add lyric prefix: but prefix is empty, return");
        }
      }
    }
    for (;;)
    {
      ac.d("MicroMsg.Music.LyricObj", "getLrcMgr finish: use %d ms", new Object[] { Long.valueOf(bs.aO(l)) });
      AppMethodBeat.o(195609);
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
          ac.w("MicroMsg.Music.LyricObj", "parserLine fail: lrcMgr or str is null");
        }
        else if (str.startsWith("[ti:"))
        {
          localb.title = hX(str, "[ti:");
        }
        else if (str.startsWith("[ar:"))
        {
          localb.kbK = hX(str, "[ar:");
        }
        else if (str.startsWith("[al:"))
        {
          localb.album = hX(str, "[al:");
        }
        else if (str.startsWith("[by:"))
        {
          localb.vfo = hX(str, "[by:");
        }
        else if (str.startsWith("[offset:"))
        {
          localb.offset = bs.getLong(hX(str, "[offset:"), 0L);
        }
        else if (str.startsWith("[re:"))
        {
          localb.vfp = hX(str, "[re:");
        }
        else if (str.startsWith("[ve:"))
        {
          localb.vfq = hX(str, "[ve:");
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
              locala.timestamp = anE(localMatcher2.group(1));
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
              if (bs.isNullOrNil(paramString4)) {
                localObject = " ";
              }
              locala.content = ((String)localObject);
              i = 0;
            }
            for (;;)
            {
              if (i < localb.vfn.size())
              {
                paramString4 = new a();
                paramString4.timestamp = ((Long)localb.vfn.get(i)).longValue();
                paramString4.content = locala.content;
                paramString4.vfs = true;
                i += 1;
                continue;
                localb.vfn.add(Long.valueOf(locala.timestamp));
                break;
              }
            }
            localb.vfn.clear();
            i = localb.vfm.size() - 1;
          }
          for (;;)
          {
            if ((i >= 0) && (((a)localb.vfm.get(i)).timestamp != locala.timestamp))
            {
              if (((a)localb.vfm.get(i)).timestamp < locala.timestamp) {
                localb.vfm.add(i + 1, locala);
              }
            }
            else
            {
              if (i >= 0) {
                break label427;
              }
              localb.vfm.add(0, locala);
              break label427;
              break;
            }
            i -= 1;
          }
        }
      }
      ac.d("MicroMsg.Music.LyricObj", "handle offset %d", new Object[] { Long.valueOf(localb.offset) });
      if (localb.offset != 0L)
      {
        i = 0;
        while (i < localb.vfm.size())
        {
          paramString4 = (a)localb.vfm.get(i);
          paramString4.timestamp += localb.offset;
          i += 1;
        }
        localb.offset = 0L;
      }
      int i = 0;
      while (i < localb.vfm.size() - 1)
      {
        paramString4 = (a)localb.vfm.get(i);
        if ((paramString4.vfs) && (paramString4.content.equals(((a)localb.vfm.get(i + 1)).content))) {
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
        localb.vfm.add(localObject);
        break;
        if (!paramBoolean1) {
          ((a)localObject).content = ai.getContext().getString(2131761621);
        } else {
          ((a)localObject).content = ai.getContext().getString(2131761622);
        }
      }
      label998:
      break label77;
      label1000:
      paramString4 = new a();
      paramString4.timestamp = 0L;
      paramString4.content = ai.getContext().getString(2131764617, new Object[] { v.wk(paramString3) });
      if (localb.vfm.isEmpty())
      {
        localb.vfm.add(paramString4);
        break label96;
      }
      if (localb.vfm.size() == 1)
      {
        localb.vfm.add(0, paramString4);
        ((a)localb.vfm.get(1)).timestamp = 5000L;
        break label96;
      }
      localb.vfm.add(0, paramString4);
      ((a)localb.vfm.get(1)).timestamp = (3L * (((a)localb.vfm.get(2)).timestamp >> 2));
      break label96;
      label1159:
      paramString1 = new a();
      paramString1.timestamp = 0L;
      paramString1.content = paramString2;
      if (localb.vfm.isEmpty())
      {
        localb.vfm.add(paramString1);
      }
      else if (localb.vfm.size() == 1)
      {
        localb.vfm.add(0, paramString1);
        ((a)localb.vfm.get(1)).timestamp = 5000L;
      }
      else
      {
        localb.vfm.add(0, paramString1);
        ((a)localb.vfm.get(1)).timestamp = (3L * (((a)localb.vfm.get(2)).timestamp >> 2));
      }
    }
  }
  
  private static long anE(String paramString)
  {
    AppMethodBeat.i(63005);
    for (;;)
    {
      try
      {
        paramString = paramString.split(":");
        int k = e.ee(paramString[0]);
        if (paramString.length <= 1) {
          break label145;
        }
        paramString = paramString[1].split("\\.");
        j = e.ee(paramString[0]);
        if (paramString.length > 1)
        {
          i = e.ee(paramString[1]);
          long l1 = k;
          long l2 = j * 1000;
          long l3 = i * 10;
          AppMethodBeat.o(63005);
          return l3 + (l2 + l1 * 60L * 1000L);
        }
      }
      catch (Exception paramString)
      {
        ac.printErrStackTrace("MicroMsg.Music.LyricObj", paramString, "", new Object[0]);
        ac.w("MicroMsg.Music.LyricObj", "strToLong error: %s", new Object[] { paramString.getLocalizedMessage() });
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
  
  private static String hX(String paramString1, String paramString2)
  {
    AppMethodBeat.i(63004);
    if ((bs.isNullOrNil(paramString1)) || (bs.isNullOrNil(paramString2)))
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
    ac.d("MicroMsg.Music.LyricObj", "str[%s] prefix[%s] attr[%s]", new Object[] { paramString1, paramString2, str });
    AppMethodBeat.o(63004);
    return str;
  }
  
  public final a JM(int paramInt)
  {
    AppMethodBeat.i(63006);
    if ((paramInt < 0) || (paramInt >= this.vfm.size()))
    {
      AppMethodBeat.o(63006);
      return null;
    }
    a locala = (a)this.vfm.get(paramInt);
    AppMethodBeat.o(63006);
    return locala;
  }
  
  public static final class a
  {
    public String content;
    public long timestamp;
    public boolean vfs;
    
    public final String toString()
    {
      AppMethodBeat.i(63002);
      String str = String.format("[%d %s]", new Object[] { Long.valueOf(this.timestamp), this.content });
      AppMethodBeat.o(63002);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.b
 * JD-Core Version:    0.7.0.1
 */