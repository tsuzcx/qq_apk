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
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.chatting.viewitems.by;

public final class r
{
  private static int WBc;
  public static b WBd;
  
  static
  {
    AppMethodBeat.i(34577);
    WBc = -1;
    WBd = new b();
    AppMethodBeat.o(34577);
  }
  
  public static void dismiss()
  {
    AppMethodBeat.i(34575);
    try
    {
      if (WBd != null) {
        b.a(WBd);
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
  
  public static void eo(View paramView)
  {
    AppMethodBeat.i(34574);
    Object localObject = WBd;
    if ((paramView == null) || (localObject == null))
    {
      Log.w("MicroMsg.OnHoverCompatibleHelper", "view or callback is null.");
      AppMethodBeat.o(34574);
      return;
    }
    if (Build.VERSION.SDK_INT >= 14)
    {
      ah localah = ah.hNt();
      if ((Build.VERSION.SDK_INT >= 14) && (localah.WDC == null)) {
        localah.WDC = new ah.a((ah.b)localObject);
      }
      localObject = localah.WDC;
      if ((localObject != null) && (Build.VERSION.SDK_INT >= 14) && ((localObject instanceof View.OnHoverListener))) {
        paramView.setOnHoverListener((View.OnHoverListener)localObject);
      }
    }
    AppMethodBeat.o(34574);
  }
  
  public static boolean isEnable()
  {
    AppMethodBeat.i(273038);
    if (WBc == -1)
    {
      WBc = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.wcm, 0);
      Log.i("MicroMsg.ChattingItemAvatarOnHoverHelper", "isEnable:%s", new Object[] { Integer.valueOf(WBc) });
    }
    if (WBc == 1)
    {
      AppMethodBeat.o(273038);
      return true;
    }
    AppMethodBeat.o(273038);
    return false;
  }
  
  public static final class b
    implements View.OnClickListener, View.OnTouchListener, ah.b
  {
    private int Bw;
    private int Haf;
    private com.tencent.mm.ui.base.r WBe;
    private View WBf;
    private View WBg;
    private int WBh;
    private int WBi;
    private int WBj;
    private boolean WBk;
    private r.a WBl;
    private View.OnTouchListener WBm;
    private int WBn;
    private MTimerHandler.CallBack WBo;
    private MTimerHandler cts;
    private View mContentView;
    private int mStatusBarHeight;
    private View xB;
    
    public b()
    {
      AppMethodBeat.i(34568);
      this.WBl = new r.a();
      this.WBm = new View.OnTouchListener()
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
      this.WBn = 300;
      this.WBo = new MTimerHandler.CallBack()
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
      if (this.WBe != null) {
        this.WBe.dismiss();
      }
      AppMethodBeat.o(34569);
    }
    
    public final boolean h(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(34570);
      Object localObject1 = paramView.getTag();
      if ((localObject1 == null) || (!(localObject1 instanceof by)))
      {
        Log.i("MicroMsg.ChattingItemAvatarOnHoverHelper", "The Tag of the View is not a instance of ItemDataTag or is null.");
        AppMethodBeat.o(34570);
        return false;
      }
      localObject1 = (by)paramView.getTag();
      Object localObject2 = ((by)localObject1).userName;
      Object localObject3 = z.bcZ();
      if ((Util.isNullOrNil((String)localObject3)) || (((String)localObject3).equals(localObject2))) {
        Log.v("MicroMsg.ChattingItemAvatarOnHoverHelper", "Can't talk to self and self username can't be null.");
      }
      for (int i = 0; i == 0; i = 1)
      {
        AppMethodBeat.o(34570);
        return false;
      }
      localObject2 = paramView.getContext();
      if (this.WBe == null)
      {
        localObject3 = ((Context)localObject2).getResources();
        float f = ((Resources)localObject3).getDimension(R.f.MiniAvatarSize);
        this.WBh = ((int)(((Resources)localObject3).getDimension(R.f.BasicPaddingSize) * 2.0F + f));
        this.mContentView = View.inflate((Context)localObject2, R.i.ecx, null);
        this.WBf = this.mContentView.findViewById(R.h.video);
        this.WBg = this.mContentView.findViewById(R.h.drZ);
        this.WBg.setOnClickListener(this);
        this.WBf.setOnClickListener(this);
        this.WBg.setOnTouchListener(this.WBm);
        this.WBf.setOnTouchListener(this.WBm);
        this.WBe = new com.tencent.mm.ui.base.r(this.mContentView, -2, this.WBh, false);
        this.WBe.setOutsideTouchable(true);
        localObject3 = new Rect();
        if ((localObject2 instanceof Activity)) {
          ((Activity)localObject2).getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject3);
        }
        this.mStatusBarHeight = ((Rect)localObject3).top;
        localObject3 = ((Context)localObject2).getResources().getDisplayMetrics();
        if (((DisplayMetrics)localObject3).widthPixels > ((DisplayMetrics)localObject3).heightPixels)
        {
          this.Haf = ((Context)localObject2).getResources().getDimensionPixelSize(R.f.DefaultActionbarHeightLand);
          this.WBe.setBackgroundDrawable(new ColorDrawable(16777215));
          this.Bw = 0;
          this.cts = new MTimerHandler(Looper.getMainLooper(), this.WBo, false);
          Log.i("MicroMsg.ChattingItemAvatarOnHoverHelper", "Create a new PopupWindow.");
        }
      }
      else
      {
        localObject2 = this.WBe;
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
          this.Haf = ((Context)localObject2).getResources().getDimensionPixelSize(R.f.DefaultActionbarHeightPort);
          break;
          this.WBk = false;
          this.xB = null;
        }
        this.xB = paramView;
        paramView.setOnTouchListener(this);
        if (((com.tencent.mm.ui.base.r)localObject2).isShowing()) {
          ((com.tencent.mm.ui.base.r)localObject2).dismiss();
        }
      } while (this.WBk);
      this.WBg.setTag(localObject1);
      this.WBf.setTag(localObject1);
      this.WBg.setVisibility(0);
      this.WBf.setVisibility(8);
      paramMotionEvent = new int[2];
      paramView.getLocationInWindow(paramMotionEvent);
      i = paramMotionEvent[1];
      paramView.getWidth();
      int j = paramView.getHeight();
      this.WBj = this.Bw;
      if (i > this.mStatusBarHeight + this.Haf + this.WBh) {
        this.WBj = (-j - this.WBh - this.Bw);
      }
      this.WBi = 0;
      if (this.WBj >= 0) {
        this.mContentView.setBackgroundResource(R.g.dmU);
      }
      for (;;)
      {
        this.cts.startTimer(this.WBn);
        break;
        this.mContentView.setBackgroundResource(R.g.dmV);
      }
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(34572);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      a.c("com/tencent/mm/ui/chatting/ChattingItemAvatarOnHoverHelper$OnHoverMotionEventCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      localObject = (by)paramView.getTag();
      if (paramView == this.WBg) {
        r.x(paramView.getContext(), ((by)localObject).userName, 3);
      }
      for (;;)
      {
        dismiss();
        a.a(this, "com/tencent/mm/ui/chatting/ChattingItemAvatarOnHoverHelper$OnHoverMotionEventCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(34572);
        return;
        r.x(paramView.getContext(), ((by)localObject).userName, 2);
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
        this.WBk = true;
        dismiss();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.r
 * JD-Core Version:    0.7.0.1
 */