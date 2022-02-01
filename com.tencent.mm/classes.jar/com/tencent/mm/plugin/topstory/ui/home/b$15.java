package com.tencent.mm.plugin.topstory.ui.home;

import android.support.v4.view.q;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.List;

final class b$15
  extends q
{
  b$15(b paramb) {}
  
  public final void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(125949);
    ad.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "destroyItem pos:%s, v:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramObject.hashCode()) });
    paramViewGroup.removeView((View)paramObject);
    AppMethodBeat.o(125949);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(125947);
    int i = this.BsG.Bsq.size();
    AppMethodBeat.o(125947);
    return i;
  }
  
  public final Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(125948);
    ad.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "instantiateItem pos:%s, v:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(((b.a)this.BsG.Ady.get(paramInt)).BsW.hashCode()) });
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
    paramViewGroup.addView(((b.a)this.BsG.Ady.get(paramInt)).BsW, localLayoutParams);
    paramViewGroup = ((b.a)this.BsG.Ady.get(paramInt)).BsW;
    AppMethodBeat.o(125948);
    return paramViewGroup;
  }
  
  public final boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.b.15
 * JD-Core Version:    0.7.0.1
 */