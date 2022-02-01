package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.widget.h;
import com.tencent.mm.plugin.story.api.f.a;
import com.tencent.mm.plugin.story.api.n;
import com.tencent.mm.plugin.story.api.o;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.pluginsdk.ui.span.p.a;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.am;
import com.tencent.mm.vending.d.b;
import java.util.HashMap;

public class SnsLikesTextView
  extends RelativeLayout
  implements be.a
{
  private String diQ;
  private boolean hasCheck;
  private int nBH;
  private ImageView xAV;
  private LinearLayout xAW;
  private MaskTextView xAX;
  private SpannableStringBuilder xAY;
  private int xAZ;
  private boolean xBa;
  private PBool xBb;
  protected HashMap<String, Integer> xBc;
  private Runnable xBd;
  private BaseTimeLineItem.BaseViewHolder xkF;
  private TextView xlG;
  private bf xlK;
  private j xwI;
  
  public SnsLikesTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SnsLikesTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(98838);
    this.diQ = null;
    this.hasCheck = true;
    this.xlG = null;
    this.xAV = null;
    this.xAW = null;
    this.xAX = null;
    this.xAY = new SpannableStringBuilder(" ");
    this.xAZ = 0;
    this.xBa = false;
    this.nBH = 0;
    this.xwI = null;
    this.xBb = null;
    this.xBc = null;
    this.xkF = null;
    this.xlK = null;
    this.xBd = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98837);
        SnsLikesTextView.b(SnsLikesTextView.this);
        AppMethodBeat.o(98837);
      }
    };
    inflate(getContext(), 2131495559, this);
    this.xlG = ((TextView)findViewById(2131305001));
    this.xAV = ((ImageView)findViewById(2131304999));
    this.xAW = ((LinearLayout)findViewById(2131305000));
    this.xAX = ((MaskTextView)findViewById(2131305002));
    AppMethodBeat.o(98838);
  }
  
  private void dBz()
  {
    AppMethodBeat.i(98840);
    Object localObject1 = (Integer)this.xBc.get(this.diQ);
    if (localObject1 != null) {}
    switch (((Integer)localObject1).intValue())
    {
    default: 
    case 0: 
      do
      {
        AppMethodBeat.o(98840);
        return;
        i = this.xAX.getLayout().getLineCount();
        this.xAW.setVisibility(8);
      } while (i <= this.xAZ);
      com.tencent.mm.plugin.sns.k.f.wQY.a(this.xkF.rLd, this.xlK, this.xAY.toString(), this.xAY.toString(), i, i, false, this.xkF.position, this.xAZ);
      AppMethodBeat.o(98840);
      return;
    case 1: 
      i = this.xAX.getLayout().getLineCount();
      j = Math.max(Math.min(this.xAZ, i), 0);
      k = this.xAX.getLayout().getLineVisibleEnd(j - 1);
      localObject1 = this.xAY.subSequence(0, k);
      k = ((CharSequence)localObject1).toString().lastIndexOf(",");
      if ((k > 0) && (k < ((CharSequence)localObject1).length())) {}
      for (localObject1 = new SpannableStringBuilder(((CharSequence)localObject1).subSequence(0, k));; localObject1 = new SpannableStringBuilder((CharSequence)localObject1))
      {
        localObject2 = ((SpannableStringBuilder)localObject1).toString();
        ((SpannableStringBuilder)localObject1).append(",...");
        this.xAX.setText((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
        this.xAW.setVisibility(0);
        this.xlG.setText(getContext().getString(2131763885));
        this.xAV.setRotation(90.0F);
        this.xAV.setImageDrawable(am.i(getContext(), 2131690349, getContext().getResources().getColor(2131100547)));
        com.tencent.mm.plugin.sns.k.f.wQY.a(this.xkF.rLd, this.xlK, (String)localObject2, this.xAY.toString(), j, i, true, this.xkF.position, this.xAZ);
        AppMethodBeat.o(98840);
        return;
      }
    case 2: 
      i = this.xAX.getLayout().getLineCount();
      this.xAX.setText(this.xAY, TextView.BufferType.SPANNABLE);
      this.xAW.setVisibility(0);
      this.xAV.setRotation(-90.0F);
      this.xAV.setImageDrawable(am.i(getContext(), 2131690349, getContext().getResources().getColor(2131100547)));
      this.xlG.setText(getContext().getString(2131763884));
      com.tencent.mm.plugin.sns.k.f.wQY.a(this.xkF.rLd, this.xlK, this.xAY.toString(), this.xAY.toString(), i, i, false, this.xkF.position, this.xAZ);
      AppMethodBeat.o(98840);
      return;
    }
    int j = this.xAX.getLayout().getLineCount();
    Object localObject2 = (String)g.afB().afk().get(2, null);
    localObject1 = (String)g.afB().afk().get(4, null);
    SpannableString localSpannableString = k.b(getContext(), (CharSequence)localObject1, this.xAX.getTextSize());
    int k = Math.max(Math.min(this.xAZ, j), 0);
    int i = this.xAX.getLayout().getLineVisibleEnd(k - 1);
    localObject1 = this.xAY.subSequence(0, i);
    i = ((CharSequence)localObject1).toString().lastIndexOf(",");
    if ((i > 0) && (i < ((CharSequence)localObject1).length()))
    {
      localObject1 = new SpannableStringBuilder(((CharSequence)localObject1).subSequence(0, i));
      label672:
      if (this.nBH != 10) {
        break label894;
      }
    }
    label894:
    for (i = 3;; i = 2)
    {
      getContext();
      localSpannableString.setSpan(new p(localObject2, new p.a()
      {
        public final void b(View paramAnonymousView, Object paramAnonymousObject)
        {
          AppMethodBeat.i(98835);
          if (SnsLikesTextView.a(SnsLikesTextView.this) != null)
          {
            SnsLikesTextView.a(SnsLikesTextView.this).dep = 13;
            SnsLikesTextView.a(SnsLikesTextView.this).b(paramAnonymousView, paramAnonymousObject);
          }
          AppMethodBeat.o(98835);
        }
      }, i), 0, localSpannableString.length(), 33);
      localObject2 = new StringBuilder(((SpannableStringBuilder)localObject1).toString());
      ((SpannableStringBuilder)localObject1).append(",...").append(",").append(localSpannableString);
      this.xAX.setText((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
      this.xAW.setVisibility(0);
      this.xlG.setText(getContext().getString(2131763885));
      this.xAV.setRotation(90.0F);
      this.xAV.setImageDrawable(am.i(getContext(), 2131690349, getContext().getResources().getColor(2131100547)));
      com.tencent.mm.plugin.sns.k.f.wQY.a(this.xkF.rLd, this.xlK, "," + localSpannableString, this.xAY.toString(), k, j, true, this.xkF.position, this.xAZ);
      break;
      localObject1 = new SpannableStringBuilder((CharSequence)localObject1);
      break label672;
    }
  }
  
  public final boolean a(b<com.tencent.mm.vending.j.a> paramb, int paramInt1, be parambe, String paramString, int paramInt2, boolean paramBoolean, PBool paramPBool, bf parambf, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(98843);
    this.xAZ = paramInt2;
    this.diQ = paramString;
    this.nBH = paramInt1;
    this.xwI = parambe.xwI;
    this.xBb = paramPBool;
    this.xBa = paramBoolean;
    this.xkF = paramBaseViewHolder;
    this.xlK = parambf;
    this.xBc = parambe.xBc;
    this.xAY.clear();
    parambe = new StringBuffer();
    paramString = new int[paramb.size()];
    paramPBool = new int[paramb.size()];
    int i = 0;
    int j = 1;
    for (;;)
    {
      try
      {
        if (i < paramb.size())
        {
          parambf = (String)((com.tencent.mm.vending.j.a)paramb.get(i)).get(1);
          paramBaseViewHolder = k.b(getContext(), parambf, this.xAX.getTextSize());
          if (j != 0)
          {
            this.xAY.append(" ");
            parambe.append(" ");
            j = 0;
            paramString[i] = this.xAY.length();
            paramString[i] += parambf.length();
            parambe.append(parambf);
            this.xAY.append(paramBaseViewHolder);
            if ((!com.tencent.mm.plugin.sns.g.a.anY((String)((com.tencent.mm.vending.j.a)paramb.get(i)).get(0))) || (!((com.tencent.mm.plugin.story.api.e)g.ad(com.tencent.mm.plugin.story.api.e.class)).getStoryBasicConfig().a(f.a.yda)) || (!o.isShowStoryCheck())) {
              break label709;
            }
            this.xAY.append("  ");
            parambf = new h(((com.tencent.mm.plugin.story.api.e)g.ad(com.tencent.mm.plugin.story.api.e.class)).getStoryUIFactory().qD(true));
            this.xAY.setSpan(parambf, this.xAY.length() - 1, this.xAY.length(), 17);
            break label709;
          }
          this.xAY.append(", ");
          parambe.append(", ");
          continue;
          AppMethodBeat.o(98843);
        }
      }
      catch (Exception paramb)
      {
        ad.e("MicroMsg.SnsLikesTextView", "setLikedList  e:%s", new Object[] { bt.m(paramb) });
      }
      for (;;)
      {
        return true;
        parambf = getContext();
        if (paramInt1 != 10) {
          break label724;
        }
        i = 2131232602;
        parambf = am.i(parambf, i, getContext().getResources().getColor(2131099769));
        parambf.setBounds(0, 0, parambf.getIntrinsicWidth(), parambf.getIntrinsicHeight());
        paramBaseViewHolder = new com.tencent.mm.ui.widget.a(parambf);
        paramBaseViewHolder.HyD = ((int)((parambf.getIntrinsicHeight() - this.xAX.getTextSize() + com.tencent.mm.cd.a.fromDPToPix(getContext(), 2)) / 2.0F));
        this.xAY.setSpan(paramBaseViewHolder, 0, 1, 33);
        if (paramInt1 != 10) {
          break label732;
        }
        paramInt1 = 3;
        break;
        label512:
        while (i < paramString.length)
        {
          parambf = (String)((com.tencent.mm.vending.j.a)paramb.get(i)).get(0);
          paramBaseViewHolder = this.xAY;
          getContext();
          paramBaseViewHolder.setSpan(new p(parambf, new p.a()
          {
            public final void b(View paramAnonymousView, Object paramAnonymousObject)
            {
              AppMethodBeat.i(98836);
              if (SnsLikesTextView.a(SnsLikesTextView.this) != null)
              {
                SnsLikesTextView.a(SnsLikesTextView.this).dep = 13;
                SnsLikesTextView.a(SnsLikesTextView.this).b(paramAnonymousView, paramAnonymousObject);
              }
              AppMethodBeat.o(98836);
            }
          }, paramInt1), paramString[i], paramPBool[i], 33);
          i += 1;
        }
        this.xAX.setText(this.xAY, TextView.BufferType.SPANNABLE);
        this.xAX.setOriginText(parambe.toString());
        if (paramInt2 > 0)
        {
          if ((getTag() == null) || (!(getTag() instanceof String)) || (!bt.kU((String)getTag(), this.xAY.toString())))
          {
            setTag(this.xAY.toString());
            this.xAW.setVisibility(8);
            this.hasCheck = false;
            requestLayout();
            AppMethodBeat.o(98843);
            return true;
          }
          this.hasCheck = true;
          dBz();
        }
      }
      label709:
      i += 1;
    }
    for (;;)
    {
      i = 0;
      break label512;
      label724:
      i = 2131233474;
      break;
      label732:
      paramInt1 = 2;
    }
  }
  
  public String getKey()
  {
    return this.diQ;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(98839);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = this.xAX.getLineCount();
    if ((this.xAZ > 0) && (paramInt1 > this.xAZ) && (this.xBb != null)) {
      this.xBb.value = true;
    }
    if ((this.xAZ > 0) && (this.xBc != null))
    {
      if (this.hasCheck)
      {
        AppMethodBeat.o(98839);
        return;
      }
      this.hasCheck = true;
      if (this.xBc.get(this.diQ) == null)
      {
        if (!this.xBa) {
          break label168;
        }
        if (paramInt1 > this.xAZ) {
          break label149;
        }
        this.xBc.put(this.diQ, Integer.valueOf(0));
      }
    }
    for (;;)
    {
      post(this.xBd);
      AppMethodBeat.o(98839);
      return;
      label149:
      this.xBc.put(this.diQ, Integer.valueOf(1));
      continue;
      label168:
      this.xBc.put(this.diQ, Integer.valueOf(0));
    }
  }
  
  public final void qq(boolean paramBoolean)
  {
    AppMethodBeat.i(98846);
    if ((this.xAZ > 0) && (this.xBc != null))
    {
      Integer localInteger = (Integer)this.xBc.get(this.diQ);
      if (localInteger != null)
      {
        if (paramBoolean)
        {
          if (localInteger.intValue() == 1)
          {
            this.xBc.put(this.diQ, Integer.valueOf(3));
            dBz();
            AppMethodBeat.o(98846);
          }
        }
        else if (localInteger.intValue() == 3)
        {
          this.xBc.put(this.diQ, Integer.valueOf(1));
          dBz();
          AppMethodBeat.o(98846);
        }
      }
      else {
        this.xBc.put(this.diQ, Integer.valueOf(0));
      }
    }
    AppMethodBeat.o(98846);
  }
  
  public void setLikeTvTag(Object paramObject)
  {
    AppMethodBeat.i(98844);
    if (this.xAX != null) {
      this.xAX.setTag(paramObject);
    }
    AppMethodBeat.o(98844);
  }
  
  public void setLikedTextTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    AppMethodBeat.i(98842);
    if (this.xAX != null) {
      this.xAX.setOnTouchListener(paramOnTouchListener);
    }
    AppMethodBeat.o(98842);
  }
  
  public void setOpClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(98841);
    if (this.xAW != null) {
      this.xAW.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(98841);
  }
  
  public void setOpTvTag(Object paramObject)
  {
    AppMethodBeat.i(98845);
    if (this.xAW != null) {
      this.xAW.setTag(paramObject);
    }
    AppMethodBeat.o(98845);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsLikesTextView
 * JD-Core Version:    0.7.0.1
 */