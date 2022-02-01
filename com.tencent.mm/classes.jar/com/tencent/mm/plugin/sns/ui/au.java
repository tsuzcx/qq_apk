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
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.plugin.sns.ui.widget.SnsRatioView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class au
  implements View.OnClickListener
{
  private Context mContext;
  private View zWX;
  private TextView zWY;
  private TextView zWZ;
  private TextView zXa;
  private View zXb;
  private Button zXc;
  private Button zXd;
  private View zXe;
  private SnsRatioView zXf;
  private TextView zXg;
  private TextView zXh;
  private p zXi;
  private int zXj;
  private int zXk;
  private int zXl;
  private int zXm;
  private c zaU;
  
  public au(Context paramContext, View paramView, c paramc)
  {
    AppMethodBeat.i(98302);
    this.zXj = Color.parseColor("#1A000000");
    this.zXk = Color.parseColor("#FFFFFFFF");
    this.zXl = Color.parseColor("#E6000000");
    this.zXm = Color.parseColor("#4D000000");
    this.mContext = paramContext;
    this.zaU = paramc;
    this.zWX = paramView.findViewById(2131306637);
    this.zXj = paramContext.getResources().getColor(2131100901);
    this.zXk = paramContext.getResources().getColor(2131100898);
    this.zXl = paramContext.getResources().getColor(2131100902);
    this.zXm = paramContext.getResources().getColor(2131100899);
    this.zWY = ((TextView)paramView.findViewById(2131306641));
    this.zWZ = ((TextView)paramView.findViewById(2131306639));
    this.zXa = ((TextView)paramView.findViewById(2131306638));
    this.zXb = paramView.findViewById(2131306634);
    this.zXc = ((Button)paramView.findViewById(2131306635));
    this.zXd = ((Button)paramView.findViewById(2131306636));
    this.zXe = paramView.findViewById(2131303727);
    this.zXf = ((SnsRatioView)paramView.findViewById(2131306640));
    this.zXg = ((TextView)paramView.findViewById(2131306642));
    this.zXh = ((TextView)paramView.findViewById(2131306643));
    this.zXc.setOnClickListener(this);
    this.zXd.setOnClickListener(this);
    int i = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 4);
    int j = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 8);
    int k = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 8);
    paramContext = this.zXf;
    paramContext.ADM.setAntiAlias(true);
    paramContext.ADN.setAntiAlias(true);
    paramContext.ADG = i;
    paramContext.ADJ = Math.max(i, k);
    paramContext.ADH = 70;
    paramContext.ADI = j;
    paramContext.ADO[0] = i;
    paramContext.ADO[1] = i;
    paramContext.ADO[2] = i;
    paramContext.ADO[3] = i;
    paramContext.ADO[4] = i;
    paramContext.ADO[5] = i;
    paramContext.ADO[6] = i;
    paramContext.ADO[7] = i;
    AppMethodBeat.o(98302);
  }
  
  private static a.d jW(String paramString1, String paramString2)
  {
    AppMethodBeat.i(98304);
    long l1 = System.currentTimeMillis();
    g.ajA();
    Object localObject1 = com.tencent.mm.kernel.a.aiq();
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
            ((a.e)localObject1).zvs = ((JSONObject)localObject2).optInt("scoring");
            ((a.e)localObject1).zvt = ((JSONObject)localObject2).optInt("friends");
            localObject2 = ((JSONObject)localObject2).optJSONArray("friendsList");
            if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0))
            {
              int j = 0;
              while (j < ((JSONArray)localObject2).length())
              {
                ((a.e)localObject1).zvu.add(((JSONArray)localObject2).getString(j));
                j += 1;
              }
            }
            paramString2.zvr.add(localObject1);
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
        this.zXc.setTag(paramObject);
        this.zXd.setTag(paramObject);
        this.zXi = paramp;
        Object localObject2 = paramp.dRL();
        localObject1 = paramp.dRL().zwG;
        paramObject = paramp.dYT();
        String str = ((b.k)localObject1).zxA;
        int j = x.jS(str, paramObject);
        if (j <= 0) {
          break label702;
        }
        i = 1;
        paramObject = jW(str, paramObject);
        if (paramObject == null)
        {
          ad.i("SnsAdCardVoteCtrl", "fillVoteInfoView, web voteResult == null, snsId=" + paramp.getSnsId());
          paramp = paramp.dRK().zva;
          if (!TextUtils.isEmpty(((com.tencent.mm.plugin.sns.storage.b)localObject2).zwk))
          {
            this.zXa.setText(((com.tencent.mm.plugin.sns.storage.b)localObject2).zwk);
            this.zXa.setVisibility(0);
            if (TextUtils.isEmpty(((b.k)localObject1).zxB)) {
              break label584;
            }
            this.zWZ.setText(((b.k)localObject1).zxB);
            this.zWZ.setVisibility(0);
            if (TextUtils.isEmpty(((com.tencent.mm.plugin.sns.storage.b)localObject2).zwj)) {
              break label596;
            }
            this.zWY.setText(((com.tencent.mm.plugin.sns.storage.b)localObject2).zwj);
            this.zWY.setVisibility(0);
            localObject2 = ((b.l)((b.k)localObject1).zxC.get(0)).id;
            str = ((b.l)((b.k)localObject1).zxC.get(1)).id;
            paramObject = ((b.k)localObject1).Qn(0);
            localObject1 = ((b.k)localObject1).Qn(1);
            if (i == 0) {
              break label661;
            }
            i = paramp.jx((String)localObject2, str);
            int k = 100 - i;
            this.zXb.setVisibility(8);
            this.zXe.setVisibility(0);
            paramp = this.zXf;
            paramp.ADE = i;
            paramp.ADF = k;
            paramp.ADE = Math.max(0, paramp.ADE);
            paramp.ADE = Math.min(100, paramp.ADE);
            paramp.ADF = Math.max(0, paramp.ADF);
            paramp.ADF = Math.min(100, paramp.ADF);
            if (paramp.ADE + paramp.ADF != 100) {
              paramp.ADF = (100 - paramp.ADE);
            }
            paramp.invalidate();
            this.zXg.setText(paramObject + " " + i + "%");
            this.zXh.setText(k + "% " + (String)localObject1);
            if (j != 1) {
              break label617;
            }
            this.zXf.ib(this.zXj, this.zXk);
            this.zXg.setTextColor(this.zXl);
            this.zXh.setTextColor(this.zXm);
            AppMethodBeat.o(98303);
          }
        }
        else
        {
          ad.i("SnsAdCardVoteCtrl", "fillVoteInfoView, web voteResult != null, snsId=" + paramp.getSnsId());
          paramp = paramObject;
          continue;
        }
        this.zXa.setVisibility(8);
        continue;
        this.zWZ.setVisibility(8);
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
      this.zWY.setVisibility(8);
      this.zWZ.setVisibility(8);
      continue;
      label617:
      this.zXf.ib(this.zXk, this.zXj);
      this.zXg.setTextColor(this.zXm);
      this.zXh.setTextColor(this.zXl);
      AppMethodBeat.o(98303);
      return;
      label661:
      this.zXb.setVisibility(0);
      this.zXe.setVisibility(8);
      this.zXc.setText(paramObject);
      this.zXd.setText((CharSequence)localObject1);
      AppMethodBeat.o(98303);
      return;
      label702:
      int i = 0;
    }
  }
  
  public final void eaT()
  {
    AppMethodBeat.i(98305);
    if (this.zWX.getVisibility() != 0) {
      this.zWX.setVisibility(0);
    }
    AppMethodBeat.o(98305);
  }
  
  public final void eaU()
  {
    AppMethodBeat.i(98306);
    if (this.zWX.getVisibility() != 8) {
      this.zWX.setVisibility(8);
    }
    AppMethodBeat.o(98306);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(98307);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsAdCardVoteCtrl", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    if (paramView == this.zXc) {
      this.zaU.Aza.onClick(paramView);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsAdCardVoteCtrl", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(98307);
      return;
      if (paramView == this.zXd) {
        this.zaU.Azb.onClick(paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.au
 * JD-Core Version:    0.7.0.1
 */