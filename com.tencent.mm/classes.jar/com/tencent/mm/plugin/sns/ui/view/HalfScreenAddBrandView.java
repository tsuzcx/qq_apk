package com.tencent.mm.plugin.sns.ui.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.a.c;
import com.tencent.mm.plugin.sns.data.f;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.e.a.1;
import com.tencent.mm.plugin.sns.e.a.a;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.RoundCornerImageView;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import org.json.JSONObject;

public class HalfScreenAddBrandView
  extends RelativeLayout
  implements View.OnClickListener
{
  private WeImageView AQI;
  private int JCO;
  private f JPm;
  private com.tencent.mm.plugin.sns.e.a Kqq;
  private RoundCornerImageView Lsa;
  private TextView Lsb;
  private TextView Lsc;
  private TextView Lsd;
  private TextView Lse;
  private Button Lsf;
  private View jac;
  private Context mContext;
  
  public HalfScreenAddBrandView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public HalfScreenAddBrandView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public HalfScreenAddBrandView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(229969);
    this.mContext = paramContext;
    this.jac = LayoutInflater.from(this.mContext).inflate(i.g.half_screen_add_brand, this);
    this.AQI = ((WeImageView)this.jac.findViewById(i.f.close));
    this.Lsa = ((RoundCornerImageView)this.jac.findViewById(i.f.iv_brand_img));
    this.Lsb = ((TextView)this.jac.findViewById(i.f.tv_brand_nickname));
    this.Lsc = ((TextView)this.jac.findViewById(i.f.tv_brand_desc));
    this.Lsd = ((TextView)this.jac.findViewById(i.f.tv_brand_friend_tip));
    this.Lse = ((TextView)this.jac.findViewById(i.f.tv_brand_content_tip));
    this.Lsf = ((Button)this.jac.findViewById(i.f.btn_brand_send));
    this.Lsf.setOnClickListener(this);
    this.AQI.setOnClickListener(this);
    AppMethodBeat.o(229969);
  }
  
  private void bzz()
  {
    AppMethodBeat.i(229975);
    this.Lsb.setText(this.JPm.fzM);
    this.Lsc.setText(this.JPm.JxQ);
    String str = this.JPm.JxP;
    if (!TextUtils.equals((String)this.Lsa.getTag(i.f.sns_ad_subscribe_url), str))
    {
      this.Lsa.setImageDrawable(null);
      c.a(i.f.sns_ad_subscribe_url, str, this.Lsa);
    }
    AppMethodBeat.o(229975);
  }
  
  public final void a(f paramf, int paramInt, com.tencent.mm.plugin.sns.e.a parama)
  {
    AppMethodBeat.i(229972);
    this.JPm = paramf;
    this.JCO = paramInt;
    this.Kqq = parama;
    bzz();
    AppMethodBeat.o(229972);
  }
  
  public final void fZn()
  {
    AppMethodBeat.i(229977);
    this.Lsf.setText(this.JPm.JxR);
    AppMethodBeat.o(229977);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(229985);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/view/HalfScreenAddBrandView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
    int i;
    if (paramView.getId() == i.f.btn_brand_send) {
      if (this.JCO == 182)
      {
        paramView = this.Kqq;
        i = this.JCO;
        if (paramView.JPn)
        {
          Log.i("HalfScreenAddBrandController", "sendAddBrandFromNativeUI isAddContact is true");
          paramView.I(true, paramView.JPm.lFl);
          this.Kqq.fNg();
          paramView = this.Kqq;
          i = this.JCO;
          if (i != 0) {
            break label464;
          }
          i = 1;
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject = new JSONObject();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("clickType", i);
        ((JSONObject)localObject).put("extInfo", localJSONObject);
        ((JSONObject)localObject).put("uxinfo", paramView.uxInfo);
        ((JSONObject)localObject).put("snsid", paramView.fLp);
        ((JSONObject)localObject).put("scene", 0);
        ((JSONObject)localObject).put("adExtInfo", paramView.adExtInfo);
        paramView = ((JSONObject)localObject).toString();
        m.ks("timeline_ad_half_screen_quickly_add_brand_btn", paramView);
        Log.i("HalfScreenAddBrandController", "addBrandReport timeline_ad_half_screen_quickly_add_brand_btn, content=".concat(String.valueOf(paramView)));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/view/HalfScreenAddBrandView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(229985);
        return;
        localObject = paramView.mContext;
        paramView.mContext.getString(i.j.app_tip);
        paramView.tipDialog = com.tencent.mm.ui.base.h.a((Context)localObject, paramView.mContext.getString(i.j.contact_info_adding_tip), true, null);
        AdLandingPagesProxy.getInstance().doAddBrandScene(paramView.JPm.lFl, i, new a.1(paramView, i));
        break;
        paramView = this.Kqq;
        i = this.JCO;
        if ((paramView.mContext == null) || (paramView.JPm == null) || (Util.isNullOrNil(paramView.JPm.lFl))) {
          break;
        }
        localObject = paramView.mContext;
        paramView.mContext.getString(i.j.app_tip);
        paramView.tipDialog = com.tencent.mm.ui.base.h.a((Context)localObject, paramView.mContext.getString(i.j.contact_info_adding_tip), true, null);
        paramView = com.tencent.mm.plugin.sns.model.b.a(paramView.JPm.lFl, new a.a(paramView, paramView.mContext, i, paramView.tipDialog, (byte)0), i);
        if ((paramView instanceof com.tencent.mm.openim.b.b))
        {
          paramView = (com.tencent.mm.openim.b.b)paramView;
          com.tencent.mm.kernel.h.aGY().a(paramView, 0);
          break;
        }
        if (!(paramView instanceof com.tencent.mm.pluginsdk.model.t)) {
          break;
        }
        paramView = (com.tencent.mm.pluginsdk.model.t)paramView;
        com.tencent.mm.kernel.h.aGY().a(paramView, 0);
        break;
        label464:
        if (i == 182)
        {
          boolean bool = paramView.JPn;
          if (bool)
          {
            i = 4;
            continue;
          }
          i = 3;
          continue;
        }
        i = 2;
        continue;
      }
      catch (Exception paramView)
      {
        Log.e("HalfScreenAddBrandController", "addBrandReport exp:" + paramView.toString());
        continue;
      }
      if (paramView.getId() == i.f.close) {
        this.Kqq.fNg();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.view.HalfScreenAddBrandView
 * JD-Core Version:    0.7.0.1
 */