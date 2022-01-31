package com.tencent.mm.pluginsdk.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;

public class BioHelperUI
  extends MMActivity
{
  private String eiu;
  private String ikj;
  private int lCs;
  private int mType;
  private String mWording;
  private String vPX;
  private b vPY;
  
  public int getLayoutId()
  {
    return 2130968856;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool = true;
    AppMethodBeat.i(125682);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent == null) {}
    for (;;)
    {
      ab.i("MicroMsg.BioHelperUI", "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      this.vPY.f(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(125682);
      return;
      bool = false;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Object localObject = null;
    AppMethodBeat.i(125681);
    super.onCreate(paramBundle);
    this.mType = getIntent().getIntExtra("k_type", 1);
    ab.i("MicroMsg.BioHelperUI", "hy: starting to bio helper ui, type: %d", new Object[] { Integer.valueOf(this.mType) });
    this.ikj = bo.bf(getIntent().getStringExtra("Kusername"), null);
    this.eiu = bo.bf(getIntent().getStringExtra("Kvertify_key"), null);
    this.vPX = bo.bf(getIntent().getStringExtra("KVoiceHelpUrl"), null);
    this.mWording = bo.bf(getIntent().getStringExtra("KVoiceHelpWording"), null);
    this.lCs = getIntent().getIntExtra("KVoiceHelpCode", 0);
    if (this.mType == 0) {
      paramBundle = new c((byte)0);
    }
    for (;;)
    {
      this.vPY = paramBundle;
      if ((this.vPY != null) && (!bo.isNullOrNil(this.ikj)) && (!bo.isNullOrNil(this.eiu))) {
        break;
      }
      ab.w("MicroMsg.BioHelperUI", "type or username or ticket is null and finish");
      finish();
      AppMethodBeat.o(125681);
      return;
      if (this.mType == 1)
      {
        paramBundle = new a((byte)0);
      }
      else
      {
        ab.e("MicroMsg.BioHelperUI", "hy: invalid type!!!");
        paramBundle = localObject;
      }
    }
    paramBundle = (TextView)findViewById(2131821828);
    if (!bo.isNullOrNil(this.mWording)) {
      paramBundle.setText(this.mWording);
    }
    for (;;)
    {
      setMMTitle(this.vPY.dmU());
      ((ImageView)findViewById(2131821827)).setImageResource(this.vPY.dmV());
      setBackBtn(new BioHelperUI.1(this));
      this.vPY.aD(getIntent());
      paramBundle = (Button)findViewById(2131821829);
      paramBundle.setText(this.vPY.dmW());
      paramBundle.setOnClickListener(new BioHelperUI.2(this));
      findViewById(2131821830).setOnClickListener(new BioHelperUI.3(this));
      AppMethodBeat.o(125681);
      return;
      paramBundle.setText(this.vPY.dmX());
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
    
    public final void aD(Intent paramIntent) {}
    
    public final String dmU()
    {
      AppMethodBeat.i(125670);
      String str = BioHelperUI.this.getString(2131297660);
      AppMethodBeat.o(125670);
      return str;
    }
    
    public final int dmV()
    {
      return 2130838693;
    }
    
    public final String dmW()
    {
      AppMethodBeat.i(125671);
      String str = BioHelperUI.this.getString(2131297661);
      AppMethodBeat.o(125671);
      return str;
    }
    
    public final String dmX()
    {
      AppMethodBeat.i(125672);
      String str = BioHelperUI.this.getString(2131297658);
      AppMethodBeat.o(125672);
      return str;
    }
    
    public final void f(int paramInt1, int paramInt2, Intent paramIntent)
    {
      paramInt1 = 0;
      AppMethodBeat.i(125674);
      boolean bool;
      if ((paramInt2 == 2) && (paramIntent != null))
      {
        BioHelperUI.this.finish();
        paramIntent = paramIntent.getStringExtra("KFaceLoginAuthPwd");
        bool = bo.isNullOrNil(paramIntent);
        if (!bo.isNullOrNil(paramIntent)) {
          break label75;
        }
      }
      for (;;)
      {
        ab.i("MicroMsg.BioHelperUI", "hy: secondary check onActivityResult, do faceprint auth, authPwd is null:%b, authPwd.len:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt1) });
        AppMethodBeat.o(125674);
        return;
        label75:
        paramInt1 = paramIntent.length();
      }
    }
    
    public final void fW(Context paramContext)
    {
      AppMethodBeat.i(125673);
      paramContext = new Intent();
      paramContext.putExtra("k_user_name", BioHelperUI.c(BioHelperUI.this));
      paramContext.putExtra("k_purpose", 2);
      paramContext.putExtra("k_need_signature", true);
      paramContext.putExtra("k_ticket", BioHelperUI.d(BioHelperUI.this));
      d.b(BioHelperUI.this.getContext(), "facedetect", ".ui.FaceDetectUI", paramContext, 1025);
      AppMethodBeat.o(125673);
    }
  }
  
  static abstract interface b
  {
    public abstract void aD(Intent paramIntent);
    
    public abstract String dmU();
    
    public abstract int dmV();
    
    public abstract String dmW();
    
    public abstract String dmX();
    
    public abstract void f(int paramInt1, int paramInt2, Intent paramIntent);
    
    public abstract void fW(Context paramContext);
  }
  
  final class c
    implements BioHelperUI.b
  {
    private int mScene;
    
    private c() {}
    
    public final void aD(Intent paramIntent)
    {
      AppMethodBeat.i(125675);
      if (paramIntent == null)
      {
        AppMethodBeat.o(125675);
        return;
      }
      this.mScene = paramIntent.getIntExtra("kscene_type", 73);
      AppMethodBeat.o(125675);
    }
    
    public final String dmU()
    {
      AppMethodBeat.i(125676);
      String str = BioHelperUI.this.getString(2131297664);
      AppMethodBeat.o(125676);
      return str;
    }
    
    public final int dmV()
    {
      return 2130840676;
    }
    
    public final String dmW()
    {
      AppMethodBeat.i(125677);
      String str = BioHelperUI.this.getString(2131297663);
      AppMethodBeat.o(125677);
      return str;
    }
    
    public final String dmX()
    {
      AppMethodBeat.i(125678);
      String str = BioHelperUI.this.getString(2131297659);
      AppMethodBeat.o(125678);
      return str;
    }
    
    public final void f(int paramInt1, int paramInt2, Intent paramIntent)
    {
      int i = 0;
      AppMethodBeat.i(125680);
      boolean bool;
      if (paramInt2 == -1) {
        if ((paramInt1 == 1024) && (paramIntent != null))
        {
          paramIntent = paramIntent.getStringExtra("VoiceLoginAuthPwd");
          bool = bo.isNullOrNil(paramIntent);
          if (!bo.isNullOrNil(paramIntent)) {
            break label129;
          }
        }
      }
      label129:
      for (paramInt1 = i;; paramInt1 = paramIntent.length())
      {
        ab.d("MicroMsg.BioHelperUI", "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt1) });
        Intent localIntent = new Intent();
        localIntent.putExtra("VoiceLoginAuthPwd", paramIntent);
        localIntent.putExtra("KVoiceHelpCode", BioHelperUI.e(BioHelperUI.this));
        BioHelperUI.this.setResult(-1, localIntent);
        BioHelperUI.this.finish();
        AppMethodBeat.o(125680);
        return;
      }
    }
    
    public final void fW(Context paramContext)
    {
      AppMethodBeat.i(125679);
      Intent localIntent = new Intent();
      localIntent.putExtra("kscene_type", this.mScene);
      localIntent.putExtra("Kusername", BioHelperUI.c(BioHelperUI.this));
      localIntent.putExtra("Kvertify_key", BioHelperUI.d(BioHelperUI.this));
      d.b(paramContext, "voiceprint", ".ui.VoiceLoginUI", localIntent, 1024);
      AppMethodBeat.o(125679);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.BioHelperUI
 * JD-Core Version:    0.7.0.1
 */