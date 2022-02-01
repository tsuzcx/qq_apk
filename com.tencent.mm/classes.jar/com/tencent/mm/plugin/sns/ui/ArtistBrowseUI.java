package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bc.p;
import com.tencent.mm.bc.t;
import com.tencent.mm.modelsns.e;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ak;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.plugin.sns.model.bb;
import com.tencent.mm.plugin.sns.model.bc;
import com.tencent.mm.plugin.sns.model.f;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.i;
import java.util.LinkedList;
import java.util.List;

public class ArtistBrowseUI
  extends SnsBaseGalleryUI
  implements v.a
{
  private String uZv = "";
  private String zOp = "";
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(97721);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      ad.d("MicroMsg.ArtistBrowseUI", "dispatchKeyEvent");
      paramKeyEvent = new Intent();
      paramKeyEvent.putExtra("sns_cmd_list", this.zZT.zRm);
      setResult(-1, paramKeyEvent);
      finish();
      AppMethodBeat.o(97721);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(97721);
    return bool;
  }
  
  public final void fa(String paramString, int paramInt)
  {
    AppMethodBeat.i(97724);
    if (this.zZW != null) {
      this.zZW.rR(true);
    }
    AppMethodBeat.o(97724);
  }
  
  public final void fb(String paramString, int paramInt) {}
  
  public int getLayoutId()
  {
    return 2131495548;
  }
  
  public void initView()
  {
    AppMethodBeat.i(97722);
    setActionbarColor(getResources().getColor(2131100017));
    setNavigationbarColor(getResources().getColor(2131100017));
    this.uZv = getIntent().getStringExtra("sns_gallery_artist_lan");
    int i = getIntent().getIntExtra("sns_gallery_position", 0);
    t.aJZ();
    this.zOp = p.aJW();
    R(false, 2);
    this.zZW = new SnsInfoFlip(this);
    List localList = ak.jm(this.uZv, this.zOp);
    this.zZW.setShowTitle(true);
    this.zZW.a(localList, "", i, this.zZR, this);
    this.zZW.setOnPageSelectListener(this);
    addView(this.zZW);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(97716);
        ArtistBrowseUI.this.zZT.dZL();
        AppMethodBeat.o(97716);
        return true;
      }
    });
    setMMTitle(2131764047);
    showOptionMenu(false);
    this.zZR.setCallBack(new u.a()
    {
      public final void dZs()
      {
        AppMethodBeat.i(97717);
        Object localObject1 = ArtistBrowseUI.this.zZW.getCntMedia();
        if (localObject1 == null)
        {
          AppMethodBeat.o(97717);
          return;
        }
        ad.d("MicroMsg.ArtistBrowseUI", "set bg the meida id " + ((byn)localObject1).Id);
        Object localObject2 = e.pV(723);
        ((e)localObject2).Gs(((byn)localObject1).Url);
        ((e)localObject2).aLk();
        if (!i.fv(ao.jo(ag.getAccSnsPath(), ((byn)localObject1).Id) + q.k((byn)localObject1)))
        {
          AppMethodBeat.o(97717);
          return;
        }
        localObject2 = ag.dUa();
        Object localObject3;
        String str;
        if ((((bb)localObject2).dTJ() != null) && (!((bb)localObject2).dTJ().equals("")))
        {
          localObject3 = ao.jo(ag.getAccSnsPath(), ((byn)localObject1).Id) + q.k((byn)localObject1);
          str = ao.jo(ag.getAccSnsPath(), ((bb)localObject2).dTJ());
          if (!i.fv((String)localObject3)) {
            break label486;
          }
          ad.d("MicroMsg.UploadManager", "bg file is exist!'");
          i.aYg(str);
          i.deleteFile(str + ((bb)localObject2).dTJ() + "bg_");
          i.deleteFile(str + ((bb)localObject2).dTJ() + "tbg_");
          i.mz((String)localObject3, str + ((bb)localObject2).dTJ() + "bg_");
        }
        for (;;)
        {
          localObject3 = ag.dUi();
          Object localObject4 = ((bb)localObject2).dTJ();
          str = ((byn)localObject1).Id;
          localObject4 = ((o)localObject3).aAf((String)localObject4);
          ((n)localObject4).field_bgId = str;
          ((o)localObject3).c((n)localObject4);
          ((bb)localObject2).dVe();
          localObject2 = new bc(7);
          ((byn)localObject1).GSO = 1;
          ((bc)localObject2).znM.HAT.GaQ.add(localObject1);
          ((bc)localObject2).Qd(2);
          ((bc)localObject2).commit();
          localObject2 = new Intent();
          ((Intent)localObject2).setClass(ArtistBrowseUI.this, SettingSnsBackgroundUI.class);
          ((Intent)localObject2).setFlags(536870912);
          ((Intent)localObject2).addFlags(67108864);
          localObject1 = ArtistBrowseUI.this;
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahp(), "com/tencent/mm/plugin/sns/ui/ArtistBrowseUI$2", "onSetBgFinish", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((ArtistBrowseUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/sns/ui/ArtistBrowseUI$2", "onSetBgFinish", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ArtistBrowseUI.this.finish();
          AppMethodBeat.o(97717);
          return;
          label486:
          i.deleteFile(str + ((bb)localObject2).dTJ() + "bg_");
          i.deleteFile(str + ((bb)localObject2).dTJ() + "tbg_");
          ad.e("MicroMsg.UploadManager", "bg file is not exist! wait to down it");
        }
      }
    });
    AppMethodBeat.o(97722);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(97725);
    ad.i("MicroMsg.ArtistBrowseUI", "onAcvityResult requestCode:".concat(String.valueOf(paramInt1)));
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(97725);
      return;
    }
    paramInt1 = paramIntent.getIntExtra("sns_gallery_op_id", 0);
    this.zZT.QS(paramInt1);
    AppMethodBeat.o(97725);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(97718);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(97718);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(97719);
    ag.dUb().aD(this);
    super.onDestroy();
    AppMethodBeat.o(97719);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(97723);
    if (this.zZW != null) {
      this.zZW.onPause();
    }
    super.onPause();
    AppMethodBeat.o(97723);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(97720);
    super.onResume();
    if (this.zZW != null) {
      this.zZW.rR(false);
    }
    AppMethodBeat.o(97720);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ArtistBrowseUI
 * JD-Core Version:    0.7.0.1
 */