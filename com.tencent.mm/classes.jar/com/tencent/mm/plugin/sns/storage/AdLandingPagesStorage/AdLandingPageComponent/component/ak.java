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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ce.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.y;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;

public final class ak
  extends m
{
  TextView vk;
  private com.tencent.e.i.b zYD;
  volatile boolean zYE = false;
  
  public ak(Context paramContext, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae paramae, ViewGroup paramViewGroup)
  {
    super(paramContext, paramae, paramViewGroup);
  }
  
  @TargetApi(17)
  public final void dUI()
  {
    AppMethodBeat.i(96802);
    View localView = this.contentView;
    localView.setBackgroundColor(this.backgroundColor);
    localView.findViewById(2131304897).setBackgroundColor(this.backgroundColor);
    localView.findViewById(2131304898).setBackgroundColor(this.backgroundColor);
    this.vk = ((TextView)localView.findViewById(2131304898));
    AppMethodBeat.o(96802);
  }
  
  protected final void dUJ()
  {
    AppMethodBeat.i(96801);
    if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae)this.zUP).textSize > 0.0F) {
      this.vk.setTextSize(0, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae)this.zUP).textSize);
    }
    Object localObject;
    if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae)this.zUP).subType == 1)
    {
      if (!bu.isNullOrNil(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae)this.zUP).zRI))
      {
        localObject = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae)this.zUP).zRI.trim().replace("<icon", "<img");
        if (this.zYD != null) {
          this.zYD.cancel();
        }
        this.zYD = new com.tencent.e.i.b()
        {
          public final String getKey()
          {
            return "MicroMsg.Sns.AdLandingPageTextComponent";
          }
          
          public final void run()
          {
            AppMethodBeat.i(96798);
            if (ak.this.zYE)
            {
              AppMethodBeat.o(96798);
              return;
            }
            ar.f(new Runnable()
            {
              public final Drawable getDrawable(String paramAnonymous2String)
              {
                AppMethodBeat.i(96796);
                Object localObject = null;
                String str = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.jL("adId", paramAnonymous2String);
                int i;
                int j;
                if ((!bu.isNullOrNil(str)) && (o.fB(str)))
                {
                  paramAnonymous2String = com.tencent.mm.plugin.sns.ad.f.b.a(ak.this.vk.getResources(), str);
                  if (paramAnonymous2String == null) {
                    break label162;
                  }
                  if (paramAnonymous2String.getIntrinsicHeight() != 0)
                  {
                    i = paramAnonymous2String.getIntrinsicWidth() * (int)ak.a(ak.this).textSize / paramAnonymous2String.getIntrinsicHeight();
                    if (paramAnonymous2String.getIntrinsicHeight() == 0) {
                      break label132;
                    }
                    j = (int)ak.a(ak.this).textSize;
                    label109:
                    paramAnonymous2String.setBounds(0, 0, i, j);
                  }
                }
                label132:
                label162:
                for (;;)
                {
                  AppMethodBeat.o(96796);
                  return paramAnonymous2String;
                  i = paramAnonymous2String.getIntrinsicWidth();
                  break;
                  j = paramAnonymous2String.getIntrinsicHeight();
                  break label109;
                  com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.c("adId", paramAnonymous2String, false, 0, new f.a()
                  {
                    public final void ayY(String paramAnonymous3String)
                    {
                      AppMethodBeat.i(96795);
                      try
                      {
                        ar.f(new Runnable()
                        {
                          public final Drawable getDrawable(String paramAnonymous4String)
                          {
                            AppMethodBeat.i(96793);
                            Object localObject = null;
                            String str = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.jL("adId", paramAnonymous4String);
                            paramAnonymous4String = localObject;
                            int i;
                            if (!bu.isNullOrNil(str))
                            {
                              paramAnonymous4String = localObject;
                              if (o.fB(str))
                              {
                                paramAnonymous4String = com.tencent.mm.plugin.sns.ad.f.b.a(ak.this.vk.getResources(), str);
                                if (paramAnonymous4String != null)
                                {
                                  if (paramAnonymous4String.getIntrinsicHeight() == 0) {
                                    break label148;
                                  }
                                  i = paramAnonymous4String.getIntrinsicWidth() * (int)ak.a(ak.this).textSize / paramAnonymous4String.getIntrinsicHeight();
                                  if (paramAnonymous4String.getIntrinsicHeight() == 0) {
                                    break label156;
                                  }
                                }
                              }
                            }
                            label148:
                            label156:
                            for (int j = (int)ak.a(ak.this).textSize;; j = paramAnonymous4String.getIntrinsicHeight())
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
                            ak.this.vk.setText(this.zYK);
                            AppMethodBeat.o(96794);
                          }
                        });
                        AppMethodBeat.o(96795);
                        return;
                      }
                      catch (Exception paramAnonymous3String)
                      {
                        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.Sns.AdLandingPageTextComponent", "the backgroundCoverUrl is set error ,because " + paramAnonymous3String.toString());
                        AppMethodBeat.o(96795);
                      }
                    }
                    
                    public final void dVu() {}
                    
                    public final void dVv() {}
                  });
                  paramAnonymous2String = localObject;
                }
              }
            }
            {
              public final void run()
              {
                AppMethodBeat.i(96797);
                ak.this.vk.setText(g.fqZ().b(this.zYK, ak.this.vk.getTextSize()));
                AppMethodBeat.o(96797);
              }
            });
            AppMethodBeat.o(96798);
          }
        };
        com.tencent.e.h.MqF.aO(this.zYD);
      }
      if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae)this.zUP).textAlignment != 0) {
        break label418;
      }
      this.vk.setGravity(3);
      label151:
      if ((((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae)this.zUP).wdx == null) || (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae)this.zUP).wdx.length() <= 0)) {
        break label503;
      }
    }
    for (;;)
    {
      try
      {
        i = Color.parseColor(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae)this.zUP).wdx);
        this.vk.setTextColor(i);
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae)this.zUP).zRM > 0.0F) {
          this.vk.setLineSpacing(0.0F, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae)this.zUP).zRM + 1.0F);
        }
        localObject = this.vk.getPaint();
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae)this.zUP).zRJ) {
          ((TextPaint)localObject).setFakeBoldText(true);
        }
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae)this.zUP).zRK) {
          ((TextPaint)localObject).setTextSkewX(-0.25F);
        }
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae)this.zUP).zRL) {
          ((TextPaint)localObject).setUnderlineText(true);
        }
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae)this.zUP).maxLines > 0) {
          this.vk.setMaxLines(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae)this.zUP).maxLines);
        }
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae)this.zUP).zQw == com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae.zRH) {
          this.vk.setTypeface(an.gr(this.context));
        }
        AppMethodBeat.o(96801);
        return;
        if (bu.isNullOrNil(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae)this.zUP).zRI)) {
          break;
        }
        this.vk.setText(g.fqZ().b(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae)this.zUP).zRI.trim(), this.vk.getTextSize()));
        break;
        label418:
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae)this.zUP).textAlignment == 1)
        {
          this.vk.setGravity(17);
          break label151;
        }
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae)this.zUP).textAlignment != 2) {
          break label151;
        }
        this.vk.setGravity(5);
      }
      catch (Exception localException)
      {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.Sns.AdLandingPageTextComponent", "parse the color is error : " + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae)this.zUP).wdx);
        continue;
      }
      label503:
      int i = Color.parseColor("#FFFFFF");
      this.vk.setTextColor(i);
    }
  }
  
  public final void dUK()
  {
    AppMethodBeat.i(96803);
    super.dUK();
    AppMethodBeat.o(96803);
  }
  
  public final void dUL()
  {
    AppMethodBeat.i(96804);
    super.dUL();
    AppMethodBeat.o(96804);
  }
  
  public final void dUM()
  {
    AppMethodBeat.i(96799);
    super.dUM();
    if (this.zYD != null) {
      this.zYD.cancel();
    }
    this.zYE = true;
    AppMethodBeat.o(96799);
  }
  
  protected final void eah()
  {
    AppMethodBeat.i(96800);
    ViewGroup.LayoutParams localLayoutParams = this.contentView.getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      ((ViewGroup.MarginLayoutParams)localLayoutParams).setMargins((int)this.zUP.paddingLeft, (int)this.zUP.paddingTop, (int)this.zUP.paddingRight, (int)this.zUP.paddingBottom);
    }
    this.contentView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(96800);
  }
  
  protected final int getLayout()
  {
    return 2131495510;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ak
 * JD-Core Version:    0.7.0.1
 */