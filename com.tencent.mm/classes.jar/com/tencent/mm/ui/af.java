package com.tencent.mm.ui;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.ViewStub;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.f;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.cd.a;
import com.tencent.mm.ce.b;
import com.tencent.mm.kiss.widget.textview.StaticTextView;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.MMVerticalTextView;
import com.tencent.mm.ui.widget.MMCollapsibleTextView;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.imageview.WeImageButton;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.neattextview.textview.view.NeatTextView;

public final class af
{
  public static final int[] adFA = { 16843379 };
  public static final int[] adFB = { 16842904, 16842906, 16842964 };
  public static final int[] adFC = { 16842904, 16842964 };
  public static final int[] adFD = { 16842904, 16843015 };
  public static final int[] adFz = { 16843087, 16843088, 16843379 };
  
  public static LayoutInflater a(LayoutInflater paramLayoutInflater, Context paramContext)
  {
    AppMethodBeat.i(249696);
    a.getScaleSize(paramContext);
    paramContext = paramLayoutInflater.cloneInContext(paramContext);
    paramLayoutInflater = new a();
    paramLayoutInflater.dvH = paramContext;
    paramContext.setFactory(paramLayoutInflater);
    paramContext = new af.b(paramContext, paramContext.getContext());
    a locala = new a();
    locala.dvH = paramContext;
    locala.adFF = paramLayoutInflater;
    paramContext.setFactory(locala);
    paramContext.adGC = locala;
    AppMethodBeat.o(249696);
    return paramContext;
  }
  
  public static LayoutInflater b(LayoutInflater paramLayoutInflater)
  {
    AppMethodBeat.i(141465);
    a.getScaleSize(paramLayoutInflater.getContext());
    Object localObject = paramLayoutInflater.cloneInContext(paramLayoutInflater.getContext());
    paramLayoutInflater = new a();
    paramLayoutInflater.dvH = ((LayoutInflater)localObject);
    ((LayoutInflater)localObject).setFactory(paramLayoutInflater);
    localObject = new af.b((LayoutInflater)localObject, ((LayoutInflater)localObject).getContext());
    a locala = new a();
    locala.dvH = ((LayoutInflater)localObject);
    locala.adFF = paramLayoutInflater;
    ((af.b)localObject).setFactory(locala);
    ((af.b)localObject).adGC = locala;
    AppMethodBeat.o(141465);
    return localObject;
  }
  
  public static void c(LayoutInflater paramLayoutInflater)
  {
    AppMethodBeat.i(249698);
    a.getScaleSize(paramLayoutInflater.getContext());
    a locala = new a();
    locala.dvH = paramLayoutInflater;
    paramLayoutInflater.setFactory(locala);
    AppMethodBeat.o(249698);
  }
  
  public static LayoutInflater mU(Context paramContext)
  {
    AppMethodBeat.i(141466);
    a.getScaleSize(paramContext);
    Object localObject = LayoutInflater.from(paramContext).cloneInContext(paramContext);
    paramContext = new a();
    paramContext.dvH = ((LayoutInflater)localObject);
    ((LayoutInflater)localObject).setFactory(paramContext);
    localObject = new af.b((LayoutInflater)localObject, ((LayoutInflater)localObject).getContext());
    a locala = new a();
    locala.dvH = ((LayoutInflater)localObject);
    locala.adFF = paramContext;
    ((af.b)localObject).setFactory(locala);
    ((af.b)localObject).adGC = locala;
    AppMethodBeat.o(141466);
    return localObject;
  }
  
  static final class a
    implements LayoutInflater.Factory
  {
    private static final int MMEditText;
    private static final int MMTextView;
    private static final int aWE;
    private static final int aWH;
    private static final int adFG;
    private static final int adFH;
    private static final int adFI;
    private static final int adFJ;
    private static final int adFK;
    private static final int adFL;
    private static final int adFM;
    private static final int adFN;
    private static final int adFO;
    private static final int adFP;
    private static final int adFQ;
    private static final int adFR;
    private static final int adFS;
    private static final int adFT;
    private static final int adFU;
    private static final int adFV;
    private static final int adFW;
    private static final int adFX;
    private static final int adFY;
    private static final int adFZ;
    private static final int adGA;
    private static final int adGB;
    private static final int adGa;
    private static final int adGb;
    private static final int adGc;
    private static final int adGd;
    private static final int adGe;
    private static final int adGf;
    private static final int adGg;
    private static final int adGh;
    private static final int adGi;
    private static final int adGj;
    private static final int adGk;
    private static final int adGl;
    private static final int adGm;
    private static final int adGn;
    private static final int adGo;
    private static final int adGp;
    private static final int adGq;
    private static final int adGr;
    private static final int adGs;
    private static final int adGt;
    private static final int adGu;
    private static final int adGv;
    private static final int adGw;
    private static final int adGx;
    private static final int adGy;
    private static final int adGz;
    int adFE;
    a adFF;
    LayoutInflater dvH;
    
    static
    {
      AppMethodBeat.i(249943);
      adFG = "LinearLayout".hashCode();
      adFH = "FrameLayout".hashCode();
      adFI = "RelativeLayout".hashCode();
      adFJ = "ListView".hashCode();
      adFK = "View".hashCode();
      adFL = "ViewStub".hashCode();
      adFM = "WebView".hashCode();
      adFN = "ProgressBar".hashCode();
      adFO = "TextView".hashCode();
      aWE = "Button".hashCode();
      adFP = "EditText".hashCode();
      adFQ = "CheckBox".hashCode();
      aWH = "RadioButton".hashCode();
      adFR = "ImageView".hashCode();
      adFS = "CheckedTextView".hashCode();
      MMTextView = "com.tencent.mm.ui.widget.MMTextView".hashCode();
      MMEditText = "com.tencent.mm.ui.widget.MMEditText".hashCode();
      adFT = "com.tencent.mm.ui.widget.MMNeat7extView".hashCode();
      adFU = "com.tencent.mm.ui.widget.MMCollapsibleTextView".hashCode();
      adFV = "com.tencent.mm.ui.base.MMClearEditText".hashCode();
      adFW = "com.tencent.mm.plugin.account.sdk.MMImeClearEditText".hashCode();
      adFX = "com.tencent.mm.ui.widget.edittext.PasterEditText".hashCode();
      adFY = "com.tenpay.android.wechat.TenpaySecureEditText".hashCode();
      adFZ = "com.tencent.mm.ui.base.MMVisiblePasswordEditText".hashCode();
      adGa = "com.tencent.mm.ui.tools.MMTruncTextView".hashCode();
      adGb = "com.tencent.mm.plugin.brandservice.ui.base.CatalogView".hashCode();
      adGc = "com.tencent.mm.ui.tools.CustomFitTextView".hashCode();
      adGd = "com.tencent.mm.ui.tools.ActionBarSearchView$ActionBarEditText".hashCode();
      adGe = "com.tencent.mm.plugin.favorite.ui.base.FavDetailFooterView".hashCode();
      adGf = "com.tencent.mm.plugin.game.ui.GameDropdownView".hashCode();
      adGg = "com.tencent.mm.ui.ScrollAlwaysTextView".hashCode();
      adGh = "com.tencent.mm.ui.base.MMAutoSizeTextView".hashCode();
      adGi = "com.tencent.mm.ui.widget.textview.MMAutoAdjustTextView".hashCode();
      adGj = "com.tencent.mm.plugin.sns.ui.AsyncTextView".hashCode();
      adGk = "com.tencent.mm.plugin.sns.ui.SnsTextView".hashCode();
      adGl = "com.tencent.mm.plugin.sns.ui.MaskTextView".hashCode();
      adGm = "com.tencent.mm.plugin.sns.ui.SnsEditText".hashCode();
      adGn = "com.tencent.mm.kiss.widget.textview.PLSysTextView".hashCode();
      adGo = "com.tencent.mm.ui.base.EllipsizeTextView".hashCode();
      adGp = "com.tencent.mm.plugin.finder.view.EllipsizedTextView".hashCode();
      adGq = "com.tencent.mm.wallet_core.ui.WalletTextView".hashCode();
      adGr = "com.tencent.mm.ui.base.MMVerticalTextView".hashCode();
      adGs = "com.tencent.mm.plugin.sns.ad.widget.appcompat.AdAppCompatTextView".hashCode();
      adGt = "com.tencent.mm.plugin.sns.ad.widget.appcompat.AdAppCompatButton".hashCode();
      adGu = "com.tencent.mm.ui.widget.cedit.api.MMCustomEditText".hashCode();
      adGv = "com.tencent.mm.plugin.sns.ui.SnsCustomEditText".hashCode();
      adGw = "com.tencent.mm.ui.widget.cedit.api.MMFlexEditText".hashCode();
      adGx = "com.tencent.mm.ui.widget.imageview.WeImageView".hashCode();
      adGy = "com.tencent.mm.ui.widget.imageview.WeImageButton".hashCode();
      adGz = "com.tencent.mm.plugin.sns.ui.widget.SnsPostDescPreloadTextView".hashCode();
      adGA = "com.tencent.mm.plugin.finder.view.MentionEllipsizeTextView".hashCode();
      adGB = "com.tencent.mm.plugin.luckymoney.ui.FixedAlignRightLabelEditText".hashCode();
      AppMethodBeat.o(249943);
    }
    
    public a()
    {
      AppMethodBeat.i(249910);
      if (MMApplicationContext.isImeProcess()) {
        LocaleUtil.initLanguage(MMApplicationContext.getContext());
      }
      AppMethodBeat.o(249910);
    }
    
    private static View a(String paramString, View paramView, Context paramContext, AttributeSet paramAttributeSet)
    {
      AppMethodBeat.i(249933);
      int j = paramString.hashCode();
      if ((j != adFO) && (j != aWE) && (j != adFP) && (j != adFQ) && (j != aWH) && (j != adFR) && (j != adGx) && (j != adGy) && (j != adFS) && (j != MMTextView) && (j != MMEditText) && (j != adFT) && (j != adFU) && (j != adFV) && (j != adFW) && (j != adFX) && (j != adFY) && (j != adFZ) && (j != adGa) && (j != adGb) && (j != adGc) && (j != adGd) && (j != adGe) && (j != adGf) && (j != adGg) && (j != adGh) && (j != adGi) && (j != adGj) && (j != adGk) && (j != adGl) && (j != adGm) && (j != adGn) && (j != adGo) && (j != adGp) && (j != adGq) && (j != adGr) && (j != adGs) && (j != adGt) && (j != adGu) && (j != adGv) && (j != adGw) && (j != adGz) && (j != adGA) && (j != adGB))
      {
        AppMethodBeat.o(249933);
        return paramView;
      }
      int i;
      if (b.iRp())
      {
        TypedArray localTypedArray;
        int k;
        if ((paramView instanceof RadioButton))
        {
          paramString = (RadioButton)paramView;
          if (paramAttributeSet != null)
          {
            i = paramAttributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "textColor", -1);
            if (i > 0) {
              paramString.setTextColor(paramString.getContext().getResources().getColorStateList(i));
            }
            localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, af.adFD);
            i = 0;
            if (i < af.adFD.length)
            {
              k = localTypedArray.getResourceId(i, 0);
              if (k != 0)
              {
                if (af.adFD[i] != 16842904) {
                  break label504;
                }
                paramString.setTextColor(paramString.getContext().getResources().getColorStateList(k));
              }
              for (;;)
              {
                i += 1;
                break;
                label504:
                if ((af.adFD[i] == 16843015) && (b.iRp()) && (k == a.f.round_selector)) {
                  paramString.setButtonDrawable(a.f.round_selector_care);
                }
              }
            }
          }
        }
        else if ((paramView instanceof Button))
        {
          paramString = (Button)paramView;
          if (paramAttributeSet != null)
          {
            i = paramAttributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "textColor", -1);
            if (i > 0) {
              paramString.setTextColor(paramString.getContext().getResources().getColorStateList(i));
            }
            localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, af.adFC);
            i = 0;
            if (i < af.adFC.length)
            {
              k = localTypedArray.getResourceId(i, 0);
              if (k != 0)
              {
                if (af.adFC[i] != 16842904) {
                  break label666;
                }
                paramString.setTextColor(paramString.getContext().getResources().getColorStateList(k));
              }
              for (;;)
              {
                i += 1;
                break;
                label666:
                if ((af.adFC[i] == 16842964) && (b.iRp())) {
                  if (k == a.f.btn_solid_green) {
                    paramString.setBackgroundResource(a.f.btn_solid_green_care);
                  } else if ((k == a.f.btn_solid_green_small) || (k == a.f.btn_solid_dark_green_small)) {
                    paramString.setBackgroundResource(a.f.btn_solid_green_small_care);
                  } else if (k == a.f.mm_checkbox_btn) {
                    paramString.setBackgroundResource(a.f.mm_checkbox_btn_care);
                  } else if (k == a.f.mm_checkbox_btn_filled) {
                    paramString.setBackgroundResource(a.f.mm_checkbox_btn_filled_care);
                  }
                }
              }
            }
          }
        }
        else if ((paramView instanceof TextView))
        {
          paramString = (TextView)paramView;
          if (paramAttributeSet != null)
          {
            i = paramAttributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "textColor", -1);
            if (i > 0) {
              paramString.setTextColor(paramString.getContext().getResources().getColorStateList(i));
            }
            i = paramAttributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "textColorHint", -1);
            if (i > 0) {
              paramString.setHintTextColor(paramString.getContext().getResources().getColor(i));
            }
            localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, af.adFB);
            i = 0;
            if (i < af.adFB.length)
            {
              k = localTypedArray.getResourceId(i, 0);
              if (k != 0)
              {
                if (af.adFB[i] != 16842904) {
                  break label926;
                }
                paramString.setTextColor(paramString.getContext().getResources().getColorStateList(k));
              }
              for (;;)
              {
                i += 1;
                break;
                label926:
                if (af.adFB[i] == 16842906) {
                  paramString.setHintTextColor(paramString.getContext().getResources().getColorStateList(k));
                } else if ((af.adFB[i] == 16842964) && (b.iRp()) && ((k == a.f.btn_solid_green_small) || (k == a.f.btn_solid_dark_green_small))) {
                  paramString.setBackgroundResource(a.f.btn_solid_green_small_care);
                }
              }
            }
          }
        }
        else if ((paramView instanceof EditText))
        {
          paramString = (EditText)paramView;
          if (paramAttributeSet != null)
          {
            i = paramAttributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "textColor", -1);
            if (i > 0) {
              paramString.setTextColor(paramString.getContext().getResources().getColor(i));
            }
            i = paramAttributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "textColorHint", -1);
            if (i > 0) {
              paramString.setHintTextColor(paramString.getContext().getResources().getColor(i));
            }
            localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, af.adFB);
            i = 0;
            if (i < af.adFB.length)
            {
              k = localTypedArray.getResourceId(i, 0);
              if (k != 0)
              {
                if (af.adFB[i] != 16842904) {
                  break label1163;
                }
                paramString.setTextColor(paramString.getContext().getResources().getColor(k));
              }
              for (;;)
              {
                i += 1;
                break;
                label1163:
                if (af.adFB[i] == 16842906) {
                  paramString.setHintTextColor(paramString.getContext().getResources().getColorStateList(k));
                }
              }
            }
          }
        }
        else if ((paramView instanceof MMNeat7extView))
        {
          paramString = (MMNeat7extView)paramView;
          if (paramAttributeSet != null)
          {
            i = paramAttributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "textColor", -1);
            if (i > 0) {
              paramString.setTextColor(paramString.getContext().getResources().getColor(i));
            }
            localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, af.adFB);
            i = 0;
            while (i < af.adFB.length)
            {
              k = localTypedArray.getResourceId(i, 0);
              if ((k != 0) && (af.adFB[i] == 16842904)) {
                paramString.setTextColor(paramString.getContext().getResources().getColor(k));
              }
              i += 1;
            }
          }
        }
      }
      float f1;
      float f2;
      if ((paramView instanceof TextView))
      {
        paramString = (TextView)paramView;
        f1 = paramString.getLineSpacingMultiplier();
        f2 = paramString.getLineSpacingExtra();
        if ((f1 < 1.1D) && (f2 == 0.0F)) {
          paramString.setLineSpacing(0.0F, 1.1F);
        }
        f1 = a.getScaleSize(paramContext);
        if (((!aw.bc(f1, a.mi(paramContext))) && (!aw.bc(f1, a.mj(paramContext)))) || (j == MMTextView) || (j == adGj) || (j == adGk) || (j == adGl) || (j == adFT) || (j == adGu) || (j == adGv) || (j == adGw) || (j == adFU)) {
          break label3115;
        }
        f1 = a.mh(paramContext);
      }
      label1932:
      label2590:
      label3115:
      for (;;)
      {
        if ((j == adFO) || (j == MMTextView) || (j == adGq) || (j == adGi) || (j == adGs))
        {
          paramString = (TextView)paramView;
          f1 = f1 * paramString.getTextSize() / a.getDensity(paramString.getContext());
          paramString.setTextSize(1, f1);
          if (j == adGs) {
            androidx.core.widget.j.b(paramString, (int)f1);
          }
          paramContext.getAssets();
          com.tencent.mm.ce.j.iRR();
          if (com.tencent.mm.ce.j.iRS())
          {
            paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, af.adFz);
            i = 0;
            label1588:
            if (i < af.adFz.length)
            {
              j = paramAttributeSet.getResourceId(i, 0);
              if (j != 0)
              {
                if (af.adFz[i] != 16843379) {
                  break label1734;
                }
                paramString.setContentDescription(paramContext.getString(j));
              }
              for (;;)
              {
                i += 1;
                break label1588;
                if ((paramView instanceof MMNeat7extView))
                {
                  paramString = (MMNeat7extView)paramView;
                  f1 = paramString.getLineSpacingMultiplier();
                  paramString.getLineSpacingExtra();
                  if (f1 >= 1.1D) {
                    break;
                  }
                  paramString.br(0.0F, 1.1F);
                  break;
                }
                if (!(paramView instanceof StaticTextView)) {
                  break;
                }
                paramString = (StaticTextView)paramView;
                f1 = paramString.getLineSpacingMultiplier();
                f2 = paramString.getLineSpacingExtra();
                if ((f1 >= 1.1D) || (f2 != 0.0F)) {
                  break;
                }
                paramString.bbN();
                break;
                label1734:
                if (af.adFz[i] == 16843088) {
                  paramString.setHint(paramContext.getString(j));
                } else {
                  paramString.setText(paramContext.getString(j));
                }
              }
            }
            paramAttributeSet.recycle();
          }
        }
        for (;;)
        {
          AppMethodBeat.o(249933);
          return paramView;
          af.c.N(paramString);
          continue;
          if ((j == aWE) || (j == adGt))
          {
            paramString = (Button)paramView;
            f1 = f1 * paramString.getTextSize() / a.getDensity(paramString.getContext());
            paramString.setTextSize(1, f1);
            if (j == adGt) {
              androidx.core.widget.j.b(paramString, (int)f1);
            }
            paramContext.getAssets();
            com.tencent.mm.ce.j.iRR();
            if (com.tencent.mm.ce.j.iRS())
            {
              paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, af.adFz);
              i = 0;
              if (i < af.adFz.length)
              {
                j = paramAttributeSet.getResourceId(i, 0);
                if (j != 0)
                {
                  if (af.adFz[i] != 16843379) {
                    break label1932;
                  }
                  paramString.setContentDescription(paramContext.getString(j));
                }
                for (;;)
                {
                  i += 1;
                  break;
                  if (af.adFz[i] == 16843088) {
                    paramString.setHint(paramContext.getString(j));
                  } else {
                    paramString.setText(paramContext.getString(j));
                  }
                }
              }
              paramAttributeSet.recycle();
            }
            else
            {
              af.c.N(paramString);
            }
          }
          else if ((j == adFP) || (j == MMEditText) || (j == adFV) || (j == adFX) || (j == adGd) || (j == adFY) || (j == adFZ) || (j == adGm) || (j == adFW))
          {
            paramString = (EditText)paramView;
            paramString.setTextSize(1, f1 * paramString.getTextSize() / a.getDensity(paramString.getContext()));
            paramContext.getAssets();
            com.tencent.mm.ce.j.iRR();
            if (com.tencent.mm.ce.j.iRS())
            {
              paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, af.adFz);
              i = 0;
              if (i < af.adFz.length)
              {
                j = paramAttributeSet.getResourceId(i, 0);
                if (j != 0)
                {
                  if (af.adFz[i] != 16843379) {
                    break label2162;
                  }
                  paramString.setContentDescription(paramContext.getString(j));
                }
                for (;;)
                {
                  i += 1;
                  break;
                  label2162:
                  if (af.adFz[i] == 16843088) {
                    paramString.setHint(paramContext.getString(j));
                  } else {
                    paramString.setText(paramContext.getString(j));
                  }
                }
              }
              paramAttributeSet.recycle();
            }
            else
            {
              af.c.N(paramString);
            }
          }
          else if ((j == adGu) || (j == adGv) || (j == adGw))
          {
            paramString = (com.tencent.mm.ui.widget.cedit.api.c)paramView;
            paramString.setTextSize(1, f1 * paramString.getTextSize() / a.getDensity(paramString.jEK()));
            paramContext.getAssets();
            com.tencent.mm.ce.j.iRR();
            if (com.tencent.mm.ce.j.iRS())
            {
              paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, af.adFz);
              i = 0;
              if (i < af.adFz.length)
              {
                j = paramAttributeSet.getResourceId(i, 0);
                if (j != 0)
                {
                  if (af.adFz[i] != 16843379) {
                    break label2352;
                  }
                  paramString.setContentDescription(paramContext.getString(j));
                }
                for (;;)
                {
                  i += 1;
                  break;
                  label2352:
                  if (af.adFz[i] == 16843088) {
                    paramString.setHint(paramContext.getString(j));
                  } else {
                    paramString.setText(paramContext.getString(j));
                  }
                }
              }
              paramAttributeSet.recycle();
            }
            else
            {
              paramContext = paramString.getText();
              if (!TextUtils.isEmpty(paramContext)) {
                paramString.setText(af.c.aR(paramContext));
              }
              paramContext = paramString.getHint();
              if (!TextUtils.isEmpty(paramContext)) {
                paramString.setHint(af.c.aR(paramContext));
              }
              paramContext = paramString.getContentDescription();
              if (!TextUtils.isEmpty(paramContext)) {
                paramString.setContentDescription(af.c.aR(paramContext));
              }
            }
          }
          else if (j == adFQ)
          {
            paramString = (CheckBox)paramView;
            paramString.setTextSize(1, f1 * paramString.getTextSize() / a.getDensity(paramString.getContext()));
            paramContext.getAssets();
            com.tencent.mm.ce.j.iRR();
            if (com.tencent.mm.ce.j.iRS())
            {
              paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, af.adFz);
              i = 0;
              if (i < af.adFz.length)
              {
                j = paramAttributeSet.getResourceId(i, 0);
                if (j != 0)
                {
                  if (af.adFz[i] != 16843379) {
                    break label2590;
                  }
                  paramString.setContentDescription(paramContext.getString(j));
                }
                for (;;)
                {
                  i += 1;
                  break;
                  if (af.adFz[i] == 16843088) {
                    paramString.setHint(paramContext.getString(j));
                  } else {
                    paramString.setText(paramContext.getString(j));
                  }
                }
              }
              paramAttributeSet.recycle();
            }
            else
            {
              af.c.N(paramString);
            }
          }
          else if (j == adFR)
          {
            paramString = (ImageView)paramView;
            paramContext.getAssets();
            com.tencent.mm.ce.j.iRR();
            if (com.tencent.mm.ce.j.iRS())
            {
              paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, af.adFA);
              i = 0;
              while (i < af.adFA.length)
              {
                j = paramAttributeSet.getResourceId(i, 0);
                if ((j != 0) && (af.adFA[i] == 16843379)) {
                  paramString.setContentDescription(paramContext.getString(j));
                }
                i += 1;
              }
              paramAttributeSet.recycle();
            }
            else
            {
              paramContext = paramString.getContentDescription();
              if (!TextUtils.isEmpty(paramContext)) {
                paramString.setContentDescription(af.c.aR(paramContext));
              }
            }
          }
          else if (j == adGx)
          {
            if (b.iRp())
            {
              paramString = (WeImageView)paramView;
              if (paramAttributeSet != null)
              {
                i = paramAttributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res-auto", "iconColor", -1);
                if (i > 0) {
                  paramString.setIconColor(paramString.getContext().getResources().getColor(i));
                }
              }
            }
          }
          else if (j == adGy)
          {
            if (b.iRp())
            {
              paramString = (WeImageButton)paramView;
              if (paramAttributeSet != null)
              {
                i = paramAttributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res-auto", "btnIconColor", -1);
                if (i > 0) {
                  paramString.setIconColor(paramString.getContext().getResources().getColor(i));
                }
              }
            }
          }
          else if (j == adFT)
          {
            paramString = (MMNeat7extView)paramView;
            paramString.setTextSize(1, f1 * paramString.getTextSize() / a.getDensity(paramString.getContext()));
            paramContext = paramString.jPy();
            if (!TextUtils.isEmpty(paramContext)) {
              paramString.aZ(af.c.aR(paramContext));
            }
            paramContext = paramString.getHint();
            if (!TextUtils.isEmpty(paramContext)) {
              paramString.setHint(af.c.aR(paramContext));
            }
            paramContext = paramString.getContentDescription();
            if (!TextUtils.isEmpty(paramContext)) {
              paramString.setContentDescription(af.c.aR(paramContext));
            }
          }
          else if (j == adGr)
          {
            paramString = (MMVerticalTextView)paramView;
            paramString.setTextSize(f1 * paramString.getTextSize());
          }
          else if (j == adFU)
          {
            paramString = (MMCollapsibleTextView)paramView;
            f1 = f1 * paramString.getTextSize() / a.getDensity(paramString.getContext());
            paramString.get_collapseButton().setTextSize(1, f1);
            paramString.get_contentText().setTextSize(1, f1);
            paramString.get_contentBackupText().setTextSize(1, f1);
          }
          else if ((paramView instanceof TextView))
          {
            paramString = (TextView)paramView;
            paramString.setTextSize(1, f1 * paramString.getTextSize() / a.getDensity(paramString.getContext()));
            af.c.N(paramString);
          }
        }
      }
    }
    
    public final View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
    {
      AppMethodBeat.i(141463);
      long l = System.currentTimeMillis();
      localObject6 = null;
      localObject5 = null;
      localObject1 = null;
      localObject2 = localObject5;
      localObject3 = localObject6;
      for (;;)
      {
        try
        {
          i = paramString.hashCode();
          localObject2 = localObject5;
          localObject3 = localObject6;
          if (i != adFG) {
            continue;
          }
          localObject2 = localObject5;
          localObject3 = localObject6;
          localObject1 = new LinearLayout(paramContext, paramAttributeSet);
        }
        catch (ClassNotFoundException paramContext)
        {
          Log.w("MicroMsg.MMLayoutInflater", "[cpan] class not found. name:%s. Use default Inflate. Exception:%s", new Object[] { paramString, paramContext.getMessage() });
          localObject1 = localObject2;
          continue;
          localObject2 = localObject5;
          localObject3 = localObject6;
          if (i != adFO) {
            continue;
          }
          localObject2 = localObject5;
          localObject3 = localObject6;
          localObject1 = new TextView(paramContext, paramAttributeSet);
          continue;
        }
        catch (InflateException paramContext)
        {
          int i;
          Log.w("MicroMsg.MMLayoutInflater", "[cpan] Inflate failed. name:%s. Use default Inflate. Exception:%s", new Object[] { paramString, paramContext.getMessage() });
          localObject1 = localObject3;
          continue;
          localObject2 = localObject5;
          localObject3 = localObject6;
          if (i != aWE) {
            continue;
          }
          localObject2 = localObject5;
          localObject3 = localObject6;
          localObject1 = new Button(paramContext, paramAttributeSet);
          continue;
          localObject2 = localObject5;
          localObject3 = localObject6;
          if (i != adFP) {
            continue;
          }
          localObject2 = localObject5;
          localObject3 = localObject6;
          localObject1 = new EditText(paramContext, paramAttributeSet);
          continue;
          localObject2 = localObject5;
          localObject3 = localObject6;
          if (i != adFQ) {
            continue;
          }
          localObject2 = localObject5;
          localObject3 = localObject6;
          localObject1 = new CheckBox(paramContext, paramAttributeSet);
          continue;
          localObject2 = localObject5;
          localObject3 = localObject6;
          if (i != adFH) {
            continue;
          }
          localObject2 = localObject5;
          localObject3 = localObject6;
          localObject1 = new FrameLayout(paramContext, paramAttributeSet);
          continue;
          localObject2 = localObject5;
          localObject3 = localObject6;
          if (i != adFI) {
            continue;
          }
          localObject2 = localObject5;
          localObject3 = localObject6;
          localObject1 = new RelativeLayout(paramContext, paramAttributeSet);
          continue;
          localObject2 = localObject5;
          localObject3 = localObject6;
          if (i != adFS) {
            continue;
          }
          localObject2 = localObject5;
          localObject3 = localObject6;
          localObject1 = new CheckedTextView(paramContext, paramAttributeSet);
          continue;
          localObject2 = localObject5;
          localObject3 = localObject6;
          if (i != adFJ) {
            continue;
          }
          localObject2 = localObject5;
          localObject3 = localObject6;
          localObject1 = new ListView(paramContext, paramAttributeSet);
          continue;
          localObject2 = localObject5;
          localObject3 = localObject6;
          if (i != adFK) {
            continue;
          }
          localObject2 = localObject5;
          localObject3 = localObject6;
          localObject1 = new View(paramContext, paramAttributeSet);
          continue;
          localObject2 = localObject5;
          localObject3 = localObject6;
          if (i != adFL) {
            continue;
          }
          localObject2 = localObject5;
          localObject3 = localObject6;
          localObject1 = new ViewStub(paramContext, paramAttributeSet);
          continue;
          localObject2 = localObject5;
          localObject3 = localObject6;
          if (i != adFM) {
            continue;
          }
          localObject2 = localObject5;
          localObject3 = localObject6;
          localObject1 = new WebView(paramContext, paramAttributeSet);
          continue;
          localObject2 = localObject5;
          localObject3 = localObject6;
          if (i != adFN) {
            continue;
          }
          localObject2 = localObject5;
          localObject3 = localObject6;
          localObject1 = new ProgressBar(paramContext, paramAttributeSet);
          continue;
          localObject2 = localObject1;
          localObject3 = localObject1;
          Object localObject4 = ((View)localObject1).animate();
          continue;
          localObject2 = localObject1;
          localObject3 = localObject1;
          Log.w("MicroMsg.MMLayoutInflater", "Inflate view, ClassNotFound ".concat(String.valueOf(paramString)));
          continue;
          continue;
        }
        localObject4 = localObject1;
        if (localObject1 == null)
        {
          localObject4 = localObject1;
          localObject2 = localObject5;
          localObject3 = localObject6;
          if (paramString.indexOf(".") > 0)
          {
            localObject2 = localObject5;
            localObject3 = localObject6;
            localObject4 = this.dvH.createView(paramString, null, paramAttributeSet);
          }
        }
        localObject2 = localObject4;
        if (localObject4 == null)
        {
          localObject2 = localObject5;
          localObject3 = localObject6;
          localObject1 = this.dvH.createView(paramString, "android.widget.", paramAttributeSet);
          localObject2 = localObject1;
        }
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject2 = localObject5;
          localObject3 = localObject6;
          localObject1 = this.dvH.createView(paramString, "android.view.", paramAttributeSet);
        }
        if (localObject1 != null)
        {
          localObject2 = localObject5;
          localObject3 = localObject6;
          ((View)localObject1).setTag(a.g.tag_acc_layout_id, Integer.valueOf(this.adFE));
        }
        if (localObject1 != null) {
          continue;
        }
        try
        {
          if (this.adFF == null) {
            continue;
          }
          localObject2 = this.adFF.onCreateView(paramString, paramContext, paramAttributeSet);
          localObject1 = localObject2;
          localObject2 = localObject1;
          localObject3 = localObject1;
          Log.d("MicroMsg.MMLayoutInflater", "step 1: %s(%d)", new Object[] { paramString, Long.valueOf(System.currentTimeMillis() - l) });
          localObject2 = localObject1;
          localObject3 = localObject1;
          localObject4 = com.tencent.mm.ui.anim.e.c.adMR;
          localObject2 = localObject1;
          localObject3 = localObject1;
          if (com.tencent.mm.ui.anim.e.c.adMS)
          {
            if (localObject1 != null) {
              continue;
            }
            localObject4 = null;
            if (localObject4 != null)
            {
              localObject2 = localObject1;
              localObject3 = localObject1;
              ((ViewPropertyAnimator)localObject4).setInterpolator((TimeInterpolator)com.tencent.mm.ui.anim.e.c.jlL());
            }
          }
          localObject2 = localObject1;
          localObject3 = localObject1;
          if ((localObject1 instanceof ViewStub))
          {
            localObject2 = localObject1;
            localObject3 = localObject1;
            ((ViewStub)localObject1).setLayoutInflater(this.dvH);
          }
          if (localObject1 == null) {
            continue;
          }
          localObject2 = localObject1;
          localObject3 = localObject1;
          a(paramString, (View)localObject1, paramContext, paramAttributeSet);
          localObject2 = localObject1;
          localObject3 = localObject1;
          Log.d("MicroMsg.MMLayoutInflater", "step 2: %s(%d)", new Object[] { paramString, Long.valueOf(System.currentTimeMillis() - l) });
          AppMethodBeat.o(141463);
          return localObject1;
        }
        catch (InflateException paramContext)
        {
          localObject3 = localObject1;
          continue;
        }
        catch (ClassNotFoundException paramContext)
        {
          localObject2 = localObject1;
          continue;
        }
        localObject2 = localObject5;
        localObject3 = localObject6;
        if (i != adFR) {
          continue;
        }
        localObject2 = localObject5;
        localObject3 = localObject6;
        localObject1 = new ImageView(paramContext, paramAttributeSet);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.af
 * JD-Core Version:    0.7.0.1
 */