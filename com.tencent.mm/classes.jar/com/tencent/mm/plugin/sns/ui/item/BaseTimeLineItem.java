package com.tencent.mm.plugin.sns.ui.item;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.b;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.plugin.sns.model.aq.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.plugin.sns.ui.AsyncNormalTextView;
import com.tencent.mm.plugin.sns.ui.AsyncTextView;
import com.tencent.mm.plugin.sns.ui.MaskTextView;
import com.tencent.mm.plugin.sns.ui.PhotosContent;
import com.tencent.mm.plugin.sns.ui.SnsTranslateResultView;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.TranslateCommentTextView;
import com.tencent.mm.plugin.sns.ui.aa;
import com.tencent.mm.plugin.sns.ui.aj;
import com.tencent.mm.plugin.sns.ui.as;
import com.tencent.mm.plugin.sns.ui.av.b;
import com.tencent.mm.plugin.sns.ui.aw;
import com.tencent.mm.plugin.sns.ui.ba;
import com.tencent.mm.plugin.sns.ui.bc;
import com.tencent.mm.plugin.sns.ui.bd;
import com.tencent.mm.plugin.sns.ui.l;
import com.tencent.mm.plugin.sns.ui.w;
import com.tencent.mm.plugin.sns.ui.widget.SnsAvatarImageView;
import com.tencent.mm.plugin.sns.ui.widget.SnsCommentCollapseLayout;
import com.tencent.mm.plugin.story.api.f;
import com.tencent.mm.plugin.story.api.f.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.k;
import com.tencent.mm.pluginsdk.ui.d.o;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bct;
import com.tencent.mm.protocal.protobuf.cds;
import com.tencent.mm.protocal.protobuf.du;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.a.a.a;
import com.tencent.mm.vending.base.Vending;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public abstract class BaseTimeLineItem
{
  public boolean DEBUG = false;
  protected int kwo;
  protected Activity mActivity;
  protected boolean rNW = false;
  protected com.tencent.mm.plugin.sns.ui.av rkX;
  public ArrayList<aq.b> sgH = new ArrayList();
  
  private static void a(View paramView, CharSequence paramCharSequence, int paramInt)
  {
    if ((paramView instanceof SnsCommentCollapseLayout)) {
      ((SnsCommentCollapseLayout)paramView).k(paramCharSequence, paramInt);
    }
    while (!(paramView instanceof TextView)) {
      return;
    }
    ((TextView)paramView).setText(paramCharSequence);
  }
  
  public static void a(aq.b paramb, BaseViewHolder paramBaseViewHolder, String paramString1, String paramString2)
  {
    if ((paramBaseViewHolder != null) && (paramBaseViewHolder.sgR != null))
    {
      paramBaseViewHolder.sgR.a(paramb, 1, paramString1, paramString2, paramb.riz);
      paramBaseViewHolder.sgR.setVisibility(0);
    }
  }
  
  private static void a(aw paramaw, TimeLineObject paramTimeLineObject)
  {
    if ((paramaw == null) || (paramTimeLineObject == null)) {}
    for (;;)
    {
      return;
      if (paramTimeLineObject.xTR == null) {}
      for (String str = null; !bo.isNullOrNil(str); str = paramTimeLineObject.xTR.Id)
      {
        com.tencent.mm.plugin.sns.c.a.gmP.a(str, paramTimeLineObject.jJA, paramTimeLineObject.xTS.wNZ, paramTimeLineObject.xTW, paramaw.rZw);
        return;
      }
    }
  }
  
  private static void a(BaseViewHolder paramBaseViewHolder, com.tencent.mm.plugin.sns.storage.n paramn)
  {
    if (paramn.Ex(32))
    {
      if (paramBaseViewHolder.sgQ != null) {
        paramBaseViewHolder.sgQ.setVisibility(0);
      }
      paramBaseViewHolder.sgS.setLongClickable(false);
      paramBaseViewHolder.sgS.setOnClickListener(null);
      paramn = new LinearLayout.LayoutParams(-1, -2);
      paramBaseViewHolder.sgS.setLayoutParams(paramn);
      paramBaseViewHolder.sgS.setBackgroundColor(Color.parseColor("#00ffffff"));
      if (paramBaseViewHolder.shk != null)
      {
        paramn = (LinearLayout.LayoutParams)paramBaseViewHolder.shk.getLayoutParams();
        paramn.leftMargin = 0;
        paramn.rightMargin = 0;
        paramBaseViewHolder.shk.setLayoutParams(paramn);
      }
      if (paramBaseViewHolder.shI)
      {
        paramn = (LinearLayout.LayoutParams)paramBaseViewHolder.sfG.rLD.getLayoutParams();
        paramn.leftMargin = 0;
        paramn.rightMargin = 0;
        paramBaseViewHolder.sfG.rLD.setLayoutParams(paramn);
      }
      return;
    }
    if (paramBaseViewHolder.sgQ != null) {
      paramBaseViewHolder.sgQ.setVisibility(0);
    }
    paramBaseViewHolder.sgS.setLongClickable(false);
    paramBaseViewHolder.sgS.setOnClickListener(null);
    if (paramBaseViewHolder.shk != null)
    {
      paramn = (LinearLayout.LayoutParams)paramBaseViewHolder.shk.getLayoutParams();
      paramn.leftMargin = 0;
      paramn.rightMargin = 0;
      paramBaseViewHolder.shk.setLayoutParams(paramn);
    }
    if (paramBaseViewHolder.shI)
    {
      paramn = (LinearLayout.LayoutParams)paramBaseViewHolder.sfG.rLD.getLayoutParams();
      paramn.leftMargin = 0;
      paramn.rightMargin = 0;
      paramBaseViewHolder.sfG.rLD.setLayoutParams(paramn);
    }
    paramn = new LinearLayout.LayoutParams(-1, -2);
    paramBaseViewHolder.sgS.setLayoutParams(paramn);
    paramBaseViewHolder.sgS.setBackgroundColor(Color.parseColor("#00ffffff"));
  }
  
  private boolean a(MaskTextView paramMaskTextView, com.tencent.mm.vending.d.b<com.tencent.mm.vending.j.a> paramb, int paramInt)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(" ");
    int k = localSpannableStringBuilder.length() - 1;
    StringBuffer localStringBuffer = new StringBuffer();
    int[] arrayOfInt1 = new int[paramb.size()];
    int[] arrayOfInt2 = new int[paramb.size()];
    int j = 1;
    int i = 0;
    for (;;)
    {
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
            arrayOfInt1[i] = localSpannableStringBuilder.length();
            arrayOfInt1[i] += ((String)localObject).length();
            localStringBuffer.append((String)localObject);
            localSpannableStringBuilder.append(com.tencent.mm.pluginsdk.ui.d.j.b(this.mActivity, (CharSequence)localObject, paramMaskTextView.getTextSize()));
            if ((!com.tencent.mm.plugin.sns.e.a.ZR((String)((com.tencent.mm.vending.j.a)paramb.get(i)).get(0))) || (!((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.story.api.e.class)).getStoryBasicConfig().a(f.a.sqN)) || (!com.tencent.mm.plugin.story.api.n.isShowStoryCheck())) {
              break label509;
            }
            localSpannableStringBuilder.append("  ");
            localSpannableStringBuilder.setSpan(new com.tencent.mm.plugin.sns.ui.widget.g(((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.story.api.e.class)).getStoryUIFactory().lO(true)), localSpannableStringBuilder.length() - 1, localSpannableStringBuilder.length(), 17);
            break label509;
          }
          localSpannableStringBuilder.append(", ");
          localStringBuffer.append(", ");
          continue;
          return true;
        }
      }
      catch (Exception paramMaskTextView)
      {
        ab.e("MicroMsg.BaseTimeLineItem", "setLikedList  e:%s", new Object[] { bo.l(paramMaskTextView) });
      }
      for (;;)
      {
        localObject = this.mActivity.getResources();
        if (paramInt != 10) {
          break label524;
        }
        i = 2130839060;
        localObject = ((Resources)localObject).getDrawable(i);
        ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
        com.tencent.mm.ui.widget.a locala = new com.tencent.mm.ui.widget.a((Drawable)localObject);
        locala.ACa = ((int)((((Drawable)localObject).getIntrinsicHeight() - paramMaskTextView.getTextSize() + com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 2)) / 2.0F));
        localSpannableStringBuilder.setSpan(locala, k, k + 1, 33);
        if (paramInt != 10) {
          break label532;
        }
        paramInt = 3;
        break;
        label422:
        while (i < arrayOfInt1.length)
        {
          localSpannableStringBuilder.setSpan(new o((String)((com.tencent.mm.vending.j.a)paramb.get(i)).get(0), new BaseTimeLineItem.5(this), paramInt), arrayOfInt1[i], arrayOfInt2[i], 33);
          i += 1;
        }
        paramMaskTextView.setText(localSpannableStringBuilder, TextView.BufferType.SPANNABLE);
        paramMaskTextView.setOriginText(localStringBuffer.toString());
      }
      label509:
      i += 1;
    }
    for (;;)
    {
      i = 0;
      break label422;
      label524:
      i = 2130839819;
      break;
      label532:
      paramInt = 2;
    }
  }
  
  private boolean a(List<cds> paramList, com.tencent.mm.vending.d.b<com.tencent.mm.vending.j.a> paramb, BaseViewHolder paramBaseViewHolder)
  {
    LinearLayout localLinearLayout = paramBaseViewHolder.shg;
    int n = localLinearLayout.getChildCount();
    int j = paramb.size();
    int i;
    if (n > j)
    {
      i = j;
      while (i < n)
      {
        localObject1 = localLinearLayout.getChildAt(j);
        localLinearLayout.removeViewAt(j);
        if ((localObject1 instanceof SnsCommentCollapseLayout)) {
          this.rkX.a((SnsCommentCollapseLayout)localObject1);
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
    Object localObject1 = this.rkX.cvY();
    if ((localObject1 instanceof com.tencent.mm.plugin.sns.ui.a.c)) {}
    for (aw localaw = (aw)((com.tencent.mm.plugin.sns.ui.a.c)localObject1).sds.get(paramBaseViewHolder.position);; localaw = null)
    {
      if (this.DEBUG) {
        ab.d("MicroMsg.BaseTimeLineItem", "debug:setCommentList position " + paramBaseViewHolder.position + " commentCount: " + j);
      }
      int k = 0;
      j = 0;
      Object localObject3;
      aq.b localb;
      label428:
      int m;
      Object localObject2;
      TranslateCommentTextView localTranslateCommentTextView;
      label645:
      String str4;
      String str5;
      if (j < paramb.size())
      {
        localObject1 = (com.tencent.mm.vending.j.a)paramb.get(j);
        long l = ((Long)((com.tencent.mm.vending.j.a)localObject1).get(0)).longValue();
        String str1 = (String)((com.tencent.mm.vending.j.a)localObject1).get(1);
        String str2 = (String)((com.tencent.mm.vending.j.a)localObject1).get(2);
        String str3 = (String)((com.tencent.mm.vending.j.a)localObject1).get(3);
        localObject3 = (CharSequence)((com.tencent.mm.vending.j.a)localObject1).get(4);
        cds localcds = (cds)paramList.get(j);
        i = localcds.xOc;
        localb = aG(paramBaseViewHolder.czw, l);
        if ((localb != null) && (localb.frX)) {
          aq.dm(localb.id, 2);
        }
        if (k >= n) {
          if ((localb == null) || (localb.frX))
          {
            localObject1 = this.rkX.cvU();
            ((SnsCommentCollapseLayout)localObject1).setTextSize$255e752(15.0F * com.tencent.mm.cb.a.dr(((View)localObject1).getContext()));
            if (this.rkX.rWT == -1) {
              this.rkX.rWT = this.mActivity.getResources().getColor(2131690482);
            }
            ((SnsCommentCollapseLayout)localObject1).setTextColor(this.rkX.rWT);
            ((SnsCommentCollapseLayout)localObject1).setGravity(16);
            m = 1;
            localObject2 = localObject1;
          }
        }
        for (;;)
        {
          if (localb != null)
          {
            localObject1 = localObject2;
            if (!(localObject2 instanceof TranslateCommentTextView))
            {
              localLinearLayout.removeView((View)localObject2);
              localObject1 = new TranslateCommentTextView(this.mActivity);
              localLinearLayout.addView((View)localObject1, k);
              ((TranslateCommentTextView)localObject1).getTranslateResultView().setResultTextSize$255e752(15.0F * com.tencent.mm.cb.a.dr(((View)localObject1).getContext()));
              ((TranslateCommentTextView)localObject1).getOriginCommentTextView().setTextSize(1, 15.0F * com.tencent.mm.cb.a.dr(((View)localObject1).getContext()));
            }
            localTranslateCommentTextView = (TranslateCommentTextView)localObject1;
            ((View)localObject1).setOnTouchListener(null);
            a(localTranslateCommentTextView.getOriginCommentTextView(), (CharSequence)localObject3, i);
            if (!localb.fon)
            {
              localTranslateCommentTextView.sdc.setTextSize(1, 15.0F * com.tencent.mm.cb.a.dr(localTranslateCommentTextView.getContext()));
              localTranslateCommentTextView.rPT.Fc(2);
              localTranslateCommentTextView.rPT.setVisibility(0);
              i = 1;
              ((View)localObject1).setBackgroundResource(2130840428);
              if (k <= 0) {
                break label1265;
              }
              if (i == 0) {
                break label1239;
              }
              ((View)localObject1).setPadding(0, com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 2), 0, com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 7));
              if (i != 0)
              {
                localObject2 = (TranslateCommentTextView)localObject1;
                i = (int)this.mActivity.getResources().getDimension(2131427854);
                ((TranslateCommentTextView)localObject2).rPT.getSplitlineView().setPadding(0, 0, i, 0);
              }
              ((View)localObject1).setOnLongClickListener(new BaseTimeLineItem.6(this, (View)localObject1));
              ((View)localObject1).setOnClickListener(new com.tencent.mm.plugin.sns.ui.i.a(this.rkX.rWP, localcds, str2, str3, paramBaseViewHolder));
              if (localaw != null) {
                ((View)localObject1).setTag(new l(localaw.rGx, localaw.rZv, localcds, str1, str3, (View)localObject1, 1));
              }
              if (m != 0) {
                localLinearLayout.addView((View)localObject1);
              }
              k += 1;
              j += 1;
              break;
              localObject1 = new TranslateCommentTextView(this.mActivity);
              ((TranslateCommentTextView)localObject1).getTranslateResultView().setResultTextSize$255e752(15.0F * com.tencent.mm.cb.a.dr(((View)localObject1).getContext()));
              ((TranslateCommentTextView)localObject1).getOriginCommentTextView().setTextSize(1, 15.0F * com.tencent.mm.cb.a.dr(((View)localObject1).getContext()));
              break label428;
              localObject2 = localLinearLayout.getChildAt(k);
              m = 0;
              continue;
            }
            if (!localb.frX)
            {
              str4 = localb.result;
              str5 = localb.fwM;
              String str6 = localTranslateCommentTextView.sdc.getText().toString();
              if (!bo.isNullOrNil(str6))
              {
                localObject2 = str6.split(":");
                if (localObject2.length <= 2) {
                  break label1318;
                }
                localObject3 = new String[2];
                localObject3[0] = localObject2[0];
                localObject3[1] = str6.substring(localObject3[0].length() + 1);
                localObject2 = localObject3;
              }
            }
          }
        }
      }
      label1318:
      for (;;)
      {
        if (localObject2.length == 2)
        {
          if (bo.isNullOrNil(str4)) {
            break label1066;
          }
          localTranslateCommentTextView.rPT.a(localb, 2, localObject2[0] + ": " + str4, str5, localb.riz);
        }
        for (;;)
        {
          localTranslateCommentTextView.rPT.setVisibility(0);
          localTranslateCommentTextView.sdc.setTextSize(1, 15.0F * com.tencent.mm.cb.a.dr(localTranslateCommentTextView.getContext()));
          i = 1;
          break;
          label1066:
          localTranslateCommentTextView.rPT.a(localb, 2, null, str5, localb.riz);
        }
        localTranslateCommentTextView.getTranslateResultView().setVisibility(8);
        i = 1;
        break;
        if ((m == 0) && ((localObject2 instanceof TranslateCommentTextView)))
        {
          localLinearLayout.removeView((View)localObject2);
          localObject1 = this.rkX.cvU();
          localLinearLayout.addView((View)localObject1, k);
          ((SnsCommentCollapseLayout)localObject1).setTextSize$255e752(15.0F * com.tencent.mm.cb.a.dr(((View)localObject1).getContext()));
        }
        for (;;)
        {
          if ((localObject1 instanceof SnsCommentCollapseLayout))
          {
            ((SnsCommentCollapseLayout)localObject1).setTextSize$255e752(15.0F * com.tencent.mm.cb.a.dr(((View)localObject1).getContext()));
            ((SnsCommentCollapseLayout)localObject1).setOpClickListener(this.rkX.rXa);
            ((SnsCommentCollapseLayout)localObject1).setPressTouchListener(new com.tencent.mm.pluginsdk.ui.d.m(this.mActivity));
          }
          a((View)localObject1, (CharSequence)localObject3, i);
          i = 0;
          break;
          label1239:
          ((View)localObject1).setPadding(0, com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 2), 0, com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 3));
          break label645;
          label1265:
          if (i != 0)
          {
            ((View)localObject1).setPadding(0, 1, 0, com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 7));
            break label645;
          }
          ((View)localObject1).setPadding(0, 1, 0, com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 3));
          break label645;
          return true;
          localObject1 = localObject2;
        }
      }
    }
  }
  
  private aq.b aG(String paramString, long paramLong)
  {
    if (this.sgH.size() <= 0) {
      return null;
    }
    Iterator localIterator = this.sgH.iterator();
    while (localIterator.hasNext())
    {
      aq.b localb = (aq.b)localIterator.next();
      if ((localb.id != null) && (localb.id.equals(aq.gm(paramString, String.valueOf(paramLong))))) {
        return localb;
      }
    }
    return null;
  }
  
  private void b(MaskTextView paramMaskTextView, com.tencent.mm.vending.d.b<com.tencent.mm.vending.j.a> paramb, int paramInt)
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
          localSpannableStringBuilder.append(com.tencent.mm.pluginsdk.ui.d.j.b(this.mActivity, (CharSequence)localObject, paramMaskTextView.getTextSize()));
          i += 1;
          break;
          localSpannableStringBuilder.append(", ");
          localStringBuffer.append(", ");
        }
      }
      localObject = this.mActivity.getResources().getDrawable(2131231367);
    }
    catch (Exception paramMaskTextView)
    {
      ab.e("MicroMsg.BaseTimeLineItem", "setReward error  e:%s", new Object[] { bo.l(paramMaskTextView) });
      return;
    }
    ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
    com.tencent.mm.ui.widget.a locala = new com.tencent.mm.ui.widget.a((Drawable)localObject);
    locala.ACa = ((int)((((Drawable)localObject).getIntrinsicHeight() - paramMaskTextView.getTextSize() + com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 2)) / 2.0F));
    localSpannableStringBuilder.setSpan(locala, k, k + 1, 33);
    if (paramInt == 10)
    {
      paramInt = 3;
      break label408;
      while (i < arrayOfInt1.length)
      {
        localSpannableStringBuilder.setSpan(new o((String)((com.tencent.mm.vending.j.a)paramb.get(i)).get(0), this.rkX.rOK, paramInt), arrayOfInt1[i], arrayOfInt2[i], 33);
        i += 1;
      }
      paramMaskTextView.setText(localSpannableStringBuilder, TextView.BufferType.SPANNABLE);
      paramMaskTextView.setOriginText(localStringBuffer.toString());
      return;
    }
    for (;;)
    {
      label408:
      i = 0;
      break;
      paramInt = 2;
    }
  }
  
  public static void e(BaseViewHolder paramBaseViewHolder)
  {
    if ((paramBaseViewHolder != null) && (paramBaseViewHolder.sgR != null))
    {
      paramBaseViewHolder.sgR.Fc(1);
      paramBaseViewHolder.sgR.setVisibility(0);
    }
  }
  
  public static void f(BaseViewHolder paramBaseViewHolder)
  {
    if ((paramBaseViewHolder != null) && (paramBaseViewHolder.sgR != null)) {
      paramBaseViewHolder.sgR.setVisibility(8);
    }
  }
  
  public final View a(Activity paramActivity, BaseViewHolder paramBaseViewHolder, int paramInt, com.tencent.mm.plugin.sns.ui.av paramav, com.tencent.mm.plugin.sns.storage.n paramn)
  {
    this.mActivity = paramActivity;
    this.kwo = paramInt;
    this.rkX = paramav;
    paramBaseViewHolder.czw = paramn.getSnsId();
    Object localObject;
    View localView;
    switch (paramInt)
    {
    default: 
      localObject = "R.layout.sns_media_sub_item2";
      com.tencent.mm.kiss.a.b.SH();
      localView = com.tencent.mm.kiss.a.b.b(this.mActivity, 2130970886);
      paramBaseViewHolder.shR = ((String)localObject);
      localObject = localView.findViewById(2131827945);
      if (!(localObject instanceof ViewStub)) {
        break;
      }
    }
    for (paramBaseViewHolder.sgT = ((ViewStub)localObject);; paramBaseViewHolder.sgT = null)
    {
      ab.i("MicroMsg.BaseTimeLineItem", "create new item  " + paramInt + "  " + localView.hashCode());
      paramBaseViewHolder.shK = localView.findViewById(2131828141);
      paramBaseViewHolder.kwo = paramInt;
      paramBaseViewHolder.sgM = ((SnsAvatarImageView)localView.findViewById(2131827936));
      paramBaseViewHolder.sgM.setWeakContext(paramActivity);
      paramBaseViewHolder.sgM.setOnClickListener(paramav.rks.sjs);
      paramBaseViewHolder.sgM.setOnLongClickListener(paramav.rks.sjt);
      paramBaseViewHolder.sgM.setOnTouchListener(new BaseTimeLineItem.1(this));
      paramBaseViewHolder.sgN = ((AsyncTextView)localView.findViewById(2131823254));
      paramBaseViewHolder.sgO = ((ImageView)localView.findViewById(2131827939));
      paramBaseViewHolder.sgN.setOnTouchListener(new aa());
      paramBaseViewHolder.sgP = ((ViewGroup)localView.findViewById(2131828142));
      paramBaseViewHolder.sgQ = ((AsyncNormalTextView)localView.findViewById(2131828144));
      paramBaseViewHolder.sgQ.setOpClickListener(paramav.rWZ);
      paramBaseViewHolder.sgS = ((LinearLayout)localView.findViewById(2131827944));
      paramBaseViewHolder.sgS.setTag(paramBaseViewHolder);
      paramBaseViewHolder.sgS.setOnClickListener(paramav.rks.sjX);
      localObject = localView.findViewById(2131821007);
      paramav.jVd.c((View)localObject, paramav.rks.sju, paramav.rks.sjr);
      localObject = (TextView)localView.findViewById(2131822880);
      paramav.jVd.c((View)localObject, paramav.rks.sju, paramav.rks.sjr);
      paramBaseViewHolder.sgR = ((SnsTranslateResultView)localView.findViewById(2131827943));
      paramBaseViewHolder.sgR.setVisibility(8);
      paramBaseViewHolder.sgR.getSplitlineView().setPadding(0, 0, (int)this.mActivity.getResources().getDimension(2131427854), 0);
      paramBaseViewHolder.sgR.getResultTextView().setBackgroundResource(2130840380);
      paramav.jVd.c(paramBaseViewHolder.sgR.getResultTextView(), paramav.rks.sju, paramav.rks.sjr);
      paramBaseViewHolder.shj = ((LinearLayout)localView.findViewById(2131827986));
      paramBaseViewHolder.sgZ = ((TextView)localView.findViewById(2131827947));
      paramBaseViewHolder.timeTv = ((TextView)localView.findViewById(2131827948));
      paramBaseViewHolder.sha = ((AsyncTextView)localView.findViewById(2131827949));
      paramBaseViewHolder.shb = ((AsyncTextView)localView.findViewById(2131827950));
      paramBaseViewHolder.rUN = ((TextView)localView.findViewById(2131827946));
      paramBaseViewHolder.rba = new bc(localView);
      paramBaseViewHolder.rba.a(paramav.rks.sjC, paramav.rks.sjQ);
      paramBaseViewHolder.rHh = ((TextView)localView.findViewById(2131827954));
      paramBaseViewHolder.rHh.setText(paramActivity.getString(2131296901));
      paramBaseViewHolder.rHh.setOnClickListener(paramav.rks.sjw);
      paramBaseViewHolder.sha.setOnClickListener(paramav.rks.sjR);
      paramBaseViewHolder.shb.setOnClickListener(paramav.rks.sjS);
      paramBaseViewHolder.rUN.setOnClickListener(paramav.rks.sjN);
      paramBaseViewHolder.shc = localView.findViewById(2131827951);
      paramBaseViewHolder.shc.setOnClickListener(paramav.rks.sjB);
      paramBaseViewHolder.lbr = ((TextView)localView.findViewById(2131827952));
      paramBaseViewHolder.shd = ((ImageView)localView.findViewById(2131827937));
      paramBaseViewHolder.shm = ((ViewStub)localView.findViewById(2131828149));
      paramBaseViewHolder.rEv = ((LinearLayout)localView.findViewById(2131828126));
      paramBaseViewHolder.shM = ((ViewStub)localView.findViewById(2131828148));
      paramBaseViewHolder.sho = ((ViewStub)localView.findViewById(2131828151));
      paramBaseViewHolder.sgV = ((TextView)localView.findViewById(2131828146));
      paramBaseViewHolder.sgV.setOnClickListener(paramav.rks.sjx);
      BaseViewHolder.a(paramBaseViewHolder, (TextView)localView.findViewById(2131827953));
      paramBaseViewHolder.ngZ = localView;
      if (this.rNW)
      {
        com.tencent.mm.plugin.sns.abtest.c.b(localView, paramBaseViewHolder);
        com.tencent.mm.plugin.sns.abtest.a.a(localView, paramBaseViewHolder);
        ag.coW();
        com.tencent.mm.plugin.sns.g.c.c(localView, paramBaseViewHolder);
      }
      d(paramBaseViewHolder);
      localView.setTag(paramBaseViewHolder);
      a(paramBaseViewHolder, paramn);
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
      localObject = "R.layout.sns_media_sub_item2";
      break;
      localObject = "R.layout.sns_media_sub_item2";
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
  
  public final void a(BaseViewHolder paramBaseViewHolder, int paramInt, com.tencent.mm.plugin.sns.storage.n paramn)
  {
    paramn = paramn.csh();
    aw localaw = (aw)this.rkX.cvY().ctE().get(Integer.valueOf(paramInt));
    a(paramBaseViewHolder, paramInt, localaw, paramn, paramBaseViewHolder.kwo, this.rkX);
    a(localaw, paramn);
  }
  
  public final void a(BaseViewHolder paramBaseViewHolder, int paramInt1, com.tencent.mm.plugin.sns.storage.n paramn, TimeLineObject paramTimeLineObject, int paramInt2, com.tencent.mm.plugin.sns.ui.av paramav)
  {
    Object localObject3 = (aw)paramav.cvY().ctE().get(Integer.valueOf(paramInt1));
    a(paramBaseViewHolder, paramn);
    this.kwo = paramInt2;
    this.rkX = paramav;
    if (this.rNW) {
      com.tencent.mm.plugin.sns.ui.a.c.E(paramn);
    }
    com.tencent.mm.plugin.sns.ui.a.c.d(paramTimeLineObject);
    if (paramn.Ex(32)) {
      ab.i("MicroMsg.BaseTimeLineItem", "the ad sns id is " + com.tencent.mm.plugin.sns.data.i.lr(paramn.field_snsId) + " for susan");
    }
    paramBaseViewHolder.sgK = ((aw)localObject3).rZw;
    paramBaseViewHolder.nmm = false;
    paramBaseViewHolder.position = paramInt1;
    paramBaseViewHolder.czw = ((aw)localObject3).rZv;
    paramBaseViewHolder.crk = ((aw)localObject3).rGx;
    paramBaseViewHolder.sgL = ((aw)localObject3).rZA;
    paramBaseViewHolder.shd.setOnClickListener(paramav.rWY);
    paramBaseViewHolder.timeLineObject = paramTimeLineObject;
    SnsObject localSnsObject = ((aw)localObject3).qXo;
    paramBaseViewHolder.snsobj = localSnsObject;
    Object localObject1 = paramav.rWP.rFl.rhS;
    Object localObject2;
    if (paramn != null)
    {
      localObject2 = paramn.csH();
      ((com.tencent.mm.plugin.sns.i.b)localObject1).roj.add(localObject2);
      if (paramn.Ex(32)) {
        ((com.tencent.mm.plugin.sns.i.b)localObject1).roo.add(localObject2);
      }
      ((com.tencent.mm.plugin.sns.i.b)localObject1).rop.add(paramn.field_userName);
    }
    Object localObject4;
    switch (paramn.field_type)
    {
    default: 
      ((com.tencent.mm.plugin.sns.i.b)localObject1).rou.add(localObject2);
      if (paramInt1 < ((com.tencent.mm.plugin.sns.i.b)localObject1).roh)
      {
        ((com.tencent.mm.plugin.sns.i.b)localObject1).roh = paramInt1;
        ((com.tencent.mm.plugin.sns.i.b)localObject1).rmM = com.tencent.mm.plugin.sns.data.i.j(paramn);
      }
      if (paramInt1 > ((com.tencent.mm.plugin.sns.i.b)localObject1).roi)
      {
        ((com.tencent.mm.plugin.sns.i.b)localObject1).roi = paramInt1;
        ((com.tencent.mm.plugin.sns.i.b)localObject1).rmN = com.tencent.mm.plugin.sns.data.i.j(paramn);
      }
      ((com.tencent.mm.plugin.sns.i.b)localObject1).rmS = ((com.tencent.mm.plugin.sns.i.b)localObject1).rok.size();
      ((com.tencent.mm.plugin.sns.i.b)localObject1).rmT = ((com.tencent.mm.plugin.sns.i.b)localObject1).rol.size();
      ((com.tencent.mm.plugin.sns.i.b)localObject1).rmU = ((com.tencent.mm.plugin.sns.i.b)localObject1).rom.size();
      ((com.tencent.mm.plugin.sns.i.b)localObject1).rmW = ((com.tencent.mm.plugin.sns.i.b)localObject1).ron.size();
      ((com.tencent.mm.plugin.sns.i.b)localObject1).rmV = ((com.tencent.mm.plugin.sns.i.b)localObject1).roo.size();
      ((com.tencent.mm.plugin.sns.i.b)localObject1).rmX = ((com.tencent.mm.plugin.sns.i.b)localObject1).ros.size();
      ((com.tencent.mm.plugin.sns.i.b)localObject1).rnf = ((com.tencent.mm.plugin.sns.i.b)localObject1).rot.size();
      ((com.tencent.mm.plugin.sns.i.b)localObject1).jUj = ((com.tencent.mm.plugin.sns.i.b)localObject1).rop.size();
      ((com.tencent.mm.plugin.sns.i.b)localObject1).rmQ = ((com.tencent.mm.plugin.sns.i.b)localObject1).roq.size();
      ((com.tencent.mm.plugin.sns.i.b)localObject1).rmR = ((com.tencent.mm.plugin.sns.i.b)localObject1).ror.size();
      ((com.tencent.mm.plugin.sns.i.b)localObject1).rne = ((com.tencent.mm.plugin.sns.i.b)localObject1).rou.size();
      ((com.tencent.mm.plugin.sns.i.b)localObject1).rmA = ((com.tencent.mm.plugin.sns.i.b)localObject1).roj.size();
      localObject2 = paramn.csb();
      localObject1 = ((aw)localObject3).ikj;
      if (!bo.isNullOrNil((String)localObject1))
      {
        paramBaseViewHolder.shJ = ((aw)localObject3).rZu;
        paramBaseViewHolder.sgM.setTag(localObject1);
        if ((localObject2 == null) || (!((com.tencent.mm.plugin.sns.storage.b)localObject2).rqL)) {
          break label2589;
        }
        paramBaseViewHolder.sgM.setImageResource(2130838493);
        paramBaseViewHolder.sgM.dw((String)localObject1, 4);
        paramBaseViewHolder.sgM.setShowStoryHint(false);
        if (!bo.isNullOrNil(((com.tencent.mm.plugin.sns.storage.b)localObject2).rqN))
        {
          localObject4 = h.gy("adId", ((com.tencent.mm.plugin.sns.storage.b)localObject2).rqN);
          paramBaseViewHolder.sgM.setTag(2131820667, ((com.tencent.mm.plugin.sns.storage.b)localObject2).rqN);
          if (!com.tencent.mm.vfs.e.cN((String)localObject4)) {
            break label2569;
          }
          localObject2 = com.tencent.mm.plugin.sns.a.b.j.rac.getBitmap((String)localObject4);
          if (localObject2 != null) {
            paramBaseViewHolder.sgM.setImageBitmap((Bitmap)localObject2);
          }
        }
        label678:
        paramBaseViewHolder.sgN.a((String)localObject1, ((aw)localObject3).rZK, new BaseTimeLineItem.3(this, paramav), ((aw)localObject3).rEX, ((aw)localObject3).rGx, paramInt2, ((aw)localObject3).rEX);
        paramBaseViewHolder.sgM.eQq = ((aw)localObject3).rGx;
      }
      else
      {
        paramBaseViewHolder.sgO.setVisibility(8);
        if (!((aw)localObject3).rEX) {
          break label2864;
        }
        paramBaseViewHolder.raZ = true;
        paramBaseViewHolder.nmm = ((aw)localObject3).rZB;
        label762:
        if (((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.story.api.e.class)).hasNewStory((String)localObject1)) {
          ((aw)localObject3).rZt = null;
        }
        paramBaseViewHolder.sgQ.a(((aw)localObject3).rZx, paramav, ((aw)localObject3).rZy, (aw)localObject3);
        paramBaseViewHolder.sgQ.setShow(paramBaseViewHolder);
        paramBaseViewHolder.lbr.setOnTouchListener(new aa());
        a(paramBaseViewHolder, paramInt1, (aw)localObject3, paramTimeLineObject, paramInt2, paramav);
        a((aw)localObject3, paramTimeLineObject);
        paramav.rWR.put(Integer.valueOf(paramInt1), new WeakReference(paramBaseViewHolder.ngZ));
        if (paramBaseViewHolder.ngZ.getBackground() == null)
        {
          paramBaseViewHolder.ngZ.setBackgroundResource(2130838445);
          paramInt1 = com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 12);
          int i = com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 8);
          paramBaseViewHolder.ngZ.setPadding(paramInt1, paramInt1, paramInt1, i);
        }
        paramBaseViewHolder.timeTv.setText(((aw)localObject3).rZD);
        paramBaseViewHolder.sha.setVisibility(8);
        paramBaseViewHolder.shb.setVisibility(8);
        if (((aw)localObject3).rEX)
        {
          localObject2 = ((aw)localObject3).rZE;
          paramBaseViewHolder.sha.setTag(((aw)localObject3).rGx);
          if (((aw)localObject3).rZE.rpp != com.tencent.mm.plugin.sns.storage.a.rpb) {
            break label2884;
          }
          if (bo.isNullOrNil(((aw)localObject3).rZH)) {
            break label2872;
          }
          paramBaseViewHolder.sha.setText(((aw)localObject3).rZH);
          paramBaseViewHolder.sha.setVisibility(0);
          label1030:
          if ((paramBaseViewHolder.sha.getVisibility() != 8) && (bo.isNullOrNil(((com.tencent.mm.plugin.sns.storage.a)localObject2).rpr)))
          {
            paramBaseViewHolder.sha.setTextColor(this.mActivity.getResources().getColor(2131690516));
            paramBaseViewHolder.sha.setOnClickListener(null);
          }
          if ((paramn.csh().xTS.wOb & 0x4) == 0) {
            break label3195;
          }
          paramBaseViewHolder.shb.setTag(paramBaseViewHolder);
          paramBaseViewHolder.shb.setVisibility(0);
          paramBaseViewHolder.shb.setText(String.format("%s%s%s", new Object[] { this.mActivity.getResources().getString(2131303742), ((aw)localObject3).rZK, this.mActivity.getResources().getString(2131303743) }));
        }
        label1169:
        if (!((aw)localObject3).rZN) {
          break label3207;
        }
        localObject1 = paramav.cmc.getString(2131301341, new Object[] { Integer.valueOf(((aw)localObject3).rZO) });
        BaseViewHolder.g(paramBaseViewHolder).setText((CharSequence)localObject1);
        BaseViewHolder.g(paramBaseViewHolder).setVisibility(0);
        label1222:
        paramBaseViewHolder.rUN.setTag(((aw)localObject3).rGx);
        if (bo.isNullOrNil(((aw)localObject3).rZQ)) {
          break label3226;
        }
        paramBaseViewHolder.rUN.setVisibility(0);
        paramBaseViewHolder.rUN.setText(((aw)localObject3).rZQ);
        paramBaseViewHolder.rUN.setClickable(((aw)localObject3).rZR);
        localObject1 = paramBaseViewHolder.rUN;
        if (!((aw)localObject3).rZR) {
          break label3219;
        }
        paramInt1 = -11048043;
        label1295:
        ((TextView)localObject1).setTextColor(paramInt1);
        label1301:
        paramBaseViewHolder.lbr.setTextColor(this.mActivity.getResources().getColor(2131690489));
        if (!((aw)localObject3).rZS) {
          break label3238;
        }
        paramBaseViewHolder.lbr.setVisibility(0);
        localObject2 = this.mActivity.getString(2131303788) + ((aw)localObject3).mAppName;
        localObject1 = localObject2;
        if (((String)localObject2).length() > 10) {
          localObject1 = ((String)localObject2).substring(0, 10) + "...";
        }
        localObject1 = new SpannableString((CharSequence)localObject1);
        ((SpannableString)localObject1).setSpan(new b(), 0, ((SpannableString)localObject1).length(), 33);
        paramBaseViewHolder.lbr.setText((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
        if ((!((aw)localObject3).rZU) && (!"wx7fa037cc7dfabad5".equals(paramTimeLineObject.xTR.Id)))
        {
          paramBaseViewHolder.lbr.setTextColor(this.mActivity.getResources().getColor(2131690516));
          paramBaseViewHolder.lbr.setOnTouchListener(null);
        }
        paramBaseViewHolder.lbr.setTag(paramTimeLineObject);
        label1519:
        if (!((aw)localObject3).rZM) {
          break label3539;
        }
        paramBaseViewHolder.rHh.setVisibility(0);
        paramBaseViewHolder.rHh.setTag(((aw)localObject3).rGx);
        label1547:
        paramBaseViewHolder.shd.setTag(paramBaseViewHolder);
        if (!((aw)localObject3).rZY) {
          break label3638;
        }
        if (!paramBaseViewHolder.shs)
        {
          paramBaseViewHolder.shh = ((LinearLayout)paramBaseViewHolder.sho.inflate());
          paramBaseViewHolder.shi = paramBaseViewHolder.ngZ.findViewById(2131828064);
          paramBaseViewHolder.shs = true;
          paramBaseViewHolder.shi.setTag(((aw)localObject3).rGx);
          paramBaseViewHolder.rwK = ((TextView)paramBaseViewHolder.shh.findViewById(2131828064));
        }
        paramBaseViewHolder.sho.setVisibility(0);
        paramBaseViewHolder.shi.setOnClickListener(paramav.rks.sjA);
        label2097:
        switch (((aw)localObject3).rZZ)
        {
        default: 
          paramBaseViewHolder.rwK.setText(2131303932);
          paramBaseViewHolder.shi.setClickable(true);
          paramBaseViewHolder.shi.setEnabled(true);
          label1722:
          paramTimeLineObject = paramn.csz();
          if ((paramTimeLineObject != null) && (!bo.isNullOrNil(paramTimeLineObject.xsE))) {
            paramBaseViewHolder.rwK.setText(paramTimeLineObject.xsE);
          }
          label1756:
          if (((aw)localObject3).saa)
          {
            paramBaseViewHolder.shc.setVisibility(0);
            paramBaseViewHolder.shc.setTag(((aw)localObject3).rGx);
            label1784:
            if (!((aw)localObject3).sab) {
              break label3760;
            }
            if (bo.isNullOrNil(((aw)localObject3).sac)) {
              break label3699;
            }
            paramBaseViewHolder.sgZ.setVisibility(0);
            if (paramInt2 != 7) {
              break label3669;
            }
            paramTimeLineObject = String.format(this.mActivity.getString(2131304021), new Object[] { ((aw)localObject3).sac });
            paramTimeLineObject = com.tencent.mm.pluginsdk.ui.d.j.b(this.mActivity, paramTimeLineObject, paramBaseViewHolder.sgZ.getTextSize());
            paramBaseViewHolder.sgZ.setText(paramTimeLineObject);
            if (!((aw)localObject3).sae) {
              break label3772;
            }
            if (paramBaseViewHolder.shN == null)
            {
              paramBaseViewHolder.shN = paramBaseViewHolder.shM.inflate();
              paramBaseViewHolder.rcB = ((TextView)paramBaseViewHolder.shN.findViewById(2131825847));
              paramBaseViewHolder.shO = ((MaskTextView)paramBaseViewHolder.shN.findViewById(2131825849));
              paramBaseViewHolder.shO.setOnTouchListener(new aa());
            }
            paramBaseViewHolder.shN.setVisibility(0);
            b(paramBaseViewHolder.shO, ((aw)localObject3).sah, paramInt2);
            paramTimeLineObject = this.mActivity.getString(2131303892, new Object[] { Integer.valueOf(((aw)localObject3).saf), bo.E(((aw)localObject3).sag / 100.0D) });
            paramBaseViewHolder.rcB.setText(paramTimeLineObject);
            paramBaseViewHolder.shN.setTag(paramn);
            paramBaseViewHolder.shN.setOnClickListener(paramav.rks.sjD);
            label2043:
            if (((((aw)localObject3).sai != null) && (((aw)localObject3).sai.size() != 0)) || ((((aw)localObject3).saj != null) && (((aw)localObject3).saj.size() != 0))) {
              break label3810;
            }
            if (paramBaseViewHolder.rEv == null) {
              break label3791;
            }
            paramBaseViewHolder.rEv.setVisibility(8);
            if (!((aw)localObject3).sak) {
              break label4167;
            }
            paramBaseViewHolder.sgV.setTag(((aw)localObject3).rGx);
            paramBaseViewHolder.sgV.setText(((aw)localObject3).sal);
            paramBaseViewHolder.sgV.setVisibility(0);
            if (!((aw)localObject3).rEX) {
              break label4184;
            }
            ab.i("MicroMsg.BaseTimeLineItem", "adatag " + ((aw)localObject3).rZG);
            paramBaseViewHolder.rba.w(Long.valueOf(((aw)localObject3).rZw), new com.tencent.mm.plugin.sns.data.b(paramBaseViewHolder.rba, paramBaseViewHolder.position, ((aw)localObject3).rGx, ((aw)localObject3).rZw, ((aw)localObject3).rZC));
            paramBaseViewHolder.rba.a(((aw)localObject3).rZF, ((aw)localObject3).rZE);
            paramBaseViewHolder.rba.setVisibility(0);
            if ((paramBaseViewHolder.rUN != null) && (paramBaseViewHolder.rUN.getVisibility() == 0))
            {
              if (paramBaseViewHolder.rba.scn.getVisibility() != 0) {
                break label4179;
              }
              paramInt1 = 1;
              label2274:
              if (paramInt1 != 0)
              {
                paramn = (LinearLayout.LayoutParams)paramBaseViewHolder.rUN.getLayoutParams();
                paramn.setMargins(paramn.leftMargin, BackwardSupportUtil.b.b(this.mActivity, 0.0F), paramn.rightMargin, paramn.bottomMargin);
                paramBaseViewHolder.rUN.setLayoutParams(paramn);
              }
            }
          }
          label1845:
          label1872:
          label2137:
          break;
        }
      }
      break;
    }
    boolean bool;
    for (;;)
    {
      if (this.rNW) {
        ag.coW().a(this.mActivity, localSnsObject, paramBaseViewHolder);
      }
      paramn = new as(((aw)localObject3).rZv, ((aw)localObject3).rGx, false, true, 1);
      paramBaseViewHolder.sgR.getResultTextView().setTag(paramn);
      paramn = a.a.dDt();
      paramTimeLineObject = paramBaseViewHolder.ngZ;
      paramav = paramBaseViewHolder.sgN;
      localObject3 = paramBaseViewHolder.timeTv;
      localObject1 = paramBaseViewHolder.sgQ.getContent();
      localObject2 = paramBaseViewHolder.sgX;
      bool = paramBaseViewHolder.shI;
      if ((paramn.dDs()) && (paramn.zF != null) && (paramTimeLineObject != null) && (paramav != null) && (localObject3 != null)) {
        break label4196;
      }
      return;
      ((com.tencent.mm.plugin.sns.i.b)localObject1).rol.add(localObject2);
      break;
      ((com.tencent.mm.plugin.sns.i.b)localObject1).rok.add(localObject2);
      break;
      ((com.tencent.mm.plugin.sns.i.b)localObject1).ron.add(localObject2);
      break;
      ((com.tencent.mm.plugin.sns.i.b)localObject1).rom.add(localObject2);
      break;
      ((com.tencent.mm.plugin.sns.i.b)localObject1).ros.add(localObject2);
      break;
      ((com.tencent.mm.plugin.sns.i.b)localObject1).rot.add(localObject2);
      break;
      if (!bo.isNullOrNil(paramTimeLineObject.xTT))
      {
        ((com.tencent.mm.plugin.sns.i.b)localObject1).roq.add(localObject2);
        break;
      }
      ((com.tencent.mm.plugin.sns.i.b)localObject1).ror.add(localObject2);
      break;
      label2569:
      h.a(((com.tencent.mm.plugin.sns.storage.b)localObject2).rqN, new BaseTimeLineItem.2(this, paramBaseViewHolder));
      break label678;
      label2589:
      if (!((String)localObject1).endsWith("@ad")) {
        if (((aw)localObject3).rZL)
        {
          ab.i("MicroMsg.BaseTimeLineItem", "getContact %s", new Object[] { localObject1 });
          if (a.b.dmT().AY() != null) {
            paramBaseViewHolder.sgM.setImageBitmap(a.b.dmT().AY());
          }
          ao.a.flI.a((String)localObject1, "", new av.b(paramav.cvY(), paramInt1));
          label2678:
          if (((aw)localObject3).rZM) {
            break label2812;
          }
          com.tencent.mm.plugin.sns.ui.e.a.b(4, (String)paramBaseViewHolder.sgM.getTag(), paramBaseViewHolder.sgM);
          paramBaseViewHolder.sgM.dw((String)localObject1, 4);
          paramBaseViewHolder.sgM.setTag(localObject1);
          com.tencent.mm.plugin.sns.ui.e.a.a(4, (String)localObject1, paramBaseViewHolder.sgM);
          paramBaseViewHolder.sgM.setShowStoryHint(((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.story.api.e.class)).hasNewStory((String)localObject1));
        }
      }
      for (;;)
      {
        paramBaseViewHolder.sgN.a((String)localObject1, ((aw)localObject3).rZK, new BaseTimeLineItem.4(this, paramav), ((aw)localObject3).rEX, ((aw)localObject3).rGx, paramInt2, ((aw)localObject3).rEX);
        break;
        a.b.c(paramBaseViewHolder.sgM, (String)localObject1);
        break label2678;
        label2812:
        paramBaseViewHolder.sgM.dw((String)localObject1, 4);
        paramBaseViewHolder.sgM.setShowStoryHint(false);
        continue;
        paramBaseViewHolder.sgM.setImageResource(2130838493);
        paramBaseViewHolder.sgM.dw((String)localObject1, 4);
        paramBaseViewHolder.sgM.setShowStoryHint(false);
      }
      label2864:
      paramBaseViewHolder.raZ = false;
      break label762;
      label2872:
      paramBaseViewHolder.sha.setVisibility(8);
      break label1030;
      label2884:
      if (((com.tencent.mm.plugin.sns.storage.a)localObject2).rpp != com.tencent.mm.plugin.sns.storage.a.rpc) {
        break label1030;
      }
      if (!bo.isNullOrNil(((aw)localObject3).rZI))
      {
        localObject1 = ((aw)localObject3).rZJ;
        localObject4 = ((aw)localObject3).rZI;
        Object localObject5 = this.mActivity;
        paramBaseViewHolder.sha.getTextSize();
        localObject5 = new k(com.tencent.mm.pluginsdk.ui.d.j.c((Context)localObject5, (CharSequence)localObject4, 1));
        ((k)localObject5).a(null, (CharSequence)localObject4, 0);
        localObject4 = paramBaseViewHolder.sha.getPaint();
        float f = Layout.getDesiredWidth((CharSequence)localObject5, 0, ((k)localObject5).length(), (TextPaint)localObject4);
        if (com.tencent.mm.cb.a.ar(this.mActivity, (int)f) > paramBaseViewHolder.rOS)
        {
          do
          {
            if (((String)localObject1).length() <= 1) {
              break;
            }
            localObject1 = ((String)localObject1).substring(0, ((String)localObject1).length() - 2);
            localObject5 = String.format(((com.tencent.mm.plugin.sns.storage.a)localObject2).rpq, new Object[] { (String)localObject1 + "..." });
            Object localObject6 = this.mActivity;
            paramBaseViewHolder.sha.getTextSize();
            localObject6 = new k(com.tencent.mm.pluginsdk.ui.d.j.c((Context)localObject6, (CharSequence)localObject5, 1));
            ((k)localObject6).a(null, (CharSequence)localObject5, 0);
            f = Layout.getDesiredWidth((CharSequence)localObject6, 0, ((k)localObject6).length(), (TextPaint)localObject4);
            paramInt1 = com.tencent.mm.cb.a.ar(this.mActivity, (int)f);
            paramBaseViewHolder.sha.setText((CharSequence)localObject6, TextView.BufferType.SPANNABLE);
            paramBaseViewHolder.sha.setVisibility(0);
          } while (paramInt1 > paramBaseViewHolder.rOS);
          break label1030;
        }
        paramBaseViewHolder.sha.setText((CharSequence)localObject5, TextView.BufferType.SPANNABLE);
        paramBaseViewHolder.sha.setVisibility(0);
        break label1030;
      }
      paramBaseViewHolder.sha.setVisibility(8);
      break label1030;
      label3195:
      paramBaseViewHolder.shb.setVisibility(8);
      break label1169;
      label3207:
      BaseViewHolder.g(paramBaseViewHolder).setVisibility(8);
      break label1222;
      label3219:
      paramInt1 = -9211021;
      break label1295;
      label3226:
      paramBaseViewHolder.rUN.setVisibility(8);
      break label1301;
      label3238:
      if (((aw)localObject3).rZT)
      {
        paramBaseViewHolder.lbr.setVisibility(0);
        paramTimeLineObject = new SpannableString(((aw)localObject3).rZW);
        paramTimeLineObject.setSpan(new BaseTimeLineItem.c(this), 0, paramTimeLineObject.length(), 33);
        paramBaseViewHolder.lbr.setText(paramTimeLineObject, TextView.BufferType.SPANNABLE);
        paramBaseViewHolder.lbr.setTag(new ba(((aw)localObject3).rZV, ((aw)localObject3).rZW));
        break label1519;
      }
      if (((aw)localObject3).rZX)
      {
        paramBaseViewHolder.lbr.setVisibility(0);
        localObject1 = this.mActivity.getString(2131296572);
        localObject2 = (String)localObject1 + ((aw)localObject3).mAppName;
        localObject4 = new SpannableString((CharSequence)localObject2);
        ((SpannableString)localObject4).setSpan(new ForegroundColorSpan(this.mActivity.getResources().getColor(2131690516)), 0, ((String)localObject1).length(), 33);
        ((SpannableString)localObject4).setSpan(new BaseTimeLineItem.a(this), ((String)localObject1).length(), ((String)localObject2).length(), 33);
        paramBaseViewHolder.lbr.setText((CharSequence)localObject4, TextView.BufferType.SPANNABLE);
        if ((!((aw)localObject3).rZU) && (!"wx7fa037cc7dfabad5".equals(paramTimeLineObject.xTR.Id)))
        {
          paramBaseViewHolder.lbr.setTextColor(this.mActivity.getResources().getColor(2131690516));
          paramBaseViewHolder.lbr.setOnTouchListener(null);
        }
        paramBaseViewHolder.lbr.setTag(paramTimeLineObject);
        break label1519;
      }
      paramBaseViewHolder.lbr.setVisibility(8);
      break label1519;
      label3539:
      paramBaseViewHolder.rHh.setVisibility(8);
      break label1547;
      paramBaseViewHolder.rwK.setText(2131303929);
      paramBaseViewHolder.shi.setClickable(false);
      paramBaseViewHolder.shi.setEnabled(false);
      break label1722;
      paramBaseViewHolder.rwK.setText(2131303931);
      paramBaseViewHolder.shi.setClickable(false);
      paramBaseViewHolder.shi.setEnabled(false);
      break label1722;
      paramBaseViewHolder.rwK.setText(2131303930);
      paramBaseViewHolder.shi.setClickable(true);
      paramBaseViewHolder.shi.setEnabled(true);
      break label1722;
      label3638:
      if (!paramBaseViewHolder.shs) {
        break label1756;
      }
      paramBaseViewHolder.sho.setVisibility(8);
      break label1756;
      paramBaseViewHolder.shc.setVisibility(8);
      break label1784;
      label3669:
      paramTimeLineObject = String.format(this.mActivity.getString(2131304022), new Object[] { ((aw)localObject3).sac });
      break label1845;
      label3699:
      if (((aw)localObject3).sad)
      {
        paramBaseViewHolder.sgZ.setVisibility(0);
        paramTimeLineObject = this.mActivity.getString(2131304023);
        paramTimeLineObject = com.tencent.mm.pluginsdk.ui.d.j.b(this.mActivity, paramTimeLineObject.toString(), paramBaseViewHolder.sgZ.getTextSize());
        paramBaseViewHolder.sgZ.setText(paramTimeLineObject);
        break label1872;
      }
      label3760:
      paramBaseViewHolder.sgZ.setVisibility(8);
      break label1872;
      label3772:
      if (paramBaseViewHolder.shN == null) {
        break label2043;
      }
      paramBaseViewHolder.shN.setVisibility(8);
      break label2043;
      label3791:
      if (!paramBaseViewHolder.shn) {
        break label2097;
      }
      paramBaseViewHolder.shm.setVisibility(8);
      break label2097;
      label3810:
      if (!paramBaseViewHolder.shn)
      {
        if ((paramBaseViewHolder.rEv != null) || (paramBaseViewHolder.shm.getParent() == null)) {
          break label4091;
        }
        paramBaseViewHolder.rEv = ((LinearLayout)paramBaseViewHolder.shm.inflate());
        if (paramBaseViewHolder.rEv != null)
        {
          paramBaseViewHolder.shf = ((MaskTextView)paramBaseViewHolder.rEv.findViewById(2131828127));
          paramBaseViewHolder.shf.setOnTouchListener(new aa());
          paramBaseViewHolder.shg = ((LinearLayout)paramBaseViewHolder.ngZ.findViewById(2131828129));
          paramBaseViewHolder.rEv.setTag(((aw)localObject3).rZv);
          paramBaseViewHolder.shf.setTag(((aw)localObject3).rZv);
          paramBaseViewHolder.shl = paramBaseViewHolder.rEv.findViewById(2131828128);
          paramBaseViewHolder.shP = paramBaseViewHolder.rEv.findViewById(2131828126);
          paramBaseViewHolder.shn = true;
        }
      }
      if (paramBaseViewHolder.rEv != null) {
        paramBaseViewHolder.rEv.setVisibility(0);
      }
      if ((((aw)localObject3).sai != null) && (((aw)localObject3).sai.size() > 0))
      {
        paramBaseViewHolder.shf.setVisibility(0);
        a(paramBaseViewHolder.shf, ((aw)localObject3).sai, paramInt2);
        label4018:
        if (((aw)localObject3).saj == null) {
          break label4143;
        }
        a(localSnsObject.CommentUserList, ((aw)localObject3).saj, paramBaseViewHolder);
      }
      for (;;)
      {
        if ((((aw)localObject3).sai == null) || (((aw)localObject3).sai.size() == 0) || (((aw)localObject3).saj == null) || (((aw)localObject3).saj.size() == 0)) {
          break label4155;
        }
        paramBaseViewHolder.shl.setVisibility(0);
        break;
        label4091:
        if (paramBaseViewHolder.rEv == null) {}
        for (bool = true;; bool = false)
        {
          ab.e("MicroMsg.BaseTimeLineItem", "holder.listKeeper = null %s,and holder.commentStub.inflated", new Object[] { Boolean.valueOf(bool) });
          break;
        }
        paramBaseViewHolder.shf.setVisibility(8);
        break label4018;
        label4143:
        paramBaseViewHolder.shg.setVisibility(8);
      }
      label4155:
      paramBaseViewHolder.shl.setVisibility(8);
      break label2097;
      label4167:
      paramBaseViewHolder.sgV.setVisibility(8);
      break label2137;
      label4179:
      paramInt1 = 0;
      break label2274;
      label4184:
      paramBaseViewHolder.rba.setVisibility(8);
    }
    label4196:
    paramBaseViewHolder = new com.tencent.mm.ui.a.b();
    paramBaseViewHolder.atr(paramav.getText().toString());
    paramBaseViewHolder.atr((String)localObject1);
    if (localObject2 != null) {
      paramBaseViewHolder.atr(((TextView)localObject2).getText().toString());
    }
    if (bool) {
      paramBaseViewHolder.atr(paramn.zF.getString(2131298863));
    }
    paramBaseViewHolder.eK(paramTimeLineObject);
  }
  
  public abstract void a(BaseViewHolder paramBaseViewHolder, int paramInt1, aw paramaw, TimeLineObject paramTimeLineObject, int paramInt2, com.tencent.mm.plugin.sns.ui.av paramav);
  
  public abstract void d(BaseViewHolder paramBaseViewHolder);
  
  public final void setIsFromMainTimeline(boolean paramBoolean)
  {
    this.rNW = paramBoolean;
  }
  
  public static class BaseViewHolder
  {
    public String crk;
    public String czw;
    public volatile boolean ezJ;
    public int kwo;
    public TextView lbr;
    public View ngZ;
    public boolean nmm;
    public int position;
    public bct rDg;
    public LinearLayout rEv;
    public ImageView rFb;
    public TextView rHh;
    public int rOS;
    public TextView rUN;
    public View rUS;
    public boolean raZ;
    public bc rba;
    public TextView rcB;
    public TextView rwK;
    public aj sfG;
    public long sgK;
    public int sgL;
    public SnsAvatarImageView sgM;
    public AsyncTextView sgN;
    public ImageView sgO;
    public ViewGroup sgP;
    public AsyncNormalTextView sgQ;
    public SnsTranslateResultView sgR;
    public LinearLayout sgS;
    public ViewStub sgT;
    public boolean sgU;
    public TextView sgV;
    public TagImageView sgW;
    public TextView sgX;
    public int sgY;
    public TextView sgZ;
    public View shA;
    public LinearLayout shB;
    public ViewStub shC;
    public boolean shD;
    public View shE;
    public ImageView shF;
    public boolean shG;
    ViewStub shH;
    boolean shI;
    public com.tencent.mm.n.a shJ;
    public View shK;
    public BaseTimeLineItem shL;
    public ViewStub shM;
    public View shN;
    public MaskTextView shO;
    public View shP;
    private TextView shQ;
    public String shR;
    public AsyncTextView sha;
    public AsyncTextView shb;
    public View shc;
    public ImageView shd;
    public View she;
    public MaskTextView shf;
    public LinearLayout shg;
    public LinearLayout shh;
    public View shi;
    public LinearLayout shj;
    public PhotosContent shk;
    public View shl;
    public ViewStub shm;
    public boolean shn;
    public ViewStub sho;
    public ViewStub shp;
    public View shq;
    public boolean shr;
    public boolean shs;
    public ViewStub sht;
    public boolean shu;
    public View shv;
    public LinearLayout shw;
    public TextView shx;
    public ViewStub shy;
    public boolean shz;
    public SnsObject snsobj;
    public TimeLineObject timeLineObject;
    public TextView timeTv;
    public TextView titleTv;
    
    public BaseViewHolder()
    {
      AppMethodBeat.i(40125);
      this.sgU = false;
      this.sgY = 0;
      this.rOS = 210;
      this.shn = false;
      this.shq = null;
      this.shr = false;
      this.shs = false;
      this.shu = false;
      this.shz = false;
      this.shD = false;
      this.shG = false;
      this.shI = false;
      this.sfG = new aj();
      AppMethodBeat.o(40125);
    }
  }
  
  final class b
    extends o
  {
    b() {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(40123);
      BaseTimeLineItem.this.rkX.rON.scw.onClick(paramView);
      AppMethodBeat.o(40123);
    }
    
    public final void updateDrawState(TextPaint paramTextPaint)
    {
      AppMethodBeat.i(40124);
      int i = BaseTimeLineItem.this.mActivity.getResources().getColor(2131690488);
      if (getPress())
      {
        paramTextPaint.bgColor = i;
        AppMethodBeat.o(40124);
        return;
      }
      paramTextPaint.bgColor = 0;
      AppMethodBeat.o(40124);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem
 * JD-Core Version:    0.7.0.1
 */