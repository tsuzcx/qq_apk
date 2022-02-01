package com.tencent.mm.ui.contact;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.af;
import com.tencent.mm.al.e;
import com.tencent.mm.al.e.a;
import com.tencent.mm.al.e.a.b;
import com.tencent.mm.model.az;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.ao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class j
  extends LinearLayout
  implements e.a
{
  private List<String> IvA;
  private a IvB;
  private List<String> Ivy;
  private Map<String, View> Ivz;
  private Context context;
  private LinearLayout qTW;
  
  public j(Context paramContext, a parama)
  {
    super(paramContext);
    AppMethodBeat.i(37821);
    this.qTW = null;
    this.context = paramContext;
    this.IvB = parama;
    reset();
    AppMethodBeat.o(37821);
  }
  
  public final void a(e.a.b paramb)
  {
    AppMethodBeat.i(37824);
    if (paramb.hxG == null)
    {
      AppMethodBeat.o(37824);
      return;
    }
    if (!paramb.hxG.IN())
    {
      ac.i("MicroMsg.EnterpriseBizView", "onEvent, not enterprise father");
      AppMethodBeat.o(37824);
      return;
    }
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(196749);
        j.this.reset();
        AppMethodBeat.o(196749);
      }
    });
    AppMethodBeat.o(37824);
  }
  
  public final int getEnterpriseFriendCount()
  {
    AppMethodBeat.i(37822);
    if ((this.Ivy == null) || (this.IvA == null))
    {
      AppMethodBeat.o(37822);
      return 0;
    }
    int i = this.Ivy.size();
    int j = this.IvA.size();
    AppMethodBeat.o(37822);
    return i + j;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(196750);
    h.JZN.aS(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(37820);
        j localj = j.this;
        Object localObject1 = af.aCW();
        ArrayList localArrayList = new ArrayList();
        Object localObject2 = new StringBuilder();
        e.a((StringBuilder)localObject2);
        e.c((StringBuilder)localObject2);
        ((StringBuilder)localObject2).append(" and bizinfo.type = 2 ");
        ((StringBuilder)localObject2).append(" order by ");
        ((StringBuilder)localObject2).append(e.aCs());
        localObject2 = ((StringBuilder)localObject2).toString();
        ac.i("MicroMsg.BizInfoStorage", "getEnterpriseFatherBizLst sql %s", new Object[] { localObject2 });
        localObject1 = ((e)localObject1).rawQuery((String)localObject2, new String[0]);
        if (localObject1 != null)
        {
          if (((Cursor)localObject1).moveToFirst()) {
            do
            {
              localArrayList.add(((Cursor)localObject1).getString(0));
            } while (((Cursor)localObject1).moveToNext());
          }
          ((Cursor)localObject1).close();
        }
        j.a(localj, localArrayList);
        localj = j.this;
        az.ayM();
        j.b(localj, com.tencent.mm.model.c.awB().fap());
        j.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(196748);
            if ((j.a(j.this) != null) && (j.a(j.this).contains("wework")))
            {
              j.a(j.this).clear();
              j.a(j.this).add("wework");
            }
            if ((j.b(j.this).size() > 0) || (j.a(j.this).size() > 0))
            {
              ac.i("MicroMsg.EnterpriseBizView", "biz list size = %s", new Object[] { Integer.valueOf(j.b(j.this).size()) });
              if (j.c(j.this) == null)
              {
                View.inflate(j.this.getContext(), 2131493837, j.this);
                j.a(j.this, (LinearLayout)j.this.findViewById(2131298736));
              }
              j.c(j.this).removeAllViews();
              int i;
              Object localObject;
              int j;
              if (j.a(j.this).size() > 0)
              {
                i = 0;
                if (i < j.a(j.this).size())
                {
                  localObject = (String)j.a(j.this).get(i);
                  localObject = new z(j.this.getContext(), (String)localObject);
                  j.c(j.this).addView((View)localObject);
                  if ((i == j.a(j.this).size() - 1) && (j.b(j.this).size() == 0))
                  {
                    localObject = ((z)localObject).findViewById(2131299501);
                    j = ((View)localObject).getPaddingLeft();
                    ((View)localObject).setBackground(ao.aI(j.d(j.this), 2130969245));
                    ((View)localObject).findViewById(2131299503).setBackground(null);
                    ((View)localObject).setPadding(j, 0, 0, 0);
                  }
                  for (;;)
                  {
                    i += 1;
                    break;
                    ((z)localObject).findViewById(2131299501).setBackground(null);
                    ((z)localObject).findViewById(2131299501).findViewById(2131299503).setBackground(ao.aI(j.d(j.this), 2130969245));
                  }
                }
              }
              if (j.b(j.this).size() > 0)
              {
                j.a(j.this, new HashMap());
                i = 0;
                if (i < j.b(j.this).size())
                {
                  localObject = (String)j.b(j.this).get(i);
                  k localk = new k(j.this.getContext(), (String)localObject);
                  j.c(j.this).addView(localk);
                  j.e(j.this).put(localObject, localk);
                  if (i == j.b(j.this).size() - 1)
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
              j.f(j.this).abO(j.this.getEnterpriseFriendCount());
            }
            AppMethodBeat.o(196748);
          }
        });
        AppMethodBeat.o(37820);
      }
    });
    AppMethodBeat.o(196750);
  }
  
  public static abstract interface a
  {
    public abstract void abO(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.j
 * JD-Core Version:    0.7.0.1
 */