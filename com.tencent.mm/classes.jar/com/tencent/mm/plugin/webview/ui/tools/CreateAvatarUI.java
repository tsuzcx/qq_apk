package com.tencent.mm.plugin.webview.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
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
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ag.d;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.webview.model.g;
import com.tencent.mm.protocal.c.ajn;
import com.tencent.mm.protocal.c.azp;
import com.tencent.mm.protocal.c.bp;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.io.ByteArrayOutputStream;
import java.io.File;

public class CreateAvatarUI
  extends MMActivity
  implements f, com.tencent.mm.ui.tools.a.c.a
{
  private String appId;
  private com.tencent.mm.ui.base.p dpF;
  private String fileId;
  private InputMethodManager rkG;
  private EditText rkH;
  private String rkI;
  private boolean rkJ = true;
  private boolean rkK = false;
  
  private boolean Cu(int paramInt)
  {
    if ((paramInt == 1) || (paramInt == 2) || (paramInt == 7) || (paramInt == 8))
    {
      y.e("MicroMsg.CreateAvatarUI", "isNetworkAvailable false, errType = " + paramInt);
      return false;
    }
    if (!aq.isConnected(this))
    {
      y.e("MicroMsg.CreateAvatarUI", "isNetworkAvailable false, not connected");
      return false;
    }
    return true;
  }
  
  private static byte[] Q(Bitmap paramBitmap)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    com.tencent.mm.sdk.platformtools.c.a(paramBitmap, Bitmap.CompressFormat.JPEG, 85, localByteArrayOutputStream);
    paramBitmap = localByteArrayOutputStream.toByteArray();
    try
    {
      localByteArrayOutputStream.close();
      return paramBitmap;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.CreateAvatarUI", localException, "", new Object[0]);
    }
    return paramBitmap;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    int j = 1;
    boolean bool1;
    if (paramMotionEvent.getAction() == 0)
    {
      View localView = getCurrentFocus();
      int i;
      if ((localView != null) && ((localView instanceof EditText)))
      {
        int[] arrayOfInt = new int[2];
        int[] tmp38_36 = arrayOfInt;
        tmp38_36[0] = 0;
        int[] tmp42_38 = tmp38_36;
        tmp42_38[1] = 0;
        tmp42_38;
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
                this.rkH.setCursorVisible(true);
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
        this.rkG = ((InputMethodManager)getSystemService("input_method"));
        if (this.rkG != null)
        {
          this.rkG.hideSoftInputFromWindow(localView.getWindowToken(), 0);
          this.rkH.setCursorVisible(false);
          getWindow().getDecorView().requestFocus();
        }
      }
      bool1 = super.dispatchTouchEvent(paramMotionEvent);
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (getWindow().superDispatchTouchEvent(paramMotionEvent));
      bool1 = bool2;
    } while (onTouchEvent(paramMotionEvent));
    return false;
  }
  
  public final void eP(String paramString)
  {
    Object localObject1;
    Object localObject2;
    if (this.rkK)
    {
      localObject1 = this.appId;
      localObject2 = this.fileId;
      y.i("MicroMsg.CreateAvatarUI", "doAddAvatar appid: %s", new Object[] { localObject1 });
      paramString = new g((String)localObject1, paramString, (String)localObject2);
      au.Dk().a(paramString, 0);
      return;
    }
    if (this.rkJ)
    {
      localObject1 = com.tencent.mm.sdk.platformtools.c.EX(R.k.default_avatar);
      localObject2 = com.tencent.mm.sdk.platformtools.c.a((Bitmap)localObject1, 500, 500, false);
      localObject1 = this.appId;
      localObject2 = Q((Bitmap)localObject2);
      y.i("MicroMsg.CreateAvatarUI", "doAddAvatar appid: %s", new Object[] { localObject1 });
      if ((this.dpF == null) || (this.dpF.isShowing())) {
        break label161;
      }
      this.dpF.show();
    }
    for (;;)
    {
      paramString = new g((String)localObject1, paramString, (byte[])localObject2);
      au.Dk().a(paramString, 0);
      return;
      localObject1 = com.tencent.mm.sdk.platformtools.c.f(this.rkI, 1.0F);
      break;
      label161:
      this.dpF = h.b(this, getString(R.l.create_avatar_saving), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          try
          {
            paramAnonymousDialogInterface.dismiss();
            return;
          }
          catch (Exception paramAnonymousDialogInterface)
          {
            y.e("MicroMsg.CreateAvatarUI", "showProgressDlg onCancel exp: %s ", new Object[] { paramAnonymousDialogInterface.getLocalizedMessage() });
          }
        }
      });
    }
  }
  
  protected final int getLayoutId()
  {
    return R.i.create_avatar_ui;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    y.i("MicroMsg.CreateAvatarUI", "onAcvityResult requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 != -1) {
      y.e("MicroMsg.CreateAvatarUI", "Get image from album failed");
    }
    do
    {
      do
      {
        return;
        switch (paramInt1)
        {
        default: 
          return;
        }
      } while (paramIntent == null);
      Intent localIntent = new Intent();
      localIntent.putExtra("CropImageMode", 1);
      localIntent.putExtra("CropImage_Filter", true);
      com.tencent.mm.ag.o.JQ();
      localIntent.putExtra("CropImage_OutputPath", d.A(q.Gj() + ".crop", true));
      localIntent.putExtra("CropImage_ImgPath", null);
      localIntent.setClassName(this, "com.tencent.mm.ui.tools.CropImageNewUI");
      com.tencent.mm.ui.tools.a.b(this, paramIntent, localIntent, com.tencent.mm.plugin.n.c.FG(), 5, null);
      return;
    } while (paramIntent == null);
    paramIntent = paramIntent.getStringExtra("CropImage_OutputPath");
    if (paramIntent == null)
    {
      y.e("MicroMsg.CreateAvatarUI", "crop picture failed");
      return;
    }
    y.i("MicroMsg.CreateAvatarUI", "onActivityResult(CROP_PICTURE_FOR_AVATAR)  file:%s, size:%d", new Object[] { paramIntent, Long.valueOf(new File(paramIntent).length()) });
    this.rkI = paramIntent;
    this.rkJ = false;
    this.rkK = false;
    ((ImageView)findViewById(R.h.avatar_profile)).setImageBitmap(BitmapFactory.decodeFile(paramIntent));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setMMTitle(getString(R.l.create_avatar_title));
    setBackBtn(new CreateAvatarUI.1(this));
    this.appId = getIntent().getStringExtra("0");
    this.rkH = ((EditText)findViewById(R.h.nickname_edit));
    this.rkH.setOnEditorActionListener(new CreateAvatarUI.3(this));
    this.rkH.setOnKeyListener(new CreateAvatarUI.4(this));
    this.rkH.addTextChangedListener(new CreateAvatarUI.5(this));
    this.rkH.setOnTouchListener(new CreateAvatarUI.6(this));
    findViewById(R.h.choose_avatar_profile).setOnClickListener(new CreateAvatarUI.7(this));
    findViewById(R.h.refresh_icon).setOnClickListener(new CreateAvatarUI.8(this));
    findViewById(R.h.refresh_text).setOnClickListener(new CreateAvatarUI.9(this));
    findViewById(R.h.create_avatar_btn_save).setOnClickListener(new CreateAvatarUI.10(this));
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.dpF != null) {
      this.dpF.dismiss();
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    au.Dk().b(2500, this);
    au.Dk().b(2785, this);
  }
  
  protected void onResume()
  {
    super.onResume();
    au.Dk().a(2500, this);
    au.Dk().a(2785, this);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    if ((paramm instanceof g))
    {
      y.i("MicroMsg.CreateAvatarUI", "onAddAvatarEnd errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (this.dpF != null) {
        this.dpF.dismiss();
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((bp)((g)paramm).dmK.ecF.ecN).svl;
        paramm = new Intent();
        paramm.putExtra("id", paramString.id);
        paramm.putExtra("nickname", paramString.nickname);
        paramm.putExtra("avatarurl", paramString.tgf);
        setResult(-1, paramm);
        finish();
      }
    }
    while (!(paramm instanceof com.tencent.mm.plugin.webview.model.m))
    {
      return;
      if (!Cu(paramInt1))
      {
        h.b(this, getString(R.l.wechat_auth_network_failed), getString(R.l.create_avatar_add_failed), true);
        return;
      }
      h.b(this, paramString, getString(R.l.create_avatar_add_failed), true);
      return;
    }
    y.i("MicroMsg.CreateAvatarUI", "onGetRandomAvatarEnd errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = (ajn)((com.tencent.mm.plugin.webview.model.m)paramm).dmK.ecF.ecN;
      paramm = new com.tencent.mm.as.a.a.c.a();
      paramm.eru = R.k.default_avatar;
      com.tencent.mm.as.o.ON().a(paramString.tgf, (ImageView)findViewById(R.h.avatar_profile), paramm.OV());
      this.rkH.setText(paramString.nickname);
      this.rkK = true;
      this.rkJ = false;
      this.fileId = paramString.fileid;
      if (!this.rkH.getText().toString().equals(""))
      {
        findViewById(R.h.create_avatar_btn_save).setEnabled(true);
        return;
      }
      findViewById(R.h.create_avatar_btn_save).setEnabled(false);
      return;
    }
    if (!Cu(paramInt1))
    {
      h.b(this, getString(R.l.wechat_auth_network_failed), getString(R.l.create_avatar_getrandom_failed), true);
      return;
    }
    h.b(this, paramString, getString(R.l.create_avatar_getrandom_failed), true);
  }
  
  public final void xB()
  {
    h.h(this, R.l.settings_modify_name_invalid_less, R.l.settings_modify_name_title);
  }
  
  public final void xC()
  {
    h.h(this, R.l.settings_modify_name_invalid_more, R.l.settings_modify_name_title);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.CreateAvatarUI
 * JD-Core Version:    0.7.0.1
 */