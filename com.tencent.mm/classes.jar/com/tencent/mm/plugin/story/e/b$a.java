package com.tencent.mm.plugin.story.e;

import a.f.b.j;
import a.l;
import a.l.m;
import android.content.Context;
import android.text.format.DateFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/data/StoryTimeUtil$Companion;", "", "()V", "MILLSECONDS_OF_DAY", "", "getMILLSECONDS_OF_DAY", "()J", "MILLSECONDS_OF_HOUR", "getMILLSECONDS_OF_HOUR", "MILLSECONDS_OF_MINUTE", "getMILLSECONDS_OF_MINUTE", "MILLSECONDS_OF_SECOND", "getMILLSECONDS_OF_SECOND", "TAG", "", "formatDateInGallery", "", "date", "formatDateInGrid", "formatDateToTimeSecond", "", "formatStoryCreateDate", "time", "formatTimeInGrid", "formatTimeSecondToDate", "(Ljava/lang/Integer;)Ljava/lang/String;", "formatTimeSecondToMD", "nowToYear", "plugin-story_release"})
public final class b$a
{
  public static CharSequence acJ(String paramString)
  {
    AppMethodBeat.i(108988);
    j.q(paramString, "date");
    try
    {
      paramString = m.a((CharSequence)paramString, new String[] { "-" });
      l = new GregorianCalendar(Integer.parseInt((String)paramString.get(0)), Integer.parseInt((String)paramString.get(1)) - 1, Integer.parseInt((String)paramString.get(2))).getTimeInMillis();
      paramString = new GregorianCalendar();
      GregorianCalendar localGregorianCalendar = new GregorianCalendar();
      localGregorianCalendar.setTimeInMillis(l);
      if ((paramString.get(1) == localGregorianCalendar.get(1)) && (paramString.get(2) == localGregorianCalendar.get(2)))
      {
        paramString = ah.getContext().getString(2131304100);
        j.p(paramString, "MMApplicationContext.get…ry_album_date_this_month)");
        paramString = (CharSequence)paramString;
        AppMethodBeat.o(108988);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      long l;
      for (;;)
      {
        ab.printErrStackTrace(b.access$getTAG$cp(), (Throwable)paramString, paramString.getMessage(), new Object[0]);
        l = 0L;
      }
      new GregorianCalendar().setTimeInMillis(l);
      paramString = DateFormat.format((CharSequence)ah.getContext().getString(2131304099), l);
      j.p(paramString, "DateFormat.format(MMAppl…_album_date_split), time)");
      AppMethodBeat.o(108988);
    }
    return paramString;
  }
  
  public static CharSequence acK(String paramString)
  {
    AppMethodBeat.i(138746);
    j.q(paramString, "date");
    try
    {
      paramString = m.a((CharSequence)paramString, new String[] { "-" });
      l = new GregorianCalendar(Integer.parseInt((String)paramString.get(0)), Integer.parseInt((String)paramString.get(1)) - 1, Integer.parseInt((String)paramString.get(2))).getTimeInMillis();
      paramString = DateFormat.format((CharSequence)ah.getContext().getString(2131304164), l);
      j.p(paramString, "DateFormat.format(MMAppl…allery_date_split), time)");
      AppMethodBeat.o(138746);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ab.printErrStackTrace(b.access$getTAG$cp(), (Throwable)paramString, paramString.getMessage(), new Object[0]);
        long l = 0L;
      }
    }
  }
  
  public static int acL(String paramString)
  {
    AppMethodBeat.i(108990);
    j.q(paramString, "date");
    paramString = new SimpleDateFormat("yyyy-MM-dd").parse(paramString);
    j.p(paramString, "simpleDateFormat.parse(date)");
    int i = (int)(paramString.getTime() / 1000L);
    AppMethodBeat.o(108990);
    return i;
  }
  
  public static String i(Integer paramInteger)
  {
    AppMethodBeat.i(108991);
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    if (paramInteger != null) {}
    for (long l = paramInteger.intValue();; l = 0L)
    {
      paramInteger = localSimpleDateFormat.format(new Date(l * 1000L));
      j.p(paramInteger, "simpleDateFormat.format(date)");
      AppMethodBeat.o(108991);
      return paramInteger;
    }
  }
  
  public static int mt(long paramLong)
  {
    AppMethodBeat.i(108989);
    try
    {
      i = Integer.parseInt(DateFormat.format((CharSequence)ah.getContext().getString(2131304097), paramLong).toString());
      AppMethodBeat.o(108989);
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        ab.printErrStackTrace(b.access$getTAG$cp(), (Throwable)localNumberFormatException, "NumberFormatException", new Object[0]);
        int i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.e.b.a
 * JD-Core Version:    0.7.0.1
 */