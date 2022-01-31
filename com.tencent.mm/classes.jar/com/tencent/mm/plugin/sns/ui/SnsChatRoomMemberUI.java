package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Display;
import android.view.WindowManager;
import android.widget.GridView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.n;
import com.tencent.mm.model.r;
import com.tencent.mm.n.a;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SnsChatRoomMemberUI
  extends MMActivity
{
  private static int eiZ = 5;
  private List<SnsChatRoomMemberUI.a> cAs;
  private u efi;
  private String egF;
  private String egT;
  private int egU;
  private String egV;
  private boolean egW;
  private j ejh;
  private String mTitle;
  private GridView rOl;
  private SnsChatRoomMemberUI.b rOm;
  
  public SnsChatRoomMemberUI()
  {
    AppMethodBeat.i(145533);
    this.rOl = null;
    this.rOm = null;
    this.cAs = new ArrayList();
    AppMethodBeat.o(145533);
  }
  
  private static int bE(Context paramContext)
  {
    AppMethodBeat.i(145534);
    int i = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getWidth();
    int j = (int)(paramContext.getResources().getDimension(2131427792) * 2.0F + paramContext.getResources().getDimension(2131427800));
    i = (int)((i - paramContext.getResources().getDimension(2131427781) * 1.0F) / j);
    ab.i("MicroMsg.SnsChatRoomMemberUI", "[getWrapColNum] :%s", new Object[] { Integer.valueOf(i) });
    eiZ = i;
    AppMethodBeat.o(145534);
    return i;
  }
  
  public int getLayoutId()
  {
    return 2130970812;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(145536);
    super.onConfigurationChanged(paramConfiguration);
    this.rOl.setNumColumns(bE(this));
    AppMethodBeat.o(145536);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(145535);
    super.onCreate(paramBundle);
    this.ejh = ((j)g.E(j.class));
    this.egF = getIntent().getStringExtra("RoomInfo_Id");
    this.egT = getIntent().getStringExtra("room_name");
    this.mTitle = getIntent().getStringExtra("Add_address_titile");
    this.egU = getIntent().getIntExtra("room_member_count", 0);
    this.efi = ((c)g.E(c.class)).YJ().oU(this.egF);
    if (this.efi != null)
    {
      this.egV = this.efi.field_roomowner;
      this.egW = r.Zn().equals(this.egV);
    }
    this.rOl = ((GridView)findViewById(2131827920));
    this.rOl.setNumColumns(bE(this));
    this.rOl.setColumnWidth(getResources().getDimensionPixelSize(2131427781));
    this.rOl.setOnItemClickListener(new SnsChatRoomMemberUI.1(this));
    this.rOm = new SnsChatRoomMemberUI.b(this, this, this.efi, this.egF, this.egV);
    this.rOl.setAdapter(this.rOm);
    paramBundle = n.nt(this.egF);
    if (paramBundle != null)
    {
      this.cAs.clear();
      int i = 0;
      if (i < paramBundle.size())
      {
        ad localad = this.ejh.YA().arw((String)paramBundle.get(i));
        if ((localad != null) && (a.je(localad.field_type)) && (!r.nB(localad.field_username)))
        {
          if (!this.efi.ara(localad.field_username)) {
            break label353;
          }
          this.cAs.add(new SnsChatRoomMemberUI.a(localad, 3));
        }
        for (;;)
        {
          i += 1;
          break;
          label353:
          if (this.efi.aqW(localad.field_username)) {
            this.cAs.add(new SnsChatRoomMemberUI.a(localad, 2));
          } else {
            this.cAs.add(new SnsChatRoomMemberUI.a(localad, 1));
          }
        }
      }
      Collections.sort(this.cAs, new SnsChatRoomMemberUI.2(this));
      this.rOm.notifyDataSetChanged();
    }
    setMMTitle(this.mTitle + "(" + this.cAs.size() + ")");
    setBackBtn(new SnsChatRoomMemberUI.3(this));
    AppMethodBeat.o(145535);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsChatRoomMemberUI
 * JD-Core Version:    0.7.0.1
 */