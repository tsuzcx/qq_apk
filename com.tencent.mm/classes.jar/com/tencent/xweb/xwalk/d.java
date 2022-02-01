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
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.widget.Button;
import android.widget.CheckBox;
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
import com.tencent.xweb.f;
import com.tencent.xweb.f.a;
import com.tencent.xweb.f.c;
import com.tencent.xweb.internal.l;
import com.tencent.xweb.internal.l.a;
import com.tencent.xweb.s;
import com.tencent.xweb.s.a;
import com.tencent.xweb.w;
import com.tencent.xweb.xwalk.a.a.a;
import com.tencent.xweb.xwalk.a.j;
import com.tencent.xweb.xwalk.a.k;
import com.tencent.xweb.xwalk.updater.Scheduler;
import com.tencent.xweb.xwalk.updater.XWebCoreScheduler;
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
  com.tencent.xweb.WebView SFP;
  String SFQ;
  ScrollView SFR;
  TextView SFS;
  TextView SFT;
  TextView SFU;
  Button SFV;
  View SFW;
  boolean SFX;
  String SFY;
  private final String SFZ;
  private final String SGa;
  private final String SGb;
  private final String SGc;
  private View.OnClickListener SGd;
  Context SzQ;
  
  public d(com.tencent.xweb.WebView paramWebView)
  {
    AppMethodBeat.i(154224);
    this.SFQ = "";
    this.SFR = null;
    this.SFS = null;
    this.SFT = null;
    this.SFU = null;
    this.SFV = null;
    this.SFX = false;
    this.SFY = "tools";
    this.SFZ = "当前Dark Mode强制智能反色[%d,%d]（点击切换）";
    this.SGa = "当前Dark Mode不强制智能反色[%d,%d]（点击切换）";
    this.SGb = "当前Light Mode[%d,%d]（点击切换）";
    this.SGc = "当前未知Mode[%d,%d]（点击切换）";
    this.SGd = new d.40(this);
    this.SzQ = paramWebView.getContext();
    this.SFP = paramWebView;
    huO();
    huM();
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
    if (com.tencent.xweb.a.brE(paramString) != WebView.c.SAs)
    {
      paramc = com.tencent.xweb.a.brE(paramString);
      localStringBuilder.append("\n   has command type ".concat(String.valueOf(paramc)));
    }
    if (y.hsF().dI(paramString, true) != WebView.c.SAs)
    {
      paramc = y.hsF().bsk(paramString);
      localStringBuilder.append("\n   has abtest type ".concat(String.valueOf(paramc)));
    }
    for (int i = 1;; i = 0)
    {
      if (y.hsF().dI(paramString, false) != WebView.c.SAs)
      {
        paramContext = y.hsF().bsk(paramString);
        localStringBuilder.append("\n   has hardcode type ".concat(String.valueOf(paramContext)));
        i = j;
      }
      for (;;)
      {
        if ((i == 0) && (paramContext == WebView.c.SAt) && (XWalkEnvironment.getXWebInitArgs("isgpversion", false)))
        {
          paramContext = WebView.c.SAv;
          localStringBuilder.append("\n   is prefer " + paramContext + " because of gp version");
        }
        for (;;)
        {
          paramc = paramContext;
          if (paramContext == WebView.c.SAt)
          {
            paramc = paramContext;
            if (!XWalkEnvironment.hasAvailableVersion())
            {
              paramc = WebView.c.SAu;
              localStringBuilder.append("\n   is prefer " + paramc + " because of xwalk is not available");
            }
          }
          com.tencent.xweb.internal.h.d(paramc);
          if (com.tencent.xweb.internal.h.htF().htK())
          {
            paramc = WebView.c.SAv;
            localStringBuilder.append("\n   is prefer " + paramc + " because of LoadUrlWatchDog");
          }
          if (com.tencent.xweb.internal.b.c(paramc)) {
            localStringBuilder.append("\n   will not use " + paramc + " because of CrashWatchDog hit");
          }
          if (paramc == WebView.c.SAu) {
            com.tencent.xweb.x5.sdk.d.huK();
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
    localh.htu();
    final com.tencent.xweb.xwalk.a.g localg = com.tencent.xweb.xwalk.a.h.brX(paramString);
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
        private ProgressDialog yuB = null;
        
        private Boolean huU()
        {
          int i = 99999;
          boolean bool = true;
          AppMethodBeat.i(207265);
          Object localObject2 = null;
          for (;;)
          {
            try
            {
              int k = localg.hvk();
              com.tencent.xweb.xwalk.updater.c localc;
              if (this.SGy > 0)
              {
                int j = this.SGy;
                i = j;
                if (k > 0)
                {
                  localObject1 = localg.atd(k);
                  localg.atc(-1);
                  i = j;
                  if (localObject1 != null)
                  {
                    i = j;
                    if (!((String)localObject1).isEmpty())
                    {
                      com.tencent.xweb.util.c.bsB((String)localObject1);
                      i = j;
                    }
                  }
                }
                localc = new com.tencent.xweb.xwalk.updater.c();
                localc.version = i;
                localc.SJc = false;
                localc.path = localg.ca(i, false);
                localObject1 = new File(localc.path);
              }
              try
              {
                if (this.SGz)
                {
                  com.tencent.xweb.util.c.b(this.val$context.getAssets().open(paramString), (File)localObject1);
                  localc.SID = com.tencent.xweb.b.i.bhK(((File)localObject1).getPath());
                  localc.SJl = true;
                  if (localg.a(localc) != 0) {
                    continue;
                  }
                  AppMethodBeat.o(207265);
                  return Boolean.valueOf(bool);
                  if (k < 99999) {
                    continue;
                  }
                  i = k + 1;
                  continue;
                }
                com.tencent.xweb.b.i.copyFile(this.SGB, ((File)localObject1).getPath());
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
              AppMethodBeat.o(207265);
              return localObject1;
              bool = false;
            }
            catch (Exception localException1) {}
          }
        }
        
        protected final void onPreExecute()
        {
          AppMethodBeat.i(207264);
          this.yuB = new ProgressDialog(this.val$context);
          this.yuB.setProgressStyle(0);
          this.yuB.setMessage("安装中");
          this.yuB.setCancelable(false);
          this.yuB.setCanceledOnTouchOutside(false);
          this.yuB.setButton(-1, "完成", new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(207263);
              d.42.a(d.42.this).hide();
              AppMethodBeat.o(207263);
            }
          });
          this.yuB.show();
          this.yuB.getButton(-1).setVisibility(8);
          AppMethodBeat.o(207264);
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
    //   3: ldc_w 389
    //   6: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: ifnull +12 -> 22
    //   13: invokestatic 212	com/tencent/xweb/y:hsF	()Lcom/tencent/xweb/y;
    //   16: getfield 392	com/tencent/xweb/y:SAb	Z
    //   19: ifne +13 -> 32
    //   22: ldc_w 389
    //   25: invokestatic 154	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: ldc 2
    //   30: monitorexit
    //   31: return
    //   32: aload_0
    //   33: invokestatic 394	com/tencent/xweb/xwalk/d:b	(Lcom/tencent/xweb/internal/IWebView;)V
    //   36: ldc_w 389
    //   39: invokestatic 154	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  private void agw(String paramString)
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
          agw(paramString + "//" + arrayOfString[i]);
          i += 1;
        }
      }
    }
    localh.delete();
    AppMethodBeat.o(154240);
  }
  
  /* Error */
  public static void b(com.tencent.xweb.internal.IWebView paramIWebView)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 490
    //   6: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: ifnull +12 -> 22
    //   13: invokestatic 212	com/tencent/xweb/y:hsF	()Lcom/tencent/xweb/y;
    //   16: getfield 392	com/tencent/xweb/y:SAb	Z
    //   19: ifne +13 -> 32
    //   22: ldc_w 490
    //   25: invokestatic 154	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: ldc 2
    //   30: monitorexit
    //   31: return
    //   32: aload_0
    //   33: ldc_w 492
    //   36: new 38	com/tencent/xweb/xwalk/d$50
    //   39: dup
    //   40: invokespecial 493	com/tencent/xweb/xwalk/d$50:<init>	()V
    //   43: invokeinterface 499 3 0
    //   48: ldc_w 490
    //   51: invokestatic 154	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public static boolean bsN(String paramString)
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
      com.tencent.xweb.util.h.OQ(223L);
      Log.e("WebDebugPage", "this url contians debug piece, url =  ".concat(String.valueOf(paramString)));
    }
    AppMethodBeat.o(154252);
    return bool;
  }
  
  private boolean dP(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(154227);
    if ((paramString.contains("debugxweb.qq.com")) || (paramBoolean))
    {
      Uri localUri = Uri.parse(paramString);
      paramString = localUri.getQueryParameterNames();
      if ((paramString == null) || (paramString.size() == 0))
      {
        huQ();
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
              Es(false);
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
          paramString = y.hsF();
          paramString.SzX = paramBoolean;
          paramString.SzQ.getSharedPreferences("wcwebview", 0).edit().putBoolean("bWaitforDebugger", paramBoolean).commit();
          continue;
          paramString = localUri.getQueryParameter("debug_process");
          y.hsF().SzQ.getSharedPreferences("wcwebview", 4).edit().putString("strDebugProcess", paramString).commit();
          continue;
          paramString = localUri.getQueryParameter("set_apkver");
          try
          {
            XWalkEnvironment.setAvailableVersion(Integer.parseInt(paramString), "1.0.".concat(String.valueOf(paramString)), XWalkEnvironment.getRuntimeAbi());
            dR("版本号设置到:" + paramString + " 点击空白处退出重启进程", true);
          }
          catch (Exception paramString)
          {
            dQ("设置版本号失败:" + paramString.getMessage(), true);
          }
          continue;
          p.Et(true);
          continue;
          paramString = localUri.getQueryParameter("revert_to_apk");
          try
          {
            i = p.aX(XWalkEnvironment.getApplicationContext(), Integer.parseInt(paramString));
            dR("版本号回滚到:" + i + " 点击空白处退出重启进程", true);
          }
          catch (Exception paramString)
          {
            dQ("版本号回滚到失败:" + paramString.getMessage(), true);
          }
          continue;
          paramString = localUri.getQueryParameter("set_config_peroid");
          try
          {
            com.tencent.xweb.a.asP(Integer.parseInt(paramString));
            dR("设置配置拉取周期为:" + paramString + "分钟", false);
          }
          catch (Exception paramString)
          {
            dQ("设置配置拉取周期失败:" + paramString.getMessage(), true);
          }
          continue;
          l.g(WebView.c.SAt).excute("STR_CMD_SET_RECHECK_COMMAND", null);
          dR("重新跑了一遍命令配置 点击空白处退出重启进程", true);
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
          dQ("强制设置文件预览方式失败，参数错误", true);
        }
        else
        {
          paramString = arrayOfString[(arrayOfString.length - 1)];
          if ("xweb".equalsIgnoreCase(paramString)) {
            paramString = f.a.SyU;
          }
          for (;;)
          {
            if ((arrayOfString.length == 2) && ("all".equalsIgnoreCase(arrayOfString[0])))
            {
              localObject = f.SyR;
              localObject = y.hsF().a((String[])localObject, paramString);
              if (((String)localObject).isEmpty()) {
                break label1086;
              }
              dQ("格式:" + (String)localObject + "强制使用" + paramString.name() + "打开", true);
              break;
              if ("x5".equalsIgnoreCase(paramString))
              {
                paramString = f.a.SyV;
              }
              else if ("none".equalsIgnoreCase(paramString))
              {
                paramString = f.a.SyT;
              }
              else
              {
                dQ("强制设置文件预览方式失败，类型错误", true);
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
          dQ("强制设置文件预览方式失败", true);
          continue;
          paramString = "";
        }
        label1325:
        label1336:
        try
        {
          localObject = localUri.getQueryParameter("set_force_filereader");
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
          dQ("强制设置OfficeReader失败，参数错误", true);
        }
        else
        {
          paramString = arrayOfString[(arrayOfString.length - 1)];
          if ("yes".equalsIgnoreCase(paramString)) {
            paramString = f.c.SyZ;
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
            localObject = y.hsF().a((String[])localObject, paramString);
            if (((String)localObject).isEmpty()) {
              break label1372;
            }
            dQ("格式:" + (String)localObject + "强制OfficeReader状态：" + paramString.toString(), true);
            break;
            if ("no".equalsIgnoreCase(paramString))
            {
              paramString = f.c.Sza;
            }
            else
            {
              if (!"none".equalsIgnoreCase(paramString)) {
                break label1325;
              }
              paramString = f.c.SyY;
            }
          }
          dQ("强制设置OfficeReader失败，类型错误", true);
          continue;
          localObject = new String[arrayOfString.length - 1];
          i = 0;
          while (i < arrayOfString.length - 1)
          {
            localObject[i] = arrayOfString[i];
            i += 1;
          }
          dQ("强制设置OfficeReader失败", true);
          continue;
          huS();
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
  
  public static void dc(Context paramContext, final String paramString)
  {
    AppMethodBeat.i(207284);
    final k localk = new k();
    localk.a(paramString, new j()
    {
      ProgressDialog SGr = null;
      boolean mFinished = false;
      
      public final void asQ(int paramAnonymousInt)
      {
        AppMethodBeat.i(207261);
        if ((this.mFinished) || (this.SGr == null))
        {
          AppMethodBeat.o(207261);
          return;
        }
        this.SGr.setProgress(paramAnonymousInt);
        AppMethodBeat.o(207261);
      }
      
      public final void asR(int paramAnonymousInt)
      {
        AppMethodBeat.i(207262);
        this.mFinished = true;
        if (this.SGr == null)
        {
          AppMethodBeat.o(207262);
          return;
        }
        Object localObject = com.tencent.xweb.xwalk.a.h.brX(paramString);
        int i;
        if (localObject != null)
        {
          i = ((com.tencent.xweb.xwalk.a.g)localObject).hvk();
          switch (paramAnonymousInt)
          {
          default: 
            this.SGr.setMessage(paramString + " 更新失败，未知错误，ErrCode = " + paramAnonymousInt);
            label129:
            if ((this.SGv != null) && (y.hsF() != null))
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
          String str = y.hsF().a((String[])localObject, this.SGv);
          e.ah((String[])localObject);
          Toast.makeText(this.val$context, "格式:" + str + "强制使用" + this.SGv.name() + "打开", 0).show();
          if (this.lVB != null) {
            this.lVB.onReceiveValue(Integer.valueOf(paramAnonymousInt));
          }
          AppMethodBeat.o(207262);
          return;
          i = -1;
          break;
          this.SGr.setMessage(paramString + " 更新完成，已安装版本" + i);
          this.SGr.setProgress(100);
          this.SGr.getButton(-2).setVisibility(8);
          this.SGr.getButton(-1).setVisibility(0);
          if (!this.SGu) {
            break label129;
          }
          this.SGr.dismiss();
          break label129;
          this.SGr.setMessage(paramString + " 更新被取消，ErrCode = " + paramAnonymousInt);
          break label129;
          this.SGr.setMessage(paramString + " 更新失败，无网络，ErrCode = " + paramAnonymousInt);
          break label129;
          this.SGr.setMessage(paramString + " 更新失败，未到检查时间，ErrCode = " + paramAnonymousInt);
          break label129;
          this.SGr.setMessage(paramString + " 更新失败，其它任务正在更新插件，ErrCode = " + paramAnonymousInt);
          break label129;
          this.SGr.setMessage(paramString + " 更新失败，配置下载失败，ErrCode = " + paramAnonymousInt);
          break label129;
          this.SGr.setMessage(paramString + " 更新失败，配置解析失败，ErrCode = " + paramAnonymousInt);
          break label129;
          this.SGr.setMessage(paramString + " 更新失败，配置中未包含插件信息，ErrCode = " + paramAnonymousInt);
          break label129;
          this.SGr.setMessage(paramString + " 更新失败，未找到可用更新，当前已安装版本" + i + "，ErrCode = " + paramAnonymousInt);
          if (!this.SGu) {
            break label129;
          }
          this.SGr.dismiss();
          break label129;
          this.SGr.setMessage(paramString + " 更新失败，下载安装出错，ErrCode = " + paramAnonymousInt);
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
        AppMethodBeat.o(207262);
      }
      
      public final void hst()
      {
        AppMethodBeat.i(207260);
        this.SGr = new ProgressDialog(this.val$context);
        this.SGr.setProgressStyle(1);
        this.SGr.setMessage(paramString + " 下载更新中");
        this.SGr.setCancelable(false);
        this.SGr.setCanceledOnTouchOutside(false);
        this.SGr.setButton(-2, "取消", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(207258);
            if (!d.41.this.mFinished) {
              d.41.this.SGt.hsE();
            }
            AppMethodBeat.o(207258);
          }
        });
        this.SGr.setButton(-1, "完成", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(207259);
            d.41.this.SGr.dismiss();
            AppMethodBeat.o(207259);
          }
        });
        this.SGr.show();
        this.SGr.getButton(-1).setVisibility(8);
        AppMethodBeat.o(207260);
      }
    });
    paramString = new HashMap();
    paramString.put("UpdaterCheckType", "1");
    localk.b(paramContext, paramString);
    AppMethodBeat.o(207284);
  }
  
  private void huP()
  {
    AppMethodBeat.i(154233);
    if (this.SFT == null)
    {
      AppMethodBeat.o(154233);
      return;
    }
    String str = Er(false);
    this.SFT.setText(str);
    AppMethodBeat.o(154233);
  }
  
  private static String huR()
  {
    int j = 0;
    AppMethodBeat.i(154237);
    Object localObject = new StringBuilder();
    String[] arrayOfString = f.SyR;
    int k = arrayOfString.length;
    int i = 0;
    String str;
    while (i < k)
    {
      str = arrayOfString[i];
      ((StringBuilder)localObject).append("\n ").append(str).append(": force-").append(y.hsF().bsl(str)).append("  cmd-tools-").append(com.tencent.xweb.b.nW(str, "tools")).append("  cmd-appbrand-").append(com.tencent.xweb.b.nW(str, "appbrand"));
      i += 1;
    }
    ((StringBuilder)localObject).append("\n\n use office reader:");
    arrayOfString = f.SyR;
    k = arrayOfString.length;
    i = j;
    while (i < k)
    {
      str = arrayOfString[i];
      if (!"pdf".equals(str)) {
        ((StringBuilder)localObject).append("\n ").append(str).append(": force-").append(y.hsF().bsm(str)).append("  cmd-tools-").append(com.tencent.xweb.b.nV(str, "tools")).append("  cmd-appbrand-").append(com.tencent.xweb.b.nV(str, "appbrand")).append("  cmd-mm-").append(com.tencent.xweb.b.nV(str, "mm"));
      }
      i += 1;
    }
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(154237);
    return localObject;
  }
  
  protected static void iH(Context paramContext)
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
          com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/xweb/xwalk/WebDebugPage", "killAllProcess", "(Landroid/content/Context;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
          Process.killProcess(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/xweb/xwalk/WebDebugPage", "killAllProcess", "(Landroid/content/Context;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
        }
      }
    }
    paramContext = com.tencent.mm.hellhoundlib.b.c.a(i, new com.tencent.mm.hellhoundlib.b.a());
    Object localObject1 = new Object();
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, paramContext.axQ(), "com/tencent/xweb/xwalk/WebDebugPage", "killAllProcess", "(Landroid/content/Context;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
    Process.killProcess(((Integer)paramContext.pG(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/xweb/xwalk/WebDebugPage", "killAllProcess", "(Landroid/content/Context;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
    AppMethodBeat.o(154243);
  }
  
  public static void lF(Context paramContext)
  {
    AppMethodBeat.i(154238);
    Scheduler.SIT = true;
    k localk = new k();
    HashMap localHashMap = new HashMap();
    localHashMap.put("UpdaterCheckType", "1");
    localk.b(paramContext, localHashMap);
    AppMethodBeat.o(154238);
  }
  
  private static int mP(int paramInt1, int paramInt2)
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
  
  final String Er(boolean paramBoolean)
  {
    AppMethodBeat.i(154232);
    String str2 = this.SFP.getVersionInfo();
    int i;
    if (!paramBoolean)
    {
      i = str2.indexOf(",apkversion");
      str1 = str2;
      if (i <= 0) {}
    }
    for (String str1 = str2.substring(0, i);; str1 = str2 + ", " + com.tencent.xweb.xwalk.a.h.hvp() + " current process is " + XWalkEnvironment.getProcessName())
    {
      AppMethodBeat.o(154232);
      return str1;
    }
  }
  
  final void Es(boolean paramBoolean)
  {
    AppMethodBeat.i(154246);
    Object localObject1 = new com.tencent.xweb.b.h(Environment.getExternalStorageDirectory());
    ((com.tencent.xweb.b.h)localObject1).htu();
    localObject1 = ((com.tencent.xweb.b.h)localObject1).getPath() + "/apkxwebtest";
    Object localObject2;
    try
    {
      localObject1 = new com.tencent.xweb.b.h((String)localObject1);
      localObject2 = ((com.tencent.xweb.b.h)localObject1).htu();
      if (localObject2.length == 0)
      {
        dQ("apkxwebtest目录下没有.zip文件,请确认应用权限，在权限管理打开应用的读写存储权限", true);
        AppMethodBeat.o(154246);
        return;
      }
    }
    catch (Exception localException)
    {
      dQ("没有找到apkxwebtest目录,请确认应用权限，在权限管理打开应用的读写存储权限", true);
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
          new AlertDialog.Builder(this.SzQ).setTitle("提示").setMessage("确定加载:" + (String)localObject2 + "?").setPositiveButton("确定", new d.44(this, str, (String)localObject2, paramBoolean)).setNegativeButton("取消", new d.43(this)).show();
          AppMethodBeat.o(154246);
          return;
        }
        G(str, (String)localObject2, paramBoolean);
        AppMethodBeat.o(154246);
        return;
      }
      i += 1;
    }
    dQ("apkxwebtest目录下没有.zip文件", true);
    AppMethodBeat.o(154246);
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
      localObject = com.tencent.xweb.b.i.LM(((com.tencent.xweb.b.h)localObject).getAbsolutePath());
      byte[] arrayOfByte = new byte[1048576];
      for (;;)
      {
        int i = paramString1.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        ((OutputStream)localObject).write(arrayOfByte, 0, i);
      }
      dQ("安装" + paramString2 + "失败,错误码=" + paramString1, true);
    }
    catch (IOException paramString1)
    {
      for (;;)
      {
        paramString1 = XWalkUpdater.onHandleFile(localb);
        if (paramString1.intValue() != 0) {
          break;
        }
        dQ("安装" + paramString2 + "成功", paramBoolean);
        AppMethodBeat.o(154247);
        return;
        ((OutputStream)localObject).flush();
        paramString1.close();
        ((OutputStream)localObject).close();
      }
    }
    catch (Exception paramString1)
    {
      dQ("安装失败", true);
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
          if ((paramBoolean2) && (this.SFP.getX5WebViewExtension() != null))
          {
            if (!paramBoolean1) {
              break label79;
            }
            this.SFP.loadUrl("http://debugx5.qq.com/?inspector=true");
          }
          while (paramButton != null) {
            if (paramBoolean1)
            {
              paramButton.setText("关闭远程调试模式(当前已打开)");
              AppMethodBeat.o(154244);
              return;
              label79:
              this.SFP.loadUrl("http://debugx5.qq.com/?inspector=false");
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
  
  final void bCn()
  {
    AppMethodBeat.i(154242);
    iH(this.SzQ);
    AppMethodBeat.o(154242);
  }
  
  public final boolean bsn(String paramString)
  {
    boolean bool5 = false;
    AppMethodBeat.i(154226);
    if (paramString == null)
    {
      AppMethodBeat.o(154226);
      return false;
    }
    Object localObject6;
    Object localObject1;
    Iterator localIterator;
    boolean bool1;
    boolean bool2;
    if ((paramString.contains("debugmm.qq.com")) || (paramString.contains("debugxweb.qq.com")))
    {
      com.tencent.xweb.util.h.OQ(224L);
      localObject6 = Uri.parse(paramString);
      localObject1 = ((Uri)localObject6).getQueryParameterNames();
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
      label310:
      Object localObject5;
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
              if (((Uri)localObject6).getBooleanQueryParameter("forcex5", false))
              {
                y.hsF().a("tools", WebView.c.SAu);
                y.hsF().a("appbrand", WebView.c.SAu);
                y.hsF().a("support", WebView.c.SAu);
                y.hsF().a("mm", WebView.c.SAu);
                y.hsF().a("toolsmp", WebView.c.SAu);
                y.hsF().a(JsRuntime.JsRuntimeType.SzA);
                dR("force use x5 switch is on ", true);
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
              break label310;
              if (!((String)localObject1).equals("inspector")) {
                break;
              }
              i = 1;
              break label310;
              if (!((String)localObject1).equals("ticket")) {
                break;
              }
              i = 2;
              break label310;
              if (!((String)localObject1).equals("show_x5_ver")) {
                break;
              }
              i = 3;
              break label310;
              if (!((String)localObject1).equals("encrpt_url")) {
                break;
              }
              i = 4;
              break label310;
              if (!((String)localObject1).equals("clear_test_setting")) {
                break;
              }
              i = 5;
              break label310;
              if (!((String)localObject1).equals("show_fps")) {
                break;
              }
              i = 6;
              break label310;
              if (!((String)localObject1).equals("set_mm_config")) {
                break;
              }
              i = 7;
              break label310;
              if (!((String)localObject1).equals("set_web_config")) {
                break;
              }
              i = 8;
              break label310;
              if (!((String)localObject1).equals("set_appbrand_config")) {
                break;
              }
              i = 9;
              break label310;
              if (!((String)localObject1).equals("show_webview_version")) {
                break;
              }
              i = 10;
              break label310;
              if (!((String)localObject1).equals("set_grayvalue")) {
                break;
              }
              i = 11;
              break label310;
              if (!((String)localObject1).equals("set_device_rd_value")) {
                break;
              }
              i = 12;
              break label310;
              if (!((String)localObject1).equals("check_xwalk_update")) {
                break;
              }
              i = 13;
              break label310;
              if (!((String)localObject1).equals("soft_check_xwalk_update")) {
                break;
              }
              i = 14;
              break label310;
              if (!((String)localObject1).equals("check_update_in_sandbox")) {
                break;
              }
              i = 15;
              break label310;
              if (!((String)localObject1).equals("clear_config_time_stamp")) {
                break;
              }
              i = 16;
              break label310;
              if (!((String)localObject1).equals("clear_schedule")) {
                break;
              }
              i = 17;
              break label310;
              if (!((String)localObject1).equals("set_config_url")) {
                break;
              }
              i = 18;
              break label310;
              if (!((String)localObject1).equals("set_plugin_config_url")) {
                break;
              }
              i = 19;
              break label310;
              if (!((String)localObject1).equals("check_plugin_update")) {
                break;
              }
              i = 20;
              break label310;
              y.hsF().a("tools", WebView.c.SAs);
              y.hsF().a("appbrand", WebView.c.SAs);
              y.hsF().a("support", WebView.c.SAs);
              y.hsF().a("mm", WebView.c.SAs);
              y.hsF().a("toolsmp", WebView.c.SAs);
              y.hsF().a(JsRuntime.JsRuntimeType.Szv);
              dR("force use x5 switch is off ", true);
            }
            bool1 = ((Uri)localObject6).getBooleanQueryParameter("inspector", false);
            y.hsF().setDebugEnable(bool1);
            a(bool1, null, true);
            AppMethodBeat.o(154226);
            return true;
            localObject1 = ((Uri)localObject6).getQueryParameter("ticket");
            localObject5 = ((Uri)localObject6).toString();
            if ((TextUtils.isEmpty((CharSequence)localObject5)) || (TextUtils.isEmpty((CharSequence)localObject1))) {
              bool2 = false;
            }
            for (;;)
            {
              if (bool2) {
                break label1138;
              }
              dQ("权限校验失败", true);
              Log.e("WebDebugPage", "checkTempPerssion failed");
              break;
              localObject5 = ((String)localObject5).trim();
              i = ((String)localObject5).lastIndexOf("ticket");
              if ((i < 0) || (i >= ((String)localObject5).length()))
              {
                bool2 = false;
              }
              else
              {
                localObject5 = ((String)localObject5).substring(0, i);
                String str2 = new SimpleDateFormat("yyyyMMdd").format(new Date());
                bool2 = com.tencent.xweb.util.b.bw((String)localObject5 + "@check_permission@" + str2, (String)localObject1, "MHYwEAYHKoZIzj0CAQYFK4EEACIDYgAE4s7oy+BvW5kzf5PwtVqDdZb2rVQS7GDf\naJWwtkD95ILDQAtHM9Nv5apLYQnUbXkjTldOUpjK7MimTkf/qXjQfk8hF2A0Mf7L\nHbDPr7kD9DOuQlG53SWOuKQVEwwsjN1l");
              }
            }
            label1138:
            Log.i("WebDebugPage", "checkTempPerssion suc");
            continue;
            bool1 = ((Uri)localObject6).getBooleanQueryParameter("show_x5_ver", false);
            paramString = y.hsF();
            if (bool1 != paramString.SzU)
            {
              paramString.SzU = bool1;
              paramString.SzQ.getSharedPreferences("wcwebview", 0).edit().putBoolean("bShowX5Version", paramString.SzU).commit();
            }
            if (bool1) {
              dQ("开启显示x5内核信息", true);
            }
            for (;;)
            {
              AppMethodBeat.o(154226);
              return true;
              dQ("关闭显示x5内核信息", true);
            }
            paramString = ((Uri)localObject6).getQueryParameter("encrpt_url");
            try
            {
              paramString = com.tencent.xweb.util.a.a(paramString, com.tencent.xweb.util.a.bsz("b01d4598de5875eb9b86abdef32b811e9c55edcfb1673b5617cc0a6ab7dceaff"));
              if (TextUtils.isEmpty(paramString))
              {
                dQ("解密失败", true);
                AppMethodBeat.o(154226);
                return true;
              }
              bsn(paramString);
            }
            catch (Throwable paramString)
            {
              for (;;)
              {
                dQ("解密失败", true);
              }
            }
            AppMethodBeat.o(154226);
            return true;
            p.lG(XWalkEnvironment.getApplicationContext());
            AppMethodBeat.o(154226);
            return true;
            bool1 = ((Uri)localObject6).getBooleanQueryParameter("show_fps", false);
            y.hsF().setShowFps(bool1);
            AppMethodBeat.o(154226);
            return true;
            try
            {
              localObject1 = WebView.c.valueOf(((Uri)localObject6).getQueryParameter("set_mm_config"));
              y.hsF().a("mm", (WebView.c)localObject1);
              dQ("mm进程将使用:".concat(String.valueOf(localObject1)), true);
            }
            catch (Exception localException1) {}
            continue;
            try
            {
              WebView.c localc = WebView.c.valueOf(((Uri)localObject6).getQueryParameter("set_web_config"));
              y.hsF().a("tools", localc);
              y.hsF().a("toolsmp", localc);
              dQ("打开网页将使用:".concat(String.valueOf(localc)), true);
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
          Object localObject2 = WebView.c.valueOf(((Uri)localObject6).getQueryParameter("set_appbrand_config"));
          y.hsF().a("appbrand", (WebView.c)localObject2);
          y.hsF().a("support", (WebView.c)localObject2);
          switch (51.nXl[localObject2.ordinal()])
          {
          case 1: 
            y.hsF().a(JsRuntime.JsRuntimeType.SzD);
            dQ("打开小程序将使用:".concat(String.valueOf(localObject2)), true);
            break;
          case 2: 
            y.hsF().a(JsRuntime.JsRuntimeType.SzA);
            dQ("打开小程序将使用:".concat(String.valueOf(localObject2)), true);
            break;
          case 3: 
            y.hsF().a(JsRuntime.JsRuntimeType.SzD);
            dQ("打开小程序将使用:".concat(String.valueOf(localObject2)), true);
            continue;
            if (this.SFU == null)
            {
              localObject2 = new ScrollView(this.SzQ);
              this.SFU = new TextView(this.SzQ);
              this.SFU.setTextColor(-16777216);
              this.SFU.setBackgroundColor(-1);
              ((ScrollView)localObject2).addView(this.SFU);
              this.SFU.setOnClickListener(new d.12(this));
              huN();
              this.SFP.getTopView().addView((View)localObject2);
              continue;
              try
              {
                i = Integer.parseInt(((Uri)localObject6).getQueryParameter("set_grayvalue"));
                XWalkEnvironment.setGrayValueForTest(i);
                dQ("灰度值设为" + i % 10000, true);
                bool1 = true;
              }
              catch (Exception localException3)
              {
                dQ("灰度值设置失败，参数解析错误", true);
                bool1 = true;
              }
              continue;
              try
              {
                i = Integer.parseInt(((Uri)localObject6).getQueryParameter("set_device_rd_value"));
                XWalkEnvironment.sNDeviceRd = i;
                XWalkEnvironment.getSharedPreferences().edit().putInt("sNDeviceRd", i).commit();
                XWalkEnvironment.setGrayValueForTest(i);
                dQ("设备随机灰度值设为" + i % 10000, true);
                bool1 = true;
              }
              catch (Exception localException4)
              {
                dQ("设备随机灰度值设置失败，参数解析错误", true);
                bool1 = true;
              }
              continue;
              dQ("开始检测浏览器和所有插件更新", true);
              huT();
              lF(XWalkEnvironment.getApplicationContext());
              continue;
              dQ("模拟触发沙箱进程检测浏览器内核更新", true);
              XWalkEnvironment.setConfigFetchPeriod(1800001L);
              w.b(XWalkEnvironment.getApplicationContext(), null);
              new a(this.SzQ);
              continue;
              Object localObject3 = Integer.TYPE;
              localObject5 = this.SzQ;
              com.tencent.xweb.util.g.b("com.tencent.mm.pluginsdk.model.TBSHelper", "checkXWalkNow", new Class[] { Context.class, localObject3 }, new Object[] { localObject5, Integer.valueOf(4) });
              dQ("即将发起沙箱进程检查更新", true);
              new a(this.SzQ);
              continue;
              dQ("重置上次拉取配置时间", true);
              Scheduler.hvD();
              k.OY(0L);
              continue;
              dQ("清理本地的更新计划", true);
              Scheduler.Ev(false).hvw();
              Scheduler.Ev(true).hvw();
              continue;
              try
              {
                localObject3 = ((Uri)localObject6).getQueryParameter("set_config_url");
                if ((XWalkEnvironment.isValidConfigHost((String)localObject3)) || (y.hsF().hsJ())) {
                  break label2101;
                }
                dQ("you have no athority to set this config url:".concat(String.valueOf(localObject3)), true);
              }
              catch (Exception localException5)
              {
                dQ("测试连接设置失败，格式错误", true);
              }
              continue;
              label2101:
              XWalkEnvironment.setTestDownLoadUrl(this.SzQ, localException5);
              dQ("测试连接设置为:".concat(String.valueOf(localException5)), true);
              continue;
              try
              {
                String str1 = ((Uri)localObject6).getQueryParameter("set_plugin_config_url");
                XWalkEnvironment.setPluginTestConfigUrl(str1);
                dQ("插件测试连接设置为:".concat(String.valueOf(str1)), true);
              }
              catch (Exception localException6)
              {
                dQ("插件测试连接设置失败，格式错误", true);
              }
              continue;
              Object localObject4 = "";
              try
              {
                localObject5 = ((Uri)localObject6).getQueryParameter("check_plugin_update");
                localObject4 = localObject5;
              }
              catch (Exception localException8)
              {
                for (;;)
                {
                  int k;
                  label2720:
                  label3154:
                  continue;
                  bool2 = bool1;
                  continue;
                  int j = 0;
                  bool1 = bool3;
                }
              }
              if ("all".equalsIgnoreCase((String)localObject4))
              {
                dQ("开始检测所有插件更新", true);
                lF(this.SzQ);
              }
              else if ("FullScreenVideo".equalsIgnoreCase((String)localObject4))
              {
                dc(this.SzQ, "FullScreenVideo");
              }
              else if ("XFilesPDFReader".equalsIgnoreCase((String)localObject4))
              {
                dc(this.SzQ, "XFilesPDFReader");
              }
              else if ("XFilesPPTReader".equalsIgnoreCase((String)localObject4))
              {
                dc(this.SzQ, "XFilesPPTReader");
              }
              else if ("XFilesWordReader".equalsIgnoreCase((String)localObject4))
              {
                dc(this.SzQ, "XFilesWordReader");
              }
              else if ("XFilesExcelReader".equalsIgnoreCase((String)localObject4))
              {
                dc(this.SzQ, "XFilesExcelReader");
              }
              else if ("XFilesOfficeReader".equalsIgnoreCase((String)localObject4))
              {
                dc(this.SzQ, "XFilesOfficeReader");
              }
              else
              {
                dQ("检测插件更新失败，参数错误", true);
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
                      localObject4 = (String)paramString.next();
                      if (localObject4 != null) {
                        switch (((String)localObject4).hashCode())
                        {
                        default: 
                          break;
                        case -1157057597: 
                          ((String)localObject4).equals("enable_local_debug");
                        }
                      }
                    }
                  }
                  AppMethodBeat.o(154226);
                  return true;
                }
                XWalkEnvironment.initTurnOnKVLog();
                if ((y.hsF().hsJ()) || (bool4)) {
                  k = 1;
                }
                for (;;)
                {
                  if ((paramString.contains("debugxweb.qq.com")) || (bool4))
                  {
                    localObject4 = Uri.parse(paramString);
                    localObject5 = ((Uri)localObject4).getQueryParameterNames();
                    if ((localObject5 == null) || (((Set)localObject5).size() == 0))
                    {
                      if (k != 0) {
                        huQ();
                      }
                      AppMethodBeat.o(154226);
                      return true;
                      k = 0;
                    }
                    else
                    {
                      localObject5 = ((Set)localObject5).iterator();
                      j = 0;
                      bool1 = bool3;
                      while (((Iterator)localObject5).hasNext())
                      {
                        localObject6 = (String)((Iterator)localObject5).next();
                        if (localObject6 != null)
                        {
                          switch (((String)localObject6).hashCode())
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
                              bool1 = ((Uri)localObject4).getBooleanQueryParameter("inspector", false);
                              y.hsF().setDebugEnable(bool1);
                              a(bool1, null, true);
                              bool1 = true;
                              break;
                              if (!((String)localObject6).equals("inspector")) {
                                break label2720;
                              }
                              i = 0;
                              continue;
                              if (!((String)localObject6).equals("use_testconfig")) {
                                break label2720;
                              }
                              i = 1;
                              continue;
                              if (!((String)localObject6).equals("kill_all")) {
                                break label2720;
                              }
                              i = 2;
                              continue;
                              if (!((String)localObject6).equals("ignore_crashwatch")) {
                                break label2720;
                              }
                              i = 3;
                              continue;
                              if (!((String)localObject6).equals("save_page")) {
                                break label2720;
                              }
                              i = 4;
                              continue;
                              if (!((String)localObject6).equals("clear_cache")) {
                                break label2720;
                              }
                              i = 5;
                              continue;
                              if (!((String)localObject6).equals("clear_old_ver")) {
                                break label2720;
                              }
                              i = 6;
                              continue;
                              if (!((String)localObject6).equals("fix_dex")) {
                                break label2720;
                              }
                              i = 7;
                              continue;
                              if (!((String)localObject6).equals("clear_all")) {
                                break label2720;
                              }
                              i = 8;
                              continue;
                              if (!((String)localObject6).equals("abandon_curent_ver")) {
                                break label2720;
                              }
                              i = 9;
                            }
                          }
                          bool1 = ((Uri)localObject4).getBooleanQueryParameter("use_testconfig", false);
                          y.hsF().Ej(bool1);
                          if (bool1) {
                            dQ("使用测试config", true);
                          }
                          for (;;)
                          {
                            bool1 = true;
                            break;
                            dQ("使用正式config", true);
                          }
                          j = 1;
                          bool1 = true;
                          continue;
                          bool2 = ((Uri)localObject4).getBooleanQueryParameter("ignore_crashwatch", false);
                          localObject6 = y.hsF();
                          ((y)localObject6).SzY = bool2;
                          ((y)localObject6).SzQ.getSharedPreferences("wcwebview", 0).edit().putBoolean("ignore_crashwatch", bool2).commit();
                          dQ("忽略crash检测设为 = ".concat(String.valueOf(bool2)), true);
                          continue;
                          if (!y.hsF().SzV) {}
                          for (bool2 = true;; bool2 = false)
                          {
                            y.hsF().Ei(bool2);
                            if (!bool2) {
                              break label3154;
                            }
                            huM();
                            this.SFV.setVisibility(0);
                            break;
                          }
                          if (this.SFV != null)
                          {
                            this.SFV.setVisibility(8);
                            continue;
                            ah.clearAllWebViewCache(XWalkEnvironment.getApplicationContext(), true);
                            dQ("网页cache已经清理:", true);
                            continue;
                            p.L(XWalkEnvironment.getApplicationContext(), true);
                            dQ("旧版本已经清理", true);
                            continue;
                            p.hva();
                            continue;
                            XWalkEnvironment.clearAllVersion(this.SzQ);
                            bool1 = true;
                            continue;
                            p.huX();
                            bool1 = true;
                          }
                        }
                      }
                      if (k != 0)
                      {
                        if (!dP(paramString, bool4))
                        {
                          bool2 = bool5;
                          if (!bool1) {}
                        }
                        else
                        {
                          bool2 = true;
                        }
                        if (j != 0) {
                          bCn();
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
  
  final void dQ(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(154248);
    if (paramBoolean) {
      try
      {
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.SzQ);
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
  
  final void dR(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(154249);
    try
    {
      AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.SzQ);
      localBuilder.setMessage(paramString);
      localBuilder.create();
      localBuilder.setCancelable(true);
      if (paramBoolean) {
        localBuilder.setOnCancelListener(new d.48(this));
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
    int i = this.SFP.getSettings().getForceDarkMode();
    int j = this.SFP.getSettings().getForceDarkBehavior();
    int k = mP(i, j);
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
  
  public final void hsZ()
  {
    AppMethodBeat.i(154225);
    if (y.hsF().SzS) {
      a(true, null, false);
    }
    AppMethodBeat.o(154225);
  }
  
  final void huM()
  {
    AppMethodBeat.i(154228);
    if (!y.hsF().SzV)
    {
      AppMethodBeat.o(154228);
      return;
    }
    if (this.SFV != null)
    {
      AppMethodBeat.o(154228);
      return;
    }
    this.SFV = new Button(this.SzQ);
    this.SFV.setText("保存页面");
    this.SFV.setOnClickListener(new d.1(this));
    this.SFP.getTopView().addView(this.SFV);
    AppMethodBeat.o(154228);
  }
  
  final void huN()
  {
    AppMethodBeat.i(154230);
    if (this.SFU == null)
    {
      AppMethodBeat.o(154230);
      return;
    }
    Object localObject5 = XWalkEnvironment.getXWalkUpdateConfigUrl();
    Object localObject2 = "\n\n" + this.SFP.getAbstractInfo();
    Object localObject1 = localObject2;
    if (com.tencent.xweb.WebView.getCurWebType() != WebView.c.SAt) {
      localObject1 = (String)localObject2 + "\n xwebsdk is = 201201 apk ver is " + XWalkEnvironment.getAvailableVersion() + " des " + XWalkEnvironment.getAvailableVersionDetail();
    }
    if (XWalkEnvironment.getApplicationContext().getApplicationInfo() != null) {}
    for (int i = XWalkEnvironment.getApplicationContext().getApplicationInfo().targetSdkVersion;; i = 0)
    {
      localObject1 = (String)localObject1 + "\n\n current js engine: =  " + JsRuntime.hsu() + "\n prefered js engine =  " + JsRuntime.a(JsRuntime.JsRuntimeType.Szv, "appbrand", this.SzQ) + "\n user id(uin) = " + XWalkEnvironment.getUserId() + "\n local gray value = " + XWalkEnvironment.getGrayValue() + "\n local gray device rd value = " + XWalkEnvironment.getDeviceRd() + "\n today gray value = " + XWalkEnvironment.getTodayGrayValue() + "\n config url = " + (String)localObject5 + "\n config period(minutes) = " + Scheduler.hvH() / 60000L + "\n\n apilevel = " + Build.VERSION.SDK_INT + "\n apilevel = " + i + "\n sys webversion = " + XWalkEnvironment.safeGetChromiunVersion() + "\n device is  " + Build.BRAND + " " + Build.MODEL + "\n usertype is " + XWalkEnvironment.getUserType() + "\n runtime abi is " + XWalkEnvironment.getRuntimeAbi() + "\n device abi is " + XWalkEnvironment.getDeviceAbi() + "\n installed ver for arm32 is " + XWalkEnvironment.getInstalledNewstVersion("armeabi-v7a") + "\n installed ver for arm64 is " + XWalkEnvironment.getInstalledNewstVersion("arm64-v8a") + "\n should embed =  false\n embed lib md5 match =  true\n embed config ver =  0/0" + "\n embed try installed ver =  " + XWalkUpdater.getLastTryInstallVer(XWalkEnvironment.getRuntimeAbi()) + "\n current useragent: " + this.SFP.getSettings().getUserAgentString() + "\n current clientversion: 0x" + Integer.toHexString(XWalkEnvironment.getAppClientVersion()) + "\n current app infos dump : " + XWalkEnvironment.dumpAppInfo();
      localObject2 = (String)localObject1 + "\n\n ------dump module prefer webview core start:------\n";
      localObject1 = localObject2;
      try
      {
        localObject2 = (String)localObject2 + a(this.SzQ, WebView.c.SAu, "tools") + "\n";
        localObject1 = localObject2;
        localObject2 = (String)localObject2 + a(this.SzQ, WebView.c.SAt, "toolsmp") + "\n";
        localObject1 = localObject2;
        localObject2 = (String)localObject2 + a(this.SzQ, WebView.c.SAs, "mm") + "\n";
        localObject1 = localObject2;
        localObject2 = (String)localObject2 + a(this.SzQ, WebView.c.SAt, "appbrand") + "\n";
        localObject1 = localObject2;
        localObject2 = (String)localObject2 + a(this.SzQ, WebView.c.SAt, "support") + "\n";
        localObject1 = localObject2;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          localObject1 = (String)localObject1 + localException1.getMessage() + "\n";
        }
        localObject1 = (String)localObject1 + "\n current update match gap backward(update speed) is " + Scheduler.bsT(Scheduler.Ev(false).Ex(false));
        localObject1 = (String)localObject1 + "\n current update match gap forward(提前更新) is " + Scheduler.bsT(Scheduler.Ev(false).Ex(true));
        localObject1 = (String)localObject1 + "\n plugin current update match gap backward(update speed) is " + Scheduler.bsT(new a.a("").Ex(false));
        localObject1 = (String)localObject1 + "\n plugin current update match gap forward(提前更新) is " + Scheduler.bsT(new a.a("").Ex(true));
        localObject3 = com.tencent.xweb.a.getAbstractInfo();
        if (localObject3 == null) {
          break label1923;
        }
      }
      localObject1 = (String)localObject1 + "------dump module prefer webview core end------";
      localObject1 = (String)localObject1 + "\n" + XWebCoreScheduler.hvW().hvx();
      localObject1 = (String)localObject1 + "\n" + com.tencent.xweb.xwalk.updater.i.hvV().hvx();
      localObject2 = com.tencent.xweb.xwalk.a.h.hvo().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject5 = (com.tencent.xweb.xwalk.a.g)((Iterator)localObject2).next();
        if (localObject5 != null)
        {
          localObject5 = com.tencent.xweb.xwalk.a.a.bsQ(((com.tencent.xweb.xwalk.a.g)localObject5).getPluginName());
          localObject1 = (String)localObject1 + "\n" + ((Scheduler)localObject5).hvx();
        }
      }
      Object localObject3;
      if (!((String)localObject3).isEmpty()) {
        localObject1 = (String)localObject1 + "\n\n ------dump commands start:------\n" + (String)localObject3 + "\n ------dump commands end------";
      }
      label1923:
      for (;;)
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("\n\n ------plugin info start:------\n plugin config url = ").append(XWalkEnvironment.getPluginConfigUrl()).append("\n plugin config period(minutes) = ").append(XWalkEnvironment.getPluginUpdatePeriod() / 60000).append("\n\n plugin version:");
        localObject5 = com.tencent.xweb.xwalk.a.h.hvo().iterator();
        Object localObject6;
        while (((Iterator)localObject5).hasNext())
        {
          localObject6 = (com.tencent.xweb.xwalk.a.g)((Iterator)localObject5).next();
          if (localObject6 != null) {
            ((StringBuilder)localObject3).append("\n ").append(((com.tencent.xweb.xwalk.a.g)localObject6).getPluginName()).append(" = ").append(((com.tencent.xweb.xwalk.a.g)localObject6).hvk());
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
          if (y.hsF() != null)
          {
            ((StringBuilder)localObject3).append("\n disable cache = ").append(y.hsF().hsG());
            ((StringBuilder)localObject3).append("\n disable crash detect = ").append(y.hsF().hsH());
          }
          ((StringBuilder)localObject3).append(huR()).append("\n\n ------plugin info end:------");
          localObject6 = (String)localObject1 + ((StringBuilder)localObject3).toString();
          localObject5 = "";
          localObject1 = localObject5;
          try
          {
            SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            localObject3 = localObject5;
            localObject1 = localObject5;
            if (Scheduler.Ev(false).hvz())
            {
              localObject1 = localObject5;
              String str = localSimpleDateFormat.format(new Date(Scheduler.Ev(false).hvJ().SJf));
              localObject1 = localObject5;
              localObject3 = "" + "going to update to apk ver = " + Scheduler.Ev(false).hvJ().version;
              localObject1 = localObject3;
              localObject3 = (String)localObject3 + "\n update time is = " + str;
              localObject1 = localObject3;
              localObject3 = (String)localObject3 + "\n is patch update = " + Scheduler.Ev(false).hvJ().SJc;
              localObject1 = localObject3;
              localObject3 = (String)localObject3 + "\n can use cellular = " + Scheduler.Ev(false).hvJ().SIE;
              localObject1 = localObject3;
              localObject3 = (String)localObject3 + "\n updateHourStart = " + Scheduler.Ev(false).hvJ().SJj;
              localObject1 = localObject3;
              localObject3 = (String)localObject3 + "\n updateHourEnd = " + Scheduler.Ev(false).hvJ().SJk;
              localObject1 = localObject3;
              localObject3 = (String)localObject3 + "\n versionId = " + Scheduler.Ev(false).hvJ().SIv;
              localObject1 = localObject3;
              localObject3 = (String)localObject3 + "\n update time is = " + str;
              localObject1 = localObject3;
              localObject3 = (String)localObject3 + "\n try count = " + Scheduler.Ev(false).hvJ().SJh;
              localObject1 = localObject3;
              localObject3 = (String)localObject3 + "\n try use shared core count = " + Scheduler.Ev(false).hvJ().SJi;
              localObject1 = localObject3;
              localObject3 = (String)localObject3 + "\n";
            }
            localObject1 = localObject3;
            localObject5 = new Date(Scheduler.Ev(false).hvJ().SJa);
            localObject1 = localObject3;
            localObject3 = (String)localObject3 + " last fetch config time = " + localSimpleDateFormat.format((Date)localObject5);
            localObject1 = localObject3;
            localObject3 = (String)localObject3 + " last fetch config abi = " + Scheduler.Ev(false).hvJ().SJb;
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
          this.SFU.setText((CharSequence)localObject3);
          AppMethodBeat.o(154230);
          return;
          ((StringBuilder)localObject3).append("\n null\n");
        }
      }
    }
  }
  
  final void huO()
  {
    AppMethodBeat.i(154231);
    if ((!y.hsF().SzT) && ((!y.hsF().SzU) || (this.SFP.getWebCoreType() != WebView.c.SAu)))
    {
      AppMethodBeat.o(154231);
      return;
    }
    if (this.SFT != null)
    {
      AppMethodBeat.o(154231);
      return;
    }
    this.SFT = new TextView(this.SzQ);
    this.SFT.setOnLongClickListener(new d.23(this));
    huP();
    this.SFP.getTopView().addView(this.SFT);
    AppMethodBeat.o(154231);
  }
  
  final boolean huQ()
  {
    AppMethodBeat.i(154235);
    b(this.SFP);
    if (this.SFW != null)
    {
      this.SFW.setVisibility(0);
      AppMethodBeat.o(154235);
      return true;
    }
    this.SFW = ((LayoutInflater)this.SzQ.getSystemService("layout_inflater")).inflate(2131493816, this.SFP.getTopView(), true).findViewById(2131309868);
    ((Button)this.SFW.findViewById(2131297911)).setOnClickListener(new d.34(this));
    Object localObject1 = (CheckBox)this.SFW.findViewById(2131298651);
    ((CheckBox)localObject1).setChecked(y.hsF().SzT);
    ((CheckBox)localObject1).setOnCheckedChangeListener(new d.45(this));
    ((TextView)this.SFW.findViewById(2131298631)).setOnClickListener(new d.52(this, (CheckBox)localObject1));
    localObject1 = (EditText)this.SFW.findViewById(2131309560);
    if (localObject1 != null)
    {
      ((EditText)localObject1).setInputType(2);
      ((EditText)localObject1).setText(XWalkEnvironment.getGrayValue());
      ((EditText)localObject1).addTextChangedListener(new d.53(this, (EditText)localObject1));
    }
    ((Spinner)this.SFW.findViewById(2131307575)).setOnItemSelectedListener(new d.54(this));
    ((RadioGroup)this.SFW.findViewById(2131310379)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(RadioGroup paramAnonymousRadioGroup, int paramAnonymousInt)
      {
        AppMethodBeat.i(154215);
        if (d.this.SFX)
        {
          AppMethodBeat.o(154215);
          return;
        }
        paramAnonymousRadioGroup = WebView.c.SAs;
        if (paramAnonymousInt == 2131296280) {
          paramAnonymousRadioGroup = WebView.c.SAs;
        }
        while (!d.this.SFY.equals("all"))
        {
          y.hsF().a(d.this.SFY, paramAnonymousRadioGroup);
          Log.d("WebDebugPage", "webview change to=".concat(String.valueOf(paramAnonymousRadioGroup)));
          AppMethodBeat.o(154215);
          return;
          if (paramAnonymousInt == 2131296283) {
            paramAnonymousRadioGroup = WebView.c.SAt;
          } else if (paramAnonymousInt == 2131296282) {
            paramAnonymousRadioGroup = WebView.c.SAu;
          } else if (paramAnonymousInt == 2131296281) {
            paramAnonymousRadioGroup = WebView.c.SAv;
          }
        }
        String[] arrayOfString = d.this.SzQ.getResources().getStringArray(2130903105);
        paramAnonymousInt = 0;
        while (paramAnonymousInt < arrayOfString.length)
        {
          y.hsF().a(arrayOfString[paramAnonymousInt], paramAnonymousRadioGroup);
          Log.d("WebDebugPage", "webview " + arrayOfString[paramAnonymousInt] + " change to=" + paramAnonymousRadioGroup);
          paramAnonymousInt += 1;
        }
        AppMethodBeat.o(154215);
      }
    });
    switch (51.SFs[y.hsF().SzZ.ordinal()])
    {
    default: 
      ((RadioGroup)this.SFW.findViewById(2131309657)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
      {
        public final void onCheckedChanged(RadioGroup paramAnonymousRadioGroup, int paramAnonymousInt)
        {
          AppMethodBeat.i(154153);
          paramAnonymousRadioGroup = JsRuntime.JsRuntimeType.Szv;
          if (paramAnonymousInt == 2131309654) {
            paramAnonymousRadioGroup = JsRuntime.JsRuntimeType.Szv;
          }
          for (;;)
          {
            y.hsF().a(paramAnonymousRadioGroup);
            Log.d("WebDebugPage", "v8 type change to=".concat(String.valueOf(paramAnonymousRadioGroup)));
            AppMethodBeat.o(154153);
            return;
            if (paramAnonymousInt == 2131309658) {
              paramAnonymousRadioGroup = JsRuntime.JsRuntimeType.Szw;
            } else if (paramAnonymousInt == 2131309659) {
              paramAnonymousRadioGroup = JsRuntime.JsRuntimeType.SzA;
            } else if (paramAnonymousInt == 2131309656) {
              paramAnonymousRadioGroup = JsRuntime.JsRuntimeType.SzC;
            } else if (paramAnonymousInt == 2131309655) {
              paramAnonymousRadioGroup = JsRuntime.JsRuntimeType.SzD;
            }
          }
        }
      });
      ((Button)this.SFW.findViewById(2131297919)).setOnClickListener(new d.3(this));
      localObject1 = (Button)this.SFW.findViewById(2131297831);
      a(y.hsF().SzS, (Button)localObject1, false);
      ((Button)localObject1).setOnClickListener(new d.4(this, (Button)localObject1));
      ((Button)this.SFW.findViewById(2131297908)).setOnClickListener(new d.5(this));
      ((Button)this.SFW.findViewById(2131297932)).setOnClickListener(new d.6(this));
      ((Button)this.SFW.findViewById(2131297922)).setOnClickListener(new d.7(this));
      localObject1 = (Button)this.SFW.findViewById(2131297913);
      if ((this.SFP.isXWalkKernel()) && (XWalkEnvironment.isCurrentVersionSupportForceDarkMode()))
      {
        ((Button)localObject1).setVisibility(0);
        label502:
        f((Button)localObject1);
        ((Button)localObject1).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(154159);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/xweb/xwalk/WebDebugPage$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
            paramAnonymousView = d.this;
            localObject = this.SGh;
            int i = paramAnonymousView.SFP.getSettings().getForceDarkMode();
            int j = paramAnonymousView.SFP.getSettings().getForceDarkBehavior();
            if ((i != 0) && (i == 2)) {
              if (j == 2) {
                paramAnonymousView.SFP.getSettings().setForceDarkBehavior(1);
              }
            }
            for (;;)
            {
              paramAnonymousView.f((Button)localObject);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(154159);
              return;
              if (j == 1)
              {
                paramAnonymousView.SFP.getSettings().setForceDarkMode(0);
              }
              else if (j == 0)
              {
                paramAnonymousView.SFP.getSettings().setForceDarkMode(0);
              }
              else
              {
                paramAnonymousView.SFP.getSettings().setForceDarkMode(2);
                paramAnonymousView.SFP.getSettings().setForceDarkBehavior(2);
              }
            }
          }
        });
        Object localObject2 = (Button)this.SFW.findViewById(2131297912);
        localObject1 = XWalkEnvironment.getXWalkUpdateConfigUrl();
        localObject1 = ((String)localObject1).substring(((String)localObject1).lastIndexOf('/') + 1);
        localObject1 = "(当前为" + (String)localObject1 + ")";
        if (!y.hsF().SAa) {
          break label1594;
        }
        localObject1 = "使用正式版config".concat(String.valueOf(localObject1));
        label595:
        ((Button)localObject2).setText((CharSequence)localObject1);
        ((Button)localObject2).setOnClickListener(new d.9(this, (Button)localObject2));
        ((Button)this.SFW.findViewById(2131297935)).setOnClickListener(new d.10(this));
        localObject1 = (LinearLayout)this.SFW.findViewById(2131305984);
        ((LinearLayout)localObject1).setVisibility(8);
        localObject2 = (Button)this.SFW.findViewById(2131297929);
        ((Button)localObject2).setText("插件设置");
        ((Button)localObject2).setOnClickListener(new d.11(this, (LinearLayout)localObject1));
        localObject1 = (Button)this.SFW.findViewById(2131297928);
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
      ((Button)localObject1).setOnClickListener(new d.13(this, (Button)localObject1));
      ((Button)this.SFW.findViewById(2131297936)).setOnClickListener(new d.14(this));
      ((Button)this.SFW.findViewById(2131297909)).setOnClickListener(new d.15(this));
      ((Spinner)this.SFW.findViewById(2131308334)).setOnItemSelectedListener(new d.16(this));
      ((Button)this.SFW.findViewById(2131297924)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(154169);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/xweb/xwalk/WebDebugPage$24", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          d.a(d.this.SzQ, d.this.SFQ, false, new ValueCallback() {});
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$24", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(154169);
        }
      });
      ((Button)this.SFW.findViewById(2131297925)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(154171);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/xweb/xwalk/WebDebugPage$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          d.a(d.this.SzQ, d.this.SFQ, true, new ValueCallback() {});
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(154171);
        }
      });
      ((Button)this.SFW.findViewById(2131297937)).setOnClickListener(new d.19(this));
      ((Button)this.SFW.findViewById(2131297910)).setOnClickListener(new d.20(this));
      localObject1 = (CheckBox)this.SFW.findViewById(2131298649);
      ((CheckBox)localObject1).setChecked(y.hsF().hsG());
      ((CheckBox)localObject1).setOnCheckedChangeListener(new d.21(this));
      localObject1 = (CheckBox)this.SFW.findViewById(2131298650);
      ((CheckBox)localObject1).setChecked(y.hsF().hsH());
      ((CheckBox)localObject1).setOnCheckedChangeListener(new d.22(this));
      ((TextView)this.SFW.findViewById(2131308997)).setText(huR());
      localObject1 = (EditText)this.SFW.findViewById(2131299841);
      ((Button)this.SFW.findViewById(2131297916)).setOnClickListener(new d.24(this, (EditText)localObject1));
      ((Button)this.SFW.findViewById(2131297915)).setOnClickListener(new d.25(this, (EditText)localObject1));
      ((Button)this.SFW.findViewById(2131297914)).setOnClickListener(new d.26(this, (EditText)localObject1));
      localObject1 = (EditText)this.SFW.findViewById(2131299844);
      ((Button)this.SFW.findViewById(2131297940)).setOnClickListener(new d.27(this, (EditText)localObject1));
      ((Button)this.SFW.findViewById(2131297938)).setOnClickListener(new d.28(this, (EditText)localObject1));
      ((Button)this.SFW.findViewById(2131297939)).setOnClickListener(new d.29(this, (EditText)localObject1));
      ((TextView)this.SFW.findViewById(2131309555)).setText(Er(true) + "\n" + XWalkInitializer.getXWalkInitializeLog());
      ((LinearLayout)this.SFW.findViewById(2131298987)).setVisibility(8);
      ((Button)this.SFW.findViewById(2131297907)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(154183);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/xweb/xwalk/WebDebugPage$36", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          XWalkEnvironment.setGrayValueForTest(1);
          if (!XWalkEnvironment.hasAvailableVersion()) {
            if (XWalkEnvironment.isIaDevice()) {
              d.this.bsn("http://debugxweb.qq.com/?set_web_config=WV_KIND_CW&set_appbrand_config=WV_KIND_CW&set_config_url=https://dldir1.qq.com/weixin/android/wxweb/updateConfig_x86_test.xml&check_xwalk_update");
            }
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$36", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(154183);
            return;
            d.this.bsn("http://debugxweb.qq.com/?set_web_config=WV_KIND_CW&set_appbrand_config=WV_KIND_CW&set_config_url=https://dldir1.qq.com/weixin/android/wxweb/updateConfig_test.xml&check_xwalk_update");
            continue;
            y.hsF().a("tools", WebView.c.SAt);
            y.hsF().a("toolsmp", WebView.c.SAt);
            y.hsF().a("appbrand", WebView.c.SAt);
            y.hsF().a("support", WebView.c.SAt);
            y.hsF().a("mm", WebView.c.SAt);
            d.this.dR("已使用XWeb，点任意位置重启进程生效\n", true);
          }
        }
      });
      ((Button)this.SFW.findViewById(2131297906)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(154184);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/xweb/xwalk/WebDebugPage$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          y.hsF().a("tools", WebView.c.SAu);
          y.hsF().a("toolsmp", WebView.c.SAu);
          y.hsF().a("appbrand", WebView.c.SAu);
          y.hsF().a("support", WebView.c.SAu);
          y.hsF().a("mm", WebView.c.SAu);
          if (com.tencent.xweb.WebView.getInstalledTbsCoreVersion(d.this.SzQ) <= 0) {
            d.this.dQ("已切换x5，但是x5未ready，点任意位置重启进程生效\n", true);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(154184);
            return;
            d.this.dR("已使用x5，点任意位置重启进程生效\n", true);
          }
        }
      });
      ((Button)this.SFW.findViewById(2131297905)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(154185);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/xweb/xwalk/WebDebugPage$38", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          y.hsF().a("tools", WebView.c.SAv);
          y.hsF().a("toolsmp", WebView.c.SAv);
          y.hsF().a("appbrand", WebView.c.SAv);
          y.hsF().a("support", WebView.c.SAv);
          y.hsF().a("mm", WebView.c.SAv);
          d.this.dR("已使用system，点任意位置重启进程生效\n", true);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$38", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(154185);
        }
      });
      ((Button)this.SFW.findViewById(2131297904)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(154186);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/xweb/xwalk/WebDebugPage$39", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          XWalkEnvironment.setGrayValueForTest(0);
          XWalkEnvironment.setTestDownLoadUrl(d.this.SzQ, "");
          y.hsF().a("tools", WebView.c.SAs);
          y.hsF().a("toolsmp", WebView.c.SAs);
          y.hsF().a("appbrand", WebView.c.SAs);
          y.hsF().a("support", WebView.c.SAs);
          y.hsF().a("mm", WebView.c.SAs);
          d.this.dR("已使用AUTO，点任意位置重启进程生效\n", true);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$39", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(154186);
        }
      });
      ((Button)this.SFW.findViewById(2131297901)).setOnClickListener(new d.35(this));
      ((Button)this.SFW.findViewById(2131297933)).setOnClickListener(new d.36(this));
      localObject1 = (Button)this.SFW.findViewById(2131297923);
      ((Button)localObject1).setOnClickListener(new d.37(this));
      ((Button)this.SFW.findViewById(2131297934)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(207251);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/xweb/xwalk/WebDebugPage$43", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          boolean bool;
          if (!y.hsF().SAb)
          {
            bool = true;
            y.hsF().setShowFps(bool);
            d.b(d.this.SFP);
            if (!bool) {
              break label101;
            }
          }
          label101:
          for (paramAnonymousView = "打开显示fps";; paramAnonymousView = "关闭显示fps")
          {
            d.this.dR(paramAnonymousView, false);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$43", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(207251);
            return;
            bool = false;
            break;
          }
        }
      });
      ((Button)localObject1).setOnLongClickListener(new d.39(this));
      ((Button)this.SFW.findViewById(2131297926)).setOnClickListener(this.SGd);
      AppMethodBeat.o(154235);
      return true;
      ((RadioButton)this.SFW.findViewById(2131309654)).setChecked(true);
      break;
      ((RadioButton)this.SFW.findViewById(2131309658)).setChecked(true);
      break;
      ((RadioButton)this.SFW.findViewById(2131309659)).setChecked(true);
      break;
      ((RadioButton)this.SFW.findViewById(2131309656)).setChecked(true);
      break;
      ((RadioButton)this.SFW.findViewById(2131309655)).setChecked(true);
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
  
  final void huS()
  {
    AppMethodBeat.i(207283);
    Object localObject = com.tencent.xweb.xwalk.a.h.hvo().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((com.tencent.xweb.xwalk.a.g)((Iterator)localObject).next()).atc(-1);
    }
    localObject = XWalkEnvironment.getPluginBaseDir();
    if (((String)localObject).isEmpty())
    {
      AppMethodBeat.o(207283);
      return;
    }
    com.tencent.xweb.util.c.bsB((String)localObject);
    dQ("所有插件清理完成", true);
    AppMethodBeat.o(207283);
  }
  
  final void huT()
  {
    AppMethodBeat.i(154241);
    Scheduler.SIT = true;
    Scheduler.hvD();
    new c(this.SzQ).C(null);
    AppMethodBeat.o(154241);
  }
  
  final void m(WebView.c paramc)
  {
    AppMethodBeat.i(154234);
    switch (51.nXl[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(154234);
      return;
      ((RadioButton)this.SFW.findViewById(2131296280)).setChecked(true);
      AppMethodBeat.o(154234);
      return;
      ((RadioButton)this.SFW.findViewById(2131296283)).setChecked(true);
      AppMethodBeat.o(154234);
      return;
      ((RadioButton)this.SFW.findViewById(2131296282)).setChecked(true);
      AppMethodBeat.o(154234);
      return;
      ((RadioButton)this.SFW.findViewById(2131296281)).setChecked(true);
    }
  }
  
  static final class a
    implements s.a
  {
    boolean SGM;
    private ProgressDialog SGr;
    Context mContext;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(207275);
      this.SGM = false;
      this.mContext = paramContext;
      s.a(this);
      bsO("正在监听更新,点空白区域取消");
      AppMethodBeat.o(207275);
    }
    
    private void bsO(String paramString)
    {
      AppMethodBeat.i(207281);
      if (this.SGr == null)
      {
        this.SGr = new ProgressDialog(this.mContext);
        this.SGr.setProgressStyle(1);
        this.SGr.setMessage(paramString);
        this.SGr.setOnCancelListener(new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(207274);
            s.b(d.a.this);
            if (d.a.this.SGM) {
              d.iH(d.a.this.mContext);
            }
            AppMethodBeat.o(207274);
          }
        });
        this.SGr.setCancelable(true);
        this.SGr.show();
      }
      this.SGr.setMessage(paramString);
      AppMethodBeat.o(207281);
    }
    
    public final void AN(int paramInt)
    {
      AppMethodBeat.i(207277);
      if (paramInt == 0) {}
      try
      {
        bsO("更新完成，点任意位置重启进程生效");
        this.SGM = true;
        this.SGr.setCancelable(true);
        this.SGr.setCanceledOnTouchOutside(true);
        this.SGr.setProgress(100);
        AppMethodBeat.o(207277);
        return;
      }
      catch (Exception localException)
      {
        Log.i("WebDebugPage", "may run in background failed to load alert:" + localException.getMessage());
        AppMethodBeat.o(207277);
        return;
      }
      if (paramInt == -5)
      {
        bsO("暂无需要立即更新的版本");
        this.SGr.setCancelable(true);
        this.SGr.setCanceledOnTouchOutside(true);
        AppMethodBeat.o(207277);
        return;
      }
      this.SGr.setCancelable(true);
      this.SGr.setCanceledOnTouchOutside(true);
      bsO("更新失败, error code = :".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(207277);
    }
    
    public final void AO(int paramInt)
    {
      AppMethodBeat.i(207278);
      try
      {
        bsO("正在下载内核");
        if (this.SGr != null)
        {
          this.SGr.setCancelable(false);
          this.SGr.setProgress(paramInt);
        }
        AppMethodBeat.o(207278);
        return;
      }
      catch (Exception localException)
      {
        Log.i("WebDebugPage", "may run in background failed to load alert:" + localException.getMessage());
        AppMethodBeat.o(207278);
      }
    }
    
    public final void cdG()
    {
      AppMethodBeat.i(207276);
      bsO("开始更新");
      AppMethodBeat.o(207276);
    }
    
    public final void cdH()
    {
      AppMethodBeat.i(207279);
      bsO("主配置更新完成");
      AppMethodBeat.o(207279);
    }
    
    public final void cdI()
    {
      AppMethodBeat.i(207280);
      bsO("插件配置更新完成");
      AppMethodBeat.o(207280);
    }
  }
  
  static final class b
    extends XWalkUpdater.UpdateConfig
  {
    String SGO;
    
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
      this.SGO = paramString1;
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
      AppMethodBeat.i(207282);
      new d.a(d.this.SzQ);
      AppMethodBeat.o(207282);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d
 * JD-Core Version:    0.7.0.1
 */