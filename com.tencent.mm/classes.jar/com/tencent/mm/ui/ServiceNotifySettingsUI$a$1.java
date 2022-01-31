package com.tencent.mm.ui;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h;

final class ServiceNotifySettingsUI$a$1
  implements View.OnClickListener
{
  ServiceNotifySettingsUI$a$1(ServiceNotifySettingsUI.a parama, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(29856);
    String str = (String)paramView.getTag();
    if (TextUtils.isEmpty(str))
    {
      AppMethodBeat.o(29856);
      return;
    }
    paramView = paramView.getContext();
    int i;
    if (this.zeY == 1)
    {
      i = 2131301985;
      if (this.zeY != 1) {
        break label101;
      }
    }
    label101:
    for (int j = 2131301986;; j = 2131297018)
    {
      h.a(paramView, i, 0, j, 2131297837, false, new ServiceNotifySettingsUI.a.1.1(this, str), new ServiceNotifySettingsUI.a.1.2(this), 2131690139);
      AppMethodBeat.o(29856);
      return;
      i = 2131301989;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.ServiceNotifySettingsUI.a.1
 * JD-Core Version:    0.7.0.1
 */