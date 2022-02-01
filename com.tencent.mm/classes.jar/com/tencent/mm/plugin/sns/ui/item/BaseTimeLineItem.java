package com.tencent.mm.plugin.sns.ui.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
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
import com.tencent.mm.g.b.a.il;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.b;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.secdata.f;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC.a;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.k.e.a;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.au;
import com.tencent.mm.plugin.sns.model.au.b;
import com.tencent.mm.plugin.sns.model.aw;
import com.tencent.mm.plugin.sns.model.bc;
import com.tencent.mm.plugin.sns.model.g.5;
import com.tencent.mm.plugin.sns.model.g.d;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.plugin.sns.ui.AsyncNormalTextView;
import com.tencent.mm.plugin.sns.ui.AsyncTextView;
import com.tencent.mm.plugin.sns.ui.MaskTextView;
import com.tencent.mm.plugin.sns.ui.PhotosContent;
import com.tencent.mm.plugin.sns.ui.SnsLikesTextView;
import com.tencent.mm.plugin.sns.ui.SnsTranslateResultView;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.TranslateCommentTextView;
import com.tencent.mm.plugin.sns.ui.af;
import com.tencent.mm.plugin.sns.ui.bg;
import com.tencent.mm.plugin.sns.ui.bk;
import com.tencent.mm.plugin.sns.ui.bk.c;
import com.tencent.mm.plugin.sns.ui.bl;
import com.tencent.mm.plugin.sns.ui.bo;
import com.tencent.mm.plugin.sns.ui.bq;
import com.tencent.mm.plugin.sns.ui.br;
import com.tencent.mm.plugin.sns.ui.i;
import com.tencent.mm.plugin.sns.ui.i.a;
import com.tencent.mm.plugin.sns.ui.widget.SnsAvatarImageView;
import com.tencent.mm.plugin.sns.ui.widget.SnsCommentCollapseLayout;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.j.a;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.pluginsdk.ui.span.q;
import com.tencent.mm.pluginsdk.ui.span.q.a;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.cnc;
import com.tencent.mm.protocal.protobuf.dzo;
import com.tencent.mm.protocal.protobuf.dzu;
import com.tencent.mm.protocal.protobuf.fa;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.vfs.s;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import kotlin.g.b.p;

public abstract class BaseTimeLineItem
{
  public boolean DEBUG = false;
  protected bk DQX;
  protected boolean EAv = false;
  public ArrayList<au.b> EWs = new ArrayList();
  protected Activity mActivity;
  private com.tencent.mm.pluginsdk.ui.span.a mAdTagClickCallback = new com.tencent.mm.pluginsdk.ui.span.a()
  {
    public final void iL(int paramAnonymousInt1, int paramAnonymousInt2)
    {
      AppMethodBeat.i(203908);
      try
      {
        SnsInfo localSnsInfo = BaseTimeLineItem.this.DQX.Zv(paramAnonymousInt1);
        if (localSnsInfo != null)
        {
          Log.i("AdTagClickableHelper", "BaseTimeLineItem position = " + paramAnonymousInt1 + ", snsId = " + localSnsInfo.field_snsId + ", source = SOURCE_TIMELINE , clickPos = " + paramAnonymousInt2);
          com.tencent.mm.plugin.sns.ad.timeline.b.b.a(BaseTimeLineItem.this.mActivity, 0, localSnsInfo, paramAnonymousInt2);
          AppMethodBeat.o(203908);
          return;
        }
        Log.e("AdTagClickableHelper", "BaseTimeLineItem, snsInfo is null");
        AppMethodBeat.o(203908);
        return;
      }
      catch (Throwable localThrowable)
      {
        Log.e("AdTagClickableHelper", localThrowable.toString());
        AppMethodBeat.o(203908);
      }
    }
  };
  protected int qcr;
  
  private static void a(View paramView, CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt1, int paramInt2, dzo paramdzo)
  {
    if ((paramView instanceof SnsCommentCollapseLayout)) {
      ((SnsCommentCollapseLayout)paramView).a(paramCharSequence1, paramCharSequence2, paramInt1, paramInt2);
    }
    for (;;)
    {
      paramCharSequence1 = com.tencent.mm.plugin.sns.i.a.DRI;
      com.tencent.mm.plugin.sns.i.a.a.a(paramView, paramdzo);
      return;
      if ((paramView instanceof TextView)) {
        ((TextView)paramView).setText(paramCharSequence1);
      }
    }
  }
  
  public static void a(au.b paramb, BaseViewHolder paramBaseViewHolder, String paramString1, String paramString2)
  {
    if ((paramBaseViewHolder != null) && (paramBaseViewHolder.EWB != null))
    {
      paramBaseViewHolder.EWB.a(paramb, 1, paramString1, paramString2, paramb.DNh);
      paramBaseViewHolder.EWB.setVisibility(0);
    }
  }
  
  private void a(ADInfo paramADInfo, BaseViewHolder paramBaseViewHolder)
  {
    if ((paramADInfo == null) || (paramBaseViewHolder == null)) {
      Log.i("MicroMsg.BaseTimeLineItem", "adInfo or holder is null");
    }
    for (;;)
    {
      return;
      try
      {
        if ((paramADInfo.adChainType == 1) && (!Util.isNullOrNil(paramADInfo.adActionExtTailFormattedWording)))
        {
          String str = paramADInfo.adActionExtTailUserDisplayName;
          Object localObject1 = paramADInfo.adActionExtTailFormattedWording;
          Object localObject2 = this.mActivity;
          paramBaseViewHolder.EWM.getTextSize();
          localObject2 = new com.tencent.mm.pluginsdk.ui.span.m(com.tencent.mm.pluginsdk.ui.span.l.f((Context)localObject2, (CharSequence)localObject1, 1));
          ((com.tencent.mm.pluginsdk.ui.span.m)localObject2).a(null, (CharSequence)localObject1, 0);
          localObject1 = paramBaseViewHolder.EWM.getPaint();
          float f = Layout.getDesiredWidth((CharSequence)localObject2, 0, ((com.tencent.mm.pluginsdk.ui.span.m)localObject2).length(), (TextPaint)localObject1);
          if (com.tencent.mm.cb.a.E(this.mActivity, (int)f) > paramBaseViewHolder.EBt)
          {
            int i;
            do
            {
              if (str.length() <= 1) {
                break;
              }
              str = str.substring(0, str.length() - 2);
              localObject2 = String.format(paramADInfo.adActionExtTailWording, new Object[] { str + "..." });
              Object localObject3 = this.mActivity;
              paramBaseViewHolder.EWM.getTextSize();
              localObject3 = new com.tencent.mm.pluginsdk.ui.span.m(com.tencent.mm.pluginsdk.ui.span.l.f((Context)localObject3, (CharSequence)localObject2, 1));
              ((com.tencent.mm.pluginsdk.ui.span.m)localObject3).a(null, (CharSequence)localObject2, 0);
              f = Layout.getDesiredWidth((CharSequence)localObject3, 0, ((com.tencent.mm.pluginsdk.ui.span.m)localObject3).length(), (TextPaint)localObject1);
              i = com.tencent.mm.cb.a.E(this.mActivity, (int)f);
              paramBaseViewHolder.EWM.setText((CharSequence)localObject3, TextView.BufferType.SPANNABLE);
              paramBaseViewHolder.EWM.setVisibility(0);
            } while (i > paramBaseViewHolder.EBt);
            return;
          }
          paramBaseViewHolder.EWM.setText((CharSequence)localObject2, TextView.BufferType.SPANNABLE);
          paramBaseViewHolder.EWM.setVisibility(0);
          return;
        }
      }
      catch (Throwable paramADInfo)
      {
        Log.e("MicroMsg.BaseTimeLineItem", paramADInfo.toString());
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
          localSpannableStringBuilder.append(com.tencent.mm.pluginsdk.ui.span.l.b(this.mActivity, (CharSequence)localObject, paramMaskTextView.getTextSize()));
          i += 1;
          break;
          localSpannableStringBuilder.append(", ");
          localStringBuffer.append(", ");
        }
      }
      localObject = this.mActivity.getResources().getDrawable(2131690345);
    }
    catch (Exception paramMaskTextView)
    {
      Log.e("MicroMsg.BaseTimeLineItem", "setReward error  e:%s", new Object[] { Util.stackTraceToString(paramMaskTextView) });
      return;
    }
    ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
    com.tencent.mm.ui.widget.a locala = new com.tencent.mm.ui.widget.a((Drawable)localObject);
    locala.QBM = ((int)((((Drawable)localObject).getIntrinsicHeight() - paramMaskTextView.getTextSize() + com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 2)) / 2.0F));
    localSpannableStringBuilder.setSpan(locala, k, k + 1, 33);
    if (paramInt == 10)
    {
      paramInt = 3;
      break label407;
      while (i < arrayOfInt1.length)
      {
        localSpannableStringBuilder.setSpan(new q((String)((com.tencent.mm.vending.j.a)paramb.get(i)).get(0), this.DQX.EBk, paramInt), arrayOfInt1[i], arrayOfInt2[i], 33);
        i += 1;
      }
      paramMaskTextView.setText(localSpannableStringBuilder, TextView.BufferType.SPANNABLE);
      paramMaskTextView.setOriginText(localStringBuffer.toString());
      return;
    }
    for (;;)
    {
      label407:
      i = 0;
      break;
      paramInt = 2;
    }
  }
  
  private void a(bl parambl, TimeLineObject paramTimeLineObject)
  {
    if ((parambl == null) || (paramTimeLineObject == null)) {}
    for (;;)
    {
      return;
      if (paramTimeLineObject.AppInfo == null) {}
      for (String str = null; !Util.isNullOrNil(str); str = paramTimeLineObject.AppInfo.Id)
      {
        com.tencent.mm.plugin.sns.c.a.jRu.a(str, paramTimeLineObject.UserName, paramTimeLineObject.ContentObj.LoU, paramTimeLineObject.statisticsData, parambl.ENp);
        return;
      }
    }
  }
  
  private static void a(BaseViewHolder paramBaseViewHolder, SnsInfo paramSnsInfo)
  {
    if (paramSnsInfo.isAd())
    {
      if (paramBaseViewHolder.EWA != null) {
        paramBaseViewHolder.EWA.setVisibility(0);
      }
      paramBaseViewHolder.EWC.setLongClickable(false);
      paramBaseViewHolder.EWC.setOnClickListener(null);
      paramSnsInfo = new LinearLayout.LayoutParams(-1, -2);
      paramBaseViewHolder.EWC.setLayoutParams(paramSnsInfo);
      paramBaseViewHolder.EWC.setBackgroundColor(Color.parseColor("#00ffffff"));
      if (paramBaseViewHolder.EWX != null)
      {
        paramSnsInfo = (LinearLayout.LayoutParams)paramBaseViewHolder.EWX.getLayoutParams();
        paramSnsInfo.leftMargin = 0;
        paramSnsInfo.rightMargin = 0;
        paramBaseViewHolder.EWX.setLayoutParams(paramSnsInfo);
      }
      if (paramBaseViewHolder.EXv)
      {
        paramSnsInfo = (LinearLayout.LayoutParams)paramBaseViewHolder.EUK.Ewr.getLayoutParams();
        paramSnsInfo.leftMargin = 0;
        paramSnsInfo.rightMargin = 0;
        paramBaseViewHolder.EUK.Ewr.setLayoutParams(paramSnsInfo);
      }
      return;
    }
    if (paramBaseViewHolder.EWA != null) {
      paramBaseViewHolder.EWA.setVisibility(0);
    }
    paramBaseViewHolder.EWC.setLongClickable(false);
    paramBaseViewHolder.EWC.setOnClickListener(null);
    if (paramBaseViewHolder.EWX != null)
    {
      paramSnsInfo = (LinearLayout.LayoutParams)paramBaseViewHolder.EWX.getLayoutParams();
      paramSnsInfo.leftMargin = 0;
      paramSnsInfo.rightMargin = 0;
      paramBaseViewHolder.EWX.setLayoutParams(paramSnsInfo);
    }
    if (paramBaseViewHolder.EXv)
    {
      paramSnsInfo = (LinearLayout.LayoutParams)paramBaseViewHolder.EUK.Ewr.getLayoutParams();
      paramSnsInfo.leftMargin = 0;
      paramSnsInfo.rightMargin = 0;
      paramBaseViewHolder.EUK.Ewr.setLayoutParams(paramSnsInfo);
    }
    paramSnsInfo = new LinearLayout.LayoutParams(-1, -2);
    paramBaseViewHolder.EWC.setLayoutParams(paramSnsInfo);
    paramBaseViewHolder.EWC.setBackgroundColor(Color.parseColor("#00ffffff"));
  }
  
  private boolean a(List<dzo> paramList, com.tencent.mm.vending.d.b<com.tencent.mm.vending.j.a> paramb, BaseViewHolder paramBaseViewHolder, bl parambl, int paramInt, SnsInfo paramSnsInfo)
  {
    LinearLayout localLinearLayout = paramBaseViewHolder.EWT;
    int i1 = localLinearLayout.getChildCount();
    int j = paramb.size();
    Object localObject1;
    if (i1 > j)
    {
      i = j;
      while (i < i1)
      {
        localObject1 = localLinearLayout.getChildAt(j);
        localLinearLayout.removeViewAt(j);
        if ((localObject1 instanceof SnsCommentCollapseLayout)) {
          this.DQX.a((SnsCommentCollapseLayout)localObject1);
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
    if (this.DEBUG) {
      Log.d("MicroMsg.BaseTimeLineItem", "debug:setCommentList position " + paramBaseViewHolder.position + " commentCount: " + j);
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    int m = 0;
    int i = 0;
    int k = 0;
    long l;
    String str1;
    String str2;
    String str3;
    Object localObject4;
    Object localObject6;
    Object localObject5;
    if (m < paramb.size())
    {
      localObject1 = (com.tencent.mm.vending.j.a)paramb.get(m);
      l = ((Long)((com.tencent.mm.vending.j.a)localObject1).get(0)).longValue();
      str1 = (String)((com.tencent.mm.vending.j.a)localObject1).get(1);
      str2 = (String)((com.tencent.mm.vending.j.a)localObject1).get(2);
      str3 = (String)((com.tencent.mm.vending.j.a)localObject1).get(3);
      localObject4 = (CharSequence)((com.tencent.mm.vending.j.a)localObject1).get(4);
      localObject6 = (String)((com.tencent.mm.vending.j.a)localObject1).get(5);
      localObject5 = (CharSequence)((com.tencent.mm.vending.j.a)localObject1).get(6);
      if (Util.isNullOrNil((String)localObject6)) {
        break label2211;
      }
      j = 1;
      localStringBuilder2.append(l).append("|");
    }
    for (;;)
    {
      localStringBuilder1.append(l).append("|");
      dzo localdzo = (dzo)paramList.get(m);
      i = localdzo.MYX;
      int i2 = localdzo.DeleteFlag;
      Object localObject7 = br(paramBaseViewHolder.dRS, l);
      if ((localObject7 != null) && (((au.b)localObject7).aGI)) {
        au.fB(((au.b)localObject7).id, 2);
      }
      label480:
      int n;
      Object localObject2;
      if (k >= i1) {
        if ((localObject7 == null) || (((au.b)localObject7).aGI))
        {
          localObject1 = this.DQX.fiO();
          ((SnsCommentCollapseLayout)localObject1).setTextSize$255e752(15.0F * com.tencent.mm.cb.a.ez(((View)localObject1).getContext()));
          if (this.DQX.EKq == -1) {
            this.DQX.EKq = this.mActivity.getResources().getColor(2131101124);
          }
          ((SnsCommentCollapseLayout)localObject1).setTextColor(this.DQX.EKq);
          ((SnsCommentCollapseLayout)localObject1).setGravity(16);
          n = 1;
          localObject2 = localObject1;
        }
      }
      label723:
      Object localObject8;
      label787:
      Object localObject3;
      for (;;)
      {
        if (localObject7 != null)
        {
          localObject1 = localObject2;
          if (!(localObject2 instanceof TranslateCommentTextView))
          {
            localLinearLayout.removeView((View)localObject2);
            localObject1 = new TranslateCommentTextView(this.mActivity);
            localLinearLayout.addView((View)localObject1, k);
            ((TranslateCommentTextView)localObject1).getTranslateResultView().setResultTextSize$255e752(15.0F * com.tencent.mm.cb.a.ez(((View)localObject1).getContext()));
            ((TranslateCommentTextView)localObject1).getOriginCommentTextView().setTextSize(1, 15.0F * com.tencent.mm.cb.a.ez(((View)localObject1).getContext()));
          }
          localObject6 = (TranslateCommentTextView)localObject1;
          ((View)localObject1).setOnTouchListener(null);
          a(((TranslateCommentTextView)localObject6).getOriginCommentTextView(), (CharSequence)localObject5, (CharSequence)localObject4, i, i2, localdzo);
          if (!((au.b)localObject7).iGD)
          {
            ((TranslateCommentTextView)localObject6).ERU.setTextSize(1, 15.0F * com.tencent.mm.cb.a.ez(((TranslateCommentTextView)localObject6).getContext()));
            ((TranslateCommentTextView)localObject6).ECF.ZW(2);
            ((TranslateCommentTextView)localObject6).ECF.setVisibility(0);
            i = 1;
            if (k <= 0) {
              break label1904;
            }
            ((View)localObject1).setPadding(com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 8), com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 4), com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 0), com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 3));
            if (k != paramb.size() - 1) {
              break label1893;
            }
            ((View)localObject1).setBackgroundResource(2131235017);
            if (i != 0)
            {
              localObject2 = (TranslateCommentTextView)localObject1;
              i = (int)this.mActivity.getResources().getDimension(2131165586);
              ((TranslateCommentTextView)localObject2).ECF.getSplitlineView().setPadding(0, 0, i, 0);
            }
            if (!com.tencent.mm.plugin.sns.ui.widget.e.c(localdzo)) {
              break label2010;
            }
            ((View)localObject1).setOnLongClickListener(null);
            ((View)localObject1).setOnClickListener(null);
            if (parambl != null) {
              ((View)localObject1).setTag(new com.tencent.mm.plugin.sns.ui.m(parambl.Eql, parambl.Dsr, localdzo, str1, str3, (View)localObject1, 1, parambl.mRa));
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
            ((TranslateCommentTextView)localObject1).getTranslateResultView().setResultTextSize$255e752(15.0F * com.tencent.mm.cb.a.ez(((View)localObject1).getContext()));
            ((TranslateCommentTextView)localObject1).getOriginCommentTextView().setTextSize(1, 15.0F * com.tencent.mm.cb.a.ez(((View)localObject1).getContext()));
            break label480;
            localObject2 = localLinearLayout.getChildAt(k);
            n = 0;
            continue;
          }
          if (!((au.b)localObject7).aGI)
          {
            localObject4 = ((au.b)localObject7).result;
            localObject5 = ((au.b)localObject7).brand;
            localObject8 = ((TranslateCommentTextView)localObject6).ERU.getText().toString();
            if (!Util.isNullOrNil((String)localObject8))
            {
              localObject2 = ((String)localObject8).split(":");
              if (localObject2.length <= 2) {
                break label2208;
              }
              localObject3 = new String[2];
              localObject3[0] = localObject2[0];
              localObject3[1] = ((String)localObject8).substring(localObject3[0].length() + 1);
              localObject2 = localObject3;
            }
          }
        }
      }
      label2208:
      for (;;)
      {
        if (localObject2.length == 2)
        {
          if (Util.isNullOrNil((String)localObject4)) {
            break label1139;
          }
          ((TranslateCommentTextView)localObject6).ECF.a((au.b)localObject7, 2, localObject2[0] + ": " + (String)localObject4, (String)localObject5, ((au.b)localObject7).DNh);
        }
        for (;;)
        {
          ((TranslateCommentTextView)localObject6).ECF.setVisibility(0);
          ((TranslateCommentTextView)localObject6).ERU.setTextSize(1, 15.0F * com.tencent.mm.cb.a.ez(((TranslateCommentTextView)localObject6).getContext()));
          i = 1;
          break;
          label1139:
          ((TranslateCommentTextView)localObject6).ECF.a((au.b)localObject7, 2, null, (String)localObject5, ((au.b)localObject7).DNh);
        }
        ((TranslateCommentTextView)localObject6).getTranslateResultView().setVisibility(8);
        i = 1;
        break;
        if ((n == 0) && ((localObject2 instanceof TranslateCommentTextView)))
        {
          localLinearLayout.removeView((View)localObject2);
          localObject1 = this.DQX.fiO();
          localLinearLayout.addView((View)localObject1, k);
          ((SnsCommentCollapseLayout)localObject1).setTextSize$255e752(15.0F * com.tencent.mm.cb.a.ez(((View)localObject1).getContext()));
        }
        for (;;)
        {
          if ((localObject1 instanceof SnsCommentCollapseLayout))
          {
            ((SnsCommentCollapseLayout)localObject1).setTextSize$255e752(15.0F * com.tencent.mm.cb.a.ez(((View)localObject1).getContext()));
            ((SnsCommentCollapseLayout)localObject1).setOpClickListener(this.DQX.EKG);
            localObject2 = new o(this.mActivity);
            if (com.tencent.mm.plugin.sns.ui.widget.e.b(paramSnsInfo, localdzo.Username))
            {
              ((o)localObject2).setAdTagClickCallback(this.mAdTagClickCallback, paramInt);
              ((o)localObject2).mAdTagClickScene = 31;
            }
            ((SnsCommentCollapseLayout)localObject1).setPressTouchListener((View.OnTouchListener)localObject2);
          }
          localObject3 = new CharSequence[2];
          localObject3[0] = localObject5;
          localObject3[1] = localObject4;
          localObject1.hashCode();
          if ((Util.isNullOrNil((String)localObject6)) || (!(localObject1 instanceof SnsCommentCollapseLayout)))
          {
            a((View)localObject1, localObject3[0], localObject3[1], i, i2, localdzo);
            i = 0;
            break;
          }
          localObject2 = aj.faL();
          localObject7 = new d((String)localObject6, (CharSequence)localObject5, (CharSequence)localObject4, (View)localObject1, i, i2, this.DQX.EKu);
          localObject8 = com.tencent.mm.emoji.loader.a.b.gVU;
          localObject8 = com.tencent.mm.emoji.loader.a.b.EP((String)localObject6);
          if (localObject8 == null) {
            aj.faB().execute(new g.5((com.tencent.mm.plugin.sns.model.g)localObject2, (String)localObject6, (g.d)localObject7));
          }
          int i3 = com.tencent.mm.ui.at.fromDPToPix(this.mActivity, 28);
          localObject6 = new StringBuilder((String)localObject6);
          if (localObject8 == null)
          {
            ((StringBuilder)localObject6).append("miss");
            Log.i("MicroMsg.BaseTimeLineItem", "wrapEmojiInfo:%s miss cache", new Object[] { ((StringBuilder)localObject6).toString() });
          }
          for (localObject2 = this.mActivity.getResources().getDrawable(2131234979);; localObject2 = new BitmapDrawable((Bitmap)localObject8))
          {
            localObject5 = new SpannableStringBuilder((CharSequence)localObject5);
            ((SpannableStringBuilder)localObject5).append("  ").append(((StringBuilder)localObject6).toString()).append("  ").append(" ");
            int i4 = ((SpannableStringBuilder)localObject5).length() - ((StringBuilder)localObject6).toString().length() - 2 - 1;
            int i5 = ((SpannableStringBuilder)localObject5).length() - ((StringBuilder)localObject6).toString().length() - 4 - 1;
            ((Drawable)localObject2).setBounds(0, 0, i3, i3);
            localObject7 = new com.tencent.mm.ui.widget.a((Drawable)localObject2);
            localObject8 = new q(((StringBuilder)localObject6).toString(), this.DQX.EKu, 2);
            ((SpannableStringBuilder)localObject5).setSpan(localObject7, i4, ((StringBuilder)localObject6).toString().length() + i4, 33);
            ((SpannableStringBuilder)localObject5).setSpan(localObject8, i5, i5 + 4 + ((StringBuilder)localObject6).toString().length(), 33);
            localObject4 = new SpannableStringBuilder((CharSequence)localObject4);
            ((SpannableStringBuilder)localObject4).append("  ").append(((StringBuilder)localObject6).toString()).append("  ").append(" ");
            i4 = ((SpannableStringBuilder)localObject4).length() - ((StringBuilder)localObject6).toString().length() - 2 - 1;
            i5 = ((SpannableStringBuilder)localObject4).length() - ((StringBuilder)localObject6).toString().length() - 4 - 1;
            ((Drawable)localObject2).setBounds(0, 0, i3, i3);
            ((SpannableStringBuilder)localObject4).setSpan(localObject7, i4, ((StringBuilder)localObject6).toString().length() + i4, 33);
            ((SpannableStringBuilder)localObject4).setSpan(localObject8, i5, i5 + 4 + ((StringBuilder)localObject6).toString().length(), 33);
            localObject3[0] = localObject5;
            localObject3[1] = localObject4;
            break;
            Log.i("MicroMsg.BaseTimeLineItem", "wrapEmojiInfo:%s hit cache", new Object[] { ((StringBuilder)localObject6).toString() });
          }
          label1893:
          ((View)localObject1).setBackgroundResource(2131234959);
          break label723;
          label1904:
          ((View)localObject1).setPadding(com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 8), com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 6), com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 0), com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 3));
          if (paramBaseViewHolder.EWS)
          {
            if (paramb.size() == 1)
            {
              ((View)localObject1).setBackgroundResource(2131235017);
              break label723;
            }
            ((View)localObject1).setBackgroundResource(2131234959);
            break label723;
          }
          if (paramb.size() == 1)
          {
            ((View)localObject1).setBackgroundResource(2131235016);
            break label723;
          }
          ((View)localObject1).setBackgroundResource(2131235018);
          break label723;
          label2010:
          ((View)localObject1).setOnLongClickListener(new View.OnLongClickListener()
          {
            public final boolean onLongClick(View paramAnonymousView)
            {
              AppMethodBeat.i(203913);
              Object localObject = new com.tencent.mm.hellhoundlib.b.b();
              ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/item/BaseTimeLineItem$9", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
              localObject = new int[2];
              if ((paramAnonymousView.getTag(2131309367) instanceof int[])) {}
              for (paramAnonymousView = (int[])paramAnonymousView.getTag(2131309367);; paramAnonymousView = (View)localObject)
              {
                BaseTimeLineItem.this.DQX.fiV().a(this.ERE, BaseTimeLineItem.this.DQX.DQs.FaE, BaseTimeLineItem.this.DQX.DQs.Far, paramAnonymousView[0], paramAnonymousView[1]);
                com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sns/ui/item/BaseTimeLineItem$9", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                AppMethodBeat.o(203913);
                return true;
              }
            }
          });
          ((View)localObject1).setOnClickListener(new i.a(this.DQX.EKl, localdzo, str2, str3, paramBaseViewHolder));
          break label787;
          if (i != 0)
          {
            paramList = com.tencent.mm.plugin.sns.k.e.DUQ;
            paramInt = paramBaseViewHolder.position;
            l = parambl.DqO.field_snsId;
            paramb = localStringBuilder2.toString();
            paramSnsInfo = localStringBuilder1.toString();
            paramBaseViewHolder = r.Jb(l);
            if (paramList.DVd.get(paramBaseViewHolder) == null)
            {
              parambl = new il();
              parambl.eOG = parambl.x("PublishId", paramBaseViewHolder, true);
              parambl.eOH = parambl.x("CommentIdList", paramSnsInfo, true);
              parambl.eOI = parambl.x("EmojiIdList", paramb, true);
              paramb = new e.a(paramList);
              paramb.position = paramInt;
              paramb.DVN = parambl;
              paramList.DVd.put(paramBaseViewHolder, paramb);
            }
          }
          return true;
          localObject1 = localObject2;
        }
      }
      label2211:
      j = i;
    }
  }
  
  private void b(BaseViewHolder paramBaseViewHolder, SnsInfo paramSnsInfo)
  {
    paramBaseViewHolder.EXN.setVisibility(8);
    Object localObject1;
    Object localObject2;
    if ((this.DQX != null) && (this.DQX.EKy))
    {
      localObject1 = aj.faW();
      long l = paramSnsInfo.field_snsId;
      localObject2 = "select *,rowid from SnsWsFoldGroup  where SnsWsFoldGroup.bottom<=" + l + " AND SnsWsFoldGroup.top>=" + l;
      localObject2 = ((x)localObject1).iFy.rawQuery((String)localObject2, null, 2);
      if (localObject2 == null) {
        break label518;
      }
      if (!((Cursor)localObject2).moveToFirst()) {
        break label512;
      }
      localObject1 = new w();
      ((w)localObject1).convertFrom((Cursor)localObject2);
      ((Cursor)localObject2).close();
    }
    for (;;)
    {
      String str1;
      String str2;
      int i;
      if (localObject1 != null)
      {
        str1 = r.Jc(((w)localObject1).field_top);
        str2 = r.Jc(((w)localObject1).field_bottom);
        Object localObject3 = aj.faO();
        localObject2 = com.tencent.mm.plugin.sns.storage.n.feR();
        if (str1 != null)
        {
          localObject1 = localObject2;
          if (str1.equals("")) {}
        }
        else
        {
          localObject1 = (String)localObject2 + " AND " + ((com.tencent.mm.plugin.sns.storage.n)localObject3).aQB(str1);
        }
        localObject2 = localObject1;
        if (com.tencent.mm.plugin.sns.storage.n.aQw(str2)) {
          localObject2 = (String)localObject1 + " AND " + ((com.tencent.mm.plugin.sns.storage.n)localObject3).aQx(str2);
        }
        localObject1 = (String)localObject2 + com.tencent.mm.plugin.sns.storage.n.Emu;
        Log.d("MicroMsg.SnsInfoStorage", "getCursorByTimeLineSeqIncluded ".concat(String.valueOf(localObject1)));
        localObject1 = ((com.tencent.mm.plugin.sns.storage.n)localObject3).iFy.rawQuery((String)localObject1, null);
        localObject2 = new ArrayList();
        if (localObject1 != null)
        {
          while (((Cursor)localObject1).moveToNext())
          {
            localObject3 = new SnsInfo();
            ((SnsInfo)localObject3).convertFrom((Cursor)localObject1);
            ((List)localObject2).add(localObject3);
          }
          ((Cursor)localObject1).close();
        }
        i = 0;
        if (i >= ((List)localObject2).size()) {
          break label507;
        }
        if (((SnsInfo)((List)localObject2).get(i)).field_snsId != paramSnsInfo.field_snsId) {
          break label500;
        }
      }
      for (;;)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("top:").append(str1).append("bottom:").append(str2).append("\n");
        ((StringBuilder)localObject1).append("snsid:").append(r.Jc(paramSnsInfo.field_snsId)).append("\n");
        ((StringBuilder)localObject1).append("indexInGroup:").append(i);
        paramBaseViewHolder.EXN.setText(((StringBuilder)localObject1).toString());
        paramBaseViewHolder.EXN.setVisibility(0);
        return;
        label500:
        i += 1;
        break;
        label507:
        i = 0;
      }
      label512:
      localObject1 = null;
      break;
      label518:
      localObject1 = null;
    }
  }
  
  private au.b br(String paramString, long paramLong)
  {
    if (this.EWs.size() <= 0) {
      return null;
    }
    Iterator localIterator = this.EWs.iterator();
    while (localIterator.hasNext())
    {
      au.b localb = (au.b)localIterator.next();
      if ((localb.id != null) && (localb.id.equals(au.kj(paramString, String.valueOf(paramLong))))) {
        return localb;
      }
    }
    return null;
  }
  
  public static ViewStub i(BaseViewHolder paramBaseViewHolder)
  {
    return paramBaseViewHolder.EWD;
  }
  
  public static void j(BaseViewHolder paramBaseViewHolder)
  {
    if ((paramBaseViewHolder != null) && (paramBaseViewHolder.EWB != null))
    {
      paramBaseViewHolder.EWB.ZW(1);
      paramBaseViewHolder.EWB.setVisibility(0);
    }
  }
  
  public static void k(BaseViewHolder paramBaseViewHolder)
  {
    if ((paramBaseViewHolder != null) && (paramBaseViewHolder.EWB != null)) {
      paramBaseViewHolder.EWB.setVisibility(8);
    }
  }
  
  public final View a(Activity paramActivity, BaseViewHolder paramBaseViewHolder, int paramInt, bk parambk, SnsInfo paramSnsInfo)
  {
    this.mActivity = paramActivity;
    this.qcr = paramInt;
    this.DQX = parambk;
    paramBaseViewHolder.dRS = paramSnsInfo.getSnsId();
    Object localObject;
    View localView;
    switch (paramInt)
    {
    case 17: 
    case 18: 
    case 20: 
    case 21: 
    case 22: 
    default: 
      localObject = "R.layout.sns_media_sub_item2";
      com.tencent.mm.kiss.a.b.aBh();
      localView = com.tencent.mm.kiss.a.b.c(this.mActivity, 2131496511);
      paramBaseViewHolder.EXE = localView;
      paramBaseViewHolder.EXD = ((String)localObject);
      localObject = localView.findViewById(2131302605);
      if (!(localObject instanceof ViewStub)) {
        break;
      }
    }
    for (paramBaseViewHolder.EWD = ((ViewStub)localObject);; paramBaseViewHolder.EWD = null)
    {
      Log.i("MicroMsg.BaseTimeLineItem", "create new item  " + paramInt + "  " + localView.hashCode());
      paramBaseViewHolder.EXw = localView.findViewById(2131308241);
      paramBaseViewHolder.qcr = paramInt;
      paramBaseViewHolder.EWw = ((SnsAvatarImageView)localView.findViewById(2131296609));
      paramBaseViewHolder.EWw.setWeakContext(paramActivity);
      paramBaseViewHolder.EWw.setOnClickListener(parambk.DQs.Fas);
      paramBaseViewHolder.EWw.setOnLongClickListener(parambk.DQs.Fat);
      paramBaseViewHolder.EWw.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(100046);
          if (paramAnonymousMotionEvent.getAction() == 0) {
            paramAnonymousView.setTag(2131309367, new int[] { (int)paramAnonymousMotionEvent.getRawX(), (int)paramAnonymousMotionEvent.getRawY() });
          }
          AppMethodBeat.o(100046);
          return false;
        }
      });
      paramBaseViewHolder.EWx = ((AsyncTextView)localView.findViewById(2131305440));
      paramBaseViewHolder.EWy = ((ImageView)localView.findViewById(2131309561));
      paramBaseViewHolder.EWx.setOnTouchListener(new af());
      paramBaseViewHolder.EWz = ((ViewGroup)localView.findViewById(2131305435));
      paramBaseViewHolder.EWA = ((AsyncNormalTextView)localView.findViewById(2131299502));
      paramBaseViewHolder.EWA.setOpClickListener(parambk.EKD);
      paramBaseViewHolder.EWA.setShrinkOrSpreadListener(parambk.EKE);
      paramBaseViewHolder.EWC = ((LinearLayout)localView.findViewById(2131302606));
      paramBaseViewHolder.EWC.setTag(paramBaseViewHolder);
      paramBaseViewHolder.EWC.setOnClickListener(parambk.DQs.Fbd);
      localObject = localView.findViewById(2131299510);
      parambk.fiV().c((View)localObject, parambk.DQs.Fau, parambk.DQs.Far);
      localObject = (TextView)localView.findViewById(2131299511);
      parambk.fiV().c((View)localObject, parambk.DQs.Fau, parambk.DQs.Far);
      paramBaseViewHolder.EWB = ((SnsTranslateResultView)localView.findViewById(2131308248));
      paramBaseViewHolder.EWB.setVisibility(8);
      paramBaseViewHolder.EWB.getSplitlineView().setPadding(0, 0, 0, 0);
      paramBaseViewHolder.EWB.getResultTextView().setBackgroundResource(2131234959);
      parambk.fiV().c(paramBaseViewHolder.EWB.getResultTextView(), parambk.DQs.Fau, parambk.DQs.Far);
      paramBaseViewHolder.EWW = ((LinearLayout)localView.findViewById(2131298954));
      paramBaseViewHolder.EWK = ((TextView)localView.findViewById(2131310522));
      paramBaseViewHolder.timeTv = ((TextView)localView.findViewById(2131296675));
      paramBaseViewHolder.EWM = ((AsyncTextView)localView.findViewById(2131296604));
      paramBaseViewHolder.EWN = ((AsyncTextView)localView.findViewById(2131296603));
      paramBaseViewHolder.EIm = ((TextView)localView.findViewById(2131296607));
      paramBaseViewHolder.DDr = new bq(localView);
      paramBaseViewHolder.DDr.b(parambk.DQs.FaC, parambk.DQs.FaS);
      paramBaseViewHolder.EWJ = ((RelativeLayout)localView.findViewById(2131305636));
      paramBaseViewHolder.EWJ.setOnClickListener(parambk.DQs.FaV);
      paramBaseViewHolder.EqV = ((TextView)localView.findViewById(2131296643));
      paramBaseViewHolder.EqV.setText(paramActivity.getString(2131755778));
      paramBaseViewHolder.EqV.setContentDescription(paramActivity.getString(2131755778));
      paramBaseViewHolder.EqV.setOnClickListener(parambk.DQs.Faw);
      paramBaseViewHolder.EWM.setOnClickListener(parambk.DQs.FaT);
      paramBaseViewHolder.EWN.setOnClickListener(parambk.DQs.FaU);
      paramBaseViewHolder.EIm.setOnClickListener(parambk.DQs.FaP);
      paramBaseViewHolder.EWO = localView.findViewById(2131296647);
      paramBaseViewHolder.EWO.setOnClickListener(parambk.DQs.FaB);
      paramBaseViewHolder.EWL = ((WeImageView)localView.findViewById(2131296704));
      paramBaseViewHolder.jBQ = ((TextView)localView.findViewById(2131296646));
      paramBaseViewHolder.EWP = ((ImageView)localView.findViewById(2131296676));
      paramBaseViewHolder.EWZ = ((ViewStub)localView.findViewById(2131296638));
      paramBaseViewHolder.EnO = ((LinearLayout)localView.findViewById(2131296667));
      paramBaseViewHolder.EXy = ((ViewStub)localView.findViewById(2131296649));
      paramBaseViewHolder.EXG = ((ViewStub)localView.findViewById(2131308251));
      paramBaseViewHolder.EXK = ((ViewStub)localView.findViewById(2131308203));
      paramBaseViewHolder.jLy = ((ViewGroup)localView.findViewById(2131308138));
      paramBaseViewHolder.EXb = ((ViewStub)localView.findViewById(2131308192));
      paramBaseViewHolder.EWF = ((TextView)localView.findViewById(2131302040));
      paramBaseViewHolder.EWF.setOnClickListener(parambk.DQs.Fax);
      BaseViewHolder.a(paramBaseViewHolder, (TextView)localView.findViewById(2131302256));
      paramBaseViewHolder.EXN = ((TextView)localView.findViewById(2131308266));
      paramBaseViewHolder.convertView = localView;
      paramBaseViewHolder.EXO = localView.findViewById(2131308242);
      if (this.EAv)
      {
        com.tencent.mm.plugin.sns.abtest.c.b(localView, paramBaseViewHolder);
        com.tencent.mm.plugin.sns.abtest.a.a(localView, paramBaseViewHolder);
        aj.faF();
        com.tencent.mm.plugin.sns.h.c.c(localView, paramBaseViewHolder);
      }
      d(paramBaseViewHolder);
      localView.setTag(paramBaseViewHolder);
      a(paramBaseViewHolder, paramSnsInfo);
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
      localObject = "R.layout.sns_ad_finder_topic_item_content";
      break;
    }
  }
  
  public final void a(BaseViewHolder paramBaseViewHolder, int paramInt, SnsInfo paramSnsInfo, bl parambl)
  {
    paramSnsInfo = paramSnsInfo.getTimeLine();
    a(paramBaseViewHolder, paramInt, parambl, paramSnsInfo, paramBaseViewHolder.qcr, this.DQX);
    a(parambl, paramSnsInfo);
  }
  
  public final void a(final BaseViewHolder paramBaseViewHolder, int paramInt1, SnsInfo paramSnsInfo, TimeLineObject paramTimeLineObject, int paramInt2, final bk parambk, bl parambl)
  {
    a(paramBaseViewHolder, paramSnsInfo);
    this.qcr = paramInt2;
    this.DQX = parambk;
    if (this.EAv) {
      com.tencent.mm.plugin.sns.ui.a.c.Z(paramSnsInfo);
    }
    com.tencent.mm.plugin.sns.ui.a.c.g(paramTimeLineObject);
    com.tencent.mm.plugin.sns.ui.a.c.f(paramTimeLineObject);
    if (paramSnsInfo.isAd()) {
      Log.i("MicroMsg.BaseTimeLineItem", "the ad sns id is " + r.Jc(paramSnsInfo.field_snsId) + " for susan");
    }
    paramBaseViewHolder.EWu = parambl.ENp;
    paramBaseViewHolder.xEm = false;
    paramBaseViewHolder.position = paramInt1;
    paramBaseViewHolder.dRS = parambl.Dsr;
    paramBaseViewHolder.dHp = parambl.Eql;
    paramBaseViewHolder.EWv = parambl.ENt;
    paramBaseViewHolder.EWP.setOnClickListener(parambk.EKC);
    paramBaseViewHolder.timeLineObject = paramTimeLineObject;
    Object localObject2 = parambl.DqN;
    paramBaseViewHolder.snsobj = ((SnsObject)localObject2);
    Object localObject1 = parambk.EKl.EoF.DMa;
    Object localObject3;
    if (paramSnsInfo != null)
    {
      localObject3 = paramSnsInfo.getLocalid();
      ((com.tencent.mm.plugin.sns.k.b)localObject1).DUo.add(localObject3);
      if (paramSnsInfo.isAd()) {
        ((com.tencent.mm.plugin.sns.k.b)localObject1).DUt.add(localObject3);
      }
      ((com.tencent.mm.plugin.sns.k.b)localObject1).DUu.add(paramSnsInfo.field_userName);
    }
    int i;
    label614:
    Object localObject4;
    switch (paramSnsInfo.field_type)
    {
    default: 
      ((com.tencent.mm.plugin.sns.k.b)localObject1).DUz.add(localObject3);
      if (paramInt1 < ((com.tencent.mm.plugin.sns.k.b)localObject1).DUm)
      {
        ((com.tencent.mm.plugin.sns.k.b)localObject1).DUm = paramInt1;
        ((com.tencent.mm.plugin.sns.k.b)localObject1).DSR = r.v(paramSnsInfo);
      }
      if (paramInt1 > ((com.tencent.mm.plugin.sns.k.b)localObject1).DUn)
      {
        ((com.tencent.mm.plugin.sns.k.b)localObject1).DUn = paramInt1;
        ((com.tencent.mm.plugin.sns.k.b)localObject1).DSS = r.v(paramSnsInfo);
      }
      ((com.tencent.mm.plugin.sns.k.b)localObject1).DSX = ((com.tencent.mm.plugin.sns.k.b)localObject1).DUp.size();
      ((com.tencent.mm.plugin.sns.k.b)localObject1).DSY = ((com.tencent.mm.plugin.sns.k.b)localObject1).DUq.size();
      ((com.tencent.mm.plugin.sns.k.b)localObject1).DSZ = ((com.tencent.mm.plugin.sns.k.b)localObject1).DUr.size();
      ((com.tencent.mm.plugin.sns.k.b)localObject1).DTb = ((com.tencent.mm.plugin.sns.k.b)localObject1).DUs.size();
      ((com.tencent.mm.plugin.sns.k.b)localObject1).DTa = ((com.tencent.mm.plugin.sns.k.b)localObject1).DUt.size();
      ((com.tencent.mm.plugin.sns.k.b)localObject1).DTc = ((com.tencent.mm.plugin.sns.k.b)localObject1).DUx.size();
      ((com.tencent.mm.plugin.sns.k.b)localObject1).DTk = ((com.tencent.mm.plugin.sns.k.b)localObject1).DUy.size();
      ((com.tencent.mm.plugin.sns.k.b)localObject1).ppa = ((com.tencent.mm.plugin.sns.k.b)localObject1).DUu.size();
      ((com.tencent.mm.plugin.sns.k.b)localObject1).DSV = ((com.tencent.mm.plugin.sns.k.b)localObject1).DUv.size();
      ((com.tencent.mm.plugin.sns.k.b)localObject1).DSW = ((com.tencent.mm.plugin.sns.k.b)localObject1).DUw.size();
      ((com.tencent.mm.plugin.sns.k.b)localObject1).DTj = ((com.tencent.mm.plugin.sns.k.b)localObject1).DUz.size();
      ((com.tencent.mm.plugin.sns.k.b)localObject1).DSF = ((com.tencent.mm.plugin.sns.k.b)localObject1).DUo.size();
      localObject3 = parambl.DuG;
      localObject1 = parambl.mRa;
      if (com.tencent.mm.plugin.sns.ad.timeline.b.b.V(parambl.Eoq, paramInt2)) {
        paramBaseViewHolder.EWA.setAdTagClickCallback(this.mAdTagClickCallback, paramInt1);
      }
      if (!Util.isNullOrNil((String)localObject1))
      {
        paramBaseViewHolder.Eou = parambl.ENo;
        paramBaseViewHolder.EWw.setTag(localObject1);
        if (paramBaseViewHolder.Eou != null) {
          if ((as.bjp((String)localObject1)) && ("3552365301".equals(paramBaseViewHolder.Eou.field_openImAppid)))
          {
            i = 1;
            if ((localObject3 == null) || (!((ADXml)localObject3).usePreferedInfo)) {
              break label3373;
            }
            paramBaseViewHolder.EWw.setImageResource(2131231957);
            paramBaseViewHolder.EWw.fL((String)localObject1, 4);
            paramBaseViewHolder.EWw.setShowStoryHint(false);
            if (!Util.isNullOrNil(((ADXml)localObject3).preferAvatar))
            {
              localObject4 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.kz("adId", ((ADXml)localObject3).preferAvatar);
              paramBaseViewHolder.EWw.setTag(2131308195, ((ADXml)localObject3).preferAvatar);
              if (!s.YS((String)localObject4)) {
                break label3352;
              }
              localObject3 = com.tencent.mm.plugin.sns.ad.g.n.Dwr.getBitmap((String)localObject4);
              if (localObject3 != null) {
                paramBaseViewHolder.EWw.setImageBitmap((Bitmap)localObject3);
              }
            }
            label726:
            paramBaseViewHolder.EWx.setContactInfo(paramBaseViewHolder.Eou);
            paramBaseViewHolder.EWx.a((String)localObject1, parambl.ENE, new q.a()
            {
              public final void b(View paramAnonymousView, Object paramAnonymousObject)
              {
                AppMethodBeat.i(100049);
                if (parambk.EBk != null)
                {
                  parambk.EBk.source = 0;
                  parambk.EBk.b(paramAnonymousView, paramAnonymousObject);
                  ((com.tencent.mm.plugin.textstatus.a.c)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.textstatus.a.c.class)).report22210(this.gtu, 6L);
                }
                AppMethodBeat.o(100049);
              }
            }, parambl.Eoq, parambl.Eql, paramInt2, parambl.Eoq);
            paramBaseViewHolder.EWw.ico = parambl.Eql;
          }
        }
      }
      break;
    }
    label1423:
    label1554:
    label2209:
    label2852:
    label4645:
    for (;;)
    {
      paramBaseViewHolder.EWy.setVisibility(8);
      label823:
      int j;
      if (parambl.Eoq)
      {
        paramBaseViewHolder.isAd = true;
        paramBaseViewHolder.xEm = parambl.ENu;
        paramBaseViewHolder.EWA.a(parambl.ENq, parambk, parambl.ENr, parambl);
        paramBaseViewHolder.EWA.setShow(paramBaseViewHolder);
        localObject1 = com.tencent.mm.plugin.sns.i.a.DRI;
        localObject3 = paramBaseViewHolder.EWA;
        p.h(localObject3, "view");
        p.h(parambl, "struct");
        localObject1 = ((View)localObject3).findViewById(2131299510);
        localObject4 = SecDataUIC.CWq;
        localObject3 = ((View)localObject3).getContext();
        p.g(localObject3, "view.context");
        localObject3 = SecDataUIC.a.gU((Context)localObject3);
        if (localObject3 != null)
        {
          localObject3 = ((SecDataUIC)localObject3).eSr();
          if (localObject3 != null) {
            ((f)localObject3).jS("Item_" + parambl.DqO.localid, String.valueOf(((View)localObject1).hashCode()));
          }
        }
        paramBaseViewHolder.jBQ.setOnTouchListener(new af());
        a(paramBaseViewHolder, paramInt1, parambl, paramTimeLineObject, paramInt2, parambk);
        a(parambl, paramTimeLineObject);
        parambk.EKn.put(Integer.valueOf(paramInt1), new WeakReference(paramBaseViewHolder.convertView));
        if (paramBaseViewHolder.convertView.getBackground() == null)
        {
          paramBaseViewHolder.convertView.setBackgroundResource(2131231898);
          j = com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 12);
          int k = com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 8);
          paramBaseViewHolder.convertView.setPadding(j, j, j, k);
        }
        paramBaseViewHolder.timeTv.setText(parambl.ENw);
        paramBaseViewHolder.EWM.setVisibility(8);
        paramBaseViewHolder.EWN.setVisibility(8);
        if (parambl.Eoq)
        {
          localObject3 = parambl.ENx;
          paramBaseViewHolder.EWM.setTag(parambl.Eql);
          if (parambl.ENx.adActionExtTailType != ADInfo.ADChainStrengthenDefaultWording) {
            break label3678;
          }
          if (Util.isNullOrNil(parambl.ENA)) {
            break label3666;
          }
          paramBaseViewHolder.EWM.setText(parambl.ENA);
          paramBaseViewHolder.EWM.setVisibility(0);
          label1191:
          if ((((ADInfo)localObject3).adChainType == 1) && (!Util.isNullOrNil(((ADInfo)localObject3).adActionExtTailWording)))
          {
            paramBaseViewHolder.EWM.setText(((ADInfo)localObject3).adActionExtTailWording);
            paramBaseViewHolder.EWM.setVisibility(0);
          }
          label1231:
          if ((paramBaseViewHolder.EWM.getVisibility() != 8) && (Util.isNullOrNil(((ADInfo)localObject3).adActionExtTailLink)))
          {
            paramBaseViewHolder.EWM.setTextColor(this.mActivity.getResources().getColor(2131101161));
            paramBaseViewHolder.EWM.setOnClickListener(null);
          }
          if ((paramSnsInfo.getTimeLine().ContentObj.LoW & 0x4) == 0) {
            break label3997;
          }
          paramBaseViewHolder.EWN.setTag(paramBaseViewHolder);
          paramBaseViewHolder.EWN.setVisibility(0);
          paramBaseViewHolder.EWN.setText(String.format("%s%s%s", new Object[] { this.mActivity.getResources().getString(2131765936), parambl.ENE, this.mActivity.getResources().getString(2131765937) }));
        }
        label1370:
        if (!parambl.ENH) {
          break label4009;
        }
        localObject1 = parambk.gte.getString(2131762762, new Object[] { Integer.valueOf(parambl.ENI) });
        BaseViewHolder.l(paramBaseViewHolder).setText((CharSequence)localObject1);
        BaseViewHolder.l(paramBaseViewHolder).setVisibility(0);
        paramBaseViewHolder.EIm.setTag(parambl.Eql);
        if (Util.isNullOrNil(parambl.ENK)) {
          break label4062;
        }
        paramBaseViewHolder.EIm.setVisibility(0);
        paramBaseViewHolder.EIm.setText(parambl.ENK);
        paramBaseViewHolder.EIm.setContentDescription(parambl.ENK);
        paramBaseViewHolder.EIm.setClickable(parambl.ENL);
        localObject1 = paramBaseViewHolder.EIm;
        if (!parambl.ENL) {
          break label4021;
        }
        j = this.mActivity.getResources().getColor(2131101131);
        label1519:
        ((TextView)localObject1).setTextColor(j);
        if (!parambl.ENL) {
          break label4039;
        }
        paramBaseViewHolder.EIm.setBackground(this.mActivity.getResources().getDrawable(2131234959));
        if (!parambl.ENS) {
          break label4074;
        }
        paramBaseViewHolder.EWL.setVisibility(0);
        paramBaseViewHolder.EWL.setImageResource(2131690836);
        paramBaseViewHolder.EWL.setIconColor(this.mActivity.getResources().getColor(2131099662));
        label1600:
        paramBaseViewHolder.jBQ.setTextColor(this.mActivity.getResources().getColor(2131101131));
        if (!parambl.ENM) {
          break label4092;
        }
        paramBaseViewHolder.jBQ.setVisibility(0);
        localObject1 = this.mActivity.getString(2131766013) + parambl.mAppName;
        if ((paramTimeLineObject == null) || (paramTimeLineObject.ContentObj == null) || ((paramTimeLineObject.ContentObj.LoU != 28) && (paramTimeLineObject.ContentObj.LoU != 34) && (paramTimeLineObject.ContentObj.LoU != 36))) {
          break label4086;
        }
        j = 1;
        label1724:
        if ((((String)localObject1).length() <= 10) || (j != 0)) {
          break label5826;
        }
        localObject1 = ((String)localObject1).substring(0, 10) + "...";
      }
      label2086:
      label2236:
      label5183:
      label5826:
      for (;;)
      {
        localObject1 = new SpannableString((CharSequence)localObject1);
        ((SpannableString)localObject1).setSpan(new b(), 0, ((SpannableString)localObject1).length(), 33);
        paramBaseViewHolder.jBQ.setText((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
        if ((!parambl.ENO) && (!"wx7fa037cc7dfabad5".equals(paramTimeLineObject.AppInfo.Id)))
        {
          paramBaseViewHolder.jBQ.setTextColor(this.mActivity.getResources().getColor(2131101161));
          paramBaseViewHolder.jBQ.setOnTouchListener(null);
        }
        paramBaseViewHolder.jBQ.setTag(paramTimeLineObject);
        label1873:
        if (parambl.ENG)
        {
          paramBaseViewHolder.EqV.setVisibility(0);
          paramBaseViewHolder.EqV.setTag(parambl.Eql);
          label1901:
          paramBaseViewHolder.EWP.setTag(paramBaseViewHolder);
          if ((!parambl.ENT) || (paramTimeLineObject.ContentObj.LoU == 28)) {
            break label4492;
          }
          if (!paramBaseViewHolder.EXf)
          {
            paramBaseViewHolder.EWU = ((LinearLayout)paramBaseViewHolder.EXb.inflate());
            paramBaseViewHolder.EWV = paramBaseViewHolder.convertView.findViewById(2131306054);
            paramBaseViewHolder.EXf = true;
            paramBaseViewHolder.EWV.setTag(parambl.Eql);
            paramBaseViewHolder.EeT = ((TextView)paramBaseViewHolder.EWU.findViewById(2131306054));
          }
          paramBaseViewHolder.EXb.setVisibility(0);
          paramBaseViewHolder.EWV.setOnClickListener(parambk.DQs.FaA);
          switch (parambl.ENU)
          {
          default: 
            paramBaseViewHolder.EeT.setText(2131766173);
            paramBaseViewHolder.EWV.setClickable(true);
            paramBaseViewHolder.EWV.setEnabled(true);
            paramTimeLineObject = paramSnsInfo.getPostInfo();
            if ((paramTimeLineObject != null) && (!Util.isNullOrNil(paramTimeLineObject.Mtk))) {
              paramBaseViewHolder.EeT.setText(paramTimeLineObject.Mtk);
            }
            if (parambl.ENV)
            {
              paramBaseViewHolder.EWO.setVisibility(0);
              paramBaseViewHolder.EWO.setTag(parambl.Eql);
              label2148:
              if (!parambl.ENW) {
                break label4614;
              }
              if (Util.isNullOrNil(parambl.ENX)) {
                break label4553;
              }
              paramBaseViewHolder.EWK.setVisibility(0);
              if (paramInt2 != 7) {
                break label4523;
              }
              paramTimeLineObject = String.format(this.mActivity.getString(2131766276), new Object[] { parambl.ENX });
              paramTimeLineObject = com.tencent.mm.pluginsdk.ui.span.l.b(this.mActivity, paramTimeLineObject, paramBaseViewHolder.EWK.getTextSize());
              paramBaseViewHolder.EWK.setText(paramTimeLineObject);
              if (!parambl.ENZ) {
                break label4626;
              }
              if (paramBaseViewHolder.EXz == null)
              {
                paramBaseViewHolder.EXz = paramBaseViewHolder.EXy.inflate();
                paramBaseViewHolder.DGi = ((TextView)paramBaseViewHolder.EXz.findViewById(2131296650));
                paramBaseViewHolder.EXA = ((MaskTextView)paramBaseViewHolder.EXz.findViewById(2131296651));
                paramBaseViewHolder.EXA.setOnTouchListener(new af());
              }
              paramBaseViewHolder.EXz.setVisibility(0);
              a(paramBaseViewHolder.EXA, parambl.EOc, paramInt2);
              paramTimeLineObject = this.mActivity.getString(2131766130, new Object[] { Integer.valueOf(parambl.EOa), Util.formatMoney2f(parambl.EOb / 100.0D) });
              paramBaseViewHolder.DGi.setText(paramTimeLineObject);
              paramBaseViewHolder.EXz.setTag(paramSnsInfo);
              paramBaseViewHolder.EXz.setOnClickListener(parambk.DQs.FaD);
              label2407:
              if (((parambl.EOd != null) && (parambl.EOd.size() != 0)) || ((parambl.EOe != null) && (parambl.EOe.size() != 0))) {
                break label4664;
              }
              if (paramBaseViewHolder.EnO == null) {
                break label4645;
              }
              paramBaseViewHolder.EnO.setVisibility(8);
              if (!parambl.EOf) {
                break label5092;
              }
              paramBaseViewHolder.EWF.setTag(parambl.Eql);
              paramBaseViewHolder.EWF.setText(parambl.EOg);
              paramBaseViewHolder.EWF.setVisibility(0);
              if (!parambl.Eoq) {
                break label5110;
              }
              Log.i("MicroMsg.BaseTimeLineItem", "adatag " + parambl.ENz);
              paramBaseViewHolder.DDr.N(Long.valueOf(parambl.ENp), new com.tencent.mm.plugin.sns.data.c(paramBaseViewHolder.DDr, paramBaseViewHolder.position, parambl.Eql, parambl.ENp, parambl.ENv));
              paramBaseViewHolder.DDr.b(parambl.ENy, parambl.ENx);
              paramBaseViewHolder.DDr.setVisibility(0);
              if ((paramBaseViewHolder.EIm != null) && (paramBaseViewHolder.EIm.getVisibility() == 0))
              {
                if (paramBaseViewHolder.DDr.EQS.getVisibility() != 0) {
                  break label5104;
                }
                i = 1;
                if (i != 0)
                {
                  paramTimeLineObject = (LinearLayout.LayoutParams)paramBaseViewHolder.EIm.getLayoutParams();
                  paramTimeLineObject.setMargins(paramTimeLineObject.leftMargin, BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mActivity, 0.0F), paramTimeLineObject.rightMargin, paramTimeLineObject.bottomMargin);
                  paramBaseViewHolder.EIm.setLayoutParams(paramTimeLineObject);
                }
              }
              paramBaseViewHolder.EWJ.setVisibility(8);
              if (!this.EAv) {
                break label5260;
              }
              aj.faF().a(this.mActivity, (SnsObject)localObject2, paramBaseViewHolder);
              b(paramBaseViewHolder, paramSnsInfo);
              paramTimeLineObject = aj.faZ();
              long l = paramSnsInfo.field_snsId;
              if ((!paramTimeLineObject.DNn) || (l == 0L) || (paramTimeLineObject.DNG) || (paramTimeLineObject.DNx <= paramTimeLineObject.DNr) || (paramTimeLineObject.DNK == null) || (paramTimeLineObject.DNK.state != 1) || (paramTimeLineObject.DNK.DSb < paramTimeLineObject.DNs) || (!paramTimeLineObject.DNC)) {
                break label5183;
              }
              if ((paramTimeLineObject.DNv != 0L) && (cl.aWB() - paramTimeLineObject.DNJ.DNN <= paramTimeLineObject.DNv)) {
                break label5178;
              }
              paramInt1 = 1;
              if ((paramInt1 == 0) || (l != paramTimeLineObject.DNL)) {
                break label5183;
              }
              paramInt1 = 1;
              if (paramInt1 == 0) {
                break label5188;
              }
              if (!paramBaseViewHolder.EXF)
              {
                paramBaseViewHolder.EXH = ((LinearLayout)paramBaseViewHolder.EXG.inflate());
                paramBaseViewHolder.EXF = true;
                paramBaseViewHolder.EXI = ((ViewGroup)paramBaseViewHolder.EXH.findViewById(2131308250));
              }
              paramBaseViewHolder.EXG.setVisibility(0);
              paramBaseViewHolder.jLy.setBackgroundColor(0);
              paramBaseViewHolder.EXI.setTag(Long.valueOf(paramSnsInfo.field_snsId));
              aj.faZ().fj(paramBaseViewHolder.EXI);
              paramBaseViewHolder.EXI.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(203911);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bm(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/item/BaseTimeLineItem$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
                  BaseTimeLineItem.this.DQX.EKl.ffv();
                  com.tencent.mm.plugin.sns.k.e.DUQ.DVy.eTU = 1L;
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/item/BaseTimeLineItem$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(203911);
                }
              });
              com.tencent.mm.plugin.report.service.h.CyF.dN(1295, 1);
              aj.fba();
              if (!com.tencent.mm.plugin.sns.model.at.o(paramSnsInfo.field_snsId, paramSnsInfo.getCreateTime(), paramSnsInfo.localid)) {
                break label5231;
              }
              if (!paramBaseViewHolder.EXJ)
              {
                paramBaseViewHolder.EXL = ((LinearLayout)paramBaseViewHolder.EXK.inflate());
                paramBaseViewHolder.EXJ = true;
                paramBaseViewHolder.EXM = ((TextView)paramBaseViewHolder.EXL.findViewById(2131308200));
              }
              paramBaseViewHolder.EXK.setVisibility(0);
              paramBaseViewHolder.jLy.setBackgroundColor(0);
              paramBaseViewHolder.EXM.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(203912);
                  Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
                  ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/item/BaseTimeLineItem$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
                  paramAnonymousView = aj.fba();
                  localObject1 = paramBaseViewHolder.EXM.getContext();
                  Object localObject2;
                  Parcel localParcel;
                  if (com.tencent.mm.plugin.sns.model.at.DMT)
                  {
                    paramAnonymousView.DMX = null;
                    paramAnonymousView.DMY = "";
                    Log.i(com.tencent.mm.plugin.sns.model.at.TAG, "goRetryEdit draftKey:%s", new Object[] { paramAnonymousView.DMW });
                    localObject2 = aj.faV().aQn(paramAnonymousView.DMW);
                    if (localObject2 != null)
                    {
                      localObject2 = ((com.tencent.mm.plugin.sns.storage.j)localObject2).field_draft;
                      if (!Util.isNullOrNil((byte[])localObject2))
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
                    localObject2 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject2);
                    com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/plugin/sns/model/SnsRetryEditTipManager", "goRetryEdit", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/sns/model/SnsRetryEditTipManager", "goRetryEdit", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    paramAnonymousView.reset();
                    MMHandlerThread.removeRunnable(paramAnonymousView.DMZ);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/item/BaseTimeLineItem$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(203912);
                    return;
                  }
                  catch (Exception localException)
                  {
                    for (;;)
                    {
                      aj.faV().b(paramAnonymousView.DMW, null, 0);
                    }
                  }
                }
              });
            }
            break;
          }
        }
        label2120:
        label2638:
        label3666:
        label3678:
        Object localObject5;
        label2501:
        label4039:
        label4062:
        label4074:
        label4086:
        label4092:
        boolean bool;
        for (;;)
        {
          paramSnsInfo = new bg(parambl.Dsr, parambl.Eql, false, true, 1);
          paramBaseViewHolder.EWB.getResultTextView().setTag(paramSnsInfo);
          paramSnsInfo = new StringBuilder("");
          if ((parambl.EOd == null) || (parambl.EOd.size() <= 0)) {
            break label5321;
          }
          paramSnsInfo.append(MMApplicationContext.getContext().getResources().getString(2131765922)).append(":");
          paramInt1 = 0;
          while (paramInt1 < parambl.EOd.size())
          {
            paramTimeLineObject = (com.tencent.mm.vending.j.a)parambl.EOd.get(paramInt1);
            if (paramTimeLineObject != null) {
              paramSnsInfo.append((String)paramTimeLineObject.get(1)).append(",");
            }
            paramInt1 += 1;
          }
          ((com.tencent.mm.plugin.sns.k.b)localObject1).DUq.add(localObject3);
          break;
          ((com.tencent.mm.plugin.sns.k.b)localObject1).DUp.add(localObject3);
          break;
          ((com.tencent.mm.plugin.sns.k.b)localObject1).DUs.add(localObject3);
          break;
          ((com.tencent.mm.plugin.sns.k.b)localObject1).DUr.add(localObject3);
          break;
          ((com.tencent.mm.plugin.sns.k.b)localObject1).DUx.add(localObject3);
          break;
          ((com.tencent.mm.plugin.sns.k.b)localObject1).DUy.add(localObject3);
          break;
          if (!Util.isNullOrNil(paramTimeLineObject.publicUserName))
          {
            ((com.tencent.mm.plugin.sns.k.b)localObject1).DUv.add(localObject3);
            break;
          }
          ((com.tencent.mm.plugin.sns.k.b)localObject1).DUw.add(localObject3);
          break;
          i = 0;
          break label614;
          com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(((ADXml)localObject3).preferAvatar, false, new f.a()
          {
            public final void aNH(String paramAnonymousString)
            {
              AppMethodBeat.i(203909);
              Log.i("MicroMsg.BaseTimeLineItem", "download img %s", new Object[] { paramAnonymousString });
              String str = (String)paramBaseViewHolder.EWw.getTag(2131308195);
              if ((!Util.isNullOrNil(new String[] { str, paramAnonymousString })) && (paramAnonymousString.equals(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.kz("adId", str))))
              {
                paramAnonymousString = com.tencent.mm.plugin.sns.ad.g.n.Dwr.getBitmap(paramAnonymousString);
                if (paramAnonymousString != null) {
                  paramBaseViewHolder.EWw.setImageBitmap(paramAnonymousString);
                }
              }
              AppMethodBeat.o(203909);
            }
            
            public final void eWN() {}
            
            public final void eWO() {}
          });
          break label726;
          if (!((String)localObject1).endsWith("@ad")) {
            if (parambl.ENF)
            {
              Log.i("MicroMsg.BaseTimeLineItem", "getContact %s", new Object[] { localObject1 });
              if (a.b.gov().Wg() != null) {
                paramBaseViewHolder.EWw.setImageBitmap(a.b.gov().Wg());
              }
              ay.a.iDq.a((String)localObject1, "", new bk.c(parambk.fiT(), paramInt1));
              if (parambl.ENG) {
                break label3606;
              }
              com.tencent.mm.plugin.sns.ui.e.a.b(4, (String)paramBaseViewHolder.EWw.getTag(), paramBaseViewHolder.EWw);
              paramBaseViewHolder.EWw.fL((String)localObject1, 4);
              paramBaseViewHolder.EWw.setTag(localObject1);
              com.tencent.mm.plugin.sns.ui.e.a.a(4, (String)localObject1, paramBaseViewHolder.EWw);
              paramBaseViewHolder.EWw.setShowStoryHint(((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.story.api.e.class)).hasNewStory((String)localObject1));
            }
          }
          for (;;)
          {
            paramBaseViewHolder.EWx.setContactInfo(paramBaseViewHolder.Eou);
            paramBaseViewHolder.EWx.a((String)localObject1, parambl.ENE, new q.a()
            {
              public final void b(View paramAnonymousView, Object paramAnonymousObject)
              {
                AppMethodBeat.i(203910);
                if (parambk.EBk != null) {
                  if (!(paramAnonymousObject instanceof com.tencent.mm.plugin.sns.data.b)) {
                    break label78;
                  }
                }
                label78:
                for (boolean bool = ((com.tencent.mm.plugin.sns.data.b)paramAnonymousObject).isAd;; bool = false)
                {
                  if (bool) {}
                  for (parambk.EBk.source = 0;; parambk.EBk.source = 6)
                  {
                    parambk.EBk.b(paramAnonymousView, paramAnonymousObject);
                    AppMethodBeat.o(203910);
                    return;
                  }
                }
              }
            }, parambl.Eoq, parambl.Eql, paramInt2, parambl.Eoq);
            break;
            a.b.c(paramBaseViewHolder.EWw, (String)localObject1);
            break label3461;
            paramBaseViewHolder.EWw.fL((String)localObject1, 4);
            paramBaseViewHolder.EWw.setShowStoryHint(false);
            continue;
            paramBaseViewHolder.EWw.setImageResource(2131231957);
            paramBaseViewHolder.EWw.fL((String)localObject1, 4);
            paramBaseViewHolder.EWw.setShowStoryHint(false);
          }
          paramBaseViewHolder.isAd = false;
          break label823;
          paramBaseViewHolder.EWM.setVisibility(8);
          break label1191;
          if (((ADInfo)localObject3).adActionExtTailType != ADInfo.ADChainStrengthenUserInfoFormatWording) {
            break label1231;
          }
          if (!Util.isNullOrNil(parambl.ENB))
          {
            localObject1 = parambl.ENC;
            localObject4 = parambl.ENB;
            localObject5 = this.mActivity;
            paramBaseViewHolder.EWM.getTextSize();
            localObject5 = new com.tencent.mm.pluginsdk.ui.span.m(com.tencent.mm.pluginsdk.ui.span.l.f((Context)localObject5, (CharSequence)localObject4, 1));
            ((com.tencent.mm.pluginsdk.ui.span.m)localObject5).a(null, (CharSequence)localObject4, 0);
            localObject4 = paramBaseViewHolder.EWM.getPaint();
            float f = Layout.getDesiredWidth((CharSequence)localObject5, 0, ((com.tencent.mm.pluginsdk.ui.span.m)localObject5).length(), (TextPaint)localObject4);
            if (com.tencent.mm.cb.a.E(this.mActivity, (int)f) > paramBaseViewHolder.EBt) {
              do
              {
                if (((String)localObject1).length() <= 1) {
                  break;
                }
                localObject1 = ((String)localObject1).substring(0, ((String)localObject1).length() - 2);
                localObject5 = String.format(((ADInfo)localObject3).adActionExtTailWording, new Object[] { (String)localObject1 + "..." });
                localObject6 = this.mActivity;
                paramBaseViewHolder.EWM.getTextSize();
                localObject6 = new com.tencent.mm.pluginsdk.ui.span.m(com.tencent.mm.pluginsdk.ui.span.l.f((Context)localObject6, (CharSequence)localObject5, 1));
                ((com.tencent.mm.pluginsdk.ui.span.m)localObject6).a(null, (CharSequence)localObject5, 0);
                f = Layout.getDesiredWidth((CharSequence)localObject6, 0, ((com.tencent.mm.pluginsdk.ui.span.m)localObject6).length(), (TextPaint)localObject4);
                j = com.tencent.mm.cb.a.E(this.mActivity, (int)f);
                paramBaseViewHolder.EWM.setText((CharSequence)localObject6, TextView.BufferType.SPANNABLE);
                paramBaseViewHolder.EWM.setVisibility(0);
              } while (j > paramBaseViewHolder.EBt);
            }
          }
          for (;;)
          {
            a((ADInfo)localObject3, paramBaseViewHolder);
            break;
            paramBaseViewHolder.EWM.setText((CharSequence)localObject5, TextView.BufferType.SPANNABLE);
            paramBaseViewHolder.EWM.setVisibility(0);
            continue;
            paramBaseViewHolder.EWM.setVisibility(8);
          }
          paramBaseViewHolder.EWN.setVisibility(8);
          break label1370;
          BaseViewHolder.l(paramBaseViewHolder).setVisibility(8);
          break label1423;
          j = this.mActivity.getResources().getColor(2131100245);
          break label1519;
          paramBaseViewHolder.EIm.setBackground(this.mActivity.getResources().getDrawable(2131233974));
          break label1554;
          paramBaseViewHolder.EIm.setVisibility(8);
          break label1554;
          paramBaseViewHolder.EWL.setVisibility(8);
          break label1600;
          j = 0;
          break label1724;
          if (parambl.ENN)
          {
            paramBaseViewHolder.jBQ.setVisibility(0);
            localObject1 = new SpannableString(parambl.ENQ);
            ((SpannableString)localObject1).setSpan(new c(), 0, ((SpannableString)localObject1).length(), 33);
            paramBaseViewHolder.jBQ.setText((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
            paramBaseViewHolder.jBQ.setTag(new bo(parambl.ENP, parambl.ENQ));
            break label1873;
          }
          if (parambl.ENR)
          {
            paramBaseViewHolder.jBQ.setVisibility(0);
            localObject1 = this.mActivity.getString(2131755354);
            localObject3 = (String)localObject1 + parambl.mAppName;
            localObject4 = new SpannableString((CharSequence)localObject3);
            ((SpannableString)localObject4).setSpan(new ForegroundColorSpan(this.mActivity.getResources().getColor(2131101161)), 0, ((String)localObject1).length(), 33);
            ((SpannableString)localObject4).setSpan(new a(), ((String)localObject1).length(), ((String)localObject3).length(), 33);
            paramBaseViewHolder.jBQ.setText((CharSequence)localObject4, TextView.BufferType.SPANNABLE);
            if ((!parambl.ENO) && (!"wx7fa037cc7dfabad5".equals(paramTimeLineObject.AppInfo.Id)))
            {
              paramBaseViewHolder.jBQ.setTextColor(this.mActivity.getResources().getColor(2131101161));
              paramBaseViewHolder.jBQ.setOnTouchListener(null);
            }
            paramBaseViewHolder.jBQ.setTag(paramTimeLineObject);
            break label1873;
          }
          paramBaseViewHolder.jBQ.setVisibility(8);
          break label1873;
          paramBaseViewHolder.EqV.setVisibility(8);
          break label1901;
          paramBaseViewHolder.EeT.setText(2131766170);
          paramBaseViewHolder.EWV.setClickable(false);
          paramBaseViewHolder.EWV.setEnabled(false);
          break label2086;
          paramBaseViewHolder.EeT.setText(2131766172);
          paramBaseViewHolder.EWV.setClickable(false);
          paramBaseViewHolder.EWV.setEnabled(false);
          break label2086;
          paramBaseViewHolder.EeT.setText(2131766171);
          paramBaseViewHolder.EWV.setClickable(true);
          paramBaseViewHolder.EWV.setEnabled(true);
          break label2086;
          if (!paramBaseViewHolder.EXf) {
            break label2120;
          }
          paramBaseViewHolder.EXb.setVisibility(8);
          break label2120;
          paramBaseViewHolder.EWO.setVisibility(8);
          break label2148;
          paramTimeLineObject = String.format(this.mActivity.getString(2131766277), new Object[] { parambl.ENX });
          break label2209;
          label4553:
          if (parambl.ENY)
          {
            paramBaseViewHolder.EWK.setVisibility(0);
            paramTimeLineObject = this.mActivity.getString(2131766278);
            paramTimeLineObject = com.tencent.mm.pluginsdk.ui.span.l.b(this.mActivity, paramTimeLineObject.toString(), paramBaseViewHolder.EWK.getTextSize());
            paramBaseViewHolder.EWK.setText(paramTimeLineObject);
            break label2236;
          }
          paramBaseViewHolder.EWK.setVisibility(8);
          break label2236;
          if (paramBaseViewHolder.EXz == null) {
            break label2407;
          }
          paramBaseViewHolder.EXz.setVisibility(8);
          break label2407;
          if (!paramBaseViewHolder.EXa) {
            break label2461;
          }
          paramBaseViewHolder.EWZ.setVisibility(8);
          break label2461;
          if (!paramBaseViewHolder.EXa)
          {
            if ((paramBaseViewHolder.EnO != null) || (paramBaseViewHolder.EWZ.getParent() == null)) {
              break label5012;
            }
            paramBaseViewHolder.EnO = ((LinearLayout)paramBaseViewHolder.EWZ.inflate());
            if (paramBaseViewHolder.EnO != null)
            {
              paramBaseViewHolder.EWR = ((SnsLikesTextView)paramBaseViewHolder.EnO.findViewById(2131296665));
              paramBaseViewHolder.EWR.setLikedTextTouchListener(new af());
              paramBaseViewHolder.EWR.setOpClickListener(parambk.EKF);
              paramBaseViewHolder.EWT = ((LinearLayout)paramBaseViewHolder.convertView.findViewById(2131296634));
              paramBaseViewHolder.EnO.setTag(parambl.Dsr);
              paramBaseViewHolder.EWR.setLikeTvTag(parambl.Dsr);
              paramBaseViewHolder.EWR.setOpTvTag(paramBaseViewHolder);
              paramBaseViewHolder.EWY = paramBaseViewHolder.EnO.findViewById(2131296669);
              paramBaseViewHolder.EXB = paramBaseViewHolder.EnO.findViewById(2131296667);
              paramBaseViewHolder.EXa = true;
            }
          }
          if (paramBaseViewHolder.EnO != null) {
            paramBaseViewHolder.EnO.setVisibility(0);
          }
          if ((parambl.EOd != null) && (parambl.EOd.size() > 0))
          {
            paramBaseViewHolder.EWR.setVisibility(0);
            parambk.a(parambl.Eql, paramBaseViewHolder.EWR);
            paramBaseViewHolder.EWR.a(parambl.EOd, paramInt2, parambk, parambl.Eql, parambk.EFK, parambk.EFL, parambk.EKp, parambl, paramBaseViewHolder);
            paramBaseViewHolder.EWS = true;
            label4935:
            if (parambl.EOe == null) {
              break label5068;
            }
            a(((SnsObject)localObject2).CommentUserList, parambl.EOe, paramBaseViewHolder, parambl, paramInt1, paramSnsInfo);
          }
          for (;;)
          {
            if ((parambl.EOd == null) || (parambl.EOd.size() == 0) || (parambl.EOe == null) || (parambl.EOe.size() == 0)) {
              break label5080;
            }
            paramBaseViewHolder.EWY.setVisibility(0);
            break;
            if (paramBaseViewHolder.EnO == null) {}
            for (bool = true;; bool = false)
            {
              Log.e("MicroMsg.BaseTimeLineItem", "holder.listKeeper = null %s,and holder.commentStub.inflated", new Object[] { Boolean.valueOf(bool) });
              break;
            }
            paramBaseViewHolder.EWR.setVisibility(8);
            paramBaseViewHolder.EWS = false;
            break label4935;
            label5068:
            paramBaseViewHolder.EWT.setVisibility(8);
          }
          label5080:
          paramBaseViewHolder.EWY.setVisibility(8);
          break label2461;
          label5092:
          paramBaseViewHolder.EWF.setVisibility(8);
          break label2501;
          label5104:
          i = 0;
          break label2638;
          label5110:
          if (i != 0)
          {
            paramBaseViewHolder.DDr.setVisibility(8);
            paramBaseViewHolder.EWJ.setTag(new com.tencent.mm.plugin.sns.data.g(paramBaseViewHolder.EWJ, paramSnsInfo.getLocalid()));
            paramBaseViewHolder.EWJ.setVisibility(0);
            break label2701;
          }
          paramBaseViewHolder.DDr.setVisibility(8);
          paramBaseViewHolder.EWJ.setVisibility(8);
          break label2701;
          paramInt1 = 0;
          break label2852;
          paramInt1 = 0;
          break label2869;
          label5188:
          if (paramBaseViewHolder.EXF)
          {
            paramBaseViewHolder.EXG.setVisibility(8);
            paramBaseViewHolder.EXI.setTag(Long.valueOf(paramSnsInfo.field_snsId));
          }
          paramBaseViewHolder.jLy.setBackgroundResource(2131233327);
          break label2981;
          label5231:
          if (paramBaseViewHolder.EXJ) {
            paramBaseViewHolder.EXK.setVisibility(8);
          }
          paramBaseViewHolder.jLy.setBackgroundResource(2131233327);
          continue;
          if ((this.DQX != null) && (this.DQX.getCount() - 1 == paramInt1))
          {
            paramBaseViewHolder.jLy.setBackgroundColor(0);
            paramBaseViewHolder.EXO.setVisibility(0);
          }
          else
          {
            paramBaseViewHolder.jLy.setBackgroundResource(2131233327);
            paramBaseViewHolder.EXO.setVisibility(8);
          }
        }
        label5321:
        paramTimeLineObject = new StringBuilder("");
        if ((parambl.EOe != null) && (parambl.EOe.size() > 0))
        {
          paramTimeLineObject.append(MMApplicationContext.getContext().getResources().getString(2131765921)).append(":");
          paramInt1 = 0;
          while (paramInt1 < parambl.EOe.size())
          {
            parambk = (com.tencent.mm.vending.j.a)parambl.EOe.get(paramInt1);
            if (parambk != null) {
              paramTimeLineObject.append((CharSequence)parambk.get(6)).append(",");
            }
            paramInt1 += 1;
          }
        }
        paramInt1 = 0;
        if (paramInt2 == 2) {}
        for (paramInt1 = 1;; paramInt1 = 2) {
          do
          {
            parambk = com.tencent.mm.ui.a.a.a.gKe();
            parambl = paramBaseViewHolder.convertView;
            localObject1 = paramBaseViewHolder.EWx;
            localObject2 = paramBaseViewHolder.timeTv;
            localObject3 = paramBaseViewHolder.EIm;
            localObject4 = paramBaseViewHolder.EWA.getContent();
            localObject5 = paramBaseViewHolder.EWH;
            bool = paramBaseViewHolder.EXv;
            paramBaseViewHolder = paramBaseViewHolder.jBQ;
            paramSnsInfo = paramSnsInfo.toString();
            paramTimeLineObject = paramTimeLineObject.toString();
            if ((parambk.gKc()) && (parambk.mAppContext != null) && (parambl != null) && (localObject1 != null) && (localObject2 != null) && (localObject3 != null) && (paramBaseViewHolder != null)) {
              break;
            }
            return;
          } while ((paramInt2 != 3) && (paramInt2 != 4) && (paramInt2 != 5));
        }
        Object localObject6 = new com.tencent.mm.ui.a.b();
        ((com.tencent.mm.ui.a.b)localObject6).blW(((TextView)localObject1).getText().toString());
        ((com.tencent.mm.ui.a.b)localObject6).blW((String)localObject4);
        if ((localObject5 != null) && (((TextView)localObject5).getText() != null)) {
          ((com.tencent.mm.ui.a.b)localObject6).blW(((TextView)localObject5).getText().toString());
        }
        if (bool) {
          ((com.tencent.mm.ui.a.b)localObject6).blW(parambk.mAppContext.getString(2131758184));
        }
        if (paramInt1 == 1) {
          ((com.tencent.mm.ui.a.b)localObject6).blW(parambk.mAppContext.getString(2131758182));
        }
        for (;;)
        {
          if ((localObject3 != null) && (((TextView)localObject3).getText() != null)) {
            ((com.tencent.mm.ui.a.b)localObject6).blW(((TextView)localObject3).getText().toString());
          }
          if ((localObject2 != null) && (((TextView)localObject2).getText() != null)) {
            ((com.tencent.mm.ui.a.b)localObject6).blW(((TextView)localObject2).getText().toString());
          }
          if ((paramBaseViewHolder != null) && (paramBaseViewHolder.getText() != null)) {
            ((com.tencent.mm.ui.a.b)localObject6).blW(paramBaseViewHolder.getText().toString());
          }
          if (paramSnsInfo != null) {
            ((com.tencent.mm.ui.a.b)localObject6).blW(paramSnsInfo);
          }
          if (paramTimeLineObject != null) {
            ((com.tencent.mm.ui.a.b)localObject6).blW(paramTimeLineObject);
          }
          ((com.tencent.mm.ui.a.b)localObject6).gt(parambl);
          return;
          if (paramInt1 > 1) {
            ((com.tencent.mm.ui.a.b)localObject6).blW(parambk.mAppContext.getString(2131758183));
          }
        }
      }
      label2869:
      label4664:
      label5178:
      i = 0;
      label2981:
      label3373:
      label4021:
      break label614;
      label4009:
      label4523:
      i = 0;
    }
  }
  
  public abstract void a(BaseViewHolder paramBaseViewHolder, int paramInt1, bl parambl, TimeLineObject paramTimeLineObject, int paramInt2, bk parambk);
  
  public abstract void d(BaseViewHolder paramBaseViewHolder);
  
  public final void setIsFromMainTimeline(boolean paramBoolean)
  {
    this.EAv = paramBoolean;
  }
  
  public static class BaseViewHolder
  {
    public bq DDr;
    public TextView DGi;
    public int EBt;
    public TextView EIm;
    public View EIs;
    public com.tencent.mm.plugin.sns.ui.at EUK;
    public AsyncNormalTextView EWA;
    public SnsTranslateResultView EWB;
    public LinearLayout EWC;
    public ViewStub EWD;
    public boolean EWE;
    public TextView EWF;
    public TagImageView EWG;
    public TextView EWH;
    public int EWI;
    public RelativeLayout EWJ;
    public TextView EWK;
    public WeImageView EWL;
    public AsyncTextView EWM;
    public AsyncTextView EWN;
    public View EWO;
    public ImageView EWP;
    public View EWQ;
    public SnsLikesTextView EWR;
    public boolean EWS;
    public LinearLayout EWT;
    public LinearLayout EWU;
    public View EWV;
    public LinearLayout EWW;
    public PhotosContent EWX;
    public View EWY;
    public ViewStub EWZ;
    public long EWu;
    public int EWv;
    public SnsAvatarImageView EWw;
    public AsyncTextView EWx;
    public ImageView EWy;
    public ViewGroup EWz;
    public MaskTextView EXA;
    public View EXB;
    private TextView EXC;
    public String EXD;
    public View EXE;
    public boolean EXF;
    public ViewStub EXG;
    public LinearLayout EXH;
    public ViewGroup EXI;
    public boolean EXJ;
    public ViewStub EXK;
    public LinearLayout EXL;
    public TextView EXM;
    public TextView EXN;
    public View EXO;
    public boolean EXa;
    public ViewStub EXb;
    public ViewStub EXc;
    public View EXd;
    public boolean EXe;
    public boolean EXf;
    public ViewStub EXg;
    public boolean EXh;
    public View EXi;
    public LinearLayout EXj;
    public TextView EXk;
    public ViewStub EXl;
    public boolean EXm;
    public View EXn;
    public LinearLayout EXo;
    public ViewStub EXp;
    public boolean EXq;
    public View EXr;
    public ImageView EXs;
    public boolean EXt;
    ViewStub EXu;
    boolean EXv;
    public View EXw;
    public BaseTimeLineItem EXx;
    public ViewStub EXy;
    public View EXz;
    public TextView EeT;
    public LinearLayout EnO;
    public com.tencent.mm.contact.c Eou;
    public TextView EqV;
    public View convertView;
    public String dHp;
    public String dRS;
    public volatile boolean hho;
    public boolean isAd;
    public TextView jBQ;
    public ViewGroup jLy;
    public int position;
    public cnc postInfo;
    public int qcr;
    public SnsObject snsobj;
    public TimeLineObject timeLineObject;
    public TextView timeTv;
    public TextView titleTv;
    public ImageView uzC;
    public boolean xEm;
    
    public BaseViewHolder()
    {
      AppMethodBeat.i(100055);
      this.EWE = false;
      this.EWI = 0;
      this.EBt = 210;
      this.EWS = false;
      this.EXa = false;
      this.EXd = null;
      this.EXe = false;
      this.EXf = false;
      this.EXh = false;
      this.EXm = false;
      this.EXq = false;
      this.EXt = false;
      this.EXv = false;
      this.EUK = new com.tencent.mm.plugin.sns.ui.at();
      this.EXF = false;
      this.EXJ = false;
      AppMethodBeat.o(100055);
    }
  }
  
  final class a
    extends q
  {
    a() {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(100051);
      BaseTimeLineItem.this.DQX.EBo.ERu.onClick(paramView);
      AppMethodBeat.o(100051);
    }
    
    public final void updateDrawState(TextPaint paramTextPaint)
    {
      AppMethodBeat.i(100052);
      int i = BaseTimeLineItem.this.mActivity.getResources().getColor(2131101130);
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
    extends q
  {
    b() {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(100053);
      BaseTimeLineItem.this.DQX.EBo.ERi.onClick(paramView);
      AppMethodBeat.o(100053);
    }
    
    public final void updateDrawState(TextPaint paramTextPaint)
    {
      AppMethodBeat.i(100054);
      int i = BaseTimeLineItem.this.mActivity.getResources().getColor(2131101130);
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
    extends q
  {
    c() {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(100056);
      BaseTimeLineItem.this.DQX.EBo.ERj.onClick(paramView);
      AppMethodBeat.o(100056);
    }
    
    public final void updateDrawState(TextPaint paramTextPaint)
    {
      AppMethodBeat.i(100057);
      int i = BaseTimeLineItem.this.mActivity.getResources().getColor(2131101130);
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
    public int ECO;
    public com.tencent.mm.plugin.sns.ui.l EKu;
    public CharSequence EXP;
    public int EXQ;
    public int deleteFlag;
    public CharSequence hus;
    public String md5;
    private WeakReference<View> view;
    
    public d(String paramString, CharSequence paramCharSequence1, CharSequence paramCharSequence2, View paramView, int paramInt1, int paramInt2, com.tencent.mm.plugin.sns.ui.l paraml)
    {
      AppMethodBeat.i(203914);
      this.view = null;
      this.md5 = null;
      this.EXP = null;
      this.hus = null;
      this.ECO = 0;
      this.deleteFlag = 0;
      this.EXQ = com.tencent.mm.ui.at.fromDPToPix(MMApplicationContext.getContext(), 28);
      this.EKu = null;
      this.view = new WeakReference(paramView);
      this.md5 = paramString;
      this.EXP = paramCharSequence1;
      this.hus = paramCharSequence2;
      this.ECO = paramInt1;
      this.deleteFlag = paramInt2;
      this.EKu = paraml;
      AppMethodBeat.o(203914);
    }
    
    public final void f(Bitmap paramBitmap, String paramString)
    {
      AppMethodBeat.i(100059);
      Log.i("MicroMsg.BaseTimeLineItem", "onEmojiDecodeFin bitmapAvailable:%s, md5:%s", new Object[] { Boolean.valueOf(r.M(paramBitmap)), paramString });
      if ((this.view != null) && (this.view.get() != null) && ((this.view.get() instanceof SnsCommentCollapseLayout)))
      {
        SnsCommentCollapseLayout localSnsCommentCollapseLayout = (SnsCommentCollapseLayout)this.view.get();
        if ((localSnsCommentCollapseLayout != null) && (localSnsCommentCollapseLayout.getTag() != null) && ((localSnsCommentCollapseLayout.getTag() instanceof com.tencent.mm.plugin.sns.ui.m)))
        {
          Object localObject = (com.tencent.mm.plugin.sns.ui.m)localSnsCommentCollapseLayout.getTag();
          if ((((com.tencent.mm.plugin.sns.ui.m)localObject).DIu != null) && (!Util.isNullOrNil(((com.tencent.mm.plugin.sns.ui.m)localObject).DIu.MYY)) && (((com.tencent.mm.plugin.sns.ui.m)localObject).DIu.MYY.get(0) != null) && (Util.isEqual(paramString, ((dzu)((com.tencent.mm.plugin.sns.ui.m)localObject).DIu.MYY.get(0)).Md5)) && (r.M(paramBitmap)))
          {
            paramBitmap = new BitmapDrawable(paramBitmap);
            paramBitmap.setBounds(0, 0, this.EXQ, this.EXQ);
            paramBitmap = new com.tencent.mm.ui.widget.a(paramBitmap);
            MMApplicationContext.getContext();
            paramString = new q(this.md5, this.EKu, 2);
            localObject = new SpannableStringBuilder(this.EXP);
            ((SpannableStringBuilder)localObject).append("  ").append(this.md5).append("  ").append(" ");
            int i = ((SpannableStringBuilder)localObject).length() - this.md5.length() - 2 - 1;
            int j = ((SpannableStringBuilder)localObject).length() - this.md5.length() - 4 - 1;
            ((SpannableStringBuilder)localObject).setSpan(paramBitmap, i, this.md5.length() + i, 33);
            ((SpannableStringBuilder)localObject).setSpan(paramString, j, j + 4 + this.md5.length(), 33);
            SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(this.hus);
            localSpannableStringBuilder.append("  ").append(this.md5).append("  ").append(" ");
            i = localSpannableStringBuilder.length() - this.md5.length() - 2 - 1;
            j = localSpannableStringBuilder.length() - this.md5.length() - 4 - 1;
            localSpannableStringBuilder.setSpan(paramBitmap, i, this.md5.length() + i, 33);
            localSpannableStringBuilder.setSpan(paramString, j, j + 4 + this.md5.length(), 33);
            localSnsCommentCollapseLayout.a((CharSequence)localObject, localSpannableStringBuilder, this.ECO, this.deleteFlag);
          }
        }
      }
      AppMethodBeat.o(100059);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem
 * JD-Core Version:    0.7.0.1
 */