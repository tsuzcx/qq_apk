package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.k;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.ar;
import com.tencent.mm.plugin.sns.model.be;
import com.tencent.mm.plugin.sns.model.bf;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import java.util.LinkedList;
import java.util.List;

public class ArtistBrowseUI
  extends SnsBaseGalleryUI
  implements w.a
{
  private String EnT = "";
  private String yFy = "";
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(97721);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      Log.d("MicroMsg.ArtistBrowseUI", "dispatchKeyEvent");
      paramKeyEvent = new Intent();
      paramKeyEvent.putExtra("sns_cmd_list", this.EAf.EqW);
      setResult(-1, paramKeyEvent);
      finish();
      AppMethodBeat.o(97721);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(97721);
    return bool;
  }
  
  public final void fH(String paramString, int paramInt)
  {
    AppMethodBeat.i(97724);
    if (this.EAi != null) {
      this.EAi.vu(true);
    }
    AppMethodBeat.o(97724);
  }
  
  public final void fI(String paramString, int paramInt) {}
  
  public int getLayoutId()
  {
    return 2131496440;
  }
  
  public void initView()
  {
    AppMethodBeat.i(97722);
    setActionbarColor(getResources().getColor(2131100042));
    setNavigationbarColor(getResources().getColor(2131100042));
    this.yFy = getIntent().getStringExtra("sns_gallery_artist_lan");
    int i = getIntent().getIntExtra("sns_gallery_position", 0);
    com.tencent.mm.bb.v.bev();
    this.EnT = com.tencent.mm.bb.r.bes();
    X(false, 2);
    this.EAi = new SnsInfoFlip(this);
    List localList = an.kg(this.yFy, this.EnT);
    this.EAi.setShowTitle(true);
    this.EAi.a(localList, "", i, this.EAd, this);
    this.EAi.setOnPageSelectListener(this);
    addView(this.EAi);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(97716);
        ArtistBrowseUI.this.EAf.ffJ();
        AppMethodBeat.o(97716);
        return true;
      }
    });
    setMMTitle(2131766286);
    showOptionMenu(false);
    this.EAd.setCallBack(new v.a()
    {
      public final void ffk()
      {
        AppMethodBeat.i(97717);
        Object localObject1 = ArtistBrowseUI.this.EAi.getCntMedia();
        if (localObject1 == null)
        {
          AppMethodBeat.o(97717);
          return;
        }
        Log.d("MicroMsg.ArtistBrowseUI", "set bg the meida id " + ((cnb)localObject1).Id);
        Object localObject2 = k.tO(723);
        ((k)localObject2).PH(((cnb)localObject1).Url);
        ((k)localObject2).bfK();
        if (!s.YS(ar.ki(aj.getAccSnsPath(), ((cnb)localObject1).Id) + com.tencent.mm.plugin.sns.data.r.l((cnb)localObject1)))
        {
          AppMethodBeat.o(97717);
          return;
        }
        localObject2 = aj.faK();
        Object localObject3;
        String str;
        if ((((be)localObject2).fau() != null) && (!((be)localObject2).fau().equals("")))
        {
          localObject3 = ar.ki(aj.getAccSnsPath(), ((cnb)localObject1).Id) + com.tencent.mm.plugin.sns.data.r.l((cnb)localObject1);
          str = ar.ki(aj.getAccSnsPath(), ((be)localObject2).fau());
          if (!s.YS((String)localObject3)) {
            break label486;
          }
          Log.d("MicroMsg.UploadManager", "bg file is exist!'");
          s.boN(str);
          s.deleteFile(str + ((be)localObject2).fau() + "bg_");
          s.deleteFile(str + ((be)localObject2).fau() + "tbg_");
          s.nw((String)localObject3, str + ((be)localObject2).fau() + "bg_");
        }
        for (;;)
        {
          localObject3 = aj.faS();
          Object localObject4 = ((be)localObject2).fau();
          str = ((cnb)localObject1).Id;
          localObject4 = ((m)localObject3).aQr((String)localObject4);
          ((l)localObject4).field_bgId = str;
          ((m)localObject3).c((l)localObject4);
          ((be)localObject2).fbT();
          localObject2 = new bf(7);
          ((cnb)localObject1).MsE = 1;
          ((bf)localObject2).DPd.ContentObj.LoV.add(localObject1);
          ((bf)localObject2).YH(2);
          ((bf)localObject2).commit();
          localObject2 = new Intent();
          ((Intent)localObject2).setClass(ArtistBrowseUI.this, SettingSnsBackgroundUI.class);
          ((Intent)localObject2).setFlags(536870912);
          ((Intent)localObject2).addFlags(67108864);
          localObject1 = ArtistBrowseUI.this;
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject2);
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/plugin/sns/ui/ArtistBrowseUI$2", "onSetBgFinish", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((ArtistBrowseUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/sns/ui/ArtistBrowseUI$2", "onSetBgFinish", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ArtistBrowseUI.this.finish();
          AppMethodBeat.o(97717);
          return;
          label486:
          s.deleteFile(str + ((be)localObject2).fau() + "bg_");
          s.deleteFile(str + ((be)localObject2).fau() + "tbg_");
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
    this.EAf.Zu(paramInt1);
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
    aj.faL().aI(this);
    super.onDestroy();
    AppMethodBeat.o(97719);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(97723);
    if (this.EAi != null) {
      this.EAi.onPause();
    }
    super.onPause();
    AppMethodBeat.o(97723);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(97720);
    super.onResume();
    if (this.EAi != null) {
      this.EAi.vu(false);
    }
    AppMethodBeat.o(97720);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ArtistBrowseUI
 * JD-Core Version:    0.7.0.1
 */