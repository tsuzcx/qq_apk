package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.j.b;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.f;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class SnsUploadBrowseUI
  extends SnsBaseGalleryUI
  implements u.a
{
  private ArrayList<String> xJM;
  private HashMap<Integer, Boolean> xJN;
  private int xvT;
  
  public SnsUploadBrowseUI()
  {
    AppMethodBeat.i(99509);
    this.xJM = new ArrayList();
    this.xvT = 0;
    this.xJN = new HashMap();
    AppMethodBeat.o(99509);
  }
  
  public final void a(bpi parambpi, int paramInt, String paramString)
  {
    AppMethodBeat.i(99517);
    super.a(parambpi, paramInt, paramString);
    this.xJN.put(Integer.valueOf(paramInt), Boolean.TRUE);
    AppMethodBeat.o(99517);
  }
  
  public final void dCE()
  {
    AppMethodBeat.i(99514);
    Intent localIntent = new Intent();
    Object localObject = this.xvM.getFlipList();
    if (localObject == null)
    {
      AppMethodBeat.o(99514);
      return;
    }
    this.xJM.clear();
    Iterator localIterator = ((List)localObject).iterator();
    if (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      localObject = af.getAccSnsTmpPath() + localb.dyS.Id;
      if (!localb.dyS.Id.startsWith("pre_temp_extend_pic")) {
        break label183;
      }
      localObject = localb.dyS.Id.substring(19);
    }
    label183:
    for (;;)
    {
      this.xJM.add(localObject);
      break;
      localIntent.putExtra("sns_gallery_temp_paths", this.xJM);
      localIntent.putExtra("sns_update_preview_image_count", this.xJN.size());
      this.xJN.clear();
      setResult(-1, localIntent);
      finish();
      AppMethodBeat.o(99514);
      return;
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(99515);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      ad.d("MicroMsg.SnsUploadBrowseUI", "dispatchKeyEvent");
      dCE();
      AppMethodBeat.o(99515);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(99515);
    return bool;
  }
  
  public final void eA(String paramString, int paramInt)
  {
    AppMethodBeat.i(99518);
    if (this.xvM != null) {
      this.xvM.qp(true);
    }
    AppMethodBeat.o(99518);
  }
  
  public final void eB(String paramString, int paramInt) {}
  
  public int getLayoutId()
  {
    return 2131495531;
  }
  
  public void initView()
  {
    AppMethodBeat.i(99516);
    String str = bt.by(getIntent().getStringExtra("sns_gallery_userName"), "");
    this.xJM = getIntent().getStringArrayListExtra("sns_gallery_temp_paths");
    if (this.xJM == null)
    {
      AppMethodBeat.o(99516);
      return;
    }
    this.xvT = getIntent().getIntExtra("sns_gallery_position", 0);
    this.xvM = new SnsInfoFlip(this);
    this.xvM.setEnableHorLongBmpMode(false);
    this.xvM.setShowTitle(true);
    af.getAccSnsTmpPath();
    List localList = aj.fp(this.xJM);
    this.xvM.a(localList, str, this.xvT, this.xvH, this);
    this.xvM.setOnPageSelectListener(this);
    addView(this.xvM);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(99506);
        SnsUploadBrowseUI.this.dCE();
        AppMethodBeat.o(99506);
        return true;
      }
    });
    addIconOptionMenu(0, 2131755707, 2131690551, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(99508);
        h.a(SnsUploadBrowseUI.this, 2131763834, 2131755906, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(99507);
            if (SnsUploadBrowseUI.this.xvM.dBm() == 0) {
              SnsUploadBrowseUI.this.dCE();
            }
            AppMethodBeat.o(99507);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
        });
        AppMethodBeat.o(99508);
        return true;
      }
    });
    AppMethodBeat.o(99516);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(99519);
    ad.i("MicroMsg.SnsUploadBrowseUI", "onAcvityResult requestCode:".concat(String.valueOf(paramInt1)));
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(99519);
      return;
    }
    AppMethodBeat.o(99519);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(99510);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(99510);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(99511);
    af.dtr().az(this);
    super.onDestroy();
    AppMethodBeat.o(99511);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(99513);
    if (this.xvM != null) {
      this.xvM.onPause();
    }
    super.onPause();
    AppMethodBeat.o(99513);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(99512);
    super.onResume();
    if (this.xvM != null) {
      this.xvM.qp(false);
    }
    AppMethodBeat.o(99512);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadBrowseUI
 * JD-Core Version:    0.7.0.1
 */