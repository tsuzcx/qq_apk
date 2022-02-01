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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.LinkedList;

public class LiveTalkRoomTipsBar
  extends LinearLayout
{
  public p JuH;
  private RelativeLayout JuI;
  public RelativeLayout JuJ;
  private RelativeLayout JuK;
  private FrameLayout JuL;
  private TextView JuM;
  private WeImageView JuN;
  private View JuO;
  public ListView JuP;
  private View JuQ;
  private com.tencent.mm.ui.chatting.e.a JuR;
  private WeImageView JuS;
  private View JuT;
  private boolean JuU;
  public Context context;
  private View mOh;
  private View ogP;
  
  public LiveTalkRoomTipsBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(186977);
    this.context = paramContext;
    initView();
    AppMethodBeat.o(186977);
  }
  
  @TargetApi(11)
  public LiveTalkRoomTipsBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(186976);
    this.context = paramContext;
    initView();
    AppMethodBeat.o(186976);
  }
  
  private void acm(int paramInt)
  {
    AppMethodBeat.i(186982);
    int j = com.tencent.mm.cb.a.ax(this.context, 2131165303);
    Object localObject = new DisplayMetrics();
    ((Activity)this.context).getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    int i = (((DisplayMetrics)localObject).heightPixels - j * 21) / 2;
    paramInt = j * ((paramInt + 1) * 8);
    localObject = this.JuP.getLayoutParams();
    if (paramInt > i) {}
    for (((ViewGroup.LayoutParams)localObject).height = i;; ((ViewGroup.LayoutParams)localObject).height = paramInt)
    {
      this.JuP.setLayoutParams((ViewGroup.LayoutParams)localObject);
      ViewGroup.LayoutParams localLayoutParams = this.JuJ.getLayoutParams();
      localLayoutParams.height = ((ViewGroup.LayoutParams)localObject).height;
      this.JuJ.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(186982);
      return;
    }
  }
  
  private void fAN()
  {
    AppMethodBeat.i(186983);
    this.JuJ.setVisibility(8);
    setVisibility(8);
    setRootTipsBarBackground(false);
    AppMethodBeat.o(186983);
  }
  
  private void initView()
  {
    AppMethodBeat.i(186979);
    inflate(getContext(), 2131496341, this);
    this.JuI = ((RelativeLayout)findViewById(2131307794));
    this.JuN = ((WeImageView)findViewById(2131307793));
    this.JuN.setIconColor(0);
    this.JuM = ((TextView)findViewById(2131307799));
    this.JuK = ((RelativeLayout)findViewById(2131307791));
    this.mOh = findViewById(2131297453);
    this.JuS = ((WeImageView)findViewById(2131296937));
    this.JuT = findViewById(2131307790);
    this.JuJ = ((RelativeLayout)findViewById(2131307800));
    this.JuL = ((FrameLayout)findViewById(2131307801));
    this.JuP = ((ListView)findViewById(2131307796));
    this.ogP = z.jV(this.context).inflate(2131496342, null);
    this.JuP.addFooterView(this.ogP);
    this.JuO = findViewById(2131307795);
    aS(true, false);
    this.JuI.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(186971);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/LiveTalkRoomTipsBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (LiveTalkRoomTipsBar.a(LiveTalkRoomTipsBar.this).JuY != null)
        {
          int i = LiveTalkRoomTipsBar.a(LiveTalkRoomTipsBar.this).JuY.getCount();
          if (i <= 0)
          {
            ae.e("MicroMsg.LiveTalkRoomTipsBar", "click liveTipsBarLayout error, count:%d", new Object[] { Integer.valueOf(i) });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LiveTalkRoomTipsBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(186971);
            return;
          }
          ae.i("MicroMsg.LiveTalkRoomTipsBar", "click liveTipsBarLayout, isAnchorLiving:%b, isVisitorLiving:%b, count:%s", new Object[] { Boolean.valueOf(((com.tencent.mm.live.a)g.ad(com.tencent.mm.live.a.class)).isAnchorLiving()), Boolean.valueOf(((com.tencent.mm.live.a)g.ad(com.tencent.mm.live.a.class)).isVisitorLiving()), Integer.valueOf(i) });
          if (LiveTalkRoomTipsBar.b(LiveTalkRoomTipsBar.this).getVisibility() == 8) {
            LiveTalkRoomTipsBar.a(LiveTalkRoomTipsBar.this, false);
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LiveTalkRoomTipsBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(186971);
      }
    });
    this.JuK.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(186972);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/LiveTalkRoomTipsBar$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (LiveTalkRoomTipsBar.a(LiveTalkRoomTipsBar.this) != null)
        {
          LiveTalkRoomTipsBar.a(LiveTalkRoomTipsBar.this);
          p.aWP(LiveTalkRoomTipsBar.c(LiveTalkRoomTipsBar.this).getTalkerUserName());
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LiveTalkRoomTipsBar$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(186972);
      }
    });
    this.JuO.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(186973);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/LiveTalkRoomTipsBar$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        LiveTalkRoomTipsBar.a(LiveTalkRoomTipsBar.this, true);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LiveTalkRoomTipsBar$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(186973);
      }
    });
    AppMethodBeat.o(186979);
  }
  
  public final void aS(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(186980);
    Animation localAnimation;
    if (paramBoolean1)
    {
      if ((this.JuJ.getVisibility() == 0) && (paramBoolean2))
      {
        localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772109);
        localAnimation.setAnimationListener(new Animation.AnimationListener()
        {
          public final void onAnimationEnd(Animation paramAnonymousAnimation)
          {
            AppMethodBeat.i(186974);
            LiveTalkRoomTipsBar.b(LiveTalkRoomTipsBar.this).setVisibility(8);
            LiveTalkRoomTipsBar.this.fAM();
            AppMethodBeat.o(186974);
          }
          
          public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
          
          public final void onAnimationStart(Animation paramAnonymousAnimation) {}
        });
        this.JuJ.startAnimation(localAnimation);
      }
      for (;;)
      {
        setRootTipsBarBackground(false);
        AppMethodBeat.o(186980);
        return;
        this.JuJ.setVisibility(8);
        fAM();
      }
    }
    if (this.JuJ.getVisibility() != 0)
    {
      this.JuJ.setVisibility(0);
      setRootTipsBarBackground(true);
      if (paramBoolean2)
      {
        localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772105);
        this.JuJ.startAnimation(localAnimation);
        if (this.JuQ != null) {
          this.JuQ.startAnimation(AnimationUtils.loadAnimation(getContext(), 2130772047));
        }
      }
    }
    fAM();
    if (this.JuR != null) {
      this.JuR.hideVKB();
    }
    AppMethodBeat.o(186980);
  }
  
  public final void fAL()
  {
    AppMethodBeat.i(186978);
    if (this.JuH != null)
    {
      p localp = this.JuH;
      ((com.tencent.mm.live.a)g.ad(com.tencent.mm.live.a.class)).getLiveTipsBarStorage().gTL = localp.gTL;
    }
    AppMethodBeat.o(186978);
  }
  
  public final void fAM()
  {
    AppMethodBeat.i(186981);
    if (!this.JuU)
    {
      fAN();
      AppMethodBeat.o(186981);
      return;
    }
    LinkedList localLinkedList;
    Object localObject;
    if (this.JuH != null)
    {
      localLinkedList = this.JuH.fAP();
      if ((localLinkedList == null) || (localLinkedList.size() <= 0))
      {
        if (localLinkedList == null) {}
        for (localObject = "null";; localObject = "0")
        {
          ae.e("MicroMsg.LiveTalkRoomTipsBar", "showLiveTipsBar List error:%s", new Object[] { localObject });
          fAN();
          AppMethodBeat.o(186981);
          return;
        }
      }
      boolean bool1 = ((com.tencent.mm.live.a)g.ad(com.tencent.mm.live.a.class)).isAnchorLiving();
      boolean bool2 = ((com.tencent.mm.live.a)g.ad(com.tencent.mm.live.a.class)).isVisitorLiving();
      if (localLinkedList != null) {
        break label286;
      }
      localObject = "null";
      ae.i("MicroMsg.LiveTalkRoomTipsBar", "showLiveTipsBar List size:%s, isAnchorLiving:%b, isVisitorLiving:%b", new Object[] { localObject, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if (((!bool1) && (!bool2)) || (this.JuH == null) || (!this.JuH.aWO(((com.tencent.mm.live.a)g.ad(com.tencent.mm.live.a.class)).getLivingRoomId()))) {
        break label309;
      }
      localObject = this.context.getString(2131766728, new Object[] { Integer.valueOf(localLinkedList.size()) });
      if (this.JuJ.getVisibility() != 0) {
        break label298;
      }
      this.JuM.setText((CharSequence)localObject);
      acm(localLinkedList.size());
      setRootTipsBarBackground(true);
      this.JuH.JuY.notifyDataSetChanged();
    }
    for (;;)
    {
      setVisibility(0);
      AppMethodBeat.o(186981);
      return;
      label286:
      localObject = Integer.valueOf(localLinkedList.size());
      break;
      label298:
      this.JuM.setText((CharSequence)localObject);
      continue;
      label309:
      localObject = this.context.getString(2131766729, new Object[] { Integer.valueOf(localLinkedList.size()) });
      if (this.JuJ.getVisibility() == 0)
      {
        this.JuM.setText((CharSequence)localObject);
        acm(localLinkedList.size());
        setRootTipsBarBackground(true);
        this.JuH.JuY.notifyDataSetChanged();
      }
      else
      {
        this.JuM.setText((CharSequence)localObject);
      }
    }
  }
  
  public void setChattingContext(com.tencent.mm.ui.chatting.e.a parama)
  {
    this.JuR = parama;
  }
  
  public void setChattingUserName(String paramString)
  {
    if (this.JuH != null) {
      this.JuH.gJi = paramString;
    }
  }
  
  public void setInChatRoom(boolean paramBoolean)
  {
    this.JuU = paramBoolean;
  }
  
  public void setRootTipsBarBackground(View paramView)
  {
    this.JuQ = paramView;
  }
  
  public void setRootTipsBarBackground(boolean paramBoolean)
  {
    AppMethodBeat.i(186984);
    if (this.JuQ != null) {
      if (paramBoolean)
      {
        this.JuQ.setVisibility(0);
        this.JuQ.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(186975);
            b localb = new b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/LiveTalkRoomTipsBar$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            LiveTalkRoomTipsBar.a(LiveTalkRoomTipsBar.this, true);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LiveTalkRoomTipsBar$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(186975);
          }
        });
        if (this.mOh != null) {
          this.mOh.setVisibility(8);
        }
        if (this.JuS != null) {
          this.JuS.setVisibility(4);
        }
        if (this.JuT != null) {
          this.JuT.setBackgroundColor(0);
        }
        if (this.JuK != null)
        {
          this.JuK.setVisibility(0);
          AppMethodBeat.o(186984);
        }
      }
      else
      {
        this.JuQ.setVisibility(8);
        if (this.mOh != null) {
          this.mOh.setVisibility(0);
        }
        if (this.JuS != null) {
          this.JuS.setVisibility(0);
        }
        if (this.JuT != null) {
          this.JuT.setBackgroundResource(2131234968);
        }
        if (this.JuK != null) {
          this.JuK.setVisibility(8);
        }
      }
    }
    AppMethodBeat.o(186984);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.LiveTalkRoomTipsBar
 * JD-Core Version:    0.7.0.1
 */