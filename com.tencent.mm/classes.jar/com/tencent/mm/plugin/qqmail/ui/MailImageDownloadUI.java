package com.tencent.mm.plugin.qqmail.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.av.e;
import com.tencent.mm.av.o;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.i;

public class MailImageDownloadUI
  extends MMActivity
  implements com.tencent.mm.ak.g, com.tencent.mm.ak.h
{
  private long dpl;
  private int hGP;
  private ao handler;
  private long msgId;
  private TextView oLU;
  private String username;
  private ProgressBar vYV;
  private TextView vYW;
  private TextView vYX;
  private TextView vYY;
  private RelativeLayout vYZ;
  private e vZa;
  private com.tencent.mm.av.k vZb;
  private ImageView vZc;
  private LinearLayout vZd;
  
  public MailImageDownloadUI()
  {
    AppMethodBeat.i(123110);
    this.handler = new ao(Looper.getMainLooper());
    this.msgId = 0L;
    this.dpl = 0L;
    AppMethodBeat.o(123110);
  }
  
  private void LP(int paramInt)
  {
    AppMethodBeat.i(123115);
    this.vYW.setText(getString(2131759531, new Object[] { Integer.valueOf(paramInt) }));
    if (paramInt < this.vYV.getMax())
    {
      AppMethodBeat.o(123115);
      return;
    }
    Object localObject = o.aFx().c(Long.valueOf(this.vZb.hIm));
    if (this.hGP == 1) {
      com.tencent.mm.av.f.c((e)localObject);
    }
    finish();
    localObject = getIntent();
    localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/qqmail/ui/MailImageDownloadUI", "updateProgress", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/MailImageDownloadUI", "updateProgress", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(123115);
  }
  
  public final void a(int paramInt1, int paramInt2, n paramn)
  {
    AppMethodBeat.i(123116);
    ac.d("MicroMsg.MailImageDownloadUI", "offset " + paramInt1 + "totaolLen  " + paramInt2);
    if (paramn.getType() == 109) {
      if (paramInt2 == 0) {
        break label72;
      }
    }
    label72:
    for (paramInt1 = paramInt1 * 100 / paramInt2 - 1;; paramInt1 = 0)
    {
      LP(Math.max(0, paramInt1));
      AppMethodBeat.o(123116);
      return;
    }
  }
  
  public int getLayoutId()
  {
    return 2131494679;
  }
  
  public void initView()
  {
    AppMethodBeat.i(123114);
    this.vYW = ((TextView)findViewById(2131300925));
    this.vYX = ((TextView)findViewById(2131300925));
    this.oLU = ((TextView)findViewById(2131300926));
    this.vYY = ((TextView)findViewById(2131300923));
    this.vZc = ((ImageView)findViewById(2131301979));
    this.vYW.setVisibility(0);
    this.vZd = ((LinearLayout)findViewById(2131300922));
    this.vYZ = ((RelativeLayout)findViewById(2131301980));
    this.vYX.setVisibility(8);
    this.oLU.setVisibility(8);
    this.vYY.setVisibility(8);
    setTitleVisibility(8);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(123109);
        com.tencent.mm.kernel.g.agQ().ghe.a(MailImageDownloadUI.a(MailImageDownloadUI.this));
        MailImageDownloadUI.this.finish();
        AppMethodBeat.o(123109);
        return true;
      }
    });
    this.vYV = ((ProgressBar)findViewById(2131300924));
    AppMethodBeat.o(123114);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(123111);
    super.onCreate(paramBundle);
    this.msgId = getIntent().getLongExtra("img_msg_id", 0L);
    this.dpl = getIntent().getLongExtra("img_server_id", 0L);
    this.hGP = getIntent().getIntExtra("img_download_compress_type", 0);
    this.username = getIntent().getStringExtra("img_download_username");
    initView();
    if (this.msgId > 0L) {
      this.vZa = o.aFx().qg(this.msgId);
    }
    if (((this.vZa == null) || (this.vZa.dcd <= 0L)) && (this.dpl > 0L)) {
      this.vZa = o.aFx().qf(this.dpl);
    }
    if ((this.vZa == null) || (this.vZa.dcd <= 0L))
    {
      ac.e("MicroMsg.MailImageDownloadUI", "onCreate : on such imginfo, with msgLocalId = " + this.msgId + ", or msgSvrId = " + this.dpl);
      AppMethodBeat.o(123111);
      return;
    }
    if ((this.msgId <= 0L) && (this.dpl > 0L)) {
      this.msgId = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().aF(this.username, this.dpl).field_msgId;
    }
    paramBundle = this.vZa.hGM;
    String str = o.aFx().p(paramBundle, null, null);
    if ((!bs.isNullOrNil(paramBundle)) && (i.eA(str)))
    {
      ac.i("MicroMsg.MailImageDownloadUI", "has big image, bigImgPath = %s, hasHDImg = %b, fullPath = %s", new Object[] { paramBundle, Boolean.valueOf(this.vZa.aFa()), str });
      if ((str == null) || (str.equals("")) || (!i.eA(str)))
      {
        ac.d("MicroMsg.MailImageDownloadUI", "showImg : imgPath is null");
        AppMethodBeat.o(123111);
        return;
      }
      this.vZd.setVisibility(8);
      this.vYV.setVisibility(8);
      this.vZc.setVisibility(0);
      paramBundle = com.tencent.mm.sdk.platformtools.f.aKz(str);
      this.vZc.setImageBitmap(paramBundle);
      this.vYZ.invalidate();
      AppMethodBeat.o(123111);
      return;
    }
    this.vZb = new com.tencent.mm.av.k(this.vZa.dcd, this.msgId, this.hGP, this);
    com.tencent.mm.kernel.g.agQ().ghe.a(this.vZb, 0);
    AppMethodBeat.o(123111);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(123112);
    super.onPause();
    com.tencent.mm.kernel.g.agQ().ghe.b(109, this);
    AppMethodBeat.o(123112);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(123113);
    super.onResume();
    com.tencent.mm.kernel.g.agQ().ghe.a(109, this);
    AppMethodBeat.o(123113);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(123117);
    if (paramn.getType() != 109)
    {
      AppMethodBeat.o(123117);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      LP(this.vYV.getMax());
      AppMethodBeat.o(123117);
      return;
    }
    ac.e("MicroMsg.MailImageDownloadUI", "onSceneEnd : fail, errType = " + paramInt1 + ", errCode = " + paramInt2);
    Toast.makeText(this, 2131760323, 1).show();
    AppMethodBeat.o(123117);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.MailImageDownloadUI
 * JD-Core Version:    0.7.0.1
 */