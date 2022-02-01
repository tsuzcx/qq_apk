package com.tencent.mm.plugin.sns.ui.item;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
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
import com.tencent.mm.g.b.a.cm;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.model.ap.b;
import com.tencent.mm.plugin.sns.model.ar;
import com.tencent.mm.plugin.sns.model.ax;
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
import com.tencent.mm.plugin.sns.ui.an;
import com.tencent.mm.plugin.sns.ui.ba;
import com.tencent.mm.plugin.sns.ui.be;
import com.tencent.mm.plugin.sns.ui.be.c;
import com.tencent.mm.plugin.sns.ui.bf;
import com.tencent.mm.plugin.sns.ui.bi;
import com.tencent.mm.plugin.sns.ui.bk;
import com.tencent.mm.plugin.sns.ui.bl;
import com.tencent.mm.plugin.sns.ui.m;
import com.tencent.mm.plugin.sns.ui.widget.SnsAvatarImageView;
import com.tencent.mm.plugin.sns.ui.widget.SnsCommentCollapseLayout;
import com.tencent.mm.plugin.sns.ui.y;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.n;
import com.tencent.mm.pluginsdk.ui.span.p.a;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bpj;
import com.tencent.mm.protocal.protobuf.cuo;
import com.tencent.mm.protocal.protobuf.cuu;
import com.tencent.mm.protocal.protobuf.eh;
import com.tencent.mm.protocal.protobuf.yk;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
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
  protected int nBH;
  protected be wNd;
  public ArrayList<ap.b> xQk = new ArrayList();
  protected boolean xvU = false;
  
  private static void a(View paramView, CharSequence paramCharSequence, int paramInt)
  {
    if ((paramView instanceof SnsCommentCollapseLayout)) {
      ((SnsCommentCollapseLayout)paramView).l(paramCharSequence, paramInt);
    }
    while (!(paramView instanceof TextView)) {
      return;
    }
    ((TextView)paramView).setText(paramCharSequence);
  }
  
  public static void a(ap.b paramb, BaseViewHolder paramBaseViewHolder, String paramString1, String paramString2)
  {
    if ((paramBaseViewHolder != null) && (paramBaseViewHolder.xQu != null))
    {
      paramBaseViewHolder.xQu.a(paramb, 1, paramString1, paramString2, paramb.wJl);
      paramBaseViewHolder.xQu.setVisibility(0);
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
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.BaseTimeLineItem", "setReward error  e:%s", new Object[] { bt.m(paramMaskTextView) });
      return;
    }
    ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
    com.tencent.mm.ui.widget.a locala = new com.tencent.mm.ui.widget.a((Drawable)localObject);
    locala.HyD = ((int)((((Drawable)localObject).getIntrinsicHeight() - paramMaskTextView.getTextSize() + com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 2)) / 2.0F));
    localSpannableStringBuilder.setSpan(locala, k, k + 1, 33);
    if (paramInt == 10)
    {
      paramInt = 3;
      break label403;
      while (i < arrayOfInt1.length)
      {
        localSpannableStringBuilder.setSpan(new com.tencent.mm.pluginsdk.ui.span.p((String)((com.tencent.mm.vending.j.a)paramb.get(i)).get(0), this.wNd.xwI, paramInt), arrayOfInt1[i], arrayOfInt2[i], 33);
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
      if (paramTimeLineObject.Etl == null) {}
      for (String str = null; !bt.isNullOrNil(str); str = paramTimeLineObject.Etl.Id)
      {
        com.tencent.mm.plugin.sns.d.a.hYu.a(str, paramTimeLineObject.mAQ, paramTimeLineObject.Etm.DaB, paramTimeLineObject.Etq, parambf.xIc);
        return;
      }
    }
  }
  
  private static void a(BaseViewHolder paramBaseViewHolder, com.tencent.mm.plugin.sns.storage.p paramp)
  {
    if (paramp.Nb(32))
    {
      if (paramBaseViewHolder.xQt != null) {
        paramBaseViewHolder.xQt.setVisibility(0);
      }
      paramBaseViewHolder.xQv.setLongClickable(false);
      paramBaseViewHolder.xQv.setOnClickListener(null);
      paramp = new LinearLayout.LayoutParams(-1, -2);
      paramBaseViewHolder.xQv.setLayoutParams(paramp);
      paramBaseViewHolder.xQv.setBackgroundColor(Color.parseColor("#00ffffff"));
      if (paramBaseViewHolder.xQQ != null)
      {
        paramp = (LinearLayout.LayoutParams)paramBaseViewHolder.xQQ.getLayoutParams();
        paramp.leftMargin = 0;
        paramp.rightMargin = 0;
        paramBaseViewHolder.xQQ.setLayoutParams(paramp);
      }
      if (paramBaseViewHolder.xRo)
      {
        paramp = (LinearLayout.LayoutParams)paramBaseViewHolder.xOO.xsm.getLayoutParams();
        paramp.leftMargin = 0;
        paramp.rightMargin = 0;
        paramBaseViewHolder.xOO.xsm.setLayoutParams(paramp);
      }
      return;
    }
    if (paramBaseViewHolder.xQt != null) {
      paramBaseViewHolder.xQt.setVisibility(0);
    }
    paramBaseViewHolder.xQv.setLongClickable(false);
    paramBaseViewHolder.xQv.setOnClickListener(null);
    if (paramBaseViewHolder.xQQ != null)
    {
      paramp = (LinearLayout.LayoutParams)paramBaseViewHolder.xQQ.getLayoutParams();
      paramp.leftMargin = 0;
      paramp.rightMargin = 0;
      paramBaseViewHolder.xQQ.setLayoutParams(paramp);
    }
    if (paramBaseViewHolder.xRo)
    {
      paramp = (LinearLayout.LayoutParams)paramBaseViewHolder.xOO.xsm.getLayoutParams();
      paramp.leftMargin = 0;
      paramp.rightMargin = 0;
      paramBaseViewHolder.xOO.xsm.setLayoutParams(paramp);
    }
    paramp = new LinearLayout.LayoutParams(-1, -2);
    paramBaseViewHolder.xQv.setLayoutParams(paramp);
    paramBaseViewHolder.xQv.setBackgroundColor(Color.parseColor("#00ffffff"));
  }
  
  private boolean a(List<cuo> paramList, com.tencent.mm.vending.d.b<com.tencent.mm.vending.j.a> paramb, BaseViewHolder paramBaseViewHolder)
  {
    LinearLayout localLinearLayout = paramBaseViewHolder.xQM;
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
          this.wNd.a((SnsCommentCollapseLayout)localObject1);
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
    Object localObject1 = this.wNd.dBY();
    if ((localObject1 instanceof com.tencent.mm.plugin.sns.ui.a.c)) {}
    for (bf localbf = (bf)((com.tencent.mm.plugin.sns.ui.a.c)localObject1).xMy.get(paramBaseViewHolder.position);; localbf = null)
    {
      if (this.DEBUG) {
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.BaseTimeLineItem", "debug:setCommentList position " + paramBaseViewHolder.position + " commentCount: " + j);
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
      Object localObject3;
      Object localObject5;
      if (m < paramb.size())
      {
        localObject1 = (com.tencent.mm.vending.j.a)paramb.get(m);
        l = ((Long)((com.tencent.mm.vending.j.a)localObject1).get(0)).longValue();
        str1 = (String)((com.tencent.mm.vending.j.a)localObject1).get(1);
        str2 = (String)((com.tencent.mm.vending.j.a)localObject1).get(2);
        str3 = (String)((com.tencent.mm.vending.j.a)localObject1).get(3);
        localObject3 = (CharSequence)((com.tencent.mm.vending.j.a)localObject1).get(4);
        localObject5 = (String)((com.tencent.mm.vending.j.a)localObject1).get(5);
        if (bt.isNullOrNil((String)localObject5)) {
          break label1985;
        }
        j = 1;
        localStringBuilder2.append(l).append("|");
      }
      for (;;)
      {
        localStringBuilder1.append(l).append("|");
        cuo localcuo = (cuo)paramList.get(m);
        i = localcuo.Eme;
        Object localObject4 = bj(paramBaseViewHolder.dpC, l);
        if ((localObject4 != null) && (((ap.b)localObject4).aEj)) {
          ap.eu(((ap.b)localObject4).id, 2);
        }
        label498:
        int n;
        Object localObject2;
        if (k >= i1) {
          if ((localObject4 == null) || (((ap.b)localObject4).aEj))
          {
            localObject1 = this.wNd.dBU();
            ((SnsCommentCollapseLayout)localObject1).setTextSize$255e752(15.0F * com.tencent.mm.cd.a.dT(((View)localObject1).getContext()));
            if (this.wNd.xFv == -1) {
              this.wNd.xFv = this.mActivity.getResources().getColor(2131100907);
            }
            ((SnsCommentCollapseLayout)localObject1).setTextColor(this.wNd.xFv);
            ((SnsCommentCollapseLayout)localObject1).setGravity(16);
            n = 1;
            localObject2 = localObject1;
          }
        }
        label735:
        Object localObject6;
        String str4;
        for (;;)
        {
          if (localObject4 != null)
          {
            localObject1 = localObject2;
            if (!(localObject2 instanceof TranslateCommentTextView))
            {
              localLinearLayout.removeView((View)localObject2);
              localObject1 = new TranslateCommentTextView(this.mActivity);
              localLinearLayout.addView((View)localObject1, k);
              ((TranslateCommentTextView)localObject1).getTranslateResultView().setResultTextSize$255e752(15.0F * com.tencent.mm.cd.a.dT(((View)localObject1).getContext()));
              ((TranslateCommentTextView)localObject1).getOriginCommentTextView().setTextSize(1, 15.0F * com.tencent.mm.cd.a.dT(((View)localObject1).getContext()));
            }
            localObject5 = (TranslateCommentTextView)localObject1;
            ((View)localObject1).setOnTouchListener(null);
            a(((TranslateCommentTextView)localObject5).getOriginCommentTextView(), (CharSequence)localObject3, i);
            if (!((ap.b)localObject4).gPQ)
            {
              ((TranslateCommentTextView)localObject5).xMg.setTextSize(1, 15.0F * com.tencent.mm.cd.a.dT(((TranslateCommentTextView)localObject5).getContext()));
              ((TranslateCommentTextView)localObject5).xxZ.NG(2);
              ((TranslateCommentTextView)localObject5).xxZ.setVisibility(0);
              i = 1;
              if (k <= 0) {
                break label1722;
              }
              ((View)localObject1).setPadding(com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 8), com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 4), com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 0), com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 3));
              if (k != paramb.size() - 1) {
                break label1711;
              }
              ((View)localObject1).setBackgroundResource(2131234841);
              if (i != 0)
              {
                localObject2 = (TranslateCommentTextView)localObject1;
                i = (int)this.mActivity.getResources().getDimension(2131165568);
                ((TranslateCommentTextView)localObject2).xxZ.getSplitlineView().setPadding(0, 0, i, 0);
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
                    BaseTimeLineItem.this.wNd.dCa().a(this.xLQ, BaseTimeLineItem.this.wNd.wMy.xTG, BaseTimeLineItem.this.wNd.wMy.xTt, paramAnonymousView[0], paramAnonymousView[1]);
                    AppMethodBeat.o(100050);
                    return true;
                  }
                }
              });
              ((View)localObject1).setOnClickListener(new com.tencent.mm.plugin.sns.ui.i.a(this.wNd.xFq, localcuo, str2, str3, paramBaseViewHolder));
              if (localbf != null) {
                ((View)localObject1).setTag(new m(localbf.xmu, localbf.xIb, localcuo, str1, str3, (View)localObject1, 1));
              }
              if (n != 0) {
                localLinearLayout.addView((View)localObject1);
              }
              m += 1;
              i = j;
              k += 1;
              break;
              localObject1 = new TranslateCommentTextView(this.mActivity);
              ((TranslateCommentTextView)localObject1).getTranslateResultView().setResultTextSize$255e752(15.0F * com.tencent.mm.cd.a.dT(((View)localObject1).getContext()));
              ((TranslateCommentTextView)localObject1).getOriginCommentTextView().setTextSize(1, 15.0F * com.tencent.mm.cd.a.dT(((View)localObject1).getContext()));
              break label498;
              localObject2 = localLinearLayout.getChildAt(k);
              n = 0;
              continue;
            }
            if (!((ap.b)localObject4).aEj)
            {
              localObject6 = ((ap.b)localObject4).result;
              str4 = ((ap.b)localObject4).gXN;
              String str5 = ((TranslateCommentTextView)localObject5).xMg.getText().toString();
              if (!bt.isNullOrNil(str5))
              {
                localObject2 = str5.split(":");
                if (localObject2.length <= 2) {
                  break label1982;
                }
                localObject3 = new String[2];
                localObject3[0] = localObject2[0];
                localObject3[1] = str5.substring(localObject3[0].length() + 1);
                localObject2 = localObject3;
              }
            }
          }
        }
        label1160:
        label1711:
        label1722:
        label1982:
        for (;;)
        {
          if (localObject2.length == 2)
          {
            if (bt.isNullOrNil((String)localObject6)) {
              break label1160;
            }
            ((TranslateCommentTextView)localObject5).xxZ.a((ap.b)localObject4, 2, localObject2[0] + ": " + (String)localObject6, str4, ((ap.b)localObject4).wJl);
          }
          for (;;)
          {
            ((TranslateCommentTextView)localObject5).xxZ.setVisibility(0);
            ((TranslateCommentTextView)localObject5).xMg.setTextSize(1, 15.0F * com.tencent.mm.cd.a.dT(((TranslateCommentTextView)localObject5).getContext()));
            i = 1;
            break;
            ((TranslateCommentTextView)localObject5).xxZ.a((ap.b)localObject4, 2, null, str4, ((ap.b)localObject4).wJl);
          }
          ((TranslateCommentTextView)localObject5).getTranslateResultView().setVisibility(8);
          i = 1;
          break;
          if ((n == 0) && ((localObject2 instanceof TranslateCommentTextView)))
          {
            localLinearLayout.removeView((View)localObject2);
            localObject1 = this.wNd.dBU();
            localLinearLayout.addView((View)localObject1, k);
            ((SnsCommentCollapseLayout)localObject1).setTextSize$255e752(15.0F * com.tencent.mm.cd.a.dT(((View)localObject1).getContext()));
          }
          for (;;)
          {
            if ((localObject1 instanceof SnsCommentCollapseLayout))
            {
              ((SnsCommentCollapseLayout)localObject1).setTextSize$255e752(15.0F * com.tencent.mm.cd.a.dT(((View)localObject1).getContext()));
              ((SnsCommentCollapseLayout)localObject1).setOpClickListener(this.wNd.xFH);
              ((SnsCommentCollapseLayout)localObject1).setPressTouchListener(new n(this.mActivity));
            }
            localObject1.hashCode();
            localObject2 = localObject3;
            if (!bt.isNullOrNil((String)localObject5))
            {
              if (!(localObject1 instanceof SnsCommentCollapseLayout)) {
                localObject2 = localObject3;
              }
            }
            else
            {
              a((View)localObject1, (CharSequence)localObject2, i);
              i = 0;
              break;
            }
            localObject4 = new SpannableStringBuilder((CharSequence)localObject3);
            int i2 = ao.fromDPToPix(this.mActivity, 28);
            localObject2 = com.tencent.mm.plugin.sns.model.af.dtr();
            localObject3 = new d((String)localObject5, (CharSequence)localObject3, (View)localObject1, i, this.wNd.xFz);
            localObject6 = com.tencent.mm.emoji.loader.a.b.fLw;
            localObject6 = com.tencent.mm.emoji.loader.a.b.pT((String)localObject5);
            if (localObject6 == null) {
              com.tencent.mm.plugin.sns.model.af.dth().execute(new f.5((com.tencent.mm.plugin.sns.model.f)localObject2, (String)localObject5, (f.d)localObject3));
            }
            localObject3 = new StringBuilder((String)localObject5);
            if (localObject6 == null)
            {
              ((StringBuilder)localObject3).append("miss");
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BaseTimeLineItem", "wrapEmojiInfo:%s miss cache", new Object[] { ((StringBuilder)localObject3).toString() });
            }
            for (localObject2 = this.mActivity.getResources().getDrawable(2131234117);; localObject2 = new BitmapDrawable((Bitmap)localObject6))
            {
              ((SpannableStringBuilder)localObject4).append("  ").append(((StringBuilder)localObject3).toString()).append("  ").append(" ");
              int i3 = ((SpannableStringBuilder)localObject4).length() - ((StringBuilder)localObject3).toString().length() - 2 - 1;
              int i4 = ((SpannableStringBuilder)localObject4).length() - ((StringBuilder)localObject3).toString().length() - 4 - 1;
              ((Drawable)localObject2).setBounds(0, 0, i2, i2);
              localObject2 = new com.tencent.mm.ui.widget.a((Drawable)localObject2);
              localObject5 = new com.tencent.mm.pluginsdk.ui.span.p(((StringBuilder)localObject3).toString(), this.wNd.xFz, 2);
              ((SpannableStringBuilder)localObject4).setSpan(localObject2, i3, ((StringBuilder)localObject3).toString().length() + i3, 33);
              ((SpannableStringBuilder)localObject4).setSpan(localObject5, i4, i4 + 4 + ((StringBuilder)localObject3).toString().length(), 33);
              localObject2 = localObject4;
              break;
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BaseTimeLineItem", "wrapEmojiInfo:%s hit cache", new Object[] { ((StringBuilder)localObject3).toString() });
            }
            ((View)localObject1).setBackgroundResource(2131234100);
            break label735;
            ((View)localObject1).setPadding(com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 8), com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 6), com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 0), com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 3));
            if (paramBaseViewHolder.xQL)
            {
              if (paramb.size() == 1)
              {
                ((View)localObject1).setBackgroundResource(2131234841);
                break label735;
              }
              ((View)localObject1).setBackgroundResource(2131234100);
              break label735;
            }
            if (paramb.size() == 1)
            {
              ((View)localObject1).setBackgroundResource(2131234150);
              break label735;
            }
            ((View)localObject1).setBackgroundResource(2131234842);
            break label735;
            if (i != 0)
            {
              paramList = com.tencent.mm.plugin.sns.k.f.wQY;
              i = paramBaseViewHolder.position;
              l = localbf.wvM.field_snsId;
              paramb = localStringBuilder2.toString();
              localObject2 = localStringBuilder1.toString();
              paramBaseViewHolder = q.st(l);
              if (paramList.wRj.get(paramBaseViewHolder) == null)
              {
                localObject1 = new cm();
                ((cm)localObject1).dRy = ((cm)localObject1).t("PublishId", paramBaseViewHolder, true);
                ((cm)localObject1).dRz = ((cm)localObject1).t("CommentIdList", (String)localObject2, true);
                ((cm)localObject1).dRA = ((cm)localObject1).t("EmojiIdList", paramb, true);
                paramb = new com.tencent.mm.plugin.sns.k.f.a(paramList);
                paramb.position = i;
                paramb.wRI = ((cm)localObject1);
                paramList.wRj.put(paramBaseViewHolder, paramb);
              }
            }
            return true;
            localObject1 = localObject2;
          }
        }
        label1985:
        j = i;
      }
    }
  }
  
  private ap.b bj(String paramString, long paramLong)
  {
    if (this.xQk.size() <= 0) {
      return null;
    }
    Iterator localIterator = this.xQk.iterator();
    while (localIterator.hasNext())
    {
      ap.b localb = (ap.b)localIterator.next();
      if ((localb.id != null) && (localb.id.equals(ap.iG(paramString, String.valueOf(paramLong))))) {
        return localb;
      }
    }
    return null;
  }
  
  public static void f(BaseViewHolder paramBaseViewHolder)
  {
    if ((paramBaseViewHolder != null) && (paramBaseViewHolder.xQu != null))
    {
      paramBaseViewHolder.xQu.NG(1);
      paramBaseViewHolder.xQu.setVisibility(0);
    }
  }
  
  public static void g(BaseViewHolder paramBaseViewHolder)
  {
    if ((paramBaseViewHolder != null) && (paramBaseViewHolder.xQu != null)) {
      paramBaseViewHolder.xQu.setVisibility(8);
    }
  }
  
  public final View a(Activity paramActivity, BaseViewHolder paramBaseViewHolder, int paramInt, be parambe, com.tencent.mm.plugin.sns.storage.p paramp)
  {
    this.mActivity = paramActivity;
    this.nBH = paramInt;
    this.wNd = parambe;
    paramBaseViewHolder.dpC = paramp.getSnsId();
    Object localObject;
    View localView;
    switch (paramInt)
    {
    default: 
      localObject = "R.layout.sns_media_sub_item2";
      com.tencent.mm.kiss.a.b.agA();
      localView = com.tencent.mm.kiss.a.b.c(this.mActivity, 2131495612);
      paramBaseViewHolder.xRx = localView;
      paramBaseViewHolder.xRw = ((String)localObject);
      localObject = localView.findViewById(2131300969);
      if (!(localObject instanceof ViewStub)) {
        break;
      }
    }
    for (paramBaseViewHolder.xQw = ((ViewStub)localObject);; paramBaseViewHolder.xQw = null)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BaseTimeLineItem", "create new item  " + paramInt + "  " + localView.hashCode());
      paramBaseViewHolder.xRp = localView.findViewById(2131305085);
      paramBaseViewHolder.nBH = paramInt;
      paramBaseViewHolder.xQp = ((SnsAvatarImageView)localView.findViewById(2131296533));
      paramBaseViewHolder.xQp.setWeakContext(paramActivity);
      paramBaseViewHolder.xQp.setOnClickListener(parambe.wMy.xTu);
      paramBaseViewHolder.xQp.setOnLongClickListener(parambe.wMy.xTv);
      paramBaseViewHolder.xQp.setOnTouchListener(new View.OnTouchListener()
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
      paramBaseViewHolder.xQq = ((AsyncTextView)localView.findViewById(2131302867));
      paramBaseViewHolder.xQr = ((ImageView)localView.findViewById(2131306175));
      paramBaseViewHolder.xQq.setOnTouchListener(new com.tencent.mm.plugin.sns.ui.ad());
      paramBaseViewHolder.xQs = ((ViewGroup)localView.findViewById(2131302862));
      paramBaseViewHolder.xQt = ((AsyncNormalTextView)localView.findViewById(2131299001));
      paramBaseViewHolder.xQt.setOpClickListener(parambe.xFF);
      paramBaseViewHolder.xQv = ((LinearLayout)localView.findViewById(2131300970));
      paramBaseViewHolder.xQv.setTag(paramBaseViewHolder);
      paramBaseViewHolder.xQv.setOnClickListener(parambe.wMy.xUd);
      localObject = localView.findViewById(2131299008);
      parambe.dCa().c((View)localObject, parambe.wMy.xTw, parambe.wMy.xTt);
      localObject = (TextView)localView.findViewById(2131299009);
      parambe.dCa().c((View)localObject, parambe.wMy.xTw, parambe.wMy.xTt);
      paramBaseViewHolder.xQu = ((SnsTranslateResultView)localView.findViewById(2131305091));
      paramBaseViewHolder.xQu.setVisibility(8);
      paramBaseViewHolder.xQu.getSplitlineView().setPadding(0, 0, 0, 0);
      paramBaseViewHolder.xQu.getResultTextView().setBackgroundResource(2131234100);
      parambe.dCa().c(paramBaseViewHolder.xQu.getResultTextView(), parambe.wMy.xTw, parambe.wMy.xTt);
      paramBaseViewHolder.xQP = ((LinearLayout)localView.findViewById(2131298526));
      paramBaseViewHolder.xQD = ((TextView)localView.findViewById(2131306999));
      paramBaseViewHolder.timeTv = ((TextView)localView.findViewById(2131296598));
      paramBaseViewHolder.xQF = ((AsyncTextView)localView.findViewById(2131296528));
      paramBaseViewHolder.xQG = ((AsyncTextView)localView.findViewById(2131296527));
      paramBaseViewHolder.xDy = ((TextView)localView.findViewById(2131296531));
      paramBaseViewHolder.wAe = new bk(localView);
      paramBaseViewHolder.wAe.a(parambe.wMy.xTE, parambe.wMy.xTS);
      paramBaseViewHolder.xQC = ((RelativeLayout)localView.findViewById(2131303033));
      paramBaseViewHolder.xQC.setOnClickListener(parambe.wMy.xTV);
      paramBaseViewHolder.xnd = ((TextView)localView.findViewById(2131296566));
      paramBaseViewHolder.xnd.setText(paramActivity.getString(2131755707));
      paramBaseViewHolder.xnd.setOnClickListener(parambe.wMy.xTy);
      paramBaseViewHolder.xQF.setOnClickListener(parambe.wMy.xTT);
      paramBaseViewHolder.xQG.setOnClickListener(parambe.wMy.xTU);
      paramBaseViewHolder.xDy.setOnClickListener(parambe.wMy.xTP);
      paramBaseViewHolder.xQH = localView.findViewById(2131296570);
      paramBaseViewHolder.xQH.setOnClickListener(parambe.wMy.xTD);
      paramBaseViewHolder.xQE = ((WeImageView)localView.findViewById(2131296627));
      paramBaseViewHolder.hJd = ((TextView)localView.findViewById(2131296569));
      paramBaseViewHolder.xQI = ((ImageView)localView.findViewById(2131296599));
      paramBaseViewHolder.xQS = ((ViewStub)localView.findViewById(2131296561));
      paramBaseViewHolder.xkf = ((LinearLayout)localView.findViewById(2131296590));
      paramBaseViewHolder.xRr = ((ViewStub)localView.findViewById(2131296572));
      paramBaseViewHolder.xRz = ((ViewStub)localView.findViewById(2131305093));
      paramBaseViewHolder.hSI = ((ViewGroup)localView.findViewById(2131304988));
      paramBaseViewHolder.xQU = ((ViewStub)localView.findViewById(2131305041));
      paramBaseViewHolder.xQy = ((TextView)localView.findViewById(2131300513));
      paramBaseViewHolder.xQy.setOnClickListener(parambe.wMy.xTz);
      BaseViewHolder.a(paramBaseViewHolder, (TextView)localView.findViewById(2131300687));
      paramBaseViewHolder.rLd = localView;
      if (this.xvU)
      {
        com.tencent.mm.plugin.sns.abtest.c.b(localView, paramBaseViewHolder);
        com.tencent.mm.plugin.sns.abtest.a.a(localView, paramBaseViewHolder);
        com.tencent.mm.plugin.sns.model.af.dtl();
        com.tencent.mm.plugin.sns.i.c.c(localView, paramBaseViewHolder);
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
    paramp = paramp.dxy();
    bf localbf = (bf)this.wNd.dBY().dzd().get(Integer.valueOf(paramInt));
    a(paramBaseViewHolder, paramInt, localbf, paramp, paramBaseViewHolder.nBH, this.wNd);
    a(localbf, paramp);
  }
  
  public final void a(final BaseViewHolder paramBaseViewHolder, int paramInt1, com.tencent.mm.plugin.sns.storage.p paramp, TimeLineObject paramTimeLineObject, int paramInt2, final be parambe)
  {
    Object localObject3 = (bf)parambe.dBY().dzd().get(Integer.valueOf(paramInt1));
    a(paramBaseViewHolder, paramp);
    this.nBH = paramInt2;
    this.wNd = parambe;
    if (this.xvU) {
      com.tencent.mm.plugin.sns.ui.a.c.P(paramp);
    }
    com.tencent.mm.plugin.sns.ui.a.c.i(paramTimeLineObject);
    com.tencent.mm.plugin.sns.ui.a.c.h(paramTimeLineObject);
    if (paramp.Nb(32)) {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BaseTimeLineItem", "the ad sns id is " + q.su(paramp.field_snsId) + " for susan");
    }
    paramBaseViewHolder.xQn = ((bf)localObject3).xIc;
    paramBaseViewHolder.rVk = false;
    paramBaseViewHolder.position = paramInt1;
    paramBaseViewHolder.dpC = ((bf)localObject3).xIb;
    paramBaseViewHolder.dgg = ((bf)localObject3).xmu;
    paramBaseViewHolder.xQo = ((bf)localObject3).xIg;
    paramBaseViewHolder.xQI.setOnClickListener(parambe.xFE);
    paramBaseViewHolder.timeLineObject = paramTimeLineObject;
    SnsObject localSnsObject = ((bf)localObject3).wvL;
    paramBaseViewHolder.snsobj = localSnsObject;
    Object localObject1 = parambe.xFq.xkY.wIv;
    Object localObject2;
    if (paramp != null)
    {
      localObject2 = paramp.dxX();
      ((com.tencent.mm.plugin.sns.k.c)localObject1).wQw.add(localObject2);
      if (paramp.Nb(32)) {
        ((com.tencent.mm.plugin.sns.k.c)localObject1).wQB.add(localObject2);
      }
      ((com.tencent.mm.plugin.sns.k.c)localObject1).wQC.add(paramp.field_userName);
    }
    int i;
    label605:
    Object localObject4;
    switch (paramp.field_type)
    {
    default: 
      ((com.tencent.mm.plugin.sns.k.c)localObject1).wQH.add(localObject2);
      if (paramInt1 < ((com.tencent.mm.plugin.sns.k.c)localObject1).wQu)
      {
        ((com.tencent.mm.plugin.sns.k.c)localObject1).wQu = paramInt1;
        ((com.tencent.mm.plugin.sns.k.c)localObject1).wOZ = q.l(paramp);
      }
      if (paramInt1 > ((com.tencent.mm.plugin.sns.k.c)localObject1).wQv)
      {
        ((com.tencent.mm.plugin.sns.k.c)localObject1).wQv = paramInt1;
        ((com.tencent.mm.plugin.sns.k.c)localObject1).wPa = q.l(paramp);
      }
      ((com.tencent.mm.plugin.sns.k.c)localObject1).wPf = ((com.tencent.mm.plugin.sns.k.c)localObject1).wQx.size();
      ((com.tencent.mm.plugin.sns.k.c)localObject1).wPg = ((com.tencent.mm.plugin.sns.k.c)localObject1).wQy.size();
      ((com.tencent.mm.plugin.sns.k.c)localObject1).wPh = ((com.tencent.mm.plugin.sns.k.c)localObject1).wQz.size();
      ((com.tencent.mm.plugin.sns.k.c)localObject1).wPj = ((com.tencent.mm.plugin.sns.k.c)localObject1).wQA.size();
      ((com.tencent.mm.plugin.sns.k.c)localObject1).wPi = ((com.tencent.mm.plugin.sns.k.c)localObject1).wQB.size();
      ((com.tencent.mm.plugin.sns.k.c)localObject1).wPk = ((com.tencent.mm.plugin.sns.k.c)localObject1).wQF.size();
      ((com.tencent.mm.plugin.sns.k.c)localObject1).wPs = ((com.tencent.mm.plugin.sns.k.c)localObject1).wQG.size();
      ((com.tencent.mm.plugin.sns.k.c)localObject1).mUB = ((com.tencent.mm.plugin.sns.k.c)localObject1).wQC.size();
      ((com.tencent.mm.plugin.sns.k.c)localObject1).wPd = ((com.tencent.mm.plugin.sns.k.c)localObject1).wQD.size();
      ((com.tencent.mm.plugin.sns.k.c)localObject1).wPe = ((com.tencent.mm.plugin.sns.k.c)localObject1).wQE.size();
      ((com.tencent.mm.plugin.sns.k.c)localObject1).wPr = ((com.tencent.mm.plugin.sns.k.c)localObject1).wQH.size();
      ((com.tencent.mm.plugin.sns.k.c)localObject1).wON = ((com.tencent.mm.plugin.sns.k.c)localObject1).wQw.size();
      localObject2 = ((bf)localObject3).wxf;
      localObject1 = ((bf)localObject3).kGt;
      if (!bt.isNullOrNil((String)localObject1))
      {
        paramBaseViewHolder.xkM = ((bf)localObject3).xIa;
        paramBaseViewHolder.xQp.setTag(localObject1);
        if (paramBaseViewHolder.xkM != null) {
          if ((com.tencent.mm.storage.af.aHH((String)localObject1)) && ("3552365301".equals(paramBaseViewHolder.xkM.field_openImAppid)))
          {
            i = 1;
            if ((localObject2 == null) || (!((com.tencent.mm.plugin.sns.storage.b)localObject2).wTG)) {
              break label2961;
            }
            paramBaseViewHolder.xQp.setImageResource(2131231875);
            paramBaseViewHolder.xQp.eE((String)localObject1, 4);
            paramBaseViewHolder.xQp.setShowStoryHint(false);
            if (!bt.isNullOrNil(((com.tencent.mm.plugin.sns.storage.b)localObject2).wTI))
            {
              localObject4 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.iU("adId", ((com.tencent.mm.plugin.sns.storage.b)localObject2).wTI);
              paramBaseViewHolder.xQp.setTag(2131305044, ((com.tencent.mm.plugin.sns.storage.b)localObject2).wTI);
              if (!com.tencent.mm.vfs.i.eK((String)localObject4)) {
                break label2941;
              }
              localObject2 = com.tencent.mm.plugin.sns.a.b.l.wyR.getBitmap((String)localObject4);
              if (localObject2 != null) {
                paramBaseViewHolder.xQp.setImageBitmap((Bitmap)localObject2);
              }
            }
            label717:
            paramBaseViewHolder.xQq.a((String)localObject1, ((bf)localObject3).xIq, new p.a()
            {
              public final void b(View paramAnonymousView, Object paramAnonymousObject)
              {
                AppMethodBeat.i(100048);
                if (parambe.xwI != null)
                {
                  parambe.xwI.dep = 0;
                  parambe.xwI.b(paramAnonymousView, paramAnonymousObject);
                }
                AppMethodBeat.o(100048);
              }
            }, ((bf)localObject3).xkI, ((bf)localObject3).xmu, paramInt2, ((bf)localObject3).xkI);
            paramBaseViewHolder.xQp.glT = ((bf)localObject3).xmu;
          }
        }
      }
      break;
    }
    for (;;)
    {
      paramBaseViewHolder.xQr.setVisibility(8);
      label1044:
      label1941:
      if (((bf)localObject3).xkI)
      {
        paramBaseViewHolder.isAd = true;
        paramBaseViewHolder.rVk = ((bf)localObject3).xIh;
        label801:
        paramBaseViewHolder.xQt.a(((bf)localObject3).xId, parambe, ((bf)localObject3).xIe, (bf)localObject3);
        paramBaseViewHolder.xQt.setShow(paramBaseViewHolder);
        paramBaseViewHolder.hJd.setOnTouchListener(new com.tencent.mm.plugin.sns.ui.ad());
        a(paramBaseViewHolder, paramInt1, (bf)localObject3, paramTimeLineObject, paramInt2, parambe);
        a((bf)localObject3, paramTimeLineObject);
        parambe.xFs.put(Integer.valueOf(paramInt1), new WeakReference(paramBaseViewHolder.rLd));
        if (paramBaseViewHolder.rLd.getBackground() == null)
        {
          paramBaseViewHolder.rLd.setBackgroundResource(2131231818);
          paramInt1 = com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 12);
          int j = com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 8);
          paramBaseViewHolder.rLd.setPadding(paramInt1, paramInt1, paramInt1, j);
        }
        paramBaseViewHolder.timeTv.setText(((bf)localObject3).xIj);
        paramBaseViewHolder.xQF.setVisibility(8);
        paramBaseViewHolder.xQG.setVisibility(8);
        if (((bf)localObject3).xkI)
        {
          localObject2 = ((bf)localObject3).xIk;
          paramBaseViewHolder.xQF.setTag(((bf)localObject3).xmu);
          if (((bf)localObject3).xIk.wSc != com.tencent.mm.plugin.sns.storage.a.wRO) {
            break label3266;
          }
          if (bt.isNullOrNil(((bf)localObject3).xIn)) {
            break label3254;
          }
          paramBaseViewHolder.xQF.setText(((bf)localObject3).xIn);
          paramBaseViewHolder.xQF.setVisibility(0);
          if ((paramBaseViewHolder.xQF.getVisibility() != 8) && (bt.isNullOrNil(((com.tencent.mm.plugin.sns.storage.a)localObject2).wSe)))
          {
            paramBaseViewHolder.xQF.setTextColor(this.mActivity.getResources().getColor(2131100943));
            paramBaseViewHolder.xQF.setOnClickListener(null);
          }
          if ((paramp.dxy().Etm.DaD & 0x4) == 0) {
            break label3577;
          }
          paramBaseViewHolder.xQG.setTag(paramBaseViewHolder);
          paramBaseViewHolder.xQG.setVisibility(0);
          paramBaseViewHolder.xQG.setText(String.format("%s%s%s", new Object[] { this.mActivity.getResources().getString(2131763743), ((bf)localObject3).xIq, this.mActivity.getResources().getString(2131763744) }));
        }
        label1183:
        if (!((bf)localObject3).xIt) {
          break label3589;
        }
        localObject1 = parambe.imP.getString(2131760986, new Object[] { Integer.valueOf(((bf)localObject3).xIu) });
        BaseViewHolder.h(paramBaseViewHolder).setText((CharSequence)localObject1);
        BaseViewHolder.h(paramBaseViewHolder).setVisibility(0);
        label1236:
        paramBaseViewHolder.xDy.setTag(((bf)localObject3).xmu);
        if (bt.isNullOrNil(((bf)localObject3).xIw)) {
          break label3641;
        }
        paramBaseViewHolder.xDy.setVisibility(0);
        paramBaseViewHolder.xDy.setText(((bf)localObject3).xIw);
        paramBaseViewHolder.xDy.setClickable(((bf)localObject3).xIx);
        localObject1 = paramBaseViewHolder.xDy;
        if (!((bf)localObject3).xIx) {
          break label3601;
        }
        paramInt1 = this.mActivity.getResources().getColor(2131100914);
        label1319:
        ((TextView)localObject1).setTextColor(paramInt1);
        if (!((bf)localObject3).xIx) {
          break label3618;
        }
        paramBaseViewHolder.xDy.setBackground(this.mActivity.getResources().getDrawable(2131234100));
        label1353:
        if (!((bf)localObject3).xIE) {
          break label3653;
        }
        paramBaseViewHolder.xQE.setVisibility(0);
        paramBaseViewHolder.xQE.setImageResource(2131690597);
        paramBaseViewHolder.xQE.setIconColor(this.mActivity.getResources().getColor(2131099660));
        label1399:
        paramBaseViewHolder.hJd.setTextColor(this.mActivity.getResources().getColor(2131100914));
        if (!((bf)localObject3).xIy) {
          break label3665;
        }
        paramBaseViewHolder.hJd.setVisibility(0);
        localObject2 = this.mActivity.getString(2131763791) + ((bf)localObject3).mAppName;
        localObject1 = localObject2;
        if (((String)localObject2).length() > 10) {
          localObject1 = ((String)localObject2).substring(0, 10) + "...";
        }
        localObject1 = new SpannableString((CharSequence)localObject1);
        ((SpannableString)localObject1).setSpan(new b(), 0, ((SpannableString)localObject1).length(), 33);
        paramBaseViewHolder.hJd.setText((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
        if ((!((bf)localObject3).xIA) && (!"wx7fa037cc7dfabad5".equals(paramTimeLineObject.Etl.Id)))
        {
          paramBaseViewHolder.hJd.setTextColor(this.mActivity.getResources().getColor(2131100943));
          paramBaseViewHolder.hJd.setOnTouchListener(null);
        }
        paramBaseViewHolder.hJd.setTag(paramTimeLineObject);
        label1617:
        if (!((bf)localObject3).xIs) {
          break label3966;
        }
        paramBaseViewHolder.xnd.setVisibility(0);
        paramBaseViewHolder.xnd.setTag(((bf)localObject3).xmu);
        label1645:
        paramBaseViewHolder.xQI.setTag(paramBaseViewHolder);
        if (!((bf)localObject3).xIF) {
          break label4065;
        }
        if (!paramBaseViewHolder.xQY)
        {
          paramBaseViewHolder.xQN = ((LinearLayout)paramBaseViewHolder.xQU.inflate());
          paramBaseViewHolder.xQO = paramBaseViewHolder.rLd.findViewById(2131303358);
          paramBaseViewHolder.xQY = true;
          paramBaseViewHolder.xQO.setTag(((bf)localObject3).xmu);
          paramBaseViewHolder.xbU = ((TextView)paramBaseViewHolder.xQN.findViewById(2131303358));
        }
        paramBaseViewHolder.xQU.setVisibility(0);
        paramBaseViewHolder.xQO.setOnClickListener(parambe.wMy.xTC);
        label1818:
        label2593:
        switch (((bf)localObject3).xIG)
        {
        default: 
          paramBaseViewHolder.xbU.setText(2131763946);
          paramBaseViewHolder.xQO.setClickable(true);
          paramBaseViewHolder.xQO.setEnabled(true);
          paramTimeLineObject = paramp.dxQ();
          if ((paramTimeLineObject != null) && (!bt.isNullOrNil(paramTimeLineObject.DND))) {
            paramBaseViewHolder.xbU.setText(paramTimeLineObject.DND);
          }
          label1852:
          if (((bf)localObject3).xIH)
          {
            paramBaseViewHolder.xQH.setVisibility(0);
            paramBaseViewHolder.xQH.setTag(((bf)localObject3).xmu);
            label1880:
            if (!((bf)localObject3).xII) {
              break label4187;
            }
            if (bt.isNullOrNil(((bf)localObject3).xIJ)) {
              break label4126;
            }
            paramBaseViewHolder.xQD.setVisibility(0);
            if (paramInt2 != 7) {
              break label4096;
            }
            paramTimeLineObject = String.format(this.mActivity.getString(2131764038), new Object[] { ((bf)localObject3).xIJ });
            paramTimeLineObject = com.tencent.mm.pluginsdk.ui.span.k.b(this.mActivity, paramTimeLineObject, paramBaseViewHolder.xQD.getTextSize());
            paramBaseViewHolder.xQD.setText(paramTimeLineObject);
            if (!((bf)localObject3).xIL) {
              break label4199;
            }
            if (paramBaseViewHolder.xRs == null)
            {
              paramBaseViewHolder.xRs = paramBaseViewHolder.xRr.inflate();
              paramBaseViewHolder.wCR = ((TextView)paramBaseViewHolder.xRs.findViewById(2131296573));
              paramBaseViewHolder.xRt = ((MaskTextView)paramBaseViewHolder.xRs.findViewById(2131296574));
              paramBaseViewHolder.xRt.setOnTouchListener(new com.tencent.mm.plugin.sns.ui.ad());
            }
            paramBaseViewHolder.xRs.setVisibility(0);
            a(paramBaseViewHolder.xRt, ((bf)localObject3).xIO, paramInt2);
            paramTimeLineObject = this.mActivity.getString(2131763903, new Object[] { Integer.valueOf(((bf)localObject3).xIM), bt.D(((bf)localObject3).xIN / 100.0D) });
            paramBaseViewHolder.wCR.setText(paramTimeLineObject);
            paramBaseViewHolder.xRs.setTag(paramp);
            paramBaseViewHolder.xRs.setOnClickListener(parambe.wMy.xTF);
            label2139:
            if (((((bf)localObject3).xIP != null) && (((bf)localObject3).xIP.size() != 0)) || ((((bf)localObject3).xIQ != null) && (((bf)localObject3).xIQ.size() != 0))) {
              break label4237;
            }
            if (paramBaseViewHolder.xkf == null) {
              break label4218;
            }
            paramBaseViewHolder.xkf.setVisibility(8);
            if (!((bf)localObject3).xIR) {
              break label4661;
            }
            paramBaseViewHolder.xQy.setTag(((bf)localObject3).xmu);
            paramBaseViewHolder.xQy.setText(((bf)localObject3).xIS);
            paramBaseViewHolder.xQy.setVisibility(0);
            if (!((bf)localObject3).xkI) {
              break label4678;
            }
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BaseTimeLineItem", "adatag " + ((bf)localObject3).xIm);
            paramBaseViewHolder.wAe.F(Long.valueOf(((bf)localObject3).xIc), new com.tencent.mm.plugin.sns.data.b(paramBaseViewHolder.wAe, paramBaseViewHolder.position, ((bf)localObject3).xmu, ((bf)localObject3).xIc, ((bf)localObject3).xIi));
            paramBaseViewHolder.wAe.a(((bf)localObject3).xIl, ((bf)localObject3).xIk);
            paramBaseViewHolder.wAe.setVisibility(0);
            if ((paramBaseViewHolder.xDy != null) && (paramBaseViewHolder.xDy.getVisibility() == 0))
            {
              if (paramBaseViewHolder.wAe.xLo.getVisibility() != 0) {
                break label4673;
              }
              paramInt1 = 1;
              label2369:
              if (paramInt1 != 0)
              {
                paramTimeLineObject = (LinearLayout.LayoutParams)paramBaseViewHolder.xDy.getLayoutParams();
                paramTimeLineObject.setMargins(paramTimeLineObject.leftMargin, BackwardSupportUtil.b.g(this.mActivity, 0.0F), paramTimeLineObject.rightMargin, paramTimeLineObject.bottomMargin);
                paramBaseViewHolder.xDy.setLayoutParams(paramTimeLineObject);
              }
            }
            paramBaseViewHolder.xQC.setVisibility(8);
            label2431:
            if (this.xvU) {
              com.tencent.mm.plugin.sns.model.af.dtl().a(this.mActivity, localSnsObject, paramBaseViewHolder);
            }
            paramTimeLineObject = com.tencent.mm.plugin.sns.model.af.dtD();
            long l = paramp.field_snsId;
            if ((!paramTimeLineObject.wJr) || (l == 0L) || (paramTimeLineObject.wJK) || (paramTimeLineObject.wJB <= paramTimeLineObject.wJv) || (paramTimeLineObject.wJO == null) || (paramTimeLineObject.wJO.state != 1) || (paramTimeLineObject.wJO.wOi < paramTimeLineObject.wJw) || (!paramTimeLineObject.wJG)) {
              break label4751;
            }
            if ((paramTimeLineObject.wJz != 0L) && (ce.asT() - paramTimeLineObject.wJN.wJR <= paramTimeLineObject.wJz)) {
              break label4746;
            }
            paramInt1 = 1;
            if ((paramInt1 == 0) || (l != paramTimeLineObject.wJP)) {
              break label4751;
            }
            paramInt1 = 1;
            if (paramInt1 == 0) {
              break label4756;
            }
            if (!paramBaseViewHolder.xRy)
            {
              paramBaseViewHolder.xRA = ((LinearLayout)paramBaseViewHolder.xRz.inflate());
              paramBaseViewHolder.xRy = true;
              paramBaseViewHolder.xRB = ((ViewGroup)paramBaseViewHolder.xRA.findViewById(2131305092));
            }
            paramBaseViewHolder.xRz.setVisibility(0);
            paramBaseViewHolder.hSI.setBackgroundColor(0);
            paramBaseViewHolder.xRB.setTag(Long.valueOf(paramp.field_snsId));
            com.tencent.mm.plugin.sns.model.af.dtD().es(paramBaseViewHolder.xRB);
            paramBaseViewHolder.xRB.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(179352);
                parambe.xFq.dyP();
                com.tencent.mm.plugin.sns.k.f.wQY.wRE.dWy = 1L;
                AppMethodBeat.o(179352);
              }
            });
            com.tencent.mm.plugin.report.service.h.vKh.dB(1295, 1);
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
        paramp = new ba(((bf)localObject3).xIb, ((bf)localObject3).xmu, false, true, 1);
        paramBaseViewHolder.xQu.getResultTextView().setTag(paramp);
        paramp = a.a.eSf();
        paramTimeLineObject = paramBaseViewHolder.rLd;
        parambe = paramBaseViewHolder.xQq;
        localObject3 = paramBaseViewHolder.timeTv;
        localObject1 = paramBaseViewHolder.xQt.getContent();
        localObject2 = paramBaseViewHolder.xQA;
        bool = paramBaseViewHolder.xRo;
        if ((paramp.eSe()) && (paramp.FZ != null) && (paramTimeLineObject != null) && (parambe != null) && (localObject3 != null)) {
          break label4799;
        }
        return;
        ((com.tencent.mm.plugin.sns.k.c)localObject1).wQy.add(localObject2);
        break;
        ((com.tencent.mm.plugin.sns.k.c)localObject1).wQx.add(localObject2);
        break;
        ((com.tencent.mm.plugin.sns.k.c)localObject1).wQA.add(localObject2);
        break;
        ((com.tencent.mm.plugin.sns.k.c)localObject1).wQz.add(localObject2);
        break;
        ((com.tencent.mm.plugin.sns.k.c)localObject1).wQF.add(localObject2);
        break;
        ((com.tencent.mm.plugin.sns.k.c)localObject1).wQG.add(localObject2);
        break;
        if (!bt.isNullOrNil(paramTimeLineObject.Etn))
        {
          ((com.tencent.mm.plugin.sns.k.c)localObject1).wQD.add(localObject2);
          break;
        }
        ((com.tencent.mm.plugin.sns.k.c)localObject1).wQE.add(localObject2);
        break;
        i = 0;
        break label605;
        label2941:
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(((com.tencent.mm.plugin.sns.storage.b)localObject2).wTI, new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a()
        {
          public final void apm(String paramAnonymousString)
          {
            AppMethodBeat.i(100047);
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BaseTimeLineItem", "download img %s", new Object[] { paramAnonymousString });
            String str = (String)paramBaseViewHolder.xQp.getTag(2131305044);
            if ((!bt.T(new String[] { str, paramAnonymousString })) && (paramAnonymousString.equals(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.iU("adId", str))))
            {
              paramAnonymousString = com.tencent.mm.plugin.sns.a.b.l.wyR.getBitmap(paramAnonymousString);
              if (paramAnonymousString != null) {
                paramBaseViewHolder.xQp.setImageBitmap(paramAnonymousString);
              }
            }
            AppMethodBeat.o(100047);
          }
          
          public final void dsA() {}
          
          public final void duP() {}
        });
        break label717;
        label2961:
        if (!((String)localObject1).endsWith("@ad")) {
          if (((bf)localObject3).xIr)
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BaseTimeLineItem", "getContact %s", new Object[] { localObject1 });
            if (a.b.exg().Ky() != null) {
              paramBaseViewHolder.xQp.setImageBitmap(a.b.exg().Ky());
            }
            ar.a.gMW.a((String)localObject1, "", new be.c(parambe.dBY(), paramInt1));
            label3049:
            if (((bf)localObject3).xIs) {
              break label3194;
            }
            com.tencent.mm.plugin.sns.ui.e.a.b(4, (String)paramBaseViewHolder.xQp.getTag(), paramBaseViewHolder.xQp);
            paramBaseViewHolder.xQp.eE((String)localObject1, 4);
            paramBaseViewHolder.xQp.setTag(localObject1);
            com.tencent.mm.plugin.sns.ui.e.a.a(4, (String)localObject1, paramBaseViewHolder.xQp);
            paramBaseViewHolder.xQp.setShowStoryHint(((com.tencent.mm.plugin.story.api.e)g.ad(com.tencent.mm.plugin.story.api.e.class)).hasNewStory((String)localObject1));
          }
        }
        for (;;)
        {
          paramBaseViewHolder.xQq.setContactInfo(paramBaseViewHolder.xkM);
          paramBaseViewHolder.xQq.a((String)localObject1, ((bf)localObject3).xIq, new p.a()
          {
            public final void b(View paramAnonymousView, Object paramAnonymousObject)
            {
              AppMethodBeat.i(100049);
              if (parambe.xwI != null) {
                if (!(paramAnonymousObject instanceof com.tencent.mm.plugin.sns.data.a)) {
                  break label78;
                }
              }
              label78:
              for (boolean bool = ((com.tencent.mm.plugin.sns.data.a)paramAnonymousObject).isAd;; bool = false)
              {
                if (bool) {}
                for (parambe.xwI.dep = 0;; parambe.xwI.dep = 6)
                {
                  parambe.xwI.b(paramAnonymousView, paramAnonymousObject);
                  AppMethodBeat.o(100049);
                  return;
                }
              }
            }
          }, ((bf)localObject3).xkI, ((bf)localObject3).xmu, paramInt2, ((bf)localObject3).xkI);
          break;
          a.b.c(paramBaseViewHolder.xQp, (String)localObject1);
          break label3049;
          label3194:
          paramBaseViewHolder.xQp.eE((String)localObject1, 4);
          paramBaseViewHolder.xQp.setShowStoryHint(false);
          continue;
          paramBaseViewHolder.xQp.setImageResource(2131231875);
          paramBaseViewHolder.xQp.eE((String)localObject1, 4);
          paramBaseViewHolder.xQp.setShowStoryHint(false);
        }
        paramBaseViewHolder.isAd = false;
        break label801;
        label3254:
        paramBaseViewHolder.xQF.setVisibility(8);
        break label1044;
        label3266:
        if (((com.tencent.mm.plugin.sns.storage.a)localObject2).wSc != com.tencent.mm.plugin.sns.storage.a.wRP) {
          break label1044;
        }
        if (!bt.isNullOrNil(((bf)localObject3).xIo))
        {
          localObject1 = ((bf)localObject3).xIp;
          localObject4 = ((bf)localObject3).xIo;
          Object localObject5 = this.mActivity;
          paramBaseViewHolder.xQF.getTextSize();
          localObject5 = new com.tencent.mm.pluginsdk.ui.span.l(com.tencent.mm.pluginsdk.ui.span.k.c((Context)localObject5, (CharSequence)localObject4, 1));
          ((com.tencent.mm.pluginsdk.ui.span.l)localObject5).a(null, (CharSequence)localObject4, 0);
          localObject4 = paramBaseViewHolder.xQF.getPaint();
          float f = Layout.getDesiredWidth((CharSequence)localObject5, 0, ((com.tencent.mm.pluginsdk.ui.span.l)localObject5).length(), (TextPaint)localObject4);
          if (com.tencent.mm.cd.a.ar(this.mActivity, (int)f) > paramBaseViewHolder.xwR)
          {
            do
            {
              if (((String)localObject1).length() <= 1) {
                break;
              }
              localObject1 = ((String)localObject1).substring(0, ((String)localObject1).length() - 2);
              localObject5 = String.format(((com.tencent.mm.plugin.sns.storage.a)localObject2).wSd, new Object[] { (String)localObject1 + "..." });
              Object localObject6 = this.mActivity;
              paramBaseViewHolder.xQF.getTextSize();
              localObject6 = new com.tencent.mm.pluginsdk.ui.span.l(com.tencent.mm.pluginsdk.ui.span.k.c((Context)localObject6, (CharSequence)localObject5, 1));
              ((com.tencent.mm.pluginsdk.ui.span.l)localObject6).a(null, (CharSequence)localObject5, 0);
              f = Layout.getDesiredWidth((CharSequence)localObject6, 0, ((com.tencent.mm.pluginsdk.ui.span.l)localObject6).length(), (TextPaint)localObject4);
              paramInt1 = com.tencent.mm.cd.a.ar(this.mActivity, (int)f);
              paramBaseViewHolder.xQF.setText((CharSequence)localObject6, TextView.BufferType.SPANNABLE);
              paramBaseViewHolder.xQF.setVisibility(0);
            } while (paramInt1 > paramBaseViewHolder.xwR);
            break label1044;
          }
          paramBaseViewHolder.xQF.setText((CharSequence)localObject5, TextView.BufferType.SPANNABLE);
          paramBaseViewHolder.xQF.setVisibility(0);
          break label1044;
        }
        paramBaseViewHolder.xQF.setVisibility(8);
        break label1044;
        label3577:
        paramBaseViewHolder.xQG.setVisibility(8);
        break label1183;
        label3589:
        BaseViewHolder.h(paramBaseViewHolder).setVisibility(8);
        break label1236;
        label3601:
        paramInt1 = this.mActivity.getResources().getColor(2131100212);
        break label1319;
        label3618:
        paramBaseViewHolder.xDy.setBackground(this.mActivity.getResources().getDrawable(2131233299));
        break label1353;
        label3641:
        paramBaseViewHolder.xDy.setVisibility(8);
        break label1353;
        label3653:
        paramBaseViewHolder.xQE.setVisibility(8);
        break label1399;
        label3665:
        if (((bf)localObject3).xIz)
        {
          paramBaseViewHolder.hJd.setVisibility(0);
          paramTimeLineObject = new SpannableString(((bf)localObject3).xIC);
          paramTimeLineObject.setSpan(new c(), 0, paramTimeLineObject.length(), 33);
          paramBaseViewHolder.hJd.setText(paramTimeLineObject, TextView.BufferType.SPANNABLE);
          paramBaseViewHolder.hJd.setTag(new bi(((bf)localObject3).xIB, ((bf)localObject3).xIC));
          break label1617;
        }
        if (((bf)localObject3).xID)
        {
          paramBaseViewHolder.hJd.setVisibility(0);
          localObject1 = this.mActivity.getString(2131755318);
          localObject2 = (String)localObject1 + ((bf)localObject3).mAppName;
          localObject4 = new SpannableString((CharSequence)localObject2);
          ((SpannableString)localObject4).setSpan(new ForegroundColorSpan(this.mActivity.getResources().getColor(2131100943)), 0, ((String)localObject1).length(), 33);
          ((SpannableString)localObject4).setSpan(new a(), ((String)localObject1).length(), ((String)localObject2).length(), 33);
          paramBaseViewHolder.hJd.setText((CharSequence)localObject4, TextView.BufferType.SPANNABLE);
          if ((!((bf)localObject3).xIA) && (!"wx7fa037cc7dfabad5".equals(paramTimeLineObject.Etl.Id)))
          {
            paramBaseViewHolder.hJd.setTextColor(this.mActivity.getResources().getColor(2131100943));
            paramBaseViewHolder.hJd.setOnTouchListener(null);
          }
          paramBaseViewHolder.hJd.setTag(paramTimeLineObject);
          break label1617;
        }
        paramBaseViewHolder.hJd.setVisibility(8);
        break label1617;
        label3966:
        paramBaseViewHolder.xnd.setVisibility(8);
        break label1645;
        paramBaseViewHolder.xbU.setText(2131763943);
        paramBaseViewHolder.xQO.setClickable(false);
        paramBaseViewHolder.xQO.setEnabled(false);
        break label1818;
        paramBaseViewHolder.xbU.setText(2131763945);
        paramBaseViewHolder.xQO.setClickable(false);
        paramBaseViewHolder.xQO.setEnabled(false);
        break label1818;
        paramBaseViewHolder.xbU.setText(2131763944);
        paramBaseViewHolder.xQO.setClickable(true);
        paramBaseViewHolder.xQO.setEnabled(true);
        break label1818;
        label4065:
        if (!paramBaseViewHolder.xQY) {
          break label1852;
        }
        paramBaseViewHolder.xQU.setVisibility(8);
        break label1852;
        paramBaseViewHolder.xQH.setVisibility(8);
        break label1880;
        label4096:
        paramTimeLineObject = String.format(this.mActivity.getString(2131764039), new Object[] { ((bf)localObject3).xIJ });
        break label1941;
        label4126:
        if (((bf)localObject3).xIK)
        {
          paramBaseViewHolder.xQD.setVisibility(0);
          paramTimeLineObject = this.mActivity.getString(2131764040);
          paramTimeLineObject = com.tencent.mm.pluginsdk.ui.span.k.b(this.mActivity, paramTimeLineObject.toString(), paramBaseViewHolder.xQD.getTextSize());
          paramBaseViewHolder.xQD.setText(paramTimeLineObject);
          break label1968;
        }
        label4187:
        paramBaseViewHolder.xQD.setVisibility(8);
        break label1968;
        label4199:
        if (paramBaseViewHolder.xRs == null) {
          break label2139;
        }
        paramBaseViewHolder.xRs.setVisibility(8);
        break label2139;
        label4218:
        if (!paramBaseViewHolder.xQT) {
          break label2193;
        }
        paramBaseViewHolder.xQS.setVisibility(8);
        break label2193;
        label4237:
        if (!paramBaseViewHolder.xQT)
        {
          if ((paramBaseViewHolder.xkf != null) || (paramBaseViewHolder.xQS.getParent() == null)) {
            break label4581;
          }
          paramBaseViewHolder.xkf = ((LinearLayout)paramBaseViewHolder.xQS.inflate());
          if (paramBaseViewHolder.xkf != null)
          {
            paramBaseViewHolder.xQK = ((SnsLikesTextView)paramBaseViewHolder.xkf.findViewById(2131296588));
            paramBaseViewHolder.xQK.setLikedTextTouchListener(new com.tencent.mm.plugin.sns.ui.ad());
            paramBaseViewHolder.xQK.setOpClickListener(parambe.xFG);
            paramBaseViewHolder.xQM = ((LinearLayout)paramBaseViewHolder.rLd.findViewById(2131296557));
            paramBaseViewHolder.xkf.setTag(((bf)localObject3).xIb);
            paramBaseViewHolder.xQK.setLikeTvTag(((bf)localObject3).xIb);
            paramBaseViewHolder.xQK.setOpTvTag(paramBaseViewHolder);
            paramBaseViewHolder.xQR = paramBaseViewHolder.xkf.findViewById(2131296592);
            paramBaseViewHolder.xRu = paramBaseViewHolder.xkf.findViewById(2131296590);
            paramBaseViewHolder.xQT = true;
          }
        }
        if (paramBaseViewHolder.xkf != null) {
          paramBaseViewHolder.xkf.setVisibility(0);
        }
        if ((((bf)localObject3).xIP != null) && (((bf)localObject3).xIP.size() > 0))
        {
          paramBaseViewHolder.xQK.setVisibility(0);
          parambe.a(((bf)localObject3).xmu, paramBaseViewHolder.xQK);
          paramBaseViewHolder.xQK.a(((bf)localObject3).xIP, paramInt2, parambe, ((bf)localObject3).xmu, parambe.xAZ, parambe.xBa, parambe.xFu, (bf)localObject3, paramBaseViewHolder);
          paramBaseViewHolder.xQL = true;
          label4508:
          if (((bf)localObject3).xIQ == null) {
            break label4637;
          }
          a(localSnsObject.CommentUserList, ((bf)localObject3).xIQ, paramBaseViewHolder);
        }
        for (;;)
        {
          if ((((bf)localObject3).xIP == null) || (((bf)localObject3).xIP.size() == 0) || (((bf)localObject3).xIQ == null) || (((bf)localObject3).xIQ.size() == 0)) {
            break label4649;
          }
          paramBaseViewHolder.xQR.setVisibility(0);
          break;
          label4581:
          if (paramBaseViewHolder.xkf == null) {}
          for (bool = true;; bool = false)
          {
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.BaseTimeLineItem", "holder.listKeeper = null %s,and holder.commentStub.inflated", new Object[] { Boolean.valueOf(bool) });
            break;
          }
          paramBaseViewHolder.xQK.setVisibility(8);
          paramBaseViewHolder.xQL = false;
          break label4508;
          label4637:
          paramBaseViewHolder.xQM.setVisibility(8);
        }
        label4649:
        paramBaseViewHolder.xQR.setVisibility(8);
        break label2193;
        label4661:
        paramBaseViewHolder.xQy.setVisibility(8);
        break label2233;
        label4673:
        paramInt1 = 0;
        break label2369;
        label4678:
        if (i != 0)
        {
          paramBaseViewHolder.wAe.setVisibility(8);
          paramBaseViewHolder.xQC.setTag(new com.tencent.mm.plugin.sns.data.e(paramBaseViewHolder.xQC, paramp.dxX()));
          paramBaseViewHolder.xQC.setVisibility(0);
          break label2431;
        }
        paramBaseViewHolder.wAe.setVisibility(8);
        paramBaseViewHolder.xQC.setVisibility(8);
        break label2431;
        label4746:
        paramInt1 = 0;
        break label2576;
        label4751:
        paramInt1 = 0;
        break label2593;
        label4756:
        if (paramBaseViewHolder.xRy)
        {
          paramBaseViewHolder.xRz.setVisibility(8);
          paramBaseViewHolder.xRB.setTag(Long.valueOf(paramp.field_snsId));
        }
        paramBaseViewHolder.hSI.setBackgroundResource(2131232867);
      }
      label4799:
      paramBaseViewHolder = new com.tencent.mm.ui.a.b();
      paramBaseViewHolder.aKd(parambe.getText().toString());
      paramBaseViewHolder.aKd((String)localObject1);
      if (localObject2 != null) {
        paramBaseViewHolder.aKd(((TextView)localObject2).getText().toString());
      }
      if (bool) {
        paramBaseViewHolder.aKd(paramp.FZ.getString(2131757941));
      }
      paramBaseViewHolder.fB(paramTimeLineObject);
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
    this.xvU = paramBoolean;
  }
  
  public static class BaseViewHolder
  {
    public String dgg;
    public String dpC;
    public volatile boolean fUH;
    public TextView hJd;
    public ViewGroup hSI;
    public boolean isAd;
    public int nBH;
    public int position;
    public View rLd;
    public boolean rVk;
    public SnsObject snsobj;
    public TimeLineObject timeLineObject;
    public TextView timeTv;
    public TextView titleTv;
    public bk wAe;
    public TextView wCR;
    public View xDE;
    public TextView xDy;
    public an xOO;
    public TextView xQA;
    public int xQB;
    public RelativeLayout xQC;
    public TextView xQD;
    public WeImageView xQE;
    public AsyncTextView xQF;
    public AsyncTextView xQG;
    public View xQH;
    public ImageView xQI;
    public View xQJ;
    public SnsLikesTextView xQK;
    public boolean xQL;
    public LinearLayout xQM;
    public LinearLayout xQN;
    public View xQO;
    public LinearLayout xQP;
    public PhotosContent xQQ;
    public View xQR;
    public ViewStub xQS;
    public boolean xQT;
    public ViewStub xQU;
    public ViewStub xQV;
    public View xQW;
    public boolean xQX;
    public boolean xQY;
    public ViewStub xQZ;
    public long xQn;
    public int xQo;
    public SnsAvatarImageView xQp;
    public AsyncTextView xQq;
    public ImageView xQr;
    public ViewGroup xQs;
    public AsyncNormalTextView xQt;
    public SnsTranslateResultView xQu;
    public LinearLayout xQv;
    public ViewStub xQw;
    public boolean xQx;
    public TextView xQy;
    public TagImageView xQz;
    public LinearLayout xRA;
    public ViewGroup xRB;
    public boolean xRa;
    public View xRb;
    public LinearLayout xRc;
    public TextView xRd;
    public ViewStub xRe;
    public boolean xRf;
    public View xRg;
    public LinearLayout xRh;
    public ViewStub xRi;
    public boolean xRj;
    public View xRk;
    public ImageView xRl;
    public boolean xRm;
    ViewStub xRn;
    boolean xRo;
    public View xRp;
    public BaseTimeLineItem xRq;
    public ViewStub xRr;
    public View xRs;
    public MaskTextView xRt;
    public View xRu;
    private TextView xRv;
    public String xRw;
    public View xRx;
    public boolean xRy;
    public ViewStub xRz;
    public TextView xbU;
    public bpj xiM;
    public com.tencent.mm.n.b xkM;
    public ImageView xkO;
    public LinearLayout xkf;
    public TextView xnd;
    public int xwR;
    
    public BaseViewHolder()
    {
      AppMethodBeat.i(100055);
      this.xQx = false;
      this.xQB = 0;
      this.xwR = 210;
      this.xQL = false;
      this.xQT = false;
      this.xQW = null;
      this.xQX = false;
      this.xQY = false;
      this.xRa = false;
      this.xRf = false;
      this.xRj = false;
      this.xRm = false;
      this.xRo = false;
      this.xOO = new an();
      this.xRy = false;
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
      BaseTimeLineItem.this.wNd.xwM.xLI.onClick(paramView);
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
      BaseTimeLineItem.this.wNd.xwM.xLx.onClick(paramView);
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
      BaseTimeLineItem.this.wNd.xwM.xLy.onClick(paramView);
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
    public CharSequence ggH;
    public String md5;
    private WeakReference<View> view;
    public com.tencent.mm.plugin.sns.ui.l xFz;
    public int xRC;
    public int xyh;
    
    public d(String paramString, CharSequence paramCharSequence, View paramView, int paramInt, com.tencent.mm.plugin.sns.ui.l paraml)
    {
      AppMethodBeat.i(100058);
      this.view = null;
      this.md5 = null;
      this.ggH = null;
      this.xyh = 0;
      this.xRC = ao.fromDPToPix(aj.getContext(), 28);
      this.xFz = null;
      this.view = new WeakReference(paramView);
      this.md5 = paramString;
      this.ggH = paramCharSequence;
      this.xyh = paramInt;
      this.xFz = paraml;
      AppMethodBeat.o(100058);
    }
    
    public final void f(Bitmap paramBitmap, String paramString)
    {
      AppMethodBeat.i(100059);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BaseTimeLineItem", "onEmojiDecodeFin bitmapAvailable:%s, md5:%s", new Object[] { Boolean.valueOf(q.I(paramBitmap)), paramString });
      if ((this.view != null) && (this.view.get() != null) && ((this.view.get() instanceof SnsCommentCollapseLayout)))
      {
        SnsCommentCollapseLayout localSnsCommentCollapseLayout = (SnsCommentCollapseLayout)this.view.get();
        if ((localSnsCommentCollapseLayout != null) && (localSnsCommentCollapseLayout.getTag() != null) && ((localSnsCommentCollapseLayout.getTag() instanceof m)))
        {
          Object localObject = (m)localSnsCommentCollapseLayout.getTag();
          if ((((m)localObject).wFh != null) && (!bt.gL(((m)localObject).wFh.Emf)) && (((m)localObject).wFh.Emf.get(0) != null) && (bt.kU(paramString, ((cuu)((m)localObject).wFh.Emf.get(0)).Md5)) && (q.I(paramBitmap)))
          {
            paramString = new SpannableStringBuilder(this.ggH);
            paramString.append("  ").append(this.md5).append("  ").append(" ");
            int i = paramString.length() - this.md5.length() - 2 - 1;
            int j = paramString.length() - this.md5.length() - 4 - 1;
            paramBitmap = new BitmapDrawable(paramBitmap);
            paramBitmap.setBounds(0, 0, this.xRC, this.xRC);
            paramBitmap = new com.tencent.mm.ui.widget.a(paramBitmap);
            aj.getContext();
            localObject = new com.tencent.mm.pluginsdk.ui.span.p(this.md5, this.xFz, 2);
            paramString.setSpan(paramBitmap, i, this.md5.length() + i, 33);
            paramString.setSpan(localObject, j, j + 4 + this.md5.length(), 33);
            localSnsCommentCollapseLayout.l(paramString, this.xyh);
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