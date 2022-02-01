package com.tencent.mm.ui.contact;

import android.content.Context;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.openim.PluginOpenIM;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storagebase.a.e;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.ui.AddressView;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public final class x
  extends a
{
  private HashSet<String> KLc;
  private String KLd;
  OpenIMAddressUI.OpenIMAddressUIFragment KLe;
  
  public x(Context paramContext, String paramString1, String paramString2)
  {
    super(paramContext, paramString1, null, 2);
    AppMethodBeat.i(37919);
    this.KLc = new HashSet();
    this.KLd = paramString2;
    AppMethodBeat.o(37919);
  }
  
  protected final int a(com.tencent.mm.storage.f paramf, int paramInt)
  {
    AppMethodBeat.i(37921);
    if (paramf == null)
    {
      ae.e("OpenIMContactAdapter", "contact is null, position:%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(37921);
      return -1;
    }
    if (bu.isNullOrNil(paramf.field_descWording))
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
      ae.d("OpenIMContactAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
      AppMethodBeat.o(37925);
      return;
    }
    bc.aCg();
    if (paramn == c.azF())
    {
      if (an.aUq((String)paramObject))
      {
        this.KLe.KGh = true;
        AppMethodBeat.o(37925);
        return;
      }
      ae.d("OpenIMContactAdapter", "newcursor is not openim ，return");
    }
    AppMethodBeat.o(37925);
  }
  
  protected final void a(com.tencent.mm.storage.f paramf, a.b paramb)
  {
    AppMethodBeat.i(37924);
    paramb = paramf.field_descWordingId;
    if (this.KLc.contains(paramb))
    {
      AppMethodBeat.o(37924);
      return;
    }
    this.KLc.add(paramb);
    ((com.tencent.mm.openim.a.a)g.ab(com.tencent.mm.openim.a.a.class)).bC(paramf.field_openImAppid, paramb);
    AppMethodBeat.o(37924);
  }
  
  protected final String b(com.tencent.mm.storage.f paramf, int paramInt)
  {
    AppMethodBeat.i(37922);
    paramf = paramf.field_descWording;
    if (bu.isNullOrNil(paramf))
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
    paramb.viP.updateTextColors();
    paramb.viP.setMergeCallback(null);
    Object localObject1 = paramf.IHU;
    if (localObject1 == null) {}
    for (;;)
    {
      CharSequence localCharSequence;
      try
      {
        if (an.aUq(paramf.field_username))
        {
          localObject1 = ((com.tencent.mm.openim.a.a)g.ab(com.tencent.mm.openim.a.a.class)).e(ak.getContext(), paramf.adG(), com.tencent.mm.cb.a.ax(this.context, 2131165517));
          Object localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = "";
          }
          paramb.viP.setName((CharSequence)localObject2);
          paramb.viP.setDescription(af.nullAsNil(paramf.field_remarkDesc));
          AppMethodBeat.o(37923);
          return;
        }
        localObject1 = k.b(this.context, aYl(getDisplayName(paramf.adG(), paramf.field_username)), com.tencent.mm.cb.a.ax(this.context, 2131165517));
        continue;
      }
      catch (Exception localException)
      {
        localCharSequence = null;
        continue;
      }
      paramb.viP.setName(localCharSequence);
    }
  }
  
  protected final Cursor fLS()
  {
    AppMethodBeat.i(37920);
    long l = System.currentTimeMillis();
    g.ajS();
    Object localObject2 = ((PluginOpenIM)g.ad(PluginOpenIM.class)).getAppIdInfoStg();
    String str = this.KLd;
    Object localObject1 = new LinkedList();
    localObject2 = ((com.tencent.mm.openim.e.d)localObject2).hKK.a("select distinct appid from OpenIMAppIdInfo where acctTypeId=? ", new String[] { str }, 2);
    if (((Cursor)localObject2).moveToFirst()) {
      do
      {
        str = ((Cursor)localObject2).getString(0);
        if (!bu.isNullOrNil(str)) {
          ((List)localObject1).add(str);
        }
      } while (((Cursor)localObject2).moveToNext());
    }
    ((Cursor)localObject2).close();
    bc.aCg();
    localObject2 = c.azF().a(this.fUR, ad.iR(ak.getContext()), (List)localObject1);
    localObject1 = localObject2;
    if ((localObject2 instanceof com.tencent.mm.storagebase.a.f)) {
      localObject1 = new e(new com.tencent.mm.storagebase.a.d[] { (com.tencent.mm.storagebase.a.d)com.tencent.mm.storagebase.d.fxH(), (com.tencent.mm.storagebase.a.f)localObject2 });
    }
    ae.d("OpenIMContactAdapter", "createNewCursor : " + (System.currentTimeMillis() - l));
    AppMethodBeat.o(37920);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.x
 * JD-Core Version:    0.7.0.1
 */