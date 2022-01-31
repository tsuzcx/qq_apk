package com.tencent.xweb.xwalk;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView.d;
import com.tencent.xweb.ab;
import com.tencent.xweb.c.l;
import com.tencent.xweb.c.l.a;
import com.tencent.xweb.k;
import com.tencent.xweb.k.a;
import com.tencent.xweb.q;
import com.tencent.xweb.util.b;
import com.tencent.xweb.xwalk.a.g;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
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

public final class c
  implements com.tencent.xweb.c.e
{
  Context BDH;
  com.tencent.xweb.WebView BID;
  ScrollView BIE;
  TextView BIF;
  TextView BIH;
  TextView BII;
  Button BIJ;
  View BIK;
  boolean BIL;
  String BIM;
  private View.OnClickListener BIN;
  
  public c(com.tencent.xweb.WebView paramWebView)
  {
    AppMethodBeat.i(85182);
    this.BIE = null;
    this.BIF = null;
    this.BIH = null;
    this.BII = null;
    this.BIJ = null;
    this.BIL = false;
    this.BIM = "tools";
    this.BIN = new c.35(this);
    this.BDH = paramWebView.getContext();
    this.BID = paramWebView;
    dZZ();
    dZX();
    AppMethodBeat.o(85182);
  }
  
  /* Error */
  public static void a(com.tencent.xweb.c.i parami)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 98
    //   5: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: ifnull +12 -> 21
    //   12: invokestatic 104	com/tencent/xweb/q:dYn	()Lcom/tencent/xweb/q;
    //   15: getfield 107	com/tencent/xweb/q:BDS	Z
    //   18: ifne +12 -> 30
    //   21: ldc 98
    //   23: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: ldc 2
    //   28: monitorexit
    //   29: return
    //   30: aload_0
    //   31: invokestatic 110	com/tencent/xweb/xwalk/c:b	(Lcom/tencent/xweb/c/i;)V
    //   34: ldc 98
    //   36: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   39: goto -13 -> 26
    //   42: astore_0
    //   43: ldc 2
    //   45: monitorexit
    //   46: aload_0
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	parami	com.tencent.xweb.c.i
    // Exception table:
    //   from	to	target	type
    //   3	8	42	finally
    //   12	21	42	finally
    //   21	26	42	finally
    //   30	39	42	finally
  }
  
  private static String adA(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(85185);
    try
    {
      paramString = MessageDigest.getInstance("MD5").digest(paramString.getBytes());
      if ((paramString == null) || (paramString.length == 0))
      {
        AppMethodBeat.o(85185);
        return "";
      }
      StringBuilder localStringBuilder = new StringBuilder(paramString.length);
      int j = paramString.length;
      while (i < j)
      {
        String str = Integer.toHexString(paramString[i] & 0xFF);
        if (str.length() == 1) {
          localStringBuilder.append(0);
        }
        localStringBuilder.append(str);
        i += 1;
      }
      paramString = localStringBuilder.toString().toUpperCase();
      AppMethodBeat.o(85185);
      return paramString;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(85185);
    }
    return "";
  }
  
  private void ayn(String paramString)
  {
    AppMethodBeat.i(85195);
    File localFile = new File(paramString);
    if (localFile.isDirectory())
    {
      String[] arrayOfString = localFile.list();
      if (arrayOfString != null)
      {
        int i = 0;
        while (i < arrayOfString.length)
        {
          ayn(paramString + "//" + arrayOfString[i]);
          i += 1;
        }
      }
    }
    localFile.delete();
    AppMethodBeat.o(85195);
  }
  
  public static boolean ayo(String paramString)
  {
    int i = 99999;
    AppMethodBeat.i(139582);
    com.tencent.xweb.xwalk.a.c localc = com.tencent.xweb.xwalk.a.e.ayq("XFilesPPTReader");
    if (localc == null)
    {
      AppMethodBeat.o(139582);
      return false;
    }
    try
    {
      if (localc.BKm >= 99999) {
        i = localc.BKm + 1;
      }
      com.tencent.xweb.xwalk.a.d locald = new com.tencent.xweb.xwalk.a.d();
      locald.version = i;
      locald.isPatch = false;
      locald.cqq = com.tencent.xweb.util.d.getMD5(paramString);
      locald.path = localc.aP(i, false);
      locald.BKp = true;
      b.copyFile(paramString, locald.path);
      if (localc.a(locald) == 0)
      {
        AppMethodBeat.o(139582);
        return true;
      }
      AppMethodBeat.o(139582);
      return false;
    }
    catch (Exception paramString)
    {
      Log.e("WebDebugPage", "loadPPTReaderFromLocalInternal error: " + paramString.getMessage());
      AppMethodBeat.o(139582);
    }
    return false;
  }
  
  /* Error */
  public static void b(com.tencent.xweb.c.i parami)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 359
    //   6: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: ifnull +12 -> 22
    //   13: invokestatic 104	com/tencent/xweb/q:dYn	()Lcom/tencent/xweb/q;
    //   16: getfield 107	com/tencent/xweb/q:BDS	Z
    //   19: ifne +13 -> 32
    //   22: ldc_w 359
    //   25: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: ldc 2
    //   30: monitorexit
    //   31: return
    //   32: aload_0
    //   33: ldc_w 361
    //   36: new 363	com/tencent/xweb/xwalk/c$46
    //   39: dup
    //   40: invokespecial 364	com/tencent/xweb/xwalk/c$46:<init>	()V
    //   43: invokeinterface 370 3 0
    //   48: ldc_w 359
    //   51: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   54: goto -26 -> 28
    //   57: astore_0
    //   58: ldc 2
    //   60: monitorexit
    //   61: aload_0
    //   62: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	63	0	parami	com.tencent.xweb.c.i
    // Exception table:
    //   from	to	target	type
    //   3	9	57	finally
    //   13	22	57	finally
    //   22	28	57	finally
    //   32	54	57	finally
  }
  
  private boolean cy(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(85186);
    Object localObject1;
    if ((paramString.contains("debugxweb.qq.com")) || (paramBoolean))
    {
      paramString = Uri.parse(paramString);
      localObject1 = paramString.getQueryParameterNames();
      if ((localObject1 == null) || (((Set)localObject1).size() == 0))
      {
        eab();
        AppMethodBeat.o(85186);
        return true;
      }
      localObject1 = ((Set)localObject1).iterator();
    }
    for (;;)
    {
      label240:
      int i;
      if (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (String)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          switch (((String)localObject2).hashCode())
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
              sk(false);
              break;
              if (!((String)localObject2).equals("load_local_xwalk")) {
                break label240;
              }
              i = 0;
              continue;
              if (!((String)localObject2).equals("set_web_config")) {
                break label240;
              }
              i = 1;
              continue;
              if (!((String)localObject2).equals("set_appbrand_config")) {
                break label240;
              }
              i = 2;
              continue;
              if (!((String)localObject2).equals("show_webview_version")) {
                break label240;
              }
              i = 3;
              continue;
              if (!((String)localObject2).equals("clear_commands")) {
                break label240;
              }
              i = 4;
              continue;
              if (!((String)localObject2).equals("set_config_url")) {
                break label240;
              }
              i = 5;
              continue;
              if (!((String)localObject2).equals("check_xwalk_update")) {
                break label240;
              }
              i = 6;
              continue;
              if (!((String)localObject2).equals("check_plugin_update")) {
                break label240;
              }
              i = 7;
              continue;
              if (!((String)localObject2).equals("wait_debugger")) {
                break label240;
              }
              i = 8;
              continue;
              if (!((String)localObject2).equals("debug_process")) {
                break label240;
              }
              i = 9;
              continue;
              if (!((String)localObject2).equals("set_apkver")) {
                break label240;
              }
              i = 10;
              continue;
              if (!((String)localObject2).equals("check_files")) {
                break label240;
              }
              i = 11;
              continue;
              if (!((String)localObject2).equals("set_plugin_config_url")) {
                break label240;
              }
              i = 12;
              continue;
              if (!((String)localObject2).equals("revert_to_apk")) {
                break label240;
              }
              i = 13;
              continue;
              if (!((String)localObject2).equals("set_config_peroid")) {
                break label240;
              }
              i = 14;
              continue;
              if (!((String)localObject2).equals("recheck_cmds")) {
                break label240;
              }
              i = 15;
            }
          }
          try
          {
            localObject2 = WebView.d.valueOf(paramString.getQueryParameter("set_web_config"));
            q.dYn().a("tools", (WebView.d)localObject2);
            q.dYn().a("toolsmp", (WebView.d)localObject2);
            cz("打开网页将使用:".concat(String.valueOf(localObject2)), true);
          }
          catch (Exception localException1) {}
        }
      }
      else
      {
        try
        {
          Object localObject3 = WebView.d.valueOf(paramString.getQueryParameter("set_appbrand_config"));
          q.dYn().a("appbrand", (WebView.d)localObject3);
          q.dYn().a("support", (WebView.d)localObject3);
          switch (c.47.iPi[localObject3.ordinal()])
          {
          case 1: 
            q.dYn().a(k.a.BDw);
            cz("打开小程序将使用:".concat(String.valueOf(localObject3)), true);
            break;
          case 2: 
            q.dYn().a(k.a.BDt);
            cz("打开小程序将使用:".concat(String.valueOf(localObject3)), true);
            break;
          case 3: 
            q.dYn().a(k.a.BDw);
            cz("打开小程序将使用:".concat(String.valueOf(localObject3)), true);
            continue;
            if (this.BII == null)
            {
              localObject3 = new ScrollView(this.BDH);
              this.BII = new TextView(this.BDH);
              this.BII.setBackgroundColor(-1);
              ((ScrollView)localObject3).addView(this.BII);
              this.BII.setOnClickListener(new c.12(this));
              dZY();
              this.BID.getTopView().addView((View)localObject3);
              continue;
              com.tencent.xweb.a.a(null, "0");
              continue;
              try
              {
                localObject3 = paramString.getQueryParameter("set_config_url");
                XWalkEnvironment.setTestDownLoadUrl(this.BDH, (String)localObject3);
                cz("测试连接设置为:".concat(String.valueOf(localObject3)), true);
              }
              catch (Exception localException2)
              {
                cz("测试连接设置失败，格式错误", true);
              }
              continue;
              eae();
              continue;
              ead();
              continue;
              paramBoolean = paramString.getBooleanQueryParameter("wait_debugger", false);
              Object localObject4 = q.dYn();
              ((q)localObject4).BDO = paramBoolean;
              ((q)localObject4).BDH.getSharedPreferences("wcwebview", 0).edit().putBoolean("bWaitforDebugger", paramBoolean).commit();
              continue;
              localObject4 = paramString.getQueryParameter("debug_process");
              q.dYn().BDH.getSharedPreferences("wcwebview", 4).edit().putString("strDebugProcess", (String)localObject4).commit();
              continue;
              localObject4 = paramString.getQueryParameter("set_apkver");
              try
              {
                XWalkEnvironment.setAvailableVersion(Integer.parseInt((String)localObject4), "1.0.".concat(String.valueOf(localObject4)));
                cA("版本号设置到:" + (String)localObject4 + " 点击空白处退出重启进程", true);
              }
              catch (Exception localException3)
              {
                cz("设置版本号失败:" + localException3.getMessage(), true);
              }
              continue;
              n.sl(true);
              continue;
              try
              {
                String str1 = paramString.getQueryParameter("set_plugin_config_url");
                XWalkEnvironment.setPluginTestConfigUrl(str1);
                cz("插件测试连接设置为:".concat(String.valueOf(str1)), true);
              }
              catch (Exception localException4)
              {
                cz("插件测试连接设置失败，格式错误", true);
              }
              continue;
              String str2 = paramString.getQueryParameter("revert_to_apk");
              try
              {
                i = n.aH(XWalkEnvironment.getApplicationContext(), Integer.parseInt(str2));
                cA("版本号回滚到:" + i + " 点击空白处退出重启进程", true);
              }
              catch (Exception localException5)
              {
                cz("版本号回滚到失败:" + localException5.getMessage(), true);
              }
              continue;
              String str3 = paramString.getQueryParameter("set_config_peroid");
              try
              {
                com.tencent.xweb.a.Ty(Integer.parseInt(str3));
                cA("设置配置拉取周期为:" + str3 + "分钟", false);
              }
              catch (Exception localException6)
              {
                cz("设置配置拉取周期失败:" + localException6.getMessage(), true);
              }
              continue;
              l.e(WebView.d.BEq).excute("STR_CMD_SET_RECHECK_COMMAND", null);
              cA("重新跑了一遍命令配置 点击空白处退出重启进程", true);
              continue;
              AppMethodBeat.o(85186);
              return true;
              AppMethodBeat.o(85186);
              return false;
            }
            break;
          }
        }
        catch (Exception localException7) {}
      }
    }
  }
  
  private void eaa()
  {
    AppMethodBeat.i(85191);
    if (this.BIH == null)
    {
      AppMethodBeat.o(85191);
      return;
    }
    String str = sj(false);
    this.BIH.setText(str);
    AppMethodBeat.o(85191);
  }
  
  private static String eac()
  {
    AppMethodBeat.i(85194);
    Object localObject = new StringBuilder("文件预览服务设置：\n");
    String[] arrayOfString = com.tencent.xweb.d.BCY;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      ((StringBuilder)localObject).append(str).append(": force-").append(q.dYn().axX(str)).append("  cmd-").append(com.tencent.xweb.a.axK(str)).append("\n");
      i += 1;
    }
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(85194);
    return localObject;
  }
  
  protected static void ge(Context paramContext)
  {
    AppMethodBeat.i(85198);
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
    AppMethodBeat.o(85198);
  }
  
  final void G(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(85202);
    c.a locala = new c.a(paramString1, paramString2);
    try
    {
      Object localObject = new File(XWalkEnvironment.getDownloadZipDir(locala.apkVer));
      if (((File)localObject).exists()) {
        ((File)localObject).delete();
      }
      paramString1 = new FileInputStream(paramString1);
      localObject = new FileOutputStream((File)localObject);
      byte[] arrayOfByte = new byte[1048576];
      for (;;)
      {
        int i = paramString1.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        ((FileOutputStream)localObject).write(arrayOfByte, 0, i);
      }
      cz("安装" + paramString2 + "失败,错误码=" + paramString1, true);
    }
    catch (IOException paramString1)
    {
      for (;;)
      {
        paramString1 = XWalkUpdater.onHandleFile(locala);
        if (paramString1.intValue() != 0) {
          break;
        }
        cz("安装" + paramString2 + "成功", paramBoolean);
        AppMethodBeat.o(85202);
        return;
        ((FileOutputStream)localObject).flush();
        paramString1.close();
        ((FileOutputStream)localObject).close();
      }
    }
    catch (Exception paramString1)
    {
      cz("安装失败", true);
      Log.e("WebDebugPage", "install local apk failed : " + paramString1.getMessage());
      AppMethodBeat.o(85202);
      return;
    }
    AppMethodBeat.o(85202);
  }
  
  public final void a(boolean paramBoolean1, Button paramButton, boolean paramBoolean2)
  {
    AppMethodBeat.i(85199);
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
          if ((paramBoolean2) && (this.BID.getX5WebViewExtension() != null))
          {
            if (!paramBoolean1) {
              break label79;
            }
            this.BID.loadUrl("http://debugx5.qq.com/?inspector=true");
          }
          while (paramButton != null) {
            if (paramBoolean1)
            {
              paramButton.setText("关闭远程调试模式");
              AppMethodBeat.o(85199);
              return;
              label79:
              this.BID.loadUrl("http://debugx5.qq.com/?inspector=false");
            }
            else
            {
              paramButton.setText("打开远程调试模式");
            }
          }
          AppMethodBeat.o(85199);
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
  
  final void aAd()
  {
    AppMethodBeat.i(85197);
    ge(this.BDH);
    AppMethodBeat.o(85197);
  }
  
  public final boolean axY(String paramString)
  {
    boolean bool4 = false;
    AppMethodBeat.i(85184);
    if (paramString == null)
    {
      AppMethodBeat.o(85184);
      return false;
    }
    Object localObject1;
    Object localObject2;
    boolean bool1;
    String str1;
    int i;
    if ((paramString.contains("debugmm.qq.com")) || (paramString.contains("debugxweb.qq.com")))
    {
      localObject1 = Uri.parse(paramString);
      localObject2 = ((Uri)localObject1).getQueryParameterNames();
      if ((localObject2 != null) && (((Set)localObject2).size() > 0))
      {
        localObject2 = ((Set)localObject2).iterator();
        bool1 = false;
        for (;;)
        {
          bool2 = bool1;
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          str1 = (String)((Iterator)localObject2).next();
          if (str1 != null) {
            switch (str1.hashCode())
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
                  q.dYn().a("tools", WebView.d.BEr);
                  q.dYn().a("appbrand", WebView.d.BEr);
                  q.dYn().a("support", WebView.d.BEr);
                  q.dYn().a("mm", WebView.d.BEr);
                  q.dYn().a("toolsmp", WebView.d.BEr);
                  q.dYn().a(k.a.BDt);
                  cA("force use x5 switch is on ", true);
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
              for (;;)
              {
                label186:
                AppMethodBeat.o(85184);
                return true;
                if (!str1.equals("forcex5")) {
                  break;
                }
                i = 0;
                break label186;
                if (!str1.equals("inspector")) {
                  break;
                }
                i = 1;
                break label186;
                if (!str1.equals("ticket")) {
                  break;
                }
                i = 2;
                break label186;
                if (!str1.equals("show_x5_ver")) {
                  break;
                }
                i = 3;
                break label186;
                if (!str1.equals("encrpt_url")) {
                  break;
                }
                i = 4;
                break label186;
                if (!str1.equals("clear_test_setting")) {
                  break;
                }
                i = 5;
                break label186;
                if (!str1.equals("show_fps")) {
                  break;
                }
                i = 6;
                break label186;
                q.dYn().a("tools", WebView.d.BEp);
                q.dYn().a("appbrand", WebView.d.BEp);
                q.dYn().a("support", WebView.d.BEp);
                q.dYn().a("mm", WebView.d.BEp);
                q.dYn().a("toolsmp", WebView.d.BEp);
                q.dYn().a(k.a.BDo);
                cA("force use x5 switch is off ", true);
              }
              bool1 = ((Uri)localObject1).getBooleanQueryParameter("inspector", false);
              q.dYn().sd(bool1);
              a(bool1, null, true);
              AppMethodBeat.o(85184);
              return true;
              str1 = ((Uri)localObject1).getQueryParameter("ticket");
              String str2 = ((Uri)localObject1).toString();
              if ((TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str1))) {
                bool1 = false;
              }
              for (;;)
              {
                if (bool1) {
                  break label723;
                }
                cz("权限校验失败", true);
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
                  bool1 = str1.equalsIgnoreCase(adA((str2 + "@check_permission@" + str3).toLowerCase()));
                }
              }
              label723:
              Log.i("WebDebugPage", "checkTempPerssion suc");
            }
          }
        }
        bool1 = ((Uri)localObject1).getBooleanQueryParameter("show_x5_ver", false);
        paramString = q.dYn();
        if (bool1 != paramString.BDL)
        {
          paramString.BDL = bool1;
          paramString.BDH.getSharedPreferences("wcwebview", 0).edit().putBoolean("bShowX5Version", paramString.BDL).commit();
        }
        if (bool1) {
          cz("开启显示x5内核信息", true);
        }
        for (;;)
        {
          AppMethodBeat.o(85184);
          return true;
          cz("关闭显示x5内核信息", true);
        }
        paramString = ((Uri)localObject1).getQueryParameter("encrpt_url");
        try
        {
          paramString = com.tencent.xweb.util.a.a(paramString, com.tencent.xweb.util.a.ayd("b01d4598de5875eb9b86abdef32b811e9c55edcfb1673b5617cc0a6ab7dceaff"));
          if (TextUtils.isEmpty(paramString))
          {
            cz("解密失败", true);
            AppMethodBeat.o(85184);
            return true;
          }
          axY(paramString);
        }
        catch (Throwable paramString)
        {
          for (;;)
          {
            cz("解密失败", true);
          }
        }
        AppMethodBeat.o(85184);
        return true;
        n.jW(XWalkEnvironment.getApplicationContext());
        AppMethodBeat.o(85184);
        return true;
        bool1 = ((Uri)localObject1).getBooleanQueryParameter("show_fps", false);
        q.dYn().setShowFps(bool1);
        AppMethodBeat.o(85184);
        return true;
      }
    }
    boolean bool2 = false;
    if (paramString.contains("public.debugxweb.qq.com"))
    {
      paramString = Uri.parse(paramString);
      localObject1 = paramString.getQueryParameterNames();
      if ((localObject1 != null) && (((Set)localObject1).size() > 0))
      {
        localObject1 = ((Set)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          if (localObject2 != null)
          {
            switch (((String)localObject2).hashCode())
            {
            }
            label1040:
            for (i = -1;; i = 0) {
              switch (i)
              {
              default: 
                break;
              case 0: 
                localObject2 = q.dYn();
                bool1 = paramString.getBooleanQueryParameter("enable_local_debug", false);
                ((q)localObject2).BDH.getSharedPreferences("wcwebview", 4).edit().putBoolean("m_bEnableLocalDebug", bool1).commit();
                break;
                if (!((String)localObject2).equals("enable_local_debug")) {
                  break label1040;
                }
              }
            }
          }
        }
      }
      AppMethodBeat.o(85184);
      return true;
    }
    int k;
    if ((q.dYn().BDH.getSharedPreferences("wcwebview", 4).getBoolean("m_bEnableLocalDebug", false)) || (bool2)) {
      k = 1;
    }
    int j;
    for (;;)
    {
      if ((paramString.contains("debugxweb.qq.com")) || (bool2))
      {
        localObject1 = Uri.parse(paramString);
        localObject2 = ((Uri)localObject1).getQueryParameterNames();
        if ((localObject2 == null) || (((Set)localObject2).size() == 0))
        {
          if (k != 0) {
            eab();
          }
          AppMethodBeat.o(85184);
          return true;
          k = 0;
        }
        else
        {
          localObject2 = ((Set)localObject2).iterator();
          j = 0;
          bool1 = false;
          if (((Iterator)localObject2).hasNext())
          {
            str1 = (String)((Iterator)localObject2).next();
            if (str1 != null) {
              switch (str1.hashCode())
              {
              default: 
                label1380:
                i = -1;
                label1382:
                switch (i)
                {
                }
                break;
              }
            }
            for (;;)
            {
              for (;;)
              {
                break;
                if (!str1.equals("inspector")) {
                  break label1380;
                }
                i = 0;
                break label1382;
                if (!str1.equals("use_testconfig")) {
                  break label1380;
                }
                i = 1;
                break label1382;
                if (!str1.equals("set_grayvalue")) {
                  break label1380;
                }
                i = 2;
                break label1382;
                if (!str1.equals("kill_all")) {
                  break label1380;
                }
                i = 3;
                break label1382;
                if (!str1.equals("ignore_crashwatch")) {
                  break label1380;
                }
                i = 4;
                break label1382;
                if (!str1.equals("save_page")) {
                  break label1380;
                }
                i = 5;
                break label1382;
                if (!str1.equals("clear_cache")) {
                  break label1380;
                }
                i = 6;
                break label1382;
                if (!str1.equals("clear_old_ver")) {
                  break label1380;
                }
                i = 7;
                break label1382;
                if (!str1.equals("fix_dex")) {
                  break label1380;
                }
                i = 8;
                break label1382;
                if (!str1.equals("clear_all")) {
                  break label1380;
                }
                i = 9;
                break label1382;
                if (!str1.equals("abandon_curent_ver")) {
                  break label1380;
                }
                i = 10;
                break label1382;
                bool1 = ((Uri)localObject1).getBooleanQueryParameter("inspector", false);
                q.dYn().sd(bool1);
                a(bool1, null, true);
                bool1 = true;
                break;
                bool1 = ((Uri)localObject1).getBooleanQueryParameter("use_testconfig", false);
                q.dYn().sf(bool1);
                if (bool1) {
                  cz("使用测试config", true);
                }
                for (;;)
                {
                  bool1 = true;
                  break;
                  cz("使用正式config", true);
                }
                try
                {
                  i = Integer.parseInt(((Uri)localObject1).getQueryParameter("set_grayvalue"));
                  XWalkEnvironment.setGrayValueForTest(i);
                  cz("灰度值设为" + i % 10000, true);
                  bool1 = true;
                }
                catch (Exception localException)
                {
                  cz("灰度值设置失败，参数解析错误", true);
                  bool1 = true;
                }
              }
              break;
              j = 1;
              bool1 = true;
              break;
              boolean bool3 = ((Uri)localObject1).getBooleanQueryParameter("ignore_crashwatch", false);
              q localq = q.dYn();
              localq.BDP = bool3;
              localq.BDH.getSharedPreferences("wcwebview", 0).edit().putBoolean("ignore_crashwatch", bool3).commit();
              cz("忽略crash检测设为 = ".concat(String.valueOf(bool3)), true);
              break;
              if (!q.dYn().BDM) {}
              for (bool3 = true;; bool3 = false)
              {
                q.dYn().se(bool3);
                if (!bool3) {
                  break label1898;
                }
                dZX();
                this.BIJ.setVisibility(0);
                break;
              }
              label1898:
              if (this.BIJ != null)
              {
                this.BIJ.setVisibility(8);
                break;
                ab.clearAllWebViewCache(XWalkEnvironment.getApplicationContext(), true);
                cz("网页cache已经清理:", true);
                break;
                n.E(XWalkEnvironment.getApplicationContext(), true);
                cz("旧版本已经清理", true);
                break;
                n.eaj();
                break;
                XWalkEnvironment.clearAllVersion(this.BDH);
                bool1 = true;
                break;
                n.eah();
                bool1 = true;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      if (k != 0) {
        if (!cy(paramString, bool2))
        {
          bool2 = bool4;
          if (!bool1) {
            break label2009;
          }
        }
      }
      for (bool2 = true;; bool2 = bool1)
      {
        label2009:
        if (j != 0) {
          aAd();
        }
        AppMethodBeat.o(85184);
        return bool2;
      }
      j = 0;
      bool1 = false;
    }
  }
  
  final void cA(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(85204);
    try
    {
      AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.BDH);
      localBuilder.setMessage(paramString);
      localBuilder.create();
      localBuilder.setCancelable(true);
      if (paramBoolean) {
        localBuilder.setOnCancelListener(new c.43(this));
      }
      localBuilder.show();
      AppMethodBeat.o(85204);
      return;
    }
    catch (Exception paramString)
    {
      Log.i("WebDebugPage", "show alert failed may be in abtets exe " + paramString.getMessage());
      AppMethodBeat.o(85204);
    }
  }
  
  final void cz(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(85203);
    if (paramBoolean) {
      try
      {
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.BDH);
        localBuilder.setMessage(paramString);
        localBuilder.create().show();
        AppMethodBeat.o(85203);
        return;
      }
      catch (Exception paramString)
      {
        Log.i("WebDebugPage", "show alert failed may be in abtets exe " + paramString.getMessage());
        AppMethodBeat.o(85203);
        return;
      }
    }
    Log.e("WebDebugPage", paramString);
    AppMethodBeat.o(85203);
  }
  
  public final void dYB()
  {
    AppMethodBeat.i(85183);
    if (q.dYn().BDJ) {
      a(q.dYn().BDJ, null, false);
    }
    AppMethodBeat.o(85183);
  }
  
  final void dZX()
  {
    AppMethodBeat.i(85187);
    if (!q.dYn().BDM)
    {
      AppMethodBeat.o(85187);
      return;
    }
    if (this.BIJ != null)
    {
      AppMethodBeat.o(85187);
      return;
    }
    this.BIJ = new Button(this.BDH);
    this.BIJ.setText("保存页面");
    this.BIJ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(85122);
        new AlertDialog.Builder(c.this.BDH).setTitle("保存页面").setMessage("确定保存页面？").setPositiveButton("确定", new c.1.2(this)).setNegativeButton("取消", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
        }).show();
        AppMethodBeat.o(85122);
      }
    });
    this.BID.getTopView().addView(this.BIJ);
    AppMethodBeat.o(85187);
  }
  
  final void dZY()
  {
    AppMethodBeat.i(85188);
    if (this.BII == null)
    {
      AppMethodBeat.o(85188);
      return;
    }
    Object localObject3 = XWalkEnvironment.getXWalkUpdateConfigUrl();
    Object localObject2 = "\n\n" + this.BID.getAbstractInfo();
    localObject1 = localObject2;
    if (com.tencent.xweb.WebView.getCurWebType() != WebView.d.BEq) {
      localObject1 = (String)localObject2 + "\n xwebsdk is = 190503 apk ver is " + XWalkEnvironment.getAvailableVersion();
    }
    localObject1 = new StringBuilder().append((String)localObject1).append("\n\n current js engine: =  ").append(k.dYj()).append("\n prefered js engine =  ").append(k.a(k.a.BDo, "appbrand", this.BDH)).append("\n isWaitingForUpdate = ");
    com.tencent.xweb.xwalk.b.c.eav();
    localObject1 = com.tencent.xweb.xwalk.b.c.eaw() + "\n local gray value = " + XWalkEnvironment.getGrayValue() + "\n config url = " + (String)localObject3 + "\n config period(minutes) = " + com.tencent.xweb.xwalk.b.c.eaB() / 60000L + "\n\n apilevel = " + Build.VERSION.SDK_INT + "\n device is  " + Build.BRAND + " " + Build.MODEL + "\n usertype is " + XWalkEnvironment.getUserType();
    localObject3 = com.tencent.xweb.a.getAbstractInfo();
    localObject2 = localObject1;
    if (localObject3 != null)
    {
      localObject2 = localObject1;
      if (!((String)localObject3).isEmpty()) {
        localObject2 = (String)localObject1 + "\n\n ------dump commands start:------\n" + (String)localObject3 + "\n ------dump commands end------";
      }
    }
    Object localObject5 = "";
    localObject1 = localObject5;
    try
    {
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      localObject3 = localObject5;
      localObject1 = localObject5;
      if (com.tencent.xweb.xwalk.b.c.eax())
      {
        localObject1 = localObject5;
        String str = localSimpleDateFormat.format(new Date(com.tencent.xweb.xwalk.b.c.eaD().BLd));
        localObject1 = localObject5;
        localObject3 = "" + "going to update to apk ver = " + com.tencent.xweb.xwalk.b.c.eaD().BKV;
        localObject1 = localObject3;
        localObject3 = (String)localObject3 + "\n update time is = " + str;
        localObject1 = localObject3;
        localObject3 = (String)localObject3 + "\n is patch update = " + com.tencent.xweb.xwalk.b.c.eaD().BLb;
        localObject1 = localObject3;
        localObject3 = (String)localObject3 + "\n can use cellular = " + com.tencent.xweb.xwalk.b.c.eaD().BKP;
        localObject1 = localObject3;
        localObject3 = (String)localObject3 + "\n try count = " + com.tencent.xweb.xwalk.b.c.eaD().BLf;
        localObject1 = localObject3;
        localObject3 = (String)localObject3 + "\n try use shared core count = " + com.tencent.xweb.xwalk.b.c.eaD().BLg;
        localObject1 = localObject3;
        localObject3 = (String)localObject3 + "\n";
      }
      localObject1 = localObject3;
      localObject5 = new Date(com.tencent.xweb.xwalk.b.c.eaD().BLa);
      localObject1 = localObject3;
      localObject3 = (String)localObject3 + " last fetch config time = " + localSimpleDateFormat.format((Date)localObject5);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject4 = localObject1;
      }
    }
    localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject1 = localObject2;
      if (!((String)localObject3).isEmpty()) {
        localObject1 = (String)localObject2 + "\n\n ------dump schedule updateInfo start:------\n" + (String)localObject3 + "\n ------dump schedule updateInfo end------";
      }
    }
    localObject3 = XWalkEnvironment.getXWalkInitializeLog();
    localObject2 = localObject1;
    if (localObject3 != null)
    {
      localObject2 = localObject1;
      if (!((String)localObject3).isEmpty()) {
        localObject2 = (String)localObject1 + "\n\n ------dump xweb log------\n" + (String)localObject3;
      }
    }
    this.BII.setText((CharSequence)localObject2);
    AppMethodBeat.o(85188);
  }
  
  final void dZZ()
  {
    AppMethodBeat.i(85189);
    if ((!q.dYn().BDK) && ((!q.dYn().BDL) || (this.BID.getWebCoreType() != WebView.d.BEr)))
    {
      AppMethodBeat.o(85189);
      return;
    }
    if (this.BIH != null)
    {
      AppMethodBeat.o(85189);
      return;
    }
    this.BIH = new TextView(this.BDH);
    this.BIH.setOnLongClickListener(new c.23(this));
    eaa();
    this.BID.getTopView().addView(this.BIH);
    AppMethodBeat.o(85189);
  }
  
  final boolean eab()
  {
    AppMethodBeat.i(85193);
    b(this.BID);
    if (this.BIK != null)
    {
      this.BIK.setVisibility(0);
      AppMethodBeat.o(85193);
      return true;
    }
    this.BIK = ((LayoutInflater)this.BDH.getSystemService("layout_inflater")).inflate(2130969297, this.BID.getTopView(), true).findViewById(2131822139);
    ((Button)this.BIK.findViewById(2131823310)).setOnClickListener(new c.34(this));
    Object localObject1 = (CheckBox)this.BIK.findViewById(2131823308);
    ((CheckBox)localObject1).setChecked(q.dYn().BDK);
    ((CheckBox)localObject1).setOnCheckedChangeListener(new c.45(this));
    ((TextView)this.BIK.findViewById(2131823309)).setOnClickListener(new c.48(this, (CheckBox)localObject1));
    localObject1 = (EditText)this.BIK.findViewById(2131823331);
    if (localObject1 != null)
    {
      ((EditText)localObject1).setInputType(2);
      ((EditText)localObject1).setText(XWalkEnvironment.getGrayValue());
      ((EditText)localObject1).addTextChangedListener(new c.49(this, (EditText)localObject1));
    }
    ((Spinner)this.BIK.findViewById(2131823319)).setOnItemSelectedListener(new c.50(this));
    ((RadioGroup)this.BIK.findViewById(2131823320)).setOnCheckedChangeListener(new c.51(this));
    switch (c.47.BIj[q.dYn().BDQ.ordinal()])
    {
    default: 
      ((RadioGroup)this.BIK.findViewById(2131823325)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
      {
        public final void onCheckedChanged(RadioGroup paramAnonymousRadioGroup, int paramAnonymousInt)
        {
          AppMethodBeat.i(85123);
          paramAnonymousRadioGroup = k.a.BDo;
          if (paramAnonymousInt == 2131823326) {
            paramAnonymousRadioGroup = k.a.BDo;
          }
          for (;;)
          {
            q.dYn().a(paramAnonymousRadioGroup);
            Log.d("WebDebugPage", "v8 type change to=".concat(String.valueOf(paramAnonymousRadioGroup)));
            AppMethodBeat.o(85123);
            return;
            if (paramAnonymousInt == 2131823328) {
              paramAnonymousRadioGroup = k.a.BDp;
            } else if (paramAnonymousInt == 2131823329) {
              paramAnonymousRadioGroup = k.a.BDt;
            } else if (paramAnonymousInt == 2131823327) {
              paramAnonymousRadioGroup = k.a.BDv;
            } else if (paramAnonymousInt == 2131823330) {
              paramAnonymousRadioGroup = k.a.BDw;
            }
          }
        }
      });
      ((Button)this.BIK.findViewById(2131823332)).setOnClickListener(new c.3(this));
      localObject1 = (Button)this.BIK.findViewById(2131823333);
      a(q.dYn().BDJ, (Button)localObject1, false);
      ((Button)localObject1).setOnClickListener(new c.4(this, (Button)localObject1));
      ((Button)this.BIK.findViewById(2131823334)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(85126);
          XWalkEnvironment.clearAllVersion(c.this.BDH);
          AppMethodBeat.o(85126);
        }
      });
      ((Button)this.BIK.findViewById(2131823356)).setOnClickListener(new c.6(this));
      ((Button)this.BIK.findViewById(2131823337)).setOnClickListener(new c.7(this));
      Object localObject2 = (Button)this.BIK.findViewById(2131823335);
      if (q.dYn().BDR)
      {
        localObject1 = "使用正式版config";
        label494:
        ((Button)localObject2).setText((CharSequence)localObject1);
        ((Button)localObject2).setOnClickListener(new c.8(this, (Button)localObject2));
        ((Button)this.BIK.findViewById(2131823336)).setOnClickListener(new c.9(this));
        localObject1 = (LinearLayout)this.BIK.findViewById(2131823339);
        ((LinearLayout)localObject1).setVisibility(8);
        localObject2 = (Button)this.BIK.findViewById(2131823338);
        ((Button)localObject2).setText("插件设置");
        ((Button)localObject2).setOnClickListener(new c.10(this, (LinearLayout)localObject1));
        localObject1 = (Button)this.BIK.findViewById(2131823340);
        localObject2 = XWalkEnvironment.getPluginTestConfigUrl();
        if ((localObject2 == null) || (((String)localObject2).isEmpty())) {
          break label1387;
        }
        if (!((String)localObject2).equalsIgnoreCase("https://dldir1.qq.com/weixin/android/wxweb/plugin/pluginUpdateConfig_test.xml")) {
          break label1377;
        }
        ((Button)localObject1).setText("切换插件配置，当前使用默认测试版");
      }
      break;
    }
    for (;;)
    {
      ((Button)localObject1).setOnClickListener(new c.11(this, (Button)localObject1));
      ((Button)this.BIK.findViewById(2131823342)).setOnClickListener(new c.13(this));
      ((Button)this.BIK.findViewById(2131823343)).setOnClickListener(new c.14(this));
      ((Button)this.BIK.findViewById(2131823341)).setOnClickListener(new c.15(this));
      ((Button)this.BIK.findViewById(2131823344)).setOnClickListener(new c.16(this));
      ((Button)this.BIK.findViewById(2131823345)).setOnClickListener(new c.17(this));
      ((Button)this.BIK.findViewById(2131823346)).setOnClickListener(new c.18(this));
      localObject1 = (CheckBox)this.BIK.findViewById(2131823347);
      ((CheckBox)localObject1).setChecked(q.dYn().dYo());
      ((CheckBox)localObject1).setOnCheckedChangeListener(new c.19(this));
      localObject1 = (CheckBox)this.BIK.findViewById(2131823349);
      ((CheckBox)localObject1).setChecked(q.dYn().dYp());
      ((CheckBox)localObject1).setOnCheckedChangeListener(new c.20(this));
      ((TextView)this.BIK.findViewById(2131823351)).setText(eac());
      localObject1 = (EditText)this.BIK.findViewById(2131823352);
      ((Button)this.BIK.findViewById(2131823353)).setOnClickListener(new c.21(this, (EditText)localObject1));
      ((Button)this.BIK.findViewById(2131823354)).setOnClickListener(new c.22(this, (EditText)localObject1));
      ((Button)this.BIK.findViewById(2131823355)).setOnClickListener(new c.24(this, (EditText)localObject1));
      ((TextView)this.BIK.findViewById(2131823361)).setText(sj(true) + "\n" + XWalkInitializer.getXWalkInitializeLog());
      ((LinearLayout)this.BIK.findViewById(2131823317)).setVisibility(8);
      ((Button)this.BIK.findViewById(2131823312)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(85146);
          XWalkEnvironment.setGrayValueForTest(1);
          if (!XWalkEnvironment.hasAvailableVersion())
          {
            if (XWalkEnvironment.isIaDevice())
            {
              c.this.axY("http://debugxweb.qq.com/?set_web_config=WV_KIND_CW&set_appbrand_config=WV_KIND_CW&set_config_url=https://dldir1.qq.com/weixin/android/wxweb/updateConfig_x86_test.xml&check_xwalk_update");
              AppMethodBeat.o(85146);
              return;
            }
            c.this.axY("http://debugxweb.qq.com/?set_web_config=WV_KIND_CW&set_appbrand_config=WV_KIND_CW&set_config_url=https://dldir1.qq.com/weixin/android/wxweb/updateConfig_test.xml&check_xwalk_update");
            AppMethodBeat.o(85146);
            return;
          }
          q.dYn().a("tools", WebView.d.BEq);
          q.dYn().a("toolsmp", WebView.d.BEq);
          q.dYn().a("appbrand", WebView.d.BEq);
          q.dYn().a("support", WebView.d.BEq);
          q.dYn().a("mm", WebView.d.BEq);
          c.this.cA("已使用XWeb，点任意位置重启进程生效\n", true);
          AppMethodBeat.o(85146);
        }
      });
      ((Button)this.BIK.findViewById(2131823313)).setOnClickListener(new c.26(this));
      ((Button)this.BIK.findViewById(2131823314)).setOnClickListener(new c.27(this));
      ((Button)this.BIK.findViewById(2131823315)).setOnClickListener(new c.28(this));
      ((Button)this.BIK.findViewById(2131823316)).setOnClickListener(new c.29(this));
      ((Button)this.BIK.findViewById(2131823357)).setOnClickListener(new c.30(this));
      localObject1 = (Button)this.BIK.findViewById(2131823358);
      ((Button)localObject1).setOnClickListener(new c.31(this));
      ((Button)this.BIK.findViewById(2131823359)).setOnClickListener(new c.32(this));
      ((Button)localObject1).setOnLongClickListener(new c.33(this));
      ((Button)this.BIK.findViewById(2131823360)).setOnClickListener(this.BIN);
      AppMethodBeat.o(85193);
      return true;
      ((RadioButton)this.BIK.findViewById(2131823326)).setChecked(true);
      break;
      ((RadioButton)this.BIK.findViewById(2131823328)).setChecked(true);
      break;
      ((RadioButton)this.BIK.findViewById(2131823329)).setChecked(true);
      break;
      ((RadioButton)this.BIK.findViewById(2131823327)).setChecked(true);
      break;
      ((RadioButton)this.BIK.findViewById(2131823330)).setChecked(true);
      break;
      localObject1 = "使用测试config";
      break label494;
      label1377:
      ((Button)localObject1).setText("切换插件配置, 当前使用自定义测试版");
      continue;
      label1387:
      ((Button)localObject1).setText("切换插件配置，当前使用正式版");
    }
  }
  
  final void ead()
  {
    AppMethodBeat.i(139581);
    g localg = new g();
    HashMap localHashMap = new HashMap();
    localHashMap.put("UpdaterCheckType", "1");
    localg.a(this.BDH, localHashMap);
    AppMethodBeat.o(139581);
  }
  
  final void eae()
  {
    AppMethodBeat.i(85196);
    com.tencent.xweb.a.a(null, "0");
    SharedPreferences.Editor localEditor = XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
    localEditor.putLong("nLastFetchConfigTime", 0L);
    localEditor.putBoolean("bCanUseCellular", true);
    localEditor.putLong("nTimeToUpdate", 100L);
    localEditor.commit();
    com.tencent.xweb.xwalk.b.c.eaD().BLa = 100L;
    com.tencent.xweb.xwalk.b.c.eaD().BKP = true;
    com.tencent.xweb.xwalk.b.c.eaD().BLd = 100L;
    new c.b(this, this.BDH).s(null);
    AppMethodBeat.o(85196);
  }
  
  final void k(WebView.d paramd)
  {
    AppMethodBeat.i(85192);
    switch (c.47.iPi[paramd.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(85192);
      return;
      ((RadioButton)this.BIK.findViewById(2131823321)).setChecked(true);
      AppMethodBeat.o(85192);
      return;
      ((RadioButton)this.BIK.findViewById(2131823322)).setChecked(true);
      AppMethodBeat.o(85192);
      return;
      ((RadioButton)this.BIK.findViewById(2131823324)).setChecked(true);
      AppMethodBeat.o(85192);
      return;
      ((RadioButton)this.BIK.findViewById(2131823323)).setChecked(true);
    }
  }
  
  final String sj(boolean paramBoolean)
  {
    AppMethodBeat.i(85190);
    String str2 = this.BID.getVersionInfo();
    int i;
    if (!paramBoolean)
    {
      i = str2.indexOf(",apkversion");
      str1 = str2;
      if (i <= 0) {}
    }
    for (String str1 = str2.substring(0, i);; str1 = str2 + ", " + com.tencent.xweb.xwalk.a.e.eaq() + " current process is " + XWalkEnvironment.getProcessName())
    {
      AppMethodBeat.o(85190);
      return str1;
    }
  }
  
  final void sk(boolean paramBoolean)
  {
    AppMethodBeat.i(85201);
    Object localObject1 = Environment.getExternalStorageDirectory();
    if (localObject1 == null)
    {
      cz("请确认应用权限，在权限管理打开应用的读写存储权限", true);
      AppMethodBeat.o(85201);
      return;
    }
    if (((File)localObject1).listFiles() == null)
    {
      cz("请确认应用权限，在权限管理打开应用的读写存储权限", true);
      AppMethodBeat.o(85201);
      return;
    }
    localObject1 = ((File)localObject1).getPath() + "/apkxwebtest";
    Object localObject2;
    try
    {
      localObject1 = new File((String)localObject1);
      localObject2 = ((File)localObject1).listFiles();
      if ((localObject2 == null) || (localObject2.length == 0))
      {
        cz("apkxwebtest目录下没有.zip文件,请确认应用权限，在权限管理打开应用的读写存储权限", true);
        AppMethodBeat.o(85201);
        return;
      }
    }
    catch (Exception localException)
    {
      cz("没有找到apkxwebtest目录,请确认应用权限，在权限管理打开应用的读写存储权限", true);
      AppMethodBeat.o(85201);
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
          new AlertDialog.Builder(this.BDH).setTitle("提示").setMessage("确定加载:" + (String)localObject2 + "?").setPositiveButton("确定", new c.40(this, str, (String)localObject2, paramBoolean)).setNegativeButton("取消", new c.39(this)).show();
          AppMethodBeat.o(85201);
          return;
        }
        G(str, (String)localObject2, paramBoolean);
        AppMethodBeat.o(85201);
        return;
      }
      i += 1;
    }
    cz("apkxwebtest目录下没有.zip文件", true);
    AppMethodBeat.o(85201);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.c
 * JD-Core Version:    0.7.0.1
 */