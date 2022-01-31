package com.tencent.mm.plugin.nearby.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ag.o;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.plugin.nearby.a.d;
import com.tencent.mm.plugin.nearby.b.c;
import com.tencent.mm.plugin.nearby.b.d;
import com.tencent.mm.plugin.nearby.b.e;
import com.tencent.mm.plugin.nearby.b.f;
import com.tencent.mm.plugin.nearby.b.g;
import com.tencent.mm.plugin.nearby.b.h;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.c.atm;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.kernel.j
public class NearbyFriendsUI
  extends MMActivity
  implements com.tencent.mm.ah.f
{
  private com.tencent.mm.modelgeo.c dhZ;
  private a.a dig = new NearbyFriendsUI.8(this);
  private com.tencent.mm.sdk.b.c dii = new NearbyFriendsUI.1(this);
  boolean edT = false;
  private ListView fiu;
  private List<atm> jKA = new LinkedList();
  private boolean lIh = false;
  private List<atm> lJy = new LinkedList();
  private com.tencent.mm.plugin.nearby.a.c mCP;
  private NearbyFriendsUI.b mDc;
  private com.tencent.mm.plugin.nearby.a.c mDd;
  private d mDe;
  private boolean mDf = false;
  private String[] mDg;
  private int mDh = 1;
  private BindMobileOrQQHeaderView mDi;
  private ViewGroup mDj;
  private View mDk;
  private View mDl;
  private boolean mDm = false;
  private int mDn;
  private boolean mDo = false;
  private int mDp = 0;
  private View mDq = null;
  private NearbyFriendsUI.a mDr;
  private com.tencent.mm.ui.base.p tipDialog = null;
  
  private void bof()
  {
    View localView;
    Object localObject;
    int i;
    if (com.tencent.mm.bp.a.cki())
    {
      if (this.mDq != null)
      {
        this.fiu.removeHeaderView(this.mDq);
        this.mDq = null;
      }
      localView = View.inflate(this, b.e.nearby_goto_sayhi_btn, null);
      localObject = (TextView)localView.findViewById(b.d.say_hi_count);
      com.tencent.mm.kernel.g.DN().CX();
      i = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhL().aAo();
      if (i != 0) {
        break label111;
      }
      localView.setVisibility(8);
      localView = null;
    }
    for (;;)
    {
      this.mDq = localView;
      if (this.mDq != null) {
        this.fiu.addHeaderView(this.mDq);
      }
      return;
      label111:
      localView.setVisibility(0);
      ((TextView)localObject).setText(getResources().getQuantityString(b.f.say_hi_count_text_quantity, i, new Object[] { Integer.valueOf(i) }));
      localObject = (ImageView)localView.findViewById(b.d.match_dlg_img);
      bf localbf = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhL().bhU();
      if (localbf != null) {
        a.b.a((ImageView)localObject, localbf.field_sayhiuser);
      }
      localView.setOnClickListener(new NearbyFriendsUI.9(this));
    }
  }
  
  private void bog()
  {
    com.tencent.mm.plugin.nearby.a.eUR.aM(this);
  }
  
  private void getData()
  {
    this.lIh = false;
    AppCompatActivity localAppCompatActivity = this.mController.uMN;
    getString(b.h.app_tip);
    this.tipDialog = h.b(localAppCompatActivity, getString(b.h.nearby_friend_locating), true, new NearbyFriendsUI.7(this));
    this.edT = false;
    if (this.dhZ != null) {
      this.dhZ.a(this.dig, true);
    }
  }
  
  protected final int getLayoutId()
  {
    return b.e.nearby_friend;
  }
  
  protected final void initView()
  {
    this.fiu = ((ListView)findViewById(b.d.nearby_friend_lv));
    this.mDc = new NearbyFriendsUI.b(this, this);
    Object localObject = this.fiu;
    if (this.mDj == null)
    {
      this.mDj = new LinearLayout(this);
      this.mDj.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
      ((LinearLayout)this.mDj).setGravity(17);
    }
    this.mDm = true;
    ((ListView)localObject).addHeaderView(this.mDj);
    localObject = com.tencent.mm.m.g.AA().getValue("LBSShowBindPhone");
    if ((localObject != null) && (((String)localObject).length() > 0)) {}
    try
    {
      this.mDn = Integer.valueOf((String)localObject).intValue();
      localObject = (String)com.tencent.mm.kernel.g.DP().Dz().get(6, null);
      if ((localObject != null) && (((String)localObject).length() > 0)) {
        this.mDn = 0;
      }
      this.mDp = 0;
      if (com.tencent.mm.model.a.g.Iy().iX("3") != null)
      {
        localObject = com.tencent.mm.model.a.g.Iy().iX("3").value;
        locala = l.WP();
        if (((String)localObject).equals("0")) {
          this.mDp = 0;
        }
      }
      else
      {
        if (((this.mDn > 0) || (this.mDp > 0)) && (this.mDp != 1))
        {
          this.mDi = new BindMobileOrQQHeaderView(this);
          this.fiu.addHeaderView(this.mDi);
        }
        this.fiu.setAdapter(this.mDc);
        this.fiu.setOnItemClickListener(new NearbyFriendsUI.10(this));
        this.fiu.setOnTouchListener(new NearbyFriendsUI.11(this));
        setBackBtn(new NearbyFriendsUI.12(this));
        new NearbyFriendsUI.13(this);
        addIconOptionMenu(0, b.c.mm_title_btn_menu, new NearbyFriendsUI.14(this));
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        l.a locala;
        this.mDn = 0;
        continue;
        if (localException.equals("2"))
        {
          if (locala == l.a.ffU)
          {
            this.mDp = 2;
            com.tencent.mm.model.a.f.jb("3");
          }
        }
        else if ((localException.equals("1")) && (locala == l.a.ffR))
        {
          this.mDp = 2;
          com.tencent.mm.model.a.f.jb("3");
        }
      }
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    y.d("MicroMsg.NearbyFriend", "onActivityResult, requestCode %s, resultCode %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        return;
      } while (paramInt2 != -1);
      this.mDf = false;
      getData();
      return;
    } while (paramInt2 != -1);
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    com.tencent.mm.plugin.report.service.g.wI(11);
    super.onCreate(paramBundle);
    setMMTitle(b.h.nearby_friend_title);
    com.tencent.mm.kernel.g.Dk().a(148, this);
    com.tencent.mm.kernel.g.Dk().a(376, this);
    com.tencent.mm.kernel.g.Dk().a(1087, this);
    this.dhZ = com.tencent.mm.modelgeo.c.Ob();
    initView();
    this.mDg = new String[] { getResources().getString(b.h.nearby_friend_location_findmm), getResources().getString(b.h.nearby_friend_location_findgg), getResources().getString(b.h.nearby_friend_location_findall), getResources().getString(b.h.say_hi_list_lbs_title) };
    this.mDh = bk.a((Integer)com.tencent.mm.kernel.g.DP().Dz().get(16386, null), 1);
    if (this.mDh == 3) {
      FQ(b.g.ic_sex_male);
    }
    for (;;)
    {
      getData();
      return;
      if (this.mDh == 4)
      {
        FQ(b.g.ic_sex_female);
      }
      else
      {
        FQ(0);
        this.mDh = 1;
      }
    }
  }
  
  protected void onDestroy()
  {
    if (this.mDp > 0) {
      com.tencent.mm.model.a.f.jc("3");
    }
    com.tencent.mm.plugin.report.service.g.wK(11);
    com.tencent.mm.kernel.g.Dk().b(148, this);
    com.tencent.mm.kernel.g.Dk().b(376, this);
    com.tencent.mm.kernel.g.Dk().b(1087, this);
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    if (this.dhZ != null) {
      this.dhZ.c(this.dig);
    }
    o.Kj().cancel();
    if (this.mDc != null)
    {
      NearbyFriendsUI.b localb = this.mDc;
      if (localb.ffG != null)
      {
        localb.ffG.detach();
        localb.ffG = null;
      }
    }
    super.onDestroy();
  }
  
  protected void onPause()
  {
    super.onPause();
    if (this.dhZ != null) {
      this.dhZ.c(this.dig);
    }
    com.tencent.mm.sdk.b.a.udP.d(this.dii);
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.dhZ != null) {
      this.dhZ.a(this.dig, true);
    }
    bof();
    this.mDc.notifyDataSetChanged();
    com.tencent.mm.kernel.g.DN().CX();
    if (((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhL().aAo() == 0) {
      this.fiu.removeHeaderView(this.mDl);
    }
    com.tencent.mm.sdk.b.a.udP.c(this.dii);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    label269:
    label405:
    Object localObject;
    if (paramm.getType() == 148)
    {
      int i = ((com.tencent.mm.plugin.nearby.a.c)paramm).rN();
      if ((this.mDd == null) && ((i == 1) || (i == 3) || (i == 4))) {}
      do
      {
        do
        {
          return;
          if (((i == 1) || (i == 3) || (i == 4)) && (this.mDf))
          {
            y.v("MicroMsg.NearbyFriend", "onSceneEnd data already requested, code=%d", new Object[] { Integer.valueOf(i) });
            return;
          }
        } while ((this.mCP == null) && (i == 2));
        y.i("MicroMsg.NearbyFriend", "onSceneEnd: errType=%d, errCode=%d, errMsg=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      } while (paramm.getType() != 148);
      if (this.tipDialog != null)
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if ((i == 1) || (i == 3) || (i == 4))
        {
          this.jKA = ((com.tencent.mm.plugin.nearby.a.c)paramm).boe();
          if ((this.jKA == null) || (this.jKA.size() == 0))
          {
            findViewById(b.d.nearby_friend_not_found).setVisibility(0);
            this.fiu.setVisibility(8);
            bog();
            com.tencent.mm.plugin.report.service.g.wK(11);
            if (this.mDh != 3) {
              break label707;
            }
            FQ(b.g.ic_sex_male);
            this.mDf = true;
            this.mDd = null;
          }
        }
        else
        {
          if (((com.tencent.mm.plugin.nearby.a.c)paramm).rN() == 2)
          {
            h.a(this.mController.uMN, getString(b.h.nearby_friend_clear_location_ok), "", new NearbyFriendsUI.5(this));
            this.mCP = null;
          }
          if (!((com.tencent.mm.plugin.nearby.a.c)paramm).boc()) {
            break label749;
          }
          paramString = getString(b.h.nearby_lbsroom_name);
          paramInt1 = ((com.tencent.mm.plugin.nearby.a.c)paramm).bod();
          if (this.mDj != null)
          {
            if (this.mDk != null) {
              break label738;
            }
            this.mDk = View.inflate(this, b.e.nearby_group_header_item, null);
            this.mDj.addView(this.mDk);
            this.mDk.setOnClickListener(new NearbyFriendsUI.2(this));
            ((TextView)this.mDk.findViewById(b.d.nearby_group_title)).setText(paramString);
            if (paramInt1 != 0) {
              ((TextView)this.mDk.findViewById(b.d.nearby_group_member_count)).setText(String.format(getResources().getQuantityString(b.f.nearby_lbsroom_member_count, paramInt1, new Object[] { Integer.valueOf(paramInt1) }), new Object[0]));
            }
          }
        }
        for (;;)
        {
          this.mDo = true;
          return;
          findViewById(b.d.nearby_friend_not_found).setVisibility(8);
          paramString = new LinkedList();
          localObject = this.jKA.iterator();
          paramInt1 = 0;
          while (((Iterator)localObject).hasNext())
          {
            atm localatm = (atm)((Iterator)localObject).next();
            if (((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abg(localatm.hPY))
            {
              paramString.add(paramInt1, localatm);
              paramInt1 += 1;
            }
            else
            {
              paramString.add(localatm);
            }
          }
          this.jKA.clear();
          this.jKA = paramString;
          if (this.lJy != null)
          {
            paramInt1 = this.lJy.size() - 1;
            while (paramInt1 >= 0)
            {
              if (this.lJy.get(paramInt1) != null) {
                this.jKA.add(0, this.lJy.get(paramInt1));
              }
              paramInt1 -= 1;
            }
          }
          this.mDc.notifyDataSetChanged();
          if (this.mDc.getCount() > 0) {
            this.fiu.setSelection(0);
          }
          this.fiu.post(new NearbyFriendsUI.4(this));
          break;
          label707:
          if (this.mDh == 4)
          {
            FQ(b.g.ic_sex_female);
            break label269;
          }
          FQ(0);
          this.mDh = 1;
          break label269;
          label738:
          this.mDk.setVisibility(0);
          break label405;
          label749:
          if ((this.mDk != null) && (this.mDj != null)) {
            this.mDk.setVisibility(8);
          }
        }
      }
      if ((i == 1) || (i == 3) || (i == 4))
      {
        localObject = (TextView)findViewById(b.d.nearby_friend_not_found);
        ((TextView)localObject).setVisibility(0);
        bog();
        if ((paramString == null) || (paramString.length() <= 0)) {
          break label1081;
        }
      }
    }
    label1081:
    for (paramString = com.tencent.mm.i.a.eI(paramString);; paramString = null)
    {
      if ((paramString != null) && (paramString.desc != null) && (paramString.desc.length() > 0)) {
        ((TextView)localObject).setText(paramString.desc);
      }
      for (;;)
      {
        this.fiu.setVisibility(8);
        this.mDd = null;
        if (((com.tencent.mm.plugin.nearby.a.c)paramm).rN() != 2) {
          break;
        }
        Toast.makeText(this, b.h.nearby_friend_clear_location_failed, 1).show();
        this.mCP = null;
        return;
        if (paramInt2 == -2001) {
          ((TextView)localObject).setText(getString(b.h.nearby_friend_expose));
        } else {
          ((TextView)localObject).setText(getString(b.h.nearby_friend_get_friend_fail));
        }
      }
      if ((paramm.getType() != 376) || (((d)paramm).rN() != 1)) {
        break;
      }
      if (this.tipDialog != null)
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0) && (((d)paramm).ePR != null))
      {
        paramString = ((d)paramm).ePR;
        com.tencent.mm.plugin.nearby.a.b.eg(paramString, ((d)paramm).mCz);
        paramm = new Intent();
        paramm.putExtra("Chat_User", paramString);
        com.tencent.mm.plugin.nearby.a.eUR.f(paramm, this);
        return;
      }
      h.a(this.mController.uMN, b.h.nearby_lbsroom_join_failed, b.h.app_tip, new NearbyFriendsUI.6(this));
      return;
    }
  }
  
  static final class c
  {
    public static int mDx = 10000;
    
    public static String b(atm paramatm)
    {
      if (paramatm != null) {
        return paramatm.ffi;
      }
      return null;
    }
    
    public static boolean ve(int paramInt)
    {
      return paramInt == mDx;
    }
  }
  
  static final class d
  {
    TextView fdY;
    ImageView ffK;
    TextView ffL;
    ImageView mDA;
    ImageView mDC;
    ImageView mDD;
    ImageView mDE;
    ImageView mDF;
    ImageView mDG;
    TextView mDy;
    TextView mDz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI
 * JD-Core Version:    0.7.0.1
 */