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
import com.tencent.mm.g.b.a.ck;
import com.tencent.mm.g.b.a.cs;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.a.e;
import com.tencent.mm.plugin.messenger.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.am.a;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.protocal.protobuf.yk;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bc;
import com.tencent.mm.storage.bg;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@com.tencent.mm.kernel.i
public class SnsGalleryUI
  extends SnsBaseGalleryUI
  implements u.a
{
  private int scene = 0;
  private String userName = "";
  private int xvT = 0;
  private String xyQ = "";
  
  protected final boolean dAL()
  {
    return true;
  }
  
  protected final int dAM()
  {
    return 4;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(98706);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      ad.d("MicroMsg.SnsGalleryUI", "dispatchKeyEvent");
      paramKeyEvent = new Intent();
      paramKeyEvent.putExtra("sns_cmd_list", this.xvJ.xne);
      setResult(-1, paramKeyEvent);
      finish();
      AppMethodBeat.o(98706);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(98706);
    return bool;
  }
  
  public final void eA(String paramString, int paramInt)
  {
    AppMethodBeat.i(98708);
    SnsInfoFlip localSnsInfoFlip;
    if (this.xvM != null) {
      if ((!bt.isNullOrNil(paramString)) && (paramInt != 3))
      {
        localSnsInfoFlip = this.xvM;
        if ((localSnsInfoFlip.xzp != null) && (localSnsInfoFlip.gQr != null)) {
          break label57;
        }
      }
    }
    for (;;)
    {
      this.xvM.qp(true);
      AppMethodBeat.o(98708);
      return;
      label57:
      paramInt = 0;
      while (paramInt >= 0)
      {
        if (localSnsInfoFlip.xzp != null) {
          for (;;)
          {
            if (paramInt >= localSnsInfoFlip.gQr.size()) {
              break label137;
            }
            com.tencent.mm.plugin.sns.j.b localb = localSnsInfoFlip.xzp.Nx(paramInt);
            if ((!bt.isNullOrNil(localb.wNP)) && (localb.wNP.equals(paramString)))
            {
              localSnsInfoFlip.gQr.remove(paramInt);
              break;
            }
            paramInt += 1;
          }
        }
        label137:
        paramInt = -1;
      }
      localSnsInfoFlip.xzp.notifyDataSetChanged();
    }
  }
  
  public final void eB(String paramString, int paramInt)
  {
    AppMethodBeat.i(98710);
    super.eB(paramString, paramInt);
    paramString = af.dtu().apK(paramString);
    TimeLineObject localTimeLineObject;
    ck localck;
    if (paramString != null)
    {
      com.tencent.mm.plugin.sns.k.f.wQY.F(paramString);
      com.tencent.mm.plugin.sns.k.f.wQY.b(paramString, paramInt);
      localTimeLineObject = paramString.dxy();
      if ((localTimeLineObject != null) && (localTimeLineObject.Etm != null) && (!bt.gL(localTimeLineObject.Etm.DaC)))
      {
        localck = com.tencent.mm.plugin.sns.k.f.wQY.duY();
        if (localck != null) {
          break label186;
        }
        localck = com.tencent.mm.plugin.sns.k.f.wQY.duZ();
        localck.dRm = 1L;
        localck = localck.je(com.tencent.mm.plugin.sns.data.q.su(paramString.field_snsId)).jd(com.tencent.mm.plugin.sns.k.f.wQY.wRk.dSp);
        localck.dMB = com.tencent.mm.plugin.sns.k.f.wQY.wRk.dMB;
        localck.dJX = localTimeLineObject.Etm.DaB;
        localck.dRl = localTimeLineObject.Etm.DaC.size();
        com.tencent.mm.plugin.sns.k.f.wQY.wRA = System.currentTimeMillis();
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.sns.k.f.wQY.e(paramString, paramInt);
      AppMethodBeat.o(98710);
      return;
      label186:
      if (!bt.kU(com.tencent.mm.plugin.sns.data.q.su(paramString.field_snsId), localck.dJL))
      {
        com.tencent.mm.plugin.sns.k.f.wQY.dvc();
        localck = com.tencent.mm.plugin.sns.k.f.wQY.duZ();
        localck.dRm = 0L;
        localck = localck.je(com.tencent.mm.plugin.sns.data.q.su(paramString.field_snsId)).jd(com.tencent.mm.plugin.sns.k.f.wQY.wRk.dSp);
        localck.dMB = com.tencent.mm.plugin.sns.k.f.wQY.wRk.dMB;
        localck.dJX = localTimeLineObject.Etm.DaB;
        localck.dRl = localTimeLineObject.Etm.DaC.size();
        com.tencent.mm.plugin.sns.k.f.wQY.wRA = System.currentTimeMillis();
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
    this.xvT = getIntent().getIntExtra("sns_gallery_position", 0);
    Object localObject = x.bi("sns_table_", i);
    ad.i("MicroMsg.SnsGalleryUI", "initView localId:%s, pos:%d", new Object[] { localObject, Integer.valueOf(this.xvT) });
    eB((String)localObject, this.xvT);
    O(bool, 1);
    this.xvM = new SnsInfoFlip(this);
    this.xvM.setVideoScene(this.scene);
    this.xvM.setNeedScanImage(true);
    localObject = af.dtk();
    String str = this.userName;
    if (((am.a)localObject).wIU.containsKey(str))
    {
      i = ((Integer)((am.a)localObject).wIU.get(str)).intValue();
      ((am.a)localObject).wIU.put(str, Integer.valueOf(i + 1));
      localObject = (ArrayList)((am.a)localObject).wIT.get(str);
      if (localObject != null) {
        break label467;
      }
      localObject = new ArrayList();
    }
    label467:
    for (;;)
    {
      this.xvM.setShowTitle(true);
      this.xvM.setEnableHorLongBmpMode(false);
      this.xvM.a((List)localObject, this.userName, this.xvT, this.xvH, this);
      this.xvM.setOnDeleteAllAction(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(98697);
          SnsGalleryUI.this.xvJ.dyZ();
          AppMethodBeat.o(98697);
        }
      });
      this.xvM.setOnPageSelectListener(this);
      g.afC();
      localObject = ((k)g.ab(k.class)).apM().aHY(this.userName);
      if ((localObject != null) && ((int)((com.tencent.mm.n.b)localObject).fId > 0) && (com.tencent.mm.n.b.ls(((au)localObject).field_type))) {
        localObject = bc.eLH();
      }
      for (;;)
      {
        this.xvM.setFromScene((bc)localObject);
        this.xvM.username = this.userName;
        addView(this.xvM);
        setBackBtn(new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(98698);
            SnsGalleryUI.this.xvJ.dyZ();
            AppMethodBeat.o(98698);
            return true;
          }
        });
        addIconOptionMenu(0, 2131690603, new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(98699);
            Object localObject = SnsGalleryUI.this.xvM.getSelectId();
            String str = SnsGalleryUI.this.xvM.getSelectedMediaId();
            paramAnonymousMenuItem = SnsGalleryUI.this.xvM.getSelectItem();
            ad.d("MicroMsg.SnsGalleryUI", "click selectLocalId ".concat(String.valueOf(localObject)));
            ad.d("MicroMsg.SnsGalleryUI", "click position ".concat(String.valueOf(str)));
            localObject = af.dtu().apK((String)localObject);
            for (;;)
            {
              try
              {
                i = SnsGalleryUI.this.xvM.getPosition();
                int j = ((p)localObject).dxy().Etm.DaC.size();
                if ((j <= 1) || (i <= 1) || (i > j)) {
                  continue;
                }
                i -= 1;
                SnsGalleryUI.this.xvJ.a(bool, (p)localObject, paramAnonymousMenuItem.dyS, SnsGalleryUI.this.xvM.xms, true, i);
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
        ((am.a)localObject).wIU.put(str, Integer.valueOf(0));
        break;
        localObject = com.tencent.mm.model.u.aqG();
        if (this.userName.equals(localObject)) {
          localObject = bc.eLI();
        } else {
          localObject = bc.eLJ();
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
      if (this.xvM == null) {
        break label534;
      }
      paramIntent = this.xvM.getSelectItem();
      if (paramIntent.dyS.mBH != 6)
      {
        AppMethodBeat.o(98709);
        return;
      }
    }
    label514:
    label534:
    for (Object localObject2 = paramIntent.dyS;; localObject2 = null)
    {
      if (localObject2 == null)
      {
        AppMethodBeat.o(98709);
        return;
      }
      String str3 = an.iF(af.getAccSnsPath(), ((bpi)localObject2).Id);
      paramIntent = "";
      Object localObject1 = "";
      String str4 = com.tencent.mm.plugin.sns.data.q.i((bpi)localObject2);
      if (com.tencent.mm.vfs.i.eK(str3 + str4))
      {
        localObject1 = str3 + str4;
        paramIntent = str3 + com.tencent.mm.plugin.sns.data.q.d((bpi)localObject2);
      }
      if (com.tencent.mm.vfs.i.eK(str3 + com.tencent.mm.plugin.sns.data.q.o((bpi)localObject2))) {
        paramIntent = str3 + com.tencent.mm.plugin.sns.data.q.o((bpi)localObject2);
      }
      for (localObject1 = str3 + com.tencent.mm.plugin.sns.data.q.m((bpi)localObject2);; localObject1 = localObject2)
      {
        localObject2 = bt.S(str2.split(","));
        paramInt1 = com.tencent.mm.plugin.sns.data.q.anS(paramIntent);
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          str2 = (String)((Iterator)localObject2).next();
          ad.i("MicroMsg.SnsGalleryUI", "send sight to %s, videopath %s, thumbpath %s duration %d", new Object[] { str2, paramIntent, localObject1, Integer.valueOf(paramInt1) });
          j.cOB().a(this, str2, paramIntent, (String)localObject1, 62, paramInt1, "", null);
          j.cOB().hm(str1, str2);
        }
        com.tencent.mm.ui.widget.snackbar.b.n(this, getString(2131760233));
        AppMethodBeat.o(98709);
        return;
        if (1 == paramInt1)
        {
          paramInt1 = paramIntent.getIntExtra("sns_gallery_op_id", 0);
          localObject1 = x.bi("sns_table_", paramIntent.getIntExtra("sns_gallery_op_id", 0));
          this.xvJ.Nh(paramInt1);
          eA((String)localObject1, 1);
          if (paramIntent.getBooleanExtra("sns_gallery_force_finish", false))
          {
            paramIntent = new Intent();
            paramIntent.putExtra("sns_cmd_list", this.xvJ.xne);
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
    com.tencent.mm.plugin.sns.k.f.wQY.wRt = System.currentTimeMillis();
    AppMethodBeat.o(98700);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98701);
    getWindow().clearFlags(128);
    Object localObject = af.dtk();
    String str = this.userName;
    int i;
    if (((am.a)localObject).wIU.containsKey(str))
    {
      i = Math.max(((Integer)((am.a)localObject).wIU.get(str)).intValue() - 1, 0);
      ((am.a)localObject).wIU.put(str, Integer.valueOf(i));
    }
    for (;;)
    {
      if (i <= 0) {
        ((am.a)localObject).wIT.remove(str);
      }
      af.dtr().az(this);
      super.onDestroy();
      localObject = com.tencent.mm.plugin.sns.k.f.wQY;
      if (((com.tencent.mm.plugin.sns.k.f)localObject).wRt != 0L)
      {
        ((com.tencent.mm.plugin.sns.k.f)localObject).wRu += System.currentTimeMillis() - ((com.tencent.mm.plugin.sns.k.f)localObject).wRt;
        ((com.tencent.mm.plugin.sns.k.f)localObject).wRt = 0L;
      }
      com.tencent.mm.plugin.sns.k.f.wQY.dva();
      com.tencent.mm.plugin.sns.k.f.wQY.dvc();
      AppMethodBeat.o(98701);
      return;
      i = 0;
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(98704);
    super.onPause();
    com.tencent.mm.plugin.ball.f.f.d(false, true, true);
    AppMethodBeat.o(98704);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(98705);
    super.onResume();
    SnsInfoFlip localSnsInfoFlip;
    if (this.xvM != null)
    {
      bpi localbpi = this.xvM.getCntMedia();
      localSnsInfoFlip = this.xvM;
      if ((localbpi == null) || (localbpi.mBH != 6)) {
        break label63;
      }
    }
    label63:
    for (boolean bool = true;; bool = false)
    {
      localSnsInfoFlip.qp(bool);
      com.tencent.mm.plugin.ball.f.f.d(true, true, true);
      AppMethodBeat.o(98705);
      return;
    }
  }
  
  public void onStart()
  {
    AppMethodBeat.i(98702);
    super.onStart();
    com.tencent.mm.plugin.sns.k.f.wQY.wRA = System.currentTimeMillis();
    AppMethodBeat.o(98702);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(98703);
    super.onStop();
    com.tencent.mm.plugin.sns.k.f.wQY.dva();
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