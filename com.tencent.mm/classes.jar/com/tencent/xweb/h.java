package com.tencent.xweb;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.xwalk.a.e;
import com.tencent.xweb.xwalk.a.g;
import com.tencent.xweb.xwalk.a.k;
import java.util.HashMap;
import java.util.Map;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public final class h
{
  private static Map<String, String> IMA;
  
  static
  {
    AppMethodBeat.i(156758);
    IMA = new HashMap();
    AppMethodBeat.o(156758);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, Activity paramActivity, ViewGroup paramViewGroup, ValueCallback<Integer> paramValueCallback)
  {
    AppMethodBeat.i(156756);
    f.lZ(paramString2, f.a.IMu.name());
    e locale = f.aOW(paramString2);
    if (!(locale instanceof k))
    {
      Log.e("XFilesReaderXWeb", "readFile unSupport format".concat(String.valueOf(paramString2)));
      paramValueCallback.onReceiveValue(Integer.valueOf(-7));
      AppMethodBeat.o(156756);
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = f.kV(paramActivity);
    boolean bool2 = false;
    boolean bool1 = true;
    Object localObject;
    if (x.fqR() != null)
    {
      bool2 = x.fqR().fqS();
      localObject = x.fqR().IMY.getSharedPreferences("wcwebview", 4);
      if (localObject != null) {
        break label370;
      }
    }
    label370:
    for (bool1 = true;; bool1 = ((SharedPreferences)localObject).getBoolean("fr_disable_encry", true))
    {
      localObject = new HashMap();
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
      if (((k)locale).a((HashMap)localObject, paramActivity, paramViewGroup, paramValueCallback)) {
        IMA.put(paramString3 + paramString1, locale.getPluginName());
      }
      AppMethodBeat.o(156756);
      return;
    }
  }
  
  public static void ma(String paramString1, String paramString2)
  {
    AppMethodBeat.i(156757);
    Object localObject;
    try
    {
      localObject = (String)IMA.get(paramString1 + paramString2);
      if (localObject == null)
      {
        AppMethodBeat.o(156757);
        return;
      }
      IMA.remove(paramString1 + paramString2);
      e locale = g.aOW((String)localObject);
      if ((locale instanceof k))
      {
        Log.i("XFilesReaderXWeb", "finishReadFile ".concat(String.valueOf(localObject)));
        localObject = new HashMap();
        ((HashMap)localObject).put("file_path", paramString2);
        ((HashMap)localObject).put("token", paramString1);
        ((k)locale).p((HashMap)localObject);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.h
 * JD-Core Version:    0.7.0.1
 */