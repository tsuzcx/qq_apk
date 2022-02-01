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
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;

public final class i
{
  public static void a(Context paramContext, final r paramr, final Button paramButton)
  {
    int j = 0;
    AppMethodBeat.i(267616);
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
        AppMethodBeat.o(267616);
        return;
      }
      catch (Throwable paramContext)
      {
        Log.e("BtnIconUpdateHelper", paramContext.toString());
        AppMethodBeat.o(267616);
        return;
      }
      int i = j;
      if (!Util.isNullOrNil(paramr.Kmb)) {
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
      AppMethodBeat.o(267616);
      return;
    }
    paramButton.addOnLayoutChangeListener(new View.OnLayoutChangeListener()
    {
      public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
      {
        AppMethodBeat.i(253958);
        try
        {
          Log.i("BtnIconUpdateHelper", "after onLayoutChange, then updateBtnIconLogic");
          i.b(this.val$context, paramr, paramButton);
          paramButton.removeOnLayoutChangeListener(this);
          AppMethodBeat.o(253958);
          return;
        }
        catch (Throwable paramAnonymousView)
        {
          Log.e("BtnIconUpdateHelper", paramAnonymousView.toString());
          AppMethodBeat.o(253958);
        }
      }
    });
    AppMethodBeat.o(267616);
  }
  
  static void a(Context paramContext, r paramr, Button paramButton, String paramString)
  {
    AppMethodBeat.i(267619);
    paramString = BitmapUtil.decodeFile(paramString, null);
    if (paramString == null)
    {
      Log.e("BtnIconUpdateHelper", "onDownloaded, bitmap == null");
      AppMethodBeat.o(267619);
      return;
    }
    paramString = new BitmapDrawable(paramString);
    float f2 = paramr.Kmc;
    float f1 = f2;
    if (f2 <= 0.0F) {
      f1 = com.tencent.mm.ci.a.fromDPToPix(paramContext, 20);
    }
    int i = com.tencent.mm.ci.a.fromDPToPix(paramContext, 4);
    f2 = paramButton.getPaint().measureText(paramButton.getText().toString());
    float f3 = i;
    float f4 = paramButton.getWidth();
    Log.i("BtnIconUpdateHelper", "btn width = ".concat(String.valueOf(f4)));
    int j = (int)(f4 - (f2 + (f3 + f1))) / 2;
    if (j < 0)
    {
      Log.d("BtnIconUpdateHelper", "updateBtnIcon but horizontalPadding < 0");
      AppMethodBeat.o(267619);
      return;
    }
    Log.i("BtnIconUpdateHelper", "horizontalPadding = ".concat(String.valueOf(j)));
    paramButton.setPadding(j, 0, j, 0);
    paramButton.setIncludeFontPadding(false);
    androidx.core.graphics.drawable.a.a(paramString, Color.parseColor(paramr.KlM));
    paramString.setBounds(0, 0, (int)f1, (int)f1);
    paramButton.setCompoundDrawables(paramString, null, null, null);
    paramButton.setCompoundDrawablePadding(i);
    AppMethodBeat.o(267619);
  }
  
  static void b(Context paramContext, r paramr, Button paramButton)
  {
    AppMethodBeat.i(267617);
    String str = h.kU("adId", paramr.Kmb);
    if ((!Util.isNullOrNil(str)) && (u.agG(str)))
    {
      Log.i("BtnIconUpdateHelper", "icon exists, url = " + paramr.Kmb);
      a(paramContext, paramr, paramButton, str);
      AppMethodBeat.o(267617);
      return;
    }
    c(paramContext, paramr, paramButton);
    AppMethodBeat.o(267617);
  }
  
  private static void c(final Context paramContext, final r paramr, Button paramButton)
  {
    AppMethodBeat.i(267620);
    final String str = paramr.Kmb;
    if (Util.isNullOrNil(str))
    {
      AppMethodBeat.o(267620);
      return;
    }
    Log.d("BtnIconUpdateHelper", "loadImage, hash = " + paramButton.hashCode() + ", btnIconUrl = " + str);
    paramButton.setTag(i.f.sns_ad_card_img_url, str);
    h.a("adId", str, new f.a()
    {
      public final void aYs(String paramAnonymousString)
      {
        AppMethodBeat.i(268869);
        try
        {
          String str = (String)this.HqE.getTag(i.f.sns_ad_card_img_url);
          if (Util.isNullOrNil(str)) {}
          for (str = ""; (!Util.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equals(str)); str = h.kU("adId", str))
          {
            i.a(paramContext, paramr, this.HqE, paramAnonymousString);
            Log.d("BtnIconUpdateHelper", "onDownloaded succ, hash = " + this.HqE.hashCode());
            AppMethodBeat.o(268869);
            return;
          }
          Log.d("BtnIconUpdateHelper", "onDownloaded, url changed");
          AppMethodBeat.o(268869);
          return;
        }
        catch (Throwable paramAnonymousString)
        {
          Log.e("BtnIconUpdateHelper", "onDownloaded, exp=" + paramAnonymousString.toString());
          AppMethodBeat.o(268869);
        }
      }
      
      public final void fJU() {}
      
      public final void fJV()
      {
        AppMethodBeat.i(268868);
        this.HqE.setTag(i.f.sns_ad_card_img_url, "");
        Log.e("BtnIconUpdateHelper", "onDownloadError, hash = " + this.HqE.hashCode() + ", url = " + str);
        AppMethodBeat.o(268868);
      }
    });
    AppMethodBeat.o(267620);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.d.i
 * JD-Core Version:    0.7.0.1
 */