package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.contact.c;
import com.tencent.mm.g.b.a.ey;
import com.tencent.mm.g.b.a.fh;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.i;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.messenger.a.d;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.j.e;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.ao.a;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bq;
import com.tencent.mm.vfs.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@i
public class SnsGalleryUI
  extends SnsBaseGalleryUI
  implements v.a
{
  private int Arq = 0;
  private int scene = 0;
  private String userName = "";
  private String zKU = "";
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(98706);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      ae.d("MicroMsg.SnsGalleryUI", "dispatchKeyEvent");
      paramKeyEvent = new Intent();
      paramKeyEvent.putExtra("sns_cmd_list", this.Arg.Ait);
      setResult(-1, paramKeyEvent);
      finish();
      AppMethodBeat.o(98706);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(98706);
    return bool;
  }
  
  protected final boolean efg()
  {
    return true;
  }
  
  protected final int efh()
  {
    return 4;
  }
  
  public final void fj(String paramString, int paramInt)
  {
    AppMethodBeat.i(98708);
    SnsInfoFlip localSnsInfoFlip;
    if (this.Arj != null) {
      if ((!bu.isNullOrNil(paramString)) && (paramInt != 3))
      {
        localSnsInfoFlip = this.Arj;
        if ((localSnsInfoFlip.AuL != null) && (localSnsInfoFlip.hMc != null)) {
          break label57;
        }
      }
    }
    for (;;)
    {
      this.Arj.rY(true);
      AppMethodBeat.o(98708);
      return;
      label57:
      paramInt = 0;
      while (paramInt >= 0)
      {
        if (localSnsInfoFlip.AuL != null) {
          for (;;)
          {
            if (paramInt >= localSnsInfoFlip.hMc.size()) {
              break label137;
            }
            com.tencent.mm.plugin.sns.i.b localb = localSnsInfoFlip.AuL.RR(paramInt);
            if ((!bu.isNullOrNil(localb.parentId)) && (localb.parentId.equals(paramString)))
            {
              localSnsInfoFlip.hMc.remove(paramInt);
              break;
            }
            paramInt += 1;
          }
        }
        label137:
        paramInt = -1;
      }
      localSnsInfoFlip.AuL.notifyDataSetChanged();
    }
  }
  
  public final void fk(String paramString, int paramInt)
  {
    AppMethodBeat.i(98710);
    super.fk(paramString, paramInt);
    paramString = ah.dXE().aBr(paramString);
    TimeLineObject localTimeLineObject;
    ey localey;
    if (paramString != null)
    {
      e.zKO.I(paramString);
      e.zKO.c(paramString, paramInt);
      localTimeLineObject = paramString.ebP();
      if ((localTimeLineObject != null) && (localTimeLineObject.HUG != null) && (!bu.ht(localTimeLineObject.HUG.Gtx)))
      {
        localey = e.zKO.dZl();
        if (localey != null) {
          break label186;
        }
        localey = e.zKO.dZm();
        localey.ekU = 1L;
        localey = localey.oz(r.zW(paramString.field_snsId)).oy(e.zKO.zLc.emc);
        localey.edv = e.zKO.zLc.edv;
        localey.dWn = localTimeLineObject.HUG.Gtw;
        localey.ekT = localTimeLineObject.HUG.Gtx.size();
        e.zKO.zLs = System.currentTimeMillis();
      }
    }
    for (;;)
    {
      e.zKO.f(paramString, paramInt);
      AppMethodBeat.o(98710);
      return;
      label186:
      if (!bu.lX(r.zW(paramString.field_snsId), localey.dWh))
      {
        e.zKO.dZp();
        localey = e.zKO.dZm();
        localey.ekU = 0L;
        localey = localey.oz(r.zW(paramString.field_snsId)).oy(e.zKO.zLc.emc);
        localey.edv = e.zKO.zLc.edv;
        localey.dWn = localTimeLineObject.HUG.Gtw;
        localey.ekT = localTimeLineObject.HUG.Gtx.size();
        e.zKO.zLs = System.currentTimeMillis();
      }
    }
  }
  
  public int getLayoutId()
  {
    return 2131495548;
  }
  
  public void initView()
  {
    AppMethodBeat.i(98707);
    this.scene = getIntent().getIntExtra("sns_video_scene", 0);
    this.userName = getIntent().getStringExtra("sns_gallery_userName");
    int i = getIntent().getIntExtra("sns_gallery_localId", 0);
    final boolean bool = getIntent().getBooleanExtra("sns_gallery_is_self", false);
    this.Arq = getIntent().getIntExtra("sns_gallery_position", 0);
    Object localObject = x.bo("sns_table_", i);
    ae.i("MicroMsg.SnsGalleryUI", "initView localId:%s, pos:%d", new Object[] { localObject, Integer.valueOf(this.Arq) });
    fk((String)localObject, this.Arq);
    U(bool, 1);
    this.Arj = new SnsInfoFlip(this);
    this.Arj.setVideoScene(this.scene);
    this.Arj.setNeedScanImage(true);
    localObject = ah.dXu();
    String str = this.userName;
    if (((ao.a)localObject).zCA.containsKey(str))
    {
      i = ((Integer)((ao.a)localObject).zCA.get(str)).intValue();
      ((ao.a)localObject).zCA.put(str, Integer.valueOf(i + 1));
      localObject = (ArrayList)((ao.a)localObject).zCz.get(str);
      if (localObject != null) {
        break label467;
      }
      localObject = new ArrayList();
    }
    label467:
    for (;;)
    {
      this.Arj.setShowTitle(true);
      this.Arj.setEnableHorLongBmpMode(false);
      this.Arj.a((List)localObject, this.userName, this.Arq, this.Are, this);
      this.Arj.setOnDeleteAllAction(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(98697);
          SnsGalleryUI.this.Arg.edr();
          AppMethodBeat.o(98697);
        }
      });
      this.Arj.setOnPageSelectListener(this);
      com.tencent.mm.kernel.g.ajS();
      localObject = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(this.userName);
      if ((localObject != null) && ((int)((c)localObject).ght > 0) && (c.lO(((aw)localObject).field_type))) {
        localObject = bk.fvo();
      }
      for (;;)
      {
        this.Arj.setFromScene((bk)localObject);
        this.Arj.username = this.userName;
        addView(this.Arj);
        setBackBtn(new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(98698);
            SnsGalleryUI.this.Arg.edr();
            AppMethodBeat.o(98698);
            return true;
          }
        });
        addIconOptionMenu(0, 2131690603, new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(98699);
            Object localObject = SnsGalleryUI.this.Arj.getSelectId();
            String str = SnsGalleryUI.this.Arj.getSelectedMediaId();
            paramAnonymousMenuItem = SnsGalleryUI.this.Arj.getSelectItem();
            ae.d("MicroMsg.SnsGalleryUI", "click selectLocalId ".concat(String.valueOf(localObject)));
            ae.d("MicroMsg.SnsGalleryUI", "click position ".concat(String.valueOf(str)));
            localObject = ah.dXE().aBr((String)localObject);
            for (;;)
            {
              try
              {
                i = SnsGalleryUI.this.Arj.getPosition();
                int j = ((p)localObject).ebP().HUG.Gtx.size();
                if ((j <= 1) || (i <= 1) || (i > j)) {
                  continue;
                }
                i -= 1;
                SnsGalleryUI.this.Arg.a(bool, (p)localObject, paramAnonymousMenuItem.dKe, SnsGalleryUI.this.Arj.AhI, true, i);
              }
              catch (Exception paramAnonymousMenuItem)
              {
                int i;
                ae.printErrStackTrace("MicroMsg.SnsGalleryUI", paramAnonymousMenuItem, "", new Object[0]);
                continue;
              }
              AppMethodBeat.o(98699);
              return true;
              i = 0;
            }
          }
        });
        AppMethodBeat.o(98707);
        return;
        ((ao.a)localObject).zCA.put(str, Integer.valueOf(0));
        break;
        localObject = com.tencent.mm.model.v.aAC();
        if (this.userName.equals(localObject)) {
          localObject = bk.fvp();
        } else {
          localObject = bk.fvq();
        }
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(98709);
    ae.i("MicroMsg.SnsGalleryUI", "onAcvityResult requestCode:".concat(String.valueOf(paramInt1)));
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(98709);
      return;
    }
    String str2;
    String str1;
    if (2 == paramInt1)
    {
      if (-1 != paramInt2) {
        break label514;
      }
      str2 = paramIntent.getStringExtra("Select_Conv_User");
      str1 = paramIntent.getStringExtra("custom_send_text");
      if (this.Arj == null) {
        break label534;
      }
      paramIntent = this.Arj.getSelectItem();
      if (paramIntent.dKe.nJA != 6)
      {
        AppMethodBeat.o(98709);
        return;
      }
    }
    label514:
    label534:
    for (Object localObject2 = paramIntent.dKe;; localObject2 = null)
    {
      if (localObject2 == null)
      {
        AppMethodBeat.o(98709);
        return;
      }
      String str3 = ap.jv(ah.getAccSnsPath(), ((bzh)localObject2).Id);
      paramIntent = "";
      Object localObject1 = "";
      String str4 = r.i((bzh)localObject2);
      if (o.fB(str3 + str4))
      {
        localObject1 = str3 + str4;
        paramIntent = str3 + r.d((bzh)localObject2);
      }
      if (o.fB(str3 + r.o((bzh)localObject2))) {
        paramIntent = str3 + r.o((bzh)localObject2);
      }
      for (localObject1 = str3 + r.m((bzh)localObject2);; localObject1 = localObject2)
      {
        localObject2 = bu.U(str2.split(","));
        paramInt1 = r.azA(paramIntent);
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          str2 = (String)((Iterator)localObject2).next();
          ae.i("MicroMsg.SnsGalleryUI", "send sight to %s, videopath %s, thumbpath %s duration %d", new Object[] { str2, paramIntent, localObject1, Integer.valueOf(paramInt1) });
          com.tencent.mm.plugin.messenger.a.g.doC().a(this, str2, paramIntent, (String)localObject1, 62, paramInt1, "", null);
          com.tencent.mm.plugin.messenger.a.g.doC().hW(str1, str2);
        }
        com.tencent.mm.ui.widget.snackbar.b.n(this, getString(2131760233));
        AppMethodBeat.o(98709);
        return;
        if (1 == paramInt1)
        {
          paramInt1 = paramIntent.getIntExtra("sns_gallery_op_id", 0);
          localObject1 = x.bo("sns_table_", paramIntent.getIntExtra("sns_gallery_op_id", 0));
          this.Arg.Rz(paramInt1);
          fj((String)localObject1, 1);
          if (paramIntent.getBooleanExtra("sns_gallery_force_finish", false))
          {
            paramIntent = new Intent();
            paramIntent.putExtra("sns_cmd_list", this.Arg.Ait);
            setResult(-1, paramIntent);
            finish();
          }
        }
        AppMethodBeat.o(98709);
        return;
        localObject2 = paramIntent;
        paramIntent = (Intent)localObject1;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(98700);
    super.onCreate(paramBundle);
    getWindow().addFlags(128);
    setActionbarColor(getContext().getResources().getColor(2131100196));
    setNavigationbarColor(getContext().getResources().getColor(2131100196));
    initView();
    e.zKO.zLl = System.currentTimeMillis();
    AppMethodBeat.o(98700);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98701);
    getWindow().clearFlags(128);
    Object localObject = ah.dXu();
    String str = this.userName;
    int i;
    if (((ao.a)localObject).zCA.containsKey(str))
    {
      i = Math.max(((Integer)((ao.a)localObject).zCA.get(str)).intValue() - 1, 0);
      ((ao.a)localObject).zCA.put(str, Integer.valueOf(i));
    }
    for (;;)
    {
      if (i <= 0) {
        ((ao.a)localObject).zCz.remove(str);
      }
      ah.dXB().aE(this);
      super.onDestroy();
      localObject = e.zKO;
      if (((e)localObject).zLl != 0L)
      {
        ((e)localObject).zLm += System.currentTimeMillis() - ((e)localObject).zLl;
        ((e)localObject).zLl = 0L;
      }
      e.zKO.dZn();
      e.zKO.dZp();
      AppMethodBeat.o(98701);
      return;
      i = 0;
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(98704);
    super.onPause();
    f.e(false, true, true);
    AppMethodBeat.o(98704);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(98705);
    super.onResume();
    SnsInfoFlip localSnsInfoFlip;
    if (this.Arj != null)
    {
      bzh localbzh = this.Arj.getCntMedia();
      localSnsInfoFlip = this.Arj;
      if ((localbzh == null) || (localbzh.nJA != 6)) {
        break label63;
      }
    }
    label63:
    for (boolean bool = true;; bool = false)
    {
      localSnsInfoFlip.rY(bool);
      f.e(true, true, true);
      AppMethodBeat.o(98705);
      return;
    }
  }
  
  public void onStart()
  {
    AppMethodBeat.i(98702);
    super.onStart();
    e.zKO.zLs = System.currentTimeMillis();
    AppMethodBeat.o(98702);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(98703);
    super.onStop();
    e.zKO.dZn();
    AppMethodBeat.o(98703);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsGalleryUI
 * JD-Core Version:    0.7.0.1
 */