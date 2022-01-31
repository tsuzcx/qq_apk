package com.tencent.mm.plugin.webview.ui.tools;

import android.app.Activity;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.i.c;
import com.tencent.mm.plugin.webview.f.b.b;
import com.tencent.mm.plugin.webview.model.i;
import com.tencent.mm.protocal.protobuf.aou;
import com.tencent.mm.protocal.protobuf.bgs;
import com.tencent.mm.protocal.protobuf.bv;
import com.tencent.mm.protocal.protobuf.bx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.io.ByteArrayOutputStream;
import java.io.File;

public class CreateAvatarUI
  extends MMActivity
  implements f, com.tencent.mm.ui.tools.b.c.a
{
  private String appId;
  private com.tencent.mm.ui.base.p ehb;
  private String fileId;
  private InputMethodManager vac;
  private EditText vad;
  private String vae;
  private boolean vaf = true;
  private boolean vag = false;
  private volatile com.tencent.mm.plugin.webview.f.b vah;
  private String vai;
  private boolean vaj = false;
  private long vak = 0L;
  private long val = 0L;
  
  private boolean JV(int paramInt)
  {
    AppMethodBeat.i(7376);
    if ((paramInt == 1) || (paramInt == 2) || (paramInt == 7) || (paramInt == 8))
    {
      ab.e("MicroMsg.CreateAvatarUI", "isNetworkAvailable false, errType = ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(7376);
      return false;
    }
    if (!at.isConnected(this))
    {
      ab.e("MicroMsg.CreateAvatarUI", "isNetworkAvailable false, not connected");
      AppMethodBeat.o(7376);
      return false;
    }
    AppMethodBeat.o(7376);
    return true;
  }
  
  private static byte[] ae(Bitmap paramBitmap)
  {
    AppMethodBeat.i(7371);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    com.tencent.mm.sdk.platformtools.d.a(paramBitmap, Bitmap.CompressFormat.JPEG, 85, localByteArrayOutputStream);
    paramBitmap = localByteArrayOutputStream.toByteArray();
    try
    {
      localByteArrayOutputStream.close();
      AppMethodBeat.o(7371);
      return paramBitmap;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.CreateAvatarUI", localException, "", new Object[0]);
      }
    }
  }
  
  private void ay(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(7374);
    ab.i("MicroMsg.CreateAvatarUI", "doAddAvatar appid: %s", new Object[] { paramString1 });
    paramString1 = new com.tencent.mm.plugin.webview.model.g(paramString1, paramString2, paramString3);
    com.tencent.mm.kernel.g.Rc().a(paramString1, 0);
    this.vak = System.currentTimeMillis();
    AppMethodBeat.o(7374);
  }
  
  private void ddu()
  {
    AppMethodBeat.i(7377);
    if ((this.ehb != null) && (!this.ehb.isShowing()))
    {
      this.ehb.show();
      AppMethodBeat.o(7377);
      return;
    }
    this.ehb = h.b(this, getString(2131298882), true, new CreateAvatarUI.3(this));
    AppMethodBeat.o(7377);
  }
  
  private void ddv()
  {
    AppMethodBeat.i(7378);
    if (this.ehb == null)
    {
      AppMethodBeat.o(7378);
      return;
    }
    this.ehb.dismiss();
    AppMethodBeat.o(7378);
  }
  
  public final void JU()
  {
    AppMethodBeat.i(7369);
    h.h(this, 2131303316, 2131303319);
    AppMethodBeat.o(7369);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = 1;
    AppMethodBeat.i(7373);
    if (paramMotionEvent.getAction() == 0)
    {
      View localView = getCurrentFocus();
      int i;
      if ((localView != null) && ((localView instanceof EditText)))
      {
        int[] arrayOfInt = new int[2];
        int[] tmp41_39 = arrayOfInt;
        tmp41_39[0] = 0;
        int[] tmp45_41 = tmp41_39;
        tmp45_41[1] = 0;
        tmp45_41;
        localView.getLocationInWindow(arrayOfInt);
        int k = arrayOfInt[0];
        int m = arrayOfInt[1];
        int n = localView.getHeight();
        int i1 = localView.getWidth();
        i = j;
        if (paramMotionEvent.getX() > k)
        {
          i = j;
          if (paramMotionEvent.getX() < i1 + k)
          {
            i = j;
            if (paramMotionEvent.getY() > m)
            {
              i = j;
              if (paramMotionEvent.getY() < n + m) {
                this.vad.setCursorVisible(true);
              }
            }
          }
        }
      }
      else
      {
        i = 0;
      }
      if (i != 0)
      {
        this.vac = ((InputMethodManager)getSystemService("input_method"));
        if (this.vac != null)
        {
          this.vac.hideSoftInputFromWindow(localView.getWindowToken(), 0);
          this.vad.setCursorVisible(false);
          getWindow().getDecorView().requestFocus();
        }
      }
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(7373);
      return bool;
    }
    if ((getWindow().superDispatchTouchEvent(paramMotionEvent)) || (onTouchEvent(paramMotionEvent)))
    {
      AppMethodBeat.o(7373);
      return true;
    }
    AppMethodBeat.o(7373);
    return false;
  }
  
  public int getLayoutId()
  {
    return 2130969284;
  }
  
  public final void kY(String paramString)
  {
    AppMethodBeat.i(7368);
    this.vaj = true;
    if ((this.vag) || (this.vah == null) || (this.vaf))
    {
      if ((this.fileId == null) || (this.fileId.isEmpty()))
      {
        Object localObject = com.tencent.mm.sdk.platformtools.d.b(com.tencent.mm.sdk.platformtools.d.Na(2131231207), 500, 500, false);
        String str = this.appId;
        localObject = ae((Bitmap)localObject);
        ab.i("MicroMsg.CreateAvatarUI", "doAddAvatar appid: %s", new Object[] { str });
        ddu();
        paramString = new com.tencent.mm.plugin.webview.model.g(str, paramString, (byte[])localObject);
        com.tencent.mm.kernel.g.Rc().a(paramString, 0);
        this.vak = System.currentTimeMillis();
        AppMethodBeat.o(7368);
        return;
      }
      ay(this.appId, paramString, this.fileId);
      AppMethodBeat.o(7368);
      return;
    }
    if (this.vah.vtR == b.b.vtV)
    {
      ay(this.appId, paramString, this.vai);
      AppMethodBeat.o(7368);
      return;
    }
    if (this.vah.vtR == b.b.vtW)
    {
      ddu();
      this.vah.hE(this.vae, this.appId);
      AppMethodBeat.o(7368);
      return;
    }
    ddu();
    AppMethodBeat.o(7368);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(7372);
    ab.i("MicroMsg.CreateAvatarUI", "onAcvityResult requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 != -1)
    {
      ab.e("MicroMsg.CreateAvatarUI", "Get image from album failed");
      AppMethodBeat.o(7372);
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(7372);
      return;
      if (paramIntent == null)
      {
        AppMethodBeat.o(7372);
        return;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("CropImageMode", 1);
      localIntent.putExtra("CropImage_Filter", true);
      com.tencent.mm.ah.o.acQ();
      localIntent.putExtra("CropImage_OutputPath", com.tencent.mm.ah.d.E(r.Zn() + ".crop", true));
      localIntent.putExtra("CropImage_ImgPath", null);
      localIntent.setClassName(this, "com.tencent.mm.ui.tools.CropImageNewUI");
      com.tencent.mm.ui.tools.a.b(this, paramIntent, localIntent, c.YK(), 5, null);
      AppMethodBeat.o(7372);
      return;
      if (paramIntent == null)
      {
        AppMethodBeat.o(7372);
        return;
      }
      paramIntent = paramIntent.getStringExtra("CropImage_OutputPath");
      if (paramIntent == null)
      {
        ab.e("MicroMsg.CreateAvatarUI", "crop picture failed");
        AppMethodBeat.o(7372);
        return;
      }
      ab.i("MicroMsg.CreateAvatarUI", "onActivityResult(CROP_PICTURE_FOR_AVATAR)  file:%s, size:%d", new Object[] { paramIntent, Long.valueOf(new File(paramIntent).length()) });
      this.vae = paramIntent;
      this.vaj = false;
      this.vaf = false;
      this.vag = false;
      ((ImageView)findViewById(2131823265)).setImageBitmap(BitmapFactory.decodeFile(paramIntent));
      if (this.vah == null)
      {
        this.vah = new com.tencent.mm.plugin.webview.f.b();
        this.vah.vtQ.observe(this, new CreateAvatarUI.2(this));
      }
      this.vai = null;
      this.vah.hE(this.vae, this.appId);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(7364);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(2131689615));
    hideActionbarLine();
    setMMTitle(getString(2131298883));
    setBackBtn(new CreateAvatarUI.1(this));
    this.appId = getIntent().getStringExtra("0");
    this.fileId = getIntent().getStringExtra("default_fileid");
    this.vad = ((EditText)findViewById(2131823266));
    this.vad.setOnEditorActionListener(new CreateAvatarUI.4(this));
    this.vad.setOnKeyListener(new CreateAvatarUI.5(this));
    this.vad.addTextChangedListener(new CreateAvatarUI.6(this));
    this.vad.setOnTouchListener(new CreateAvatarUI.7(this));
    findViewById(2131823264).setOnClickListener(new CreateAvatarUI.8(this));
    findViewById(2131823268).setOnClickListener(new CreateAvatarUI.9(this));
    findViewById(2131823269).setOnClickListener(new CreateAvatarUI.10(this));
    findViewById(2131823270).setOnClickListener(new CreateAvatarUI.11(this));
    AppMethodBeat.o(7364);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(7367);
    super.onDestroy();
    if (this.ehb != null) {
      this.ehb.dismiss();
    }
    AppMethodBeat.o(7367);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(7366);
    super.onPause();
    com.tencent.mm.kernel.g.Rc().b(2500, this);
    com.tencent.mm.kernel.g.Rc().b(2785, this);
    com.tencent.mm.kernel.g.Rc().a(2667, this);
    AppMethodBeat.o(7366);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(7365);
    super.onResume();
    com.tencent.mm.kernel.g.Rc().a(2500, this);
    com.tencent.mm.kernel.g.Rc().a(2785, this);
    com.tencent.mm.kernel.g.Rc().a(2667, this);
    AppMethodBeat.o(7365);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(7375);
    if ((paramm instanceof com.tencent.mm.plugin.webview.model.g))
    {
      ab.i("MicroMsg.CreateAvatarUI", "onAddAvatarEnd errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      ddv();
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((bx)((com.tencent.mm.plugin.webview.model.g)paramm).rr.fsW.fta).wos;
        paramm = new Intent();
        paramm.putExtra("id", paramString.id);
        paramm.putExtra("nickname", paramString.nickname);
        paramm.putExtra("avatarurl", paramString.xeE);
        setResult(-1, paramm);
        finish();
      }
      for (;;)
      {
        com.tencent.mm.plugin.webview.f.a.vtM.ap(6, (int)(System.currentTimeMillis() - this.vak), paramInt2);
        AppMethodBeat.o(7375);
        return;
        if (!JV(paramInt1)) {
          h.b(this, getString(2131305934), getString(2131298875), true);
        } else {
          h.b(this, paramString, getString(2131298875), true);
        }
      }
    }
    if ((paramm instanceof com.tencent.mm.plugin.webview.model.o))
    {
      ab.i("MicroMsg.CreateAvatarUI", "onGetRandomAvatarEnd errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (aou)((com.tencent.mm.plugin.webview.model.o)paramm).rr.fsW.fta;
        paramm = new com.tencent.mm.at.a.a.c.a();
        paramm.eNY = 2131231207;
        paramm.eOl = getResources().getDimension(2131428649);
        paramm.eOk = true;
        com.tencent.mm.at.o.ahG().a(paramString.xeE, (ImageView)findViewById(2131823265), paramm.ahY());
        this.vad.setText(paramString.nickname);
        this.vag = true;
        this.vaf = false;
        this.fileId = paramString.fileid;
        if (!this.vad.getText().toString().equals("")) {
          findViewById(2131823270).setEnabled(true);
        }
      }
      for (;;)
      {
        com.tencent.mm.plugin.webview.f.a.vtM.ap(5, (int)(System.currentTimeMillis() - this.val), paramInt2);
        AppMethodBeat.o(7375);
        return;
        findViewById(2131823270).setEnabled(false);
        continue;
        if (!JV(paramInt1)) {
          h.b(this, getString(2131305934), getString(2131298877), true);
        } else {
          h.b(this, paramString, getString(2131298877), true);
        }
      }
    }
    if ((paramm instanceof i))
    {
      ab.i("MicroMsg.CreateAvatarUI", "onGetCreateAvatarEnd errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (this.vah == null)
      {
        ab.e("MicroMsg.CreateAvatarUI", "uploadEngine == null, multi-Thread Error, thread name = " + Thread.currentThread().getName());
        AppMethodBeat.o(7375);
        return;
      }
      com.tencent.mm.plugin.webview.f.b localb = this.vah;
      String str = ((i)paramm).mBI;
      if (!str.equals(localb.hZV)) {
        ab.i("MicroMsg.VestImgUploadEngine", "currentPath=%s,callbackPath=%s, path updated after onSceneEnd", new Object[] { localb.hZV, str });
      }
      while (this.vaj)
      {
        ddv();
        if (this.vah.vtR != b.b.vtV)
        {
          ddv();
          if (!JV(paramInt1))
          {
            ddv();
            h.b(this, getString(2131305934), getString(2131298875), true);
            AppMethodBeat.o(7375);
            return;
            if ((paramInt1 == 0) && (paramInt2 == 0))
            {
              localb.vtR = b.b.vtV;
              paramm = (bv)((i)paramm).rr.fsW.fta;
              localb.vtQ.postValue(paramm.fileid);
              ab.i("MicroMsg.VestImgUploadEngine", "file id create success: %s", new Object[] { paramm.fileid });
            }
            else
            {
              localb.vtR = b.b.vtW;
              ab.i("MicroMsg.VestImgUploadEngine", "file id create failed: errType = %s, errCode = %s, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
            }
          }
          else
          {
            h.b(this, paramString, getString(2131298875), true);
          }
        }
      }
    }
    AppMethodBeat.o(7375);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void vn()
  {
    AppMethodBeat.i(7370);
    h.h(this, 2131303317, 2131303319);
    AppMethodBeat.o(7370);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.CreateAvatarUI
 * JD-Core Version:    0.7.0.1
 */