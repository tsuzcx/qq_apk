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
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.f;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class SnsUploadBrowseUI
  extends SnsBaseGalleryUI
  implements u.a
{
  private int yIJ;
  private ArrayList<String> yWC;
  private HashMap<Integer, Boolean> yWD;
  
  public SnsUploadBrowseUI()
  {
    AppMethodBeat.i(99509);
    this.yWC = new ArrayList();
    this.yIJ = 0;
    this.yWD = new HashMap();
    AppMethodBeat.o(99509);
  }
  
  public final void a(btz parambtz, int paramInt, String paramString)
  {
    AppMethodBeat.i(99517);
    super.a(parambtz, paramInt, paramString);
    this.yWD.put(Integer.valueOf(paramInt), Boolean.TRUE);
    AppMethodBeat.o(99517);
  }
  
  public final void dRb()
  {
    AppMethodBeat.i(99514);
    Intent localIntent = new Intent();
    Object localObject = this.yIC.getFlipList();
    if (localObject == null)
    {
      AppMethodBeat.o(99514);
      return;
    }
    this.yWC.clear();
    Iterator localIterator = ((List)localObject).iterator();
    if (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      localObject = af.getAccSnsTmpPath() + localb.dwE.Id;
      if (!localb.dwE.Id.startsWith("pre_temp_extend_pic")) {
        break label183;
      }
      localObject = localb.dwE.Id.substring(19);
    }
    label183:
    for (;;)
    {
      this.yWC.add(localObject);
      break;
      localIntent.putExtra("sns_gallery_temp_paths", this.yWC);
      localIntent.putExtra("sns_update_preview_image_count", this.yWD.size());
      this.yWD.clear();
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
      ac.d("MicroMsg.SnsUploadBrowseUI", "dispatchKeyEvent");
      dRb();
      AppMethodBeat.o(99515);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(99515);
    return bool;
  }
  
  public final void eI(String paramString, int paramInt)
  {
    AppMethodBeat.i(99518);
    if (this.yIC != null) {
      this.yIC.rn(true);
    }
    AppMethodBeat.o(99518);
  }
  
  public final void eJ(String paramString, int paramInt) {}
  
  public int getLayoutId()
  {
    return 2131495531;
  }
  
  public void initView()
  {
    AppMethodBeat.i(99516);
    String str = bs.bG(getIntent().getStringExtra("sns_gallery_userName"), "");
    this.yWC = getIntent().getStringArrayListExtra("sns_gallery_temp_paths");
    if (this.yWC == null)
    {
      AppMethodBeat.o(99516);
      return;
    }
    this.yIJ = getIntent().getIntExtra("sns_gallery_position", 0);
    this.yIC = new SnsInfoFlip(this);
    this.yIC.setEnableHorLongBmpMode(false);
    this.yIC.setShowTitle(true);
    af.getAccSnsTmpPath();
    List localList = aj.fx(this.yWC);
    this.yIC.a(localList, str, this.yIJ, this.yIx, this);
    this.yIC.setOnPageSelectListener(this);
    addView(this.yIC);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(99506);
        SnsUploadBrowseUI.this.dRb();
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
            if (SnsUploadBrowseUI.this.yIC.dPJ() == 0) {
              SnsUploadBrowseUI.this.dRb();
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
    ac.i("MicroMsg.SnsUploadBrowseUI", "onAcvityResult requestCode:".concat(String.valueOf(paramInt1)));
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
    af.dHO().aD(this);
    super.onDestroy();
    AppMethodBeat.o(99511);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(99513);
    if (this.yIC != null) {
      this.yIC.onPause();
    }
    super.onPause();
    AppMethodBeat.o(99513);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(99512);
    super.onResume();
    if (this.yIC != null) {
      this.yIC.rn(false);
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