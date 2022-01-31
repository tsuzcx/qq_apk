package com.tencent.mm.plugin.sns.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.an;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.MMGestureGallery.l;

public abstract class SnsBaseGalleryUI
  extends MMActivity
  implements s.a
{
  private LinearLayout khG;
  private LinearLayout rNN;
  r rNO;
  s rNP;
  private boolean rNQ = true;
  private boolean rNR = true;
  private TextView rNS = null;
  protected SnsInfoFlip rNT;
  protected Button rNU;
  
  @SuppressLint({"ResourceAsColor"})
  public final void E(boolean paramBoolean, int paramInt)
  {
    this.rNO = new r(this, paramInt, paramBoolean);
    this.rNO.setBackgroundColor(2131690605);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    this.rNO.getBackground().setAlpha(50);
    this.khG.addView(this.rNO, localLayoutParams);
    paramInt = getIntent().getIntExtra("sns_source", 0);
    this.rNO.setSnsSource(paramInt);
  }
  
  public void addView(View paramView)
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
    this.rNN.addView(paramView, localLayoutParams);
  }
  
  public void ctA()
  {
    int j = 8;
    boolean bool = false;
    if (!this.rNQ) {
      return;
    }
    r localr;
    if (this.rNR)
    {
      i = 8;
      setTitleVisibility(i);
      if (this.rNO != null)
      {
        localr = this.rNO;
        if (!this.rNR) {
          break label76;
        }
      }
    }
    label76:
    for (int i = j;; i = 0)
    {
      localr.setVisibility(i);
      if (!this.rNR) {
        bool = true;
      }
      this.rNR = bool;
      return;
      i = 0;
      break;
    }
  }
  
  public final void ctB()
  {
    this.rNR = false;
    setTitleVisibility(8);
    if (this.rNO != null) {
      this.rNO.setVisibility(8);
    }
  }
  
  public void ds(String paramString, int paramInt) {}
  
  public void dt(String paramString, int paramInt)
  {
    if ((!this.rNQ) || (ag.coN())) {
      return;
    }
    paramString = ag.cpf().abv(paramString);
    if ((paramString == null) || (paramString.field_snsId == 0L))
    {
      enableOptionMenu(false);
      return;
    }
    enableOptionMenu(true);
  }
  
  public final void gI(String paramString1, String paramString2)
  {
    if (!this.rNQ) {
      return;
    }
    setMMTitle(paramString1);
    setMMSubTitle(paramString2);
  }
  
  public int getLayoutId()
  {
    return 2130970825;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    ag.cpa().ac(3, true);
    this.rNN = ((LinearLayout)findViewById(2131827917));
    this.khG = ((LinearLayout)findViewById(2131820946));
    this.rNP = new s(this, this);
    paramBundle = this.rNP;
    ab.i("MicroMsg.GalleryTitleManager", "onAttach");
    g.RM();
    g.RK().eHt.a(218, paramBundle);
    a.ymk.c(paramBundle.mwt);
    a.ymk.c(paramBundle.rGI);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Object localObject;
    if (this.rNP != null)
    {
      localObject = this.rNP;
      ab.i("MicroMsg.GalleryTitleManager", "onDetch");
      g.RM();
      g.RK().eHt.b(218, (f)localObject);
      a.ymk.d(((s)localObject).mwt);
      a.ymk.d(((s)localObject).rGI);
    }
    if (this.rNT != null)
    {
      localObject = this.rNT;
      if ((((SnsInfoFlip)localObject).rQU != null) && ((((SnsInfoFlip)localObject).rQU instanceof MMGestureGallery)))
      {
        localObject = (MMGestureGallery)((SnsInfoFlip)localObject).rQU;
        ((MMGestureGallery)localObject).AvH.release();
        ((MMGestureGallery)localObject).AvI.release();
        ((MMGestureGallery)localObject).AvG.release();
      }
      this.rNT.onDestroy();
    }
  }
  
  public void onPause()
  {
    if (this.rNT != null) {
      this.rNT.onPause();
    }
    if (this.rNP != null)
    {
      s locals = this.rNP;
      if (locals.rGz != null)
      {
        an localan = new an();
        localan.cnQ.activity = ((Activity)locals.context);
        localan.cnQ.cnR = locals.rGz;
        a.ymk.l(localan);
        locals.rGz = null;
        locals.cpF = 0;
        locals.cpE = 0;
      }
    }
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.rNO != null) {
      this.rNO.refresh();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsBaseGalleryUI
 * JD-Core Version:    0.7.0.1
 */