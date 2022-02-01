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
import com.tencent.mm.plugin.sns.storage.b.l;
import com.tencent.mm.plugin.sns.storage.b.m;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.plugin.sns.ui.widget.SnsRatioView;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class au
  implements View.OnClickListener
{
  private View Aoi;
  private TextView Aoj;
  private TextView Aok;
  private TextView Aol;
  private View Aom;
  private Button Aon;
  private Button Aoo;
  private View Aop;
  private SnsRatioView Aoq;
  private TextView Aor;
  private TextView Aos;
  private p Aot;
  private int Aou;
  private int Aov;
  private int Aow;
  private int Aox;
  private Context mContext;
  private c zrv;
  
  public au(Context paramContext, View paramView, c paramc)
  {
    AppMethodBeat.i(98302);
    this.Aou = Color.parseColor("#1A000000");
    this.Aov = Color.parseColor("#FFFFFFFF");
    this.Aow = Color.parseColor("#E6000000");
    this.Aox = Color.parseColor("#4D000000");
    this.mContext = paramContext;
    this.zrv = paramc;
    this.Aoi = paramView.findViewById(2131306637);
    this.Aou = paramContext.getResources().getColor(2131100901);
    this.Aov = paramContext.getResources().getColor(2131100898);
    this.Aow = paramContext.getResources().getColor(2131100902);
    this.Aox = paramContext.getResources().getColor(2131100899);
    this.Aoj = ((TextView)paramView.findViewById(2131306641));
    this.Aok = ((TextView)paramView.findViewById(2131306639));
    this.Aol = ((TextView)paramView.findViewById(2131306638));
    this.Aom = paramView.findViewById(2131306634);
    this.Aon = ((Button)paramView.findViewById(2131306635));
    this.Aoo = ((Button)paramView.findViewById(2131306636));
    this.Aop = paramView.findViewById(2131303727);
    this.Aoq = ((SnsRatioView)paramView.findViewById(2131306640));
    this.Aor = ((TextView)paramView.findViewById(2131306642));
    this.Aos = ((TextView)paramView.findViewById(2131306643));
    this.Aon.setOnClickListener(this);
    this.Aoo.setOnClickListener(this);
    int i = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 4);
    int j = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 8);
    int k = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 8);
    paramContext = this.Aoq;
    paramContext.AVm.setAntiAlias(true);
    paramContext.AVn.setAntiAlias(true);
    paramContext.AVg = i;
    paramContext.AVj = Math.max(i, k);
    paramContext.AVh = 70;
    paramContext.AVi = j;
    paramContext.AVo[0] = i;
    paramContext.AVo[1] = i;
    paramContext.AVo[2] = i;
    paramContext.AVo[3] = i;
    paramContext.AVo[4] = i;
    paramContext.AVo[5] = i;
    paramContext.AVo[6] = i;
    paramContext.AVo[7] = i;
    AppMethodBeat.o(98302);
  }
  
  private static a.d kd(String paramString1, String paramString2)
  {
    AppMethodBeat.i(98304);
    long l1 = System.currentTimeMillis();
    g.ajP();
    Object localObject1 = com.tencent.mm.kernel.a.aiF();
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
        paramString1 = ak.getContext().getSharedPreferences("SnsAdVote", 0).getString(paramString1, "");
        label118:
        long l2 = System.currentTimeMillis();
        ae.i("StorageHelper", "getSnsAdVoteResultInfo, ret=" + paramString1 + ", timeCost=" + (l2 - l1));
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
            ae.e("StorageHelper", "getSnsAdVoteResultInfo, key is empty");
            break label118;
          }
          paramString2 = new a.d();
          i = 0;
          while (i < paramString1.length())
          {
            localObject2 = paramString1.getJSONObject(i);
            localObject1 = new a.e();
            ((a.e)localObject1).id = ((JSONObject)localObject2).optString("id");
            ((a.e)localObject1).zMN = ((JSONObject)localObject2).optInt("scoring");
            ((a.e)localObject1).zMO = ((JSONObject)localObject2).optInt("friends");
            localObject2 = ((JSONObject)localObject2).optJSONArray("friendsList");
            if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0))
            {
              int j = 0;
              while (j < ((JSONArray)localObject2).length())
              {
                ((a.e)localObject1).zMP.add(((JSONArray)localObject2).getString(j));
                j += 1;
              }
            }
            paramString2.zMM.add(localObject1);
            i += 1;
          }
          AppMethodBeat.o(98304);
          return paramString2;
        }
      }
      catch (Exception paramString1)
      {
        ae.e("SnsAdCardVoteCtrl", "getAdVoteInfoExtFromWebUpdate, exp=" + paramString1.toString());
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
        this.Aon.setTag(paramObject);
        this.Aoo.setTag(paramObject);
        this.Aot = paramp;
        Object localObject2 = paramp.dVj();
        localObject1 = paramp.dVj().zOe;
        paramObject = paramp.ecx();
        String str = ((b.l)localObject1).zOZ;
        int j = x.jZ(str, paramObject);
        if (j <= 0) {
          break label702;
        }
        i = 1;
        paramObject = kd(str, paramObject);
        if (paramObject == null)
        {
          ae.i("SnsAdCardVoteCtrl", "fillVoteInfoView, web voteResult == null, snsId=" + paramp.getSnsId());
          paramp = paramp.dVi().zMv;
          if (!TextUtils.isEmpty(((com.tencent.mm.plugin.sns.storage.b)localObject2).zNF))
          {
            this.Aol.setText(((com.tencent.mm.plugin.sns.storage.b)localObject2).zNF);
            this.Aol.setVisibility(0);
            if (TextUtils.isEmpty(((b.l)localObject1).zPa)) {
              break label584;
            }
            this.Aok.setText(((b.l)localObject1).zPa);
            this.Aok.setVisibility(0);
            if (TextUtils.isEmpty(((com.tencent.mm.plugin.sns.storage.b)localObject2).zNE)) {
              break label596;
            }
            this.Aoj.setText(((com.tencent.mm.plugin.sns.storage.b)localObject2).zNE);
            this.Aoj.setVisibility(0);
            localObject2 = ((b.m)((b.l)localObject1).zPb.get(0)).id;
            str = ((b.m)((b.l)localObject1).zPb.get(1)).id;
            paramObject = ((b.l)localObject1).QU(0);
            localObject1 = ((b.l)localObject1).QU(1);
            if (i == 0) {
              break label661;
            }
            i = paramp.jE((String)localObject2, str);
            int k = 100 - i;
            this.Aom.setVisibility(8);
            this.Aop.setVisibility(0);
            paramp = this.Aoq;
            paramp.AVe = i;
            paramp.AVf = k;
            paramp.AVe = Math.max(0, paramp.AVe);
            paramp.AVe = Math.min(100, paramp.AVe);
            paramp.AVf = Math.max(0, paramp.AVf);
            paramp.AVf = Math.min(100, paramp.AVf);
            if (paramp.AVe + paramp.AVf != 100) {
              paramp.AVf = (100 - paramp.AVe);
            }
            paramp.invalidate();
            this.Aor.setText(paramObject + " " + i + "%");
            this.Aos.setText(k + "% " + (String)localObject1);
            if (j != 1) {
              break label617;
            }
            this.Aoq.ie(this.Aou, this.Aov);
            this.Aor.setTextColor(this.Aow);
            this.Aos.setTextColor(this.Aox);
            AppMethodBeat.o(98303);
          }
        }
        else
        {
          ae.i("SnsAdCardVoteCtrl", "fillVoteInfoView, web voteResult != null, snsId=" + paramp.getSnsId());
          paramp = paramObject;
          continue;
        }
        this.Aol.setVisibility(8);
        continue;
        this.Aok.setVisibility(8);
      }
      catch (Exception paramp)
      {
        ae.e("SnsAdCardVoteCtrl", "fillVoteInfoView, exp:" + Log.getStackTraceString(paramp));
        AppMethodBeat.o(98303);
        return;
      }
      label584:
      continue;
      label596:
      this.Aoj.setVisibility(8);
      this.Aok.setVisibility(8);
      continue;
      label617:
      this.Aoq.ie(this.Aov, this.Aou);
      this.Aor.setTextColor(this.Aox);
      this.Aos.setTextColor(this.Aow);
      AppMethodBeat.o(98303);
      return;
      label661:
      this.Aom.setVisibility(0);
      this.Aop.setVisibility(8);
      this.Aon.setText(paramObject);
      this.Aoo.setText((CharSequence)localObject1);
      AppMethodBeat.o(98303);
      return;
      label702:
      int i = 0;
    }
  }
  
  public final void eeA()
  {
    AppMethodBeat.i(98306);
    if (this.Aoi.getVisibility() != 8) {
      this.Aoi.setVisibility(8);
    }
    AppMethodBeat.o(98306);
  }
  
  public final void eez()
  {
    AppMethodBeat.i(98305);
    if (this.Aoi.getVisibility() != 0) {
      this.Aoi.setVisibility(0);
    }
    AppMethodBeat.o(98305);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(98307);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsAdCardVoteCtrl", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    if (paramView == this.Aon) {
      this.zrv.AQw.onClick(paramView);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsAdCardVoteCtrl", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(98307);
      return;
      if (paramView == this.Aoo) {
        this.zrv.AQx.onClick(paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.au
 * JD-Core Version:    0.7.0.1
 */