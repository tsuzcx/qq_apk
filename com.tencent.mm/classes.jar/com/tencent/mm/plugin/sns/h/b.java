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
import com.tencent.mm.ak.t;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.e;
import com.tencent.mm.plugin.sns.model.s;
import com.tencent.mm.plugin.sns.model.v;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.i;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.SnsCommentUI;
import com.tencent.mm.plugin.sns.ui.bq;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.ao;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class b
  implements e
{
  private int CHZ;
  private int[] DQA;
  private int[] DQB;
  private int[] DQC;
  Map<Long, b> DQD;
  private Map<Long, b> DQE;
  private HashSet<Long> DQF;
  h DQG;
  private HashMap<Long, Boolean> DQH;
  public final int DQr;
  private com.tencent.mm.plugin.sns.ui.d.c DQs;
  private FrameLayout DQt;
  AbsoluteLayout DQu;
  protected Animation DQv;
  protected Animation DQw;
  boolean DQx;
  int[] DQy;
  private int[] DQz;
  private boolean dGX;
  Context mContext;
  
  public b(Context paramContext, com.tencent.mm.plugin.sns.ui.d.c paramc, FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(96098);
    this.DQr = 14;
    this.DQu = null;
    this.DQx = false;
    this.DQy = new int[] { 2131765924, 2131765925, 2131765926, 2131765927 };
    this.DQz = new int[] { 2131689543, 2131689545, 2131689544, 2131689542 };
    this.DQA = this.DQy;
    this.dGX = true;
    this.DQD = new HashMap();
    this.DQE = new HashMap();
    this.DQF = new HashSet();
    this.DQG = null;
    this.DQH = new HashMap();
    this.CHZ = -1;
    g localg = aj.faG();
    h localh2 = new h();
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.d.aXu().Fu("100007");
    h localh1;
    if (!localc.isValid())
    {
      Log.i("MicroMsg.SnsABTestStrategy", "abtest is invalid");
      localh1 = null;
    }
    for (;;)
    {
      localg.DRF = localh1;
      this.DQG = aj.faG().fcp();
      if (this.DQG != null)
      {
        this.DQB = this.DQG.DRH;
        if (!this.DQG.fcq()) {
          this.dGX = false;
        }
      }
      this.mContext = paramContext;
      this.DQs = paramc;
      this.DQt = paramFrameLayout;
      this.DQv = new ScaleAnimation(1.0F, 1.0F, 0.0F, 1.0F, 1, 1.0F, 1, 0.0F);
      this.DQv = AnimationUtils.loadAnimation(paramContext, 2130772028);
      this.DQw = new ScaleAnimation(1.0F, 1.0F, 1.0F, 0.0F, 1, 1.0F, 1, 0.0F);
      this.DQw = AnimationUtils.loadAnimation(paramContext, 2130772029);
      AppMethodBeat.o(96098);
      return;
      Map localMap = localc.gzz();
      localh1 = localh2;
      if (localMap != null)
      {
        Log.i("MicroMsg.SnsABTestStrategy", "snsabtest feed " + localc.field_expId + " " + localc.field_layerId + " " + localc.field_startTime + " " + localc.field_endTime);
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
    if (LocaleUtil.isSimplifiedChineseAppLang())
    {
      parama = parama.DQn;
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
      if (LocaleUtil.isTraditionalChineseAppLang())
      {
        parama = parama.DQo;
        break;
      }
      parama = parama.DQp;
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
    if ((paramBoolean) && (this.dGX))
    {
      if (this.DQF.contains(Long.valueOf(paramLong)))
      {
        paramBoolean = false;
        if (this.DQH.containsKey(Long.valueOf(paramLong))) {
          paramBoolean = ((Boolean)this.DQH.get(Long.valueOf(paramLong))).booleanValue();
        }
        if (paramBoolean)
        {
          paramString = (b)this.DQE.get(Long.valueOf(paramLong));
          if (paramString != null) {
            paramString.report();
          }
        }
      }
      this.DQE.remove(Long.valueOf(paramLong));
      this.DQF.remove(Long.valueOf(paramLong));
    }
    AppMethodBeat.o(96096);
  }
  
  public final void a(int paramInt, String paramString, long paramLong, TimeLineObject paramTimeLineObject, boolean paramBoolean, bq parambq)
  {
    AppMethodBeat.i(96095);
    if ((paramBoolean) && (this.dGX) && (this.DQG != null) && (parambq != null))
    {
      this.DQF.add(Long.valueOf(paramLong));
      paramString = new b(paramLong, this.DQG.DQS, this.DQG.DQT, parambq.fjV());
      this.DQE.put(Long.valueOf(paramLong), paramString);
    }
    AppMethodBeat.o(96095);
  }
  
  final void a(View paramView, AbsoluteLayout paramAbsoluteLayout, final com.tencent.mm.plugin.sns.data.c paramc)
  {
    AppMethodBeat.i(96100);
    Object localObject1 = (ViewGroup)paramView;
    ((ViewGroup)localObject1).removeAllViews();
    if (this.DQG == null)
    {
      AppMethodBeat.o(96100);
      return;
    }
    if ((paramc.DDr == null) || (paramc.DDr.EQY == null))
    {
      AppMethodBeat.o(96100);
      return;
    }
    Object localObject2 = paramc.DDr.EQY;
    int i = 0;
    Object localObject3 = new Paint(1);
    int n = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 12.0F);
    int i1 = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 10.0F);
    int k = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 150.0F);
    LinkedList localLinkedList = new LinkedList();
    float f = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 17.0F) * com.tencent.mm.cb.a.ez(this.mContext) + i1 * 2;
    int m = (int)f;
    int j = 0;
    while (j < this.DQG.DRu.size())
    {
      Object localObject4 = (a)this.DQG.DRu.get(j);
      final TextView localTextView = new TextView(this.mContext);
      localTextView.setPadding(n, i1, n, i1);
      localTextView.setTextSize(1, 14.0F * com.tencent.mm.cb.a.ez(this.mContext));
      localTextView.setTextColor(this.mContext.getResources().getColor(2131101088));
      localObject4 = a((a)localObject4, ((ADXml)localObject2).adArgs);
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
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/newabtest/AdNotLikeAbTestHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          int i = ((Integer)paramAnonymousView.getTag()).intValue();
          localObject = (b.b)b.this.DQD.get(Long.valueOf(paramc.ece));
          int j = ((a)b.this.DQG.DRu.get(i)).DQm;
          if (localObject != null) {
            ((b.b)localObject).aPL("3:" + j + ":" + localTextView.getText());
          }
          if (((a)b.this.DQG.DRu.get(i)).DQq == 1)
          {
            paramAnonymousView = new Intent();
            paramAnonymousView.setClass(b.this.mContext, SnsCommentUI.class);
            paramAnonymousView.putExtra("sns_comment_type", 2);
            paramAnonymousView.putExtra("sns_id", paramc.ece);
            paramAnonymousView.putExtra("sns_uxinfo", ((b.b)localObject).uxInfo);
            paramAnonymousView.putExtra("action_st_time", ((b.b)localObject).DQQ);
            paramAnonymousView.putExtra("sns_actionresult", ((b.b)localObject).DQP.toString());
            localObject = (MMActivity)b.this.mContext;
            paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bl(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.axQ(), "com/tencent/mm/plugin/sns/newabtest/AdNotLikeAbTestHelper$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((MMActivity)localObject).startActivity((Intent)paramAnonymousView.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/sns/newabtest/AdNotLikeAbTestHelper$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            b.this.DQD.remove(Long.valueOf(paramc.ece));
            b.this.fcl();
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/newabtest/AdNotLikeAbTestHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(96087);
            return;
            b.this.a((b.b)localObject);
            b.this.fcl();
          }
        }
      });
      j += 1;
    }
    Log.i("MicroMsg.AdNotLikeAbTestHelper", "w h " + i + " " + m);
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
    k = com.tencent.mm.pluginsdk.h.im(this.mContext);
    localObject1 = paramc.DDr.fjW();
    n = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 2.0F);
    i1 = localObject1[0];
    int i2 = localObject1[1];
    int i3 = this.CHZ;
    paramc = paramc.DDr;
    if (paramc.EQR != null) {}
    for (i = paramc.EQR.getHeight();; i = 0)
    {
      paramAbsoluteLayout.updateViewLayout(paramView, new AbsoluteLayout.LayoutParams(-2, -2, i1 - j - n, i2 - i3 - k + m - i));
      AppMethodBeat.o(96100);
      return;
    }
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(96097);
    this.DQD.remove(Long.valueOf(paramb.DuE));
    paramb.report();
    AppMethodBeat.o(96097);
  }
  
  public final boolean fcl()
  {
    AppMethodBeat.i(96102);
    if (this.DQu != null)
    {
      Object localObject;
      if ((this.DQu.getTag() instanceof a))
      {
        localObject = (a)this.DQu.getTag();
        localObject = (b)this.DQD.get(Long.valueOf(((a)localObject).ece));
        if (localObject != null)
        {
          if (!((b)localObject).fcn()) {
            break label111;
          }
          if (((b)localObject).fcm()) {
            ((b)localObject).aPL("2:0:");
          }
          a((b)localObject);
        }
      }
      for (;;)
      {
        this.DQt.removeView(this.DQu);
        this.DQu = null;
        AppMethodBeat.o(96102);
        return true;
        label111:
        ((b)localObject).aPL("2:0:");
        a((b)localObject);
      }
    }
    this.DQx = false;
    AppMethodBeat.o(96102);
    return false;
  }
  
  public final int fk(final View paramView)
  {
    AppMethodBeat.i(96099);
    if (this.DQx)
    {
      AppMethodBeat.o(96099);
      return 0;
    }
    if (this.DQu != null)
    {
      if ((this.DQu.getTag() instanceof a))
      {
        paramView = ((a)this.DQu.getTag()).Atk;
        this.DQx = true;
        paramView.startAnimation(this.DQw);
        this.DQw.setAnimationListener(new Animation.AnimationListener()
        {
          public final void onAnimationEnd(Animation paramAnonymousAnimation)
          {
            AppMethodBeat.i(96088);
            if (paramView != null)
            {
              paramView.clearAnimation();
              paramView.setVisibility(8);
              b.this.fcl();
            }
            b.this.DQx = false;
            AppMethodBeat.o(96088);
          }
          
          public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
          
          public final void onAnimationStart(Animation paramAnonymousAnimation)
          {
            b.this.DQx = true;
          }
        });
      }
      for (;;)
      {
        AppMethodBeat.o(96099);
        return 0;
        fcl();
      }
    }
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof com.tencent.mm.plugin.sns.data.c)))
    {
      AppMethodBeat.o(96099);
      return 0;
    }
    if ((!this.dGX) || (this.DQG == null))
    {
      AppMethodBeat.o(96099);
      return 2;
    }
    Object localObject1 = (com.tencent.mm.plugin.sns.data.c)paramView.getTag();
    long l = ((com.tencent.mm.plugin.sns.data.c)localObject1).ece;
    Object localObject2 = ((com.tencent.mm.plugin.sns.data.c)localObject1).DDr.EQY;
    boolean bool;
    if (this.DQH.containsKey(Long.valueOf(l))) {
      bool = ((Boolean)this.DQH.get(Long.valueOf(l))).booleanValue();
    }
    while (!bool)
    {
      AppMethodBeat.o(96099);
      return 2;
      if (this.DQG == null)
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
          if (i >= this.DQG.DRu.size()) {
            break label322;
          }
          if (Util.isNullOrNil(a((a)this.DQG.DRu.get(i), ((ADXml)localObject2).adArgs)))
          {
            this.DQH.put(Long.valueOf(l), Boolean.FALSE);
            bool = false;
            break;
          }
          i += 1;
        }
        label322:
        this.DQH.put(Long.valueOf(l), Boolean.TRUE);
        bool = true;
      }
    }
    localObject2 = ((com.tencent.mm.plugin.sns.data.c)localObject1).dHp;
    Object localObject3 = new b(((com.tencent.mm.plugin.sns.data.c)localObject1).ece, ((com.tencent.mm.plugin.sns.data.c)localObject1).DDr.fjV(), this.DQG.DQS, this.DQG.DQT, this.mContext.getString(2131765987));
    this.DQD.put(Long.valueOf(((com.tencent.mm.plugin.sns.data.c)localObject1).ece), localObject3);
    if (this.DQF.contains(Long.valueOf(((com.tencent.mm.plugin.sns.data.c)localObject1).ece))) {
      this.DQF.remove(Long.valueOf(((com.tencent.mm.plugin.sns.data.c)localObject1).ece));
    }
    this.DQu = new AbsoluteLayout(this.mContext);
    this.DQu.setId(2131296543);
    new FrameLayout.LayoutParams(-1, -1);
    this.DQt.addView(this.DQu);
    localObject3 = aa.jQ(this.mContext).inflate(2131492975, null);
    Object localObject4 = new TextView[3];
    ImageView[] arrayOfImageView = new ImageView[3];
    localObject4[0] = ((TextView)((View)localObject3).findViewById(2131296507));
    localObject4[1] = ((TextView)((View)localObject3).findViewById(2131296512));
    localObject4[2] = ((TextView)((View)localObject3).findViewById(2131296511));
    arrayOfImageView[0] = ((ImageView)((View)localObject3).findViewById(2131296508));
    arrayOfImageView[1] = ((ImageView)((View)localObject3).findViewById(2131296510));
    arrayOfImageView[2] = ((ImageView)((View)localObject3).findViewById(2131296509));
    int j = 0;
    int i = 0;
    if (!v.Jo(((com.tencent.mm.plugin.sns.data.c)localObject1).ece))
    {
      k = 0;
      for (;;)
      {
        j = i;
        if (k >= this.DQB.length) {
          break;
        }
        j = i;
        if (this.DQB[k] == 3) {
          j = i + 1;
        }
        k += 1;
        i = j;
      }
    }
    int k = 0;
    i = 0;
    while (i < this.DQB.length)
    {
      m = k;
      if (this.DQB[i] == 0) {
        m = k + 1;
      }
      i += 1;
      k = m;
    }
    if (k + j > 0)
    {
      i = this.DQB.length - k - j;
      if (i == 0)
      {
        AppMethodBeat.o(96099);
        return 2;
      }
    }
    for (this.DQC = new int[i];; this.DQC = new int[this.DQB.length])
    {
      i = 0;
      for (k = 0; i < this.DQB.length; k = m)
      {
        m = k;
        if (this.DQB[i] != 0) {
          if (j > 0)
          {
            m = k;
            if (this.DQB[i] == 3) {}
          }
          else
          {
            this.DQC[k] = this.DQB[i];
            m = k + 1;
          }
        }
        i += 1;
      }
    }
    if (v.Jn(((com.tencent.mm.plugin.sns.data.c)localObject1).ece))
    {
      i = 0;
      if (i < this.DQC.length)
      {
        if (this.DQC[i] != 3) {
          break label1130;
        }
        this.DQC[i] = 4;
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
    if (j < this.DQC.length)
    {
      i2 = this.DQC[j];
      i3 = this.DQC[j] - 1;
      localObject4[j].setText(this.DQA[i3]);
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
      localObject4[j].setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(this.DQz[i3]), null, null, null);
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
            ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/newabtest/AdNotLikeAbTestHelper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
            localObject1 = b.this;
            int j = i2;
            paramAnonymousView = this.DQJ;
            Object localObject2 = this.DQK;
            AbsoluteLayout localAbsoluteLayout = b.this.DQu;
            Log.d("MicroMsg.AdNotLikeAbTestHelper", "processFristButtonClick " + j + " " + paramAnonymousView.ece);
            b.b localb = (b.b)((b)localObject1).DQD.get(Long.valueOf(paramAnonymousView.ece));
            if (localb != null) {
              if (j != 4) {
                break label467;
              }
            }
            label467:
            for (int i = 3;; i = j)
            {
              localb.aPL("1:" + i + ":" + ((b)localObject1).mContext.getString(localObject1.DQy[(j - 1)]));
              if (j == 1)
              {
                localObject2 = aj.faO().aQm(paramAnonymousView.dHp);
                if (localObject2 != null)
                {
                  if (((SnsInfo)localObject2).isAd())
                  {
                    paramAnonymousView = ((SnsInfo)localObject2).getAdInfo();
                    if (paramAnonymousView != null) {
                      break label365;
                    }
                    paramAnonymousView = "";
                    ((com.tencent.mm.plugin.sns.b.d)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.sns.b.d.class)).a(11855, ((SnsInfo)localObject2).getAdRecSrc(), new Object[] { Integer.valueOf(3), paramAnonymousView, Integer.valueOf(((SnsInfo)localObject2).getAdRecSrc()) });
                  }
                  aj.faR().delete(((SnsInfo)localObject2).field_snsId);
                  aj.faT().JI(((SnsInfo)localObject2).field_snsId);
                  com.tencent.mm.plugin.sns.storage.g.JH(((SnsInfo)localObject2).field_snsId);
                  paramAnonymousView = new s(((SnsInfo)localObject2).field_snsId, 8);
                  com.tencent.mm.kernel.g.aAi();
                  com.tencent.mm.kernel.g.aAg().hqi.a(paramAnonymousView, 0);
                  ((b)localObject1).a(localb);
                  ((b)localObject1).fcl();
                }
              }
              for (;;)
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/newabtest/AdNotLikeAbTestHelper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(96085);
                return;
                label365:
                paramAnonymousView = paramAnonymousView.viewId;
                break;
                if (j == 2)
                {
                  ((b)localObject1).a((View)localObject2, localAbsoluteLayout, paramAnonymousView);
                }
                else if (j == 3)
                {
                  if (!v.Jn(paramAnonymousView.ece)) {
                    v.Jl(paramAnonymousView.ece);
                  }
                  ((b)localObject1).a(localb);
                  ((b)localObject1).fcl();
                }
                else if (j == 4)
                {
                  if (v.Jn(paramAnonymousView.ece)) {
                    v.Jm(paramAnonymousView.ece);
                  }
                  ((b)localObject1).a(localb);
                  ((b)localObject1).fcl();
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
      while (j < this.DQC.length)
      {
        localObject4[j].setMaxWidth(i);
        j += 1;
      }
      j = this.DQC.length;
      while (j < 3)
      {
        localObject4[j].setVisibility(8);
        j += 1;
      }
      new Rect();
      j = com.tencent.mm.pluginsdk.h.im(this.mContext);
      localObject4 = ((com.tencent.mm.plugin.sns.data.c)localObject1).DDr.fjW();
      Log.d("MicroMsg.AdNotLikeAbTestHelper", "addCommentView getLocationInWindow " + localObject4[0] + "  " + localObject4[1] + " height: " + j);
      i += com.tencent.mm.cb.a.fromDPToPix(this.mContext, 12);
      k = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 17.0F);
      m = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 2.0F);
      this.CHZ = ao.jJ(this.mContext);
      localObject4 = new AbsoluteLayout.LayoutParams(i, -2, localObject4[0] - i - m, localObject4[1] - this.CHZ - j + k);
      localObject1 = new a((String)localObject2, (View)localObject3, ((com.tencent.mm.plugin.sns.data.c)localObject1).ece, ((com.tencent.mm.plugin.sns.data.c)localObject1).DDr.EQY);
      this.DQu.setTag(localObject1);
      this.DQu.addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
      ((View)localObject3).setVisibility(8);
      this.DQx = true;
      new MMHandler().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(96086);
          b.a(b.this, paramView, this.DQK);
          AppMethodBeat.o(96086);
        }
      });
      AppMethodBeat.o(96099);
      return 1;
    }
  }
  
  final class a
  {
    View Atk = null;
    String DQN;
    ADXml DQO;
    long ece;
    
    public a(String paramString, View paramView, long paramLong, ADXml paramADXml)
    {
      this.DQN = paramString;
      this.Atk = paramView;
      this.DQO = paramADXml;
      this.ece = paramLong;
    }
  }
  
  static final class b
  {
    StringBuffer DQP;
    long DQQ;
    long DQR;
    String DQS;
    String DQT;
    long DuE;
    String uxInfo;
    
    public b(long paramLong, String paramString1, String paramString2, String paramString3)
    {
      AppMethodBeat.i(96090);
      this.DQP = new StringBuffer();
      this.uxInfo = paramString1;
      this.DQS = paramString2;
      this.DQT = paramString3;
      this.DuE = paramLong;
      this.DQQ = System.currentTimeMillis();
      this.DQP.append("0:0:");
      AppMethodBeat.o(96090);
    }
    
    public b(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4)
    {
      AppMethodBeat.i(96089);
      this.DQP = new StringBuffer();
      this.uxInfo = paramString1;
      this.DQS = paramString2;
      this.DQT = paramString3;
      this.DuE = paramLong;
      this.DQQ = System.currentTimeMillis();
      this.DQP.append("1:0:".concat(String.valueOf(paramString4)));
      AppMethodBeat.o(96089);
    }
    
    public final void aPL(String paramString)
    {
      AppMethodBeat.i(96091);
      Log.d("MicroMsg.AdNotLikeAbTestHelper", "addactionResult ".concat(String.valueOf(paramString)));
      if (this.DQP.length() != 0) {
        this.DQP.append("|");
      }
      this.DQP.append(paramString);
      AppMethodBeat.o(96091);
    }
    
    public final boolean fcm()
    {
      AppMethodBeat.i(96092);
      if ((this.DQP == null) || (this.DQP.length() == 0))
      {
        AppMethodBeat.o(96092);
        return false;
      }
      if (this.DQP.toString().startsWith("1:0"))
      {
        AppMethodBeat.o(96092);
        return true;
      }
      AppMethodBeat.o(96092);
      return false;
    }
    
    public final boolean fcn()
    {
      AppMethodBeat.i(96093);
      if ((this.DQP == null) || (this.DQP.length() == 0))
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
      this.DQR = System.currentTimeMillis();
      Log.d("MicroMsg.AdNotLikeAbTestHelper", "report abtestnotlike " + this.DuE + " uxinfo:" + this.uxInfo + " actionresult: " + this.DQP + " " + this.DQQ + " " + this.DQR);
      com.tencent.mm.plugin.report.service.h.CyF.a(11988, new Object[] { this.DQT, this.DQS, "", "", r.Jb(this.DuE), this.uxInfo, this.DQP, Long.valueOf(this.DQQ / 1000L), Long.valueOf(this.DQR / 1000L) });
      AppMethodBeat.o(96094);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.h.b
 * JD-Core Version:    0.7.0.1
 */