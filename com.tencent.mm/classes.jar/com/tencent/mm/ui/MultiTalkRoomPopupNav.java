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
import com.tencent.mm.bi.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.multitalk.c.c;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MultiTalkRoomPopupNav
  extends LinearLayout
{
  private View HmC;
  private com.tencent.mm.ui.chatting.d.a HmD;
  private boolean HmE;
  private View Hng;
  private String HqA;
  private b HqB;
  public a HqC;
  private final int HqD;
  private LinearLayout HqE;
  private LinearLayout HqF;
  private LinearLayout HqG;
  public boolean HqH;
  private f HqI;
  private int HqJ;
  private LinearLayout Hqu;
  private WeImageView Hqv;
  private TextView Hqw;
  private TextView Hqx;
  private TextView Hqy;
  private String Hqz;
  private View miE;
  
  public MultiTalkRoomPopupNav(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(33620);
    this.HqB = b.HqP;
    this.HqD = 6;
    this.HqH = false;
    this.HqI = new f();
    initView();
    AppMethodBeat.o(33620);
  }
  
  @TargetApi(11)
  public MultiTalkRoomPopupNav(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(33619);
    this.HqB = b.HqP;
    this.HqD = 6;
    this.HqH = false;
    this.HqI = new f();
    initView();
    AppMethodBeat.o(33619);
  }
  
  private void d(String paramString1, List<String> paramList, final String paramString2)
  {
    AppMethodBeat.i(33627);
    this.Hqu.setBackgroundColor(0);
    this.Hqv.setVisibility(4);
    Object localObject = b.HqN;
    this.HqC = new a((byte)0);
    localObject = this.HqC;
    View.OnClickListener local2 = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33612);
        ac.i("MicroMsg.MultiTalkRoomPopupNav", "click enter button..");
        if (paramString2 != null)
        {
          if (((com.tencent.mm.plugin.multitalk.model.a)g.ab(com.tencent.mm.plugin.multitalk.model.a.class)).dfm())
          {
            ac.e("MicroMsg.MultiTalkRoomPopupNav", "now is in other voip..");
            com.tencent.mm.ui.base.h.c(MultiTalkRoomPopupNav.this.getContext(), ai.getContext().getString(2131761418), null, true);
            AppMethodBeat.o(33612);
            return;
          }
          paramAnonymousView = ((com.tencent.mm.plugin.multitalk.model.a)g.ab(com.tencent.mm.plugin.multitalk.model.a.class)).amn(MultiTalkRoomPopupNav.b(MultiTalkRoomPopupNav.this));
          if (paramAnonymousView.size() != 1) {
            break label254;
          }
          MultiTalkRoomPopupNav.aPE(paramString2);
          com.tencent.mm.plugin.report.service.h.wUl.f(13945, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), MultiTalkRoomPopupNav.b(MultiTalkRoomPopupNav.this), Integer.valueOf(MultiTalkRoomPopupNav.c(MultiTalkRoomPopupNav.this).field_roomId), Long.valueOf(MultiTalkRoomPopupNav.c(MultiTalkRoomPopupNav.this).field_roomKey) });
        }
        for (;;)
        {
          MultiTalkRoomPopupNav.e(MultiTalkRoomPopupNav.this).close();
          MultiTalkRoomPopupNav.f(MultiTalkRoomPopupNav.this).setVisibility(0);
          MultiTalkRoomPopupNav.f(MultiTalkRoomPopupNav.this).setBackgroundResource(2131234968);
          MultiTalkRoomPopupNav.g(MultiTalkRoomPopupNav.this).setVisibility(0);
          MultiTalkRoomPopupNav.h(MultiTalkRoomPopupNav.this).setVisibility(8);
          AppMethodBeat.o(33612);
          return;
          label254:
          int i;
          if (paramAnonymousView.size() >= c.dhi())
          {
            ac.e("MicroMsg.MultiTalkRoomPopupNav", "now is up to the limit,memberList size:" + paramAnonymousView.size());
            com.tencent.mm.ui.base.h.c(MultiTalkRoomPopupNav.this.getContext(), ai.getContext().getString(2131761424, new Object[] { Integer.valueOf(c.dhi()) }), null, true);
            paramAnonymousView = com.tencent.mm.plugin.report.service.h.wUl;
            if (MultiTalkRoomPopupNav.d(MultiTalkRoomPopupNav.this) == MultiTalkRoomPopupNav.b.HqN) {}
            for (i = 1;; i = 0)
            {
              paramAnonymousView.f(13945, new Object[] { Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(1), MultiTalkRoomPopupNav.b(MultiTalkRoomPopupNav.this), Integer.valueOf(MultiTalkRoomPopupNav.c(MultiTalkRoomPopupNav.this).field_roomId), Long.valueOf(MultiTalkRoomPopupNav.c(MultiTalkRoomPopupNav.this).field_roomKey) });
              AppMethodBeat.o(33612);
              return;
            }
          }
          if (((com.tencent.mm.plugin.multitalk.model.a)g.ab(com.tencent.mm.plugin.multitalk.model.a.class)).dfl())
          {
            ac.e("MicroMsg.MultiTalkRoomPopupNav", "now is inviting other people voip..");
            com.tencent.mm.ui.base.h.c(MultiTalkRoomPopupNav.this.getContext(), ai.getContext().getString(2131761416), null, true);
            paramAnonymousView = com.tencent.mm.plugin.report.service.h.wUl;
            if (MultiTalkRoomPopupNav.d(MultiTalkRoomPopupNav.this) == MultiTalkRoomPopupNav.b.HqN) {}
            for (i = 1;; i = 0)
            {
              paramAnonymousView.f(13945, new Object[] { Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(1), MultiTalkRoomPopupNav.b(MultiTalkRoomPopupNav.this), Integer.valueOf(MultiTalkRoomPopupNav.c(MultiTalkRoomPopupNav.this).field_roomId), Long.valueOf(MultiTalkRoomPopupNav.c(MultiTalkRoomPopupNav.this).field_roomKey) });
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
        ac.i("MicroMsg.MultiTalkRoomPopupNav", "click cancel button..");
        int i;
        if (MultiTalkRoomPopupNav.d(MultiTalkRoomPopupNav.this) == MultiTalkRoomPopupNav.b.HqN)
        {
          ac.i("MicroMsg.MultiTalkRoomPopupNav", "reject multiTalk!");
          boolean bool = ((com.tencent.mm.plugin.multitalk.model.a)g.ab(com.tencent.mm.plugin.multitalk.model.a.class)).ams(paramString2);
          ((com.tencent.mm.plugin.multitalk.model.a)g.ab(com.tencent.mm.plugin.multitalk.model.a.class)).amt(paramString2);
          paramAnonymousView = com.tencent.mm.plugin.report.service.h.wUl;
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
          AppMethodBeat.o(33613);
          return;
          i = 1;
          break;
          com.tencent.mm.plugin.report.service.h.wUl.f(13945, new Object[] { Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), MultiTalkRoomPopupNav.b(MultiTalkRoomPopupNav.this), Integer.valueOf(MultiTalkRoomPopupNav.c(MultiTalkRoomPopupNav.this).field_roomId), Long.valueOf(MultiTalkRoomPopupNav.c(MultiTalkRoomPopupNav.this).field_roomKey) });
        }
      }
    };
    ((a)localObject).titleView.setText(paramString1);
    if (((a)localObject).HqL.getVisibility() != 0)
    {
      ((a)localObject).HqL.setVisibility(0);
      ((a)localObject).HqL.startAnimation(AnimationUtils.loadAnimation(((a)localObject).HqK.getContext(), 2130772105));
      ((a)localObject).HqK.wF(true);
      if (((a)localObject).HqK.HmC != null) {
        ((a)localObject).HqK.HmC.startAnimation(AnimationUtils.loadAnimation(((a)localObject).HqK.getContext(), 2130772047));
      }
    }
    ((a)localObject).HqK.HqE.setVisibility(0);
    ((a)localObject).HqK.HqE.removeAllViews();
    if (paramList != null)
    {
      if (paramList.size() > ((a)localObject).HqK.HqJ)
      {
        ((a)localObject).HqK.HqF.setVisibility(0);
        ((a)localObject).HqK.HqF.removeAllViews();
      }
      if (paramList.size() > ((a)localObject).HqK.HqJ * 2)
      {
        ((a)localObject).HqK.HqG.setVisibility(0);
        ((a)localObject).HqK.HqG.removeAllViews();
      }
    }
    paramString1 = paramList.iterator();
    int i = 0;
    if (paramString1.hasNext())
    {
      paramList = (String)paramString1.next();
      ImageView localImageView = new ImageView(((a)localObject).HqK.getContext());
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 40), com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 40));
      localLayoutParams.rightMargin = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 8);
      localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      localImageView.setLayoutParams(localLayoutParams);
      if (i < ((a)localObject).HqK.HqJ) {
        ((a)localObject).HqK.HqE.addView(localImageView);
      }
      for (;;)
      {
        a.b.c(localImageView, paramList);
        i += 1;
        break;
        if ((i >= ((a)localObject).HqK.HqJ) && (i < ((a)localObject).HqK.HqJ * 2)) {
          ((a)localObject).HqK.HqF.addView(localImageView);
        } else if ((i >= ((a)localObject).HqK.HqJ * 2) && (i < ((a)localObject).HqK.HqJ * 3)) {
          ((a)localObject).HqK.HqG.addView(localImageView);
        }
      }
    }
    ((Button)((a)localObject).HqK.findViewById(2131302574)).setOnClickListener(local2);
    ((a)localObject).wWt.setOnClickListener(paramString2);
    if (((a)localObject).HqK.HmC != null) {
      ((a)localObject).HqK.HmC.setOnClickListener(paramString2);
    }
    AppMethodBeat.o(33627);
  }
  
  private void hC(List<String> paramList)
  {
    int k = 0;
    AppMethodBeat.i(33628);
    if ((this.HqE != null) && (this.HqE.getVisibility() == 0)) {
      this.HqE.removeAllViews();
    }
    for (int j = 1;; j = 0)
    {
      int i = j;
      if (this.HqF != null)
      {
        i = j;
        if (this.HqF.getVisibility() == 0)
        {
          this.HqF.removeAllViews();
          i = 1;
        }
      }
      j = i;
      if (this.HqG != null)
      {
        j = i;
        if (this.HqG.getVisibility() == 0)
        {
          this.HqG.removeAllViews();
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
          LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 40), com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 40));
          localLayoutParams.rightMargin = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 8);
          localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
          localImageView.setLayoutParams(localLayoutParams);
          if (i < this.HqJ) {
            this.HqE.addView(localImageView);
          }
          for (;;)
          {
            a.b.c(localImageView, str);
            i += 1;
            break;
            if ((i >= this.HqJ) && (i < this.HqJ * 2)) {
              this.HqF.addView(localImageView);
            } else if ((i >= this.HqJ * 2) && (i < this.HqJ * 3)) {
              this.HqG.addView(localImageView);
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
    this.Hng = findViewById(2131307946);
    this.miE = findViewById(2131297453);
    this.Hqu = ((LinearLayout)findViewById(2131302587));
    this.Hqw = ((TextView)findViewById(2131302591));
    this.Hqx = ((TextView)findViewById(2131302592));
    this.Hqy = ((TextView)findViewById(2131302593));
    this.HqE = ((LinearLayout)findViewById(2131302580));
    this.HqF = ((LinearLayout)findViewById(2131307879));
    this.HqG = ((LinearLayout)findViewById(2131307878));
    this.Hqv = ((WeImageView)findViewById(2131296937));
    this.Hqu.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33611);
        if ((d.hXY != null) && (((com.tencent.mm.plugin.multitalk.model.a)g.ab(com.tencent.mm.plugin.multitalk.model.a.class)).ci(MultiTalkRoomPopupNav.this.getContext())))
        {
          ac.d("MicroMsg.MultiTalkRoomPopupNav", "is voip talking");
          AppMethodBeat.o(33611);
          return;
        }
        if ((d.hXY != null) && (d.hXY.aJa()))
        {
          Toast.makeText(ai.getContext(), ai.getContext().getString(2131760332), 0).show();
          ac.d("MicroMsg.MultiTalkRoomPopupNav", "is show loation");
          AppMethodBeat.o(33611);
          return;
        }
        MultiTalkRoomPopupNav.a(MultiTalkRoomPopupNav.this);
        AppMethodBeat.o(33611);
      }
    });
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)ai.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    this.HqJ = ((int)Math.floor((localDisplayMetrics.widthPixels - ao.fromDPToPix(getContext(), 56)) / ao.fromDPToPix(getContext(), 48)));
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
    this.Hqw.setTextColor(getResources().getColor(2131100685));
    this.Hqw.setText(paramString);
    if ((this.HqE == null) || (this.HqE.getVisibility() != 0))
    {
      this.Hqw.setVisibility(0);
      this.Hqy.setVisibility(8);
      this.Hqx.setVisibility(8);
      this.HqE.setVisibility(8);
    }
    AppMethodBeat.o(33625);
  }
  
  private void setInvitingBannerStyle(String paramString)
  {
    AppMethodBeat.i(33624);
    this.Hqx.setTextColor(getResources().getColor(2131100685));
    this.Hqx.setText(paramString);
    this.Hqw.setVisibility(8);
    this.Hqy.setVisibility(0);
    this.Hqx.setVisibility(0);
    this.HqE.setVisibility(8);
    AppMethodBeat.o(33624);
  }
  
  private void setTalkingBannerStyle(String paramString)
  {
    AppMethodBeat.i(33623);
    this.Hqw.setTextColor(getResources().getColor(2131100687));
    this.Hqw.setText(paramString);
    this.Hqw.setVisibility(0);
    this.Hqy.setVisibility(8);
    this.Hqx.setVisibility(8);
    AppMethodBeat.o(33623);
  }
  
  private void wF(boolean paramBoolean)
  {
    AppMethodBeat.i(196328);
    if (this.HmC != null) {
      if (paramBoolean)
      {
        this.HmC.setVisibility(0);
        if (this.miE != null) {
          this.miE.setVisibility(8);
        }
        if (this.Hqu != null) {
          this.Hqu.setBackgroundColor(0);
        }
        if (this.Hqv != null) {
          this.Hqv.setVisibility(4);
        }
        if (this.HmD != null)
        {
          this.HmD.hideVKB();
          AppMethodBeat.o(196328);
        }
      }
      else
      {
        this.HmC.setVisibility(8);
        if (this.miE != null) {
          this.miE.setVisibility(0);
        }
        if (this.Hqu != null) {
          this.Hqu.setBackgroundResource(2131234968);
        }
        if (this.Hqv != null) {
          this.Hqv.setVisibility(0);
        }
      }
    }
    AppMethodBeat.o(196328);
  }
  
  public final void fhl()
  {
    AppMethodBeat.i(33626);
    this.HqH = false;
    setVisibility(8);
    if (this.HqC != null) {
      this.HqC.close();
    }
    AppMethodBeat.o(33626);
  }
  
  public void setChattingContext(com.tencent.mm.ui.chatting.d.a parama)
  {
    this.HmD = parama;
  }
  
  public void setCurrentSenderUserName(String paramString)
  {
    this.HqA = paramString;
  }
  
  public void setGroupUserName(String paramString)
  {
    this.Hqz = paramString;
  }
  
  public void setInChatRoom(boolean paramBoolean)
  {
    this.HmE = paramBoolean;
  }
  
  public void setMultiTalkInfo(f paramf)
  {
    this.HqI = paramf;
  }
  
  public void setRootTipsBarBackground(View paramView)
  {
    this.HmC = paramView;
  }
  
  public void setUserTalkingStatus(b paramb)
  {
    this.HqB = paramb;
  }
  
  public final void wG(boolean paramBoolean)
  {
    AppMethodBeat.i(33622);
    this.HqH = false;
    if ((this.Hqz == null) || (this.HqA == null))
    {
      ac.e("MicroMsg.MultiTalkRoomPopupNav", "groupUserName or currentSenderUserName is null! groupUserName:" + this.Hqz + ",currentSenderUserName:" + this.HqA);
      AppMethodBeat.o(33622);
      return;
    }
    String str = this.Hqz;
    if (!((com.tencent.mm.plugin.multitalk.model.a)g.ab(com.tencent.mm.plugin.multitalk.model.a.class)).amk(str))
    {
      fhl();
      AppMethodBeat.o(33622);
      return;
    }
    List localList = ((com.tencent.mm.plugin.multitalk.model.a)g.ab(com.tencent.mm.plugin.multitalk.model.a.class)).amn(str);
    if (localList.size() == 0)
    {
      ((com.tencent.mm.plugin.multitalk.model.a)g.ab(com.tencent.mm.plugin.multitalk.model.a.class)).zB(str);
      fhl();
      AppMethodBeat.o(33622);
      return;
    }
    int i = ((com.tencent.mm.plugin.multitalk.model.a)g.ab(com.tencent.mm.plugin.multitalk.model.a.class)).hM(str, this.HqA);
    if (i == 1)
    {
      setUserTalkingStatus(b.HqN);
      if (((com.tencent.mm.plugin.multitalk.model.a)g.ab(com.tencent.mm.plugin.multitalk.model.a.class)).amo(str))
      {
        fhl();
        AppMethodBeat.o(33622);
        return;
      }
      setInvitingBannerStyle(((com.tencent.mm.plugin.multitalk.model.a)g.ab(com.tencent.mm.plugin.multitalk.model.a.class)).wk(((com.tencent.mm.plugin.multitalk.model.a)g.ab(com.tencent.mm.plugin.multitalk.model.a.class)).hN(str, this.HqA)));
    }
    for (;;)
    {
      setVisibility(0);
      this.Hqu.setVisibility(0);
      if ((this.HqC != null) && ((paramBoolean) || (this.HqE == null) || (this.HqE.getVisibility() != 0))) {
        this.HqC.close();
      }
      hC(s(localList, ""));
      if ((this.HqC == null) || (this.HqC.HqL == null)) {
        break label502;
      }
      if (this.HqC.HqL.getVisibility() != 0) {
        break;
      }
      wF(true);
      AppMethodBeat.o(33622);
      return;
      if (i == 10)
      {
        setUserTalkingStatus(b.HqO);
        if (((com.tencent.mm.plugin.multitalk.model.a)g.ab(com.tencent.mm.plugin.multitalk.model.a.class)).amo(str))
        {
          fhl();
          AppMethodBeat.o(33622);
          return;
        }
        if (((com.tencent.mm.plugin.multitalk.model.a)g.ab(com.tencent.mm.plugin.multitalk.model.a.class)).dfo())
        {
          fhl();
          AppMethodBeat.o(33622);
          return;
        }
        setUserTalkingStatus(b.HqP);
        setDefaultBannerStyle(ai.getContext().getString(2131761440, new Object[] { Integer.valueOf(localList.size()) }));
      }
      else
      {
        setUserTalkingStatus(b.HqP);
        setDefaultBannerStyle(ai.getContext().getString(2131761440, new Object[] { Integer.valueOf(localList.size()) }));
      }
    }
    wF(false);
    label502:
    AppMethodBeat.o(33622);
  }
  
  public final class a
  {
    public LinearLayout HqL;
    TextView titleView;
    View wWt;
    
    private a()
    {
      AppMethodBeat.i(196327);
      this.wWt = MultiTalkRoomPopupNav.this.findViewById(2131298372);
      this.titleView = ((TextView)MultiTalkRoomPopupNav.this.findViewById(2131302590));
      this.HqL = ((LinearLayout)MultiTalkRoomPopupNav.this.findViewById(2131307318));
      AppMethodBeat.o(196327);
    }
    
    public final void close()
    {
      AppMethodBeat.i(33615);
      MultiTalkRoomPopupNav.i(MultiTalkRoomPopupNav.this);
      if (this.HqL.getVisibility() == 0)
      {
        Animation localAnimation = AnimationUtils.loadAnimation(MultiTalkRoomPopupNav.this.getContext(), 2130772109);
        localAnimation.setAnimationListener(new Animation.AnimationListener()
        {
          public final void onAnimationEnd(Animation paramAnonymousAnimation)
          {
            AppMethodBeat.i(196326);
            MultiTalkRoomPopupNav.a.this.HqL.setVisibility(8);
            AppMethodBeat.o(196326);
          }
          
          public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
          
          public final void onAnimationStart(Animation paramAnonymousAnimation) {}
        });
        this.HqL.startAnimation(localAnimation);
      }
      AppMethodBeat.o(33615);
    }
  }
  
  static enum b
  {
    static
    {
      AppMethodBeat.i(33618);
      HqN = new b("Inviting", 0);
      HqO = new b("Talking", 1);
      HqP = new b("NotInTalking", 2);
      HqQ = new b[] { HqN, HqO, HqP };
      AppMethodBeat.o(33618);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.MultiTalkRoomPopupNav
 * JD-Core Version:    0.7.0.1
 */