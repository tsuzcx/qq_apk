package com.tencent.mm.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.api.LiveConfig.a;
import com.tencent.mm.live.b.c.b;
import com.tencent.mm.live.d.f;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.LinkedList;

public class LiveTalkRoomTipsBar
  extends LinearLayout
{
  private WeImageView HmA;
  public ListView HmB;
  private View HmC;
  private com.tencent.mm.ui.chatting.d.a HmD;
  private boolean HmE;
  public p Hms;
  private RelativeLayout Hmt;
  private RelativeLayout Hmu;
  private RelativeLayout Hmv;
  private FrameLayout Hmw;
  private TextView Hmx;
  private TextView Hmy;
  private WeImageView Hmz;
  public Context context;
  private RelativeLayout gzJ;
  private View nzT;
  
  public LiveTalkRoomTipsBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(196288);
    this.context = paramContext;
    initView();
    AppMethodBeat.o(196288);
  }
  
  @TargetApi(11)
  public LiveTalkRoomTipsBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(196287);
    this.context = paramContext;
    initView();
    AppMethodBeat.o(196287);
  }
  
  private void Zu(int paramInt)
  {
    AppMethodBeat.i(196293);
    int i = com.tencent.mm.cc.a.au(this.context, 2131165303);
    Object localObject = new DisplayMetrics();
    ((Activity)this.context).getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    int j = (((DisplayMetrics)localObject).heightPixels - i * 21) / 2;
    paramInt = (paramInt + 1) * 8 * i;
    localObject = this.HmB.getLayoutParams();
    if (paramInt > j) {}
    for (((ViewGroup.LayoutParams)localObject).height = j;; ((ViewGroup.LayoutParams)localObject).height = paramInt)
    {
      this.HmB.setLayoutParams((ViewGroup.LayoutParams)localObject);
      ViewGroup.LayoutParams localLayoutParams = this.Hmu.getLayoutParams();
      paramInt = ((ViewGroup.LayoutParams)localObject).height;
      localLayoutParams.height = ((int)(4.5D * i) + paramInt);
      this.Hmu.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(196293);
      return;
    }
  }
  
  private void fgA()
  {
    AppMethodBeat.i(196294);
    this.Hmu.setVisibility(8);
    setVisibility(8);
    setRootTipsBarBackground(false);
    AppMethodBeat.o(196294);
  }
  
  private void initView()
  {
    AppMethodBeat.i(196289);
    inflate(getContext(), 2131496341, this);
    this.gzJ = ((RelativeLayout)findViewById(2131304246));
    this.gzJ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView) {}
    });
    this.Hmt = ((RelativeLayout)findViewById(2131307794));
    this.Hmz = ((WeImageView)findViewById(2131307793));
    this.Hmz.setIconColor(0);
    this.Hmx = ((TextView)findViewById(2131307799));
    this.Hmv = ((RelativeLayout)findViewById(2131307791));
    this.Hmu = ((RelativeLayout)findViewById(2131307800));
    this.Hmw = ((FrameLayout)findViewById(2131307801));
    this.Hmy = ((TextView)findViewById(2131307798));
    this.HmB = ((ListView)findViewById(2131307796));
    this.nzT = z.jD(this.context).inflate(2131496342, null);
    this.HmB.addFooterView(this.nzT);
    this.HmA = ((WeImageView)findViewById(2131307795));
    setTipsBarLayout(true);
    this.Hmt.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(196282);
        if (LiveTalkRoomTipsBar.a(LiveTalkRoomTipsBar.this).HmJ != null)
        {
          int i = LiveTalkRoomTipsBar.a(LiveTalkRoomTipsBar.this).HmJ.getCount();
          if (i <= 0)
          {
            ac.e("MicroMsg.LiveTalkRoomTipsBar", "click liveTipsBarLayout error, count:%d", new Object[] { Integer.valueOf(i) });
            AppMethodBeat.o(196282);
            return;
          }
          boolean bool1 = ((com.tencent.mm.live.a)g.ad(com.tencent.mm.live.a.class)).isAnchorLiving();
          boolean bool2 = ((com.tencent.mm.live.a)g.ad(com.tencent.mm.live.a.class)).isVisitorLiving();
          ac.i("MicroMsg.LiveTalkRoomTipsBar", "click liveTipsBarLayout, isAnchorLiving:%b, isVisitorLiving:%b, count:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Integer.valueOf(i) });
          if ((i == 1) && (((!bool1) && (!bool2)) || ((LiveTalkRoomTipsBar.a(LiveTalkRoomTipsBar.this) != null) && (!LiveTalkRoomTipsBar.a(LiveTalkRoomTipsBar.this).aPx(((com.tencent.mm.live.a)g.ad(com.tencent.mm.live.a.class)).getLivingRoomId())))))
          {
            paramAnonymousView = LiveTalkRoomTipsBar.a(LiveTalkRoomTipsBar.this).HmJ.Zv(0);
            if (paramAnonymousView == null)
            {
              ac.e("MicroMsg.LiveTalkRoomTipsBar", "count 1, but liveTipsBar null.");
              AppMethodBeat.o(196282);
              return;
            }
            LiveTalkRoomTipsBar.this.b(paramAnonymousView);
            AppMethodBeat.o(196282);
            return;
          }
          if (LiveTalkRoomTipsBar.b(LiveTalkRoomTipsBar.this).getVisibility() == 8)
          {
            LiveTalkRoomTipsBar.a(LiveTalkRoomTipsBar.this, false);
            AppMethodBeat.o(196282);
            return;
          }
          LiveTalkRoomTipsBar.a(LiveTalkRoomTipsBar.this, true);
        }
        AppMethodBeat.o(196282);
      }
    });
    this.Hmv.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(196283);
        if (LiveTalkRoomTipsBar.a(LiveTalkRoomTipsBar.this) != null)
        {
          LiveTalkRoomTipsBar.a(LiveTalkRoomTipsBar.this);
          p.aPy(LiveTalkRoomTipsBar.c(LiveTalkRoomTipsBar.this).getTalkerUserName());
        }
        AppMethodBeat.o(196283);
      }
    });
    this.HmA.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(196284);
        LiveTalkRoomTipsBar.a(LiveTalkRoomTipsBar.this, true);
        AppMethodBeat.o(196284);
      }
    });
    AppMethodBeat.o(196289);
  }
  
  public final void b(b paramb)
  {
    AppMethodBeat.i(196291);
    Object localObject = new LiveConfig.a();
    if ((((com.tencent.mm.live.a)g.ad(com.tencent.mm.live.a.class)).isAnchorLiving()) || (((com.tencent.mm.live.a)g.ad(com.tencent.mm.live.a.class)).isVisitorLiving()) || ((!com.tencent.mm.r.a.cg(this.context)) && (!com.tencent.mm.r.a.ci(this.context)) && (!com.tencent.mm.r.a.cf(this.context)) && (!com.tencent.mm.r.a.ck(this.context))))
    {
      if (paramb.field_isSender) {}
      for (int i = LiveConfig.gmI;; i = LiveConfig.gmJ)
      {
        ((LiveConfig.a)localObject).gmO = i;
        ((LiveConfig.a)localObject).thumbUrl = paramb.field_thumbUrl;
        ((LiveConfig.a)localObject).gmQ = paramb.field_hostRoomId;
        ((LiveConfig.a)localObject).gmP = paramb.field_liveId;
        ((LiveConfig.a)localObject).gmR = paramb.field_liveName;
        ((LiveConfig.a)localObject).fromScene = LiveConfig.gmL;
        ((LiveConfig.a)localObject).gmT = paramb.field_anchorUsername;
        localObject = ((LiveConfig.a)localObject).aip();
        if (!paramb.field_isSender) {
          break;
        }
        ((com.tencent.mm.live.a)g.ad(com.tencent.mm.live.a.class)).liveEntranceJumper().c(this.context, (LiveConfig)localObject);
        AppMethodBeat.o(196291);
        return;
      }
      f.anm();
      ((com.tencent.mm.live.a)g.ad(com.tencent.mm.live.a.class)).liveEntranceJumper().b(this.context, (LiveConfig)localObject);
    }
    AppMethodBeat.o(196291);
  }
  
  public final void fgz()
  {
    AppMethodBeat.i(196292);
    if (!this.HmE)
    {
      fgA();
      AppMethodBeat.o(196292);
      return;
    }
    LinkedList localLinkedList;
    Object localObject;
    if (this.Hms != null)
    {
      localLinkedList = this.Hms.fgB();
      if ((localLinkedList == null) || (localLinkedList.size() <= 0))
      {
        if (localLinkedList == null) {}
        for (localObject = "null";; localObject = "0")
        {
          ac.e("MicroMsg.LiveTalkRoomTipsBar", "showLiveTipsBar List error:%s", new Object[] { localObject });
          fgA();
          AppMethodBeat.o(196292);
          return;
        }
      }
      boolean bool1 = ((com.tencent.mm.live.a)g.ad(com.tencent.mm.live.a.class)).isAnchorLiving();
      boolean bool2 = ((com.tencent.mm.live.a)g.ad(com.tencent.mm.live.a.class)).isVisitorLiving();
      if (localLinkedList != null) {
        break label283;
      }
      localObject = "null";
      ac.i("MicroMsg.LiveTalkRoomTipsBar", "showLiveTipsBar List size:%s, isAnchorLiving:%b, isVisitorLiving:%b", new Object[] { localObject, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if (((!bool1) && (!bool2)) || (this.Hms == null) || (!this.Hms.aPx(((com.tencent.mm.live.a)g.ad(com.tencent.mm.live.a.class)).getLivingRoomId()))) {
        break label306;
      }
      localObject = this.context.getString(2131766728, new Object[] { Integer.valueOf(localLinkedList.size()) });
      if (this.Hmu.getVisibility() != 0) {
        break label295;
      }
      this.Hmy.setText((CharSequence)localObject);
      Zu(localLinkedList.size());
      setRootTipsBarBackground(true);
      this.Hms.HmJ.notifyDataSetChanged();
    }
    for (;;)
    {
      setVisibility(0);
      AppMethodBeat.o(196292);
      return;
      label283:
      localObject = Integer.valueOf(localLinkedList.size());
      break;
      label295:
      this.Hmx.setText((CharSequence)localObject);
      continue;
      label306:
      if (localLinkedList.size() == 1)
      {
        localObject = (b)localLinkedList.get(0);
        localObject = this.context.getString(2131766727, new Object[] { ((b)localObject).field_liveName });
        this.Hmx.setText(k.c(this.context, (CharSequence)localObject));
        this.Hmt.setVisibility(0);
        this.Hmu.setVisibility(8);
        setRootTipsBarBackground(false);
      }
      else
      {
        localObject = this.context.getString(2131766729, new Object[] { Integer.valueOf(localLinkedList.size()) });
        if (this.Hmu.getVisibility() == 0)
        {
          this.Hmy.setText((CharSequence)localObject);
          Zu(localLinkedList.size());
          setRootTipsBarBackground(true);
          this.Hms.HmJ.notifyDataSetChanged();
        }
        else
        {
          this.Hmx.setText((CharSequence)localObject);
        }
      }
    }
  }
  
  public void setChattingContext(com.tencent.mm.ui.chatting.d.a parama)
  {
    this.HmD = parama;
  }
  
  public void setChattingUserName(String paramString)
  {
    if (this.Hms != null) {
      this.Hms.gmQ = paramString;
    }
  }
  
  public void setInChatRoom(boolean paramBoolean)
  {
    this.HmE = paramBoolean;
  }
  
  public void setRootTipsBarBackground(View paramView)
  {
    this.HmC = paramView;
  }
  
  public void setRootTipsBarBackground(boolean paramBoolean)
  {
    AppMethodBeat.i(196295);
    if (this.HmC != null)
    {
      if (paramBoolean)
      {
        this.HmC.setVisibility(0);
        this.HmC.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(196286);
            LiveTalkRoomTipsBar.a(LiveTalkRoomTipsBar.this, true);
            AppMethodBeat.o(196286);
          }
        });
        AppMethodBeat.o(196295);
        return;
      }
      this.HmC.setVisibility(8);
    }
    AppMethodBeat.o(196295);
  }
  
  public void setTipsBarLayout(boolean paramBoolean)
  {
    AppMethodBeat.i(196290);
    if (paramBoolean)
    {
      this.Hmt.setVisibility(0);
      this.Hmu.setVisibility(8);
      setRootTipsBarBackground(false);
      fgz();
      AppMethodBeat.o(196290);
      return;
    }
    this.Hmt.setVisibility(8);
    this.Hmu.setVisibility(0);
    setRootTipsBarBackground(true);
    fgz();
    if (this.HmD != null) {
      this.HmD.hideVKB();
    }
    int i = com.tencent.mm.cc.a.au(this.context, 2131165303);
    final ViewGroup.LayoutParams localLayoutParams = this.Hmw.getLayoutParams();
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { i * 6, (int)(this.HmB.getLayoutParams().height + 4.5D * i) }).setDuration(300L);
    localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(196285);
        localLayoutParams.height = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
        LiveTalkRoomTipsBar.d(LiveTalkRoomTipsBar.this).setLayoutParams(localLayoutParams);
        AppMethodBeat.o(196285);
      }
    });
    localValueAnimator.start();
    AppMethodBeat.o(196290);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.LiveTalkRoomTipsBar
 * JD-Core Version:    0.7.0.1
 */