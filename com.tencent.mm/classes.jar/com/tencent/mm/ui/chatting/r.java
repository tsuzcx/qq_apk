package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnHoverListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.v;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.chatting.viewitems.bk;

public final class r
{
  public static b JWm;
  
  static
  {
    AppMethodBeat.i(34577);
    JWm = new b();
    AppMethodBeat.o(34577);
  }
  
  public static void dY(View paramView)
  {
    AppMethodBeat.i(34574);
    Object localObject = JWm;
    if ((paramView == null) || (localObject == null))
    {
      ae.w("MicroMsg.OnHoverCompatibleHelper", "view or callback is null.");
      AppMethodBeat.o(34574);
      return;
    }
    if (Build.VERSION.SDK_INT >= 14)
    {
      ah localah = ah.fGf();
      if ((Build.VERSION.SDK_INT >= 14) && (localah.JYI == null)) {
        localah.JYI = new ah.a((ah.b)localObject);
      }
      localObject = localah.JYI;
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
      if (JWm != null) {
        b.a(JWm);
      }
      AppMethodBeat.o(34575);
      return;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.ChattingItemAvatarOnHoverHelper", "exception in dismiss, %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(34575);
    }
  }
  
  public static final class a
    implements View.OnTouchListener
  {
    private int mColor;
    
    public a()
    {
      this(Color.argb(255, 136, 136, 136));
      AppMethodBeat.i(34564);
      AppMethodBeat.o(34564);
    }
    
    private a(int paramInt)
    {
      this.mColor = paramInt;
    }
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(34565);
      b localb = new b();
      localb.bd(paramView);
      localb.bd(paramMotionEvent);
      a.b("com/tencent/mm/ui/chatting/ChattingItemAvatarOnHoverHelper$ChangeViewBgOnTouchListener", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
      int i = paramMotionEvent.getAction();
      if ((paramView instanceof ImageView))
      {
        paramView = ((ImageView)paramView).getDrawable();
        if (paramView != null)
        {
          if (i != 0) {
            break label110;
          }
          paramView.setColorFilter(this.mColor, PorterDuff.Mode.MULTIPLY);
        }
      }
      for (;;)
      {
        a.a(false, this, "com/tencent/mm/ui/chatting/ChattingItemAvatarOnHoverHelper$ChangeViewBgOnTouchListener", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(34565);
        return false;
        paramView = paramView.getBackground();
        break;
        label110:
        if ((i == 3) || (i == 1)) {
          paramView.clearColorFilter();
        }
      }
    }
  }
  
  public static final class b
    implements View.OnClickListener, View.OnTouchListener, ah.b
  {
    private o JWn;
    private View JWo;
    private View JWp;
    private int JWq;
    private int JWr;
    private int JWs;
    private boolean JWt;
    private r.a JWu;
    private View.OnTouchListener JWv;
    private int JWw;
    private aw.a JWx;
    private View azA;
    private aw cji;
    private View mContentView;
    private int mKJ;
    private int mMargin;
    private int xiC;
    
    public b()
    {
      AppMethodBeat.i(34568);
      this.JWu = new r.a();
      this.JWv = new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(34566);
          b localb = new b();
          localb.bd(paramAnonymousView);
          localb.bd(paramAnonymousMotionEvent);
          a.b("com/tencent/mm/ui/chatting/ChattingItemAvatarOnHoverHelper$OnHoverMotionEventCallback$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
          if (r.b.b(r.b.this) != null) {
            r.b.b(r.b.this).onTouch(r.b.c(r.b.this), paramAnonymousMotionEvent);
          }
          a.a(false, this, "com/tencent/mm/ui/chatting/ChattingItemAvatarOnHoverHelper$OnHoverMotionEventCallback$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(34566);
          return false;
        }
      };
      this.JWw = 300;
      this.JWx = new aw.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(34567);
          if ((r.b.d(r.b.this) != null) && (r.b.e(r.b.this) != null)) {
            r.b.e(r.b.this).showAsDropDown(r.b.d(r.b.this), r.b.f(r.b.this), r.b.g(r.b.this));
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
      if (this.JWn != null) {
        this.JWn.dismiss();
      }
      AppMethodBeat.o(34569);
    }
    
    public final boolean f(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(34570);
      Object localObject1 = paramView.getTag();
      if ((localObject1 == null) || (!(localObject1 instanceof bk)))
      {
        ae.i("MicroMsg.ChattingItemAvatarOnHoverHelper", "The Tag of the View is not a instance of ItemDataTag or is null.");
        AppMethodBeat.o(34570);
        return false;
      }
      localObject1 = (bk)paramView.getTag();
      Object localObject2 = ((bk)localObject1).userName;
      Object localObject3 = v.aAC();
      if ((bu.isNullOrNil((String)localObject3)) || (((String)localObject3).equals(localObject2))) {
        ae.v("MicroMsg.ChattingItemAvatarOnHoverHelper", "Can't talk to self and self username can't be null.");
      }
      for (int i = 0; i == 0; i = 1)
      {
        AppMethodBeat.o(34570);
        return false;
      }
      localObject2 = paramView.getContext();
      if (this.JWn == null)
      {
        localObject3 = ((Context)localObject2).getResources();
        float f = ((Resources)localObject3).getDimension(2131165505);
        this.JWq = ((int)(((Resources)localObject3).getDimension(2131165187) * 2.0F + f));
        this.mContentView = View.inflate((Context)localObject2, 2131493412, null);
        this.JWo = this.mContentView.findViewById(2131306309);
        this.JWp = this.mContentView.findViewById(2131296967);
        this.JWp.setOnClickListener(this);
        this.JWo.setOnClickListener(this);
        this.JWp.setOnTouchListener(this.JWv);
        this.JWo.setOnTouchListener(this.JWv);
        this.JWn = new o(this.mContentView, -2, this.JWq, false);
        this.JWn.setOutsideTouchable(true);
        localObject3 = new Rect();
        if ((localObject2 instanceof Activity)) {
          ((Activity)localObject2).getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject3);
        }
        this.mKJ = ((Rect)localObject3).top;
        localObject3 = ((Context)localObject2).getResources().getDisplayMetrics();
        if (((DisplayMetrics)localObject3).widthPixels > ((DisplayMetrics)localObject3).heightPixels)
        {
          this.xiC = ((Context)localObject2).getResources().getDimensionPixelSize(2131165251);
          this.JWn.setBackgroundDrawable(new ColorDrawable(16777215));
          this.mMargin = 0;
          this.cji = new aw(Looper.getMainLooper(), this.JWx, false);
          ae.i("MicroMsg.ChattingItemAvatarOnHoverHelper", "Create a new PopupWindow.");
        }
      }
      else
      {
        localObject2 = this.JWn;
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
          this.xiC = ((Context)localObject2).getResources().getDimensionPixelSize(2131165252);
          break;
          this.JWt = false;
          this.azA = null;
        }
        this.azA = paramView;
        paramView.setOnTouchListener(this);
        if (((o)localObject2).isShowing()) {
          ((o)localObject2).dismiss();
        }
      } while (this.JWt);
      this.JWp.setTag(localObject1);
      this.JWo.setTag(localObject1);
      this.JWp.setVisibility(0);
      this.JWo.setVisibility(8);
      paramMotionEvent = new int[2];
      paramView.getLocationInWindow(paramMotionEvent);
      i = paramMotionEvent[1];
      paramView.getWidth();
      int j = paramView.getHeight();
      this.JWs = this.mMargin;
      if (i > this.mKJ + this.xiC + this.JWq) {
        this.JWs = (-j - this.JWq - this.mMargin);
      }
      this.JWr = 0;
      if (this.JWs >= 0) {
        this.mContentView.setBackgroundResource(2131231657);
      }
      for (;;)
      {
        paramView = this.cji;
        long l = this.JWw;
        paramView.ay(l, l);
        break;
        this.mContentView.setBackgroundResource(2131231658);
      }
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(34572);
      Object localObject = new b();
      ((b)localObject).bd(paramView);
      a.b("com/tencent/mm/ui/chatting/ChattingItemAvatarOnHoverHelper$OnHoverMotionEventCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
      localObject = (bk)paramView.getTag();
      if (paramView == this.JWp) {
        r.w(paramView.getContext(), ((bk)localObject).userName, 3);
      }
      for (;;)
      {
        dismiss();
        a.a(this, "com/tencent/mm/ui/chatting/ChattingItemAvatarOnHoverHelper$OnHoverMotionEventCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(34572);
        return;
        r.w(paramView.getContext(), ((bk)localObject).userName, 2);
      }
    }
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(34571);
      b localb = new b();
      localb.bd(paramView);
      localb.bd(paramMotionEvent);
      a.b("com/tencent/mm/ui/chatting/ChattingItemAvatarOnHoverHelper$OnHoverMotionEventCallback", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
      switch (paramMotionEvent.getAction())
      {
      }
      for (;;)
      {
        a.a(false, this, "com/tencent/mm/ui/chatting/ChattingItemAvatarOnHoverHelper$OnHoverMotionEventCallback", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(34571);
        return false;
        this.JWt = true;
        dismiss();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.r
 * JD-Core Version:    0.7.0.1
 */