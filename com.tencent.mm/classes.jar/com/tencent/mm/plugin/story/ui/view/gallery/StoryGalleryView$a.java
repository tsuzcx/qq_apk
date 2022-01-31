package com.tencent.mm.plugin.story.ui.view.gallery;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.aj;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$Companion;", "", "()V", "ClickCountShowHint", "", "TAG", "", "getTAG", "()Ljava/lang/String;", "getPullDownSpan", "Landroid/text/SpannableString;", "text", "", "color", "plugin-story_release"})
public final class StoryGalleryView$a
{
  public static SpannableString m(CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(110784);
    j.q(paramCharSequence, "text");
    Object localObject = ah.getContext();
    Drawable localDrawable = aj.g((Context)localObject, 2131232064, paramInt);
    localDrawable.setBounds(0, 0, com.tencent.mm.cb.a.fromDPToPix((Context)localObject, 14), com.tencent.mm.cb.a.fromDPToPix((Context)localObject, 20));
    localObject = new com.tencent.mm.ui.widget.a(localDrawable);
    paramCharSequence = new SpannableString((CharSequence)("#" + paramCharSequence));
    paramCharSequence.setSpan(localObject, 0, 1, 17);
    AppMethodBeat.o(110784);
    return paramCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView.a
 * JD-Core Version:    0.7.0.1
 */