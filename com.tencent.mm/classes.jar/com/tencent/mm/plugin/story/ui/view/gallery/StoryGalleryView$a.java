package com.tencent.mm.plugin.story.ui.view.gallery;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.a.f;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.bb;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$Companion;", "", "()V", "ClickCountShowHint", "", "TAG", "", "getTAG", "()Ljava/lang/String;", "getPullDownSpan", "Landroid/text/SpannableString;", "text", "", "color", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class StoryGalleryView$a
{
  public static SpannableString h(CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(120434);
    s.u(paramCharSequence, "text");
    Object localObject = MMApplicationContext.getContext();
    Drawable localDrawable = bb.m((Context)localObject, a.f.story_downward_arrow, paramInt);
    localDrawable.setBounds(0, 0, com.tencent.mm.cd.a.fromDPToPix((Context)localObject, 14), com.tencent.mm.cd.a.fromDPToPix((Context)localObject, 20));
    localObject = new com.tencent.mm.ui.widget.a(localDrawable, 1);
    paramCharSequence = new SpannableString((CharSequence)s.X("#", paramCharSequence));
    paramCharSequence.setSpan(localObject, 0, 1, 17);
    AppMethodBeat.o(120434);
    return paramCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView.a
 * JD-Core Version:    0.7.0.1
 */