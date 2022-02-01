package com.tencent.mm.ui.contact;

import android.content.Context;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.openim.PluginOpenIM;
import com.tencent.mm.openim.a.b;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storagebase.a.e;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.ui.AddressView;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public final class x
  extends a
{
  private HashSet<String> Iya;
  private String Iyb;
  OpenIMAddressUI.OpenIMAddressUIFragment Iyc;
  
  public x(Context paramContext, String paramString1, String paramString2)
  {
    super(paramContext, paramString1, null, 2);
    AppMethodBeat.i(37919);
    this.Iya = new HashSet();
    this.Iyb = paramString2;
    AppMethodBeat.o(37919);
  }
  
  protected final int a(com.tencent.mm.storage.f paramf, int paramInt)
  {
    AppMethodBeat.i(37921);
    if (paramf == null)
    {
      ac.e("OpenIMContactAdapter", "contact is null, position:%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(37921);
      return -1;
    }
    if (bs.isNullOrNil(paramf.field_descWording))
    {
      AppMethodBeat.o(37921);
      return -1;
    }
    paramInt = paramf.field_descWording.hashCode();
    AppMethodBeat.o(37921);
    return paramInt;
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(37925);
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      ac.d("OpenIMContactAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
      AppMethodBeat.o(37925);
      return;
    }
    az.ayM();
    if (paramn == c.awB())
    {
      if (com.tencent.mm.storage.ai.aNc((String)paramObject))
      {
        this.Iyc.Ith = true;
        AppMethodBeat.o(37925);
        return;
      }
      ac.d("OpenIMContactAdapter", "newcursor is not openim ，return");
    }
    AppMethodBeat.o(37925);
  }
  
  protected final void a(com.tencent.mm.storage.f paramf, a.b paramb)
  {
    AppMethodBeat.i(37924);
    paramb = paramf.field_descWordingId;
    if (this.Iya.contains(paramb))
    {
      AppMethodBeat.o(37924);
      return;
    }
    this.Iya.add(paramb);
    ((b)g.ab(b.class)).bB(paramf.field_openImAppid, paramb);
    AppMethodBeat.o(37924);
  }
  
  protected final String b(com.tencent.mm.storage.f paramf, int paramInt)
  {
    AppMethodBeat.i(37922);
    paramf = paramf.field_descWording;
    if (bs.isNullOrNil(paramf))
    {
      AppMethodBeat.o(37922);
      return "#";
    }
    AppMethodBeat.o(37922);
    return paramf;
  }
  
  protected final void b(com.tencent.mm.storage.f paramf, a.b paramb)
  {
    AppMethodBeat.i(37923);
    paramb.tUz.updateTextColors();
    paramb.tUz.setMergeCallback(null);
    Object localObject1 = paramf.GBP;
    if (localObject1 == null) {}
    for (;;)
    {
      CharSequence localCharSequence;
      try
      {
        if (com.tencent.mm.storage.ai.aNc(paramf.field_username))
        {
          localObject1 = ((b)g.ab(b.class)).e(com.tencent.mm.sdk.platformtools.ai.getContext(), paramf.aaS(), com.tencent.mm.cc.a.au(this.context, 2131165517));
          Object localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = "";
          }
          paramb.tUz.setName((CharSequence)localObject2);
          paramb.tUz.setDescription(ae.nullAsNil(paramf.field_remarkDesc));
          AppMethodBeat.o(37923);
          return;
        }
        localObject1 = k.b(this.context, aQP(getDisplayName(paramf.aaS(), paramf.field_username)), com.tencent.mm.cc.a.au(this.context, 2131165517));
        continue;
      }
      catch (Exception localException)
      {
        localCharSequence = null;
        continue;
      }
      paramb.tUz.setName(localCharSequence);
    }
  }
  
  protected final Cursor fqN()
  {
    AppMethodBeat.i(37920);
    long l = System.currentTimeMillis();
    g.agS();
    Object localObject2 = ((PluginOpenIM)g.ad(PluginOpenIM.class)).getAppIdInfoStg();
    String str = this.Iyb;
    Object localObject1 = new LinkedList();
    localObject2 = ((com.tencent.mm.openim.e.d)localObject2).hpA.a("select distinct appid from OpenIMAppIdInfo where acctTypeId=? ", new String[] { str }, 2);
    if (((Cursor)localObject2).moveToFirst()) {
      do
      {
        str = ((Cursor)localObject2).getString(0);
        if (!bs.isNullOrNil(str)) {
          ((List)localObject1).add(str);
        }
      } while (((Cursor)localObject2).moveToNext());
    }
    ((Cursor)localObject2).close();
    az.ayM();
    localObject2 = c.awB().a(this.fzw, ab.iC(com.tencent.mm.sdk.platformtools.ai.getContext()), (List)localObject1);
    localObject1 = localObject2;
    if ((localObject2 instanceof com.tencent.mm.storagebase.a.f)) {
      localObject1 = new e(new com.tencent.mm.storagebase.a.d[] { (com.tencent.mm.storagebase.a.d)com.tencent.mm.storagebase.d.fdy(), (com.tencent.mm.storagebase.a.f)localObject2 });
    }
    ac.d("OpenIMContactAdapter", "createNewCursor : " + (System.currentTimeMillis() - l));
    AppMethodBeat.o(37920);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.x
 * JD-Core Version:    0.7.0.1
 */