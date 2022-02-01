package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelpackage.u;
import com.tencent.mm.modelsns.l;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.model.as;
import com.tencent.mm.plugin.sns.model.bf;
import com.tencent.mm.plugin.sns.model.bg;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.statistics.j;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.List;

public class ArtistBrowseUI
  extends SnsBaseGalleryUI
  implements z.a
{
  private String Kca = "";
  private String RaJ = "";
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(97721);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      Log.d("MicroMsg.ArtistBrowseUI", "dispatchKeyEvent");
      paramKeyEvent = new Intent();
      paramKeyEvent.putExtra("sns_cmd_list", this.RnE.RdQ);
      setResult(-1, paramKeyEvent);
      finish();
      AppMethodBeat.o(97721);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(97721);
    return bool;
  }
  
  public int getLayoutId()
  {
    return b.g.sns_gallery_img;
  }
  
  public final void hf(String paramString, int paramInt)
  {
    AppMethodBeat.i(97724);
    if (this.RnH != null) {
      this.RnH.Ei(true);
    }
    AppMethodBeat.o(97724);
  }
  
  public final void hg(String paramString, int paramInt) {}
  
  public void initView()
  {
    AppMethodBeat.i(97722);
    setActionbarColor(getResources().getColor(b.c.black));
    setNavigationbarColor(getResources().getColor(b.c.black));
    this.Kca = getIntent().getStringExtra("sns_gallery_artist_lan");
    int i = getIntent().getIntExtra("sns_gallery_position", 0);
    u.bLH();
    this.RaJ = com.tencent.mm.modelpackage.t.bLE();
    am(false, 2);
    this.RnH = new SnsInfoFlip(this);
    List localList = ap.me(this.Kca, this.RaJ);
    this.RnH.setShowTitle(true);
    this.RnH.a(localList, "", i, this.RnC, this);
    this.RnH.setOnPageSelectListener(this);
    addView(this.RnH);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(97716);
        ArtistBrowseUI.this.RnE.hlZ();
        AppMethodBeat.o(97716);
        return true;
      }
    });
    setMMTitle(b.j.sns_ui_setback);
    showOptionMenu(false);
    this.RnC.setCallBack(new y.a()
    {
      public final void hlv()
      {
        AppMethodBeat.i(97717);
        Object localObject1 = ArtistBrowseUI.this.RnH.getCntMedia();
        if (localObject1 == null)
        {
          AppMethodBeat.o(97717);
          return;
        }
        Log.d("MicroMsg.ArtistBrowseUI", "set bg the meida id " + ((dmz)localObject1).Id);
        Object localObject2 = l.wO(723);
        ((l)localObject2).Ph(((dmz)localObject1).Url);
        ((l)localObject2).bMH();
        if (!com.tencent.mm.vfs.y.ZC(as.mg(al.getAccSnsPath(), ((dmz)localObject1).Id) + com.tencent.mm.plugin.sns.data.t.k((dmz)localObject1)))
        {
          AppMethodBeat.o(97717);
          return;
        }
        localObject2 = al.hgx();
        String str2;
        if ((((bf)localObject2).hgg() != null) && (!((bf)localObject2).hgg().equals("")))
        {
          String str1 = as.mg(al.getAccSnsPath(), ((dmz)localObject1).Id) + com.tencent.mm.plugin.sns.data.t.k((dmz)localObject1);
          str2 = as.mg(al.getAccSnsPath(), ((bf)localObject2).hgg());
          if (!com.tencent.mm.vfs.y.ZC(str1)) {
            break label499;
          }
          Log.d("MicroMsg.UploadManager", "bg file is exist!'");
          com.tencent.mm.vfs.y.bDX(str2);
          com.tencent.mm.vfs.y.deleteFile(str2 + ((bf)localObject2).hgg() + "bg_");
          com.tencent.mm.vfs.y.deleteFile(str2 + ((bf)localObject2).hgg() + "tbg_");
          com.tencent.mm.vfs.y.O(str1, str2 + ((bf)localObject2).hgg() + "bg_", false);
        }
        for (;;)
        {
          al.hgG().bb(((bf)localObject2).hgg(), str2 + ((bf)localObject2).hgg() + "bg_", "");
          ((bf)localObject2).hhF();
          localObject2 = new bg(7);
          ((dmz)localObject1).aaTq = 1;
          ((bg)localObject2).QzA.ContentObj.Zpr.add(localObject1);
          ((bg)localObject2).akN(2);
          int i = ((bg)localObject2).FW();
          j.QFS.QGM = i;
          localObject2 = new Intent();
          ((Intent)localObject2).setClass(ArtistBrowseUI.this, SettingSnsBackgroundUI.class);
          ((Intent)localObject2).setFlags(536870912);
          ((Intent)localObject2).addFlags(67108864);
          localObject1 = ArtistBrowseUI.this;
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
          com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/sns/ui/ArtistBrowseUI$2", "onSetBgFinish", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((ArtistBrowseUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/sns/ui/ArtistBrowseUI$2", "onSetBgFinish", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ArtistBrowseUI.this.finish();
          AppMethodBeat.o(97717);
          return;
          label499:
          com.tencent.mm.vfs.y.deleteFile(str2 + ((bf)localObject2).hgg() + "bg_");
          com.tencent.mm.vfs.y.deleteFile(str2 + ((bf)localObject2).hgg() + "tbg_");
          Log.e("MicroMsg.UploadManager", "bg file is not exist! wait to down it");
        }
      }
    });
    AppMethodBeat.o(97722);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(97725);
    Log.i("MicroMsg.ArtistBrowseUI", "onAcvityResult requestCode:".concat(String.valueOf(paramInt1)));
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(97725);
      return;
    }
    paramInt1 = paramIntent.getIntExtra("sns_gallery_op_id", 0);
    this.RnE.alE(paramInt1);
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
    al.hgy().bq(this);
    super.onDestroy();
    AppMethodBeat.o(97719);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(97723);
    if (this.RnH != null) {
      this.RnH.onPause();
    }
    super.onPause();
    AppMethodBeat.o(97723);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(97720);
    super.onResume();
    if (this.RnH != null) {
      this.RnH.Ei(false);
    }
    AppMethodBeat.o(97720);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ArtistBrowseUI
 * JD-Core Version:    0.7.0.1
 */