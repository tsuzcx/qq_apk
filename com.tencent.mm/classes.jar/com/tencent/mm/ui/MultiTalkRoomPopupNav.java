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
import com.tencent.mm.kernel.g;
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
  private View GDE;
  private View OFk;
  private com.tencent.mm.ui.chatting.e.a OFl;
  private WeImageView OFm;
  private boolean OFo;
  private LinearLayout OJh;
  private View OJi;
  private TextView OJj;
  private TextView OJk;
  private TextView OJl;
  private String OJm;
  private String OJn;
  private b OJo;
  public a OJp;
  private final int OJq;
  private LinearLayout OJr;
  private LinearLayout OJs;
  private LinearLayout OJt;
  public boolean OJu;
  private f OJv;
  private int OJw;
  private View obi;
  
  public MultiTalkRoomPopupNav(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(33620);
    this.OJo = b.OJC;
    this.OJq = 6;
    this.OJu = false;
    this.OJv = new f();
    initView();
    AppMethodBeat.o(33620);
  }
  
  @TargetApi(11)
  public MultiTalkRoomPopupNav(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(33619);
    this.OJo = b.OJC;
    this.OJq = 6;
    this.OJu = false;
    this.OJv = new f();
    initView();
    AppMethodBeat.o(33619);
  }
  
  private void Bo(boolean paramBoolean)
  {
    AppMethodBeat.i(232683);
    if (this.OFk != null) {
      if (paramBoolean)
      {
        this.OFk.setVisibility(0);
        if (this.obi != null) {
          this.obi.setVisibility(8);
        }
        if (this.OJh != null) {
          this.OJh.setBackgroundColor(0);
        }
        if (this.OFm != null) {
          this.OFm.setVisibility(4);
        }
        if (this.OFl != null)
        {
          this.OFl.hideVKB();
          AppMethodBeat.o(232683);
        }
      }
      else
      {
        this.OFk.setVisibility(8);
        if (this.obi != null) {
          this.obi.setVisibility(0);
        }
        if (this.OJh != null) {
          this.OJh.setBackgroundResource(2131235312);
        }
        if (this.OFm != null) {
          this.OFm.setVisibility(0);
        }
      }
    }
    AppMethodBeat.o(232683);
  }
  
  private void d(String paramString1, List<String> paramList, final String paramString2)
  {
    AppMethodBeat.i(33627);
    this.OJh.setBackgroundColor(0);
    this.OFm.setVisibility(4);
    Object localObject = b.OJA;
    this.OJp = new a((byte)0);
    localObject = this.OJp;
    View.OnClickListener local2 = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33612);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/MultiTalkRoomPopupNav$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        Log.i("MicroMsg.MultiTalkRoomPopupNav", "click enter button..");
        if (paramString2 != null)
        {
          if (((com.tencent.mm.plugin.multitalk.model.d)g.af(com.tencent.mm.plugin.multitalk.model.d.class)).emq())
          {
            Log.e("MicroMsg.MultiTalkRoomPopupNav", "now is in other voip..");
            com.tencent.mm.ui.base.h.c(MultiTalkRoomPopupNav.this.getContext(), MMApplicationContext.getContext().getString(2131763273), null, true);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MultiTalkRoomPopupNav$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(33612);
            return;
          }
          paramAnonymousView = ((com.tencent.mm.plugin.multitalk.model.d)g.af(com.tencent.mm.plugin.multitalk.model.d.class)).aFK(MultiTalkRoomPopupNav.b(MultiTalkRoomPopupNav.this));
          if (paramAnonymousView.size() != 1) {
            break label307;
          }
          MultiTalkRoomPopupNav.blV(paramString2);
          com.tencent.mm.plugin.report.service.h.CyF.a(13945, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), MultiTalkRoomPopupNav.b(MultiTalkRoomPopupNav.this), Integer.valueOf(MultiTalkRoomPopupNav.c(MultiTalkRoomPopupNav.this).field_roomId), Long.valueOf(MultiTalkRoomPopupNav.c(MultiTalkRoomPopupNav.this).field_roomKey) });
        }
        for (;;)
        {
          MultiTalkRoomPopupNav.e(MultiTalkRoomPopupNav.this).close();
          MultiTalkRoomPopupNav.f(MultiTalkRoomPopupNav.this).setVisibility(0);
          MultiTalkRoomPopupNav.f(MultiTalkRoomPopupNav.this).setBackgroundResource(2131235312);
          MultiTalkRoomPopupNav.g(MultiTalkRoomPopupNav.this).setVisibility(0);
          MultiTalkRoomPopupNav.h(MultiTalkRoomPopupNav.this).setVisibility(8);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MultiTalkRoomPopupNav$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(33612);
          return;
          label307:
          int i;
          if (paramAnonymousView.size() >= e.epZ())
          {
            Log.e("MicroMsg.MultiTalkRoomPopupNav", "now is up to the limit,memberList size:" + paramAnonymousView.size());
            com.tencent.mm.ui.base.h.c(MultiTalkRoomPopupNav.this.getContext(), MMApplicationContext.getContext().getString(2131763279, new Object[] { Integer.valueOf(e.epZ()) }), null, true);
            paramAnonymousView = com.tencent.mm.plugin.report.service.h.CyF;
            if (MultiTalkRoomPopupNav.d(MultiTalkRoomPopupNav.this) == MultiTalkRoomPopupNav.b.OJA) {}
            for (i = 1;; i = 0)
            {
              paramAnonymousView.a(13945, new Object[] { Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(1), MultiTalkRoomPopupNav.b(MultiTalkRoomPopupNav.this), Integer.valueOf(MultiTalkRoomPopupNav.c(MultiTalkRoomPopupNav.this).field_roomId), Long.valueOf(MultiTalkRoomPopupNav.c(MultiTalkRoomPopupNav.this).field_roomKey) });
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MultiTalkRoomPopupNav$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(33612);
              return;
            }
          }
          if (((com.tencent.mm.plugin.multitalk.model.d)g.af(com.tencent.mm.plugin.multitalk.model.d.class)).emp())
          {
            Log.e("MicroMsg.MultiTalkRoomPopupNav", "now is inviting other people voip..");
            com.tencent.mm.ui.base.h.c(MultiTalkRoomPopupNav.this.getContext(), MMApplicationContext.getContext().getString(2131763271), null, true);
            paramAnonymousView = com.tencent.mm.plugin.report.service.h.CyF;
            if (MultiTalkRoomPopupNav.d(MultiTalkRoomPopupNav.this) == MultiTalkRoomPopupNav.b.OJA) {}
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
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/MultiTalkRoomPopupNav$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        Log.i("MicroMsg.MultiTalkRoomPopupNav", "click cancel button..");
        int i;
        if (MultiTalkRoomPopupNav.d(MultiTalkRoomPopupNav.this) == MultiTalkRoomPopupNav.b.OJA)
        {
          Log.i("MicroMsg.MultiTalkRoomPopupNav", "reject multiTalk!");
          boolean bool = ((com.tencent.mm.plugin.multitalk.model.d)g.af(com.tencent.mm.plugin.multitalk.model.d.class)).aFP(paramString2);
          ((com.tencent.mm.plugin.multitalk.model.d)g.af(com.tencent.mm.plugin.multitalk.model.d.class)).aFQ(paramString2);
          paramAnonymousView = com.tencent.mm.plugin.report.service.h.CyF;
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
          MultiTalkRoomPopupNav.f(MultiTalkRoomPopupNav.this).setBackgroundResource(2131235312);
          MultiTalkRoomPopupNav.g(MultiTalkRoomPopupNav.this).setVisibility(0);
          MultiTalkRoomPopupNav.h(MultiTalkRoomPopupNav.this).setVisibility(8);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MultiTalkRoomPopupNav$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(33613);
          return;
          i = 1;
          break;
          com.tencent.mm.plugin.report.service.h.CyF.a(13945, new Object[] { Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), MultiTalkRoomPopupNav.b(MultiTalkRoomPopupNav.this), Integer.valueOf(MultiTalkRoomPopupNav.c(MultiTalkRoomPopupNav.this).field_roomId), Long.valueOf(MultiTalkRoomPopupNav.c(MultiTalkRoomPopupNav.this).field_roomKey) });
        }
      }
    };
    ((a)localObject).titleView.setText(paramString1);
    if (((a)localObject).OJy.getVisibility() != 0)
    {
      ((a)localObject).OJy.setVisibility(0);
      ((a)localObject).OJy.startAnimation(AnimationUtils.loadAnimation(((a)localObject).OJx.getContext(), 2130772129));
      ((a)localObject).OJx.Bo(true);
      if (((a)localObject).OJx.OFk != null) {
        ((a)localObject).OJx.OFk.startAnimation(AnimationUtils.loadAnimation(((a)localObject).OJx.getContext(), 2130772059));
      }
    }
    ((a)localObject).OJx.OJr.setVisibility(0);
    ((a)localObject).OJx.OJr.removeAllViews();
    if (paramList != null)
    {
      if (paramList.size() > ((a)localObject).OJx.OJw)
      {
        ((a)localObject).OJx.OJs.setVisibility(0);
        ((a)localObject).OJx.OJs.removeAllViews();
      }
      if (paramList.size() > ((a)localObject).OJx.OJw * 2)
      {
        ((a)localObject).OJx.OJt.setVisibility(0);
        ((a)localObject).OJx.OJt.removeAllViews();
      }
    }
    paramString1 = paramList.iterator();
    int i = 0;
    if (paramString1.hasNext())
    {
      paramList = (String)paramString1.next();
      ImageView localImageView = new ImageView(((a)localObject).OJx.getContext());
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 40), com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 40));
      localLayoutParams.rightMargin = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 8);
      localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      localImageView.setLayoutParams(localLayoutParams);
      if (i < ((a)localObject).OJx.OJw) {
        ((a)localObject).OJx.OJr.addView(localImageView);
      }
      for (;;)
      {
        a.b.c(localImageView, paramList);
        i += 1;
        break;
        if ((i >= ((a)localObject).OJx.OJw) && (i < ((a)localObject).OJx.OJw * 2)) {
          ((a)localObject).OJx.OJs.addView(localImageView);
        } else if ((i >= ((a)localObject).OJx.OJw * 2) && (i < ((a)localObject).OJx.OJw * 3)) {
          ((a)localObject).OJx.OJt.addView(localImageView);
        }
      }
    }
    ((Button)((a)localObject).OJx.findViewById(2131305027)).setOnClickListener(local2);
    ((a)localObject).CBl.setOnClickListener(paramString2);
    if (((a)localObject).OJx.OFk != null) {
      ((a)localObject).OJx.OFk.setOnClickListener(paramString2);
    }
    AppMethodBeat.o(33627);
  }
  
  private void initView()
  {
    AppMethodBeat.i(33621);
    inflate(getContext(), 2131495735, this);
    this.GDE = findViewById(2131307166);
    this.obi = findViewById(2131297683);
    this.OJh = ((LinearLayout)findViewById(2131305047));
    this.OJj = ((TextView)findViewById(2131305064));
    this.OJk = ((TextView)findViewById(2131305065));
    this.OJl = ((TextView)findViewById(2131305066));
    this.OJr = ((LinearLayout)findViewById(2131305036));
    this.OJs = ((LinearLayout)findViewById(2131305035));
    this.OJt = ((LinearLayout)findViewById(2131305034));
    this.OFm = ((WeImageView)findViewById(2131297043));
    this.OJh.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33611);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/MultiTalkRoomPopupNav$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if ((com.tencent.mm.bi.d.jpA != null) && (((com.tencent.mm.plugin.multitalk.model.d)g.af(com.tencent.mm.plugin.multitalk.model.d.class)).cC(MultiTalkRoomPopupNav.this.getContext())))
        {
          Log.d("MicroMsg.MultiTalkRoomPopupNav", "is voip talking");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MultiTalkRoomPopupNav$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(33611);
          return;
        }
        if ((com.tencent.mm.bi.d.jpA != null) && (com.tencent.mm.bi.d.jpA.bgJ()))
        {
          Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(2131761777), 0).show();
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
    this.OJw = ((int)Math.floor((localDisplayMetrics.widthPixels - at.fromDPToPix(getContext(), 56)) / at.fromDPToPix(getContext(), 48)));
    AppMethodBeat.o(33621);
  }
  
  private void jc(List<String> paramList)
  {
    int k = 0;
    AppMethodBeat.i(33628);
    if ((this.OJr != null) && (this.OJr.getVisibility() == 0)) {
      this.OJr.removeAllViews();
    }
    for (int j = 1;; j = 0)
    {
      int i = j;
      if (this.OJs != null)
      {
        i = j;
        if (this.OJs.getVisibility() == 0)
        {
          this.OJs.removeAllViews();
          i = 1;
        }
      }
      j = i;
      if (this.OJt != null)
      {
        j = i;
        if (this.OJt.getVisibility() == 0)
        {
          this.OJt.removeAllViews();
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
          LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 40), com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 40));
          localLayoutParams.rightMargin = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 8);
          localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
          localImageView.setLayoutParams(localLayoutParams);
          if (i < this.OJw) {
            this.OJr.addView(localImageView);
          }
          for (;;)
          {
            a.b.c(localImageView, str);
            i += 1;
            break;
            if ((i >= this.OJw) && (i < this.OJw * 2)) {
              this.OJs.addView(localImageView);
            } else if ((i >= this.OJw * 2) && (i < this.OJw * 3)) {
              this.OJt.addView(localImageView);
            }
          }
        }
      }
      AppMethodBeat.o(33628);
      return;
    }
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
    this.OJj.setTextColor(getResources().getColor(2131100864));
    this.OJj.setText(paramString);
    if ((this.OJr == null) || (this.OJr.getVisibility() != 0))
    {
      this.OJj.setVisibility(0);
      this.OJl.setVisibility(8);
      this.OJk.setVisibility(8);
      this.OJr.setVisibility(8);
    }
    AppMethodBeat.o(33625);
  }
  
  private void setInvitingBannerStyle(String paramString)
  {
    AppMethodBeat.i(33624);
    this.OJk.setTextColor(getResources().getColor(2131100864));
    this.OJk.setText(paramString);
    this.OJj.setVisibility(8);
    this.OJl.setVisibility(0);
    this.OJk.setVisibility(0);
    this.OJr.setVisibility(8);
    AppMethodBeat.o(33624);
  }
  
  private void setInvitingBannerStyleWithText(String paramString)
  {
    AppMethodBeat.i(232684);
    this.OJi.setBackgroundResource(2131234089);
    this.OJj.setVisibility(8);
    this.OJl.setVisibility(0);
    this.OJl.setText(paramString);
    this.OJk.setVisibility(0);
    this.OJr.setVisibility(8);
    AppMethodBeat.o(232684);
  }
  
  private void setTalkingBannerStyle(String paramString)
  {
    AppMethodBeat.i(33623);
    this.OJj.setTextColor(getResources().getColor(2131100866));
    this.OJj.setText(paramString);
    this.OJj.setVisibility(0);
    this.OJl.setVisibility(8);
    this.OJk.setVisibility(8);
    AppMethodBeat.o(33623);
  }
  
  public final void Bp(boolean paramBoolean)
  {
    AppMethodBeat.i(33622);
    this.OJu = false;
    if ((this.OJm == null) || (this.OJn == null))
    {
      Log.e("MicroMsg.MultiTalkRoomPopupNav", "groupUserName or currentSenderUserName is null! groupUserName:" + this.OJm + ",currentSenderUserName:" + this.OJn);
      AppMethodBeat.o(33622);
      return;
    }
    Object localObject = this.OJm;
    if (!((com.tencent.mm.plugin.multitalk.model.d)g.af(com.tencent.mm.plugin.multitalk.model.d.class)).aFH((String)localObject))
    {
      gJt();
      AppMethodBeat.o(33622);
      return;
    }
    List localList = ((com.tencent.mm.plugin.multitalk.model.d)g.af(com.tencent.mm.plugin.multitalk.model.d.class)).aFK((String)localObject);
    if (localList.size() == 0)
    {
      ((com.tencent.mm.plugin.multitalk.model.d)g.af(com.tencent.mm.plugin.multitalk.model.d.class)).gC((String)localObject);
      gJt();
      AppMethodBeat.o(33622);
      return;
    }
    int i = ((com.tencent.mm.plugin.multitalk.model.d)g.af(com.tencent.mm.plugin.multitalk.model.d.class)).iM((String)localObject, this.OJn);
    String str;
    if (i == 1)
    {
      setUserTalkingStatus(b.OJA);
      if (((com.tencent.mm.plugin.multitalk.model.d)g.af(com.tencent.mm.plugin.multitalk.model.d.class)).aFL((String)localObject))
      {
        gJt();
        AppMethodBeat.o(33622);
        return;
      }
      str = e.eqg();
      if (str == null) {
        setInvitingBannerStyle(((com.tencent.mm.plugin.multitalk.model.d)g.af(com.tencent.mm.plugin.multitalk.model.d.class)).getDisplayName(((com.tencent.mm.plugin.multitalk.model.d)g.af(com.tencent.mm.plugin.multitalk.model.d.class)).iN((String)localObject, this.OJn)));
      }
    }
    for (;;)
    {
      setVisibility(0);
      this.OJh.setVisibility(0);
      if ((this.OJp != null) && ((paramBoolean) || (this.OJr == null) || (this.OJr.getVisibility() != 0))) {
        this.OJp.close();
      }
      jc(s(localList, ""));
      if ((this.OJp == null) || (this.OJp.OJy == null)) {
        break label551;
      }
      if (this.OJp.OJy.getVisibility() != 0) {
        break;
      }
      Bo(true);
      AppMethodBeat.o(33622);
      return;
      setInvitingBannerStyleWithText(str);
      continue;
      if (i == 10)
      {
        setUserTalkingStatus(b.OJB);
        if (((com.tencent.mm.plugin.multitalk.model.d)g.af(com.tencent.mm.plugin.multitalk.model.d.class)).aFL((String)localObject))
        {
          gJt();
          AppMethodBeat.o(33622);
          return;
        }
        if (((com.tencent.mm.plugin.multitalk.model.d)g.af(com.tencent.mm.plugin.multitalk.model.d.class)).ems())
        {
          gJt();
          AppMethodBeat.o(33622);
          return;
        }
        str = e.eqi();
        setUserTalkingStatus(b.OJC);
        localObject = str;
        if (str == null) {
          localObject = MMApplicationContext.getContext().getString(2131763301, new Object[] { Integer.valueOf(localList.size()) });
        }
        setDefaultBannerStyle((String)localObject);
      }
      else
      {
        setUserTalkingStatus(b.OJC);
        str = e.eqi();
        localObject = str;
        if (str == null) {
          localObject = MMApplicationContext.getContext().getString(2131763301, new Object[] { Integer.valueOf(localList.size()) });
        }
        setDefaultBannerStyle((String)localObject);
      }
    }
    Bo(false);
    label551:
    AppMethodBeat.o(33622);
  }
  
  public final void gJt()
  {
    AppMethodBeat.i(33626);
    this.OJu = false;
    setVisibility(8);
    if (this.OJp != null) {
      this.OJp.close();
    }
    AppMethodBeat.o(33626);
  }
  
  public void setChattingContext(com.tencent.mm.ui.chatting.e.a parama)
  {
    this.OFl = parama;
  }
  
  public void setCurrentSenderUserName(String paramString)
  {
    this.OJn = paramString;
  }
  
  public void setGroupUserName(String paramString)
  {
    this.OJm = paramString;
  }
  
  public void setInChatRoom(boolean paramBoolean)
  {
    this.OFo = paramBoolean;
  }
  
  public void setMultiTalkInfo(f paramf)
  {
    this.OJv = paramf;
  }
  
  public void setRootTipsBarBackground(View paramView)
  {
    this.OFk = paramView;
  }
  
  public void setUserTalkingStatus(b paramb)
  {
    this.OJo = paramb;
  }
  
  public final class a
  {
    View CBl;
    public LinearLayout OJy;
    TextView titleView;
    
    private a()
    {
      AppMethodBeat.i(232682);
      this.CBl = MultiTalkRoomPopupNav.this.findViewById(2131298781);
      this.titleView = ((TextView)MultiTalkRoomPopupNav.this.findViewById(2131305063));
      this.OJy = ((LinearLayout)MultiTalkRoomPopupNav.this.findViewById(2131299656));
      AppMethodBeat.o(232682);
    }
    
    public final void close()
    {
      AppMethodBeat.i(33615);
      MultiTalkRoomPopupNav.a(MultiTalkRoomPopupNav.this, false);
      if (this.OJy.getVisibility() == 0)
      {
        Animation localAnimation = AnimationUtils.loadAnimation(MultiTalkRoomPopupNav.this.getContext(), 2130772133);
        localAnimation.setAnimationListener(new Animation.AnimationListener()
        {
          public final void onAnimationEnd(Animation paramAnonymousAnimation)
          {
            AppMethodBeat.i(232681);
            MultiTalkRoomPopupNav.a.this.OJy.setVisibility(8);
            AppMethodBeat.o(232681);
          }
          
          public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
          
          public final void onAnimationStart(Animation paramAnonymousAnimation) {}
        });
        this.OJy.startAnimation(localAnimation);
      }
      AppMethodBeat.o(33615);
    }
  }
  
  static enum b
  {
    static
    {
      AppMethodBeat.i(33618);
      OJA = new b("Inviting", 0);
      OJB = new b("Talking", 1);
      OJC = new b("NotInTalking", 2);
      OJD = new b[] { OJA, OJB, OJC };
      AppMethodBeat.o(33618);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.MultiTalkRoomPopupNav
 * JD-Core Version:    0.7.0.1
 */