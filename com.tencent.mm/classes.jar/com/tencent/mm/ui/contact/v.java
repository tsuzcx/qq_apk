package com.tencent.mm.ui.contact;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bd;
import java.util.List;

public final class v
  extends LinearLayout
{
  private List<String> Aew;
  private v.a Aex;
  private v.b Aey;
  private Context context;
  private LinearLayout mDJ;
  
  public v(Context paramContext, v.a parama)
  {
    super(paramContext);
    AppMethodBeat.i(33807);
    this.mDJ = null;
    this.context = paramContext;
    this.Aex = parama;
    reset();
    AppMethodBeat.o(33807);
  }
  
  public final int getOpenIMCount()
  {
    AppMethodBeat.i(33808);
    if (this.Aew == null)
    {
      AppMethodBeat.o(33808);
      return 0;
    }
    int i = this.Aew.size();
    AppMethodBeat.o(33808);
    return i;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(33809);
    aw.aaz();
    this.Aew = c.YA().dwK();
    if ((this.Aew == null) || (this.Aew.size() <= 0))
    {
      ab.i("MicroMsg.OpenIMListHeaderView", "openimIdList is null");
      AppMethodBeat.o(33809);
      return;
    }
    ab.i("MicroMsg.OpenIMListHeaderView", "openim list size = %s", new Object[] { Integer.valueOf(this.Aew.size()) });
    if (this.mDJ == null)
    {
      View.inflate(getContext(), 2130970393, this);
      this.mDJ = ((LinearLayout)findViewById(2131821084));
    }
    this.mDJ.removeAllViews();
    int i = 0;
    if (i < this.Aew.size())
    {
      Object localObject = (String)this.Aew.get(i);
      localObject = new w(getContext(), (String)localObject);
      this.mDJ.addView((View)localObject);
      if (i == this.Aew.size() - 1)
      {
        localObject = ((w)localObject).findViewById(2131823728);
        int j = ((View)localObject).getPaddingLeft();
        ((View)localObject).setBackgroundResource(2130839276);
        ((View)localObject).findViewById(2131826642).setBackground(null);
        ((View)localObject).setPadding(j, 0, 0, 0);
      }
      for (;;)
      {
        i += 1;
        break;
        ((w)localObject).findViewById(2131823728).setBackground(null);
        ((w)localObject).findViewById(2131823728).findViewById(2131826642).setBackgroundResource(2130839276);
      }
    }
    AppMethodBeat.o(33809);
  }
  
  public final void setOnVisibilityChangeListener(v.b paramb)
  {
    this.Aey = paramb;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(33810);
    v.b localb;
    if ((this.Aey != null) && (paramInt != getVisibility()))
    {
      localb = this.Aey;
      if (paramInt != 0) {
        break label49;
      }
    }
    label49:
    for (boolean bool = true;; bool = false)
    {
      localb.rf(bool);
      super.setVisibility(paramInt);
      AppMethodBeat.o(33810);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.contact.v
 * JD-Core Version:    0.7.0.1
 */