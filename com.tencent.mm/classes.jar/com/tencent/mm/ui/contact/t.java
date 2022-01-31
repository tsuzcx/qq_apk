package com.tencent.mm.ui.contact;

import android.content.Context;
import android.database.Cursor;
import com.tencent.mm.cf.a.e;
import com.tencent.mm.cf.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.openim.PluginOpenIM;
import com.tencent.mm.openim.a.b;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public final class t
  extends a
{
  private HashSet<String> vMQ = new HashSet();
  private String vMR;
  OpenIMAddressUI.a vMS;
  
  public t(Context paramContext, String paramString1, String paramString2)
  {
    super(paramContext, paramString1, null, 2);
    this.vMR = paramString2;
  }
  
  protected final int a(com.tencent.mm.storage.f paramf, int paramInt)
  {
    if (paramf == null) {
      y.e("OpenIMContactAdapter", "contact is null, position:%d", new Object[] { Integer.valueOf(paramInt) });
    }
    while (bk.bl(paramf.field_descWording)) {
      return -1;
    }
    return paramf.field_descWording.hashCode();
  }
  
  public final void a(int paramInt, m paramm, Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof String))) {
      y.d("OpenIMContactAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramm, paramObject });
    }
    do
    {
      return;
      au.Hx();
    } while (paramm != c.Fw());
    if (ad.aaU((String)paramObject))
    {
      this.vMS.vJl = true;
      return;
    }
    y.d("OpenIMContactAdapter", "newcursor is not openim ，return");
  }
  
  protected final void a(com.tencent.mm.storage.f paramf, a.b paramb)
  {
    paramb = paramf.field_descWordingId;
    if (this.vMQ.contains(paramb)) {
      return;
    }
    this.vMQ.add(paramb);
    ((b)g.r(b.class)).aK(paramf.field_openImAppid, paramb);
  }
  
  protected final String b(com.tencent.mm.storage.f paramf, int paramInt)
  {
    String str = paramf.field_descWording;
    paramf = str;
    if (bk.bl(str)) {
      paramf = "#";
    }
    return paramf;
  }
  
  protected final Cursor cHk()
  {
    long l = System.currentTimeMillis();
    g.DQ();
    Object localObject2 = ((PluginOpenIM)g.t(PluginOpenIM.class)).getAppIdInfoStg();
    String str = this.vMR;
    Object localObject1 = new LinkedList();
    localObject2 = ((com.tencent.mm.openim.d.d)localObject2).dXo.a("select distinct appid from OpenIMAppIdInfo where acctTypeId=? ", new String[] { str }, 2);
    if (((Cursor)localObject2).moveToFirst()) {
      do
      {
        str = ((Cursor)localObject2).getString(0);
        if (!bk.bl(str)) {
          ((List)localObject1).add(str);
        }
      } while (((Cursor)localObject2).moveToNext());
    }
    ((Cursor)localObject2).close();
    au.Hx();
    localObject2 = c.Fw().a(this.dru, x.fB(ae.getContext()), (List)localObject1);
    localObject1 = localObject2;
    if ((localObject2 instanceof com.tencent.mm.cf.a.f)) {
      localObject1 = new e(new com.tencent.mm.cf.a.d[] { (com.tencent.mm.cf.a.d)com.tencent.mm.cf.d.cwX(), (com.tencent.mm.cf.a.f)localObject2 });
    }
    y.d("OpenIMContactAdapter", "createNewCursor : " + (System.currentTimeMillis() - l));
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.contact.t
 * JD-Core Version:    0.7.0.1
 */