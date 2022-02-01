package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bh.f;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.multitalk.d.e;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MultiTalkRoomPopupNav
  extends LinearLayout
{
  private View CbM;
  private View JuQ;
  private com.tencent.mm.ui.chatting.e.a JuR;
  private WeImageView JuS;
  private boolean JuU;
  private LinearLayout JyL;
  private View JyM;
  private TextView JyN;
  private TextView JyO;
  private TextView JyP;
  private String JyQ;
  private String JyR;
  private b JyS;
  public a JyT;
  private final int JyU;
  private LinearLayout JyV;
  private LinearLayout JyW;
  private LinearLayout JyX;
  public boolean JyY;
  private f JyZ;
  private int Jza;
  private View mOh;
  
  public MultiTalkRoomPopupNav(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(33620);
    this.JyS = b.Jzg;
    this.JyU = 6;
    this.JyY = false;
    this.JyZ = new f();
    initView();
    AppMethodBeat.o(33620);
  }
  
  @TargetApi(11)
  public MultiTalkRoomPopupNav(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(33619);
    this.JyS = b.Jzg;
    this.JyU = 6;
    this.JyY = false;
    this.JyZ = new f();
    initView();
    AppMethodBeat.o(33619);
  }
  
  private void d(String paramString1, List<String> paramList, final String paramString2)
  {
    AppMethodBeat.i(33627);
    this.JyL.setBackgroundColor(0);
    this.JuS.setVisibility(4);
    Object localObject = b.Jze;
    this.JyT = new a((byte)0);
    localObject = this.JyT;
    View.OnClickListener local2 = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33612);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/MultiTalkRoomPopupNav$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        ae.i("MicroMsg.MultiTalkRoomPopupNav", "click enter button..");
        if (paramString2 != null)
        {
          if (((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.d.class)).dsi())
          {
            ae.e("MicroMsg.MultiTalkRoomPopupNav", "now is in other voip..");
            h.c(MultiTalkRoomPopupNav.this.getContext(), ak.getContext().getString(2131761418), null, true);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MultiTalkRoomPopupNav$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(33612);
            return;
          }
          paramAnonymousView = ((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.d.class)).asr(MultiTalkRoomPopupNav.b(MultiTalkRoomPopupNav.this));
          if (paramAnonymousView.size() != 1) {
            break label307;
          }
          MultiTalkRoomPopupNav.aWV(paramString2);
          com.tencent.mm.plugin.report.service.g.yxI.f(13945, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), MultiTalkRoomPopupNav.b(MultiTalkRoomPopupNav.this), Integer.valueOf(MultiTalkRoomPopupNav.c(MultiTalkRoomPopupNav.this).field_roomId), Long.valueOf(MultiTalkRoomPopupNav.c(MultiTalkRoomPopupNav.this).field_roomKey) });
        }
        for (;;)
        {
          MultiTalkRoomPopupNav.e(MultiTalkRoomPopupNav.this).close();
          MultiTalkRoomPopupNav.f(MultiTalkRoomPopupNav.this).setVisibility(0);
          MultiTalkRoomPopupNav.f(MultiTalkRoomPopupNav.this).setBackgroundResource(2131234968);
          MultiTalkRoomPopupNav.g(MultiTalkRoomPopupNav.this).setVisibility(0);
          MultiTalkRoomPopupNav.h(MultiTalkRoomPopupNav.this).setVisibility(8);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MultiTalkRoomPopupNav$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(33612);
          return;
          label307:
          int i;
          if (paramAnonymousView.size() >= e.duB())
          {
            ae.e("MicroMsg.MultiTalkRoomPopupNav", "now is up to the limit,memberList size:" + paramAnonymousView.size());
            h.c(MultiTalkRoomPopupNav.this.getContext(), ak.getContext().getString(2131761424, new Object[] { Integer.valueOf(e.duB()) }), null, true);
            paramAnonymousView = com.tencent.mm.plugin.report.service.g.yxI;
            if (MultiTalkRoomPopupNav.d(MultiTalkRoomPopupNav.this) == MultiTalkRoomPopupNav.b.Jze) {}
            for (i = 1;; i = 0)
            {
              paramAnonymousView.f(13945, new Object[] { Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(1), MultiTalkRoomPopupNav.b(MultiTalkRoomPopupNav.this), Integer.valueOf(MultiTalkRoomPopupNav.c(MultiTalkRoomPopupNav.this).field_roomId), Long.valueOf(MultiTalkRoomPopupNav.c(MultiTalkRoomPopupNav.this).field_roomKey) });
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MultiTalkRoomPopupNav$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(33612);
              return;
            }
          }
          if (((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.d.class)).dsh())
          {
            ae.e("MicroMsg.MultiTalkRoomPopupNav", "now is inviting other people voip..");
            h.c(MultiTalkRoomPopupNav.this.getContext(), ak.getContext().getString(2131761416), null, true);
            paramAnonymousView = com.tencent.mm.plugin.report.service.g.yxI;
            if (MultiTalkRoomPopupNav.d(MultiTalkRoomPopupNav.this) == MultiTalkRoomPopupNav.b.Jze) {}
            for (i = 1;; i = 0)
            {
              paramAnonymousView.f(13945, new Object[] { Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(1), MultiTalkRoomPopupNav.b(MultiTalkRoomPopupNav.this), Integer.valueOf(MultiTalkRoomPopupNav.c(MultiTalkRoomPopupNav.this).field_roomId), Long.valueOf(MultiTalkRoomPopupNav.c(MultiTalkRoomPopupNav.this).field_roomKey) });
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MultiTalkRoomPopupNav$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(33612);
              return;
            }
          }
          MultiTalkRoomPopupNav.a(MultiTalkRoomPopupNav.this, paramString2);
        }
      }
    };
    paramString2 = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33613);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/MultiTalkRoomPopupNav$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        ae.i("MicroMsg.MultiTalkRoomPopupNav", "click cancel button..");
        int i;
        if (MultiTalkRoomPopupNav.d(MultiTalkRoomPopupNav.this) == MultiTalkRoomPopupNav.b.Jze)
        {
          ae.i("MicroMsg.MultiTalkRoomPopupNav", "reject multiTalk!");
          boolean bool = ((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.d.class)).asw(paramString2);
          ((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.d.class)).asx(paramString2);
          paramAnonymousView = com.tencent.mm.plugin.report.service.g.yxI;
          if (bool)
          {
            i = 0;
            paramAnonymousView.f(13945, new Object[] { Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(i), MultiTalkRoomPopupNav.b(MultiTalkRoomPopupNav.this), Integer.valueOf(MultiTalkRoomPopupNav.c(MultiTalkRoomPopupNav.this).field_roomId), Long.valueOf(MultiTalkRoomPopupNav.c(MultiTalkRoomPopupNav.this).field_roomKey) });
          }
        }
        for (;;)
        {
          MultiTalkRoomPopupNav.e(MultiTalkRoomPopupNav.this).close();
          MultiTalkRoomPopupNav.f(MultiTalkRoomPopupNav.this).setVisibility(0);
          MultiTalkRoomPopupNav.f(MultiTalkRoomPopupNav.this).setBackgroundResource(2131234968);
          MultiTalkRoomPopupNav.g(MultiTalkRoomPopupNav.this).setVisibility(0);
          MultiTalkRoomPopupNav.h(MultiTalkRoomPopupNav.this).setVisibility(8);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MultiTalkRoomPopupNav$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(33613);
          return;
          i = 1;
          break;
          com.tencent.mm.plugin.report.service.g.yxI.f(13945, new Object[] { Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), MultiTalkRoomPopupNav.b(MultiTalkRoomPopupNav.this), Integer.valueOf(MultiTalkRoomPopupNav.c(MultiTalkRoomPopupNav.this).field_roomId), Long.valueOf(MultiTalkRoomPopupNav.c(MultiTalkRoomPopupNav.this).field_roomKey) });
        }
      }
    };
    ((a)localObject).titleView.setText(paramString1);
    if (((a)localObject).Jzc.getVisibility() != 0)
    {
      ((a)localObject).Jzc.setVisibility(0);
      ((a)localObject).Jzc.startAnimation(AnimationUtils.loadAnimation(((a)localObject).Jzb.getContext(), 2130772105));
      ((a)localObject).Jzb.xz(true);
      if (((a)localObject).Jzb.JuQ != null) {
        ((a)localObject).Jzb.JuQ.startAnimation(AnimationUtils.loadAnimation(((a)localObject).Jzb.getContext(), 2130772047));
      }
    }
    ((a)localObject).Jzb.JyV.setVisibility(0);
    ((a)localObject).Jzb.JyV.removeAllViews();
    if (paramList != null)
    {
      if (paramList.size() > ((a)localObject).Jzb.Jza)
      {
        ((a)localObject).Jzb.JyW.setVisibility(0);
        ((a)localObject).Jzb.JyW.removeAllViews();
      }
      if (paramList.size() > ((a)localObject).Jzb.Jza * 2)
      {
        ((a)localObject).Jzb.JyX.setVisibility(0);
        ((a)localObject).Jzb.JyX.removeAllViews();
      }
    }
    paramString1 = paramList.iterator();
    int i = 0;
    if (paramString1.hasNext())
    {
      paramList = (String)paramString1.next();
      ImageView localImageView = new ImageView(((a)localObject).Jzb.getContext());
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 40), com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 40));
      localLayoutParams.rightMargin = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 8);
      localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      localImageView.setLayoutParams(localLayoutParams);
      if (i < ((a)localObject).Jzb.Jza) {
        ((a)localObject).Jzb.JyV.addView(localImageView);
      }
      for (;;)
      {
        a.b.c(localImageView, paramList);
        i += 1;
        break;
        if ((i >= ((a)localObject).Jzb.Jza) && (i < ((a)localObject).Jzb.Jza * 2)) {
          ((a)localObject).Jzb.JyW.addView(localImageView);
        } else if ((i >= ((a)localObject).Jzb.Jza * 2) && (i < ((a)localObject).Jzb.Jza * 3)) {
          ((a)localObject).Jzb.JyX.addView(localImageView);
        }
      }
    }
    ((Button)((a)localObject).Jzb.findViewById(2131302574)).setOnClickListener(local2);
    ((a)localObject).yAd.setOnClickListener(paramString2);
    if (((a)localObject).Jzb.JuQ != null) {
      ((a)localObject).Jzb.JuQ.setOnClickListener(paramString2);
    }
    AppMethodBeat.o(33627);
  }
  
  private void hY(List<String> paramList)
  {
    int k = 0;
    AppMethodBeat.i(33628);
    if ((this.JyV != null) && (this.JyV.getVisibility() == 0)) {
      this.JyV.removeAllViews();
    }
    for (int j = 1;; j = 0)
    {
      int i = j;
      if (this.JyW != null)
      {
        i = j;
        if (this.JyW.getVisibility() == 0)
        {
          this.JyW.removeAllViews();
          i = 1;
        }
      }
      j = i;
      if (this.JyX != null)
      {
        j = i;
        if (this.JyX.getVisibility() == 0)
        {
          this.JyX.removeAllViews();
          j = 1;
        }
      }
      if (j != 0)
      {
        paramList = paramList.iterator();
        i = k;
        if (paramList.hasNext())
        {
          String str = (String)paramList.next();
          ImageView localImageView = new ImageView(getContext());
          LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 40), com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 40));
          localLayoutParams.rightMargin = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 8);
          localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
          localImageView.setLayoutParams(localLayoutParams);
          if (i < this.Jza) {
            this.JyV.addView(localImageView);
          }
          for (;;)
          {
            a.b.c(localImageView, str);
            i += 1;
            break;
            if ((i >= this.Jza) && (i < this.Jza * 2)) {
              this.JyW.addView(localImageView);
            } else if ((i >= this.Jza * 2) && (i < this.Jza * 3)) {
              this.JyX.addView(localImageView);
            }
          }
        }
      }
      AppMethodBeat.o(33628);
      return;
    }
  }
  
  private void initView()
  {
    AppMethodBeat.i(33621);
    inflate(getContext(), 2131494977, this);
    this.CbM = findViewById(2131307946);
    this.mOh = findViewById(2131297453);
    this.JyL = ((LinearLayout)findViewById(2131302587));
    this.JyN = ((TextView)findViewById(2131302591));
    this.JyO = ((TextView)findViewById(2131302592));
    this.JyP = ((TextView)findViewById(2131302593));
    this.JyV = ((LinearLayout)findViewById(2131302580));
    this.JyW = ((LinearLayout)findViewById(2131307879));
    this.JyX = ((LinearLayout)findViewById(2131307878));
    this.JuS = ((WeImageView)findViewById(2131296937));
    this.JyL.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33611);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/MultiTalkRoomPopupNav$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if ((com.tencent.mm.bi.d.iuo != null) && (((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.d.class)).ch(MultiTalkRoomPopupNav.this.getContext())))
        {
          ae.d("MicroMsg.MultiTalkRoomPopupNav", "is voip talking");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MultiTalkRoomPopupNav$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(33611);
          return;
        }
        if ((com.tencent.mm.bi.d.iuo != null) && (com.tencent.mm.bi.d.iuo.aMI()))
        {
          Toast.makeText(ak.getContext(), ak.getContext().getString(2131760332), 0).show();
          ae.d("MicroMsg.MultiTalkRoomPopupNav", "is show loation");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MultiTalkRoomPopupNav$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(33611);
          return;
        }
        MultiTalkRoomPopupNav.a(MultiTalkRoomPopupNav.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MultiTalkRoomPopupNav$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(33611);
      }
    });
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)ak.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    this.Jza = ((int)Math.floor((localDisplayMetrics.widthPixels - aq.fromDPToPix(getContext(), 56)) / aq.fromDPToPix(getContext(), 48)));
    AppMethodBeat.o(33621);
  }
  
  private static List<String> s(List<String> paramList, String paramString)
  {
    AppMethodBeat.i(33629);
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    Object localObject = paramList;
    if (paramString != null)
    {
      localObject = paramList;
      if (paramString != "")
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject = (String)paramList.next();
          if ((localObject != null) && (!((String)localObject).equals(paramString))) {
            localArrayList1.add(localObject);
          }
        }
        localObject = localArrayList1;
      }
    }
    paramList = ((List)localObject).iterator();
    while (paramList.hasNext()) {
      localArrayList2.add((String)paramList.next());
    }
    AppMethodBeat.o(33629);
    return localArrayList2;
  }
  
  private void setDefaultBannerStyle(String paramString)
  {
    AppMethodBeat.i(33625);
    this.JyN.setTextColor(getResources().getColor(2131100685));
    this.JyN.setText(paramString);
    if ((this.JyV == null) || (this.JyV.getVisibility() != 0))
    {
      this.JyN.setVisibility(0);
      this.JyP.setVisibility(8);
      this.JyO.setVisibility(8);
      this.JyV.setVisibility(8);
    }
    AppMethodBeat.o(33625);
  }
  
  private void setInvitingBannerStyle(String paramString)
  {
    AppMethodBeat.i(33624);
    this.JyO.setTextColor(getResources().getColor(2131100685));
    this.JyO.setText(paramString);
    this.JyN.setVisibility(8);
    this.JyP.setVisibility(0);
    this.JyO.setVisibility(0);
    this.JyV.setVisibility(8);
    AppMethodBeat.o(33624);
  }
  
  private void setInvitingBannerStyleWithText(String paramString)
  {
    AppMethodBeat.i(187020);
    this.JyM.setBackgroundResource(2131233389);
    this.JyN.setVisibility(8);
    this.JyP.setVisibility(0);
    this.JyP.setText(paramString);
    this.JyO.setVisibility(0);
    this.JyV.setVisibility(8);
    AppMethodBeat.o(187020);
  }
  
  private void setTalkingBannerStyle(String paramString)
  {
    AppMethodBeat.i(33623);
    this.JyN.setTextColor(getResources().getColor(2131100687));
    this.JyN.setText(paramString);
    this.JyN.setVisibility(0);
    this.JyP.setVisibility(8);
    this.JyO.setVisibility(8);
    AppMethodBeat.o(33623);
  }
  
  private void xz(boolean paramBoolean)
  {
    AppMethodBeat.i(187019);
    if (this.JuQ != null) {
      if (paramBoolean)
      {
        this.JuQ.setVisibility(0);
        if (this.mOh != null) {
          this.mOh.setVisibility(8);
        }
        if (this.JyL != null) {
          this.JyL.setBackgroundColor(0);
        }
        if (this.JuS != null) {
          this.JuS.setVisibility(4);
        }
        if (this.JuR != null)
        {
          this.JuR.hideVKB();
          AppMethodBeat.o(187019);
        }
      }
      else
      {
        this.JuQ.setVisibility(8);
        if (this.mOh != null) {
          this.mOh.setVisibility(0);
        }
        if (this.JyL != null) {
          this.JyL.setBackgroundResource(2131234968);
        }
        if (this.JuS != null) {
          this.JuS.setVisibility(0);
        }
      }
    }
    AppMethodBeat.o(187019);
  }
  
  public final void fBz()
  {
    AppMethodBeat.i(33626);
    this.JyY = false;
    setVisibility(8);
    if (this.JyT != null) {
      this.JyT.close();
    }
    AppMethodBeat.o(33626);
  }
  
  public void setChattingContext(com.tencent.mm.ui.chatting.e.a parama)
  {
    this.JuR = parama;
  }
  
  public void setCurrentSenderUserName(String paramString)
  {
    this.JyR = paramString;
  }
  
  public void setGroupUserName(String paramString)
  {
    this.JyQ = paramString;
  }
  
  public void setInChatRoom(boolean paramBoolean)
  {
    this.JuU = paramBoolean;
  }
  
  public void setMultiTalkInfo(f paramf)
  {
    this.JyZ = paramf;
  }
  
  public void setRootTipsBarBackground(View paramView)
  {
    this.JuQ = paramView;
  }
  
  public void setUserTalkingStatus(b paramb)
  {
    this.JyS = paramb;
  }
  
  public final void xA(boolean paramBoolean)
  {
    AppMethodBeat.i(33622);
    this.JyY = false;
    if ((this.JyQ == null) || (this.JyR == null))
    {
      ae.e("MicroMsg.MultiTalkRoomPopupNav", "groupUserName or currentSenderUserName is null! groupUserName:" + this.JyQ + ",currentSenderUserName:" + this.JyR);
      AppMethodBeat.o(33622);
      return;
    }
    Object localObject = this.JyQ;
    if (!((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.d.class)).aso((String)localObject))
    {
      fBz();
      AppMethodBeat.o(33622);
      return;
    }
    List localList = ((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.d.class)).asr((String)localObject);
    if (localList.size() == 0)
    {
      ((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.d.class)).Dc((String)localObject);
      fBz();
      AppMethodBeat.o(33622);
      return;
    }
    int i = ((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.d.class)).id((String)localObject, this.JyR);
    String str;
    if (i == 1)
    {
      setUserTalkingStatus(b.Jze);
      if (((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.d.class)).ass((String)localObject))
      {
        fBz();
        AppMethodBeat.o(33622);
        return;
      }
      str = e.duF();
      if (str == null) {
        setInvitingBannerStyle(((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.d.class)).zP(((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.d.class)).ie((String)localObject, this.JyR)));
      }
    }
    for (;;)
    {
      setVisibility(0);
      this.JyL.setVisibility(0);
      if ((this.JyT != null) && ((paramBoolean) || (this.JyV == null) || (this.JyV.getVisibility() != 0))) {
        this.JyT.close();
      }
      hY(s(localList, ""));
      if ((this.JyT == null) || (this.JyT.Jzc == null)) {
        break label551;
      }
      if (this.JyT.Jzc.getVisibility() != 0) {
        break;
      }
      xz(true);
      AppMethodBeat.o(33622);
      return;
      setInvitingBannerStyleWithText(str);
      continue;
      if (i == 10)
      {
        setUserTalkingStatus(b.Jzf);
        if (((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.d.class)).ass((String)localObject))
        {
          fBz();
          AppMethodBeat.o(33622);
          return;
        }
        if (((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.d.class)).dsk())
        {
          fBz();
          AppMethodBeat.o(33622);
          return;
        }
        str = e.duH();
        setUserTalkingStatus(b.Jzg);
        localObject = str;
        if (str == null) {
          localObject = ak.getContext().getString(2131761440, new Object[] { Integer.valueOf(localList.size()) });
        }
        setDefaultBannerStyle((String)localObject);
      }
      else
      {
        setUserTalkingStatus(b.Jzg);
        str = e.duH();
        localObject = str;
        if (str == null) {
          localObject = ak.getContext().getString(2131761440, new Object[] { Integer.valueOf(localList.size()) });
        }
        setDefaultBannerStyle((String)localObject);
      }
    }
    xz(false);
    label551:
    AppMethodBeat.o(33622);
  }
  
  public final class a
  {
    public LinearLayout Jzc;
    TextView titleView;
    View yAd;
    
    private a()
    {
      AppMethodBeat.i(187018);
      this.yAd = MultiTalkRoomPopupNav.this.findViewById(2131298372);
      this.titleView = ((TextView)MultiTalkRoomPopupNav.this.findViewById(2131302590));
      this.Jzc = ((LinearLayout)MultiTalkRoomPopupNav.this.findViewById(2131307318));
      AppMethodBeat.o(187018);
    }
    
    public final void close()
    {
      AppMethodBeat.i(33615);
      MultiTalkRoomPopupNav.i(MultiTalkRoomPopupNav.this);
      if (this.Jzc.getVisibility() == 0)
      {
        Animation localAnimation = AnimationUtils.loadAnimation(MultiTalkRoomPopupNav.this.getContext(), 2130772109);
        localAnimation.setAnimationListener(new Animation.AnimationListener()
        {
          public final void onAnimationEnd(Animation paramAnonymousAnimation)
          {
            AppMethodBeat.i(187017);
            MultiTalkRoomPopupNav.a.this.Jzc.setVisibility(8);
            AppMethodBeat.o(187017);
          }
          
          public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
          
          public final void onAnimationStart(Animation paramAnonymousAnimation) {}
        });
        this.Jzc.startAnimation(localAnimation);
      }
      AppMethodBeat.o(33615);
    }
  }
  
  static enum b
  {
    static
    {
      AppMethodBeat.i(33618);
      Jze = new b("Inviting", 0);
      Jzf = new b("Talking", 1);
      Jzg = new b("NotInTalking", 2);
      Jzh = new b[] { Jze, Jzf, Jzg };
      AppMethodBeat.o(33618);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.MultiTalkRoomPopupNav
 * JD-Core Version:    0.7.0.1
 */