package com.tencent.mm.plugin.sns.f;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
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
import com.tencent.mm.plugin.sns.i.a;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.u;
import com.tencent.mm.plugin.sns.ui.be;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.d;
import com.tencent.mm.ui.ak;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class b
  implements com.tencent.mm.plugin.sns.model.e
{
  private boolean bJy = true;
  Context mContext;
  private int olg = -1;
  protected Animation ovA;
  protected Animation ovB;
  boolean ovC = false;
  int[] ovD = { i.j.sns_ad_abtest_001, i.j.sns_ad_abtest_002, i.j.sns_ad_abtest_003, i.j.sns_ad_abtest_004 };
  private int[] ovE = { i.i.album_test_donotlook, i.i.album_test_unlike, i.i.album_test_open, i.i.album_test_close };
  private int[] ovF = this.ovD;
  private int[] ovG;
  private int[] ovH;
  Map<Long, b.b> ovI = new HashMap();
  private Map<Long, b.b> ovJ = new HashMap();
  private HashSet<Long> ovK = new HashSet();
  h ovL = null;
  private HashMap<Long, Boolean> ovM = new HashMap();
  public final int ovw = 14;
  private com.tencent.mm.plugin.sns.ui.d.b ovx;
  private FrameLayout ovy;
  AbsoluteLayout ovz = null;
  
  public b(Context paramContext, com.tencent.mm.plugin.sns.ui.d.b paramb, FrameLayout paramFrameLayout)
  {
    g localg = af.bDx();
    h localh2 = new h();
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.c.IX().fJ("100007");
    h localh1;
    if (!localc.isValid())
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SnsABTestStrategy", "abtest is invalid");
      localh1 = null;
    }
    for (;;)
    {
      localg.owM = localh1;
      this.ovL = af.bDx().bEz();
      if (this.ovL != null)
      {
        this.ovG = this.ovL.owO;
        if (!this.ovL.bEA()) {
          this.bJy = false;
        }
      }
      this.mContext = paramContext;
      this.ovx = paramb;
      this.ovy = paramFrameLayout;
      this.ovA = new ScaleAnimation(1.0F, 1.0F, 0.0F, 1.0F, 1, 1.0F, 1, 0.0F);
      this.ovA = AnimationUtils.loadAnimation(paramContext, i.a.dropdown_down);
      this.ovB = new ScaleAnimation(1.0F, 1.0F, 1.0F, 0.0F, 1, 1.0F, 1, 0.0F);
      this.ovB = AnimationUtils.loadAnimation(paramContext, i.a.dropdown_up);
      return;
      Map localMap = localc.ctr();
      localh1 = localh2;
      if (localMap != null)
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SnsABTestStrategy", "snsabtest feed " + localc.field_expId + " " + localc.field_layerId + " " + localc.field_startTime + " " + localc.field_endTime);
        localh2.e(localc.field_layerId, localc.field_expId, localMap);
        localh1 = localh2;
      }
    }
  }
  
  private static String a(a parama, Map<String, String> paramMap)
  {
    if (parama == null) {
      return "";
    }
    StringBuffer localStringBuffer2;
    StringBuffer localStringBuffer1;
    int i;
    label38:
    char c;
    if (x.cqG())
    {
      parama = parama.ovs;
      localStringBuffer2 = new StringBuffer();
      localStringBuffer1 = new StringBuffer();
      i = 0;
      if (i >= parama.length()) {
        break label203;
      }
      c = parama.charAt(i);
      if (c != '$') {
        break label175;
      }
      if (localStringBuffer1.length() != 0) {
        break label102;
      }
      localStringBuffer1.append(c);
    }
    label175:
    for (;;)
    {
      i += 1;
      break label38;
      if (x.cqH())
      {
        parama = parama.ovt;
        break;
      }
      parama = parama.ovu;
      break;
      label102:
      if (localStringBuffer1.charAt(localStringBuffer1.length() - 1) == '$')
      {
        localStringBuffer2.append('$');
        localStringBuffer1 = new StringBuffer();
      }
      else
      {
        String str = (String)paramMap.get(localStringBuffer1.substring(1));
        if (str == null) {
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
    label203:
    return localStringBuffer2.toString();
  }
  
  public final void a(int paramInt, String paramString, long paramLong, bxk parambxk, boolean paramBoolean)
  {
    if ((paramBoolean) && (this.bJy))
    {
      if (this.ovK.contains(Long.valueOf(paramLong)))
      {
        paramBoolean = false;
        if (this.ovM.containsKey(Long.valueOf(paramLong))) {
          paramBoolean = ((Boolean)this.ovM.get(Long.valueOf(paramLong))).booleanValue();
        }
        if (paramBoolean)
        {
          paramString = (b.b)this.ovJ.get(Long.valueOf(paramLong));
          if (paramString != null) {
            paramString.wn();
          }
        }
      }
      this.ovJ.remove(Long.valueOf(paramLong));
      this.ovK.remove(Long.valueOf(paramLong));
    }
  }
  
  public final void a(int paramInt, String paramString, long paramLong, bxk parambxk, boolean paramBoolean, be parambe)
  {
    if ((paramBoolean) && (this.bJy) && (this.ovL != null) && (parambe != null))
    {
      this.ovK.add(Long.valueOf(paramLong));
      paramString = new b.b(paramLong, this.ovL.ovY, this.ovL.ovZ, parambe.bKe());
      this.ovJ.put(Long.valueOf(paramLong), paramString);
    }
  }
  
  final void a(View paramView, AbsoluteLayout paramAbsoluteLayout, com.tencent.mm.plugin.sns.data.b paramb)
  {
    Object localObject1 = (ViewGroup)paramView;
    ((ViewGroup)localObject1).removeAllViews();
    if (this.ovL == null) {}
    while ((paramb.omM == null) || (paramb.omM.pjM == null)) {
      return;
    }
    Object localObject2 = paramb.omM.pjM;
    int i = 0;
    Object localObject3 = new Paint(1);
    int n = BackwardSupportUtil.b.b(this.mContext, 12.0F);
    int i1 = BackwardSupportUtil.b.b(this.mContext, 10.0F);
    int k = BackwardSupportUtil.b.b(this.mContext, 150.0F);
    LinkedList localLinkedList = new LinkedList();
    float f = BackwardSupportUtil.b.b(this.mContext, 17.0F) * com.tencent.mm.cb.a.cJ(this.mContext) + i1 * 2;
    int m = (int)f;
    int j = 0;
    while (j < this.ovL.owB.size())
    {
      Object localObject4 = (a)this.ovL.owB.get(j);
      TextView localTextView = new TextView(this.mContext);
      localTextView.setPadding(n, i1, n, i1);
      localTextView.setTextSize(1, 14.0F * com.tencent.mm.cb.a.cJ(this.mContext));
      localTextView.setTextColor(this.mContext.getResources().getColor(i.c.sns_abtest_unlike_text_color));
      localObject4 = a((a)localObject4, ((com.tencent.mm.plugin.sns.storage.b)localObject2).oBd);
      localTextView.setText((CharSequence)localObject4);
      ((Paint)localObject3).setTextSize(localTextView.getTextSize());
      ((ViewGroup)localObject1).addView(localTextView);
      i = Math.max(i, (int)((Paint)localObject3).measureText((String)localObject4) + n * 2);
      localTextView.setTag(Integer.valueOf(j));
      localLinkedList.add(localTextView);
      localTextView.setOnClickListener(new b.3(this, paramb, localTextView));
      j += 1;
    }
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.AdNotLikeAbTestHelper", "w h " + i + " " + m);
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
    k = com.tencent.mm.pluginsdk.e.eK(this.mContext);
    localObject1 = paramb.omM.bKf();
    n = BackwardSupportUtil.b.b(this.mContext, 2.0F);
    i1 = localObject1[0];
    int i2 = localObject1[1];
    int i3 = this.olg;
    paramb = paramb.omM;
    if (paramb.pjI != null) {}
    for (i = paramb.pjI.getHeight();; i = 0)
    {
      paramAbsoluteLayout.updateViewLayout(paramView, new AbsoluteLayout.LayoutParams(-2, -2, i1 - j - n, i2 - i3 - k + m - i));
      return;
    }
  }
  
  public final void a(b.b paramb)
  {
    this.ovI.remove(Long.valueOf(paramb.okm));
    paramb.wn();
  }
  
  public final boolean bEx()
  {
    int j = 0;
    if (this.ovz != null)
    {
      Object localObject;
      int i;
      if ((this.ovz.getTag() instanceof a))
      {
        localObject = (a)this.ovz.getTag();
        localObject = (b.b)this.ovI.get(Long.valueOf(((a)localObject).eAA));
        if (localObject != null)
        {
          if ((((b.b)localObject).ovU != null) && (((b.b)localObject).ovU.length() != 0)) {
            break label135;
          }
          i = 0;
          if (i == 0) {
            break label163;
          }
          i = j;
          if (((b.b)localObject).ovU != null)
          {
            if (((b.b)localObject).ovU.length() != 0) {
              break label140;
            }
            i = j;
          }
          label101:
          if (i != 0) {
            ((b.b)localObject).Of("2:0:");
          }
          a((b.b)localObject);
        }
      }
      for (;;)
      {
        this.ovy.removeView(this.ovz);
        this.ovz = null;
        return true;
        label135:
        i = 1;
        break;
        label140:
        i = j;
        if (!((b.b)localObject).ovU.toString().startsWith("1:0")) {
          break label101;
        }
        i = 1;
        break label101;
        label163:
        ((b.b)localObject).Of("2:0:");
        a((b.b)localObject);
      }
    }
    this.ovC = false;
    return false;
  }
  
  public final int cP(final View paramView)
  {
    if (this.ovC) {
      return 0;
    }
    if (this.ovz != null)
    {
      if ((this.ovz.getTag() instanceof a))
      {
        paramView = ((a)this.ovz.getTag()).okf;
        this.ovC = true;
        paramView.startAnimation(this.ovB);
        this.ovB.setAnimationListener(new Animation.AnimationListener()
        {
          public final void onAnimationEnd(Animation paramAnonymousAnimation)
          {
            if (paramView != null)
            {
              paramView.clearAnimation();
              paramView.setVisibility(8);
              b.this.bEx();
            }
            b.this.ovC = false;
          }
          
          public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
          
          public final void onAnimationStart(Animation paramAnonymousAnimation)
          {
            b.this.ovC = true;
          }
        });
      }
      for (;;)
      {
        return 0;
        bEx();
      }
    }
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof com.tencent.mm.plugin.sns.data.b))) {
      return 0;
    }
    if ((!this.bJy) || (this.ovL == null)) {
      return 2;
    }
    Object localObject1 = (com.tencent.mm.plugin.sns.data.b)paramView.getTag();
    long l = ((com.tencent.mm.plugin.sns.data.b)localObject1).eAA;
    Object localObject2 = ((com.tencent.mm.plugin.sns.data.b)localObject1).omM.pjM;
    boolean bool;
    if (this.ovM.containsKey(Long.valueOf(l))) {
      bool = ((Boolean)this.ovM.get(Long.valueOf(l))).booleanValue();
    }
    while (!bool)
    {
      return 2;
      if (this.ovL == null)
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
          if (i >= this.ovL.owB.size()) {
            break label287;
          }
          if (bk.bl(a((a)this.ovL.owB.get(i), ((com.tencent.mm.plugin.sns.storage.b)localObject2).oBd)))
          {
            this.ovM.put(Long.valueOf(l), Boolean.valueOf(false));
            bool = false;
            break;
          }
          i += 1;
        }
        label287:
        this.ovM.put(Long.valueOf(l), Boolean.valueOf(true));
        bool = true;
      }
    }
    localObject2 = ((com.tencent.mm.plugin.sns.data.b)localObject1).bJQ;
    Object localObject3 = new b.b(((com.tencent.mm.plugin.sns.data.b)localObject1).eAA, ((com.tencent.mm.plugin.sns.data.b)localObject1).omM.bKe(), this.ovL.ovY, this.ovL.ovZ, this.mContext.getString(i.j.sns_ad_tip));
    this.ovI.put(Long.valueOf(((com.tencent.mm.plugin.sns.data.b)localObject1).eAA), localObject3);
    if (this.ovK.contains(Long.valueOf(((com.tencent.mm.plugin.sns.data.b)localObject1).eAA))) {
      this.ovK.remove(Long.valueOf(((com.tencent.mm.plugin.sns.data.b)localObject1).eAA));
    }
    this.ovz = new AbsoluteLayout(this.mContext);
    this.ovz.setId(i.f.address);
    new FrameLayout.LayoutParams(-1, -1);
    this.ovy.addView(this.ovz);
    localObject3 = com.tencent.mm.ui.y.gt(this.mContext).inflate(i.g.adabtest_unlike_tip, null);
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
    if (!u.ga(((com.tencent.mm.plugin.sns.data.b)localObject1).eAA))
    {
      k = 0;
      for (;;)
      {
        j = i;
        if (k >= this.ovG.length) {
          break;
        }
        j = i;
        if (this.ovG[k] == 3) {
          j = i + 1;
        }
        k += 1;
        i = j;
      }
    }
    int k = 0;
    i = 0;
    while (i < this.ovG.length)
    {
      m = k;
      if (this.ovG[i] == 0) {
        m = k + 1;
      }
      i += 1;
      k = m;
    }
    if (k + j > 0)
    {
      i = this.ovG.length - k - j;
      if (i == 0) {
        return 2;
      }
    }
    for (this.ovH = new int[i];; this.ovH = new int[this.ovG.length])
    {
      i = 0;
      for (k = 0; i < this.ovG.length; k = m)
      {
        m = k;
        if (this.ovG[i] != 0) {
          if (j > 0)
          {
            m = k;
            if (this.ovG[i] == 3) {}
          }
          else
          {
            this.ovH[k] = this.ovG[i];
            m = k + 1;
          }
        }
        i += 1;
      }
    }
    if (u.fZ(((com.tencent.mm.plugin.sns.data.b)localObject1).eAA))
    {
      i = 0;
      if (i < this.ovH.length)
      {
        if (this.ovH[i] != 3) {
          break label1090;
        }
        this.ovH[i] = 4;
      }
    }
    i = 0;
    int m = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 12);
    int n = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 8);
    int i1 = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 12);
    j = 0;
    label879:
    int i2;
    int i3;
    if (j < this.ovH.length)
    {
      i2 = this.ovH[j];
      i3 = this.ovH[j] - 1;
      localObject4[j].setText(this.ovF[i3]);
      Object localObject5 = localObject4[j];
      Paint localPaint = new Paint();
      String str = localObject5.getText().toString();
      localPaint.setTextSize(localObject5.getTextSize());
      k = (int)localPaint.measureText(str, 0, str.length()) + (m * 2 + n * 2 + i1);
      if (k <= i) {
        break label1400;
      }
      i = k;
    }
    label1090:
    label1400:
    for (;;)
    {
      localObject4[j].setCompoundDrawablePadding(com.tencent.mm.cb.a.fromDPToPix(this.mContext, 8));
      localObject4[j].setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(this.ovE[i3]), null, null, null);
      if (i3 == 1) {
        arrayOfImageView[j].setVisibility(0);
      }
      for (;;)
      {
        localObject4[j].setTag(localObject1);
        localObject4[j].setOnClickListener(new b.1(this, i2, (com.tencent.mm.plugin.sns.data.b)localObject1, (View)localObject3, paramView));
        j += 1;
        break label879;
        i += 1;
        break;
        arrayOfImageView[j].setVisibility(8);
      }
      j = 0;
      while (j < this.ovH.length)
      {
        localObject4[j].setMaxWidth(i);
        j += 1;
      }
      j = this.ovH.length;
      while (j < 3)
      {
        localObject4[j].setVisibility(8);
        j += 1;
      }
      new Rect();
      j = com.tencent.mm.pluginsdk.e.eK(this.mContext);
      localObject4 = ((com.tencent.mm.plugin.sns.data.b)localObject1).omM.bKf();
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.AdNotLikeAbTestHelper", "addCommentView getLocationInWindow " + localObject4[0] + "  " + localObject4[1] + " height: " + j);
      i += com.tencent.mm.cb.a.fromDPToPix(this.mContext, 12);
      k = BackwardSupportUtil.b.b(this.mContext, 17.0F);
      m = BackwardSupportUtil.b.b(this.mContext, 2.0F);
      this.olg = ak.gz(this.mContext);
      localObject4 = new AbsoluteLayout.LayoutParams(i, -2, localObject4[0] - i - m, localObject4[1] - this.olg - j + k);
      localObject1 = new a((String)localObject2, (View)localObject3, ((com.tencent.mm.plugin.sns.data.b)localObject1).eAA, ((com.tencent.mm.plugin.sns.data.b)localObject1).omM.pjM);
      this.ovz.setTag(localObject1);
      this.ovz.addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
      ((View)localObject3).setVisibility(8);
      this.ovC = true;
      new ah().post(new b.2(this, paramView, (View)localObject3));
      return 1;
    }
  }
  
  final class a
  {
    long eAA;
    View okf = null;
    String ovS;
    com.tencent.mm.plugin.sns.storage.b ovT;
    
    public a(String paramString, View paramView, long paramLong, com.tencent.mm.plugin.sns.storage.b paramb)
    {
      this.ovS = paramString;
      this.okf = paramView;
      this.ovT = paramb;
      this.eAA = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.f.b
 * JD-Core Version:    0.7.0.1
 */