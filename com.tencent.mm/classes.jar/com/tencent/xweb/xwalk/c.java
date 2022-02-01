package com.tencent.xweb.xwalk;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
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
import com.tencent.xweb.af;
import com.tencent.xweb.f.a;
import com.tencent.xweb.internal.d;
import com.tencent.xweb.internal.j.a;
import com.tencent.xweb.p;
import com.tencent.xweb.v;
import com.tencent.xweb.x;
import com.tencent.xweb.xwalk.a.i.a;
import com.tencent.xweb.xwalk.a.k;
import com.tencent.xweb.xwalk.updater.Scheduler;
import com.tencent.xweb.xwalk.updater.Scheduler.SchedulerConfig;
import com.tencent.xweb.y;
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

public final class c
  implements d
{
  Context IMY;
  com.tencent.xweb.WebView ISE;
  String ISF;
  ScrollView ISG;
  TextView ISH;
  TextView ISI;
  TextView ISJ;
  Button ISK;
  View ISL;
  boolean ISM;
  String ISN;
  private final String ISO;
  private final String ISP;
  private final String ISQ;
  private final String ISR;
  private View.OnClickListener ISS;
  
  public c(com.tencent.xweb.WebView paramWebView)
  {
    AppMethodBeat.i(154224);
    this.ISF = "";
    this.ISG = null;
    this.ISH = null;
    this.ISI = null;
    this.ISJ = null;
    this.ISK = null;
    this.ISM = false;
    this.ISN = "tools";
    this.ISO = "当前Dark Mode强制智能反色[%d,%d]（点击切换）";
    this.ISP = "当前Dark Mode不强制智能反色[%d,%d]（点击切换）";
    this.ISQ = "当前Light Mode[%d,%d]（点击切换）";
    this.ISR = "当前未知Mode[%d,%d]（点击切换）";
    this.ISS = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(154194);
        c.this.ISL.setVisibility(8);
        c.this.ISE.startLongScreenshot(new p()
        {
          public final File getCacheFileDir()
          {
            AppMethodBeat.i(154192);
            File localFile = new File(c.this.IMY.getExternalCacheDir().getAbsolutePath(), "LongScreenshot");
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
            File localFile = new File(c.this.IMY.getExternalCacheDir().getAbsolutePath(), "LongScreenshot");
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
    this.IMY = paramWebView.getContext();
    this.ISE = paramWebView;
    fsR();
    fsP();
    AppMethodBeat.o(154224);
  }
  
  private void Og(String paramString)
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
          Og(paramString + "//" + arrayOfString[i]);
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
    if (com.tencent.xweb.a.aOH(paramString) != WebView.c.INB)
    {
      paramc = com.tencent.xweb.a.aOH(paramString);
      localStringBuilder.append("\n   has command type ".concat(String.valueOf(paramc)));
    }
    if (x.fqR().da(paramString, true) != WebView.c.INB)
    {
      paramc = x.fqR().aPc(paramString);
      localStringBuilder.append("\n   has abtest type ".concat(String.valueOf(paramc)));
    }
    for (int i = 1;; i = 0)
    {
      if (x.fqR().da(paramString, false) != WebView.c.INB)
      {
        paramContext = x.fqR().aPc(paramString);
        localStringBuilder.append("\n   has hardcode type ".concat(String.valueOf(paramContext)));
        i = j;
      }
      for (;;)
      {
        if ((i == 0) && (paramContext == WebView.c.INC) && (XWalkEnvironment.getXWebInitArgs("isgpversion", false)))
        {
          paramContext = WebView.c.INE;
          localStringBuilder.append("\n   is prefer " + paramContext + " because of gp version");
        }
        for (;;)
        {
          paramc = paramContext;
          if (paramContext == WebView.c.INC)
          {
            paramc = paramContext;
            if (!XWalkEnvironment.hasAvailableVersion())
            {
              paramc = WebView.c.IND;
              localStringBuilder.append("\n   is prefer " + paramc + " because of xwalk is not available");
            }
          }
          com.tencent.xweb.internal.h.d(paramc);
          if (com.tencent.xweb.internal.h.frN().frS())
          {
            paramc = WebView.c.INE;
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
    localh.frE();
    final com.tencent.xweb.xwalk.a.e locale = com.tencent.xweb.xwalk.a.g.aOW(paramString);
    if (locale == null)
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
        private ProgressDialog sFV = null;
        
        private Boolean fsX()
        {
          int i = 99999;
          boolean bool = true;
          AppMethodBeat.i(154202);
          Object localObject2 = null;
          for (;;)
          {
            try
            {
              com.tencent.xweb.xwalk.a.f localf;
              if (this.ITl > 0)
              {
                int j = this.ITl;
                i = j;
                if (locale.IUH > 0)
                {
                  localObject1 = locale.ado(locale.IUH);
                  locale.adn(-1);
                  i = j;
                  if (localObject1 != null)
                  {
                    i = j;
                    if (!((String)localObject1).isEmpty())
                    {
                      com.tencent.xweb.util.c.aPq((String)localObject1);
                      i = j;
                    }
                  }
                }
                localf = new com.tencent.xweb.xwalk.a.f();
                localf.version = i;
                localf.isPatch = false;
                localf.path = locale.bd(i, false);
                localObject1 = new File(localf.path);
              }
              try
              {
                if (this.ITn)
                {
                  com.tencent.xweb.util.c.b(this.val$context.getAssets().open(paramString), (File)localObject1);
                  localf.md5 = com.tencent.xweb.b.i.aEN(((File)localObject1).getPath());
                  localf.IUK = true;
                  if (locale.a(localf) != 0) {
                    continue;
                  }
                  AppMethodBeat.o(154202);
                  return Boolean.valueOf(bool);
                  if (locale.IUH < 99999) {
                    continue;
                  }
                  i = locale.IUH;
                  i += 1;
                  continue;
                }
                com.tencent.xweb.b.i.kP(this.ITp, ((File)localObject1).getPath());
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
          this.sFV = new ProgressDialog(this.val$context);
          this.sFV.setProgressStyle(0);
          this.sFV.setMessage("安装中");
          this.sFV.setCancelable(false);
          this.sFV.setCanceledOnTouchOutside(false);
          this.sFV.setButton(-1, "完成", new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(154200);
              c.39.a(c.39.this).hide();
              AppMethodBeat.o(154200);
            }
          });
          this.sFV.show();
          this.sFV.getButton(-1).setVisibility(8);
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
    //   3: ldc_w 430
    //   6: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: ifnull +12 -> 22
    //   13: invokestatic 280	com/tencent/xweb/x:fqR	()Lcom/tencent/xweb/x;
    //   16: getfield 433	com/tencent/xweb/x:INj	Z
    //   19: ifne +13 -> 32
    //   22: ldc_w 430
    //   25: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: ldc 2
    //   30: monitorexit
    //   31: return
    //   32: aload_0
    //   33: invokestatic 435	com/tencent/xweb/xwalk/c:b	(Lcom/tencent/xweb/internal/IWebView;)V
    //   36: ldc_w 430
    //   39: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public static boolean aPC(String paramString)
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
      com.tencent.xweb.util.g.xs(223L);
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
    //   3: ldc_w 536
    //   6: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: ifnull +12 -> 22
    //   13: invokestatic 280	com/tencent/xweb/x:fqR	()Lcom/tencent/xweb/x;
    //   16: getfield 433	com/tencent/xweb/x:INj	Z
    //   19: ifne +13 -> 32
    //   22: ldc_w 536
    //   25: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: ldc 2
    //   30: monitorexit
    //   31: return
    //   32: aload_0
    //   33: ldc_w 538
    //   36: new 78	com/tencent/xweb/xwalk/c$47
    //   39: dup
    //   40: invokespecial 539	com/tencent/xweb/xwalk/c$47:<init>	()V
    //   43: invokeinterface 545 3 0
    //   48: ldc_w 536
    //   51: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public static void cz(Context paramContext, final String paramString)
  {
    AppMethodBeat.i(194688);
    final com.tencent.xweb.xwalk.a.i locali = new com.tencent.xweb.xwalk.a.i();
    locali.a(paramString, new i.a()
    {
      ProgressDialog ITf = null;
      boolean mFinished = false;
      
      public final void adg(int paramAnonymousInt)
      {
        AppMethodBeat.i(154198);
        if ((this.mFinished) || (this.ITf == null))
        {
          AppMethodBeat.o(154198);
          return;
        }
        this.ITf.setProgress(paramAnonymousInt);
        AppMethodBeat.o(154198);
      }
      
      public final void adh(int paramAnonymousInt)
      {
        AppMethodBeat.i(154199);
        this.mFinished = true;
        if (this.ITf == null)
        {
          AppMethodBeat.o(154199);
          return;
        }
        Object localObject = com.tencent.xweb.xwalk.a.g.aOW(paramString);
        switch (paramAnonymousInt)
        {
        default: 
          this.ITf.setMessage(paramString + " 更新失败，未知错误，ErrCode = " + paramAnonymousInt);
          if ((this.ITj != null) && (x.fqR() != null))
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
          String str = x.fqR().a((String[])localObject, this.ITj);
          com.tencent.xweb.e.ae((String[])localObject);
          Toast.makeText(this.val$context, "格式:" + str + "强制使用" + this.ITj.name() + "打开", 0).show();
          if (this.jQT != null) {
            this.jQT.onReceiveValue(Integer.valueOf(paramAnonymousInt));
          }
          AppMethodBeat.o(154199);
          return;
          if (localObject != null) {
            this.ITf.setMessage(paramString + " 更新完成，已安装版本" + ((com.tencent.xweb.xwalk.a.e)localObject).IUH);
          }
          for (;;)
          {
            this.ITf.setProgress(100);
            this.ITf.getButton(-2).setVisibility(8);
            this.ITf.getButton(-1).setVisibility(0);
            if (!this.ITi) {
              break;
            }
            this.ITf.dismiss();
            break;
            this.ITf.setMessage(paramString + " 更新完成");
          }
          this.ITf.setMessage(paramString + " 更新被取消，ErrCode = " + paramAnonymousInt);
          break;
          this.ITf.setMessage(paramString + " 更新失败，无网络，ErrCode = " + paramAnonymousInt);
          break;
          this.ITf.setMessage(paramString + " 更新失败，未到检查时间，ErrCode = " + paramAnonymousInt);
          break;
          this.ITf.setMessage(paramString + " 更新失败，其它任务正在更新插件，ErrCode = " + paramAnonymousInt);
          break;
          this.ITf.setMessage(paramString + " 更新失败，配置下载失败，ErrCode = " + paramAnonymousInt);
          break;
          this.ITf.setMessage(paramString + " 更新失败，配置解析失败，ErrCode = " + paramAnonymousInt);
          break;
          this.ITf.setMessage(paramString + " 更新失败，配置中未包含插件信息，ErrCode = " + paramAnonymousInt);
          break;
          if (localObject != null) {
            this.ITf.setMessage(paramString + " 更新失败，未找到可用更新，当前已安装版本" + ((com.tencent.xweb.xwalk.a.e)localObject).IUH + "，ErrCode = " + paramAnonymousInt);
          }
          while (this.ITi)
          {
            this.ITf.dismiss();
            break;
            this.ITf.setMessage(paramString + " 更新失败，未找到可用更新，ErrCode = " + paramAnonymousInt);
          }
          this.ITf.setMessage(paramString + " 更新失败，下载安装出错，ErrCode = " + paramAnonymousInt);
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
      
      public final void fsW()
      {
        AppMethodBeat.i(154197);
        this.ITf = new ProgressDialog(this.val$context);
        this.ITf.setProgressStyle(1);
        this.ITf.setMessage(paramString + " 下载更新中");
        this.ITf.setCancelable(false);
        this.ITf.setCanceledOnTouchOutside(false);
        this.ITf.setButton(-2, "取消", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(154195);
            if (!c.38.this.mFinished)
            {
              paramAnonymous2DialogInterface = c.38.this.ITh;
              if (paramAnonymous2DialogInterface.IUP != null) {
                paramAnonymous2DialogInterface.IUP.b(4, -1, null);
              }
            }
            AppMethodBeat.o(154195);
          }
        });
        this.ITf.setButton(-1, "完成", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(154196);
            c.38.this.ITf.dismiss();
            AppMethodBeat.o(154196);
          }
        });
        this.ITf.show();
        this.ITf.getButton(-1).setVisibility(8);
        AppMethodBeat.o(154197);
      }
    });
    paramString = new HashMap();
    paramString.put("UpdaterCheckType", "1");
    locali.a(paramContext, paramString);
    AppMethodBeat.o(194688);
  }
  
  private boolean dg(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(154227);
    if ((paramString.contains("debugxweb.qq.com")) || (paramBoolean))
    {
      Uri localUri = Uri.parse(paramString);
      paramString = localUri.getQueryParameterNames();
      if ((paramString == null) || (paramString.size() == 0))
      {
        fsT();
        AppMethodBeat.o(154227);
        return true;
      }
      Iterator localIterator = paramString.iterator();
      while (localIterator.hasNext())
      {
        paramString = (String)localIterator.next();
        label200:
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
              xK(false);
              break;
              if (!paramString.equals("load_local_xwalk")) {
                break label200;
              }
              i = 0;
              continue;
              if (!paramString.equals("clear_commands")) {
                break label200;
              }
              i = 1;
              continue;
              if (!paramString.equals("wait_debugger")) {
                break label200;
              }
              i = 2;
              continue;
              if (!paramString.equals("debug_process")) {
                break label200;
              }
              i = 3;
              continue;
              if (!paramString.equals("set_apkver")) {
                break label200;
              }
              i = 4;
              continue;
              if (!paramString.equals("check_files")) {
                break label200;
              }
              i = 5;
              continue;
              if (!paramString.equals("revert_to_apk")) {
                break label200;
              }
              i = 6;
              continue;
              if (!paramString.equals("set_config_peroid")) {
                break label200;
              }
              i = 7;
              continue;
              if (!paramString.equals("recheck_cmds")) {
                break label200;
              }
              i = 8;
              continue;
              if (!paramString.equals("set_plugin_config_url")) {
                break label200;
              }
              i = 9;
              continue;
              if (!paramString.equals("check_plugin_update")) {
                break label200;
              }
              i = 10;
              continue;
              if (!paramString.equals("set_force_filereader")) {
                break label200;
              }
              i = 11;
            }
          }
          com.tencent.xweb.a.a(null, "0");
          continue;
          paramBoolean = localUri.getBooleanQueryParameter("wait_debugger", false);
          paramString = x.fqR();
          paramString.INf = paramBoolean;
          paramString.IMY.getSharedPreferences("wcwebview", 0).edit().putBoolean("bWaitforDebugger", paramBoolean).commit();
          continue;
          paramString = localUri.getQueryParameter("debug_process");
          x.fqR().IMY.getSharedPreferences("wcwebview", 4).edit().putString("strDebugProcess", paramString).commit();
          continue;
          paramString = localUri.getQueryParameter("set_apkver");
          try
          {
            XWalkEnvironment.setAvailableVersion(Integer.parseInt(paramString), "1.0.".concat(String.valueOf(paramString)), XWalkEnvironment.getRuntimeAbi());
            di("版本号设置到:" + paramString + " 点击空白处退出重启进程", true);
          }
          catch (Exception paramString)
          {
            dh("设置版本号失败:" + paramString.getMessage(), true);
          }
          continue;
          o.xL(true);
          continue;
          paramString = localUri.getQueryParameter("revert_to_apk");
          try
          {
            i = o.aN(XWalkEnvironment.getApplicationContext(), Integer.parseInt(paramString));
            di("版本号回滚到:" + i + " 点击空白处退出重启进程", true);
          }
          catch (Exception paramString)
          {
            dh("版本号回滚到失败:" + paramString.getMessage(), true);
          }
          continue;
          paramString = localUri.getQueryParameter("set_config_peroid");
          try
          {
            com.tencent.xweb.a.adb(Integer.parseInt(paramString));
            di("设置配置拉取周期为:" + paramString + "分钟", false);
          }
          catch (Exception paramString)
          {
            dh("设置配置拉取周期失败:" + paramString.getMessage(), true);
          }
          continue;
          com.tencent.xweb.internal.j.g(WebView.c.INC).excute("STR_CMD_SET_RECHECK_COMMAND", null);
          di("重新跑了一遍命令配置 点击空白处退出重启进程", true);
          continue;
          try
          {
            paramString = localUri.getQueryParameter("set_plugin_config_url");
            XWalkEnvironment.setPluginTestConfigUrl(paramString);
            dh("插件测试连接设置为:".concat(String.valueOf(paramString)), true);
          }
          catch (Exception paramString)
          {
            dh("插件测试连接设置失败，格式错误", true);
          }
          continue;
          paramString = "";
        }
        label1300:
        try
        {
          localObject = localUri.getQueryParameter("check_plugin_update");
          paramString = (String)localObject;
        }
        catch (Exception localException2)
        {
          label1079:
          for (;;)
          {
            Object localObject;
          }
        }
        if ("all".equalsIgnoreCase(paramString))
        {
          dh("开始检测所有插件更新", true);
          la(this.IMY);
        }
        else if ("FullScreenVideo".equalsIgnoreCase(paramString))
        {
          cz(this.IMY, "FullScreenVideo");
        }
        else if ("XFilesPDFReader".equalsIgnoreCase(paramString))
        {
          cz(this.IMY, "XFilesPDFReader");
        }
        else if ("XFilesPPTReader".equalsIgnoreCase(paramString))
        {
          cz(this.IMY, "XFilesPPTReader");
        }
        else if ("XFilesWordReader".equalsIgnoreCase(paramString))
        {
          cz(this.IMY, "XFilesWordReader");
        }
        else if ("XFilesExcelReader".equalsIgnoreCase(paramString))
        {
          cz(this.IMY, "XFilesExcelReader");
        }
        else
        {
          dh("检测插件更新失败，参数错误", true);
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
          break label1079;
        }
        arrayOfString = paramString.split("_");
        if (paramString.length() < 2)
        {
          dh("强制设置文件预览方式失败，参数错误", true);
        }
        else
        {
          paramString = arrayOfString[(arrayOfString.length - 1)];
          if ("xweb".equalsIgnoreCase(paramString)) {
            paramString = f.a.IMu;
          }
          for (;;)
          {
            if ((arrayOfString.length == 2) && ("all".equalsIgnoreCase(arrayOfString[0])))
            {
              localObject = com.tencent.xweb.f.IMr;
              localObject = x.fqR().a((String[])localObject, paramString);
              if (((String)localObject).isEmpty()) {
                break label1300;
              }
              dh("格式:" + (String)localObject + "强制使用" + paramString.name() + "打开", true);
              break;
              if ("x5".equalsIgnoreCase(paramString))
              {
                paramString = f.a.IMv;
              }
              else if ("none".equalsIgnoreCase(paramString))
              {
                paramString = f.a.IMt;
              }
              else
              {
                dh("强制设置文件预览方式失败，类型错误", true);
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
          dh("强制设置文件预览方式失败", true);
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
  
  private void fsP()
  {
    AppMethodBeat.i(154228);
    if (!x.fqR().INd)
    {
      AppMethodBeat.o(154228);
      return;
    }
    if (this.ISK != null)
    {
      AppMethodBeat.o(154228);
      return;
    }
    this.ISK = new Button(this.IMY);
    this.ISK.setText("保存页面");
    this.ISK.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(154152);
        new AlertDialog.Builder(c.this.IMY).setTitle("保存页面").setMessage("确定保存页面？").setPositiveButton("确定", new c.1.2(this)).setNegativeButton("取消", new c.1.1(this)).show();
        AppMethodBeat.o(154152);
      }
    });
    this.ISE.getTopView().addView(this.ISK);
    AppMethodBeat.o(154228);
  }
  
  private void fsS()
  {
    AppMethodBeat.i(154233);
    if (this.ISI == null)
    {
      AppMethodBeat.o(154233);
      return;
    }
    String str = xJ(false);
    this.ISI.setText(str);
    AppMethodBeat.o(154233);
  }
  
  private static String fsU()
  {
    AppMethodBeat.i(154237);
    Object localObject = new StringBuilder();
    String[] arrayOfString = com.tencent.xweb.f.IMr;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      ((StringBuilder)localObject).append("\n ").append(str).append(": force-").append(x.fqR().aPd(str)).append("  cmd-").append(com.tencent.xweb.b.aOT(str));
      i += 1;
    }
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(154237);
    return localObject;
  }
  
  protected static void hr(Context paramContext)
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
  
  private static int kD(int paramInt1, int paramInt2)
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
  
  public static void la(Context paramContext)
  {
    AppMethodBeat.i(154238);
    com.tencent.xweb.xwalk.a.i locali = new com.tencent.xweb.xwalk.a.i();
    HashMap localHashMap = new HashMap();
    localHashMap.put("UpdaterCheckType", "1");
    locali.a(paramContext, localHashMap);
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
      localObject = com.tencent.xweb.b.i.vu(((com.tencent.xweb.b.h)localObject).getAbsolutePath());
      byte[] arrayOfByte = new byte[1048576];
      for (;;)
      {
        int i = paramString1.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        ((OutputStream)localObject).write(arrayOfByte, 0, i);
      }
      dh("安装" + paramString2 + "失败,错误码=" + paramString1, true);
    }
    catch (IOException paramString1)
    {
      for (;;)
      {
        paramString1 = XWalkUpdater.onHandleFile(locala);
        if (paramString1.intValue() != 0) {
          break;
        }
        dh("安装" + paramString2 + "成功", paramBoolean);
        AppMethodBeat.o(154247);
        return;
        ((OutputStream)localObject).flush();
        paramString1.close();
        ((OutputStream)localObject).close();
      }
    }
    catch (Exception paramString1)
    {
      dh("安装失败", true);
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
          if ((paramBoolean2) && (this.ISE.getX5WebViewExtension() != null))
          {
            if (!paramBoolean1) {
              break label79;
            }
            this.ISE.loadUrl("http://debugx5.qq.com/?inspector=true");
          }
          while (paramButton != null) {
            if (paramBoolean1)
            {
              paramButton.setText("关闭远程调试模式(当前已打开)");
              AppMethodBeat.o(154244);
              return;
              label79:
              this.ISE.loadUrl("http://debugx5.qq.com/?inspector=false");
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
  
  public final boolean aPe(String paramString)
  {
    AppMethodBeat.i(154226);
    if (paramString == null)
    {
      AppMethodBeat.o(154226);
      return false;
    }
    boolean bool5 = false;
    boolean bool2 = false;
    boolean bool4 = false;
    boolean bool1;
    boolean bool3;
    Object localObject1;
    Object localObject2;
    if (!paramString.contains("debugmm.qq.com"))
    {
      bool1 = bool4;
      bool3 = bool5;
      if (!paramString.contains("debugxweb.qq.com")) {}
    }
    else
    {
      com.tencent.xweb.util.g.xs(224L);
      localObject1 = Uri.parse(paramString);
      localObject2 = ((Uri)localObject1).getQueryParameterNames();
      bool1 = bool4;
      bool3 = bool5;
      if (localObject2 != null)
      {
        bool1 = bool4;
        bool3 = bool5;
        if (((Set)localObject2).size() > 0)
        {
          localObject2 = ((Set)localObject2).iterator();
          bool3 = false;
          bool1 = bool2;
          bool2 = bool3;
        }
      }
    }
    for (;;)
    {
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
                x.fqR().a("tools", WebView.c.IND);
                x.fqR().a("appbrand", WebView.c.IND);
                x.fqR().a("support", WebView.c.IND);
                x.fqR().a("mm", WebView.c.IND);
                x.fqR().a("toolsmp", WebView.c.IND);
                x.fqR().a(JsRuntime.JsRuntimeType.IMI);
                di("force use x5 switch is on ", true);
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
          case 989541982: 
          case 801125523: 
          case -1045985412: 
          case 273273929: 
          case 2135256815: 
            for (;;)
            {
              label306:
              AppMethodBeat.o(154226);
              return true;
              if (!((String)localObject3).equals("forcex5")) {
                break;
              }
              i = 0;
              break label306;
              if (!((String)localObject3).equals("inspector")) {
                break;
              }
              i = 1;
              break label306;
              if (!((String)localObject3).equals("ticket")) {
                break;
              }
              i = 2;
              break label306;
              if (!((String)localObject3).equals("show_x5_ver")) {
                break;
              }
              i = 3;
              break label306;
              if (!((String)localObject3).equals("encrpt_url")) {
                break;
              }
              i = 4;
              break label306;
              if (!((String)localObject3).equals("clear_test_setting")) {
                break;
              }
              i = 5;
              break label306;
              if (!((String)localObject3).equals("show_fps")) {
                break;
              }
              i = 6;
              break label306;
              if (!((String)localObject3).equals("set_mm_config")) {
                break;
              }
              i = 7;
              break label306;
              if (!((String)localObject3).equals("set_web_config")) {
                break;
              }
              i = 8;
              break label306;
              if (!((String)localObject3).equals("set_appbrand_config")) {
                break;
              }
              i = 9;
              break label306;
              if (!((String)localObject3).equals("show_webview_version")) {
                break;
              }
              i = 10;
              break label306;
              if (!((String)localObject3).equals("set_grayvalue")) {
                break;
              }
              i = 11;
              break label306;
              if (!((String)localObject3).equals("check_xwalk_update")) {
                break;
              }
              i = 12;
              break label306;
              if (!((String)localObject3).equals("soft_check_xwalk_update")) {
                break;
              }
              i = 13;
              break label306;
              if (!((String)localObject3).equals("clear_config_time_stamp")) {
                break;
              }
              i = 14;
              break label306;
              if (!((String)localObject3).equals("clear_schedule")) {
                break;
              }
              i = 15;
              break label306;
              if (!((String)localObject3).equals("set_config_url")) {
                break;
              }
              i = 16;
              break label306;
              x.fqR().a("tools", WebView.c.INB);
              x.fqR().a("appbrand", WebView.c.INB);
              x.fqR().a("support", WebView.c.INB);
              x.fqR().a("mm", WebView.c.INB);
              x.fqR().a("toolsmp", WebView.c.INB);
              x.fqR().a(JsRuntime.JsRuntimeType.IMD);
              di("force use x5 switch is off ", true);
            }
            bool1 = ((Uri)localObject1).getBooleanQueryParameter("inspector", false);
            x.fqR().xB(bool1);
            a(bool1, null, true);
            AppMethodBeat.o(154226);
            return true;
            localObject3 = ((Uri)localObject1).getQueryParameter("ticket");
            String str2 = ((Uri)localObject1).toString();
            if ((TextUtils.isEmpty(str2)) || (TextUtils.isEmpty((CharSequence)localObject3))) {
              bool1 = false;
            }
            for (;;)
            {
              if (bool1) {
                break label1050;
              }
              dh("权限校验失败", true);
              Log.e("WebDebugPage", "checkTempPerssion failed");
              break;
              str2 = str2.trim();
              i = str2.lastIndexOf("ticket");
              if ((i < 0) || (i >= str2.length()))
              {
                bool1 = false;
              }
              else
              {
                str2 = str2.substring(0, i);
                String str3 = new SimpleDateFormat("yyyyMMdd").format(new Date());
                bool1 = com.tencent.xweb.util.b.aZ(str2 + "@check_permission@" + str3, (String)localObject3, "MHYwEAYHKoZIzj0CAQYFK4EEACIDYgAE4s7oy+BvW5kzf5PwtVqDdZb2rVQS7GDf\naJWwtkD95ILDQAtHM9Nv5apLYQnUbXkjTldOUpjK7MimTkf/qXjQfk8hF2A0Mf7L\nHbDPr7kD9DOuQlG53SWOuKQVEwwsjN1l");
              }
            }
            label1050:
            Log.i("WebDebugPage", "checkTempPerssion suc");
            continue;
            bool1 = ((Uri)localObject1).getBooleanQueryParameter("show_x5_ver", false);
            paramString = x.fqR();
            if (bool1 != paramString.INc)
            {
              paramString.INc = bool1;
              paramString.IMY.getSharedPreferences("wcwebview", 0).edit().putBoolean("bShowX5Version", paramString.INc).commit();
            }
            if (bool1) {
              dh("开启显示x5内核信息", true);
            }
            for (;;)
            {
              AppMethodBeat.o(154226);
              return true;
              dh("关闭显示x5内核信息", true);
            }
            paramString = ((Uri)localObject1).getQueryParameter("encrpt_url");
            try
            {
              paramString = com.tencent.xweb.util.a.a(paramString, com.tencent.xweb.util.a.aPo("b01d4598de5875eb9b86abdef32b811e9c55edcfb1673b5617cc0a6ab7dceaff"));
              if (TextUtils.isEmpty(paramString))
              {
                dh("解密失败", true);
                AppMethodBeat.o(154226);
                return true;
              }
              aPe(paramString);
            }
            catch (Throwable paramString)
            {
              for (;;)
              {
                dh("解密失败", true);
              }
            }
            AppMethodBeat.o(154226);
            return true;
            o.lc(XWalkEnvironment.getApplicationContext());
            AppMethodBeat.o(154226);
            return true;
            bool1 = ((Uri)localObject1).getBooleanQueryParameter("show_fps", false);
            x.fqR().setShowFps(bool1);
            AppMethodBeat.o(154226);
            return true;
            try
            {
              localObject3 = WebView.c.valueOf(((Uri)localObject1).getQueryParameter("set_mm_config"));
              x.fqR().a("mm", (WebView.c)localObject3);
              dh("mm进程将使用:".concat(String.valueOf(localObject3)), true);
            }
            catch (Exception localException1) {}
            continue;
            try
            {
              WebView.c localc = WebView.c.valueOf(((Uri)localObject1).getQueryParameter("set_web_config"));
              x.fqR().a("tools", localc);
              x.fqR().a("toolsmp", localc);
              dh("打开网页将使用:".concat(String.valueOf(localc)), true);
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
          x.fqR().a("appbrand", (WebView.c)localObject4);
          x.fqR().a("support", (WebView.c)localObject4);
          switch (48.lCQ[localObject4.ordinal()])
          {
          case 1: 
            x.fqR().a(JsRuntime.JsRuntimeType.IML);
            dh("打开小程序将使用:".concat(String.valueOf(localObject4)), true);
            break;
          case 2: 
            x.fqR().a(JsRuntime.JsRuntimeType.IMI);
            dh("打开小程序将使用:".concat(String.valueOf(localObject4)), true);
            break;
          case 3: 
            x.fqR().a(JsRuntime.JsRuntimeType.IML);
            dh("打开小程序将使用:".concat(String.valueOf(localObject4)), true);
            continue;
            if (this.ISJ == null)
            {
              localObject4 = new ScrollView(this.IMY);
              this.ISJ = new TextView(this.IMY);
              this.ISJ.setTextColor(-16777216);
              this.ISJ.setBackgroundColor(-1);
              ((ScrollView)localObject4).addView(this.ISJ);
              this.ISJ.setOnClickListener(new c.12(this));
              fsQ();
              this.ISE.getTopView().addView((View)localObject4);
              continue;
              try
              {
                i = Integer.parseInt(((Uri)localObject1).getQueryParameter("set_grayvalue"));
                XWalkEnvironment.setGrayValueForTest(i);
                dh("灰度值设为" + i % 10000, true);
                bool2 = true;
              }
              catch (Exception localException3)
              {
                dh("灰度值设置失败，参数解析错误", true);
                bool2 = true;
              }
              continue;
              dh("开始检测浏览器和所有插件更新", true);
              fsV();
              la(XWalkEnvironment.getApplicationContext());
              continue;
              dh("模拟触发沙箱进程检测浏览器内核更新", true);
              XWalkEnvironment.setConfigFetchPeriod(1800001L);
              v.a(XWalkEnvironment.getApplicationContext(), null);
              continue;
              dh("重置上次拉取配置时间", true);
              Scheduler.ftx();
              continue;
              dh("清理本地的更新计划", true);
              Scheduler.ftt();
              continue;
              try
              {
                String str1 = ((Uri)localObject1).getQueryParameter("set_config_url");
                if ((XWalkEnvironment.isValidConfigHost(str1)) || (x.fqR().fqV())) {
                  break label1820;
                }
                dh("you have no athority to set this config url:".concat(String.valueOf(str1)), true);
              }
              catch (Exception localException4)
              {
                dh("测试连接设置失败，格式错误", true);
              }
              continue;
              label1820:
              XWalkEnvironment.setTestDownLoadUrl(this.IMY, localException4);
              dh("测试连接设置为:".concat(String.valueOf(localException4)), true);
              continue;
              bool3 = bool1;
              bool1 = bool2;
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
              if ((x.fqR().fqV()) || (bool3)) {}
              for (int k = 1;; k = 0)
              {
                j = 0;
                i = 0;
                if (!paramString.contains("debugxweb.qq.com"))
                {
                  bool2 = bool1;
                  if (!bool3) {
                    break label2768;
                  }
                }
                localObject1 = Uri.parse(paramString);
                localObject2 = ((Uri)localObject1).getQueryParameterNames();
                if ((localObject2 != null) && (((Set)localObject2).size() != 0)) {
                  break;
                }
                if (k != 0) {
                  fsT();
                }
                AppMethodBeat.o(154226);
                return true;
              }
              localObject2 = ((Set)localObject2).iterator();
              int j = i;
              if (((Iterator)localObject2).hasNext())
              {
                Object localObject5 = (String)((Iterator)localObject2).next();
                if (localObject5 != null) {
                  switch (((String)localObject5).hashCode())
                  {
                  default: 
                    label2196:
                    i = -1;
                    label2198:
                    switch (i)
                    {
                    }
                    break;
                  }
                }
                for (;;)
                {
                  break;
                  if (!((String)localObject5).equals("inspector")) {
                    break label2196;
                  }
                  i = 0;
                  break label2198;
                  if (!((String)localObject5).equals("use_testconfig")) {
                    break label2196;
                  }
                  i = 1;
                  break label2198;
                  if (!((String)localObject5).equals("kill_all")) {
                    break label2196;
                  }
                  i = 2;
                  break label2198;
                  if (!((String)localObject5).equals("ignore_crashwatch")) {
                    break label2196;
                  }
                  i = 3;
                  break label2198;
                  if (!((String)localObject5).equals("save_page")) {
                    break label2196;
                  }
                  i = 4;
                  break label2198;
                  if (!((String)localObject5).equals("clear_cache")) {
                    break label2196;
                  }
                  i = 5;
                  break label2198;
                  if (!((String)localObject5).equals("clear_old_ver")) {
                    break label2196;
                  }
                  i = 6;
                  break label2198;
                  if (!((String)localObject5).equals("fix_dex")) {
                    break label2196;
                  }
                  i = 7;
                  break label2198;
                  if (!((String)localObject5).equals("clear_all")) {
                    break label2196;
                  }
                  i = 8;
                  break label2198;
                  if (!((String)localObject5).equals("abandon_curent_ver")) {
                    break label2196;
                  }
                  i = 9;
                  break label2198;
                  bool1 = ((Uri)localObject1).getBooleanQueryParameter("inspector", false);
                  x.fqR().xB(bool1);
                  a(bool1, null, true);
                  bool1 = true;
                  break;
                  bool1 = ((Uri)localObject1).getBooleanQueryParameter("use_testconfig", false);
                  x.fqR().xC(bool1);
                  if (bool1) {
                    dh("使用测试config", true);
                  }
                  for (;;)
                  {
                    bool1 = true;
                    break;
                    dh("使用正式config", true);
                  }
                  bool1 = true;
                  j = 1;
                  break;
                  bool2 = ((Uri)localObject1).getBooleanQueryParameter("ignore_crashwatch", false);
                  localObject5 = x.fqR();
                  ((x)localObject5).INg = bool2;
                  ((x)localObject5).IMY.getSharedPreferences("wcwebview", 0).edit().putBoolean("ignore_crashwatch", bool2).commit();
                  dh("忽略crash检测设为 = ".concat(String.valueOf(bool2)), true);
                  break;
                  if (!x.fqR().INd) {}
                  for (bool2 = true;; bool2 = false)
                  {
                    localObject5 = x.fqR();
                    if (bool2 != ((x)localObject5).INd)
                    {
                      ((x)localObject5).INd = bool2;
                      ((x)localObject5).IMY.getSharedPreferences("wcwebview", 0).edit().putBoolean("bShowSavePage", ((x)localObject5).INd).commit();
                    }
                    if (!bool2) {
                      break label2680;
                    }
                    fsP();
                    this.ISK.setVisibility(0);
                    break;
                  }
                  label2680:
                  if (this.ISK != null)
                  {
                    this.ISK.setVisibility(8);
                    break;
                    af.clearAllWebViewCache(XWalkEnvironment.getApplicationContext(), true);
                    dh("网页cache已经清理:", true);
                    break;
                    o.H(XWalkEnvironment.getApplicationContext(), true);
                    dh("旧版本已经清理", true);
                    break;
                    o.ftb();
                    break;
                    XWalkEnvironment.clearAllVersion(this.IMY);
                    bool1 = true;
                    break;
                    o.fsZ();
                    bool1 = true;
                  }
                }
              }
              bool2 = bool1;
              label2768:
              bool1 = bool2;
              if (k != 0) {
                if ((!dg(paramString, bool3)) && (!bool2)) {
                  break label2812;
                }
              }
              label2812:
              for (bool1 = true;; bool1 = false)
              {
                if (j != 0) {
                  aVK();
                }
                AppMethodBeat.o(154226);
                return bool1;
              }
            }
            break;
          }
        }
        catch (Exception localException5) {}
      }
    }
  }
  
  final void aVK()
  {
    AppMethodBeat.i(154242);
    hr(this.IMY);
    AppMethodBeat.o(154242);
  }
  
  final void dh(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(154248);
    if (paramBoolean) {
      try
      {
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.IMY);
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
  
  final void di(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(154249);
    try
    {
      AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.IMY);
      localBuilder.setMessage(paramString);
      localBuilder.create();
      localBuilder.setCancelable(true);
      if (paramBoolean) {
        localBuilder.setOnCancelListener(new c.44(this));
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
    int i = this.ISE.getSettings().getForceDarkMode();
    int j = this.ISE.getSettings().getForceDarkBehavior();
    int k = kD(i, j);
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
  
  public final void frk()
  {
    AppMethodBeat.i(154225);
    if (x.fqR().INa) {
      a(x.fqR().INa, null, false);
    }
    AppMethodBeat.o(154225);
  }
  
  final void fsQ()
  {
    AppMethodBeat.i(154230);
    if (this.ISJ == null)
    {
      AppMethodBeat.o(154230);
      return;
    }
    Object localObject5 = XWalkEnvironment.getXWalkUpdateConfigUrl();
    Object localObject2 = "\n\n" + this.ISE.getAbstractInfo();
    localObject1 = localObject2;
    if (com.tencent.xweb.WebView.getCurWebType() != WebView.c.INC) {
      localObject1 = (String)localObject2 + "\n xwebsdk is = 200502 apk ver is " + XWalkEnvironment.getAvailableVersion();
    }
    localObject1 = (String)localObject1 + "\n\n current js engine: =  " + JsRuntime.fqF() + "\n prefered js engine =  " + JsRuntime.a(JsRuntime.JsRuntimeType.IMD, "appbrand", this.IMY) + "\n local gray value = " + XWalkEnvironment.getGrayValue() + "\n config url = " + (String)localObject5 + "\n config period(minutes) = " + Scheduler.ftA() / 60000L + "\n\n apilevel = " + Build.VERSION.SDK_INT + "\n device is  " + Build.BRAND + " " + Build.MODEL + "\n usertype is " + XWalkEnvironment.getUserType() + "\n runtime abi is " + XWalkEnvironment.getRuntimeAbi() + "\n device abi is " + XWalkEnvironment.getDeviceAbi() + "\n installed ver for arm32 is " + XWalkEnvironment.getInstalledNewstVersion("armeabi-v7a") + "\n installed ver for arm64 is " + XWalkEnvironment.getInstalledNewstVersion("arm64-v8a") + "\n should embed =  false\n embed lib md5 match =  true\n embed config ver =  0/0\n embed try installed ver =  " + XWalkUpdater.getLastTryInstallVer(XWalkEnvironment.getRuntimeAbi()) + "\n current useragent: " + this.ISE.getSettings().getUserAgentString() + "\n current clientversion: 0x" + Integer.toHexString(XWalkEnvironment.getAppClientVersion()) + "\n current app infos dump : " + XWalkEnvironment.dumpAppInfo();
    if (Scheduler.fts().ftu()) {
      localObject2 = new Date(Scheduler.ftC().IVN);
    }
    Object localObject6;
    for (localObject1 = (String)localObject1 + "\n has scheduler for apk ver = " + Scheduler.ftC().IVy + " version id = " + Scheduler.ftC().IVA + " update time in " + ((Date)localObject2).toString();; localObject1 = (String)localObject1 + "\n has no scheduler")
    {
      localObject1 = (String)localObject1 + "\n current update match gap backward(update speed) is " + Scheduler.xN(false);
      localObject2 = (String)localObject1 + "\n current update match gap forward(提前更新) is " + Scheduler.xN(true);
      localObject5 = com.tencent.xweb.a.getAbstractInfo();
      localObject1 = localObject2;
      if (localObject5 != null)
      {
        localObject1 = localObject2;
        if (!((String)localObject5).isEmpty()) {
          localObject1 = (String)localObject2 + "\n\n ------dump commands start:------\n" + (String)localObject5 + "\n ------dump commands end------";
        }
      }
      localObject2 = (String)localObject1 + "\n\n ------dump module prefer webview core start:------\n";
      localObject1 = localObject2;
      try
      {
        localObject2 = (String)localObject2 + a(this.IMY, WebView.c.IND, "tools") + "\n";
        localObject1 = localObject2;
        localObject2 = (String)localObject2 + a(this.IMY, WebView.c.INC, "toolsmp") + "\n";
        localObject1 = localObject2;
        localObject2 = (String)localObject2 + a(this.IMY, WebView.c.INB, "mm") + "\n";
        localObject1 = localObject2;
        localObject2 = (String)localObject2 + a(this.IMY, WebView.c.INC, "appbrand") + "\n";
        localObject1 = localObject2;
        localObject2 = (String)localObject2 + a(this.IMY, WebView.c.INC, "support") + "\n";
        localObject1 = localObject2;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          localObject1 = (String)localObject1 + localException1.getMessage() + "\n";
        }
        localException1.append("\n\n plugin commands:");
        localObject5 = com.tencent.xweb.b.getAbstractInfo();
        if (localObject5 == null) {
          break label1621;
        }
      }
      localObject1 = (String)localObject1 + "------dump module prefer webview core end------";
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("\n\n ------plugin info start:------\n plugin config url = ").append(XWalkEnvironment.getPluginConfigUrl()).append("\n plugin config period(minutes) = ").append(XWalkEnvironment.getPluginUpdatePeriod() / 60000).append("\n\n plugin version:");
      localObject5 = com.tencent.xweb.xwalk.a.g.ftk().iterator();
      while (((Iterator)localObject5).hasNext())
      {
        localObject6 = (com.tencent.xweb.xwalk.a.e)((Iterator)localObject5).next();
        if (localObject6 != null) {
          ((StringBuilder)localObject2).append("\n ").append(((com.tencent.xweb.xwalk.a.e)localObject6).getPluginName()).append(" = ").append(((com.tencent.xweb.xwalk.a.e)localObject6).IUH);
        }
      }
    }
    if (!((String)localObject5).isEmpty()) {
      localException1.append("\n").append((String)localObject5);
    }
    for (;;)
    {
      localException1.append("\n xfiles setting:");
      if (x.fqR() != null)
      {
        localException1.append("\n disable cache = ").append(x.fqR().fqS());
        localException1.append("\n disable crash detect = ").append(x.fqR().fqT());
      }
      localException1.append(fsU()).append("\n\n ------plugin info end:------");
      localObject6 = (String)localObject1 + localException1.toString();
      localObject5 = "";
      localObject1 = localObject5;
      try
      {
        SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        localObject3 = localObject5;
        localObject1 = localObject5;
        if (Scheduler.ftv())
        {
          localObject1 = localObject5;
          String str = localSimpleDateFormat.format(new Date(Scheduler.ftC().IVN));
          localObject1 = localObject5;
          localObject3 = "" + "going to update to apk ver = " + Scheduler.ftC().IVy;
          localObject1 = localObject3;
          localObject3 = (String)localObject3 + "\n update time is = " + str;
          localObject1 = localObject3;
          localObject3 = (String)localObject3 + "\n is patch update = " + Scheduler.ftC().IVL;
          localObject1 = localObject3;
          localObject3 = (String)localObject3 + "\n can use cellular = " + Scheduler.ftC().IVs;
          localObject1 = localObject3;
          localObject3 = (String)localObject3 + "\n updateHourStart = " + Scheduler.ftC().IVR;
          localObject1 = localObject3;
          localObject3 = (String)localObject3 + "\n updateHourEnd = " + Scheduler.ftC().IVS;
          localObject1 = localObject3;
          localObject3 = (String)localObject3 + "\n versionId = " + Scheduler.ftC().IVA;
          localObject1 = localObject3;
          localObject3 = (String)localObject3 + "\n update time is = " + str;
          localObject1 = localObject3;
          localObject3 = (String)localObject3 + "\n try count = " + Scheduler.ftC().IVP;
          localObject1 = localObject3;
          localObject3 = (String)localObject3 + "\n try use shared core count = " + Scheduler.ftC().IVQ;
          localObject1 = localObject3;
          localObject3 = (String)localObject3 + "\n";
        }
        localObject1 = localObject3;
        localObject5 = new Date(Scheduler.ftC().IVJ);
        localObject1 = localObject3;
        localObject3 = (String)localObject3 + " last fetch config time = " + localSimpleDateFormat.format((Date)localObject5);
        localObject1 = localObject3;
        localObject3 = (String)localObject3 + " last fetch config abi = " + Scheduler.ftC().IVK;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Object localObject3;
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
      this.ISJ.setText((CharSequence)localObject3);
      AppMethodBeat.o(154230);
      return;
      label1621:
      ((StringBuilder)localObject3).append("\n null\n");
    }
  }
  
  final void fsR()
  {
    AppMethodBeat.i(154231);
    if ((!x.fqR().INb) && ((!x.fqR().INc) || (this.ISE.getWebCoreType() != WebView.c.IND)))
    {
      AppMethodBeat.o(154231);
      return;
    }
    if (this.ISI != null)
    {
      AppMethodBeat.o(154231);
      return;
    }
    this.ISI = new TextView(this.IMY);
    this.ISI.setOnLongClickListener(new c.23(this));
    fsS();
    this.ISE.getTopView().addView(this.ISI);
    AppMethodBeat.o(154231);
  }
  
  final boolean fsT()
  {
    AppMethodBeat.i(154235);
    b(this.ISE);
    if (this.ISL != null)
    {
      this.ISL.setVisibility(0);
      AppMethodBeat.o(154235);
      return true;
    }
    this.ISL = ((LayoutInflater)this.IMY.getSystemService("layout_inflater")).inflate(2131493685, this.ISE.getTopView(), true).findViewById(2131306436);
    ((Button)this.ISL.findViewById(2131297647)).setOnClickListener(new c.34(this));
    Object localObject1 = (CheckBox)this.ISL.findViewById(2131298267);
    ((CheckBox)localObject1).setChecked(x.fqR().INb);
    ((CheckBox)localObject1).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(154208);
        paramAnonymousCompoundButton = x.fqR();
        if (paramAnonymousBoolean != paramAnonymousCompoundButton.INb)
        {
          paramAnonymousCompoundButton.INb = paramAnonymousBoolean;
          paramAnonymousCompoundButton.IMY.getSharedPreferences("wcwebview", 0).edit().putBoolean("bShowVersion", paramAnonymousCompoundButton.INb).commit();
        }
        if (paramAnonymousBoolean)
        {
          c.this.fsR();
          c.this.ISI.setVisibility(0);
          AppMethodBeat.o(154208);
          return;
        }
        if (c.this.ISI != null) {
          c.this.ISI.setVisibility(8);
        }
        AppMethodBeat.o(154208);
      }
    });
    ((TextView)this.ISL.findViewById(2131298247)).setOnClickListener(new c.49(this, (CheckBox)localObject1));
    localObject1 = (EditText)this.ISL.findViewById(2131306174);
    if (localObject1 != null)
    {
      ((EditText)localObject1).setInputType(2);
      ((EditText)localObject1).setText(XWalkEnvironment.getGrayValue());
      ((EditText)localObject1).addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(154213);
          paramAnonymousEditable = this.ITz.getText().toString();
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
    ((Spinner)this.ISL.findViewById(2131304547)).setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
    {
      public final void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        int i = 1;
        AppMethodBeat.i(154214);
        paramAnonymousAdapterView = c.this.IMY.getResources().getStringArray(2130903104);
        c.this.ISN = paramAnonymousAdapterView[paramAnonymousInt];
        paramAnonymousAdapterView = c.this;
        paramAnonymousAdapterView.ISM = true;
        WebView.c localc;
        if (paramAnonymousAdapterView.ISN.equals("all"))
        {
          paramAnonymousView = paramAnonymousAdapterView.IMY.getResources().getStringArray(2130903103);
          localc = x.fqR().aPc(paramAnonymousView[0]);
          paramAnonymousInt = i;
          if (paramAnonymousInt < paramAnonymousView.length) {
            if (x.fqR().aPc(paramAnonymousView[paramAnonymousInt]) != localc)
            {
              ((RadioButton)paramAnonymousAdapterView.ISL.findViewById(2131296280)).setChecked(false);
              ((RadioButton)paramAnonymousAdapterView.ISL.findViewById(2131296283)).setChecked(false);
              ((RadioButton)paramAnonymousAdapterView.ISL.findViewById(2131296282)).setChecked(false);
              ((RadioButton)paramAnonymousAdapterView.ISL.findViewById(2131296281)).setChecked(false);
            }
          }
        }
        for (;;)
        {
          paramAnonymousAdapterView.ISM = false;
          AppMethodBeat.o(154214);
          return;
          paramAnonymousInt += 1;
          break;
          paramAnonymousAdapterView.m(localc);
          continue;
          paramAnonymousAdapterView.m(x.fqR().aPc(paramAnonymousAdapterView.ISN));
        }
      }
      
      public final void onNothingSelected(AdapterView<?> paramAnonymousAdapterView) {}
    });
    ((RadioGroup)this.ISL.findViewById(2131306908)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(RadioGroup paramAnonymousRadioGroup, int paramAnonymousInt)
      {
        AppMethodBeat.i(154215);
        if (c.this.ISM)
        {
          AppMethodBeat.o(154215);
          return;
        }
        paramAnonymousRadioGroup = WebView.c.INB;
        if (paramAnonymousInt == 2131296280) {
          paramAnonymousRadioGroup = WebView.c.INB;
        }
        while (!c.this.ISN.equals("all"))
        {
          x.fqR().a(c.this.ISN, paramAnonymousRadioGroup);
          Log.d("WebDebugPage", "webview change to=".concat(String.valueOf(paramAnonymousRadioGroup)));
          AppMethodBeat.o(154215);
          return;
          if (paramAnonymousInt == 2131296283) {
            paramAnonymousRadioGroup = WebView.c.INC;
          } else if (paramAnonymousInt == 2131296282) {
            paramAnonymousRadioGroup = WebView.c.IND;
          } else if (paramAnonymousInt == 2131296281) {
            paramAnonymousRadioGroup = WebView.c.INE;
          }
        }
        String[] arrayOfString = c.this.IMY.getResources().getStringArray(2130903103);
        paramAnonymousInt = 0;
        while (paramAnonymousInt < arrayOfString.length)
        {
          x.fqR().a(arrayOfString[paramAnonymousInt], paramAnonymousRadioGroup);
          Log.d("WebDebugPage", "webview " + arrayOfString[paramAnonymousInt] + " change to=" + paramAnonymousRadioGroup);
          paramAnonymousInt += 1;
        }
        AppMethodBeat.o(154215);
      }
    });
    switch (48.ISl[x.fqR().INh.ordinal()])
    {
    default: 
      ((RadioGroup)this.ISL.findViewById(2131306258)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
      {
        public final void onCheckedChanged(RadioGroup paramAnonymousRadioGroup, int paramAnonymousInt)
        {
          AppMethodBeat.i(154153);
          paramAnonymousRadioGroup = JsRuntime.JsRuntimeType.IMD;
          if (paramAnonymousInt == 2131306255) {
            paramAnonymousRadioGroup = JsRuntime.JsRuntimeType.IMD;
          }
          for (;;)
          {
            x.fqR().a(paramAnonymousRadioGroup);
            Log.d("WebDebugPage", "v8 type change to=".concat(String.valueOf(paramAnonymousRadioGroup)));
            AppMethodBeat.o(154153);
            return;
            if (paramAnonymousInt == 2131306259) {
              paramAnonymousRadioGroup = JsRuntime.JsRuntimeType.IME;
            } else if (paramAnonymousInt == 2131306260) {
              paramAnonymousRadioGroup = JsRuntime.JsRuntimeType.IMI;
            } else if (paramAnonymousInt == 2131306257) {
              paramAnonymousRadioGroup = JsRuntime.JsRuntimeType.IMK;
            } else if (paramAnonymousInt == 2131306256) {
              paramAnonymousRadioGroup = JsRuntime.JsRuntimeType.IML;
            }
          }
        }
      });
      ((Button)this.ISL.findViewById(2131297654)).setOnClickListener(new c.3(this));
      localObject1 = (Button)this.ISL.findViewById(2131297586);
      a(x.fqR().INa, (Button)localObject1, false);
      ((Button)localObject1).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(154155);
          if (!x.fqR().INa) {}
          for (boolean bool = true;; bool = false)
          {
            x.fqR().xB(bool);
            c.this.a(bool, this.ISV, true);
            AppMethodBeat.o(154155);
            return;
          }
        }
      });
      ((Button)this.ISL.findViewById(2131297644)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(154156);
          XWalkEnvironment.clearAllVersion(c.this.IMY);
          AppMethodBeat.o(154156);
        }
      });
      ((Button)this.ISL.findViewById(2131297665)).setOnClickListener(new c.6(this));
      ((Button)this.ISL.findViewById(2131297657)).setOnClickListener(new c.7(this));
      localObject1 = (Button)this.ISL.findViewById(2131297649);
      if ((this.ISE.isXWalkKernel()) && (XWalkEnvironment.isCurrentVersionSupportForceDarkMode()))
      {
        ((Button)localObject1).setVisibility(0);
        label502:
        f((Button)localObject1);
        ((Button)localObject1).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(154159);
            paramAnonymousView = c.this;
            Button localButton = this.ISW;
            int i = paramAnonymousView.ISE.getSettings().getForceDarkMode();
            int j = paramAnonymousView.ISE.getSettings().getForceDarkBehavior();
            if ((i != 0) && (i == 2)) {
              if (j == 2) {
                paramAnonymousView.ISE.getSettings().setForceDarkBehavior(1);
              }
            }
            for (;;)
            {
              paramAnonymousView.f(localButton);
              AppMethodBeat.o(154159);
              return;
              if (j == 1)
              {
                paramAnonymousView.ISE.getSettings().setForceDarkMode(0);
              }
              else if (j == 0)
              {
                paramAnonymousView.ISE.getSettings().setForceDarkMode(0);
              }
              else
              {
                paramAnonymousView.ISE.getSettings().setForceDarkMode(2);
                paramAnonymousView.ISE.getSettings().setForceDarkBehavior(2);
              }
            }
          }
        });
        Object localObject2 = (Button)this.ISL.findViewById(2131297648);
        localObject1 = XWalkEnvironment.getXWalkUpdateConfigUrl();
        localObject1 = ((String)localObject1).substring(((String)localObject1).lastIndexOf('/') + 1);
        localObject1 = "(当前为" + (String)localObject1 + ")";
        if (!x.fqR().INi) {
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
            paramAnonymousView = x.fqR();
            boolean bool;
            Button localButton;
            if (!x.fqR().INi)
            {
              bool = true;
              paramAnonymousView.xC(bool);
              paramAnonymousView = XWalkEnvironment.getXWalkUpdateConfigUrl();
              paramAnonymousView = paramAnonymousView.substring(paramAnonymousView.lastIndexOf('/') + 1);
              paramAnonymousView = "(当前为" + paramAnonymousView + ")";
              localButton = this.ISX;
              if (!x.fqR().INi) {
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
        ((Button)this.ISL.findViewById(2131297668)).setOnClickListener(new c.10(this));
        localObject1 = (LinearLayout)this.ISL.findViewById(2131303310);
        ((LinearLayout)localObject1).setVisibility(8);
        localObject2 = (Button)this.ISL.findViewById(2131297663);
        ((Button)localObject2).setText("插件设置");
        ((Button)localObject2).setOnClickListener(new c.11(this, (LinearLayout)localObject1));
        localObject1 = (Button)this.ISL.findViewById(2131297662);
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
              this.ISZ.setText("切换插件配置，当前使用正式版");
              AppMethodBeat.o(154164);
              return;
            }
            c.this.dh("切换失败", true);
            AppMethodBeat.o(154164);
            return;
          }
          if (XWalkEnvironment.setPluginTestConfigUrl("https://dldir1.qq.com/weixin/android/wxweb/plugin/pluginUpdateConfig_test.xml"))
          {
            this.ISZ.setText("切换插件配置，当前使用默认测试版");
            AppMethodBeat.o(154164);
            return;
          }
          c.this.dh("切换失败", true);
          AppMethodBeat.o(154164);
        }
      });
      ((Button)this.ISL.findViewById(2131297669)).setOnClickListener(new c.14(this));
      ((Button)this.ISL.findViewById(2131297645)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(154166);
          paramAnonymousView = com.tencent.xweb.xwalk.a.g.ftk().iterator();
          while (paramAnonymousView.hasNext()) {
            ((com.tencent.xweb.xwalk.a.e)paramAnonymousView.next()).adn(-1);
          }
          paramAnonymousView = XWalkEnvironment.getPluginBaseDir();
          if (paramAnonymousView.isEmpty())
          {
            AppMethodBeat.o(154166);
            return;
          }
          com.tencent.xweb.util.c.aPq(paramAnonymousView);
          Toast.makeText(c.this.IMY, "清理完成", 0).show();
          AppMethodBeat.o(154166);
        }
      });
      ((Spinner)this.ISL.findViewById(2131305151)).setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
      {
        public final void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(154167);
          paramAnonymousAdapterView = c.this.IMY.getResources().getStringArray(2130903075);
          c.this.ISF = paramAnonymousAdapterView[paramAnonymousInt];
          AppMethodBeat.o(154167);
        }
        
        public final void onNothingSelected(AdapterView<?> paramAnonymousAdapterView) {}
      });
      ((Button)this.ISL.findViewById(2131297659)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(154169);
          c.a(c.this.IMY, c.this.ISF, false, new ValueCallback() {});
          AppMethodBeat.o(154169);
        }
      });
      ((Button)this.ISL.findViewById(2131297660)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(154171);
          c.a(c.this.IMY, c.this.ISF, true, new ValueCallback() {});
          AppMethodBeat.o(154171);
        }
      });
      ((Button)this.ISL.findViewById(2131297670)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(154172);
          c.cz(c.this.IMY, c.this.ISF);
          AppMethodBeat.o(154172);
        }
      });
      ((Button)this.ISL.findViewById(2131297646)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(154173);
          paramAnonymousView = com.tencent.xweb.xwalk.a.g.aOW(c.this.ISF);
          if (paramAnonymousView == null)
          {
            AppMethodBeat.o(154173);
            return;
          }
          int i = paramAnonymousView.IUH;
          if (i < 0)
          {
            AppMethodBeat.o(154173);
            return;
          }
          String str = paramAnonymousView.ado(i);
          paramAnonymousView.adn(-1);
          if ((str != null) && (!str.isEmpty())) {
            com.tencent.xweb.util.c.aPq(str);
          }
          Toast.makeText(c.this.IMY, "清理完成", 0).show();
          AppMethodBeat.o(154173);
        }
      });
      localObject1 = (CheckBox)this.ISL.findViewById(2131298265);
      ((CheckBox)localObject1).setChecked(x.fqR().fqS());
      ((CheckBox)localObject1).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
      {
        public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(154174);
          paramAnonymousCompoundButton = x.fqR().IMY.getSharedPreferences("wcwebview", 4);
          if (paramAnonymousCompoundButton != null)
          {
            paramAnonymousCompoundButton = paramAnonymousCompoundButton.edit();
            if (paramAnonymousCompoundButton != null)
            {
              paramAnonymousCompoundButton.putBoolean("fr_disable_cache", paramAnonymousBoolean);
              paramAnonymousCompoundButton.commit();
              if (paramAnonymousBoolean)
              {
                paramAnonymousCompoundButton = com.tencent.xweb.xwalk.a.g.ftk().iterator();
                while (paramAnonymousCompoundButton.hasNext())
                {
                  Object localObject = (com.tencent.xweb.xwalk.a.e)paramAnonymousCompoundButton.next();
                  if ((localObject instanceof k))
                  {
                    int i = ((com.tencent.xweb.xwalk.a.e)localObject).IUH;
                    if (i >= 0)
                    {
                      localObject = ((com.tencent.xweb.xwalk.a.e)localObject).adp(i);
                      if (!((String)localObject).isEmpty()) {
                        com.tencent.xweb.util.c.aPq((String)localObject);
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
      localObject1 = (CheckBox)this.ISL.findViewById(2131298266);
      ((CheckBox)localObject1).setChecked(x.fqR().fqT());
      ((CheckBox)localObject1).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
      {
        public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(154175);
          paramAnonymousCompoundButton = x.fqR().IMY.getSharedPreferences("wcwebview", 4);
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
      ((TextView)this.ISL.findViewById(2131305730)).setText(fsU());
      localObject1 = (EditText)this.ISL.findViewById(2131299264);
      ((Button)this.ISL.findViewById(2131297652)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(154177);
          c.a(c.this, this.ITc.getText().toString(), f.a.IMu);
          AppMethodBeat.o(154177);
        }
      });
      ((Button)this.ISL.findViewById(2131297651)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(154178);
          c.a(c.this, this.ITc.getText().toString(), f.a.IMv);
          AppMethodBeat.o(154178);
        }
      });
      ((Button)this.ISL.findViewById(2131297650)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(154179);
          c.a(c.this, this.ITc.getText().toString(), f.a.IMt);
          AppMethodBeat.o(154179);
        }
      });
      ((TextView)this.ISL.findViewById(2131306169)).setText(xJ(true) + "\n" + XWalkInitializer.getXWalkInitializeLog());
      ((LinearLayout)this.ISL.findViewById(2131298553)).setVisibility(8);
      ((Button)this.ISL.findViewById(2131297643)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(154180);
          XWalkEnvironment.setGrayValueForTest(1);
          if (!XWalkEnvironment.hasAvailableVersion())
          {
            if (XWalkEnvironment.isIaDevice())
            {
              c.this.aPe("http://debugxweb.qq.com/?set_web_config=WV_KIND_CW&set_appbrand_config=WV_KIND_CW&set_config_url=https://dldir1.qq.com/weixin/android/wxweb/updateConfig_x86_test.xml&check_xwalk_update");
              AppMethodBeat.o(154180);
              return;
            }
            c.this.aPe("http://debugxweb.qq.com/?set_web_config=WV_KIND_CW&set_appbrand_config=WV_KIND_CW&set_config_url=https://dldir1.qq.com/weixin/android/wxweb/updateConfig_test.xml&check_xwalk_update");
            AppMethodBeat.o(154180);
            return;
          }
          x.fqR().a("tools", WebView.c.INC);
          x.fqR().a("toolsmp", WebView.c.INC);
          x.fqR().a("appbrand", WebView.c.INC);
          x.fqR().a("support", WebView.c.INC);
          x.fqR().a("mm", WebView.c.INC);
          c.this.di("已使用XWeb，点任意位置重启进程生效\n", true);
          AppMethodBeat.o(154180);
        }
      });
      ((Button)this.ISL.findViewById(2131297642)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(154181);
          x.fqR().a("tools", WebView.c.IND);
          x.fqR().a("toolsmp", WebView.c.IND);
          x.fqR().a("appbrand", WebView.c.IND);
          x.fqR().a("support", WebView.c.IND);
          x.fqR().a("mm", WebView.c.IND);
          if (com.tencent.xweb.WebView.getInstalledTbsCoreVersion(c.this.IMY) <= 0)
          {
            c.this.dh("已切换x5，但是x5未ready，点任意位置重启进程生效\n", true);
            AppMethodBeat.o(154181);
            return;
          }
          c.this.di("已使用x5，点任意位置重启进程生效\n", true);
          AppMethodBeat.o(154181);
        }
      });
      ((Button)this.ISL.findViewById(2131297641)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(154182);
          x.fqR().a("tools", WebView.c.INE);
          x.fqR().a("toolsmp", WebView.c.INE);
          x.fqR().a("appbrand", WebView.c.INE);
          x.fqR().a("support", WebView.c.INE);
          x.fqR().a("mm", WebView.c.INE);
          c.this.di("已使用system，点任意位置重启进程生效\n", true);
          AppMethodBeat.o(154182);
        }
      });
      ((Button)this.ISL.findViewById(2131297640)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(154183);
          XWalkEnvironment.setGrayValueForTest(0);
          XWalkEnvironment.setTestDownLoadUrl(c.this.IMY, "");
          x.fqR().a("tools", WebView.c.INB);
          x.fqR().a("toolsmp", WebView.c.INB);
          x.fqR().a("appbrand", WebView.c.INB);
          x.fqR().a("support", WebView.c.INB);
          x.fqR().a("mm", WebView.c.INB);
          c.this.di("已使用AUTO，点任意位置重启进程生效\n", true);
          AppMethodBeat.o(154183);
        }
      });
      ((Button)this.ISL.findViewById(2131297639)).setOnClickListener(new c.31(this));
      ((Button)this.ISL.findViewById(2131297666)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(154185);
          v.a(c.this.IMY, null);
          AppMethodBeat.o(154185);
        }
      });
      localObject1 = (Button)this.ISL.findViewById(2131297658);
      ((Button)localObject1).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(154186);
          paramAnonymousView = c.this;
          Object localObject1 = new com.tencent.xweb.b.h(Environment.getExternalStorageDirectory());
          ((com.tencent.xweb.b.h)localObject1).frE();
          localObject1 = ((com.tencent.xweb.b.h)localObject1).getPath() + "/xweb_dump";
          Object localObject2;
          Object localObject3;
          try
          {
            localObject2 = new com.tencent.xweb.b.h((String)localObject1);
            localObject3 = ((com.tencent.xweb.b.h)localObject2).frE();
            if (localObject3.length == 0)
            {
              paramAnonymousView.dh("web_dump目录下没有.zip文件,请确认应用权限，在权限管理打开应用的读写存储权限", true);
              AppMethodBeat.o(154186);
              return;
            }
          }
          catch (Exception localException)
          {
            paramAnonymousView.dh("没有找到web_dump目录,请确认应用权限，在权限管理打开应用的读写存储权限", true);
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
              new AlertDialog.Builder(paramAnonymousView.IMY).setTitle("提示").setMessage("确定加载:" + (String)localObject3 + "?").setPositiveButton("确定", new c.43(paramAnonymousView, localException, (String)localObject2)).setNegativeButton("取消", new c.42(paramAnonymousView)).show();
              AppMethodBeat.o(154186);
              return;
            }
            i += 1;
          }
          paramAnonymousView.dh("web_dump目录下没有.zip文件", true);
          AppMethodBeat.o(154186);
        }
      });
      ((Button)this.ISL.findViewById(2131297667)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(154188);
          boolean bool;
          if (!x.fqR().INj)
          {
            bool = true;
            x.fqR().setShowFps(bool);
            c.b(c.this.ISE);
            if (!bool) {
              break label60;
            }
          }
          label60:
          for (paramAnonymousView = "打开显示fps";; paramAnonymousView = "关闭显示fps")
          {
            c.this.di(paramAnonymousView, false);
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
          new AlertDialog.Builder(c.this.IMY).setTitle("提示").setMessage("清空保存页面文件").setPositiveButton("确定", new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(154189);
              c.b(c.this, Environment.getExternalStorageDirectory() + "/xweb_dump");
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
      ((Button)this.ISL.findViewById(2131297661)).setOnClickListener(this.ISS);
      AppMethodBeat.o(154235);
      return true;
      ((RadioButton)this.ISL.findViewById(2131306255)).setChecked(true);
      break;
      ((RadioButton)this.ISL.findViewById(2131306259)).setChecked(true);
      break;
      ((RadioButton)this.ISL.findViewById(2131306260)).setChecked(true);
      break;
      ((RadioButton)this.ISL.findViewById(2131306257)).setChecked(true);
      break;
      ((RadioButton)this.ISL.findViewById(2131306256)).setChecked(true);
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
  
  final void fsV()
  {
    AppMethodBeat.i(154241);
    com.tencent.xweb.a.a(null, "0");
    SharedPreferences.Editor localEditor = XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
    localEditor.putLong("nLastFetchConfigTime", 0L);
    localEditor.putBoolean("bCanUseCellular", true);
    localEditor.putLong("nTimeToUpdate", 100L);
    localEditor.commit();
    Scheduler.ftC().IVJ = 100L;
    Scheduler.ftC().IVs = true;
    Scheduler.ftC().IVN = 100L;
    new b(this.IMY).o(null);
    AppMethodBeat.o(154241);
  }
  
  final void m(WebView.c paramc)
  {
    AppMethodBeat.i(154234);
    switch (48.lCQ[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(154234);
      return;
      ((RadioButton)this.ISL.findViewById(2131296280)).setChecked(true);
      AppMethodBeat.o(154234);
      return;
      ((RadioButton)this.ISL.findViewById(2131296283)).setChecked(true);
      AppMethodBeat.o(154234);
      return;
      ((RadioButton)this.ISL.findViewById(2131296282)).setChecked(true);
      AppMethodBeat.o(154234);
      return;
      ((RadioButton)this.ISL.findViewById(2131296281)).setChecked(true);
    }
  }
  
  final String xJ(boolean paramBoolean)
  {
    AppMethodBeat.i(154232);
    String str2 = this.ISE.getVersionInfo();
    int i;
    if (!paramBoolean)
    {
      i = str2.indexOf(",apkversion");
      str1 = str2;
      if (i <= 0) {}
    }
    for (String str1 = str2.substring(0, i);; str1 = str2 + ", " + com.tencent.xweb.xwalk.a.g.ftl() + " current process is " + XWalkEnvironment.getProcessName())
    {
      AppMethodBeat.o(154232);
      return str1;
    }
  }
  
  final void xK(boolean paramBoolean)
  {
    AppMethodBeat.i(154246);
    Object localObject1 = new com.tencent.xweb.b.h(Environment.getExternalStorageDirectory());
    ((com.tencent.xweb.b.h)localObject1).frE();
    localObject1 = ((com.tencent.xweb.b.h)localObject1).getPath() + "/apkxwebtest";
    Object localObject2;
    try
    {
      localObject1 = new com.tencent.xweb.b.h((String)localObject1);
      localObject2 = ((com.tencent.xweb.b.h)localObject1).frE();
      if (localObject2.length == 0)
      {
        dh("apkxwebtest目录下没有.zip文件,请确认应用权限，在权限管理打开应用的读写存储权限", true);
        AppMethodBeat.o(154246);
        return;
      }
    }
    catch (Exception localException)
    {
      dh("没有找到apkxwebtest目录,请确认应用权限，在权限管理打开应用的读写存储权限", true);
      AppMethodBeat.o(154246);
      return;
    }
    int i = 0;
    while (i < localObject2.length)
    {
      if (localObject2[i].getName().endsWith(".zip"))
      {
        String str = localObject2[i].getAbsolutePath();
        localObject2 = localObject2[i].getName();
        if (paramBoolean)
        {
          new AlertDialog.Builder(this.IMY).setTitle("提示").setMessage("确定加载:" + (String)localObject2 + "?").setPositiveButton("确定", new c.41(this, str, (String)localObject2, paramBoolean)).setNegativeButton("取消", new c.40(this)).show();
          AppMethodBeat.o(154246);
          return;
        }
        G(str, (String)localObject2, paramBoolean);
        AppMethodBeat.o(154246);
        return;
      }
      i += 1;
    }
    dh("apkxwebtest目录下没有.zip文件", true);
    AppMethodBeat.o(154246);
  }
  
  static final class a
    extends XWalkUpdater.UpdateConfig
  {
    String ITA;
    
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
      this.ITA = paramString1;
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
    extends o
  {
    boolean ITB = false;
    private ProgressDialog ITf;
    
    public b(Context paramContext)
    {
      super();
    }
    
    private void aPD(String paramString)
    {
      AppMethodBeat.i(154223);
      if (this.ITf == null)
      {
        this.ITf = new ProgressDialog(this.mContext);
        this.ITf.setProgressStyle(1);
        this.ITf.setMessage(paramString);
        this.ITf.setOnCancelListener(new c.b.1(this));
        this.ITf.setCancelable(false);
        this.ITf.show();
      }
      this.ITf.setMessage(paramString);
      AppMethodBeat.o(154223);
    }
    
    public final void onXWalkUpdateCancelled()
    {
      AppMethodBeat.i(154221);
      super.onXWalkUpdateCancelled();
      try
      {
        this.ITf.setCancelable(true);
        this.ITf.setCanceledOnTouchOutside(true);
        aPD("更新失败, 更新被取消");
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
        aPD("更新完成，点任意位置重启进程生效");
        this.ITf.setCancelable(true);
        this.ITf.setCanceledOnTouchOutside(true);
        this.ITf.setProgress(100);
        this.ITB = true;
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
        this.ITf.setCancelable(true);
        this.ITf.setCanceledOnTouchOutside(true);
        aPD("更新失败, error code = :".concat(String.valueOf(paramInt)));
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
      if (this.ITB)
      {
        AppMethodBeat.o(154219);
        return;
      }
      try
      {
        aPD("正在下载runtime");
        if (this.ITf != null) {
          this.ITf.setProgress(paramInt);
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
 * Qualified Name:     com.tencent.xweb.xwalk.c
 * JD-Core Version:    0.7.0.1
 */