package com.tencent.mm.pluginsdk.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;

public class BioHelperUI
  extends MMActivity
{
  private String Kbn;
  private b Kbo;
  private String gwF;
  private String mRa;
  private int mType;
  private String mWording;
  private int rxv;
  
  public int getLayoutId()
  {
    return 2131493234;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool = true;
    AppMethodBeat.i(128843);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent == null) {}
    for (;;)
    {
      Log.i("MicroMsg.BioHelperUI", "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      this.Kbo.h(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(128843);
      return;
      bool = false;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Object localObject = null;
    AppMethodBeat.i(128842);
    super.onCreate(paramBundle);
    this.mType = getIntent().getIntExtra("k_type", 1);
    Log.i("MicroMsg.BioHelperUI", "hy: starting to bio helper ui, type: %d", new Object[] { Integer.valueOf(this.mType) });
    this.mRa = Util.nullAs(getIntent().getStringExtra("Kusername"), null);
    this.gwF = Util.nullAs(getIntent().getStringExtra("Kvertify_key"), null);
    this.Kbn = Util.nullAs(getIntent().getStringExtra("KVoiceHelpUrl"), null);
    this.mWording = Util.nullAs(getIntent().getStringExtra("KVoiceHelpWording"), null);
    this.rxv = getIntent().getIntExtra("KVoiceHelpCode", 0);
    if (this.mType == 0) {
      paramBundle = new c((byte)0);
    }
    for (;;)
    {
      this.Kbo = paramBundle;
      if ((this.Kbo != null) && (!Util.isNullOrNil(this.mRa)) && (!Util.isNullOrNil(this.gwF))) {
        break;
      }
      Log.w("MicroMsg.BioHelperUI", "type or username or ticket is null and finish");
      finish();
      AppMethodBeat.o(128842);
      return;
      if (this.mType == 1)
      {
        paramBundle = new a((byte)0);
      }
      else
      {
        Log.e("MicroMsg.BioHelperUI", "hy: invalid type!!!");
        paramBundle = localObject;
      }
    }
    paramBundle = (TextView)findViewById(2131297430);
    if (!Util.isNullOrNil(this.mWording)) {
      paramBundle.setText(this.mWording);
    }
    for (;;)
    {
      setMMTitle(this.Kbo.goy());
      ((ImageView)findViewById(2131297428)).setImageResource(this.Kbo.goz());
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(128828);
          BioHelperUI.this.finish();
          AppMethodBeat.o(128828);
          return true;
        }
      });
      this.Kbo.bo(getIntent());
      paramBundle = (Button)findViewById(2131297431);
      paramBundle.setText(this.Kbo.goA());
      paramBundle.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128829);
          b localb = new b();
          localb.bm(paramAnonymousView);
          a.b("com/tencent/mm/pluginsdk/ui/BioHelperUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          BioHelperUI.a(BioHelperUI.this).iy(BioHelperUI.this);
          a.a(this, "com/tencent/mm/pluginsdk/ui/BioHelperUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(128829);
        }
      });
      findViewById(2131297429).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128830);
          b localb = new b();
          localb.bm(paramAnonymousView);
          a.b("com/tencent/mm/pluginsdk/ui/BioHelperUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("rawUrl", BioHelperUI.b(BioHelperUI.this));
          paramAnonymousView.putExtra("showShare", false);
          paramAnonymousView.putExtra("show_bottom", false);
          paramAnonymousView.putExtra("needRedirect", false);
          paramAnonymousView.putExtra("neverGetA8Key", true);
          paramAnonymousView.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Kzm);
          paramAnonymousView.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Kzg);
          c.b(BioHelperUI.this, "webview", ".ui.tools.WebViewUI", paramAnonymousView);
          BioHelperUI.this.finish();
          a.a(this, "com/tencent/mm/pluginsdk/ui/BioHelperUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(128830);
        }
      });
      AppMethodBeat.o(128842);
      return;
      paramBundle.setText(this.Kbo.goB());
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    implements BioHelperUI.b
  {
    private a() {}
    
    public final void bo(Intent paramIntent) {}
    
    public final String goA()
    {
      AppMethodBeat.i(128832);
      String str = BioHelperUI.this.getString(2131756690);
      AppMethodBeat.o(128832);
      return str;
    }
    
    public final String goB()
    {
      AppMethodBeat.i(128833);
      String str = BioHelperUI.this.getString(2131756687);
      AppMethodBeat.o(128833);
      return str;
    }
    
    public final String goy()
    {
      AppMethodBeat.i(128831);
      String str = BioHelperUI.this.getString(2131756689);
      AppMethodBeat.o(128831);
      return str;
    }
    
    public final int goz()
    {
      return 2131232245;
    }
    
    public final void h(int paramInt1, int paramInt2, Intent paramIntent)
    {
      paramInt1 = 0;
      AppMethodBeat.i(128835);
      boolean bool;
      if ((paramInt2 == 2) && (paramIntent != null))
      {
        BioHelperUI.this.finish();
        paramIntent = paramIntent.getStringExtra("KFaceLoginAuthPwd");
        bool = Util.isNullOrNil(paramIntent);
        if (!Util.isNullOrNil(paramIntent)) {
          break label75;
        }
      }
      for (;;)
      {
        Log.i("MicroMsg.BioHelperUI", "hy: secondary check onActivityResult, do faceprint auth, authPwd is null:%b, authPwd.len:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt1) });
        AppMethodBeat.o(128835);
        return;
        label75:
        paramInt1 = paramIntent.length();
      }
    }
    
    public final void iy(Context paramContext)
    {
      AppMethodBeat.i(128834);
      paramContext = new Intent();
      paramContext.putExtra("k_user_name", BioHelperUI.c(BioHelperUI.this));
      paramContext.putExtra("k_purpose", 2);
      paramContext.putExtra("k_need_signature", true);
      paramContext.putExtra("k_ticket", BioHelperUI.d(BioHelperUI.this));
      c.b(BioHelperUI.this.getContext(), "facedetect", ".ui.FaceDetectUI", paramContext, 1025);
      AppMethodBeat.o(128834);
    }
  }
  
  static abstract interface b
  {
    public abstract void bo(Intent paramIntent);
    
    public abstract String goA();
    
    public abstract String goB();
    
    public abstract String goy();
    
    public abstract int goz();
    
    public abstract void h(int paramInt1, int paramInt2, Intent paramIntent);
    
    public abstract void iy(Context paramContext);
  }
  
  final class c
    implements BioHelperUI.b
  {
    private int mScene;
    
    private c() {}
    
    public final void bo(Intent paramIntent)
    {
      AppMethodBeat.i(128836);
      if (paramIntent == null)
      {
        AppMethodBeat.o(128836);
        return;
      }
      this.mScene = paramIntent.getIntExtra("kscene_type", 73);
      AppMethodBeat.o(128836);
    }
    
    public final String goA()
    {
      AppMethodBeat.i(128838);
      String str = BioHelperUI.this.getString(2131756692);
      AppMethodBeat.o(128838);
      return str;
    }
    
    public final String goB()
    {
      AppMethodBeat.i(128839);
      String str = BioHelperUI.this.getString(2131756688);
      AppMethodBeat.o(128839);
      return str;
    }
    
    public final String goy()
    {
      AppMethodBeat.i(128837);
      String str = BioHelperUI.this.getString(2131756693);
      AppMethodBeat.o(128837);
      return str;
    }
    
    public final int goz()
    {
      return 2131235445;
    }
    
    public final void h(int paramInt1, int paramInt2, Intent paramIntent)
    {
      int i = 0;
      AppMethodBeat.i(128841);
      boolean bool;
      if (paramInt2 == -1) {
        if ((paramInt1 == 1024) && (paramIntent != null))
        {
          paramIntent = paramIntent.getStringExtra("VoiceLoginAuthPwd");
          bool = Util.isNullOrNil(paramIntent);
          if (!Util.isNullOrNil(paramIntent)) {
            break label129;
          }
        }
      }
      label129:
      for (paramInt1 = i;; paramInt1 = paramIntent.length())
      {
        Log.d("MicroMsg.BioHelperUI", "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt1) });
        Intent localIntent = new Intent();
        localIntent.putExtra("VoiceLoginAuthPwd", paramIntent);
        localIntent.putExtra("KVoiceHelpCode", BioHelperUI.e(BioHelperUI.this));
        BioHelperUI.this.setResult(-1, localIntent);
        BioHelperUI.this.finish();
        AppMethodBeat.o(128841);
        return;
      }
    }
    
    public final void iy(Context paramContext)
    {
      AppMethodBeat.i(128840);
      Intent localIntent = new Intent();
      localIntent.putExtra("kscene_type", this.mScene);
      localIntent.putExtra("Kusername", BioHelperUI.c(BioHelperUI.this));
      localIntent.putExtra("Kvertify_key", BioHelperUI.d(BioHelperUI.this));
      c.b(paramContext, "voiceprint", ".ui.VoiceLoginUI", localIntent, 1024);
      AppMethodBeat.o(128840);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.BioHelperUI
 * JD-Core Version:    0.7.0.1
 */