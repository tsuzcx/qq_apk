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
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.af;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class g
{
  private static final HashMap<String, WeakReference<Bitmap>> vbm;
  
  static
  {
    AppMethodBeat.i(7489);
    vbm = new HashMap();
    AppMethodBeat.o(7489);
  }
  
  private static long G(String paramString, long paramLong)
  {
    AppMethodBeat.i(7485);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(7485);
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
      AppMethodBeat.o(7485);
      return 0xFFFFFFFF & paramLong;
    }
    catch (Exception paramString)
    {
      ab.e("MicroMsg.WebView.RemoteUtil", "Failed to parse color: %s", new Object[] { localObject });
      AppMethodBeat.o(7485);
    }
    return paramLong;
  }
  
  public static int Kq(int paramInt)
  {
    AppMethodBeat.i(7487);
    paramInt = af.Kq(paramInt);
    AppMethodBeat.o(7487);
    return paramInt;
  }
  
  public static void a(com.tencent.mm.plugin.webview.stub.d paramd, int paramInt, List<String> paramList)
  {
    AppMethodBeat.i(7481);
    if ((paramList == null) || (paramList.size() == 0))
    {
      AppMethodBeat.o(7481);
      return;
    }
    try
    {
      paramd.k(paramInt, paramList);
      AppMethodBeat.o(7481);
      return;
    }
    catch (Exception paramd)
    {
      ab.w("MicroMsg.WebView.RemoteUtil", "kvReport, ex = " + paramd.getMessage());
      AppMethodBeat.o(7481);
    }
  }
  
  public static void a(com.tencent.mm.plugin.webview.stub.d paramd, int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(7480);
    ArrayList localArrayList = new ArrayList();
    if ((paramVarArgs == null) || (paramVarArgs.length == 0))
    {
      AppMethodBeat.o(7480);
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
      paramd.k(paramInt, localArrayList);
      AppMethodBeat.o(7480);
      return;
    }
    catch (Exception paramd)
    {
      ab.w("MicroMsg.WebView.RemoteUtil", "kvReport, ex = " + paramd.getMessage());
      AppMethodBeat.o(7480);
    }
  }
  
  public static boolean a(Bundle paramBundle, String paramString1, String paramString2, com.tencent.mm.plugin.webview.stub.e parame, Runnable paramRunnable)
  {
    AppMethodBeat.i(7488);
    if (parame == null)
    {
      if (paramRunnable != null) {
        paramRunnable.run();
      }
      AppMethodBeat.o(7488);
      return true;
    }
    Bundle localBundle = new Bundle(3);
    localBundle.putBundle("open_ui_with_webview_ui_extras", paramBundle);
    localBundle.putString("open_ui_with_webview_ui_plugin_name", paramString1);
    localBundle.putString("open_ui_with_webview_ui_plugin_entry", paramString2);
    try
    {
      parame.i(101, localBundle);
      AppMethodBeat.o(7488);
      return true;
    }
    catch (RemoteException paramBundle)
    {
      ab.printErrStackTrace("MicroMsg.WebView.RemoteUtil", paramBundle, "startUIWithWebViewUI, exp, pluginName %s, pluginEntry %s", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(7488);
      return false;
    }
    catch (Exception paramBundle)
    {
      if (paramRunnable != null) {
        paramRunnable.run();
      }
      ab.printErrStackTrace("MicroMsg.WebView.RemoteUtil", paramBundle, "startUIWithWebViewUI, exp, pluginName %s, pluginEntry %s", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(7488);
    }
    return false;
  }
  
  public static Bitmap aie(String paramString)
  {
    AppMethodBeat.i(7482);
    Object localObject = (WeakReference)vbm.get(paramString);
    if ((localObject != null) && (((WeakReference)localObject).get() != null) && (!((Bitmap)((WeakReference)localObject).get()).isRecycled()))
    {
      paramString = (Bitmap)((WeakReference)localObject).get();
      AppMethodBeat.o(7482);
      return paramString;
    }
    if (com.tencent.mm.vfs.e.cN(paramString)) {}
    for (localObject = com.tencent.mm.sdk.platformtools.d.decodeFile(paramString, null);; localObject = null)
    {
      if (localObject != null) {
        vbm.put(paramString, new WeakReference(localObject));
      }
      for (;;)
      {
        AppMethodBeat.o(7482);
        return localObject;
        try
        {
          Bitmap localBitmap = BackwardSupportUtil.b.b(ah.getContext().getAssets().open("avatar/default_nor_avatar.png"), a.getDensity(null));
          localObject = localBitmap;
          vbm.put(paramString, new WeakReference(localBitmap));
          localObject = localBitmap;
        }
        catch (Exception paramString)
        {
          ab.printErrStackTrace("MicroMsg.WebView.RemoteUtil", paramString, "", new Object[0]);
        }
      }
    }
  }
  
  public static long aif(String paramString)
  {
    AppMethodBeat.i(7483);
    long l = G(paramString, -1L);
    AppMethodBeat.o(7483);
    return l;
  }
  
  public static Bitmap aig(String paramString)
  {
    AppMethodBeat.i(7486);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(7486);
      return null;
    }
    Object localObject1 = (WeakReference)vbm.get(paramString);
    if ((localObject1 != null) && (((WeakReference)localObject1).get() != null) && (!((Bitmap)((WeakReference)localObject1).get()).isRecycled()))
    {
      paramString = (Bitmap)((WeakReference)localObject1).get();
      AppMethodBeat.o(7486);
      return paramString;
    }
    localObject1 = Base64.decode(paramString, 0);
    if (localObject1 == null)
    {
      AppMethodBeat.o(7486);
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
        AppMethodBeat.o(7486);
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
        ab.i("MicroMsg.WebView.RemoteUtil", "bitmap recycle %s", new Object[] { localObject2.toString() });
        ((Bitmap)localObject2).recycle();
      }
      if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled())) {
        vbm.put(paramString, new WeakReference(localObject1));
      }
      AppMethodBeat.o(7486);
      return localObject1;
      localObject2 = BitmapFactory.decodeByteArray((byte[])localObject1, 0, localObject1.length, (BitmapFactory.Options)localObject2);
      localObject1 = localObject2;
    } while (localObject2 != null);
    AppMethodBeat.o(7486);
    return null;
  }
  
  public static int by(String paramString, int paramInt)
  {
    AppMethodBeat.i(7484);
    paramInt = (int)G(paramString, paramInt);
    AppMethodBeat.o(7484);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.g
 * JD-Core Version:    0.7.0.1
 */