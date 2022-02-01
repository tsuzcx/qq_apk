package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADInfo.d;
import com.tencent.mm.plugin.sns.storage.ADInfo.e;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.ADXml.l;
import com.tencent.mm.plugin.sns.storage.ADXml.m;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.y;
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.plugin.sns.ui.widget.SnsRatioView;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class az
  implements View.OnClickListener
{
  private c JIp;
  private View KKM;
  private TextView KKN;
  private TextView KKO;
  private TextView KKP;
  private View KKQ;
  private Button KKR;
  private Button KKS;
  private View KKT;
  private SnsRatioView KKU;
  private TextView KKV;
  private TextView KKW;
  private SnsInfo KKX;
  private int KKY;
  private int KKZ;
  private int KLa;
  private int KLb;
  private Context mContext;
  
  public az(Context paramContext, View paramView, c paramc)
  {
    AppMethodBeat.i(98302);
    this.KKY = Color.parseColor("#1A000000");
    this.KKZ = Color.parseColor("#FFFFFFFF");
    this.KLa = Color.parseColor("#E6000000");
    this.KLb = Color.parseColor("#4D000000");
    this.mContext = paramContext;
    this.JIp = paramc;
    this.KKM = paramView.findViewById(i.f.vote_container);
    this.KKY = paramContext.getResources().getColor(i.c.sns_ad_voted_bg_color);
    this.KKZ = paramContext.getResources().getColor(i.c.sns_ad_unvoted_bg_color);
    this.KLa = paramContext.getResources().getColor(i.c.sns_ad_voted_txt_color);
    this.KLb = paramContext.getResources().getColor(i.c.sns_ad_unvoted_txt_color);
    this.KKN = ((TextView)paramView.findViewById(i.f.vote_title_txt));
    this.KKO = ((TextView)paramView.findViewById(i.f.vote_label_txt));
    this.KKP = ((TextView)paramView.findViewById(i.f.vote_desc_txt));
    this.KKQ = paramView.findViewById(i.f.vote_btn_container);
    this.KKR = ((Button)paramView.findViewById(i.f.vote_btn_left));
    this.KKS = ((Button)paramView.findViewById(i.f.vote_btn_right));
    this.KKT = paramView.findViewById(i.f.ratio_view_container);
    this.KKU = ((SnsRatioView)paramView.findViewById(i.f.vote_ratio_view));
    this.KKV = ((TextView)paramView.findViewById(i.f.voted_info_left));
    this.KKW = ((TextView)paramView.findViewById(i.f.voted_info_right));
    this.KKR.setOnClickListener(this);
    this.KKS.setOnClickListener(this);
    int i = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 4);
    int j = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 8);
    int k = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 8);
    paramContext = this.KKU;
    paramContext.Luw.setAntiAlias(true);
    paramContext.Lux.setAntiAlias(true);
    paramContext.Luq = i;
    paramContext.Lut = Math.max(i, k);
    paramContext.Lur = 70;
    paramContext.Lus = j;
    paramContext.Luy[0] = i;
    paramContext.Luy[1] = i;
    paramContext.Luy[2] = i;
    paramContext.Luy[3] = i;
    paramContext.Luy[4] = i;
    paramContext.Luy[5] = i;
    paramContext.Luy[6] = i;
    paramContext.Luy[7] = i;
    AppMethodBeat.o(98302);
  }
  
  private static ADInfo.d ln(String paramString1, String paramString2)
  {
    AppMethodBeat.i(98304);
    long l1 = System.currentTimeMillis();
    h.aHE();
    Object localObject1 = com.tencent.mm.kernel.b.aGq();
    Object localObject2 = new StringBuilder();
    if (paramString1 != null) {}
    for (;;)
    {
      ((StringBuilder)localObject2).append(paramString1);
      if (paramString2 != null)
      {
        label43:
        ((StringBuilder)localObject2).append(paramString2);
        if (localObject1 == null) {
          break label206;
        }
        paramString1 = (String)localObject1;
        label58:
        ((StringBuilder)localObject2).append(paramString1);
        paramString1 = "";
        if (((StringBuilder)localObject2).length() <= 0) {
          break label212;
        }
        paramString1 = ((StringBuilder)localObject2).toString() + "_voteRet";
        paramString1 = MMApplicationContext.getContext().getSharedPreferences("SnsAdVote", 0).getString(paramString1, "");
        label120:
        long l2 = System.currentTimeMillis();
        com.tencent.mm.sdk.platformtools.Log.i("StorageHelper", "getSnsAdVoteResultInfo, ret=" + paramString1 + ", timeCost=" + (l2 - l1));
      }
      try
      {
        if (!TextUtils.isEmpty(paramString1))
        {
          paramString1 = new JSONArray(paramString1);
          int i = paramString1.length();
          if (i == 0)
          {
            AppMethodBeat.o(98304);
            return null;
            paramString1 = "";
            continue;
            paramString2 = "";
            break label43;
            label206:
            paramString1 = "";
            break label58;
            label212:
            com.tencent.mm.sdk.platformtools.Log.e("StorageHelper", "getSnsAdVoteResultInfo, key is empty");
            break label120;
          }
          paramString2 = new ADInfo.d();
          i = 0;
          while (i < paramString1.length())
          {
            localObject2 = paramString1.getJSONObject(i);
            localObject1 = new ADInfo.e();
            ((ADInfo.e)localObject1).id = ((JSONObject)localObject2).optString("id");
            ((ADInfo.e)localObject1).Kjs = ((JSONObject)localObject2).optInt("scoring");
            ((ADInfo.e)localObject1).Kjt = ((JSONObject)localObject2).optInt("friends");
            localObject2 = ((JSONObject)localObject2).optJSONArray("friendsList");
            if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0))
            {
              int j = 0;
              while (j < ((JSONArray)localObject2).length())
              {
                ((ADInfo.e)localObject1).Kju.add(((JSONArray)localObject2).getString(j));
                j += 1;
              }
            }
            paramString2.Kjr.add(localObject1);
            i += 1;
          }
          AppMethodBeat.o(98304);
          return paramString2;
        }
      }
      catch (Exception paramString1)
      {
        com.tencent.mm.sdk.platformtools.Log.e("SnsAdCardVoteCtrl", "getAdVoteInfoExtFromWebUpdate, exp=" + paramString1.toString());
        AppMethodBeat.o(98304);
      }
    }
    return null;
  }
  
  public final void a(SnsInfo paramSnsInfo, Object paramObject)
  {
    AppMethodBeat.i(98303);
    for (;;)
    {
      Object localObject1;
      try
      {
        this.KKR.setTag(paramObject);
        this.KKS.setTag(paramObject);
        this.KKX = paramSnsInfo;
        Object localObject2 = paramSnsInfo.getAdXml();
        localObject1 = paramSnsInfo.getAdXml().adVoteInfo;
        paramObject = paramSnsInfo.getUxinfo();
        String str = ((ADXml.l)localObject1).Kkg;
        int j = y.lj(str, paramObject);
        if (j <= 0) {
          break label702;
        }
        i = 1;
        paramObject = ln(str, paramObject);
        if (paramObject == null)
        {
          com.tencent.mm.sdk.platformtools.Log.i("SnsAdCardVoteCtrl", "fillVoteInfoView, web voteResult == null, snsId=" + paramSnsInfo.getSnsId());
          paramSnsInfo = paramSnsInfo.getAdInfo().adVoteInfoExt;
          if (!TextUtils.isEmpty(((ADXml)localObject2).adCardDesc))
          {
            this.KKP.setText(((ADXml)localObject2).adCardDesc);
            this.KKP.setVisibility(0);
            if (TextUtils.isEmpty(((ADXml.l)localObject1).Kkh)) {
              break label584;
            }
            this.KKO.setText(((ADXml.l)localObject1).Kkh);
            this.KKO.setVisibility(0);
            if (TextUtils.isEmpty(((ADXml)localObject2).adCardTitle)) {
              break label596;
            }
            this.KKN.setText(((ADXml)localObject2).adCardTitle);
            this.KKN.setVisibility(0);
            localObject2 = ((ADXml.m)((ADXml.l)localObject1).Kki.get(0)).id;
            str = ((ADXml.m)((ADXml.l)localObject1).Kki.get(1)).id;
            paramObject = ((ADXml.l)localObject1).agj(0);
            localObject1 = ((ADXml.l)localObject1).agj(1);
            if (i == 0) {
              break label661;
            }
            i = paramSnsInfo.kM((String)localObject2, str);
            int k = 100 - i;
            this.KKQ.setVisibility(8);
            this.KKT.setVisibility(0);
            paramSnsInfo = this.KKU;
            paramSnsInfo.Luo = i;
            paramSnsInfo.Lup = k;
            paramSnsInfo.Luo = Math.max(0, paramSnsInfo.Luo);
            paramSnsInfo.Luo = Math.min(100, paramSnsInfo.Luo);
            paramSnsInfo.Lup = Math.max(0, paramSnsInfo.Lup);
            paramSnsInfo.Lup = Math.min(100, paramSnsInfo.Lup);
            if (paramSnsInfo.Luo + paramSnsInfo.Lup != 100) {
              paramSnsInfo.Lup = (100 - paramSnsInfo.Luo);
            }
            paramSnsInfo.invalidate();
            this.KKV.setText(paramObject + " " + i + "%");
            this.KKW.setText(k + "% " + (String)localObject1);
            if (j != 1) {
              break label617;
            }
            this.KKU.kj(this.KKY, this.KKZ);
            this.KKV.setTextColor(this.KLa);
            this.KKW.setTextColor(this.KLb);
            AppMethodBeat.o(98303);
          }
        }
        else
        {
          com.tencent.mm.sdk.platformtools.Log.i("SnsAdCardVoteCtrl", "fillVoteInfoView, web voteResult != null, snsId=" + paramSnsInfo.getSnsId());
          paramSnsInfo = paramObject;
          continue;
        }
        this.KKP.setVisibility(8);
        continue;
        this.KKO.setVisibility(8);
      }
      catch (Exception paramSnsInfo)
      {
        com.tencent.mm.sdk.platformtools.Log.e("SnsAdCardVoteCtrl", "fillVoteInfoView, exp:" + android.util.Log.getStackTraceString(paramSnsInfo));
        AppMethodBeat.o(98303);
        return;
      }
      label584:
      continue;
      label596:
      this.KKN.setVisibility(8);
      this.KKO.setVisibility(8);
      continue;
      label617:
      this.KKU.kj(this.KKZ, this.KKY);
      this.KKV.setTextColor(this.KLb);
      this.KKW.setTextColor(this.KLa);
      AppMethodBeat.o(98303);
      return;
      label661:
      this.KKQ.setVisibility(0);
      this.KKT.setVisibility(8);
      this.KKR.setText(paramObject);
      this.KKS.setText((CharSequence)localObject1);
      AppMethodBeat.o(98303);
      return;
      label702:
      int i = 0;
    }
  }
  
  public final void fUW()
  {
    AppMethodBeat.i(98305);
    if (this.KKM.getVisibility() != 0) {
      this.KKM.setVisibility(0);
    }
    AppMethodBeat.o(98305);
  }
  
  public final void fUX()
  {
    AppMethodBeat.i(98306);
    if (this.KKM.getVisibility() != 8) {
      this.KKM.setVisibility(8);
    }
    AppMethodBeat.o(98306);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(98307);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsAdCardVoteCtrl", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    if (paramView == this.KKR) {
      this.JIp.Lpz.onClick(paramView);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsAdCardVoteCtrl", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(98307);
      return;
      if (paramView == this.KKS) {
        this.JIp.LpA.onClick(paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.az
 * JD-Core Version:    0.7.0.1
 */