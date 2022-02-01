package com.tencent.mm.plugin.story.e;

import android.content.Context;
import android.text.format.DateFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.a.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/data/StoryTimeUtil$Companion;", "", "()V", "MILLSECONDS_OF_DAY", "", "getMILLSECONDS_OF_DAY", "()J", "MILLSECONDS_OF_HOUR", "getMILLSECONDS_OF_HOUR", "MILLSECONDS_OF_MINUTE", "getMILLSECONDS_OF_MINUTE", "MILLSECONDS_OF_SECOND", "getMILLSECONDS_OF_SECOND", "TAG", "", "formatDateInGallery", "", "date", "formatDateInGrid", "formatDateToTimeSecond", "", "formatStoryCreateDate", "time", "formatTimeInGrid", "formatTimeSecondToDate", "(Ljava/lang/Integer;)Ljava/lang/String;", "formatTimeSecondToMD", "nowToYear", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$a
{
  public static String C(Integer paramInteger)
  {
    AppMethodBeat.i(118622);
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    if (paramInteger == null) {}
    for (long l = 0L;; l = paramInteger.intValue())
    {
      paramInteger = localSimpleDateFormat.format(new Date(l * 1000L));
      s.s(paramInteger, "simpleDateFormat.format(date)");
      AppMethodBeat.o(118622);
      return paramInteger;
    }
  }
  
  public static CharSequence bbD(String paramString)
  {
    AppMethodBeat.i(118618);
    s.u(paramString, "date");
    try
    {
      paramString = n.a((CharSequence)paramString, new String[] { "-" });
      l = new GregorianCalendar(Integer.parseInt((String)paramString.get(0)), Integer.parseInt((String)paramString.get(1)) - 1, Integer.parseInt((String)paramString.get(2))).getTimeInMillis();
      paramString = new GregorianCalendar();
      GregorianCalendar localGregorianCalendar = new GregorianCalendar();
      localGregorianCalendar.setTimeInMillis(l);
      if ((paramString.get(1) == localGregorianCalendar.get(1)) && (paramString.get(2) == localGregorianCalendar.get(2)))
      {
        paramString = MMApplicationContext.getContext().getString(a.g.Shh);
        s.s(paramString, "getContext().getString(R…ry_album_date_this_month)");
        paramString = (CharSequence)paramString;
        AppMethodBeat.o(118618);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      long l;
      for (;;)
      {
        Log.printErrStackTrace(a.access$getTAG$cp(), (Throwable)paramString, paramString.getMessage(), new Object[0]);
        l = 0L;
      }
      new GregorianCalendar().setTimeInMillis(l);
      paramString = DateFormat.format((CharSequence)MMApplicationContext.getContext().getString(a.g.Shg), l);
      s.s(paramString, "format(MMApplicationCont…_album_date_split), time)");
      AppMethodBeat.o(118618);
    }
    return paramString;
  }
  
  public static CharSequence bbE(String paramString)
  {
    AppMethodBeat.i(118619);
    s.u(paramString, "date");
    try
    {
      paramString = n.a((CharSequence)paramString, new String[] { "-" });
      l = new GregorianCalendar(Integer.parseInt((String)paramString.get(0)), Integer.parseInt((String)paramString.get(1)) - 1, Integer.parseInt((String)paramString.get(2))).getTimeInMillis();
      paramString = DateFormat.format((CharSequence)MMApplicationContext.getContext().getString(a.g.ShP), l);
      s.s(paramString, "format(MMApplicationCont…allery_date_split), time)");
      AppMethodBeat.o(118619);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.printErrStackTrace(a.access$getTAG$cp(), (Throwable)paramString, paramString.getMessage(), new Object[0]);
        long l = 0L;
      }
    }
  }
  
  public static int bbF(String paramString)
  {
    AppMethodBeat.i(118621);
    s.u(paramString, "date");
    int i = (int)(new SimpleDateFormat("yyyy-MM-dd").parse(paramString).getTime() / 1000L);
    AppMethodBeat.o(118621);
    return i;
  }
  
  public static int vL(long paramLong)
  {
    AppMethodBeat.i(118620);
    try
    {
      i = Integer.parseInt(DateFormat.format((CharSequence)MMApplicationContext.getContext().getString(a.g.Shf), paramLong).toString());
      AppMethodBeat.o(118620);
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        Log.printErrStackTrace(a.access$getTAG$cp(), (Throwable)localNumberFormatException, "NumberFormatException", new Object[0]);
        int i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.story.e.a.a
 * JD-Core Version:    0.7.0.1
 */