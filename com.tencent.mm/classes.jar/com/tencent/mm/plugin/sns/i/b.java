package com.tencent.mm.plugin.sns.i;

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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.y;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class b
  implements com.tencent.mm.plugin.sns.model.d
{
  private boolean dfO;
  Context mContext;
  AbsoluteLayout wMA;
  protected Animation wMB;
  protected Animation wMC;
  boolean wMD;
  int[] wME;
  private int[] wMF;
  private int[] wMG;
  private int[] wMH;
  private int[] wMI;
  Map<Long, b> wMJ;
  private Map<Long, b> wMK;
  private HashSet<Long> wML;
  h wMM;
  private HashMap<Long, Boolean> wMN;
  public final int wMx;
  private com.tencent.mm.plugin.sns.ui.d.b wMy;
  private FrameLayout wMz;
  private int wxW;
  
  public b(Context paramContext, com.tencent.mm.plugin.sns.ui.d.b paramb, FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(96098);
    this.wMx = 14;
    this.wMA = null;
    this.wMD = false;
    this.wME = new int[] { 2131763731, 2131763732, 2131763733, 2131763734 };
    this.wMF = new int[] { 2131689540, 2131689542, 2131689541, 2131689539 };
    this.wMG = this.wME;
    this.dfO = true;
    this.wMJ = new HashMap();
    this.wMK = new HashMap();
    this.wML = new HashSet();
    this.wMM = null;
    this.wMN = new HashMap();
    this.wxW = -1;
    g localg = af.dtm();
    h localh2 = new h();
    c localc = com.tencent.mm.model.c.d.aty().qu("100007");
    h localh1;
    if (!localc.isValid())
    {
      ad.i("MicroMsg.SnsABTestStrategy", "abtest is invalid");
      localh1 = null;
    }
    for (;;)
    {
      localg.wNM = localh1;
      this.wMM = af.dtm().duN();
      if (this.wMM != null)
      {
        this.wMH = this.wMM.wNO;
        if (!this.wMM.duO()) {
          this.dfO = false;
        }
      }
      this.mContext = paramContext;
      this.wMy = paramb;
      this.wMz = paramFrameLayout;
      this.wMB = new ScaleAnimation(1.0F, 1.0F, 0.0F, 1.0F, 1, 1.0F, 1, 0.0F);
      this.wMB = AnimationUtils.loadAnimation(paramContext, 2130772022);
      this.wMC = new ScaleAnimation(1.0F, 1.0F, 1.0F, 0.0F, 1, 1.0F, 1, 0.0F);
      this.wMC = AnimationUtils.loadAnimation(paramContext, 2130772023);
      AppMethodBeat.o(96098);
      return;
      Map localMap = localc.eJy();
      localh1 = localh2;
      if (localMap != null)
      {
        ad.i("MicroMsg.SnsABTestStrategy", "snsabtest feed " + localc.field_expId + " " + localc.field_layerId + " " + localc.field_startTime + " " + localc.field_endTime);
        localh2.f(localc.field_layerId, localc.field_expId, localMap);
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
    if (ac.eFr())
    {
      parama = parama.wMt;
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
      if (ac.eFs())
      {
        parama = parama.wMu;
        break;
      }
      parama = parama.wMv;
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
    if ((paramBoolean) && (this.dfO))
    {
      if (this.wML.contains(Long.valueOf(paramLong)))
      {
        paramBoolean = false;
        if (this.wMN.containsKey(Long.valueOf(paramLong))) {
          paramBoolean = ((Boolean)this.wMN.get(Long.valueOf(paramLong))).booleanValue();
        }
        if (paramBoolean)
        {
          paramString = (b)this.wMK.get(Long.valueOf(paramLong));
          if (paramString != null) {
            paramString.report();
          }
        }
      }
      this.wMK.remove(Long.valueOf(paramLong));
      this.wML.remove(Long.valueOf(paramLong));
    }
    AppMethodBeat.o(96096);
  }
  
  public final void a(int paramInt, String paramString, long paramLong, TimeLineObject paramTimeLineObject, boolean paramBoolean, bk parambk)
  {
    AppMethodBeat.i(96095);
    if ((paramBoolean) && (this.dfO) && (this.wMM != null) && (parambk != null))
    {
      this.wML.add(Long.valueOf(paramLong));
      paramString = new b(paramLong, this.wMM.wMY, this.wMM.wMZ, parambk.dCV());
      this.wMK.put(Long.valueOf(paramLong), paramString);
    }
    AppMethodBeat.o(96095);
  }
  
  final void a(View paramView, AbsoluteLayout paramAbsoluteLayout, final com.tencent.mm.plugin.sns.data.b paramb)
  {
    AppMethodBeat.i(96100);
    Object localObject1 = (ViewGroup)paramView;
    ((ViewGroup)localObject1).removeAllViews();
    if (this.wMM == null)
    {
      AppMethodBeat.o(96100);
      return;
    }
    if ((paramb.wAe == null) || (paramb.wAe.xLr == null))
    {
      AppMethodBeat.o(96100);
      return;
    }
    Object localObject2 = paramb.wAe.xLr;
    int i = 0;
    Object localObject3 = new Paint(1);
    int n = BackwardSupportUtil.b.g(this.mContext, 12.0F);
    int i1 = BackwardSupportUtil.b.g(this.mContext, 10.0F);
    int k = BackwardSupportUtil.b.g(this.mContext, 150.0F);
    LinkedList localLinkedList = new LinkedList();
    float f = BackwardSupportUtil.b.g(this.mContext, 17.0F) * com.tencent.mm.cd.a.dT(this.mContext) + i1 * 2;
    int m = (int)f;
    int j = 0;
    while (j < this.wMM.wNB.size())
    {
      Object localObject4 = (a)this.wMM.wNB.get(j);
      final TextView localTextView = new TextView(this.mContext);
      localTextView.setPadding(n, i1, n, i1);
      localTextView.setTextSize(1, 14.0F * com.tencent.mm.cd.a.dT(this.mContext));
      localTextView.setTextColor(this.mContext.getResources().getColor(2131100889));
      localObject4 = a((a)localObject4, ((com.tencent.mm.plugin.sns.storage.b)localObject2).wTi);
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
          Object localObject = (b.b)b.this.wMJ.get(Long.valueOf(paramb.dze));
          int j = ((a)b.this.wMM.wNB.get(i)).wMs;
          if (localObject != null) {
            ((b.b)localObject).apg("3:" + j + ":" + localTextView.getText());
          }
          if (((a)b.this.wMM.wNB.get(i)).wMw == 1)
          {
            paramAnonymousView = new Intent();
            paramAnonymousView.setClass(b.this.mContext, SnsCommentUI.class);
            paramAnonymousView.putExtra("sns_comment_type", 2);
            paramAnonymousView.putExtra("sns_id", paramb.dze);
            paramAnonymousView.putExtra("sns_uxinfo", ((b.b)localObject).dvK);
            paramAnonymousView.putExtra("action_st_time", ((b.b)localObject).wMW);
            paramAnonymousView.putExtra("sns_actionresult", ((b.b)localObject).wMV.toString());
            localObject = (MMActivity)b.this.mContext;
            paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.adn(), "com/tencent/mm/plugin/sns/newabtest/AdNotLikeAbTestHelper$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((MMActivity)localObject).startActivity((Intent)paramAnonymousView.lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/sns/newabtest/AdNotLikeAbTestHelper$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            b.this.wMJ.remove(Long.valueOf(paramb.dze));
            b.this.duJ();
            AppMethodBeat.o(96087);
            return;
          }
          b.this.a((b.b)localObject);
          b.this.duJ();
          AppMethodBeat.o(96087);
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
    k = com.tencent.mm.pluginsdk.g.gW(this.mContext);
    localObject1 = paramb.wAe.dCW();
    n = BackwardSupportUtil.b.g(this.mContext, 2.0F);
    i1 = localObject1[0];
    int i2 = localObject1[1];
    int i3 = this.wxW;
    paramb = paramb.wAe;
    if (paramb.xLn != null) {}
    for (i = paramb.xLn.getHeight();; i = 0)
    {
      paramAbsoluteLayout.updateViewLayout(paramView, new AbsoluteLayout.LayoutParams(-2, -2, i1 - j - n, i2 - i3 - k + m - i));
      AppMethodBeat.o(96100);
      return;
    }
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(96097);
    this.wMJ.remove(Long.valueOf(paramb.wxd));
    paramb.report();
    AppMethodBeat.o(96097);
  }
  
  public final boolean duJ()
  {
    AppMethodBeat.i(96102);
    if (this.wMA != null)
    {
      Object localObject;
      if ((this.wMA.getTag() instanceof a))
      {
        localObject = (a)this.wMA.getTag();
        localObject = (b)this.wMJ.get(Long.valueOf(((a)localObject).dze));
        if (localObject != null)
        {
          if (!((b)localObject).duL()) {
            break label111;
          }
          if (((b)localObject).duK()) {
            ((b)localObject).apg("2:0:");
          }
          a((b)localObject);
        }
      }
      for (;;)
      {
        this.wMz.removeView(this.wMA);
        this.wMA = null;
        AppMethodBeat.o(96102);
        return true;
        label111:
        ((b)localObject).apg("2:0:");
        a((b)localObject);
      }
    }
    this.wMD = false;
    AppMethodBeat.o(96102);
    return false;
  }
  
  public final int et(final View paramView)
  {
    AppMethodBeat.i(96099);
    if (this.wMD)
    {
      AppMethodBeat.o(96099);
      return 0;
    }
    if (this.wMA != null)
    {
      if ((this.wMA.getTag() instanceof a))
      {
        paramView = ((a)this.wMA.getTag()).wwV;
        this.wMD = true;
        paramView.startAnimation(this.wMC);
        this.wMC.setAnimationListener(new Animation.AnimationListener()
        {
          public final void onAnimationEnd(Animation paramAnonymousAnimation)
          {
            AppMethodBeat.i(96088);
            if (paramView != null)
            {
              paramView.clearAnimation();
              paramView.setVisibility(8);
              b.this.duJ();
            }
            b.this.wMD = false;
            AppMethodBeat.o(96088);
          }
          
          public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
          
          public final void onAnimationStart(Animation paramAnonymousAnimation)
          {
            b.this.wMD = true;
          }
        });
      }
      for (;;)
      {
        AppMethodBeat.o(96099);
        return 0;
        duJ();
      }
    }
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof com.tencent.mm.plugin.sns.data.b)))
    {
      AppMethodBeat.o(96099);
      return 0;
    }
    if ((!this.dfO) || (this.wMM == null))
    {
      AppMethodBeat.o(96099);
      return 2;
    }
    Object localObject1 = (com.tencent.mm.plugin.sns.data.b)paramView.getTag();
    long l = ((com.tencent.mm.plugin.sns.data.b)localObject1).dze;
    Object localObject2 = ((com.tencent.mm.plugin.sns.data.b)localObject1).wAe.xLr;
    boolean bool;
    if (this.wMN.containsKey(Long.valueOf(l))) {
      bool = ((Boolean)this.wMN.get(Long.valueOf(l))).booleanValue();
    }
    while (!bool)
    {
      AppMethodBeat.o(96099);
      return 2;
      if (this.wMM == null)
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
          if (i >= this.wMM.wNB.size()) {
            break label322;
          }
          if (bt.isNullOrNil(a((a)this.wMM.wNB.get(i), ((com.tencent.mm.plugin.sns.storage.b)localObject2).wTi)))
          {
            this.wMN.put(Long.valueOf(l), Boolean.FALSE);
            bool = false;
            break;
          }
          i += 1;
        }
        label322:
        this.wMN.put(Long.valueOf(l), Boolean.TRUE);
        bool = true;
      }
    }
    localObject2 = ((com.tencent.mm.plugin.sns.data.b)localObject1).dgg;
    Object localObject3 = new b(((com.tencent.mm.plugin.sns.data.b)localObject1).dze, ((com.tencent.mm.plugin.sns.data.b)localObject1).wAe.dCV(), this.wMM.wMY, this.wMM.wMZ, this.mContext.getString(2131763766));
    this.wMJ.put(Long.valueOf(((com.tencent.mm.plugin.sns.data.b)localObject1).dze), localObject3);
    if (this.wML.contains(Long.valueOf(((com.tencent.mm.plugin.sns.data.b)localObject1).dze))) {
      this.wML.remove(Long.valueOf(((com.tencent.mm.plugin.sns.data.b)localObject1).dze));
    }
    this.wMA = new AbsoluteLayout(this.mContext);
    this.wMA.setId(2131296470);
    new FrameLayout.LayoutParams(-1, -1);
    this.wMz.addView(this.wMA);
    localObject3 = y.js(this.mContext).inflate(2131492942, null);
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
    if (!t.sI(((com.tencent.mm.plugin.sns.data.b)localObject1).dze))
    {
      k = 0;
      for (;;)
      {
        j = i;
        if (k >= this.wMH.length) {
          break;
        }
        j = i;
        if (this.wMH[k] == 3) {
          j = i + 1;
        }
        k += 1;
        i = j;
      }
    }
    int k = 0;
    i = 0;
    while (i < this.wMH.length)
    {
      m = k;
      if (this.wMH[i] == 0) {
        m = k + 1;
      }
      i += 1;
      k = m;
    }
    if (k + j > 0)
    {
      i = this.wMH.length - k - j;
      if (i == 0)
      {
        AppMethodBeat.o(96099);
        return 2;
      }
    }
    for (this.wMI = new int[i];; this.wMI = new int[this.wMH.length])
    {
      i = 0;
      for (k = 0; i < this.wMH.length; k = m)
      {
        m = k;
        if (this.wMH[i] != 0) {
          if (j > 0)
          {
            m = k;
            if (this.wMH[i] == 3) {}
          }
          else
          {
            this.wMI[k] = this.wMH[i];
            m = k + 1;
          }
        }
        i += 1;
      }
    }
    if (t.sH(((com.tencent.mm.plugin.sns.data.b)localObject1).dze))
    {
      i = 0;
      if (i < this.wMI.length)
      {
        if (this.wMI[i] != 3) {
          break label1130;
        }
        this.wMI[i] = 4;
      }
    }
    i = 0;
    int m = com.tencent.mm.cd.a.fromDPToPix(this.mContext, 12);
    int n = com.tencent.mm.cd.a.fromDPToPix(this.mContext, 8);
    int i1 = com.tencent.mm.cd.a.fromDPToPix(this.mContext, 12);
    j = 0;
    label919:
    final int i2;
    int i3;
    if (j < this.wMI.length)
    {
      i2 = this.wMI[j];
      i3 = this.wMI[j] - 1;
      localObject4[j].setText(this.wMG[i3]);
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
      localObject4[j].setCompoundDrawablePadding(com.tencent.mm.cd.a.fromDPToPix(this.mContext, 8));
      localObject4[j].setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(this.wMF[i3]), null, null, null);
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
            paramAnonymousView = this.wMP;
            Object localObject = this.wMQ;
            AbsoluteLayout localAbsoluteLayout = b.this.wMA;
            ad.d("MicroMsg.AdNotLikeAbTestHelper", "processFristButtonClick " + j + " " + paramAnonymousView.dze);
            b.b localb1 = (b.b)localb.wMJ.get(Long.valueOf(paramAnonymousView.dze));
            if (localb1 != null) {
              if (j != 4) {
                break label434;
              }
            }
            label434:
            for (int i = 3;; i = j)
            {
              localb1.apg("1:" + i + ":" + localb.mContext.getString(localb.wME[(j - 1)]));
              if (j == 1)
              {
                localObject = af.dtu().apK(paramAnonymousView.dgg);
                if (localObject != null)
                {
                  if (((p)localObject).Nb(32))
                  {
                    paramAnonymousView = ((p)localObject).dxu();
                    if (paramAnonymousView != null) {
                      break label323;
                    }
                  }
                  label323:
                  for (paramAnonymousView = "";; paramAnonymousView = paramAnonymousView.dAM)
                  {
                    ((com.tencent.mm.plugin.sns.c.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.sns.c.d.class)).a(11855, ((p)localObject).dyi(), new Object[] { Integer.valueOf(3), paramAnonymousView, Integer.valueOf(((p)localObject).dyi()) });
                    af.dtx().delete(((p)localObject).field_snsId);
                    af.dtz().tc(((p)localObject).field_snsId);
                    i.tb(((p)localObject).field_snsId);
                    paramAnonymousView = new com.tencent.mm.plugin.sns.model.q(((p)localObject).field_snsId, 8);
                    com.tencent.mm.kernel.g.afC();
                    com.tencent.mm.kernel.g.afA().gcy.a(paramAnonymousView, 0);
                    localb.a(localb1);
                    localb.duJ();
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
                  if (!t.sH(paramAnonymousView.dze)) {
                    t.sF(paramAnonymousView.dze);
                  }
                  localb.a(localb1);
                  localb.duJ();
                  AppMethodBeat.o(96085);
                  return;
                }
                if (j == 4)
                {
                  if (t.sH(paramAnonymousView.dze)) {
                    t.sG(paramAnonymousView.dze);
                  }
                  localb.a(localb1);
                  localb.duJ();
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
      while (j < this.wMI.length)
      {
        localObject4[j].setMaxWidth(i);
        j += 1;
      }
      j = this.wMI.length;
      while (j < 3)
      {
        localObject4[j].setVisibility(8);
        j += 1;
      }
      new Rect();
      j = com.tencent.mm.pluginsdk.g.gW(this.mContext);
      localObject4 = ((com.tencent.mm.plugin.sns.data.b)localObject1).wAe.dCW();
      ad.d("MicroMsg.AdNotLikeAbTestHelper", "addCommentView getLocationInWindow " + localObject4[0] + "  " + localObject4[1] + " height: " + j);
      i += com.tencent.mm.cd.a.fromDPToPix(this.mContext, 12);
      k = BackwardSupportUtil.b.g(this.mContext, 17.0F);
      m = BackwardSupportUtil.b.g(this.mContext, 2.0F);
      this.wxW = ai.jl(this.mContext);
      localObject4 = new AbsoluteLayout.LayoutParams(i, -2, localObject4[0] - i - m, localObject4[1] - this.wxW - j + k);
      localObject1 = new a((String)localObject2, (View)localObject3, ((com.tencent.mm.plugin.sns.data.b)localObject1).dze, ((com.tencent.mm.plugin.sns.data.b)localObject1).wAe.xLr);
      this.wMA.setTag(localObject1);
      this.wMA.addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
      ((View)localObject3).setVisibility(8);
      this.wMD = true;
      new ap().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(96086);
          b.a(b.this, paramView, this.wMQ);
          AppMethodBeat.o(96086);
        }
      });
      AppMethodBeat.o(96099);
      return 1;
    }
  }
  
  final class a
  {
    long dze;
    String wMT;
    com.tencent.mm.plugin.sns.storage.b wMU;
    View wwV = null;
    
    public a(String paramString, View paramView, long paramLong, com.tencent.mm.plugin.sns.storage.b paramb)
    {
      this.wMT = paramString;
      this.wwV = paramView;
      this.wMU = paramb;
      this.dze = paramLong;
    }
  }
  
  static final class b
  {
    String dvK;
    StringBuffer wMV;
    long wMW;
    long wMX;
    String wMY;
    String wMZ;
    long wxd;
    
    public b(long paramLong, String paramString1, String paramString2, String paramString3)
    {
      AppMethodBeat.i(96090);
      this.wMV = new StringBuffer();
      this.dvK = paramString1;
      this.wMY = paramString2;
      this.wMZ = paramString3;
      this.wxd = paramLong;
      this.wMW = System.currentTimeMillis();
      this.wMV.append("0:0:");
      AppMethodBeat.o(96090);
    }
    
    public b(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4)
    {
      AppMethodBeat.i(96089);
      this.wMV = new StringBuffer();
      this.dvK = paramString1;
      this.wMY = paramString2;
      this.wMZ = paramString3;
      this.wxd = paramLong;
      this.wMW = System.currentTimeMillis();
      this.wMV.append("1:0:".concat(String.valueOf(paramString4)));
      AppMethodBeat.o(96089);
    }
    
    public final void apg(String paramString)
    {
      AppMethodBeat.i(96091);
      ad.d("MicroMsg.AdNotLikeAbTestHelper", "addactionResult ".concat(String.valueOf(paramString)));
      if (this.wMV.length() != 0) {
        this.wMV.append("|");
      }
      this.wMV.append(paramString);
      AppMethodBeat.o(96091);
    }
    
    public final boolean duK()
    {
      AppMethodBeat.i(96092);
      if ((this.wMV == null) || (this.wMV.length() == 0))
      {
        AppMethodBeat.o(96092);
        return false;
      }
      if (this.wMV.toString().startsWith("1:0"))
      {
        AppMethodBeat.o(96092);
        return true;
      }
      AppMethodBeat.o(96092);
      return false;
    }
    
    public final boolean duL()
    {
      AppMethodBeat.i(96093);
      if ((this.wMV == null) || (this.wMV.length() == 0))
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
      this.wMX = System.currentTimeMillis();
      ad.d("MicroMsg.AdNotLikeAbTestHelper", "report abtestnotlike " + this.wxd + " uxinfo:" + this.dvK + " actionresult: " + this.wMV + " " + this.wMW + " " + this.wMX);
      com.tencent.mm.plugin.report.service.h.vKh.f(11988, new Object[] { this.wMZ, this.wMY, "", "", com.tencent.mm.plugin.sns.data.q.st(this.wxd), this.dvK, this.wMV, Long.valueOf(this.wMW / 1000L), Long.valueOf(this.wMX / 1000L) });
      AppMethodBeat.o(96094);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.i.b
 * JD-Core Version:    0.7.0.1
 */