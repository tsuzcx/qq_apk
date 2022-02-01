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
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.data.f;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.g.a.1;
import com.tencent.mm.plugin.sns.g.a.a;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.pluginsdk.model.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.widget.RoundCornerImageView;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import org.json.JSONObject;

public class HalfScreenAddBrandView
  extends RelativeLayout
  implements View.OnClickListener
{
  private WeImageView GsS;
  private com.tencent.mm.plugin.sns.g.a QOB;
  private f Qkv;
  private RoundCornerImageView RVd;
  private TextView RVe;
  private TextView RVf;
  private TextView RVg;
  private TextView RVh;
  private Button RVi;
  private View lBX;
  private Context mContext;
  private int xOq;
  
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
    AppMethodBeat.i(308458);
    this.mContext = paramContext;
    this.lBX = LayoutInflater.from(this.mContext).inflate(b.g.half_screen_add_brand, this);
    this.GsS = ((WeImageView)this.lBX.findViewById(b.f.close));
    this.RVd = ((RoundCornerImageView)this.lBX.findViewById(b.f.iv_brand_img));
    this.RVe = ((TextView)this.lBX.findViewById(b.f.tv_brand_nickname));
    this.RVf = ((TextView)this.lBX.findViewById(b.f.tv_brand_desc));
    this.RVg = ((TextView)this.lBX.findViewById(b.f.tv_brand_friend_tip));
    this.RVh = ((TextView)this.lBX.findViewById(b.f.tv_brand_content_tip));
    this.RVi = ((Button)this.lBX.findViewById(b.f.btn_brand_send));
    this.RVi.setOnClickListener(this);
    this.GsS.setOnClickListener(this);
    AppMethodBeat.o(308458);
  }
  
  private void bYl()
  {
    AppMethodBeat.i(308462);
    this.RVe.setText(this.Qkv.hEy);
    this.RVf.setText(this.Qkv.PLF);
    String str = this.Qkv.PLE;
    if (!TextUtils.equals((String)this.RVd.getTag(b.f.sns_ad_subscribe_url), str))
    {
      this.RVd.setImageDrawable(null);
      c.a(b.f.sns_ad_subscribe_url, str, this.RVd);
    }
    AppMethodBeat.o(308462);
  }
  
  public final void a(f paramf, int paramInt, com.tencent.mm.plugin.sns.g.a parama)
  {
    AppMethodBeat.i(308466);
    this.Qkv = paramf;
    this.xOq = paramInt;
    this.QOB = parama;
    bYl();
    AppMethodBeat.o(308466);
  }
  
  public final void hsB()
  {
    AppMethodBeat.i(308468);
    this.RVi.setText(this.Qkv.PLG);
    AppMethodBeat.o(308468);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(308476);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/view/HalfScreenAddBrandView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
    int i;
    if (paramView.getId() == b.f.btn_brand_send) {
      if (this.xOq == 182)
      {
        paramView = this.QOB;
        i = this.xOq;
        if (paramView.Qkw)
        {
          Log.i("HalfScreenAddBrandController", "sendAddBrandFromNativeUI isAddContact is true");
          paramView.ax(true, paramView.Qkv.owR);
          this.QOB.hem();
          paramView = this.QOB;
          i = this.xOq;
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
        ((JSONObject)localObject).put("snsid", paramView.hQX);
        ((JSONObject)localObject).put("scene", 0);
        ((JSONObject)localObject).put("adExtInfo", paramView.adExtInfo);
        paramView = ((JSONObject)localObject).toString();
        m.lU("timeline_ad_half_screen_quickly_add_brand_btn", paramView);
        Log.i("HalfScreenAddBrandController", "addBrandReport timeline_ad_half_screen_quickly_add_brand_btn, content=".concat(String.valueOf(paramView)));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/view/HalfScreenAddBrandView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(308476);
        return;
        localObject = paramView.mContext;
        paramView.mContext.getString(b.j.app_tip);
        paramView.tipDialog = k.a((Context)localObject, paramView.mContext.getString(b.j.contact_info_adding_tip), true, null);
        AdLandingPagesProxy.getInstance().doAddBrandScene(paramView.Qkv.owR, i, new a.1(paramView, i));
        break;
        paramView = this.QOB;
        i = this.xOq;
        if ((paramView.mContext == null) || (paramView.Qkv == null) || (Util.isNullOrNil(paramView.Qkv.owR))) {
          break;
        }
        localObject = paramView.mContext;
        paramView.mContext.getString(b.j.app_tip);
        paramView.tipDialog = k.a((Context)localObject, paramView.mContext.getString(b.j.contact_info_adding_tip), true, null);
        paramView = com.tencent.mm.plugin.sns.model.b.a(paramView.Qkv.owR, new a.a(paramView, paramView.mContext, i, paramView.tipDialog, (byte)0), i);
        if ((paramView instanceof com.tencent.mm.openim.model.b))
        {
          paramView = (com.tencent.mm.openim.model.b)paramView;
          h.aZW().a(paramView, 0);
          break;
        }
        if (!(paramView instanceof v)) {
          break;
        }
        paramView = (v)paramView;
        h.aZW().a(paramView, 0);
        break;
        label464:
        if (i == 182)
        {
          boolean bool = paramView.Qkw;
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
      if (paramView.getId() == b.f.close) {
        this.QOB.hem();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.view.HalfScreenAddBrandView
 * JD-Core Version:    0.7.0.1
 */