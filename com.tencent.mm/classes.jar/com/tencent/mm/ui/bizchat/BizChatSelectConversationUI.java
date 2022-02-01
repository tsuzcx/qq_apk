package com.tencent.mm.ui.bizchat;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.al.a.c;
import com.tencent.mm.al.a.e;
import com.tencent.mm.al.a.k;
import com.tencent.mm.al.a.l;
import com.tencent.mm.al.af;
import com.tencent.mm.model.az;
import com.tencent.mm.model.v;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.protocal.protobuf.apz;
import com.tencent.mm.protocal.protobuf.mk;
import com.tencent.mm.protocal.protobuf.zr;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.r;
import com.tencent.mm.ui.z;
import java.util.HashMap;

@com.tencent.mm.ui.base.a(19)
public class BizChatSelectConversationUI
  extends MMBaseSelectContactUI
  implements com.tencent.mm.al.o
{
  k HHb;
  private TextView HIi;
  private String nxJ = null;
  private int scene = 0;
  private p tipDialog = null;
  
  private void B(final String paramString1, String paramString2, final long paramLong)
  {
    AppMethodBeat.i(34041);
    com.tencent.mm.pluginsdk.ui.applet.o.a(this.mController, paramLong, getString(2131762565), paramString2, getString(2131755884), new y.a()
    {
      public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(34027);
        if (paramAnonymousBoolean)
        {
          paramAnonymousString = new Intent();
          paramAnonymousString.putExtra("enterprise_biz_name", paramString1);
          paramAnonymousString.putExtra("key_biz_chat_id", paramLong);
          paramAnonymousString.putExtra("key_is_biz_chat", true);
          BizChatSelectConversationUI.this.setResult(-1, paramAnonymousString);
          BizChatSelectConversationUI.this.finish();
        }
        AppMethodBeat.o(34027);
      }
    });
    AppMethodBeat.o(34041);
  }
  
  private void C(final String paramString1, String paramString2, final long paramLong)
  {
    AppMethodBeat.i(34042);
    com.tencent.mm.pluginsdk.ui.applet.o.a(this.mController, paramLong, getString(2131762565), paramString2, getString(2131755884), new y.a()
    {
      public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(34028);
        if (paramAnonymousBoolean)
        {
          paramAnonymousString = new Intent();
          paramAnonymousString.putExtra("enterprise_biz_name", paramString1);
          paramAnonymousString.putExtra("key_biz_chat_id", paramLong);
          paramAnonymousString.putExtra("key_is_biz_chat", true);
          BizChatSelectConversationUI.this.setResult(-1, paramAnonymousString);
          BizChatSelectConversationUI.this.finish();
        }
        AppMethodBeat.o(34028);
      }
    });
    AppMethodBeat.o(34042);
  }
  
  private com.tencent.mm.ui.widget.a.d a(String paramString1, String paramString2, String paramString3, final String paramString4, final long paramLong)
  {
    AppMethodBeat.i(34043);
    paramString1 = com.tencent.mm.pluginsdk.ui.applet.o.a(getController(), paramString1, paramString3, paramString2, true, getResources().getString(2131755884), new y.a()
    {
      public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(34029);
        if (paramAnonymousBoolean)
        {
          Intent localIntent = new Intent();
          localIntent.putExtra("enterprise_biz_name", paramString4);
          localIntent.putExtra("key_biz_chat_id", paramLong);
          localIntent.putExtra("key_is_biz_chat", true);
          if (!bs.isNullOrNil(paramAnonymousString)) {
            localIntent.putExtra("enterprise_share_append_text", paramAnonymousString);
          }
          BizChatSelectConversationUI.this.setResult(-1, localIntent);
          BizChatSelectConversationUI.this.finish();
        }
        AppMethodBeat.o(34029);
      }
    });
    AppMethodBeat.o(34043);
    return paramString1;
  }
  
  private void a(String paramString, long paramLong, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(34040);
    ac.i("MicroMsg.BizChatSelectConversationUI", "doClickUser=%s", new Object[] { paramString });
    if (this.scene == 2)
    {
      if (getIntent().getBooleanExtra("enterprise_extra_params", true))
      {
        B(paramString, String.valueOf(paramCharSequence), paramLong);
        AppMethodBeat.o(34040);
        return;
      }
      C(paramString, String.valueOf(paramCharSequence), paramLong);
      AppMethodBeat.o(34040);
      return;
    }
    if (this.scene == 1)
    {
      paramCharSequence = (HashMap)getIntent().getSerializableExtra("enterprise_extra_params");
      String str1 = (String)paramCharSequence.get("img_url");
      String str2 = (String)paramCharSequence.get("desc");
      a((String)paramCharSequence.get("title"), str2, str1, paramString, paramLong);
    }
    AppMethodBeat.o(34040);
  }
  
  private void fjK()
  {
    AppMethodBeat.i(34034);
    if (bs.isNullOrNil(this.nxJ))
    {
      this.nxJ = getIntent().getStringExtra("enterprise_biz_name");
      if (bs.isNullOrNil(this.nxJ))
      {
        ac.e("MicroMsg.BizChatSelectConversationUI", "brandUserName is null");
        finish();
      }
    }
    AppMethodBeat.o(34034);
  }
  
  public final void a(int paramInt, n paramn)
  {
    AppMethodBeat.i(34046);
    if ((this.tipDialog != null) && (this.tipDialog.isShowing()))
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    if (paramn.getType() == 1355)
    {
      paramn = ((com.tencent.mm.al.a.o)paramn).aDr();
      paramn = af.aCY().Bp(paramn.EtV.EIW.Ebl);
      if (paramn == null)
      {
        Toast.makeText(ai.getContext(), getString(2131762583), 0).show();
        AppMethodBeat.o(34046);
        return;
      }
      a(this.nxJ, paramn.field_bizChatLocalId, paramn.field_chatName);
    }
    AppMethodBeat.o(34046);
  }
  
  public final void a(ListView paramListView, int paramInt)
  {
    AppMethodBeat.i(34037);
    super.a(paramListView, paramInt);
    if (this.HIi == null)
    {
      Object localObject = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(34026);
          BizChatSelectConversationUI.a(BizChatSelectConversationUI.this);
          AppMethodBeat.o(34026);
        }
      };
      String str = getString(2131763002);
      View localView = z.jD(this).inflate(2131494420, null);
      localView.setOnClickListener((View.OnClickListener)localObject);
      localObject = (TextView)localView.findViewById(2131298778);
      ((TextView)localObject).setText(str);
      paramListView.addHeaderView(localView);
      this.HIi = ((TextView)localObject);
    }
    this.HIi.setVisibility(paramInt);
    AppMethodBeat.o(34037);
  }
  
  public final boolean aOi()
  {
    return false;
  }
  
  public final boolean aOj()
  {
    return false;
  }
  
  public final String aOk()
  {
    AppMethodBeat.i(34044);
    String str = v.wk(this.nxJ);
    AppMethodBeat.o(34044);
    return str;
  }
  
  public final com.tencent.mm.ui.contact.q aOl()
  {
    AppMethodBeat.i(34035);
    fjK();
    d locald = new d(this, this.nxJ);
    AppMethodBeat.o(34035);
    return locald;
  }
  
  public final com.tencent.mm.ui.contact.o aOm()
  {
    AppMethodBeat.i(34036);
    fjK();
    r localr = new r(this, this.nxJ);
    AppMethodBeat.o(34036);
    return localr;
  }
  
  public final void dax()
  {
    AppMethodBeat.i(34038);
    super.dax();
    AppMethodBeat.o(34038);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(34045);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(34045);
      return;
    }
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(34045);
      return;
    }
    paramIntent = paramIntent.getBundleExtra("result_data");
    apz localapz;
    if (paramIntent != null)
    {
      ac.i("MicroMsg.BizChatSelectConversationUI", "bundle != null");
      String str = paramIntent.getString("enterprise_members");
      localapz = new apz();
      c localc = new c();
      if (this.HHb != null)
      {
        paramIntent = this.HHb.field_addMemberUrl;
        localc.field_addMemberUrl = paramIntent;
        localc.field_brandUserName = this.nxJ;
        if (!e.a(localc, str, null, localapz)) {
          break label257;
        }
        if (localc.field_bizChatLocalId == -1L) {
          break label204;
        }
        a(this.nxJ, localc.field_bizChatLocalId, localc.field_chatName);
        paramInt1 = 1;
      }
    }
    for (;;)
    {
      if (paramInt1 == 0)
      {
        Toast.makeText(this, getString(2131762583), 0).show();
        AppMethodBeat.o(34045);
        return;
        paramIntent = null;
        break;
        label204:
        af.aDe();
        paramIntent = com.tencent.mm.al.a.h.a(this.nxJ, localapz, this);
        getString(2131755906);
        this.tipDialog = com.tencent.mm.ui.base.h.b(this, getString(2131755168), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(34030);
            az.agi().a(paramIntent);
            AppMethodBeat.o(34030);
          }
        });
        paramInt1 = 1;
        continue;
        label257:
        paramInt1 = 0;
        continue;
      }
      AppMethodBeat.o(34045);
      return;
      paramInt1 = 0;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool = false;
    AppMethodBeat.i(34032);
    super.onCreate(paramBundle);
    this.scene = getIntent().getIntExtra("biz_chat_scene", 1);
    fjK();
    paramBundle = af.aDa().dQ(this.nxJ);
    this.HHb = af.aDa().dP(paramBundle);
    String str = this.nxJ;
    if (this.HHb == null) {
      bool = true;
    }
    ac.i("MicroMsg.BizChatSelectConversationUI", "updateBizChatMyUserInfo: %s:%s,myBizChatUserInfo is null:%s", new Object[] { str, paramBundle, Boolean.valueOf(bool) });
    if ((bs.isNullOrNil(paramBundle)) || (this.HHb == null) || (this.HHb.aDm()) || (bs.isNullOrNil(this.HHb.field_addMemberUrl)))
    {
      af.aDe();
      com.tencent.mm.al.a.h.a(this.nxJ, this);
      paramBundle = getActivity();
      getString(2131755906);
      this.tipDialog = com.tencent.mm.ui.base.h.b(paramBundle, getString(2131755936), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(34031);
          BizChatSelectConversationUI.this.finish();
          AppMethodBeat.o(34031);
        }
      });
    }
    AppMethodBeat.o(34032);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(34033);
    super.onDestroy();
    AppMethodBeat.o(34033);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void qG(int paramInt)
  {
    AppMethodBeat.i(34039);
    if (paramInt < getContentLV().getHeaderViewsCount())
    {
      ac.i("MicroMsg.BizChatSelectConversationUI", "Click HeaderView position=%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(34039);
      return;
    }
    if (!(getContentLV().getAdapter().getItem(paramInt) instanceof a))
    {
      ac.w("MicroMsg.BizChatSelectConversationUI", "Click HeaderView not BizChatConvDataItem");
      AppMethodBeat.o(34039);
      return;
    }
    a locala = (a)getContentLV().getAdapter().getItem(paramInt);
    if (locala == null)
    {
      AppMethodBeat.o(34039);
      return;
    }
    String str = locala.username;
    long l = locala.nxq;
    if ((str == null) || (l == -1L))
    {
      ac.i("MicroMsg.BizChatSelectConversationUI", "onclick err userName:%s,bizChatId:%s", new Object[] { str, Long.valueOf(l) });
      AppMethodBeat.o(34039);
      return;
    }
    a(str, l, locala.iCd);
    AppMethodBeat.o(34039);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatSelectConversationUI
 * JD-Core Version:    0.7.0.1
 */