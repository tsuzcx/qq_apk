package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.a;

public class TalkRoomPopupNav
  extends LinearLayout
{
  public View kcm;
  public LinearLayout uPo;
  private Animation vbA;
  public AlphaAnimation vbB;
  public AlphaAnimation vbC;
  private a vbq;
  public LinearLayout vbr;
  private LinearLayout vbs;
  private ImageView vbt;
  public ImageView vbu;
  public ScaleAnimation vbv;
  public Animation vbw;
  public int vbx = 0;
  public int vby = 0;
  private ScaleAnimation vbz;
  
  public TalkRoomPopupNav(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initView();
  }
  
  @TargetApi(11)
  public TalkRoomPopupNav(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView();
  }
  
  private void initView()
  {
    inflate(getContext(), R.i.talk_room_popup_nav, this);
    this.uPo = ((LinearLayout)findViewById(R.h.nav_layout));
    this.vbr = ((LinearLayout)findViewById(R.h.dialog_layout));
    this.vbs = ((LinearLayout)findViewById(R.h.dialog_btn_layout));
    this.kcm = findViewById(R.h.nav_bg);
    this.vbt = ((ImageView)findViewById(R.h.talk_scene_icon));
    this.vbu = ((ImageView)findViewById(R.h.talk_scene_icon_anim));
    this.vbu.setVisibility(8);
    this.uPo.setOnClickListener(new TalkRoomPopupNav.1(this));
    ((Button)findViewById(R.h.btn_cancel)).setOnClickListener(new TalkRoomPopupNav.2(this));
    ((Button)findViewById(R.h.btn_confirm)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        TalkRoomPopupNav.b(TalkRoomPopupNav.this);
        if (TalkRoomPopupNav.a(TalkRoomPopupNav.this) != null) {
          TalkRoomPopupNav.a(TalkRoomPopupNav.this).cBq();
        }
      }
    });
    this.vbx = this.kcm.getLayoutParams().height;
    this.vby = this.vbr.getLayoutParams().height;
  }
  
  public void setBgViewResource(int paramInt)
  {
    if (this.kcm != null) {
      this.kcm.setBackgroundResource(paramInt);
    }
  }
  
  public void setDialogContent(String paramString)
  {
    ((TextView)findViewById(R.h.tv_dialog_content)).setText(paramString);
  }
  
  public void setIconAnim(int paramInt)
  {
    if (paramInt < 0) {
      if (this.vbu != null) {
        this.vbu.setVisibility(8);
      }
    }
    while (this.vbu == null) {
      return;
    }
    this.vbu.setImageResource(paramInt);
    this.vbu.setVisibility(0);
  }
  
  public void setIconRes(int paramInt)
  {
    if (this.vbt != null) {
      this.vbt.setImageResource(paramInt);
    }
  }
  
  public void setNavContent(String paramString)
  {
    ((TextView)findViewById(R.h.tv_nav_content)).setText(paramString);
  }
  
  public void setOnClickListener(a parama)
  {
    this.vbq = parama;
  }
  
  public final void stop()
  {
    if ((this.vbB != null) && (this.vbC != null))
    {
      BackwardSupportUtil.a.a(this.vbu, this.vbB);
      BackwardSupportUtil.a.a(this.vbu, this.vbC);
      this.vbu.clearAnimation();
      this.vbB = null;
      this.vbC = null;
    }
  }
  
  public static abstract interface a
  {
    public abstract void cBp();
    
    public abstract void cBq();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.TalkRoomPopupNav
 * JD-Core Version:    0.7.0.1
 */