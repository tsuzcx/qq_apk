package com.tencent.mm.plugin.multitask.ui.minusscreen.e;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.plugin.finder.loader.x;
import com.tencent.mm.plugin.finder.storage.u;
import com.tencent.mm.plugin.multitask.ui.e.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ai.a;
import com.tencent.mm.ui.ai.e;
import com.tencent.mm.ui.au;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/ui/minusscreen/utils/MultiTaskViewUtils;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "calcTextWidth", "", "context", "Landroid/content/Context;", "length", "checkTitle", "title", "MAX_SHOW_TITLE_COUNT", "getFileResIcon", "fileExt", "getMultiTaskResIcon", "viewType", "getNickName", "", "tv", "Landroid/widget/TextView;", "spanText", "maxNameCount", "setAuthIcon", "", "view", "Landroid/widget/ImageView;", "authIconType", "authIconUrl", "ui-multitask_release"})
public final class a
{
  public static final a FKR;
  private static final String TAG = "MicroMsg.MinusScreen.ViewUtils";
  
  static
  {
    AppMethodBeat.i(196108);
    FKR = new a();
    TAG = "MicroMsg.MinusScreen.ViewUtils";
    AppMethodBeat.o(196108);
  }
  
  public static int Yj(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return ai.e.icons_filled_link;
    case 1: 
      return ai.e.icons_filled_mini_program2;
    case 22: 
      return ai.e.icons_filled_play2;
    case 2: 
      return ai.e.icons_filled_link;
    case 3: 
      return ai.e.bottomsheet_icon_fav;
    case 4: 
      return e.e.icons_filled_documentation;
    }
    return ai.e.icons_filled_news;
  }
  
  public static CharSequence a(TextView paramTextView, CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(196092);
    p.k(paramTextView, "tv");
    p.k(paramCharSequence, "spanText");
    Object localObject = paramTextView.getContext();
    p.j(localObject, "tv.context");
    int i = ae((Context)localObject, paramInt);
    localObject = paramTextView.getContext();
    p.j(localObject, "tv.context");
    paramInt = ae((Context)localObject, paramInt + 1);
    localObject = new StaticLayout(paramCharSequence, 0, paramCharSequence.length(), paramTextView.getPaint(), i, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
    if (new StaticLayout(paramCharSequence, 0, paramCharSequence.length(), paramTextView.getPaint(), paramInt, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true).getLineCount() <= 1)
    {
      AppMethodBeat.o(196092);
      return paramCharSequence;
    }
    paramInt = ((StaticLayout)localObject).getLineEnd(0);
    paramTextView = paramTextView.getContext();
    localObject = new StringBuilder();
    paramCharSequence = paramCharSequence.toString();
    if (paramCharSequence == null)
    {
      paramTextView = new kotlin.t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(196092);
      throw paramTextView;
    }
    paramCharSequence = paramCharSequence.substring(0, paramInt);
    p.j(paramCharSequence, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    paramTextView = com.tencent.mm.pluginsdk.ui.span.l.c(paramTextView, (CharSequence)(paramCharSequence + "..."));
    p.j(paramTextView, "MMSpanManager.spanForSmi…0, ellipseStart) + \"...\")");
    paramTextView = (CharSequence)paramTextView;
    AppMethodBeat.o(196092);
    return paramTextView;
  }
  
  public static void a(ImageView paramImageView, int paramInt, String paramString)
  {
    AppMethodBeat.i(196101);
    p.k(paramImageView, "view");
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
        AppMethodBeat.o(196101);
        return;
      case 1: 
        localObject = (CharSequence)paramString;
        if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
        for (paramInt = 1; paramInt == 0; paramInt = 0)
        {
          localObject = com.tencent.mm.plugin.finder.loader.t.ztT;
          localObject = com.tencent.mm.plugin.finder.loader.t.dJe();
          paramString = new x(paramString, u.Aly);
          com.tencent.mm.plugin.finder.loader.t localt = com.tencent.mm.plugin.finder.loader.t.ztT;
          ((com.tencent.mm.loader.d)localObject).a(paramString, paramImageView, com.tencent.mm.plugin.finder.loader.t.a(t.a.ztU));
          AppMethodBeat.o(196101);
          return;
        }
        paramImageView.setImageDrawable(au.o(paramImageView.getContext(), ai.e.icons_filled_star_identify, com.tencent.mm.ci.a.w(paramImageView.getContext(), ai.a.orange_100)));
        AppMethodBeat.o(196101);
        return;
      case 2: 
        paramImageView.setImageResource(ai.e.icons_filled_star_identify_enterprise);
        AppMethodBeat.o(196101);
        return;
      }
      paramImageView.setVisibility(8);
      AppMethodBeat.o(196101);
      return;
    }
    paramImageView.setVisibility(8);
    AppMethodBeat.o(196101);
  }
  
  public static int aRc(String paramString)
  {
    AppMethodBeat.i(196102);
    Integer localInteger = com.tencent.mm.plugin.ball.f.d.aoD(paramString);
    paramString = localInteger;
    if (localInteger == null) {
      paramString = com.tencent.mm.plugin.ball.f.d.aoD("unknown");
    }
    p.j(paramString, "iconRes");
    int i = paramString.intValue();
    AppMethodBeat.o(196102);
    return i;
  }
  
  private static int ae(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(196087);
    p.k(paramContext, "context");
    paramInt = com.tencent.mm.ci.a.fromDPToPix(paramContext, paramInt * 12 + 1);
    AppMethodBeat.o(196087);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.minusscreen.e.a
 * JD-Core Version:    0.7.0.1
 */