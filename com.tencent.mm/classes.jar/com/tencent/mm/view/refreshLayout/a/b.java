package com.tencent.mm.view.refreshLayout.a;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/view/refreshLayout/config/CommonValue;", "", "()V", "attachedToWindow", "", "getAttachedToWindow", "()Z", "setAttachedToWindow", "(Z)V", "currentSpinner", "", "getCurrentSpinner", "()I", "setCurrentSpinner", "(I)V", "currentVelocity", "getCurrentVelocity", "setCurrentVelocity", "dragDirection", "getDragDirection", "setDragDirection", "enableDisallowIntercept", "getEnableDisallowIntercept", "setEnableDisallowIntercept", "footerLocked", "getFooterLocked", "setFooterLocked", "footerNoMoreData", "getFooterNoMoreData", "setFooterNoMoreData", "footerNoMoreDataEffective", "getFooterNoMoreDataEffective", "setFooterNoMoreDataEffective", "isBeingDragged", "setBeingDragged", "isHasPerformHapticFeedback", "setHasPerformHapticFeedback", "lastOpenTime", "", "getLastOpenTime", "()J", "setLastOpenTime", "(J)V", "lastSpinner", "getLastSpinner", "setLastSpinner", "lastTouchX", "", "getLastTouchX", "()F", "setLastTouchX", "(F)V", "lastTouchY", "getLastTouchY", "setLastTouchY", "maximumVelocity", "getMaximumVelocity", "setMaximumVelocity", "minimumVelocity", "getMinimumVelocity", "setMinimumVelocity", "screenHeightPixels", "getScreenHeightPixels", "setScreenHeightPixels", "superDispatchTouchEvent", "getSuperDispatchTouchEvent", "setSuperDispatchTouchEvent", "touchSlop", "getTouchSlop", "setTouchSlop", "touchSpinner", "getTouchSpinner", "setTouchSpinner", "touchX", "getTouchX", "setTouchX", "touchY", "getTouchY", "setTouchY", "verticalPermit", "getVerticalPermit", "setVerticalPermit", "init", "context", "Landroid/content/Context;", "Companion", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b.a agPS;
  public float Mlj;
  public float Mlk;
  public boolean agJm;
  public int agPT;
  public int agPU;
  public int agPV;
  public int agPW;
  public boolean agPX;
  public int agPY;
  public int agPZ;
  public int agQa;
  public boolean agQb;
  public boolean agQc;
  public int agQd;
  public boolean agQe;
  public long agQf;
  public boolean agQg;
  public boolean agQh;
  public boolean agQi;
  public boolean doH;
  public int doK;
  public float mkm;
  public float mkn;
  
  static
  {
    AppMethodBeat.i(235158);
    agPS = new b.a((byte)0);
    AppMethodBeat.o(235158);
  }
  
  public final b nP(Context paramContext)
  {
    AppMethodBeat.i(235170);
    s.u(paramContext, "context");
    this.agPT = paramContext.getResources().getDisplayMetrics().heightPixels;
    paramContext = ViewConfiguration.get(paramContext);
    this.doK = paramContext.getScaledTouchSlop();
    this.agPV = paramContext.getScaledMinimumFlingVelocity();
    this.agPW = paramContext.getScaledMaximumFlingVelocity();
    AppMethodBeat.o(235170);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.view.refreshLayout.a.b
 * JD-Core Version:    0.7.0.1
 */