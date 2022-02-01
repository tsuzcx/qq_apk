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
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.i.a;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.v;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.ui.SnsCommentUI;
import com.tencent.mm.plugin.sns.ui.bt;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.ar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class b
  implements com.tencent.mm.plugin.sns.model.e
{
  private int INC;
  private FrameLayout KdA;
  AbsoluteLayout KdB;
  protected Animation KdC;
  protected Animation KdD;
  private boolean KdE;
  private int[] KdF;
  private int[] KdG;
  private int[] KdH;
  private int[] KdI;
  private int[] KdJ;
  private Map<Long, b> KdK;
  private Map<Long, b> KdL;
  private HashSet<Long> KdM;
  private h KdN;
  private HashMap<Long, Boolean> KdO;
  public final int Kdy;
  private com.tencent.mm.plugin.sns.ui.d.c Kdz;
  private boolean fzO;
  private Context mContext;
  
  public b(Context paramContext, com.tencent.mm.plugin.sns.ui.d.c paramc, FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(96098);
    this.Kdy = 14;
    this.KdB = null;
    this.KdE = false;
    this.KdF = new int[] { i.j.sns_ad_abtest_001, i.j.sns_ad_abtest_002, i.j.sns_ad_abtest_003, i.j.sns_ad_abtest_004 };
    this.KdG = new int[] { i.i.album_test_donotlook, i.i.album_test_unlike, i.i.album_test_open, i.i.album_test_close };
    this.KdH = this.KdF;
    this.fzO = true;
    this.KdK = new HashMap();
    this.KdL = new HashMap();
    this.KdM = new HashSet();
    this.KdN = null;
    this.KdO = new HashMap();
    this.INC = -1;
    g localg = aj.fOA();
    h localh2 = new h();
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.d.bgB().Mu("100007");
    h localh1;
    if (!localc.isValid())
    {
      Log.i("MicroMsg.SnsABTestStrategy", "abtest is invalid");
      localh1 = null;
    }
    for (;;)
    {
      localg.KeM = localh1;
      this.KdN = aj.fOA().fQi();
      if (this.KdN != null)
      {
        this.KdI = this.KdN.KeO;
        if (!this.KdN.fQj()) {
          this.fzO = false;
        }
      }
      this.mContext = paramContext;
      this.Kdz = paramc;
      this.KdA = paramFrameLayout;
      this.KdC = new ScaleAnimation(1.0F, 1.0F, 0.0F, 1.0F, 1, 1.0F, 1, 0.0F);
      this.KdC = AnimationUtils.loadAnimation(paramContext, i.a.dropdown_down);
      this.KdD = new ScaleAnimation(1.0F, 1.0F, 1.0F, 0.0F, 1, 1.0F, 1, 0.0F);
      this.KdD = AnimationUtils.loadAnimation(paramContext, i.a.dropdown_up);
      AppMethodBeat.o(96098);
      return;
      Map localMap = localc.hvz();
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
    label51:
    char c;
    if (LocaleUtil.isSimplifiedChineseAppLang())
    {
      parama = parama.Kdu;
      localStringBuffer2 = new StringBuffer();
      localStringBuffer1 = new StringBuffer();
      i = 0;
      if (i >= parama.length()) {
        break label223;
      }
      c = parama.charAt(i);
      if (c != '$') {
        break label195;
      }
      if (localStringBuffer1.length() != 0) {
        break label115;
      }
      localStringBuffer1.append(c);
    }
    label195:
    for (;;)
    {
      i += 1;
      break label51;
      if (LocaleUtil.isTraditionalChineseAppLang())
      {
        parama = parama.Kdv;
        break;
      }
      parama = parama.Kdw;
      break;
      label115:
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
    label223:
    parama = localStringBuffer2.toString();
    AppMethodBeat.o(96101);
    return parama;
  }
  
  private void a(View paramView, AbsoluteLayout paramAbsoluteLayout, final com.tencent.mm.plugin.sns.data.e parame)
  {
    AppMethodBeat.i(96100);
    Object localObject1 = (ViewGroup)paramView;
    ((ViewGroup)localObject1).removeAllViews();
    if (this.KdN == null)
    {
      AppMethodBeat.o(96100);
      return;
    }
    if ((parame.JPW == null) || (parame.JPW.LeX == null))
    {
      AppMethodBeat.o(96100);
      return;
    }
    Object localObject2 = parame.JPW.LeX;
    int i = 0;
    Object localObject3 = new Paint(1);
    int n = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 12.0F);
    int i1 = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 10.0F);
    int k = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 150.0F);
    LinkedList localLinkedList = new LinkedList();
    float f = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 17.0F) * com.tencent.mm.ci.a.ez(this.mContext) + i1 * 2;
    int m = (int)f;
    int j = 0;
    while (j < this.KdN.KeB.size())
    {
      Object localObject4 = (a)this.KdN.KeB.get(j);
      final TextView localTextView = new TextView(this.mContext);
      localTextView.setPadding(n, i1, n, i1);
      localTextView.setTextSize(1, 14.0F * com.tencent.mm.ci.a.ez(this.mContext));
      localTextView.setTextColor(this.mContext.getResources().getColor(i.c.sns_abtest_unlike_text_color));
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
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/newabtest/AdNotLikeAbTestHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          int i = ((Integer)paramAnonymousView.getTag()).intValue();
          localObject = (b.b)b.a(b.this).get(Long.valueOf(parame.fWg));
          int j = ((a)b.b(b.this).KeB.get(i)).Kdt;
          if (localObject != null) {
            ((b.b)localObject).baH("3:" + j + ":" + localTextView.getText());
          }
          if (((a)b.b(b.this).KeB.get(i)).Kdx == 1)
          {
            paramAnonymousView = new Intent();
            paramAnonymousView.setClass(b.c(b.this), SnsCommentUI.class);
            paramAnonymousView.putExtra("sns_comment_type", 2);
            paramAnonymousView.putExtra("sns_id", parame.fWg);
            paramAnonymousView.putExtra("sns_uxinfo", ((b.b)localObject).uxInfo);
            paramAnonymousView.putExtra("action_st_time", ((b.b)localObject).KdX);
            paramAnonymousView.putExtra("sns_actionresult", ((b.b)localObject).KdW.toString());
            localObject = (MMActivity)b.c(b.this);
            paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b(localObject, paramAnonymousView.aFh(), "com/tencent/mm/plugin/sns/newabtest/AdNotLikeAbTestHelper$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((MMActivity)localObject).startActivity((Intent)paramAnonymousView.sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/sns/newabtest/AdNotLikeAbTestHelper$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            b.a(b.this).remove(Long.valueOf(parame.fWg));
            b.this.fQe();
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/newabtest/AdNotLikeAbTestHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(96087);
            return;
            b.this.a((b.b)localObject);
            b.this.fQe();
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
    k = com.tencent.mm.pluginsdk.h.jp(this.mContext);
    localObject1 = parame.JPW.fYf();
    n = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 2.0F);
    i1 = localObject1[0];
    int i2 = localObject1[1];
    int i3 = this.INC;
    parame = parame.JPW;
    if (parame.LeQ != null) {}
    for (i = parame.LeQ.getHeight();; i = 0)
    {
      paramAbsoluteLayout.updateViewLayout(paramView, new AbsoluteLayout.LayoutParams(-2, -2, i1 - j - n, i2 - i3 - k + m - i));
      AppMethodBeat.o(96100);
      return;
    }
  }
  
  public final void a(int paramInt, String paramString, long paramLong, TimeLineObject paramTimeLineObject, boolean paramBoolean)
  {
    AppMethodBeat.i(96096);
    if ((paramBoolean) && (this.fzO))
    {
      if (this.KdM.contains(Long.valueOf(paramLong)))
      {
        paramBoolean = false;
        if (this.KdO.containsKey(Long.valueOf(paramLong))) {
          paramBoolean = ((Boolean)this.KdO.get(Long.valueOf(paramLong))).booleanValue();
        }
        if (paramBoolean)
        {
          paramString = (b)this.KdL.get(Long.valueOf(paramLong));
          if (paramString != null) {
            paramString.report();
          }
        }
      }
      this.KdL.remove(Long.valueOf(paramLong));
      this.KdM.remove(Long.valueOf(paramLong));
    }
    AppMethodBeat.o(96096);
  }
  
  public final void a(int paramInt, String paramString, long paramLong, TimeLineObject paramTimeLineObject, boolean paramBoolean, bt parambt)
  {
    AppMethodBeat.i(96095);
    if ((paramBoolean) && (this.fzO) && (this.KdN != null) && (parambt != null))
    {
      this.KdM.add(Long.valueOf(paramLong));
      paramString = new b(paramLong, this.KdN.KdZ, this.KdN.Kea, parambt.dug());
      this.KdL.put(Long.valueOf(paramLong), paramString);
    }
    AppMethodBeat.o(96095);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(96097);
    this.KdK.remove(Long.valueOf(paramb.JEb));
    paramb.report();
    AppMethodBeat.o(96097);
  }
  
  public final boolean fQe()
  {
    AppMethodBeat.i(96102);
    if (this.KdB != null)
    {
      Object localObject;
      if ((this.KdB.getTag() instanceof a))
      {
        localObject = (a)this.KdB.getTag();
        localObject = (b)this.KdK.get(Long.valueOf(((a)localObject).fWg));
        if (localObject != null)
        {
          if (!((b)localObject).fQg()) {
            break label111;
          }
          if (((b)localObject).fQf()) {
            ((b)localObject).baH("2:0:");
          }
          a((b)localObject);
        }
      }
      for (;;)
      {
        this.KdA.removeView(this.KdB);
        this.KdB = null;
        AppMethodBeat.o(96102);
        return true;
        label111:
        ((b)localObject).baH("2:0:");
        a((b)localObject);
      }
    }
    this.KdE = false;
    AppMethodBeat.o(96102);
    return false;
  }
  
  public final int gr(final View paramView)
  {
    AppMethodBeat.i(96099);
    if (this.KdE)
    {
      AppMethodBeat.o(96099);
      return 0;
    }
    if (this.KdB != null)
    {
      if ((this.KdB.getTag() instanceof a))
      {
        paramView = ((a)this.KdB.getTag()).GiP;
        this.KdE = true;
        paramView.startAnimation(this.KdD);
        this.KdD.setAnimationListener(new Animation.AnimationListener()
        {
          public final void onAnimationEnd(Animation paramAnonymousAnimation)
          {
            AppMethodBeat.i(96088);
            if (paramView != null)
            {
              paramView.clearAnimation();
              paramView.setVisibility(8);
              b.this.fQe();
            }
            b.a(b.this, false);
            AppMethodBeat.o(96088);
          }
          
          public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
          
          public final void onAnimationStart(Animation paramAnonymousAnimation)
          {
            AppMethodBeat.i(267319);
            b.a(b.this, true);
            AppMethodBeat.o(267319);
          }
        });
      }
      for (;;)
      {
        AppMethodBeat.o(96099);
        return 0;
        fQe();
      }
    }
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof com.tencent.mm.plugin.sns.data.e)))
    {
      AppMethodBeat.o(96099);
      return 0;
    }
    if ((!this.fzO) || (this.KdN == null))
    {
      AppMethodBeat.o(96099);
      return 2;
    }
    Object localObject1 = (com.tencent.mm.plugin.sns.data.e)paramView.getTag();
    long l = ((com.tencent.mm.plugin.sns.data.e)localObject1).fWg;
    Object localObject2 = ((com.tencent.mm.plugin.sns.data.e)localObject1).JPW.LeX;
    boolean bool;
    if (this.KdO.containsKey(Long.valueOf(l))) {
      bool = ((Boolean)this.KdO.get(Long.valueOf(l))).booleanValue();
    }
    while (!bool)
    {
      AppMethodBeat.o(96099);
      return 2;
      if (this.KdN == null)
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
          if (i >= this.KdN.KeB.size()) {
            break label322;
          }
          if (Util.isNullOrNil(a((a)this.KdN.KeB.get(i), ((ADXml)localObject2).adArgs)))
          {
            this.KdO.put(Long.valueOf(l), Boolean.FALSE);
            bool = false;
            break;
          }
          i += 1;
        }
        label322:
        this.KdO.put(Long.valueOf(l), Boolean.TRUE);
        bool = true;
      }
    }
    localObject2 = ((com.tencent.mm.plugin.sns.data.e)localObject1).fAg;
    Object localObject3 = new b(((com.tencent.mm.plugin.sns.data.e)localObject1).fWg, ((com.tencent.mm.plugin.sns.data.e)localObject1).JPW.dug(), this.KdN.KdZ, this.KdN.Kea, this.mContext.getString(i.j.sns_ad_tip));
    this.KdK.put(Long.valueOf(((com.tencent.mm.plugin.sns.data.e)localObject1).fWg), localObject3);
    if (this.KdM.contains(Long.valueOf(((com.tencent.mm.plugin.sns.data.e)localObject1).fWg))) {
      this.KdM.remove(Long.valueOf(((com.tencent.mm.plugin.sns.data.e)localObject1).fWg));
    }
    this.KdB = new AbsoluteLayout(this.mContext);
    this.KdB.setId(i.f.address);
    new FrameLayout.LayoutParams(-1, -1);
    this.KdA.addView(this.KdB);
    localObject3 = ad.kS(this.mContext).inflate(i.g.adabtest_unlike_tip, null);
    Object localObject4 = new TextView[3];
    ImageView[] arrayOfImageView = new ImageView[3];
    localObject4[0] = ((TextView)((View)localObject3).findViewById(i.f.ad_unlike_btn_one));
    localObject4[1] = ((TextView)((View)localObject3).findViewById(i.f.ad_unlike_btn_two));
    localObject4[2] = ((TextView)((View)localObject3).findViewById(i.f.ad_unlike_btn_three));
    arrayOfImageView[0] = ((ImageView)((View)localObject3).findViewById(i.f.ad_unlike_btn_right_one));
    arrayOfImageView[1] = ((ImageView)((View)localObject3).findViewById(i.f.ad_unlike_btn_right_two));
    arrayOfImageView[2] = ((ImageView)((View)localObject3).findViewById(i.f.ad_unlike_btn_right_three));
    int j = 0;
    int i = 0;
    if (!v.QH(((com.tencent.mm.plugin.sns.data.e)localObject1).fWg))
    {
      k = 0;
      for (;;)
      {
        j = i;
        if (k >= this.KdI.length) {
          break;
        }
        j = i;
        if (this.KdI[k] == 3) {
          j = i + 1;
        }
        k += 1;
        i = j;
      }
    }
    int k = 0;
    i = 0;
    while (i < this.KdI.length)
    {
      m = k;
      if (this.KdI[i] == 0) {
        m = k + 1;
      }
      i += 1;
      k = m;
    }
    if (k + j > 0)
    {
      i = this.KdI.length - k - j;
      if (i == 0)
      {
        AppMethodBeat.o(96099);
        return 2;
      }
    }
    for (this.KdJ = new int[i];; this.KdJ = new int[this.KdI.length])
    {
      i = 0;
      for (k = 0; i < this.KdI.length; k = m)
      {
        m = k;
        if (this.KdI[i] != 0) {
          if (j > 0)
          {
            m = k;
            if (this.KdI[i] == 3) {}
          }
          else
          {
            this.KdJ[k] = this.KdI[i];
            m = k + 1;
          }
        }
        i += 1;
      }
    }
    if (v.QG(((com.tencent.mm.plugin.sns.data.e)localObject1).fWg))
    {
      i = 0;
      if (i < this.KdJ.length)
      {
        if (this.KdJ[i] != 3) {
          break label1130;
        }
        this.KdJ[i] = 4;
      }
    }
    i = 0;
    int m = com.tencent.mm.ci.a.fromDPToPix(this.mContext, 12);
    int n = com.tencent.mm.ci.a.fromDPToPix(this.mContext, 8);
    int i1 = com.tencent.mm.ci.a.fromDPToPix(this.mContext, 12);
    j = 0;
    label919:
    final int i2;
    int i3;
    if (j < this.KdJ.length)
    {
      i2 = this.KdJ[j];
      i3 = this.KdJ[j] - 1;
      localObject4[j].setText(this.KdH[i3]);
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
      localObject4[j].setCompoundDrawablePadding(com.tencent.mm.ci.a.fromDPToPix(this.mContext, 8));
      localObject4[j].setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(this.KdG[i3]), null, null, null);
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
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/newabtest/AdNotLikeAbTestHelper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            b.a(b.this, i2, this.KdQ, this.KdR, b.this.KdB);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/newabtest/AdNotLikeAbTestHelper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(96085);
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
      while (j < this.KdJ.length)
      {
        localObject4[j].setMaxWidth(i);
        j += 1;
      }
      j = this.KdJ.length;
      while (j < 3)
      {
        localObject4[j].setVisibility(8);
        j += 1;
      }
      new Rect();
      j = com.tencent.mm.pluginsdk.h.jp(this.mContext);
      localObject4 = ((com.tencent.mm.plugin.sns.data.e)localObject1).JPW.fYf();
      Log.d("MicroMsg.AdNotLikeAbTestHelper", "addCommentView getLocationInWindow " + localObject4[0] + "  " + localObject4[1] + " height: " + j);
      i += com.tencent.mm.ci.a.fromDPToPix(this.mContext, 12);
      k = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 17.0F);
      m = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 2.0F);
      this.INC = ar.kI(this.mContext);
      localObject4 = new AbsoluteLayout.LayoutParams(i, -2, localObject4[0] - i - m, localObject4[1] - this.INC - j + k);
      localObject1 = new a((String)localObject2, (View)localObject3, ((com.tencent.mm.plugin.sns.data.e)localObject1).fWg, ((com.tencent.mm.plugin.sns.data.e)localObject1).JPW.LeX);
      this.KdB.setTag(localObject1);
      this.KdB.addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
      ((View)localObject3).setVisibility(8);
      this.KdE = true;
      new MMHandler().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(96086);
          b.a(b.this, paramView, this.KdR);
          AppMethodBeat.o(96086);
        }
      });
      AppMethodBeat.o(96099);
      return 1;
    }
  }
  
  final class a
  {
    View GiP = null;
    String KdU;
    ADXml KdV;
    long fWg;
    
    public a(String paramString, View paramView, long paramLong, ADXml paramADXml)
    {
      this.KdU = paramString;
      this.GiP = paramView;
      this.KdV = paramADXml;
      this.fWg = paramLong;
    }
  }
  
  static final class b
  {
    long JEb;
    StringBuffer KdW;
    long KdX;
    long KdY;
    String KdZ;
    String Kea;
    String uxInfo;
    
    public b(long paramLong, String paramString1, String paramString2, String paramString3)
    {
      AppMethodBeat.i(96090);
      this.KdW = new StringBuffer();
      this.uxInfo = paramString1;
      this.KdZ = paramString2;
      this.Kea = paramString3;
      this.JEb = paramLong;
      this.KdX = System.currentTimeMillis();
      this.KdW.append("0:0:");
      AppMethodBeat.o(96090);
    }
    
    public b(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4)
    {
      AppMethodBeat.i(96089);
      this.KdW = new StringBuffer();
      this.uxInfo = paramString1;
      this.KdZ = paramString2;
      this.Kea = paramString3;
      this.JEb = paramLong;
      this.KdX = System.currentTimeMillis();
      this.KdW.append("1:0:".concat(String.valueOf(paramString4)));
      AppMethodBeat.o(96089);
    }
    
    public final void baH(String paramString)
    {
      AppMethodBeat.i(96091);
      Log.d("MicroMsg.AdNotLikeAbTestHelper", "addactionResult ".concat(String.valueOf(paramString)));
      if (this.KdW.length() != 0) {
        this.KdW.append("|");
      }
      this.KdW.append(paramString);
      AppMethodBeat.o(96091);
    }
    
    public final boolean fQf()
    {
      AppMethodBeat.i(96092);
      if ((this.KdW == null) || (this.KdW.length() == 0))
      {
        AppMethodBeat.o(96092);
        return false;
      }
      if (this.KdW.toString().startsWith("1:0"))
      {
        AppMethodBeat.o(96092);
        return true;
      }
      AppMethodBeat.o(96092);
      return false;
    }
    
    public final boolean fQg()
    {
      AppMethodBeat.i(96093);
      if ((this.KdW == null) || (this.KdW.length() == 0))
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
      this.KdY = System.currentTimeMillis();
      Log.d("MicroMsg.AdNotLikeAbTestHelper", "report abtestnotlike " + this.JEb + " uxinfo:" + this.uxInfo + " actionresult: " + this.KdW + " " + this.KdX + " " + this.KdY);
      com.tencent.mm.plugin.report.service.h.IzE.a(11988, new Object[] { this.Kea, this.KdZ, "", "", t.Qu(this.JEb), this.uxInfo, this.KdW, Long.valueOf(this.KdX / 1000L), Long.valueOf(this.KdY / 1000L) });
      AppMethodBeat.o(96094);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.h.b
 * JD-Core Version:    0.7.0.1
 */