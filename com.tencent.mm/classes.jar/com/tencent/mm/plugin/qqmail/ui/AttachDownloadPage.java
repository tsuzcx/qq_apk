package com.tencent.mm.plugin.qqmail.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.qqmail.b.ac;
import com.tencent.mm.plugin.qqmail.b.v;
import com.tencent.mm.plugin.qqmail.b.v.c;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.al;
import com.tencent.mm.vfs.e;
import java.util.HashMap;
import java.util.Map;

public class AttachDownloadPage
  extends MMActivity
{
  private long fVT = 0L;
  private int fVi = 0;
  private TextView gpr;
  private TextView iMY;
  private long jyU;
  private Button mzL;
  private Button mzN;
  private View mzQ;
  private String pIJ;
  private String pJw;
  private long pKF;
  private MMImageView pKQ;
  private ImageView pKR;
  private ImageView pKS;
  private TextView pKT;
  private LinearLayout pKU;
  private String pKV;
  private int pKW;
  private boolean pKX = false;
  private String pKY;
  private boolean pKZ = true;
  private ProgressBar progressBar;
  private int retryCount = 0;
  
  private void cdW()
  {
    AppMethodBeat.i(68148);
    this.mzQ.setVisibility(0);
    this.mzL.setVisibility(8);
    this.mzN.setVisibility(8);
    this.pKR.setVisibility(0);
    this.pKS.setVisibility(8);
    this.pKT.setVisibility(8);
    this.gpr.setVisibility(8);
    this.iMY.setVisibility(8);
    this.pKR.setOnClickListener(new AttachDownloadPage.3(this));
    this.pKS.setOnClickListener(new AttachDownloadPage.4(this));
    AppMethodBeat.o(68148);
  }
  
  private void cdX()
  {
    AppMethodBeat.i(68149);
    if (this.pKW == 1)
    {
      if (FileExplorerUI.amG(this.pKY))
      {
        if (this.fVi == 3)
        {
          cdY();
          AppMethodBeat.o(68149);
          return;
        }
        if ((this.fVi == 0) || (this.pKZ))
        {
          this.retryCount = 0;
          this.pKZ = false;
          cdZ();
          cdW();
          AppMethodBeat.o(68149);
          return;
        }
      }
      this.mzQ.setVisibility(8);
      this.gpr.setVisibility(0);
      this.pKT.setVisibility(8);
      this.mzL.setVisibility(0);
      this.mzN.setVisibility(8);
      this.iMY.setVisibility(0);
      this.mzL.setOnClickListener(new AttachDownloadPage.5(this));
      if (this.fVi == 3)
      {
        this.gpr.setText(2131301385);
        this.iMY.setText(2131301382);
        this.iMY.setOnClickListener(new AttachDownloadPage.6(this));
        enableOptionMenu(true);
        AppMethodBeat.o(68149);
        return;
      }
      this.gpr.setText(2131301385);
      if (this.fVi == 2) {
        this.iMY.setText(2131301384);
      }
      for (;;)
      {
        this.iMY.setOnClickListener(new AttachDownloadPage.7(this));
        AppMethodBeat.o(68149);
        return;
        this.iMY.setText(2131301383);
      }
    }
    if (this.pKW == 0)
    {
      this.mzQ.setVisibility(8);
      this.mzL.setVisibility(8);
      this.mzN.setVisibility(0);
      this.pKT.setVisibility(8);
      this.gpr.setVisibility(0);
      this.iMY.setVisibility(8);
      if (this.fVi != 3) {
        break label380;
      }
      this.mzN.setText(2131301379);
      enableOptionMenu(true);
    }
    for (;;)
    {
      this.gpr.setText(2131301378);
      this.mzN.setOnClickListener(new AttachDownloadPage.8(this));
      AppMethodBeat.o(68149);
      return;
      label380:
      if (this.fVi == 2) {
        this.mzN.setText(2131301386);
      } else {
        this.mzN.setText(2131301377);
      }
    }
  }
  
  private void cdY()
  {
    AppMethodBeat.i(68150);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_favorite", true);
    localIntent.putExtra("key_favorite_source_type", 9);
    localIntent.putExtra("key_image_path", kj(false));
    com.tencent.mm.plugin.qqmail.a.a.gmO.d(getContext(), localIntent);
    finish();
    AppMethodBeat.o(68150);
  }
  
  private void cdZ()
  {
    AppMethodBeat.i(68151);
    cec();
    if (this.fVi == 4) {
      if (this.retryCount < 5)
      {
        this.retryCount += 1;
        cdZ();
      }
    }
    for (;;)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("mailid", this.pIJ);
      localHashMap.put("attachid", this.pJw);
      localHashMap.put("username", "");
      localHashMap.put("offset", this.fVT);
      localHashMap.put("datalen", this.jyU);
      localHashMap.put("default_attach_name", cea() + ".temp");
      v.c localc = new v.c();
      localc.pJO = false;
      localc.pJP = false;
      this.pKF = ac.cdQ().a("/cgi-bin/mmdownload", localHashMap, localc, new AttachDownloadPage.9(this));
      AppMethodBeat.o(68151);
      return;
      cdX();
      continue;
      if (this.fVi == 3)
      {
        e.h(this.pKV, cea() + ".temp", cea());
        this.fVi = 3;
        cdX();
      }
    }
  }
  
  private String cea()
  {
    AppMethodBeat.i(68153);
    int i = this.pJw.hashCode();
    int j = this.pKY.lastIndexOf(".");
    String str2 = "";
    String str1;
    if (j != -1)
    {
      str1 = this.pKY.substring(0, j);
      str2 = this.pKY;
      str2 = str2.substring(j, str2.length());
    }
    for (;;)
    {
      str1 = String.format("%s_%d%s", new Object[] { str1, Integer.valueOf(i & 0xFFFF), str2 });
      AppMethodBeat.o(68153);
      return str1;
      str1 = this.pKY;
    }
  }
  
  private String ceb()
  {
    AppMethodBeat.i(68155);
    String str = this.pKV + this.pKY;
    AppMethodBeat.o(68155);
    return str;
  }
  
  private void cec()
  {
    AppMethodBeat.i(68156);
    if (e.cN(kj(true)))
    {
      this.fVT = e.avI(kj(true));
      this.fVi = 2;
      AppMethodBeat.o(68156);
      return;
    }
    if (e.cN(kj(false)))
    {
      this.fVi = 3;
      AppMethodBeat.o(68156);
      return;
    }
    if (e.cN(ceb()))
    {
      if (e.avI(ceb()) == this.jyU)
      {
        e.h(this.pKV, this.pKY, cea());
        this.fVi = 3;
        AppMethodBeat.o(68156);
        return;
      }
      if (e.avI(ceb()) > this.jyU)
      {
        e.deleteFile(ceb());
        this.fVT = 0L;
        this.fVi = 4;
        AppMethodBeat.o(68156);
        return;
      }
      this.fVT = 0L;
      this.fVi = 0;
      AppMethodBeat.o(68156);
      return;
    }
    this.fVT = 0L;
    this.fVi = 0;
    AppMethodBeat.o(68156);
  }
  
  private String kj(boolean paramBoolean)
  {
    AppMethodBeat.i(68154);
    StringBuilder localStringBuilder = new StringBuilder().append(this.pKV).append(cea());
    if (!paramBoolean) {}
    for (String str = "";; str = ".temp")
    {
      str = str;
      AppMethodBeat.o(68154);
      return str;
    }
  }
  
  public int getLayoutId()
  {
    return 2130968788;
  }
  
  public void initView()
  {
    AppMethodBeat.i(68147);
    this.pKQ = ((MMImageView)findViewById(2131821561));
    this.mzQ = findViewById(2131821562);
    this.progressBar = ((ProgressBar)findViewById(2131821563));
    this.pKR = ((ImageView)findViewById(2131821564));
    this.pKS = ((ImageView)findViewById(2131821565));
    this.pKT = ((TextView)findViewById(2131821566));
    this.mzL = ((Button)findViewById(2131821567));
    this.mzN = ((Button)findViewById(2131821568));
    this.pKU = ((LinearLayout)findViewById(2131821569));
    this.gpr = ((TextView)findViewById(2131821570));
    this.iMY = ((TextView)findViewById(2131821571));
    if (FileExplorerUI.amG(this.pKY)) {
      this.pKQ.setBackgroundResource(2131231253);
    }
    for (;;)
    {
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(68130);
          AttachDownloadPage.this.finish();
          AppMethodBeat.o(68130);
          return true;
        }
      });
      addIconOptionMenu(0, 2131231823, new AttachDownloadPage.2(this));
      enableOptionMenu(false);
      cec();
      if (this.fVi != 1) {
        break;
      }
      cdW();
      AppMethodBeat.o(68147);
      return;
      if (FileExplorerUI.amH(this.pKY))
      {
        this.pKQ.setImageResource(2131230826);
      }
      else
      {
        int i = o.alm(e.cP(this.pKY));
        if (i > 0) {
          this.pKQ.setImageResource(i);
        } else {
          this.pKQ.setImageResource(2131230822);
        }
      }
    }
    cdX();
    AppMethodBeat.o(68147);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(68152);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    com.tencent.mm.pluginsdk.ui.tools.a.a(this, paramInt1, paramInt2, paramIntent, true, 2131299009, 2131299010, 3);
    AppMethodBeat.o(68152);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(68157);
    super.onConfigurationChanged(paramConfiguration);
    int i = getResources().getConfiguration().orientation;
    paramConfiguration = (FrameLayout.LayoutParams)this.pKU.getLayoutParams();
    if (i == 2) {
      paramConfiguration.bottomMargin = al.fromDPToPix(getContext(), 60);
    }
    for (;;)
    {
      this.pKU.setLayoutParams(paramConfiguration);
      AppMethodBeat.o(68157);
      return;
      if (i == 1) {
        paramConfiguration.bottomMargin = al.fromDPToPix(getContext(), 120);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68142);
    super.onCreate(paramBundle);
    this.pKW = getIntent().getIntExtra("is_preview", 0);
    this.pKX = getIntent().getBooleanExtra("is_compress", false);
    this.pKY = getIntent().getStringExtra("attach_name");
    this.pIJ = getIntent().getStringExtra("mail_id");
    this.pJw = getIntent().getStringExtra("attach_id");
    this.jyU = getIntent().getLongExtra("total_size", 0L);
    ac.cdQ();
    this.pKV = v.getDownloadPath();
    setMMTitle(this.pKY);
    initView();
    AppMethodBeat.o(68142);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(68145);
    super.onDestroy();
    ac.cdQ().cancel(this.pKF);
    AppMethodBeat.o(68145);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(68144);
    super.onPause();
    AppMethodBeat.o(68144);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(68143);
    super.onResume();
    AppMethodBeat.o(68143);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.AttachDownloadPage
 * JD-Core Version:    0.7.0.1
 */