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
import com.tencent.mm.aj.e;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.t;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.gallery.picker.view.ImageCropUI;
import com.tencent.mm.plugin.webview.k.c.b;
import com.tencent.mm.plugin.webview.model.k;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.protocal.protobuf.btn;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.protocal.protobuf.co;
import com.tencent.mm.protocal.protobuf.cue;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.o;
import java.io.ByteArrayOutputStream;

public class CreateAvatarUI
  extends MMActivity
  implements com.tencent.mm.ak.i, com.tencent.mm.ui.tools.b.c.a
{
  private InputMethodManager JdP;
  private EditText JdQ;
  private String JdR;
  private boolean JdS = true;
  private boolean JdT = false;
  private volatile com.tencent.mm.plugin.webview.k.c JdU;
  private String JdV;
  private boolean JdW = false;
  private long JdX = 0L;
  private long JdY = 0L;
  private String appId;
  private String fileId;
  private com.tencent.mm.ui.base.q gxX;
  
  private static byte[] aH(Bitmap paramBitmap)
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
  
  private boolean agc(int paramInt)
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
  
  private void bWL()
  {
    AppMethodBeat.i(79572);
    if ((this.gxX != null) && (!this.gxX.isShowing()))
    {
      this.gxX.show();
      AppMethodBeat.o(79572);
      return;
    }
    this.gxX = h.a(this, getString(2131758211), true, new DialogInterface.OnCancelListener()
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
  
  private void bg(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(79569);
    Log.i("MicroMsg.CreateAvatarUI", "doAddAvatar appid: %s", new Object[] { paramString1 });
    bWL();
    paramString1 = new com.tencent.mm.plugin.webview.model.i(paramString1, paramString2, paramString3);
    g.azz().a(paramString1, 0);
    this.JdX = System.currentTimeMillis();
    AppMethodBeat.o(79569);
  }
  
  private void gep()
  {
    AppMethodBeat.i(79573);
    if (this.gxX == null)
    {
      AppMethodBeat.o(79573);
      return;
    }
    this.gxX.dismiss();
    AppMethodBeat.o(79573);
  }
  
  public final void Tw(String paramString)
  {
    AppMethodBeat.i(79563);
    this.JdW = true;
    if ((this.JdT) || (this.JdU == null) || (this.JdS))
    {
      if ((this.fileId == null) || (this.fileId.isEmpty()))
      {
        Object localObject = BitmapUtil.getCenterCropBitmap(BitmapUtil.getBitmapNative(2131690042), 500, 500, false);
        String str = this.appId;
        localObject = aH((Bitmap)localObject);
        Log.i("MicroMsg.CreateAvatarUI", "doAddAvatar appid: %s", new Object[] { str });
        bWL();
        paramString = new com.tencent.mm.plugin.webview.model.i(str, paramString, (byte[])localObject);
        g.azz().a(paramString, 0);
        this.JdX = System.currentTimeMillis();
        AppMethodBeat.o(79563);
        return;
      }
      bg(this.appId, paramString, this.fileId);
      AppMethodBeat.o(79563);
      return;
    }
    if (this.JdU.JBp == c.b.JBt)
    {
      bg(this.appId, paramString, this.JdV);
      AppMethodBeat.o(79563);
      return;
    }
    if (this.JdU.JBp == c.b.JBu)
    {
      bWL();
      this.JdU.mm(this.JdR, this.appId);
      AppMethodBeat.o(79563);
      return;
    }
    bWL();
    AppMethodBeat.o(79563);
  }
  
  public final void Tx(String paramString)
  {
    AppMethodBeat.i(211039);
    h.n(this, 2131765471, 2131765474);
    AppMethodBeat.o(211039);
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
                this.JdQ.setCursorVisible(true);
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
        this.JdP = ((InputMethodManager)getSystemService("input_method"));
        if (this.JdP != null)
        {
          this.JdP.hideSoftInputFromWindow(localView.getWindowToken(), 0);
          this.JdQ.setCursorVisible(false);
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
  
  public final void dv(String paramString)
  {
    AppMethodBeat.i(164021);
    h.n(this, 2131765472, 2131765474);
    AppMethodBeat.o(164021);
  }
  
  public int getLayoutId()
  {
    return 2131493803;
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
      com.tencent.mm.aj.p.aYn();
      localIntent.putExtra("CropImage_OutputPath", e.M(z.aTY() + ".crop", true));
      localIntent.putExtra("CropImage_ImgPath", null);
      localIntent.putExtra("CropImage_from_scene", 3);
      com.tencent.mm.ui.tools.a.b(this, paramIntent, localIntent, com.tencent.mm.plugin.image.d.aSY(), 5, null);
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
      Log.i("MicroMsg.CreateAvatarUI", "onActivityResult(CROP_PICTURE_FOR_AVATAR)  file:%s, size:%d", new Object[] { paramIntent, Long.valueOf(new o(paramIntent).length()) });
      this.JdR = paramIntent;
      this.JdW = false;
      this.JdS = false;
      this.JdT = false;
      ((ImageView)findViewById(2131297141)).setImageBitmap(MMBitmapFactory.decodeFile(paramIntent));
      if (this.JdU == null)
      {
        this.JdU = new com.tencent.mm.plugin.webview.k.c();
        this.JdU.JBo.observe(this, new Observer() {});
      }
      this.JdV = null;
      this.JdU.mm(this.JdR, this.appId);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(79559);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(2131101424));
    hideActionbarLine();
    setMMTitle(getString(2131758212));
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
    this.JdQ = ((EditText)findViewById(2131305439));
    this.JdQ.setOnEditorActionListener(new TextView.OnEditorActionListener()
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
    this.JdQ.setOnKeyListener(new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(79552);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        localb.pH(paramAnonymousInt);
        localb.bm(paramAnonymousKeyEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/CreateAvatarUI$3", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.axR());
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
    this.JdQ.setHintTextColor(getResources().getColor(2131100594));
    this.JdQ.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(79553);
        if (!CreateAvatarUI.b(CreateAvatarUI.this).getText().toString().equals(""))
        {
          CreateAvatarUI.this.findViewById(2131299319).setEnabled(true);
          AppMethodBeat.o(79553);
          return;
        }
        CreateAvatarUI.this.findViewById(2131299319).setEnabled(false);
        AppMethodBeat.o(79553);
      }
    });
    this.JdQ.setOnTouchListener(new View.OnTouchListener()
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
    findViewById(2131298654).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(79555);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/CreateAvatarUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        s.o(CreateAvatarUI.this, 4);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/CreateAvatarUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(79555);
      }
    });
    findViewById(2131306776).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(79556);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/CreateAvatarUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        CreateAvatarUI.a(CreateAvatarUI.this, CreateAvatarUI.c(CreateAvatarUI.this));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/CreateAvatarUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(79556);
      }
    });
    findViewById(2131306781).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(79557);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/CreateAvatarUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        CreateAvatarUI.a(CreateAvatarUI.this, CreateAvatarUI.c(CreateAvatarUI.this));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/CreateAvatarUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(79557);
      }
    });
    findViewById(2131299319).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(79558);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/CreateAvatarUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        paramAnonymousView = CreateAvatarUI.b(CreateAvatarUI.this).getText().toString();
        localObject = com.tencent.mm.n.c.aqt();
        if ((!Util.isNullOrNil((String)localObject)) && (paramAnonymousView.matches(".*[" + (String)localObject + "].*")))
        {
          h.c(CreateAvatarUI.this.getContext(), CreateAvatarUI.this.getString(2131761795, new Object[] { localObject }), CreateAvatarUI.this.getString(2131755998), true);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/CreateAvatarUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(79558);
          return;
        }
        com.tencent.mm.ui.tools.b.c.f(CreateAvatarUI.b(CreateAvatarUI.this)).lv(1, 32).a(CreateAvatarUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/CreateAvatarUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(79558);
      }
    });
    paramBundle = getIntent();
    if ((paramBundle != null) && (paramBundle.getBooleanExtra("extra_call_by_appbrand", false))) {
      com.tencent.mm.plugin.webview.k.b.JBk.da(4, "");
    }
    AppMethodBeat.o(79559);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(79562);
    super.onDestroy();
    if (this.gxX != null) {
      this.gxX.dismiss();
    }
    AppMethodBeat.o(79562);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(79561);
    super.onPause();
    g.azz().b(2500, this);
    g.azz().b(2785, this);
    g.azz().b(2667, this);
    AppMethodBeat.o(79561);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(79560);
    super.onResume();
    g.azz().a(2500, this);
    g.azz().a(2785, this);
    g.azz().a(2667, this);
    AppMethodBeat.o(79560);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(79570);
    if ((paramq instanceof com.tencent.mm.plugin.webview.model.i))
    {
      Log.i("MicroMsg.CreateAvatarUI", "onAddAvatarEnd errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      gep();
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((co)((com.tencent.mm.plugin.webview.model.i)paramq).rr.iLL.iLR).KGJ;
        paramq = new Intent();
        paramq.putExtra("id", paramString.id);
        paramq.putExtra("nickname", paramString.nickname);
        paramq.putExtra("avatarurl", paramString.lHM);
        setResult(-1, paramq);
        finish();
      }
      for (;;)
      {
        com.tencent.mm.plugin.webview.k.b.JBk.aO(6, (int)(System.currentTimeMillis() - this.JdX), paramInt2);
        AppMethodBeat.o(79570);
        return;
        if (!agc(paramInt1)) {
          h.c(this, getString(2131768655), getString(2131758204), true);
        } else {
          h.c(this, paramString, getString(2131758204), true);
        }
      }
    }
    if ((paramq instanceof com.tencent.mm.plugin.webview.model.p))
    {
      Log.i("MicroMsg.CreateAvatarUI", "onGetRandomAvatarEnd errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (btn)((com.tencent.mm.plugin.webview.model.p)paramq).rr.iLL.iLR;
        paramq = new com.tencent.mm.av.a.a.c.a();
        paramq.jbq = 2131690042;
        paramq.jbx = getResources().getDimension(2131166898);
        paramq.iaT = true;
        com.tencent.mm.av.q.bcV().a(paramString.lHM, (ImageView)findViewById(2131297141), paramq.bdv());
        this.JdQ.setText(paramString.nickname);
        this.JdT = true;
        this.JdS = false;
        this.fileId = paramString.fileid;
        if (!this.JdQ.getText().toString().equals("")) {
          findViewById(2131299319).setEnabled(true);
        }
      }
      for (;;)
      {
        com.tencent.mm.plugin.webview.k.b.JBk.aO(5, (int)(System.currentTimeMillis() - this.JdY), paramInt2);
        AppMethodBeat.o(79570);
        return;
        findViewById(2131299319).setEnabled(false);
        continue;
        if (!agc(paramInt1)) {
          h.c(this, getString(2131768655), getString(2131758206), true);
        } else {
          h.c(this, paramString, getString(2131758206), true);
        }
      }
    }
    if ((paramq instanceof k))
    {
      Log.i("MicroMsg.CreateAvatarUI", "onGetCreateAvatarEnd errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (this.JdU == null)
      {
        Log.e("MicroMsg.CreateAvatarUI", "uploadEngine == null, multi-Thread Error, thread name = " + Thread.currentThread().getName());
        AppMethodBeat.o(79570);
        return;
      }
      com.tencent.mm.plugin.webview.k.c localc = this.JdU;
      String str = ((k)paramq).tjJ;
      if (!str.equals(localc.msl)) {
        Log.i("MicroMsg.VestImgUploadEngine", "currentPath=%s,callbackPath=%s, path updated after onSceneEnd", new Object[] { localc.msl, str });
      }
      while (this.JdW)
      {
        gep();
        if (this.JdU.JBp != c.b.JBt)
        {
          gep();
          if (!agc(paramInt1))
          {
            gep();
            h.c(this, getString(2131768655), getString(2131758204), true);
            AppMethodBeat.o(79570);
            return;
            if ((paramInt1 == 0) && (paramInt2 == 0))
            {
              localc.JBp = c.b.JBt;
              paramq = (cm)((k)paramq).rr.iLL.iLR;
              localc.JBo.postValue(paramq.fileid);
              Log.i("MicroMsg.VestImgUploadEngine", "file id create success: %s", new Object[] { paramq.fileid });
            }
            else
            {
              localc.JBp = c.b.JBu;
              Log.i("MicroMsg.VestImgUploadEngine", "file id create failed: errType = %s, errCode = %s, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
            }
          }
          else
          {
            h.c(this, paramString, getString(2131758204), true);
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