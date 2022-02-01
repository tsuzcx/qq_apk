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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.chatting.viewitems.bi;

public final class q
{
  public static b GnO;
  
  static
  {
    AppMethodBeat.i(34577);
    GnO = new b();
    AppMethodBeat.o(34577);
  }
  
  public static void dP(View paramView)
  {
    AppMethodBeat.i(34574);
    Object localObject = GnO;
    if ((paramView == null) || (localObject == null))
    {
      ad.w("MicroMsg.OnHoverCompatibleHelper", "view or callback is null.");
      AppMethodBeat.o(34574);
      return;
    }
    if (Build.VERSION.SDK_INT >= 14)
    {
      ag localag = ag.eWa();
      if ((Build.VERSION.SDK_INT >= 14) && (localag.Gqk == null)) {
        localag.Gqk = new ag.a((ag.b)localObject);
      }
      localObject = localag.Gqk;
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
      if (GnO != null) {
        b.a(GnO);
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
    private o GnP;
    private View GnQ;
    private View GnR;
    private int GnS;
    private int GnT;
    private int GnU;
    private boolean GnV;
    private q.a GnW;
    private View.OnTouchListener GnX;
    private int GnY;
    private av.a GnZ;
    private View awP;
    private av cbR;
    private int lDk;
    private View mContentView;
    private int mMargin;
    private int uCJ;
    
    public b()
    {
      AppMethodBeat.i(34568);
      this.GnW = new q.a();
      this.GnX = new View.OnTouchListener()
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
      this.GnY = 300;
      this.GnZ = new av.a()
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
      if (this.GnP != null) {
        this.GnP.dismiss();
      }
      AppMethodBeat.o(34569);
    }
    
    public final boolean f(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(34570);
      Object localObject1 = paramView.getTag();
      if ((localObject1 == null) || (!(localObject1 instanceof bi)))
      {
        ad.i("MicroMsg.ChattingItemAvatarOnHoverHelper", "The Tag of the View is not a instance of ItemDataTag or is null.");
        AppMethodBeat.o(34570);
        return false;
      }
      localObject1 = (bi)paramView.getTag();
      Object localObject2 = ((bi)localObject1).userName;
      Object localObject3 = u.aqG();
      if ((bt.isNullOrNil((String)localObject3)) || (((String)localObject3).equals(localObject2))) {
        ad.v("MicroMsg.ChattingItemAvatarOnHoverHelper", "Can't talk to self and self username can't be null.");
      }
      for (int i = 0; i == 0; i = 1)
      {
        AppMethodBeat.o(34570);
        return false;
      }
      localObject2 = paramView.getContext();
      if (this.GnP == null)
      {
        localObject3 = ((Context)localObject2).getResources();
        float f = ((Resources)localObject3).getDimension(2131165505);
        this.GnS = ((int)(((Resources)localObject3).getDimension(2131165187) * 2.0F + f));
        this.mContentView = View.inflate((Context)localObject2, 2131493412, null);
        this.GnQ = this.mContentView.findViewById(2131306309);
        this.GnR = this.mContentView.findViewById(2131296967);
        this.GnR.setOnClickListener(this);
        this.GnQ.setOnClickListener(this);
        this.GnR.setOnTouchListener(this.GnX);
        this.GnQ.setOnTouchListener(this.GnX);
        this.GnP = new o(this.mContentView, -2, this.GnS, false);
        this.GnP.setOutsideTouchable(true);
        localObject3 = new Rect();
        if ((localObject2 instanceof Activity)) {
          ((Activity)localObject2).getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject3);
        }
        this.lDk = ((Rect)localObject3).top;
        localObject3 = ((Context)localObject2).getResources().getDisplayMetrics();
        if (((DisplayMetrics)localObject3).widthPixels > ((DisplayMetrics)localObject3).heightPixels)
        {
          this.uCJ = ((Context)localObject2).getResources().getDimensionPixelSize(2131165251);
          this.GnP.setBackgroundDrawable(new ColorDrawable(16777215));
          this.mMargin = 0;
          this.cbR = new av(Looper.getMainLooper(), this.GnZ, false);
          ad.i("MicroMsg.ChattingItemAvatarOnHoverHelper", "Create a new PopupWindow.");
        }
      }
      else
      {
        localObject2 = this.GnP;
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
          this.uCJ = ((Context)localObject2).getResources().getDimensionPixelSize(2131165252);
          break;
          this.GnV = false;
          this.awP = null;
        }
        this.awP = paramView;
        paramView.setOnTouchListener(this);
        if (((o)localObject2).isShowing()) {
          ((o)localObject2).dismiss();
        }
      } while (this.GnV);
      this.GnR.setTag(localObject1);
      this.GnQ.setTag(localObject1);
      this.GnR.setVisibility(0);
      this.GnQ.setVisibility(8);
      paramMotionEvent = new int[2];
      paramView.getLocationInWindow(paramMotionEvent);
      i = paramMotionEvent[1];
      paramView.getWidth();
      int j = paramView.getHeight();
      this.GnU = this.mMargin;
      if (i > this.lDk + this.uCJ + this.GnS) {
        this.GnU = (-j - this.GnS - this.mMargin);
      }
      this.GnT = 0;
      if (this.GnU >= 0) {
        this.mContentView.setBackgroundResource(2131231657);
      }
      for (;;)
      {
        paramView = this.cbR;
        long l = this.GnY;
        paramView.av(l, l);
        break;
        this.mContentView.setBackgroundResource(2131231658);
      }
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(34572);
      bi localbi = (bi)paramView.getTag();
      if (paramView == this.GnR) {
        q.w(paramView.getContext(), localbi.userName, 3);
      }
      for (;;)
      {
        dismiss();
        AppMethodBeat.o(34572);
        return;
        q.w(paramView.getContext(), localbi.userName, 2);
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
        this.GnV = true;
        dismiss();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.q
 * JD-Core Version:    0.7.0.1
 */