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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
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

public final class ax
  implements View.OnClickListener
{
  private c Dyw;
  private View EwT;
  private TextView EwU;
  private TextView EwV;
  private TextView EwW;
  private View EwX;
  private Button EwY;
  private Button EwZ;
  private View Exa;
  private SnsRatioView Exb;
  private TextView Exc;
  private TextView Exd;
  private SnsInfo Exe;
  private int Exf;
  private int Exg;
  private int Exh;
  private int Exi;
  private Context mContext;
  
  public ax(Context paramContext, View paramView, c paramc)
  {
    AppMethodBeat.i(98302);
    this.Exf = Color.parseColor("#1A000000");
    this.Exg = Color.parseColor("#FFFFFFFF");
    this.Exh = Color.parseColor("#E6000000");
    this.Exi = Color.parseColor("#4D000000");
    this.mContext = paramContext;
    this.Dyw = paramc;
    this.EwT = paramView.findViewById(2131310097);
    this.Exf = paramContext.getResources().getColor(2131101118);
    this.Exg = paramContext.getResources().getColor(2131101115);
    this.Exh = paramContext.getResources().getColor(2131101119);
    this.Exi = paramContext.getResources().getColor(2131101116);
    this.EwU = ((TextView)paramView.findViewById(2131310101));
    this.EwV = ((TextView)paramView.findViewById(2131310099));
    this.EwW = ((TextView)paramView.findViewById(2131310098));
    this.EwX = paramView.findViewById(2131310094);
    this.EwY = ((Button)paramView.findViewById(2131310095));
    this.EwZ = ((Button)paramView.findViewById(2131310096));
    this.Exa = paramView.findViewById(2131306513);
    this.Exb = ((SnsRatioView)paramView.findViewById(2131310100));
    this.Exc = ((TextView)paramView.findViewById(2131310102));
    this.Exd = ((TextView)paramView.findViewById(2131310103));
    this.EwY.setOnClickListener(this);
    this.EwZ.setOnClickListener(this);
    int i = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 4);
    int j = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 8);
    int k = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 8);
    paramContext = this.Exb;
    paramContext.FfR.setAntiAlias(true);
    paramContext.FfS.setAntiAlias(true);
    paramContext.FfL = i;
    paramContext.FfO = Math.max(i, k);
    paramContext.FfM = 70;
    paramContext.FfN = j;
    paramContext.FfT[0] = i;
    paramContext.FfT[1] = i;
    paramContext.FfT[2] = i;
    paramContext.FfT[3] = i;
    paramContext.FfT[4] = i;
    paramContext.FfT[5] = i;
    paramContext.FfT[6] = i;
    paramContext.FfT[7] = i;
    AppMethodBeat.o(98302);
  }
  
  private static ADInfo.d kR(String paramString1, String paramString2)
  {
    AppMethodBeat.i(98304);
    long l1 = System.currentTimeMillis();
    g.aAf();
    Object localObject1 = com.tencent.mm.kernel.a.ayV();
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
          break label201;
        }
        paramString1 = (String)localObject1;
        label58:
        ((StringBuilder)localObject2).append(paramString1);
        paramString1 = "";
        if (((StringBuilder)localObject2).length() <= 0) {
          break label207;
        }
        paramString1 = ((StringBuilder)localObject2).toString() + "_voteRet";
        paramString1 = MMApplicationContext.getContext().getSharedPreferences("SnsAdVote", 0).getString(paramString1, "");
        label118:
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
            label201:
            paramString1 = "";
            break label58;
            label207:
            com.tencent.mm.sdk.platformtools.Log.e("StorageHelper", "getSnsAdVoteResultInfo, key is empty");
            break label118;
          }
          paramString2 = new ADInfo.d();
          i = 0;
          while (i < paramString1.length())
          {
            localObject2 = paramString1.getJSONObject(i);
            localObject1 = new ADInfo.e();
            ((ADInfo.e)localObject1).id = ((JSONObject)localObject2).optString("id");
            ((ADInfo.e)localObject1).DWg = ((JSONObject)localObject2).optInt("scoring");
            ((ADInfo.e)localObject1).DWh = ((JSONObject)localObject2).optInt("friends");
            localObject2 = ((JSONObject)localObject2).optJSONArray("friendsList");
            if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0))
            {
              int j = 0;
              while (j < ((JSONArray)localObject2).length())
              {
                ((ADInfo.e)localObject1).DWi.add(((JSONArray)localObject2).getString(j));
                j += 1;
              }
            }
            paramString2.DWf.add(localObject1);
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
        this.EwY.setTag(paramObject);
        this.EwZ.setTag(paramObject);
        this.Exe = paramSnsInfo;
        Object localObject2 = paramSnsInfo.getAdXml();
        localObject1 = paramSnsInfo.getAdXml().adVoteInfo;
        paramObject = paramSnsInfo.getUxinfo();
        String str = ((ADXml.l)localObject1).DWX;
        int j = y.kN(str, paramObject);
        if (j <= 0) {
          break label702;
        }
        i = 1;
        paramObject = kR(str, paramObject);
        if (paramObject == null)
        {
          com.tencent.mm.sdk.platformtools.Log.i("SnsAdCardVoteCtrl", "fillVoteInfoView, web voteResult == null, snsId=" + paramSnsInfo.getSnsId());
          paramSnsInfo = paramSnsInfo.getAdInfo().adVoteInfoExt;
          if (!TextUtils.isEmpty(((ADXml)localObject2).adCardDesc))
          {
            this.EwW.setText(((ADXml)localObject2).adCardDesc);
            this.EwW.setVisibility(0);
            if (TextUtils.isEmpty(((ADXml.l)localObject1).DWY)) {
              break label584;
            }
            this.EwV.setText(((ADXml.l)localObject1).DWY);
            this.EwV.setVisibility(0);
            if (TextUtils.isEmpty(((ADXml)localObject2).adCardTitle)) {
              break label596;
            }
            this.EwU.setText(((ADXml)localObject2).adCardTitle);
            this.EwU.setVisibility(0);
            localObject2 = ((ADXml.m)((ADXml.l)localObject1).DWZ.get(0)).id;
            str = ((ADXml.m)((ADXml.l)localObject1).DWZ.get(1)).id;
            paramObject = ((ADXml.l)localObject1).YS(0);
            localObject1 = ((ADXml.l)localObject1).YS(1);
            if (i == 0) {
              break label661;
            }
            i = paramSnsInfo.kr((String)localObject2, str);
            int k = 100 - i;
            this.EwX.setVisibility(8);
            this.Exa.setVisibility(0);
            paramSnsInfo = this.Exb;
            paramSnsInfo.FfJ = i;
            paramSnsInfo.FfK = k;
            paramSnsInfo.FfJ = Math.max(0, paramSnsInfo.FfJ);
            paramSnsInfo.FfJ = Math.min(100, paramSnsInfo.FfJ);
            paramSnsInfo.FfK = Math.max(0, paramSnsInfo.FfK);
            paramSnsInfo.FfK = Math.min(100, paramSnsInfo.FfK);
            if (paramSnsInfo.FfJ + paramSnsInfo.FfK != 100) {
              paramSnsInfo.FfK = (100 - paramSnsInfo.FfJ);
            }
            paramSnsInfo.invalidate();
            this.Exc.setText(paramObject + " " + i + "%");
            this.Exd.setText(k + "% " + (String)localObject1);
            if (j != 1) {
              break label617;
            }
            this.Exb.iZ(this.Exf, this.Exg);
            this.Exc.setTextColor(this.Exh);
            this.Exd.setTextColor(this.Exi);
            AppMethodBeat.o(98303);
          }
        }
        else
        {
          com.tencent.mm.sdk.platformtools.Log.i("SnsAdCardVoteCtrl", "fillVoteInfoView, web voteResult != null, snsId=" + paramSnsInfo.getSnsId());
          paramSnsInfo = paramObject;
          continue;
        }
        this.EwW.setVisibility(8);
        continue;
        this.EwV.setVisibility(8);
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
      this.EwU.setVisibility(8);
      this.EwV.setVisibility(8);
      continue;
      label617:
      this.Exb.iZ(this.Exg, this.Exf);
      this.Exc.setTextColor(this.Exi);
      this.Exd.setTextColor(this.Exh);
      AppMethodBeat.o(98303);
      return;
      label661:
      this.EwX.setVisibility(0);
      this.Exa.setVisibility(8);
      this.EwY.setText(paramObject);
      this.EwZ.setText((CharSequence)localObject1);
      AppMethodBeat.o(98303);
      return;
      label702:
      int i = 0;
    }
  }
  
  public final void fgQ()
  {
    AppMethodBeat.i(98305);
    if (this.EwT.getVisibility() != 0) {
      this.EwT.setVisibility(0);
    }
    AppMethodBeat.o(98305);
  }
  
  public final void fgR()
  {
    AppMethodBeat.i(98306);
    if (this.EwT.getVisibility() != 8) {
      this.EwT.setVisibility(8);
    }
    AppMethodBeat.o(98306);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(98307);
    b localb = new b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsAdCardVoteCtrl", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    if (paramView == this.EwY) {
      this.Dyw.Fbb.onClick(paramView);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsAdCardVoteCtrl", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(98307);
      return;
      if (paramView == this.EwZ) {
        this.Dyw.Fbc.onClick(paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ax
 * JD-Core Version:    0.7.0.1
 */