package com.tencent.mm.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.a;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.view.FinderLiveOnliveWidget;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.ui.report.d;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.LinkedList;
import kotlin.g.b.s;
import org.libpag.PAGView;

public class LiveTalkRoomTipsBar
  extends LinearLayout
{
  private RelativeLayout adCP;
  private com.tencent.mm.ui.chatting.d.a adCQ;
  public u adCT;
  public RelativeLayout adCU;
  private RelativeLayout adCV;
  private FrameLayout adCW;
  private TextView adCX;
  private View adCY;
  public ListView adCZ;
  private View adDa;
  private WeImageView adDb;
  private View adDc;
  private boolean adDd;
  private FinderLiveOnliveWidget adDe;
  public Context context;
  private String pss;
  private View uiE;
  private View uix;
  
  public LiveTalkRoomTipsBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(249466);
    this.context = paramContext;
    initView();
    AppMethodBeat.o(249466);
  }
  
  public LiveTalkRoomTipsBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(249461);
    this.context = paramContext;
    initView();
    AppMethodBeat.o(249461);
  }
  
  private void aAg(int paramInt)
  {
    AppMethodBeat.i(249475);
    int j = com.tencent.mm.cd.a.br(this.context, R.f.Edge_A);
    Object localObject = new DisplayMetrics();
    ((Activity)this.context).getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    int i = (((DisplayMetrics)localObject).heightPixels - j * 21) / 2;
    paramInt = j * ((paramInt + 1) * 8);
    localObject = this.adCZ.getLayoutParams();
    if (paramInt > i) {}
    for (((ViewGroup.LayoutParams)localObject).height = i;; ((ViewGroup.LayoutParams)localObject).height = paramInt)
    {
      this.adCZ.setLayoutParams((ViewGroup.LayoutParams)localObject);
      ViewGroup.LayoutParams localLayoutParams = this.adCU.getLayoutParams();
      localLayoutParams.height = ((ViewGroup.LayoutParams)localObject).height;
      this.adCU.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(249475);
      return;
    }
  }
  
  private void initView()
  {
    AppMethodBeat.i(249472);
    inflate(getContext(), R.i.live_talkroom_tipsbar, this);
    this.adCP = ((RelativeLayout)findViewById(R.h.live_tipsbar_layout));
    this.adCX = ((TextView)findViewById(R.h.live_tipsbar_title));
    this.adCV = ((RelativeLayout)findViewById(R.h.live_tipsbar_close_btn));
    this.uix = findViewById(R.h.bottom_line);
    this.adDb = ((WeImageView)findViewById(R.h.arrow));
    this.adDc = findViewById(R.h.live_tipsbar_click_area);
    this.adCU = ((RelativeLayout)findViewById(R.h.live_tipsbar_unfold_background));
    this.adCW = ((FrameLayout)findViewById(R.h.live_tipsbar_unfold_layout));
    this.adCZ = ((ListView)findViewById(R.h.live_tipsbar_listview));
    this.uiE = af.mU(this.context).inflate(R.i.live_talkroom_tipsbar_footer, null);
    this.adCZ.addFooterView(this.uiE);
    this.adCY = findViewById(R.h.live_tipsbar_list_unfold_btn);
    this.adDe = ((FinderLiveOnliveWidget)findViewById(R.h.live_tipsbar_living_icon));
    bK(true, false);
    this.adCP.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(249689);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/LiveTalkRoomTipsBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (LiveTalkRoomTipsBar.a(LiveTalkRoomTipsBar.this).adDi != null)
        {
          int i = LiveTalkRoomTipsBar.a(LiveTalkRoomTipsBar.this).adDi.getCount();
          if (i <= 0)
          {
            Log.e("MicroMsg.LiveTalkRoomTipsBar", "click liveTipsBarLayout error, count:%d", new Object[] { Integer.valueOf(i) });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LiveTalkRoomTipsBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(249689);
            return;
          }
          if (!WeChatBrands.Business.Entries.SessionGroupLive.checkAvailable(paramAnonymousView.getContext()))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LiveTalkRoomTipsBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(249689);
            return;
          }
          Log.i("MicroMsg.LiveTalkRoomTipsBar", "click liveTipsBarLayout, isAnchorLiving:%b, isVisitorLiving:%b, count:%s", new Object[] { Boolean.valueOf(((com.tencent.mm.live.a)h.az(com.tencent.mm.live.a.class)).isAnchorLiving()), Boolean.valueOf(((com.tencent.mm.live.a)h.az(com.tencent.mm.live.a.class)).isVisitorLiving()), Integer.valueOf(i) });
          if (LiveTalkRoomTipsBar.b(LiveTalkRoomTipsBar.this).getVisibility() == 8)
          {
            LiveTalkRoomTipsBar.a(LiveTalkRoomTipsBar.this, false);
            paramAnonymousView = d.afBU;
            d.a(LiveTalkRoomTipsBar.c(LiveTalkRoomTipsBar.this), LiveTalkRoomTipsBar.a(LiveTalkRoomTipsBar.this).jjI(), "", 1L, System.currentTimeMillis());
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LiveTalkRoomTipsBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(249689);
      }
    });
    this.adCV.setVisibility(8);
    this.adCV.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(249687);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/LiveTalkRoomTipsBar$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (LiveTalkRoomTipsBar.a(LiveTalkRoomTipsBar.this) != null)
        {
          LiveTalkRoomTipsBar.a(LiveTalkRoomTipsBar.this);
          u.bzJ(LiveTalkRoomTipsBar.d(LiveTalkRoomTipsBar.this).getTalkerUserName());
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LiveTalkRoomTipsBar$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(249687);
      }
    });
    this.adCY.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(249658);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/LiveTalkRoomTipsBar$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        LiveTalkRoomTipsBar.a(LiveTalkRoomTipsBar.this, true);
        paramAnonymousView = d.afBU;
        d.a(LiveTalkRoomTipsBar.c(LiveTalkRoomTipsBar.this), LiveTalkRoomTipsBar.a(LiveTalkRoomTipsBar.this).jjI(), "", 2L, System.currentTimeMillis());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LiveTalkRoomTipsBar$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(249658);
      }
    });
    AppMethodBeat.o(249472);
  }
  
  private void jjD()
  {
    AppMethodBeat.i(249478);
    this.adCU.setVisibility(8);
    setVisibility(8);
    setRootTipsBarBackground(false);
    jjF();
    AppMethodBeat.o(249478);
  }
  
  public final void bK(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(249497);
    Animation localAnimation;
    if (paramBoolean1)
    {
      if ((this.adCU.getVisibility() == 0) && (paramBoolean2))
      {
        localAnimation = AnimationUtils.loadAnimation(getContext(), R.a.push_up_out);
        localAnimation.setAnimationListener(new Animation.AnimationListener()
        {
          public final void onAnimationEnd(Animation paramAnonymousAnimation)
          {
            AppMethodBeat.i(249649);
            LiveTalkRoomTipsBar.b(LiveTalkRoomTipsBar.this).setVisibility(8);
            LiveTalkRoomTipsBar.this.jjC();
            AppMethodBeat.o(249649);
          }
          
          public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
          
          public final void onAnimationStart(Animation paramAnonymousAnimation) {}
        });
        this.adCU.startAnimation(localAnimation);
      }
      for (;;)
      {
        setRootTipsBarBackground(false);
        AppMethodBeat.o(249497);
        return;
        this.adCU.setVisibility(8);
        jjC();
      }
    }
    if (this.adCU.getVisibility() != 0)
    {
      this.adCU.setVisibility(0);
      setRootTipsBarBackground(true);
      if (paramBoolean2)
      {
        localAnimation = AnimationUtils.loadAnimation(getContext(), R.a.push_down_in);
        this.adCU.startAnimation(localAnimation);
        if (this.adDa != null) {
          this.adDa.startAnimation(AnimationUtils.loadAnimation(getContext(), R.a.fast_faded_in));
        }
      }
    }
    jjC();
    if (this.adCQ != null) {
      this.adCQ.hideVKB();
    }
    AppMethodBeat.o(249497);
  }
  
  public final void jjB()
  {
    AppMethodBeat.i(249491);
    if (this.adCT != null)
    {
      u localu = this.adCT;
      ((com.tencent.mm.live.a)h.az(com.tencent.mm.live.a.class)).getLiveTipsBarStorage().nbW = localu.nbW;
    }
    AppMethodBeat.o(249491);
  }
  
  public final void jjC()
  {
    AppMethodBeat.i(249503);
    if (!this.adDd)
    {
      jjD();
      AppMethodBeat.o(249503);
      return;
    }
    LinkedList localLinkedList;
    Object localObject;
    if (this.adCT != null)
    {
      localLinkedList = this.adCT.jjH();
      if ((localLinkedList == null) || (localLinkedList.size() <= 0))
      {
        if (localLinkedList == null) {}
        for (localObject = "null";; localObject = "0")
        {
          Log.e("MicroMsg.LiveTalkRoomTipsBar", "showLiveTipsBar List error:%s", new Object[] { localObject });
          jjD();
          AppMethodBeat.o(249503);
          return;
        }
      }
      boolean bool1 = ((com.tencent.mm.live.a)h.az(com.tencent.mm.live.a.class)).isAnchorLiving();
      boolean bool2 = ((com.tencent.mm.live.a)h.az(com.tencent.mm.live.a.class)).isVisitorLiving();
      if (localLinkedList != null) {
        break label272;
      }
      localObject = "null";
      Log.i("MicroMsg.LiveTalkRoomTipsBar", "showLiveTipsBar List size:%s, isAnchorLiving:%b, isVisitorLiving:%b", new Object[] { localObject, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if (((!bool1) && (!bool2)) || (this.adCT == null) || (!this.adCT.bzI(((com.tencent.mm.live.a)h.az(com.tencent.mm.live.a.class)).getLivingRoomId()))) {
        break label295;
      }
      localObject = this.adCT.c(localLinkedList, bool1, true);
      if (this.adCU.getVisibility() != 0) {
        break label284;
      }
      this.adCX.setText((CharSequence)localObject);
      aAg(localLinkedList.size());
      setRootTipsBarBackground(true);
      this.adCT.adDi.notifyDataSetChanged();
    }
    for (;;)
    {
      setVisibility(0);
      AppMethodBeat.o(249503);
      return;
      label272:
      localObject = Integer.valueOf(localLinkedList.size());
      break;
      label284:
      this.adCX.setText((CharSequence)localObject);
      continue;
      label295:
      localObject = this.adCT.c(localLinkedList, false, false);
      if (this.adCU.getVisibility() == 0)
      {
        this.adCX.setText((CharSequence)localObject);
        aAg(localLinkedList.size());
        setRootTipsBarBackground(true);
        this.adCT.adDi.notifyDataSetChanged();
      }
      else
      {
        this.adCX.setText((CharSequence)localObject);
      }
    }
  }
  
  public final void jjE()
  {
    AppMethodBeat.i(249512);
    Object localObject = t.adCS;
    int i;
    if (t.jjy())
    {
      this.adDe.setLogoStyle(1);
      localObject = this.adDe;
      i = R.e.finder_live_logo_color;
      Log.i(FinderLiveOnliveWidget.TAG, s.X("showAnim logoStyle:", Integer.valueOf(((FinderLiveOnliveWidget)localObject).GAG)));
      if (((FinderLiveOnliveWidget)localObject).GAG == 1)
      {
        if ((!((FinderLiveOnliveWidget)localObject).GAT) || (i != ((FinderLiveOnliveWidget)localObject).GAS)) {
          break label95;
        }
        FinderLiveOnliveWidget.aCE("same anim!");
      }
    }
    for (;;)
    {
      this.adDe.fkY();
      AppMethodBeat.o(249512);
      return;
      label95:
      if (((FinderLiveOnliveWidget)localObject).indexOfChild((View)((FinderLiveOnliveWidget)localObject).GAK) != -1)
      {
        ((FinderLiveOnliveWidget)localObject).removeView((View)((FinderLiveOnliveWidget)localObject).GAK);
        Log.i(FinderLiveOnliveWidget.TAG, "hideImage");
      }
      ((FinderLiveOnliveWidget)localObject).GAV = false;
      if (((FinderLiveOnliveWidget)localObject).indexOfChild((View)((FinderLiveOnliveWidget)localObject).GAJ) != -1)
      {
        PAGView localPAGView = ((FinderLiveOnliveWidget)localObject).GAJ;
        if (localPAGView != null) {
          localPAGView.stop();
        }
        ((FinderLiveOnliveWidget)localObject).removeView((View)((FinderLiveOnliveWidget)localObject).GAJ);
        Log.i(FinderLiveOnliveWidget.TAG, "hideAnim");
      }
      ((FinderLiveOnliveWidget)localObject).GAT = false;
      ((FinderLiveOnliveWidget)localObject).GAT = true;
      ((FinderLiveOnliveWidget)localObject).GAS = ((FinderLiveOnliveWidget)localObject).getContext().getResources().getColor(i);
      ((FinderLiveOnliveWidget)localObject).exv();
      ((FinderLiveOnliveWidget)localObject).fkV();
    }
  }
  
  public final void jjF()
  {
    AppMethodBeat.i(249516);
    t localt = t.adCS;
    if (t.jjy()) {
      this.adDe.dxz();
    }
    AppMethodBeat.o(249516);
  }
  
  public void setChattingContext(com.tencent.mm.ui.chatting.d.a parama)
  {
    this.adCQ = parama;
  }
  
  public void setChattingUserName(String paramString)
  {
    this.pss = paramString;
    if (this.adCT != null) {
      this.adCT.mIz = paramString;
    }
  }
  
  public void setInChatRoom(boolean paramBoolean)
  {
    this.adDd = paramBoolean;
  }
  
  public void setRootTipsBarBackground(View paramView)
  {
    this.adDa = paramView;
  }
  
  public void setRootTipsBarBackground(boolean paramBoolean)
  {
    AppMethodBeat.i(249507);
    if (this.adDa != null) {
      if (paramBoolean)
      {
        this.adDa.setVisibility(0);
        this.adDa.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(249637);
            b localb = new b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/LiveTalkRoomTipsBar$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            LiveTalkRoomTipsBar.a(LiveTalkRoomTipsBar.this, true);
            paramAnonymousView = d.afBU;
            d.a(LiveTalkRoomTipsBar.c(LiveTalkRoomTipsBar.this), LiveTalkRoomTipsBar.a(LiveTalkRoomTipsBar.this).jjI(), "", 2L, System.currentTimeMillis());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LiveTalkRoomTipsBar$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(249637);
          }
        });
        if (this.uix != null) {
          this.uix.setVisibility(8);
        }
        if (this.adDb != null) {
          this.adDb.setVisibility(4);
        }
        if (this.adDc != null)
        {
          this.adDc.setBackgroundColor(0);
          AppMethodBeat.o(249507);
        }
      }
      else
      {
        this.adDa.setVisibility(8);
        if (this.uix != null) {
          this.uix.setVisibility(0);
        }
        if (this.adDb != null) {
          this.adDb.setVisibility(0);
        }
        if (this.adDc != null) {
          this.adDc.setBackgroundResource(R.g.tipsbar_small_white_bg);
        }
      }
    }
    AppMethodBeat.o(249507);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.LiveTalkRoomTipsBar
 * JD-Core Version:    0.7.0.1
 */