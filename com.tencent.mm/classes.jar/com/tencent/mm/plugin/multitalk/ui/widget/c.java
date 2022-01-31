package com.tencent.mm.plugin.multitalk.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.multitalk.a.d;
import com.tencent.mm.plugin.multitalk.a.g;
import com.tencent.mm.plugin.multitalk.a.f;
import com.tencent.mm.plugin.multitalk.a.p;
import com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import java.util.ArrayList;
import java.util.List;

public final class c
  implements View.OnClickListener
{
  private TextView icn;
  private MultiTalkMainUI mvG;
  private View mvH;
  private TextView mvI;
  private ImageView mvJ;
  private LinearLayout mvK;
  private ImageButton mvL;
  private ImageButton mvM;
  
  public c(MultiTalkMainUI paramMultiTalkMainUI)
  {
    this.mvG = paramMultiTalkMainUI;
    this.mvH = paramMultiTalkMainUI.findViewById(a.d.invite_layout);
    this.mvI = ((TextView)paramMultiTalkMainUI.findViewById(a.d.invite_main_nickname_tv));
    this.mvJ = ((ImageView)paramMultiTalkMainUI.findViewById(a.d.invite_main_avatar_iv));
    this.mvK = ((LinearLayout)paramMultiTalkMainUI.findViewById(a.d.small_avatar_iv_container));
    this.icn = ((TextView)paramMultiTalkMainUI.findViewById(a.d.introduce_tv));
    this.mvL = ((ImageButton)paramMultiTalkMainUI.findViewById(a.d.invite_pickup_btn));
    this.mvM = ((ImageButton)paramMultiTalkMainUI.findViewById(a.d.invite_hangup_btn));
    this.mvL.setOnClickListener(this);
    this.mvM.setOnClickListener(this);
  }
  
  public final void blL()
  {
    this.mvH.setVisibility(8);
  }
  
  public final void n(MultiTalkGroup paramMultiTalkGroup)
  {
    this.mvH.setVisibility(0);
    Object localObject = com.tencent.mm.plugin.multitalk.a.j.blv();
    ArrayList localArrayList = new ArrayList();
    int i;
    if (!bk.bl((String)localObject))
    {
      i = 0;
      while (i < paramMultiTalkGroup.wJP.size())
      {
        if (!((MultiTalkGroupMember)paramMultiTalkGroup.wJP.get(i)).wJQ.equals(localObject)) {
          localArrayList.add(((MultiTalkGroupMember)paramMultiTalkGroup.wJP.get(i)).wJQ);
        }
        i += 1;
      }
      this.mvI.setText(com.tencent.mm.pluginsdk.ui.d.j.b(this.mvG, r.gV((String)localObject)));
      a.b.a(this.mvJ, (String)localObject, 0.1F, true);
    }
    if (localArrayList.size() > 0)
    {
      this.icn.setVisibility(0);
      this.icn.setText(a.g.multitalk_member_wording);
      this.mvK.setVisibility(0);
      this.mvK.removeAllViews();
      i = 0;
      while (i < localArrayList.size())
      {
        paramMultiTalkGroup = new ImageView(this.mvG.mController.uMN);
        localObject = new LinearLayout.LayoutParams(b.mvz, b.mvz);
        if (i != 0) {
          ((LinearLayout.LayoutParams)localObject).leftMargin = b.mvx;
        }
        paramMultiTalkGroup.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.mvK.addView(paramMultiTalkGroup);
        a.b.a(paramMultiTalkGroup, (String)localArrayList.get(i), 0.1F, false);
        i += 1;
      }
    }
    this.icn.setVisibility(8);
    this.mvK.setVisibility(8);
  }
  
  public final void onClick(View paramView)
  {
    if (paramView.getId() == a.d.invite_hangup_btn) {
      p.blF().h(true, false, false);
    }
    while (paramView.getId() != a.d.invite_pickup_btn) {
      return;
    }
    paramView = p.blF();
    if (paramView.bkD())
    {
      y.i("MicroMsg.MT.MultiTalkManager", "acceptCurrentMultiTalk: %s", new Object[] { com.tencent.mm.plugin.multitalk.a.j.h(paramView.mtH) });
      p.blE().mtp.C(paramView.mtH.wJL, paramView.mtH.wFA, paramView.mtH.wJN);
      return;
    }
    y.e("MicroMsg.MT.MultiTalkManager", "acceptCurrentMultiTalk: Not in MultiTalking");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.c
 * JD-Core Version:    0.7.0.1
 */