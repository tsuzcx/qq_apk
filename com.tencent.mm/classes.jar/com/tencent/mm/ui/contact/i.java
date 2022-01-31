package com.tencent.mm.ui.contact;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.d;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.e.a;
import com.tencent.mm.aj.e.a.b;
import com.tencent.mm.aj.z;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class i
  extends LinearLayout
  implements e.a
{
  private List<String> AcH;
  private Map<String, View> AcI;
  private i.a AcJ;
  private Context context;
  private LinearLayout mDJ;
  
  public i(Context paramContext, i.a parama)
  {
    super(paramContext);
    AppMethodBeat.i(33704);
    this.mDJ = null;
    this.context = paramContext;
    this.AcJ = parama;
    init();
    AppMethodBeat.o(33704);
  }
  
  private void init()
  {
    AppMethodBeat.i(33706);
    Object localObject2 = z.afi();
    Object localObject1 = new ArrayList();
    Object localObject3 = new StringBuilder();
    e.a((StringBuilder)localObject3);
    e.c((StringBuilder)localObject3);
    ((StringBuilder)localObject3).append(" and bizinfo.type = 2 ");
    ((StringBuilder)localObject3).append(" order by ");
    ((StringBuilder)localObject3).append(e.aeK());
    localObject3 = ((StringBuilder)localObject3).toString();
    ab.i("MicroMsg.BizInfoStorage", "getEnterpriseFatherBizLst sql %s", new Object[] { localObject3 });
    localObject2 = ((e)localObject2).rawQuery((String)localObject3, new String[0]);
    if (localObject2 != null)
    {
      if (((Cursor)localObject2).moveToFirst()) {
        do
        {
          ((ArrayList)localObject1).add(((Cursor)localObject2).getString(0));
        } while (((Cursor)localObject2).moveToNext());
      }
      ((Cursor)localObject2).close();
    }
    this.AcH = ((List)localObject1);
    if ((this.AcH == null) || (this.AcH.size() <= 0))
    {
      ab.e("MicroMsg.EnterpriseBizView", "bizList is null");
      AppMethodBeat.o(33706);
      return;
    }
    ab.i("MicroMsg.EnterpriseBizView", "biz list size = %s", new Object[] { Integer.valueOf(this.AcH.size()) });
    this.AcI = new HashMap();
    if (this.mDJ == null)
    {
      View.inflate(getContext(), 2130969425, this);
      this.mDJ = ((LinearLayout)findViewById(2131821084));
    }
    int i = 0;
    if (i < this.AcH.size())
    {
      localObject1 = (String)this.AcH.get(i);
      localObject2 = new j(getContext(), (String)localObject1);
      this.mDJ.addView((View)localObject2);
      this.AcI.put(localObject1, localObject2);
      int j;
      if (i == this.AcH.size() - 1)
      {
        localObject1 = ((j)localObject2).findViewById(2131823728);
        j = ((View)localObject1).getPaddingLeft();
        ((View)localObject1).setBackgroundResource(2130839276);
        ((View)localObject1).findViewById(2131823729).setBackground(null);
        ((View)localObject1).setPadding(j, 0, 0, 0);
      }
      for (;;)
      {
        i += 1;
        break;
        ((j)localObject2).findViewById(2131823728).setBackground(null);
        localObject1 = ((j)localObject2).findViewById(2131823728).findViewById(2131823729);
        j = ((View)localObject1).getPaddingRight();
        ((View)localObject1).setBackgroundResource(2130839276);
        ((View)localObject1).setPadding(0, 0, j, 0);
      }
    }
    AppMethodBeat.o(33706);
  }
  
  public final void a(e.a.b paramb)
  {
    AppMethodBeat.i(33707);
    if (paramb.fwl == null)
    {
      AppMethodBeat.o(33707);
      return;
    }
    if (!paramb.fwl.aeg())
    {
      ab.i("MicroMsg.EnterpriseBizView", "onEvent, not enterprise father");
      AppMethodBeat.o(33707);
      return;
    }
    al.d(new i.1(this, paramb));
    AppMethodBeat.o(33707);
  }
  
  public final int getEnterpriseFriendCount()
  {
    AppMethodBeat.i(33705);
    if (this.AcH == null)
    {
      AppMethodBeat.o(33705);
      return 0;
    }
    int i = this.AcH.size();
    AppMethodBeat.o(33705);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.contact.i
 * JD-Core Version:    0.7.0.1
 */