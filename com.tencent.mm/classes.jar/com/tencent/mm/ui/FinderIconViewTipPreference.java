package com.tencent.mm.ui;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.cd.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.i;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.utils.at;
import com.tencent.mm.plugin.finder.view.FinderRedDotTextView;
import com.tencent.mm.plugin.newtips.NormalIconNewTipPreference;
import com.tencent.mm.plugin.newtips.b.b;
import com.tencent.mm.protocal.protobuf.FinderTipsShowEntranceExtInfo;
import com.tencent.mm.protocal.protobuf.fng;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FinderIconViewTipPreference
  extends NormalIconNewTipPreference
{
  private boolean adzA;
  private boolean adzB;
  private boolean adzC;
  private boolean adzD;
  private RelativeLayout adzE;
  private WeImageView adzF;
  private LinearLayout adzG;
  private RelativeLayout adzH;
  private LinearLayout.LayoutParams adzI;
  private LinearLayout.LayoutParams adzJ;
  private LinearLayout.LayoutParams adzK;
  private LinearLayout.LayoutParams adzL;
  ViewGroup adzc;
  View adzd;
  View adze;
  View adzf;
  View adzg;
  ImageView adzh;
  ImageView adzi;
  ImageView adzj;
  ImageView adzk;
  ImageView adzl;
  ImageView adzm;
  WeImageView adzn;
  LinearLayout adzo;
  ImageView adzp;
  ArrayList<View> adzq;
  ArrayList<ImageView> adzr;
  View adzs;
  ImageView adzt;
  ImageView adzu;
  ImageView adzv;
  ImageView adzw;
  FinderRedDotTextView adzx;
  private boolean adzy;
  private fng adzz;
  TextView akme;
  Context mContext;
  private int mStyle;
  TextView xul;
  TextView xum;
  
  public FinderIconViewTipPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FinderIconViewTipPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(249483);
    this.mContext = paramContext;
    this.adYN = true;
    setLayoutResource(R.i.finder_mm_preference);
    AppMethodBeat.o(249483);
  }
  
  private void KZ(boolean paramBoolean)
  {
    AppMethodBeat.i(249493);
    Log.i("FinderIconViewTipPreference", "changeContentLayoutParam :".concat(String.valueOf(paramBoolean)));
    ViewGroup localViewGroup;
    if (this.lBX != null)
    {
      localViewGroup = (ViewGroup)this.lBX.findViewById(a.g.content);
      if (!paramBoolean) {
        break label95;
      }
      localViewGroup.setLayoutParams(this.adzK);
      this.adzG.setLayoutParams(this.adzI);
      bg(this.adzH, 8);
      bg(this.adzF, 0);
    }
    for (;;)
    {
      this.adzH.requestLayout();
      AppMethodBeat.o(249493);
      return;
      label95:
      localViewGroup.setLayoutParams(this.adzL);
      this.adzG.setLayoutParams(this.adzJ);
      bg(this.adzH, 0);
      bg(this.adzc, 0);
      bg(this.adzF, 8);
      Log.i("FinderIconViewTipPreference", "changeContentLayoutParam mThirdLayoutContainer:" + this.adzH);
    }
  }
  
  private static void a(fng paramfng, int paramInt)
  {
    AppMethodBeat.i(249578);
    int i = paramfng.hrh.size();
    while (i > paramInt)
    {
      paramfng.hrh.removeLast();
      i -= 1;
    }
    AppMethodBeat.o(249578);
  }
  
  private void a(fng paramfng, boolean paramBoolean)
  {
    AppMethodBeat.i(249518);
    boolean bool = paramfng.abNs;
    FinderRedDotTextView localFinderRedDotTextView = this.adzx;
    Object localObject2 = null;
    Log.i("FinderIconViewTipPreference", "setNewTitleView: isZh" + jiH());
    Object localObject1;
    if (paramBoolean)
    {
      localObject1 = this.xum.getLayoutParams();
      if (((ViewGroup.LayoutParams)localObject1).width != -2)
      {
        ((ViewGroup.LayoutParams)localObject1).width = -2;
        this.xum.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      localObject1 = this.xum;
    }
    while (!Util.isNullOrNil(paramfng.title)) {
      if (localObject1 != null)
      {
        bg((View)localObject1, 0);
        bg(localFinderRedDotTextView, 8);
        ((TextView)localObject1).setText(paramfng.title);
        AppMethodBeat.o(249518);
        return;
        if ((!jiH()) || (!jiI()))
        {
          localObject1 = this.xul;
        }
        else
        {
          localObject1 = localObject2;
          if (this.xul != null)
          {
            bg(this.xul, 8);
            localObject1 = localObject2;
          }
        }
      }
      else
      {
        bg(localFinderRedDotTextView, 0);
        if (localFinderRedDotTextView == null) {
          break label330;
        }
        localObject1 = paramfng.abNp;
        if (aw.isDarkMode()) {
          localObject1 = paramfng.abNr;
        }
        int i = bzG((String)localObject1);
        if (!bool) {
          i = this.mContext.getResources().getColor(R.e.FG_1);
        }
        if (paramfng.title == null) {
          paramfng.title = "";
        }
        if (paramfng.abNo == null) {
          paramfng.abNo = "";
        }
        if (paramfng.abNq == null) {
          paramfng.abNq = "";
        }
        localFinderRedDotTextView.a(b(paramfng, true, false), paramfng.title, paramfng.abNo, R.f.SmallestTextSize, i, paramfng.abNq);
        AppMethodBeat.o(249518);
        return;
      }
    }
    bg((View)localObject1, 8);
    bg(localFinderRedDotTextView, 8);
    label330:
    AppMethodBeat.o(249518);
  }
  
  private void a(fng paramfng, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(249515);
    if (paramBoolean2)
    {
      bg(this.adzn, 0);
      if (Util.isNullOrNil(paramfng.title)) {
        break label157;
      }
      if (!paramBoolean1) {
        break label144;
      }
      bg(this.xul, 8);
      bg(this.adzx, 8);
    }
    for (;;)
    {
      a(paramfng, paramBoolean1);
      if ((this.adzx == null) || (this.adzx.getDropStat() != 1) || (!c(paramfng))) {
        break label187;
      }
      paramfng.abNo = "";
      paramfng.abNq = "";
      a(this.adzy, paramfng, this.mStyle, true, this.adzB, this.adzC, this.adzD);
      AppMethodBeat.o(249515);
      return;
      bg(this.adzn, 8);
      break;
      label144:
      bg(this.xum, 8);
    }
    label157:
    bg(this.xum, 8);
    bg(this.xul, 8);
    bg(this.adzx, 8);
    label187:
    AppMethodBeat.o(249515);
  }
  
  private void a(fng paramfng, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    int i = 3;
    AppMethodBeat.i(249574);
    if (this.adzs == null)
    {
      AppMethodBeat.o(249574);
      return;
    }
    bg(this.adzs, 0);
    bg(this.adzm, 8);
    Object localObject = paramfng.hrh.iterator();
    while (((Iterator)localObject).hasNext()) {
      Log.i("FinderIconViewTipPreference", "bindMultiAvatarTask url:".concat(String.valueOf((String)((Iterator)localObject).next())));
    }
    if ((!jiH()) && (paramfng.hrh.size() > 1)) {
      a(paramfng, 1);
    }
    int k = paramfng.hrh.size();
    Log.i("FinderIconViewTipPreference", "bindMultiAvatarTask urlSize:".concat(String.valueOf(k)));
    int j = i;
    if (k > 0)
    {
      if (k < 3) {
        i = k;
      }
      j = 0;
      if (j < i)
      {
        localObject = azZ(j);
        if (localObject != null)
        {
          bg((View)localObject, 0);
          if (!paramBoolean4) {
            break label216;
          }
          p((String)paramfng.hrh.get(j), (ImageView)localObject);
        }
        for (;;)
        {
          j += 1;
          break;
          label216:
          q((String)paramfng.hrh.get(j), (ImageView)localObject);
        }
      }
      Log.i("FinderIconViewTipPreference", "bindMultiAvatarTask load avatar: " + j + " isSquare:" + paramBoolean4);
      azY(j);
      a(paramfng, j);
      if ((!paramBoolean2) && (j - 1 > 0))
      {
        Log.i("FinderIconViewTipPreference", "bindMultiAvatarTask adjust avatarView marginEnd");
        localObject = azZ(j - 1);
        if (localObject != null)
        {
          ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)((ImageView)localObject).getLayoutParams();
          localMarginLayoutParams.setMarginEnd(0);
          ((ImageView)localObject).setLayoutParams(localMarginLayoutParams);
        }
      }
      Log.i("FinderIconViewTipPreference", "bindMultiAvatarTask dismiss avatar: " + j + " isSquare:" + paramBoolean4);
      j = i;
    }
    if ((j == 1) && (paramBoolean1) && (!c(paramfng))) {
      bg(this.adzw, 0);
    }
    for (;;)
    {
      paramBoolean1 = g(paramBoolean2, paramfng.title, j);
      if ((paramBoolean1) && (j > 1)) {
        e(paramfng);
      }
      Log.i("FinderIconViewTipPreference", "isAdjust :" + paramBoolean1 + "  maxAvatars:" + j);
      a(paramfng, paramBoolean2, paramBoolean3);
      AppMethodBeat.o(249574);
      return;
      bg(this.adzw, 8);
    }
  }
  
  private void a(fng paramfng, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, Boolean paramBoolean, boolean paramBoolean5)
  {
    AppMethodBeat.i(249551);
    if ((this.adzh == null) || (this.adzd == null))
    {
      AppMethodBeat.o(249551);
      return;
    }
    bg(this.adzE, 0);
    bg(this.adzm, 8);
    Object localObject1;
    float f;
    int i;
    Object localObject2;
    if (paramBoolean1)
    {
      localObject1 = this.adzh.getLayoutParams();
      if (paramBoolean.booleanValue())
      {
        f = this.adzh.getContext().getResources().getDimension(R.f.finder_4_75_A);
        ((ViewGroup.LayoutParams)localObject1).width = ((int)f);
        ((ViewGroup.LayoutParams)localObject1).height = ((int)f);
        i = this.adzh.getContext().getResources().getDimensionPixelOffset(R.f.Edge_0_5_A);
        this.adzh.setPadding(i, i, i, i);
        localObject2 = this.adzd.getLayoutParams();
        if ((localObject2 instanceof RelativeLayout.LayoutParams)) {
          ((RelativeLayout.LayoutParams)localObject2).rightMargin = (this.adzh.getContext().getResources().getDimensionPixelOffset(R.f.finder_0_125_A) + 1);
        }
        if (this.xul != null)
        {
          localObject2 = this.xul.getLayoutParams();
          if ((localObject2 instanceof LinearLayout.LayoutParams)) {
            ((LinearLayout.LayoutParams)localObject2).rightMargin = (this.adzh.getContext().getResources().getDimensionPixelOffset(R.f.Edge_0_5_A) + this.adzh.getContext().getResources().getDimensionPixelOffset(R.f.finder_0_125_A) + 1);
          }
        }
        localObject2 = this.adzh.getContext().getResources().getDrawable(R.g.find_page_live_avatar_bg_shape);
        this.adzh.setBackground((Drawable)localObject2);
        this.adzh.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        label280:
        if (Util.isNullOrNil(paramfng.url)) {
          break label709;
        }
        Log.i("FinderIconViewTipPreference", "[bindSingleAvatarTask] load=%s isBigAvatar=%s isWithRedDot=%s", new Object[] { paramfng.url, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
        localObject1 = com.tencent.mm.plugin.finder.loader.p.ExI;
        localObject1 = com.tencent.mm.plugin.finder.loader.p.eCp();
        localObject2 = new com.tencent.mm.plugin.finder.loader.b(paramfng.url, com.tencent.mm.plugin.finder.storage.v.FLF);
        ImageView localImageView = this.adzh;
        com.tencent.mm.plugin.finder.loader.p localp = com.tencent.mm.plugin.finder.loader.p.ExI;
        ((com.tencent.mm.loader.d)localObject1).a(localObject2, localImageView, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExM));
        this.adzh.setVisibility(0);
        bg(this.adzd, 0);
        bg(this.adze, 8);
        bg(this.adzi, 8);
        bg(this.adzp, 8);
        bg(this.adzc, 0);
        if (!paramBoolean2) {
          break label872;
        }
        bg(this.adzl, 0);
        if (paramBoolean4) {
          break label782;
        }
        paramBoolean = this.adzl.getLayoutParams();
        paramBoolean.width = -2;
        paramBoolean.height = -2;
        this.adzl.setLayoutParams(paramBoolean);
        this.adzl.setImageResource(R.g.unread_dot_shape);
      }
    }
    for (;;)
    {
      for (;;)
      {
        a(paramfng, paramBoolean3, paramBoolean5);
        AppMethodBeat.o(249551);
        return;
        f = this.adzh.getContext().getResources().getDimension(R.f.Edge_4A);
        ((ViewGroup.LayoutParams)localObject1).width = ((int)f);
        ((ViewGroup.LayoutParams)localObject1).height = ((int)f);
        this.adzh.setPadding(0, 0, 0, 0);
        localObject2 = this.adzd.getLayoutParams();
        if ((localObject2 instanceof RelativeLayout.LayoutParams)) {
          ((RelativeLayout.LayoutParams)localObject2).rightMargin = (this.adzh.getContext().getResources().getDimensionPixelOffset(R.f.Edge_0_5_A) + 1);
        }
        if (this.xul != null)
        {
          localObject2 = this.xul.getLayoutParams();
          if ((localObject2 instanceof LinearLayout.LayoutParams)) {
            ((LinearLayout.LayoutParams)localObject2).rightMargin = this.adzh.getContext().getResources().getDimensionPixelOffset(R.f.Edge_A);
          }
        }
        this.adzh.setBackground(null);
        break;
        localObject1 = this.adzh.getLayoutParams();
        f = this.adzh.getContext().getResources().getDimension(R.f.Edge_2_5_A);
        ((ViewGroup.LayoutParams)localObject1).width = ((int)f);
        ((ViewGroup.LayoutParams)localObject1).height = ((int)f);
        this.adzh.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        break label280;
        try
        {
          label709:
          localObject1 = BackwardSupportUtil.BitmapFactory.decodeStream(this.mContext.getAssets().open("avatar/default_nor_avatar.png"), a.getDensity(null));
          this.adzh.setImageBitmap((Bitmap)localObject1);
          Log.w("FinderIconViewTipPreference", "[bindSingleAvatarTask] tipsInfo.url is null.");
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            Log.w("FinderIconViewTipPreference", "[bindSingleAvatarTask] e:" + localIOException.toString());
          }
        }
      }
      label782:
      if (paramBoolean.booleanValue())
      {
        this.adzl.setVisibility(8);
      }
      else
      {
        paramBoolean = this.adzl.getLayoutParams();
        i = (int)(com.tencent.mm.view.d.e(this.adzl.getContext(), 11.1F) * a.getScaleSize(this.mContext));
        paramBoolean.width = i;
        paramBoolean.height = i;
        this.adzl.setLayoutParams(paramBoolean);
        this.adzl.setImageResource(R.k.finder_live_icon);
        continue;
        label872:
        bg(this.adzl, 8);
      }
    }
  }
  
  private void a(fng paramfng, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    AppMethodBeat.i(249511);
    if ((this.adzi == null) || (this.adze == null))
    {
      AppMethodBeat.o(249511);
      return;
    }
    bg(this.adzE, 0);
    bg(this.adzm, 8);
    Object localObject;
    float f;
    if (paramBoolean1)
    {
      localObject = this.adzi.getLayoutParams();
      f = this.adzi.getContext().getResources().getDimension(R.f.Edge_4A);
      ((ViewGroup.LayoutParams)localObject).width = ((int)f);
      ((ViewGroup.LayoutParams)localObject).height = ((int)f);
      this.adzi.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (Util.isNullOrNil(paramfng.url)) {
        break label375;
      }
      Log.i("FinderIconViewTipPreference", "[bindSingleSquareAvatarTask] load=%s isBigAvatar=%s isWithRedDot=%s", new Object[] { paramfng.url, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
      localObject = com.tencent.mm.plugin.finder.loader.p.ExI;
      localObject = com.tencent.mm.plugin.finder.loader.p.eCq();
      com.tencent.mm.plugin.finder.loader.b localb = new com.tencent.mm.plugin.finder.loader.b(paramfng.url, com.tencent.mm.plugin.finder.storage.v.FLF);
      ImageView localImageView = this.adzi;
      com.tencent.mm.plugin.finder.loader.p localp = com.tencent.mm.plugin.finder.loader.p.ExI;
      ((com.tencent.mm.loader.d)localObject).a(localb, localImageView, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExO));
      bg(this.adzd, 8);
      bg(this.adze, 0);
      bg(this.adzi, 0);
      bg(this.adzl, 8);
      bg(this.adzc, 0);
      if (!paramBoolean2) {
        break label518;
      }
      bg(this.adzp, 0);
      if (paramBoolean4) {
        break label448;
      }
      localObject = this.adzp.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = -2;
      ((ViewGroup.LayoutParams)localObject).height = -2;
      this.adzp.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.adzp.setImageResource(R.g.unread_dot_shape);
    }
    for (;;)
    {
      for (;;)
      {
        a(paramfng, paramBoolean3, paramBoolean5);
        AppMethodBeat.o(249511);
        return;
        localObject = this.adzi.getLayoutParams();
        f = this.adzi.getContext().getResources().getDimension(R.f.Edge_2_5_A);
        ((ViewGroup.LayoutParams)localObject).width = ((int)f);
        ((ViewGroup.LayoutParams)localObject).height = ((int)f);
        this.adzi.setLayoutParams((ViewGroup.LayoutParams)localObject);
        break;
        try
        {
          label375:
          localObject = BackwardSupportUtil.BitmapFactory.decodeStream(this.mContext.getAssets().open("avatar/default_nor_avatar.png"), a.getDensity(null));
          this.adzi.setImageBitmap((Bitmap)localObject);
          Log.w("FinderIconViewTipPreference", "[bindSingleSquareAvatarTask] tipsInfo.url is null.");
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            Log.w("FinderIconViewTipPreference", "[bindSingleSquareAvatarTask] e:" + localIOException.toString());
          }
        }
      }
      label448:
      ViewGroup.LayoutParams localLayoutParams = this.adzl.getLayoutParams();
      int i = (int)(com.tencent.mm.view.d.e(this.adzl.getContext(), 11.1F) * a.getScaleSize(this.mContext));
      localLayoutParams.width = i;
      localLayoutParams.height = i;
      this.adzp.setLayoutParams(localLayoutParams);
      this.adzp.setImageResource(R.k.finder_live_icon);
      continue;
      label518:
      bg(this.adzp, 8);
    }
  }
  
  private void a(boolean paramBoolean1, fng paramfng, boolean paramBoolean2)
  {
    AppMethodBeat.i(369626);
    aeD(8);
    aBf(8);
    aBi(8);
    afx(8);
    bg(this.akme, 8);
    LF(false);
    if (paramBoolean1) {
      c(paramfng, true, paramBoolean2);
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(369626);
      return;
      bg(this.adzc, 8);
    }
  }
  
  private void a(boolean paramBoolean1, fng paramfng, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, Boolean paramBoolean5, Boolean paramBoolean6, boolean paramBoolean7)
  {
    AppMethodBeat.i(249564);
    aeD(8);
    aBf(8);
    aBi(8);
    afx(8);
    LF(false);
    bg(this.adzn, 8);
    bg(this.adzs, 8);
    if (paramBoolean1) {
      a(paramfng, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5.booleanValue(), paramBoolean6, paramBoolean7);
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(249564);
      return;
      bg(this.adzc, 8);
    }
  }
  
  private void a(boolean paramBoolean1, fng paramfng, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    AppMethodBeat.i(249568);
    aeD(8);
    aBf(8);
    aBi(8);
    afx(8);
    LF(false);
    bg(this.adzn, 8);
    bg(this.adzE, 8);
    if (paramBoolean1) {
      a(paramfng, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5);
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(249568);
      return;
      bg(this.adzc, 8);
    }
  }
  
  private void a(boolean paramBoolean1, fng paramfng, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    AppMethodBeat.i(249566);
    aeD(8);
    aBf(8);
    aBi(8);
    afx(8);
    LF(false);
    bg(this.adzn, 8);
    bg(this.akme, 8);
    bg(this.adzs, 8);
    if (paramBoolean1) {
      a(paramfng, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5, paramBoolean6);
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(249566);
      return;
      bg(this.adzc, 8);
    }
  }
  
  private boolean a(int paramInt, fng paramfng)
  {
    AppMethodBeat.i(249494);
    if (((paramInt == 6) || (paramInt == 7)) && (paramfng != null) && (getDropStat() == 2))
    {
      AppMethodBeat.o(249494);
      return true;
    }
    AppMethodBeat.o(249494);
    return false;
  }
  
  private boolean azX(int paramInt)
  {
    AppMethodBeat.i(249485);
    Log.i("FinderIconViewTipPreference", "initWidgetFrame mWidgetFrame:" + this.adzc);
    Object localObject = (ViewGroup)jnk();
    jiD();
    if (localObject == null)
    {
      Log.i("FinderIconViewTipPreference", "[initWidgetFrame] fail,WidgetFrame has child!");
      AppMethodBeat.o(249485);
      return false;
    }
    this.adzc = ((ViewGroup)localObject);
    if ((paramInt == 2) || (paramInt == 5) || (paramInt == 1) || (paramInt == 4) || (paramInt == 6) || (paramInt == 7) || (paramInt == 10) || (paramInt == 11) || (paramInt == 12) || (paramInt == 14))
    {
      localObject = this.adzc;
      if ((((ViewGroup)localObject).getChildCount() != 1) || (!"singleAvatar".equals(((ViewGroup)localObject).getChildAt(0).getTag())))
      {
        ((ViewGroup)localObject).removeAllViews();
        View.inflate(this.mContext, R.i.gmf, (ViewGroup)localObject).findViewById(R.h.fIi).setTag("singleAvatar");
      }
      this.adzd = ((ViewGroup)localObject).findViewById(R.h.friend_avatar_1_layout);
      this.adze = ((ViewGroup)localObject).findViewById(R.h.fIQ);
      this.adzh = ((ImageView)((ViewGroup)localObject).findViewById(R.h.friend_avatar_1));
      this.adzi = ((ImageView)((ViewGroup)localObject).findViewById(R.h.friend_square_avatar_1));
      this.adzl = ((ImageView)((ViewGroup)localObject).findViewById(R.h.right_prospect));
      aBj(8);
      this.adzp = ((ImageView)((ViewGroup)localObject).findViewById(R.h.right_square_prospect));
      this.xum = ((TextView)((ViewGroup)localObject).findViewById(R.h.right_title));
      this.xul = ((TextView)((ViewGroup)localObject).findViewById(R.h.fMJ));
      this.adzm = ((ImageView)((ViewGroup)localObject).findViewById(R.h.fRA));
      this.adzn = ((WeImageView)((ViewGroup)localObject).findViewById(R.h.fVa));
      this.adzo = ((LinearLayout)((ViewGroup)localObject).findViewById(R.h.fUZ));
      this.adzE = ((RelativeLayout)((ViewGroup)localObject).findViewById(R.h.avatar_container));
      this.adzs = ((ViewGroup)localObject).findViewById(R.h.fOO);
      this.adzt = ((ImageView)((ViewGroup)localObject).findViewById(R.h.friend_square_multi_avatar_1));
      this.adzw = ((ImageView)((ViewGroup)localObject).findViewById(R.h.fUY));
      this.adzu = ((ImageView)((ViewGroup)localObject).findViewById(R.h.friend_square_multi_avatar_2));
      this.adzv = ((ImageView)((ViewGroup)localObject).findViewById(R.h.friend_square_multi_avatar_3));
      this.adzx = ((FinderRedDotTextView)((ViewGroup)localObject).findViewById(R.h.fQE));
      this.akme = ((TextView)((ViewGroup)localObject).findViewById(R.h.dYB));
    }
    for (;;)
    {
      AppMethodBeat.o(249485);
      return true;
      if (paramInt == 3)
      {
        localObject = this.adzc;
        ((ViewGroup)localObject).removeAllViews();
        localObject = View.inflate(this.mContext, R.i.gme, (ViewGroup)localObject);
        this.adzd = ((View)localObject).findViewById(R.h.friend_avatar_1_layout);
        this.adzf = ((View)localObject).findViewById(R.h.friend_avatar_2_layout);
        this.adzg = ((View)localObject).findViewById(R.h.friend_avatar_3_layout);
        this.adzq = new ArrayList(3);
        this.adzq.add(this.adzd);
        this.adzq.add(this.adzf);
        this.adzq.add(this.adzg);
        this.adzh = ((ImageView)((View)localObject).findViewById(R.h.friend_avatar_1));
        this.adzj = ((ImageView)((View)localObject).findViewById(R.h.friend_avatar_2));
        this.adzk = ((ImageView)((View)localObject).findViewById(R.h.friend_avatar_3));
        this.adzr = new ArrayList(3);
        this.adzr.add(this.adzh);
        this.adzr.add(this.adzj);
        this.adzr.add(this.adzk);
        this.adzl = ((ImageView)((View)localObject).findViewById(R.h.right_prospect));
      }
    }
  }
  
  private void azY(int paramInt)
  {
    AppMethodBeat.i(249582);
    while (paramInt < 3)
    {
      ImageView localImageView = azZ(paramInt);
      if (localImageView != null) {
        bg(localImageView, 8);
      }
      paramInt += 1;
    }
    AppMethodBeat.o(249582);
  }
  
  private ImageView azZ(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return this.adzt;
    case 1: 
      return this.adzu;
    }
    return this.adzv;
  }
  
  private int b(fng paramfng, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 3;
    AppMethodBeat.i(249526);
    Resources localResources = this.xul.getResources();
    int k = 0;
    int i = paramfng.hrh.size();
    if (i > 3) {}
    for (;;)
    {
      i = k;
      if (paramBoolean1) {
        if (j > 0)
        {
          k = (int)(localResources.getDimension(R.f.Edge_4_5_A) * j);
          i = k;
          if (j <= 1) {
            break label275;
          }
          i = k - (int)localResources.getDimension(R.f.Edge_0_5_A);
        }
      }
      label275:
      for (;;)
      {
        paramfng = at.GiI;
        int n = at.getScreenWidth();
        paramfng = (TextView)this.lBX.findViewById(16908310);
        int i1 = (int)paramfng.getPaint().measureText(getTitle().toString());
        k = (int)localResources.getDimension(R.f.Edge_16A);
        if (i <= 0)
        {
          j = i;
          if (!paramBoolean2) {}
        }
        else
        {
          int m = (int)localResources.getDimension(R.f.Edge_17A);
          j = i;
          k = m;
          if (paramBoolean2)
          {
            j = (int)localResources.getDimension(R.f.Edge_A);
            k = m;
          }
        }
        i = n - k - i1 - j;
        Log.i("FinderIconViewTipPreference", "getNewLeftTitleMaxWidth availableWidth :" + i + " titleTv:" + paramfng);
        AppMethodBeat.o(249526);
        return i;
        i = k;
        if (!TextUtils.isEmpty(paramfng.url)) {
          i = (int)localResources.getDimension(R.f.Edge_4_5_A);
        }
      }
      j = i;
    }
  }
  
  private void bg(View paramView, int paramInt)
  {
    AppMethodBeat.i(249496);
    if ((paramView != null) && (paramView.getVisibility() != paramInt)) {
      paramView.setVisibility(paramInt);
    }
    if ((paramView != null) && (paramView == this.adzc) && (paramInt == 8)) {
      KZ(true);
    }
    AppMethodBeat.o(249496);
  }
  
  private static int bzG(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(249520);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(249520);
      return 0;
    }
    String str = paramString;
    if (!paramString.startsWith("#")) {
      str = "#".concat(String.valueOf(paramString));
    }
    for (;;)
    {
      try
      {
        if (str.length() != 9) {
          continue;
        }
        j = Color.parseColor(str.charAt(0) + str.substring(7, 9) + str.substring(1, 7));
        i = j;
      }
      catch (Exception paramString)
      {
        int j;
        Log.printErrStackTrace("FinderIconViewTipPreference", paramString, "getColor", new Object[0]);
        continue;
      }
      Log.i("FinderIconViewTipPreference", "getColor  color:" + str + " colorInt:" + i);
      AppMethodBeat.o(249520);
      return i;
      j = Color.parseColor(str);
      i = j;
    }
  }
  
  private void c(fng paramfng, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = true;
    int j = 0;
    AppMethodBeat.i(369623);
    Object localObject1;
    if (paramBoolean1)
    {
      if (this.xul != null)
      {
        this.xul.setMaxLines(2);
        localObject1 = at.GiI;
        i = (int)(at.getScreenWidth() * 0.4D);
        this.xul.setMaxWidth(i);
      }
      bg(this.xul, 8);
      bg(this.adzx, 0);
      bg(this.adzm, 8);
      bg(this.xum, 8);
      bg(this.adzn, 8);
      bg(this.adzE, 8);
      bg(this.adzs, 8);
      bg(this.akme, 8);
      if (this.adzx == null) {
        break label570;
      }
      if ((!TextUtils.isEmpty(paramfng.abNo)) || (!TextUtils.isEmpty(paramfng.abNq))) {
        break label415;
      }
      if (paramBoolean2) {
        bg(this.adzm, 0);
      }
      if (this.adzx == null) {
        break label570;
      }
      localObject1 = this.adzx;
      if (TextUtils.isEmpty(paramfng.akls)) {
        break label409;
      }
    }
    label409:
    for (int i = 1;; i = 0)
    {
      Resources localResources = this.xul.getResources();
      Object localObject2 = at.GiI;
      int k = at.getScreenWidth();
      localObject2 = (TextView)this.lBX.findViewById(16908310);
      int m = (int)localResources.getDimension(R.f.Edge_A);
      int n = (int)((TextView)localObject2).getPaint().measureText(getTitle().toString());
      int i1 = (int)localResources.getDimension(R.f.Edge_17A);
      if (i != 0) {
        j = (int)(this.akme.getPaint().measureText(paramfng.akls) + this.mContext.getResources().getDimension(R.f.finder_1_25_A));
      }
      i = k - i1 - n - m - j;
      Log.i("FinderIconViewTipPreference", "getNewLeftTitleMaxWidth availableWidth:".concat(String.valueOf(i)));
      ((FinderRedDotTextView)localObject1).a(i, paramfng.title, "", R.f.SmallestTextSize, bzG(paramfng.abNp), "");
      AppMethodBeat.o(369623);
      return;
      this.xul.setMaxLines(1);
      localObject1 = at.GiI;
      i = at.getScreenWidth();
      this.xul.setMaxWidth(i);
      break;
    }
    label415:
    if (this.adzx != null)
    {
      this.adzx.a(b(paramfng, false, true), paramfng.title, paramfng.abNo, R.f.SmallestTextSize, bzG(paramfng.abNp), paramfng.abNq);
      if ((this.adzx == null) || (this.adzx.getDropStat() != 1) || (!c(paramfng))) {
        break label577;
      }
      paramfng.abNo = "";
      paramfng.abNq = "";
      c(paramfng, paramBoolean1, true);
    }
    label570:
    label577:
    for (paramBoolean1 = bool;; paramBoolean1 = false)
    {
      Log.i("FinderIconViewTipPreference", "getDropStat:" + getDropStat() + " checkResult:" + paramBoolean1);
      if (!paramBoolean1)
      {
        paramfng = (ViewGroup.MarginLayoutParams)this.adzx.getLayoutParams();
        paramfng.setMarginEnd(0);
        this.adzx.setLayoutParams(paramfng);
      }
      AppMethodBeat.o(369623);
      return;
    }
  }
  
  private static boolean c(fng paramfng)
  {
    AppMethodBeat.i(249556);
    if ((paramfng != null) && ((!TextUtils.isEmpty(paramfng.abNo)) || (!TextUtils.isEmpty(paramfng.abNq))))
    {
      AppMethodBeat.o(249556);
      return true;
    }
    AppMethodBeat.o(249556);
    return false;
  }
  
  private void d(fng paramfng)
  {
    AppMethodBeat.i(249560);
    paramfng = paramfng.hrh;
    int i = paramfng.size();
    Log.i("FinderIconViewTipPreference", "url size = ".concat(String.valueOf(i)));
    int j = Math.min(i, 3);
    i = 0;
    for (;;)
    {
      int k;
      if (j > 0)
      {
        j -= 1;
        View localView = (View)this.adzq.get(j);
        ImageView localImageView = (ImageView)this.adzr.get(j);
        Object localObject = com.tencent.mm.plugin.finder.loader.p.ExI;
        localObject = com.tencent.mm.plugin.finder.loader.p.eCp();
        k = i + 1;
        com.tencent.mm.plugin.finder.loader.b localb = new com.tencent.mm.plugin.finder.loader.b((String)paramfng.get(i), com.tencent.mm.plugin.finder.storage.v.FLF);
        com.tencent.mm.plugin.finder.loader.p localp = com.tencent.mm.plugin.finder.loader.p.ExI;
        ((com.tencent.mm.loader.d)localObject).a(localb, localImageView, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExM));
        if (localView != null)
        {
          localView.setVisibility(0);
          i = k;
        }
      }
      else
      {
        AppMethodBeat.o(249560);
        return;
      }
      i = k;
    }
  }
  
  private void e(fng paramfng)
  {
    AppMethodBeat.i(249575);
    azY(1);
    a(paramfng, 1);
    if (!c(paramfng)) {
      bg(this.adzw, 0);
    }
    AppMethodBeat.o(249575);
  }
  
  private void e(boolean paramBoolean, fng paramfng)
  {
    AppMethodBeat.i(249598);
    aeD(8);
    aBf(8);
    aBi(8);
    afx(8);
    LF(false);
    bg(this.akme, 8);
    if (paramBoolean) {
      c(paramfng, false, true);
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(249598);
      return;
      bg(this.adzc, 8);
    }
  }
  
  private void f(boolean paramBoolean, fng paramfng)
  {
    AppMethodBeat.i(369622);
    aeD(8);
    aBf(8);
    aBi(8);
    afx(8);
    LF(false);
    if ((this.akme != null) && (paramBoolean) && (!Util.isNullOrNil(paramfng.akls)))
    {
      aw.a(this.akme.getPaint(), 0.8F);
      this.akme.setText(paramfng.akls);
      this.akme.setBackgroundResource(b.b.new_tips_bg);
      bg(this.akme, 0);
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(369622);
      return;
      bg(this.akme, 8);
    }
  }
  
  private void g(boolean paramBoolean, fng paramfng)
  {
    AppMethodBeat.i(249608);
    Log.d("FinderIconViewTipPreference", "bindAvatars() show:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      if ((paramfng != null) && (paramfng.hrh != null) && (paramfng.hrh.size() > 0) && (jiF()))
      {
        aeD(8);
        aBi(8);
        aBh(8);
        aBj(8);
        LF(false);
        jiE();
        d(paramfng);
        bg(this.adzl, 0);
        bg(this.adzs, 8);
        bg(this.adzc, 0);
      }
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(249608);
      return;
      aeD(8);
      aBf(8);
      aBi(8);
      afx(8);
      bg(this.adzc, 8);
    }
  }
  
  private boolean g(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(249533);
    TextView localTextView = this.xul;
    if (paramBoolean) {
      localTextView = this.xum;
    }
    for (;;)
    {
      Object localObject = at.GiI;
      int j = at.getScreenWidth();
      localObject = this.xul.getResources();
      int k = (int)((TextView)this.lBX.findViewById(16908310)).getPaint().measureText(getTitle().toString());
      int i = (int)((Resources)localObject).getDimension(R.f.Edge_16A);
      if (paramBoolean) {
        i = (int)((Resources)localObject).getDimension(R.f.finder_16_5_A);
      }
      i = j - i - k;
      paramInt = (int)(((Resources)localObject).getDimension(R.f.Edge_4_5_A) * paramInt);
      paramBoolean = false;
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = TextUtils.ellipsize(paramString, localTextView.getPaint(), i - paramInt, TextUtils.TruncateAt.END).toString();
        if ((paramString.endsWith("…")) || (TextUtils.isEmpty(paramString))) {
          paramBoolean = true;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(249533);
        return paramBoolean;
        if (paramInt > i) {
          paramBoolean = true;
        }
      }
    }
  }
  
  private void jiD()
  {
    AppMethodBeat.i(249488);
    Log.i("FinderIconViewTipPreference", "initContentLayoutParam mThirdLayoutContainer：" + this.adzH);
    if (this.lBX != null)
    {
      if (this.adzK == null) {
        this.adzK = ((LinearLayout.LayoutParams)((ViewGroup)this.lBX.findViewById(a.g.content)).getLayoutParams());
      }
      if (this.adzL == null) {
        this.adzL = new LinearLayout.LayoutParams(-2, this.adzK.height, 0.0F);
      }
      if (this.adzI == null) {
        this.adzI = ((LinearLayout.LayoutParams)this.adzG.getLayoutParams());
      }
      if (this.adzJ == null) {
        this.adzJ = new LinearLayout.LayoutParams(-1, -1, 0.0F);
      }
    }
    AppMethodBeat.o(249488);
  }
  
  private void jiE()
  {
    AppMethodBeat.i(249498);
    if (this.adzq == null)
    {
      AppMethodBeat.o(249498);
      return;
    }
    int j = this.adzq.size();
    int i = 0;
    while (i < j)
    {
      View localView = (View)this.adzq.get(i);
      if ((localView != null) && (localView.getVisibility() == 0)) {
        localView.setVisibility(8);
      }
      i += 1;
    }
    AppMethodBeat.o(249498);
  }
  
  private boolean jiF()
  {
    AppMethodBeat.i(249501);
    if ((this.adzq == null) || (this.adzr == null))
    {
      Log.i("FinderIconViewTipPreference", "friend avatar is null");
      AppMethodBeat.o(249501);
      return false;
    }
    int i = this.adzq.size();
    int j = this.adzr.size();
    if ((i != 3) || (i != j))
    {
      Log.i("FinderIconViewTipPreference", "friend avatar size illegal");
      AppMethodBeat.o(249501);
      return false;
    }
    AppMethodBeat.o(249501);
    return true;
  }
  
  private void jiG()
  {
    AppMethodBeat.i(249612);
    bg(this.adzc, 8);
    AppMethodBeat.o(249612);
  }
  
  private static boolean jiH()
  {
    AppMethodBeat.i(249615);
    String str = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
    Log.i("FinderIconViewTipPreference", "language :".concat(String.valueOf(str)));
    com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
    int i = ((Integer)com.tencent.mm.plugin.finder.storage.d.eUA().bmg()).intValue();
    Log.i("FinderIconViewTipPreference", "isZh language:" + str + " testValue:" + i);
    if (((!TextUtils.isEmpty(str)) && (str.startsWith("zh"))) || (i == 1))
    {
      AppMethodBeat.o(249615);
      return true;
    }
    AppMethodBeat.o(249615);
    return false;
  }
  
  private boolean jiI()
  {
    AppMethodBeat.i(249616);
    boolean bool = "find_friends_by_finder".equals(this.mKey);
    AppMethodBeat.o(249616);
    return bool;
  }
  
  private void p(String paramString, ImageView paramImageView)
  {
    AppMethodBeat.i(249591);
    if (!Util.isNullOrNil(paramString))
    {
      Log.i("FinderIconViewTipPreference", "[setWxAvatar] set=%s", new Object[] { paramString });
      Object localObject = com.tencent.mm.plugin.finder.loader.p.ExI;
      localObject = com.tencent.mm.plugin.finder.loader.p.eCq();
      paramString = new com.tencent.mm.plugin.finder.loader.b(paramString, com.tencent.mm.plugin.finder.storage.v.FLF);
      com.tencent.mm.plugin.finder.loader.p localp = com.tencent.mm.plugin.finder.loader.p.ExI;
      ((com.tencent.mm.loader.d)localObject).a(paramString, paramImageView, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExO));
      AppMethodBeat.o(249591);
      return;
    }
    try
    {
      paramImageView.setImageBitmap(BackwardSupportUtil.BitmapFactory.decodeStream(this.mContext.getAssets().open("avatar/default_nor_avatar.png"), a.getDensity(null)));
      Log.w("FinderIconViewTipPreference", "[setWxAvatar] url is null.");
      AppMethodBeat.o(249591);
      return;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        Log.w("FinderIconViewTipPreference", "[setWxAvatar] e:" + paramString.toString());
      }
    }
  }
  
  private void q(String paramString, ImageView paramImageView)
  {
    AppMethodBeat.i(249596);
    if (!Util.isNullOrNil(paramString))
    {
      Log.i("FinderIconViewTipPreference", "[setOvalAvatar] load=%s", new Object[] { paramString });
      Object localObject = com.tencent.mm.plugin.finder.loader.p.ExI;
      localObject = com.tencent.mm.plugin.finder.loader.p.eCp();
      paramString = new com.tencent.mm.plugin.finder.loader.b(paramString, com.tencent.mm.plugin.finder.storage.v.FLF);
      com.tencent.mm.plugin.finder.loader.p localp = com.tencent.mm.plugin.finder.loader.p.ExI;
      ((com.tencent.mm.loader.d)localObject).a(paramString, paramImageView, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExM));
      paramImageView.setVisibility(0);
      AppMethodBeat.o(249596);
      return;
    }
    try
    {
      paramImageView.setImageBitmap(BackwardSupportUtil.BitmapFactory.decodeStream(this.mContext.getAssets().open("avatar/default_nor_avatar.png"), a.getDensity(null)));
      Log.w("FinderIconViewTipPreference", "[setOvalAvatar] tipsInfo.url is null.");
      AppMethodBeat.o(249596);
      return;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        Log.w("FinderIconViewTipPreference", "[setOvalAvatar] e:" + paramString.toString());
      }
    }
  }
  
  public final void a(boolean paramBoolean1, fng paramfng, int paramInt, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    AppMethodBeat.i(249629);
    Log.i("FinderIconViewTipPreference", "[showFinderAvatars] show=%s title=%s url=%s style=%s withRedDot=%s isRightTitle=%s isLiveRedDot=%s mThirdLayoutContainer:%s subTitle:%s, subIcon:%s", new Object[] { Boolean.valueOf(paramBoolean1), paramfng.title, paramfng.url, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3), Boolean.valueOf(paramBoolean4), this.adzH, paramfng.abNo, paramfng.abNp });
    if (!azX(paramInt))
    {
      Log.w("FinderIconViewTipPreference", "showFinderAvatars return for initWidgetFrame");
      AppMethodBeat.o(249629);
      return;
    }
    if ((jiH()) && (c(paramfng)) && (paramBoolean2)) {}
    for (boolean bool = false;; bool = paramBoolean2)
    {
      this.adzy = paramBoolean1;
      this.adzz = paramfng;
      this.mStyle = paramInt;
      this.adzA = bool;
      this.adzB = paramBoolean3;
      this.adzC = paramBoolean4;
      this.adzD = paramBoolean5;
      bg(this.akme, 8);
      if (paramInt == 1)
      {
        KZ(false);
        a(paramBoolean1, paramfng, false, bool, paramBoolean3, Boolean.valueOf(paramBoolean4), Boolean.FALSE, paramBoolean5);
        if ((!paramBoolean2) || ((c(paramfng)) && (jiH()))) {
          break label644;
        }
      }
      label644:
      for (paramBoolean1 = true;; paramBoolean1 = false)
      {
        this.adzA = paramBoolean1;
        if (!this.adzA)
        {
          bg(this.adzl, 8);
          aBj(8);
        }
        Log.i("FinderIconViewTipPreference", "showFinderAvatars mWithRedDot:%s  withRedDot:%s", new Object[] { Boolean.valueOf(this.adzA), Boolean.valueOf(bool) });
        if (!a(paramInt, paramfng)) {
          break label649;
        }
        Log.w("FinderIconViewTipPreference", "showFinderAvatars return for checkIsDrop");
        com.tencent.mm.plugin.finder.extension.reddot.p localp = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().Su("FinderEntrance");
        if (localp != null)
        {
          z localz = z.FrZ;
          z.a("FinderEntrance", localp.field_ctrInfo, paramfng.title, localp.eav().object_id, localp.eav().report_ext_info);
        }
        AppMethodBeat.o(249629);
        return;
        if (paramInt == 2)
        {
          KZ(false);
          a(paramBoolean1, paramfng, false, bool, paramBoolean3, paramBoolean4, paramBoolean5);
          break;
        }
        if (paramInt == 4)
        {
          KZ(false);
          a(paramBoolean1, paramfng, true, bool, paramBoolean3, Boolean.valueOf(paramBoolean4), Boolean.FALSE, paramBoolean5);
          break;
        }
        if (paramInt == 5)
        {
          KZ(false);
          a(paramBoolean1, paramfng, true, bool, paramBoolean3, paramBoolean4, paramBoolean5);
          break;
        }
        if (paramInt == 3)
        {
          KZ(false);
          g(paramBoolean1, paramfng);
          break;
        }
        if (paramInt == 6)
        {
          KZ(false);
          e(paramBoolean1, paramfng);
          break;
        }
        if (paramInt == 7)
        {
          KZ(false);
          a(paramBoolean1, paramfng, true);
          break;
        }
        if (paramInt == 10)
        {
          KZ(false);
          a(paramBoolean1, paramfng, true, bool, paramBoolean3, Boolean.valueOf(paramBoolean4), Boolean.TRUE, paramBoolean5);
          break;
        }
        if ((paramInt >= 11) && (paramInt <= 12))
        {
          KZ(false);
          if (paramInt == 11) {}
          for (paramBoolean4 = true;; paramBoolean4 = false)
          {
            a(paramBoolean1, paramfng, bool, paramBoolean3, paramBoolean5, paramBoolean4);
            break;
          }
        }
        if (paramInt != 14) {
          break;
        }
        KZ(false);
        a(paramBoolean1, paramfng, false);
        f(paramBoolean1, paramfng);
        break;
      }
      label649:
      AppMethodBeat.o(249629);
      return;
    }
  }
  
  public final boolean a(boolean paramBoolean, fng paramfng)
  {
    AppMethodBeat.i(249639);
    jiG();
    this.mStyle = 8;
    paramBoolean = super.a(paramBoolean, paramfng);
    AppMethodBeat.o(249639);
    return paramBoolean;
  }
  
  public final boolean d(boolean paramBoolean, fng paramfng)
  {
    AppMethodBeat.i(249642);
    jiG();
    Log.d("FinderIconViewTipPreference", "showCounter() show:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      afx(0);
      String str = paramfng.num;
      if (paramfng.num > 999) {
        str = "· · ·";
      }
      iO(str, com.tencent.mm.ui.tools.v.bC(this.mContext, paramfng.num));
    }
    for (;;)
    {
      this.adzy = paramBoolean;
      this.mStyle = 9;
      this.adzz = paramfng;
      notifyDataSetChanged();
      AppMethodBeat.o(249642);
      return true;
      aeD(8);
      aBf(8);
      aBi(8);
      afx(8);
    }
  }
  
  public final int getDropStat()
  {
    AppMethodBeat.i(249631);
    if ((this.adzx != null) && (this.adzx.getVisibility() == 0))
    {
      int i = this.adzx.getDropStat();
      AppMethodBeat.o(249631);
      return i;
    }
    AppMethodBeat.o(249631);
    return 0;
  }
  
  public final View getRootView()
  {
    return this.lBX;
  }
  
  public final int getRowCount()
  {
    AppMethodBeat.i(249634);
    if ((this.adzx != null) && (this.adzx.getVisibility() == 0))
    {
      int i = this.adzx.getRowCount();
      AppMethodBeat.o(249634);
      return i;
    }
    AppMethodBeat.o(249634);
    return 1;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(249622);
    super.onBindView(paramView);
    Log.i("FinderIconViewTipPreference", "onBindView title:" + getTitle() + " hashCode:" + hashCode() + " view:" + paramView);
    this.lBX = paramView;
    if (this.lBX != null)
    {
      this.adzF = ((WeImageView)this.lBX.findViewById(R.h.right_arrow_only));
      this.adzG = ((LinearLayout)this.lBX.findViewById(R.h.second_level_container));
      this.adzH = ((RelativeLayout)this.lBX.findViewById(R.h.third_level_container));
      jiD();
      Log.i("FinderIconViewTipPreference", "onBindView mStyle:" + this.mStyle + " mTipsInfo:" + this.adzz);
      if (this.adzz != null)
      {
        if (this.mStyle == 9)
        {
          d(this.adzy, this.adzz);
          AppMethodBeat.o(249622);
          return;
        }
        if (((this.mStyle > 0) && (this.mStyle <= 7)) || (this.mStyle == 10) || ((this.mStyle >= 11) && (this.mStyle < 12)) || (this.mStyle == 14)) {
          a(this.adzy, this.adzz, this.mStyle, this.adzA, this.adzB, this.adzC, this.adzD);
        }
      }
    }
    AppMethodBeat.o(249622);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(249617);
    paramViewGroup = super.onCreateView(paramViewGroup);
    Log.i("FinderIconViewTipPreference", "onCreateView title:" + getTitle() + " hashCode:" + hashCode() + " view:" + paramViewGroup);
    AppMethodBeat.o(249617);
    return paramViewGroup;
  }
  
  public final boolean yn(boolean paramBoolean)
  {
    AppMethodBeat.i(249636);
    if (paramBoolean) {
      jiG();
    }
    for (;;)
    {
      this.mStyle = 8;
      paramBoolean = super.yn(paramBoolean);
      AppMethodBeat.o(249636);
      return paramBoolean;
      KZ(true);
    }
  }
  
  public final boolean yo(boolean paramBoolean)
  {
    AppMethodBeat.i(249644);
    jiG();
    this.mStyle = 8;
    if (paramBoolean) {
      aeD(4);
    }
    paramBoolean = super.yo(paramBoolean);
    AppMethodBeat.o(249644);
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.FinderIconViewTipPreference
 * JD-Core Version:    0.7.0.1
 */