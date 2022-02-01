package com.tencent.mm.plugin.sns.ui.item.a;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.PointF;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.ad.d.n;
import com.tencent.mm.plugin.sns.ad.timeline.c.b.a.b;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.storage.ADXml.g;
import com.tencent.mm.plugin.sns.storage.ADXml.g.a;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.SnsTimeLineUI;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.bm;
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.plugin.sns.ui.i;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.item.f;
import com.tencent.mm.plugin.sns.ui.item.h;
import com.tencent.mm.plugin.sns.ui.item.h.a;
import com.tencent.mm.plugin.sns.ui.widget.SnsDrawGestureView;
import com.tencent.mm.plugin.sns.ui.widget.SnsDrawGestureView.a;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.List;

public final class a
  extends h
{
  private void a(final h.a parama)
  {
    AppMethodBeat.i(266363);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(267416);
        if (a.g(a.this).Lnh.JKz == null)
        {
          AppMethodBeat.o(267416);
          return;
        }
        parama.Lnh.JKz.setVisibility(8);
        parama.Lnh.JKz.setBackgroundColor(0);
        parama.Lnh.JKz.fZF();
        parama.Lnh.JKz.setOnGestureListener(null);
        AppMethodBeat.o(267416);
      }
    });
    AppMethodBeat.o(266363);
  }
  
  public final void a(long paramLong1, final ADXml.g paramg, final SnsInfo paramSnsInfo, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(266360);
    super.a(paramLong1, paramg, paramSnsInfo, paramLong2, paramInt);
    final h.a locala = this.Lna;
    paramInt = (int)paramLong2;
    if (paramg == null) {
      paramg = null;
    }
    while ((paramg != null) && (paramg.startTime >= 0L) && (paramg.endTime > paramg.startTime))
    {
      Log.i("MicroMsg.FullCardAdTimeLineItemNew.Gesture", "%d-%d,%d", new Object[] { Long.valueOf(paramg.startTime), Long.valueOf(paramg.endTime), Integer.valueOf(paramInt) });
      if ((paramg.startTime <= paramInt) && (paramg.endTime >= paramInt))
      {
        if ((this.Lna.Lnh.JKz != null) && (locala.Lnh.JKz.getOnGestureListener() == null))
        {
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(237931);
              if (a.a(a.this).Lnh.JKz == null)
              {
                AppMethodBeat.o(237931);
                return;
              }
              locala.Lnh.JKz.setVisibility(0);
              locala.Lnh.JKz.fZF();
              locala.Lnh.JKz.setPaintColor(paramg.color);
              locala.Lnh.JKz.setOnGestureListener(new SnsDrawGestureView.a()
              {
                public final void fYw()
                {
                  AppMethodBeat.i(223857);
                  t.yu(false);
                  a.1.this.Lng.Lnh.JKz.setBackgroundColor(a.b(a.this).getResources().getColor(i.c.sns_ad_gesture_bg_color));
                  AppMethodBeat.o(223857);
                }
                
                public final void hR(List<PointF> paramAnonymous2List)
                {
                  AppMethodBeat.i(223869);
                  t.yu(true);
                  a.1.this.Lng.Lnh.JKz.setBackgroundColor(0);
                  if (paramAnonymous2List.size() > 0) {
                    try
                    {
                      boolean bool = n.a(a.1.this.JHl, paramAnonymous2List, a.1.this.LjK, 1);
                      Log.i("MicroMsg.FullCardAdTimeLineItemNew.Gesture", "confirmOpenGestureLandingPage is ".concat(String.valueOf(bool)));
                      if (bool)
                      {
                        a.c(a.this).KYo.KCe.a(a.1.this.Lng, null);
                        t.e(new long[] { 20L, 100L });
                        f.a(a.d(a.this), a.1.this.Lng.Lnh.xYJ, a.1.this.JHl, 1);
                        paramAnonymous2List = new SnsAdClick(1, 1, t.aZs(a.1.this.JHl.getTimeLine().Id), 25, 21);
                        if ((a.e(a.this) instanceof SnsTimeLineUI)) {
                          m.a(paramAnonymous2List, ((SnsTimeLineUI)a.f(a.this)).fXs(), a.1.this.JHl, 25);
                        }
                        t.a(paramAnonymous2List);
                      }
                      return;
                    }
                    catch (Exception paramAnonymous2List)
                    {
                      Log.printErrStackTrace("MicroMsg.FullCardAdTimeLineItemNew.Gesture", paramAnonymous2List, "recog gesture error!", new Object[0]);
                      return;
                    }
                    finally
                    {
                      a.1.this.Lng.Lnh.JKz.fZF();
                      AppMethodBeat.o(223869);
                    }
                  }
                  AppMethodBeat.o(223869);
                }
                
                public final void onClick()
                {
                  AppMethodBeat.i(223874);
                  t.yu(true);
                  a.1.this.Lng.Lnh.JKz.setBackgroundColor(0);
                  a.1.this.Lng.JKG.KKj.performClick();
                  AppMethodBeat.o(223874);
                }
              });
              AppMethodBeat.o(237931);
            }
          });
          AppMethodBeat.o(266360);
          return;
          paramg = paramg.KjK;
        }
      }
      else {
        a(locala);
      }
    }
    AppMethodBeat.o(266360);
  }
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt, TimeLineObject paramTimeLineObject, ADXml.g paramg, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(266359);
    super.a(paramBaseViewHolder, paramInt, paramTimeLineObject, paramg, paramLayoutParams);
    a(this.Lna);
    AppMethodBeat.o(266359);
  }
  
  public final void b(ViewStub paramViewStub, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(266357);
    super.b(paramViewStub, paramBaseViewHolder);
    if (this.Lna.Lnh.JKz == null)
    {
      paramViewStub = (ViewStub)this.Lna.Lnh.xYJ.findViewById(i.f.sns_twist_ad_gesture_stub);
      if (paramViewStub != null)
      {
        this.Lna.Lnh.JKz = ((SnsDrawGestureView)paramViewStub.inflate());
        AppMethodBeat.o(266357);
        return;
      }
      Log.e("MicroMsg.FullCardAdTimeLineItemNew.Gesture", "coverStub==null");
    }
    AppMethodBeat.o(266357);
  }
  
  public final void fYB()
  {
    AppMethodBeat.i(266361);
    super.fYB();
    a(this.Lna);
    AppMethodBeat.o(266361);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.a.a
 * JD-Core Version:    0.7.0.1
 */