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
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.c;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.openim.api.e;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cm;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.base.MaskLayout.a;
import com.tencent.mm.ui.contact.p.a;
import com.tencent.mm.ui.contact.t;
import com.tencent.mm.ui.tools.s;
import com.tencent.mm.ui.tools.s.c;
import com.tencent.mm.ui.x;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class AtSomeoneUI
  extends MMActivity
  implements com.tencent.mm.ui.contact.o, p.a
{
  private static boolean aeaN = false;
  private a aeeP;
  private String lMu;
  private String lMv;
  private s lMw;
  private t lNh;
  private TextView lNm;
  private aj lzy;
  private String mTitle;
  private ListView qgc;
  private String talker;
  
  public static String a(aj paramaj, String paramString)
  {
    AppMethodBeat.i(34253);
    if (paramaj == null)
    {
      AppMethodBeat.o(34253);
      return null;
    }
    paramaj = paramaj.getDisplayName(paramString);
    AppMethodBeat.o(34253);
    return paramaj;
  }
  
  public final boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    return false;
  }
  
  public final boolean b(com.tencent.mm.ui.contact.a.a parama)
  {
    return false;
  }
  
  public final String c(com.tencent.mm.ui.contact.a.a parama)
  {
    return null;
  }
  
  public Activity getActivity()
  {
    return this;
  }
  
  public ListView getContentLV()
  {
    return this.qgc;
  }
  
  public int getLayoutId()
  {
    return R.i.geu;
  }
  
  public final void h(final String paramString, final int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(253761);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(253792);
        if (Util.isNullOrNil(paramString))
        {
          AtSomeoneUI.b(AtSomeoneUI.this).setAdapter(AtSomeoneUI.c(AtSomeoneUI.this));
          AtSomeoneUI.e(AtSomeoneUI.this).setVisibility(8);
          AppMethodBeat.o(253792);
          return;
        }
        AtSomeoneUI.b(AtSomeoneUI.this).setAdapter(AtSomeoneUI.a(AtSomeoneUI.this));
        if (paramInt > 0)
        {
          AtSomeoneUI.e(AtSomeoneUI.this).setVisibility(8);
          AppMethodBeat.o(253792);
          return;
        }
        AtSomeoneUI.e(AtSomeoneUI.this).setText(f.a(AtSomeoneUI.this.getString(R.l.search_contact_no_result_pre), AtSomeoneUI.this.getString(R.l.search_contact_no_result_post), g.c(paramString, paramString)).HsX);
        AtSomeoneUI.e(AtSomeoneUI.this).setVisibility(0);
        AppMethodBeat.o(253792);
      }
    });
    AppMethodBeat.o(253761);
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
    this.lMw = new s(true);
    this.lMw.afKz = new s.c()
    {
      public final boolean SN(String paramAnonymousString)
      {
        return false;
      }
      
      public final void SO(String paramAnonymousString)
      {
        AppMethodBeat.i(34239);
        AtSomeoneUI.a(AtSomeoneUI.this).aEJ(paramAnonymousString);
        AppMethodBeat.o(34239);
      }
      
      public final void bWw()
      {
        AppMethodBeat.i(34240);
        Log.d("MicroMsg.AtSomeoneUI", "onQuitSearch()");
        if (AtSomeoneUI.a(AtSomeoneUI.this) != null) {
          AtSomeoneUI.a(AtSomeoneUI.this).eui();
        }
        AppMethodBeat.o(34240);
      }
      
      public final void bWx() {}
      
      public final void bWy() {}
      
      public final void bWz() {}
    };
    addSearchMenu(true, this.lMw);
    this.qgc = ((ListView)findViewById(R.h.fvH));
    this.lNm = ((TextView)findViewById(R.h.empty_tv));
    Object localObject1 = new HashSet();
    ((HashSet)localObject1).add(z.bAM());
    this.lNh = new t(this, this.talker, false, (HashSet)localObject1);
    au localau = new au();
    aj localaj = this.lzy;
    localObject1 = null;
    if (!Util.isNullOrNil(this.lMv))
    {
      localObject1 = this.lMv.split(",");
      Log.d("MicroMsg.AtSomeoneUI", "chatroom members name=[%s]", new Object[] { Arrays.toString((Object[])localObject1) });
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = localObject1;
      if (this.lzy != null)
      {
        Log.w("MicroMsg.AtSomeoneUI", "[getChatroomMember] chatroomMemberList is null!");
        localObject2 = Util.listToString(this.lzy.bHw(), ",").split(",");
      }
    }
    if (localObject2 == null) {
      if (this.lzy != null) {
        break label372;
      }
    }
    for (;;)
    {
      Log.e("MicroMsg.AtSomeoneUI", "WTF! member is null? %s", new Object[] { Boolean.valueOf(bool) });
      localObject1 = new LinkedList();
      if (!Util.isNullOrNil(this.lMu)) {
        localObject1 = Util.stringsToList(this.lMu.split(","));
      }
      bh.bCz();
      cm localcm = c.bzJ().aMh("@t.qq.com");
      if (localcm != null) {
        ((List)localObject1).add(localcm.name);
      }
      this.aeeP = new a(this, localau, localaj, (String[])localObject2, (List)localObject1);
      this.lNh.afew = this;
      this.qgc.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(34241);
          Object localObject = new b();
          ((b)localObject).cH(paramAnonymousAdapterView);
          ((b)localObject).cH(paramAnonymousView);
          ((b)localObject).sc(paramAnonymousInt);
          ((b)localObject).hB(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/AtSomeoneUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((b)localObject).aYj());
          if (AtSomeoneUI.b(AtSomeoneUI.this).getAdapter() == AtSomeoneUI.c(AtSomeoneUI.this))
          {
            localObject = new Intent();
            if ((paramAnonymousInt == 0) && (AtSomeoneUI.XU()))
            {
              ((Intent)localObject).putExtra("Select_Conv_User", AtSomeoneUI.this.getString(R.l.gsi, new Object[] { "" }));
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
            if (AtSomeoneUI.XU()) {}
            au localau;
            for (int i = 1;; i = 0)
            {
              localau = (au)paramAnonymousAdapterView.getItem(paramAnonymousInt - i);
              paramAnonymousView = AtSomeoneUI.a(AtSomeoneUI.d(AtSomeoneUI.this), localau.field_username);
              paramAnonymousAdapterView = paramAnonymousView;
              if (Util.isNullOrNil(paramAnonymousView)) {
                paramAnonymousAdapterView = localau.aSU();
              }
              ((Intent)localObject).putExtra("select_raw_user_name", localau.field_username);
              ((Intent)localObject).putExtra("Select_Conv_User", paramAnonymousAdapterView);
              break;
            }
            if (AtSomeoneUI.b(AtSomeoneUI.this).getAdapter() == AtSomeoneUI.a(AtSomeoneUI.this))
            {
              localObject = new Intent();
              localau = AtSomeoneUI.a(AtSomeoneUI.this).aDt(paramAnonymousInt).contact;
              paramAnonymousView = AtSomeoneUI.a(AtSomeoneUI.d(AtSomeoneUI.this), localau.field_username);
              paramAnonymousAdapterView = paramAnonymousView;
              if (Util.isNullOrNil(paramAnonymousView)) {
                paramAnonymousAdapterView = localau.aSU();
              }
              ((Intent)localObject).putExtra("select_raw_user_name", localau.field_username);
              ((Intent)localObject).putExtra("Select_Conv_User", paramAnonymousAdapterView);
              AtSomeoneUI.this.setResult(-1, (Intent)localObject);
              AtSomeoneUI.this.finish();
            }
          }
        }
      });
      this.qgc.setAdapter(this.aeeP);
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
    this.lMu = getIntent().getStringExtra("Block_list");
    this.lMv = getIntent().getStringExtra("Chatroom_member_list");
    this.talker = getIntent().getStringExtra("Chat_User");
    this.mTitle = getIntent().getStringExtra("Add_address_titile");
    bh.bCz();
    this.lzy = c.bzK().Ju(this.talker);
    if ((this.lzy != null) && (this.lzy.field_roomowner != null) && (this.lzy.field_roomowner.equals(z.bAM()))) {
      aeaN = false;
    }
    initView();
    AppMethodBeat.o(34249);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(34252);
    this.aeeP.fSd();
    this.lNh.finish();
    super.onDestroy();
    AppMethodBeat.o(34252);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(34251);
    super.onPause();
    if (this.lMw != null) {
      this.lMw.jyO();
    }
    AppMethodBeat.o(34251);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
    extends x<au>
  {
    private String[] aeaP;
    private Bitmap aeaQ;
    private List<String> lMF;
    private String lMG;
    private aj lzy;
    
    public a(Context paramContext, au paramau, aj paramaj, String[] paramArrayOfString, List<String> paramList)
    {
      super(paramau);
      AppMethodBeat.i(34242);
      this.lzy = paramaj;
      this.aeaP = paramArrayOfString;
      this.lMF = paramList;
      this.aeaQ = BitmapUtil.transformDrawableToBitmap(paramContext.getResources().getDrawable(R.k.at_all_avater));
      AppMethodBeat.o(34242);
    }
    
    public final boolean XL(int paramInt)
    {
      return false;
    }
    
    public final void aNy()
    {
      AppMethodBeat.i(34245);
      bh.bCz();
      bx localbx = c.bzA();
      String[] arrayOfString1 = this.aeaP;
      String str1 = this.lMG;
      String str2 = this.lMG;
      Object localObject;
      if ((this.lzy == null) || (str2 == null) || (this.aeaP == null))
      {
        localObject = null;
        w(localbx.a(arrayOfString1, "@all.chatroom", str1, (List)localObject, this.lMF));
        super.notifyDataSetChanged();
        AppMethodBeat.o(34245);
        return;
      }
      ArrayList localArrayList = new ArrayList();
      String[] arrayOfString2 = this.aeaP;
      int j = arrayOfString2.length;
      int i = 0;
      for (;;)
      {
        localObject = localArrayList;
        if (i >= j) {
          break;
        }
        localObject = arrayOfString2[i];
        String str3 = this.lzy.getDisplayName((String)localObject);
        if ((str3 != null) && (str3.contains(str2))) {
          localArrayList.add(localObject);
        }
        i += 1;
      }
    }
    
    public final void aNz()
    {
      AppMethodBeat.i(34246);
      fSd();
      aNy();
      AppMethodBeat.o(34246);
    }
    
    public final int fHy()
    {
      AppMethodBeat.i(34243);
      if (AtSomeoneUI.XU())
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
        localView = View.inflate(this.context, R.i.get, null);
        paramViewGroup = new AtSomeoneUI.b((byte)0);
        paramViewGroup.lNy = ((MaskLayout)localView.findViewById(R.h.at_someone_item_avatar));
        paramViewGroup.lDe = ((TextView)localView.findViewById(R.h.at_someone_item_nick));
        paramViewGroup.aeaR = ((ImageView)localView.findViewById(R.h.content));
        localView.setTag(paramViewGroup);
      }
      while ((paramInt == 0) && (AtSomeoneUI.XU()))
      {
        paramViewGroup.aeaR.setImageBitmap(this.aeaQ);
        paramViewGroup.lDe.setText(this.context.getResources().getString(R.l.gsi, new Object[] { "@" }));
        AppMethodBeat.o(34244);
        return localView;
        paramViewGroup = (AtSomeoneUI.b)paramView.getTag();
        localView = paramView;
      }
      int i;
      au localau;
      if (AtSomeoneUI.XU())
      {
        i = 1;
        localau = (au)getItem(paramInt - i);
        paramView = paramViewGroup.lDe;
        Context localContext = this.context;
        if (ab.IV(localau.field_username)) {
          break label377;
        }
        paramInt = R.e.mm_list_textcolor_one;
        label202:
        paramView.setTextColor(com.tencent.mm.cd.a.l(localContext, paramInt));
        a.b.g((ImageView)paramViewGroup.lNy.getContentView(), localau.field_username);
        if (localau.field_verifyFlag == 0) {
          break label406;
        }
        if (az.a.okR == null) {
          break label395;
        }
        paramView = az.a.okR.ve(localau.field_verifyFlag);
        if (paramView == null) {
          break label384;
        }
        paramView = com.tencent.mm.an.o.MR(paramView);
        paramViewGroup.lNy.a(paramView, MaskLayout.a.adVl);
        label278:
        if (Util.isNullOrNil(localau.field_conRemark)) {
          break label417;
        }
        paramView = localau.field_conRemark;
        label295:
        if (!Util.isNullOrNil(paramView)) {
          break label458;
        }
        paramView = localau.aSU();
      }
      label384:
      label395:
      label406:
      label417:
      label458:
      for (;;)
      {
        if (au.bwO(localau.field_username)) {
          ((e)com.tencent.mm.kernel.h.ax(e.class)).a(paramViewGroup.lDe.getContext(), paramViewGroup.lDe, paramView, localau.field_openImAppid, localau.field_descWordingId, (int)paramViewGroup.lDe.getTextSize());
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
          paramViewGroup.lNy.setMaskDrawable(null);
          break label278;
          paramViewGroup.lNy.setMaskDrawable(null);
          break label278;
          paramViewGroup.lNy.setMaskDrawable(null);
          break label278;
          paramView = AtSomeoneUI.a(this.lzy, localau.field_username);
          break label295;
          paramViewGroup.lDe.setText(p.b(this.context, paramView, paramViewGroup.lDe.getTextSize()));
        }
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
 * Qualified Name:     com.tencent.mm.ui.chatting.AtSomeoneUI
 * JD-Core Version:    0.7.0.1
 */