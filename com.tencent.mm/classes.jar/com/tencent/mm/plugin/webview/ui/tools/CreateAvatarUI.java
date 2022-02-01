package com.tencent.mm.plugin.webview.ui.tools;

import android.app.Activity;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.aw.o;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.gallery.picker.view.ImageCropUI;
import com.tencent.mm.plugin.image.d;
import com.tencent.mm.plugin.webview.j.c.b;
import com.tencent.mm.plugin.webview.model.i;
import com.tencent.mm.plugin.webview.model.k;
import com.tencent.mm.protocal.protobuf.azb;
import com.tencent.mm.protocal.protobuf.btv;
import com.tencent.mm.protocal.protobuf.cb;
import com.tencent.mm.protocal.protobuf.cd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.io.ByteArrayOutputStream;

public class CreateAvatarUI
  extends MMActivity
  implements com.tencent.mm.al.g, com.tencent.mm.ui.tools.b.c.a
{
  private InputMethodManager BcL;
  private EditText BcM;
  private String BcN;
  private boolean BcO = true;
  private boolean BcP = false;
  private volatile com.tencent.mm.plugin.webview.j.c BcQ;
  private String BcR;
  private boolean BcS = false;
  private long BcT = 0L;
  private long BcU = 0L;
  private String appId;
  private String fileId;
  private com.tencent.mm.ui.base.p ftP;
  
  private boolean SP(int paramInt)
  {
    AppMethodBeat.i(79571);
    if ((paramInt == 1) || (paramInt == 2) || (paramInt == 7) || (paramInt == 8))
    {
      ad.e("MicroMsg.CreateAvatarUI", "isNetworkAvailable false, errType = ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(79571);
      return false;
    }
    if (!ay.isConnected(this))
    {
      ad.e("MicroMsg.CreateAvatarUI", "isNetworkAvailable false, not connected");
      AppMethodBeat.o(79571);
      return false;
    }
    AppMethodBeat.o(79571);
    return true;
  }
  
  private void aK(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(79569);
    ad.i("MicroMsg.CreateAvatarUI", "doAddAvatar appid: %s", new Object[] { paramString1 });
    bnU();
    paramString1 = new i(paramString1, paramString2, paramString3);
    com.tencent.mm.kernel.g.aeS().a(paramString1, 0);
    this.BcT = System.currentTimeMillis();
    AppMethodBeat.o(79569);
  }
  
  private static byte[] aq(Bitmap paramBitmap)
  {
    AppMethodBeat.i(79566);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    f.a(paramBitmap, Bitmap.CompressFormat.JPEG, 85, localByteArrayOutputStream);
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
        ad.printErrStackTrace("MicroMsg.CreateAvatarUI", localException, "", new Object[0]);
      }
    }
  }
  
  private void bnU()
  {
    AppMethodBeat.i(79572);
    if ((this.ftP != null) && (!this.ftP.isShowing()))
    {
      this.ftP.show();
      AppMethodBeat.o(79572);
      return;
    }
    this.ftP = h.b(this, getString(2131757962), true, new DialogInterface.OnCancelListener()
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
          ad.e("MicroMsg.CreateAvatarUI", "showProgressDlg onCancel exp: %s ", new Object[] { paramAnonymousDialogInterface.getLocalizedMessage() });
          AppMethodBeat.o(79550);
        }
      }
    });
    AppMethodBeat.o(79572);
  }
  
  private void enB()
  {
    AppMethodBeat.i(79573);
    if (this.ftP == null)
    {
      AppMethodBeat.o(79573);
      return;
    }
    this.ftP.dismiss();
    AppMethodBeat.o(79573);
  }
  
  public final void CH(String paramString)
  {
    AppMethodBeat.i(79563);
    this.BcS = true;
    if ((this.BcP) || (this.BcQ == null) || (this.BcO))
    {
      if ((this.fileId == null) || (this.fileId.isEmpty()))
      {
        Object localObject = f.b(f.Wf(2131690013), 500, 500, false);
        String str = this.appId;
        localObject = aq((Bitmap)localObject);
        ad.i("MicroMsg.CreateAvatarUI", "doAddAvatar appid: %s", new Object[] { str });
        bnU();
        paramString = new i(str, paramString, (byte[])localObject);
        com.tencent.mm.kernel.g.aeS().a(paramString, 0);
        this.BcT = System.currentTimeMillis();
        AppMethodBeat.o(79563);
        return;
      }
      aK(this.appId, paramString, this.fileId);
      AppMethodBeat.o(79563);
      return;
    }
    if (this.BcQ.BwW == c.b.Bxa)
    {
      aK(this.appId, paramString, this.BcR);
      AppMethodBeat.o(79563);
      return;
    }
    if (this.BcQ.BwW == c.b.Bxb)
    {
      bnU();
      this.BcQ.kn(this.BcN, this.appId);
      AppMethodBeat.o(79563);
      return;
    }
    bnU();
    AppMethodBeat.o(79563);
  }
  
  public final void aKr()
  {
    AppMethodBeat.i(164020);
    h.j(this, 2131763296, 2131763299);
    AppMethodBeat.o(164020);
  }
  
  public final void ck(String paramString)
  {
    AppMethodBeat.i(164021);
    h.j(this, 2131763297, 2131763299);
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
                this.BcM.setCursorVisible(true);
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
        this.BcL = ((InputMethodManager)getSystemService("input_method"));
        if (this.BcL != null)
        {
          this.BcL.hideSoftInputFromWindow(localView.getWindowToken(), 0);
          this.BcM.setCursorVisible(false);
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
    return 2131493672;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(79567);
    ad.i("MicroMsg.CreateAvatarUI", "onAcvityResult requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 != -1)
    {
      ad.e("MicroMsg.CreateAvatarUI", "Get image from album failed");
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
      com.tencent.mm.ak.p.auq();
      localIntent.putExtra("CropImage_OutputPath", com.tencent.mm.ak.e.J(u.aqG() + ".crop", true));
      localIntent.putExtra("CropImage_ImgPath", null);
      localIntent.putExtra("CropImage_from_scene", 3);
      com.tencent.mm.ui.tools.a.b(this, paramIntent, localIntent, d.apW(), 5, null);
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
        ad.e("MicroMsg.CreateAvatarUI", "crop picture failed");
        AppMethodBeat.o(79567);
        return;
      }
      ad.i("MicroMsg.CreateAvatarUI", "onActivityResult(CROP_PICTURE_FOR_AVATAR)  file:%s, size:%d", new Object[] { paramIntent, Long.valueOf(new com.tencent.mm.vfs.e(paramIntent).length()) });
      this.BcN = paramIntent;
      this.BcS = false;
      this.BcO = false;
      this.BcP = false;
      ((ImageView)findViewById(2131297014)).setImageBitmap(MMBitmapFactory.decodeFile(paramIntent));
      if (this.BcQ == null)
      {
        this.BcQ = new com.tencent.mm.plugin.webview.j.c();
        this.BcQ.BwV.observe(this, new Observer() {});
      }
      this.BcR = null;
      this.BcQ.kn(this.BcN, this.appId);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(79559);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(2131101179));
    hideActionbarLine();
    setMMTitle(getString(2131757963));
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
    this.BcM = ((EditText)findViewById(2131302866));
    this.BcM.setOnEditorActionListener(new TextView.OnEditorActionListener()
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
    this.BcM.setOnKeyListener(new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(79552);
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
        AppMethodBeat.o(79552);
        return false;
      }
    });
    this.BcM.setHintTextColor(getResources().getColor(2131100490));
    this.BcM.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(79553);
        if (!CreateAvatarUI.b(CreateAvatarUI.this).getText().toString().equals(""))
        {
          CreateAvatarUI.this.findViewById(2131298853).setEnabled(true);
          AppMethodBeat.o(79553);
          return;
        }
        CreateAvatarUI.this.findViewById(2131298853).setEnabled(false);
        AppMethodBeat.o(79553);
      }
    });
    this.BcM.setOnTouchListener(new View.OnTouchListener()
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
    findViewById(2131298268).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(79555);
        com.tencent.mm.pluginsdk.ui.tools.q.o(CreateAvatarUI.this, 4);
        AppMethodBeat.o(79555);
      }
    });
    findViewById(2131303927).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(79556);
        CreateAvatarUI.a(CreateAvatarUI.this, CreateAvatarUI.c(CreateAvatarUI.this));
        AppMethodBeat.o(79556);
      }
    });
    findViewById(2131303932).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(79557);
        CreateAvatarUI.a(CreateAvatarUI.this, CreateAvatarUI.c(CreateAvatarUI.this));
        AppMethodBeat.o(79557);
      }
    });
    findViewById(2131298853).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(79558);
        paramAnonymousView = CreateAvatarUI.b(CreateAvatarUI.this).getText().toString();
        String str = com.tencent.mm.m.b.YL();
        if ((!bt.isNullOrNil(str)) && (paramAnonymousView.matches(".*[" + str + "].*")))
        {
          h.c(CreateAvatarUI.this.getContext(), CreateAvatarUI.this.getString(2131760350, new Object[] { str }), CreateAvatarUI.this.getString(2131755906), true);
          AppMethodBeat.o(79558);
          return;
        }
        com.tencent.mm.ui.tools.b.c.d(CreateAvatarUI.b(CreateAvatarUI.this)).jE(1, 32).a(CreateAvatarUI.this);
        AppMethodBeat.o(79558);
      }
    });
    paramBundle = getIntent();
    if ((paramBundle != null) && (paramBundle.getBooleanExtra("extra_call_by_appbrand", false))) {
      com.tencent.mm.plugin.webview.j.b.BwR.cy(4, "");
    }
    AppMethodBeat.o(79559);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(79562);
    super.onDestroy();
    if (this.ftP != null) {
      this.ftP.dismiss();
    }
    AppMethodBeat.o(79562);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(79561);
    super.onPause();
    com.tencent.mm.kernel.g.aeS().b(2500, this);
    com.tencent.mm.kernel.g.aeS().b(2785, this);
    com.tencent.mm.kernel.g.aeS().b(2667, this);
    AppMethodBeat.o(79561);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(79560);
    super.onResume();
    com.tencent.mm.kernel.g.aeS().a(2500, this);
    com.tencent.mm.kernel.g.aeS().a(2785, this);
    com.tencent.mm.kernel.g.aeS().a(2667, this);
    AppMethodBeat.o(79560);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(79570);
    if ((paramn instanceof i))
    {
      ad.i("MicroMsg.CreateAvatarUI", "onAddAvatarEnd errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      enB();
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((cd)((i)paramn).rr.gUT.gUX).Cxa;
        paramn = new Intent();
        paramn.putExtra("id", paramString.id);
        paramn.putExtra("nickname", paramString.nickname);
        paramn.putExtra("avatarurl", paramString.jEL);
        setResult(-1, paramn);
        finish();
      }
      for (;;)
      {
        com.tencent.mm.plugin.webview.j.b.BwR.aC(6, (int)(System.currentTimeMillis() - this.BcT), paramInt2);
        AppMethodBeat.o(79570);
        return;
        if (!SP(paramInt1)) {
          h.c(this, getString(2131766179), getString(2131757955), true);
        } else {
          h.c(this, paramString, getString(2131757955), true);
        }
      }
    }
    if ((paramn instanceof com.tencent.mm.plugin.webview.model.p))
    {
      ad.i("MicroMsg.CreateAvatarUI", "onGetRandomAvatarEnd errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (azb)((com.tencent.mm.plugin.webview.model.p)paramn).rr.gUT.gUX;
        paramn = new com.tencent.mm.aw.a.a.c.a();
        paramn.hkf = 2131690013;
        paramn.hkm = getResources().getDimension(2131166775);
        paramn.gkG = true;
        o.ayJ().a(paramString.jEL, (ImageView)findViewById(2131297014), paramn.azc());
        this.BcM.setText(paramString.nickname);
        this.BcP = true;
        this.BcO = false;
        this.fileId = paramString.fileid;
        if (!this.BcM.getText().toString().equals("")) {
          findViewById(2131298853).setEnabled(true);
        }
      }
      for (;;)
      {
        com.tencent.mm.plugin.webview.j.b.BwR.aC(5, (int)(System.currentTimeMillis() - this.BcU), paramInt2);
        AppMethodBeat.o(79570);
        return;
        findViewById(2131298853).setEnabled(false);
        continue;
        if (!SP(paramInt1)) {
          h.c(this, getString(2131766179), getString(2131757957), true);
        } else {
          h.c(this, paramString, getString(2131757957), true);
        }
      }
    }
    if ((paramn instanceof k))
    {
      ad.i("MicroMsg.CreateAvatarUI", "onGetCreateAvatarEnd errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (this.BcQ == null)
      {
        ad.e("MicroMsg.CreateAvatarUI", "uploadEngine == null, multi-Thread Error, thread name = " + Thread.currentThread().getName());
        AppMethodBeat.o(79570);
        return;
      }
      com.tencent.mm.plugin.webview.j.c localc = this.BcQ;
      String str = ((k)paramn).qjl;
      if (!str.equals(localc.kkH)) {
        ad.i("MicroMsg.VestImgUploadEngine", "currentPath=%s,callbackPath=%s, path updated after onSceneEnd", new Object[] { localc.kkH, str });
      }
      while (this.BcS)
      {
        enB();
        if (this.BcQ.BwW != c.b.Bxa)
        {
          enB();
          if (!SP(paramInt1))
          {
            enB();
            h.c(this, getString(2131766179), getString(2131757955), true);
            AppMethodBeat.o(79570);
            return;
            if ((paramInt1 == 0) && (paramInt2 == 0))
            {
              localc.BwW = c.b.Bxa;
              paramn = (cb)((k)paramn).rr.gUT.gUX;
              localc.BwV.postValue(paramn.fileid);
              ad.i("MicroMsg.VestImgUploadEngine", "file id create success: %s", new Object[] { paramn.fileid });
            }
            else
            {
              localc.BwW = c.b.Bxb;
              ad.i("MicroMsg.VestImgUploadEngine", "file id create failed: errType = %s, errCode = %s, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
            }
          }
          else
          {
            h.c(this, paramString, getString(2131757955), true);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.CreateAvatarUI
 * JD-Core Version:    0.7.0.1
 */