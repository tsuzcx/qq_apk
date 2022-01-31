package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
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
import android.os.HandlerThread;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ch.a;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x;
import com.tencent.mm.plugin.sns.ui.widget.SnsTextProgressBar;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class m
  extends j
  implements Serializable
{
  private View rvA;
  private Button rvB;
  private SnsTextProgressBar rvC;
  m.a rvD;
  private al rvE;
  private m.b rvF;
  private View.OnClickListener rvG;
  AdLandingPagesProxy.e rvH;
  
  public m(Context paramContext, b paramb, ViewGroup paramViewGroup)
  {
    super(paramContext, paramb, paramViewGroup);
    AppMethodBeat.i(37144);
    this.rvG = new m.1(this);
    this.rvH = new m.2(this);
    this.rvE = new al("apkStateMachine");
    this.rvD = new m.a(this, "apkStateMachine", this.rvE.oNc.getLooper());
    AppMethodBeat.o(37144);
  }
  
  private static String gu(String paramString1, String paramString2)
  {
    AppMethodBeat.i(37151);
    if (bo.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(37151);
      return paramString2;
    }
    if (paramString1.matches("#[0-9A-Fa-f]{6}([0-9A-Fa-f]{2})?"))
    {
      AppMethodBeat.o(37151);
      return paramString1;
    }
    AppMethodBeat.o(37151);
    return paramString2;
  }
  
  public final void cqA()
  {
    AppMethodBeat.i(37147);
    super.cqA();
    this.rvD.sendMessage(2);
    AdLandingPagesProxy.getInstance().addReportInfo(((b)this.rve).cwc, crc().rpv, crc().heu);
    AppMethodBeat.o(37147);
  }
  
  @TargetApi(17)
  public final void cqK()
  {
    AppMethodBeat.i(37146);
    this.clickCount = 0;
    View localView = this.contentView;
    this.rvA = localView.findViewById(2131827839);
    this.rvB = ((Button)localView.findViewById(2131822726));
    this.rvB.setOnClickListener(this.rvG);
    this.rvC = ((SnsTextProgressBar)localView.findViewById(2131827840));
    this.rvC.setProgress(0);
    this.rvC.setVisibility(8);
    this.rvC.setOnClickListener(this.rvG);
    this.rvD.start();
    AppMethodBeat.o(37146);
  }
  
  protected final void cqP()
  {
    AppMethodBeat.i(37145);
    Object localObject1 = new HashMap();
    ((Map)localObject1).put("fontNormalColor", gu(((b)this.rve).rrN, "#FFFFFF"));
    ((Map)localObject1).put("fontDisableColor", gu(((b)this.rve).rrO, "#4CFFFFFF"));
    ((Map)localObject1).put("fontPressedColor", gu(((b)this.rve).rrP, "#99FFFFFF"));
    ((Map)localObject1).put("NormalColor", gu(((b)this.rve).rrH, "#1AAD19"));
    ((Map)localObject1).put("PressedColor", gu(((b)this.rve).rrJ, "#179B16"));
    ((Map)localObject1).put("DisableColor", gu(((b)this.rve).rrI, "#661AAD19"));
    ((Map)localObject1).put("borderNormalColor", gu(((b)this.rve).rrK, "#179E16"));
    ((Map)localObject1).put("borderPressedColor", gu(((b)this.rve).rrM, "#158E14"));
    ((Map)localObject1).put("borderDisableColor", gu(((b)this.rve).rrL, "#00179E16"));
    int i = Color.parseColor((String)((Map)localObject1).get("fontNormalColor"));
    int j = Color.parseColor((String)((Map)localObject1).get("fontDisableColor"));
    int k = Color.parseColor((String)((Map)localObject1).get("fontPressedColor"));
    int m = Color.parseColor((String)((Map)localObject1).get("NormalColor"));
    int n = Color.parseColor((String)((Map)localObject1).get("PressedColor"));
    int i1 = Color.parseColor((String)((Map)localObject1).get("DisableColor"));
    int i2 = (int)((b)this.rve).rsh;
    int i3 = Color.parseColor((String)((Map)localObject1).get("borderNormalColor"));
    int i4 = Color.parseColor((String)((Map)localObject1).get("borderPressedColor"));
    int i5 = Color.parseColor((String)((Map)localObject1).get("borderDisableColor"));
    int i6 = this.context.getResources().getDimensionPixelSize(2131427514);
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
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setShape(0);
    localGradientDrawable.setCornerRadius(i6);
    localGradientDrawable.setColor(m);
    localGradientDrawable.setStroke(i2, i3);
    StateListDrawable localStateListDrawable = new StateListDrawable();
    localStateListDrawable.addState(new int[] { -16842910 }, (Drawable)localObject1);
    localStateListDrawable.addState(new int[] { 16842919 }, (Drawable)localObject2);
    localStateListDrawable.addState(new int[] { 16842910 }, localGradientDrawable);
    this.rvB.setBackground(localStateListDrawable);
    localObject1 = new int[] { -16842910 };
    localObject2 = new int[] { 16842919 };
    this.rvB.setTextColor(new ColorStateList(new int[][] { localObject1, localObject2, { 16842910 } }, new int[] { j, k, i }));
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
    localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setShape(0);
    localGradientDrawable.setCornerRadius(i6);
    localGradientDrawable.setColor(m);
    localObject1 = new LayerDrawable(new Drawable[] { localObject1, localObject2, new ClipDrawable(localGradientDrawable, 3, 1) });
    ((LayerDrawable)localObject1).setId(0, 16908288);
    ((LayerDrawable)localObject1).setId(1, 16908303);
    ((LayerDrawable)localObject1).setId(2, 16908301);
    this.rvC.setProgressDrawable((Drawable)localObject1);
    this.rvC.setPaintColor(((b)this.rve).rrP);
    if (((b)this.rve).height > 0.0F)
    {
      localObject1 = (RelativeLayout.LayoutParams)this.rvA.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).height = ((int)((b)this.rve).height);
      this.rvA.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    }
    this.rvB.setText(((b)this.rve).title);
    this.rvD.sendMessage(11);
    AppMethodBeat.o(37145);
  }
  
  public final void cqz()
  {
    AppMethodBeat.i(37148);
    super.cqz();
    ab.i("MicroMsg.AdLandingPageDownloadApkBtnComp", "view destroy");
    this.rvE.oNc.quit();
    if (this.rvF != null)
    {
      this.context.unregisterReceiver(this.rvF);
      this.rvF = null;
    }
    AppMethodBeat.o(37148);
  }
  
  public final boolean crk()
  {
    AppMethodBeat.i(37149);
    if ((this.context == null) || (TextUtils.isEmpty(((b)this.rve).cwc)) || (TextUtils.isEmpty(((b)this.rve).Ca)))
    {
      AppMethodBeat.o(37149);
      return false;
    }
    Intent localIntent;
    Object localObject;
    if (!TextUtils.isEmpty(((b)this.rve).rrQ))
    {
      localIntent = new Intent("android.intent.action.VIEW", Uri.parse(((b)this.rve).rrQ));
      localIntent.addFlags(268435456);
      localObject = bo.H(this.context, localIntent);
      if ((localObject != null) && (!((List)localObject).isEmpty()))
      {
        if ((!TextUtils.isEmpty(localIntent.getPackage())) || (((List)localObject).size() != 1)) {
          break label209;
        }
        localObject = g.b((ResolveInfo)((List)localObject).get(0));
        if (!bo.nullAsNil(ah.getPackageName()).equals(localObject)) {
          a.post(new m.3(this, localIntent));
        }
      }
    }
    for (;;)
    {
      AdLandingPagesProxy.getInstance().reportDownloadInfo(9, ((b)this.rve).cwc);
      AppMethodBeat.o(37149);
      return true;
      label209:
      localObject = localIntent.getPackage();
      break;
      a.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(37105);
          Intent localIntent = m.this.context.getPackageManager().getLaunchIntentForPackage(m.b(m.this).Ca);
          g.a(m.this.context, localIntent, g.t(m.this.context, m.b(m.this).cwc), new m.4.1(this));
          AppMethodBeat.o(37105);
        }
      });
    }
  }
  
  public final void crl()
  {
    AppMethodBeat.i(37150);
    ab.d("MicroMsg.AdLandingPageDownloadApkBtnComp", "writing deferred deep link");
    AdLandingPagesProxy.getInstance().writeDeferredDeepLink(((b)this.rve).Ca, ((b)this.rve).rrQ);
    AppMethodBeat.o(37150);
  }
  
  protected final int getLayout()
  {
    return 2130970773;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
 * JD-Core Version:    0.7.0.1
 */