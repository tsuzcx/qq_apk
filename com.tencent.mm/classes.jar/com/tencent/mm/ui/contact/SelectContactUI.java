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
import com.tencent.mm.al.n;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.du;
import com.tencent.mm.m.e;
import com.tencent.mm.model.az;
import com.tencent.mm.openim.a.b.a;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.pluginsdk.ui.applet.aa.a;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.contact.a.k;
import com.tencent.mm.ui.r.b;
import com.tencent.mm.ui.x.a;
import com.tencent.mm.ui.y;
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
  implements com.tencent.mm.al.g
{
  private int GSH;
  private int GXV;
  private boolean GXW;
  private a GXX;
  private TextView GYf;
  private TextView GYg;
  private TextView GYh;
  private TextView GYi;
  private TextView GYj;
  private TextView GYk;
  private List<String> GYl;
  private Map<String, Integer> GYm;
  private boolean GYn;
  private boolean GYo;
  private String GYp;
  private String GYq;
  private boolean GYr;
  private boolean GYs;
  private boolean GYt;
  private boolean GYu;
  private String GYv;
  private b GYw;
  private boolean GYx;
  private ProgressDialog fpP;
  private List<String> fvP;
  private String lZG;
  private int requestCode;
  private String sMt;
  private String title;
  private List<String> twU;
  
  public SelectContactUI()
  {
    AppMethodBeat.i(37994);
    this.GYm = new HashMap();
    this.GXW = true;
    this.GYu = false;
    this.GYw = new b(this, (byte)0);
    this.GYx = false;
    this.GXX = new a();
    AppMethodBeat.o(37994);
  }
  
  private void VV()
  {
    AppMethodBeat.i(38006);
    if ((u.hasAttr(this.GXV, 64)) && (this.twU.size() > 0))
    {
      updateOptionMenuText(1, getString(2131755835) + "(" + this.twU.size() + ")");
      int i = getIntent().getIntExtra("min_limit_num", 0);
      if ((u.hasAttr(this.GXV, 262144)) && (this.twU.size() < i))
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
  
  private static List<String> Z(List<String> paramList)
  {
    AppMethodBeat.i(38020);
    LinkedList localLinkedList = new LinkedList();
    if (!az.afw())
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
      az.arV();
      af localaf = com.tencent.mm.model.c.apM().aHY(str);
      paramList = str;
      if (localaf != null)
      {
        paramList = str;
        if ((int)localaf.fId != 0) {
          paramList = localaf.ZX();
        }
      }
      localLinkedList.add(paramList);
    }
    AppMethodBeat.o(38020);
    return localLinkedList;
  }
  
  private void ZF(int paramInt)
  {
    AppMethodBeat.i(38012);
    if (this.GYx)
    {
      AppMethodBeat.o(38012);
      return;
    }
    this.GYx = true;
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
        localObject = this.twU.iterator();
        j = 0;
        label107:
        if (!((Iterator)localObject).hasNext()) {
          break label257;
        }
        String str = (String)((Iterator)localObject).next();
        if (this.GYm.containsKey(str)) {
          switch (((Integer)this.GYm.get(str)).intValue())
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
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SelectContactUI", "report_17535, scene:%d, SelectCount:%d, SearchCount:%d, RecommendCount:%d, RecommendGroupCount:%d, ExitType:%d, TokenSearchCount:%d, TokenRecommendCount:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(fbz().fbd()), Integer.valueOf(paramInt), Integer.valueOf(i1), Integer.valueOf(j) });
      com.tencent.mm.plugin.report.service.h.vKh.f(17535, new Object[] { Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(fbz().fbd()), Integer.valueOf(paramInt), Integer.valueOf(i1), Integer.valueOf(j) });
      Object localObject = new LinkedList();
      ((List)localObject).addAll(this.GYl);
      ((List)localObject).addAll(this.twU);
      w.ib((List)localObject);
    }
    AppMethodBeat.o(38012);
  }
  
  private TextView a(ListView paramListView, View.OnClickListener paramOnClickListener, String paramString)
  {
    AppMethodBeat.i(38003);
    View localView = y.js(this).inflate(2131494420, null);
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
    ZF(2);
    AppMethodBeat.o(38011);
  }
  
  private void aLv(String paramString)
  {
    AppMethodBeat.i(38018);
    if (this.GYl.contains(paramString))
    {
      AppMethodBeat.o(38018);
      return;
    }
    int i;
    if (this.twU.contains(paramString))
    {
      this.twU.remove(paramString);
      i = 1;
      if (getIntent().getBooleanExtra("create_group_recommend", false))
      {
        if (fbz() == fbA()) {
          break label310;
        }
        ((c)fbA()).GTA.reset();
        fbA().VP();
        this.GWe.bXa();
        hideVKB();
      }
      label107:
      if (!(fbz() instanceof v)) {
        break label338;
      }
      String str = ((v)fbz()).fby();
      if (this.twW != null) {
        this.twW.getInputText().setText(str);
      }
    }
    for (;;)
    {
      this.twW.aBC(paramString);
      AppMethodBeat.o(38018);
      return;
      this.twU.add(paramString);
      if ((fbz() instanceof v))
      {
        if (((v)fbz()).fbO())
        {
          this.GYm.put(paramString, Integer.valueOf(((v)fbz()).aLs(paramString)));
          i = 0;
          break;
        }
        this.GYm.put(paramString, Integer.valueOf(1));
        i = 0;
        break;
      }
      if (fbz() == fbA())
      {
        if (((c)fbA()).aLm(paramString))
        {
          this.GYm.put(paramString, Integer.valueOf(2));
          i = 0;
          break;
        }
        this.GYm.put(paramString, Integer.valueOf(0));
      }
      i = 0;
      break;
      label310:
      if ((i == 0) && (!((c)fbA()).aLm(paramString))) {
        break label107;
      }
      fbA().VP();
      break label107;
      label338:
      fbG();
    }
  }
  
  private void fbQ()
  {
    int j = 0;
    AppMethodBeat.i(37999);
    if ((this.GXW) && ((this.GSH == 1) || (this.GSH == 0))) {
      if (this.GYl == null) {
        break label96;
      }
    }
    label96:
    for (int i = this.GYl.size();; i = 0)
    {
      if (this.twU != null) {
        j = this.twU.size();
      }
      int k = bt.aGh(com.tencent.mm.m.g.Zd().getValue("ChatRoomInviteStartCount"));
      this.GXX.e(this, i + j, k);
      AppMethodBeat.o(37999);
      return;
    }
  }
  
  private void fbR()
  {
    AppMethodBeat.i(38009);
    ArrayList localArrayList = wv(true);
    localArrayList.remove(com.tencent.mm.model.u.aqG());
    if (localArrayList.size() > 0)
    {
      this.fpP = com.tencent.mm.ui.base.h.b(getContext(), getString(2131761075), false, null);
      az.afE().ax(new c(this, localArrayList, (byte)0));
    }
    AppMethodBeat.o(38009);
  }
  
  private void fbS()
  {
    AppMethodBeat.i(38010);
    Object localObject = wv(false);
    ((ArrayList)localObject).remove(com.tencent.mm.model.u.aqG());
    final String str = bt.n((List)localObject, ",");
    if (!bt.gL((List)localObject))
    {
      com.tencent.mm.ui.base.h.a(getContext(), true, getString(2131760621), "", getString(2131760620), getString(2131760619), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(37972);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SelectContactUI", "return the result,and create new label");
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
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SelectContactUI", "return the result");
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
  
  private boolean ic(final List<String> paramList)
  {
    AppMethodBeat.i(38004);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SelectContactUI", "handleSelect %s", new Object[] { paramList });
    if (u.hasAttr(this.GXV, 65536))
    {
      String str = ie(paramList);
      this.GYt = true;
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
      bool = this.GYt;
      AppMethodBeat.o(38004);
      return bool;
    }
    boolean bool = id(paramList);
    AppMethodBeat.o(38004);
    return bool;
  }
  
  private boolean id(List<String> paramList)
  {
    boolean bool = false;
    AppMethodBeat.i(38005);
    if (getIntent().getBooleanExtra("Add_SendCard", false))
    {
      if (bt.isNullOrNil(this.GYp)) {
        this.GYp = bt.n(paramList, ",");
      }
      for (;;)
      {
        bool = com.tencent.mm.model.w.pF(this.GYq);
        paramList = new Intent();
        paramList.putExtra("be_send_card_name", this.GYp);
        paramList.putExtra("received_card_name", this.GYq);
        paramList.putExtra("Is_Chatroom", bool);
        setResult(-1, paramList);
        finish();
        AppMethodBeat.o(38005);
        return true;
        if (!bt.isNullOrNil(this.GYq)) {
          break;
        }
        this.GYq = bt.n(paramList, ",");
      }
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SelectContactUI", "send card occur error: send:%s | receive:%s", new Object[] { this.GYp, this.GYq });
      AppMethodBeat.o(38005);
      return false;
    }
    Object localObject;
    int i;
    if (getIntent().getBooleanExtra("snsPostWhoCanSee", false))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SelectContactUI", "sns post who can see scene,users=%s", new Object[] { paramList.toString() });
      localObject = wv(false);
      ((ArrayList)localObject).remove(com.tencent.mm.model.u.aqG());
      paramList = paramList.iterator();
      for (i = 0; paramList.hasNext(); i = 1)
      {
        label228:
        String str = (String)paramList.next();
        if (bt.isNullOrNil(str)) {
          break label730;
        }
        if ((((ArrayList)localObject).contains(str)) || (com.tencent.mm.model.u.aqG().equals(str))) {
          break label228;
        }
        az.arV();
        af localaf = com.tencent.mm.model.c.apM().aHY(str);
        if ((localaf == null) || ((int)localaf.fId == 0) || (!com.tencent.mm.n.b.ls(localaf.field_type))) {
          break label730;
        }
        aLv(str);
        ((ArrayList)localObject).add(str);
      }
    }
    label730:
    for (;;)
    {
      break label228;
      if (i != 0)
      {
        VV();
        fbz().notifyDataSetChanged();
        break;
      }
      fbS();
      break;
      if (getIntent().getBooleanExtra("recommend_friends", false))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SelectContactUI", "Recommend Friends");
        ad.a(getContext(), this.GYq, paramList);
        break;
      }
      if (u.hasAttr(this.GXV, 16384))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SelectContactUI", "return the result");
        localObject = new Intent();
        paramList = bt.n(paramList, ",");
        ((Intent)localObject).putExtra("Select_Contact", paramList);
        ((Intent)localObject).putExtra("Select_Conv_User", paramList);
        ((Intent)localObject).putExtra("Select_Contact", paramList);
        ((Intent)localObject).putExtra("label_source", this.sMt);
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
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SelectContactUI", "Share Image");
        fbR();
        break;
      }
      if (paramList.size() > 0)
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SelectContactUI", "Launch ChattingUI: users=%s", new Object[] { paramList.toString() });
        finish();
        localObject = new Intent();
        ((Intent)localObject).setClass(this, ChattingUI.class);
        ((Intent)localObject).putExtra("Chat_User", (String)paramList.get(0));
        ((Intent)localObject).addFlags(67108864);
        paramList = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramList.adn(), "com/tencent/mm/ui/contact/SelectContactUI", "dohandleSelect", "(Ljava/util/List;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramList.lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/SelectContactUI", "dohandleSelect", "(Ljava/util/List;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ZF(3);
        break;
      }
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SelectContactUI", "unkown action: User=%s", new Object[] { paramList.toString() });
      break;
    }
  }
  
  private String ie(List<String> paramList)
  {
    AppMethodBeat.i(38019);
    StringBuilder localStringBuilder = null;
    Object localObject = localStringBuilder;
    if (paramList != null)
    {
      if (paramList.size() != 1) {
        break label62;
      }
      localObject = getString(2131762980, new Object[] { com.tencent.mm.model.v.sh((String)paramList.get(0)) });
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
      localStringBuilder.append(com.tencent.mm.model.v.sh((String)paramList.get(i)));
      if (i < paramList.size() - 1) {
        localStringBuilder.append((String)localObject);
      }
      i += 1;
    }
  }
  
  private ArrayList<String> wv(boolean paramBoolean)
  {
    AppMethodBeat.i(38007);
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.twU.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      if ((!paramBoolean) && (com.tencent.mm.model.w.sB((String)localObject)))
      {
        localObject = com.tencent.mm.model.q.rX((String)localObject);
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
  
  private ArrayList<String> ww(boolean paramBoolean)
  {
    AppMethodBeat.i(38008);
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.twU.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      if ((!paramBoolean) && (com.tencent.mm.model.w.sB((String)localObject)))
      {
        localObject = com.tencent.mm.model.q.rX((String)localObject);
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
    localHashSet.addAll(this.GYl);
    localArrayList.addAll(localHashSet);
    AppMethodBeat.o(38008);
    return localArrayList;
  }
  
  public final void N(int paramInt, String paramString)
  {
    AppMethodBeat.i(38017);
    if (paramInt == 1)
    {
      this.twU.remove(paramString);
      if (!(fbz() instanceof v)) {
        break label65;
      }
      paramString = ((v)fbz()).fby();
      this.twW.getInputText().setText(paramString);
    }
    for (;;)
    {
      VV();
      AppMethodBeat.o(38017);
      return;
      label65:
      if ((fbz() instanceof c)) {
        fbA().VP();
      } else {
        fbz().notifyDataSetChanged();
      }
    }
  }
  
  protected final void VL()
  {
    AppMethodBeat.i(37997);
    super.VL();
    this.GXV = getIntent().getIntExtra("list_attr", u.GWA);
    this.title = getIntent().getStringExtra("titile");
    this.lZG = getIntent().getStringExtra("sub_title");
    this.GSH = getIntent().getIntExtra("list_type", -1);
    this.GXW = getIntent().getBooleanExtra("show_too_many_member", true);
    this.sMt = getIntent().getStringExtra("label_source");
    if ((u.hasAttr(this.GXV, 256)) && (com.tencent.mm.model.w.ars().size() == 0)) {
      u.jw(this.GXV, 256);
    }
    this.GYn = getIntent().getBooleanExtra("Add_SendCard", false);
    this.GYo = getIntent().getBooleanExtra("recommend_friends", false);
    if ((this.GYn) || (this.GYo))
    {
      this.GYp = bt.by(getIntent().getStringExtra("be_send_card_name"), "");
      this.GYq = bt.by(getIntent().getStringExtra("received_card_name"), "");
    }
    this.GYr = getIntent().getBooleanExtra("Forbid_SelectChatRoom", false);
    this.fvP = new ArrayList();
    this.twU = new LinkedList();
    this.GYl = new LinkedList();
    Object localObject = getIntent().getStringExtra("always_select_contact");
    if (!bt.isNullOrNil((String)localObject)) {
      this.GYl.addAll(bt.S(((String)localObject).split(",")));
    }
    localObject = getIntent().getStringExtra("already_select_contact");
    if (!bt.isNullOrNil((String)localObject)) {
      this.twU.addAll(bt.S(((String)localObject).split(",")));
    }
    localObject = new HashSet();
    String str = getIntent().getStringExtra("block_contact");
    if (!bt.isNullOrNil(str)) {
      ((HashSet)localObject).addAll(bt.S(str.split(",")));
    }
    localObject = new HashSet((Collection)localObject);
    ((HashSet)localObject).addAll(u.fbL());
    ((HashSet)localObject).addAll(u.fbM());
    if (!u.hasAttr(this.GXV, 268435456)) {
      ((HashSet)localObject).add(com.tencent.mm.model.u.aqG());
    }
    if (this.GYn) {
      ((HashSet)localObject).removeAll(u.fbL());
    }
    this.fvP.add("gh_3dfda90e39d6");
    this.fvP.addAll((Collection)localObject);
    fbQ();
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
    if (u.hasAttr(this.GXV, 256))
    {
      if (this.GYf == null)
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
                ((Intent)localObject).putExtra("already_select_contact", bt.n(SelectContactUI.a(SelectContactUI.this, true), ","));
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
            localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/ui/contact/SelectContactUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/ui/contact/SelectContactUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(37977);
          }
        };
        if (this.GSH == 14)
        {
          localObject = getString(2131755225);
          this.GYf = a(paramListView, local10, (String)localObject);
        }
      }
      else
      {
        this.GYf.setVisibility(paramInt);
      }
    }
    else
    {
      if (u.hasAttr(this.GXV, 512))
      {
        if (this.GYg == null) {
          this.GYg = a(paramListView, new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(37978);
              com.tencent.mm.plugin.report.service.h.vKh.f(11140, new Object[] { Integer.valueOf(0) });
              d.O(SelectContactUI.this, "pwdgroup", ".ui.FacingCreateChatRoomAllInOneUI");
              AppMethodBeat.o(37978);
            }
          }, getString(2131759100));
        }
        this.GYg.setVisibility(paramInt);
      }
      if (u.hasAttr(this.GXV, 1024))
      {
        if (this.GYh == null) {
          this.GYh = a(paramListView, new View.OnClickListener()
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
        this.GYh.setVisibility(paramInt);
      }
      if (u.hasAttr(this.GXV, 2048))
      {
        if (this.GYj == null) {
          this.GYj = a(paramListView, new View.OnClickListener()
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
        this.GYj.setVisibility(paramInt);
        this.GYj.setTextSize(16.0F * com.tencent.mm.cd.a.dT(this.GYj.getContext()));
      }
      if (u.hasAttr(this.GXV, 524288)) {
        if (this.GYi == null)
        {
          localObject = "";
          i = getIntent().getIntExtra("topstory_import_type", 0);
          j = 2131755209;
          if (i != 1) {
            break label636;
          }
          localObject = com.tencent.mm.plugin.sns.c.o.wzJ.sr(5L);
          if (!bt.gL((List)localObject)) {
            break label625;
          }
          i = 0;
          localObject = bt.n((List)localObject, ",");
          j = 2131755209;
          m = 2131755210;
          k = i;
          i = m;
        }
      }
    }
    for (;;)
    {
      this.GYi = a(paramListView, new View.OnClickListener()
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
              paramAnonymous2DialogInterface.putExtra("Select_Contact", SelectContactUI.14.this.GYE);
              paramAnonymous2DialogInterface.putExtra("App_MsgId", "fromSns");
              SelectContactUI.this.setResult(-1, paramAnonymous2DialogInterface);
              SelectContactUI.this.finish();
              AppMethodBeat.o(37981);
            }
          }, null);
          AppMethodBeat.o(37982);
        }
      }, getString(j));
      this.GYi.setTag(Integer.valueOf(k));
      localObject = this.GYi.getTag();
      if ((!(localObject instanceof Integer)) || (((Integer)localObject).intValue() <= 0)) {
        this.GYi.setVisibility(8);
      }
      for (;;)
      {
        if (u.hasAttr(this.GXV, 16777216))
        {
          if (this.GYk == null)
          {
            az.arV();
            localObject = com.tencent.mm.model.c.apM().eKN();
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SelectContactUI", "setOpenIMHeaderView %s", new Object[] { Integer.valueOf(((List)localObject).size()) });
            if (((List)localObject).size() != 0)
            {
              this.GYk = a(paramListView, new View.OnClickListener()
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
                    if (af.aHH(str)) {
                      localArrayList.add(str);
                    }
                  }
                  paramAnonymousView.putExtra("already_select_contact", bt.n(localArrayList, ","));
                  SelectContactUI.this.startActivityForResult(paramAnonymousView, 5);
                  AppMethodBeat.o(37983);
                }
              }, "");
              paramListView = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).a("3552365301", "openim_acct_type_title", b.a.hNA);
              this.GYk.setVisibility(paramInt);
              this.GYk.setText(paramListView);
            }
          }
          if (this.GYk != null) {
            this.GYk.setVisibility(paramInt);
          }
        }
        if ((!u.hasAttr(this.GXV, 16777216)) || (this.GYk == null)) {
          break label707;
        }
        this.GYk.setBackgroundResource(2131231820);
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
        localObject = com.tencent.mm.model.w.arx();
        if (bt.gL((List)localObject)) {}
        for (i = 0;; i = ((List)localObject).size())
        {
          localObject = bt.n((List)localObject, ",");
          j = 2131755207;
          m = 2131755208;
          k = i;
          i = m;
          break;
        }
        this.GYi.setVisibility(paramInt);
      }
      label707:
      if (u.hasAttr(this.GXV, 2048))
      {
        if (this.GYj != null)
        {
          this.GYj.setBackgroundResource(2131231820);
          AppMethodBeat.o(38002);
        }
      }
      else if (u.hasAttr(this.GXV, 1024))
      {
        if (this.GYh != null)
        {
          this.GYh.setBackgroundResource(2131231820);
          AppMethodBeat.o(38002);
        }
      }
      else if (u.hasAttr(this.GXV, 512))
      {
        if (this.GYg != null)
        {
          this.GYg.setBackgroundResource(2131231820);
          AppMethodBeat.o(38002);
        }
      }
      else if ((u.hasAttr(this.GXV, 256)) && (this.GYf != null)) {
        this.GYf.setBackgroundResource(2131231820);
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
    if ((parama.GVT) && (parama.contact != null))
    {
      bool = this.twU.contains(parama.contact.field_username);
      AppMethodBeat.o(38014);
      return bool;
    }
    if ((parama.GVU) && (parama.contact != null))
    {
      bool = this.twU.contains(parama.contact.field_username);
      AppMethodBeat.o(38014);
      return bool;
    }
    if ((parama instanceof k))
    {
      bool = this.twU.isEmpty();
      AppMethodBeat.o(38014);
      return bool;
    }
    AppMethodBeat.o(38014);
    return false;
  }
  
  protected final boolean aHt()
  {
    return false;
  }
  
  protected final boolean aHu()
  {
    return true;
  }
  
  protected final String aHv()
  {
    return this.title;
  }
  
  protected final q aHw()
  {
    boolean bool2 = false;
    AppMethodBeat.i(38000);
    Object localObject = new c.a();
    ((c.a)localObject).GTE = u.hasAttr(this.GXV, 16);
    ((c.a)localObject).GTD = u.hasAttr(this.GXV, 32);
    ((c.a)localObject).GTH = getIntent().getBooleanExtra("create_group_recommend", false);
    boolean bool1;
    if (!u.hasAttr(this.GXV, 4))
    {
      bool1 = true;
      ((c.a)localObject).GTF = bool1;
      if (u.hasAttr(this.GXV, 1)) {
        break label366;
      }
      bool1 = true;
      label92:
      ((c.a)localObject).GTG = bool1;
      ((c.a)localObject).GTI = u.hasAttr(this.GXV, 128);
      ((c.a)localObject).GTJ = u.hasAttr(this.GXV, 1048576);
      ((c.a)localObject).GTM = u.hasAttr(this.GXV, 256);
      if (((c.a)localObject).GTM) {
        ((c.a)localObject).GTN = getIntent().getStringExtra("custom_contact");
      }
      if (((c.a)localObject).GTI)
      {
        this.GYu = true;
        ((c.a)localObject).GTK = getIntent().getStringExtra("wechat_sport_contact");
        ((c.a)localObject).GTL = getIntent().getStringExtra("wechat_sport_recent_like");
        this.GYv = ((c.a)localObject).GTK;
      }
      if (!u.fbN()) {
        break label371;
      }
    }
    label366:
    label371:
    for (((c.a)localObject).GRX = "@all.contact.without.chatroom.without.openim";; ((c.a)localObject).GRX = "@all.contact.without.chatroom.without.openim.without.openimfavour")
    {
      if ((this.scene == 6) || (this.scene == 5)) {
        ((c.a)localObject).GRX = "@all.contact.without.chatroom.without.openim.without.openimfavour";
      }
      if (getIntent().getBooleanExtra("KBlockOpenImFav", false)) {
        ((c.a)localObject).GRX = "@all.contact.without.chatroom.without.openim.without.openimfavour";
      }
      List localList1 = this.GYl;
      List localList2 = this.twU;
      List localList3 = this.fvP;
      boolean bool3 = u.hasAttr(this.GXV, 1);
      boolean bool4 = u.hasAttr(this.GXV, 64);
      bool1 = bool2;
      if (this.GSH == 15) {
        bool1 = true;
      }
      localObject = new c(this, localList1, localList2, localList3, bool3, bool4, (c.a)localObject, bool1);
      AppMethodBeat.o(38000);
      return localObject;
      bool1 = false;
      break;
      bool1 = false;
      break label92;
    }
  }
  
  protected final o aHx()
  {
    AppMethodBeat.i(38001);
    if (this.GYu)
    {
      localObject = new t(this, this.fvP, u.hasAttr(this.GXV, 64), this.GYv);
      AppMethodBeat.o(38001);
      return localObject;
    }
    if (getIntent().getBooleanExtra("create_group_recommend", false))
    {
      localObject = new v(this, this.GYl, this.twU, this.fvP, u.hasAttr(this.GXV, 64), this.scene);
      AppMethodBeat.o(38001);
      return localObject;
    }
    Object localObject = new s(this, this.fvP, u.hasAttr(this.GXV, 64), this.scene);
    AppMethodBeat.o(38001);
    return localObject;
  }
  
  protected final void afM(String paramString)
  {
    AppMethodBeat.i(38022);
    com.tencent.mm.plugin.report.service.h.vKh.f(11225, new Object[] { Integer.valueOf(1), Integer.valueOf(0) });
    Intent localIntent = new Intent();
    localIntent.setClassName(this, "com.tencent.mm.ui.contact.SelectLabelContactUI");
    localIntent.putExtra("label", paramString);
    paramString = new HashSet();
    paramString.addAll(wv(u.hasAttr(this.GXV, 8192)));
    paramString.addAll(this.GYl);
    localIntent.putExtra("always_select_contact", bt.n(new ArrayList(paramString), ","));
    localIntent.putExtra("always_select_contact", bt.n(new ArrayList(paramString), ","));
    if (u.hasAttr(this.GXV, 64))
    {
      localIntent.putExtra("list_attr", u.I(new int[] { 16384, 64, 131072 }));
      if (this.GSH == 14) {
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
    if ((parama.GVT) && (parama.contact != null))
    {
      if (u.hasAttr(this.GXV, 536870912))
      {
        bool = parama.contact.ZR();
        AppMethodBeat.o(38015);
        return bool;
      }
      boolean bool = this.GYl.contains(parama.contact.field_username);
      AppMethodBeat.o(38015);
      return bool;
    }
    AppMethodBeat.o(38015);
    return false;
  }
  
  public final int[] cMQ()
  {
    AppMethodBeat.i(38016);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(131072));
    if (!getIntent().getBooleanExtra("without_openim", false)) {
      localArrayList.add(Integer.valueOf(131081));
    }
    if (!u.hasAttr(this.GXV, 1)) {
      localArrayList.add(Integer.valueOf(131076));
    }
    if (!u.hasAttr(this.GXV, 4)) {
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
  
  protected final boolean cOv()
  {
    return !this.GYu;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(38021);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.requestCode = paramInt1;
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SelectContactUI", "requestCode=%d | resultCode=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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
      if (!bt.isNullOrNil(paramIntent))
      {
        ic(bt.S(new String[] { paramIntent }));
        AppMethodBeat.o(38021);
        return;
        paramIntent = paramIntent.getStringExtra("Select_Conv_User");
        Object localObject1 = this.twU.iterator();
        String str1;
        while (((Iterator)localObject1).hasNext())
        {
          str1 = (String)((Iterator)localObject1).next();
          this.twW.aBD(str1);
        }
        this.twU.clear();
        if (!bt.isNullOrNil(paramIntent)) {
          this.twU.addAll(bt.S(paramIntent.split(",")));
        }
        paramIntent = this.twU.iterator();
        while (paramIntent.hasNext())
        {
          localObject1 = (String)paramIntent.next();
          this.twW.aBE((String)localObject1);
        }
        VV();
        AppMethodBeat.o(38021);
        return;
        paramIntent = paramIntent.getStringExtra("Select_Contact");
        if (!bt.isNullOrNil(paramIntent))
        {
          ic(bt.S(paramIntent.split(",")));
          AppMethodBeat.o(38021);
          return;
          if (paramIntent != null)
          {
            paramIntent = paramIntent.getStringExtra("Select_Contact");
            if (!bt.isNullOrNil(paramIntent)) {
              ic(bt.S(new String[] { paramIntent }));
            }
            AppMethodBeat.o(38021);
            return;
            paramIntent = paramIntent.getStringExtra("Select_Contact");
            if (bt.isNullOrNil(paramIntent))
            {
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SelectContactUI", "GET_LABEL_USERS return usernames is null or empty");
              AppMethodBeat.o(38021);
              return;
            }
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SelectContactUI", "GET_LABEL_USERS select username=%s", new Object[] { paramIntent });
            if (u.hasAttr(this.GXV, 64))
            {
              paramIntent = paramIntent.split(",");
              paramInt2 = paramIntent.length;
              paramInt1 = 0;
              while (paramInt1 < paramInt2)
              {
                localObject1 = paramIntent[paramInt1];
                if (this.twU.add(localObject1)) {
                  this.twW.aBC((String)localObject1);
                }
                paramInt1 += 1;
              }
              VV();
              fbz().notifyDataSetChanged();
              AppMethodBeat.o(38021);
              return;
            }
            ic(bt.S(new String[] { paramIntent }));
            AppMethodBeat.o(38021);
            return;
            if (paramIntent != null)
            {
              str1 = paramIntent.getStringExtra("Select_Contact");
              localObject1 = paramIntent.getStringExtra("Cancel_Select_Contact");
              if (bt.isNullOrNil(str1))
              {
                paramIntent = null;
                if (!bt.isNullOrNil((String)localObject1)) {
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
                  if (this.twW != null)
                  {
                    localObject2 = paramIntent.iterator();
                    for (;;)
                    {
                      if (((Iterator)localObject2).hasNext())
                      {
                        String str2 = (String)((Iterator)localObject2).next();
                        if (!this.twU.contains(str2))
                        {
                          this.twW.aBC(str2);
                          continue;
                          paramIntent = bt.kS(str1, ",");
                          break;
                          label638:
                          localObject1 = bt.kS((String)localObject1, ",");
                          break label559;
                        }
                      }
                    }
                  }
                  this.twU.addAll(paramIntent);
                }
              }
              if (localObject1 != null)
              {
                if (this.twW != null)
                {
                  paramIntent = ((List)localObject1).iterator();
                  while (paramIntent.hasNext())
                  {
                    localObject2 = (String)paramIntent.next();
                    this.twW.aBC((String)localObject2);
                  }
                }
                this.twU.removeAll((Collection)localObject1);
              }
              fbz().notifyDataSetChanged();
              if (getIntent().getBooleanExtra("Add_SendCard", false)) {
                ic(bt.S(new String[] { str1 }));
              }
            }
            VV();
          }
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(37995);
    super.onCreate(paramBundle);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SelectContactUI", "create!");
    az.aeS().a(30, this);
    az.aeS().a(138, this);
    if (!bt.isNullOrNil(this.lZG)) {
      setMMSubTitle(this.lZG);
    }
    if (u.hasAttr(this.GXV, 64)) {
      addTextOptionMenu(1, getString(2131755835), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(37971);
          paramAnonymousMenuItem = SelectContactUI.c(SelectContactUI.this, u.hasAttr(SelectContactUI.b(SelectContactUI.this), 8192));
          paramAnonymousMenuItem.remove(com.tencent.mm.model.u.aqG());
          if ((u.hasAttr(SelectContactUI.b(SelectContactUI.this), 4096)) && (paramAnonymousMenuItem.size() > 1)) {}
          for (int i = 1; i != 0; i = 0)
          {
            if (!SelectContactUI.e(SelectContactUI.this))
            {
              SelectContactUI.d(SelectContactUI.this, true);
              SelectContactUI.f(SelectContactUI.this);
            }
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SelectContactUI", "Create the chatroom");
            AppMethodBeat.o(37971);
            return true;
          }
          boolean bool = SelectContactUI.b(SelectContactUI.this, SelectContactUI.a(SelectContactUI.this, u.hasAttr(SelectContactUI.b(SelectContactUI.this), 8192)));
          AppMethodBeat.o(37971);
          return bool;
        }
      }, null, r.b.FOB);
    }
    VV();
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(37970);
        SelectContactUI.this.hideVKB();
        SelectContactUI.this.finish();
        if (!SelectContactUI.this.getIntent().getBooleanExtra("stay_in_wechat", true)) {
          aq.n(SelectContactUI.a(SelectContactUI.this), 80L);
        }
        AppMethodBeat.o(37970);
        return true;
      }
    });
    if ((this.GSH != 15) && (this.twW != null)) {
      this.twW.gG(this.twU);
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
      w.GXn = i;
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NewGroupRecommendDetailReporter", "scene:%d", new Object[] { Integer.valueOf(i) });
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
    az.aeS().b(30, this);
    az.aeS().b(138, this);
    ZF(1);
    w.reset();
    super.onDestroy();
    AppMethodBeat.o(37996);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(38013);
    if (this.fpP != null)
    {
      this.fpP.dismiss();
      this.fpP = null;
    }
    if (!bt.iM(this))
    {
      AppMethodBeat.o(38013);
      return;
    }
    if (x.a.a(this, paramInt1, paramInt2, paramString, 4))
    {
      AppMethodBeat.o(38013);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      if ((paramInt1 == 4) && (paramInt2 == -24) && (!bt.isNullOrNil(paramString))) {
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
      fbz().notifyDataSetChanged();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void pT(int paramInt)
  {
    AppMethodBeat.i(37998);
    int i = paramInt - getContentLV().getHeaderViewsCount();
    if (i < 0)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SelectContactUI", "offsetPosition is Smaller than 0, offsetPosition=%d | position=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
      AppMethodBeat.o(37998);
      return;
    }
    Object localObject1 = fbz().ZC(i);
    if (localObject1 == null)
    {
      AppMethodBeat.o(37998);
      return;
    }
    if ((localObject1 instanceof k))
    {
      if (u.hasAttr(this.GXV, 16384))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SelectContactUI", "handleClickNonSelect, return the result");
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
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SelectContactUI", "ClickUser=%s", new Object[] { localObject1 });
    if (u.hasAttr(this.GXV, 64))
    {
      Object localObject2;
      if ((com.tencent.mm.model.w.pF((String)localObject1)) && (getIntent().getBooleanExtra("create_group_recommend", false)))
      {
        localObject2 = new Intent(this, ChattingUI.class);
        ((Intent)localObject2).addFlags(67108864);
        ((Intent)localObject2).putExtra("Chat_User", (String)localObject1);
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject2);
        com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).adn(), "com/tencent/mm/ui/contact/SelectContactUI", "handleItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/SelectContactUI", "handleItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        ZF(3);
        AppMethodBeat.o(37998);
        return;
      }
      if ((u.hasAttr(this.GXV, 131072)) && (this.twU.size() >= getIntent().getIntExtra("max_limit_num", 2147483647))) {
        if (!this.GYl.contains(localObject1))
        {
          fbG();
          if (!this.twU.contains(localObject1)) {
            break label480;
          }
          this.twW.aBC((String)localObject1);
          this.twU.remove(localObject1);
        }
      }
      for (;;)
      {
        VV();
        fbQ();
        fbA().notifyDataSetChanged();
        AppMethodBeat.o(37998);
        return;
        label480:
        localObject2 = getIntent().getStringExtra("too_many_member_tip_string");
        localObject1 = localObject2;
        if (bt.isNullOrNil((String)localObject2)) {
          localObject1 = getString(2131762994, new Object[] { Integer.valueOf(getIntent().getIntExtra("max_limit_num", 10)) });
        }
        com.tencent.mm.ui.base.h.d(getContext(), (String)localObject1, "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        continue;
        aLv((String)localObject1);
      }
    }
    ic(bt.S(new String[] { localObject1 }));
    AppMethodBeat.o(37998);
  }
  
  static final class a
  {
    private AlphaAnimation GYG;
    private AlphaAnimation GYH;
    boolean GYI = false;
    TextView kXT;
    
    final void bh(Activity paramActivity)
    {
      AppMethodBeat.i(37989);
      if (this.kXT == null) {
        this.kXT = ((TextView)paramActivity.findViewById(2131304506));
      }
      if (this.kXT.getVisibility() == 8)
      {
        AppMethodBeat.o(37989);
        return;
      }
      if (this.GYH == null)
      {
        this.GYH = new AlphaAnimation(1.0F, 0.0F);
        this.GYH.setAnimationListener(new Animation.AnimationListener()
        {
          public final void onAnimationEnd(Animation paramAnonymousAnimation)
          {
            AppMethodBeat.i(37987);
            SelectContactUI.a.this.kXT.setVisibility(8);
            AppMethodBeat.o(37987);
          }
          
          public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
          
          public final void onAnimationStart(Animation paramAnonymousAnimation) {}
        });
      }
      this.GYH.setDuration(300L);
      if (this.GYG != null) {
        this.GYG.cancel();
      }
      this.kXT.startAnimation(this.GYH);
      AppMethodBeat.o(37989);
    }
    
    public final void e(final Activity paramActivity, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(37988);
      if ((paramInt2 > 0) && (paramInt1 == paramInt2 + 1) && (!this.GYI))
      {
        if (this.kXT == null) {
          this.kXT = ((TextView)paramActivity.findViewById(2131304506));
        }
        if (this.kXT.getVisibility() != 0)
        {
          this.kXT.setText(2131762573);
          this.kXT.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(37986);
              SelectContactUI.a.this.GYI = true;
              SelectContactUI.a.this.bh(paramActivity);
              AppMethodBeat.o(37986);
            }
          });
          if (this.GYG == null) {
            this.GYG = new AlphaAnimation(0.0F, 1.0F);
          }
          this.GYG.setDuration(300L);
          if (this.GYH != null) {
            this.GYH.cancel();
          }
          this.kXT.setVisibility(0);
          this.kXT.startAnimation(this.GYG);
        }
        AppMethodBeat.o(37988);
        return;
      }
      if (paramInt1 < paramInt2)
      {
        bh(paramActivity);
        this.GYI = false;
      }
      AppMethodBeat.o(37988);
    }
  }
  
  static final class b
    implements Runnable
  {
    private WeakReference<SelectContactUI> cqo;
    
    private b(SelectContactUI paramSelectContactUI)
    {
      AppMethodBeat.i(37990);
      this.cqo = new WeakReference(paramSelectContactUI);
      AppMethodBeat.o(37990);
    }
    
    public final void run()
    {
      AppMethodBeat.i(37991);
      SelectContactUI localSelectContactUI = (SelectContactUI)this.cqo.get();
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
    private ArrayList<String> GYK;
    private WeakReference<SelectContactUI> cqo;
    
    private c(SelectContactUI paramSelectContactUI, ArrayList<String> paramArrayList)
    {
      AppMethodBeat.i(37992);
      this.cqo = new WeakReference(paramSelectContactUI);
      this.GYK = paramArrayList;
      AppMethodBeat.o(37992);
    }
    
    public final void run()
    {
      AppMethodBeat.i(37993);
      SelectContactUI localSelectContactUI = (SelectContactUI)this.cqo.get();
      if (localSelectContactUI == null)
      {
        AppMethodBeat.o(37993);
        return;
      }
      String str = com.tencent.mm.model.u.aqG();
      Object localObject1 = null;
      int i = 0;
      Iterator localIterator = this.GYK.iterator();
      if (localIterator.hasNext())
      {
        Object localObject2 = (String)localIterator.next();
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SelectContactUI", "toSend, %s", new Object[] { localObject2 });
        if (com.tencent.mm.model.w.pF((String)localObject2)) {}
        for (int j = 1;; j = 0)
        {
          localObject2 = new com.tencent.mm.aw.l(4, str, (String)localObject2, localSelectContactUI.getIntent().getStringExtra("shareImagePath"), 0, null, 0, "", (String)localObject1, true, 2131231564);
          az.aeS().a((n)localObject2, 0);
          if (((com.tencent.mm.aw.l)localObject2).dbD != null) {
            localObject1 = ((com.tencent.mm.aw.l)localObject2).dbD.field_imgPath;
          }
          i += j;
          break;
        }
      }
      SelectContactUI.g(localSelectContactUI).dismiss();
      localObject1 = new Intent();
      ((Intent)localObject1).putStringArrayListExtra("Select_Contact", this.GYK);
      localSelectContactUI.setResult(-1, (Intent)localObject1);
      com.tencent.mm.plugin.report.service.h.vKh.f(11048, new Object[] { Integer.valueOf(1), Integer.valueOf(this.GYK.size() - i), Integer.valueOf(i) });
      localSelectContactUI.finish();
      AppMethodBeat.o(37993);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SelectContactUI
 * JD-Core Version:    0.7.0.1
 */