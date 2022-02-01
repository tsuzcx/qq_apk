package com.tencent.xweb;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.util.Pair;
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
  private static Map<String, String> MMk;
  private static w.a MMl;
  
  static
  {
    AppMethodBeat.i(156758);
    MMk = new HashMap();
    MMl = null;
    AppMethodBeat.o(156758);
  }
  
  private static void a(l paraml, String paramString1, String paramString2, String paramString3, HashMap<String, String> paramHashMap, b paramb, Activity paramActivity, ViewGroup paramViewGroup, a parama, ValueCallback<Integer> paramValueCallback)
  {
    AppMethodBeat.i(217383);
    long l1 = System.currentTimeMillis();
    long l2 = f.lC(paramActivity);
    boolean bool2;
    Object localObject;
    boolean bool1;
    if (y.gfo() != null)
    {
      bool2 = y.gfo().gfp();
      localObject = y.gfo().MMV.getSharedPreferences("wcwebview", 4);
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
      paramHashMap = b.bcl(paraml.getPluginName());
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
      ((HashMap)localObject).put("str_password_title", paramActivity.getString(2131766369));
      ((HashMap)localObject).put("str_password_wrong", paramActivity.getString(2131766370));
      ((HashMap)localObject).put("str_password_hint", paramActivity.getString(2131766368));
      ((HashMap)localObject).put("str_button_confirm", paramActivity.getString(2131766365));
      ((HashMap)localObject).put("str_button_cancel", paramActivity.getString(2131766364));
      ((HashMap)localObject).put("str_operation_copy", paramActivity.getString(2131766367));
      ((HashMap)localObject).put("str_hint_copied", paramActivity.getString(2131766366));
      switch (3.MMu[paramb.ordinal()])
      {
      default: 
        ((HashMap)localObject).put("view_type", "view_type_list");
        if (parama == null) {
          break;
        }
      }
      for (bool1 = paraml.a((HashMap)localObject, paramActivity, paramViewGroup, new ValueCallback() {}, paramValueCallback);; bool1 = paraml.a((HashMap)localObject, paramActivity, paramViewGroup, null, paramValueCallback))
      {
        if (bool1) {
          MMk.put(paramString3 + paramString1, paraml.getPluginName());
        }
        AppMethodBeat.o(217383);
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
    AppMethodBeat.i(217386);
    f.be(paramString, paramInt1, paramInt2);
    if (paramValueCallback != null) {
      paramValueCallback.onReceiveValue(Integer.valueOf(paramInt2));
    }
    AppMethodBeat.o(217386);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, Activity paramActivity, ViewGroup paramViewGroup, ValueCallback<Integer> paramValueCallback)
  {
    AppMethodBeat.i(217380);
    b localb = b.MMv;
    Object localObject2 = new StringBuilder("readFile by xweb, fileExt: ");
    if (paramString2 != null) {}
    for (Object localObject1 = paramString2;; localObject1 = "null")
    {
      Log.i("XFilesReaderXWeb", (String)localObject1);
      f.ne(paramString2, f.a.MMf.name());
      localObject1 = f.bcp(paramString2);
      if ((localObject1 instanceof l)) {
        break;
      }
      Log.e("XFilesReaderXWeb", "readFile unSupport format".concat(String.valueOf(paramString2)));
      a(paramString2, -1, paramValueCallback, -7);
      AppMethodBeat.o(217380);
      return;
    }
    localObject2 = (l)localObject1;
    int j = ((com.tencent.xweb.xwalk.a.f)localObject2).MUN;
    int i = ((l)localObject2).ajs(0);
    if ((j <= 0) || (j < i))
    {
      if ((ai.gfR()) && (!((com.tencent.xweb.xwalk.a.f)localObject1).ghK()))
      {
        Log.i("XFilesReaderXWeb", "readFile forbid download code, return");
        a(paramString2, -1, paramValueCallback, -1);
        AppMethodBeat.o(217380);
        return;
      }
      if (!paramBoolean)
      {
        Log.i("XFilesReaderXWeb", "readFile plugin version: " + j + ", require: " + i + ", canDownload: false, return");
        if (j <= 0) {}
        for (i = -2;; i = -11)
        {
          a(paramString2, j, paramValueCallback, i);
          AppMethodBeat.o(217380);
          return;
        }
      }
      Log.i("XFilesReaderXWeb", "readFile plugin version: " + j + ", require: " + i + ", canDownload: true, start download");
      f.bcv(paramString2);
      if (!a((l)localObject2, paramString1, paramString2, paramString3, paramBoolean, localb, paramActivity, paramViewGroup, paramValueCallback))
      {
        f.bcw(paramString2);
        a(paramString2, j, paramValueCallback, -16);
      }
      AppMethodBeat.o(217380);
      return;
    }
    a((l)localObject2, paramString1, paramString2, paramString3, null, localb, paramActivity, paramViewGroup, null, paramValueCallback);
    AppMethodBeat.o(217380);
  }
  
  private static boolean a(final l paraml, final String paramString1, final String paramString2, final String paramString3, final boolean paramBoolean, final b paramb, Activity paramActivity, final ViewGroup paramViewGroup, final ValueCallback<Integer> paramValueCallback)
  {
    AppMethodBeat.i(217382);
    if (MMl != null)
    {
      Log.i("XFilesReaderXWeb", "startDownload pre updater not finish, cancel it");
      MMl.gfn();
      MMl = null;
    }
    Object localObject1 = j.g(WebView.c.MNy);
    if (localObject1 == null)
    {
      Log.e("XFilesReaderXWeb", "startDownload webViewProvider is null");
      AppMethodBeat.o(217382);
      return false;
    }
    localObject1 = (w.a)((j.a)localObject1).excute("STR_CMD_GET_PLUGIN_UPDATER", null);
    MMl = (w.a)localObject1;
    if (localObject1 == null)
    {
      Log.e("XFilesReaderXWeb", "startDownload updater is null");
      AppMethodBeat.o(217382);
      return false;
    }
    if ((paramActivity == null) || (paramActivity.isDestroyed()) || (paramViewGroup == null))
    {
      Log.e("XFilesReaderXWeb", "startDownload activity destroyed");
      AppMethodBeat.o(217382);
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
        break label452;
      }
      localObject3 = ((View)localObject2).getTag();
      if ((!(localObject3 instanceof String)) || (!"view_tag_relative_layout".equalsIgnoreCase((String)localObject3))) {
        break label452;
      }
      localObject1 = (RelativeLayout)localObject2;
    }
    label452:
    for (;;)
    {
      i += 1;
      break;
      if (localObject1 == null) {
        if ((paramViewGroup instanceof RelativeLayout)) {
          localObject1 = (RelativeLayout)paramViewGroup;
        }
      }
      for (;;)
      {
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
        MMl.a(paraml.getPluginName(), new i()
        {
          public final void ajh(int paramAnonymousInt)
          {
            AppMethodBeat.i(217373);
            Log.i("XFilesReaderXWeb", "onXWalkPluginUpdateProgress ".concat(String.valueOf(paramAnonymousInt)));
            Activity localActivity = (Activity)this.MMm.get();
            TextView localTextView = (TextView)this.MMn.get();
            if ((localActivity == null) || (localActivity.isDestroyed()) || (localTextView == null))
            {
              AppMethodBeat.o(217373);
              return;
            }
            localTextView.setText(localActivity.getString(2131766888) + paramAnonymousInt + "%");
            AppMethodBeat.o(217373);
          }
          
          public final void aji(int paramAnonymousInt)
          {
            AppMethodBeat.i(217374);
            Log.i("XFilesReaderXWeb", "onXWalkPluginUpdateCompleted errorCode = ".concat(String.valueOf(paramAnonymousInt)));
            h.gfb();
            f.hs(paramString2, paramAnonymousInt);
            Activity localActivity = (Activity)this.MMm.get();
            ViewGroup localViewGroup = (ViewGroup)paramViewGroup.get();
            TextView localTextView = (TextView)this.MMn.get();
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
                AppMethodBeat.o(217374);
                return;
              }
              break;
            case 0: 
              if ((localActivity != null) && (!localActivity.isDestroyed()) && (localViewGroup != null) && (localTextView != null))
              {
                Log.i("XFilesReaderXWeb", "onXWalkPluginUpdateCompleted, download success, start read file");
                localTextView.setVisibility(8);
                h.b(paraml, paramString1, paramString2, paramString3, this.MMr, paramb, localActivity, localViewGroup, this.MMt, paramValueCallback);
                AppMethodBeat.o(217374);
                return;
              }
              Log.e("XFilesReaderXWeb", "onXWalkPluginUpdateCompleted, download success, view destroyed, return");
              h.b(paramString2, paramValueCallback, -14);
              AppMethodBeat.o(217374);
              return;
            }
            Log.i("XFilesReaderXWeb", "onXWalkPluginUpdateCompleted, download failed");
            h.b(paramString2, paramValueCallback, -16);
            AppMethodBeat.o(217374);
          }
          
          public final void gfc()
          {
            AppMethodBeat.i(217372);
            Log.i("XFilesReaderXWeb", "onXWalkPluginUpdateStarted");
            AppMethodBeat.o(217372);
          }
        });
        paraml = new HashMap();
        paraml.put("UpdaterCheckType", "1");
        MMl.a(XWalkEnvironment.getApplicationContext(), paraml);
        AppMethodBeat.o(217382);
        return true;
        Log.e("XFilesReaderXWeb", "startDownload layout is null");
        AppMethodBeat.o(217382);
        return false;
      }
    }
  }
  
  private static Integer c(HashMap<String, Object> paramHashMap, String paramString)
  {
    AppMethodBeat.i(217384);
    if (paramHashMap == null)
    {
      Log.e("XFilesReaderXWeb", "getIntegerFromParams params is null");
      AppMethodBeat.o(217384);
      return null;
    }
    try
    {
      paramHashMap = paramHashMap.get(paramString);
      if ((paramHashMap instanceof Integer))
      {
        paramHashMap = (Integer)paramHashMap;
        AppMethodBeat.o(217384);
        return paramHashMap;
      }
      Log.e("XFilesReaderXWeb", "getIntegerFromParams value is not integer, key: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(217384);
      return null;
    }
    catch (Exception paramHashMap)
    {
      Log.e("XFilesReaderXWeb", "getIntegerFromParams error: ", paramHashMap);
      AppMethodBeat.o(217384);
    }
    return null;
  }
  
  private static Bitmap d(HashMap<String, Object> paramHashMap, String paramString)
  {
    AppMethodBeat.i(217385);
    if (paramHashMap == null)
    {
      Log.e("XFilesReaderXWeb", "getBitmapFromParams params is null");
      AppMethodBeat.o(217385);
      return null;
    }
    try
    {
      paramHashMap = paramHashMap.get(paramString);
      if ((paramHashMap instanceof Bitmap))
      {
        paramHashMap = (Bitmap)paramHashMap;
        AppMethodBeat.o(217385);
        return paramHashMap;
      }
      Log.e("XFilesReaderXWeb", "getBitmapFromParams value is not bitmap, key: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(217385);
      return null;
    }
    catch (Exception paramHashMap)
    {
      Log.e("XFilesReaderXWeb", "getBitmapFromParams error: ", paramHashMap);
      AppMethodBeat.o(217385);
    }
    return null;
  }
  
  public static void nf(String paramString1, String paramString2)
  {
    AppMethodBeat.i(156757);
    Object localObject;
    try
    {
      if (MMl != null)
      {
        Log.i("XFilesReaderXWeb", "finishReadFile pre updater exist, cancel it");
        MMl.gfn();
        MMl = null;
      }
      localObject = (String)MMk.get(paramString1 + paramString2);
      if (localObject == null)
      {
        AppMethodBeat.o(156757);
        return;
      }
      MMk.remove(paramString1 + paramString2);
      com.tencent.xweb.xwalk.a.f localf = g.bcp((String)localObject);
      if ((localf instanceof l))
      {
        Log.i("XFilesReaderXWeb", "finishReadFile ".concat(String.valueOf(localObject)));
        localObject = new HashMap();
        ((HashMap)localObject).put("file_path", paramString2);
        ((HashMap)localObject).put("token", paramString1);
        ((l)localf).r((HashMap)localObject);
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
    AppMethodBeat.i(217381);
    if ((paramBoolean1) && (e.bco(paramString)))
    {
      Log.i("XFilesReaderXWeb", "isPluginAvailable recent crashed");
      AppMethodBeat.o(217381);
      return false;
    }
    com.tencent.xweb.xwalk.a.f localf = f.bcp(paramString);
    if (!(localf instanceof l))
    {
      Log.i("XFilesReaderXWeb", "isPluginAvailable unSupport format".concat(String.valueOf(paramString)));
      AppMethodBeat.o(217381);
      return false;
    }
    paramString = (l)localf;
    int i = paramString.MUN;
    int j = paramString.ajs(0);
    if ((i <= 0) || (i < j))
    {
      if ((ai.gfR()) && (!localf.ghK()))
      {
        Log.i("XFilesReaderXWeb", "isPluginAvailable forbid download code");
        AppMethodBeat.o(217381);
        return false;
      }
      if (!paramBoolean2)
      {
        Log.i("XFilesReaderXWeb", "isPluginAvailable not installed, can not download");
        AppMethodBeat.o(217381);
        return false;
      }
      Log.i("XFilesReaderXWeb", "isPluginAvailable not installed, can download");
      AppMethodBeat.o(217381);
      return true;
    }
    Log.i("XFilesReaderXWeb", "isPluginAvailable has available version");
    AppMethodBeat.o(217381);
    return true;
  }
  
  public static abstract interface a {}
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(217379);
      MMv = new b("ListView", 0);
      MMw = new b("ReaderView", 1);
      MMx = new b[] { MMv, MMw };
      AppMethodBeat.o(217379);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.h
 * JD-Core Version:    0.7.0.1
 */