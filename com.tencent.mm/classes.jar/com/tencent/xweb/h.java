package com.tencent.xweb;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.internal.l;
import com.tencent.xweb.internal.l.a;
import com.tencent.xweb.xwalk.a.g;
import com.tencent.xweb.xwalk.a.j;
import com.tencent.xweb.xwalk.a.m;
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
  private static Map<String, String> Szd;
  private static w.a Sze;
  
  static
  {
    AppMethodBeat.i(156758);
    Szd = new HashMap();
    Sze = null;
    AppMethodBeat.o(156758);
  }
  
  private static void a(m paramm, String paramString1, String paramString2, String paramString3, HashMap<String, String> paramHashMap, c paramc, Activity paramActivity, ViewGroup paramViewGroup, a parama, ValueCallback<Integer> paramValueCallback)
  {
    AppMethodBeat.i(219024);
    long l1 = System.currentTimeMillis();
    long l2 = f.lB(paramActivity);
    boolean bool2;
    Object localObject;
    boolean bool1;
    if (y.hsF() != null)
    {
      bool2 = y.hsF().hsG();
      localObject = y.hsF().SzQ.getSharedPreferences("wcwebview", 4);
      if (localObject == null) {
        bool1 = true;
      }
    }
    for (;;)
    {
      localObject = new HashMap();
      Map.Entry localEntry;
      if (paramHashMap != null)
      {
        paramHashMap = paramHashMap.entrySet().iterator();
        for (;;)
        {
          if (paramHashMap.hasNext())
          {
            localEntry = (Map.Entry)paramHashMap.next();
            if ((localEntry != null) && (localEntry.getKey() != null) && (!((String)localEntry.getKey()).isEmpty()) && (localEntry.getValue() != null) && (!((String)localEntry.getValue()).isEmpty()))
            {
              ((HashMap)localObject).put(localEntry.getKey(), localEntry.getValue());
              continue;
              bool1 = ((SharedPreferences)localObject).getBoolean("fr_disable_encry", true);
              break;
            }
          }
        }
      }
      paramHashMap = b.brQ(paramm.getPluginName());
      if (paramHashMap != null)
      {
        paramHashMap = paramHashMap.entrySet().iterator();
        while (paramHashMap.hasNext())
        {
          localEntry = (Map.Entry)paramHashMap.next();
          if ((localEntry != null) && (localEntry.getKey() != null) && (!((String)localEntry.getKey()).isEmpty()) && (localEntry.getValue() != null) && (!((String)localEntry.getValue()).isEmpty())) {
            ((HashMap)localObject).put("config_param_" + (String)localEntry.getKey(), localEntry.getValue());
          }
        }
      }
      ((HashMap)localObject).put("dark_mode", String.valueOf(XWalkEnvironment.getForceDarkMode()));
      ((HashMap)localObject).put("disable_cache", String.valueOf(bool2));
      ((HashMap)localObject).put("disable_encry", String.valueOf(bool1));
      ((HashMap)localObject).put("file_path", paramString1);
      ((HashMap)localObject).put("file_ext", paramString2);
      ((HashMap)localObject).put("token", paramString3);
      ((HashMap)localObject).put("time_start", String.valueOf(l1));
      ((HashMap)localObject).put("memory_start", String.valueOf(l2));
      ((HashMap)localObject).put("str_password_title", paramActivity.getString(2131768884));
      ((HashMap)localObject).put("str_password_wrong", paramActivity.getString(2131768885));
      ((HashMap)localObject).put("str_password_hint", paramActivity.getString(2131768883));
      ((HashMap)localObject).put("str_button_confirm", paramActivity.getString(2131768880));
      ((HashMap)localObject).put("str_button_cancel", paramActivity.getString(2131768879));
      ((HashMap)localObject).put("str_operation_copy", paramActivity.getString(2131768882));
      ((HashMap)localObject).put("str_hint_copied", paramActivity.getString(2131768881));
      switch (3.Szn[paramc.ordinal()])
      {
      default: 
        ((HashMap)localObject).put("view_type", "view_type_list");
        if (parama == null) {
          break;
        }
      }
      for (bool1 = paramm.a((HashMap)localObject, paramActivity, paramViewGroup, new ValueCallback() {}, paramValueCallback);; bool1 = paramm.a((HashMap)localObject, paramActivity, paramViewGroup, null, paramValueCallback))
      {
        if (bool1) {
          Szd.put(paramString3 + paramString1, paramm.getPluginName());
        }
        AppMethodBeat.o(219024);
        return;
        ((HashMap)localObject).put("view_type", "view_type_reader");
        break;
      }
      bool1 = true;
      bool2 = false;
    }
  }
  
  private static void a(String paramString, int paramInt1, ValueCallback<Integer> paramValueCallback, int paramInt2)
  {
    AppMethodBeat.i(219034);
    f.aZ(paramString, paramInt1, paramInt2);
    if (paramValueCallback != null) {
      paramValueCallback.onReceiveValue(Integer.valueOf(paramInt2));
    }
    AppMethodBeat.o(219034);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, c paramc, Activity paramActivity, ViewGroup paramViewGroup, a parama, ValueCallback<Integer> paramValueCallback)
  {
    AppMethodBeat.i(219020);
    a(paramString1, paramString2, paramString3, paramBoolean, null, paramc, paramActivity, paramViewGroup, parama, paramValueCallback);
    AppMethodBeat.o(219020);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, HashMap<String, String> paramHashMap, c paramc, Activity paramActivity, ViewGroup paramViewGroup, a parama, ValueCallback<Integer> paramValueCallback)
  {
    AppMethodBeat.i(219021);
    Object localObject2 = new StringBuilder("readFile by xweb, fileExt: ");
    if (paramString2 != null) {}
    for (Object localObject1 = paramString2;; localObject1 = "null")
    {
      Log.i("XFilesReaderXWeb", (String)localObject1);
      f.nY(paramString2, f.a.SyU.name());
      localObject1 = f.brX(paramString2);
      if ((localObject1 instanceof m)) {
        break;
      }
      Log.e("XFilesReaderXWeb", "readFile unSupport format".concat(String.valueOf(paramString2)));
      a(paramString2, -1, paramValueCallback, -7);
      AppMethodBeat.o(219021);
      return;
    }
    localObject2 = (m)localObject1;
    int j = ((m)localObject2).hvk();
    if (parama != null) {}
    for (int i = 1;; i = 0)
    {
      i = ((m)localObject2).atb(i);
      if ((j > 0) && (j >= i)) {
        break label360;
      }
      if ((!ai.htj()) || (((g)localObject1).hvi())) {
        break;
      }
      Log.i("XFilesReaderXWeb", "readFile forbid download code, return");
      a(paramString2, -1, paramValueCallback, -1);
      AppMethodBeat.o(219021);
      return;
    }
    if (!paramBoolean)
    {
      Log.i("XFilesReaderXWeb", "readFile plugin version: " + j + ", require: " + i + ", canDownload: false, return");
      if (j <= 0) {}
      for (i = -2;; i = -11)
      {
        a(paramString2, j, paramValueCallback, i);
        AppMethodBeat.o(219021);
        return;
      }
    }
    Log.i("XFilesReaderXWeb", "readFile plugin version: " + j + ", require: " + i + ", canDownload: true, start download");
    f.bsd(paramString2);
    if (!a((m)localObject2, paramString1, paramString2, paramString3, paramBoolean, paramHashMap, paramc, paramActivity, paramViewGroup, parama, paramValueCallback))
    {
      f.bse(paramString2);
      a(paramString2, j, paramValueCallback, -16);
    }
    AppMethodBeat.o(219021);
    return;
    label360:
    a((m)localObject2, paramString1, paramString2, paramString3, paramHashMap, paramc, paramActivity, paramViewGroup, parama, paramValueCallback);
    AppMethodBeat.o(219021);
  }
  
  private static boolean a(final m paramm, final String paramString1, final String paramString2, final String paramString3, final boolean paramBoolean, final HashMap<String, String> paramHashMap, final c paramc, Activity paramActivity, final ViewGroup paramViewGroup, final a parama, final ValueCallback<Integer> paramValueCallback)
  {
    AppMethodBeat.i(219023);
    if (Sze != null)
    {
      Log.i("XFilesReaderXWeb", "startDownload pre updater not finish, cancel it");
      Sze.hsE();
      Sze = null;
    }
    Object localObject1 = l.g(WebView.c.SAt);
    if (localObject1 == null)
    {
      Log.e("XFilesReaderXWeb", "startDownload webViewProvider is null");
      AppMethodBeat.o(219023);
      return false;
    }
    localObject1 = (w.a)((l.a)localObject1).excute("STR_CMD_GET_PLUGIN_UPDATER", null);
    Sze = (w.a)localObject1;
    if (localObject1 == null)
    {
      Log.e("XFilesReaderXWeb", "startDownload updater is null");
      AppMethodBeat.o(219023);
      return false;
    }
    if ((paramActivity == null) || (paramActivity.isDestroyed()) || (paramViewGroup == null))
    {
      Log.e("XFilesReaderXWeb", "startDownload activity destroyed");
      AppMethodBeat.o(219023);
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
        break label500;
      }
      localObject3 = ((View)localObject2).getTag();
      if ((!(localObject3 instanceof String)) || (!"view_tag_relative_layout".equalsIgnoreCase((String)localObject3))) {
        break label500;
      }
      localObject1 = (RelativeLayout)localObject2;
    }
    label500:
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
          localObject1 = bsf((String)paramHashMap.get("extra_param_download_text_color"));
        }
        localObject3 = localObject1;
        if (localObject1 == null) {
          localObject3 = Integer.valueOf(-1140850689);
        }
        localObject1 = new TextView(paramActivity);
        ((TextView)localObject1).setText(paramActivity.getString(2131768887) + "0%");
        ((TextView)localObject1).setTextSize(14.0F);
        ((TextView)localObject1).setTextColor(((Integer)localObject3).intValue());
        localObject3 = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject3).addRule(13, -1);
        ((RelativeLayout)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
        paramActivity = new WeakReference(paramActivity);
        paramViewGroup = new WeakReference(paramViewGroup);
        localObject1 = new WeakReference(localObject1);
        Sze.a(paramm.getPluginName(), new j()
        {
          public final void asQ(int paramAnonymousInt)
          {
            AppMethodBeat.i(219013);
            Log.i("XFilesReaderXWeb", "onXWalkPluginUpdateProgress ".concat(String.valueOf(paramAnonymousInt)));
            Activity localActivity = (Activity)this.Szf.get();
            TextView localTextView = (TextView)this.Szg.get();
            if ((localActivity == null) || (localActivity.isDestroyed()) || (localTextView == null))
            {
              AppMethodBeat.o(219013);
              return;
            }
            localTextView.setText(localActivity.getString(2131768887) + paramAnonymousInt + "%");
            AppMethodBeat.o(219013);
          }
          
          public final void asR(int paramAnonymousInt)
          {
            AppMethodBeat.i(219014);
            Log.i("XFilesReaderXWeb", "onXWalkPluginUpdateCompleted errorCode = ".concat(String.valueOf(paramAnonymousInt)));
            h.hss();
            f.hO(paramString2, paramAnonymousInt);
            Activity localActivity = (Activity)this.Szf.get();
            ViewGroup localViewGroup = (ViewGroup)paramViewGroup.get();
            TextView localTextView = (TextView)this.Szg.get();
            switch (paramAnonymousInt)
            {
            default: 
              if ((localActivity != null) && (!localActivity.isDestroyed()) && (localViewGroup != null) && (localTextView != null)) {
                localTextView.setText(localActivity.getString(2131768886));
              }
              if (paramAnonymousInt == -1)
              {
                Log.i("XFilesReaderXWeb", "onXWalkPluginUpdateCompleted, download cancel");
                h.b(paramString2, paramValueCallback, -15);
                AppMethodBeat.o(219014);
                return;
              }
              break;
            case 0: 
              if ((localActivity != null) && (!localActivity.isDestroyed()) && (localViewGroup != null) && (localTextView != null))
              {
                Log.i("XFilesReaderXWeb", "onXWalkPluginUpdateCompleted, download success, start read file");
                localTextView.setVisibility(8);
                h.b(paramm, paramString1, paramString2, paramString3, paramHashMap, paramc, localActivity, localViewGroup, parama, paramValueCallback);
                AppMethodBeat.o(219014);
                return;
              }
              Log.e("XFilesReaderXWeb", "onXWalkPluginUpdateCompleted, download success, view destroyed, return");
              h.b(paramString2, paramValueCallback, -14);
              AppMethodBeat.o(219014);
              return;
            }
            Log.i("XFilesReaderXWeb", "onXWalkPluginUpdateCompleted, download failed");
            h.b(paramString2, paramValueCallback, -16);
            AppMethodBeat.o(219014);
          }
          
          public final void hst()
          {
            AppMethodBeat.i(219012);
            Log.i("XFilesReaderXWeb", "onXWalkPluginUpdateStarted");
            AppMethodBeat.o(219012);
          }
        });
        paramm = new HashMap();
        paramm.put("UpdaterCheckType", "1");
        Sze.b(XWalkEnvironment.getApplicationContext(), paramm);
        AppMethodBeat.o(219023);
        return true;
      }
      Log.e("XFilesReaderXWeb", "startDownload layout is null");
      AppMethodBeat.o(219023);
      return false;
    }
  }
  
  public static boolean aw(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(219026);
    if (paramString1 != null) {}
    try
    {
      if ((paramString1.isEmpty()) || (paramString2 == null) || (paramString2.isEmpty()))
      {
        Log.e("XFilesReaderXWeb", "setViewToStatus error, invalid param");
        AppMethodBeat.o(219026);
        return false;
      }
      Object localObject = (String)Szd.get(paramString1 + paramString2);
      if (localObject == null)
      {
        Log.e("XFilesReaderXWeb", "setViewToStatus error, not reading");
        AppMethodBeat.o(219026);
        return false;
      }
      paramString2 = com.tencent.xweb.xwalk.a.h.brX((String)localObject);
      if ((paramString2 instanceof m))
      {
        localObject = new HashMap();
        ((HashMap)localObject).put("token", paramString1);
        ((HashMap)localObject).put("set_index", Integer.valueOf(paramInt));
        ((HashMap)localObject).put("set_zoom", Float.valueOf(1.0F));
        ((HashMap)localObject).put("set_x", Integer.valueOf(0));
        ((HashMap)localObject).put("set_y", Integer.valueOf(0));
        boolean bool = ((m)paramString2).F((HashMap)localObject);
        AppMethodBeat.o(219026);
        return bool;
      }
      Log.e("XFilesReaderXWeb", "setViewToStatus error, unknown plugin: ".concat(String.valueOf(localObject)));
      AppMethodBeat.o(219026);
      return false;
    }
    catch (Exception paramString1)
    {
      Log.e("XFilesReaderXWeb", "setViewToStatus error: " + paramString1.getMessage());
      AppMethodBeat.o(219026);
    }
    return false;
  }
  
  public static boolean ax(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(219027);
    if (paramString1 != null) {}
    try
    {
      if ((paramString1.isEmpty()) || (paramString2 == null) || (paramString2.isEmpty()) || (paramInt < 0))
      {
        Log.e("XFilesReaderXWeb", "requestThumbnail error, invalid param");
        AppMethodBeat.o(219027);
        return false;
      }
      Object localObject = (String)Szd.get(paramString1 + paramString2);
      if (localObject == null)
      {
        Log.e("XFilesReaderXWeb", "requestThumbnail error, not reading");
        AppMethodBeat.o(219027);
        return false;
      }
      paramString2 = com.tencent.xweb.xwalk.a.h.brX((String)localObject);
      if ((paramString2 instanceof m))
      {
        localObject = new HashMap();
        ((HashMap)localObject).put("token", paramString1);
        ((HashMap)localObject).put("thumbnail_index", Integer.valueOf(paramInt));
        boolean bool = ((m)paramString2).G((HashMap)localObject);
        AppMethodBeat.o(219027);
        return bool;
      }
      Log.e("XFilesReaderXWeb", "requestThumbnail error, unknown plugin: ".concat(String.valueOf(localObject)));
      AppMethodBeat.o(219027);
      return false;
    }
    catch (Exception paramString1)
    {
      Log.e("XFilesReaderXWeb", "requestThumbnail error: " + paramString1.getMessage());
      AppMethodBeat.o(219027);
    }
    return false;
  }
  
  private static Integer b(HashMap<String, Object> paramHashMap, String paramString)
  {
    AppMethodBeat.i(219029);
    if (paramHashMap == null)
    {
      Log.e("XFilesReaderXWeb", "getIntegerFromParams params is null");
      AppMethodBeat.o(219029);
      return null;
    }
    try
    {
      paramHashMap = paramHashMap.get(paramString);
      if ((paramHashMap instanceof Integer))
      {
        paramHashMap = (Integer)paramHashMap;
        AppMethodBeat.o(219029);
        return paramHashMap;
      }
      Log.e("XFilesReaderXWeb", "getIntegerFromParams value is not integer, key: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(219029);
      return null;
    }
    catch (Exception paramHashMap)
    {
      Log.e("XFilesReaderXWeb", "getIntegerFromParams error: ", paramHashMap);
      AppMethodBeat.o(219029);
    }
    return null;
  }
  
  public static boolean b(String paramString1, String paramString2, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(219028);
    if (paramString1 != null) {}
    Object localObject;
    try
    {
      if ((paramString1.isEmpty()) || (paramString2 == null) || (paramString2.isEmpty()) || (paramMotionEvent == null))
      {
        Log.e("XFilesReaderXWeb", "setTouchEvent error, invalid param");
        AppMethodBeat.o(219028);
        return false;
      }
      localObject = (String)Szd.get(paramString1 + paramString2);
      if (localObject == null)
      {
        Log.e("XFilesReaderXWeb", "setTouchEvent error, not reading");
        AppMethodBeat.o(219028);
        return false;
      }
      paramString2 = com.tencent.xweb.xwalk.a.h.brX((String)localObject);
      if (!(paramString2 instanceof m)) {
        break label231;
      }
      localObject = new HashMap();
      ((HashMap)localObject).put("token", paramString1);
      ((HashMap)localObject).put("gi_name", "gi_setTouchEvent");
      ((HashMap)localObject).put("gi_touchEvent", paramMotionEvent);
      paramString1 = ((m)paramString2).H((HashMap)localObject);
      if ((paramString1 instanceof Boolean))
      {
        boolean bool = ((Boolean)paramString1).booleanValue();
        AppMethodBeat.o(219028);
        return bool;
      }
    }
    catch (Exception paramString1)
    {
      Log.e("XFilesReaderXWeb", "setTouchEvent error: " + paramString1.getMessage());
      AppMethodBeat.o(219028);
      return false;
    }
    AppMethodBeat.o(219028);
    return false;
    label231:
    Log.e("XFilesReaderXWeb", "setTouchEvent error, unknown plugin: ".concat(String.valueOf(localObject)));
    AppMethodBeat.o(219028);
    return false;
  }
  
  private static Integer bsf(String paramString)
  {
    AppMethodBeat.i(219033);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(219033);
      return null;
    }
    try
    {
      int i = Integer.parseInt(paramString);
      AppMethodBeat.o(219033);
      return Integer.valueOf(i);
    }
    catch (Exception paramString)
    {
      Log.e("XFilesReaderXWeb", "parseInteger error:" + paramString.getMessage());
      AppMethodBeat.o(219033);
    }
    return null;
  }
  
  private static Float c(HashMap<String, Object> paramHashMap, String paramString)
  {
    AppMethodBeat.i(219030);
    if (paramHashMap == null)
    {
      Log.e("XFilesReaderXWeb", "getFloatFromParams params is null");
      AppMethodBeat.o(219030);
      return null;
    }
    try
    {
      paramHashMap = paramHashMap.get(paramString);
      if ((paramHashMap instanceof Float))
      {
        paramHashMap = (Float)paramHashMap;
        AppMethodBeat.o(219030);
        return paramHashMap;
      }
      Log.e("XFilesReaderXWeb", "getFloatFromParams value is not float, key: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(219030);
      return null;
    }
    catch (Exception paramHashMap)
    {
      Log.e("XFilesReaderXWeb", "getFloatFromParams error: ", paramHashMap);
      AppMethodBeat.o(219030);
    }
    return null;
  }
  
  private static Bitmap d(HashMap<String, Object> paramHashMap, String paramString)
  {
    AppMethodBeat.i(219031);
    if (paramHashMap == null)
    {
      Log.e("XFilesReaderXWeb", "getBitmapFromParams params is null");
      AppMethodBeat.o(219031);
      return null;
    }
    try
    {
      paramHashMap = paramHashMap.get(paramString);
      if ((paramHashMap instanceof Bitmap))
      {
        paramHashMap = (Bitmap)paramHashMap;
        AppMethodBeat.o(219031);
        return paramHashMap;
      }
      Log.e("XFilesReaderXWeb", "getBitmapFromParams value is not bitmap, key: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(219031);
      return null;
    }
    catch (Exception paramHashMap)
    {
      Log.e("XFilesReaderXWeb", "getBitmapFromParams error: ", paramHashMap);
      AppMethodBeat.o(219031);
    }
    return null;
  }
  
  private static MotionEvent e(HashMap<String, Object> paramHashMap, String paramString)
  {
    AppMethodBeat.i(219032);
    if (paramHashMap == null)
    {
      Log.e("XFilesReaderXWeb", "getMotionEventFromParams params is null");
      AppMethodBeat.o(219032);
      return null;
    }
    try
    {
      paramHashMap = paramHashMap.get(paramString);
      if ((paramHashMap instanceof MotionEvent))
      {
        paramHashMap = (MotionEvent)paramHashMap;
        AppMethodBeat.o(219032);
        return paramHashMap;
      }
      Log.e("XFilesReaderXWeb", "getMotionEventFromParams value is not motion event, key: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(219032);
      return null;
    }
    catch (Exception paramHashMap)
    {
      Log.e("XFilesReaderXWeb", "getMotionEventFromParams error: ", paramHashMap);
      AppMethodBeat.o(219032);
    }
    return null;
  }
  
  public static void nZ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(156757);
    Object localObject;
    try
    {
      if (Sze != null)
      {
        Log.i("XFilesReaderXWeb", "finishReadFile pre updater exist, cancel it");
        Sze.hsE();
        Sze = null;
      }
      localObject = (String)Szd.get(paramString1 + paramString2);
      if (localObject == null)
      {
        AppMethodBeat.o(156757);
        return;
      }
      Szd.remove(paramString1 + paramString2);
      g localg = com.tencent.xweb.xwalk.a.h.brX((String)localObject);
      if ((localg instanceof m))
      {
        Log.i("XFilesReaderXWeb", "finishReadFile ".concat(String.valueOf(localObject)));
        localObject = new HashMap();
        ((HashMap)localObject).put("file_path", paramString2);
        ((HashMap)localObject).put("token", paramString1);
        ((m)localg).D((HashMap)localObject);
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
  
  public static h.b oa(String paramString1, String paramString2)
  {
    AppMethodBeat.i(219025);
    if (paramString1 != null) {}
    try
    {
      if ((paramString1.isEmpty()) || (paramString2 == null) || (paramString2.isEmpty()))
      {
        Log.e("XFilesReaderXWeb", "getViewStatus error, invalid param");
        AppMethodBeat.o(219025);
        return null;
      }
      Object localObject = (String)Szd.get(paramString1 + paramString2);
      if (localObject == null)
      {
        Log.e("XFilesReaderXWeb", "getViewStatus error, not reading");
        AppMethodBeat.o(219025);
        return null;
      }
      paramString2 = com.tencent.xweb.xwalk.a.h.brX((String)localObject);
      if ((paramString2 instanceof m))
      {
        localObject = new HashMap();
        ((HashMap)localObject).put("token", paramString1);
        paramString1 = ((m)paramString2).E((HashMap)localObject);
        AppMethodBeat.o(219025);
        return paramString1;
      }
      Log.e("XFilesReaderXWeb", "getViewStatus error, unknown plugin: ".concat(String.valueOf(localObject)));
      AppMethodBeat.o(219025);
      return null;
    }
    catch (Exception paramString1)
    {
      Log.e("XFilesReaderXWeb", "getViewStatus error: " + paramString1.getMessage());
      AppMethodBeat.o(219025);
    }
    return null;
  }
  
  public static boolean r(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(219022);
    if ((paramBoolean1) && (e.brV(paramString)))
    {
      Log.i("XFilesReaderXWeb", "isPluginAvailable recent crashed");
      AppMethodBeat.o(219022);
      return false;
    }
    g localg = f.brX(paramString);
    if (!(localg instanceof m))
    {
      Log.i("XFilesReaderXWeb", "isPluginAvailable unSupport format".concat(String.valueOf(paramString)));
      AppMethodBeat.o(219022);
      return false;
    }
    paramString = (m)localg;
    int i = paramString.hvk();
    int j = paramString.atb(0);
    if ((i <= 0) || (i < j))
    {
      if ((ai.htj()) && (!localg.hvi()))
      {
        Log.i("XFilesReaderXWeb", "isPluginAvailable forbid download code");
        AppMethodBeat.o(219022);
        return false;
      }
      if (!paramBoolean2)
      {
        Log.i("XFilesReaderXWeb", "isPluginAvailable not installed, can not download");
        AppMethodBeat.o(219022);
        return false;
      }
      Log.i("XFilesReaderXWeb", "isPluginAvailable not installed, can download");
      AppMethodBeat.o(219022);
      return true;
    }
    Log.i("XFilesReaderXWeb", "isPluginAvailable has available version");
    AppMethodBeat.o(219022);
    return true;
  }
  
  public static abstract interface a
  {
    public abstract void Rz(int paramInt);
    
    public abstract void ar(int paramInt1, int paramInt2, int paramInt3);
    
    public abstract void b(int paramInt1, float paramFloat, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
    
    public abstract void c(int paramInt, Bitmap paramBitmap);
    
    public abstract void cTA();
    
    public abstract void epu();
    
    public abstract void epv();
    
    public abstract void epw();
  }
  
  public static enum c
  {
    static
    {
      AppMethodBeat.i(219019);
      Szq = new c("ListView", 0);
      Szr = new c("ReaderView", 1);
      Szs = new c[] { Szq, Szr };
      AppMethodBeat.o(219019);
    }
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.h
 * JD-Core Version:    0.7.0.1
 */