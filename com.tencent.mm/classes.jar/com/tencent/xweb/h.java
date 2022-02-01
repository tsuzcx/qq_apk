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
  private static Map<String, String> Mpo;
  private static w.a Mpp;
  
  static
  {
    AppMethodBeat.i(156758);
    Mpo = new HashMap();
    Mpp = null;
    AppMethodBeat.o(156758);
  }
  
  private static void a(String paramString, int paramInt1, ValueCallback<Integer> paramValueCallback, int paramInt2)
  {
    AppMethodBeat.i(197070);
    f.bb(paramString, paramInt1, paramInt2);
    if (paramValueCallback != null) {
      paramValueCallback.onReceiveValue(Integer.valueOf(paramInt2));
    }
    AppMethodBeat.o(197070);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, Activity paramActivity, ViewGroup paramViewGroup, ValueCallback<Integer> paramValueCallback)
  {
    AppMethodBeat.i(197066);
    Object localObject2 = new StringBuilder("readFile by xweb, fileExt: ");
    if (paramString2 != null) {}
    for (Object localObject1 = paramString2;; localObject1 = "null")
    {
      Log.i("XFilesReaderXWeb", (String)localObject1);
      f.mY(paramString2, f.a.Mpj.name());
      localObject1 = f.baM(paramString2);
      if ((localObject1 instanceof l)) {
        break;
      }
      Log.e("XFilesReaderXWeb", "readFile unSupport format".concat(String.valueOf(paramString2)));
      a(paramString2, -1, paramValueCallback, -7);
      AppMethodBeat.o(197066);
      return;
    }
    localObject2 = (l)localObject1;
    int j = ((com.tencent.xweb.xwalk.a.f)localObject2).MxJ;
    if ((j <= 0) || (j < ((l)localObject2).gdh()))
    {
      if ((ai.gbp()) && (!((com.tencent.xweb.xwalk.a.f)localObject1).gdi()))
      {
        Log.i("XFilesReaderXWeb", "readFile forbid download code, return");
        a(paramString2, -1, paramValueCallback, -1);
        AppMethodBeat.o(197066);
        return;
      }
      if (!paramBoolean)
      {
        Log.i("XFilesReaderXWeb", "readFile plugin version: " + j + ", require: " + ((l)localObject2).gdh() + ", canDownload: false, return");
        if (j <= 0) {}
        for (int i = -2;; i = -11)
        {
          a(paramString2, j, paramValueCallback, i);
          AppMethodBeat.o(197066);
          return;
        }
      }
      Log.i("XFilesReaderXWeb", "readFile plugin version: " + j + ", require: " + ((l)localObject2).gdh() + ", canDownload: true, start download");
      f.baS(paramString2);
      if (!a((l)localObject2, paramString1, paramString2, paramString3, paramActivity, paramViewGroup, paramValueCallback))
      {
        f.baT(paramString2);
        a(paramString2, j, paramValueCallback, -16);
      }
      AppMethodBeat.o(197066);
      return;
    }
    b((l)localObject2, paramString1, paramString2, paramString3, paramActivity, paramViewGroup, paramValueCallback);
    AppMethodBeat.o(197066);
  }
  
  private static boolean a(final l paraml, final String paramString1, final String paramString2, final String paramString3, Activity paramActivity, final ViewGroup paramViewGroup, final ValueCallback<Integer> paramValueCallback)
  {
    AppMethodBeat.i(197068);
    if (Mpp != null)
    {
      Log.i("XFilesReaderXWeb", "startDownload pre updater not finish, cancel it");
      Mpp.gaL();
      Mpp = null;
    }
    Object localObject1 = j.g(WebView.c.Mqu);
    if (localObject1 == null)
    {
      Log.e("XFilesReaderXWeb", "startDownload webViewProvider is null");
      AppMethodBeat.o(197068);
      return false;
    }
    localObject1 = (w.a)((j.a)localObject1).excute("STR_CMD_GET_PLUGIN_UPDATER", null);
    Mpp = (w.a)localObject1;
    if (localObject1 == null)
    {
      Log.e("XFilesReaderXWeb", "startDownload updater is null");
      AppMethodBeat.o(197068);
      return false;
    }
    if ((paramActivity == null) || (paramActivity.isDestroyed()) || (paramViewGroup == null))
    {
      Log.e("XFilesReaderXWeb", "startDownload activity destroyed");
      AppMethodBeat.o(197068);
      return false;
    }
    localObject1 = null;
    int i = 0;
    Object localObject2;
    Object localObject3;
    if (i < paramViewGroup.getChildCount())
    {
      localObject2 = paramViewGroup.getChildAt(i);
      if (localObject2 == null) {
        break label408;
      }
      localObject3 = ((View)localObject2).getTag();
      if ((!(localObject3 instanceof String)) || (!"view_tag_relative_layout".equalsIgnoreCase((String)localObject3))) {
        break label408;
      }
      localObject1 = (RelativeLayout)localObject2;
    }
    label408:
    for (;;)
    {
      i += 1;
      break;
      if (localObject1 == null)
      {
        Log.e("XFilesReaderXWeb", "startDownload layout is null");
        AppMethodBeat.o(197068);
        return false;
      }
      localObject2 = new TextView(paramActivity);
      ((TextView)localObject2).setText(paramActivity.getString(2131766888) + "0%");
      ((TextView)localObject2).setTextSize(14.0F);
      ((TextView)localObject2).setTextColor(-1140850689);
      localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject3).addRule(13, -1);
      ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      paramActivity = new WeakReference(paramActivity);
      paramViewGroup = new WeakReference(paramViewGroup);
      localObject1 = new WeakReference(localObject2);
      Mpp.a(paraml.getPluginName(), new i()
      {
        public final void aiy(int paramAnonymousInt)
        {
          AppMethodBeat.i(197064);
          Log.i("XFilesReaderXWeb", "onXWalkPluginUpdateProgress ".concat(String.valueOf(paramAnonymousInt)));
          Activity localActivity = (Activity)this.Mpq.get();
          TextView localTextView = (TextView)this.Mpr.get();
          if ((localActivity == null) || (localActivity.isDestroyed()) || (localTextView == null))
          {
            AppMethodBeat.o(197064);
            return;
          }
          localTextView.setText(localActivity.getString(2131766888) + paramAnonymousInt + "%");
          AppMethodBeat.o(197064);
        }
        
        public final void aiz(int paramAnonymousInt)
        {
          AppMethodBeat.i(197065);
          Log.i("XFilesReaderXWeb", "onXWalkPluginUpdateCompleted errorCode = ".concat(String.valueOf(paramAnonymousInt)));
          h.gaz();
          f.hj(paramString2, paramAnonymousInt);
          Activity localActivity = (Activity)this.Mpq.get();
          ViewGroup localViewGroup = (ViewGroup)paramViewGroup.get();
          TextView localTextView = (TextView)this.Mpr.get();
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
              AppMethodBeat.o(197065);
              return;
            }
            break;
          case 0: 
            if ((localActivity != null) && (!localActivity.isDestroyed()) && (localViewGroup != null) && (localTextView != null))
            {
              Log.i("XFilesReaderXWeb", "onXWalkPluginUpdateCompleted, download success, start read file");
              localTextView.setVisibility(8);
              h.c(paraml, paramString1, paramString2, paramString3, localActivity, localViewGroup, paramValueCallback);
              AppMethodBeat.o(197065);
              return;
            }
            Log.e("XFilesReaderXWeb", "onXWalkPluginUpdateCompleted, download success, view destroyed, return");
            h.b(paramString2, paramValueCallback, -14);
            AppMethodBeat.o(197065);
            return;
          }
          Log.i("XFilesReaderXWeb", "onXWalkPluginUpdateCompleted, download failed");
          h.b(paramString2, paramValueCallback, -16);
          AppMethodBeat.o(197065);
        }
        
        public final void gaA()
        {
          AppMethodBeat.i(197063);
          Log.i("XFilesReaderXWeb", "onXWalkPluginUpdateStarted");
          AppMethodBeat.o(197063);
        }
      });
      paraml = new HashMap();
      paraml.put("UpdaterCheckType", "1");
      Mpp.a(XWalkEnvironment.getApplicationContext(), paraml);
      AppMethodBeat.o(197068);
      return true;
    }
  }
  
  private static void b(l paraml, String paramString1, String paramString2, String paramString3, Activity paramActivity, ViewGroup paramViewGroup, ValueCallback<Integer> paramValueCallback)
  {
    AppMethodBeat.i(197069);
    long l1 = System.currentTimeMillis();
    long l2 = f.lw(paramActivity);
    boolean bool2;
    Object localObject1;
    boolean bool1;
    if (y.gaM() != null)
    {
      bool2 = y.gaM().gaN();
      localObject1 = y.gaM().MpR.getSharedPreferences("wcwebview", 4);
      if (localObject1 == null) {
        bool1 = true;
      }
    }
    for (;;)
    {
      localObject1 = new HashMap();
      Object localObject2 = b.baI(paraml.getPluginName());
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
        Mpo.put(paramString3 + paramString1, paraml.getPluginName());
      }
      AppMethodBeat.o(197069);
      return;
      bool1 = true;
      bool2 = false;
    }
  }
  
  public static void mZ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(156757);
    Object localObject;
    try
    {
      if (Mpp != null)
      {
        Log.i("XFilesReaderXWeb", "finishReadFile pre updater exist, cancel it");
        Mpp.gaL();
        Mpp = null;
      }
      localObject = (String)Mpo.get(paramString1 + paramString2);
      if (localObject == null)
      {
        AppMethodBeat.o(156757);
        return;
      }
      Mpo.remove(paramString1 + paramString2);
      com.tencent.xweb.xwalk.a.f localf = g.baM((String)localObject);
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
  
  public static boolean p(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(197067);
    if ((paramBoolean1) && (e.baL(paramString)))
    {
      Log.i("XFilesReaderXWeb", "isPluginAvailable recent crashed");
      AppMethodBeat.o(197067);
      return false;
    }
    com.tencent.xweb.xwalk.a.f localf = f.baM(paramString);
    if (!(localf instanceof l))
    {
      Log.i("XFilesReaderXWeb", "isPluginAvailable unSupport format".concat(String.valueOf(paramString)));
      AppMethodBeat.o(197067);
      return false;
    }
    paramString = (l)localf;
    int i = paramString.MxJ;
    if ((i <= 0) || (i < paramString.gdh()))
    {
      if ((ai.gbp()) && (!localf.gdi()))
      {
        Log.i("XFilesReaderXWeb", "isPluginAvailable forbid download code");
        AppMethodBeat.o(197067);
        return false;
      }
      if (!paramBoolean2)
      {
        Log.i("XFilesReaderXWeb", "isPluginAvailable not installed, can not download");
        AppMethodBeat.o(197067);
        return false;
      }
      Log.i("XFilesReaderXWeb", "isPluginAvailable not installed, can download");
      AppMethodBeat.o(197067);
      return true;
    }
    Log.i("XFilesReaderXWeb", "isPluginAvailable has available version");
    AppMethodBeat.o(197067);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.h
 * JD-Core Version:    0.7.0.1
 */