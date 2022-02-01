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
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.gallery.picker.view.ImageCropUI;
import com.tencent.mm.plugin.image.d;
import com.tencent.mm.plugin.webview.j.c.b;
import com.tencent.mm.plugin.webview.model.i;
import com.tencent.mm.protocal.protobuf.bhp;
import com.tencent.mm.protocal.protobuf.cd;
import com.tencent.mm.protocal.protobuf.cdx;
import com.tencent.mm.protocal.protobuf.cf;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import java.io.ByteArrayOutputStream;

public class CreateAvatarUI
  extends MMActivity
  implements f, com.tencent.mm.ui.tools.b.c.a
{
  private InputMethodManager EqG;
  private EditText EqH;
  private String EqI;
  private boolean EqJ = true;
  private boolean EqK = false;
  private volatile com.tencent.mm.plugin.webview.j.c EqL;
  private String EqM;
  private boolean EqN = false;
  private long EqO = 0L;
  private long EqP = 0L;
  private String appId;
  private com.tencent.mm.ui.base.p fSP;
  private String fileId;
  
  private boolean Xu(int paramInt)
  {
    AppMethodBeat.i(79571);
    if ((paramInt == 1) || (paramInt == 2) || (paramInt == 7) || (paramInt == 8))
    {
      ae.e("MicroMsg.CreateAvatarUI", "isNetworkAvailable false, errType = ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(79571);
      return false;
    }
    if (!az.isConnected(this))
    {
      ae.e("MicroMsg.CreateAvatarUI", "isNetworkAvailable false, not connected");
      AppMethodBeat.o(79571);
      return false;
    }
    AppMethodBeat.o(79571);
    return true;
  }
  
  private void aW(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(79569);
    ae.i("MicroMsg.CreateAvatarUI", "doAddAvatar appid: %s", new Object[] { paramString1 });
    bzQ();
    paramString1 = new i(paramString1, paramString2, paramString3);
    g.ajj().a(paramString1, 0);
    this.EqO = System.currentTimeMillis();
    AppMethodBeat.o(79569);
  }
  
  private static byte[] au(Bitmap paramBitmap)
  {
    AppMethodBeat.i(79566);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    com.tencent.mm.sdk.platformtools.h.a(paramBitmap, Bitmap.CompressFormat.JPEG, 85, localByteArrayOutputStream);
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
        ae.printErrStackTrace("MicroMsg.CreateAvatarUI", localException, "", new Object[0]);
      }
    }
  }
  
  private void bzQ()
  {
    AppMethodBeat.i(79572);
    if ((this.fSP != null) && (!this.fSP.isShowing()))
    {
      this.fSP.show();
      AppMethodBeat.o(79572);
      return;
    }
    this.fSP = com.tencent.mm.ui.base.h.b(this, getString(2131757962), true, new DialogInterface.OnCancelListener()
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
          ae.e("MicroMsg.CreateAvatarUI", "showProgressDlg onCancel exp: %s ", new Object[] { paramAnonymousDialogInterface.getLocalizedMessage() });
          AppMethodBeat.o(79550);
        }
      }
    });
    AppMethodBeat.o(79572);
  }
  
  private void eVx()
  {
    AppMethodBeat.i(79573);
    if (this.fSP == null)
    {
      AppMethodBeat.o(79573);
      return;
    }
    this.fSP.dismiss();
    AppMethodBeat.o(79573);
  }
  
  public final void Ky(String paramString)
  {
    AppMethodBeat.i(79563);
    this.EqN = true;
    if ((this.EqK) || (this.EqL == null) || (this.EqJ))
    {
      if ((this.fileId == null) || (this.fileId.isEmpty()))
      {
        Object localObject = com.tencent.mm.sdk.platformtools.h.b(com.tencent.mm.sdk.platformtools.h.aaZ(2131690013), 500, 500, false);
        String str = this.appId;
        localObject = au((Bitmap)localObject);
        ae.i("MicroMsg.CreateAvatarUI", "doAddAvatar appid: %s", new Object[] { str });
        bzQ();
        paramString = new i(str, paramString, (byte[])localObject);
        g.ajj().a(paramString, 0);
        this.EqO = System.currentTimeMillis();
        AppMethodBeat.o(79563);
        return;
      }
      aW(this.appId, paramString, this.fileId);
      AppMethodBeat.o(79563);
      return;
    }
    if (this.EqL.ELy == c.b.ELC)
    {
      aW(this.appId, paramString, this.EqM);
      AppMethodBeat.o(79563);
      return;
    }
    if (this.EqL.ELy == c.b.ELD)
    {
      bzQ();
      this.EqL.ln(this.EqI, this.appId);
      AppMethodBeat.o(79563);
      return;
    }
    bzQ();
    AppMethodBeat.o(79563);
  }
  
  public final void aUT()
  {
    AppMethodBeat.i(164020);
    com.tencent.mm.ui.base.h.l(this, 2131763296, 2131763299);
    AppMethodBeat.o(164020);
  }
  
  public final void cW(String paramString)
  {
    AppMethodBeat.i(164021);
    com.tencent.mm.ui.base.h.l(this, 2131763297, 2131763299);
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
                this.EqH.setCursorVisible(true);
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
        this.EqG = ((InputMethodManager)getSystemService("input_method"));
        if (this.EqG != null)
        {
          this.EqG.hideSoftInputFromWindow(localView.getWindowToken(), 0);
          this.EqH.setCursorVisible(false);
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
    ae.i("MicroMsg.CreateAvatarUI", "onAcvityResult requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 != -1)
    {
      ae.e("MicroMsg.CreateAvatarUI", "Get image from album failed");
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
      com.tencent.mm.aj.p.aEA();
      localIntent.putExtra("CropImage_OutputPath", e.K(v.aAC() + ".crop", true));
      localIntent.putExtra("CropImage_ImgPath", null);
      localIntent.putExtra("CropImage_from_scene", 3);
      com.tencent.mm.ui.tools.a.b(this, paramIntent, localIntent, d.azQ(), 5, null);
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
        ae.e("MicroMsg.CreateAvatarUI", "crop picture failed");
        AppMethodBeat.o(79567);
        return;
      }
      ae.i("MicroMsg.CreateAvatarUI", "onActivityResult(CROP_PICTURE_FOR_AVATAR)  file:%s, size:%d", new Object[] { paramIntent, Long.valueOf(new com.tencent.mm.vfs.k(paramIntent).length()) });
      this.EqI = paramIntent;
      this.EqN = false;
      this.EqJ = false;
      this.EqK = false;
      ((ImageView)findViewById(2131297014)).setImageBitmap(MMBitmapFactory.decodeFile(paramIntent));
      if (this.EqL == null)
      {
        this.EqL = new com.tencent.mm.plugin.webview.j.c();
        this.EqL.ELx.observe(this, new Observer() {});
      }
      this.EqM = null;
      this.EqL.ln(this.EqI, this.appId);
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
    this.EqH = ((EditText)findViewById(2131302866));
    this.EqH.setOnEditorActionListener(new TextView.OnEditorActionListener()
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
    this.EqH.setOnKeyListener(new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(79552);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        localb.mu(paramAnonymousInt);
        localb.bd(paramAnonymousKeyEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/CreateAvatarUI$3", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.ahF());
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
    this.EqH.setHintTextColor(getResources().getColor(2131100490));
    this.EqH.addTextChangedListener(new TextWatcher()
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
    this.EqH.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(79554);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/CreateAvatarUI$5", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
        if (paramAnonymousMotionEvent.getAction() == 0) {
          CreateAvatarUI.b(CreateAvatarUI.this).setCursorVisible(true);
        }
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/webview/ui/tools/CreateAvatarUI$5", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(79554);
        return false;
      }
    });
    findViewById(2131298268).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(79555);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/CreateAvatarUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        com.tencent.mm.pluginsdk.ui.tools.q.o(CreateAvatarUI.this, 4);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/CreateAvatarUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(79555);
      }
    });
    findViewById(2131303927).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(79556);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/CreateAvatarUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        CreateAvatarUI.a(CreateAvatarUI.this, CreateAvatarUI.c(CreateAvatarUI.this));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/CreateAvatarUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(79556);
      }
    });
    findViewById(2131303932).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(79557);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/CreateAvatarUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        CreateAvatarUI.a(CreateAvatarUI.this, CreateAvatarUI.c(CreateAvatarUI.this));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/CreateAvatarUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(79557);
      }
    });
    findViewById(2131298853).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(79558);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/CreateAvatarUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        paramAnonymousView = CreateAvatarUI.b(CreateAvatarUI.this).getText().toString();
        localObject = com.tencent.mm.n.b.acu();
        if ((!bu.isNullOrNil((String)localObject)) && (paramAnonymousView.matches(".*[" + (String)localObject + "].*")))
        {
          com.tencent.mm.ui.base.h.c(CreateAvatarUI.this.getContext(), CreateAvatarUI.this.getString(2131760350, new Object[] { localObject }), CreateAvatarUI.this.getString(2131755906), true);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/CreateAvatarUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(79558);
          return;
        }
        com.tencent.mm.ui.tools.b.c.d(CreateAvatarUI.b(CreateAvatarUI.this)).kj(1, 32).a(CreateAvatarUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/CreateAvatarUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(79558);
      }
    });
    paramBundle = getIntent();
    if ((paramBundle != null) && (paramBundle.getBooleanExtra("extra_call_by_appbrand", false))) {
      com.tencent.mm.plugin.webview.j.b.ELt.cH(4, "");
    }
    AppMethodBeat.o(79559);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(79562);
    super.onDestroy();
    if (this.fSP != null) {
      this.fSP.dismiss();
    }
    AppMethodBeat.o(79562);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(79561);
    super.onPause();
    g.ajj().b(2500, this);
    g.ajj().b(2785, this);
    g.ajj().b(2667, this);
    AppMethodBeat.o(79561);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(79560);
    super.onResume();
    g.ajj().a(2500, this);
    g.ajj().a(2785, this);
    g.ajj().a(2667, this);
    AppMethodBeat.o(79560);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(79570);
    if ((paramn instanceof i))
    {
      ae.i("MicroMsg.CreateAvatarUI", "onAddAvatarEnd errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      eVx();
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((cf)((i)paramn).rr.hQE.hQJ).FNe;
        paramn = new Intent();
        paramn.putExtra("id", paramString.id);
        paramn.putExtra("nickname", paramString.nickname);
        paramn.putExtra("avatarurl", paramString.kDl);
        setResult(-1, paramn);
        finish();
      }
      for (;;)
      {
        com.tencent.mm.plugin.webview.j.b.ELt.aG(6, (int)(System.currentTimeMillis() - this.EqO), paramInt2);
        AppMethodBeat.o(79570);
        return;
        if (!Xu(paramInt1)) {
          com.tencent.mm.ui.base.h.c(this, getString(2131766179), getString(2131757955), true);
        } else {
          com.tencent.mm.ui.base.h.c(this, paramString, getString(2131757955), true);
        }
      }
    }
    if ((paramn instanceof com.tencent.mm.plugin.webview.model.p))
    {
      ae.i("MicroMsg.CreateAvatarUI", "onGetRandomAvatarEnd errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (bhp)((com.tencent.mm.plugin.webview.model.p)paramn).rr.hQE.hQJ;
        paramn = new com.tencent.mm.av.a.a.c.a();
        paramn.igv = 2131690013;
        paramn.igC = getResources().getDimension(2131166775);
        paramn.hhW = true;
        com.tencent.mm.av.q.aJb().a(paramString.kDl, (ImageView)findViewById(2131297014), paramn.aJu());
        this.EqH.setText(paramString.nickname);
        this.EqK = true;
        this.EqJ = false;
        this.fileId = paramString.fileid;
        if (!this.EqH.getText().toString().equals("")) {
          findViewById(2131298853).setEnabled(true);
        }
      }
      for (;;)
      {
        com.tencent.mm.plugin.webview.j.b.ELt.aG(5, (int)(System.currentTimeMillis() - this.EqP), paramInt2);
        AppMethodBeat.o(79570);
        return;
        findViewById(2131298853).setEnabled(false);
        continue;
        if (!Xu(paramInt1)) {
          com.tencent.mm.ui.base.h.c(this, getString(2131766179), getString(2131757957), true);
        } else {
          com.tencent.mm.ui.base.h.c(this, paramString, getString(2131757957), true);
        }
      }
    }
    if ((paramn instanceof com.tencent.mm.plugin.webview.model.k))
    {
      ae.i("MicroMsg.CreateAvatarUI", "onGetCreateAvatarEnd errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (this.EqL == null)
      {
        ae.e("MicroMsg.CreateAvatarUI", "uploadEngine == null, multi-Thread Error, thread name = " + Thread.currentThread().getName());
        AppMethodBeat.o(79570);
        return;
      }
      com.tencent.mm.plugin.webview.j.c localc = this.EqL;
      String str = ((com.tencent.mm.plugin.webview.model.k)paramn).rJY;
      if (!str.equals(localc.lmo)) {
        ae.i("MicroMsg.VestImgUploadEngine", "currentPath=%s,callbackPath=%s, path updated after onSceneEnd", new Object[] { localc.lmo, str });
      }
      while (this.EqN)
      {
        eVx();
        if (this.EqL.ELy != c.b.ELC)
        {
          eVx();
          if (!Xu(paramInt1))
          {
            eVx();
            com.tencent.mm.ui.base.h.c(this, getString(2131766179), getString(2131757955), true);
            AppMethodBeat.o(79570);
            return;
            if ((paramInt1 == 0) && (paramInt2 == 0))
            {
              localc.ELy = c.b.ELC;
              paramn = (cd)((com.tencent.mm.plugin.webview.model.k)paramn).rr.hQE.hQJ;
              localc.ELx.postValue(paramn.fileid);
              ae.i("MicroMsg.VestImgUploadEngine", "file id create success: %s", new Object[] { paramn.fileid });
            }
            else
            {
              localc.ELy = c.b.ELD;
              ae.i("MicroMsg.VestImgUploadEngine", "file id create failed: errType = %s, errCode = %s, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
            }
          }
          else
          {
            com.tencent.mm.ui.base.h.c(this, paramString, getString(2131757955), true);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.CreateAvatarUI
 * JD-Core Version:    0.7.0.1
 */