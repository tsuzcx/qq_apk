package com.tencent.tbs.reader;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TbsReaderView
  extends FrameLayout
  implements ITbsReaderCallback
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
  static boolean g = false;
  public static String gReaderPackName = "";
  public static String gReaderPackVersion = "";
  Context a;
  ITbsReader b;
  TbsReaderView.ReaderCallback c;
  TbsReaderView.ReaderCallback d;
  ReaderMixerMode e;
  ReaderPluginPreLoad f;
  
  public TbsReaderView(Context paramContext, TbsReaderView.ReaderCallback paramReaderCallback)
  {
    super(paramContext.getApplicationContext());
    AppMethodBeat.i(192404);
    this.a = null;
    this.b = null;
    this.c = null;
    this.d = null;
    this.e = null;
    this.f = null;
    if (!(paramContext instanceof Activity))
    {
      paramContext = new RuntimeException("error: unexpect context(none Activity)");
      AppMethodBeat.o(192404);
      throw paramContext;
    }
    this.c = paramReaderCallback;
    this.a = paramContext;
    AppMethodBeat.o(192404);
  }
  
  public static Drawable getResDrawable(Context paramContext, int paramInt)
  {
    return null;
  }
  
  public static String getResString(Context paramContext, int paramInt)
  {
    return "";
  }
  
  public static boolean initSDK(Context paramContext)
  {
    AppMethodBeat.i(192406);
    if (!g) {
      g = TbsFileInterfaceImpl.initEngine(paramContext.getApplicationContext());
    }
    new StringBuilder("gInitSdk:").append(g);
    boolean bool = g;
    AppMethodBeat.o(192406);
    return bool;
  }
  
  public static boolean isSupportExt(Context paramContext, String paramString)
  {
    AppMethodBeat.i(192407);
    boolean bool = false;
    if (initSDK(paramContext)) {
      bool = TbsFileInterfaceImpl.canOpenFile(paramString);
    }
    AppMethodBeat.o(192407);
    return bool;
  }
  
  boolean a()
  {
    bool2 = false;
    AppMethodBeat.i(192414);
    try
    {
      this.b = ReaderEngine.getInstance().createTbsReader(this.a.getApplicationContext(), Integer.valueOf(3), this);
      bool1 = bool2;
      if (this.b != null)
      {
        this.e = new ReaderMixerMode(this.a, this.b);
        bool1 = true;
      }
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        boolean bool1 = bool2;
      }
    }
    AppMethodBeat.o(192414);
    return bool1;
  }
  
  public void doCommand(Integer paramInteger, Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(192411);
    if ((this.e != null) && (this.b != null)) {
      this.b.doCommand(paramInteger, paramObject1, paramObject2);
    }
    AppMethodBeat.o(192411);
  }
  
  public boolean downloadPlugin(String paramString)
  {
    boolean bool2 = false;
    AppMethodBeat.i(192409);
    if (this.b == null)
    {
      AppMethodBeat.o(192409);
      return false;
    }
    if (this.f == null) {
      this.f = new ReaderPluginPreLoad(this.a, this.b);
    }
    boolean bool1 = bool2;
    if (this.f != null)
    {
      bool1 = bool2;
      if (this.f.downloadPlugin(this.a, paramString) == 0) {
        bool1 = true;
      }
    }
    AppMethodBeat.o(192409);
    return bool1;
  }
  
  public void onCallBackAction(Integer paramInteger, Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(192405);
    new StringBuilder("onCallBackAction:").append(paramInteger);
    if (this.c != null) {
      this.c.onCallBackAction(paramInteger, paramObject1, paramObject2);
    }
    AppMethodBeat.o(192405);
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(192412);
    if (this.e != null) {
      this.e.onSizeChanged(paramInt1, paramInt2);
    }
    AppMethodBeat.o(192412);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(192413);
    if (this.e != null)
    {
      this.e.destroy();
      this.e = null;
    }
    if (this.f != null) {
      this.f.destroy();
    }
    this.f = null;
    if (this.b != null) {
      this.b.destroy();
    }
    this.b = null;
    this.a = null;
    g = false;
    AppMethodBeat.o(192413);
  }
  
  public int openFile(Bundle paramBundle)
  {
    AppMethodBeat.i(192410);
    if ((this.b == null) || (paramBundle == null) || (this.e == null))
    {
      AppMethodBeat.o(192410);
      return -1;
    }
    if (!paramBundle.containsKey("file_reader_top_bar_hide")) {
      paramBundle.putBoolean("file_reader_top_bar_hide", true);
    }
    paramBundle.putInt("windowType", TbsFileInterfaceImpl.FILE_READER_WINDOW_TYPE_VIEW);
    int i = this.e.openFile(paramBundle, this);
    AppMethodBeat.o(192410);
    return i;
  }
  
  public boolean preOpen(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(192408);
    if (!isSupportExt(this.a, paramString))
    {
      AppMethodBeat.o(192408);
      return false;
    }
    boolean bool2 = initSDK(this.a);
    boolean bool1 = bool2;
    if (bool2)
    {
      bool2 = a();
      bool1 = bool2;
      if (paramBoolean)
      {
        bool1 = bool2;
        if (bool2)
        {
          downloadPlugin(paramString);
          bool1 = bool2;
        }
      }
    }
    AppMethodBeat.o(192408);
    return bool1;
  }
  
  public void userStatistics(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tbs.reader.TbsReaderView
 * JD-Core Version:    0.7.0.1
 */