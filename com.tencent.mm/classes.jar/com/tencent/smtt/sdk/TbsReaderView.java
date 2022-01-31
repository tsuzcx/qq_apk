package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.a.d;
import com.tencent.smtt.utils.Apn;

public class TbsReaderView
  extends FrameLayout
{
  public static final String IS_BAR_ANIMATING = "is_bar_animating";
  public static final String IS_BAR_SHOWING = "is_bar_show";
  public static final String IS_INTO_DOWNLOADING = "into_downloading";
  public static final String KEY_FILE_PATH = "filePath";
  public static final String KEY_TEMP_PATH = "tempPath";
  public static final int READER_CHANNEL_DOC_ID = 10965;
  public static final int READER_CHANNEL_PDF_ID = 10834;
  public static final int READER_CHANNEL_PPT_ID = 10833;
  public static final int READER_CHANNEL_TXT_ID = 10835;
  public static final String READER_STATISTICS_COUNT_CANCEL_LOADED_BTN = "AHNG802";
  public static final String READER_STATISTICS_COUNT_CLICK_LOADED_BTN = "AHNG801";
  public static final String READER_STATISTICS_COUNT_DOC_INTO_BROWSER = "AHNG829";
  public static final String READER_STATISTICS_COUNT_DOC_INTO_DIALOG = "AHNG827";
  public static final String READER_STATISTICS_COUNT_DOC_INTO_DOWNLOAD = "AHNG828";
  public static final String READER_STATISTICS_COUNT_DOC_SEARCH_BTN = "AHNG826";
  public static final String READER_STATISTICS_COUNT_PDF_FOLDER_BTN = "AHNG810";
  public static final String READER_STATISTICS_COUNT_PDF_INTO_BROWSER = "AHNG813";
  public static final String READER_STATISTICS_COUNT_PDF_INTO_DIALOG = "AHNG811";
  public static final String READER_STATISTICS_COUNT_PDF_INTO_DOWNLOAD = "AHNG812";
  public static final String READER_STATISTICS_COUNT_PPT_INTO_BROWSER = "AHNG809";
  public static final String READER_STATISTICS_COUNT_PPT_INTO_DIALOG = "AHNG807";
  public static final String READER_STATISTICS_COUNT_PPT_INTO_DOWNLOAD = "AHNG808";
  public static final String READER_STATISTICS_COUNT_PPT_PLAY_BTN = "AHNG806";
  public static final String READER_STATISTICS_COUNT_RETRY_BTN = "AHNG803";
  public static final String READER_STATISTICS_COUNT_TXT_INTO_BROWSER = "AHNG817";
  public static final String READER_STATISTICS_COUNT_TXT_INTO_DIALOG = "AHNG815";
  public static final String READER_STATISTICS_COUNT_TXT_INTO_DOWNLOAD = "AHNG816";
  public static final String READER_STATISTICS_COUNT_TXT_NOVEL_BTN = "AHNG814";
  public static final String TAG = "TbsReaderView";
  static boolean f = false;
  public static String gReaderPackName = "";
  public static String gReaderPackVersion = "";
  Context a;
  ReaderWizard b;
  Object c;
  TbsReaderView.ReaderCallback d;
  TbsReaderView.ReaderCallback e;
  
  public TbsReaderView(Context paramContext, TbsReaderView.ReaderCallback paramReaderCallback)
  {
    super(paramContext.getApplicationContext());
    AppMethodBeat.i(64554);
    this.a = null;
    this.b = null;
    this.c = null;
    this.d = null;
    this.e = null;
    if (!(paramContext instanceof Activity))
    {
      paramContext = new RuntimeException("error: unexpect context(none Activity)");
      AppMethodBeat.o(64554);
      throw paramContext;
    }
    this.d = paramReaderCallback;
    this.a = paramContext;
    this.e = new be(this);
    AppMethodBeat.o(64554);
  }
  
  static boolean a(Context paramContext)
  {
    AppMethodBeat.i(64555);
    if (!f)
    {
      o.a(true).a(paramContext.getApplicationContext(), true, false, null);
      f = o.a(false).b();
    }
    boolean bool = f;
    AppMethodBeat.o(64555);
    return bool;
  }
  
  public static Drawable getResDrawable(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(64559);
    Drawable localDrawable = null;
    if (a(paramContext)) {
      localDrawable = ReaderWizard.getResDrawable(paramInt);
    }
    AppMethodBeat.o(64559);
    return localDrawable;
  }
  
  public static String getResString(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(64560);
    String str = "";
    if (a(paramContext)) {
      str = ReaderWizard.getResString(paramInt);
    }
    AppMethodBeat.o(64560);
    return str;
  }
  
  public static boolean isSupportExt(Context paramContext, String paramString)
  {
    boolean bool2 = false;
    AppMethodBeat.i(64556);
    boolean bool1 = bool2;
    if (a(paramContext))
    {
      bool1 = bool2;
      if (ReaderWizard.isSupportCurrentPlatform(paramContext))
      {
        bool1 = bool2;
        if (ReaderWizard.isSupportExt(paramString)) {
          bool1 = true;
        }
      }
    }
    AppMethodBeat.o(64556);
    return bool1;
  }
  
  boolean a()
  {
    bool2 = false;
    AppMethodBeat.i(64566);
    try
    {
      if (this.b == null) {
        this.b = new ReaderWizard(this.e);
      }
      if (this.c == null) {
        this.c = this.b.getTbsReader();
      }
      bool1 = bool2;
      if (this.c != null) {
        bool1 = this.b.initTbsReader(this.c, this.a);
      }
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        boolean bool1 = bool2;
      }
    }
    AppMethodBeat.o(64566);
    return bool1;
  }
  
  public void doCommand(Integer paramInteger, Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(64562);
    if ((this.b != null) && (this.c != null)) {
      this.b.doCommand(this.c, paramInteger, paramObject1, paramObject2);
    }
    AppMethodBeat.o(64562);
  }
  
  public boolean downloadPlugin(String paramString)
  {
    AppMethodBeat.i(64558);
    if (this.c == null)
    {
      AppMethodBeat.o(64558);
      return false;
    }
    boolean bool = this.b.checkPlugin(this.c, this.a, paramString, true);
    AppMethodBeat.o(64558);
    return bool;
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(64563);
    if ((this.b != null) && (this.c != null)) {
      this.b.onSizeChanged(this.c, paramInt1, paramInt2);
    }
    AppMethodBeat.o(64563);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(64564);
    if (this.b != null)
    {
      this.b.destroy(this.c);
      this.c = null;
    }
    this.a = null;
    f = false;
    AppMethodBeat.o(64564);
  }
  
  public void openFile(Bundle paramBundle)
  {
    boolean bool2 = true;
    AppMethodBeat.i(64561);
    if ((this.c == null) || (paramBundle == null))
    {
      AppMethodBeat.o(64561);
      return;
    }
    boolean bool3 = d.c(this.a);
    if (!d.b(this.a))
    {
      bool1 = true;
      paramBundle.putBoolean("browser6.0", bool1 | bool3);
      bool3 = d.a(this.a, 6101625L, 610000L);
      if (d.b(this.a)) {
        break label122;
      }
    }
    label122:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramBundle.putBoolean("browser6.1", bool3 | bool1);
      this.b.openFile(this.c, this.a, paramBundle, this);
      AppMethodBeat.o(64561);
      return;
      bool1 = false;
      break;
    }
  }
  
  public boolean preOpen(String paramString, boolean paramBoolean)
  {
    boolean bool2 = false;
    AppMethodBeat.i(64557);
    if (!isSupportExt(this.a, paramString))
    {
      AppMethodBeat.o(64557);
      return false;
    }
    boolean bool3 = a(this.a);
    boolean bool1 = bool3;
    if (bool3)
    {
      bool3 = a();
      bool1 = bool3;
      if (paramBoolean)
      {
        bool1 = bool3;
        if (bool3)
        {
          paramBoolean = bool2;
          if (Apn.getApnType(this.a) == 3) {
            paramBoolean = true;
          }
        }
      }
    }
    for (paramBoolean = this.b.checkPlugin(this.c, this.a, paramString, paramBoolean);; paramBoolean = bool1)
    {
      AppMethodBeat.o(64557);
      return paramBoolean;
    }
  }
  
  public void userStatistics(String paramString)
  {
    AppMethodBeat.i(64565);
    if (this.b != null) {
      this.b.userStatistics(this.c, paramString);
    }
    AppMethodBeat.o(64565);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsReaderView
 * JD-Core Version:    0.7.0.1
 */