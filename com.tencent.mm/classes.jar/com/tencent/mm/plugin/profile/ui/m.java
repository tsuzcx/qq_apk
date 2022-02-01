package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.sns.c.b;
import com.tencent.mm.plugin.sns.c.k;
import com.tencent.mm.plugin.sns.c.k.a;
import com.tencent.mm.plugin.sns.c.q;
import com.tencent.mm.pluginsdk.c.a;
import com.tencent.mm.pluginsdk.model.v;
import com.tencent.mm.sdk.platformtools.DoNotCheckLeakForActivities;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.preference.f;
import junit.framework.Assert;

@DoNotCheckLeakForActivities({ContactInfoUI.class})
public final class m
  implements h, k.a, a
{
  public final void a(String paramString1, String paramString2, boolean paramBoolean1, int paramInt, b paramb, boolean paramBoolean2) {}
  
  public final void a(String paramString, boolean paramBoolean, int paramInt, b paramb)
  {
    AppMethodBeat.i(27203);
    AppMethodBeat.o(27203);
    throw null;
  }
  
  public final boolean a(f paramf, au paramau, boolean paramBoolean, int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(27193);
    if (paramau != null)
    {
      paramBoolean = true;
      Assert.assertTrue(paramBoolean);
      if (Util.nullAsNil(paramau.field_username).length() <= 0) {
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
  
  public final boolean anl(String paramString)
  {
    AppMethodBeat.i(27190);
    if (paramString.equals("contact_info_sns"))
    {
      bh.bCz();
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
  
  public final boolean dvq()
  {
    AppMethodBeat.i(27201);
    if (q.Qkn != null) {
      q.Qkn.a(this, 3);
    }
    bh.aZW().b(30, this);
    bh.aZW().b(453, this);
    AppMethodBeat.o(27201);
    throw null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(27202);
    if ((paramp.getType() != 30) && (paramp.getType() != 458))
    {
      Log.w("MicroMsg.ContactWidgetNormal", "not expected scene,  type = " + paramp.getType());
      AppMethodBeat.o(27202);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramp.getType() == 30)
      {
        paramString = (v)paramp;
        if ((paramString.hId != 1) && (paramString.hId != 3))
        {
          AppMethodBeat.o(27202);
          return;
        }
        if (paramString.XRr != null)
        {
          AppMethodBeat.o(27202);
          throw null;
        }
        AppMethodBeat.o(27202);
        throw null;
      }
      if (paramp.getType() == 453)
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
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.m
 * JD-Core Version:    0.7.0.1
 */