package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.sns.b.b;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.b.j.a;
import com.tencent.mm.plugin.sns.b.p;
import com.tencent.mm.pluginsdk.c.a;
import com.tencent.mm.sdk.platformtools.DoNotCheckLeakForActivities;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.preference.f;
import junit.framework.Assert;

@DoNotCheckLeakForActivities({ContactInfoUI.class})
public final class l
  implements i, j.a, a
{
  public final void a(String paramString1, String paramString2, boolean paramBoolean, int paramInt, b paramb) {}
  
  public final void a(String paramString, boolean paramBoolean, int paramInt, b paramb)
  {
    AppMethodBeat.i(27203);
    AppMethodBeat.o(27203);
    throw null;
  }
  
  public final boolean a(f paramf, as paramas, boolean paramBoolean, int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(27193);
    if (paramas != null)
    {
      paramBoolean = true;
      Assert.assertTrue(paramBoolean);
      if (Util.nullAsNil(paramas.field_username).length() <= 0) {
        break label62;
      }
      paramBoolean = true;
      label34:
      Assert.assertTrue(paramBoolean);
      if (paramf == null) {
        break label67;
      }
    }
    label62:
    label67:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      Assert.assertTrue(paramBoolean);
      AppMethodBeat.o(27193);
      throw null;
      paramBoolean = false;
      break;
      paramBoolean = false;
      break label34;
    }
  }
  
  public final boolean atw(String paramString)
  {
    AppMethodBeat.i(27190);
    if (paramString.equals("contact_info_sns"))
    {
      bh.beI();
      if (!c.isSDCardAvailable())
      {
        AppMethodBeat.o(27190);
        throw null;
      }
      AppMethodBeat.o(27190);
      throw null;
    }
    if (paramString.equals("contact_info_more"))
    {
      new Intent();
      AppMethodBeat.o(27190);
      throw null;
    }
    if (paramString.equals("contact_info_social"))
    {
      new Intent();
      AppMethodBeat.o(27190);
      throw null;
    }
    if (paramString.equals("contact_info_invite_source"))
    {
      AppMethodBeat.o(27190);
      throw null;
    }
    AppMethodBeat.o(27190);
    return true;
  }
  
  public final void b(String paramString, boolean paramBoolean, int paramInt, b paramb) {}
  
  public final boolean cQX()
  {
    AppMethodBeat.i(27201);
    if (p.JPh != null) {
      p.JPh.a(this, 3);
    }
    bh.aGY().b(30, this);
    bh.aGY().b(453, this);
    AppMethodBeat.o(27201);
    throw null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(27202);
    if ((paramq.getType() != 30) && (paramq.getType() != 458))
    {
      Log.w("MicroMsg.ContactWidgetNormal", "not expected scene,  type = " + paramq.getType());
      AppMethodBeat.o(27202);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramq.getType() == 30)
      {
        paramString = (com.tencent.mm.pluginsdk.model.t)paramq;
        if ((paramString.fDn != 1) && (paramString.fDn != 3))
        {
          AppMethodBeat.o(27202);
          return;
        }
        if (paramString.QVu != null)
        {
          AppMethodBeat.o(27202);
          throw null;
        }
        AppMethodBeat.o(27202);
        throw null;
      }
      if (paramq.getType() == 453)
      {
        AppMethodBeat.o(27202);
        throw null;
      }
    }
    else if ((paramInt1 == 4) && (paramInt2 == -24) && (!Util.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(27202);
      throw null;
    }
    AppMethodBeat.o(27202);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.l
 * JD-Core Version:    0.7.0.1
 */