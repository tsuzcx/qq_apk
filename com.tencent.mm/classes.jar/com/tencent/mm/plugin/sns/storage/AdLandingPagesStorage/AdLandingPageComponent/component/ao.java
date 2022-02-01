package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.j.c;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.smiley.u;
import com.tencent.mm.vfs.y;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import com.tencent.threadpool.i.b;

public final class ao
  extends n
{
  private b QSB;
  volatile boolean QSC = false;
  TextView dyR;
  
  public ao(Context paramContext, ah paramah, ViewGroup paramViewGroup)
  {
    super(paramContext, paramah, paramViewGroup);
  }
  
  public final void Gs()
  {
    AppMethodBeat.i(96802);
    View localView = this.contentView;
    localView.setBackgroundColor(this.backgroundColor);
    localView.findViewById(b.f.sns_ad_landingpage_text_layout).setBackgroundColor(this.backgroundColor);
    localView.findViewById(b.f.sns_ad_landingpage_text_wordTitle).setBackgroundColor(this.backgroundColor);
    this.dyR = ((TextView)localView.findViewById(b.f.sns_ad_landingpage_text_wordTitle));
    AppMethodBeat.o(96802);
  }
  
  protected final int getLayout()
  {
    return b.g.sns_ad_native_landing_pages_item_text;
  }
  
  protected final void had()
  {
    AppMethodBeat.i(96801);
    if (((ah)this.QOV).textSize > 0.0F) {
      this.dyR.setTextSize(0, ((ah)this.QOV).textSize);
    }
    Object localObject;
    if (((ah)this.QOV).subType == 1)
    {
      if (!Util.isNullOrNil(((ah)this.QOV).QLp))
      {
        localObject = ((ah)this.QOV).QLp.trim().replace("<icon", "<img");
        if (this.QSB != null) {
          this.QSB.cancel();
        }
        this.QSB = new b()
        {
          public final String getKey()
          {
            return "MicroMsg.Sns.AdLandingPageTextComponent";
          }
          
          public final void run()
          {
            AppMethodBeat.i(96798);
            if (ao.this.QSC)
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
                String str = k.mC("adId", paramAnonymous2String);
                int i;
                int j;
                if ((!Util.isNullOrNil(str)) && (y.ZC(str)))
                {
                  paramAnonymous2String = c.a(ao.this.dyR.getResources(), str);
                  if (paramAnonymous2String == null) {
                    break label168;
                  }
                  if (paramAnonymous2String.getIntrinsicHeight() != 0)
                  {
                    i = paramAnonymous2String.getIntrinsicWidth();
                    i = (int)((ah)ao.this.QOV).textSize * i / paramAnonymous2String.getIntrinsicHeight();
                    if (paramAnonymous2String.getIntrinsicHeight() == 0) {
                      break label140;
                    }
                    j = (int)((ah)ao.this.QOV).textSize;
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
                  k.b("adId", paramAnonymous2String, new g.a()
                  {
                    public final void aWn(String paramAnonymous3String)
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
                            String str = k.mC("adId", paramAnonymous4String);
                            paramAnonymous4String = localObject;
                            int i;
                            if (!Util.isNullOrNil(str))
                            {
                              paramAnonymous4String = localObject;
                              if (y.ZC(str))
                              {
                                paramAnonymous4String = c.a(ao.this.dyR.getResources(), str);
                                if (paramAnonymous4String != null)
                                {
                                  if (paramAnonymous4String.getIntrinsicHeight() == 0) {
                                    break label156;
                                  }
                                  i = paramAnonymous4String.getIntrinsicWidth();
                                  i = (int)((ah)ao.this.QOV).textSize * i / paramAnonymous4String.getIntrinsicHeight();
                                  if (paramAnonymous4String.getIntrinsicHeight() == 0) {
                                    break label164;
                                  }
                                }
                              }
                            }
                            label156:
                            label164:
                            for (int j = (int)((ah)ao.this.QOV).textSize;; j = paramAnonymous4String.getIntrinsicHeight())
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
                            ao.this.dyR.setText(this.QSI);
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
                    
                    public final void gZM() {}
                    
                    public final void gZN() {}
                  });
                  paramAnonymous2String = localObject;
                }
              }
            }
            {
              public final void run()
              {
                AppMethodBeat.i(96797);
                ao.this.dyR.setText(u.iVt().a(ao.this.context, this.QSI, ao.this.dyR.getTextSize()));
                AppMethodBeat.o(96797);
              }
            });
            AppMethodBeat.o(96798);
          }
        };
        h.ahAA.bm(this.QSB);
      }
      if (((ah)this.QOV).QJU != 0) {
        break label422;
      }
      this.dyR.setGravity(3);
      label151:
      if ((((ah)this.QOV).KZj == null) || (((ah)this.QOV).KZj.length() <= 0)) {
        break label507;
      }
    }
    for (;;)
    {
      try
      {
        i = Color.parseColor(((ah)this.QOV).KZj);
        this.dyR.setTextColor(i);
        if (((ah)this.QOV).QLt > 0.0F) {
          this.dyR.setLineSpacing(0.0F, ((ah)this.QOV).QLt + 1.0F);
        }
        localObject = this.dyR.getPaint();
        if (((ah)this.QOV).QLq) {
          ((TextPaint)localObject).setFakeBoldText(true);
        }
        if (((ah)this.QOV).QLr) {
          ((TextPaint)localObject).setTextSkewX(-0.25F);
        }
        if (((ah)this.QOV).QLs) {
          ((TextPaint)localObject).setUnderlineText(true);
        }
        if (((ah)this.QOV).maxLines > 0) {
          this.dyR.setMaxLines(((ah)this.QOV).maxLines);
        }
        if (((ah)this.QOV).QJT == ah.QLo) {
          this.dyR.setTypeface(ar.jT(this.context));
        }
        AppMethodBeat.o(96801);
        return;
        if (Util.isNullOrNil(((ah)this.QOV).QLp)) {
          break;
        }
        this.dyR.setText(u.iVt().a(this.context, ((ah)this.QOV).QLp.trim(), this.dyR.getTextSize()));
        break;
        label422:
        if (((ah)this.QOV).QJU == 1)
        {
          this.dyR.setGravity(17);
          break label151;
        }
        if (((ah)this.QOV).QJU != 2) {
          break label151;
        }
        this.dyR.setGravity(5);
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.Sns.AdLandingPageTextComponent", "parse the color is error : " + ((ah)this.QOV).KZj);
        continue;
      }
      label507:
      int i = Color.parseColor("#FFFFFF");
      this.dyR.setTextColor(i);
    }
  }
  
  protected final void hal()
  {
    AppMethodBeat.i(96800);
    ViewGroup.LayoutParams localLayoutParams = this.contentView.getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      ((ViewGroup.MarginLayoutParams)localLayoutParams).setMargins((int)this.QOV.paddingLeft, (int)this.QOV.paddingTop, (int)this.QOV.paddingRight, (int)this.QOV.paddingBottom);
    }
    this.contentView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(96800);
  }
  
  public final void hao()
  {
    AppMethodBeat.i(96803);
    super.hao();
    AppMethodBeat.o(96803);
  }
  
  public final void hap()
  {
    AppMethodBeat.i(96804);
    super.hap();
    AppMethodBeat.o(96804);
  }
  
  public final void has()
  {
    AppMethodBeat.i(96799);
    super.has();
    if (this.QSB != null) {
      this.QSB.cancel();
    }
    this.QSC = true;
    AppMethodBeat.o(96799);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ao
 * JD-Core Version:    0.7.0.1
 */