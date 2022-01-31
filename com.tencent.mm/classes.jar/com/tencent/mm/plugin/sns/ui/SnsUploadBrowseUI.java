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
import com.tencent.mm.plugin.sns.h.b;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ak;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class SnsUploadBrowseUI
  extends SnsBaseGalleryUI
  implements s.a
{
  private int rNV;
  private ArrayList<String> sbj;
  private HashMap<Integer, Boolean> sbk;
  
  public SnsUploadBrowseUI()
  {
    AppMethodBeat.i(39680);
    this.sbj = new ArrayList();
    this.rNV = 0;
    this.sbk = new HashMap();
    AppMethodBeat.o(39680);
  }
  
  public final void cwv()
  {
    AppMethodBeat.i(39685);
    Intent localIntent = new Intent();
    Object localObject = this.rNT.getFlipList();
    if (localObject == null)
    {
      AppMethodBeat.o(39685);
      return;
    }
    this.sbj.clear();
    Iterator localIterator = ((List)localObject).iterator();
    if (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      localObject = ag.getAccSnsTmpPath() + localb.cIc.Id;
      if (!localb.cIc.Id.startsWith("pre_temp_extend_pic")) {
        break label183;
      }
      localObject = localb.cIc.Id.substring(19);
    }
    label183:
    for (;;)
    {
      this.sbj.add(localObject);
      break;
      localIntent.putExtra("sns_gallery_temp_paths", this.sbj);
      localIntent.putExtra("sns_update_preview_image_count", this.sbk.size());
      this.sbk.clear();
      setResult(-1, localIntent);
      finish();
      AppMethodBeat.o(39685);
      return;
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(39686);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      ab.d("MicroMsg.SnsUploadBrowseUI", "dispatchKeyEvent");
      cwv();
      AppMethodBeat.o(39686);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(39686);
    return bool;
  }
  
  public final void ds(String paramString, int paramInt)
  {
    AppMethodBeat.i(39688);
    if (this.rNT != null) {
      this.rNT.bvl();
    }
    AppMethodBeat.o(39688);
  }
  
  public final void dt(String paramString, int paramInt) {}
  
  public int getLayoutId()
  {
    return 2130970810;
  }
  
  public void initView()
  {
    AppMethodBeat.i(39687);
    String str = bo.bf(getIntent().getStringExtra("sns_gallery_userName"), "");
    this.sbj = getIntent().getStringArrayListExtra("sns_gallery_temp_paths");
    if (this.sbj == null)
    {
      AppMethodBeat.o(39687);
      return;
    }
    this.rNV = getIntent().getIntExtra("sns_gallery_position", 0);
    this.rNT = new SnsInfoFlip(this);
    this.rNT.setEnableHorLongBmpMode(false);
    this.rNT.setShowTitle(true);
    ag.getAccSnsTmpPath();
    List localList = ak.db(this.sbj);
    this.rNT.a(localList, str, this.rNV, this.rNO, this);
    this.rNT.setOnPageSelectListener(new SnsUploadBrowseUI.1(this));
    addView(this.rNT);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(39677);
        SnsUploadBrowseUI.this.cwv();
        AppMethodBeat.o(39677);
        return true;
      }
    });
    addIconOptionMenu(0, 2131296901, 2131231500, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(39679);
        h.a(SnsUploadBrowseUI.this, 2131303825, 2131297087, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(39678);
            if (SnsUploadBrowseUI.this.rNT.cvm() == 0) {
              SnsUploadBrowseUI.this.cwv();
            }
            AppMethodBeat.o(39678);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
        });
        AppMethodBeat.o(39679);
        return true;
      }
    });
    AppMethodBeat.o(39687);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(39689);
    ab.i("MicroMsg.SnsUploadBrowseUI", "onAcvityResult requestCode:".concat(String.valueOf(paramInt1)));
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(39689);
      return;
    }
    AppMethodBeat.o(39689);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(39681);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(39681);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(39682);
    if (this.rNT != null)
    {
      this.rNT.cvl();
      this.rNT.onDestroy();
    }
    ag.cpc().ah(this);
    super.onDestroy();
    AppMethodBeat.o(39682);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(39684);
    if (this.rNT != null) {
      this.rNT.onPause();
    }
    super.onPause();
    AppMethodBeat.o(39684);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(39683);
    super.onResume();
    if (this.rNT != null) {
      this.rNT.bvl();
    }
    AppMethodBeat.o(39683);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadBrowseUI
 * JD-Core Version:    0.7.0.1
 */