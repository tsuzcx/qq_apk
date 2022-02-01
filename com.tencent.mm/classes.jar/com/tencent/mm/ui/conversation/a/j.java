package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.bp.b;
import com.tencent.mm.pluginsdk.ui.b.a;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.Log;

public final class j
  extends b
{
  LinearLayout XFo;
  
  public j(final Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(38799);
    this.XFo = null;
    this.XFo = new LinearLayout(paramContext);
    this.XFo.setVisibility(8);
    bp.beO().ltZ = new bp.b()
    {
      public final void onNotify()
      {
        AppMethodBeat.i(38798);
        j.this.XFo.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(38797);
            if (j.this.XFo != null)
            {
              j.this.XFo.setVisibility(8);
              j.this.XFo.removeAllViews();
            }
            a locala = e.a(j.1.this.val$context, e.a.XFa, null);
            Object localObject = locala;
            if (locala == null) {
              localObject = e.a(j.1.this.val$context, e.a.XER, null);
            }
            if ((localObject != null) && (((a)localObject).getView() != null))
            {
              Log.i("MicroMsg.MainFrameAndAbtestBanner", "summerinit MainFrameBannerStorage onNotify banner[%s], view[%s]", new Object[] { localObject, ((a)localObject).getView() });
              j.this.XFo.setVisibility(0);
              localObject = ((a)localObject).getView();
              j.this.XFo.addView((View)localObject, new LinearLayout.LayoutParams(-1, -2));
            }
            AppMethodBeat.o(38797);
          }
        });
        AppMethodBeat.o(38798);
      }
    };
    bp.beO().ltZ.onNotify();
    AppMethodBeat.o(38799);
  }
  
  public final boolean ckL()
  {
    AppMethodBeat.i(38800);
    if ((this.XFo != null) && (this.XFo.getVisibility() == 0))
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
    bp.beO().ltZ = null;
    AppMethodBeat.o(38801);
  }
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public final View getView()
  {
    return this.XFo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.j
 * JD-Core Version:    0.7.0.1
 */