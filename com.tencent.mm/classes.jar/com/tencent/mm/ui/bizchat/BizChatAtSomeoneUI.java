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
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ao.a.d;
import com.tencent.mm.ao.a.e;
import com.tencent.mm.ao.a.k;
import com.tencent.mm.ao.af;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.ay.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.tools.t;
import com.tencent.mm.ui.tools.t.b;
import com.tencent.mm.ui.v;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BizChatAtSomeoneUI
  extends MMActivity
{
  private static boolean Wtu = false;
  private a Wts;
  private com.tencent.mm.ao.a.c Wtt;
  private String jjQ;
  private String jjR;
  private t jjS;
  private String mTitle;
  private ListView niO;
  private long syu;
  private String talker;
  
  protected static String a(com.tencent.mm.ao.a.c paramc, String paramString)
  {
    AppMethodBeat.i(33901);
    if (paramc == null)
    {
      AppMethodBeat.o(33901);
      return null;
    }
    paramc = paramc.PJ(paramString);
    AppMethodBeat.o(33901);
    return paramc;
  }
  
  public int getLayoutId()
  {
    return R.i.ebM;
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
    this.jjS = new t((byte)0);
    this.jjS.XUl = new t.b()
    {
      public final boolean aat(String paramAnonymousString)
      {
        return false;
      }
      
      public final void aau(String paramAnonymousString)
      {
        AppMethodBeat.i(33888);
        BizChatAtSomeoneUI.a locala = BizChatAtSomeoneUI.a(BizChatAtSomeoneUI.this);
        locala.jkc = paramAnonymousString;
        locala.onNotifyChange(null, null);
        AppMethodBeat.o(33888);
      }
      
      public final void bxH() {}
      
      public final void bxI() {}
      
      public final void bxJ() {}
      
      public final void bxK() {}
    };
    addSearchMenu(true, this.jjS);
    this.niO = ((ListView)findViewById(R.h.dvq));
    k localk = new k();
    com.tencent.mm.ao.a.c localc = this.Wtt;
    String[] arrayOfString = null;
    if (!Util.isNullOrNil(this.jjR))
    {
      arrayOfString = this.jjR.split(";");
      Log.d("MicroMsg.AtSomeoneUI", "chatroom members name=[%s]", new Object[] { Arrays.toString(arrayOfString) });
    }
    Object localObject = new LinkedList();
    if (!Util.isNullOrNil(this.jjQ)) {
      localObject = Util.stringsToList(this.jjQ.split(";"));
    }
    this.Wts = new a(this, localk, localc, arrayOfString, (List)localObject);
    this.niO.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(33889);
        Object localObject = new b();
        ((b)localObject).bn(paramAnonymousAdapterView);
        ((b)localObject).bn(paramAnonymousView);
        ((b)localObject).sg(paramAnonymousInt);
        ((b)localObject).Fs(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/bizchat/BizChatAtSomeoneUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((b)localObject).aFi());
        paramAnonymousAdapterView = new Intent();
        if ((paramAnonymousInt == 0) && (BizChatAtSomeoneUI.Wtu))
        {
          paramAnonymousAdapterView.putExtra("Select_Conv_User", BizChatAtSomeoneUI.this.getString(R.l.eph, new Object[] { "" }));
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
    this.niO.setAdapter(this.Wts);
    this.niO.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(33890);
        q.bml().onScrollStateChanged(paramAnonymousInt);
        AppMethodBeat.o(33890);
      }
    });
    AppMethodBeat.o(33898);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(33897);
    super.onCreate(paramBundle);
    this.jjQ = getIntent().getStringExtra("Block_list");
    this.jjR = getIntent().getStringExtra("Chatroom_member_list");
    this.talker = getIntent().getStringExtra("Chat_User");
    this.mTitle = getIntent().getStringExtra("Add_address_titile");
    this.syu = getIntent().getLongExtra("key_biz_chat_id", -1L);
    this.Wtt = af.bjx().bF(this.syu);
    if (this.Wtt == null)
    {
      Log.w("MicroMsg.AtSomeoneUI", "bizChatInfo is null");
      finish();
      AppMethodBeat.o(33897);
      return;
    }
    if ((this.Wtt != null) && (this.Wtt.field_ownerUserId.equals(z.bcZ()))) {
      Wtu = true;
    }
    initView();
    AppMethodBeat.o(33897);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(33900);
    this.Wts.eKd();
    super.onDestroy();
    AppMethodBeat.o(33900);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(33899);
    super.onPause();
    if (this.jjS != null) {
      this.jjS.hVb();
    }
    AppMethodBeat.o(33899);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
    extends v<k>
  {
    private com.tencent.mm.ao.a.c Wtt;
    private String[] Wtw;
    private Bitmap Wtx;
    private com.tencent.mm.ay.a.a.c jjH;
    private List<String> jkb;
    String jkc;
    
    public a(Context paramContext, k paramk, com.tencent.mm.ao.a.c paramc, String[] paramArrayOfString, List<String> paramList)
    {
      super(paramk);
      AppMethodBeat.i(33891);
      this.jjH = null;
      this.Wtt = paramc;
      this.Wtw = paramArrayOfString;
      this.jkb = paramList;
      paramk = new c.a();
      paramk.prefixPath = e.Vj(this.Wtt.field_brandUserName);
      paramk.lRD = true;
      paramk.kOl = true;
      paramk.lRP = R.k.default_avatar;
      this.jjH = paramk.bmL();
      this.Wtx = BitmapUtil.transformDrawableToBitmap(paramContext.getResources().getDrawable(R.k.at_all_avater));
      AppMethodBeat.o(33891);
    }
    
    public final boolean TR(int paramInt)
    {
      return false;
    }
    
    public final void atr()
    {
      AppMethodBeat.i(33894);
      eKd();
      com.tencent.mm.ao.a.l locall = af.bjz();
      Object localObject2 = this.Wtw;
      Object localObject1 = this.jkc;
      List localList = this.jkb;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("select *  from BizChatUserInfo where ");
      localObject2 = localStringBuilder.append(com.tencent.mm.ao.a.l.a((String[])localObject2, localList));
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
        v(locall.db.rawQuery(localStringBuilder.toString(), null));
        super.notifyDataSetChanged();
        AppMethodBeat.o(33894);
        return;
      }
    }
    
    public final void ats()
    {
      AppMethodBeat.i(33895);
      atr();
      AppMethodBeat.o(33895);
    }
    
    public final int ezA()
    {
      AppMethodBeat.i(33892);
      if (BizChatAtSomeoneUI.Wtu)
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
        paramView = View.inflate(this.context, R.i.ebL, null);
        paramViewGroup = new BizChatAtSomeoneUI.b((byte)0);
        paramViewGroup.jkT = ((MaskLayout)paramView.findViewById(R.h.drX));
        paramViewGroup.jbe = ((TextView)paramView.findViewById(R.h.drY));
        paramView.setTag(paramViewGroup);
      }
      while ((paramInt == 0) && (BizChatAtSomeoneUI.Wtu))
      {
        paramViewGroup.Wty.setImageBitmap(this.Wtx);
        paramViewGroup.jbe.setText(this.context.getResources().getString(R.l.eph, new Object[] { "@" }));
        AppMethodBeat.o(33893);
        return paramView;
        paramViewGroup = (BizChatAtSomeoneUI.b)paramView.getTag();
      }
      if (BizChatAtSomeoneUI.Wtu) {}
      for (int i = 1;; i = 0)
      {
        Object localObject = (k)getItem(paramInt - i);
        paramViewGroup.jbe.setTextColor(com.tencent.mm.ci.a.l(this.context, R.e.mm_list_textcolor_one));
        ImageView localImageView = (ImageView)paramViewGroup.jkT.getContentView();
        q.bml().a(((k)localObject).field_headImageUrl, localImageView, this.jjH);
        paramViewGroup.jkT.setMaskDrawable(null);
        localObject = BizChatAtSomeoneUI.a(this.Wtt, ((k)localObject).field_userId);
        paramViewGroup.jbe.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.context, (CharSequence)localObject, paramViewGroup.jbe.getTextSize()));
        AppMethodBeat.o(33893);
        return paramView;
      }
    }
  }
  
  static final class b
  {
    public ImageView Wty;
    public TextView jbe;
    public MaskLayout jkT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatAtSomeoneUI
 * JD-Core Version:    0.7.0.1
 */