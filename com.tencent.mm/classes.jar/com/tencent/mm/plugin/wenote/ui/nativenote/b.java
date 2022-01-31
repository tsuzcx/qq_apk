package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.wenote.model.a.q;
import com.tencent.mm.plugin.wenote.model.f;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.h;
import com.tencent.mm.sdk.platformtools.bo;

public final class b
  extends com.tencent.mm.pluginsdk.ui.b.b
{
  private View jGC;
  private View jGD;
  private TextView titleTv;
  
  public b(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(27113);
    this.titleTv = null;
    if (this.view != null)
    {
      this.titleTv = ((TextView)this.view.findViewById(2131829586));
      this.jGC = this.view.findViewById(2131829585);
      this.jGD = this.view.findViewById(2131821667);
      this.titleTv.setTextSize(0, a.ao(this.titleTv.getContext(), 2131427758));
      this.view.setOnClickListener(new b.1(this));
    }
    AppMethodBeat.o(27113);
  }
  
  public final boolean aMK()
  {
    AppMethodBeat.i(27115);
    Object localObject = h.diI().diJ();
    int i;
    if ((this.nwf) && (this.eUx))
    {
      this.jGD.setBackgroundResource(2130840583);
      this.jGC.setBackground(null);
      this.titleTv.setBackground(null);
      if ((localObject == null) || (!((q)localObject).vxu) || (((q)localObject).vxw <= 0L) || (bo.isNullOrNil(((q)localObject).vxy))) {
        break label223;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        localObject = ((q)localObject).vxx;
        if (this.titleTv != null) {
          this.titleTv.setText((CharSequence)localObject);
        }
        setVisibility(0);
        AppMethodBeat.o(27115);
        return true;
        if (this.nwf)
        {
          this.jGD.setBackgroundResource(2130839279);
          this.jGC.setBackgroundResource(2130839278);
          this.titleTv.setBackgroundResource(2130839276);
          break;
        }
        if (this.eUx)
        {
          this.jGD.setBackgroundResource(2130839279);
          this.jGC.setBackgroundResource(2130839276);
          this.titleTv.setBackground(null);
          break;
        }
        this.jGD.setBackgroundResource(2130839279);
        this.jGC.setBackground(null);
        this.titleTv.setBackgroundResource(2130839276);
        break;
        label223:
        if ((localObject == null) || (((q)localObject).vxu) || (f.kY(((q)localObject).vxv) == null)) {
          break label274;
        }
        i = 1;
        continue;
      }
      if (localObject != null) {
        h.diI().a(null);
      }
      setVisibility(8);
      AppMethodBeat.o(27115);
      return false;
      label274:
      i = 0;
    }
  }
  
  public final void destroy() {}
  
  public final int getLayoutId()
  {
    return 2130971319;
  }
  
  public final int getOrder()
  {
    return 0;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(27114);
    if (this.view != null) {
      this.view.findViewById(2131829585).setVisibility(paramInt);
    }
    AppMethodBeat.o(27114);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.b
 * JD-Core Version:    0.7.0.1
 */