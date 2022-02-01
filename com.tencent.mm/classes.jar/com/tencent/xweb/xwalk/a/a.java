package com.tencent.xweb.xwalk.a;

import android.app.Activity;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.f;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.xwalk.core.Log;

public final class a
  extends k
{
  public final boolean a(HashMap<String, String> paramHashMap, Activity paramActivity, ViewGroup paramViewGroup, final ValueCallback<Integer> paramValueCallback)
  {
    AppMethodBeat.i(157174);
    if ((paramActivity == null) || (paramViewGroup == null))
    {
      Log.e("XFilesExcelReader", "readFile params is null");
      b("xls", paramValueCallback, -5);
      AppMethodBeat.o(157174);
      return false;
    }
    final String str = (String)paramHashMap.get("file_ext");
    if ((str == null) || (str.isEmpty()))
    {
      Log.e("XFilesExcelReader", "readFile fileExt is null");
      b("xls", paramValueCallback, -5);
      AppMethodBeat.o(157174);
      return false;
    }
    int i = this.IUH;
    if (i <= 0)
    {
      Log.e("XFilesExcelReader", "readFile plugin not installed");
      b(str, paramValueCallback, -2);
      AppMethodBeat.o(157174);
      return false;
    }
    if (i < 100)
    {
      Log.e("XFilesExcelReader", "readFile plugin version is too old, require: 100");
      b(str, paramValueCallback, -11);
      AppMethodBeat.o(157174);
      return false;
    }
    Log.i("XFilesExcelReader", "readFile by xweb, plugin version ".concat(String.valueOf(i)));
    ads(1070);
    try
    {
      paramHashMap.put("cache_dir", adp(i));
      paramHashMap.put("res_dir", adq(i));
      ftr();
      Method localMethod = this.IVf.getMethod("readFile", new Class[] { Activity.class, ViewGroup.class, ClassLoader.class, HashMap.class, ValueCallback.class, ValueCallback.class, ValueCallback.class });
      localMethod.setAccessible(true);
      com.tencent.xweb.e.onStart(str);
      localMethod.invoke(null, new Object[] { paramActivity, paramViewGroup, this.IVf.getClassLoader(), paramHashMap, this.IVi, this.IVj, new ValueCallback() {} });
      AppMethodBeat.o(157174);
      return true;
    }
    catch (Exception paramHashMap)
    {
      Log.e("XFilesExcelReader", "readFile error: " + paramHashMap.getMessage());
      f.a("XFilesExcelReader", i, "invoke error ", paramHashMap);
      b(str, paramValueCallback, -3);
      AppMethodBeat.o(157174);
    }
    return false;
  }
  
  public final String adm(int paramInt)
  {
    AppMethodBeat.i(157173);
    String str = cS(paramInt, "excelreader.apk");
    AppMethodBeat.o(157173);
    return str;
  }
  
  public final String ftd()
  {
    return "com.tencent.xweb.xfiles.excel.ExcelReader";
  }
  
  public final String fte()
  {
    return "com.tencent.xweb.xfiles.excel.ExcelReaderEnvironment";
  }
  
  public final int ftf()
  {
    return 100;
  }
  
  public final String getPluginName()
  {
    return "XFilesExcelReader";
  }
  
  public final void p(HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(157175);
    if (this.IVf == null)
    {
      AppMethodBeat.o(157175);
      return;
    }
    try
    {
      Method localMethod = this.IVf.getMethod("finishReadFile", new Class[] { HashMap.class });
      localMethod.setAccessible(true);
      localMethod.invoke(null, new Object[] { paramHashMap });
      AppMethodBeat.o(157175);
      return;
    }
    catch (Exception paramHashMap)
    {
      Log.e("XFilesExcelReader", "finishReadFile error: " + paramHashMap.getMessage());
      AppMethodBeat.o(157175);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a.a
 * JD-Core Version:    0.7.0.1
 */