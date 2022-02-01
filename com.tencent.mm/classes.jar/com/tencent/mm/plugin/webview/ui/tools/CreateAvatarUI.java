package com.tencent.mm.plugin.webview.ui.tools;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.t;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.gallery.picker.view.ImageCropUI;
import com.tencent.mm.plugin.webview.c.c;
import com.tencent.mm.plugin.webview.c.d;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.c.g;
import com.tencent.mm.plugin.webview.c.h;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.k.f.b;
import com.tencent.mm.plugin.webview.model.k;
import com.tencent.mm.plugin.webview.model.p;
import com.tencent.mm.protocal.protobuf.cbf;
import com.tencent.mm.protocal.protobuf.cl;
import com.tencent.mm.protocal.protobuf.cn;
import com.tencent.mm.protocal.protobuf.ddg;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.io.ByteArrayOutputStream;

public class CreateAvatarUI
  extends MMActivity
  implements com.tencent.mm.an.i, com.tencent.mm.ui.tools.b.c.a
{
  private InputMethodManager QaP;
  private EditText QaQ;
  private String QaR;
  private boolean QaS = true;
  private boolean QaT = false;
  private volatile com.tencent.mm.plugin.webview.k.f QaU;
  private String QaV;
  private boolean QaW = false;
  private long QaX = 0L;
  private long QaY = 0L;
  private String appId;
  private String fileId;
  private com.tencent.mm.ui.base.s jhZ;
  
  private static byte[] aE(Bitmap paramBitmap)
  {
    AppMethodBeat.i(79566);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    BitmapUtil.compress(paramBitmap, Bitmap.CompressFormat.JPEG, 85, localByteArrayOutputStream);
    paramBitmap = localByteArrayOutputStream.toByteArray();
    try
    {
      localByteArrayOutputStream.close();
      AppMethodBeat.o(79566);
      return paramBitmap;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.CreateAvatarUI", localException, "", new Object[0]);
      }
    }
  }
  
  private boolean anQ(int paramInt)
  {
    AppMethodBeat.i(79571);
    if ((paramInt == 1) || (paramInt == 2) || (paramInt == 7) || (paramInt == 8))
    {
      Log.e("MicroMsg.CreateAvatarUI", "isNetworkAvailable false, errType = ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(79571);
      return false;
    }
    if (!NetStatusUtil.isConnected(this))
    {
      Log.e("MicroMsg.CreateAvatarUI", "isNetworkAvailable false, not connected");
      AppMethodBeat.o(79571);
      return false;
    }
    AppMethodBeat.o(79571);
    return true;
  }
  
  private void bb(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(79569);
    Log.i("MicroMsg.CreateAvatarUI", "doAddAvatar appid: %s", new Object[] { paramString1 });
    cjp();
    paramString1 = new com.tencent.mm.plugin.webview.model.i(paramString1, paramString2, paramString3);
    com.tencent.mm.kernel.h.aGY().a(paramString1, 0);
    this.QaX = System.currentTimeMillis();
    AppMethodBeat.o(79569);
  }
  
  private void cjp()
  {
    AppMethodBeat.i(79572);
    if ((this.jhZ != null) && (!this.jhZ.isShowing()))
    {
      this.jhZ.show();
      AppMethodBeat.o(79572);
      return;
    }
    this.jhZ = com.tencent.mm.ui.base.h.a(this, getString(c.i.create_avatar_saving), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(79550);
        try
        {
          paramAnonymousDialogInterface.dismiss();
          AppMethodBeat.o(79550);
          return;
        }
        catch (Exception paramAnonymousDialogInterface)
        {
          Log.e("MicroMsg.CreateAvatarUI", "showProgressDlg onCancel exp: %s ", new Object[] { paramAnonymousDialogInterface.getLocalizedMessage() });
          AppMethodBeat.o(79550);
        }
      }
    });
    AppMethodBeat.o(79572);
  }
  
  private void gXr()
  {
    AppMethodBeat.i(79573);
    if (this.jhZ == null)
    {
      AppMethodBeat.o(79573);
      return;
    }
    this.jhZ.dismiss();
    AppMethodBeat.o(79573);
  }
  
  public final void abc(String paramString)
  {
    AppMethodBeat.i(79563);
    this.QaW = true;
    if ((this.QaT) || (this.QaU == null) || (this.QaS))
    {
      if ((this.fileId == null) || (this.fileId.isEmpty()))
      {
        Object localObject = BitmapUtil.getCenterCropBitmap(BitmapUtil.getBitmapNative(c.h.default_avatar), 500, 500, false);
        String str = this.appId;
        localObject = aE((Bitmap)localObject);
        Log.i("MicroMsg.CreateAvatarUI", "doAddAvatar appid: %s", new Object[] { str });
        cjp();
        paramString = new com.tencent.mm.plugin.webview.model.i(str, paramString, (byte[])localObject);
        com.tencent.mm.kernel.h.aGY().a(paramString, 0);
        this.QaX = System.currentTimeMillis();
        AppMethodBeat.o(79563);
        return;
      }
      bb(this.appId, paramString, this.fileId);
      AppMethodBeat.o(79563);
      return;
    }
    if (this.QaU.QzT == f.b.QzX)
    {
      bb(this.appId, paramString, this.QaV);
      AppMethodBeat.o(79563);
      return;
    }
    if (this.QaU.QzT == f.b.QzY)
    {
      cjp();
      this.QaU.mN(this.QaR, this.appId);
      AppMethodBeat.o(79563);
      return;
    }
    cjp();
    AppMethodBeat.o(79563);
  }
  
  public final void abd(String paramString)
  {
    AppMethodBeat.i(251448);
    com.tencent.mm.ui.base.h.p(this, c.i.settings_modify_name_invalid_less, c.i.settings_modify_name_title);
    AppMethodBeat.o(251448);
  }
  
  public final void dN(String paramString)
  {
    AppMethodBeat.i(164021);
    com.tencent.mm.ui.base.h.p(this, c.i.settings_modify_name_invalid_more, c.i.settings_modify_name_title);
    AppMethodBeat.o(164021);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = 1;
    AppMethodBeat.i(79568);
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
                this.QaQ.setCursorVisible(true);
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
        this.QaP = ((InputMethodManager)getSystemService("input_method"));
        if (this.QaP != null)
        {
          this.QaP.hideSoftInputFromWindow(localView.getWindowToken(), 0);
          this.QaQ.setCursorVisible(false);
          getWindow().getDecorView().requestFocus();
        }
      }
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(79568);
      return bool;
    }
    if ((getWindow().superDispatchTouchEvent(paramMotionEvent)) || (onTouchEvent(paramMotionEvent)))
    {
      AppMethodBeat.o(79568);
      return true;
    }
    AppMethodBeat.o(79568);
    return false;
  }
  
  public int getLayoutId()
  {
    return c.g.create_avatar_ui;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(79567);
    Log.i("MicroMsg.CreateAvatarUI", "onAcvityResult requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 != -1)
    {
      Log.e("MicroMsg.CreateAvatarUI", "Get image from album failed");
      AppMethodBeat.o(79567);
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(79567);
      return;
      if (paramIntent == null)
      {
        AppMethodBeat.o(79567);
        return;
      }
      Intent localIntent = new Intent(this, ImageCropUI.class);
      localIntent.putExtra("CropImageMode", 1);
      localIntent.putExtra("CropImage_Filter", true);
      com.tencent.mm.am.q.bhz();
      localIntent.putExtra("CropImage_OutputPath", com.tencent.mm.am.f.O(z.bcZ() + ".crop", true));
      localIntent.putExtra("CropImage_ImgPath", null);
      localIntent.putExtra("CropImage_from_scene", 3);
      com.tencent.mm.ui.tools.b.b(this, paramIntent, localIntent, com.tencent.mm.plugin.image.d.bbW(), 5, null);
      AppMethodBeat.o(79567);
      return;
      if (paramIntent == null)
      {
        AppMethodBeat.o(79567);
        return;
      }
      paramIntent = paramIntent.getStringExtra("CropImage_OutputPath");
      if (paramIntent == null)
      {
        Log.e("MicroMsg.CreateAvatarUI", "crop picture failed");
        AppMethodBeat.o(79567);
        return;
      }
      Log.i("MicroMsg.CreateAvatarUI", "onActivityResult(CROP_PICTURE_FOR_AVATAR)  file:%s, size:%d", new Object[] { paramIntent, Long.valueOf(new com.tencent.mm.vfs.q(paramIntent).length()) });
      this.QaR = paramIntent;
      this.QaW = false;
      this.QaS = false;
      this.QaT = false;
      ((ImageView)findViewById(c.f.avatar_profile)).setImageBitmap(MMBitmapFactory.decodeFile(paramIntent));
      if (this.QaU == null)
      {
        this.QaU = new com.tencent.mm.plugin.webview.k.f();
        this.QaU.QzS.a(this, new androidx.lifecycle.s() {});
      }
      this.QaV = null;
      this.QaU.mN(this.QaR, this.appId);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(79559);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(c.c.white));
    hideActionbarLine();
    setMMTitle(getString(c.i.create_avatar_title));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(79548);
        CreateAvatarUI.this.finish();
        AppMethodBeat.o(79548);
        return true;
      }
    });
    this.appId = getIntent().getStringExtra("0");
    this.fileId = getIntent().getStringExtra("default_fileid");
    this.QaQ = ((EditText)findViewById(c.f.nickname_edit));
    this.QaQ.setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(79551);
        if ((paramAnonymousInt == 6) || ((paramAnonymousKeyEvent != null) && (paramAnonymousKeyEvent.getKeyCode() == 66)))
        {
          CreateAvatarUI.a(CreateAvatarUI.this, (InputMethodManager)CreateAvatarUI.this.getSystemService("input_method"));
          if ((CreateAvatarUI.a(CreateAvatarUI.this) != null) && (CreateAvatarUI.a(CreateAvatarUI.this).isActive()))
          {
            CreateAvatarUI.a(CreateAvatarUI.this).hideSoftInputFromWindow(CreateAvatarUI.this.getCurrentFocus().getWindowToken(), 0);
            CreateAvatarUI.b(CreateAvatarUI.this).setCursorVisible(false);
            CreateAvatarUI.this.getWindow().getDecorView().requestFocus();
          }
        }
        AppMethodBeat.o(79551);
        return false;
      }
    });
    this.QaQ.setOnKeyListener(new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(79552);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        localb.sg(paramAnonymousInt);
        localb.bn(paramAnonymousKeyEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/CreateAvatarUI$3", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.aFi());
        if (paramAnonymousInt == 4)
        {
          CreateAvatarUI.a(CreateAvatarUI.this, (InputMethodManager)CreateAvatarUI.this.getSystemService("input_method"));
          if ((CreateAvatarUI.a(CreateAvatarUI.this) != null) && (CreateAvatarUI.a(CreateAvatarUI.this).isActive()))
          {
            CreateAvatarUI.a(CreateAvatarUI.this).hideSoftInputFromWindow(CreateAvatarUI.this.getCurrentFocus().getWindowToken(), 0);
            CreateAvatarUI.b(CreateAvatarUI.this).setCursorVisible(false);
            CreateAvatarUI.this.getWindow().getDecorView().requestFocus();
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/webview/ui/tools/CreateAvatarUI$3", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
        AppMethodBeat.o(79552);
        return false;
      }
    });
    this.QaQ.setHintTextColor(getResources().getColor(c.c.hint_text_color));
    this.QaQ.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(79553);
        if (!CreateAvatarUI.b(CreateAvatarUI.this).getText().toString().equals(""))
        {
          CreateAvatarUI.this.findViewById(c.f.create_avatar_btn_save).setEnabled(true);
          AppMethodBeat.o(79553);
          return;
        }
        CreateAvatarUI.this.findViewById(c.f.create_avatar_btn_save).setEnabled(false);
        AppMethodBeat.o(79553);
      }
    });
    this.QaQ.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(79554);
        if (paramAnonymousMotionEvent.getAction() == 0) {
          CreateAvatarUI.b(CreateAvatarUI.this).setCursorVisible(true);
        }
        AppMethodBeat.o(79554);
        return false;
      }
    });
    findViewById(c.f.choose_avatar_profile).setOnClickListener(new CreateAvatarUI.8(this));
    findViewById(c.f.refresh_icon).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(79556);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/CreateAvatarUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        CreateAvatarUI.a(CreateAvatarUI.this, CreateAvatarUI.c(CreateAvatarUI.this));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/CreateAvatarUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(79556);
      }
    });
    findViewById(c.f.refresh_text).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(79557);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/CreateAvatarUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        CreateAvatarUI.a(CreateAvatarUI.this, CreateAvatarUI.c(CreateAvatarUI.this));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/CreateAvatarUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(79557);
      }
    });
    findViewById(c.f.create_avatar_btn_save).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(79558);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/CreateAvatarUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        paramAnonymousView = CreateAvatarUI.b(CreateAvatarUI.this).getText().toString();
        localObject = com.tencent.mm.n.c.awM();
        if ((!Util.isNullOrNil((String)localObject)) && (paramAnonymousView.matches(".*[" + (String)localObject + "].*")))
        {
          com.tencent.mm.ui.base.h.c(CreateAvatarUI.this.getContext(), CreateAvatarUI.this.getString(c.i.invalid_input_character_toast, new Object[] { localObject }), CreateAvatarUI.this.getString(c.i.app_tip), true);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/CreateAvatarUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(79558);
          return;
        }
        com.tencent.mm.ui.tools.b.c.i(CreateAvatarUI.b(CreateAvatarUI.this)).mM(1, 32).a(CreateAvatarUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/CreateAvatarUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(79558);
      }
    });
    paramBundle = getIntent();
    if ((paramBundle != null) && (paramBundle.getBooleanExtra("extra_call_by_appbrand", false))) {
      com.tencent.mm.plugin.webview.k.b.QzJ.da(4, "");
    }
    AppMethodBeat.o(79559);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(79562);
    super.onDestroy();
    if (this.jhZ != null) {
      this.jhZ.dismiss();
    }
    AppMethodBeat.o(79562);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(79561);
    super.onPause();
    com.tencent.mm.kernel.h.aGY().b(2500, this);
    com.tencent.mm.kernel.h.aGY().b(2785, this);
    com.tencent.mm.kernel.h.aGY().b(2667, this);
    AppMethodBeat.o(79561);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(79560);
    super.onResume();
    com.tencent.mm.kernel.h.aGY().a(2500, this);
    com.tencent.mm.kernel.h.aGY().a(2785, this);
    com.tencent.mm.kernel.h.aGY().a(2667, this);
    AppMethodBeat.o(79560);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(79570);
    if ((paramq instanceof com.tencent.mm.plugin.webview.model.i))
    {
      Log.i("MicroMsg.CreateAvatarUI", "onAddAvatarEnd errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      gXr();
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((cn)d.c.b(((com.tencent.mm.plugin.webview.model.i)paramq).rr.lBS)).RId;
        paramq = new Intent();
        paramq.putExtra("id", paramString.id);
        paramq.putExtra("nickname", paramString.nickname);
        paramq.putExtra("avatarurl", paramString.oDV);
        setResult(-1, paramq);
        finish();
      }
      for (;;)
      {
        com.tencent.mm.plugin.webview.k.b.QzJ.aS(6, (int)(System.currentTimeMillis() - this.QaX), paramInt2);
        AppMethodBeat.o(79570);
        return;
        if (!anQ(paramInt1)) {
          com.tencent.mm.ui.base.h.c(this, getString(c.i.wechat_auth_network_failed), getString(c.i.create_avatar_add_failed), true);
        } else {
          com.tencent.mm.ui.base.h.c(this, paramString, getString(c.i.create_avatar_add_failed), true);
        }
      }
    }
    if ((paramq instanceof p))
    {
      Log.i("MicroMsg.CreateAvatarUI", "onGetRandomAvatarEnd errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (cbf)d.c.b(((p)paramq).rr.lBS);
        paramq = new com.tencent.mm.ay.a.a.c.a();
        paramq.lRP = c.h.default_avatar;
        paramq.lRW = getResources().getDimension(c.d.sdk_oauth_avatar_corners_size);
        paramq.kPz = true;
        com.tencent.mm.ay.q.bml().a(paramString.oDV, (ImageView)findViewById(c.f.avatar_profile), paramq.bmL());
        this.QaQ.setText(paramString.nickname);
        this.QaT = true;
        this.QaS = false;
        this.fileId = paramString.fileid;
        if (!this.QaQ.getText().toString().equals("")) {
          findViewById(c.f.create_avatar_btn_save).setEnabled(true);
        }
      }
      for (;;)
      {
        com.tencent.mm.plugin.webview.k.b.QzJ.aS(5, (int)(System.currentTimeMillis() - this.QaY), paramInt2);
        AppMethodBeat.o(79570);
        return;
        findViewById(c.f.create_avatar_btn_save).setEnabled(false);
        continue;
        if (!anQ(paramInt1)) {
          com.tencent.mm.ui.base.h.c(this, getString(c.i.wechat_auth_network_failed), getString(c.i.create_avatar_getrandom_failed), true);
        } else {
          com.tencent.mm.ui.base.h.c(this, paramString, getString(c.i.create_avatar_getrandom_failed), true);
        }
      }
    }
    if ((paramq instanceof k))
    {
      Log.i("MicroMsg.CreateAvatarUI", "onGetCreateAvatarEnd errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (this.QaU == null)
      {
        Log.e("MicroMsg.CreateAvatarUI", "uploadEngine == null, multi-Thread Error, thread name = " + Thread.currentThread().getName());
        AppMethodBeat.o(79570);
        return;
      }
      com.tencent.mm.plugin.webview.k.f localf = this.QaU;
      String str = ((k)paramq).wQa;
      if (!str.equals(localf.pqt)) {
        Log.i("MicroMsg.VestImgUploadEngine", "currentPath=%s,callbackPath=%s, path updated after onSceneEnd", new Object[] { localf.pqt, str });
      }
      while (this.QaW)
      {
        gXr();
        if (this.QaU.QzT != f.b.QzX)
        {
          gXr();
          if (!anQ(paramInt1))
          {
            gXr();
            com.tencent.mm.ui.base.h.c(this, getString(c.i.wechat_auth_network_failed), getString(c.i.create_avatar_add_failed), true);
            AppMethodBeat.o(79570);
            return;
            if ((paramInt1 == 0) && (paramInt2 == 0))
            {
              localf.QzT = f.b.QzX;
              paramq = (cl)d.c.b(((k)paramq).rr.lBS);
              localf.QzS.L(paramq.fileid);
              Log.i("MicroMsg.VestImgUploadEngine", "file id create success: %s", new Object[] { paramq.fileid });
            }
            else
            {
              localf.QzT = f.b.QzY;
              Log.i("MicroMsg.VestImgUploadEngine", "file id create failed: errType = %s, errCode = %s, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
            }
          }
          else
          {
            com.tencent.mm.ui.base.h.c(this, paramString, getString(c.i.create_avatar_add_failed), true);
          }
        }
      }
    }
    AppMethodBeat.o(79570);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.CreateAvatarUI
 * JD-Core Version:    0.7.0.1
 */