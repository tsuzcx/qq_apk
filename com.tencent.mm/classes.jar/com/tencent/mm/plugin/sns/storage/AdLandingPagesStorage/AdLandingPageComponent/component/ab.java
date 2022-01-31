package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w;
import com.tencent.mm.sdk.g.a.e;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.bo;

public final class ab
  extends h
{
  TextView euY;
  private Runnable gaj;
  volatile boolean rxV = false;
  
  public ab(Context paramContext, w paramw, ViewGroup paramViewGroup)
  {
    super(paramContext, paramw, paramViewGroup);
  }
  
  public final void cqA()
  {
    AppMethodBeat.i(37343);
    super.cqA();
    AppMethodBeat.o(37343);
  }
  
  public final void cqB()
  {
    AppMethodBeat.i(37344);
    super.cqB();
    AppMethodBeat.o(37344);
  }
  
  @TargetApi(17)
  public final void cqK()
  {
    AppMethodBeat.i(37342);
    View localView = this.contentView;
    localView.setBackgroundColor(this.backgroundColor);
    localView.findViewById(2131827873).setBackgroundColor(this.backgroundColor);
    localView.findViewById(2131827874).setBackgroundColor(this.backgroundColor);
    this.euY = ((TextView)localView.findViewById(2131827874));
    AppMethodBeat.o(37342);
  }
  
  protected final void cqP()
  {
    AppMethodBeat.i(37341);
    if (((w)this.rve).textSize > 0.0F) {
      this.euY.setTextSize(0, ((w)this.rve).textSize);
    }
    Object localObject;
    if (((w)this.rve).subType == 1)
    {
      if (!bo.isNullOrNil(((w)this.rve).rta))
      {
        localObject = ((w)this.rve).rta.trim().replace("<icon", "<img");
        d.ysm.remove(this.gaj);
        this.gaj = new ab.1(this, (String)localObject);
        d.post(this.gaj, "");
      }
      if (((w)this.rve).textAlignment != 0) {
        break label412;
      }
      this.euY.setGravity(3);
      label145:
      if ((((w)this.rve).oKE == null) || (((w)this.rve).oKE.length() <= 0)) {
        break label497;
      }
    }
    for (;;)
    {
      try
      {
        i = Color.parseColor(((w)this.rve).oKE);
        this.euY.setTextColor(i);
        if (((w)this.rve).rte > 0.0F) {
          this.euY.setLineSpacing(0.0F, ((w)this.rve).rte + 1.0F);
        }
        localObject = this.euY.getPaint();
        if (((w)this.rve).rtb) {
          ((TextPaint)localObject).setFakeBoldText(true);
        }
        if (((w)this.rve).rtc) {
          ((TextPaint)localObject).setTextSkewX(-0.25F);
        }
        if (((w)this.rve).rtd) {
          ((TextPaint)localObject).setUnderlineText(true);
        }
        if (((w)this.rve).maxLines > 0) {
          this.euY.setMaxLines(((w)this.rve).maxLines);
        }
        if (((w)this.rve).rsi == w.rsZ) {
          this.euY.setTypeface(ae.eW(this.context));
        }
        AppMethodBeat.o(37341);
        return;
        if (bo.isNullOrNil(((w)this.rve).rta)) {
          break;
        }
        this.euY.setText(g.dvk().b(((w)this.rve).rta.trim(), this.euY.getTextSize()));
        break;
        label412:
        if (((w)this.rve).textAlignment == 1)
        {
          this.euY.setGravity(17);
          break label145;
        }
        if (((w)this.rve).textAlignment != 2) {
          break label145;
        }
        this.euY.setGravity(5);
      }
      catch (Exception localException)
      {
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.Sns.AdLandingPageTextComponent", "parse the color is error : " + ((w)this.rve).oKE);
        continue;
      }
      label497:
      int i = Color.parseColor("#FFFFFF");
      this.euY.setTextColor(i);
    }
  }
  
  protected final void cqQ()
  {
    AppMethodBeat.i(37340);
    ViewGroup.LayoutParams localLayoutParams = this.contentView.getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      ((ViewGroup.MarginLayoutParams)localLayoutParams).setMargins((int)this.rve.paddingLeft, (int)this.rve.paddingTop, (int)this.rve.paddingRight, (int)this.rve.paddingBottom);
    }
    this.contentView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(37340);
  }
  
  public final void cqz()
  {
    AppMethodBeat.i(37339);
    super.cqz();
    d.ysm.remove(this.gaj);
    this.rxV = true;
    AppMethodBeat.o(37339);
  }
  
  protected final int getLayout()
  {
    return 2130970790;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ab
 * JD-Core Version:    0.7.0.1
 */