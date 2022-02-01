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
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.t;
import com.tencent.mm.plugin.sns.storage.f;
import com.tencent.mm.plugin.sns.storage.i;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.SnsCommentUI;
import com.tencent.mm.plugin.sns.ui.bn;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
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
  implements com.tencent.mm.plugin.sns.model.d
{
  private boolean doF;
  Context mContext;
  private int yYM;
  public final int zpc;
  private com.tencent.mm.plugin.sns.ui.d.c zpd;
  private FrameLayout zpe;
  AbsoluteLayout zpf;
  protected Animation zpg;
  protected Animation zph;
  boolean zpi;
  int[] zpj;
  private int[] zpk;
  private int[] zpl;
  private int[] zpm;
  private int[] zpn;
  Map<Long, b> zpo;
  private Map<Long, b> zpp;
  private HashSet<Long> zpq;
  h zpr;
  private HashMap<Long, Boolean> zps;
  
  public b(Context paramContext, com.tencent.mm.plugin.sns.ui.d.c paramc, FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(96098);
    this.zpc = 14;
    this.zpf = null;
    this.zpi = false;
    this.zpj = new int[] { 2131763731, 2131763732, 2131763733, 2131763734 };
    this.zpk = new int[] { 2131689540, 2131689542, 2131689541, 2131689539 };
    this.zpl = this.zpj;
    this.doF = true;
    this.zpo = new HashMap();
    this.zpp = new HashMap();
    this.zpq = new HashSet();
    this.zpr = null;
    this.zps = new HashMap();
    this.yYM = -1;
    g localg = ag.dTW();
    h localh2 = new h();
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.d.aDs().wz("100007");
    h localh1;
    if (!localc.isValid())
    {
      ad.i("MicroMsg.SnsABTestStrategy", "abtest is invalid");
      localh1 = null;
    }
    for (;;)
    {
      localg.zqq = localh1;
      this.zpr = ag.dTW().dVA();
      if (this.zpr != null)
      {
        this.zpm = this.zpr.zqs;
        if (!this.zpr.dVB()) {
          this.doF = false;
        }
      }
      this.mContext = paramContext;
      this.zpd = paramc;
      this.zpe = paramFrameLayout;
      this.zpg = new ScaleAnimation(1.0F, 1.0F, 0.0F, 1.0F, 1, 1.0F, 1, 0.0F);
      this.zpg = AnimationUtils.loadAnimation(paramContext, 2130772022);
      this.zph = new ScaleAnimation(1.0F, 1.0F, 1.0F, 0.0F, 1, 1.0F, 1, 0.0F);
      this.zph = AnimationUtils.loadAnimation(paramContext, 2130772023);
      AppMethodBeat.o(96098);
      return;
      Map localMap = localc.foF();
      localh1 = localh2;
      if (localMap != null)
      {
        ad.i("MicroMsg.SnsABTestStrategy", "snsabtest feed " + localc.field_expId + " " + localc.field_layerId + " " + localc.field_startTime + " " + localc.field_endTime);
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
    if (ac.fkp())
    {
      parama = parama.zoY;
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
      if (ac.fkq())
      {
        parama = parama.zoZ;
        break;
      }
      parama = parama.zpa;
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
    if ((paramBoolean) && (this.doF))
    {
      if (this.zpq.contains(Long.valueOf(paramLong)))
      {
        paramBoolean = false;
        if (this.zps.containsKey(Long.valueOf(paramLong))) {
          paramBoolean = ((Boolean)this.zps.get(Long.valueOf(paramLong))).booleanValue();
        }
        if (paramBoolean)
        {
          paramString = (b)this.zpp.get(Long.valueOf(paramLong));
          if (paramString != null) {
            paramString.report();
          }
        }
      }
      this.zpp.remove(Long.valueOf(paramLong));
      this.zpq.remove(Long.valueOf(paramLong));
    }
    AppMethodBeat.o(96096);
  }
  
  public final void a(int paramInt, String paramString, long paramLong, TimeLineObject paramTimeLineObject, boolean paramBoolean, bn parambn)
  {
    AppMethodBeat.i(96095);
    if ((paramBoolean) && (this.doF) && (this.zpr != null) && (parambn != null))
    {
      this.zpq.add(Long.valueOf(paramLong));
      paramString = new b(paramLong, this.zpr.zpD, this.zpr.zpE, parambn.edM());
      this.zpp.put(Long.valueOf(paramLong), paramString);
    }
    AppMethodBeat.o(96095);
  }
  
  final void a(View paramView, AbsoluteLayout paramAbsoluteLayout, final com.tencent.mm.plugin.sns.data.b paramb)
  {
    AppMethodBeat.i(96100);
    Object localObject1 = (ViewGroup)paramView;
    ((ViewGroup)localObject1).removeAllViews();
    if (this.zpr == null)
    {
      AppMethodBeat.o(96100);
      return;
    }
    if ((paramb.zcq == null) || (paramb.zcq.ApR == null))
    {
      AppMethodBeat.o(96100);
      return;
    }
    Object localObject2 = paramb.zcq.ApR;
    int i = 0;
    Object localObject3 = new Paint(1);
    int n = BackwardSupportUtil.b.g(this.mContext, 12.0F);
    int i1 = BackwardSupportUtil.b.g(this.mContext, 10.0F);
    int k = BackwardSupportUtil.b.g(this.mContext, 150.0F);
    LinkedList localLinkedList = new LinkedList();
    float f = BackwardSupportUtil.b.g(this.mContext, 17.0F) * com.tencent.mm.cc.a.eb(this.mContext) + i1 * 2;
    int m = (int)f;
    int j = 0;
    while (j < this.zpr.zqf.size())
    {
      Object localObject4 = (a)this.zpr.zqf.get(j);
      final TextView localTextView = new TextView(this.mContext);
      localTextView.setPadding(n, i1, n, i1);
      localTextView.setTextSize(1, 14.0F * com.tencent.mm.cc.a.eb(this.mContext));
      localTextView.setTextColor(this.mContext.getResources().getColor(2131100889));
      localObject4 = a((a)localObject4, ((com.tencent.mm.plugin.sns.storage.b)localObject2).zvU);
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
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/newabtest/AdNotLikeAbTestHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          int i = ((Integer)paramAnonymousView.getTag()).intValue();
          localObject = (b.b)b.this.zpo.get(Long.valueOf(paramb.dJc));
          int j = ((a)b.this.zpr.zqf.get(i)).zoX;
          if (localObject != null) {
            ((b.b)localObject).azy("3:" + j + ":" + localTextView.getText());
          }
          if (((a)b.this.zpr.zqf.get(i)).zpb == 1)
          {
            paramAnonymousView = new Intent();
            paramAnonymousView.setClass(b.this.mContext, SnsCommentUI.class);
            paramAnonymousView.putExtra("sns_comment_type", 2);
            paramAnonymousView.putExtra("sns_id", paramb.dJc);
            paramAnonymousView.putExtra("sns_uxinfo", ((b.b)localObject).dFy);
            paramAnonymousView.putExtra("action_st_time", ((b.b)localObject).zpB);
            paramAnonymousView.putExtra("sns_actionresult", ((b.b)localObject).zpA.toString());
            localObject = (MMActivity)b.this.mContext;
            paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.ahp(), "com/tencent/mm/plugin/sns/newabtest/AdNotLikeAbTestHelper$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((MMActivity)localObject).startActivity((Intent)paramAnonymousView.mq(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/sns/newabtest/AdNotLikeAbTestHelper$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            b.this.zpo.remove(Long.valueOf(paramb.dJc));
            b.this.dVw();
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/newabtest/AdNotLikeAbTestHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(96087);
            return;
            b.this.a((b.b)localObject);
            b.this.dVw();
          }
        }
      });
      j += 1;
    }
    ad.i("MicroMsg.AdNotLikeAbTestHelper", "w h " + i + " " + m);
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
    k = com.tencent.mm.pluginsdk.h.hm(this.mContext);
    localObject1 = paramb.zcq.edN();
    n = BackwardSupportUtil.b.g(this.mContext, 2.0F);
    i1 = localObject1[0];
    int i2 = localObject1[1];
    int i3 = this.yYM;
    paramb = paramb.zcq;
    if (paramb.ApN != null) {}
    for (i = paramb.ApN.getHeight();; i = 0)
    {
      paramAbsoluteLayout.updateViewLayout(paramView, new AbsoluteLayout.LayoutParams(-2, -2, i1 - j - n, i2 - i3 - k + m - i));
      AppMethodBeat.o(96100);
      return;
    }
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(96097);
    this.zpo.remove(Long.valueOf(paramb.yXT));
    paramb.report();
    AppMethodBeat.o(96097);
  }
  
  public final boolean dVw()
  {
    AppMethodBeat.i(96102);
    if (this.zpf != null)
    {
      Object localObject;
      if ((this.zpf.getTag() instanceof a))
      {
        localObject = (a)this.zpf.getTag();
        localObject = (b)this.zpo.get(Long.valueOf(((a)localObject).dJc));
        if (localObject != null)
        {
          if (!((b)localObject).dVy()) {
            break label111;
          }
          if (((b)localObject).dVx()) {
            ((b)localObject).azy("2:0:");
          }
          a((b)localObject);
        }
      }
      for (;;)
      {
        this.zpe.removeView(this.zpf);
        this.zpf = null;
        AppMethodBeat.o(96102);
        return true;
        label111:
        ((b)localObject).azy("2:0:");
        a((b)localObject);
      }
    }
    this.zpi = false;
    AppMethodBeat.o(96102);
    return false;
  }
  
  public final int eW(final View paramView)
  {
    AppMethodBeat.i(96099);
    if (this.zpi)
    {
      AppMethodBeat.o(96099);
      return 0;
    }
    if (this.zpf != null)
    {
      if ((this.zpf.getTag() instanceof a))
      {
        paramView = ((a)this.zpf.getTag()).yXL;
        this.zpi = true;
        paramView.startAnimation(this.zph);
        this.zph.setAnimationListener(new Animation.AnimationListener()
        {
          public final void onAnimationEnd(Animation paramAnonymousAnimation)
          {
            AppMethodBeat.i(96088);
            if (paramView != null)
            {
              paramView.clearAnimation();
              paramView.setVisibility(8);
              b.this.dVw();
            }
            b.this.zpi = false;
            AppMethodBeat.o(96088);
          }
          
          public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
          
          public final void onAnimationStart(Animation paramAnonymousAnimation)
          {
            b.this.zpi = true;
          }
        });
      }
      for (;;)
      {
        AppMethodBeat.o(96099);
        return 0;
        dVw();
      }
    }
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof com.tencent.mm.plugin.sns.data.b)))
    {
      AppMethodBeat.o(96099);
      return 0;
    }
    if ((!this.doF) || (this.zpr == null))
    {
      AppMethodBeat.o(96099);
      return 2;
    }
    Object localObject1 = (com.tencent.mm.plugin.sns.data.b)paramView.getTag();
    long l = ((com.tencent.mm.plugin.sns.data.b)localObject1).dJc;
    Object localObject2 = ((com.tencent.mm.plugin.sns.data.b)localObject1).zcq.ApR;
    boolean bool;
    if (this.zps.containsKey(Long.valueOf(l))) {
      bool = ((Boolean)this.zps.get(Long.valueOf(l))).booleanValue();
    }
    while (!bool)
    {
      AppMethodBeat.o(96099);
      return 2;
      if (this.zpr == null)
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
          if (i >= this.zpr.zqf.size()) {
            break label322;
          }
          if (bt.isNullOrNil(a((a)this.zpr.zqf.get(i), ((com.tencent.mm.plugin.sns.storage.b)localObject2).zvU)))
          {
            this.zps.put(Long.valueOf(l), Boolean.FALSE);
            bool = false;
            break;
          }
          i += 1;
        }
        label322:
        this.zps.put(Long.valueOf(l), Boolean.TRUE);
        bool = true;
      }
    }
    localObject2 = ((com.tencent.mm.plugin.sns.data.b)localObject1).doX;
    Object localObject3 = new b(((com.tencent.mm.plugin.sns.data.b)localObject1).dJc, ((com.tencent.mm.plugin.sns.data.b)localObject1).zcq.edM(), this.zpr.zpD, this.zpr.zpE, this.mContext.getString(2131763766));
    this.zpo.put(Long.valueOf(((com.tencent.mm.plugin.sns.data.b)localObject1).dJc), localObject3);
    if (this.zpq.contains(Long.valueOf(((com.tencent.mm.plugin.sns.data.b)localObject1).dJc))) {
      this.zpq.remove(Long.valueOf(((com.tencent.mm.plugin.sns.data.b)localObject1).dJc));
    }
    this.zpf = new AbsoluteLayout(this.mContext);
    this.zpf.setId(2131296470);
    new FrameLayout.LayoutParams(-1, -1);
    this.zpe.addView(this.zpf);
    localObject3 = z.jO(this.mContext).inflate(2131492942, null);
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
    if (!t.zK(((com.tencent.mm.plugin.sns.data.b)localObject1).dJc))
    {
      k = 0;
      for (;;)
      {
        j = i;
        if (k >= this.zpm.length) {
          break;
        }
        j = i;
        if (this.zpm[k] == 3) {
          j = i + 1;
        }
        k += 1;
        i = j;
      }
    }
    int k = 0;
    i = 0;
    while (i < this.zpm.length)
    {
      m = k;
      if (this.zpm[i] == 0) {
        m = k + 1;
      }
      i += 1;
      k = m;
    }
    if (k + j > 0)
    {
      i = this.zpm.length - k - j;
      if (i == 0)
      {
        AppMethodBeat.o(96099);
        return 2;
      }
    }
    for (this.zpn = new int[i];; this.zpn = new int[this.zpm.length])
    {
      i = 0;
      for (k = 0; i < this.zpm.length; k = m)
      {
        m = k;
        if (this.zpm[i] != 0) {
          if (j > 0)
          {
            m = k;
            if (this.zpm[i] == 3) {}
          }
          else
          {
            this.zpn[k] = this.zpm[i];
            m = k + 1;
          }
        }
        i += 1;
      }
    }
    if (t.zJ(((com.tencent.mm.plugin.sns.data.b)localObject1).dJc))
    {
      i = 0;
      if (i < this.zpn.length)
      {
        if (this.zpn[i] != 3) {
          break label1130;
        }
        this.zpn[i] = 4;
      }
    }
    i = 0;
    int m = com.tencent.mm.cc.a.fromDPToPix(this.mContext, 12);
    int n = com.tencent.mm.cc.a.fromDPToPix(this.mContext, 8);
    int i1 = com.tencent.mm.cc.a.fromDPToPix(this.mContext, 12);
    j = 0;
    label919:
    final int i2;
    int i3;
    if (j < this.zpn.length)
    {
      i2 = this.zpn[j];
      i3 = this.zpn[j] - 1;
      localObject4[j].setText(this.zpl[i3]);
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
      localObject4[j].setCompoundDrawablePadding(com.tencent.mm.cc.a.fromDPToPix(this.mContext, 8));
      localObject4[j].setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(this.zpk[i3]), null, null, null);
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
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/newabtest/AdNotLikeAbTestHelper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
            localObject1 = b.this;
            int j = i2;
            paramAnonymousView = this.zpu;
            Object localObject2 = this.zpv;
            AbsoluteLayout localAbsoluteLayout = b.this.zpf;
            ad.d("MicroMsg.AdNotLikeAbTestHelper", "processFristButtonClick " + j + " " + paramAnonymousView.dJc);
            b.b localb = (b.b)((b)localObject1).zpo.get(Long.valueOf(paramAnonymousView.dJc));
            if (localb != null) {
              if (j != 4) {
                break label469;
              }
            }
            label469:
            for (int i = 3;; i = j)
            {
              localb.azy("1:" + i + ":" + ((b)localObject1).mContext.getString(localObject1.zpj[(j - 1)]));
              if (j == 1)
              {
                localObject2 = ag.dUe().aAa(paramAnonymousView.doX);
                if (localObject2 != null)
                {
                  if (((p)localObject2).QM(32))
                  {
                    paramAnonymousView = ((p)localObject2).dRK();
                    if (paramAnonymousView != null) {
                      break label367;
                    }
                    paramAnonymousView = "";
                    ((com.tencent.mm.plugin.sns.b.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.sns.b.d.class)).a(11855, ((p)localObject2).dYV(), new Object[] { Integer.valueOf(3), paramAnonymousView, Integer.valueOf(((p)localObject2).dYV()) });
                  }
                  ag.dUh().delete(((p)localObject2).field_snsId);
                  ag.dUj().Ad(((p)localObject2).field_snsId);
                  i.Ac(((p)localObject2).field_snsId);
                  paramAnonymousView = new com.tencent.mm.plugin.sns.model.q(((p)localObject2).field_snsId, 8);
                  com.tencent.mm.kernel.g.ajD();
                  com.tencent.mm.kernel.g.ajB().gAO.a(paramAnonymousView, 0);
                  ((b)localObject1).a(localb);
                  ((b)localObject1).dVw();
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
                  if (!t.zJ(paramAnonymousView.dJc)) {
                    t.zH(paramAnonymousView.dJc);
                  }
                  ((b)localObject1).a(localb);
                  ((b)localObject1).dVw();
                }
                else if (j == 4)
                {
                  if (t.zJ(paramAnonymousView.dJc)) {
                    t.zI(paramAnonymousView.dJc);
                  }
                  ((b)localObject1).a(localb);
                  ((b)localObject1).dVw();
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
      while (j < this.zpn.length)
      {
        localObject4[j].setMaxWidth(i);
        j += 1;
      }
      j = this.zpn.length;
      while (j < 3)
      {
        localObject4[j].setVisibility(8);
        j += 1;
      }
      new Rect();
      j = com.tencent.mm.pluginsdk.h.hm(this.mContext);
      localObject4 = ((com.tencent.mm.plugin.sns.data.b)localObject1).zcq.edN();
      ad.d("MicroMsg.AdNotLikeAbTestHelper", "addCommentView getLocationInWindow " + localObject4[0] + "  " + localObject4[1] + " height: " + j);
      i += com.tencent.mm.cc.a.fromDPToPix(this.mContext, 12);
      k = BackwardSupportUtil.b.g(this.mContext, 17.0F);
      m = BackwardSupportUtil.b.g(this.mContext, 2.0F);
      this.yYM = al.jH(this.mContext);
      localObject4 = new AbsoluteLayout.LayoutParams(i, -2, localObject4[0] - i - m, localObject4[1] - this.yYM - j + k);
      localObject1 = new a((String)localObject2, (View)localObject3, ((com.tencent.mm.plugin.sns.data.b)localObject1).dJc, ((com.tencent.mm.plugin.sns.data.b)localObject1).zcq.ApR);
      this.zpf.setTag(localObject1);
      this.zpf.addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
      ((View)localObject3).setVisibility(8);
      this.zpi = true;
      new ap().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(96086);
          b.a(b.this, paramView, this.zpv);
          AppMethodBeat.o(96086);
        }
      });
      AppMethodBeat.o(96099);
      return 1;
    }
  }
  
  final class a
  {
    long dJc;
    View yXL = null;
    String zpy;
    com.tencent.mm.plugin.sns.storage.b zpz;
    
    public a(String paramString, View paramView, long paramLong, com.tencent.mm.plugin.sns.storage.b paramb)
    {
      this.zpy = paramString;
      this.yXL = paramView;
      this.zpz = paramb;
      this.dJc = paramLong;
    }
  }
  
  static final class b
  {
    String dFy;
    long yXT;
    StringBuffer zpA;
    long zpB;
    long zpC;
    String zpD;
    String zpE;
    
    public b(long paramLong, String paramString1, String paramString2, String paramString3)
    {
      AppMethodBeat.i(96090);
      this.zpA = new StringBuffer();
      this.dFy = paramString1;
      this.zpD = paramString2;
      this.zpE = paramString3;
      this.yXT = paramLong;
      this.zpB = System.currentTimeMillis();
      this.zpA.append("0:0:");
      AppMethodBeat.o(96090);
    }
    
    public b(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4)
    {
      AppMethodBeat.i(96089);
      this.zpA = new StringBuffer();
      this.dFy = paramString1;
      this.zpD = paramString2;
      this.zpE = paramString3;
      this.yXT = paramLong;
      this.zpB = System.currentTimeMillis();
      this.zpA.append("1:0:".concat(String.valueOf(paramString4)));
      AppMethodBeat.o(96089);
    }
    
    public final void azy(String paramString)
    {
      AppMethodBeat.i(96091);
      ad.d("MicroMsg.AdNotLikeAbTestHelper", "addactionResult ".concat(String.valueOf(paramString)));
      if (this.zpA.length() != 0) {
        this.zpA.append("|");
      }
      this.zpA.append(paramString);
      AppMethodBeat.o(96091);
    }
    
    public final boolean dVx()
    {
      AppMethodBeat.i(96092);
      if ((this.zpA == null) || (this.zpA.length() == 0))
      {
        AppMethodBeat.o(96092);
        return false;
      }
      if (this.zpA.toString().startsWith("1:0"))
      {
        AppMethodBeat.o(96092);
        return true;
      }
      AppMethodBeat.o(96092);
      return false;
    }
    
    public final boolean dVy()
    {
      AppMethodBeat.i(96093);
      if ((this.zpA == null) || (this.zpA.length() == 0))
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
      this.zpC = System.currentTimeMillis();
      ad.d("MicroMsg.AdNotLikeAbTestHelper", "report abtestnotlike " + this.yXT + " uxinfo:" + this.dFy + " actionresult: " + this.zpA + " " + this.zpB + " " + this.zpC);
      com.tencent.mm.plugin.report.service.g.yhR.f(11988, new Object[] { this.zpE, this.zpD, "", "", com.tencent.mm.plugin.sns.data.q.zw(this.yXT), this.dFy, this.zpA, Long.valueOf(this.zpB / 1000L), Long.valueOf(this.zpC / 1000L) });
      AppMethodBeat.o(96094);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.h.b
 * JD-Core Version:    0.7.0.1
 */