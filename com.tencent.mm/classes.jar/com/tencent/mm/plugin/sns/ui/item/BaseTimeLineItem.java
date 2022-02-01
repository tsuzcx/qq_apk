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
import com.tencent.mm.g.b.a.fa;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.au.a;
import com.tencent.mm.model.au.b;
import com.tencent.mm.model.ch;
import com.tencent.mm.plugin.sns.data.f;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.j.e.a;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.as;
import com.tencent.mm.plugin.sns.model.as.b;
import com.tencent.mm.plugin.sns.model.au;
import com.tencent.mm.plugin.sns.model.ba;
import com.tencent.mm.plugin.sns.model.g.5;
import com.tencent.mm.plugin.sns.model.g.d;
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
import com.tencent.mm.plugin.sns.ui.bd;
import com.tencent.mm.plugin.sns.ui.bh;
import com.tencent.mm.plugin.sns.ui.bh.c;
import com.tencent.mm.plugin.sns.ui.bi;
import com.tencent.mm.plugin.sns.ui.bl;
import com.tencent.mm.plugin.sns.ui.bn;
import com.tencent.mm.plugin.sns.ui.bo;
import com.tencent.mm.plugin.sns.ui.i;
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
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.bzi;
import com.tencent.mm.protocal.protobuf.dgh;
import com.tencent.mm.protocal.protobuf.dgn;
import com.tencent.mm.protocal.protobuf.en;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.a.a.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.vending.base.Vending;
import com.tencent.mm.vfs.o;
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
  public ArrayList<as.b> AMg = new ArrayList();
  protected boolean Arr = false;
  public boolean DEBUG = false;
  protected Activity mActivity;
  protected int oOD;
  protected bh zGX;
  
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
  
  public static void a(as.b paramb, BaseViewHolder paramBaseViewHolder, String paramString1, String paramString2)
  {
    if ((paramBaseViewHolder != null) && (paramBaseViewHolder.AMq != null))
    {
      paramBaseViewHolder.AMq.a(paramb, 1, paramString1, paramString2, paramb.zDe);
      paramBaseViewHolder.AMq.setVisibility(0);
    }
  }
  
  private void a(com.tencent.mm.plugin.sns.storage.a parama, BaseViewHolder paramBaseViewHolder)
  {
    if ((parama == null) || (paramBaseViewHolder == null)) {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BaseTimeLineItem", "adInfo or holder is null");
    }
    for (;;)
    {
      return;
      try
      {
        if ((parama.zMg == 1) && (!bu.isNullOrNil(parama.zMf)))
        {
          String str = parama.zMe;
          Object localObject1 = parama.zMf;
          Object localObject2 = this.mActivity;
          paramBaseViewHolder.AMB.getTextSize();
          localObject2 = new com.tencent.mm.pluginsdk.ui.span.l(com.tencent.mm.pluginsdk.ui.span.k.c((Context)localObject2, (CharSequence)localObject1, 1));
          ((com.tencent.mm.pluginsdk.ui.span.l)localObject2).a(null, (CharSequence)localObject1);
          localObject1 = paramBaseViewHolder.AMB.getPaint();
          float f = Layout.getDesiredWidth((CharSequence)localObject2, 0, ((com.tencent.mm.pluginsdk.ui.span.l)localObject2).length(), (TextPaint)localObject1);
          if (com.tencent.mm.cb.a.aA(this.mActivity, (int)f) > paramBaseViewHolder.Aso)
          {
            int i;
            do
            {
              if (str.length() <= 1) {
                break;
              }
              str = str.substring(0, str.length() - 2);
              localObject2 = String.format(parama.zMb, new Object[] { str + "..." });
              Object localObject3 = this.mActivity;
              paramBaseViewHolder.AMB.getTextSize();
              localObject3 = new com.tencent.mm.pluginsdk.ui.span.l(com.tencent.mm.pluginsdk.ui.span.k.c((Context)localObject3, (CharSequence)localObject2, 1));
              ((com.tencent.mm.pluginsdk.ui.span.l)localObject3).a(null, (CharSequence)localObject2);
              f = Layout.getDesiredWidth((CharSequence)localObject3, 0, ((com.tencent.mm.pluginsdk.ui.span.l)localObject3).length(), (TextPaint)localObject1);
              i = com.tencent.mm.cb.a.aA(this.mActivity, (int)f);
              paramBaseViewHolder.AMB.setText((CharSequence)localObject3, TextView.BufferType.SPANNABLE);
              paramBaseViewHolder.AMB.setVisibility(0);
            } while (i > paramBaseViewHolder.Aso);
            return;
          }
          paramBaseViewHolder.AMB.setText((CharSequence)localObject2, TextView.BufferType.SPANNABLE);
          paramBaseViewHolder.AMB.setVisibility(0);
          return;
        }
      }
      catch (Throwable parama)
      {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.BaseTimeLineItem", parama.toString());
      }
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
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.BaseTimeLineItem", "setReward error  e:%s", new Object[] { bu.o(paramMaskTextView) });
      return;
    }
    ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
    com.tencent.mm.ui.widget.a locala = new com.tencent.mm.ui.widget.a((Drawable)localObject);
    locala.LmE = ((int)((((Drawable)localObject).getIntrinsicHeight() - paramMaskTextView.getTextSize() + com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 2)) / 2.0F));
    localSpannableStringBuilder.setSpan(locala, k, k + 1, 33);
    if (paramInt == 10)
    {
      paramInt = 3;
      break label404;
      while (i < arrayOfInt1.length)
      {
        localSpannableStringBuilder.setSpan(new com.tencent.mm.pluginsdk.ui.span.p((String)((com.tencent.mm.vending.j.a)paramb.get(i)).get(0), this.zGX.Asf, paramInt), arrayOfInt1[i], arrayOfInt2[i], 33);
        i += 1;
      }
      paramMaskTextView.setText(localSpannableStringBuilder, TextView.BufferType.SPANNABLE);
      paramMaskTextView.setOriginText(localStringBuffer.toString());
      return;
    }
    for (;;)
    {
      label404:
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
      if (paramTimeLineObject.HUF == null) {}
      for (String str = null; !bu.isNullOrNil(str); str = paramTimeLineObject.HUF.Id)
      {
        com.tencent.mm.plugin.sns.c.a.iUA.a(str, paramTimeLineObject.nIJ, paramTimeLineObject.HUG.Gtw, paramTimeLineObject.HUK, parambi.ADP);
        return;
      }
    }
  }
  
  private static void a(BaseViewHolder paramBaseViewHolder, com.tencent.mm.plugin.sns.storage.p paramp)
  {
    if (paramp.Rt(32))
    {
      if (paramBaseViewHolder.AMp != null) {
        paramBaseViewHolder.AMp.setVisibility(0);
      }
      paramBaseViewHolder.AMr.setLongClickable(false);
      paramBaseViewHolder.AMr.setOnClickListener(null);
      paramp = new LinearLayout.LayoutParams(-1, -2);
      paramBaseViewHolder.AMr.setLayoutParams(paramp);
      paramBaseViewHolder.AMr.setBackgroundColor(Color.parseColor("#00ffffff"));
      if (paramBaseViewHolder.AMM != null)
      {
        paramp = (LinearLayout.LayoutParams)paramBaseViewHolder.AMM.getLayoutParams();
        paramp.leftMargin = 0;
        paramp.rightMargin = 0;
        paramBaseViewHolder.AMM.setLayoutParams(paramp);
      }
      if (paramBaseViewHolder.ANl)
      {
        paramp = (LinearLayout.LayoutParams)paramBaseViewHolder.AKJ.AnG.getLayoutParams();
        paramp.leftMargin = 0;
        paramp.rightMargin = 0;
        paramBaseViewHolder.AKJ.AnG.setLayoutParams(paramp);
      }
      return;
    }
    if (paramBaseViewHolder.AMp != null) {
      paramBaseViewHolder.AMp.setVisibility(0);
    }
    paramBaseViewHolder.AMr.setLongClickable(false);
    paramBaseViewHolder.AMr.setOnClickListener(null);
    if (paramBaseViewHolder.AMM != null)
    {
      paramp = (LinearLayout.LayoutParams)paramBaseViewHolder.AMM.getLayoutParams();
      paramp.leftMargin = 0;
      paramp.rightMargin = 0;
      paramBaseViewHolder.AMM.setLayoutParams(paramp);
    }
    if (paramBaseViewHolder.ANl)
    {
      paramp = (LinearLayout.LayoutParams)paramBaseViewHolder.AKJ.AnG.getLayoutParams();
      paramp.leftMargin = 0;
      paramp.rightMargin = 0;
      paramBaseViewHolder.AKJ.AnG.setLayoutParams(paramp);
    }
    paramp = new LinearLayout.LayoutParams(-1, -2);
    paramBaseViewHolder.AMr.setLayoutParams(paramp);
    paramBaseViewHolder.AMr.setBackgroundColor(Color.parseColor("#00ffffff"));
  }
  
  private boolean a(List<dgh> paramList, com.tencent.mm.vending.d.b<com.tencent.mm.vending.j.a> paramb, BaseViewHolder paramBaseViewHolder)
  {
    LinearLayout localLinearLayout = paramBaseViewHolder.AMI;
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
          this.zGX.a((SnsCommentCollapseLayout)localObject1);
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
    Object localObject1 = this.zGX.egs();
    if ((localObject1 instanceof com.tencent.mm.plugin.sns.ui.a.c)) {}
    for (bi localbi = (bi)((com.tencent.mm.plugin.sns.ui.a.c)localObject1).AIr.get(paramBaseViewHolder.position);; localbi = null)
    {
      if (this.DEBUG) {
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.BaseTimeLineItem", "debug:setCommentList position " + paramBaseViewHolder.position + " commentCount: " + j);
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
        if (bu.isNullOrNil((String)localObject7)) {
          break label2209;
        }
        j = 1;
        localStringBuilder2.append(l).append("|");
      }
      for (;;)
      {
        localStringBuilder1.append(l).append("|");
        dgh localdgh = (dgh)paramList.get(m);
        i = localdgh.HNo;
        int i2 = localdgh.DeleteFlag;
        Object localObject6 = bp(paramBaseViewHolder.dAg, l);
        if ((localObject6 != null) && (((as.b)localObject6).aGQ)) {
          as.fd(((as.b)localObject6).id, 2);
        }
        label517:
        int n;
        if (k >= i1) {
          if ((localObject6 == null) || (((as.b)localObject6).aGQ))
          {
            localObject1 = this.zGX.ego();
            ((SnsCommentCollapseLayout)localObject1).setTextSize$255e752(15.0F * com.tencent.mm.cb.a.ef(((View)localObject1).getContext()));
            if (this.zGX.AAV == -1) {
              this.zGX.AAV = this.mActivity.getResources().getColor(2131100907);
            }
            ((SnsCommentCollapseLayout)localObject1).setTextColor(this.zGX.AAV);
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
            ((TranslateCommentTextView)localObject1).getTranslateResultView().setResultTextSize$255e752(15.0F * com.tencent.mm.cb.a.ef(((View)localObject1).getContext()));
            ((TranslateCommentTextView)localObject1).getOriginCommentTextView().setTextSize(1, 15.0F * com.tencent.mm.cb.a.ef(((View)localObject1).getContext()));
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
          if (!((as.b)localObject6).hLB)
          {
            ((TranslateCommentTextView)localObject7).AHX.setTextSize(1, 15.0F * com.tencent.mm.cb.a.ef(((TranslateCommentTextView)localObject7).getContext()));
            ((TranslateCommentTextView)localObject7).Atx.Sa(2);
            ((TranslateCommentTextView)localObject7).Atx.setVisibility(0);
            i = 1;
            if (k <= 0) {
              break label1906;
            }
            ((View)localObject1).setPadding(com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 8), com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 4), com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 0), com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 3));
            if (k != paramb.size() - 1) {
              break label1895;
            }
            ((View)localObject1).setBackgroundResource(2131234841);
            if (i != 0)
            {
              localObject2 = (TranslateCommentTextView)localObject1;
              i = (int)this.mActivity.getResources().getDimension(2131165568);
              ((TranslateCommentTextView)localObject2).Atx.getSplitlineView().setPadding(0, 0, i, 0);
            }
            if (!com.tencent.mm.plugin.sns.ui.widget.e.b(localdgh)) {
              break label2012;
            }
            ((View)localObject1).setOnLongClickListener(null);
            ((View)localObject1).setOnClickListener(null);
            label814:
            if (localbi != null) {
              ((View)localObject1).setTag(new com.tencent.mm.plugin.sns.ui.m(localbi.AhK, localbi.ADO, localdgh, str1, str3, (View)localObject1, 1, localbi.lJm));
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
            ((TranslateCommentTextView)localObject1).getTranslateResultView().setResultTextSize$255e752(15.0F * com.tencent.mm.cb.a.ef(((View)localObject1).getContext()));
            ((TranslateCommentTextView)localObject1).getOriginCommentTextView().setTextSize(1, 15.0F * com.tencent.mm.cb.a.ef(((View)localObject1).getContext()));
            break label517;
            localObject1 = localLinearLayout.getChildAt(k);
            n = 0;
            break label520;
          }
          Object localObject8;
          Object localObject3;
          if (!((as.b)localObject6).aGQ)
          {
            localObject4 = ((as.b)localObject6).result;
            localObject5 = ((as.b)localObject6).hTy;
            localObject8 = ((TranslateCommentTextView)localObject7).AHX.getText().toString();
            if (!bu.isNullOrNil((String)localObject8))
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
              if (bu.isNullOrNil((String)localObject4)) {
                break label1166;
              }
              ((TranslateCommentTextView)localObject7).Atx.a((as.b)localObject6, 2, localObject2[0] + ": " + (String)localObject4, (String)localObject5, ((as.b)localObject6).zDe);
            }
            for (;;)
            {
              ((TranslateCommentTextView)localObject7).Atx.setVisibility(0);
              ((TranslateCommentTextView)localObject7).AHX.setTextSize(1, 15.0F * com.tencent.mm.cb.a.ef(((TranslateCommentTextView)localObject7).getContext()));
              i = 1;
              break;
              ((TranslateCommentTextView)localObject7).Atx.a((as.b)localObject6, 2, null, (String)localObject5, ((as.b)localObject6).zDe);
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
                localObject2 = this.zGX.ego();
                localLinearLayout.addView((View)localObject2, k);
                ((SnsCommentCollapseLayout)localObject2).setTextSize$255e752(15.0F * com.tencent.mm.cb.a.ef(((View)localObject2).getContext()));
              }
            }
            if ((localObject2 instanceof SnsCommentCollapseLayout))
            {
              ((SnsCommentCollapseLayout)localObject2).setTextSize$255e752(15.0F * com.tencent.mm.cb.a.ef(((View)localObject2).getContext()));
              ((SnsCommentCollapseLayout)localObject2).setOpClickListener(this.zGX.ABi);
              ((SnsCommentCollapseLayout)localObject2).setPressTouchListener(new n(this.mActivity));
            }
            localObject3 = new CharSequence[2];
            localObject3[0] = localObject5;
            localObject3[1] = localObject4;
            localObject2.hashCode();
            if ((bu.isNullOrNil((String)localObject7)) || (!(localObject2 instanceof SnsCommentCollapseLayout)))
            {
              a((View)localObject2, localObject3[0], localObject3[1], i, i2);
              i = 0;
              localObject1 = localObject2;
              break;
            }
            localObject1 = ah.dXB();
            localObject6 = new d((String)localObject7, (CharSequence)localObject5, (CharSequence)localObject4, (View)localObject2, i, i2, this.zGX.AAZ);
            localObject8 = com.tencent.mm.emoji.loader.a.b.gla;
            localObject8 = com.tencent.mm.emoji.loader.a.b.wA((String)localObject7);
            if (localObject8 == null) {
              ah.dXr().execute(new g.5((com.tencent.mm.plugin.sns.model.g)localObject1, (String)localObject7, (g.d)localObject6));
            }
            int i3 = com.tencent.mm.ui.aq.fromDPToPix(this.mActivity, 28);
            localObject6 = new StringBuilder((String)localObject7);
            if (localObject8 == null)
            {
              ((StringBuilder)localObject6).append("miss");
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BaseTimeLineItem", "wrapEmojiInfo:%s miss cache", new Object[] { ((StringBuilder)localObject6).toString() });
            }
            for (localObject1 = this.mActivity.getResources().getDrawable(2131234117);; localObject1 = new BitmapDrawable((Bitmap)localObject8))
            {
              localObject5 = new SpannableStringBuilder((CharSequence)localObject5);
              ((SpannableStringBuilder)localObject5).append("  ").append(((StringBuilder)localObject6).toString()).append("  ").append(" ");
              int i4 = ((SpannableStringBuilder)localObject5).length() - ((StringBuilder)localObject6).toString().length() - 2 - 1;
              int i5 = ((SpannableStringBuilder)localObject5).length() - ((StringBuilder)localObject6).toString().length() - 4 - 1;
              ((Drawable)localObject1).setBounds(0, 0, i3, i3);
              localObject7 = new com.tencent.mm.ui.widget.a((Drawable)localObject1);
              localObject8 = new com.tencent.mm.pluginsdk.ui.span.p(((StringBuilder)localObject6).toString(), this.zGX.AAZ, 2);
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
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BaseTimeLineItem", "wrapEmojiInfo:%s hit cache", new Object[] { ((StringBuilder)localObject6).toString() });
            }
            label1895:
            ((View)localObject1).setBackgroundResource(2131234100);
            break label750;
            label1906:
            ((View)localObject1).setPadding(com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 8), com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 6), com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 0), com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 3));
            if (paramBaseViewHolder.AMH)
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
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/item/BaseTimeLineItem$8", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
                localObject = new int[2];
                if ((paramAnonymousView.getTag(2131306044) instanceof int[])) {}
                for (paramAnonymousView = (int[])paramAnonymousView.getTag(2131306044);; paramAnonymousView = (View)localObject)
                {
                  BaseTimeLineItem.this.zGX.egu().a(this.AHH, BaseTimeLineItem.this.zGX.zGs.APZ, BaseTimeLineItem.this.zGX.zGs.APL, paramAnonymousView[0], paramAnonymousView[1]);
                  com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sns/ui/item/BaseTimeLineItem$8", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                  AppMethodBeat.o(100050);
                  return true;
                }
              }
            });
            ((View)localObject1).setOnClickListener(new i.a(this.zGX.AAQ, localdgh, str2, str3, paramBaseViewHolder));
            break label814;
            if (i != 0)
            {
              paramList = com.tencent.mm.plugin.sns.j.e.zKO;
              i = paramBaseViewHolder.position;
              l = localbi.zlW.field_snsId;
              paramb = localStringBuilder2.toString();
              localObject2 = localStringBuilder1.toString();
              paramBaseViewHolder = r.zV(l);
              if (paramList.zLb.get(paramBaseViewHolder) == null)
              {
                localObject1 = new fa();
                ((fa)localObject1).elg = ((fa)localObject1).t("PublishId", paramBaseViewHolder, true);
                ((fa)localObject1).elh = ((fa)localObject1).t("CommentIdList", (String)localObject2, true);
                ((fa)localObject1).eli = ((fa)localObject1).t("EmojiIdList", paramb, true);
                paramb = new e.a(paramList);
                paramb.position = i;
                paramb.zLF = ((fa)localObject1);
                paramList.zLb.put(paramBaseViewHolder, paramb);
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
  
  private as.b bp(String paramString, long paramLong)
  {
    if (this.AMg.size() <= 0) {
      return null;
    }
    Iterator localIterator = this.AMg.iterator();
    while (localIterator.hasNext())
    {
      as.b localb = (as.b)localIterator.next();
      if ((localb.id != null) && (localb.id.equals(as.jw(paramString, String.valueOf(paramLong))))) {
        return localb;
      }
    }
    return null;
  }
  
  public static void i(BaseViewHolder paramBaseViewHolder)
  {
    if ((paramBaseViewHolder != null) && (paramBaseViewHolder.AMq != null))
    {
      paramBaseViewHolder.AMq.Sa(1);
      paramBaseViewHolder.AMq.setVisibility(0);
    }
  }
  
  public static void j(BaseViewHolder paramBaseViewHolder)
  {
    if ((paramBaseViewHolder != null) && (paramBaseViewHolder.AMq != null)) {
      paramBaseViewHolder.AMq.setVisibility(8);
    }
  }
  
  public final View a(Activity paramActivity, BaseViewHolder paramBaseViewHolder, int paramInt, bh parambh, com.tencent.mm.plugin.sns.storage.p paramp)
  {
    this.mActivity = paramActivity;
    this.oOD = paramInt;
    this.zGX = parambh;
    paramBaseViewHolder.dAg = paramp.getSnsId();
    Object localObject;
    View localView;
    switch (paramInt)
    {
    case 17: 
    case 18: 
    default: 
      localObject = "R.layout.sns_media_sub_item2";
      com.tencent.mm.kiss.a.b.akR();
      localView = com.tencent.mm.kiss.a.b.c(this.mActivity, 2131495612);
      paramBaseViewHolder.ANu = localView;
      paramBaseViewHolder.ANt = ((String)localObject);
      localObject = localView.findViewById(2131300969);
      if (!(localObject instanceof ViewStub)) {
        break;
      }
    }
    for (paramBaseViewHolder.AMs = ((ViewStub)localObject);; paramBaseViewHolder.AMs = null)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BaseTimeLineItem", "create new item  " + paramInt + "  " + localView.hashCode());
      paramBaseViewHolder.ANm = localView.findViewById(2131305085);
      paramBaseViewHolder.oOD = paramInt;
      paramBaseViewHolder.AMl = ((SnsAvatarImageView)localView.findViewById(2131296533));
      paramBaseViewHolder.AMl.setWeakContext(paramActivity);
      paramBaseViewHolder.AMl.setOnClickListener(parambh.zGs.APM);
      paramBaseViewHolder.AMl.setOnLongClickListener(parambh.zGs.APN);
      paramBaseViewHolder.AMl.setOnTouchListener(new BaseTimeLineItem.1(this));
      paramBaseViewHolder.AMm = ((AsyncTextView)localView.findViewById(2131302867));
      paramBaseViewHolder.AMn = ((ImageView)localView.findViewById(2131306175));
      paramBaseViewHolder.AMm.setOnTouchListener(new com.tencent.mm.plugin.sns.ui.ae());
      paramBaseViewHolder.AMo = ((ViewGroup)localView.findViewById(2131302862));
      paramBaseViewHolder.AMp = ((AsyncNormalTextView)localView.findViewById(2131299001));
      paramBaseViewHolder.AMp.setOpClickListener(parambh.ABf);
      paramBaseViewHolder.AMp.setShrinkOrSpreadListener(parambh.ABg);
      paramBaseViewHolder.AMr = ((LinearLayout)localView.findViewById(2131300970));
      paramBaseViewHolder.AMr.setTag(paramBaseViewHolder);
      paramBaseViewHolder.AMr.setOnClickListener(parambh.zGs.AQy);
      localObject = localView.findViewById(2131299008);
      parambh.egu().c((View)localObject, parambh.zGs.APO, parambh.zGs.APL);
      localObject = (TextView)localView.findViewById(2131299009);
      parambh.egu().c((View)localObject, parambh.zGs.APO, parambh.zGs.APL);
      paramBaseViewHolder.AMq = ((SnsTranslateResultView)localView.findViewById(2131305091));
      paramBaseViewHolder.AMq.setVisibility(8);
      paramBaseViewHolder.AMq.getSplitlineView().setPadding(0, 0, 0, 0);
      paramBaseViewHolder.AMq.getResultTextView().setBackgroundResource(2131234100);
      parambh.egu().c(paramBaseViewHolder.AMq.getResultTextView(), parambh.zGs.APO, parambh.zGs.APL);
      paramBaseViewHolder.AML = ((LinearLayout)localView.findViewById(2131298526));
      paramBaseViewHolder.AMz = ((TextView)localView.findViewById(2131306999));
      paramBaseViewHolder.timeTv = ((TextView)localView.findViewById(2131296598));
      paramBaseViewHolder.AMB = ((AsyncTextView)localView.findViewById(2131296528));
      paramBaseViewHolder.AMC = ((AsyncTextView)localView.findViewById(2131296527));
      paramBaseViewHolder.AyU = ((TextView)localView.findViewById(2131296531));
      paramBaseViewHolder.ztd = new bn(localView);
      paramBaseViewHolder.ztd.a(parambh.zGs.APX, parambh.zGs.AQn);
      paramBaseViewHolder.AMy = ((RelativeLayout)localView.findViewById(2131303033));
      paramBaseViewHolder.AMy.setOnClickListener(parambh.zGs.AQq);
      paramBaseViewHolder.Ais = ((TextView)localView.findViewById(2131296566));
      paramBaseViewHolder.Ais.setText(paramActivity.getString(2131755707));
      paramBaseViewHolder.Ais.setOnClickListener(parambh.zGs.APR);
      paramBaseViewHolder.AMB.setOnClickListener(parambh.zGs.AQo);
      paramBaseViewHolder.AMC.setOnClickListener(parambh.zGs.AQp);
      paramBaseViewHolder.AyU.setOnClickListener(parambh.zGs.AQk);
      paramBaseViewHolder.AMD = localView.findViewById(2131296570);
      paramBaseViewHolder.AMD.setOnClickListener(parambh.zGs.APW);
      paramBaseViewHolder.AMA = ((WeImageView)localView.findViewById(2131296627));
      paramBaseViewHolder.iFN = ((TextView)localView.findViewById(2131296569));
      paramBaseViewHolder.AME = ((ImageView)localView.findViewById(2131296599));
      paramBaseViewHolder.AMO = ((ViewStub)localView.findViewById(2131296561));
      paramBaseViewHolder.Afr = ((LinearLayout)localView.findViewById(2131296590));
      paramBaseViewHolder.ANo = ((ViewStub)localView.findViewById(2131296572));
      paramBaseViewHolder.ANw = ((ViewStub)localView.findViewById(2131305093));
      paramBaseViewHolder.ANA = ((ViewStub)localView.findViewById(2131308006));
      paramBaseViewHolder.iOJ = ((ViewGroup)localView.findViewById(2131304988));
      paramBaseViewHolder.AMQ = ((ViewStub)localView.findViewById(2131305041));
      paramBaseViewHolder.AMu = ((TextView)localView.findViewById(2131300513));
      paramBaseViewHolder.AMu.setOnClickListener(parambh.zGs.APS);
      BaseViewHolder.a(paramBaseViewHolder, (TextView)localView.findViewById(2131300687));
      paramBaseViewHolder.uan = localView;
      if (this.Arr)
      {
        com.tencent.mm.plugin.sns.abtest.c.b(localView, paramBaseViewHolder);
        com.tencent.mm.plugin.sns.abtest.a.a(localView, paramBaseViewHolder);
        ah.dXv();
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
    paramp = paramp.ebP();
    bi localbi = (bi)this.zGX.egs().edv().get(Integer.valueOf(paramInt));
    a(paramBaseViewHolder, paramInt, localbi, paramp, paramBaseViewHolder.oOD, this.zGX);
    a(localbi, paramp);
  }
  
  public final void a(final BaseViewHolder paramBaseViewHolder, int paramInt1, com.tencent.mm.plugin.sns.storage.p paramp, TimeLineObject paramTimeLineObject, int paramInt2, final bh parambh)
  {
    Object localObject2 = (bi)parambh.egs().edv().get(Integer.valueOf(paramInt1));
    a(paramBaseViewHolder, paramp);
    this.oOD = paramInt2;
    this.zGX = parambh;
    if (this.Arr) {
      com.tencent.mm.plugin.sns.ui.a.c.S(paramp);
    }
    com.tencent.mm.plugin.sns.ui.a.c.h(paramTimeLineObject);
    com.tencent.mm.plugin.sns.ui.a.c.g(paramTimeLineObject);
    if (paramp.Rt(32)) {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BaseTimeLineItem", "the ad sns id is " + r.zW(paramp.field_snsId) + " for susan");
    }
    paramBaseViewHolder.AMj = ((bi)localObject2).ADP;
    paramBaseViewHolder.ulU = false;
    paramBaseViewHolder.position = paramInt1;
    paramBaseViewHolder.dAg = ((bi)localObject2).ADO;
    paramBaseViewHolder.dqc = ((bi)localObject2).AhK;
    paramBaseViewHolder.AMk = ((bi)localObject2).ADT;
    paramBaseViewHolder.AME.setOnClickListener(parambh.ABe);
    paramBaseViewHolder.timeLineObject = paramTimeLineObject;
    Object localObject3 = ((bi)localObject2).zlV;
    paramBaseViewHolder.snsobj = ((SnsObject)localObject3);
    Object localObject1 = parambh.AAQ.Agj.zCa;
    Object localObject4;
    if (paramp != null)
    {
      localObject4 = paramp.eco();
      ((com.tencent.mm.plugin.sns.j.b)localObject1).zKm.add(localObject4);
      if (paramp.Rt(32)) {
        ((com.tencent.mm.plugin.sns.j.b)localObject1).zKr.add(localObject4);
      }
      ((com.tencent.mm.plugin.sns.j.b)localObject1).zKs.add(paramp.field_userName);
    }
    int i;
    label605:
    Object localObject5;
    switch (paramp.field_type)
    {
    default: 
      ((com.tencent.mm.plugin.sns.j.b)localObject1).zKx.add(localObject4);
      if (paramInt1 < ((com.tencent.mm.plugin.sns.j.b)localObject1).zKk)
      {
        ((com.tencent.mm.plugin.sns.j.b)localObject1).zKk = paramInt1;
        ((com.tencent.mm.plugin.sns.j.b)localObject1).zIP = r.o(paramp);
      }
      if (paramInt1 > ((com.tencent.mm.plugin.sns.j.b)localObject1).zKl)
      {
        ((com.tencent.mm.plugin.sns.j.b)localObject1).zKl = paramInt1;
        ((com.tencent.mm.plugin.sns.j.b)localObject1).zIQ = r.o(paramp);
      }
      ((com.tencent.mm.plugin.sns.j.b)localObject1).zIV = ((com.tencent.mm.plugin.sns.j.b)localObject1).zKn.size();
      ((com.tencent.mm.plugin.sns.j.b)localObject1).zIW = ((com.tencent.mm.plugin.sns.j.b)localObject1).zKo.size();
      ((com.tencent.mm.plugin.sns.j.b)localObject1).zIX = ((com.tencent.mm.plugin.sns.j.b)localObject1).zKp.size();
      ((com.tencent.mm.plugin.sns.j.b)localObject1).zIZ = ((com.tencent.mm.plugin.sns.j.b)localObject1).zKq.size();
      ((com.tencent.mm.plugin.sns.j.b)localObject1).zIY = ((com.tencent.mm.plugin.sns.j.b)localObject1).zKr.size();
      ((com.tencent.mm.plugin.sns.j.b)localObject1).zJa = ((com.tencent.mm.plugin.sns.j.b)localObject1).zKv.size();
      ((com.tencent.mm.plugin.sns.j.b)localObject1).zJi = ((com.tencent.mm.plugin.sns.j.b)localObject1).zKw.size();
      ((com.tencent.mm.plugin.sns.j.b)localObject1).oec = ((com.tencent.mm.plugin.sns.j.b)localObject1).zKs.size();
      ((com.tencent.mm.plugin.sns.j.b)localObject1).zIT = ((com.tencent.mm.plugin.sns.j.b)localObject1).zKt.size();
      ((com.tencent.mm.plugin.sns.j.b)localObject1).zIU = ((com.tencent.mm.plugin.sns.j.b)localObject1).zKu.size();
      ((com.tencent.mm.plugin.sns.j.b)localObject1).zJh = ((com.tencent.mm.plugin.sns.j.b)localObject1).zKx.size();
      ((com.tencent.mm.plugin.sns.j.b)localObject1).zID = ((com.tencent.mm.plugin.sns.j.b)localObject1).zKm.size();
      localObject4 = ((bi)localObject2).zow;
      localObject1 = ((bi)localObject2).lJm;
      if (!bu.isNullOrNil((String)localObject1))
      {
        paramBaseViewHolder.AfX = ((bi)localObject2).ADN;
        paramBaseViewHolder.AMl.setTag(localObject1);
        if (paramBaseViewHolder.AfX != null) {
          if ((an.aUq((String)localObject1)) && ("3552365301".equals(paramBaseViewHolder.AfX.field_openImAppid)))
          {
            i = 1;
            if ((localObject4 == null) || (!((com.tencent.mm.plugin.sns.storage.b)localObject4).zNN)) {
              break label3165;
            }
            paramBaseViewHolder.AMl.setImageResource(2131231875);
            paramBaseViewHolder.AMl.fn((String)localObject1, 4);
            paramBaseViewHolder.AMl.setShowStoryHint(false);
            if (!bu.isNullOrNil(((com.tencent.mm.plugin.sns.storage.b)localObject4).zNP))
            {
              localObject5 = h.jL("adId", ((com.tencent.mm.plugin.sns.storage.b)localObject4).zNP);
              paramBaseViewHolder.AMl.setTag(2131305044, ((com.tencent.mm.plugin.sns.storage.b)localObject4).zNP);
              if (!o.fB((String)localObject5)) {
                break label3144;
              }
              localObject4 = com.tencent.mm.plugin.sns.ad.e.m.zqi.getBitmap((String)localObject5);
              if (localObject4 != null) {
                paramBaseViewHolder.AMl.setImageBitmap((Bitmap)localObject4);
              }
            }
            label717:
            paramBaseViewHolder.AMm.a((String)localObject1, ((bi)localObject2).AEd, new p.a()
            {
              public final void b(View paramAnonymousView, Object paramAnonymousObject)
              {
                AppMethodBeat.i(100048);
                if (parambh.Asf != null)
                {
                  parambh.Asf.doj = 0;
                  parambh.Asf.b(paramAnonymousView, paramAnonymousObject);
                }
                AppMethodBeat.o(100048);
              }
            }, ((bi)localObject2).AfT, ((bi)localObject2).AhK, paramInt2, ((bi)localObject2).AfT);
            paramBaseViewHolder.AMl.hjr = ((bi)localObject2).AhK;
          }
        }
      }
      break;
    }
    for (;;)
    {
      paramBaseViewHolder.AMn.setVisibility(8);
      if (((bi)localObject2).AfT)
      {
        paramBaseViewHolder.isAd = true;
        paramBaseViewHolder.ulU = ((bi)localObject2).ADU;
        label801:
        paramBaseViewHolder.AMp.a(((bi)localObject2).ADQ, parambh, ((bi)localObject2).ADR, (bi)localObject2);
        paramBaseViewHolder.AMp.setShow(paramBaseViewHolder);
        paramBaseViewHolder.iFN.setOnTouchListener(new com.tencent.mm.plugin.sns.ui.ae());
        a(paramBaseViewHolder, paramInt1, (bi)localObject2, paramTimeLineObject, paramInt2, parambh);
        a((bi)localObject2, paramTimeLineObject);
        parambh.AAS.put(Integer.valueOf(paramInt1), new WeakReference(paramBaseViewHolder.uan));
        if (paramBaseViewHolder.uan.getBackground() == null)
        {
          paramBaseViewHolder.uan.setBackgroundResource(2131231818);
          paramInt1 = com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 12);
          int j = com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 8);
          paramBaseViewHolder.uan.setPadding(paramInt1, paramInt1, paramInt1, j);
        }
        paramBaseViewHolder.timeTv.setText(((bi)localObject2).ADW);
        paramBaseViewHolder.AMB.setVisibility(8);
        paramBaseViewHolder.AMC.setVisibility(8);
        if (((bi)localObject2).AfT)
        {
          localObject4 = ((bi)localObject2).ADX;
          paramBaseViewHolder.AMB.setTag(((bi)localObject2).AhK);
          if (((bi)localObject2).ADX.zMa != com.tencent.mm.plugin.sns.storage.a.zLM) {
            break label3470;
          }
          if (bu.isNullOrNil(((bi)localObject2).AEa)) {
            break label3458;
          }
          paramBaseViewHolder.AMB.setText(((bi)localObject2).AEa);
          paramBaseViewHolder.AMB.setVisibility(0);
          label1044:
          if ((((com.tencent.mm.plugin.sns.storage.a)localObject4).zMg == 1) && (!bu.isNullOrNil(((com.tencent.mm.plugin.sns.storage.a)localObject4).zMb)))
          {
            paramBaseViewHolder.AMB.setText(((com.tencent.mm.plugin.sns.storage.a)localObject4).zMb);
            paramBaseViewHolder.AMB.setVisibility(0);
          }
          label1084:
          if ((paramBaseViewHolder.AMB.getVisibility() != 8) && (bu.isNullOrNil(((com.tencent.mm.plugin.sns.storage.a)localObject4).zMc)))
          {
            paramBaseViewHolder.AMB.setTextColor(this.mActivity.getResources().getColor(2131100943));
            paramBaseViewHolder.AMB.setOnClickListener(null);
          }
          if ((paramp.ebP().HUG.Gty & 0x4) == 0) {
            break label3785;
          }
          paramBaseViewHolder.AMC.setTag(paramBaseViewHolder);
          paramBaseViewHolder.AMC.setVisibility(0);
          paramBaseViewHolder.AMC.setText(String.format("%s%s%s", new Object[] { this.mActivity.getResources().getString(2131763743), ((bi)localObject2).AEd, this.mActivity.getResources().getString(2131763744) }));
        }
        label1223:
        if (!((bi)localObject2).AEg) {
          break label3797;
        }
        localObject1 = parambh.fNT.getString(2131760986, new Object[] { Integer.valueOf(((bi)localObject2).AEh) });
        BaseViewHolder.k(paramBaseViewHolder).setText((CharSequence)localObject1);
        BaseViewHolder.k(paramBaseViewHolder).setVisibility(0);
        label1276:
        paramBaseViewHolder.AyU.setTag(((bi)localObject2).AhK);
        if (bu.isNullOrNil(((bi)localObject2).AEj)) {
          break label3849;
        }
        paramBaseViewHolder.AyU.setVisibility(0);
        paramBaseViewHolder.AyU.setText(((bi)localObject2).AEj);
        paramBaseViewHolder.AyU.setClickable(((bi)localObject2).AEk);
        localObject1 = paramBaseViewHolder.AyU;
        if (!((bi)localObject2).AEk) {
          break label3809;
        }
        paramInt1 = this.mActivity.getResources().getColor(2131100914);
        label1359:
        ((TextView)localObject1).setTextColor(paramInt1);
        if (!((bi)localObject2).AEk) {
          break label3826;
        }
        paramBaseViewHolder.AyU.setBackground(this.mActivity.getResources().getDrawable(2131234100));
        label1393:
        if (!((bi)localObject2).AEr) {
          break label3861;
        }
        paramBaseViewHolder.AMA.setVisibility(0);
        paramBaseViewHolder.AMA.setImageResource(2131690597);
        paramBaseViewHolder.AMA.setIconColor(this.mActivity.getResources().getColor(2131099660));
        label1439:
        paramBaseViewHolder.iFN.setTextColor(this.mActivity.getResources().getColor(2131100914));
        if (!((bi)localObject2).AEl) {
          break label3878;
        }
        paramBaseViewHolder.iFN.setVisibility(0);
        localObject1 = this.mActivity.getString(2131763791) + ((bi)localObject2).mAppName;
        if ((paramTimeLineObject == null) || (paramTimeLineObject.HUG == null) || (paramTimeLineObject.HUG.Gtw != 28)) {
          break label3873;
        }
        paramInt1 = 1;
        label1536:
        if ((((String)localObject1).length() <= 10) || (paramInt1 != 0)) {
          break label5546;
        }
        localObject1 = ((String)localObject1).substring(0, 10) + "...";
      }
      label1684:
      label1948:
      label2207:
      label3873:
      label3878:
      label5546:
      for (;;)
      {
        localObject1 = new SpannableString((CharSequence)localObject1);
        ((SpannableString)localObject1).setSpan(new b(), 0, ((SpannableString)localObject1).length(), 33);
        paramBaseViewHolder.iFN.setText((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
        if ((!((bi)localObject2).AEn) && (!"wx7fa037cc7dfabad5".equals(paramTimeLineObject.HUF.Id)))
        {
          paramBaseViewHolder.iFN.setTextColor(this.mActivity.getResources().getColor(2131100943));
          paramBaseViewHolder.iFN.setOnTouchListener(null);
        }
        paramBaseViewHolder.iFN.setTag(paramTimeLineObject);
        if (((bi)localObject2).AEf)
        {
          paramBaseViewHolder.Ais.setVisibility(0);
          paramBaseViewHolder.Ais.setTag(((bi)localObject2).AhK);
          label1712:
          paramBaseViewHolder.AME.setTag(paramBaseViewHolder);
          if (!((bi)localObject2).AEs) {
            break label4278;
          }
          if (!paramBaseViewHolder.AMV)
          {
            paramBaseViewHolder.AMJ = ((LinearLayout)paramBaseViewHolder.AMQ.inflate());
            paramBaseViewHolder.AMK = paramBaseViewHolder.uan.findViewById(2131303358);
            paramBaseViewHolder.AMV = true;
            paramBaseViewHolder.AMK.setTag(((bi)localObject2).AhK);
            paramBaseViewHolder.zWK = ((TextView)paramBaseViewHolder.AMJ.findViewById(2131303358));
          }
          paramBaseViewHolder.AMQ.setVisibility(0);
          paramBaseViewHolder.AMK.setOnClickListener(parambh.zGs.APV);
          switch (((bi)localObject2).AEt)
          {
          default: 
            paramBaseViewHolder.zWK.setText(2131763946);
            paramBaseViewHolder.AMK.setClickable(true);
            paramBaseViewHolder.AMK.setEnabled(true);
            label1886:
            paramTimeLineObject = paramp.ech();
            if ((paramTimeLineObject != null) && (!bu.isNullOrNil(paramTimeLineObject.HmW))) {
              paramBaseViewHolder.zWK.setText(paramTimeLineObject.HmW);
            }
            if (((bi)localObject2).AEu)
            {
              paramBaseViewHolder.AMD.setVisibility(0);
              paramBaseViewHolder.AMD.setTag(((bi)localObject2).AhK);
              if (!((bi)localObject2).AEv) {
                break label4400;
              }
              if (bu.isNullOrNil(((bi)localObject2).AEw)) {
                break label4339;
              }
              paramBaseViewHolder.AMz.setVisibility(0);
              if (paramInt2 != 7) {
                break label4309;
              }
              paramTimeLineObject = String.format(this.mActivity.getString(2131764038), new Object[] { ((bi)localObject2).AEw });
              label2009:
              paramTimeLineObject = com.tencent.mm.pluginsdk.ui.span.k.b(this.mActivity, paramTimeLineObject, paramBaseViewHolder.AMz.getTextSize());
              paramBaseViewHolder.AMz.setText(paramTimeLineObject);
              label2036:
              if (!((bi)localObject2).AEy) {
                break label4412;
              }
              if (paramBaseViewHolder.ANp == null)
              {
                paramBaseViewHolder.ANp = paramBaseViewHolder.ANo.inflate();
                paramBaseViewHolder.zvV = ((TextView)paramBaseViewHolder.ANp.findViewById(2131296573));
                paramBaseViewHolder.ANq = ((MaskTextView)paramBaseViewHolder.ANp.findViewById(2131296574));
                paramBaseViewHolder.ANq.setOnTouchListener(new com.tencent.mm.plugin.sns.ui.ae());
              }
              paramBaseViewHolder.ANp.setVisibility(0);
              a(paramBaseViewHolder.ANq, ((bi)localObject2).AEB, paramInt2);
              paramTimeLineObject = this.mActivity.getString(2131763903, new Object[] { Integer.valueOf(((bi)localObject2).AEz), bu.C(((bi)localObject2).AEA / 100.0D) });
              paramBaseViewHolder.zvV.setText(paramTimeLineObject);
              paramBaseViewHolder.ANp.setTag(paramp);
              paramBaseViewHolder.ANp.setOnClickListener(parambh.zGs.APY);
              if (((((bi)localObject2).AEC != null) && (((bi)localObject2).AEC.size() != 0)) || ((((bi)localObject2).AED != null) && (((bi)localObject2).AED.size() != 0))) {
                break label4450;
              }
              if (paramBaseViewHolder.Afr == null) {
                break label4431;
              }
              paramBaseViewHolder.Afr.setVisibility(8);
              label2261:
              if (!((bi)localObject2).AEE) {
                break label4874;
              }
              paramBaseViewHolder.AMu.setTag(((bi)localObject2).AhK);
              paramBaseViewHolder.AMu.setText(((bi)localObject2).AEF);
              paramBaseViewHolder.AMu.setVisibility(0);
              label2301:
              if (!((bi)localObject2).AfT) {
                break label4891;
              }
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BaseTimeLineItem", "adatag " + ((bi)localObject2).ADZ);
              paramBaseViewHolder.ztd.H(Long.valueOf(((bi)localObject2).ADP), new com.tencent.mm.plugin.sns.data.b(paramBaseViewHolder.ztd, paramBaseViewHolder.position, ((bi)localObject2).AhK, ((bi)localObject2).ADP, ((bi)localObject2).ADV));
              paramBaseViewHolder.ztd.b(((bi)localObject2).ADY, ((bi)localObject2).ADX);
              paramBaseViewHolder.ztd.setVisibility(0);
              if ((paramBaseViewHolder.AyU != null) && (paramBaseViewHolder.AyU.getVisibility() == 0))
              {
                if (paramBaseViewHolder.ztd.AHb.getVisibility() != 0) {
                  break label4886;
                }
                paramInt1 = 1;
                if (paramInt1 != 0)
                {
                  paramTimeLineObject = (LinearLayout.LayoutParams)paramBaseViewHolder.AyU.getLayoutParams();
                  paramTimeLineObject.setMargins(paramTimeLineObject.leftMargin, BackwardSupportUtil.b.h(this.mActivity, 0.0F), paramTimeLineObject.rightMargin, paramTimeLineObject.bottomMargin);
                  paramBaseViewHolder.AyU.setLayoutParams(paramTimeLineObject);
                }
              }
              paramBaseViewHolder.AMy.setVisibility(8);
              label2499:
              if (this.Arr) {
                ah.dXv().a(this.mActivity, (SnsObject)localObject3, paramBaseViewHolder);
              }
              paramTimeLineObject = ah.dXN();
              long l = paramp.field_snsId;
              if ((!paramTimeLineObject.zDj) || (l == 0L) || (paramTimeLineObject.zDC) || (paramTimeLineObject.zDt <= paramTimeLineObject.zDn) || (paramTimeLineObject.zDG == null) || (paramTimeLineObject.zDG.state != 1) || (paramTimeLineObject.zDG.zIa < paramTimeLineObject.zDo) || (!paramTimeLineObject.zDy)) {
                break label4964;
              }
              if ((paramTimeLineObject.zDr != 0L) && (ch.aDd() - paramTimeLineObject.zDF.zDJ <= paramTimeLineObject.zDr)) {
                break label4959;
              }
              paramInt1 = 1;
              label2644:
              if ((paramInt1 == 0) || (l != paramTimeLineObject.zDH)) {
                break label4964;
              }
              paramInt1 = 1;
              label2661:
              if (paramInt1 == 0) {
                break label4969;
              }
              if (!paramBaseViewHolder.ANv)
              {
                paramBaseViewHolder.ANx = ((LinearLayout)paramBaseViewHolder.ANw.inflate());
                paramBaseViewHolder.ANv = true;
                paramBaseViewHolder.ANy = ((ViewGroup)paramBaseViewHolder.ANx.findViewById(2131305092));
              }
              paramBaseViewHolder.ANw.setVisibility(0);
              paramBaseViewHolder.iOJ.setBackgroundColor(0);
              paramBaseViewHolder.ANy.setTag(Long.valueOf(paramp.field_snsId));
              ah.dXN().eU(paramBaseViewHolder.ANy);
              paramBaseViewHolder.ANy.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(179352);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bd(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/item/BaseTimeLineItem$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
                  BaseTimeLineItem.this.zGX.AAQ.edg();
                  com.tencent.mm.plugin.sns.j.e.zKO.zLw.eqr = 1L;
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/item/BaseTimeLineItem$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(179352);
                }
              });
              com.tencent.mm.plugin.report.service.g.yxI.dD(1295, 1);
              label2773:
              ah.dXO();
              if (!com.tencent.mm.plugin.sns.model.ar.p(paramp.field_snsId, paramp.field_createTime, paramp.AdJ)) {
                break label5012;
              }
              if (!paramBaseViewHolder.ANz)
              {
                paramBaseViewHolder.ANB = ((LinearLayout)paramBaseViewHolder.ANA.inflate());
                paramBaseViewHolder.ANz = true;
                paramBaseViewHolder.ANC = ((TextView)paramBaseViewHolder.ANB.findViewById(2131308003));
              }
              paramBaseViewHolder.ANA.setVisibility(0);
              paramBaseViewHolder.iOJ.setBackgroundColor(0);
              paramBaseViewHolder.ANC.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(220081);
                  Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
                  ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/item/BaseTimeLineItem$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
                  paramAnonymousView = ah.dXO();
                  localObject1 = paramBaseViewHolder.ANC.getContext();
                  Object localObject2;
                  Parcel localParcel;
                  if (com.tencent.mm.plugin.sns.model.ar.zCQ)
                  {
                    paramAnonymousView.zCU = null;
                    paramAnonymousView.zCV = "";
                    com.tencent.mm.sdk.platformtools.ae.i(com.tencent.mm.plugin.sns.model.ar.TAG, "goRetryEdit draftKey:%s", new Object[] { paramAnonymousView.zCT });
                    localObject2 = ah.dXL().aBs(paramAnonymousView.zCT);
                    if (localObject2 != null)
                    {
                      localObject2 = ((com.tencent.mm.plugin.sns.storage.l)localObject2).field_draft;
                      if (!bu.cF((byte[])localObject2))
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
                    com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahE(), "com/tencent/mm/plugin/sns/model/SnsRetryEditTipManager", "goRetryEdit", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mt(0));
                    com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/sns/model/SnsRetryEditTipManager", "goRetryEdit", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    paramAnonymousView.reset();
                    com.tencent.mm.sdk.platformtools.ar.ay(paramAnonymousView.zCW);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/item/BaseTimeLineItem$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(220081);
                    return;
                  }
                  catch (Exception localException)
                  {
                    for (;;)
                    {
                      ah.dXL().b(paramAnonymousView.zCT, null, 0);
                    }
                  }
                }
              });
            }
            break;
          }
        }
        label3144:
        label3165:
        Object localObject6;
        label3253:
        label3398:
        label3785:
        label3797:
        label3809:
        label3826:
        label4339:
        boolean bool;
        for (;;)
        {
          paramp = new bd(((bi)localObject2).ADO, ((bi)localObject2).AhK, false, true, 1);
          paramBaseViewHolder.AMq.getResultTextView().setTag(paramp);
          paramp = new StringBuilder("");
          if ((((bi)localObject2).AEC == null) || (((bi)localObject2).AEC.size() <= 0)) {
            break label5041;
          }
          paramp.append(ak.getContext().getResources().getString(2131767182)).append(":");
          paramInt1 = 0;
          while (paramInt1 < ((bi)localObject2).AEC.size())
          {
            paramTimeLineObject = (com.tencent.mm.vending.j.a)((bi)localObject2).AEC.get(paramInt1);
            if (paramTimeLineObject != null) {
              paramp.append((String)paramTimeLineObject.get(1)).append(",");
            }
            paramInt1 += 1;
          }
          ((com.tencent.mm.plugin.sns.j.b)localObject1).zKo.add(localObject4);
          break;
          ((com.tencent.mm.plugin.sns.j.b)localObject1).zKn.add(localObject4);
          break;
          ((com.tencent.mm.plugin.sns.j.b)localObject1).zKq.add(localObject4);
          break;
          ((com.tencent.mm.plugin.sns.j.b)localObject1).zKp.add(localObject4);
          break;
          ((com.tencent.mm.plugin.sns.j.b)localObject1).zKv.add(localObject4);
          break;
          ((com.tencent.mm.plugin.sns.j.b)localObject1).zKw.add(localObject4);
          break;
          if (!bu.isNullOrNil(paramTimeLineObject.HUH))
          {
            ((com.tencent.mm.plugin.sns.j.b)localObject1).zKt.add(localObject4);
            break;
          }
          ((com.tencent.mm.plugin.sns.j.b)localObject1).zKu.add(localObject4);
          break;
          i = 0;
          break label605;
          h.a(((com.tencent.mm.plugin.sns.storage.b)localObject4).zNP, false, new f.a()
          {
            public final void ayY(String paramAnonymousString)
            {
              AppMethodBeat.i(100047);
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BaseTimeLineItem", "download img %s", new Object[] { paramAnonymousString });
              String str = (String)paramBaseViewHolder.AMl.getTag(2131305044);
              if ((!bu.V(new String[] { str, paramAnonymousString })) && (paramAnonymousString.equals(h.jL("adId", str))))
              {
                paramAnonymousString = com.tencent.mm.plugin.sns.ad.e.m.zqi.getBitmap(paramAnonymousString);
                if (paramAnonymousString != null) {
                  paramBaseViewHolder.AMl.setImageBitmap(paramAnonymousString);
                }
              }
              AppMethodBeat.o(100047);
            }
            
            public final void dVu() {}
            
            public final void dVv() {}
          });
          break label717;
          if (!((String)localObject1).endsWith("@ad")) {
            if (((bi)localObject2).AEe)
            {
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BaseTimeLineItem", "getContact %s", new Object[] { localObject1 });
              if (a.b.ffl().LT() != null) {
                paramBaseViewHolder.AMl.setImageBitmap(a.b.ffl().LT());
              }
              au.a.hIG.a((String)localObject1, "", new bh.c(parambh.egs(), paramInt1));
              if (((bi)localObject2).AEf) {
                break label3398;
              }
              com.tencent.mm.plugin.sns.ui.e.a.b(4, (String)paramBaseViewHolder.AMl.getTag(), paramBaseViewHolder.AMl);
              paramBaseViewHolder.AMl.fn((String)localObject1, 4);
              paramBaseViewHolder.AMl.setTag(localObject1);
              com.tencent.mm.plugin.sns.ui.e.a.a(4, (String)localObject1, paramBaseViewHolder.AMl);
              paramBaseViewHolder.AMl.setShowStoryHint(((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).hasNewStory((String)localObject1));
            }
          }
          for (;;)
          {
            paramBaseViewHolder.AMm.setContactInfo(paramBaseViewHolder.AfX);
            paramBaseViewHolder.AMm.a((String)localObject1, ((bi)localObject2).AEd, new p.a()
            {
              public final void b(View paramAnonymousView, Object paramAnonymousObject)
              {
                AppMethodBeat.i(100049);
                if (parambh.Asf != null) {
                  if (!(paramAnonymousObject instanceof com.tencent.mm.plugin.sns.data.a)) {
                    break label78;
                  }
                }
                label78:
                for (boolean bool = ((com.tencent.mm.plugin.sns.data.a)paramAnonymousObject).isAd;; bool = false)
                {
                  if (bool) {}
                  for (parambh.Asf.doj = 0;; parambh.Asf.doj = 6)
                  {
                    parambh.Asf.b(paramAnonymousView, paramAnonymousObject);
                    AppMethodBeat.o(100049);
                    return;
                  }
                }
              }
            }, ((bi)localObject2).AfT, ((bi)localObject2).AhK, paramInt2, ((bi)localObject2).AfT);
            break;
            a.b.c(paramBaseViewHolder.AMl, (String)localObject1);
            break label3253;
            paramBaseViewHolder.AMl.fn((String)localObject1, 4);
            paramBaseViewHolder.AMl.setShowStoryHint(false);
            continue;
            paramBaseViewHolder.AMl.setImageResource(2131231875);
            paramBaseViewHolder.AMl.fn((String)localObject1, 4);
            paramBaseViewHolder.AMl.setShowStoryHint(false);
          }
          paramBaseViewHolder.isAd = false;
          break label801;
          paramBaseViewHolder.AMB.setVisibility(8);
          break label1044;
          if (((com.tencent.mm.plugin.sns.storage.a)localObject4).zMa != com.tencent.mm.plugin.sns.storage.a.zLN) {
            break label1084;
          }
          if (!bu.isNullOrNil(((bi)localObject2).AEb))
          {
            localObject1 = ((bi)localObject2).AEc;
            localObject5 = ((bi)localObject2).AEb;
            localObject6 = this.mActivity;
            paramBaseViewHolder.AMB.getTextSize();
            localObject6 = new com.tencent.mm.pluginsdk.ui.span.l(com.tencent.mm.pluginsdk.ui.span.k.c((Context)localObject6, (CharSequence)localObject5, 1));
            ((com.tencent.mm.pluginsdk.ui.span.l)localObject6).a(null, (CharSequence)localObject5);
            localObject5 = paramBaseViewHolder.AMB.getPaint();
            float f = Layout.getDesiredWidth((CharSequence)localObject6, 0, ((com.tencent.mm.pluginsdk.ui.span.l)localObject6).length(), (TextPaint)localObject5);
            if (com.tencent.mm.cb.a.aA(this.mActivity, (int)f) > paramBaseViewHolder.Aso) {
              do
              {
                if (((String)localObject1).length() <= 1) {
                  break;
                }
                localObject1 = ((String)localObject1).substring(0, ((String)localObject1).length() - 2);
                localObject6 = String.format(((com.tencent.mm.plugin.sns.storage.a)localObject4).zMb, new Object[] { (String)localObject1 + "..." });
                localObject7 = this.mActivity;
                paramBaseViewHolder.AMB.getTextSize();
                localObject7 = new com.tencent.mm.pluginsdk.ui.span.l(com.tencent.mm.pluginsdk.ui.span.k.c((Context)localObject7, (CharSequence)localObject6, 1));
                ((com.tencent.mm.pluginsdk.ui.span.l)localObject7).a(null, (CharSequence)localObject6);
                f = Layout.getDesiredWidth((CharSequence)localObject7, 0, ((com.tencent.mm.pluginsdk.ui.span.l)localObject7).length(), (TextPaint)localObject5);
                paramInt1 = com.tencent.mm.cb.a.aA(this.mActivity, (int)f);
                paramBaseViewHolder.AMB.setText((CharSequence)localObject7, TextView.BufferType.SPANNABLE);
                paramBaseViewHolder.AMB.setVisibility(0);
              } while (paramInt1 > paramBaseViewHolder.Aso);
            }
          }
          for (;;)
          {
            a((com.tencent.mm.plugin.sns.storage.a)localObject4, paramBaseViewHolder);
            break;
            paramBaseViewHolder.AMB.setText((CharSequence)localObject6, TextView.BufferType.SPANNABLE);
            paramBaseViewHolder.AMB.setVisibility(0);
            continue;
            paramBaseViewHolder.AMB.setVisibility(8);
          }
          paramBaseViewHolder.AMC.setVisibility(8);
          break label1223;
          BaseViewHolder.k(paramBaseViewHolder).setVisibility(8);
          break label1276;
          paramInt1 = this.mActivity.getResources().getColor(2131100212);
          break label1359;
          paramBaseViewHolder.AyU.setBackground(this.mActivity.getResources().getDrawable(2131233299));
          break label1393;
          paramBaseViewHolder.AyU.setVisibility(8);
          break label1393;
          paramBaseViewHolder.AMA.setVisibility(8);
          break label1439;
          paramInt1 = 0;
          break label1536;
          if (((bi)localObject2).AEm)
          {
            paramBaseViewHolder.iFN.setVisibility(0);
            paramTimeLineObject = new SpannableString(((bi)localObject2).AEp);
            paramTimeLineObject.setSpan(new c(), 0, paramTimeLineObject.length(), 33);
            paramBaseViewHolder.iFN.setText(paramTimeLineObject, TextView.BufferType.SPANNABLE);
            paramBaseViewHolder.iFN.setTag(new bl(((bi)localObject2).AEo, ((bi)localObject2).AEp));
            break label1684;
          }
          if (((bi)localObject2).AEq)
          {
            paramBaseViewHolder.iFN.setVisibility(0);
            localObject1 = this.mActivity.getString(2131755318);
            localObject4 = (String)localObject1 + ((bi)localObject2).mAppName;
            localObject5 = new SpannableString((CharSequence)localObject4);
            ((SpannableString)localObject5).setSpan(new ForegroundColorSpan(this.mActivity.getResources().getColor(2131100943)), 0, ((String)localObject1).length(), 33);
            ((SpannableString)localObject5).setSpan(new a(), ((String)localObject1).length(), ((String)localObject4).length(), 33);
            paramBaseViewHolder.iFN.setText((CharSequence)localObject5, TextView.BufferType.SPANNABLE);
            if ((!((bi)localObject2).AEn) && (!"wx7fa037cc7dfabad5".equals(paramTimeLineObject.HUF.Id)))
            {
              paramBaseViewHolder.iFN.setTextColor(this.mActivity.getResources().getColor(2131100943));
              paramBaseViewHolder.iFN.setOnTouchListener(null);
            }
            paramBaseViewHolder.iFN.setTag(paramTimeLineObject);
            break label1684;
          }
          paramBaseViewHolder.iFN.setVisibility(8);
          break label1684;
          paramBaseViewHolder.Ais.setVisibility(8);
          break label1712;
          paramBaseViewHolder.zWK.setText(2131763943);
          paramBaseViewHolder.AMK.setClickable(false);
          paramBaseViewHolder.AMK.setEnabled(false);
          break label1886;
          paramBaseViewHolder.zWK.setText(2131763945);
          paramBaseViewHolder.AMK.setClickable(false);
          paramBaseViewHolder.AMK.setEnabled(false);
          break label1886;
          paramBaseViewHolder.zWK.setText(2131763944);
          paramBaseViewHolder.AMK.setClickable(true);
          paramBaseViewHolder.AMK.setEnabled(true);
          break label1886;
          label4278:
          if (!paramBaseViewHolder.AMV) {
            break label1920;
          }
          paramBaseViewHolder.AMQ.setVisibility(8);
          break label1920;
          paramBaseViewHolder.AMD.setVisibility(8);
          break label1948;
          label4309:
          paramTimeLineObject = String.format(this.mActivity.getString(2131764039), new Object[] { ((bi)localObject2).AEw });
          break label2009;
          if (((bi)localObject2).AEx)
          {
            paramBaseViewHolder.AMz.setVisibility(0);
            paramTimeLineObject = this.mActivity.getString(2131764040);
            paramTimeLineObject = com.tencent.mm.pluginsdk.ui.span.k.b(this.mActivity, paramTimeLineObject.toString(), paramBaseViewHolder.AMz.getTextSize());
            paramBaseViewHolder.AMz.setText(paramTimeLineObject);
            break label2036;
          }
          label4400:
          paramBaseViewHolder.AMz.setVisibility(8);
          break label2036;
          label4412:
          if (paramBaseViewHolder.ANp == null) {
            break label2207;
          }
          paramBaseViewHolder.ANp.setVisibility(8);
          break label2207;
          label4431:
          if (!paramBaseViewHolder.AMP) {
            break label2261;
          }
          paramBaseViewHolder.AMO.setVisibility(8);
          break label2261;
          label4450:
          if (!paramBaseViewHolder.AMP)
          {
            if ((paramBaseViewHolder.Afr != null) || (paramBaseViewHolder.AMO.getParent() == null)) {
              break label4794;
            }
            paramBaseViewHolder.Afr = ((LinearLayout)paramBaseViewHolder.AMO.inflate());
            if (paramBaseViewHolder.Afr != null)
            {
              paramBaseViewHolder.AMG = ((SnsLikesTextView)paramBaseViewHolder.Afr.findViewById(2131296588));
              paramBaseViewHolder.AMG.setLikedTextTouchListener(new com.tencent.mm.plugin.sns.ui.ae());
              paramBaseViewHolder.AMG.setOpClickListener(parambh.ABh);
              paramBaseViewHolder.AMI = ((LinearLayout)paramBaseViewHolder.uan.findViewById(2131296557));
              paramBaseViewHolder.Afr.setTag(((bi)localObject2).ADO);
              paramBaseViewHolder.AMG.setLikeTvTag(((bi)localObject2).ADO);
              paramBaseViewHolder.AMG.setOpTvTag(paramBaseViewHolder);
              paramBaseViewHolder.AMN = paramBaseViewHolder.Afr.findViewById(2131296592);
              paramBaseViewHolder.ANr = paramBaseViewHolder.Afr.findViewById(2131296590);
              paramBaseViewHolder.AMP = true;
            }
          }
          if (paramBaseViewHolder.Afr != null) {
            paramBaseViewHolder.Afr.setVisibility(0);
          }
          if ((((bi)localObject2).AEC != null) && (((bi)localObject2).AEC.size() > 0))
          {
            paramBaseViewHolder.AMG.setVisibility(0);
            parambh.a(((bi)localObject2).AhK, paramBaseViewHolder.AMG);
            paramBaseViewHolder.AMG.a(((bi)localObject2).AEC, paramInt2, parambh, ((bi)localObject2).AhK, parambh.Awv, parambh.Aww, parambh.AAU, (bi)localObject2, paramBaseViewHolder);
            paramBaseViewHolder.AMH = true;
            label4721:
            if (((bi)localObject2).AED == null) {
              break label4850;
            }
            a(((SnsObject)localObject3).CommentUserList, ((bi)localObject2).AED, paramBaseViewHolder);
          }
          for (;;)
          {
            if ((((bi)localObject2).AEC == null) || (((bi)localObject2).AEC.size() == 0) || (((bi)localObject2).AED == null) || (((bi)localObject2).AED.size() == 0)) {
              break label4862;
            }
            paramBaseViewHolder.AMN.setVisibility(0);
            break;
            label4794:
            if (paramBaseViewHolder.Afr == null) {}
            for (bool = true;; bool = false)
            {
              com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.BaseTimeLineItem", "holder.listKeeper = null %s,and holder.commentStub.inflated", new Object[] { Boolean.valueOf(bool) });
              break;
            }
            paramBaseViewHolder.AMG.setVisibility(8);
            paramBaseViewHolder.AMH = false;
            break label4721;
            label4850:
            paramBaseViewHolder.AMI.setVisibility(8);
          }
          label4862:
          paramBaseViewHolder.AMN.setVisibility(8);
          break label2261;
          paramBaseViewHolder.AMu.setVisibility(8);
          break label2301;
          paramInt1 = 0;
          break label2437;
          if (i != 0)
          {
            paramBaseViewHolder.ztd.setVisibility(8);
            paramBaseViewHolder.AMy.setTag(new f(paramBaseViewHolder.AMy, paramp.eco()));
            paramBaseViewHolder.AMy.setVisibility(0);
            break label2499;
          }
          paramBaseViewHolder.ztd.setVisibility(8);
          paramBaseViewHolder.AMy.setVisibility(8);
          break label2499;
          label4959:
          paramInt1 = 0;
          break label2644;
          label4964:
          paramInt1 = 0;
          break label2661;
          label4969:
          if (paramBaseViewHolder.ANv)
          {
            paramBaseViewHolder.ANw.setVisibility(8);
            paramBaseViewHolder.ANy.setTag(Long.valueOf(paramp.field_snsId));
          }
          paramBaseViewHolder.iOJ.setBackgroundResource(2131232867);
          break label2773;
          if (paramBaseViewHolder.ANz) {
            paramBaseViewHolder.ANA.setVisibility(8);
          }
          paramBaseViewHolder.iOJ.setBackgroundResource(2131232867);
        }
        label5041:
        paramTimeLineObject = new StringBuilder("");
        if ((((bi)localObject2).AED != null) && (((bi)localObject2).AED.size() > 0))
        {
          paramTimeLineObject.append(ak.getContext().getResources().getString(2131767181)).append(":");
          paramInt1 = 0;
          while (paramInt1 < ((bi)localObject2).AED.size())
          {
            parambh = (com.tencent.mm.vending.j.a)((bi)localObject2).AED.get(paramInt1);
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
            parambh = a.a.fCh();
            localObject1 = paramBaseViewHolder.uan;
            localObject2 = paramBaseViewHolder.AMm;
            localObject3 = paramBaseViewHolder.timeTv;
            localObject4 = paramBaseViewHolder.AyU;
            localObject5 = paramBaseViewHolder.AMp.getContent();
            localObject6 = paramBaseViewHolder.AMw;
            bool = paramBaseViewHolder.ANl;
            paramBaseViewHolder = paramBaseViewHolder.iFN;
            paramp = paramp.toString();
            paramTimeLineObject = paramTimeLineObject.toString();
            if ((parambh.fCg()) && (parambh.IR != null) && (localObject1 != null) && (localObject2 != null) && (localObject3 != null) && (localObject4 != null) && (paramBaseViewHolder != null)) {
              break;
            }
            return;
          } while ((paramInt2 != 3) && (paramInt2 != 4) && (paramInt2 != 5));
        }
        Object localObject7 = new com.tencent.mm.ui.a.b();
        ((com.tencent.mm.ui.a.b)localObject7).aWW(((TextView)localObject2).getText().toString());
        ((com.tencent.mm.ui.a.b)localObject7).aWW((String)localObject5);
        if ((localObject6 != null) && (((TextView)localObject6).getText() != null)) {
          ((com.tencent.mm.ui.a.b)localObject7).aWW(((TextView)localObject6).getText().toString());
        }
        if (bool) {
          ((com.tencent.mm.ui.a.b)localObject7).aWW(parambh.IR.getString(2131757941));
        }
        if (paramInt1 == 1) {
          ((com.tencent.mm.ui.a.b)localObject7).aWW(parambh.IR.getString(2131766923));
        }
        for (;;)
        {
          if ((localObject4 != null) && (((TextView)localObject4).getText() != null)) {
            ((com.tencent.mm.ui.a.b)localObject7).aWW(((TextView)localObject4).getText().toString());
          }
          if ((localObject3 != null) && (((TextView)localObject3).getText() != null)) {
            ((com.tencent.mm.ui.a.b)localObject7).aWW(((TextView)localObject3).getText().toString());
          }
          if ((paramBaseViewHolder != null) && (paramBaseViewHolder.getText() != null)) {
            ((com.tencent.mm.ui.a.b)localObject7).aWW(paramBaseViewHolder.getText().toString());
          }
          if (paramp != null) {
            ((com.tencent.mm.ui.a.b)localObject7).aWW(paramp);
          }
          if (paramTimeLineObject != null) {
            ((com.tencent.mm.ui.a.b)localObject7).aWW(paramTimeLineObject);
          }
          ((com.tencent.mm.ui.a.b)localObject7).gc((View)localObject1);
          return;
          if (paramInt1 > 1) {
            ((com.tencent.mm.ui.a.b)localObject7).aWW(parambh.IR.getString(2131766924));
          }
        }
      }
      label1920:
      label2437:
      label3470:
      label3861:
      label4886:
      label4891:
      i = 0;
      label3458:
      label3849:
      label4874:
      label5012:
      break label605;
      i = 0;
    }
  }
  
  public abstract void a(BaseViewHolder paramBaseViewHolder, int paramInt1, bi parambi, TimeLineObject paramTimeLineObject, int paramInt2, bh parambh);
  
  public abstract void h(BaseViewHolder paramBaseViewHolder);
  
  public final void setIsFromMainTimeline(boolean paramBoolean)
  {
    this.Arr = paramBoolean;
  }
  
  public static class BaseViewHolder
  {
    public com.tencent.mm.plugin.sns.ui.aq AKJ;
    public WeImageView AMA;
    public AsyncTextView AMB;
    public AsyncTextView AMC;
    public View AMD;
    public ImageView AME;
    public View AMF;
    public SnsLikesTextView AMG;
    public boolean AMH;
    public LinearLayout AMI;
    public LinearLayout AMJ;
    public View AMK;
    public LinearLayout AML;
    public PhotosContent AMM;
    public View AMN;
    public ViewStub AMO;
    public boolean AMP;
    public ViewStub AMQ;
    public ViewStub AMS;
    public View AMT;
    public boolean AMU;
    public boolean AMV;
    public ViewStub AMW;
    public boolean AMX;
    public View AMY;
    public LinearLayout AMZ;
    public long AMj;
    public int AMk;
    public SnsAvatarImageView AMl;
    public AsyncTextView AMm;
    public ImageView AMn;
    public ViewGroup AMo;
    public AsyncNormalTextView AMp;
    public SnsTranslateResultView AMq;
    public LinearLayout AMr;
    public ViewStub AMs;
    public boolean AMt;
    public TextView AMu;
    public TagImageView AMv;
    public TextView AMw;
    public int AMx;
    public RelativeLayout AMy;
    public TextView AMz;
    public ViewStub ANA;
    public LinearLayout ANB;
    public TextView ANC;
    public TextView ANa;
    public ViewStub ANb;
    public boolean ANc;
    public View ANd;
    public LinearLayout ANe;
    public ViewStub ANf;
    public boolean ANg;
    public View ANh;
    public ImageView ANi;
    public boolean ANj;
    ViewStub ANk;
    boolean ANl;
    public View ANm;
    public BaseTimeLineItem ANn;
    public ViewStub ANo;
    public View ANp;
    public MaskTextView ANq;
    public View ANr;
    private TextView ANs;
    public String ANt;
    public View ANu;
    public boolean ANv;
    public ViewStub ANw;
    public LinearLayout ANx;
    public ViewGroup ANy;
    public boolean ANz;
    public bzi AdX;
    public com.tencent.mm.contact.c AfX;
    public ImageView AfZ;
    public LinearLayout Afr;
    public TextView Ais;
    public int Aso;
    public TextView AyU;
    public View Aza;
    public String dAg;
    public String dqc;
    public volatile boolean guz;
    public TextView iFN;
    public ViewGroup iOJ;
    public boolean isAd;
    public int oOD;
    public int position;
    public SnsObject snsobj;
    public TimeLineObject timeLineObject;
    public TextView timeTv;
    public TextView titleTv;
    public View uan;
    public boolean ulU;
    public TextView zWK;
    public bn ztd;
    public TextView zvV;
    
    public BaseViewHolder()
    {
      AppMethodBeat.i(100055);
      this.AMt = false;
      this.AMx = 0;
      this.Aso = 210;
      this.AMH = false;
      this.AMP = false;
      this.AMT = null;
      this.AMU = false;
      this.AMV = false;
      this.AMX = false;
      this.ANc = false;
      this.ANg = false;
      this.ANj = false;
      this.ANl = false;
      this.AKJ = new com.tencent.mm.plugin.sns.ui.aq();
      this.ANv = false;
      this.ANz = false;
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
      BaseTimeLineItem.this.zGX.Asj.AHz.onClick(paramView);
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
      BaseTimeLineItem.this.zGX.Asj.AHo.onClick(paramView);
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
      BaseTimeLineItem.this.zGX.Asj.AHp.onClick(paramView);
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
    implements g.d
  {
    public com.tencent.mm.plugin.sns.ui.l AAZ;
    public CharSequence AND;
    public int ANE;
    public int AtF;
    public int deleteFlag;
    public CharSequence gHE;
    public String md5;
    private WeakReference<View> view;
    
    public d(String paramString, CharSequence paramCharSequence1, CharSequence paramCharSequence2, View paramView, int paramInt1, int paramInt2, com.tencent.mm.plugin.sns.ui.l paraml)
    {
      AppMethodBeat.i(220082);
      this.view = null;
      this.md5 = null;
      this.AND = null;
      this.gHE = null;
      this.AtF = 0;
      this.deleteFlag = 0;
      this.ANE = com.tencent.mm.ui.aq.fromDPToPix(ak.getContext(), 28);
      this.AAZ = null;
      this.view = new WeakReference(paramView);
      this.md5 = paramString;
      this.AND = paramCharSequence1;
      this.gHE = paramCharSequence2;
      this.AtF = paramInt1;
      this.deleteFlag = paramInt2;
      this.AAZ = paraml;
      AppMethodBeat.o(220082);
    }
    
    public final void f(Bitmap paramBitmap, String paramString)
    {
      AppMethodBeat.i(100059);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BaseTimeLineItem", "onEmojiDecodeFin bitmapAvailable:%s, md5:%s", new Object[] { Boolean.valueOf(r.J(paramBitmap)), paramString });
      if ((this.view != null) && (this.view.get() != null) && ((this.view.get() instanceof SnsCommentCollapseLayout)))
      {
        SnsCommentCollapseLayout localSnsCommentCollapseLayout = (SnsCommentCollapseLayout)this.view.get();
        if ((localSnsCommentCollapseLayout != null) && (localSnsCommentCollapseLayout.getTag() != null) && ((localSnsCommentCollapseLayout.getTag() instanceof com.tencent.mm.plugin.sns.ui.m)))
        {
          Object localObject = (com.tencent.mm.plugin.sns.ui.m)localSnsCommentCollapseLayout.getTag();
          if ((((com.tencent.mm.plugin.sns.ui.m)localObject).zyl != null) && (!bu.ht(((com.tencent.mm.plugin.sns.ui.m)localObject).zyl.HNp)) && (((com.tencent.mm.plugin.sns.ui.m)localObject).zyl.HNp.get(0) != null) && (bu.lX(paramString, ((dgn)((com.tencent.mm.plugin.sns.ui.m)localObject).zyl.HNp.get(0)).Md5)) && (r.J(paramBitmap)))
          {
            paramBitmap = new BitmapDrawable(paramBitmap);
            paramBitmap.setBounds(0, 0, this.ANE, this.ANE);
            paramBitmap = new com.tencent.mm.ui.widget.a(paramBitmap);
            ak.getContext();
            paramString = new com.tencent.mm.pluginsdk.ui.span.p(this.md5, this.AAZ, 2);
            localObject = new SpannableStringBuilder(this.AND);
            ((SpannableStringBuilder)localObject).append("  ").append(this.md5).append("  ").append(" ");
            int i = ((SpannableStringBuilder)localObject).length() - this.md5.length() - 2 - 1;
            int j = ((SpannableStringBuilder)localObject).length() - this.md5.length() - 4 - 1;
            ((SpannableStringBuilder)localObject).setSpan(paramBitmap, i, this.md5.length() + i, 33);
            ((SpannableStringBuilder)localObject).setSpan(paramString, j, j + 4 + this.md5.length(), 33);
            SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(this.gHE);
            localSpannableStringBuilder.append("  ").append(this.md5).append("  ").append(" ");
            i = localSpannableStringBuilder.length() - this.md5.length() - 2 - 1;
            j = localSpannableStringBuilder.length() - this.md5.length() - 4 - 1;
            localSpannableStringBuilder.setSpan(paramBitmap, i, this.md5.length() + i, 33);
            localSpannableStringBuilder.setSpan(paramString, j, j + 4 + this.md5.length(), 33);
            localSnsCommentCollapseLayout.a((CharSequence)localObject, localSpannableStringBuilder, this.AtF, this.deleteFlag);
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