package com.tencent.mm.plugin.story.ui.view.gallery;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.am;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$Companion;", "", "()V", "ClickCountShowHint", "", "TAG", "", "getTAG", "()Ljava/lang/String;", "getPullDownSpan", "Landroid/text/SpannableString;", "text", "", "color", "plugin-story_release"})
public final class StoryGalleryView$a
{
  public static SpannableString m(CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(120434);
    k.h(paramCharSequence, "text");
    Object localObject = aj.getContext();
    Drawable localDrawable = am.i((Context)localObject, 2131691257, paramInt);
    localDrawable.setBounds(0, 0, com.tencent.mm.cd.a.fromDPToPix((Context)localObject, 14), com.tencent.mm.cd.a.fromDPToPix((Context)localObject, 20));
    localObject = new com.tencent.mm.ui.widget.a(localDrawable);
    paramCharSequence = new SpannableString((CharSequence)("#" + paramCharSequence));
    paramCharSequence.setSpan(localObject, 0, 1, 17);
    AppMethodBeat.o(120434);
    return paramCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView.a
 * JD-Core Version:    0.7.0.1
 */