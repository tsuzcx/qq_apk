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
import com.tencent.mm.al.o;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.c;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ci;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.base.MaskLayout.a;
import com.tencent.mm.ui.tools.s.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class AtSomeoneUI
  extends MMActivity
{
  private static boolean Pah = false;
  private a Pee;
  private ah gtd;
  private String gzN;
  private String gzO;
  private com.tencent.mm.ui.tools.s gzP;
  private ListView krb;
  private String mTitle;
  private String talker;
  
  public static String a(ah paramah, String paramString)
  {
    AppMethodBeat.i(34253);
    if (paramah == null)
    {
      AppMethodBeat.o(34253);
      return null;
    }
    paramah = paramah.getDisplayName(paramString);
    AppMethodBeat.o(34253);
    return paramah;
  }
  
  public int getLayoutId()
  {
    return 2131493158;
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
    this.gzP = new com.tencent.mm.ui.tools.s((byte)0);
    this.gzP.Qwi = new s.b()
    {
      public final boolean SN(String paramAnonymousString)
      {
        return false;
      }
      
      public final void SO(String paramAnonymousString)
      {
        AppMethodBeat.i(34239);
        AtSomeoneUI.a(AtSomeoneUI.this).DO(paramAnonymousString);
        AppMethodBeat.o(34239);
      }
      
      public final void bnA() {}
      
      public final void bnB() {}
      
      public final void bny()
      {
        AppMethodBeat.i(34240);
        Log.d("MicroMsg.AtSomeoneUI", "onQuitSearch()");
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(34238);
            if (AtSomeoneUI.a(AtSomeoneUI.this) != null) {
              AtSomeoneUI.a(AtSomeoneUI.this).DO("");
            }
            AppMethodBeat.o(34238);
          }
        });
        AppMethodBeat.o(34240);
      }
      
      public final void bnz() {}
    };
    addSearchMenu(true, this.gzP);
    this.krb = ((ListView)findViewById(2131298305));
    as localas = new as();
    ah localah = this.gtd;
    Object localObject1 = null;
    if (!Util.isNullOrNil(this.gzO))
    {
      localObject1 = this.gzO.split(",");
      Log.d("MicroMsg.AtSomeoneUI", "chatroom members name=[%s]", new Object[] { Arrays.toString((Object[])localObject1) });
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = localObject1;
      if (this.gtd != null)
      {
        Log.w("MicroMsg.AtSomeoneUI", "[getChatroomMember] chatroomMemberList is null!");
        localObject2 = Util.listToString(this.gtd.bax(), ",").split(",");
      }
    }
    if (localObject2 == null) {
      if (this.gtd != null) {
        break label314;
      }
    }
    for (;;)
    {
      Log.e("MicroMsg.AtSomeoneUI", "WTF! member is null? %s", new Object[] { Boolean.valueOf(bool) });
      localObject1 = new LinkedList();
      if (!Util.isNullOrNil(this.gzN)) {
        localObject1 = Util.stringsToList(this.gzN.split(","));
      }
      bg.aVF();
      ci localci = c.aSW().aEY("@t.qq.com");
      if (localci != null) {
        ((List)localObject1).add(localci.name);
      }
      this.Pee = new a(this, localas, localah, (String[])localObject2, (List)localObject1);
      this.krb.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(34241);
          Object localObject = new b();
          ((b)localObject).bm(paramAnonymousAdapterView);
          ((b)localObject).bm(paramAnonymousView);
          ((b)localObject).pH(paramAnonymousInt);
          ((b)localObject).zo(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/AtSomeoneUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((b)localObject).axR());
          localObject = new Intent();
          if ((paramAnonymousInt == 0) && (AtSomeoneUI.Pah))
          {
            ((Intent)localObject).putExtra("Select_Conv_User", AtSomeoneUI.this.getString(2131756210, new Object[] { "" }));
            ((Intent)localObject).putExtra("select_raw_user_name", "notify@all");
            AtSomeoneUI.this.setResult(-1, (Intent)localObject);
            AtSomeoneUI.this.finish();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/AtSomeoneUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(34241);
            return;
          }
          paramAnonymousAdapterView = AtSomeoneUI.a(AtSomeoneUI.this);
          if (AtSomeoneUI.Pah) {}
          for (int i = 1;; i = 0)
          {
            as localas = (as)paramAnonymousAdapterView.getItem(paramAnonymousInt - i);
            paramAnonymousView = AtSomeoneUI.a(AtSomeoneUI.b(AtSomeoneUI.this), localas.field_username);
            paramAnonymousAdapterView = paramAnonymousView;
            if (Util.isNullOrNil(paramAnonymousView)) {
              paramAnonymousAdapterView = localas.arI();
            }
            ((Intent)localObject).putExtra("select_raw_user_name", localas.field_username);
            ((Intent)localObject).putExtra("Select_Conv_User", paramAnonymousAdapterView);
            break;
          }
        }
      });
      this.krb.setAdapter(this.Pee);
      AppMethodBeat.o(34250);
      return;
      label314:
      bool = false;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(34249);
    super.onCreate(paramBundle);
    this.gzN = getIntent().getStringExtra("Block_list");
    this.gzO = getIntent().getStringExtra("Chatroom_member_list");
    this.talker = getIntent().getStringExtra("Chat_User");
    this.mTitle = getIntent().getStringExtra("Add_address_titile");
    bg.aVF();
    this.gtd = c.aSX().Kd(this.talker);
    if ((this.gtd != null) && (this.gtd.field_roomowner != null) && (this.gtd.field_roomowner.equals(z.aTY()))) {
      Pah = false;
    }
    initView();
    AppMethodBeat.o(34249);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(34252);
    this.Pee.ebf();
    super.onDestroy();
    AppMethodBeat.o(34252);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(34251);
    super.onPause();
    if (this.gzP != null) {
      this.gzP.gXP();
    }
    AppMethodBeat.o(34251);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
    extends com.tencent.mm.ui.s<as>
  {
    private String[] Paj;
    private Bitmap Pak;
    private ah gtd;
    private List<String> gzY;
    private String gzZ;
    
    public a(Context paramContext, as paramas, ah paramah, String[] paramArrayOfString, List<String> paramList)
    {
      super(paramas);
      AppMethodBeat.i(34242);
      this.gtd = paramah;
      this.Paj = paramArrayOfString;
      this.gzY = paramList;
      this.Pak = BitmapUtil.transformDrawableToBitmap(paramContext.getResources().getDrawable(2131689719));
      AppMethodBeat.o(34242);
    }
    
    public final void DO(String paramString)
    {
      AppMethodBeat.i(34247);
      this.gzZ = paramString;
      onNotifyChange(null, null);
      AppMethodBeat.o(34247);
    }
    
    public final boolean Ox(int paramInt)
    {
      return false;
    }
    
    public final void anp()
    {
      AppMethodBeat.i(34245);
      bg.aVF();
      bv localbv = c.aSN();
      String[] arrayOfString1 = this.Paj;
      String str1 = this.gzZ;
      String str2 = this.gzZ;
      Object localObject;
      if ((this.gtd == null) || (str2 == null) || (this.Paj == null))
      {
        localObject = null;
        setCursor(localbv.a(arrayOfString1, "@all.chatroom", str1, (List)localObject, this.gzY));
        super.notifyDataSetChanged();
        AppMethodBeat.o(34245);
        return;
      }
      ArrayList localArrayList = new ArrayList();
      String[] arrayOfString2 = this.Paj;
      int j = arrayOfString2.length;
      int i = 0;
      for (;;)
      {
        localObject = localArrayList;
        if (i >= j) {
          break;
        }
        localObject = arrayOfString2[i];
        String str3 = this.gtd.getDisplayName((String)localObject);
        if ((str3 != null) && (str3.contains(str2))) {
          localArrayList.add(localObject);
        }
        i += 1;
      }
    }
    
    public final void anq()
    {
      AppMethodBeat.i(34246);
      ebf();
      anp();
      AppMethodBeat.o(34246);
    }
    
    public final int dWu()
    {
      AppMethodBeat.i(34243);
      if (AtSomeoneUI.Pah)
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
        localView = View.inflate(this.context, 2131493157, null);
        paramViewGroup = new AtSomeoneUI.b((byte)0);
        paramViewGroup.gAN = ((MaskLayout)localView.findViewById(2131297066));
        paramViewGroup.gwR = ((TextView)localView.findViewById(2131297067));
        paramViewGroup.Pal = ((ImageView)localView.findViewById(2131299180));
        localView.setTag(paramViewGroup);
      }
      while ((paramInt == 0) && (AtSomeoneUI.Pah))
      {
        paramViewGroup.Pal.setImageBitmap(this.Pak);
        paramViewGroup.gwR.setText(this.context.getResources().getString(2131756210, new Object[] { "@" }));
        AppMethodBeat.o(34244);
        return localView;
        paramViewGroup = (AtSomeoneUI.b)paramView.getTag();
        localView = paramView;
      }
      int i;
      as localas;
      if (AtSomeoneUI.Pah)
      {
        i = 1;
        localas = (as)getItem(paramInt - i);
        paramView = paramViewGroup.gwR;
        Context localContext = this.context;
        if (ab.JE(localas.field_username)) {
          break label371;
        }
        paramInt = 2131100808;
        label196:
        paramView.setTextColor(com.tencent.mm.cb.a.m(localContext, paramInt));
        a.b.c((ImageView)paramViewGroup.gAN.getContentView(), localas.field_username);
        if (localas.field_verifyFlag == 0) {
          break label400;
        }
        if (ay.a.iDs == null) {
          break label389;
        }
        paramView = ay.a.iDs.rW(localas.field_verifyFlag);
        if (paramView == null) {
          break label378;
        }
        paramView = o.Nw(paramView);
        paramViewGroup.gAN.a(paramView, MaskLayout.a.OUJ);
        label272:
        if (Util.isNullOrNil(localas.field_conRemark)) {
          break label411;
        }
        paramView = localas.field_conRemark;
        label289:
        if (!Util.isNullOrNil(paramView)) {
          break label452;
        }
        paramView = localas.arI();
      }
      label389:
      label400:
      label411:
      label452:
      for (;;)
      {
        if (as.bjp(localas.field_username)) {
          ((com.tencent.mm.openim.a.a)g.af(com.tencent.mm.openim.a.a.class)).a(paramViewGroup.gwR.getContext(), paramViewGroup.gwR, paramView, localas.field_openImAppid, localas.field_descWordingId, (int)paramViewGroup.gwR.getTextSize());
        }
        for (;;)
        {
          AppMethodBeat.o(34244);
          return localView;
          i = 0;
          break;
          label371:
          paramInt = 2131100809;
          break label196;
          label378:
          paramViewGroup.gAN.setMaskDrawable(null);
          break label272;
          paramViewGroup.gAN.setMaskDrawable(null);
          break label272;
          paramViewGroup.gAN.setMaskDrawable(null);
          break label272;
          paramView = AtSomeoneUI.a(this.gtd, localas.field_username);
          break label289;
          paramViewGroup.gwR.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.context, paramView, paramViewGroup.gwR.getTextSize()));
        }
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
 * Qualified Name:     com.tencent.mm.ui.chatting.AtSomeoneUI
 * JD-Core Version:    0.7.0.1
 */