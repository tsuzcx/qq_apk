package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bb.p;
import com.tencent.mm.bb.t;
import com.tencent.mm.modelsns.e;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.model.bc;
import com.tencent.mm.plugin.sns.model.bd;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;
import java.util.List;

public class ArtistBrowseUI
  extends SnsBaseGalleryUI
  implements v.a
{
  private String Afw = "";
  private String vlG = "";
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(97721);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      ae.d("MicroMsg.ArtistBrowseUI", "dispatchKeyEvent");
      paramKeyEvent = new Intent();
      paramKeyEvent.putExtra("sns_cmd_list", this.Arg.Ait);
      setResult(-1, paramKeyEvent);
      finish();
      AppMethodBeat.o(97721);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(97721);
    return bool;
  }
  
  public final void fj(String paramString, int paramInt)
  {
    AppMethodBeat.i(97724);
    if (this.Arj != null) {
      this.Arj.rY(true);
    }
    AppMethodBeat.o(97724);
  }
  
  public final void fk(String paramString, int paramInt) {}
  
  public int getLayoutId()
  {
    return 2131495548;
  }
  
  public void initView()
  {
    AppMethodBeat.i(97722);
    setActionbarColor(getResources().getColor(2131100017));
    setNavigationbarColor(getResources().getColor(2131100017));
    this.vlG = getIntent().getStringExtra("sns_gallery_artist_lan");
    int i = getIntent().getIntExtra("sns_gallery_position", 0);
    t.aKs();
    this.Afw = p.aKp();
    U(false, 2);
    this.Arj = new SnsInfoFlip(this);
    List localList = al.jt(this.vlG, this.Afw);
    this.Arj.setShowTitle(true);
    this.Arj.a(localList, "", i, this.Are, this);
    this.Arj.setOnPageSelectListener(this);
    addView(this.Arj);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(97716);
        ArtistBrowseUI.this.Arg.edr();
        AppMethodBeat.o(97716);
        return true;
      }
    });
    setMMTitle(2131764047);
    showOptionMenu(false);
    this.Are.setCallBack(new u.a()
    {
      public final void ecX()
      {
        AppMethodBeat.i(97717);
        Object localObject1 = ArtistBrowseUI.this.Arj.getCntMedia();
        if (localObject1 == null)
        {
          AppMethodBeat.o(97717);
          return;
        }
        ae.d("MicroMsg.ArtistBrowseUI", "set bg the meida id " + ((bzh)localObject1).Id);
        Object localObject2 = e.pY(723);
        ((e)localObject2).GU(((bzh)localObject1).Url);
        ((e)localObject2).aLH();
        if (!com.tencent.mm.vfs.o.fB(ap.jv(ah.getAccSnsPath(), ((bzh)localObject1).Id) + r.k((bzh)localObject1)))
        {
          AppMethodBeat.o(97717);
          return;
        }
        localObject2 = ah.dXA();
        Object localObject3;
        String str;
        if ((((bc)localObject2).dXj() != null) && (!((bc)localObject2).dXj().equals("")))
        {
          localObject3 = ap.jv(ah.getAccSnsPath(), ((bzh)localObject1).Id) + r.k((bzh)localObject1);
          str = ap.jv(ah.getAccSnsPath(), ((bc)localObject2).dXj());
          if (!com.tencent.mm.vfs.o.fB((String)localObject3)) {
            break label486;
          }
          ae.d("MicroMsg.UploadManager", "bg file is exist!'");
          com.tencent.mm.vfs.o.aZI(str);
          com.tencent.mm.vfs.o.deleteFile(str + ((bc)localObject2).dXj() + "bg_");
          com.tencent.mm.vfs.o.deleteFile(str + ((bc)localObject2).dXj() + "tbg_");
          com.tencent.mm.vfs.o.mF((String)localObject3, str + ((bc)localObject2).dXj() + "bg_");
        }
        for (;;)
        {
          localObject3 = ah.dXI();
          Object localObject4 = ((bc)localObject2).dXj();
          str = ((bzh)localObject1).Id;
          localObject4 = ((com.tencent.mm.plugin.sns.storage.o)localObject3).aBw((String)localObject4);
          ((n)localObject4).field_bgId = str;
          ((com.tencent.mm.plugin.sns.storage.o)localObject3).c((n)localObject4);
          ((bc)localObject2).dYF();
          localObject2 = new bd(7);
          ((bzh)localObject1).Hmp = 1;
          ((bd)localObject2).zFb.HUG.Gtx.add(localObject1);
          ((bd)localObject2).QK(2);
          ((bd)localObject2).commit();
          localObject2 = new Intent();
          ((Intent)localObject2).setClass(ArtistBrowseUI.this, SettingSnsBackgroundUI.class);
          ((Intent)localObject2).setFlags(536870912);
          ((Intent)localObject2).addFlags(67108864);
          localObject1 = ArtistBrowseUI.this;
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahE(), "com/tencent/mm/plugin/sns/ui/ArtistBrowseUI$2", "onSetBgFinish", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((ArtistBrowseUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/sns/ui/ArtistBrowseUI$2", "onSetBgFinish", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ArtistBrowseUI.this.finish();
          AppMethodBeat.o(97717);
          return;
          label486:
          com.tencent.mm.vfs.o.deleteFile(str + ((bc)localObject2).dXj() + "bg_");
          com.tencent.mm.vfs.o.deleteFile(str + ((bc)localObject2).dXj() + "tbg_");
          ae.e("MicroMsg.UploadManager", "bg file is not exist! wait to down it");
        }
      }
    });
    AppMethodBeat.o(97722);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(97725);
    ae.i("MicroMsg.ArtistBrowseUI", "onAcvityResult requestCode:".concat(String.valueOf(paramInt1)));
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(97725);
      return;
    }
    paramInt1 = paramIntent.getIntExtra("sns_gallery_op_id", 0);
    this.Arg.Rz(paramInt1);
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
    ah.dXB().aE(this);
    super.onDestroy();
    AppMethodBeat.o(97719);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(97723);
    if (this.Arj != null) {
      this.Arj.onPause();
    }
    super.onPause();
    AppMethodBeat.o(97723);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(97720);
    super.onResume();
    if (this.Arj != null) {
      this.Arj.rY(false);
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