package com.tencent.mm.pluginsdk.ui.span;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ClickableSpan;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.comm.c.b;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import java.util.List;

public final class p
{
  static LinkedList<m> YoD;
  private static boolean YoE;
  public static final a YoF;
  public static c YoG;
  
  static
  {
    AppMethodBeat.i(152309);
    YoD = new LinkedList();
    YoE = Util.isOverseasUser(MMApplicationContext.getContext());
    YoF = new a()
    {
      public final void a(v paramAnonymousv)
      {
        AppMethodBeat.i(245163);
        if (p.YoG.ceR()) {}
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousv.Ypx = bool;
          AppMethodBeat.o(245163);
          return;
        }
      }
    };
    YoG = new c()
    {
      public final boolean ceR()
      {
        return false;
      }
    };
    AppMethodBeat.o(152309);
  }
  
  public static SpannableString L(TextView paramTextView)
  {
    AppMethodBeat.i(152304);
    paramTextView = a(paramTextView.getContext(), paramTextView, (int)paramTextView.getTextSize(), null, null);
    AppMethodBeat.o(152304);
    return paramTextView;
  }
  
  private static SpannableString a(Context paramContext, TextView paramTextView, int paramInt, Object paramObject, a parama)
  {
    AppMethodBeat.i(245268);
    paramContext = new v(paramContext);
    paramContext.Ypm = false;
    paramContext.Ypi = false;
    paramContext.Ypj = false;
    paramContext.Ypl = false;
    paramContext.Ypn = false;
    paramContext.Ypq = false;
    paramContext.YpC = true;
    paramContext = paramContext.M(paramTextView);
    paramContext.YpD = paramObject;
    paramContext.YpA = 1;
    paramContext.Ypo = false;
    paramContext.Ypr = false;
    if (parama != null) {
      parama.a(paramContext);
    }
    paramContext = paramContext.b(paramTextView.getText(), paramInt, false);
    AppMethodBeat.o(245268);
    return paramContext;
  }
  
  private static SpannableString a(Context paramContext, TextView paramTextView, int paramInt1, boolean paramBoolean, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(245234);
    paramContext = new v(paramContext);
    paramContext.Ypm = true;
    paramContext.Ypi = true;
    paramContext.Ypj = true;
    paramContext.Ypt = true;
    paramContext.Ypv = true;
    paramContext.YpA = 1;
    paramContext.Ypn = true;
    paramContext.Ypq = false;
    paramContext.YpC = true;
    paramContext = paramContext.M(paramTextView);
    paramContext.Ypo = true;
    paramContext.Ypr = true;
    if (paramObject != null) {
      paramContext.YpD = paramObject;
    }
    paramContext = paramContext.b(paramTextView.getText(), paramInt1, paramBoolean);
    AppMethodBeat.o(245234);
    return paramContext;
  }
  
  private static SpannableString a(Context paramContext, TextView paramTextView, boolean paramBoolean1, int paramInt1, boolean paramBoolean2, int paramInt2, int paramInt3, Object paramObject, a parama)
  {
    AppMethodBeat.i(245230);
    paramContext = new v(paramContext);
    paramContext.Ypm = true;
    paramContext.Ypi = true;
    paramContext.Ypj = paramBoolean1;
    paramContext.Ypl = YoE;
    paramContext.YpA = paramInt2;
    paramContext.Ypn = true;
    paramContext.Ypq = false;
    paramContext.Yps = awW(paramInt2);
    paramContext.YpC = true;
    paramContext.YpD = paramObject;
    paramContext = paramContext.M(paramTextView);
    paramContext.lCR = paramInt3;
    if (paramInt2 == 1)
    {
      paramContext.Ypo = true;
      paramContext.Ypr = true;
    }
    for (;;)
    {
      if (parama != null) {
        parama.a(paramContext);
      }
      paramContext = paramContext.b(paramTextView.getText(), paramInt1, paramBoolean2);
      AppMethodBeat.o(245230);
      return paramContext;
      if (paramInt2 == 2)
      {
        paramContext.Ypo = false;
        paramContext.Ypr = false;
      }
    }
  }
  
  public static SpannableString a(Context paramContext, CharSequence paramCharSequence, int paramInt1, int paramInt2, Object paramObject, a parama)
  {
    AppMethodBeat.i(245243);
    paramContext = a(paramContext, true, paramCharSequence, paramInt1, paramInt2, false, paramObject, parama, -1);
    AppMethodBeat.o(245243);
    return paramContext;
  }
  
  public static SpannableString a(Context paramContext, CharSequence paramCharSequence, int paramInt1, int paramInt2, Object paramObject, String paramString, int paramInt3, a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(245226);
    paramContext = a(paramContext, paramBoolean, paramInt2, paramObject, paramString);
    paramContext.lCR = paramInt3;
    if (parama != null) {
      parama.a(paramContext);
    }
    paramContext = paramContext.b(paramCharSequence, paramInt1, true);
    AppMethodBeat.o(245226);
    return paramContext;
  }
  
  public static SpannableString a(Context paramContext, CharSequence paramCharSequence, int paramInt1, int paramInt2, Object paramObject, boolean paramBoolean)
  {
    AppMethodBeat.i(162013);
    paramContext = new v(paramContext);
    paramContext.Ypm = true;
    paramContext.Ypi = true;
    paramContext.Ypj = true;
    paramContext.Ypl = YoE;
    paramContext.Ypv = true;
    paramContext.YpA = paramInt2;
    paramContext.Ypn = true;
    paramContext.Ypq = false;
    paramContext.YpC = true;
    paramContext.YpD = paramObject;
    paramContext.Ypz = paramBoolean;
    if (paramInt2 == 1)
    {
      paramContext.Ypo = true;
      paramContext.Ypr = true;
    }
    for (;;)
    {
      paramContext = paramContext.b(paramCharSequence, paramInt1, false);
      AppMethodBeat.o(162013);
      return paramContext;
      if (paramInt2 == 2)
      {
        paramContext.Ypo = false;
        paramContext.Ypr = false;
      }
    }
  }
  
  public static SpannableString a(Context paramContext, CharSequence paramCharSequence, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(152294);
    paramContext = a(paramContext, paramCharSequence, paramInt1, paramInt2, false, null, paramBoolean);
    AppMethodBeat.o(152294);
    return paramContext;
  }
  
  private static SpannableString a(Context paramContext, CharSequence paramCharSequence, int paramInt1, int paramInt2, boolean paramBoolean1, Object paramObject, boolean paramBoolean2)
  {
    AppMethodBeat.i(245240);
    paramContext = a(paramContext, paramBoolean2, paramCharSequence, paramInt1, paramInt2, paramBoolean1, paramObject, null, -1);
    AppMethodBeat.o(245240);
    return paramContext;
  }
  
  public static SpannableString a(Context paramContext, CharSequence paramCharSequence, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(152297);
    paramContext = a(paramContext, paramCharSequence, paramInt, 1, paramObject, false);
    AppMethodBeat.o(152297);
    return paramContext;
  }
  
  public static SpannableString a(Context paramContext, CharSequence paramCharSequence, int paramInt, Object paramObject, String paramString)
  {
    AppMethodBeat.i(245220);
    paramContext = a(paramContext, paramCharSequence, paramInt, paramObject, paramString, true);
    AppMethodBeat.o(245220);
    return paramContext;
  }
  
  public static SpannableString a(Context paramContext, CharSequence paramCharSequence, int paramInt, Object paramObject, String paramString, a parama)
  {
    AppMethodBeat.i(245224);
    paramContext = a(paramContext, paramCharSequence, paramInt, 1, paramObject, paramString, 0, parama, true);
    AppMethodBeat.o(245224);
    return paramContext;
  }
  
  public static SpannableString a(Context paramContext, CharSequence paramCharSequence, int paramInt, Object paramObject, String paramString, a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(245227);
    paramContext = a(paramContext, paramBoolean, 1, paramObject, paramString);
    paramContext.Ypi = false;
    if (parama != null) {
      parama.a(paramContext);
    }
    paramContext = paramContext.b(paramCharSequence, paramInt, true);
    AppMethodBeat.o(245227);
    return paramContext;
  }
  
  public static SpannableString a(Context paramContext, CharSequence paramCharSequence, int paramInt, Object paramObject, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(245222);
    paramContext = a(paramContext, paramCharSequence, paramInt, 1, paramObject, paramString, 0, null, paramBoolean);
    AppMethodBeat.o(245222);
    return paramContext;
  }
  
  private static SpannableString a(Context paramContext, CharSequence paramCharSequence, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(152293);
    paramContext = new v(paramContext);
    paramContext.Ypn = false;
    paramContext.Ypo = false;
    paramContext.Ypi = false;
    paramContext.Ypj = false;
    paramContext.Ypq = false;
    paramContext.Ypm = false;
    paramContext.YpC = false;
    paramContext = paramContext.b(paramCharSequence, paramInt, paramBoolean);
    e(paramContext);
    AppMethodBeat.o(152293);
    return paramContext;
  }
  
  public static SpannableString a(Context paramContext, CharSequence paramCharSequence, int paramInt, boolean paramBoolean, Object paramObject)
  {
    AppMethodBeat.i(152277);
    paramContext = new v(paramContext);
    paramContext.Ypt = true;
    paramContext.Ypi = true;
    paramContext.Ypv = true;
    paramContext.YpA = 1;
    paramContext.Ypq = false;
    paramContext.YpC = true;
    paramContext = paramContext.M(null);
    paramContext.Ypo = true;
    paramContext.Ypr = true;
    if (paramObject != null) {
      paramContext.YpD = paramObject;
    }
    paramContext = paramContext.b(paramCharSequence, paramInt, paramBoolean);
    AppMethodBeat.o(152277);
    return paramContext;
  }
  
  public static SpannableString a(Context paramContext, boolean paramBoolean1, CharSequence paramCharSequence, int paramInt1, int paramInt2, boolean paramBoolean2, Object paramObject, a parama, int paramInt3)
  {
    AppMethodBeat.i(245244);
    paramContext = new v(paramContext);
    paramContext.Ypm = paramBoolean1;
    paramContext.Ypi = paramBoolean1;
    paramContext.Ypj = paramBoolean1;
    boolean bool;
    if ((YoE) && (paramBoolean1))
    {
      bool = true;
      paramContext.Ypl = bool;
      paramContext.YpA = paramInt2;
      paramContext.Ypn = paramBoolean1;
      paramContext.Ypq = false;
      paramContext.YpC = true;
      if ((!awW(paramInt2)) || (!paramBoolean1)) {
        break label144;
      }
      paramBoolean1 = true;
      label83:
      paramContext.Yps = paramBoolean1;
      paramContext.YpD = paramObject;
      if (paramInt2 != 1) {
        break label149;
      }
      paramContext.Ypo = true;
      paramContext.Ypr = true;
    }
    label144:
    label149:
    while (paramInt2 != 2)
    {
      if (parama != null) {
        parama.a(paramContext);
      }
      paramContext = paramContext.b(paramCharSequence, paramInt1, true);
      AppMethodBeat.o(245244);
      return paramContext;
      bool = false;
      break;
      paramBoolean1 = false;
      break label83;
    }
    paramContext.Ypo = false;
    paramContext.Ypr = false;
    paramContext.Ypy = paramBoolean2;
    if (paramInt3 != -1) {}
    for (;;)
    {
      paramContext.lCR = paramInt3;
      break;
      paramInt3 = 2;
    }
  }
  
  public static SpannableString a(TextView paramTextView, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(369599);
    paramTextView = b(paramTextView, 2, 2, paramObject);
    AppMethodBeat.o(369599);
    return paramTextView;
  }
  
  public static SpannableString a(TextView paramTextView, int paramInt1, int paramInt2, Object paramObject, a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(245213);
    paramTextView = a(paramTextView, paramInt1, paramInt2, paramObject, parama, paramBoolean, true);
    AppMethodBeat.o(245213);
    return paramTextView;
  }
  
  public static SpannableString a(TextView paramTextView, int paramInt1, int paramInt2, Object paramObject, a parama, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(245215);
    if (paramTextView == null)
    {
      Log.e("MicroMsg.MMSpanManager", "spanForTextView, textView cannot be null!");
      paramTextView = new SpannableString("");
      AppMethodBeat.o(245215);
      return paramTextView;
    }
    paramTextView = a(paramTextView.getContext(), paramTextView, paramBoolean1, (int)paramTextView.getTextSize(), paramBoolean2, paramInt1, paramInt2, paramObject, parama);
    AppMethodBeat.o(245215);
    return paramTextView;
  }
  
  public static SpannableString a(TextView paramTextView, a parama, Object paramObject)
  {
    AppMethodBeat.i(245217);
    if (paramTextView == null)
    {
      Log.e("MicroMsg.MMSpanManager", "spanForTextView, textView cannot be null!");
      paramTextView = new SpannableString("");
      AppMethodBeat.o(245217);
      return paramTextView;
    }
    Object localObject = paramTextView.getContext();
    int i = (int)paramTextView.getTextSize();
    localObject = new v((Context)localObject);
    ((v)localObject).Ypm = true;
    ((v)localObject).Ypi = true;
    ((v)localObject).Ypj = true;
    ((v)localObject).Ypl = YoE;
    ((v)localObject).YpA = 2;
    ((v)localObject).Ypn = true;
    ((v)localObject).Ypq = false;
    ((v)localObject).Yps = awW(2);
    ((v)localObject).YpC = true;
    ((v)localObject).YpD = paramObject;
    paramObject = ((v)localObject).M(paramTextView);
    paramObject.lCR = 2;
    paramObject.mAdTagClickCallback = parama;
    paramObject.mAdTagClickScene = 30;
    paramObject.Ypo = false;
    paramObject.Ypr = false;
    paramTextView = paramObject.b(paramTextView.getText(), i, true);
    AppMethodBeat.o(245217);
    return paramTextView;
  }
  
  public static SpannableString a(TextView paramTextView, Object paramObject)
  {
    AppMethodBeat.i(152278);
    paramTextView = a(paramTextView, true, paramObject);
    AppMethodBeat.o(152278);
    return paramTextView;
  }
  
  public static SpannableString a(TextView paramTextView, Object paramObject, a parama)
  {
    AppMethodBeat.i(245218);
    if (paramTextView == null)
    {
      Log.e("MicroMsg.MMSpanManager", "spanForTextView, textView cannot be null!");
      paramTextView = new SpannableString("");
      AppMethodBeat.o(245218);
      return paramTextView;
    }
    Object localObject = paramTextView.getContext();
    int i = (int)paramTextView.getTextSize();
    localObject = new v((Context)localObject);
    ((v)localObject).Ypm = true;
    ((v)localObject).Ypi = true;
    ((v)localObject).Ypj = true;
    ((v)localObject).Ypl = YoE;
    ((v)localObject).YpA = 1;
    ((v)localObject).Ypn = true;
    ((v)localObject).Ypq = false;
    ((v)localObject).YpC = true;
    localObject = ((v)localObject).M(paramTextView);
    ((v)localObject).YpD = paramObject;
    ((v)localObject).mSessionId = null;
    ((v)localObject).Ypo = true;
    ((v)localObject).Ypr = true;
    if (parama != null) {
      parama.a((v)localObject);
    }
    paramTextView = ((v)localObject).b(paramTextView.getText(), i, true);
    AppMethodBeat.o(245218);
    return paramTextView;
  }
  
  public static SpannableString a(TextView paramTextView, boolean paramBoolean, Object paramObject)
  {
    AppMethodBeat.i(152279);
    if (paramTextView == null)
    {
      Log.e("MicroMsg.MMSpanManager", "spanForTextView, textView cannot be null!");
      paramTextView = new SpannableString("");
      AppMethodBeat.o(152279);
      return paramTextView;
    }
    paramTextView = a(paramTextView.getContext(), paramTextView, (int)paramTextView.getTextSize(), paramBoolean, 1, paramObject);
    AppMethodBeat.o(152279);
    return paramTextView;
  }
  
  public static SpannableStringBuilder a(Context paramContext, CharSequence paramCharSequence1, CharSequence paramCharSequence2, float paramFloat, Drawable paramDrawable)
  {
    AppMethodBeat.i(245283);
    paramContext = a(paramContext, paramCharSequence1, paramCharSequence2, paramFloat, paramDrawable, true);
    AppMethodBeat.o(245283);
    return paramContext;
  }
  
  public static SpannableStringBuilder a(Context paramContext, CharSequence paramCharSequence1, CharSequence paramCharSequence2, float paramFloat, Drawable paramDrawable, boolean paramBoolean)
  {
    AppMethodBeat.i(245285);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    localSpannableStringBuilder.append(paramCharSequence1);
    int i = paramCharSequence1.length();
    if (paramBoolean) {
      localSpannableStringBuilder.append("  ");
    }
    for (;;)
    {
      localSpannableStringBuilder.append(b(paramContext, paramCharSequence2, paramFloat));
      localSpannableStringBuilder.setSpan(new com.tencent.mm.ui.widget.a(paramDrawable, 1), i, i + 1, 17);
      AppMethodBeat.o(245285);
      return localSpannableStringBuilder;
      localSpannableStringBuilder.append(" ");
    }
  }
  
  private static v a(Context paramContext, boolean paramBoolean, int paramInt, Object paramObject, String paramString)
  {
    boolean bool2 = true;
    AppMethodBeat.i(245232);
    paramContext = new v(paramContext);
    paramContext.Ypm = paramBoolean;
    paramContext.Ypi = paramBoolean;
    paramContext.Ypj = paramBoolean;
    boolean bool1;
    if ((YoE) && (paramBoolean))
    {
      bool1 = true;
      paramContext.Ypl = bool1;
      paramContext.YpA = paramInt;
      paramContext.Ypn = paramBoolean;
      paramContext.Ypq = false;
      paramContext.YpC = true;
      paramContext = paramContext.M(null);
      paramContext.YpD = paramObject;
      paramContext.mSessionId = paramString;
      if ((paramInt != 1) && (paramInt != 4)) {
        break label162;
      }
      paramContext.Ypo = true;
      paramContext.Ypr = true;
      label109:
      if ("zh_CN".equals(LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()))) {
        paramContext.Ypp = paramBoolean;
      }
      if ((!awW(paramInt)) || (!paramBoolean)) {
        break label180;
      }
    }
    label162:
    label180:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      paramContext.Yps = paramBoolean;
      AppMethodBeat.o(245232);
      return paramContext;
      bool1 = false;
      break;
      if (paramInt != 2) {
        break label109;
      }
      paramContext.Ypo = false;
      paramContext.Ypr = false;
      break label109;
    }
  }
  
  public static CharSequence a(CharSequence paramCharSequence, Drawable paramDrawable)
  {
    AppMethodBeat.i(245276);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    localSpannableStringBuilder.append(paramCharSequence);
    int i = paramCharSequence.length();
    localSpannableStringBuilder.append(" ");
    localSpannableStringBuilder.setSpan(new com.tencent.mm.ui.widget.a(paramDrawable, 1), i, i + 1, 18);
    AppMethodBeat.o(245276);
    return localSpannableStringBuilder;
  }
  
  public static void a(Context paramContext, List<String> paramList1, String paramString, List<String> paramList2, TextView paramTextView)
  {
    AppMethodBeat.i(245291);
    a(paramContext, paramList1, paramString, paramList2, Boolean.TRUE, paramTextView);
    AppMethodBeat.o(245291);
  }
  
  public static void a(Context paramContext, List<String> paramList1, String paramString, List<String> paramList2, Boolean paramBoolean, TextView paramTextView)
  {
    AppMethodBeat.i(245294);
    SpannableString localSpannableString = new SpannableString(paramString);
    int i = 0;
    while (i < paramList2.size())
    {
      String str = (String)paramList2.get(i);
      int j = paramString.indexOf(str);
      int k = j + str.length();
      if ((j >= 0) && (k <= paramString.length())) {
        localSpannableString.setSpan(new p.b((String)paramList1.get(i), MMApplicationContext.getContext().getResources().getColor(c.b.link_color), MMApplicationContext.getContext().getResources().getColor(c.b.BW_0_Alpha_0_2), paramBoolean.booleanValue(), new p.3(paramContext)), j, k, 17);
      }
      i += 1;
    }
    if (paramTextView != null)
    {
      paramTextView.setText(localSpannableString);
      a(paramTextView, localSpannableString);
    }
    AppMethodBeat.o(245294);
  }
  
  public static void a(TextView paramTextView, Spannable paramSpannable)
  {
    AppMethodBeat.i(245298);
    paramTextView.setOnTouchListener(new p.4(paramSpannable, paramTextView));
    AppMethodBeat.o(245298);
  }
  
  public static void a(m paramm)
  {
    AppMethodBeat.i(152275);
    YoD.add(paramm);
    AppMethodBeat.o(152275);
  }
  
  private static boolean awW(int paramInt)
  {
    AppMethodBeat.i(245237);
    if ((paramInt != 2) && (paramInt == 3)) {}
    com.tencent.mm.plugin.comm.a.a locala = (com.tencent.mm.plugin.comm.a.a)h.ax(com.tencent.mm.plugin.comm.a.a.class);
    if ((locala != null) && (locala.aBu())) {}
    for (boolean bool = false;; bool = true)
    {
      AppMethodBeat.o(245237);
      return bool;
    }
  }
  
  public static SpannableString b(Context paramContext, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(152292);
    paramContext = a(paramContext, paramCharSequence, 0, true);
    AppMethodBeat.o(152292);
    return paramContext;
  }
  
  public static SpannableString b(Context paramContext, CharSequence paramCharSequence, float paramFloat)
  {
    AppMethodBeat.i(152288);
    paramContext = a(paramContext, paramCharSequence, (int)paramFloat, true);
    AppMethodBeat.o(152288);
    return paramContext;
  }
  
  public static SpannableString b(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(245223);
    paramContext = new v(paramContext);
    paramContext.Ypm = false;
    paramContext.Ypi = false;
    paramContext.Ypj = false;
    paramContext.Ypl = YoE;
    paramContext.YpA = 1;
    paramContext.Ypn = false;
    paramContext.Ypq = false;
    paramContext.Yps = awW(1);
    paramContext.YpC = true;
    paramContext.Ypv = true;
    paramContext = paramContext.b(paramCharSequence, paramInt, false);
    AppMethodBeat.o(245223);
    return paramContext;
  }
  
  private static SpannableString b(Context paramContext, CharSequence paramCharSequence, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(152301);
    paramContext = new v(paramContext);
    paramContext.Ypm = false;
    paramContext.Ypi = true;
    paramContext.Ypj = true;
    paramContext.Ypt = true;
    paramContext.Ypu = paramBoolean;
    paramContext.Ypv = true;
    paramContext.YpA = 1;
    paramContext.Ypn = false;
    paramContext.Ypq = false;
    paramContext.Ypo = false;
    paramContext.Ypr = false;
    paramContext.YpC = false;
    paramContext = paramContext.b(paramCharSequence, paramInt, true);
    AppMethodBeat.o(152301);
    return paramContext;
  }
  
  public static SpannableString b(Context paramContext, CharSequence paramCharSequence, int paramInt, boolean paramBoolean, Object paramObject)
  {
    AppMethodBeat.i(245238);
    paramContext = a(paramContext, paramCharSequence, paramInt, 2, paramBoolean, paramObject, true);
    AppMethodBeat.o(245238);
    return paramContext;
  }
  
  private static SpannableString b(TextView paramTextView, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(245211);
    paramTextView = a(paramTextView, paramInt1, paramInt2, paramObject, null, true);
    AppMethodBeat.o(245211);
    return paramTextView;
  }
  
  public static SpannableString b(TextView paramTextView, Object paramObject, a parama)
  {
    AppMethodBeat.i(245262);
    if (paramTextView == null)
    {
      Log.e("MicroMsg.MMSpanManager", "spanForTextView, textView cannot be null!");
      paramTextView = new SpannableString("");
      AppMethodBeat.o(245262);
      return paramTextView;
    }
    paramTextView = a(paramTextView.getContext(), paramTextView, (int)paramTextView.getTextSize(), paramObject, parama);
    AppMethodBeat.o(245262);
    return paramTextView;
  }
  
  public static SpannableStringBuilder b(CharSequence paramCharSequence, Drawable paramDrawable)
  {
    AppMethodBeat.i(245282);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    localSpannableStringBuilder.append(" ");
    localSpannableStringBuilder.setSpan(new com.tencent.mm.ui.widget.a(paramDrawable, 1), 0, 1, 17);
    localSpannableStringBuilder.append(" ");
    localSpannableStringBuilder.append(paramCharSequence);
    AppMethodBeat.o(245282);
    return localSpannableStringBuilder;
  }
  
  public static void b(m paramm)
  {
    AppMethodBeat.i(152276);
    YoD.remove(paramm);
    AppMethodBeat.o(152276);
  }
  
  public static String brr(String paramString)
  {
    AppMethodBeat.i(152302);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(152302);
      return paramString;
    }
    v localv = new v(MMApplicationContext.getContext());
    localv.Ypm = false;
    localv.Ypi = true;
    localv.Ypj = true;
    localv.Ypt = true;
    localv.Ypu = true;
    localv.Ypv = true;
    localv.YpA = 1;
    localv.Ypn = false;
    localv.Ypq = false;
    localv.Ypo = false;
    localv.Ypr = false;
    localv.Ypw = false;
    localv.YpC = false;
    paramString = localv.b(paramString, 0, false).toString();
    AppMethodBeat.o(152302);
    return paramString;
  }
  
  public static SpannableString c(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(152284);
    paramContext = new v(paramContext);
    paramContext.Ypm = true;
    paramContext.Ypi = true;
    paramContext.Ypj = true;
    paramContext.Ypl = YoE;
    paramContext.YpA = 1;
    paramContext.Ypn = true;
    paramContext.Ypq = false;
    paramContext.YpC = false;
    paramContext = paramContext.M(null);
    paramContext.YpD = null;
    paramContext.mSessionId = null;
    paramContext.Ypo = true;
    paramContext.Ypr = true;
    paramContext = paramContext.b(paramCharSequence, paramInt, true);
    AppMethodBeat.o(152284);
    return paramContext;
  }
  
  public static void clearCache()
  {
    AppMethodBeat.i(152303);
    Log.i("MicroMsg.MMSpanManager", "clear MMSpanManager cache");
    v.clearCache();
    AppMethodBeat.o(152303);
  }
  
  public static SpannableString d(Context paramContext, CharSequence paramCharSequence, float paramFloat)
  {
    AppMethodBeat.i(152289);
    paramContext = a(paramContext, paramCharSequence, (int)paramFloat, false);
    AppMethodBeat.o(152289);
    return paramContext;
  }
  
  public static SpannableString d(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(152287);
    paramContext = a(paramContext, paramCharSequence, paramInt, true);
    AppMethodBeat.o(152287);
    return paramContext;
  }
  
  public static SpannableString e(Context paramContext, CharSequence paramCharSequence, float paramFloat)
  {
    AppMethodBeat.i(152300);
    paramContext = b(paramContext, paramCharSequence, (int)paramFloat, false);
    AppMethodBeat.o(152300);
    return paramContext;
  }
  
  public static SpannableString e(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(152290);
    paramContext = new v(paramContext);
    paramContext.Ypn = false;
    paramContext.Ypo = false;
    paramContext.Ypi = false;
    paramContext.Ypj = false;
    paramContext.Ypq = false;
    paramContext.YpA = paramInt;
    paramContext.Ypm = false;
    paramContext.YpC = false;
    paramContext = paramContext.b(paramCharSequence, 0, true);
    e(paramContext);
    AppMethodBeat.o(152290);
    return paramContext;
  }
  
  private static void e(Spannable paramSpannable)
  {
    int i = 0;
    AppMethodBeat.i(152291);
    ClickableSpan[] arrayOfClickableSpan = (ClickableSpan[])paramSpannable.getSpans(0, paramSpannable.length(), ClickableSpan.class);
    while (i < arrayOfClickableSpan.length)
    {
      paramSpannable.removeSpan(arrayOfClickableSpan[i]);
      i += 1;
    }
    AppMethodBeat.o(152291);
  }
  
  public static SpannableString f(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(152296);
    paramContext = new v(paramContext);
    paramContext.Ypm = true;
    paramContext.Ypi = true;
    paramContext.Ypj = true;
    paramContext.Ypl = YoE;
    paramContext.Ypv = true;
    paramContext.YpA = 1;
    paramContext.Ypn = true;
    paramContext.Ypq = false;
    paramContext.YpC = true;
    paramContext.YpD = null;
    paramContext.Ypo = true;
    paramContext.Ypr = true;
    paramContext = paramContext.b(paramCharSequence, paramInt, true);
    AppMethodBeat.o(152296);
    return paramContext;
  }
  
  public static SpannableString g(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(245250);
    paramContext = new v(paramContext);
    paramContext.Ypm = false;
    paramContext.Ypi = true;
    paramContext.Ypj = false;
    paramContext.Ypl = YoE;
    paramContext.Ypv = false;
    paramContext.YpA = 1;
    paramContext.Ypn = true;
    paramContext.Ypq = false;
    paramContext.YpC = true;
    paramContext.Ypo = false;
    paramContext.Ypr = false;
    paramContext = paramContext.b(paramCharSequence, paramInt, true);
    AppMethodBeat.o(245250);
    return paramContext;
  }
  
  public static SpannableString h(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(152299);
    paramContext = b(paramContext, paramCharSequence, paramInt, true);
    AppMethodBeat.o(152299);
    return paramContext;
  }
  
  public static CharSequence i(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(245272);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    localSpannableStringBuilder.append(paramCharSequence);
    int i = paramCharSequence.length();
    localSpannableStringBuilder.append(" ");
    paramContext = paramContext.getResources().getDrawable(paramInt);
    paramContext.setBounds(0, 0, paramContext.getIntrinsicWidth(), paramContext.getIntrinsicHeight());
    paramContext = new com.tencent.mm.ui.widget.a(paramContext, 1);
    paramContext.padding = 0;
    localSpannableStringBuilder.setSpan(paramContext, i, i + 1, 18);
    AppMethodBeat.o(245272);
    return localSpannableStringBuilder;
  }
  
  public static SpannableString j(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(152307);
    paramContext = new v(paramContext);
    paramContext.Ypm = false;
    paramContext.Ypi = true;
    paramContext.Ypj = true;
    paramContext.Ypk = false;
    paramContext.Ypt = false;
    paramContext.Ypu = false;
    paramContext.Ypv = false;
    paramContext.YpA = 1;
    paramContext.Ypn = false;
    paramContext.Ypq = false;
    paramContext.Ypo = false;
    paramContext.Ypr = false;
    paramContext.YpC = true;
    paramContext = paramContext.b(paramCharSequence, paramInt, true);
    AppMethodBeat.o(152307);
    return paramContext;
  }
  
  public static SpannableString t(TextView paramTextView, int paramInt)
  {
    AppMethodBeat.i(152280);
    paramTextView = b(paramTextView, paramInt, 0, null);
    AppMethodBeat.o(152280);
    return paramTextView;
  }
  
  public static SpannableString u(TextView paramTextView, int paramInt)
  {
    AppMethodBeat.i(245207);
    paramTextView = b(paramTextView, 1, paramInt, null);
    AppMethodBeat.o(245207);
    return paramTextView;
  }
  
  public static abstract interface a
  {
    public abstract void a(v paramv);
  }
  
  public static abstract interface c
  {
    public abstract boolean ceR();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.span.p
 * JD-Core Version:    0.7.0.1
 */