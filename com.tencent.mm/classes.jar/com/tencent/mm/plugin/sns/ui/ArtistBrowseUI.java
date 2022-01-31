package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ba.n;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ak;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.List;

public class ArtistBrowseUI
  extends SnsBaseGalleryUI
  implements s.a
{
  private String nZZ = "";
  private String rEA = "";
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(38100);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      ab.d("MicroMsg.ArtistBrowseUI", "dispatchKeyEvent");
      paramKeyEvent = new Intent();
      paramKeyEvent.putExtra("sns_cmd_list", this.rNP.rHi);
      setResult(-1, paramKeyEvent);
      finish();
      AppMethodBeat.o(38100);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(38100);
    return bool;
  }
  
  public final void ds(String paramString, int paramInt)
  {
    AppMethodBeat.i(38103);
    if (this.rNT != null) {
      this.rNT.bvl();
    }
    AppMethodBeat.o(38103);
  }
  
  public final void dt(String paramString, int paramInt) {}
  
  public int getLayoutId()
  {
    return 2130970825;
  }
  
  public void initView()
  {
    AppMethodBeat.i(38101);
    this.nZZ = getIntent().getStringExtra("sns_gallery_artist_lan");
    int i = getIntent().getIntExtra("sns_gallery_position", 0);
    com.tencent.mm.ba.r.aiP();
    this.rEA = n.aiM();
    E(false, 2);
    this.rNT = new SnsInfoFlip(this);
    List localList = ak.gk(this.nZZ, this.rEA);
    this.rNT.setShowTitle(true);
    this.rNT.a(localList, "", i, this.rNO, this);
    addView(this.rNT);
    setBackBtn(new ArtistBrowseUI.1(this));
    setMMTitle(2131304030);
    showOptionMenu(false);
    this.rNO.setCallBack(new ArtistBrowseUI.2(this));
    AppMethodBeat.o(38101);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(38104);
    ab.i("MicroMsg.ArtistBrowseUI", "onAcvityResult requestCode:".concat(String.valueOf(paramInt1)));
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(38104);
      return;
    }
    paramInt1 = paramIntent.getIntExtra("sns_gallery_op_id", 0);
    this.rNP.EC(paramInt1);
    AppMethodBeat.o(38104);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(38097);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(38097);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(38098);
    if (this.rNT != null)
    {
      this.rNT.cvl();
      this.rNT.onDestroy();
    }
    ag.cpc().ah(this);
    super.onDestroy();
    AppMethodBeat.o(38098);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(38102);
    if (this.rNT != null) {
      this.rNT.onPause();
    }
    super.onPause();
    AppMethodBeat.o(38102);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(38099);
    super.onResume();
    if (this.rNT != null) {
      this.rNT.bvl();
    }
    AppMethodBeat.o(38099);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ArtistBrowseUI
 * JD-Core Version:    0.7.0.1
 */