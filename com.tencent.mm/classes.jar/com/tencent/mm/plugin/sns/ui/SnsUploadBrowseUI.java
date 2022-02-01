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
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.j.b;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class SnsUploadBrowseUI
  extends SnsBaseGalleryUI
  implements y.a
{
  private int KOm;
  private ArrayList<String> Lda;
  private HashMap<Integer, Boolean> Ldb;
  
  public SnsUploadBrowseUI()
  {
    AppMethodBeat.i(99509);
    this.Lda = new ArrayList();
    this.KOm = 0;
    this.Ldb = new HashMap();
    AppMethodBeat.o(99509);
  }
  
  public final void a(cvt paramcvt, int paramInt, String paramString)
  {
    AppMethodBeat.i(99517);
    super.a(paramcvt, paramInt, paramString);
    this.Ldb.put(Integer.valueOf(paramInt), Boolean.TRUE);
    AppMethodBeat.o(99517);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(99515);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      Log.d("MicroMsg.SnsUploadBrowseUI", "dispatchKeyEvent");
      fXP();
      AppMethodBeat.o(99515);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(99515);
    return bool;
  }
  
  public final void fXP()
  {
    AppMethodBeat.i(99514);
    Intent localIntent = new Intent();
    Object localObject = this.KNW.getFlipList();
    if (localObject == null)
    {
      AppMethodBeat.o(99514);
      return;
    }
    this.Lda.clear();
    Iterator localIterator = ((List)localObject).iterator();
    if (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      localObject = aj.getAccSnsTmpPath() + localb.fVT.Id;
      if (!localb.fVT.Id.startsWith("pre_temp_extend_pic")) {
        break label183;
      }
      localObject = localb.fVT.Id.substring(19);
    }
    label183:
    for (;;)
    {
      this.Lda.add(localObject);
      break;
      localIntent.putExtra("sns_gallery_temp_paths", this.Lda);
      localIntent.putExtra("sns_update_preview_image_count", this.Ldb.size());
      this.Ldb.clear();
      setResult(-1, localIntent);
      finish();
      AppMethodBeat.o(99514);
      return;
    }
  }
  
  public int getLayoutId()
  {
    return i.g.sns_browse_img;
  }
  
  public final void gl(String paramString, int paramInt)
  {
    AppMethodBeat.i(99518);
    if (this.KNW != null) {
      this.KNW.yY(true);
    }
    AppMethodBeat.o(99518);
  }
  
  public final void gm(String paramString, int paramInt) {}
  
  public void initView()
  {
    AppMethodBeat.i(99516);
    boolean bool = getIntent().getBooleanExtra("k_need_delete", true);
    String str = Util.nullAs(getIntent().getStringExtra("sns_gallery_userName"), "");
    this.Lda = getIntent().getStringArrayListExtra("sns_gallery_temp_paths");
    if (this.Lda == null)
    {
      AppMethodBeat.o(99516);
      return;
    }
    this.KOm = getIntent().getIntExtra("sns_gallery_position", 0);
    this.KNW = new SnsInfoFlip(this);
    this.KNW.setEnableHorLongBmpMode(false);
    this.KNW.setShowTitle(true);
    aj.getAccSnsTmpPath();
    List localList = an.hz(this.Lda);
    this.KNW.a(localList, str, this.KOm, this.KNR, this);
    this.KNW.setOnPageSelectListener(this);
    addView(this.KNW);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(99506);
        SnsUploadBrowseUI.this.fXP();
        AppMethodBeat.o(99506);
        return true;
      }
    });
    if (bool) {
      addIconOptionMenu(0, i.j.app_delete, i.i.icons_outlined_delete, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(99508);
          h.a(SnsUploadBrowseUI.this, i.j.sns_gallery_del, i.j.app_tip, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(99507);
              if (SnsUploadBrowseUI.this.KNW.fWt() == 0) {
                SnsUploadBrowseUI.this.fXP();
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
    ar.bs(this);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(99510);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(99511);
    aj.fOF().aO(this);
    super.onDestroy();
    AppMethodBeat.o(99511);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(99513);
    if (this.KNW != null) {
      this.KNW.onPause();
    }
    super.onPause();
    AppMethodBeat.o(99513);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(99512);
    super.onResume();
    if (this.KNW != null) {
      this.KNW.yY(false);
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