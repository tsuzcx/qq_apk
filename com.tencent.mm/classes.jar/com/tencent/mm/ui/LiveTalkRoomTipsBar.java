package com.tencent.mm.ui;

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
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.LinkedList;

public class LiveTalkRoomTipsBar
  extends LinearLayout
{
  public p IZZ;
  private RelativeLayout Jaa;
  public RelativeLayout Jab;
  private RelativeLayout Jac;
  private FrameLayout Jad;
  private TextView Jae;
  private WeImageView Jaf;
  private View Jag;
  public ListView Jah;
  private View Jai;
  private com.tencent.mm.ui.chatting.e.a Jaj;
  private WeImageView Jak;
  private View Jal;
  private boolean Jam;
  public Context context;
  private View mJf;
  private View oaY;
  
  public LiveTalkRoomTipsBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(193690);
    this.context = paramContext;
    initView();
    AppMethodBeat.o(193690);
  }
  
  @TargetApi(11)
  public LiveTalkRoomTipsBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(193689);
    this.context = paramContext;
    initView();
    AppMethodBeat.o(193689);
  }
  
  private void abE(int paramInt)
  {
    AppMethodBeat.i(193694);
    int j = com.tencent.mm.cc.a.ax(this.context, 2131165303);
    Object localObject = new DisplayMetrics();
    ((Activity)this.context).getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    int i = (((DisplayMetrics)localObject).heightPixels - j * 21) / 2;
    paramInt = j * ((paramInt + 1) * 8);
    localObject = this.Jah.getLayoutParams();
    if (paramInt > i) {}
    for (((ViewGroup.LayoutParams)localObject).height = i;; ((ViewGroup.LayoutParams)localObject).height = paramInt)
    {
      this.Jah.setLayoutParams((ViewGroup.LayoutParams)localObject);
      ViewGroup.LayoutParams localLayoutParams = this.Jab.getLayoutParams();
      localLayoutParams.height = ((ViewGroup.LayoutParams)localObject).height;
      this.Jab.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(193694);
      return;
    }
  }
  
  private void fwM()
  {
    AppMethodBeat.i(193695);
    this.Jab.setVisibility(8);
    setVisibility(8);
    setRootTipsBarBackground(false);
    AppMethodBeat.o(193695);
  }
  
  private void initView()
  {
    AppMethodBeat.i(193691);
    inflate(getContext(), 2131496341, this);
    this.Jaa = ((RelativeLayout)findViewById(2131307794));
    this.Jaf = ((WeImageView)findViewById(2131307793));
    this.Jaf.setIconColor(0);
    this.Jae = ((TextView)findViewById(2131307799));
    this.Jac = ((RelativeLayout)findViewById(2131307791));
    this.mJf = findViewById(2131297453);
    this.Jak = ((WeImageView)findViewById(2131296937));
    this.Jal = findViewById(2131307790);
    this.Jab = ((RelativeLayout)findViewById(2131307800));
    this.Jad = ((FrameLayout)findViewById(2131307801));
    this.Jah = ((ListView)findViewById(2131307796));
    this.oaY = z.jO(this.context).inflate(2131496342, null);
    this.Jah.addFooterView(this.oaY);
    this.Jag = findViewById(2131307795);
    aT(true, false);
    this.Jaa.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(193684);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/LiveTalkRoomTipsBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (LiveTalkRoomTipsBar.a(LiveTalkRoomTipsBar.this).Jaq != null)
        {
          int i = LiveTalkRoomTipsBar.a(LiveTalkRoomTipsBar.this).Jaq.getCount();
          if (i <= 0)
          {
            ad.e("MicroMsg.LiveTalkRoomTipsBar", "click liveTipsBarLayout error, count:%d", new Object[] { Integer.valueOf(i) });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LiveTalkRoomTipsBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(193684);
            return;
          }
          ad.i("MicroMsg.LiveTalkRoomTipsBar", "click liveTipsBarLayout, isAnchorLiving:%b, isVisitorLiving:%b, count:%s", new Object[] { Boolean.valueOf(((com.tencent.mm.live.a)g.ad(com.tencent.mm.live.a.class)).isAnchorLiving()), Boolean.valueOf(((com.tencent.mm.live.a)g.ad(com.tencent.mm.live.a.class)).isVisitorLiving()), Integer.valueOf(i) });
          if (LiveTalkRoomTipsBar.b(LiveTalkRoomTipsBar.this).getVisibility() == 8) {
            LiveTalkRoomTipsBar.a(LiveTalkRoomTipsBar.this, false);
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LiveTalkRoomTipsBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(193684);
      }
    });
    this.Jac.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(193685);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/LiveTalkRoomTipsBar$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (LiveTalkRoomTipsBar.a(LiveTalkRoomTipsBar.this) != null)
        {
          LiveTalkRoomTipsBar.a(LiveTalkRoomTipsBar.this);
          p.aVo(LiveTalkRoomTipsBar.c(LiveTalkRoomTipsBar.this).getTalkerUserName());
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LiveTalkRoomTipsBar$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(193685);
      }
    });
    this.Jag.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(193686);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/LiveTalkRoomTipsBar$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        LiveTalkRoomTipsBar.a(LiveTalkRoomTipsBar.this, true);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LiveTalkRoomTipsBar$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(193686);
      }
    });
    AppMethodBeat.o(193691);
  }
  
  public final void aT(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(193692);
    Animation localAnimation;
    if (paramBoolean1)
    {
      if ((this.Jab.getVisibility() == 0) && (paramBoolean2))
      {
        localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772109);
        localAnimation.setAnimationListener(new Animation.AnimationListener()
        {
          public final void onAnimationEnd(Animation paramAnonymousAnimation)
          {
            AppMethodBeat.i(193687);
            LiveTalkRoomTipsBar.b(LiveTalkRoomTipsBar.this).setVisibility(8);
            LiveTalkRoomTipsBar.this.fwL();
            AppMethodBeat.o(193687);
          }
          
          public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
          
          public final void onAnimationStart(Animation paramAnonymousAnimation) {}
        });
        this.Jab.startAnimation(localAnimation);
      }
      for (;;)
      {
        setRootTipsBarBackground(false);
        AppMethodBeat.o(193692);
        return;
        this.Jab.setVisibility(8);
        fwL();
      }
    }
    if (this.Jab.getVisibility() != 0)
    {
      this.Jab.setVisibility(0);
      setRootTipsBarBackground(true);
      if (paramBoolean2)
      {
        localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772105);
        this.Jab.startAnimation(localAnimation);
        if (this.Jai != null) {
          this.Jai.startAnimation(AnimationUtils.loadAnimation(getContext(), 2130772047));
        }
      }
    }
    fwL();
    if (this.Jaj != null) {
      this.Jaj.hideVKB();
    }
    AppMethodBeat.o(193692);
  }
  
  public final void fwL()
  {
    AppMethodBeat.i(193693);
    if (!this.Jam)
    {
      fwM();
      AppMethodBeat.o(193693);
      return;
    }
    LinkedList localLinkedList;
    Object localObject;
    if (this.IZZ != null)
    {
      localLinkedList = this.IZZ.fwN();
      if ((localLinkedList == null) || (localLinkedList.size() <= 0))
      {
        if (localLinkedList == null) {}
        for (localObject = "null";; localObject = "0")
        {
          ad.e("MicroMsg.LiveTalkRoomTipsBar", "showLiveTipsBar List error:%s", new Object[] { localObject });
          fwM();
          AppMethodBeat.o(193693);
          return;
        }
      }
      boolean bool1 = ((com.tencent.mm.live.a)g.ad(com.tencent.mm.live.a.class)).isAnchorLiving();
      boolean bool2 = ((com.tencent.mm.live.a)g.ad(com.tencent.mm.live.a.class)).isVisitorLiving();
      if (localLinkedList != null) {
        break label286;
      }
      localObject = "null";
      ad.i("MicroMsg.LiveTalkRoomTipsBar", "showLiveTipsBar List size:%s, isAnchorLiving:%b, isVisitorLiving:%b", new Object[] { localObject, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if (((!bool1) && (!bool2)) || (this.IZZ == null) || (!this.IZZ.aVn(((com.tencent.mm.live.a)g.ad(com.tencent.mm.live.a.class)).getLivingRoomId()))) {
        break label309;
      }
      localObject = this.context.getString(2131766728, new Object[] { Integer.valueOf(localLinkedList.size()) });
      if (this.Jab.getVisibility() != 0) {
        break label298;
      }
      this.Jae.setText((CharSequence)localObject);
      abE(localLinkedList.size());
      setRootTipsBarBackground(true);
      this.IZZ.Jaq.notifyDataSetChanged();
    }
    for (;;)
    {
      setVisibility(0);
      AppMethodBeat.o(193693);
      return;
      label286:
      localObject = Integer.valueOf(localLinkedList.size());
      break;
      label298:
      this.Jae.setText((CharSequence)localObject);
      continue;
      label309:
      localObject = this.context.getString(2131766729, new Object[] { Integer.valueOf(localLinkedList.size()) });
      if (this.Jab.getVisibility() == 0)
      {
        this.Jae.setText((CharSequence)localObject);
        abE(localLinkedList.size());
        setRootTipsBarBackground(true);
        this.IZZ.Jaq.notifyDataSetChanged();
      }
      else
      {
        this.Jae.setText((CharSequence)localObject);
      }
    }
  }
  
  public void setChattingContext(com.tencent.mm.ui.chatting.e.a parama)
  {
    this.Jaj = parama;
  }
  
  public void setChattingUserName(String paramString)
  {
    if (this.IZZ != null) {
      this.IZZ.gGz = paramString;
    }
  }
  
  public void setInChatRoom(boolean paramBoolean)
  {
    this.Jam = paramBoolean;
  }
  
  public void setRootTipsBarBackground(View paramView)
  {
    this.Jai = paramView;
  }
  
  public void setRootTipsBarBackground(boolean paramBoolean)
  {
    AppMethodBeat.i(193696);
    if (this.Jai != null) {
      if (paramBoolean)
      {
        this.Jai.setVisibility(0);
        this.Jai.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(193688);
            b localb = new b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/LiveTalkRoomTipsBar$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            LiveTalkRoomTipsBar.a(LiveTalkRoomTipsBar.this, true);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LiveTalkRoomTipsBar$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(193688);
          }
        });
        if (this.mJf != null) {
          this.mJf.setVisibility(8);
        }
        if (this.Jak != null) {
          this.Jak.setVisibility(4);
        }
        if (this.Jal != null) {
          this.Jal.setBackgroundColor(0);
        }
        if (this.Jac != null)
        {
          this.Jac.setVisibility(0);
          AppMethodBeat.o(193696);
        }
      }
      else
      {
        this.Jai.setVisibility(8);
        if (this.mJf != null) {
          this.mJf.setVisibility(0);
        }
        if (this.Jak != null) {
          this.Jak.setVisibility(0);
        }
        if (this.Jal != null) {
          this.Jal.setBackgroundResource(2131234968);
        }
        if (this.Jac != null) {
          this.Jac.setVisibility(4);
        }
      }
    }
    AppMethodBeat.o(193696);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.LiveTalkRoomTipsBar
 * JD-Core Version:    0.7.0.1
 */