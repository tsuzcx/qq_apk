package com.tencent.mm.ui.contact;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.d;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.an.af;
import com.tencent.mm.an.f;
import com.tencent.mm.an.f.a;
import com.tencent.mm.an.f.a.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.bd;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class j
  extends LinearLayout
  implements f.a
{
  private LinearLayout Api;
  private List<String> afdM;
  private Map<String, View> afdN;
  private List<String> afdO;
  private a afdP;
  private Context context;
  
  public j(Context paramContext, a parama)
  {
    super(paramContext);
    AppMethodBeat.i(37821);
    this.Api = null;
    this.context = paramContext;
    this.afdP = parama;
    reset();
    AppMethodBeat.o(37821);
  }
  
  public final void a(f.a.b paramb)
  {
    AppMethodBeat.i(37824);
    if (paramb.owg == null)
    {
      AppMethodBeat.o(37824);
      return;
    }
    if (!paramb.owg.aAP())
    {
      Log.i("MicroMsg.EnterpriseBizView", "onEvent, not enterprise father");
      AppMethodBeat.o(37824);
      return;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(253001);
        j.this.reset();
        AppMethodBeat.o(253001);
      }
    });
    AppMethodBeat.o(37824);
  }
  
  public final int getEnterpriseFriendCount()
  {
    AppMethodBeat.i(37822);
    if ((this.afdM == null) || (this.afdO == null))
    {
      AppMethodBeat.o(37822);
      return 0;
    }
    int i = this.afdM.size();
    int j = this.afdO.size();
    AppMethodBeat.o(37822);
    return i + j;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(252830);
    h.ahAA.bm(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(37820);
        j localj = j.this;
        Object localObject1 = af.bHf();
        ArrayList localArrayList = new ArrayList();
        Object localObject2 = new StringBuilder();
        f.b((StringBuilder)localObject2);
        f.d((StringBuilder)localObject2);
        ((StringBuilder)localObject2).append(" and bizinfo.type = 2 ");
        ((StringBuilder)localObject2).append(" order by ");
        ((StringBuilder)localObject2).append(f.bGD());
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
        bh.bCz();
        j.b(localj, com.tencent.mm.model.c.bzA().iZS());
        j.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(253024);
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
                View.inflate(j.this.getContext(), R.i.giV, j.this);
                j.a(j.this, (LinearLayout)j.this.findViewById(R.h.container));
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
                  localObject = new ac(j.this.getContext(), (String)localObject);
                  j.c(j.this).addView((View)localObject);
                  if ((i == j.a(j.this).size() - 1) && (j.b(j.this).size() == 0))
                  {
                    localObject = ((ac)localObject).findViewById(R.h.fGJ);
                    j = ((View)localObject).getPaddingLeft();
                    ((View)localObject).setBackground(bd.by(j.d(j.this), R.d.list_item_divider));
                    ((View)localObject).findViewById(R.h.fGL).setBackground(null);
                    ((View)localObject).setPadding(j, 0, 0, 0);
                  }
                  for (;;)
                  {
                    i += 1;
                    break;
                    ((ac)localObject).findViewById(R.h.fGJ).setBackground(null);
                    ((ac)localObject).findViewById(R.h.fGJ).findViewById(R.h.fGL).setBackground(bd.by(j.d(j.this), R.d.list_item_divider));
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
                    localObject = localk.findViewById(R.h.fGJ);
                    j = ((View)localObject).getPaddingLeft();
                    ((View)localObject).setBackgroundResource(R.g.list_item_normal);
                    ((View)localObject).findViewById(R.h.fGK).setBackground(null);
                    ((View)localObject).setPadding(j, 0, 0, 0);
                  }
                  for (;;)
                  {
                    i += 1;
                    break;
                    localk.findViewById(R.h.fGJ).setBackground(null);
                    localObject = localk.findViewById(R.h.fGJ).findViewById(R.h.fGK);
                    j = ((View)localObject).getPaddingRight();
                    ((View)localObject).setBackgroundResource(R.g.list_item_normal);
                    ((View)localObject).setPadding(0, 0, j, 0);
                  }
                }
              }
              j.f(j.this).onEnterpriseBizViewChange(j.this.getEnterpriseFriendCount());
            }
            AppMethodBeat.o(253024);
          }
        });
        AppMethodBeat.o(37820);
      }
    });
    AppMethodBeat.o(252830);
  }
  
  public static abstract interface a
  {
    public abstract void onEnterpriseBizViewChange(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.j
 * JD-Core Version:    0.7.0.1
 */