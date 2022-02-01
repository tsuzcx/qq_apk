package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bj.d;
import com.tencent.mm.contact.c;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.bp;
import com.tencent.mm.pluginsdk.ui.preference.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bn;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.cl;
import com.tencent.mm.storage.cm;

public final class q
{
  public static b[] a(Context paramContext, as paramas, int paramInt)
  {
    AppMethodBeat.i(27228);
    String str = Util.nullAsNil(((Activity)paramContext).getIntent().getStringExtra("Verify_ticket"));
    if (c.oR(paramas.field_type))
    {
      AppMethodBeat.o(27228);
      return null;
    }
    if (Util.isNullOrNil(str))
    {
      AppMethodBeat.o(27228);
      return null;
    }
    Log.d("MicroMsg.FMessageUtil", "initAddContent, scene = ".concat(String.valueOf(paramInt)));
    if (paramInt == 18)
    {
      Log.d("MicroMsg.FMessageUtil", "initAddContent, scene is lbs");
      paramContext = b.a(paramContext, d.bgO().bkx(paramas.field_username));
    }
    while ((paramContext == null) || (paramContext.length == 0))
    {
      AppMethodBeat.o(27228);
      return null;
      if (bp.sb(paramInt))
      {
        Log.d("MicroMsg.FMessageUtil", "initAddContent, scene is shake");
        paramContext = b.a(paramContext, d.bgP().bkW(paramas.field_username));
      }
      else
      {
        Log.d("MicroMsg.FMessageUtil", "initAddContent, scene is other");
        paramContext = b.a(paramContext, d.bgM().bku(paramas.field_username));
      }
    }
    AppMethodBeat.o(27228);
    return paramContext;
  }
  
  public static String b(Context paramContext, as paramas, int paramInt)
  {
    AppMethodBeat.i(27229);
    paramContext = Util.nullAsNil(((Activity)paramContext).getIntent().getStringExtra("Verify_ticket"));
    if (c.oR(paramas.field_type))
    {
      AppMethodBeat.o(27229);
      return null;
    }
    if (Util.isNullOrNil(paramContext))
    {
      AppMethodBeat.o(27229);
      return null;
    }
    paramContext = "";
    Log.d("MicroMsg.FMessageUtil", "initAddContent, scene = ".concat(String.valueOf(paramInt)));
    if (paramInt == 18)
    {
      Log.d("MicroMsg.FMessageUtil", "initAddContent, scene is lbs");
      paramas = d.bgO().bkx(paramas.field_username);
      if (paramas.length > 0) {
        paramContext = paramas[0].field_svrid;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(27229);
      return paramContext;
      if (bp.sb(paramInt))
      {
        Log.d("MicroMsg.FMessageUtil", "initAddContent, scene is shake");
        paramas = d.bgP().bkW(paramas.field_username);
        if (paramas.length > 0) {
          paramContext = paramas[0].field_svrid;
        }
      }
      else
      {
        Log.d("MicroMsg.FMessageUtil", "initAddContent, scene is other");
        paramas = d.bgM().bku(paramas.field_username);
        if (paramas.length > 0) {
          paramContext = paramas[0].field_svrId;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.q
 * JD-Core Version:    0.7.0.1
 */