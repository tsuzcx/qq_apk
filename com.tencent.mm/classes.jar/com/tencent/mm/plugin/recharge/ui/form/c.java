package com.tencent.mm.plugin.recharge.ui.form;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.recharge.model.a;
import com.tencent.mm.sdk.platformtools.y;

public final class c
{
  private static String TAG = "MicroMsg.CommonHintViewConfig";
  
  public static void b(MallFormView paramMallFormView)
  {
    if (paramMallFormView == null)
    {
      y.e(TAG, "hy: param error");
      return;
    }
    paramMallFormView.setLogicDelegate(new c.1());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.form.c
 * JD-Core Version:    0.7.0.1
 */