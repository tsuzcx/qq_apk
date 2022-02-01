package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.be.s;
import com.tencent.mm.be.w;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.plugin.sns.model.bd;
import com.tencent.mm.plugin.sns.model.be;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.u;
import java.util.LinkedList;
import java.util.List;

public class ArtistBrowseUI
  extends SnsBaseGalleryUI
  implements y.a
{
  private String Ejr = "";
  private String KBc = "";
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(97721);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      Log.d("MicroMsg.ArtistBrowseUI", "dispatchKeyEvent");
      paramKeyEvent = new Intent();
      paramKeyEvent.putExtra("sns_cmd_list", this.KNT.KEo);
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
    return i.g.sns_gallery_img;
  }
  
  public final void gl(String paramString, int paramInt)
  {
    AppMethodBeat.i(97724);
    if (this.KNW != null) {
      this.KNW.yY(true);
    }
    AppMethodBeat.o(97724);
  }
  
  public final void gm(String paramString, int paramInt) {}
  
  public void initView()
  {
    AppMethodBeat.i(97722);
    setActionbarColor(getResources().getColor(i.c.black));
    setNavigationbarColor(getResources().getColor(i.c.black));
    this.Ejr = getIntent().getStringExtra("sns_gallery_artist_lan");
    int i = getIntent().getIntExtra("sns_gallery_position", 0);
    w.bnU();
    this.KBc = s.bnR();
    ak(false, 2);
    this.KNW = new SnsInfoFlip(this);
    List localList = an.kB(this.Ejr, this.KBc);
    this.KNW.setShowTitle(true);
    this.KNW.a(localList, "", i, this.KNR, this);
    this.KNW.setOnPageSelectListener(this);
    addView(this.KNW);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(97716);
        ArtistBrowseUI.this.KNT.fTG();
        AppMethodBeat.o(97716);
        return true;
      }
    });
    setMMTitle(i.j.sns_ui_setback);
    showOptionMenu(false);
    this.KNR.setCallBack(new x.a()
    {
      public final void fTf()
      {
        AppMethodBeat.i(97717);
        Object localObject1 = ArtistBrowseUI.this.KNW.getCntMedia();
        if (localObject1 == null)
        {
          AppMethodBeat.o(97717);
          return;
        }
        Log.d("MicroMsg.ArtistBrowseUI", "set bg the meida id " + ((cvt)localObject1).Id);
        Object localObject2 = com.tencent.mm.modelsns.l.wO(723);
        ((com.tencent.mm.modelsns.l)localObject2).Xf(((cvt)localObject1).Url);
        ((com.tencent.mm.modelsns.l)localObject2).bpa();
        if (!u.agG(aq.kD(aj.getAccSnsPath(), ((cvt)localObject1).Id) + t.k((cvt)localObject1)))
        {
          AppMethodBeat.o(97717);
          return;
        }
        localObject2 = aj.fOE();
        Object localObject3;
        String str;
        if ((((bd)localObject2).fOo() != null) && (!((bd)localObject2).fOo().equals("")))
        {
          localObject3 = aq.kD(aj.getAccSnsPath(), ((cvt)localObject1).Id) + t.k((cvt)localObject1);
          str = aq.kD(aj.getAccSnsPath(), ((bd)localObject2).fOo());
          if (!u.agG((String)localObject3)) {
            break label486;
          }
          Log.d("MicroMsg.UploadManager", "bg file is exist!'");
          u.bBD(str);
          u.deleteFile(str + ((bd)localObject2).fOo() + "bg_");
          u.deleteFile(str + ((bd)localObject2).fOo() + "tbg_");
          u.on((String)localObject3, str + ((bd)localObject2).fOo() + "bg_");
        }
        for (;;)
        {
          localObject3 = aj.fOM();
          Object localObject4 = ((bd)localObject2).fOo();
          str = ((cvt)localObject1).Id;
          localObject4 = ((m)localObject3).bbr((String)localObject4);
          ((com.tencent.mm.plugin.sns.storage.l)localObject4).field_bgId = str;
          ((m)localObject3).c((com.tencent.mm.plugin.sns.storage.l)localObject4);
          ((bd)localObject2).fPL();
          localObject2 = new be(7);
          ((cvt)localObject1).TDK = 1;
          ((be)localObject2).Kck.ContentObj.Sqr.add(localObject1);
          ((be)localObject2).afY(2);
          ((be)localObject2).in();
          localObject2 = new Intent();
          ((Intent)localObject2).setClass(ArtistBrowseUI.this, SettingSnsBackgroundUI.class);
          ((Intent)localObject2).setFlags(536870912);
          ((Intent)localObject2).addFlags(67108864);
          localObject1 = ArtistBrowseUI.this;
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject2);
          com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/plugin/sns/ui/ArtistBrowseUI$2", "onSetBgFinish", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((ArtistBrowseUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/sns/ui/ArtistBrowseUI$2", "onSetBgFinish", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ArtistBrowseUI.this.finish();
          AppMethodBeat.o(97717);
          return;
          label486:
          u.deleteFile(str + ((bd)localObject2).fOo() + "bg_");
          u.deleteFile(str + ((bd)localObject2).fOo() + "tbg_");
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
    this.KNT.agL(paramInt1);
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
    aj.fOF().aO(this);
    super.onDestroy();
    AppMethodBeat.o(97719);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(97723);
    if (this.KNW != null) {
      this.KNW.onPause();
    }
    super.onPause();
    AppMethodBeat.o(97723);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(97720);
    super.onResume();
    if (this.KNW != null) {
      this.KNW.yY(false);
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