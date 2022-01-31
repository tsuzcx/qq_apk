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
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.al;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.MMGestureGallery.l;

public abstract class SnsBaseGalleryUI
  extends MMActivity
  implements s.a
{
  private boolean hZa = true;
  private LinearLayout oVs;
  r oVt;
  private LinearLayout oVu;
  s oVv;
  private boolean oVw = true;
  private TextView oVx = null;
  protected SnsInfoFlip oVy;
  protected Button oVz;
  
  public void addView(View paramView)
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
    this.oVs.addView(paramView, localLayoutParams);
  }
  
  public void awQ()
  {
    int j = 8;
    boolean bool = false;
    if (!this.oVw) {
      return;
    }
    r localr;
    if (this.hZa)
    {
      i = 8;
      setTitleVisibility(i);
      if (this.oVt != null)
      {
        localr = this.oVt;
        if (!this.hZa) {
          break label76;
        }
      }
    }
    label76:
    for (int i = j;; i = 0)
    {
      localr.setVisibility(i);
      if (!this.hZa) {
        bool = true;
      }
      this.hZa = bool;
      return;
      i = 0;
      break;
    }
  }
  
  public final void bHv()
  {
    this.hZa = false;
    setTitleVisibility(8);
    if (this.oVt != null) {
      this.oVt.setVisibility(8);
    }
  }
  
  public void cw(String paramString, int paramInt) {}
  
  public void cx(String paramString, int paramInt)
  {
    if ((!this.oVw) || (af.bDo())) {
      return;
    }
    paramString = af.bDF().OB(paramString);
    if ((paramString == null) || (paramString.field_snsId == 0L))
    {
      enableOptionMenu(false);
      return;
    }
    enableOptionMenu(true);
  }
  
  public final void fa(String paramString1, String paramString2)
  {
    if (!this.oVw) {
      return;
    }
    setMMTitle(paramString1);
    setMMSubTitle(paramString2);
  }
  
  protected int getLayoutId()
  {
    return i.g.sns_gallery_img;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    af.bDA().T(3, true);
    this.oVs = ((LinearLayout)findViewById(i.f.layout_content));
    this.oVu = ((LinearLayout)findViewById(i.f.content));
    this.oVv = new s(this, this);
    paramBundle = this.oVv;
    y.i("MicroMsg.GalleryTitleManager", "onAttach");
    g.DQ();
    g.DO().dJT.a(218, paramBundle);
    a.udP.c(paramBundle.kbV);
    a.udP.c(paramBundle.oOV);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Object localObject;
    if (this.oVv != null)
    {
      localObject = this.oVv;
      y.i("MicroMsg.GalleryTitleManager", "onDetch");
      g.DQ();
      g.DO().dJT.b(218, (f)localObject);
      a.udP.d(((s)localObject).kbV);
      a.udP.d(((s)localObject).oOV);
    }
    if (this.oVy != null)
    {
      localObject = this.oVy;
      if ((((SnsInfoFlip)localObject).oYB != null) && ((((SnsInfoFlip)localObject).oYB instanceof MMGestureGallery)))
      {
        localObject = (MMGestureGallery)((SnsInfoFlip)localObject).oYB;
        ((MMGestureGallery)localObject).wda.release();
        ((MMGestureGallery)localObject).wdb.release();
        ((MMGestureGallery)localObject).wcZ.release();
      }
      this.oVy.onDestroy();
    }
  }
  
  protected void onPause()
  {
    if (this.oVy != null) {
      this.oVy.onPause();
    }
    if (this.oVv != null)
    {
      s locals = this.oVv;
      if (locals.oOO != null)
      {
        al localal = new al();
        localal.bGD.activity = ((Activity)locals.context);
        localal.bGD.bGE = locals.oOO;
        a.udP.m(localal);
        locals.oOO = null;
        locals.bIk = 0;
        locals.bIj = 0;
      }
    }
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.oVt != null) {
      this.oVt.refresh();
    }
  }
  
  @SuppressLint({"ResourceAsColor"})
  public final void w(boolean paramBoolean, int paramInt)
  {
    this.oVt = new r(this, paramInt, paramBoolean);
    this.oVt.setBackgroundColor(i.c.transparent);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    this.oVt.getBackground().setAlpha(50);
    this.oVu.addView(this.oVt, localLayoutParams);
    paramInt = getIntent().getIntExtra("sns_source", 0);
    this.oVt.setSnsSource(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsBaseGalleryUI
 * JD-Core Version:    0.7.0.1
 */