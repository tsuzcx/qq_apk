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
import com.tencent.mm.R.a;
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.bj.f;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.multitalk.d.e;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MultiTalkRoomPopupNav
  extends LinearLayout
{
  private View Nrv;
  private View VYF;
  private WeImageView VYG;
  private boolean VYI;
  private com.tencent.mm.ui.chatting.e.a VYv;
  private LinearLayout WcC;
  private View WcD;
  private TextView WcE;
  private TextView WcF;
  private TextView WcG;
  private String WcH;
  private String WcI;
  private b WcJ;
  public a WcK;
  private final int WcL;
  private LinearLayout WcM;
  private LinearLayout WcN;
  private LinearLayout WcO;
  public boolean WcP;
  private f WcQ;
  private int WcR;
  private View rcN;
  
  public MultiTalkRoomPopupNav(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(33620);
    this.WcJ = b.WcX;
    this.WcL = 6;
    this.WcP = false;
    this.WcQ = new f();
    initView();
    AppMethodBeat.o(33620);
  }
  
  @TargetApi(11)
  public MultiTalkRoomPopupNav(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(33619);
    this.WcJ = b.WcX;
    this.WcL = 6;
    this.WcP = false;
    this.WcQ = new f();
    initView();
    AppMethodBeat.o(33619);
  }
  
  private void FF(boolean paramBoolean)
  {
    AppMethodBeat.i(292374);
    if (this.VYF != null) {
      if (paramBoolean)
      {
        this.VYF.setVisibility(0);
        if (this.rcN != null) {
          this.rcN.setVisibility(8);
        }
        if (this.WcC != null) {
          this.WcC.setBackgroundColor(0);
        }
        if (this.VYG != null) {
          this.VYG.setVisibility(4);
        }
        if (this.VYv != null)
        {
          this.VYv.hideVKB();
          AppMethodBeat.o(292374);
        }
      }
      else
      {
        this.VYF.setVisibility(8);
        if (this.rcN != null) {
          this.rcN.setVisibility(0);
        }
        if (this.WcC != null) {
          this.WcC.setBackgroundResource(R.g.tipsbar_small_white_bg);
        }
        if (this.VYG != null) {
          this.VYG.setVisibility(0);
        }
      }
    }
    AppMethodBeat.o(292374);
  }
  
  private void c(String paramString1, List<String> paramList, final String paramString2)
  {
    AppMethodBeat.i(33627);
    this.WcC.setBackgroundColor(0);
    this.VYG.setVisibility(4);
    Object localObject = b.WcV;
    this.WcK = new a((byte)0);
    localObject = this.WcK;
    View.OnClickListener local2 = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33612);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/MultiTalkRoomPopupNav$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        Log.i("MicroMsg.MultiTalkRoomPopupNav", "click enter button..");
        if (paramString2 != null)
        {
          if (((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.multitalk.model.d.class)).eWe())
          {
            Log.e("MicroMsg.MultiTalkRoomPopupNav", "now is in other voip..");
            com.tencent.mm.ui.base.h.c(MultiTalkRoomPopupNav.this.getContext(), MMApplicationContext.getContext().getString(R.l.multitalk_is_talking_cannot_enter), null, true);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MultiTalkRoomPopupNav$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(33612);
            return;
          }
          paramAnonymousView = ((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.multitalk.model.d.class)).aPW(MultiTalkRoomPopupNav.b(MultiTalkRoomPopupNav.this));
          if (paramAnonymousView.size() != 1) {
            break label309;
          }
          MultiTalkRoomPopupNav.byu(paramString2);
          com.tencent.mm.plugin.report.service.h.IzE.a(13945, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), MultiTalkRoomPopupNav.b(MultiTalkRoomPopupNav.this), Integer.valueOf(MultiTalkRoomPopupNav.c(MultiTalkRoomPopupNav.this).field_roomId), Long.valueOf(MultiTalkRoomPopupNav.c(MultiTalkRoomPopupNav.this).field_roomKey) });
        }
        for (;;)
        {
          MultiTalkRoomPopupNav.e(MultiTalkRoomPopupNav.this).close();
          MultiTalkRoomPopupNav.f(MultiTalkRoomPopupNav.this).setVisibility(0);
          MultiTalkRoomPopupNav.f(MultiTalkRoomPopupNav.this).setBackgroundResource(R.g.tipsbar_small_white_bg);
          MultiTalkRoomPopupNav.g(MultiTalkRoomPopupNav.this).setVisibility(0);
          MultiTalkRoomPopupNav.h(MultiTalkRoomPopupNav.this).setVisibility(8);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MultiTalkRoomPopupNav$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(33612);
          return;
          label309:
          int i;
          if (paramAnonymousView.size() >= e.eZN())
          {
            Log.e("MicroMsg.MultiTalkRoomPopupNav", "now is up to the limit,memberList size:" + paramAnonymousView.size());
            com.tencent.mm.ui.base.h.c(MultiTalkRoomPopupNav.this.getContext(), MMApplicationContext.getContext().getString(R.l.multitalk_members_reach_max_limit, new Object[] { Integer.valueOf(e.eZN()) }), null, true);
            paramAnonymousView = com.tencent.mm.plugin.report.service.h.IzE;
            if (MultiTalkRoomPopupNav.d(MultiTalkRoomPopupNav.this) == MultiTalkRoomPopupNav.b.WcV) {}
            for (i = 1;; i = 0)
            {
              paramAnonymousView.a(13945, new Object[] { Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(1), MultiTalkRoomPopupNav.b(MultiTalkRoomPopupNav.this), Integer.valueOf(MultiTalkRoomPopupNav.c(MultiTalkRoomPopupNav.this).field_roomId), Long.valueOf(MultiTalkRoomPopupNav.c(MultiTalkRoomPopupNav.this).field_roomKey) });
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MultiTalkRoomPopupNav$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(33612);
              return;
            }
          }
          if (((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.multitalk.model.d.class)).eWd())
          {
            Log.e("MicroMsg.MultiTalkRoomPopupNav", "now is inviting other people voip..");
            com.tencent.mm.ui.base.h.c(MultiTalkRoomPopupNav.this.getContext(), MMApplicationContext.getContext().getString(R.l.multitalk_inviting_in_another_group), null, true);
            paramAnonymousView = com.tencent.mm.plugin.report.service.h.IzE;
            if (MultiTalkRoomPopupNav.d(MultiTalkRoomPopupNav.this) == MultiTalkRoomPopupNav.b.WcV) {}
            for (i = 1;; i = 0)
            {
              paramAnonymousView.a(13945, new Object[] { Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(1), MultiTalkRoomPopupNav.b(MultiTalkRoomPopupNav.this), Integer.valueOf(MultiTalkRoomPopupNav.c(MultiTalkRoomPopupNav.this).field_roomId), Long.valueOf(MultiTalkRoomPopupNav.c(MultiTalkRoomPopupNav.this).field_roomKey) });
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
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/MultiTalkRoomPopupNav$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        Log.i("MicroMsg.MultiTalkRoomPopupNav", "click cancel button..");
        int i;
        if (MultiTalkRoomPopupNav.d(MultiTalkRoomPopupNav.this) == MultiTalkRoomPopupNav.b.WcV)
        {
          Log.i("MicroMsg.MultiTalkRoomPopupNav", "reject multiTalk!");
          boolean bool = ((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.multitalk.model.d.class)).aQb(paramString2);
          ((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.multitalk.model.d.class)).aQc(paramString2);
          paramAnonymousView = com.tencent.mm.plugin.report.service.h.IzE;
          if (bool)
          {
            i = 0;
            paramAnonymousView.a(13945, new Object[] { Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(i), MultiTalkRoomPopupNav.b(MultiTalkRoomPopupNav.this), Integer.valueOf(MultiTalkRoomPopupNav.c(MultiTalkRoomPopupNav.this).field_roomId), Long.valueOf(MultiTalkRoomPopupNav.c(MultiTalkRoomPopupNav.this).field_roomKey) });
          }
        }
        for (;;)
        {
          MultiTalkRoomPopupNav.e(MultiTalkRoomPopupNav.this).close();
          MultiTalkRoomPopupNav.f(MultiTalkRoomPopupNav.this).setVisibility(0);
          MultiTalkRoomPopupNav.f(MultiTalkRoomPopupNav.this).setBackgroundResource(R.g.tipsbar_small_white_bg);
          MultiTalkRoomPopupNav.g(MultiTalkRoomPopupNav.this).setVisibility(0);
          MultiTalkRoomPopupNav.h(MultiTalkRoomPopupNav.this).setVisibility(8);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MultiTalkRoomPopupNav$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(33613);
          return;
          i = 1;
          break;
          com.tencent.mm.plugin.report.service.h.IzE.a(13945, new Object[] { Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), MultiTalkRoomPopupNav.b(MultiTalkRoomPopupNav.this), Integer.valueOf(MultiTalkRoomPopupNav.c(MultiTalkRoomPopupNav.this).field_roomId), Long.valueOf(MultiTalkRoomPopupNav.c(MultiTalkRoomPopupNav.this).field_roomKey) });
        }
      }
    };
    ((a)localObject).titleView.setText(paramString1);
    if (((a)localObject).WcT.getVisibility() != 0)
    {
      ((a)localObject).WcT.setVisibility(0);
      ((a)localObject).WcT.startAnimation(AnimationUtils.loadAnimation(((a)localObject).WcS.getContext(), R.a.push_down_in));
      ((a)localObject).WcS.FF(true);
      if (((a)localObject).WcS.VYF != null) {
        ((a)localObject).WcS.VYF.startAnimation(AnimationUtils.loadAnimation(((a)localObject).WcS.getContext(), R.a.fast_faded_in));
      }
    }
    ((a)localObject).WcS.WcM.setVisibility(0);
    ((a)localObject).WcS.WcM.removeAllViews();
    if (paramList != null)
    {
      if (paramList.size() > ((a)localObject).WcS.WcR)
      {
        ((a)localObject).WcS.WcN.setVisibility(0);
        ((a)localObject).WcS.WcN.removeAllViews();
      }
      if (paramList.size() > ((a)localObject).WcS.WcR * 2)
      {
        ((a)localObject).WcS.WcO.setVisibility(0);
        ((a)localObject).WcS.WcO.removeAllViews();
      }
    }
    paramString1 = paramList.iterator();
    int i = 0;
    if (paramString1.hasNext())
    {
      paramList = (String)paramString1.next();
      ImageView localImageView = new ImageView(((a)localObject).WcS.getContext());
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 40), com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 40));
      localLayoutParams.rightMargin = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 8);
      localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      localImageView.setLayoutParams(localLayoutParams);
      if (i < ((a)localObject).WcS.WcR) {
        ((a)localObject).WcS.WcM.addView(localImageView);
      }
      for (;;)
      {
        a.b.c(localImageView, paramList);
        i += 1;
        break;
        if ((i >= ((a)localObject).WcS.WcR) && (i < ((a)localObject).WcS.WcR * 2)) {
          ((a)localObject).WcS.WcN.addView(localImageView);
        } else if ((i >= ((a)localObject).WcS.WcR * 2) && (i < ((a)localObject).WcS.WcR * 3)) {
          ((a)localObject).WcS.WcO.addView(localImageView);
        }
      }
    }
    ((Button)((a)localObject).WcS.findViewById(R.h.multitalk_alert_enter_btn)).setOnClickListener(local2);
    ((a)localObject).Bqa.setOnClickListener(paramString2);
    if (((a)localObject).WcS.VYF != null) {
      ((a)localObject).WcS.VYF.setOnClickListener(paramString2);
    }
    AppMethodBeat.o(33627);
  }
  
  private void initView()
  {
    AppMethodBeat.i(33621);
    inflate(getContext(), R.i.multitalk_room_popup_nav, this);
    this.Nrv = findViewById(R.h.root_ll);
    this.rcN = findViewById(R.h.bottom_line);
    this.WcC = ((LinearLayout)findViewById(R.h.multitalk_nav_layout));
    this.WcE = ((TextView)findViewById(R.h.multitalk_tv_nav_content));
    this.WcF = ((TextView)findViewById(R.h.multitalk_tv_nav_content2));
    this.WcG = ((TextView)findViewById(R.h.multitalk_tv_nav_inviting));
    this.WcM = ((LinearLayout)findViewById(R.h.multitalk_image_list_layout));
    this.WcN = ((LinearLayout)findViewById(R.h.multitalk_image_line_two));
    this.WcO = ((LinearLayout)findViewById(R.h.multitalk_image_line_three));
    this.VYG = ((WeImageView)findViewById(R.h.arrow));
    this.WcC.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33611);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/MultiTalkRoomPopupNav$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if ((com.tencent.mm.bk.d.meV != null) && (((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.multitalk.model.d.class)).cy(MultiTalkRoomPopupNav.this.getContext())))
        {
          Log.d("MicroMsg.MultiTalkRoomPopupNav", "is voip talking");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MultiTalkRoomPopupNav$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(33611);
          return;
        }
        if ((com.tencent.mm.bk.d.meV != null) && (com.tencent.mm.bk.d.meV.bpY()))
        {
          Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(R.l.in_new_share_location_tip), 0).show();
          Log.d("MicroMsg.MultiTalkRoomPopupNav", "is show loation");
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
    ((WindowManager)MMApplicationContext.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    this.WcR = ((int)Math.floor((localDisplayMetrics.widthPixels - aw.fromDPToPix(getContext(), 56)) / aw.fromDPToPix(getContext(), 48)));
    AppMethodBeat.o(33621);
  }
  
  private void jU(List<String> paramList)
  {
    int k = 0;
    AppMethodBeat.i(33628);
    if ((this.WcM != null) && (this.WcM.getVisibility() == 0)) {
      this.WcM.removeAllViews();
    }
    for (int j = 1;; j = 0)
    {
      int i = j;
      if (this.WcN != null)
      {
        i = j;
        if (this.WcN.getVisibility() == 0)
        {
          this.WcN.removeAllViews();
          i = 1;
        }
      }
      j = i;
      if (this.WcO != null)
      {
        j = i;
        if (this.WcO.getVisibility() == 0)
        {
          this.WcO.removeAllViews();
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
          LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 40), com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 40));
          localLayoutParams.rightMargin = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 8);
          localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
          localImageView.setLayoutParams(localLayoutParams);
          if (i < this.WcR) {
            this.WcM.addView(localImageView);
          }
          for (;;)
          {
            a.b.c(localImageView, str);
            i += 1;
            break;
            if ((i >= this.WcR) && (i < this.WcR * 2)) {
              this.WcN.addView(localImageView);
            } else if ((i >= this.WcR * 2) && (i < this.WcR * 3)) {
              this.WcO.addView(localImageView);
            }
          }
        }
      }
      AppMethodBeat.o(33628);
      return;
    }
  }
  
  private void setDefaultBannerStyle(String paramString)
  {
    AppMethodBeat.i(33625);
    this.WcE.setTextColor(getResources().getColor(R.e.multitalk_popup_nav_black_text_color));
    this.WcE.setText(paramString);
    if ((this.WcM == null) || (this.WcM.getVisibility() != 0))
    {
      this.WcE.setVisibility(0);
      this.WcG.setVisibility(8);
      this.WcF.setVisibility(8);
      this.WcM.setVisibility(8);
    }
    AppMethodBeat.o(33625);
  }
  
  private void setInvitingBannerStyle(String paramString)
  {
    AppMethodBeat.i(33624);
    this.WcF.setTextColor(getResources().getColor(R.e.multitalk_popup_nav_black_text_color));
    this.WcF.setText(paramString);
    this.WcE.setVisibility(8);
    this.WcG.setVisibility(0);
    this.WcF.setVisibility(0);
    this.WcM.setVisibility(8);
    AppMethodBeat.o(33624);
  }
  
  private void setInvitingBannerStyleWithText(String paramString)
  {
    AppMethodBeat.i(292375);
    this.WcD.setBackgroundResource(R.g.multitalk_talking_banner_shape);
    this.WcE.setVisibility(8);
    this.WcG.setVisibility(0);
    this.WcG.setText(paramString);
    this.WcF.setVisibility(0);
    this.WcM.setVisibility(8);
    AppMethodBeat.o(292375);
  }
  
  private void setTalkingBannerStyle(String paramString)
  {
    AppMethodBeat.i(33623);
    this.WcE.setTextColor(getResources().getColor(R.e.multitalk_popup_nav_green_text_color));
    this.WcE.setText(paramString);
    this.WcE.setVisibility(0);
    this.WcG.setVisibility(8);
    this.WcF.setVisibility(8);
    AppMethodBeat.o(33623);
  }
  
  private static List<String> u(List<String> paramList, String paramString)
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
  
  public final void FG(boolean paramBoolean)
  {
    AppMethodBeat.i(33622);
    this.WcP = false;
    if ((this.WcH == null) || (this.WcI == null))
    {
      Log.e("MicroMsg.MultiTalkRoomPopupNav", "groupUserName or currentSenderUserName is null! groupUserName:" + this.WcH + ",currentSenderUserName:" + this.WcI);
      AppMethodBeat.o(33622);
      return;
    }
    Object localObject = this.WcH;
    if (!((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.multitalk.model.d.class)).aPT((String)localObject))
    {
      hIr();
      AppMethodBeat.o(33622);
      return;
    }
    List localList = ((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.multitalk.model.d.class)).aPW((String)localObject);
    if (localList.size() == 0)
    {
      ((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.multitalk.model.d.class)).ho((String)localObject);
      hIr();
      AppMethodBeat.o(33622);
      return;
    }
    int i = ((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.multitalk.model.d.class)).iX((String)localObject, this.WcI);
    String str;
    if (i == 1)
    {
      setUserTalkingStatus(b.WcV);
      if (((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.multitalk.model.d.class)).aPX((String)localObject))
      {
        hIr();
        AppMethodBeat.o(33622);
        return;
      }
      str = e.eZX();
      if (str == null) {
        setInvitingBannerStyle(((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.multitalk.model.d.class)).PJ(((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.multitalk.model.d.class)).iY((String)localObject, this.WcI)));
      }
    }
    for (;;)
    {
      setVisibility(0);
      this.WcC.setVisibility(0);
      if ((this.WcK != null) && ((paramBoolean) || (this.WcM == null) || (this.WcM.getVisibility() != 0))) {
        this.WcK.close();
      }
      jU(u(localList, ""));
      if ((this.WcK == null) || (this.WcK.WcT == null)) {
        break label551;
      }
      if (this.WcK.WcT.getVisibility() != 0) {
        break;
      }
      FF(true);
      AppMethodBeat.o(33622);
      return;
      setInvitingBannerStyleWithText(str);
      continue;
      if (i == 10)
      {
        setUserTalkingStatus(b.WcW);
        if (((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.multitalk.model.d.class)).aPX((String)localObject))
        {
          hIr();
          AppMethodBeat.o(33622);
          return;
        }
        if (((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.multitalk.model.d.class)).eWg())
        {
          hIr();
          AppMethodBeat.o(33622);
          return;
        }
        str = e.eZZ();
        setUserTalkingStatus(b.WcX);
        localObject = str;
        if (str == null) {
          localObject = MMApplicationContext.getContext().getString(R.l.multitalk_somepepole_in_tip, new Object[] { Integer.valueOf(localList.size()) });
        }
        setDefaultBannerStyle((String)localObject);
      }
      else
      {
        setUserTalkingStatus(b.WcX);
        str = e.eZZ();
        localObject = str;
        if (str == null) {
          localObject = MMApplicationContext.getContext().getString(R.l.multitalk_somepepole_in_tip, new Object[] { Integer.valueOf(localList.size()) });
        }
        setDefaultBannerStyle((String)localObject);
      }
    }
    FF(false);
    label551:
    AppMethodBeat.o(33622);
  }
  
  public final void hIr()
  {
    AppMethodBeat.i(33626);
    this.WcP = false;
    setVisibility(8);
    if (this.WcK != null) {
      this.WcK.close();
    }
    AppMethodBeat.o(33626);
  }
  
  public void setChattingContext(com.tencent.mm.ui.chatting.e.a parama)
  {
    this.VYv = parama;
  }
  
  public void setCurrentSenderUserName(String paramString)
  {
    this.WcI = paramString;
  }
  
  public void setGroupUserName(String paramString)
  {
    this.WcH = paramString;
  }
  
  public void setInChatRoom(boolean paramBoolean)
  {
    this.VYI = paramBoolean;
  }
  
  public void setMultiTalkInfo(f paramf)
  {
    this.WcQ = paramf;
  }
  
  public void setRootTipsBarBackground(View paramView)
  {
    this.VYF = paramView;
  }
  
  public void setUserTalkingStatus(b paramb)
  {
    this.WcJ = paramb;
  }
  
  public final class a
  {
    View Bqa;
    public LinearLayout WcT;
    TextView titleView;
    
    private a()
    {
      AppMethodBeat.i(287908);
      this.Bqa = MultiTalkRoomPopupNav.this.findViewById(R.h.close_img);
      this.titleView = ((TextView)MultiTalkRoomPopupNav.this.findViewById(R.h.multitalk_tv_dialog_title));
      this.WcT = ((LinearLayout)MultiTalkRoomPopupNav.this.findViewById(R.h.dialog_root));
      AppMethodBeat.o(287908);
    }
    
    public final void close()
    {
      AppMethodBeat.i(33615);
      MultiTalkRoomPopupNav.a(MultiTalkRoomPopupNav.this, false);
      if (this.WcT.getVisibility() == 0)
      {
        Animation localAnimation = AnimationUtils.loadAnimation(MultiTalkRoomPopupNav.this.getContext(), R.a.push_up_out);
        localAnimation.setAnimationListener(new Animation.AnimationListener()
        {
          public final void onAnimationEnd(Animation paramAnonymousAnimation)
          {
            AppMethodBeat.i(219636);
            MultiTalkRoomPopupNav.a.this.WcT.setVisibility(8);
            AppMethodBeat.o(219636);
          }
          
          public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
          
          public final void onAnimationStart(Animation paramAnonymousAnimation) {}
        });
        this.WcT.startAnimation(localAnimation);
      }
      AppMethodBeat.o(33615);
    }
  }
  
  static enum b
  {
    static
    {
      AppMethodBeat.i(33618);
      WcV = new b("Inviting", 0);
      WcW = new b("Talking", 1);
      WcX = new b("NotInTalking", 2);
      WcY = new b[] { WcV, WcW, WcX };
      AppMethodBeat.o(33618);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.MultiTalkRoomPopupNav
 * JD-Core Version:    0.7.0.1
 */