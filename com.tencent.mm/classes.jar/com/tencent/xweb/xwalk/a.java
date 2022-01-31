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
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import com.tencent.xweb.WebView.d;
import com.tencent.xweb.c.e;
import com.tencent.xweb.g;
import com.tencent.xweb.g.a;
import com.tencent.xweb.k;
import com.tencent.xweb.s;
import com.tencent.xweb.xwalk.a.c;
import com.tencent.xweb.xwalk.a.c.a;
import com.tencent.xweb.xwalk.plugin.XWalkPluginManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.xwalk.core.Log;
import org.xwalk.core.R.id;
import org.xwalk.core.R.layout;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;
import org.xwalk.core.XWalkPreferences;
import org.xwalk.core.XWalkUpdater;

public final class a
  implements e
{
  Context xgK;
  com.tencent.xweb.WebView xkX;
  ScrollView xkY = null;
  TextView xkZ = null;
  TextView xla = null;
  TextView xlb = null;
  Button xlc = null;
  View xld;
  boolean xle = false;
  String xlf = "tools";
  
  public a(com.tencent.xweb.WebView paramWebView)
  {
    this.xgK = paramWebView.getContext();
    this.xkX = paramWebView;
    cTz();
    cTx();
  }
  
  private boolean ahc(String paramString)
  {
    Object localObject1;
    if (paramString.contains("debugxweb.qq.com"))
    {
      paramString = Uri.parse(paramString);
      localObject1 = paramString.getQueryParameterNames();
      if ((localObject1 == null) || (((Set)localObject1).size() == 0))
      {
        cTA();
        return true;
      }
      localObject1 = ((Set)localObject1).iterator();
    }
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (String)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          label180:
          int i;
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
              ow(false);
              break;
              if (!((String)localObject2).equals("load_local_xwalk")) {
                break label180;
              }
              i = 0;
              continue;
              if (!((String)localObject2).equals("set_web_config")) {
                break label180;
              }
              i = 1;
              continue;
              if (!((String)localObject2).equals("set_appbrand_config")) {
                break label180;
              }
              i = 2;
              continue;
              if (!((String)localObject2).equals("show_webview_version")) {
                break label180;
              }
              i = 3;
              continue;
              if (!((String)localObject2).equals("clear_commands")) {
                break label180;
              }
              i = 4;
              continue;
              if (!((String)localObject2).equals("set_config_url")) {
                break label180;
              }
              i = 5;
              continue;
              if (!((String)localObject2).equals("check_xwalk_update")) {
                break label180;
              }
              i = 6;
              continue;
              if (!((String)localObject2).equals("wait_debugger")) {
                break label180;
              }
              i = 7;
              continue;
              if (!((String)localObject2).equals("set_apkver")) {
                break label180;
              }
              i = 8;
              continue;
              if (!((String)localObject2).equals("check_files")) {
                break label180;
              }
              i = 9;
              continue;
              if (!((String)localObject2).equals("set_plugin_config_url")) {
                break label180;
              }
              i = 10;
            }
          }
          try
          {
            localObject2 = WebView.d.valueOf(paramString.getQueryParameter("set_web_config"));
            k.cSk().a("tools", (WebView.d)localObject2);
            k.cSk().a("toolsmp", (WebView.d)localObject2);
            bU("打开网页将使用:" + localObject2, true);
          }
          catch (Exception localException1) {}
        }
      }
      else
      {
        try
        {
          Object localObject3 = WebView.d.valueOf(paramString.getQueryParameter("set_appbrand_config"));
          k.cSk().a("appbrand", (WebView.d)localObject3);
          k.cSk().a("support", (WebView.d)localObject3);
          switch (35.xkh[localObject3.ordinal()])
          {
          case 1: 
            k.cSk().a(g.a.xgE);
            bU("打开小程序将使用:" + localObject3, true);
            break;
          case 2: 
            k.cSk().a(g.a.xgB);
            bU("打开小程序将使用:" + localObject3, true);
            break;
          case 3: 
            k.cSk().a(g.a.xgE);
            bU("打开小程序将使用:" + localObject3, true);
            continue;
            if (this.xlb == null)
            {
              localObject3 = new ScrollView(this.xgK);
              this.xlb = new TextView(this.xgK);
              this.xlb.setBackgroundColor(-1);
              ((ScrollView)localObject3).addView(this.xlb);
              this.xlb.setOnClickListener(new a.12(this));
              cTy();
              this.xkX.getTopView().addView((View)localObject3);
              continue;
              com.tencent.xweb.a.a(null, "0");
              continue;
              try
              {
                localObject3 = paramString.getQueryParameter("set_config_url");
                XWalkEnvironment.setTestDownLoadUrl(this.xgK, (String)localObject3);
                bU("测试连接设置为:" + (String)localObject3, true);
              }
              catch (Exception localException2)
              {
                bU("测试连接设置失败，格式错误", true);
              }
              continue;
              cTB();
              continue;
              boolean bool = paramString.getBooleanQueryParameter("wait_debugger", false);
              Object localObject4 = k.cSk();
              ((k)localObject4).xgQ = bool;
              ((k)localObject4).xgK.getSharedPreferences("wcwebview", 0).edit().putBoolean("bWaitforDebugger", bool).commit();
              continue;
              localObject4 = paramString.getQueryParameter("set_apkver");
              try
              {
                XWalkEnvironment.setAvailableVersion(Integer.parseInt((String)localObject4), "1.0." + (String)localObject4);
                ahe("版本号设置到:" + (String)localObject4 + " 点击空白处退出重启进程");
              }
              catch (Exception localException3)
              {
                bU("设置版本号失败:" + localException3.getMessage(), true);
              }
              continue;
              l.ox(true);
              try
              {
                String str = paramString.getQueryParameter("set_plugin_config_url");
                XWalkEnvironment.setPluginTestConfigUrl(str);
                bU("插件测试连接设置为:" + str, true);
              }
              catch (Exception localException4)
              {
                bU("插件测试连接设置失败，格式错误", true);
              }
              continue;
              return true;
              return false;
            }
            break;
          }
        }
        catch (Exception localException5) {}
      }
    }
  }
  
  private void ahd(String paramString)
  {
    File localFile = new File(paramString);
    if (localFile.isDirectory())
    {
      String[] arrayOfString = localFile.list();
      if (arrayOfString != null)
      {
        int i = 0;
        while (i < arrayOfString.length)
        {
          ahd(paramString + "//" + arrayOfString[i]);
          i += 1;
        }
      }
    }
    localFile.delete();
  }
  
  protected static void io(Context paramContext)
  {
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
  }
  
  final void A(String paramString1, String paramString2, boolean paramBoolean)
  {
    a.a locala = new a.a(paramString1, paramString2);
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
      bU("安装" + paramString2 + "失败,错误码=" + paramString1, true);
    }
    catch (IOException paramString1)
    {
      for (;;)
      {
        paramString1 = XWalkUpdater.onHandleFile(locala);
        if (paramString1.intValue() != 0) {
          break;
        }
        bU("安装" + paramString2 + "成功", paramBoolean);
        return;
        ((FileOutputStream)localObject).flush();
        paramString1.close();
        ((FileOutputStream)localObject).close();
      }
    }
    catch (Exception paramString1)
    {
      bU("安装失败", true);
      Log.e("WebDebugPage", "install local apk failed : " + paramString1.getMessage());
      return;
    }
  }
  
  public final void a(boolean paramBoolean1, Button paramButton, boolean paramBoolean2)
  {
    try
    {
      XWalkPreferences.setValue("remote-debugging", paramBoolean1);
      try
      {
        label7:
        if (Build.VERSION.SDK_INT >= 19) {
          android.webkit.WebView.setWebContentsDebuggingEnabled(paramBoolean1);
        }
        try
        {
          label19:
          com.tencent.smtt.sdk.WebView.setWebContentsDebuggingEnabled(paramBoolean1);
          label23:
          if ((paramBoolean2) && (this.xkX.getX5WebViewExtension() != null))
          {
            if (!paramBoolean1) {
              break label67;
            }
            this.xkX.loadUrl("http://debugx5.qq.com/?inspector=true");
          }
          for (;;)
          {
            if (paramButton != null)
            {
              if (!paramBoolean1) {
                break;
              }
              paramButton.setText("关闭远程调试模式");
            }
            return;
            label67:
            this.xkX.loadUrl("http://debugx5.qq.com/?inspector=false");
          }
          paramButton.setText("打开远程调试模式");
          return;
        }
        catch (Exception localException1)
        {
          break label23;
        }
      }
      catch (Exception localException2)
      {
        break label19;
      }
    }
    catch (Exception localException3)
    {
      break label7;
    }
  }
  
  final void afz()
  {
    io(this.xgK);
  }
  
  public final boolean agV(String paramString)
  {
    boolean bool3 = false;
    boolean bool1 = true;
    Object localObject1;
    String str;
    int i;
    label114:
    boolean bool2;
    if (paramString.contains("debugmm.qq.com"))
    {
      localObject1 = Uri.parse(paramString);
      localObject2 = ((Uri)localObject1).getQueryParameterNames();
      if ((localObject2 != null) && (((Set)localObject2).size() > 0))
      {
        localObject2 = ((Set)localObject2).iterator();
        for (;;)
        {
          if (((Iterator)localObject2).hasNext())
          {
            str = (String)((Iterator)localObject2).next();
            if (str != null) {
              switch (str.hashCode())
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
                    k.cSk().a("tools", WebView.d.xhp);
                    k.cSk().a("appbrand", WebView.d.xhp);
                    k.cSk().a("support", WebView.d.xhp);
                    k.cSk().a("mm", WebView.d.xhp);
                    k.cSk().a("toolsmp", WebView.d.xhp);
                    k.cSk().a(g.a.xgB);
                    ahe("force use x5 switch is on ");
                    bool2 = bool1;
                  }
                  break;
                }
                break;
              }
            }
          }
        }
      }
    }
    label472:
    boolean bool4;
    label562:
    do
    {
      do
      {
        do
        {
          return bool2;
          if (!str.equals("forcex5")) {
            break;
          }
          i = 0;
          break label114;
          if (!str.equals("inspector")) {
            break;
          }
          i = 1;
          break label114;
          k.cSk().a("tools", WebView.d.xhn);
          k.cSk().a("appbrand", WebView.d.xhn);
          k.cSk().a("support", WebView.d.xhn);
          k.cSk().a("mm", WebView.d.xhn);
          k.cSk().a("toolsmp", WebView.d.xhn);
          k.cSk().a(g.a.xgw);
          ahe("force use x5 switch is off ");
          return true;
          bool1 = ((Uri)localObject1).getBooleanQueryParameter("inspector", false);
          k.cSk().oq(bool1);
          a(bool1, null, true);
          return true;
          if (!paramString.contains("public.debugxweb.qq.com")) {
            break label562;
          }
          paramString = Uri.parse(paramString);
          localObject1 = paramString.getQueryParameterNames();
          bool2 = bool1;
        } while (localObject1 == null);
        bool2 = bool1;
      } while (((Set)localObject1).size() <= 0);
      localObject1 = ((Set)localObject1).iterator();
      do
      {
        bool2 = bool1;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (String)((Iterator)localObject1).next();
      } while (localObject2 == null);
      switch (((String)localObject2).hashCode())
      {
      }
      for (i = -1;; i = 0) {
        switch (i)
        {
        default: 
          break;
        case 0: 
          localObject2 = k.cSk();
          bool2 = paramString.getBooleanQueryParameter("enable_local_debug", false);
          ((k)localObject2).xgK.getSharedPreferences("wcwebview", 4).edit().putBoolean("m_bEnableLocalDebug", bool2).commit();
          break;
          if (!((String)localObject2).equals("enable_local_debug")) {
            break label472;
          }
        }
      }
      bool4 = k.cSk().xgK.getSharedPreferences("wcwebview", 4).getBoolean("m_bEnableLocalDebug", false);
      if (!paramString.contains("debugxweb.qq.com")) {
        break label1329;
      }
      localObject1 = Uri.parse(paramString);
      localObject2 = ((Uri)localObject1).getQueryParameterNames();
      if ((localObject2 != null) && (((Set)localObject2).size() != 0)) {
        break label639;
      }
      bool2 = bool1;
    } while (!bool4);
    cTA();
    return true;
    label639:
    Object localObject2 = ((Set)localObject2).iterator();
    int j = 0;
    bool1 = false;
    while (((Iterator)localObject2).hasNext())
    {
      str = (String)((Iterator)localObject2).next();
      if (str != null)
      {
        switch (str.hashCode())
        {
        default: 
          label760:
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
            k.cSk().oq(bool1);
            a(bool1, null, true);
            bool1 = true;
            break;
            if (!str.equals("inspector")) {
              break label760;
            }
            i = 0;
            continue;
            if (!str.equals("use_testconfig")) {
              break label760;
            }
            i = 1;
            continue;
            if (!str.equals("set_grayvalue")) {
              break label760;
            }
            i = 2;
            continue;
            if (!str.equals("kill_all")) {
              break label760;
            }
            i = 3;
            continue;
            if (!str.equals("ignore_crashwatch")) {
              break label760;
            }
            i = 4;
            continue;
            if (!str.equals("save_page")) {
              break label760;
            }
            i = 5;
            continue;
            if (!str.equals("clear_cache")) {
              break label760;
            }
            i = 6;
            continue;
            if (!str.equals("clear_old_ver")) {
              break label760;
            }
            i = 7;
          }
        }
        bool1 = ((Uri)localObject1).getBooleanQueryParameter("use_testconfig", false);
        k.cSk().os(bool1);
        if (bool1) {
          bU("使用测试config", true);
        }
        for (;;)
        {
          bool1 = true;
          break;
          bU("使用正式config", true);
        }
        try
        {
          i = Integer.parseInt(((Uri)localObject1).getQueryParameter("set_grayvalue"));
          XWalkEnvironment.setGrayValueForTest(i);
          bU("灰度值设为" + i % 10000, true);
          bool1 = true;
        }
        catch (Exception localException)
        {
          bU("灰度值设置失败，参数解析错误", true);
          bool1 = true;
        }
        continue;
        afz();
        j = 1;
        bool1 = true;
        continue;
        bool2 = ((Uri)localObject1).getBooleanQueryParameter("ignore_crashwatch", false);
        k localk = k.cSk();
        localk.xgR = bool2;
        localk.xgK.getSharedPreferences("wcwebview", 0).edit().putBoolean("ignore_crashwatch", bool2).commit();
        bU("忽略crash检测设为 = " + bool2, true);
        continue;
        if (!k.cSk().xgO) {}
        for (bool2 = true;; bool2 = false)
        {
          k.cSk().or(bool2);
          if (!bool2) {
            break label1227;
          }
          cTx();
          this.xlc.setVisibility(0);
          break;
        }
        label1227:
        if (this.xlc != null)
        {
          this.xlc.setVisibility(8);
          continue;
          s.clearAllWebViewCache(XWalkEnvironment.getApplicationContext(), true);
          bU("网页cache已经清理:", true);
          continue;
          l.y(XWalkEnvironment.getApplicationContext(), true);
          bU("旧版本已经清理", true);
        }
      }
    }
    for (;;)
    {
      if (bool4)
      {
        if (!ahc(paramString))
        {
          bool2 = bool3;
          if (!bool1) {}
        }
        else
        {
          bool2 = true;
        }
        bool1 = bool2;
      }
      for (;;)
      {
        bool2 = bool1;
        if (j == 0) {
          break;
        }
        afz();
        return bool1;
      }
      label1329:
      j = 0;
      bool1 = false;
    }
  }
  
  final void ahe(String paramString)
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.xgK);
    localBuilder.setMessage(paramString);
    localBuilder.create();
    localBuilder.setCancelable(true);
    localBuilder.setOnCancelListener(new a.32(this));
    localBuilder.show();
  }
  
  final void bU(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.xgK);
      localBuilder.setMessage(paramString);
      localBuilder.create().show();
      return;
    }
    Log.e("WebDebugPage", paramString);
  }
  
  public final void cSv()
  {
    if (k.cSk().xgM) {
      a(k.cSk().xgM, null, false);
    }
  }
  
  final boolean cTA()
  {
    if (this.xld != null)
    {
      this.xld.setVisibility(0);
      return true;
    }
    this.xld = ((LayoutInflater)this.xgK.getSystemService("layout_inflater")).inflate(R.layout.debug_menu, this.xkX.getTopView(), true).findViewById(R.id.view_root);
    ((Button)this.xld.findViewById(R.id.button_close_menu)).setOnClickListener(new a.34(this));
    Object localObject = (CheckBox)this.xld.findViewById(R.id.checked_show_version);
    ((CheckBox)localObject).setChecked(k.cSk().xgN);
    ((CheckBox)localObject).setOnCheckedChangeListener(new a.36(this));
    ((TextView)this.xld.findViewById(R.id.check_text)).setOnClickListener(new a.37(this, (CheckBox)localObject));
    localObject = (EditText)this.xld.findViewById(R.id.txtin_grayvalue);
    if (localObject != null)
    {
      ((EditText)localObject).setInputType(2);
      ((EditText)localObject).setText(XWalkEnvironment.getGrayValue());
      ((EditText)localObject).addTextChangedListener(new a.38(this, (EditText)localObject));
    }
    ((Spinner)this.xld.findViewById(R.id.selector_webviewmodule)).setOnItemSelectedListener(new a.39(this));
    ((RadioGroup)this.xld.findViewById(R.id.web_select)).setOnCheckedChangeListener(new a.40(this));
    Button localButton;
    switch (35.gXB[k.cSk().xgS.ordinal()])
    {
    default: 
      ((RadioGroup)this.xld.findViewById(R.id.v8_select)).setOnCheckedChangeListener(new a.2(this));
      ((Button)this.xld.findViewById(R.id.button_kill)).setOnClickListener(new a.3(this));
      localObject = (Button)this.xld.findViewById(R.id.btn_debug);
      a(k.cSk().xgM, (Button)localObject, false);
      ((Button)localObject).setOnClickListener(new a.4(this, (Button)localObject));
      ((Button)this.xld.findViewById(R.id.button_clear)).setOnClickListener(new a.5(this));
      ((Button)this.xld.findViewById(R.id.button_refreshLog)).setOnClickListener(new a.6(this));
      ((Button)this.xld.findViewById(R.id.button_loadLocalApk)).setOnClickListener(new a.7(this));
      localButton = (Button)this.xld.findViewById(R.id.button_config);
      if (k.cSk().xgT)
      {
        localObject = "使用正式版config";
        label478:
        localButton.setText((CharSequence)localObject);
        localButton.setOnClickListener(new a.8(this, localButton));
        ((Button)this.xld.findViewById(R.id.button_update)).setOnClickListener(new a.9(this));
        localObject = (LinearLayout)this.xld.findViewById(R.id.plugin_menu);
        ((LinearLayout)localObject).setVisibility(8);
        localButton = (Button)this.xld.findViewById(R.id.button_plugin_menu);
        localButton.setText("插件设置");
        localButton.setOnClickListener(new a.10(this, (LinearLayout)localObject));
        localButton = (Button)this.xld.findViewById(R.id.button_plugin_config);
        if (!XWalkEnvironment.hasPluginTestConfigUrl()) {
          break label1067;
        }
      }
      break;
    }
    label1067:
    for (localObject = "切换插件config，当前使用测试版";; localObject = "切换插件config，当前使用正式版")
    {
      localButton.setText((CharSequence)localObject);
      localButton.setOnClickListener(new a.11(this, localButton));
      ((Button)this.xld.findViewById(R.id.button_update_all_plugin)).setOnClickListener(new a.13(this));
      ((Button)this.xld.findViewById(R.id.button_update_fullScreenJS)).setOnClickListener(new a.14(this));
      ((Button)this.xld.findViewById(R.id.button_clear_all_plugin)).setOnClickListener(new a.15(this));
      ((Button)this.xld.findViewById(R.id.button_load_local_fullScreenJS)).setOnClickListener(new a.16(this));
      ((TextView)this.xld.findViewById(R.id.txtVersion)).setText(ov(true) + "\n" + XWalkInitializer.getXWalkInitializeLog());
      ((LinearLayout)this.xld.findViewById(R.id.config_memu)).setVisibility(8);
      ((Button)this.xld.findViewById(R.id.button_change_to_xweb)).setOnClickListener(new a.17(this));
      ((Button)this.xld.findViewById(R.id.button_change_to_x5)).setOnClickListener(new a.18(this));
      ((Button)this.xld.findViewById(R.id.button_change_to_sys)).setOnClickListener(new a.19(this));
      ((Button)this.xld.findViewById(R.id.button_change_to_auto)).setOnClickListener(new a.20(this));
      ((Button)this.xld.findViewById(R.id.button_advanced)).setOnClickListener(new a.21(this));
      ((Button)this.xld.findViewById(R.id.button_savePage)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          boolean bool;
          if (!k.cSk().xgO)
          {
            bool = true;
            k.cSk().or(bool);
            if (!bool) {
              break label46;
            }
            a.this.cTx();
            a.this.xlc.setVisibility(0);
          }
          label46:
          while (a.this.xlc == null)
          {
            return;
            bool = false;
            break;
          }
          a.this.xlc.setVisibility(8);
        }
      });
      localObject = (Button)this.xld.findViewById(R.id.button_loadSavedPage);
      ((Button)localObject).setOnClickListener(new a.24(this));
      ((Button)localObject).setOnLongClickListener(new a.25(this));
      return true;
      ((RadioButton)this.xld.findViewById(R.id.v8_auto)).setChecked(true);
      break;
      ((RadioButton)this.xld.findViewById(R.id.v8_sys)).setChecked(true);
      break;
      ((RadioButton)this.xld.findViewById(R.id.v8_x5)).setChecked(true);
      break;
      ((RadioButton)this.xld.findViewById(R.id.v8_nativescript)).setChecked(true);
      break;
      ((RadioButton)this.xld.findViewById(R.id.v8_mmv8)).setChecked(true);
      break;
      localObject = "使用测试config";
      break label478;
    }
  }
  
  final void cTB()
  {
    com.tencent.xweb.a.a(null, "0");
    SharedPreferences.Editor localEditor = XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
    localEditor.putLong("nLastFetchConfigTime", 0L);
    localEditor.putBoolean("bCanUseCellular", true);
    localEditor.putLong("nTimeToUpdate", 100L);
    localEditor.commit();
    c.cTR().xne = 100L;
    c.cTR().xmT = true;
    c.cTR().xnh = 100L;
    new a.b(this, this.xgK).o(null);
  }
  
  final void cTx()
  {
    if (!k.cSk().xgO) {}
    while (this.xlc != null) {
      return;
    }
    this.xlc = new Button(this.xgK);
    this.xlc.setText("保存页面");
    this.xlc.setOnClickListener(new a.1(this));
    this.xkX.getTopView().addView(this.xlc);
  }
  
  final void cTy()
  {
    if (this.xlb == null) {
      return;
    }
    Object localObject3 = XWalkEnvironment.getXWalkUpdateConfigUrl();
    Object localObject2 = "\n\n" + this.xkX.getAbstractInfo();
    localObject1 = localObject2;
    if (com.tencent.xweb.WebView.getCurWebType() != WebView.d.xho) {
      localObject1 = (String)localObject2 + "\n xwebsdk is = 180801 apk ver is " + XWalkEnvironment.getAvailableVersion();
    }
    localObject1 = new StringBuilder().append((String)localObject1).append("\n\n current js engine: =  ").append(g.cSh()).append("\n prefered js engine =  ").append(g.b(g.a.xgw, "appbrand", this.xgK)).append("\n isWaitingForUpdate = ");
    c.cTK();
    localObject1 = c.cTL() + "\n local gray value = " + XWalkEnvironment.getGrayValue() + "\n config url = " + (String)localObject3 + "\n\n apilevel = " + Build.VERSION.SDK_INT + "\n device is  " + Build.BRAND + " " + Build.MODEL;
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
      if (c.cTM())
      {
        localObject1 = localObject5;
        String str = localSimpleDateFormat.format(new Date(c.cTR().xnh));
        localObject1 = localObject5;
        localObject3 = "" + "going to update to apk ver = " + c.cTR().xmZ;
        localObject1 = localObject3;
        localObject3 = (String)localObject3 + "\n update time is = " + str;
        localObject1 = localObject3;
        localObject3 = (String)localObject3 + "\n is patch update = " + c.cTR().xnf;
        localObject1 = localObject3;
        localObject3 = (String)localObject3 + "\n can use cellular = " + c.cTR().xmT;
        localObject1 = localObject3;
        localObject3 = (String)localObject3 + "\n try count = " + c.cTR().xnj;
        localObject1 = localObject3;
        localObject3 = (String)localObject3 + "\n try use shared core count = " + c.cTR().xnk;
        localObject1 = localObject3;
        localObject3 = (String)localObject3 + "\n";
      }
      localObject1 = localObject3;
      localObject5 = new Date(c.cTR().xne);
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
    this.xlb.setText((CharSequence)localObject2);
  }
  
  final void cTz()
  {
    if (!k.cSk().xgN) {}
    while (this.xla != null) {
      return;
    }
    this.xla = new TextView(this.xgK);
    this.xla.setOnLongClickListener(new a.23(this));
    if (this.xla != null)
    {
      String str = ov(false);
      this.xla.setText(str);
    }
    this.xkX.getTopView().addView(this.xla);
  }
  
  final void h(WebView.d paramd)
  {
    switch (35.xkh[paramd.ordinal()])
    {
    default: 
      return;
    case 4: 
      ((RadioButton)this.xld.findViewById(R.id.WV_AUTO)).setChecked(true);
      return;
    case 1: 
      ((RadioButton)this.xld.findViewById(R.id.WV_XWALK)).setChecked(true);
      return;
    case 2: 
      ((RadioButton)this.xld.findViewById(R.id.WV_X5)).setChecked(true);
      return;
    }
    ((RadioButton)this.xld.findViewById(R.id.WV_SYS)).setChecked(true);
  }
  
  final String ov(boolean paramBoolean)
  {
    String str2 = this.xkX.getVersionInfo();
    if (!paramBoolean)
    {
      int i = str2.indexOf(",apkversion");
      String str1 = str2;
      if (i > 0) {
        str1 = str2.substring(0, i);
      }
      return str1;
    }
    return str2 + ", " + XWalkPluginManager.cTG() + " current process is " + XWalkEnvironment.getProcessName();
  }
  
  final void ow(boolean paramBoolean)
  {
    Object localObject1 = Environment.getExternalStorageDirectory();
    if (localObject1 == null)
    {
      bU("请确认应用权限，在权限管理打开应用的读写存储权限", true);
      return;
    }
    if (((File)localObject1).listFiles() == null)
    {
      bU("请确认应用权限，在权限管理打开应用的读写存储权限", true);
      return;
    }
    ((File)localObject1).toString();
    localObject1 = ((File)localObject1).getPath() + "/apkxwebtest";
    Object localObject2;
    try
    {
      localObject1 = new File((String)localObject1);
      localObject2 = ((File)localObject1).listFiles();
      if ((localObject2 == null) || (localObject2.length == 0))
      {
        bU("apkxwebtest目录下没有.zip文件,请确认应用权限，在权限管理打开应用的读写存储权限", true);
        return;
      }
    }
    catch (Exception localException)
    {
      bU("没有找到apkxwebtest目录,请确认应用权限，在权限管理打开应用的读写存储权限", true);
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
          new AlertDialog.Builder(this.xgK).setTitle("提示").setMessage("确定加载:" + (String)localObject2 + "?").setPositiveButton("确定", new a.29(this, str, (String)localObject2, paramBoolean)).setNegativeButton("取消", new a.28(this)).show();
          return;
        }
        A(str, (String)localObject2, paramBoolean);
        return;
      }
      i += 1;
    }
    bU("apkxwebtest目录下没有.zip文件", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a
 * JD-Core Version:    0.7.0.1
 */