package com.tencent.mm.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.cc.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Wordings;
import com.tencent.mm.ui.widget.MMCollapsibleTextView;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.cedit.api.c;
import com.tencent.neattextview.textview.view.NeatTextView;

public final class aa
{
  public static final int[] OHJ = { 16843087, 16843088, 16843379 };
  public static final int[] OHK = { 16843379 };
  
  public static LayoutInflater b(LayoutInflater paramLayoutInflater)
  {
    AppMethodBeat.i(141465);
    a.ez(paramLayoutInflater.getContext());
    paramLayoutInflater = paramLayoutInflater.cloneInContext(paramLayoutInflater.getContext());
    a locala = new a((byte)0);
    locala.layoutInflater = paramLayoutInflater;
    paramLayoutInflater.setFactory(locala);
    AppMethodBeat.o(141465);
    return paramLayoutInflater;
  }
  
  public static LayoutInflater jQ(Context paramContext)
  {
    AppMethodBeat.i(141466);
    a.ez(paramContext);
    paramContext = LayoutInflater.from(paramContext).cloneInContext(paramContext);
    a locala = new a((byte)0);
    locala.layoutInflater = paramContext;
    paramContext.setFactory(locala);
    AppMethodBeat.o(141466);
    return paramContext;
  }
  
  static final class a
    implements LayoutInflater.Factory
  {
    LayoutInflater layoutInflater;
    
    private View createView(String paramString1, String paramString2, AttributeSet paramAttributeSet)
    {
      AppMethodBeat.i(141464);
      Object localObject = null;
      try
      {
        paramString1 = this.layoutInflater.createView(paramString1, paramString2, paramAttributeSet);
        AppMethodBeat.o(141464);
        return paramString1;
      }
      catch (ClassNotFoundException paramString1)
      {
        for (;;)
        {
          paramString1 = localObject;
        }
      }
      catch (InflateException paramString1)
      {
        for (;;)
        {
          paramString1 = localObject;
        }
      }
    }
    
    public final View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
    {
      Object localObject5 = null;
      Object localObject4 = null;
      AppMethodBeat.i(141463);
      Object localObject2 = localObject4;
      Object localObject3 = localObject5;
      Object localObject1;
      label118:
      float f1;
      label828:
      int i;
      label1035:
      label1208:
      int j;
      for (;;)
      {
        try
        {
          if (paramString.indexOf(".") == -1)
          {
            localObject2 = localObject4;
            localObject3 = localObject5;
            if (!paramString.equals("WebView")) {
              break label3632;
            }
            localObject2 = localObject4;
            localObject3 = localObject5;
            localObject1 = createView(paramString, "android.webkit.", paramAttributeSet);
            localObject2 = localObject1;
            if (localObject1 == null)
            {
              localObject2 = localObject4;
              localObject3 = localObject5;
              localObject1 = createView(paramString, "android.widget.", paramAttributeSet);
              localObject2 = localObject1;
            }
            if (localObject2 != null) {
              break label3625;
            }
            localObject2 = localObject4;
            localObject3 = localObject5;
            localObject1 = createView(paramString, "android.view.", paramAttributeSet);
            localObject2 = localObject1;
            localObject3 = localObject1;
            if ((localObject1 instanceof ViewStub))
            {
              localObject2 = localObject1;
              localObject3 = localObject1;
              if (Build.VERSION.SDK_INT >= 21)
              {
                localObject2 = localObject1;
                localObject3 = localObject1;
                ((ViewStub)localObject1).setLayoutInflater(this.layoutInflater);
              }
            }
            if (localObject1 == null) {
              break label3592;
            }
            localObject2 = localObject1;
            localObject3 = localObject1;
            if (!paramString.equals("TextView"))
            {
              localObject2 = localObject1;
              localObject3 = localObject1;
              if (!paramString.equals("Button"))
              {
                localObject2 = localObject1;
                localObject3 = localObject1;
                if (!paramString.equals("EditText"))
                {
                  localObject2 = localObject1;
                  localObject3 = localObject1;
                  if (!paramString.equals("CheckBox"))
                  {
                    localObject2 = localObject1;
                    localObject3 = localObject1;
                    if (!paramString.equals("ImageView"))
                    {
                      localObject2 = localObject1;
                      localObject3 = localObject1;
                      if (!paramString.equals("CheckedTextView"))
                      {
                        localObject2 = localObject1;
                        localObject3 = localObject1;
                        if (!paramString.equals("com.tencent.mm.ui.widget.MMTextView"))
                        {
                          localObject2 = localObject1;
                          localObject3 = localObject1;
                          if (!paramString.equals("com.tencent.mm.ui.widget.MMEditText"))
                          {
                            localObject2 = localObject1;
                            localObject3 = localObject1;
                            if (!paramString.equals("com.tencent.mm.ui.widget.MMNeat7extView"))
                            {
                              localObject2 = localObject1;
                              localObject3 = localObject1;
                              if (!paramString.equals("com.tencent.mm.ui.widget.MMCollapsibleTextView"))
                              {
                                localObject2 = localObject1;
                                localObject3 = localObject1;
                                if (!paramString.equals("com.tencent.mm.ui.base.MMClearEditText"))
                                {
                                  localObject2 = localObject1;
                                  localObject3 = localObject1;
                                  if (!paramString.equals("com.tencent.mm.ui.widget.edittext.PasterEditText"))
                                  {
                                    localObject2 = localObject1;
                                    localObject3 = localObject1;
                                    if (!paramString.equals("com.tenpay.android.wechat.TenpaySecureEditText"))
                                    {
                                      localObject2 = localObject1;
                                      localObject3 = localObject1;
                                      if (!paramString.equals("com.tencent.mm.ui.base.MMVisiblePasswordEditText"))
                                      {
                                        localObject2 = localObject1;
                                        localObject3 = localObject1;
                                        if (!paramString.equals("com.tencent.mm.ui.tools.MMTruncTextView"))
                                        {
                                          localObject2 = localObject1;
                                          localObject3 = localObject1;
                                          if (!paramString.equals("com.tencent.mm.plugin.brandservice.ui.base.CatalogView"))
                                          {
                                            localObject2 = localObject1;
                                            localObject3 = localObject1;
                                            if (!paramString.equals("com.tencent.mm.ui.tools.CustomFitTextView"))
                                            {
                                              localObject2 = localObject1;
                                              localObject3 = localObject1;
                                              if (!paramString.equals("com.tencent.mm.ui.tools.ActionBarSearchView$ActionBarEditText"))
                                              {
                                                localObject2 = localObject1;
                                                localObject3 = localObject1;
                                                if (!paramString.equals("com.tencent.mm.plugin.favorite.ui.base.FavDetailFooterView"))
                                                {
                                                  localObject2 = localObject1;
                                                  localObject3 = localObject1;
                                                  if (!paramString.equals("com.tencent.mm.plugin.game.ui.GameDropdownView"))
                                                  {
                                                    localObject2 = localObject1;
                                                    localObject3 = localObject1;
                                                    if (!paramString.equals("com.tencent.mm.ui.ScrollAlwaysTextView"))
                                                    {
                                                      localObject2 = localObject1;
                                                      localObject3 = localObject1;
                                                      if (!paramString.equals("com.tencent.mm.ui.base.MMAutoSizeTextView"))
                                                      {
                                                        localObject2 = localObject1;
                                                        localObject3 = localObject1;
                                                        if (!paramString.equals("com.tencent.mm.ui.widget.textview.MMAutoAdjustTextView"))
                                                        {
                                                          localObject2 = localObject1;
                                                          localObject3 = localObject1;
                                                          if (!paramString.equals("com.tencent.mm.plugin.sns.ui.AsyncTextView"))
                                                          {
                                                            localObject2 = localObject1;
                                                            localObject3 = localObject1;
                                                            if (!paramString.equals("com.tencent.mm.plugin.sns.ui.SnsTextView"))
                                                            {
                                                              localObject2 = localObject1;
                                                              localObject3 = localObject1;
                                                              if (!paramString.equals("com.tencent.mm.plugin.sns.ui.MaskTextView"))
                                                              {
                                                                localObject2 = localObject1;
                                                                localObject3 = localObject1;
                                                                if (!paramString.equals("com.tencent.mm.plugin.sns.ui.SnsEditText"))
                                                                {
                                                                  localObject2 = localObject1;
                                                                  localObject3 = localObject1;
                                                                  if (!paramString.equals("com.tencent.mm.kiss.widget.textview.PLSysTextView"))
                                                                  {
                                                                    localObject2 = localObject1;
                                                                    localObject3 = localObject1;
                                                                    if (!paramString.equals("com.tencent.mm.ui.base.EllipsizeTextView"))
                                                                    {
                                                                      localObject2 = localObject1;
                                                                      localObject3 = localObject1;
                                                                      if (!paramString.equals("com.tencent.mm.wallet_core.ui.WalletTextView"))
                                                                      {
                                                                        localObject2 = localObject1;
                                                                        localObject3 = localObject1;
                                                                        if (!paramString.equals("com.tencent.mm.ui.widget.cedit.api.MMCustomEditText"))
                                                                        {
                                                                          localObject2 = localObject1;
                                                                          localObject3 = localObject1;
                                                                          if (!paramString.equals("com.tencent.mm.plugin.sns.ui.SnsCustomEditText"))
                                                                          {
                                                                            localObject2 = localObject1;
                                                                            localObject4 = localObject1;
                                                                            localObject3 = localObject1;
                                                                            if (!paramString.equals("com.tencent.mm.ui.widget.cedit.api.MMFlexEditText")) {
                                                                              continue;
                                                                            }
                                                                          }
                                                                        }
                                                                      }
                                                                    }
                                                                  }
                                                                }
                                                              }
                                                            }
                                                          }
                                                        }
                                                      }
                                                    }
                                                  }
                                                }
                                              }
                                            }
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
            localObject2 = localObject1;
            localObject3 = localObject1;
            float f2 = a.ez(paramContext);
            f1 = f2;
            localObject2 = localObject1;
            localObject3 = localObject1;
            if (paramContext.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getBoolean("screenResolution_isModifyDensity", true))
            {
              localObject2 = localObject1;
              localObject3 = localObject1;
              if (ao.as(f2, 1.1F)) {
                break label3638;
              }
              f1 = f2;
              localObject2 = localObject1;
              localObject3 = localObject1;
              if (ao.as(f2, 0.8F)) {
                break label3638;
              }
            }
            localObject2 = localObject1;
            localObject3 = localObject1;
            if (!ao.as(f1, a.jc(paramContext)))
            {
              localObject2 = localObject1;
              localObject3 = localObject1;
              if (!ao.as(f1, a.jd(paramContext))) {
                break label3622;
              }
            }
            localObject2 = localObject1;
            localObject3 = localObject1;
            if (paramString.equals("com.tencent.mm.ui.widget.MMTextView")) {
              break label3622;
            }
            localObject2 = localObject1;
            localObject3 = localObject1;
            if (paramString.equals("com.tencent.mm.plugin.sns.ui.AsyncTextView")) {
              break label3622;
            }
            localObject2 = localObject1;
            localObject3 = localObject1;
            if (paramString.equals("com.tencent.mm.plugin.sns.ui.SnsTextView")) {
              break label3622;
            }
            localObject2 = localObject1;
            localObject3 = localObject1;
            if (paramString.equals("com.tencent.mm.plugin.sns.ui.MaskTextView")) {
              break label3622;
            }
            localObject2 = localObject1;
            localObject3 = localObject1;
            if (paramString.equals("com.tencent.mm.ui.widget.MMNeat7extView")) {
              break label3622;
            }
            localObject2 = localObject1;
            localObject3 = localObject1;
            if (paramString.equals("com.tencent.mm.ui.widget.cedit.api.MMCustomEditText")) {
              break label3622;
            }
            localObject2 = localObject1;
            localObject3 = localObject1;
            if (paramString.equals("com.tencent.mm.plugin.sns.ui.SnsCustomEditText")) {
              break label3622;
            }
            localObject2 = localObject1;
            localObject3 = localObject1;
            if (paramString.equals("com.tencent.mm.ui.widget.cedit.api.MMFlexEditText")) {
              break label3622;
            }
            localObject2 = localObject1;
            localObject3 = localObject1;
            if (paramString.equals("com.tencent.mm.ui.widget.MMCollapsibleTextView")) {
              break label3622;
            }
            localObject2 = localObject1;
            localObject3 = localObject1;
            f1 = a.jb(paramContext);
            localObject2 = localObject1;
            localObject3 = localObject1;
            if (!paramString.equals("TextView"))
            {
              localObject2 = localObject1;
              localObject3 = localObject1;
              if (!paramString.equals("com.tencent.mm.ui.widget.MMTextView"))
              {
                localObject2 = localObject1;
                localObject3 = localObject1;
                if (!paramString.equals("com.tencent.mm.wallet_core.ui.WalletTextView"))
                {
                  localObject2 = localObject1;
                  localObject3 = localObject1;
                  if (!paramString.equals("com.tencent.mm.ui.widget.textview.MMAutoAdjustTextView")) {
                    continue;
                  }
                }
              }
            }
            localObject2 = localObject1;
            localObject3 = localObject1;
            localObject4 = (TextView)localObject1;
            localObject2 = localObject1;
            localObject3 = localObject1;
            ((TextView)localObject4).setTextSize(1, f1 * ((TextView)localObject4).getTextSize() / a.getDensity(((TextView)localObject4).getContext()));
            localObject2 = localObject1;
            localObject3 = localObject1;
            paramContext.getAssets();
            localObject2 = localObject1;
            localObject3 = localObject1;
            h.gvF();
            localObject2 = localObject1;
            localObject3 = localObject1;
            if (!h.gvG()) {
              continue;
            }
            localObject2 = localObject1;
            localObject3 = localObject1;
            paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, aa.OHJ);
            i = 0;
            localObject2 = localObject1;
            localObject3 = localObject1;
            if (i >= aa.OHJ.length) {
              continue;
            }
            localObject2 = localObject1;
            localObject3 = localObject1;
            j = paramAttributeSet.getResourceId(i, 0);
            if (j == 0) {
              break label3644;
            }
            localObject2 = localObject1;
            localObject3 = localObject1;
            if (aa.OHJ[i] == 16843379)
            {
              localObject2 = localObject1;
              localObject3 = localObject1;
              ((TextView)localObject4).setContentDescription(paramContext.getString(j));
              break label3644;
            }
          }
          else
          {
            localObject2 = localObject4;
            localObject3 = localObject5;
            localObject1 = this.layoutInflater.createView(paramString, null, paramAttributeSet);
            continue;
          }
          localObject2 = localObject1;
          localObject3 = localObject1;
          if (aa.OHJ[i] == 16843088)
          {
            localObject2 = localObject1;
            localObject3 = localObject1;
            ((TextView)localObject4).setHint(paramContext.getString(j));
          }
        }
        catch (ClassNotFoundException paramContext)
        {
          Log.w("MicroMsg.MMLayoutInflater", "[cpan] class not found. name:%s. Use default Inflate.", new Object[] { paramString });
          localObject4 = localObject2;
          AppMethodBeat.o(141463);
          return localObject4;
          localObject2 = localObject1;
          localObject3 = localObject1;
          ((TextView)localObject4).setText(paramContext.getString(j));
        }
        catch (InflateException paramContext)
        {
          label1372:
          Log.w("MicroMsg.MMLayoutInflater", "[cpan] Inflate failed. name:%s. Use default Inflate.", new Object[] { paramString });
          localObject4 = localObject3;
          continue;
          localObject2 = localObject1;
          localObject3 = localObject1;
          paramAttributeSet.recycle();
          localObject2 = localObject1;
          localObject3 = localObject1;
          aa.b.D((TextView)localObject4);
          localObject4 = localObject1;
          continue;
          localObject2 = localObject1;
          localObject3 = localObject1;
          if (!paramString.equals("Button")) {
            break label1755;
          }
        }
        localObject2 = localObject1;
        localObject3 = localObject1;
        localObject4 = (Button)localObject1;
        localObject2 = localObject1;
        localObject3 = localObject1;
        ((Button)localObject4).setTextSize(1, f1 * ((Button)localObject4).getTextSize() / a.getDensity(((Button)localObject4).getContext()));
        localObject2 = localObject1;
        localObject3 = localObject1;
        paramContext.getAssets();
        localObject2 = localObject1;
        localObject3 = localObject1;
        h.gvF();
        localObject2 = localObject1;
        localObject3 = localObject1;
        if (h.gvG())
        {
          localObject2 = localObject1;
          localObject3 = localObject1;
          paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, aa.OHJ);
          i = 0;
          label1580:
          localObject2 = localObject1;
          localObject3 = localObject1;
          if (i < aa.OHJ.length)
          {
            localObject2 = localObject1;
            localObject3 = localObject1;
            j = paramAttributeSet.getResourceId(i, 0);
            if (j == 0) {
              break label3653;
            }
            localObject2 = localObject1;
            localObject3 = localObject1;
            if (aa.OHJ[i] == 16843379)
            {
              localObject2 = localObject1;
              localObject3 = localObject1;
              ((Button)localObject4).setContentDescription(paramContext.getString(j));
              break label3653;
            }
            localObject2 = localObject1;
            localObject3 = localObject1;
            if (aa.OHJ[i] == 16843088)
            {
              localObject2 = localObject1;
              localObject3 = localObject1;
              ((Button)localObject4).setHint(paramContext.getString(j));
              break label3653;
            }
            localObject2 = localObject1;
            localObject3 = localObject1;
            ((Button)localObject4).setText(paramContext.getString(j));
            break label3653;
          }
          localObject2 = localObject1;
          localObject3 = localObject1;
          paramAttributeSet.recycle();
        }
        localObject2 = localObject1;
        localObject3 = localObject1;
        aa.b.D((TextView)localObject4);
        localObject4 = localObject1;
        continue;
        label1755:
        localObject2 = localObject1;
        localObject3 = localObject1;
        if (!paramString.equals("EditText"))
        {
          localObject2 = localObject1;
          localObject3 = localObject1;
          if (!paramString.equals("com.tencent.mm.ui.widget.MMEditText"))
          {
            localObject2 = localObject1;
            localObject3 = localObject1;
            if (!paramString.equals("com.tencent.mm.ui.base.MMClearEditText"))
            {
              localObject2 = localObject1;
              localObject3 = localObject1;
              if (!paramString.equals("com.tencent.mm.ui.widget.edittext.PasterEditText"))
              {
                localObject2 = localObject1;
                localObject3 = localObject1;
                if (!paramString.equals("com.tencent.mm.ui.tools.ActionBarSearchView$ActionBarEditText"))
                {
                  localObject2 = localObject1;
                  localObject3 = localObject1;
                  if (!paramString.equals("com.tenpay.android.wechat.TenpaySecureEditText"))
                  {
                    localObject2 = localObject1;
                    localObject3 = localObject1;
                    if (!paramString.equals("com.tencent.mm.ui.base.MMVisiblePasswordEditText"))
                    {
                      localObject2 = localObject1;
                      localObject3 = localObject1;
                      if (!paramString.equals("com.tencent.mm.plugin.sns.ui.SnsEditText")) {
                        break label2171;
                      }
                    }
                  }
                }
              }
            }
          }
        }
        localObject2 = localObject1;
        localObject3 = localObject1;
        localObject4 = (EditText)localObject1;
        localObject2 = localObject1;
        localObject3 = localObject1;
        ((EditText)localObject4).setTextSize(1, f1 * ((EditText)localObject4).getTextSize() / a.getDensity(((EditText)localObject4).getContext()));
        localObject2 = localObject1;
        localObject3 = localObject1;
        paramContext.getAssets();
        localObject2 = localObject1;
        localObject3 = localObject1;
        h.gvF();
        localObject2 = localObject1;
        localObject3 = localObject1;
        if (h.gvG())
        {
          localObject2 = localObject1;
          localObject3 = localObject1;
          paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, aa.OHJ);
          i = 0;
          label1996:
          localObject2 = localObject1;
          localObject3 = localObject1;
          if (i < aa.OHJ.length)
          {
            localObject2 = localObject1;
            localObject3 = localObject1;
            j = paramAttributeSet.getResourceId(i, 0);
            if (j == 0) {
              break label3662;
            }
            localObject2 = localObject1;
            localObject3 = localObject1;
            if (aa.OHJ[i] == 16843379)
            {
              localObject2 = localObject1;
              localObject3 = localObject1;
              ((EditText)localObject4).setContentDescription(paramContext.getString(j));
              break label3662;
            }
            localObject2 = localObject1;
            localObject3 = localObject1;
            if (aa.OHJ[i] == 16843088)
            {
              localObject2 = localObject1;
              localObject3 = localObject1;
              ((EditText)localObject4).setHint(paramContext.getString(j));
              break label3662;
            }
            localObject2 = localObject1;
            localObject3 = localObject1;
            ((EditText)localObject4).setText(paramContext.getString(j));
            break label3662;
          }
          localObject2 = localObject1;
          localObject3 = localObject1;
          paramAttributeSet.recycle();
        }
        localObject2 = localObject1;
        localObject3 = localObject1;
        aa.b.D((TextView)localObject4);
        localObject4 = localObject1;
        continue;
        label2171:
        localObject2 = localObject1;
        localObject3 = localObject1;
        if (!paramString.equals("com.tencent.mm.ui.widget.cedit.api.MMCustomEditText"))
        {
          localObject2 = localObject1;
          localObject3 = localObject1;
          if (!paramString.equals("com.tencent.mm.plugin.sns.ui.SnsCustomEditText"))
          {
            localObject2 = localObject1;
            localObject3 = localObject1;
            if (!paramString.equals("com.tencent.mm.ui.widget.cedit.api.MMFlexEditText")) {
              break label2655;
            }
          }
        }
        localObject2 = localObject1;
        localObject3 = localObject1;
        localObject5 = (c)localObject1;
        localObject2 = localObject1;
        localObject3 = localObject1;
        ((c)localObject5).setTextSize(1, f1 * ((c)localObject5).getTextSize() / a.getDensity(((c)localObject5).gYK()));
        localObject2 = localObject1;
        localObject3 = localObject1;
        paramContext.getAssets();
        localObject2 = localObject1;
        localObject3 = localObject1;
        h.gvF();
        localObject2 = localObject1;
        localObject3 = localObject1;
        if (h.gvG())
        {
          localObject2 = localObject1;
          localObject3 = localObject1;
          paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, aa.OHJ);
          i = 0;
          label2333:
          localObject2 = localObject1;
          localObject3 = localObject1;
          if (i < aa.OHJ.length)
          {
            localObject2 = localObject1;
            localObject3 = localObject1;
            j = paramAttributeSet.getResourceId(i, 0);
            if (j == 0) {
              break label3671;
            }
            localObject2 = localObject1;
            localObject3 = localObject1;
            if (aa.OHJ[i] == 16843379)
            {
              localObject2 = localObject1;
              localObject3 = localObject1;
              ((c)localObject5).setContentDescription(paramContext.getString(j));
              break label3671;
            }
            localObject2 = localObject1;
            localObject3 = localObject1;
            if (aa.OHJ[i] == 16843088)
            {
              localObject2 = localObject1;
              localObject3 = localObject1;
              ((c)localObject5).setHint(paramContext.getString(j));
              break label3671;
            }
            localObject2 = localObject1;
            localObject3 = localObject1;
            ((c)localObject5).setText(paramContext.getString(j));
            break label3671;
          }
          localObject2 = localObject1;
          localObject3 = localObject1;
          paramAttributeSet.recycle();
        }
        localObject2 = localObject1;
        localObject3 = localObject1;
        paramContext = ((c)localObject5).getText();
        localObject2 = localObject1;
        localObject3 = localObject1;
        if (!TextUtils.isEmpty(paramContext))
        {
          localObject2 = localObject1;
          localObject3 = localObject1;
          ((c)localObject5).setText(aa.b.aq(paramContext));
        }
        localObject2 = localObject1;
        localObject3 = localObject1;
        paramContext = ((c)localObject5).getHint();
        localObject2 = localObject1;
        localObject3 = localObject1;
        if (!TextUtils.isEmpty(paramContext))
        {
          localObject2 = localObject1;
          localObject3 = localObject1;
          ((c)localObject5).setHint(aa.b.aq(paramContext));
        }
        localObject2 = localObject1;
        localObject3 = localObject1;
        paramContext = ((c)localObject5).getContentDescription();
        localObject2 = localObject1;
        localObject4 = localObject1;
        localObject3 = localObject1;
        if (!TextUtils.isEmpty(paramContext))
        {
          localObject2 = localObject1;
          localObject3 = localObject1;
          ((c)localObject5).setContentDescription(aa.b.aq(paramContext));
          localObject4 = localObject1;
          continue;
          label2655:
          localObject2 = localObject1;
          localObject3 = localObject1;
          if (!paramString.equals("CheckBox")) {
            break;
          }
          localObject2 = localObject1;
          localObject3 = localObject1;
          localObject4 = (CheckBox)localObject1;
          localObject2 = localObject1;
          localObject3 = localObject1;
          ((CheckBox)localObject4).setTextSize(1, f1 * ((CheckBox)localObject4).getTextSize() / a.getDensity(((CheckBox)localObject4).getContext()));
          localObject2 = localObject1;
          localObject3 = localObject1;
          paramContext.getAssets();
          localObject2 = localObject1;
          localObject3 = localObject1;
          h.gvF();
          localObject2 = localObject1;
          localObject3 = localObject1;
          if (h.gvG())
          {
            localObject2 = localObject1;
            localObject3 = localObject1;
            paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, aa.OHJ);
            i = 0;
            label2777:
            localObject2 = localObject1;
            localObject3 = localObject1;
            if (i < aa.OHJ.length)
            {
              localObject2 = localObject1;
              localObject3 = localObject1;
              j = paramAttributeSet.getResourceId(i, 0);
              if (j == 0) {
                break label3680;
              }
              localObject2 = localObject1;
              localObject3 = localObject1;
              if (aa.OHJ[i] == 16843379)
              {
                localObject2 = localObject1;
                localObject3 = localObject1;
                ((CheckBox)localObject4).setContentDescription(paramContext.getString(j));
                break label3680;
              }
              localObject2 = localObject1;
              localObject3 = localObject1;
              if (aa.OHJ[i] == 16843088)
              {
                localObject2 = localObject1;
                localObject3 = localObject1;
                ((CheckBox)localObject4).setHint(paramContext.getString(j));
                break label3680;
              }
              localObject2 = localObject1;
              localObject3 = localObject1;
              ((CheckBox)localObject4).setText(paramContext.getString(j));
              break label3680;
            }
            localObject2 = localObject1;
            localObject3 = localObject1;
            paramAttributeSet.recycle();
          }
          localObject2 = localObject1;
          localObject3 = localObject1;
          aa.b.D((TextView)localObject4);
          localObject4 = localObject1;
        }
      }
      localObject2 = localObject1;
      localObject3 = localObject1;
      if (paramString.equals("ImageView"))
      {
        localObject2 = localObject1;
        localObject3 = localObject1;
        localObject5 = (ImageView)localObject1;
        localObject2 = localObject1;
        localObject3 = localObject1;
        paramContext.getAssets();
        localObject2 = localObject1;
        localObject3 = localObject1;
        h.gvF();
        localObject2 = localObject1;
        localObject3 = localObject1;
        if (h.gvG())
        {
          localObject2 = localObject1;
          localObject3 = localObject1;
          paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, aa.OHK);
          i = 0;
        }
      }
      for (;;)
      {
        localObject2 = localObject1;
        localObject3 = localObject1;
        if (i < aa.OHK.length)
        {
          localObject2 = localObject1;
          localObject3 = localObject1;
          j = paramAttributeSet.getResourceId(i, 0);
          if (j != 0)
          {
            localObject2 = localObject1;
            localObject3 = localObject1;
            if (aa.OHK[i] == 16843379)
            {
              localObject2 = localObject1;
              localObject3 = localObject1;
              ((ImageView)localObject5).setContentDescription(paramContext.getString(j));
            }
          }
        }
        else
        {
          localObject2 = localObject1;
          localObject3 = localObject1;
          paramAttributeSet.recycle();
          localObject2 = localObject1;
          localObject3 = localObject1;
          paramContext = ((ImageView)localObject5).getContentDescription();
          localObject2 = localObject1;
          localObject4 = localObject1;
          localObject3 = localObject1;
          if (TextUtils.isEmpty(paramContext)) {
            break label1372;
          }
          localObject2 = localObject1;
          localObject3 = localObject1;
          ((ImageView)localObject5).setContentDescription(aa.b.aq(paramContext));
          localObject4 = localObject1;
          break label1372;
          localObject2 = localObject1;
          localObject3 = localObject1;
          if (paramString.equals("com.tencent.mm.ui.widget.MMNeat7extView"))
          {
            localObject2 = localObject1;
            localObject3 = localObject1;
            paramContext = (MMNeat7extView)localObject1;
            localObject2 = localObject1;
            localObject3 = localObject1;
            paramContext.setTextSize(1, f1 * paramContext.getTextSize() / a.getDensity(paramContext.getContext()));
            localObject2 = localObject1;
            localObject3 = localObject1;
            paramAttributeSet = paramContext.hiT();
            localObject2 = localObject1;
            localObject3 = localObject1;
            if (!TextUtils.isEmpty(paramAttributeSet))
            {
              localObject2 = localObject1;
              localObject3 = localObject1;
              paramContext.aw(aa.b.aq(paramAttributeSet));
            }
            localObject2 = localObject1;
            localObject3 = localObject1;
            paramAttributeSet = paramContext.getHint();
            localObject2 = localObject1;
            localObject3 = localObject1;
            if (!TextUtils.isEmpty(paramAttributeSet))
            {
              localObject2 = localObject1;
              localObject3 = localObject1;
              paramContext.setHint(aa.b.aq(paramAttributeSet));
            }
            localObject2 = localObject1;
            localObject3 = localObject1;
            paramAttributeSet = paramContext.getContentDescription();
            localObject2 = localObject1;
            localObject4 = localObject1;
            localObject3 = localObject1;
            if (TextUtils.isEmpty(paramAttributeSet)) {
              break label1372;
            }
            localObject2 = localObject1;
            localObject3 = localObject1;
            paramContext.setContentDescription(aa.b.aq(paramAttributeSet));
            localObject4 = localObject1;
            break label1372;
          }
          localObject2 = localObject1;
          localObject3 = localObject1;
          if (paramString.equals("com.tencent.mm.ui.widget.MMCollapsibleTextView"))
          {
            localObject2 = localObject1;
            localObject3 = localObject1;
            paramContext = (MMCollapsibleTextView)localObject1;
            localObject2 = localObject1;
            localObject3 = localObject1;
            f1 = f1 * paramContext.getTextSize() / a.getDensity(paramContext.getContext());
            localObject2 = localObject1;
            localObject3 = localObject1;
            paramContext.get_collapseButton().setTextSize(1, f1);
            localObject2 = localObject1;
            localObject3 = localObject1;
            paramContext.get_contentText().setTextSize(1, f1);
            localObject2 = localObject1;
            localObject3 = localObject1;
            paramContext.get_contentBackupText().setTextSize(1, f1);
            localObject4 = localObject1;
            break label1372;
          }
          localObject2 = localObject1;
          localObject4 = localObject1;
          localObject3 = localObject1;
          if (!(localObject1 instanceof TextView)) {
            break label1372;
          }
          localObject2 = localObject1;
          localObject3 = localObject1;
          paramContext = (TextView)localObject1;
          localObject2 = localObject1;
          localObject3 = localObject1;
          paramContext.setTextSize(1, f1 * paramContext.getTextSize() / a.getDensity(paramContext.getContext()));
          localObject2 = localObject1;
          localObject3 = localObject1;
          aa.b.D(paramContext);
          localObject4 = localObject1;
          break label1372;
          label3592:
          localObject2 = localObject1;
          localObject3 = localObject1;
          Log.w("MicroMsg.MMLayoutInflater", "Inflate view, ClassNotFound ".concat(String.valueOf(paramString)));
          localObject4 = localObject1;
          break label1372;
          label3622:
          break label1035;
          label3625:
          localObject1 = localObject2;
          break label118;
          label3632:
          localObject1 = null;
          break;
          label3638:
          f1 = 1.0F;
          break label828;
          label3644:
          i += 1;
          break label1208;
          label3653:
          i += 1;
          break label1580;
          label3662:
          i += 1;
          break label1996;
          label3671:
          i += 1;
          break label2333;
          label3680:
          i += 1;
          break label2777;
        }
        i += 1;
      }
    }
  }
  
  static final class b
  {
    public static void D(TextView paramTextView)
    {
      AppMethodBeat.i(205127);
      CharSequence localCharSequence = paramTextView.getText();
      if (!TextUtils.isEmpty(localCharSequence)) {
        paramTextView.setText(aq(localCharSequence));
      }
      localCharSequence = paramTextView.getHint();
      if (!TextUtils.isEmpty(localCharSequence)) {
        paramTextView.setHint(aq(localCharSequence));
      }
      localCharSequence = paramTextView.getContentDescription();
      if (!TextUtils.isEmpty(localCharSequence)) {
        paramTextView.setContentDescription(aq(localCharSequence));
      }
      AppMethodBeat.o(205127);
    }
    
    static String aq(CharSequence paramCharSequence)
    {
      AppMethodBeat.i(205128);
      if (paramCharSequence == null)
      {
        AppMethodBeat.o(205128);
        return null;
      }
      paramCharSequence = blT(paramCharSequence.toString());
      AppMethodBeat.o(205128);
      return paramCharSequence;
    }
    
    private static String blT(String paramString)
    {
      AppMethodBeat.i(205129);
      if (TextUtils.isEmpty(paramString))
      {
        AppMethodBeat.o(205129);
        return paramString;
      }
      paramString = WeChatBrands.Wordings.translate(paramString);
      AppMethodBeat.o(205129);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.aa
 * JD-Core Version:    0.7.0.1
 */