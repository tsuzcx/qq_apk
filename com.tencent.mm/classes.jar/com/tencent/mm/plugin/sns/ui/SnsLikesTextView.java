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
import com.tencent.mm.plugin.textstatus.a.a.b;
import com.tencent.mm.plugin.textstatus.a.c;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.q;
import com.tencent.mm.pluginsdk.ui.span.q.a;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.ar;
import com.tencent.mm.vending.d.b;
import java.util.HashMap;

public class SnsLikesTextView
  extends RelativeLayout
  implements bk.a
{
  private j EBk;
  private ImageView EFG;
  private LinearLayout EFH;
  private MaskTextView EFI;
  private SpannableStringBuilder EFJ;
  private int EFK;
  private boolean EFL;
  private PBool EFM;
  protected HashMap<String, Integer> EFN;
  private Runnable EFO;
  private BaseTimeLineItem.BaseViewHolder Eon;
  private TextView Epm;
  private bl Epq;
  private String dJX;
  private boolean hasCheck;
  private int qcr;
  
  public SnsLikesTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SnsLikesTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(98838);
    this.dJX = null;
    this.hasCheck = true;
    this.Epm = null;
    this.EFG = null;
    this.EFH = null;
    this.EFI = null;
    this.EFJ = new SpannableStringBuilder(" ");
    this.EFK = 0;
    this.EFL = false;
    this.qcr = 0;
    this.EBk = null;
    this.EFM = null;
    this.EFN = null;
    this.Eon = null;
    this.Epq = null;
    this.EFO = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98837);
        SnsLikesTextView.b(SnsLikesTextView.this);
        AppMethodBeat.o(98837);
      }
    };
    inflate(getContext(), 2131496451, this);
    this.Epm = ((TextView)findViewById(2131308152));
    this.EFG = ((ImageView)findViewById(2131308150));
    this.EFH = ((LinearLayout)findViewById(2131308151));
    this.EFI = ((MaskTextView)findViewById(2131308153));
    AppMethodBeat.o(98838);
  }
  
  private void fiu()
  {
    AppMethodBeat.i(98840);
    Object localObject1 = (Integer)this.EFN.get(this.dJX);
    if (localObject1 != null) {}
    switch (((Integer)localObject1).intValue())
    {
    default: 
    case 0: 
      do
      {
        AppMethodBeat.o(98840);
        return;
        i = this.EFI.getLayout().getLineCount();
        this.EFH.setVisibility(8);
      } while (i <= this.EFK);
      com.tencent.mm.plugin.sns.k.e.DUQ.a(this.Eon.convertView, this.Epq, this.EFJ.toString(), this.EFJ.toString(), i, i, false, this.Eon.position, this.EFK);
      AppMethodBeat.o(98840);
      return;
    case 1: 
      i = this.EFI.getLayout().getLineCount();
      j = Math.max(Math.min(this.EFK, i), 0);
      k = this.EFI.getLayout().getLineVisibleEnd(j - 1);
      localObject1 = this.EFJ.subSequence(0, k);
      k = ((CharSequence)localObject1).toString().lastIndexOf(",");
      if ((k > 0) && (k < ((CharSequence)localObject1).length())) {}
      for (localObject1 = new SpannableStringBuilder(((CharSequence)localObject1).subSequence(0, k));; localObject1 = new SpannableStringBuilder((CharSequence)localObject1))
      {
        localObject2 = ((SpannableStringBuilder)localObject1).toString();
        ((SpannableStringBuilder)localObject1).append(",...");
        this.EFI.setText((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
        this.EFH.setVisibility(0);
        this.Epm.setText(getContext().getString(2131766112));
        this.EFG.setRotation(90.0F);
        this.EFG.setImageDrawable(ar.m(getContext(), 2131690481, getContext().getResources().getColor(2131100685)));
        com.tencent.mm.plugin.sns.k.e.DUQ.a(this.Eon.convertView, this.Epq, (String)localObject2, this.EFJ.toString(), j, i, true, this.Eon.position, this.EFK);
        AppMethodBeat.o(98840);
        return;
      }
    case 2: 
      i = this.EFI.getLayout().getLineCount();
      this.EFI.setText(this.EFJ, TextView.BufferType.SPANNABLE);
      this.EFH.setVisibility(0);
      this.EFG.setRotation(-90.0F);
      this.EFG.setImageDrawable(ar.m(getContext(), 2131690481, getContext().getResources().getColor(2131100685)));
      this.Epm.setText(getContext().getString(2131766111));
      com.tencent.mm.plugin.sns.k.e.DUQ.a(this.Eon.convertView, this.Epq, this.EFJ.toString(), this.EFJ.toString(), i, i, false, this.Eon.position, this.EFK);
      AppMethodBeat.o(98840);
      return;
    }
    int j = this.EFI.getLayout().getLineCount();
    Object localObject2 = (String)g.aAh().azQ().get(2, null);
    localObject1 = (String)g.aAh().azQ().get(4, null);
    SpannableString localSpannableString = l.b(getContext(), (CharSequence)localObject1, this.EFI.getTextSize());
    int k = Math.max(Math.min(this.EFK, j), 0);
    int i = this.EFI.getLayout().getLineVisibleEnd(k - 1);
    localObject1 = this.EFJ.subSequence(0, i);
    i = ((CharSequence)localObject1).toString().lastIndexOf(",");
    if ((i > 0) && (i < ((CharSequence)localObject1).length()))
    {
      localObject1 = new SpannableStringBuilder(((CharSequence)localObject1).subSequence(0, i));
      label672:
      if (this.qcr != 10) {
        break label896;
      }
    }
    label896:
    for (i = 3;; i = 2)
    {
      getContext();
      localSpannableString.setSpan(new q(localObject2, new q.a()
      {
        public final void b(View paramAnonymousView, Object paramAnonymousObject)
        {
          AppMethodBeat.i(98835);
          if (SnsLikesTextView.a(SnsLikesTextView.this) != null)
          {
            SnsLikesTextView.a(SnsLikesTextView.this).source = 13;
            SnsLikesTextView.a(SnsLikesTextView.this).b(paramAnonymousView, paramAnonymousObject);
            ((c)g.ah(c.class)).report22210(this.gtu, 7L);
          }
          AppMethodBeat.o(98835);
        }
      }, i), 0, localSpannableString.length(), 33);
      localObject2 = new StringBuilder(((SpannableStringBuilder)localObject1).toString());
      ((SpannableStringBuilder)localObject1).append(",...").append(",").append(localSpannableString);
      this.EFI.setText((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
      this.EFH.setVisibility(0);
      this.Epm.setText(getContext().getString(2131766112));
      this.EFG.setRotation(90.0F);
      this.EFG.setImageDrawable(ar.m(getContext(), 2131690481, getContext().getResources().getColor(2131100685)));
      com.tencent.mm.plugin.sns.k.e.DUQ.a(this.Eon.convertView, this.Epq, "," + localSpannableString, this.EFJ.toString(), k, j, true, this.Eon.position, this.EFK);
      break;
      localObject1 = new SpannableStringBuilder((CharSequence)localObject1);
      break label672;
    }
  }
  
  public final boolean a(b<com.tencent.mm.vending.j.a> paramb, int paramInt1, bk parambk, String paramString, int paramInt2, boolean paramBoolean, PBool paramPBool, bl parambl, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(98843);
    this.EFK = paramInt2;
    this.dJX = paramString;
    this.qcr = paramInt1;
    this.EBk = parambk.EBk;
    this.EFM = paramPBool;
    this.EFL = paramBoolean;
    this.Eon = paramBaseViewHolder;
    this.Epq = parambl;
    this.EFN = parambk.EFN;
    this.EFJ.clear();
    parambk = new StringBuffer();
    paramString = new int[paramb.size()];
    paramPBool = new int[paramb.size()];
    int i = 1;
    int j = 0;
    for (;;)
    {
      try
      {
        if (j < paramb.size())
        {
          parambl = (String)((com.tencent.mm.vending.j.a)paramb.get(j)).get(1);
          paramBaseViewHolder = l.b(getContext(), parambl, this.EFI.getTextSize());
          if (i != 0)
          {
            this.EFJ.append(" ");
            parambk.append(" ");
            i = 0;
            paramString[j] = this.EFJ.length();
            paramString[j] += parambl.length();
            parambk.append(parambl);
            this.EFJ.append(paramBaseViewHolder);
            parambl = (String)((com.tencent.mm.vending.j.a)paramb.get(j)).get(0);
            if ((com.tencent.mm.plugin.sns.f.a.aOD(parambl)) && (((com.tencent.mm.plugin.story.api.e)g.ah(com.tencent.mm.plugin.story.api.e.class)).getStoryBasicConfig().a(f.a.Fkv)) && (o.isShowStoryCheck()))
            {
              this.EFJ.append("  ");
              parambl = new h(((com.tencent.mm.plugin.story.api.e)g.ah(com.tencent.mm.plugin.story.api.e.class)).getStoryUIFactory().vJ(true));
              this.EFJ.setSpan(parambl, this.EFJ.length() - 1, this.EFJ.length(), 17);
              break label786;
            }
          }
          else
          {
            this.EFJ.append(", ");
            parambk.append(", ");
            continue;
          }
          parambl = ((c)g.ah(c.class)).getTextStatusSpanSync(parambl, a.b.FXk, this.EFI.getTextSize());
          if (parambl == null) {
            break label786;
          }
          this.EFJ.append(" ");
          this.EFJ.setSpan(parambl, this.EFJ.length() - 1, this.EFJ.length(), 17);
        }
      }
      catch (Exception paramb)
      {
        Log.e("MicroMsg.SnsLikesTextView", "setLikedList  e:%s", new Object[] { Util.stackTraceToString(paramb) });
      }
      for (;;)
      {
        AppMethodBeat.o(98843);
        return true;
        parambl = getContext();
        if (paramInt1 != 10) {
          break label801;
        }
        i = 2131232997;
        parambl = ar.m(parambl, i, getContext().getResources().getColor(2131099783));
        parambl.setBounds(0, 0, parambl.getIntrinsicWidth(), parambl.getIntrinsicHeight());
        paramBaseViewHolder = new com.tencent.mm.ui.widget.a(parambl);
        paramBaseViewHolder.QBM = ((int)((parambl.getIntrinsicHeight() - this.EFI.getTextSize() + com.tencent.mm.cb.a.fromDPToPix(getContext(), 2)) / 2.0F));
        this.EFJ.setSpan(paramBaseViewHolder, 0, 1, 33);
        if (paramInt1 != 10) {
          break label809;
        }
        paramInt1 = 3;
        break;
        label589:
        while (i < paramString.length)
        {
          parambl = (String)((com.tencent.mm.vending.j.a)paramb.get(i)).get(0);
          paramBaseViewHolder = this.EFJ;
          getContext();
          paramBaseViewHolder.setSpan(new q(parambl, new q.a()
          {
            public final void b(View paramAnonymousView, Object paramAnonymousObject)
            {
              AppMethodBeat.i(98836);
              if (SnsLikesTextView.a(SnsLikesTextView.this) != null)
              {
                SnsLikesTextView.a(SnsLikesTextView.this).source = 13;
                SnsLikesTextView.a(SnsLikesTextView.this).b(paramAnonymousView, paramAnonymousObject);
              }
              AppMethodBeat.o(98836);
            }
          }, paramInt1), paramString[i], paramPBool[i], 33);
          i += 1;
        }
        this.EFI.setText(this.EFJ, TextView.BufferType.SPANNABLE);
        this.EFI.setOriginText(parambk.toString());
        if (paramInt2 > 0)
        {
          if ((getTag() == null) || (!(getTag() instanceof String)) || (!Util.isEqual((String)getTag(), this.EFJ.toString())))
          {
            setTag(this.EFJ.toString());
            this.EFH.setVisibility(8);
            this.hasCheck = false;
            requestLayout();
            AppMethodBeat.o(98843);
            return true;
          }
          this.hasCheck = true;
          fiu();
        }
      }
      label786:
      j += 1;
    }
    for (;;)
    {
      i = 0;
      break label589;
      label801:
      i = 2131234277;
      break;
      label809:
      paramInt1 = 2;
    }
  }
  
  public String getKey()
  {
    return this.dJX;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(98839);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = this.EFI.getLineCount();
    if ((this.EFK > 0) && (paramInt1 > this.EFK) && (this.EFM != null)) {
      this.EFM.value = true;
    }
    if ((this.EFK > 0) && (this.EFN != null))
    {
      if (this.hasCheck)
      {
        AppMethodBeat.o(98839);
        return;
      }
      this.hasCheck = true;
      if (this.EFN.get(this.dJX) == null)
      {
        if (!this.EFL) {
          break label168;
        }
        if (paramInt1 > this.EFK) {
          break label149;
        }
        this.EFN.put(this.dJX, Integer.valueOf(0));
      }
    }
    for (;;)
    {
      post(this.EFO);
      AppMethodBeat.o(98839);
      return;
      label149:
      this.EFN.put(this.dJX, Integer.valueOf(1));
      continue;
      label168:
      this.EFN.put(this.dJX, Integer.valueOf(0));
    }
  }
  
  public void setLikeTvTag(Object paramObject)
  {
    AppMethodBeat.i(98844);
    if (this.EFI != null) {
      this.EFI.setTag(paramObject);
    }
    AppMethodBeat.o(98844);
  }
  
  public void setLikedTextTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    AppMethodBeat.i(98842);
    if (this.EFI != null) {
      this.EFI.setOnTouchListener(paramOnTouchListener);
    }
    AppMethodBeat.o(98842);
  }
  
  public void setOpClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(98841);
    if (this.EFH != null) {
      this.EFH.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(98841);
  }
  
  public void setOpTvTag(Object paramObject)
  {
    AppMethodBeat.i(98845);
    if (this.EFH != null) {
      this.EFH.setTag(paramObject);
    }
    AppMethodBeat.o(98845);
  }
  
  public final void vv(boolean paramBoolean)
  {
    AppMethodBeat.i(98846);
    if ((this.EFK > 0) && (this.EFN != null))
    {
      Integer localInteger = (Integer)this.EFN.get(this.dJX);
      if (localInteger != null)
      {
        if (paramBoolean)
        {
          if (localInteger.intValue() == 1)
          {
            this.EFN.put(this.dJX, Integer.valueOf(3));
            fiu();
            AppMethodBeat.o(98846);
          }
        }
        else if (localInteger.intValue() == 3)
        {
          this.EFN.put(this.dJX, Integer.valueOf(1));
          fiu();
          AppMethodBeat.o(98846);
        }
      }
      else {
        this.EFN.put(this.dJX, Integer.valueOf(0));
      }
    }
    AppMethodBeat.o(98846);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsLikesTextView
 * JD-Core Version:    0.7.0.1
 */