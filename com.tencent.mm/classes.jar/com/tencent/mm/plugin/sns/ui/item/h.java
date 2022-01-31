package com.tencent.mm.plugin.sns.ui.item;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Build.VERSION;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.g;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.SphereImageView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.SphereImageView.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.b.e;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.aw;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.RoundedCornerRelativeLayout;

public final class h
  extends BaseTimeLineItem
{
  protected ak loX;
  protected SphereImageView.b rBq;
  protected com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a rxL;
  private int rxM;
  protected b.e sgq;
  protected h.a sin;
  protected boolean sio;
  protected boolean sip;
  protected String siq;
  protected a.d sir;
  boolean sis;
  
  public h()
  {
    AppMethodBeat.i(145738);
    this.sio = true;
    this.sip = true;
    this.siq = null;
    this.loX = new ak(Looper.getMainLooper());
    this.rxM = 0;
    this.sir = new h.2(this);
    this.rBq = new h.3(this);
    this.sis = false;
    AppMethodBeat.o(145738);
  }
  
  public final void a(SphereImageView paramSphereImageView, boolean paramBoolean)
  {
    AppMethodBeat.i(145741);
    ab.d("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "setIsInLowPriority, isInLowPriority=" + paramBoolean + ", hash=" + paramSphereImageView.hashCode());
    this.sis = paramBoolean;
    if (paramBoolean)
    {
      paramSphereImageView.setSensorEnabled(false);
      AppMethodBeat.o(145741);
      return;
    }
    if (!this.sio) {
      paramSphereImageView.setSensorEnabled(true);
    }
    AppMethodBeat.o(145741);
  }
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, final aw paramaw, TimeLineObject paramTimeLineObject, int paramInt2, av paramav)
  {
    AppMethodBeat.i(145740);
    for (;;)
    {
      try
      {
        long l1 = System.currentTimeMillis();
        if (paramBaseViewHolder.ezJ)
        {
          ab.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "fillItem, holder is busy");
          AppMethodBeat.o(145740);
          return;
        }
        final h.a locala = (h.a)paramBaseViewHolder;
        Object localObject1 = paramaw.qXp;
        if ((localObject1 == null) || (((n)localObject1).csb() == null)) {
          break label1486;
        }
        paramTimeLineObject = ((n)localObject1).csb().rqJ;
        this.sgq = paramTimeLineObject;
        if ((Build.VERSION.SDK_INT < 24) && (paramTimeLineObject != null) && ((this.siq == null) || (!this.siq.equals(paramTimeLineObject.rrf))))
        {
          this.sio = true;
          this.sip = true;
          ab.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "fillItem, reset, sdk_int=" + Build.VERSION.SDK_INT);
        }
        paramaw = new StringBuilder("fillItem, pos=").append(paramInt1).append(", hash=").append(locala.siz.hashCode()).append(", isFirst=").append(this.sip).append(", snsInfo.hash=");
        if (localObject1 != null)
        {
          paramInt1 = localObject1.hashCode();
          ab.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", paramInt1);
          paramaw = null;
          locala.sfT.setVisibility(8);
          locala.sfV.setVisibility(8);
          locala.sfW.setVisibility(8);
          locala.sfU.setVisibility(8);
          locala.sfX.setVisibility(8);
          locala.sfY.setVisibility(8);
          locala.sfZ.setVisibility(8);
          if (paramTimeLineObject == null) {
            break label1475;
          }
          localObject2 = (WindowManager)this.mActivity.getSystemService("window");
          paramInt1 = Math.min(((WindowManager)localObject2).getDefaultDisplay().getWidth(), ((WindowManager)localObject2).getDefaultDisplay().getHeight()) - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 54) - this.mActivity.getResources().getDimensionPixelSize(2131427782) - this.mActivity.getResources().getDimensionPixelSize(2131427808) - this.mActivity.getResources().getDimensionPixelSize(2131427854);
          if (paramTimeLineObject.rqV == 0)
          {
            paramaw = new ViewGroup.LayoutParams(-2, -2);
            paramaw.width = paramInt1;
            paramaw.height = ((int)(paramaw.width * 0.75F));
            if (paramaw != null)
            {
              localObject2 = locala.rMB.getLayoutParams();
              ((ViewGroup.LayoutParams)localObject2).width = paramaw.width;
              ((ViewGroup.LayoutParams)localObject2).height = paramaw.height;
              locala.rMB.setLayoutParams((ViewGroup.LayoutParams)localObject2);
              ((RoundedCornerRelativeLayout)locala.rMB).setRadius(8.0F);
              localObject2 = locala.siz.getLayoutParams();
              ((ViewGroup.LayoutParams)localObject2).width = paramaw.width;
              ((ViewGroup.LayoutParams)localObject2).height = paramaw.height;
              locala.siz.setLayoutParams((ViewGroup.LayoutParams)localObject2);
              paramaw = locala.siA.getLayoutParams();
              paramaw.width = ((ViewGroup.LayoutParams)localObject2).width;
              paramaw.height = ((ViewGroup.LayoutParams)localObject2).height;
              locala.siA.setLayoutParams(paramaw);
            }
            if (paramTimeLineObject.rqX != 0) {
              continue;
            }
            paramInt1 = Color.argb((int)(paramTimeLineObject.rqW * 2.55F), 0, 0, 0);
            paramInt2 = Color.argb(0, 0, 0, 0);
            paramaw = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { paramInt1, paramInt2 });
            paramaw.setGradientType(0);
            locala.sfT.setBackground(paramaw);
            if ((!bo.isNullOrNil(paramTimeLineObject.title)) || (!bo.isNullOrNil(paramTimeLineObject.description))) {
              locala.sfT.setVisibility(0);
            }
            if (!bo.isNullOrNil(paramTimeLineObject.title))
            {
              locala.sfV.setVisibility(0);
              paramaw = locala.sfV;
              localObject2 = g.dvk();
              locala.sfV.getContext();
              paramaw.setText(((g)localObject2).b(paramTimeLineObject.title, locala.sfV.getTextSize()));
            }
            if (!bo.isNullOrNil(paramTimeLineObject.description))
            {
              locala.sfW.setVisibility(0);
              paramaw = locala.sfW;
              localObject2 = g.dvk();
              locala.sfW.getContext();
              paramaw.setText(((g)localObject2).b(paramTimeLineObject.description, locala.sfW.getTextSize()));
            }
            if ((localObject1 != null) && (((n)localObject1).csd().cqi()))
            {
              paramInt1 = Color.argb((int)(paramTimeLineObject.rqW * 2.55F), 0, 0, 0);
              paramInt2 = Color.argb(0, 0, 0, 0);
              paramaw = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[] { paramInt1, paramInt2 });
              paramaw.setGradientType(0);
              locala.sfU.setVisibility(0);
              locala.sfU.setBackground(paramaw);
              locala.sfZ.setVisibility(0);
            }
            if (this.sip)
            {
              locala.siA.setVisibility(0);
              paramaw = paramTimeLineObject.rrf;
              localObject1 = paramTimeLineObject.rrg;
              new a.c(paramaw, (String)localObject1, "scene_timeline", new a.d()
              {
                public final void a(boolean paramAnonymousBoolean, String paramAnonymousString1, Bitmap paramAnonymousBitmap, String paramAnonymousString2)
                {
                  AppMethodBeat.i(145737);
                  if ((paramAnonymousString2 == null) || (!paramAnonymousString2.equals(paramaw)))
                  {
                    AppMethodBeat.o(145737);
                    return;
                  }
                  if (paramAnonymousBitmap != null)
                  {
                    locala.siA.setImageBitmap(paramAnonymousBitmap);
                    AppMethodBeat.o(145737);
                    return;
                  }
                  ab.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "show progressView");
                  locala.siB.setVisibility(0);
                  locala.siB.dOF();
                  if (!TextUtils.isEmpty(this.fEW))
                  {
                    ab.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "no shot and thumb cache, start download thumb image");
                    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(this.fEW, 133, new f.a()
                    {
                      String six;
                      
                      public final void abi(String paramAnonymous2String)
                      {
                        AppMethodBeat.i(145736);
                        ab.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "onDownloaded thumb, path=".concat(String.valueOf(paramAnonymous2String)));
                        if (h.this.sgq != null) {}
                        for (String str = h.this.sgq.rrg; (this.six != null) && (this.six.equals(str)); str = "")
                        {
                          if (h.4.this.siu.siA.getVisibility() != 0) {
                            break label149;
                          }
                          try
                          {
                            paramAnonymous2String = MMBitmapFactory.decodeFile(paramAnonymous2String);
                            h.4.this.siu.siA.setImageBitmap(paramAnonymous2String);
                            AppMethodBeat.o(145736);
                            return;
                          }
                          catch (Throwable paramAnonymous2String)
                          {
                            ab.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "onDownloaded thumb exp:" + paramAnonymous2String.toString());
                            AppMethodBeat.o(145736);
                            return;
                          }
                        }
                        ab.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "onDownloaded, url != nowUrl");
                        label149:
                        AppMethodBeat.o(145736);
                      }
                      
                      public final void coe()
                      {
                        AppMethodBeat.i(145735);
                        ab.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "onDownloadError thumb");
                        AppMethodBeat.o(145735);
                      }
                      
                      public final void cqU() {}
                    });
                    AppMethodBeat.o(145737);
                    return;
                  }
                  ab.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "thumbUrl is empty");
                  AppMethodBeat.o(145737);
                }
                
                public final void onStart(String paramAnonymousString) {}
              }).execute(new Void[0]);
            }
            locala.siz.setVisibility(0);
            locala.siz.setOnClickListener(paramav.rks.sjX);
            locala.siz.setTag(paramBaseViewHolder);
            if ((!this.sio) && (!this.sis))
            {
              ab.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "fillItem !first, enable sensor");
              locala.siz.setSensorEnabled(true);
            }
            if ((this.siq == null) || (!this.siq.equals(paramTimeLineObject.rrf)))
            {
              ab.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "fillItem, loadImage, hash=" + locala.siz.hashCode());
              paramBaseViewHolder = locala.siz.getLayoutParams();
              this.rxL.j(paramTimeLineObject.rrf, paramBaseViewHolder.width, paramBaseViewHolder.height, "scene_timeline");
              this.siq = paramTimeLineObject.rrf;
            }
            this.sip = false;
            long l2 = System.currentTimeMillis();
            ab.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "fillItem total timeCost=" + (l2 - l1));
            AppMethodBeat.o(145740);
          }
        }
        else
        {
          paramInt1 = 0;
          continue;
        }
        if (paramTimeLineObject.rqV != 1) {
          continue;
        }
        paramaw = new ViewGroup.LayoutParams(-2, -2);
        paramaw.width = paramInt1;
        paramaw.height = paramaw.width;
        continue;
        if (paramTimeLineObject.rqX != 1) {
          continue;
        }
        paramInt1 = Color.argb((int)(paramTimeLineObject.rqW * 2.55F), 0, 0, 0);
        paramInt2 = Color.argb(0, 0, 0, 0);
        paramaw = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[] { paramInt1, paramInt2 });
        paramaw.setGradientType(0);
        locala.sfU.setBackground(paramaw);
        if ((!bo.isNullOrNil(paramTimeLineObject.title)) || (!bo.isNullOrNil(paramTimeLineObject.description)))
        {
          locala.sfU.setVisibility(0);
          paramaw = (RelativeLayout.LayoutParams)locala.sfZ.getLayoutParams();
          paramaw.topMargin = com.tencent.mm.cb.a.fromDPToPix(locala.rMB.getContext(), 4);
          locala.sfZ.setLayoutParams(paramaw);
        }
        if (!bo.isNullOrNil(paramTimeLineObject.title))
        {
          locala.sfX.setVisibility(0);
          paramaw = locala.sfX;
          localObject2 = g.dvk();
          locala.sfX.getContext();
          paramaw.setText(((g)localObject2).b(paramTimeLineObject.title, locala.sfX.getTextSize()));
        }
        if (bo.isNullOrNil(paramTimeLineObject.description)) {
          continue;
        }
        locala.sfY.setVisibility(0);
        paramaw = locala.sfY;
        Object localObject2 = g.dvk();
        locala.sfY.getContext();
        paramaw.setText(((g)localObject2).b(paramTimeLineObject.description, locala.sfY.getTextSize()));
        continue;
        ab.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "sphereCardInfo==null, invalid sphereCard");
      }
      catch (Throwable paramBaseViewHolder)
      {
        ab.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "fillItem exp=" + paramBaseViewHolder.toString());
        AppMethodBeat.o(145740);
        return;
      }
      label1475:
      continue;
      label1486:
      paramTimeLineObject = null;
    }
  }
  
  public final void d(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(145739);
    for (;;)
    {
      try
      {
        h.a locala = (h.a)paramBaseViewHolder;
        this.sin = locala;
        ab.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "buildContent, holder=" + paramBaseViewHolder.hashCode());
        if (paramBaseViewHolder.sgT != null)
        {
          paramBaseViewHolder.sgT.setLayoutResource(2130970878);
          if (!paramBaseViewHolder.sgU)
          {
            locala.rMB = paramBaseViewHolder.sgT.inflate();
            paramBaseViewHolder.sgU = true;
          }
          locala.sfT = locala.ngZ.findViewById(2131828116);
          locala.sfU = locala.ngZ.findViewById(2131828119);
          locala.sfV = ((TextView)locala.ngZ.findViewById(2131828117));
          locala.sfW = ((TextView)locala.ngZ.findViewById(2131828118));
          locala.sfX = ((TextView)locala.ngZ.findViewById(2131828120));
          locala.sfY = ((TextView)locala.ngZ.findViewById(2131828121));
          locala.siz = ((SphereImageView)locala.ngZ.findViewById(2131828125));
          locala.sfZ = locala.ngZ.findViewById(2131828122);
          locala.siA = ((ImageView)locala.ngZ.findViewById(2131827870));
          locala.siB = ((MMPinProgressBtn)locala.ngZ.findViewById(2131821404));
          locala.siB.setMax(50);
          ab.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "buildContent, disable touch and sensor");
          locala.siz.setTouchEnabled(false);
          locala.siz.setSensorEnabled(false);
          locala.siz.ad(1.8F, -2.0F);
          locala.siz.setTouchSensitivity(0.45F);
          locala.siz.setEventListener(this.rBq);
          this.rxL = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a();
          this.rxL.a(this.sir);
          if (this.sgq == null)
          {
            i = 0;
            this.loX.postDelayed(new h.1(this, i, locala), i);
            ab.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "viewHash=" + locala.siz.hashCode() + ", touchDelay=" + i);
            AppMethodBeat.o(145739);
          }
        }
        else
        {
          if (paramBaseViewHolder.sgU) {
            continue;
          }
          locala.rMB = paramBaseViewHolder.ngZ.findViewById(2131828124);
          paramBaseViewHolder.sgU = true;
          continue;
        }
        int i = this.sgq.rre;
      }
      catch (Throwable paramBaseViewHolder)
      {
        ab.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "buildContent exp=" + paramBaseViewHolder.toString());
        AppMethodBeat.o(145739);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.h
 * JD-Core Version:    0.7.0.1
 */