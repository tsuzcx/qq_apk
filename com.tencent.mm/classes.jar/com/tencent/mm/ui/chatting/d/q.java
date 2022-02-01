package com.tencent.mm.ui.chatting.d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ab;
import com.tencent.mm.msgsubscription.presenter.SubscribeMsgSettingData;
import com.tencent.mm.msgsubscription.util.c;
import com.tencent.mm.plugin.appbrand.config.ae;
import com.tencent.mm.plugin.appbrand.config.y;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.o;

@com.tencent.mm.ui.chatting.d.a.a(gRF=o.class)
public class q
  extends a
  implements o
{
  private String PoN;
  
  private boolean gPo()
  {
    AppMethodBeat.i(233095);
    if (Util.isNullOrNil(this.dom.getTalkerUserName()))
    {
      AppMethodBeat.o(233095);
      return false;
    }
    if ((ab.Jx(this.dom.getTalkerUserName())) && (!Util.isNullOrNil(this.PoN)))
    {
      AppMethodBeat.o(233095);
      return true;
    }
    AppMethodBeat.o(233095);
    return false;
  }
  
  public final void gIk()
  {
    AppMethodBeat.i(233090);
    super.gIk();
    this.PoN = this.dom.Pwc.getStringExtra("key_notify_message_real_username");
    if (!gPo())
    {
      AppMethodBeat.o(233090);
      return;
    }
    AppMethodBeat.o(233090);
  }
  
  public final boolean gPG()
  {
    AppMethodBeat.i(233092);
    if (!gPo())
    {
      AppMethodBeat.o(233092);
      return false;
    }
    ((com.tencent.mm.ui.chatting.d.b.aa)this.dom.bh(com.tencent.mm.ui.chatting.d.b.aa.class)).gQs();
    AppMethodBeat.o(233092);
    return true;
  }
  
  public final boolean gPH()
  {
    AppMethodBeat.i(233093);
    boolean bool = gPo();
    AppMethodBeat.o(233093);
    return bool;
  }
  
  public final String gPI()
  {
    return this.PoN;
  }
  
  public final void j(LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(233091);
    if (!gPo())
    {
      AppMethodBeat.o(233091);
      return;
    }
    if (Util.isNullOrNil(this.PoN))
    {
      Log.e("MicroMsg.ChattingServiceNotifyComponent", "username is null");
      AppMethodBeat.o(233091);
      return;
    }
    boolean bool = as.HF(this.PoN);
    Activity localActivity = this.dom.Pwc.getContext();
    Object localObject = paramLinearLayout.findViewById(2131298537);
    ImageView localImageView = (ImageView)paramLinearLayout.findViewById(2131306181);
    TextView localTextView2 = (TextView)paramLinearLayout.findViewById(2131306237);
    TextView localTextView1 = (TextView)paramLinearLayout.findViewById(2131306269);
    if (localObject != null) {
      ((View)localObject).setOnClickListener(new q.1(this, bool, localActivity));
    }
    if (localImageView != null) {
      a.b.d(localImageView, this.PoN);
    }
    paramLinearLayout = "";
    if (localTextView2 != null)
    {
      if (bool)
      {
        localObject = y.Xr(this.PoN);
        if (localObject != null) {
          paramLinearLayout = ((ae)localObject).nickname;
        }
        localTextView2.setText(com.tencent.mm.model.aa.getDisplayName(paramLinearLayout));
      }
    }
    else if (localTextView1 != null) {
      if (!bool) {
        break label215;
      }
    }
    label215:
    for (paramLinearLayout = localActivity.getString(2131756040);; paramLinearLayout = localActivity.getString(2131761000))
    {
      localTextView1.setText(paramLinearLayout);
      AppMethodBeat.o(233091);
      return;
      paramLinearLayout = com.tencent.mm.model.aa.getDisplayName(this.PoN);
      break;
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(233094);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (!gPo())
    {
      AppMethodBeat.o(233094);
      return;
    }
    if ((paramInt1 == 100) && (paramIntent != null))
    {
      Log.i("MicroMsg.ChattingServiceNotifyComponent", "receive data from subscribe msg");
      paramIntent = (SubscribeMsgSettingData)paramIntent.getParcelableExtra("key_biz_data");
      if (paramIntent != null)
      {
        c localc = c.jDh;
        c.a(this.PoN, paramIntent, new aj(this.dom.Pwc.getContext(), this.PoN));
      }
    }
    AppMethodBeat.o(233094);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.q
 * JD-Core Version:    0.7.0.1
 */