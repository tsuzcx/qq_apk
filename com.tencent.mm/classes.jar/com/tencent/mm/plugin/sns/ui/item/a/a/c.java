package com.tencent.mm.plugin.sns.ui.item.a.a;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.PointF;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.d.q;
import com.tencent.mm.plugin.sns.ad.g.l;
import com.tencent.mm.plugin.sns.ad.timeline.b.b.a.b;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.ADXml.g;
import com.tencent.mm.plugin.sns.storage.ADXml.g.a;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.aw;
import com.tencent.mm.plugin.sns.ui.widget.SnsDrawGestureView;
import com.tencent.mm.plugin.sns.ui.widget.SnsDrawGestureView.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.List;

public final class c
  extends a
{
  SnsDrawGestureView RNU;
  
  public final void a(int paramInt, SnsInfo paramSnsInfo, ADXml.g paramg, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(309082);
    super.a(paramInt, paramSnsInfo, paramg, paramLayoutParams);
    hrb();
    AppMethodBeat.o(309082);
  }
  
  public final void a(Activity paramActivity, l paraml, com.tencent.mm.plugin.sns.ui.listener.c paramc, a.b paramb, com.tencent.mm.plugin.sns.ad.timeline.b.b.a parama)
  {
    AppMethodBeat.i(309074);
    super.a(paramActivity, paraml, paramc, paramb, parama);
    if (this.RNU == null)
    {
      paramActivity = (ViewStub)paramb.Cxb.findViewById(b.f.sns_twist_ad_gesture_stub);
      if (paramActivity != null)
      {
        this.RNU = ((SnsDrawGestureView)paramActivity.inflate());
        AppMethodBeat.o(309074);
        return;
      }
      Log.e("GestureAdBusiness", "coverStub==null");
    }
    AppMethodBeat.o(309074);
  }
  
  public final void hrb()
  {
    AppMethodBeat.i(309105);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(309061);
        if (c.this.RNU == null)
        {
          AppMethodBeat.o(309061);
          return;
        }
        c.this.RNU.setVisibility(8);
        c.this.RNU.setBackgroundColor(0);
        c.this.RNU.hsW();
        c.this.RNU.setOnGestureListener(null);
        AppMethodBeat.o(309061);
      }
    });
    AppMethodBeat.o(309105);
  }
  
  public final void vA(long paramLong)
  {
    AppMethodBeat.i(309097);
    final a.b localb = this.RIM;
    Object localObject = this.QbN;
    final SnsInfo localSnsInfo = this.PJQ;
    int i = (int)paramLong;
    if (localObject == null) {
      localObject = null;
    }
    while ((localObject != null) && (((ADXml.g.a)localObject).startTime >= 0L) && (((ADXml.g.a)localObject).endTime > ((ADXml.g.a)localObject).startTime))
    {
      Log.i("GestureAdBusiness", "%d-%d,%d", new Object[] { Long.valueOf(((ADXml.g.a)localObject).startTime), Long.valueOf(((ADXml.g.a)localObject).endTime), Integer.valueOf(i) });
      if ((((ADXml.g.a)localObject).startTime <= i) && (((ADXml.g.a)localObject).endTime >= i))
      {
        if ((this.RNU != null) && (this.RNU.getOnGestureListener() == null))
        {
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(309062);
              if ((c.this.RNU == null) || (localSnsInfo == null))
              {
                AppMethodBeat.o(309062);
                return;
              }
              c.this.RNU.setVisibility(0);
              c.this.RNU.hsW();
              c.this.RNU.setPaintColor(this.RNV.color);
              c.this.RNU.setOnGestureListener(new SnsDrawGestureView.a()
              {
                public final void hrc()
                {
                  AppMethodBeat.i(309054);
                  t.DC(false);
                  c.this.RNU.setBackgroundColor(c.this.mActivity.getResources().getColor(b.c.sns_ad_gesture_bg_color));
                  AppMethodBeat.o(309054);
                }
                
                public final void kS(List<PointF> paramAnonymous2List)
                {
                  int i = 1;
                  AppMethodBeat.i(309058);
                  t.DC(true);
                  c.this.RNU.setBackgroundColor(0);
                  if (paramAnonymous2List.size() > 0) {
                    try
                    {
                      if (c.this.xOq == 0) {}
                      for (;;)
                      {
                        boolean bool = q.a(c.1.this.PNW, paramAnonymous2List, c.1.this.RNV, i);
                        Log.i("GestureAdBusiness", "confirmOpenGestureLandingPage=" + bool + ", scene=" + i);
                        if (bool)
                        {
                          c.this.be(null);
                          t.g(new long[] { 20L, 100L });
                          c.this.hra();
                          c.this.amt(25);
                        }
                        return;
                        i = 2;
                      }
                      AppMethodBeat.o(309058);
                    }
                    catch (Exception paramAnonymous2List)
                    {
                      Log.printErrStackTrace("GestureAdBusiness", paramAnonymous2List, "recog gesture error!", new Object[0]);
                      return;
                    }
                    finally
                    {
                      c.this.RNU.hsW();
                      AppMethodBeat.o(309058);
                    }
                  }
                }
                
                public final void onClick()
                {
                  AppMethodBeat.i(309065);
                  t.DC(true);
                  c.this.RNU.setBackgroundColor(0);
                  c.1.this.RIJ.Qcj.RjL.performClick();
                  AppMethodBeat.o(309065);
                }
              });
              AppMethodBeat.o(309062);
            }
          });
          AppMethodBeat.o(309097);
          return;
          localObject = ((ADXml.g)localObject).QHH;
        }
      }
      else {
        hrb();
      }
    }
    AppMethodBeat.o(309097);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.a.a.c
 * JD-Core Version:    0.7.0.1
 */