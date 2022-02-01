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
import com.tencent.e.i.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cf.g;
import com.tencent.mm.plugin.sns.ad.e.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;

public final class aj
  extends l
{
  TextView vk;
  private b zHw;
  volatile boolean zHx = false;
  
  public aj(Context paramContext, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad paramad, ViewGroup paramViewGroup)
  {
    super(paramContext, paramad, paramViewGroup);
  }
  
  @TargetApi(17)
  public final void dRk()
  {
    AppMethodBeat.i(96802);
    View localView = this.contentView;
    localView.setBackgroundColor(this.backgroundColor);
    localView.findViewById(2131304897).setBackgroundColor(this.backgroundColor);
    localView.findViewById(2131304898).setBackgroundColor(this.backgroundColor);
    this.vk = ((TextView)localView.findViewById(2131304898));
    AppMethodBeat.o(96802);
  }
  
  protected final void dRl()
  {
    AppMethodBeat.i(96801);
    if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad)this.zDK).textSize > 0.0F) {
      this.vk.setTextSize(0, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad)this.zDK).textSize);
    }
    Object localObject;
    if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad)this.zDK).subType == 1)
    {
      if (!bt.isNullOrNil(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad)this.zDK).zAI))
      {
        localObject = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad)this.zDK).zAI.trim().replace("<icon", "<img");
        if (this.zHw != null) {
          this.zHw.cancel();
        }
        this.zHw = new b()
        {
          public final String getKey()
          {
            return "MicroMsg.Sns.AdLandingPageTextComponent";
          }
          
          public final void run()
          {
            AppMethodBeat.i(96798);
            if (aj.this.zHx)
            {
              AppMethodBeat.o(96798);
              return;
            }
            aq.f(new Runnable()
            {
              public final Drawable getDrawable(String paramAnonymous2String)
              {
                AppMethodBeat.i(96796);
                Object localObject = null;
                String str = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.jF("adId", paramAnonymous2String);
                int i;
                int j;
                if ((!bt.isNullOrNil(str)) && (com.tencent.mm.vfs.i.fv(str)))
                {
                  paramAnonymous2String = a.a(aj.this.vk.getResources(), str);
                  if (paramAnonymous2String == null) {
                    break label162;
                  }
                  if (paramAnonymous2String.getIntrinsicHeight() != 0)
                  {
                    i = paramAnonymous2String.getIntrinsicWidth() * (int)aj.a(aj.this).textSize / paramAnonymous2String.getIntrinsicHeight();
                    if (paramAnonymous2String.getIntrinsicHeight() == 0) {
                      break label132;
                    }
                    j = (int)aj.a(aj.this).textSize;
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
                    public final void axG(String paramAnonymous3String)
                    {
                      AppMethodBeat.i(96795);
                      try
                      {
                        aq.f(new Runnable()
                        {
                          public final Drawable getDrawable(String paramAnonymous4String)
                          {
                            AppMethodBeat.i(96793);
                            Object localObject = null;
                            String str = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.jF("adId", paramAnonymous4String);
                            paramAnonymous4String = localObject;
                            int i;
                            if (!bt.isNullOrNil(str))
                            {
                              paramAnonymous4String = localObject;
                              if (com.tencent.mm.vfs.i.fv(str))
                              {
                                paramAnonymous4String = a.a(aj.this.vk.getResources(), str);
                                if (paramAnonymous4String != null)
                                {
                                  if (paramAnonymous4String.getIntrinsicHeight() == 0) {
                                    break label148;
                                  }
                                  i = paramAnonymous4String.getIntrinsicWidth() * (int)aj.a(aj.this).textSize / paramAnonymous4String.getIntrinsicHeight();
                                  if (paramAnonymous4String.getIntrinsicHeight() == 0) {
                                    break label156;
                                  }
                                }
                              }
                            }
                            label148:
                            label156:
                            for (int j = (int)aj.a(aj.this).textSize;; j = paramAnonymous4String.getIntrinsicHeight())
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
                            aj.this.vk.setText(this.zHD);
                            AppMethodBeat.o(96794);
                          }
                        });
                        AppMethodBeat.o(96795);
                        return;
                      }
                      catch (Exception paramAnonymous3String)
                      {
                        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Sns.AdLandingPageTextComponent", "the backgroundCoverUrl is set error ,because " + paramAnonymous3String.toString());
                        AppMethodBeat.o(96795);
                      }
                    }
                    
                    public final void dRW() {}
                    
                    public final void dRX() {}
                  });
                  paramAnonymous2String = localObject;
                }
              }
            }
            {
              public final void run()
              {
                AppMethodBeat.i(96797);
                aj.this.vk.setText(g.fng().b(this.zHD, aj.this.vk.getTextSize()));
                AppMethodBeat.o(96797);
              }
            });
            AppMethodBeat.o(96798);
          }
        };
        com.tencent.e.h.LTJ.aR(this.zHw);
      }
      if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad)this.zDK).textAlignment != 0) {
        break label418;
      }
      this.vk.setGravity(3);
      label151:
      if ((((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad)this.zDK).vRt == null) || (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad)this.zDK).vRt.length() <= 0)) {
        break label503;
      }
    }
    for (;;)
    {
      try
      {
        i = Color.parseColor(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad)this.zDK).vRt);
        this.vk.setTextColor(i);
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad)this.zDK).zAM > 0.0F) {
          this.vk.setLineSpacing(0.0F, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad)this.zDK).zAM + 1.0F);
        }
        localObject = this.vk.getPaint();
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad)this.zDK).zAJ) {
          ((TextPaint)localObject).setFakeBoldText(true);
        }
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad)this.zDK).zAK) {
          ((TextPaint)localObject).setTextSkewX(-0.25F);
        }
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad)this.zDK).zAL) {
          ((TextPaint)localObject).setUnderlineText(true);
        }
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad)this.zDK).maxLines > 0) {
          this.vk.setMaxLines(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad)this.zDK).maxLines);
        }
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad)this.zDK).zyX == com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad.zAH) {
          this.vk.setTypeface(am.gm(this.context));
        }
        AppMethodBeat.o(96801);
        return;
        if (bt.isNullOrNil(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad)this.zDK).zAI)) {
          break;
        }
        this.vk.setText(g.fng().b(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad)this.zDK).zAI.trim(), this.vk.getTextSize()));
        break;
        label418:
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad)this.zDK).textAlignment == 1)
        {
          this.vk.setGravity(17);
          break label151;
        }
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad)this.zDK).textAlignment != 2) {
          break label151;
        }
        this.vk.setGravity(5);
      }
      catch (Exception localException)
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Sns.AdLandingPageTextComponent", "parse the color is error : " + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad)this.zDK).vRt);
        continue;
      }
      label503:
      int i = Color.parseColor("#FFFFFF");
      this.vk.setTextColor(i);
    }
  }
  
  public final void dRm()
  {
    AppMethodBeat.i(96803);
    super.dRm();
    AppMethodBeat.o(96803);
  }
  
  public final void dRn()
  {
    AppMethodBeat.i(96804);
    super.dRn();
    AppMethodBeat.o(96804);
  }
  
  public final void dRo()
  {
    AppMethodBeat.i(96799);
    super.dRo();
    if (this.zHw != null) {
      this.zHw.cancel();
    }
    this.zHx = true;
    AppMethodBeat.o(96799);
  }
  
  protected final void dWF()
  {
    AppMethodBeat.i(96800);
    ViewGroup.LayoutParams localLayoutParams = this.contentView.getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      ((ViewGroup.MarginLayoutParams)localLayoutParams).setMargins((int)this.zDK.paddingLeft, (int)this.zDK.paddingTop, (int)this.zDK.paddingRight, (int)this.zDK.paddingBottom);
    }
    this.contentView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(96800);
  }
  
  protected final int getLayout()
  {
    return 2131495510;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.aj
 * JD-Core Version:    0.7.0.1
 */