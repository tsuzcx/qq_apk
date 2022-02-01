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
import com.tencent.mm.g.b.a.dy;
import com.tencent.mm.g.b.a.eg;
import com.tencent.mm.g.c.av;
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
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.bj;
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
  private int yIJ = 0;
  private String yLE = "";
  
  protected final boolean dPi()
  {
    return true;
  }
  
  protected final int dPj()
  {
    return 4;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(98706);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      ac.d("MicroMsg.SnsGalleryUI", "dispatchKeyEvent");
      paramKeyEvent = new Intent();
      paramKeyEvent.putExtra("sns_cmd_list", this.yIz.yzV);
      setResult(-1, paramKeyEvent);
      finish();
      AppMethodBeat.o(98706);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(98706);
    return bool;
  }
  
  public final void eI(String paramString, int paramInt)
  {
    AppMethodBeat.i(98708);
    SnsInfoFlip localSnsInfoFlip;
    if (this.yIC != null) {
      if ((!bs.isNullOrNil(paramString)) && (paramInt != 3))
      {
        localSnsInfoFlip = this.yIC;
        if ((localSnsInfoFlip.yMd != null) && (localSnsInfoFlip.hqR != null)) {
          break label57;
        }
      }
    }
    for (;;)
    {
      this.yIC.rn(true);
      AppMethodBeat.o(98708);
      return;
      label57:
      paramInt = 0;
      while (paramInt >= 0)
      {
        if (localSnsInfoFlip.yMd != null) {
          for (;;)
          {
            if (paramInt >= localSnsInfoFlip.hqR.size()) {
              break label137;
            }
            com.tencent.mm.plugin.sns.i.b localb = localSnsInfoFlip.yMd.PB(paramInt);
            if ((!bs.isNullOrNil(localb.yav)) && (localb.yav.equals(paramString)))
            {
              localSnsInfoFlip.hqR.remove(paramInt);
              break;
            }
            paramInt += 1;
          }
        }
        label137:
        paramInt = -1;
      }
      localSnsInfoFlip.yMd.notifyDataSetChanged();
    }
  }
  
  public final void eJ(String paramString, int paramInt)
  {
    AppMethodBeat.i(98710);
    super.eJ(paramString, paramInt);
    paramString = af.dHR().auT(paramString);
    TimeLineObject localTimeLineObject;
    dy localdy;
    if (paramString != null)
    {
      com.tencent.mm.plugin.sns.j.f.ydE.G(paramString);
      com.tencent.mm.plugin.sns.j.f.ydE.b(paramString, paramInt);
      localTimeLineObject = paramString.dLV();
      if ((localTimeLineObject != null) && (localTimeLineObject.FQo != null) && (!bs.gY(localTimeLineObject.FQo.Etz)))
      {
        localdy = com.tencent.mm.plugin.sns.j.f.ydE.dJx();
        if (localdy != null) {
          break label186;
        }
        localdy = com.tencent.mm.plugin.sns.j.f.ydE.dJy();
        localdy.dTa = 1L;
        localdy = localdy.lU(com.tencent.mm.plugin.sns.data.q.wX(paramString.field_snsId)).lT(com.tencent.mm.plugin.sns.j.f.ydE.ydQ.dUd);
        localdy.dNc = com.tencent.mm.plugin.sns.j.f.ydE.ydQ.dNc;
        localdy.dHS = localTimeLineObject.FQo.Ety;
        localdy.dSZ = localTimeLineObject.FQo.Etz.size();
        com.tencent.mm.plugin.sns.j.f.ydE.yeg = System.currentTimeMillis();
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.sns.j.f.ydE.e(paramString, paramInt);
      AppMethodBeat.o(98710);
      return;
      label186:
      if (!bs.lr(com.tencent.mm.plugin.sns.data.q.wX(paramString.field_snsId), localdy.dHM))
      {
        com.tencent.mm.plugin.sns.j.f.ydE.dJB();
        localdy = com.tencent.mm.plugin.sns.j.f.ydE.dJy();
        localdy.dTa = 0L;
        localdy = localdy.lU(com.tencent.mm.plugin.sns.data.q.wX(paramString.field_snsId)).lT(com.tencent.mm.plugin.sns.j.f.ydE.ydQ.dUd);
        localdy.dNc = com.tencent.mm.plugin.sns.j.f.ydE.ydQ.dNc;
        localdy.dHS = localTimeLineObject.FQo.Ety;
        localdy.dSZ = localTimeLineObject.FQo.Etz.size();
        com.tencent.mm.plugin.sns.j.f.ydE.yeg = System.currentTimeMillis();
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
    this.yIJ = getIntent().getIntExtra("sns_gallery_position", 0);
    Object localObject = x.bk("sns_table_", i);
    ac.i("MicroMsg.SnsGalleryUI", "initView localId:%s, pos:%d", new Object[] { localObject, Integer.valueOf(this.yIJ) });
    eJ((String)localObject, this.yIJ);
    Q(bool, 1);
    this.yIC = new SnsInfoFlip(this);
    this.yIC.setVideoScene(this.scene);
    this.yIC.setNeedScanImage(true);
    localObject = af.dHH();
    String str = this.userName;
    if (((am.a)localObject).xVp.containsKey(str))
    {
      i = ((Integer)((am.a)localObject).xVp.get(str)).intValue();
      ((am.a)localObject).xVp.put(str, Integer.valueOf(i + 1));
      localObject = (ArrayList)((am.a)localObject).xVo.get(str);
      if (localObject != null) {
        break label467;
      }
      localObject = new ArrayList();
    }
    label467:
    for (;;)
    {
      this.yIC.setShowTitle(true);
      this.yIC.setEnableHorLongBmpMode(false);
      this.yIC.a((List)localObject, this.userName, this.yIJ, this.yIx, this);
      this.yIC.setOnDeleteAllAction(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(98697);
          SnsGalleryUI.this.yIz.dNw();
          AppMethodBeat.o(98697);
        }
      });
      this.yIC.setOnPageSelectListener(this);
      g.agS();
      localObject = ((k)g.ab(k.class)).awB().aNt(this.userName);
      if ((localObject != null) && ((int)((com.tencent.mm.n.b)localObject).fLJ > 0) && (com.tencent.mm.n.b.ln(((av)localObject).field_type))) {
        localObject = bf.fbl();
      }
      for (;;)
      {
        this.yIC.setFromScene((bf)localObject);
        this.yIC.username = this.userName;
        addView(this.yIC);
        setBackBtn(new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(98698);
            SnsGalleryUI.this.yIz.dNw();
            AppMethodBeat.o(98698);
            return true;
          }
        });
        addIconOptionMenu(0, 2131690603, new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(98699);
            Object localObject = SnsGalleryUI.this.yIC.getSelectId();
            String str = SnsGalleryUI.this.yIC.getSelectedMediaId();
            paramAnonymousMenuItem = SnsGalleryUI.this.yIC.getSelectItem();
            ac.d("MicroMsg.SnsGalleryUI", "click selectLocalId ".concat(String.valueOf(localObject)));
            ac.d("MicroMsg.SnsGalleryUI", "click position ".concat(String.valueOf(str)));
            localObject = af.dHR().auT((String)localObject);
            for (;;)
            {
              try
              {
                i = SnsGalleryUI.this.yIC.getPosition();
                int j = ((p)localObject).dLV().FQo.Etz.size();
                if ((j <= 1) || (i <= 1) || (i > j)) {
                  continue;
                }
                i -= 1;
                SnsGalleryUI.this.yIz.a(bool, (p)localObject, paramAnonymousMenuItem.dwE, SnsGalleryUI.this.yIC.yzk, true, i);
              }
              catch (Exception paramAnonymousMenuItem)
              {
                int i;
                ac.printErrStackTrace("MicroMsg.SnsGalleryUI", paramAnonymousMenuItem, "", new Object[0]);
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
        ((am.a)localObject).xVp.put(str, Integer.valueOf(0));
        break;
        localObject = com.tencent.mm.model.u.axw();
        if (this.userName.equals(localObject)) {
          localObject = bf.fbm();
        } else {
          localObject = bf.fbn();
        }
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(98709);
    ac.i("MicroMsg.SnsGalleryUI", "onAcvityResult requestCode:".concat(String.valueOf(paramInt1)));
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
      if (this.yIC == null) {
        break label534;
      }
      paramIntent = this.yIC.getSelectItem();
      if (paramIntent.dwE.ndI != 6)
      {
        AppMethodBeat.o(98709);
        return;
      }
    }
    label514:
    label534:
    for (Object localObject2 = paramIntent.dwE;; localObject2 = null)
    {
      if (localObject2 == null)
      {
        AppMethodBeat.o(98709);
        return;
      }
      String str3 = an.jc(af.getAccSnsPath(), ((btz)localObject2).Id);
      paramIntent = "";
      Object localObject1 = "";
      String str4 = com.tencent.mm.plugin.sns.data.q.i((btz)localObject2);
      if (com.tencent.mm.vfs.i.eA(str3 + str4))
      {
        localObject1 = str3 + str4;
        paramIntent = str3 + com.tencent.mm.plugin.sns.data.q.d((btz)localObject2);
      }
      if (com.tencent.mm.vfs.i.eA(str3 + com.tencent.mm.plugin.sns.data.q.o((btz)localObject2))) {
        paramIntent = str3 + com.tencent.mm.plugin.sns.data.q.o((btz)localObject2);
      }
      for (localObject1 = str3 + com.tencent.mm.plugin.sns.data.q.m((btz)localObject2);; localObject1 = localObject2)
      {
        localObject2 = bs.S(str2.split(","));
        paramInt1 = com.tencent.mm.plugin.sns.data.q.ate(paramIntent);
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          str2 = (String)((Iterator)localObject2).next();
          ac.i("MicroMsg.SnsGalleryUI", "send sight to %s, videopath %s, thumbpath %s duration %d", new Object[] { str2, paramIntent, localObject1, Integer.valueOf(paramInt1) });
          j.dck().a(this, str2, paramIntent, (String)localObject1, 62, paramInt1, "", null);
          j.dck().hF(str1, str2);
        }
        com.tencent.mm.ui.widget.snackbar.b.n(this, getString(2131760233));
        AppMethodBeat.o(98709);
        return;
        if (1 == paramInt1)
        {
          paramInt1 = paramIntent.getIntExtra("sns_gallery_op_id", 0);
          localObject1 = x.bk("sns_table_", paramIntent.getIntExtra("sns_gallery_op_id", 0));
          this.yIz.Pk(paramInt1);
          eI((String)localObject1, 1);
          if (paramIntent.getBooleanExtra("sns_gallery_force_finish", false))
          {
            paramIntent = new Intent();
            paramIntent.putExtra("sns_cmd_list", this.yIz.yzV);
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
    com.tencent.mm.plugin.sns.j.f.ydE.ydZ = System.currentTimeMillis();
    AppMethodBeat.o(98700);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98701);
    getWindow().clearFlags(128);
    Object localObject = af.dHH();
    String str = this.userName;
    int i;
    if (((am.a)localObject).xVp.containsKey(str))
    {
      i = Math.max(((Integer)((am.a)localObject).xVp.get(str)).intValue() - 1, 0);
      ((am.a)localObject).xVp.put(str, Integer.valueOf(i));
    }
    for (;;)
    {
      if (i <= 0) {
        ((am.a)localObject).xVo.remove(str);
      }
      af.dHO().aD(this);
      super.onDestroy();
      localObject = com.tencent.mm.plugin.sns.j.f.ydE;
      if (((com.tencent.mm.plugin.sns.j.f)localObject).ydZ != 0L)
      {
        ((com.tencent.mm.plugin.sns.j.f)localObject).yea += System.currentTimeMillis() - ((com.tencent.mm.plugin.sns.j.f)localObject).ydZ;
        ((com.tencent.mm.plugin.sns.j.f)localObject).ydZ = 0L;
      }
      com.tencent.mm.plugin.sns.j.f.ydE.dJz();
      com.tencent.mm.plugin.sns.j.f.ydE.dJB();
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
    if (this.yIC != null)
    {
      btz localbtz = this.yIC.getCntMedia();
      localSnsInfoFlip = this.yIC;
      if ((localbtz == null) || (localbtz.ndI != 6)) {
        break label63;
      }
    }
    label63:
    for (boolean bool = true;; bool = false)
    {
      localSnsInfoFlip.rn(bool);
      com.tencent.mm.plugin.ball.f.f.e(true, true, true);
      AppMethodBeat.o(98705);
      return;
    }
  }
  
  public void onStart()
  {
    AppMethodBeat.i(98702);
    super.onStart();
    com.tencent.mm.plugin.sns.j.f.ydE.yeg = System.currentTimeMillis();
    AppMethodBeat.o(98702);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(98703);
    super.onStop();
    com.tencent.mm.plugin.sns.j.f.ydE.dJz();
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