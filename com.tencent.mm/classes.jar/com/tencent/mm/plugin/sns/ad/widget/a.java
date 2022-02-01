package com.tencent.mm.plugin.sns.ad.widget;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.adxml.AdClickActionInfo;
import com.tencent.mm.plugin.sns.ad.d.a.a;
import com.tencent.mm.plugin.sns.ad.j.c;
import com.tencent.mm.plugin.sns.ad.timeline.a.a.c.a;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.e;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.a.f;
import org.json.JSONObject;

public final class a
  implements View.OnClickListener
{
  private String PNx;
  private w PZK;
  private String QdA;
  private String QdB;
  private com.tencent.mm.plugin.sns.ad.adxml.a QdC;
  public c.a QdD;
  public AdClickActionInfo QdE;
  private ImageView Qdu;
  private TextView Qdv;
  private TextView Qdw;
  private TextView Qdx;
  private TextView Qdy;
  private Button Qdz;
  private View mContentView;
  private Context mContext;
  private int mScene;
  private f vlk;
  
  public a(Context paramContext, int paramInt)
  {
    this.mContext = paramContext;
    this.mScene = paramInt;
  }
  
  private void ajT(int paramInt)
  {
    AppMethodBeat.i(310141);
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put("snsid", this.PNx);
      localJSONObject1.put("uxinfo", this.QdB);
      int i;
      JSONObject localJSONObject2;
      if (this.mScene == 0)
      {
        i = 1;
        localJSONObject1.put("scene", i);
        localJSONObject2 = new JSONObject();
        if (this.QdC != null) {
          break label123;
        }
      }
      label123:
      for (long l = 0L;; l = this.QdC.PKZ)
      {
        localJSONObject2.put("appointmentId", l);
        localJSONObject2.put("opType", paramInt);
        localJSONObject1.put("extInfo", localJSONObject2);
        m.lU("timeline_ad_appointment_submit_action", localJSONObject1.toString());
        AppMethodBeat.o(310141);
        return;
        i = 2;
        break;
      }
      return;
    }
    finally
    {
      Log.e("ADAppointment.ADAppointmentHalfScreenWidget", "doCancelReport, exp=" + localObject.toString());
      AppMethodBeat.o(310141);
    }
  }
  
  private void hct()
  {
    AppMethodBeat.i(310117);
    initContentView();
    refreshView();
    this.vlk = new f(this.mContext, true, 0);
    this.vlk.af(this.mContentView, true);
    this.vlk.GwS = true;
    this.vlk.uR(true);
    if (this.mScene == 2) {
      this.vlk.sRz = true;
    }
    AppMethodBeat.o(310117);
  }
  
  private void hcu()
  {
    AppMethodBeat.i(310132);
    if ((this.vlk != null) && (this.vlk.isShowing())) {
      this.vlk.cyW();
    }
    AppMethodBeat.o(310132);
  }
  
  private void initContentView()
  {
    AppMethodBeat.i(310123);
    View localView = LayoutInflater.from(this.mContext).inflate(b.g.ad_appointment_half_screen, null);
    this.mContentView = localView;
    this.Qdu = ((ImageView)localView.findViewById(b.f.avatar_iv));
    this.Qdv = ((TextView)localView.findViewById(b.f.nickname_tv));
    this.Qdw = ((TextView)localView.findViewById(b.f.title_tv));
    this.Qdx = ((TextView)localView.findViewById(b.f.content_tv));
    this.Qdy = ((TextView)localView.findViewById(b.f.desc_tv));
    localView.findViewById(b.f.close_icon).setOnClickListener(this);
    this.Qdz = ((Button)localView.findViewById(b.f.btn));
    this.Qdz.setOnClickListener(this);
    AppMethodBeat.o(310123);
  }
  
  private void refreshView()
  {
    AppMethodBeat.i(310127);
    this.Qdv.setText(this.QdC.nickname);
    this.Qdw.setText(this.QdC.title);
    this.Qdx.setText(this.QdC.content);
    this.Qdy.setText(this.QdC.PLa);
    if ((this.mScene == 0) || (this.mScene == 1)) {
      if ("0".equals(this.QdA))
      {
        this.Qdz.setText(this.QdC.PLb);
        this.Qdz.setEnabled(true);
      }
    }
    while (MMApplicationContext.isMainProcess())
    {
      com.tencent.mm.plugin.sns.ad.j.a.o(this.QdC.nnS, this.Qdu);
      AppMethodBeat.o(310127);
      return;
      if ("1".equals(this.QdA))
      {
        this.Qdz.setText(this.QdC.PLc);
        this.Qdz.setEnabled(true);
        this.Qdz.setBackgroundResource(b.e.btn_solid_white);
        this.Qdz.setTextColor(this.mContext.getResources().getColor(b.c.white_btn_text_selector));
      }
      else if ("1000".equals(this.QdA))
      {
        this.Qdz.setText(this.QdC.PLj);
        this.Qdz.setEnabled(false);
        continue;
        this.Qdz.setText(this.QdC.PLb);
      }
    }
    c.o(this.QdC.nnS, this.Qdu);
    AppMethodBeat.o(310127);
  }
  
  private void showLoading()
  {
    AppMethodBeat.i(310135);
    String str = this.mContext.getString(b.j.app_waiting);
    if (this.PZK == null) {
      this.PZK = w.a(this.mContext, str, true);
    }
    if (!this.PZK.isShowing()) {
      this.PZK.show();
    }
    AppMethodBeat.o(310135);
  }
  
  public final void a(String paramString1, String paramString2, com.tencent.mm.plugin.sns.ad.adxml.a parama, String paramString3)
  {
    AppMethodBeat.i(310172);
    if ((TextUtils.isEmpty(paramString2)) || (parama == null))
    {
      Log.e("ADAppointment.ADAppointmentHalfScreenWidget", "showBottomSheet err, uxinfo=" + paramString2 + ", info=" + parama);
      AppMethodBeat.o(310172);
      return;
    }
    Log.i("ADAppointment.ADAppointmentHalfScreenWidget", "showBottomSheet, status=" + paramString3 + ", appointmentId=" + parama.PKZ + ", uxInfo=" + paramString2);
    this.QdB = paramString2;
    this.PNx = paramString1;
    this.QdC = parama;
    this.QdA = paramString3;
    if (this.vlk == null) {
      hct();
    }
    if (!this.vlk.isShowing()) {
      this.vlk.dDn();
    }
    AppMethodBeat.o(310172);
  }
  
  /* Error */
  public final void onClick(View paramView)
  {
    // Byte code:
    //   0: ldc_w 415
    //   3: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 417	com/tencent/mm/hellhoundlib/b/b
    //   9: dup
    //   10: invokespecial 418	com/tencent/mm/hellhoundlib/b/b:<init>	()V
    //   13: astore_3
    //   14: aload_3
    //   15: aload_1
    //   16: invokevirtual 422	com/tencent/mm/hellhoundlib/b/b:cH	(Ljava/lang/Object;)V
    //   19: ldc_w 424
    //   22: ldc_w 425
    //   25: ldc_w 426
    //   28: ldc_w 427
    //   31: aload_0
    //   32: aload_3
    //   33: invokevirtual 431	com/tencent/mm/hellhoundlib/b/b:aYj	()[Ljava/lang/Object;
    //   36: invokestatic 436	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V
    //   39: aload_1
    //   40: invokevirtual 440	android/view/View:getId	()I
    //   43: istore_2
    //   44: iload_2
    //   45: getstatic 272	com/tencent/mm/plugin/sns/b$f:close_icon	I
    //   48: if_icmpne +50 -> 98
    //   51: aload_0
    //   52: invokespecial 442	com/tencent/mm/plugin/sns/ad/widget/a:hcu	()V
    //   55: aload_0
    //   56: getfield 46	com/tencent/mm/plugin/sns/ad/widget/a:mContext	Landroid/content/Context;
    //   59: instanceof 444
    //   62: ifeq +13 -> 75
    //   65: aload_0
    //   66: getfield 46	com/tencent/mm/plugin/sns/ad/widget/a:mContext	Landroid/content/Context;
    //   69: checkcast 444	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI
    //   72: invokestatic 450	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ar:bs	(Landroid/app/Activity;)V
    //   75: aload_0
    //   76: ldc_w 424
    //   79: ldc_w 425
    //   82: ldc_w 426
    //   85: ldc_w 427
    //   88: invokestatic 453	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   91: ldc_w 415
    //   94: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: return
    //   98: iload_2
    //   99: getstatic 279	com/tencent/mm/plugin/sns/b$f:btn	I
    //   102: if_icmpne -47 -> 55
    //   105: aload_0
    //   106: getfield 48	com/tencent/mm/plugin/sns/ad/widget/a:mScene	I
    //   109: ifeq +11 -> 120
    //   112: aload_0
    //   113: getfield 48	com/tencent/mm/plugin/sns/ad/widget/a:mScene	I
    //   116: iconst_1
    //   117: if_icmpne +96 -> 213
    //   120: aload_0
    //   121: invokespecial 442	com/tencent/mm/plugin/sns/ad/widget/a:hcu	()V
    //   124: ldc_w 303
    //   127: aload_0
    //   128: getfield 305	com/tencent/mm/plugin/sns/ad/widget/a:QdA	Ljava/lang/String;
    //   131: invokevirtual 311	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   134: ifeq +41 -> 175
    //   137: aload_0
    //   138: invokespecial 455	com/tencent/mm/plugin/sns/ad/widget/a:showLoading	()V
    //   141: aload_0
    //   142: getfield 128	com/tencent/mm/plugin/sns/ad/widget/a:PNx	Ljava/lang/String;
    //   145: aload_0
    //   146: getfield 136	com/tencent/mm/plugin/sns/ad/widget/a:QdB	Ljava/lang/String;
    //   149: aload_0
    //   150: getfield 143	com/tencent/mm/plugin/sns/ad/widget/a:QdC	Lcom/tencent/mm/plugin/sns/ad/adxml/a;
    //   153: getfield 166	com/tencent/mm/plugin/sns/ad/adxml/a:PKZ	J
    //   156: new 8	com/tencent/mm/plugin/sns/ad/widget/a$1
    //   159: dup
    //   160: aload_0
    //   161: invokespecial 457	com/tencent/mm/plugin/sns/ad/widget/a$1:<init>	(Lcom/tencent/mm/plugin/sns/ad/widget/a;)V
    //   164: invokestatic 462	com/tencent/mm/plugin/sns/ad/d/a:a	(Ljava/lang/String;Ljava/lang/String;JLcom/tencent/mm/plugin/sns/ad/d/a$a;)V
    //   167: aload_0
    //   168: iconst_0
    //   169: invokespecial 464	com/tencent/mm/plugin/sns/ad/widget/a:ajT	(I)V
    //   172: goto -117 -> 55
    //   175: aload_0
    //   176: invokespecial 455	com/tencent/mm/plugin/sns/ad/widget/a:showLoading	()V
    //   179: aload_0
    //   180: getfield 128	com/tencent/mm/plugin/sns/ad/widget/a:PNx	Ljava/lang/String;
    //   183: aload_0
    //   184: getfield 136	com/tencent/mm/plugin/sns/ad/widget/a:QdB	Ljava/lang/String;
    //   187: aload_0
    //   188: getfield 143	com/tencent/mm/plugin/sns/ad/widget/a:QdC	Lcom/tencent/mm/plugin/sns/ad/adxml/a;
    //   191: getfield 166	com/tencent/mm/plugin/sns/ad/adxml/a:PKZ	J
    //   194: new 10	com/tencent/mm/plugin/sns/ad/widget/a$2
    //   197: dup
    //   198: aload_0
    //   199: invokespecial 465	com/tencent/mm/plugin/sns/ad/widget/a$2:<init>	(Lcom/tencent/mm/plugin/sns/ad/widget/a;)V
    //   202: invokestatic 467	com/tencent/mm/plugin/sns/ad/d/a:b	(Ljava/lang/String;Ljava/lang/String;JLcom/tencent/mm/plugin/sns/ad/d/a$a;)V
    //   205: aload_0
    //   206: iconst_1
    //   207: invokespecial 464	com/tencent/mm/plugin/sns/ad/widget/a:ajT	(I)V
    //   210: goto -155 -> 55
    //   213: aload_0
    //   214: invokespecial 442	com/tencent/mm/plugin/sns/ad/widget/a:hcu	()V
    //   217: goto -162 -> 55
    //   220: astore_1
    //   221: goto -146 -> 75
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	224	0	this	a
    //   0	224	1	paramView	View
    //   43	60	2	i	int
    //   13	20	3	localb	com.tencent.mm.hellhoundlib.b.b
    // Exception table:
    //   from	to	target	type
    //   55	75	220	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.a
 * JD-Core Version:    0.7.0.1
 */