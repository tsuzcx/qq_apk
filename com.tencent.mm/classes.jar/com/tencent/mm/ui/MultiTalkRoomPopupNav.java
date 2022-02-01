package com.tencent.mm.ui;

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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MultiTalkRoomPopupNav
  extends LinearLayout
{
  private View DOL;
  private com.tencent.mm.ui.chatting.d.a adCQ;
  private View adDa;
  private WeImageView adDb;
  private boolean adDd;
  private LinearLayout adIf;
  private View adIg;
  private TextView adIh;
  private TextView adIi;
  private TextView adIj;
  private String adIk;
  private String adIl;
  private b adIm;
  public a adIn;
  private final int adIo;
  private LinearLayout adIp;
  private LinearLayout adIq;
  private LinearLayout adIr;
  public boolean adIs;
  private com.tencent.mm.bc.f adIt;
  private int adIu;
  private View uix;
  
  public MultiTalkRoomPopupNav(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(33620);
    this.adIm = b.adIA;
    this.adIo = 6;
    this.adIs = false;
    this.adIt = new com.tencent.mm.bc.f();
    initView();
    AppMethodBeat.o(33620);
  }
  
  public MultiTalkRoomPopupNav(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(33619);
    this.adIm = b.adIA;
    this.adIo = 6;
    this.adIs = false;
    this.adIt = new com.tencent.mm.bc.f();
    initView();
    AppMethodBeat.o(33619);
  }
  
  private static List<String> K(List<String> paramList, String paramString)
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
  
  private void Lo(boolean paramBoolean)
  {
    AppMethodBeat.i(249449);
    if (this.adDa != null) {
      if (paramBoolean)
      {
        this.adDa.setVisibility(0);
        if (this.uix != null) {
          this.uix.setVisibility(8);
        }
        if (this.adIf != null) {
          this.adIf.setBackgroundColor(0);
        }
        if (this.adDb != null) {
          this.adDb.setVisibility(4);
        }
        if (this.adCQ != null)
        {
          this.adCQ.hideVKB();
          AppMethodBeat.o(249449);
        }
      }
      else
      {
        this.adDa.setVisibility(8);
        if (this.uix != null) {
          this.uix.setVisibility(0);
        }
        if (this.adIf != null) {
          this.adIf.setBackgroundResource(R.g.tipsbar_small_white_bg);
        }
        if (this.adDb != null) {
          this.adDb.setVisibility(0);
        }
      }
    }
    AppMethodBeat.o(249449);
  }
  
  private void c(String paramString1, List<String> paramList, final String paramString2)
  {
    AppMethodBeat.i(33627);
    this.adIf.setBackgroundColor(0);
    this.adDb.setVisibility(4);
    Object localObject = b.adIy;
    this.adIn = new a((byte)0);
    localObject = this.adIn;
    View.OnClickListener local2 = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33612);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/MultiTalkRoomPopupNav$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        Log.i("MicroMsg.MultiTalkRoomPopupNav", "click enter button..");
        if (paramString2 != null)
        {
          if (((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.multitalk.model.d.class)).geV())
          {
            Log.e("MicroMsg.MultiTalkRoomPopupNav", "now is in other voip..");
            k.c(MultiTalkRoomPopupNav.this.getContext(), MMApplicationContext.getContext().getString(R.l.multitalk_is_talking_cannot_enter), null, true);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MultiTalkRoomPopupNav$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(33612);
            return;
          }
          paramAnonymousView = ((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.multitalk.model.d.class)).aMR(MultiTalkRoomPopupNav.b(MultiTalkRoomPopupNav.this));
          if ((paramAnonymousView == null) || (paramAnonymousView.size() != 1)) {
            break label313;
          }
          MultiTalkRoomPopupNav.bzQ(paramString2);
          com.tencent.mm.plugin.report.service.h.OAn.b(13945, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), MultiTalkRoomPopupNav.b(MultiTalkRoomPopupNav.this), Integer.valueOf(MultiTalkRoomPopupNav.c(MultiTalkRoomPopupNav.this).field_roomId), Long.valueOf(MultiTalkRoomPopupNav.c(MultiTalkRoomPopupNav.this).field_roomKey) });
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
          label313:
          int i;
          if ((paramAnonymousView != null) && (paramAnonymousView.size() >= com.tencent.mm.plugin.multitalk.e.f.giS()))
          {
            Log.e("MicroMsg.MultiTalkRoomPopupNav", "now is up to the limit,memberList size:" + paramAnonymousView.size());
            k.c(MultiTalkRoomPopupNav.this.getContext(), MMApplicationContext.getContext().getString(R.l.multitalk_members_reach_max_limit, new Object[] { Integer.valueOf(com.tencent.mm.plugin.multitalk.e.f.giS()) }), null, true);
            paramAnonymousView = com.tencent.mm.plugin.report.service.h.OAn;
            if (MultiTalkRoomPopupNav.d(MultiTalkRoomPopupNav.this) == MultiTalkRoomPopupNav.b.adIy) {}
            for (i = 1;; i = 0)
            {
              paramAnonymousView.b(13945, new Object[] { Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(1), MultiTalkRoomPopupNav.b(MultiTalkRoomPopupNav.this), Integer.valueOf(MultiTalkRoomPopupNav.c(MultiTalkRoomPopupNav.this).field_roomId), Long.valueOf(MultiTalkRoomPopupNav.c(MultiTalkRoomPopupNav.this).field_roomKey) });
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MultiTalkRoomPopupNav$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(33612);
              return;
            }
          }
          if (((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.multitalk.model.d.class)).geU())
          {
            Log.e("MicroMsg.MultiTalkRoomPopupNav", "now is inviting other people voip..");
            k.c(MultiTalkRoomPopupNav.this.getContext(), MMApplicationContext.getContext().getString(R.l.multitalk_inviting_in_another_group), null, true);
            paramAnonymousView = com.tencent.mm.plugin.report.service.h.OAn;
            if (MultiTalkRoomPopupNav.d(MultiTalkRoomPopupNav.this) == MultiTalkRoomPopupNav.b.adIy) {}
            for (i = 1;; i = 0)
            {
              paramAnonymousView.b(13945, new Object[] { Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(1), MultiTalkRoomPopupNav.b(MultiTalkRoomPopupNav.this), Integer.valueOf(MultiTalkRoomPopupNav.c(MultiTalkRoomPopupNav.this).field_roomId), Long.valueOf(MultiTalkRoomPopupNav.c(MultiTalkRoomPopupNav.this).field_roomKey) });
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
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/MultiTalkRoomPopupNav$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        Log.i("MicroMsg.MultiTalkRoomPopupNav", "click cancel button..");
        int i;
        if (MultiTalkRoomPopupNav.d(MultiTalkRoomPopupNav.this) == MultiTalkRoomPopupNav.b.adIy)
        {
          Log.i("MicroMsg.MultiTalkRoomPopupNav", "reject multiTalk!");
          boolean bool = ((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.multitalk.model.d.class)).aMW(paramString2);
          ((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.multitalk.model.d.class)).aMX(paramString2);
          paramAnonymousView = com.tencent.mm.plugin.report.service.h.OAn;
          if (bool)
          {
            i = 0;
            paramAnonymousView.b(13945, new Object[] { Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(i), MultiTalkRoomPopupNav.b(MultiTalkRoomPopupNav.this), Integer.valueOf(MultiTalkRoomPopupNav.c(MultiTalkRoomPopupNav.this).field_roomId), Long.valueOf(MultiTalkRoomPopupNav.c(MultiTalkRoomPopupNav.this).field_roomKey) });
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
          com.tencent.mm.plugin.report.service.h.OAn.b(13945, new Object[] { Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), MultiTalkRoomPopupNav.b(MultiTalkRoomPopupNav.this), Integer.valueOf(MultiTalkRoomPopupNav.c(MultiTalkRoomPopupNav.this).field_roomId), Long.valueOf(MultiTalkRoomPopupNav.c(MultiTalkRoomPopupNav.this).field_roomKey) });
        }
      }
    };
    ((a)localObject).titleView.setText(paramString1);
    if (((a)localObject).adIw.getVisibility() != 0)
    {
      ((a)localObject).adIw.setVisibility(0);
      ((a)localObject).adIw.startAnimation(AnimationUtils.loadAnimation(((a)localObject).adIv.getContext(), R.a.push_down_in));
      ((a)localObject).adIv.Lo(true);
      if (((a)localObject).adIv.adDa != null) {
        ((a)localObject).adIv.adDa.startAnimation(AnimationUtils.loadAnimation(((a)localObject).adIv.getContext(), R.a.fast_faded_in));
      }
    }
    ((a)localObject).adIv.adIp.setVisibility(0);
    ((a)localObject).adIv.adIp.removeAllViews();
    if (paramList != null)
    {
      if (paramList.size() > ((a)localObject).adIv.adIu)
      {
        ((a)localObject).adIv.adIq.setVisibility(0);
        ((a)localObject).adIv.adIq.removeAllViews();
      }
      if (paramList.size() > ((a)localObject).adIv.adIu * 2)
      {
        ((a)localObject).adIv.adIr.setVisibility(0);
        ((a)localObject).adIv.adIr.removeAllViews();
      }
    }
    paramString1 = paramList.iterator();
    int i = 0;
    if (paramString1.hasNext())
    {
      paramList = (String)paramString1.next();
      ImageView localImageView = new ImageView(((a)localObject).adIv.getContext());
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 40), com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 40));
      localLayoutParams.rightMargin = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 8);
      localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      localImageView.setLayoutParams(localLayoutParams);
      if (i < ((a)localObject).adIv.adIu) {
        ((a)localObject).adIv.adIp.addView(localImageView);
      }
      for (;;)
      {
        a.b.g(localImageView, paramList);
        i += 1;
        break;
        if ((i >= ((a)localObject).adIv.adIu) && (i < ((a)localObject).adIv.adIu * 2)) {
          ((a)localObject).adIv.adIq.addView(localImageView);
        } else if ((i >= ((a)localObject).adIv.adIu * 2) && (i < ((a)localObject).adIv.adIu * 3)) {
          ((a)localObject).adIv.adIr.addView(localImageView);
        }
      }
    }
    ((Button)((a)localObject).adIv.findViewById(R.h.multitalk_alert_enter_btn)).setOnClickListener(local2);
    ((a)localObject).puX.setOnClickListener(paramString2);
    if (((a)localObject).adIv.adDa != null) {
      ((a)localObject).adIv.adDa.setOnClickListener(paramString2);
    }
    AppMethodBeat.o(33627);
  }
  
  private void initView()
  {
    AppMethodBeat.i(33621);
    inflate(getContext(), R.i.multitalk_room_popup_nav, this);
    this.DOL = findViewById(R.h.root_ll);
    this.uix = findViewById(R.h.bottom_line);
    this.adIf = ((LinearLayout)findViewById(R.h.multitalk_nav_layout));
    this.adIh = ((TextView)findViewById(R.h.multitalk_tv_nav_content));
    this.adIi = ((TextView)findViewById(R.h.multitalk_tv_nav_content2));
    this.adIj = ((TextView)findViewById(R.h.multitalk_tv_nav_inviting));
    this.adIp = ((LinearLayout)findViewById(R.h.multitalk_image_list_layout));
    this.adIq = ((LinearLayout)findViewById(R.h.multitalk_image_line_two));
    this.adIr = ((LinearLayout)findViewById(R.h.multitalk_image_line_three));
    this.adDb = ((WeImageView)findViewById(R.h.arrow));
    this.adIf.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33611);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/MultiTalkRoomPopupNav$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if ((com.tencent.mm.bd.d.oXN != null) && (((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.multitalk.model.d.class)).dm(MultiTalkRoomPopupNav.this.getContext())))
        {
          Log.d("MicroMsg.MultiTalkRoomPopupNav", "is voip talking");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MultiTalkRoomPopupNav$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(33611);
          return;
        }
        if ((com.tencent.mm.bd.d.oXN != null) && (com.tencent.mm.bd.d.oXN.bNE()))
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
    this.adIu = ((int)Math.floor((localDisplayMetrics.widthPixels - bd.fromDPToPix(getContext(), 56)) / bd.fromDPToPix(getContext(), 48)));
    AppMethodBeat.o(33621);
  }
  
  private void nj(List<String> paramList)
  {
    int k = 0;
    AppMethodBeat.i(33628);
    if ((this.adIp != null) && (this.adIp.getVisibility() == 0)) {
      this.adIp.removeAllViews();
    }
    for (int j = 1;; j = 0)
    {
      int i = j;
      if (this.adIq != null)
      {
        i = j;
        if (this.adIq.getVisibility() == 0)
        {
          this.adIq.removeAllViews();
          i = 1;
        }
      }
      j = i;
      if (this.adIr != null)
      {
        j = i;
        if (this.adIr.getVisibility() == 0)
        {
          this.adIr.removeAllViews();
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
          LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 40), com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 40));
          localLayoutParams.rightMargin = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 8);
          localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
          localImageView.setLayoutParams(localLayoutParams);
          if (i < this.adIu) {
            this.adIp.addView(localImageView);
          }
          for (;;)
          {
            a.b.g(localImageView, str);
            i += 1;
            break;
            if ((i >= this.adIu) && (i < this.adIu * 2)) {
              this.adIq.addView(localImageView);
            } else if ((i >= this.adIu * 2) && (i < this.adIu * 3)) {
              this.adIr.addView(localImageView);
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
    this.adIh.setTextColor(getResources().getColor(R.e.multitalk_popup_nav_black_text_color));
    this.adIh.setText(paramString);
    if ((this.adIp == null) || (this.adIp.getVisibility() != 0))
    {
      this.adIh.setVisibility(0);
      this.adIj.setVisibility(8);
      this.adIi.setVisibility(8);
      this.adIp.setVisibility(8);
    }
    AppMethodBeat.o(33625);
  }
  
  private void setInvitingBannerStyle(String paramString)
  {
    AppMethodBeat.i(33624);
    this.adIi.setTextColor(getResources().getColor(R.e.multitalk_popup_nav_black_text_color));
    this.adIi.setText(paramString);
    this.adIh.setVisibility(8);
    this.adIj.setVisibility(0);
    this.adIi.setVisibility(0);
    this.adIp.setVisibility(8);
    AppMethodBeat.o(33624);
  }
  
  private void setInvitingBannerStyleWithText(String paramString)
  {
    AppMethodBeat.i(249462);
    this.adIg.setBackgroundResource(R.g.multitalk_talking_banner_shape);
    this.adIh.setVisibility(8);
    this.adIj.setVisibility(0);
    this.adIj.setText(paramString);
    this.adIi.setVisibility(0);
    this.adIp.setVisibility(8);
    AppMethodBeat.o(249462);
  }
  
  private void setTalkingBannerStyle(String paramString)
  {
    AppMethodBeat.i(33623);
    this.adIh.setTextColor(getResources().getColor(R.e.multitalk_popup_nav_green_text_color));
    this.adIh.setText(paramString);
    this.adIh.setVisibility(0);
    this.adIj.setVisibility(8);
    this.adIi.setVisibility(8);
    AppMethodBeat.o(33623);
  }
  
  public final void Lp(boolean paramBoolean)
  {
    AppMethodBeat.i(33622);
    this.adIs = false;
    if ((this.adIk == null) || (this.adIl == null))
    {
      Log.e("MicroMsg.MultiTalkRoomPopupNav", "groupUserName or currentSenderUserName is null! groupUserName:" + this.adIk + ",currentSenderUserName:" + this.adIl);
      AppMethodBeat.o(33622);
      return;
    }
    Object localObject = this.adIk;
    if (!((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.multitalk.model.d.class)).aMO((String)localObject))
    {
      jkA();
      AppMethodBeat.o(33622);
      return;
    }
    List localList = ((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.multitalk.model.d.class)).aMR((String)localObject);
    if (localList.size() == 0)
    {
      ((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.multitalk.model.d.class)).iP((String)localObject);
      jkA();
      AppMethodBeat.o(33622);
      return;
    }
    int i = ((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.multitalk.model.d.class)).km((String)localObject, this.adIl);
    String str;
    if (i == 1)
    {
      setUserTalkingStatus(b.adIy);
      if (((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.multitalk.model.d.class)).aMS((String)localObject))
      {
        jkA();
        AppMethodBeat.o(33622);
        return;
      }
      str = com.tencent.mm.plugin.multitalk.e.f.gjc();
      if (str == null) {
        setInvitingBannerStyle(((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.multitalk.model.d.class)).getDisplayName(((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.multitalk.model.d.class)).kn((String)localObject, this.adIl)));
      }
    }
    for (;;)
    {
      setVisibility(0);
      this.adIf.setVisibility(0);
      this.adIf.sendAccessibilityEvent(32768);
      if ((this.adIn != null) && ((paramBoolean) || (this.adIp == null) || (this.adIp.getVisibility() != 0))) {
        this.adIn.close();
      }
      nj(K(localList, ""));
      if ((this.adIn == null) || (this.adIn.adIw == null)) {
        break label560;
      }
      if (this.adIn.adIw.getVisibility() != 0) {
        break;
      }
      Lo(true);
      AppMethodBeat.o(33622);
      return;
      setInvitingBannerStyleWithText(str);
      continue;
      if (i == 10)
      {
        setUserTalkingStatus(b.adIz);
        if (((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.multitalk.model.d.class)).aMS((String)localObject))
        {
          jkA();
          AppMethodBeat.o(33622);
          return;
        }
        if (((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.multitalk.model.d.class)).geX())
        {
          jkA();
          AppMethodBeat.o(33622);
          return;
        }
        str = com.tencent.mm.plugin.multitalk.e.f.gje();
        setUserTalkingStatus(b.adIA);
        localObject = str;
        if (str == null) {
          localObject = MMApplicationContext.getContext().getString(R.l.multitalk_somepepole_in_tip, new Object[] { Integer.valueOf(localList.size()) });
        }
        setDefaultBannerStyle((String)localObject);
      }
      else
      {
        setUserTalkingStatus(b.adIA);
        str = com.tencent.mm.plugin.multitalk.e.f.gje();
        localObject = str;
        if (str == null) {
          localObject = MMApplicationContext.getContext().getString(R.l.multitalk_somepepole_in_tip, new Object[] { Integer.valueOf(localList.size()) });
        }
        setDefaultBannerStyle((String)localObject);
      }
    }
    Lo(false);
    label560:
    AppMethodBeat.o(33622);
  }
  
  public final void jkA()
  {
    AppMethodBeat.i(33626);
    this.adIs = false;
    setVisibility(8);
    if (this.adIn != null) {
      this.adIn.close();
    }
    AppMethodBeat.o(33626);
  }
  
  public void setChattingContext(com.tencent.mm.ui.chatting.d.a parama)
  {
    this.adCQ = parama;
  }
  
  public void setCurrentSenderUserName(String paramString)
  {
    this.adIl = paramString;
  }
  
  public void setGroupUserName(String paramString)
  {
    this.adIk = paramString;
  }
  
  public void setInChatRoom(boolean paramBoolean)
  {
    this.adDd = paramBoolean;
  }
  
  public void setMultiTalkInfo(com.tencent.mm.bc.f paramf)
  {
    this.adIt = paramf;
  }
  
  public void setRootTipsBarBackground(View paramView)
  {
    this.adDa = paramView;
  }
  
  public void setUserTalkingStatus(b paramb)
  {
    this.adIm = paramb;
  }
  
  public final class a
  {
    public LinearLayout adIw;
    View puX;
    TextView titleView;
    
    private a()
    {
      AppMethodBeat.i(249543);
      this.puX = MultiTalkRoomPopupNav.this.findViewById(R.h.close_img);
      this.titleView = ((TextView)MultiTalkRoomPopupNav.this.findViewById(R.h.multitalk_tv_dialog_title));
      this.adIw = ((LinearLayout)MultiTalkRoomPopupNav.this.findViewById(R.h.dialog_root));
      AppMethodBeat.o(249543);
    }
    
    public final void close()
    {
      AppMethodBeat.i(33615);
      MultiTalkRoomPopupNav.a(MultiTalkRoomPopupNav.this, false);
      if (this.adIw.getVisibility() == 0)
      {
        Animation localAnimation = AnimationUtils.loadAnimation(MultiTalkRoomPopupNav.this.getContext(), R.a.push_up_out);
        localAnimation.setAnimationListener(new Animation.AnimationListener()
        {
          public final void onAnimationEnd(Animation paramAnonymousAnimation)
          {
            AppMethodBeat.i(249719);
            MultiTalkRoomPopupNav.a.this.adIw.setVisibility(8);
            AppMethodBeat.o(249719);
          }
          
          public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
          
          public final void onAnimationStart(Animation paramAnonymousAnimation) {}
        });
        this.adIw.startAnimation(localAnimation);
      }
      AppMethodBeat.o(33615);
    }
  }
  
  static enum b
  {
    static
    {
      AppMethodBeat.i(33618);
      adIy = new b("Inviting", 0);
      adIz = new b("Talking", 1);
      adIA = new b("NotInTalking", 2);
      adIB = new b[] { adIy, adIz, adIA };
      AppMethodBeat.o(33618);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.MultiTalkRoomPopupNav
 * JD-Core Version:    0.7.0.1
 */