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
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.t;
import com.tencent.mm.av.h;
import com.tencent.mm.av.m;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.s;

public class MailImageDownloadUI
  extends MMActivity
  implements com.tencent.mm.ak.i, j
{
  private ImageView BwA;
  private LinearLayout BwB;
  private ProgressBar Bwt;
  private TextView Bwu;
  private TextView Bwv;
  private TextView Bww;
  private RelativeLayout Bwx;
  private com.tencent.mm.av.g Bwy;
  private m Bwz;
  private long dTS;
  private MMHandler handler;
  private int iXp;
  private long msgId;
  private TextView qLz;
  private String username;
  
  public MailImageDownloadUI()
  {
    AppMethodBeat.i(123110);
    this.handler = new MMHandler(Looper.getMainLooper());
    this.msgId = 0L;
    this.dTS = 0L;
    AppMethodBeat.o(123110);
  }
  
  private void Vj(int paramInt)
  {
    AppMethodBeat.i(123115);
    this.Bwu.setText(getString(2131760846, new Object[] { Integer.valueOf(paramInt) }));
    if (paramInt < this.Bwt.getMax())
    {
      AppMethodBeat.o(123115);
      return;
    }
    Object localObject = com.tencent.mm.av.q.bcR().c(Long.valueOf(this.Bwz.iYP));
    if (this.iXp == 1) {
      h.c((com.tencent.mm.av.g)localObject);
    }
    finish();
    localObject = getIntent();
    localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/qqmail/ui/MailImageDownloadUI", "updateProgress", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/MailImageDownloadUI", "updateProgress", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(123115);
  }
  
  public final void a(int paramInt1, int paramInt2, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(123116);
    Log.d("MicroMsg.MailImageDownloadUI", "offset " + paramInt1 + "totaolLen  " + paramInt2);
    if (paramq.getType() == 109) {
      if (paramInt2 == 0) {
        break label72;
      }
    }
    label72:
    for (paramInt1 = paramInt1 * 100 / paramInt2 - 1;; paramInt1 = 0)
    {
      Vj(Math.max(0, paramInt1));
      AppMethodBeat.o(123116);
      return;
    }
  }
  
  public int getLayoutId()
  {
    return 2131495405;
  }
  
  public void initView()
  {
    AppMethodBeat.i(123114);
    this.Bwu = ((TextView)findViewById(2131302554));
    this.Bwv = ((TextView)findViewById(2131302554));
    this.qLz = ((TextView)findViewById(2131302555));
    this.Bww = ((TextView)findViewById(2131302552));
    this.BwA = ((ImageView)findViewById(2131304314));
    this.Bwu.setVisibility(0);
    this.BwB = ((LinearLayout)findViewById(2131302539));
    this.Bwx = ((RelativeLayout)findViewById(2131304315));
    this.Bwv.setVisibility(8);
    this.qLz.setVisibility(8);
    this.Bww.setVisibility(8);
    setTitleVisibility(8);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(123109);
        com.tencent.mm.kernel.g.aAg().hqi.a(MailImageDownloadUI.a(MailImageDownloadUI.this));
        MailImageDownloadUI.this.finish();
        AppMethodBeat.o(123109);
        return true;
      }
    });
    this.Bwt = ((ProgressBar)findViewById(2131302553));
    AppMethodBeat.o(123114);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(123111);
    super.onCreate(paramBundle);
    this.msgId = getIntent().getLongExtra("img_msg_id", 0L);
    this.dTS = getIntent().getLongExtra("img_server_id", 0L);
    this.iXp = getIntent().getIntExtra("img_download_compress_type", 0);
    this.username = getIntent().getStringExtra("img_download_username");
    initView();
    if (this.msgId > 0L) {
      this.Bwy = com.tencent.mm.av.q.bcR().H(this.username, this.msgId);
    }
    if (((this.Bwy == null) || (this.Bwy.localId <= 0L)) && (this.dTS > 0L)) {
      this.Bwy = com.tencent.mm.av.q.bcR().G(this.username, this.dTS);
    }
    if ((this.Bwy == null) || (this.Bwy.localId <= 0L))
    {
      Log.e("MicroMsg.MailImageDownloadUI", "onCreate : on such imginfo, with msgLocalId = " + this.msgId + ", or msgSvrId = " + this.dTS);
      AppMethodBeat.o(123111);
      return;
    }
    if ((this.msgId <= 0L) && (this.dTS > 0L)) {
      this.msgId = ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().aJ(this.username, this.dTS).field_msgId;
    }
    paramBundle = this.Bwy.iXm;
    String str = com.tencent.mm.av.q.bcR().o(paramBundle, null, null);
    if ((!Util.isNullOrNil(paramBundle)) && (s.YS(str)))
    {
      Log.i("MicroMsg.MailImageDownloadUI", "has big image, bigImgPath = %s, hasHDImg = %b, fullPath = %s", new Object[] { paramBundle, Boolean.valueOf(this.Bwy.bcv()), str });
      if ((str == null) || (str.equals("")) || (!s.YS(str)))
      {
        Log.d("MicroMsg.MailImageDownloadUI", "showImg : imgPath is null");
        AppMethodBeat.o(123111);
        return;
      }
      this.BwB.setVisibility(8);
      this.Bwt.setVisibility(8);
      this.BwA.setVisibility(0);
      paramBundle = BitmapUtil.getBitmapNative(str);
      this.BwA.setImageBitmap(paramBundle);
      this.Bwx.invalidate();
      AppMethodBeat.o(123111);
      return;
    }
    this.Bwz = new m(this.Bwy.localId, this.msgId, this.iXp, this);
    com.tencent.mm.kernel.g.aAg().hqi.a(this.Bwz, 0);
    AppMethodBeat.o(123111);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(123112);
    super.onPause();
    com.tencent.mm.kernel.g.aAg().hqi.b(109, this);
    AppMethodBeat.o(123112);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(123113);
    super.onResume();
    com.tencent.mm.kernel.g.aAg().hqi.a(109, this);
    AppMethodBeat.o(123113);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(123117);
    if (paramq.getType() != 109)
    {
      AppMethodBeat.o(123117);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      Vj(this.Bwt.getMax());
      AppMethodBeat.o(123117);
      return;
    }
    Log.e("MicroMsg.MailImageDownloadUI", "onSceneEnd : fail, errType = " + paramInt1 + ", errCode = " + paramInt2);
    Toast.makeText(this, 2131761767, 1).show();
    AppMethodBeat.o(123117);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.MailImageDownloadUI
 * JD-Core Version:    0.7.0.1
 */