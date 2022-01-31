package com.tencent.mm.wallet_core.ui;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.view.LayoutInflater;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.c;

public final class b
{
  public static c a(Context paramContext, int paramInt, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    return h.a(paramContext, paramString1, paramString2, ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(paramInt, null), paramOnClickListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.b
 * JD-Core Version:    0.7.0.1
 */