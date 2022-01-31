package com.tencent.mm.plugin.sns.g;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.AbsoluteLayout;
import android.widget.AbsoluteLayout.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.e;
import com.tencent.mm.plugin.sns.model.u;
import com.tencent.mm.plugin.sns.ui.bc;
import com.tencent.mm.pluginsdk.f;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.d;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.w;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class b
  implements e
{
  private boolean cqS;
  Context mContext;
  private int qZo;
  private int[] rkA;
  private int[] rkB;
  private int[] rkC;
  Map<Long, b.b> rkD;
  private Map<Long, b.b> rkE;
  private HashSet<Long> rkF;
  h rkG;
  private HashMap<Long, Boolean> rkH;
  public final int rkr;
  private com.tencent.mm.plugin.sns.ui.d.b rks;
  private FrameLayout rkt;
  AbsoluteLayout rku;
  protected Animation rkv;
  protected Animation rkw;
  boolean rkx;
  int[] rky;
  private int[] rkz;
  
  public b(Context paramContext, com.tencent.mm.plugin.sns.ui.d.b paramb, FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(36770);
    this.rkr = 14;
    this.rku = null;
    this.rkx = false;
    this.rky = new int[] { 2131303737, 2131303738, 2131303739, 2131303740 };
    this.rkz = new int[] { 2131230785, 2131230787, 2131230786, 2131230784 };
    this.rkA = this.rky;
    this.cqS = true;
    this.rkD = new HashMap();
    this.rkE = new HashMap();
    this.rkF = new HashSet();
    this.rkG = null;
    this.rkH = new HashMap();
    this.qZo = -1;
    g localg = ag.coX();
    h localh2 = new h();
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.c.abU().me("100007");
    h localh1;
    if (!localc.isValid())
    {
      ab.i("MicroMsg.SnsABTestStrategy", "abtest is invalid");
      localh1 = null;
    }
    for (;;)
    {
      localg.rlG = localh1;
      this.rkG = ag.coX().cqb();
      if (this.rkG != null)
      {
        this.rkB = this.rkG.rlI;
        if (!this.rkG.cqc()) {
          this.cqS = false;
        }
      }
      this.mContext = paramContext;
      this.rks = paramb;
      this.rkt = paramFrameLayout;
      this.rkv = new ScaleAnimation(1.0F, 1.0F, 0.0F, 1.0F, 1, 1.0F, 1, 0.0F);
      this.rkv = AnimationUtils.loadAnimation(paramContext, 2131034161);
      this.rkw = new ScaleAnimation(1.0F, 1.0F, 1.0F, 0.0F, 1, 1.0F, 1, 0.0F);
      this.rkw = AnimationUtils.loadAnimation(paramContext, 2131034162);
      AppMethodBeat.o(36770);
      return;
      Map localMap = localc.dvN();
      localh1 = localh2;
      if (localMap != null)
      {
        ab.i("MicroMsg.SnsABTestStrategy", "snsabtest feed " + localc.field_expId + " " + localc.field_layerId + " " + localc.field_startTime + " " + localc.field_endTime);
        localh2.h(localc.field_layerId, localc.field_expId, localMap);
        localh1 = localh2;
      }
    }
  }
  
  private static String a(a parama, Map<String, String> paramMap)
  {
    AppMethodBeat.i(36773);
    if (parama == null)
    {
      AppMethodBeat.o(36773);
      return "";
    }
    StringBuffer localStringBuffer2;
    StringBuffer localStringBuffer1;
    int i;
    label48:
    char c;
    if (aa.dsD())
    {
      parama = parama.rkn;
      localStringBuffer2 = new StringBuffer();
      localStringBuffer1 = new StringBuffer();
      i = 0;
      if (i >= parama.length()) {
        break label218;
      }
      c = parama.charAt(i);
      if (c != '$') {
        break label190;
      }
      if (localStringBuffer1.length() != 0) {
        break label112;
      }
      localStringBuffer1.append(c);
    }
    label190:
    for (;;)
    {
      i += 1;
      break label48;
      if (aa.dsE())
      {
        parama = parama.rko;
        break;
      }
      parama = parama.rkp;
      break;
      label112:
      if (localStringBuffer1.charAt(localStringBuffer1.length() - 1) == '$')
      {
        localStringBuffer2.append('$');
        localStringBuffer1 = new StringBuffer();
      }
      else
      {
        String str = (String)paramMap.get(localStringBuffer1.substring(1));
        if (str == null)
        {
          AppMethodBeat.o(36773);
          return "";
        }
        localStringBuffer2.append(str);
        continue;
        if (localStringBuffer1.length() == 0) {
          localStringBuffer2.append(c);
        } else {
          localStringBuffer1.append(c);
        }
      }
    }
    label218:
    parama = localStringBuffer2.toString();
    AppMethodBeat.o(36773);
    return parama;
  }
  
  public final void a(int paramInt, String paramString, long paramLong, TimeLineObject paramTimeLineObject, boolean paramBoolean)
  {
    AppMethodBeat.i(36768);
    if ((paramBoolean) && (this.cqS))
    {
      if (this.rkF.contains(Long.valueOf(paramLong)))
      {
        paramBoolean = false;
        if (this.rkH.containsKey(Long.valueOf(paramLong))) {
          paramBoolean = ((Boolean)this.rkH.get(Long.valueOf(paramLong))).booleanValue();
        }
        if (paramBoolean)
        {
          paramString = (b.b)this.rkE.get(Long.valueOf(paramLong));
          if (paramString != null) {
            paramString.IE();
          }
        }
      }
      this.rkE.remove(Long.valueOf(paramLong));
      this.rkF.remove(Long.valueOf(paramLong));
    }
    AppMethodBeat.o(36768);
  }
  
  public final void a(int paramInt, String paramString, long paramLong, TimeLineObject paramTimeLineObject, boolean paramBoolean, bc parambc)
  {
    AppMethodBeat.i(36767);
    if ((paramBoolean) && (this.cqS) && (this.rkG != null) && (parambc != null))
    {
      this.rkF.add(Long.valueOf(paramLong));
      paramString = new b.b(paramLong, this.rkG.rkS, this.rkG.rkT, parambc.cwG());
      this.rkE.put(Long.valueOf(paramLong), paramString);
    }
    AppMethodBeat.o(36767);
  }
  
  final void a(View paramView, AbsoluteLayout paramAbsoluteLayout, com.tencent.mm.plugin.sns.data.b paramb)
  {
    AppMethodBeat.i(36772);
    Object localObject1 = (ViewGroup)paramView;
    ((ViewGroup)localObject1).removeAllViews();
    if (this.rkG == null)
    {
      AppMethodBeat.o(36772);
      return;
    }
    if ((paramb.rba == null) || (paramb.rba.scq == null))
    {
      AppMethodBeat.o(36772);
      return;
    }
    Object localObject2 = paramb.rba.scq;
    int i = 0;
    Object localObject3 = new Paint(1);
    int n = BackwardSupportUtil.b.b(this.mContext, 12.0F);
    int i1 = BackwardSupportUtil.b.b(this.mContext, 10.0F);
    int k = BackwardSupportUtil.b.b(this.mContext, 150.0F);
    LinkedList localLinkedList = new LinkedList();
    float f = BackwardSupportUtil.b.b(this.mContext, 17.0F) * com.tencent.mm.cb.a.dr(this.mContext) + i1 * 2;
    int m = (int)f;
    int j = 0;
    while (j < this.rkG.rlv.size())
    {
      Object localObject4 = (a)this.rkG.rlv.get(j);
      TextView localTextView = new TextView(this.mContext);
      localTextView.setPadding(n, i1, n, i1);
      localTextView.setTextSize(1, 14.0F * com.tencent.mm.cb.a.dr(this.mContext));
      localTextView.setTextColor(this.mContext.getResources().getColor(2131690474));
      localObject4 = a((a)localObject4, ((com.tencent.mm.plugin.sns.storage.b)localObject2).rqn);
      localTextView.setText((CharSequence)localObject4);
      ((Paint)localObject3).setTextSize(localTextView.getTextSize());
      ((ViewGroup)localObject1).addView(localTextView);
      i = Math.max(i, (int)((Paint)localObject3).measureText((String)localObject4) + n * 2);
      localTextView.setTag(Integer.valueOf(j));
      localLinkedList.add(localTextView);
      localTextView.setOnClickListener(new b.3(this, paramb, localTextView));
      j += 1;
    }
    ab.i("MicroMsg.AdNotLikeAbTestHelper", "w h " + i + " " + m);
    j = i;
    if (i < k) {
      j = k;
    }
    localObject1 = localLinkedList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (TextView)((Iterator)localObject1).next();
      localObject3 = ((TextView)localObject2).getLayoutParams();
      ((ViewGroup.LayoutParams)localObject3).width = j;
      ((ViewGroup.LayoutParams)localObject3).height = ((int)f);
      ((TextView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
    }
    new Rect();
    k = f.fK(this.mContext);
    localObject1 = paramb.rba.cwH();
    n = BackwardSupportUtil.b.b(this.mContext, 2.0F);
    i1 = localObject1[0];
    int i2 = localObject1[1];
    int i3 = this.qZo;
    paramb = paramb.rba;
    if (paramb.scm != null) {}
    for (i = paramb.scm.getHeight();; i = 0)
    {
      paramAbsoluteLayout.updateViewLayout(paramView, new AbsoluteLayout.LayoutParams(-2, -2, i1 - j - n, i2 - i3 - k + m - i));
      AppMethodBeat.o(36772);
      return;
    }
  }
  
  public final void a(b.b paramb)
  {
    AppMethodBeat.i(36769);
    this.rkD.remove(Long.valueOf(paramb.qYx));
    paramb.IE();
    AppMethodBeat.o(36769);
  }
  
  public final boolean cpX()
  {
    AppMethodBeat.i(36774);
    if (this.rku != null)
    {
      Object localObject;
      if ((this.rku.getTag() instanceof b.a))
      {
        localObject = (b.a)this.rku.getTag();
        localObject = (b.b)this.rkD.get(Long.valueOf(((b.a)localObject).cIo));
        if (localObject != null)
        {
          if (!((b.b)localObject).cpZ()) {
            break label111;
          }
          if (((b.b)localObject).cpY()) {
            ((b.b)localObject).aaZ("2:0:");
          }
          a((b.b)localObject);
        }
      }
      for (;;)
      {
        this.rkt.removeView(this.rku);
        this.rku = null;
        AppMethodBeat.o(36774);
        return true;
        label111:
        ((b.b)localObject).aaZ("2:0:");
        a((b.b)localObject);
      }
    }
    this.rkx = false;
    AppMethodBeat.o(36774);
    return false;
  }
  
  public final int dF(View paramView)
  {
    AppMethodBeat.i(36771);
    if (this.rkx)
    {
      AppMethodBeat.o(36771);
      return 0;
    }
    if (this.rku != null)
    {
      if ((this.rku.getTag() instanceof b.a))
      {
        paramView = ((b.a)this.rku.getTag()).qYp;
        this.rkx = true;
        paramView.startAnimation(this.rkw);
        this.rkw.setAnimationListener(new b.5(this, paramView));
      }
      for (;;)
      {
        AppMethodBeat.o(36771);
        return 0;
        cpX();
      }
    }
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof com.tencent.mm.plugin.sns.data.b)))
    {
      AppMethodBeat.o(36771);
      return 0;
    }
    if ((!this.cqS) || (this.rkG == null))
    {
      AppMethodBeat.o(36771);
      return 2;
    }
    Object localObject1 = (com.tencent.mm.plugin.sns.data.b)paramView.getTag();
    long l = ((com.tencent.mm.plugin.sns.data.b)localObject1).cIo;
    Object localObject2 = ((com.tencent.mm.plugin.sns.data.b)localObject1).rba.scq;
    boolean bool;
    if (this.rkH.containsKey(Long.valueOf(l))) {
      bool = ((Boolean)this.rkH.get(Long.valueOf(l))).booleanValue();
    }
    while (!bool)
    {
      AppMethodBeat.o(36771);
      return 2;
      if (this.rkG == null)
      {
        bool = false;
      }
      else if (localObject2 == null)
      {
        bool = false;
      }
      else
      {
        i = 0;
        for (;;)
        {
          if (i >= this.rkG.rlv.size()) {
            break label322;
          }
          if (bo.isNullOrNil(a((a)this.rkG.rlv.get(i), ((com.tencent.mm.plugin.sns.storage.b)localObject2).rqn)))
          {
            this.rkH.put(Long.valueOf(l), Boolean.FALSE);
            bool = false;
            break;
          }
          i += 1;
        }
        label322:
        this.rkH.put(Long.valueOf(l), Boolean.TRUE);
        bool = true;
      }
    }
    localObject2 = ((com.tencent.mm.plugin.sns.data.b)localObject1).crk;
    Object localObject3 = new b.b(((com.tencent.mm.plugin.sns.data.b)localObject1).cIo, ((com.tencent.mm.plugin.sns.data.b)localObject1).rba.cwG(), this.rkG.rkS, this.rkG.rkT, this.mContext.getString(2131303763));
    this.rkD.put(Long.valueOf(((com.tencent.mm.plugin.sns.data.b)localObject1).cIo), localObject3);
    if (this.rkF.contains(Long.valueOf(((com.tencent.mm.plugin.sns.data.b)localObject1).cIo))) {
      this.rkF.remove(Long.valueOf(((com.tencent.mm.plugin.sns.data.b)localObject1).cIo));
    }
    this.rku = new AbsoluteLayout(this.mContext);
    this.rku.setId(2131820735);
    new FrameLayout.LayoutParams(-1, -1);
    this.rkt.addView(this.rku);
    localObject3 = w.hM(this.mContext).inflate(2130968634, null);
    Object localObject4 = new TextView[3];
    ImageView[] arrayOfImageView = new ImageView[3];
    localObject4[0] = ((TextView)((View)localObject3).findViewById(2131821054));
    localObject4[1] = ((TextView)((View)localObject3).findViewById(2131821056));
    localObject4[2] = ((TextView)((View)localObject3).findViewById(2131821058));
    arrayOfImageView[0] = ((ImageView)((View)localObject3).findViewById(2131821055));
    arrayOfImageView[1] = ((ImageView)((View)localObject3).findViewById(2131821057));
    arrayOfImageView[2] = ((ImageView)((View)localObject3).findViewById(2131821059));
    int j = 0;
    int i = 0;
    if (!u.lF(((com.tencent.mm.plugin.sns.data.b)localObject1).cIo))
    {
      k = 0;
      for (;;)
      {
        j = i;
        if (k >= this.rkB.length) {
          break;
        }
        j = i;
        if (this.rkB[k] == 3) {
          j = i + 1;
        }
        k += 1;
        i = j;
      }
    }
    int k = 0;
    i = 0;
    while (i < this.rkB.length)
    {
      m = k;
      if (this.rkB[i] == 0) {
        m = k + 1;
      }
      i += 1;
      k = m;
    }
    if (k + j > 0)
    {
      i = this.rkB.length - k - j;
      if (i == 0)
      {
        AppMethodBeat.o(36771);
        return 2;
      }
    }
    for (this.rkC = new int[i];; this.rkC = new int[this.rkB.length])
    {
      i = 0;
      for (k = 0; i < this.rkB.length; k = m)
      {
        m = k;
        if (this.rkB[i] != 0) {
          if (j > 0)
          {
            m = k;
            if (this.rkB[i] == 3) {}
          }
          else
          {
            this.rkC[k] = this.rkB[i];
            m = k + 1;
          }
        }
        i += 1;
      }
    }
    if (u.lE(((com.tencent.mm.plugin.sns.data.b)localObject1).cIo))
    {
      i = 0;
      if (i < this.rkC.length)
      {
        if (this.rkC[i] != 3) {
          break label1130;
        }
        this.rkC[i] = 4;
      }
    }
    i = 0;
    int m = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 12);
    int n = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 8);
    int i1 = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 12);
    j = 0;
    label919:
    int i2;
    int i3;
    if (j < this.rkC.length)
    {
      i2 = this.rkC[j];
      i3 = this.rkC[j] - 1;
      localObject4[j].setText(this.rkA[i3]);
      Object localObject5 = localObject4[j];
      Paint localPaint = new Paint();
      String str = localObject5.getText().toString();
      localPaint.setTextSize(localObject5.getTextSize());
      k = (int)localPaint.measureText(str, 0, str.length()) + (m * 2 + n * 2 + i1);
      if (k <= i) {
        break label1446;
      }
      i = k;
    }
    label1446:
    for (;;)
    {
      localObject4[j].setCompoundDrawablePadding(com.tencent.mm.cb.a.fromDPToPix(this.mContext, 8));
      localObject4[j].setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(this.rkz[i3]), null, null, null);
      if (i3 == 1) {
        arrayOfImageView[j].setVisibility(0);
      }
      for (;;)
      {
        localObject4[j].setTag(localObject1);
        localObject4[j].setOnClickListener(new b.1(this, i2, (com.tencent.mm.plugin.sns.data.b)localObject1, (View)localObject3, paramView));
        j += 1;
        break label919;
        label1130:
        i += 1;
        break;
        arrayOfImageView[j].setVisibility(8);
      }
      j = 0;
      while (j < this.rkC.length)
      {
        localObject4[j].setMaxWidth(i);
        j += 1;
      }
      j = this.rkC.length;
      while (j < 3)
      {
        localObject4[j].setVisibility(8);
        j += 1;
      }
      new Rect();
      j = f.fK(this.mContext);
      localObject4 = ((com.tencent.mm.plugin.sns.data.b)localObject1).rba.cwH();
      ab.d("MicroMsg.AdNotLikeAbTestHelper", "addCommentView getLocationInWindow " + localObject4[0] + "  " + localObject4[1] + " height: " + j);
      i += com.tencent.mm.cb.a.fromDPToPix(this.mContext, 12);
      k = BackwardSupportUtil.b.b(this.mContext, 17.0F);
      m = BackwardSupportUtil.b.b(this.mContext, 2.0F);
      this.qZo = af.hT(this.mContext);
      localObject4 = new AbsoluteLayout.LayoutParams(i, -2, localObject4[0] - i - m, localObject4[1] - this.qZo - j + k);
      localObject1 = new b.a(this, (String)localObject2, (View)localObject3, ((com.tencent.mm.plugin.sns.data.b)localObject1).cIo, ((com.tencent.mm.plugin.sns.data.b)localObject1).rba.scq);
      this.rku.setTag(localObject1);
      this.rku.addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
      ((View)localObject3).setVisibility(8);
      this.rkx = true;
      new ak().post(new b.2(this, paramView, (View)localObject3));
      AppMethodBeat.o(36771);
      return 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.g.b
 * JD-Core Version:    0.7.0.1
 */