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
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.data.c;
import com.tencent.mm.plugin.sns.data.k;
import com.tencent.mm.plugin.sns.e.a.1;
import com.tencent.mm.plugin.sns.e.a.a;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.RoundCornerImageView;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import org.json.JSONObject;

public class HalfScreenAddBrandView
  extends RelativeLayout
  implements View.OnClickListener
{
  public RoundCornerImageView ASO;
  public TextView ASP;
  public TextView ASQ;
  private TextView ASR;
  private TextView ASS;
  public Button AST;
  private View fQH;
  private Context mContext;
  private WeImageView tbS;
  public com.tencent.mm.plugin.sns.e.a zUG;
  public int zsG;
  public c zsH;
  
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
    AppMethodBeat.i(220135);
    this.mContext = paramContext;
    this.fQH = LayoutInflater.from(this.mContext).inflate(2131496523, this);
    this.tbS = ((WeImageView)this.fQH.findViewById(2131298360));
    this.ASO = ((RoundCornerImageView)this.fQH.findViewById(2131308493));
    this.ASP = ((TextView)this.fQH.findViewById(2131308523));
    this.ASQ = ((TextView)this.fQH.findViewById(2131308521));
    this.ASR = ((TextView)this.fQH.findViewById(2131308522));
    this.ASS = ((TextView)this.fQH.findViewById(2131308520));
    this.AST = ((Button)this.fQH.findViewById(2131308477));
    this.AST.setOnClickListener(this);
    this.tbS.setOnClickListener(this);
    AppMethodBeat.o(220135);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(220136);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/view/HalfScreenAddBrandView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
    int i;
    if (paramView.getId() == 2131308477) {
      if (this.zsG == 182)
      {
        paramView = this.zUG;
        i = this.zsG;
        if (paramView.zsI)
        {
          ae.i("HalfScreenAddBrandController", "sendAddBrandFromNativeUI isAddContact is true");
          paramView.C(true, paramView.zsH.hTJ);
          this.zUG.dWe();
          paramView = this.zUG;
          i = this.zsG;
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
        ((JSONObject)localObject).put("uxinfo", paramView.dGD);
        ((JSONObject)localObject).put("snsid", paramView.dAg);
        ((JSONObject)localObject).put("scene", 0);
        ((JSONObject)localObject).put("adExtInfo", paramView.zsJ);
        paramView = ((JSONObject)localObject).toString();
        k.jm("timeline_ad_half_screen_quickly_add_brand_btn", paramView);
        ae.i("HalfScreenAddBrandController", "addBrandReport timeline_ad_half_screen_quickly_add_brand_btn, content=".concat(String.valueOf(paramView)));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/view/HalfScreenAddBrandView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(220136);
        return;
        localObject = paramView.mContext;
        paramView.mContext.getString(2131755906);
        paramView.tipDialog = h.b((Context)localObject, paramView.mContext.getString(2131757579), true, null);
        AdLandingPagesProxy.getInstance().doAddBrandScene(paramView.zsH.hTJ, i, new a.1(paramView, i));
        break;
        paramView = this.zUG;
        i = this.zsG;
        if ((paramView.mContext == null) || (paramView.zsH == null) || (bu.isNullOrNil(paramView.zsH.hTJ))) {
          break;
        }
        localObject = paramView.mContext;
        paramView.mContext.getString(2131755906);
        paramView.tipDialog = h.b((Context)localObject, paramView.mContext.getString(2131757579), true, null);
        paramView = com.tencent.mm.plugin.sns.model.b.a(paramView.zsH.hTJ, new a.a(paramView, paramView.mContext, i, paramView.tipDialog, (byte)0), i);
        if ((paramView instanceof com.tencent.mm.openim.b.b))
        {
          paramView = (com.tencent.mm.openim.b.b)paramView;
          g.ajj().a(paramView, 0);
          break;
        }
        if (!(paramView instanceof o)) {
          break;
        }
        paramView = (o)paramView;
        g.ajj().a(paramView, 0);
        break;
        label454:
        if (i == 182)
        {
          boolean bool = paramView.zsI;
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
        ae.e("HalfScreenAddBrandController", "addBrandReport exp:" + paramView.toString());
        continue;
      }
      if (paramView.getId() == 2131298360) {
        this.zUG.dWe();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.view.HalfScreenAddBrandView
 * JD-Core Version:    0.7.0.1
 */