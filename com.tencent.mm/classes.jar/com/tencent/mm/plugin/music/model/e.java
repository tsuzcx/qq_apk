package com.tencent.mm.plugin.music.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.g.b;
import com.tencent.mm.model.aa;
import com.tencent.mm.plugin.music.a.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class e
{
  private boolean FRq;
  public ArrayList<a> FRr;
  private LinkedList<Long> FRs;
  private String FRt;
  private String FRu;
  private String FRv;
  private boolean FRw;
  private String album;
  private long offset;
  private String ozs;
  private String title;
  private int wzx;
  
  private e()
  {
    AppMethodBeat.i(63007);
    this.FRq = false;
    this.FRs = new LinkedList();
    this.FRr = new ArrayList();
    this.wzx = 0;
    this.FRw = false;
    AppMethodBeat.o(63007);
  }
  
  public static e a(String paramString1, String paramString2, String paramString3, boolean paramBoolean1, String paramString4, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(259935);
    e locale = new e();
    long l = Util.currentTicks();
    if (!Util.isNullOrNil(paramString1)) {
      if (paramString1 == null)
      {
        Log.w("MicroMsg.Music.LyricObj", "parserLrc: but lrc or lrcMgr is null");
        Log.d("MicroMsg.Music.LyricObj", "getLrcMgr beg: src lrc = %s", new Object[] { paramString1 });
        Log.d("MicroMsg.Music.LyricObj", "parse finish: sentence size [%d], result:", new Object[] { Integer.valueOf(locale.FRr.size()) });
        locale.FRq = true;
        if (paramBoolean3)
        {
          if (!Util.isNullOrNil(paramString3)) {
            break label1015;
          }
          Log.w("MicroMsg.Music.LyricObj", "add lyric prefix: but prefix is empty, return");
        }
        label102:
        if ((!Util.isNullOrNil(paramString1)) && (paramBoolean3))
        {
          if (!Util.isNullOrNil(paramString2)) {
            break label1174;
          }
          Log.w("MicroMsg.Music.LyricObj", "add lyric prefix: but prefix is empty, return");
        }
      }
    }
    for (;;)
    {
      Log.d("MicroMsg.Music.LyricObj", "getLrcMgr finish: use %d ms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
      AppMethodBeat.o(259935);
      return locale;
      paramString4 = paramString1.replaceAll("\n", " ").replaceAll("\r", " ");
      Matcher localMatcher1 = Pattern.compile("(\\[((\\d{2}:\\d{2}(\\.\\d{2}){0,1}\\])|(al:|ar:|by:|offset:|re:|ti:|ve:))[^\\[]*)").matcher(paramString4);
      while (localMatcher1.find())
      {
        String str = localMatcher1.group();
        localMatcher1.start();
        localMatcher1.end();
        if (str == null)
        {
          Log.w("MicroMsg.Music.LyricObj", "parserLine fail: lrcMgr or str is null");
        }
        else if (str.startsWith("[ti:"))
        {
          locale.title = ji(str, "[ti:");
        }
        else if (str.startsWith("[ar:"))
        {
          locale.ozs = ji(str, "[ar:");
        }
        else if (str.startsWith("[al:"))
        {
          locale.album = ji(str, "[al:");
        }
        else if (str.startsWith("[by:"))
        {
          locale.FRt = ji(str, "[by:");
        }
        else if (str.startsWith("[offset:"))
        {
          locale.offset = Util.getLong(ji(str, "[offset:"), 0L);
        }
        else if (str.startsWith("[re:"))
        {
          locale.FRu = ji(str, "[re:");
        }
        else if (str.startsWith("[ve:"))
        {
          locale.FRv = ji(str, "[ve:");
        }
        else
        {
          Pattern localPattern = Pattern.compile("\\[(\\d{2}:\\d{2}(\\.\\d{2}){0,1})\\]");
          Matcher localMatcher2 = localPattern.matcher(str);
          a locala = new a();
          for (;;)
          {
            label433:
            if (localMatcher2.find())
            {
              if (localMatcher2.groupCount() > 0) {
                locala.timestamp = aSe(localMatcher2.group(1));
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
                if (Util.isNullOrNil(paramString4)) {
                  localObject = " ";
                }
                locala.content = ((String)localObject);
                i = 0;
              }
              for (;;)
              {
                if (i < locale.FRs.size())
                {
                  paramString4 = new a();
                  paramString4.timestamp = ((Long)locale.FRs.get(i)).longValue();
                  paramString4.content = locala.content;
                  paramString4.FRx = true;
                  i += 1;
                  continue;
                  locale.FRs.add(Long.valueOf(locala.timestamp));
                  break;
                }
              }
              locale.FRs.clear();
              if (!locala.isEmpty()) {
                i = locale.FRr.size() - 1;
              }
            }
          }
          for (;;)
          {
            if ((i >= 0) && (((a)locale.FRr.get(i)).timestamp != locala.timestamp))
            {
              if (((a)locale.FRr.get(i)).timestamp < locala.timestamp) {
                locale.FRr.add(i + 1, locala);
              }
            }
            else
            {
              if (i >= 0) {
                break label433;
              }
              locale.FRr.add(0, locala);
              break label433;
              break;
            }
            i -= 1;
          }
        }
      }
      Log.d("MicroMsg.Music.LyricObj", "handle offset %d", new Object[] { Long.valueOf(locale.offset) });
      if (locale.offset != 0L)
      {
        i = 0;
        while (i < locale.FRr.size())
        {
          paramString4 = (a)locale.FRr.get(i);
          paramString4.timestamp += locale.offset;
          i += 1;
        }
        locale.offset = 0L;
      }
      int i = 0;
      while (i < locale.FRr.size() - 1)
      {
        paramString4 = (a)locale.FRr.get(i);
        if ((paramString4.FRx) && (paramString4.content.equals(((a)locale.FRr.get(i + 1)).content))) {
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
        if (((a)localObject).content != null) {
          locale.FRr.add(localObject);
        }
        locale.FRq = false;
        break;
        if (!paramBoolean1) {
          ((a)localObject).content = MMApplicationContext.getContext().getString(a.h.no_licence_lyric_wording);
        } else {
          ((a)localObject).content = "";
        }
      }
      label1015:
      paramString4 = new a();
      paramString4.timestamp = 0L;
      paramString4.content = MMApplicationContext.getContext().getString(a.h.user_share_music, new Object[] { aa.PJ(paramString3) });
      if (locale.FRr.isEmpty())
      {
        locale.FRr.add(paramString4);
        break label102;
      }
      if (locale.FRr.size() == 1)
      {
        locale.FRr.add(0, paramString4);
        ((a)locale.FRr.get(1)).timestamp = 5000L;
        break label102;
      }
      locale.FRr.add(0, paramString4);
      ((a)locale.FRr.get(1)).timestamp = (3L * (((a)locale.FRr.get(2)).timestamp >> 2));
      break label102;
      label1174:
      paramString1 = new a();
      paramString1.timestamp = 0L;
      paramString1.content = paramString2;
      if (locale.FRr.isEmpty())
      {
        locale.FRr.add(paramString1);
      }
      else if (locale.FRr.size() == 1)
      {
        locale.FRr.add(0, paramString1);
        ((a)locale.FRr.get(1)).timestamp = 5000L;
      }
      else
      {
        locale.FRr.add(0, paramString1);
        ((a)locale.FRr.get(1)).timestamp = (3L * (((a)locale.FRr.get(2)).timestamp >> 2));
      }
    }
  }
  
  private static long aSe(String paramString)
  {
    AppMethodBeat.i(63005);
    for (;;)
    {
      try
      {
        paramString = paramString.split(":");
        int k = m.df(paramString[0]);
        if (paramString.length <= 1) {
          break label145;
        }
        paramString = paramString[1].split("\\.");
        j = m.df(paramString[0]);
        if (paramString.length > 1)
        {
          i = m.df(paramString[1]);
          long l1 = k;
          long l2 = j * 1000;
          long l3 = i * 10;
          AppMethodBeat.o(63005);
          return l3 + (l2 + l1 * 60L * 1000L);
        }
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace("MicroMsg.Music.LyricObj", paramString, "", new Object[0]);
        Log.w("MicroMsg.Music.LyricObj", "strToLong error: %s", new Object[] { paramString.getLocalizedMessage() });
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
  
  private static String ji(String paramString1, String paramString2)
  {
    AppMethodBeat.i(63004);
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
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
    Log.d("MicroMsg.Music.LyricObj", "str[%s] prefix[%s] attr[%s]", new Object[] { paramString1, paramString2, str });
    AppMethodBeat.o(63004);
    return str;
  }
  
  public final int OF(long paramLong)
  {
    AppMethodBeat.i(259945);
    if (this.FRr.isEmpty())
    {
      Log.w("MicroMsg.Music.LyricObj", "getCurIndex: but sentence list is empty");
      AppMethodBeat.o(259945);
      return -1;
    }
    int j;
    int i;
    if (((a)this.FRr.get(this.wzx)).timestamp <= paramLong)
    {
      j = this.FRr.size() - 1;
      i = this.wzx;
      while (i < j)
      {
        if ((((a)this.FRr.get(i)).timestamp <= paramLong) && (paramLong < ((a)this.FRr.get(i + 1)).timestamp))
        {
          this.wzx = i;
          i = this.wzx;
          AppMethodBeat.o(259945);
          return i;
        }
        i += 1;
      }
    }
    for (this.wzx = j;; this.wzx = 0)
    {
      Log.d("MicroMsg.Music.LyricObj", "curIndex %d", new Object[] { Integer.valueOf(this.wzx) });
      i = this.wzx;
      AppMethodBeat.o(259945);
      return i;
      i = this.wzx;
      while (i > 0)
      {
        if ((((a)this.FRr.get(i)).timestamp >= paramLong) && (paramLong > ((a)this.FRr.get(i - 1)).timestamp))
        {
          this.wzx = (i - 1);
          i = this.wzx;
          AppMethodBeat.o(259945);
          return i;
        }
        i -= 1;
      }
    }
  }
  
  public final a Zm(int paramInt)
  {
    AppMethodBeat.i(63006);
    if ((paramInt < 0) || (paramInt >= this.FRr.size()))
    {
      AppMethodBeat.o(63006);
      return null;
    }
    a locala = (a)this.FRr.get(paramInt);
    AppMethodBeat.o(63006);
    return locala;
  }
  
  public final int feO()
  {
    AppMethodBeat.i(259943);
    int i = this.FRr.size();
    AppMethodBeat.o(259943);
    return i;
  }
  
  public static final class a
  {
    public boolean FRx;
    public String content;
    public long timestamp;
    
    public final boolean isEmpty()
    {
      AppMethodBeat.i(260304);
      boolean bool = b.fK(this.content.trim());
      AppMethodBeat.o(260304);
      return bool;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(63002);
      String str = String.format("[%d %s]", new Object[] { Long.valueOf(this.timestamp), this.content });
      AppMethodBeat.o(63002);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.e
 * JD-Core Version:    0.7.0.1
 */