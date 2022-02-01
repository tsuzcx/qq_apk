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
import com.tencent.mm.model.u;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.chatting.viewitems.bj;

public final class q
{
  public static b HNF;
  
  static
  {
    AppMethodBeat.i(34577);
    HNF = new b();
    AppMethodBeat.o(34577);
  }
  
  public static void dT(View paramView)
  {
    AppMethodBeat.i(34574);
    Object localObject = HNF;
    if ((paramView == null) || (localObject == null))
    {
      ac.w("MicroMsg.OnHoverCompatibleHelper", "view or callback is null.");
      AppMethodBeat.o(34574);
      return;
    }
    if (Build.VERSION.SDK_INT >= 14)
    {
      ag localag = ag.flM();
      if ((Build.VERSION.SDK_INT >= 14) && (localag.HQc == null)) {
        localag.HQc = new ag.a((ag.b)localObject);
      }
      localObject = localag.HQc;
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
      if (HNF != null) {
        b.a(HNF);
      }
      AppMethodBeat.o(34575);
      return;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.ChattingItemAvatarOnHoverHelper", "exception in dismiss, %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(34575);
    }
  }
  
  public static final class b
    implements View.OnClickListener, View.OnTouchListener, ag.b
  {
    private o HNG;
    private View HNH;
    private View HNI;
    private int HNJ;
    private int HNK;
    private int HNL;
    private boolean HNM;
    private q.a HNN;
    private View.OnTouchListener HNO;
    private int HNP;
    private au.a HNQ;
    private View axJ;
    private au bYO;
    private View mContentView;
    private int mMargin;
    private int mfe;
    private int vLC;
    
    public b()
    {
      AppMethodBeat.i(34568);
      this.HNN = new q.a();
      this.HNO = new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(34566);
          if (q.b.b(q.b.this) != null) {
            q.b.b(q.b.this).onTouch(q.b.c(q.b.this), paramAnonymousMotionEvent);
          }
          AppMethodBeat.o(34566);
          return false;
        }
      };
      this.HNP = 300;
      this.HNQ = new au.a()
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
      if (this.HNG != null) {
        this.HNG.dismiss();
      }
      AppMethodBeat.o(34569);
    }
    
    public final boolean f(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(34570);
      Object localObject1 = paramView.getTag();
      if ((localObject1 == null) || (!(localObject1 instanceof bj)))
      {
        ac.i("MicroMsg.ChattingItemAvatarOnHoverHelper", "The Tag of the View is not a instance of ItemDataTag or is null.");
        AppMethodBeat.o(34570);
        return false;
      }
      localObject1 = (bj)paramView.getTag();
      Object localObject2 = ((bj)localObject1).userName;
      Object localObject3 = u.axw();
      if ((bs.isNullOrNil((String)localObject3)) || (((String)localObject3).equals(localObject2))) {
        ac.v("MicroMsg.ChattingItemAvatarOnHoverHelper", "Can't talk to self and self username can't be null.");
      }
      for (int i = 0; i == 0; i = 1)
      {
        AppMethodBeat.o(34570);
        return false;
      }
      localObject2 = paramView.getContext();
      if (this.HNG == null)
      {
        localObject3 = ((Context)localObject2).getResources();
        float f = ((Resources)localObject3).getDimension(2131165505);
        this.HNJ = ((int)(((Resources)localObject3).getDimension(2131165187) * 2.0F + f));
        this.mContentView = View.inflate((Context)localObject2, 2131493412, null);
        this.HNH = this.mContentView.findViewById(2131306309);
        this.HNI = this.mContentView.findViewById(2131296967);
        this.HNI.setOnClickListener(this);
        this.HNH.setOnClickListener(this);
        this.HNI.setOnTouchListener(this.HNO);
        this.HNH.setOnTouchListener(this.HNO);
        this.HNG = new o(this.mContentView, -2, this.HNJ, false);
        this.HNG.setOutsideTouchable(true);
        localObject3 = new Rect();
        if ((localObject2 instanceof Activity)) {
          ((Activity)localObject2).getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject3);
        }
        this.mfe = ((Rect)localObject3).top;
        localObject3 = ((Context)localObject2).getResources().getDisplayMetrics();
        if (((DisplayMetrics)localObject3).widthPixels > ((DisplayMetrics)localObject3).heightPixels)
        {
          this.vLC = ((Context)localObject2).getResources().getDimensionPixelSize(2131165251);
          this.HNG.setBackgroundDrawable(new ColorDrawable(16777215));
          this.mMargin = 0;
          this.bYO = new au(Looper.getMainLooper(), this.HNQ, false);
          ac.i("MicroMsg.ChattingItemAvatarOnHoverHelper", "Create a new PopupWindow.");
        }
      }
      else
      {
        localObject2 = this.HNG;
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
          this.vLC = ((Context)localObject2).getResources().getDimensionPixelSize(2131165252);
          break;
          this.HNM = false;
          this.axJ = null;
        }
        this.axJ = paramView;
        paramView.setOnTouchListener(this);
        if (((o)localObject2).isShowing()) {
          ((o)localObject2).dismiss();
        }
      } while (this.HNM);
      this.HNI.setTag(localObject1);
      this.HNH.setTag(localObject1);
      this.HNI.setVisibility(0);
      this.HNH.setVisibility(8);
      paramMotionEvent = new int[2];
      paramView.getLocationInWindow(paramMotionEvent);
      i = paramMotionEvent[1];
      paramView.getWidth();
      int j = paramView.getHeight();
      this.HNL = this.mMargin;
      if (i > this.mfe + this.vLC + this.HNJ) {
        this.HNL = (-j - this.HNJ - this.mMargin);
      }
      this.HNK = 0;
      if (this.HNL >= 0) {
        this.mContentView.setBackgroundResource(2131231657);
      }
      for (;;)
      {
        paramView = this.bYO;
        long l = this.HNP;
        paramView.au(l, l);
        break;
        this.mContentView.setBackgroundResource(2131231658);
      }
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(34572);
      bj localbj = (bj)paramView.getTag();
      if (paramView == this.HNI) {
        q.x(paramView.getContext(), localbj.userName, 3);
      }
      for (;;)
      {
        dismiss();
        AppMethodBeat.o(34572);
        return;
        q.x(paramView.getContext(), localbj.userName, 2);
      }
    }
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(34571);
      switch (paramMotionEvent.getAction())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(34571);
        return false;
        this.HNM = true;
        dismiss();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.q
 * JD-Core Version:    0.7.0.1
 */