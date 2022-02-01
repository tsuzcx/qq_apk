package com.tencent.mm.plugin.sns.ui.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ey;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.as.a;
import com.tencent.mm.model.as.b;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.j.e.a;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ar;
import com.tencent.mm.plugin.sns.model.ar.b;
import com.tencent.mm.plugin.sns.model.at;
import com.tencent.mm.plugin.sns.model.az;
import com.tencent.mm.plugin.sns.model.f;
import com.tencent.mm.plugin.sns.model.f.5;
import com.tencent.mm.plugin.sns.model.f.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.plugin.sns.ui.AsyncNormalTextView;
import com.tencent.mm.plugin.sns.ui.AsyncTextView;
import com.tencent.mm.plugin.sns.ui.MaskTextView;
import com.tencent.mm.plugin.sns.ui.PhotosContent;
import com.tencent.mm.plugin.sns.ui.SnsLikesTextView;
import com.tencent.mm.plugin.sns.ui.SnsTranslateResultView;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.TranslateCommentTextView;
import com.tencent.mm.plugin.sns.ui.ae;
import com.tencent.mm.plugin.sns.ui.bd;
import com.tencent.mm.plugin.sns.ui.bh;
import com.tencent.mm.plugin.sns.ui.bh.c;
import com.tencent.mm.plugin.sns.ui.bi;
import com.tencent.mm.plugin.sns.ui.bl;
import com.tencent.mm.plugin.sns.ui.bn;
import com.tencent.mm.plugin.sns.ui.bo;
import com.tencent.mm.plugin.sns.ui.i.a;
import com.tencent.mm.plugin.sns.ui.widget.SnsAvatarImageView;
import com.tencent.mm.plugin.sns.ui.widget.SnsCommentCollapseLayout;
import com.tencent.mm.plugin.sns.ui.z;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.j.a;
import com.tencent.mm.pluginsdk.ui.span.n;
import com.tencent.mm.pluginsdk.ui.span.p.a;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.byo;
import com.tencent.mm.protocal.protobuf.dfn;
import com.tencent.mm.protocal.protobuf.dft;
import com.tencent.mm.protocal.protobuf.en;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.a.a.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.vending.base.Vending;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public abstract class BaseTimeLineItem
{
  protected boolean Aae = false;
  public ArrayList<ar.b> AuQ = new ArrayList();
  public boolean DEBUG = false;
  protected Activity mActivity;
  protected int oIb;
  protected bh zpI;
  
  private static void a(View paramView, CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt1, int paramInt2)
  {
    if ((paramView instanceof SnsCommentCollapseLayout)) {
      ((SnsCommentCollapseLayout)paramView).a(paramCharSequence1, paramCharSequence2, paramInt1, paramInt2);
    }
    while (!(paramView instanceof TextView)) {
      return;
    }
    ((TextView)paramView).setText(paramCharSequence1);
  }
  
  public static void a(ar.b paramb, BaseViewHolder paramBaseViewHolder, String paramString1, String paramString2)
  {
    if ((paramBaseViewHolder != null) && (paramBaseViewHolder.Ava != null))
    {
      paramBaseViewHolder.Ava.a(paramb, 1, paramString1, paramString2, paramb.zlP);
      paramBaseViewHolder.Ava.setVisibility(0);
    }
  }
  
  private void a(MaskTextView paramMaskTextView, com.tencent.mm.vending.d.b<com.tencent.mm.vending.j.a> paramb, int paramInt)
  {
    if (paramb.size() == 0)
    {
      paramMaskTextView.setVisibility(8);
      return;
    }
    paramMaskTextView.setVisibility(0);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(" ");
    int k = localSpannableStringBuilder.length() - 1;
    StringBuffer localStringBuffer = new StringBuffer();
    int[] arrayOfInt1 = new int[paramb.size()];
    int[] arrayOfInt2 = new int[paramb.size()];
    int j = 1;
    int i = 0;
    Object localObject;
    try
    {
      if (i < paramb.size())
      {
        localObject = (String)((com.tencent.mm.vending.j.a)paramb.get(i)).get(1);
        if (j != 0)
        {
          localSpannableStringBuilder.append(" ");
          localStringBuffer.append(" ");
          j = 0;
        }
        for (;;)
        {
          arrayOfInt1[i] = localSpannableStringBuilder.length();
          arrayOfInt1[i] += ((String)localObject).length();
          localStringBuffer.append((String)localObject);
          localSpannableStringBuilder.append(com.tencent.mm.pluginsdk.ui.span.k.b(this.mActivity, (CharSequence)localObject, paramMaskTextView.getTextSize()));
          i += 1;
          break;
          localSpannableStringBuilder.append(", ");
          localStringBuffer.append(", ");
        }
      }
      localObject = this.mActivity.getResources().getDrawable(2131690249);
    }
    catch (Exception paramMaskTextView)
    {
      ad.e("MicroMsg.BaseTimeLineItem", "setReward error  e:%s", new Object[] { bt.n(paramMaskTextView) });
      return;
    }
    ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
    com.tencent.mm.ui.widget.a locala = new com.tencent.mm.ui.widget.a((Drawable)localObject);
    locala.KQg = ((int)((((Drawable)localObject).getIntrinsicHeight() - paramMaskTextView.getTextSize() + com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 2)) / 2.0F));
    localSpannableStringBuilder.setSpan(locala, k, k + 1, 33);
    if (paramInt == 10)
    {
      paramInt = 3;
      break label403;
      while (i < arrayOfInt1.length)
      {
        localSpannableStringBuilder.setSpan(new com.tencent.mm.pluginsdk.ui.span.p((String)((com.tencent.mm.vending.j.a)paramb.get(i)).get(0), this.zpI.AaS, paramInt), arrayOfInt1[i], arrayOfInt2[i], 33);
        i += 1;
      }
      paramMaskTextView.setText(localSpannableStringBuilder, TextView.BufferType.SPANNABLE);
      paramMaskTextView.setOriginText(localStringBuffer.toString());
      return;
    }
    for (;;)
    {
      label403:
      i = 0;
      break;
      paramInt = 2;
    }
  }
  
  private static void a(bi parambi, TimeLineObject paramTimeLineObject)
  {
    if ((parambi == null) || (paramTimeLineObject == null)) {}
    for (;;)
    {
      return;
      if (paramTimeLineObject.HAS == null) {}
      for (String str = null; !bt.isNullOrNil(str); str = paramTimeLineObject.HAS.Id)
      {
        com.tencent.mm.plugin.sns.c.a.iRH.a(str, paramTimeLineObject.nDo, paramTimeLineObject.HAT.GaP, paramTimeLineObject.HAX, parambi.AmB);
        return;
      }
    }
  }
  
  private static void a(BaseViewHolder paramBaseViewHolder, com.tencent.mm.plugin.sns.storage.p paramp)
  {
    if (paramp.QM(32))
    {
      if (paramBaseViewHolder.AuZ != null) {
        paramBaseViewHolder.AuZ.setVisibility(0);
      }
      paramBaseViewHolder.Avb.setLongClickable(false);
      paramBaseViewHolder.Avb.setOnClickListener(null);
      paramp = new LinearLayout.LayoutParams(-1, -2);
      paramBaseViewHolder.Avb.setLayoutParams(paramp);
      paramBaseViewHolder.Avb.setBackgroundColor(Color.parseColor("#00ffffff"));
      if (paramBaseViewHolder.Avw != null)
      {
        paramp = (LinearLayout.LayoutParams)paramBaseViewHolder.Avw.getLayoutParams();
        paramp.leftMargin = 0;
        paramp.rightMargin = 0;
        paramBaseViewHolder.Avw.setLayoutParams(paramp);
      }
      if (paramBaseViewHolder.AvU)
      {
        paramp = (LinearLayout.LayoutParams)paramBaseViewHolder.Atv.zWx.getLayoutParams();
        paramp.leftMargin = 0;
        paramp.rightMargin = 0;
        paramBaseViewHolder.Atv.zWx.setLayoutParams(paramp);
      }
      return;
    }
    if (paramBaseViewHolder.AuZ != null) {
      paramBaseViewHolder.AuZ.setVisibility(0);
    }
    paramBaseViewHolder.Avb.setLongClickable(false);
    paramBaseViewHolder.Avb.setOnClickListener(null);
    if (paramBaseViewHolder.Avw != null)
    {
      paramp = (LinearLayout.LayoutParams)paramBaseViewHolder.Avw.getLayoutParams();
      paramp.leftMargin = 0;
      paramp.rightMargin = 0;
      paramBaseViewHolder.Avw.setLayoutParams(paramp);
    }
    if (paramBaseViewHolder.AvU)
    {
      paramp = (LinearLayout.LayoutParams)paramBaseViewHolder.Atv.zWx.getLayoutParams();
      paramp.leftMargin = 0;
      paramp.rightMargin = 0;
      paramBaseViewHolder.Atv.zWx.setLayoutParams(paramp);
    }
    paramp = new LinearLayout.LayoutParams(-1, -2);
    paramBaseViewHolder.Avb.setLayoutParams(paramp);
    paramBaseViewHolder.Avb.setBackgroundColor(Color.parseColor("#00ffffff"));
  }
  
  private boolean a(List<dfn> paramList, com.tencent.mm.vending.d.b<com.tencent.mm.vending.j.a> paramb, BaseViewHolder paramBaseViewHolder)
  {
    LinearLayout localLinearLayout = paramBaseViewHolder.Avs;
    int i1 = localLinearLayout.getChildCount();
    int j = paramb.size();
    int i;
    if (i1 > j)
    {
      i = j;
      while (i < i1)
      {
        localObject1 = localLinearLayout.getChildAt(j);
        localLinearLayout.removeViewAt(j);
        if ((localObject1 instanceof SnsCommentCollapseLayout)) {
          this.zpI.a((SnsCommentCollapseLayout)localObject1);
        }
        i += 1;
      }
    }
    if (paramb.size() == 0)
    {
      localLinearLayout.setVisibility(8);
      return false;
    }
    localLinearLayout.setVisibility(0);
    Object localObject1 = this.zpI.ecL();
    if ((localObject1 instanceof com.tencent.mm.plugin.sns.ui.a.c)) {}
    for (bi localbi = (bi)((com.tencent.mm.plugin.sns.ui.a.c)localObject1).Ard.get(paramBaseViewHolder.position);; localbi = null)
    {
      if (this.DEBUG) {
        ad.d("MicroMsg.BaseTimeLineItem", "debug:setCommentList position " + paramBaseViewHolder.position + " commentCount: " + j);
      }
      StringBuilder localStringBuilder1 = new StringBuilder();
      StringBuilder localStringBuilder2 = new StringBuilder();
      int m = 0;
      i = 0;
      int k = 0;
      long l;
      String str1;
      String str2;
      String str3;
      Object localObject4;
      Object localObject7;
      Object localObject5;
      if (m < paramb.size())
      {
        localObject1 = (com.tencent.mm.vending.j.a)paramb.get(m);
        l = ((Long)((com.tencent.mm.vending.j.a)localObject1).get(0)).longValue();
        str1 = (String)((com.tencent.mm.vending.j.a)localObject1).get(1);
        str2 = (String)((com.tencent.mm.vending.j.a)localObject1).get(2);
        str3 = (String)((com.tencent.mm.vending.j.a)localObject1).get(3);
        localObject4 = (CharSequence)((com.tencent.mm.vending.j.a)localObject1).get(4);
        localObject7 = (String)((com.tencent.mm.vending.j.a)localObject1).get(5);
        localObject5 = (CharSequence)((com.tencent.mm.vending.j.a)localObject1).get(6);
        if (bt.isNullOrNil((String)localObject7)) {
          break label2209;
        }
        j = 1;
        localStringBuilder2.append(l).append("|");
      }
      for (;;)
      {
        localStringBuilder1.append(l).append("|");
        dfn localdfn = (dfn)paramList.get(m);
        i = localdfn.HtL;
        int i2 = localdfn.DeleteFlag;
        Object localObject6 = bo(paramBaseViewHolder.dzb, l);
        if ((localObject6 != null) && (((ar.b)localObject6).aGQ)) {
          ar.eU(((ar.b)localObject6).id, 2);
        }
        label517:
        int n;
        if (k >= i1) {
          if ((localObject6 == null) || (((ar.b)localObject6).aGQ))
          {
            localObject1 = this.zpI.ecH();
            ((SnsCommentCollapseLayout)localObject1).setTextSize$255e752(15.0F * com.tencent.mm.cc.a.eb(((View)localObject1).getContext()));
            if (this.zpI.AjJ == -1) {
              this.zpI.AjJ = this.mActivity.getResources().getColor(2131100907);
            }
            ((SnsCommentCollapseLayout)localObject1).setTextColor(this.zpI.AjJ);
            ((SnsCommentCollapseLayout)localObject1).setGravity(16);
            n = 1;
            label520:
            if (localObject6 == null) {
              break label1204;
            }
            if ((localObject1 instanceof TranslateCommentTextView)) {
              break label2206;
            }
            localLinearLayout.removeView((View)localObject1);
            localObject1 = new TranslateCommentTextView(this.mActivity);
            localLinearLayout.addView((View)localObject1, k);
            ((TranslateCommentTextView)localObject1).getTranslateResultView().setResultTextSize$255e752(15.0F * com.tencent.mm.cc.a.eb(((View)localObject1).getContext()));
            ((TranslateCommentTextView)localObject1).getOriginCommentTextView().setTextSize(1, 15.0F * com.tencent.mm.cc.a.eb(((View)localObject1).getContext()));
          }
        }
        label1166:
        label2203:
        label2206:
        for (;;)
        {
          localObject7 = (TranslateCommentTextView)localObject1;
          ((View)localObject1).setOnTouchListener(null);
          a(((TranslateCommentTextView)localObject7).getOriginCommentTextView(), (CharSequence)localObject5, (CharSequence)localObject4, i, i2);
          label750:
          Object localObject2;
          if (!((ar.b)localObject6).hII)
          {
            ((TranslateCommentTextView)localObject7).AqJ.setTextSize(1, 15.0F * com.tencent.mm.cc.a.eb(((TranslateCommentTextView)localObject7).getContext()));
            ((TranslateCommentTextView)localObject7).Ack.Rt(2);
            ((TranslateCommentTextView)localObject7).Ack.setVisibility(0);
            i = 1;
            if (k <= 0) {
              break label1906;
            }
            ((View)localObject1).setPadding(com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 8), com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 4), com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 0), com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 3));
            if (k != paramb.size() - 1) {
              break label1895;
            }
            ((View)localObject1).setBackgroundResource(2131234841);
            if (i != 0)
            {
              localObject2 = (TranslateCommentTextView)localObject1;
              i = (int)this.mActivity.getResources().getDimension(2131165568);
              ((TranslateCommentTextView)localObject2).Ack.getSplitlineView().setPadding(0, 0, i, 0);
            }
            if (!com.tencent.mm.plugin.sns.ui.widget.e.b(localdfn)) {
              break label2012;
            }
            ((View)localObject1).setOnLongClickListener(null);
            ((View)localObject1).setOnClickListener(null);
            label814:
            if (localbi != null) {
              ((View)localObject1).setTag(new com.tencent.mm.plugin.sns.ui.m(localbi.zQD, localbi.AmA, localdfn, str1, str3, (View)localObject1, 1, localbi.lEN));
            }
            if (n != 0)
            {
              localLinearLayout.removeView((View)localObject1);
              localLinearLayout.addView((View)localObject1);
            }
            m += 1;
            i = j;
            k += 1;
            break;
            localObject1 = new TranslateCommentTextView(this.mActivity);
            ((TranslateCommentTextView)localObject1).getTranslateResultView().setResultTextSize$255e752(15.0F * com.tencent.mm.cc.a.eb(((View)localObject1).getContext()));
            ((TranslateCommentTextView)localObject1).getOriginCommentTextView().setTextSize(1, 15.0F * com.tencent.mm.cc.a.eb(((View)localObject1).getContext()));
            break label517;
            localObject1 = localLinearLayout.getChildAt(k);
            n = 0;
            break label520;
          }
          Object localObject8;
          Object localObject3;
          if (!((ar.b)localObject6).aGQ)
          {
            localObject4 = ((ar.b)localObject6).result;
            localObject5 = ((ar.b)localObject6).hQG;
            localObject8 = ((TranslateCommentTextView)localObject7).AqJ.getText().toString();
            if (!bt.isNullOrNil((String)localObject8))
            {
              localObject2 = ((String)localObject8).split(":");
              if (localObject2.length <= 2) {
                break label2203;
              }
              localObject3 = new String[2];
              localObject3[0] = localObject2[0];
              localObject3[1] = ((String)localObject8).substring(localObject3[0].length() + 1);
              localObject2 = localObject3;
            }
          }
          for (;;)
          {
            if (localObject2.length == 2)
            {
              if (bt.isNullOrNil((String)localObject4)) {
                break label1166;
              }
              ((TranslateCommentTextView)localObject7).Ack.a((ar.b)localObject6, 2, localObject2[0] + ": " + (String)localObject4, (String)localObject5, ((ar.b)localObject6).zlP);
            }
            for (;;)
            {
              ((TranslateCommentTextView)localObject7).Ack.setVisibility(0);
              ((TranslateCommentTextView)localObject7).AqJ.setTextSize(1, 15.0F * com.tencent.mm.cc.a.eb(((TranslateCommentTextView)localObject7).getContext()));
              i = 1;
              break;
              ((TranslateCommentTextView)localObject7).Ack.a((ar.b)localObject6, 2, null, (String)localObject5, ((ar.b)localObject6).zlP);
            }
            ((TranslateCommentTextView)localObject7).getTranslateResultView().setVisibility(8);
            i = 1;
            break;
            label1204:
            localObject2 = localObject1;
            if (n == 0)
            {
              localObject2 = localObject1;
              if ((localObject1 instanceof TranslateCommentTextView))
              {
                localLinearLayout.removeView((View)localObject1);
                localObject2 = this.zpI.ecH();
                localLinearLayout.addView((View)localObject2, k);
                ((SnsCommentCollapseLayout)localObject2).setTextSize$255e752(15.0F * com.tencent.mm.cc.a.eb(((View)localObject2).getContext()));
              }
            }
            if ((localObject2 instanceof SnsCommentCollapseLayout))
            {
              ((SnsCommentCollapseLayout)localObject2).setTextSize$255e752(15.0F * com.tencent.mm.cc.a.eb(((View)localObject2).getContext()));
              ((SnsCommentCollapseLayout)localObject2).setOpClickListener(this.zpI.AjW);
              ((SnsCommentCollapseLayout)localObject2).setPressTouchListener(new n(this.mActivity));
            }
            localObject3 = new CharSequence[2];
            localObject3[0] = localObject5;
            localObject3[1] = localObject4;
            localObject2.hashCode();
            if ((bt.isNullOrNil((String)localObject7)) || (!(localObject2 instanceof SnsCommentCollapseLayout)))
            {
              a((View)localObject2, localObject3[0], localObject3[1], i, i2);
              i = 0;
              localObject1 = localObject2;
              break;
            }
            localObject1 = ag.dUb();
            localObject6 = new d((String)localObject7, (CharSequence)localObject5, (CharSequence)localObject4, (View)localObject2, i, i2, this.zpI.AjN);
            localObject8 = com.tencent.mm.emoji.loader.a.b.giI;
            localObject8 = com.tencent.mm.emoji.loader.a.b.vT((String)localObject7);
            if (localObject8 == null) {
              ag.dTR().execute(new f.5((f)localObject1, (String)localObject7, (f.d)localObject6));
            }
            int i3 = com.tencent.mm.ui.aq.fromDPToPix(this.mActivity, 28);
            localObject6 = new StringBuilder((String)localObject7);
            if (localObject8 == null)
            {
              ((StringBuilder)localObject6).append("miss");
              ad.i("MicroMsg.BaseTimeLineItem", "wrapEmojiInfo:%s miss cache", new Object[] { ((StringBuilder)localObject6).toString() });
            }
            for (localObject1 = this.mActivity.getResources().getDrawable(2131234117);; localObject1 = new BitmapDrawable((Bitmap)localObject8))
            {
              localObject5 = new SpannableStringBuilder((CharSequence)localObject5);
              ((SpannableStringBuilder)localObject5).append("  ").append(((StringBuilder)localObject6).toString()).append("  ").append(" ");
              int i4 = ((SpannableStringBuilder)localObject5).length() - ((StringBuilder)localObject6).toString().length() - 2 - 1;
              int i5 = ((SpannableStringBuilder)localObject5).length() - ((StringBuilder)localObject6).toString().length() - 4 - 1;
              ((Drawable)localObject1).setBounds(0, 0, i3, i3);
              localObject7 = new com.tencent.mm.ui.widget.a((Drawable)localObject1);
              localObject8 = new com.tencent.mm.pluginsdk.ui.span.p(((StringBuilder)localObject6).toString(), this.zpI.AjN, 2);
              ((SpannableStringBuilder)localObject5).setSpan(localObject7, i4, ((StringBuilder)localObject6).toString().length() + i4, 33);
              ((SpannableStringBuilder)localObject5).setSpan(localObject8, i5, i5 + 4 + ((StringBuilder)localObject6).toString().length(), 33);
              localObject4 = new SpannableStringBuilder((CharSequence)localObject4);
              ((SpannableStringBuilder)localObject4).append("  ").append(((StringBuilder)localObject6).toString()).append("  ").append(" ");
              i4 = ((SpannableStringBuilder)localObject4).length() - ((StringBuilder)localObject6).toString().length() - 2 - 1;
              i5 = ((SpannableStringBuilder)localObject4).length() - ((StringBuilder)localObject6).toString().length() - 4 - 1;
              ((Drawable)localObject1).setBounds(0, 0, i3, i3);
              ((SpannableStringBuilder)localObject4).setSpan(localObject7, i4, ((StringBuilder)localObject6).toString().length() + i4, 33);
              ((SpannableStringBuilder)localObject4).setSpan(localObject8, i5, i5 + 4 + ((StringBuilder)localObject6).toString().length(), 33);
              localObject3[0] = localObject5;
              localObject3[1] = localObject4;
              break;
              ad.i("MicroMsg.BaseTimeLineItem", "wrapEmojiInfo:%s hit cache", new Object[] { ((StringBuilder)localObject6).toString() });
            }
            label1895:
            ((View)localObject1).setBackgroundResource(2131234100);
            break label750;
            label1906:
            ((View)localObject1).setPadding(com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 8), com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 6), com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 0), com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 3));
            if (paramBaseViewHolder.Avr)
            {
              if (paramb.size() == 1)
              {
                ((View)localObject1).setBackgroundResource(2131234841);
                break label750;
              }
              ((View)localObject1).setBackgroundResource(2131234100);
              break label750;
            }
            if (paramb.size() == 1)
            {
              ((View)localObject1).setBackgroundResource(2131234150);
              break label750;
            }
            ((View)localObject1).setBackgroundResource(2131234842);
            break label750;
            label2012:
            ((View)localObject1).setOnLongClickListener(new View.OnLongClickListener()
            {
              public final boolean onLongClick(View paramAnonymousView)
              {
                AppMethodBeat.i(100050);
                Object localObject = new com.tencent.mm.hellhoundlib.b.b();
                ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/item/BaseTimeLineItem$8", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
                localObject = new int[2];
                if ((paramAnonymousView.getTag(2131306044) instanceof int[])) {}
                for (paramAnonymousView = (int[])paramAnonymousView.getTag(2131306044);; paramAnonymousView = (View)localObject)
                {
                  BaseTimeLineItem.this.zpI.ecN().a(this.Aqt, BaseTimeLineItem.this.zpI.zpd.AyD, BaseTimeLineItem.this.zpI.zpd.Ayq, paramAnonymousView[0], paramAnonymousView[1]);
                  com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sns/ui/item/BaseTimeLineItem$8", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                  AppMethodBeat.o(100050);
                  return true;
                }
              }
            });
            ((View)localObject1).setOnClickListener(new i.a(this.zpI.AjE, localdfn, str2, str3, paramBaseViewHolder));
            break label814;
            if (i != 0)
            {
              paramList = com.tencent.mm.plugin.sns.j.e.ztz;
              i = paramBaseViewHolder.position;
              l = localbi.yVM.field_snsId;
              paramb = localStringBuilder2.toString();
              localObject2 = localStringBuilder1.toString();
              paramBaseViewHolder = q.zw(l);
              if (paramList.ztK.get(paramBaseViewHolder) == null)
              {
                localObject1 = new ey();
                ((ey)localObject1).ejz = ((ey)localObject1).t("PublishId", paramBaseViewHolder, true);
                ((ey)localObject1).ejA = ((ey)localObject1).t("CommentIdList", (String)localObject2, true);
                ((ey)localObject1).ejB = ((ey)localObject1).t("EmojiIdList", paramb, true);
                paramb = new e.a(paramList);
                paramb.position = i;
                paramb.zuo = ((ey)localObject1);
                paramList.ztK.put(paramBaseViewHolder, paramb);
              }
            }
            return true;
          }
        }
        label2209:
        j = i;
      }
    }
  }
  
  private ar.b bo(String paramString, long paramLong)
  {
    if (this.AuQ.size() <= 0) {
      return null;
    }
    Iterator localIterator = this.AuQ.iterator();
    while (localIterator.hasNext())
    {
      ar.b localb = (ar.b)localIterator.next();
      if ((localb.id != null) && (localb.id.equals(ar.jp(paramString, String.valueOf(paramLong))))) {
        return localb;
      }
    }
    return null;
  }
  
  public static void i(BaseViewHolder paramBaseViewHolder)
  {
    if ((paramBaseViewHolder != null) && (paramBaseViewHolder.Ava != null))
    {
      paramBaseViewHolder.Ava.Rt(1);
      paramBaseViewHolder.Ava.setVisibility(0);
    }
  }
  
  public static void j(BaseViewHolder paramBaseViewHolder)
  {
    if ((paramBaseViewHolder != null) && (paramBaseViewHolder.Ava != null)) {
      paramBaseViewHolder.Ava.setVisibility(8);
    }
  }
  
  public final View a(Activity paramActivity, BaseViewHolder paramBaseViewHolder, int paramInt, bh parambh, com.tencent.mm.plugin.sns.storage.p paramp)
  {
    this.mActivity = paramActivity;
    this.oIb = paramInt;
    this.zpI = parambh;
    paramBaseViewHolder.dzb = paramp.getSnsId();
    Object localObject;
    View localView;
    switch (paramInt)
    {
    case 17: 
    case 18: 
    default: 
      localObject = "R.layout.sns_media_sub_item2";
      com.tencent.mm.kiss.a.b.akC();
      localView = com.tencent.mm.kiss.a.b.c(this.mActivity, 2131495612);
      paramBaseViewHolder.Awd = localView;
      paramBaseViewHolder.Awc = ((String)localObject);
      localObject = localView.findViewById(2131300969);
      if (!(localObject instanceof ViewStub)) {
        break;
      }
    }
    for (paramBaseViewHolder.Avc = ((ViewStub)localObject);; paramBaseViewHolder.Avc = null)
    {
      ad.i("MicroMsg.BaseTimeLineItem", "create new item  " + paramInt + "  " + localView.hashCode());
      paramBaseViewHolder.AvV = localView.findViewById(2131305085);
      paramBaseViewHolder.oIb = paramInt;
      paramBaseViewHolder.AuV = ((SnsAvatarImageView)localView.findViewById(2131296533));
      paramBaseViewHolder.AuV.setWeakContext(paramActivity);
      paramBaseViewHolder.AuV.setOnClickListener(parambh.zpd.Ayr);
      paramBaseViewHolder.AuV.setOnLongClickListener(parambh.zpd.Ays);
      paramBaseViewHolder.AuV.setOnTouchListener(new BaseTimeLineItem.1(this));
      paramBaseViewHolder.AuW = ((AsyncTextView)localView.findViewById(2131302867));
      paramBaseViewHolder.AuX = ((ImageView)localView.findViewById(2131306175));
      paramBaseViewHolder.AuW.setOnTouchListener(new ae());
      paramBaseViewHolder.AuY = ((ViewGroup)localView.findViewById(2131302862));
      paramBaseViewHolder.AuZ = ((AsyncNormalTextView)localView.findViewById(2131299001));
      paramBaseViewHolder.AuZ.setOpClickListener(parambh.AjT);
      paramBaseViewHolder.AuZ.setShrinkOrSpreadListener(parambh.AjU);
      paramBaseViewHolder.Avb = ((LinearLayout)localView.findViewById(2131300970));
      paramBaseViewHolder.Avb.setTag(paramBaseViewHolder);
      paramBaseViewHolder.Avb.setOnClickListener(parambh.zpd.Azc);
      localObject = localView.findViewById(2131299008);
      parambh.ecN().c((View)localObject, parambh.zpd.Ayt, parambh.zpd.Ayq);
      localObject = (TextView)localView.findViewById(2131299009);
      parambh.ecN().c((View)localObject, parambh.zpd.Ayt, parambh.zpd.Ayq);
      paramBaseViewHolder.Ava = ((SnsTranslateResultView)localView.findViewById(2131305091));
      paramBaseViewHolder.Ava.setVisibility(8);
      paramBaseViewHolder.Ava.getSplitlineView().setPadding(0, 0, 0, 0);
      paramBaseViewHolder.Ava.getResultTextView().setBackgroundResource(2131234100);
      parambh.ecN().c(paramBaseViewHolder.Ava.getResultTextView(), parambh.zpd.Ayt, parambh.zpd.Ayq);
      paramBaseViewHolder.Avv = ((LinearLayout)localView.findViewById(2131298526));
      paramBaseViewHolder.Avj = ((TextView)localView.findViewById(2131306999));
      paramBaseViewHolder.timeTv = ((TextView)localView.findViewById(2131296598));
      paramBaseViewHolder.Avl = ((AsyncTextView)localView.findViewById(2131296528));
      paramBaseViewHolder.Avm = ((AsyncTextView)localView.findViewById(2131296527));
      paramBaseViewHolder.AhI = ((TextView)localView.findViewById(2131296531));
      paramBaseViewHolder.zcq = new bn(localView);
      paramBaseViewHolder.zcq.a(parambh.zpd.AyB, parambh.zpd.AyR);
      paramBaseViewHolder.Avi = ((RelativeLayout)localView.findViewById(2131303033));
      paramBaseViewHolder.Avi.setOnClickListener(parambh.zpd.AyU);
      paramBaseViewHolder.zRl = ((TextView)localView.findViewById(2131296566));
      paramBaseViewHolder.zRl.setText(paramActivity.getString(2131755707));
      paramBaseViewHolder.zRl.setOnClickListener(parambh.zpd.Ayv);
      paramBaseViewHolder.Avl.setOnClickListener(parambh.zpd.AyS);
      paramBaseViewHolder.Avm.setOnClickListener(parambh.zpd.AyT);
      paramBaseViewHolder.AhI.setOnClickListener(parambh.zpd.AyO);
      paramBaseViewHolder.Avn = localView.findViewById(2131296570);
      paramBaseViewHolder.Avn.setOnClickListener(parambh.zpd.AyA);
      paramBaseViewHolder.Avk = ((WeImageView)localView.findViewById(2131296627));
      paramBaseViewHolder.iCU = ((TextView)localView.findViewById(2131296569));
      paramBaseViewHolder.Avo = ((ImageView)localView.findViewById(2131296599));
      paramBaseViewHolder.Avy = ((ViewStub)localView.findViewById(2131296561));
      paramBaseViewHolder.zOk = ((LinearLayout)localView.findViewById(2131296590));
      paramBaseViewHolder.AvX = ((ViewStub)localView.findViewById(2131296572));
      paramBaseViewHolder.Awf = ((ViewStub)localView.findViewById(2131305093));
      paramBaseViewHolder.Awj = ((ViewStub)localView.findViewById(2131308006));
      paramBaseViewHolder.iLQ = ((ViewGroup)localView.findViewById(2131304988));
      paramBaseViewHolder.AvA = ((ViewStub)localView.findViewById(2131305041));
      paramBaseViewHolder.Ave = ((TextView)localView.findViewById(2131300513));
      paramBaseViewHolder.Ave.setOnClickListener(parambh.zpd.Ayw);
      BaseViewHolder.a(paramBaseViewHolder, (TextView)localView.findViewById(2131300687));
      paramBaseViewHolder.tPw = localView;
      if (this.Aae)
      {
        com.tencent.mm.plugin.sns.abtest.c.b(localView, paramBaseViewHolder);
        com.tencent.mm.plugin.sns.abtest.a.a(localView, paramBaseViewHolder);
        ag.dTV();
        com.tencent.mm.plugin.sns.h.c.c(localView, paramBaseViewHolder);
      }
      h(paramBaseViewHolder);
      localView.setTag(paramBaseViewHolder);
      a(paramBaseViewHolder, paramp);
      return localView;
      localObject = "R.layout.sns_timeline_item_photo_one3";
      break;
      localObject = "R.layout.sns_timeline_imagesline_one";
      break;
      localObject = "R.layout.sns_timeline_imagesline1";
      break;
      localObject = "R.layout.sns_timeline_imagesline2";
      break;
      localObject = "R.layout.sns_timeline_imagesline3";
      break;
      localObject = "R.layout.sns_media_sub_item2";
      break;
      localObject = "R.layout.sns_media_sight_item";
      break;
      localObject = "R.layout.sns_ad_card_layout_item";
      break;
      localObject = "R.layout.sns_hb_reward_item";
      break;
      localObject = "R.layout.sns_timeline_turn_media";
      break;
      localObject = "R.layout.sns_media_collapse_item";
      break;
      localObject = "R.layout.sns_timeline_ad_full_card";
      break;
      localObject = "R.layout.sns_timeline_ad_sphere_card";
      break;
      localObject = "R.layout.sns_media_sight_item";
      break;
    }
  }
  
  public final void a(BaseViewHolder paramBaseViewHolder, int paramInt, com.tencent.mm.plugin.sns.storage.p paramp)
  {
    paramp = paramp.dYl();
    bi localbi = (bi)this.zpI.ecL().dZP().get(Integer.valueOf(paramInt));
    a(paramBaseViewHolder, paramInt, localbi, paramp, paramBaseViewHolder.oIb, this.zpI);
    a(localbi, paramp);
  }
  
  public final void a(final BaseViewHolder paramBaseViewHolder, int paramInt1, com.tencent.mm.plugin.sns.storage.p paramp, TimeLineObject paramTimeLineObject, int paramInt2, final bh parambh)
  {
    Object localObject2 = (bi)parambh.ecL().dZP().get(Integer.valueOf(paramInt1));
    a(paramBaseViewHolder, paramp);
    this.oIb = paramInt2;
    this.zpI = parambh;
    if (this.Aae) {
      com.tencent.mm.plugin.sns.ui.a.c.S(paramp);
    }
    com.tencent.mm.plugin.sns.ui.a.c.h(paramTimeLineObject);
    com.tencent.mm.plugin.sns.ui.a.c.g(paramTimeLineObject);
    if (paramp.QM(32)) {
      ad.i("MicroMsg.BaseTimeLineItem", "the ad sns id is " + q.zx(paramp.field_snsId) + " for susan");
    }
    paramBaseViewHolder.AuT = ((bi)localObject2).AmB;
    paramBaseViewHolder.uaS = false;
    paramBaseViewHolder.position = paramInt1;
    paramBaseViewHolder.dzb = ((bi)localObject2).AmA;
    paramBaseViewHolder.doX = ((bi)localObject2).zQD;
    paramBaseViewHolder.AuU = ((bi)localObject2).AmF;
    paramBaseViewHolder.Avo.setOnClickListener(parambh.AjS);
    paramBaseViewHolder.timeLineObject = paramTimeLineObject;
    Object localObject3 = ((bi)localObject2).yVL;
    paramBaseViewHolder.snsobj = ((SnsObject)localObject3);
    Object localObject1 = parambh.AjE.zPc.zkL;
    Object localObject4;
    if (paramp != null)
    {
      localObject4 = paramp.dYK();
      ((com.tencent.mm.plugin.sns.j.b)localObject1).zsX.add(localObject4);
      if (paramp.QM(32)) {
        ((com.tencent.mm.plugin.sns.j.b)localObject1).ztc.add(localObject4);
      }
      ((com.tencent.mm.plugin.sns.j.b)localObject1).ztd.add(paramp.field_userName);
    }
    int i;
    label605:
    Object localObject5;
    switch (paramp.field_type)
    {
    default: 
      ((com.tencent.mm.plugin.sns.j.b)localObject1).zti.add(localObject4);
      if (paramInt1 < ((com.tencent.mm.plugin.sns.j.b)localObject1).zsV)
      {
        ((com.tencent.mm.plugin.sns.j.b)localObject1).zsV = paramInt1;
        ((com.tencent.mm.plugin.sns.j.b)localObject1).zrA = q.n(paramp);
      }
      if (paramInt1 > ((com.tencent.mm.plugin.sns.j.b)localObject1).zsW)
      {
        ((com.tencent.mm.plugin.sns.j.b)localObject1).zsW = paramInt1;
        ((com.tencent.mm.plugin.sns.j.b)localObject1).zrB = q.n(paramp);
      }
      ((com.tencent.mm.plugin.sns.j.b)localObject1).zrG = ((com.tencent.mm.plugin.sns.j.b)localObject1).zsY.size();
      ((com.tencent.mm.plugin.sns.j.b)localObject1).zrH = ((com.tencent.mm.plugin.sns.j.b)localObject1).zsZ.size();
      ((com.tencent.mm.plugin.sns.j.b)localObject1).zrI = ((com.tencent.mm.plugin.sns.j.b)localObject1).zta.size();
      ((com.tencent.mm.plugin.sns.j.b)localObject1).zrK = ((com.tencent.mm.plugin.sns.j.b)localObject1).ztb.size();
      ((com.tencent.mm.plugin.sns.j.b)localObject1).zrJ = ((com.tencent.mm.plugin.sns.j.b)localObject1).ztc.size();
      ((com.tencent.mm.plugin.sns.j.b)localObject1).zrL = ((com.tencent.mm.plugin.sns.j.b)localObject1).ztg.size();
      ((com.tencent.mm.plugin.sns.j.b)localObject1).zrT = ((com.tencent.mm.plugin.sns.j.b)localObject1).zth.size();
      ((com.tencent.mm.plugin.sns.j.b)localObject1).nYt = ((com.tencent.mm.plugin.sns.j.b)localObject1).ztd.size();
      ((com.tencent.mm.plugin.sns.j.b)localObject1).zrE = ((com.tencent.mm.plugin.sns.j.b)localObject1).zte.size();
      ((com.tencent.mm.plugin.sns.j.b)localObject1).zrF = ((com.tencent.mm.plugin.sns.j.b)localObject1).ztf.size();
      ((com.tencent.mm.plugin.sns.j.b)localObject1).zrS = ((com.tencent.mm.plugin.sns.j.b)localObject1).zti.size();
      ((com.tencent.mm.plugin.sns.j.b)localObject1).zro = ((com.tencent.mm.plugin.sns.j.b)localObject1).zsX.size();
      localObject4 = ((bi)localObject2).yXV;
      localObject1 = ((bi)localObject2).lEN;
      if (!bt.isNullOrNil((String)localObject1))
      {
        paramBaseViewHolder.zOQ = ((bi)localObject2).Amz;
        paramBaseViewHolder.AuV.setTag(localObject1);
        if (paramBaseViewHolder.zOQ != null) {
          if ((am.aSQ((String)localObject1)) && ("3552365301".equals(paramBaseViewHolder.zOQ.field_openImAppid)))
          {
            i = 1;
            if ((localObject4 == null) || (!((com.tencent.mm.plugin.sns.storage.b)localObject4).zws)) {
              break label3125;
            }
            paramBaseViewHolder.AuV.setImageResource(2131231875);
            paramBaseViewHolder.AuV.fe((String)localObject1, 4);
            paramBaseViewHolder.AuV.setShowStoryHint(false);
            if (!bt.isNullOrNil(((com.tencent.mm.plugin.sns.storage.b)localObject4).zwu))
            {
              localObject5 = h.jF("adId", ((com.tencent.mm.plugin.sns.storage.b)localObject4).zwu);
              paramBaseViewHolder.AuV.setTag(2131305044, ((com.tencent.mm.plugin.sns.storage.b)localObject4).zwu);
              if (!com.tencent.mm.vfs.i.fv((String)localObject5)) {
                break label3104;
              }
              localObject4 = com.tencent.mm.plugin.sns.ad.d.l.yZH.getBitmap((String)localObject5);
              if (localObject4 != null) {
                paramBaseViewHolder.AuV.setImageBitmap((Bitmap)localObject4);
              }
            }
            label717:
            paramBaseViewHolder.AuW.a((String)localObject1, ((bi)localObject2).AmP, new p.a()
            {
              public final void b(View paramAnonymousView, Object paramAnonymousObject)
              {
                AppMethodBeat.i(100048);
                if (parambh.AaS != null)
                {
                  parambh.AaS.dnh = 0;
                  parambh.AaS.b(paramAnonymousView, paramAnonymousObject);
                }
                AppMethodBeat.o(100048);
              }
            }, ((bi)localObject2).zOM, ((bi)localObject2).zQD, paramInt2, ((bi)localObject2).zOM);
            paramBaseViewHolder.AuV.hgD = ((bi)localObject2).zQD;
          }
        }
      }
      break;
    }
    label801:
    label1319:
    label1846:
    label2621:
    label3780:
    label4804:
    for (;;)
    {
      paramBaseViewHolder.AuX.setVisibility(8);
      if (((bi)localObject2).zOM)
      {
        paramBaseViewHolder.isAd = true;
        paramBaseViewHolder.uaS = ((bi)localObject2).AmG;
        paramBaseViewHolder.AuZ.a(((bi)localObject2).AmC, parambh, ((bi)localObject2).AmD, (bi)localObject2);
        paramBaseViewHolder.AuZ.setShow(paramBaseViewHolder);
        paramBaseViewHolder.iCU.setOnTouchListener(new ae());
        a(paramBaseViewHolder, paramInt1, (bi)localObject2, paramTimeLineObject, paramInt2, parambh);
        a((bi)localObject2, paramTimeLineObject);
        parambh.AjG.put(Integer.valueOf(paramInt1), new WeakReference(paramBaseViewHolder.tPw));
        if (paramBaseViewHolder.tPw.getBackground() == null)
        {
          paramBaseViewHolder.tPw.setBackgroundResource(2131231818);
          paramInt1 = com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 12);
          int j = com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 8);
          paramBaseViewHolder.tPw.setPadding(paramInt1, paramInt1, paramInt1, j);
        }
        paramBaseViewHolder.timeTv.setText(((bi)localObject2).AmI);
        paramBaseViewHolder.Avl.setVisibility(8);
        paramBaseViewHolder.Avm.setVisibility(8);
        if (((bi)localObject2).zOM)
        {
          localObject4 = ((bi)localObject2).AmJ;
          paramBaseViewHolder.Avl.setTag(((bi)localObject2).zQD);
          if (((bi)localObject2).AmJ.zuJ != com.tencent.mm.plugin.sns.storage.a.zuv) {
            break label3430;
          }
          if (bt.isNullOrNil(((bi)localObject2).AmM)) {
            break label3418;
          }
          paramBaseViewHolder.Avl.setText(((bi)localObject2).AmM);
          paramBaseViewHolder.Avl.setVisibility(0);
          if ((paramBaseViewHolder.Avl.getVisibility() != 8) && (bt.isNullOrNil(((com.tencent.mm.plugin.sns.storage.a)localObject4).zuL)))
          {
            paramBaseViewHolder.Avl.setTextColor(this.mActivity.getResources().getColor(2131100943));
            paramBaseViewHolder.Avl.setOnClickListener(null);
          }
          if ((paramp.dYl().HAT.GaR & 0x4) == 0) {
            break label3739;
          }
          paramBaseViewHolder.Avm.setTag(paramBaseViewHolder);
          paramBaseViewHolder.Avm.setVisibility(0);
          paramBaseViewHolder.Avm.setText(String.format("%s%s%s", new Object[] { this.mActivity.getResources().getString(2131763743), ((bi)localObject2).AmP, this.mActivity.getResources().getString(2131763744) }));
        }
        if (!((bi)localObject2).AmS) {
          break label3751;
        }
        localObject1 = parambh.fLP.getString(2131760986, new Object[] { Integer.valueOf(((bi)localObject2).AmT) });
        BaseViewHolder.k(paramBaseViewHolder).setText((CharSequence)localObject1);
        BaseViewHolder.k(paramBaseViewHolder).setVisibility(0);
        label1236:
        paramBaseViewHolder.AhI.setTag(((bi)localObject2).zQD);
        if (bt.isNullOrNil(((bi)localObject2).AmV)) {
          break label3803;
        }
        paramBaseViewHolder.AhI.setVisibility(0);
        paramBaseViewHolder.AhI.setText(((bi)localObject2).AmV);
        paramBaseViewHolder.AhI.setClickable(((bi)localObject2).AmW);
        localObject1 = paramBaseViewHolder.AhI;
        if (!((bi)localObject2).AmW) {
          break label3763;
        }
        paramInt1 = this.mActivity.getResources().getColor(2131100914);
        ((TextView)localObject1).setTextColor(paramInt1);
        if (!((bi)localObject2).AmW) {
          break label3780;
        }
        paramBaseViewHolder.AhI.setBackground(this.mActivity.getResources().getDrawable(2131234100));
        label1353:
        if (!((bi)localObject2).And) {
          break label3815;
        }
        paramBaseViewHolder.Avk.setVisibility(0);
        paramBaseViewHolder.Avk.setImageResource(2131690597);
        paramBaseViewHolder.Avk.setIconColor(this.mActivity.getResources().getColor(2131099660));
        label1399:
        paramBaseViewHolder.iCU.setTextColor(this.mActivity.getResources().getColor(2131100914));
        if (!((bi)localObject2).AmX) {
          break label3832;
        }
        paramBaseViewHolder.iCU.setVisibility(0);
        localObject1 = this.mActivity.getString(2131763791) + ((bi)localObject2).mAppName;
        if ((paramTimeLineObject == null) || (paramTimeLineObject.HAT == null) || (paramTimeLineObject.HAT.GaP != 28)) {
          break label3827;
        }
        paramInt1 = 1;
        label1496:
        if ((((String)localObject1).length() <= 10) || (paramInt1 != 0)) {
          break label5500;
        }
        localObject1 = ((String)localObject1).substring(0, 10) + "...";
      }
      label1645:
      label1908:
      label2167:
      label3832:
      label5500:
      for (;;)
      {
        localObject1 = new SpannableString((CharSequence)localObject1);
        ((SpannableString)localObject1).setSpan(new b(), 0, ((SpannableString)localObject1).length(), 33);
        paramBaseViewHolder.iCU.setText((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
        if ((!((bi)localObject2).AmZ) && (!"wx7fa037cc7dfabad5".equals(paramTimeLineObject.HAS.Id)))
        {
          paramBaseViewHolder.iCU.setTextColor(this.mActivity.getResources().getColor(2131100943));
          paramBaseViewHolder.iCU.setOnTouchListener(null);
        }
        paramBaseViewHolder.iCU.setTag(paramTimeLineObject);
        if (((bi)localObject2).AmR)
        {
          paramBaseViewHolder.zRl.setVisibility(0);
          paramBaseViewHolder.zRl.setTag(((bi)localObject2).zQD);
          paramBaseViewHolder.Avo.setTag(paramBaseViewHolder);
          if (!((bi)localObject2).Ane) {
            break label4232;
          }
          if (!paramBaseViewHolder.AvE)
          {
            paramBaseViewHolder.Avt = ((LinearLayout)paramBaseViewHolder.AvA.inflate());
            paramBaseViewHolder.Avu = paramBaseViewHolder.tPw.findViewById(2131303358);
            paramBaseViewHolder.AvE = true;
            paramBaseViewHolder.Avu.setTag(((bi)localObject2).zQD);
            paramBaseViewHolder.zFE = ((TextView)paramBaseViewHolder.Avt.findViewById(2131303358));
          }
          paramBaseViewHolder.AvA.setVisibility(0);
          paramBaseViewHolder.Avu.setOnClickListener(parambh.zpd.Ayz);
          switch (((bi)localObject2).Anf)
          {
          default: 
            paramBaseViewHolder.zFE.setText(2131763946);
            paramBaseViewHolder.Avu.setClickable(true);
            paramBaseViewHolder.Avu.setEnabled(true);
            paramTimeLineObject = paramp.dYD();
            if ((paramTimeLineObject != null) && (!bt.isNullOrNil(paramTimeLineObject.GTv))) {
              paramBaseViewHolder.zFE.setText(paramTimeLineObject.GTv);
            }
            if (((bi)localObject2).Ang)
            {
              paramBaseViewHolder.Avn.setVisibility(0);
              paramBaseViewHolder.Avn.setTag(((bi)localObject2).zQD);
              if (!((bi)localObject2).Anh) {
                break label4354;
              }
              if (bt.isNullOrNil(((bi)localObject2).Ani)) {
                break label4293;
              }
              paramBaseViewHolder.Avj.setVisibility(0);
              if (paramInt2 != 7) {
                break label4263;
              }
              paramTimeLineObject = String.format(this.mActivity.getString(2131764038), new Object[] { ((bi)localObject2).Ani });
              paramTimeLineObject = com.tencent.mm.pluginsdk.ui.span.k.b(this.mActivity, paramTimeLineObject, paramBaseViewHolder.Avj.getTextSize());
              paramBaseViewHolder.Avj.setText(paramTimeLineObject);
              if (!((bi)localObject2).Ank) {
                break label4366;
              }
              if (paramBaseViewHolder.AvY == null)
              {
                paramBaseViewHolder.AvY = paramBaseViewHolder.AvX.inflate();
                paramBaseViewHolder.zfg = ((TextView)paramBaseViewHolder.AvY.findViewById(2131296573));
                paramBaseViewHolder.AvZ = ((MaskTextView)paramBaseViewHolder.AvY.findViewById(2131296574));
                paramBaseViewHolder.AvZ.setOnTouchListener(new ae());
              }
              paramBaseViewHolder.AvY.setVisibility(0);
              a(paramBaseViewHolder.AvZ, ((bi)localObject2).Ann, paramInt2);
              paramTimeLineObject = this.mActivity.getString(2131763903, new Object[] { Integer.valueOf(((bi)localObject2).Anl), bt.C(((bi)localObject2).Anm / 100.0D) });
              paramBaseViewHolder.zfg.setText(paramTimeLineObject);
              paramBaseViewHolder.AvY.setTag(paramp);
              paramBaseViewHolder.AvY.setOnClickListener(parambh.zpd.AyC);
              if (((((bi)localObject2).Ano != null) && (((bi)localObject2).Ano.size() != 0)) || ((((bi)localObject2).Anp != null) && (((bi)localObject2).Anp.size() != 0))) {
                break label4404;
              }
              if (paramBaseViewHolder.zOk == null) {
                break label4385;
              }
              paramBaseViewHolder.zOk.setVisibility(8);
              if (!((bi)localObject2).Anq) {
                break label4828;
              }
              paramBaseViewHolder.Ave.setTag(((bi)localObject2).zQD);
              paramBaseViewHolder.Ave.setText(((bi)localObject2).Ans);
              paramBaseViewHolder.Ave.setVisibility(0);
              if (!((bi)localObject2).zOM) {
                break label4845;
              }
              ad.i("MicroMsg.BaseTimeLineItem", "adatag " + ((bi)localObject2).AmL);
              paramBaseViewHolder.zcq.H(Long.valueOf(((bi)localObject2).AmB), new com.tencent.mm.plugin.sns.data.b(paramBaseViewHolder.zcq, paramBaseViewHolder.position, ((bi)localObject2).zQD, ((bi)localObject2).AmB, ((bi)localObject2).AmH));
              paramBaseViewHolder.zcq.a(((bi)localObject2).AmK, ((bi)localObject2).AmJ);
              paramBaseViewHolder.zcq.setVisibility(0);
              if ((paramBaseViewHolder.AhI != null) && (paramBaseViewHolder.AhI.getVisibility() == 0))
              {
                if (paramBaseViewHolder.zcq.ApO.getVisibility() != 0) {
                  break label4840;
                }
                paramInt1 = 1;
                if (paramInt1 != 0)
                {
                  paramTimeLineObject = (LinearLayout.LayoutParams)paramBaseViewHolder.AhI.getLayoutParams();
                  paramTimeLineObject.setMargins(paramTimeLineObject.leftMargin, BackwardSupportUtil.b.g(this.mActivity, 0.0F), paramTimeLineObject.rightMargin, paramTimeLineObject.bottomMargin);
                  paramBaseViewHolder.AhI.setLayoutParams(paramTimeLineObject);
                }
              }
              paramBaseViewHolder.Avi.setVisibility(8);
              if (this.Aae) {
                ag.dTV().a(this.mActivity, (SnsObject)localObject3, paramBaseViewHolder);
              }
              paramTimeLineObject = ag.dUn();
              long l = paramp.field_snsId;
              if ((!paramTimeLineObject.zlU) || (l == 0L) || (paramTimeLineObject.zmn) || (paramTimeLineObject.zme <= paramTimeLineObject.zlY) || (paramTimeLineObject.zmr == null) || (paramTimeLineObject.zmr.state != 1) || (paramTimeLineObject.zmr.zqL < paramTimeLineObject.zlZ) || (!paramTimeLineObject.zmj)) {
                break label4918;
              }
              if ((paramTimeLineObject.zmc != 0L) && (cf.aCN() - paramTimeLineObject.zmq.zmu <= paramTimeLineObject.zmc)) {
                break label4913;
              }
              paramInt1 = 1;
              if ((paramInt1 == 0) || (l != paramTimeLineObject.zms)) {
                break label4918;
              }
              paramInt1 = 1;
              if (paramInt1 == 0) {
                break label4923;
              }
              if (!paramBaseViewHolder.Awe)
              {
                paramBaseViewHolder.Awg = ((LinearLayout)paramBaseViewHolder.Awf.inflate());
                paramBaseViewHolder.Awe = true;
                paramBaseViewHolder.Awh = ((ViewGroup)paramBaseViewHolder.Awg.findViewById(2131305092));
              }
              paramBaseViewHolder.Awf.setVisibility(0);
              paramBaseViewHolder.iLQ.setBackgroundColor(0);
              paramBaseViewHolder.Awh.setTag(Long.valueOf(paramp.field_snsId));
              ag.dUn().eV(paramBaseViewHolder.Awh);
              paramBaseViewHolder.Awh.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(179352);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bd(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/item/BaseTimeLineItem$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
                  BaseTimeLineItem.this.zpI.AjE.dZB();
                  com.tencent.mm.plugin.sns.j.e.ztz.zuf.eoK = 1L;
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/item/BaseTimeLineItem$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(179352);
                }
              });
              com.tencent.mm.plugin.report.service.g.yhR.dD(1295, 1);
              ag.dUo();
              if (!com.tencent.mm.plugin.sns.model.aq.p(paramp.field_snsId, paramp.field_createTime, paramp.zMC)) {
                break label4966;
              }
              if (!paramBaseViewHolder.Awi)
              {
                paramBaseViewHolder.Awk = ((LinearLayout)paramBaseViewHolder.Awj.inflate());
                paramBaseViewHolder.Awi = true;
                paramBaseViewHolder.Awl = ((TextView)paramBaseViewHolder.Awk.findViewById(2131308003));
              }
              paramBaseViewHolder.Awj.setVisibility(0);
              paramBaseViewHolder.iLQ.setBackgroundColor(0);
              paramBaseViewHolder.Awl.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(198539);
                  Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
                  ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/item/BaseTimeLineItem$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
                  paramAnonymousView = ag.dUo();
                  localObject1 = paramBaseViewHolder.Awl.getContext();
                  Object localObject2;
                  Parcel localParcel;
                  if (com.tencent.mm.plugin.sns.model.aq.zlB)
                  {
                    paramAnonymousView.zlF = null;
                    paramAnonymousView.zlG = "";
                    ad.i(com.tencent.mm.plugin.sns.model.aq.TAG, "goRetryEdit draftKey:%s", new Object[] { paramAnonymousView.zlE });
                    localObject2 = ag.dUl().aAb(paramAnonymousView.zlE);
                    if (localObject2 != null)
                    {
                      localObject2 = ((com.tencent.mm.plugin.sns.storage.l)localObject2).field_draft;
                      if (!bt.cC((byte[])localObject2))
                      {
                        localParcel = Parcel.obtain();
                        localParcel.unmarshall((byte[])localObject2, 0, localObject2.length);
                        localParcel.setDataPosition(0);
                      }
                    }
                  }
                  try
                  {
                    localObject2 = (Intent)Intent.CREATOR.createFromParcel(localParcel);
                    ((Intent)localObject2).putExtra("Kis_retry_edit", true);
                    localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
                    com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahp(), "com/tencent/mm/plugin/sns/model/SnsRetryEditTipManager", "goRetryEdit", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mq(0));
                    com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/sns/model/SnsRetryEditTipManager", "goRetryEdit", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    paramAnonymousView.reset();
                    com.tencent.mm.sdk.platformtools.aq.aA(paramAnonymousView.zlH);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/item/BaseTimeLineItem$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(198539);
                    return;
                  }
                  catch (Exception localException)
                  {
                    for (;;)
                    {
                      ag.dUl().b(paramAnonymousView.zlE, null, 0);
                    }
                  }
                }
              });
            }
            break;
          }
        }
        Object localObject6;
        boolean bool;
        for (;;)
        {
          paramp = new bd(((bi)localObject2).AmA, ((bi)localObject2).zQD, false, true, 1);
          paramBaseViewHolder.Ava.getResultTextView().setTag(paramp);
          paramp = new StringBuilder("");
          if ((((bi)localObject2).Ano == null) || (((bi)localObject2).Ano.size() <= 0)) {
            break label4995;
          }
          paramp.append(aj.getContext().getResources().getString(2131767182)).append(":");
          paramInt1 = 0;
          while (paramInt1 < ((bi)localObject2).Ano.size())
          {
            paramTimeLineObject = (com.tencent.mm.vending.j.a)((bi)localObject2).Ano.get(paramInt1);
            if (paramTimeLineObject != null) {
              paramp.append((String)paramTimeLineObject.get(1)).append(",");
            }
            paramInt1 += 1;
          }
          ((com.tencent.mm.plugin.sns.j.b)localObject1).zsZ.add(localObject4);
          break;
          ((com.tencent.mm.plugin.sns.j.b)localObject1).zsY.add(localObject4);
          break;
          ((com.tencent.mm.plugin.sns.j.b)localObject1).ztb.add(localObject4);
          break;
          ((com.tencent.mm.plugin.sns.j.b)localObject1).zta.add(localObject4);
          break;
          ((com.tencent.mm.plugin.sns.j.b)localObject1).ztg.add(localObject4);
          break;
          ((com.tencent.mm.plugin.sns.j.b)localObject1).zth.add(localObject4);
          break;
          if (!bt.isNullOrNil(paramTimeLineObject.HAU))
          {
            ((com.tencent.mm.plugin.sns.j.b)localObject1).zte.add(localObject4);
            break;
          }
          ((com.tencent.mm.plugin.sns.j.b)localObject1).ztf.add(localObject4);
          break;
          i = 0;
          break label605;
          h.a(((com.tencent.mm.plugin.sns.storage.b)localObject4).zwu, false, new f.a()
          {
            public final void axG(String paramAnonymousString)
            {
              AppMethodBeat.i(100047);
              ad.i("MicroMsg.BaseTimeLineItem", "download img %s", new Object[] { paramAnonymousString });
              String str = (String)paramBaseViewHolder.AuV.getTag(2131305044);
              if ((!bt.V(new String[] { str, paramAnonymousString })) && (paramAnonymousString.equals(h.jF("adId", str))))
              {
                paramAnonymousString = com.tencent.mm.plugin.sns.ad.d.l.yZH.getBitmap(paramAnonymousString);
                if (paramAnonymousString != null) {
                  paramBaseViewHolder.AuV.setImageBitmap(paramAnonymousString);
                }
              }
              AppMethodBeat.o(100047);
            }
            
            public final void dRW() {}
            
            public final void dRX() {}
          });
          break label717;
          if (!((String)localObject1).endsWith("@ad")) {
            if (((bi)localObject2).AmQ)
            {
              ad.i("MicroMsg.BaseTimeLineItem", "getContact %s", new Object[] { localObject1 });
              if (a.b.fbx().LL() != null) {
                paramBaseViewHolder.AuV.setImageBitmap(a.b.fbx().LL());
              }
              as.a.hFO.a((String)localObject1, "", new bh.c(parambh.ecL(), paramInt1));
              if (((bi)localObject2).AmR) {
                break label3358;
              }
              com.tencent.mm.plugin.sns.ui.e.a.b(4, (String)paramBaseViewHolder.AuV.getTag(), paramBaseViewHolder.AuV);
              paramBaseViewHolder.AuV.fe((String)localObject1, 4);
              paramBaseViewHolder.AuV.setTag(localObject1);
              com.tencent.mm.plugin.sns.ui.e.a.a(4, (String)localObject1, paramBaseViewHolder.AuV);
              paramBaseViewHolder.AuV.setShowStoryHint(((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).hasNewStory((String)localObject1));
            }
          }
          for (;;)
          {
            paramBaseViewHolder.AuW.setContactInfo(paramBaseViewHolder.zOQ);
            paramBaseViewHolder.AuW.a((String)localObject1, ((bi)localObject2).AmP, new p.a()
            {
              public final void b(View paramAnonymousView, Object paramAnonymousObject)
              {
                AppMethodBeat.i(100049);
                if (parambh.AaS != null) {
                  if (!(paramAnonymousObject instanceof com.tencent.mm.plugin.sns.data.a)) {
                    break label78;
                  }
                }
                label78:
                for (boolean bool = ((com.tencent.mm.plugin.sns.data.a)paramAnonymousObject).isAd;; bool = false)
                {
                  if (bool) {}
                  for (parambh.AaS.dnh = 0;; parambh.AaS.dnh = 6)
                  {
                    parambh.AaS.b(paramAnonymousView, paramAnonymousObject);
                    AppMethodBeat.o(100049);
                    return;
                  }
                }
              }
            }, ((bi)localObject2).zOM, ((bi)localObject2).zQD, paramInt2, ((bi)localObject2).zOM);
            break;
            a.b.c(paramBaseViewHolder.AuV, (String)localObject1);
            break label3213;
            paramBaseViewHolder.AuV.fe((String)localObject1, 4);
            paramBaseViewHolder.AuV.setShowStoryHint(false);
            continue;
            paramBaseViewHolder.AuV.setImageResource(2131231875);
            paramBaseViewHolder.AuV.fe((String)localObject1, 4);
            paramBaseViewHolder.AuV.setShowStoryHint(false);
          }
          paramBaseViewHolder.isAd = false;
          break label801;
          paramBaseViewHolder.Avl.setVisibility(8);
          break label1044;
          if (((com.tencent.mm.plugin.sns.storage.a)localObject4).zuJ != com.tencent.mm.plugin.sns.storage.a.zuw) {
            break label1044;
          }
          if (!bt.isNullOrNil(((bi)localObject2).AmN))
          {
            localObject1 = ((bi)localObject2).AmO;
            localObject5 = ((bi)localObject2).AmN;
            localObject6 = this.mActivity;
            paramBaseViewHolder.Avl.getTextSize();
            localObject6 = new com.tencent.mm.pluginsdk.ui.span.l(com.tencent.mm.pluginsdk.ui.span.k.c((Context)localObject6, (CharSequence)localObject5, 1));
            ((com.tencent.mm.pluginsdk.ui.span.l)localObject6).a(null, (CharSequence)localObject5);
            localObject5 = paramBaseViewHolder.Avl.getPaint();
            float f = Layout.getDesiredWidth((CharSequence)localObject6, 0, ((com.tencent.mm.pluginsdk.ui.span.l)localObject6).length(), (TextPaint)localObject5);
            if (com.tencent.mm.cc.a.aA(this.mActivity, (int)f) > paramBaseViewHolder.Abb)
            {
              do
              {
                if (((String)localObject1).length() <= 1) {
                  break;
                }
                localObject1 = ((String)localObject1).substring(0, ((String)localObject1).length() - 2);
                localObject6 = String.format(((com.tencent.mm.plugin.sns.storage.a)localObject4).zuK, new Object[] { (String)localObject1 + "..." });
                localObject7 = this.mActivity;
                paramBaseViewHolder.Avl.getTextSize();
                localObject7 = new com.tencent.mm.pluginsdk.ui.span.l(com.tencent.mm.pluginsdk.ui.span.k.c((Context)localObject7, (CharSequence)localObject6, 1));
                ((com.tencent.mm.pluginsdk.ui.span.l)localObject7).a(null, (CharSequence)localObject6);
                f = Layout.getDesiredWidth((CharSequence)localObject7, 0, ((com.tencent.mm.pluginsdk.ui.span.l)localObject7).length(), (TextPaint)localObject5);
                paramInt1 = com.tencent.mm.cc.a.aA(this.mActivity, (int)f);
                paramBaseViewHolder.Avl.setText((CharSequence)localObject7, TextView.BufferType.SPANNABLE);
                paramBaseViewHolder.Avl.setVisibility(0);
              } while (paramInt1 > paramBaseViewHolder.Abb);
              break label1044;
            }
            paramBaseViewHolder.Avl.setText((CharSequence)localObject6, TextView.BufferType.SPANNABLE);
            paramBaseViewHolder.Avl.setVisibility(0);
            break label1044;
          }
          paramBaseViewHolder.Avl.setVisibility(8);
          break label1044;
          paramBaseViewHolder.Avm.setVisibility(8);
          break label1183;
          BaseViewHolder.k(paramBaseViewHolder).setVisibility(8);
          break label1236;
          paramInt1 = this.mActivity.getResources().getColor(2131100212);
          break label1319;
          paramBaseViewHolder.AhI.setBackground(this.mActivity.getResources().getDrawable(2131233299));
          break label1353;
          paramBaseViewHolder.AhI.setVisibility(8);
          break label1353;
          paramBaseViewHolder.Avk.setVisibility(8);
          break label1399;
          paramInt1 = 0;
          break label1496;
          if (((bi)localObject2).AmY)
          {
            paramBaseViewHolder.iCU.setVisibility(0);
            paramTimeLineObject = new SpannableString(((bi)localObject2).Anb);
            paramTimeLineObject.setSpan(new c(), 0, paramTimeLineObject.length(), 33);
            paramBaseViewHolder.iCU.setText(paramTimeLineObject, TextView.BufferType.SPANNABLE);
            paramBaseViewHolder.iCU.setTag(new bl(((bi)localObject2).Ana, ((bi)localObject2).Anb));
            break label1645;
          }
          if (((bi)localObject2).Anc)
          {
            paramBaseViewHolder.iCU.setVisibility(0);
            localObject1 = this.mActivity.getString(2131755318);
            localObject4 = (String)localObject1 + ((bi)localObject2).mAppName;
            localObject5 = new SpannableString((CharSequence)localObject4);
            ((SpannableString)localObject5).setSpan(new ForegroundColorSpan(this.mActivity.getResources().getColor(2131100943)), 0, ((String)localObject1).length(), 33);
            ((SpannableString)localObject5).setSpan(new a(), ((String)localObject1).length(), ((String)localObject4).length(), 33);
            paramBaseViewHolder.iCU.setText((CharSequence)localObject5, TextView.BufferType.SPANNABLE);
            if ((!((bi)localObject2).AmZ) && (!"wx7fa037cc7dfabad5".equals(paramTimeLineObject.HAS.Id)))
            {
              paramBaseViewHolder.iCU.setTextColor(this.mActivity.getResources().getColor(2131100943));
              paramBaseViewHolder.iCU.setOnTouchListener(null);
            }
            paramBaseViewHolder.iCU.setTag(paramTimeLineObject);
            break label1645;
          }
          paramBaseViewHolder.iCU.setVisibility(8);
          break label1645;
          paramBaseViewHolder.zRl.setVisibility(8);
          break label1673;
          paramBaseViewHolder.zFE.setText(2131763943);
          paramBaseViewHolder.Avu.setClickable(false);
          paramBaseViewHolder.Avu.setEnabled(false);
          break label1846;
          paramBaseViewHolder.zFE.setText(2131763945);
          paramBaseViewHolder.Avu.setClickable(false);
          paramBaseViewHolder.Avu.setEnabled(false);
          break label1846;
          paramBaseViewHolder.zFE.setText(2131763944);
          paramBaseViewHolder.Avu.setClickable(true);
          paramBaseViewHolder.Avu.setEnabled(true);
          break label1846;
          if (!paramBaseViewHolder.AvE) {
            break label1880;
          }
          paramBaseViewHolder.AvA.setVisibility(8);
          break label1880;
          paramBaseViewHolder.Avn.setVisibility(8);
          break label1908;
          paramTimeLineObject = String.format(this.mActivity.getString(2131764039), new Object[] { ((bi)localObject2).Ani });
          break label1969;
          if (((bi)localObject2).Anj)
          {
            paramBaseViewHolder.Avj.setVisibility(0);
            paramTimeLineObject = this.mActivity.getString(2131764040);
            paramTimeLineObject = com.tencent.mm.pluginsdk.ui.span.k.b(this.mActivity, paramTimeLineObject.toString(), paramBaseViewHolder.Avj.getTextSize());
            paramBaseViewHolder.Avj.setText(paramTimeLineObject);
            break label1996;
          }
          paramBaseViewHolder.Avj.setVisibility(8);
          break label1996;
          if (paramBaseViewHolder.AvY == null) {
            break label2167;
          }
          paramBaseViewHolder.AvY.setVisibility(8);
          break label2167;
          if (!paramBaseViewHolder.Avz) {
            break label2221;
          }
          paramBaseViewHolder.Avy.setVisibility(8);
          break label2221;
          if (!paramBaseViewHolder.Avz)
          {
            if ((paramBaseViewHolder.zOk != null) || (paramBaseViewHolder.Avy.getParent() == null)) {
              break label4748;
            }
            paramBaseViewHolder.zOk = ((LinearLayout)paramBaseViewHolder.Avy.inflate());
            if (paramBaseViewHolder.zOk != null)
            {
              paramBaseViewHolder.Avq = ((SnsLikesTextView)paramBaseViewHolder.zOk.findViewById(2131296588));
              paramBaseViewHolder.Avq.setLikedTextTouchListener(new ae());
              paramBaseViewHolder.Avq.setOpClickListener(parambh.AjV);
              paramBaseViewHolder.Avs = ((LinearLayout)paramBaseViewHolder.tPw.findViewById(2131296557));
              paramBaseViewHolder.zOk.setTag(((bi)localObject2).AmA);
              paramBaseViewHolder.Avq.setLikeTvTag(((bi)localObject2).AmA);
              paramBaseViewHolder.Avq.setOpTvTag(paramBaseViewHolder);
              paramBaseViewHolder.Avx = paramBaseViewHolder.zOk.findViewById(2131296592);
              paramBaseViewHolder.Awa = paramBaseViewHolder.zOk.findViewById(2131296590);
              paramBaseViewHolder.Avz = true;
            }
          }
          if (paramBaseViewHolder.zOk != null) {
            paramBaseViewHolder.zOk.setVisibility(0);
          }
          if ((((bi)localObject2).Ano != null) && (((bi)localObject2).Ano.size() > 0))
          {
            paramBaseViewHolder.Avq.setVisibility(0);
            parambh.a(((bi)localObject2).zQD, paramBaseViewHolder.Avq);
            paramBaseViewHolder.Avq.a(((bi)localObject2).Ano, paramInt2, parambh, ((bi)localObject2).zQD, parambh.Afj, parambh.Afk, parambh.AjI, (bi)localObject2, paramBaseViewHolder);
            paramBaseViewHolder.Avr = true;
            if (((bi)localObject2).Anp == null) {
              break label4804;
            }
            a(((SnsObject)localObject3).CommentUserList, ((bi)localObject2).Anp, paramBaseViewHolder);
          }
          for (;;)
          {
            if ((((bi)localObject2).Ano == null) || (((bi)localObject2).Ano.size() == 0) || (((bi)localObject2).Anp == null) || (((bi)localObject2).Anp.size() == 0)) {
              break label4816;
            }
            paramBaseViewHolder.Avx.setVisibility(0);
            break;
            if (paramBaseViewHolder.zOk == null) {}
            for (bool = true;; bool = false)
            {
              ad.e("MicroMsg.BaseTimeLineItem", "holder.listKeeper = null %s,and holder.commentStub.inflated", new Object[] { Boolean.valueOf(bool) });
              break;
            }
            paramBaseViewHolder.Avq.setVisibility(8);
            paramBaseViewHolder.Avr = false;
            break label4675;
            paramBaseViewHolder.Avs.setVisibility(8);
          }
          paramBaseViewHolder.Avx.setVisibility(8);
          break label2221;
          paramBaseViewHolder.Ave.setVisibility(8);
          break label2261;
          paramInt1 = 0;
          break label2397;
          if (i != 0)
          {
            paramBaseViewHolder.zcq.setVisibility(8);
            paramBaseViewHolder.Avi.setTag(new com.tencent.mm.plugin.sns.data.e(paramBaseViewHolder.Avi, paramp.dYK()));
            paramBaseViewHolder.Avi.setVisibility(0);
            break label2459;
          }
          paramBaseViewHolder.zcq.setVisibility(8);
          paramBaseViewHolder.Avi.setVisibility(8);
          break label2459;
          paramInt1 = 0;
          break label2604;
          paramInt1 = 0;
          break label2621;
          if (paramBaseViewHolder.Awe)
          {
            paramBaseViewHolder.Awf.setVisibility(8);
            paramBaseViewHolder.Awh.setTag(Long.valueOf(paramp.field_snsId));
          }
          paramBaseViewHolder.iLQ.setBackgroundResource(2131232867);
          break label2733;
          if (paramBaseViewHolder.Awi) {
            paramBaseViewHolder.Awj.setVisibility(8);
          }
          paramBaseViewHolder.iLQ.setBackgroundResource(2131232867);
        }
        paramTimeLineObject = new StringBuilder("");
        if ((((bi)localObject2).Anp != null) && (((bi)localObject2).Anp.size() > 0))
        {
          paramTimeLineObject.append(aj.getContext().getResources().getString(2131767181)).append(":");
          paramInt1 = 0;
          while (paramInt1 < ((bi)localObject2).Anp.size())
          {
            parambh = (com.tencent.mm.vending.j.a)((bi)localObject2).Anp.get(paramInt1);
            if (parambh != null) {
              paramTimeLineObject.append((CharSequence)parambh.get(6)).append(",");
            }
            paramInt1 += 1;
          }
        }
        paramInt1 = 0;
        if (paramInt2 == 2) {}
        for (paramInt1 = 1;; paramInt1 = 2) {
          do
          {
            parambh = a.a.fyf();
            localObject1 = paramBaseViewHolder.tPw;
            localObject2 = paramBaseViewHolder.AuW;
            localObject3 = paramBaseViewHolder.timeTv;
            localObject4 = paramBaseViewHolder.AhI;
            localObject5 = paramBaseViewHolder.AuZ.getContent();
            localObject6 = paramBaseViewHolder.Avg;
            bool = paramBaseViewHolder.AvU;
            paramBaseViewHolder = paramBaseViewHolder.iCU;
            paramp = paramp.toString();
            paramTimeLineObject = paramTimeLineObject.toString();
            if ((parambh.fye()) && (parambh.IR != null) && (localObject1 != null) && (localObject2 != null) && (localObject3 != null) && (localObject4 != null) && (paramBaseViewHolder != null)) {
              break;
            }
            return;
          } while ((paramInt2 != 3) && (paramInt2 != 4) && (paramInt2 != 5));
        }
        Object localObject7 = new com.tencent.mm.ui.a.b();
        ((com.tencent.mm.ui.a.b)localObject7).aVv(((TextView)localObject2).getText().toString());
        ((com.tencent.mm.ui.a.b)localObject7).aVv((String)localObject5);
        if ((localObject6 != null) && (((TextView)localObject6).getText() != null)) {
          ((com.tencent.mm.ui.a.b)localObject7).aVv(((TextView)localObject6).getText().toString());
        }
        if (bool) {
          ((com.tencent.mm.ui.a.b)localObject7).aVv(parambh.IR.getString(2131757941));
        }
        if (paramInt1 == 1) {
          ((com.tencent.mm.ui.a.b)localObject7).aVv(parambh.IR.getString(2131766923));
        }
        for (;;)
        {
          if ((localObject4 != null) && (((TextView)localObject4).getText() != null)) {
            ((com.tencent.mm.ui.a.b)localObject7).aVv(((TextView)localObject4).getText().toString());
          }
          if ((localObject3 != null) && (((TextView)localObject3).getText() != null)) {
            ((com.tencent.mm.ui.a.b)localObject7).aVv(((TextView)localObject3).getText().toString());
          }
          if ((paramBaseViewHolder != null) && (paramBaseViewHolder.getText() != null)) {
            ((com.tencent.mm.ui.a.b)localObject7).aVv(paramBaseViewHolder.getText().toString());
          }
          if (paramp != null) {
            ((com.tencent.mm.ui.a.b)localObject7).aVv(paramp);
          }
          if (paramTimeLineObject != null) {
            ((com.tencent.mm.ui.a.b)localObject7).aVv(paramTimeLineObject);
          }
          ((com.tencent.mm.ui.a.b)localObject7).gd((View)localObject1);
          return;
          if (paramInt1 > 1) {
            ((com.tencent.mm.ui.a.b)localObject7).aVv(parambh.IR.getString(2131766924));
          }
        }
      }
      label1880:
      label2397:
      label3430:
      label3815:
      label3827:
      i = 0;
      label1996:
      label2261:
      label3418:
      label3803:
      label4828:
      label4840:
      label4845:
      break label605;
      label4293:
      label4816:
      label4966:
      i = 0;
    }
  }
  
  public abstract void a(BaseViewHolder paramBaseViewHolder, int paramInt1, bi parambi, TimeLineObject paramTimeLineObject, int paramInt2, bh parambh);
  
  public abstract void h(BaseViewHolder paramBaseViewHolder);
  
  public final void setIsFromMainTimeline(boolean paramBoolean)
  {
    this.Aae = paramBoolean;
  }
  
  public static class BaseViewHolder
  {
    public int Abb;
    public TextView AhI;
    public View AhO;
    public com.tencent.mm.plugin.sns.ui.aq Atv;
    public long AuT;
    public int AuU;
    public SnsAvatarImageView AuV;
    public AsyncTextView AuW;
    public ImageView AuX;
    public ViewGroup AuY;
    public AsyncNormalTextView AuZ;
    public ViewStub AvA;
    public ViewStub AvB;
    public View AvC;
    public boolean AvD;
    public boolean AvE;
    public ViewStub AvF;
    public boolean AvG;
    public View AvH;
    public LinearLayout AvI;
    public TextView AvJ;
    public ViewStub AvK;
    public boolean AvL;
    public View AvM;
    public LinearLayout AvN;
    public ViewStub AvO;
    public boolean AvP;
    public View AvQ;
    public ImageView AvR;
    public boolean AvS;
    ViewStub AvT;
    boolean AvU;
    public View AvV;
    public BaseTimeLineItem AvW;
    public ViewStub AvX;
    public View AvY;
    public MaskTextView AvZ;
    public SnsTranslateResultView Ava;
    public LinearLayout Avb;
    public ViewStub Avc;
    public boolean Avd;
    public TextView Ave;
    public TagImageView Avf;
    public TextView Avg;
    public int Avh;
    public RelativeLayout Avi;
    public TextView Avj;
    public WeImageView Avk;
    public AsyncTextView Avl;
    public AsyncTextView Avm;
    public View Avn;
    public ImageView Avo;
    public View Avp;
    public SnsLikesTextView Avq;
    public boolean Avr;
    public LinearLayout Avs;
    public LinearLayout Avt;
    public View Avu;
    public LinearLayout Avv;
    public PhotosContent Avw;
    public View Avx;
    public ViewStub Avy;
    public boolean Avz;
    public View Awa;
    private TextView Awb;
    public String Awc;
    public View Awd;
    public boolean Awe;
    public ViewStub Awf;
    public LinearLayout Awg;
    public ViewGroup Awh;
    public boolean Awi;
    public ViewStub Awj;
    public LinearLayout Awk;
    public TextView Awl;
    public String doX;
    public String dzb;
    public volatile boolean grY;
    public TextView iCU;
    public ViewGroup iLQ;
    public boolean isAd;
    public int oIb;
    public int position;
    public SnsObject snsobj;
    public View tPw;
    public TimeLineObject timeLineObject;
    public TextView timeTv;
    public TextView titleTv;
    public boolean uaS;
    public TextView zFE;
    public byo zMQ;
    public com.tencent.mm.o.b zOQ;
    public ImageView zOS;
    public LinearLayout zOk;
    public TextView zRl;
    public bn zcq;
    public TextView zfg;
    
    public BaseViewHolder()
    {
      AppMethodBeat.i(100055);
      this.Avd = false;
      this.Avh = 0;
      this.Abb = 210;
      this.Avr = false;
      this.Avz = false;
      this.AvC = null;
      this.AvD = false;
      this.AvE = false;
      this.AvG = false;
      this.AvL = false;
      this.AvP = false;
      this.AvS = false;
      this.AvU = false;
      this.Atv = new com.tencent.mm.plugin.sns.ui.aq();
      this.Awe = false;
      this.Awi = false;
      AppMethodBeat.o(100055);
    }
  }
  
  final class a
    extends com.tencent.mm.pluginsdk.ui.span.p
  {
    a() {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(100051);
      BaseTimeLineItem.this.zpI.AaW.Aql.onClick(paramView);
      AppMethodBeat.o(100051);
    }
    
    public final void updateDrawState(TextPaint paramTextPaint)
    {
      AppMethodBeat.i(100052);
      int i = BaseTimeLineItem.this.mActivity.getResources().getColor(2131100913);
      if (getPress())
      {
        paramTextPaint.bgColor = i;
        AppMethodBeat.o(100052);
        return;
      }
      paramTextPaint.bgColor = 0;
      AppMethodBeat.o(100052);
    }
  }
  
  final class b
    extends com.tencent.mm.pluginsdk.ui.span.p
  {
    b() {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(100053);
      BaseTimeLineItem.this.zpI.AaW.Aqa.onClick(paramView);
      AppMethodBeat.o(100053);
    }
    
    public final void updateDrawState(TextPaint paramTextPaint)
    {
      AppMethodBeat.i(100054);
      int i = BaseTimeLineItem.this.mActivity.getResources().getColor(2131100913);
      if (getPress())
      {
        paramTextPaint.bgColor = i;
        AppMethodBeat.o(100054);
        return;
      }
      paramTextPaint.bgColor = 0;
      AppMethodBeat.o(100054);
    }
  }
  
  final class c
    extends com.tencent.mm.pluginsdk.ui.span.p
  {
    c() {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(100056);
      BaseTimeLineItem.this.zpI.AaW.Aqb.onClick(paramView);
      AppMethodBeat.o(100056);
    }
    
    public final void updateDrawState(TextPaint paramTextPaint)
    {
      AppMethodBeat.i(100057);
      int i = BaseTimeLineItem.this.mActivity.getResources().getColor(2131100913);
      if (getPress())
      {
        paramTextPaint.bgColor = i;
        AppMethodBeat.o(100057);
        return;
      }
      paramTextPaint.bgColor = 0;
      AppMethodBeat.o(100057);
    }
  }
  
  static final class d
    implements f.d
  {
    public int Acs;
    public com.tencent.mm.plugin.sns.ui.l AjN;
    public CharSequence Awm;
    public int Awn;
    public int deleteFlag;
    public CharSequence gEX;
    public String md5;
    private WeakReference<View> view;
    
    public d(String paramString, CharSequence paramCharSequence1, CharSequence paramCharSequence2, View paramView, int paramInt1, int paramInt2, com.tencent.mm.plugin.sns.ui.l paraml)
    {
      AppMethodBeat.i(198540);
      this.view = null;
      this.md5 = null;
      this.Awm = null;
      this.gEX = null;
      this.Acs = 0;
      this.deleteFlag = 0;
      this.Awn = com.tencent.mm.ui.aq.fromDPToPix(aj.getContext(), 28);
      this.AjN = null;
      this.view = new WeakReference(paramView);
      this.md5 = paramString;
      this.Awm = paramCharSequence1;
      this.gEX = paramCharSequence2;
      this.Acs = paramInt1;
      this.deleteFlag = paramInt2;
      this.AjN = paraml;
      AppMethodBeat.o(198540);
    }
    
    public final void f(Bitmap paramBitmap, String paramString)
    {
      AppMethodBeat.i(100059);
      ad.i("MicroMsg.BaseTimeLineItem", "onEmojiDecodeFin bitmapAvailable:%s, md5:%s", new Object[] { Boolean.valueOf(q.I(paramBitmap)), paramString });
      if ((this.view != null) && (this.view.get() != null) && ((this.view.get() instanceof SnsCommentCollapseLayout)))
      {
        SnsCommentCollapseLayout localSnsCommentCollapseLayout = (SnsCommentCollapseLayout)this.view.get();
        if ((localSnsCommentCollapseLayout != null) && (localSnsCommentCollapseLayout.getTag() != null) && ((localSnsCommentCollapseLayout.getTag() instanceof com.tencent.mm.plugin.sns.ui.m)))
        {
          Object localObject = (com.tencent.mm.plugin.sns.ui.m)localSnsCommentCollapseLayout.getTag();
          if ((((com.tencent.mm.plugin.sns.ui.m)localObject).zhw != null) && (!bt.hj(((com.tencent.mm.plugin.sns.ui.m)localObject).zhw.HtM)) && (((com.tencent.mm.plugin.sns.ui.m)localObject).zhw.HtM.get(0) != null) && (bt.lQ(paramString, ((dft)((com.tencent.mm.plugin.sns.ui.m)localObject).zhw.HtM.get(0)).Md5)) && (q.I(paramBitmap)))
          {
            paramBitmap = new BitmapDrawable(paramBitmap);
            paramBitmap.setBounds(0, 0, this.Awn, this.Awn);
            paramBitmap = new com.tencent.mm.ui.widget.a(paramBitmap);
            aj.getContext();
            paramString = new com.tencent.mm.pluginsdk.ui.span.p(this.md5, this.AjN, 2);
            localObject = new SpannableStringBuilder(this.Awm);
            ((SpannableStringBuilder)localObject).append("  ").append(this.md5).append("  ").append(" ");
            int i = ((SpannableStringBuilder)localObject).length() - this.md5.length() - 2 - 1;
            int j = ((SpannableStringBuilder)localObject).length() - this.md5.length() - 4 - 1;
            ((SpannableStringBuilder)localObject).setSpan(paramBitmap, i, this.md5.length() + i, 33);
            ((SpannableStringBuilder)localObject).setSpan(paramString, j, j + 4 + this.md5.length(), 33);
            SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(this.gEX);
            localSpannableStringBuilder.append("  ").append(this.md5).append("  ").append(" ");
            i = localSpannableStringBuilder.length() - this.md5.length() - 2 - 1;
            j = localSpannableStringBuilder.length() - this.md5.length() - 4 - 1;
            localSpannableStringBuilder.setSpan(paramBitmap, i, this.md5.length() + i, 33);
            localSpannableStringBuilder.setSpan(paramString, j, j + 4 + this.md5.length(), 33);
            localSnsCommentCollapseLayout.a((CharSequence)localObject, localSpannableStringBuilder, this.Acs, this.deleteFlag);
          }
        }
      }
      AppMethodBeat.o(100059);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem
 * JD-Core Version:    0.7.0.1
 */