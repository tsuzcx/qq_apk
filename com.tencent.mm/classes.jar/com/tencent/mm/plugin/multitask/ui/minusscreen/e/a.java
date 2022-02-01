package com.tencent.mm.plugin.multitask.ui.minusscreen.e;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.m.a;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ar;
import kotlin.t;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/ui/minusscreen/utils/MultiTaskViewUtils;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "calcTextWidth", "", "context", "Landroid/content/Context;", "length", "checkTitle", "title", "MAX_SHOW_TITLE_COUNT", "getFileResIcon", "fileExt", "getMultiTaskResIcon", "viewType", "getNickName", "", "tv", "Landroid/widget/TextView;", "spanText", "maxNameCount", "setAuthIcon", "", "view", "Landroid/widget/ImageView;", "authIconType", "authIconUrl", "ui-multitask_release"})
public final class a
{
  public static final a Aep;
  private static final String TAG = "MicroMsg.MinusScreen.ViewUtils";
  
  static
  {
    AppMethodBeat.i(236508);
    Aep = new a();
    TAG = "MicroMsg.MinusScreen.ViewUtils";
    AppMethodBeat.o(236508);
  }
  
  public static int RR(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return 2131690579;
    case 1: 
      return 2131690606;
    case 22: 
      return 2131690648;
    case 3: 
      return 2131689821;
    case 4: 
      return 2131690536;
    }
    return 2131690625;
  }
  
  private static int Z(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(236504);
    kotlin.g.b.p.h(paramContext, "context");
    paramInt = com.tencent.mm.cb.a.fromDPToPix(paramContext, paramInt * 12 + 1);
    AppMethodBeat.o(236504);
    return paramInt;
  }
  
  public static CharSequence a(TextView paramTextView, CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(236505);
    kotlin.g.b.p.h(paramTextView, "tv");
    kotlin.g.b.p.h(paramCharSequence, "spanText");
    Object localObject = paramTextView.getContext();
    kotlin.g.b.p.g(localObject, "tv.context");
    int i = Z((Context)localObject, paramInt);
    localObject = paramTextView.getContext();
    kotlin.g.b.p.g(localObject, "tv.context");
    paramInt = Z((Context)localObject, paramInt + 1);
    localObject = new StaticLayout(paramCharSequence, 0, paramCharSequence.length(), paramTextView.getPaint(), i, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
    if (new StaticLayout(paramCharSequence, 0, paramCharSequence.length(), paramTextView.getPaint(), paramInt, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true).getLineCount() <= 1)
    {
      AppMethodBeat.o(236505);
      return paramCharSequence;
    }
    paramInt = ((StaticLayout)localObject).getLineEnd(0);
    paramTextView = paramTextView.getContext();
    localObject = new StringBuilder();
    paramCharSequence = paramCharSequence.toString();
    if (paramCharSequence == null)
    {
      paramTextView = new t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(236505);
      throw paramTextView;
    }
    paramCharSequence = paramCharSequence.substring(0, paramInt);
    kotlin.g.b.p.g(paramCharSequence, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    paramTextView = com.tencent.mm.pluginsdk.ui.span.l.c(paramTextView, (CharSequence)(paramCharSequence + "..."));
    kotlin.g.b.p.g(paramTextView, "MMSpanManager.spanForSmi…0, ellipseStart) + \"...\")");
    paramTextView = (CharSequence)paramTextView;
    AppMethodBeat.o(236505);
    return paramTextView;
  }
  
  public static void a(ImageView paramImageView, int paramInt, String paramString)
  {
    AppMethodBeat.i(236506);
    kotlin.g.b.p.h(paramImageView, "view");
    paramImageView.setVisibility(8);
    Object localObject = paramImageView.getDrawable();
    if (localObject != null) {
      ((Drawable)localObject).setColorFilter(null);
    }
    Log.i(TAG, "authType = " + paramInt + ", authIconUrl = " + paramString);
    paramImageView.setVisibility(0);
    if (paramInt > 0)
    {
      switch (paramInt)
      {
      default: 
        paramImageView.setVisibility(8);
        AppMethodBeat.o(236506);
        return;
      case 1: 
        localObject = (CharSequence)paramString;
        if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
        for (paramInt = 1; paramInt == 0; paramInt = 0)
        {
          localObject = m.uJa;
          localObject = m.djY();
          paramString = new com.tencent.mm.plugin.finder.loader.p(paramString, x.vEn);
          m localm = m.uJa;
          ((com.tencent.mm.loader.d)localObject).a(paramString, paramImageView, m.a(m.a.uJb));
          AppMethodBeat.o(236506);
          return;
        }
        paramImageView.setImageDrawable(ar.m(paramImageView.getContext(), 2131690678, com.tencent.mm.cb.a.n(paramImageView.getContext(), 2131100919)));
        AppMethodBeat.o(236506);
        return;
      case 2: 
        paramImageView.setImageResource(2131690679);
        AppMethodBeat.o(236506);
        return;
      }
      paramImageView.setVisibility(8);
      AppMethodBeat.o(236506);
      return;
    }
    paramImageView.setVisibility(8);
    AppMethodBeat.o(236506);
  }
  
  public static int aGN(String paramString)
  {
    AppMethodBeat.i(236507);
    Integer localInteger = com.tencent.mm.plugin.ball.f.d.agX(paramString);
    paramString = localInteger;
    if (localInteger == null) {
      paramString = com.tencent.mm.plugin.ball.f.d.agX("unknown");
    }
    kotlin.g.b.p.g(paramString, "iconRes");
    int i = paramString.intValue();
    AppMethodBeat.o(236507);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.minusscreen.e.a
 * JD-Core Version:    0.7.0.1
 */