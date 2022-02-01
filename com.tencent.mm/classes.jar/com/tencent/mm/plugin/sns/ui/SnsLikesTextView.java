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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.am;
import com.tencent.mm.vending.d.b;
import java.util.HashMap;

public class SnsLikesTextView
  extends RelativeLayout
  implements be.a
{
  private String dgl;
  private boolean hasCheck;
  private int oeH;
  private j yJy;
  private ImageView yNJ;
  private LinearLayout yNK;
  private MaskTextView yNL;
  private SpannableStringBuilder yNM;
  private int yNN;
  private boolean yNO;
  private PBool yNP;
  protected HashMap<String, Integer> yNQ;
  private Runnable yNR;
  private BaseTimeLineItem.BaseViewHolder yxx;
  private bf yyC;
  private TextView yyy;
  
  public SnsLikesTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SnsLikesTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(98838);
    this.dgl = null;
    this.hasCheck = true;
    this.yyy = null;
    this.yNJ = null;
    this.yNK = null;
    this.yNL = null;
    this.yNM = new SpannableStringBuilder(" ");
    this.yNN = 0;
    this.yNO = false;
    this.oeH = 0;
    this.yJy = null;
    this.yNP = null;
    this.yNQ = null;
    this.yxx = null;
    this.yyC = null;
    this.yNR = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98837);
        SnsLikesTextView.b(SnsLikesTextView.this);
        AppMethodBeat.o(98837);
      }
    };
    inflate(getContext(), 2131495559, this);
    this.yyy = ((TextView)findViewById(2131305001));
    this.yNJ = ((ImageView)findViewById(2131304999));
    this.yNK = ((LinearLayout)findViewById(2131305000));
    this.yNL = ((MaskTextView)findViewById(2131305002));
    AppMethodBeat.o(98838);
  }
  
  private void dPW()
  {
    AppMethodBeat.i(98840);
    Object localObject1 = (Integer)this.yNQ.get(this.dgl);
    if (localObject1 != null) {}
    switch (((Integer)localObject1).intValue())
    {
    default: 
    case 0: 
      do
      {
        AppMethodBeat.o(98840);
        return;
        i = this.yNL.getLayout().getLineCount();
        this.yNK.setVisibility(8);
      } while (i <= this.yNN);
      com.tencent.mm.plugin.sns.j.f.ydE.a(this.yxx.sSS, this.yyC, this.yNM.toString(), this.yNM.toString(), i, i, false, this.yxx.position, this.yNN);
      AppMethodBeat.o(98840);
      return;
    case 1: 
      i = this.yNL.getLayout().getLineCount();
      j = Math.max(Math.min(this.yNN, i), 0);
      k = this.yNL.getLayout().getLineVisibleEnd(j - 1);
      localObject1 = this.yNM.subSequence(0, k);
      k = ((CharSequence)localObject1).toString().lastIndexOf(",");
      if ((k > 0) && (k < ((CharSequence)localObject1).length())) {}
      for (localObject1 = new SpannableStringBuilder(((CharSequence)localObject1).subSequence(0, k));; localObject1 = new SpannableStringBuilder((CharSequence)localObject1))
      {
        localObject2 = ((SpannableStringBuilder)localObject1).toString();
        ((SpannableStringBuilder)localObject1).append(",...");
        this.yNL.setText((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
        this.yNK.setVisibility(0);
        this.yyy.setText(getContext().getString(2131763885));
        this.yNJ.setRotation(90.0F);
        this.yNJ.setImageDrawable(am.k(getContext(), 2131690349, getContext().getResources().getColor(2131100547)));
        com.tencent.mm.plugin.sns.j.f.ydE.a(this.yxx.sSS, this.yyC, (String)localObject2, this.yNM.toString(), j, i, true, this.yxx.position, this.yNN);
        AppMethodBeat.o(98840);
        return;
      }
    case 2: 
      i = this.yNL.getLayout().getLineCount();
      this.yNL.setText(this.yNM, TextView.BufferType.SPANNABLE);
      this.yNK.setVisibility(0);
      this.yNJ.setRotation(-90.0F);
      this.yNJ.setImageDrawable(am.k(getContext(), 2131690349, getContext().getResources().getColor(2131100547)));
      this.yyy.setText(getContext().getString(2131763884));
      com.tencent.mm.plugin.sns.j.f.ydE.a(this.yxx.sSS, this.yyC, this.yNM.toString(), this.yNM.toString(), i, i, false, this.yxx.position, this.yNN);
      AppMethodBeat.o(98840);
      return;
    }
    int j = this.yNL.getLayout().getLineCount();
    Object localObject2 = (String)g.agR().agA().get(2, null);
    localObject1 = (String)g.agR().agA().get(4, null);
    SpannableString localSpannableString = k.b(getContext(), (CharSequence)localObject1, this.yNL.getTextSize());
    int k = Math.max(Math.min(this.yNN, j), 0);
    int i = this.yNL.getLayout().getLineVisibleEnd(k - 1);
    localObject1 = this.yNM.subSequence(0, i);
    i = ((CharSequence)localObject1).toString().lastIndexOf(",");
    if ((i > 0) && (i < ((CharSequence)localObject1).length()))
    {
      localObject1 = new SpannableStringBuilder(((CharSequence)localObject1).subSequence(0, i));
      label672:
      if (this.oeH != 10) {
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
            SnsLikesTextView.a(SnsLikesTextView.this).dbL = 13;
            SnsLikesTextView.a(SnsLikesTextView.this).b(paramAnonymousView, paramAnonymousObject);
          }
          AppMethodBeat.o(98835);
        }
      }, i), 0, localSpannableString.length(), 33);
      localObject2 = new StringBuilder(((SpannableStringBuilder)localObject1).toString());
      ((SpannableStringBuilder)localObject1).append(",...").append(",").append(localSpannableString);
      this.yNL.setText((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
      this.yNK.setVisibility(0);
      this.yyy.setText(getContext().getString(2131763885));
      this.yNJ.setRotation(90.0F);
      this.yNJ.setImageDrawable(am.k(getContext(), 2131690349, getContext().getResources().getColor(2131100547)));
      com.tencent.mm.plugin.sns.j.f.ydE.a(this.yxx.sSS, this.yyC, "," + localSpannableString, this.yNM.toString(), k, j, true, this.yxx.position, this.yNN);
      break;
      localObject1 = new SpannableStringBuilder((CharSequence)localObject1);
      break label672;
    }
  }
  
  public final boolean a(b<com.tencent.mm.vending.j.a> paramb, int paramInt1, be parambe, String paramString, int paramInt2, boolean paramBoolean, PBool paramPBool, bf parambf, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(98843);
    this.yNN = paramInt2;
    this.dgl = paramString;
    this.oeH = paramInt1;
    this.yJy = parambe.yJy;
    this.yNP = paramPBool;
    this.yNO = paramBoolean;
    this.yxx = paramBaseViewHolder;
    this.yyC = parambf;
    this.yNQ = parambe.yNQ;
    this.yNM.clear();
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
          paramBaseViewHolder = k.b(getContext(), parambf, this.yNL.getTextSize());
          if (j != 0)
          {
            this.yNM.append(" ");
            parambe.append(" ");
            j = 0;
            paramString[i] = this.yNM.length();
            paramString[i] += parambf.length();
            parambe.append(parambf);
            this.yNM.append(paramBaseViewHolder);
            if ((!com.tencent.mm.plugin.sns.f.a.atk((String)((com.tencent.mm.vending.j.a)paramb.get(i)).get(0))) || (!((com.tencent.mm.plugin.story.api.e)g.ad(com.tencent.mm.plugin.story.api.e.class)).getStoryBasicConfig().a(f.a.zqa)) || (!o.isShowStoryCheck())) {
              break label709;
            }
            this.yNM.append("  ");
            parambf = new h(((com.tencent.mm.plugin.story.api.e)g.ad(com.tencent.mm.plugin.story.api.e.class)).getStoryUIFactory().rB(true));
            this.yNM.setSpan(parambf, this.yNM.length() - 1, this.yNM.length(), 17);
            break label709;
          }
          this.yNM.append(", ");
          parambe.append(", ");
          continue;
          AppMethodBeat.o(98843);
        }
      }
      catch (Exception paramb)
      {
        ac.e("MicroMsg.SnsLikesTextView", "setLikedList  e:%s", new Object[] { bs.m(paramb) });
      }
      for (;;)
      {
        return true;
        parambf = getContext();
        if (paramInt1 != 10) {
          break label724;
        }
        i = 2131232602;
        parambf = am.k(parambf, i, getContext().getResources().getColor(2131099769));
        parambf.setBounds(0, 0, parambf.getIntrinsicWidth(), parambf.getIntrinsicHeight());
        paramBaseViewHolder = new com.tencent.mm.ui.widget.a(parambf);
        paramBaseViewHolder.IZa = ((int)((parambf.getIntrinsicHeight() - this.yNL.getTextSize() + com.tencent.mm.cc.a.fromDPToPix(getContext(), 2)) / 2.0F));
        this.yNM.setSpan(paramBaseViewHolder, 0, 1, 33);
        if (paramInt1 != 10) {
          break label732;
        }
        paramInt1 = 3;
        break;
        label512:
        while (i < paramString.length)
        {
          parambf = (String)((com.tencent.mm.vending.j.a)paramb.get(i)).get(0);
          paramBaseViewHolder = this.yNM;
          getContext();
          paramBaseViewHolder.setSpan(new p(parambf, new p.a()
          {
            public final void b(View paramAnonymousView, Object paramAnonymousObject)
            {
              AppMethodBeat.i(98836);
              if (SnsLikesTextView.a(SnsLikesTextView.this) != null)
              {
                SnsLikesTextView.a(SnsLikesTextView.this).dbL = 13;
                SnsLikesTextView.a(SnsLikesTextView.this).b(paramAnonymousView, paramAnonymousObject);
              }
              AppMethodBeat.o(98836);
            }
          }, paramInt1), paramString[i], paramPBool[i], 33);
          i += 1;
        }
        this.yNL.setText(this.yNM, TextView.BufferType.SPANNABLE);
        this.yNL.setOriginText(parambe.toString());
        if (paramInt2 > 0)
        {
          if ((getTag() == null) || (!(getTag() instanceof String)) || (!bs.lr((String)getTag(), this.yNM.toString())))
          {
            setTag(this.yNM.toString());
            this.yNK.setVisibility(8);
            this.hasCheck = false;
            requestLayout();
            AppMethodBeat.o(98843);
            return true;
          }
          this.hasCheck = true;
          dPW();
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
    return this.dgl;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(98839);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = this.yNL.getLineCount();
    if ((this.yNN > 0) && (paramInt1 > this.yNN) && (this.yNP != null)) {
      this.yNP.value = true;
    }
    if ((this.yNN > 0) && (this.yNQ != null))
    {
      if (this.hasCheck)
      {
        AppMethodBeat.o(98839);
        return;
      }
      this.hasCheck = true;
      if (this.yNQ.get(this.dgl) == null)
      {
        if (!this.yNO) {
          break label168;
        }
        if (paramInt1 > this.yNN) {
          break label149;
        }
        this.yNQ.put(this.dgl, Integer.valueOf(0));
      }
    }
    for (;;)
    {
      post(this.yNR);
      AppMethodBeat.o(98839);
      return;
      label149:
      this.yNQ.put(this.dgl, Integer.valueOf(1));
      continue;
      label168:
      this.yNQ.put(this.dgl, Integer.valueOf(0));
    }
  }
  
  public final void ro(boolean paramBoolean)
  {
    AppMethodBeat.i(98846);
    if ((this.yNN > 0) && (this.yNQ != null))
    {
      Integer localInteger = (Integer)this.yNQ.get(this.dgl);
      if (localInteger != null)
      {
        if (paramBoolean)
        {
          if (localInteger.intValue() == 1)
          {
            this.yNQ.put(this.dgl, Integer.valueOf(3));
            dPW();
            AppMethodBeat.o(98846);
          }
        }
        else if (localInteger.intValue() == 3)
        {
          this.yNQ.put(this.dgl, Integer.valueOf(1));
          dPW();
          AppMethodBeat.o(98846);
        }
      }
      else {
        this.yNQ.put(this.dgl, Integer.valueOf(0));
      }
    }
    AppMethodBeat.o(98846);
  }
  
  public void setLikeTvTag(Object paramObject)
  {
    AppMethodBeat.i(98844);
    if (this.yNL != null) {
      this.yNL.setTag(paramObject);
    }
    AppMethodBeat.o(98844);
  }
  
  public void setLikedTextTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    AppMethodBeat.i(98842);
    if (this.yNL != null) {
      this.yNL.setOnTouchListener(paramOnTouchListener);
    }
    AppMethodBeat.o(98842);
  }
  
  public void setOpClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(98841);
    if (this.yNK != null) {
      this.yNK.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(98841);
  }
  
  public void setOpTvTag(Object paramObject)
  {
    AppMethodBeat.i(98845);
    if (this.yNK != null) {
      this.yNK.setTag(paramObject);
    }
    AppMethodBeat.o(98845);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsLikesTextView
 * JD-Core Version:    0.7.0.1
 */