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
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class SnsUploadBrowseUI
  extends SnsBaseGalleryUI
  implements w.a
{
  private int EAu;
  private ArrayList<String> EPf;
  private HashMap<Integer, Boolean> EPg;
  
  public SnsUploadBrowseUI()
  {
    AppMethodBeat.i(99509);
    this.EPf = new ArrayList();
    this.EAu = 0;
    this.EPg = new HashMap();
    AppMethodBeat.o(99509);
  }
  
  public final void a(cnb paramcnb, int paramInt, String paramString)
  {
    AppMethodBeat.i(99517);
    super.a(paramcnb, paramInt, paramString);
    this.EPg.put(Integer.valueOf(paramInt), Boolean.TRUE);
    AppMethodBeat.o(99517);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(99515);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      Log.d("MicroMsg.SnsUploadBrowseUI", "dispatchKeyEvent");
      fjC();
      AppMethodBeat.o(99515);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(99515);
    return bool;
  }
  
  public final void fH(String paramString, int paramInt)
  {
    AppMethodBeat.i(99518);
    if (this.EAi != null) {
      this.EAi.vu(true);
    }
    AppMethodBeat.o(99518);
  }
  
  public final void fI(String paramString, int paramInt) {}
  
  public final void fjC()
  {
    AppMethodBeat.i(99514);
    Intent localIntent = new Intent();
    Object localObject = this.EAi.getFlipList();
    if (localObject == null)
    {
      AppMethodBeat.o(99514);
      return;
    }
    this.EPf.clear();
    Iterator localIterator = ((List)localObject).iterator();
    if (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      localObject = aj.getAccSnsTmpPath() + localb.ebR.Id;
      if (!localb.ebR.Id.startsWith("pre_temp_extend_pic")) {
        break label183;
      }
      localObject = localb.ebR.Id.substring(19);
    }
    label183:
    for (;;)
    {
      this.EPf.add(localObject);
      break;
      localIntent.putExtra("sns_gallery_temp_paths", this.EPf);
      localIntent.putExtra("sns_update_preview_image_count", this.EPg.size());
      this.EPg.clear();
      setResult(-1, localIntent);
      finish();
      AppMethodBeat.o(99514);
      return;
    }
  }
  
  public int getLayoutId()
  {
    return 2131496419;
  }
  
  public void initView()
  {
    AppMethodBeat.i(99516);
    String str = Util.nullAs(getIntent().getStringExtra("sns_gallery_userName"), "");
    this.EPf = getIntent().getStringArrayListExtra("sns_gallery_temp_paths");
    if (this.EPf == null)
    {
      AppMethodBeat.o(99516);
      return;
    }
    this.EAu = getIntent().getIntExtra("sns_gallery_position", 0);
    this.EAi = new SnsInfoFlip(this);
    this.EAi.setEnableHorLongBmpMode(false);
    this.EAi.setShowTitle(true);
    aj.getAccSnsTmpPath();
    List localList = an.gQ(this.EPf);
    this.EAi.a(localList, str, this.EAu, this.EAd, this);
    this.EAi.setOnPageSelectListener(this);
    addView(this.EAi);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(99506);
        SnsUploadBrowseUI.this.fjC();
        AppMethodBeat.o(99506);
        return true;
      }
    });
    addIconOptionMenu(0, 2131755778, 2131690780, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(99508);
        h.a(SnsUploadBrowseUI.this, 2131766060, 2131755998, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(99507);
            if (SnsUploadBrowseUI.this.EAi.fih() == 0) {
              SnsUploadBrowseUI.this.fjC();
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
    Log.i("MicroMsg.SnsUploadBrowseUI", "onAcvityResult requestCode:".concat(String.valueOf(paramInt1)));
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
    ao.bm(this);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(99510);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(99511);
    aj.faL().aI(this);
    super.onDestroy();
    AppMethodBeat.o(99511);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(99513);
    if (this.EAi != null) {
      this.EAi.onPause();
    }
    super.onPause();
    AppMethodBeat.o(99513);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(99512);
    super.onResume();
    if (this.EAi != null) {
      this.EAi.vu(false);
    }
    AppMethodBeat.o(99512);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadBrowseUI
 * JD-Core Version:    0.7.0.1
 */