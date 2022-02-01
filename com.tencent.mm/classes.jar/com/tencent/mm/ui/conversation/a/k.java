package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.bk.b;
import com.tencent.mm.pluginsdk.ui.b.a;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.ae;

public final class k
  extends b
{
  LinearLayout KUS;
  
  public k(final Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(38799);
    this.KUS = null;
    this.KUS = new LinearLayout(paramContext);
    this.KUS.setVisibility(8);
    bk.aCm().hJo = new bk.b()
    {
      public final void onNotify()
      {
        AppMethodBeat.i(38798);
        k.this.KUS.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(38797);
            if (k.this.KUS != null)
            {
              k.this.KUS.setVisibility(8);
              k.this.KUS.removeAllViews();
            }
            a locala = e.a(k.1.this.val$context, e.a.KUz, null);
            Object localObject = locala;
            if (locala == null) {
              localObject = e.a(k.1.this.val$context, e.a.KUq, null);
            }
            if ((localObject != null) && (((a)localObject).getView() != null))
            {
              ae.i("MicroMsg.MainFrameAndAbtestBanner", "summerinit MainFrameBannerStorage onNotify banner[%s], view[%s]", new Object[] { localObject, ((a)localObject).getView() });
              k.this.KUS.setVisibility(0);
              localObject = ((a)localObject).getView();
              k.this.KUS.addView((View)localObject, new LinearLayout.LayoutParams(-1, -2));
            }
            AppMethodBeat.o(38797);
          }
        });
        AppMethodBeat.o(38798);
      }
    };
    bk.aCm().hJo.onNotify();
    AppMethodBeat.o(38799);
  }
  
  public final boolean bAV()
  {
    AppMethodBeat.i(38800);
    if ((this.KUS != null) && (this.KUS.getVisibility() == 0))
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
    bk.aCm().hJo = null;
    AppMethodBeat.o(38801);
  }
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public final View getView()
  {
    return this.KUS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.k
 * JD-Core Version:    0.7.0.1
 */