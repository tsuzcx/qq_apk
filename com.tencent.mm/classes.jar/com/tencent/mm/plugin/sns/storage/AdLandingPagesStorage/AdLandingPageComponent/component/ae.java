package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Outline;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.protocal.protobuf.btl;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

public final class ae
  extends m
{
  volatile String DDP = "";
  boolean DYJ;
  com.tencent.mm.plugin.sns.data.h EcI;
  boolean Ecz = true;
  private ImageView dKU;
  volatile String imageUrl = "";
  ProgressBar progressBar;
  
  public ae(Context paramContext, t paramt, ViewGroup paramViewGroup)
  {
    super(paramContext, paramt, paramViewGroup);
  }
  
  public final boolean ay(Bitmap paramBitmap)
  {
    AppMethodBeat.i(96697);
    if (paramBitmap == null)
    {
      Log.e("AdLandingPagePureImageComponet", "when set image the bmp is null!");
      AppMethodBeat.o(96697);
      return false;
    }
    if (this.dKU == null)
    {
      Log.e("AdLandingPagePureImageComponet", "when set image the imageView is null!");
      AppMethodBeat.o(96697);
      return false;
    }
    if (paramBitmap.getWidth() == 0)
    {
      Log.e("AdLandingPagePureImageComponet", "when set image the bmp.getWidth is 0!");
      AppMethodBeat.o(96697);
      return false;
    }
    this.dKU.setImageBitmap(paramBitmap);
    this.progressBar.setVisibility(8);
    AppMethodBeat.o(96697);
    return true;
  }
  
  public final boolean bp(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(96698);
    if (!super.bp(paramJSONObject))
    {
      AppMethodBeat.o(96698);
      return false;
    }
    try
    {
      if (!this.Ecz)
      {
        String str = MD5Util.getMD5String(this.imageUrl);
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("urlMd5", str);
        localJSONObject.put("needDownload", 1);
        paramJSONObject.put("imgUrlInfo", localJSONObject);
      }
      AppMethodBeat.o(96698);
      return true;
    }
    catch (JSONException paramJSONObject)
    {
      Log.printErrStackTrace("AdLandingPagePureImageComponet", paramJSONObject, "", new Object[0]);
      AppMethodBeat.o(96698);
    }
    return false;
  }
  
  protected final void eWT()
  {
    AppMethodBeat.i(96695);
    if ((this.contentView == null) || (this.dKU == null) || (this.progressBar == null))
    {
      AppMethodBeat.o(96695);
      return;
    }
    if ((t)this.EcX == null)
    {
      AppMethodBeat.o(96695);
      return;
    }
    int i = ((t)this.EcX).scaleType;
    if (i == 0) {
      this.dKU.setScaleType(ImageView.ScaleType.FIT_XY);
    }
    for (;;)
    {
      Log.i("AdLandingPagePureImageComponet", "cid=" + ((t)this.EcX).DZi + ", scaleType=" + i);
      this.imageUrl = ((t)this.EcX).DYK;
      Object localObject = ((t)this.EcX).DWN;
      float f2 = ((t)this.EcX).height;
      final float f1 = ((t)this.EcX).width;
      this.DYJ = ((t)this.EcX).DYJ;
      if ((f2 != 0.0F) && (f1 != 0.0F) && (!this.DYJ))
      {
        i = this.mEX - (int)((t)this.EcX).paddingLeft - (int)((t)this.EcX).paddingRight;
        if (f1 < i)
        {
          label229:
          f2 = f1 * ((t)this.EcX).height / ((t)this.EcX).width;
          this.dKU.setLayoutParams(new RelativeLayout.LayoutParams((int)f1, (int)f2));
          label271:
          if ((localObject == null) || (((String)localObject).length() <= 0)) {}
        }
      }
      try
      {
        this.dKU.setBackgroundColor(Color.parseColor((String)localObject));
        label296:
        if ((this.imageUrl == null) || (this.imageUrl.length() <= 0))
        {
          Log.i("AdLandingPagePureImageComponet", "Pure image component fillItem without imageurl.");
          AppMethodBeat.o(96695);
          return;
          if (i != 1) {
            continue;
          }
          this.dKU.setScaleType(ImageView.ScaleType.CENTER_CROP);
          continue;
          f1 = i;
          break label229;
          if ((this.DYJ) && (f2 != 0.0F) && (f1 != 0.0F))
          {
            this.dKU.setLayoutParams(new RelativeLayout.LayoutParams(this.mEX, this.mEY));
            break label271;
          }
          this.dKU.setLayoutParams(new RelativeLayout.LayoutParams(this.mEX, this.mEY));
          break label271;
        }
        localObject = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.kD("adId", this.imageUrl);
        if ((localObject != null) && (ay((Bitmap)localObject)))
        {
          Log.i("AdLandingPagePureImageComponet", "loaded cached image with  " + this.imageUrl);
          localObject = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.kz("adId", this.imageUrl);
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (s.YS((String)localObject))) {
            this.DDP = ((String)localObject);
          }
          this.Ecz = true;
        }
        for (;;)
        {
          if ((((t)this.EcX).DYL) && (((t)this.EcX).DYN)) {}
          try
          {
            Log.i("AdLandingPagePureImageComponet", "request new qr image imgUrl");
            AdLandingPagesProxy.getInstance().doAdUpdateQrUrlScene("", ((t)this.EcX).DYM, "", fds().uxInfo, fdn(), fds().getSnsId(), new b(this));
            f1 = ((t)this.EcX).tt;
            if (f1 > 0.0F)
            {
              Log.i("AdLandingPagePureImageComponet", "fillItem, cornerRadius=" + f1 + ", cId=" + fdn() + ", viewHash=" + this.dKU.hashCode());
              this.dKU.setClipToOutline(true);
              this.dKU.setOutlineProvider(new ViewOutlineProvider()
              {
                public final void getOutline(View paramAnonymousView, Outline paramAnonymousOutline)
                {
                  AppMethodBeat.i(202994);
                  if (paramAnonymousView != null)
                  {
                    Log.d("AdLandingPagePureImageComponet", "getOutline, viewW=" + paramAnonymousView.getWidth() + ", vewH=" + paramAnonymousView.getHeight());
                    paramAnonymousOutline.setRoundRect(0, 0, paramAnonymousView.getWidth(), paramAnonymousView.getHeight(), f1);
                  }
                  AppMethodBeat.o(202994);
                }
              });
            }
            AppMethodBeat.o(96695);
            return;
            this.Ecz = false;
            startLoading();
            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(this.imageUrl, ((t)this.EcX).DZj, new f.a()
            {
              public final void aNH(String paramAnonymousString)
              {
                AppMethodBeat.i(96685);
                try
                {
                  if (ae.a(ae.this).DYK.equals(ae.this.imageUrl))
                  {
                    Bitmap localBitmap = BitmapUtil.decodeFile(paramAnonymousString);
                    ae.this.ay(localBitmap);
                    ae.this.DDP = paramAnonymousString;
                  }
                  AppMethodBeat.o(96685);
                  return;
                }
                catch (Exception paramAnonymousString)
                {
                  Log.e("AdLandingPagePureImageComponet", "%s" + Util.stackTraceToString(paramAnonymousString));
                  AppMethodBeat.o(96685);
                }
              }
              
              public final void eWN()
              {
                AppMethodBeat.i(96683);
                ae.this.startLoading();
                AppMethodBeat.o(96683);
              }
              
              public final void eWO()
              {
                AppMethodBeat.i(96684);
                ae.this.progressBar.setVisibility(8);
                AppMethodBeat.o(96684);
              }
            });
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              Log.e("AdLandingPagePureImageComponet", localThrowable.toString());
            }
          }
        }
      }
      catch (Exception localException)
      {
        break label296;
      }
    }
  }
  
  protected final void eWX()
  {
    AppMethodBeat.i(96694);
    Object localObject = this.contentView.getLayoutParams();
    if ((localObject instanceof ViewGroup.MarginLayoutParams))
    {
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      ((ViewGroup.MarginLayoutParams)localObject).setMargins((int)((t)this.EcX).paddingLeft, (int)((t)this.EcX).paddingTop, (int)((t)this.EcX).paddingRight, (int)((t)this.EcX).paddingBottom);
      this.contentView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    AppMethodBeat.o(96694);
  }
  
  public final void eXe()
  {
    AppMethodBeat.i(96693);
    this.dKU = ((ImageView)this.contentView.findViewById(2131308051));
    this.progressBar = ((ProgressBar)this.contentView.findViewById(2131306302));
    if (((t)this.EcX).DYL)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("qrExtInfo", ((t)this.EcX).DYM);
      this.EcI = new com.tencent.mm.plugin.sns.data.h(this.context, fds(), 1, localBundle);
      this.dKU.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(202995);
          b localb = new b();
          localb.bm(paramAnonymousView);
          a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPagePureImageComponet$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
          Log.i("AdLandingPagePureImageComponet", "onLongClick, filePath=" + ae.this.DDP);
          boolean bool = ae.this.EcI.jX(ae.this.DDP, ae.this.imageUrl);
          a.a(bool, this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPagePureImageComponet$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(202995);
          return bool;
        }
      });
    }
    AppMethodBeat.o(96693);
  }
  
  protected final int getLayout()
  {
    return 2131496392;
  }
  
  public final void startLoading()
  {
    AppMethodBeat.i(96696);
    this.progressBar.setVisibility(0);
    AppMethodBeat.o(96696);
  }
  
  public static final class a
    implements f.a
  {
    WeakReference<ae> EfK;
    
    a(ae paramae)
    {
      AppMethodBeat.i(202996);
      this.EfK = new WeakReference(paramae);
      AppMethodBeat.o(202996);
    }
    
    public final void aNH(String paramString)
    {
      AppMethodBeat.i(202998);
      ae localae = (ae)this.EfK.get();
      if (localae != null)
      {
        Log.i("AdLandingPagePureImageComponet", "download qr image completed, the path " + paramString + "; cId " + localae.fdn());
        localae.ay(BitmapUtil.decodeFile(paramString));
        localae.DDP = paramString;
        AppMethodBeat.o(202998);
        return;
      }
      Log.w("AdLandingPagePureImageComponet", "qrCodePureImageComp is null in weak ref");
      AppMethodBeat.o(202998);
    }
    
    public final void eWN() {}
    
    public final void eWO()
    {
      AppMethodBeat.i(202997);
      Log.e("AdLandingPagePureImageComponet", "there is something error happening when downloading qr image.");
      AppMethodBeat.o(202997);
    }
  }
  
  public static final class b
    implements AdLandingPagesProxy.e
  {
    private WeakReference<ae> EfK;
    
    b(ae paramae)
    {
      AppMethodBeat.i(202999);
      this.EfK = new WeakReference(paramae);
      AppMethodBeat.o(202999);
    }
    
    public final void bn(Object paramObject) {}
    
    public final void h(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(203000);
      if ((paramInt1 == 0) && (paramInt2 == 0)) {}
      try
      {
        if ((paramObject instanceof byte[]))
        {
          btl localbtl = new btl();
          localbtl.parseFrom((byte[])paramObject);
          if (this.EfK != null)
          {
            paramObject = (ae)this.EfK.get();
            if ((paramObject != null) && (paramObject.fdn().equals(localbtl.Mac)))
            {
              Log.i("AdLandingPagePureImageComponet", "request new qr image imgUrl completed");
              paramObject.imageUrl = localbtl.url;
              com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(paramObject.imageUrl, ae.a(paramObject).DZj, new ae.a(paramObject));
            }
          }
          AppMethodBeat.o(203000);
          return;
        }
        Log.e("AdLandingPagePureImageComponet", "request new qr image imgUrl failed");
        AppMethodBeat.o(203000);
        return;
      }
      catch (Throwable paramObject)
      {
        Log.e("AdLandingPagePureImageComponet", paramObject.toString());
        AppMethodBeat.o(203000);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ae
 * JD-Core Version:    0.7.0.1
 */