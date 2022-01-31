package com.tencent.mm.ui.contact;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.ai.d;
import com.tencent.mm.ai.e;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.ai.e.a.b;
import com.tencent.mm.ai.z;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class i
  extends LinearLayout
  implements e.a
{
  private Context context;
  private LinearLayout kjd = null;
  private List<String> vLf;
  private Map<String, View> vLg;
  private i.a vLh;
  
  public i(Context paramContext, i.a parama)
  {
    super(paramContext);
    this.context = paramContext;
    this.vLh = parama;
    init();
  }
  
  private void init()
  {
    int j = 0;
    Object localObject2 = z.My();
    Object localObject1 = new ArrayList();
    Object localObject3 = new StringBuilder();
    e.a((StringBuilder)localObject3);
    e.c((StringBuilder)localObject3);
    ((StringBuilder)localObject3).append(" and bizinfo.type = 2 ");
    ((StringBuilder)localObject3).append(" order by ");
    ((StringBuilder)localObject3).append(e.Md());
    localObject3 = ((StringBuilder)localObject3).toString();
    y.i("MicroMsg.BizInfoStorage", "getEnterpriseFatherBizLst sql %s", new Object[] { localObject3 });
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
    this.vLf = ((List)localObject1);
    if ((this.vLf == null) || (this.vLf.size() <= 0)) {
      y.e("MicroMsg.EnterpriseBizView", "bizList is null");
    }
    for (;;)
    {
      return;
      y.i("MicroMsg.EnterpriseBizView", "biz list size = %s", new Object[] { Integer.valueOf(this.vLf.size()) });
      this.vLg = new HashMap();
      int i = j;
      if (this.kjd == null)
      {
        View.inflate(getContext(), R.i.enterprise_biz_in_addressui_header, this);
        this.kjd = ((LinearLayout)findViewById(R.h.container));
        i = j;
      }
      while (i < this.vLf.size())
      {
        localObject1 = (String)this.vLf.get(i);
        localObject2 = new j(getContext(), (String)localObject1);
        this.kjd.addView((View)localObject2);
        this.vLg.put(localObject1, localObject2);
        if (i == this.vLf.size() - 1) {
          ((j)localObject2).findViewById(R.h.enterprise_biz_item_ll).setBackgroundResource(R.g.mm_trans);
        }
        i += 1;
      }
    }
  }
  
  public final void a(e.a.b paramb)
  {
    if (paramb.egj == null) {
      return;
    }
    if (!paramb.egj.Ly())
    {
      y.i("MicroMsg.EnterpriseBizView", "onEvent, not enterprise father");
      return;
    }
    ai.d(new i.1(this, paramb));
  }
  
  public final int getEnterpriseFriendCount()
  {
    if (this.vLf == null) {
      return 0;
    }
    return this.vLf.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.contact.i
 * JD-Core Version:    0.7.0.1
 */