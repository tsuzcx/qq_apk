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
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ea;
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.plugin.sns.model.aq.b;
import com.tencent.mm.plugin.sns.model.as;
import com.tencent.mm.plugin.sns.model.ay;
import com.tencent.mm.plugin.sns.model.f.5;
import com.tencent.mm.plugin.sns.model.f.d;
import com.tencent.mm.plugin.sns.ui.AsyncNormalTextView;
import com.tencent.mm.plugin.sns.ui.AsyncTextView;
import com.tencent.mm.plugin.sns.ui.MaskTextView;
import com.tencent.mm.plugin.sns.ui.PhotosContent;
import com.tencent.mm.plugin.sns.ui.SnsLikesTextView;
import com.tencent.mm.plugin.sns.ui.SnsTranslateResultView;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.TranslateCommentTextView;
import com.tencent.mm.plugin.sns.ui.ad;
import com.tencent.mm.plugin.sns.ui.an;
import com.tencent.mm.plugin.sns.ui.ba;
import com.tencent.mm.plugin.sns.ui.be;
import com.tencent.mm.plugin.sns.ui.be.c;
import com.tencent.mm.plugin.sns.ui.bf;
import com.tencent.mm.plugin.sns.ui.bi;
import com.tencent.mm.plugin.sns.ui.bk;
import com.tencent.mm.plugin.sns.ui.bl;
import com.tencent.mm.plugin.sns.ui.widget.SnsAvatarImageView;
import com.tencent.mm.plugin.sns.ui.widget.SnsCommentCollapseLayout;
import com.tencent.mm.plugin.sns.ui.y;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.n;
import com.tencent.mm.pluginsdk.ui.span.p.a;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bua;
import com.tencent.mm.protocal.protobuf.daa;
import com.tencent.mm.protocal.protobuf.dag;
import com.tencent.mm.protocal.protobuf.ej;
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.a.a.a;
import com.tencent.mm.ui.ao;
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
  public boolean DEBUG = false;
  protected Activity mActivity;
  protected int oeH;
  protected be xZJ;
  protected boolean yIK = false;
  public ArrayList<aq.b> zda = new ArrayList();
  
  private static void a(View paramView, CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt)
  {
    if ((paramView instanceof SnsCommentCollapseLayout)) {
      ((SnsCommentCollapseLayout)paramView).a(paramCharSequence1, paramCharSequence2, paramInt);
    }
    while (!(paramView instanceof TextView)) {
      return;
    }
    ((TextView)paramView).setText(paramCharSequence1);
  }
  
  public static void a(aq.b paramb, BaseViewHolder paramBaseViewHolder, String paramString1, String paramString2)
  {
    if ((paramBaseViewHolder != null) && (paramBaseViewHolder.zdk != null))
    {
      paramBaseViewHolder.zdk.a(paramb, 1, paramString1, paramString2, paramb.xVR);
      paramBaseViewHolder.zdk.setVisibility(0);
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
      ac.e("MicroMsg.BaseTimeLineItem", "setReward error  e:%s", new Object[] { bs.m(paramMaskTextView) });
      return;
    }
    ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
    com.tencent.mm.ui.widget.a locala = new com.tencent.mm.ui.widget.a((Drawable)localObject);
    locala.IZa = ((int)((((Drawable)localObject).getIntrinsicHeight() - paramMaskTextView.getTextSize() + com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 2)) / 2.0F));
    localSpannableStringBuilder.setSpan(locala, k, k + 1, 33);
    if (paramInt == 10)
    {
      paramInt = 3;
      break label403;
      while (i < arrayOfInt1.length)
      {
        localSpannableStringBuilder.setSpan(new com.tencent.mm.pluginsdk.ui.span.p((String)((com.tencent.mm.vending.j.a)paramb.get(i)).get(0), this.xZJ.yJy, paramInt), arrayOfInt1[i], arrayOfInt2[i], 33);
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
  
  private static void a(bf parambf, TimeLineObject paramTimeLineObject)
  {
    if ((parambf == null) || (paramTimeLineObject == null)) {}
    for (;;)
    {
      return;
      if (paramTimeLineObject.FQn == null) {}
      for (String str = null; !bs.isNullOrNil(str); str = paramTimeLineObject.FQn.Id)
      {
        com.tencent.mm.plugin.sns.c.a.iyy.a(str, paramTimeLineObject.ncR, paramTimeLineObject.FQo.Ety, paramTimeLineObject.FQs, parambf.yUS);
        return;
      }
    }
  }
  
  private static void a(BaseViewHolder paramBaseViewHolder, com.tencent.mm.plugin.sns.storage.p paramp)
  {
    if (paramp.Pe(32))
    {
      if (paramBaseViewHolder.zdj != null) {
        paramBaseViewHolder.zdj.setVisibility(0);
      }
      paramBaseViewHolder.zdl.setLongClickable(false);
      paramBaseViewHolder.zdl.setOnClickListener(null);
      paramp = new LinearLayout.LayoutParams(-1, -2);
      paramBaseViewHolder.zdl.setLayoutParams(paramp);
      paramBaseViewHolder.zdl.setBackgroundColor(Color.parseColor("#00ffffff"));
      if (paramBaseViewHolder.zdG != null)
      {
        paramp = (LinearLayout.LayoutParams)paramBaseViewHolder.zdG.getLayoutParams();
        paramp.leftMargin = 0;
        paramp.rightMargin = 0;
        paramBaseViewHolder.zdG.setLayoutParams(paramp);
      }
      if (paramBaseViewHolder.zee)
      {
        paramp = (LinearLayout.LayoutParams)paramBaseViewHolder.zbE.yFc.getLayoutParams();
        paramp.leftMargin = 0;
        paramp.rightMargin = 0;
        paramBaseViewHolder.zbE.yFc.setLayoutParams(paramp);
      }
      return;
    }
    if (paramBaseViewHolder.zdj != null) {
      paramBaseViewHolder.zdj.setVisibility(0);
    }
    paramBaseViewHolder.zdl.setLongClickable(false);
    paramBaseViewHolder.zdl.setOnClickListener(null);
    if (paramBaseViewHolder.zdG != null)
    {
      paramp = (LinearLayout.LayoutParams)paramBaseViewHolder.zdG.getLayoutParams();
      paramp.leftMargin = 0;
      paramp.rightMargin = 0;
      paramBaseViewHolder.zdG.setLayoutParams(paramp);
    }
    if (paramBaseViewHolder.zee)
    {
      paramp = (LinearLayout.LayoutParams)paramBaseViewHolder.zbE.yFc.getLayoutParams();
      paramp.leftMargin = 0;
      paramp.rightMargin = 0;
      paramBaseViewHolder.zbE.yFc.setLayoutParams(paramp);
    }
    paramp = new LinearLayout.LayoutParams(-1, -2);
    paramBaseViewHolder.zdl.setLayoutParams(paramp);
    paramBaseViewHolder.zdl.setBackgroundColor(Color.parseColor("#00ffffff"));
  }
  
  private boolean a(List<daa> paramList, com.tencent.mm.vending.d.b<com.tencent.mm.vending.j.a> paramb, BaseViewHolder paramBaseViewHolder)
  {
    LinearLayout localLinearLayout = paramBaseViewHolder.zdC;
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
          this.xZJ.a((SnsCommentCollapseLayout)localObject1);
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
    Object localObject1 = this.xZJ.dQv();
    if ((localObject1 instanceof com.tencent.mm.plugin.sns.ui.a.c)) {}
    for (bf localbf = (bf)((com.tencent.mm.plugin.sns.ui.a.c)localObject1).yZn.get(paramBaseViewHolder.position);; localbf = null)
    {
      if (this.DEBUG) {
        ac.d("MicroMsg.BaseTimeLineItem", "debug:setCommentList position " + paramBaseViewHolder.position + " commentCount: " + j);
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
        if (bs.isNullOrNil((String)localObject7)) {
          break label2161;
        }
        j = 1;
        localStringBuilder2.append(l).append("|");
      }
      for (;;)
      {
        localStringBuilder1.append(l).append("|");
        daa localdaa = (daa)paramList.get(m);
        i = localdaa.FJd;
        Object localObject6 = bl(paramBaseViewHolder.dnn, l);
        if ((localObject6 != null) && (((aq.b)localObject6).aEZ)) {
          aq.eC(((aq.b)localObject6).id, 2);
        }
        label510:
        int n;
        if (k >= i1) {
          if ((localObject6 == null) || (((aq.b)localObject6).aEZ))
          {
            localObject1 = this.xZJ.dQr();
            ((SnsCommentCollapseLayout)localObject1).setTextSize$255e752(15.0F * com.tencent.mm.cc.a.eb(((View)localObject1).getContext()));
            if (this.xZJ.ySi == -1) {
              this.xZJ.ySi = this.mActivity.getResources().getColor(2131100907);
            }
            ((SnsCommentCollapseLayout)localObject1).setTextColor(this.xZJ.ySi);
            ((SnsCommentCollapseLayout)localObject1).setGravity(16);
            n = 1;
            label513:
            if (localObject6 == null) {
              break label1204;
            }
            if ((localObject1 instanceof TranslateCommentTextView)) {
              break label2158;
            }
            localLinearLayout.removeView((View)localObject1);
            localObject1 = new TranslateCommentTextView(this.mActivity);
            localLinearLayout.addView((View)localObject1, k);
            ((TranslateCommentTextView)localObject1).getTranslateResultView().setResultTextSize$255e752(15.0F * com.tencent.mm.cc.a.eb(((View)localObject1).getContext()));
            ((TranslateCommentTextView)localObject1).getOriginCommentTextView().setTextSize(1, 15.0F * com.tencent.mm.cc.a.eb(((View)localObject1).getContext()));
          }
        }
        label741:
        label2155:
        label2158:
        for (;;)
        {
          localObject7 = (TranslateCommentTextView)localObject1;
          ((View)localObject1).setOnTouchListener(null);
          a(((TranslateCommentTextView)localObject7).getOriginCommentTextView(), (CharSequence)localObject5, (CharSequence)localObject4, i);
          Object localObject2;
          if (!((aq.b)localObject6).hqq)
          {
            ((TranslateCommentTextView)localObject7).yYV.setTextSize(1, 15.0F * com.tencent.mm.cc.a.eb(((TranslateCommentTextView)localObject7).getContext()));
            ((TranslateCommentTextView)localObject7).yKP.PK(2);
            ((TranslateCommentTextView)localObject7).yKP.setVisibility(0);
            i = 1;
            if (k <= 0) {
              break label1902;
            }
            ((View)localObject1).setPadding(com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 8), com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 4), com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 0), com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 3));
            if (k != paramb.size() - 1) {
              break label1891;
            }
            ((View)localObject1).setBackgroundResource(2131234841);
            if (i != 0)
            {
              localObject2 = (TranslateCommentTextView)localObject1;
              i = (int)this.mActivity.getResources().getDimension(2131165568);
              ((TranslateCommentTextView)localObject2).yKP.getSplitlineView().setPadding(0, 0, i, 0);
            }
            ((View)localObject1).setOnLongClickListener(new View.OnLongClickListener()
            {
              public final boolean onLongClick(View paramAnonymousView)
              {
                AppMethodBeat.i(100050);
                int[] arrayOfInt = new int[2];
                if ((paramAnonymousView.getTag(2131306044) instanceof int[])) {}
                for (paramAnonymousView = (int[])paramAnonymousView.getTag(2131306044);; paramAnonymousView = arrayOfInt)
                {
                  BaseTimeLineItem.this.xZJ.dQx().a(this.yYF, BaseTimeLineItem.this.xZJ.xZe.zgC, BaseTimeLineItem.this.xZJ.xZe.zgp, paramAnonymousView[0], paramAnonymousView[1]);
                  AppMethodBeat.o(100050);
                  return true;
                }
              }
            });
            ((View)localObject1).setOnClickListener(new com.tencent.mm.plugin.sns.ui.i.a(this.xZJ.ySd, localdaa, str2, str3, paramBaseViewHolder));
            if (localbf != null) {
              ((View)localObject1).setTag(new com.tencent.mm.plugin.sns.ui.m(localbf.yzm, localbf.yUR, localdaa, str1, str3, (View)localObject1, 1));
            }
            if (n != 0) {
              localLinearLayout.addView((View)localObject1);
            }
            m += 1;
            i = j;
            k += 1;
            break;
            localObject1 = new TranslateCommentTextView(this.mActivity);
            ((TranslateCommentTextView)localObject1).getTranslateResultView().setResultTextSize$255e752(15.0F * com.tencent.mm.cc.a.eb(((View)localObject1).getContext()));
            ((TranslateCommentTextView)localObject1).getOriginCommentTextView().setTextSize(1, 15.0F * com.tencent.mm.cc.a.eb(((View)localObject1).getContext()));
            break label510;
            localObject1 = localLinearLayout.getChildAt(k);
            n = 0;
            break label513;
          }
          Object localObject8;
          Object localObject3;
          if (!((aq.b)localObject6).aEZ)
          {
            localObject4 = ((aq.b)localObject6).result;
            localObject5 = ((aq.b)localObject6).hym;
            localObject8 = ((TranslateCommentTextView)localObject7).yYV.getText().toString();
            if (!bs.isNullOrNil((String)localObject8))
            {
              localObject2 = ((String)localObject8).split(":");
              if (localObject2.length <= 2) {
                break label2155;
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
              if (bs.isNullOrNil((String)localObject4)) {
                break label1166;
              }
              ((TranslateCommentTextView)localObject7).yKP.a((aq.b)localObject6, 2, localObject2[0] + ": " + (String)localObject4, (String)localObject5, ((aq.b)localObject6).xVR);
            }
            for (;;)
            {
              ((TranslateCommentTextView)localObject7).yKP.setVisibility(0);
              ((TranslateCommentTextView)localObject7).yYV.setTextSize(1, 15.0F * com.tencent.mm.cc.a.eb(((TranslateCommentTextView)localObject7).getContext()));
              i = 1;
              break;
              ((TranslateCommentTextView)localObject7).yKP.a((aq.b)localObject6, 2, null, (String)localObject5, ((aq.b)localObject6).xVR);
            }
            ((TranslateCommentTextView)localObject7).getTranslateResultView().setVisibility(8);
            i = 1;
            break;
            localObject2 = localObject1;
            if (n == 0)
            {
              localObject2 = localObject1;
              if ((localObject1 instanceof TranslateCommentTextView))
              {
                localLinearLayout.removeView((View)localObject1);
                localObject2 = this.xZJ.dQr();
                localLinearLayout.addView((View)localObject2, k);
                ((SnsCommentCollapseLayout)localObject2).setTextSize$255e752(15.0F * com.tencent.mm.cc.a.eb(((View)localObject2).getContext()));
              }
            }
            if ((localObject2 instanceof SnsCommentCollapseLayout))
            {
              ((SnsCommentCollapseLayout)localObject2).setTextSize$255e752(15.0F * com.tencent.mm.cc.a.eb(((View)localObject2).getContext()));
              ((SnsCommentCollapseLayout)localObject2).setOpClickListener(this.xZJ.ySu);
              ((SnsCommentCollapseLayout)localObject2).setPressTouchListener(new n(this.mActivity));
            }
            localObject3 = new CharSequence[2];
            localObject3[0] = localObject5;
            localObject3[1] = localObject4;
            localObject2.hashCode();
            if ((bs.isNullOrNil((String)localObject7)) || (!(localObject2 instanceof SnsCommentCollapseLayout)))
            {
              a((View)localObject2, localObject3[0], localObject3[1], i);
              i = 0;
              localObject1 = localObject2;
              break;
            }
            localObject1 = af.dHO();
            localObject6 = new d((String)localObject7, (CharSequence)localObject5, (CharSequence)localObject4, (View)localObject2, i, this.xZJ.ySm);
            localObject8 = com.tencent.mm.emoji.loader.a.b.fPi;
            localObject8 = com.tencent.mm.emoji.loader.a.b.te((String)localObject7);
            if (localObject8 == null) {
              af.dHE().execute(new f.5((com.tencent.mm.plugin.sns.model.f)localObject1, (String)localObject7, (f.d)localObject6));
            }
            int i2 = ao.fromDPToPix(this.mActivity, 28);
            localObject6 = new StringBuilder((String)localObject7);
            if (localObject8 == null)
            {
              ((StringBuilder)localObject6).append("miss");
              ac.i("MicroMsg.BaseTimeLineItem", "wrapEmojiInfo:%s miss cache", new Object[] { ((StringBuilder)localObject6).toString() });
            }
            for (localObject1 = this.mActivity.getResources().getDrawable(2131234117);; localObject1 = new BitmapDrawable((Bitmap)localObject8))
            {
              localObject5 = new SpannableStringBuilder((CharSequence)localObject5);
              ((SpannableStringBuilder)localObject5).append("  ").append(((StringBuilder)localObject6).toString()).append("  ").append(" ");
              int i3 = ((SpannableStringBuilder)localObject5).length() - ((StringBuilder)localObject6).toString().length() - 2 - 1;
              int i4 = ((SpannableStringBuilder)localObject5).length() - ((StringBuilder)localObject6).toString().length() - 4 - 1;
              ((Drawable)localObject1).setBounds(0, 0, i2, i2);
              localObject7 = new com.tencent.mm.ui.widget.a((Drawable)localObject1);
              localObject8 = new com.tencent.mm.pluginsdk.ui.span.p(((StringBuilder)localObject6).toString(), this.xZJ.ySm, 2);
              ((SpannableStringBuilder)localObject5).setSpan(localObject7, i3, ((StringBuilder)localObject6).toString().length() + i3, 33);
              ((SpannableStringBuilder)localObject5).setSpan(localObject8, i4, i4 + 4 + ((StringBuilder)localObject6).toString().length(), 33);
              localObject4 = new SpannableStringBuilder((CharSequence)localObject4);
              ((SpannableStringBuilder)localObject4).append("  ").append(((StringBuilder)localObject6).toString()).append("  ").append(" ");
              i3 = ((SpannableStringBuilder)localObject4).length() - ((StringBuilder)localObject6).toString().length() - 2 - 1;
              i4 = ((SpannableStringBuilder)localObject4).length() - ((StringBuilder)localObject6).toString().length() - 4 - 1;
              ((Drawable)localObject1).setBounds(0, 0, i2, i2);
              ((SpannableStringBuilder)localObject4).setSpan(localObject7, i3, ((StringBuilder)localObject6).toString().length() + i3, 33);
              ((SpannableStringBuilder)localObject4).setSpan(localObject8, i4, i4 + 4 + ((StringBuilder)localObject6).toString().length(), 33);
              localObject3[0] = localObject5;
              localObject3[1] = localObject4;
              break;
              ac.i("MicroMsg.BaseTimeLineItem", "wrapEmojiInfo:%s hit cache", new Object[] { ((StringBuilder)localObject6).toString() });
            }
            ((View)localObject1).setBackgroundResource(2131234100);
            break label741;
            label1902:
            ((View)localObject1).setPadding(com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 8), com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 6), com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 0), com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 3));
            if (paramBaseViewHolder.zdB)
            {
              if (paramb.size() == 1)
              {
                ((View)localObject1).setBackgroundResource(2131234841);
                break label741;
              }
              ((View)localObject1).setBackgroundResource(2131234100);
              break label741;
            }
            if (paramb.size() == 1)
            {
              ((View)localObject1).setBackgroundResource(2131234150);
              break label741;
            }
            ((View)localObject1).setBackgroundResource(2131234842);
            break label741;
            if (i != 0)
            {
              paramList = com.tencent.mm.plugin.sns.j.f.ydE;
              i = paramBaseViewHolder.position;
              l = localbf.xHc.field_snsId;
              paramb = localStringBuilder2.toString();
              localObject2 = localStringBuilder1.toString();
              paramBaseViewHolder = q.wW(l);
              if (paramList.ydP.get(paramBaseViewHolder) == null)
              {
                localObject1 = new ea();
                ((ea)localObject1).dTm = ((ea)localObject1).t("PublishId", paramBaseViewHolder, true);
                ((ea)localObject1).dTn = ((ea)localObject1).t("CommentIdList", (String)localObject2, true);
                ((ea)localObject1).dTo = ((ea)localObject1).t("EmojiIdList", paramb, true);
                paramb = new com.tencent.mm.plugin.sns.j.f.a(paramList);
                paramb.position = i;
                paramb.yeo = ((ea)localObject1);
                paramList.ydP.put(paramBaseViewHolder, paramb);
              }
            }
            return true;
          }
        }
        label1166:
        label1204:
        label1891:
        label2161:
        j = i;
      }
    }
  }
  
  private aq.b bl(String paramString, long paramLong)
  {
    if (this.zda.size() <= 0) {
      return null;
    }
    Iterator localIterator = this.zda.iterator();
    while (localIterator.hasNext())
    {
      aq.b localb = (aq.b)localIterator.next();
      if ((localb.id != null) && (localb.id.equals(aq.jd(paramString, String.valueOf(paramLong))))) {
        return localb;
      }
    }
    return null;
  }
  
  public static void f(BaseViewHolder paramBaseViewHolder)
  {
    if ((paramBaseViewHolder != null) && (paramBaseViewHolder.zdk != null))
    {
      paramBaseViewHolder.zdk.PK(1);
      paramBaseViewHolder.zdk.setVisibility(0);
    }
  }
  
  public static void g(BaseViewHolder paramBaseViewHolder)
  {
    if ((paramBaseViewHolder != null) && (paramBaseViewHolder.zdk != null)) {
      paramBaseViewHolder.zdk.setVisibility(8);
    }
  }
  
  public final View a(Activity paramActivity, BaseViewHolder paramBaseViewHolder, int paramInt, be parambe, com.tencent.mm.plugin.sns.storage.p paramp)
  {
    this.mActivity = paramActivity;
    this.oeH = paramInt;
    this.xZJ = parambe;
    paramBaseViewHolder.dnn = paramp.getSnsId();
    Object localObject;
    View localView;
    switch (paramInt)
    {
    default: 
      localObject = "R.layout.sns_media_sub_item2";
      com.tencent.mm.kiss.a.b.ahR();
      localView = com.tencent.mm.kiss.a.b.c(this.mActivity, 2131495612);
      paramBaseViewHolder.zen = localView;
      paramBaseViewHolder.zem = ((String)localObject);
      localObject = localView.findViewById(2131300969);
      if (!(localObject instanceof ViewStub)) {
        break;
      }
    }
    for (paramBaseViewHolder.zdm = ((ViewStub)localObject);; paramBaseViewHolder.zdm = null)
    {
      ac.i("MicroMsg.BaseTimeLineItem", "create new item  " + paramInt + "  " + localView.hashCode());
      paramBaseViewHolder.zef = localView.findViewById(2131305085);
      paramBaseViewHolder.oeH = paramInt;
      paramBaseViewHolder.zdf = ((SnsAvatarImageView)localView.findViewById(2131296533));
      paramBaseViewHolder.zdf.setWeakContext(paramActivity);
      paramBaseViewHolder.zdf.setOnClickListener(parambe.xZe.zgq);
      paramBaseViewHolder.zdf.setOnLongClickListener(parambe.xZe.zgr);
      paramBaseViewHolder.zdf.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(100046);
          if (paramAnonymousMotionEvent.getAction() == 0) {
            paramAnonymousView.setTag(2131306044, new int[] { (int)paramAnonymousMotionEvent.getRawX(), (int)paramAnonymousMotionEvent.getRawY() });
          }
          AppMethodBeat.o(100046);
          return false;
        }
      });
      paramBaseViewHolder.zdg = ((AsyncTextView)localView.findViewById(2131302867));
      paramBaseViewHolder.zdh = ((ImageView)localView.findViewById(2131306175));
      paramBaseViewHolder.zdg.setOnTouchListener(new ad());
      paramBaseViewHolder.zdi = ((ViewGroup)localView.findViewById(2131302862));
      paramBaseViewHolder.zdj = ((AsyncNormalTextView)localView.findViewById(2131299001));
      paramBaseViewHolder.zdj.setOpClickListener(parambe.ySs);
      paramBaseViewHolder.zdl = ((LinearLayout)localView.findViewById(2131300970));
      paramBaseViewHolder.zdl.setTag(paramBaseViewHolder);
      paramBaseViewHolder.zdl.setOnClickListener(parambe.xZe.zgZ);
      localObject = localView.findViewById(2131299008);
      parambe.dQx().c((View)localObject, parambe.xZe.zgs, parambe.xZe.zgp);
      localObject = (TextView)localView.findViewById(2131299009);
      parambe.dQx().c((View)localObject, parambe.xZe.zgs, parambe.xZe.zgp);
      paramBaseViewHolder.zdk = ((SnsTranslateResultView)localView.findViewById(2131305091));
      paramBaseViewHolder.zdk.setVisibility(8);
      paramBaseViewHolder.zdk.getSplitlineView().setPadding(0, 0, 0, 0);
      paramBaseViewHolder.zdk.getResultTextView().setBackgroundResource(2131234100);
      parambe.dQx().c(paramBaseViewHolder.zdk.getResultTextView(), parambe.xZe.zgs, parambe.xZe.zgp);
      paramBaseViewHolder.zdF = ((LinearLayout)localView.findViewById(2131298526));
      paramBaseViewHolder.zdt = ((TextView)localView.findViewById(2131306999));
      paramBaseViewHolder.timeTv = ((TextView)localView.findViewById(2131296598));
      paramBaseViewHolder.zdv = ((AsyncTextView)localView.findViewById(2131296528));
      paramBaseViewHolder.zdw = ((AsyncTextView)localView.findViewById(2131296527));
      paramBaseViewHolder.yQm = ((TextView)localView.findViewById(2131296531));
      paramBaseViewHolder.xMy = new bk(localView);
      paramBaseViewHolder.xMy.a(parambe.xZe.zgA, parambe.xZe.zgO);
      paramBaseViewHolder.zds = ((RelativeLayout)localView.findViewById(2131303033));
      paramBaseViewHolder.zds.setOnClickListener(parambe.xZe.zgR);
      paramBaseViewHolder.yzU = ((TextView)localView.findViewById(2131296566));
      paramBaseViewHolder.yzU.setText(paramActivity.getString(2131755707));
      paramBaseViewHolder.yzU.setOnClickListener(parambe.xZe.zgu);
      paramBaseViewHolder.zdv.setOnClickListener(parambe.xZe.zgP);
      paramBaseViewHolder.zdw.setOnClickListener(parambe.xZe.zgQ);
      paramBaseViewHolder.yQm.setOnClickListener(parambe.xZe.zgL);
      paramBaseViewHolder.zdx = localView.findViewById(2131296570);
      paramBaseViewHolder.zdx.setOnClickListener(parambe.xZe.zgz);
      paramBaseViewHolder.zdu = ((WeImageView)localView.findViewById(2131296627));
      paramBaseViewHolder.ijD = ((TextView)localView.findViewById(2131296569));
      paramBaseViewHolder.zdy = ((ImageView)localView.findViewById(2131296599));
      paramBaseViewHolder.zdI = ((ViewStub)localView.findViewById(2131296561));
      paramBaseViewHolder.ywY = ((LinearLayout)localView.findViewById(2131296590));
      paramBaseViewHolder.zeh = ((ViewStub)localView.findViewById(2131296572));
      paramBaseViewHolder.zep = ((ViewStub)localView.findViewById(2131305093));
      paramBaseViewHolder.zet = ((ViewStub)localView.findViewById(2131308006));
      paramBaseViewHolder.isN = ((ViewGroup)localView.findViewById(2131304988));
      paramBaseViewHolder.zdK = ((ViewStub)localView.findViewById(2131305041));
      paramBaseViewHolder.zdo = ((TextView)localView.findViewById(2131300513));
      paramBaseViewHolder.zdo.setOnClickListener(parambe.xZe.zgv);
      BaseViewHolder.a(paramBaseViewHolder, (TextView)localView.findViewById(2131300687));
      paramBaseViewHolder.sSS = localView;
      if (this.yIK)
      {
        com.tencent.mm.plugin.sns.abtest.c.b(localView, paramBaseViewHolder);
        com.tencent.mm.plugin.sns.abtest.a.a(localView, paramBaseViewHolder);
        af.dHI();
        com.tencent.mm.plugin.sns.h.c.c(localView, paramBaseViewHolder);
      }
      e(paramBaseViewHolder);
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
    }
  }
  
  public final void a(BaseViewHolder paramBaseViewHolder, int paramInt, com.tencent.mm.plugin.sns.storage.p paramp)
  {
    paramp = paramp.dLV();
    bf localbf = (bf)this.xZJ.dQv().dNA().get(Integer.valueOf(paramInt));
    a(paramBaseViewHolder, paramInt, localbf, paramp, paramBaseViewHolder.oeH, this.xZJ);
    a(localbf, paramp);
  }
  
  public final void a(final BaseViewHolder paramBaseViewHolder, int paramInt1, com.tencent.mm.plugin.sns.storage.p paramp, TimeLineObject paramTimeLineObject, int paramInt2, final be parambe)
  {
    Object localObject3 = (bf)parambe.dQv().dNA().get(Integer.valueOf(paramInt1));
    a(paramBaseViewHolder, paramp);
    this.oeH = paramInt2;
    this.xZJ = parambe;
    if (this.yIK) {
      com.tencent.mm.plugin.sns.ui.a.c.Q(paramp);
    }
    com.tencent.mm.plugin.sns.ui.a.c.h(paramTimeLineObject);
    com.tencent.mm.plugin.sns.ui.a.c.g(paramTimeLineObject);
    if (paramp.Pe(32)) {
      ac.i("MicroMsg.BaseTimeLineItem", "the ad sns id is " + q.wX(paramp.field_snsId) + " for susan");
    }
    paramBaseViewHolder.zdd = ((bf)localObject3).yUS;
    paramBaseViewHolder.tdc = false;
    paramBaseViewHolder.position = paramInt1;
    paramBaseViewHolder.dnn = ((bf)localObject3).yUR;
    paramBaseViewHolder.ddB = ((bf)localObject3).yzm;
    paramBaseViewHolder.zde = ((bf)localObject3).yUW;
    paramBaseViewHolder.zdy.setOnClickListener(parambe.ySr);
    paramBaseViewHolder.timeLineObject = paramTimeLineObject;
    SnsObject localSnsObject = ((bf)localObject3).xHb;
    paramBaseViewHolder.snsobj = localSnsObject;
    Object localObject1 = parambe.ySd.yxQ.xUQ;
    Object localObject2;
    if (paramp != null)
    {
      localObject2 = paramp.dMu();
      ((com.tencent.mm.plugin.sns.j.c)localObject1).ydc.add(localObject2);
      if (paramp.Pe(32)) {
        ((com.tencent.mm.plugin.sns.j.c)localObject1).ydh.add(localObject2);
      }
      ((com.tencent.mm.plugin.sns.j.c)localObject1).ydi.add(paramp.field_userName);
    }
    int i;
    label605:
    Object localObject4;
    switch (paramp.field_type)
    {
    default: 
      ((com.tencent.mm.plugin.sns.j.c)localObject1).ydn.add(localObject2);
      if (paramInt1 < ((com.tencent.mm.plugin.sns.j.c)localObject1).yda)
      {
        ((com.tencent.mm.plugin.sns.j.c)localObject1).yda = paramInt1;
        ((com.tencent.mm.plugin.sns.j.c)localObject1).ybF = q.l(paramp);
      }
      if (paramInt1 > ((com.tencent.mm.plugin.sns.j.c)localObject1).ydb)
      {
        ((com.tencent.mm.plugin.sns.j.c)localObject1).ydb = paramInt1;
        ((com.tencent.mm.plugin.sns.j.c)localObject1).ybG = q.l(paramp);
      }
      ((com.tencent.mm.plugin.sns.j.c)localObject1).ybL = ((com.tencent.mm.plugin.sns.j.c)localObject1).ydd.size();
      ((com.tencent.mm.plugin.sns.j.c)localObject1).ybM = ((com.tencent.mm.plugin.sns.j.c)localObject1).yde.size();
      ((com.tencent.mm.plugin.sns.j.c)localObject1).ybN = ((com.tencent.mm.plugin.sns.j.c)localObject1).ydf.size();
      ((com.tencent.mm.plugin.sns.j.c)localObject1).ybP = ((com.tencent.mm.plugin.sns.j.c)localObject1).ydg.size();
      ((com.tencent.mm.plugin.sns.j.c)localObject1).ybO = ((com.tencent.mm.plugin.sns.j.c)localObject1).ydh.size();
      ((com.tencent.mm.plugin.sns.j.c)localObject1).ybQ = ((com.tencent.mm.plugin.sns.j.c)localObject1).ydl.size();
      ((com.tencent.mm.plugin.sns.j.c)localObject1).ybY = ((com.tencent.mm.plugin.sns.j.c)localObject1).ydm.size();
      ((com.tencent.mm.plugin.sns.j.c)localObject1).nwV = ((com.tencent.mm.plugin.sns.j.c)localObject1).ydi.size();
      ((com.tencent.mm.plugin.sns.j.c)localObject1).ybJ = ((com.tencent.mm.plugin.sns.j.c)localObject1).ydj.size();
      ((com.tencent.mm.plugin.sns.j.c)localObject1).ybK = ((com.tencent.mm.plugin.sns.j.c)localObject1).ydk.size();
      ((com.tencent.mm.plugin.sns.j.c)localObject1).ybX = ((com.tencent.mm.plugin.sns.j.c)localObject1).ydn.size();
      ((com.tencent.mm.plugin.sns.j.c)localObject1).ybt = ((com.tencent.mm.plugin.sns.j.c)localObject1).ydc.size();
      localObject2 = ((bf)localObject3).xIG;
      localObject1 = ((bf)localObject3).lhM;
      if (!bs.isNullOrNil((String)localObject1))
      {
        paramBaseViewHolder.yxE = ((bf)localObject3).yUQ;
        paramBaseViewHolder.zdf.setTag(localObject1);
        if (paramBaseViewHolder.yxE != null) {
          if ((com.tencent.mm.storage.ai.aNc((String)localObject1)) && ("3552365301".equals(paramBaseViewHolder.yxE.field_openImAppid)))
          {
            i = 1;
            if ((localObject2 == null) || (!((com.tencent.mm.plugin.sns.storage.b)localObject2).ygq)) {
              break label3057;
            }
            paramBaseViewHolder.zdf.setImageResource(2131231875);
            paramBaseViewHolder.zdf.eM((String)localObject1, 4);
            paramBaseViewHolder.zdf.setShowStoryHint(false);
            if (!bs.isNullOrNil(((com.tencent.mm.plugin.sns.storage.b)localObject2).ygs))
            {
              localObject4 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.js("adId", ((com.tencent.mm.plugin.sns.storage.b)localObject2).ygs);
              paramBaseViewHolder.zdf.setTag(2131305044, ((com.tencent.mm.plugin.sns.storage.b)localObject2).ygs);
              if (!com.tencent.mm.vfs.i.eA((String)localObject4)) {
                break label3036;
              }
              localObject2 = com.tencent.mm.plugin.sns.ad.d.l.xKs.getBitmap((String)localObject4);
              if (localObject2 != null) {
                paramBaseViewHolder.zdf.setImageBitmap((Bitmap)localObject2);
              }
            }
            label717:
            paramBaseViewHolder.zdg.a((String)localObject1, ((bf)localObject3).yVg, new p.a()
            {
              public final void b(View paramAnonymousView, Object paramAnonymousObject)
              {
                AppMethodBeat.i(100048);
                if (parambe.yJy != null)
                {
                  parambe.yJy.dbL = 0;
                  parambe.yJy.b(paramAnonymousView, paramAnonymousObject);
                }
                AppMethodBeat.o(100048);
              }
            }, ((bf)localObject3).yxA, ((bf)localObject3).yzm, paramInt2, ((bf)localObject3).yxA);
            paramBaseViewHolder.zdf.gMG = ((bf)localObject3).yzm;
          }
        }
      }
      break;
    }
    for (;;)
    {
      paramBaseViewHolder.zdh.setVisibility(8);
      label1044:
      label1941:
      if (((bf)localObject3).yxA)
      {
        paramBaseViewHolder.isAd = true;
        paramBaseViewHolder.tdc = ((bf)localObject3).yUX;
        label801:
        paramBaseViewHolder.zdj.a(((bf)localObject3).yUT, parambe, ((bf)localObject3).yUU, (bf)localObject3);
        paramBaseViewHolder.zdj.setShow(paramBaseViewHolder);
        paramBaseViewHolder.ijD.setOnTouchListener(new ad());
        a(paramBaseViewHolder, paramInt1, (bf)localObject3, paramTimeLineObject, paramInt2, parambe);
        a((bf)localObject3, paramTimeLineObject);
        parambe.ySf.put(Integer.valueOf(paramInt1), new WeakReference(paramBaseViewHolder.sSS));
        if (paramBaseViewHolder.sSS.getBackground() == null)
        {
          paramBaseViewHolder.sSS.setBackgroundResource(2131231818);
          paramInt1 = com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 12);
          int j = com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 8);
          paramBaseViewHolder.sSS.setPadding(paramInt1, paramInt1, paramInt1, j);
        }
        paramBaseViewHolder.timeTv.setText(((bf)localObject3).yUZ);
        paramBaseViewHolder.zdv.setVisibility(8);
        paramBaseViewHolder.zdw.setVisibility(8);
        if (((bf)localObject3).yxA)
        {
          localObject2 = ((bf)localObject3).yVa;
          paramBaseViewHolder.zdv.setTag(((bf)localObject3).yzm);
          if (((bf)localObject3).yVa.yeI != com.tencent.mm.plugin.sns.storage.a.yeu) {
            break label3362;
          }
          if (bs.isNullOrNil(((bf)localObject3).yVd)) {
            break label3350;
          }
          paramBaseViewHolder.zdv.setText(((bf)localObject3).yVd);
          paramBaseViewHolder.zdv.setVisibility(0);
          if ((paramBaseViewHolder.zdv.getVisibility() != 8) && (bs.isNullOrNil(((com.tencent.mm.plugin.sns.storage.a)localObject2).yeK)))
          {
            paramBaseViewHolder.zdv.setTextColor(this.mActivity.getResources().getColor(2131100943));
            paramBaseViewHolder.zdv.setOnClickListener(null);
          }
          if ((paramp.dLV().FQo.EtA & 0x4) == 0) {
            break label3671;
          }
          paramBaseViewHolder.zdw.setTag(paramBaseViewHolder);
          paramBaseViewHolder.zdw.setVisibility(0);
          paramBaseViewHolder.zdw.setText(String.format("%s%s%s", new Object[] { this.mActivity.getResources().getString(2131763743), ((bf)localObject3).yVg, this.mActivity.getResources().getString(2131763744) }));
        }
        label1183:
        if (!((bf)localObject3).yVj) {
          break label3683;
        }
        localObject1 = parambe.iMV.getString(2131760986, new Object[] { Integer.valueOf(((bf)localObject3).yVk) });
        BaseViewHolder.h(paramBaseViewHolder).setText((CharSequence)localObject1);
        BaseViewHolder.h(paramBaseViewHolder).setVisibility(0);
        label1236:
        paramBaseViewHolder.yQm.setTag(((bf)localObject3).yzm);
        if (bs.isNullOrNil(((bf)localObject3).yVm)) {
          break label3735;
        }
        paramBaseViewHolder.yQm.setVisibility(0);
        paramBaseViewHolder.yQm.setText(((bf)localObject3).yVm);
        paramBaseViewHolder.yQm.setClickable(((bf)localObject3).yVn);
        localObject1 = paramBaseViewHolder.yQm;
        if (!((bf)localObject3).yVn) {
          break label3695;
        }
        paramInt1 = this.mActivity.getResources().getColor(2131100914);
        label1319:
        ((TextView)localObject1).setTextColor(paramInt1);
        if (!((bf)localObject3).yVn) {
          break label3712;
        }
        paramBaseViewHolder.yQm.setBackground(this.mActivity.getResources().getDrawable(2131234100));
        label1353:
        if (!((bf)localObject3).yVu) {
          break label3747;
        }
        paramBaseViewHolder.zdu.setVisibility(0);
        paramBaseViewHolder.zdu.setImageResource(2131690597);
        paramBaseViewHolder.zdu.setIconColor(this.mActivity.getResources().getColor(2131099660));
        label1399:
        paramBaseViewHolder.ijD.setTextColor(this.mActivity.getResources().getColor(2131100914));
        if (!((bf)localObject3).yVo) {
          break label3759;
        }
        paramBaseViewHolder.ijD.setVisibility(0);
        localObject2 = this.mActivity.getString(2131763791) + ((bf)localObject3).mAppName;
        localObject1 = localObject2;
        if (((String)localObject2).length() > 10) {
          localObject1 = ((String)localObject2).substring(0, 10) + "...";
        }
        localObject1 = new SpannableString((CharSequence)localObject1);
        ((SpannableString)localObject1).setSpan(new b(), 0, ((SpannableString)localObject1).length(), 33);
        paramBaseViewHolder.ijD.setText((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
        if ((!((bf)localObject3).yVq) && (!"wx7fa037cc7dfabad5".equals(paramTimeLineObject.FQn.Id)))
        {
          paramBaseViewHolder.ijD.setTextColor(this.mActivity.getResources().getColor(2131100943));
          paramBaseViewHolder.ijD.setOnTouchListener(null);
        }
        paramBaseViewHolder.ijD.setTag(paramTimeLineObject);
        label1617:
        if (!((bf)localObject3).yVi) {
          break label4060;
        }
        paramBaseViewHolder.yzU.setVisibility(0);
        paramBaseViewHolder.yzU.setTag(((bf)localObject3).yzm);
        label1645:
        paramBaseViewHolder.zdy.setTag(paramBaseViewHolder);
        if (!((bf)localObject3).yVv) {
          break label4159;
        }
        if (!paramBaseViewHolder.zdO)
        {
          paramBaseViewHolder.zdD = ((LinearLayout)paramBaseViewHolder.zdK.inflate());
          paramBaseViewHolder.zdE = paramBaseViewHolder.sSS.findViewById(2131303358);
          paramBaseViewHolder.zdO = true;
          paramBaseViewHolder.zdE.setTag(((bf)localObject3).yzm);
          paramBaseViewHolder.yoJ = ((TextView)paramBaseViewHolder.zdD.findViewById(2131303358));
        }
        paramBaseViewHolder.zdK.setVisibility(0);
        paramBaseViewHolder.zdE.setOnClickListener(parambe.xZe.zgy);
        label1818:
        label2593:
        switch (((bf)localObject3).yVw)
        {
        default: 
          paramBaseViewHolder.yoJ.setText(2131763946);
          paramBaseViewHolder.zdE.setClickable(true);
          paramBaseViewHolder.zdE.setEnabled(true);
          paramTimeLineObject = paramp.dMn();
          if ((paramTimeLineObject != null) && (!bs.isNullOrNil(paramTimeLineObject.FjU))) {
            paramBaseViewHolder.yoJ.setText(paramTimeLineObject.FjU);
          }
          label1852:
          if (((bf)localObject3).yVx)
          {
            paramBaseViewHolder.zdx.setVisibility(0);
            paramBaseViewHolder.zdx.setTag(((bf)localObject3).yzm);
            label1880:
            if (!((bf)localObject3).yVy) {
              break label4281;
            }
            if (bs.isNullOrNil(((bf)localObject3).yVz)) {
              break label4220;
            }
            paramBaseViewHolder.zdt.setVisibility(0);
            if (paramInt2 != 7) {
              break label4190;
            }
            paramTimeLineObject = String.format(this.mActivity.getString(2131764038), new Object[] { ((bf)localObject3).yVz });
            paramTimeLineObject = com.tencent.mm.pluginsdk.ui.span.k.b(this.mActivity, paramTimeLineObject, paramBaseViewHolder.zdt.getTextSize());
            paramBaseViewHolder.zdt.setText(paramTimeLineObject);
            if (!((bf)localObject3).yVB) {
              break label4293;
            }
            if (paramBaseViewHolder.zei == null)
            {
              paramBaseViewHolder.zei = paramBaseViewHolder.zeh.inflate();
              paramBaseViewHolder.xPm = ((TextView)paramBaseViewHolder.zei.findViewById(2131296573));
              paramBaseViewHolder.zej = ((MaskTextView)paramBaseViewHolder.zei.findViewById(2131296574));
              paramBaseViewHolder.zej.setOnTouchListener(new ad());
            }
            paramBaseViewHolder.zei.setVisibility(0);
            a(paramBaseViewHolder.zej, ((bf)localObject3).yVE, paramInt2);
            paramTimeLineObject = this.mActivity.getString(2131763903, new Object[] { Integer.valueOf(((bf)localObject3).yVC), bs.C(((bf)localObject3).yVD / 100.0D) });
            paramBaseViewHolder.xPm.setText(paramTimeLineObject);
            paramBaseViewHolder.zei.setTag(paramp);
            paramBaseViewHolder.zei.setOnClickListener(parambe.xZe.zgB);
            label2139:
            if (((((bf)localObject3).yVF != null) && (((bf)localObject3).yVF.size() != 0)) || ((((bf)localObject3).yVG != null) && (((bf)localObject3).yVG.size() != 0))) {
              break label4331;
            }
            if (paramBaseViewHolder.ywY == null) {
              break label4312;
            }
            paramBaseViewHolder.ywY.setVisibility(8);
            if (!((bf)localObject3).yVH) {
              break label4755;
            }
            paramBaseViewHolder.zdo.setTag(((bf)localObject3).yzm);
            paramBaseViewHolder.zdo.setText(((bf)localObject3).yVI);
            paramBaseViewHolder.zdo.setVisibility(0);
            if (!((bf)localObject3).yxA) {
              break label4772;
            }
            ac.i("MicroMsg.BaseTimeLineItem", "adatag " + ((bf)localObject3).yVc);
            paramBaseViewHolder.xMy.F(Long.valueOf(((bf)localObject3).yUS), new com.tencent.mm.plugin.sns.data.b(paramBaseViewHolder.xMy, paramBaseViewHolder.position, ((bf)localObject3).yzm, ((bf)localObject3).yUS, ((bf)localObject3).yUY));
            paramBaseViewHolder.xMy.a(((bf)localObject3).yVb, ((bf)localObject3).yVa);
            paramBaseViewHolder.xMy.setVisibility(0);
            if ((paramBaseViewHolder.yQm != null) && (paramBaseViewHolder.yQm.getVisibility() == 0))
            {
              if (paramBaseViewHolder.xMy.yYd.getVisibility() != 0) {
                break label4767;
              }
              paramInt1 = 1;
              label2369:
              if (paramInt1 != 0)
              {
                paramTimeLineObject = (LinearLayout.LayoutParams)paramBaseViewHolder.yQm.getLayoutParams();
                paramTimeLineObject.setMargins(paramTimeLineObject.leftMargin, BackwardSupportUtil.b.g(this.mActivity, 0.0F), paramTimeLineObject.rightMargin, paramTimeLineObject.bottomMargin);
                paramBaseViewHolder.yQm.setLayoutParams(paramTimeLineObject);
              }
            }
            paramBaseViewHolder.zds.setVisibility(8);
            label2431:
            if (this.yIK) {
              af.dHI().a(this.mActivity, localSnsObject, paramBaseViewHolder);
            }
            paramTimeLineObject = af.dIa();
            long l = paramp.field_snsId;
            if ((!paramTimeLineObject.xVW) || (l == 0L) || (paramTimeLineObject.xWp) || (paramTimeLineObject.xWg <= paramTimeLineObject.xWa) || (paramTimeLineObject.xWt == null) || (paramTimeLineObject.xWt.state != 1) || (paramTimeLineObject.xWt.yaP < paramTimeLineObject.xWb) || (!paramTimeLineObject.xWl)) {
              break label4845;
            }
            if ((paramTimeLineObject.xWe != 0L) && (ce.azK() - paramTimeLineObject.xWs.xWw <= paramTimeLineObject.xWe)) {
              break label4840;
            }
            paramInt1 = 1;
            if ((paramInt1 == 0) || (l != paramTimeLineObject.xWu)) {
              break label4845;
            }
            paramInt1 = 1;
            if (paramInt1 == 0) {
              break label4850;
            }
            if (!paramBaseViewHolder.zeo)
            {
              paramBaseViewHolder.zeq = ((LinearLayout)paramBaseViewHolder.zep.inflate());
              paramBaseViewHolder.zeo = true;
              paramBaseViewHolder.zer = ((ViewGroup)paramBaseViewHolder.zeq.findViewById(2131305092));
            }
            paramBaseViewHolder.zep.setVisibility(0);
            paramBaseViewHolder.isN.setBackgroundColor(0);
            paramBaseViewHolder.zer.setTag(Long.valueOf(paramp.field_snsId));
            af.dIa().eF(paramBaseViewHolder.zer);
            paramBaseViewHolder.zer.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(179352);
                BaseTimeLineItem.this.xZJ.ySd.dNm();
                com.tencent.mm.plugin.sns.j.f.ydE.yek.dYt = 1L;
                AppMethodBeat.o(179352);
              }
            });
            com.tencent.mm.plugin.report.service.h.wUl.dB(1295, 1);
            af.dIb();
            if (!com.tencent.mm.plugin.sns.model.ap.o(paramp.field_snsId, paramp.field_createTime, paramp.yvp)) {
              break label4893;
            }
            if (!paramBaseViewHolder.zes)
            {
              paramBaseViewHolder.zeu = ((LinearLayout)paramBaseViewHolder.zet.inflate());
              paramBaseViewHolder.zes = true;
              paramBaseViewHolder.zev = ((TextView)paramBaseViewHolder.zeu.findViewById(2131308003));
            }
            paramBaseViewHolder.zet.setVisibility(0);
            paramBaseViewHolder.isN.setBackgroundColor(0);
            paramBaseViewHolder.zev.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(200655);
                paramAnonymousView = af.dIb();
                Context localContext = paramBaseViewHolder.zev.getContext();
                if (com.tencent.mm.plugin.sns.model.ap.xVF)
                {
                  ac.i(com.tencent.mm.plugin.sns.model.ap.TAG, "goRetryEdit draftKey:%s", new Object[] { paramAnonymousView.xVI });
                  Object localObject = af.dHY().auU(paramAnonymousView.xVI);
                  if (localObject != null)
                  {
                    localObject = ((com.tencent.mm.plugin.sns.storage.l)localObject).field_draft;
                    if (!bs.cv((byte[])localObject))
                    {
                      Parcel localParcel = Parcel.obtain();
                      localParcel.unmarshall((byte[])localObject, 0, localObject.length);
                      localParcel.setDataPosition(0);
                      try
                      {
                        localObject = (Intent)Intent.CREATOR.createFromParcel(localParcel);
                        ((Intent)localObject).putExtra("Kis_retry_edit", true);
                        localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
                        com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/sns/model/SnsRetryEditTipManager", "goRetryEdit", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
                        com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/plugin/sns/model/SnsRetryEditTipManager", "goRetryEdit", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        paramAnonymousView.reset();
                        com.tencent.mm.sdk.platformtools.ap.aB(paramAnonymousView.xVJ);
                        AppMethodBeat.o(200655);
                        return;
                      }
                      catch (Exception localException)
                      {
                        af.dHY().b(paramAnonymousView.xVI, null, 0);
                      }
                    }
                  }
                }
                AppMethodBeat.o(200655);
              }
            });
          }
          label1968:
          label2233:
          break;
        }
      }
      label2193:
      boolean bool;
      for (;;)
      {
        label2576:
        label2705:
        paramp = new ba(((bf)localObject3).yUR, ((bf)localObject3).yzm, false, true, 1);
        paramBaseViewHolder.zdk.getResultTextView().setTag(paramp);
        paramp = a.a.fhP();
        paramTimeLineObject = paramBaseViewHolder.sSS;
        parambe = paramBaseViewHolder.zdg;
        localObject3 = paramBaseViewHolder.timeTv;
        localObject1 = paramBaseViewHolder.zdj.getContent();
        localObject2 = paramBaseViewHolder.zdq;
        bool = paramBaseViewHolder.zee;
        if ((paramp.fhO()) && (paramp.GX != null) && (paramTimeLineObject != null) && (parambe != null) && (localObject3 != null)) {
          break label4922;
        }
        return;
        ((com.tencent.mm.plugin.sns.j.c)localObject1).yde.add(localObject2);
        break;
        ((com.tencent.mm.plugin.sns.j.c)localObject1).ydd.add(localObject2);
        break;
        ((com.tencent.mm.plugin.sns.j.c)localObject1).ydg.add(localObject2);
        break;
        ((com.tencent.mm.plugin.sns.j.c)localObject1).ydf.add(localObject2);
        break;
        ((com.tencent.mm.plugin.sns.j.c)localObject1).ydl.add(localObject2);
        break;
        ((com.tencent.mm.plugin.sns.j.c)localObject1).ydm.add(localObject2);
        break;
        if (!bs.isNullOrNil(paramTimeLineObject.FQp))
        {
          ((com.tencent.mm.plugin.sns.j.c)localObject1).ydj.add(localObject2);
          break;
        }
        ((com.tencent.mm.plugin.sns.j.c)localObject1).ydk.add(localObject2);
        break;
        i = 0;
        break label605;
        label3036:
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(((com.tencent.mm.plugin.sns.storage.b)localObject2).ygs, false, new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a()
        {
          public final void asD(String paramAnonymousString)
          {
            AppMethodBeat.i(100047);
            ac.i("MicroMsg.BaseTimeLineItem", "download img %s", new Object[] { paramAnonymousString });
            String str = (String)paramBaseViewHolder.zdf.getTag(2131305044);
            if ((!bs.T(new String[] { str, paramAnonymousString })) && (paramAnonymousString.equals(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.js("adId", str))))
            {
              paramAnonymousString = com.tencent.mm.plugin.sns.ad.d.l.xKs.getBitmap(paramAnonymousString);
              if (paramAnonymousString != null) {
                paramBaseViewHolder.zdf.setImageBitmap(paramAnonymousString);
              }
            }
            AppMethodBeat.o(100047);
          }
          
          public final void dFC() {}
          
          public final void dFD() {}
        });
        break label717;
        label3057:
        if (!((String)localObject1).endsWith("@ad")) {
          if (((bf)localObject3).yVh)
          {
            ac.i("MicroMsg.BaseTimeLineItem", "getContact %s", new Object[] { localObject1 });
            if (a.b.eMA().Kj() != null) {
              paramBaseViewHolder.zdf.setImageBitmap(a.b.eMA().Kj());
            }
            ar.a.hnw.a((String)localObject1, "", new be.c(parambe.dQv(), paramInt1));
            if (((bf)localObject3).yVi) {
              break label3290;
            }
            com.tencent.mm.plugin.sns.ui.e.a.b(4, (String)paramBaseViewHolder.zdf.getTag(), paramBaseViewHolder.zdf);
            paramBaseViewHolder.zdf.eM((String)localObject1, 4);
            paramBaseViewHolder.zdf.setTag(localObject1);
            com.tencent.mm.plugin.sns.ui.e.a.a(4, (String)localObject1, paramBaseViewHolder.zdf);
            paramBaseViewHolder.zdf.setShowStoryHint(((com.tencent.mm.plugin.story.api.e)g.ad(com.tencent.mm.plugin.story.api.e.class)).hasNewStory((String)localObject1));
          }
        }
        for (;;)
        {
          label3145:
          paramBaseViewHolder.zdg.setContactInfo(paramBaseViewHolder.yxE);
          paramBaseViewHolder.zdg.a((String)localObject1, ((bf)localObject3).yVg, new p.a()
          {
            public final void b(View paramAnonymousView, Object paramAnonymousObject)
            {
              AppMethodBeat.i(100049);
              if (parambe.yJy != null) {
                if (!(paramAnonymousObject instanceof com.tencent.mm.plugin.sns.data.a)) {
                  break label78;
                }
              }
              label78:
              for (boolean bool = ((com.tencent.mm.plugin.sns.data.a)paramAnonymousObject).isAd;; bool = false)
              {
                if (bool) {}
                for (parambe.yJy.dbL = 0;; parambe.yJy.dbL = 6)
                {
                  parambe.yJy.b(paramAnonymousView, paramAnonymousObject);
                  AppMethodBeat.o(100049);
                  return;
                }
              }
            }
          }, ((bf)localObject3).yxA, ((bf)localObject3).yzm, paramInt2, ((bf)localObject3).yxA);
          break;
          a.b.c(paramBaseViewHolder.zdf, (String)localObject1);
          break label3145;
          label3290:
          paramBaseViewHolder.zdf.eM((String)localObject1, 4);
          paramBaseViewHolder.zdf.setShowStoryHint(false);
          continue;
          paramBaseViewHolder.zdf.setImageResource(2131231875);
          paramBaseViewHolder.zdf.eM((String)localObject1, 4);
          paramBaseViewHolder.zdf.setShowStoryHint(false);
        }
        paramBaseViewHolder.isAd = false;
        break label801;
        label3350:
        paramBaseViewHolder.zdv.setVisibility(8);
        break label1044;
        label3362:
        if (((com.tencent.mm.plugin.sns.storage.a)localObject2).yeI != com.tencent.mm.plugin.sns.storage.a.yev) {
          break label1044;
        }
        if (!bs.isNullOrNil(((bf)localObject3).yVe))
        {
          localObject1 = ((bf)localObject3).yVf;
          localObject4 = ((bf)localObject3).yVe;
          Object localObject5 = this.mActivity;
          paramBaseViewHolder.zdv.getTextSize();
          localObject5 = new com.tencent.mm.pluginsdk.ui.span.l(com.tencent.mm.pluginsdk.ui.span.k.c((Context)localObject5, (CharSequence)localObject4, 1));
          ((com.tencent.mm.pluginsdk.ui.span.l)localObject5).a(null, (CharSequence)localObject4);
          localObject4 = paramBaseViewHolder.zdv.getPaint();
          float f = Layout.getDesiredWidth((CharSequence)localObject5, 0, ((com.tencent.mm.pluginsdk.ui.span.l)localObject5).length(), (TextPaint)localObject4);
          if (com.tencent.mm.cc.a.ax(this.mActivity, (int)f) > paramBaseViewHolder.yJH)
          {
            do
            {
              if (((String)localObject1).length() <= 1) {
                break;
              }
              localObject1 = ((String)localObject1).substring(0, ((String)localObject1).length() - 2);
              localObject5 = String.format(((com.tencent.mm.plugin.sns.storage.a)localObject2).yeJ, new Object[] { (String)localObject1 + "..." });
              Object localObject6 = this.mActivity;
              paramBaseViewHolder.zdv.getTextSize();
              localObject6 = new com.tencent.mm.pluginsdk.ui.span.l(com.tencent.mm.pluginsdk.ui.span.k.c((Context)localObject6, (CharSequence)localObject5, 1));
              ((com.tencent.mm.pluginsdk.ui.span.l)localObject6).a(null, (CharSequence)localObject5);
              f = Layout.getDesiredWidth((CharSequence)localObject6, 0, ((com.tencent.mm.pluginsdk.ui.span.l)localObject6).length(), (TextPaint)localObject4);
              paramInt1 = com.tencent.mm.cc.a.ax(this.mActivity, (int)f);
              paramBaseViewHolder.zdv.setText((CharSequence)localObject6, TextView.BufferType.SPANNABLE);
              paramBaseViewHolder.zdv.setVisibility(0);
            } while (paramInt1 > paramBaseViewHolder.yJH);
            break label1044;
          }
          paramBaseViewHolder.zdv.setText((CharSequence)localObject5, TextView.BufferType.SPANNABLE);
          paramBaseViewHolder.zdv.setVisibility(0);
          break label1044;
        }
        paramBaseViewHolder.zdv.setVisibility(8);
        break label1044;
        label3671:
        paramBaseViewHolder.zdw.setVisibility(8);
        break label1183;
        label3683:
        BaseViewHolder.h(paramBaseViewHolder).setVisibility(8);
        break label1236;
        label3695:
        paramInt1 = this.mActivity.getResources().getColor(2131100212);
        break label1319;
        label3712:
        paramBaseViewHolder.yQm.setBackground(this.mActivity.getResources().getDrawable(2131233299));
        break label1353;
        label3735:
        paramBaseViewHolder.yQm.setVisibility(8);
        break label1353;
        label3747:
        paramBaseViewHolder.zdu.setVisibility(8);
        break label1399;
        label3759:
        if (((bf)localObject3).yVp)
        {
          paramBaseViewHolder.ijD.setVisibility(0);
          paramTimeLineObject = new SpannableString(((bf)localObject3).yVs);
          paramTimeLineObject.setSpan(new c(), 0, paramTimeLineObject.length(), 33);
          paramBaseViewHolder.ijD.setText(paramTimeLineObject, TextView.BufferType.SPANNABLE);
          paramBaseViewHolder.ijD.setTag(new bi(((bf)localObject3).yVr, ((bf)localObject3).yVs));
          break label1617;
        }
        if (((bf)localObject3).yVt)
        {
          paramBaseViewHolder.ijD.setVisibility(0);
          localObject1 = this.mActivity.getString(2131755318);
          localObject2 = (String)localObject1 + ((bf)localObject3).mAppName;
          localObject4 = new SpannableString((CharSequence)localObject2);
          ((SpannableString)localObject4).setSpan(new ForegroundColorSpan(this.mActivity.getResources().getColor(2131100943)), 0, ((String)localObject1).length(), 33);
          ((SpannableString)localObject4).setSpan(new a(), ((String)localObject1).length(), ((String)localObject2).length(), 33);
          paramBaseViewHolder.ijD.setText((CharSequence)localObject4, TextView.BufferType.SPANNABLE);
          if ((!((bf)localObject3).yVq) && (!"wx7fa037cc7dfabad5".equals(paramTimeLineObject.FQn.Id)))
          {
            paramBaseViewHolder.ijD.setTextColor(this.mActivity.getResources().getColor(2131100943));
            paramBaseViewHolder.ijD.setOnTouchListener(null);
          }
          paramBaseViewHolder.ijD.setTag(paramTimeLineObject);
          break label1617;
        }
        paramBaseViewHolder.ijD.setVisibility(8);
        break label1617;
        label4060:
        paramBaseViewHolder.yzU.setVisibility(8);
        break label1645;
        paramBaseViewHolder.yoJ.setText(2131763943);
        paramBaseViewHolder.zdE.setClickable(false);
        paramBaseViewHolder.zdE.setEnabled(false);
        break label1818;
        paramBaseViewHolder.yoJ.setText(2131763945);
        paramBaseViewHolder.zdE.setClickable(false);
        paramBaseViewHolder.zdE.setEnabled(false);
        break label1818;
        paramBaseViewHolder.yoJ.setText(2131763944);
        paramBaseViewHolder.zdE.setClickable(true);
        paramBaseViewHolder.zdE.setEnabled(true);
        break label1818;
        label4159:
        if (!paramBaseViewHolder.zdO) {
          break label1852;
        }
        paramBaseViewHolder.zdK.setVisibility(8);
        break label1852;
        paramBaseViewHolder.zdx.setVisibility(8);
        break label1880;
        label4190:
        paramTimeLineObject = String.format(this.mActivity.getString(2131764039), new Object[] { ((bf)localObject3).yVz });
        break label1941;
        label4220:
        if (((bf)localObject3).yVA)
        {
          paramBaseViewHolder.zdt.setVisibility(0);
          paramTimeLineObject = this.mActivity.getString(2131764040);
          paramTimeLineObject = com.tencent.mm.pluginsdk.ui.span.k.b(this.mActivity, paramTimeLineObject.toString(), paramBaseViewHolder.zdt.getTextSize());
          paramBaseViewHolder.zdt.setText(paramTimeLineObject);
          break label1968;
        }
        label4281:
        paramBaseViewHolder.zdt.setVisibility(8);
        break label1968;
        label4293:
        if (paramBaseViewHolder.zei == null) {
          break label2139;
        }
        paramBaseViewHolder.zei.setVisibility(8);
        break label2139;
        label4312:
        if (!paramBaseViewHolder.zdJ) {
          break label2193;
        }
        paramBaseViewHolder.zdI.setVisibility(8);
        break label2193;
        label4331:
        if (!paramBaseViewHolder.zdJ)
        {
          if ((paramBaseViewHolder.ywY != null) || (paramBaseViewHolder.zdI.getParent() == null)) {
            break label4675;
          }
          paramBaseViewHolder.ywY = ((LinearLayout)paramBaseViewHolder.zdI.inflate());
          if (paramBaseViewHolder.ywY != null)
          {
            paramBaseViewHolder.zdA = ((SnsLikesTextView)paramBaseViewHolder.ywY.findViewById(2131296588));
            paramBaseViewHolder.zdA.setLikedTextTouchListener(new ad());
            paramBaseViewHolder.zdA.setOpClickListener(parambe.ySt);
            paramBaseViewHolder.zdC = ((LinearLayout)paramBaseViewHolder.sSS.findViewById(2131296557));
            paramBaseViewHolder.ywY.setTag(((bf)localObject3).yUR);
            paramBaseViewHolder.zdA.setLikeTvTag(((bf)localObject3).yUR);
            paramBaseViewHolder.zdA.setOpTvTag(paramBaseViewHolder);
            paramBaseViewHolder.zdH = paramBaseViewHolder.ywY.findViewById(2131296592);
            paramBaseViewHolder.zek = paramBaseViewHolder.ywY.findViewById(2131296590);
            paramBaseViewHolder.zdJ = true;
          }
        }
        if (paramBaseViewHolder.ywY != null) {
          paramBaseViewHolder.ywY.setVisibility(0);
        }
        if ((((bf)localObject3).yVF != null) && (((bf)localObject3).yVF.size() > 0))
        {
          paramBaseViewHolder.zdA.setVisibility(0);
          parambe.a(((bf)localObject3).yzm, paramBaseViewHolder.zdA);
          paramBaseViewHolder.zdA.a(((bf)localObject3).yVF, paramInt2, parambe, ((bf)localObject3).yzm, parambe.yNN, parambe.yNO, parambe.ySh, (bf)localObject3, paramBaseViewHolder);
          paramBaseViewHolder.zdB = true;
          label4602:
          if (((bf)localObject3).yVG == null) {
            break label4731;
          }
          a(localSnsObject.CommentUserList, ((bf)localObject3).yVG, paramBaseViewHolder);
        }
        for (;;)
        {
          if ((((bf)localObject3).yVF == null) || (((bf)localObject3).yVF.size() == 0) || (((bf)localObject3).yVG == null) || (((bf)localObject3).yVG.size() == 0)) {
            break label4743;
          }
          paramBaseViewHolder.zdH.setVisibility(0);
          break;
          label4675:
          if (paramBaseViewHolder.ywY == null) {}
          for (bool = true;; bool = false)
          {
            ac.e("MicroMsg.BaseTimeLineItem", "holder.listKeeper = null %s,and holder.commentStub.inflated", new Object[] { Boolean.valueOf(bool) });
            break;
          }
          paramBaseViewHolder.zdA.setVisibility(8);
          paramBaseViewHolder.zdB = false;
          break label4602;
          label4731:
          paramBaseViewHolder.zdC.setVisibility(8);
        }
        label4743:
        paramBaseViewHolder.zdH.setVisibility(8);
        break label2193;
        label4755:
        paramBaseViewHolder.zdo.setVisibility(8);
        break label2233;
        label4767:
        paramInt1 = 0;
        break label2369;
        label4772:
        if (i != 0)
        {
          paramBaseViewHolder.xMy.setVisibility(8);
          paramBaseViewHolder.zds.setTag(new com.tencent.mm.plugin.sns.data.e(paramBaseViewHolder.zds, paramp.dMu()));
          paramBaseViewHolder.zds.setVisibility(0);
          break label2431;
        }
        paramBaseViewHolder.xMy.setVisibility(8);
        paramBaseViewHolder.zds.setVisibility(8);
        break label2431;
        label4840:
        paramInt1 = 0;
        break label2576;
        label4845:
        paramInt1 = 0;
        break label2593;
        label4850:
        if (paramBaseViewHolder.zeo)
        {
          paramBaseViewHolder.zep.setVisibility(8);
          paramBaseViewHolder.zer.setTag(Long.valueOf(paramp.field_snsId));
        }
        paramBaseViewHolder.isN.setBackgroundResource(2131232867);
        break label2705;
        label4893:
        if (paramBaseViewHolder.zes) {
          paramBaseViewHolder.zet.setVisibility(8);
        }
        paramBaseViewHolder.isN.setBackgroundResource(2131232867);
      }
      label4922:
      paramBaseViewHolder = new com.tencent.mm.ui.a.b();
      paramBaseViewHolder.aPF(parambe.getText().toString());
      paramBaseViewHolder.aPF((String)localObject1);
      if (localObject2 != null) {
        paramBaseViewHolder.aPF(((TextView)localObject2).getText().toString());
      }
      if (bool) {
        paramBaseViewHolder.aPF(paramp.GX.getString(2131757941));
      }
      paramBaseViewHolder.fO(paramTimeLineObject);
      return;
      i = 0;
      break label605;
      i = 0;
    }
  }
  
  public abstract void a(BaseViewHolder paramBaseViewHolder, int paramInt1, bf parambf, TimeLineObject paramTimeLineObject, int paramInt2, be parambe);
  
  public abstract void e(BaseViewHolder paramBaseViewHolder);
  
  public final void setIsFromMainTimeline(boolean paramBoolean)
  {
    this.yIK = paramBoolean;
  }
  
  public static class BaseViewHolder
  {
    public String ddB;
    public String dnn;
    public volatile boolean fYC;
    public TextView ijD;
    public boolean isAd;
    public ViewGroup isN;
    public int oeH;
    public int position;
    public View sSS;
    public SnsObject snsobj;
    public boolean tdc;
    public TimeLineObject timeLineObject;
    public TextView timeTv;
    public TextView titleTv;
    public bk xMy;
    public TextView xPm;
    public int yJH;
    public TextView yQm;
    public View yQs;
    public TextView yoJ;
    public bua yvD;
    public LinearLayout ywY;
    public com.tencent.mm.n.b yxE;
    public ImageView yxG;
    public TextView yzU;
    public an zbE;
    public SnsLikesTextView zdA;
    public boolean zdB;
    public LinearLayout zdC;
    public LinearLayout zdD;
    public View zdE;
    public LinearLayout zdF;
    public PhotosContent zdG;
    public View zdH;
    public ViewStub zdI;
    public boolean zdJ;
    public ViewStub zdK;
    public ViewStub zdL;
    public View zdM;
    public boolean zdN;
    public boolean zdO;
    public ViewStub zdP;
    public boolean zdQ;
    public View zdR;
    public LinearLayout zdS;
    public TextView zdT;
    public ViewStub zdU;
    public boolean zdV;
    public View zdW;
    public LinearLayout zdX;
    public ViewStub zdY;
    public boolean zdZ;
    public long zdd;
    public int zde;
    public SnsAvatarImageView zdf;
    public AsyncTextView zdg;
    public ImageView zdh;
    public ViewGroup zdi;
    public AsyncNormalTextView zdj;
    public SnsTranslateResultView zdk;
    public LinearLayout zdl;
    public ViewStub zdm;
    public boolean zdn;
    public TextView zdo;
    public TagImageView zdp;
    public TextView zdq;
    public int zdr;
    public RelativeLayout zds;
    public TextView zdt;
    public WeImageView zdu;
    public AsyncTextView zdv;
    public AsyncTextView zdw;
    public View zdx;
    public ImageView zdy;
    public View zdz;
    public View zea;
    public ImageView zeb;
    public boolean zec;
    ViewStub zed;
    boolean zee;
    public View zef;
    public BaseTimeLineItem zeg;
    public ViewStub zeh;
    public View zei;
    public MaskTextView zej;
    public View zek;
    private TextView zel;
    public String zem;
    public View zen;
    public boolean zeo;
    public ViewStub zep;
    public LinearLayout zeq;
    public ViewGroup zer;
    public boolean zes;
    public ViewStub zet;
    public LinearLayout zeu;
    public TextView zev;
    
    public BaseViewHolder()
    {
      AppMethodBeat.i(100055);
      this.zdn = false;
      this.zdr = 0;
      this.yJH = 210;
      this.zdB = false;
      this.zdJ = false;
      this.zdM = null;
      this.zdN = false;
      this.zdO = false;
      this.zdQ = false;
      this.zdV = false;
      this.zdZ = false;
      this.zec = false;
      this.zee = false;
      this.zbE = new an();
      this.zeo = false;
      this.zes = false;
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
      BaseTimeLineItem.this.xZJ.yJC.yYx.onClick(paramView);
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
      BaseTimeLineItem.this.xZJ.yJC.yYm.onClick(paramView);
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
      BaseTimeLineItem.this.xZJ.yJC.yYn.onClick(paramView);
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
    public CharSequence gln;
    public String md5;
    private WeakReference<View> view;
    public int yKW;
    public com.tencent.mm.plugin.sns.ui.l ySm;
    public CharSequence zew;
    public int zex;
    
    public d(String paramString, CharSequence paramCharSequence1, CharSequence paramCharSequence2, View paramView, int paramInt, com.tencent.mm.plugin.sns.ui.l paraml)
    {
      AppMethodBeat.i(200656);
      this.view = null;
      this.md5 = null;
      this.zew = null;
      this.gln = null;
      this.yKW = 0;
      this.zex = ao.fromDPToPix(com.tencent.mm.sdk.platformtools.ai.getContext(), 28);
      this.ySm = null;
      this.view = new WeakReference(paramView);
      this.md5 = paramString;
      this.zew = paramCharSequence1;
      this.gln = paramCharSequence2;
      this.yKW = paramInt;
      this.ySm = paraml;
      AppMethodBeat.o(200656);
    }
    
    public final void f(Bitmap paramBitmap, String paramString)
    {
      AppMethodBeat.i(100059);
      ac.i("MicroMsg.BaseTimeLineItem", "onEmojiDecodeFin bitmapAvailable:%s, md5:%s", new Object[] { Boolean.valueOf(q.I(paramBitmap)), paramString });
      if ((this.view != null) && (this.view.get() != null) && ((this.view.get() instanceof SnsCommentCollapseLayout)))
      {
        SnsCommentCollapseLayout localSnsCommentCollapseLayout = (SnsCommentCollapseLayout)this.view.get();
        if ((localSnsCommentCollapseLayout != null) && (localSnsCommentCollapseLayout.getTag() != null) && ((localSnsCommentCollapseLayout.getTag() instanceof com.tencent.mm.plugin.sns.ui.m)))
        {
          Object localObject = (com.tencent.mm.plugin.sns.ui.m)localSnsCommentCollapseLayout.getTag();
          if ((((com.tencent.mm.plugin.sns.ui.m)localObject).xRC != null) && (!bs.gY(((com.tencent.mm.plugin.sns.ui.m)localObject).xRC.FJe)) && (((com.tencent.mm.plugin.sns.ui.m)localObject).xRC.FJe.get(0) != null) && (bs.lr(paramString, ((dag)((com.tencent.mm.plugin.sns.ui.m)localObject).xRC.FJe.get(0)).Md5)) && (q.I(paramBitmap)))
          {
            paramBitmap = new BitmapDrawable(paramBitmap);
            paramBitmap.setBounds(0, 0, this.zex, this.zex);
            paramBitmap = new com.tencent.mm.ui.widget.a(paramBitmap);
            com.tencent.mm.sdk.platformtools.ai.getContext();
            paramString = new com.tencent.mm.pluginsdk.ui.span.p(this.md5, this.ySm, 2);
            localObject = new SpannableStringBuilder(this.zew);
            ((SpannableStringBuilder)localObject).append("  ").append(this.md5).append("  ").append(" ");
            int i = ((SpannableStringBuilder)localObject).length() - this.md5.length() - 2 - 1;
            int j = ((SpannableStringBuilder)localObject).length() - this.md5.length() - 4 - 1;
            ((SpannableStringBuilder)localObject).setSpan(paramBitmap, i, this.md5.length() + i, 33);
            ((SpannableStringBuilder)localObject).setSpan(paramString, j, j + 4 + this.md5.length(), 33);
            SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(this.gln);
            localSpannableStringBuilder.append("  ").append(this.md5).append("  ").append(" ");
            i = localSpannableStringBuilder.length() - this.md5.length() - 2 - 1;
            j = localSpannableStringBuilder.length() - this.md5.length() - 4 - 1;
            localSpannableStringBuilder.setSpan(paramBitmap, i, this.md5.length() + i, 33);
            localSpannableStringBuilder.setSpan(paramString, j, j + 4 + this.md5.length(), 33);
            localSnsCommentCollapseLayout.a((CharSequence)localObject, localSpannableStringBuilder, this.yKW);
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