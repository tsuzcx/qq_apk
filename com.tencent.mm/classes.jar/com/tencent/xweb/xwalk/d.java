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
import android.content.pm.ApplicationInfo;
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
import com.tencent.xweb.aa;
import com.tencent.xweb.aj;
import com.tencent.xweb.b.i;
import com.tencent.xweb.e;
import com.tencent.xweb.f;
import com.tencent.xweb.f.a;
import com.tencent.xweb.f.c;
import com.tencent.xweb.internal.l;
import com.tencent.xweb.internal.l.a;
import com.tencent.xweb.q;
import com.tencent.xweb.s;
import com.tencent.xweb.s.a;
import com.tencent.xweb.w;
import com.tencent.xweb.xwalk.a.a.a;
import com.tencent.xweb.xwalk.a.m;
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
import org.xwalk.core.R.array;
import org.xwalk.core.R.id;
import org.xwalk.core.R.layout;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;
import org.xwalk.core.XWalkPreferences;

public final class d
  implements com.tencent.xweb.internal.d
{
  Context aaaH;
  com.tencent.xweb.WebView aahe;
  String aahf;
  ScrollView aahg;
  TextView aahh;
  TextView aahi;
  TextView aahj;
  Button aahk;
  View aahl;
  boolean aahm;
  String aahn;
  private final String aaho;
  private final String aahp;
  private final String aahq;
  private final String aahr;
  private View.OnClickListener aahs;
  
  public d(com.tencent.xweb.WebView paramWebView)
  {
    AppMethodBeat.i(154224);
    this.aahf = "";
    this.aahg = null;
    this.aahh = null;
    this.aahi = null;
    this.aahj = null;
    this.aahk = null;
    this.aahm = false;
    this.aahn = "tools";
    this.aaho = "当前Dark Mode强制智能反色[%d,%d]（点击切换）";
    this.aahp = "当前Dark Mode不强制智能反色[%d,%d]（点击切换）";
    this.aahq = "当前Light Mode[%d,%d]（点击切换）";
    this.aahr = "当前未知Mode[%d,%d]（点击切换）";
    this.aahs = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(205493);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/xweb/xwalk/WebDebugPage$45", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        d.this.aahl.setVisibility(8);
        d.this.aahe.startLongScreenshot(new q()
        {
          public final File getCacheFileDir()
          {
            AppMethodBeat.i(204420);
            File localFile = new File(d.this.aaaH.getExternalCacheDir().getAbsolutePath(), "LongScreenshot");
            AppMethodBeat.o(204420);
            return localFile;
          }
          
          public final int getMaxHeightSupported()
          {
            return 0;
          }
          
          public final File getResultFileDir()
          {
            AppMethodBeat.i(204422);
            File localFile = new File(d.this.aaaH.getExternalCacheDir().getAbsolutePath(), "LongScreenshot");
            AppMethodBeat.o(204422);
            return localFile;
          }
          
          public final void onLongScreenshotFinished(int paramAnonymous2Int, String paramAnonymous2String)
          {
            AppMethodBeat.i(204418);
            Log.d("WebDebugPage", "onLongScreenshotFinished with " + paramAnonymous2Int + " / " + paramAnonymous2String);
            AppMethodBeat.o(204418);
          }
          
          public final Bitmap overrideScreenshot(Bitmap paramAnonymous2Bitmap)
          {
            return paramAnonymous2Bitmap;
          }
        }, true);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$45", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(205493);
      }
    };
    this.aaaH = paramWebView.getContext();
    this.aahe = paramWebView;
    iyB();
    iyz();
    AppMethodBeat.o(154224);
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
    if (com.tencent.xweb.a.bEC(paramString) != WebView.c.aabl)
    {
      paramc = com.tencent.xweb.a.bEC(paramString);
      localStringBuilder.append("\n   has command type ".concat(String.valueOf(paramc)));
    }
    if (y.iwp().dU(paramString, true) != WebView.c.aabl)
    {
      paramc = y.iwp().dU(paramString, true);
      localStringBuilder.append("\n   has abtest type ".concat(String.valueOf(paramc)));
    }
    for (int i = 1;; i = 0)
    {
      if (y.iwp().dU(paramString, false) != WebView.c.aabl)
      {
        paramContext = y.iwp().bFj(paramString);
        localStringBuilder.append("\n   has hardcode type ".concat(String.valueOf(paramContext)));
        i = j;
      }
      for (;;)
      {
        if ((i == 0) && (paramContext == WebView.c.aabm) && (XWalkEnvironment.getXWebInitArgs("isgpversion", false)))
        {
          paramContext = WebView.c.aabo;
          localStringBuilder.append("\n   is prefer " + paramContext + " because of gp version");
        }
        for (;;)
        {
          paramc = paramContext;
          if (paramContext == WebView.c.aabm)
          {
            paramc = paramContext;
            if (!XWalkEnvironment.hasAvailableVersion())
            {
              paramc = WebView.c.aabn;
              localStringBuilder.append("\n   is prefer " + paramc + " because of xwalk is not available");
            }
          }
          com.tencent.xweb.internal.h.e(paramc);
          if (com.tencent.xweb.internal.h.ixo().ixt())
          {
            paramc = WebView.c.aabo;
            localStringBuilder.append("\n   is prefer " + paramc + " because of LoadUrlWatchDog");
          }
          if (com.tencent.xweb.internal.b.c(paramc)) {
            localStringBuilder.append("\n   will not use " + paramc + " because of CrashWatchDog hit");
          }
          if (paramc == WebView.c.aabn) {
            com.tencent.xweb.x5.sdk.d.iyx();
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
    localh.ixd();
    final com.tencent.xweb.xwalk.a.g localg = com.tencent.xweb.xwalk.a.h.bEW(paramString);
    if (localg == null)
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
        private ProgressDialog DUF = null;
        
        private Boolean iyH()
        {
          int i = 99999;
          boolean bool = true;
          AppMethodBeat.i(205949);
          Object localObject2 = null;
          for (;;)
          {
            try
            {
              int k = localg.izd();
              com.tencent.xweb.xwalk.b.d locald;
              if (this.aahN > 0)
              {
                int j = this.aahN;
                i = j;
                if (k > 0)
                {
                  localObject1 = localg.aCZ(k);
                  localg.aCY(-1);
                  i = j;
                  if (localObject1 != null)
                  {
                    i = j;
                    if (!((String)localObject1).isEmpty())
                    {
                      com.tencent.xweb.util.c.bFA((String)localObject1);
                      i = j;
                    }
                  }
                }
                locald = new com.tencent.xweb.xwalk.b.d();
                locald.version = i;
                locald.aakU = false;
                locald.path = localg.cm(i, false);
                localObject1 = new File(locald.path);
              }
              try
              {
                if (this.aahO)
                {
                  com.tencent.xweb.util.c.a(this.val$context.getAssets().open(paramString), (File)localObject1);
                  locald.aakv = i.buc(((File)localObject1).getPath());
                  locald.aald = true;
                  if (localg.a(locald) != 0) {
                    continue;
                  }
                  AppMethodBeat.o(205949);
                  return Boolean.valueOf(bool);
                  if (k < 99999) {
                    continue;
                  }
                  i = k + 1;
                  continue;
                }
                i.copyFile(this.aahQ, ((File)localObject1).getPath());
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
              AppMethodBeat.o(205949);
              return localObject1;
              bool = false;
            }
            catch (Exception localException1) {}
          }
        }
        
        protected final void onPreExecute()
        {
          AppMethodBeat.i(205947);
          this.DUF = new ProgressDialog(this.val$context);
          this.DUF.setProgressStyle(0);
          this.DUF.setMessage("安装中");
          this.DUF.setCancelable(false);
          this.DUF.setCanceledOnTouchOutside(false);
          this.DUF.setButton(-1, "完成", new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(205166);
              d.42.a(d.42.this).hide();
              AppMethodBeat.o(205166);
            }
          });
          this.DUF.show();
          this.DUF.getButton(-1).setVisibility(8);
          AppMethodBeat.o(205947);
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
      } else if ("XFilesOfficeReader".equals(paramString))
      {
        if (paramBoolean) {
          paramString = "xfiles_office_reader_arm64.zip";
        } else {
          paramString = "xfiles_office_reader_arm.zip";
        }
      }
      else {
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
    //   3: ldc_w 447
    //   6: invokestatic 152	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: ifnull +12 -> 22
    //   13: invokestatic 270	com/tencent/xweb/y:iwp	()Lcom/tencent/xweb/y;
    //   16: getfield 450	com/tencent/xweb/y:aaaS	Z
    //   19: ifne +13 -> 32
    //   22: ldc_w 447
    //   25: invokestatic 212	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: ldc 2
    //   30: monitorexit
    //   31: return
    //   32: aload_0
    //   33: invokestatic 452	com/tencent/xweb/xwalk/d:b	(Lcom/tencent/xweb/internal/IWebView;)V
    //   36: ldc_w 447
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
  
  private void aoa(String paramString)
  {
    AppMethodBeat.i(154240);
    com.tencent.xweb.b.h localh = new com.tencent.xweb.b.h(paramString);
    if (localh.isDirectory())
    {
      String[] arrayOfString = localh.ifI();
      if (arrayOfString != null)
      {
        int i = 0;
        while (i < arrayOfString.length)
        {
          aoa(paramString + "//" + arrayOfString[i]);
          i += 1;
        }
      }
    }
    localh.cFq();
    AppMethodBeat.o(154240);
  }
  
  /* Error */
  public static void b(com.tencent.xweb.internal.IWebView paramIWebView)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 553
    //   6: invokestatic 152	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: ifnull +12 -> 22
    //   13: invokestatic 270	com/tencent/xweb/y:iwp	()Lcom/tencent/xweb/y;
    //   16: getfield 450	com/tencent/xweb/y:aaaS	Z
    //   19: ifne +13 -> 32
    //   22: ldc_w 553
    //   25: invokestatic 212	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: ldc 2
    //   30: monitorexit
    //   31: return
    //   32: aload_0
    //   33: ldc_w 555
    //   36: new 92	com/tencent/xweb/xwalk/d$50
    //   39: dup
    //   40: invokespecial 556	com/tencent/xweb/xwalk/d$50:<init>	()V
    //   43: invokeinterface 562 3 0
    //   48: ldc_w 553
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
  
  public static boolean bFM(String paramString)
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
      com.tencent.xweb.util.h.Xg(223L);
      Log.e("WebDebugPage", "this url contians debug piece, url =  ".concat(String.valueOf(paramString)));
    }
    AppMethodBeat.o(154252);
    return bool;
  }
  
  public static void dl(Context paramContext, final String paramString)
  {
    AppMethodBeat.i(210390);
    final com.tencent.xweb.xwalk.a.k localk = new com.tencent.xweb.xwalk.a.k();
    localk.a(paramString, new com.tencent.xweb.xwalk.a.j()
    {
      ProgressDialog aahG = null;
      boolean mFinished = false;
      
      public final void aCH(int paramAnonymousInt)
      {
        AppMethodBeat.i(204909);
        if ((this.mFinished) || (this.aahG == null))
        {
          AppMethodBeat.o(204909);
          return;
        }
        this.aahG.setProgress(paramAnonymousInt);
        AppMethodBeat.o(204909);
      }
      
      public final void aCI(int paramAnonymousInt)
      {
        AppMethodBeat.i(204910);
        this.mFinished = true;
        if (this.aahG == null)
        {
          AppMethodBeat.o(204910);
          return;
        }
        Object localObject = com.tencent.xweb.xwalk.a.h.bEW(paramString);
        int i;
        if (localObject != null)
        {
          i = ((com.tencent.xweb.xwalk.a.g)localObject).izd();
          switch (paramAnonymousInt)
          {
          default: 
            this.aahG.setMessage(paramString + " 更新失败，未知错误，ErrCode = " + paramAnonymousInt);
            label129:
            if ((this.aahK != null) && (y.iwp() != null))
            {
              if (!"XFilesPPTReader".equals(paramString)) {
                break label697;
              }
              localObject = new String[2];
              localObject[0] = "ppt";
              localObject[1] = "pptx";
            }
            break;
          }
        }
        for (;;)
        {
          String str = y.iwp().a((String[])localObject, this.aahK);
          e.ah((String[])localObject);
          Toast.makeText(this.val$context, "格式:" + str + "强制使用" + this.aahK.name() + "打开", 0).show();
          if (this.oSF != null) {
            this.oSF.onReceiveValue(Integer.valueOf(paramAnonymousInt));
          }
          AppMethodBeat.o(204910);
          return;
          i = -1;
          break;
          this.aahG.setMessage(paramString + " 更新完成，已安装版本" + i);
          this.aahG.setProgress(100);
          this.aahG.getButton(-2).setVisibility(8);
          this.aahG.getButton(-1).setVisibility(0);
          if (!this.aahJ) {
            break label129;
          }
          this.aahG.dismiss();
          break label129;
          this.aahG.setMessage(paramString + " 更新被取消，ErrCode = " + paramAnonymousInt);
          break label129;
          this.aahG.setMessage(paramString + " 更新失败，无网络，ErrCode = " + paramAnonymousInt);
          break label129;
          this.aahG.setMessage(paramString + " 更新失败，未到检查时间，ErrCode = " + paramAnonymousInt);
          break label129;
          this.aahG.setMessage(paramString + " 更新失败，其它任务正在更新插件，ErrCode = " + paramAnonymousInt);
          break label129;
          this.aahG.setMessage(paramString + " 更新失败，配置下载失败，ErrCode = " + paramAnonymousInt);
          break label129;
          this.aahG.setMessage(paramString + " 更新失败，配置解析失败，ErrCode = " + paramAnonymousInt);
          break label129;
          this.aahG.setMessage(paramString + " 更新失败，配置中未包含插件信息，ErrCode = " + paramAnonymousInt);
          break label129;
          this.aahG.setMessage(paramString + " 更新失败，未找到可用更新，当前已安装版本" + i + "，ErrCode = " + paramAnonymousInt);
          if (!this.aahJ) {
            break label129;
          }
          this.aahG.dismiss();
          break label129;
          this.aahG.setMessage(paramString + " 更新失败，下载安装出错，ErrCode = " + paramAnonymousInt);
          break label129;
          label697:
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
          else if ("XFilesExcelReader".equals(paramString))
          {
            localObject = new String[2];
            localObject[0] = "xls";
            localObject[1] = "xlsx";
          }
          else
          {
            if (!"XFilesOfficeReader".equals(paramString)) {
              break label833;
            }
            localObject = new String[6];
            localObject[0] = "doc";
            localObject[1] = "docx";
            localObject[2] = "xls";
            localObject[3] = "xlsx";
            localObject[4] = "ppt";
            localObject[5] = "pptx";
          }
        }
        label833:
        AppMethodBeat.o(204910);
      }
      
      public final void iwb()
      {
        AppMethodBeat.i(204908);
        this.aahG = new ProgressDialog(this.val$context);
        this.aahG.setProgressStyle(1);
        this.aahG.setMessage(paramString + " 下载更新中");
        this.aahG.setCancelable(false);
        this.aahG.setCanceledOnTouchOutside(false);
        this.aahG.setButton(-2, "取消", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(205035);
            if (!d.41.this.mFinished) {
              d.41.this.aahI.iwn();
            }
            AppMethodBeat.o(205035);
          }
        });
        this.aahG.setButton(-1, "完成", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(204958);
            d.41.this.aahG.dismiss();
            AppMethodBeat.o(204958);
          }
        });
        this.aahG.show();
        this.aahG.getButton(-1).setVisibility(8);
        AppMethodBeat.o(204908);
      }
    });
    paramString = new HashMap();
    paramString.put("UpdaterCheckType", "1");
    localk.b(paramContext, paramString);
    AppMethodBeat.o(210390);
  }
  
  private boolean eb(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(154227);
    if ((paramString.contains("debugxweb.qq.com")) || (paramBoolean))
    {
      Uri localUri = Uri.parse(paramString);
      paramString = localUri.getQueryParameterNames();
      if ((paramString == null) || (paramString.size() == 0))
      {
        iyD();
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
              IV(false);
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
              if (!paramString.equals("set_force_filereader")) {
                break label200;
              }
              i = 9;
              continue;
              if (!paramString.equals("set_force_use_office_reader")) {
                break label200;
              }
              i = 10;
              continue;
              if (!paramString.equals("clear_all_plugin")) {
                break label200;
              }
              i = 11;
            }
          }
          com.tencent.xweb.a.a(null, "0");
          continue;
          paramBoolean = localUri.getBooleanQueryParameter("wait_debugger", false);
          paramString = y.iwp();
          paramString.aaaO = paramBoolean;
          paramString.aaaH.getSharedPreferences("wcwebview", 0).edit().putBoolean("bWaitforDebugger", paramBoolean).commit();
          continue;
          paramString = localUri.getQueryParameter("debug_process");
          y.iwp().aaaH.getSharedPreferences("wcwebview", 4).edit().putString("strDebugProcess", paramString).commit();
          continue;
          paramString = localUri.getQueryParameter("set_apkver");
          try
          {
            XWalkEnvironment.setAvailableVersion(Integer.parseInt(paramString), "1.0.".concat(String.valueOf(paramString)), XWalkEnvironment.getRuntimeAbi());
            ed("版本号设置到:" + paramString + " 点击空白处退出重启进程", true);
          }
          catch (Exception paramString)
          {
            ec("设置版本号失败:" + paramString.getMessage(), true);
          }
          continue;
          p.IW(true);
          continue;
          paramString = localUri.getQueryParameter("revert_to_apk");
          try
          {
            i = p.bq(XWalkEnvironment.getApplicationContext(), Integer.parseInt(paramString));
            ed("版本号回滚到:" + i + " 点击空白处退出重启进程", true);
          }
          catch (Exception paramString)
          {
            ec("版本号回滚到失败:" + paramString.getMessage(), true);
          }
          continue;
          paramString = localUri.getQueryParameter("set_config_peroid");
          try
          {
            com.tencent.xweb.a.aCG(Integer.parseInt(paramString));
            ed("设置配置拉取周期为:" + paramString + "分钟", false);
          }
          catch (Exception paramString)
          {
            ec("设置配置拉取周期失败:" + paramString.getMessage(), true);
          }
          continue;
          l.h(WebView.c.aabm).excute("STR_CMD_SET_RECHECK_COMMAND", null);
          ed("重新跑了一遍命令配置 点击空白处退出重启进程", true);
          continue;
          paramString = "";
        }
        try
        {
          localObject = localUri.getQueryParameter("set_force_filereader");
          paramString = (String)localObject;
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            Object localObject;
            String[] arrayOfString;
            continue;
          }
        }
        arrayOfString = paramString.split("_");
        if (paramString.length() < 2)
        {
          ec("强制设置文件预览方式失败，参数错误", true);
        }
        else
        {
          paramString = arrayOfString[(arrayOfString.length - 1)];
          if ("xweb".equalsIgnoreCase(paramString)) {
            paramString = f.a.ZZL;
          }
          for (;;)
          {
            if ((arrayOfString.length == 2) && ("all".equalsIgnoreCase(arrayOfString[0])))
            {
              localObject = f.ZZI;
              localObject = y.iwp().a((String[])localObject, paramString);
              if (((String)localObject).isEmpty()) {
                break label1086;
              }
              ec("格式:" + (String)localObject + "强制使用" + paramString.name() + "打开", true);
              break;
              if ("x5".equalsIgnoreCase(paramString))
              {
                paramString = f.a.ZZM;
              }
              else if ("none".equalsIgnoreCase(paramString))
              {
                paramString = f.a.ZZK;
              }
              else
              {
                ec("强制设置文件预览方式失败，类型错误", true);
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
          label1086:
          ec("强制设置文件预览方式失败", true);
          continue;
          paramString = "";
        }
        label1325:
        label1336:
        try
        {
          localObject = localUri.getQueryParameter("set_force_use_office_reader");
          paramString = (String)localObject;
        }
        catch (Exception localException1)
        {
          label1113:
          label1372:
          break label1113;
        }
        arrayOfString = paramString.split("_");
        if (paramString.length() < 2)
        {
          ec("强制设置OfficeReader失败，参数错误", true);
        }
        else
        {
          paramString = arrayOfString[(arrayOfString.length - 1)];
          if ("yes".equalsIgnoreCase(paramString)) {
            paramString = f.c.ZZQ;
          }
          for (;;)
          {
            if ((arrayOfString.length != 2) || (!"all".equalsIgnoreCase(arrayOfString[0]))) {
              break label1336;
            }
            localObject = new String[6];
            localObject[0] = "doc";
            localObject[1] = "docx";
            localObject[2] = "xls";
            localObject[3] = "xlsx";
            localObject[4] = "ppt";
            localObject[5] = "pptx";
            localObject = y.iwp().a((String[])localObject, paramString);
            if (((String)localObject).isEmpty()) {
              break label1372;
            }
            ec("格式:" + (String)localObject + "强制OfficeReader状态：" + paramString.toString(), true);
            break;
            if ("no".equalsIgnoreCase(paramString))
            {
              paramString = f.c.ZZR;
            }
            else
            {
              if (!"none".equalsIgnoreCase(paramString)) {
                break label1325;
              }
              paramString = f.c.ZZP;
            }
          }
          ec("强制设置OfficeReader失败，类型错误", true);
          continue;
          localObject = new String[arrayOfString.length - 1];
          i = 0;
          while (i < arrayOfString.length - 1)
          {
            localObject[i] = arrayOfString[i];
            i += 1;
          }
          ec("强制设置OfficeReader失败", true);
          continue;
          iyF();
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
  
  private void iyC()
  {
    AppMethodBeat.i(154233);
    if (this.aahi == null)
    {
      AppMethodBeat.o(154233);
      return;
    }
    String str = IU(false);
    this.aahi.setText(str);
    AppMethodBeat.o(154233);
  }
  
  private static String iyE()
  {
    int j = 0;
    AppMethodBeat.i(154237);
    Object localObject = new StringBuilder();
    String[] arrayOfString = f.ZZI;
    int k = arrayOfString.length;
    int i = 0;
    String str;
    while (i < k)
    {
      str = arrayOfString[i];
      ((StringBuilder)localObject).append("\n ").append(str).append(": force-").append(y.iwp().bFk(str)).append("  cmd-tools-").append(com.tencent.xweb.b.oS(str, "tools")).append("  cmd-appbrand-").append(com.tencent.xweb.b.oS(str, "appbrand"));
      i += 1;
    }
    ((StringBuilder)localObject).append("\n\n use office reader:");
    arrayOfString = f.ZZI;
    k = arrayOfString.length;
    i = j;
    while (i < k)
    {
      str = arrayOfString[i];
      if (!"pdf".equals(str)) {
        ((StringBuilder)localObject).append("\n ").append(str).append(": force-").append(y.iwp().bFl(str)).append("  cmd-tools-").append(com.tencent.xweb.b.oR(str, "tools")).append("  cmd-appbrand-").append(com.tencent.xweb.b.oR(str, "appbrand")).append("  cmd-mm-").append(com.tencent.xweb.b.oR(str, "mm"));
      }
      i += 1;
    }
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(154237);
    return localObject;
  }
  
  protected static void jK(Context paramContext)
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
        if ((localObject2 == null) || (!((String)localObject2).contains("com.tencent.mm")) || (((ActivityManager.RunningAppProcessInfo)localObject1).processName.contains("tools")) || (((ActivityManager.RunningAppProcessInfo)localObject1).processName.contains("appbrand")) || (((ActivityManager.RunningAppProcessInfo)localObject1).processName.contains("support")) || (((ActivityManager.RunningAppProcessInfo)localObject1).processName.contains("sandbox")))
        {
          localObject1 = com.tencent.mm.hellhoundlib.b.c.a(((ActivityManager.RunningAppProcessInfo)localObject1).pid, new com.tencent.mm.hellhoundlib.b.a());
          localObject2 = new Object();
          com.tencent.mm.hellhoundlib.a.a.b(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/xweb/xwalk/WebDebugPage", "killAllProcess", "(Landroid/content/Context;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
          Process.killProcess(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/xweb/xwalk/WebDebugPage", "killAllProcess", "(Landroid/content/Context;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
        }
      }
    }
    paramContext = com.tencent.mm.hellhoundlib.b.c.a(i, new com.tencent.mm.hellhoundlib.b.a());
    Object localObject1 = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(localObject1, paramContext.aFh(), "com/tencent/xweb/xwalk/WebDebugPage", "killAllProcess", "(Landroid/content/Context;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
    Process.killProcess(((Integer)paramContext.sf(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/xweb/xwalk/WebDebugPage", "killAllProcess", "(Landroid/content/Context;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
    AppMethodBeat.o(154243);
  }
  
  public static void mC(Context paramContext)
  {
    AppMethodBeat.i(154238);
    com.tencent.xweb.xwalk.b.c.aakL = true;
    com.tencent.xweb.xwalk.a.k localk = new com.tencent.xweb.xwalk.a.k();
    HashMap localHashMap = new HashMap();
    localHashMap.put("UpdaterCheckType", "1");
    localk.b(paramContext, localHashMap);
    AppMethodBeat.o(154238);
  }
  
  private static int oh(int paramInt1, int paramInt2)
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
  
  final String IU(boolean paramBoolean)
  {
    AppMethodBeat.i(154232);
    String str2 = this.aahe.getVersionInfo();
    int i;
    if (!paramBoolean)
    {
      i = str2.indexOf(",apkversion");
      str1 = str2;
      if (i <= 0) {}
    }
    for (String str1 = str2.substring(0, i);; str1 = str2 + ", " + com.tencent.xweb.xwalk.a.h.izi() + " current process is " + XWalkEnvironment.getProcessName())
    {
      AppMethodBeat.o(154232);
      return str1;
    }
  }
  
  final void IV(boolean paramBoolean)
  {
    AppMethodBeat.i(154246);
    Object localObject1 = new com.tencent.xweb.b.h(Environment.getExternalStorageDirectory());
    ((com.tencent.xweb.b.h)localObject1).ixd();
    localObject1 = ((com.tencent.xweb.b.h)localObject1).getPath() + "/apkxwebtest";
    Object localObject2;
    try
    {
      localObject1 = new com.tencent.xweb.b.h((String)localObject1);
      localObject2 = ((com.tencent.xweb.b.h)localObject1).ixd();
      if (localObject2.length == 0)
      {
        ec("apkxwebtest目录下没有.zip文件,请确认应用权限，在权限管理打开应用的读写存储权限", true);
        AppMethodBeat.o(154246);
        return;
      }
    }
    catch (Exception localException)
    {
      ec("没有找到apkxwebtest目录,请确认应用权限，在权限管理打开应用的读写存储权限", true);
      AppMethodBeat.o(154246);
      return;
    }
    int i = 0;
    while (i < localObject2.length)
    {
      if (localObject2[i].getName().endsWith(".zip"))
      {
        String str = localObject2[i].bOF();
        localObject2 = localObject2[i].getName();
        if (paramBoolean)
        {
          new AlertDialog.Builder(this.aaaH).setTitle("提示").setMessage("确定加载:" + (String)localObject2 + "?").setPositiveButton("确定", new d.44(this, str, (String)localObject2, paramBoolean)).setNegativeButton("取消", new d.43(this)).show();
          AppMethodBeat.o(154246);
          return;
        }
        J(str, (String)localObject2, paramBoolean);
        AppMethodBeat.o(154246);
        return;
      }
      i += 1;
    }
    ec("apkxwebtest目录下没有.zip文件", true);
    AppMethodBeat.o(154246);
  }
  
  final void J(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(154247);
    b localb = new b(paramString1, paramString2);
    try
    {
      Object localObject = new com.tencent.xweb.b.h(XWalkEnvironment.getDownloadZipDir(localb.aajv));
      if (((com.tencent.xweb.b.h)localObject).ifE()) {
        ((com.tencent.xweb.b.h)localObject).cFq();
      }
      paramString1 = i.Tf(paramString1);
      localObject = i.Te(((com.tencent.xweb.b.h)localObject).bOF());
      byte[] arrayOfByte = new byte[1048576];
      for (;;)
      {
        int i = paramString1.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        ((OutputStream)localObject).write(arrayOfByte, 0, i);
      }
      ec("安装" + paramString2 + "失败,错误码=" + paramString1, true);
    }
    catch (IOException paramString1)
    {
      for (;;)
      {
        paramString1 = XWalkUpdater.a(localb);
        if (paramString1.intValue() != 0) {
          break;
        }
        ec("安装" + paramString2 + "成功", paramBoolean);
        AppMethodBeat.o(154247);
        return;
        ((OutputStream)localObject).flush();
        paramString1.close();
        ((OutputStream)localObject).close();
      }
    }
    catch (Exception paramString1)
    {
      ec("安装失败", true);
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
          if ((paramBoolean2) && (this.aahe.getX5WebViewExtension() != null))
          {
            if (!paramBoolean1) {
              break label79;
            }
            this.aahe.loadUrl("http://debugx5.qq.com/?inspector=true");
          }
          while (paramButton != null) {
            if (paramBoolean1)
            {
              paramButton.setText("关闭远程调试模式(当前已打开)");
              AppMethodBeat.o(154244);
              return;
              label79:
              this.aahe.loadUrl("http://debugx5.qq.com/?inspector=false");
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
  
  public final boolean bFm(String paramString)
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
    int j;
    boolean bool1;
    boolean bool2;
    if ((paramString.contains("debugmm.qq.com")) || (paramString.contains("debugxweb.qq.com")))
    {
      com.tencent.xweb.util.h.Xg(224L);
      localObject5 = Uri.parse(paramString);
      localObject1 = ((Uri)localObject5).getQueryParameterNames();
      if ((localObject1 != null) && (((Set)localObject1).size() > 0))
      {
        localIterator = ((Set)localObject1).iterator();
        j = 0;
        bool1 = false;
        bool2 = false;
      }
    }
    for (;;)
    {
      int i = j;
      boolean bool3 = bool1;
      boolean bool4 = bool2;
      label314:
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
                y.iwp().a("tools", WebView.c.aabn);
                y.iwp().a("toolsmp", WebView.c.aabn);
                y.iwp().a(JsRuntime.JsRuntimeType.aaar);
                ed("force use x5 switch is on ", true);
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
          case 1217859436: 
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
              break label314;
              if (!((String)localObject1).equals("inspector")) {
                break;
              }
              i = 1;
              break label314;
              if (!((String)localObject1).equals("ticket")) {
                break;
              }
              i = 2;
              break label314;
              if (!((String)localObject1).equals("show_x5_ver")) {
                break;
              }
              i = 3;
              break label314;
              if (!((String)localObject1).equals("encrpt_url")) {
                break;
              }
              i = 4;
              break label314;
              if (!((String)localObject1).equals("clear_test_setting")) {
                break;
              }
              i = 5;
              break label314;
              if (!((String)localObject1).equals("show_fps")) {
                break;
              }
              i = 6;
              break label314;
              if (!((String)localObject1).equals("set_mm_config")) {
                break;
              }
              i = 7;
              break label314;
              if (!((String)localObject1).equals("set_web_config")) {
                break;
              }
              i = 8;
              break label314;
              if (!((String)localObject1).equals("set_appbrand_config")) {
                break;
              }
              i = 9;
              break label314;
              if (!((String)localObject1).equals("show_webview_version")) {
                break;
              }
              i = 10;
              break label314;
              if (!((String)localObject1).equals("set_grayvalue")) {
                break;
              }
              i = 11;
              break label314;
              if (!((String)localObject1).equals("set_device_rd_value")) {
                break;
              }
              i = 12;
              break label314;
              if (!((String)localObject1).equals("check_xwalk_update")) {
                break;
              }
              i = 13;
              break label314;
              if (!((String)localObject1).equals("soft_check_xwalk_update")) {
                break;
              }
              i = 14;
              break label314;
              if (!((String)localObject1).equals("check_update_in_sandbox")) {
                break;
              }
              i = 15;
              break label314;
              if (!((String)localObject1).equals("clear_config_time_stamp")) {
                break;
              }
              i = 16;
              break label314;
              if (!((String)localObject1).equals("clear_schedule")) {
                break;
              }
              i = 17;
              break label314;
              if (!((String)localObject1).equals("set_config_url")) {
                break;
              }
              i = 18;
              break label314;
              if (!((String)localObject1).equals("set_plugin_config_url")) {
                break;
              }
              i = 19;
              break label314;
              if (!((String)localObject1).equals("check_plugin_update")) {
                break;
              }
              i = 20;
              break label314;
              y.iwp().a("tools", WebView.c.aabl);
              y.iwp().a("toolsmp", WebView.c.aabl);
              y.iwp().a(JsRuntime.JsRuntimeType.aaam);
              ed("force use x5 switch is off ", true);
            }
            bool1 = ((Uri)localObject5).getBooleanQueryParameter("inspector", false);
            y.iwp().setDebugEnable(bool1);
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
                break label1070;
              }
              ec("权限校验失败", true);
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
                String str2 = new SimpleDateFormat("yyyyMMdd").format(new Date());
                bool2 = com.tencent.xweb.util.b.bu((String)localObject4 + "@check_permission@" + str2, (String)localObject1, "MHYwEAYHKoZIzj0CAQYFK4EEACIDYgAE4s7oy+BvW5kzf5PwtVqDdZb2rVQS7GDf\naJWwtkD95ILDQAtHM9Nv5apLYQnUbXkjTldOUpjK7MimTkf/qXjQfk8hF2A0Mf7L\nHbDPr7kD9DOuQlG53SWOuKQVEwwsjN1l");
              }
            }
            label1070:
            Log.i("WebDebugPage", "checkTempPerssion suc");
            continue;
            bool1 = ((Uri)localObject5).getBooleanQueryParameter("show_x5_ver", false);
            paramString = y.iwp();
            if (bool1 != paramString.aaaL)
            {
              paramString.aaaL = bool1;
              paramString.aaaH.getSharedPreferences("wcwebview", 0).edit().putBoolean("bShowX5Version", paramString.aaaL).commit();
            }
            if (bool1) {
              ec("开启显示x5内核信息", true);
            }
            for (;;)
            {
              AppMethodBeat.o(154226);
              return true;
              ec("关闭显示x5内核信息", true);
            }
            paramString = ((Uri)localObject5).getQueryParameter("encrpt_url");
            try
            {
              paramString = com.tencent.xweb.util.a.a(paramString, com.tencent.xweb.util.a.bFy("b01d4598de5875eb9b86abdef32b811e9c55edcfb1673b5617cc0a6ab7dceaff"));
              if (TextUtils.isEmpty(paramString))
              {
                ec("解密失败", true);
                AppMethodBeat.o(154226);
                return true;
              }
              bFm(paramString);
            }
            catch (Throwable paramString)
            {
              for (;;)
              {
                ec("解密失败", true);
              }
            }
            AppMethodBeat.o(154226);
            return true;
            p.mD(XWalkEnvironment.getApplicationContext());
            AppMethodBeat.o(154226);
            return true;
            bool1 = ((Uri)localObject5).getBooleanQueryParameter("show_fps", false);
            y.iwp().setShowFps(bool1);
            AppMethodBeat.o(154226);
            return true;
          }
        }
      }
      else
      {
        label1552:
        label2042:
        label3194:
        try
        {
          localObject1 = WebView.c.valueOf(((Uri)localObject5).getQueryParameter("set_mm_config"));
          y.iwp().a("mm", (WebView.c)localObject1);
          ec("mm进程将使用:".concat(String.valueOf(localObject1)), true);
          j = 1;
        }
        catch (Exception localException8) {}
        try
        {
          localObject1 = WebView.c.valueOf(((Uri)localObject5).getQueryParameter("set_web_config"));
          y.iwp().a("tools", (WebView.c)localObject1);
          y.iwp().a("toolsmp", (WebView.c)localObject1);
          ec("打开网页将使用:".concat(String.valueOf(localObject1)), true);
          j = 1;
        }
        catch (Exception localException7) {}
        try
        {
          localObject1 = WebView.c.valueOf(((Uri)localObject5).getQueryParameter("set_appbrand_config"));
          y.iwp().a("appbrand", (WebView.c)localObject1);
          y.iwp().a("support", (WebView.c)localObject1);
          try
          {
            switch (51.qYM[localObject1.ordinal()])
            {
            case 1: 
              y.iwp().a(JsRuntime.JsRuntimeType.aaau);
              ec("打开小程序将使用:".concat(String.valueOf(localObject1)), true);
              j = 1;
            }
          }
          catch (Exception localException1)
          {
            i = 1;
          }
          y.iwp().a(JsRuntime.JsRuntimeType.aaar);
          ec("打开小程序将使用:".concat(String.valueOf(localObject1)), true);
          j = 1;
        }
        catch (Exception localException6)
        {
          i = j;
          break label1552;
        }
        y.iwp().a(JsRuntime.JsRuntimeType.aaau);
        ec("打开小程序将使用:".concat(String.valueOf(localObject1)), true);
        break label3268;
        j = i;
        continue;
        if (this.aahj == null)
        {
          ScrollView localScrollView = new ScrollView(this.aaaH);
          this.aahj = new TextView(this.aaaH);
          this.aahj.setTextColor(-16777216);
          this.aahj.setBackgroundColor(-1);
          localScrollView.addView(this.aahj);
          this.aahj.setOnClickListener(new d.12(this));
          iyA();
          this.aahe.getTopView().addView(localScrollView);
          continue;
          try
          {
            i = Integer.parseInt(((Uri)localObject5).getQueryParameter("set_grayvalue"));
            XWalkEnvironment.setGrayValueForTest(i);
            ec("灰度值设为" + i % 10000, true);
            bool1 = true;
          }
          catch (Exception localException2)
          {
            ec("灰度值设置失败，参数解析错误", true);
            bool1 = true;
          }
          continue;
          try
          {
            i = Integer.parseInt(((Uri)localObject5).getQueryParameter("set_device_rd_value"));
            XWalkEnvironment.sNDeviceRd = i;
            XWalkEnvironment.getSharedPreferences().edit().putInt("sNDeviceRd", i).commit();
            XWalkEnvironment.setGrayValueForTest(i);
            ec("设备随机灰度值设为" + i % 10000, true);
            bool1 = true;
          }
          catch (Exception localException3)
          {
            ec("设备随机灰度值设置失败，参数解析错误", true);
            bool1 = true;
          }
          continue;
          ec("开始检测浏览器和所有插件更新", true);
          iyG();
          mC(XWalkEnvironment.getApplicationContext());
          continue;
          ec("模拟触发沙箱进程检测浏览器内核更新", true);
          XWalkEnvironment.setConfigFetchPeriod(1800001L);
          w.b(XWalkEnvironment.getApplicationContext(), null);
          new a(this.aaaH);
          continue;
          Object localObject2 = Integer.TYPE;
          localObject4 = this.aaaH;
          com.tencent.xweb.util.g.b("com.tencent.mm.pluginsdk.model.TBSHelper", "checkXWalkNow", new Class[] { Context.class, localObject2 }, new Object[] { localObject4, Integer.valueOf(4) });
          ec("即将发起沙箱进程检查更新", true);
          new a(this.aaaH);
          continue;
          ec("重置上次拉取配置时间", true);
          com.tencent.xweb.xwalk.b.c.izA();
          com.tencent.xweb.xwalk.a.k.Xo(0L);
          continue;
          ec("清理本地的更新计划", true);
          com.tencent.xweb.xwalk.b.c.IY(false).izt();
          com.tencent.xweb.xwalk.b.c.IY(true).izt();
          continue;
          try
          {
            localObject2 = ((Uri)localObject5).getQueryParameter("set_config_url");
            if ((XWalkEnvironment.isValidConfigHost((String)localObject2)) || (y.iwp().iwt())) {
              break label2042;
            }
            ec("you have no athority to set this config url:".concat(String.valueOf(localObject2)), true);
          }
          catch (Exception localException4)
          {
            ec("测试连接设置失败，格式错误", true);
          }
          continue;
          XWalkEnvironment.setTestDownLoadUrl(this.aaaH, localException4);
          ec("测试连接设置为:".concat(String.valueOf(localException4)), true);
          continue;
          try
          {
            String str1 = ((Uri)localObject5).getQueryParameter("set_plugin_config_url");
            XWalkEnvironment.setPluginTestConfigUrl(str1);
            ec("插件测试连接设置为:".concat(String.valueOf(str1)), true);
          }
          catch (Exception localException5)
          {
            ec("插件测试连接设置失败，格式错误", true);
          }
          continue;
          Object localObject3 = "";
          label3110:
          try
          {
            localObject4 = ((Uri)localObject5).getQueryParameter("check_plugin_update");
            localObject3 = localObject4;
          }
          catch (Exception localException9)
          {
            label2136:
            int k;
            int m;
            label2676:
            break label2136;
          }
          if ("all".equalsIgnoreCase((String)localObject3))
          {
            ec("开始检测所有插件更新", true);
            mC(this.aaaH);
          }
          else if ("FullScreenVideo".equalsIgnoreCase((String)localObject3))
          {
            dl(this.aaaH, "FullScreenVideo");
          }
          else if ("XFilesPDFReader".equalsIgnoreCase((String)localObject3))
          {
            dl(this.aaaH, "XFilesPDFReader");
          }
          else if ("XFilesPPTReader".equalsIgnoreCase((String)localObject3))
          {
            dl(this.aaaH, "XFilesPPTReader");
          }
          else if ("XFilesWordReader".equalsIgnoreCase((String)localObject3))
          {
            dl(this.aaaH, "XFilesWordReader");
          }
          else if ("XFilesExcelReader".equalsIgnoreCase((String)localObject3))
          {
            dl(this.aaaH, "XFilesExcelReader");
          }
          else if ("XFilesOfficeReader".equalsIgnoreCase((String)localObject3))
          {
            dl(this.aaaH, "XFilesOfficeReader");
          }
          else
          {
            ec("检测插件更新失败，参数错误", true);
            continue;
            i = 0;
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
            if ((y.iwp().iwt()) || (bool4)) {}
            for (k = 1;; k = 0)
            {
              if (!paramString.contains("debugxweb.qq.com"))
              {
                m = i;
                bool2 = bool3;
                if (!bool4) {
                  break label3194;
                }
              }
              localObject3 = Uri.parse(paramString);
              localObject4 = ((Uri)localObject3).getQueryParameterNames();
              if ((localObject4 != null) && (((Set)localObject4).size() != 0)) {
                break;
              }
              if (k != 0) {
                iyD();
              }
              AppMethodBeat.o(154226);
              return true;
            }
            localObject4 = ((Set)localObject4).iterator();
            bool1 = bool3;
            j = i;
            for (;;)
            {
              m = j;
              bool2 = bool1;
              if (!((Iterator)localObject4).hasNext()) {
                break;
              }
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
                    y.iwp().setDebugEnable(bool1);
                    a(bool1, null, true);
                    bool1 = true;
                    break;
                    if (!((String)localObject5).equals("inspector")) {
                      break label2676;
                    }
                    i = 0;
                    continue;
                    if (!((String)localObject5).equals("use_testconfig")) {
                      break label2676;
                    }
                    i = 1;
                    continue;
                    if (!((String)localObject5).equals("kill_all")) {
                      break label2676;
                    }
                    i = 2;
                    continue;
                    if (!((String)localObject5).equals("ignore_crashwatch")) {
                      break label2676;
                    }
                    i = 3;
                    continue;
                    if (!((String)localObject5).equals("save_page")) {
                      break label2676;
                    }
                    i = 4;
                    continue;
                    if (!((String)localObject5).equals("clear_cache")) {
                      break label2676;
                    }
                    i = 5;
                    continue;
                    if (!((String)localObject5).equals("clear_old_ver")) {
                      break label2676;
                    }
                    i = 6;
                    continue;
                    if (!((String)localObject5).equals("fix_dex")) {
                      break label2676;
                    }
                    i = 7;
                    continue;
                    if (!((String)localObject5).equals("clear_all")) {
                      break label2676;
                    }
                    i = 8;
                    continue;
                    if (!((String)localObject5).equals("abandon_curent_ver")) {
                      break label2676;
                    }
                    i = 9;
                  }
                }
                bool1 = ((Uri)localObject3).getBooleanQueryParameter("use_testconfig", false);
                y.iwp().IL(bool1);
                if (bool1) {
                  ec("使用测试config", true);
                }
                for (;;)
                {
                  bool1 = true;
                  break;
                  ec("使用正式config", true);
                }
                j = 1;
                bool1 = true;
                continue;
                bool2 = ((Uri)localObject3).getBooleanQueryParameter("ignore_crashwatch", false);
                localObject5 = y.iwp();
                ((y)localObject5).aaaP = bool2;
                ((y)localObject5).aaaH.getSharedPreferences("wcwebview", 0).edit().putBoolean("ignore_crashwatch", bool2).commit();
                ec("忽略crash检测设为 = ".concat(String.valueOf(bool2)), true);
                continue;
                if (!y.iwp().aaaM) {}
                for (bool2 = true;; bool2 = false)
                {
                  y.iwp().IK(bool2);
                  if (!bool2) {
                    break label3110;
                  }
                  iyz();
                  this.aahk.setVisibility(0);
                  break;
                }
                if (this.aahk != null)
                {
                  this.aahk.setVisibility(8);
                  continue;
                  aj.clearAllWebViewCache(XWalkEnvironment.getApplicationContext(), true);
                  ec("网页cache已经清理:", true);
                  continue;
                  p.Q(XWalkEnvironment.getApplicationContext(), true);
                  ec("旧版本已经清理", true);
                  continue;
                  p.iyT();
                  continue;
                  XWalkEnvironment.clearAllVersion(this.aaaH);
                  bool1 = true;
                  continue;
                  p.iyQ();
                  bool1 = true;
                }
              }
            }
            if (k != 0) {
              if (!eb(paramString, bool4))
              {
                bool1 = bool5;
                if (!bool2) {
                  break label3221;
                }
              }
            }
            for (bool1 = true;; bool1 = bool2)
            {
              label3221:
              if (m != 0) {
                bNI();
              }
              AppMethodBeat.o(154226);
              return bool1;
              break;
              break;
            }
            label3268:
            j = 1;
          }
        }
      }
    }
  }
  
  final void bNI()
  {
    AppMethodBeat.i(154242);
    jK(this.aaaH);
    AppMethodBeat.o(154242);
  }
  
  final void ec(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(154248);
    if (paramBoolean) {
      try
      {
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.aaaH);
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
  
  final void ed(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(154249);
    try
    {
      AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.aaaH);
      localBuilder.setMessage(paramString);
      localBuilder.create();
      localBuilder.setCancelable(true);
      if (paramBoolean) {
        localBuilder.setOnCancelListener(new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(204870);
            d.this.bNI();
            AppMethodBeat.o(204870);
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
    int i = this.aahe.getSettings().getForceDarkMode();
    int j = this.aahe.getSettings().getForceDarkBehavior();
    int k = oh(i, j);
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
  
  public final void iwH()
  {
    AppMethodBeat.i(154225);
    if (y.iwp().aaaJ) {
      a(true, null, false);
    }
    AppMethodBeat.o(154225);
  }
  
  final void iyA()
  {
    AppMethodBeat.i(154230);
    if (this.aahj == null)
    {
      AppMethodBeat.o(154230);
      return;
    }
    Object localObject5 = XWalkEnvironment.getXWalkUpdateConfigUrl();
    Object localObject2 = "\n\n" + this.aahe.getAbstractInfo();
    Object localObject1 = localObject2;
    if (com.tencent.xweb.WebView.getCurWebType() != WebView.c.aabm) {
      localObject1 = (String)localObject2 + "\n xwebsdk is = 20210601 apk ver is " + XWalkEnvironment.getAvailableVersion() + " des " + XWalkEnvironment.getAvailableVersionDetail();
    }
    if (XWalkEnvironment.getApplicationContext().getApplicationInfo() != null) {}
    for (int i = XWalkEnvironment.getApplicationContext().getApplicationInfo().targetSdkVersion;; i = 0)
    {
      localObject1 = (String)localObject1 + "\n\n current js engine: =  " + JsRuntime.iwc() + "\n prefered js engine =  " + JsRuntime.a(JsRuntime.JsRuntimeType.aaam, "appbrand", this.aaaH) + "\n local gray value = " + XWalkEnvironment.getGrayValue() + "\n local gray device rd value = " + XWalkEnvironment.getDeviceRd() + "\n today gray value = " + XWalkEnvironment.getTodayGrayValue() + "\n config url = " + (String)localObject5 + "\n config period(minutes) = " + com.tencent.xweb.xwalk.b.c.izE() / 60000L + "\n\n apilevel = " + Build.VERSION.SDK_INT + "\n apilevel = " + i + "\n sys webversion = " + XWalkEnvironment.safeGetChromiunVersion() + "\n device is  " + Build.BRAND + " " + Build.MODEL + "\n usertype is " + XWalkEnvironment.getUserType() + "\n runtime abi is " + XWalkEnvironment.getRuntimeAbi() + "\n device abi is " + XWalkEnvironment.getDeviceAbi() + "\n installed ver for arm32 is " + XWalkEnvironment.getInstalledNewstVersion("armeabi-v7a") + "\n installed ver for arm64 is " + XWalkEnvironment.getInstalledNewstVersion("arm64-v8a") + "\n should embed =  false\n embed lib md5 match =  true\n embed config ver =  0/0" + "\n embed try installed ver =  " + XWalkUpdater.bFP(XWalkEnvironment.getRuntimeAbi()) + "\n current useragent: " + this.aahe.getSettings().getUserAgentString() + "\n current clientversion: 0x" + Integer.toHexString(XWalkEnvironment.getAppClientVersion()) + "\n current app infos dump : " + XWalkEnvironment.dumpAppInfo();
      localObject2 = (String)localObject1 + "\n\n ------dump module prefer webview core start:------\n";
      localObject1 = localObject2;
      try
      {
        localObject2 = (String)localObject2 + a(this.aaaH, WebView.c.aabn, "tools") + "\n";
        localObject1 = localObject2;
        localObject2 = (String)localObject2 + a(this.aaaH, WebView.c.aabm, "toolsmp") + "\n";
        localObject1 = localObject2;
        localObject2 = (String)localObject2 + a(this.aaaH, WebView.c.aabl, "mm") + "\n";
        localObject1 = localObject2;
        localObject2 = (String)localObject2 + a(this.aaaH, WebView.c.aabm, "appbrand") + "\n";
        localObject1 = localObject2;
        localObject2 = (String)localObject2 + a(this.aaaH, WebView.c.aabm, "support") + "\n";
        localObject1 = localObject2;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          localObject1 = (String)localObject1 + localException1.getMessage() + "\n";
        }
        localObject1 = (String)localObject1 + "\n current update match gap backward(update speed) is " + com.tencent.xweb.xwalk.b.c.bFU(com.tencent.xweb.xwalk.b.c.IY(false).Ja(false));
        localObject1 = (String)localObject1 + "\n current update match gap forward(提前更新) is " + com.tencent.xweb.xwalk.b.c.bFU(com.tencent.xweb.xwalk.b.c.IY(false).Ja(true));
        localObject1 = (String)localObject1 + "\n plugin current update match gap backward(update speed) is " + com.tencent.xweb.xwalk.b.c.bFU(new a.a("").Ja(false));
        localObject1 = (String)localObject1 + "\n plugin current update match gap forward(提前更新) is " + com.tencent.xweb.xwalk.b.c.bFU(new a.a("").Ja(true));
        localObject3 = com.tencent.xweb.a.getAbstractInfo();
        if (localObject3 == null) {
          break label1911;
        }
      }
      localObject1 = (String)localObject1 + "------dump module prefer webview core end------";
      localObject1 = (String)localObject1 + "\n" + com.tencent.xweb.xwalk.b.k.izV().izu();
      localObject1 = (String)localObject1 + "\n" + com.tencent.xweb.xwalk.b.j.izU().izu();
      localObject2 = com.tencent.xweb.xwalk.a.h.izh().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject5 = (com.tencent.xweb.xwalk.a.g)((Iterator)localObject2).next();
        if (localObject5 != null)
        {
          localObject5 = com.tencent.xweb.xwalk.a.a.bFR(((com.tencent.xweb.xwalk.a.g)localObject5).getPluginName());
          localObject1 = (String)localObject1 + "\n" + ((com.tencent.xweb.xwalk.b.c)localObject5).izu();
        }
      }
      Object localObject3;
      if (!((String)localObject3).isEmpty()) {
        localObject1 = (String)localObject1 + "\n\n ------dump commands start:------\n" + (String)localObject3 + "\n ------dump commands end------";
      }
      label1911:
      for (;;)
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("\n\n ------plugin info start:------\n plugin config url = ").append(XWalkEnvironment.getPluginConfigUrl()).append("\n plugin config period(minutes) = ").append(XWalkEnvironment.getPluginUpdatePeriod() / 60000).append("\n\n plugin version:");
        localObject5 = com.tencent.xweb.xwalk.a.h.izh().iterator();
        Object localObject6;
        while (((Iterator)localObject5).hasNext())
        {
          localObject6 = (com.tencent.xweb.xwalk.a.g)((Iterator)localObject5).next();
          if (localObject6 != null) {
            ((StringBuilder)localObject3).append("\n ").append(((com.tencent.xweb.xwalk.a.g)localObject6).getPluginName()).append(" = ").append(((com.tencent.xweb.xwalk.a.g)localObject6).izd());
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
          if (y.iwp() != null)
          {
            ((StringBuilder)localObject3).append("\n disable cache = ").append(y.iwp().iwq());
            ((StringBuilder)localObject3).append("\n disable crash detect = ").append(y.iwp().iwr());
          }
          ((StringBuilder)localObject3).append(iyE()).append("\n\n ------plugin info end:------");
          localObject6 = (String)localObject1 + ((StringBuilder)localObject3).toString();
          localObject5 = "";
          localObject1 = localObject5;
          try
          {
            SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            localObject3 = localObject5;
            localObject1 = localObject5;
            if (com.tencent.xweb.xwalk.b.c.IY(false).izw())
            {
              localObject1 = localObject5;
              String str = localSimpleDateFormat.format(new Date(com.tencent.xweb.xwalk.b.c.IY(false).izG().aakX));
              localObject1 = localObject5;
              localObject3 = "" + "going to update to apk ver = " + com.tencent.xweb.xwalk.b.c.IY(false).izG().version;
              localObject1 = localObject3;
              localObject3 = (String)localObject3 + "\n update time is = " + str;
              localObject1 = localObject3;
              localObject3 = (String)localObject3 + "\n is patch update = " + com.tencent.xweb.xwalk.b.c.IY(false).izG().aakU;
              localObject1 = localObject3;
              localObject3 = (String)localObject3 + "\n can use cellular = " + com.tencent.xweb.xwalk.b.c.IY(false).izG().aakw;
              localObject1 = localObject3;
              localObject3 = (String)localObject3 + "\n updateHourStart = " + com.tencent.xweb.xwalk.b.c.IY(false).izG().aalb;
              localObject1 = localObject3;
              localObject3 = (String)localObject3 + "\n updateHourEnd = " + com.tencent.xweb.xwalk.b.c.IY(false).izG().aalc;
              localObject1 = localObject3;
              localObject3 = (String)localObject3 + "\n versionId = " + com.tencent.xweb.xwalk.b.c.IY(false).izG().aakn;
              localObject1 = localObject3;
              localObject3 = (String)localObject3 + "\n update time is = " + str;
              localObject1 = localObject3;
              localObject3 = (String)localObject3 + "\n try count = " + com.tencent.xweb.xwalk.b.c.IY(false).izG().aakZ;
              localObject1 = localObject3;
              localObject3 = (String)localObject3 + "\n try use shared core count = " + com.tencent.xweb.xwalk.b.c.IY(false).izG().aala;
              localObject1 = localObject3;
              localObject3 = (String)localObject3 + "\n";
            }
            localObject1 = localObject3;
            localObject5 = new Date(com.tencent.xweb.xwalk.b.c.IY(false).izG().aakS);
            localObject1 = localObject3;
            localObject3 = (String)localObject3 + " last fetch config time = " + localSimpleDateFormat.format((Date)localObject5);
            localObject1 = localObject3;
            localObject3 = (String)localObject3 + " last fetch config abi = " + com.tencent.xweb.xwalk.b.c.IY(false).izG().aakT;
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
          this.aahj.setText((CharSequence)localObject3);
          AppMethodBeat.o(154230);
          return;
          ((StringBuilder)localObject3).append("\n null\n");
        }
      }
    }
  }
  
  final void iyB()
  {
    AppMethodBeat.i(154231);
    if ((!y.iwp().aaaK) && ((!y.iwp().aaaL) || (this.aahe.getWebCoreType() != WebView.c.aabn)))
    {
      AppMethodBeat.o(154231);
      return;
    }
    if (this.aahi != null)
    {
      AppMethodBeat.o(154231);
      return;
    }
    this.aahi = new TextView(this.aaaH);
    this.aahi.setOnLongClickListener(new d.23(this));
    iyC();
    this.aahe.getTopView().addView(this.aahi);
    AppMethodBeat.o(154231);
  }
  
  final boolean iyD()
  {
    AppMethodBeat.i(154235);
    b(this.aahe);
    if (this.aahl != null)
    {
      this.aahl.setVisibility(0);
      AppMethodBeat.o(154235);
      return true;
    }
    this.aahl = ((LayoutInflater)this.aaaH.getSystemService("layout_inflater")).inflate(R.layout.debug_menu, this.aahe.getTopView(), true).findViewById(R.id.view_root);
    ((Button)this.aahl.findViewById(R.id.button_close_menu)).setOnClickListener(new d.34(this));
    Object localObject1 = (CheckBox)this.aahl.findViewById(R.id.checked_show_version);
    ((CheckBox)localObject1).setChecked(y.iwp().aaaK);
    ((CheckBox)localObject1).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(154208);
        paramAnonymousCompoundButton = y.iwp();
        if (paramAnonymousBoolean != paramAnonymousCompoundButton.aaaK)
        {
          paramAnonymousCompoundButton.aaaK = paramAnonymousBoolean;
          paramAnonymousCompoundButton.aaaH.getSharedPreferences("wcwebview", 0).edit().putBoolean("bShowVersion", paramAnonymousCompoundButton.aaaK).commit();
        }
        if (paramAnonymousBoolean)
        {
          d.this.iyB();
          d.this.aahi.setVisibility(0);
          AppMethodBeat.o(154208);
          return;
        }
        if (d.this.aahi != null) {
          d.this.aahi.setVisibility(8);
        }
        AppMethodBeat.o(154208);
      }
    });
    ((TextView)this.aahl.findViewById(R.id.check_text)).setOnClickListener(new d.52(this, (CheckBox)localObject1));
    localObject1 = (EditText)this.aahl.findViewById(R.id.txtin_grayvalue);
    if (localObject1 != null)
    {
      ((EditText)localObject1).setInputType(2);
      ((EditText)localObject1).setText(XWalkEnvironment.getGrayValue());
      ((EditText)localObject1).addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(154213);
          paramAnonymousEditable = this.aaia.getText().toString();
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
    ((Spinner)this.aahl.findViewById(R.id.selector_webviewmodule)).setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
    {
      public final void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(154214);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).Fs(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/xweb/xwalk/WebDebugPage$8", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        paramAnonymousAdapterView = d.this.aaaH.getResources().getStringArray(R.array.webviewuimodules);
        d.this.aahn = paramAnonymousAdapterView[paramAnonymousInt];
        paramAnonymousAdapterView = d.this;
        paramAnonymousAdapterView.aahm = true;
        if (paramAnonymousAdapterView.aahn.equals("all"))
        {
          paramAnonymousView = paramAnonymousAdapterView.aaaH.getResources().getStringArray(R.array.webviewmodules);
          localObject = y.iwp().bFj(paramAnonymousView[0]);
          paramAnonymousInt = 1;
          if (paramAnonymousInt < paramAnonymousView.length) {
            if (y.iwp().bFj(paramAnonymousView[paramAnonymousInt]) != localObject)
            {
              ((RadioButton)paramAnonymousAdapterView.aahl.findViewById(R.id.WV_AUTO)).setChecked(false);
              ((RadioButton)paramAnonymousAdapterView.aahl.findViewById(R.id.WV_XWALK)).setChecked(false);
              ((RadioButton)paramAnonymousAdapterView.aahl.findViewById(R.id.WV_X5)).setChecked(false);
              ((RadioButton)paramAnonymousAdapterView.aahl.findViewById(R.id.WV_SYS)).setChecked(false);
            }
          }
        }
        for (;;)
        {
          paramAnonymousAdapterView.aahm = false;
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$8", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(154214);
          return;
          paramAnonymousInt += 1;
          break;
          paramAnonymousAdapterView.n((WebView.c)localObject);
          continue;
          paramAnonymousAdapterView.n(y.iwp().bFj(paramAnonymousAdapterView.aahn));
        }
      }
      
      public final void onNothingSelected(AdapterView<?> paramAnonymousAdapterView) {}
    });
    ((RadioGroup)this.aahl.findViewById(R.id.web_select)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(RadioGroup paramAnonymousRadioGroup, int paramAnonymousInt)
      {
        AppMethodBeat.i(154215);
        if (d.this.aahm)
        {
          AppMethodBeat.o(154215);
          return;
        }
        paramAnonymousRadioGroup = WebView.c.aabl;
        if (paramAnonymousInt == R.id.WV_AUTO) {
          paramAnonymousRadioGroup = WebView.c.aabl;
        }
        while (!d.this.aahn.equals("all"))
        {
          y.iwp().a(d.this.aahn, paramAnonymousRadioGroup);
          Log.d("WebDebugPage", "webview change to=".concat(String.valueOf(paramAnonymousRadioGroup)));
          AppMethodBeat.o(154215);
          return;
          if (paramAnonymousInt == R.id.WV_XWALK) {
            paramAnonymousRadioGroup = WebView.c.aabm;
          } else if (paramAnonymousInt == R.id.WV_X5) {
            paramAnonymousRadioGroup = WebView.c.aabn;
          } else if (paramAnonymousInt == R.id.WV_SYS) {
            paramAnonymousRadioGroup = WebView.c.aabo;
          }
        }
        String[] arrayOfString = d.this.aaaH.getResources().getStringArray(R.array.webviewmodules);
        paramAnonymousInt = 0;
        while (paramAnonymousInt < arrayOfString.length)
        {
          y.iwp().a(arrayOfString[paramAnonymousInt], paramAnonymousRadioGroup);
          Log.d("WebDebugPage", "webview " + arrayOfString[paramAnonymousInt] + " change to=" + paramAnonymousRadioGroup);
          paramAnonymousInt += 1;
        }
        AppMethodBeat.o(154215);
      }
    });
    switch (51.aagD[y.iwp().aaaQ.ordinal()])
    {
    default: 
      ((RadioGroup)this.aahl.findViewById(R.id.v8_select)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
      {
        public final void onCheckedChanged(RadioGroup paramAnonymousRadioGroup, int paramAnonymousInt)
        {
          AppMethodBeat.i(154153);
          paramAnonymousRadioGroup = JsRuntime.JsRuntimeType.aaam;
          if (paramAnonymousInt == R.id.v8_auto) {
            paramAnonymousRadioGroup = JsRuntime.JsRuntimeType.aaam;
          }
          for (;;)
          {
            y.iwp().a(paramAnonymousRadioGroup);
            Log.d("WebDebugPage", "v8 type change to=".concat(String.valueOf(paramAnonymousRadioGroup)));
            AppMethodBeat.o(154153);
            return;
            if (paramAnonymousInt == R.id.v8_sys) {
              paramAnonymousRadioGroup = JsRuntime.JsRuntimeType.aaan;
            } else if (paramAnonymousInt == R.id.v8_x5) {
              paramAnonymousRadioGroup = JsRuntime.JsRuntimeType.aaar;
            } else if (paramAnonymousInt == R.id.v8_nativescript) {
              paramAnonymousRadioGroup = JsRuntime.JsRuntimeType.aaat;
            } else if (paramAnonymousInt == R.id.v8_mmv8) {
              paramAnonymousRadioGroup = JsRuntime.JsRuntimeType.aaau;
            }
          }
        }
      });
      ((Button)this.aahl.findViewById(R.id.button_kill)).setOnClickListener(new d.3(this));
      localObject1 = (Button)this.aahl.findViewById(R.id.btn_debug);
      a(y.iwp().aaaJ, (Button)localObject1, false);
      ((Button)localObject1).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(154155);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/xweb/xwalk/WebDebugPage$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (!y.iwp().aaaJ) {}
          for (boolean bool = true;; bool = false)
          {
            y.iwp().setDebugEnable(bool);
            d.this.a(bool, this.aahv, true);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(154155);
            return;
          }
        }
      });
      ((Button)this.aahl.findViewById(R.id.button_clear)).setOnClickListener(new d.5(this));
      ((Button)this.aahl.findViewById(R.id.button_refreshLog)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(154157);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/xweb/xwalk/WebDebugPage$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          ((TextView)d.this.aahl.findViewById(R.id.txtVersion)).setText(d.this.IU(true) + "\n" + XWalkInitializer.getXWalkInitializeLog());
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(154157);
        }
      });
      ((Button)this.aahl.findViewById(R.id.button_loadLocalApk)).setOnClickListener(new d.7(this));
      localObject1 = (Button)this.aahl.findViewById(R.id.button_darkMode);
      if ((this.aahe.isXWalkKernel()) && (XWalkEnvironment.isCurrentVersionSupportForceDarkMode()))
      {
        ((Button)localObject1).setVisibility(0);
        label502:
        f((Button)localObject1);
        ((Button)localObject1).setOnClickListener(new d.8(this, (Button)localObject1));
        Object localObject2 = (Button)this.aahl.findViewById(R.id.button_config);
        localObject1 = XWalkEnvironment.getXWalkUpdateConfigUrl();
        localObject1 = ((String)localObject1).substring(((String)localObject1).lastIndexOf('/') + 1);
        localObject1 = "(当前为" + (String)localObject1 + ")";
        if (!y.iwp().aaaR) {
          break label1594;
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
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/xweb/xwalk/WebDebugPage$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
            paramAnonymousView = y.iwp();
            boolean bool;
            if (!y.iwp().aaaR)
            {
              bool = true;
              paramAnonymousView.IL(bool);
              paramAnonymousView = XWalkEnvironment.getXWalkUpdateConfigUrl();
              paramAnonymousView = paramAnonymousView.substring(paramAnonymousView.lastIndexOf('/') + 1);
              paramAnonymousView = "(当前为" + paramAnonymousView + ")";
              localObject = this.aahx;
              if (!y.iwp().aaaR) {
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
        ((Button)this.aahl.findViewById(R.id.button_update)).setOnClickListener(new d.10(this));
        localObject1 = (LinearLayout)this.aahl.findViewById(R.id.plugin_menu);
        ((LinearLayout)localObject1).setVisibility(8);
        localObject2 = (Button)this.aahl.findViewById(R.id.button_plugin_menu);
        ((Button)localObject2).setText("插件设置");
        ((Button)localObject2).setOnClickListener(new d.11(this, (LinearLayout)localObject1));
        localObject1 = (Button)this.aahl.findViewById(R.id.button_plugin_config);
        localObject2 = XWalkEnvironment.getPluginTestConfigUrl();
        if ((localObject2 == null) || (((String)localObject2).isEmpty())) {
          break label1618;
        }
        if (!((String)localObject2).equalsIgnoreCase("https://dldir1.qq.com/weixin/android/wxweb/plugin/pluginUpdateConfig_test.xml")) {
          break label1608;
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
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/xweb/xwalk/WebDebugPage$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          paramAnonymousView = XWalkEnvironment.getPluginTestConfigUrl();
          if ((paramAnonymousView != null) && (!paramAnonymousView.isEmpty())) {
            if (XWalkEnvironment.setPluginTestConfigUrl("")) {
              this.aahz.setText("切换插件配置，当前使用正式版");
            }
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(154164);
            return;
            d.this.ec("切换失败", true);
            continue;
            if (XWalkEnvironment.setPluginTestConfigUrl("https://dldir1.qq.com/weixin/android/wxweb/plugin/pluginUpdateConfig_test.xml")) {
              this.aahz.setText("切换插件配置，当前使用默认测试版");
            } else {
              d.this.ec("切换失败", true);
            }
          }
        }
      });
      ((Button)this.aahl.findViewById(R.id.button_update_all_plugin)).setOnClickListener(new d.14(this));
      ((Button)this.aahl.findViewById(R.id.button_clear_all_plugin)).setOnClickListener(new d.15(this));
      ((Spinner)this.aahl.findViewById(R.id.spinner_select_plugin)).setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
      {
        public final void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(154167);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousAdapterView);
          localb.bn(paramAnonymousView);
          localb.sg(paramAnonymousInt);
          localb.Fs(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/xweb/xwalk/WebDebugPage$23", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
          paramAnonymousAdapterView = d.this.aaaH.getResources().getStringArray(R.array.plugins);
          d.this.aahf = paramAnonymousAdapterView[paramAnonymousInt];
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$23", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(154167);
        }
        
        public final void onNothingSelected(AdapterView<?> paramAnonymousAdapterView) {}
      });
      ((Button)this.aahl.findViewById(R.id.button_load_local_plugin)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(154169);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/xweb/xwalk/WebDebugPage$24", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          d.a(d.this.aaaH, d.this.aahf, false, new ValueCallback() {});
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$24", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(154169);
        }
      });
      ((Button)this.aahl.findViewById(R.id.button_load_local_plugin_64)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(154171);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/xweb/xwalk/WebDebugPage$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          d.a(d.this.aaaH, d.this.aahf, true, new ValueCallback() {});
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(154171);
        }
      });
      ((Button)this.aahl.findViewById(R.id.button_update_plugin)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(154172);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/xweb/xwalk/WebDebugPage$26", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          d.dl(d.this.aaaH, d.this.aahf);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$26", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(154172);
        }
      });
      ((Button)this.aahl.findViewById(R.id.button_clear_plugin)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(154173);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/xweb/xwalk/WebDebugPage$27", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          paramAnonymousView = com.tencent.xweb.xwalk.a.h.bEW(d.this.aahf);
          if (paramAnonymousView == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$27", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(154173);
            return;
          }
          int i = paramAnonymousView.izd();
          if (i < 0)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$27", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(154173);
            return;
          }
          localObject = paramAnonymousView.aCZ(i);
          paramAnonymousView.aCY(-1);
          if ((localObject != null) && (!((String)localObject).isEmpty())) {
            com.tencent.xweb.util.c.bFA((String)localObject);
          }
          Toast.makeText(d.this.aaaH, "清理完成", 0).show();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$27", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(154173);
        }
      });
      localObject1 = (CheckBox)this.aahl.findViewById(R.id.checked_disable_filereader_cache);
      ((CheckBox)localObject1).setChecked(y.iwp().iwq());
      ((CheckBox)localObject1).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
      {
        public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(154174);
          paramAnonymousCompoundButton = y.iwp().aaaH.getSharedPreferences("wcwebview", 4);
          if (paramAnonymousCompoundButton != null)
          {
            paramAnonymousCompoundButton = paramAnonymousCompoundButton.edit();
            if (paramAnonymousCompoundButton != null)
            {
              paramAnonymousCompoundButton.putBoolean("fr_disable_cache", paramAnonymousBoolean);
              paramAnonymousCompoundButton.commit();
              if (paramAnonymousBoolean)
              {
                paramAnonymousCompoundButton = com.tencent.xweb.xwalk.a.h.izh().iterator();
                while (paramAnonymousCompoundButton.hasNext())
                {
                  Object localObject = (com.tencent.xweb.xwalk.a.g)paramAnonymousCompoundButton.next();
                  if ((localObject instanceof m))
                  {
                    int i = ((com.tencent.xweb.xwalk.a.g)localObject).izd();
                    if (i >= 0)
                    {
                      localObject = ((com.tencent.xweb.xwalk.a.g)localObject).aDa(i);
                      if (!((String)localObject).isEmpty()) {
                        com.tencent.xweb.util.c.bFA((String)localObject);
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
      localObject1 = (CheckBox)this.aahl.findViewById(R.id.checked_disable_filereader_crash_detect);
      ((CheckBox)localObject1).setChecked(y.iwp().iwr());
      ((CheckBox)localObject1).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
      {
        public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(154175);
          paramAnonymousCompoundButton = y.iwp().aaaH.getSharedPreferences("wcwebview", 4);
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
      ((TextView)this.aahl.findViewById(R.id.text_filereader_type)).setText(iyE());
      localObject1 = (EditText)this.aahl.findViewById(R.id.edit_text_filereader_format);
      ((Button)this.aahl.findViewById(R.id.button_filereader_force_xweb)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(154177);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/xweb/xwalk/WebDebugPage$30", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          d.a(d.this, this.aahC.getText().toString(), f.a.ZZL);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$30", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(154177);
        }
      });
      ((Button)this.aahl.findViewById(R.id.button_filereader_force_x5)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(154178);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/xweb/xwalk/WebDebugPage$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          d.a(d.this, this.aahC.getText().toString(), f.a.ZZM);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(154178);
        }
      });
      ((Button)this.aahl.findViewById(R.id.button_filereader_force_none)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(154179);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/xweb/xwalk/WebDebugPage$32", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          d.a(d.this, this.aahC.getText().toString(), f.a.ZZK);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$32", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(154179);
        }
      });
      localObject1 = (EditText)this.aahl.findViewById(R.id.edit_text_use_office_reader_format);
      ((Button)this.aahl.findViewById(R.id.button_use_office_reader_force_yes)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(154180);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/xweb/xwalk/WebDebugPage$33", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          d.a(d.this, this.aahD.getText().toString(), f.c.ZZQ);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$33", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(154180);
        }
      });
      ((Button)this.aahl.findViewById(R.id.button_use_office_reader_force_no)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(154181);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/xweb/xwalk/WebDebugPage$34", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          d.a(d.this, this.aahD.getText().toString(), f.c.ZZR);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$34", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(154181);
        }
      });
      ((Button)this.aahl.findViewById(R.id.button_use_office_reader_force_none)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(154182);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/xweb/xwalk/WebDebugPage$35", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          d.a(d.this, this.aahD.getText().toString(), f.c.ZZP);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$35", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(154182);
        }
      });
      ((TextView)this.aahl.findViewById(R.id.txtVersion)).setText(IU(true) + "\n" + XWalkInitializer.getXWalkInitializeLog());
      ((LinearLayout)this.aahl.findViewById(R.id.config_memu)).setVisibility(8);
      ((Button)this.aahl.findViewById(R.id.button_change_to_xweb)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(154183);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/xweb/xwalk/WebDebugPage$36", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          y.iwp().a("tools", WebView.c.aabm);
          y.iwp().a("toolsmp", WebView.c.aabm);
          y.iwp().a("appbrand", WebView.c.aabm);
          y.iwp().a("support", WebView.c.aabm);
          y.iwp().a("mm", WebView.c.aabm);
          if (!XWalkEnvironment.hasInstalledAvailableVersion()) {
            d.this.bFm("http://debugxweb.qq.com/?check_xwalk_update");
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$36", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(154183);
            return;
            d.this.ed("已使用XWeb，点任意位置重启进程生效\n", true);
          }
        }
      });
      ((Button)this.aahl.findViewById(R.id.button_change_to_x5)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(154184);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/xweb/xwalk/WebDebugPage$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          y.iwp().a("tools", WebView.c.aabn);
          y.iwp().a("toolsmp", WebView.c.aabn);
          y.iwp().a("appbrand", WebView.c.aabn);
          y.iwp().a("support", WebView.c.aabn);
          y.iwp().a("mm", WebView.c.aabn);
          if (com.tencent.xweb.WebView.getInstalledTbsCoreVersion(d.this.aaaH) <= 0) {
            d.this.ec("已切换x5，但是x5未ready，点任意位置重启进程生效\n", true);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(154184);
            return;
            d.this.ed("已使用x5，点任意位置重启进程生效\n", true);
          }
        }
      });
      ((Button)this.aahl.findViewById(R.id.button_change_to_sys)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(154185);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/xweb/xwalk/WebDebugPage$38", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          y.iwp().a("tools", WebView.c.aabo);
          y.iwp().a("toolsmp", WebView.c.aabo);
          y.iwp().a("appbrand", WebView.c.aabo);
          y.iwp().a("support", WebView.c.aabo);
          y.iwp().a("mm", WebView.c.aabo);
          d.this.ed("已使用system，点任意位置重启进程生效\n", true);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$38", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(154185);
        }
      });
      ((Button)this.aahl.findViewById(R.id.button_change_to_auto)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(154186);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/xweb/xwalk/WebDebugPage$39", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          XWalkEnvironment.setGrayValueForTest(0);
          XWalkEnvironment.setTestDownLoadUrl(d.this.aaaH, "");
          y.iwp().a("tools", WebView.c.aabl);
          y.iwp().a("toolsmp", WebView.c.aabl);
          y.iwp().a("appbrand", WebView.c.aabl);
          y.iwp().a("support", WebView.c.aabl);
          y.iwp().a("mm", WebView.c.aabl);
          d.this.ed("已使用AUTO，点任意位置重启进程生效\n", true);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$39", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(154186);
        }
      });
      ((Button)this.aahl.findViewById(R.id.button_advanced)).setOnClickListener(new d.35(this));
      ((Button)this.aahl.findViewById(R.id.button_savePage)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(205195);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/xweb/xwalk/WebDebugPage$41", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          boolean bool;
          if (!y.iwp().aaaM)
          {
            bool = true;
            y.iwp().IK(bool);
            if (!bool) {
              break label97;
            }
            d.this.iyz();
            d.this.aahk.setVisibility(0);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$41", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(205195);
            return;
            bool = false;
            break;
            label97:
            if (d.this.aahk != null) {
              d.this.aahk.setVisibility(8);
            }
          }
        }
      });
      localObject1 = (Button)this.aahl.findViewById(R.id.button_loadSavedPage);
      ((Button)localObject1).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(154194);
          Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/xweb/xwalk/WebDebugPage$42", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
          paramAnonymousView = d.this;
          localObject1 = new com.tencent.xweb.b.h(Environment.getExternalStorageDirectory());
          ((com.tencent.xweb.b.h)localObject1).ixd();
          localObject1 = ((com.tencent.xweb.b.h)localObject1).getPath() + "/xweb_dump";
          try
          {
            localObject2 = new com.tencent.xweb.b.h((String)localObject1);
            localObject3 = ((com.tencent.xweb.b.h)localObject2).ixd();
            if (localObject3.length != 0) {
              break label137;
            }
            paramAnonymousView.ec("web_dump目录下没有.zip文件,请确认应用权限，在权限管理打开应用的读写存储权限", true);
          }
          catch (Exception localException)
          {
            for (;;)
            {
              Object localObject2;
              Object localObject3;
              paramAnonymousView.ec("没有找到web_dump目录,请确认应用权限，在权限管理打开应用的读写存储权限", true);
              continue;
              int i = 0;
              for (;;)
              {
                if (i >= localObject3.length) {
                  break label263;
                }
                if (localObject3[i].getName().endsWith(".zip"))
                {
                  localObject2 = localObject3[i].bOF();
                  localObject3 = localObject3[i].getName();
                  new AlertDialog.Builder(paramAnonymousView.aaaH).setTitle("提示").setMessage("确定加载:" + (String)localObject3 + "?").setPositiveButton("确定", new d.47(paramAnonymousView, localException, (String)localObject2)).setNegativeButton("取消", new d.46(paramAnonymousView)).show();
                  break;
                }
                i += 1;
              }
              paramAnonymousView.ec("web_dump目录下没有.zip文件", true);
            }
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$42", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(154194);
        }
      });
      ((Button)this.aahl.findViewById(R.id.button_showFps)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(205097);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/xweb/xwalk/WebDebugPage$43", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          boolean bool;
          if (!y.iwp().aaaS)
          {
            bool = true;
            y.iwp().setShowFps(bool);
            d.b(d.this.aahe);
            if (!bool) {
              break label101;
            }
          }
          label101:
          for (paramAnonymousView = "打开显示fps";; paramAnonymousView = "关闭显示fps")
          {
            d.this.ed(paramAnonymousView, false);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$43", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(205097);
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
          AppMethodBeat.i(204668);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/xweb/xwalk/WebDebugPage$44", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aFi());
          new AlertDialog.Builder(d.this.aaaH).setTitle("提示").setMessage("清空保存页面文件").setPositiveButton("确定", new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(209349);
              d.b(d.this, Environment.getExternalStorageDirectory() + "/xweb_dump");
              AppMethodBeat.o(209349);
            }
          }).setNegativeButton("取消", new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(154200);
              AppMethodBeat.o(154200);
            }
          }).show();
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/xweb/xwalk/WebDebugPage$44", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(204668);
          return false;
        }
      });
      ((Button)this.aahl.findViewById(R.id.button_long_screenshot)).setOnClickListener(this.aahs);
      AppMethodBeat.o(154235);
      return true;
      ((RadioButton)this.aahl.findViewById(R.id.v8_auto)).setChecked(true);
      break;
      ((RadioButton)this.aahl.findViewById(R.id.v8_sys)).setChecked(true);
      break;
      ((RadioButton)this.aahl.findViewById(R.id.v8_x5)).setChecked(true);
      break;
      ((RadioButton)this.aahl.findViewById(R.id.v8_nativescript)).setChecked(true);
      break;
      ((RadioButton)this.aahl.findViewById(R.id.v8_mmv8)).setChecked(true);
      break;
      ((Button)localObject1).setVisibility(8);
      break label502;
      label1594:
      localObject1 = "使用测试config".concat(String.valueOf(localObject1));
      break label595;
      label1608:
      ((Button)localObject1).setText("切换插件配置, 当前使用自定义测试版");
      continue;
      label1618:
      ((Button)localObject1).setText("切换插件配置，当前使用正式版");
    }
  }
  
  final void iyF()
  {
    AppMethodBeat.i(210389);
    Object localObject = com.tencent.xweb.xwalk.a.h.izh().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((com.tencent.xweb.xwalk.a.g)((Iterator)localObject).next()).aCY(-1);
    }
    localObject = XWalkEnvironment.getPluginBaseDir();
    if (((String)localObject).isEmpty())
    {
      AppMethodBeat.o(210389);
      return;
    }
    com.tencent.xweb.util.c.bFA((String)localObject);
    ec("所有插件清理完成", true);
    AppMethodBeat.o(210389);
  }
  
  final void iyG()
  {
    AppMethodBeat.i(154241);
    com.tencent.xweb.xwalk.b.c.aakL = true;
    com.tencent.xweb.xwalk.b.c.izA();
    new c(this.aaaH).z(null);
    AppMethodBeat.o(154241);
  }
  
  final void iyz()
  {
    AppMethodBeat.i(154228);
    if (!y.iwp().aaaM)
    {
      AppMethodBeat.o(154228);
      return;
    }
    if (this.aahk != null)
    {
      AppMethodBeat.o(154228);
      return;
    }
    this.aahk = new Button(this.aaaH);
    this.aahk.setText("保存页面");
    this.aahk.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(154152);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/xweb/xwalk/WebDebugPage$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        new AlertDialog.Builder(d.this.aaaH).setTitle("保存页面").setMessage("确定保存页面？").setPositiveButton("确定", new DialogInterface.OnClickListener()
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
            paramAnonymous2DialogInterface.aahe.savePage((String)localObject2, str, 1);
            new Thread(new d.49(paramAnonymous2DialogInterface, (String)localObject1)).start();
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
    this.aahe.getTopView().addView(this.aahk);
    AppMethodBeat.o(154228);
  }
  
  final void n(WebView.c paramc)
  {
    AppMethodBeat.i(154234);
    switch (51.qYM[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(154234);
      return;
      ((RadioButton)this.aahl.findViewById(R.id.WV_AUTO)).setChecked(true);
      AppMethodBeat.o(154234);
      return;
      ((RadioButton)this.aahl.findViewById(R.id.WV_XWALK)).setChecked(true);
      AppMethodBeat.o(154234);
      return;
      ((RadioButton)this.aahl.findViewById(R.id.WV_X5)).setChecked(true);
      AppMethodBeat.o(154234);
      return;
      ((RadioButton)this.aahl.findViewById(R.id.WV_SYS)).setChecked(true);
    }
  }
  
  static final class a
    implements s.a
  {
    private ProgressDialog aahG;
    boolean aaib;
    Context mContext;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(207078);
      this.aaib = false;
      this.mContext = paramContext;
      s.a(this);
      bFN("正在监听更新,点空白区域取消");
      AppMethodBeat.o(207078);
    }
    
    private void bFN(String paramString)
    {
      AppMethodBeat.i(207088);
      if (this.aahG == null)
      {
        this.aahG = new ProgressDialog(this.mContext);
        this.aahG.setProgressStyle(1);
        this.aahG.setMessage(paramString);
        this.aahG.setOnCancelListener(new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(205118);
            s.b(d.a.this);
            if (d.a.this.aaib) {
              d.jK(d.a.this.mContext);
            }
            AppMethodBeat.o(205118);
          }
        });
        this.aahG.setCancelable(true);
        this.aahG.show();
      }
      this.aahG.setMessage(paramString);
      AppMethodBeat.o(207088);
    }
    
    public final void Et(int paramInt)
    {
      AppMethodBeat.i(207081);
      if (paramInt == 0) {}
      try
      {
        bFN("更新完成，点任意位置重启进程生效");
        this.aaib = true;
        this.aahG.setCancelable(true);
        this.aahG.setCanceledOnTouchOutside(true);
        this.aahG.setProgress(100);
        AppMethodBeat.o(207081);
        return;
      }
      catch (Exception localException)
      {
        Log.i("WebDebugPage", "may run in background failed to load alert:" + localException.getMessage());
        AppMethodBeat.o(207081);
        return;
      }
      if (paramInt == -5)
      {
        bFN("暂无需要立即更新的版本");
        this.aahG.setCancelable(true);
        this.aahG.setCanceledOnTouchOutside(true);
        AppMethodBeat.o(207081);
        return;
      }
      this.aahG.setCancelable(true);
      this.aahG.setCanceledOnTouchOutside(true);
      bFN("更新失败, error code = :".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(207081);
    }
    
    public final void Eu(int paramInt)
    {
      AppMethodBeat.i(207083);
      try
      {
        bFN("正在下载内核");
        if (this.aahG != null)
        {
          this.aahG.setCancelable(false);
          this.aahG.setProgress(paramInt);
        }
        AppMethodBeat.o(207083);
        return;
      }
      catch (Exception localException)
      {
        Log.i("WebDebugPage", "may run in background failed to load alert:" + localException.getMessage());
        AppMethodBeat.o(207083);
      }
    }
    
    public final void cqT()
    {
      AppMethodBeat.i(207079);
      bFN("开始更新");
      AppMethodBeat.o(207079);
    }
    
    public final void cqU()
    {
      AppMethodBeat.i(207086);
      bFN("主配置更新完成");
      AppMethodBeat.o(207086);
    }
    
    public final void cqV()
    {
      AppMethodBeat.i(207087);
      bFN("插件配置更新完成");
      AppMethodBeat.o(207087);
    }
  }
  
  static final class b
    extends XWalkUpdater.UpdateConfig
  {
    String aaid;
    
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
      this.aaid = paramString1;
      this.aajq = false;
      this.aajs = false;
      this.aajw = "local:".concat(String.valueOf(paramString2));
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
      AppMethodBeat.i(209860);
      new d.a(d.this.aaaH);
      AppMethodBeat.o(209860);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d
 * JD-Core Version:    0.7.0.1
 */