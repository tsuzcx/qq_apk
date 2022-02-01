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
  com.tencent.xweb.WebView KFf;
  String KFg;
  ScrollView KFh;
  TextView KFi;
  TextView KFj;
  TextView KFk;
  Button KFl;
  View KFm;
  boolean KFn;
  String KFo;
  private final String KFp;
  private final String KFq;
  private final String KFr;
  private final String KFs;
  private View.OnClickListener KFt;
  Context Kzw;
  
  public d(com.tencent.xweb.WebView paramWebView)
  {
    AppMethodBeat.i(154224);
    this.KFg = "";
    this.KFh = null;
    this.KFi = null;
    this.KFj = null;
    this.KFk = null;
    this.KFl = null;
    this.KFn = false;
    this.KFo = "tools";
    this.KFp = "当前Dark Mode强制智能反色[%d,%d]（点击切换）";
    this.KFq = "当前Dark Mode不强制智能反色[%d,%d]（点击切换）";
    this.KFr = "当前Light Mode[%d,%d]（点击切换）";
    this.KFs = "当前未知Mode[%d,%d]（点击切换）";
    this.KFt = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(154194);
        d.this.KFm.setVisibility(8);
        d.this.KFf.startLongScreenshot(new q()
        {
          public final File getCacheFileDir()
          {
            AppMethodBeat.i(154192);
            File localFile = new File(d.this.Kzw.getExternalCacheDir().getAbsolutePath(), "LongScreenshot");
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
            File localFile = new File(d.this.Kzw.getExternalCacheDir().getAbsolutePath(), "LongScreenshot");
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
        AppMethodBeat.o(154194);
      }
    };
    this.Kzw = paramWebView.getContext();
    this.KFf = paramWebView;
    fLv();
    fLt();
    AppMethodBeat.o(154224);
  }
  
  private void Sq(String paramString)
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
          Sq(paramString + "//" + arrayOfString[i]);
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
    localStringBuilder.append("module: " + paramString + " default " + paramc);
    if (XWalkEnvironment.isIaDevice())
    {
      localStringBuilder.append(", is prefer WV_KIND_SYS because of this is x86 device");
      paramContext = localStringBuilder.toString();
      AppMethodBeat.o(154229);
      return paramContext;
    }
    if (com.tencent.xweb.a.aUt(paramString) != WebView.c.KzY)
    {
      paramc = com.tencent.xweb.a.aUt(paramString);
      localStringBuilder.append("\n   has command type ".concat(String.valueOf(paramc)));
    }
    if (y.fJs().df(paramString, true) != WebView.c.KzY)
    {
      paramc = y.fJs().aUV(paramString);
      localStringBuilder.append("\n   has abtest type ".concat(String.valueOf(paramc)));
    }
    for (int i = 1;; i = 0)
    {
      if (y.fJs().df(paramString, false) != WebView.c.KzY)
      {
        paramContext = y.fJs().aUV(paramString);
        localStringBuilder.append("\n   has hardcode type ".concat(String.valueOf(paramContext)));
        i = j;
      }
      for (;;)
      {
        if ((i == 0) && (paramContext == WebView.c.KzZ) && (XWalkEnvironment.getXWebInitArgs("isgpversion", false)))
        {
          paramContext = WebView.c.KAb;
          localStringBuilder.append("\n   is prefer " + paramContext + " because of gp version");
        }
        for (;;)
        {
          paramc = paramContext;
          if (paramContext == WebView.c.KzZ)
          {
            paramc = paramContext;
            if (!XWalkEnvironment.hasAvailableVersion())
            {
              paramc = WebView.c.KAa;
              localStringBuilder.append("\n   is prefer " + paramc + " because of xwalk is not available");
            }
          }
          com.tencent.xweb.internal.h.d(paramc);
          if (com.tencent.xweb.internal.h.fKq().fKv())
          {
            paramc = WebView.c.KAb;
            localStringBuilder.append("\n   is prefer " + paramc + " because of LoadUrlWatchDog");
          }
          if (com.tencent.xweb.internal.b.c(paramc)) {
            localStringBuilder.append("\n   will not use " + paramc + " because of CrashWatchDog hit");
          }
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
    localh.fKg();
    final com.tencent.xweb.xwalk.a.f localf = com.tencent.xweb.xwalk.a.g.aUJ(paramString);
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
        private ProgressDialog tNC = null;
        
        private Boolean fLB()
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
              if (this.KFM > 0)
              {
                int j = this.KFM;
                i = j;
                if (localf.KHj > 0)
                {
                  localObject1 = localf.agj(localf.KHj);
                  localf.agi(-1);
                  i = j;
                  if (localObject1 != null)
                  {
                    i = j;
                    if (!((String)localObject1).isEmpty())
                    {
                      com.tencent.xweb.util.c.aVj((String)localObject1);
                      i = j;
                    }
                  }
                }
                localSchedulerConfig = new SchedulerConfig();
                localSchedulerConfig.version = i;
                localSchedulerConfig.KIp = false;
                localSchedulerConfig.path = localf.bi(i, false);
                localObject1 = new File(localSchedulerConfig.path);
              }
              try
              {
                if (this.KFO)
                {
                  com.tencent.xweb.util.c.b(this.val$context.getAssets().open(paramString), (File)localObject1);
                  localSchedulerConfig.KHS = com.tencent.xweb.b.i.aKe(((File)localObject1).getPath());
                  localSchedulerConfig.KIx = true;
                  if (localf.a(localSchedulerConfig) != 0) {
                    continue;
                  }
                  AppMethodBeat.o(154202);
                  return Boolean.valueOf(bool);
                  if (localf.KHj < 99999) {
                    continue;
                  }
                  i = localf.KHj;
                  i += 1;
                  continue;
                }
                com.tencent.xweb.b.i.lm(this.KFQ, ((File)localObject1).getPath());
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
          this.tNC = new ProgressDialog(this.val$context);
          this.tNC.setProgressStyle(0);
          this.tNC.setMessage("安装中");
          this.tNC.setCancelable(false);
          this.tNC.setCanceledOnTouchOutside(false);
          this.tNC.setButton(-1, "完成", new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(154200);
              d.39.a(d.39.this).hide();
              AppMethodBeat.o(154200);
            }
          });
          this.tNC.show();
          this.tNC.getButton(-1).setVisibility(8);
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
    //   3: ldc_w 456
    //   6: invokestatic 161	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: ifnull +12 -> 22
    //   13: invokestatic 306	com/tencent/xweb/y:fJs	()Lcom/tencent/xweb/y;
    //   16: getfield 459	com/tencent/xweb/y:KzH	Z
    //   19: ifne +13 -> 32
    //   22: ldc_w 456
    //   25: invokestatic 221	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: ldc 2
    //   30: monitorexit
    //   31: return
    //   32: aload_0
    //   33: invokestatic 461	com/tencent/xweb/xwalk/d:b	(Lcom/tencent/xweb/internal/IWebView;)V
    //   36: ldc_w 456
    //   39: invokestatic 221	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public static boolean aVv(String paramString)
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
      com.tencent.xweb.util.g.Cf(223L);
      Log.e("WebDebugPage", "this url contians debug piece, url =  ".concat(String.valueOf(paramString)));
    }
    AppMethodBeat.o(154252);
    return bool;
  }
  
  /* Error */
  public static void b(com.tencent.xweb.internal.IWebView paramIWebView)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 562
    //   6: invokestatic 161	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: ifnull +12 -> 22
    //   13: invokestatic 306	com/tencent/xweb/y:fJs	()Lcom/tencent/xweb/y;
    //   16: getfield 459	com/tencent/xweb/y:KzH	Z
    //   19: ifne +13 -> 32
    //   22: ldc_w 562
    //   25: invokestatic 221	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: ldc 2
    //   30: monitorexit
    //   31: return
    //   32: aload_0
    //   33: ldc_w 564
    //   36: new 100	com/tencent/xweb/xwalk/d$47
    //   39: dup
    //   40: invokespecial 565	com/tencent/xweb/xwalk/d$47:<init>	()V
    //   43: invokeinterface 571 3 0
    //   48: ldc_w 562
    //   51: invokestatic 221	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public static void cD(Context paramContext, final String paramString)
  {
    AppMethodBeat.i(208912);
    final com.tencent.xweb.xwalk.a.j localj = new com.tencent.xweb.xwalk.a.j();
    localj.a(paramString, new com.tencent.xweb.xwalk.a.i()
    {
      ProgressDialog KFG = null;
      boolean mFinished = false;
      
      public final void afY(int paramAnonymousInt)
      {
        AppMethodBeat.i(154198);
        if ((this.mFinished) || (this.KFG == null))
        {
          AppMethodBeat.o(154198);
          return;
        }
        this.KFG.setProgress(paramAnonymousInt);
        AppMethodBeat.o(154198);
      }
      
      public final void afZ(int paramAnonymousInt)
      {
        AppMethodBeat.i(154199);
        this.mFinished = true;
        if (this.KFG == null)
        {
          AppMethodBeat.o(154199);
          return;
        }
        Object localObject = com.tencent.xweb.xwalk.a.g.aUJ(paramString);
        switch (paramAnonymousInt)
        {
        default: 
          this.KFG.setMessage(paramString + " 更新失败，未知错误，ErrCode = " + paramAnonymousInt);
          if ((this.KFK != null) && (y.fJs() != null))
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
          String str = y.fJs().a((String[])localObject, this.KFK);
          e.ae((String[])localObject);
          Toast.makeText(this.val$context, "格式:" + str + "强制使用" + this.KFK.name() + "打开", 0).show();
          if (this.krE != null) {
            this.krE.onReceiveValue(Integer.valueOf(paramAnonymousInt));
          }
          AppMethodBeat.o(154199);
          return;
          if (localObject != null) {
            this.KFG.setMessage(paramString + " 更新完成，已安装版本" + ((com.tencent.xweb.xwalk.a.f)localObject).KHj);
          }
          for (;;)
          {
            this.KFG.setProgress(100);
            this.KFG.getButton(-2).setVisibility(8);
            this.KFG.getButton(-1).setVisibility(0);
            if (!this.KFJ) {
              break;
            }
            this.KFG.dismiss();
            break;
            this.KFG.setMessage(paramString + " 更新完成");
          }
          this.KFG.setMessage(paramString + " 更新被取消，ErrCode = " + paramAnonymousInt);
          break;
          this.KFG.setMessage(paramString + " 更新失败，无网络，ErrCode = " + paramAnonymousInt);
          break;
          this.KFG.setMessage(paramString + " 更新失败，未到检查时间，ErrCode = " + paramAnonymousInt);
          break;
          this.KFG.setMessage(paramString + " 更新失败，其它任务正在更新插件，ErrCode = " + paramAnonymousInt);
          break;
          this.KFG.setMessage(paramString + " 更新失败，配置下载失败，ErrCode = " + paramAnonymousInt);
          break;
          this.KFG.setMessage(paramString + " 更新失败，配置解析失败，ErrCode = " + paramAnonymousInt);
          break;
          this.KFG.setMessage(paramString + " 更新失败，配置中未包含插件信息，ErrCode = " + paramAnonymousInt);
          break;
          if (localObject != null) {
            this.KFG.setMessage(paramString + " 更新失败，未找到可用更新，当前已安装版本" + ((com.tencent.xweb.xwalk.a.f)localObject).KHj + "，ErrCode = " + paramAnonymousInt);
          }
          while (this.KFJ)
          {
            this.KFG.dismiss();
            break;
            this.KFG.setMessage(paramString + " 更新失败，未找到可用更新，ErrCode = " + paramAnonymousInt);
          }
          this.KFG.setMessage(paramString + " 更新失败，下载安装出错，ErrCode = " + paramAnonymousInt);
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
      
      public final void fJe()
      {
        AppMethodBeat.i(154197);
        this.KFG = new ProgressDialog(this.val$context);
        this.KFG.setProgressStyle(1);
        this.KFG.setMessage(paramString + " 下载更新中");
        this.KFG.setCancelable(false);
        this.KFG.setCanceledOnTouchOutside(false);
        this.KFG.setButton(-2, "取消", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(154195);
            if (!d.38.this.mFinished) {
              d.38.this.KFI.fJr();
            }
            AppMethodBeat.o(154195);
          }
        });
        this.KFG.setButton(-1, "完成", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(154196);
            d.38.this.KFG.dismiss();
            AppMethodBeat.o(154196);
          }
        });
        this.KFG.show();
        this.KFG.getButton(-1).setVisibility(8);
        AppMethodBeat.o(154197);
      }
    });
    paramString = new HashMap();
    paramString.put("UpdaterCheckType", "1");
    localj.a(paramContext, paramString);
    AppMethodBeat.o(208912);
  }
  
  private boolean dl(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(154227);
    if ((paramString.contains("debugxweb.qq.com")) || (paramBoolean))
    {
      Uri localUri = Uri.parse(paramString);
      paramString = localUri.getQueryParameterNames();
      if ((paramString == null) || (paramString.size() == 0))
      {
        fLx();
        AppMethodBeat.o(154227);
        return true;
      }
      Iterator localIterator = paramString.iterator();
      while (localIterator.hasNext())
      {
        paramString = (String)localIterator.next();
        label208:
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
              zc(false);
              break;
              if (!paramString.equals("load_local_xwalk")) {
                break label208;
              }
              i = 0;
              continue;
              if (!paramString.equals("clear_commands")) {
                break label208;
              }
              i = 1;
              continue;
              if (!paramString.equals("wait_debugger")) {
                break label208;
              }
              i = 2;
              continue;
              if (!paramString.equals("debug_process")) {
                break label208;
              }
              i = 3;
              continue;
              if (!paramString.equals("set_apkver")) {
                break label208;
              }
              i = 4;
              continue;
              if (!paramString.equals("check_files")) {
                break label208;
              }
              i = 5;
              continue;
              if (!paramString.equals("revert_to_apk")) {
                break label208;
              }
              i = 6;
              continue;
              if (!paramString.equals("set_config_peroid")) {
                break label208;
              }
              i = 7;
              continue;
              if (!paramString.equals("recheck_cmds")) {
                break label208;
              }
              i = 8;
              continue;
              if (!paramString.equals("set_plugin_config_url")) {
                break label208;
              }
              i = 9;
              continue;
              if (!paramString.equals("check_plugin_update")) {
                break label208;
              }
              i = 10;
              continue;
              if (!paramString.equals("set_force_filereader")) {
                break label208;
              }
              i = 11;
              continue;
              if (!paramString.equals("clear_all_plugin")) {
                break label208;
              }
              i = 12;
            }
          }
          com.tencent.xweb.a.a(null, "0");
          continue;
          paramBoolean = localUri.getBooleanQueryParameter("wait_debugger", false);
          paramString = y.fJs();
          paramString.KzD = paramBoolean;
          paramString.Kzw.getSharedPreferences("wcwebview", 0).edit().putBoolean("bWaitforDebugger", paramBoolean).commit();
          continue;
          paramString = localUri.getQueryParameter("debug_process");
          y.fJs().Kzw.getSharedPreferences("wcwebview", 4).edit().putString("strDebugProcess", paramString).commit();
          continue;
          paramString = localUri.getQueryParameter("set_apkver");
          try
          {
            XWalkEnvironment.setAvailableVersion(Integer.parseInt(paramString), "1.0.".concat(String.valueOf(paramString)), XWalkEnvironment.getRuntimeAbi());
            dn("版本号设置到:" + paramString + " 点击空白处退出重启进程", true);
          }
          catch (Exception paramString)
          {
            dm("设置版本号失败:" + paramString.getMessage(), true);
          }
          continue;
          p.zd(true);
          continue;
          paramString = localUri.getQueryParameter("revert_to_apk");
          try
          {
            i = p.aT(XWalkEnvironment.getApplicationContext(), Integer.parseInt(paramString));
            dn("版本号回滚到:" + i + " 点击空白处退出重启进程", true);
          }
          catch (Exception paramString)
          {
            dm("版本号回滚到失败:" + paramString.getMessage(), true);
          }
          continue;
          paramString = localUri.getQueryParameter("set_config_peroid");
          try
          {
            com.tencent.xweb.a.afX(Integer.parseInt(paramString));
            dn("设置配置拉取周期为:" + paramString + "分钟", false);
          }
          catch (Exception paramString)
          {
            dm("设置配置拉取周期失败:" + paramString.getMessage(), true);
          }
          continue;
          com.tencent.xweb.internal.j.g(WebView.c.KzZ).excute("STR_CMD_SET_RECHECK_COMMAND", null);
          dn("重新跑了一遍命令配置 点击空白处退出重启进程", true);
          continue;
          try
          {
            paramString = localUri.getQueryParameter("set_plugin_config_url");
            XWalkEnvironment.setPluginTestConfigUrl(paramString);
            dm("插件测试连接设置为:".concat(String.valueOf(paramString)), true);
          }
          catch (Exception paramString)
          {
            dm("插件测试连接设置失败，格式错误", true);
          }
          continue;
          paramString = "";
        }
        label1328:
        try
        {
          localObject = localUri.getQueryParameter("check_plugin_update");
          paramString = (String)localObject;
        }
        catch (Exception localException2)
        {
          label1107:
          for (;;)
          {
            Object localObject;
          }
        }
        if ("all".equalsIgnoreCase(paramString))
        {
          dm("开始检测所有插件更新", true);
          lo(this.Kzw);
        }
        else if ("FullScreenVideo".equalsIgnoreCase(paramString))
        {
          cD(this.Kzw, "FullScreenVideo");
        }
        else if ("XFilesPDFReader".equalsIgnoreCase(paramString))
        {
          cD(this.Kzw, "XFilesPDFReader");
        }
        else if ("XFilesPPTReader".equalsIgnoreCase(paramString))
        {
          cD(this.Kzw, "XFilesPPTReader");
        }
        else if ("XFilesWordReader".equalsIgnoreCase(paramString))
        {
          cD(this.Kzw, "XFilesWordReader");
        }
        else if ("XFilesExcelReader".equalsIgnoreCase(paramString))
        {
          cD(this.Kzw, "XFilesExcelReader");
        }
        else
        {
          dm("检测插件更新失败，参数错误", true);
          continue;
          paramString = "";
        }
        try
        {
          localObject = localUri.getQueryParameter("set_force_filereader");
          paramString = (String)localObject;
        }
        catch (Exception localException1)
        {
          String[] arrayOfString;
          break label1107;
        }
        arrayOfString = paramString.split("_");
        if (paramString.length() < 2)
        {
          dm("强制设置文件预览方式失败，参数错误", true);
        }
        else
        {
          paramString = arrayOfString[(arrayOfString.length - 1)];
          if ("xweb".equalsIgnoreCase(paramString)) {
            paramString = f.a.KyN;
          }
          for (;;)
          {
            if ((arrayOfString.length == 2) && ("all".equalsIgnoreCase(arrayOfString[0])))
            {
              localObject = com.tencent.xweb.f.KyK;
              localObject = y.fJs().a((String[])localObject, paramString);
              if (((String)localObject).isEmpty()) {
                break label1328;
              }
              dm("格式:" + (String)localObject + "强制使用" + paramString.name() + "打开", true);
              break;
              if ("x5".equalsIgnoreCase(paramString))
              {
                paramString = f.a.KyO;
              }
              else if ("none".equalsIgnoreCase(paramString))
              {
                paramString = f.a.KyM;
              }
              else
              {
                dm("强制设置文件预览方式失败，类型错误", true);
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
          dm("强制设置文件预览方式失败", true);
          continue;
          fLz();
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
  
  private void fLw()
  {
    AppMethodBeat.i(154233);
    if (this.KFj == null)
    {
      AppMethodBeat.o(154233);
      return;
    }
    String str = zb(false);
    this.KFj.setText(str);
    AppMethodBeat.o(154233);
  }
  
  private static String fLy()
  {
    AppMethodBeat.i(154237);
    Object localObject = new StringBuilder();
    String[] arrayOfString = com.tencent.xweb.f.KyK;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      ((StringBuilder)localObject).append("\n ").append(str).append(": force-").append(y.fJs().aUW(str)).append("  cmd-").append(com.tencent.xweb.b.aUG(str));
      i += 1;
    }
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(154237);
    return localObject;
  }
  
  protected static void hC(Context paramContext)
  {
    AppMethodBeat.i(154243);
    paramContext = (ActivityManager)paramContext.getSystemService("activity");
    int i = Process.myPid();
    int j = Process.myUid();
    paramContext = paramContext.getRunningAppProcesses().iterator();
    while (paramContext.hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
      if ((localRunningAppProcessInfo.uid == j) && (localRunningAppProcessInfo.pid != i))
      {
        String str = localRunningAppProcessInfo.processName;
        if ((str == null) || (!str.contains("com.tencent.mm")) || (localRunningAppProcessInfo.processName.contains("tools")) || (localRunningAppProcessInfo.processName.contains("appbrand")) || (localRunningAppProcessInfo.processName.contains("support"))) {
          Process.killProcess(localRunningAppProcessInfo.pid);
        }
      }
    }
    Process.killProcess(i);
    AppMethodBeat.o(154243);
  }
  
  private static int kT(int paramInt1, int paramInt2)
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
  
  public static void lo(Context paramContext)
  {
    AppMethodBeat.i(154238);
    com.tencent.xweb.xwalk.updater.c.KIe = true;
    com.tencent.xweb.xwalk.a.j localj = new com.tencent.xweb.xwalk.a.j();
    HashMap localHashMap = new HashMap();
    localHashMap.put("UpdaterCheckType", "1");
    localj.a(paramContext, localHashMap);
    AppMethodBeat.o(154238);
  }
  
  final void G(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(154247);
    a locala = new a(paramString1, paramString2);
    try
    {
      Object localObject = new com.tencent.xweb.b.h(XWalkEnvironment.getDownloadZipDir(locala.apkVer));
      if (((com.tencent.xweb.b.h)localObject).exists()) {
        ((com.tencent.xweb.b.h)localObject).delete();
      }
      paramString1 = com.tencent.xweb.b.i.openRead(paramString1);
      localObject = com.tencent.xweb.b.i.zA(((com.tencent.xweb.b.h)localObject).getAbsolutePath());
      byte[] arrayOfByte = new byte[1048576];
      for (;;)
      {
        int i = paramString1.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        ((OutputStream)localObject).write(arrayOfByte, 0, i);
      }
      dm("安装" + paramString2 + "失败,错误码=" + paramString1, true);
    }
    catch (IOException paramString1)
    {
      for (;;)
      {
        paramString1 = XWalkUpdater.onHandleFile(locala);
        if (paramString1.intValue() != 0) {
          break;
        }
        dm("安装" + paramString2 + "成功", paramBoolean);
        AppMethodBeat.o(154247);
        return;
        ((OutputStream)localObject).flush();
        paramString1.close();
        ((OutputStream)localObject).close();
      }
    }
    catch (Exception paramString1)
    {
      dm("安装失败", true);
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
          com.tencent.smtt.sdk.WebView.setWebContentsDebuggingEnabled(paramBoolean1);
          label29:
          if ((paramBoolean2) && (this.KFf.getX5WebViewExtension() != null))
          {
            if (!paramBoolean1) {
              break label79;
            }
            this.KFf.loadUrl("http://debugx5.qq.com/?inspector=true");
          }
          while (paramButton != null) {
            if (paramBoolean1)
            {
              paramButton.setText("关闭远程调试模式(当前已打开)");
              AppMethodBeat.o(154244);
              return;
              label79:
              this.KFf.loadUrl("http://debugx5.qq.com/?inspector=false");
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
  
  public final boolean aUX(String paramString)
  {
    boolean bool5 = false;
    AppMethodBeat.i(154226);
    if (paramString == null)
    {
      AppMethodBeat.o(154226);
      return false;
    }
    Object localObject1;
    Object localObject2;
    boolean bool1;
    boolean bool2;
    if ((paramString.contains("debugmm.qq.com")) || (paramString.contains("debugxweb.qq.com")))
    {
      com.tencent.xweb.util.g.Cf(224L);
      localObject1 = Uri.parse(paramString);
      localObject2 = ((Uri)localObject1).getQueryParameterNames();
      if ((localObject2 != null) && (((Set)localObject2).size() > 0))
      {
        localObject2 = ((Set)localObject2).iterator();
        bool1 = false;
        bool2 = false;
      }
    }
    for (;;)
    {
      boolean bool3 = bool1;
      boolean bool4 = bool2;
      int i;
      if (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = (String)((Iterator)localObject2).next();
        if (localObject3 != null) {
          switch (((String)localObject3).hashCode())
          {
          default: 
            i = -1;
            switch (i)
            {
            default: 
              break;
            case 0: 
              if (((Uri)localObject1).getBooleanQueryParameter("forcex5", false))
              {
                y.fJs().a("tools", WebView.c.KAa);
                y.fJs().a("appbrand", WebView.c.KAa);
                y.fJs().a("support", WebView.c.KAa);
                y.fJs().a("mm", WebView.c.KAa);
                y.fJs().a("toolsmp", WebView.c.KAa);
                y.fJs().a(JsRuntime.JsRuntimeType.Kzg);
                dn("force use x5 switch is on ", true);
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
            for (;;)
            {
              label286:
              AppMethodBeat.o(154226);
              return true;
              if (!((String)localObject3).equals("forcex5")) {
                break;
              }
              i = 0;
              break label286;
              if (!((String)localObject3).equals("inspector")) {
                break;
              }
              i = 1;
              break label286;
              if (!((String)localObject3).equals("ticket")) {
                break;
              }
              i = 2;
              break label286;
              if (!((String)localObject3).equals("show_x5_ver")) {
                break;
              }
              i = 3;
              break label286;
              if (!((String)localObject3).equals("encrpt_url")) {
                break;
              }
              i = 4;
              break label286;
              if (!((String)localObject3).equals("clear_test_setting")) {
                break;
              }
              i = 5;
              break label286;
              if (!((String)localObject3).equals("show_fps")) {
                break;
              }
              i = 6;
              break label286;
              if (!((String)localObject3).equals("set_mm_config")) {
                break;
              }
              i = 7;
              break label286;
              if (!((String)localObject3).equals("set_web_config")) {
                break;
              }
              i = 8;
              break label286;
              if (!((String)localObject3).equals("set_appbrand_config")) {
                break;
              }
              i = 9;
              break label286;
              if (!((String)localObject3).equals("show_webview_version")) {
                break;
              }
              i = 10;
              break label286;
              if (!((String)localObject3).equals("set_grayvalue")) {
                break;
              }
              i = 11;
              break label286;
              if (!((String)localObject3).equals("set_device_rd_value")) {
                break;
              }
              i = 12;
              break label286;
              if (!((String)localObject3).equals("check_xwalk_update")) {
                break;
              }
              i = 13;
              break label286;
              if (!((String)localObject3).equals("soft_check_xwalk_update")) {
                break;
              }
              i = 14;
              break label286;
              if (!((String)localObject3).equals("clear_config_time_stamp")) {
                break;
              }
              i = 15;
              break label286;
              if (!((String)localObject3).equals("clear_schedule")) {
                break;
              }
              i = 16;
              break label286;
              if (!((String)localObject3).equals("set_config_url")) {
                break;
              }
              i = 17;
              break label286;
              y.fJs().a("tools", WebView.c.KzY);
              y.fJs().a("appbrand", WebView.c.KzY);
              y.fJs().a("support", WebView.c.KzY);
              y.fJs().a("mm", WebView.c.KzY);
              y.fJs().a("toolsmp", WebView.c.KzY);
              y.fJs().a(JsRuntime.JsRuntimeType.Kzb);
              dn("force use x5 switch is off ", true);
            }
            bool1 = ((Uri)localObject1).getBooleanQueryParameter("inspector", false);
            y.fJs().yR(bool1);
            a(bool1, null, true);
            AppMethodBeat.o(154226);
            return true;
            localObject3 = ((Uri)localObject1).getQueryParameter("ticket");
            String str2 = ((Uri)localObject1).toString();
            if ((TextUtils.isEmpty(str2)) || (TextUtils.isEmpty((CharSequence)localObject3))) {
              bool2 = false;
            }
            for (;;)
            {
              if (bool2) {
                break label1051;
              }
              dm("权限校验失败", true);
              Log.e("WebDebugPage", "checkTempPerssion failed");
              break;
              str2 = str2.trim();
              i = str2.lastIndexOf("ticket");
              if ((i < 0) || (i >= str2.length()))
              {
                bool2 = false;
              }
              else
              {
                str2 = str2.substring(0, i);
                String str3 = new SimpleDateFormat("yyyyMMdd").format(new Date());
                bool2 = com.tencent.xweb.util.b.be(str2 + "@check_permission@" + str3, (String)localObject3, "MHYwEAYHKoZIzj0CAQYFK4EEACIDYgAE4s7oy+BvW5kzf5PwtVqDdZb2rVQS7GDf\naJWwtkD95ILDQAtHM9Nv5apLYQnUbXkjTldOUpjK7MimTkf/qXjQfk8hF2A0Mf7L\nHbDPr7kD9DOuQlG53SWOuKQVEwwsjN1l");
              }
            }
            label1051:
            Log.i("WebDebugPage", "checkTempPerssion suc");
            continue;
            bool1 = ((Uri)localObject1).getBooleanQueryParameter("show_x5_ver", false);
            paramString = y.fJs();
            if (bool1 != paramString.KzA)
            {
              paramString.KzA = bool1;
              paramString.Kzw.getSharedPreferences("wcwebview", 0).edit().putBoolean("bShowX5Version", paramString.KzA).commit();
            }
            if (bool1) {
              dm("开启显示x5内核信息", true);
            }
            for (;;)
            {
              AppMethodBeat.o(154226);
              return true;
              dm("关闭显示x5内核信息", true);
            }
            paramString = ((Uri)localObject1).getQueryParameter("encrpt_url");
            try
            {
              paramString = com.tencent.xweb.util.a.a(paramString, com.tencent.xweb.util.a.aVh("b01d4598de5875eb9b86abdef32b811e9c55edcfb1673b5617cc0a6ab7dceaff"));
              if (TextUtils.isEmpty(paramString))
              {
                dm("解密失败", true);
                AppMethodBeat.o(154226);
                return true;
              }
              aUX(paramString);
            }
            catch (Throwable paramString)
            {
              for (;;)
              {
                dm("解密失败", true);
              }
            }
            AppMethodBeat.o(154226);
            return true;
            p.lq(XWalkEnvironment.getApplicationContext());
            AppMethodBeat.o(154226);
            return true;
            bool1 = ((Uri)localObject1).getBooleanQueryParameter("show_fps", false);
            y.fJs().setShowFps(bool1);
            AppMethodBeat.o(154226);
            return true;
            try
            {
              localObject3 = WebView.c.valueOf(((Uri)localObject1).getQueryParameter("set_mm_config"));
              y.fJs().a("mm", (WebView.c)localObject3);
              dm("mm进程将使用:".concat(String.valueOf(localObject3)), true);
            }
            catch (Exception localException1) {}
            continue;
            try
            {
              WebView.c localc = WebView.c.valueOf(((Uri)localObject1).getQueryParameter("set_web_config"));
              y.fJs().a("tools", localc);
              y.fJs().a("toolsmp", localc);
              dm("打开网页将使用:".concat(String.valueOf(localc)), true);
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
          Object localObject4 = WebView.c.valueOf(((Uri)localObject1).getQueryParameter("set_appbrand_config"));
          y.fJs().a("appbrand", (WebView.c)localObject4);
          y.fJs().a("support", (WebView.c)localObject4);
          switch (48.meK[localObject4.ordinal()])
          {
          case 1: 
            y.fJs().a(JsRuntime.JsRuntimeType.Kzj);
            dm("打开小程序将使用:".concat(String.valueOf(localObject4)), true);
            break;
          case 2: 
            y.fJs().a(JsRuntime.JsRuntimeType.Kzg);
            dm("打开小程序将使用:".concat(String.valueOf(localObject4)), true);
            break;
          case 3: 
            y.fJs().a(JsRuntime.JsRuntimeType.Kzj);
            dm("打开小程序将使用:".concat(String.valueOf(localObject4)), true);
            continue;
            if (this.KFk == null)
            {
              localObject4 = new ScrollView(this.Kzw);
              this.KFk = new TextView(this.Kzw);
              this.KFk.setTextColor(-16777216);
              this.KFk.setBackgroundColor(-1);
              ((ScrollView)localObject4).addView(this.KFk);
              this.KFk.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(154163);
                  d.this.fLu();
                  AppMethodBeat.o(154163);
                }
              });
              fLu();
              this.KFf.getTopView().addView((View)localObject4);
              continue;
              try
              {
                i = Integer.parseInt(((Uri)localObject1).getQueryParameter("set_grayvalue"));
                XWalkEnvironment.setGrayValueForTest(i);
                dm("灰度值设为" + i % 10000, true);
                bool1 = true;
              }
              catch (Exception localException3)
              {
                dm("灰度值设置失败，参数解析错误", true);
                bool1 = true;
              }
              continue;
              try
              {
                i = Integer.parseInt(((Uri)localObject1).getQueryParameter("set_device_rd_value"));
                XWalkEnvironment.sNDeviceRd = i;
                XWalkEnvironment.getSharedPreferences().edit().putInt("sNDeviceRd", i).commit();
                XWalkEnvironment.setGrayValueForTest(i);
                dm("设备随机灰度值设为" + i % 10000, true);
                bool1 = true;
              }
              catch (Exception localException4)
              {
                dm("设备随机灰度值设置失败，参数解析错误", true);
                bool1 = true;
              }
              continue;
              dm("开始检测浏览器和所有插件更新", true);
              fLA();
              lo(XWalkEnvironment.getApplicationContext());
              continue;
              dm("模拟触发沙箱进程检测浏览器内核更新", true);
              XWalkEnvironment.setConfigFetchPeriod(1800001L);
              w.a(XWalkEnvironment.getApplicationContext(), null);
              continue;
              dm("重置上次拉取配置时间", true);
              com.tencent.xweb.xwalk.updater.c.fLZ().fMg();
              com.tencent.xweb.xwalk.a.j.Cn(0L);
              continue;
              dm("清理本地的更新计划", true);
              com.tencent.xweb.xwalk.updater.c.fLZ().fMa();
              continue;
              try
              {
                String str1 = ((Uri)localObject1).getQueryParameter("set_config_url");
                if ((XWalkEnvironment.isValidConfigHost(str1)) || (y.fJs().fJw())) {
                  break label1921;
                }
                dm("you have no athority to set this config url:".concat(String.valueOf(str1)), true);
              }
              catch (Exception localException5)
              {
                dm("测试连接设置失败，格式错误", true);
              }
              continue;
              label1921:
              XWalkEnvironment.setTestDownLoadUrl(this.Kzw, localException5);
              dm("测试连接设置为:".concat(String.valueOf(localException5)), true);
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
                    localObject1 = (String)paramString.next();
                    if (localObject1 != null) {
                      switch (((String)localObject1).hashCode())
                      {
                      default: 
                        break;
                      case -1157057597: 
                        ((String)localObject1).equals("enable_local_debug");
                      }
                    }
                  }
                }
                AppMethodBeat.o(154226);
                return true;
              }
              XWalkEnvironment.initTurnOnKVLog();
              int k;
              if ((y.fJs().fJw()) || (bool4)) {
                k = 1;
              }
              int j;
              while ((paramString.contains("debugxweb.qq.com")) || (bool4))
              {
                localObject1 = Uri.parse(paramString);
                localObject2 = ((Uri)localObject1).getQueryParameterNames();
                if ((localObject2 == null) || (((Set)localObject2).size() == 0))
                {
                  if (k != 0) {
                    fLx();
                  }
                  AppMethodBeat.o(154226);
                  return true;
                  k = 0;
                }
                else
                {
                  localObject2 = ((Set)localObject2).iterator();
                  j = 0;
                  bool1 = bool3;
                  while (((Iterator)localObject2).hasNext())
                  {
                    Object localObject5 = (String)((Iterator)localObject2).next();
                    if (localObject5 != null)
                    {
                      switch (((String)localObject5).hashCode())
                      {
                      default: 
                        label2288:
                        i = -1;
                      }
                      for (;;)
                      {
                        switch (i)
                        {
                        default: 
                          break;
                        case 0: 
                          bool1 = ((Uri)localObject1).getBooleanQueryParameter("inspector", false);
                          y.fJs().yR(bool1);
                          a(bool1, null, true);
                          bool1 = true;
                          break;
                          if (!((String)localObject5).equals("inspector")) {
                            break label2288;
                          }
                          i = 0;
                          continue;
                          if (!((String)localObject5).equals("use_testconfig")) {
                            break label2288;
                          }
                          i = 1;
                          continue;
                          if (!((String)localObject5).equals("kill_all")) {
                            break label2288;
                          }
                          i = 2;
                          continue;
                          if (!((String)localObject5).equals("ignore_crashwatch")) {
                            break label2288;
                          }
                          i = 3;
                          continue;
                          if (!((String)localObject5).equals("save_page")) {
                            break label2288;
                          }
                          i = 4;
                          continue;
                          if (!((String)localObject5).equals("clear_cache")) {
                            break label2288;
                          }
                          i = 5;
                          continue;
                          if (!((String)localObject5).equals("clear_old_ver")) {
                            break label2288;
                          }
                          i = 6;
                          continue;
                          if (!((String)localObject5).equals("fix_dex")) {
                            break label2288;
                          }
                          i = 7;
                          continue;
                          if (!((String)localObject5).equals("clear_all")) {
                            break label2288;
                          }
                          i = 8;
                          continue;
                          if (!((String)localObject5).equals("abandon_curent_ver")) {
                            break label2288;
                          }
                          i = 9;
                        }
                      }
                      bool1 = ((Uri)localObject1).getBooleanQueryParameter("use_testconfig", false);
                      y.fJs().yT(bool1);
                      if (bool1) {
                        dm("使用测试config", true);
                      }
                      for (;;)
                      {
                        bool1 = true;
                        break;
                        dm("使用正式config", true);
                      }
                      j = 1;
                      bool1 = true;
                      continue;
                      bool2 = ((Uri)localObject1).getBooleanQueryParameter("ignore_crashwatch", false);
                      localObject5 = y.fJs();
                      ((y)localObject5).KzE = bool2;
                      ((y)localObject5).Kzw.getSharedPreferences("wcwebview", 0).edit().putBoolean("ignore_crashwatch", bool2).commit();
                      dm("忽略crash检测设为 = ".concat(String.valueOf(bool2)), true);
                      continue;
                      if (!y.fJs().KzB) {}
                      for (bool2 = true;; bool2 = false)
                      {
                        y.fJs().yS(bool2);
                        if (!bool2) {
                          break label2722;
                        }
                        fLt();
                        this.KFl.setVisibility(0);
                        break;
                      }
                      label2722:
                      if (this.KFl != null)
                      {
                        this.KFl.setVisibility(8);
                        continue;
                        ah.clearAllWebViewCache(XWalkEnvironment.getApplicationContext(), true);
                        dm("网页cache已经清理:", true);
                        continue;
                        p.I(XWalkEnvironment.getApplicationContext(), true);
                        dm("旧版本已经清理", true);
                        continue;
                        p.fLF();
                        continue;
                        XWalkEnvironment.clearAllVersion(this.Kzw);
                        bool1 = true;
                        continue;
                        p.fLD();
                        bool1 = true;
                      }
                    }
                  }
                }
              }
              for (;;)
              {
                if (k != 0) {
                  if (!dl(paramString, bool4))
                  {
                    bool2 = bool5;
                    if (!bool1) {
                      break label2833;
                    }
                  }
                }
                for (bool2 = true;; bool2 = bool1)
                {
                  label2833:
                  if (j != 0) {
                    bcI();
                  }
                  AppMethodBeat.o(154226);
                  return bool2;
                }
                j = 0;
                bool1 = bool3;
              }
            }
            break;
          }
        }
        catch (Exception localException6) {}
      }
    }
  }
  
  final void bcI()
  {
    AppMethodBeat.i(154242);
    hC(this.Kzw);
    AppMethodBeat.o(154242);
  }
  
  final void dm(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(154248);
    if (paramBoolean) {
      try
      {
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.Kzw);
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
  
  final void dn(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(154249);
    try
    {
      AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.Kzw);
      localBuilder.setMessage(paramString);
      localBuilder.create();
      localBuilder.setCancelable(true);
      if (paramBoolean) {
        localBuilder.setOnCancelListener(new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(154207);
            d.this.bcI();
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
    int i = this.KFf.getSettings().getForceDarkMode();
    int j = this.KFf.getSettings().getForceDarkBehavior();
    int k = kT(i, j);
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
  
  public final void fJL()
  {
    AppMethodBeat.i(154225);
    if (y.fJs().Kzy) {
      a(true, null, false);
    }
    AppMethodBeat.o(154225);
  }
  
  final void fLA()
  {
    AppMethodBeat.i(154241);
    com.tencent.xweb.xwalk.updater.c.KIe = true;
    com.tencent.xweb.xwalk.updater.c.fLZ().fMg();
    com.tencent.xweb.xwalk.updater.c.fLZ().fMm().KIn = 100L;
    new b(this.Kzw).p(null);
    AppMethodBeat.o(154241);
  }
  
  final void fLt()
  {
    AppMethodBeat.i(154228);
    if (!y.fJs().KzB)
    {
      AppMethodBeat.o(154228);
      return;
    }
    if (this.KFl != null)
    {
      AppMethodBeat.o(154228);
      return;
    }
    this.KFl = new Button(this.Kzw);
    this.KFl.setText("保存页面");
    this.KFl.setOnClickListener(new d.1(this));
    this.KFf.getTopView().addView(this.KFl);
    AppMethodBeat.o(154228);
  }
  
  final void fLu()
  {
    AppMethodBeat.i(154230);
    if (this.KFk == null)
    {
      AppMethodBeat.o(154230);
      return;
    }
    Object localObject5 = XWalkEnvironment.getXWalkUpdateConfigUrl();
    Object localObject2 = "\n\n" + this.KFf.getAbstractInfo();
    Object localObject1 = localObject2;
    if (com.tencent.xweb.WebView.getCurWebType() != WebView.c.KzZ) {
      localObject1 = (String)localObject2 + "\n xwebsdk is = 200601 apk ver is " + XWalkEnvironment.getAvailableVersion();
    }
    localObject1 = (String)localObject1 + "\n\n current js engine: =  " + JsRuntime.fJf() + "\n prefered js engine =  " + JsRuntime.a(JsRuntime.JsRuntimeType.Kzb, "appbrand", this.Kzw) + "\n local gray value = " + XWalkEnvironment.getGrayValue() + "\n local gray device rd value = " + XWalkEnvironment.getDeviceRd() + "\n config url = " + (String)localObject5 + "\n config period(minutes) = " + com.tencent.xweb.xwalk.updater.c.fLZ().fMk() / 60000L + "\n\n apilevel = " + Build.VERSION.SDK_INT + "\n device is  " + Build.BRAND + " " + Build.MODEL + "\n usertype is " + XWalkEnvironment.getUserType() + "\n runtime abi is " + XWalkEnvironment.getRuntimeAbi() + "\n device abi is " + XWalkEnvironment.getDeviceAbi() + "\n installed ver for arm32 is " + XWalkEnvironment.getInstalledNewstVersion("armeabi-v7a") + "\n installed ver for arm64 is " + XWalkEnvironment.getInstalledNewstVersion("arm64-v8a") + "\n should embed =  false\n embed lib md5 match =  true\n embed config ver =  0/0\n embed try installed ver =  " + XWalkUpdater.getLastTryInstallVer(XWalkEnvironment.getRuntimeAbi()) + "\n current useragent: " + this.KFf.getSettings().getUserAgentString() + "\n current clientversion: 0x" + Integer.toHexString(XWalkEnvironment.getAppClientVersion()) + "\n current app infos dump : " + XWalkEnvironment.dumpAppInfo();
    localObject2 = (String)localObject1 + "\n\n ------dump module prefer webview core start:------\n";
    localObject1 = localObject2;
    try
    {
      localObject2 = (String)localObject2 + a(this.Kzw, WebView.c.KAa, "tools") + "\n";
      localObject1 = localObject2;
      localObject2 = (String)localObject2 + a(this.Kzw, WebView.c.KzZ, "toolsmp") + "\n";
      localObject1 = localObject2;
      localObject2 = (String)localObject2 + a(this.Kzw, WebView.c.KzY, "mm") + "\n";
      localObject1 = localObject2;
      localObject2 = (String)localObject2 + a(this.Kzw, WebView.c.KzZ, "appbrand") + "\n";
      localObject1 = localObject2;
      localObject2 = (String)localObject2 + a(this.Kzw, WebView.c.KzZ, "support") + "\n";
      localObject1 = localObject2;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        localObject1 = (String)localObject1 + localException1.getMessage() + "\n";
      }
      localObject1 = (String)localObject1 + "\n current update match gap backward(update speed) is " + com.tencent.xweb.xwalk.updater.c.aVA(com.tencent.xweb.xwalk.updater.c.fLZ().ze(false));
      localObject1 = (String)localObject1 + "\n current update match gap forward(提前更新) is " + com.tencent.xweb.xwalk.updater.c.aVA(com.tencent.xweb.xwalk.updater.c.fLZ().ze(true));
      localObject1 = (String)localObject1 + "\n plugin current update match gap backward(update speed) is " + com.tencent.xweb.xwalk.updater.c.aVA(new a.a("").ze(false));
      localObject1 = (String)localObject1 + "\n plugin current update match gap forward(提前更新) is " + com.tencent.xweb.xwalk.updater.c.aVA(new a.a("").ze(true));
      localObject3 = com.tencent.xweb.a.getAbstractInfo();
      if (localObject3 == null) {
        break label1783;
      }
    }
    localObject1 = (String)localObject1 + "------dump module prefer webview core end------";
    localObject1 = (String)localObject1 + "\n" + com.tencent.xweb.xwalk.updater.c.fLZ().fMb();
    localObject2 = com.tencent.xweb.xwalk.a.g.fLR().iterator();
    Object localObject3;
    for (;;)
    {
      if (((Iterator)localObject2).hasNext())
      {
        localObject5 = (com.tencent.xweb.xwalk.a.f)((Iterator)localObject2).next();
        if (localObject5 != null)
        {
          localObject5 = com.tencent.xweb.xwalk.a.a.aVx(((com.tencent.xweb.xwalk.a.f)localObject5).getPluginName());
          localObject1 = (String)localObject1 + "\n" + ((com.tencent.xweb.xwalk.updater.c)localObject5).fMb();
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
      localObject5 = com.tencent.xweb.xwalk.a.g.fLR().iterator();
      Object localObject6;
      while (((Iterator)localObject5).hasNext())
      {
        localObject6 = (com.tencent.xweb.xwalk.a.f)((Iterator)localObject5).next();
        if (localObject6 != null) {
          ((StringBuilder)localObject3).append("\n ").append(((com.tencent.xweb.xwalk.a.f)localObject6).getPluginName()).append(" = ").append(((com.tencent.xweb.xwalk.a.f)localObject6).KHj);
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
        if (y.fJs() != null)
        {
          ((StringBuilder)localObject3).append("\n disable cache = ").append(y.fJs().fJt());
          ((StringBuilder)localObject3).append("\n disable crash detect = ").append(y.fJs().fJu());
        }
        ((StringBuilder)localObject3).append(fLy()).append("\n\n ------plugin info end:------");
        localObject6 = (String)localObject1 + ((StringBuilder)localObject3).toString();
        localObject5 = "";
        localObject1 = localObject5;
        try
        {
          SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
          localObject3 = localObject5;
          localObject1 = localObject5;
          if (com.tencent.xweb.xwalk.updater.c.fLZ().fMd())
          {
            localObject1 = localObject5;
            String str = localSimpleDateFormat.format(new Date(com.tencent.xweb.xwalk.updater.c.fLZ().fMm().KIr));
            localObject1 = localObject5;
            localObject3 = "" + "going to update to apk ver = " + com.tencent.xweb.xwalk.updater.c.fLZ().fMm().version;
            localObject1 = localObject3;
            localObject3 = (String)localObject3 + "\n update time is = " + str;
            localObject1 = localObject3;
            localObject5 = new StringBuilder().append((String)localObject3).append("\n is patch update = ");
            localObject1 = localObject3;
            com.tencent.xweb.xwalk.updater.c.fLZ();
            localObject1 = localObject3;
            localObject3 = com.tencent.xweb.xwalk.updater.g.fLZ().fMm().KIp;
            localObject1 = localObject3;
            localObject3 = (String)localObject3 + "\n can use cellular = " + com.tencent.xweb.xwalk.updater.c.fLZ().fMm().KHT;
            localObject1 = localObject3;
            localObject3 = (String)localObject3 + "\n updateHourStart = " + com.tencent.xweb.xwalk.updater.c.fLZ().fMm().KIv;
            localObject1 = localObject3;
            localObject3 = (String)localObject3 + "\n updateHourEnd = " + com.tencent.xweb.xwalk.updater.c.fLZ().fMm().KIw;
            localObject1 = localObject3;
            localObject3 = (String)localObject3 + "\n versionId = " + com.tencent.xweb.xwalk.updater.c.fLZ().fMm().KHK;
            localObject1 = localObject3;
            localObject3 = (String)localObject3 + "\n update time is = " + str;
            localObject1 = localObject3;
            localObject3 = (String)localObject3 + "\n try count = " + com.tencent.xweb.xwalk.updater.c.fLZ().fMm().KIt;
            localObject1 = localObject3;
            localObject3 = (String)localObject3 + "\n try use shared core count = " + com.tencent.xweb.xwalk.updater.c.fLZ().fMm().KIu;
            localObject1 = localObject3;
            localObject3 = (String)localObject3 + "\n";
          }
          localObject1 = localObject3;
          localObject5 = new Date(com.tencent.xweb.xwalk.updater.c.fLZ().fMm().KIn);
          localObject1 = localObject3;
          localObject3 = (String)localObject3 + " last fetch config time = " + localSimpleDateFormat.format((Date)localObject5);
          localObject1 = localObject3;
          localObject3 = (String)localObject3 + " last fetch config abi = " + com.tencent.xweb.xwalk.updater.c.fLZ().fMm().KIo;
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
        this.KFk.setText((CharSequence)localObject3);
        AppMethodBeat.o(154230);
        return;
        ((StringBuilder)localObject3).append("\n null\n");
      }
    }
  }
  
  final void fLv()
  {
    AppMethodBeat.i(154231);
    if ((!y.fJs().Kzz) && ((!y.fJs().KzA) || (this.KFf.getWebCoreType() != WebView.c.KAa)))
    {
      AppMethodBeat.o(154231);
      return;
    }
    if (this.KFj != null)
    {
      AppMethodBeat.o(154231);
      return;
    }
    this.KFj = new TextView(this.Kzw);
    this.KFj.setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(154176);
        d.this.fLx();
        AppMethodBeat.o(154176);
        return true;
      }
    });
    fLw();
    this.KFf.getTopView().addView(this.KFj);
    AppMethodBeat.o(154231);
  }
  
  final boolean fLx()
  {
    AppMethodBeat.i(154235);
    b(this.KFf);
    if (this.KFm != null)
    {
      this.KFm.setVisibility(0);
      AppMethodBeat.o(154235);
      return true;
    }
    this.KFm = ((LayoutInflater)this.Kzw.getSystemService("layout_inflater")).inflate(2131493685, this.KFf.getTopView(), true).findViewById(2131306436);
    ((Button)this.KFm.findViewById(2131297647)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(154187);
        d.this.KFm.setVisibility(8);
        AppMethodBeat.o(154187);
      }
    });
    Object localObject1 = (CheckBox)this.KFm.findViewById(2131298267);
    ((CheckBox)localObject1).setChecked(y.fJs().Kzz);
    ((CheckBox)localObject1).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(154208);
        paramAnonymousCompoundButton = y.fJs();
        if (paramAnonymousBoolean != paramAnonymousCompoundButton.Kzz)
        {
          paramAnonymousCompoundButton.Kzz = paramAnonymousBoolean;
          paramAnonymousCompoundButton.Kzw.getSharedPreferences("wcwebview", 0).edit().putBoolean("bShowVersion", paramAnonymousCompoundButton.Kzz).commit();
        }
        if (paramAnonymousBoolean)
        {
          d.this.fLv();
          d.this.KFj.setVisibility(0);
          AppMethodBeat.o(154208);
          return;
        }
        if (d.this.KFj != null) {
          d.this.KFj.setVisibility(8);
        }
        AppMethodBeat.o(154208);
      }
    });
    ((TextView)this.KFm.findViewById(2131298247)).setOnClickListener(new d.49(this, (CheckBox)localObject1));
    localObject1 = (EditText)this.KFm.findViewById(2131306174);
    if (localObject1 != null)
    {
      ((EditText)localObject1).setInputType(2);
      ((EditText)localObject1).setText(XWalkEnvironment.getGrayValue());
      ((EditText)localObject1).addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(154213);
          paramAnonymousEditable = this.KGa.getText().toString();
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
    ((Spinner)this.KFm.findViewById(2131304547)).setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
    {
      public final void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        int i = 1;
        AppMethodBeat.i(154214);
        paramAnonymousAdapterView = d.this.Kzw.getResources().getStringArray(2130903104);
        d.this.KFo = paramAnonymousAdapterView[paramAnonymousInt];
        paramAnonymousAdapterView = d.this;
        paramAnonymousAdapterView.KFn = true;
        WebView.c localc;
        if (paramAnonymousAdapterView.KFo.equals("all"))
        {
          paramAnonymousView = paramAnonymousAdapterView.Kzw.getResources().getStringArray(2130903103);
          localc = y.fJs().aUV(paramAnonymousView[0]);
          paramAnonymousInt = i;
          if (paramAnonymousInt < paramAnonymousView.length) {
            if (y.fJs().aUV(paramAnonymousView[paramAnonymousInt]) != localc)
            {
              ((RadioButton)paramAnonymousAdapterView.KFm.findViewById(2131296280)).setChecked(false);
              ((RadioButton)paramAnonymousAdapterView.KFm.findViewById(2131296283)).setChecked(false);
              ((RadioButton)paramAnonymousAdapterView.KFm.findViewById(2131296282)).setChecked(false);
              ((RadioButton)paramAnonymousAdapterView.KFm.findViewById(2131296281)).setChecked(false);
            }
          }
        }
        for (;;)
        {
          paramAnonymousAdapterView.KFn = false;
          AppMethodBeat.o(154214);
          return;
          paramAnonymousInt += 1;
          break;
          paramAnonymousAdapterView.m(localc);
          continue;
          paramAnonymousAdapterView.m(y.fJs().aUV(paramAnonymousAdapterView.KFo));
        }
      }
      
      public final void onNothingSelected(AdapterView<?> paramAnonymousAdapterView) {}
    });
    ((RadioGroup)this.KFm.findViewById(2131306908)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(RadioGroup paramAnonymousRadioGroup, int paramAnonymousInt)
      {
        AppMethodBeat.i(154215);
        if (d.this.KFn)
        {
          AppMethodBeat.o(154215);
          return;
        }
        paramAnonymousRadioGroup = WebView.c.KzY;
        if (paramAnonymousInt == 2131296280) {
          paramAnonymousRadioGroup = WebView.c.KzY;
        }
        while (!d.this.KFo.equals("all"))
        {
          y.fJs().a(d.this.KFo, paramAnonymousRadioGroup);
          Log.d("WebDebugPage", "webview change to=".concat(String.valueOf(paramAnonymousRadioGroup)));
          AppMethodBeat.o(154215);
          return;
          if (paramAnonymousInt == 2131296283) {
            paramAnonymousRadioGroup = WebView.c.KzZ;
          } else if (paramAnonymousInt == 2131296282) {
            paramAnonymousRadioGroup = WebView.c.KAa;
          } else if (paramAnonymousInt == 2131296281) {
            paramAnonymousRadioGroup = WebView.c.KAb;
          }
        }
        String[] arrayOfString = d.this.Kzw.getResources().getStringArray(2130903103);
        paramAnonymousInt = 0;
        while (paramAnonymousInt < arrayOfString.length)
        {
          y.fJs().a(arrayOfString[paramAnonymousInt], paramAnonymousRadioGroup);
          Log.d("WebDebugPage", "webview " + arrayOfString[paramAnonymousInt] + " change to=" + paramAnonymousRadioGroup);
          paramAnonymousInt += 1;
        }
        AppMethodBeat.o(154215);
      }
    });
    switch (48.KEI[y.fJs().KzF.ordinal()])
    {
    default: 
      ((RadioGroup)this.KFm.findViewById(2131306258)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
      {
        public final void onCheckedChanged(RadioGroup paramAnonymousRadioGroup, int paramAnonymousInt)
        {
          AppMethodBeat.i(154153);
          paramAnonymousRadioGroup = JsRuntime.JsRuntimeType.Kzb;
          if (paramAnonymousInt == 2131306255) {
            paramAnonymousRadioGroup = JsRuntime.JsRuntimeType.Kzb;
          }
          for (;;)
          {
            y.fJs().a(paramAnonymousRadioGroup);
            Log.d("WebDebugPage", "v8 type change to=".concat(String.valueOf(paramAnonymousRadioGroup)));
            AppMethodBeat.o(154153);
            return;
            if (paramAnonymousInt == 2131306259) {
              paramAnonymousRadioGroup = JsRuntime.JsRuntimeType.Kzc;
            } else if (paramAnonymousInt == 2131306260) {
              paramAnonymousRadioGroup = JsRuntime.JsRuntimeType.Kzg;
            } else if (paramAnonymousInt == 2131306257) {
              paramAnonymousRadioGroup = JsRuntime.JsRuntimeType.Kzi;
            } else if (paramAnonymousInt == 2131306256) {
              paramAnonymousRadioGroup = JsRuntime.JsRuntimeType.Kzj;
            }
          }
        }
      });
      ((Button)this.KFm.findViewById(2131297654)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(154154);
          d.this.KFm.setVisibility(8);
          d.this.bcI();
          AppMethodBeat.o(154154);
        }
      });
      localObject1 = (Button)this.KFm.findViewById(2131297586);
      a(y.fJs().Kzy, (Button)localObject1, false);
      ((Button)localObject1).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(154155);
          if (!y.fJs().Kzy) {}
          for (boolean bool = true;; bool = false)
          {
            y.fJs().yR(bool);
            d.this.a(bool, this.KFw, true);
            AppMethodBeat.o(154155);
            return;
          }
        }
      });
      ((Button)this.KFm.findViewById(2131297644)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(154156);
          XWalkEnvironment.clearAllVersion(d.this.Kzw);
          AppMethodBeat.o(154156);
        }
      });
      ((Button)this.KFm.findViewById(2131297665)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(154157);
          ((TextView)d.this.KFm.findViewById(2131306169)).setText(d.this.zb(true) + "\n" + XWalkInitializer.getXWalkInitializeLog());
          AppMethodBeat.o(154157);
        }
      });
      ((Button)this.KFm.findViewById(2131297657)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(154158);
          d.this.zc(true);
          AppMethodBeat.o(154158);
        }
      });
      localObject1 = (Button)this.KFm.findViewById(2131297649);
      if ((this.KFf.isXWalkKernel()) && (XWalkEnvironment.isCurrentVersionSupportForceDarkMode()))
      {
        ((Button)localObject1).setVisibility(0);
        label502:
        f((Button)localObject1);
        ((Button)localObject1).setOnClickListener(new d.8(this, (Button)localObject1));
        Object localObject2 = (Button)this.KFm.findViewById(2131297648);
        localObject1 = XWalkEnvironment.getXWalkUpdateConfigUrl();
        localObject1 = ((String)localObject1).substring(((String)localObject1).lastIndexOf('/') + 1);
        localObject1 = "(当前为" + (String)localObject1 + ")";
        if (!y.fJs().KzG) {
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
            paramAnonymousView = y.fJs();
            boolean bool;
            Button localButton;
            if (!y.fJs().KzG)
            {
              bool = true;
              paramAnonymousView.yT(bool);
              paramAnonymousView = XWalkEnvironment.getXWalkUpdateConfigUrl();
              paramAnonymousView = paramAnonymousView.substring(paramAnonymousView.lastIndexOf('/') + 1);
              paramAnonymousView = "(当前为" + paramAnonymousView + ")";
              localButton = this.KFy;
              if (!y.fJs().KzG) {
                break label104;
              }
            }
            label104:
            for (paramAnonymousView = "使用正式版config".concat(String.valueOf(paramAnonymousView));; paramAnonymousView = "使用测试config".concat(String.valueOf(paramAnonymousView)))
            {
              localButton.setText(paramAnonymousView);
              AppMethodBeat.o(154160);
              return;
              bool = false;
              break;
            }
          }
        });
        ((Button)this.KFm.findViewById(2131297668)).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(154161);
            d.this.fLA();
            AppMethodBeat.o(154161);
          }
        });
        localObject1 = (LinearLayout)this.KFm.findViewById(2131303310);
        ((LinearLayout)localObject1).setVisibility(8);
        localObject2 = (Button)this.KFm.findViewById(2131297663);
        ((Button)localObject2).setText("插件设置");
        ((Button)localObject2).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(154162);
            if (this.KFz.getVisibility() == 8)
            {
              this.KFz.setVisibility(0);
              ((Button)paramAnonymousView).setText("隐藏插件设置");
              AppMethodBeat.o(154162);
              return;
            }
            this.KFz.setVisibility(8);
            ((Button)paramAnonymousView).setText("插件设置");
            AppMethodBeat.o(154162);
          }
        });
        localObject1 = (Button)this.KFm.findViewById(2131297662);
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
          paramAnonymousView = XWalkEnvironment.getPluginTestConfigUrl();
          if ((paramAnonymousView != null) && (!paramAnonymousView.isEmpty()))
          {
            if (XWalkEnvironment.setPluginTestConfigUrl(""))
            {
              this.KFA.setText("切换插件配置，当前使用正式版");
              AppMethodBeat.o(154164);
              return;
            }
            d.this.dm("切换失败", true);
            AppMethodBeat.o(154164);
            return;
          }
          if (XWalkEnvironment.setPluginTestConfigUrl("https://dldir1.qq.com/weixin/android/wxweb/plugin/pluginUpdateConfig_test.xml"))
          {
            this.KFA.setText("切换插件配置，当前使用默认测试版");
            AppMethodBeat.o(154164);
            return;
          }
          d.this.dm("切换失败", true);
          AppMethodBeat.o(154164);
        }
      });
      ((Button)this.KFm.findViewById(2131297669)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(154165);
          d.lo(d.this.Kzw);
          Toast.makeText(d.this.Kzw, "开始检测插件更新", 0).show();
          AppMethodBeat.o(154165);
        }
      });
      ((Button)this.KFm.findViewById(2131297645)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(154166);
          d.this.fLz();
          AppMethodBeat.o(154166);
        }
      });
      ((Spinner)this.KFm.findViewById(2131305151)).setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
      {
        public final void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(154167);
          paramAnonymousAdapterView = d.this.Kzw.getResources().getStringArray(2130903075);
          d.this.KFg = paramAnonymousAdapterView[paramAnonymousInt];
          AppMethodBeat.o(154167);
        }
        
        public final void onNothingSelected(AdapterView<?> paramAnonymousAdapterView) {}
      });
      ((Button)this.KFm.findViewById(2131297659)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(154169);
          d.a(d.this.Kzw, d.this.KFg, false, new ValueCallback() {});
          AppMethodBeat.o(154169);
        }
      });
      ((Button)this.KFm.findViewById(2131297660)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(154171);
          d.a(d.this.Kzw, d.this.KFg, true, new ValueCallback() {});
          AppMethodBeat.o(154171);
        }
      });
      ((Button)this.KFm.findViewById(2131297670)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(154172);
          d.cD(d.this.Kzw, d.this.KFg);
          AppMethodBeat.o(154172);
        }
      });
      ((Button)this.KFm.findViewById(2131297646)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(154173);
          paramAnonymousView = com.tencent.xweb.xwalk.a.g.aUJ(d.this.KFg);
          if (paramAnonymousView == null)
          {
            AppMethodBeat.o(154173);
            return;
          }
          int i = paramAnonymousView.KHj;
          if (i < 0)
          {
            AppMethodBeat.o(154173);
            return;
          }
          String str = paramAnonymousView.agj(i);
          paramAnonymousView.agi(-1);
          if ((str != null) && (!str.isEmpty())) {
            com.tencent.xweb.util.c.aVj(str);
          }
          Toast.makeText(d.this.Kzw, "清理完成", 0).show();
          AppMethodBeat.o(154173);
        }
      });
      localObject1 = (CheckBox)this.KFm.findViewById(2131298265);
      ((CheckBox)localObject1).setChecked(y.fJs().fJt());
      ((CheckBox)localObject1).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
      {
        public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(154174);
          paramAnonymousCompoundButton = y.fJs().Kzw.getSharedPreferences("wcwebview", 4);
          if (paramAnonymousCompoundButton != null)
          {
            paramAnonymousCompoundButton = paramAnonymousCompoundButton.edit();
            if (paramAnonymousCompoundButton != null)
            {
              paramAnonymousCompoundButton.putBoolean("fr_disable_cache", paramAnonymousBoolean);
              paramAnonymousCompoundButton.commit();
              if (paramAnonymousBoolean)
              {
                paramAnonymousCompoundButton = com.tencent.xweb.xwalk.a.g.fLR().iterator();
                while (paramAnonymousCompoundButton.hasNext())
                {
                  Object localObject = (com.tencent.xweb.xwalk.a.f)paramAnonymousCompoundButton.next();
                  if ((localObject instanceof l))
                  {
                    int i = ((com.tencent.xweb.xwalk.a.f)localObject).KHj;
                    if (i >= 0)
                    {
                      localObject = ((com.tencent.xweb.xwalk.a.f)localObject).agk(i);
                      if (!((String)localObject).isEmpty()) {
                        com.tencent.xweb.util.c.aVj((String)localObject);
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
      localObject1 = (CheckBox)this.KFm.findViewById(2131298266);
      ((CheckBox)localObject1).setChecked(y.fJs().fJu());
      ((CheckBox)localObject1).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
      {
        public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(154175);
          paramAnonymousCompoundButton = y.fJs().Kzw.getSharedPreferences("wcwebview", 4);
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
      ((TextView)this.KFm.findViewById(2131305730)).setText(fLy());
      localObject1 = (EditText)this.KFm.findViewById(2131299264);
      ((Button)this.KFm.findViewById(2131297652)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(154177);
          d.a(d.this, this.KFD.getText().toString(), f.a.KyN);
          AppMethodBeat.o(154177);
        }
      });
      ((Button)this.KFm.findViewById(2131297651)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(154178);
          d.a(d.this, this.KFD.getText().toString(), f.a.KyO);
          AppMethodBeat.o(154178);
        }
      });
      ((Button)this.KFm.findViewById(2131297650)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(154179);
          d.a(d.this, this.KFD.getText().toString(), f.a.KyM);
          AppMethodBeat.o(154179);
        }
      });
      ((TextView)this.KFm.findViewById(2131306169)).setText(zb(true) + "\n" + XWalkInitializer.getXWalkInitializeLog());
      ((LinearLayout)this.KFm.findViewById(2131298553)).setVisibility(8);
      ((Button)this.KFm.findViewById(2131297643)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(154180);
          XWalkEnvironment.setGrayValueForTest(1);
          if (!XWalkEnvironment.hasAvailableVersion())
          {
            if (XWalkEnvironment.isIaDevice())
            {
              d.this.aUX("http://debugxweb.qq.com/?set_web_config=WV_KIND_CW&set_appbrand_config=WV_KIND_CW&set_config_url=https://dldir1.qq.com/weixin/android/wxweb/updateConfig_x86_test.xml&check_xwalk_update");
              AppMethodBeat.o(154180);
              return;
            }
            d.this.aUX("http://debugxweb.qq.com/?set_web_config=WV_KIND_CW&set_appbrand_config=WV_KIND_CW&set_config_url=https://dldir1.qq.com/weixin/android/wxweb/updateConfig_test.xml&check_xwalk_update");
            AppMethodBeat.o(154180);
            return;
          }
          y.fJs().a("tools", WebView.c.KzZ);
          y.fJs().a("toolsmp", WebView.c.KzZ);
          y.fJs().a("appbrand", WebView.c.KzZ);
          y.fJs().a("support", WebView.c.KzZ);
          y.fJs().a("mm", WebView.c.KzZ);
          d.this.dn("已使用XWeb，点任意位置重启进程生效\n", true);
          AppMethodBeat.o(154180);
        }
      });
      ((Button)this.KFm.findViewById(2131297642)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(154181);
          y.fJs().a("tools", WebView.c.KAa);
          y.fJs().a("toolsmp", WebView.c.KAa);
          y.fJs().a("appbrand", WebView.c.KAa);
          y.fJs().a("support", WebView.c.KAa);
          y.fJs().a("mm", WebView.c.KAa);
          if (com.tencent.xweb.WebView.getInstalledTbsCoreVersion(d.this.Kzw) <= 0)
          {
            d.this.dm("已切换x5，但是x5未ready，点任意位置重启进程生效\n", true);
            AppMethodBeat.o(154181);
            return;
          }
          d.this.dn("已使用x5，点任意位置重启进程生效\n", true);
          AppMethodBeat.o(154181);
        }
      });
      ((Button)this.KFm.findViewById(2131297641)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(154182);
          y.fJs().a("tools", WebView.c.KAb);
          y.fJs().a("toolsmp", WebView.c.KAb);
          y.fJs().a("appbrand", WebView.c.KAb);
          y.fJs().a("support", WebView.c.KAb);
          y.fJs().a("mm", WebView.c.KAb);
          d.this.dn("已使用system，点任意位置重启进程生效\n", true);
          AppMethodBeat.o(154182);
        }
      });
      ((Button)this.KFm.findViewById(2131297640)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(154183);
          XWalkEnvironment.setGrayValueForTest(0);
          XWalkEnvironment.setTestDownLoadUrl(d.this.Kzw, "");
          y.fJs().a("tools", WebView.c.KzY);
          y.fJs().a("toolsmp", WebView.c.KzY);
          y.fJs().a("appbrand", WebView.c.KzY);
          y.fJs().a("support", WebView.c.KzY);
          y.fJs().a("mm", WebView.c.KzY);
          d.this.dn("已使用AUTO，点任意位置重启进程生效\n", true);
          AppMethodBeat.o(154183);
        }
      });
      ((Button)this.KFm.findViewById(2131297639)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(154184);
          LinearLayout localLinearLayout = (LinearLayout)d.this.KFm.findViewById(2131298553);
          if (localLinearLayout.getVisibility() == 8)
          {
            localLinearLayout.setVisibility(0);
            ((Button)paramAnonymousView).setText("隐藏高级设置");
            AppMethodBeat.o(154184);
            return;
          }
          localLinearLayout.setVisibility(8);
          ((Button)paramAnonymousView).setText("高级设置");
          AppMethodBeat.o(154184);
        }
      });
      ((Button)this.KFm.findViewById(2131297666)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(154185);
          if (!y.fJs().KzB) {}
          for (boolean bool = true;; bool = false)
          {
            y.fJs().yS(bool);
            if (!bool) {
              break;
            }
            d.this.fLt();
            d.this.KFl.setVisibility(0);
            AppMethodBeat.o(154185);
            return;
          }
          if (d.this.KFl != null) {
            d.this.KFl.setVisibility(8);
          }
          AppMethodBeat.o(154185);
        }
      });
      localObject1 = (Button)this.KFm.findViewById(2131297658);
      ((Button)localObject1).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(154186);
          paramAnonymousView = d.this;
          Object localObject1 = new com.tencent.xweb.b.h(Environment.getExternalStorageDirectory());
          ((com.tencent.xweb.b.h)localObject1).fKg();
          localObject1 = ((com.tencent.xweb.b.h)localObject1).getPath() + "/xweb_dump";
          Object localObject2;
          Object localObject3;
          try
          {
            localObject2 = new com.tencent.xweb.b.h((String)localObject1);
            localObject3 = ((com.tencent.xweb.b.h)localObject2).fKg();
            if (localObject3.length == 0)
            {
              paramAnonymousView.dm("web_dump目录下没有.zip文件,请确认应用权限，在权限管理打开应用的读写存储权限", true);
              AppMethodBeat.o(154186);
              return;
            }
          }
          catch (Exception localException)
          {
            paramAnonymousView.dm("没有找到web_dump目录,请确认应用权限，在权限管理打开应用的读写存储权限", true);
            AppMethodBeat.o(154186);
            return;
          }
          int i = 0;
          while (i < localObject3.length)
          {
            if (localObject3[i].getName().endsWith(".zip"))
            {
              localObject2 = localObject3[i].getAbsolutePath();
              localObject3 = localObject3[i].getName();
              new AlertDialog.Builder(paramAnonymousView.Kzw).setTitle("提示").setMessage("确定加载:" + (String)localObject3 + "?").setPositiveButton("确定", new d.43(paramAnonymousView, localException, (String)localObject2)).setNegativeButton("取消", new d.42(paramAnonymousView)).show();
              AppMethodBeat.o(154186);
              return;
            }
            i += 1;
          }
          paramAnonymousView.dm("web_dump目录下没有.zip文件", true);
          AppMethodBeat.o(154186);
        }
      });
      ((Button)this.KFm.findViewById(2131297667)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(154188);
          boolean bool;
          if (!y.fJs().KzH)
          {
            bool = true;
            y.fJs().setShowFps(bool);
            d.b(d.this.KFf);
            if (!bool) {
              break label60;
            }
          }
          label60:
          for (paramAnonymousView = "打开显示fps";; paramAnonymousView = "关闭显示fps")
          {
            d.this.dn(paramAnonymousView, false);
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
          new AlertDialog.Builder(d.this.Kzw).setTitle("提示").setMessage("清空保存页面文件").setPositiveButton("确定", new DialogInterface.OnClickListener()
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
          AppMethodBeat.o(154190);
          return false;
        }
      });
      ((Button)this.KFm.findViewById(2131297661)).setOnClickListener(this.KFt);
      AppMethodBeat.o(154235);
      return true;
      ((RadioButton)this.KFm.findViewById(2131306255)).setChecked(true);
      break;
      ((RadioButton)this.KFm.findViewById(2131306259)).setChecked(true);
      break;
      ((RadioButton)this.KFm.findViewById(2131306260)).setChecked(true);
      break;
      ((RadioButton)this.KFm.findViewById(2131306257)).setChecked(true);
      break;
      ((RadioButton)this.KFm.findViewById(2131306256)).setChecked(true);
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
  
  final void fLz()
  {
    AppMethodBeat.i(208911);
    Object localObject = com.tencent.xweb.xwalk.a.g.fLR().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((com.tencent.xweb.xwalk.a.f)((Iterator)localObject).next()).agi(-1);
    }
    localObject = XWalkEnvironment.getPluginBaseDir();
    if (((String)localObject).isEmpty())
    {
      AppMethodBeat.o(208911);
      return;
    }
    com.tencent.xweb.util.c.aVj((String)localObject);
    dm("所有插件清理完成", true);
    AppMethodBeat.o(208911);
  }
  
  final void m(WebView.c paramc)
  {
    AppMethodBeat.i(154234);
    switch (48.meK[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(154234);
      return;
      ((RadioButton)this.KFm.findViewById(2131296280)).setChecked(true);
      AppMethodBeat.o(154234);
      return;
      ((RadioButton)this.KFm.findViewById(2131296283)).setChecked(true);
      AppMethodBeat.o(154234);
      return;
      ((RadioButton)this.KFm.findViewById(2131296282)).setChecked(true);
      AppMethodBeat.o(154234);
      return;
      ((RadioButton)this.KFm.findViewById(2131296281)).setChecked(true);
    }
  }
  
  final String zb(boolean paramBoolean)
  {
    AppMethodBeat.i(154232);
    String str2 = this.KFf.getVersionInfo();
    int i;
    if (!paramBoolean)
    {
      i = str2.indexOf(",apkversion");
      str1 = str2;
      if (i <= 0) {}
    }
    for (String str1 = str2.substring(0, i);; str1 = str2 + ", " + com.tencent.xweb.xwalk.a.g.fLS() + " current process is " + XWalkEnvironment.getProcessName())
    {
      AppMethodBeat.o(154232);
      return str1;
    }
  }
  
  final void zc(final boolean paramBoolean)
  {
    AppMethodBeat.i(154246);
    Object localObject1 = new com.tencent.xweb.b.h(Environment.getExternalStorageDirectory());
    ((com.tencent.xweb.b.h)localObject1).fKg();
    localObject1 = ((com.tencent.xweb.b.h)localObject1).getPath() + "/apkxwebtest";
    Object localObject2;
    try
    {
      localObject1 = new com.tencent.xweb.b.h((String)localObject1);
      localObject2 = ((com.tencent.xweb.b.h)localObject1).fKg();
      if (localObject2.length == 0)
      {
        dm("apkxwebtest目录下没有.zip文件,请确认应用权限，在权限管理打开应用的读写存储权限", true);
        AppMethodBeat.o(154246);
        return;
      }
    }
    catch (Exception localException)
    {
      dm("没有找到apkxwebtest目录,请确认应用权限，在权限管理打开应用的读写存储权限", true);
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
          new AlertDialog.Builder(this.Kzw).setTitle("提示").setMessage("确定加载:" + (String)localObject2 + "?").setPositiveButton("确定", new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(154205);
              d.this.G(str, this.KFV, paramBoolean);
              AppMethodBeat.o(154205);
            }
          }).setNegativeButton("取消", new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          }).show();
          AppMethodBeat.o(154246);
          return;
        }
        G(str, (String)localObject2, paramBoolean);
        AppMethodBeat.o(154246);
        return;
      }
      i += 1;
    }
    dm("apkxwebtest目录下没有.zip文件", true);
    AppMethodBeat.o(154246);
  }
  
  static final class a
    extends XWalkUpdater.UpdateConfig
  {
    String KGb;
    
    private a(int paramInt)
    {
      super(false, paramInt, XWalkEnvironment.getRuntimeAbi(), 0);
      AppMethodBeat.i(154217);
      AppMethodBeat.o(154217);
    }
    
    public a(String paramString1, String paramString2)
    {
      this(i);
      AppMethodBeat.i(154216);
      this.KGb = paramString1;
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
  
  final class b
    extends p
  {
    private ProgressDialog KFG;
    boolean KGc = false;
    
    public b(Context paramContext)
    {
      super();
    }
    
    private void aVw(String paramString)
    {
      AppMethodBeat.i(154223);
      if (this.KFG == null)
      {
        this.KFG = new ProgressDialog(this.mContext);
        this.KFG.setProgressStyle(1);
        this.KFG.setMessage(paramString);
        this.KFG.setOnCancelListener(new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(154218);
            d.this.bcI();
            AppMethodBeat.o(154218);
          }
        });
        this.KFG.setCancelable(false);
        this.KFG.show();
      }
      this.KFG.setMessage(paramString);
      AppMethodBeat.o(154223);
    }
    
    public final void onXWalkUpdateCancelled()
    {
      AppMethodBeat.i(154221);
      super.onXWalkUpdateCancelled();
      try
      {
        this.KFG.setCancelable(true);
        this.KFG.setCanceledOnTouchOutside(true);
        aVw("更新失败, 更新被取消");
        AppMethodBeat.o(154221);
        return;
      }
      catch (Exception localException)
      {
        Log.i("WebDebugPage", "may run in background failed to load alert:" + localException.getMessage());
        AppMethodBeat.o(154221);
      }
    }
    
    public final void onXWalkUpdateCompleted()
    {
      AppMethodBeat.i(154222);
      super.onXWalkUpdateCompleted();
      try
      {
        aVw("更新完成，点任意位置重启进程生效");
        this.KFG.setCancelable(true);
        this.KFG.setCanceledOnTouchOutside(true);
        this.KFG.setProgress(100);
        this.KGc = true;
        AppMethodBeat.o(154222);
        return;
      }
      catch (Exception localException)
      {
        Log.i("WebDebugPage", "may run in background failed to load alert:" + localException.getMessage());
        AppMethodBeat.o(154222);
      }
    }
    
    public final void onXWalkUpdateFailed(int paramInt)
    {
      AppMethodBeat.i(154220);
      super.onXWalkUpdateFailed(paramInt);
      try
      {
        this.KFG.setCancelable(true);
        this.KFG.setCanceledOnTouchOutside(true);
        aVw("更新失败, error code = :".concat(String.valueOf(paramInt)));
        AppMethodBeat.o(154220);
        return;
      }
      catch (Exception localException)
      {
        Log.i("WebDebugPage", "may run in background failed to load alert:" + localException.getMessage());
        AppMethodBeat.o(154220);
      }
    }
    
    public final void onXWalkUpdateProgress(int paramInt)
    {
      AppMethodBeat.i(154219);
      super.onXWalkUpdateProgress(paramInt);
      if (this.KGc)
      {
        AppMethodBeat.o(154219);
        return;
      }
      try
      {
        aVw("正在下载runtime");
        if (this.KFG != null) {
          this.KFG.setProgress(paramInt);
        }
        AppMethodBeat.o(154219);
        return;
      }
      catch (Exception localException)
      {
        Log.i("WebDebugPage", "may run in background failed to load alert:" + localException.getMessage());
        AppMethodBeat.o(154219);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d
 * JD-Core Version:    0.7.0.1
 */