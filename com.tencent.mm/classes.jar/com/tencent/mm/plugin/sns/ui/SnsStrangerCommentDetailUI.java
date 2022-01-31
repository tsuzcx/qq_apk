package com.tencent.mm.plugin.sns.ui;

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
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.b.b;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.y;
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
  private static int pdI = 4;
  private long eAA;
  private ImageView ffK;
  private TextView iuy;
  private View lZC;
  private an oNH;
  private com.tencent.mm.plugin.sns.storage.n oUH;
  private int oWf = -1;
  private j.a pao = new SnsStrangerCommentDetailUI.7(this);
  private ListView pdA;
  private SnsCommentFooter pdB;
  private LinearLayout pdC;
  private List<View> pdD;
  private SnsStrangerCommentDetailUI.a pdE;
  private boolean pdF = false;
  private boolean pdG = false;
  private ad pdH;
  private int source;
  private String talker;
  
  private void bJn()
  {
    this.pdC.removeAllViews();
    int k = BackwardSupportUtil.b.b(this, pdI);
    LinkedList localLinkedList = this.oUH.bGe().tNr.sPJ;
    this.pdD = new ArrayList();
    int j = 0;
    if (j < localLinkedList.size())
    {
      MMImageView localMMImageView = new MMImageView(this);
      localMMImageView.setPadding(k, k, k, k);
      this.pdC.addView(localMMImageView, new ViewGroup.LayoutParams(-2, -2));
      Bitmap localBitmap = af.bDC().a((awd)localLinkedList.get(j), localMMImageView, hashCode(), az.uBK).Fd();
      int i;
      if (localBitmap == null) {
        switch (this.oUH.field_type)
        {
        default: 
          i = i.i.app_attach_file_icon_webpage;
          label188:
          if (i != 0) {
            localMMImageView.setImageResource(i);
          }
          break;
        }
      }
      for (;;)
      {
        this.pdD.add(localMMImageView);
        j += 1;
        break;
        i = i.i.app_attach_file_icon_music;
        break label188;
        i = i.i.app_attach_file_icon_video;
        break label188;
        i = i.i.app_attach_file_icon_webpage;
        break label188;
        i = i.i.app_attach_file_icon_location;
        break label188;
        i = i.e.app_attach_file_icon_pic;
        break label188;
        i = i.e.app_attach_file_icon_pic;
        break label188;
        localMMImageView.setImageDrawable(null);
        i = 0;
        break label188;
        localMMImageView.setImageDrawable(null);
        i = 0;
        break label188;
        localMMImageView.setImageBitmap(localBitmap);
      }
    }
  }
  
  public final void Ni(String paramString)
  {
    bJn();
  }
  
  public final void bCt() {}
  
  public final void ba(String paramString, boolean paramBoolean) {}
  
  public final void bb(String paramString, boolean paramBoolean) {}
  
  protected final int getLayoutId()
  {
    return i.g.sns_comment_detail;
  }
  
  protected final void initView()
  {
    this.pdA = ((ListView)findViewById(i.f.album_comment_list));
    this.pdB = ((SnsCommentFooter)findViewById(i.f.comment_footer));
    this.lZC = View.inflate(this, i.g.sns_stranger_comment_detail_header, null);
    this.pdC = ((LinearLayout)this.lZC.findViewById(i.f.album_list));
    this.ffK = ((ImageView)this.lZC.findViewById(i.f.album_avatar_iv));
    this.iuy = ((TextView)this.lZC.findViewById(i.f.album_nick_name));
    a.b.p(this.ffK, this.oUH.field_userName);
    Object localObject = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.a.b.class)).gV(this.oUH.field_userName);
    this.iuy.setText(com.tencent.mm.pluginsdk.ui.d.j.a(this, (CharSequence)localObject, this.iuy.getTextSize()));
    bJn();
    int i = 0;
    while (i < this.pdD.size())
    {
      localObject = new ao();
      ((ao)localObject).bMB = this.oUH.bGE();
      ((ao)localObject).index = i;
      ((ao)localObject).oYz = this.pdD;
      ((View)this.pdD.get(i)).setTag(localObject);
      ((View)this.pdD.get(i)).setOnClickListener(new SnsStrangerCommentDetailUI.9(this));
      i += 1;
    }
    this.pdA.addHeaderView(this.lZC);
    this.pdE = new SnsStrangerCommentDetailUI.a(this, this);
    this.pdA.post(new SnsStrangerCommentDetailUI.10(this));
    this.pdA.setAdapter(this.pdE);
    this.pdA.setOnScrollListener(new SnsStrangerCommentDetailUI.11(this));
    this.pdB.setAfterEditAction(new SnsStrangerCommentDetailUI.2(this));
    this.pdB.bIK();
    this.pdB.setHeartBtnVisibility(8);
    this.pdB.setOnCommentSendImp(new SnsStrangerCommentDetailUI.3(this));
    this.pdB.setCommentHint(getString(i.j.sns_reply) + this.talker + getString(i.j.sns_after_reply));
    new SnsStrangerCommentDetailUI.1(this);
    setBackBtn(new SnsStrangerCommentDetailUI.4(this));
    addIconOptionMenu(0, i.e.mm_title_btn_menu, new SnsStrangerCommentDetailUI.5(this));
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    y.i("MicroMsg.SnsStrangerCommentDetailUI", "onAcvityResult requestCode:" + paramInt1);
    if (paramInt2 != -1) {}
    do
    {
      do
      {
        return;
        switch (paramInt1)
        {
        default: 
          return;
        }
      } while (paramInt2 != -1);
      paramIntent = managedQuery(paramIntent.getData(), null, null, null, null);
    } while (!paramIntent.moveToFirst());
    paramIntent = paramIntent.getString(paramIntent.getColumnIndexOrThrow("_id"));
    startActivity(new Intent("android.intent.action.EDIT", Uri.parse("content://com.android.contacts/contacts/" + paramIntent)));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setMMTitle(i.j.sns_comment_detial_ui_title);
    this.eAA = getIntent().getLongExtra("INTENT_SNSID", 0L);
    this.talker = getIntent().getStringExtra("INTENT_TALKER");
    this.oUH = af.bDF().gt(this.eAA);
    this.source = getIntent().getIntExtra("INTENT_SOURCE", -1);
    com.tencent.mm.kernel.g.DQ();
    this.pdH = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(this.talker);
    if ((this.oUH == null) || (this.talker == null))
    {
      finish();
      return;
    }
    this.oNH = new an(this);
    af.bDK().c(this.pao);
    initView();
  }
  
  protected void onDestroy()
  {
    af.bDK().d(this.pao);
    af.bDC().M(this);
    if (this.pdE != null) {
      this.pdE.bcS();
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    af.bDA().b(this);
    super.onPause();
  }
  
  public void onResume()
  {
    af.bDA().a(this);
    super.onResume();
  }
  
  final class a$a
  {
    ImageView doU;
    TextView fuN;
    TextView igx;
    TextView mYa;
    TextView nMe;
    ImageView pdM;
    
    a$a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsStrangerCommentDetailUI
 * JD-Core Version:    0.7.0.1
 */