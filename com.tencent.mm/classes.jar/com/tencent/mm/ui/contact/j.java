package com.tencent.mm.ui.contact;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.af;
import com.tencent.mm.am.e;
import com.tencent.mm.am.e.a;
import com.tencent.mm.am.e.a.b;
import com.tencent.mm.model.az;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.ao;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class j
  extends LinearLayout
  implements e.a
{
  private List<String> GVl;
  private Map<String, View> GVm;
  private List<String> GVn;
  private a GVo;
  private Context context;
  private LinearLayout qlu;
  
  public j(Context paramContext, a parama)
  {
    super(paramContext);
    AppMethodBeat.i(37821);
    this.qlu = null;
    this.context = paramContext;
    this.GVo = parama;
    reset();
    AppMethodBeat.o(37821);
  }
  
  public final void a(e.a.b paramb)
  {
    AppMethodBeat.i(37824);
    if (paramb.gXh == null)
    {
      AppMethodBeat.o(37824);
      return;
    }
    if (!paramb.gXh.Je())
    {
      ad.i("MicroMsg.EnterpriseBizView", "onEvent, not enterprise father");
      AppMethodBeat.o(37824);
      return;
    }
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(37820);
        j.this.reset();
        AppMethodBeat.o(37820);
      }
    });
    AppMethodBeat.o(37824);
  }
  
  public final int getEnterpriseFriendCount()
  {
    AppMethodBeat.i(37822);
    if (this.GVl == null)
    {
      AppMethodBeat.o(37822);
      return 0;
    }
    int i = this.GVl.size();
    int j = this.GVn.size();
    AppMethodBeat.o(37822);
    return i + j;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(191666);
    this.GVl = af.awe().avB();
    az.arV();
    this.GVn = com.tencent.mm.model.c.apM().eKN();
    if ((this.GVn != null) && (this.GVn.contains("wework")))
    {
      this.GVn.clear();
      this.GVn.add("wework");
    }
    if ((this.GVl.size() > 0) || (this.GVn.size() > 0))
    {
      ad.i("MicroMsg.EnterpriseBizView", "biz list size = %s", new Object[] { Integer.valueOf(this.GVl.size()) });
      if (this.qlu == null)
      {
        View.inflate(getContext(), 2131493837, this);
        this.qlu = ((LinearLayout)findViewById(2131298736));
      }
      this.qlu.removeAllViews();
      int i;
      Object localObject;
      int j;
      if (this.GVn.size() > 0)
      {
        i = 0;
        if (i < this.GVn.size())
        {
          localObject = (String)this.GVn.get(i);
          localObject = new z(getContext(), (String)localObject);
          this.qlu.addView((View)localObject);
          if ((i == this.GVn.size() - 1) && (this.GVl.size() == 0))
          {
            localObject = ((z)localObject).findViewById(2131299501);
            j = ((View)localObject).getPaddingLeft();
            ((View)localObject).setBackground(ao.aC(this.context, 2130969245));
            ((View)localObject).findViewById(2131299503).setBackground(null);
            ((View)localObject).setPadding(j, 0, 0, 0);
          }
          for (;;)
          {
            i += 1;
            break;
            ((z)localObject).findViewById(2131299501).setBackground(null);
            ((z)localObject).findViewById(2131299501).findViewById(2131299503).setBackground(ao.aC(this.context, 2130969245));
          }
        }
      }
      if (this.GVl.size() > 0)
      {
        this.GVm = new HashMap();
        i = 0;
        if (i < this.GVl.size())
        {
          localObject = (String)this.GVl.get(i);
          k localk = new k(getContext(), (String)localObject);
          this.qlu.addView(localk);
          this.GVm.put(localObject, localk);
          if (i == this.GVl.size() - 1)
          {
            localObject = localk.findViewById(2131299501);
            j = ((View)localObject).getPaddingLeft();
            ((View)localObject).setBackgroundResource(2131232867);
            ((View)localObject).findViewById(2131299502).setBackground(null);
            ((View)localObject).setPadding(j, 0, 0, 0);
          }
          for (;;)
          {
            i += 1;
            break;
            localk.findViewById(2131299501).setBackground(null);
            localObject = localk.findViewById(2131299501).findViewById(2131299502);
            j = ((View)localObject).getPaddingRight();
            ((View)localObject).setBackgroundResource(2131232867);
            ((View)localObject).setPadding(0, 0, j, 0);
          }
        }
      }
      this.GVo.ZA(getEnterpriseFriendCount());
    }
    AppMethodBeat.o(191666);
  }
  
  public static abstract interface a
  {
    public abstract void ZA(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.j
 * JD-Core Version:    0.7.0.1
 */