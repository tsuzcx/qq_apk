package com.tencent.mm.plugin.music.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.s;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a
{
  private String album;
  private int eSO;
  private String hBK;
  public ArrayList<a.a> oZq;
  private LinkedList<Long> oZr;
  private String oZs;
  private String oZt;
  private String oZu;
  private boolean oZv;
  private long offset;
  private String title;
  
  private a()
  {
    AppMethodBeat.i(104875);
    this.oZr = new LinkedList();
    this.oZq = new ArrayList();
    this.eSO = 0;
    this.oZv = false;
    AppMethodBeat.o(104875);
  }
  
  private static long Vw(String paramString)
  {
    AppMethodBeat.i(104873);
    for (;;)
    {
      try
      {
        paramString = paramString.split(":");
        int k = d.lT(paramString[0]);
        if (paramString.length <= 1) {
          break label138;
        }
        paramString = paramString[1].split("\\.");
        j = d.lT(paramString[0]);
        if (paramString.length > 1)
        {
          i = d.lT(paramString[1]);
          long l1 = k;
          long l2 = j * 1000;
          long l3 = i * 10;
          AppMethodBeat.o(104873);
          return l3 + (l2 + l1 * 60L * 1000L);
        }
      }
      catch (Exception paramString)
      {
        ab.printErrStackTrace("MicroMsg.Music.LyricObj", paramString, "", new Object[0]);
        ab.w("MicroMsg.Music.LyricObj", "strToLong error: %s", new Object[] { paramString.getLocalizedMessage() });
        AppMethodBeat.o(104873);
        return 0L;
      }
      int i = 0;
      continue;
      label138:
      i = 0;
      int j = 0;
    }
  }
  
  public static a a(String paramString1, String paramString2, String paramString3, boolean paramBoolean1, String paramString4, boolean paramBoolean2)
  {
    AppMethodBeat.i(104871);
    a locala = new a();
    long l = bo.yB();
    if (!bo.isNullOrNil(paramString1)) {
      if (paramString1 == null)
      {
        ab.w("MicroMsg.Music.LyricObj", "parserLrc: but lrc or lrcMgr is null");
        ab.d("MicroMsg.Music.LyricObj", "getLrcMgr beg: src lrc = %s", new Object[] { paramString1 });
        ab.d("MicroMsg.Music.LyricObj", "parse finish: sentence size [%d], result:", new Object[] { Integer.valueOf(locala.oZq.size()) });
        label77:
        if (!bo.isNullOrNil(paramString3)) {
          break label992;
        }
        ab.w("MicroMsg.Music.LyricObj", "add lyric prefix: but prefix is empty, return");
        label91:
        if (!bo.isNullOrNil(paramString1))
        {
          if (!bo.isNullOrNil(paramString2)) {
            break label1151;
          }
          ab.w("MicroMsg.Music.LyricObj", "add lyric prefix: but prefix is empty, return");
        }
      }
    }
    for (;;)
    {
      ab.d("MicroMsg.Music.LyricObj", "getLrcMgr finish: use %d ms", new Object[] { Long.valueOf(bo.av(l)) });
      AppMethodBeat.o(104871);
      return locala;
      paramString4 = paramString1.replaceAll("\n", " ").replaceAll("\r", " ");
      Matcher localMatcher1 = Pattern.compile("(\\[((\\d{2}:\\d{2}(\\.\\d{2}){0,1}\\])|(al:|ar:|by:|offset:|re:|ti:|ve:))[^\\[]*)").matcher(paramString4);
      while (localMatcher1.find())
      {
        String str = localMatcher1.group();
        localMatcher1.start();
        localMatcher1.end();
        if (str == null)
        {
          ab.w("MicroMsg.Music.LyricObj", "parserLine fail: lrcMgr or str is null");
        }
        else if (str.startsWith("[ti:"))
        {
          locala.title = fy(str, "[ti:");
        }
        else if (str.startsWith("[ar:"))
        {
          locala.hBK = fy(str, "[ar:");
        }
        else if (str.startsWith("[al:"))
        {
          locala.album = fy(str, "[al:");
        }
        else if (str.startsWith("[by:"))
        {
          locala.oZs = fy(str, "[by:");
        }
        else if (str.startsWith("[offset:"))
        {
          locala.offset = bo.getLong(fy(str, "[offset:"), 0L);
        }
        else if (str.startsWith("[re:"))
        {
          locala.oZt = fy(str, "[re:");
        }
        else if (str.startsWith("[ve:"))
        {
          locala.oZu = fy(str, "[ve:");
        }
        else
        {
          Pattern localPattern = Pattern.compile("\\[(\\d{2}:\\d{2}(\\.\\d{2}){0,1})\\]");
          Matcher localMatcher2 = localPattern.matcher(str);
          a.a locala1 = new a.a();
          label417:
          if (localMatcher2.find())
          {
            if (localMatcher2.groupCount() > 0) {
              locala1.timestamp = Vw(localMatcher2.group(1));
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
              if (bo.isNullOrNil(paramString4)) {
                localObject = " ";
              }
              locala1.content = ((String)localObject);
              i = 0;
            }
            for (;;)
            {
              if (i < locala.oZr.size())
              {
                paramString4 = new a.a();
                paramString4.timestamp = ((Long)locala.oZr.get(i)).longValue();
                paramString4.content = locala1.content;
                paramString4.oZw = true;
                i += 1;
                continue;
                locala.oZr.add(Long.valueOf(locala1.timestamp));
                break;
              }
            }
            locala.oZr.clear();
            i = locala.oZq.size() - 1;
          }
          for (;;)
          {
            if ((i >= 0) && (((a.a)locala.oZq.get(i)).timestamp != locala1.timestamp))
            {
              if (((a.a)locala.oZq.get(i)).timestamp < locala1.timestamp) {
                locala.oZq.add(i + 1, locala1);
              }
            }
            else
            {
              if (i >= 0) {
                break label417;
              }
              locala.oZq.add(0, locala1);
              break label417;
              break;
            }
            i -= 1;
          }
        }
      }
      ab.d("MicroMsg.Music.LyricObj", "handle offset %d", new Object[] { Long.valueOf(locala.offset) });
      if (locala.offset != 0L)
      {
        i = 0;
        while (i < locala.oZq.size())
        {
          paramString4 = (a.a)locala.oZq.get(i);
          paramString4.timestamp += locala.offset;
          i += 1;
        }
        locala.offset = 0L;
      }
      int i = 0;
      while (i < locala.oZq.size() - 1)
      {
        paramString4 = (a.a)locala.oZq.get(i);
        if ((paramString4.oZw) && (paramString4.content.equals(((a.a)locala.oZq.get(i + 1)).content))) {
          paramString4.content = " ";
        }
        i += 1;
      }
      break;
      Object localObject = new a.a();
      ((a.a)localObject).timestamp = 0L;
      if (paramBoolean2) {
        ((a.a)localObject).content = paramString4;
      }
      for (;;)
      {
        if (((a.a)localObject).content == null) {
          break label990;
        }
        locala.oZq.add(localObject);
        break;
        if (!paramBoolean1) {
          ((a.a)localObject).content = ah.getContext().getString(2131301861);
        } else {
          ((a.a)localObject).content = ah.getContext().getString(2131301862);
        }
      }
      label990:
      break label77;
      label992:
      paramString4 = new a.a();
      paramString4.timestamp = 0L;
      paramString4.content = ah.getContext().getString(2131304463, new Object[] { s.nE(paramString3) });
      if (locala.oZq.isEmpty())
      {
        locala.oZq.add(paramString4);
        break label91;
      }
      if (locala.oZq.size() == 1)
      {
        locala.oZq.add(0, paramString4);
        ((a.a)locala.oZq.get(1)).timestamp = 5000L;
        break label91;
      }
      locala.oZq.add(0, paramString4);
      ((a.a)locala.oZq.get(1)).timestamp = (3L * (((a.a)locala.oZq.get(2)).timestamp >> 2));
      break label91;
      label1151:
      paramString1 = new a.a();
      paramString1.timestamp = 0L;
      paramString1.content = paramString2;
      if (locala.oZq.isEmpty())
      {
        locala.oZq.add(paramString1);
      }
      else if (locala.oZq.size() == 1)
      {
        locala.oZq.add(0, paramString1);
        ((a.a)locala.oZq.get(1)).timestamp = 5000L;
      }
      else
      {
        locala.oZq.add(0, paramString1);
        ((a.a)locala.oZq.get(1)).timestamp = (3L * (((a.a)locala.oZq.get(2)).timestamp >> 2));
      }
    }
  }
  
  private static String fy(String paramString1, String paramString2)
  {
    AppMethodBeat.i(104872);
    if ((bo.isNullOrNil(paramString1)) || (bo.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(104872);
      return paramString1;
    }
    if (paramString2.length() >= paramString1.length() - 1)
    {
      AppMethodBeat.o(104872);
      return "";
    }
    String str = paramString1.substring(paramString2.length(), paramString1.length() - 1);
    ab.d("MicroMsg.Music.LyricObj", "str[%s] prefix[%s] attr[%s]", new Object[] { paramString1, paramString2, str });
    AppMethodBeat.o(104872);
    return str;
  }
  
  public final a.a Aj(int paramInt)
  {
    AppMethodBeat.i(104874);
    if ((paramInt < 0) || (paramInt >= this.oZq.size()))
    {
      AppMethodBeat.o(104874);
      return null;
    }
    a.a locala = (a.a)this.oZq.get(paramInt);
    AppMethodBeat.o(104874);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.a
 * JD-Core Version:    0.7.0.1
 */