package com.tencent.mm.ui.contact;

import android.content.Context;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.openim.PluginOpenIM;
import com.tencent.mm.openim.a.b;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storagebase.a.e;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.ui.AddressView;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public final class x
  extends a
{
  private HashSet<String> KoI;
  private String KoJ;
  OpenIMAddressUI.OpenIMAddressUIFragment KoK;
  
  public x(Context paramContext, String paramString1, String paramString2)
  {
    super(paramContext, paramString1, null, 2);
    AppMethodBeat.i(37919);
    this.KoI = new HashSet();
    this.KoJ = paramString2;
    AppMethodBeat.o(37919);
  }
  
  protected final int a(com.tencent.mm.storage.f paramf, int paramInt)
  {
    AppMethodBeat.i(37921);
    if (paramf == null)
    {
      ad.e("OpenIMContactAdapter", "contact is null, position:%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(37921);
      return -1;
    }
    if (bt.isNullOrNil(paramf.field_descWording))
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
      ad.d("OpenIMContactAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
      AppMethodBeat.o(37925);
      return;
    }
    ba.aBQ();
    if (paramn == c.azp())
    {
      if (am.aSQ((String)paramObject))
      {
        this.KoK.KjN = true;
        AppMethodBeat.o(37925);
        return;
      }
      ad.d("OpenIMContactAdapter", "newcursor is not openim ，return");
    }
    AppMethodBeat.o(37925);
  }
  
  protected final void a(com.tencent.mm.storage.f paramf, a.b paramb)
  {
    AppMethodBeat.i(37924);
    paramb = paramf.field_descWordingId;
    if (this.KoI.contains(paramb))
    {
      AppMethodBeat.o(37924);
      return;
    }
    this.KoI.add(paramb);
    ((b)g.ab(b.class)).bC(paramf.field_openImAppid, paramb);
    AppMethodBeat.o(37924);
  }
  
  protected final String b(com.tencent.mm.storage.f paramf, int paramInt)
  {
    AppMethodBeat.i(37922);
    paramf = paramf.field_descWording;
    if (bt.isNullOrNil(paramf))
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
    paramb.uXb.updateTextColors();
    paramb.uXb.setMergeCallback(null);
    Object localObject1 = paramf.InJ;
    if (localObject1 == null) {}
    for (;;)
    {
      CharSequence localCharSequence;
      try
      {
        if (am.aSQ(paramf.field_username))
        {
          localObject1 = ((b)g.ab(b.class)).e(aj.getContext(), paramf.adv(), com.tencent.mm.cc.a.ax(this.context, 2131165517));
          Object localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = "";
          }
          paramb.uXb.setName((CharSequence)localObject2);
          paramb.uXb.setDescription(af.nullAsNil(paramf.field_remarkDesc));
          AppMethodBeat.o(37923);
          return;
        }
        localObject1 = k.b(this.context, aWK(getDisplayName(paramf.adv(), paramf.field_username)), com.tencent.mm.cc.a.ax(this.context, 2131165517));
        continue;
      }
      catch (Exception localException)
      {
        localCharSequence = null;
        continue;
      }
      paramb.uXb.setName(localCharSequence);
    }
  }
  
  protected final Cursor fHA()
  {
    AppMethodBeat.i(37920);
    long l = System.currentTimeMillis();
    g.ajD();
    Object localObject2 = ((PluginOpenIM)g.ad(PluginOpenIM.class)).getAppIdInfoStg();
    String str = this.KoJ;
    Object localObject1 = new LinkedList();
    localObject2 = ((com.tencent.mm.openim.e.d)localObject2).hHS.a("select distinct appid from OpenIMAppIdInfo where acctTypeId=? ", new String[] { str }, 2);
    if (((Cursor)localObject2).moveToFirst()) {
      do
      {
        str = ((Cursor)localObject2).getString(0);
        if (!bt.isNullOrNil(str)) {
          ((List)localObject1).add(str);
        }
      } while (((Cursor)localObject2).moveToNext());
    }
    ((Cursor)localObject2).close();
    ba.aBQ();
    localObject2 = c.azp().a(this.fSL, ac.iM(aj.getContext()), (List)localObject1);
    localObject1 = localObject2;
    if ((localObject2 instanceof com.tencent.mm.storagebase.a.f)) {
      localObject1 = new e(new com.tencent.mm.storagebase.a.d[] { (com.tencent.mm.storagebase.a.d)com.tencent.mm.storagebase.d.ftG(), (com.tencent.mm.storagebase.a.f)localObject2 });
    }
    ad.d("OpenIMContactAdapter", "createNewCursor : " + (System.currentTimeMillis() - l));
    AppMethodBeat.o(37920);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.x
 * JD-Core Version:    0.7.0.1
 */