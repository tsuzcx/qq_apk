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
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.chatting.viewitems.bq;

public final class r
{
  public static b PhA;
  
  static
  {
    AppMethodBeat.i(34577);
    PhA = new b();
    AppMethodBeat.o(34577);
  }
  
  public static void dQ(View paramView)
  {
    AppMethodBeat.i(34574);
    Object localObject = PhA;
    if ((paramView == null) || (localObject == null))
    {
      Log.w("MicroMsg.OnHoverCompatibleHelper", "view or callback is null.");
      AppMethodBeat.o(34574);
      return;
    }
    if (Build.VERSION.SDK_INT >= 14)
    {
      ah localah = ah.gOj();
      if ((Build.VERSION.SDK_INT >= 14) && (localah.PjV == null)) {
        localah.PjV = new ah.a((ah.b)localObject);
      }
      localObject = localah.PjV;
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
      if (PhA != null) {
        b.a(PhA);
      }
      AppMethodBeat.o(34575);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.ChattingItemAvatarOnHoverHelper", "exception in dismiss, %s", new Object[] { localException.getMessage() });
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
      int i = paramMotionEvent.getAction();
      if ((paramView instanceof ImageView))
      {
        paramView = ((ImageView)paramView).getDrawable();
        if (paramView != null)
        {
          if (i != 0) {
            break label59;
          }
          paramView.setColorFilter(this.mColor, PorterDuff.Mode.MULTIPLY);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(34565);
        return false;
        paramView = paramView.getBackground();
        break;
        label59:
        if ((i == 3) || (i == 1)) {
          paramView.clearColorFilter();
        }
      }
    }
  }
  
  public static final class b
    implements View.OnClickListener, View.OnTouchListener, ah.b
  {
    private int Bgx;
    private p PhB;
    private View PhC;
    private View PhD;
    private int PhE;
    private int PhF;
    private int PhG;
    private boolean PhH;
    private r.a PhI;
    private View.OnTouchListener PhJ;
    private int PhK;
    private MTimerHandler.CallBack PhL;
    private View azy;
    private MTimerHandler cve;
    private View mContentView;
    private int mMargin;
    private int mStatusBarHeight;
    
    public b()
    {
      AppMethodBeat.i(34568);
      this.PhI = new r.a();
      this.PhJ = new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(34566);
          if (r.b.b(r.b.this) != null) {
            r.b.b(r.b.this).onTouch(r.b.c(r.b.this), paramAnonymousMotionEvent);
          }
          AppMethodBeat.o(34566);
          return false;
        }
      };
      this.PhK = 300;
      this.PhL = new MTimerHandler.CallBack()
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
      if (this.PhB != null) {
        this.PhB.dismiss();
      }
      AppMethodBeat.o(34569);
    }
    
    public final boolean g(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(34570);
      Object localObject1 = paramView.getTag();
      if ((localObject1 == null) || (!(localObject1 instanceof bq)))
      {
        Log.i("MicroMsg.ChattingItemAvatarOnHoverHelper", "The Tag of the View is not a instance of ItemDataTag or is null.");
        AppMethodBeat.o(34570);
        return false;
      }
      localObject1 = (bq)paramView.getTag();
      Object localObject2 = ((bq)localObject1).userName;
      Object localObject3 = z.aTY();
      if ((Util.isNullOrNil((String)localObject3)) || (((String)localObject3).equals(localObject2))) {
        Log.v("MicroMsg.ChattingItemAvatarOnHoverHelper", "Can't talk to self and self username can't be null.");
      }
      for (int i = 0; i == 0; i = 1)
      {
        AppMethodBeat.o(34570);
        return false;
      }
      localObject2 = paramView.getContext();
      if (this.PhB == null)
      {
        localObject3 = ((Context)localObject2).getResources();
        float f = ((Resources)localObject3).getDimension(2131165523);
        this.PhE = ((int)(((Resources)localObject3).getDimension(2131165190) * 2.0F + f));
        this.mContentView = View.inflate((Context)localObject2, 2131493507, null);
        this.PhC = this.mContentView.findViewById(2131309722);
        this.PhD = this.mContentView.findViewById(2131297082);
        this.PhD.setOnClickListener(this);
        this.PhC.setOnClickListener(this);
        this.PhD.setOnTouchListener(this.PhJ);
        this.PhC.setOnTouchListener(this.PhJ);
        this.PhB = new p(this.mContentView, -2, this.PhE, false);
        this.PhB.setOutsideTouchable(true);
        localObject3 = new Rect();
        if ((localObject2 instanceof Activity)) {
          ((Activity)localObject2).getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject3);
        }
        this.mStatusBarHeight = ((Rect)localObject3).top;
        localObject3 = ((Context)localObject2).getResources().getDisplayMetrics();
        if (((DisplayMetrics)localObject3).widthPixels > ((DisplayMetrics)localObject3).heightPixels)
        {
          this.Bgx = ((Context)localObject2).getResources().getDimensionPixelSize(2131165255);
          this.PhB.setBackgroundDrawable(new ColorDrawable(16777215));
          this.mMargin = 0;
          this.cve = new MTimerHandler(Looper.getMainLooper(), this.PhL, false);
          Log.i("MicroMsg.ChattingItemAvatarOnHoverHelper", "Create a new PopupWindow.");
        }
      }
      else
      {
        localObject2 = this.PhB;
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
          this.Bgx = ((Context)localObject2).getResources().getDimensionPixelSize(2131165256);
          break;
          this.PhH = false;
          this.azy = null;
        }
        this.azy = paramView;
        paramView.setOnTouchListener(this);
        if (((p)localObject2).isShowing()) {
          ((p)localObject2).dismiss();
        }
      } while (this.PhH);
      this.PhD.setTag(localObject1);
      this.PhC.setTag(localObject1);
      this.PhD.setVisibility(0);
      this.PhC.setVisibility(8);
      paramMotionEvent = new int[2];
      paramView.getLocationInWindow(paramMotionEvent);
      i = paramMotionEvent[1];
      paramView.getWidth();
      int j = paramView.getHeight();
      this.PhG = this.mMargin;
      if (i > this.mStatusBarHeight + this.Bgx + this.PhE) {
        this.PhG = (-j - this.PhE - this.mMargin);
      }
      this.PhF = 0;
      if (this.PhG >= 0) {
        this.mContentView.setBackgroundResource(2131231723);
      }
      for (;;)
      {
        this.cve.startTimer(this.PhK);
        break;
        this.mContentView.setBackgroundResource(2131231724);
      }
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(34572);
      Object localObject = new b();
      ((b)localObject).bm(paramView);
      a.b("com/tencent/mm/ui/chatting/ChattingItemAvatarOnHoverHelper$OnHoverMotionEventCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
      localObject = (bq)paramView.getTag();
      if (paramView == this.PhD) {
        r.v(paramView.getContext(), ((bq)localObject).userName, 3);
      }
      for (;;)
      {
        dismiss();
        a.a(this, "com/tencent/mm/ui/chatting/ChattingItemAvatarOnHoverHelper$OnHoverMotionEventCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(34572);
        return;
        r.v(paramView.getContext(), ((bq)localObject).userName, 2);
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
        this.PhH = true;
        dismiss();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.r
 * JD-Core Version:    0.7.0.1
 */