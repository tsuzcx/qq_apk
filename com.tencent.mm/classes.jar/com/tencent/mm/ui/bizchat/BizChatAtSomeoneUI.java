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
import com.tencent.mm.am.af;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.aw.o;
import com.tencent.mm.model.u;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.tools.r;
import com.tencent.mm.ui.tools.r.b;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BizChatAtSomeoneUI
  extends MMActivity
{
  private static boolean GgF = false;
  private a GgD;
  private com.tencent.mm.am.a.c GgE;
  private String fvG;
  private String fvH;
  private r fvI;
  private ListView iwH;
  private String mTitle;
  private long mUQ;
  private String talker;
  
  protected static String a(com.tencent.mm.am.a.c paramc, String paramString)
  {
    AppMethodBeat.i(33901);
    if (paramc == null)
    {
      AppMethodBeat.o(33901);
      return null;
    }
    paramc = paramc.sh(paramString);
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
    this.fvI = new r((byte)0);
    this.fvI.Htp = new r.b()
    {
      public final boolean BX(String paramAnonymousString)
      {
        return false;
      }
      
      public final void BY(String paramAnonymousString)
      {
        AppMethodBeat.i(33888);
        BizChatAtSomeoneUI.a locala = BizChatAtSomeoneUI.a(BizChatAtSomeoneUI.this);
        locala.fvQ = paramAnonymousString;
        locala.a(null, null);
        AppMethodBeat.o(33888);
      }
      
      public final void aIj() {}
      
      public final void aIk() {}
      
      public final void aIl() {}
      
      public final void aIm() {}
    };
    addSearchMenu(true, this.fvI);
    this.iwH = ((ListView)findViewById(2131297967));
    com.tencent.mm.am.a.k localk = new com.tencent.mm.am.a.k();
    com.tencent.mm.am.a.c localc = this.GgE;
    String[] arrayOfString = null;
    if (!bt.isNullOrNil(this.fvH))
    {
      arrayOfString = this.fvH.split(";");
      ad.d("MicroMsg.AtSomeoneUI", "chatroom members name=[%s]", new Object[] { Arrays.toString(arrayOfString) });
    }
    Object localObject = new LinkedList();
    if (!bt.isNullOrNil(this.fvG)) {
      localObject = bt.S(this.fvG.split(";"));
    }
    this.GgD = new a(this, localk, localc, arrayOfString, (List)localObject);
    this.iwH.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(33889);
        paramAnonymousAdapterView = new Intent();
        if ((paramAnonymousInt == 0) && (BizChatAtSomeoneUI.GgF))
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
          paramAnonymousView = (com.tencent.mm.am.a.k)BizChatAtSomeoneUI.a(BizChatAtSomeoneUI.this).getItem(paramAnonymousInt);
          String str = BizChatAtSomeoneUI.a(BizChatAtSomeoneUI.b(BizChatAtSomeoneUI.this), paramAnonymousView.field_userId);
          paramAnonymousAdapterView.putExtra("select_raw_user_name", paramAnonymousView.field_userId);
          paramAnonymousAdapterView.putExtra("Select_Conv_User", str);
        }
      }
    });
    this.iwH.setAdapter(this.GgD);
    this.iwH.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(33890);
        o.ayJ().cq(paramAnonymousInt);
        AppMethodBeat.o(33890);
      }
    });
    AppMethodBeat.o(33898);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(33897);
    super.onCreate(paramBundle);
    this.fvG = getIntent().getStringExtra("Block_list");
    this.fvH = getIntent().getStringExtra("Chatroom_member_list");
    this.talker = getIntent().getStringExtra("Chat_User");
    this.mTitle = getIntent().getStringExtra("Add_address_titile");
    this.mUQ = getIntent().getLongExtra("key_biz_chat_id", -1L);
    this.GgE = af.awg().bg(this.mUQ);
    if (this.GgE == null)
    {
      ad.w("MicroMsg.AtSomeoneUI", "bizChatInfo is null");
      finish();
      AppMethodBeat.o(33897);
      return;
    }
    if ((this.GgE != null) && (this.GgE.field_ownerUserId.equals(u.aqG()))) {
      GgF = true;
    }
    initView();
    AppMethodBeat.o(33897);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(33900);
    this.GgD.cHX();
    super.onDestroy();
    AppMethodBeat.o(33900);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(33899);
    super.onPause();
    if (this.fvI != null) {
      this.fvI.fdW();
    }
    AppMethodBeat.o(33899);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
    extends q<com.tencent.mm.am.a.k>
  {
    private com.tencent.mm.am.a.c GgE;
    private String[] GgH;
    private Bitmap GgI;
    private List<String> fvP;
    String fvQ;
    private com.tencent.mm.aw.a.a.c fvx;
    
    public a(Context paramContext, com.tencent.mm.am.a.k paramk, com.tencent.mm.am.a.c paramc, String[] paramArrayOfString, List<String> paramList)
    {
      super(paramk);
      AppMethodBeat.i(33891);
      this.fvx = null;
      this.GgE = paramc;
      this.GgH = paramArrayOfString;
      this.fvP = paramList;
      paramk = new c.a();
      paramk.prefixPath = com.tencent.mm.am.a.e.xs(this.GgE.field_brandUserName);
      paramk.hjU = true;
      paramk.gjA = true;
      paramk.hkf = 2131690013;
      this.fvx = paramk.azc();
      this.GgI = f.B(paramContext.getResources().getDrawable(2131689712));
      AppMethodBeat.o(33891);
    }
    
    public final boolean EJ(int paramInt)
    {
      return false;
    }
    
    public final void Wd()
    {
      AppMethodBeat.i(33894);
      cHX();
      l locall = af.awi();
      Object localObject2 = this.GgH;
      Object localObject1 = this.fvQ;
      List localList = this.fvP;
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
    
    public final void We()
    {
      AppMethodBeat.i(33895);
      Wd();
      AppMethodBeat.o(33895);
    }
    
    public final int cEn()
    {
      AppMethodBeat.i(33892);
      if (BizChatAtSomeoneUI.GgF)
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
        paramViewGroup.fwD = ((MaskLayout)paramView.findViewById(2131296957));
        paramViewGroup.fsI = ((TextView)paramView.findViewById(2131296958));
        paramView.setTag(paramViewGroup);
      }
      while ((paramInt == 0) && (BizChatAtSomeoneUI.GgF))
      {
        paramViewGroup.GgJ.setImageBitmap(this.GgI);
        paramViewGroup.fsI.setText(this.context.getResources().getString(2131756080, new Object[] { "@" }));
        AppMethodBeat.o(33893);
        return paramView;
        paramViewGroup = (BizChatAtSomeoneUI.b)paramView.getTag();
      }
      if (BizChatAtSomeoneUI.GgF) {}
      for (int i = 1;; i = 0)
      {
        Object localObject = (com.tencent.mm.am.a.k)getItem(paramInt - i);
        paramViewGroup.fsI.setTextColor(com.tencent.mm.cd.a.m(this.context, 2131100638));
        ImageView localImageView = (ImageView)paramViewGroup.fwD.getContentView();
        o.ayJ().a(((com.tencent.mm.am.a.k)localObject).field_headImageUrl, localImageView, this.fvx);
        paramViewGroup.fwD.setMaskDrawable(null);
        localObject = BizChatAtSomeoneUI.a(this.GgE, ((com.tencent.mm.am.a.k)localObject).field_userId);
        paramViewGroup.fsI.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.context, (CharSequence)localObject, paramViewGroup.fsI.getTextSize()));
        AppMethodBeat.o(33893);
        return paramView;
      }
    }
  }
  
  static final class b
  {
    public ImageView GgJ;
    public TextView fsI;
    public MaskLayout fwD;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatAtSomeoneUI
 * JD-Core Version:    0.7.0.1
 */