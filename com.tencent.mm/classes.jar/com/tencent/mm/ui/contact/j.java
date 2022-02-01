package com.tencent.mm.ui.contact;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.f;
import com.tencent.mm.al.f.a;
import com.tencent.mm.al.f.a.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.at;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class j
  extends LinearLayout
  implements f.a
{
  private List<String> PVw;
  private Map<String, View> PVx;
  private List<String> PVy;
  private a PVz;
  private Context context;
  private LinearLayout tmh;
  
  public j(Context paramContext, a parama)
  {
    super(paramContext);
    AppMethodBeat.i(37821);
    this.tmh = null;
    this.context = paramContext;
    this.PVz = parama;
    reset();
    AppMethodBeat.o(37821);
  }
  
  public final void a(f.a.b paramb)
  {
    AppMethodBeat.i(37824);
    if (paramb.iOi == null)
    {
      AppMethodBeat.o(37824);
      return;
    }
    if (!paramb.iOi.UF())
    {
      Log.i("MicroMsg.EnterpriseBizView", "onEvent, not enterprise father");
      AppMethodBeat.o(37824);
      return;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(233999);
        j.this.reset();
        AppMethodBeat.o(233999);
      }
    });
    AppMethodBeat.o(37824);
  }
  
  public final int getEnterpriseFriendCount()
  {
    AppMethodBeat.i(37822);
    if ((this.PVw == null) || (this.PVy == null))
    {
      AppMethodBeat.o(37822);
      return 0;
    }
    int i = this.PVw.size();
    int j = this.PVy.size();
    AppMethodBeat.o(37822);
    return i + j;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(234000);
    h.RTc.aX(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(37820);
        j localj = j.this;
        Object localObject1 = ag.bah();
        ArrayList localArrayList = new ArrayList();
        Object localObject2 = new StringBuilder();
        f.a((StringBuilder)localObject2);
        f.c((StringBuilder)localObject2);
        ((StringBuilder)localObject2).append(" and bizinfo.type = 2 ");
        ((StringBuilder)localObject2).append(" order by ");
        ((StringBuilder)localObject2).append(f.aZD());
        localObject2 = ((StringBuilder)localObject2).toString();
        Log.i("MicroMsg.BizInfoStorage", "getEnterpriseFatherBizLst sql %s", new Object[] { localObject2 });
        localObject1 = ((f)localObject1).rawQuery((String)localObject2, new String[0]);
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
        bg.aVF();
        j.b(localj, com.tencent.mm.model.c.aSN().gBY());
        j.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(233998);
            if ((j.a(j.this) != null) && (j.a(j.this).contains("wework")))
            {
              j.a(j.this).clear();
              j.a(j.this).add("wework");
            }
            if ((j.b(j.this).size() > 0) || (j.a(j.this).size() > 0))
            {
              Log.i("MicroMsg.EnterpriseBizView", "biz list size = %s", new Object[] { Integer.valueOf(j.b(j.this).size()) });
              if (j.c(j.this) == null)
              {
                View.inflate(j.this.getContext(), 2131493992, j.this);
                j.a(j.this, (LinearLayout)j.this.findViewById(2131299174));
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
                    localObject = ((z)localObject).findViewById(2131300138);
                    j = ((View)localObject).getPaddingLeft();
                    ((View)localObject).setBackground(at.aN(j.d(j.this), 2130969285));
                    ((View)localObject).findViewById(2131300140).setBackground(null);
                    ((View)localObject).setPadding(j, 0, 0, 0);
                  }
                  for (;;)
                  {
                    i += 1;
                    break;
                    ((z)localObject).findViewById(2131300138).setBackground(null);
                    ((z)localObject).findViewById(2131300138).findViewById(2131300140).setBackground(at.aN(j.d(j.this), 2130969285));
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
                    localObject = localk.findViewById(2131300138);
                    j = ((View)localObject).getPaddingLeft();
                    ((View)localObject).setBackgroundResource(2131233327);
                    ((View)localObject).findViewById(2131300139).setBackground(null);
                    ((View)localObject).setPadding(j, 0, 0, 0);
                  }
                  for (;;)
                  {
                    i += 1;
                    break;
                    localk.findViewById(2131300138).setBackground(null);
                    localObject = localk.findViewById(2131300138).findViewById(2131300139);
                    j = ((View)localObject).getPaddingRight();
                    ((View)localObject).setBackgroundResource(2131233327);
                    ((View)localObject).setPadding(0, 0, j, 0);
                  }
                }
              }
              j.f(j.this).anF(j.this.getEnterpriseFriendCount());
            }
            AppMethodBeat.o(233998);
          }
        });
        AppMethodBeat.o(37820);
      }
    });
    AppMethodBeat.o(234000);
  }
  
  public static abstract interface a
  {
    public abstract void anF(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.j
 * JD-Core Version:    0.7.0.1
 */