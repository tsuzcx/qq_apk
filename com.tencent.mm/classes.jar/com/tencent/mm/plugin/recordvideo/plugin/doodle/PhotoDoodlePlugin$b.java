package com.tencent.mm.plugin.recordvideo.plugin.doodle;

import a.f.b.j;
import a.l;
import a.v;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import java.util.ArrayList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/PhotoDoodlePlugin$ClickImageViewResourceAdapter;", "Landroid/widget/BaseAdapter;", "resourceArray", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/PhotoDoodlePlugin$ClickImageViewResource;", "Lkotlin/collections/ArrayList;", "(Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/PhotoDoodlePlugin;Ljava/util/ArrayList;)V", "getResourceArray", "()Ljava/util/ArrayList;", "setResourceArray", "(Ljava/util/ArrayList;)V", "getCount", "", "getItem", "", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "plugin-recordvideo_release"})
final class PhotoDoodlePlugin$b
  extends BaseAdapter
{
  private ArrayList<PhotoDoodlePlugin.a> qdt;
  
  public PhotoDoodlePlugin$b(ArrayList<PhotoDoodlePlugin.a> paramArrayList)
  {
    AppMethodBeat.i(150768);
    this.qdt = localObject;
    AppMethodBeat.o(150768);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(150767);
    int i = this.qdt.size();
    AppMethodBeat.o(150767);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(150766);
    Object localObject = this.qdt.get(paramInt);
    j.p(localObject, "resourceArray[position]");
    AppMethodBeat.o(150766);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(150765);
    if (paramViewGroup == null) {
      j.ebi();
    }
    paramView = paramViewGroup.getContext();
    j.p(paramView, "parent!!.context");
    paramView = new ClickBigImageView(paramView, null);
    Object localObject = getItem(paramInt);
    if (localObject == null)
    {
      paramView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.PhotoDoodlePlugin.ClickImageViewResource");
      AppMethodBeat.o(150765);
      throw paramView;
    }
    localObject = (PhotoDoodlePlugin.a)localObject;
    if (((PhotoDoodlePlugin.a)localObject).bitmap == null)
    {
      paramView.setDrawColor(((PhotoDoodlePlugin.a)localObject).color);
      paramView.setType(((PhotoDoodlePlugin.a)localObject).type);
      if (paramView.getType() != PhotoDoodlePlugin.a(this.qdx)) {
        break label182;
      }
      paramView.setHasSelected(true);
      paramInt = (int)(a.fromDPToPix(paramViewGroup.getContext(), 18) * 1.2D);
      paramView.setLayoutParams((ViewGroup.LayoutParams)new AbsListView.LayoutParams(paramInt, paramInt));
    }
    for (;;)
    {
      paramView = (View)paramView;
      AppMethodBeat.o(150765);
      return paramView;
      Bitmap localBitmap = ((PhotoDoodlePlugin.a)localObject).bitmap;
      if (localBitmap == null) {
        j.ebi();
      }
      paramView.setBitmap(localBitmap);
      break;
      label182:
      paramInt = a.fromDPToPix(paramViewGroup.getContext(), 18);
      paramView.setLayoutParams((ViewGroup.LayoutParams)new AbsListView.LayoutParams(paramInt, paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.doodle.PhotoDoodlePlugin.b
 * JD-Core Version:    0.7.0.1
 */