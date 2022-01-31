package com.tencent.mm.ui.transmit;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.Toast;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a.cj;
import com.tencent.mm.model.au;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.pluginsdk.model.e;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.contact.SelectContactUI;
import java.util.ArrayList;

public class ShareImageSelectorUI
  extends MMActivity
  implements AdapterView.OnItemClickListener
{
  private static int whP = 1;
  private ListView Nn;
  private View jdP;
  private ImageView jjn;
  private String lWF;
  private ah mHandler = new ShareImageSelectorUI.2(this);
  private int vNh = 2;
  private ShareImageSelectorUI.a whQ;
  private Dialog whR;
  private View.OnClickListener whS = new ShareImageSelectorUI.1(this);
  
  private void beB()
  {
    com.tencent.mm.ui.base.h.a(this.mController.uMN, getString(R.l.cropimg_share_cancle), getString(R.l.cropimg_share_title), true, new ShareImageSelectorUI.4(this), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        if (ShareImageSelectorUI.whP == 1) {
          ShareImageSelectorUI.c(ShareImageSelectorUI.this);
        }
      }
    });
  }
  
  private void cJE()
  {
    if ((this.whR != null) && (this.whR.isShowing())) {
      return;
    }
    String str1 = getString(R.l.cropimg_share_to_friend);
    String str2 = getString(R.l.cropimg_share_to_sns);
    String str3 = getString(R.l.cropimg_share_to_fav);
    AppCompatActivity localAppCompatActivity = this.mController.uMN;
    String str4 = getString(R.l.menu_item_send_image);
    ShareImageSelectorUI.6 local6 = new ShareImageSelectorUI.6(this);
    ShareImageSelectorUI.7 local7 = new ShareImageSelectorUI.7(this);
    this.whR = com.tencent.mm.ui.base.h.a(localAppCompatActivity, str4, new String[] { str1, str2, str3 }, null, local6, local7);
  }
  
  private void cJF()
  {
    Intent localIntent = new Intent(this, SelectContactUI.class);
    localIntent.putExtra("list_attr", com.tencent.mm.ui.contact.s.vMy);
    localIntent.putExtra("titile", getString(R.l.address_title_dis_send_friend));
    localIntent.putExtra("list_type", 11);
    localIntent.putExtra("shareImage", true);
    localIntent.putExtra("shareImagePath", this.lWF);
    startActivityForResult(localIntent, 1001);
  }
  
  private void cJG()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("Ksnsupload_type", 0);
    localIntent.putExtra("sns_kemdia_path", this.lWF);
    localIntent.putExtra("need_result", true);
    d.b(this.mController.uMN, "sns", ".ui.SnsUploadUI", localIntent, 1002);
  }
  
  private void cJH()
  {
    cj localcj = new cj();
    e.a(localcj, 6, this.lWF);
    localcj.bIw.activity = this;
    localcj.bIw.bID = 52;
    a.udP.m(localcj);
    com.tencent.mm.plugin.report.service.h.nFQ.f(11048, new Object[] { Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0) });
    if (this.mHandler != null) {
      this.mHandler.sendEmptyMessageDelayed(0, 800L);
    }
  }
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return R.i.share_image_selector;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    y.d("MicroMsg.ShareImageSelectorUI", "requestCode:%d , resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    switch (paramInt1)
    {
    default: 
      y.w("MicroMsg.ShareImageSelectorUI", "unknow result");
      return;
    case 1001: 
      if (paramInt2 == -1)
      {
        ArrayList localArrayList = null;
        if (paramIntent != null) {
          localArrayList = paramIntent.getStringArrayListExtra("Select_Contact");
        }
        if ((localArrayList != null) && (localArrayList.size() == 1))
        {
          paramIntent = new Intent(this, ChattingUI.class);
          paramIntent.putExtra("Chat_User", (String)localArrayList.get(0));
          startActivity(paramIntent);
        }
        finish();
        return;
      }
      y.w("MicroMsg.ShareImageSelectorUI", "user cancle");
      return;
    }
    if (paramInt2 == -1)
    {
      Toast.makeText(this.mController.uMN, R.l.confirm_dialog_sent, 0).show();
      finish();
      return;
    }
    y.w("MicroMsg.ShareImageSelectorUI", "user cancle");
  }
  
  public void onBackPressed()
  {
    beB();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    au.Hx();
    paramBundle = com.tencent.mm.model.c.Dz().get(229635, null);
    if ((paramBundle instanceof Integer))
    {
      i = ((Integer)paramBundle).intValue();
      if ((i == 0) || (i == 1)) {
        whP = i;
      }
    }
    setMMTitle(R.l.menu_item_send_image);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        ShareImageSelectorUI.b(ShareImageSelectorUI.this);
        return false;
      }
    });
    this.vNh = getIntent().getIntExtra("Select_Conv_Type", 2);
    this.lWF = getIntent().getStringExtra("intent_extra_image_path");
    this.jdP = findViewById(R.h.main);
    this.jjn = ((ImageView)findViewById(R.h.image));
    this.jjn.setOnClickListener(this.whS);
    this.Nn = ((ListView)findViewById(R.h.list));
    this.whQ = new ShareImageSelectorUI.a(this);
    this.Nn.setAdapter(this.whQ);
    this.Nn.setOnItemClickListener(this);
    y.d("MicroMsg.ShareImageSelectorUI", "mSelectType:%s ImagePath:%s", new Object[] { this.vNh, this.lWF });
    if (whP == 1)
    {
      setTitleVisibility(8);
      this.Nn.setVisibility(8);
      this.jjn.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
      this.jjn.setPadding(0, 0, 0, 0);
      this.jjn.setOnClickListener(null);
      this.jdP.setBackgroundColor(getResources().getColor(R.e.dark_bg_color));
      cJE();
    }
    long l = System.currentTimeMillis();
    paramBundle = x.pg(this.lWF);
    int i = BackwardSupportUtil.ExifHelper.YS(this.lWF);
    y.d("MicroMsg.ShareImageSelectorUI", "cpan [onCreate]degree:%d", new Object[] { Integer.valueOf(i) });
    paramBundle = com.tencent.mm.sdk.platformtools.c.b(paramBundle, i);
    if ((paramBundle != null) && (!paramBundle.isRecycled())) {
      this.jjn.setImageBitmap(paramBundle);
    }
    y.d("MicroMsg.ShareImageSelectorUI", "cpan[onCreate] Read Bitmap Time:%s", new Object[] { System.currentTimeMillis() - l + "'" });
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    switch (paramInt)
    {
    default: 
      y.e("MicroMsg.ShareImageSelectorUI", "unknow postion.");
      return;
    case 0: 
      cJF();
      return;
    case 1: 
      cJG();
      return;
    }
    cJH();
  }
  
  protected void onResume()
  {
    super.onResume();
    if ((whP == 1) && ((this.whR == null) || (!this.whR.isShowing()))) {
      cJE();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.ShareImageSelectorUI
 * JD-Core Version:    0.7.0.1
 */