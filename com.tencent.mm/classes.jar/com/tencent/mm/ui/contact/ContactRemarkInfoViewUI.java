package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.aw;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;

public class ContactRemarkInfoViewUI
  extends MMActivity
{
  private TextView AbU;
  private TextView AbV;
  private ImageView AbY;
  private boolean Ace = false;
  private View Acy;
  private View Acz;
  private String bma;
  private ad contact;
  private String dqT;
  private String fNq;
  private int gyR;
  private String username;
  
  private void Kc()
  {
    AppMethodBeat.i(33695);
    aw.aaz();
    this.contact = com.tencent.mm.model.c.YA().arw(this.username);
    this.bma = this.contact.Of();
    this.dqT = this.contact.dqT;
    this.fNq = this.contact.dqU;
    AppMethodBeat.o(33695);
  }
  
  private void dLL()
  {
    AppMethodBeat.i(33697);
    com.tencent.mm.bc.c.aiT();
    Bitmap localBitmap = com.tencent.mm.bc.c.tX(this.username);
    if (localBitmap != null)
    {
      this.AbY.setImageBitmap(localBitmap);
      this.Ace = true;
    }
    AppMethodBeat.o(33697);
  }
  
  public int getLayoutId()
  {
    return 2130969269;
  }
  
  public void initView()
  {
    AppMethodBeat.i(33696);
    this.AbU = ((TextView)findViewById(2131823225));
    this.AbV = ((TextView)findViewById(2131823235));
    this.AbY = ((ImageView)findViewById(2131823238));
    this.Acy = findViewById(2131823239);
    this.Acz = findViewById(2131823240);
    setMMTitle(2131298671);
    this.AbY.setOnClickListener(new ContactRemarkInfoViewUI.1(this));
    addTextOptionMenu(0, getString(2131296914), new ContactRemarkInfoViewUI.2(this));
    setBackBtn(new ContactRemarkInfoViewUI.3(this));
    AppMethodBeat.o(33696);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(33692);
    super.onCreate(paramBundle);
    this.gyR = getIntent().getIntExtra("Contact_Scene", 9);
    this.username = getIntent().getStringExtra("Contact_User");
    if (ah.isNullOrNil(this.username))
    {
      finish();
      AppMethodBeat.o(33692);
      return;
    }
    Kc();
    initView();
    AppMethodBeat.o(33692);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(33694);
    super.onDestroy();
    AppMethodBeat.o(33694);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(33693);
    super.onResume();
    Kc();
    this.AbU.setText(j.b(this, ah.nullAsNil(this.bma), this.AbU.getTextSize()));
    if (!ah.isNullOrNil(this.dqT))
    {
      this.Acy.setVisibility(0);
      this.AbV.setText(ah.nullAsNil(this.dqT));
    }
    while (!ah.isNullOrNil(this.fNq))
    {
      this.Acz.setVisibility(0);
      com.tencent.mm.bc.c.aiT();
      if (!com.tencent.mm.bc.c.tV(this.username))
      {
        com.tencent.mm.bc.c.aiT().a(this.username, this.fNq, new ContactRemarkInfoViewUI.4(this));
        AppMethodBeat.o(33693);
        return;
        this.Acy.setVisibility(8);
      }
      else
      {
        dLL();
        AppMethodBeat.o(33693);
        return;
      }
    }
    this.Acz.setVisibility(8);
    AppMethodBeat.o(33693);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ContactRemarkInfoViewUI
 * JD-Core Version:    0.7.0.1
 */