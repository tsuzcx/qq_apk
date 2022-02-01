package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
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
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.e;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.g;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.widget.k;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.plugin.story.api.f.a;
import com.tencent.mm.plugin.story.api.n;
import com.tencent.mm.plugin.story.api.o;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.pluginsdk.ui.span.u;
import com.tencent.mm.pluginsdk.ui.span.u.a;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.bb;
import com.tencent.mm.vending.d.b;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class SnsLikesTextView
  extends RelativeLayout
  implements bn.a
{
  private Drawable Qey;
  private String Qez;
  private BaseTimeLineItem.BaseViewHolder Rbd;
  private TextView Rcd;
  private bo Rch;
  private j RoO;
  private SpannableStringBuilder RtA;
  private int RtB;
  private boolean RtC;
  private PBool RtD;
  protected HashMap<String, Integer> RtE;
  private Runnable RtF;
  private ImageView Rtx;
  private LinearLayout Rty;
  private MaskTextView Rtz;
  private String hHB;
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
    this.hHB = null;
    this.hasCheck = true;
    this.Rcd = null;
    this.Rtx = null;
    this.Rty = null;
    this.Rtz = null;
    this.RtA = new SpannableStringBuilder(" ");
    this.RtB = 0;
    this.RtC = false;
    this.viewType = 0;
    this.RoO = null;
    this.RtD = null;
    this.RtE = null;
    this.Rbd = null;
    this.Rch = null;
    this.RtF = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98837);
        SnsLikesTextView.f(SnsLikesTextView.this);
        AppMethodBeat.o(98837);
      }
    };
    inflate(getContext(), b.g.sns_like_text_layout, this);
    this.Rcd = ((TextView)findViewById(b.f.sns_like_op_text_view));
    this.Rtx = ((ImageView)findViewById(b.f.sns_like_op_icon_view));
    this.Rty = ((LinearLayout)findViewById(b.f.sns_like_op_text_group));
    this.Rtz = ((MaskTextView)findViewById(b.f.sns_like_text_view));
    AppMethodBeat.o(98838);
  }
  
  private void hoX()
  {
    int i = 2;
    AppMethodBeat.i(98840);
    Object localObject1 = (Integer)this.RtE.get(this.hHB);
    if (localObject1 != null) {}
    switch (((Integer)localObject1).intValue())
    {
    default: 
    case 0: 
      do
      {
        AppMethodBeat.o(98840);
        return;
        i = this.Rtz.getLayout().getLineCount();
        this.Rty.setVisibility(8);
      } while (i <= this.RtB);
      com.tencent.mm.plugin.sns.statistics.j.QFS.a(this.Rbd.convertView, this.Rch, this.RtA.toString(), this.RtA.toString(), i, i, false, this.Rbd.position, this.RtB);
      AppMethodBeat.o(98840);
      return;
    case 1: 
      i = this.Rtz.getLayout().getLineCount();
      j = Math.max(Math.min(this.RtB, i), 0);
      k = this.Rtz.getLayout().getLineVisibleEnd(j - 1);
      localObject1 = this.RtA.subSequence(0, k);
      k = ((CharSequence)localObject1).toString().lastIndexOf(",");
      if ((k > 0) && (k < ((CharSequence)localObject1).length())) {}
      for (localObject1 = new SpannableStringBuilder(((CharSequence)localObject1).subSequence(0, k));; localObject1 = new SpannableStringBuilder((CharSequence)localObject1))
      {
        localObject2 = ((SpannableStringBuilder)localObject1).toString();
        ((SpannableStringBuilder)localObject1).append(",...");
        this.Rtz.setText((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
        this.Rty.setVisibility(0);
        this.Rcd.setText(getContext().getString(b.j.sns_like_spread));
        this.Rtx.setRotation(90.0F);
        this.Rtx.setImageDrawable(bb.m(getContext(), b.i.icons_filled_arrow, getContext().getResources().getColor(b.c.link_color)));
        com.tencent.mm.plugin.sns.statistics.j.QFS.a(this.Rbd.convertView, this.Rch, (String)localObject2, this.RtA.toString(), j, i, true, this.Rbd.position, this.RtB);
        AppMethodBeat.o(98840);
        return;
      }
    case 2: 
      i = this.Rtz.getLayout().getLineCount();
      this.Rtz.setText(this.RtA, TextView.BufferType.SPANNABLE);
      this.Rty.setVisibility(0);
      this.Rtx.setRotation(-90.0F);
      this.Rtx.setImageDrawable(bb.m(getContext(), b.i.icons_filled_arrow, getContext().getResources().getColor(b.c.link_color)));
      this.Rcd.setText(getContext().getString(b.j.sns_like_shrinkup));
      com.tencent.mm.plugin.sns.statistics.j.QFS.a(this.Rbd.convertView, this.Rch, this.RtA.toString(), this.RtA.toString(), i, i, false, this.Rbd.position, this.RtB);
      AppMethodBeat.o(98840);
      return;
    }
    int j = this.Rtz.getLayout().getLineCount();
    Object localObject2 = (String)h.baE().ban().d(2, null);
    localObject1 = (String)h.baE().ban().d(4, null);
    SpannableString localSpannableString = p.b(getContext(), (CharSequence)localObject1, this.Rtz.getTextSize());
    int k = Math.max(Math.min(this.RtB, j), 0);
    int m = this.Rtz.getLayout().getLineVisibleEnd(k - 1);
    localObject1 = this.RtA.subSequence(0, m);
    m = ((CharSequence)localObject1).toString().lastIndexOf(",");
    if ((m > 0) && (m < ((CharSequence)localObject1).length())) {}
    for (localObject1 = new SpannableStringBuilder(((CharSequence)localObject1).subSequence(0, m));; localObject1 = new SpannableStringBuilder((CharSequence)localObject1))
    {
      if (this.viewType == 10) {
        i = 3;
      }
      getContext();
      localSpannableString.setSpan(new u(localObject2, new u.a()
      {
        public final void onClick(View paramAnonymousView, Object paramAnonymousObject)
        {
          AppMethodBeat.i(98835);
          if (SnsLikesTextView.a(SnsLikesTextView.this) != null)
          {
            SnsLikesTextView.a(SnsLikesTextView.this).source = 13;
            SnsLikesTextView.a(SnsLikesTextView.this).onClick(paramAnonymousView, paramAnonymousObject);
            ((com.tencent.mm.plugin.textstatus.a.f)h.az(com.tencent.mm.plugin.textstatus.a.f.class)).report22210(this.lzC, 7L);
          }
          AppMethodBeat.o(98835);
        }
      }, i), 0, localSpannableString.length(), 33);
      localObject2 = new StringBuilder(((SpannableStringBuilder)localObject1).toString());
      ((SpannableStringBuilder)localObject1).append(",...").append(",").append(localSpannableString);
      this.Rtz.setText((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
      this.Rty.setVisibility(0);
      this.Rcd.setText(getContext().getString(b.j.sns_like_spread));
      this.Rtx.setRotation(90.0F);
      this.Rtx.setImageDrawable(bb.m(getContext(), b.i.icons_filled_arrow, getContext().getResources().getColor(b.c.link_color)));
      com.tencent.mm.plugin.sns.statistics.j.QFS.a(this.Rbd.convertView, this.Rch, "," + localSpannableString, this.RtA.toString(), k, j, true, this.Rbd.position, this.RtB);
      break;
    }
  }
  
  public final void Ej(boolean paramBoolean)
  {
    AppMethodBeat.i(98846);
    if ((this.RtB > 0) && (this.RtE != null))
    {
      Integer localInteger = (Integer)this.RtE.get(this.hHB);
      if (localInteger != null)
      {
        if (paramBoolean)
        {
          if (localInteger.intValue() == 1)
          {
            this.RtE.put(this.hHB, Integer.valueOf(3));
            hoX();
            AppMethodBeat.o(98846);
          }
        }
        else if (localInteger.intValue() == 3)
        {
          this.RtE.put(this.hHB, Integer.valueOf(1));
          hoX();
          AppMethodBeat.o(98846);
        }
      }
      else {
        this.RtE.put(this.hHB, Integer.valueOf(0));
      }
    }
    AppMethodBeat.o(98846);
  }
  
  public final boolean a(b<com.tencent.mm.vending.j.a> paramb, int paramInt1, bn parambn, String paramString, int paramInt2, boolean paramBoolean, PBool paramPBool, bo parambo, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(98843);
    this.RtB = paramInt2;
    this.hHB = paramString;
    this.viewType = paramInt1;
    this.RoO = parambn.RoO;
    this.RtD = paramPBool;
    this.RtC = paramBoolean;
    this.Rbd = paramBaseViewHolder;
    this.Rch = parambo;
    this.RtE = parambn.RtE;
    this.RtA.clear();
    parambn = new StringBuffer();
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
          paramBaseViewHolder = (String)((com.tencent.mm.vending.j.a)paramb.get(j)).get(1);
          SpannableString localSpannableString = p.b(getContext(), paramBaseViewHolder, this.Rtz.getTextSize());
          if (i != 0)
          {
            if ((parambo != null) && (parambo.PJQ != null) && (parambo.PJQ.isSocialAttitudeAd()))
            {
              this.RtA.append("  ");
              parambn.append("  ");
              break label930;
              paramString[j] = this.RtA.length();
              paramString[j] += paramBaseViewHolder.length();
              parambn.append(paramBaseViewHolder);
              this.RtA.append(localSpannableString);
              paramBaseViewHolder = (String)((com.tencent.mm.vending.j.a)paramb.get(j)).get(0);
              if ((!com.tencent.mm.plugin.sns.easteregg.a.aXK(paramBaseViewHolder)) || (!((e)h.az(e.class)).getStoryBasicConfig().a(f.a.Sii)) || (!o.isShowStoryCheck())) {
                break label439;
              }
              this.RtA.append("  ");
              paramBaseViewHolder = new k(((e)h.az(e.class)).getStoryUIFactory().EE(true));
              this.RtA.setSpan(paramBaseViewHolder, this.RtA.length() - 1, this.RtA.length(), 17);
              break label936;
            }
            this.RtA.append(" ");
            parambn.append(" ");
          }
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
        this.RtA.append(", ");
        parambn.append(", ");
        break;
        label439:
        paramBaseViewHolder = ((com.tencent.mm.plugin.textstatus.a.f)h.az(com.tencent.mm.plugin.textstatus.a.f.class)).getTextStatusSpanSync(this.Rtz, paramBaseViewHolder, com.tencent.mm.plugin.textstatus.a.a.b.ThH, this.Rtz.getTextSize());
        if (paramBaseViewHolder == null) {
          break label936;
        }
        this.RtA.append(" ");
        this.RtA.setSpan(paramBaseViewHolder, this.RtA.length() - 1, this.RtA.length(), 17);
        break label936;
        paramBaseViewHolder = getContext();
        if (paramInt1 == 10) {}
        for (i = b.e.golden_like_icon;; i = b.e.normal_like_icon)
        {
          paramBaseViewHolder = bb.m(paramBaseViewHolder, i, getContext().getResources().getColor(b.c.Link));
          paramBaseViewHolder.setBounds(0, 0, paramBaseViewHolder.getIntrinsicWidth(), paramBaseViewHolder.getIntrinsicHeight());
          if ((parambo == null) || (parambo.PJQ == null) || (!parambo.PJQ.isSocialAttitudeAd())) {
            break;
          }
          parambo = parambo.PJQ.getAdXml().adSocialInfo.QYg;
          this.Rtz.setTag(b.f.sns_ad_social_img_url, parambo);
          this.Qey = paramBaseViewHolder;
          this.Qez = parambo;
          com.tencent.mm.plugin.sns.ad.j.a.a(parambo, new a(this));
          break label945;
          while (i < paramString.length)
          {
            parambo = (String)((com.tencent.mm.vending.j.a)paramb.get(i)).get(0);
            paramBaseViewHolder = this.RtA;
            getContext();
            paramBaseViewHolder.setSpan(new u(parambo, new u.a()
            {
              public final void onClick(View paramAnonymousView, Object paramAnonymousObject)
              {
                AppMethodBeat.i(98836);
                if (SnsLikesTextView.a(SnsLikesTextView.this) != null)
                {
                  SnsLikesTextView.a(SnsLikesTextView.this).source = 13;
                  SnsLikesTextView.a(SnsLikesTextView.this).onClick(paramAnonymousView, paramAnonymousObject);
                }
                AppMethodBeat.o(98836);
              }
            }, paramInt1), paramString[i], paramPBool[i], 33);
            i += 1;
          }
        }
        this.Rtz.setTag(b.f.sns_ad_social_img_url, "");
        parambo = new com.tencent.mm.ui.widget.a(paramBaseViewHolder, 1);
        parambo.afSg = ((int)((paramBaseViewHolder.getIntrinsicHeight() - this.Rtz.getTextSize() + com.tencent.mm.cd.a.fromDPToPix(getContext(), 2)) / 2.0F));
        this.RtA.setSpan(parambo, 0, 1, 33);
        break label945;
        this.Rtz.setText(this.RtA, TextView.BufferType.SPANNABLE);
        this.Rtz.setOriginText(parambn.toString());
        if (paramInt2 > 0)
        {
          if ((getTag() == null) || (!(getTag() instanceof String)) || (!Util.isEqual((String)getTag(), this.RtA.toString())))
          {
            setTag(this.RtA.toString());
            this.Rty.setVisibility(8);
            this.hasCheck = false;
            requestLayout();
            AppMethodBeat.o(98843);
            return true;
          }
          this.hasCheck = true;
          hoX();
        }
      }
      label930:
      i = 0;
      continue;
      label936:
      j += 1;
    }
    label945:
    if (paramInt1 == 10) {}
    for (paramInt1 = 3;; paramInt1 = 2)
    {
      i = 0;
      break;
    }
  }
  
  public String getKey()
  {
    return this.hHB;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(98839);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = this.Rtz.getLineCount();
    if ((this.RtB > 0) && (paramInt1 > this.RtB) && (this.RtD != null)) {
      this.RtD.value = true;
    }
    if ((this.RtB > 0) && (this.RtE != null))
    {
      if (this.hasCheck)
      {
        AppMethodBeat.o(98839);
        return;
      }
      this.hasCheck = true;
      if (this.RtE.get(this.hHB) == null)
      {
        if (!this.RtC) {
          break label168;
        }
        if (paramInt1 > this.RtB) {
          break label149;
        }
        this.RtE.put(this.hHB, Integer.valueOf(0));
      }
    }
    for (;;)
    {
      post(this.RtF);
      AppMethodBeat.o(98839);
      return;
      label149:
      this.RtE.put(this.hHB, Integer.valueOf(1));
      continue;
      label168:
      this.RtE.put(this.hHB, Integer.valueOf(0));
    }
  }
  
  public void setLikeTvTag(Object paramObject)
  {
    AppMethodBeat.i(98844);
    if (this.Rtz != null) {
      this.Rtz.setTag(paramObject);
    }
    AppMethodBeat.o(98844);
  }
  
  public void setLikedTextTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    AppMethodBeat.i(98842);
    if (this.Rtz != null) {
      this.Rtz.setOnTouchListener(paramOnTouchListener);
    }
    AppMethodBeat.o(98842);
  }
  
  public void setOpClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(98841);
    if (this.Rty != null) {
      this.Rty.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(98841);
  }
  
  public void setOpTvTag(Object paramObject)
  {
    AppMethodBeat.i(98845);
    if (this.Rty != null) {
      this.Rty.setTag(paramObject);
    }
    AppMethodBeat.o(98845);
  }
  
  static final class a
    implements com.tencent.mm.plugin.sns.ad.j.a.b
  {
    private int Qev;
    private WeakReference<SnsLikesTextView> RtH;
    
    public a(SnsLikesTextView paramSnsLikesTextView)
    {
      AppMethodBeat.i(308262);
      this.RtH = new WeakReference(paramSnsLikesTextView);
      this.Qev = com.tencent.mm.cd.a.fromDPToPix(paramSnsLikesTextView.getContext(), 16);
      AppMethodBeat.o(308262);
    }
    
    public final void g(Bitmap paramBitmap, boolean paramBoolean)
    {
      AppMethodBeat.i(308266);
      try
      {
        Object localObject1 = this.RtH;
        if (localObject1 == null)
        {
          AppMethodBeat.o(308266);
          return;
        }
        SnsLikesTextView localSnsLikesTextView = (SnsLikesTextView)this.RtH.get();
        if (localSnsLikesTextView == null)
        {
          AppMethodBeat.o(308266);
          return;
        }
        Object localObject2 = SnsLikesTextView.b(localSnsLikesTextView).getTag(b.f.sns_ad_social_img_url);
        localObject1 = SnsLikesTextView.c(localSnsLikesTextView);
        if ((localObject2 instanceof String))
        {
          localObject2 = (String)localObject2;
          if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).equals(localObject2)) && (SnsLikesTextView.d(localSnsLikesTextView) != null))
          {
            localObject2 = SnsLikesTextView.e(localSnsLikesTextView);
            localObject1 = localObject2;
            if (paramBoolean)
            {
              localObject1 = localObject2;
              if (paramBitmap != null)
              {
                localObject1 = new BitmapDrawable(MMApplicationContext.getContext().getResources(), paramBitmap);
                ((BitmapDrawable)localObject1).setBounds(0, 0, this.Qev, this.Qev);
              }
            }
            ((Drawable)localObject1).setColorFilter(localSnsLikesTextView.getResources().getColor(b.c.Link), PorterDuff.Mode.SRC_ATOP);
            paramBitmap = new com.tencent.mm.ui.widget.a((Drawable)localObject1, 1);
            SnsLikesTextView.d(localSnsLikesTextView).setSpan(paramBitmap, 0, 1, 33);
            SnsLikesTextView.b(localSnsLikesTextView).setText(SnsLikesTextView.d(localSnsLikesTextView), TextView.BufferType.SPANNABLE);
          }
        }
        AppMethodBeat.o(308266);
        return;
      }
      finally
      {
        Log.e("MicroMsg.SnsLikesTextView", "onDownloadResult, exp=" + paramBitmap.toString());
        AppMethodBeat.o(308266);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsLikesTextView
 * JD-Core Version:    0.7.0.1
 */