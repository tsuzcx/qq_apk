package com.tencent.mm.ui.contact;

import android.content.Context;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.openim.PluginOpenIM;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storagebase.a.e;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public final class x
  extends a
{
  private HashSet<String> PYd;
  private String PYe;
  OpenIMAddressUI.OpenIMAddressUIFragment PYf;
  
  public x(Context paramContext, String paramString1, String paramString2)
  {
    super(paramContext, paramString1, null, 2);
    AppMethodBeat.i(37919);
    this.PYd = new HashSet();
    this.PYe = paramString2;
    AppMethodBeat.o(37919);
  }
  
  protected final int a(com.tencent.mm.storage.f paramf, int paramInt)
  {
    AppMethodBeat.i(37921);
    if (paramf == null)
    {
      Log.e("OpenIMContactAdapter", "contact is null, position:%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(37921);
      return -1;
    }
    if (Util.isNullOrNil(paramf.field_descWording))
    {
      AppMethodBeat.o(37921);
      return -1;
    }
    paramInt = paramf.field_descWording.hashCode();
    AppMethodBeat.o(37921);
    return paramInt;
  }
  
  protected final void a(com.tencent.mm.storage.f paramf, a.b paramb)
  {
    AppMethodBeat.i(37924);
    paramb = paramf.field_descWordingId;
    if (this.PYd.contains(paramb))
    {
      AppMethodBeat.o(37924);
      return;
    }
    this.PYd.add(paramb);
    ((com.tencent.mm.openim.a.a)g.af(com.tencent.mm.openim.a.a.class)).bN(paramf.field_openImAppid, paramb);
    AppMethodBeat.o(37924);
  }
  
  protected final String b(com.tencent.mm.storage.f paramf, int paramInt)
  {
    AppMethodBeat.i(37922);
    paramf = paramf.field_descWording;
    if (Util.isNullOrNil(paramf))
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
    Object localObject = paramf.NON;
    if (localObject == null) {
      try
      {
        if (as.bjp(paramf.field_username)) {}
        for (paramf = ((com.tencent.mm.openim.a.a)g.af(com.tencent.mm.openim.a.a.class)).e(MMApplicationContext.getContext(), paramf.arJ(), com.tencent.mm.cb.a.aG(this.context, 2131165535));; paramf = l.e(this.context, bnp(getDisplayName(paramf.arJ(), paramf.field_username)), com.tencent.mm.cb.a.aG(this.context, 2131165535)))
        {
          localObject = paramf;
          if (paramf == null) {
            localObject = "";
          }
          paramb.PSD.setText((CharSequence)localObject);
          AppMethodBeat.o(37923);
          return;
        }
      }
      catch (Exception paramf)
      {
        for (;;)
        {
          paramf = null;
        }
      }
    }
    paramb.PSD.setText((CharSequence)localObject);
    AppMethodBeat.o(37923);
  }
  
  protected final Cursor gUm()
  {
    AppMethodBeat.i(37920);
    long l = System.currentTimeMillis();
    g.aAi();
    Object localObject2 = ((PluginOpenIM)g.ah(PluginOpenIM.class)).getAppIdInfoStg();
    String str = this.PYe;
    Object localObject1 = new LinkedList();
    localObject2 = ((com.tencent.mm.openim.e.d)localObject2).iFy.rawQuery("select distinct appid from OpenIMAppIdInfo where acctTypeId=? ", new String[] { str }, 2);
    if (((Cursor)localObject2).moveToFirst()) {
      do
      {
        str = ((Cursor)localObject2).getString(0);
        if (!Util.isNullOrNil(str)) {
          ((List)localObject1).add(str);
        }
      } while (((Cursor)localObject2).moveToNext());
    }
    ((Cursor)localObject2).close();
    bg.aVF();
    localObject2 = c.aSN().a(this.gzY, LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()), (List)localObject1);
    localObject1 = localObject2;
    if ((localObject2 instanceof com.tencent.mm.storagebase.a.f)) {
      localObject1 = new e(new com.tencent.mm.storagebase.a.d[] { (com.tencent.mm.storagebase.a.d)com.tencent.mm.storagebase.d.gFu(), (com.tencent.mm.storagebase.a.f)localObject2 });
    }
    Log.d("OpenIMContactAdapter", "createNewCursor : " + (System.currentTimeMillis() - l));
    AppMethodBeat.o(37920);
    return localObject1;
  }
  
  public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(37925);
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      Log.d("OpenIMContactAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramMStorageEx, paramObject });
      AppMethodBeat.o(37925);
      return;
    }
    bg.aVF();
    if (paramMStorageEx == c.aSN())
    {
      if (as.bjp((String)paramObject))
      {
        this.PYf.PTd = true;
        AppMethodBeat.o(37925);
        return;
      }
      Log.d("OpenIMContactAdapter", "newcursor is not openim ，return");
    }
    AppMethodBeat.o(37925);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.x
 * JD-Core Version:    0.7.0.1
 */