package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.r;
import com.tencent.mm.n.a;
import com.tencent.mm.plugin.messenger.a.d;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.an.a;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.plugin.webview.ui.tools.widget.o;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bd;
import com.tencent.mm.vfs.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@com.tencent.mm.kernel.i
public class SnsGalleryUI
  extends SnsBaseGalleryUI
  implements s.a
{
  private int rNV = 0;
  private int scene = 0;
  private String userName = "";
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(38942);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      ab.d("MicroMsg.SnsGalleryUI", "dispatchKeyEvent");
      paramKeyEvent = new Intent();
      paramKeyEvent.putExtra("sns_cmd_list", this.rNP.rHi);
      setResult(-1, paramKeyEvent);
      finish();
      AppMethodBeat.o(38942);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(38942);
    return bool;
  }
  
  public final void ds(String paramString, int paramInt)
  {
    AppMethodBeat.i(38944);
    if (this.rNT != null)
    {
      if ((!bo.isNullOrNil(paramString)) && (paramInt != 3))
      {
        SnsInfoFlip localSnsInfoFlip = this.rNT;
        if (localSnsInfoFlip.items != null)
        {
          paramInt = 0;
          if (paramInt >= 0)
          {
            label42:
            if (paramInt < localSnsInfoFlip.items.size())
            {
              com.tencent.mm.plugin.sns.h.b localb = (com.tencent.mm.plugin.sns.h.b)localSnsInfoFlip.items.get(paramInt);
              if ((!bo.isNullOrNil(localb.rlJ)) && (localb.rlJ.equals(paramString))) {
                localSnsInfoFlip.items.remove(paramInt);
              }
            }
            for (;;)
            {
              break;
              paramInt += 1;
              break label42;
              paramInt = -1;
            }
          }
          localSnsInfoFlip.rQT.notifyDataSetChanged();
        }
      }
      this.rNT.bvl();
    }
    AppMethodBeat.o(38944);
  }
  
  public int getLayoutId()
  {
    return 2130970825;
  }
  
  public void initView()
  {
    AppMethodBeat.i(38943);
    this.scene = getIntent().getIntExtra("sns_video_scene", 0);
    this.userName = getIntent().getStringExtra("sns_gallery_userName");
    int i = getIntent().getIntExtra("sns_gallery_localId", 0);
    boolean bool = getIntent().getBooleanExtra("sns_gallery_is_self", false);
    this.rNV = getIntent().getIntExtra("sns_gallery_position", 0);
    Object localObject = v.aF("sns_table_", i);
    ab.i("MicroMsg.SnsGalleryUI", "initView localId:%s, pos:%d", new Object[] { localObject, Integer.valueOf(this.rNV) });
    dt((String)localObject, this.rNV);
    E(bool, 1);
    this.rNT = new SnsInfoFlip(this);
    this.rNT.setVideoScene(this.scene);
    this.rNT.setNeedScanImage(true);
    localObject = ag.coV();
    String str = this.userName;
    if (((an.a)localObject).rij.containsKey(str))
    {
      i = ((Integer)((an.a)localObject).rij.get(str)).intValue();
      ((an.a)localObject).rij.put(str, Integer.valueOf(i + 1));
      localObject = (ArrayList)((an.a)localObject).rii.get(str);
      if (localObject != null) {
        break label458;
      }
      localObject = new ArrayList();
    }
    label458:
    for (;;)
    {
      this.rNT.setDoubleClick(true);
      this.rNT.setShowTitle(true);
      this.rNT.setEnableHorLongBmpMode(false);
      this.rNT.a((List)localObject, this.userName, this.rNV, this.rNO, this);
      this.rNT.setOnDeleteAllAction(new SnsGalleryUI.1(this));
      com.tencent.mm.kernel.g.RM();
      localObject = ((j)com.tencent.mm.kernel.g.E(j.class)).YA().arw(this.userName);
      if ((localObject != null) && ((int)((a)localObject).euF > 0) && (a.je(((aq)localObject).field_type))) {
        localObject = az.dxC();
      }
      for (;;)
      {
        this.rNT.setFromScene((az)localObject);
        this.rNT.username = this.userName;
        addView(this.rNT);
        setBackBtn(new SnsGalleryUI.2(this));
        addIconOptionMenu(0, 2130839668, new SnsGalleryUI.3(this, bool));
        AppMethodBeat.o(38943);
        return;
        ((an.a)localObject).rij.put(str, Integer.valueOf(0));
        break;
        localObject = r.Zn();
        if (this.userName.equals(localObject)) {
          localObject = az.dxD();
        } else {
          localObject = az.dxE();
        }
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(38945);
    ab.i("MicroMsg.SnsGalleryUI", "onAcvityResult requestCode:".concat(String.valueOf(paramInt1)));
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(38945);
      return;
    }
    String str2;
    String str1;
    if (2 == paramInt1)
    {
      if (-1 != paramInt2) {
        break label512;
      }
      str2 = paramIntent.getStringExtra("Select_Conv_User");
      str1 = paramIntent.getStringExtra("custom_send_text");
      if (this.rNT == null) {
        break label532;
      }
      paramIntent = this.rNT.getSelectItem();
      if (paramIntent.cIc.jKs != 6)
      {
        AppMethodBeat.o(38945);
        return;
      }
    }
    label512:
    label532:
    for (Object localObject2 = paramIntent.cIc;; localObject2 = null)
    {
      if (localObject2 == null)
      {
        AppMethodBeat.o(38945);
        return;
      }
      String str3 = ao.gl(ag.getAccSnsPath(), ((bcs)localObject2).Id);
      paramIntent = "";
      Object localObject1 = "";
      String str4 = com.tencent.mm.plugin.sns.data.i.j((bcs)localObject2);
      if (e.cN(str3 + str4))
      {
        localObject1 = str3 + str4;
        paramIntent = str3 + com.tencent.mm.plugin.sns.data.i.e((bcs)localObject2);
      }
      if (e.cN(str3 + com.tencent.mm.plugin.sns.data.i.p((bcs)localObject2))) {
        paramIntent = str3 + com.tencent.mm.plugin.sns.data.i.p((bcs)localObject2);
      }
      for (localObject1 = str3 + com.tencent.mm.plugin.sns.data.i.n((bcs)localObject2);; localObject1 = localObject2)
      {
        localObject2 = bo.P(str2.split(","));
        paramInt1 = com.tencent.mm.plugin.sns.data.i.ZO(paramIntent);
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          str2 = (String)((Iterator)localObject2).next();
          ab.i("MicroMsg.SnsGalleryUI", "send sight to %s, videopath %s, thumbpath %s duration %d", new Object[] { str2, paramIntent, localObject1, Integer.valueOf(paramInt1) });
          com.tencent.mm.plugin.messenger.a.g.bPJ().a(this, str2, paramIntent, (String)localObject1, 62, paramInt1, "");
          com.tencent.mm.plugin.messenger.a.g.bPJ().fh(str1, str2);
        }
        com.tencent.mm.ui.widget.snackbar.b.l(this, getString(2131300637));
        AppMethodBeat.o(38945);
        return;
        if (1 == paramInt1)
        {
          paramInt1 = paramIntent.getIntExtra("sns_gallery_op_id", 0);
          localObject1 = v.aF("sns_table_", paramIntent.getIntExtra("sns_gallery_op_id", 0));
          this.rNP.EC(paramInt1);
          ds((String)localObject1, 1);
          if (paramIntent.getBooleanExtra("sns_gallery_force_finish", false))
          {
            paramIntent = new Intent();
            paramIntent.putExtra("sns_cmd_list", this.rNP.rHi);
            setResult(-1, paramIntent);
            finish();
          }
        }
        AppMethodBeat.o(38945);
        return;
        localObject2 = paramIntent;
        paramIntent = (Intent)localObject1;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(38938);
    super.onCreate(paramBundle);
    getWindow().addFlags(128);
    setActionbarColor(getContext().getResources().getColor(2131689915));
    setNavigationbarColor(getContext().getResources().getColor(2131689915));
    initView();
    AppMethodBeat.o(38938);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(38939);
    if (this.rNT != null)
    {
      this.rNT.cvl();
      this.rNT.onDestroy();
    }
    getWindow().clearFlags(128);
    an.a locala = ag.coV();
    String str = this.userName;
    int i;
    if (locala.rij.containsKey(str))
    {
      i = Math.max(((Integer)locala.rij.get(str)).intValue() - 1, 0);
      locala.rij.put(str, Integer.valueOf(i));
    }
    for (;;)
    {
      if (i <= 0) {
        locala.rii.remove(str);
      }
      ag.cpc().ah(this);
      super.onDestroy();
      AppMethodBeat.o(38939);
      return;
      i = 0;
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(38940);
    super.onPause();
    o.La(2);
    AppMethodBeat.o(38940);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(38941);
    super.onResume();
    if (this.rNT != null) {
      this.rNT.bvl();
    }
    o.La(1);
    AppMethodBeat.o(38941);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsGalleryUI
 * JD-Core Version:    0.7.0.1
 */