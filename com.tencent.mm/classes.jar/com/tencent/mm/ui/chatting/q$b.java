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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.chatting.viewitems.az;

public final class q$b
  implements View.OnClickListener, View.OnTouchListener, ag.b
{
  private View Qz;
  private View apm;
  private ap bAz;
  private int iPy;
  private int mMargin;
  private int pBb;
  private o zzD;
  private View zzE;
  private View zzF;
  private int zzG;
  private int zzH;
  private int zzI;
  private boolean zzJ;
  private q.a zzK;
  private View.OnTouchListener zzL;
  private int zzM;
  private ap.a zzN;
  
  public q$b()
  {
    AppMethodBeat.i(30698);
    this.zzK = new q.a();
    this.zzL = new q.b.1(this);
    this.zzM = 300;
    this.zzN = new q.b.2(this);
    AppMethodBeat.o(30698);
  }
  
  private void dismiss()
  {
    AppMethodBeat.i(30699);
    if (this.zzD != null) {
      this.zzD.dismiss();
    }
    AppMethodBeat.o(30699);
  }
  
  public final boolean f(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(30700);
    Object localObject1 = paramView.getTag();
    if ((localObject1 == null) || (!(localObject1 instanceof az)))
    {
      ab.i("MicroMsg.ChattingItemAvatarOnHoverHelper", "The Tag of the View is not a instance of ItemDataTag or is null.");
      AppMethodBeat.o(30700);
      return false;
    }
    localObject1 = (az)paramView.getTag();
    Object localObject2 = ((az)localObject1).userName;
    Object localObject3 = r.Zn();
    if ((ah.isNullOrNil((String)localObject3)) || (((String)localObject3).equals(localObject2))) {
      ab.v("MicroMsg.ChattingItemAvatarOnHoverHelper", "Can't talk to self and self username can't be null.");
    }
    for (int i = 0; i == 0; i = 1)
    {
      AppMethodBeat.o(30700);
      return false;
    }
    localObject2 = paramView.getContext();
    if (this.zzD == null)
    {
      localObject3 = ((Context)localObject2).getResources();
      float f = ((Resources)localObject3).getDimension(2131427797);
      this.zzG = ((int)(((Resources)localObject3).getDimension(2131427496) * 2.0F + f));
      this.Qz = View.inflate((Context)localObject2, 2130969045, null);
      this.zzE = this.Qz.findViewById(2131822513);
      this.zzF = this.Qz.findViewById(2131822514);
      this.zzF.setOnClickListener(this);
      this.zzE.setOnClickListener(this);
      this.zzF.setOnTouchListener(this.zzL);
      this.zzE.setOnTouchListener(this.zzL);
      this.zzD = new o(this.Qz, -2, this.zzG, false);
      this.zzD.setOutsideTouchable(true);
      localObject3 = new Rect();
      if ((localObject2 instanceof Activity)) {
        ((Activity)localObject2).getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject3);
      }
      this.iPy = ((Rect)localObject3).top;
      localObject3 = ((Context)localObject2).getResources().getDisplayMetrics();
      if (((DisplayMetrics)localObject3).widthPixels > ((DisplayMetrics)localObject3).heightPixels)
      {
        this.pBb = ((Context)localObject2).getResources().getDimensionPixelSize(2131427558);
        this.zzD.setBackgroundDrawable(new ColorDrawable(16777215));
        this.mMargin = 0;
        this.bAz = new ap(Looper.getMainLooper(), this.zzN, false);
        ab.i("MicroMsg.ChattingItemAvatarOnHoverHelper", "Create a new PopupWindow.");
      }
    }
    else
    {
      localObject2 = this.zzD;
      switch (paramMotionEvent.getAction())
      {
      }
    }
    do
    {
      for (;;)
      {
        AppMethodBeat.o(30700);
        return true;
        this.pBb = ((Context)localObject2).getResources().getDimensionPixelSize(2131427559);
        break;
        this.zzJ = false;
        this.apm = null;
      }
      this.apm = paramView;
      paramView.setOnTouchListener(this);
      if (((o)localObject2).isShowing()) {
        ((o)localObject2).dismiss();
      }
    } while (this.zzJ);
    this.zzF.setTag(localObject1);
    this.zzE.setTag(localObject1);
    this.zzF.setVisibility(0);
    this.zzE.setVisibility(8);
    paramMotionEvent = new int[2];
    paramView.getLocationInWindow(paramMotionEvent);
    i = paramMotionEvent[1];
    paramView.getWidth();
    int j = paramView.getHeight();
    this.zzI = this.mMargin;
    if (i > this.iPy + this.pBb + this.zzG) {
      this.zzI = (-j - this.zzG - this.mMargin);
    }
    this.zzH = 0;
    if (this.zzI >= 0) {
      this.Qz.setBackgroundResource(2130838306);
    }
    for (;;)
    {
      paramView = this.bAz;
      long l = this.zzM;
      paramView.ag(l, l);
      break;
      this.Qz.setBackgroundResource(2130838307);
    }
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(30702);
    az localaz = (az)paramView.getTag();
    if (paramView == this.zzF) {
      q.v(paramView.getContext(), localaz.userName, 3);
    }
    for (;;)
    {
      dismiss();
      AppMethodBeat.o(30702);
      return;
      q.v(paramView.getContext(), localaz.userName, 2);
    }
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(30701);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(30701);
      return false;
      this.zzJ = true;
      dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.q.b
 * JD-Core Version:    0.7.0.1
 */