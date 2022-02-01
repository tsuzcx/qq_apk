package com.tencent.xweb;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.webkit.ValueCallback;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.internal.j;
import com.tencent.xweb.internal.j.a;
import com.tencent.xweb.xwalk.a.g;
import com.tencent.xweb.xwalk.a.i;
import com.tencent.xweb.xwalk.a.l;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public final class h
{
  private static Map<String, String> KyT;
  private static w.a KyU;
  
  static
  {
    AppMethodBeat.i(156758);
    KyT = new HashMap();
    KyU = null;
    AppMethodBeat.o(156758);
  }
  
  private static void a(l paraml, String paramString1, String paramString2, String paramString3, Activity paramActivity, ViewGroup paramViewGroup, ValueCallback<Integer> paramValueCallback)
  {
    AppMethodBeat.i(205060);
    long l1 = System.currentTimeMillis();
    long l2 = f.lj(paramActivity);
    boolean bool2;
    Object localObject1;
    boolean bool1;
    if (y.fJs() != null)
    {
      bool2 = y.fJs().fJt();
      localObject1 = y.fJs().Kzw.getSharedPreferences("wcwebview", 4);
      if (localObject1 == null) {
        bool1 = true;
      }
    }
    for (;;)
    {
      localObject1 = new HashMap();
      Object localObject2 = b.aUF(paraml.getPluginName());
      if (localObject2 != null)
      {
        localObject2 = ((HashMap)localObject2).entrySet().iterator();
        for (;;)
        {
          if (((Iterator)localObject2).hasNext())
          {
            Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
            if ((localEntry != null) && (localEntry.getKey() != null) && (!((String)localEntry.getKey()).isEmpty()) && (localEntry.getValue() != null) && (!((String)localEntry.getValue()).isEmpty()))
            {
              ((HashMap)localObject1).put("config_param_" + (String)localEntry.getKey(), localEntry.getValue());
              continue;
              bool1 = ((SharedPreferences)localObject1).getBoolean("fr_disable_encry", true);
              break;
            }
          }
        }
      }
      ((HashMap)localObject1).put("dark_mode", String.valueOf(XWalkEnvironment.getForceDarkMode()));
      ((HashMap)localObject1).put("disable_cache", String.valueOf(bool2));
      ((HashMap)localObject1).put("disable_encry", String.valueOf(bool1));
      ((HashMap)localObject1).put("file_path", paramString1);
      ((HashMap)localObject1).put("file_ext", paramString2);
      ((HashMap)localObject1).put("token", paramString3);
      ((HashMap)localObject1).put("time_start", String.valueOf(l1));
      ((HashMap)localObject1).put("memory_start", String.valueOf(l2));
      ((HashMap)localObject1).put("str_password_title", paramActivity.getString(2131766369));
      ((HashMap)localObject1).put("str_password_wrong", paramActivity.getString(2131766370));
      ((HashMap)localObject1).put("str_password_hint", paramActivity.getString(2131766368));
      ((HashMap)localObject1).put("str_button_confirm", paramActivity.getString(2131766365));
      ((HashMap)localObject1).put("str_button_cancel", paramActivity.getString(2131766364));
      ((HashMap)localObject1).put("str_operation_copy", paramActivity.getString(2131766367));
      ((HashMap)localObject1).put("str_hint_copied", paramActivity.getString(2131766366));
      if (paraml.a((HashMap)localObject1, paramActivity, paramViewGroup, paramValueCallback)) {
        KyT.put(paramString3 + paramString1, paraml.getPluginName());
      }
      AppMethodBeat.o(205060);
      return;
      bool1 = true;
      bool2 = false;
    }
  }
  
  private static void a(String paramString, int paramInt1, ValueCallback<Integer> paramValueCallback, int paramInt2)
  {
    AppMethodBeat.i(205061);
    f.aX(paramString, paramInt1, paramInt2);
    if (paramValueCallback != null) {
      paramValueCallback.onReceiveValue(Integer.valueOf(paramInt2));
    }
    AppMethodBeat.o(205061);
  }
  
  public static void a(final String paramString1, final String paramString2, final String paramString3, boolean paramBoolean, Activity paramActivity, final ViewGroup paramViewGroup, final ValueCallback<Integer> paramValueCallback)
  {
    AppMethodBeat.i(205058);
    Object localObject2 = new StringBuilder("readFile by xweb, fileExt: ");
    if (paramString2 != null) {}
    for (Object localObject1 = paramString2;; localObject1 = "null")
    {
      Log.i("XFilesReaderXWeb", (String)localObject1);
      f.mA(paramString2, f.a.KyN.name());
      localObject2 = f.aUJ(paramString2);
      if ((localObject2 instanceof l)) {
        break;
      }
      Log.e("XFilesReaderXWeb", "readFile unSupport format".concat(String.valueOf(paramString2)));
      a(paramString2, -1, paramValueCallback, -7);
      AppMethodBeat.o(205058);
      return;
    }
    localObject1 = (l)localObject2;
    int j = ((com.tencent.xweb.xwalk.a.f)localObject1).KHj;
    if ((j <= 0) || (j < ((l)localObject1).fLM()))
    {
      if ((ai.fJV()) && (!((com.tencent.xweb.xwalk.a.f)localObject2).fLN()))
      {
        Log.i("XFilesReaderXWeb", "readFile forbid download code, return");
        a(paramString2, -1, paramValueCallback, -1);
        AppMethodBeat.o(205058);
        return;
      }
      int i;
      if (!paramBoolean)
      {
        Log.i("XFilesReaderXWeb", "readFile plugin version: " + j + ", require: " + ((l)localObject1).fLM() + ", canDownload: false, return");
        if (j <= 0) {}
        for (i = -2;; i = -11)
        {
          a(paramString2, j, paramValueCallback, i);
          AppMethodBeat.o(205058);
          return;
        }
      }
      Log.i("XFilesReaderXWeb", "readFile plugin version: " + j + ", require: " + ((l)localObject1).fLM() + ", canDownload: true, start download");
      f.aUP(paramString2);
      if (KyU != null)
      {
        Log.i("XFilesReaderXWeb", "startDownload pre updater not finish, cancel it");
        KyU.fJr();
        KyU = null;
      }
      localObject2 = j.g(WebView.c.KzZ);
      if (localObject2 == null)
      {
        Log.e("XFilesReaderXWeb", "startDownload webViewProvider is null");
        i = 0;
      }
      for (;;)
      {
        if (i == 0)
        {
          f.aUQ(paramString2);
          a(paramString2, j, paramValueCallback, -16);
        }
        AppMethodBeat.o(205058);
        return;
        localObject2 = (w.a)((j.a)localObject2).excute("STR_CMD_GET_PLUGIN_UPDATER", null);
        KyU = (w.a)localObject2;
        if (localObject2 == null)
        {
          Log.e("XFilesReaderXWeb", "startDownload updater is null");
          i = 0;
        }
        else
        {
          paramActivity = new WeakReference(paramActivity);
          paramViewGroup = new WeakReference(paramViewGroup);
          KyU.a(((l)localObject1).getPluginName(), new i()
          {
            private WeakReference<TextView> KyV = null;
            
            public final void afY(int paramAnonymousInt)
            {
              AppMethodBeat.i(205056);
              Activity localActivity = (Activity)this.KyW.get();
              TextView localTextView = (TextView)this.KyV.get();
              if ((localActivity == null) || (localActivity.isDestroyed()) || (localTextView == null))
              {
                AppMethodBeat.o(205056);
                return;
              }
              localTextView.setText(localActivity.getString(2131766888) + paramAnonymousInt + "%");
              AppMethodBeat.o(205056);
            }
            
            public final void afZ(int paramAnonymousInt)
            {
              AppMethodBeat.i(205057);
              Log.i("XFilesReaderXWeb", "onXWalkPluginUpdateCompleted errorCode = ".concat(String.valueOf(paramAnonymousInt)));
              h.fJd();
              f.gK(paramString2, paramAnonymousInt);
              Activity localActivity = (Activity)this.KyW.get();
              ViewGroup localViewGroup = (ViewGroup)paramViewGroup.get();
              TextView localTextView = (TextView)this.KyV.get();
              switch (paramAnonymousInt)
              {
              default: 
                if ((localActivity != null) && (!localActivity.isDestroyed()) && (localViewGroup != null) && (localTextView != null)) {
                  localTextView.setText(localActivity.getString(2131766887));
                }
                if (paramAnonymousInt == -1)
                {
                  Log.i("XFilesReaderXWeb", "onXWalkPluginUpdateCompleted, download cancel");
                  h.b(paramString2, paramValueCallback, -15);
                  AppMethodBeat.o(205057);
                  return;
                }
                break;
              case 0: 
                if ((localActivity != null) && (!localActivity.isDestroyed()) && (localViewGroup != null) && (localTextView != null))
                {
                  Log.i("XFilesReaderXWeb", "onXWalkPluginUpdateCompleted, download success, start read file");
                  localTextView.setVisibility(8);
                  h.b(this.KyY, paramString1, paramString2, paramString3, localActivity, localViewGroup, paramValueCallback);
                  AppMethodBeat.o(205057);
                  return;
                }
                Log.e("XFilesReaderXWeb", "onXWalkPluginUpdateCompleted, download success, view destroyed, return");
                h.b(paramString2, paramValueCallback, -14);
                AppMethodBeat.o(205057);
                return;
              }
              Log.i("XFilesReaderXWeb", "onXWalkPluginUpdateCompleted, download failed");
              h.b(paramString2, paramValueCallback, -16);
              AppMethodBeat.o(205057);
            }
            
            public final void fJe()
            {
              AppMethodBeat.i(205055);
              Object localObject1 = (Activity)this.KyW.get();
              Object localObject2 = (ViewGroup)paramViewGroup.get();
              if ((localObject1 == null) || (((Activity)localObject1).isDestroyed()) || (localObject2 == null))
              {
                Log.e("XFilesReaderXWeb", "onXWalkPluginUpdateStarted view destroyed");
                AppMethodBeat.o(205055);
                return;
              }
              RelativeLayout localRelativeLayout = null;
              int i = 0;
              if (i < ((ViewGroup)localObject2).getChildCount())
              {
                View localView = ((ViewGroup)localObject2).getChildAt(i);
                if (localView == null) {
                  break label239;
                }
                Object localObject3 = localView.getTag();
                if ((!(localObject3 instanceof String)) || (!"view_tag_relative_layout".equalsIgnoreCase((String)localObject3))) {
                  break label239;
                }
                localRelativeLayout = (RelativeLayout)localView;
              }
              label239:
              for (;;)
              {
                i += 1;
                break;
                if (localRelativeLayout == null)
                {
                  Log.e("XFilesReaderXWeb", "onXWalkPluginUpdateStarted layout is null");
                  AppMethodBeat.o(205055);
                  return;
                }
                localObject2 = new TextView((Context)localObject1);
                ((TextView)localObject2).setText(((Activity)localObject1).getString(2131766888) + "0%");
                ((TextView)localObject2).setTextSize(14.0F);
                ((TextView)localObject2).setTextColor(-1140850689);
                localObject1 = new RelativeLayout.LayoutParams(-2, -2);
                ((RelativeLayout.LayoutParams)localObject1).addRule(13, -1);
                localRelativeLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
                this.KyV = new WeakReference(localObject2);
                AppMethodBeat.o(205055);
                return;
              }
            }
          });
          paramString1 = new HashMap();
          paramString1.put("UpdaterCheckType", "1");
          KyU.a(com.tencent.mm.sdk.platformtools.ai.getContext(), paramString1);
          i = 1;
        }
      }
    }
    a((l)localObject1, paramString1, paramString2, paramString3, paramActivity, paramViewGroup, paramValueCallback);
    AppMethodBeat.o(205058);
  }
  
  public static void mB(String paramString1, String paramString2)
  {
    AppMethodBeat.i(156757);
    Object localObject;
    try
    {
      if (KyU != null)
      {
        Log.i("XFilesReaderXWeb", "finishReadFile pre updater exist, cancel it");
        KyU.fJr();
        KyU = null;
      }
      localObject = (String)KyT.get(paramString1 + paramString2);
      if (localObject == null)
      {
        AppMethodBeat.o(156757);
        return;
      }
      KyT.remove(paramString1 + paramString2);
      com.tencent.xweb.xwalk.a.f localf = g.aUJ((String)localObject);
      if ((localf instanceof l))
      {
        Log.i("XFilesReaderXWeb", "finishReadFile ".concat(String.valueOf(localObject)));
        localObject = new HashMap();
        ((HashMap)localObject).put("file_path", paramString2);
        ((HashMap)localObject).put("token", paramString1);
        ((l)localf).q((HashMap)localObject);
        AppMethodBeat.o(156757);
        return;
      }
    }
    catch (Exception paramString1)
    {
      Log.e("XFilesReaderXWeb", "finishReadFile error: " + paramString1.getMessage());
      AppMethodBeat.o(156757);
      return;
    }
    Log.e("XFilesReaderXWeb", "finishReadFile unknown plugin: ".concat(String.valueOf(localObject)));
    AppMethodBeat.o(156757);
  }
  
  public static boolean n(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(205059);
    if ((paramBoolean1) && (e.aUI(paramString)))
    {
      Log.i("XFilesReaderXWeb", "isPluginAvailable recent crashed");
      AppMethodBeat.o(205059);
      return false;
    }
    com.tencent.xweb.xwalk.a.f localf = f.aUJ(paramString);
    if (!(localf instanceof l))
    {
      Log.i("XFilesReaderXWeb", "isPluginAvailable unSupport format".concat(String.valueOf(paramString)));
      AppMethodBeat.o(205059);
      return false;
    }
    paramString = (l)localf;
    int i = paramString.KHj;
    if ((i <= 0) || (i < paramString.fLM()))
    {
      if ((ai.fJV()) && (!localf.fLN()))
      {
        Log.i("XFilesReaderXWeb", "isPluginAvailable forbid download code");
        AppMethodBeat.o(205059);
        return false;
      }
      if (!paramBoolean2)
      {
        Log.i("XFilesReaderXWeb", "isPluginAvailable not installed, can not download");
        AppMethodBeat.o(205059);
        return false;
      }
      Log.i("XFilesReaderXWeb", "isPluginAvailable not installed, can download");
      AppMethodBeat.o(205059);
      return true;
    }
    Log.i("XFilesReaderXWeb", "isPluginAvailable has available version");
    AppMethodBeat.o(205059);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.h
 * JD-Core Version:    0.7.0.1
 */