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
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;

public final class ai
  extends k
{
  TextView tr;
  private b yqm;
  volatile boolean yqn = false;
  
  public ai(Context paramContext, ad paramad, ViewGroup paramViewGroup)
  {
    super(paramContext, paramad, paramViewGroup);
  }
  
  @TargetApi(17)
  public final void dJW()
  {
    AppMethodBeat.i(96802);
    View localView = this.contentView;
    localView.setBackgroundColor(this.backgroundColor);
    localView.findViewById(2131304897).setBackgroundColor(this.backgroundColor);
    localView.findViewById(2131304898).setBackgroundColor(this.backgroundColor);
    this.tr = ((TextView)localView.findViewById(2131304898));
    AppMethodBeat.o(96802);
  }
  
  public final void dJX()
  {
    AppMethodBeat.i(96799);
    super.dJX();
    if (this.yqm != null) {
      this.yqm.cancel();
    }
    this.yqn = true;
    AppMethodBeat.o(96799);
  }
  
  public final void dJY()
  {
    AppMethodBeat.i(96803);
    super.dJY();
    AppMethodBeat.o(96803);
  }
  
  public final void dJZ()
  {
    AppMethodBeat.i(96804);
    super.dJZ();
    AppMethodBeat.o(96804);
  }
  
  protected final void dKm()
  {
    AppMethodBeat.i(96801);
    if (((ad)this.ymQ).textSize > 0.0F) {
      this.tr.setTextSize(0, ((ad)this.ymQ).textSize);
    }
    Object localObject;
    if (((ad)this.ymQ).subType == 1)
    {
      if (!bs.isNullOrNil(((ad)this.ymQ).yjT))
      {
        localObject = ((ad)this.ymQ).yjT.trim().replace("<icon", "<img");
        if (this.yqm != null) {
          this.yqm.cancel();
        }
        this.yqm = new b()
        {
          public final String getKey()
          {
            return "MicroMsg.Sns.AdLandingPageTextComponent";
          }
          
          public final void run()
          {
            AppMethodBeat.i(96798);
            if (ai.this.yqn)
            {
              AppMethodBeat.o(96798);
              return;
            }
            ap.f(new Runnable()
            {
              public final Drawable getDrawable(String paramAnonymous2String)
              {
                AppMethodBeat.i(96796);
                Object localObject = null;
                String str = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.js("adId", paramAnonymous2String);
                int i;
                int j;
                if ((!bs.isNullOrNil(str)) && (com.tencent.mm.vfs.i.eA(str)))
                {
                  paramAnonymous2String = a.a(ai.this.tr.getResources(), str);
                  if (paramAnonymous2String == null) {
                    break label162;
                  }
                  if (paramAnonymous2String.getIntrinsicHeight() != 0)
                  {
                    i = paramAnonymous2String.getIntrinsicWidth() * (int)ai.a(ai.this).textSize / paramAnonymous2String.getIntrinsicHeight();
                    if (paramAnonymous2String.getIntrinsicHeight() == 0) {
                      break label132;
                    }
                    j = (int)ai.a(ai.this).textSize;
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
                    public final void asD(String paramAnonymous3String)
                    {
                      AppMethodBeat.i(96795);
                      try
                      {
                        ap.f(new Runnable()
                        {
                          public final Drawable getDrawable(String paramAnonymous4String)
                          {
                            AppMethodBeat.i(96793);
                            Object localObject = null;
                            String str = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.js("adId", paramAnonymous4String);
                            paramAnonymous4String = localObject;
                            int i;
                            if (!bs.isNullOrNil(str))
                            {
                              paramAnonymous4String = localObject;
                              if (com.tencent.mm.vfs.i.eA(str))
                              {
                                paramAnonymous4String = a.a(ai.this.tr.getResources(), str);
                                if (paramAnonymous4String != null)
                                {
                                  if (paramAnonymous4String.getIntrinsicHeight() == 0) {
                                    break label148;
                                  }
                                  i = paramAnonymous4String.getIntrinsicWidth() * (int)ai.a(ai.this).textSize / paramAnonymous4String.getIntrinsicHeight();
                                  if (paramAnonymous4String.getIntrinsicHeight() == 0) {
                                    break label156;
                                  }
                                }
                              }
                            }
                            label148:
                            label156:
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
                            ai.this.tr.setText(this.yqt);
                            AppMethodBeat.o(96794);
                          }
                        });
                        AppMethodBeat.o(96795);
                        return;
                      }
                      catch (Exception paramAnonymous3String)
                      {
                        ac.e("MicroMsg.Sns.AdLandingPageTextComponent", "the backgroundCoverUrl is set error ,because " + paramAnonymous3String.toString());
                        AppMethodBeat.o(96795);
                      }
                    }
                    
                    public final void dFC() {}
                    
                    public final void dFD() {}
                  });
                  paramAnonymous2String = localObject;
                }
              }
            }
            {
              public final void run()
              {
                AppMethodBeat.i(96797);
                ai.this.tr.setText(g.eXw().b(this.yqt, ai.this.tr.getTextSize()));
                AppMethodBeat.o(96797);
              }
            });
            AppMethodBeat.o(96798);
          }
        };
        com.tencent.e.h.JZN.aS(this.yqm);
      }
      if (((ad)this.ymQ).textAlignment != 0) {
        break label418;
      }
      this.tr.setGravity(3);
      label151:
      if ((((ad)this.ymQ).uOk == null) || (((ad)this.ymQ).uOk.length() <= 0)) {
        break label504;
      }
    }
    for (;;)
    {
      try
      {
        i = Color.parseColor(((ad)this.ymQ).uOk);
        this.tr.setTextColor(i);
        if (((ad)this.ymQ).yjX > 0.0F) {
          this.tr.setLineSpacing(0.0F, ((ad)this.ymQ).yjX + 1.0F);
        }
        localObject = this.tr.getPaint();
        if (((ad)this.ymQ).yjU) {
          ((TextPaint)localObject).setFakeBoldText(true);
        }
        if (((ad)this.ymQ).yjV) {
          ((TextPaint)localObject).setTextSkewX(-0.25F);
        }
        if (((ad)this.ymQ).yjW) {
          ((TextPaint)localObject).setUnderlineText(true);
        }
        if (((ad)this.ymQ).maxLines > 0) {
          this.tr.setMaxLines(((ad)this.ymQ).maxLines);
        }
        if (((ad)this.ymQ).yiP == ad.yjS) {
          this.tr.setTypeface(al.gi(this.context));
        }
        AppMethodBeat.o(96801);
        return;
        if (bs.isNullOrNil(((ad)this.ymQ).yjT)) {
          break;
        }
        this.tr.setText(g.eXw().b(((ad)this.ymQ).yjT.trim(), this.tr.getTextSize()));
        break;
        label418:
        if (((ad)this.ymQ).textAlignment == 1)
        {
          this.tr.setGravity(17);
          break label151;
        }
        if (((ad)this.ymQ).textAlignment != 2) {
          break label151;
        }
        this.tr.setGravity(5);
      }
      catch (Exception localException)
      {
        ac.e("MicroMsg.Sns.AdLandingPageTextComponent", "parse the color is error : " + ((ad)this.ymQ).uOk);
        continue;
      }
      label504:
      int i = Color.parseColor("#FFFFFF");
      this.tr.setTextColor(i);
    }
  }
  
  protected final void dKs()
  {
    AppMethodBeat.i(96800);
    ViewGroup.LayoutParams localLayoutParams = this.contentView.getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      ((ViewGroup.MarginLayoutParams)localLayoutParams).setMargins((int)this.ymQ.paddingLeft, (int)this.ymQ.paddingTop, (int)this.ymQ.paddingRight, (int)this.ymQ.paddingBottom);
    }
    this.contentView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(96800);
  }
  
  protected final int getLayout()
  {
    return 2131495510;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ai
 * JD-Core Version:    0.7.0.1
 */