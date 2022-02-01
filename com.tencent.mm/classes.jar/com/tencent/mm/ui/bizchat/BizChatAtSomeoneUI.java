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
import com.tencent.mm.al.ag;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.v;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.tools.r.b;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BizChatAtSomeoneUI
  extends MMActivity
{
  private static boolean JPb = false;
  private a JOZ;
  private com.tencent.mm.al.a.c JPa;
  private String fUG;
  private String fUH;
  private com.tencent.mm.ui.tools.r fUI;
  private ListView jsM;
  private String mTitle;
  private long oex;
  private String talker;
  
  protected static String a(com.tencent.mm.al.a.c paramc, String paramString)
  {
    AppMethodBeat.i(33901);
    if (paramc == null)
    {
      AppMethodBeat.o(33901);
      return null;
    }
    paramc = paramc.zP(paramString);
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
    this.fUI = new com.tencent.mm.ui.tools.r((byte)0);
    this.fUI.Lhk = new r.b()
    {
      public final boolean JO(String paramAnonymousString)
      {
        return false;
      }
      
      public final void JP(String paramAnonymousString)
      {
        AppMethodBeat.i(33888);
        BizChatAtSomeoneUI.a locala = BizChatAtSomeoneUI.a(BizChatAtSomeoneUI.this);
        locala.fUS = paramAnonymousString;
        locala.a(null, null);
        AppMethodBeat.o(33888);
      }
      
      public final void aSL() {}
      
      public final void aSM() {}
      
      public final void aSN() {}
      
      public final void aSO() {}
    };
    addSearchMenu(true, this.fUI);
    this.jsM = ((ListView)findViewById(2131297967));
    com.tencent.mm.al.a.k localk = new com.tencent.mm.al.a.k();
    com.tencent.mm.al.a.c localc = this.JPa;
    String[] arrayOfString = null;
    if (!bu.isNullOrNil(this.fUH))
    {
      arrayOfString = this.fUH.split(";");
      ae.d("MicroMsg.AtSomeoneUI", "chatroom members name=[%s]", new Object[] { Arrays.toString(arrayOfString) });
    }
    Object localObject = new LinkedList();
    if (!bu.isNullOrNil(this.fUG)) {
      localObject = bu.U(this.fUG.split(";"));
    }
    this.JOZ = new a(this, localk, localc, arrayOfString, (List)localObject);
    this.jsM.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(33889);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousAdapterView);
        ((b)localObject).bd(paramAnonymousView);
        ((b)localObject).mu(paramAnonymousInt);
        ((b)localObject).rl(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/bizchat/BizChatAtSomeoneUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((b)localObject).ahF());
        paramAnonymousAdapterView = new Intent();
        if ((paramAnonymousInt == 0) && (BizChatAtSomeoneUI.JPb))
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
          paramAnonymousView = (com.tencent.mm.al.a.k)BizChatAtSomeoneUI.a(BizChatAtSomeoneUI.this).getItem(paramAnonymousInt);
          localObject = BizChatAtSomeoneUI.a(BizChatAtSomeoneUI.b(BizChatAtSomeoneUI.this), paramAnonymousView.field_userId);
          paramAnonymousAdapterView.putExtra("select_raw_user_name", paramAnonymousView.field_userId);
          paramAnonymousAdapterView.putExtra("Select_Conv_User", (String)localObject);
        }
      }
    });
    this.jsM.setAdapter(this.JOZ);
    this.jsM.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(33890);
        q.aJb().cp(paramAnonymousInt);
        AppMethodBeat.o(33890);
      }
    });
    AppMethodBeat.o(33898);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(33897);
    super.onCreate(paramBundle);
    this.fUG = getIntent().getStringExtra("Block_list");
    this.fUH = getIntent().getStringExtra("Chatroom_member_list");
    this.talker = getIntent().getStringExtra("Chat_User");
    this.mTitle = getIntent().getStringExtra("Add_address_titile");
    this.oex = getIntent().getLongExtra("key_biz_chat_id", -1L);
    this.JPa = ag.aGr().bd(this.oex);
    if (this.JPa == null)
    {
      ae.w("MicroMsg.AtSomeoneUI", "bizChatInfo is null");
      finish();
      AppMethodBeat.o(33897);
      return;
    }
    if ((this.JPa != null) && (this.JPa.field_ownerUserId.equals(v.aAC()))) {
      JPb = true;
    }
    initView();
    AppMethodBeat.o(33897);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(33900);
    this.JOZ.dhl();
    super.onDestroy();
    AppMethodBeat.o(33900);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(33899);
    super.onPause();
    if (this.fUI != null) {
      this.fUI.fOV();
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
    private com.tencent.mm.al.a.c JPa;
    private String[] JPd;
    private Bitmap JPe;
    private List<String> fUR;
    String fUS;
    private com.tencent.mm.av.a.a.c fUx;
    
    public a(Context paramContext, com.tencent.mm.al.a.k paramk, com.tencent.mm.al.a.c paramc, String[] paramArrayOfString, List<String> paramList)
    {
      super(paramk);
      AppMethodBeat.i(33891);
      this.fUx = null;
      this.JPa = paramc;
      this.JPd = paramArrayOfString;
      this.fUR = paramList;
      paramk = new c.a();
      paramk.prefixPath = com.tencent.mm.al.a.e.EZ(this.JPa.field_brandUserName);
      paramk.igk = true;
      paramk.hgL = true;
      paramk.igv = 2131690013;
      this.fUx = paramk.aJu();
      this.JPe = h.B(paramContext.getResources().getDrawable(2131689712));
      AppMethodBeat.o(33891);
    }
    
    public final boolean Iw(int paramInt)
    {
      return false;
    }
    
    public final void ZD()
    {
      AppMethodBeat.i(33894);
      dhl();
      l locall = ag.aGt();
      Object localObject2 = this.JPd;
      Object localObject1 = this.fUS;
      List localList = this.fUR;
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
    
    public final void ZE()
    {
      AppMethodBeat.i(33895);
      ZD();
      AppMethodBeat.o(33895);
    }
    
    public final int dcN()
    {
      AppMethodBeat.i(33892);
      if (BizChatAtSomeoneUI.JPb)
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
        paramViewGroup.fVG = ((MaskLayout)paramView.findViewById(2131296957));
        paramViewGroup.fRI = ((TextView)paramView.findViewById(2131296958));
        paramView.setTag(paramViewGroup);
      }
      while ((paramInt == 0) && (BizChatAtSomeoneUI.JPb))
      {
        paramViewGroup.JPf.setImageBitmap(this.JPe);
        paramViewGroup.fRI.setText(this.context.getResources().getString(2131756080, new Object[] { "@" }));
        AppMethodBeat.o(33893);
        return paramView;
        paramViewGroup = (BizChatAtSomeoneUI.b)paramView.getTag();
      }
      if (BizChatAtSomeoneUI.JPb) {}
      for (int i = 1;; i = 0)
      {
        Object localObject = (com.tencent.mm.al.a.k)getItem(paramInt - i);
        paramViewGroup.fRI.setTextColor(com.tencent.mm.cb.a.m(this.context, 2131100638));
        ImageView localImageView = (ImageView)paramViewGroup.fVG.getContentView();
        q.aJb().a(((com.tencent.mm.al.a.k)localObject).field_headImageUrl, localImageView, this.fUx);
        paramViewGroup.fVG.setMaskDrawable(null);
        localObject = BizChatAtSomeoneUI.a(this.JPa, ((com.tencent.mm.al.a.k)localObject).field_userId);
        paramViewGroup.fRI.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.context, (CharSequence)localObject, paramViewGroup.fRI.getTextSize()));
        AppMethodBeat.o(33893);
        return paramView;
      }
    }
  }
  
  static final class b
  {
    public ImageView JPf;
    public TextView fRI;
    public MaskLayout fVG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatAtSomeoneUI
 * JD-Core Version:    0.7.0.1
 */