package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.comm.b.c;
import com.tencent.mm.plugin.comm.b.e;
import com.tencent.mm.plugin.comm.b.e.a;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.protocal.protobuf.bzi;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class SnsUploadBrowseUI
  extends SnsBaseGalleryUI
  implements z.a
{
  private ArrayList<String> RDj;
  private HashMap<Integer, Boolean> RDk;
  private int RnZ;
  
  public SnsUploadBrowseUI()
  {
    AppMethodBeat.i(99509);
    this.RDj = new ArrayList();
    this.RnZ = 0;
    this.RDk = new HashMap();
    AppMethodBeat.o(99509);
  }
  
  public final void a(dmz paramdmz, int paramInt, String paramString)
  {
    AppMethodBeat.i(99517);
    super.a(paramdmz, paramInt, paramString);
    this.RDk.put(Integer.valueOf(paramInt), Boolean.TRUE);
    AppMethodBeat.o(99517);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(99515);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      Log.d("MicroMsg.SnsUploadBrowseUI", "dispatchKeyEvent");
      hqk();
      AppMethodBeat.o(99515);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(99515);
    return bool;
  }
  
  public int getLayoutId()
  {
    return b.g.sns_browse_img;
  }
  
  public final void hf(String paramString, int paramInt)
  {
    AppMethodBeat.i(99518);
    if (this.RnH != null) {
      this.RnH.Ei(true);
    }
    AppMethodBeat.o(99518);
  }
  
  public final void hg(String paramString, int paramInt) {}
  
  public final void hqk()
  {
    AppMethodBeat.i(99514);
    Intent localIntent = new Intent();
    Object localObject = this.RnH.getFlipList();
    if (localObject == null)
    {
      AppMethodBeat.o(99514);
      return;
    }
    this.RDj.clear();
    Iterator localIterator = ((List)localObject).iterator();
    if (localIterator.hasNext())
    {
      bzi localbzi = (bzi)localIterator.next();
      localObject = al.getAccSnsTmpPath() + localbzi.ibT.Id;
      if (!localbzi.ibT.Id.startsWith("pre_temp_extend_pic")) {
        break label183;
      }
      localObject = localbzi.ibT.Id.substring(19);
    }
    label183:
    for (;;)
    {
      this.RDj.add(localObject);
      break;
      localIntent.putExtra("sns_gallery_temp_paths", this.RDj);
      localIntent.putExtra("sns_update_preview_image_count", this.RDk.size());
      this.RDk.clear();
      setResult(-1, localIntent);
      finish();
      AppMethodBeat.o(99514);
      return;
    }
  }
  
  public void initView()
  {
    AppMethodBeat.i(99516);
    boolean bool = getIntent().getBooleanExtra("k_need_delete", true);
    String str = Util.nullAs(getIntent().getStringExtra("sns_gallery_userName"), "");
    this.RDj = getIntent().getStringArrayListExtra("sns_gallery_temp_paths");
    if (this.RDj == null)
    {
      AppMethodBeat.o(99516);
      return;
    }
    this.RnZ = getIntent().getIntExtra("sns_gallery_position", 0);
    this.RnH = new SnsInfoFlip(this);
    this.RnH.setEnableHorLongBmpMode(false);
    this.RnH.setShowTitle(true);
    al.getAccSnsTmpPath();
    List localList = ap.kA(this.RDj);
    this.RnH.a(localList, str, this.RnZ, this.RnC, this);
    this.RnH.setOnPageSelectListener(this);
    addView(this.RnH);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(99506);
        SnsUploadBrowseUI.this.hqk();
        AppMethodBeat.o(99506);
        return true;
      }
    });
    if (bool) {
      addIconOptionMenu(0, b.j.app_delete, b.i.icons_outlined_delete, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(99508);
          k.a(SnsUploadBrowseUI.this, b.j.sns_gallery_del, b.j.app_tip, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(99507);
              if (SnsUploadBrowseUI.this.RnH.hoK() == 0) {
                SnsUploadBrowseUI.this.hqk();
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
    }
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
    aw.bW(this);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(99510);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(99511);
    al.hgy().bq(this);
    super.onDestroy();
    e.xfd.a("SnsPublishProcess", "mediaPreviewPageStaytime_", Long.valueOf(getActivityBrowseTimeMs()), c.xeT);
    AppMethodBeat.o(99511);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(99513);
    if (this.RnH != null) {
      this.RnH.onPause();
    }
    super.onPause();
    AppMethodBeat.o(99513);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(99512);
    super.onResume();
    if (this.RnH != null) {
      this.RnH.Ei(false);
    }
    AppMethodBeat.o(99512);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadBrowseUI
 * JD-Core Version:    0.7.0.1
 */