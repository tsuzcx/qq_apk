package com.tencent.mm.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
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
import com.tencent.mm.cc.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.widget.MMCollapsibleTextView;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class w
{
  public static final int[] zck = { 16843087, 16843088, 16843379 };
  public static final int[] zcl = { 16843379 };
  
  public static LayoutInflater b(LayoutInflater paramLayoutInflater)
  {
    AppMethodBeat.i(106107);
    a.dr(paramLayoutInflater.getContext());
    paramLayoutInflater = paramLayoutInflater.cloneInContext(paramLayoutInflater.getContext());
    a locala = new a((byte)0);
    locala.layoutInflater = paramLayoutInflater;
    paramLayoutInflater.setFactory(locala);
    AppMethodBeat.o(106107);
    return paramLayoutInflater;
  }
  
  public static LayoutInflater hM(Context paramContext)
  {
    AppMethodBeat.i(106108);
    a.dr(paramContext);
    paramContext = LayoutInflater.from(paramContext).cloneInContext(paramContext);
    a locala = new a((byte)0);
    locala.layoutInflater = paramContext;
    paramContext.setFactory(locala);
    AppMethodBeat.o(106108);
    return paramContext;
  }
  
  static final class a
    implements LayoutInflater.Factory
  {
    LayoutInflater layoutInflater;
    
    private View createView(String paramString1, String paramString2, AttributeSet paramAttributeSet)
    {
      AppMethodBeat.i(106106);
      Object localObject = null;
      try
      {
        paramString1 = this.layoutInflater.createView(paramString1, paramString2, paramAttributeSet);
        AppMethodBeat.o(106106);
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
      AppMethodBeat.i(106105);
      Object localObject2 = localObject4;
      Object localObject3 = localObject5;
      Object localObject1;
      label118:
      float f1;
      label777:
      label933:
      label1093:
      int j;
      label1257:
      do
      {
        for (;;)
        {
          try
          {
            if (paramString.indexOf(".") == -1)
            {
              localObject2 = localObject4;
              localObject3 = localObject5;
              if (!paramString.equals("WebView")) {
                break label2778;
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
                break label2771;
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
                break label2738;
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
                                                                        localObject4 = localObject1;
                                                                        localObject3 = localObject1;
                                                                        if (!paramString.equals("com.tencent.mm.wallet_core.ui.WalletTextView")) {
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
              localObject2 = localObject1;
              localObject3 = localObject1;
              float f2 = a.dr(paramContext);
              f1 = f2;
              localObject2 = localObject1;
              localObject3 = localObject1;
              if (paramContext.getSharedPreferences(ah.dsP(), 0).getBoolean("screenResolution_isModifyDensity", true))
              {
                localObject2 = localObject1;
                localObject3 = localObject1;
                if (af.am(f2, 1.1F)) {
                  break label2784;
                }
                f1 = f2;
                localObject2 = localObject1;
                localObject3 = localObject1;
                if (af.am(f2, 0.8F)) {
                  break label2784;
                }
              }
              localObject2 = localObject1;
              localObject3 = localObject1;
              if (!af.am(f1, a.gl(paramContext)))
              {
                localObject2 = localObject1;
                localObject3 = localObject1;
                if (!af.am(f1, a.gm(paramContext))) {
                  break label2768;
                }
              }
              localObject2 = localObject1;
              localObject3 = localObject1;
              if (paramString.equals("com.tencent.mm.ui.widget.MMTextView")) {
                break label2768;
              }
              localObject2 = localObject1;
              localObject3 = localObject1;
              if (paramString.equals("com.tencent.mm.plugin.sns.ui.AsyncTextView")) {
                break label2768;
              }
              localObject2 = localObject1;
              localObject3 = localObject1;
              if (paramString.equals("com.tencent.mm.plugin.sns.ui.SnsTextView")) {
                break label2768;
              }
              localObject2 = localObject1;
              localObject3 = localObject1;
              if (paramString.equals("com.tencent.mm.plugin.sns.ui.MaskTextView")) {
                break label2768;
              }
              localObject2 = localObject1;
              localObject3 = localObject1;
              if (paramString.equals("com.tencent.mm.ui.widget.MMNeat7extView")) {
                break label2768;
              }
              localObject2 = localObject1;
              localObject3 = localObject1;
              if (paramString.equals("com.tencent.mm.ui.widget.MMCollapsibleTextView")) {
                break label2768;
              }
              localObject2 = localObject1;
              localObject3 = localObject1;
              f1 = a.gk(paramContext);
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
                  if (!paramString.equals("com.tencent.mm.wallet_core.ui.WalletTextView")) {
                    continue;
                  }
                }
              }
              localObject2 = localObject1;
              localObject3 = localObject1;
              localObject5 = (TextView)localObject1;
              localObject2 = localObject1;
              localObject3 = localObject1;
              ((TextView)localObject5).setTextSize(1, f1 * ((TextView)localObject5).getTextSize() / a.getDensity(((TextView)localObject5).getContext()));
              localObject2 = localObject1;
              localObject3 = localObject1;
              paramContext.getAssets();
              localObject2 = localObject1;
              localObject3 = localObject1;
              f.drk();
              localObject2 = localObject1;
              localObject4 = localObject1;
              localObject3 = localObject1;
              if (!f.drl()) {
                continue;
              }
              localObject2 = localObject1;
              localObject3 = localObject1;
              paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, w.zck);
              i = 0;
              localObject2 = localObject1;
              localObject3 = localObject1;
              if (i >= w.zck.length) {
                continue;
              }
              localObject2 = localObject1;
              localObject3 = localObject1;
              j = paramAttributeSet.getResourceId(i, 0);
              if (j == 0) {
                break label2790;
              }
              localObject2 = localObject1;
              localObject3 = localObject1;
              if (w.zck[i] == 16843379)
              {
                localObject2 = localObject1;
                localObject3 = localObject1;
                ((TextView)localObject5).setContentDescription(paramContext.getString(j));
                break label2790;
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
            if (w.zck[i] == 16843088)
            {
              localObject2 = localObject1;
              localObject3 = localObject1;
              ((TextView)localObject5).setHint(paramContext.getString(j));
            }
          }
          catch (ClassNotFoundException paramContext)
          {
            ab.w("MicroMsg.MMLayoutInflater", "[cpan] class not found. name:%s. Use default Inflate.", new Object[] { paramString });
            localObject4 = localObject2;
            AppMethodBeat.o(106105);
            return localObject4;
            localObject2 = localObject1;
            localObject3 = localObject1;
            ((TextView)localObject5).setText(paramContext.getString(j));
          }
          catch (InflateException paramContext)
          {
            ab.w("MicroMsg.MMLayoutInflater", "[cpan] Inflate failed. name:%s. Use default Inflate.", new Object[] { paramString });
            localObject4 = localObject3;
            continue;
            localObject2 = localObject1;
            localObject3 = localObject1;
            paramAttributeSet.recycle();
            localObject4 = localObject1;
            continue;
            localObject2 = localObject1;
            localObject3 = localObject1;
            if (!paramString.equals("Button")) {
              break label1617;
            }
          }
          localObject2 = localObject1;
          localObject3 = localObject1;
          localObject5 = (Button)localObject1;
          localObject2 = localObject1;
          localObject3 = localObject1;
          ((Button)localObject5).setTextSize(1, f1 * ((Button)localObject5).getTextSize() / a.getDensity(((Button)localObject5).getContext()));
          localObject2 = localObject1;
          localObject3 = localObject1;
          paramContext.getAssets();
          localObject2 = localObject1;
          localObject3 = localObject1;
          f.drk();
          localObject2 = localObject1;
          localObject4 = localObject1;
          localObject3 = localObject1;
          if (f.drl())
          {
            localObject2 = localObject1;
            localObject3 = localObject1;
            paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, w.zck);
            i = 0;
            localObject2 = localObject1;
            localObject3 = localObject1;
            if (i < w.zck.length)
            {
              localObject2 = localObject1;
              localObject3 = localObject1;
              j = paramAttributeSet.getResourceId(i, 0);
              if (j == 0) {
                break label2799;
              }
              localObject2 = localObject1;
              localObject3 = localObject1;
              if (w.zck[i] == 16843379)
              {
                localObject2 = localObject1;
                localObject3 = localObject1;
                ((Button)localObject5).setContentDescription(paramContext.getString(j));
                break label2799;
              }
              localObject2 = localObject1;
              localObject3 = localObject1;
              if (w.zck[i] == 16843088)
              {
                localObject2 = localObject1;
                localObject3 = localObject1;
                ((Button)localObject5).setHint(paramContext.getString(j));
                break label2799;
              }
              localObject2 = localObject1;
              localObject3 = localObject1;
              ((Button)localObject5).setText(paramContext.getString(j));
              break label2799;
            }
            localObject2 = localObject1;
            localObject3 = localObject1;
            paramAttributeSet.recycle();
            localObject4 = localObject1;
            continue;
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
                            break label2024;
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
            localObject5 = (EditText)localObject1;
            localObject2 = localObject1;
            localObject3 = localObject1;
            ((EditText)localObject5).setTextSize(1, f1 * ((EditText)localObject5).getTextSize() / a.getDensity(((EditText)localObject5).getContext()));
            localObject2 = localObject1;
            localObject3 = localObject1;
            paramContext.getAssets();
            localObject2 = localObject1;
            localObject3 = localObject1;
            f.drk();
            localObject2 = localObject1;
            localObject4 = localObject1;
            localObject3 = localObject1;
            if (f.drl())
            {
              localObject2 = localObject1;
              localObject3 = localObject1;
              paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, w.zck);
              i = 0;
              localObject2 = localObject1;
              localObject3 = localObject1;
              if (i < w.zck.length)
              {
                localObject2 = localObject1;
                localObject3 = localObject1;
                j = paramAttributeSet.getResourceId(i, 0);
                if (j == 0) {
                  break label2808;
                }
                localObject2 = localObject1;
                localObject3 = localObject1;
                if (w.zck[i] == 16843379)
                {
                  localObject2 = localObject1;
                  localObject3 = localObject1;
                  ((EditText)localObject5).setContentDescription(paramContext.getString(j));
                  break label2808;
                }
                localObject2 = localObject1;
                localObject3 = localObject1;
                if (w.zck[i] == 16843088)
                {
                  localObject2 = localObject1;
                  localObject3 = localObject1;
                  ((EditText)localObject5).setHint(paramContext.getString(j));
                  break label2808;
                }
                localObject2 = localObject1;
                localObject3 = localObject1;
                ((EditText)localObject5).setText(paramContext.getString(j));
                break label2808;
              }
              localObject2 = localObject1;
              localObject3 = localObject1;
              paramAttributeSet.recycle();
              localObject4 = localObject1;
              continue;
              localObject2 = localObject1;
              localObject3 = localObject1;
              if (!paramString.equals("CheckBox")) {
                break;
              }
              localObject2 = localObject1;
              localObject3 = localObject1;
              localObject5 = (CheckBox)localObject1;
              localObject2 = localObject1;
              localObject3 = localObject1;
              ((CheckBox)localObject5).setTextSize(1, f1 * ((CheckBox)localObject5).getTextSize() / a.getDensity(((CheckBox)localObject5).getContext()));
              localObject2 = localObject1;
              localObject3 = localObject1;
              paramContext.getAssets();
              localObject2 = localObject1;
              localObject3 = localObject1;
              f.drk();
              localObject2 = localObject1;
              localObject4 = localObject1;
              localObject3 = localObject1;
              if (f.drl())
              {
                localObject2 = localObject1;
                localObject3 = localObject1;
                paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, w.zck);
                i = 0;
                localObject2 = localObject1;
                localObject3 = localObject1;
                if (i < w.zck.length)
                {
                  localObject2 = localObject1;
                  localObject3 = localObject1;
                  j = paramAttributeSet.getResourceId(i, 0);
                  if (j == 0) {
                    break label2817;
                  }
                  localObject2 = localObject1;
                  localObject3 = localObject1;
                  if (w.zck[i] == 16843379)
                  {
                    localObject2 = localObject1;
                    localObject3 = localObject1;
                    ((CheckBox)localObject5).setContentDescription(paramContext.getString(j));
                    break label2817;
                  }
                  localObject2 = localObject1;
                  localObject3 = localObject1;
                  if (w.zck[i] == 16843088)
                  {
                    localObject2 = localObject1;
                    localObject3 = localObject1;
                    ((CheckBox)localObject5).setHint(paramContext.getString(j));
                    break label2817;
                  }
                  localObject2 = localObject1;
                  localObject3 = localObject1;
                  ((CheckBox)localObject5).setText(paramContext.getString(j));
                  break label2817;
                }
                localObject2 = localObject1;
                localObject3 = localObject1;
                paramAttributeSet.recycle();
                localObject4 = localObject1;
              }
            }
          }
        }
        localObject2 = localObject1;
        localObject3 = localObject1;
        if (!paramString.equals("ImageView")) {
          break;
        }
        localObject2 = localObject1;
        localObject3 = localObject1;
        localObject5 = (ImageView)localObject1;
        localObject2 = localObject1;
        localObject3 = localObject1;
        paramContext.getAssets();
        localObject2 = localObject1;
        localObject3 = localObject1;
        f.drk();
        localObject2 = localObject1;
        localObject4 = localObject1;
        localObject3 = localObject1;
      } while (!f.drl());
      label1455:
      label1617:
      label2024:
      localObject2 = localObject1;
      label1862:
      label2150:
      localObject3 = localObject1;
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, w.zcl);
      int i = 0;
      for (;;)
      {
        localObject2 = localObject1;
        localObject3 = localObject1;
        if (i < w.zcl.length)
        {
          localObject2 = localObject1;
          localObject3 = localObject1;
          j = paramAttributeSet.getResourceId(i, 0);
          if (j != 0)
          {
            localObject2 = localObject1;
            localObject3 = localObject1;
            if (w.zcl[i] == 16843379)
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
          localObject4 = localObject1;
          break label1257;
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
            localObject4 = localObject1;
            break label1257;
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
            break label1257;
          }
          localObject2 = localObject1;
          localObject3 = localObject1;
          paramContext = (TextView)localObject1;
          localObject2 = localObject1;
          localObject3 = localObject1;
          paramContext.setTextSize(1, f1 * paramContext.getTextSize() / a.getDensity(paramContext.getContext()));
          localObject4 = localObject1;
          break label1257;
          label2738:
          localObject2 = localObject1;
          localObject3 = localObject1;
          ab.w("MicroMsg.MMLayoutInflater", "Inflate view, ClassNotFound ".concat(String.valueOf(paramString)));
          localObject4 = localObject1;
          break label1257;
          label2768:
          break label933;
          label2771:
          localObject1 = localObject2;
          break label118;
          label2778:
          localObject1 = null;
          break;
          label2784:
          f1 = 1.0F;
          break label777;
          label2790:
          i += 1;
          break label1093;
          label2799:
          i += 1;
          break label1455;
          label2808:
          i += 1;
          break label1862;
          label2817:
          i += 1;
          break label2150;
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.w
 * JD-Core Version:    0.7.0.1
 */