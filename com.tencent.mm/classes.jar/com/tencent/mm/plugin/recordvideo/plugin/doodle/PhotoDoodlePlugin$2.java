package com.tencent.mm.plugin.recordvideo.plugin.doodle;

import a.a.j;
import a.l;
import a.v;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "a", "Landroid/widget/AdapterView;", "kotlin.jvm.PlatformType", "b", "Landroid/view/View;", "position", "", "d", "", "onItemClick"})
final class PhotoDoodlePlugin$2
  implements AdapterView.OnItemClickListener
{
  PhotoDoodlePlugin$2(PhotoDoodlePlugin paramPhotoDoodlePlugin) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(150764);
    if (paramView == null)
    {
      paramAdapterView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
      AppMethodBeat.o(150764);
      throw paramAdapterView;
    }
    if (((ClickBigImageView)paramView).getType() == PhotoDoodlePlugin.a(this.qdx))
    {
      PhotoDoodlePlugin.b(this.qdx, ((ClickBigImageView)paramView).getType());
      AppMethodBeat.o(150764);
      return;
    }
    PhotoDoodlePlugin.a(this.qdx, ((ClickBigImageView)paramView).getType());
    PhotoDoodlePlugin.b(this.qdx, ((ClickBigImageView)paramView).getType());
    paramAdapterView = (Iterable)PhotoDoodlePlugin.c(this.qdx);
    int i = 0;
    paramAdapterView = paramAdapterView.iterator();
    while (paramAdapterView.hasNext())
    {
      paramAdapterView.next();
      int j = i + 1;
      if (i < 0) {
        j.eaS();
      }
      View localView;
      if (i == paramInt)
      {
        paramView = PhotoDoodlePlugin.d(this.qdx).getChildAt(i);
        if (paramView == null)
        {
          paramAdapterView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
          AppMethodBeat.o(150764);
          throw paramAdapterView;
        }
        if (!((ClickBigImageView)paramView).getHasSelected())
        {
          paramView = this.qdx;
          localView = PhotoDoodlePlugin.d(this.qdx).getChildAt(i);
          if (localView == null)
          {
            paramAdapterView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
            AppMethodBeat.o(150764);
            throw paramAdapterView;
          }
          PhotoDoodlePlugin.a(paramView, (ClickBigImageView)localView);
          i = j;
        }
      }
      else
      {
        paramView = PhotoDoodlePlugin.d(this.qdx).getChildAt(i);
        if (paramView == null)
        {
          paramAdapterView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
          AppMethodBeat.o(150764);
          throw paramAdapterView;
        }
        if (((ClickBigImageView)paramView).getHasSelected())
        {
          paramView = this.qdx;
          localView = PhotoDoodlePlugin.d(this.qdx).getChildAt(i);
          if (localView == null)
          {
            paramAdapterView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
            AppMethodBeat.o(150764);
            throw paramAdapterView;
          }
          PhotoDoodlePlugin.b(paramView, (ClickBigImageView)localView);
        }
      }
      i = j;
    }
    AppMethodBeat.o(150764);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.doodle.PhotoDoodlePlugin.2
 * JD-Core Version:    0.7.0.1
 */