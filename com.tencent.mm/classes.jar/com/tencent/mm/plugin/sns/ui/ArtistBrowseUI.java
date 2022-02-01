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
import com.tencent.mm.modelsns.d;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.az;
import com.tencent.mm.plugin.sns.model.ba;
import com.tencent.mm.plugin.sns.model.f;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.protocal.protobuf.yk;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.i;
import java.util.LinkedList;
import java.util.List;

public class ArtistBrowseUI
  extends SnsBaseGalleryUI
  implements u.a
{
  private String sOz = "";
  private String xkk = "";
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(97721);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      ad.d("MicroMsg.ArtistBrowseUI", "dispatchKeyEvent");
      paramKeyEvent = new Intent();
      paramKeyEvent.putExtra("sns_cmd_list", this.xvJ.xne);
      setResult(-1, paramKeyEvent);
      finish();
      AppMethodBeat.o(97721);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(97721);
    return bool;
  }
  
  public final void eA(String paramString, int paramInt)
  {
    AppMethodBeat.i(97724);
    if (this.xvM != null) {
      this.xvM.qp(true);
    }
    AppMethodBeat.o(97724);
  }
  
  public final void eB(String paramString, int paramInt) {}
  
  public int getLayoutId()
  {
    return 2131495548;
  }
  
  public void initView()
  {
    AppMethodBeat.i(97722);
    setActionbarColor(getResources().getColor(2131100017));
    setNavigationbarColor(getResources().getColor(2131100017));
    this.sOz = getIntent().getStringExtra("sns_gallery_artist_lan");
    int i = getIntent().getIntExtra("sns_gallery_position", 0);
    com.tencent.mm.bc.t.azY();
    this.xkk = p.azV();
    O(false, 2);
    this.xvM = new SnsInfoFlip(this);
    List localList = aj.iD(this.sOz, this.xkk);
    this.xvM.setShowTitle(true);
    this.xvM.a(localList, "", i, this.xvH, this);
    this.xvM.setOnPageSelectListener(this);
    addView(this.xvM);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(97716);
        ArtistBrowseUI.this.xvJ.dyZ();
        AppMethodBeat.o(97716);
        return true;
      }
    });
    setMMTitle(2131764047);
    showOptionMenu(false);
    this.xvH.setCallBack(new t.a()
    {
      public final void dyG()
      {
        AppMethodBeat.i(97717);
        Object localObject1 = ArtistBrowseUI.this.xvM.getCntMedia();
        if (localObject1 == null)
        {
          AppMethodBeat.o(97717);
          return;
        }
        ad.d("MicroMsg.ArtistBrowseUI", "set bg the meida id " + ((bpi)localObject1).Id);
        Object localObject2 = d.oE(723);
        ((d)localObject2).zi(((bpi)localObject1).Url);
        ((d)localObject2).aBj();
        if (!i.eK(an.iF(af.getAccSnsPath(), ((bpi)localObject1).Id) + q.k((bpi)localObject1)))
        {
          AppMethodBeat.o(97717);
          return;
        }
        localObject2 = af.dtq();
        Object localObject3;
        String str;
        if ((((az)localObject2).dta() != null) && (!((az)localObject2).dta().equals("")))
        {
          localObject3 = an.iF(af.getAccSnsPath(), ((bpi)localObject1).Id) + q.k((bpi)localObject1);
          str = an.iF(af.getAccSnsPath(), ((az)localObject2).dta());
          if (!i.eK((String)localObject3)) {
            break label486;
          }
          ad.d("MicroMsg.UploadManager", "bg file is exist!'");
          i.aMF(str);
          i.deleteFile(str + ((az)localObject2).dta() + "bg_");
          i.deleteFile(str + ((az)localObject2).dta() + "tbg_");
          i.lC((String)localObject3, str + ((az)localObject2).dta() + "bg_");
        }
        for (;;)
        {
          localObject3 = af.dty();
          Object localObject4 = ((az)localObject2).dta();
          str = ((bpi)localObject1).Id;
          localObject4 = ((o)localObject3).apP((String)localObject4);
          ((n)localObject4).field_bgId = str;
          ((o)localObject3).c((n)localObject4);
          ((az)localObject2).dur();
          localObject2 = new ba(7);
          ((bpi)localObject1).DMW = 1;
          ((ba)localObject2).wLh.Etm.DaC.add(localObject1);
          ((ba)localObject2).Mt(2);
          ((ba)localObject2).commit();
          localObject2 = new Intent();
          ((Intent)localObject2).setClass(ArtistBrowseUI.this, SettingSnsBackgroundUI.class);
          ((Intent)localObject2).setFlags(536870912);
          ((Intent)localObject2).addFlags(67108864);
          localObject1 = ArtistBrowseUI.this;
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject2);
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).adn(), "com/tencent/mm/plugin/sns/ui/ArtistBrowseUI$2", "onSetBgFinish", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((ArtistBrowseUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/sns/ui/ArtistBrowseUI$2", "onSetBgFinish", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ArtistBrowseUI.this.finish();
          AppMethodBeat.o(97717);
          return;
          label486:
          i.deleteFile(str + ((az)localObject2).dta() + "bg_");
          i.deleteFile(str + ((az)localObject2).dta() + "tbg_");
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
    this.xvJ.Nh(paramInt1);
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
    af.dtr().az(this);
    super.onDestroy();
    AppMethodBeat.o(97719);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(97723);
    if (this.xvM != null) {
      this.xvM.onPause();
    }
    super.onPause();
    AppMethodBeat.o(97723);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(97720);
    super.onResume();
    if (this.xvM != null) {
      this.xvM.qp(false);
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