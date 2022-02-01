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
import com.tencent.mm.plugin.sns.i.b;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ak;
import com.tencent.mm.plugin.sns.model.f;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class SnsUploadBrowseUI
  extends SnsBaseGalleryUI
  implements v.a
{
  private int Aad;
  private ArrayList<String> Aom;
  private HashMap<Integer, Boolean> Aon;
  
  public SnsUploadBrowseUI()
  {
    AppMethodBeat.i(99509);
    this.Aom = new ArrayList();
    this.Aad = 0;
    this.Aon = new HashMap();
    AppMethodBeat.o(99509);
  }
  
  public final void a(byn parambyn, int paramInt, String paramString)
  {
    AppMethodBeat.i(99517);
    super.a(parambyn, paramInt, paramString);
    this.Aon.put(Integer.valueOf(paramInt), Boolean.TRUE);
    AppMethodBeat.o(99517);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(99515);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      ad.d("MicroMsg.SnsUploadBrowseUI", "dispatchKeyEvent");
      edt();
      AppMethodBeat.o(99515);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(99515);
    return bool;
  }
  
  public final void edt()
  {
    AppMethodBeat.i(99514);
    Intent localIntent = new Intent();
    Object localObject = this.zZW.getFlipList();
    if (localObject == null)
    {
      AppMethodBeat.o(99514);
      return;
    }
    this.Aom.clear();
    Iterator localIterator = ((List)localObject).iterator();
    if (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      localObject = ag.getAccSnsTmpPath() + localb.dIQ.Id;
      if (!localb.dIQ.Id.startsWith("pre_temp_extend_pic")) {
        break label183;
      }
      localObject = localb.dIQ.Id.substring(19);
    }
    label183:
    for (;;)
    {
      this.Aom.add(localObject);
      break;
      localIntent.putExtra("sns_gallery_temp_paths", this.Aom);
      localIntent.putExtra("sns_update_preview_image_count", this.Aon.size());
      this.Aon.clear();
      setResult(-1, localIntent);
      finish();
      AppMethodBeat.o(99514);
      return;
    }
  }
  
  public final void fa(String paramString, int paramInt)
  {
    AppMethodBeat.i(99518);
    if (this.zZW != null) {
      this.zZW.rR(true);
    }
    AppMethodBeat.o(99518);
  }
  
  public final void fb(String paramString, int paramInt) {}
  
  public int getLayoutId()
  {
    return 2131495531;
  }
  
  public void initView()
  {
    AppMethodBeat.i(99516);
    String str = bt.bI(getIntent().getStringExtra("sns_gallery_userName"), "");
    this.Aom = getIntent().getStringArrayListExtra("sns_gallery_temp_paths");
    if (this.Aom == null)
    {
      AppMethodBeat.o(99516);
      return;
    }
    this.Aad = getIntent().getIntExtra("sns_gallery_position", 0);
    this.zZW = new SnsInfoFlip(this);
    this.zZW.setEnableHorLongBmpMode(false);
    this.zZW.setShowTitle(true);
    ag.getAccSnsTmpPath();
    List localList = ak.fK(this.Aom);
    this.zZW.a(localList, str, this.Aad, this.zZR, this);
    this.zZW.setOnPageSelectListener(this);
    addView(this.zZW);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(99506);
        SnsUploadBrowseUI.this.edt();
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
            if (SnsUploadBrowseUI.this.zZW.eca() == 0) {
              SnsUploadBrowseUI.this.edt();
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
    ag.dUb().aD(this);
    super.onDestroy();
    AppMethodBeat.o(99511);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(99513);
    if (this.zZW != null) {
      this.zZW.onPause();
    }
    super.onPause();
    AppMethodBeat.o(99513);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(99512);
    super.onResume();
    if (this.zZW != null) {
      this.zZW.rR(false);
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