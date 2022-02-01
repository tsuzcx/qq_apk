package com.tencent.mm.plugin.sns.ad.e;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;

public final class f
{
  public static void a(Context paramContext, final q paramq, final Button paramButton)
  {
    int j = 0;
    AppMethodBeat.i(201919);
    if ((paramContext == null) || (paramq == null) || (paramButton == null)) {}
    for (;;)
    {
      try
      {
        Log.e("BtnIconUpdateHelper", "context or btnInfo or btn is null ");
        i = j;
        if (i != 0) {
          break;
        }
        AppMethodBeat.o(201919);
        return;
      }
      catch (Throwable paramContext)
      {
        Log.e("BtnIconUpdateHelper", paramContext.toString());
        AppMethodBeat.o(201919);
        return;
      }
      int i = j;
      if (!Util.isNullOrNil(paramq.DYH)) {
        if (Util.isNullOrNil(paramButton.getText()))
        {
          Log.e("BtnIconUpdateHelper", "btnText is null ");
          i = j;
        }
        else
        {
          i = 1;
        }
      }
    }
    if (paramButton.getWidth() > 0)
    {
      Log.i("BtnIconUpdateHelper", "already onLayoutChange, then updateBtnIconLogic");
      b(paramContext, paramq, paramButton);
      AppMethodBeat.o(201919);
      return;
    }
    paramButton.addOnLayoutChangeListener(new View.OnLayoutChangeListener()
    {
      public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
      {
        AppMethodBeat.i(201916);
        try
        {
          Log.i("BtnIconUpdateHelper", "after onLayoutChange, then updateBtnIconLogic");
          f.b(this.val$context, paramq, paramButton);
          paramButton.removeOnLayoutChangeListener(this);
          AppMethodBeat.o(201916);
          return;
        }
        catch (Throwable paramAnonymousView)
        {
          Log.e("BtnIconUpdateHelper", paramAnonymousView.toString());
          AppMethodBeat.o(201916);
        }
      }
    });
    AppMethodBeat.o(201919);
  }
  
  static void a(Context paramContext, q paramq, Button paramButton, String paramString)
  {
    AppMethodBeat.i(201921);
    paramString = BitmapUtil.decodeFile(paramString, null);
    if (paramString == null)
    {
      Log.e("BtnIconUpdateHelper", "onDownloaded, bitmap == null");
      AppMethodBeat.o(201921);
      return;
    }
    paramString = new BitmapDrawable(paramString);
    int i = com.tencent.mm.cb.a.fromDPToPix(paramContext, 20);
    int j = com.tencent.mm.cb.a.fromDPToPix(paramContext, 20);
    int k = com.tencent.mm.cb.a.fromDPToPix(paramContext, 4);
    float f1 = paramButton.getPaint().measureText(paramButton.getText().toString());
    float f2 = i + k;
    float f3 = paramButton.getWidth();
    Log.i("BtnIconUpdateHelper", "btn width = ".concat(String.valueOf(f3)));
    int m = (int)(f3 - (f1 + f2)) / 2;
    if (m < 0)
    {
      Log.d("BtnIconUpdateHelper", "updateBtnIcon but horizontalPadding < 0");
      AppMethodBeat.o(201921);
      return;
    }
    Log.i("BtnIconUpdateHelper", "horizontalPadding = ".concat(String.valueOf(m)));
    paramButton.setPadding(m, 0, m, 0);
    paramButton.setIncludeFontPadding(false);
    android.support.v4.graphics.drawable.a.a(paramString, Color.parseColor(paramq.DYt));
    paramString.setBounds(0, 0, i, j);
    paramButton.setCompoundDrawables(paramString, null, null, null);
    paramButton.setCompoundDrawablePadding(k);
    AppMethodBeat.o(201921);
  }
  
  static void b(Context paramContext, q paramq, Button paramButton)
  {
    AppMethodBeat.i(201920);
    String str = h.kz("adId", paramq.DYH);
    if ((!Util.isNullOrNil(str)) && (s.YS(str)))
    {
      Log.i("BtnIconUpdateHelper", "icon exists, url = " + paramq.DYH);
      a(paramContext, paramq, paramButton, str);
      AppMethodBeat.o(201920);
      return;
    }
    c(paramContext, paramq, paramButton);
    AppMethodBeat.o(201920);
  }
  
  private static void c(final Context paramContext, final q paramq, Button paramButton)
  {
    AppMethodBeat.i(201922);
    final String str = paramq.DYH;
    if (Util.isNullOrNil(str))
    {
      AppMethodBeat.o(201922);
      return;
    }
    Log.d("BtnIconUpdateHelper", "loadImage, hash = " + paramButton.hashCode() + ", btnIconUrl = " + str);
    paramButton.setTag(2131307979, str);
    h.a(str, false, new f.a()
    {
      public final void aNH(String paramAnonymousString)
      {
        AppMethodBeat.i(201918);
        try
        {
          String str = (String)this.Bwj.getTag(2131307979);
          if (Util.isNullOrNil(str)) {}
          for (str = ""; (!Util.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equals(str)); str = h.kz("adId", str))
          {
            f.a(paramContext, paramq, this.Bwj, paramAnonymousString);
            Log.d("BtnIconUpdateHelper", "onDownloaded succ, hash = " + this.Bwj.hashCode());
            AppMethodBeat.o(201918);
            return;
          }
          Log.d("BtnIconUpdateHelper", "onDownloaded, url changed");
          AppMethodBeat.o(201918);
          return;
        }
        catch (Throwable paramAnonymousString)
        {
          Log.e("BtnIconUpdateHelper", "onDownloaded, exp=" + paramAnonymousString.toString());
          AppMethodBeat.o(201918);
        }
      }
      
      public final void eWN() {}
      
      public final void eWO()
      {
        AppMethodBeat.i(201917);
        this.Bwj.setTag(2131307979, "");
        Log.e("BtnIconUpdateHelper", "onDownloadError, hash = " + this.Bwj.hashCode() + ", url = " + str);
        AppMethodBeat.o(201917);
      }
    });
    AppMethodBeat.o(201922);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.e.f
 * JD-Core Version:    0.7.0.1
 */