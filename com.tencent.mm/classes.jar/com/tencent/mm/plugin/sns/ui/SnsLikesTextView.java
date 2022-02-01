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
import com.tencent.mm.plugin.story.api.f;
import com.tencent.mm.plugin.story.api.f.a;
import com.tencent.mm.plugin.story.api.n;
import com.tencent.mm.plugin.story.api.o;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.pluginsdk.ui.span.p.a;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.ao;
import com.tencent.mm.vending.d.b;
import java.util.HashMap;

public class SnsLikesTextView
  extends RelativeLayout
  implements bh.a
{
  private j AaS;
  private ImageView Aff;
  private LinearLayout Afg;
  private MaskTextView Afh;
  private SpannableStringBuilder Afi;
  private int Afj;
  private boolean Afk;
  private PBool Afl;
  protected HashMap<String, Integer> Afm;
  private Runnable Afn;
  private String drH;
  private boolean hasCheck;
  private int oIb;
  private BaseTimeLineItem.BaseViewHolder zOJ;
  private TextView zPJ;
  private bi zPN;
  
  public SnsLikesTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SnsLikesTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(98838);
    this.drH = null;
    this.hasCheck = true;
    this.zPJ = null;
    this.Aff = null;
    this.Afg = null;
    this.Afh = null;
    this.Afi = new SpannableStringBuilder(" ");
    this.Afj = 0;
    this.Afk = false;
    this.oIb = 0;
    this.AaS = null;
    this.Afl = null;
    this.Afm = null;
    this.zOJ = null;
    this.zPN = null;
    this.Afn = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98837);
        SnsLikesTextView.b(SnsLikesTextView.this);
        AppMethodBeat.o(98837);
      }
    };
    inflate(getContext(), 2131495559, this);
    this.zPJ = ((TextView)findViewById(2131305001));
    this.Aff = ((ImageView)findViewById(2131304999));
    this.Afg = ((LinearLayout)findViewById(2131305000));
    this.Afh = ((MaskTextView)findViewById(2131305002));
    AppMethodBeat.o(98838);
  }
  
  private void ecn()
  {
    AppMethodBeat.i(98840);
    Object localObject1 = (Integer)this.Afm.get(this.drH);
    if (localObject1 != null) {}
    switch (((Integer)localObject1).intValue())
    {
    default: 
    case 0: 
      do
      {
        AppMethodBeat.o(98840);
        return;
        i = this.Afh.getLayout().getLineCount();
        this.Afg.setVisibility(8);
      } while (i <= this.Afj);
      com.tencent.mm.plugin.sns.j.e.ztz.a(this.zOJ.tPw, this.zPN, this.Afi.toString(), this.Afi.toString(), i, i, false, this.zOJ.position, this.Afj);
      AppMethodBeat.o(98840);
      return;
    case 1: 
      i = this.Afh.getLayout().getLineCount();
      j = Math.max(Math.min(this.Afj, i), 0);
      k = this.Afh.getLayout().getLineVisibleEnd(j - 1);
      localObject1 = this.Afi.subSequence(0, k);
      k = ((CharSequence)localObject1).toString().lastIndexOf(",");
      if ((k > 0) && (k < ((CharSequence)localObject1).length())) {}
      for (localObject1 = new SpannableStringBuilder(((CharSequence)localObject1).subSequence(0, k));; localObject1 = new SpannableStringBuilder((CharSequence)localObject1))
      {
        localObject2 = ((SpannableStringBuilder)localObject1).toString();
        ((SpannableStringBuilder)localObject1).append(",...");
        this.Afh.setText((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
        this.Afg.setVisibility(0);
        this.zPJ.setText(getContext().getString(2131763885));
        this.Aff.setRotation(90.0F);
        this.Aff.setImageDrawable(ao.k(getContext(), 2131690349, getContext().getResources().getColor(2131100547)));
        com.tencent.mm.plugin.sns.j.e.ztz.a(this.zOJ.tPw, this.zPN, (String)localObject2, this.Afi.toString(), j, i, true, this.zOJ.position, this.Afj);
        AppMethodBeat.o(98840);
        return;
      }
    case 2: 
      i = this.Afh.getLayout().getLineCount();
      this.Afh.setText(this.Afi, TextView.BufferType.SPANNABLE);
      this.Afg.setVisibility(0);
      this.Aff.setRotation(-90.0F);
      this.Aff.setImageDrawable(ao.k(getContext(), 2131690349, getContext().getResources().getColor(2131100547)));
      this.zPJ.setText(getContext().getString(2131763884));
      com.tencent.mm.plugin.sns.j.e.ztz.a(this.zOJ.tPw, this.zPN, this.Afi.toString(), this.Afi.toString(), i, i, false, this.zOJ.position, this.Afj);
      AppMethodBeat.o(98840);
      return;
    }
    int j = this.Afh.getLayout().getLineCount();
    Object localObject2 = (String)g.ajC().ajl().get(2, null);
    localObject1 = (String)g.ajC().ajl().get(4, null);
    SpannableString localSpannableString = k.b(getContext(), (CharSequence)localObject1, this.Afh.getTextSize());
    int k = Math.max(Math.min(this.Afj, j), 0);
    int i = this.Afh.getLayout().getLineVisibleEnd(k - 1);
    localObject1 = this.Afi.subSequence(0, i);
    i = ((CharSequence)localObject1).toString().lastIndexOf(",");
    if ((i > 0) && (i < ((CharSequence)localObject1).length()))
    {
      localObject1 = new SpannableStringBuilder(((CharSequence)localObject1).subSequence(0, i));
      label672:
      if (this.oIb != 10) {
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
            SnsLikesTextView.a(SnsLikesTextView.this).dnh = 13;
            SnsLikesTextView.a(SnsLikesTextView.this).b(paramAnonymousView, paramAnonymousObject);
          }
          AppMethodBeat.o(98835);
        }
      }, i), 0, localSpannableString.length(), 33);
      localObject2 = new StringBuilder(((SpannableStringBuilder)localObject1).toString());
      ((SpannableStringBuilder)localObject1).append(",...").append(",").append(localSpannableString);
      this.Afh.setText((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
      this.Afg.setVisibility(0);
      this.zPJ.setText(getContext().getString(2131763885));
      this.Aff.setRotation(90.0F);
      this.Aff.setImageDrawable(ao.k(getContext(), 2131690349, getContext().getResources().getColor(2131100547)));
      com.tencent.mm.plugin.sns.j.e.ztz.a(this.zOJ.tPw, this.zPN, "," + localSpannableString, this.Afi.toString(), k, j, true, this.zOJ.position, this.Afj);
      break;
      localObject1 = new SpannableStringBuilder((CharSequence)localObject1);
      break label672;
    }
  }
  
  public final boolean a(b<com.tencent.mm.vending.j.a> paramb, int paramInt1, bh parambh, String paramString, int paramInt2, boolean paramBoolean, PBool paramPBool, bi parambi, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(98843);
    this.Afj = paramInt2;
    this.drH = paramString;
    this.oIb = paramInt1;
    this.AaS = parambh.AaS;
    this.Afl = paramPBool;
    this.Afk = paramBoolean;
    this.zOJ = paramBaseViewHolder;
    this.zPN = parambi;
    this.Afm = parambh.Afm;
    this.Afi.clear();
    parambh = new StringBuffer();
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
          parambi = (String)((com.tencent.mm.vending.j.a)paramb.get(i)).get(1);
          paramBaseViewHolder = k.b(getContext(), parambi, this.Afh.getTextSize());
          if (j != 0)
          {
            this.Afi.append(" ");
            parambh.append(" ");
            j = 0;
            paramString[i] = this.Afi.length();
            paramString[i] += parambi.length();
            parambh.append(parambi);
            this.Afi.append(paramBaseViewHolder);
            if ((!com.tencent.mm.plugin.sns.f.a.ayp((String)((com.tencent.mm.vending.j.a)paramb.get(i)).get(0))) || (!((com.tencent.mm.plugin.story.api.e)g.ad(com.tencent.mm.plugin.story.api.e.class)).getStoryBasicConfig().a(f.a.AHU)) || (!o.isShowStoryCheck())) {
              break label709;
            }
            this.Afi.append("  ");
            parambi = new h(((com.tencent.mm.plugin.story.api.e)g.ad(com.tencent.mm.plugin.story.api.e.class)).getStoryUIFactory().sh(true));
            this.Afi.setSpan(parambi, this.Afi.length() - 1, this.Afi.length(), 17);
            break label709;
          }
          this.Afi.append(", ");
          parambh.append(", ");
          continue;
          AppMethodBeat.o(98843);
        }
      }
      catch (Exception paramb)
      {
        ad.e("MicroMsg.SnsLikesTextView", "setLikedList  e:%s", new Object[] { bt.n(paramb) });
      }
      for (;;)
      {
        return true;
        parambi = getContext();
        if (paramInt1 != 10) {
          break label724;
        }
        i = 2131232602;
        parambi = ao.k(parambi, i, getContext().getResources().getColor(2131099769));
        parambi.setBounds(0, 0, parambi.getIntrinsicWidth(), parambi.getIntrinsicHeight());
        paramBaseViewHolder = new com.tencent.mm.ui.widget.a(parambi);
        paramBaseViewHolder.KQg = ((int)((parambi.getIntrinsicHeight() - this.Afh.getTextSize() + com.tencent.mm.cc.a.fromDPToPix(getContext(), 2)) / 2.0F));
        this.Afi.setSpan(paramBaseViewHolder, 0, 1, 33);
        if (paramInt1 != 10) {
          break label732;
        }
        paramInt1 = 3;
        break;
        label512:
        while (i < paramString.length)
        {
          parambi = (String)((com.tencent.mm.vending.j.a)paramb.get(i)).get(0);
          paramBaseViewHolder = this.Afi;
          getContext();
          paramBaseViewHolder.setSpan(new p(parambi, new p.a()
          {
            public final void b(View paramAnonymousView, Object paramAnonymousObject)
            {
              AppMethodBeat.i(98836);
              if (SnsLikesTextView.a(SnsLikesTextView.this) != null)
              {
                SnsLikesTextView.a(SnsLikesTextView.this).dnh = 13;
                SnsLikesTextView.a(SnsLikesTextView.this).b(paramAnonymousView, paramAnonymousObject);
              }
              AppMethodBeat.o(98836);
            }
          }, paramInt1), paramString[i], paramPBool[i], 33);
          i += 1;
        }
        this.Afh.setText(this.Afi, TextView.BufferType.SPANNABLE);
        this.Afh.setOriginText(parambh.toString());
        if (paramInt2 > 0)
        {
          if ((getTag() == null) || (!(getTag() instanceof String)) || (!bt.lQ((String)getTag(), this.Afi.toString())))
          {
            setTag(this.Afi.toString());
            this.Afg.setVisibility(8);
            this.hasCheck = false;
            requestLayout();
            AppMethodBeat.o(98843);
            return true;
          }
          this.hasCheck = true;
          ecn();
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
    return this.drH;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(98839);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = this.Afh.getLineCount();
    if ((this.Afj > 0) && (paramInt1 > this.Afj) && (this.Afl != null)) {
      this.Afl.value = true;
    }
    if ((this.Afj > 0) && (this.Afm != null))
    {
      if (this.hasCheck)
      {
        AppMethodBeat.o(98839);
        return;
      }
      this.hasCheck = true;
      if (this.Afm.get(this.drH) == null)
      {
        if (!this.Afk) {
          break label168;
        }
        if (paramInt1 > this.Afj) {
          break label149;
        }
        this.Afm.put(this.drH, Integer.valueOf(0));
      }
    }
    for (;;)
    {
      post(this.Afn);
      AppMethodBeat.o(98839);
      return;
      label149:
      this.Afm.put(this.drH, Integer.valueOf(1));
      continue;
      label168:
      this.Afm.put(this.drH, Integer.valueOf(0));
    }
  }
  
  public final void rS(boolean paramBoolean)
  {
    AppMethodBeat.i(98846);
    if ((this.Afj > 0) && (this.Afm != null))
    {
      Integer localInteger = (Integer)this.Afm.get(this.drH);
      if (localInteger != null)
      {
        if (paramBoolean)
        {
          if (localInteger.intValue() == 1)
          {
            this.Afm.put(this.drH, Integer.valueOf(3));
            ecn();
            AppMethodBeat.o(98846);
          }
        }
        else if (localInteger.intValue() == 3)
        {
          this.Afm.put(this.drH, Integer.valueOf(1));
          ecn();
          AppMethodBeat.o(98846);
        }
      }
      else {
        this.Afm.put(this.drH, Integer.valueOf(0));
      }
    }
    AppMethodBeat.o(98846);
  }
  
  public void setLikeTvTag(Object paramObject)
  {
    AppMethodBeat.i(98844);
    if (this.Afh != null) {
      this.Afh.setTag(paramObject);
    }
    AppMethodBeat.o(98844);
  }
  
  public void setLikedTextTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    AppMethodBeat.i(98842);
    if (this.Afh != null) {
      this.Afh.setOnTouchListener(paramOnTouchListener);
    }
    AppMethodBeat.o(98842);
  }
  
  public void setOpClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(98841);
    if (this.Afg != null) {
      this.Afg.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(98841);
  }
  
  public void setOpTvTag(Object paramObject)
  {
    AppMethodBeat.i(98845);
    if (this.Afg != null) {
      this.Afg.setTag(paramObject);
    }
    AppMethodBeat.o(98845);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsLikesTextView
 * JD-Core Version:    0.7.0.1
 */