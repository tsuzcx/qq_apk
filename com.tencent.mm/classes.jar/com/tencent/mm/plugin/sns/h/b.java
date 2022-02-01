package com.tencent.mm.plugin.sns.h;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.AbsoluteLayout;
import android.widget.AbsoluteLayout.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.e;
import com.tencent.mm.plugin.sns.model.u;
import com.tencent.mm.plugin.sns.storage.f;
import com.tencent.mm.plugin.sns.storage.i;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.SnsCommentUI;
import com.tencent.mm.plugin.sns.ui.bn;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.z;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class b
  implements e
{
  private boolean dpK;
  Context mContext;
  private int[] zGA;
  private int[] zGB;
  private int[] zGC;
  Map<Long, b> zGD;
  private Map<Long, b> zGE;
  private HashSet<Long> zGF;
  h zGG;
  private HashMap<Long, Boolean> zGH;
  public final int zGr;
  private com.tencent.mm.plugin.sns.ui.d.c zGs;
  private FrameLayout zGt;
  AbsoluteLayout zGu;
  protected Animation zGv;
  protected Animation zGw;
  boolean zGx;
  int[] zGy;
  private int[] zGz;
  private int zpn;
  
  public b(Context paramContext, com.tencent.mm.plugin.sns.ui.d.c paramc, FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(96098);
    this.zGr = 14;
    this.zGu = null;
    this.zGx = false;
    this.zGy = new int[] { 2131763731, 2131763732, 2131763733, 2131763734 };
    this.zGz = new int[] { 2131689540, 2131689542, 2131689541, 2131689539 };
    this.zGA = this.zGy;
    this.dpK = true;
    this.zGD = new HashMap();
    this.zGE = new HashMap();
    this.zGF = new HashSet();
    this.zGG = null;
    this.zGH = new HashMap();
    this.zpn = -1;
    g localg = ah.dXw();
    h localh2 = new h();
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.d.aDI().xi("100007");
    h localh1;
    if (!localc.isValid())
    {
      ae.i("MicroMsg.SnsABTestStrategy", "abtest is invalid");
      localh1 = null;
    }
    for (;;)
    {
      localg.zHF = localh1;
      this.zGG = ah.dXw().dZb();
      if (this.zGG != null)
      {
        this.zGB = this.zGG.zHH;
        if (!this.zGG.dZc()) {
          this.dpK = false;
        }
      }
      this.mContext = paramContext;
      this.zGs = paramc;
      this.zGt = paramFrameLayout;
      this.zGv = new ScaleAnimation(1.0F, 1.0F, 0.0F, 1.0F, 1, 1.0F, 1, 0.0F);
      this.zGv = AnimationUtils.loadAnimation(paramContext, 2130772022);
      this.zGw = new ScaleAnimation(1.0F, 1.0F, 1.0F, 0.0F, 1, 1.0F, 1, 0.0F);
      this.zGw = AnimationUtils.loadAnimation(paramContext, 2130772023);
      AppMethodBeat.o(96098);
      return;
      Map localMap = localc.fsy();
      localh1 = localh2;
      if (localMap != null)
      {
        ae.i("MicroMsg.SnsABTestStrategy", "snsabtest feed " + localc.field_expId + " " + localc.field_layerId + " " + localc.field_startTime + " " + localc.field_endTime);
        localh2.h(localc.field_layerId, localc.field_expId, localMap);
        localh1 = localh2;
      }
    }
  }
  
  private static String a(a parama, Map<String, String> paramMap)
  {
    AppMethodBeat.i(96101);
    if (parama == null)
    {
      AppMethodBeat.o(96101);
      return "";
    }
    StringBuffer localStringBuffer2;
    StringBuffer localStringBuffer1;
    int i;
    label48:
    char c;
    if (ad.foj())
    {
      parama = parama.zGn;
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
      if (ad.fok())
      {
        parama = parama.zGo;
        break;
      }
      parama = parama.zGp;
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
          AppMethodBeat.o(96101);
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
    AppMethodBeat.o(96101);
    return parama;
  }
  
  public final void a(int paramInt, String paramString, long paramLong, TimeLineObject paramTimeLineObject, boolean paramBoolean)
  {
    AppMethodBeat.i(96096);
    if ((paramBoolean) && (this.dpK))
    {
      if (this.zGF.contains(Long.valueOf(paramLong)))
      {
        paramBoolean = false;
        if (this.zGH.containsKey(Long.valueOf(paramLong))) {
          paramBoolean = ((Boolean)this.zGH.get(Long.valueOf(paramLong))).booleanValue();
        }
        if (paramBoolean)
        {
          paramString = (b)this.zGE.get(Long.valueOf(paramLong));
          if (paramString != null) {
            paramString.report();
          }
        }
      }
      this.zGE.remove(Long.valueOf(paramLong));
      this.zGF.remove(Long.valueOf(paramLong));
    }
    AppMethodBeat.o(96096);
  }
  
  public final void a(int paramInt, String paramString, long paramLong, TimeLineObject paramTimeLineObject, boolean paramBoolean, bn parambn)
  {
    AppMethodBeat.i(96095);
    if ((paramBoolean) && (this.dpK) && (this.zGG != null) && (parambn != null))
    {
      this.zGF.add(Long.valueOf(paramLong));
      paramString = new b(paramLong, this.zGG.zGS, this.zGG.zGT, parambn.eht());
      this.zGE.put(Long.valueOf(paramLong), paramString);
    }
    AppMethodBeat.o(96095);
  }
  
  final void a(View paramView, AbsoluteLayout paramAbsoluteLayout, final com.tencent.mm.plugin.sns.data.b paramb)
  {
    AppMethodBeat.i(96100);
    Object localObject1 = (ViewGroup)paramView;
    ((ViewGroup)localObject1).removeAllViews();
    if (this.zGG == null)
    {
      AppMethodBeat.o(96100);
      return;
    }
    if ((paramb.ztd == null) || (paramb.ztd.AHh == null))
    {
      AppMethodBeat.o(96100);
      return;
    }
    Object localObject2 = paramb.ztd.AHh;
    int i = 0;
    Object localObject3 = new Paint(1);
    int n = BackwardSupportUtil.b.h(this.mContext, 12.0F);
    int i1 = BackwardSupportUtil.b.h(this.mContext, 10.0F);
    int k = BackwardSupportUtil.b.h(this.mContext, 150.0F);
    LinkedList localLinkedList = new LinkedList();
    float f = BackwardSupportUtil.b.h(this.mContext, 17.0F) * com.tencent.mm.cb.a.ef(this.mContext) + i1 * 2;
    int m = (int)f;
    int j = 0;
    while (j < this.zGG.zHu.size())
    {
      Object localObject4 = (a)this.zGG.zHu.get(j);
      final TextView localTextView = new TextView(this.mContext);
      localTextView.setPadding(n, i1, n, i1);
      localTextView.setTextSize(1, 14.0F * com.tencent.mm.cb.a.ef(this.mContext));
      localTextView.setTextColor(this.mContext.getResources().getColor(2131100889));
      localObject4 = a((a)localObject4, ((com.tencent.mm.plugin.sns.storage.b)localObject2).zNp);
      localTextView.setText((CharSequence)localObject4);
      ((Paint)localObject3).setTextSize(localTextView.getTextSize());
      ((ViewGroup)localObject1).addView(localTextView);
      i = Math.max(i, (int)((Paint)localObject3).measureText((String)localObject4) + n * 2);
      localTextView.setTag(Integer.valueOf(j));
      localLinkedList.add(localTextView);
      localTextView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(96087);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/newabtest/AdNotLikeAbTestHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          int i = ((Integer)paramAnonymousView.getTag()).intValue();
          localObject = (b.b)b.this.zGD.get(Long.valueOf(paramb.dKq));
          int j = ((a)b.this.zGG.zHu.get(i)).zGm;
          if (localObject != null) {
            ((b.b)localObject).aAP("3:" + j + ":" + localTextView.getText());
          }
          if (((a)b.this.zGG.zHu.get(i)).zGq == 1)
          {
            paramAnonymousView = new Intent();
            paramAnonymousView.setClass(b.this.mContext, SnsCommentUI.class);
            paramAnonymousView.putExtra("sns_comment_type", 2);
            paramAnonymousView.putExtra("sns_id", paramb.dKq);
            paramAnonymousView.putExtra("sns_uxinfo", ((b.b)localObject).dGD);
            paramAnonymousView.putExtra("action_st_time", ((b.b)localObject).zGQ);
            paramAnonymousView.putExtra("sns_actionresult", ((b.b)localObject).zGP.toString());
            localObject = (MMActivity)b.this.mContext;
            paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.ahE(), "com/tencent/mm/plugin/sns/newabtest/AdNotLikeAbTestHelper$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((MMActivity)localObject).startActivity((Intent)paramAnonymousView.mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/sns/newabtest/AdNotLikeAbTestHelper$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            b.this.zGD.remove(Long.valueOf(paramb.dKq));
            b.this.dYX();
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/newabtest/AdNotLikeAbTestHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(96087);
            return;
            b.this.a((b.b)localObject);
            b.this.dYX();
          }
        }
      });
      j += 1;
    }
    ae.i("MicroMsg.AdNotLikeAbTestHelper", "w h " + i + " " + m);
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
    k = com.tencent.mm.pluginsdk.h.hs(this.mContext);
    localObject1 = paramb.ztd.ehu();
    n = BackwardSupportUtil.b.h(this.mContext, 2.0F);
    i1 = localObject1[0];
    int i2 = localObject1[1];
    int i3 = this.zpn;
    paramb = paramb.ztd;
    if (paramb.AHa != null) {}
    for (i = paramb.AHa.getHeight();; i = 0)
    {
      paramAbsoluteLayout.updateViewLayout(paramView, new AbsoluteLayout.LayoutParams(-2, -2, i1 - j - n, i2 - i3 - k + m - i));
      AppMethodBeat.o(96100);
      return;
    }
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(96097);
    this.zGD.remove(Long.valueOf(paramb.zou));
    paramb.report();
    AppMethodBeat.o(96097);
  }
  
  public final boolean dYX()
  {
    AppMethodBeat.i(96102);
    if (this.zGu != null)
    {
      Object localObject;
      if ((this.zGu.getTag() instanceof a))
      {
        localObject = (a)this.zGu.getTag();
        localObject = (b)this.zGD.get(Long.valueOf(((a)localObject).dKq));
        if (localObject != null)
        {
          if (!((b)localObject).dYZ()) {
            break label111;
          }
          if (((b)localObject).dYY()) {
            ((b)localObject).aAP("2:0:");
          }
          a((b)localObject);
        }
      }
      for (;;)
      {
        this.zGt.removeView(this.zGu);
        this.zGu = null;
        AppMethodBeat.o(96102);
        return true;
        label111:
        ((b)localObject).aAP("2:0:");
        a((b)localObject);
      }
    }
    this.zGx = false;
    AppMethodBeat.o(96102);
    return false;
  }
  
  public final int eV(final View paramView)
  {
    AppMethodBeat.i(96099);
    if (this.zGx)
    {
      AppMethodBeat.o(96099);
      return 0;
    }
    if (this.zGu != null)
    {
      if ((this.zGu.getTag() instanceof a))
      {
        paramView = ((a)this.zGu.getTag()).zom;
        this.zGx = true;
        paramView.startAnimation(this.zGw);
        this.zGw.setAnimationListener(new Animation.AnimationListener()
        {
          public final void onAnimationEnd(Animation paramAnonymousAnimation)
          {
            AppMethodBeat.i(96088);
            if (paramView != null)
            {
              paramView.clearAnimation();
              paramView.setVisibility(8);
              b.this.dYX();
            }
            b.this.zGx = false;
            AppMethodBeat.o(96088);
          }
          
          public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
          
          public final void onAnimationStart(Animation paramAnonymousAnimation)
          {
            b.this.zGx = true;
          }
        });
      }
      for (;;)
      {
        AppMethodBeat.o(96099);
        return 0;
        dYX();
      }
    }
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof com.tencent.mm.plugin.sns.data.b)))
    {
      AppMethodBeat.o(96099);
      return 0;
    }
    if ((!this.dpK) || (this.zGG == null))
    {
      AppMethodBeat.o(96099);
      return 2;
    }
    Object localObject1 = (com.tencent.mm.plugin.sns.data.b)paramView.getTag();
    long l = ((com.tencent.mm.plugin.sns.data.b)localObject1).dKq;
    Object localObject2 = ((com.tencent.mm.plugin.sns.data.b)localObject1).ztd.AHh;
    boolean bool;
    if (this.zGH.containsKey(Long.valueOf(l))) {
      bool = ((Boolean)this.zGH.get(Long.valueOf(l))).booleanValue();
    }
    while (!bool)
    {
      AppMethodBeat.o(96099);
      return 2;
      if (this.zGG == null)
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
          if (i >= this.zGG.zHu.size()) {
            break label322;
          }
          if (bu.isNullOrNil(a((a)this.zGG.zHu.get(i), ((com.tencent.mm.plugin.sns.storage.b)localObject2).zNp)))
          {
            this.zGH.put(Long.valueOf(l), Boolean.FALSE);
            bool = false;
            break;
          }
          i += 1;
        }
        label322:
        this.zGH.put(Long.valueOf(l), Boolean.TRUE);
        bool = true;
      }
    }
    localObject2 = ((com.tencent.mm.plugin.sns.data.b)localObject1).dqc;
    Object localObject3 = new b(((com.tencent.mm.plugin.sns.data.b)localObject1).dKq, ((com.tencent.mm.plugin.sns.data.b)localObject1).ztd.eht(), this.zGG.zGS, this.zGG.zGT, this.mContext.getString(2131763766));
    this.zGD.put(Long.valueOf(((com.tencent.mm.plugin.sns.data.b)localObject1).dKq), localObject3);
    if (this.zGF.contains(Long.valueOf(((com.tencent.mm.plugin.sns.data.b)localObject1).dKq))) {
      this.zGF.remove(Long.valueOf(((com.tencent.mm.plugin.sns.data.b)localObject1).dKq));
    }
    this.zGu = new AbsoluteLayout(this.mContext);
    this.zGu.setId(2131296470);
    new FrameLayout.LayoutParams(-1, -1);
    this.zGt.addView(this.zGu);
    localObject3 = z.jV(this.mContext).inflate(2131492942, null);
    Object localObject4 = new TextView[3];
    ImageView[] arrayOfImageView = new ImageView[3];
    localObject4[0] = ((TextView)((View)localObject3).findViewById(2131296436));
    localObject4[1] = ((TextView)((View)localObject3).findViewById(2131296441));
    localObject4[2] = ((TextView)((View)localObject3).findViewById(2131296440));
    arrayOfImageView[0] = ((ImageView)((View)localObject3).findViewById(2131296437));
    arrayOfImageView[1] = ((ImageView)((View)localObject3).findViewById(2131296439));
    arrayOfImageView[2] = ((ImageView)((View)localObject3).findViewById(2131296438));
    int j = 0;
    int i = 0;
    if (!u.Ai(((com.tencent.mm.plugin.sns.data.b)localObject1).dKq))
    {
      k = 0;
      for (;;)
      {
        j = i;
        if (k >= this.zGB.length) {
          break;
        }
        j = i;
        if (this.zGB[k] == 3) {
          j = i + 1;
        }
        k += 1;
        i = j;
      }
    }
    int k = 0;
    i = 0;
    while (i < this.zGB.length)
    {
      m = k;
      if (this.zGB[i] == 0) {
        m = k + 1;
      }
      i += 1;
      k = m;
    }
    if (k + j > 0)
    {
      i = this.zGB.length - k - j;
      if (i == 0)
      {
        AppMethodBeat.o(96099);
        return 2;
      }
    }
    for (this.zGC = new int[i];; this.zGC = new int[this.zGB.length])
    {
      i = 0;
      for (k = 0; i < this.zGB.length; k = m)
      {
        m = k;
        if (this.zGB[i] != 0) {
          if (j > 0)
          {
            m = k;
            if (this.zGB[i] == 3) {}
          }
          else
          {
            this.zGC[k] = this.zGB[i];
            m = k + 1;
          }
        }
        i += 1;
      }
    }
    if (u.Ah(((com.tencent.mm.plugin.sns.data.b)localObject1).dKq))
    {
      i = 0;
      if (i < this.zGC.length)
      {
        if (this.zGC[i] != 3) {
          break label1130;
        }
        this.zGC[i] = 4;
      }
    }
    i = 0;
    int m = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 12);
    int n = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 8);
    int i1 = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 12);
    j = 0;
    label919:
    final int i2;
    int i3;
    if (j < this.zGC.length)
    {
      i2 = this.zGC[j];
      i3 = this.zGC[j] - 1;
      localObject4[j].setText(this.zGA[i3]);
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
      localObject4[j].setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(this.zGz[i3]), null, null, null);
      if (i3 == 1) {
        arrayOfImageView[j].setVisibility(0);
      }
      for (;;)
      {
        localObject4[j].setTag(localObject1);
        localObject4[j].setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(96085);
            Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/newabtest/AdNotLikeAbTestHelper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
            localObject1 = b.this;
            int j = i2;
            paramAnonymousView = this.zGJ;
            Object localObject2 = this.zGK;
            AbsoluteLayout localAbsoluteLayout = b.this.zGu;
            ae.d("MicroMsg.AdNotLikeAbTestHelper", "processFristButtonClick " + j + " " + paramAnonymousView.dKq);
            b.b localb = (b.b)((b)localObject1).zGD.get(Long.valueOf(paramAnonymousView.dKq));
            if (localb != null) {
              if (j != 4) {
                break label469;
              }
            }
            label469:
            for (int i = 3;; i = j)
            {
              localb.aAP("1:" + i + ":" + ((b)localObject1).mContext.getString(localObject1.zGy[(j - 1)]));
              if (j == 1)
              {
                localObject2 = ah.dXE().aBr(paramAnonymousView.dqc);
                if (localObject2 != null)
                {
                  if (((p)localObject2).Rt(32))
                  {
                    paramAnonymousView = ((p)localObject2).dVi();
                    if (paramAnonymousView != null) {
                      break label367;
                    }
                    paramAnonymousView = "";
                    ((com.tencent.mm.plugin.sns.b.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.sns.b.d.class)).a(11855, ((p)localObject2).ecz(), new Object[] { Integer.valueOf(3), paramAnonymousView, Integer.valueOf(((p)localObject2).ecz()) });
                  }
                  ah.dXH().delete(((p)localObject2).field_snsId);
                  ah.dXJ().AB(((p)localObject2).field_snsId);
                  i.AA(((p)localObject2).field_snsId);
                  paramAnonymousView = new com.tencent.mm.plugin.sns.model.r(((p)localObject2).field_snsId, 8);
                  com.tencent.mm.kernel.g.ajS();
                  com.tencent.mm.kernel.g.ajQ().gDv.a(paramAnonymousView, 0);
                  ((b)localObject1).a(localb);
                  ((b)localObject1).dYX();
                }
              }
              for (;;)
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/newabtest/AdNotLikeAbTestHelper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(96085);
                return;
                label367:
                paramAnonymousView = paramAnonymousView.aQj;
                break;
                if (j == 2)
                {
                  ((b)localObject1).a((View)localObject2, localAbsoluteLayout, paramAnonymousView);
                }
                else if (j == 3)
                {
                  if (!u.Ah(paramAnonymousView.dKq)) {
                    u.Af(paramAnonymousView.dKq);
                  }
                  ((b)localObject1).a(localb);
                  ((b)localObject1).dYX();
                }
                else if (j == 4)
                {
                  if (u.Ah(paramAnonymousView.dKq)) {
                    u.Ag(paramAnonymousView.dKq);
                  }
                  ((b)localObject1).a(localb);
                  ((b)localObject1).dYX();
                }
              }
            }
          }
        });
        j += 1;
        break label919;
        label1130:
        i += 1;
        break;
        arrayOfImageView[j].setVisibility(8);
      }
      j = 0;
      while (j < this.zGC.length)
      {
        localObject4[j].setMaxWidth(i);
        j += 1;
      }
      j = this.zGC.length;
      while (j < 3)
      {
        localObject4[j].setVisibility(8);
        j += 1;
      }
      new Rect();
      j = com.tencent.mm.pluginsdk.h.hs(this.mContext);
      localObject4 = ((com.tencent.mm.plugin.sns.data.b)localObject1).ztd.ehu();
      ae.d("MicroMsg.AdNotLikeAbTestHelper", "addCommentView getLocationInWindow " + localObject4[0] + "  " + localObject4[1] + " height: " + j);
      i += com.tencent.mm.cb.a.fromDPToPix(this.mContext, 12);
      k = BackwardSupportUtil.b.h(this.mContext, 17.0F);
      m = BackwardSupportUtil.b.h(this.mContext, 2.0F);
      this.zpn = al.jO(this.mContext);
      localObject4 = new AbsoluteLayout.LayoutParams(i, -2, localObject4[0] - i - m, localObject4[1] - this.zpn - j + k);
      localObject1 = new a((String)localObject2, (View)localObject3, ((com.tencent.mm.plugin.sns.data.b)localObject1).dKq, ((com.tencent.mm.plugin.sns.data.b)localObject1).ztd.AHh);
      this.zGu.setTag(localObject1);
      this.zGu.addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
      ((View)localObject3).setVisibility(8);
      this.zGx = true;
      new aq().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(96086);
          b.a(b.this, paramView, this.zGK);
          AppMethodBeat.o(96086);
        }
      });
      AppMethodBeat.o(96099);
      return 1;
    }
  }
  
  final class a
  {
    long dKq;
    String zGN;
    com.tencent.mm.plugin.sns.storage.b zGO;
    View zom = null;
    
    public a(String paramString, View paramView, long paramLong, com.tencent.mm.plugin.sns.storage.b paramb)
    {
      this.zGN = paramString;
      this.zom = paramView;
      this.zGO = paramb;
      this.dKq = paramLong;
    }
  }
  
  static final class b
  {
    String dGD;
    StringBuffer zGP;
    long zGQ;
    long zGR;
    String zGS;
    String zGT;
    long zou;
    
    public b(long paramLong, String paramString1, String paramString2, String paramString3)
    {
      AppMethodBeat.i(96090);
      this.zGP = new StringBuffer();
      this.dGD = paramString1;
      this.zGS = paramString2;
      this.zGT = paramString3;
      this.zou = paramLong;
      this.zGQ = System.currentTimeMillis();
      this.zGP.append("0:0:");
      AppMethodBeat.o(96090);
    }
    
    public b(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4)
    {
      AppMethodBeat.i(96089);
      this.zGP = new StringBuffer();
      this.dGD = paramString1;
      this.zGS = paramString2;
      this.zGT = paramString3;
      this.zou = paramLong;
      this.zGQ = System.currentTimeMillis();
      this.zGP.append("1:0:".concat(String.valueOf(paramString4)));
      AppMethodBeat.o(96089);
    }
    
    public final void aAP(String paramString)
    {
      AppMethodBeat.i(96091);
      ae.d("MicroMsg.AdNotLikeAbTestHelper", "addactionResult ".concat(String.valueOf(paramString)));
      if (this.zGP.length() != 0) {
        this.zGP.append("|");
      }
      this.zGP.append(paramString);
      AppMethodBeat.o(96091);
    }
    
    public final boolean dYY()
    {
      AppMethodBeat.i(96092);
      if ((this.zGP == null) || (this.zGP.length() == 0))
      {
        AppMethodBeat.o(96092);
        return false;
      }
      if (this.zGP.toString().startsWith("1:0"))
      {
        AppMethodBeat.o(96092);
        return true;
      }
      AppMethodBeat.o(96092);
      return false;
    }
    
    public final boolean dYZ()
    {
      AppMethodBeat.i(96093);
      if ((this.zGP == null) || (this.zGP.length() == 0))
      {
        AppMethodBeat.o(96093);
        return false;
      }
      AppMethodBeat.o(96093);
      return true;
    }
    
    public final void report()
    {
      AppMethodBeat.i(96094);
      this.zGR = System.currentTimeMillis();
      ae.d("MicroMsg.AdNotLikeAbTestHelper", "report abtestnotlike " + this.zou + " uxinfo:" + this.dGD + " actionresult: " + this.zGP + " " + this.zGQ + " " + this.zGR);
      com.tencent.mm.plugin.report.service.g.yxI.f(11988, new Object[] { this.zGT, this.zGS, "", "", com.tencent.mm.plugin.sns.data.r.zV(this.zou), this.dGD, this.zGP, Long.valueOf(this.zGQ / 1000L), Long.valueOf(this.zGR / 1000L) });
      AppMethodBeat.o(96094);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.h.b
 * JD-Core Version:    0.7.0.1
 */