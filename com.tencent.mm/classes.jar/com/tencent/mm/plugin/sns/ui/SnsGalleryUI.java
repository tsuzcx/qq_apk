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
import com.tencent.mm.g.b.a.ew;
import com.tencent.mm.g.b.a.ff;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.a.d;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.sns.j.e;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.an.a;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@com.tencent.mm.kernel.i
public class SnsGalleryUI
  extends SnsBaseGalleryUI
  implements v.a
{
  private int Aad = 0;
  private String Adb = "";
  private int scene = 0;
  private String userName = "";
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(98706);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      ad.d("MicroMsg.SnsGalleryUI", "dispatchKeyEvent");
      paramKeyEvent = new Intent();
      paramKeyEvent.putExtra("sns_cmd_list", this.zZT.zRm);
      setResult(-1, paramKeyEvent);
      finish();
      AppMethodBeat.o(98706);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(98706);
    return bool;
  }
  
  protected final int ebA()
  {
    return 4;
  }
  
  protected final boolean ebz()
  {
    return true;
  }
  
  public final void fa(String paramString, int paramInt)
  {
    AppMethodBeat.i(98708);
    SnsInfoFlip localSnsInfoFlip;
    if (this.zZW != null) {
      if ((!bt.isNullOrNil(paramString)) && (paramInt != 3))
      {
        localSnsInfoFlip = this.zZW;
        if ((localSnsInfoFlip.Adz != null) && (localSnsInfoFlip.hJj != null)) {
          break label57;
        }
      }
    }
    for (;;)
    {
      this.zZW.rR(true);
      AppMethodBeat.o(98708);
      return;
      label57:
      paramInt = 0;
      while (paramInt >= 0)
      {
        if (localSnsInfoFlip.Adz != null) {
          for (;;)
          {
            if (paramInt >= localSnsInfoFlip.hJj.size()) {
              break label137;
            }
            com.tencent.mm.plugin.sns.i.b localb = localSnsInfoFlip.Adz.Rk(paramInt);
            if ((!bt.isNullOrNil(localb.parentId)) && (localb.parentId.equals(paramString)))
            {
              localSnsInfoFlip.hJj.remove(paramInt);
              break;
            }
            paramInt += 1;
          }
        }
        label137:
        paramInt = -1;
      }
      localSnsInfoFlip.Adz.notifyDataSetChanged();
    }
  }
  
  public final void fb(String paramString, int paramInt)
  {
    AppMethodBeat.i(98710);
    super.fb(paramString, paramInt);
    paramString = ag.dUe().aAa(paramString);
    TimeLineObject localTimeLineObject;
    ew localew;
    if (paramString != null)
    {
      e.ztz.I(paramString);
      e.ztz.c(paramString, paramInt);
      localTimeLineObject = paramString.dYl();
      if ((localTimeLineObject != null) && (localTimeLineObject.HAT != null) && (!bt.hj(localTimeLineObject.HAT.GaQ)))
      {
        localew = e.ztz.dVK();
        if (localew != null) {
          break label186;
        }
        localew = e.ztz.dVL();
        localew.ejn = 1L;
        localew = localew.oe(com.tencent.mm.plugin.sns.data.q.zx(paramString.field_snsId)).od(e.ztz.ztL.ekv);
        localew.eca = e.ztz.ztL.eca;
        localew.dUX = localTimeLineObject.HAT.GaP;
        localew.ejm = localTimeLineObject.HAT.GaQ.size();
        e.ztz.zub = System.currentTimeMillis();
      }
    }
    for (;;)
    {
      e.ztz.f(paramString, paramInt);
      AppMethodBeat.o(98710);
      return;
      label186:
      if (!bt.lQ(com.tencent.mm.plugin.sns.data.q.zx(paramString.field_snsId), localew.dUR))
      {
        e.ztz.dVO();
        localew = e.ztz.dVL();
        localew.ejn = 0L;
        localew = localew.oe(com.tencent.mm.plugin.sns.data.q.zx(paramString.field_snsId)).od(e.ztz.ztL.ekv);
        localew.eca = e.ztz.ztL.eca;
        localew.dUX = localTimeLineObject.HAT.GaP;
        localew.ejm = localTimeLineObject.HAT.GaQ.size();
        e.ztz.zub = System.currentTimeMillis();
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
    this.Aad = getIntent().getIntExtra("sns_gallery_position", 0);
    Object localObject = x.bn("sns_table_", i);
    ad.i("MicroMsg.SnsGalleryUI", "initView localId:%s, pos:%d", new Object[] { localObject, Integer.valueOf(this.Aad) });
    fb((String)localObject, this.Aad);
    R(bool, 1);
    this.zZW = new SnsInfoFlip(this);
    this.zZW.setVideoScene(this.scene);
    this.zZW.setNeedScanImage(true);
    localObject = ag.dTU();
    String str = this.userName;
    if (((an.a)localObject).zll.containsKey(str))
    {
      i = ((Integer)((an.a)localObject).zll.get(str)).intValue();
      ((an.a)localObject).zll.put(str, Integer.valueOf(i + 1));
      localObject = (ArrayList)((an.a)localObject).zlk.get(str);
      if (localObject != null) {
        break label467;
      }
      localObject = new ArrayList();
    }
    label467:
    for (;;)
    {
      this.zZW.setShowTitle(true);
      this.zZW.setEnableHorLongBmpMode(false);
      this.zZW.a((List)localObject, this.userName, this.Aad, this.zZR, this);
      this.zZW.setOnDeleteAllAction(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(98697);
          SnsGalleryUI.this.zZT.dZL();
          AppMethodBeat.o(98697);
        }
      });
      this.zZW.setOnPageSelectListener(this);
      com.tencent.mm.kernel.g.ajD();
      localObject = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(this.userName);
      if ((localObject != null) && ((int)((com.tencent.mm.o.b)localObject).gfj > 0) && (com.tencent.mm.o.b.lM(((aw)localObject).field_type))) {
        localObject = bj.fro();
      }
      for (;;)
      {
        this.zZW.setFromScene((bj)localObject);
        this.zZW.username = this.userName;
        addView(this.zZW);
        setBackBtn(new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(98698);
            SnsGalleryUI.this.zZT.dZL();
            AppMethodBeat.o(98698);
            return true;
          }
        });
        addIconOptionMenu(0, 2131690603, new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(98699);
            Object localObject = SnsGalleryUI.this.zZW.getSelectId();
            String str = SnsGalleryUI.this.zZW.getSelectedMediaId();
            paramAnonymousMenuItem = SnsGalleryUI.this.zZW.getSelectItem();
            ad.d("MicroMsg.SnsGalleryUI", "click selectLocalId ".concat(String.valueOf(localObject)));
            ad.d("MicroMsg.SnsGalleryUI", "click position ".concat(String.valueOf(str)));
            localObject = ag.dUe().aAa((String)localObject);
            for (;;)
            {
              try
              {
                i = SnsGalleryUI.this.zZW.getPosition();
                int j = ((p)localObject).dYl().HAT.GaQ.size();
                if ((j <= 1) || (i <= 1) || (i > j)) {
                  continue;
                }
                i -= 1;
                SnsGalleryUI.this.zZT.a(bool, (p)localObject, paramAnonymousMenuItem.dIQ, SnsGalleryUI.this.zZW.zQB, true, i);
              }
              catch (Exception paramAnonymousMenuItem)
              {
                int i;
                ad.printErrStackTrace("MicroMsg.SnsGalleryUI", paramAnonymousMenuItem, "", new Object[0]);
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
        ((an.a)localObject).zll.put(str, Integer.valueOf(0));
        break;
        localObject = u.aAm();
        if (this.userName.equals(localObject)) {
          localObject = bj.frp();
        } else {
          localObject = bj.frq();
        }
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(98709);
    ad.i("MicroMsg.SnsGalleryUI", "onAcvityResult requestCode:".concat(String.valueOf(paramInt1)));
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
      if (this.zZW == null) {
        break label534;
      }
      paramIntent = this.zZW.getSelectItem();
      if (paramIntent.dIQ.nEf != 6)
      {
        AppMethodBeat.o(98709);
        return;
      }
    }
    label514:
    label534:
    for (Object localObject2 = paramIntent.dIQ;; localObject2 = null)
    {
      if (localObject2 == null)
      {
        AppMethodBeat.o(98709);
        return;
      }
      String str3 = ao.jo(ag.getAccSnsPath(), ((byn)localObject2).Id);
      paramIntent = "";
      Object localObject1 = "";
      String str4 = com.tencent.mm.plugin.sns.data.q.i((byn)localObject2);
      if (com.tencent.mm.vfs.i.fv(str3 + str4))
      {
        localObject1 = str3 + str4;
        paramIntent = str3 + com.tencent.mm.plugin.sns.data.q.d((byn)localObject2);
      }
      if (com.tencent.mm.vfs.i.fv(str3 + com.tencent.mm.plugin.sns.data.q.o((byn)localObject2))) {
        paramIntent = str3 + com.tencent.mm.plugin.sns.data.q.o((byn)localObject2);
      }
      for (localObject1 = str3 + com.tencent.mm.plugin.sns.data.q.m((byn)localObject2);; localObject1 = localObject2)
      {
        localObject2 = bt.U(str2.split(","));
        paramInt1 = com.tencent.mm.plugin.sns.data.q.ayj(paramIntent);
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          str2 = (String)((Iterator)localObject2).next();
          ad.i("MicroMsg.SnsGalleryUI", "send sight to %s, videopath %s, thumbpath %s duration %d", new Object[] { str2, paramIntent, localObject1, Integer.valueOf(paramInt1) });
          com.tencent.mm.plugin.messenger.a.g.dlD().a(this, str2, paramIntent, (String)localObject1, 62, paramInt1, "", null);
          com.tencent.mm.plugin.messenger.a.g.dlD().hP(str1, str2);
        }
        com.tencent.mm.ui.widget.snackbar.b.n(this, getString(2131760233));
        AppMethodBeat.o(98709);
        return;
        if (1 == paramInt1)
        {
          paramInt1 = paramIntent.getIntExtra("sns_gallery_op_id", 0);
          localObject1 = x.bn("sns_table_", paramIntent.getIntExtra("sns_gallery_op_id", 0));
          this.zZT.QS(paramInt1);
          fa((String)localObject1, 1);
          if (paramIntent.getBooleanExtra("sns_gallery_force_finish", false))
          {
            paramIntent = new Intent();
            paramIntent.putExtra("sns_cmd_list", this.zZT.zRm);
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
    e.ztz.ztU = System.currentTimeMillis();
    AppMethodBeat.o(98700);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98701);
    getWindow().clearFlags(128);
    Object localObject = ag.dTU();
    String str = this.userName;
    int i;
    if (((an.a)localObject).zll.containsKey(str))
    {
      i = Math.max(((Integer)((an.a)localObject).zll.get(str)).intValue() - 1, 0);
      ((an.a)localObject).zll.put(str, Integer.valueOf(i));
    }
    for (;;)
    {
      if (i <= 0) {
        ((an.a)localObject).zlk.remove(str);
      }
      ag.dUb().aD(this);
      super.onDestroy();
      localObject = e.ztz;
      if (((e)localObject).ztU != 0L)
      {
        ((e)localObject).ztV += System.currentTimeMillis() - ((e)localObject).ztU;
        ((e)localObject).ztU = 0L;
      }
      e.ztz.dVM();
      e.ztz.dVO();
      AppMethodBeat.o(98701);
      return;
      i = 0;
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(98704);
    super.onPause();
    com.tencent.mm.plugin.ball.f.f.e(false, true, true);
    AppMethodBeat.o(98704);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(98705);
    super.onResume();
    SnsInfoFlip localSnsInfoFlip;
    if (this.zZW != null)
    {
      byn localbyn = this.zZW.getCntMedia();
      localSnsInfoFlip = this.zZW;
      if ((localbyn == null) || (localbyn.nEf != 6)) {
        break label63;
      }
    }
    label63:
    for (boolean bool = true;; bool = false)
    {
      localSnsInfoFlip.rR(bool);
      com.tencent.mm.plugin.ball.f.f.e(true, true, true);
      AppMethodBeat.o(98705);
      return;
    }
  }
  
  public void onStart()
  {
    AppMethodBeat.i(98702);
    super.onStart();
    e.ztz.zub = System.currentTimeMillis();
    AppMethodBeat.o(98702);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(98703);
    super.onStop();
    e.ztz.dVM();
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