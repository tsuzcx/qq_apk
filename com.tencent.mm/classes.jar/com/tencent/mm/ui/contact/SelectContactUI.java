package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.m.e;
import com.tencent.mm.model.aw;
import com.tencent.mm.openim.a.b;
import com.tencent.mm.openim.a.b.a;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.q.b;
import com.tencent.mm.ui.v.a;
import com.tencent.mm.ui.w;
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
  private int Aau;
  private HashSet<String> AeB;
  private int AeD;
  private boolean AeE;
  private SelectContactUI.a AeF;
  private TextView AeQ;
  private TextView AeR;
  private TextView AeS;
  private TextView AeT;
  private TextView AeU;
  private TextView AeV;
  private boolean AeW;
  private boolean AeX;
  private String AeY;
  private String AeZ;
  private boolean Afa;
  private boolean Afb;
  private boolean Afc;
  private boolean Afd;
  private String Afe;
  private SelectContactUI.b Aff;
  private ProgressDialog eeN;
  private List<String> ejc;
  private HashSet<String> gpQ;
  private String jjP;
  private String nYv;
  private int requestCode;
  private String title;
  
  public SelectContactUI()
  {
    AppMethodBeat.i(33871);
    this.AeE = true;
    this.Afd = false;
    this.Aff = new SelectContactUI.b(this, (byte)0);
    this.AeF = new SelectContactUI.a();
    AppMethodBeat.o(33871);
  }
  
  private void Km()
  {
    AppMethodBeat.i(33883);
    if ((t.hI(this.AeD, 64)) && (this.gpQ.size() > 0))
    {
      updateOptionMenuText(1, getString(2131297018) + "(" + this.gpQ.size() + ")");
      int i = getIntent().getIntExtra("min_limit_num", 0);
      if ((t.hI(this.AeD, 262144)) && (this.gpQ.size() < i))
      {
        enableOptionMenu(1, false);
        AppMethodBeat.o(33883);
        return;
      }
      enableOptionMenu(1, true);
      AppMethodBeat.o(33883);
      return;
    }
    updateOptionMenuText(1, getString(2131297018));
    enableOptionMenu(1, false);
    AppMethodBeat.o(33883);
  }
  
  private static List<String> M(List<String> paramList)
  {
    AppMethodBeat.i(33896);
    LinkedList localLinkedList = new LinkedList();
    if (!aw.RG())
    {
      AppMethodBeat.o(33896);
      return localLinkedList;
    }
    if (paramList == null)
    {
      AppMethodBeat.o(33896);
      return localLinkedList;
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      aw.aaz();
      ad localad = com.tencent.mm.model.c.YA().arw(str);
      paramList = str;
      if (localad != null)
      {
        paramList = str;
        if ((int)localad.euF != 0) {
          paramList = localad.Of();
        }
      }
      localLinkedList.add(paramList);
    }
    AppMethodBeat.o(33896);
    return localLinkedList;
  }
  
  private TextView a(ListView paramListView, View.OnClickListener paramOnClickListener, String paramString)
  {
    AppMethodBeat.i(33880);
    View localView = w.hM(this).inflate(2130969849, null);
    localView.setOnClickListener(paramOnClickListener);
    paramOnClickListener = (TextView)localView.findViewById(2131823022);
    paramOnClickListener.setText(paramString);
    paramListView.addHeaderView(localView);
    AppMethodBeat.o(33880);
    return paramOnClickListener;
  }
  
  private void a(com.tencent.mm.roomsdk.a.c.a parama)
  {
    AppMethodBeat.i(33888);
    parama.d(new SelectContactUI.5(this, parama));
    getString(2131297087);
    parama.a(this, getString(2131301056), true, new SelectContactUI.6(this, parama));
    AppMethodBeat.o(33888);
  }
  
  private void auC(String paramString)
  {
    AppMethodBeat.i(33894);
    if (this.AeB.contains(paramString))
    {
      AppMethodBeat.o(33894);
      return;
    }
    dMc();
    this.oCs.ama(paramString);
    if (this.gpQ.contains(paramString))
    {
      this.gpQ.remove(paramString);
      AppMethodBeat.o(33894);
      return;
    }
    this.gpQ.add(paramString);
    AppMethodBeat.o(33894);
  }
  
  private void dMj()
  {
    int j = 0;
    AppMethodBeat.i(33876);
    if ((this.AeE) && ((this.Aau == 1) || (this.Aau == 0))) {
      if (this.AeB == null) {
        break label92;
      }
    }
    label92:
    for (int i = this.AeB.size();; i = 0)
    {
      if (this.gpQ != null) {
        j = this.gpQ.size();
      }
      int k = bo.apV(com.tencent.mm.m.g.Nq().getValue("ChatRoomInviteStartCount"));
      this.AeF.e(this, i + j, k);
      AppMethodBeat.o(33876);
      return;
    }
  }
  
  private void dMk()
  {
    AppMethodBeat.i(33886);
    ArrayList localArrayList = rj(true);
    localArrayList.remove(com.tencent.mm.model.r.Zn());
    if (localArrayList.size() > 0)
    {
      this.eeN = com.tencent.mm.ui.base.h.b(getContext(), getString(2131301428), false, null);
      aw.RO().ac(new SelectContactUI.c(this, localArrayList, (byte)0));
    }
    AppMethodBeat.o(33886);
  }
  
  private void dMl()
  {
    AppMethodBeat.i(33887);
    Object localObject = rj(false);
    ((ArrayList)localObject).remove(com.tencent.mm.model.r.Zn());
    String str = bo.d((List)localObject, ",");
    if (!bo.es((List)localObject))
    {
      com.tencent.mm.ui.base.h.a(getContext(), true, getString(2131301018), "", getString(2131301017), getString(2131301016), new SelectContactUI.3(this, str), new SelectContactUI.4(this, str));
      AppMethodBeat.o(33887);
      return;
    }
    localObject = new Intent();
    ((Intent)localObject).putExtra("Select_Contact", str);
    ((Intent)localObject).putExtra("Select_Conv_User", str);
    ((Intent)localObject).putExtra("Select_Contact", str);
    ((Intent)localObject).putExtra("Select_Contacts_To_Create_New_Label", str);
    setResult(0, (Intent)localObject);
    finish();
    AppMethodBeat.o(33887);
  }
  
  private String fA(List<String> paramList)
  {
    AppMethodBeat.i(33895);
    StringBuilder localStringBuilder = null;
    Object localObject = localStringBuilder;
    if (paramList != null)
    {
      if (paramList.size() != 1) {
        break label62;
      }
      localObject = getString(2131303036, new Object[] { com.tencent.mm.model.s.nE((String)paramList.get(0)) });
    }
    label62:
    do
    {
      AppMethodBeat.o(33895);
      return localObject;
      localObject = localStringBuilder;
    } while (paramList.size() <= 1);
    localObject = getString(2131297071);
    localStringBuilder = new StringBuilder();
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
        localObject = getString(2131303036, new Object[] { localStringBuilder.toString() });
        break;
      }
      localStringBuilder.append(com.tencent.mm.model.s.nE((String)paramList.get(i)));
      if (i < paramList.size() - 1) {
        localStringBuilder.append((String)localObject);
      }
      i += 1;
    }
  }
  
  private boolean fy(List<String> paramList)
  {
    AppMethodBeat.i(33881);
    ab.i("MicroMsg.SelectContactUI", "handleSelect %s", new Object[] { paramList });
    if (t.hI(this.AeD, 65536))
    {
      String str = fA(paramList);
      this.Afc = true;
      com.tencent.mm.ui.base.h.a(getContext(), str, null, true, new SelectContactUI.16(this, paramList), new SelectContactUI.17(this));
      bool = this.Afc;
      AppMethodBeat.o(33881);
      return bool;
    }
    boolean bool = fz(paramList);
    AppMethodBeat.o(33881);
    return bool;
  }
  
  private boolean fz(List<String> paramList)
  {
    boolean bool = false;
    AppMethodBeat.i(33882);
    if (getIntent().getBooleanExtra("Add_SendCard", false))
    {
      if (bo.isNullOrNil(this.AeY)) {
        this.AeY = bo.d(paramList, ",");
      }
      for (;;)
      {
        bool = com.tencent.mm.model.t.lA(this.AeZ);
        paramList = new Intent();
        paramList.putExtra("be_send_card_name", this.AeY);
        paramList.putExtra("received_card_name", this.AeZ);
        paramList.putExtra("Is_Chatroom", bool);
        setResult(-1, paramList);
        finish();
        AppMethodBeat.o(33882);
        return true;
        if (!bo.isNullOrNil(this.AeZ)) {
          break;
        }
        this.AeZ = bo.d(paramList, ",");
      }
      ab.e("MicroMsg.SelectContactUI", "send card occur error: send:%s | receive:%s", new Object[] { this.AeY, this.AeZ });
      AppMethodBeat.o(33882);
      return false;
    }
    Object localObject;
    int i;
    if (getIntent().getBooleanExtra("snsPostWhoCanSee", false))
    {
      ab.i("MicroMsg.SelectContactUI", "sns post who can see scene,users=%s", new Object[] { paramList.toString() });
      localObject = rj(false);
      ((ArrayList)localObject).remove(com.tencent.mm.model.r.Zn());
      paramList = paramList.iterator();
      for (i = 0; paramList.hasNext(); i = 1)
      {
        label228:
        String str = (String)paramList.next();
        if (bo.isNullOrNil(str)) {
          break label658;
        }
        if ((((ArrayList)localObject).contains(str)) || (com.tencent.mm.model.r.Zn().equals(str))) {
          break label228;
        }
        aw.aaz();
        ad localad = com.tencent.mm.model.c.YA().arw(str);
        if ((localad == null) || ((int)localad.euF == 0) || (!com.tencent.mm.n.a.je(localad.field_type))) {
          break label658;
        }
        auC(str);
        ((ArrayList)localObject).add(str);
      }
    }
    label658:
    for (;;)
    {
      break label228;
      if (i != 0)
      {
        Km();
        dLW().notifyDataSetChanged();
        break;
      }
      dMl();
      break;
      if (getIntent().getBooleanExtra("recommend_friends", false))
      {
        ab.i("MicroMsg.SelectContactUI", "Recommend Friends");
        aa.a(getContext(), this.AeZ, paramList);
        break;
      }
      if (t.hI(this.AeD, 16384))
      {
        ab.i("MicroMsg.SelectContactUI", "return the result");
        localObject = new Intent();
        paramList = bo.d(paramList, ",");
        ((Intent)localObject).putExtra("Select_Contact", paramList);
        ((Intent)localObject).putExtra("Select_Conv_User", paramList);
        ((Intent)localObject).putExtra("Select_Contact", paramList);
        ((Intent)localObject).putExtra("label_source", this.nYv);
        if (this.requestCode == 1) {
          bool = true;
        }
        ((Intent)localObject).putExtra("Is_Chatroom", bool);
        setResult(-1, (Intent)localObject);
        finish();
        break;
      }
      if (getIntent().getBooleanExtra("shareImage", false))
      {
        ab.i("MicroMsg.SelectContactUI", "Share Image");
        dMk();
        break;
      }
      if (paramList.size() > 0)
      {
        ab.i("MicroMsg.SelectContactUI", "Launch ChattingUI: users=%s", new Object[] { paramList.toString() });
        finish();
        localObject = new Intent();
        ((Intent)localObject).setClass(this, ChattingUI.class);
        ((Intent)localObject).putExtra("Chat_User", (String)paramList.get(0));
        ((Intent)localObject).addFlags(67108864);
        startActivity((Intent)localObject);
        break;
      }
      ab.e("MicroMsg.SelectContactUI", "unkown action: User=%s", new Object[] { paramList.toString() });
      break;
    }
  }
  
  private ArrayList<String> rj(boolean paramBoolean)
  {
    AppMethodBeat.i(33884);
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.gpQ.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      if ((!paramBoolean) && (com.tencent.mm.model.t.nR((String)localObject)))
      {
        localObject = com.tencent.mm.model.n.nu((String)localObject);
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
    AppMethodBeat.o(33884);
    return localArrayList;
  }
  
  private ArrayList<String> rk(boolean paramBoolean)
  {
    AppMethodBeat.i(33885);
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.gpQ.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      if ((!paramBoolean) && (com.tencent.mm.model.t.nR((String)localObject)))
      {
        localObject = com.tencent.mm.model.n.nu((String)localObject);
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
    localHashSet.addAll(this.AeB);
    localArrayList.addAll(localHashSet);
    AppMethodBeat.o(33885);
    return localArrayList;
  }
  
  protected final void Kc()
  {
    AppMethodBeat.i(33872);
    super.Kc();
    this.AeD = getIntent().getIntExtra("list_attr", t.AdS);
    this.title = getIntent().getStringExtra("titile");
    this.jjP = getIntent().getStringExtra("sub_title");
    this.Aau = getIntent().getIntExtra("list_type", -1);
    this.AeE = getIntent().getBooleanExtra("show_too_many_member", true);
    this.nYv = getIntent().getStringExtra("label_source");
    if ((t.hI(this.AeD, 256)) && (com.tencent.mm.model.t.ZX().size() == 0)) {
      t.hJ(this.AeD, 256);
    }
    this.AeW = getIntent().getBooleanExtra("Add_SendCard", false);
    this.AeX = getIntent().getBooleanExtra("recommend_friends", false);
    if ((this.AeW) || (this.AeX))
    {
      this.AeY = bo.bf(getIntent().getStringExtra("be_send_card_name"), "");
      this.AeZ = bo.bf(getIntent().getStringExtra("received_card_name"), "");
    }
    this.Afa = getIntent().getBooleanExtra("Forbid_SelectChatRoom", false);
    this.ejc = new ArrayList();
    this.gpQ = new HashSet();
    this.AeB = new HashSet();
    Object localObject = getIntent().getStringExtra("always_select_contact");
    if (!bo.isNullOrNil((String)localObject)) {
      this.AeB.addAll(bo.P(((String)localObject).split(",")));
    }
    localObject = getIntent().getStringExtra("already_select_contact");
    if (!bo.isNullOrNil((String)localObject)) {
      this.gpQ.addAll(bo.P(((String)localObject).split(",")));
    }
    localObject = new HashSet();
    String str = getIntent().getStringExtra("block_contact");
    if (!bo.isNullOrNil(str)) {
      ((HashSet)localObject).addAll(bo.P(str.split(",")));
    }
    localObject = new HashSet((Collection)localObject);
    ((HashSet)localObject).addAll(t.dMg());
    ((HashSet)localObject).addAll(t.dMh());
    if (this.AeW) {
      ((HashSet)localObject).removeAll(t.dMg());
    }
    this.ejc.addAll((Collection)localObject);
    dMj();
    AppMethodBeat.o(33872);
  }
  
  protected final void SL(String paramString)
  {
    AppMethodBeat.i(33898);
    com.tencent.mm.plugin.report.service.h.qsU.e(11225, new Object[] { Integer.valueOf(1), Integer.valueOf(0) });
    Intent localIntent = new Intent();
    localIntent.setClassName(this, "com.tencent.mm.ui.contact.SelectLabelContactUI");
    localIntent.putExtra("label", paramString);
    paramString = new HashSet();
    paramString.addAll(rj(t.hI(this.AeD, 8192)));
    paramString.addAll(this.AeB);
    localIntent.putExtra("always_select_contact", bo.d(new ArrayList(paramString), ","));
    localIntent.putExtra("always_select_contact", bo.d(new ArrayList(paramString), ","));
    if (t.hI(this.AeD, 64))
    {
      localIntent.putExtra("list_attr", t.F(new int[] { 16384, 64, 131072 }));
      if (this.Aau == 14) {
        localIntent.putExtra("max_limit_num", getIntent().getIntExtra("max_limit_num", 2147483647));
      }
    }
    for (;;)
    {
      startActivityForResult(localIntent, 3);
      AppMethodBeat.o(33898);
      return;
      localIntent.putExtra("list_attr", 16384);
    }
  }
  
  protected final void a(ListView paramListView, int paramInt)
  {
    AppMethodBeat.i(33879);
    super.a(paramListView, paramInt);
    Object localObject;
    int i;
    int j;
    label328:
    int m;
    int k;
    if (t.hI(this.AeD, 256))
    {
      if (this.AeQ == null)
      {
        SelectContactUI.10 local10 = new SelectContactUI.10(this);
        if (this.Aau == 14)
        {
          localObject = getString(2131296493);
          this.AeQ = a(paramListView, local10, (String)localObject);
        }
      }
      else
      {
        this.AeQ.setVisibility(paramInt);
      }
    }
    else
    {
      if (t.hI(this.AeD, 512))
      {
        if (this.AeR == null) {
          this.AeR = a(paramListView, new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(33859);
              com.tencent.mm.plugin.report.service.h.qsU.e(11140, new Object[] { Integer.valueOf(0) });
              d.H(SelectContactUI.this, "pwdgroup", ".ui.FacingCreateChatRoomAllInOneUI");
              AppMethodBeat.o(33859);
            }
          }, getString(2131299913));
        }
        this.AeR.setVisibility(paramInt);
      }
      if (t.hI(this.AeD, 1024))
      {
        if (this.AeS == null) {
          this.AeS = a(paramListView, new SelectContactUI.12(this), getString(2131296473));
        }
        this.AeS.setVisibility(paramInt);
      }
      if (t.hI(this.AeD, 2048))
      {
        if (this.AeU == null) {
          this.AeU = a(paramListView, new SelectContactUI.13(this), getString(2131296487));
        }
        this.AeU.setVisibility(paramInt);
        this.AeU.setTextSize(16.0F * com.tencent.mm.cb.a.dr(this.AeU.getContext()));
      }
      if (t.hI(this.AeD, 524288)) {
        if (this.AeT == null)
        {
          localObject = "";
          i = getIntent().getIntExtra("topstory_import_type", 0);
          j = 2131296477;
          if (i != 1) {
            break label621;
          }
          localObject = com.tencent.mm.plugin.sns.b.n.raT.lo(5L);
          if (!bo.es((List)localObject)) {
            break label610;
          }
          i = 0;
          localObject = bo.d((List)localObject, ",");
          j = 2131296477;
          m = 2131296478;
          k = i;
          i = m;
        }
      }
    }
    for (;;)
    {
      this.AeT = a(paramListView, new SelectContactUI.14(this, i, k, (String)localObject), getString(j));
      this.AeT.setTag(Integer.valueOf(k));
      localObject = this.AeT.getTag();
      if ((!(localObject instanceof Integer)) || (((Integer)localObject).intValue() <= 0)) {
        this.AeT.setVisibility(8);
      }
      for (;;)
      {
        if ((t.hI(this.AeD, 16777216)) && (this.AeV == null))
        {
          aw.aaz();
          localObject = com.tencent.mm.model.c.YA().dwK();
          ab.i("MicroMsg.SelectContactUI", "setOpenIMHeaderView %s", new Object[] { Integer.valueOf(((List)localObject).size()) });
          if (((List)localObject).size() != 0)
          {
            this.AeV = a(paramListView, new SelectContactUI.15(this), "");
            paramListView = ((b)com.tencent.mm.kernel.g.E(b.class)).a("3552365301", "openim_acct_type_title", b.a.gfD);
            this.AeV.setVisibility(paramInt);
            this.AeV.setText(paramListView);
          }
        }
        if ((!t.hI(this.AeD, 16777216)) || (this.AeV == null)) {
          break label692;
        }
        this.AeV.setBackgroundResource(2130838447);
        AppMethodBeat.o(33879);
        return;
        localObject = getString(2131296472);
        break;
        label610:
        i = ((List)localObject).size();
        break label328;
        label621:
        if (i != 2) {
          break label840;
        }
        localObject = com.tencent.mm.model.t.aac();
        if (bo.es((List)localObject)) {}
        for (i = 0;; i = ((List)localObject).size())
        {
          localObject = bo.d((List)localObject, ",");
          j = 2131296475;
          m = 2131296476;
          k = i;
          i = m;
          break;
        }
        this.AeT.setVisibility(paramInt);
      }
      label692:
      if (t.hI(this.AeD, 2048))
      {
        if (this.AeU != null)
        {
          this.AeU.setBackgroundResource(2130838447);
          AppMethodBeat.o(33879);
        }
      }
      else if (t.hI(this.AeD, 1024))
      {
        if (this.AeS != null)
        {
          this.AeS.setBackgroundResource(2130838447);
          AppMethodBeat.o(33879);
        }
      }
      else if (t.hI(this.AeD, 512))
      {
        if (this.AeR != null)
        {
          this.AeR.setBackgroundResource(2130838447);
          AppMethodBeat.o(33879);
        }
      }
      else if ((t.hI(this.AeD, 256)) && (this.AeQ != null)) {
        this.AeQ.setBackgroundResource(2130838447);
      }
      AppMethodBeat.o(33879);
      return;
      label840:
      i = 2131296478;
      k = 0;
    }
  }
  
  public final boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(33890);
    boolean bool;
    if ((parama.Adl) && (parama.contact != null))
    {
      bool = this.gpQ.contains(parama.contact.field_username);
      AppMethodBeat.o(33890);
      return bool;
    }
    if ((parama.Adm) && (parama.contact != null))
    {
      bool = this.gpQ.contains(parama.contact.field_username);
      AppMethodBeat.o(33890);
      return bool;
    }
    if ((parama instanceof com.tencent.mm.ui.contact.a.k))
    {
      bool = this.gpQ.isEmpty();
      AppMethodBeat.o(33890);
      return bool;
    }
    AppMethodBeat.o(33890);
    return false;
  }
  
  protected final boolean apa()
  {
    return false;
  }
  
  protected final boolean apb()
  {
    return true;
  }
  
  protected final String apc()
  {
    return this.title;
  }
  
  protected final p apd()
  {
    boolean bool2 = false;
    AppMethodBeat.i(33877);
    Object localObject = new c.a();
    ((c.a)localObject).Abg = t.hI(this.AeD, 16);
    ((c.a)localObject).Abf = t.hI(this.AeD, 32);
    boolean bool1;
    if (!t.hI(this.AeD, 4))
    {
      bool1 = true;
      ((c.a)localObject).Abh = bool1;
      if (t.hI(this.AeD, 1)) {
        break label335;
      }
      bool1 = true;
      label77:
      ((c.a)localObject).Abi = bool1;
      ((c.a)localObject).Abj = t.hI(this.AeD, 128);
      ((c.a)localObject).Abk = t.hI(this.AeD, 1048576);
      ((c.a)localObject).Abn = t.hI(this.AeD, 256);
      if (((c.a)localObject).Abn) {
        ((c.a)localObject).Abo = getIntent().getStringExtra("custom_contact");
      }
      if (((c.a)localObject).Abj)
      {
        this.Afd = true;
        ((c.a)localObject).Abl = getIntent().getStringExtra("wechat_sport_contact");
        ((c.a)localObject).Abm = getIntent().getStringExtra("wechat_sport_recent_like");
        this.Afe = ((c.a)localObject).Abl;
      }
      if (!t.dMi()) {
        break label340;
      }
    }
    label335:
    label340:
    for (((c.a)localObject).zZK = "@all.contact.without.chatroom.without.openim";; ((c.a)localObject).zZK = "@all.contact.without.chatroom.without.openim.without.openimfavour")
    {
      if ((this.scene == 6) || (this.scene == 5)) {
        ((c.a)localObject).zZK = "@all.contact.without.chatroom.without.openim.without.openimfavour";
      }
      if (getIntent().getBooleanExtra("KBlockOpenImFav", false)) {
        ((c.a)localObject).zZK = "@all.contact.without.chatroom.without.openim.without.openimfavour";
      }
      List localList = this.ejc;
      boolean bool3 = t.hI(this.AeD, 1);
      boolean bool4 = t.hI(this.AeD, 64);
      bool1 = bool2;
      if (this.Aau == 15) {
        bool1 = true;
      }
      localObject = new c(this, localList, bool3, bool4, (c.a)localObject, bool1);
      AppMethodBeat.o(33877);
      return localObject;
      bool1 = false;
      break;
      bool1 = false;
      break label77;
    }
  }
  
  protected final n ape()
  {
    AppMethodBeat.i(33878);
    if (this.Afd)
    {
      localObject = new s(this, this.ejc, t.hI(this.AeD, 64), this.Afe);
      AppMethodBeat.o(33878);
      return localObject;
    }
    Object localObject = new r(this, this.ejc, t.hI(this.AeD, 64), this.scene);
    AppMethodBeat.o(33878);
    return localObject;
  }
  
  public final boolean b(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(33891);
    if ((parama.Adl) && (parama.contact != null))
    {
      boolean bool = this.AeB.contains(parama.contact.field_username);
      AppMethodBeat.o(33891);
      return bool;
    }
    AppMethodBeat.o(33891);
    return false;
  }
  
  public final int[] bOp()
  {
    AppMethodBeat.i(33892);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(131072));
    if (!getIntent().getBooleanExtra("without_openim", false)) {
      localArrayList.add(Integer.valueOf(131081));
    }
    if (!t.hI(this.AeD, 1)) {
      localArrayList.add(Integer.valueOf(131076));
    }
    if (!t.hI(this.AeD, 4)) {
      localArrayList.add(Integer.valueOf(131075));
    }
    int[] arrayOfInt = new int[localArrayList.size()];
    int i = 0;
    while (i < localArrayList.size())
    {
      arrayOfInt[i] = ((Integer)localArrayList.get(i)).intValue();
      i += 1;
    }
    AppMethodBeat.o(33892);
    return arrayOfInt;
  }
  
  protected final boolean bPC()
  {
    return !this.Afd;
  }
  
  public final void mL(int paramInt)
  {
    AppMethodBeat.i(33875);
    int i = paramInt - getContentLV().getHeaderViewsCount();
    if (i < 0)
    {
      ab.i("MicroMsg.SelectContactUI", "offsetPosition is Smaller than 0, offsetPosition=%d | position=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
      AppMethodBeat.o(33875);
      return;
    }
    Object localObject = dLW().Qt(i);
    if (localObject == null)
    {
      AppMethodBeat.o(33875);
      return;
    }
    if ((localObject instanceof com.tencent.mm.ui.contact.a.k))
    {
      if (t.hI(this.AeD, 16384))
      {
        ab.i("MicroMsg.SelectContactUI", "handleClickNonSelect, return the result");
        localObject = new Intent();
        ((Intent)localObject).putExtra("Select_Contact", "");
        ((Intent)localObject).putExtra("Select_Conv_User", "");
        ((Intent)localObject).putExtra("Select_Contact", "");
        setResult(-1, (Intent)localObject);
        finish();
      }
      AppMethodBeat.o(33875);
      return;
    }
    if (((com.tencent.mm.ui.contact.a.a)localObject).contact == null)
    {
      AppMethodBeat.o(33875);
      return;
    }
    if (((com.tencent.mm.ui.contact.a.a)localObject).contact.field_deleteFlag == 1)
    {
      AppMethodBeat.o(33875);
      return;
    }
    localObject = ((com.tencent.mm.ui.contact.a.a)localObject).contact.field_username;
    ab.i("MicroMsg.SelectContactUI", "ClickUser=%s", new Object[] { localObject });
    if (t.hI(this.AeD, 64))
    {
      if ((t.hI(this.AeD, 131072)) && (this.gpQ.size() >= getIntent().getIntExtra("max_limit_num", 2147483647))) {
        if (!this.AeB.contains(localObject))
        {
          dMc();
          if (!this.gpQ.contains(localObject)) {
            break label331;
          }
          this.oCs.ama((String)localObject);
          this.gpQ.remove(localObject);
        }
      }
      for (;;)
      {
        Km();
        dMj();
        dLX().notifyDataSetChanged();
        AppMethodBeat.o(33875);
        return;
        label331:
        String str = getIntent().getStringExtra("too_many_member_tip_string");
        localObject = str;
        if (bo.isNullOrNil(str)) {
          localObject = getString(2131303050, new Object[] { Integer.valueOf(getIntent().getIntExtra("max_limit_num", 10)) });
        }
        com.tencent.mm.ui.base.h.a(getContext(), (String)localObject, getString(2131297056), new SelectContactUI.7(this));
        continue;
        auC((String)localObject);
      }
    }
    fy(bo.P(new String[] { localObject }));
    AppMethodBeat.o(33875);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(33897);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.requestCode = paramInt1;
    ab.i("MicroMsg.SelectContactUI", "requestCode=%d | resultCode=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(33897);
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(33897);
      return;
      paramIntent = paramIntent.getStringExtra("Select_Conv_User");
      if (!bo.isNullOrNil(paramIntent))
      {
        fy(bo.P(new String[] { paramIntent }));
        AppMethodBeat.o(33897);
        return;
        paramIntent = paramIntent.getStringExtra("Select_Conv_User");
        Object localObject1 = this.gpQ.iterator();
        String str1;
        while (((Iterator)localObject1).hasNext())
        {
          str1 = (String)((Iterator)localObject1).next();
          this.oCs.amb(str1);
        }
        this.gpQ.clear();
        if (!bo.isNullOrNil(paramIntent)) {
          this.gpQ.addAll(bo.P(paramIntent.split(",")));
        }
        paramIntent = this.gpQ.iterator();
        while (paramIntent.hasNext())
        {
          localObject1 = (String)paramIntent.next();
          this.oCs.amc((String)localObject1);
        }
        Km();
        AppMethodBeat.o(33897);
        return;
        paramIntent = paramIntent.getStringExtra("Select_Contact");
        if (!bo.isNullOrNil(paramIntent))
        {
          fy(bo.P(paramIntent.split(",")));
          AppMethodBeat.o(33897);
          return;
          if (paramIntent != null)
          {
            paramIntent = paramIntent.getStringExtra("Select_Contact");
            if (!bo.isNullOrNil(paramIntent)) {
              fy(bo.P(new String[] { paramIntent }));
            }
            AppMethodBeat.o(33897);
            return;
            paramIntent = paramIntent.getStringExtra("Select_Contact");
            if (bo.isNullOrNil(paramIntent))
            {
              ab.i("MicroMsg.SelectContactUI", "GET_LABEL_USERS return usernames is null or empty");
              AppMethodBeat.o(33897);
              return;
            }
            ab.i("MicroMsg.SelectContactUI", "GET_LABEL_USERS select username=%s", new Object[] { paramIntent });
            if (t.hI(this.AeD, 64))
            {
              paramIntent = paramIntent.split(",");
              paramInt2 = paramIntent.length;
              paramInt1 = 0;
              while (paramInt1 < paramInt2)
              {
                localObject1 = paramIntent[paramInt1];
                if (this.gpQ.add(localObject1)) {
                  this.oCs.ama((String)localObject1);
                }
                paramInt1 += 1;
              }
              Km();
              dLW().notifyDataSetChanged();
              AppMethodBeat.o(33897);
              return;
            }
            fy(bo.P(new String[] { paramIntent }));
            AppMethodBeat.o(33897);
            return;
            if (paramIntent != null)
            {
              str1 = paramIntent.getStringExtra("Select_Contact");
              localObject1 = paramIntent.getStringExtra("Cancel_Select_Contact");
              if (bo.isNullOrNil(str1))
              {
                paramIntent = null;
                if (!bo.isNullOrNil((String)localObject1)) {
                  break label626;
                }
                localObject1 = null;
              }
              label549:
              Object localObject2;
              for (;;)
              {
                if (paramIntent != null)
                {
                  if (this.oCs != null)
                  {
                    localObject2 = paramIntent.iterator();
                    for (;;)
                    {
                      if (((Iterator)localObject2).hasNext())
                      {
                        String str2 = (String)((Iterator)localObject2).next();
                        if (!this.gpQ.contains(str2))
                        {
                          this.oCs.ama(str2);
                          continue;
                          paramIntent = bo.ih(str1, ",");
                          break;
                          label626:
                          localObject1 = bo.ih((String)localObject1, ",");
                          break label549;
                        }
                      }
                    }
                  }
                  this.gpQ.addAll(paramIntent);
                }
              }
              if (localObject1 != null)
              {
                if (this.oCs != null)
                {
                  paramIntent = ((List)localObject1).iterator();
                  while (paramIntent.hasNext())
                  {
                    localObject2 = (String)paramIntent.next();
                    this.oCs.ama((String)localObject2);
                  }
                }
                this.gpQ.removeAll((Collection)localObject1);
              }
              dLW().notifyDataSetChanged();
              if (getIntent().getBooleanExtra("Add_SendCard", false)) {
                fy(bo.P(new String[] { str1 }));
              }
            }
            Km();
          }
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(33873);
    super.onCreate(paramBundle);
    aw.Rc().a(30, this);
    aw.Rc().a(138, this);
    ab.i("MicroMsg.SelectContactUI", "create!");
    if (!bo.isNullOrNil(this.jjP)) {
      setMMSubTitle(this.jjP);
    }
    if (t.hI(this.AeD, 64)) {
      addTextOptionMenu(1, getString(2131297018), new SelectContactUI.2(this), null, q.b.zby);
    }
    Km();
    setBackBtn(new SelectContactUI.1(this));
    if (this.Aau != 15) {
      this.oCs.g(this.gpQ);
    }
    AppMethodBeat.o(33873);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(33874);
    aw.Rc().b(30, this);
    aw.Rc().b(138, this);
    super.onDestroy();
    AppMethodBeat.o(33874);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(33889);
    if (this.eeN != null)
    {
      this.eeN.dismiss();
      this.eeN = null;
    }
    if (!bo.cB(this))
    {
      AppMethodBeat.o(33889);
      return;
    }
    if (v.a.a(this, paramInt1, paramInt2, paramString, 4))
    {
      AppMethodBeat.o(33889);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      if ((paramInt1 == 4) && (paramInt2 == -24) && (!bo.isNullOrNil(paramString))) {
        Toast.makeText(this, paramString, 1).show();
      }
      AppMethodBeat.o(33889);
      return;
    }
    switch (paramm.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(33889);
      return;
      dLW().notifyDataSetChanged();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void wK(String paramString)
  {
    AppMethodBeat.i(33893);
    this.gpQ.remove(paramString);
    dLW().notifyDataSetChanged();
    Km();
    AppMethodBeat.o(33893);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SelectContactUI
 * JD-Core Version:    0.7.0.1
 */