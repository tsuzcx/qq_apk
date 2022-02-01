package com.tencent.xweb.xwalk;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Process;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.JsRuntime;
import com.tencent.xweb.JsRuntime.JsRuntimeType;
import com.tencent.xweb.WebView.c;
import com.tencent.xweb.ah;
import com.tencent.xweb.e;
import com.tencent.xweb.f.a;
import com.tencent.xweb.internal.j.a;
import com.tencent.xweb.q;
import com.tencent.xweb.s;
import com.tencent.xweb.s.a;
import com.tencent.xweb.w;
import com.tencent.xweb.xwalk.a.a.a;
import com.tencent.xweb.xwalk.a.l;
import com.tencent.xweb.xwalk.updater.SchedulerConfig;
import com.tencent.xweb.y;
import com.tencent.xweb.z;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;
import org.xwalk.core.XWalkPreferences;
import org.xwalk.core.XWalkUpdater;
import org.xwalk.core.XWalkUpdater.UpdateConfig;

public final class d
  implements com.tencent.xweb.internal.d
{
  Context MpR;
  com.tencent.xweb.WebView MvF;
  String MvG;
  ScrollView MvH;
  TextView MvI;
  TextView MvJ;
  TextView MvK;
  Button MvL;
  View MvM;
  boolean MvN;
  String MvO;
  private final String MvP;
  private final String MvQ;
  private final String MvR;
  private final String MvS;
  private View.OnClickListener MvT;
  
  public d(com.tencent.xweb.WebView paramWebView)
  {
    AppMethodBeat.i(154224);
    this.MvG = "";
    this.MvH = null;
    this.MvI = null;
    this.MvJ = null;
    this.MvK = null;
    this.MvL = null;
    this.MvN = false;
    this.MvO = "tools";
    this.MvP = "当前Dark Mode强制智能反色[%d,%d]（点击切换）";
    this.MvQ = "当前Dark Mode不强制智能反色[%d,%d]（点击切换）";
    this.MvR = "当前Light Mode[%d,%d]（点击切换）";
    this.MvS = "当前未知Mode[%d,%d]（点击切换）";
    this.MvT = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(154194);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/xweb/xwalk/WebDebugPage$42", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        d.this.MvM.setVisibility(8);
        d.this.MvF.startLongScreenshot(new q()
        {
          public final File getCacheFileDir()
          {
            AppMethodBeat.i(154192);
            File localFile = new File(d.this.MpR.getExternalCacheDir().getAbsolutePath(), "LongScreenshot");
            AppMethodBeat.o(154192);
            return localFile;
          }
          
          public final int getMaxHeightSupported()
          {
            return 0;
          }
          
          public final File getResultFileDir()
          {
            AppMethodBeat.i(154193);
            File localFile = new File(d.this.MpR.getExternalCacheDir().getAbsolutePath(), "LongScreenshot");
            AppMethodBeat.o(154193);
            return localFile;
          }
          
          public final void onLongScreenshotFinished(int paramAnonymous2Int, String paramAnonymous2String)
          {
            AppMethodBeat.i(154191);
            Log.d("WebDebugPage", "onLongScreenshotFinished with " + paramAnonymous2Int + " / " + paramAnonymous2String);
            AppMethodBeat.o(154191);
          }
          
          public final Bitmap overrideScreenshot(Bitmap paramAnonymous2Bitmap)
          {
            return paramAnonymous2Bitmap;
          }
        }, true);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$42", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(154194);
      }
    };
    this.MpR = paramWebView.getContext();
    this.MvF = paramWebView;
    gcR();
    gcP();
    AppMethodBeat.o(154224);
  }
  
  private void VO(String paramString)
  {
    AppMethodBeat.i(154240);
    com.tencent.xweb.b.h localh = new com.tencent.xweb.b.h(paramString);
    if (localh.isDirectory())
    {
      String[] arrayOfString = localh.list();
      if (arrayOfString != null)
      {
        int i = 0;
        while (i < arrayOfString.length)
        {
          VO(paramString + "//" + arrayOfString[i]);
          i += 1;
        }
      }
    }
    localh.delete();
    AppMethodBeat.o(154240);
  }
  
  private static String a(Context paramContext, WebView.c paramc, String paramString)
  {
    int j = 1;
    AppMethodBeat.i(154229);
    XWalkEnvironment.init(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\n   default core type ".concat(String.valueOf(paramc)));
    if (XWalkEnvironment.isIaDevice())
    {
      localStringBuilder.append(", is prefer WV_KIND_SYS because of this is x86 device");
      paramContext = localStringBuilder.toString();
      AppMethodBeat.o(154229);
      return paramContext;
    }
    if (com.tencent.xweb.a.baw(paramString) != WebView.c.Mqt)
    {
      paramc = com.tencent.xweb.a.baw(paramString);
      localStringBuilder.append("\n   has command type ".concat(String.valueOf(paramc)));
    }
    if (y.gaM().dk(paramString, true) != WebView.c.Mqt)
    {
      paramc = y.gaM().baY(paramString);
      localStringBuilder.append("\n   has abtest type ".concat(String.valueOf(paramc)));
    }
    for (int i = 1;; i = 0)
    {
      if (y.gaM().dk(paramString, false) != WebView.c.Mqt)
      {
        paramContext = y.gaM().baY(paramString);
        localStringBuilder.append("\n   has hardcode type ".concat(String.valueOf(paramContext)));
        i = j;
      }
      for (;;)
      {
        if ((i == 0) && (paramContext == WebView.c.Mqu) && (XWalkEnvironment.getXWebInitArgs("isgpversion", false)))
        {
          paramContext = WebView.c.Mqw;
          localStringBuilder.append("\n   is prefer " + paramContext + " because of gp version");
        }
        for (;;)
        {
          paramc = paramContext;
          if (paramContext == WebView.c.Mqu)
          {
            paramc = paramContext;
            if (!XWalkEnvironment.hasAvailableVersion())
            {
              paramc = WebView.c.Mqv;
              localStringBuilder.append("\n   is prefer " + paramc + " because of xwalk is not available");
            }
          }
          com.tencent.xweb.internal.h.d(paramc);
          if (com.tencent.xweb.internal.h.gbL().gbQ())
          {
            paramc = WebView.c.Mqw;
            localStringBuilder.append("\n   is prefer " + paramc + " because of LoadUrlWatchDog");
          }
          if (com.tencent.xweb.internal.b.c(paramc)) {
            localStringBuilder.append("\n   will not use " + paramc + " because of CrashWatchDog hit");
          }
          if (paramc == WebView.c.Mqv) {
            com.tencent.xweb.x5.sdk.d.gcN();
          }
          localStringBuilder.insert(0, "module: " + paramString + " core type is " + paramc);
          paramContext = localStringBuilder.toString();
          AppMethodBeat.o(154229);
          return paramContext;
        }
        paramContext = paramc;
      }
    }
  }
  
  public static void a(Context paramContext, final String paramString, boolean paramBoolean, final ValueCallback<Boolean> paramValueCallback)
  {
    AppMethodBeat.i(154245);
    com.tencent.xweb.b.h localh = new com.tencent.xweb.b.h(Environment.getExternalStorageDirectory().getPath());
    localh.gbA();
    final com.tencent.xweb.xwalk.a.f localf = com.tencent.xweb.xwalk.a.g.baM(paramString);
    if (localf == null)
    {
      Toast.makeText(paramContext, "找不到对应插件", 0).show();
      paramValueCallback.onReceiveValue(Boolean.FALSE);
      AppMethodBeat.o(154245);
      return;
    }
    if ("FullScreenVideo".equals(paramString)) {
      paramString = "xweb_fullscreen_video.js";
    }
    for (;;)
    {
      new AsyncTask()
      {
        private ProgressDialog uQp = null;
        
        private Boolean gcX()
        {
          int i = 99999;
          boolean bool = true;
          AppMethodBeat.i(154202);
          Object localObject2 = null;
          for (;;)
          {
            try
            {
              SchedulerConfig localSchedulerConfig;
              if (this.Mwm > 0)
              {
                int j = this.Mwm;
                i = j;
                if (localf.MxJ > 0)
                {
                  localObject1 = localf.aiK(localf.MxJ);
                  localf.aiJ(-1);
                  i = j;
                  if (localObject1 != null)
                  {
                    i = j;
                    if (!((String)localObject1).isEmpty())
                    {
                      com.tencent.xweb.util.c.bbn((String)localObject1);
                      i = j;
                    }
                  }
                }
                localSchedulerConfig = new SchedulerConfig();
                localSchedulerConfig.version = i;
                localSchedulerConfig.MyT = false;
                localSchedulerConfig.path = localf.bq(i, false);
                localObject1 = new File(localSchedulerConfig.path);
              }
              try
              {
                if (this.Mwo)
                {
                  com.tencent.xweb.util.c.b(this.val$context.getAssets().open(paramString), (File)localObject1);
                  localSchedulerConfig.Mys = com.tencent.xweb.b.i.aPK(((File)localObject1).getPath());
                  localSchedulerConfig.Mzc = true;
                  if (localf.a(localSchedulerConfig) != 0) {
                    continue;
                  }
                  AppMethodBeat.o(154202);
                  return Boolean.valueOf(bool);
                  if (localf.MxJ < 99999) {
                    continue;
                  }
                  i = localf.MxJ;
                  i += 1;
                  continue;
                }
                com.tencent.xweb.b.i.lL(this.Mwq, ((File)localObject1).getPath());
                continue;
                Log.e("WebDebugPage", "loadZipFormatPluginFromLocal error: " + ((Exception)localObject1).getMessage());
              }
              catch (Exception localException3)
              {
                localObject2 = localObject1;
                localObject1 = localException3;
              }
            }
            catch (Exception localException2)
            {
              Object localObject1;
              continue;
            }
            if (localObject2 != null) {}
            try
            {
              com.tencent.xweb.util.c.deleteAll(localObject2);
              localObject1 = Boolean.FALSE;
              AppMethodBeat.o(154202);
              return localObject1;
              bool = false;
            }
            catch (Exception localException1) {}
          }
        }
        
        protected final void onPreExecute()
        {
          AppMethodBeat.i(154201);
          this.uQp = new ProgressDialog(this.val$context);
          this.uQp.setProgressStyle(0);
          this.uQp.setMessage("安装中");
          this.uQp.setCancelable(false);
          this.uQp.setCanceledOnTouchOutside(false);
          this.uQp.setButton(-1, "完成", new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(154200);
              d.39.a(d.39.this).hide();
              AppMethodBeat.o(154200);
            }
          });
          this.uQp.show();
          this.uQp.getButton(-1).setVisibility(8);
          AppMethodBeat.o(154201);
        }
      }.execute(new Void[0]);
      AppMethodBeat.o(154245);
      return;
      if ("XFilesPPTReader".equals(paramString)) {
        paramString = "xfiles_ppt_reader.zip";
      } else if ("XFilesPDFReader".equals(paramString))
      {
        if (paramBoolean) {
          paramString = "xfiles_pdf_reader_arm64.zip";
        } else {
          paramString = "xfiles_pdf_reader_arm.zip";
        }
      }
      else if ("XFilesWordReader".equals(paramString))
      {
        if (paramBoolean) {
          paramString = "xfiles_word_reader_arm64.zip";
        } else {
          paramString = "xfiles_word_reader_arm.zip";
        }
      }
      else if ("XFilesExcelReader".equals(paramString)) {
        paramString = "xfiles_excel_reader.zip";
      } else {
        paramString = "";
      }
    }
  }
  
  /* Error */
  public static void a(com.tencent.xweb.internal.IWebView paramIWebView)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 457
    //   6: invokestatic 152	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: ifnull +12 -> 22
    //   13: invokestatic 291	com/tencent/xweb/y:gaM	()Lcom/tencent/xweb/y;
    //   16: getfield 460	com/tencent/xweb/y:Mqc	Z
    //   19: ifne +13 -> 32
    //   22: ldc_w 457
    //   25: invokestatic 212	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: ldc 2
    //   30: monitorexit
    //   31: return
    //   32: aload_0
    //   33: invokestatic 462	com/tencent/xweb/xwalk/d:b	(Lcom/tencent/xweb/internal/IWebView;)V
    //   36: ldc_w 457
    //   39: invokestatic 212	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: goto -14 -> 28
    //   45: astore_0
    //   46: ldc 2
    //   48: monitorexit
    //   49: aload_0
    //   50: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	paramIWebView	com.tencent.xweb.internal.IWebView
    // Exception table:
    //   from	to	target	type
    //   3	9	45	finally
    //   13	22	45	finally
    //   22	28	45	finally
    //   32	42	45	finally
  }
  
  /* Error */
  public static void b(com.tencent.xweb.internal.IWebView paramIWebView)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 532
    //   6: invokestatic 152	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: ifnull +12 -> 22
    //   13: invokestatic 291	com/tencent/xweb/y:gaM	()Lcom/tencent/xweb/y;
    //   16: getfield 460	com/tencent/xweb/y:Mqc	Z
    //   19: ifne +13 -> 32
    //   22: ldc_w 532
    //   25: invokestatic 212	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: ldc 2
    //   30: monitorexit
    //   31: return
    //   32: aload_0
    //   33: ldc_w 534
    //   36: new 92	com/tencent/xweb/xwalk/d$47
    //   39: dup
    //   40: invokespecial 535	com/tencent/xweb/xwalk/d$47:<init>	()V
    //   43: invokeinterface 541 3 0
    //   48: ldc_w 532
    //   51: invokestatic 212	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   54: goto -26 -> 28
    //   57: astore_0
    //   58: ldc 2
    //   60: monitorexit
    //   61: aload_0
    //   62: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	63	0	paramIWebView	com.tencent.xweb.internal.IWebView
    // Exception table:
    //   from	to	target	type
    //   3	9	57	finally
    //   13	22	57	finally
    //   22	28	57	finally
    //   32	54	57	finally
  }
  
  public static boolean bby(String paramString)
  {
    boolean bool = false;
    AppMethodBeat.i(154252);
    if (paramString == null)
    {
      AppMethodBeat.o(154252);
      return false;
    }
    if ((paramString.contains("debugxweb.qq.com")) || (paramString.contains("debugmm.qq.com")) || (paramString.contains("public.debugxweb.qq.com"))) {
      bool = true;
    }
    if (bool)
    {
      com.tencent.xweb.util.g.Fh(223L);
      Log.e("WebDebugPage", "this url contians debug piece, url =  ".concat(String.valueOf(paramString)));
    }
    AppMethodBeat.o(154252);
    return bool;
  }
  
  public static void cH(Context paramContext, final String paramString)
  {
    AppMethodBeat.i(195553);
    final com.tencent.xweb.xwalk.a.j localj = new com.tencent.xweb.xwalk.a.j();
    localj.a(paramString, new com.tencent.xweb.xwalk.a.i()
    {
      ProgressDialog Mwg = null;
      boolean mFinished = false;
      
      public final void aiy(int paramAnonymousInt)
      {
        AppMethodBeat.i(154198);
        if ((this.mFinished) || (this.Mwg == null))
        {
          AppMethodBeat.o(154198);
          return;
        }
        this.Mwg.setProgress(paramAnonymousInt);
        AppMethodBeat.o(154198);
      }
      
      public final void aiz(int paramAnonymousInt)
      {
        AppMethodBeat.i(154199);
        this.mFinished = true;
        if (this.Mwg == null)
        {
          AppMethodBeat.o(154199);
          return;
        }
        Object localObject = com.tencent.xweb.xwalk.a.g.baM(paramString);
        switch (paramAnonymousInt)
        {
        default: 
          this.Mwg.setMessage(paramString + " 更新失败，未知错误，ErrCode = " + paramAnonymousInt);
          if ((this.Mwk != null) && (y.gaM() != null))
          {
            if (!"XFilesPPTReader".equals(paramString)) {
              break label764;
            }
            localObject = new String[2];
            localObject[0] = "ppt";
            localObject[1] = "pptx";
          }
          break;
        }
        for (;;)
        {
          String str = y.gaM().a((String[])localObject, this.Mwk);
          e.al((String[])localObject);
          Toast.makeText(this.val$context, "格式:" + str + "强制使用" + this.Mwk.name() + "打开", 0).show();
          if (this.kNa != null) {
            this.kNa.onReceiveValue(Integer.valueOf(paramAnonymousInt));
          }
          AppMethodBeat.o(154199);
          return;
          if (localObject != null) {
            this.Mwg.setMessage(paramString + " 更新完成，已安装版本" + ((com.tencent.xweb.xwalk.a.f)localObject).MxJ);
          }
          for (;;)
          {
            this.Mwg.setProgress(100);
            this.Mwg.getButton(-2).setVisibility(8);
            this.Mwg.getButton(-1).setVisibility(0);
            if (!this.Mwj) {
              break;
            }
            this.Mwg.dismiss();
            break;
            this.Mwg.setMessage(paramString + " 更新完成");
          }
          this.Mwg.setMessage(paramString + " 更新被取消，ErrCode = " + paramAnonymousInt);
          break;
          this.Mwg.setMessage(paramString + " 更新失败，无网络，ErrCode = " + paramAnonymousInt);
          break;
          this.Mwg.setMessage(paramString + " 更新失败，未到检查时间，ErrCode = " + paramAnonymousInt);
          break;
          this.Mwg.setMessage(paramString + " 更新失败，其它任务正在更新插件，ErrCode = " + paramAnonymousInt);
          break;
          this.Mwg.setMessage(paramString + " 更新失败，配置下载失败，ErrCode = " + paramAnonymousInt);
          break;
          this.Mwg.setMessage(paramString + " 更新失败，配置解析失败，ErrCode = " + paramAnonymousInt);
          break;
          this.Mwg.setMessage(paramString + " 更新失败，配置中未包含插件信息，ErrCode = " + paramAnonymousInt);
          break;
          if (localObject != null) {
            this.Mwg.setMessage(paramString + " 更新失败，未找到可用更新，当前已安装版本" + ((com.tencent.xweb.xwalk.a.f)localObject).MxJ + "，ErrCode = " + paramAnonymousInt);
          }
          while (this.Mwj)
          {
            this.Mwg.dismiss();
            break;
            this.Mwg.setMessage(paramString + " 更新失败，未找到可用更新，ErrCode = " + paramAnonymousInt);
          }
          this.Mwg.setMessage(paramString + " 更新失败，下载安装出错，ErrCode = " + paramAnonymousInt);
          break;
          label764:
          if ("XFilesPDFReader".equals(paramString))
          {
            localObject = new String[1];
            localObject[0] = "pdf";
          }
          else if ("XFilesWordReader".equals(paramString))
          {
            localObject = new String[2];
            localObject[0] = "doc";
            localObject[1] = "docx";
          }
          else
          {
            if (!"XFilesExcelReader".equals(paramString)) {
              break label849;
            }
            localObject = new String[2];
            localObject[0] = "xls";
            localObject[1] = "xlsx";
          }
        }
        label849:
        AppMethodBeat.o(154199);
      }
      
      public final void gaA()
      {
        AppMethodBeat.i(154197);
        this.Mwg = new ProgressDialog(this.val$context);
        this.Mwg.setProgressStyle(1);
        this.Mwg.setMessage(paramString + " 下载更新中");
        this.Mwg.setCancelable(false);
        this.Mwg.setCanceledOnTouchOutside(false);
        this.Mwg.setButton(-2, "取消", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(154195);
            if (!d.38.this.mFinished) {
              d.38.this.Mwi.gaL();
            }
            AppMethodBeat.o(154195);
          }
        });
        this.Mwg.setButton(-1, "完成", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(154196);
            d.38.this.Mwg.dismiss();
            AppMethodBeat.o(154196);
          }
        });
        this.Mwg.show();
        this.Mwg.getButton(-1).setVisibility(8);
        AppMethodBeat.o(154197);
      }
    });
    paramString = new HashMap();
    paramString.put("UpdaterCheckType", "1");
    localj.a(paramContext, paramString);
    AppMethodBeat.o(195553);
  }
  
  private boolean dq(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(154227);
    if ((paramString.contains("debugxweb.qq.com")) || (paramBoolean))
    {
      Uri localUri = Uri.parse(paramString);
      paramString = localUri.getQueryParameterNames();
      if ((paramString == null) || (paramString.size() == 0))
      {
        gcT();
        AppMethodBeat.o(154227);
        return true;
      }
      Iterator localIterator = paramString.iterator();
      while (localIterator.hasNext())
      {
        paramString = (String)localIterator.next();
        label192:
        int i;
        if (paramString != null)
        {
          switch (paramString.hashCode())
          {
          default: 
            i = -1;
          }
          for (;;)
          {
            switch (i)
            {
            default: 
              break;
            case 0: 
              zP(false);
              break;
              if (!paramString.equals("load_local_xwalk")) {
                break label192;
              }
              i = 0;
              continue;
              if (!paramString.equals("clear_commands")) {
                break label192;
              }
              i = 1;
              continue;
              if (!paramString.equals("wait_debugger")) {
                break label192;
              }
              i = 2;
              continue;
              if (!paramString.equals("debug_process")) {
                break label192;
              }
              i = 3;
              continue;
              if (!paramString.equals("set_apkver")) {
                break label192;
              }
              i = 4;
              continue;
              if (!paramString.equals("check_files")) {
                break label192;
              }
              i = 5;
              continue;
              if (!paramString.equals("revert_to_apk")) {
                break label192;
              }
              i = 6;
              continue;
              if (!paramString.equals("set_config_peroid")) {
                break label192;
              }
              i = 7;
              continue;
              if (!paramString.equals("recheck_cmds")) {
                break label192;
              }
              i = 8;
              continue;
              if (!paramString.equals("set_force_filereader")) {
                break label192;
              }
              i = 9;
              continue;
              if (!paramString.equals("clear_all_plugin")) {
                break label192;
              }
              i = 10;
            }
          }
          com.tencent.xweb.a.a(null, "0");
          continue;
          paramBoolean = localUri.getBooleanQueryParameter("wait_debugger", false);
          paramString = y.gaM();
          paramString.MpY = paramBoolean;
          paramString.MpR.getSharedPreferences("wcwebview", 0).edit().putBoolean("bWaitforDebugger", paramBoolean).commit();
          continue;
          paramString = localUri.getQueryParameter("debug_process");
          y.gaM().MpR.getSharedPreferences("wcwebview", 4).edit().putString("strDebugProcess", paramString).commit();
          continue;
          paramString = localUri.getQueryParameter("set_apkver");
          try
          {
            XWalkEnvironment.setAvailableVersion(Integer.parseInt(paramString), "1.0.".concat(String.valueOf(paramString)), XWalkEnvironment.getRuntimeAbi());
            ds("版本号设置到:" + paramString + " 点击空白处退出重启进程", true);
          }
          catch (Exception paramString)
          {
            dr("设置版本号失败:" + paramString.getMessage(), true);
          }
          continue;
          p.zQ(true);
          continue;
          paramString = localUri.getQueryParameter("revert_to_apk");
          try
          {
            i = p.aW(XWalkEnvironment.getApplicationContext(), Integer.parseInt(paramString));
            ds("版本号回滚到:" + i + " 点击空白处退出重启进程", true);
          }
          catch (Exception paramString)
          {
            dr("版本号回滚到失败:" + paramString.getMessage(), true);
          }
          continue;
          paramString = localUri.getQueryParameter("set_config_peroid");
          try
          {
            com.tencent.xweb.a.aix(Integer.parseInt(paramString));
            ds("设置配置拉取周期为:" + paramString + "分钟", false);
          }
          catch (Exception paramString)
          {
            dr("设置配置拉取周期失败:" + paramString.getMessage(), true);
          }
          continue;
          com.tencent.xweb.internal.j.g(WebView.c.Mqu).excute("STR_CMD_SET_RECHECK_COMMAND", null);
          ds("重新跑了一遍命令配置 点击空白处退出重启进程", true);
          continue;
          paramString = "";
        }
        try
        {
          localObject = localUri.getQueryParameter("set_force_filereader");
          paramString = (String)localObject;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Object localObject;
            String[] arrayOfString;
          }
        }
        arrayOfString = paramString.split("_");
        if (paramString.length() < 2)
        {
          dr("强制设置文件预览方式失败，参数错误", true);
        }
        else
        {
          paramString = arrayOfString[(arrayOfString.length - 1)];
          if ("xweb".equalsIgnoreCase(paramString)) {
            paramString = f.a.Mpj;
          }
          for (;;)
          {
            if ((arrayOfString.length == 2) && ("all".equalsIgnoreCase(arrayOfString[0])))
            {
              localObject = com.tencent.xweb.f.Mpg;
              localObject = y.gaM().a((String[])localObject, paramString);
              if (((String)localObject).isEmpty()) {
                break label1058;
              }
              dr("格式:" + (String)localObject + "强制使用" + paramString.name() + "打开", true);
              break;
              if ("x5".equalsIgnoreCase(paramString))
              {
                paramString = f.a.Mpk;
              }
              else if ("none".equalsIgnoreCase(paramString))
              {
                paramString = f.a.Mpi;
              }
              else
              {
                dr("强制设置文件预览方式失败，类型错误", true);
                break;
              }
            }
          }
          localObject = new String[arrayOfString.length - 1];
          i = 0;
          while (i < arrayOfString.length - 1)
          {
            localObject[i] = arrayOfString[i];
            i += 1;
          }
          label1058:
          dr("强制设置文件预览方式失败", true);
          continue;
          gcV();
        }
      }
      AppMethodBeat.o(154227);
      return true;
    }
    else
    {
      AppMethodBeat.o(154227);
      return false;
    }
  }
  
  private void gcS()
  {
    AppMethodBeat.i(154233);
    if (this.MvJ == null)
    {
      AppMethodBeat.o(154233);
      return;
    }
    String str = zO(false);
    this.MvJ.setText(str);
    AppMethodBeat.o(154233);
  }
  
  private static String gcU()
  {
    AppMethodBeat.i(154237);
    Object localObject = new StringBuilder();
    String[] arrayOfString = com.tencent.xweb.f.Mpg;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      ((StringBuilder)localObject).append("\n ").append(str).append(": force-").append(y.gaM().baZ(str)).append("  cmd-").append(com.tencent.xweb.b.baJ(str));
      i += 1;
    }
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(154237);
    return localObject;
  }
  
  protected static void hH(Context paramContext)
  {
    AppMethodBeat.i(154243);
    paramContext = (ActivityManager)paramContext.getSystemService("activity");
    int i = Process.myPid();
    int j = Process.myUid();
    paramContext = paramContext.getRunningAppProcesses().iterator();
    while (paramContext.hasNext())
    {
      localObject1 = (ActivityManager.RunningAppProcessInfo)paramContext.next();
      if ((((ActivityManager.RunningAppProcessInfo)localObject1).uid == j) && (((ActivityManager.RunningAppProcessInfo)localObject1).pid != i))
      {
        Object localObject2 = ((ActivityManager.RunningAppProcessInfo)localObject1).processName;
        if ((localObject2 == null) || (!((String)localObject2).contains("com.tencent.mm")) || (((ActivityManager.RunningAppProcessInfo)localObject1).processName.contains("tools")) || (((ActivityManager.RunningAppProcessInfo)localObject1).processName.contains("appbrand")) || (((ActivityManager.RunningAppProcessInfo)localObject1).processName.contains("support")))
        {
          localObject1 = com.tencent.mm.hellhoundlib.b.c.a(((ActivityManager.RunningAppProcessInfo)localObject1).pid, new com.tencent.mm.hellhoundlib.b.a());
          localObject2 = new Object();
          com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahp(), "com/tencent/xweb/xwalk/WebDebugPage", "killAllProcess", "(Landroid/content/Context;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
          Process.killProcess(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).mq(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/xweb/xwalk/WebDebugPage", "killAllProcess", "(Landroid/content/Context;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
        }
      }
    }
    paramContext = com.tencent.mm.hellhoundlib.b.c.a(i, new com.tencent.mm.hellhoundlib.b.a());
    Object localObject1 = new Object();
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, paramContext.ahp(), "com/tencent/xweb/xwalk/WebDebugPage", "killAllProcess", "(Landroid/content/Context;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
    Process.killProcess(((Integer)paramContext.mq(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/xweb/xwalk/WebDebugPage", "killAllProcess", "(Landroid/content/Context;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
    AppMethodBeat.o(154243);
  }
  
  public static void lA(Context paramContext)
  {
    AppMethodBeat.i(154238);
    com.tencent.xweb.xwalk.updater.c.MyI = true;
    com.tencent.xweb.xwalk.a.j localj = new com.tencent.xweb.xwalk.a.j();
    HashMap localHashMap = new HashMap();
    localHashMap.put("UpdaterCheckType", "1");
    localj.a(paramContext, localHashMap);
    AppMethodBeat.o(154238);
  }
  
  private static int li(int paramInt1, int paramInt2)
  {
    int i = 1;
    if (paramInt1 == 0) {
      paramInt1 = 3;
    }
    do
    {
      do
      {
        return paramInt1;
        if (paramInt1 != 2) {
          break;
        }
        paramInt1 = i;
      } while (paramInt2 == 2);
      if (paramInt2 == 1) {
        return 2;
      }
      paramInt1 = i;
    } while (paramInt2 == 0);
    return 4;
  }
  
  final void G(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(154247);
    b localb = new b(paramString1, paramString2);
    try
    {
      Object localObject = new com.tencent.xweb.b.h(XWalkEnvironment.getDownloadZipDir(localb.apkVer));
      if (((com.tencent.xweb.b.h)localObject).exists()) {
        ((com.tencent.xweb.b.h)localObject).delete();
      }
      paramString1 = com.tencent.xweb.b.i.openRead(paramString1);
      localObject = com.tencent.xweb.b.i.Cz(((com.tencent.xweb.b.h)localObject).getAbsolutePath());
      byte[] arrayOfByte = new byte[1048576];
      for (;;)
      {
        int i = paramString1.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        ((OutputStream)localObject).write(arrayOfByte, 0, i);
      }
      dr("安装" + paramString2 + "失败,错误码=" + paramString1, true);
    }
    catch (IOException paramString1)
    {
      for (;;)
      {
        paramString1 = XWalkUpdater.onHandleFile(localb);
        if (paramString1.intValue() != 0) {
          break;
        }
        dr("安装" + paramString2 + "成功", paramBoolean);
        AppMethodBeat.o(154247);
        return;
        ((OutputStream)localObject).flush();
        paramString1.close();
        ((OutputStream)localObject).close();
      }
    }
    catch (Exception paramString1)
    {
      dr("安装失败", true);
      Log.e("WebDebugPage", "install local apk failed : " + paramString1.getMessage());
      AppMethodBeat.o(154247);
      return;
    }
    AppMethodBeat.o(154247);
  }
  
  public final void a(boolean paramBoolean1, Button paramButton, boolean paramBoolean2)
  {
    AppMethodBeat.i(154244);
    try
    {
      XWalkPreferences.setValue("remote-debugging", paramBoolean1);
      try
      {
        label13:
        if (Build.VERSION.SDK_INT >= 19) {
          android.webkit.WebView.setWebContentsDebuggingEnabled(paramBoolean1);
        }
        try
        {
          label25:
          com.tencent.xweb.x5.sdk.d.setWebContentsDebuggingEnabled(paramBoolean1);
          label29:
          if ((paramBoolean2) && (this.MvF.getX5WebViewExtension() != null))
          {
            if (!paramBoolean1) {
              break label79;
            }
            this.MvF.loadUrl("http://debugx5.qq.com/?inspector=true");
          }
          while (paramButton != null) {
            if (paramBoolean1)
            {
              paramButton.setText("关闭远程调试模式(当前已打开)");
              AppMethodBeat.o(154244);
              return;
              label79:
              this.MvF.loadUrl("http://debugx5.qq.com/?inspector=false");
            }
            else
            {
              paramButton.setText("打开远程调试模式(当前已关闭)");
            }
          }
          AppMethodBeat.o(154244);
          return;
        }
        catch (Exception localException1)
        {
          break label29;
        }
      }
      catch (Exception localException2)
      {
        break label25;
      }
    }
    catch (Exception localException3)
    {
      break label13;
    }
  }
  
  public final boolean bba(String paramString)
  {
    boolean bool5 = false;
    AppMethodBeat.i(154226);
    if (paramString == null)
    {
      AppMethodBeat.o(154226);
      return false;
    }
    Object localObject5;
    Object localObject1;
    Iterator localIterator;
    boolean bool1;
    boolean bool2;
    if ((paramString.contains("debugmm.qq.com")) || (paramString.contains("debugxweb.qq.com")))
    {
      com.tencent.xweb.util.g.Fh(224L);
      localObject5 = Uri.parse(paramString);
      localObject1 = ((Uri)localObject5).getQueryParameterNames();
      if ((localObject1 != null) && (((Set)localObject1).size() > 0))
      {
        localIterator = ((Set)localObject1).iterator();
        bool1 = false;
        bool2 = false;
      }
    }
    for (;;)
    {
      boolean bool3 = bool1;
      boolean bool4 = bool2;
      int i;
      label302:
      Object localObject4;
      if (localIterator.hasNext())
      {
        localObject1 = (String)localIterator.next();
        if (localObject1 != null) {
          switch (((String)localObject1).hashCode())
          {
          default: 
            i = -1;
            switch (i)
            {
            default: 
              break;
            case 0: 
              if (((Uri)localObject5).getBooleanQueryParameter("forcex5", false))
              {
                y.gaM().a("tools", WebView.c.Mqv);
                y.gaM().a("appbrand", WebView.c.Mqv);
                y.gaM().a("support", WebView.c.Mqv);
                y.gaM().a("mm", WebView.c.Mqv);
                y.gaM().a("toolsmp", WebView.c.Mqv);
                y.gaM().a(JsRuntime.JsRuntimeType.MpB);
                ds("force use x5 switch is on ", true);
              }
              break;
            }
            break;
          case -677737752: 
          case -82035977: 
          case -873960692: 
          case 624401059: 
          case -1767214708: 
          case 1473208405: 
          case -338505561: 
          case -108592348: 
          case 1874228874: 
          case -748036674: 
          case -974615216: 
          case 386281809: 
          case 293074704: 
          case 989541982: 
          case 801125523: 
          case -1045985412: 
          case 273273929: 
          case 2135256815: 
          case 684429537: 
          case -1556996002: 
            for (;;)
            {
              AppMethodBeat.o(154226);
              return true;
              if (!((String)localObject1).equals("forcex5")) {
                break;
              }
              i = 0;
              break label302;
              if (!((String)localObject1).equals("inspector")) {
                break;
              }
              i = 1;
              break label302;
              if (!((String)localObject1).equals("ticket")) {
                break;
              }
              i = 2;
              break label302;
              if (!((String)localObject1).equals("show_x5_ver")) {
                break;
              }
              i = 3;
              break label302;
              if (!((String)localObject1).equals("encrpt_url")) {
                break;
              }
              i = 4;
              break label302;
              if (!((String)localObject1).equals("clear_test_setting")) {
                break;
              }
              i = 5;
              break label302;
              if (!((String)localObject1).equals("show_fps")) {
                break;
              }
              i = 6;
              break label302;
              if (!((String)localObject1).equals("set_mm_config")) {
                break;
              }
              i = 7;
              break label302;
              if (!((String)localObject1).equals("set_web_config")) {
                break;
              }
              i = 8;
              break label302;
              if (!((String)localObject1).equals("set_appbrand_config")) {
                break;
              }
              i = 9;
              break label302;
              if (!((String)localObject1).equals("show_webview_version")) {
                break;
              }
              i = 10;
              break label302;
              if (!((String)localObject1).equals("set_grayvalue")) {
                break;
              }
              i = 11;
              break label302;
              if (!((String)localObject1).equals("set_device_rd_value")) {
                break;
              }
              i = 12;
              break label302;
              if (!((String)localObject1).equals("check_xwalk_update")) {
                break;
              }
              i = 13;
              break label302;
              if (!((String)localObject1).equals("soft_check_xwalk_update")) {
                break;
              }
              i = 14;
              break label302;
              if (!((String)localObject1).equals("clear_config_time_stamp")) {
                break;
              }
              i = 15;
              break label302;
              if (!((String)localObject1).equals("clear_schedule")) {
                break;
              }
              i = 16;
              break label302;
              if (!((String)localObject1).equals("set_config_url")) {
                break;
              }
              i = 17;
              break label302;
              if (!((String)localObject1).equals("set_plugin_config_url")) {
                break;
              }
              i = 18;
              break label302;
              if (!((String)localObject1).equals("check_plugin_update")) {
                break;
              }
              i = 19;
              break label302;
              y.gaM().a("tools", WebView.c.Mqt);
              y.gaM().a("appbrand", WebView.c.Mqt);
              y.gaM().a("support", WebView.c.Mqt);
              y.gaM().a("mm", WebView.c.Mqt);
              y.gaM().a("toolsmp", WebView.c.Mqt);
              y.gaM().a(JsRuntime.JsRuntimeType.Mpw);
              ds("force use x5 switch is off ", true);
            }
            bool1 = ((Uri)localObject5).getBooleanQueryParameter("inspector", false);
            y.gaM().zE(bool1);
            a(bool1, null, true);
            AppMethodBeat.o(154226);
            return true;
            localObject1 = ((Uri)localObject5).getQueryParameter("ticket");
            localObject4 = ((Uri)localObject5).toString();
            if ((TextUtils.isEmpty((CharSequence)localObject4)) || (TextUtils.isEmpty((CharSequence)localObject1))) {
              bool2 = false;
            }
            for (;;)
            {
              if (bool2) {
                break label1109;
              }
              dr("权限校验失败", true);
              Log.e("WebDebugPage", "checkTempPerssion failed");
              break;
              localObject4 = ((String)localObject4).trim();
              i = ((String)localObject4).lastIndexOf("ticket");
              if ((i < 0) || (i >= ((String)localObject4).length()))
              {
                bool2 = false;
              }
              else
              {
                localObject4 = ((String)localObject4).substring(0, i);
                String str3 = new SimpleDateFormat("yyyyMMdd").format(new Date());
                bool2 = com.tencent.xweb.util.b.bn((String)localObject4 + "@check_permission@" + str3, (String)localObject1, "MHYwEAYHKoZIzj0CAQYFK4EEACIDYgAE4s7oy+BvW5kzf5PwtVqDdZb2rVQS7GDf\naJWwtkD95ILDQAtHM9Nv5apLYQnUbXkjTldOUpjK7MimTkf/qXjQfk8hF2A0Mf7L\nHbDPr7kD9DOuQlG53SWOuKQVEwwsjN1l");
              }
            }
            label1109:
            Log.i("WebDebugPage", "checkTempPerssion suc");
            continue;
            bool1 = ((Uri)localObject5).getBooleanQueryParameter("show_x5_ver", false);
            paramString = y.gaM();
            if (bool1 != paramString.MpV)
            {
              paramString.MpV = bool1;
              paramString.MpR.getSharedPreferences("wcwebview", 0).edit().putBoolean("bShowX5Version", paramString.MpV).commit();
            }
            if (bool1) {
              dr("开启显示x5内核信息", true);
            }
            for (;;)
            {
              AppMethodBeat.o(154226);
              return true;
              dr("关闭显示x5内核信息", true);
            }
            paramString = ((Uri)localObject5).getQueryParameter("encrpt_url");
            try
            {
              paramString = com.tencent.xweb.util.a.a(paramString, com.tencent.xweb.util.a.bbl("b01d4598de5875eb9b86abdef32b811e9c55edcfb1673b5617cc0a6ab7dceaff"));
              if (TextUtils.isEmpty(paramString))
              {
                dr("解密失败", true);
                AppMethodBeat.o(154226);
                return true;
              }
              bba(paramString);
            }
            catch (Throwable paramString)
            {
              for (;;)
              {
                dr("解密失败", true);
              }
            }
            AppMethodBeat.o(154226);
            return true;
            p.lC(XWalkEnvironment.getApplicationContext());
            AppMethodBeat.o(154226);
            return true;
            bool1 = ((Uri)localObject5).getBooleanQueryParameter("show_fps", false);
            y.gaM().setShowFps(bool1);
            AppMethodBeat.o(154226);
            return true;
            try
            {
              localObject1 = WebView.c.valueOf(((Uri)localObject5).getQueryParameter("set_mm_config"));
              y.gaM().a("mm", (WebView.c)localObject1);
              dr("mm进程将使用:".concat(String.valueOf(localObject1)), true);
            }
            catch (Exception localException1) {}
            continue;
            try
            {
              WebView.c localc = WebView.c.valueOf(((Uri)localObject5).getQueryParameter("set_web_config"));
              y.gaM().a("tools", localc);
              y.gaM().a("toolsmp", localc);
              dr("打开网页将使用:".concat(String.valueOf(localc)), true);
            }
            catch (Exception localException2) {}
            break;
          }
        }
      }
      else
      {
        try
        {
          Object localObject2 = WebView.c.valueOf(((Uri)localObject5).getQueryParameter("set_appbrand_config"));
          y.gaM().a("appbrand", (WebView.c)localObject2);
          y.gaM().a("support", (WebView.c)localObject2);
          switch (48.mFe[localObject2.ordinal()])
          {
          case 1: 
            y.gaM().a(JsRuntime.JsRuntimeType.MpE);
            dr("打开小程序将使用:".concat(String.valueOf(localObject2)), true);
            break;
          case 2: 
            y.gaM().a(JsRuntime.JsRuntimeType.MpB);
            dr("打开小程序将使用:".concat(String.valueOf(localObject2)), true);
            break;
          case 3: 
            y.gaM().a(JsRuntime.JsRuntimeType.MpE);
            dr("打开小程序将使用:".concat(String.valueOf(localObject2)), true);
            continue;
            if (this.MvK == null)
            {
              localObject2 = new ScrollView(this.MpR);
              this.MvK = new TextView(this.MpR);
              this.MvK.setTextColor(-16777216);
              this.MvK.setBackgroundColor(-1);
              ((ScrollView)localObject2).addView(this.MvK);
              this.MvK.setOnClickListener(new d.12(this));
              gcQ();
              this.MvF.getTopView().addView((View)localObject2);
              continue;
              try
              {
                i = Integer.parseInt(((Uri)localObject5).getQueryParameter("set_grayvalue"));
                XWalkEnvironment.setGrayValueForTest(i);
                dr("灰度值设为" + i % 10000, true);
                bool1 = true;
              }
              catch (Exception localException3)
              {
                dr("灰度值设置失败，参数解析错误", true);
                bool1 = true;
              }
              continue;
              try
              {
                i = Integer.parseInt(((Uri)localObject5).getQueryParameter("set_device_rd_value"));
                XWalkEnvironment.sNDeviceRd = i;
                XWalkEnvironment.getSharedPreferences().edit().putInt("sNDeviceRd", i).commit();
                XWalkEnvironment.setGrayValueForTest(i);
                dr("设备随机灰度值设为" + i % 10000, true);
                bool1 = true;
              }
              catch (Exception localException4)
              {
                dr("设备随机灰度值设置失败，参数解析错误", true);
                bool1 = true;
              }
              continue;
              dr("开始检测浏览器和所有插件更新", true);
              gcW();
              lA(XWalkEnvironment.getApplicationContext());
              continue;
              dr("模拟触发沙箱进程检测浏览器内核更新", true);
              XWalkEnvironment.setConfigFetchPeriod(1800001L);
              w.a(XWalkEnvironment.getApplicationContext(), null);
              new a(this.MpR);
              continue;
              dr("重置上次拉取配置时间", true);
              com.tencent.xweb.xwalk.updater.c.gdu().gdB();
              com.tencent.xweb.xwalk.a.j.Fp(0L);
              continue;
              dr("清理本地的更新计划", true);
              com.tencent.xweb.xwalk.updater.c.gdu().gdv();
              continue;
              try
              {
                String str1 = ((Uri)localObject5).getQueryParameter("set_config_url");
                if ((XWalkEnvironment.isValidConfigHost(str1)) || (y.gaM().gaQ())) {
                  break label1993;
                }
                dr("you have no athority to set this config url:".concat(String.valueOf(str1)), true);
              }
              catch (Exception localException5)
              {
                dr("测试连接设置失败，格式错误", true);
              }
              continue;
              label1993:
              XWalkEnvironment.setTestDownLoadUrl(this.MpR, localException5);
              dr("测试连接设置为:".concat(String.valueOf(localException5)), true);
              continue;
              try
              {
                String str2 = ((Uri)localObject5).getQueryParameter("set_plugin_config_url");
                XWalkEnvironment.setPluginTestConfigUrl(str2);
                dr("插件测试连接设置为:".concat(String.valueOf(str2)), true);
              }
              catch (Exception localException6)
              {
                dr("插件测试连接设置失败，格式错误", true);
              }
              continue;
              Object localObject3 = "";
              try
              {
                localObject4 = ((Uri)localObject5).getQueryParameter("check_plugin_update");
                localObject3 = localObject4;
              }
              catch (Exception localException8)
              {
                for (;;)
                {
                  int k;
                  label2588:
                  label3022:
                  continue;
                  bool2 = bool1;
                  continue;
                  int j = 0;
                  bool1 = bool3;
                }
              }
              if ("all".equalsIgnoreCase((String)localObject3))
              {
                dr("开始检测所有插件更新", true);
                lA(this.MpR);
              }
              else if ("FullScreenVideo".equalsIgnoreCase((String)localObject3))
              {
                cH(this.MpR, "FullScreenVideo");
              }
              else if ("XFilesPDFReader".equalsIgnoreCase((String)localObject3))
              {
                cH(this.MpR, "XFilesPDFReader");
              }
              else if ("XFilesPPTReader".equalsIgnoreCase((String)localObject3))
              {
                cH(this.MpR, "XFilesPPTReader");
              }
              else if ("XFilesWordReader".equalsIgnoreCase((String)localObject3))
              {
                cH(this.MpR, "XFilesWordReader");
              }
              else if ("XFilesExcelReader".equalsIgnoreCase((String)localObject3))
              {
                cH(this.MpR, "XFilesExcelReader");
              }
              else
              {
                dr("检测插件更新失败，参数错误", true);
                continue;
                bool3 = false;
                bool4 = false;
                if (paramString.contains("public.debugxweb.qq.com"))
                {
                  paramString = Uri.parse(paramString).getQueryParameterNames();
                  if ((paramString != null) && (paramString.size() > 0))
                  {
                    paramString = paramString.iterator();
                    while (paramString.hasNext())
                    {
                      localObject3 = (String)paramString.next();
                      if (localObject3 != null) {
                        switch (((String)localObject3).hashCode())
                        {
                        default: 
                          break;
                        case -1157057597: 
                          ((String)localObject3).equals("enable_local_debug");
                        }
                      }
                    }
                  }
                  AppMethodBeat.o(154226);
                  return true;
                }
                XWalkEnvironment.initTurnOnKVLog();
                if ((y.gaM().gaQ()) || (bool4)) {
                  k = 1;
                }
                for (;;)
                {
                  if ((paramString.contains("debugxweb.qq.com")) || (bool4))
                  {
                    localObject3 = Uri.parse(paramString);
                    localObject4 = ((Uri)localObject3).getQueryParameterNames();
                    if ((localObject4 == null) || (((Set)localObject4).size() == 0))
                    {
                      if (k != 0) {
                        gcT();
                      }
                      AppMethodBeat.o(154226);
                      return true;
                      k = 0;
                    }
                    else
                    {
                      localObject4 = ((Set)localObject4).iterator();
                      j = 0;
                      bool1 = bool3;
                      while (((Iterator)localObject4).hasNext())
                      {
                        localObject5 = (String)((Iterator)localObject4).next();
                        if (localObject5 != null)
                        {
                          switch (((String)localObject5).hashCode())
                          {
                          default: 
                            i = -1;
                          }
                          for (;;)
                          {
                            switch (i)
                            {
                            default: 
                              break;
                            case 0: 
                              bool1 = ((Uri)localObject3).getBooleanQueryParameter("inspector", false);
                              y.gaM().zE(bool1);
                              a(bool1, null, true);
                              bool1 = true;
                              break;
                              if (!((String)localObject5).equals("inspector")) {
                                break label2588;
                              }
                              i = 0;
                              continue;
                              if (!((String)localObject5).equals("use_testconfig")) {
                                break label2588;
                              }
                              i = 1;
                              continue;
                              if (!((String)localObject5).equals("kill_all")) {
                                break label2588;
                              }
                              i = 2;
                              continue;
                              if (!((String)localObject5).equals("ignore_crashwatch")) {
                                break label2588;
                              }
                              i = 3;
                              continue;
                              if (!((String)localObject5).equals("save_page")) {
                                break label2588;
                              }
                              i = 4;
                              continue;
                              if (!((String)localObject5).equals("clear_cache")) {
                                break label2588;
                              }
                              i = 5;
                              continue;
                              if (!((String)localObject5).equals("clear_old_ver")) {
                                break label2588;
                              }
                              i = 6;
                              continue;
                              if (!((String)localObject5).equals("fix_dex")) {
                                break label2588;
                              }
                              i = 7;
                              continue;
                              if (!((String)localObject5).equals("clear_all")) {
                                break label2588;
                              }
                              i = 8;
                              continue;
                              if (!((String)localObject5).equals("abandon_curent_ver")) {
                                break label2588;
                              }
                              i = 9;
                            }
                          }
                          bool1 = ((Uri)localObject3).getBooleanQueryParameter("use_testconfig", false);
                          y.gaM().zG(bool1);
                          if (bool1) {
                            dr("使用测试config", true);
                          }
                          for (;;)
                          {
                            bool1 = true;
                            break;
                            dr("使用正式config", true);
                          }
                          j = 1;
                          bool1 = true;
                          continue;
                          bool2 = ((Uri)localObject3).getBooleanQueryParameter("ignore_crashwatch", false);
                          localObject5 = y.gaM();
                          ((y)localObject5).MpZ = bool2;
                          ((y)localObject5).MpR.getSharedPreferences("wcwebview", 0).edit().putBoolean("ignore_crashwatch", bool2).commit();
                          dr("忽略crash检测设为 = ".concat(String.valueOf(bool2)), true);
                          continue;
                          if (!y.gaM().MpW) {}
                          for (bool2 = true;; bool2 = false)
                          {
                            y.gaM().zF(bool2);
                            if (!bool2) {
                              break label3022;
                            }
                            gcP();
                            this.MvL.setVisibility(0);
                            break;
                          }
                          if (this.MvL != null)
                          {
                            this.MvL.setVisibility(8);
                            continue;
                            ah.clearAllWebViewCache(XWalkEnvironment.getApplicationContext(), true);
                            dr("网页cache已经清理:", true);
                            continue;
                            p.K(XWalkEnvironment.getApplicationContext(), true);
                            dr("旧版本已经清理", true);
                            continue;
                            p.gdb();
                            continue;
                            XWalkEnvironment.clearAllVersion(this.MpR);
                            bool1 = true;
                            continue;
                            p.gcZ();
                            bool1 = true;
                          }
                        }
                      }
                      if (k != 0)
                      {
                        if (!dq(paramString, bool4))
                        {
                          bool2 = bool5;
                          if (!bool1) {}
                        }
                        else
                        {
                          bool2 = true;
                        }
                        if (j != 0) {
                          bgm();
                        }
                        AppMethodBeat.o(154226);
                        return bool2;
                      }
                    }
                  }
                }
              }
            }
            break;
          }
        }
        catch (Exception localException7) {}
      }
    }
  }
  
  final void bgm()
  {
    AppMethodBeat.i(154242);
    hH(this.MpR);
    AppMethodBeat.o(154242);
  }
  
  final void dr(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(154248);
    if (paramBoolean) {
      try
      {
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.MpR);
        localBuilder.setMessage(paramString);
        localBuilder.create().show();
        AppMethodBeat.o(154248);
        return;
      }
      catch (Exception paramString)
      {
        Log.i("WebDebugPage", "show alert failed may be in abtets exe " + paramString.getMessage());
        AppMethodBeat.o(154248);
        return;
      }
    }
    Log.e("WebDebugPage", paramString);
    AppMethodBeat.o(154248);
  }
  
  final void ds(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(154249);
    try
    {
      AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.MpR);
      localBuilder.setMessage(paramString);
      localBuilder.create();
      localBuilder.setCancelable(true);
      if (paramBoolean) {
        localBuilder.setOnCancelListener(new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(154207);
            d.this.bgm();
            AppMethodBeat.o(154207);
          }
        });
      }
      localBuilder.show();
      AppMethodBeat.o(154249);
      return;
    }
    catch (Exception paramString)
    {
      Log.i("WebDebugPage", "show alert failed may be in abtets exe " + paramString.getMessage());
      AppMethodBeat.o(154249);
    }
  }
  
  final void f(Button paramButton)
  {
    AppMethodBeat.i(154236);
    int i = this.MvF.getSettings().getForceDarkMode();
    int j = this.MvF.getSettings().getForceDarkBehavior();
    int k = li(i, j);
    if (k == 1)
    {
      paramButton.setText(String.format("当前Dark Mode强制智能反色[%d,%d]（点击切换）", new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
      AppMethodBeat.o(154236);
      return;
    }
    if (k == 2)
    {
      paramButton.setText(String.format("当前Dark Mode不强制智能反色[%d,%d]（点击切换）", new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
      AppMethodBeat.o(154236);
      return;
    }
    if (k == 3)
    {
      paramButton.setText(String.format("当前Light Mode[%d,%d]（点击切换）", new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
      AppMethodBeat.o(154236);
      return;
    }
    if (k == 4) {
      paramButton.setText(String.format("当前未知Mode[%d,%d]（点击切换）", new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
    }
    AppMethodBeat.o(154236);
  }
  
  public final void gbf()
  {
    AppMethodBeat.i(154225);
    if (y.gaM().MpT) {
      a(true, null, false);
    }
    AppMethodBeat.o(154225);
  }
  
  final void gcP()
  {
    AppMethodBeat.i(154228);
    if (!y.gaM().MpW)
    {
      AppMethodBeat.o(154228);
      return;
    }
    if (this.MvL != null)
    {
      AppMethodBeat.o(154228);
      return;
    }
    this.MvL = new Button(this.MpR);
    this.MvL.setText("保存页面");
    this.MvL.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(154152);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/xweb/xwalk/WebDebugPage$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        new AlertDialog.Builder(d.this.MpR).setTitle("保存页面").setMessage("确定保存页面？").setPositiveButton("确定", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(154151);
            paramAnonymous2DialogInterface = d.this;
            Object localObject1 = new Date();
            Object localObject2 = new SimpleDateFormat("yyyy-MM-dd-HH_mm_ss");
            String str = Environment.getExternalStorageDirectory().getPath();
            localObject1 = str + "/xweb_dump/" + ((SimpleDateFormat)localObject2).format((Date)localObject1);
            localObject2 = (String)localObject1 + "/main.html";
            str = (String)localObject1 + "/resource";
            paramAnonymous2DialogInterface.MvF.savePage((String)localObject2, str, 1);
            new Thread(new d.46(paramAnonymous2DialogInterface, (String)localObject1)).start();
            AppMethodBeat.o(154151);
          }
        }).setNegativeButton("取消", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
        }).show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(154152);
      }
    });
    this.MvF.getTopView().addView(this.MvL);
    AppMethodBeat.o(154228);
  }
  
  final void gcQ()
  {
    AppMethodBeat.i(154230);
    if (this.MvK == null)
    {
      AppMethodBeat.o(154230);
      return;
    }
    Object localObject5 = XWalkEnvironment.getXWalkUpdateConfigUrl();
    Object localObject2 = "\n\n" + this.MvF.getAbstractInfo();
    Object localObject1 = localObject2;
    if (com.tencent.xweb.WebView.getCurWebType() != WebView.c.Mqu) {
      localObject1 = (String)localObject2 + "\n xwebsdk is = 200801 apk ver is " + XWalkEnvironment.getAvailableVersion();
    }
    localObject1 = (String)localObject1 + "\n\n current js engine: =  " + JsRuntime.gaB() + "\n prefered js engine =  " + JsRuntime.a(JsRuntime.JsRuntimeType.Mpw, "appbrand", this.MpR) + "\n local gray value = " + XWalkEnvironment.getGrayValue() + "\n local gray device rd value = " + XWalkEnvironment.getDeviceRd() + "\n config url = " + (String)localObject5 + "\n config period(minutes) = " + com.tencent.xweb.xwalk.updater.c.gdu().gdF() / 60000L + "\n\n apilevel = " + Build.VERSION.SDK_INT + "\n device is  " + Build.BRAND + " " + Build.MODEL + "\n usertype is " + XWalkEnvironment.getUserType() + "\n runtime abi is " + XWalkEnvironment.getRuntimeAbi() + "\n device abi is " + XWalkEnvironment.getDeviceAbi() + "\n installed ver for arm32 is " + XWalkEnvironment.getInstalledNewstVersion("armeabi-v7a") + "\n installed ver for arm64 is " + XWalkEnvironment.getInstalledNewstVersion("arm64-v8a") + "\n should embed =  false\n embed lib md5 match =  true\n embed config ver =  0/0\n embed try installed ver =  " + XWalkUpdater.getLastTryInstallVer(XWalkEnvironment.getRuntimeAbi()) + "\n current useragent: " + this.MvF.getSettings().getUserAgentString() + "\n current clientversion: 0x" + Integer.toHexString(XWalkEnvironment.getAppClientVersion()) + "\n current app infos dump : " + XWalkEnvironment.dumpAppInfo();
    localObject2 = (String)localObject1 + "\n\n ------dump module prefer webview core start:------\n";
    localObject1 = localObject2;
    try
    {
      localObject2 = (String)localObject2 + a(this.MpR, WebView.c.Mqv, "tools") + "\n";
      localObject1 = localObject2;
      localObject2 = (String)localObject2 + a(this.MpR, WebView.c.Mqu, "toolsmp") + "\n";
      localObject1 = localObject2;
      localObject2 = (String)localObject2 + a(this.MpR, WebView.c.Mqt, "mm") + "\n";
      localObject1 = localObject2;
      localObject2 = (String)localObject2 + a(this.MpR, WebView.c.Mqu, "appbrand") + "\n";
      localObject1 = localObject2;
      localObject2 = (String)localObject2 + a(this.MpR, WebView.c.Mqu, "support") + "\n";
      localObject1 = localObject2;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        localObject1 = (String)localObject1 + localException1.getMessage() + "\n";
      }
      localObject1 = (String)localObject1 + "\n current update match gap backward(update speed) is " + com.tencent.xweb.xwalk.updater.c.bbD(com.tencent.xweb.xwalk.updater.c.gdu().zT(false));
      localObject1 = (String)localObject1 + "\n current update match gap forward(提前更新) is " + com.tencent.xweb.xwalk.updater.c.bbD(com.tencent.xweb.xwalk.updater.c.gdu().zT(true));
      localObject1 = (String)localObject1 + "\n plugin current update match gap backward(update speed) is " + com.tencent.xweb.xwalk.updater.c.bbD(new a.a("").zT(false));
      localObject1 = (String)localObject1 + "\n plugin current update match gap forward(提前更新) is " + com.tencent.xweb.xwalk.updater.c.bbD(new a.a("").zT(true));
      localObject3 = com.tencent.xweb.a.getAbstractInfo();
      if (localObject3 == null) {
        break label1783;
      }
    }
    localObject1 = (String)localObject1 + "------dump module prefer webview core end------";
    localObject1 = (String)localObject1 + "\n" + com.tencent.xweb.xwalk.updater.c.gdu().gdw();
    localObject2 = com.tencent.xweb.xwalk.a.g.gdm().iterator();
    Object localObject3;
    for (;;)
    {
      if (((Iterator)localObject2).hasNext())
      {
        localObject5 = (com.tencent.xweb.xwalk.a.f)((Iterator)localObject2).next();
        if (localObject5 != null)
        {
          localObject5 = com.tencent.xweb.xwalk.a.a.bbA(((com.tencent.xweb.xwalk.a.f)localObject5).getPluginName());
          localObject1 = (String)localObject1 + "\n" + ((com.tencent.xweb.xwalk.updater.c)localObject5).gdw();
        }
      }
      else if (!((String)localObject3).isEmpty())
      {
        localObject1 = (String)localObject1 + "\n\n ------dump commands start:------\n" + (String)localObject3 + "\n ------dump commands end------";
      }
    }
    label1783:
    for (;;)
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("\n\n ------plugin info start:------\n plugin config url = ").append(XWalkEnvironment.getPluginConfigUrl()).append("\n plugin config period(minutes) = ").append(XWalkEnvironment.getPluginUpdatePeriod() / 60000).append("\n\n plugin version:");
      localObject5 = com.tencent.xweb.xwalk.a.g.gdm().iterator();
      Object localObject6;
      while (((Iterator)localObject5).hasNext())
      {
        localObject6 = (com.tencent.xweb.xwalk.a.f)((Iterator)localObject5).next();
        if (localObject6 != null) {
          ((StringBuilder)localObject3).append("\n ").append(((com.tencent.xweb.xwalk.a.f)localObject6).getPluginName()).append(" = ").append(((com.tencent.xweb.xwalk.a.f)localObject6).MxJ);
        }
      }
      ((StringBuilder)localObject3).append("\n\n plugin commands:");
      localObject5 = com.tencent.xweb.b.getAbstractInfo();
      if ((localObject5 != null) && (!((String)localObject5).isEmpty())) {
        ((StringBuilder)localObject3).append("\n").append((String)localObject5);
      }
      for (;;)
      {
        ((StringBuilder)localObject3).append("\n xfiles setting:");
        if (y.gaM() != null)
        {
          ((StringBuilder)localObject3).append("\n disable cache = ").append(y.gaM().gaN());
          ((StringBuilder)localObject3).append("\n disable crash detect = ").append(y.gaM().gaO());
        }
        ((StringBuilder)localObject3).append(gcU()).append("\n\n ------plugin info end:------");
        localObject6 = (String)localObject1 + ((StringBuilder)localObject3).toString();
        localObject5 = "";
        localObject1 = localObject5;
        try
        {
          SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
          localObject3 = localObject5;
          localObject1 = localObject5;
          if (com.tencent.xweb.xwalk.updater.c.gdu().gdy())
          {
            localObject1 = localObject5;
            String str = localSimpleDateFormat.format(new Date(com.tencent.xweb.xwalk.updater.c.gdu().gdH().MyW));
            localObject1 = localObject5;
            localObject3 = "" + "going to update to apk ver = " + com.tencent.xweb.xwalk.updater.c.gdu().gdH().version;
            localObject1 = localObject3;
            localObject3 = (String)localObject3 + "\n update time is = " + str;
            localObject1 = localObject3;
            localObject5 = new StringBuilder().append((String)localObject3).append("\n is patch update = ");
            localObject1 = localObject3;
            com.tencent.xweb.xwalk.updater.c.gdu();
            localObject1 = localObject3;
            localObject3 = com.tencent.xweb.xwalk.updater.h.gdu().gdH().MyT;
            localObject1 = localObject3;
            localObject3 = (String)localObject3 + "\n can use cellular = " + com.tencent.xweb.xwalk.updater.c.gdu().gdH().Myt;
            localObject1 = localObject3;
            localObject3 = (String)localObject3 + "\n updateHourStart = " + com.tencent.xweb.xwalk.updater.c.gdu().gdH().Mza;
            localObject1 = localObject3;
            localObject3 = (String)localObject3 + "\n updateHourEnd = " + com.tencent.xweb.xwalk.updater.c.gdu().gdH().Mzb;
            localObject1 = localObject3;
            localObject3 = (String)localObject3 + "\n versionId = " + com.tencent.xweb.xwalk.updater.c.gdu().gdH().Myk;
            localObject1 = localObject3;
            localObject3 = (String)localObject3 + "\n update time is = " + str;
            localObject1 = localObject3;
            localObject3 = (String)localObject3 + "\n try count = " + com.tencent.xweb.xwalk.updater.c.gdu().gdH().MyY;
            localObject1 = localObject3;
            localObject3 = (String)localObject3 + "\n try use shared core count = " + com.tencent.xweb.xwalk.updater.c.gdu().gdH().MyZ;
            localObject1 = localObject3;
            localObject3 = (String)localObject3 + "\n";
          }
          localObject1 = localObject3;
          localObject5 = new Date(com.tencent.xweb.xwalk.updater.c.gdu().gdH().MyR);
          localObject1 = localObject3;
          localObject3 = (String)localObject3 + " last fetch config time = " + localSimpleDateFormat.format((Date)localObject5);
          localObject1 = localObject3;
          localObject3 = (String)localObject3 + " last fetch config abi = " + com.tencent.xweb.xwalk.updater.c.gdu().gdH().MyS;
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            Object localObject4 = localObject1;
          }
        }
        localObject1 = localObject6;
        if (localObject3 != null)
        {
          localObject1 = localObject6;
          if (!((String)localObject3).isEmpty()) {
            localObject1 = (String)localObject6 + "\n\n ------dump schedule updateInfo start:------\n" + (String)localObject3 + "\n ------dump schedule updateInfo end------";
          }
        }
        localObject5 = XWalkEnvironment.getXWalkInitializeLog();
        localObject3 = localObject1;
        if (localObject5 != null)
        {
          localObject3 = localObject1;
          if (!((String)localObject5).isEmpty()) {
            localObject3 = (String)localObject1 + "\n\n ------dump xweb log------\n" + (String)localObject5;
          }
        }
        this.MvK.setText((CharSequence)localObject3);
        AppMethodBeat.o(154230);
        return;
        ((StringBuilder)localObject3).append("\n null\n");
      }
    }
  }
  
  final void gcR()
  {
    AppMethodBeat.i(154231);
    if ((!y.gaM().MpU) && ((!y.gaM().MpV) || (this.MvF.getWebCoreType() != WebView.c.Mqv)))
    {
      AppMethodBeat.o(154231);
      return;
    }
    if (this.MvJ != null)
    {
      AppMethodBeat.o(154231);
      return;
    }
    this.MvJ = new TextView(this.MpR);
    this.MvJ.setOnLongClickListener(new d.23(this));
    gcS();
    this.MvF.getTopView().addView(this.MvJ);
    AppMethodBeat.o(154231);
  }
  
  final boolean gcT()
  {
    AppMethodBeat.i(154235);
    b(this.MvF);
    if (this.MvM != null)
    {
      this.MvM.setVisibility(0);
      AppMethodBeat.o(154235);
      return true;
    }
    this.MvM = ((LayoutInflater)this.MpR.getSystemService("layout_inflater")).inflate(2131493685, this.MvF.getTopView(), true).findViewById(2131306436);
    ((Button)this.MvM.findViewById(2131297647)).setOnClickListener(new d.34(this));
    Object localObject1 = (CheckBox)this.MvM.findViewById(2131298267);
    ((CheckBox)localObject1).setChecked(y.gaM().MpU);
    ((CheckBox)localObject1).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(154208);
        paramAnonymousCompoundButton = y.gaM();
        if (paramAnonymousBoolean != paramAnonymousCompoundButton.MpU)
        {
          paramAnonymousCompoundButton.MpU = paramAnonymousBoolean;
          paramAnonymousCompoundButton.MpR.getSharedPreferences("wcwebview", 0).edit().putBoolean("bShowVersion", paramAnonymousCompoundButton.MpU).commit();
        }
        if (paramAnonymousBoolean)
        {
          d.this.gcR();
          d.this.MvJ.setVisibility(0);
          AppMethodBeat.o(154208);
          return;
        }
        if (d.this.MvJ != null) {
          d.this.MvJ.setVisibility(8);
        }
        AppMethodBeat.o(154208);
      }
    });
    ((TextView)this.MvM.findViewById(2131298247)).setOnClickListener(new d.49(this, (CheckBox)localObject1));
    localObject1 = (EditText)this.MvM.findViewById(2131306174);
    if (localObject1 != null)
    {
      ((EditText)localObject1).setInputType(2);
      ((EditText)localObject1).setText(XWalkEnvironment.getGrayValue());
      ((EditText)localObject1).addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(154213);
          paramAnonymousEditable = this.MwA.getText().toString();
          int i = 0;
          try
          {
            int j = Integer.parseInt(paramAnonymousEditable);
            i = j;
          }
          catch (Exception paramAnonymousEditable)
          {
            label25:
            break label25;
          }
          XWalkEnvironment.setGrayValueForTest(i);
          AppMethodBeat.o(154213);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
    }
    ((Spinner)this.MvM.findViewById(2131304547)).setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
    {
      public final void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(154214);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).mr(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).qY(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/xweb/xwalk/WebDebugPage$8", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        paramAnonymousAdapterView = d.this.MpR.getResources().getStringArray(2130903104);
        d.this.MvO = paramAnonymousAdapterView[paramAnonymousInt];
        paramAnonymousAdapterView = d.this;
        paramAnonymousAdapterView.MvN = true;
        if (paramAnonymousAdapterView.MvO.equals("all"))
        {
          paramAnonymousView = paramAnonymousAdapterView.MpR.getResources().getStringArray(2130903103);
          localObject = y.gaM().baY(paramAnonymousView[0]);
          paramAnonymousInt = 1;
          if (paramAnonymousInt < paramAnonymousView.length) {
            if (y.gaM().baY(paramAnonymousView[paramAnonymousInt]) != localObject)
            {
              ((RadioButton)paramAnonymousAdapterView.MvM.findViewById(2131296280)).setChecked(false);
              ((RadioButton)paramAnonymousAdapterView.MvM.findViewById(2131296283)).setChecked(false);
              ((RadioButton)paramAnonymousAdapterView.MvM.findViewById(2131296282)).setChecked(false);
              ((RadioButton)paramAnonymousAdapterView.MvM.findViewById(2131296281)).setChecked(false);
            }
          }
        }
        for (;;)
        {
          paramAnonymousAdapterView.MvN = false;
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$8", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(154214);
          return;
          paramAnonymousInt += 1;
          break;
          paramAnonymousAdapterView.m((WebView.c)localObject);
          continue;
          paramAnonymousAdapterView.m(y.gaM().baY(paramAnonymousAdapterView.MvO));
        }
      }
      
      public final void onNothingSelected(AdapterView<?> paramAnonymousAdapterView) {}
    });
    ((RadioGroup)this.MvM.findViewById(2131306908)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(RadioGroup paramAnonymousRadioGroup, int paramAnonymousInt)
      {
        AppMethodBeat.i(154215);
        if (d.this.MvN)
        {
          AppMethodBeat.o(154215);
          return;
        }
        paramAnonymousRadioGroup = WebView.c.Mqt;
        if (paramAnonymousInt == 2131296280) {
          paramAnonymousRadioGroup = WebView.c.Mqt;
        }
        while (!d.this.MvO.equals("all"))
        {
          y.gaM().a(d.this.MvO, paramAnonymousRadioGroup);
          Log.d("WebDebugPage", "webview change to=".concat(String.valueOf(paramAnonymousRadioGroup)));
          AppMethodBeat.o(154215);
          return;
          if (paramAnonymousInt == 2131296283) {
            paramAnonymousRadioGroup = WebView.c.Mqu;
          } else if (paramAnonymousInt == 2131296282) {
            paramAnonymousRadioGroup = WebView.c.Mqv;
          } else if (paramAnonymousInt == 2131296281) {
            paramAnonymousRadioGroup = WebView.c.Mqw;
          }
        }
        String[] arrayOfString = d.this.MpR.getResources().getStringArray(2130903103);
        paramAnonymousInt = 0;
        while (paramAnonymousInt < arrayOfString.length)
        {
          y.gaM().a(arrayOfString[paramAnonymousInt], paramAnonymousRadioGroup);
          Log.d("WebDebugPage", "webview " + arrayOfString[paramAnonymousInt] + " change to=" + paramAnonymousRadioGroup);
          paramAnonymousInt += 1;
        }
        AppMethodBeat.o(154215);
      }
    });
    switch (48.Mvi[y.gaM().Mqa.ordinal()])
    {
    default: 
      ((RadioGroup)this.MvM.findViewById(2131306258)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
      {
        public final void onCheckedChanged(RadioGroup paramAnonymousRadioGroup, int paramAnonymousInt)
        {
          AppMethodBeat.i(154153);
          paramAnonymousRadioGroup = JsRuntime.JsRuntimeType.Mpw;
          if (paramAnonymousInt == 2131306255) {
            paramAnonymousRadioGroup = JsRuntime.JsRuntimeType.Mpw;
          }
          for (;;)
          {
            y.gaM().a(paramAnonymousRadioGroup);
            Log.d("WebDebugPage", "v8 type change to=".concat(String.valueOf(paramAnonymousRadioGroup)));
            AppMethodBeat.o(154153);
            return;
            if (paramAnonymousInt == 2131306259) {
              paramAnonymousRadioGroup = JsRuntime.JsRuntimeType.Mpx;
            } else if (paramAnonymousInt == 2131306260) {
              paramAnonymousRadioGroup = JsRuntime.JsRuntimeType.MpB;
            } else if (paramAnonymousInt == 2131306257) {
              paramAnonymousRadioGroup = JsRuntime.JsRuntimeType.MpD;
            } else if (paramAnonymousInt == 2131306256) {
              paramAnonymousRadioGroup = JsRuntime.JsRuntimeType.MpE;
            }
          }
        }
      });
      ((Button)this.MvM.findViewById(2131297654)).setOnClickListener(new d.3(this));
      localObject1 = (Button)this.MvM.findViewById(2131297586);
      a(y.gaM().MpT, (Button)localObject1, false);
      ((Button)localObject1).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(154155);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/xweb/xwalk/WebDebugPage$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if (!y.gaM().MpT) {}
          for (boolean bool = true;; bool = false)
          {
            y.gaM().zE(bool);
            d.this.a(bool, this.MvW, true);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(154155);
            return;
          }
        }
      });
      ((Button)this.MvM.findViewById(2131297644)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(154156);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/xweb/xwalk/WebDebugPage$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          XWalkEnvironment.clearAllVersion(d.this.MpR);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(154156);
        }
      });
      ((Button)this.MvM.findViewById(2131297665)).setOnClickListener(new d.6(this));
      ((Button)this.MvM.findViewById(2131297657)).setOnClickListener(new d.7(this));
      localObject1 = (Button)this.MvM.findViewById(2131297649);
      if ((this.MvF.isXWalkKernel()) && (XWalkEnvironment.isCurrentVersionSupportForceDarkMode()))
      {
        ((Button)localObject1).setVisibility(0);
        label502:
        f((Button)localObject1);
        ((Button)localObject1).setOnClickListener(new d.8(this, (Button)localObject1));
        Object localObject2 = (Button)this.MvM.findViewById(2131297648);
        localObject1 = XWalkEnvironment.getXWalkUpdateConfigUrl();
        localObject1 = ((String)localObject1).substring(((String)localObject1).lastIndexOf('/') + 1);
        localObject1 = "(当前为" + (String)localObject1 + ")";
        if (!y.gaM().Mqb) {
          break label1505;
        }
        localObject1 = "使用正式版config".concat(String.valueOf(localObject1));
        label595:
        ((Button)localObject2).setText((CharSequence)localObject1);
        ((Button)localObject2).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(154160);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/xweb/xwalk/WebDebugPage$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
            paramAnonymousView = y.gaM();
            boolean bool;
            if (!y.gaM().Mqb)
            {
              bool = true;
              paramAnonymousView.zG(bool);
              paramAnonymousView = XWalkEnvironment.getXWalkUpdateConfigUrl();
              paramAnonymousView = paramAnonymousView.substring(paramAnonymousView.lastIndexOf('/') + 1);
              paramAnonymousView = "(当前为" + paramAnonymousView + ")";
              localObject = this.MvY;
              if (!y.gaM().Mqb) {
                break label145;
              }
            }
            label145:
            for (paramAnonymousView = "使用正式版config".concat(String.valueOf(paramAnonymousView));; paramAnonymousView = "使用测试config".concat(String.valueOf(paramAnonymousView)))
            {
              ((Button)localObject).setText(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(154160);
              return;
              bool = false;
              break;
            }
          }
        });
        ((Button)this.MvM.findViewById(2131297668)).setOnClickListener(new d.10(this));
        localObject1 = (LinearLayout)this.MvM.findViewById(2131303310);
        ((LinearLayout)localObject1).setVisibility(8);
        localObject2 = (Button)this.MvM.findViewById(2131297663);
        ((Button)localObject2).setText("插件设置");
        ((Button)localObject2).setOnClickListener(new d.11(this, (LinearLayout)localObject1));
        localObject1 = (Button)this.MvM.findViewById(2131297662);
        localObject2 = XWalkEnvironment.getPluginTestConfigUrl();
        if ((localObject2 == null) || (((String)localObject2).isEmpty())) {
          break label1529;
        }
        if (!((String)localObject2).equalsIgnoreCase("https://dldir1.qq.com/weixin/android/wxweb/plugin/pluginUpdateConfig_test.xml")) {
          break label1519;
        }
        ((Button)localObject1).setText("切换插件配置，当前使用默认测试版");
      }
      break;
    }
    for (;;)
    {
      ((Button)localObject1).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(154164);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/xweb/xwalk/WebDebugPage$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          paramAnonymousView = XWalkEnvironment.getPluginTestConfigUrl();
          if ((paramAnonymousView != null) && (!paramAnonymousView.isEmpty())) {
            if (XWalkEnvironment.setPluginTestConfigUrl("")) {
              this.Mwa.setText("切换插件配置，当前使用正式版");
            }
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(154164);
            return;
            d.this.dr("切换失败", true);
            continue;
            if (XWalkEnvironment.setPluginTestConfigUrl("https://dldir1.qq.com/weixin/android/wxweb/plugin/pluginUpdateConfig_test.xml")) {
              this.Mwa.setText("切换插件配置，当前使用默认测试版");
            } else {
              d.this.dr("切换失败", true);
            }
          }
        }
      });
      ((Button)this.MvM.findViewById(2131297669)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(154165);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/xweb/xwalk/WebDebugPage$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          d.lA(d.this.MpR);
          Toast.makeText(d.this.MpR, "开始检测插件更新", 0).show();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(154165);
        }
      });
      ((Button)this.MvM.findViewById(2131297645)).setOnClickListener(new d.15(this));
      ((Spinner)this.MvM.findViewById(2131305151)).setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
      {
        public final void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(154167);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousAdapterView);
          localb.bd(paramAnonymousView);
          localb.mr(paramAnonymousInt);
          localb.qY(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/xweb/xwalk/WebDebugPage$23", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
          paramAnonymousAdapterView = d.this.MpR.getResources().getStringArray(2130903075);
          d.this.MvG = paramAnonymousAdapterView[paramAnonymousInt];
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$23", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(154167);
        }
        
        public final void onNothingSelected(AdapterView<?> paramAnonymousAdapterView) {}
      });
      ((Button)this.MvM.findViewById(2131297659)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(154169);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/xweb/xwalk/WebDebugPage$24", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          d.a(d.this.MpR, d.this.MvG, false, new ValueCallback() {});
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$24", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(154169);
        }
      });
      ((Button)this.MvM.findViewById(2131297660)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(154171);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/xweb/xwalk/WebDebugPage$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          d.a(d.this.MpR, d.this.MvG, true, new ValueCallback() {});
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(154171);
        }
      });
      ((Button)this.MvM.findViewById(2131297670)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(154172);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/xweb/xwalk/WebDebugPage$26", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          d.cH(d.this.MpR, d.this.MvG);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$26", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(154172);
        }
      });
      ((Button)this.MvM.findViewById(2131297646)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(154173);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/xweb/xwalk/WebDebugPage$27", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          paramAnonymousView = com.tencent.xweb.xwalk.a.g.baM(d.this.MvG);
          if (paramAnonymousView == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$27", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(154173);
            return;
          }
          int i = paramAnonymousView.MxJ;
          if (i < 0)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$27", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(154173);
            return;
          }
          localObject = paramAnonymousView.aiK(i);
          paramAnonymousView.aiJ(-1);
          if ((localObject != null) && (!((String)localObject).isEmpty())) {
            com.tencent.xweb.util.c.bbn((String)localObject);
          }
          Toast.makeText(d.this.MpR, "清理完成", 0).show();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$27", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(154173);
        }
      });
      localObject1 = (CheckBox)this.MvM.findViewById(2131298265);
      ((CheckBox)localObject1).setChecked(y.gaM().gaN());
      ((CheckBox)localObject1).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
      {
        public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(154174);
          paramAnonymousCompoundButton = y.gaM().MpR.getSharedPreferences("wcwebview", 4);
          if (paramAnonymousCompoundButton != null)
          {
            paramAnonymousCompoundButton = paramAnonymousCompoundButton.edit();
            if (paramAnonymousCompoundButton != null)
            {
              paramAnonymousCompoundButton.putBoolean("fr_disable_cache", paramAnonymousBoolean);
              paramAnonymousCompoundButton.commit();
              if (paramAnonymousBoolean)
              {
                paramAnonymousCompoundButton = com.tencent.xweb.xwalk.a.g.gdm().iterator();
                while (paramAnonymousCompoundButton.hasNext())
                {
                  Object localObject = (com.tencent.xweb.xwalk.a.f)paramAnonymousCompoundButton.next();
                  if ((localObject instanceof l))
                  {
                    int i = ((com.tencent.xweb.xwalk.a.f)localObject).MxJ;
                    if (i >= 0)
                    {
                      localObject = ((com.tencent.xweb.xwalk.a.f)localObject).aiL(i);
                      if (!((String)localObject).isEmpty()) {
                        com.tencent.xweb.util.c.bbn((String)localObject);
                      }
                    }
                  }
                }
              }
            }
          }
          AppMethodBeat.o(154174);
        }
      });
      localObject1 = (CheckBox)this.MvM.findViewById(2131298266);
      ((CheckBox)localObject1).setChecked(y.gaM().gaO());
      ((CheckBox)localObject1).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
      {
        public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(154175);
          paramAnonymousCompoundButton = y.gaM().MpR.getSharedPreferences("wcwebview", 4);
          if (paramAnonymousCompoundButton != null)
          {
            paramAnonymousCompoundButton = paramAnonymousCompoundButton.edit();
            if (paramAnonymousCompoundButton != null)
            {
              paramAnonymousCompoundButton.putBoolean("fr_disable_crash_detect", paramAnonymousBoolean);
              paramAnonymousCompoundButton.commit();
            }
          }
          AppMethodBeat.o(154175);
        }
      });
      ((TextView)this.MvM.findViewById(2131305730)).setText(gcU());
      localObject1 = (EditText)this.MvM.findViewById(2131299264);
      ((Button)this.MvM.findViewById(2131297652)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(154177);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/xweb/xwalk/WebDebugPage$30", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          d.a(d.this, this.Mwd.getText().toString(), f.a.Mpj);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$30", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(154177);
        }
      });
      ((Button)this.MvM.findViewById(2131297651)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(154178);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/xweb/xwalk/WebDebugPage$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          d.a(d.this, this.Mwd.getText().toString(), f.a.Mpk);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(154178);
        }
      });
      ((Button)this.MvM.findViewById(2131297650)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(154179);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/xweb/xwalk/WebDebugPage$32", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          d.a(d.this, this.Mwd.getText().toString(), f.a.Mpi);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$32", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(154179);
        }
      });
      ((TextView)this.MvM.findViewById(2131306169)).setText(zO(true) + "\n" + XWalkInitializer.getXWalkInitializeLog());
      ((LinearLayout)this.MvM.findViewById(2131298553)).setVisibility(8);
      ((Button)this.MvM.findViewById(2131297643)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(154180);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/xweb/xwalk/WebDebugPage$33", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          XWalkEnvironment.setGrayValueForTest(1);
          if (!XWalkEnvironment.hasAvailableVersion()) {
            if (XWalkEnvironment.isIaDevice()) {
              d.this.bba("http://debugxweb.qq.com/?set_web_config=WV_KIND_CW&set_appbrand_config=WV_KIND_CW&set_config_url=https://dldir1.qq.com/weixin/android/wxweb/updateConfig_x86_test.xml&check_xwalk_update");
            }
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$33", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(154180);
            return;
            d.this.bba("http://debugxweb.qq.com/?set_web_config=WV_KIND_CW&set_appbrand_config=WV_KIND_CW&set_config_url=https://dldir1.qq.com/weixin/android/wxweb/updateConfig_test.xml&check_xwalk_update");
            continue;
            y.gaM().a("tools", WebView.c.Mqu);
            y.gaM().a("toolsmp", WebView.c.Mqu);
            y.gaM().a("appbrand", WebView.c.Mqu);
            y.gaM().a("support", WebView.c.Mqu);
            y.gaM().a("mm", WebView.c.Mqu);
            d.this.ds("已使用XWeb，点任意位置重启进程生效\n", true);
          }
        }
      });
      ((Button)this.MvM.findViewById(2131297642)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(154181);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/xweb/xwalk/WebDebugPage$34", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          y.gaM().a("tools", WebView.c.Mqv);
          y.gaM().a("toolsmp", WebView.c.Mqv);
          y.gaM().a("appbrand", WebView.c.Mqv);
          y.gaM().a("support", WebView.c.Mqv);
          y.gaM().a("mm", WebView.c.Mqv);
          if (com.tencent.xweb.WebView.getInstalledTbsCoreVersion(d.this.MpR) <= 0) {
            d.this.dr("已切换x5，但是x5未ready，点任意位置重启进程生效\n", true);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$34", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(154181);
            return;
            d.this.ds("已使用x5，点任意位置重启进程生效\n", true);
          }
        }
      });
      ((Button)this.MvM.findViewById(2131297641)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(154182);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/xweb/xwalk/WebDebugPage$35", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          y.gaM().a("tools", WebView.c.Mqw);
          y.gaM().a("toolsmp", WebView.c.Mqw);
          y.gaM().a("appbrand", WebView.c.Mqw);
          y.gaM().a("support", WebView.c.Mqw);
          y.gaM().a("mm", WebView.c.Mqw);
          d.this.ds("已使用system，点任意位置重启进程生效\n", true);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$35", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(154182);
        }
      });
      ((Button)this.MvM.findViewById(2131297640)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(154183);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/xweb/xwalk/WebDebugPage$36", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          XWalkEnvironment.setGrayValueForTest(0);
          XWalkEnvironment.setTestDownLoadUrl(d.this.MpR, "");
          y.gaM().a("tools", WebView.c.Mqt);
          y.gaM().a("toolsmp", WebView.c.Mqt);
          y.gaM().a("appbrand", WebView.c.Mqt);
          y.gaM().a("support", WebView.c.Mqt);
          y.gaM().a("mm", WebView.c.Mqt);
          d.this.ds("已使用AUTO，点任意位置重启进程生效\n", true);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$36", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(154183);
        }
      });
      ((Button)this.MvM.findViewById(2131297639)).setOnClickListener(new d.31(this));
      ((Button)this.MvM.findViewById(2131297666)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(154185);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/xweb/xwalk/WebDebugPage$38", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          boolean bool;
          if (!y.gaM().MpW)
          {
            bool = true;
            y.gaM().zF(bool);
            if (!bool) {
              break label97;
            }
            d.this.gcP();
            d.this.MvL.setVisibility(0);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$38", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(154185);
            return;
            bool = false;
            break;
            label97:
            if (d.this.MvL != null) {
              d.this.MvL.setVisibility(8);
            }
          }
        }
      });
      localObject1 = (Button)this.MvM.findViewById(2131297658);
      ((Button)localObject1).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(154186);
          Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/xweb/xwalk/WebDebugPage$39", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
          paramAnonymousView = d.this;
          localObject1 = new com.tencent.xweb.b.h(Environment.getExternalStorageDirectory());
          ((com.tencent.xweb.b.h)localObject1).gbA();
          localObject1 = ((com.tencent.xweb.b.h)localObject1).getPath() + "/xweb_dump";
          try
          {
            localObject2 = new com.tencent.xweb.b.h((String)localObject1);
            localObject3 = ((com.tencent.xweb.b.h)localObject2).gbA();
            if (localObject3.length != 0) {
              break label137;
            }
            paramAnonymousView.dr("web_dump目录下没有.zip文件,请确认应用权限，在权限管理打开应用的读写存储权限", true);
          }
          catch (Exception localException)
          {
            for (;;)
            {
              Object localObject2;
              Object localObject3;
              paramAnonymousView.dr("没有找到web_dump目录,请确认应用权限，在权限管理打开应用的读写存储权限", true);
              continue;
              int i = 0;
              for (;;)
              {
                if (i >= localObject3.length) {
                  break label263;
                }
                if (localObject3[i].getName().endsWith(".zip"))
                {
                  localObject2 = localObject3[i].getAbsolutePath();
                  localObject3 = localObject3[i].getName();
                  new AlertDialog.Builder(paramAnonymousView.MpR).setTitle("提示").setMessage("确定加载:" + (String)localObject3 + "?").setPositiveButton("确定", new d.43(paramAnonymousView, localException, (String)localObject2)).setNegativeButton("取消", new d.42(paramAnonymousView)).show();
                  break;
                }
                i += 1;
              }
              paramAnonymousView.dr("web_dump目录下没有.zip文件", true);
            }
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$39", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(154186);
        }
      });
      ((Button)this.MvM.findViewById(2131297667)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(154188);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/xweb/xwalk/WebDebugPage$40", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          boolean bool;
          if (!y.gaM().Mqc)
          {
            bool = true;
            y.gaM().setShowFps(bool);
            d.b(d.this.MvF);
            if (!bool) {
              break label101;
            }
          }
          label101:
          for (paramAnonymousView = "打开显示fps";; paramAnonymousView = "关闭显示fps")
          {
            d.this.ds(paramAnonymousView, false);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$40", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(154188);
            return;
            bool = false;
            break;
          }
        }
      });
      ((Button)localObject1).setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(154190);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/xweb/xwalk/WebDebugPage$41", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahq());
          new AlertDialog.Builder(d.this.MpR).setTitle("提示").setMessage("清空保存页面文件").setPositiveButton("确定", new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(154189);
              d.b(d.this, Environment.getExternalStorageDirectory() + "/xweb_dump");
              AppMethodBeat.o(154189);
            }
          }).setNegativeButton("取消", new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
          }).show();
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/xweb/xwalk/WebDebugPage$41", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(154190);
          return false;
        }
      });
      ((Button)this.MvM.findViewById(2131297661)).setOnClickListener(this.MvT);
      AppMethodBeat.o(154235);
      return true;
      ((RadioButton)this.MvM.findViewById(2131306255)).setChecked(true);
      break;
      ((RadioButton)this.MvM.findViewById(2131306259)).setChecked(true);
      break;
      ((RadioButton)this.MvM.findViewById(2131306260)).setChecked(true);
      break;
      ((RadioButton)this.MvM.findViewById(2131306257)).setChecked(true);
      break;
      ((RadioButton)this.MvM.findViewById(2131306256)).setChecked(true);
      break;
      ((Button)localObject1).setVisibility(8);
      break label502;
      label1505:
      localObject1 = "使用测试config".concat(String.valueOf(localObject1));
      break label595;
      label1519:
      ((Button)localObject1).setText("切换插件配置, 当前使用自定义测试版");
      continue;
      label1529:
      ((Button)localObject1).setText("切换插件配置，当前使用正式版");
    }
  }
  
  final void gcV()
  {
    AppMethodBeat.i(195552);
    Object localObject = com.tencent.xweb.xwalk.a.g.gdm().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((com.tencent.xweb.xwalk.a.f)((Iterator)localObject).next()).aiJ(-1);
    }
    localObject = XWalkEnvironment.getPluginBaseDir();
    if (((String)localObject).isEmpty())
    {
      AppMethodBeat.o(195552);
      return;
    }
    com.tencent.xweb.util.c.bbn((String)localObject);
    dr("所有插件清理完成", true);
    AppMethodBeat.o(195552);
  }
  
  final void gcW()
  {
    AppMethodBeat.i(154241);
    com.tencent.xweb.xwalk.updater.c.MyI = true;
    com.tencent.xweb.xwalk.updater.c.gdu().gdB();
    com.tencent.xweb.xwalk.updater.c.gdu().gdH().MyR = 100L;
    new c(this.MpR).p(null);
    AppMethodBeat.o(154241);
  }
  
  final void m(WebView.c paramc)
  {
    AppMethodBeat.i(154234);
    switch (48.mFe[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(154234);
      return;
      ((RadioButton)this.MvM.findViewById(2131296280)).setChecked(true);
      AppMethodBeat.o(154234);
      return;
      ((RadioButton)this.MvM.findViewById(2131296283)).setChecked(true);
      AppMethodBeat.o(154234);
      return;
      ((RadioButton)this.MvM.findViewById(2131296282)).setChecked(true);
      AppMethodBeat.o(154234);
      return;
      ((RadioButton)this.MvM.findViewById(2131296281)).setChecked(true);
    }
  }
  
  final String zO(boolean paramBoolean)
  {
    AppMethodBeat.i(154232);
    String str2 = this.MvF.getVersionInfo();
    int i;
    if (!paramBoolean)
    {
      i = str2.indexOf(",apkversion");
      str1 = str2;
      if (i <= 0) {}
    }
    for (String str1 = str2.substring(0, i);; str1 = str2 + ", " + com.tencent.xweb.xwalk.a.g.gdn() + " current process is " + XWalkEnvironment.getProcessName())
    {
      AppMethodBeat.o(154232);
      return str1;
    }
  }
  
  final void zP(final boolean paramBoolean)
  {
    AppMethodBeat.i(154246);
    Object localObject1 = new com.tencent.xweb.b.h(Environment.getExternalStorageDirectory());
    ((com.tencent.xweb.b.h)localObject1).gbA();
    localObject1 = ((com.tencent.xweb.b.h)localObject1).getPath() + "/apkxwebtest";
    Object localObject2;
    try
    {
      localObject1 = new com.tencent.xweb.b.h((String)localObject1);
      localObject2 = ((com.tencent.xweb.b.h)localObject1).gbA();
      if (localObject2.length == 0)
      {
        dr("apkxwebtest目录下没有.zip文件,请确认应用权限，在权限管理打开应用的读写存储权限", true);
        AppMethodBeat.o(154246);
        return;
      }
    }
    catch (Exception localException)
    {
      dr("没有找到apkxwebtest目录,请确认应用权限，在权限管理打开应用的读写存储权限", true);
      AppMethodBeat.o(154246);
      return;
    }
    int i = 0;
    while (i < localObject2.length)
    {
      if (localObject2[i].getName().endsWith(".zip"))
      {
        final String str = localObject2[i].getAbsolutePath();
        localObject2 = localObject2[i].getName();
        if (paramBoolean)
        {
          new AlertDialog.Builder(this.MpR).setTitle("提示").setMessage("确定加载:" + (String)localObject2 + "?").setPositiveButton("确定", new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(154205);
              d.this.G(str, this.Mwv, paramBoolean);
              AppMethodBeat.o(154205);
            }
          }).setNegativeButton("取消", new d.40(this)).show();
          AppMethodBeat.o(154246);
          return;
        }
        G(str, (String)localObject2, paramBoolean);
        AppMethodBeat.o(154246);
        return;
      }
      i += 1;
    }
    dr("apkxwebtest目录下没有.zip文件", true);
    AppMethodBeat.o(154246);
  }
  
  static final class a
    implements s.a
  {
    boolean MwB;
    private ProgressDialog Mwg;
    Context mContext;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(195544);
      this.MwB = false;
      this.mContext = paramContext;
      s.a(this);
      bbz("正在监听更新,点空白区域取消");
      AppMethodBeat.o(195544);
    }
    
    private void bbz(String paramString)
    {
      AppMethodBeat.i(195550);
      if (this.Mwg == null)
      {
        this.Mwg = new ProgressDialog(this.mContext);
        this.Mwg.setProgressStyle(1);
        this.Mwg.setMessage(paramString);
        this.Mwg.setOnCancelListener(new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(195543);
            s.b(d.a.this);
            if (d.a.this.MwB) {
              d.hH(d.a.this.mContext);
            }
            AppMethodBeat.o(195543);
          }
        });
        this.Mwg.setCancelable(true);
        this.Mwg.show();
      }
      this.Mwg.setMessage(paramString);
      AppMethodBeat.o(195550);
    }
    
    public final void bGk()
    {
      AppMethodBeat.i(195545);
      bbz("开始更新");
      AppMethodBeat.o(195545);
    }
    
    public final void bGl()
    {
      AppMethodBeat.i(195548);
      bbz("主配置更新");
      AppMethodBeat.o(195548);
    }
    
    public final void bGm()
    {
      AppMethodBeat.i(195549);
      bbz("插件配置更新");
      AppMethodBeat.o(195549);
    }
    
    public final void xc(int paramInt)
    {
      AppMethodBeat.i(195546);
      if (paramInt == 0) {}
      try
      {
        bbz("更新完成，点任意位置重启进程生效");
        this.MwB = true;
        this.Mwg.setCancelable(true);
        this.Mwg.setCanceledOnTouchOutside(true);
        this.Mwg.setProgress(100);
        AppMethodBeat.o(195546);
        return;
      }
      catch (Exception localException)
      {
        Log.i("WebDebugPage", "may run in background failed to load alert:" + localException.getMessage());
        AppMethodBeat.o(195546);
        return;
      }
      if (paramInt == -5)
      {
        bbz("暂无需要立即更新的版本");
        this.Mwg.setCancelable(true);
        this.Mwg.setCanceledOnTouchOutside(true);
        AppMethodBeat.o(195546);
        return;
      }
      this.Mwg.setCancelable(true);
      this.Mwg.setCanceledOnTouchOutside(true);
      bbz("更新失败, error code = :".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(195546);
    }
    
    public final void xd(int paramInt)
    {
      AppMethodBeat.i(195547);
      try
      {
        bbz("正在下载内核");
        if (this.Mwg != null)
        {
          this.Mwg.setCancelable(false);
          this.Mwg.setProgress(paramInt);
        }
        AppMethodBeat.o(195547);
        return;
      }
      catch (Exception localException)
      {
        Log.i("WebDebugPage", "may run in background failed to load alert:" + localException.getMessage());
        AppMethodBeat.o(195547);
      }
    }
  }
  
  static final class b
    extends XWalkUpdater.UpdateConfig
  {
    String MwD;
    
    private b(int paramInt)
    {
      super(false, paramInt, XWalkEnvironment.getRuntimeAbi(), 0);
      AppMethodBeat.i(154217);
      AppMethodBeat.o(154217);
    }
    
    public b(String paramString1, String paramString2)
    {
      this(i);
      AppMethodBeat.i(154216);
      this.MwD = paramString1;
      this.isMatchMd5 = false;
      this.isPatchUpdate = false;
      this.versionDetail = "local:".concat(String.valueOf(paramString2));
      AppMethodBeat.o(154216);
    }
    
    public final boolean checkValid()
    {
      return true;
    }
  }
  
  final class c
    extends p
  {
    public c(Context paramContext)
    {
      super();
      AppMethodBeat.i(195551);
      new d.a(d.this.MpR);
      AppMethodBeat.o(195551);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d
 * JD-Core Version:    0.7.0.1
 */