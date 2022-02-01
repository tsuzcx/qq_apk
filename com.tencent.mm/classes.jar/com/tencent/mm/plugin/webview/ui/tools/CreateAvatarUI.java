package com.tencent.mm.plugin.webview.ui.tools;

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
import androidx.lifecycle.x;
import androidx.lifecycle.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.model.z;
import com.tencent.mm.modelavatar.AvatarStorage;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.gallery.picker.view.ImageCropUI;
import com.tencent.mm.plugin.image.d;
import com.tencent.mm.plugin.webview.c.d;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.c.g;
import com.tencent.mm.plugin.webview.c.h;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.k.g;
import com.tencent.mm.plugin.webview.k.g.b;
import com.tencent.mm.plugin.webview.model.i;
import com.tencent.mm.pluginsdk.ui.tools.t;
import com.tencent.mm.protocal.protobuf.cqo;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.protocal.protobuf.cx;
import com.tencent.mm.protocal.protobuf.dvb;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.vfs.u;
import java.io.ByteArrayOutputStream;
import java.util.HashSet;

public class CreateAvatarUI
  extends MMActivity
  implements com.tencent.mm.am.h, com.tencent.mm.ui.tools.b.c.a
{
  private InputMethodManager WRZ;
  private EditText WSa;
  private String WSb;
  private boolean WSc = true;
  private boolean WSd = false;
  private volatile g WSe;
  private String WSf;
  private boolean WSg = false;
  private long WSh = 0L;
  private long WSi = 0L;
  private String appId;
  private String fileId;
  private w lKp;
  
  private static byte[] aV(Bitmap paramBitmap)
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
  
  private static boolean atJ(int paramInt)
  {
    AppMethodBeat.i(79571);
    if ((paramInt == 1) || (paramInt == 2) || (paramInt == 7) || (paramInt == 8))
    {
      Log.e("MicroMsg.CreateAvatarUI", "isNetworkAvailable false, errType = ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(79571);
      return false;
    }
    if (!NetStatusUtil.isConnected(MMApplicationContext.getContext()))
    {
      Log.e("MicroMsg.CreateAvatarUI", "isNetworkAvailable false, not connected");
      AppMethodBeat.o(79571);
      return false;
    }
    AppMethodBeat.o(79571);
    return true;
  }
  
  private void bu(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(79569);
    Log.i("MicroMsg.CreateAvatarUI", "doAddAvatar appid: %s", new Object[] { paramString1 });
    cKs();
    paramString1 = new i(paramString1, paramString2, paramString3);
    com.tencent.mm.kernel.h.aZW().a(paramString1, 0);
    this.WSh = System.currentTimeMillis();
    AppMethodBeat.o(79569);
  }
  
  private void cKs()
  {
    AppMethodBeat.i(79572);
    if ((this.lKp != null) && (!this.lKp.isShowing()))
    {
      this.lKp.show();
      AppMethodBeat.o(79572);
      return;
    }
    this.lKp = com.tencent.mm.ui.base.k.a(this, getString(c.i.create_avatar_saving), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(296404);
        try
        {
          paramAnonymousDialogInterface.dismiss();
          AppMethodBeat.o(296404);
          return;
        }
        catch (Exception paramAnonymousDialogInterface)
        {
          Log.e("MicroMsg.CreateAvatarUI", "showProgressDlg onCancel exp: %s ", new Object[] { paramAnonymousDialogInterface.getLocalizedMessage() });
          AppMethodBeat.o(296404);
        }
      }
    });
    AppMethodBeat.o(79572);
  }
  
  private void ddd()
  {
    AppMethodBeat.i(79573);
    if (this.lKp == null)
    {
      AppMethodBeat.o(79573);
      return;
    }
    this.lKp.dismiss();
    AppMethodBeat.o(79573);
  }
  
  public final void Tw(String paramString)
  {
    AppMethodBeat.i(79563);
    this.WSg = true;
    if ((this.WSd) || (this.WSe == null) || (this.WSc))
    {
      if ((this.fileId == null) || (this.fileId.isEmpty()))
      {
        Object localObject = BitmapUtil.getCenterCropBitmap(BitmapUtil.getBitmapNative(c.h.default_avatar), 500, 500, false);
        String str = this.appId;
        localObject = aV((Bitmap)localObject);
        Log.i("MicroMsg.CreateAvatarUI", "doAddAvatar appid: %s", new Object[] { str });
        cKs();
        paramString = new i(str, paramString, (byte[])localObject);
        com.tencent.mm.kernel.h.aZW().a(paramString, 0);
        this.WSh = System.currentTimeMillis();
        AppMethodBeat.o(79563);
        return;
      }
      bu(this.appId, paramString, this.fileId);
      AppMethodBeat.o(79563);
      return;
    }
    if (this.WSe.XsN == g.b.XsR)
    {
      bu(this.appId, paramString, this.WSf);
      AppMethodBeat.o(79563);
      return;
    }
    if (this.WSe.XsN == g.b.XsS)
    {
      cKs();
      this.WSe.oD(this.WSb, this.appId);
      AppMethodBeat.o(79563);
      return;
    }
    cKs();
    AppMethodBeat.o(79563);
  }
  
  public final void Tx(String paramString)
  {
    AppMethodBeat.i(296174);
    com.tencent.mm.ui.base.k.s(this, c.i.settings_modify_name_invalid_less, c.i.settings_modify_name_title);
    AppMethodBeat.o(296174);
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
                this.WSa.setCursorVisible(true);
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
        this.WRZ = ((InputMethodManager)getSystemService("input_method"));
        if (this.WRZ != null)
        {
          this.WRZ.hideSoftInputFromWindow(localView.getWindowToken(), 0);
          this.WSa.setCursorVisible(false);
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
  
  public final void eY(String paramString)
  {
    AppMethodBeat.i(164021);
    com.tencent.mm.ui.base.k.s(this, c.i.settings_modify_name_invalid_more, c.i.settings_modify_name_title);
    AppMethodBeat.o(164021);
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
      q.bFp();
      localIntent.putExtra("CropImage_OutputPath", AvatarStorage.R(z.bAM() + ".crop", true));
      localIntent.putExtra("CropImage_ImgPath", null);
      localIntent.putExtra("CropImage_from_scene", 3);
      com.tencent.mm.ui.tools.b.a(this, paramIntent, localIntent, d.bzL(), 5, null);
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
      Log.i("MicroMsg.CreateAvatarUI", "onActivityResult(CROP_PICTURE_FOR_AVATAR)  file:%s, size:%d", new Object[] { paramIntent, Long.valueOf(new u(paramIntent).length()) });
      this.WSb = paramIntent;
      this.WSg = false;
      this.WSc = false;
      this.WSd = false;
      ((ImageView)findViewById(c.f.avatar_profile)).setImageBitmap(MMBitmapFactory.decodeFile(paramIntent));
      if (this.WSe == null)
      {
        this.WSe = new g();
        this.WSe.XsM.a(this, new y() {});
      }
      this.WSf = null;
      this.WSe.oD(this.WSb, this.appId);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(79559);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(com.tencent.mm.plugin.webview.c.c.white));
    hideActionbarLine();
    paramBundle = getIntent().getStringExtra("title");
    if (!Util.isNullOrNil(paramBundle)) {
      setMMTitle(paramBundle);
    }
    for (;;)
    {
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
      this.WSa = ((EditText)findViewById(c.f.nickname_edit));
      this.WSa.setOnEditorActionListener(new TextView.OnEditorActionListener()
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
      this.WSa.setOnKeyListener(new View.OnKeyListener()
      {
        public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(79552);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          localb.sc(paramAnonymousInt);
          localb.cH(paramAnonymousKeyEvent);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/CreateAvatarUI$3", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.aYj());
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
      this.WSa.setHintTextColor(getResources().getColor(com.tencent.mm.plugin.webview.c.c.hint_text_color));
      this.WSa.addTextChangedListener(new TextWatcher()
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
      this.WSa.setOnTouchListener(new View.OnTouchListener()
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
      findViewById(c.f.choose_avatar_profile).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(79555);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/CreateAvatarUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          t.r(CreateAvatarUI.this, 4);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/CreateAvatarUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(79555);
        }
      });
      findViewById(c.f.random_info).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(79556);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/CreateAvatarUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          CreateAvatarUI.a(CreateAvatarUI.this, CreateAvatarUI.c(CreateAvatarUI.this));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/CreateAvatarUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(79556);
        }
      });
      findViewById(c.f.create_avatar_btn_save).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(79557);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/CreateAvatarUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          paramAnonymousView = CreateAvatarUI.b(CreateAvatarUI.this).getText().toString();
          localObject = com.tencent.mm.k.c.aRm();
          if ((!Util.isNullOrNil((String)localObject)) && (paramAnonymousView.matches(".*[" + (String)localObject + "].*")))
          {
            com.tencent.mm.ui.base.k.c(CreateAvatarUI.this.getContext(), CreateAvatarUI.this.getString(c.i.invalid_input_character_toast, new Object[] { localObject }), CreateAvatarUI.this.getString(c.i.app_tip), true);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/CreateAvatarUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(79557);
            return;
          }
          com.tencent.mm.ui.tools.b.c.i(CreateAvatarUI.b(CreateAvatarUI.this)).oF(1, 32).a(CreateAvatarUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/CreateAvatarUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(79557);
        }
      });
      paramBundle = getIntent();
      if ((paramBundle != null) && (paramBundle.getBooleanExtra("extra_call_by_appbrand", false))) {
        com.tencent.mm.plugin.webview.k.b.XsD.dQ(4, "");
      }
      AppMethodBeat.o(79559);
      return;
      setMMTitle(getString(c.i.new_sdk_oauth_login_create_avatar));
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(79562);
    super.onDestroy();
    if (this.lKp != null) {
      this.lKp.dismiss();
    }
    AppMethodBeat.o(79562);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(79561);
    super.onPause();
    com.tencent.mm.kernel.h.aZW().b(2500, this);
    com.tencent.mm.kernel.h.aZW().b(2785, this);
    com.tencent.mm.kernel.h.aZW().b(2667, this);
    AppMethodBeat.o(79561);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(79560);
    super.onResume();
    com.tencent.mm.kernel.h.aZW().a(2500, this);
    com.tencent.mm.kernel.h.aZW().a(2785, this);
    com.tencent.mm.kernel.h.aZW().a(2667, this);
    AppMethodBeat.o(79560);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(79570);
    if ((paramp instanceof i))
    {
      Log.i("MicroMsg.CreateAvatarUI", "onAddAvatarEnd errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      ddd();
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((cx)com.tencent.mm.am.c.c.b(((i)paramp).rr.otC)).YFf;
        paramp = new Intent();
        paramp.putExtra("id", paramString.id);
        paramp.putExtra("nickname", paramString.nickname);
        paramp.putExtra("avatarurl", paramString.rHi);
        setResult(-1, paramp);
        finish();
      }
      for (;;)
      {
        com.tencent.mm.plugin.webview.k.b.XsD.bt(6, (int)(System.currentTimeMillis() - this.WSh), paramInt2);
        AppMethodBeat.o(79570);
        return;
        if (!atJ(paramInt1)) {
          com.tencent.mm.ui.base.k.c(this, getString(c.i.wechat_auth_network_failed), getString(c.i.create_avatar_add_failed), true);
        } else {
          com.tencent.mm.ui.base.k.c(this, paramString, getString(c.i.create_avatar_add_failed), true);
        }
      }
    }
    if ((paramp instanceof com.tencent.mm.plugin.webview.model.p))
    {
      Log.i("MicroMsg.CreateAvatarUI", "onGetRandomAvatarEnd errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (cqo)com.tencent.mm.am.c.c.b(((com.tencent.mm.plugin.webview.model.p)paramp).rr.otC);
        paramp = new com.tencent.mm.modelimage.loader.a.c.a();
        paramp.oKB = c.h.default_avatar;
        paramp.oKI = getResources().getDimension(c.d.sdk_oauth_avatar_corners_size);
        paramp.nrc = true;
        r.bKe().a(paramString.rHi, (ImageView)findViewById(c.f.avatar_profile), paramp.bKx());
        this.WSa.setText(paramString.nickname);
        this.WSd = true;
        this.WSc = false;
        this.fileId = paramString.fileid;
        if (!this.WSa.getText().toString().equals("")) {
          findViewById(c.f.create_avatar_btn_save).setEnabled(true);
        }
      }
      for (;;)
      {
        com.tencent.mm.plugin.webview.k.b.XsD.bt(5, (int)(System.currentTimeMillis() - this.WSi), paramInt2);
        AppMethodBeat.o(79570);
        return;
        findViewById(c.f.create_avatar_btn_save).setEnabled(false);
        continue;
        if (!atJ(paramInt1)) {
          com.tencent.mm.ui.base.k.c(this, getString(c.i.wechat_auth_network_failed), getString(c.i.create_avatar_getrandom_failed), true);
        } else {
          com.tencent.mm.ui.base.k.c(this, paramString, getString(c.i.create_avatar_getrandom_failed), true);
        }
      }
    }
    if ((paramp instanceof com.tencent.mm.plugin.webview.model.k))
    {
      Log.i("MicroMsg.CreateAvatarUI", "onGetCreateAvatarEnd errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (this.WSe == null)
      {
        Log.e("MicroMsg.CreateAvatarUI", "uploadEngine == null, multi-Thread Error, thread name = " + Thread.currentThread().getName());
        AppMethodBeat.o(79570);
        return;
      }
      g localg = this.WSe;
      String str = ((com.tencent.mm.plugin.webview.model.k)paramp).AmC;
      if (!str.equals(localg.svg)) {
        Log.i("MicroMsg.VestImgUploadEngine", "currentPath=%s,callbackPath=%s, path updated after onSceneEnd", new Object[] { localg.svg, str });
      }
      while (this.WSg)
      {
        ddd();
        if (this.WSe.XsN != g.b.XsR)
        {
          ddd();
          if (!atJ(paramInt1))
          {
            ddd();
            com.tencent.mm.ui.base.k.c(this, getString(c.i.wechat_auth_network_failed), getString(c.i.create_avatar_add_failed), true);
            AppMethodBeat.o(79570);
            return;
            if ((paramInt1 == 0) && (paramInt2 == 0))
            {
              localg.XsN = g.b.XsR;
              paramp = (cv)com.tencent.mm.am.c.c.b(((com.tencent.mm.plugin.webview.model.k)paramp).rr.otC);
              localg.XsM.t(paramp.fileid);
              Log.i("MicroMsg.VestImgUploadEngine", "file id create success: %s", new Object[] { paramp.fileid });
            }
            else
            {
              localg.XsN = g.b.XsS;
              Log.i("MicroMsg.VestImgUploadEngine", "file id create failed: errType = %s, errCode = %s, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
            }
          }
          else
          {
            com.tencent.mm.ui.base.k.c(this, paramString, getString(c.i.create_avatar_add_failed), true);
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
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(296152);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(b.class);
    AppMethodBeat.o(296152);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.CreateAvatarUI
 * JD-Core Version:    0.7.0.1
 */