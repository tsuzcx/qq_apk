package com.tencent.xweb;

import android.app.Activity;
import android.graphics.Bitmap;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.webkit.ValueCallback;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.i.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.internal.WebViewWrapperFactory;
import com.tencent.xweb.internal.WebViewWrapperFactory.IWebViewProvider;
import com.tencent.xweb.xwalk.a.i;
import com.tencent.xweb.xwalk.a.k;
import com.tencent.xweb.xwalk.a.n;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public final class j
{
  private static Map<String, String> aieD;
  private static y.a aieE;
  
  static
  {
    AppMethodBeat.i(156758);
    aieD = new HashMap();
    aieE = null;
    AppMethodBeat.o(156758);
  }
  
  private static void a(n paramn, String paramString1, String paramString2, String paramString3, HashMap<String, String> paramHashMap, c paramc, Activity paramActivity, ViewGroup paramViewGroup, a parama, ValueCallback<Integer> paramValueCallback)
  {
    AppMethodBeat.i(212398);
    long l1 = System.currentTimeMillis();
    long l2 = h.oO(paramActivity);
    boolean bool2;
    boolean bool1;
    if (aa.kfE() != null)
    {
      aa.kfE();
      bool2 = aa.kfF();
      aa.kfE();
      bool1 = aa.kfG();
    }
    for (;;)
    {
      HashMap localHashMap = new HashMap();
      Map.Entry localEntry;
      if (paramHashMap != null)
      {
        paramHashMap = paramHashMap.entrySet().iterator();
        while (paramHashMap.hasNext())
        {
          localEntry = (Map.Entry)paramHashMap.next();
          if ((localEntry != null) && (localEntry.getKey() != null) && (!((String)localEntry.getKey()).isEmpty()) && (localEntry.getValue() != null) && (!((String)localEntry.getValue()).isEmpty())) {
            localHashMap.put((String)localEntry.getKey(), (String)localEntry.getValue());
          }
        }
      }
      paramHashMap = b.kfi().bHn(paramn.kjs());
      if (paramHashMap != null)
      {
        paramHashMap = paramHashMap.entrySet().iterator();
        while (paramHashMap.hasNext())
        {
          localEntry = (Map.Entry)paramHashMap.next();
          if ((localEntry != null) && (localEntry.getKey() != null) && (!((String)localEntry.getKey()).isEmpty()) && (localEntry.getValue() != null) && (!((String)localEntry.getValue()).isEmpty())) {
            localHashMap.put("config_param_" + (String)localEntry.getKey(), (String)localEntry.getValue());
          }
        }
      }
      localHashMap.put("dark_mode", String.valueOf(XWalkEnvironment.getForceDarkMode()));
      localHashMap.put("disable_cache", String.valueOf(bool2));
      localHashMap.put("disable_encry", String.valueOf(bool1));
      localHashMap.put("file_path", paramString1);
      localHashMap.put("file_ext", paramString2);
      localHashMap.put("token", paramString3);
      localHashMap.put("time_start", String.valueOf(l1));
      localHashMap.put("memory_start", String.valueOf(l2));
      localHashMap.put("str_password_title", paramActivity.getString(a.a.xweb_file_reader_password_title));
      localHashMap.put("str_password_wrong", paramActivity.getString(a.a.xweb_file_reader_password_wrong));
      localHashMap.put("str_password_hint", paramActivity.getString(a.a.xweb_file_reader_password_hint));
      localHashMap.put("str_button_confirm", paramActivity.getString(a.a.xweb_file_reader_button_confirm));
      localHashMap.put("str_button_cancel", paramActivity.getString(a.a.xweb_file_reader_button_cancel));
      localHashMap.put("str_operation_copy", paramActivity.getString(a.a.xweb_file_reader_operation_copy));
      localHashMap.put("str_hint_copied", paramActivity.getString(a.a.xweb_file_reader_hint_copied));
      switch (3.aieN[paramc.ordinal()])
      {
      default: 
        localHashMap.put("view_type", "view_type_list");
        if (parama == null) {
          break;
        }
      }
      for (bool1 = paramn.a(localHashMap, paramActivity, paramViewGroup, new ValueCallback() {}, paramValueCallback);; bool1 = paramn.a(localHashMap, paramActivity, paramViewGroup, null, paramValueCallback))
      {
        if (bool1) {
          aieD.put(paramString3 + paramString1, paramn.kjs());
        }
        AppMethodBeat.o(212398);
        return;
        localHashMap.put("view_type", "view_type_reader");
        break;
      }
      bool1 = true;
      bool2 = false;
    }
  }
  
  private static void a(String paramString, int paramInt1, ValueCallback<Integer> paramValueCallback, int paramInt2)
  {
    AppMethodBeat.i(212454);
    h.bl(paramString, paramInt1, paramInt2);
    if (paramValueCallback != null) {
      paramValueCallback.onReceiveValue(Integer.valueOf(paramInt2));
    }
    AppMethodBeat.o(212454);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, c paramc, Activity paramActivity, ViewGroup paramViewGroup, a parama, ValueCallback<Integer> paramValueCallback)
  {
    AppMethodBeat.i(212379);
    a(paramString1, paramString2, paramString3, paramBoolean, null, paramc, paramActivity, paramViewGroup, parama, paramValueCallback);
    AppMethodBeat.o(212379);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, HashMap<String, String> paramHashMap, c paramc, Activity paramActivity, ViewGroup paramViewGroup, a parama, ValueCallback<Integer> paramValueCallback)
  {
    AppMethodBeat.i(212382);
    Object localObject2 = new StringBuilder("readFile by xweb, fileExt: ");
    if (paramString2 != null) {}
    for (Object localObject1 = paramString2;; localObject1 = "null")
    {
      Log.i("FileReaderXWeb", (String)localObject1);
      h.qR(paramString2, h.a.aieu.name());
      localObject1 = h.bHs(paramString2);
      if ((localObject1 instanceof n)) {
        break;
      }
      Log.e("FileReaderXWeb", "readFile unSupport format".concat(String.valueOf(paramString2)));
      a(paramString2, -1, paramValueCallback, -7);
      AppMethodBeat.o(212382);
      return;
    }
    localObject2 = (n)localObject1;
    int j = ((n)localObject2).kjy();
    if (parama != null) {}
    for (int i = 1;; i = 0)
    {
      i = ((n)localObject2).aJL(i);
      if ((j > 0) && (j >= i)) {
        break label360;
      }
      if ((!ak.kgd()) || (((com.tencent.xweb.xwalk.a.g)localObject1).kjw())) {
        break;
      }
      Log.i("FileReaderXWeb", "readFile forbid download code, return");
      a(paramString2, -1, paramValueCallback, -1);
      AppMethodBeat.o(212382);
      return;
    }
    if (!paramBoolean)
    {
      Log.i("FileReaderXWeb", "readFile plugin version: " + j + ", require: " + i + ", canDownload: false, return");
      if (j <= 0) {}
      for (i = -2;; i = -11)
      {
        a(paramString2, j, paramValueCallback, i);
        AppMethodBeat.o(212382);
        return;
      }
    }
    Log.i("FileReaderXWeb", "readFile plugin version: " + j + ", require: " + i + ", canDownload: true, start download");
    h.bHy(paramString2);
    if (!a((n)localObject2, paramString1, paramString2, paramString3, paramBoolean, paramHashMap, paramc, paramActivity, paramViewGroup, parama, paramValueCallback))
    {
      h.bHz(paramString2);
      a(paramString2, j, paramValueCallback, -16);
    }
    AppMethodBeat.o(212382);
    return;
    label360:
    a((n)localObject2, paramString1, paramString2, paramString3, paramHashMap, paramc, paramActivity, paramViewGroup, parama, paramValueCallback);
    AppMethodBeat.o(212382);
  }
  
  private static boolean a(final n paramn, final String paramString1, final String paramString2, final String paramString3, final boolean paramBoolean, final HashMap<String, String> paramHashMap, final c paramc, Activity paramActivity, final ViewGroup paramViewGroup, final a parama, final ValueCallback<Integer> paramValueCallback)
  {
    AppMethodBeat.i(212391);
    if (aieE != null)
    {
      Log.i("FileReaderXWeb", "startDownload pre updater not finish, cancel it");
      aieE.kfB();
      aieE = null;
    }
    Object localObject1 = WebViewWrapperFactory.khn();
    if (localObject1 == null)
    {
      Log.e("FileReaderXWeb", "startDownload webViewProvider is null");
      AppMethodBeat.o(212391);
      return false;
    }
    localObject1 = (y.a)((WebViewWrapperFactory.IWebViewProvider)localObject1).excute("STR_CMD_GET_PLUGIN_UPDATER", null);
    aieE = (y.a)localObject1;
    if (localObject1 == null)
    {
      Log.e("FileReaderXWeb", "startDownload updater is null");
      AppMethodBeat.o(212391);
      return false;
    }
    if ((paramActivity == null) || (paramActivity.isDestroyed()) || (paramViewGroup == null))
    {
      Log.e("FileReaderXWeb", "startDownload activity destroyed");
      AppMethodBeat.o(212391);
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
        break label497;
      }
      localObject3 = ((View)localObject2).getTag();
      if ((!(localObject3 instanceof String)) || (!"view_tag_relative_layout".equalsIgnoreCase((String)localObject3))) {
        break label497;
      }
      localObject1 = (RelativeLayout)localObject2;
    }
    label497:
    for (;;)
    {
      i += 1;
      break;
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        if ((paramViewGroup instanceof RelativeLayout)) {
          localObject2 = (RelativeLayout)paramViewGroup;
        }
      }
      else
      {
        localObject1 = null;
        if (paramHashMap != null) {
          localObject1 = bHA((String)paramHashMap.get("extra_param_download_text_color"));
        }
        localObject3 = localObject1;
        if (localObject1 == null) {
          localObject3 = Integer.valueOf(-1140850689);
        }
        localObject1 = new TextView(paramActivity);
        ((TextView)localObject1).setText(paramActivity.getString(a.a.xweb_file_reader_plugin_downloading) + "0%");
        ((TextView)localObject1).setTextSize(14.0F);
        ((TextView)localObject1).setTextColor(((Integer)localObject3).intValue());
        localObject3 = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject3).addRule(13, -1);
        ((RelativeLayout)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
        paramActivity = new WeakReference(paramActivity);
        paramViewGroup = new WeakReference(paramViewGroup);
        localObject1 = new WeakReference(localObject1);
        aieE.a(paramn.kjs(), new k()
        {
          public final void aJu(int paramAnonymousInt)
          {
            AppMethodBeat.i(212468);
            Log.i("FileReaderXWeb", "onXWalkPluginUpdateProgress ".concat(String.valueOf(paramAnonymousInt)));
            Activity localActivity = (Activity)j.this.get();
            TextView localTextView = (TextView)this.aieG.get();
            if ((localActivity == null) || (localActivity.isDestroyed()) || (localTextView == null))
            {
              AppMethodBeat.o(212468);
              return;
            }
            localTextView.setText(localActivity.getString(a.a.xweb_file_reader_plugin_downloading) + paramAnonymousInt + "%");
            AppMethodBeat.o(212468);
          }
          
          public final void aJv(int paramAnonymousInt)
          {
            AppMethodBeat.i(212477);
            Log.i("FileReaderXWeb", "onXWalkPluginUpdateCompleted errorCode = ".concat(String.valueOf(paramAnonymousInt)));
            j.kfr();
            h.jJ(paramString2, paramAnonymousInt);
            Activity localActivity = (Activity)j.this.get();
            ViewGroup localViewGroup = (ViewGroup)paramViewGroup.get();
            TextView localTextView = (TextView)this.aieG.get();
            switch (paramAnonymousInt)
            {
            default: 
              if ((localActivity != null) && (!localActivity.isDestroyed()) && (localViewGroup != null) && (localTextView != null)) {
                localTextView.setText(localActivity.getString(a.a.xweb_file_reader_plugin_download_failed));
              }
              if (paramAnonymousInt == -1)
              {
                Log.i("FileReaderXWeb", "onXWalkPluginUpdateCompleted, download cancel");
                j.b(paramString2, paramValueCallback, -15);
                AppMethodBeat.o(212477);
                return;
              }
              break;
            case 0: 
              if ((localActivity != null) && (!localActivity.isDestroyed()) && (localViewGroup != null) && (localTextView != null))
              {
                Log.i("FileReaderXWeb", "onXWalkPluginUpdateCompleted, download success, start read file");
                localTextView.setVisibility(8);
                j.b(paramn, paramString1, paramString2, paramString3, paramHashMap, paramc, localActivity, localViewGroup, parama, paramValueCallback);
                AppMethodBeat.o(212477);
                return;
              }
              Log.e("FileReaderXWeb", "onXWalkPluginUpdateCompleted, download success, view destroyed, return");
              j.b(paramString2, paramValueCallback, -14);
              AppMethodBeat.o(212477);
              return;
            }
            Log.i("FileReaderXWeb", "onXWalkPluginUpdateCompleted, download failed");
            j.b(paramString2, paramValueCallback, -16);
            AppMethodBeat.o(212477);
          }
          
          public final void kfs()
          {
            AppMethodBeat.i(212459);
            Log.i("FileReaderXWeb", "onXWalkPluginUpdateStarted");
            AppMethodBeat.o(212459);
          }
        });
        paramn = new HashMap();
        paramn.put("UpdaterCheckType", "1");
        aieE.b(XWalkEnvironment.getApplicationContext(), paramn);
        AppMethodBeat.o(212391);
        return true;
      }
      Log.e("FileReaderXWeb", "startDownload layout is null");
      AppMethodBeat.o(212391);
      return false;
    }
  }
  
  public static boolean aV(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(212412);
    if (paramString1 != null) {}
    try
    {
      if ((paramString1.isEmpty()) || (paramString2 == null) || (paramString2.isEmpty()))
      {
        Log.e("FileReaderXWeb", "setViewToStatus error, invalid param");
        AppMethodBeat.o(212412);
        return false;
      }
      Object localObject = (String)aieD.get(paramString1 + paramString2);
      if (localObject == null)
      {
        Log.e("FileReaderXWeb", "setViewToStatus error, not reading");
        AppMethodBeat.o(212412);
        return false;
      }
      paramString2 = i.bHs((String)localObject);
      if ((paramString2 instanceof n))
      {
        localObject = new HashMap();
        ((HashMap)localObject).put("token", paramString1);
        ((HashMap)localObject).put("set_index", Integer.valueOf(paramInt));
        ((HashMap)localObject).put("set_zoom", Float.valueOf(1.0F));
        ((HashMap)localObject).put("set_x", Integer.valueOf(0));
        ((HashMap)localObject).put("set_y", Integer.valueOf(0));
        boolean bool = ((n)paramString2).E((HashMap)localObject);
        AppMethodBeat.o(212412);
        return bool;
      }
      return false;
    }
    finally
    {
      Log.e("FileReaderXWeb", "setViewToStatus error:".concat(String.valueOf(paramString1)));
      AppMethodBeat.o(212412);
    }
    return false;
  }
  
  public static boolean aW(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(212419);
    if (paramString1 != null) {}
    try
    {
      if ((paramString1.isEmpty()) || (paramString2 == null) || (paramString2.isEmpty()) || (paramInt < 0))
      {
        Log.e("FileReaderXWeb", "requestThumbnail error, invalid param");
        AppMethodBeat.o(212419);
        return false;
      }
      Object localObject = (String)aieD.get(paramString1 + paramString2);
      if (localObject == null)
      {
        Log.e("FileReaderXWeb", "requestThumbnail error, not reading");
        AppMethodBeat.o(212419);
        return false;
      }
      paramString2 = i.bHs((String)localObject);
      if ((paramString2 instanceof n))
      {
        localObject = new HashMap();
        ((HashMap)localObject).put("token", paramString1);
        ((HashMap)localObject).put("thumbnail_index", Integer.valueOf(paramInt));
        boolean bool = ((n)paramString2).F((HashMap)localObject);
        AppMethodBeat.o(212419);
        return bool;
      }
      return false;
    }
    finally
    {
      Log.e("FileReaderXWeb", "requestThumbnail error:".concat(String.valueOf(paramString1)));
      AppMethodBeat.o(212419);
    }
    return false;
  }
  
  public static boolean b(String paramString1, String paramString2, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(212425);
    if (paramString1 != null) {}
    Object localObject;
    try
    {
      if ((paramString1.isEmpty()) || (paramString2 == null) || (paramString2.isEmpty()) || (paramMotionEvent == null))
      {
        Log.e("FileReaderXWeb", "setTouchEvent error, invalid param");
        AppMethodBeat.o(212425);
        return false;
      }
      localObject = (String)aieD.get(paramString1 + paramString2);
      if (localObject == null)
      {
        Log.e("FileReaderXWeb", "setTouchEvent error, not reading");
        AppMethodBeat.o(212425);
        return false;
      }
      paramString2 = i.bHs((String)localObject);
      if (!(paramString2 instanceof n)) {
        break label221;
      }
      localObject = new HashMap();
      ((HashMap)localObject).put("token", paramString1);
      ((HashMap)localObject).put("gi_name", "gi_setTouchEvent");
      ((HashMap)localObject).put("gi_touchEvent", paramMotionEvent);
      paramString1 = ((n)paramString2).G((HashMap)localObject);
      if ((paramString1 instanceof Boolean))
      {
        boolean bool = ((Boolean)paramString1).booleanValue();
        AppMethodBeat.o(212425);
        return bool;
      }
    }
    finally
    {
      Log.e("FileReaderXWeb", "setTouchEvent error:".concat(String.valueOf(paramString1)));
      AppMethodBeat.o(212425);
      return false;
    }
    AppMethodBeat.o(212425);
    return false;
    label221:
    Log.e("FileReaderXWeb", "setTouchEvent error, unknown plugin: ".concat(String.valueOf(localObject)));
    AppMethodBeat.o(212425);
    return false;
  }
  
  private static Integer bHA(String paramString)
  {
    AppMethodBeat.i(212449);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(212449);
      return null;
    }
    try
    {
      int i = Integer.parseInt(paramString);
      AppMethodBeat.o(212449);
      return Integer.valueOf(i);
    }
    finally
    {
      Log.e("FileReaderXWeb", "parseInteger error:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(212449);
    }
    return null;
  }
  
  private static Integer d(HashMap<String, Object> paramHashMap, String paramString)
  {
    AppMethodBeat.i(212430);
    if (paramHashMap == null)
    {
      Log.e("FileReaderXWeb", "getIntegerFromParams params is null");
      AppMethodBeat.o(212430);
      return null;
    }
    try
    {
      paramHashMap = paramHashMap.get(paramString);
      if ((paramHashMap instanceof Integer))
      {
        paramHashMap = (Integer)paramHashMap;
        AppMethodBeat.o(212430);
        return paramHashMap;
      }
      return null;
    }
    finally
    {
      Log.e("FileReaderXWeb", "getIntegerFromParams error:".concat(String.valueOf(paramHashMap)));
      AppMethodBeat.o(212430);
    }
    return null;
  }
  
  private static Float e(HashMap<String, Object> paramHashMap, String paramString)
  {
    AppMethodBeat.i(212434);
    if (paramHashMap == null)
    {
      Log.e("FileReaderXWeb", "getFloatFromParams params is null");
      AppMethodBeat.o(212434);
      return null;
    }
    try
    {
      paramHashMap = paramHashMap.get(paramString);
      if ((paramHashMap instanceof Float))
      {
        paramHashMap = (Float)paramHashMap;
        AppMethodBeat.o(212434);
        return paramHashMap;
      }
      return null;
    }
    finally
    {
      Log.e("FileReaderXWeb", "getFloatFromParams error:".concat(String.valueOf(paramHashMap)));
      AppMethodBeat.o(212434);
    }
    return null;
  }
  
  private static Bitmap f(HashMap<String, Object> paramHashMap, String paramString)
  {
    AppMethodBeat.i(212441);
    if (paramHashMap == null)
    {
      Log.e("FileReaderXWeb", "getBitmapFromParams params is null");
      AppMethodBeat.o(212441);
      return null;
    }
    try
    {
      paramHashMap = paramHashMap.get(paramString);
      if ((paramHashMap instanceof Bitmap))
      {
        paramHashMap = (Bitmap)paramHashMap;
        AppMethodBeat.o(212441);
        return paramHashMap;
      }
      return null;
    }
    finally
    {
      Log.e("FileReaderXWeb", "getBitmapFromParams error:".concat(String.valueOf(paramHashMap)));
      AppMethodBeat.o(212441);
    }
    return null;
  }
  
  private static MotionEvent g(HashMap<String, Object> paramHashMap, String paramString)
  {
    AppMethodBeat.i(212444);
    if (paramHashMap == null)
    {
      Log.e("FileReaderXWeb", "getMotionEventFromParams params is null");
      AppMethodBeat.o(212444);
      return null;
    }
    try
    {
      paramHashMap = paramHashMap.get(paramString);
      if ((paramHashMap instanceof MotionEvent))
      {
        paramHashMap = (MotionEvent)paramHashMap;
        AppMethodBeat.o(212444);
        return paramHashMap;
      }
      return null;
    }
    finally
    {
      Log.e("FileReaderXWeb", "getMotionEventFromParams error:".concat(String.valueOf(paramHashMap)));
      AppMethodBeat.o(212444);
    }
    return null;
  }
  
  public static void qS(String paramString1, String paramString2)
  {
    AppMethodBeat.i(156757);
    Object localObject;
    try
    {
      if (aieE != null)
      {
        Log.i("FileReaderXWeb", "finishReadFile pre updater exist, cancel it");
        aieE.kfB();
        aieE = null;
      }
      localObject = (String)aieD.get(paramString1 + paramString2);
      if (localObject == null)
      {
        AppMethodBeat.o(156757);
        return;
      }
      aieD.remove(paramString1 + paramString2);
      com.tencent.xweb.xwalk.a.g localg = i.bHs((String)localObject);
      if ((localg instanceof n))
      {
        Log.i("FileReaderXWeb", "finishReadFile ".concat(String.valueOf(localObject)));
        localObject = new HashMap();
        ((HashMap)localObject).put("file_path", paramString2);
        ((HashMap)localObject).put("token", paramString1);
        ((n)localg).C((HashMap)localObject);
        AppMethodBeat.o(156757);
        return;
      }
    }
    finally
    {
      Log.e("FileReaderXWeb", "finishReadFile error:".concat(String.valueOf(paramString1)));
      AppMethodBeat.o(156757);
      return;
    }
    Log.e("FileReaderXWeb", "finishReadFile unknown plugin: ".concat(String.valueOf(localObject)));
    AppMethodBeat.o(156757);
  }
  
  public static b qT(String paramString1, String paramString2)
  {
    AppMethodBeat.i(212406);
    if (paramString1 != null) {}
    try
    {
      if ((paramString1.isEmpty()) || (paramString2 == null) || (paramString2.isEmpty()))
      {
        Log.e("FileReaderXWeb", "getViewStatus error, invalid param");
        AppMethodBeat.o(212406);
        return null;
      }
      Object localObject = (String)aieD.get(paramString1 + paramString2);
      if (localObject == null)
      {
        Log.e("FileReaderXWeb", "getViewStatus error, not reading");
        AppMethodBeat.o(212406);
        return null;
      }
      paramString2 = i.bHs((String)localObject);
      if ((paramString2 instanceof n))
      {
        localObject = new HashMap();
        ((HashMap)localObject).put("token", paramString1);
        paramString1 = ((n)paramString2).D((HashMap)localObject);
        AppMethodBeat.o(212406);
        return paramString1;
      }
      return null;
    }
    finally
    {
      Log.e("FileReaderXWeb", "getViewStatus error:".concat(String.valueOf(paramString1)));
      AppMethodBeat.o(212406);
    }
    return null;
  }
  
  public static boolean w(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(212385);
    if ((paramBoolean1) && (g.bHq(paramString)))
    {
      Log.i("FileReaderXWeb", "isPluginAvailable recent crashed");
      AppMethodBeat.o(212385);
      return false;
    }
    com.tencent.xweb.xwalk.a.g localg = h.bHs(paramString);
    if (!(localg instanceof n))
    {
      Log.i("FileReaderXWeb", "isPluginAvailable unSupport format".concat(String.valueOf(paramString)));
      AppMethodBeat.o(212385);
      return false;
    }
    paramString = (n)localg;
    int i = paramString.kjy();
    int j = paramString.aJL(0);
    if ((i <= 0) || (i < j))
    {
      if ((ak.kgd()) && (!localg.kjw()))
      {
        Log.i("FileReaderXWeb", "isPluginAvailable forbid download code");
        AppMethodBeat.o(212385);
        return false;
      }
      if (!paramBoolean2)
      {
        Log.i("FileReaderXWeb", "isPluginAvailable not installed, can not download");
        AppMethodBeat.o(212385);
        return false;
      }
      Log.i("FileReaderXWeb", "isPluginAvailable not installed, can download");
      AppMethodBeat.o(212385);
      return true;
    }
    Log.i("FileReaderXWeb", "isPluginAvailable has available version");
    AppMethodBeat.o(212385);
    return true;
  }
  
  public static abstract interface a
  {
    public abstract void Pc(int paramInt);
    
    public abstract void a(int paramInt1, float paramFloat, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
    
    public abstract void ay(int paramInt1, int paramInt2, int paramInt3);
    
    public abstract void bSt();
    
    public abstract void c(int paramInt, Bitmap paramBitmap);
    
    public abstract void erQ();
    
    public abstract void erR();
    
    public abstract void erS();
  }
  
  public static class b
  {
    public int aieO;
    public int aieP;
    public int index;
    public float zoom;
    
    public b(int paramInt1, float paramFloat, int paramInt2, int paramInt3)
    {
      this.index = paramInt1;
      this.zoom = paramFloat;
      this.aieO = paramInt2;
      this.aieP = paramInt3;
    }
  }
  
  public static enum c
  {
    static
    {
      AppMethodBeat.i(212521);
      aieQ = new c("ListView", 0);
      aieR = new c("ReaderView", 1);
      aieS = new c[] { aieQ, aieR };
      AppMethodBeat.o(212521);
    }
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.j
 * JD-Core Version:    0.7.0.1
 */