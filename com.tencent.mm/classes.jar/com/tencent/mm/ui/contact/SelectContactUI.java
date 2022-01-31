package com.tencent.mm.ui.contact;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.m.e;
import com.tencent.mm.model.au;
import com.tencent.mm.openim.a.b;
import com.tencent.mm.openim.a.b.a;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.contact.a.j;
import com.tencent.mm.ui.s.b;
import com.tencent.mm.ui.w.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SelectContactUI
  extends MMBaseSelectContactUI
  implements f
{
  private int bQU;
  private ProgressDialog dnm;
  private List<String> dru;
  private HashSet<String> eXT;
  private String imV;
  private String mSource;
  private String title;
  private int vIY;
  private HashSet<String> vMY;
  private String vNA;
  private int vNa;
  private boolean vNb = true;
  private SelectContactUI.a vNc = new SelectContactUI.a();
  private TextView vNn;
  private TextView vNo;
  private TextView vNp;
  private TextView vNq;
  private TextView vNr;
  private boolean vNs;
  private boolean vNt;
  private String vNu;
  private String vNv;
  private boolean vNw;
  private boolean vNx;
  private boolean vNy;
  private boolean vNz = false;
  
  private static List<String> F(List<String> paramList)
  {
    LinkedList localLinkedList = new LinkedList();
    if (!au.DK()) {
      return localLinkedList;
    }
    if (paramList == null) {
      return localLinkedList;
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      au.Hx();
      ad localad = com.tencent.mm.model.c.Fw().abl(str);
      paramList = str;
      if (localad != null)
      {
        paramList = str;
        if ((int)localad.dBe != 0) {
          paramList = localad.Bq();
        }
      }
      localLinkedList.add(paramList);
    }
    return localLinkedList;
  }
  
  private TextView a(ListView paramListView, View.OnClickListener paramOnClickListener, String paramString)
  {
    View localView = com.tencent.mm.ui.y.gt(this).inflate(R.i.group_card_item, null);
    localView.setOnClickListener(paramOnClickListener);
    paramOnClickListener = (TextView)localView.findViewById(R.h.content_tv);
    paramOnClickListener.setText(paramString);
    paramListView.addHeaderView(localView);
    return paramOnClickListener;
  }
  
  private void a(com.tencent.mm.roomsdk.a.c.a parama)
  {
    parama.d(new SelectContactUI.5(this, parama));
    getString(R.l.app_tip);
    parama.a(this, getString(R.l.launchchatting_creating_chatroom), true, new SelectContactUI.6(this, parama));
  }
  
  private void adU(String paramString)
  {
    if (this.vMY.contains(paramString)) {
      return;
    }
    cHK();
    this.mbR.Wv(paramString);
    if (this.eXT.contains(paramString))
    {
      this.eXT.remove(paramString);
      return;
    }
    this.eXT.add(paramString);
  }
  
  private void cHR()
  {
    int j = 0;
    if ((this.vNb) && ((this.vIY == 1) || (this.vIY == 0))) {
      if (this.vMY == null) {
        break label80;
      }
    }
    label80:
    for (int i = this.vMY.size();; i = 0)
    {
      if (this.eXT != null) {
        j = this.eXT.size();
      }
      int k = bk.ZR(com.tencent.mm.m.g.AA().getValue("ChatRoomInviteStartCount"));
      this.vNc.d(this, i + j, k);
      return;
    }
  }
  
  private boolean em(List<String> paramList)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SelectContactUI", "handleSelect %s", new Object[] { paramList });
    String str;
    if (s.fA(this.vNa, 65536))
    {
      if (paramList == null) {
        break label240;
      }
      if (paramList.size() == 1) {
        str = getString(R.l.select_contact_confirm_tips, new Object[] { com.tencent.mm.model.r.gV((String)paramList.get(0)) });
      }
    }
    for (;;)
    {
      this.vNy = true;
      com.tencent.mm.ui.base.h.a(this.mController.uMN, str, null, true, new SelectContactUI.15(this, paramList), new SelectContactUI.16(this));
      return this.vNy;
      if (paramList.size() > 1)
      {
        str = getString(R.l.app_seperator_marker);
        StringBuilder localStringBuilder = new StringBuilder();
        int i = 0;
        for (;;)
        {
          if (i < paramList.size())
          {
            if (i == 3) {
              localStringBuilder.append("...");
            }
          }
          else
          {
            str = getString(R.l.select_contact_confirm_tips, new Object[] { localStringBuilder.toString() });
            break;
          }
          localStringBuilder.append(com.tencent.mm.model.r.gV((String)paramList.get(i)));
          if (i < paramList.size() - 1) {
            localStringBuilder.append(str);
          }
          i += 1;
        }
        return en(paramList);
      }
      label240:
      str = null;
    }
  }
  
  private boolean en(List<String> paramList)
  {
    boolean bool = false;
    if (getIntent().getBooleanExtra("Add_SendCard", false))
    {
      if (bk.bl(this.vNu)) {
        this.vNu = bk.c(paramList, ",");
      }
      for (;;)
      {
        bool = com.tencent.mm.model.s.fn(this.vNv);
        paramList = new Intent();
        paramList.putExtra("be_send_card_name", this.vNu);
        paramList.putExtra("received_card_name", this.vNv);
        paramList.putExtra("Is_Chatroom", bool);
        setResult(-1, paramList);
        finish();
        return true;
        if (!bk.bl(this.vNv)) {
          break;
        }
        this.vNv = bk.c(paramList, ",");
      }
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.SelectContactUI", "send card occur error: send:%s | receive:%s", new Object[] { this.vNu, this.vNv });
      return false;
    }
    Object localObject;
    int i;
    if (getIntent().getBooleanExtra("snsPostWhoCanSee", false))
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SelectContactUI", "sns post who can see scene,users=%s", new Object[] { paramList.toString() });
      localObject = nA(false);
      ((ArrayList)localObject).remove(com.tencent.mm.model.q.Gj());
      paramList = paramList.iterator();
      for (i = 0; paramList.hasNext(); i = 1)
      {
        label210:
        String str = (String)paramList.next();
        if (bk.bl(str)) {
          break label844;
        }
        if ((((ArrayList)localObject).contains(str)) || (com.tencent.mm.model.q.Gj().equals(str))) {
          break label210;
        }
        au.Hx();
        ad localad = com.tencent.mm.model.c.Fw().abl(str);
        if ((localad == null) || ((int)localad.dBe == 0) || (!com.tencent.mm.n.a.gR(localad.field_type))) {
          break label844;
        }
        adU(str);
        ((ArrayList)localObject).add(str);
      }
    }
    label844:
    for (;;)
    {
      break label210;
      if (i != 0)
      {
        xU();
        cHE().notifyDataSetChanged();
        break;
      }
      localObject = nA(false);
      ((ArrayList)localObject).remove(com.tencent.mm.model.q.Gj());
      paramList = bk.c((List)localObject, ",");
      if (!bk.dk((List)localObject))
      {
        com.tencent.mm.ui.base.h.a(this.mController.uMN, true, getString(R.l.label_selected_contact_save_label), "", getString(R.l.label_selected_contact_save_btn), getString(R.l.label_selected_contact_cancel_btn), new SelectContactUI.3(this, paramList), new SelectContactUI.4(this, paramList));
        break;
      }
      localObject = new Intent();
      ((Intent)localObject).putExtra("Select_Contact", paramList);
      ((Intent)localObject).putExtra("Select_Conv_User", paramList);
      ((Intent)localObject).putExtra("Select_Contact", paramList);
      ((Intent)localObject).putExtra("Select_Contacts_To_Create_New_Label", paramList);
      setResult(0, (Intent)localObject);
      finish();
      break;
      if (getIntent().getBooleanExtra("recommend_friends", false))
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SelectContactUI", "Recommend Friends");
        z.a(this.mController.uMN, this.vNv, paramList);
        break;
      }
      if (s.fA(this.vNa, 16384))
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SelectContactUI", "return the result");
        localObject = new Intent();
        paramList = bk.c(paramList, ",");
        ((Intent)localObject).putExtra("Select_Contact", paramList);
        ((Intent)localObject).putExtra("Select_Conv_User", paramList);
        ((Intent)localObject).putExtra("Select_Contact", paramList);
        ((Intent)localObject).putExtra("label_source", this.mSource);
        if (this.bQU == 1) {
          bool = true;
        }
        ((Intent)localObject).putExtra("Is_Chatroom", bool);
        setResult(-1, (Intent)localObject);
        finish();
        break;
      }
      if (getIntent().getBooleanExtra("shareImage", false))
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SelectContactUI", "Share Image");
        paramList = nA(true);
        paramList.remove(com.tencent.mm.model.q.Gj());
        if (paramList.size() <= 0) {
          break;
        }
        this.dnm = com.tencent.mm.ui.base.h.b(this.mController.uMN, getString(R.l.main_sending), false, null);
        au.DS().O(new SelectContactUI.2(this, paramList));
        break;
      }
      if (paramList.size() > 0)
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SelectContactUI", "Launch ChattingUI: users=%s", new Object[] { paramList.toString() });
        finish();
        localObject = new Intent();
        ((Intent)localObject).setClass(this, ChattingUI.class);
        ((Intent)localObject).putExtra("Chat_User", (String)paramList.get(0));
        ((Intent)localObject).addFlags(67108864);
        startActivity((Intent)localObject);
        break;
      }
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.SelectContactUI", "unkown action: User=%s", new Object[] { paramList.toString() });
      break;
    }
  }
  
  private ArrayList<String> nA(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.eXT.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      if ((!paramBoolean) && (com.tencent.mm.model.s.hi((String)localObject)))
      {
        localObject = com.tencent.mm.model.m.gL((String)localObject);
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            localHashSet.add((String)((Iterator)localObject).next());
          }
        }
      }
      else
      {
        localHashSet.add(localObject);
      }
    }
    localArrayList.addAll(localHashSet);
    return localArrayList;
  }
  
  private ArrayList<String> nB(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.eXT.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      if ((!paramBoolean) && (com.tencent.mm.model.s.hi((String)localObject)))
      {
        localObject = com.tencent.mm.model.m.gL((String)localObject);
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            localHashSet.add((String)((Iterator)localObject).next());
          }
        }
      }
      else
      {
        localHashSet.add(localObject);
      }
    }
    localHashSet.addAll(this.vMY);
    localArrayList.addAll(localHashSet);
    return localArrayList;
  }
  
  private void xU()
  {
    if ((s.fA(this.vNa, 64)) && (this.eXT.size() > 0))
    {
      updateOptionMenuText(1, getString(R.l.app_ok) + "(" + this.eXT.size() + ")");
      int i = getIntent().getIntExtra("min_limit_num", 0);
      if ((s.fA(this.vNa, 262144)) && (this.eXT.size() < i))
      {
        enableOptionMenu(1, false);
        return;
      }
      enableOptionMenu(1, true);
      return;
    }
    updateOptionMenuText(1, getString(R.l.app_ok));
    enableOptionMenu(1, false);
  }
  
  protected final void Ha(String paramString)
  {
    com.tencent.mm.plugin.report.service.h.nFQ.f(11225, new Object[] { Integer.valueOf(1), Integer.valueOf(0) });
    Intent localIntent = new Intent();
    localIntent.setClassName(this, "com.tencent.mm.ui.contact.SelectLabelContactUI");
    localIntent.putExtra("label", paramString);
    paramString = new HashSet();
    paramString.addAll(nA(s.fA(this.vNa, 8192)));
    paramString.addAll(this.vMY);
    localIntent.putExtra("always_select_contact", bk.c(new ArrayList(paramString), ","));
    localIntent.putExtra("always_select_contact", bk.c(new ArrayList(paramString), ","));
    if (s.fA(this.vNa, 64))
    {
      localIntent.putExtra("list_attr", s.v(new int[] { 16384, 64, 131072 }));
      if (this.vIY == 14) {
        localIntent.putExtra("max_limit_num", getIntent().getIntExtra("max_limit_num", 2147483647));
      }
    }
    for (;;)
    {
      startActivityForResult(localIntent, 3);
      return;
      localIntent.putExtra("list_attr", 16384);
    }
  }
  
  protected final boolean VC()
  {
    return false;
  }
  
  protected final boolean VD()
  {
    return true;
  }
  
  protected final String VE()
  {
    return this.title;
  }
  
  protected final o VF()
  {
    boolean bool2 = false;
    c.a locala = new c.a();
    locala.vJK = s.fA(this.vNa, 16);
    locala.vJJ = s.fA(this.vNa, 32);
    boolean bool1;
    if (!s.fA(this.vNa, 4))
    {
      bool1 = true;
      locala.vJL = bool1;
      if (s.fA(this.vNa, 1)) {
        break label319;
      }
      bool1 = true;
      label71:
      locala.vJM = bool1;
      locala.vJN = s.fA(this.vNa, 128);
      locala.vJO = s.fA(this.vNa, 1048576);
      locala.vJR = s.fA(this.vNa, 256);
      if (locala.vJR) {
        locala.vJS = getIntent().getStringExtra("custom_contact");
      }
      if (locala.vJN)
      {
        this.vNz = true;
        locala.vJP = getIntent().getStringExtra("wechat_sport_contact");
        locala.vJQ = getIntent().getStringExtra("wechat_sport_recent_like");
        this.vNA = locala.vJP;
      }
      if (!s.cHQ()) {
        break label324;
      }
    }
    label319:
    label324:
    for (locala.vIs = "@all.contact.without.chatroom.without.openim";; locala.vIs = "@all.contact.without.chatroom.without.openim.without.openimfavour")
    {
      if ((this.scene == 6) || (this.scene == 5)) {
        locala.vIs = "@all.contact.without.chatroom.without.openim.without.openimfavour";
      }
      if (getIntent().getBooleanExtra("KBlockOpenImFav", false)) {
        locala.vIs = "@all.contact.without.chatroom.without.openim.without.openimfavour";
      }
      List localList = this.dru;
      boolean bool3 = s.fA(this.vNa, 1);
      boolean bool4 = s.fA(this.vNa, 64);
      bool1 = bool2;
      if (this.vIY == 15) {
        bool1 = true;
      }
      return new c(this, localList, bool3, bool4, locala, bool1);
      bool1 = false;
      break;
      bool1 = false;
      break label71;
    }
  }
  
  protected final m VG()
  {
    if (this.vNz) {
      return new r(this, this.dru, s.fA(this.vNa, 64), this.vNA);
    }
    return new q(this, this.dru, s.fA(this.vNa, 64), this.scene);
  }
  
  protected final void a(ListView paramListView, int paramInt)
  {
    super.a(paramListView, paramInt);
    Object localObject;
    if (s.fA(this.vNa, 256))
    {
      if (this.vNn == null)
      {
        SelectContactUI.10 local10 = new SelectContactUI.10(this);
        if (this.vIY == 14)
        {
          localObject = getString(R.l.address_select_group_card);
          this.vNn = a(paramListView, local10, (String)localObject);
        }
      }
      else
      {
        this.vNn.setVisibility(paramInt);
      }
    }
    else
    {
      if (s.fA(this.vNa, 512))
      {
        if (this.vNo == null) {
          this.vNo = a(paramListView, new SelectContactUI.11(this), getString(R.l.find_friends_create_pwdgroup));
        }
        this.vNo.setVisibility(paramInt);
      }
      if (s.fA(this.vNa, 1024))
      {
        if (this.vNp == null) {
          this.vNp = a(paramListView, new SelectContactUI.12(this), getString(R.l.address_history_group_card_import));
        }
        this.vNp.setVisibility(paramInt);
      }
      if (s.fA(this.vNa, 2048))
      {
        if (this.vNq == null) {
          this.vNq = a(paramListView, new SelectContactUI.13(this), getString(R.l.address_official_accounts_title));
        }
        this.vNq.setVisibility(paramInt);
        this.vNq.setTextSize(16.0F * com.tencent.mm.cb.a.cJ(this.vNq.getContext()));
      }
      if ((s.fA(this.vNa, 16777216)) && (this.vNr == null))
      {
        au.Hx();
        localObject = com.tencent.mm.model.c.Fw().cul();
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SelectContactUI", "setOpenIMHeaderView %s", new Object[] { Integer.valueOf(((List)localObject).size()) });
        if (((List)localObject).size() != 0)
        {
          this.vNr = a(paramListView, new SelectContactUI.14(this), "");
          paramListView = ((b)com.tencent.mm.kernel.g.r(b.class)).a("3552365301", "openim_acct_type_title", b.a.ePI);
          this.vNr.setVisibility(paramInt);
          this.vNr.setText(paramListView);
        }
      }
      if ((!s.fA(this.vNa, 16777216)) || (this.vNr == null)) {
        break label418;
      }
      this.vNr.setBackgroundResource(R.g.comm_list_item_selector_no_divider);
    }
    label418:
    label449:
    label480:
    label511:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            localObject = getString(R.l.address_history_group_card);
            break;
            if (!s.fA(this.vNa, 2048)) {
              break label449;
            }
          } while (this.vNq == null);
          this.vNq.setBackgroundResource(R.g.comm_list_item_selector_no_divider);
          return;
          if (!s.fA(this.vNa, 1024)) {
            break label480;
          }
        } while (this.vNp == null);
        this.vNp.setBackgroundResource(R.g.comm_list_item_selector_no_divider);
        return;
        if (!s.fA(this.vNa, 512)) {
          break label511;
        }
      } while (this.vNo == null);
      this.vNo.setBackgroundResource(R.g.comm_list_item_selector_no_divider);
      return;
    } while ((!s.fA(this.vNa, 256)) || (this.vNn == null));
    this.vNn.setBackgroundResource(R.g.comm_list_item_selector_no_divider);
  }
  
  public final boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    if ((parama.vLJ) && (parama.dnp != null)) {
      return this.eXT.contains(parama.dnp.field_username);
    }
    if ((parama.vLK) && (parama.dnp != null)) {
      return this.eXT.contains(parama.dnp.field_username);
    }
    if ((parama instanceof j)) {
      return this.eXT.isEmpty();
    }
    return false;
  }
  
  public final boolean b(com.tencent.mm.ui.contact.a.a parama)
  {
    if ((parama.vLJ) && (parama.dnp != null)) {
      return this.vMY.contains(parama.dnp.field_username);
    }
    return false;
  }
  
  public final int[] bgw()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(131072));
    localArrayList.add(Integer.valueOf(131081));
    if (!s.fA(this.vNa, 1)) {
      localArrayList.add(Integer.valueOf(131076));
    }
    if (!s.fA(this.vNa, 4)) {
      localArrayList.add(Integer.valueOf(131075));
    }
    int[] arrayOfInt = new int[localArrayList.size()];
    int i = 0;
    while (i < localArrayList.size())
    {
      arrayOfInt[i] = ((Integer)localArrayList.get(i)).intValue();
      i += 1;
    }
    return arrayOfInt;
  }
  
  protected final boolean bhB()
  {
    return !this.vNz;
  }
  
  public final void jP(int paramInt)
  {
    int i = paramInt - getContentLV().getHeaderViewsCount();
    if (i < 0) {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SelectContactUI", "offsetPosition is Smaller than 0, offsetPosition=%d | position=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
    }
    do
    {
      do
      {
        do
        {
          return;
          localObject = cHE().HK(i);
        } while (localObject == null);
        if (!(localObject instanceof j)) {
          break;
        }
      } while (!s.fA(this.vNa, 16384));
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SelectContactUI", "handleClickNonSelect, return the result");
      localObject = new Intent();
      ((Intent)localObject).putExtra("Select_Contact", "");
      ((Intent)localObject).putExtra("Select_Conv_User", "");
      ((Intent)localObject).putExtra("Select_Contact", "");
      setResult(-1, (Intent)localObject);
      finish();
      return;
    } while ((((com.tencent.mm.ui.contact.a.a)localObject).dnp == null) || (((com.tencent.mm.ui.contact.a.a)localObject).dnp.field_deleteFlag == 1));
    Object localObject = ((com.tencent.mm.ui.contact.a.a)localObject).dnp.field_username;
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SelectContactUI", "ClickUser=%s", new Object[] { localObject });
    if (s.fA(this.vNa, 64))
    {
      if ((s.fA(this.vNa, 131072)) && (this.eXT.size() >= getIntent().getIntExtra("max_limit_num", 2147483647))) {
        if (!this.vMY.contains(localObject))
        {
          cHK();
          if (!this.eXT.contains(localObject)) {
            break label283;
          }
          this.mbR.Wv((String)localObject);
          this.eXT.remove(localObject);
        }
      }
      for (;;)
      {
        xU();
        cHR();
        cHF().notifyDataSetChanged();
        return;
        label283:
        String str = getIntent().getStringExtra("too_many_member_tip_string");
        localObject = str;
        if (bk.bl(str)) {
          localObject = getString(R.l.select_contact_num_limit_tips, new Object[] { Integer.valueOf(getIntent().getIntExtra("max_limit_num", 10)) });
        }
        com.tencent.mm.ui.base.h.a(this.mController.uMN, (String)localObject, getString(R.l.app_remind), new SelectContactUI.7(this));
        continue;
        adU((String)localObject);
      }
    }
    em(bk.G(new String[] { localObject }));
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.bQU = paramInt1;
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SelectContactUI", "requestCode=%d | resultCode=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 != -1) {}
    Object localObject1;
    String str1;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            switch (paramInt1)
            {
            default: 
              return;
            case 0: 
              paramIntent = paramIntent.getStringExtra("Select_Conv_User");
            }
          } while (bk.bl(paramIntent));
          em(bk.G(new String[] { paramIntent }));
          return;
          paramIntent = paramIntent.getStringExtra("Select_Conv_User");
          localObject1 = this.eXT.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            str1 = (String)((Iterator)localObject1).next();
            this.mbR.Ww(str1);
          }
          this.eXT.clear();
          if (!bk.bl(paramIntent)) {
            this.eXT.addAll(bk.G(paramIntent.split(",")));
          }
          paramIntent = this.eXT.iterator();
          while (paramIntent.hasNext())
          {
            localObject1 = (String)paramIntent.next();
            this.mbR.bz((String)localObject1, false);
          }
          xU();
          return;
          paramIntent = paramIntent.getStringExtra("Select_Contact");
        } while (bk.bl(paramIntent));
        em(bk.G(paramIntent.split(",")));
        return;
      } while (paramIntent == null);
      paramIntent = paramIntent.getStringExtra("Select_Contact");
    } while (bk.bl(paramIntent));
    em(bk.G(new String[] { paramIntent }));
    return;
    paramIntent = paramIntent.getStringExtra("Select_Contact");
    if (bk.bl(paramIntent))
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SelectContactUI", "GET_LABEL_USERS return usernames is null or empty");
      return;
    }
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SelectContactUI", "GET_LABEL_USERS select username=%s", new Object[] { paramIntent });
    if (s.fA(this.vNa, 64))
    {
      paramIntent = paramIntent.split(",");
      paramInt2 = paramIntent.length;
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        localObject1 = paramIntent[paramInt1];
        if (this.eXT.add(localObject1)) {
          this.mbR.Wv((String)localObject1);
        }
        paramInt1 += 1;
      }
      xU();
      cHE().notifyDataSetChanged();
      return;
    }
    em(bk.G(new String[] { paramIntent }));
    return;
    if (paramIntent != null)
    {
      str1 = paramIntent.getStringExtra("Select_Contact");
      localObject1 = paramIntent.getStringExtra("Cancel_Select_Contact");
      if (bk.bl(str1))
      {
        paramIntent = null;
        if (!bk.bl((String)localObject1)) {
          break label567;
        }
        localObject1 = null;
      }
      label490:
      Object localObject2;
      for (;;)
      {
        if (paramIntent != null)
        {
          if (this.mbR != null)
          {
            localObject2 = paramIntent.iterator();
            for (;;)
            {
              if (((Iterator)localObject2).hasNext())
              {
                String str2 = (String)((Iterator)localObject2).next();
                if (!this.eXT.contains(str2))
                {
                  this.mbR.Wv(str2);
                  continue;
                  paramIntent = bk.gg(str1, ",");
                  break;
                  label567:
                  localObject1 = bk.gg((String)localObject1, ",");
                  break label490;
                }
              }
            }
          }
          this.eXT.addAll(paramIntent);
        }
      }
      if (localObject1 != null)
      {
        if (this.mbR != null)
        {
          paramIntent = ((List)localObject1).iterator();
          while (paramIntent.hasNext())
          {
            localObject2 = (String)paramIntent.next();
            this.mbR.Wv((String)localObject2);
          }
        }
        this.eXT.removeAll((Collection)localObject1);
      }
      cHE().notifyDataSetChanged();
      if (getIntent().getBooleanExtra("Add_SendCard", false)) {
        em(bk.G(new String[] { str1 }));
      }
    }
    xU();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    au.Dk().a(30, this);
    au.Dk().a(138, this);
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SelectContactUI", "create!");
    if (!bk.bl(this.imV)) {
      setMMSubTitle(this.imV);
    }
    if (s.fA(this.vNa, 64)) {
      a(1, getString(R.l.app_ok), new SelectContactUI.17(this), s.b.uNx);
    }
    xU();
    setBackBtn(new SelectContactUI.1(this));
    if (this.vIY != 15)
    {
      paramBundle = this.eXT.iterator();
      while (paramBundle.hasNext())
      {
        String str = (String)paramBundle.next();
        this.mbR.bz(str, false);
      }
    }
  }
  
  protected void onDestroy()
  {
    au.Dk().b(30, this);
    au.Dk().b(138, this);
    super.onDestroy();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    if (this.dnm != null)
    {
      this.dnm.dismiss();
      this.dnm = null;
    }
    if (!bk.bU(this)) {}
    do
    {
      do
      {
        return;
      } while (w.a.a(this, paramInt1, paramInt2, paramString, 4));
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        break;
      }
    } while ((paramInt1 != 4) || (paramInt2 != -24) || (bk.bl(paramString)));
    Toast.makeText(this, paramString, 1).show();
    return;
    switch (paramm.getType())
    {
    default: 
      return;
    }
    cHE().notifyDataSetChanged();
  }
  
  public final void pw(String paramString)
  {
    this.eXT.remove(paramString);
    cHE().notifyDataSetChanged();
    xU();
  }
  
  protected final void xK()
  {
    super.xK();
    this.vNa = getIntent().getIntExtra("list_attr", s.vMq);
    this.title = getIntent().getStringExtra("titile");
    this.imV = getIntent().getStringExtra("sub_title");
    this.vIY = getIntent().getIntExtra("list_type", -1);
    this.vNb = getIntent().getBooleanExtra("show_too_many_member", true);
    this.mSource = getIntent().getStringExtra("label_source");
    if ((s.fA(this.vNa, 256)) && (com.tencent.mm.model.s.GV().size() == 0)) {
      s.fB(this.vNa, 256);
    }
    this.vNs = getIntent().getBooleanExtra("Add_SendCard", false);
    this.vNt = getIntent().getBooleanExtra("recommend_friends", false);
    if ((this.vNs) || (this.vNt))
    {
      this.vNu = bk.aM(getIntent().getStringExtra("be_send_card_name"), "");
      this.vNv = bk.aM(getIntent().getStringExtra("received_card_name"), "");
    }
    this.vNw = getIntent().getBooleanExtra("Forbid_SelectChatRoom", false);
    this.dru = new ArrayList();
    this.eXT = new HashSet();
    this.vMY = new HashSet();
    Object localObject = getIntent().getStringExtra("always_select_contact");
    if (!bk.bl((String)localObject)) {
      this.vMY.addAll(bk.G(((String)localObject).split(",")));
    }
    localObject = getIntent().getStringExtra("already_select_contact");
    if (!bk.bl((String)localObject)) {
      this.eXT.addAll(bk.G(((String)localObject).split(",")));
    }
    localObject = new HashSet();
    String str = getIntent().getStringExtra("block_contact");
    if (!bk.bl(str)) {
      ((HashSet)localObject).addAll(bk.G(str.split(",")));
    }
    localObject = new HashSet((Collection)localObject);
    ((HashSet)localObject).addAll(s.cHO());
    ((HashSet)localObject).addAll(s.cHP());
    if (this.vNs) {
      ((HashSet)localObject).removeAll(s.cHO());
    }
    this.dru.addAll((Collection)localObject);
    cHR();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SelectContactUI
 * JD-Core Version:    0.7.0.1
 */