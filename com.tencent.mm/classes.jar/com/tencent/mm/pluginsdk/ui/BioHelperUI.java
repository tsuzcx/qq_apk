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
import com.tencent.mm.br.d;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;

public class BioHelperUI
  extends MMActivity
{
  private String Fkv;
  private b Fkw;
  private String fRw;
  private String lJm;
  private int mType;
  private String mWording;
  private int qgz;
  
  public int getLayoutId()
  {
    return 2131493188;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool = true;
    AppMethodBeat.i(128843);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent == null) {}
    for (;;)
    {
      ae.i("MicroMsg.BioHelperUI", "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      this.Fkw.h(paramInt1, paramInt2, paramIntent);
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
    ae.i("MicroMsg.BioHelperUI", "hy: starting to bio helper ui, type: %d", new Object[] { Integer.valueOf(this.mType) });
    this.lJm = bu.bI(getIntent().getStringExtra("Kusername"), null);
    this.fRw = bu.bI(getIntent().getStringExtra("Kvertify_key"), null);
    this.Fkv = bu.bI(getIntent().getStringExtra("KVoiceHelpUrl"), null);
    this.mWording = bu.bI(getIntent().getStringExtra("KVoiceHelpWording"), null);
    this.qgz = getIntent().getIntExtra("KVoiceHelpCode", 0);
    if (this.mType == 0) {
      paramBundle = new c((byte)0);
    }
    for (;;)
    {
      this.Fkw = paramBundle;
      if ((this.Fkw != null) && (!bu.isNullOrNil(this.lJm)) && (!bu.isNullOrNil(this.fRw))) {
        break;
      }
      ae.w("MicroMsg.BioHelperUI", "type or username or ticket is null and finish");
      finish();
      AppMethodBeat.o(128842);
      return;
      if (this.mType == 1)
      {
        paramBundle = new a((byte)0);
      }
      else
      {
        ae.e("MicroMsg.BioHelperUI", "hy: invalid type!!!");
        paramBundle = localObject;
      }
    }
    paramBundle = (TextView)findViewById(2131297273);
    if (!bu.isNullOrNil(this.mWording)) {
      paramBundle.setText(this.mWording);
    }
    for (;;)
    {
      setMMTitle(this.Fkw.ffo());
      ((ImageView)findViewById(2131297271)).setImageResource(this.Fkw.ffp());
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
      this.Fkw.bc(getIntent());
      paramBundle = (Button)findViewById(2131297274);
      paramBundle.setText(this.Fkw.ffq());
      paramBundle.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128829);
          b localb = new b();
          localb.bd(paramAnonymousView);
          a.b("com/tencent/mm/pluginsdk/ui/BioHelperUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          BioHelperUI.a(BioHelperUI.this).hE(BioHelperUI.this);
          a.a(this, "com/tencent/mm/pluginsdk/ui/BioHelperUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(128829);
        }
      });
      findViewById(2131297272).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128830);
          b localb = new b();
          localb.bd(paramAnonymousView);
          a.b("com/tencent/mm/pluginsdk/ui/BioHelperUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("rawUrl", BioHelperUI.b(BioHelperUI.this));
          paramAnonymousView.putExtra("showShare", false);
          paramAnonymousView.putExtra("show_bottom", false);
          paramAnonymousView.putExtra("needRedirect", false);
          paramAnonymousView.putExtra("neverGetA8Key", true);
          paramAnonymousView.putExtra("hardcode_jspermission", JsapiPermissionWrapper.FGb);
          paramAnonymousView.putExtra("hardcode_general_ctrl", GeneralControlWrapper.FFX);
          d.b(BioHelperUI.this, "webview", ".ui.tools.WebViewUI", paramAnonymousView);
          BioHelperUI.this.finish();
          a.a(this, "com/tencent/mm/pluginsdk/ui/BioHelperUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(128830);
        }
      });
      AppMethodBeat.o(128842);
      return;
      paramBundle.setText(this.Fkw.ffr());
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
    
    public final void bc(Intent paramIntent) {}
    
    public final String ffo()
    {
      AppMethodBeat.i(128831);
      String str = BioHelperUI.this.getString(2131756553);
      AppMethodBeat.o(128831);
      return str;
    }
    
    public final int ffp()
    {
      return 2131232134;
    }
    
    public final String ffq()
    {
      AppMethodBeat.i(128832);
      String str = BioHelperUI.this.getString(2131756554);
      AppMethodBeat.o(128832);
      return str;
    }
    
    public final String ffr()
    {
      AppMethodBeat.i(128833);
      String str = BioHelperUI.this.getString(2131756551);
      AppMethodBeat.o(128833);
      return str;
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
        bool = bu.isNullOrNil(paramIntent);
        if (!bu.isNullOrNil(paramIntent)) {
          break label75;
        }
      }
      for (;;)
      {
        ae.i("MicroMsg.BioHelperUI", "hy: secondary check onActivityResult, do faceprint auth, authPwd is null:%b, authPwd.len:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt1) });
        AppMethodBeat.o(128835);
        return;
        label75:
        paramInt1 = paramIntent.length();
      }
    }
    
    public final void hE(Context paramContext)
    {
      AppMethodBeat.i(128834);
      paramContext = new Intent();
      paramContext.putExtra("k_user_name", BioHelperUI.c(BioHelperUI.this));
      paramContext.putExtra("k_purpose", 2);
      paramContext.putExtra("k_need_signature", true);
      paramContext.putExtra("k_ticket", BioHelperUI.d(BioHelperUI.this));
      d.b(BioHelperUI.this.getContext(), "facedetect", ".ui.FaceDetectUI", paramContext, 1025);
      AppMethodBeat.o(128834);
    }
  }
  
  static abstract interface b
  {
    public abstract void bc(Intent paramIntent);
    
    public abstract String ffo();
    
    public abstract int ffp();
    
    public abstract String ffq();
    
    public abstract String ffr();
    
    public abstract void h(int paramInt1, int paramInt2, Intent paramIntent);
    
    public abstract void hE(Context paramContext);
  }
  
  final class c
    implements BioHelperUI.b
  {
    private int mScene;
    
    private c() {}
    
    public final void bc(Intent paramIntent)
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
    
    public final String ffo()
    {
      AppMethodBeat.i(128837);
      String str = BioHelperUI.this.getString(2131756557);
      AppMethodBeat.o(128837);
      return str;
    }
    
    public final int ffp()
    {
      return 2131234489;
    }
    
    public final String ffq()
    {
      AppMethodBeat.i(128838);
      String str = BioHelperUI.this.getString(2131756556);
      AppMethodBeat.o(128838);
      return str;
    }
    
    public final String ffr()
    {
      AppMethodBeat.i(128839);
      String str = BioHelperUI.this.getString(2131756552);
      AppMethodBeat.o(128839);
      return str;
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
          bool = bu.isNullOrNil(paramIntent);
          if (!bu.isNullOrNil(paramIntent)) {
            break label129;
          }
        }
      }
      label129:
      for (paramInt1 = i;; paramInt1 = paramIntent.length())
      {
        ae.d("MicroMsg.BioHelperUI", "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt1) });
        Intent localIntent = new Intent();
        localIntent.putExtra("VoiceLoginAuthPwd", paramIntent);
        localIntent.putExtra("KVoiceHelpCode", BioHelperUI.e(BioHelperUI.this));
        BioHelperUI.this.setResult(-1, localIntent);
        BioHelperUI.this.finish();
        AppMethodBeat.o(128841);
        return;
      }
    }
    
    public final void hE(Context paramContext)
    {
      AppMethodBeat.i(128840);
      Intent localIntent = new Intent();
      localIntent.putExtra("kscene_type", this.mScene);
      localIntent.putExtra("Kusername", BioHelperUI.c(BioHelperUI.this));
      localIntent.putExtra("Kvertify_key", BioHelperUI.d(BioHelperUI.this));
      d.b(paramContext, "voiceprint", ".ui.VoiceLoginUI", localIntent, 1024);
      AppMethodBeat.o(128840);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.BioHelperUI
 * JD-Core Version:    0.7.0.1
 */