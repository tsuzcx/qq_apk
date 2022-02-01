package com.tencent.mm.wallet_core.ui;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.view.LayoutInflater;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.widget.a.e;

public final class b
{
  public static e a(Context paramContext, int paramInt, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(72941);
    paramContext = k.a(paramContext, paramString1, paramString2, ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(paramInt, null), paramOnClickListener);
    AppMethodBeat.o(72941);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.b
 * JD-Core Version:    0.7.0.1
 */