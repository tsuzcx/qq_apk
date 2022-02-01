package com.tencent.mm.plugin.music.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.f.c;
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
  private LinkedList<Long> Fas;
  private boolean LMl;
  public ArrayList<a> LMm;
  private String LMn;
  private String LMo;
  private String LMp;
  private boolean LMq;
  private String album;
  private long offset;
  private String rDl;
  private String title;
  private int zVI;
  
  private e()
  {
    AppMethodBeat.i(63007);
    this.LMl = false;
    this.Fas = new LinkedList();
    this.LMm = new ArrayList();
    this.zVI = 0;
    this.LMq = false;
    AppMethodBeat.o(63007);
  }
  
  public static e a(String paramString1, String paramString2, String paramString3, boolean paramBoolean1, String paramString4, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(271137);
    e locale = new e();
    long l = Util.currentTicks();
    if (!Util.isNullOrNil(paramString1)) {
      if (paramString1 == null)
      {
        Log.w("MicroMsg.Music.LyricObj", "parserLrc: but lrc or lrcMgr is null");
        Log.d("MicroMsg.Music.LyricObj", "getLrcMgr beg: src lrc = %s", new Object[] { paramString1 });
        Log.d("MicroMsg.Music.LyricObj", "parse finish: sentence size [%d], result:", new Object[] { Integer.valueOf(locale.LMm.size()) });
        locale.LMl = true;
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
      AppMethodBeat.o(271137);
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
          locale.title = kx(str, "[ti:");
        }
        else if (str.startsWith("[ar:"))
        {
          locale.rDl = kx(str, "[ar:");
        }
        else if (str.startsWith("[al:"))
        {
          locale.album = kx(str, "[al:");
        }
        else if (str.startsWith("[by:"))
        {
          locale.LMn = kx(str, "[by:");
        }
        else if (str.startsWith("[offset:"))
        {
          locale.offset = Util.getLong(kx(str, "[offset:"), 0L);
        }
        else if (str.startsWith("[re:"))
        {
          locale.LMo = kx(str, "[re:");
        }
        else if (str.startsWith("[ve:"))
        {
          locale.LMp = kx(str, "[ve:");
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
                locala.timestamp = aOW(localMatcher2.group(1));
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
                if (i < locale.Fas.size())
                {
                  paramString4 = new a();
                  paramString4.timestamp = ((Long)locale.Fas.get(i)).longValue();
                  paramString4.content = locala.content;
                  paramString4.LMr = true;
                  i += 1;
                  continue;
                  locale.Fas.add(Long.valueOf(locala.timestamp));
                  break;
                }
              }
              locale.Fas.clear();
              if (!locala.isEmpty()) {
                i = locale.LMm.size() - 1;
              }
            }
          }
          for (;;)
          {
            if ((i >= 0) && (((a)locale.LMm.get(i)).timestamp != locala.timestamp))
            {
              if (((a)locale.LMm.get(i)).timestamp < locala.timestamp) {
                locale.LMm.add(i + 1, locala);
              }
            }
            else
            {
              if (i >= 0) {
                break label433;
              }
              locale.LMm.add(0, locala);
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
        while (i < locale.LMm.size())
        {
          paramString4 = (a)locale.LMm.get(i);
          paramString4.timestamp += locale.offset;
          i += 1;
        }
        locale.offset = 0L;
      }
      int i = 0;
      while (i < locale.LMm.size() - 1)
      {
        paramString4 = (a)locale.LMm.get(i);
        if ((paramString4.LMr) && (paramString4.content.equals(((a)locale.LMm.get(i + 1)).content))) {
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
          locale.LMm.add(localObject);
        }
        locale.LMl = false;
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
      paramString4.content = MMApplicationContext.getContext().getString(a.h.user_share_music, new Object[] { aa.getDisplayName(paramString3) });
      if (locale.LMm.isEmpty())
      {
        locale.LMm.add(paramString4);
        break label102;
      }
      if (locale.LMm.size() == 1)
      {
        locale.LMm.add(0, paramString4);
        ((a)locale.LMm.get(1)).timestamp = 5000L;
        break label102;
      }
      locale.LMm.add(0, paramString4);
      ((a)locale.LMm.get(1)).timestamp = (3L * (((a)locale.LMm.get(2)).timestamp >> 2));
      break label102;
      label1174:
      paramString1 = new a();
      paramString1.timestamp = 0L;
      paramString1.content = paramString2;
      if (locale.LMm.isEmpty())
      {
        locale.LMm.add(paramString1);
      }
      else if (locale.LMm.size() == 1)
      {
        locale.LMm.add(0, paramString1);
        ((a)locale.LMm.get(1)).timestamp = 5000L;
      }
      else
      {
        locale.LMm.add(0, paramString1);
        ((a)locale.LMm.get(1)).timestamp = (3L * (((a)locale.LMm.get(2)).timestamp >> 2));
      }
    }
  }
  
  private static long aOW(String paramString)
  {
    AppMethodBeat.i(63005);
    for (;;)
    {
      try
      {
        paramString = paramString.split(":");
        int k = m.ew(paramString[0]);
        if (paramString.length <= 1) {
          break label145;
        }
        paramString = paramString[1].split("\\.");
        j = m.ew(paramString[0]);
        if (paramString.length > 1)
        {
          i = m.ew(paramString[1]);
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
  
  private static String kx(String paramString1, String paramString2)
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
  
  public final a adz(int paramInt)
  {
    AppMethodBeat.i(63006);
    if ((paramInt < 0) || (paramInt >= this.LMm.size()))
    {
      AppMethodBeat.o(63006);
      return null;
    }
    a locala = (a)this.LMm.get(paramInt);
    AppMethodBeat.o(63006);
    return locala;
  }
  
  public final int sC(long paramLong)
  {
    AppMethodBeat.i(271176);
    if (this.LMm.isEmpty())
    {
      Log.w("MicroMsg.Music.LyricObj", "getCurIndex: but sentence list is empty");
      AppMethodBeat.o(271176);
      return -1;
    }
    int j;
    int i;
    if (((a)this.LMm.get(this.zVI)).timestamp <= paramLong)
    {
      j = this.LMm.size() - 1;
      i = this.zVI;
      while (i < j)
      {
        if ((((a)this.LMm.get(i)).timestamp <= paramLong) && (paramLong < ((a)this.LMm.get(i + 1)).timestamp))
        {
          this.zVI = i;
          i = this.zVI;
          AppMethodBeat.o(271176);
          return i;
        }
        i += 1;
      }
    }
    for (this.zVI = j;; this.zVI = 0)
    {
      Log.d("MicroMsg.Music.LyricObj", "curIndex %d", new Object[] { Integer.valueOf(this.zVI) });
      i = this.zVI;
      AppMethodBeat.o(271176);
      return i;
      i = this.zVI;
      while (i > 0)
      {
        if ((((a)this.LMm.get(i)).timestamp >= paramLong) && (paramLong > ((a)this.LMm.get(i - 1)).timestamp))
        {
          this.zVI = (i - 1);
          i = this.zVI;
          AppMethodBeat.o(271176);
          return i;
        }
        i -= 1;
      }
    }
  }
  
  public static final class a
  {
    public boolean LMr;
    public String content;
    public long timestamp;
    
    public final boolean isEmpty()
    {
      AppMethodBeat.i(271104);
      boolean bool = c.hm(this.content.trim());
      AppMethodBeat.o(271104);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.e
 * JD-Core Version:    0.7.0.1
 */