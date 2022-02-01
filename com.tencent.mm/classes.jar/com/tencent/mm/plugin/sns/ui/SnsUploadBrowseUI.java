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
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class SnsUploadBrowseUI
  extends SnsBaseGalleryUI
  implements v.a
{
  private HashMap<Integer, Boolean> AFA;
  private ArrayList<String> AFz;
  private int Arq;
  
  public SnsUploadBrowseUI()
  {
    AppMethodBeat.i(99509);
    this.AFz = new ArrayList();
    this.Arq = 0;
    this.AFA = new HashMap();
    AppMethodBeat.o(99509);
  }
  
  public final void a(bzh parambzh, int paramInt, String paramString)
  {
    AppMethodBeat.i(99517);
    super.a(parambzh, paramInt, paramString);
    this.AFA.put(Integer.valueOf(paramInt), Boolean.TRUE);
    AppMethodBeat.o(99517);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(99515);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      ae.d("MicroMsg.SnsUploadBrowseUI", "dispatchKeyEvent");
      eha();
      AppMethodBeat.o(99515);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(99515);
    return bool;
  }
  
  public final void eha()
  {
    AppMethodBeat.i(99514);
    Intent localIntent = new Intent();
    Object localObject = this.Arj.getFlipList();
    if (localObject == null)
    {
      AppMethodBeat.o(99514);
      return;
    }
    this.AFz.clear();
    Iterator localIterator = ((List)localObject).iterator();
    if (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      localObject = ah.getAccSnsTmpPath() + localb.dKe.Id;
      if (!localb.dKe.Id.startsWith("pre_temp_extend_pic")) {
        break label183;
      }
      localObject = localb.dKe.Id.substring(19);
    }
    label183:
    for (;;)
    {
      this.AFz.add(localObject);
      break;
      localIntent.putExtra("sns_gallery_temp_paths", this.AFz);
      localIntent.putExtra("sns_update_preview_image_count", this.AFA.size());
      this.AFA.clear();
      setResult(-1, localIntent);
      finish();
      AppMethodBeat.o(99514);
      return;
    }
  }
  
  public final void fj(String paramString, int paramInt)
  {
    AppMethodBeat.i(99518);
    if (this.Arj != null) {
      this.Arj.rY(true);
    }
    AppMethodBeat.o(99518);
  }
  
  public final void fk(String paramString, int paramInt) {}
  
  public int getLayoutId()
  {
    return 2131495531;
  }
  
  public void initView()
  {
    AppMethodBeat.i(99516);
    String str = bu.bI(getIntent().getStringExtra("sns_gallery_userName"), "");
    this.AFz = getIntent().getStringArrayListExtra("sns_gallery_temp_paths");
    if (this.AFz == null)
    {
      AppMethodBeat.o(99516);
      return;
    }
    this.Arq = getIntent().getIntExtra("sns_gallery_position", 0);
    this.Arj = new SnsInfoFlip(this);
    this.Arj.setEnableHorLongBmpMode(false);
    this.Arj.setShowTitle(true);
    ah.getAccSnsTmpPath();
    List localList = al.fT(this.AFz);
    this.Arj.a(localList, str, this.Arq, this.Are, this);
    this.Arj.setOnPageSelectListener(this);
    addView(this.Arj);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(99506);
        SnsUploadBrowseUI.this.eha();
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
            if (SnsUploadBrowseUI.this.Arj.efH() == 0) {
              SnsUploadBrowseUI.this.eha();
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
    ae.i("MicroMsg.SnsUploadBrowseUI", "onAcvityResult requestCode:".concat(String.valueOf(paramInt1)));
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
    ah.dXB().aE(this);
    super.onDestroy();
    AppMethodBeat.o(99511);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(99513);
    if (this.Arj != null) {
      this.Arj.onPause();
    }
    super.onPause();
    AppMethodBeat.o(99513);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(99512);
    super.onResume();
    if (this.Arj != null) {
      this.Arj.rY(false);
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