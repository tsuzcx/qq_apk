package com.tencent.mm.plugin.multitalk.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.multitalk.model.f;
import com.tencent.mm.plugin.multitalk.model.p;
import com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import java.util.ArrayList;
import java.util.List;

public final class c
  implements View.OnClickListener
{
  private TextView jTd;
  private TextView oVA;
  private ImageView oVB;
  private LinearLayout oVC;
  private ImageButton oVD;
  private ImageButton oVE;
  private MultiTalkMainUI oVy;
  private View oVz;
  
  public c(MultiTalkMainUI paramMultiTalkMainUI)
  {
    AppMethodBeat.i(54188);
    this.oVy = paramMultiTalkMainUI;
    this.oVz = paramMultiTalkMainUI.findViewById(2131826408);
    this.oVA = ((TextView)paramMultiTalkMainUI.findViewById(2131826410));
    this.oVB = ((ImageView)paramMultiTalkMainUI.findViewById(2131826409));
    this.oVC = ((LinearLayout)paramMultiTalkMainUI.findViewById(2131826412));
    this.jTd = ((TextView)paramMultiTalkMainUI.findViewById(2131826411));
    this.oVD = ((ImageButton)paramMultiTalkMainUI.findViewById(2131826414));
    this.oVE = ((ImageButton)paramMultiTalkMainUI.findViewById(2131826413));
    this.oVD.setOnClickListener(this);
    this.oVE.setOnClickListener(this);
    AppMethodBeat.o(54188);
  }
  
  public final void bTM()
  {
    AppMethodBeat.i(54190);
    this.oVz.setVisibility(8);
    AppMethodBeat.o(54190);
  }
  
  public final void n(MultiTalkGroup paramMultiTalkGroup)
  {
    int j = 0;
    AppMethodBeat.i(54189);
    this.oVz.setVisibility(0);
    Object localObject = com.tencent.mm.plugin.multitalk.model.j.bTv();
    ArrayList localArrayList = new ArrayList();
    int i;
    if (!bo.isNullOrNil((String)localObject))
    {
      i = 0;
      while (i < paramMultiTalkGroup.Bhp.size())
      {
        if (!((MultiTalkGroupMember)paramMultiTalkGroup.Bhp.get(i)).Bhq.equals(localObject)) {
          localArrayList.add(((MultiTalkGroupMember)paramMultiTalkGroup.Bhp.get(i)).Bhq);
        }
        i += 1;
      }
      this.oVA.setText(com.tencent.mm.pluginsdk.ui.d.j.b(this.oVy, s.nE((String)localObject)));
      a.b.a(this.oVB, (String)localObject, 0.1F, true);
    }
    if (localArrayList.size() > 0)
    {
      this.jTd.setVisibility(0);
      this.jTd.setText(2131301686);
      this.oVC.setVisibility(0);
      this.oVC.removeAllViews();
      i = j;
      while (i < localArrayList.size())
      {
        paramMultiTalkGroup = new ImageView(this.oVy.getContext());
        j = b.oVr;
        localObject = new LinearLayout.LayoutParams(j, j);
        if (i != 0) {
          ((LinearLayout.LayoutParams)localObject).leftMargin = b.oVp;
        }
        paramMultiTalkGroup.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.oVC.addView(paramMultiTalkGroup);
        a.b.c(paramMultiTalkGroup, (String)localArrayList.get(i));
        i += 1;
      }
      AppMethodBeat.o(54189);
      return;
    }
    this.jTd.setVisibility(8);
    this.oVC.setVisibility(8);
    AppMethodBeat.o(54189);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(54191);
    if (paramView.getId() == 2131826413)
    {
      p.bTF().f(true, false, false);
      AppMethodBeat.o(54191);
      return;
    }
    if (paramView.getId() == 2131826414)
    {
      paramView = p.bTF();
      if (paramView.bSD())
      {
        ab.i("MicroMsg.MT.MultiTalkManager", "acceptCurrentMultiTalk: %s", new Object[] { com.tencent.mm.plugin.multitalk.model.j.h(paramView.oTs) });
        p.bTE().oTa.A(paramView.oTs.Bhl, paramView.oTs.Bda, paramView.oTs.Bhn);
        AppMethodBeat.o(54191);
        return;
      }
      ab.e("MicroMsg.MT.MultiTalkManager", "acceptCurrentMultiTalk: Not in MultiTalking");
    }
    AppMethodBeat.o(54191);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.c
 * JD-Core Version:    0.7.0.1
 */