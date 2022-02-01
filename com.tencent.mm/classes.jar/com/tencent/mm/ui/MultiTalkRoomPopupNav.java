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
import com.tencent.mm.bi.f;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.multitalk.c.e;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MultiTalkRoomPopupNav
  extends LinearLayout
{
  private View BKn;
  private View Jai;
  private com.tencent.mm.ui.chatting.e.a Jaj;
  private WeImageView Jak;
  private boolean Jam;
  private LinearLayout Jea;
  private View Jeb;
  private TextView Jec;
  private TextView Jed;
  private TextView Jee;
  private String Jef;
  private String Jeg;
  private MultiTalkRoomPopupNav.b Jeh;
  public a Jei;
  private final int Jej;
  private LinearLayout Jek;
  private LinearLayout Jel;
  private LinearLayout Jem;
  public boolean Jen;
  private f Jeo;
  private int Jep;
  private View mJf;
  
  public MultiTalkRoomPopupNav(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(33620);
    this.Jeh = MultiTalkRoomPopupNav.b.Jev;
    this.Jej = 6;
    this.Jen = false;
    this.Jeo = new f();
    initView();
    AppMethodBeat.o(33620);
  }
  
  @TargetApi(11)
  public MultiTalkRoomPopupNav(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(33619);
    this.Jeh = MultiTalkRoomPopupNav.b.Jev;
    this.Jej = 6;
    this.Jen = false;
    this.Jeo = new f();
    initView();
    AppMethodBeat.o(33619);
  }
  
  private void d(String paramString1, List<String> paramList, final String paramString2)
  {
    AppMethodBeat.i(33627);
    this.Jea.setBackgroundColor(0);
    this.Jak.setVisibility(4);
    Object localObject = MultiTalkRoomPopupNav.b.Jet;
    this.Jei = new a((byte)0);
    localObject = this.Jei;
    View.OnClickListener local2 = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33612);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/MultiTalkRoomPopupNav$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        ad.i("MicroMsg.MultiTalkRoomPopupNav", "click enter button..");
        if (paramString2 != null)
        {
          if (((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.d.class)).doY())
          {
            ad.e("MicroMsg.MultiTalkRoomPopupNav", "now is in other voip..");
            h.c(MultiTalkRoomPopupNav.this.getContext(), aj.getContext().getString(2131761418), null, true);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MultiTalkRoomPopupNav$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(33612);
            return;
          }
          paramAnonymousView = ((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.d.class)).arj(MultiTalkRoomPopupNav.b(MultiTalkRoomPopupNav.this));
          if (paramAnonymousView.size() != 1) {
            break label307;
          }
          MultiTalkRoomPopupNav.aVu(paramString2);
          com.tencent.mm.plugin.report.service.g.yhR.f(13945, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), MultiTalkRoomPopupNav.b(MultiTalkRoomPopupNav.this), Integer.valueOf(MultiTalkRoomPopupNav.c(MultiTalkRoomPopupNav.this).field_roomId), Long.valueOf(MultiTalkRoomPopupNav.c(MultiTalkRoomPopupNav.this).field_roomKey) });
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
          if (paramAnonymousView.size() >= e.drp())
          {
            ad.e("MicroMsg.MultiTalkRoomPopupNav", "now is up to the limit,memberList size:" + paramAnonymousView.size());
            h.c(MultiTalkRoomPopupNav.this.getContext(), aj.getContext().getString(2131761424, new Object[] { Integer.valueOf(e.drp()) }), null, true);
            paramAnonymousView = com.tencent.mm.plugin.report.service.g.yhR;
            if (MultiTalkRoomPopupNav.d(MultiTalkRoomPopupNav.this) == MultiTalkRoomPopupNav.b.Jet) {}
            for (i = 1;; i = 0)
            {
              paramAnonymousView.f(13945, new Object[] { Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(1), MultiTalkRoomPopupNav.b(MultiTalkRoomPopupNav.this), Integer.valueOf(MultiTalkRoomPopupNav.c(MultiTalkRoomPopupNav.this).field_roomId), Long.valueOf(MultiTalkRoomPopupNav.c(MultiTalkRoomPopupNav.this).field_roomKey) });
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MultiTalkRoomPopupNav$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(33612);
              return;
            }
          }
          if (((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.d.class)).doX())
          {
            ad.e("MicroMsg.MultiTalkRoomPopupNav", "now is inviting other people voip..");
            h.c(MultiTalkRoomPopupNav.this.getContext(), aj.getContext().getString(2131761416), null, true);
            paramAnonymousView = com.tencent.mm.plugin.report.service.g.yhR;
            if (MultiTalkRoomPopupNav.d(MultiTalkRoomPopupNav.this) == MultiTalkRoomPopupNav.b.Jet) {}
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
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/MultiTalkRoomPopupNav$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        ad.i("MicroMsg.MultiTalkRoomPopupNav", "click cancel button..");
        int i;
        if (MultiTalkRoomPopupNav.d(MultiTalkRoomPopupNav.this) == MultiTalkRoomPopupNav.b.Jet)
        {
          ad.i("MicroMsg.MultiTalkRoomPopupNav", "reject multiTalk!");
          boolean bool = ((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.d.class)).aro(paramString2);
          ((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.d.class)).arp(paramString2);
          paramAnonymousView = com.tencent.mm.plugin.report.service.g.yhR;
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
          com.tencent.mm.plugin.report.service.g.yhR.f(13945, new Object[] { Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), MultiTalkRoomPopupNav.b(MultiTalkRoomPopupNav.this), Integer.valueOf(MultiTalkRoomPopupNav.c(MultiTalkRoomPopupNav.this).field_roomId), Long.valueOf(MultiTalkRoomPopupNav.c(MultiTalkRoomPopupNav.this).field_roomKey) });
        }
      }
    };
    ((a)localObject).titleView.setText(paramString1);
    if (((a)localObject).Jer.getVisibility() != 0)
    {
      ((a)localObject).Jer.setVisibility(0);
      ((a)localObject).Jer.startAnimation(AnimationUtils.loadAnimation(((a)localObject).Jeq.getContext(), 2130772105));
      ((a)localObject).Jeq.xr(true);
      if (((a)localObject).Jeq.Jai != null) {
        ((a)localObject).Jeq.Jai.startAnimation(AnimationUtils.loadAnimation(((a)localObject).Jeq.getContext(), 2130772047));
      }
    }
    ((a)localObject).Jeq.Jek.setVisibility(0);
    ((a)localObject).Jeq.Jek.removeAllViews();
    if (paramList != null)
    {
      if (paramList.size() > ((a)localObject).Jeq.Jep)
      {
        ((a)localObject).Jeq.Jel.setVisibility(0);
        ((a)localObject).Jeq.Jel.removeAllViews();
      }
      if (paramList.size() > ((a)localObject).Jeq.Jep * 2)
      {
        ((a)localObject).Jeq.Jem.setVisibility(0);
        ((a)localObject).Jeq.Jem.removeAllViews();
      }
    }
    paramString1 = paramList.iterator();
    int i = 0;
    if (paramString1.hasNext())
    {
      paramList = (String)paramString1.next();
      ImageView localImageView = new ImageView(((a)localObject).Jeq.getContext());
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 40), com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 40));
      localLayoutParams.rightMargin = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 8);
      localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      localImageView.setLayoutParams(localLayoutParams);
      if (i < ((a)localObject).Jeq.Jep) {
        ((a)localObject).Jeq.Jek.addView(localImageView);
      }
      for (;;)
      {
        a.b.c(localImageView, paramList);
        i += 1;
        break;
        if ((i >= ((a)localObject).Jeq.Jep) && (i < ((a)localObject).Jeq.Jep * 2)) {
          ((a)localObject).Jeq.Jel.addView(localImageView);
        } else if ((i >= ((a)localObject).Jeq.Jep * 2) && (i < ((a)localObject).Jeq.Jep * 3)) {
          ((a)localObject).Jeq.Jem.addView(localImageView);
        }
      }
    }
    ((Button)((a)localObject).Jeq.findViewById(2131302574)).setOnClickListener(local2);
    ((a)localObject).yke.setOnClickListener(paramString2);
    if (((a)localObject).Jeq.Jai != null) {
      ((a)localObject).Jeq.Jai.setOnClickListener(paramString2);
    }
    AppMethodBeat.o(33627);
  }
  
  private void hO(List<String> paramList)
  {
    int k = 0;
    AppMethodBeat.i(33628);
    if ((this.Jek != null) && (this.Jek.getVisibility() == 0)) {
      this.Jek.removeAllViews();
    }
    for (int j = 1;; j = 0)
    {
      int i = j;
      if (this.Jel != null)
      {
        i = j;
        if (this.Jel.getVisibility() == 0)
        {
          this.Jel.removeAllViews();
          i = 1;
        }
      }
      j = i;
      if (this.Jem != null)
      {
        j = i;
        if (this.Jem.getVisibility() == 0)
        {
          this.Jem.removeAllViews();
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
          LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 40), com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 40));
          localLayoutParams.rightMargin = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 8);
          localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
          localImageView.setLayoutParams(localLayoutParams);
          if (i < this.Jep) {
            this.Jek.addView(localImageView);
          }
          for (;;)
          {
            a.b.c(localImageView, str);
            i += 1;
            break;
            if ((i >= this.Jep) && (i < this.Jep * 2)) {
              this.Jel.addView(localImageView);
            } else if ((i >= this.Jep * 2) && (i < this.Jep * 3)) {
              this.Jem.addView(localImageView);
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
    this.BKn = findViewById(2131307946);
    this.mJf = findViewById(2131297453);
    this.Jea = ((LinearLayout)findViewById(2131302587));
    this.Jec = ((TextView)findViewById(2131302591));
    this.Jed = ((TextView)findViewById(2131302592));
    this.Jee = ((TextView)findViewById(2131302593));
    this.Jek = ((LinearLayout)findViewById(2131302580));
    this.Jel = ((LinearLayout)findViewById(2131307879));
    this.Jem = ((LinearLayout)findViewById(2131307878));
    this.Jak = ((WeImageView)findViewById(2131296937));
    this.Jea.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33611);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/MultiTalkRoomPopupNav$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if ((com.tencent.mm.bj.d.iru != null) && (((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.d.class)).cf(MultiTalkRoomPopupNav.this.getContext())))
        {
          ad.d("MicroMsg.MultiTalkRoomPopupNav", "is voip talking");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MultiTalkRoomPopupNav$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(33611);
          return;
        }
        if ((com.tencent.mm.bj.d.iru != null) && (com.tencent.mm.bj.d.iru.aMk()))
        {
          Toast.makeText(aj.getContext(), aj.getContext().getString(2131760332), 0).show();
          ad.d("MicroMsg.MultiTalkRoomPopupNav", "is show loation");
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
    ((WindowManager)aj.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    this.Jep = ((int)Math.floor((localDisplayMetrics.widthPixels - aq.fromDPToPix(getContext(), 56)) / aq.fromDPToPix(getContext(), 48)));
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
    this.Jec.setTextColor(getResources().getColor(2131100685));
    this.Jec.setText(paramString);
    if ((this.Jek == null) || (this.Jek.getVisibility() != 0))
    {
      this.Jec.setVisibility(0);
      this.Jee.setVisibility(8);
      this.Jed.setVisibility(8);
      this.Jek.setVisibility(8);
    }
    AppMethodBeat.o(33625);
  }
  
  private void setInvitingBannerStyle(String paramString)
  {
    AppMethodBeat.i(33624);
    this.Jed.setTextColor(getResources().getColor(2131100685));
    this.Jed.setText(paramString);
    this.Jec.setVisibility(8);
    this.Jee.setVisibility(0);
    this.Jed.setVisibility(0);
    this.Jek.setVisibility(8);
    AppMethodBeat.o(33624);
  }
  
  private void setInvitingBannerStyleWithText(String paramString)
  {
    AppMethodBeat.i(193729);
    this.Jeb.setBackgroundResource(2131233389);
    this.Jec.setVisibility(8);
    this.Jee.setVisibility(0);
    this.Jee.setText(paramString);
    this.Jed.setVisibility(0);
    this.Jek.setVisibility(8);
    AppMethodBeat.o(193729);
  }
  
  private void setTalkingBannerStyle(String paramString)
  {
    AppMethodBeat.i(33623);
    this.Jec.setTextColor(getResources().getColor(2131100687));
    this.Jec.setText(paramString);
    this.Jec.setVisibility(0);
    this.Jee.setVisibility(8);
    this.Jed.setVisibility(8);
    AppMethodBeat.o(33623);
  }
  
  private void xr(boolean paramBoolean)
  {
    AppMethodBeat.i(193728);
    if (this.Jai != null) {
      if (paramBoolean)
      {
        this.Jai.setVisibility(0);
        if (this.mJf != null) {
          this.mJf.setVisibility(8);
        }
        if (this.Jea != null) {
          this.Jea.setBackgroundColor(0);
        }
        if (this.Jak != null) {
          this.Jak.setVisibility(4);
        }
        if (this.Jaj != null)
        {
          this.Jaj.hideVKB();
          AppMethodBeat.o(193728);
        }
      }
      else
      {
        this.Jai.setVisibility(8);
        if (this.mJf != null) {
          this.mJf.setVisibility(0);
        }
        if (this.Jea != null) {
          this.Jea.setBackgroundResource(2131234968);
        }
        if (this.Jak != null) {
          this.Jak.setVisibility(0);
        }
      }
    }
    AppMethodBeat.o(193728);
  }
  
  public final void fxx()
  {
    AppMethodBeat.i(33626);
    this.Jen = false;
    setVisibility(8);
    if (this.Jei != null) {
      this.Jei.close();
    }
    AppMethodBeat.o(33626);
  }
  
  public void setChattingContext(com.tencent.mm.ui.chatting.e.a parama)
  {
    this.Jaj = parama;
  }
  
  public void setCurrentSenderUserName(String paramString)
  {
    this.Jeg = paramString;
  }
  
  public void setGroupUserName(String paramString)
  {
    this.Jef = paramString;
  }
  
  public void setInChatRoom(boolean paramBoolean)
  {
    this.Jam = paramBoolean;
  }
  
  public void setMultiTalkInfo(f paramf)
  {
    this.Jeo = paramf;
  }
  
  public void setRootTipsBarBackground(View paramView)
  {
    this.Jai = paramView;
  }
  
  public void setUserTalkingStatus(MultiTalkRoomPopupNav.b paramb)
  {
    this.Jeh = paramb;
  }
  
  public final void xs(boolean paramBoolean)
  {
    AppMethodBeat.i(33622);
    this.Jen = false;
    if ((this.Jef == null) || (this.Jeg == null))
    {
      ad.e("MicroMsg.MultiTalkRoomPopupNav", "groupUserName or currentSenderUserName is null! groupUserName:" + this.Jef + ",currentSenderUserName:" + this.Jeg);
      AppMethodBeat.o(33622);
      return;
    }
    Object localObject = this.Jef;
    if (!((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.d.class)).arg((String)localObject))
    {
      fxx();
      AppMethodBeat.o(33622);
      return;
    }
    List localList = ((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.d.class)).arj((String)localObject);
    if (localList.size() == 0)
    {
      ((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.d.class)).CA((String)localObject);
      fxx();
      AppMethodBeat.o(33622);
      return;
    }
    int i = ((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.d.class)).hX((String)localObject, this.Jeg);
    String str;
    if (i == 1)
    {
      setUserTalkingStatus(MultiTalkRoomPopupNav.b.Jet);
      if (((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.d.class)).ark((String)localObject))
      {
        fxx();
        AppMethodBeat.o(33622);
        return;
      }
      str = e.drt();
      if (str == null) {
        setInvitingBannerStyle(((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.d.class)).zf(((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.d.class)).hY((String)localObject, this.Jeg)));
      }
    }
    for (;;)
    {
      setVisibility(0);
      this.Jea.setVisibility(0);
      if ((this.Jei != null) && ((paramBoolean) || (this.Jek == null) || (this.Jek.getVisibility() != 0))) {
        this.Jei.close();
      }
      hO(s(localList, ""));
      if ((this.Jei == null) || (this.Jei.Jer == null)) {
        break label551;
      }
      if (this.Jei.Jer.getVisibility() != 0) {
        break;
      }
      xr(true);
      AppMethodBeat.o(33622);
      return;
      setInvitingBannerStyleWithText(str);
      continue;
      if (i == 10)
      {
        setUserTalkingStatus(MultiTalkRoomPopupNav.b.Jeu);
        if (((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.d.class)).ark((String)localObject))
        {
          fxx();
          AppMethodBeat.o(33622);
          return;
        }
        if (((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.d.class)).dpa())
        {
          fxx();
          AppMethodBeat.o(33622);
          return;
        }
        str = e.drv();
        setUserTalkingStatus(MultiTalkRoomPopupNav.b.Jev);
        localObject = str;
        if (str == null) {
          localObject = aj.getContext().getString(2131761440, new Object[] { Integer.valueOf(localList.size()) });
        }
        setDefaultBannerStyle((String)localObject);
      }
      else
      {
        setUserTalkingStatus(MultiTalkRoomPopupNav.b.Jev);
        str = e.drv();
        localObject = str;
        if (str == null) {
          localObject = aj.getContext().getString(2131761440, new Object[] { Integer.valueOf(localList.size()) });
        }
        setDefaultBannerStyle((String)localObject);
      }
    }
    xr(false);
    label551:
    AppMethodBeat.o(33622);
  }
  
  public final class a
  {
    public LinearLayout Jer;
    TextView titleView;
    View yke;
    
    private a()
    {
      AppMethodBeat.i(193727);
      this.yke = MultiTalkRoomPopupNav.this.findViewById(2131298372);
      this.titleView = ((TextView)MultiTalkRoomPopupNav.this.findViewById(2131302590));
      this.Jer = ((LinearLayout)MultiTalkRoomPopupNav.this.findViewById(2131307318));
      AppMethodBeat.o(193727);
    }
    
    public final void close()
    {
      AppMethodBeat.i(33615);
      MultiTalkRoomPopupNav.i(MultiTalkRoomPopupNav.this);
      if (this.Jer.getVisibility() == 0)
      {
        Animation localAnimation = AnimationUtils.loadAnimation(MultiTalkRoomPopupNav.this.getContext(), 2130772109);
        localAnimation.setAnimationListener(new Animation.AnimationListener()
        {
          public final void onAnimationEnd(Animation paramAnonymousAnimation)
          {
            AppMethodBeat.i(193726);
            MultiTalkRoomPopupNav.a.this.Jer.setVisibility(8);
            AppMethodBeat.o(193726);
          }
          
          public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
          
          public final void onAnimationStart(Animation paramAnonymousAnimation) {}
        });
        this.Jer.startAnimation(localAnimation);
      }
      AppMethodBeat.o(33615);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.MultiTalkRoomPopupNav
 * JD-Core Version:    0.7.0.1
 */