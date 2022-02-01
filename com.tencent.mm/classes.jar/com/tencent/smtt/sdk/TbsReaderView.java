package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.c.c;
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
    AppMethodBeat.i(55481);
    this.a = null;
    this.b = null;
    this.c = null;
    this.d = null;
    this.e = null;
    if (!(paramContext instanceof Activity))
    {
      paramContext = new RuntimeException("error: unexpect context(none Activity)");
      AppMethodBeat.o(55481);
      throw paramContext;
    }
    this.d = paramReaderCallback;
    this.a = paramContext;
    this.e = new TbsReaderView.ReaderCallback()
    {
      public void onCallBackAction(Integer paramAnonymousInteger, Object paramAnonymousObject1, Object paramAnonymousObject2)
      {
        Object localObject3 = null;
        Object localObject4 = null;
        Object localObject5 = null;
        Object localObject2 = null;
        int i = 0;
        AppMethodBeat.i(55089);
        new StringBuilder("onCallBackAction, actionType:").append(paramAnonymousInteger);
        Object localObject1;
        switch (paramAnonymousInteger.intValue())
        {
        default: 
        case 5008: 
          for (;;)
          {
            if ((TbsReaderView.this.d != null) && (i == 0)) {
              TbsReaderView.this.d.onCallBackAction(paramAnonymousInteger, paramAnonymousObject1, paramAnonymousObject2);
            }
            AppMethodBeat.o(55089);
            return;
            if (c.c(TbsReaderView.this.a)) {
              break;
            }
            paramAnonymousInteger = Integer.valueOf(5011);
            localObject1 = TbsReaderView.getResString(TbsReaderView.this.a, 5023);
            paramAnonymousObject1 = new Bundle();
            paramAnonymousObject1.putString("tip", (String)localObject1);
            paramAnonymousObject1.putString("statistics", "AHNG812");
            paramAnonymousObject1.putInt("channel_id", 10834);
            TbsReaderView.this.userStatistics("AHNG811");
          }
          localObject1 = "";
          if (paramAnonymousObject1 != null)
          {
            localObject2 = (Bundle)paramAnonymousObject1;
            localObject1 = ((Bundle)localObject2).getString("docpath");
          }
          QbSdk.startQBForDoc(TbsReaderView.this.a, (String)localObject1, 4, 0, "pdf", (Bundle)localObject2);
          TbsReaderView.this.userStatistics("AHNG813");
        }
        for (;;)
        {
          i = 1;
          break;
          if (!c.c(TbsReaderView.this.a))
          {
            paramAnonymousInteger = Integer.valueOf(5011);
            localObject1 = TbsReaderView.getResString(TbsReaderView.this.a, 5021);
            paramAnonymousObject1 = new Bundle();
            paramAnonymousObject1.putString("tip", (String)localObject1);
            paramAnonymousObject1.putString("statistics", "AHNG808");
            paramAnonymousObject1.putInt("channel_id", 10833);
            TbsReaderView.this.userStatistics("AHNG807");
            break;
          }
          localObject1 = "";
          localObject2 = localObject3;
          if (paramAnonymousObject1 != null)
          {
            localObject2 = (Bundle)paramAnonymousObject1;
            localObject1 = ((Bundle)localObject2).getString("docpath");
          }
          QbSdk.startQBForDoc(TbsReaderView.this.a, (String)localObject1, 4, 0, "", (Bundle)localObject2);
          TbsReaderView.this.userStatistics("AHNG809");
          continue;
          if (!c.c(TbsReaderView.this.a))
          {
            paramAnonymousInteger = Integer.valueOf(5011);
            localObject1 = TbsReaderView.getResString(TbsReaderView.this.a, 5022);
            paramAnonymousObject1 = new Bundle();
            paramAnonymousObject1.putString("tip", (String)localObject1);
            paramAnonymousObject1.putString("statistics", "AHNG816");
            paramAnonymousObject1.putInt("channel_id", 10835);
            TbsReaderView.this.userStatistics("AHNG815");
            break;
          }
          localObject1 = "";
          localObject2 = localObject4;
          if (paramAnonymousObject1 != null)
          {
            localObject2 = (Bundle)paramAnonymousObject1;
            localObject1 = ((Bundle)localObject2).getString("docpath");
          }
          QbSdk.startQBForDoc(TbsReaderView.this.a, (String)localObject1, 4, 0, "txt", (Bundle)localObject2);
          continue;
          if (!c.c(TbsReaderView.this.a))
          {
            paramAnonymousInteger = Integer.valueOf(5011);
            localObject1 = TbsReaderView.getResString(TbsReaderView.this.a, 5029);
            paramAnonymousObject1 = new Bundle();
            paramAnonymousObject1.putString("tip", (String)localObject1);
            paramAnonymousObject1.putString("statistics", "AHNG828");
            paramAnonymousObject1.putInt("channel_id", 10965);
            TbsReaderView.this.userStatistics("AHNG827");
            break;
          }
          localObject1 = "";
          localObject2 = localObject5;
          if (paramAnonymousObject1 != null)
          {
            localObject2 = (Bundle)paramAnonymousObject1;
            localObject1 = ((Bundle)localObject2).getString("docpath");
          }
          QbSdk.startQBForDoc(TbsReaderView.this.a, (String)localObject1, 4, 0, "doc", (Bundle)localObject2);
          TbsReaderView.this.userStatistics("AHNG829");
          continue;
          if (paramAnonymousObject1 != null)
          {
            localObject1 = (Bundle)paramAnonymousObject1;
            TbsReaderView.gReaderPackName = ((Bundle)localObject1).getString("name");
            TbsReaderView.gReaderPackVersion = ((Bundle)localObject1).getString("version");
          }
        }
      }
    };
    AppMethodBeat.o(55481);
  }
  
  static boolean a(Context paramContext)
  {
    AppMethodBeat.i(55482);
    if (!f)
    {
      g.a(true).a(paramContext.getApplicationContext(), true, false, null);
      f = g.a(false).b();
    }
    new StringBuilder("gInitSdk:").append(f);
    boolean bool = f;
    AppMethodBeat.o(55482);
    return bool;
  }
  
  public static Drawable getResDrawable(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(55486);
    Drawable localDrawable = null;
    if (a(paramContext)) {
      localDrawable = ReaderWizard.getResDrawable(paramInt);
    }
    AppMethodBeat.o(55486);
    return localDrawable;
  }
  
  public static String getResString(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(55487);
    String str = "";
    if (a(paramContext)) {
      str = ReaderWizard.getResString(paramInt);
    }
    AppMethodBeat.o(55487);
    return str;
  }
  
  public static boolean isSupportExt(Context paramContext, String paramString)
  {
    boolean bool2 = false;
    AppMethodBeat.i(55483);
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
    AppMethodBeat.o(55483);
    return bool1;
  }
  
  boolean a()
  {
    bool2 = false;
    AppMethodBeat.i(55493);
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
    AppMethodBeat.o(55493);
    return bool1;
  }
  
  public void doCommand(Integer paramInteger, Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(55489);
    if ((this.b != null) && (this.c != null)) {
      this.b.doCommand(this.c, paramInteger, paramObject1, paramObject2);
    }
    AppMethodBeat.o(55489);
  }
  
  public boolean downloadPlugin(String paramString)
  {
    AppMethodBeat.i(55485);
    if (this.c == null)
    {
      AppMethodBeat.o(55485);
      return false;
    }
    boolean bool = this.b.checkPlugin(this.c, this.a, paramString, true);
    AppMethodBeat.o(55485);
    return bool;
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(55490);
    if ((this.b != null) && (this.c != null)) {
      this.b.onSizeChanged(this.c, paramInt1, paramInt2);
    }
    AppMethodBeat.o(55490);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(55491);
    if (this.b != null)
    {
      this.b.destroy(this.c);
      this.c = null;
    }
    this.a = null;
    f = false;
    AppMethodBeat.o(55491);
  }
  
  public void openFile(Bundle paramBundle)
  {
    boolean bool2 = true;
    AppMethodBeat.i(55488);
    if ((this.c == null) || (paramBundle == null))
    {
      AppMethodBeat.o(55488);
      return;
    }
    boolean bool3 = c.c(this.a);
    if (!c.b(this.a))
    {
      bool1 = true;
      paramBundle.putBoolean("browser6.0", bool1 | bool3);
      bool3 = c.a(this.a, 6101625L, 610000L);
      if (c.b(this.a)) {
        break label123;
      }
    }
    label123:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramBundle.putBoolean("browser6.1", bool3 | bool1);
      this.b.openFile(this.c, this.a, paramBundle, this);
      AppMethodBeat.o(55488);
      return;
      bool1 = false;
      break;
    }
  }
  
  public boolean preOpen(String paramString, boolean paramBoolean)
  {
    boolean bool2 = false;
    AppMethodBeat.i(55484);
    if (!isSupportExt(this.a, paramString))
    {
      AppMethodBeat.o(55484);
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
      AppMethodBeat.o(55484);
      return paramBoolean;
    }
  }
  
  public void userStatistics(String paramString)
  {
    AppMethodBeat.i(55492);
    if (this.b != null) {
      this.b.userStatistics(this.c, paramString);
    }
    AppMethodBeat.o(55492);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsReaderView
 * JD-Core Version:    0.7.0.1
 */