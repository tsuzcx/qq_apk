package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.modelsns.e;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.j.g;
import com.tencent.mm.plugin.sns.j.h;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.bb;
import com.tencent.mm.plugin.sns.model.bc;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bvq;
import com.tencent.mm.protocal.protobuf.dhj;
import com.tencent.mm.protocal.protobuf.jb;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.z;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class af
  implements ac
{
  private String appId;
  private String appName;
  private String dHo;
  private String dHu;
  private final MMActivity fLP;
  public String hCk = "";
  public String hCl = "";
  private String mSessionId;
  private View rY = null;
  private String title = "";
  private TextView titleTv = null;
  private byte[] zQb = null;
  private String zQc;
  private int zQd;
  CdnImageView zQe = null;
  private TextView zQf = null;
  private e zQj = null;
  private String zQk = "";
  private boolean zRC = false;
  private boolean zRD = false;
  private WXMediaMessage zRE = null;
  private int zRJ = 0;
  private e zRK = null;
  private int zRL = 0;
  private String zSL;
  jb zSM = null;
  private int znT = 1;
  
  public af(MMActivity paramMMActivity)
  {
    this.fLP = paramMMActivity;
  }
  
  public final boolean a(int paramInt1, int paramInt2, org.b.d.i parami, String paramString1, List<String> paramList1, bvq parambvq, LinkedList<Long> paramLinkedList, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(198182);
    paramLinkedList = new bc(33);
    paramPInt.value = paramLinkedList.beN;
    if (paramInt3 > com.tencent.mm.plugin.sns.c.a.zbZ) {
      paramLinkedList.Qb(4);
    }
    paramLinkedList.azo(this.title).azj(paramString1);
    paramLinkedList.azm(bt.bI(this.fLP.getIntent().getStringExtra("ksnsupload_link_desc"), ""));
    if (this.zRL == 15) {
      paramLinkedList.azm(bt.bI(this.fLP.getIntent().getStringExtra("fav_note_link_description"), ""));
    }
    if (this.zSM != null)
    {
      paramString1 = this.zSM;
      if (paramString1 != null) {
        paramLinkedList.znM.HAT.GaW = paramString1;
      }
    }
    paramLinkedList.cc(this.znT, this.zQk);
    paramLinkedList.Qg(this.zQd);
    paramLinkedList.azr(this.dHo);
    paramLinkedList.azs(this.zQc);
    paramLinkedList.Qe(paramInt1);
    if (paramBoolean) {
      paramLinkedList.Qh(1);
    }
    for (;;)
    {
      paramLinkedList.fL(paramList2);
      paramString1 = new LinkedList();
      if (paramList1 == null) {
        break;
      }
      new LinkedList();
      paramList2 = com.tencent.mm.pluginsdk.i.d.fas();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        paramPInt = (String)paramList1.next();
        if (!paramList2.contains(paramPInt))
        {
          dhj localdhj = new dhj();
          localdhj.nDo = paramPInt;
          paramString1.add(localdhj);
        }
      }
      paramLinkedList.Qh(0);
    }
    if (parami != null) {
      paramLinkedList.jr(parami.token, parami.GTp);
    }
    paramLinkedList.aU(paramString1);
    if (!bt.isNullOrNil(this.appId)) {
      paramLinkedList.azp(this.appId);
    }
    if (!bt.isNullOrNil(this.appName)) {
      paramLinkedList.azq(bt.bI(this.appName, ""));
    }
    if (this.zRC) {
      paramLinkedList.Qg(5);
    }
    paramLinkedList.a(parambvq);
    if ((this.zRD) && (this.zRE != null))
    {
      paramLinkedList.azk(this.zRE.mediaTagName);
      paramLinkedList.aD(this.appId, this.zRE.messageExt, this.zRE.messageAction);
    }
    paramLinkedList.azl(paramString2);
    paramLinkedList.azu(this.dHu);
    paramLinkedList.setSessionId(this.mSessionId);
    paramLinkedList.Qc(this.zRJ);
    paramInt1 = paramLinkedList.commit();
    if (this.zQj != null)
    {
      this.zQj.pX(paramInt1);
      g.zus.c(this.zQj);
    }
    if (this.zRK != null)
    {
      this.zRK.pX(paramInt1);
      h.zus.c(this.zRK);
      this.zRK.aLk();
    }
    ag.dUa().dSE();
    this.fLP.finish();
    AppMethodBeat.o(198182);
    return false;
  }
  
  public final void ap(Bundle paramBundle)
  {
    AppMethodBeat.i(198180);
    this.appId = bt.bI(this.fLP.getIntent().getStringExtra("Ksnsupload_appid"), "");
    this.appName = bt.bI(this.fLP.getIntent().getStringExtra("Ksnsupload_appname"), "");
    this.zQd = this.fLP.getIntent().getIntExtra("Ksnsupload_source", 0);
    this.dHo = bt.bI(this.fLP.getIntent().getStringExtra("src_username"), "");
    this.zQc = bt.bI(this.fLP.getIntent().getStringExtra("src_displayname"), "");
    this.dHu = bt.bI(this.fLP.getIntent().getStringExtra("KPublisherId"), "");
    this.mSessionId = bt.bI(this.fLP.getIntent().getStringExtra("reportSessionId"), "");
    this.zSL = bt.bI(this.fLP.getIntent().getStringExtra("ksnsupload_mp_video_xml"), "");
    if (!bt.isNullOrNil(this.zSL))
    {
      paramBundle = bw.M(this.zSL, "mmbrandmpvideo");
      if (paramBundle != null) {
        this.zSM = com.tencent.mm.modelsns.d.j("", paramBundle);
      }
    }
    AppMethodBeat.o(198180);
  }
  
  public final void aq(Bundle paramBundle) {}
  
  public final boolean dZG()
  {
    return true;
  }
  
  public final View dZH()
  {
    AppMethodBeat.i(198181);
    this.rY = z.jO(this.fLP).inflate(2131495816, null);
    this.rY.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(198179);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/MPVideoWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
        if (af.this.zSM != null)
        {
          localObject = new Rect();
          int[] arrayOfInt = new int[2];
          af.this.zQe.getLocationOnScreen(arrayOfInt);
          ((Rect)localObject).set(arrayOfInt[0], arrayOfInt[1], arrayOfInt[0] + af.this.zQe.getMeasuredWidth(), arrayOfInt[1] + af.this.zQe.getMeasuredHeight());
          com.tencent.mm.modelsns.d.a(paramAnonymousView.getContext(), af.this.zSM, (Rect)localObject);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/MPVideoWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(198179);
      }
    });
    this.zQe = ((CdnImageView)this.rY.findViewById(2131300948));
    this.titleTv = ((TextView)this.rY.findViewById(2131305950));
    this.zQf = ((TextView)this.rY.findViewById(2131304202));
    Object localObject = (ImageView)this.rY.findViewById(2131305185);
    ((ImageView)localObject).setImageDrawable(ao.k(this.fLP, 2131690672, -1));
    ((ImageView)localObject).setVisibility(0);
    this.zQe.setVisibility(0);
    if (this.zSM != null)
    {
      this.zQe.setUrl(this.zSM.hDm);
      this.titleTv.setText(this.zSM.title);
    }
    q.b(this.zQe, this.fLP);
    localObject = this.rY;
    AppMethodBeat.o(198181);
    return localObject;
  }
  
  public final boolean dZI()
  {
    return false;
  }
  
  public final boolean k(int paramInt, Intent paramIntent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.af
 * JD-Core Version:    0.7.0.1
 */