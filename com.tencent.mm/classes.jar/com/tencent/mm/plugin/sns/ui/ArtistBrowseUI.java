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
import com.tencent.mm.modelsns.d;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.ba;
import com.tencent.mm.plugin.sns.model.bb;
import com.tencent.mm.plugin.sns.model.f;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.vfs.i;
import java.util.LinkedList;
import java.util.List;

public class ArtistBrowseUI
  extends SnsBaseGalleryUI
  implements u.a
{
  private String tWM = "";
  private String yxd = "";
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(97721);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      ac.d("MicroMsg.ArtistBrowseUI", "dispatchKeyEvent");
      paramKeyEvent = new Intent();
      paramKeyEvent.putExtra("sns_cmd_list", this.yIz.yzV);
      setResult(-1, paramKeyEvent);
      finish();
      AppMethodBeat.o(97721);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(97721);
    return bool;
  }
  
  public final void eI(String paramString, int paramInt)
  {
    AppMethodBeat.i(97724);
    if (this.yIC != null) {
      this.yIC.rn(true);
    }
    AppMethodBeat.o(97724);
  }
  
  public final void eJ(String paramString, int paramInt) {}
  
  public int getLayoutId()
  {
    return 2131495548;
  }
  
  public void initView()
  {
    AppMethodBeat.i(97722);
    setActionbarColor(getResources().getColor(2131100017));
    setNavigationbarColor(getResources().getColor(2131100017));
    this.tWM = getIntent().getStringExtra("sns_gallery_artist_lan");
    int i = getIntent().getIntExtra("sns_gallery_position", 0);
    com.tencent.mm.bb.t.aGO();
    this.yxd = p.aGL();
    Q(false, 2);
    this.yIC = new SnsInfoFlip(this);
    List localList = aj.ja(this.tWM, this.yxd);
    this.yIC.setShowTitle(true);
    this.yIC.a(localList, "", i, this.yIx, this);
    this.yIC.setOnPageSelectListener(this);
    addView(this.yIC);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(97716);
        ArtistBrowseUI.this.yIz.dNw();
        AppMethodBeat.o(97716);
        return true;
      }
    });
    setMMTitle(2131764047);
    showOptionMenu(false);
    this.yIx.setCallBack(new t.a()
    {
      public final void dNd()
      {
        AppMethodBeat.i(97717);
        Object localObject1 = ArtistBrowseUI.this.yIC.getCntMedia();
        if (localObject1 == null)
        {
          AppMethodBeat.o(97717);
          return;
        }
        ac.d("MicroMsg.ArtistBrowseUI", "set bg the meida id " + ((btz)localObject1).Id);
        Object localObject2 = d.ps(723);
        ((d)localObject2).Dn(((btz)localObject1).Url);
        ((d)localObject2).aHZ();
        if (!i.eA(an.jc(af.getAccSnsPath(), ((btz)localObject1).Id) + q.k((btz)localObject1)))
        {
          AppMethodBeat.o(97717);
          return;
        }
        localObject2 = af.dHN();
        Object localObject3;
        String str;
        if ((((ba)localObject2).dHx() != null) && (!((ba)localObject2).dHx().equals("")))
        {
          localObject3 = an.jc(af.getAccSnsPath(), ((btz)localObject1).Id) + q.k((btz)localObject1);
          str = an.jc(af.getAccSnsPath(), ((ba)localObject2).dHx());
          if (!i.eA((String)localObject3)) {
            break label486;
          }
          ac.d("MicroMsg.UploadManager", "bg file is exist!'");
          i.aSh(str);
          i.deleteFile(str + ((ba)localObject2).dHx() + "bg_");
          i.deleteFile(str + ((ba)localObject2).dHx() + "tbg_");
          i.lZ((String)localObject3, str + ((ba)localObject2).dHx() + "bg_");
        }
        for (;;)
        {
          localObject3 = af.dHV();
          Object localObject4 = ((ba)localObject2).dHx();
          str = ((btz)localObject1).Id;
          localObject4 = ((o)localObject3).auY((String)localObject4);
          ((n)localObject4).field_bgId = str;
          ((o)localObject3).c((n)localObject4);
          ((ba)localObject2).dIR();
          localObject2 = new bb(7);
          ((btz)localObject1).Fjn = 1;
          ((bb)localObject2).xXN.FQo.Etz.add(localObject1);
          ((bb)localObject2).Ov(2);
          ((bb)localObject2).commit();
          localObject2 = new Intent();
          ((Intent)localObject2).setClass(ArtistBrowseUI.this, SettingSnsBackgroundUI.class);
          ((Intent)localObject2).setFlags(536870912);
          ((Intent)localObject2).addFlags(67108864);
          localObject1 = ArtistBrowseUI.this;
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject2);
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aeD(), "com/tencent/mm/plugin/sns/ui/ArtistBrowseUI$2", "onSetBgFinish", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((ArtistBrowseUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/sns/ui/ArtistBrowseUI$2", "onSetBgFinish", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ArtistBrowseUI.this.finish();
          AppMethodBeat.o(97717);
          return;
          label486:
          i.deleteFile(str + ((ba)localObject2).dHx() + "bg_");
          i.deleteFile(str + ((ba)localObject2).dHx() + "tbg_");
          ac.e("MicroMsg.UploadManager", "bg file is not exist! wait to down it");
        }
      }
    });
    AppMethodBeat.o(97722);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(97725);
    ac.i("MicroMsg.ArtistBrowseUI", "onAcvityResult requestCode:".concat(String.valueOf(paramInt1)));
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(97725);
      return;
    }
    paramInt1 = paramIntent.getIntExtra("sns_gallery_op_id", 0);
    this.yIz.Pk(paramInt1);
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
    af.dHO().aD(this);
    super.onDestroy();
    AppMethodBeat.o(97719);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(97723);
    if (this.yIC != null) {
      this.yIC.onPause();
    }
    super.onPause();
    AppMethodBeat.o(97723);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(97720);
    super.onResume();
    if (this.yIC != null) {
      this.yIC.rn(false);
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