package com.tencent.mm.plugin.whatsnew.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.a.ab;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/whatsnew/ui/WhatsNewSubtitlesView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "adjustViews", "", "position", "ratio", "", "attachImages", "imageIds", "", "select", "Companion", "app_release"})
public final class WhatsNewSubtitlesView
  extends FrameLayout
{
  public static final a JPe;
  
  static
  {
    AppMethodBeat.i(230978);
    JPe = new a((byte)0);
    AppMethodBeat.o(230978);
  }
  
  public WhatsNewSubtitlesView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, (byte)0);
  }
  
  public WhatsNewSubtitlesView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(230977);
    setClipChildren(false);
    setClipToPadding(false);
    AppMethodBeat.o(230977);
  }
  
  public final void y(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(230976);
    if (paramInt >= getChildCount() - 1)
    {
      AppMethodBeat.o(230976);
      return;
    }
    int k = a.fromDPToPix(getContext(), 200);
    Object localObject2 = (Iterable)kotlin.k.j.mY(0, getChildCount());
    Object localObject1 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      i = ((ab)localObject2).nextInt();
      ((Collection)localObject1).add(((WhatsNewSubtitlesView)this).getChildAt(i));
    }
    localObject1 = ((Iterable)localObject1).iterator();
    int i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      int j = i + 1;
      if (i < 0) {
        kotlin.a.j.hxH();
      }
      localObject2 = (View)localObject2;
      float f;
      if (i == paramInt)
      {
        p.g(localObject2, "childView");
        ((View)localObject2).setVisibility(0);
        if (paramFloat < 0.571429F)
        {
          f = paramFloat / 0.571429F;
          ((View)localObject2).setAlpha(1.0F - f);
          ((View)localObject2).setTranslationX(f * -k);
          i = j;
        }
        else
        {
          ((View)localObject2).setAlpha(0.0F);
          ((View)localObject2).setTranslationX(-k);
          i = j;
        }
      }
      else if (i == paramInt + 1)
      {
        p.g(localObject2, "childView");
        ((View)localObject2).setVisibility(0);
        if (paramFloat > 0.571429F)
        {
          f = (paramFloat - 0.571429F) / 0.428571F;
          ((View)localObject2).setAlpha(f);
          ((View)localObject2).setTranslationX((1.0F - f) * k);
          i = j;
        }
        else
        {
          ((View)localObject2).setAlpha(0.0F);
          ((View)localObject2).setTranslationX(k);
          i = j;
        }
      }
      else
      {
        p.g(localObject2, "childView");
        ((View)localObject2).setVisibility(8);
        i = j;
      }
    }
    AppMethodBeat.o(230976);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/whatsnew/ui/WhatsNewSubtitlesView$Companion;", "", "()V", "TAG", "", "app_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.whatsnew.ui.WhatsNewSubtitlesView
 * JD-Core Version:    0.7.0.1
 */