package com.tencent.mm.plugin.story.e;

import android.content.Context;
import android.text.format.DateFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import d.g.b.p;
import d.l;
import d.n.n;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/data/StoryTimeUtil;", "", "()V", "Companion", "plugin-story_release"})
public final class a
{
  private static final long BaA = 3600000L;
  private static final long BaB = 86400000L;
  public static final a BaC;
  private static final long Bay = 1000L;
  private static final long Baz = 60000L;
  private static final String TAG = "MicroMsg.StoryTimeUtil";
  
  static
  {
    AppMethodBeat.i(118623);
    BaC = new a((byte)0);
    TAG = "MicroMsg.StoryTimeUtil";
    Bay = 1000L;
    Baz = Bay * 60L;
    BaA = Baz * 60L;
    BaB = 24L * BaA;
    AppMethodBeat.o(118623);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/data/StoryTimeUtil$Companion;", "", "()V", "MILLSECONDS_OF_DAY", "", "getMILLSECONDS_OF_DAY", "()J", "MILLSECONDS_OF_HOUR", "getMILLSECONDS_OF_HOUR", "MILLSECONDS_OF_MINUTE", "getMILLSECONDS_OF_MINUTE", "MILLSECONDS_OF_SECOND", "getMILLSECONDS_OF_SECOND", "TAG", "", "formatDateInGallery", "", "date", "formatDateInGrid", "formatDateToTimeSecond", "", "formatStoryCreateDate", "time", "formatTimeInGrid", "formatTimeSecondToDate", "(Ljava/lang/Integer;)Ljava/lang/String;", "formatTimeSecondToMD", "nowToYear", "plugin-story_release"})
  public static final class a
  {
    public static int Bd(long paramLong)
    {
      AppMethodBeat.i(118620);
      try
      {
        i = Integer.parseInt(DateFormat.format((CharSequence)ak.getContext().getString(2131764191), paramLong).toString());
        AppMethodBeat.o(118620);
        return i;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          ae.printErrStackTrace(a.access$getTAG$cp(), (Throwable)localNumberFormatException, "NumberFormatException", new Object[0]);
          int i = 0;
        }
      }
    }
    
    public static CharSequence aCP(String paramString)
    {
      AppMethodBeat.i(118618);
      p.h(paramString, "date");
      try
      {
        paramString = n.a((CharSequence)paramString, new String[] { "-" });
        l = new GregorianCalendar(Integer.parseInt((String)paramString.get(0)), Integer.parseInt((String)paramString.get(1)) - 1, Integer.parseInt((String)paramString.get(2))).getTimeInMillis();
        paramString = new GregorianCalendar();
        GregorianCalendar localGregorianCalendar = new GregorianCalendar();
        localGregorianCalendar.setTimeInMillis(l);
        if ((paramString.get(1) == localGregorianCalendar.get(1)) && (paramString.get(2) == localGregorianCalendar.get(2)))
        {
          paramString = ak.getContext().getString(2131764194);
          p.g(paramString, "MMApplicationContext.get…ry_album_date_this_month)");
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
          ae.printErrStackTrace(a.access$getTAG$cp(), (Throwable)paramString, paramString.getMessage(), new Object[0]);
          l = 0L;
        }
        new GregorianCalendar().setTimeInMillis(l);
        paramString = DateFormat.format((CharSequence)ak.getContext().getString(2131764193), l);
        p.g(paramString, "DateFormat.format(MMAppl…_album_date_split), time)");
        AppMethodBeat.o(118618);
      }
      return paramString;
    }
    
    public static CharSequence aCQ(String paramString)
    {
      AppMethodBeat.i(118619);
      p.h(paramString, "date");
      try
      {
        paramString = n.a((CharSequence)paramString, new String[] { "-" });
        l = new GregorianCalendar(Integer.parseInt((String)paramString.get(0)), Integer.parseInt((String)paramString.get(1)) - 1, Integer.parseInt((String)paramString.get(2))).getTimeInMillis();
        paramString = DateFormat.format((CharSequence)ak.getContext().getString(2131764272), l);
        p.g(paramString, "DateFormat.format(MMAppl…allery_date_split), time)");
        AppMethodBeat.o(118619);
        return paramString;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          ae.printErrStackTrace(a.access$getTAG$cp(), (Throwable)paramString, paramString.getMessage(), new Object[0]);
          long l = 0L;
        }
      }
    }
    
    public static int aCR(String paramString)
    {
      AppMethodBeat.i(118621);
      p.h(paramString, "date");
      paramString = new SimpleDateFormat("yyyy-MM-dd").parse(paramString);
      p.g(paramString, "simpleDateFormat.parse(date)");
      int i = (int)(paramString.getTime() / 1000L);
      AppMethodBeat.o(118621);
      return i;
    }
    
    public static String n(Integer paramInteger)
    {
      AppMethodBeat.i(118622);
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
      if (paramInteger != null) {}
      for (long l = paramInteger.intValue();; l = 0L)
      {
        paramInteger = localSimpleDateFormat.format(new Date(l * 1000L));
        p.g(paramInteger, "simpleDateFormat.format(date)");
        AppMethodBeat.o(118622);
        return paramInteger;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.e.a
 * JD-Core Version:    0.7.0.1
 */