package com.tencent.mm.ui;

import android.annotation.TargetApi;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.LinkedList;

public class LiveTalkRoomTipsBar
  extends LinearLayout
{
  public q OFb;
  private RelativeLayout OFc;
  public RelativeLayout OFd;
  private RelativeLayout OFe;
  private FrameLayout OFf;
  private TextView OFg;
  private ImageView OFh;
  private View OFi;
  public ListView OFj;
  private View OFk;
  private com.tencent.mm.ui.chatting.e.a OFl;
  private WeImageView OFm;
  private View OFn;
  private boolean OFo;
  public Context context;
  private View obi;
  private View psf;
  
  public LiveTalkRoomTipsBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(232608);
    this.context = paramContext;
    initView();
    AppMethodBeat.o(232608);
  }
  
  @TargetApi(11)
  public LiveTalkRoomTipsBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(232607);
    this.context = paramContext;
    initView();
    AppMethodBeat.o(232607);
  }
  
  private void akU(int paramInt)
  {
    AppMethodBeat.i(232613);
    int j = com.tencent.mm.cb.a.aG(this.context, 2131165314);
    Object localObject = new DisplayMetrics();
    ((Activity)this.context).getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    int i = (((DisplayMetrics)localObject).heightPixels - j * 21) / 2;
    paramInt = j * ((paramInt + 1) * 8);
    localObject = this.OFj.getLayoutParams();
    if (paramInt > i) {}
    for (((ViewGroup.LayoutParams)localObject).height = i;; ((ViewGroup.LayoutParams)localObject).height = paramInt)
    {
      this.OFj.setLayoutParams((ViewGroup.LayoutParams)localObject);
      ViewGroup.LayoutParams localLayoutParams = this.OFd.getLayoutParams();
      localLayoutParams.height = ((ViewGroup.LayoutParams)localObject).height;
      this.OFd.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(232613);
      return;
    }
  }
  
  private void gIF()
  {
    AppMethodBeat.i(232614);
    this.OFd.setVisibility(8);
    setVisibility(8);
    setRootTipsBarBackground(false);
    AppMethodBeat.o(232614);
  }
  
  private void initView()
  {
    AppMethodBeat.i(232610);
    inflate(getContext(), 2131495281, this);
    this.OFc = ((RelativeLayout)findViewById(2131303582));
    this.OFh = ((ImageView)findViewById(2131303581));
    this.OFh.setImageDrawable(ar.m(getContext(), 2131691403, getContext().getResources().getColor(2131101009)));
    this.OFg = ((TextView)findViewById(2131303586));
    this.OFe = ((RelativeLayout)findViewById(2131303579));
    this.obi = findViewById(2131297683);
    this.OFm = ((WeImageView)findViewById(2131297043));
    this.OFn = findViewById(2131303578);
    this.OFd = ((RelativeLayout)findViewById(2131303587));
    this.OFf = ((FrameLayout)findViewById(2131303588));
    this.OFj = ((ListView)findViewById(2131303584));
    this.psf = aa.jQ(this.context).inflate(2131495282, null);
    this.OFj.addFooterView(this.psf);
    this.OFi = findViewById(2131303583);
    bc(true, false);
    this.OFc.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(232602);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/LiveTalkRoomTipsBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (LiveTalkRoomTipsBar.a(LiveTalkRoomTipsBar.this).OFs != null)
        {
          int i = LiveTalkRoomTipsBar.a(LiveTalkRoomTipsBar.this).OFs.getCount();
          if (i <= 0)
          {
            Log.e("MicroMsg.LiveTalkRoomTipsBar", "click liveTipsBarLayout error, count:%d", new Object[] { Integer.valueOf(i) });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LiveTalkRoomTipsBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(232602);
            return;
          }
          if (!WeChatBrands.Business.Entries.SessionGroupLive.checkAvailable(paramAnonymousView.getContext()))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LiveTalkRoomTipsBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(232602);
            return;
          }
          Log.i("MicroMsg.LiveTalkRoomTipsBar", "click liveTipsBarLayout, isAnchorLiving:%b, isVisitorLiving:%b, count:%s", new Object[] { Boolean.valueOf(((com.tencent.mm.live.a)g.ah(com.tencent.mm.live.a.class)).isAnchorLiving()), Boolean.valueOf(((com.tencent.mm.live.a)g.ah(com.tencent.mm.live.a.class)).isVisitorLiving()), Integer.valueOf(i) });
          if (LiveTalkRoomTipsBar.b(LiveTalkRoomTipsBar.this).getVisibility() == 8) {
            LiveTalkRoomTipsBar.a(LiveTalkRoomTipsBar.this, false);
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LiveTalkRoomTipsBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(232602);
      }
    });
    this.OFe.setVisibility(8);
    this.OFe.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(232603);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/LiveTalkRoomTipsBar$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (LiveTalkRoomTipsBar.a(LiveTalkRoomTipsBar.this) != null)
        {
          LiveTalkRoomTipsBar.a(LiveTalkRoomTipsBar.this);
          q.blO(LiveTalkRoomTipsBar.c(LiveTalkRoomTipsBar.this).getTalkerUserName());
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LiveTalkRoomTipsBar$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(232603);
      }
    });
    this.OFi.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(232604);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/LiveTalkRoomTipsBar$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        LiveTalkRoomTipsBar.a(LiveTalkRoomTipsBar.this, true);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LiveTalkRoomTipsBar$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(232604);
      }
    });
    AppMethodBeat.o(232610);
  }
  
  public final void bc(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(232611);
    Animation localAnimation;
    if (paramBoolean1)
    {
      if ((this.OFd.getVisibility() == 0) && (paramBoolean2))
      {
        localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772133);
        localAnimation.setAnimationListener(new Animation.AnimationListener()
        {
          public final void onAnimationEnd(Animation paramAnonymousAnimation)
          {
            AppMethodBeat.i(232605);
            LiveTalkRoomTipsBar.b(LiveTalkRoomTipsBar.this).setVisibility(8);
            LiveTalkRoomTipsBar.this.gIE();
            AppMethodBeat.o(232605);
          }
          
          public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
          
          public final void onAnimationStart(Animation paramAnonymousAnimation) {}
        });
        this.OFd.startAnimation(localAnimation);
      }
      for (;;)
      {
        setRootTipsBarBackground(false);
        AppMethodBeat.o(232611);
        return;
        this.OFd.setVisibility(8);
        gIE();
      }
    }
    if (this.OFd.getVisibility() != 0)
    {
      this.OFd.setVisibility(0);
      setRootTipsBarBackground(true);
      if (paramBoolean2)
      {
        localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772129);
        this.OFd.startAnimation(localAnimation);
        if (this.OFk != null) {
          this.OFk.startAnimation(AnimationUtils.loadAnimation(getContext(), 2130772059));
        }
      }
    }
    gIE();
    if (this.OFl != null) {
      this.OFl.hideVKB();
    }
    AppMethodBeat.o(232611);
  }
  
  public final void gID()
  {
    AppMethodBeat.i(232609);
    if (this.OFb != null)
    {
      q localq = this.OFb;
      ((com.tencent.mm.live.a)g.ah(com.tencent.mm.live.a.class)).getLiveTipsBarStorage().hLf = localq.hLf;
    }
    AppMethodBeat.o(232609);
  }
  
  public final void gIE()
  {
    AppMethodBeat.i(232612);
    if (!this.OFo)
    {
      gIF();
      AppMethodBeat.o(232612);
      return;
    }
    LinkedList localLinkedList;
    Object localObject;
    if (this.OFb != null)
    {
      localLinkedList = this.OFb.gIH();
      if ((localLinkedList == null) || (localLinkedList.size() <= 0))
      {
        if (localLinkedList == null) {}
        for (localObject = "null";; localObject = "0")
        {
          Log.e("MicroMsg.LiveTalkRoomTipsBar", "showLiveTipsBar List error:%s", new Object[] { localObject });
          gIF();
          AppMethodBeat.o(232612);
          return;
        }
      }
      boolean bool1 = ((com.tencent.mm.live.a)g.ah(com.tencent.mm.live.a.class)).isAnchorLiving();
      boolean bool2 = ((com.tencent.mm.live.a)g.ah(com.tencent.mm.live.a.class)).isVisitorLiving();
      if (localLinkedList != null) {
        break label286;
      }
      localObject = "null";
      Log.i("MicroMsg.LiveTalkRoomTipsBar", "showLiveTipsBar List size:%s, isAnchorLiving:%b, isVisitorLiving:%b", new Object[] { localObject, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if (((!bool1) && (!bool2)) || (this.OFb == null) || (!this.OFb.blN(((com.tencent.mm.live.a)g.ah(com.tencent.mm.live.a.class)).getLivingRoomId()))) {
        break label309;
      }
      localObject = this.context.getString(2131762425, new Object[] { Integer.valueOf(localLinkedList.size()) });
      if (this.OFd.getVisibility() != 0) {
        break label298;
      }
      this.OFg.setText((CharSequence)localObject);
      akU(localLinkedList.size());
      setRootTipsBarBackground(true);
      this.OFb.OFs.notifyDataSetChanged();
    }
    for (;;)
    {
      setVisibility(0);
      AppMethodBeat.o(232612);
      return;
      label286:
      localObject = Integer.valueOf(localLinkedList.size());
      break;
      label298:
      this.OFg.setText((CharSequence)localObject);
      continue;
      label309:
      localObject = this.context.getString(2131762426, new Object[] { Integer.valueOf(localLinkedList.size()) });
      if (this.OFd.getVisibility() == 0)
      {
        this.OFg.setText((CharSequence)localObject);
        akU(localLinkedList.size());
        setRootTipsBarBackground(true);
        this.OFb.OFs.notifyDataSetChanged();
      }
      else
      {
        this.OFg.setText((CharSequence)localObject);
      }
    }
  }
  
  public void setChattingContext(com.tencent.mm.ui.chatting.e.a parama)
  {
    this.OFl = parama;
  }
  
  public void setChattingUserName(String paramString)
  {
    if (this.OFb != null) {
      this.OFb.hwa = paramString;
    }
  }
  
  public void setInChatRoom(boolean paramBoolean)
  {
    this.OFo = paramBoolean;
  }
  
  public void setRootTipsBarBackground(View paramView)
  {
    this.OFk = paramView;
  }
  
  public void setRootTipsBarBackground(boolean paramBoolean)
  {
    AppMethodBeat.i(232615);
    if (this.OFk != null) {
      if (paramBoolean)
      {
        this.OFk.setVisibility(0);
        this.OFk.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(232606);
            b localb = new b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/LiveTalkRoomTipsBar$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            LiveTalkRoomTipsBar.a(LiveTalkRoomTipsBar.this, true);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LiveTalkRoomTipsBar$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(232606);
          }
        });
        if (this.obi != null) {
          this.obi.setVisibility(8);
        }
        if (this.OFm != null) {
          this.OFm.setVisibility(4);
        }
        if (this.OFn != null)
        {
          this.OFn.setBackgroundColor(0);
          AppMethodBeat.o(232615);
        }
      }
      else
      {
        this.OFk.setVisibility(8);
        if (this.obi != null) {
          this.obi.setVisibility(0);
        }
        if (this.OFm != null) {
          this.OFm.setVisibility(0);
        }
        if (this.OFn != null) {
          this.OFn.setBackgroundResource(2131235312);
        }
      }
    }
    AppMethodBeat.o(232615);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.LiveTalkRoomTipsBar
 * JD-Core Version:    0.7.0.1
 */