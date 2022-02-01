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
import com.tencent.mm.al.a.e;
import com.tencent.mm.al.a.k;
import com.tencent.mm.al.ag;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.tools.s.b;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BizChatAtSomeoneUI
  extends MMActivity
{
  private static boolean Pah = false;
  private a Paf;
  private com.tencent.mm.al.a.c Pag;
  private String gzN;
  private String gzO;
  private com.tencent.mm.ui.tools.s gzP;
  private ListView krb;
  private String mTitle;
  private long ppv;
  private String talker;
  
  protected static String a(com.tencent.mm.al.a.c paramc, String paramString)
  {
    AppMethodBeat.i(33901);
    if (paramc == null)
    {
      AppMethodBeat.o(33901);
      return null;
    }
    paramc = paramc.getDisplayName(paramString);
    AppMethodBeat.o(33901);
    return paramc;
  }
  
  public int getLayoutId()
  {
    return 2131493158;
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
    this.gzP = new com.tencent.mm.ui.tools.s((byte)0);
    this.gzP.Qwi = new s.b()
    {
      public final boolean SN(String paramAnonymousString)
      {
        return false;
      }
      
      public final void SO(String paramAnonymousString)
      {
        AppMethodBeat.i(33888);
        BizChatAtSomeoneUI.a locala = BizChatAtSomeoneUI.a(BizChatAtSomeoneUI.this);
        locala.gzZ = paramAnonymousString;
        locala.onNotifyChange(null, null);
        AppMethodBeat.o(33888);
      }
      
      public final void bnA() {}
      
      public final void bnB() {}
      
      public final void bny() {}
      
      public final void bnz() {}
    };
    addSearchMenu(true, this.gzP);
    this.krb = ((ListView)findViewById(2131298305));
    k localk = new k();
    com.tencent.mm.al.a.c localc = this.Pag;
    String[] arrayOfString = null;
    if (!Util.isNullOrNil(this.gzO))
    {
      arrayOfString = this.gzO.split(";");
      Log.d("MicroMsg.AtSomeoneUI", "chatroom members name=[%s]", new Object[] { Arrays.toString(arrayOfString) });
    }
    Object localObject = new LinkedList();
    if (!Util.isNullOrNil(this.gzN)) {
      localObject = Util.stringsToList(this.gzN.split(";"));
    }
    this.Paf = new a(this, localk, localc, arrayOfString, (List)localObject);
    this.krb.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(33889);
        Object localObject = new b();
        ((b)localObject).bm(paramAnonymousAdapterView);
        ((b)localObject).bm(paramAnonymousView);
        ((b)localObject).pH(paramAnonymousInt);
        ((b)localObject).zo(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/bizchat/BizChatAtSomeoneUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((b)localObject).axR());
        paramAnonymousAdapterView = new Intent();
        if ((paramAnonymousInt == 0) && (BizChatAtSomeoneUI.Pah))
        {
          paramAnonymousAdapterView.putExtra("Select_Conv_User", BizChatAtSomeoneUI.this.getString(2131756210, new Object[] { "" }));
          paramAnonymousAdapterView.putExtra("select_raw_user_name", "notify@all");
        }
        for (;;)
        {
          BizChatAtSomeoneUI.this.setResult(-1, paramAnonymousAdapterView);
          BizChatAtSomeoneUI.this.finish();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/bizchat/BizChatAtSomeoneUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(33889);
          return;
          paramAnonymousView = (k)BizChatAtSomeoneUI.a(BizChatAtSomeoneUI.this).getItem(paramAnonymousInt);
          localObject = BizChatAtSomeoneUI.a(BizChatAtSomeoneUI.b(BizChatAtSomeoneUI.this), paramAnonymousView.field_userId);
          paramAnonymousAdapterView.putExtra("select_raw_user_name", paramAnonymousView.field_userId);
          paramAnonymousAdapterView.putExtra("Select_Conv_User", (String)localObject);
        }
      }
    });
    this.krb.setAdapter(this.Paf);
    this.krb.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(33890);
        q.bcV().onScrollStateChanged(paramAnonymousInt);
        AppMethodBeat.o(33890);
      }
    });
    AppMethodBeat.o(33898);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(33897);
    super.onCreate(paramBundle);
    this.gzN = getIntent().getStringExtra("Block_list");
    this.gzO = getIntent().getStringExtra("Chatroom_member_list");
    this.talker = getIntent().getStringExtra("Chat_User");
    this.mTitle = getIntent().getStringExtra("Add_address_titile");
    this.ppv = getIntent().getLongExtra("key_biz_chat_id", -1L);
    this.Pag = ag.baj().bs(this.ppv);
    if (this.Pag == null)
    {
      Log.w("MicroMsg.AtSomeoneUI", "bizChatInfo is null");
      finish();
      AppMethodBeat.o(33897);
      return;
    }
    if ((this.Pag != null) && (this.Pag.field_ownerUserId.equals(z.aTY()))) {
      Pah = true;
    }
    initView();
    AppMethodBeat.o(33897);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(33900);
    this.Paf.ebf();
    super.onDestroy();
    AppMethodBeat.o(33900);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(33899);
    super.onPause();
    if (this.gzP != null) {
      this.gzP.gXP();
    }
    AppMethodBeat.o(33899);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
    extends com.tencent.mm.ui.s<k>
  {
    private com.tencent.mm.al.a.c Pag;
    private String[] Paj;
    private Bitmap Pak;
    private com.tencent.mm.av.a.a.c gzE;
    private List<String> gzY;
    String gzZ;
    
    public a(Context paramContext, k paramk, com.tencent.mm.al.a.c paramc, String[] paramArrayOfString, List<String> paramList)
    {
      super(paramk);
      AppMethodBeat.i(33891);
      this.gzE = null;
      this.Pag = paramc;
      this.Paj = paramArrayOfString;
      this.gzY = paramList;
      paramk = new c.a();
      paramk.prefixPath = e.NN(this.Pag.field_brandUserName);
      paramk.jbf = true;
      paramk.hZF = true;
      paramk.jbq = 2131690042;
      this.gzE = paramk.bdv();
      this.Pak = BitmapUtil.transformDrawableToBitmap(paramContext.getResources().getDrawable(2131689719));
      AppMethodBeat.o(33891);
    }
    
    public final boolean Ox(int paramInt)
    {
      return false;
    }
    
    public final void anp()
    {
      AppMethodBeat.i(33894);
      ebf();
      com.tencent.mm.al.a.l locall = ag.bal();
      Object localObject2 = this.Paj;
      Object localObject1 = this.gzZ;
      List localList = this.gzY;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("select *  from BizChatUserInfo where ");
      localObject2 = localStringBuilder.append(com.tencent.mm.al.a.l.a((String[])localObject2, localList));
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
    
    public final void anq()
    {
      AppMethodBeat.i(33895);
      anp();
      AppMethodBeat.o(33895);
    }
    
    public final int dWu()
    {
      AppMethodBeat.i(33892);
      if (BizChatAtSomeoneUI.Pah)
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
        paramView = View.inflate(this.context, 2131493157, null);
        paramViewGroup = new BizChatAtSomeoneUI.b((byte)0);
        paramViewGroup.gAN = ((MaskLayout)paramView.findViewById(2131297066));
        paramViewGroup.gwR = ((TextView)paramView.findViewById(2131297067));
        paramView.setTag(paramViewGroup);
      }
      while ((paramInt == 0) && (BizChatAtSomeoneUI.Pah))
      {
        paramViewGroup.Pal.setImageBitmap(this.Pak);
        paramViewGroup.gwR.setText(this.context.getResources().getString(2131756210, new Object[] { "@" }));
        AppMethodBeat.o(33893);
        return paramView;
        paramViewGroup = (BizChatAtSomeoneUI.b)paramView.getTag();
      }
      if (BizChatAtSomeoneUI.Pah) {}
      for (int i = 1;; i = 0)
      {
        Object localObject = (k)getItem(paramInt - i);
        paramViewGroup.gwR.setTextColor(com.tencent.mm.cb.a.m(this.context, 2131100808));
        ImageView localImageView = (ImageView)paramViewGroup.gAN.getContentView();
        q.bcV().a(((k)localObject).field_headImageUrl, localImageView, this.gzE);
        paramViewGroup.gAN.setMaskDrawable(null);
        localObject = BizChatAtSomeoneUI.a(this.Pag, ((k)localObject).field_userId);
        paramViewGroup.gwR.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.context, (CharSequence)localObject, paramViewGroup.gwR.getTextSize()));
        AppMethodBeat.o(33893);
        return paramView;
      }
    }
  }
  
  static final class b
  {
    public ImageView Pal;
    public MaskLayout gAN;
    public TextView gwR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatAtSomeoneUI
 * JD-Core Version:    0.7.0.1
 */