package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.storage.a.d;
import com.tencent.mm.plugin.sns.storage.a.e;
import com.tencent.mm.plugin.sns.storage.b.j;
import com.tencent.mm.plugin.sns.storage.b.k;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.plugin.sns.ui.widget.SnsRatioView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class ar
  implements View.OnClickListener
{
  private Context mContext;
  private View xsO;
  private TextView xsP;
  private TextView xsQ;
  private TextView xsR;
  private View xsS;
  private Button xsT;
  private Button xsU;
  private View xsV;
  private SnsRatioView xsW;
  private TextView xsX;
  private TextView xsY;
  private p xsZ;
  private com.tencent.mm.plugin.sns.ui.d.b xta;
  private int xtb;
  private int xtc;
  private int xtd;
  private int xte;
  
  public ar(Context paramContext, View paramView, com.tencent.mm.plugin.sns.ui.d.b paramb)
  {
    AppMethodBeat.i(98302);
    this.xtb = Color.parseColor("#1A000000");
    this.xtc = Color.parseColor("#FFFFFFFF");
    this.xtd = Color.parseColor("#E6000000");
    this.xte = Color.parseColor("#4D000000");
    this.mContext = paramContext;
    this.xta = paramb;
    this.xsO = paramView.findViewById(2131306637);
    this.xtb = paramContext.getResources().getColor(2131100901);
    this.xtc = paramContext.getResources().getColor(2131100898);
    this.xtd = paramContext.getResources().getColor(2131100902);
    this.xte = paramContext.getResources().getColor(2131100899);
    this.xsP = ((TextView)paramView.findViewById(2131306641));
    this.xsQ = ((TextView)paramView.findViewById(2131306639));
    this.xsR = ((TextView)paramView.findViewById(2131306638));
    this.xsS = paramView.findViewById(2131306634);
    this.xsT = ((Button)paramView.findViewById(2131306635));
    this.xsU = ((Button)paramView.findViewById(2131306636));
    this.xsV = paramView.findViewById(2131303727);
    this.xsW = ((SnsRatioView)paramView.findViewById(2131306640));
    this.xsX = ((TextView)paramView.findViewById(2131306642));
    this.xsY = ((TextView)paramView.findViewById(2131306643));
    this.xsT.setOnClickListener(this);
    this.xsU.setOnClickListener(this);
    int i = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 4);
    int j = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 8);
    int k = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 8);
    paramContext = this.xsW;
    paramContext.xYE.setAntiAlias(true);
    paramContext.xYF.setAntiAlias(true);
    paramContext.xYy = i;
    paramContext.xYB = Math.max(i, k);
    paramContext.xYz = 70;
    paramContext.xYA = j;
    paramContext.xYG[0] = i;
    paramContext.xYG[1] = i;
    paramContext.xYG[2] = i;
    paramContext.xYG[3] = i;
    paramContext.xYG[4] = i;
    paramContext.xYG[5] = i;
    paramContext.xYG[6] = i;
    paramContext.xYG[7] = i;
    AppMethodBeat.o(98302);
  }
  
  private static a.d jl(String paramString1, String paramString2)
  {
    AppMethodBeat.i(98304);
    long l1 = System.currentTimeMillis();
    g.afz();
    Object localObject1 = com.tencent.mm.kernel.a.aeo();
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
        paramString1 = aj.getContext().getSharedPreferences("SnsAdVote", 0).getString(paramString1, "");
        label118:
        long l2 = System.currentTimeMillis();
        ad.i("StorageHelper", "getSnsAdVoteResultInfo, ret=" + paramString1 + ", timeCost=" + (l2 - l1));
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
            ad.e("StorageHelper", "getSnsAdVoteResultInfo, key is empty");
            break label118;
          }
          paramString2 = new a.d();
          i = 0;
          while (i < paramString1.length())
          {
            localObject2 = paramString1.getJSONObject(i);
            localObject1 = new a.e();
            ((a.e)localObject1).id = ((JSONObject)localObject2).optString("id");
            ((a.e)localObject1).wSG = ((JSONObject)localObject2).optInt("scoring");
            ((a.e)localObject1).wSH = ((JSONObject)localObject2).optInt("friends");
            localObject2 = ((JSONObject)localObject2).optJSONArray("friendsList");
            if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0))
            {
              int j = 0;
              while (j < ((JSONArray)localObject2).length())
              {
                ((a.e)localObject1).wSI.add(((JSONArray)localObject2).getString(j));
                j += 1;
              }
            }
            paramString2.wSF.add(localObject1);
            i += 1;
          }
          AppMethodBeat.o(98304);
          return paramString2;
        }
      }
      catch (Exception paramString1)
      {
        ad.e("SnsAdCardVoteCtrl", "getAdVoteInfoExtFromWebUpdate, exp=" + paramString1.toString());
        AppMethodBeat.o(98304);
      }
    }
    return null;
  }
  
  public final void a(p paramp, Object paramObject)
  {
    AppMethodBeat.i(98303);
    for (;;)
    {
      Object localObject1;
      try
      {
        this.xsT.setTag(paramObject);
        this.xsU.setTag(paramObject);
        this.xsZ = paramp;
        Object localObject2 = paramp.dxs();
        localObject1 = paramp.dxs().wTR;
        paramObject = paramp.dyg();
        String str = ((b.j)localObject1).wUF;
        int j = x.jh(str, paramObject);
        if (j <= 0) {
          break label702;
        }
        i = 1;
        paramObject = jl(str, paramObject);
        if (paramObject == null)
        {
          ad.i("SnsAdCardVoteCtrl", "fillVoteInfoView, web voteResult == null, snsId=" + paramp.getSnsId());
          paramp = paramp.dxu().wSt;
          if (!TextUtils.isEmpty(((com.tencent.mm.plugin.sns.storage.b)localObject2).wTy))
          {
            this.xsR.setText(((com.tencent.mm.plugin.sns.storage.b)localObject2).wTy);
            this.xsR.setVisibility(0);
            if (TextUtils.isEmpty(((b.j)localObject1).wUG)) {
              break label584;
            }
            this.xsQ.setText(((b.j)localObject1).wUG);
            this.xsQ.setVisibility(0);
            if (TextUtils.isEmpty(((com.tencent.mm.plugin.sns.storage.b)localObject2).wTx)) {
              break label596;
            }
            this.xsP.setText(((com.tencent.mm.plugin.sns.storage.b)localObject2).wTx);
            this.xsP.setVisibility(0);
            localObject2 = ((b.k)((b.j)localObject1).wUH.get(0)).id;
            str = ((b.k)((b.j)localObject1).wUH.get(1)).id;
            paramObject = ((b.j)localObject1).MD(0);
            localObject1 = ((b.j)localObject1).MD(1);
            if (i == 0) {
              break label661;
            }
            i = paramp.iO((String)localObject2, str);
            int k = 100 - i;
            this.xsS.setVisibility(8);
            this.xsV.setVisibility(0);
            paramp = this.xsW;
            paramp.xYw = i;
            paramp.xYx = k;
            paramp.xYw = Math.max(0, paramp.xYw);
            paramp.xYw = Math.min(100, paramp.xYw);
            paramp.xYx = Math.max(0, paramp.xYx);
            paramp.xYx = Math.min(100, paramp.xYx);
            if (paramp.xYw + paramp.xYx != 100) {
              paramp.xYx = (100 - paramp.xYw);
            }
            paramp.invalidate();
            this.xsX.setText(paramObject + " " + i + "%");
            this.xsY.setText(k + "% " + (String)localObject1);
            if (j != 1) {
              break label617;
            }
            this.xsW.hB(this.xtb, this.xtc);
            this.xsX.setTextColor(this.xtd);
            this.xsY.setTextColor(this.xte);
            AppMethodBeat.o(98303);
          }
        }
        else
        {
          ad.i("SnsAdCardVoteCtrl", "fillVoteInfoView, web voteResult != null, snsId=" + paramp.getSnsId());
          paramp = paramObject;
          continue;
        }
        this.xsR.setVisibility(8);
        continue;
        this.xsQ.setVisibility(8);
      }
      catch (Exception paramp)
      {
        ad.e("SnsAdCardVoteCtrl", "fillVoteInfoView, exp:" + Log.getStackTraceString(paramp));
        AppMethodBeat.o(98303);
        return;
      }
      label584:
      continue;
      label596:
      this.xsP.setVisibility(8);
      this.xsQ.setVisibility(8);
      continue;
      label617:
      this.xsW.hB(this.xtc, this.xtb);
      this.xsX.setTextColor(this.xte);
      this.xsY.setTextColor(this.xtd);
      AppMethodBeat.o(98303);
      return;
      label661:
      this.xsS.setVisibility(0);
      this.xsV.setVisibility(8);
      this.xsT.setText(paramObject);
      this.xsU.setText((CharSequence)localObject1);
      AppMethodBeat.o(98303);
      return;
      label702:
      int i = 0;
    }
  }
  
  public final void dAi()
  {
    AppMethodBeat.i(98305);
    if (this.xsO.getVisibility() != 0) {
      this.xsO.setVisibility(0);
    }
    AppMethodBeat.o(98305);
  }
  
  public final void dAj()
  {
    AppMethodBeat.i(98306);
    if (this.xsO.getVisibility() != 8) {
      this.xsO.setVisibility(8);
    }
    AppMethodBeat.o(98306);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(98307);
    if (paramView == this.xsT)
    {
      this.xta.xUb.onClick(paramView);
      AppMethodBeat.o(98307);
      return;
    }
    if (paramView == this.xsU) {
      this.xta.xUc.onClick(paramView);
    }
    AppMethodBeat.o(98307);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ar
 * JD-Core Version:    0.7.0.1
 */