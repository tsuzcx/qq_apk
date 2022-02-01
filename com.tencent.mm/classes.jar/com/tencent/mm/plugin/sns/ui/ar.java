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
import com.tencent.mm.plugin.sns.storage.b.k;
import com.tencent.mm.plugin.sns.storage.b.l;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.plugin.sns.ui.widget.SnsRatioView;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class ar
  implements View.OnClickListener
{
  private Context mContext;
  private com.tencent.mm.plugin.sns.ui.d.b xLF;
  private View yFF;
  private TextView yFG;
  private TextView yFH;
  private TextView yFI;
  private View yFJ;
  private Button yFK;
  private Button yFL;
  private View yFM;
  private SnsRatioView yFN;
  private TextView yFO;
  private TextView yFP;
  private p yFQ;
  private int yFR;
  private int yFS;
  private int yFT;
  private int yFU;
  
  public ar(Context paramContext, View paramView, com.tencent.mm.plugin.sns.ui.d.b paramb)
  {
    AppMethodBeat.i(98302);
    this.yFR = Color.parseColor("#1A000000");
    this.yFS = Color.parseColor("#FFFFFFFF");
    this.yFT = Color.parseColor("#E6000000");
    this.yFU = Color.parseColor("#4D000000");
    this.mContext = paramContext;
    this.xLF = paramb;
    this.yFF = paramView.findViewById(2131306637);
    this.yFR = paramContext.getResources().getColor(2131100901);
    this.yFS = paramContext.getResources().getColor(2131100898);
    this.yFT = paramContext.getResources().getColor(2131100902);
    this.yFU = paramContext.getResources().getColor(2131100899);
    this.yFG = ((TextView)paramView.findViewById(2131306641));
    this.yFH = ((TextView)paramView.findViewById(2131306639));
    this.yFI = ((TextView)paramView.findViewById(2131306638));
    this.yFJ = paramView.findViewById(2131306634);
    this.yFK = ((Button)paramView.findViewById(2131306635));
    this.yFL = ((Button)paramView.findViewById(2131306636));
    this.yFM = paramView.findViewById(2131303727);
    this.yFN = ((SnsRatioView)paramView.findViewById(2131306640));
    this.yFO = ((TextView)paramView.findViewById(2131306642));
    this.yFP = ((TextView)paramView.findViewById(2131306643));
    this.yFK.setOnClickListener(this);
    this.yFL.setOnClickListener(this);
    int i = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 4);
    int j = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 8);
    int k = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 8);
    paramContext = this.yFN;
    paramContext.zlB.setAntiAlias(true);
    paramContext.zlC.setAntiAlias(true);
    paramContext.zlv = i;
    paramContext.zly = Math.max(i, k);
    paramContext.zlw = 70;
    paramContext.zlx = j;
    paramContext.zlD[0] = i;
    paramContext.zlD[1] = i;
    paramContext.zlD[2] = i;
    paramContext.zlD[3] = i;
    paramContext.zlD[4] = i;
    paramContext.zlD[5] = i;
    paramContext.zlD[6] = i;
    paramContext.zlD[7] = i;
    AppMethodBeat.o(98302);
  }
  
  private static a.d jJ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(98304);
    long l1 = System.currentTimeMillis();
    g.agP();
    Object localObject1 = com.tencent.mm.kernel.a.afE();
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
        paramString1 = ai.getContext().getSharedPreferences("SnsAdVote", 0).getString(paramString1, "");
        label118:
        long l2 = System.currentTimeMillis();
        ac.i("StorageHelper", "getSnsAdVoteResultInfo, ret=" + paramString1 + ", timeCost=" + (l2 - l1));
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
            ac.e("StorageHelper", "getSnsAdVoteResultInfo, key is empty");
            break label118;
          }
          paramString2 = new a.d();
          i = 0;
          while (i < paramString1.length())
          {
            localObject2 = paramString1.getJSONObject(i);
            localObject1 = new a.e();
            ((a.e)localObject1).id = ((JSONObject)localObject2).optString("id");
            ((a.e)localObject1).yfq = ((JSONObject)localObject2).optInt("scoring");
            ((a.e)localObject1).yfr = ((JSONObject)localObject2).optInt("friends");
            localObject2 = ((JSONObject)localObject2).optJSONArray("friendsList");
            if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0))
            {
              int j = 0;
              while (j < ((JSONArray)localObject2).length())
              {
                ((a.e)localObject1).yfs.add(((JSONArray)localObject2).getString(j));
                j += 1;
              }
            }
            paramString2.yfp.add(localObject1);
            i += 1;
          }
          AppMethodBeat.o(98304);
          return paramString2;
        }
      }
      catch (Exception paramString1)
      {
        ac.e("SnsAdCardVoteCtrl", "getAdVoteInfoExtFromWebUpdate, exp=" + paramString1.toString());
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
        this.yFK.setTag(paramObject);
        this.yFL.setTag(paramObject);
        this.yFQ = paramp;
        Object localObject2 = paramp.dFR();
        localObject1 = paramp.dFR().ygC;
        paramObject = paramp.dMD();
        String str = ((b.k)localObject1).yht;
        int j = x.jF(str, paramObject);
        if (j <= 0) {
          break label702;
        }
        i = 1;
        paramObject = jJ(str, paramObject);
        if (paramObject == null)
        {
          ac.i("SnsAdCardVoteCtrl", "fillVoteInfoView, web voteResult == null, snsId=" + paramp.getSnsId());
          paramp = paramp.dFQ().yeZ;
          if (!TextUtils.isEmpty(((com.tencent.mm.plugin.sns.storage.b)localObject2).ygi))
          {
            this.yFI.setText(((com.tencent.mm.plugin.sns.storage.b)localObject2).ygi);
            this.yFI.setVisibility(0);
            if (TextUtils.isEmpty(((b.k)localObject1).yhu)) {
              break label584;
            }
            this.yFH.setText(((b.k)localObject1).yhu);
            this.yFH.setVisibility(0);
            if (TextUtils.isEmpty(((com.tencent.mm.plugin.sns.storage.b)localObject2).ygh)) {
              break label596;
            }
            this.yFG.setText(((com.tencent.mm.plugin.sns.storage.b)localObject2).ygh);
            this.yFG.setVisibility(0);
            localObject2 = ((b.l)((b.k)localObject1).yhv.get(0)).id;
            str = ((b.l)((b.k)localObject1).yhv.get(1)).id;
            paramObject = ((b.k)localObject1).OF(0);
            localObject1 = ((b.k)localObject1).OF(1);
            if (i == 0) {
              break label661;
            }
            i = paramp.jl((String)localObject2, str);
            int k = 100 - i;
            this.yFJ.setVisibility(8);
            this.yFM.setVisibility(0);
            paramp = this.yFN;
            paramp.zlt = i;
            paramp.zlu = k;
            paramp.zlt = Math.max(0, paramp.zlt);
            paramp.zlt = Math.min(100, paramp.zlt);
            paramp.zlu = Math.max(0, paramp.zlu);
            paramp.zlu = Math.min(100, paramp.zlu);
            if (paramp.zlt + paramp.zlu != 100) {
              paramp.zlu = (100 - paramp.zlt);
            }
            paramp.invalidate();
            this.yFO.setText(paramObject + " " + i + "%");
            this.yFP.setText(k + "% " + (String)localObject1);
            if (j != 1) {
              break label617;
            }
            this.yFN.hK(this.yFR, this.yFS);
            this.yFO.setTextColor(this.yFT);
            this.yFP.setTextColor(this.yFU);
            AppMethodBeat.o(98303);
          }
        }
        else
        {
          ac.i("SnsAdCardVoteCtrl", "fillVoteInfoView, web voteResult != null, snsId=" + paramp.getSnsId());
          paramp = paramObject;
          continue;
        }
        this.yFI.setVisibility(8);
        continue;
        this.yFH.setVisibility(8);
      }
      catch (Exception paramp)
      {
        ac.e("SnsAdCardVoteCtrl", "fillVoteInfoView, exp:" + Log.getStackTraceString(paramp));
        AppMethodBeat.o(98303);
        return;
      }
      label584:
      continue;
      label596:
      this.yFG.setVisibility(8);
      this.yFH.setVisibility(8);
      continue;
      label617:
      this.yFN.hK(this.yFS, this.yFR);
      this.yFO.setTextColor(this.yFU);
      this.yFP.setTextColor(this.yFT);
      AppMethodBeat.o(98303);
      return;
      label661:
      this.yFJ.setVisibility(0);
      this.yFM.setVisibility(8);
      this.yFK.setText(paramObject);
      this.yFL.setText((CharSequence)localObject1);
      AppMethodBeat.o(98303);
      return;
      label702:
      int i = 0;
    }
  }
  
  public final void dOF()
  {
    AppMethodBeat.i(98305);
    if (this.yFF.getVisibility() != 0) {
      this.yFF.setVisibility(0);
    }
    AppMethodBeat.o(98305);
  }
  
  public final void dOG()
  {
    AppMethodBeat.i(98306);
    if (this.yFF.getVisibility() != 8) {
      this.yFF.setVisibility(8);
    }
    AppMethodBeat.o(98306);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(98307);
    if (paramView == this.yFK)
    {
      this.xLF.zgX.onClick(paramView);
      AppMethodBeat.o(98307);
      return;
    }
    if (paramView == this.yFL) {
      this.xLF.zgY.onClick(paramView);
    }
    AppMethodBeat.o(98307);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ar
 * JD-Core Version:    0.7.0.1
 */