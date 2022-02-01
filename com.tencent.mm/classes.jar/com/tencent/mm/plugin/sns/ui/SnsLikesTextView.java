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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.ui.ao;
import com.tencent.mm.vending.d.b;
import java.util.HashMap;

public class SnsLikesTextView
  extends RelativeLayout
  implements bh.a
{
  private BaseTimeLineItem.BaseViewHolder AfQ;
  private TextView AgQ;
  private bi AgU;
  private j Asf;
  private ImageView Awr;
  private LinearLayout Aws;
  private MaskTextView Awt;
  private SpannableStringBuilder Awu;
  private int Awv;
  private boolean Aww;
  private PBool Awx;
  protected HashMap<String, Integer> Awy;
  private Runnable Awz;
  private String dsN;
  private boolean hasCheck;
  private int oOD;
  
  public SnsLikesTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SnsLikesTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(98838);
    this.dsN = null;
    this.hasCheck = true;
    this.AgQ = null;
    this.Awr = null;
    this.Aws = null;
    this.Awt = null;
    this.Awu = new SpannableStringBuilder(" ");
    this.Awv = 0;
    this.Aww = false;
    this.oOD = 0;
    this.Asf = null;
    this.Awx = null;
    this.Awy = null;
    this.AfQ = null;
    this.AgU = null;
    this.Awz = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98837);
        SnsLikesTextView.b(SnsLikesTextView.this);
        AppMethodBeat.o(98837);
      }
    };
    inflate(getContext(), 2131495559, this);
    this.AgQ = ((TextView)findViewById(2131305001));
    this.Awr = ((ImageView)findViewById(2131304999));
    this.Aws = ((LinearLayout)findViewById(2131305000));
    this.Awt = ((MaskTextView)findViewById(2131305002));
    AppMethodBeat.o(98838);
  }
  
  private void efU()
  {
    AppMethodBeat.i(98840);
    Object localObject1 = (Integer)this.Awy.get(this.dsN);
    if (localObject1 != null) {}
    switch (((Integer)localObject1).intValue())
    {
    default: 
    case 0: 
      do
      {
        AppMethodBeat.o(98840);
        return;
        i = this.Awt.getLayout().getLineCount();
        this.Aws.setVisibility(8);
      } while (i <= this.Awv);
      com.tencent.mm.plugin.sns.j.e.zKO.a(this.AfQ.uan, this.AgU, this.Awu.toString(), this.Awu.toString(), i, i, false, this.AfQ.position, this.Awv);
      AppMethodBeat.o(98840);
      return;
    case 1: 
      i = this.Awt.getLayout().getLineCount();
      j = Math.max(Math.min(this.Awv, i), 0);
      k = this.Awt.getLayout().getLineVisibleEnd(j - 1);
      localObject1 = this.Awu.subSequence(0, k);
      k = ((CharSequence)localObject1).toString().lastIndexOf(",");
      if ((k > 0) && (k < ((CharSequence)localObject1).length())) {}
      for (localObject1 = new SpannableStringBuilder(((CharSequence)localObject1).subSequence(0, k));; localObject1 = new SpannableStringBuilder((CharSequence)localObject1))
      {
        localObject2 = ((SpannableStringBuilder)localObject1).toString();
        ((SpannableStringBuilder)localObject1).append(",...");
        this.Awt.setText((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
        this.Aws.setVisibility(0);
        this.AgQ.setText(getContext().getString(2131763885));
        this.Awr.setRotation(90.0F);
        this.Awr.setImageDrawable(ao.k(getContext(), 2131690349, getContext().getResources().getColor(2131100547)));
        com.tencent.mm.plugin.sns.j.e.zKO.a(this.AfQ.uan, this.AgU, (String)localObject2, this.Awu.toString(), j, i, true, this.AfQ.position, this.Awv);
        AppMethodBeat.o(98840);
        return;
      }
    case 2: 
      i = this.Awt.getLayout().getLineCount();
      this.Awt.setText(this.Awu, TextView.BufferType.SPANNABLE);
      this.Aws.setVisibility(0);
      this.Awr.setRotation(-90.0F);
      this.Awr.setImageDrawable(ao.k(getContext(), 2131690349, getContext().getResources().getColor(2131100547)));
      this.AgQ.setText(getContext().getString(2131763884));
      com.tencent.mm.plugin.sns.j.e.zKO.a(this.AfQ.uan, this.AgU, this.Awu.toString(), this.Awu.toString(), i, i, false, this.AfQ.position, this.Awv);
      AppMethodBeat.o(98840);
      return;
    }
    int j = this.Awt.getLayout().getLineCount();
    Object localObject2 = (String)g.ajR().ajA().get(2, null);
    localObject1 = (String)g.ajR().ajA().get(4, null);
    SpannableString localSpannableString = k.b(getContext(), (CharSequence)localObject1, this.Awt.getTextSize());
    int k = Math.max(Math.min(this.Awv, j), 0);
    int i = this.Awt.getLayout().getLineVisibleEnd(k - 1);
    localObject1 = this.Awu.subSequence(0, i);
    i = ((CharSequence)localObject1).toString().lastIndexOf(",");
    if ((i > 0) && (i < ((CharSequence)localObject1).length()))
    {
      localObject1 = new SpannableStringBuilder(((CharSequence)localObject1).subSequence(0, i));
      label672:
      if (this.oOD != 10) {
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
            SnsLikesTextView.a(SnsLikesTextView.this).doj = 13;
            SnsLikesTextView.a(SnsLikesTextView.this).b(paramAnonymousView, paramAnonymousObject);
          }
          AppMethodBeat.o(98835);
        }
      }, i), 0, localSpannableString.length(), 33);
      localObject2 = new StringBuilder(((SpannableStringBuilder)localObject1).toString());
      ((SpannableStringBuilder)localObject1).append(",...").append(",").append(localSpannableString);
      this.Awt.setText((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
      this.Aws.setVisibility(0);
      this.AgQ.setText(getContext().getString(2131763885));
      this.Awr.setRotation(90.0F);
      this.Awr.setImageDrawable(ao.k(getContext(), 2131690349, getContext().getResources().getColor(2131100547)));
      com.tencent.mm.plugin.sns.j.e.zKO.a(this.AfQ.uan, this.AgU, "," + localSpannableString, this.Awu.toString(), k, j, true, this.AfQ.position, this.Awv);
      break;
      localObject1 = new SpannableStringBuilder((CharSequence)localObject1);
      break label672;
    }
  }
  
  public final boolean a(b<com.tencent.mm.vending.j.a> paramb, int paramInt1, bh parambh, String paramString, int paramInt2, boolean paramBoolean, PBool paramPBool, bi parambi, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(98843);
    this.Awv = paramInt2;
    this.dsN = paramString;
    this.oOD = paramInt1;
    this.Asf = parambh.Asf;
    this.Awx = paramPBool;
    this.Aww = paramBoolean;
    this.AfQ = paramBaseViewHolder;
    this.AgU = parambi;
    this.Awy = parambh.Awy;
    this.Awu.clear();
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
          paramBaseViewHolder = k.b(getContext(), parambi, this.Awt.getTextSize());
          if (j != 0)
          {
            this.Awu.append(" ");
            parambh.append(" ");
            j = 0;
            paramString[i] = this.Awu.length();
            paramString[i] += parambi.length();
            parambh.append(parambi);
            this.Awu.append(paramBaseViewHolder);
            if ((!com.tencent.mm.plugin.sns.f.a.azG((String)((com.tencent.mm.vending.j.a)paramb.get(i)).get(0))) || (!((com.tencent.mm.plugin.story.api.e)g.ad(com.tencent.mm.plugin.story.api.e.class)).getStoryBasicConfig().a(f.a.AZx)) || (!o.isShowStoryCheck())) {
              break label709;
            }
            this.Awu.append("  ");
            parambi = new h(((com.tencent.mm.plugin.story.api.e)g.ad(com.tencent.mm.plugin.story.api.e.class)).getStoryUIFactory().so(true));
            this.Awu.setSpan(parambi, this.Awu.length() - 1, this.Awu.length(), 17);
            break label709;
          }
          this.Awu.append(", ");
          parambh.append(", ");
          continue;
          AppMethodBeat.o(98843);
        }
      }
      catch (Exception paramb)
      {
        ae.e("MicroMsg.SnsLikesTextView", "setLikedList  e:%s", new Object[] { bu.o(paramb) });
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
        paramBaseViewHolder.LmE = ((int)((parambi.getIntrinsicHeight() - this.Awt.getTextSize() + com.tencent.mm.cb.a.fromDPToPix(getContext(), 2)) / 2.0F));
        this.Awu.setSpan(paramBaseViewHolder, 0, 1, 33);
        if (paramInt1 != 10) {
          break label732;
        }
        paramInt1 = 3;
        break;
        label512:
        while (i < paramString.length)
        {
          parambi = (String)((com.tencent.mm.vending.j.a)paramb.get(i)).get(0);
          paramBaseViewHolder = this.Awu;
          getContext();
          paramBaseViewHolder.setSpan(new p(parambi, new p.a()
          {
            public final void b(View paramAnonymousView, Object paramAnonymousObject)
            {
              AppMethodBeat.i(98836);
              if (SnsLikesTextView.a(SnsLikesTextView.this) != null)
              {
                SnsLikesTextView.a(SnsLikesTextView.this).doj = 13;
                SnsLikesTextView.a(SnsLikesTextView.this).b(paramAnonymousView, paramAnonymousObject);
              }
              AppMethodBeat.o(98836);
            }
          }, paramInt1), paramString[i], paramPBool[i], 33);
          i += 1;
        }
        this.Awt.setText(this.Awu, TextView.BufferType.SPANNABLE);
        this.Awt.setOriginText(parambh.toString());
        if (paramInt2 > 0)
        {
          if ((getTag() == null) || (!(getTag() instanceof String)) || (!bu.lX((String)getTag(), this.Awu.toString())))
          {
            setTag(this.Awu.toString());
            this.Aws.setVisibility(8);
            this.hasCheck = false;
            requestLayout();
            AppMethodBeat.o(98843);
            return true;
          }
          this.hasCheck = true;
          efU();
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
    return this.dsN;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(98839);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = this.Awt.getLineCount();
    if ((this.Awv > 0) && (paramInt1 > this.Awv) && (this.Awx != null)) {
      this.Awx.value = true;
    }
    if ((this.Awv > 0) && (this.Awy != null))
    {
      if (this.hasCheck)
      {
        AppMethodBeat.o(98839);
        return;
      }
      this.hasCheck = true;
      if (this.Awy.get(this.dsN) == null)
      {
        if (!this.Aww) {
          break label168;
        }
        if (paramInt1 > this.Awv) {
          break label149;
        }
        this.Awy.put(this.dsN, Integer.valueOf(0));
      }
    }
    for (;;)
    {
      post(this.Awz);
      AppMethodBeat.o(98839);
      return;
      label149:
      this.Awy.put(this.dsN, Integer.valueOf(1));
      continue;
      label168:
      this.Awy.put(this.dsN, Integer.valueOf(0));
    }
  }
  
  public final void rZ(boolean paramBoolean)
  {
    AppMethodBeat.i(98846);
    if ((this.Awv > 0) && (this.Awy != null))
    {
      Integer localInteger = (Integer)this.Awy.get(this.dsN);
      if (localInteger != null)
      {
        if (paramBoolean)
        {
          if (localInteger.intValue() == 1)
          {
            this.Awy.put(this.dsN, Integer.valueOf(3));
            efU();
            AppMethodBeat.o(98846);
          }
        }
        else if (localInteger.intValue() == 3)
        {
          this.Awy.put(this.dsN, Integer.valueOf(1));
          efU();
          AppMethodBeat.o(98846);
        }
      }
      else {
        this.Awy.put(this.dsN, Integer.valueOf(0));
      }
    }
    AppMethodBeat.o(98846);
  }
  
  public void setLikeTvTag(Object paramObject)
  {
    AppMethodBeat.i(98844);
    if (this.Awt != null) {
      this.Awt.setTag(paramObject);
    }
    AppMethodBeat.o(98844);
  }
  
  public void setLikedTextTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    AppMethodBeat.i(98842);
    if (this.Awt != null) {
      this.Awt.setOnTouchListener(paramOnTouchListener);
    }
    AppMethodBeat.o(98842);
  }
  
  public void setOpClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(98841);
    if (this.Aws != null) {
      this.Aws.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(98841);
  }
  
  public void setOpTvTag(Object paramObject)
  {
    AppMethodBeat.i(98845);
    if (this.Aws != null) {
      this.Aws.setTag(paramObject);
    }
    AppMethodBeat.o(98845);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsLikesTextView
 * JD-Core Version:    0.7.0.1
 */