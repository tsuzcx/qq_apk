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
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.k.g;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.plugin.story.api.f.a;
import com.tencent.mm.plugin.story.api.n;
import com.tencent.mm.plugin.story.api.o;
import com.tencent.mm.plugin.textstatus.a.a.b;
import com.tencent.mm.plugin.textstatus.a.d;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.q;
import com.tencent.mm.pluginsdk.ui.span.q.a;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.au;
import com.tencent.mm.vending.d.b;
import java.util.HashMap;

public class SnsLikesTextView
  extends RelativeLayout
  implements bm.a
{
  private BaseTimeLineItem.BaseViewHolder KBw;
  private TextView KCv;
  private bn KCz;
  private j KPc;
  private ImageView KTA;
  private LinearLayout KTB;
  private MaskTextView KTC;
  private SpannableStringBuilder KTD;
  private int KTE;
  private boolean KTF;
  private PBool KTG;
  protected HashMap<String, Integer> KTH;
  private Runnable KTI;
  private String fCM;
  private boolean hasCheck;
  private int viewType;
  
  public SnsLikesTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SnsLikesTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(98838);
    this.fCM = null;
    this.hasCheck = true;
    this.KCv = null;
    this.KTA = null;
    this.KTB = null;
    this.KTC = null;
    this.KTD = new SpannableStringBuilder(" ");
    this.KTE = 0;
    this.KTF = false;
    this.viewType = 0;
    this.KPc = null;
    this.KTG = null;
    this.KTH = null;
    this.KBw = null;
    this.KCz = null;
    this.KTI = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98837);
        SnsLikesTextView.b(SnsLikesTextView.this);
        AppMethodBeat.o(98837);
      }
    };
    inflate(getContext(), i.g.sns_like_text_layout, this);
    this.KCv = ((TextView)findViewById(i.f.sns_like_op_text_view));
    this.KTA = ((ImageView)findViewById(i.f.sns_like_op_icon_view));
    this.KTB = ((LinearLayout)findViewById(i.f.sns_like_op_text_group));
    this.KTC = ((MaskTextView)findViewById(i.f.sns_like_text_view));
    AppMethodBeat.o(98838);
  }
  
  private void fWG()
  {
    int i = 2;
    AppMethodBeat.i(98840);
    Object localObject1 = (Integer)this.KTH.get(this.fCM);
    if (localObject1 != null) {}
    switch (((Integer)localObject1).intValue())
    {
    default: 
    case 0: 
      do
      {
        AppMethodBeat.o(98840);
        return;
        i = this.KTC.getLayout().getLineCount();
        this.KTB.setVisibility(8);
      } while (i <= this.KTE);
      g.Kia.a(this.KBw.convertView, this.KCz, this.KTD.toString(), this.KTD.toString(), i, i, false, this.KBw.position, this.KTE);
      AppMethodBeat.o(98840);
      return;
    case 1: 
      i = this.KTC.getLayout().getLineCount();
      j = Math.max(Math.min(this.KTE, i), 0);
      k = this.KTC.getLayout().getLineVisibleEnd(j - 1);
      localObject1 = this.KTD.subSequence(0, k);
      k = ((CharSequence)localObject1).toString().lastIndexOf(",");
      if ((k > 0) && (k < ((CharSequence)localObject1).length())) {}
      for (localObject1 = new SpannableStringBuilder(((CharSequence)localObject1).subSequence(0, k));; localObject1 = new SpannableStringBuilder((CharSequence)localObject1))
      {
        localObject2 = ((SpannableStringBuilder)localObject1).toString();
        ((SpannableStringBuilder)localObject1).append(",...");
        this.KTC.setText((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
        this.KTB.setVisibility(0);
        this.KCv.setText(getContext().getString(i.j.sns_like_spread));
        this.KTA.setRotation(90.0F);
        this.KTA.setImageDrawable(au.o(getContext(), i.i.icons_filled_arrow, getContext().getResources().getColor(i.c.link_color)));
        g.Kia.a(this.KBw.convertView, this.KCz, (String)localObject2, this.KTD.toString(), j, i, true, this.KBw.position, this.KTE);
        AppMethodBeat.o(98840);
        return;
      }
    case 2: 
      i = this.KTC.getLayout().getLineCount();
      this.KTC.setText(this.KTD, TextView.BufferType.SPANNABLE);
      this.KTB.setVisibility(0);
      this.KTA.setRotation(-90.0F);
      this.KTA.setImageDrawable(au.o(getContext(), i.i.icons_filled_arrow, getContext().getResources().getColor(i.c.link_color)));
      this.KCv.setText(getContext().getString(i.j.sns_like_shrinkup));
      g.Kia.a(this.KBw.convertView, this.KCz, this.KTD.toString(), this.KTD.toString(), i, i, false, this.KBw.position, this.KTE);
      AppMethodBeat.o(98840);
      return;
    }
    int j = this.KTC.getLayout().getLineCount();
    Object localObject2 = (String)com.tencent.mm.kernel.h.aHG().aHp().b(2, null);
    localObject1 = (String)com.tencent.mm.kernel.h.aHG().aHp().b(4, null);
    SpannableString localSpannableString = l.b(getContext(), (CharSequence)localObject1, this.KTC.getTextSize());
    int k = Math.max(Math.min(this.KTE, j), 0);
    int m = this.KTC.getLayout().getLineVisibleEnd(k - 1);
    localObject1 = this.KTD.subSequence(0, m);
    m = ((CharSequence)localObject1).toString().lastIndexOf(",");
    if ((m > 0) && (m < ((CharSequence)localObject1).length())) {}
    for (localObject1 = new SpannableStringBuilder(((CharSequence)localObject1).subSequence(0, m));; localObject1 = new SpannableStringBuilder((CharSequence)localObject1))
    {
      if (this.viewType == 10) {
        i = 3;
      }
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
            ((d)com.tencent.mm.kernel.h.ag(d.class)).report22210(this.iXG, 7L);
          }
          AppMethodBeat.o(98835);
        }
      }, i), 0, localSpannableString.length(), 33);
      localObject2 = new StringBuilder(((SpannableStringBuilder)localObject1).toString());
      ((SpannableStringBuilder)localObject1).append(",...").append(",").append(localSpannableString);
      this.KTC.setText((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
      this.KTB.setVisibility(0);
      this.KCv.setText(getContext().getString(i.j.sns_like_spread));
      this.KTA.setRotation(90.0F);
      this.KTA.setImageDrawable(au.o(getContext(), i.i.icons_filled_arrow, getContext().getResources().getColor(i.c.link_color)));
      g.Kia.a(this.KBw.convertView, this.KCz, "," + localSpannableString, this.KTD.toString(), k, j, true, this.KBw.position, this.KTE);
      break;
    }
  }
  
  public final boolean a(b<com.tencent.mm.vending.j.a> paramb, int paramInt1, bm parambm, String paramString, int paramInt2, boolean paramBoolean, PBool paramPBool, bn parambn, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(98843);
    this.KTE = paramInt2;
    this.fCM = paramString;
    this.viewType = paramInt1;
    this.KPc = parambm.KPc;
    this.KTG = paramPBool;
    this.KTF = paramBoolean;
    this.KBw = paramBaseViewHolder;
    this.KCz = parambn;
    this.KTH = parambm.KTH;
    this.KTD.clear();
    parambm = new StringBuffer();
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
          parambn = (String)((com.tencent.mm.vending.j.a)paramb.get(j)).get(1);
          paramBaseViewHolder = l.b(getContext(), parambn, this.KTC.getTextSize());
          if (i != 0)
          {
            this.KTD.append(" ");
            parambm.append(" ");
            i = 0;
            paramString[j] = this.KTD.length();
            paramString[j] += parambn.length();
            parambm.append(parambn);
            this.KTD.append(paramBaseViewHolder);
            parambn = (String)((com.tencent.mm.vending.j.a)paramb.get(j)).get(0);
            if ((com.tencent.mm.plugin.sns.f.a.aZz(parambn)) && (((e)com.tencent.mm.kernel.h.ag(e.class)).getStoryBasicConfig().a(f.a.LEx)) && (o.isShowStoryCheck()))
            {
              this.KTD.append("  ");
              parambn = new com.tencent.mm.plugin.sns.ui.widget.h(((e)com.tencent.mm.kernel.h.ag(e.class)).getStoryUIFactory().zn(true));
              this.KTD.setSpan(parambn, this.KTD.length() - 1, this.KTD.length(), 17);
              break label799;
            }
          }
          else
          {
            this.KTD.append(", ");
            parambm.append(", ");
            continue;
          }
          parambn = ((d)com.tencent.mm.kernel.h.ag(d.class)).getTextStatusSpanSync(this.KTC, parambn, a.b.MzD, this.KTC.getTextSize());
          if (parambn == null) {
            break label799;
          }
          this.KTD.append(" ");
          this.KTD.setSpan(parambn, this.KTD.length() - 1, this.KTD.length(), 17);
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
        parambn = getContext();
        if (paramInt1 == 10) {}
        for (i = i.e.golden_like_icon;; i = i.e.normal_like_icon)
        {
          parambn = au.o(parambn, i, getContext().getResources().getColor(i.c.Link));
          parambn.setBounds(0, 0, parambn.getIntrinsicWidth(), parambn.getIntrinsicHeight());
          paramBaseViewHolder = new com.tencent.mm.ui.widget.a(parambn, 1);
          paramBaseViewHolder.Yal = ((int)((parambn.getIntrinsicHeight() - this.KTC.getTextSize() + com.tencent.mm.ci.a.fromDPToPix(getContext(), 2)) / 2.0F));
          this.KTD.setSpan(paramBaseViewHolder, 0, 1, 33);
          if (paramInt1 != 10) {
            break label814;
          }
          paramInt1 = 3;
          break label808;
          while (i < paramString.length)
          {
            parambn = (String)((com.tencent.mm.vending.j.a)paramb.get(i)).get(0);
            paramBaseViewHolder = this.KTD;
            getContext();
            paramBaseViewHolder.setSpan(new q(parambn, new q.a()
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
        }
        this.KTC.setText(this.KTD, TextView.BufferType.SPANNABLE);
        this.KTC.setOriginText(parambm.toString());
        if (paramInt2 > 0)
        {
          if ((getTag() == null) || (!(getTag() instanceof String)) || (!Util.isEqual((String)getTag(), this.KTD.toString())))
          {
            setTag(this.KTD.toString());
            this.KTB.setVisibility(8);
            this.hasCheck = false;
            requestLayout();
            AppMethodBeat.o(98843);
            return true;
          }
          this.hasCheck = true;
          fWG();
        }
      }
      label799:
      j += 1;
    }
    for (;;)
    {
      label808:
      i = 0;
      break;
      label814:
      paramInt1 = 2;
    }
  }
  
  public String getKey()
  {
    return this.fCM;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(98839);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = this.KTC.getLineCount();
    if ((this.KTE > 0) && (paramInt1 > this.KTE) && (this.KTG != null)) {
      this.KTG.value = true;
    }
    if ((this.KTE > 0) && (this.KTH != null))
    {
      if (this.hasCheck)
      {
        AppMethodBeat.o(98839);
        return;
      }
      this.hasCheck = true;
      if (this.KTH.get(this.fCM) == null)
      {
        if (!this.KTF) {
          break label168;
        }
        if (paramInt1 > this.KTE) {
          break label149;
        }
        this.KTH.put(this.fCM, Integer.valueOf(0));
      }
    }
    for (;;)
    {
      post(this.KTI);
      AppMethodBeat.o(98839);
      return;
      label149:
      this.KTH.put(this.fCM, Integer.valueOf(1));
      continue;
      label168:
      this.KTH.put(this.fCM, Integer.valueOf(0));
    }
  }
  
  public void setLikeTvTag(Object paramObject)
  {
    AppMethodBeat.i(98844);
    if (this.KTC != null) {
      this.KTC.setTag(paramObject);
    }
    AppMethodBeat.o(98844);
  }
  
  public void setLikedTextTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    AppMethodBeat.i(98842);
    if (this.KTC != null) {
      this.KTC.setOnTouchListener(paramOnTouchListener);
    }
    AppMethodBeat.o(98842);
  }
  
  public void setOpClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(98841);
    if (this.KTB != null) {
      this.KTB.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(98841);
  }
  
  public void setOpTvTag(Object paramObject)
  {
    AppMethodBeat.i(98845);
    if (this.KTB != null) {
      this.KTB.setTag(paramObject);
    }
    AppMethodBeat.o(98845);
  }
  
  public final void yZ(boolean paramBoolean)
  {
    AppMethodBeat.i(98846);
    if ((this.KTE > 0) && (this.KTH != null))
    {
      Integer localInteger = (Integer)this.KTH.get(this.fCM);
      if (localInteger != null)
      {
        if (paramBoolean)
        {
          if (localInteger.intValue() == 1)
          {
            this.KTH.put(this.fCM, Integer.valueOf(3));
            fWG();
            AppMethodBeat.o(98846);
          }
        }
        else if (localInteger.intValue() == 3)
        {
          this.KTH.put(this.fCM, Integer.valueOf(1));
          fWG();
          AppMethodBeat.o(98846);
        }
      }
      else {
        this.KTH.put(this.fCM, Integer.valueOf(0));
      }
    }
    AppMethodBeat.o(98846);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsLikesTextView
 * JD-Core Version:    0.7.0.1
 */