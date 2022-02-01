package com.tencent.mm.sensitive;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.platformtools.ExportFileUtil;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sensitive/ExportFileHooker;", "", "()V", "TAG", "", "mExportMethodMap", "Ljava/util/HashMap;", "", "Landroid/util/Pair;", "mSaveBitmapMethodMap", "invokeMethod", "innerClassName", "methodName", "caller", "args", "", "needToast", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/Boolean;)Ljava/lang/Object;", "invokeSaveBitmap", "monitor", "", "sensitive_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  private static final String TAG;
  public static final c acsB;
  private static final HashMap<String, List<Pair<String, String>>> acsC;
  private static final HashMap<String, List<Pair<String, String>>> acsD;
  
  static
  {
    AppMethodBeat.i(240954);
    acsB = new c();
    TAG = "ExportFileHooker";
    acsC = new HashMap();
    acsD = new HashMap();
    AppMethodBeat.o(240954);
  }
  
  private static Object a(String paramString, Object paramObject, Object[] paramArrayOfObject, Boolean paramBoolean)
  {
    AppMethodBeat.i(369584);
    paramString = BitmapUtil.class.getDeclaredMethod(paramString, (Class[])Arrays.copyOf(new Class[] { Bitmap.class, Integer.TYPE, Integer.TYPE, String.class, Boolean.TYPE }, 5));
    if (paramString != null) {
      paramString.setAccessible(true);
    }
    if (paramString == null) {}
    for (paramString = null;; paramString = paramString.invoke(paramObject, Arrays.copyOf(paramArrayOfObject, paramArrayOfObject.length)))
    {
      if (s.p(paramBoolean, Boolean.TRUE)) {
        d.uiThread((kotlin.g.a.a)new c.b(paramString));
      }
      AppMethodBeat.o(369584);
      return paramString;
    }
  }
  
  private static Object a(String paramString1, String paramString2, Object paramObject, Object[] paramArrayOfObject, Boolean paramBoolean)
  {
    AppMethodBeat.i(369585);
    Log.i(TAG, "[invokeMethod] enter, methodName:" + paramString2 + ", caller:" + paramObject + ", args:" + paramArrayOfObject);
    Log.i(TAG, "[invokeMethod]  clazz:" + ExportFileUtil.class + ", inputClassName:" + paramString1);
    switch (paramString2.hashCode())
    {
    default: 
      paramString1 = (Class[])new Class[0];
      label127:
      paramString1 = ExportFileUtil.class.getDeclaredMethod(paramString2, (Class[])Arrays.copyOf(paramString1, paramString1.length));
      Log.i(TAG, s.X("[invokeMethod]  method:", paramString1));
      if (paramString1 != null) {
        paramString1.setAccessible(true);
      }
      if (paramString1 != null) {
        break;
      }
    }
    for (paramString1 = null;; paramString1 = paramString1.invoke(paramObject, Arrays.copyOf(paramArrayOfObject, paramArrayOfObject.length)))
    {
      if (s.p(paramBoolean, Boolean.TRUE)) {
        d.uiThread((kotlin.g.a.a)new c.a(paramString1));
      }
      AppMethodBeat.o(369585);
      return paramString1;
      if (!paramString2.equals("exportImageImpl")) {
        break;
      }
      paramString1 = new Class[3];
      paramString1[0] = Context.class;
      paramString1[1] = String.class;
      paramString1[2] = String.class;
      break label127;
      if (!paramString2.equals("exportToPublicDownloadDirImpl")) {
        break;
      }
      paramString1 = new Class[2];
      paramString1[0] = Context.class;
      paramString1[1] = String.class;
      break label127;
      if (!paramString2.equals("exportVideoImpl")) {
        break;
      }
      paramString1 = new Class[3];
      paramString1[0] = Context.class;
      paramString1[1] = String.class;
      paramString1[2] = String.class;
      break label127;
    }
  }
  
  public static void ayW()
  {
    AppMethodBeat.i(240915);
    Map localMap = (Map)acsC;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Pair.create("exportToPublicDownloadDirImpl", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;"));
    localArrayList.add(Pair.create("exportImageImpl", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;"));
    localArrayList.add(Pair.create("exportVideoImpl", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;"));
    localMap.put("com/tencent/mm/platformtools/ExportFileUtil", localArrayList);
    com.tencent.mm.hellhoundlib.a.aYh();
    com.tencent.mm.hellhoundlib.a.a((Map)acsC, c..ExternalSyntheticLambda0.INSTANCE);
    localMap = (Map)acsD;
    localArrayList = new ArrayList();
    localArrayList.add(Pair.create("saveBitmapToImage", "(Landroid/graphics/Bitmap;II;Ljava/lang/String;Z)Ljava/lang/String;"));
    localMap.put("com/tencent/mm/sdk/platformtools/BitmapUtil", localArrayList);
    com.tencent.mm.hellhoundlib.a.aYh();
    com.tencent.mm.hellhoundlib.a.a((Map)acsD, c..ExternalSyntheticLambda1.INSTANCE);
    AppMethodBeat.o(240915);
  }
  
  private static final Object b(String paramString1, String paramString2, String paramString3, final String paramString4, String paramString5, final Object paramObject, final Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(240939);
    Log.i(TAG, "ExportFileHooker");
    paramString2 = com.tencent.mm.sensitive.ui.a.acvO;
    if (!com.tencent.mm.sensitive.ui.a.iUw())
    {
      paramString2 = com.tencent.mm.sensitive.ui.a.acvO;
      if (com.tencent.mm.sensitive.ui.a.a(d.c.actw, d.a.acto, (b)new c(paramString1, paramString4, paramObject, paramArrayOfObject)))
      {
        AppMethodBeat.o(240939);
        return null;
      }
    }
    s.s(paramString1, "innerClassName");
    s.s(paramString4, "methodName");
    s.s(paramArrayOfObject, "args");
    paramString1 = a(paramString1, paramString4, paramObject, paramArrayOfObject, Boolean.FALSE);
    AppMethodBeat.o(240939);
    return paramString1;
  }
  
  private static final Object c(String paramString1, String paramString2, String paramString3, final String paramString4, String paramString5, final Object paramObject, final Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(240944);
    Log.i(TAG, "saveBitmapToImage");
    paramString2 = com.tencent.mm.sensitive.ui.a.acvO;
    if (!com.tencent.mm.sensitive.ui.a.iUw())
    {
      paramString2 = com.tencent.mm.sensitive.ui.a.acvO;
      if (com.tencent.mm.sensitive.ui.a.a(d.c.actw, d.a.acto, (b)new d(paramString1, paramString4, paramObject, paramArrayOfObject)))
      {
        AppMethodBeat.o(240944);
        return null;
      }
    }
    s.s(paramString1, "innerClassName");
    s.s(paramString4, "methodName");
    s.s(paramArrayOfObject, "args");
    paramString1 = a(paramString4, paramObject, paramArrayOfObject, Boolean.FALSE);
    AppMethodBeat.o(240944);
    return paramString1;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "isOk", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements b<Boolean, ah>
  {
    c(String paramString1, String paramString2, Object paramObject, Object[] paramArrayOfObject)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "isOk", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements b<Boolean, ah>
  {
    d(String paramString1, String paramString2, Object paramObject, Object[] paramArrayOfObject)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.sensitive.c
 * JD-Core Version:    0.7.0.1
 */