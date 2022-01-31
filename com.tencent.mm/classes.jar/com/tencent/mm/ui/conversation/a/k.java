package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.model.bb;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.ui.MMImageView;

public final class k
  extends b
{
  protected bb vUO = null;
  
  public k(Context paramContext, bb parambb)
  {
    super(paramContext);
    this.vUO = parambb;
    int i;
    int j;
    if (this.view != null)
    {
      paramContext = (MMImageView)this.view.findViewById(R.h.mainframe_banner_icon);
      parambb = (TextView)this.view.findViewById(R.h.mainframe_banner_text);
      switch (this.vUO.type)
      {
      case 5: 
      default: 
        parambb = this.view;
        i = this.vUO.type;
        j = this.vUO.showType;
        switch (i)
        {
        case 5: 
        default: 
          paramContext = null;
        }
        break;
      }
    }
    for (;;)
    {
      parambb.setOnClickListener(paramContext);
      return;
      paramContext.setImageResource(R.k.userguide_bindmb_icon);
      parambb.setText(R.l.banner_bind_mobile_hint);
      break;
      paramContext.setImageResource(R.k.userguide_contacts_icon);
      parambb.setText(R.l.find_mcontact_add_frined_btn);
      break;
      paramContext.setImageResource(R.k.userguide_avatar_icon);
      parambb.setText(R.l.banner_upload_avatar_hint);
      break;
      paramContext.setImageResource(R.k.userguide_nearfriends_icon);
      parambb.setText(R.l.banner_meet_nearby_hint);
      break;
      paramContext.setImageResource(R.k.userguide_emostore_icon);
      parambb.setText(R.l.banner_open_sticker_shop_hint);
      break;
      paramContext.setImageResource(R.k.userguide_gamecenter_icon);
      parambb.setText(R.l.banner_open_games_hint);
      break;
      paramContext.setImageResource(R.k.userguide_grounpmessage_icon);
      parambb.setText(R.l.banner_send_broadcast_message_hint);
      break;
      paramContext.setImageResource(R.k.userguide_moments_icon);
      parambb.setText(R.l.banner_moments_timeline_hint);
      break;
      paramContext.setImageResource(R.k.userguide_autoadd_icon);
      parambb.setText(R.l.banner_auto_add_friends_hint);
      break;
      paramContext = new k.1(this, i, j);
      continue;
      paramContext = new k.2(this, i, j);
      continue;
      paramContext = new k.3(this, i, j);
      continue;
      paramContext = new k.4(this, i, j);
      continue;
      paramContext = new k.5(this, i, j);
      continue;
      paramContext = new k.6(this, i, j);
      continue;
      paramContext = new k.7(this, i, j);
      continue;
      paramContext = new k.8(this, i, j);
      continue;
      paramContext = new k.9(this, i, j);
    }
  }
  
  public final void destroy() {}
  
  public final int getLayoutId()
  {
    return R.i.mainframe_banner_header_view;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.k
 * JD-Core Version:    0.7.0.1
 */