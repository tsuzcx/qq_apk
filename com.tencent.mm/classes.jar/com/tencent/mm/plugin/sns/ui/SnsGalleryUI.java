package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.q;
import com.tencent.mm.n.a;
import com.tencent.mm.plugin.messenger.a.d;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.am.a;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.plugin.webview.ui.tools.widget.o;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bd;
import com.tencent.mm.vfs.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@com.tencent.mm.kernel.j
public class SnsGalleryUI
  extends SnsBaseGalleryUI
  implements s.a
{
  private int oVA = 0;
  private String userName = "";
  
  public final void cw(String paramString, int paramInt)
  {
    if (this.oVy != null)
    {
      if ((!bk.bl(paramString)) && (paramInt != 3))
      {
        SnsInfoFlip localSnsInfoFlip = this.oVy;
        if (localSnsInfoFlip.items != null)
        {
          paramInt = 0;
          if (paramInt >= 0)
          {
            label37:
            if (paramInt < localSnsInfoFlip.items.size())
            {
              com.tencent.mm.plugin.sns.g.b localb = (com.tencent.mm.plugin.sns.g.b)localSnsInfoFlip.items.get(paramInt);
              if ((!bk.bl(localb.owP)) && (localb.owP.equals(paramString))) {
                localSnsInfoFlip.items.remove(paramInt);
              }
            }
            for (;;)
            {
              break;
              paramInt += 1;
              break label37;
              paramInt = -1;
            }
          }
          localSnsInfoFlip.oYA.notifyDataSetChanged();
        }
      }
      this.oVy.aPg();
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      y.d("MicroMsg.SnsGalleryUI", "dispatchKeyEvent");
      paramKeyEvent = new Intent();
      paramKeyEvent.putExtra("sns_cmd_list", this.oVv.oPw);
      setResult(-1, paramKeyEvent);
      finish();
      return true;
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  protected final int getLayoutId()
  {
    return i.g.sns_gallery_img;
  }
  
  protected final void initView()
  {
    this.userName = getIntent().getStringExtra("sns_gallery_userName");
    int i = getIntent().getIntExtra("sns_gallery_localId", 0);
    boolean bool = getIntent().getBooleanExtra("sns_gallery_is_self", false);
    this.oVA = getIntent().getIntExtra("sns_gallery_position", 0);
    Object localObject = v.al("sns_table_", i);
    y.i("MicroMsg.SnsGalleryUI", "initView localId:%s, pos:%d", new Object[] { localObject, Integer.valueOf(this.oVA) });
    cx((String)localObject, this.oVA);
    w(bool, 1);
    this.oVy = new SnsInfoFlip(this);
    this.oVy.setNeedScanImage(true);
    localObject = af.bDv();
    String str = this.userName;
    if (((am.a)localObject).otr.containsKey(str))
    {
      i = ((Integer)((am.a)localObject).otr.get(str)).intValue();
      ((am.a)localObject).otr.put(str, Integer.valueOf(i + 1));
      localObject = (ArrayList)((am.a)localObject).otq.get(str);
      if (localObject != null) {
        break label423;
      }
      localObject = new ArrayList();
    }
    label423:
    for (;;)
    {
      this.oVy.setDoubleClick(true);
      this.oVy.setShowTitle(true);
      this.oVy.setEnableHorLongBmpMode(false);
      this.oVy.a((List)localObject, this.userName, this.oVA, this.oVt, this);
      this.oVy.setOnDeleteAllAction(new SnsGalleryUI.1(this));
      com.tencent.mm.kernel.g.DQ();
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(this.userName);
      if ((localObject != null) && ((int)((a)localObject).dBe > 0) && (a.gR(((ao)localObject).field_type))) {
        localObject = az.cuZ();
      }
      for (;;)
      {
        this.oVy.setFromScene((az)localObject);
        this.oVy.username = this.userName;
        addView(this.oVy);
        setBackBtn(new SnsGalleryUI.2(this));
        addIconOptionMenu(0, i.e.mm_title_btn_menu, new SnsGalleryUI.3(this, bool));
        return;
        ((am.a)localObject).otr.put(str, Integer.valueOf(0));
        break;
        localObject = q.Gj();
        if (this.userName.equals(localObject)) {
          localObject = az.cva();
        } else {
          localObject = az.cvb();
        }
      }
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    y.i("MicroMsg.SnsGalleryUI", "onAcvityResult requestCode:" + paramInt1);
    if (paramInt2 != -1) {}
    label501:
    label505:
    for (;;)
    {
      return;
      String str2;
      String str1;
      if (2 == paramInt1)
      {
        if (-1 != paramInt2) {
          continue;
        }
        str2 = paramIntent.getStringExtra("Select_Conv_User");
        str1 = paramIntent.getStringExtra("custom_send_text");
        if (this.oVy == null) {
          break label501;
        }
        paramIntent = this.oVy.getSelectItem();
        if (paramIntent.bZK.hQR != 6) {
          continue;
        }
      }
      for (Object localObject2 = paramIntent.bZK;; localObject2 = null)
      {
        if (localObject2 == null) {
          break label505;
        }
        String str3 = an.eJ(af.getAccSnsPath(), ((awd)localObject2).lsK);
        paramIntent = "";
        Object localObject1 = "";
        String str4 = i.j((awd)localObject2);
        if (e.bK(str3 + str4))
        {
          localObject1 = str3 + str4;
          paramIntent = str3 + i.e((awd)localObject2);
        }
        if (e.bK(str3 + i.p((awd)localObject2))) {
          paramIntent = str3 + i.p((awd)localObject2);
        }
        for (localObject1 = str3 + i.n((awd)localObject2);; localObject1 = localObject2)
        {
          localObject2 = bk.G(str2.split(","));
          paramInt1 = i.Nh(paramIntent);
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            str2 = (String)((Iterator)localObject2).next();
            y.i("MicroMsg.SnsGalleryUI", "send sight to %s, videopath %s, thumbpath %s duration %d", new Object[] { str2, paramIntent, localObject1, Integer.valueOf(paramInt1) });
            com.tencent.mm.plugin.messenger.a.g.bhI().a(this, str2, paramIntent, (String)localObject1, 62, paramInt1, "");
            com.tencent.mm.plugin.messenger.a.g.bhI().dO(str1, str2);
          }
          com.tencent.mm.ui.widget.snackbar.b.h(this, getString(i.j.has_send));
          return;
          if (1 != paramInt1) {
            break;
          }
          paramInt1 = paramIntent.getIntExtra("sns_gallery_op_id", 0);
          localObject1 = v.al("sns_table_", paramIntent.getIntExtra("sns_gallery_op_id", 0));
          this.oVv.yw(paramInt1);
          cw((String)localObject1, 1);
          if (!paramIntent.getBooleanExtra("sns_gallery_force_finish", false)) {
            break;
          }
          paramIntent = new Intent();
          paramIntent.putExtra("sns_cmd_list", this.oVv.oPw);
          setResult(-1, paramIntent);
          finish();
          return;
          localObject2 = paramIntent;
          paramIntent = (Intent)localObject1;
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().addFlags(128);
    initView();
  }
  
  public void onDestroy()
  {
    if (this.oVy != null)
    {
      this.oVy.bIQ();
      this.oVy.onDestroy();
    }
    getWindow().clearFlags(128);
    am.a locala = af.bDv();
    String str = this.userName;
    int i;
    if (locala.otr.containsKey(str))
    {
      i = Math.max(((Integer)locala.otr.get(str)).intValue() - 1, 0);
      locala.otr.put(str, Integer.valueOf(i));
    }
    for (;;)
    {
      if (i <= 0) {
        locala.otq.remove(str);
      }
      af.bDC().M(this);
      super.onDestroy();
      return;
      i = 0;
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    o.Dh(2);
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.oVy != null) {
      this.oVy.aPg();
    }
    o.Dh(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsGalleryUI
 * JD-Core Version:    0.7.0.1
 */