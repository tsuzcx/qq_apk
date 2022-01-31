package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.cg.a;
import com.tencent.mm.plugin.sns.i.d;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a;
import com.tencent.mm.plugin.sns.ui.widget.SnsTextProgressBar;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class n
  extends k
  implements f, Serializable
{
  private View oFW;
  Button oFX;
  SnsTextProgressBar oFY;
  n.a oFZ = new n.a(this, "apkStateMachine");
  n.b oGa;
  private View.OnClickListener oGb = new n.1(this);
  AdLandingPagesProxy.a oGc = new n.2(this);
  
  public n(Context paramContext, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b paramb, ViewGroup paramViewGroup)
  {
    super(paramContext, paramb, paramViewGroup);
  }
  
  private static String eR(String paramString1, String paramString2)
  {
    if (bk.bl(paramString1)) {}
    while (!paramString1.matches("#[0-9A-Fa-f]{6}([0-9A-Fa-f]{2})?")) {
      return paramString2;
    }
    return paramString1;
  }
  
  public final void bES()
  {
    super.bES();
    if (this.oGa != null)
    {
      this.context.unregisterReceiver(this.oGa);
      this.oGa = null;
    }
  }
  
  public final void bET()
  {
    super.bET();
    this.oFZ.Ff(2);
  }
  
  @TargetApi(17)
  public final View bFf()
  {
    this.oFs = 0;
    View localView = this.contentView;
    this.oFW = localView.findViewById(i.f.downloader);
    this.oFX = ((Button)localView.findViewById(i.f.download_btn));
    this.oFX.setOnClickListener(this.oGb);
    this.oFY = ((SnsTextProgressBar)localView.findViewById(i.f.download_progress));
    this.oFY.setProgress(0);
    this.oFY.setVisibility(8);
    this.oFY.setOnClickListener(this.oGb);
    this.oFZ.start();
    return localView;
  }
  
  protected final void bFj()
  {
    Object localObject1 = new HashMap();
    ((Map)localObject1).put("fontNormalColor", eR(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.oFE).oCo, "#FFFFFF"));
    ((Map)localObject1).put("fontDisableColor", eR(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.oFE).oCp, "#4CFFFFFF"));
    ((Map)localObject1).put("fontPressedColor", eR(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.oFE).oCq, "#99FFFFFF"));
    ((Map)localObject1).put("NormalColor", eR(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.oFE).oCi, "#1AAD19"));
    ((Map)localObject1).put("PressedColor", eR(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.oFE).oCk, "#179B16"));
    ((Map)localObject1).put("DisableColor", eR(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.oFE).oCj, "#661AAD19"));
    ((Map)localObject1).put("borderNormalColor", eR(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.oFE).oCl, "#179E16"));
    ((Map)localObject1).put("borderPressedColor", eR(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.oFE).oCn, "#158E14"));
    ((Map)localObject1).put("borderDisableColor", eR(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.oFE).oCm, "#00179E16"));
    int i = Color.parseColor((String)((Map)localObject1).get("fontNormalColor"));
    int j = Color.parseColor((String)((Map)localObject1).get("fontDisableColor"));
    int k = Color.parseColor((String)((Map)localObject1).get("fontPressedColor"));
    int m = Color.parseColor((String)((Map)localObject1).get("NormalColor"));
    int n = Color.parseColor((String)((Map)localObject1).get("PressedColor"));
    int i1 = Color.parseColor((String)((Map)localObject1).get("DisableColor"));
    int i2 = (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.oFE).oCG;
    int i3 = Color.parseColor((String)((Map)localObject1).get("borderNormalColor"));
    int i4 = Color.parseColor((String)((Map)localObject1).get("borderPressedColor"));
    int i5 = Color.parseColor((String)((Map)localObject1).get("borderDisableColor"));
    int i6 = this.context.getResources().getDimensionPixelSize(i.d.ButtonCornerSize);
    localObject1 = new GradientDrawable();
    ((GradientDrawable)localObject1).setShape(0);
    ((GradientDrawable)localObject1).setCornerRadius(i6);
    ((GradientDrawable)localObject1).setColor(i1);
    ((GradientDrawable)localObject1).setStroke(i2, i5);
    Object localObject2 = new GradientDrawable();
    ((GradientDrawable)localObject2).setShape(0);
    ((GradientDrawable)localObject2).setCornerRadius(i6);
    ((GradientDrawable)localObject2).setColor(n);
    ((GradientDrawable)localObject2).setStroke(i2, i4);
    Object localObject3 = new GradientDrawable();
    ((GradientDrawable)localObject3).setShape(0);
    ((GradientDrawable)localObject3).setCornerRadius(i6);
    ((GradientDrawable)localObject3).setColor(m);
    ((GradientDrawable)localObject3).setStroke(i2, i3);
    StateListDrawable localStateListDrawable = new StateListDrawable();
    localStateListDrawable.addState(new int[] { -16842910 }, (Drawable)localObject1);
    localStateListDrawable.addState(new int[] { 16842919 }, (Drawable)localObject2);
    localStateListDrawable.addState(new int[] { 16842910 }, (Drawable)localObject3);
    this.oFX.setBackground(localStateListDrawable);
    localObject1 = new int[] { -16842910 };
    localObject2 = new int[] { 16842919 };
    localObject3 = new int[] { 16842910 };
    this.oFX.setTextColor(new ColorStateList(new int[][] { localObject1, localObject2, localObject3 }, new int[] { j, k, i }));
    localObject1 = new GradientDrawable();
    ((GradientDrawable)localObject1).setShape(0);
    ((GradientDrawable)localObject1).setCornerRadius(i6);
    ((GradientDrawable)localObject1).setColor(n);
    ((GradientDrawable)localObject1).setStroke(i2, i4);
    localObject2 = new GradientDrawable();
    ((GradientDrawable)localObject2).setShape(0);
    ((GradientDrawable)localObject2).setCornerRadius(i6);
    ((GradientDrawable)localObject2).setColor(m);
    localObject2 = new ClipDrawable((Drawable)localObject2, 3, 1);
    localObject3 = new GradientDrawable();
    ((GradientDrawable)localObject3).setShape(0);
    ((GradientDrawable)localObject3).setCornerRadius(i6);
    ((GradientDrawable)localObject3).setColor(m);
    localObject1 = new LayerDrawable(new Drawable[] { localObject1, localObject2, new ClipDrawable((Drawable)localObject3, 3, 1) });
    ((LayerDrawable)localObject1).setId(0, 16908288);
    ((LayerDrawable)localObject1).setId(1, 16908303);
    ((LayerDrawable)localObject1).setId(2, 16908301);
    this.oFY.setProgressDrawable((Drawable)localObject1);
    this.oFY.setPaintColor(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.oFE).oCq);
    if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.oFE).height > 0.0F)
    {
      localObject1 = (RelativeLayout.LayoutParams)this.oFW.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).height = ((int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.oFE).height);
      this.oFW.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    }
    this.oFX.setText(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.oFE).title);
    this.oFZ.Ff(11);
  }
  
  public final boolean bFv()
  {
    if ((this.context == null) || (TextUtils.isEmpty(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.oFE).bOL)) || (TextUtils.isEmpty(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.oFE).Bo))) {
      return false;
    }
    Intent localIntent;
    Object localObject;
    if (!TextUtils.isEmpty(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.oFE).oCr))
    {
      localIntent = new Intent("android.intent.action.VIEW", Uri.parse(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.oFE).oCr));
      localIntent.addFlags(268435456);
      localObject = bk.A(this.context, localIntent);
      if ((localObject != null) && (!((List)localObject).isEmpty()))
      {
        if ((!TextUtils.isEmpty(localIntent.getPackage())) || (((List)localObject).size() != 1)) {
          break label221;
        }
        localObject = g.b((ResolveInfo)((List)localObject).get(0));
        if (!bk.pm(ae.getPackageName()).equals(localObject)) {
          a.post(new n.3(this, localIntent));
        }
      }
    }
    for (;;)
    {
      AdLandingPagesProxy.getInstance().reportDownloadInfo(9, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.oFE).bOL, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.oFE).Bo, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.oFE).bIW, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.oFE).downloadUrl);
      return true;
      label221:
      localObject = localIntent.getPackage();
      break;
      a.post(new n.4(this));
    }
  }
  
  public final void bFw()
  {
    y.d("MicroMsg.AdLandingPageDownloadApkBtnComp", "writing deferred deep link");
    AdLandingPagesProxy.getInstance().writeDeferredDeepLink(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.oFE).Bo, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.oFE).oCr);
  }
  
  protected final int getLayout()
  {
    return i.g.sns_ad_comp_down_apk_btn;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm) {}
  
  final class a$c
    extends com.tencent.mm.sdk.d.b
  {
    a.a oGq;
    
    a$c() {}
    
    public final void enter()
    {
      super.enter();
      n.this.oGd.oFX.setVisibility(8);
      n.this.oGd.oFY.setVisibility(0);
      if ((AdLandingPagesProxy.getInstance().isPaused(n.b(n.this.oGd).bOL)) || (AdLandingPagesProxy.getInstance().isDownloading(n.b(n.this.oGd).bOL)))
      {
        if (this.oGq == null) {
          this.oGq = new n.a.c.a(this, (byte)0);
        }
        n.this.oGd.oFY.setProgress(AdLandingPagesProxy.getInstance().getTaskProgress(n.b(n.this.oGd).bOL));
        if (!AdLandingPagesProxy.getInstance().resumeTask(n.b(n.this.oGd).bOL, this.oGq, n.b(n.this.oGd).oAl, n.b(n.this.oGd).oAk))
        {
          AdLandingPagesProxy.getInstance().stopTask(n.b(n.this.oGd).bOL);
          n.this.b(n.this.oGg);
        }
        return;
      }
      if (TextUtils.isEmpty(n.b(n.this.oGd).downloadUrl))
      {
        n.this.b(n.this.oGm);
        return;
      }
      if (AdLandingPagesProxy.getInstance().isApkExist(n.b(n.this.oGd).bOL))
      {
        n.this.oGd.oFY.setProgress(100);
        n.this.b(n.this.oGj);
        return;
      }
      AdLandingPagesProxy.getInstance().stopTask(n.b(n.this.oGd).bOL);
      this.oGq = new n.a.c.a(this, (byte)0);
      AdLandingPagesProxy.getInstance().startDownload(n.b(n.this.oGd).bOL, n.b(n.this.oGd).Bo, n.b(n.this.oGd).bIW, n.b(n.this.oGd).downloadUrl, n.b(n.this.oGd).oCe, n.b(n.this.oGd).oCf, this.oGq, n.b(n.this.oGd).oAl, n.b(n.this.oGd).oAk);
    }
    
    public final boolean g(Message paramMessage)
    {
      y.i("LogStateTransitionState", "recv msg.what " + paramMessage.what);
      switch (paramMessage.what)
      {
      case 2: 
      case 4: 
      case 5: 
      case 6: 
      default: 
        return false;
      case 0: 
        if ((AdLandingPagesProxy.getInstance().pauseTask(n.b(n.this.oGd).bOL)) && (AdLandingPagesProxy.getInstance().isPaused(n.b(n.this.oGd).bOL))) {
          n.this.b(n.this.oGi);
        }
        return true;
      case 1: 
        int i = paramMessage.arg1;
        if (i >= 0) {
          n.this.oGd.oFY.setProgress(i);
        }
        return true;
      case 3: 
        n.this.b(n.this.oGk);
        return true;
      case 7: 
        n.this.b(n.this.oGi);
        return true;
      case 8: 
        n.a.a(n.this, "下载失败");
        n.this.b(n.this.oGl);
        return true;
      }
      if (n.b(n.this.oGd).oCf) {
        AdLandingPagesProxy.getInstance().reportDownloadInfo(4, n.b(n.this.oGd).bOL, n.b(n.this.oGd).Bo, n.b(n.this.oGd).bIW, n.b(n.this.oGd).downloadUrl);
      }
      n.this.oGd.bFw();
      n.this.b(n.this.oGj);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n
 * JD-Core Version:    0.7.0.1
 */