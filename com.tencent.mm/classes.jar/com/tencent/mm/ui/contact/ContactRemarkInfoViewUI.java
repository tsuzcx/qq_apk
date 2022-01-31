package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.au;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;

public class ContactRemarkInfoViewUI
  extends MMActivity
{
  private String aVs;
  private String cCJ;
  private ad dnp;
  private String exA;
  private int fhj;
  private String username;
  private boolean vKE = false;
  private View vKW;
  private View vKX;
  private TextView vKu;
  private TextView vKv;
  private ImageView vKy;
  
  private void cHu()
  {
    com.tencent.mm.bb.c.PO();
    Bitmap localBitmap = com.tencent.mm.bb.c.mN(this.username);
    if (localBitmap != null)
    {
      this.vKy.setImageBitmap(localBitmap);
      this.vKE = true;
    }
  }
  
  private void xK()
  {
    au.Hx();
    this.dnp = com.tencent.mm.model.c.Fw().abl(this.username);
    this.aVs = this.dnp.Bq();
    this.cCJ = this.dnp.cCJ;
    this.exA = this.dnp.cCK;
  }
  
  protected final int getLayoutId()
  {
    return R.i.contact_remark_info_view;
  }
  
  protected final void initView()
  {
    this.vKu = ((TextView)findViewById(R.h.contact_info_remark_name_tv));
    this.vKv = ((TextView)findViewById(R.h.contact_info_remark_desc_tv));
    this.vKy = ((ImageView)findViewById(R.h.remark_pic_display));
    this.vKW = findViewById(R.h.contact_remark_desc_container);
    this.vKX = findViewById(R.h.contact_remark_image_container);
    setMMTitle(R.l.contact_info_mod_remarkinfo);
    this.vKy.setOnClickListener(new ContactRemarkInfoViewUI.1(this));
    addTextOptionMenu(0, getString(R.l.app_edit), new ContactRemarkInfoViewUI.2(this));
    setBackBtn(new ContactRemarkInfoViewUI.3(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.fhj = getIntent().getIntExtra("Contact_Scene", 9);
    this.username = getIntent().getStringExtra("Contact_User");
    if (ah.bl(this.username))
    {
      finish();
      return;
    }
    xK();
    initView();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onResume()
  {
    super.onResume();
    xK();
    this.vKu.setText(j.a(this, ah.pm(this.aVs), this.vKu.getTextSize()));
    if (!ah.bl(this.cCJ))
    {
      this.vKW.setVisibility(0);
      this.vKv.setText(ah.pm(this.cCJ));
    }
    while (!ah.bl(this.exA))
    {
      this.vKX.setVisibility(0);
      com.tencent.mm.bb.c.PO();
      if (!com.tencent.mm.bb.c.mL(this.username))
      {
        com.tencent.mm.bb.c.PO().a(this.username, this.exA, new ContactRemarkInfoViewUI.4(this));
        return;
        this.vKW.setVisibility(8);
      }
      else
      {
        cHu();
        return;
      }
    }
    this.vKX.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ContactRemarkInfoViewUI
 * JD-Core Version:    0.7.0.1
 */