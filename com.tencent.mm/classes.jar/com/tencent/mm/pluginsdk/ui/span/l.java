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
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class l
{
  static LinkedList<i> Rsk;
  private static boolean Rsl;
  public static final l.a Rsm;
  public static l.b Rsn;
  
  static
  {
    AppMethodBeat.i(152309);
    Rsk = new LinkedList();
    Rsl = Util.isOverseasUser(MMApplicationContext.getContext());
    Rsm = new l.1();
    Rsn = new l.2();
    AppMethodBeat.o(152309);
  }
  
  public static SpannableString I(TextView paramTextView)
  {
    AppMethodBeat.i(152304);
    paramTextView = a(paramTextView.getContext(), paramTextView, (int)paramTextView.getTextSize(), null, null);
    AppMethodBeat.o(152304);
    return paramTextView;
  }
  
  private static SpannableString a(Context paramContext, TextView paramTextView, int paramInt, Object paramObject, l.a parama)
  {
    AppMethodBeat.i(243099);
    paramContext = new r(paramContext);
    paramContext.RsR = false;
    paramContext.RsN = false;
    paramContext.RsO = false;
    paramContext.RsQ = false;
    paramContext.RsS = false;
    paramContext.RsV = false;
    paramContext.Rth = true;
    paramContext = paramContext.J(paramTextView);
    paramContext.Rti = paramObject;
    paramContext.Rtf = 1;
    paramContext.RsT = false;
    paramContext.RsW = false;
    if (parama != null) {
      parama.a(paramContext);
    }
    paramContext = paramContext.b(paramTextView.getText(), paramInt, false);
    AppMethodBeat.o(243099);
    return paramContext;
  }
  
  private static SpannableString a(Context paramContext, TextView paramTextView, int paramInt1, boolean paramBoolean, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(243066);
    paramContext = new r(paramContext);
    paramContext.RsR = true;
    paramContext.RsN = true;
    paramContext.RsO = true;
    paramContext.RsY = true;
    paramContext.Rta = true;
    paramContext.Rtf = 1;
    paramContext.RsS = true;
    paramContext.RsV = false;
    paramContext.Rth = true;
    paramContext = paramContext.J(paramTextView);
    paramContext.RsT = true;
    paramContext.RsW = true;
    if (paramObject != null) {
      paramContext.Rti = paramObject;
    }
    paramContext = paramContext.b(paramTextView.getText(), paramInt1, paramBoolean);
    AppMethodBeat.o(243066);
    return paramContext;
  }
  
  private static SpannableString a(Context paramContext, TextView paramTextView, boolean paramBoolean1, int paramInt1, boolean paramBoolean2, int paramInt2, int paramInt3, Object paramObject, l.a parama)
  {
    AppMethodBeat.i(243064);
    paramContext = new r(paramContext);
    paramContext.RsR = true;
    paramContext.RsN = true;
    paramContext.RsO = paramBoolean1;
    paramContext.RsQ = Rsl;
    paramContext.Rtf = paramInt2;
    paramContext.RsS = true;
    paramContext.RsV = false;
    paramContext.RsX = aqQ(paramInt2);
    paramContext.Rth = true;
    paramContext.Rti = paramObject;
    paramContext = paramContext.J(paramTextView);
    paramContext.jaR = paramInt3;
    if (paramInt2 == 1)
    {
      paramContext.RsT = true;
      paramContext.RsW = true;
    }
    for (;;)
    {
      if (parama != null) {
        parama.a(paramContext);
      }
      paramContext = paramContext.b(paramTextView.getText(), paramInt1, paramBoolean2);
      AppMethodBeat.o(243064);
      return paramContext;
      if (paramInt2 == 2)
      {
        paramContext.RsT = false;
        paramContext.RsW = false;
      }
    }
  }
  
  public static SpannableString a(Context paramContext, CharSequence paramCharSequence, int paramInt1, int paramInt2, Object paramObject, l.a parama)
  {
    AppMethodBeat.i(243087);
    paramContext = a(paramContext, true, paramCharSequence, paramInt1, paramInt2, false, paramObject, parama);
    AppMethodBeat.o(243087);
    return paramContext;
  }
  
  public static SpannableString a(Context paramContext, CharSequence paramCharSequence, int paramInt1, int paramInt2, Object paramObject, String paramString, int paramInt3, l.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(243058);
    paramContext = a(paramContext, paramBoolean, paramInt2, paramObject, paramString);
    paramContext.jaR = paramInt3;
    if (parama != null) {
      parama.a(paramContext);
    }
    paramContext = paramContext.b(paramCharSequence, paramInt1, true);
    AppMethodBeat.o(243058);
    return paramContext;
  }
  
  public static SpannableString a(Context paramContext, CharSequence paramCharSequence, int paramInt1, int paramInt2, Object paramObject, boolean paramBoolean)
  {
    AppMethodBeat.i(162013);
    paramContext = new r(paramContext);
    paramContext.RsR = true;
    paramContext.RsN = true;
    paramContext.RsO = true;
    paramContext.RsQ = Rsl;
    paramContext.Rta = true;
    paramContext.Rtf = paramInt2;
    paramContext.RsS = true;
    paramContext.RsV = false;
    paramContext.Rth = true;
    paramContext.Rti = paramObject;
    paramContext.Rte = paramBoolean;
    if (paramInt2 == 1)
    {
      paramContext.RsT = true;
      paramContext.RsW = true;
    }
    for (;;)
    {
      paramContext = paramContext.b(paramCharSequence, paramInt1, false);
      AppMethodBeat.o(162013);
      return paramContext;
      if (paramInt2 == 2)
      {
        paramContext.RsT = false;
        paramContext.RsW = false;
      }
    }
  }
  
  private static SpannableString a(Context paramContext, CharSequence paramCharSequence, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(243080);
    paramContext = a(paramContext, paramCharSequence, paramInt1, paramInt2, false, null, paramBoolean);
    AppMethodBeat.o(243080);
    return paramContext;
  }
  
  private static SpannableString a(Context paramContext, CharSequence paramCharSequence, int paramInt1, int paramInt2, boolean paramBoolean1, Object paramObject, boolean paramBoolean2)
  {
    AppMethodBeat.i(243084);
    paramContext = a(paramContext, paramBoolean2, paramCharSequence, paramInt1, paramInt2, paramBoolean1, paramObject, null);
    AppMethodBeat.o(243084);
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
    AppMethodBeat.i(243051);
    paramContext = a(paramContext, paramCharSequence, paramInt, paramObject, paramString, true);
    AppMethodBeat.o(243051);
    return paramContext;
  }
  
  public static SpannableString a(Context paramContext, CharSequence paramCharSequence, int paramInt, Object paramObject, String paramString, l.a parama)
  {
    AppMethodBeat.i(243057);
    paramContext = a(paramContext, paramCharSequence, paramInt, 1, paramObject, paramString, 0, parama, true);
    AppMethodBeat.o(243057);
    return paramContext;
  }
  
  public static SpannableString a(Context paramContext, CharSequence paramCharSequence, int paramInt, Object paramObject, String paramString, l.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(243059);
    paramContext = a(paramContext, paramBoolean, 1, paramObject, paramString);
    paramContext.RsN = false;
    if (parama != null) {
      parama.a(paramContext);
    }
    paramContext = paramContext.b(paramCharSequence, paramInt, true);
    AppMethodBeat.o(243059);
    return paramContext;
  }
  
  public static SpannableString a(Context paramContext, CharSequence paramCharSequence, int paramInt, Object paramObject, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(243053);
    paramContext = a(paramContext, paramCharSequence, paramInt, 1, paramObject, paramString, 0, null, paramBoolean);
    AppMethodBeat.o(243053);
    return paramContext;
  }
  
  private static SpannableString a(Context paramContext, CharSequence paramCharSequence, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(152293);
    paramContext = new r(paramContext);
    paramContext.RsS = false;
    paramContext.RsT = false;
    paramContext.RsN = false;
    paramContext.RsO = false;
    paramContext.RsV = false;
    paramContext.RsR = false;
    paramContext.Rth = false;
    paramContext = paramContext.b(paramCharSequence, paramInt, paramBoolean);
    e(paramContext);
    AppMethodBeat.o(152293);
    return paramContext;
  }
  
  public static SpannableString a(Context paramContext, CharSequence paramCharSequence, int paramInt, boolean paramBoolean, Object paramObject)
  {
    AppMethodBeat.i(152277);
    paramContext = new r(paramContext);
    paramContext.RsY = true;
    paramContext.RsN = true;
    paramContext.Rta = true;
    paramContext.Rtf = 1;
    paramContext.RsV = false;
    paramContext.Rth = true;
    paramContext = paramContext.J(null);
    paramContext.RsT = true;
    paramContext.RsW = true;
    if (paramObject != null) {
      paramContext.Rti = paramObject;
    }
    paramContext = paramContext.b(paramCharSequence, paramInt, paramBoolean);
    AppMethodBeat.o(152277);
    return paramContext;
  }
  
  private static SpannableString a(Context paramContext, boolean paramBoolean1, CharSequence paramCharSequence, int paramInt1, int paramInt2, boolean paramBoolean2, Object paramObject, l.a parama)
  {
    AppMethodBeat.i(243089);
    paramContext = new r(paramContext);
    paramContext.RsR = paramBoolean1;
    paramContext.RsN = paramBoolean1;
    paramContext.RsO = paramBoolean1;
    boolean bool;
    if ((Rsl) && (paramBoolean1))
    {
      bool = true;
      paramContext.RsQ = bool;
      paramContext.Rtf = paramInt2;
      paramContext.RsS = paramBoolean1;
      paramContext.RsV = false;
      paramContext.Rth = true;
      if ((!aqQ(paramInt2)) || (!paramBoolean1)) {
        break label144;
      }
      paramBoolean1 = true;
      label83:
      paramContext.RsX = paramBoolean1;
      paramContext.Rti = paramObject;
      if (paramInt2 != 1) {
        break label149;
      }
      paramContext.RsT = true;
      paramContext.RsW = true;
    }
    for (;;)
    {
      if (parama != null) {
        parama.a(paramContext);
      }
      paramContext = paramContext.b(paramCharSequence, paramInt1, true);
      AppMethodBeat.o(243089);
      return paramContext;
      bool = false;
      break;
      label144:
      paramBoolean1 = false;
      break label83;
      label149:
      if (paramInt2 == 2)
      {
        paramContext.RsT = false;
        paramContext.RsW = false;
        paramContext.Rtd = paramBoolean2;
        paramContext.jaR = 2;
      }
    }
  }
  
  public static SpannableString a(TextView paramTextView, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(293063);
    paramTextView = b(paramTextView, 2, 2, paramObject);
    AppMethodBeat.o(293063);
    return paramTextView;
  }
  
  public static SpannableString a(TextView paramTextView, int paramInt1, int paramInt2, Object paramObject, l.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(243046);
    paramTextView = a(paramTextView, paramInt1, paramInt2, paramObject, parama, paramBoolean, true);
    AppMethodBeat.o(243046);
    return paramTextView;
  }
  
  public static SpannableString a(TextView paramTextView, int paramInt1, int paramInt2, Object paramObject, l.a parama, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(243048);
    if (paramTextView == null)
    {
      Log.e("MicroMsg.MMSpanManager", "spanForTextView, textView cannot be null!");
      paramTextView = new SpannableString("");
      AppMethodBeat.o(243048);
      return paramTextView;
    }
    paramTextView = a(paramTextView.getContext(), paramTextView, paramBoolean1, (int)paramTextView.getTextSize(), paramBoolean2, paramInt1, paramInt2, paramObject, parama);
    AppMethodBeat.o(243048);
    return paramTextView;
  }
  
  public static SpannableString a(TextView paramTextView, a parama, Object paramObject)
  {
    AppMethodBeat.i(243049);
    if (paramTextView == null)
    {
      Log.e("MicroMsg.MMSpanManager", "spanForTextView, textView cannot be null!");
      paramTextView = new SpannableString("");
      AppMethodBeat.o(243049);
      return paramTextView;
    }
    Object localObject = paramTextView.getContext();
    int i = (int)paramTextView.getTextSize();
    localObject = new r((Context)localObject);
    ((r)localObject).RsR = true;
    ((r)localObject).RsN = true;
    ((r)localObject).RsO = true;
    ((r)localObject).RsQ = Rsl;
    ((r)localObject).Rtf = 2;
    ((r)localObject).RsS = true;
    ((r)localObject).RsV = false;
    ((r)localObject).RsX = aqQ(2);
    ((r)localObject).Rth = true;
    ((r)localObject).Rti = paramObject;
    paramObject = ((r)localObject).J(paramTextView);
    paramObject.jaR = 2;
    paramObject.mAdTagClickCallback = parama;
    paramObject.mAdTagClickScene = 30;
    paramObject.RsT = false;
    paramObject.RsW = false;
    paramTextView = paramObject.b(paramTextView.getText(), i, true);
    AppMethodBeat.o(243049);
    return paramTextView;
  }
  
  public static SpannableString a(TextView paramTextView, Object paramObject)
  {
    AppMethodBeat.i(152278);
    paramTextView = a(paramTextView, true, paramObject);
    AppMethodBeat.o(152278);
    return paramTextView;
  }
  
  public static SpannableString a(TextView paramTextView, Object paramObject, l.a parama)
  {
    AppMethodBeat.i(243050);
    if (paramTextView == null)
    {
      Log.e("MicroMsg.MMSpanManager", "spanForTextView, textView cannot be null!");
      paramTextView = new SpannableString("");
      AppMethodBeat.o(243050);
      return paramTextView;
    }
    Object localObject = paramTextView.getContext();
    int i = (int)paramTextView.getTextSize();
    localObject = new r((Context)localObject);
    ((r)localObject).RsR = true;
    ((r)localObject).RsN = true;
    ((r)localObject).RsO = true;
    ((r)localObject).RsQ = Rsl;
    ((r)localObject).Rtf = 1;
    ((r)localObject).RsS = true;
    ((r)localObject).RsV = false;
    ((r)localObject).Rth = true;
    localObject = ((r)localObject).J(paramTextView);
    ((r)localObject).Rti = paramObject;
    ((r)localObject).mSessionId = null;
    ((r)localObject).RsT = true;
    ((r)localObject).RsW = true;
    if (parama != null) {
      parama.a((r)localObject);
    }
    paramTextView = ((r)localObject).b(paramTextView.getText(), i, true);
    AppMethodBeat.o(243050);
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
  
  private static r a(Context paramContext, boolean paramBoolean, int paramInt, Object paramObject, String paramString)
  {
    boolean bool2 = true;
    AppMethodBeat.i(243065);
    paramContext = new r(paramContext);
    paramContext.RsR = paramBoolean;
    paramContext.RsN = paramBoolean;
    paramContext.RsO = paramBoolean;
    boolean bool1;
    if ((Rsl) && (paramBoolean))
    {
      bool1 = true;
      paramContext.RsQ = bool1;
      paramContext.Rtf = paramInt;
      paramContext.RsS = paramBoolean;
      paramContext.RsV = false;
      paramContext.Rth = true;
      paramContext = paramContext.J(null);
      paramContext.Rti = paramObject;
      paramContext.mSessionId = paramString;
      if ((paramInt != 1) && (paramInt != 4)) {
        break label159;
      }
      paramContext.RsT = true;
      paramContext.RsW = true;
      label108:
      if ("zh_CN".equals(LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()))) {
        paramContext.RsU = paramBoolean;
      }
      if ((!aqQ(paramInt)) || (!paramBoolean)) {
        break label177;
      }
    }
    label159:
    label177:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      paramContext.RsX = paramBoolean;
      AppMethodBeat.o(243065);
      return paramContext;
      bool1 = false;
      break;
      if (paramInt != 2) {
        break label108;
      }
      paramContext.RsT = false;
      paramContext.RsW = false;
      break label108;
    }
  }
  
  public static void a(i parami)
  {
    AppMethodBeat.i(152275);
    Rsk.add(parami);
    AppMethodBeat.o(152275);
  }
  
  private static boolean aqQ(int paramInt)
  {
    AppMethodBeat.i(243075);
    if ((paramInt == 2) || (paramInt == 3))
    {
      if (((b)h.ae(b.class)).a(b.a.vRr, 0) == 1)
      {
        AppMethodBeat.o(243075);
        return true;
      }
      AppMethodBeat.o(243075);
      return false;
    }
    if (((b)h.ae(b.class)).a(b.a.vRq, 0) == 1)
    {
      AppMethodBeat.o(243075);
      return true;
    }
    AppMethodBeat.o(243075);
    return false;
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
    AppMethodBeat.i(243055);
    paramContext = new r(paramContext);
    paramContext.RsR = false;
    paramContext.RsN = false;
    paramContext.RsO = false;
    paramContext.RsQ = Rsl;
    paramContext.Rtf = 1;
    paramContext.RsS = false;
    paramContext.RsV = false;
    paramContext.RsX = aqQ(1);
    paramContext.Rth = true;
    paramContext.Rta = true;
    paramContext = paramContext.b(paramCharSequence, paramInt, false);
    AppMethodBeat.o(243055);
    return paramContext;
  }
  
  public static SpannableString b(Context paramContext, CharSequence paramCharSequence, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(152294);
    paramContext = a(paramContext, paramCharSequence, paramInt1, paramInt2, paramBoolean);
    AppMethodBeat.o(152294);
    return paramContext;
  }
  
  private static SpannableString b(Context paramContext, CharSequence paramCharSequence, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(152301);
    paramContext = new r(paramContext);
    paramContext.RsR = false;
    paramContext.RsN = true;
    paramContext.RsO = true;
    paramContext.RsY = true;
    paramContext.RsZ = paramBoolean;
    paramContext.Rta = true;
    paramContext.Rtf = 1;
    paramContext.RsS = false;
    paramContext.RsV = false;
    paramContext.RsT = false;
    paramContext.RsW = false;
    paramContext.Rth = false;
    paramContext = paramContext.b(paramCharSequence, paramInt, true);
    AppMethodBeat.o(152301);
    return paramContext;
  }
  
  public static SpannableString b(Context paramContext, CharSequence paramCharSequence, int paramInt, boolean paramBoolean, Object paramObject)
  {
    AppMethodBeat.i(243082);
    paramContext = a(paramContext, paramCharSequence, paramInt, 2, paramBoolean, paramObject, true);
    AppMethodBeat.o(243082);
    return paramContext;
  }
  
  private static SpannableString b(TextView paramTextView, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(243045);
    paramTextView = a(paramTextView, paramInt1, paramInt2, paramObject, null, true);
    AppMethodBeat.o(243045);
    return paramTextView;
  }
  
  public static SpannableString b(TextView paramTextView, Object paramObject, l.a parama)
  {
    AppMethodBeat.i(243098);
    if (paramTextView == null)
    {
      Log.e("MicroMsg.MMSpanManager", "spanForTextView, textView cannot be null!");
      paramTextView = new SpannableString("");
      AppMethodBeat.o(243098);
      return paramTextView;
    }
    paramTextView = a(paramTextView.getContext(), paramTextView, (int)paramTextView.getTextSize(), paramObject, parama);
    AppMethodBeat.o(243098);
    return paramTextView;
  }
  
  public static void b(i parami)
  {
    AppMethodBeat.i(152276);
    Rsk.remove(parami);
    AppMethodBeat.o(152276);
  }
  
  public static String brD(String paramString)
  {
    AppMethodBeat.i(152302);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(152302);
      return paramString;
    }
    r localr = new r(MMApplicationContext.getContext());
    localr.RsR = false;
    localr.RsN = true;
    localr.RsO = true;
    localr.RsY = true;
    localr.RsZ = true;
    localr.Rta = true;
    localr.Rtf = 1;
    localr.RsS = false;
    localr.RsV = false;
    localr.RsT = false;
    localr.RsW = false;
    localr.Rtb = false;
    localr.Rth = false;
    paramString = localr.b(paramString, 0, false).toString();
    AppMethodBeat.o(152302);
    return paramString;
  }
  
  public static SpannableString c(Context paramContext, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(152292);
    paramContext = a(paramContext, paramCharSequence, 0, true);
    AppMethodBeat.o(152292);
    return paramContext;
  }
  
  public static SpannableString c(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(152284);
    paramContext = new r(paramContext);
    paramContext.RsR = true;
    paramContext.RsN = true;
    paramContext.RsO = true;
    paramContext.RsQ = Rsl;
    paramContext.Rtf = 1;
    paramContext.RsS = true;
    paramContext.RsV = false;
    paramContext.Rth = false;
    paramContext = paramContext.J(null);
    paramContext.Rti = null;
    paramContext.mSessionId = null;
    paramContext.RsT = true;
    paramContext.RsW = true;
    paramContext = paramContext.b(paramCharSequence, paramInt, true);
    AppMethodBeat.o(152284);
    return paramContext;
  }
  
  public static void clearCache()
  {
    AppMethodBeat.i(152303);
    Log.i("MicroMsg.MMSpanManager", "clear MMSpanManager cache");
    r.clearCache();
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
    paramContext = new r(paramContext);
    paramContext.RsS = false;
    paramContext.RsT = false;
    paramContext.RsN = false;
    paramContext.RsO = false;
    paramContext.RsV = false;
    paramContext.Rtf = paramInt;
    paramContext.RsR = false;
    paramContext.Rth = false;
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
    AppMethodBeat.i(152295);
    paramContext = a(paramContext, paramCharSequence, paramInt, 1, true);
    AppMethodBeat.o(152295);
    return paramContext;
  }
  
  public static SpannableString g(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(152296);
    paramContext = new r(paramContext);
    paramContext.RsR = true;
    paramContext.RsN = true;
    paramContext.RsO = true;
    paramContext.RsQ = Rsl;
    paramContext.Rta = true;
    paramContext.Rtf = 1;
    paramContext.RsS = true;
    paramContext.RsV = false;
    paramContext.Rth = true;
    paramContext.Rti = null;
    paramContext.RsT = true;
    paramContext.RsW = true;
    paramContext = paramContext.b(paramCharSequence, paramInt, true);
    AppMethodBeat.o(152296);
    return paramContext;
  }
  
  public static SpannableString h(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(243091);
    paramContext = new r(paramContext);
    paramContext.RsR = false;
    paramContext.RsN = true;
    paramContext.RsO = false;
    paramContext.RsQ = Rsl;
    paramContext.Rta = false;
    paramContext.Rtf = 1;
    paramContext.RsS = true;
    paramContext.RsV = false;
    paramContext.Rth = true;
    paramContext.RsT = false;
    paramContext.RsW = false;
    paramContext = paramContext.b(paramCharSequence, paramInt, true);
    AppMethodBeat.o(243091);
    return paramContext;
  }
  
  public static SpannableString i(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(152299);
    paramContext = b(paramContext, paramCharSequence, paramInt, true);
    AppMethodBeat.o(152299);
    return paramContext;
  }
  
  public static CharSequence j(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(243100);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    localSpannableStringBuilder.append(paramCharSequence);
    int i = paramCharSequence.length();
    localSpannableStringBuilder.append(" ");
    paramContext = paramContext.getResources().getDrawable(paramInt);
    paramContext.setBounds(0, 0, paramContext.getIntrinsicWidth(), paramContext.getIntrinsicHeight());
    localSpannableStringBuilder.setSpan(new com.tencent.mm.ui.widget.a(paramContext, 1), i, i + 1, 18);
    AppMethodBeat.o(243100);
    return localSpannableStringBuilder;
  }
  
  public static SpannableString k(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(152307);
    paramContext = new r(paramContext);
    paramContext.RsR = false;
    paramContext.RsN = true;
    paramContext.RsO = true;
    paramContext.RsP = false;
    paramContext.RsY = false;
    paramContext.RsZ = false;
    paramContext.Rta = false;
    paramContext.Rtf = 1;
    paramContext.RsS = false;
    paramContext.RsV = false;
    paramContext.RsT = false;
    paramContext.RsW = false;
    paramContext.Rth = true;
    paramContext = paramContext.b(paramCharSequence, paramInt, true);
    AppMethodBeat.o(152307);
    return paramContext;
  }
  
  public static SpannableString q(TextView paramTextView, int paramInt)
  {
    AppMethodBeat.i(152280);
    paramTextView = b(paramTextView, paramInt, 0, null);
    AppMethodBeat.o(152280);
    return paramTextView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.span.l
 * JD-Core Version:    0.7.0.1
 */