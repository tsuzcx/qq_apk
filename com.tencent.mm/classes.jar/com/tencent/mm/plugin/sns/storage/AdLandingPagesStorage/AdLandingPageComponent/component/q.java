package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
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
import com.tencent.e.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.device.appstore.a;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.d.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b;
import com.tencent.mm.plugin.sns.ui.widget.SnsTextProgressBar;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public final class q
  extends n
  implements Serializable
{
  String appId;
  String dnn;
  String dtx;
  String xOm;
  private View.OnClickListener ynA;
  AdLandingPagesProxy.e ynB;
  private View yns;
  Button ynt;
  private SnsTextProgressBar ynu;
  q.a ynv;
  private HandlerThread ynw;
  private b ynx;
  boolean yny;
  boolean ynz;
  
  public q(Context paramContext, b paramb, ViewGroup paramViewGroup)
  {
    super(paramContext, paramb, paramViewGroup);
    AppMethodBeat.i(96554);
    this.ynz = true;
    this.appId = "";
    this.dtx = "";
    this.xOm = "";
    this.dnn = "";
    this.ynA = new q.1(this);
    this.ynB = new q.2(this);
    ac.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "component create, new BtnStateMachine");
    this.ynw = d.aTD("apkStateMachine");
    this.ynw.start();
    this.ynv = new q.a(this, "apkStateMachine", this.ynw.getLooper());
    if ((paramContext instanceof Activity))
    {
      this.yny = ((Activity)paramContext).getIntent().getBooleanExtra("sns_landing_pages_auto_download_for_action_btn", false);
      this.ynz = true;
      ac.i("MicroMsg.AdLandingPageDownloadApkBtnComp", "autoDownloadFromActionBtn=" + this.yny + ", activity=" + paramContext + ", idx=" + ((b)this.ymQ).yii + ", appId=" + ((b)this.ymQ).djj + ", wxAppid=" + ((b)this.ymQ).yhT + ", useGameDownloader=" + ((b)this.ymQ).yhU + ", pkg=" + ((b)this.ymQ).JG);
    }
    this.ynh.bi("platform", paramb.yhX);
    this.ynh.jo("appid", paramb.djj);
    this.ynh.jo("channelId", paramb.channelId);
    this.ynh.jo("pkg", paramb.JG);
    this.ynh.jo("appPageUrlAndroid", paramb.yfc);
    try
    {
      this.appId = bs.nullAsNil(((b)this.ymQ).djj);
      this.dtx = bs.nullAsNil(dKH().dtx);
      this.xOm = bs.nullAsNil(dKH().xOm);
      this.dnn = dKH().getSnsId();
      AppMethodBeat.o(96554);
      return;
    }
    catch (Throwable paramContext)
    {
      ac.e("MicroMsg.AdLandingPageDownloadApkBtnComp.DownloadToastReport", paramContext.toString());
      AppMethodBeat.o(96554);
    }
  }
  
  private static String jn(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96561);
    if (bs.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(96561);
      return paramString2;
    }
    if (paramString1.matches("#[0-9A-Fa-f]{6}([0-9A-Fa-f]{2})?"))
    {
      AppMethodBeat.o(96561);
      return paramString1;
    }
    AppMethodBeat.o(96561);
    return paramString2;
  }
  
  @TargetApi(17)
  public final void dJW()
  {
    AppMethodBeat.i(96556);
    this.clickCount = 0;
    Object localObject = this.contentView;
    this.yns = ((View)localObject).findViewById(2131299227);
    this.ynt = ((Button)((View)localObject).findViewById(2131299195));
    this.ynt.setOnClickListener(this.ynA);
    this.ynu = ((SnsTextProgressBar)((View)localObject).findViewById(2131299215));
    this.ynu.setProgress(0);
    this.ynu.setVisibility(8);
    this.ynu.setOnClickListener(this.ynA);
    ac.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "createView, BtnStateMachine start");
    this.ynv.start();
    try
    {
      localObject = (b)this.ymQ;
      if (((b)localObject).yil > 0)
      {
        if (!a.aE(((b)localObject).yim)) {
          break label167;
        }
        j.a(dKH(), 4, "0", "");
      }
      for (;;)
      {
        j.a(dKH(), 1, "1", "");
        AppMethodBeat.o(96556);
        return;
        label167:
        j.a(dKH(), 4, "1", "");
      }
      return;
    }
    catch (Exception localException)
    {
      ac.w("MicroMsg.AdLandingPageDownloadApkBtnComp", "report19790 has something wrong");
      AppMethodBeat.o(96556);
    }
  }
  
  public final void dJX()
  {
    AppMethodBeat.i(96558);
    super.dJX();
    ac.i("MicroMsg.AdLandingPageDownloadApkBtnComp", "view destroy");
    this.ynw.quit();
    if (this.ynx != null)
    {
      this.context.unregisterReceiver(this.ynx);
      this.ynx = null;
    }
    AppMethodBeat.o(96558);
  }
  
  public final void dJY()
  {
    AppMethodBeat.i(96557);
    super.dJY();
    ac.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "viewWillAppear, sendMsg=2");
    this.ynv.Yv(2);
    AdLandingPagesProxy.getInstance().addReportInfo(((b)this.ymQ).djj, dKH().yeO, dKH().jyU, dKH().dtx);
    AppMethodBeat.o(96557);
  }
  
  public final void dKP()
  {
    AppMethodBeat.i(96560);
    ac.d("MicroMsg.AdLandingPageDownloadApkBtnComp", "writing deferred deep link");
    AdLandingPagesProxy.getInstance().writeDeferredDeepLink(((b)this.ymQ).JG, ((b)this.ymQ).yfc);
    AppMethodBeat.o(96560);
  }
  
  protected final void dKm()
  {
    AppMethodBeat.i(96555);
    Object localObject1 = new HashMap();
    ((Map)localObject1).put("fontNormalColor", jn(((b)this.ymQ).yif, "#FFFFFF"));
    ((Map)localObject1).put("fontDisableColor", jn(((b)this.ymQ).yig, "#4CFFFFFF"));
    ((Map)localObject1).put("fontPressedColor", jn(((b)this.ymQ).yih, "#99FFFFFF"));
    ((Map)localObject1).put("NormalColor", jn(((b)this.ymQ).yhZ, "#1AAD19"));
    ((Map)localObject1).put("PressedColor", jn(((b)this.ymQ).yib, "#179B16"));
    ((Map)localObject1).put("DisableColor", jn(((b)this.ymQ).yia, "#661AAD19"));
    ((Map)localObject1).put("borderNormalColor", jn(((b)this.ymQ).yic, "#179E16"));
    ((Map)localObject1).put("borderPressedColor", jn(((b)this.ymQ).yie, "#158E14"));
    ((Map)localObject1).put("borderDisableColor", jn(((b)this.ymQ).yid, "#00179E16"));
    int j = Color.parseColor((String)((Map)localObject1).get("fontNormalColor"));
    int k = Color.parseColor((String)((Map)localObject1).get("fontDisableColor"));
    int m = Color.parseColor((String)((Map)localObject1).get("fontPressedColor"));
    int n = Color.parseColor((String)((Map)localObject1).get("NormalColor"));
    int i1 = Color.parseColor((String)((Map)localObject1).get("PressedColor"));
    int i2 = Color.parseColor((String)((Map)localObject1).get("DisableColor"));
    int i3 = (int)((b)this.ymQ).yiO;
    int i4 = Color.parseColor((String)((Map)localObject1).get("borderNormalColor"));
    int i5 = Color.parseColor((String)((Map)localObject1).get("borderPressedColor"));
    int i6 = Color.parseColor((String)((Map)localObject1).get("borderDisableColor"));
    int i = this.context.getResources().getDimensionPixelSize(2131165207);
    if (((b)this.ymQ).rs > 0.0F) {
      i = (int)((b)this.ymQ).rs;
    }
    localObject1 = new GradientDrawable();
    ((GradientDrawable)localObject1).setShape(0);
    ((GradientDrawable)localObject1).setCornerRadius(i);
    ((GradientDrawable)localObject1).setColor(i2);
    ((GradientDrawable)localObject1).setStroke(i3, i6);
    Object localObject2 = new GradientDrawable();
    ((GradientDrawable)localObject2).setShape(0);
    ((GradientDrawable)localObject2).setCornerRadius(i);
    ((GradientDrawable)localObject2).setColor(i1);
    ((GradientDrawable)localObject2).setStroke(i3, i5);
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setShape(0);
    localGradientDrawable.setCornerRadius(i);
    localGradientDrawable.setColor(n);
    localGradientDrawable.setStroke(i3, i4);
    StateListDrawable localStateListDrawable = new StateListDrawable();
    localStateListDrawable.addState(new int[] { -16842910 }, (Drawable)localObject1);
    localStateListDrawable.addState(new int[] { 16842919 }, (Drawable)localObject2);
    localStateListDrawable.addState(new int[] { 16842910 }, localGradientDrawable);
    this.ynt.setBackground(localStateListDrawable);
    localObject1 = new int[] { -16842910 };
    localObject2 = new int[] { 16842919 };
    this.ynt.setTextColor(new ColorStateList(new int[][] { localObject1, localObject2, { 16842910 } }, new int[] { k, m, j }));
    if (((b)this.ymQ).bsJ > 0.0F) {
      this.ynt.setTextSize(0, ((b)this.ymQ).bsJ);
    }
    localObject1 = new GradientDrawable();
    ((GradientDrawable)localObject1).setShape(0);
    ((GradientDrawable)localObject1).setCornerRadius(i);
    ((GradientDrawable)localObject1).setColor(i1);
    ((GradientDrawable)localObject1).setStroke(i3, i5);
    localObject2 = new GradientDrawable();
    ((GradientDrawable)localObject2).setShape(0);
    ((GradientDrawable)localObject2).setCornerRadius(i);
    ((GradientDrawable)localObject2).setColor(n);
    localObject2 = new ClipDrawable((Drawable)localObject2, 3, 1);
    localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setShape(0);
    localGradientDrawable.setCornerRadius(i);
    localGradientDrawable.setColor(n);
    localObject1 = new LayerDrawable(new Drawable[] { localObject1, localObject2, new ClipDrawable(localGradientDrawable, 3, 1) });
    ((LayerDrawable)localObject1).setId(0, 16908288);
    ((LayerDrawable)localObject1).setId(1, 16908303);
    ((LayerDrawable)localObject1).setId(2, 16908301);
    this.ynu.setProgressDrawable((Drawable)localObject1);
    this.ynu.setPaintColor(((b)this.ymQ).yih);
    if (((b)this.ymQ).height > 0.0F)
    {
      localObject1 = (RelativeLayout.LayoutParams)this.yns.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).height = ((int)((b)this.ymQ).height);
      this.yns.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    }
    this.ynt.setText(((b)this.ymQ).title);
    ac.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "fillItem, sendMsg=11");
    this.ynv.Yv(11);
    AppMethodBeat.o(96555);
  }
  
  protected final int getLayout()
  {
    return 2131495490;
  }
  
  final class b
    extends BroadcastReceiver
    implements Serializable
  {
    private b() {}
    
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(96553);
      if (paramIntent != null)
      {
        paramContext = paramIntent.getAction();
        if ("android.intent.action.PACKAGE_ADDED".equals(paramContext))
        {
          paramContext = paramIntent.getData().getSchemeSpecificPart();
          if ((!TextUtils.isEmpty(paramContext)) && (paramContext.equals(q.b(q.this).JG))) {
            q.this.ynv.Yv(3);
          }
          AppMethodBeat.o(96553);
          return;
        }
        if ("android.intent.action.PACKAGE_REMOVED".equals(paramContext))
        {
          paramContext = paramIntent.getData().getSchemeSpecificPart();
          if ((!TextUtils.isEmpty(paramContext)) && (paramContext.equals(q.b(q.this).JG))) {
            q.this.ynv.Yv(4);
          }
        }
      }
      AppMethodBeat.o(96553);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.q
 * JD-Core Version:    0.7.0.1
 */