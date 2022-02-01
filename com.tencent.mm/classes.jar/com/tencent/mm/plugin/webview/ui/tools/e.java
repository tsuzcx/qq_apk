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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.webview.stub.f;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.vfs.s;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class e
{
  private static final HashMap<String, WeakReference<Bitmap>> JeH;
  
  static
  {
    AppMethodBeat.i(79687);
    JeH = new HashMap();
    AppMethodBeat.o(79687);
  }
  
  public static void a(com.tencent.mm.plugin.webview.stub.e parame, int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(79678);
    ArrayList localArrayList = new ArrayList();
    if (paramVarArgs.length == 0)
    {
      AppMethodBeat.o(79678);
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
      parame.v(paramInt, localArrayList);
      AppMethodBeat.o(79678);
      return;
    }
    catch (Exception parame)
    {
      Log.w("MicroMsg.WebView.RemoteUtil", "kvReport, ex = " + parame.getMessage());
      AppMethodBeat.o(79678);
    }
  }
  
  public static boolean a(Bundle paramBundle, String paramString1, String paramString2, f paramf, Runnable paramRunnable)
  {
    AppMethodBeat.i(79686);
    if (paramf == null)
    {
      if (paramRunnable != null) {
        paramRunnable.run();
      }
      AppMethodBeat.o(79686);
      return true;
    }
    Bundle localBundle = new Bundle(3);
    localBundle.putBundle("open_ui_with_webview_ui_extras", paramBundle);
    localBundle.putString("open_ui_with_webview_ui_plugin_name", paramString1);
    localBundle.putString("open_ui_with_webview_ui_plugin_entry", paramString2);
    try
    {
      paramf.j(101, localBundle);
      AppMethodBeat.o(79686);
      return true;
    }
    catch (RemoteException paramBundle)
    {
      Log.printErrStackTrace("MicroMsg.WebView.RemoteUtil", paramBundle, "startUIWithWebViewUI, exp, pluginName %s, pluginEntry %s", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(79686);
      return false;
    }
    catch (Exception paramBundle)
    {
      if (paramRunnable != null) {
        paramRunnable.run();
      }
      Log.printErrStackTrace("MicroMsg.WebView.RemoteUtil", paramBundle, "startUIWithWebViewUI, exp, pluginName %s, pluginEntry %s", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(79686);
    }
    return false;
  }
  
  public static int agC(int paramInt)
  {
    AppMethodBeat.i(79685);
    paramInt = ao.agC(paramInt);
    AppMethodBeat.o(79685);
    return paramInt;
  }
  
  private static long bA(String paramString, long paramLong)
  {
    AppMethodBeat.i(79683);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(79683);
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
      paramLong = i;
      AppMethodBeat.o(79683);
      return 0xFFFFFFFF & paramLong;
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.WebView.RemoteUtil", "Failed to parse color: %s", new Object[] { localObject });
      AppMethodBeat.o(79683);
    }
    return paramLong;
  }
  
  public static Bitmap baf(String paramString)
  {
    AppMethodBeat.i(79680);
    Object localObject = (WeakReference)JeH.get(paramString);
    if ((localObject != null) && (((WeakReference)localObject).get() != null) && (!((Bitmap)((WeakReference)localObject).get()).isRecycled()))
    {
      paramString = (Bitmap)((WeakReference)localObject).get();
      AppMethodBeat.o(79680);
      return paramString;
    }
    if (s.YS(paramString)) {}
    for (localObject = BitmapUtil.decodeFile(paramString, null);; localObject = null)
    {
      if (localObject != null) {
        JeH.put(paramString, new WeakReference(localObject));
      }
      for (;;)
      {
        AppMethodBeat.o(79680);
        return localObject;
        try
        {
          Bitmap localBitmap = BackwardSupportUtil.BitmapFactory.decodeStream(MMApplicationContext.getContext().getAssets().open("avatar/default_nor_avatar.png"), a.getDensity(null));
          localObject = localBitmap;
          JeH.put(paramString, new WeakReference(localBitmap));
          localObject = localBitmap;
        }
        catch (Exception paramString)
        {
          Log.printErrStackTrace("MicroMsg.WebView.RemoteUtil", paramString, "", new Object[0]);
        }
      }
    }
  }
  
  public static long bag(String paramString)
  {
    AppMethodBeat.i(79681);
    long l = bA(paramString, -1L);
    AppMethodBeat.o(79681);
    return l;
  }
  
  public static Bitmap bah(String paramString)
  {
    AppMethodBeat.i(79684);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(79684);
      return null;
    }
    Object localObject1 = (WeakReference)JeH.get(paramString);
    if ((localObject1 != null) && (((WeakReference)localObject1).get() != null) && (!((Bitmap)((WeakReference)localObject1).get()).isRecycled()))
    {
      paramString = (Bitmap)((WeakReference)localObject1).get();
      AppMethodBeat.o(79684);
      return paramString;
    }
    localObject1 = Base64.decode(paramString, 0);
    if (localObject1 == null)
    {
      AppMethodBeat.o(79684);
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
      if (localObject1 == null)
      {
        AppMethodBeat.o(79684);
        return null;
      }
      k = ((Bitmap)localObject1).getWidth();
      j = ((Bitmap)localObject1).getHeight();
      i = Math.min(k, j);
    }
    do
    {
      localObject2 = Bitmap.createBitmap((Bitmap)localObject1, Math.max(k / 2 - i / 2, 0), Math.max(j / 2 - i / 2, 0), i, i);
      if (localObject2 != localObject1) {
        ((Bitmap)localObject1).recycle();
      }
      localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject2, 96, 96, false);
      if (localObject2 != localObject1)
      {
        Log.i("MicroMsg.WebView.RemoteUtil", "bitmap recycle %s", new Object[] { localObject2.toString() });
        ((Bitmap)localObject2).recycle();
      }
      if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled())) {
        JeH.put(paramString, new WeakReference(localObject1));
      }
      AppMethodBeat.o(79684);
      return localObject1;
      localObject2 = BitmapFactory.decodeByteArray((byte[])localObject1, 0, localObject1.length, (BitmapFactory.Options)localObject2);
      localObject1 = localObject2;
    } while (localObject2 != null);
    AppMethodBeat.o(79684);
    return null;
  }
  
  public static int gw(String paramString, int paramInt)
  {
    AppMethodBeat.i(79682);
    paramInt = (int)bA(paramString, paramInt);
    AppMethodBeat.o(79682);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.e
 * JD-Core Version:    0.7.0.1
 */