package com.tencent.mm.plugin.multitask.ui.minusscreen.e;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.plugin.multitask.ui.e.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.am.a;
import com.tencent.mm.ui.am.f;
import com.tencent.mm.ui.bb;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/ui/minusscreen/utils/MultiTaskViewUtils;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "calcTextWidth", "", "context", "Landroid/content/Context;", "length", "checkTitle", "title", "MAX_SHOW_TITLE_COUNT", "getFileResIcon", "fileExt", "getMultiTaskResIcon", "viewType", "getNickName", "", "tv", "Landroid/widget/TextView;", "spanText", "maxNameCount", "setAuthIcon", "", "view", "Landroid/widget/ImageView;", "authIconType", "authIconUrl", "ui-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a LGc;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(304468);
    LGc = new a();
    TAG = "MicroMsg.MinusScreen.ViewUtils";
    AppMethodBeat.o(304468);
  }
  
  public static CharSequence a(TextView paramTextView, CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(304446);
    kotlin.g.b.s.u(paramTextView, "tv");
    kotlin.g.b.s.u(paramCharSequence, "spanText");
    Object localObject = paramTextView.getContext();
    kotlin.g.b.s.s(localObject, "tv.context");
    int i = ao((Context)localObject, paramInt);
    localObject = paramTextView.getContext();
    kotlin.g.b.s.s(localObject, "tv.context");
    paramInt = ao((Context)localObject, paramInt + 1);
    localObject = new StaticLayout(paramCharSequence, 0, paramCharSequence.length(), paramTextView.getPaint(), i, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
    if (new StaticLayout(paramCharSequence, 0, paramCharSequence.length(), paramTextView.getPaint(), paramInt, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true).getLineCount() <= 1)
    {
      AppMethodBeat.o(304446);
      return paramCharSequence;
    }
    paramInt = ((StaticLayout)localObject).getLineEnd(0);
    paramTextView = paramTextView.getContext();
    paramCharSequence = paramCharSequence.toString();
    if (paramCharSequence == null)
    {
      paramTextView = new NullPointerException("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(304446);
      throw paramTextView;
    }
    paramCharSequence = paramCharSequence.substring(0, paramInt);
    kotlin.g.b.s.s(paramCharSequence, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    paramTextView = com.tencent.mm.pluginsdk.ui.span.p.b(paramTextView, (CharSequence)kotlin.g.b.s.X(paramCharSequence, "..."));
    kotlin.g.b.s.s(paramTextView, "{\n            val ellips…Start) + \"...\")\n        }");
    paramTextView = (CharSequence)paramTextView;
    AppMethodBeat.o(304446);
    return paramTextView;
  }
  
  public static int aNU(String paramString)
  {
    AppMethodBeat.i(304459);
    Integer localInteger = com.tencent.mm.plugin.ball.f.d.ahZ(paramString);
    paramString = localInteger;
    if (localInteger == null) {
      paramString = com.tencent.mm.plugin.ball.f.d.ahZ("unknown");
    }
    kotlin.g.b.s.s(paramString, "iconRes");
    int i = ((Number)paramString).intValue();
    AppMethodBeat.o(304459);
    return i;
  }
  
  public static int acv(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return am.f.icons_filled_link;
    case 1: 
      return am.f.icons_filled_mini_program2;
    case 22: 
      return am.f.icons_filled_play2;
    case 2: 
      return am.f.icons_filled_link;
    case 3: 
      return am.f.bottomsheet_icon_fav;
    case 4: 
      return e.e.icons_filled_documentation;
    }
    return am.f.icons_filled_news;
  }
  
  private static int ao(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(304436);
    kotlin.g.b.s.u(paramContext, "context");
    paramInt = com.tencent.mm.cd.a.fromDPToPix(paramContext, paramInt * 12 + 1);
    AppMethodBeat.o(304436);
    return paramInt;
  }
  
  public static void b(ImageView paramImageView, int paramInt, String paramString)
  {
    AppMethodBeat.i(304454);
    kotlin.g.b.s.u(paramImageView, "view");
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
        AppMethodBeat.o(304454);
        return;
      case 1: 
        localObject = (CharSequence)paramString;
        if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
        for (paramInt = 1; paramInt == 0; paramInt = 0)
        {
          localObject = com.tencent.mm.plugin.finder.loader.p.ExI;
          localObject = com.tencent.mm.plugin.finder.loader.p.eCl();
          paramString = new com.tencent.mm.plugin.finder.loader.s(paramString, v.FKY);
          com.tencent.mm.plugin.finder.loader.p localp = com.tencent.mm.plugin.finder.loader.p.ExI;
          ((com.tencent.mm.loader.d)localObject).a(paramString, paramImageView, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExJ));
          AppMethodBeat.o(304454);
          return;
        }
        paramImageView.setImageDrawable(bb.m(paramImageView.getContext(), am.f.icons_filled_star_identify, com.tencent.mm.cd.a.w(paramImageView.getContext(), am.a.orange_100)));
        AppMethodBeat.o(304454);
        return;
      case 2: 
        paramImageView.setImageResource(am.f.icons_filled_star_identify_enterprise);
        AppMethodBeat.o(304454);
        return;
      }
      paramImageView.setVisibility(8);
      AppMethodBeat.o(304454);
      return;
    }
    paramImageView.setVisibility(8);
    AppMethodBeat.o(304454);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.minusscreen.e.a
 * JD-Core Version:    0.7.0.1
 */