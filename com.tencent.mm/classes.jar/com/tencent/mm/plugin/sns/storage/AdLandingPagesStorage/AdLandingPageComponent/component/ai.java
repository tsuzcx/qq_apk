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
import com.tencent.mm.cg.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ac;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;

public final class ai
  extends k
{
  TextView ss;
  private b xdx;
  volatile boolean xdy = false;
  
  public ai(Context paramContext, ac paramac, ViewGroup paramViewGroup)
  {
    super(paramContext, paramac, paramViewGroup);
  }
  
  public final void dvA()
  {
    AppMethodBeat.i(96804);
    super.dvA();
    AppMethodBeat.o(96804);
  }
  
  protected final void dvN()
  {
    AppMethodBeat.i(96801);
    if (((ac)this.xab).textSize > 0.0F) {
      this.ss.setTextSize(0, ((ac)this.xab).textSize);
    }
    Object localObject;
    if (((ac)this.xab).subType == 1)
    {
      if (!bt.isNullOrNil(((ac)this.xab).wXe))
      {
        localObject = ((ac)this.xab).wXe.trim().replace("<icon", "<img");
        if (this.xdx != null) {
          this.xdx.cancel();
        }
        this.xdx = new b()
        {
          public final String getKey()
          {
            return "MicroMsg.Sns.AdLandingPageTextComponent";
          }
          
          public final void run()
          {
            AppMethodBeat.i(96798);
            if (ai.this.xdy)
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
                String str = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.iU("adId", paramAnonymous2String);
                int i;
                int j;
                if ((!bt.isNullOrNil(str)) && (com.tencent.mm.vfs.i.eK(str)))
                {
                  paramAnonymous2String = Drawable.createFromPath(str);
                  if (paramAnonymous2String == null) {
                    break label149;
                  }
                  if (paramAnonymous2String.getIntrinsicHeight() != 0)
                  {
                    i = paramAnonymous2String.getIntrinsicWidth() * (int)ai.a(ai.this).textSize / paramAnonymous2String.getIntrinsicHeight();
                    if (paramAnonymous2String.getIntrinsicHeight() == 0) {
                      break label119;
                    }
                    j = (int)ai.a(ai.this).textSize;
                    label96:
                    paramAnonymous2String.setBounds(0, 0, i, j);
                  }
                }
                label149:
                for (;;)
                {
                  AppMethodBeat.o(96796);
                  return paramAnonymous2String;
                  i = paramAnonymous2String.getIntrinsicWidth();
                  break;
                  label119:
                  j = paramAnonymous2String.getIntrinsicHeight();
                  break label96;
                  com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.c("adId", paramAnonymous2String, false, 0, new f.a()
                  {
                    public final void apm(String paramAnonymous3String)
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
                            String str = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.iU("adId", paramAnonymous4String);
                            paramAnonymous4String = localObject;
                            int i;
                            if (!bt.isNullOrNil(str))
                            {
                              paramAnonymous4String = localObject;
                              if (com.tencent.mm.vfs.i.eK(str))
                              {
                                paramAnonymous4String = Drawable.createFromPath(str);
                                if (paramAnonymous4String != null)
                                {
                                  if (paramAnonymous4String.getIntrinsicHeight() == 0) {
                                    break label129;
                                  }
                                  i = paramAnonymous4String.getIntrinsicWidth() * (int)ai.a(ai.this).textSize / paramAnonymous4String.getIntrinsicHeight();
                                  if (paramAnonymous4String.getIntrinsicHeight() == 0) {
                                    break label137;
                                  }
                                }
                              }
                            }
                            label129:
                            label137:
                            for (int j = (int)ai.a(ai.this).textSize;; j = paramAnonymous4String.getIntrinsicHeight())
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
                            ai.this.ss.setText(this.xdE);
                            AppMethodBeat.o(96794);
                          }
                        });
                        AppMethodBeat.o(96795);
                        return;
                      }
                      catch (Exception paramAnonymous3String)
                      {
                        ad.e("MicroMsg.Sns.AdLandingPageTextComponent", "the backgroundCoverUrl is set error ,because " + paramAnonymous3String.toString());
                        AppMethodBeat.o(96795);
                      }
                    }
                    
                    public final void dsA() {}
                    
                    public final void duP() {}
                  });
                  paramAnonymous2String = localObject;
                }
              }
            }
            {
              public final void run()
              {
                AppMethodBeat.i(96797);
                ai.this.ss.setText(g.eIa().b(this.xdE, ai.this.ss.getTextSize()));
                AppMethodBeat.o(96797);
              }
            });
            AppMethodBeat.o(96798);
          }
        };
        com.tencent.e.h.Iye.aP(this.xdx);
      }
      if (((ac)this.xab).textAlignment != 0) {
        break label418;
      }
      this.ss.setGravity(3);
      label151:
      if ((((ac)this.xab).tFP == null) || (((ac)this.xab).tFP.length() <= 0)) {
        break label503;
      }
    }
    for (;;)
    {
      try
      {
        i = Color.parseColor(((ac)this.xab).tFP);
        this.ss.setTextColor(i);
        if (((ac)this.xab).wXi > 0.0F) {
          this.ss.setLineSpacing(0.0F, ((ac)this.xab).wXi + 1.0F);
        }
        localObject = this.ss.getPaint();
        if (((ac)this.xab).wXf) {
          ((TextPaint)localObject).setFakeBoldText(true);
        }
        if (((ac)this.xab).wXg) {
          ((TextPaint)localObject).setTextSkewX(-0.25F);
        }
        if (((ac)this.xab).wXh) {
          ((TextPaint)localObject).setUnderlineText(true);
        }
        if (((ac)this.xab).maxLines > 0) {
          this.ss.setMaxLines(((ac)this.xab).maxLines);
        }
        if (((ac)this.xab).wWb == ac.wXd) {
          this.ss.setTypeface(al.fW(this.context));
        }
        AppMethodBeat.o(96801);
        return;
        if (bt.isNullOrNil(((ac)this.xab).wXe)) {
          break;
        }
        this.ss.setText(g.eIa().b(((ac)this.xab).wXe.trim(), this.ss.getTextSize()));
        break;
        label418:
        if (((ac)this.xab).textAlignment == 1)
        {
          this.ss.setGravity(17);
          break label151;
        }
        if (((ac)this.xab).textAlignment != 2) {
          break label151;
        }
        this.ss.setGravity(5);
      }
      catch (Exception localException)
      {
        ad.e("MicroMsg.Sns.AdLandingPageTextComponent", "parse the color is error : " + ((ac)this.xab).tFP);
        continue;
      }
      label503:
      int i = Color.parseColor("#FFFFFF");
      this.ss.setTextColor(i);
    }
  }
  
  protected final void dvT()
  {
    AppMethodBeat.i(96800);
    ViewGroup.LayoutParams localLayoutParams = this.contentView.getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      ((ViewGroup.MarginLayoutParams)localLayoutParams).setMargins((int)this.xab.paddingLeft, (int)this.xab.paddingTop, (int)this.xab.paddingRight, (int)this.xab.paddingBottom);
    }
    this.contentView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(96800);
  }
  
  @TargetApi(17)
  public final void dvx()
  {
    AppMethodBeat.i(96802);
    View localView = this.contentView;
    localView.setBackgroundColor(this.backgroundColor);
    localView.findViewById(2131304897).setBackgroundColor(this.backgroundColor);
    localView.findViewById(2131304898).setBackgroundColor(this.backgroundColor);
    this.ss = ((TextView)localView.findViewById(2131304898));
    AppMethodBeat.o(96802);
  }
  
  public final void dvy()
  {
    AppMethodBeat.i(96799);
    super.dvy();
    if (this.xdx != null) {
      this.xdx.cancel();
    }
    this.xdy = true;
    AppMethodBeat.o(96799);
  }
  
  public final void dvz()
  {
    AppMethodBeat.i(96803);
    super.dvz();
    AppMethodBeat.o(96803);
  }
  
  protected final int getLayout()
  {
    return 2131495510;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ai
 * JD-Core Version:    0.7.0.1
 */