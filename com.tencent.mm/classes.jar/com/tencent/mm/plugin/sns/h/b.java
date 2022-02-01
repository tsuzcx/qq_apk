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
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.t;
import com.tencent.mm.plugin.sns.storage.f;
import com.tencent.mm.plugin.sns.storage.i;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.SnsCommentUI;
import com.tencent.mm.plugin.sns.ui.bk;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aj;
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
  private boolean ddj;
  Context mContext;
  private int xJx;
  public final int xZd;
  private com.tencent.mm.plugin.sns.ui.d.b xZe;
  private FrameLayout xZf;
  AbsoluteLayout xZg;
  protected Animation xZh;
  protected Animation xZi;
  boolean xZj;
  int[] xZk;
  private int[] xZl;
  private int[] xZm;
  private int[] xZn;
  private int[] xZo;
  Map<Long, b> xZp;
  private Map<Long, b> xZq;
  private HashSet<Long> xZr;
  h xZs;
  private HashMap<Long, Boolean> xZt;
  
  public b(Context paramContext, com.tencent.mm.plugin.sns.ui.d.b paramb, FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(96098);
    this.xZd = 14;
    this.xZg = null;
    this.xZj = false;
    this.xZk = new int[] { 2131763731, 2131763732, 2131763733, 2131763734 };
    this.xZl = new int[] { 2131689540, 2131689542, 2131689541, 2131689539 };
    this.xZm = this.xZk;
    this.ddj = true;
    this.xZp = new HashMap();
    this.xZq = new HashMap();
    this.xZr = new HashSet();
    this.xZs = null;
    this.xZt = new HashMap();
    this.xJx = -1;
    g localg = af.dHJ();
    h localh2 = new h();
    c localc = com.tencent.mm.model.c.d.aAp().tJ("100007");
    h localh1;
    if (!localc.isValid())
    {
      ac.i("MicroMsg.SnsABTestStrategy", "abtest is invalid");
      localh1 = null;
    }
    for (;;)
    {
      localg.yas = localh1;
      this.xZs = af.dHJ().dJn();
      if (this.xZs != null)
      {
        this.xZn = this.xZs.yau;
        if (!this.xZs.dJo()) {
          this.ddj = false;
        }
      }
      this.mContext = paramContext;
      this.xZe = paramb;
      this.xZf = paramFrameLayout;
      this.xZh = new ScaleAnimation(1.0F, 1.0F, 0.0F, 1.0F, 1, 1.0F, 1, 0.0F);
      this.xZh = AnimationUtils.loadAnimation(paramContext, 2130772022);
      this.xZi = new ScaleAnimation(1.0F, 1.0F, 1.0F, 0.0F, 1, 1.0F, 1, 0.0F);
      this.xZi = AnimationUtils.loadAnimation(paramContext, 2130772023);
      AppMethodBeat.o(96098);
      return;
      Map localMap = localc.eYV();
      localh1 = localh2;
      if (localMap != null)
      {
        ac.i("MicroMsg.SnsABTestStrategy", "snsabtest feed " + localc.field_expId + " " + localc.field_layerId + " " + localc.field_startTime + " " + localc.field_endTime);
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
    if (ab.eUL())
    {
      parama = parama.xYZ;
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
      if (ab.eUM())
      {
        parama = parama.xZa;
        break;
      }
      parama = parama.xZb;
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
    if ((paramBoolean) && (this.ddj))
    {
      if (this.xZr.contains(Long.valueOf(paramLong)))
      {
        paramBoolean = false;
        if (this.xZt.containsKey(Long.valueOf(paramLong))) {
          paramBoolean = ((Boolean)this.xZt.get(Long.valueOf(paramLong))).booleanValue();
        }
        if (paramBoolean)
        {
          paramString = (b)this.xZq.get(Long.valueOf(paramLong));
          if (paramString != null) {
            paramString.report();
          }
        }
      }
      this.xZq.remove(Long.valueOf(paramLong));
      this.xZr.remove(Long.valueOf(paramLong));
    }
    AppMethodBeat.o(96096);
  }
  
  public final void a(int paramInt, String paramString, long paramLong, TimeLineObject paramTimeLineObject, boolean paramBoolean, bk parambk)
  {
    AppMethodBeat.i(96095);
    if ((paramBoolean) && (this.ddj) && (this.xZs != null) && (parambk != null))
    {
      this.xZr.add(Long.valueOf(paramLong));
      paramString = new b(paramLong, this.xZs.xZE, this.xZs.xZF, parambk.dRs());
      this.xZq.put(Long.valueOf(paramLong), paramString);
    }
    AppMethodBeat.o(96095);
  }
  
  final void a(View paramView, AbsoluteLayout paramAbsoluteLayout, final com.tencent.mm.plugin.sns.data.b paramb)
  {
    AppMethodBeat.i(96100);
    Object localObject1 = (ViewGroup)paramView;
    ((ViewGroup)localObject1).removeAllViews();
    if (this.xZs == null)
    {
      AppMethodBeat.o(96100);
      return;
    }
    if ((paramb.xMy == null) || (paramb.xMy.yYg == null))
    {
      AppMethodBeat.o(96100);
      return;
    }
    Object localObject2 = paramb.xMy.yYg;
    int i = 0;
    Object localObject3 = new Paint(1);
    int n = BackwardSupportUtil.b.g(this.mContext, 12.0F);
    int i1 = BackwardSupportUtil.b.g(this.mContext, 10.0F);
    int k = BackwardSupportUtil.b.g(this.mContext, 150.0F);
    LinkedList localLinkedList = new LinkedList();
    float f = BackwardSupportUtil.b.g(this.mContext, 17.0F) * com.tencent.mm.cc.a.eb(this.mContext) + i1 * 2;
    int m = (int)f;
    int j = 0;
    while (j < this.xZs.yah.size())
    {
      Object localObject4 = (a)this.xZs.yah.get(j);
      final TextView localTextView = new TextView(this.mContext);
      localTextView.setPadding(n, i1, n, i1);
      localTextView.setTextSize(1, 14.0F * com.tencent.mm.cc.a.eb(this.mContext));
      localTextView.setTextColor(this.mContext.getResources().getColor(2131100889));
      localObject4 = a((a)localObject4, ((com.tencent.mm.plugin.sns.storage.b)localObject2).yfS);
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
          int i = ((Integer)paramAnonymousView.getTag()).intValue();
          Object localObject = (b.b)b.this.xZp.get(Long.valueOf(paramb.dwQ));
          int j = ((a)b.this.xZs.yah.get(i)).xYY;
          if (localObject != null) {
            ((b.b)localObject).aus("3:" + j + ":" + localTextView.getText());
          }
          if (((a)b.this.xZs.yah.get(i)).xZc == 1)
          {
            paramAnonymousView = new Intent();
            paramAnonymousView.setClass(b.this.mContext, SnsCommentUI.class);
            paramAnonymousView.putExtra("sns_comment_type", 2);
            paramAnonymousView.putExtra("sns_id", paramb.dwQ);
            paramAnonymousView.putExtra("sns_uxinfo", ((b.b)localObject).dtx);
            paramAnonymousView.putExtra("action_st_time", ((b.b)localObject).xZC);
            paramAnonymousView.putExtra("sns_actionresult", ((b.b)localObject).xZB.toString());
            localObject = (MMActivity)b.this.mContext;
            paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().ba(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.aeD(), "com/tencent/mm/plugin/sns/newabtest/AdNotLikeAbTestHelper$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((MMActivity)localObject).startActivity((Intent)paramAnonymousView.lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/sns/newabtest/AdNotLikeAbTestHelper$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            b.this.xZp.remove(Long.valueOf(paramb.dwQ));
            b.this.dJj();
            AppMethodBeat.o(96087);
            return;
          }
          b.this.a((b.b)localObject);
          b.this.dJj();
          AppMethodBeat.o(96087);
        }
      });
      j += 1;
    }
    ac.i("MicroMsg.AdNotLikeAbTestHelper", "w h " + i + " " + m);
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
    k = com.tencent.mm.pluginsdk.g.hh(this.mContext);
    localObject1 = paramb.xMy.dRt();
    n = BackwardSupportUtil.b.g(this.mContext, 2.0F);
    i1 = localObject1[0];
    int i2 = localObject1[1];
    int i3 = this.xJx;
    paramb = paramb.xMy;
    if (paramb.yYc != null) {}
    for (i = paramb.yYc.getHeight();; i = 0)
    {
      paramAbsoluteLayout.updateViewLayout(paramView, new AbsoluteLayout.LayoutParams(-2, -2, i1 - j - n, i2 - i3 - k + m - i));
      AppMethodBeat.o(96100);
      return;
    }
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(96097);
    this.xZp.remove(Long.valueOf(paramb.xIE));
    paramb.report();
    AppMethodBeat.o(96097);
  }
  
  public final boolean dJj()
  {
    AppMethodBeat.i(96102);
    if (this.xZg != null)
    {
      Object localObject;
      if ((this.xZg.getTag() instanceof a))
      {
        localObject = (a)this.xZg.getTag();
        localObject = (b)this.xZp.get(Long.valueOf(((a)localObject).dwQ));
        if (localObject != null)
        {
          if (!((b)localObject).dJl()) {
            break label111;
          }
          if (((b)localObject).dJk()) {
            ((b)localObject).aus("2:0:");
          }
          a((b)localObject);
        }
      }
      for (;;)
      {
        this.xZf.removeView(this.xZg);
        this.xZg = null;
        AppMethodBeat.o(96102);
        return true;
        label111:
        ((b)localObject).aus("2:0:");
        a((b)localObject);
      }
    }
    this.xZj = false;
    AppMethodBeat.o(96102);
    return false;
  }
  
  public final int eG(final View paramView)
  {
    AppMethodBeat.i(96099);
    if (this.xZj)
    {
      AppMethodBeat.o(96099);
      return 0;
    }
    if (this.xZg != null)
    {
      if ((this.xZg.getTag() instanceof a))
      {
        paramView = ((a)this.xZg.getTag()).xIw;
        this.xZj = true;
        paramView.startAnimation(this.xZi);
        this.xZi.setAnimationListener(new Animation.AnimationListener()
        {
          public final void onAnimationEnd(Animation paramAnonymousAnimation)
          {
            AppMethodBeat.i(96088);
            if (paramView != null)
            {
              paramView.clearAnimation();
              paramView.setVisibility(8);
              b.this.dJj();
            }
            b.this.xZj = false;
            AppMethodBeat.o(96088);
          }
          
          public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
          
          public final void onAnimationStart(Animation paramAnonymousAnimation)
          {
            b.this.xZj = true;
          }
        });
      }
      for (;;)
      {
        AppMethodBeat.o(96099);
        return 0;
        dJj();
      }
    }
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof com.tencent.mm.plugin.sns.data.b)))
    {
      AppMethodBeat.o(96099);
      return 0;
    }
    if ((!this.ddj) || (this.xZs == null))
    {
      AppMethodBeat.o(96099);
      return 2;
    }
    Object localObject1 = (com.tencent.mm.plugin.sns.data.b)paramView.getTag();
    long l = ((com.tencent.mm.plugin.sns.data.b)localObject1).dwQ;
    Object localObject2 = ((com.tencent.mm.plugin.sns.data.b)localObject1).xMy.yYg;
    boolean bool;
    if (this.xZt.containsKey(Long.valueOf(l))) {
      bool = ((Boolean)this.xZt.get(Long.valueOf(l))).booleanValue();
    }
    while (!bool)
    {
      AppMethodBeat.o(96099);
      return 2;
      if (this.xZs == null)
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
          if (i >= this.xZs.yah.size()) {
            break label322;
          }
          if (bs.isNullOrNil(a((a)this.xZs.yah.get(i), ((com.tencent.mm.plugin.sns.storage.b)localObject2).yfS)))
          {
            this.xZt.put(Long.valueOf(l), Boolean.FALSE);
            bool = false;
            break;
          }
          i += 1;
        }
        label322:
        this.xZt.put(Long.valueOf(l), Boolean.TRUE);
        bool = true;
      }
    }
    localObject2 = ((com.tencent.mm.plugin.sns.data.b)localObject1).ddB;
    Object localObject3 = new b(((com.tencent.mm.plugin.sns.data.b)localObject1).dwQ, ((com.tencent.mm.plugin.sns.data.b)localObject1).xMy.dRs(), this.xZs.xZE, this.xZs.xZF, this.mContext.getString(2131763766));
    this.xZp.put(Long.valueOf(((com.tencent.mm.plugin.sns.data.b)localObject1).dwQ), localObject3);
    if (this.xZr.contains(Long.valueOf(((com.tencent.mm.plugin.sns.data.b)localObject1).dwQ))) {
      this.xZr.remove(Long.valueOf(((com.tencent.mm.plugin.sns.data.b)localObject1).dwQ));
    }
    this.xZg = new AbsoluteLayout(this.mContext);
    this.xZg.setId(2131296470);
    new FrameLayout.LayoutParams(-1, -1);
    this.xZf.addView(this.xZg);
    localObject3 = z.jD(this.mContext).inflate(2131492942, null);
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
    if (!t.xl(((com.tencent.mm.plugin.sns.data.b)localObject1).dwQ))
    {
      k = 0;
      for (;;)
      {
        j = i;
        if (k >= this.xZn.length) {
          break;
        }
        j = i;
        if (this.xZn[k] == 3) {
          j = i + 1;
        }
        k += 1;
        i = j;
      }
    }
    int k = 0;
    i = 0;
    while (i < this.xZn.length)
    {
      m = k;
      if (this.xZn[i] == 0) {
        m = k + 1;
      }
      i += 1;
      k = m;
    }
    if (k + j > 0)
    {
      i = this.xZn.length - k - j;
      if (i == 0)
      {
        AppMethodBeat.o(96099);
        return 2;
      }
    }
    for (this.xZo = new int[i];; this.xZo = new int[this.xZn.length])
    {
      i = 0;
      for (k = 0; i < this.xZn.length; k = m)
      {
        m = k;
        if (this.xZn[i] != 0) {
          if (j > 0)
          {
            m = k;
            if (this.xZn[i] == 3) {}
          }
          else
          {
            this.xZo[k] = this.xZn[i];
            m = k + 1;
          }
        }
        i += 1;
      }
    }
    if (t.xk(((com.tencent.mm.plugin.sns.data.b)localObject1).dwQ))
    {
      i = 0;
      if (i < this.xZo.length)
      {
        if (this.xZo[i] != 3) {
          break label1130;
        }
        this.xZo[i] = 4;
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
    if (j < this.xZo.length)
    {
      i2 = this.xZo[j];
      i3 = this.xZo[j] - 1;
      localObject4[j].setText(this.xZm[i3]);
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
      localObject4[j].setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(this.xZl[i3]), null, null, null);
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
            b localb = b.this;
            int j = i2;
            paramAnonymousView = this.xZv;
            Object localObject = this.xZw;
            AbsoluteLayout localAbsoluteLayout = b.this.xZg;
            ac.d("MicroMsg.AdNotLikeAbTestHelper", "processFristButtonClick " + j + " " + paramAnonymousView.dwQ);
            b.b localb1 = (b.b)localb.xZp.get(Long.valueOf(paramAnonymousView.dwQ));
            if (localb1 != null) {
              if (j != 4) {
                break label434;
              }
            }
            label434:
            for (int i = 3;; i = j)
            {
              localb1.aus("1:" + i + ":" + localb.mContext.getString(localb.xZk[(j - 1)]));
              if (j == 1)
              {
                localObject = af.dHR().auT(paramAnonymousView.ddB);
                if (localObject != null)
                {
                  if (((p)localObject).Pe(32))
                  {
                    paramAnonymousView = ((p)localObject).dFQ();
                    if (paramAnonymousView != null) {
                      break label323;
                    }
                  }
                  label323:
                  for (paramAnonymousView = "";; paramAnonymousView = paramAnonymousView.dyy)
                  {
                    ((com.tencent.mm.plugin.sns.b.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.sns.b.d.class)).a(11855, ((p)localObject).dMF(), new Object[] { Integer.valueOf(3), paramAnonymousView, Integer.valueOf(((p)localObject).dMF()) });
                    af.dHU().delete(((p)localObject).field_snsId);
                    af.dHW().xF(((p)localObject).field_snsId);
                    i.xE(((p)localObject).field_snsId);
                    paramAnonymousView = new com.tencent.mm.plugin.sns.model.q(((p)localObject).field_snsId, 8);
                    com.tencent.mm.kernel.g.agS();
                    com.tencent.mm.kernel.g.agQ().ghe.a(paramAnonymousView, 0);
                    localb.a(localb1);
                    localb.dJj();
                    AppMethodBeat.o(96085);
                    return;
                  }
                }
              }
              else
              {
                if (j == 2)
                {
                  localb.a((View)localObject, localAbsoluteLayout, paramAnonymousView);
                  AppMethodBeat.o(96085);
                  return;
                }
                if (j == 3)
                {
                  if (!t.xk(paramAnonymousView.dwQ)) {
                    t.xi(paramAnonymousView.dwQ);
                  }
                  localb.a(localb1);
                  localb.dJj();
                  AppMethodBeat.o(96085);
                  return;
                }
                if (j == 4)
                {
                  if (t.xk(paramAnonymousView.dwQ)) {
                    t.xj(paramAnonymousView.dwQ);
                  }
                  localb.a(localb1);
                  localb.dJj();
                }
              }
              AppMethodBeat.o(96085);
              return;
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
      while (j < this.xZo.length)
      {
        localObject4[j].setMaxWidth(i);
        j += 1;
      }
      j = this.xZo.length;
      while (j < 3)
      {
        localObject4[j].setVisibility(8);
        j += 1;
      }
      new Rect();
      j = com.tencent.mm.pluginsdk.g.hh(this.mContext);
      localObject4 = ((com.tencent.mm.plugin.sns.data.b)localObject1).xMy.dRt();
      ac.d("MicroMsg.AdNotLikeAbTestHelper", "addCommentView getLocationInWindow " + localObject4[0] + "  " + localObject4[1] + " height: " + j);
      i += com.tencent.mm.cc.a.fromDPToPix(this.mContext, 12);
      k = BackwardSupportUtil.b.g(this.mContext, 17.0F);
      m = BackwardSupportUtil.b.g(this.mContext, 2.0F);
      this.xJx = aj.jw(this.mContext);
      localObject4 = new AbsoluteLayout.LayoutParams(i, -2, localObject4[0] - i - m, localObject4[1] - this.xJx - j + k);
      localObject1 = new a((String)localObject2, (View)localObject3, ((com.tencent.mm.plugin.sns.data.b)localObject1).dwQ, ((com.tencent.mm.plugin.sns.data.b)localObject1).xMy.yYg);
      this.xZg.setTag(localObject1);
      this.xZg.addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
      ((View)localObject3).setVisibility(8);
      this.xZj = true;
      new ao().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(96086);
          b.a(b.this, paramView, this.xZw);
          AppMethodBeat.o(96086);
        }
      });
      AppMethodBeat.o(96099);
      return 1;
    }
  }
  
  final class a
  {
    long dwQ;
    View xIw = null;
    com.tencent.mm.plugin.sns.storage.b xZA;
    String xZz;
    
    public a(String paramString, View paramView, long paramLong, com.tencent.mm.plugin.sns.storage.b paramb)
    {
      this.xZz = paramString;
      this.xIw = paramView;
      this.xZA = paramb;
      this.dwQ = paramLong;
    }
  }
  
  static final class b
  {
    String dtx;
    long xIE;
    StringBuffer xZB;
    long xZC;
    long xZD;
    String xZE;
    String xZF;
    
    public b(long paramLong, String paramString1, String paramString2, String paramString3)
    {
      AppMethodBeat.i(96090);
      this.xZB = new StringBuffer();
      this.dtx = paramString1;
      this.xZE = paramString2;
      this.xZF = paramString3;
      this.xIE = paramLong;
      this.xZC = System.currentTimeMillis();
      this.xZB.append("0:0:");
      AppMethodBeat.o(96090);
    }
    
    public b(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4)
    {
      AppMethodBeat.i(96089);
      this.xZB = new StringBuffer();
      this.dtx = paramString1;
      this.xZE = paramString2;
      this.xZF = paramString3;
      this.xIE = paramLong;
      this.xZC = System.currentTimeMillis();
      this.xZB.append("1:0:".concat(String.valueOf(paramString4)));
      AppMethodBeat.o(96089);
    }
    
    public final void aus(String paramString)
    {
      AppMethodBeat.i(96091);
      ac.d("MicroMsg.AdNotLikeAbTestHelper", "addactionResult ".concat(String.valueOf(paramString)));
      if (this.xZB.length() != 0) {
        this.xZB.append("|");
      }
      this.xZB.append(paramString);
      AppMethodBeat.o(96091);
    }
    
    public final boolean dJk()
    {
      AppMethodBeat.i(96092);
      if ((this.xZB == null) || (this.xZB.length() == 0))
      {
        AppMethodBeat.o(96092);
        return false;
      }
      if (this.xZB.toString().startsWith("1:0"))
      {
        AppMethodBeat.o(96092);
        return true;
      }
      AppMethodBeat.o(96092);
      return false;
    }
    
    public final boolean dJl()
    {
      AppMethodBeat.i(96093);
      if ((this.xZB == null) || (this.xZB.length() == 0))
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
      this.xZD = System.currentTimeMillis();
      ac.d("MicroMsg.AdNotLikeAbTestHelper", "report abtestnotlike " + this.xIE + " uxinfo:" + this.dtx + " actionresult: " + this.xZB + " " + this.xZC + " " + this.xZD);
      com.tencent.mm.plugin.report.service.h.wUl.f(11988, new Object[] { this.xZF, this.xZE, "", "", com.tencent.mm.plugin.sns.data.q.wW(this.xIE), this.dtx, this.xZB, Long.valueOf(this.xZC / 1000L), Long.valueOf(this.xZD / 1000L) });
      AppMethodBeat.o(96094);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.h.b
 * JD-Core Version:    0.7.0.1
 */