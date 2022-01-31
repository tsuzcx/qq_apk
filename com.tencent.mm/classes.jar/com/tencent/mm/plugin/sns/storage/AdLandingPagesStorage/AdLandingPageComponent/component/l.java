package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.plugin.sns.ui.SnsAdProxyUI;
import com.tencent.mm.pluginsdk.ui.d.c;
import com.tencent.mm.pluginsdk.ui.d.c.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;
import java.util.Map;

public class l
  extends k
{
  RelativeLayout lFV;
  Button oFR;
  View oFS;
  
  public l(Context paramContext, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l paraml, ViewGroup paramViewGroup)
  {
    super(paramContext, paraml, paramViewGroup);
  }
  
  @TargetApi(17)
  public final View bFf()
  {
    View localView = this.contentView;
    this.lFV = ((RelativeLayout)localView.findViewById(i.f.sns_ad_native_landing_pages_item_btn_relative));
    this.oFR = ((Button)localView.findViewById(i.f.sns_ad_native_landing_pages_item_btn_btn));
    this.oFS = localView.findViewById(i.f.sns_ad_native_landing_pages_item_gray_cover);
    return localView;
  }
  
  @TargetApi(17)
  protected final void bFj()
  {
    this.oFs = 0;
    int i = ((WindowManager)this.context.getSystemService("window")).getDefaultDisplay().getWidth();
    int j = i;
    if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l)this.oFE).oDm > 0.0F)
    {
      j = i;
      if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l)this.oFE).oDm < i * 2)
      {
        i = (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l)this.oFE).oDm;
        j = (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l)this.oFE).oDk;
        j = (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l)this.oFE).oDl + (i + j);
      }
    }
    this.lFV.setBackgroundColor(this.backgroundColor);
    if (!bk.bl(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l)this.oFE).oCJ))
    {
      h.c("adId", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l)this.oFE).oCJ, false, 0, new f.a()
      {
        @TargetApi(16)
        public final void Op(String paramAnonymousString)
        {
          try
          {
            paramAnonymousString = Drawable.createFromPath(paramAnonymousString);
            l.this.oFR.setBackground(paramAnonymousString);
            if ((paramAnonymousString != null) && (l.this.bFt().height > 0.0F) && (paramAnonymousString.getIntrinsicHeight() > 0))
            {
              float f = l.this.bFt().height * paramAnonymousString.getIntrinsicWidth() / paramAnonymousString.getIntrinsicHeight();
              l.this.oFR.setLayoutParams(new RelativeLayout.LayoutParams((int)f, (int)l.this.bFt().height));
            }
            return;
          }
          catch (Exception paramAnonymousString)
          {
            y.e("MicroMsg.Sns.AdLandingPageBtnComponent", "the backgroundCoverUrl is set error ,because " + paramAnonymousString.toString());
          }
        }
        
        public final void bCF() {}
        
        public final void bFl() {}
      });
      this.oFR.setText(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l)this.oFE).title);
      e(this.oFR);
      this.oFR.setTextSize(0, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l)this.oFE).fontSize);
      if ((((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l)this.oFE).oCF == null) || (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l)this.oFE).oCF.length() <= 0)) {}
    }
    for (;;)
    {
      try
      {
        i = Color.parseColor(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l)this.oFE).oCF);
        this.oFR.setTextColor(i);
      }
      catch (Exception localException1)
      {
        try
        {
          for (;;)
          {
            this.oFR.setTextAlignment(4);
            if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l)this.oFE).height <= 0.0F) {
              break label631;
            }
            this.oFR.setLayoutParams(new RelativeLayout.LayoutParams(j - (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l)this.oFE).oDk - (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l)this.oFE).oDl, (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l)this.oFE).height));
            if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l)this.oFE).oCK != 1) {
              break label683;
            }
            this.oFS.setLayoutParams(new RelativeLayout.LayoutParams(j - (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l)this.oFE).oDk - (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l)this.oFE).oDl, this.oFS.getLayoutParams().height));
            this.oFS.setVisibility(0);
            this.oFS.setOnLongClickListener(new l.2(this));
            this.oFS.setOnClickListener(new l.3(this));
            return;
            GradientDrawable localGradientDrawable = new GradientDrawable();
            localGradientDrawable.setShape(0);
            if ((bk.bl(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l)this.oFE).oCI)) || (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l)this.oFE).oCG <= 0.0F)) {
              break label693;
            }
            try
            {
              i = Color.parseColor(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l)this.oFE).oCI);
              localGradientDrawable.setStroke((int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l)this.oFE).oCG, i);
              i = 1;
              if (bk.bl(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l)this.oFE).oCH)) {}
            }
            catch (Exception localException3)
            {
              try
              {
                i = Color.parseColor(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l)this.oFE).oCH);
                localGradientDrawable.setColor(i);
                i = 1;
                if (i == 0) {
                  break;
                }
                this.oFR.setBackgroundDrawable(localGradientDrawable);
                break;
                localException3 = localException3;
                y.e("MicroMsg.Sns.AdLandingPageBtnComponent", bk.j(localException3));
                i = 0;
              }
              catch (Exception localException4)
              {
                for (;;)
                {
                  y.e("MicroMsg.Sns.AdLandingPageBtnComponent", bk.j(localException4));
                  i = 0;
                }
              }
            }
          }
          localException1 = localException1;
          y.e("MicroMsg.Sns.AdLandingPageBtnComponent", "invalid color! %s", new Object[] { ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l)this.oFE).oCF });
          continue;
        }
        catch (Exception localException2)
        {
          y.e("MicroMsg.Sns.AdLandingPageBtnComponent", "the device has no method btn.setTextAlignment");
          continue;
          label631:
          this.oFR.setLayoutParams(new RelativeLayout.LayoutParams(j - (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l)this.oFE).oDk - (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l)this.oFE).oDl, this.oFR.getLayoutParams().height));
          continue;
          label683:
          this.oFS.setVisibility(8);
          return;
        }
      }
      label693:
      i = 0;
    }
  }
  
  protected final com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l bFt()
  {
    return (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l)this.oFE;
  }
  
  protected final void bFu()
  {
    Object localObject4 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l)this.oFE;
    Object localObject1 = "";
    int i;
    if ((this.context instanceof Activity))
    {
      localObject1 = ad.Or(((Activity)this.context).getIntent().getStringExtra("sns_landing_pages_rawSnsId"));
      i = ((Activity)this.context).getIntent().getIntExtra("sns_landig_pages_from_source", 0);
      ((Activity)this.context).getIntent().getIntExtra("sns_landing_pages_adType", 0);
    }
    for (;;)
    {
      Object localObject2;
      Object localObject3;
      if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l)localObject4).brC == 4)
      {
        localObject2 = (f)localObject4;
        localObject1 = ((f)localObject2).imW;
        if (!(this.context instanceof SnsAdNativeLandingPagesUI)) {
          break label1476;
        }
        localObject3 = (SnsAdNativeLandingPagesUI)this.context;
        localObject4 = ((f)localObject2).imf;
        if ((localObject4 != null) && (((SnsAdNativeLandingPagesUI)localObject3).oUr.containsKey(localObject4))) {
          localObject1 = (String)((SnsAdNativeLandingPagesUI)localObject3).oUr.get(localObject4);
        }
      }
      label662:
      label1047:
      label1087:
      label1476:
      for (;;)
      {
        y.i("MicroMsg.Sns.AdLandingPageBtnComponent", "ext is " + (String)localObject1);
        localObject3 = new Intent();
        ((Intent)localObject3).putExtra("key_card_id", ((f)localObject2).imf);
        ((Intent)localObject3).putExtra("key_card_ext", (String)localObject1);
        ((Intent)localObject3).putExtra("key_from_scene", 21);
        ((Intent)localObject3).putExtra("key_stastic_scene", 15);
        d.b(this.context, "card", ".ui.CardDetailUI", (Intent)localObject3);
        do
        {
          return;
          break;
          if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l)localObject4).brC != 8) {
            break label662;
          }
        } while (!((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l)this.oFE instanceof j));
        localObject3 = "";
        if (((this.context instanceof Activity)) && (bFm().oDw == 2)) {
          localObject3 = ((Activity)this.context).getIntent().getStringExtra("sns_landing_pages_sessionId");
        }
        for (localObject2 = ((Activity)this.context).getIntent().getStringExtra("sns_landing_pages_ad_buffer");; localObject2 = "")
        {
          localObject3 = String.format("%s:%s:%s:%s:%d:%s:%s:%d", new Object[] { localObject3, localObject2, ((j)(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l)this.oFE).oDg, String.valueOf(System.currentTimeMillis() / 1000L), Integer.valueOf(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l)localObject4).oDw), ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l)localObject4).ovV, localObject1, Integer.valueOf(i) });
          localObject4 = (j)this.oFE;
          if ((this.context instanceof SnsAdNativeLandingPagesUI))
          {
            localObject1 = (SnsAdNativeLandingPagesUI)this.context;
            if (((SnsAdNativeLandingPagesUI)localObject1).oAl == null)
            {
              localObject1 = "";
              localObject2 = (SnsAdNativeLandingPagesUI)this.context;
              if (((SnsAdNativeLandingPagesUI)localObject2).fLi != null) {
                break label635;
              }
              localObject2 = "";
            }
          }
          for (;;)
          {
            localObject1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.l(((j)localObject4).cas, new String[] { String.format("gdt_vid=%s", new Object[] { localObject2 }), String.format("weixinadinfo=%s.%s.0.0", new Object[] { localObject1, localObject2 }) });
            localObject2 = new Intent();
            ((Intent)localObject2).putExtra("username", ((j)localObject4).username);
            ((Intent)localObject2).putExtra("url", (String)localObject1);
            ((Intent)localObject2).putExtra("sceneNote", (String)localObject3);
            ((Intent)localObject2).setClass(this.context, SnsAdProxyUI.class);
            this.context.startActivity((Intent)localObject2);
            return;
            localObject1 = ((SnsAdNativeLandingPagesUI)localObject1).oAl;
            break;
            label635:
            localObject2 = ((SnsAdNativeLandingPagesUI)localObject2).fLi;
            continue;
            localObject1 = ((j)localObject4).oAl;
            localObject2 = ((j)localObject4).oAk;
          }
          if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l)localObject4).brC == 9)
          {
            localObject1 = (g)localObject4;
            localObject2 = new Intent();
            ((Intent)localObject2).putExtra("map_view_type", 1);
            ((Intent)localObject2).putExtra("kwebmap_slat", ((g)localObject1).oCv.lCJ);
            ((Intent)localObject2).putExtra("kwebmap_lng", ((g)localObject1).oCv.lCK);
            ((Intent)localObject2).putExtra("kwebmap_scale", ((g)localObject1).oCv.bRv);
            ((Intent)localObject2).putExtra("kPoiName", ((g)localObject1).oCv.bVA);
            ((Intent)localObject2).putExtra("Kwebmap_locaion", ((g)localObject1).oCv.lCM);
            y.i("MicroMsg.Sns.AdLandingPageBtnComponent", "locatint to slat " + ((g)localObject1).oCv.lCJ + ", slong " + ((g)localObject1).oCv.lCK + ", " + ((g)localObject1).oCv.bVA);
            d.b(this.context, "location", ".ui.RedirectUI", (Intent)localObject2, 2);
            return;
          }
          if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l)localObject4).brC == 10)
          {
            if (c.a.sjo == null) {
              break;
            }
            localObject1 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.i)localObject4;
            if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.i)localObject1).oCu.size() > 1)
            {
              c.a.sjo.a(this.context, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.i)localObject1).oCu, new l.5(this));
              return;
            }
            if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.i)localObject1).oCu.size() <= 0) {
              break;
            }
            AdLandingPagesProxy.getInstance().confirmDialPhoneNum((Activity)this.context, (String)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.i)localObject1).oCu.get(0));
            return;
          }
          if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l)localObject4).brC == 11)
          {
            if (!(this.context instanceof SnsAdNativeLandingPagesUI)) {
              break;
            }
            localObject1 = (SnsAdNativeLandingPagesUI)this.context;
            localObject2 = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l)localObject4).oCR;
            localObject3 = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l)localObject4).oCO;
            String str1 = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l)localObject4).oCP;
            String str2 = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l)localObject4).oCQ;
            boolean bool1;
            boolean bool2;
            if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l)localObject4).oCM == 1)
            {
              bool1 = true;
              if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l)localObject4).oCN != 1) {
                break label1087;
              }
              bool2 = true;
              if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l)this.oFE).oCL != 1) {
                break label1092;
              }
            }
            label1092:
            for (boolean bool3 = true;; bool3 = false)
            {
              ((SnsAdNativeLandingPagesUI)localObject1).a((s)localObject2, (String)localObject3, str1, str2, bool1, bool2, bool3);
              return;
              bool1 = false;
              break;
              bool2 = false;
              break label1047;
            }
          }
          localObject3 = new Intent();
          localObject2 = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l)localObject4).oCD;
          localObject1 = localObject2;
          if (!TextUtils.isEmpty(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l)localObject4).oAk))
          {
            localObject1 = localObject2;
            if (!TextUtils.isEmpty(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l)localObject4).oAl)) {
              localObject1 = ad.k((String)localObject2, new String[] { "traceid=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l)localObject4).oAk + "&aid=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l)localObject4).oAl });
            }
          }
          y.i("MicroMsg.Sns.AdLandingPageBtnComponent", "open url %s", new Object[] { localObject1 });
          ((Intent)localObject3).putExtra("rawUrl", (String)localObject1);
          ((Intent)localObject3).putExtra("useJs", true);
          ((Intent)localObject3).putExtra("type", -255);
          ((Intent)localObject3).putExtra("geta8key_scene", 2);
          if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l)this.oFE).oDw == 0) {
            ((Intent)localObject3).putExtra("jsapiargs", new Bundle());
          }
          long l;
          if (((this.context instanceof Activity)) && (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l)this.oFE).oDw == 2))
          {
            localObject2 = ((Activity)this.context).getIntent().getStringExtra("sns_landing_pages_sessionId");
            localObject1 = ((Activity)this.context).getIntent().getStringExtra("sns_landing_pages_ad_buffer");
            if (!bk.bl((String)localObject2))
            {
              l = System.currentTimeMillis() / 1000L;
              if (bk.bl((String)localObject1)) {
                break label1460;
              }
            }
          }
          for (;;)
          {
            localObject1 = String.format("official_mall_%s_%s_%s_%s", new Object[] { localObject1, localObject2, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l)this.oFE).oDg, String.valueOf(l) });
            ((Intent)localObject3).putExtra("prePublishId", (String)localObject1);
            ((Intent)localObject3).putExtra("KPublisherId", (String)localObject1);
            ((Intent)localObject3).putExtra("pay_channel", 47);
            d.b(this.context, "webview", ".ui.tools.WebViewUI", (Intent)localObject3);
            return;
            localObject1 = "";
          }
        }
      }
      label1460:
      i = 0;
    }
  }
  
  protected void e(Button paramButton)
  {
    paramButton.setOnClickListener(new l.4(this));
  }
  
  protected final int getLayout()
  {
    return i.g.sns_ad_native_landing_pages_item_btn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.l
 * JD-Core Version:    0.7.0.1
 */