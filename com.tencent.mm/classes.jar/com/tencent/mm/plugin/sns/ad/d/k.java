package com.tencent.mm.plugin.sns.ad.d;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g.a;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;

public final class k
{
  public static void a(Context paramContext, final r paramr, final Button paramButton)
  {
    int j = 0;
    AppMethodBeat.i(309946);
    if ((paramContext == null) || (paramr == null) || (paramButton == null)) {}
    for (;;)
    {
      try
      {
        Log.e("BtnIconUpdateHelper", "context or btnInfo or btn is null ");
        i = j;
        if (i != 0) {
          break;
        }
        AppMethodBeat.o(309946);
        return;
      }
      finally
      {
        Log.e("BtnIconUpdateHelper", paramContext.toString());
        AppMethodBeat.o(309946);
        return;
      }
      int i = j;
      if (!Util.isNullOrNil(paramr.QKf)) {
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
      b(paramContext, paramr, paramButton);
      AppMethodBeat.o(309946);
      return;
    }
    paramButton.addOnLayoutChangeListener(new View.OnLayoutChangeListener()
    {
      public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
      {
        AppMethodBeat.i(310057);
        try
        {
          Log.i("BtnIconUpdateHelper", "after onLayoutChange, then updateBtnIconLogic");
          k.b(k.this, paramr, paramButton);
          paramButton.removeOnLayoutChangeListener(this);
          AppMethodBeat.o(310057);
          return;
        }
        finally
        {
          Log.e("BtnIconUpdateHelper", paramAnonymousView.toString());
          AppMethodBeat.o(310057);
        }
      }
    });
    AppMethodBeat.o(309946);
  }
  
  static void a(Context paramContext, r paramr, Button paramButton, String paramString)
  {
    AppMethodBeat.i(309960);
    paramString = BitmapUtil.decodeFile(paramString, null);
    if (paramString == null)
    {
      Log.e("BtnIconUpdateHelper", "onDownloaded, bitmap == null");
      AppMethodBeat.o(309960);
      return;
    }
    paramString = new BitmapDrawable(paramString);
    float f2 = paramr.QKg;
    float f1 = f2;
    if (f2 <= 0.0F) {
      f1 = com.tencent.mm.cd.a.fromDPToPix(paramContext, 20);
    }
    int i = com.tencent.mm.cd.a.fromDPToPix(paramContext, 4);
    f2 = paramButton.getPaint().measureText(paramButton.getText().toString());
    float f3 = i;
    float f4 = paramButton.getWidth();
    Log.i("BtnIconUpdateHelper", "btn width = ".concat(String.valueOf(f4)));
    int j = (int)(f4 - (f2 + (f3 + f1))) / 2;
    if (j < 0)
    {
      Log.d("BtnIconUpdateHelper", "updateBtnIcon but horizontalPadding < 0");
      AppMethodBeat.o(309960);
      return;
    }
    Log.i("BtnIconUpdateHelper", "horizontalPadding = ".concat(String.valueOf(j)));
    paramButton.setPadding(j, 0, j, 0);
    paramButton.setIncludeFontPadding(false);
    androidx.core.graphics.drawable.a.a(paramString, Color.parseColor(paramr.QJR));
    paramString.setBounds(0, 0, (int)f1, (int)f1);
    paramButton.setCompoundDrawables(paramString, null, null, null);
    paramButton.setCompoundDrawablePadding(i);
    AppMethodBeat.o(309960);
  }
  
  static void b(Context paramContext, r paramr, Button paramButton)
  {
    AppMethodBeat.i(309950);
    String str = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k.mC("adId", paramr.QKf);
    if ((!Util.isNullOrNil(str)) && (y.ZC(str)))
    {
      Log.i("BtnIconUpdateHelper", "icon exists, url = " + paramr.QKf);
      a(paramContext, paramr, paramButton, str);
      AppMethodBeat.o(309950);
      return;
    }
    c(paramContext, paramr, paramButton);
    AppMethodBeat.o(309950);
  }
  
  private static void c(final Context paramContext, final r paramr, Button paramButton)
  {
    AppMethodBeat.i(309968);
    final String str = paramr.QKf;
    if (Util.isNullOrNil(str))
    {
      AppMethodBeat.o(309968);
      return;
    }
    Log.d("BtnIconUpdateHelper", "loadImage, hash = " + paramButton.hashCode() + ", btnIconUrl = " + str);
    paramButton.setTag(b.f.sns_ad_card_img_url, str);
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k.b("adId", str, new g.a()
    {
      public final void aWn(String paramAnonymousString)
      {
        AppMethodBeat.i(310076);
        try
        {
          String str = (String)k.this.getTag(b.f.sns_ad_card_img_url);
          if (Util.isNullOrNil(str)) {}
          for (str = ""; (!Util.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equals(str)); str = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k.mC("adId", str))
          {
            k.a(paramContext, paramr, k.this, paramAnonymousString);
            Log.d("BtnIconUpdateHelper", "onDownloaded succ, hash = " + k.this.hashCode());
            AppMethodBeat.o(310076);
            return;
          }
          Log.d("BtnIconUpdateHelper", "onDownloaded, url changed");
          AppMethodBeat.o(310076);
          return;
        }
        finally
        {
          Log.e("BtnIconUpdateHelper", "onDownloaded, exp=" + paramAnonymousString.toString());
          AppMethodBeat.o(310076);
        }
      }
      
      public final void gZM() {}
      
      public final void gZN()
      {
        AppMethodBeat.i(310070);
        k.this.setTag(b.f.sns_ad_card_img_url, "");
        Log.e("BtnIconUpdateHelper", "onDownloadError, hash = " + k.this.hashCode() + ", url = " + str);
        AppMethodBeat.o(310070);
      }
    });
    AppMethodBeat.o(309968);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.d.k
 * JD-Core Version:    0.7.0.1
 */