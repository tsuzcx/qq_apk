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
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.v;
import com.tencent.mm.ui.chatting.viewitems.bz;

public final class t
{
  private static int aeiw;
  public static b aeix;
  
  static
  {
    AppMethodBeat.i(34577);
    aeiw = -1;
    aeix = new b();
    AppMethodBeat.o(34577);
  }
  
  public static void dismiss()
  {
    AppMethodBeat.i(34575);
    try
    {
      if (aeix != null) {
        b.a(aeix);
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
  
  public static void fj(View paramView)
  {
    AppMethodBeat.i(34574);
    Object localObject = aeix;
    if ((paramView == null) || (localObject == null))
    {
      Log.w("MicroMsg.OnHoverCompatibleHelper", "view or callback is null.");
      AppMethodBeat.o(34574);
      return;
    }
    if (Build.VERSION.SDK_INT >= 14)
    {
      ak localak = ak.jpZ();
      if ((Build.VERSION.SDK_INT >= 14) && (localak.aeld == null)) {
        localak.aeld = new ak.a((ak.b)localObject);
      }
      localObject = localak.aeld;
      if ((localObject != null) && (Build.VERSION.SDK_INT >= 14) && ((localObject instanceof View.OnHoverListener))) {
        paramView.setOnHoverListener((View.OnHoverListener)localObject);
      }
    }
    AppMethodBeat.o(34574);
  }
  
  public static boolean isEnable()
  {
    AppMethodBeat.i(253938);
    if (aeiw == -1)
    {
      aeiw = ((c)h.ax(c.class)).a(c.a.zvT, 0);
      Log.i("MicroMsg.ChattingItemAvatarOnHoverHelper", "isEnable:%s", new Object[] { Integer.valueOf(aeiw) });
    }
    if (aeiw == 1)
    {
      AppMethodBeat.o(253938);
      return true;
    }
    AppMethodBeat.o(253938);
    return false;
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
    implements View.OnClickListener, View.OnTouchListener, ak.b
  {
    private int MYk;
    private View aeiA;
    private int aeiB;
    private int aeiC;
    private int aeiD;
    private boolean aeiE;
    private t.a aeiF;
    private View.OnTouchListener aeiG;
    private int aeiH;
    private MTimerHandler.CallBack aeiI;
    private v aeiy;
    private View aeiz;
    private int bhE;
    private MTimerHandler eln;
    private View mContentView;
    private int mStatusBarHeight;
    private View yw;
    
    public b()
    {
      AppMethodBeat.i(34568);
      this.aeiF = new t.a();
      this.aeiG = new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(34566);
          if (t.b.b(t.b.this) != null) {
            t.b.b(t.b.this).onTouch(t.b.c(t.b.this), paramAnonymousMotionEvent);
          }
          AppMethodBeat.o(34566);
          return false;
        }
      };
      this.aeiH = 300;
      this.aeiI = new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(34567);
          if ((t.b.d(t.b.this) != null) && (t.b.e(t.b.this) != null)) {
            t.b.e(t.b.this).showAsDropDown(t.b.d(t.b.this), t.b.f(t.b.this), t.b.g(t.b.this));
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
      if (this.aeiy != null) {
        this.aeiy.dismiss();
      }
      AppMethodBeat.o(34569);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(34572);
      Object localObject = new b();
      ((b)localObject).cH(paramView);
      a.c("com/tencent/mm/ui/chatting/ChattingItemAvatarOnHoverHelper$OnHoverMotionEventCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
      localObject = (bz)paramView.getTag();
      if (paramView == this.aeiA) {
        t.z(paramView.getContext(), ((bz)localObject).userName, 3);
      }
      for (;;)
      {
        dismiss();
        a.a(this, "com/tencent/mm/ui/chatting/ChattingItemAvatarOnHoverHelper$OnHoverMotionEventCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(34572);
        return;
        t.z(paramView.getContext(), ((bz)localObject).userName, 2);
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
        this.aeiE = true;
        dismiss();
      }
    }
    
    public final boolean p(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(34570);
      Object localObject1 = paramView.getTag();
      if ((localObject1 == null) || (!(localObject1 instanceof bz)))
      {
        Log.i("MicroMsg.ChattingItemAvatarOnHoverHelper", "The Tag of the View is not a instance of ItemDataTag or is null.");
        AppMethodBeat.o(34570);
        return false;
      }
      localObject1 = (bz)paramView.getTag();
      Object localObject2 = ((bz)localObject1).userName;
      Object localObject3 = z.bAM();
      if ((Util.isNullOrNil((String)localObject3)) || (((String)localObject3).equals(localObject2))) {
        Log.v("MicroMsg.ChattingItemAvatarOnHoverHelper", "Can't talk to self and self username can't be null.");
      }
      for (int i = 0; i == 0; i = 1)
      {
        AppMethodBeat.o(34570);
        return false;
      }
      localObject2 = paramView.getContext();
      if (this.aeiy == null)
      {
        localObject3 = ((Context)localObject2).getResources();
        float f = ((Resources)localObject3).getDimension(R.f.MiniAvatarSize);
        this.aeiB = ((int)(((Resources)localObject3).getDimension(R.f.BasicPaddingSize) * 2.0F + f));
        this.mContentView = View.inflate((Context)localObject2, R.i.gfj, null);
        this.aeiz = this.mContentView.findViewById(R.h.video);
        this.aeiA = this.mContentView.findViewById(R.h.fsp);
        this.aeiA.setOnClickListener(this);
        this.aeiz.setOnClickListener(this);
        this.aeiA.setOnTouchListener(this.aeiG);
        this.aeiz.setOnTouchListener(this.aeiG);
        this.aeiy = new v(this.mContentView, -2, this.aeiB, false);
        this.aeiy.setOutsideTouchable(true);
        localObject3 = new Rect();
        if ((localObject2 instanceof Activity)) {
          ((Activity)localObject2).getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject3);
        }
        this.mStatusBarHeight = ((Rect)localObject3).top;
        localObject3 = ((Context)localObject2).getResources().getDisplayMetrics();
        if (((DisplayMetrics)localObject3).widthPixels > ((DisplayMetrics)localObject3).heightPixels)
        {
          this.MYk = ((Context)localObject2).getResources().getDimensionPixelSize(R.f.DefaultActionbarHeightLand);
          this.aeiy.setBackgroundDrawable(new ColorDrawable(16777215));
          this.bhE = 0;
          this.eln = new MTimerHandler(Looper.getMainLooper(), this.aeiI, false);
          Log.i("MicroMsg.ChattingItemAvatarOnHoverHelper", "Create a new PopupWindow.");
        }
      }
      else
      {
        localObject2 = this.aeiy;
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
          this.MYk = ((Context)localObject2).getResources().getDimensionPixelSize(R.f.DefaultActionbarHeightPort);
          break;
          this.aeiE = false;
          this.yw = null;
        }
        this.yw = paramView;
        paramView.setOnTouchListener(this);
        if (((v)localObject2).isShowing()) {
          ((v)localObject2).dismiss();
        }
      } while (this.aeiE);
      this.aeiA.setTag(localObject1);
      this.aeiz.setTag(localObject1);
      this.aeiA.setVisibility(0);
      this.aeiz.setVisibility(8);
      paramMotionEvent = new int[2];
      paramView.getLocationInWindow(paramMotionEvent);
      i = paramMotionEvent[1];
      paramView.getWidth();
      int j = paramView.getHeight();
      this.aeiD = this.bhE;
      if (i > this.mStatusBarHeight + this.MYk + this.aeiB) {
        this.aeiD = (-j - this.aeiB - this.bhE);
      }
      this.aeiC = 0;
      if (this.aeiD >= 0) {
        this.mContentView.setBackgroundResource(R.g.fng);
      }
      for (;;)
      {
        this.eln.startTimer(this.aeiH);
        break;
        this.mContentView.setBackgroundResource(R.g.fnh);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.t
 * JD-Core Version:    0.7.0.1
 */