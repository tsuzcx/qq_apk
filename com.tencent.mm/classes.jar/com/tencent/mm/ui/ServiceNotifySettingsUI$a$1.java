package com.tencent.mm.ui;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R.e;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.base.h;

final class ServiceNotifySettingsUI$a$1
  implements View.OnClickListener
{
  ServiceNotifySettingsUI$a$1(ServiceNotifySettingsUI.a parama, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    String str = (String)paramView.getTag();
    if (TextUtils.isEmpty(str)) {
      return;
    }
    paramView = paramView.getContext();
    int i;
    if (this.uQO == 1)
    {
      i = R.l.notify_message_settings_receive_app_brand_custom_session_msg_title;
      if (this.uQO != 1) {
        break label88;
      }
    }
    label88:
    for (int j = R.l.notify_message_settings_receive_app_brand_custom_session_msg_title_ok;; j = R.l.app_ok)
    {
      h.a(paramView, i, 0, j, R.l.cancel, false, new ServiceNotifySettingsUI.a.1.1(this, str), new ServiceNotifySettingsUI.a.1.2(this), R.e.green_text_color);
      return;
      i = R.l.notify_message_settings_receive_app_brand_msg_title;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.ServiceNotifySettingsUI.a.1
 * JD-Core Version:    0.7.0.1
 */