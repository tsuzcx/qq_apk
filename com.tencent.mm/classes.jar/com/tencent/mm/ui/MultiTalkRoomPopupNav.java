package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.bf.f;
import com.tencent.mm.bg.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MultiTalkRoomPopupNav
  extends LinearLayout
{
  public boolean uPA = false;
  private f uPB = new f();
  public LinearLayout uPo;
  public View uPp;
  private TextView uPq;
  private TextView uPr;
  private TextView uPs;
  public String uPt;
  public String uPu;
  private boolean uPv;
  private MultiTalkRoomPopupNav.b uPw = MultiTalkRoomPopupNav.b.uPG;
  public MultiTalkRoomPopupNav.a uPx;
  private final int uPy = 6;
  public LinearLayout uPz;
  
  public MultiTalkRoomPopupNav(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initView();
  }
  
  @TargetApi(11)
  public MultiTalkRoomPopupNav(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView();
  }
  
  private void d(String paramString1, List<String> paramList, final String paramString2)
  {
    this.uPp.setVisibility(8);
    this.uPo.setVisibility(8);
    if (this.uPw == MultiTalkRoomPopupNav.b.uPE) {}
    MultiTalkRoomPopupNav.a locala;
    View.OnClickListener local2;
    for (boolean bool = true;; bool = false)
    {
      this.uPx = new MultiTalkRoomPopupNav.a(this, bool, (byte)0);
      locala = this.uPx;
      local2 = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          y.i("MicroMsg.MultiTalkRoomPopupNav", "click enter button..");
          if (paramString2 != null)
          {
            if (((com.tencent.mm.plugin.multitalk.a.a)g.r(com.tencent.mm.plugin.multitalk.a.a.class)).bkB())
            {
              y.e("MicroMsg.MultiTalkRoomPopupNav", "now is in other voip..");
              com.tencent.mm.ui.base.h.b(MultiTalkRoomPopupNav.this.getContext(), ae.getContext().getString(R.l.multitalk_is_talking_cannot_enter), null, true);
              return;
            }
            paramAnonymousView = ((com.tencent.mm.plugin.multitalk.a.a)g.r(com.tencent.mm.plugin.multitalk.a.a.class)).Iw(MultiTalkRoomPopupNav.b(MultiTalkRoomPopupNav.this));
            if (paramAnonymousView.size() != 1) {
              break label228;
            }
            MultiTalkRoomPopupNav.acX(paramString2);
            com.tencent.mm.plugin.report.service.h.nFQ.f(13945, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), MultiTalkRoomPopupNav.b(MultiTalkRoomPopupNav.this), Integer.valueOf(MultiTalkRoomPopupNav.c(MultiTalkRoomPopupNav.this).field_roomId), Long.valueOf(MultiTalkRoomPopupNav.c(MultiTalkRoomPopupNav.this).field_roomKey) });
          }
          for (;;)
          {
            MultiTalkRoomPopupNav.a.a(MultiTalkRoomPopupNav.e(MultiTalkRoomPopupNav.this));
            MultiTalkRoomPopupNav.f(MultiTalkRoomPopupNav.this).setVisibility(0);
            MultiTalkRoomPopupNav.g(MultiTalkRoomPopupNav.this).setVisibility(0);
            MultiTalkRoomPopupNav.h(MultiTalkRoomPopupNav.this).setVisibility(8);
            return;
            label228:
            int i;
            if (paramAnonymousView.size() >= 9)
            {
              y.e("MicroMsg.MultiTalkRoomPopupNav", "now is up to the limit,memberList size:" + paramAnonymousView.size());
              com.tencent.mm.ui.base.h.b(MultiTalkRoomPopupNav.this.getContext(), ae.getContext().getString(R.l.multitalk_members_reach_max_limit, new Object[] { Integer.valueOf(9) }), null, true);
              paramAnonymousView = com.tencent.mm.plugin.report.service.h.nFQ;
              if (MultiTalkRoomPopupNav.d(MultiTalkRoomPopupNav.this) == MultiTalkRoomPopupNav.b.uPE) {}
              for (i = 1;; i = 0)
              {
                paramAnonymousView.f(13945, new Object[] { Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(1), MultiTalkRoomPopupNav.b(MultiTalkRoomPopupNav.this), Integer.valueOf(MultiTalkRoomPopupNav.c(MultiTalkRoomPopupNav.this).field_roomId), Long.valueOf(MultiTalkRoomPopupNav.c(MultiTalkRoomPopupNav.this).field_roomKey) });
                return;
              }
            }
            if (((com.tencent.mm.plugin.multitalk.a.a)g.r(com.tencent.mm.plugin.multitalk.a.a.class)).bkA())
            {
              y.e("MicroMsg.MultiTalkRoomPopupNav", "now is inviting other people voip..");
              com.tencent.mm.ui.base.h.b(MultiTalkRoomPopupNav.this.getContext(), ae.getContext().getString(R.l.multitalk_inviting_in_another_group), null, true);
              paramAnonymousView = com.tencent.mm.plugin.report.service.h.nFQ;
              if (MultiTalkRoomPopupNav.d(MultiTalkRoomPopupNav.this) == MultiTalkRoomPopupNav.b.uPE) {}
              for (i = 1;; i = 0)
              {
                paramAnonymousView.f(13945, new Object[] { Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(1), MultiTalkRoomPopupNav.b(MultiTalkRoomPopupNav.this), Integer.valueOf(MultiTalkRoomPopupNav.c(MultiTalkRoomPopupNav.this).field_roomId), Long.valueOf(MultiTalkRoomPopupNav.c(MultiTalkRoomPopupNav.this).field_roomKey) });
                return;
              }
            }
            MultiTalkRoomPopupNav.a(MultiTalkRoomPopupNav.this, paramString2);
          }
        }
      };
      paramString2 = new MultiTalkRoomPopupNav.3(this, paramString2);
      locala.titleView.setText(paramString1);
      locala.uPD.setVisibility(0);
      locala.uPC.uPz.setVisibility(0);
      locala.uPC.uPz.removeAllViews();
      paramString1 = paramList.iterator();
      while (paramString1.hasNext())
      {
        paramList = (String)paramString1.next();
        ImageView localImageView = new ImageView(locala.uPC.getContext());
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(com.tencent.mm.cb.a.fromDPToPix(ae.getContext(), 26), com.tencent.mm.cb.a.fromDPToPix(ae.getContext(), 26));
        localLayoutParams.rightMargin = com.tencent.mm.cb.a.fromDPToPix(ae.getContext(), 10);
        localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        localImageView.setLayoutParams(localLayoutParams);
        locala.uPC.uPz.addView(localImageView);
        a.b.a(localImageView, paramList, 0.1F, false);
      }
    }
    ((Button)locala.uPC.findViewById(R.h.multitalk_alert_enter_btn)).setOnClickListener(local2);
    ((Button)locala.uPC.findViewById(R.h.multitalk_alert_cancel_btn)).setOnClickListener(paramString2);
  }
  
  private void initView()
  {
    inflate(getContext(), R.i.multitalk_room_popup_nav, this);
    this.uPo = ((LinearLayout)findViewById(R.h.multitalk_nav_layout));
    this.uPp = findViewById(R.h.multitalk_nav_bg);
    this.uPq = ((TextView)findViewById(R.h.multitalk_tv_nav_content));
    this.uPr = ((TextView)findViewById(R.h.multitalk_tv_nav_content2));
    this.uPs = ((TextView)findViewById(R.h.multitalk_tv_nav_inviting));
    this.uPz = ((LinearLayout)findViewById(R.h.multitalk_image_list_layout));
    this.uPo.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        if ((d.eEX != null) && (((com.tencent.mm.plugin.multitalk.a.a)g.r(com.tencent.mm.plugin.multitalk.a.a.class)).bk(MultiTalkRoomPopupNav.this.getContext())))
        {
          y.d("MicroMsg.MultiTalkRoomPopupNav", "is voip talking");
          return;
        }
        if ((d.eEX != null) && (d.eEX.RU()))
        {
          Toast.makeText(ae.getContext(), ae.getContext().getString(R.l.in_new_share_location_tip), 0).show();
          y.d("MicroMsg.MultiTalkRoomPopupNav", "is show loation");
          return;
        }
        MultiTalkRoomPopupNav.a(MultiTalkRoomPopupNav.this);
      }
    });
  }
  
  public static List<String> k(List<String> paramList, String paramString)
  {
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
    return localArrayList2;
  }
  
  private void setTalkingBannerStyle(String paramString)
  {
    this.uPp.setBackgroundResource(R.g.multitalk_talking_banner_shape);
    this.uPq.setTextColor(getResources().getColor(R.e.multitalk_popup_nav_green_text_color));
    this.uPq.setText(paramString);
    this.uPq.setVisibility(0);
    this.uPs.setVisibility(8);
    this.uPr.setVisibility(8);
  }
  
  public final void czY()
  {
    this.uPA = false;
    setVisibility(8);
    if (this.uPx != null) {
      MultiTalkRoomPopupNav.a.a(this.uPx);
    }
  }
  
  public final void dL(List<String> paramList)
  {
    if ((this.uPz != null) && (this.uPz.getVisibility() == 0))
    {
      this.uPz.removeAllViews();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        ImageView localImageView = new ImageView(getContext());
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(com.tencent.mm.cb.a.fromDPToPix(ae.getContext(), 26), com.tencent.mm.cb.a.fromDPToPix(ae.getContext(), 26));
        localLayoutParams.rightMargin = com.tencent.mm.cb.a.fromDPToPix(ae.getContext(), 10);
        localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        localImageView.setLayoutParams(localLayoutParams);
        this.uPz.addView(localImageView);
        a.b.a(localImageView, str, 0.1F, false);
      }
    }
  }
  
  public void setCurrentSenderUserName(String paramString)
  {
    this.uPu = paramString;
  }
  
  public void setDefaultBannerStyle(String paramString)
  {
    this.uPp.setBackgroundResource(R.g.multitalk_default_banner_shape);
    this.uPq.setTextColor(getResources().getColor(R.e.multitalk_popup_nav_black_text_color));
    this.uPq.setText(paramString);
    if ((this.uPz == null) || (this.uPz.getVisibility() != 0))
    {
      this.uPq.setVisibility(0);
      this.uPs.setVisibility(8);
      this.uPr.setVisibility(8);
      this.uPz.setVisibility(8);
    }
  }
  
  public void setGroupUserName(String paramString)
  {
    this.uPt = paramString;
  }
  
  public void setInChatRoom(boolean paramBoolean)
  {
    this.uPv = paramBoolean;
  }
  
  public void setInvitingBannerStyle(String paramString)
  {
    this.uPp.setBackgroundResource(R.g.multitalk_talking_banner_shape);
    this.uPr.setTextColor(getResources().getColor(R.e.multitalk_popup_nav_black_text_color));
    this.uPr.setText(paramString);
    this.uPq.setVisibility(8);
    this.uPs.setVisibility(0);
    this.uPr.setVisibility(0);
    this.uPz.setVisibility(8);
  }
  
  public void setMultiTalkInfo(f paramf)
  {
    this.uPB = paramf;
  }
  
  public void setUserTalkingStatus(MultiTalkRoomPopupNav.b paramb)
  {
    this.uPw = paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.MultiTalkRoomPopupNav
 * JD-Core Version:    0.7.0.1
 */