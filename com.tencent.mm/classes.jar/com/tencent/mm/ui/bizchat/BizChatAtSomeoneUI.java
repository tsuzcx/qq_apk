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
import com.tencent.mm.al.a.d;
import com.tencent.mm.al.a.l;
import com.tencent.mm.al.af;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.o;
import com.tencent.mm.model.u;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.tools.r.b;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BizChatAtSomeoneUI
  extends MMActivity
{
  private static boolean HGv = false;
  private a HGt;
  private com.tencent.mm.al.a.c HGu;
  private String fzn;
  private String fzo;
  private com.tencent.mm.ui.tools.r fzp;
  private ListView iWK;
  private String mTitle;
  private long nxq;
  private String talker;
  
  protected static String a(com.tencent.mm.al.a.c paramc, String paramString)
  {
    AppMethodBeat.i(33901);
    if (paramc == null)
    {
      AppMethodBeat.o(33901);
      return null;
    }
    paramc = paramc.wk(paramString);
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
    this.fzp = new com.tencent.mm.ui.tools.r((byte)0);
    this.fzp.ITM = new r.b()
    {
      public final boolean Ga(String paramAnonymousString)
      {
        return false;
      }
      
      public final void Gb(String paramAnonymousString)
      {
        AppMethodBeat.i(33888);
        BizChatAtSomeoneUI.a locala = BizChatAtSomeoneUI.a(BizChatAtSomeoneUI.this);
        locala.fzx = paramAnonymousString;
        locala.a(null, null);
        AppMethodBeat.o(33888);
      }
      
      public final void aPa() {}
      
      public final void aPb() {}
      
      public final void aPc() {}
      
      public final void aPd() {}
    };
    addSearchMenu(true, this.fzp);
    this.iWK = ((ListView)findViewById(2131297967));
    com.tencent.mm.al.a.k localk = new com.tencent.mm.al.a.k();
    com.tencent.mm.al.a.c localc = this.HGu;
    String[] arrayOfString = null;
    if (!bs.isNullOrNil(this.fzo))
    {
      arrayOfString = this.fzo.split(";");
      ac.d("MicroMsg.AtSomeoneUI", "chatroom members name=[%s]", new Object[] { Arrays.toString(arrayOfString) });
    }
    Object localObject = new LinkedList();
    if (!bs.isNullOrNil(this.fzn)) {
      localObject = bs.S(this.fzn.split(";"));
    }
    this.HGt = new a(this, localk, localc, arrayOfString, (List)localObject);
    this.iWK.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(33889);
        paramAnonymousAdapterView = new Intent();
        if ((paramAnonymousInt == 0) && (BizChatAtSomeoneUI.HGv))
        {
          paramAnonymousAdapterView.putExtra("Select_Conv_User", BizChatAtSomeoneUI.this.getString(2131756080, new Object[] { "" }));
          paramAnonymousAdapterView.putExtra("select_raw_user_name", "notify@all");
        }
        for (;;)
        {
          BizChatAtSomeoneUI.this.setResult(-1, paramAnonymousAdapterView);
          BizChatAtSomeoneUI.this.finish();
          AppMethodBeat.o(33889);
          return;
          paramAnonymousView = (com.tencent.mm.al.a.k)BizChatAtSomeoneUI.a(BizChatAtSomeoneUI.this).getItem(paramAnonymousInt);
          String str = BizChatAtSomeoneUI.a(BizChatAtSomeoneUI.b(BizChatAtSomeoneUI.this), paramAnonymousView.field_userId);
          paramAnonymousAdapterView.putExtra("select_raw_user_name", paramAnonymousView.field_userId);
          paramAnonymousAdapterView.putExtra("Select_Conv_User", str);
        }
      }
    });
    this.iWK.setAdapter(this.HGt);
    this.iWK.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(33890);
        o.aFB().cp(paramAnonymousInt);
        AppMethodBeat.o(33890);
      }
    });
    AppMethodBeat.o(33898);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(33897);
    super.onCreate(paramBundle);
    this.fzn = getIntent().getStringExtra("Block_list");
    this.fzo = getIntent().getStringExtra("Chatroom_member_list");
    this.talker = getIntent().getStringExtra("Chat_User");
    this.mTitle = getIntent().getStringExtra("Add_address_titile");
    this.nxq = getIntent().getLongExtra("key_biz_chat_id", -1L);
    this.HGu = af.aCY().bd(this.nxq);
    if (this.HGu == null)
    {
      ac.w("MicroMsg.AtSomeoneUI", "bizChatInfo is null");
      finish();
      AppMethodBeat.o(33897);
      return;
    }
    if ((this.HGu != null) && (this.HGu.field_ownerUserId.equals(u.axw()))) {
      HGv = true;
    }
    initView();
    AppMethodBeat.o(33897);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(33900);
    this.HGt.cVi();
    super.onDestroy();
    AppMethodBeat.o(33900);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(33899);
    super.onPause();
    if (this.fzp != null) {
      this.fzp.ftR();
    }
    AppMethodBeat.o(33899);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
    extends com.tencent.mm.ui.r<com.tencent.mm.al.a.k>
  {
    private com.tencent.mm.al.a.c HGu;
    private String[] HGx;
    private Bitmap HGy;
    private com.tencent.mm.av.a.a.c fze;
    private List<String> fzw;
    String fzx;
    
    public a(Context paramContext, com.tencent.mm.al.a.k paramk, com.tencent.mm.al.a.c paramc, String[] paramArrayOfString, List<String> paramList)
    {
      super(paramk);
      AppMethodBeat.i(33891);
      this.fze = null;
      this.HGu = paramc;
      this.HGx = paramArrayOfString;
      this.fzw = paramList;
      paramk = new c.a();
      paramk.prefixPath = com.tencent.mm.al.a.e.By(this.HGu.field_brandUserName);
      paramk.hKx = true;
      paramk.gKm = true;
      paramk.hKI = 2131690013;
      this.fze = paramk.aFT();
      this.HGy = f.A(paramContext.getResources().getDrawable(2131689712));
      AppMethodBeat.o(33891);
    }
    
    public final boolean GF(int paramInt)
    {
      return false;
    }
    
    public final void Xb()
    {
      AppMethodBeat.i(33894);
      cVi();
      l locall = af.aDa();
      Object localObject2 = this.HGx;
      Object localObject1 = this.fzx;
      List localList = this.fzw;
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
    
    public final void Xc()
    {
      AppMethodBeat.i(33895);
      Xb();
      AppMethodBeat.o(33895);
    }
    
    public final int cRx()
    {
      AppMethodBeat.i(33892);
      if (BizChatAtSomeoneUI.HGv)
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
        paramViewGroup.fAk = ((MaskLayout)paramView.findViewById(2131296957));
        paramViewGroup.fwp = ((TextView)paramView.findViewById(2131296958));
        paramView.setTag(paramViewGroup);
      }
      while ((paramInt == 0) && (BizChatAtSomeoneUI.HGv))
      {
        paramViewGroup.HGz.setImageBitmap(this.HGy);
        paramViewGroup.fwp.setText(this.context.getResources().getString(2131756080, new Object[] { "@" }));
        AppMethodBeat.o(33893);
        return paramView;
        paramViewGroup = (BizChatAtSomeoneUI.b)paramView.getTag();
      }
      if (BizChatAtSomeoneUI.HGv) {}
      for (int i = 1;; i = 0)
      {
        Object localObject = (com.tencent.mm.al.a.k)getItem(paramInt - i);
        paramViewGroup.fwp.setTextColor(com.tencent.mm.cc.a.m(this.context, 2131100638));
        ImageView localImageView = (ImageView)paramViewGroup.fAk.getContentView();
        o.aFB().a(((com.tencent.mm.al.a.k)localObject).field_headImageUrl, localImageView, this.fze);
        paramViewGroup.fAk.setMaskDrawable(null);
        localObject = BizChatAtSomeoneUI.a(this.HGu, ((com.tencent.mm.al.a.k)localObject).field_userId);
        paramViewGroup.fwp.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.context, (CharSequence)localObject, paramViewGroup.fwp.getTextSize()));
        AppMethodBeat.o(33893);
        return paramView;
      }
    }
  }
  
  static final class b
  {
    public ImageView HGz;
    public MaskLayout fAk;
    public TextView fwp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatAtSomeoneUI
 * JD-Core Version:    0.7.0.1
 */