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
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.v;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.ui.SnsCommentUI;
import com.tencent.mm.plugin.sns.ui.bu;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.aw;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class b
  implements com.tencent.mm.plugin.sns.model.e
{
  public final int QBe;
  private com.tencent.mm.plugin.sns.ui.listener.c QBf;
  private FrameLayout QBg;
  AbsoluteLayout QBh;
  protected Animation QBi;
  protected Animation QBj;
  private boolean QBk;
  private int[] QBl;
  private int[] QBm;
  private int[] QBn;
  private int[] QBo;
  private int[] QBp;
  private Map<Long, b> QBq;
  private Map<Long, b> QBr;
  private HashSet<Long> QBs;
  private h QBt;
  private HashMap<Long, Boolean> QBu;
  private boolean hEn;
  private Context mContext;
  private int vpn;
  
  public b(Context paramContext, com.tencent.mm.plugin.sns.ui.listener.c paramc, FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(96098);
    this.QBe = 14;
    this.QBh = null;
    this.QBk = false;
    this.QBl = new int[] { b.j.sns_ad_abtest_001, b.j.sns_ad_abtest_002, b.j.sns_ad_abtest_003, b.j.sns_ad_abtest_004 };
    this.QBm = new int[] { b.i.album_test_donotlook, b.i.album_test_unlike, b.i.album_test_open, b.i.album_test_close };
    this.QBn = this.QBl;
    this.hEn = true;
    this.QBq = new HashMap();
    this.QBr = new HashMap();
    this.QBs = new HashSet();
    this.QBt = null;
    this.QBu = new HashMap();
    this.vpn = -1;
    g localg = al.hgt();
    h localh2 = new h();
    com.tencent.mm.storage.c localc = com.tencent.mm.model.newabtest.d.bEt().Fd("100007");
    h localh1;
    if (localc == null)
    {
      Log.i("MicroMsg.SnsABTestStrategy", "abtest is null");
      localh1 = null;
    }
    for (;;)
    {
      localg.QCr = localh1;
      this.QBt = al.hgt().hif();
      if (this.QBt != null)
      {
        this.QBo = this.QBt.QCt;
        if (!this.QBt.hig()) {
          this.hEn = false;
        }
      }
      this.mContext = paramContext;
      this.QBf = paramc;
      this.QBg = paramFrameLayout;
      this.QBi = new ScaleAnimation(1.0F, 1.0F, 0.0F, 1.0F, 1, 1.0F, 1, 0.0F);
      this.QBi = AnimationUtils.loadAnimation(paramContext, com.tencent.mm.plugin.sns.b.a.dropdown_down);
      this.QBj = new ScaleAnimation(1.0F, 1.0F, 1.0F, 0.0F, 1, 1.0F, 1, 0.0F);
      this.QBj = AnimationUtils.loadAnimation(paramContext, com.tencent.mm.plugin.sns.b.a.dropdown_up);
      AppMethodBeat.o(96098);
      return;
      if (!localc.isValid())
      {
        Log.i("MicroMsg.SnsABTestStrategy", "abtest is invalid");
        localh1 = null;
      }
      else
      {
        Map localMap = localc.iWZ();
        localh1 = localh2;
        if (localMap != null)
        {
          Log.i("MicroMsg.SnsABTestStrategy", "snsabtest feed " + localc.field_expId + " " + localc.field_layerId + " " + localc.field_startTime + " " + localc.field_endTime);
          localh2.f(localc.field_layerId, localc.field_expId, localMap);
          localh1 = localh2;
        }
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
      parama = parama.QBa;
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
        parama = parama.QBb;
        break;
      }
      parama = parama.QBc;
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
    if (this.QBt == null)
    {
      AppMethodBeat.o(96100);
      return;
    }
    if ((parame.QmD == null) || (parame.QmD.RFh == null))
    {
      AppMethodBeat.o(96100);
      return;
    }
    Object localObject2 = parame.QmD.RFh;
    int i = 0;
    Object localObject3 = new Paint(1);
    int n = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 12.0F);
    int i1 = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 10.0F);
    int k = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 150.0F);
    LinkedList localLinkedList = new LinkedList();
    int m = (int)(BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 17.0F) * com.tencent.mm.cd.a.getScaleSize(this.mContext) + i1 * 2);
    int j = 0;
    while (j < this.QBt.QCg.size())
    {
      Object localObject4 = (a)this.QBt.QCg.get(j);
      final TextView localTextView = new TextView(this.mContext);
      localTextView.setPadding(n, i1, n, i1);
      localTextView.setTextSize(1, 14.0F * com.tencent.mm.cd.a.getScaleSize(this.mContext));
      localTextView.setTextColor(this.mContext.getResources().getColor(b.c.sns_abtest_unlike_text_color));
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
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/newabtest/AdNotLikeAbTestHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          int i = ((Integer)paramAnonymousView.getTag()).intValue();
          localObject = (b.b)b.a(b.this).get(Long.valueOf(parame.ibq));
          int j = ((a)b.b(b.this).QCg.get(i)).QAZ;
          if (localObject != null) {
            ((b.b)localObject).aZe("3:" + j + ":" + localTextView.getText());
          }
          if (((a)b.b(b.this).QCg.get(i)).QBd == 1)
          {
            paramAnonymousView = new Intent();
            paramAnonymousView.setClass(b.c(b.this), SnsCommentUI.class);
            paramAnonymousView.putExtra("sns_comment_type", 2);
            paramAnonymousView.putExtra("sns_id", parame.ibq);
            paramAnonymousView.putExtra("sns_uxinfo", ((b.b)localObject).uxInfo);
            paramAnonymousView.putExtra("action_st_time", ((b.b)localObject).QBD);
            paramAnonymousView.putExtra("sns_actionresult", ((b.b)localObject).QBC.toString());
            localObject = (MMActivity)b.c(b.this);
            paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b(localObject, paramAnonymousView.aYi(), "com/tencent/mm/plugin/sns/newabtest/AdNotLikeAbTestHelper$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((MMActivity)localObject).startActivity((Intent)paramAnonymousView.sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/sns/newabtest/AdNotLikeAbTestHelper$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            b.a(b.this).remove(Long.valueOf(parame.ibq));
            b.this.hib();
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/newabtest/AdNotLikeAbTestHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(96087);
            return;
            b.this.a((b.b)localObject);
            b.this.hib();
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
      ((ViewGroup.LayoutParams)localObject3).height = m;
      ((TextView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
    }
    new Rect();
    k = com.tencent.mm.pluginsdk.h.lm(this.mContext);
    localObject1 = parame.QmD.hqD();
    n = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 2.0F);
    i1 = localObject1[0];
    int i2 = localObject1[1];
    int i3 = this.vpn;
    parame = parame.QmD;
    if (parame.RFa != null) {}
    for (i = parame.RFa.getHeight();; i = 0)
    {
      paramAbsoluteLayout.updateViewLayout(paramView, new AbsoluteLayout.LayoutParams(-2, -2, i1 - j - n, i2 - i3 - k + m - i));
      AppMethodBeat.o(96100);
      return;
    }
  }
  
  public final void a(int paramInt, String paramString, long paramLong, TimeLineObject paramTimeLineObject, boolean paramBoolean)
  {
    AppMethodBeat.i(96096);
    if ((paramBoolean) && (this.hEn))
    {
      if (this.QBs.contains(Long.valueOf(paramLong)))
      {
        paramBoolean = false;
        if (this.QBu.containsKey(Long.valueOf(paramLong))) {
          paramBoolean = ((Boolean)this.QBu.get(Long.valueOf(paramLong))).booleanValue();
        }
        if (paramBoolean)
        {
          paramString = (b)this.QBr.get(Long.valueOf(paramLong));
          if (paramString != null) {
            paramString.report();
          }
        }
      }
      this.QBr.remove(Long.valueOf(paramLong));
      this.QBs.remove(Long.valueOf(paramLong));
    }
    AppMethodBeat.o(96096);
  }
  
  public final void a(int paramInt, String paramString, long paramLong, TimeLineObject paramTimeLineObject, boolean paramBoolean, bu parambu)
  {
    AppMethodBeat.i(96095);
    if ((paramBoolean) && (this.hEn) && (this.QBt != null) && (parambu != null))
    {
      this.QBs.add(Long.valueOf(paramLong));
      paramString = new b(paramLong, this.QBt.QBF, this.QBt.sdF, parambu.edF());
      this.QBr.put(Long.valueOf(paramLong), paramString);
    }
    AppMethodBeat.o(96095);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(96097);
    this.QBq.remove(Long.valueOf(paramb.PVd));
    paramb.report();
    AppMethodBeat.o(96097);
  }
  
  public final boolean hib()
  {
    AppMethodBeat.i(96102);
    if (this.QBh != null)
    {
      Object localObject;
      if ((this.QBh.getTag() instanceof a))
      {
        localObject = (a)this.QBh.getTag();
        localObject = (b)this.QBq.get(Long.valueOf(((a)localObject).ibq));
        if (localObject != null)
        {
          if (!((b)localObject).hid()) {
            break label111;
          }
          if (((b)localObject).hic()) {
            ((b)localObject).aZe("2:0:");
          }
          a((b)localObject);
        }
      }
      for (;;)
      {
        this.QBg.removeView(this.QBh);
        this.QBh = null;
        AppMethodBeat.o(96102);
        return true;
        label111:
        ((b)localObject).aZe("2:0:");
        a((b)localObject);
      }
    }
    this.QBk = false;
    AppMethodBeat.o(96102);
    return false;
  }
  
  public final int jv(final View paramView)
  {
    AppMethodBeat.i(96099);
    if (this.QBk)
    {
      AppMethodBeat.o(96099);
      return 0;
    }
    if (this.QBh != null)
    {
      if ((this.QBh.getTag() instanceof a))
      {
        paramView = ((a)this.QBh.getTag()).MdP;
        this.QBk = true;
        paramView.startAnimation(this.QBj);
        this.QBj.setAnimationListener(new Animation.AnimationListener()
        {
          public final void onAnimationEnd(Animation paramAnonymousAnimation)
          {
            AppMethodBeat.i(96088);
            if (paramView != null)
            {
              paramView.clearAnimation();
              paramView.setVisibility(8);
              b.this.hib();
            }
            b.a(b.this, false);
            AppMethodBeat.o(96088);
          }
          
          public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
          
          public final void onAnimationStart(Animation paramAnonymousAnimation)
          {
            AppMethodBeat.i(306467);
            b.a(b.this, true);
            AppMethodBeat.o(306467);
          }
        });
      }
      for (;;)
      {
        AppMethodBeat.o(96099);
        return 0;
        hib();
      }
    }
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof com.tencent.mm.plugin.sns.data.e)))
    {
      AppMethodBeat.o(96099);
      return 0;
    }
    if ((!this.hEn) || (this.QBt == null))
    {
      AppMethodBeat.o(96099);
      return 2;
    }
    Object localObject1 = (com.tencent.mm.plugin.sns.data.e)paramView.getTag();
    long l = ((com.tencent.mm.plugin.sns.data.e)localObject1).ibq;
    Object localObject2 = ((com.tencent.mm.plugin.sns.data.e)localObject1).QmD.RFh;
    boolean bool;
    if (this.QBu.containsKey(Long.valueOf(l))) {
      bool = ((Boolean)this.QBu.get(Long.valueOf(l))).booleanValue();
    }
    while (!bool)
    {
      AppMethodBeat.o(96099);
      return 2;
      if (this.QBt == null)
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
          if (i >= this.QBt.QCg.size()) {
            break label322;
          }
          if (Util.isNullOrNil(a((a)this.QBt.QCg.get(i), ((ADXml)localObject2).adArgs)))
          {
            this.QBu.put(Long.valueOf(l), Boolean.FALSE);
            bool = false;
            break;
          }
          i += 1;
        }
        label322:
        this.QBu.put(Long.valueOf(l), Boolean.TRUE);
        bool = true;
      }
    }
    localObject2 = ((com.tencent.mm.plugin.sns.data.e)localObject1).hES;
    Object localObject3 = new b(((com.tencent.mm.plugin.sns.data.e)localObject1).ibq, ((com.tencent.mm.plugin.sns.data.e)localObject1).QmD.edF(), this.QBt.QBF, this.QBt.sdF, this.mContext.getString(b.j.sns_ad_tip));
    this.QBq.put(Long.valueOf(((com.tencent.mm.plugin.sns.data.e)localObject1).ibq), localObject3);
    if (this.QBs.contains(Long.valueOf(((com.tencent.mm.plugin.sns.data.e)localObject1).ibq))) {
      this.QBs.remove(Long.valueOf(((com.tencent.mm.plugin.sns.data.e)localObject1).ibq));
    }
    this.QBh = new AbsoluteLayout(this.mContext);
    this.QBh.setId(b.f.address);
    new FrameLayout.LayoutParams(-1, -1);
    this.QBg.addView(this.QBh);
    localObject3 = af.mU(this.mContext).inflate(b.g.adabtest_unlike_tip, null);
    Object localObject4 = new TextView[3];
    ImageView[] arrayOfImageView = new ImageView[3];
    localObject4[0] = ((TextView)((View)localObject3).findViewById(b.f.ad_unlike_btn_one));
    localObject4[1] = ((TextView)((View)localObject3).findViewById(b.f.ad_unlike_btn_two));
    localObject4[2] = ((TextView)((View)localObject3).findViewById(b.f.ad_unlike_btn_three));
    arrayOfImageView[0] = ((ImageView)((View)localObject3).findViewById(b.f.ad_unlike_btn_right_one));
    arrayOfImageView[1] = ((ImageView)((View)localObject3).findViewById(b.f.ad_unlike_btn_right_two));
    arrayOfImageView[2] = ((ImageView)((View)localObject3).findViewById(b.f.ad_unlike_btn_right_three));
    int j = 0;
    int i = 0;
    if (!v.uN(((com.tencent.mm.plugin.sns.data.e)localObject1).ibq))
    {
      k = 0;
      for (;;)
      {
        j = i;
        if (k >= this.QBo.length) {
          break;
        }
        j = i;
        if (this.QBo[k] == 3) {
          j = i + 1;
        }
        k += 1;
        i = j;
      }
    }
    int k = 0;
    i = 0;
    while (i < this.QBo.length)
    {
      m = k;
      if (this.QBo[i] == 0) {
        m = k + 1;
      }
      i += 1;
      k = m;
    }
    if (k + j > 0)
    {
      i = this.QBo.length - k - j;
      if (i == 0)
      {
        AppMethodBeat.o(96099);
        return 2;
      }
    }
    for (this.QBp = new int[i];; this.QBp = new int[this.QBo.length])
    {
      i = 0;
      for (k = 0; i < this.QBo.length; k = m)
      {
        m = k;
        if (this.QBo[i] != 0) {
          if (j > 0)
          {
            m = k;
            if (this.QBo[i] == 3) {}
          }
          else
          {
            this.QBp[k] = this.QBo[i];
            m = k + 1;
          }
        }
        i += 1;
      }
    }
    if (v.uM(((com.tencent.mm.plugin.sns.data.e)localObject1).ibq))
    {
      i = 0;
      if (i < this.QBp.length)
      {
        if (this.QBp[i] != 3) {
          break label1130;
        }
        this.QBp[i] = 4;
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
    if (j < this.QBp.length)
    {
      i2 = this.QBp[j];
      i3 = this.QBp[j] - 1;
      localObject4[j].setText(this.QBn[i3]);
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
      localObject4[j].setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(this.QBm[i3]), null, null, null);
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
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/newabtest/AdNotLikeAbTestHelper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            b.a(b.this, i2, this.QBw, this.QBx, b.this.QBh);
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
      while (j < this.QBp.length)
      {
        localObject4[j].setMaxWidth(i);
        j += 1;
      }
      j = this.QBp.length;
      while (j < 3)
      {
        localObject4[j].setVisibility(8);
        j += 1;
      }
      new Rect();
      j = com.tencent.mm.pluginsdk.h.lm(this.mContext);
      localObject4 = ((com.tencent.mm.plugin.sns.data.e)localObject1).QmD.hqD();
      Log.d("MicroMsg.AdNotLikeAbTestHelper", "addCommentView getLocationInWindow " + localObject4[0] + "  " + localObject4[1] + " height: " + j);
      i += com.tencent.mm.cd.a.fromDPToPix(this.mContext, 12);
      k = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 17.0F);
      m = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 2.0F);
      this.vpn = aw.mL(this.mContext);
      localObject4 = new AbsoluteLayout.LayoutParams(i, -2, localObject4[0] - i - m, localObject4[1] - this.vpn - j + k);
      localObject1 = new a((String)localObject2, (View)localObject3, ((com.tencent.mm.plugin.sns.data.e)localObject1).ibq, ((com.tencent.mm.plugin.sns.data.e)localObject1).QmD.RFh);
      this.QBh.setTag(localObject1);
      this.QBh.addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
      ((View)localObject3).setVisibility(8);
      this.QBk = true;
      new MMHandler().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(96086);
          b.a(b.this, paramView, this.QBx);
          AppMethodBeat.o(96086);
        }
      });
      AppMethodBeat.o(96099);
      return 1;
    }
  }
  
  final class a
  {
    View MdP = null;
    String QBA;
    ADXml QBB;
    long ibq;
    
    public a(String paramString, View paramView, long paramLong, ADXml paramADXml)
    {
      this.QBA = paramString;
      this.MdP = paramView;
      this.QBB = paramADXml;
      this.ibq = paramLong;
    }
  }
  
  static final class b
  {
    long PVd;
    StringBuffer QBC;
    long QBD;
    long QBE;
    String QBF;
    String sdF;
    String uxInfo;
    
    public b(long paramLong, String paramString1, String paramString2, String paramString3)
    {
      AppMethodBeat.i(96090);
      this.QBC = new StringBuffer();
      this.uxInfo = paramString1;
      this.QBF = paramString2;
      this.sdF = paramString3;
      this.PVd = paramLong;
      this.QBD = System.currentTimeMillis();
      this.QBC.append("0:0:");
      AppMethodBeat.o(96090);
    }
    
    public b(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4)
    {
      AppMethodBeat.i(96089);
      this.QBC = new StringBuffer();
      this.uxInfo = paramString1;
      this.QBF = paramString2;
      this.sdF = paramString3;
      this.PVd = paramLong;
      this.QBD = System.currentTimeMillis();
      this.QBC.append("1:0:".concat(String.valueOf(paramString4)));
      AppMethodBeat.o(96089);
    }
    
    public final void aZe(String paramString)
    {
      AppMethodBeat.i(96091);
      Log.d("MicroMsg.AdNotLikeAbTestHelper", "addactionResult ".concat(String.valueOf(paramString)));
      if (this.QBC.length() != 0) {
        this.QBC.append("|");
      }
      this.QBC.append(paramString);
      AppMethodBeat.o(96091);
    }
    
    public final boolean hic()
    {
      AppMethodBeat.i(96092);
      if ((this.QBC == null) || (this.QBC.length() == 0))
      {
        AppMethodBeat.o(96092);
        return false;
      }
      if (this.QBC.toString().startsWith("1:0"))
      {
        AppMethodBeat.o(96092);
        return true;
      }
      AppMethodBeat.o(96092);
      return false;
    }
    
    public final boolean hid()
    {
      AppMethodBeat.i(96093);
      if ((this.QBC == null) || (this.QBC.length() == 0))
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
      this.QBE = System.currentTimeMillis();
      Log.d("MicroMsg.AdNotLikeAbTestHelper", "report abtestnotlike " + this.PVd + " uxinfo:" + this.uxInfo + " actionresult: " + this.QBC + " " + this.QBD + " " + this.QBE);
      com.tencent.mm.plugin.report.service.h.OAn.b(11988, new Object[] { this.sdF, this.QBF, "", "", t.uA(this.PVd), this.uxInfo, this.QBC, Long.valueOf(this.QBD / 1000L), Long.valueOf(this.QBE / 1000L) });
      AppMethodBeat.o(96094);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.i.b
 * JD-Core Version:    0.7.0.1
 */