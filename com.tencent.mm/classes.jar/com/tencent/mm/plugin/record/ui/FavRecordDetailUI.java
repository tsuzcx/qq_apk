package com.tencent.mm.plugin.record.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gi;
import com.tencent.mm.g.a.gi.b;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.q;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.record.b.n;
import com.tencent.mm.plugin.record.b.v;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.acw;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.p;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FavRecordDetailUI
  extends RecordMsgBaseUI
{
  private boolean cBz;
  private k.a muK;
  private com.tencent.mm.plugin.fav.a.g mxX;
  private long pZh;
  private boolean pZi;
  private boolean pZj;
  private i pZk;
  
  public FavRecordDetailUI()
  {
    AppMethodBeat.i(24210);
    this.pZh = -1L;
    this.cBz = true;
    this.pZi = true;
    this.pZj = false;
    this.muK = new FavRecordDetailUI.1(this);
    AppMethodBeat.o(24210);
  }
  
  protected final void cfU()
  {
    AppMethodBeat.i(24212);
    this.pZh = getIntent().getLongExtra("key_detail_info_id", -1L);
    this.cBz = getIntent().getBooleanExtra("show_share", true);
    this.mxX = com.tencent.mm.plugin.record.b.g.kY(this.pZh);
    if (this.mxX == null)
    {
      finish();
      AppMethodBeat.o(24212);
      return;
    }
    F(this.mxX);
    Object localObject1 = new b();
    ((b)localObject1).mCk = this.mxX;
    ((b)localObject1).pZa = this.mxX.field_favProto.wVc;
    ((b)localObject1).pZb = new v();
    Object localObject2 = ((b)localObject1).pZa;
    if (localObject2 == null) {
      this.pZi = false;
    }
    for (;;)
    {
      super.cfU();
      this.pZz.a((a)localObject1);
      this.pZk = new i(this, this.pZz, (a)localObject1);
      localObject1 = ((b)localObject1).pZa;
      if (localObject1 != null) {
        com.tencent.mm.sdk.g.d.post(new FavRecordDetailUI.4(this, (List)localObject1), "calc_fav_record_info");
      }
      this.pZz.pZk = this.pZk;
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().add(this.muK);
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnStorage().a(((d)this.pZz).pZd);
      AppMethodBeat.o(24212);
      return;
      if (((List)localObject2).size() == 0)
      {
        this.pZi = false;
      }
      else
      {
        localObject2 = ((List)localObject2).iterator();
        for (;;)
        {
          if (((Iterator)localObject2).hasNext()) {
            if (((aca)((Iterator)localObject2).next()).wTK != 0)
            {
              this.pZi = false;
              break;
            }
          }
        }
        this.pZi = true;
      }
    }
  }
  
  protected final h cfV()
  {
    AppMethodBeat.i(24213);
    d locald = new d(this, new c(this));
    AppMethodBeat.o(24213);
    return locald;
  }
  
  protected final String cfW()
  {
    AppMethodBeat.i(24217);
    Object localObject;
    if ((14 == this.mxX.field_type) && (!bo.isNullOrNil(this.mxX.field_favProto.title))) {
      localObject = this.mxX.field_favProto.title;
    }
    for (;;)
    {
      AppMethodBeat.o(24217);
      return localObject;
      acw localacw = this.mxX.field_favProto.wVa;
      if ((localacw != null) && (!bo.isNullOrNil(localacw.wUA)))
      {
        String str1 = s.nE(localacw.wUA);
        String str2;
        if (r.Zn().equals(localacw.czp))
        {
          str2 = n.nF(localacw.toUser);
          localObject = str1;
          if (!bo.bf(str2, "").equals(localacw.toUser)) {
            localObject = str1 + " - " + str2;
          }
        }
        for (;;)
        {
          ab.v("MicroMsg.FavRecordDetailUI", "display name, source from[%s] to[%s]", new Object[] { localacw.czp, localacw.toUser });
          break;
          str2 = n.nF(localacw.czp);
          localObject = str1;
          if (!bo.bf(str2, "").equals(localacw.czp)) {
            localObject = str1 + " - " + str2;
          }
        }
      }
      ab.v("MicroMsg.FavRecordDetailUI", "display name, from item info user[%s]", new Object[] { this.mxX.field_fromUser });
      localObject = n.nF(this.mxX.field_fromUser);
    }
  }
  
  protected final String cfX()
  {
    AppMethodBeat.i(24218);
    Object localObject = this.mxX.field_favProto.wVc;
    if (((LinkedList)localObject).size() > 0)
    {
      localObject = ((aca)((LinkedList)localObject).getFirst()).wTA;
      AppMethodBeat.o(24218);
      return localObject;
    }
    AppMethodBeat.o(24218);
    return null;
  }
  
  protected final String cfY()
  {
    AppMethodBeat.i(24219);
    Object localObject = this.mxX.field_favProto.wVc;
    if (((LinkedList)localObject).size() > 0)
    {
      localObject = ((aca)((LinkedList)localObject).getLast()).wTA;
      AppMethodBeat.o(24219);
      return localObject;
    }
    AppMethodBeat.o(24219);
    return null;
  }
  
  protected final void cfZ()
  {
    AppMethodBeat.i(24220);
    if (!this.cBz)
    {
      AppMethodBeat.o(24220);
      return;
    }
    addIconOptionMenu(0, 2131304317, 2130839668, new FavRecordDetailUI.2(this));
    AppMethodBeat.o(24220);
  }
  
  protected final void d(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(24221);
    if ((4097 == paramInt1) && (-1 == paramInt2))
    {
      Object localObject = new gi();
      ((gi)localObject).cuX.type = 32;
      ((gi)localObject).cuX.cpM = this.pZh;
      com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
      if (((gi)localObject).cuY.cvo)
      {
        com.tencent.mm.ui.base.h.bO(getContext(), getString(2131296330));
        AppMethodBeat.o(24221);
        return;
      }
      if (paramIntent == null)
      {
        localObject = null;
        if (paramIntent != null) {
          break label230;
        }
      }
      label230:
      for (paramIntent = null;; paramIntent = paramIntent.getStringExtra("custom_send_text"))
      {
        p localp = com.tencent.mm.ui.base.h.b(getContext(), getString(2131299734), false, null);
        gi localgi = new gi();
        localgi.cuX.type = 13;
        localgi.cuX.context = getContext();
        localgi.cuX.toUser = ((String)localObject);
        localgi.cuX.cvd = paramIntent;
        localgi.cuX.cpM = this.pZh;
        localgi.cuX.cvc = new FavRecordDetailUI.3(this, localp);
        com.tencent.mm.sdk.b.a.ymk.l(localgi);
        AppMethodBeat.o(24221);
        return;
        localObject = paramIntent.getStringExtra("Select_Conv_User");
        break;
      }
    }
    AppMethodBeat.o(24221);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(24211);
    super.onCreate(paramBundle);
    AppMethodBeat.o(24211);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(24216);
    ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().remove(this.muK);
    if (this.pZz != null) {
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnStorage().b(((d)this.pZz).pZd);
    }
    this.pZj = true;
    this.pZk.cgg();
    super.onDestroy();
    AppMethodBeat.o(24216);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(24214);
    super.onResume();
    Object localObject2 = (b)((d)this.pZz).pZv;
    com.tencent.mm.plugin.fav.a.g localg;
    Object localObject1;
    if (((b)localObject2).mCk != null)
    {
      localg = com.tencent.mm.plugin.record.b.g.kY(((b)localObject2).mCk.field_localId);
      if ((localg == null) || (localg.field_favProto == null))
      {
        AppMethodBeat.o(24214);
        return;
      }
      localObject1 = localg.field_favProto.wVc;
      localObject2 = ((b)localObject2).pZa.iterator();
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
      } while (((LinkedList)localObject1).contains((aca)((Iterator)localObject2).next()));
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject1 = new b();
        ((b)localObject1).mCk = localg;
        ((b)localObject1).pZa = localg.field_favProto.wVc;
        this.pZz.a((a)localObject1);
      }
      AppMethodBeat.o(24214);
      return;
    }
  }
  
  public void onStop()
  {
    AppMethodBeat.i(24215);
    super.onStop();
    AppMethodBeat.o(24215);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.FavRecordDetailUI
 * JD-Core Version:    0.7.0.1
 */