package com.tencent.mm.ui.bizchat;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.a.d;
import com.tencent.mm.am.a.l;
import com.tencent.mm.am.ag;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.aw.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.u;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.g;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.tools.r.b;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BizChatAtSomeoneUI
  extends MMActivity
{
  private static boolean Jum = false;
  private a Juk;
  private com.tencent.mm.am.a.c Jul;
  private String fSA;
  private String fSB;
  private com.tencent.mm.ui.tools.r fSC;
  private ListView jpT;
  private String mTitle;
  private long nYO;
  private String talker;
  
  protected static String a(com.tencent.mm.am.a.c paramc, String paramString)
  {
    AppMethodBeat.i(33901);
    if (paramc == null)
    {
      AppMethodBeat.o(33901);
      return null;
    }
    paramc = paramc.zf(paramString);
    AppMethodBeat.o(33901);
    return paramc;
  }
  
  public int getLayoutId()
  {
    return 2131493116;
  }
  
  public void initView()
  {
    AppMethodBeat.i(33898);
    setMMTitle(this.mTitle);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(33887);
        BizChatAtSomeoneUI.this.setResult(0);
        BizChatAtSomeoneUI.this.finish();
        AppMethodBeat.o(33887);
        return true;
      }
    });
    this.fSC = new com.tencent.mm.ui.tools.r((byte)0);
    this.fSC.KKQ = new r.b()
    {
      public final boolean Jp(String paramAnonymousString)
      {
        return false;
      }
      
      public final void Jq(String paramAnonymousString)
      {
        AppMethodBeat.i(33888);
        BizChatAtSomeoneUI.a locala = BizChatAtSomeoneUI.a(BizChatAtSomeoneUI.this);
        locala.fSM = paramAnonymousString;
        locala.a(null, null);
        AppMethodBeat.o(33888);
      }
      
      public final void aSm() {}
      
      public final void aSn() {}
      
      public final void aSo() {}
      
      public final void aSp() {}
    };
    addSearchMenu(true, this.fSC);
    this.jpT = ((ListView)findViewById(2131297967));
    com.tencent.mm.am.a.k localk = new com.tencent.mm.am.a.k();
    com.tencent.mm.am.a.c localc = this.Jul;
    String[] arrayOfString = null;
    if (!bt.isNullOrNil(this.fSB))
    {
      arrayOfString = this.fSB.split(";");
      ad.d("MicroMsg.AtSomeoneUI", "chatroom members name=[%s]", new Object[] { Arrays.toString(arrayOfString) });
    }
    Object localObject = new LinkedList();
    if (!bt.isNullOrNil(this.fSA)) {
      localObject = bt.U(this.fSA.split(";"));
    }
    this.Juk = new a(this, localk, localc, arrayOfString, (List)localObject);
    this.jpT.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(33889);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousAdapterView);
        ((b)localObject).bd(paramAnonymousView);
        ((b)localObject).mr(paramAnonymousInt);
        ((b)localObject).qY(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/bizchat/BizChatAtSomeoneUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((b)localObject).ahq());
        paramAnonymousAdapterView = new Intent();
        if ((paramAnonymousInt == 0) && (BizChatAtSomeoneUI.Jum))
        {
          paramAnonymousAdapterView.putExtra("Select_Conv_User", BizChatAtSomeoneUI.this.getString(2131756080, new Object[] { "" }));
          paramAnonymousAdapterView.putExtra("select_raw_user_name", "notify@all");
        }
        for (;;)
        {
          BizChatAtSomeoneUI.this.setResult(-1, paramAnonymousAdapterView);
          BizChatAtSomeoneUI.this.finish();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/bizchat/BizChatAtSomeoneUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(33889);
          return;
          paramAnonymousView = (com.tencent.mm.am.a.k)BizChatAtSomeoneUI.a(BizChatAtSomeoneUI.this).getItem(paramAnonymousInt);
          localObject = BizChatAtSomeoneUI.a(BizChatAtSomeoneUI.b(BizChatAtSomeoneUI.this), paramAnonymousView.field_userId);
          paramAnonymousAdapterView.putExtra("select_raw_user_name", paramAnonymousView.field_userId);
          paramAnonymousAdapterView.putExtra("Select_Conv_User", (String)localObject);
        }
      }
    });
    this.jpT.setAdapter(this.Juk);
    this.jpT.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(33890);
        q.aIJ().cp(paramAnonymousInt);
        AppMethodBeat.o(33890);
      }
    });
    AppMethodBeat.o(33898);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(33897);
    super.onCreate(paramBundle);
    this.fSA = getIntent().getStringExtra("Block_list");
    this.fSB = getIntent().getStringExtra("Chatroom_member_list");
    this.talker = getIntent().getStringExtra("Chat_User");
    this.mTitle = getIntent().getStringExtra("Add_address_titile");
    this.nYO = getIntent().getLongExtra("key_biz_chat_id", -1L);
    this.Jul = ag.aGb().bd(this.nYO);
    if (this.Jul == null)
    {
      ad.w("MicroMsg.AtSomeoneUI", "bizChatInfo is null");
      finish();
      AppMethodBeat.o(33897);
      return;
    }
    if ((this.Jul != null) && (this.Jul.field_ownerUserId.equals(u.aAm()))) {
      Jum = true;
    }
    initView();
    AppMethodBeat.o(33897);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(33900);
    this.Juk.det();
    super.onDestroy();
    AppMethodBeat.o(33900);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(33899);
    super.onPause();
    if (this.fSC != null) {
      this.fSC.fKE();
    }
    AppMethodBeat.o(33899);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
    extends com.tencent.mm.ui.r<com.tencent.mm.am.a.k>
  {
    private com.tencent.mm.am.a.c Jul;
    private String[] Juo;
    private Bitmap Jup;
    private List<String> fSL;
    String fSM;
    private com.tencent.mm.aw.a.a.c fSr;
    
    public a(Context paramContext, com.tencent.mm.am.a.k paramk, com.tencent.mm.am.a.c paramc, String[] paramArrayOfString, List<String> paramList)
    {
      super(paramk);
      AppMethodBeat.i(33891);
      this.fSr = null;
      this.Jul = paramc;
      this.Juo = paramArrayOfString;
      this.fSL = paramList;
      paramk = new c.a();
      paramk.prefixPath = com.tencent.mm.am.a.e.Ex(this.Jul.field_brandUserName);
      paramk.idr = true;
      paramk.hdX = true;
      paramk.idD = 2131690013;
      this.fSr = paramk.aJc();
      this.Jup = g.A(paramContext.getResources().getDrawable(2131689712));
      AppMethodBeat.o(33891);
    }
    
    public final boolean HY(int paramInt)
    {
      return false;
    }
    
    public final void Zu()
    {
      AppMethodBeat.i(33894);
      det();
      l locall = ag.aGd();
      Object localObject2 = this.Juo;
      Object localObject1 = this.fSM;
      List localList = this.fSL;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("select *  from BizChatUserInfo where ");
      localObject2 = localStringBuilder.append(l.a((String[])localObject2, localList));
      if ((localObject1 == null) || (((String)localObject1).equals(""))) {}
      for (localObject1 = "";; localObject1 = " and (" + "userName like '%" + (String)localObject1 + "%' )")
      {
        ((StringBuilder)localObject2).append((String)localObject1);
        localObject1 = localStringBuilder.append(" order by ");
        localObject2 = new StringBuffer();
        ((StringBuffer)localObject2).append(" case when length(BizChatUserInfo.userNamePY) > 0 then upper(BizChatUserInfo.userNamePY) ");
        ((StringBuffer)localObject2).append(" else upper(BizChatUserInfo.userName) end asc, ");
        ((StringBuffer)localObject2).append(" upper(BizChatUserInfo.userNamePY) asc, ");
        ((StringBuffer)localObject2).append(" upper(BizChatUserInfo.userName) asc ");
        ((StringBuilder)localObject1).append(((StringBuffer)localObject2).toString());
        setCursor(locall.db.rawQuery(localStringBuilder.toString(), null));
        super.notifyDataSetChanged();
        AppMethodBeat.o(33894);
        return;
      }
    }
    
    public final void Zv()
    {
      AppMethodBeat.i(33895);
      Zu();
      AppMethodBeat.o(33895);
    }
    
    public final int dac()
    {
      AppMethodBeat.i(33892);
      if (BizChatAtSomeoneUI.Jum)
      {
        AppMethodBeat.o(33892);
        return 1;
      }
      AppMethodBeat.o(33892);
      return 0;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(33893);
      if (paramView == null)
      {
        paramView = View.inflate(this.context, 2131493115, null);
        paramViewGroup = new BizChatAtSomeoneUI.b((byte)0);
        paramViewGroup.fTA = ((MaskLayout)paramView.findViewById(2131296957));
        paramViewGroup.fPC = ((TextView)paramView.findViewById(2131296958));
        paramView.setTag(paramViewGroup);
      }
      while ((paramInt == 0) && (BizChatAtSomeoneUI.Jum))
      {
        paramViewGroup.Juq.setImageBitmap(this.Jup);
        paramViewGroup.fPC.setText(this.context.getResources().getString(2131756080, new Object[] { "@" }));
        AppMethodBeat.o(33893);
        return paramView;
        paramViewGroup = (BizChatAtSomeoneUI.b)paramView.getTag();
      }
      if (BizChatAtSomeoneUI.Jum) {}
      for (int i = 1;; i = 0)
      {
        Object localObject = (com.tencent.mm.am.a.k)getItem(paramInt - i);
        paramViewGroup.fPC.setTextColor(com.tencent.mm.cc.a.m(this.context, 2131100638));
        ImageView localImageView = (ImageView)paramViewGroup.fTA.getContentView();
        q.aIJ().a(((com.tencent.mm.am.a.k)localObject).field_headImageUrl, localImageView, this.fSr);
        paramViewGroup.fTA.setMaskDrawable(null);
        localObject = BizChatAtSomeoneUI.a(this.Jul, ((com.tencent.mm.am.a.k)localObject).field_userId);
        paramViewGroup.fPC.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.context, (CharSequence)localObject, paramViewGroup.fPC.getTextSize()));
        AppMethodBeat.o(33893);
        return paramView;
      }
    }
  }
  
  static final class b
  {
    public ImageView Juq;
    public TextView fPC;
    public MaskLayout fTA;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatAtSomeoneUI
 * JD-Core Version:    0.7.0.1
 */