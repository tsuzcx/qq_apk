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
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADInfo.d;
import com.tencent.mm.plugin.sns.storage.ADInfo.e;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.ADXml.l;
import com.tencent.mm.plugin.sns.storage.ADXml.m;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.ai;
import com.tencent.mm.plugin.sns.ui.listener.c;
import com.tencent.mm.plugin.sns.ui.widget.SnsRatioView;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class ba
  implements View.OnClickListener
{
  private c PZr;
  private TextView RkA;
  private TextView RkB;
  private View RkC;
  private Button RkD;
  private Button RkE;
  private View RkF;
  private SnsRatioView RkG;
  private TextView RkH;
  private TextView RkI;
  private SnsInfo RkJ;
  private int RkK;
  private int RkL;
  private int RkM;
  private int RkN;
  private View Rky;
  private TextView Rkz;
  private Context mContext;
  
  public ba(Context paramContext, View paramView, c paramc)
  {
    AppMethodBeat.i(98302);
    this.RkK = Color.parseColor("#1A000000");
    this.RkL = Color.parseColor("#FFFFFFFF");
    this.RkM = Color.parseColor("#E6000000");
    this.RkN = Color.parseColor("#4D000000");
    this.mContext = paramContext;
    this.PZr = paramc;
    this.Rky = paramView.findViewById(b.f.vote_container);
    this.RkK = paramContext.getResources().getColor(b.c.sns_ad_voted_bg_color);
    this.RkL = paramContext.getResources().getColor(b.c.sns_ad_unvoted_bg_color);
    this.RkM = paramContext.getResources().getColor(b.c.sns_ad_voted_txt_color);
    this.RkN = paramContext.getResources().getColor(b.c.sns_ad_unvoted_txt_color);
    this.Rkz = ((TextView)paramView.findViewById(b.f.vote_title_txt));
    this.RkA = ((TextView)paramView.findViewById(b.f.vote_label_txt));
    this.RkB = ((TextView)paramView.findViewById(b.f.vote_desc_txt));
    this.RkC = paramView.findViewById(b.f.vote_btn_container);
    this.RkD = ((Button)paramView.findViewById(b.f.vote_btn_left));
    this.RkE = ((Button)paramView.findViewById(b.f.vote_btn_right));
    this.RkF = paramView.findViewById(b.f.ratio_view_container);
    this.RkG = ((SnsRatioView)paramView.findViewById(b.f.vote_ratio_view));
    this.RkH = ((TextView)paramView.findViewById(b.f.voted_info_left));
    this.RkI = ((TextView)paramView.findViewById(b.f.voted_info_right));
    this.RkD.setOnClickListener(this);
    this.RkE.setOnClickListener(this);
    int i = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 4);
    int j = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 8);
    int k = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 8);
    paramContext = this.RkG;
    paramContext.RXW.setAntiAlias(true);
    paramContext.RXX.setAntiAlias(true);
    paramContext.mRadius = i;
    paramContext.RXT = Math.max(i, k);
    paramContext.RXR = 70;
    paramContext.RXS = j;
    paramContext.RXY[0] = i;
    paramContext.RXY[1] = i;
    paramContext.RXY[2] = i;
    paramContext.RXY[3] = i;
    paramContext.RXY[4] = i;
    paramContext.RXY[5] = i;
    paramContext.RXY[6] = i;
    paramContext.RXY[7] = i;
    AppMethodBeat.o(98302);
  }
  
  private static ADInfo.d mW(String paramString1, String paramString2)
  {
    AppMethodBeat.i(98304);
    long l1 = System.currentTimeMillis();
    h.baC();
    Object localObject1 = com.tencent.mm.kernel.b.aZs();
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
            ((ADInfo.e)localObject1).QHp = ((JSONObject)localObject2).optInt("scoring");
            ((ADInfo.e)localObject1).QHq = ((JSONObject)localObject2).optInt("friends");
            localObject2 = ((JSONObject)localObject2).optJSONArray("friendsList");
            if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0))
            {
              int j = 0;
              while (j < ((JSONArray)localObject2).length())
              {
                ((ADInfo.e)localObject1).QHr.add(((JSONArray)localObject2).getString(j));
                j += 1;
              }
            }
            paramString2.QHo.add(localObject1);
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
        this.RkD.setTag(paramObject);
        this.RkE.setTag(paramObject);
        this.RkJ = paramSnsInfo;
        Object localObject2 = paramSnsInfo.getAdXml();
        localObject1 = paramSnsInfo.getAdXml().adVoteInfo;
        paramObject = paramSnsInfo.getUxinfo();
        String str = ((ADXml.l)localObject1).QIe;
        int j = ai.mS(str, paramObject);
        if (j <= 0) {
          break label702;
        }
        i = 1;
        paramObject = mW(str, paramObject);
        if (paramObject == null)
        {
          com.tencent.mm.sdk.platformtools.Log.i("SnsAdCardVoteCtrl", "fillVoteInfoView, web voteResult == null, snsId=" + paramSnsInfo.getSnsId());
          paramSnsInfo = paramSnsInfo.getAdInfo().adVoteInfoExt;
          if (!TextUtils.isEmpty(((ADXml)localObject2).adCardDesc))
          {
            this.RkB.setText(((ADXml)localObject2).adCardDesc);
            this.RkB.setVisibility(0);
            if (TextUtils.isEmpty(((ADXml.l)localObject1).QIf)) {
              break label584;
            }
            this.RkA.setText(((ADXml.l)localObject1).QIf);
            this.RkA.setVisibility(0);
            if (TextUtils.isEmpty(((ADXml)localObject2).adCardTitle)) {
              break label596;
            }
            this.Rkz.setText(((ADXml)localObject2).adCardTitle);
            this.Rkz.setVisibility(0);
            localObject2 = ((ADXml.m)((ADXml.l)localObject1).QIg.get(0)).id;
            str = ((ADXml.m)((ADXml.l)localObject1).QIg.get(1)).id;
            paramObject = ((ADXml.l)localObject1).alb(0);
            localObject1 = ((ADXml.l)localObject1).alb(1);
            if (i == 0) {
              break label661;
            }
            i = paramSnsInfo.mt((String)localObject2, str);
            int k = 100 - i;
            this.RkC.setVisibility(8);
            this.RkF.setVisibility(0);
            paramSnsInfo = this.RkG;
            paramSnsInfo.RXP = i;
            paramSnsInfo.RXQ = k;
            paramSnsInfo.RXP = Math.max(0, paramSnsInfo.RXP);
            paramSnsInfo.RXP = Math.min(100, paramSnsInfo.RXP);
            paramSnsInfo.RXQ = Math.max(0, paramSnsInfo.RXQ);
            paramSnsInfo.RXQ = Math.min(100, paramSnsInfo.RXQ);
            if (paramSnsInfo.RXP + paramSnsInfo.RXQ != 100) {
              paramSnsInfo.RXQ = (100 - paramSnsInfo.RXP);
            }
            paramSnsInfo.invalidate();
            this.RkH.setText(paramObject + " " + i + "%");
            this.RkI.setText(k + "% " + (String)localObject1);
            if (j != 1) {
              break label617;
            }
            this.RkG.lV(this.RkK, this.RkL);
            this.RkH.setTextColor(this.RkM);
            this.RkI.setTextColor(this.RkN);
            AppMethodBeat.o(98303);
          }
        }
        else
        {
          com.tencent.mm.sdk.platformtools.Log.i("SnsAdCardVoteCtrl", "fillVoteInfoView, web voteResult != null, snsId=" + paramSnsInfo.getSnsId());
          paramSnsInfo = paramObject;
          continue;
        }
        this.RkB.setVisibility(8);
        continue;
        this.RkA.setVisibility(8);
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
      this.Rkz.setVisibility(8);
      this.RkA.setVisibility(8);
      continue;
      label617:
      this.RkG.lV(this.RkL, this.RkK);
      this.RkH.setTextColor(this.RkN);
      this.RkI.setTextColor(this.RkM);
      AppMethodBeat.o(98303);
      return;
      label661:
      this.RkC.setVisibility(0);
      this.RkF.setVisibility(8);
      this.RkD.setText(paramObject);
      this.RkE.setText((CharSequence)localObject1);
      AppMethodBeat.o(98303);
      return;
      label702:
      int i = 0;
    }
  }
  
  public final void hnn()
  {
    AppMethodBeat.i(98305);
    if (this.Rky.getVisibility() != 0) {
      this.Rky.setVisibility(0);
    }
    AppMethodBeat.o(98305);
  }
  
  public final void hno()
  {
    AppMethodBeat.i(98306);
    if (this.Rky.getVisibility() != 8) {
      this.Rky.setVisibility(8);
    }
    AppMethodBeat.o(98306);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(98307);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsAdCardVoteCtrl", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if (paramView == this.RkD) {
      this.PZr.RQE.onClick(paramView);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsAdCardVoteCtrl", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(98307);
      return;
      if (paramView == this.RkE) {
        this.PZr.RQF.onClick(paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ba
 * JD-Core Version:    0.7.0.1
 */