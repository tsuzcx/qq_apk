package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnHoverListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.u;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.chatting.viewitems.bk;

public final class q
{
  public static b JBv;
  
  static
  {
    AppMethodBeat.i(34577);
    JBv = new b();
    AppMethodBeat.o(34577);
  }
  
  public static void dY(View paramView)
  {
    AppMethodBeat.i(34574);
    Object localObject = JBv;
    if ((paramView == null) || (localObject == null))
    {
      ad.w("MicroMsg.OnHoverCompatibleHelper", "view or callback is null.");
      AppMethodBeat.o(34574);
      return;
    }
    if (Build.VERSION.SDK_INT >= 14)
    {
      ag localag = ag.fCd();
      if ((Build.VERSION.SDK_INT >= 14) && (localag.JDR == null)) {
        localag.JDR = new ag.a((ag.b)localObject);
      }
      localObject = localag.JDR;
      if ((localObject != null) && (Build.VERSION.SDK_INT >= 14) && ((localObject instanceof View.OnHoverListener))) {
        paramView.setOnHoverListener((View.OnHoverListener)localObject);
      }
    }
    AppMethodBeat.o(34574);
  }
  
  public static void dismiss()
  {
    AppMethodBeat.i(34575);
    try
    {
      if (JBv != null) {
        b.a(JBv);
      }
      AppMethodBeat.o(34575);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.ChattingItemAvatarOnHoverHelper", "exception in dismiss, %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(34575);
    }
  }
  
  public static final class b
    implements View.OnClickListener, View.OnTouchListener, ag.b
  {
    private int JBA;
    private int JBB;
    private boolean JBC;
    private q.a JBD;
    private View.OnTouchListener JBE;
    private int JBF;
    private av.a JBG;
    private o JBw;
    private View JBx;
    private View JBy;
    private int JBz;
    private View azA;
    private av cjg;
    private View mContentView;
    private int mFF;
    private int mMargin;
    private int wSL;
    
    public b()
    {
      AppMethodBeat.i(34568);
      this.JBD = new q.a();
      this.JBE = new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(34566);
          b localb = new b();
          localb.bd(paramAnonymousView);
          localb.bd(paramAnonymousMotionEvent);
          a.b("com/tencent/mm/ui/chatting/ChattingItemAvatarOnHoverHelper$OnHoverMotionEventCallback$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
          if (q.b.b(q.b.this) != null) {
            q.b.b(q.b.this).onTouch(q.b.c(q.b.this), paramAnonymousMotionEvent);
          }
          a.a(false, this, "com/tencent/mm/ui/chatting/ChattingItemAvatarOnHoverHelper$OnHoverMotionEventCallback$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(34566);
          return false;
        }
      };
      this.JBF = 300;
      this.JBG = new av.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(34567);
          if ((q.b.d(q.b.this) != null) && (q.b.e(q.b.this) != null)) {
            q.b.e(q.b.this).showAsDropDown(q.b.d(q.b.this), q.b.f(q.b.this), q.b.g(q.b.this));
          }
          AppMethodBeat.o(34567);
          return false;
        }
      };
      AppMethodBeat.o(34568);
    }
    
    private void dismiss()
    {
      AppMethodBeat.i(34569);
      if (this.JBw != null) {
        this.JBw.dismiss();
      }
      AppMethodBeat.o(34569);
    }
    
    public final boolean f(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(34570);
      Object localObject1 = paramView.getTag();
      if ((localObject1 == null) || (!(localObject1 instanceof bk)))
      {
        ad.i("MicroMsg.ChattingItemAvatarOnHoverHelper", "The Tag of the View is not a instance of ItemDataTag or is null.");
        AppMethodBeat.o(34570);
        return false;
      }
      localObject1 = (bk)paramView.getTag();
      Object localObject2 = ((bk)localObject1).userName;
      Object localObject3 = u.aAm();
      if ((bt.isNullOrNil((String)localObject3)) || (((String)localObject3).equals(localObject2))) {
        ad.v("MicroMsg.ChattingItemAvatarOnHoverHelper", "Can't talk to self and self username can't be null.");
      }
      for (int i = 0; i == 0; i = 1)
      {
        AppMethodBeat.o(34570);
        return false;
      }
      localObject2 = paramView.getContext();
      if (this.JBw == null)
      {
        localObject3 = ((Context)localObject2).getResources();
        float f = ((Resources)localObject3).getDimension(2131165505);
        this.JBz = ((int)(((Resources)localObject3).getDimension(2131165187) * 2.0F + f));
        this.mContentView = View.inflate((Context)localObject2, 2131493412, null);
        this.JBx = this.mContentView.findViewById(2131306309);
        this.JBy = this.mContentView.findViewById(2131296967);
        this.JBy.setOnClickListener(this);
        this.JBx.setOnClickListener(this);
        this.JBy.setOnTouchListener(this.JBE);
        this.JBx.setOnTouchListener(this.JBE);
        this.JBw = new o(this.mContentView, -2, this.JBz, false);
        this.JBw.setOutsideTouchable(true);
        localObject3 = new Rect();
        if ((localObject2 instanceof Activity)) {
          ((Activity)localObject2).getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject3);
        }
        this.mFF = ((Rect)localObject3).top;
        localObject3 = ((Context)localObject2).getResources().getDisplayMetrics();
        if (((DisplayMetrics)localObject3).widthPixels > ((DisplayMetrics)localObject3).heightPixels)
        {
          this.wSL = ((Context)localObject2).getResources().getDimensionPixelSize(2131165251);
          this.JBw.setBackgroundDrawable(new ColorDrawable(16777215));
          this.mMargin = 0;
          this.cjg = new av(Looper.getMainLooper(), this.JBG, false);
          ad.i("MicroMsg.ChattingItemAvatarOnHoverHelper", "Create a new PopupWindow.");
        }
      }
      else
      {
        localObject2 = this.JBw;
        switch (paramMotionEvent.getAction())
        {
        }
      }
      do
      {
        for (;;)
        {
          AppMethodBeat.o(34570);
          return true;
          this.wSL = ((Context)localObject2).getResources().getDimensionPixelSize(2131165252);
          break;
          this.JBC = false;
          this.azA = null;
        }
        this.azA = paramView;
        paramView.setOnTouchListener(this);
        if (((o)localObject2).isShowing()) {
          ((o)localObject2).dismiss();
        }
      } while (this.JBC);
      this.JBy.setTag(localObject1);
      this.JBx.setTag(localObject1);
      this.JBy.setVisibility(0);
      this.JBx.setVisibility(8);
      paramMotionEvent = new int[2];
      paramView.getLocationInWindow(paramMotionEvent);
      i = paramMotionEvent[1];
      paramView.getWidth();
      int j = paramView.getHeight();
      this.JBB = this.mMargin;
      if (i > this.mFF + this.wSL + this.JBz) {
        this.JBB = (-j - this.JBz - this.mMargin);
      }
      this.JBA = 0;
      if (this.JBB >= 0) {
        this.mContentView.setBackgroundResource(2131231657);
      }
      for (;;)
      {
        paramView = this.cjg;
        long l = this.JBF;
        paramView.az(l, l);
        break;
        this.mContentView.setBackgroundResource(2131231658);
      }
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(34572);
      Object localObject = new b();
      ((b)localObject).bd(paramView);
      a.b("com/tencent/mm/ui/chatting/ChattingItemAvatarOnHoverHelper$OnHoverMotionEventCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
      localObject = (bk)paramView.getTag();
      if (paramView == this.JBy) {
        q.x(paramView.getContext(), ((bk)localObject).userName, 3);
      }
      for (;;)
      {
        dismiss();
        a.a(this, "com/tencent/mm/ui/chatting/ChattingItemAvatarOnHoverHelper$OnHoverMotionEventCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(34572);
        return;
        q.x(paramView.getContext(), ((bk)localObject).userName, 2);
      }
    }
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(34571);
      b localb = new b();
      localb.bd(paramView);
      localb.bd(paramMotionEvent);
      a.b("com/tencent/mm/ui/chatting/ChattingItemAvatarOnHoverHelper$OnHoverMotionEventCallback", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
      switch (paramMotionEvent.getAction())
      {
      }
      for (;;)
      {
        a.a(false, this, "com/tencent/mm/ui/chatting/ChattingItemAvatarOnHoverHelper$OnHoverMotionEventCallback", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(34571);
        return false;
        this.JBC = true;
        dismiss();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.q
 * JD-Core Version:    0.7.0.1
 */