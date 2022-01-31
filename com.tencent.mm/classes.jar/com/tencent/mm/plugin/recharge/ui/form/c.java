package com.tencent.mm.plugin.recharge.ui.form;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recharge.model.a;
import com.tencent.mm.sdk.platformtools.ab;

public final class c
{
  private static String TAG = "MicroMsg.CommonHintViewConfig";
  
  public static void b(MallFormView paramMallFormView)
  {
    AppMethodBeat.i(44374);
    if (paramMallFormView == null)
    {
      ab.e(TAG, "hy: param error");
      AppMethodBeat.o(44374);
      return;
    }
    paramMallFormView.setLogicDelegate(new c.1());
    AppMethodBeat.o(44374);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.form.c
 * JD-Core Version:    0.7.0.1
 */