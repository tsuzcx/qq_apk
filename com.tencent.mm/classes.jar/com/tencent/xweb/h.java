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
import com.tencent.j.a.a;
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
  private static Map<String, String> ZZU;
  private static w.a ZZV;
  
  static
  {
    AppMethodBeat.i(156758);
    ZZU = new HashMap();
    ZZV = null;
    AppMethodBeat.o(156758);
  }
  
  private static void a(m paramm, String paramString1, String paramString2, String paramString3, HashMap<String, String> paramHashMap, h.c paramc, Activity paramActivity, ViewGroup paramViewGroup, a parama, ValueCallback<Integer> paramValueCallback)
  {
    AppMethodBeat.i(197261);
    long l1 = System.currentTimeMillis();
    long l2 = f.mz(paramActivity);
    boolean bool2;
    Object localObject;
    boolean bool1;
    if (y.iwp() != null)
    {
      bool2 = y.iwp().iwq();
      localObject = y.iwp().aaaH.getSharedPreferences("wcwebview", 4);
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
      paramHashMap = b.bEP(paramm.getPluginName());
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
      ((HashMap)localObject).put("str_password_title", paramActivity.getString(a.a.xweb_file_reader_password_title));
      ((HashMap)localObject).put("str_password_wrong", paramActivity.getString(a.a.xweb_file_reader_password_wrong));
      ((HashMap)localObject).put("str_password_hint", paramActivity.getString(a.a.xweb_file_reader_password_hint));
      ((HashMap)localObject).put("str_button_confirm", paramActivity.getString(a.a.xweb_file_reader_button_confirm));
      ((HashMap)localObject).put("str_button_cancel", paramActivity.getString(a.a.xweb_file_reader_button_cancel));
      ((HashMap)localObject).put("str_operation_copy", paramActivity.getString(a.a.xweb_file_reader_operation_copy));
      ((HashMap)localObject).put("str_hint_copied", paramActivity.getString(a.a.xweb_file_reader_hint_copied));
      switch (h.3.aaae[paramc.ordinal()])
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
          ZZU.put(paramString3 + paramString1, paramm.getPluginName());
        }
        AppMethodBeat.o(197261);
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
    AppMethodBeat.i(197334);
    f.bb(paramString, paramInt1, paramInt2);
    if (paramValueCallback != null) {
      paramValueCallback.onReceiveValue(Integer.valueOf(paramInt2));
    }
    AppMethodBeat.o(197334);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, h.c paramc, Activity paramActivity, ViewGroup paramViewGroup, a parama, ValueCallback<Integer> paramValueCallback)
  {
    AppMethodBeat.i(197202);
    a(paramString1, paramString2, paramString3, paramBoolean, null, paramc, paramActivity, paramViewGroup, parama, paramValueCallback);
    AppMethodBeat.o(197202);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, HashMap<String, String> paramHashMap, h.c paramc, Activity paramActivity, ViewGroup paramViewGroup, a parama, ValueCallback<Integer> paramValueCallback)
  {
    AppMethodBeat.i(197212);
    Object localObject2 = new StringBuilder("readFile by xweb, fileExt: ");
    if (paramString2 != null) {}
    for (Object localObject1 = paramString2;; localObject1 = "null")
    {
      Log.i("XFilesReaderXWeb", (String)localObject1);
      f.oU(paramString2, f.a.ZZL.name());
      localObject1 = f.bEW(paramString2);
      if ((localObject1 instanceof m)) {
        break;
      }
      Log.e("XFilesReaderXWeb", "readFile unSupport format".concat(String.valueOf(paramString2)));
      a(paramString2, -1, paramValueCallback, -7);
      AppMethodBeat.o(197212);
      return;
    }
    localObject2 = (m)localObject1;
    int j = ((m)localObject2).izd();
    if (parama != null) {}
    for (int i = 1;; i = 0)
    {
      i = ((m)localObject2).aCX(i);
      if ((j > 0) && (j >= i)) {
        break label360;
      }
      if ((!ak.iwQ()) || (((g)localObject1).izb())) {
        break;
      }
      Log.i("XFilesReaderXWeb", "readFile forbid download code, return");
      a(paramString2, -1, paramValueCallback, -1);
      AppMethodBeat.o(197212);
      return;
    }
    if (!paramBoolean)
    {
      Log.i("XFilesReaderXWeb", "readFile plugin version: " + j + ", require: " + i + ", canDownload: false, return");
      if (j <= 0) {}
      for (i = -2;; i = -11)
      {
        a(paramString2, j, paramValueCallback, i);
        AppMethodBeat.o(197212);
        return;
      }
    }
    Log.i("XFilesReaderXWeb", "readFile plugin version: " + j + ", require: " + i + ", canDownload: true, start download");
    f.bFc(paramString2);
    if (!a((m)localObject2, paramString1, paramString2, paramString3, paramBoolean, paramHashMap, paramc, paramActivity, paramViewGroup, parama, paramValueCallback))
    {
      f.bFd(paramString2);
      a(paramString2, j, paramValueCallback, -16);
    }
    AppMethodBeat.o(197212);
    return;
    label360:
    a((m)localObject2, paramString1, paramString2, paramString3, paramHashMap, paramc, paramActivity, paramViewGroup, parama, paramValueCallback);
    AppMethodBeat.o(197212);
  }
  
  private static boolean a(final m paramm, final String paramString1, final String paramString2, final String paramString3, final boolean paramBoolean, final HashMap<String, String> paramHashMap, final h.c paramc, Activity paramActivity, final ViewGroup paramViewGroup, final a parama, final ValueCallback<Integer> paramValueCallback)
  {
    AppMethodBeat.i(197237);
    if (ZZV != null)
    {
      Log.i("XFilesReaderXWeb", "startDownload pre updater not finish, cancel it");
      ZZV.iwn();
      ZZV = null;
    }
    Object localObject1 = l.h(WebView.c.aabm);
    if (localObject1 == null)
    {
      Log.e("XFilesReaderXWeb", "startDownload webViewProvider is null");
      AppMethodBeat.o(197237);
      return false;
    }
    localObject1 = (w.a)((l.a)localObject1).excute("STR_CMD_GET_PLUGIN_UPDATER", null);
    ZZV = (w.a)localObject1;
    if (localObject1 == null)
    {
      Log.e("XFilesReaderXWeb", "startDownload updater is null");
      AppMethodBeat.o(197237);
      return false;
    }
    if ((paramActivity == null) || (paramActivity.isDestroyed()) || (paramViewGroup == null))
    {
      Log.e("XFilesReaderXWeb", "startDownload activity destroyed");
      AppMethodBeat.o(197237);
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
          localObject1 = bFe((String)paramHashMap.get("extra_param_download_text_color"));
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
        ZZV.a(paramm.getPluginName(), new j()
        {
          public final void aCH(int paramAnonymousInt)
          {
            AppMethodBeat.i(197027);
            Log.i("XFilesReaderXWeb", "onXWalkPluginUpdateProgress ".concat(String.valueOf(paramAnonymousInt)));
            Activity localActivity = (Activity)this.ZZW.get();
            TextView localTextView = (TextView)this.ZZX.get();
            if ((localActivity == null) || (localActivity.isDestroyed()) || (localTextView == null))
            {
              AppMethodBeat.o(197027);
              return;
            }
            localTextView.setText(localActivity.getString(a.a.xweb_file_reader_plugin_downloading) + paramAnonymousInt + "%");
            AppMethodBeat.o(197027);
          }
          
          public final void aCI(int paramAnonymousInt)
          {
            AppMethodBeat.i(197038);
            Log.i("XFilesReaderXWeb", "onXWalkPluginUpdateCompleted errorCode = ".concat(String.valueOf(paramAnonymousInt)));
            h.iwa();
            f.ix(paramString2, paramAnonymousInt);
            Activity localActivity = (Activity)this.ZZW.get();
            ViewGroup localViewGroup = (ViewGroup)paramViewGroup.get();
            TextView localTextView = (TextView)this.ZZX.get();
            switch (paramAnonymousInt)
            {
            default: 
              if ((localActivity != null) && (!localActivity.isDestroyed()) && (localViewGroup != null) && (localTextView != null)) {
                localTextView.setText(localActivity.getString(a.a.xweb_file_reader_plugin_download_failed));
              }
              if (paramAnonymousInt == -1)
              {
                Log.i("XFilesReaderXWeb", "onXWalkPluginUpdateCompleted, download cancel");
                h.b(paramString2, paramValueCallback, -15);
                AppMethodBeat.o(197038);
                return;
              }
              break;
            case 0: 
              if ((localActivity != null) && (!localActivity.isDestroyed()) && (localViewGroup != null) && (localTextView != null))
              {
                Log.i("XFilesReaderXWeb", "onXWalkPluginUpdateCompleted, download success, start read file");
                localTextView.setVisibility(8);
                h.b(paramm, paramString1, paramString2, paramString3, paramHashMap, paramc, localActivity, localViewGroup, parama, paramValueCallback);
                AppMethodBeat.o(197038);
                return;
              }
              Log.e("XFilesReaderXWeb", "onXWalkPluginUpdateCompleted, download success, view destroyed, return");
              h.b(paramString2, paramValueCallback, -14);
              AppMethodBeat.o(197038);
              return;
            }
            Log.i("XFilesReaderXWeb", "onXWalkPluginUpdateCompleted, download failed");
            h.b(paramString2, paramValueCallback, -16);
            AppMethodBeat.o(197038);
          }
          
          public final void iwb()
          {
            AppMethodBeat.i(197026);
            Log.i("XFilesReaderXWeb", "onXWalkPluginUpdateStarted");
            AppMethodBeat.o(197026);
          }
        });
        paramm = new HashMap();
        paramm.put("UpdaterCheckType", "1");
        ZZV.b(XWalkEnvironment.getApplicationContext(), paramm);
        AppMethodBeat.o(197237);
        return true;
      }
      Log.e("XFilesReaderXWeb", "startDownload layout is null");
      AppMethodBeat.o(197237);
      return false;
    }
  }
  
  public static boolean aH(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(197288);
    if (paramString1 != null) {}
    try
    {
      if ((paramString1.isEmpty()) || (paramString2 == null) || (paramString2.isEmpty()))
      {
        Log.e("XFilesReaderXWeb", "setViewToStatus error, invalid param");
        AppMethodBeat.o(197288);
        return false;
      }
      Object localObject = (String)ZZU.get(paramString1 + paramString2);
      if (localObject == null)
      {
        Log.e("XFilesReaderXWeb", "setViewToStatus error, not reading");
        AppMethodBeat.o(197288);
        return false;
      }
      paramString2 = com.tencent.xweb.xwalk.a.h.bEW((String)localObject);
      if ((paramString2 instanceof m))
      {
        localObject = new HashMap();
        ((HashMap)localObject).put("token", paramString1);
        ((HashMap)localObject).put("set_index", Integer.valueOf(paramInt));
        ((HashMap)localObject).put("set_zoom", Float.valueOf(1.0F));
        ((HashMap)localObject).put("set_x", Integer.valueOf(0));
        ((HashMap)localObject).put("set_y", Integer.valueOf(0));
        boolean bool = ((m)paramString2).C((HashMap)localObject);
        AppMethodBeat.o(197288);
        return bool;
      }
      Log.e("XFilesReaderXWeb", "setViewToStatus error, unknown plugin: ".concat(String.valueOf(localObject)));
      AppMethodBeat.o(197288);
      return false;
    }
    catch (Exception paramString1)
    {
      Log.e("XFilesReaderXWeb", "setViewToStatus error: " + paramString1.getMessage());
      AppMethodBeat.o(197288);
    }
    return false;
  }
  
  public static boolean aI(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(197299);
    if (paramString1 != null) {}
    try
    {
      if ((paramString1.isEmpty()) || (paramString2 == null) || (paramString2.isEmpty()) || (paramInt < 0))
      {
        Log.e("XFilesReaderXWeb", "requestThumbnail error, invalid param");
        AppMethodBeat.o(197299);
        return false;
      }
      Object localObject = (String)ZZU.get(paramString1 + paramString2);
      if (localObject == null)
      {
        Log.e("XFilesReaderXWeb", "requestThumbnail error, not reading");
        AppMethodBeat.o(197299);
        return false;
      }
      paramString2 = com.tencent.xweb.xwalk.a.h.bEW((String)localObject);
      if ((paramString2 instanceof m))
      {
        localObject = new HashMap();
        ((HashMap)localObject).put("token", paramString1);
        ((HashMap)localObject).put("thumbnail_index", Integer.valueOf(paramInt));
        boolean bool = ((m)paramString2).D((HashMap)localObject);
        AppMethodBeat.o(197299);
        return bool;
      }
      Log.e("XFilesReaderXWeb", "requestThumbnail error, unknown plugin: ".concat(String.valueOf(localObject)));
      AppMethodBeat.o(197299);
      return false;
    }
    catch (Exception paramString1)
    {
      Log.e("XFilesReaderXWeb", "requestThumbnail error: " + paramString1.getMessage());
      AppMethodBeat.o(197299);
    }
    return false;
  }
  
  public static boolean b(String paramString1, String paramString2, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(197313);
    if (paramString1 != null) {}
    Object localObject;
    try
    {
      if ((paramString1.isEmpty()) || (paramString2 == null) || (paramString2.isEmpty()) || (paramMotionEvent == null))
      {
        Log.e("XFilesReaderXWeb", "setTouchEvent error, invalid param");
        AppMethodBeat.o(197313);
        return false;
      }
      localObject = (String)ZZU.get(paramString1 + paramString2);
      if (localObject == null)
      {
        Log.e("XFilesReaderXWeb", "setTouchEvent error, not reading");
        AppMethodBeat.o(197313);
        return false;
      }
      paramString2 = com.tencent.xweb.xwalk.a.h.bEW((String)localObject);
      if (!(paramString2 instanceof m)) {
        break label231;
      }
      localObject = new HashMap();
      ((HashMap)localObject).put("token", paramString1);
      ((HashMap)localObject).put("gi_name", "gi_setTouchEvent");
      ((HashMap)localObject).put("gi_touchEvent", paramMotionEvent);
      paramString1 = ((m)paramString2).E((HashMap)localObject);
      if ((paramString1 instanceof Boolean))
      {
        boolean bool = ((Boolean)paramString1).booleanValue();
        AppMethodBeat.o(197313);
        return bool;
      }
    }
    catch (Exception paramString1)
    {
      Log.e("XFilesReaderXWeb", "setTouchEvent error: " + paramString1.getMessage());
      AppMethodBeat.o(197313);
      return false;
    }
    AppMethodBeat.o(197313);
    return false;
    label231:
    Log.e("XFilesReaderXWeb", "setTouchEvent error, unknown plugin: ".concat(String.valueOf(localObject)));
    AppMethodBeat.o(197313);
    return false;
  }
  
  private static Integer bFe(String paramString)
  {
    AppMethodBeat.i(197332);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(197332);
      return null;
    }
    try
    {
      int i = Integer.parseInt(paramString);
      AppMethodBeat.o(197332);
      return Integer.valueOf(i);
    }
    catch (Exception paramString)
    {
      Log.e("XFilesReaderXWeb", "parseInteger error:" + paramString.getMessage());
      AppMethodBeat.o(197332);
    }
    return null;
  }
  
  private static Integer d(HashMap<String, Object> paramHashMap, String paramString)
  {
    AppMethodBeat.i(197318);
    if (paramHashMap == null)
    {
      Log.e("XFilesReaderXWeb", "getIntegerFromParams params is null");
      AppMethodBeat.o(197318);
      return null;
    }
    try
    {
      paramHashMap = paramHashMap.get(paramString);
      if ((paramHashMap instanceof Integer))
      {
        paramHashMap = (Integer)paramHashMap;
        AppMethodBeat.o(197318);
        return paramHashMap;
      }
      Log.e("XFilesReaderXWeb", "getIntegerFromParams value is not integer, key: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(197318);
      return null;
    }
    catch (Exception paramHashMap)
    {
      Log.e("XFilesReaderXWeb", "getIntegerFromParams error: ", paramHashMap);
      AppMethodBeat.o(197318);
    }
    return null;
  }
  
  private static Float e(HashMap<String, Object> paramHashMap, String paramString)
  {
    AppMethodBeat.i(197323);
    if (paramHashMap == null)
    {
      Log.e("XFilesReaderXWeb", "getFloatFromParams params is null");
      AppMethodBeat.o(197323);
      return null;
    }
    try
    {
      paramHashMap = paramHashMap.get(paramString);
      if ((paramHashMap instanceof Float))
      {
        paramHashMap = (Float)paramHashMap;
        AppMethodBeat.o(197323);
        return paramHashMap;
      }
      Log.e("XFilesReaderXWeb", "getFloatFromParams value is not float, key: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(197323);
      return null;
    }
    catch (Exception paramHashMap)
    {
      Log.e("XFilesReaderXWeb", "getFloatFromParams error: ", paramHashMap);
      AppMethodBeat.o(197323);
    }
    return null;
  }
  
  private static Bitmap f(HashMap<String, Object> paramHashMap, String paramString)
  {
    AppMethodBeat.i(197326);
    if (paramHashMap == null)
    {
      Log.e("XFilesReaderXWeb", "getBitmapFromParams params is null");
      AppMethodBeat.o(197326);
      return null;
    }
    try
    {
      paramHashMap = paramHashMap.get(paramString);
      if ((paramHashMap instanceof Bitmap))
      {
        paramHashMap = (Bitmap)paramHashMap;
        AppMethodBeat.o(197326);
        return paramHashMap;
      }
      Log.e("XFilesReaderXWeb", "getBitmapFromParams value is not bitmap, key: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(197326);
      return null;
    }
    catch (Exception paramHashMap)
    {
      Log.e("XFilesReaderXWeb", "getBitmapFromParams error: ", paramHashMap);
      AppMethodBeat.o(197326);
    }
    return null;
  }
  
  private static MotionEvent g(HashMap<String, Object> paramHashMap, String paramString)
  {
    AppMethodBeat.i(197328);
    if (paramHashMap == null)
    {
      Log.e("XFilesReaderXWeb", "getMotionEventFromParams params is null");
      AppMethodBeat.o(197328);
      return null;
    }
    try
    {
      paramHashMap = paramHashMap.get(paramString);
      if ((paramHashMap instanceof MotionEvent))
      {
        paramHashMap = (MotionEvent)paramHashMap;
        AppMethodBeat.o(197328);
        return paramHashMap;
      }
      Log.e("XFilesReaderXWeb", "getMotionEventFromParams value is not motion event, key: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(197328);
      return null;
    }
    catch (Exception paramHashMap)
    {
      Log.e("XFilesReaderXWeb", "getMotionEventFromParams error: ", paramHashMap);
      AppMethodBeat.o(197328);
    }
    return null;
  }
  
  public static void oV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(156757);
    Object localObject;
    try
    {
      if (ZZV != null)
      {
        Log.i("XFilesReaderXWeb", "finishReadFile pre updater exist, cancel it");
        ZZV.iwn();
        ZZV = null;
      }
      localObject = (String)ZZU.get(paramString1 + paramString2);
      if (localObject == null)
      {
        AppMethodBeat.o(156757);
        return;
      }
      ZZU.remove(paramString1 + paramString2);
      g localg = com.tencent.xweb.xwalk.a.h.bEW((String)localObject);
      if ((localg instanceof m))
      {
        Log.i("XFilesReaderXWeb", "finishReadFile ".concat(String.valueOf(localObject)));
        localObject = new HashMap();
        ((HashMap)localObject).put("file_path", paramString2);
        ((HashMap)localObject).put("token", paramString1);
        ((m)localg).A((HashMap)localObject);
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
  
  public static b oW(String paramString1, String paramString2)
  {
    AppMethodBeat.i(197272);
    if (paramString1 != null) {}
    try
    {
      if ((paramString1.isEmpty()) || (paramString2 == null) || (paramString2.isEmpty()))
      {
        Log.e("XFilesReaderXWeb", "getViewStatus error, invalid param");
        AppMethodBeat.o(197272);
        return null;
      }
      Object localObject = (String)ZZU.get(paramString1 + paramString2);
      if (localObject == null)
      {
        Log.e("XFilesReaderXWeb", "getViewStatus error, not reading");
        AppMethodBeat.o(197272);
        return null;
      }
      paramString2 = com.tencent.xweb.xwalk.a.h.bEW((String)localObject);
      if ((paramString2 instanceof m))
      {
        localObject = new HashMap();
        ((HashMap)localObject).put("token", paramString1);
        paramString1 = ((m)paramString2).B((HashMap)localObject);
        AppMethodBeat.o(197272);
        return paramString1;
      }
      Log.e("XFilesReaderXWeb", "getViewStatus error, unknown plugin: ".concat(String.valueOf(localObject)));
      AppMethodBeat.o(197272);
      return null;
    }
    catch (Exception paramString1)
    {
      Log.e("XFilesReaderXWeb", "getViewStatus error: " + paramString1.getMessage());
      AppMethodBeat.o(197272);
    }
    return null;
  }
  
  public static boolean s(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(197218);
    if ((paramBoolean1) && (e.bEU(paramString)))
    {
      Log.i("XFilesReaderXWeb", "isPluginAvailable recent crashed");
      AppMethodBeat.o(197218);
      return false;
    }
    g localg = f.bEW(paramString);
    if (!(localg instanceof m))
    {
      Log.i("XFilesReaderXWeb", "isPluginAvailable unSupport format".concat(String.valueOf(paramString)));
      AppMethodBeat.o(197218);
      return false;
    }
    paramString = (m)localg;
    int i = paramString.izd();
    int j = paramString.aCX(0);
    if ((i <= 0) || (i < j))
    {
      if ((ak.iwQ()) && (!localg.izb()))
      {
        Log.i("XFilesReaderXWeb", "isPluginAvailable forbid download code");
        AppMethodBeat.o(197218);
        return false;
      }
      if (!paramBoolean2)
      {
        Log.i("XFilesReaderXWeb", "isPluginAvailable not installed, can not download");
        AppMethodBeat.o(197218);
        return false;
      }
      Log.i("XFilesReaderXWeb", "isPluginAvailable not installed, can download");
      AppMethodBeat.o(197218);
      return true;
    }
    Log.i("XFilesReaderXWeb", "isPluginAvailable has available version");
    AppMethodBeat.o(197218);
    return true;
  }
  
  public static abstract interface a
  {
    public abstract void NB(int paramInt);
    
    public abstract void a(int paramInt1, float paramFloat, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
    
    public abstract void a(int paramInt, Bitmap paramBitmap);
    
    public abstract void ag(int paramInt1, int paramInt2, int paramInt3);
    
    public abstract void bQm();
    
    public abstract void dCv();
    
    public abstract void dCw();
    
    public abstract void dCx();
  }
  
  public static class b
  {
    public int aaaf;
    public int aaag;
    public int index;
    public float zoom;
    
    public b(int paramInt1, float paramFloat, int paramInt2, int paramInt3)
    {
      this.index = paramInt1;
      this.zoom = paramFloat;
      this.aaaf = paramInt2;
      this.aaag = paramInt3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.h
 * JD-Core Version:    0.7.0.1
 */