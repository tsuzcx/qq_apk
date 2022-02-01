package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.wx;
import com.tencent.mm.g.a.wx.a;
import com.tencent.mm.model.v;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.msgsubscription.presenter.SubscribeMsgSettingData;
import com.tencent.mm.msgsubscription.storage.IBrandSubscribeMsgService.Companion.SubscribeMsgListWrapper;
import com.tencent.mm.msgsubscription.storage.e;
import com.tencent.mm.msgsubscription.storage.e.b;
import com.tencent.mm.msgsubscription.ui.BizSubscribeMsgManagerUI;
import com.tencent.mm.msgsubscription.util.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.MMFragmentActivity.b;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import d.y;

final class ah$2
  implements DialogInterface.OnClickListener
{
  ah$2(ah paramah, String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(37204);
    paramDialogInterface = new Intent(ah.b(this.Inu).HZF.getContext(), BizSubscribeMsgManagerUI.class);
    paramDialogInterface.putExtra("key_biz_username", this.fur);
    paramDialogInterface.putExtra("key_biz_nickname", v.wk(this.fur));
    if (this.Inz)
    {
      paramDialogInterface.putExtra("key_biz_presenter_class", com.tencent.mm.msgsubscription.presenter.d.class.getName());
      if (!this.Inz) {
        break label150;
      }
    }
    label150:
    for (paramInt = 100;; paramInt = 101)
    {
      com.tencent.mm.br.d.a((MMFragmentActivity)ah.b(this.Inu).HZF.getContext(), "com.tencent.mm.msgsubscription.ui.BizSubscribeMsgManagerUI", paramDialogInterface, paramInt, new MMFragmentActivity.b()
      {
        public final void c(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
        {
          AppMethodBeat.i(169880);
          if ((paramAnonymousInt1 == 100) && (paramAnonymousIntent != null))
          {
            paramAnonymousIntent = (SubscribeMsgSettingData)paramAnonymousIntent.getParcelableExtra("key_biz_data");
            if (paramAnonymousIntent != null)
            {
              ah.g(ah.2.this.Inu);
              c localc = c.ikO;
              c.a(ah.2.this.fur, paramAnonymousIntent, new d.g.a.b() {});
            }
            AppMethodBeat.o(169880);
            return;
          }
          if ((paramAnonymousInt1 == 101) && (paramAnonymousIntent != null))
          {
            boolean bool = paramAnonymousIntent.getBooleanExtra("key_need_update", false);
            ac.i("MicroMsg.ChattingItemDyeingTemplate", "alvinluo back from SubscribeMsgManagerUI needUpdate: %b", new Object[] { Boolean.valueOf(bool) });
            if (!bool)
            {
              AppMethodBeat.o(169880);
              return;
            }
            paramAnonymousIntent = (IBrandSubscribeMsgService.Companion.SubscribeMsgListWrapper)paramAnonymousIntent.getParcelableExtra("key_biz_data");
            if (paramAnonymousIntent != null)
            {
              ah.g(ah.2.this.Inu);
              new e(com.tencent.mm.al.b.b.hAn).a(ah.2.this.fur, paramAnonymousIntent.iir, paramAnonymousIntent.iiq, false, new e.b()
              {
                public final void a(String paramAnonymous2String, SubscribeMsgRequestResult paramAnonymous2SubscribeMsgRequestResult)
                {
                  AppMethodBeat.i(37201);
                  ac.i("MicroMsg.ChattingItemDyeingTemplate", "alvinluo updateSubscribeMsgList success");
                  ah.h(ah.2.this.Inu);
                  if (ah.b(ah.2.this.Inu) != null) {
                    ah.b(ah.2.this.Inu).bJU();
                  }
                  AppMethodBeat.o(37201);
                }
                
                public final void i(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String)
                {
                  AppMethodBeat.i(37202);
                  ac.e("MicroMsg.ChattingItemDyeingTemplate", "alvinluo updateSubscribeMsgList onError errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), paramAnonymous2String });
                  ah.h(ah.2.this.Inu);
                  t.makeText(ah.b(ah.2.this.Inu).HZF.getContext(), ah.b(ah.2.this.Inu).HZF.getContext().getString(2131761772), 1).show();
                  AppMethodBeat.o(37202);
                }
              });
            }
          }
          AppMethodBeat.o(169880);
        }
      });
      AppMethodBeat.o(37204);
      return;
      paramDialogInterface.putExtra("key_biz_presenter_class", com.tencent.mm.al.b.a.class.getName());
      paramDialogInterface.putExtra("key_need_update", false);
      paramDialogInterface.putExtra("key_need_load_from_remote", true);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ah.2
 * JD-Core Version:    0.7.0.1
 */