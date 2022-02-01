package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.br.d;
import com.tencent.mm.g.c.av;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.m.e;
import com.tencent.mm.model.az;
import com.tencent.mm.openim.a.b.a;
import com.tencent.mm.pluginsdk.g.j;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.pluginsdk.ui.applet.aa.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.contact.a.k;
import com.tencent.mm.ui.s.b;
import com.tencent.mm.ui.y.a;
import com.tencent.mm.ui.z;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SelectContactUI
  extends MMBaseSelectContactUI
  implements com.tencent.mm.ak.g
{
  private int IsT;
  private TextView IyA;
  private List<String> IyB;
  private Map<String, Integer> IyC;
  private boolean IyD;
  private boolean IyE;
  private String IyF;
  private String IyG;
  private boolean IyH;
  private boolean IyI;
  private boolean IyJ;
  private boolean IyK;
  private String IyL;
  private b IyM;
  private boolean IyN;
  private int Iyl;
  private boolean Iym;
  private a Iyn;
  private TextView Iyv;
  private TextView Iyw;
  private TextView Iyx;
  private TextView Iyy;
  private TextView Iyz;
  private ProgressDialog fts;
  private List<String> fzw;
  private String mBH;
  private int requestCode;
  private String tTY;
  private String title;
  private List<String> uFm;
  
  public SelectContactUI()
  {
    AppMethodBeat.i(37994);
    this.IyC = new HashMap();
    this.Iym = true;
    this.IyK = false;
    this.IyM = new b(this, (byte)0);
    this.IyN = false;
    this.Iyn = new a();
    AppMethodBeat.o(37994);
  }
  
  private static List<String> Q(List<String> paramList)
  {
    AppMethodBeat.i(38020);
    LinkedList localLinkedList = new LinkedList();
    if (!az.agM())
    {
      AppMethodBeat.o(38020);
      return localLinkedList;
    }
    if (paramList == null)
    {
      AppMethodBeat.o(38020);
      return localLinkedList;
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      az.ayM();
      ai localai = com.tencent.mm.model.c.awB().aNt(str);
      paramList = str;
      if (localai != null)
      {
        paramList = str;
        if ((int)localai.fLJ != 0) {
          paramList = localai.aaS();
        }
      }
      localLinkedList.add(paramList);
    }
    AppMethodBeat.o(38020);
    return localLinkedList;
  }
  
  private void WT()
  {
    AppMethodBeat.i(38006);
    if ((u.hasAttr(this.Iyl, 64)) && (this.uFm.size() > 0))
    {
      updateOptionMenuText(1, getString(2131755835) + "(" + this.uFm.size() + ")");
      int i = getIntent().getIntExtra("min_limit_num", 0);
      if ((u.hasAttr(this.Iyl, 262144)) && (this.uFm.size() < i))
      {
        enableOptionMenu(1, false);
        AppMethodBeat.o(38006);
        return;
      }
      enableOptionMenu(1, true);
      AppMethodBeat.o(38006);
      return;
    }
    updateOptionMenuText(1, getString(2131755835));
    enableOptionMenu(1, false);
    AppMethodBeat.o(38006);
  }
  
  private TextView a(ListView paramListView, View.OnClickListener paramOnClickListener, String paramString)
  {
    AppMethodBeat.i(38003);
    View localView = z.jD(this).inflate(2131494420, null);
    localView.setOnClickListener(paramOnClickListener);
    paramOnClickListener = (TextView)localView.findViewById(2131298778);
    paramOnClickListener.setText(paramString);
    paramListView.addHeaderView(localView);
    AppMethodBeat.o(38003);
    return paramOnClickListener;
  }
  
  private void a(final com.tencent.mm.roomsdk.a.c.a parama)
  {
    AppMethodBeat.i(38011);
    parama.d(new com.tencent.mm.roomsdk.a.b.c() {});
    getString(2131755906);
    parama.a(this, getString(2131760674), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(37975);
        SelectContactUI.d(SelectContactUI.this, false);
        parama.cancel();
        AppMethodBeat.o(37975);
      }
    });
    abT(2);
    AppMethodBeat.o(38011);
  }
  
  private void aQZ(String paramString)
  {
    AppMethodBeat.i(38018);
    if (this.IyB.contains(paramString))
    {
      AppMethodBeat.o(38018);
      return;
    }
    int i;
    if (this.uFm.contains(paramString))
    {
      this.uFm.remove(paramString);
      i = 1;
      if (getIntent().getBooleanExtra("create_group_recommend", false))
      {
        if (frq() == frr()) {
          break label311;
        }
        ((c)frr()).ItL.reset();
        frr().WN();
        this.Iws.cen();
        hideVKB();
      }
      label108:
      if (!(frq() instanceof v)) {
        break label339;
      }
      String str = ((v)frq()).frp();
      if (this.uFo != null) {
        this.uFo.getInputText().setText(str);
      }
    }
    for (;;)
    {
      this.uFo.aGU(paramString);
      AppMethodBeat.o(38018);
      return;
      this.uFm.add(paramString);
      if ((frq() instanceof v))
      {
        if (((v)frq()).frF())
        {
          this.IyC.put(paramString, Integer.valueOf(((v)frq()).aQW(paramString)));
          i = 0;
          break;
        }
        this.IyC.put(paramString, Integer.valueOf(1));
        i = 0;
        break;
      }
      if (frq() == frr())
      {
        if (((c)frr()).aQQ(paramString))
        {
          this.IyC.put(paramString, Integer.valueOf(2));
          i = 0;
          break;
        }
        this.IyC.put(paramString, Integer.valueOf(0));
      }
      i = 0;
      break;
      label311:
      if ((i == 0) && (!((c)frr()).aQQ(paramString))) {
        break label108;
      }
      frr().WN();
      break label108;
      label339:
      frx();
    }
  }
  
  private void abT(int paramInt)
  {
    AppMethodBeat.i(38012);
    if (this.IyN)
    {
      AppMethodBeat.o(38012);
      return;
    }
    this.IyN = true;
    if (getIntent().getBooleanExtra("create_group_recommend", false))
    {
      int i;
      int k;
      int m;
      int n;
      int i1;
      int j;
      switch (this.scene)
      {
      case 4: 
      case 5: 
      case 6: 
      default: 
        i = 0;
        k = 0;
        m = 0;
        n = 0;
        i1 = 0;
        localObject = this.uFm.iterator();
        j = 0;
        label107:
        if (!((Iterator)localObject).hasNext()) {
          break label257;
        }
        String str = (String)((Iterator)localObject).next();
        if (this.IyC.containsKey(str)) {
          switch (((Integer)this.IyC.get(str)).intValue())
          {
          }
        }
        break;
      }
      for (;;)
      {
        break label107;
        i = 1;
        break;
        i = 2;
        break;
        i = 3;
        break;
        k += 1;
        break label107;
        n += 1;
        break label107;
        m += 1;
        break label107;
        i1 += 1;
        break label107;
        j += 1;
      }
      label257:
      ac.d("MicroMsg.SelectContactUI", "report_17535, scene:%d, SelectCount:%d, SearchCount:%d, RecommendCount:%d, RecommendGroupCount:%d, ExitType:%d, TokenSearchCount:%d, TokenRecommendCount:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(frq().fqU()), Integer.valueOf(paramInt), Integer.valueOf(i1), Integer.valueOf(j) });
      com.tencent.mm.plugin.report.service.h.wUl.f(17535, new Object[] { Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(frq().fqU()), Integer.valueOf(paramInt), Integer.valueOf(i1), Integer.valueOf(j) });
      Object localObject = new LinkedList();
      ((List)localObject).addAll(this.IyB);
      ((List)localObject).addAll(this.uFm);
      w.io((List)localObject);
    }
    AppMethodBeat.o(38012);
  }
  
  private void frH()
  {
    int j = 0;
    AppMethodBeat.i(37999);
    if ((this.Iym) && ((this.IsT == 1) || (this.IsT == 0))) {
      if (this.IyB == null) {
        break label96;
      }
    }
    label96:
    for (int i = this.IyB.size();; i = 0)
    {
      if (this.uFm != null) {
        j = this.uFm.size();
      }
      int k = bs.aLy(com.tencent.mm.m.g.ZY().getValue("ChatRoomInviteStartCount"));
      this.Iyn.e(this, i + j, k);
      AppMethodBeat.o(37999);
      return;
    }
  }
  
  private void frI()
  {
    AppMethodBeat.i(38009);
    ArrayList localArrayList = xB(true);
    localArrayList.remove(com.tencent.mm.model.u.axw());
    if (localArrayList.size() > 0)
    {
      this.fts = com.tencent.mm.ui.base.h.b(getContext(), getString(2131761075), false, null);
      az.agU().az(new c(this, localArrayList, (byte)0));
    }
    AppMethodBeat.o(38009);
  }
  
  private void frJ()
  {
    AppMethodBeat.i(38010);
    Object localObject = xB(false);
    ((ArrayList)localObject).remove(com.tencent.mm.model.u.axw());
    final String str = bs.n((List)localObject, ",");
    if (!bs.gY((List)localObject))
    {
      com.tencent.mm.ui.base.h.a(getContext(), true, getString(2131760621), "", getString(2131760620), getString(2131760619), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(37972);
          ac.i("MicroMsg.SelectContactUI", "return the result,and create new label");
          paramAnonymousDialogInterface = new Intent();
          paramAnonymousDialogInterface.putExtra("Select_Contact", str);
          paramAnonymousDialogInterface.putExtra("Select_Conv_User", str);
          paramAnonymousDialogInterface.putExtra("Select_Contact", str);
          paramAnonymousDialogInterface.putExtra("Select_Contacts_To_Create_New_Label", str);
          SelectContactUI.this.setResult(-1, paramAnonymousDialogInterface);
          SelectContactUI.this.finish();
          AppMethodBeat.o(37972);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(37973);
          ac.i("MicroMsg.SelectContactUI", "return the result");
          paramAnonymousDialogInterface = new Intent();
          paramAnonymousDialogInterface.putExtra("Select_Contact", str);
          paramAnonymousDialogInterface.putExtra("Select_Conv_User", str);
          paramAnonymousDialogInterface.putExtra("Select_Contact", str);
          SelectContactUI.this.setResult(-1, paramAnonymousDialogInterface);
          SelectContactUI.this.finish();
          AppMethodBeat.o(37973);
        }
      });
      AppMethodBeat.o(38010);
      return;
    }
    localObject = new Intent();
    ((Intent)localObject).putExtra("Select_Contact", str);
    ((Intent)localObject).putExtra("Select_Conv_User", str);
    ((Intent)localObject).putExtra("Select_Contact", str);
    ((Intent)localObject).putExtra("Select_Contacts_To_Create_New_Label", str);
    setResult(0, (Intent)localObject);
    finish();
    AppMethodBeat.o(38010);
  }
  
  private boolean ip(final List<String> paramList)
  {
    AppMethodBeat.i(38004);
    ac.i("MicroMsg.SelectContactUI", "handleSelect %s", new Object[] { paramList });
    if (u.hasAttr(this.Iyl, 65536))
    {
      String str = ir(paramList);
      this.IyJ = true;
      com.tencent.mm.ui.base.h.a(getContext(), str, null, true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(37984);
          SelectContactUI.b(SelectContactUI.this, SelectContactUI.a(SelectContactUI.this, paramList));
          AppMethodBeat.o(37984);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(37985);
          SelectContactUI.b(SelectContactUI.this, false);
          AppMethodBeat.o(37985);
        }
      });
      bool = this.IyJ;
      AppMethodBeat.o(38004);
      return bool;
    }
    boolean bool = iq(paramList);
    AppMethodBeat.o(38004);
    return bool;
  }
  
  private boolean iq(List<String> paramList)
  {
    boolean bool = false;
    AppMethodBeat.i(38005);
    if (getIntent().getBooleanExtra("Add_SendCard", false))
    {
      if (bs.isNullOrNil(this.IyF)) {
        this.IyF = bs.n(paramList, ",");
      }
      for (;;)
      {
        bool = com.tencent.mm.model.w.sQ(this.IyG);
        paramList = new Intent();
        paramList.putExtra("be_send_card_name", this.IyF);
        paramList.putExtra("received_card_name", this.IyG);
        paramList.putExtra("Is_Chatroom", bool);
        setResult(-1, paramList);
        finish();
        AppMethodBeat.o(38005);
        return true;
        if (!bs.isNullOrNil(this.IyG)) {
          break;
        }
        this.IyG = bs.n(paramList, ",");
      }
      ac.e("MicroMsg.SelectContactUI", "send card occur error: send:%s | receive:%s", new Object[] { this.IyF, this.IyG });
      AppMethodBeat.o(38005);
      return false;
    }
    Object localObject;
    int i;
    if (getIntent().getBooleanExtra("snsPostWhoCanSee", false))
    {
      ac.i("MicroMsg.SelectContactUI", "sns post who can see scene,users=%s", new Object[] { paramList.toString() });
      localObject = xB(false);
      ((ArrayList)localObject).remove(com.tencent.mm.model.u.axw());
      paramList = paramList.iterator();
      for (i = 0; paramList.hasNext(); i = 1)
      {
        label228:
        String str = (String)paramList.next();
        if (bs.isNullOrNil(str)) {
          break label730;
        }
        if ((((ArrayList)localObject).contains(str)) || (com.tencent.mm.model.u.axw().equals(str))) {
          break label228;
        }
        az.ayM();
        ai localai = com.tencent.mm.model.c.awB().aNt(str);
        if ((localai == null) || ((int)localai.fLJ == 0) || (!com.tencent.mm.n.b.ln(localai.field_type))) {
          break label730;
        }
        aQZ(str);
        ((ArrayList)localObject).add(str);
      }
    }
    label730:
    for (;;)
    {
      break label228;
      if (i != 0)
      {
        WT();
        frq().notifyDataSetChanged();
        break;
      }
      frJ();
      break;
      if (getIntent().getBooleanExtra("recommend_friends", false))
      {
        ac.i("MicroMsg.SelectContactUI", "Recommend Friends");
        ad.a(getContext(), this.IyG, paramList);
        break;
      }
      if (u.hasAttr(this.Iyl, 16384))
      {
        ac.i("MicroMsg.SelectContactUI", "return the result");
        localObject = new Intent();
        paramList = bs.n(paramList, ",");
        ((Intent)localObject).putExtra("Select_Contact", paramList);
        ((Intent)localObject).putExtra("Select_Conv_User", paramList);
        ((Intent)localObject).putExtra("Select_Contact", paramList);
        ((Intent)localObject).putExtra("label_source", this.tTY);
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
        ac.i("MicroMsg.SelectContactUI", "Share Image");
        frI();
        break;
      }
      if (paramList.size() > 0)
      {
        ac.i("MicroMsg.SelectContactUI", "Launch ChattingUI: users=%s", new Object[] { paramList.toString() });
        finish();
        localObject = new Intent();
        ((Intent)localObject).setClass(this, ChattingUI.class);
        ((Intent)localObject).putExtra("Chat_User", (String)paramList.get(0));
        ((Intent)localObject).addFlags(67108864);
        paramList = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramList.aeD(), "com/tencent/mm/ui/contact/SelectContactUI", "dohandleSelect", "(Ljava/util/List;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramList.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/SelectContactUI", "dohandleSelect", "(Ljava/util/List;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        abT(3);
        break;
      }
      ac.e("MicroMsg.SelectContactUI", "unkown action: User=%s", new Object[] { paramList.toString() });
      break;
    }
  }
  
  private String ir(List<String> paramList)
  {
    AppMethodBeat.i(38019);
    StringBuilder localStringBuilder = null;
    Object localObject = localStringBuilder;
    if (paramList != null)
    {
      if (paramList.size() != 1) {
        break label62;
      }
      localObject = getString(2131762980, new Object[] { com.tencent.mm.model.v.wk((String)paramList.get(0)) });
    }
    label62:
    do
    {
      AppMethodBeat.o(38019);
      return localObject;
      localObject = localStringBuilder;
    } while (paramList.size() <= 1);
    localObject = getString(2131755888);
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
        localObject = getString(2131762980, new Object[] { localStringBuilder.toString() });
        break;
      }
      localStringBuilder.append(com.tencent.mm.model.v.wk((String)paramList.get(i)));
      if (i < paramList.size() - 1) {
        localStringBuilder.append((String)localObject);
      }
      i += 1;
    }
  }
  
  private ArrayList<String> xB(boolean paramBoolean)
  {
    AppMethodBeat.i(38007);
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.uFm.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      if ((!paramBoolean) && (com.tencent.mm.model.w.wE((String)localObject)))
      {
        localObject = com.tencent.mm.model.q.wa((String)localObject);
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
    AppMethodBeat.o(38007);
    return localArrayList;
  }
  
  private ArrayList<String> xC(boolean paramBoolean)
  {
    AppMethodBeat.i(38008);
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.uFm.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      if ((!paramBoolean) && (com.tencent.mm.model.w.wE((String)localObject)))
      {
        localObject = com.tencent.mm.model.q.wa((String)localObject);
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
    localHashSet.addAll(this.IyB);
    localArrayList.addAll(localHashSet);
    AppMethodBeat.o(38008);
    return localArrayList;
  }
  
  public final void O(int paramInt, String paramString)
  {
    AppMethodBeat.i(38017);
    if (paramInt == 1)
    {
      this.uFm.remove(paramString);
      if (!(frq() instanceof v)) {
        break label65;
      }
      paramString = ((v)frq()).frp();
      this.uFo.getInputText().setText(paramString);
    }
    for (;;)
    {
      WT();
      AppMethodBeat.o(38017);
      return;
      label65:
      if ((frq() instanceof c)) {
        frr().WN();
      } else {
        frq().notifyDataSetChanged();
      }
    }
  }
  
  protected final void WJ()
  {
    AppMethodBeat.i(37997);
    super.WJ();
    this.Iyl = getIntent().getIntExtra("list_attr", u.IwO);
    this.title = getIntent().getStringExtra("titile");
    this.mBH = getIntent().getStringExtra("sub_title");
    this.IsT = getIntent().getIntExtra("list_type", -1);
    this.Iym = getIntent().getBooleanExtra("show_too_many_member", true);
    this.tTY = getIntent().getStringExtra("label_source");
    if ((u.hasAttr(this.Iyl, 256)) && (com.tencent.mm.model.w.ayi().size() == 0)) {
      u.jI(this.Iyl, 256);
    }
    this.IyD = getIntent().getBooleanExtra("Add_SendCard", false);
    this.IyE = getIntent().getBooleanExtra("recommend_friends", false);
    if ((this.IyD) || (this.IyE))
    {
      this.IyF = bs.bG(getIntent().getStringExtra("be_send_card_name"), "");
      this.IyG = bs.bG(getIntent().getStringExtra("received_card_name"), "");
    }
    this.IyH = getIntent().getBooleanExtra("Forbid_SelectChatRoom", false);
    this.fzw = new ArrayList();
    this.uFm = new LinkedList();
    this.IyB = new LinkedList();
    Object localObject = getIntent().getStringExtra("always_select_contact");
    if (!bs.isNullOrNil((String)localObject)) {
      this.IyB.addAll(bs.S(((String)localObject).split(",")));
    }
    localObject = getIntent().getStringExtra("already_select_contact");
    if (!bs.isNullOrNil((String)localObject)) {
      this.uFm.addAll(bs.S(((String)localObject).split(",")));
    }
    localObject = new HashSet();
    String str = getIntent().getStringExtra("block_contact");
    if (!bs.isNullOrNil(str)) {
      ((HashSet)localObject).addAll(bs.S(str.split(",")));
    }
    localObject = new HashSet((Collection)localObject);
    ((HashSet)localObject).addAll(u.frC());
    ((HashSet)localObject).addAll(u.frD());
    if (!u.hasAttr(this.Iyl, 268435456)) {
      ((HashSet)localObject).add(com.tencent.mm.model.u.axw());
    }
    if (this.IyD) {
      ((HashSet)localObject).removeAll(u.frC());
    }
    this.fzw.add("gh_3dfda90e39d6");
    this.fzw.addAll((Collection)localObject);
    frH();
    AppMethodBeat.o(37997);
  }
  
  protected final void a(ListView paramListView, int paramInt)
  {
    AppMethodBeat.i(38002);
    super.a(paramListView, paramInt);
    Object localObject;
    final int i;
    int j;
    label328:
    int m;
    final int k;
    if (u.hasAttr(this.Iyl, 256))
    {
      if (this.Iyv == null)
      {
        View.OnClickListener local10 = new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(37977);
            Object localObject = new Intent();
            ((Intent)localObject).setClassName(SelectContactUI.this, "com.tencent.mm.ui.contact.GroupCardSelectUI");
            ((Intent)localObject).putExtra("group_select_type", true);
            boolean bool = u.hasAttr(SelectContactUI.b(SelectContactUI.this), 16384);
            ((Intent)localObject).putExtra("group_select_need_result", bool);
            if (bool)
            {
              if (SelectContactUI.c(SelectContactUI.this) == 14)
              {
                ((Intent)localObject).putExtra("group_multi_select", true);
                ((Intent)localObject).putExtra("already_select_contact", bs.n(SelectContactUI.a(SelectContactUI.this, true), ","));
                ((Intent)localObject).putExtra("max_limit_num", SelectContactUI.this.getIntent().getIntExtra("max_limit_num", 9));
                SelectContactUI.this.startActivityForResult((Intent)localObject, 4);
                AppMethodBeat.o(37977);
                return;
              }
              SelectContactUI.this.startActivityForResult((Intent)localObject, 0);
              AppMethodBeat.o(37977);
              return;
            }
            paramAnonymousView = SelectContactUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/ui/contact/SelectContactUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/ui/contact/SelectContactUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(37977);
          }
        };
        if (this.IsT == 14)
        {
          localObject = getString(2131755225);
          this.Iyv = a(paramListView, local10, (String)localObject);
        }
      }
      else
      {
        this.Iyv.setVisibility(paramInt);
      }
    }
    else
    {
      if (u.hasAttr(this.Iyl, 512))
      {
        if (this.Iyw == null) {
          this.Iyw = a(paramListView, new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(37978);
              com.tencent.mm.plugin.report.service.h.wUl.f(11140, new Object[] { Integer.valueOf(0) });
              d.N(SelectContactUI.this, "pwdgroup", ".ui.FacingCreateChatRoomAllInOneUI");
              AppMethodBeat.o(37978);
            }
          }, getString(2131759100));
        }
        this.Iyw.setVisibility(paramInt);
      }
      if (u.hasAttr(this.Iyl, 1024))
      {
        if (this.Iyx == null) {
          this.Iyx = a(paramListView, new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(37979);
              paramAnonymousView = new Intent();
              paramAnonymousView.setClassName(SelectContactUI.this, "com.tencent.mm.ui.contact.GroupCardSelectUI");
              paramAnonymousView.putExtra("group_select_type", false);
              SelectContactUI.this.startActivityForResult(paramAnonymousView, 1);
              AppMethodBeat.o(37979);
            }
          }, getString(2131755205));
        }
        this.Iyx.setVisibility(paramInt);
      }
      if (u.hasAttr(this.Iyl, 2048))
      {
        if (this.Iyz == null) {
          this.Iyz = a(paramListView, new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(37980);
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("list_attr", 16384);
              d.b(SelectContactUI.this, "brandservice", ".ui.BrandServiceIndexUI", paramAnonymousView, 2);
              AppMethodBeat.o(37980);
            }
          }, getString(2131755219));
        }
        this.Iyz.setVisibility(paramInt);
        this.Iyz.setTextSize(16.0F * com.tencent.mm.cc.a.eb(this.Iyz.getContext()));
      }
      if (u.hasAttr(this.Iyl, 524288)) {
        if (this.Iyy == null)
        {
          localObject = "";
          i = getIntent().getIntExtra("topstory_import_type", 0);
          j = 2131755209;
          if (i != 1) {
            break label636;
          }
          localObject = com.tencent.mm.plugin.sns.b.o.xMd.wU(5L);
          if (!bs.gY((List)localObject)) {
            break label625;
          }
          i = 0;
          localObject = bs.n((List)localObject, ",");
          j = 2131755209;
          m = 2131755210;
          k = i;
          i = m;
        }
      }
    }
    for (;;)
    {
      this.Iyy = a(paramListView, new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(37982);
          com.tencent.mm.ui.base.h.d(SelectContactUI.this, SelectContactUI.this.getString(i, new Object[] { Integer.valueOf(k) }), "", SelectContactUI.this.getString(2131755206), SelectContactUI.this.getString(2131755691), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(37981);
              paramAnonymous2DialogInterface = new Intent();
              paramAnonymous2DialogInterface.putExtra("Select_Contact", SelectContactUI.14.this.IyU);
              paramAnonymous2DialogInterface.putExtra("App_MsgId", "fromSns");
              SelectContactUI.this.setResult(-1, paramAnonymous2DialogInterface);
              SelectContactUI.this.finish();
              AppMethodBeat.o(37981);
            }
          }, null);
          AppMethodBeat.o(37982);
        }
      }, getString(j));
      this.Iyy.setTag(Integer.valueOf(k));
      localObject = this.Iyy.getTag();
      if ((!(localObject instanceof Integer)) || (((Integer)localObject).intValue() <= 0)) {
        this.Iyy.setVisibility(8);
      }
      for (;;)
      {
        if (u.hasAttr(this.Iyl, 16777216))
        {
          if (this.IyA == null)
          {
            az.ayM();
            localObject = com.tencent.mm.model.c.awB().fap();
            ac.i("MicroMsg.SelectContactUI", "setOpenIMHeaderView %s", new Object[] { Integer.valueOf(((List)localObject).size()) });
            if (((List)localObject).size() != 0)
            {
              this.IyA = a(paramListView, new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(37983);
                  paramAnonymousView = new Intent(SelectContactUI.this.getIntent());
                  paramAnonymousView.setClass(SelectContactUI.this.getContext(), OpenIMSelectContactUI.class);
                  paramAnonymousView.removeExtra("titile");
                  paramAnonymousView.putExtra("openim_appid", "3552365301");
                  ArrayList localArrayList = new ArrayList();
                  Iterator localIterator = SelectContactUI.d(SelectContactUI.this).iterator();
                  while (localIterator.hasNext())
                  {
                    String str = (String)localIterator.next();
                    if (ai.aNc(str)) {
                      localArrayList.add(str);
                    }
                  }
                  paramAnonymousView.putExtra("already_select_contact", bs.n(localArrayList, ","));
                  SelectContactUI.this.startActivityForResult(paramAnonymousView, 5);
                  AppMethodBeat.o(37983);
                }
              }, "");
              paramListView = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).a("3552365301", "openim_acct_type_title", b.a.inW);
              this.IyA.setVisibility(paramInt);
              this.IyA.setText(paramListView);
            }
          }
          if (this.IyA != null) {
            this.IyA.setVisibility(paramInt);
          }
        }
        if ((!u.hasAttr(this.Iyl, 16777216)) || (this.IyA == null)) {
          break label707;
        }
        this.IyA.setBackgroundResource(2131231820);
        AppMethodBeat.o(38002);
        return;
        localObject = getString(2131755204);
        break;
        label625:
        i = ((List)localObject).size();
        break label328;
        label636:
        if (i != 2) {
          break label855;
        }
        localObject = j.fdk();
        if (bs.gY((List)localObject)) {}
        for (i = 0;; i = ((List)localObject).size())
        {
          localObject = bs.n((List)localObject, ",");
          j = 2131755207;
          m = 2131755208;
          k = i;
          i = m;
          break;
        }
        this.Iyy.setVisibility(paramInt);
      }
      label707:
      if (u.hasAttr(this.Iyl, 2048))
      {
        if (this.Iyz != null)
        {
          this.Iyz.setBackgroundResource(2131231820);
          AppMethodBeat.o(38002);
        }
      }
      else if (u.hasAttr(this.Iyl, 1024))
      {
        if (this.Iyx != null)
        {
          this.Iyx.setBackgroundResource(2131231820);
          AppMethodBeat.o(38002);
        }
      }
      else if (u.hasAttr(this.Iyl, 512))
      {
        if (this.Iyw != null)
        {
          this.Iyw.setBackgroundResource(2131231820);
          AppMethodBeat.o(38002);
        }
      }
      else if ((u.hasAttr(this.Iyl, 256)) && (this.Iyv != null)) {
        this.Iyv.setBackgroundResource(2131231820);
      }
      AppMethodBeat.o(38002);
      return;
      label855:
      i = 2131755210;
      k = 0;
    }
  }
  
  public final boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(38014);
    boolean bool;
    if ((parama.Iwh) && (parama.contact != null))
    {
      bool = this.uFm.contains(parama.contact.field_username);
      AppMethodBeat.o(38014);
      return bool;
    }
    if ((parama.Iwi) && (parama.contact != null))
    {
      bool = this.uFm.contains(parama.contact.field_username);
      AppMethodBeat.o(38014);
      return bool;
    }
    if ((parama instanceof k))
    {
      bool = this.uFm.isEmpty();
      AppMethodBeat.o(38014);
      return bool;
    }
    AppMethodBeat.o(38014);
    return false;
  }
  
  protected final boolean aOi()
  {
    return false;
  }
  
  protected final boolean aOj()
  {
    return true;
  }
  
  protected final String aOk()
  {
    return this.title;
  }
  
  protected final q aOl()
  {
    boolean bool2 = false;
    AppMethodBeat.i(38000);
    Object localObject = new c.a();
    ((c.a)localObject).ItP = u.hasAttr(this.Iyl, 16);
    ((c.a)localObject).ItO = u.hasAttr(this.Iyl, 32);
    ((c.a)localObject).ItS = getIntent().getBooleanExtra("create_group_recommend", false);
    boolean bool1;
    if (!u.hasAttr(this.Iyl, 4))
    {
      bool1 = true;
      ((c.a)localObject).ItQ = bool1;
      if (u.hasAttr(this.Iyl, 1)) {
        break label367;
      }
      bool1 = true;
      label93:
      ((c.a)localObject).ItR = bool1;
      ((c.a)localObject).ItT = u.hasAttr(this.Iyl, 128);
      ((c.a)localObject).ItU = u.hasAttr(this.Iyl, 1048576);
      ((c.a)localObject).ItX = u.hasAttr(this.Iyl, 256);
      if (((c.a)localObject).ItX) {
        ((c.a)localObject).ItY = getIntent().getStringExtra("custom_contact");
      }
      if (((c.a)localObject).ItT)
      {
        this.IyK = true;
        ((c.a)localObject).ItV = getIntent().getStringExtra("wechat_sport_contact");
        ((c.a)localObject).ItW = getIntent().getStringExtra("wechat_sport_recent_like");
        this.IyL = ((c.a)localObject).ItV;
      }
      if (!u.frE()) {
        break label372;
      }
    }
    label367:
    label372:
    for (((c.a)localObject).Isk = "@all.contact.without.chatroom.without.openim";; ((c.a)localObject).Isk = "@all.contact.without.chatroom.without.openim.without.openimfavour")
    {
      if ((this.scene == 6) || (this.scene == 5)) {
        ((c.a)localObject).Isk = "@all.contact.without.chatroom.without.openim.without.openimfavour";
      }
      if (getIntent().getBooleanExtra("KBlockOpenImFav", false)) {
        ((c.a)localObject).Isk = "@all.contact.without.chatroom.without.openim.without.openimfavour";
      }
      List localList1 = this.IyB;
      List localList2 = this.uFm;
      List localList3 = this.fzw;
      boolean bool3 = u.hasAttr(this.Iyl, 1);
      boolean bool4 = u.hasAttr(this.Iyl, 64);
      bool1 = bool2;
      if (this.IsT == 15) {
        bool1 = true;
      }
      localObject = new c(this, localList1, localList2, localList3, bool3, bool4, (c.a)localObject, bool1);
      AppMethodBeat.o(38000);
      return localObject;
      bool1 = false;
      break;
      bool1 = false;
      break label93;
    }
  }
  
  protected final o aOm()
  {
    AppMethodBeat.i(38001);
    if (this.IyK)
    {
      localObject = new t(this, this.fzw, u.hasAttr(this.Iyl, 64), this.IyL);
      AppMethodBeat.o(38001);
      return localObject;
    }
    if (getIntent().getBooleanExtra("create_group_recommend", false))
    {
      localObject = new v(this, this.IyB, this.uFm, this.fzw, u.hasAttr(this.Iyl, 64), this.scene);
      AppMethodBeat.o(38001);
      return localObject;
    }
    Object localObject = new s(this, this.fzw, u.hasAttr(this.Iyl, 64), this.scene);
    AppMethodBeat.o(38001);
    return localObject;
  }
  
  protected final void akG(String paramString)
  {
    AppMethodBeat.i(38022);
    com.tencent.mm.plugin.report.service.h.wUl.f(11225, new Object[] { Integer.valueOf(1), Integer.valueOf(0) });
    Intent localIntent = new Intent();
    localIntent.setClassName(this, "com.tencent.mm.ui.contact.SelectLabelContactUI");
    localIntent.putExtra("label", paramString);
    paramString = new HashSet();
    paramString.addAll(xB(u.hasAttr(this.Iyl, 8192)));
    paramString.addAll(this.IyB);
    localIntent.putExtra("always_select_contact", bs.n(new ArrayList(paramString), ","));
    localIntent.putExtra("always_select_contact", bs.n(new ArrayList(paramString), ","));
    if (u.hasAttr(this.Iyl, 64))
    {
      localIntent.putExtra("list_attr", u.I(new int[] { 16384, 64, 131072 }));
      if (this.IsT == 14) {
        localIntent.putExtra("max_limit_num", getIntent().getIntExtra("max_limit_num", 2147483647));
      }
    }
    for (;;)
    {
      startActivityForResult(localIntent, 3);
      AppMethodBeat.o(38022);
      return;
      localIntent.putExtra("list_attr", 16384);
    }
  }
  
  public final boolean b(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(38015);
    if ((parama.Iwh) && (parama.contact != null))
    {
      if (u.hasAttr(this.Iyl, 536870912))
      {
        bool = parama.contact.aaM();
        AppMethodBeat.o(38015);
        return bool;
      }
      boolean bool = this.IyB.contains(parama.contact.field_username);
      AppMethodBeat.o(38015);
      return bool;
    }
    AppMethodBeat.o(38015);
    return false;
  }
  
  public final int[] daw()
  {
    AppMethodBeat.i(38016);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(131072));
    if (!getIntent().getBooleanExtra("without_openim", false)) {
      localArrayList.add(Integer.valueOf(131081));
    }
    if (!u.hasAttr(this.Iyl, 1)) {
      localArrayList.add(Integer.valueOf(131076));
    }
    if (!u.hasAttr(this.Iyl, 4)) {
      localArrayList.add(Integer.valueOf(131075));
    }
    int[] arrayOfInt = new int[localArrayList.size()];
    int i = 0;
    while (i < localArrayList.size())
    {
      arrayOfInt[i] = ((Integer)localArrayList.get(i)).intValue();
      i += 1;
    }
    AppMethodBeat.o(38016);
    return arrayOfInt;
  }
  
  protected final boolean dce()
  {
    return !this.IyK;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(38021);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.requestCode = paramInt1;
    ac.i("MicroMsg.SelectContactUI", "requestCode=%d | resultCode=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(38021);
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(38021);
      return;
      paramIntent = paramIntent.getStringExtra("Select_Conv_User");
      if (!bs.isNullOrNil(paramIntent))
      {
        ip(bs.S(new String[] { paramIntent }));
        AppMethodBeat.o(38021);
        return;
        paramIntent = paramIntent.getStringExtra("Select_Conv_User");
        Object localObject1 = this.uFm.iterator();
        String str1;
        while (((Iterator)localObject1).hasNext())
        {
          str1 = (String)((Iterator)localObject1).next();
          this.uFo.aGV(str1);
        }
        this.uFm.clear();
        if (!bs.isNullOrNil(paramIntent)) {
          this.uFm.addAll(bs.S(paramIntent.split(",")));
        }
        paramIntent = this.uFm.iterator();
        while (paramIntent.hasNext())
        {
          localObject1 = (String)paramIntent.next();
          this.uFo.aGW((String)localObject1);
        }
        WT();
        AppMethodBeat.o(38021);
        return;
        paramIntent = paramIntent.getStringExtra("Select_Contact");
        if (!bs.isNullOrNil(paramIntent))
        {
          ip(bs.S(paramIntent.split(",")));
          AppMethodBeat.o(38021);
          return;
          if (paramIntent != null)
          {
            paramIntent = paramIntent.getStringExtra("Select_Contact");
            if (!bs.isNullOrNil(paramIntent)) {
              ip(bs.S(new String[] { paramIntent }));
            }
            AppMethodBeat.o(38021);
            return;
            paramIntent = paramIntent.getStringExtra("Select_Contact");
            if (bs.isNullOrNil(paramIntent))
            {
              ac.i("MicroMsg.SelectContactUI", "GET_LABEL_USERS return usernames is null or empty");
              AppMethodBeat.o(38021);
              return;
            }
            ac.i("MicroMsg.SelectContactUI", "GET_LABEL_USERS select username=%s", new Object[] { paramIntent });
            if (u.hasAttr(this.Iyl, 64))
            {
              paramIntent = paramIntent.split(",");
              paramInt2 = paramIntent.length;
              paramInt1 = 0;
              while (paramInt1 < paramInt2)
              {
                localObject1 = paramIntent[paramInt1];
                if (this.uFm.add(localObject1)) {
                  this.uFo.aGU((String)localObject1);
                }
                paramInt1 += 1;
              }
              WT();
              frq().notifyDataSetChanged();
              AppMethodBeat.o(38021);
              return;
            }
            ip(bs.S(new String[] { paramIntent }));
            AppMethodBeat.o(38021);
            return;
            if (paramIntent != null)
            {
              str1 = paramIntent.getStringExtra("Select_Contact");
              localObject1 = paramIntent.getStringExtra("Cancel_Select_Contact");
              if (bs.isNullOrNil(str1))
              {
                paramIntent = null;
                if (!bs.isNullOrNil((String)localObject1)) {
                  break label638;
                }
                localObject1 = null;
              }
              label559:
              Object localObject2;
              for (;;)
              {
                if (paramIntent != null)
                {
                  if (this.uFo != null)
                  {
                    localObject2 = paramIntent.iterator();
                    for (;;)
                    {
                      if (((Iterator)localObject2).hasNext())
                      {
                        String str2 = (String)((Iterator)localObject2).next();
                        if (!this.uFm.contains(str2))
                        {
                          this.uFo.aGU(str2);
                          continue;
                          paramIntent = bs.lp(str1, ",");
                          break;
                          label638:
                          localObject1 = bs.lp((String)localObject1, ",");
                          break label559;
                        }
                      }
                    }
                  }
                  this.uFm.addAll(paramIntent);
                }
              }
              if (localObject1 != null)
              {
                if (this.uFo != null)
                {
                  paramIntent = ((List)localObject1).iterator();
                  while (paramIntent.hasNext())
                  {
                    localObject2 = (String)paramIntent.next();
                    this.uFo.aGU((String)localObject2);
                  }
                }
                this.uFm.removeAll((Collection)localObject1);
              }
              frq().notifyDataSetChanged();
              if (getIntent().getBooleanExtra("Add_SendCard", false)) {
                ip(bs.S(new String[] { str1 }));
              }
            }
            WT();
          }
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(37995);
    super.onCreate(paramBundle);
    ac.i("MicroMsg.SelectContactUI", "create!");
    az.agi().a(30, this);
    az.agi().a(138, this);
    if (!bs.isNullOrNil(this.mBH)) {
      setMMSubTitle(this.mBH);
    }
    if (u.hasAttr(this.Iyl, 64)) {
      addTextOptionMenu(1, getString(2131755835), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(37971);
          paramAnonymousMenuItem = SelectContactUI.c(SelectContactUI.this, u.hasAttr(SelectContactUI.b(SelectContactUI.this), 8192));
          paramAnonymousMenuItem.remove(com.tencent.mm.model.u.axw());
          if ((u.hasAttr(SelectContactUI.b(SelectContactUI.this), 4096)) && (paramAnonymousMenuItem.size() > 1)) {}
          for (int i = 1; i != 0; i = 0)
          {
            if (!SelectContactUI.e(SelectContactUI.this))
            {
              SelectContactUI.d(SelectContactUI.this, true);
              SelectContactUI.f(SelectContactUI.this);
            }
            ac.i("MicroMsg.SelectContactUI", "Create the chatroom");
            AppMethodBeat.o(37971);
            return true;
          }
          boolean bool = SelectContactUI.b(SelectContactUI.this, SelectContactUI.a(SelectContactUI.this, u.hasAttr(SelectContactUI.b(SelectContactUI.this), 8192)));
          AppMethodBeat.o(37971);
          return bool;
        }
      }, null, s.b.Hom);
    }
    WT();
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(37970);
        SelectContactUI.this.hideVKB();
        SelectContactUI.this.finish();
        if (!SelectContactUI.this.getIntent().getBooleanExtra("stay_in_wechat", true)) {
          ap.n(SelectContactUI.a(SelectContactUI.this), 80L);
        }
        AppMethodBeat.o(37970);
        return true;
      }
    });
    if ((this.IsT != 15) && (this.uFo != null)) {
      this.uFo.gR(this.uFm);
    }
    int i;
    if (getIntent().getBooleanExtra("create_group_recommend", false)) {
      switch (this.scene)
      {
      case 4: 
      case 5: 
      case 6: 
      default: 
        i = 0;
      }
    }
    for (;;)
    {
      w.IxB = i;
      ac.d("MicroMsg.NewGroupRecommendDetailReporter", "scene:%d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(37995);
      return;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(37996);
    az.agi().b(30, this);
    az.agi().b(138, this);
    abT(1);
    w.reset();
    super.onDestroy();
    AppMethodBeat.o(37996);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(38013);
    if (this.fts != null)
    {
      this.fts.dismiss();
      this.fts = null;
    }
    if (!bs.iX(this))
    {
      AppMethodBeat.o(38013);
      return;
    }
    if (y.a.a(this, paramInt1, paramInt2, paramString, 4))
    {
      AppMethodBeat.o(38013);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      if ((paramInt1 == 4) && (paramInt2 == -24) && (!bs.isNullOrNil(paramString))) {
        Toast.makeText(this, paramString, 1).show();
      }
      AppMethodBeat.o(38013);
      return;
    }
    switch (paramn.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(38013);
      return;
      frq().notifyDataSetChanged();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void qG(int paramInt)
  {
    AppMethodBeat.i(37998);
    int i = paramInt - getContentLV().getHeaderViewsCount();
    if (i < 0)
    {
      ac.i("MicroMsg.SelectContactUI", "offsetPosition is Smaller than 0, offsetPosition=%d | position=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
      AppMethodBeat.o(37998);
      return;
    }
    Object localObject1 = frq().abQ(i);
    if (localObject1 == null)
    {
      AppMethodBeat.o(37998);
      return;
    }
    if ((localObject1 instanceof k))
    {
      if (u.hasAttr(this.Iyl, 16384))
      {
        ac.i("MicroMsg.SelectContactUI", "handleClickNonSelect, return the result");
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("Select_Contact", "");
        ((Intent)localObject1).putExtra("Select_Conv_User", "");
        ((Intent)localObject1).putExtra("Select_Contact", "");
        setResult(-1, (Intent)localObject1);
        finish();
      }
      AppMethodBeat.o(37998);
      return;
    }
    if (((com.tencent.mm.ui.contact.a.a)localObject1).contact == null)
    {
      AppMethodBeat.o(37998);
      return;
    }
    if (((com.tencent.mm.ui.contact.a.a)localObject1).contact.field_deleteFlag == 1)
    {
      AppMethodBeat.o(37998);
      return;
    }
    localObject1 = ((com.tencent.mm.ui.contact.a.a)localObject1).contact.field_username;
    ac.i("MicroMsg.SelectContactUI", "ClickUser=%s", new Object[] { localObject1 });
    if (u.hasAttr(this.Iyl, 64))
    {
      Object localObject2;
      if ((com.tencent.mm.model.w.sQ((String)localObject1)) && (getIntent().getBooleanExtra("create_group_recommend", false)))
      {
        localObject2 = new Intent(this, ChattingUI.class);
        ((Intent)localObject2).addFlags(67108864);
        ((Intent)localObject2).putExtra("Chat_User", (String)localObject1);
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject2);
        com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aeD(), "com/tencent/mm/ui/contact/SelectContactUI", "handleItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/SelectContactUI", "handleItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        abT(3);
        AppMethodBeat.o(37998);
        return;
      }
      if ((u.hasAttr(this.Iyl, 131072)) && (this.uFm.size() >= getIntent().getIntExtra("max_limit_num", 2147483647))) {
        if (!this.IyB.contains(localObject1))
        {
          frx();
          if (!this.uFm.contains(localObject1)) {
            break label481;
          }
          this.uFo.aGU((String)localObject1);
          this.uFm.remove(localObject1);
        }
      }
      for (;;)
      {
        WT();
        frH();
        frr().notifyDataSetChanged();
        AppMethodBeat.o(37998);
        return;
        label481:
        localObject2 = getIntent().getStringExtra("too_many_member_tip_string");
        localObject1 = localObject2;
        if (bs.isNullOrNil((String)localObject2)) {
          localObject1 = getString(2131762994, new Object[] { Integer.valueOf(getIntent().getIntExtra("max_limit_num", 10)) });
        }
        com.tencent.mm.ui.base.h.d(getContext(), (String)localObject1, "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        continue;
        aQZ((String)localObject1);
      }
    }
    ip(bs.S(new String[] { localObject1 }));
    AppMethodBeat.o(37998);
  }
  
  static final class a
  {
    private AlphaAnimation IyW;
    private AlphaAnimation IyX;
    boolean IyY = false;
    TextView lzD;
    
    final void bl(Activity paramActivity)
    {
      AppMethodBeat.i(37989);
      if (this.lzD == null) {
        this.lzD = ((TextView)paramActivity.findViewById(2131304506));
      }
      if (this.lzD.getVisibility() == 8)
      {
        AppMethodBeat.o(37989);
        return;
      }
      if (this.IyX == null)
      {
        this.IyX = new AlphaAnimation(1.0F, 0.0F);
        this.IyX.setAnimationListener(new Animation.AnimationListener()
        {
          public final void onAnimationEnd(Animation paramAnonymousAnimation)
          {
            AppMethodBeat.i(37987);
            SelectContactUI.a.this.lzD.setVisibility(8);
            AppMethodBeat.o(37987);
          }
          
          public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
          
          public final void onAnimationStart(Animation paramAnonymousAnimation) {}
        });
      }
      this.IyX.setDuration(300L);
      if (this.IyW != null) {
        this.IyW.cancel();
      }
      this.lzD.startAnimation(this.IyX);
      AppMethodBeat.o(37989);
    }
    
    public final void e(final Activity paramActivity, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(37988);
      if ((paramInt2 > 0) && (paramInt1 == paramInt2 + 1) && (!this.IyY))
      {
        if (this.lzD == null) {
          this.lzD = ((TextView)paramActivity.findViewById(2131304506));
        }
        if (this.lzD.getVisibility() != 0)
        {
          this.lzD.setText(2131762573);
          this.lzD.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(37986);
              SelectContactUI.a.this.IyY = true;
              SelectContactUI.a.this.bl(paramActivity);
              AppMethodBeat.o(37986);
            }
          });
          if (this.IyW == null) {
            this.IyW = new AlphaAnimation(0.0F, 1.0F);
          }
          this.IyW.setDuration(300L);
          if (this.IyX != null) {
            this.IyX.cancel();
          }
          this.lzD.setVisibility(0);
          this.lzD.startAnimation(this.IyW);
        }
        AppMethodBeat.o(37988);
        return;
      }
      if (paramInt1 < paramInt2)
      {
        bl(paramActivity);
        this.IyY = false;
      }
      AppMethodBeat.o(37988);
    }
  }
  
  static final class b
    implements Runnable
  {
    private WeakReference<SelectContactUI> cnv;
    
    private b(SelectContactUI paramSelectContactUI)
    {
      AppMethodBeat.i(37990);
      this.cnv = new WeakReference(paramSelectContactUI);
      AppMethodBeat.o(37990);
    }
    
    public final void run()
    {
      AppMethodBeat.i(37991);
      SelectContactUI localSelectContactUI = (SelectContactUI)this.cnv.get();
      if (localSelectContactUI == null)
      {
        AppMethodBeat.o(37991);
        return;
      }
      localSelectContactUI.moveTaskToBack(true);
      AppMethodBeat.o(37991);
    }
  }
  
  static final class c
    implements Runnable
  {
    private ArrayList<String> Iza;
    private WeakReference<SelectContactUI> cnv;
    
    private c(SelectContactUI paramSelectContactUI, ArrayList<String> paramArrayList)
    {
      AppMethodBeat.i(37992);
      this.cnv = new WeakReference(paramSelectContactUI);
      this.Iza = paramArrayList;
      AppMethodBeat.o(37992);
    }
    
    public final void run()
    {
      AppMethodBeat.i(37993);
      SelectContactUI localSelectContactUI = (SelectContactUI)this.cnv.get();
      if (localSelectContactUI == null)
      {
        AppMethodBeat.o(37993);
        return;
      }
      String str = com.tencent.mm.model.u.axw();
      Object localObject1 = null;
      int i = 0;
      Iterator localIterator = this.Iza.iterator();
      if (localIterator.hasNext())
      {
        Object localObject2 = (String)localIterator.next();
        ac.d("MicroMsg.SelectContactUI", "toSend, %s", new Object[] { localObject2 });
        if (com.tencent.mm.model.w.sQ((String)localObject2)) {}
        for (int j = 1;; j = 0)
        {
          localObject2 = new com.tencent.mm.av.l(4, str, (String)localObject2, localSelectContactUI.getIntent().getStringExtra("shareImagePath"), 0, null, 0, "", (String)localObject1, true, 2131231564);
          az.agi().a((n)localObject2, 0);
          if (((com.tencent.mm.av.l)localObject2).cZc != null) {
            localObject1 = ((com.tencent.mm.av.l)localObject2).cZc.field_imgPath;
          }
          i += j;
          break;
        }
      }
      SelectContactUI.g(localSelectContactUI).dismiss();
      localObject1 = new Intent();
      ((Intent)localObject1).putStringArrayListExtra("Select_Contact", this.Iza);
      localSelectContactUI.setResult(-1, (Intent)localObject1);
      com.tencent.mm.plugin.report.service.h.wUl.f(11048, new Object[] { Integer.valueOf(1), Integer.valueOf(this.Iza.size() - i), Integer.valueOf(i) });
      localSelectContactUI.finish();
      AppMethodBeat.o(37993);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SelectContactUI
 * JD-Core Version:    0.7.0.1
 */