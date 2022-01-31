package com.tencent.mm.plugin.sns.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.at.b;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a.ga;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.protocal.c.aui;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.i.a.a;
import com.tencent.mm.ui.i.a.b;
import com.tencent.mm.ui.i.a.c;
import com.tencent.mm.ui.y;
import org.c.d.i;

public class SnsUploadConfigView
  extends LinearLayout
  implements f, a.a, a.b
{
  private static String bwQ = "com.tencent.mm";
  private Context context;
  private ProgressDialog lxZ = null;
  boolean pcF = false;
  ImageView piL;
  ImageView piM;
  ImageView piN;
  ImageView piO;
  private boolean piP = false;
  boolean piQ = false;
  boolean piR = false;
  private boolean piS = false;
  private boolean piT = false;
  private boolean piU = true;
  private boolean piV = false;
  boolean piW = false;
  aui piX = new aui();
  com.tencent.mm.ui.i.a piY = new com.tencent.mm.ui.i.a();
  
  public SnsUploadConfigView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.context = paramContext;
    this.context = paramContext;
    paramAttributeSet = y.gt(paramContext).inflate(i.g.sns_upload_config_view, this, true);
    this.piL = ((ImageView)paramAttributeSet.findViewById(i.f.sns_sync_facebook_iv));
    this.piM = ((ImageView)paramAttributeSet.findViewById(i.f.sns_sync_twitter_iv));
    this.piN = ((ImageView)paramAttributeSet.findViewById(i.f.sns_sync_qzone_iv));
    this.piO = ((ImageView)paramAttributeSet.findViewById(i.f.sns_sync_weishi_iv));
    if (!b.Pd()) {
      this.piN.setVisibility(8);
    }
    g.DQ();
    if (!g.DP().Dz().getBoolean(ac.a.upX, false)) {
      this.piO.setVisibility(8);
    }
    if (!b.Pf()) {
      this.piM.setVisibility(8);
    }
    if (!q.GI()) {
      this.piL.setVisibility(8);
    }
    this.piN.setOnClickListener(new SnsUploadConfigView.1(this, paramContext));
    this.piO.setOnClickListener(new SnsUploadConfigView.8(this, paramContext));
    this.piL.setOnClickListener(new SnsUploadConfigView.9(this));
    this.piM.setOnClickListener(new SnsUploadConfigView.10(this));
  }
  
  private void sS(int paramInt)
  {
    h.a(getContext(), paramInt, i.j.app_tip, new SnsUploadConfigView.5(this), new SnsUploadConfigView.6(this));
  }
  
  public final void a(a.c paramc)
  {
    if (this.lxZ != null) {
      this.lxZ.cancel();
    }
    switch (SnsUploadConfigView.7.lyx[paramc.ordinal()])
    {
    }
    for (;;)
    {
      bJV();
      return;
      this.piR = true;
      sS(i.j.twitterlogin_success);
      continue;
      this.piR = false;
      continue;
      this.piR = false;
      sS(i.j.twitterlogin_failed);
    }
  }
  
  public final void b(a.c paramc)
  {
    switch (SnsUploadConfigView.7.lyx[paramc.ordinal()])
    {
    }
    for (;;)
    {
      bJV();
      return;
      this.piR = false;
    }
  }
  
  public final void bJS()
  {
    this.piP = false;
    this.piQ = false;
    this.piR = false;
    this.piS = false;
    this.piT = false;
    this.piN.setImageResource(i.i.album_qzone_icon_normal);
    this.piO.setImageResource(i.i.album_wesee_icon_normal);
    this.piL.setImageResource(i.i.album_facebook_icon_normal);
    this.piM.setImageResource(i.i.album_twitter_icon_normal);
  }
  
  final void bJT()
  {
    if (this.piS)
    {
      g.DQ();
      int i = bk.g((Integer)g.DP().Dz().get(9, null));
      if (i == 0) {
        h.a(getContext(), i.j.settings_weibo_notice, i.j.app_tip, new SnsUploadConfigView.11(this), new SnsUploadConfigView.12(this));
      }
      for (i = 0;; i = 1)
      {
        if (i != 0) {
          break label85;
        }
        this.piS = false;
        return;
        if (i == 0) {
          break;
        }
      }
      label85:
      this.piN.setImageResource(i.i.album_qzone_icon_pressed);
      return;
    }
    this.piN.setImageResource(i.i.album_qzone_icon_normal);
  }
  
  final void bJU()
  {
    if (this.piO == null) {
      return;
    }
    if (this.piW)
    {
      g.DQ();
      if (g.DP().Dz().getBoolean(ac.a.upX, false)) {}
    }
    else
    {
      this.piT = false;
      this.piO.setVisibility(8);
      return;
    }
    this.piO.setVisibility(0);
    if (this.piT)
    {
      this.piO.setImageResource(i.i.album_wesee_icon_pressed);
      return;
    }
    this.piO.setImageResource(i.i.album_wesee_icon_normal);
  }
  
  final void bJV()
  {
    if (this.piR)
    {
      if (!this.piY.cJJ()) {
        h.a(getContext(), i.j.settings_twitter_notice, i.j.app_tip, new SnsUploadConfigView.15(this), new SnsUploadConfigView.2(this));
      }
      for (int i = 0; i == 0; i = 1)
      {
        this.piR = false;
        return;
      }
      this.piM.setImageResource(i.i.album_twitter_icon_pressed);
      return;
    }
    this.piM.setImageResource(i.i.album_twitter_icon_normal);
  }
  
  public int getPrivated()
  {
    int i = 0;
    if (this.pcF) {
      i = 1;
    }
    return i;
  }
  
  public int getSyncFlag()
  {
    int j = 0;
    if (this.piP) {
      j = 1;
    }
    int i = j;
    if (this.piQ) {
      i = j | 0x2;
    }
    j = i;
    if (this.piR) {
      j = i | 0x8;
    }
    i = j;
    if (this.piS) {
      i = j | 0x4;
    }
    j = i;
    if (this.piT) {
      j = i | 0x10;
    }
    return j;
  }
  
  public i getTwitterAccessToken()
  {
    return this.piY.wih;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramInt1 != 0) || (paramInt2 != 0) || (paramm == null)) {
      return;
    }
    bJU();
  }
  
  public void setPrivated(boolean paramBoolean)
  {
    this.pcF = paramBoolean;
    if (paramBoolean) {
      bJS();
    }
  }
  
  void setSyncFacebook(boolean paramBoolean)
  {
    if (this.piQ)
    {
      if (!q.GL()) {
        h.a(getContext(), i.j.settings_facebook_notice, i.j.app_tip, new DialogInterface.OnClickListener()new SnsUploadConfigView.14
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            d.b(SnsUploadConfigView.this.getContext(), "account", ".ui.FacebookAuthUI", new Intent().putExtra("shake_music", true));
          }
        }, new SnsUploadConfigView.14(this));
      }
      for (int i = 0; i == 0; i = 1)
      {
        this.piQ = false;
        return;
      }
      if ((!paramBoolean) && (!this.piV) && (q.GL()))
      {
        ga localga = new ga();
        localga.bFJ = new SnsUploadConfigView.3(this, localga);
        com.tencent.mm.sdk.b.a.udP.a(localga, Looper.myLooper());
      }
      this.piL.setImageResource(i.i.album_facebook_icon_pressed);
      return;
    }
    this.piL.setImageResource(i.i.album_facebook_icon_normal);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadConfigView
 * JD-Core Version:    0.7.0.1
 */