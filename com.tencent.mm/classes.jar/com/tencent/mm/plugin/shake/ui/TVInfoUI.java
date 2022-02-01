package com.tencent.mm.plugin.shake.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.am.ag;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.cq;
import com.tencent.mm.g.a.cq.a;
import com.tencent.mm.g.a.cq.b;
import com.tencent.mm.g.a.io;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ba;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.shake.e.a.a;
import com.tencent.mm.plugin.shake.e.c.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.bjb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.LinkedList;

public class TVInfoUI
  extends MMPreference
  implements com.tencent.mm.al.f, u.a
{
  protected ProgressDialog fMu = null;
  private long msgId;
  private ImageView oHo;
  protected com.tencent.mm.ui.base.preference.f screen;
  private TextView titleTv;
  private String yQA = "";
  private TextView yQB;
  private c.a yQC;
  private boolean yQD = false;
  private com.tencent.mm.plugin.shake.e.b yQE;
  private boolean yrB = false;
  
  private void a(final c.a parama)
  {
    AppMethodBeat.i(28592);
    if (parama == null)
    {
      ad.e("MicroMsg.TVInfoUI", "refreshViewByProduct(), pd == null");
      finish();
      AppMethodBeat.o(28592);
      return;
    }
    this.titleTv.setText(parama.field_title);
    if (bt.isNullOrNil(parama.field_topic)) {
      this.yQB.setVisibility(8);
    }
    for (;;)
    {
      this.oHo = ((ImageView)findViewById(2131306165));
      if (!bt.isNullOrNil(parama.field_playurl))
      {
        ImageView localImageView = (ImageView)findViewById(2131306164);
        localImageView.setVisibility(0);
        localImageView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(28579);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/shake/ui/TVInfoUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            g.yhR.f(10987, new Object[] { Integer.valueOf(2), parama.field_playstatid, "", "" });
            TVInfoUI.a(TVInfoUI.this, parama.field_playurl);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/TVInfoUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(28579);
          }
        });
        this.oHo.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(28580);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/shake/ui/TVInfoUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            g.yhR.f(10987, new Object[] { Integer.valueOf(2), parama.field_playstatid, "", "" });
            TVInfoUI.a(TVInfoUI.this, parama.field_playurl);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/TVInfoUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(28580);
          }
        });
      }
      addIconOptionMenu(0, 2131690603, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(28581);
          TVInfoUI.a(TVInfoUI.this);
          AppMethodBeat.o(28581);
          return true;
        }
      });
      if ((!bt.isNullOrNil(parama.field_id)) && (!this.yQD) && (!getIntent().getBooleanExtra("key_TV_come_from_shake", false)))
      {
        int i = getIntent().getIntExtra("key_TV_getProductInfoScene", 0);
        ad.d("MicroMsg.TVInfoUI", "GetTVInfo id[%s], scene[%s]", new Object[] { parama.field_id, Integer.valueOf(i) });
        ba.aiU().a(new com.tencent.mm.plugin.shake.d.a.b(parama.field_id, i), 0);
        this.yQD = true;
      }
      this.oHo.setVisibility(0);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(28582);
          TVInfoUI.this.finish();
          AppMethodBeat.o(28582);
          return true;
        }
      });
      ad.v("MicroMsg.TVInfoUI", "start postToMainThread initBodyView");
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(28583);
          TVInfoUI.a(TVInfoUI.this, parama);
          TVInfoUI.b(TVInfoUI.this, parama);
          AppMethodBeat.o(28583);
        }
      });
      AppMethodBeat.o(28592);
      return;
      this.yQB.setText(parama.field_topic);
    }
  }
  
  private void dLH()
  {
    AppMethodBeat.i(28593);
    this.msgId = getIntent().getLongExtra("key_TVInfoUI_chatting_msgId", 0L);
    if ((this.msgId > 0L) && (ba.ajx()))
    {
      ba.aBQ();
      bu localbu = com.tencent.mm.model.c.azs().xY(this.msgId);
      if (localbu.field_msgId > 0L)
      {
        localbu.tO(this.yQE.aQw());
        ba.aBQ();
        com.tencent.mm.model.c.azs().a(this.msgId, localbu);
      }
    }
    AppMethodBeat.o(28593);
  }
  
  public int getHeaderResourceId()
  {
    return 2131495810;
  }
  
  public int getLayoutId()
  {
    return 2131495809;
  }
  
  public int getResourceId()
  {
    return 2131951752;
  }
  
  public void initView()
  {
    AppMethodBeat.i(28591);
    setMMTitle(2131762884);
    this.screen = getPreferenceScreen();
    this.titleTv = ((TextView)findViewById(2131306166));
    this.yQB = ((TextView)findViewById(2131306167));
    String str2 = getIntent().getStringExtra("key_TV_xml");
    String str1 = str2;
    if (bt.isNullOrNil(str2))
    {
      byte[] arrayOfByte = getIntent().getByteArrayExtra("key_TV_xml_bytes");
      str1 = str2;
      if (arrayOfByte != null) {
        str1 = new String(arrayOfByte);
      }
    }
    ad.d("MicroMsg.TVInfoUI", "tvinfo xml : %s", new Object[] { str1 });
    this.yQC = com.tencent.mm.plugin.shake.e.c.axu(str1);
    if (this.yQC == null)
    {
      ad.e("MicroMsg.TVInfoUI", "initView(), tv == null");
      finish();
      AppMethodBeat.o(28591);
      return;
    }
    a(this.yQC);
    AppMethodBeat.o(28591);
  }
  
  public final void k(final String paramString, final Bitmap paramBitmap)
  {
    AppMethodBeat.i(28595);
    if (paramString != null)
    {
      if (paramBitmap == null) {}
      for (boolean bool = true;; bool = false)
      {
        ad.d("MicroMsg.TVInfoUI", "onGetPictureFinish pic, url = [%s], bitmap is null ? [%B]", new Object[] { paramString, Boolean.valueOf(bool) });
        try
        {
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(28586);
              if ((TVInfoUI.e(TVInfoUI.this) != null) && (TVInfoUI.e(TVInfoUI.this).equals(paramString)))
              {
                if ((TVInfoUI.f(TVInfoUI.this) != null) && (paramBitmap != null))
                {
                  TVInfoUI.f(TVInfoUI.this).setImageBitmap(paramBitmap);
                  TVInfoUI.g(TVInfoUI.this);
                }
                TVInfoUI.h(TVInfoUI.this);
              }
              AppMethodBeat.o(28586);
            }
          });
          AppMethodBeat.o(28595);
          return;
        }
        catch (Exception paramString)
        {
          ad.e("MicroMsg.TVInfoUI", "onGetPictureFinish : [%s]", new Object[] { paramString.getLocalizedMessage() });
          ad.printErrStackTrace("MicroMsg.TVInfoUI", paramString, "", new Object[0]);
          AppMethodBeat.o(28595);
          return;
        }
      }
    }
    ad.e("MicroMsg.TVInfoUI", "onUpdateEnable pic, url  is null ");
    AppMethodBeat.o(28595);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(28587);
    super.onCreate(paramBundle);
    u.b(this);
    initView();
    AppMethodBeat.o(28587);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(28590);
    u.c(this);
    super.onDestroy();
    AppMethodBeat.o(28590);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(28589);
    ba.aiU().b(552, this);
    super.onPause();
    AppMethodBeat.o(28589);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(28594);
    ad.d("MicroMsg.TVInfoUI", "onPreferenceTreeClick item: [%s]", new Object[] { paramPreference.mKey });
    if ((this.yQC == null) || (this.yQC.yAm == null))
    {
      ad.e("MicroMsg.TVInfoUI", "tv == null || tv.actionlist == null");
      AppMethodBeat.o(28594);
      return false;
    }
    for (;;)
    {
      Intent localIntent;
      try
      {
        int i = Integer.valueOf(paramPreference.mKey).intValue();
        int j = i / 100;
        int k = i % 100;
        ad.v("MicroMsg.TVInfoUI", "keyId=[%s], ii=[%s], jj=[%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
        if ((j < 0) || (j >= this.yQC.yAm.size()))
        {
          ad.w("MicroMsg.TVInfoUI", "index out of bounds, ii=[%s], list Size=[%s]", new Object[] { Integer.valueOf(j), Integer.valueOf(this.yQC.yAm.size()) });
          AppMethodBeat.o(28594);
          return false;
        }
        paramf = (com.tencent.mm.plugin.shake.e.a)this.yQC.yAm.get(j);
        if (paramf == null)
        {
          ad.w("MicroMsg.TVInfoUI", "actionList == null");
          AppMethodBeat.o(28594);
          return false;
        }
        if ((k < 0) || (k >= paramf.lFr.size()))
        {
          ad.w("MicroMsg.TVInfoUI", "index out of bounds, jj=[%s], actions Size=[%s]", new Object[] { Integer.valueOf(k), Integer.valueOf(paramf.lFr.size()) });
          AppMethodBeat.o(28594);
          return false;
        }
        paramf = (a.a)paramf.lFr.get(k);
        if (paramf == null)
        {
          ad.w("MicroMsg.TVInfoUI", "action == null");
          AppMethodBeat.o(28594);
          return false;
        }
        ad.v("MicroMsg.TVInfoUI", "action type:" + paramf.type + ", target:" + paramf.cJt + ", targetDesc:" + paramf.yQO + ", targetDesc2:" + paramf.yQP);
        if (paramf.type == 3)
        {
          paramPreference = new Intent();
          paramPreference.putExtra("rawUrl", paramf.cJt);
          paramPreference.putExtra("show_bottom", false);
          paramPreference.putExtra("geta8key_scene", 10);
          paramPreference.putExtra("srcUsername", paramf.yQP);
          com.tencent.mm.plugin.shake.a.iRG.i(paramPreference, this);
          AppMethodBeat.o(28594);
          return true;
        }
        if (paramf.type != 4) {
          break label642;
        }
        ba.aBQ();
        paramPreference = com.tencent.mm.model.c.azp().Bf(paramf.cJt);
        if (paramPreference == null) {
          continue;
        }
        localIntent = new Intent();
        if ((com.tencent.mm.o.b.lM(paramPreference.field_type)) && (paramPreference.fqg()))
        {
          ag.aFZ().DD(paramf.cJt);
          if (paramf.yQO.equals("1"))
          {
            localIntent.putExtra("Chat_User", paramf.cJt);
            localIntent.putExtra("finish_direct", true);
            com.tencent.mm.plugin.shake.a.iRG.d(localIntent, this);
            continue;
          }
        }
        localIntent.putExtra("Contact_User", paramf.cJt);
      }
      catch (Exception paramf)
      {
        ad.e("MicroMsg.TVInfoUI", "onPreferenceTreeClick, [%s]", new Object[] { paramf.getMessage() });
        ad.printErrStackTrace("MicroMsg.TVInfoUI", paramf, "", new Object[0]);
        AppMethodBeat.o(28594);
        return false;
      }
      localIntent.putExtra("force_get_contact", true);
      d.b(this, "profile", ".ui.ContactInfoUI", localIntent);
      continue;
      label642:
      if (paramf.type == 5)
      {
        paramPreference = new io();
        paramPreference.dvh.actionCode = 11;
        paramPreference.dvh.result = paramf.cJt;
        paramPreference.dvh.context = this;
        paramPreference.callback = null;
        com.tencent.mm.sdk.b.a.IbL.a(paramPreference, Looper.myLooper());
      }
      else if (paramf.type == 6)
      {
        paramPreference = new Intent();
        paramPreference.putExtra("key_product_id", paramf.cJt);
        paramPreference.putExtra("key_product_scene", 9);
        d.b(this, "product", ".ui.MallProductUI", paramPreference);
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(28588);
    super.onResume();
    ba.aiU().a(552, this);
    AppMethodBeat.o(28588);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(28596);
    if (paramn == null)
    {
      ad.w("MicroMsg.TVInfoUI", "scene == null");
      AppMethodBeat.o(28596);
      return;
    }
    if (paramn.getType() == 552)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ad.e("MicroMsg.TVInfoUI", "onSceneEnd() errType = [%s], errCode = [%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        Toast.makeText(this, 2131762885, 0).show();
        AppMethodBeat.o(28596);
        return;
      }
      if (this.yQC == null)
      {
        ad.w("MicroMsg.TVInfoUI", "onSceneEnd tv == null");
        AppMethodBeat.o(28596);
        return;
      }
      paramString = (com.tencent.mm.plugin.shake.d.a.b)paramn;
      if ((paramString.rr != null) && (paramString.rr.hNL.hNQ != null)) {}
      for (paramString = (bjb)paramString.rr.hNL.hNQ; paramString == null; paramString = null)
      {
        ad.w("MicroMsg.TVInfoUI", "onSceneEnd tvInfo == null");
        AppMethodBeat.o(28596);
        return;
      }
      if (paramString.GDJ != null)
      {
        ad.d("MicroMsg.TVInfoUI", "onSceneEnd  tvInfo.DescriptionXML != null, res:" + paramString.GDJ);
        paramString = com.tencent.mm.plugin.shake.e.c.axu(paramString.GDJ);
        if ((this.yQC != null) && (this.yQC.field_xml != null) && (paramString != null) && (paramString.field_xml != null) && (!this.yQC.field_xml.equals(paramString.field_xml)))
        {
          this.yQC = paramString;
          a(this.yQC);
        }
      }
    }
    AppMethodBeat.o(28596);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.TVInfoUI
 * JD-Core Version:    0.7.0.1
 */