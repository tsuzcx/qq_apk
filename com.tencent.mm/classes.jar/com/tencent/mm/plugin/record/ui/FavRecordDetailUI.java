package com.tencent.mm.plugin.record.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R.g;
import com.tencent.mm.R.l;
import com.tencent.mm.h.a.gf;
import com.tencent.mm.h.a.gf.b;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.protocal.c.yp;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.s;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FavRecordDetailUI
  extends RecordMsgBaseUI
{
  private boolean bTT = true;
  private j.a kao = new FavRecordDetailUI.1(this);
  private com.tencent.mm.plugin.fav.a.g kdn;
  private long ntA = -1L;
  private boolean ntB = true;
  private boolean ntC = false;
  
  protected final void bvD()
  {
    this.ntA = getIntent().getLongExtra("key_detail_info_id", -1L);
    this.bTT = getIntent().getBooleanExtra("show_share", true);
    this.kdn = com.tencent.mm.plugin.record.b.b.fu(this.ntA);
    if (this.kdn == null)
    {
      finish();
      return;
    }
    E(this.kdn);
    Object localObject1 = new b();
    ((b)localObject1).khA = this.kdn;
    ((b)localObject1).ntu = this.kdn.field_favProto.sXc;
    Object localObject2 = ((b)localObject1).ntu;
    if (localObject2 == null) {
      this.ntB = false;
    }
    for (;;)
    {
      super.bvD();
      this.ntS.a((a)localObject1);
      localObject1 = ((b)localObject1).ntu;
      if (localObject1 != null) {
        e.post(new FavRecordDetailUI.4(this, (List)localObject1), "calc_fav_record_info");
      }
      ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().c(this.kao);
      ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnStorage().a(((d)this.ntS).ntw);
      return;
      if (((List)localObject2).size() == 0)
      {
        this.ntB = false;
      }
      else
      {
        localObject2 = ((List)localObject2).iterator();
        for (;;)
        {
          if (((Iterator)localObject2).hasNext()) {
            if (((xv)((Iterator)localObject2).next()).sVO != 0)
            {
              this.ntB = false;
              break;
            }
          }
        }
        this.ntB = true;
      }
    }
  }
  
  protected final h bvE()
  {
    return new d(this, new c(this));
  }
  
  protected final String bvF()
  {
    if ((14 == this.kdn.field_type) && (!bk.bl(this.kdn.field_favProto.title))) {
      return this.kdn.field_favProto.title;
    }
    yp localyp = this.kdn.field_favProto.sXa;
    if ((localyp != null) && (!bk.bl(localyp.sWB)))
    {
      String str2 = r.gV(localyp.sWB);
      String str3;
      String str1;
      if (com.tencent.mm.model.q.Gj().equals(localyp.bRO))
      {
        str3 = com.tencent.mm.plugin.record.b.h.gW(localyp.toUser);
        str1 = str2;
        if (!bk.aM(str3, "").equals(localyp.toUser)) {
          str1 = str2 + " - " + str3;
        }
      }
      for (;;)
      {
        y.v("MicroMsg.FavRecordDetailUI", "display name, source from[%s] to[%s]", new Object[] { localyp.bRO, localyp.toUser });
        return str1;
        str3 = com.tencent.mm.plugin.record.b.h.gW(localyp.bRO);
        str1 = str2;
        if (!bk.aM(str3, "").equals(localyp.bRO)) {
          str1 = str2 + " - " + str3;
        }
      }
    }
    y.v("MicroMsg.FavRecordDetailUI", "display name, from item info user[%s]", new Object[] { this.kdn.field_fromUser });
    return com.tencent.mm.plugin.record.b.h.gW(this.kdn.field_fromUser);
  }
  
  protected final String bvG()
  {
    LinkedList localLinkedList = this.kdn.field_favProto.sXc;
    if (localLinkedList.size() > 0) {
      return ((xv)localLinkedList.getFirst()).sVE;
    }
    return null;
  }
  
  protected final String bvH()
  {
    LinkedList localLinkedList = this.kdn.field_favProto.sXc;
    if (localLinkedList.size() > 0) {
      return ((xv)localLinkedList.getLast()).sVE;
    }
    return null;
  }
  
  protected final void bvI()
  {
    if (!this.bTT) {
      return;
    }
    addIconOptionMenu(0, R.l.top_item_desc_more, R.g.mm_title_btn_menu, new FavRecordDetailUI.2(this));
  }
  
  protected final void d(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject;
    if ((4097 == paramInt1) && (-1 == paramInt2))
    {
      localObject = new gf();
      ((gf)localObject).bNF.type = 32;
      ((gf)localObject).bNF.bIr = this.ntA;
      com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
      if (((gf)localObject).bNG.bNW) {
        com.tencent.mm.ui.base.h.bC(this.mController.uMN, getString(R.l.Fav_NotDownload_CannotForward));
      }
    }
    else
    {
      return;
    }
    if (paramIntent == null)
    {
      localObject = null;
      if (paramIntent != null) {
        break label221;
      }
    }
    label221:
    for (paramIntent = null;; paramIntent = paramIntent.getStringExtra("custom_send_text"))
    {
      p localp = com.tencent.mm.ui.base.h.b(this.mController.uMN, getString(R.l.favorite_forward_tips), false, null);
      gf localgf = new gf();
      localgf.bNF.type = 13;
      localgf.bNF.context = this.mController.uMN;
      localgf.bNF.toUser = ((String)localObject);
      localgf.bNF.bNL = paramIntent;
      localgf.bNF.bIr = this.ntA;
      localgf.bNF.bNK = new FavRecordDetailUI.3(this, localp);
      com.tencent.mm.sdk.b.a.udP.m(localgf);
      return;
      localObject = paramIntent.getStringExtra("Select_Conv_User");
      break;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  protected void onDestroy()
  {
    ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().d(this.kao);
    if (this.ntS != null) {
      ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnStorage().b(((d)this.ntS).ntw);
    }
    this.ntC = true;
    super.onDestroy();
  }
  
  protected void onResume()
  {
    super.onResume();
    Object localObject2 = (b)((d)this.ntS).ntO;
    com.tencent.mm.plugin.fav.a.g localg;
    if (((b)localObject2).khA != null)
    {
      localg = com.tencent.mm.plugin.record.b.b.fu(((b)localObject2).khA.field_localId);
      if ((localg != null) && (localg.field_favProto != null)) {
        break label51;
      }
    }
    for (;;)
    {
      return;
      label51:
      Object localObject1 = localg.field_favProto.sXc;
      localObject2 = ((b)localObject2).ntu.iterator();
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
      } while (((LinkedList)localObject1).contains((xv)((Iterator)localObject2).next()));
      for (int i = 1; i != 0; i = 0)
      {
        localObject1 = new b();
        ((b)localObject1).khA = localg;
        ((b)localObject1).ntu = localg.field_favProto.sXc;
        this.ntS.a((a)localObject1);
        return;
      }
    }
  }
  
  protected void onStop()
  {
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.FavRecordDetailUI
 * JD-Core Version:    0.7.0.1
 */