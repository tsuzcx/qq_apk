package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.Spanned;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;
import com.tencent.e.i;
import com.tencent.e.i.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.i.c;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;

public final class al
  extends m
{
  private b Kub;
  volatile boolean Kuc = false;
  TextView bFR;
  
  public al(Context paramContext, ah paramah, ViewGroup paramViewGroup)
  {
    super(paramContext, paramah, paramViewGroup);
  }
  
  protected final void fKe()
  {
    AppMethodBeat.i(96801);
    if (((ah)this.KqB).textSize > 0.0F) {
      this.bFR.setTextSize(0, ((ah)this.KqB).textSize);
    }
    Object localObject;
    if (((ah)this.KqB).subType == 1)
    {
      if (!Util.isNullOrNil(((ah)this.KqB).Knk))
      {
        localObject = ((ah)this.KqB).Knk.trim().replace("<icon", "<img");
        if (this.Kub != null) {
          this.Kub.cancel();
        }
        this.Kub = new b()
        {
          public final String getKey()
          {
            return "MicroMsg.Sns.AdLandingPageTextComponent";
          }
          
          public final void run()
          {
            AppMethodBeat.i(96798);
            if (al.this.Kuc)
            {
              AppMethodBeat.o(96798);
              return;
            }
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final Drawable getDrawable(String paramAnonymous2String)
              {
                AppMethodBeat.i(96796);
                Object localObject = null;
                String str = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.kU("adId", paramAnonymous2String);
                int i;
                int j;
                if ((!Util.isNullOrNil(str)) && (u.agG(str)))
                {
                  paramAnonymous2String = c.a(al.this.bFR.getResources(), str);
                  if (paramAnonymous2String == null) {
                    break label168;
                  }
                  if (paramAnonymous2String.getIntrinsicHeight() != 0)
                  {
                    i = paramAnonymous2String.getIntrinsicWidth();
                    i = (int)((ah)al.this.KqB).textSize * i / paramAnonymous2String.getIntrinsicHeight();
                    if (paramAnonymous2String.getIntrinsicHeight() == 0) {
                      break label140;
                    }
                    j = (int)((ah)al.this.KqB).textSize;
                    label117:
                    paramAnonymous2String.setBounds(0, 0, i, j);
                  }
                }
                label140:
                label168:
                for (;;)
                {
                  AppMethodBeat.o(96796);
                  return paramAnonymous2String;
                  i = paramAnonymous2String.getIntrinsicWidth();
                  break;
                  j = paramAnonymous2String.getIntrinsicHeight();
                  break label117;
                  com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a("adId", paramAnonymous2String, new f.a()
                  {
                    public final void aYs(String paramAnonymous3String)
                    {
                      AppMethodBeat.i(96795);
                      try
                      {
                        MMHandlerThread.postToMainThread(new Runnable()
                        {
                          public final Drawable getDrawable(String paramAnonymous4String)
                          {
                            AppMethodBeat.i(96793);
                            Object localObject = null;
                            String str = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.kU("adId", paramAnonymous4String);
                            paramAnonymous4String = localObject;
                            int i;
                            if (!Util.isNullOrNil(str))
                            {
                              paramAnonymous4String = localObject;
                              if (u.agG(str))
                              {
                                paramAnonymous4String = c.a(al.this.bFR.getResources(), str);
                                if (paramAnonymous4String != null)
                                {
                                  if (paramAnonymous4String.getIntrinsicHeight() == 0) {
                                    break label156;
                                  }
                                  i = paramAnonymous4String.getIntrinsicWidth();
                                  i = (int)((ah)al.this.KqB).textSize * i / paramAnonymous4String.getIntrinsicHeight();
                                  if (paramAnonymous4String.getIntrinsicHeight() == 0) {
                                    break label164;
                                  }
                                }
                              }
                            }
                            label156:
                            label164:
                            for (int j = (int)((ah)al.this.KqB).textSize;; j = paramAnonymous4String.getIntrinsicHeight())
                            {
                              paramAnonymous4String.setBounds(0, 0, i, j);
                              AppMethodBeat.o(96793);
                              return paramAnonymous4String;
                              i = paramAnonymous4String.getIntrinsicWidth();
                              break;
                            }
                          }
                        }
                        {
                          public final void run()
                          {
                            AppMethodBeat.i(96794);
                            al.this.bFR.setText(this.Kui);
                            AppMethodBeat.o(96794);
                          }
                        });
                        AppMethodBeat.o(96795);
                        return;
                      }
                      catch (Exception paramAnonymous3String)
                      {
                        Log.e("MicroMsg.Sns.AdLandingPageTextComponent", "the backgroundCoverUrl is set error ,because " + paramAnonymous3String.toString());
                        AppMethodBeat.o(96795);
                      }
                    }
                    
                    public final void fJU() {}
                    
                    public final void fJV() {}
                  });
                  paramAnonymous2String = localObject;
                }
              }
            }
            {
              public final void run()
              {
                AppMethodBeat.i(96797);
                al.this.bFR.setText(com.tencent.mm.cl.h.htZ().a(al.this.context, this.Kui, al.this.bFR.getTextSize()));
                AppMethodBeat.o(96797);
              }
            });
            AppMethodBeat.o(96798);
          }
        };
        com.tencent.e.h.ZvG.be(this.Kub);
      }
      if (((ah)this.KqB).KlP != 0) {
        break label422;
      }
      this.bFR.setGravity(3);
      label151:
      if ((((ah)this.KqB).FdA == null) || (((ah)this.KqB).FdA.length() <= 0)) {
        break label507;
      }
    }
    for (;;)
    {
      try
      {
        i = Color.parseColor(((ah)this.KqB).FdA);
        this.bFR.setTextColor(i);
        if (((ah)this.KqB).Kno > 0.0F) {
          this.bFR.setLineSpacing(0.0F, ((ah)this.KqB).Kno + 1.0F);
        }
        localObject = this.bFR.getPaint();
        if (((ah)this.KqB).Knl) {
          ((TextPaint)localObject).setFakeBoldText(true);
        }
        if (((ah)this.KqB).Knm) {
          ((TextPaint)localObject).setTextSkewX(-0.25F);
        }
        if (((ah)this.KqB).Knn) {
          ((TextPaint)localObject).setUnderlineText(true);
        }
        if (((ah)this.KqB).maxLines > 0) {
          this.bFR.setMaxLines(((ah)this.KqB).maxLines);
        }
        if (((ah)this.KqB).KlO == ah.Knj) {
          this.bFR.setTypeface(ao.id(this.context));
        }
        AppMethodBeat.o(96801);
        return;
        if (Util.isNullOrNil(((ah)this.KqB).Knk)) {
          break;
        }
        this.bFR.setText(com.tencent.mm.cl.h.htZ().a(this.context, ((ah)this.KqB).Knk.trim(), this.bFR.getTextSize()));
        break;
        label422:
        if (((ah)this.KqB).KlP == 1)
        {
          this.bFR.setGravity(17);
          break label151;
        }
        if (((ah)this.KqB).KlP != 2) {
          break label151;
        }
        this.bFR.setGravity(5);
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.Sns.AdLandingPageTextComponent", "parse the color is error : " + ((ah)this.KqB).FdA);
        continue;
      }
      label507:
      int i = Color.parseColor("#FFFFFF");
      this.bFR.setTextColor(i);
    }
  }
  
  protected final void fKi()
  {
    AppMethodBeat.i(96800);
    ViewGroup.LayoutParams localLayoutParams = this.contentView.getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      ((ViewGroup.MarginLayoutParams)localLayoutParams).setMargins((int)this.KqB.paddingLeft, (int)this.KqB.paddingTop, (int)this.KqB.paddingRight, (int)this.KqB.paddingBottom);
    }
    this.contentView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(96800);
  }
  
  public final void fKk()
  {
    AppMethodBeat.i(96803);
    super.fKk();
    AppMethodBeat.o(96803);
  }
  
  public final void fKl()
  {
    AppMethodBeat.i(96804);
    super.fKl();
    AppMethodBeat.o(96804);
  }
  
  public final void fKo()
  {
    AppMethodBeat.i(96799);
    super.fKo();
    if (this.Kub != null) {
      this.Kub.cancel();
    }
    this.Kuc = true;
    AppMethodBeat.o(96799);
  }
  
  @TargetApi(17)
  public final void fKp()
  {
    AppMethodBeat.i(96802);
    View localView = this.contentView;
    localView.setBackgroundColor(this.backgroundColor);
    localView.findViewById(i.f.sns_ad_landingpage_text_layout).setBackgroundColor(this.backgroundColor);
    localView.findViewById(i.f.sns_ad_landingpage_text_wordTitle).setBackgroundColor(this.backgroundColor);
    this.bFR = ((TextView)localView.findViewById(i.f.sns_ad_landingpage_text_wordTitle));
    AppMethodBeat.o(96802);
  }
  
  protected final int getLayout()
  {
    return i.g.sns_ad_native_landing_pages_item_text;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.al
 * JD-Core Version:    0.7.0.1
 */