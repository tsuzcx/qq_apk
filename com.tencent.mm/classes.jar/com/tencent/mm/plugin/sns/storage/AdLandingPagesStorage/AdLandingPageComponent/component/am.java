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
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ce.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ag;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;

public final class am
  extends m
{
  private com.tencent.f.i.b EgU;
  volatile boolean EgV = false;
  TextView vr;
  
  public am(Context paramContext, ag paramag, ViewGroup paramViewGroup)
  {
    super(paramContext, paramag, paramViewGroup);
  }
  
  protected final void eWT()
  {
    AppMethodBeat.i(96801);
    if (((ag)this.EcX).textSize > 0.0F) {
      this.vr.setTextSize(0, ((ag)this.EcX).textSize);
    }
    Object localObject;
    if (((ag)this.EcX).subType == 1)
    {
      if (!Util.isNullOrNil(((ag)this.EcX).DZP))
      {
        localObject = ((ag)this.EcX).DZP.trim().replace("<icon", "<img");
        if (this.EgU != null) {
          this.EgU.cancel();
        }
        this.EgU = new com.tencent.f.i.b()
        {
          public final String getKey()
          {
            return "MicroMsg.Sns.AdLandingPageTextComponent";
          }
          
          public final void run()
          {
            AppMethodBeat.i(96798);
            if (am.this.EgV)
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
                String str = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.kz("adId", paramAnonymous2String);
                int i;
                int j;
                if ((!Util.isNullOrNil(str)) && (s.YS(str)))
                {
                  paramAnonymous2String = com.tencent.mm.plugin.sns.ad.i.b.a(am.this.vr.getResources(), str);
                  if (paramAnonymous2String == null) {
                    break label162;
                  }
                  if (paramAnonymous2String.getIntrinsicHeight() != 0)
                  {
                    i = paramAnonymous2String.getIntrinsicWidth() * (int)am.a(am.this).textSize / paramAnonymous2String.getIntrinsicHeight();
                    if (paramAnonymous2String.getIntrinsicHeight() == 0) {
                      break label132;
                    }
                    j = (int)am.a(am.this).textSize;
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
                  com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a("adId", paramAnonymous2String, false, 0, new f.a()
                  {
                    public final void aNH(String paramAnonymous3String)
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
                            String str = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.kz("adId", paramAnonymous4String);
                            paramAnonymous4String = localObject;
                            int i;
                            if (!Util.isNullOrNil(str))
                            {
                              paramAnonymous4String = localObject;
                              if (s.YS(str))
                              {
                                paramAnonymous4String = com.tencent.mm.plugin.sns.ad.i.b.a(am.this.vr.getResources(), str);
                                if (paramAnonymous4String != null)
                                {
                                  if (paramAnonymous4String.getIntrinsicHeight() == 0) {
                                    break label148;
                                  }
                                  i = paramAnonymous4String.getIntrinsicWidth() * (int)am.a(am.this).textSize / paramAnonymous4String.getIntrinsicHeight();
                                  if (paramAnonymous4String.getIntrinsicHeight() == 0) {
                                    break label156;
                                  }
                                }
                              }
                            }
                            label148:
                            label156:
                            for (int j = (int)am.a(am.this).textSize;; j = paramAnonymous4String.getIntrinsicHeight())
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
                            am.this.vr.setText(this.Ehb);
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
                    
                    public final void eWN() {}
                    
                    public final void eWO() {}
                  });
                  paramAnonymous2String = localObject;
                }
              }
            }
            {
              public final void run()
              {
                AppMethodBeat.i(96797);
                am.this.vr.setText(g.gxZ().a(am.this.context, this.Ehb, am.this.vr.getTextSize()));
                AppMethodBeat.o(96797);
              }
            });
            AppMethodBeat.o(96798);
          }
        };
        com.tencent.f.h.RTc.aX(this.EgU);
      }
      if (((ag)this.EcX).textAlignment != 0) {
        break label422;
      }
      this.vr.setGravity(3);
      label151:
      if ((((ag)this.EcX).zyf == null) || (((ag)this.EcX).zyf.length() <= 0)) {
        break label507;
      }
    }
    for (;;)
    {
      try
      {
        i = Color.parseColor(((ag)this.EcX).zyf);
        this.vr.setTextColor(i);
        if (((ag)this.EcX).DZT > 0.0F) {
          this.vr.setLineSpacing(0.0F, ((ag)this.EcX).DZT + 1.0F);
        }
        localObject = this.vr.getPaint();
        if (((ag)this.EcX).DZQ) {
          ((TextPaint)localObject).setFakeBoldText(true);
        }
        if (((ag)this.EcX).DZR) {
          ((TextPaint)localObject).setTextSkewX(-0.25F);
        }
        if (((ag)this.EcX).DZS) {
          ((TextPaint)localObject).setUnderlineText(true);
        }
        if (((ag)this.EcX).maxLines > 0) {
          this.vr.setMaxLines(((ag)this.EcX).maxLines);
        }
        if (((ag)this.EcX).DYv == ag.DZO) {
          this.vr.setTypeface(ap.hc(this.context));
        }
        AppMethodBeat.o(96801);
        return;
        if (Util.isNullOrNil(((ag)this.EcX).DZP)) {
          break;
        }
        this.vr.setText(g.gxZ().a(this.context, ((ag)this.EcX).DZP.trim(), this.vr.getTextSize()));
        break;
        label422:
        if (((ag)this.EcX).textAlignment == 1)
        {
          this.vr.setGravity(17);
          break label151;
        }
        if (((ag)this.EcX).textAlignment != 2) {
          break label151;
        }
        this.vr.setGravity(5);
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.Sns.AdLandingPageTextComponent", "parse the color is error : " + ((ag)this.EcX).zyf);
        continue;
      }
      label507:
      int i = Color.parseColor("#FFFFFF");
      this.vr.setTextColor(i);
    }
  }
  
  protected final void eWX()
  {
    AppMethodBeat.i(96800);
    ViewGroup.LayoutParams localLayoutParams = this.contentView.getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      ((ViewGroup.MarginLayoutParams)localLayoutParams).setMargins((int)this.EcX.paddingLeft, (int)this.EcX.paddingTop, (int)this.EcX.paddingRight, (int)this.EcX.paddingBottom);
    }
    this.contentView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(96800);
  }
  
  public final void eWZ()
  {
    AppMethodBeat.i(96803);
    super.eWZ();
    AppMethodBeat.o(96803);
  }
  
  public final void eXa()
  {
    AppMethodBeat.i(96804);
    super.eXa();
    AppMethodBeat.o(96804);
  }
  
  public final void eXd()
  {
    AppMethodBeat.i(96799);
    super.eXd();
    if (this.EgU != null) {
      this.EgU.cancel();
    }
    this.EgV = true;
    AppMethodBeat.o(96799);
  }
  
  @TargetApi(17)
  public final void eXe()
  {
    AppMethodBeat.i(96802);
    View localView = this.contentView;
    localView.setBackgroundColor(this.backgroundColor);
    localView.findViewById(2131308033).setBackgroundColor(this.backgroundColor);
    localView.findViewById(2131308034).setBackgroundColor(this.backgroundColor);
    this.vr = ((TextView)localView.findViewById(2131308034));
    AppMethodBeat.o(96802);
  }
  
  protected final int getLayout()
  {
    return 2131496396;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.am
 * JD-Core Version:    0.7.0.1
 */