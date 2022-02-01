package com.tencent.mm.plugin.sns.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.data.d;
import com.tencent.mm.plugin.sns.data.k;
import com.tencent.mm.plugin.sns.e.a.1;
import com.tencent.mm.plugin.sns.e.a.a;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.RoundCornerImageView;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import org.json.JSONObject;

public class HalfScreenAddBrandView
  extends RelativeLayout
  implements View.OnClickListener
{
  public d DCX;
  public int DxM;
  public com.tencent.mm.plugin.sns.e.a EcO;
  public RoundCornerImageView Fdu;
  public TextView Fdv;
  public TextView Fdw;
  private TextView Fdx;
  private TextView Fdy;
  public Button Fdz;
  private View gvQ;
  private Context mContext;
  private WeImageView wgU;
  
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
    AppMethodBeat.i(203978);
    this.mContext = paramContext;
    this.gvQ = LayoutInflater.from(this.mContext).inflate(2131495006, this);
    this.wgU = ((WeImageView)this.gvQ.findViewById(2131298763));
    this.Fdu = ((RoundCornerImageView)this.gvQ.findViewById(2131302884));
    this.Fdv = ((TextView)this.gvQ.findViewById(2131309461));
    this.Fdw = ((TextView)this.gvQ.findViewById(2131309459));
    this.Fdx = ((TextView)this.gvQ.findViewById(2131309460));
    this.Fdy = ((TextView)this.gvQ.findViewById(2131309458));
    this.Fdz = ((Button)this.gvQ.findViewById(2131297826));
    this.Fdz.setOnClickListener(this);
    this.wgU.setOnClickListener(this);
    AppMethodBeat.o(203978);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(203979);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/view/HalfScreenAddBrandView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
    int i;
    if (paramView.getId() == 2131297826) {
      if (this.DxM == 182)
      {
        paramView = this.EcO;
        i = this.DxM;
        if (paramView.DCY)
        {
          Log.i("HalfScreenAddBrandController", "sendAddBrandFromNativeUI isAddContact is true");
          paramView.D(true, paramView.DCX.brandUsername);
          this.EcO.eZp();
          paramView = this.EcO;
          i = this.DxM;
          if (i != 0) {
            break label454;
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
        ((JSONObject)localObject).put("snsid", paramView.dRS);
        ((JSONObject)localObject).put("scene", 0);
        ((JSONObject)localObject).put("adExtInfo", paramView.adExtInfo);
        paramView = ((JSONObject)localObject).toString();
        k.jY("timeline_ad_half_screen_quickly_add_brand_btn", paramView);
        Log.i("HalfScreenAddBrandController", "addBrandReport timeline_ad_half_screen_quickly_add_brand_btn, content=".concat(String.valueOf(paramView)));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/view/HalfScreenAddBrandView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(203979);
        return;
        localObject = paramView.mContext;
        paramView.mContext.getString(2131755998);
        paramView.tipDialog = h.a((Context)localObject, paramView.mContext.getString(2131757806), true, null);
        AdLandingPagesProxy.getInstance().doAddBrandScene(paramView.DCX.brandUsername, i, new a.1(paramView, i));
        break;
        paramView = this.EcO;
        i = this.DxM;
        if ((paramView.mContext == null) || (paramView.DCX == null) || (Util.isNullOrNil(paramView.DCX.brandUsername))) {
          break;
        }
        localObject = paramView.mContext;
        paramView.mContext.getString(2131755998);
        paramView.tipDialog = h.a((Context)localObject, paramView.mContext.getString(2131757806), true, null);
        paramView = com.tencent.mm.plugin.sns.model.b.a(paramView.DCX.brandUsername, new a.a(paramView, paramView.mContext, i, paramView.tipDialog, (byte)0), i);
        if ((paramView instanceof com.tencent.mm.openim.b.b))
        {
          paramView = (com.tencent.mm.openim.b.b)paramView;
          g.azz().a(paramView, 0);
          break;
        }
        if (!(paramView instanceof p)) {
          break;
        }
        paramView = (p)paramView;
        g.azz().a(paramView, 0);
        break;
        label454:
        if (i == 182)
        {
          boolean bool = paramView.DCY;
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
      if (paramView.getId() == 2131298763) {
        this.EcO.eZp();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.view.HalfScreenAddBrandView
 * JD-Core Version:    0.7.0.1
 */