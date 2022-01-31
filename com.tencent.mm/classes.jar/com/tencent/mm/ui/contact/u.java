package com.tencent.mm.ui.contact;

import android.content.Context;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.a.e;
import com.tencent.mm.cg.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.openim.PluginOpenIM;
import com.tencent.mm.openim.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.AddressView;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public final class u
  extends a
{
  private HashSet<String> Aet;
  private String Aeu;
  OpenIMAddressUI.OpenIMAddressUIFragment Aev;
  
  public u(Context paramContext, String paramString1, String paramString2)
  {
    super(paramContext, paramString1, null, 2);
    AppMethodBeat.i(33801);
    this.Aet = new HashSet();
    this.Aeu = paramString2;
    AppMethodBeat.o(33801);
  }
  
  protected final int a(com.tencent.mm.storage.f paramf, int paramInt)
  {
    AppMethodBeat.i(33803);
    if (paramf == null)
    {
      ab.e("OpenIMContactAdapter", "contact is null, position:%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(33803);
      return -1;
    }
    if (bo.isNullOrNil(paramf.field_descWording))
    {
      AppMethodBeat.o(33803);
      return -1;
    }
    paramInt = paramf.field_descWording.hashCode();
    AppMethodBeat.o(33803);
    return paramInt;
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(33806);
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      ab.d("OpenIMContactAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
      AppMethodBeat.o(33806);
      return;
    }
    aw.aaz();
    if (paramn == c.YA())
    {
      if (ad.arf((String)paramObject))
      {
        this.Aev.AaH = true;
        AppMethodBeat.o(33806);
        return;
      }
      ab.d("OpenIMContactAdapter", "newcursor is not openim ，return");
    }
    AppMethodBeat.o(33806);
  }
  
  protected final void a(com.tencent.mm.storage.f paramf, a.b paramb)
  {
    AppMethodBeat.i(33805);
    paramb = paramf.field_descWordingId;
    if (this.Aet.contains(paramb))
    {
      AppMethodBeat.o(33805);
      return;
    }
    this.Aet.add(paramb);
    ((b)g.E(b.class)).bd(paramf.field_openImAppid, paramb);
    AppMethodBeat.o(33805);
  }
  
  protected final String b(com.tencent.mm.storage.f paramf, int paramInt)
  {
    AppMethodBeat.i(33804);
    paramf = paramf.field_descWording;
    if (bo.isNullOrNil(paramf))
    {
      AppMethodBeat.o(33804);
      return "#";
    }
    AppMethodBeat.o(33804);
    return paramf;
  }
  
  protected final void b(com.tencent.mm.storage.f paramf, a.b paramb)
  {
    AppMethodBeat.i(156721);
    paramb.nYV.updateTextColors();
    paramb.nYV.setMergeCallback(null);
    Object localObject1 = paramf.ywx;
    if (localObject1 == null) {}
    for (;;)
    {
      CharSequence localCharSequence;
      try
      {
        if (ad.arf(paramf.field_username))
        {
          localObject1 = ((b)g.E(b.class)).e(com.tencent.mm.sdk.platformtools.ah.getContext(), paramf.Of(), com.tencent.mm.cb.a.ao(this.context, 2131427809));
          Object localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = "";
          }
          paramb.nYV.setName((CharSequence)localObject2);
          paramb.nYV.setDescription(com.tencent.mm.platformtools.ah.nullAsNil(paramf.field_remarkDesc));
          AppMethodBeat.o(156721);
          return;
        }
        localObject1 = j.b(this.context, auw(getDisplayName(paramf.Of(), paramf.field_username)), com.tencent.mm.cb.a.ao(this.context, 2131427809));
        continue;
      }
      catch (Exception localException)
      {
        localCharSequence = null;
        continue;
      }
      paramb.nYV.setName(localCharSequence);
    }
  }
  
  protected final Cursor dLA()
  {
    AppMethodBeat.i(33802);
    long l = System.currentTimeMillis();
    g.RM();
    Object localObject2 = ((PluginOpenIM)g.G(PluginOpenIM.class)).getAppIdInfoStg();
    String str = this.Aeu;
    Object localObject1 = new LinkedList();
    localObject2 = ((com.tencent.mm.openim.e.d)localObject2).fnw.a("select distinct appid from OpenIMAppIdInfo where acctTypeId=? ", new String[] { str }, 2);
    if (((Cursor)localObject2).moveToFirst()) {
      do
      {
        str = ((Cursor)localObject2).getString(0);
        if (!bo.isNullOrNil(str)) {
          ((List)localObject1).add(str);
        }
      } while (((Cursor)localObject2).moveToNext());
    }
    ((Cursor)localObject2).close();
    aw.aaz();
    localObject2 = c.YA().a(this.ejc, aa.gP(com.tencent.mm.sdk.platformtools.ah.getContext()), (List)localObject1);
    localObject1 = localObject2;
    if ((localObject2 instanceof com.tencent.mm.cg.a.f)) {
      localObject1 = new e(new com.tencent.mm.cg.a.d[] { (com.tencent.mm.cg.a.d)com.tencent.mm.cg.d.dzJ(), (com.tencent.mm.cg.a.f)localObject2 });
    }
    ab.d("OpenIMContactAdapter", "createNewCursor : " + (System.currentTimeMillis() - l));
    AppMethodBeat.o(33802);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.contact.u
 * JD-Core Version:    0.7.0.1
 */