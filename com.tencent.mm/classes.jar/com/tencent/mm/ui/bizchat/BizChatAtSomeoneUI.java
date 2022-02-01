package com.tencent.mm.ui.bizchat;

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
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.an.a.d;
import com.tencent.mm.an.a.e;
import com.tencent.mm.an.a.k;
import com.tencent.mm.an.a.l;
import com.tencent.mm.an.af;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.z;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.tools.s;
import com.tencent.mm.ui.tools.s.c;
import com.tencent.mm.ui.x;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BizChatAtSomeoneUI
  extends MMActivity
{
  private static boolean aeaN = false;
  private a aeaL;
  private com.tencent.mm.an.a.c aeaM;
  private String lMu;
  private String lMv;
  private s lMw;
  private String mTitle;
  private ListView qgc;
  private String talker;
  private long vEb;
  
  protected static String a(com.tencent.mm.an.a.c paramc, String paramString)
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
    return R.i.geu;
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
    this.lMw = new s(true);
    this.lMw.afKz = new s.c()
    {
      public final boolean SN(String paramAnonymousString)
      {
        return false;
      }
      
      public final void SO(String paramAnonymousString)
      {
        AppMethodBeat.i(33888);
        BizChatAtSomeoneUI.a locala = BizChatAtSomeoneUI.a(BizChatAtSomeoneUI.this);
        locala.lMG = paramAnonymousString;
        locala.onNotifyChange(null, null);
        AppMethodBeat.o(33888);
      }
      
      public final void bWw() {}
      
      public final void bWx() {}
      
      public final void bWy() {}
      
      public final void bWz() {}
    };
    addSearchMenu(true, this.lMw);
    this.qgc = ((ListView)findViewById(R.h.fvH));
    k localk = new k();
    com.tencent.mm.an.a.c localc = this.aeaM;
    String[] arrayOfString = null;
    if (!Util.isNullOrNil(this.lMv))
    {
      arrayOfString = this.lMv.split(";");
      Log.d("MicroMsg.AtSomeoneUI", "chatroom members name=[%s]", new Object[] { Arrays.toString(arrayOfString) });
    }
    Object localObject = new LinkedList();
    if (!Util.isNullOrNil(this.lMu)) {
      localObject = Util.stringsToList(this.lMu.split(";"));
    }
    this.aeaL = new a(this, localk, localc, arrayOfString, (List)localObject);
    this.qgc.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(33889);
        Object localObject = new b();
        ((b)localObject).cH(paramAnonymousAdapterView);
        ((b)localObject).cH(paramAnonymousView);
        ((b)localObject).sc(paramAnonymousInt);
        ((b)localObject).hB(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/bizchat/BizChatAtSomeoneUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((b)localObject).aYj());
        paramAnonymousAdapterView = new Intent();
        if ((paramAnonymousInt == 0) && (BizChatAtSomeoneUI.aeaN))
        {
          paramAnonymousAdapterView.putExtra("Select_Conv_User", BizChatAtSomeoneUI.this.getString(R.l.gsi, new Object[] { "" }));
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
    this.qgc.setAdapter(this.aeaL);
    this.qgc.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(33890);
        r.bKe().onScrollStateChanged(paramAnonymousInt);
        AppMethodBeat.o(33890);
      }
    });
    AppMethodBeat.o(33898);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(33897);
    super.onCreate(paramBundle);
    this.lMu = getIntent().getStringExtra("Block_list");
    this.lMv = getIntent().getStringExtra("Chatroom_member_list");
    this.talker = getIntent().getStringExtra("Chat_User");
    this.mTitle = getIntent().getStringExtra("Add_address_titile");
    this.vEb = getIntent().getLongExtra("key_biz_chat_id", -1L);
    this.aeaM = af.bHh().dW(this.vEb);
    if (this.aeaM == null)
    {
      Log.w("MicroMsg.AtSomeoneUI", "bizChatInfo is null");
      finish();
      AppMethodBeat.o(33897);
      return;
    }
    if ((this.aeaM != null) && (this.aeaM.field_ownerUserId.equals(z.bAM()))) {
      aeaN = true;
    }
    initView();
    AppMethodBeat.o(33897);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(33900);
    this.aeaL.fSd();
    super.onDestroy();
    AppMethodBeat.o(33900);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(33899);
    super.onPause();
    if (this.lMw != null) {
      this.lMw.jyO();
    }
    AppMethodBeat.o(33899);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
    extends x<k>
  {
    private com.tencent.mm.an.a.c aeaM;
    private String[] aeaP;
    private Bitmap aeaQ;
    private List<String> lMF;
    String lMG;
    private com.tencent.mm.modelimage.loader.a.c lMm;
    
    public a(Context paramContext, k paramk, com.tencent.mm.an.a.c paramc, String[] paramArrayOfString, List<String> paramList)
    {
      super(paramk);
      AppMethodBeat.i(33891);
      this.lMm = null;
      this.aeaM = paramc;
      this.aeaP = paramArrayOfString;
      this.lMF = paramList;
      paramk = new c.a();
      paramk.prefixPath = e.Ni(this.aeaM.field_brandUserName);
      paramk.oKp = true;
      paramk.nqa = true;
      paramk.oKB = R.k.default_avatar;
      this.lMm = paramk.bKx();
      this.aeaQ = BitmapUtil.transformDrawableToBitmap(paramContext.getResources().getDrawable(R.k.at_all_avater));
      AppMethodBeat.o(33891);
    }
    
    public final boolean XL(int paramInt)
    {
      return false;
    }
    
    public final void aNy()
    {
      AppMethodBeat.i(33894);
      fSd();
      l locall = af.bHj();
      Object localObject2 = this.aeaP;
      Object localObject1 = this.lMG;
      List localList = this.lMF;
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
        w(locall.db.rawQuery(localStringBuilder.toString(), null));
        super.notifyDataSetChanged();
        AppMethodBeat.o(33894);
        return;
      }
    }
    
    public final void aNz()
    {
      AppMethodBeat.i(33895);
      aNy();
      AppMethodBeat.o(33895);
    }
    
    public final int fHy()
    {
      AppMethodBeat.i(33892);
      if (BizChatAtSomeoneUI.aeaN)
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
        paramView = View.inflate(this.context, R.i.get, null);
        paramViewGroup = new BizChatAtSomeoneUI.b((byte)0);
        paramViewGroup.lNy = ((MaskLayout)paramView.findViewById(R.h.at_someone_item_avatar));
        paramViewGroup.lDe = ((TextView)paramView.findViewById(R.h.at_someone_item_nick));
        paramView.setTag(paramViewGroup);
      }
      while ((paramInt == 0) && (BizChatAtSomeoneUI.aeaN))
      {
        paramViewGroup.aeaR.setImageBitmap(this.aeaQ);
        paramViewGroup.lDe.setText(this.context.getResources().getString(R.l.gsi, new Object[] { "@" }));
        AppMethodBeat.o(33893);
        return paramView;
        paramViewGroup = (BizChatAtSomeoneUI.b)paramView.getTag();
      }
      if (BizChatAtSomeoneUI.aeaN) {}
      for (int i = 1;; i = 0)
      {
        Object localObject = (k)getItem(paramInt - i);
        paramViewGroup.lDe.setTextColor(com.tencent.mm.cd.a.l(this.context, R.e.mm_list_textcolor_one));
        ImageView localImageView = (ImageView)paramViewGroup.lNy.getContentView();
        r.bKe().a(((k)localObject).field_headImageUrl, localImageView, this.lMm);
        paramViewGroup.lNy.setMaskDrawable(null);
        localObject = BizChatAtSomeoneUI.a(this.aeaM, ((k)localObject).field_userId);
        paramViewGroup.lDe.setText(p.b(this.context, (CharSequence)localObject, paramViewGroup.lDe.getTextSize()));
        AppMethodBeat.o(33893);
        return paramView;
      }
    }
  }
  
  static final class b
  {
    public ImageView aeaR;
    public TextView lDe;
    public MaskLayout lNy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatAtSomeoneUI
 * JD-Core Version:    0.7.0.1
 */