package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.b.b;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SnsStrangerCommentDetailUI
  extends MMActivity
  implements b.b
{
  private static int rWv = 4;
  private long cIo;
  private int cpt;
  private ImageView gxs;
  private TextView khB;
  private View ozz;
  private an rFq;
  private com.tencent.mm.plugin.sns.storage.n rMD;
  private int rOD;
  private k.a rSM;
  private ListView rWn;
  private SnsCommentFooter rWo;
  private LinearLayout rWp;
  private List<View> rWq;
  private SnsStrangerCommentDetailUI.a rWr;
  private boolean rWs;
  private boolean rWt;
  private ad rWu;
  private String talker;
  
  public SnsStrangerCommentDetailUI()
  {
    AppMethodBeat.i(39329);
    this.rWs = false;
    this.rOD = -1;
    this.rWt = false;
    this.rSM = new SnsStrangerCommentDetailUI.7(this);
    AppMethodBeat.o(39329);
  }
  
  private static void a(int paramInt, MMImageView paramMMImageView)
  {
    int j = 2131230829;
    AppMethodBeat.i(39340);
    int i = j;
    switch (paramInt)
    {
    default: 
      i = j;
    }
    for (;;)
    {
      if (i != 0) {
        paramMMImageView.setImageResource(i);
      }
      AppMethodBeat.o(39340);
      return;
      i = 2131230809;
      continue;
      i = 2131230826;
      continue;
      i = 2131230807;
      continue;
      i = 2130837708;
      continue;
      i = 2130837708;
      continue;
      paramMMImageView.setImageDrawable(null);
      i = 0;
      continue;
      paramMMImageView.setImageDrawable(null);
      i = 0;
    }
  }
  
  private void cvQ()
  {
    AppMethodBeat.i(39336);
    this.rWp.removeAllViews();
    int j = BackwardSupportUtil.b.b(this, rWv);
    LinkedList localLinkedList = this.rMD.csh().xTS.wOa;
    this.rWq = new ArrayList();
    int i = 0;
    if (i < localLinkedList.size())
    {
      MMImageView localMMImageView = new MMImageView(this);
      localMMImageView.setPadding(j, j, j, j);
      this.rWp.addView(localMMImageView, new ViewGroup.LayoutParams(-2, -2));
      Bitmap localBitmap = ag.cpc().a((bcs)localLinkedList.get(i), localMMImageView, hashCode(), az.yNU).XS();
      if (localBitmap == null) {
        a(this.rMD.field_type, localMMImageView);
      }
      for (;;)
      {
        this.rWq.add(localMMImageView);
        i += 1;
        break;
        localMMImageView.setImageBitmap(localBitmap);
      }
    }
    AppMethodBeat.o(39336);
  }
  
  public final void ZU(String paramString)
  {
    AppMethodBeat.i(39341);
    cvQ();
    AppMethodBeat.o(39341);
  }
  
  public final void bp(String paramString, boolean paramBoolean) {}
  
  public final void bq(String paramString, boolean paramBoolean) {}
  
  public final void cnV() {}
  
  public int getLayoutId()
  {
    return 2130970816;
  }
  
  public void initView()
  {
    AppMethodBeat.i(39335);
    this.rWn = ((ListView)findViewById(2131827935));
    this.rWo = ((SnsCommentFooter)findViewById(2131822831));
    this.ozz = View.inflate(this, 2130970868, null);
    this.rWp = ((LinearLayout)this.ozz.findViewById(2131828094));
    this.gxs = ((ImageView)this.ozz.findViewById(2131827936));
    this.khB = ((TextView)this.ozz.findViewById(2131828093));
    a.b.u(this.gxs, this.rMD.field_userName);
    Object localObject = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.a.b.class)).nE(this.rMD.field_userName);
    this.khB.setText(com.tencent.mm.pluginsdk.ui.d.j.b(this, (CharSequence)localObject, this.khB.getTextSize()));
    cvQ();
    int i = 0;
    while (i < this.rWq.size())
    {
      localObject = new ao();
      ((ao)localObject).ctV = this.rMD.csH();
      ((ao)localObject).index = i;
      ((ao)localObject).rQS = this.rWq;
      ((View)this.rWq.get(i)).setTag(localObject);
      ((View)this.rWq.get(i)).setOnClickListener(new SnsStrangerCommentDetailUI.9(this));
      i += 1;
    }
    this.rWn.addHeaderView(this.ozz);
    this.rWr = new SnsStrangerCommentDetailUI.a(this, this);
    this.rWn.post(new SnsStrangerCommentDetailUI.10(this));
    this.rWn.setAdapter(this.rWr);
    this.rWn.setOnScrollListener(new SnsStrangerCommentDetailUI.11(this));
    this.rWo.setAfterEditAction(new SnsStrangerCommentDetailUI.2(this));
    this.rWo.cve();
    this.rWo.setOnCommentSendImp(new SnsStrangerCommentDetailUI.3(this));
    this.rWo.setCommentHint(getString(2131303938) + this.talker + getString(2131303772));
    setToTop(new SnsStrangerCommentDetailUI.1(this));
    setBackBtn(new SnsStrangerCommentDetailUI.4(this));
    addIconOptionMenu(0, 2130839668, new SnsStrangerCommentDetailUI.5(this));
    AppMethodBeat.o(39335);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(39342);
    ab.i("MicroMsg.SnsStrangerCommentDetailUI", "onAcvityResult requestCode:".concat(String.valueOf(paramInt1)));
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(39342);
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(39342);
      return;
      if (paramInt2 == -1)
      {
        paramIntent = managedQuery(paramIntent.getData(), null, null, null, null);
        if (paramIntent.moveToFirst()) {
          startActivity(new Intent("android.intent.action.EDIT", Uri.parse("content://com.android.contacts/contacts/".concat(String.valueOf(paramIntent.getString(paramIntent.getColumnIndexOrThrow("_id")))))));
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(39330);
    super.onCreate(paramBundle);
    setMMTitle(2131303791);
    this.cIo = getIntent().getLongExtra("INTENT_SNSID", 0L);
    this.talker = getIntent().getStringExtra("INTENT_TALKER");
    this.rMD = ag.cpf().lZ(this.cIo);
    this.cpt = getIntent().getIntExtra("INTENT_SOURCE", -1);
    com.tencent.mm.kernel.g.RM();
    this.rWu = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(this.talker);
    if ((this.rMD == null) || (this.talker == null))
    {
      finish();
      AppMethodBeat.o(39330);
      return;
    }
    this.rFq = new an(this);
    ag.cpk().add(this.rSM);
    initView();
    AppMethodBeat.o(39330);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(39333);
    ag.cpk().remove(this.rSM);
    ag.cpc().ah(this);
    if (this.rWr != null) {
      this.rWr.bKb();
    }
    super.onDestroy();
    AppMethodBeat.o(39333);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(39332);
    ag.cpa().b(this);
    super.onPause();
    AppMethodBeat.o(39332);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(39331);
    ag.cpa().a(this);
    super.onResume();
    AppMethodBeat.o(39331);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsStrangerCommentDetailUI
 * JD-Core Version:    0.7.0.1
 */