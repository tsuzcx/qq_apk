package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Base64;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.ak;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class e
{
  private static final HashMap<String, WeakReference<Bitmap>> rlK = new HashMap();
  
  public static int Cx(int paramInt)
  {
    return ak.Cx(paramInt);
  }
  
  public static Bitmap Td(String paramString)
  {
    Object localObject = (WeakReference)rlK.get(paramString);
    if ((localObject != null) && (((WeakReference)localObject).get() != null) && (!((Bitmap)((WeakReference)localObject).get()).isRecycled())) {
      return (Bitmap)((WeakReference)localObject).get();
    }
    if (com.tencent.mm.vfs.e.bK(paramString)) {}
    for (localObject = c.decodeFile(paramString, null);; localObject = null)
    {
      if (localObject != null)
      {
        rlK.put(paramString, new WeakReference(localObject));
        return localObject;
      }
      try
      {
        Bitmap localBitmap = BackwardSupportUtil.b.a(ae.getContext().getAssets().open("avatar/default_nor_avatar.png"), a.getDensity(null));
        localObject = localBitmap;
        rlK.put(paramString, new WeakReference(localBitmap));
        return localBitmap;
      }
      catch (Exception paramString)
      {
        y.printErrStackTrace("MicroMsg.WebView.RemoteUtil", paramString, "", new Object[0]);
        return localObject;
      }
    }
  }
  
  public static Bitmap Te(String paramString)
  {
    if (bk.bl(paramString))
    {
      localObject1 = null;
      return localObject1;
    }
    Object localObject1 = (WeakReference)rlK.get(paramString);
    if ((localObject1 != null) && (((WeakReference)localObject1).get() != null) && (!((Bitmap)((WeakReference)localObject1).get()).isRecycled())) {
      return (Bitmap)((WeakReference)localObject1).get();
    }
    localObject1 = Base64.decode(paramString, 0);
    if (localObject1 == null) {
      return null;
    }
    Object localObject2 = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
    BitmapFactory.decodeByteArray((byte[])localObject1, 0, localObject1.length, (BitmapFactory.Options)localObject2);
    int k = ((BitmapFactory.Options)localObject2).outWidth;
    int j = ((BitmapFactory.Options)localObject2).outHeight;
    int i = Math.min(((BitmapFactory.Options)localObject2).outWidth, ((BitmapFactory.Options)localObject2).outHeight);
    ((BitmapFactory.Options)localObject2).inJustDecodeBounds = false;
    if (i > 96)
    {
      ((BitmapFactory.Options)localObject2).inSampleSize = Math.max((int)(i * 1.0F / 96.0F), 1);
      localObject1 = BitmapFactory.decodeByteArray((byte[])localObject1, 0, localObject1.length, (BitmapFactory.Options)localObject2);
      if (localObject1 == null) {
        return null;
      }
      k = ((Bitmap)localObject1).getWidth();
      j = ((Bitmap)localObject1).getHeight();
      i = Math.min(k, j);
    }
    do
    {
      Bitmap localBitmap = Bitmap.createBitmap((Bitmap)localObject1, Math.max(k / 2 - i / 2, 0), Math.max(j / 2 - i / 2, 0), i, i);
      if (localBitmap != localObject1) {
        ((Bitmap)localObject1).recycle();
      }
      localObject2 = Bitmap.createScaledBitmap(localBitmap, 96, 96, false);
      if (localBitmap != localObject2) {
        localBitmap.recycle();
      }
      localObject1 = localObject2;
      if (localObject2 == null) {
        break;
      }
      localObject1 = localObject2;
      if (((Bitmap)localObject2).isRecycled()) {
        break;
      }
      rlK.put(paramString, new WeakReference(localObject2));
      return localObject2;
      localObject2 = BitmapFactory.decodeByteArray((byte[])localObject1, 0, localObject1.length, (BitmapFactory.Options)localObject2);
      localObject1 = localObject2;
    } while (localObject2 != null);
    return null;
  }
  
  public static void a(d paramd, int paramInt, List<String> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    try
    {
      paramd.h(paramInt, paramList);
      return;
    }
    catch (Exception paramd)
    {
      y.w("MicroMsg.WebView.RemoteUtil", "kvReport, ex = " + paramd.getMessage());
    }
  }
  
  public static void a(d paramd, int paramInt, Object... paramVarArgs)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {
      return;
    }
    try
    {
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        localArrayList.add(String.valueOf(paramVarArgs[i]));
        i += 1;
      }
      paramd.h(paramInt, localArrayList);
      return;
    }
    catch (Exception paramd)
    {
      y.w("MicroMsg.WebView.RemoteUtil", "kvReport, ex = " + paramd.getMessage());
    }
  }
  
  public static boolean a(Bundle paramBundle, String paramString1, String paramString2, com.tencent.mm.plugin.webview.stub.e parame, Runnable paramRunnable)
  {
    if (parame == null)
    {
      if (paramRunnable != null) {
        paramRunnable.run();
      }
      return true;
    }
    paramRunnable = new Bundle(3);
    paramRunnable.putBundle("open_ui_with_webview_ui_extras", paramBundle);
    paramRunnable.putString("open_ui_with_webview_ui_plugin_name", paramString1);
    paramRunnable.putString("open_ui_with_webview_ui_plugin_entry", paramString2);
    try
    {
      parame.f(101, paramRunnable);
      return true;
    }
    catch (RemoteException paramBundle)
    {
      y.printErrStackTrace("MicroMsg.WebView.RemoteUtil", paramBundle, "startUIWithWebViewUI, exp, pluginName %s, pluginEntry %s", new Object[] { paramString1, paramString2 });
    }
    return false;
  }
  
  public static int bb(String paramString, int paramInt)
  {
    return (int)x(paramString, Long.valueOf(paramInt).longValue());
  }
  
  private static long x(String paramString, long paramLong)
  {
    if (bk.bl(paramString)) {
      return paramLong;
    }
    Object localObject = paramString;
    if (paramString.startsWith("#"))
    {
      localObject = paramString;
      if (paramString.length() == 4)
      {
        localObject = new StringBuilder(paramString);
        ((StringBuilder)localObject).insert(2, paramString.charAt(1));
        ((StringBuilder)localObject).insert(4, paramString.charAt(2));
        ((StringBuilder)localObject).insert(6, paramString.charAt(3));
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    try
    {
      int i = Color.parseColor((String)localObject);
      return 0xFFFFFFFF & i;
    }
    catch (Exception paramString)
    {
      y.e("MicroMsg.WebView.RemoteUtil", "Failed to parse color: %s", new Object[] { localObject });
    }
    return paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.e
 * JD-Core Version:    0.7.0.1
 */