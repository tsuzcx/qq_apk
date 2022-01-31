package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.model.q;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.chatting.viewitems.aw;

public final class r$b
  implements View.OnClickListener, View.OnTouchListener, ak.b
{
  private View QR;
  private int acr;
  private View amX;
  private am fjC;
  private int heA;
  private o vkb;
  private View vkc;
  private View vkd;
  private int vke;
  private int vkf;
  private int vkg;
  private int vkh;
  private boolean vki;
  private r.a vkj = new r.a();
  private View.OnTouchListener vkk = new r.b.1(this);
  private int vkl = 300;
  private am.a vkm = new r.b.2(this);
  
  private void dismiss()
  {
    if (this.vkb != null) {
      this.vkb.dismiss();
    }
  }
  
  public final boolean e(View paramView, MotionEvent paramMotionEvent)
  {
    Object localObject1 = paramView.getTag();
    if ((localObject1 == null) || (!(localObject1 instanceof aw)))
    {
      y.i("MicroMsg.ChattingItemAvatarOnHoverHelper", "The Tag of the View is not a instance of ItemDataTag or is null.");
      return false;
    }
    localObject1 = (aw)paramView.getTag();
    Object localObject2 = ((aw)localObject1).userName;
    Object localObject3 = q.Gj();
    if ((ah.bl((String)localObject3)) || (((String)localObject3).equals(localObject2))) {
      y.v("MicroMsg.ChattingItemAvatarOnHoverHelper", "Can't talk to self and self username can't be null.");
    }
    for (int i = 0; i == 0; i = 1) {
      return false;
    }
    localObject2 = paramView.getContext();
    if (this.vkb == null)
    {
      localObject3 = ((Context)localObject2).getResources();
      float f = ((Resources)localObject3).getDimension(R.f.MiniAvatarSize);
      this.vke = ((int)(((Resources)localObject3).getDimension(R.f.BasicPaddingSize) * 2.0F + f));
      this.QR = View.inflate((Context)localObject2, R.i.chatting_item_avatar_faster_entrance, null);
      this.vkc = this.QR.findViewById(R.h.video);
      this.vkd = this.QR.findViewById(R.h.audio);
      this.vkd.setOnClickListener(this);
      this.vkc.setOnClickListener(this);
      this.vkd.setOnTouchListener(this.vkk);
      this.vkc.setOnTouchListener(this.vkk);
      this.vkb = new o(this.QR, -2, this.vke, false);
      this.vkb.setOutsideTouchable(true);
      localObject3 = new Rect();
      if ((localObject2 instanceof Activity)) {
        ((Activity)localObject2).getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject3);
      }
      this.heA = ((Rect)localObject3).top;
      localObject3 = ((Context)localObject2).getResources().getDisplayMetrics();
      if (((DisplayMetrics)localObject3).widthPixels > ((DisplayMetrics)localObject3).heightPixels)
      {
        this.vkf = ((Context)localObject2).getResources().getDimensionPixelSize(R.f.DefaultActionbarHeightLand);
        this.vkb.setBackgroundDrawable(new ColorDrawable(16777215));
        this.acr = 0;
        this.fjC = new am(Looper.getMainLooper(), this.vkm, false);
        y.i("MicroMsg.ChattingItemAvatarOnHoverHelper", "Create a new PopupWindow.");
      }
    }
    else
    {
      localObject2 = this.vkb;
      switch (paramMotionEvent.getAction())
      {
      }
    }
    do
    {
      for (;;)
      {
        return true;
        this.vkf = ((Context)localObject2).getResources().getDimensionPixelSize(R.f.DefaultActionbarHeightPort);
        break;
        this.vki = false;
        this.amX = null;
      }
      this.amX = paramView;
      paramView.setOnTouchListener(this);
      if (((o)localObject2).isShowing()) {
        ((o)localObject2).dismiss();
      }
    } while (this.vki);
    this.vkd.setTag(localObject1);
    this.vkc.setTag(localObject1);
    this.vkd.setVisibility(0);
    this.vkc.setVisibility(8);
    paramMotionEvent = new int[2];
    paramView.getLocationInWindow(paramMotionEvent);
    i = paramMotionEvent[1];
    paramView.getWidth();
    int j = paramView.getHeight();
    this.vkh = this.acr;
    if (i > this.heA + this.vkf + this.vke) {
      this.vkh = (-j - this.vke - this.acr);
    }
    this.vkg = 0;
    if (this.vkh >= 0) {
      this.QR.setBackgroundResource(R.g.chatting_fast_entrance_win_bottom);
    }
    for (;;)
    {
      paramView = this.fjC;
      long l = this.vkl;
      paramView.S(l, l);
      break;
      this.QR.setBackgroundResource(R.g.chatting_fast_entrance_win_top);
    }
  }
  
  public final void onClick(View paramView)
  {
    aw localaw = (aw)paramView.getTag();
    if (paramView == this.vkd) {
      r.p(paramView.getContext(), localaw.userName, 3);
    }
    for (;;)
    {
      dismiss();
      return;
      r.p(paramView.getContext(), localaw.userName, 2);
    }
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return false;
      this.vki = true;
      dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.r.b
 * JD-Core Version:    0.7.0.1
 */