package com.tencent.mm.ui.chatting;

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
import com.tencent.mm.f.c.ax;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.c;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.cj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.base.MaskLayout.a;
import com.tencent.mm.ui.contact.p.a;
import com.tencent.mm.ui.tools.t.b;
import com.tencent.mm.ui.v;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class AtSomeoneUI
  extends MMActivity
  implements com.tencent.mm.ui.contact.o, p.a
{
  private static boolean Wtu = false;
  private a Wxx;
  private ah iXp;
  private String jjQ;
  private String jjR;
  private com.tencent.mm.ui.tools.t jjS;
  private com.tencent.mm.ui.contact.t jkD;
  private TextView jkI;
  private String mTitle;
  private ListView niO;
  private String talker;
  
  public static String a(ah paramah, String paramString)
  {
    AppMethodBeat.i(34253);
    if (paramah == null)
    {
      AppMethodBeat.o(34253);
      return null;
    }
    paramah = paramah.PJ(paramString);
    AppMethodBeat.o(34253);
    return paramah;
  }
  
  public final boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    return false;
  }
  
  public final boolean b(com.tencent.mm.ui.contact.a.a parama)
  {
    return false;
  }
  
  public final void g(final String paramString, final int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(281267);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(287023);
        if (Util.isNullOrNil(paramString))
        {
          AtSomeoneUI.b(AtSomeoneUI.this).setAdapter(AtSomeoneUI.c(AtSomeoneUI.this));
          AtSomeoneUI.e(AtSomeoneUI.this).setVisibility(8);
          AppMethodBeat.o(287023);
          return;
        }
        AtSomeoneUI.b(AtSomeoneUI.this).setAdapter(AtSomeoneUI.a(AtSomeoneUI.this));
        if (paramInt > 0)
        {
          AtSomeoneUI.e(AtSomeoneUI.this).setVisibility(8);
          AppMethodBeat.o(287023);
          return;
        }
        AtSomeoneUI.e(AtSomeoneUI.this).setText(com.tencent.mm.plugin.fts.a.f.a(AtSomeoneUI.this.getString(R.l.search_contact_no_result_pre), AtSomeoneUI.this.getString(R.l.search_contact_no_result_post), e.c(paramString, paramString)).BIp);
        AtSomeoneUI.e(AtSomeoneUI.this).setVisibility(0);
        AppMethodBeat.o(287023);
      }
    });
    AppMethodBeat.o(281267);
  }
  
  public Activity getActivity()
  {
    return this;
  }
  
  public ListView getContentLV()
  {
    return this.niO;
  }
  
  public int getLayoutId()
  {
    return R.i.ebM;
  }
  
  public void initView()
  {
    boolean bool = true;
    AppMethodBeat.i(34250);
    setMMTitle(this.mTitle);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(34237);
        AtSomeoneUI.this.setResult(0);
        AtSomeoneUI.this.finish();
        AppMethodBeat.o(34237);
        return true;
      }
    });
    this.jjS = new com.tencent.mm.ui.tools.t((byte)0);
    this.jjS.XUl = new t.b()
    {
      public final boolean aat(String paramAnonymousString)
      {
        return false;
      }
      
      public final void aau(String paramAnonymousString)
      {
        AppMethodBeat.i(34239);
        AtSomeoneUI.a(AtSomeoneUI.this).aIi(paramAnonymousString);
        AppMethodBeat.o(34239);
      }
      
      public final void bxH()
      {
        AppMethodBeat.i(34240);
        Log.d("MicroMsg.AtSomeoneUI", "onQuitSearch()");
        if (AtSomeoneUI.a(AtSomeoneUI.this) != null) {
          AtSomeoneUI.a(AtSomeoneUI.this).erx();
        }
        AppMethodBeat.o(34240);
      }
      
      public final void bxI() {}
      
      public final void bxJ() {}
      
      public final void bxK() {}
    };
    addSearchMenu(true, this.jjS);
    this.niO = ((ListView)findViewById(R.h.dvq));
    this.jkI = ((TextView)findViewById(R.h.empty_tv));
    Object localObject1 = new HashSet();
    ((HashSet)localObject1).add(z.bcZ());
    this.jkD = new com.tencent.mm.ui.contact.t(this, this.talker, false, (HashSet)localObject1);
    as localas = new as();
    ah localah = this.iXp;
    localObject1 = null;
    if (!Util.isNullOrNil(this.jjR))
    {
      localObject1 = this.jjR.split(",");
      Log.d("MicroMsg.AtSomeoneUI", "chatroom members name=[%s]", new Object[] { Arrays.toString((Object[])localObject1) });
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = localObject1;
      if (this.iXp != null)
      {
        Log.w("MicroMsg.AtSomeoneUI", "[getChatroomMember] chatroomMemberList is null!");
        localObject2 = Util.listToString(this.iXp.bjL(), ",").split(",");
      }
    }
    if (localObject2 == null) {
      if (this.iXp != null) {
        break label372;
      }
    }
    for (;;)
    {
      Log.e("MicroMsg.AtSomeoneUI", "WTF! member is null? %s", new Object[] { Boolean.valueOf(bool) });
      localObject1 = new LinkedList();
      if (!Util.isNullOrNil(this.jjQ)) {
        localObject1 = Util.stringsToList(this.jjQ.split(","));
      }
      bh.beI();
      cj localcj = c.bbU().aPi("@t.qq.com");
      if (localcj != null) {
        ((List)localObject1).add(localcj.name);
      }
      this.Wxx = new a(this, localas, localah, (String[])localObject2, (List)localObject1);
      this.jkD.XsV = this;
      this.niO.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(34241);
          Object localObject = new b();
          ((b)localObject).bn(paramAnonymousAdapterView);
          ((b)localObject).bn(paramAnonymousView);
          ((b)localObject).sg(paramAnonymousInt);
          ((b)localObject).Fs(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/AtSomeoneUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((b)localObject).aFi());
          if (AtSomeoneUI.b(AtSomeoneUI.this).getAdapter() == AtSomeoneUI.c(AtSomeoneUI.this))
          {
            localObject = new Intent();
            if ((paramAnonymousInt == 0) && (AtSomeoneUI.bSX()))
            {
              ((Intent)localObject).putExtra("Select_Conv_User", AtSomeoneUI.this.getString(R.l.eph, new Object[] { "" }));
              ((Intent)localObject).putExtra("select_raw_user_name", "notify@all");
              AtSomeoneUI.this.setResult(-1, (Intent)localObject);
              AtSomeoneUI.this.finish();
            }
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/AtSomeoneUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(34241);
            return;
            paramAnonymousAdapterView = AtSomeoneUI.c(AtSomeoneUI.this);
            if (AtSomeoneUI.bSX()) {}
            as localas;
            for (int i = 1;; i = 0)
            {
              localas = (as)paramAnonymousAdapterView.getItem(paramAnonymousInt - i);
              paramAnonymousView = AtSomeoneUI.a(AtSomeoneUI.d(AtSomeoneUI.this), localas.field_username);
              paramAnonymousAdapterView = paramAnonymousView;
              if (Util.isNullOrNil(paramAnonymousView)) {
                paramAnonymousAdapterView = localas.ayr();
              }
              ((Intent)localObject).putExtra("select_raw_user_name", localas.field_username);
              ((Intent)localObject).putExtra("Select_Conv_User", paramAnonymousAdapterView);
              break;
            }
            if (AtSomeoneUI.b(AtSomeoneUI.this).getAdapter() == AtSomeoneUI.a(AtSomeoneUI.this))
            {
              localObject = new Intent();
              localas = AtSomeoneUI.a(AtSomeoneUI.this).awM(paramAnonymousInt).contact;
              paramAnonymousView = AtSomeoneUI.a(AtSomeoneUI.d(AtSomeoneUI.this), localas.field_username);
              paramAnonymousAdapterView = paramAnonymousView;
              if (Util.isNullOrNil(paramAnonymousView)) {
                paramAnonymousAdapterView = localas.ayr();
              }
              ((Intent)localObject).putExtra("select_raw_user_name", localas.field_username);
              ((Intent)localObject).putExtra("Select_Conv_User", paramAnonymousAdapterView);
              AtSomeoneUI.this.setResult(-1, (Intent)localObject);
              AtSomeoneUI.this.finish();
            }
          }
        }
      });
      this.niO.setAdapter(this.Wxx);
      AppMethodBeat.o(34250);
      return;
      label372:
      bool = false;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(34249);
    super.onCreate(paramBundle);
    this.jjQ = getIntent().getStringExtra("Block_list");
    this.jjR = getIntent().getStringExtra("Chatroom_member_list");
    this.talker = getIntent().getStringExtra("Chat_User");
    this.mTitle = getIntent().getStringExtra("Add_address_titile");
    bh.beI();
    this.iXp = c.bbV().Rw(this.talker);
    if ((this.iXp != null) && (this.iXp.field_roomowner != null) && (this.iXp.field_roomowner.equals(z.bcZ()))) {
      Wtu = false;
    }
    initView();
    AppMethodBeat.o(34249);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(34252);
    this.Wxx.eKd();
    this.jkD.finish();
    super.onDestroy();
    AppMethodBeat.o(34252);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(34251);
    super.onPause();
    if (this.jjS != null) {
      this.jjS.hVb();
    }
    AppMethodBeat.o(34251);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
    extends v<as>
  {
    private String[] Wtw;
    private Bitmap Wtx;
    private ah iXp;
    private List<String> jkb;
    private String jkc;
    
    public a(Context paramContext, as paramas, ah paramah, String[] paramArrayOfString, List<String> paramList)
    {
      super(paramas);
      AppMethodBeat.i(34242);
      this.iXp = paramah;
      this.Wtw = paramArrayOfString;
      this.jkb = paramList;
      this.Wtx = BitmapUtil.transformDrawableToBitmap(paramContext.getResources().getDrawable(R.k.at_all_avater));
      AppMethodBeat.o(34242);
    }
    
    public final boolean TR(int paramInt)
    {
      return false;
    }
    
    public final void atr()
    {
      AppMethodBeat.i(34245);
      bh.beI();
      bv localbv = c.bbL();
      String[] arrayOfString1 = this.Wtw;
      String str1 = this.jkc;
      String str2 = this.jkc;
      Object localObject;
      if ((this.iXp == null) || (str2 == null) || (this.Wtw == null))
      {
        localObject = null;
        v(localbv.a(arrayOfString1, "@all.chatroom", str1, (List)localObject, this.jkb));
        super.notifyDataSetChanged();
        AppMethodBeat.o(34245);
        return;
      }
      ArrayList localArrayList = new ArrayList();
      String[] arrayOfString2 = this.Wtw;
      int j = arrayOfString2.length;
      int i = 0;
      for (;;)
      {
        localObject = localArrayList;
        if (i >= j) {
          break;
        }
        localObject = arrayOfString2[i];
        String str3 = this.iXp.PJ((String)localObject);
        if ((str3 != null) && (str3.contains(str2))) {
          localArrayList.add(localObject);
        }
        i += 1;
      }
    }
    
    public final void ats()
    {
      AppMethodBeat.i(34246);
      eKd();
      atr();
      AppMethodBeat.o(34246);
    }
    
    public final int ezA()
    {
      AppMethodBeat.i(34243);
      if (AtSomeoneUI.bSX())
      {
        AppMethodBeat.o(34243);
        return 1;
      }
      AppMethodBeat.o(34243);
      return 0;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(34244);
      View localView;
      if (paramView == null)
      {
        localView = View.inflate(this.context, R.i.ebL, null);
        paramViewGroup = new AtSomeoneUI.b((byte)0);
        paramViewGroup.jkT = ((MaskLayout)localView.findViewById(R.h.drX));
        paramViewGroup.jbe = ((TextView)localView.findViewById(R.h.drY));
        paramViewGroup.Wty = ((ImageView)localView.findViewById(R.h.content));
        localView.setTag(paramViewGroup);
      }
      while ((paramInt == 0) && (AtSomeoneUI.bSX()))
      {
        paramViewGroup.Wty.setImageBitmap(this.Wtx);
        paramViewGroup.jbe.setText(this.context.getResources().getString(R.l.eph, new Object[] { "@" }));
        AppMethodBeat.o(34244);
        return localView;
        paramViewGroup = (AtSomeoneUI.b)paramView.getTag();
        localView = paramView;
      }
      int i;
      as localas;
      if (AtSomeoneUI.bSX())
      {
        i = 1;
        localas = (as)getItem(paramInt - i);
        paramView = paramViewGroup.jbe;
        Context localContext = this.context;
        if (ab.QX(localas.field_username)) {
          break label377;
        }
        paramInt = R.e.mm_list_textcolor_one;
        label202:
        paramView.setTextColor(com.tencent.mm.ci.a.l(localContext, paramInt));
        a.b.c((ImageView)paramViewGroup.jkT.getContentView(), localas.field_username);
        if (localas.field_verifyFlag == 0) {
          break label406;
        }
        if (az.a.ltt == null) {
          break label395;
        }
        paramView = az.a.ltt.uT(localas.field_verifyFlag);
        if (paramView == null) {
          break label384;
        }
        paramView = com.tencent.mm.ao.o.US(paramView);
        paramViewGroup.jkT.a(paramView, MaskLayout.a.WnW);
        label278:
        if (Util.isNullOrNil(localas.field_conRemark)) {
          break label417;
        }
        paramView = localas.field_conRemark;
        label295:
        if (!Util.isNullOrNil(paramView)) {
          break label458;
        }
        paramView = localas.ayr();
      }
      label384:
      label395:
      label406:
      label417:
      label458:
      for (;;)
      {
        if (as.bvK(localas.field_username)) {
          ((com.tencent.mm.openim.a.a)h.ae(com.tencent.mm.openim.a.a.class)).a(paramViewGroup.jbe.getContext(), paramViewGroup.jbe, paramView, localas.field_openImAppid, localas.field_descWordingId, (int)paramViewGroup.jbe.getTextSize());
        }
        for (;;)
        {
          AppMethodBeat.o(34244);
          return localView;
          i = 0;
          break;
          label377:
          paramInt = R.e.mm_list_textcolor_spuser;
          break label202;
          paramViewGroup.jkT.setMaskDrawable(null);
          break label278;
          paramViewGroup.jkT.setMaskDrawable(null);
          break label278;
          paramViewGroup.jkT.setMaskDrawable(null);
          break label278;
          paramView = AtSomeoneUI.a(this.iXp, localas.field_username);
          break label295;
          paramViewGroup.jbe.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.context, paramView, paramViewGroup.jbe.getTextSize()));
        }
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
 * Qualified Name:     com.tencent.mm.ui.chatting.AtSomeoneUI
 * JD-Core Version:    0.7.0.1
 */