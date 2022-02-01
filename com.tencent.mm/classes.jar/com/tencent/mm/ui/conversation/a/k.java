package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bh.b;
import com.tencent.mm.pluginsdk.ui.b.a;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.ac;

public final class k
  extends b
{
  LinearLayout IHq;
  
  public k(final Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(38799);
    this.IHq = null;
    this.IHq = new LinearLayout(paramContext);
    this.IHq.setVisibility(8);
    bh.ayS().hoe = new bh.b()
    {
      public final void onNotify()
      {
        AppMethodBeat.i(38798);
        k.this.IHq.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(38797);
            if (k.this.IHq != null)
            {
              k.this.IHq.setVisibility(8);
              k.this.IHq.removeAllViews();
            }
            a locala = e.a(k.1.this.val$context, e.a.IGZ, null);
            Object localObject = locala;
            if (locala == null) {
              localObject = e.a(k.1.this.val$context, e.a.IGQ, null);
            }
            if ((localObject != null) && (((a)localObject).getView() != null))
            {
              ac.i("MicroMsg.MainFrameAndAbtestBanner", "summerinit MainFrameBannerStorage onNotify banner[%s], view[%s]", new Object[] { localObject, ((a)localObject).getView() });
              k.this.IHq.setVisibility(0);
              localObject = ((a)localObject).getView();
              k.this.IHq.addView((View)localObject, new LinearLayout.LayoutParams(-1, -2));
            }
            AppMethodBeat.o(38797);
          }
        });
        AppMethodBeat.o(38798);
      }
    };
    bh.ayS().hoe.onNotify();
    AppMethodBeat.o(38799);
  }
  
  public final boolean bvU()
  {
    AppMethodBeat.i(38800);
    if ((this.IHq != null) && (this.IHq.getVisibility() == 0))
    {
      AppMethodBeat.o(38800);
      return true;
    }
    AppMethodBeat.o(38800);
    return false;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(38801);
    bh.ayS().hoe = null;
    AppMethodBeat.o(38801);
  }
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public final View getView()
  {
    return this.IHq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.k
 * JD-Core Version:    0.7.0.1
 */