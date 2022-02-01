package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.p;
import com.tencent.mm.api.c.b;
import com.tencent.mm.api.c.b.e;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.acf;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.protobuf.cya;
import com.tencent.mm.protocal.protobuf.cyc;
import com.tencent.mm.protocal.protobuf.cyp;
import com.tencent.mm.protocal.protobuf.dhg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.MMActivity;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ContactSearchResultUI
  extends MMActivity
{
  private static ap hxM;
  private ListView BkM;
  private a BkN;
  private LinkedList<cyp> BkO;
  private Map<String, b> BkP;
  private LinkedList<cya> hDb;
  
  static
  {
    AppMethodBeat.i(29214);
    hxM = new ap(Looper.getMainLooper());
    AppMethodBeat.o(29214);
  }
  
  public ContactSearchResultUI()
  {
    AppMethodBeat.i(29209);
    this.hDb = new LinkedList();
    this.BkO = new LinkedList();
    AppMethodBeat.o(29209);
  }
  
  public int getLayoutId()
  {
    return 2131493660;
  }
  
  public void initView()
  {
    AppMethodBeat.i(29211);
    setMMTitle(2131757923);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(29205);
        ContactSearchResultUI.this.finish();
        AppMethodBeat.o(29205);
        return true;
      }
    });
    this.BkP = new HashMap();
    this.BkM = ((ListView)findViewById(2131304140));
    Object localObject = (TextView)findViewById(2131299457);
    this.BkM.setEmptyView((View)localObject);
    localObject = getIntent().getByteArrayExtra("result");
    final int i = getIntent().getIntExtra("add_more_friend_search_scene", 0);
    if (localObject != null) {}
    try
    {
      cyc localcyc = (cyc)new cyc().parseFrom((byte[])localObject);
      if (localcyc != null)
      {
        this.hDb = localcyc.GwV;
        this.BkO = localcyc.Hpt;
      }
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.ContactSearchResultUI", localException2, "SearchContactResponse", new Object[0]);
        try
        {
          localObject = (cyp)new cyp().parseFrom((byte[])localObject);
          this.BkO.add(localObject);
        }
        catch (Exception localException1)
        {
          ad.printErrStackTrace("MicroMsg.ContactSearchResultUI", localException1, "SearchOpenIMContactItem", new Object[0]);
        }
      }
      this.BkN = new a(this);
      this.BkM.setAdapter(this.BkN);
      this.BkM.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(29206);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousAdapterView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).mr(paramAnonymousInt);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).qY(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/subapp/ui/pluginapp/ContactSearchResultUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          int i = paramAnonymousInt - ContactSearchResultUI.a(ContactSearchResultUI.this).getHeaderViewsCount();
          if ((i < 0) || (i >= ContactSearchResultUI.a(ContactSearchResultUI.this).getCount()))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/pluginapp/ContactSearchResultUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(29206);
            return;
          }
          if (i >= ContactSearchResultUI.b(ContactSearchResultUI.this).size())
          {
            paramAnonymousAdapterView = (cyp)ContactSearchResultUI.c(ContactSearchResultUI.this).get(paramAnonymousInt - ContactSearchResultUI.b(ContactSearchResultUI.this).size());
            ContactSearchResultUI.a(ContactSearchResultUI.this, paramAnonymousAdapterView);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/pluginapp/ContactSearchResultUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(29206);
            return;
          }
          paramAnonymousAdapterView = (cya)ContactSearchResultUI.b(ContactSearchResultUI.this).get(i);
          paramAnonymousView = paramAnonymousAdapterView.GbY.HoB;
          ba.aBQ();
          localObject = com.tencent.mm.model.c.azp().Bf(paramAnonymousView);
          if (com.tencent.mm.o.b.lM(((aw)localObject).field_type))
          {
            paramAnonymousAdapterView = new Intent();
            paramAnonymousAdapterView.putExtra("Contact_User", paramAnonymousView);
            paramAnonymousAdapterView.putExtra("Contact_Scene", 3);
            if ((paramAnonymousView != null) && (paramAnonymousView.length() > 0))
            {
              if (((am)localObject).fqg())
              {
                g.yhR.kvStat(10298, paramAnonymousView + ",35");
                paramAnonymousAdapterView.putExtra("Contact_Scene", 35);
              }
              com.tencent.mm.bs.d.b(ContactSearchResultUI.this, "profile", ".ui.ContactInfoUI", paramAnonymousAdapterView);
            }
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/pluginapp/ContactSearchResultUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(29206);
            return;
            if ((paramAnonymousAdapterView.GNU & 0x8) > 0) {
              g.yhR.kvStat(10298, paramAnonymousAdapterView.GbY.HoB + ",35");
            }
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("Contact_User", paramAnonymousAdapterView.GbY.HoB);
            paramAnonymousView.putExtra("Contact_Alias", paramAnonymousAdapterView.jdh);
            paramAnonymousView.putExtra("Contact_Nick", paramAnonymousAdapterView.GKC.HoB);
            paramAnonymousView.putExtra("Contact_Signature", paramAnonymousAdapterView.jdf);
            paramAnonymousView.putExtra("Contact_RegionCode", RegionCodeDecoder.bf(paramAnonymousAdapterView.jdl, paramAnonymousAdapterView.jdd, paramAnonymousAdapterView.jde));
            paramAnonymousView.putExtra("Contact_Sex", paramAnonymousAdapterView.jdc);
            paramAnonymousView.putExtra("Contact_VUser_Info", paramAnonymousAdapterView.GNV);
            paramAnonymousView.putExtra("Contact_VUser_Info_Flag", paramAnonymousAdapterView.GNU);
            paramAnonymousView.putExtra("Contact_KWeibo_flag", paramAnonymousAdapterView.GNY);
            paramAnonymousView.putExtra("Contact_KWeibo", paramAnonymousAdapterView.GNW);
            paramAnonymousView.putExtra("Contact_KWeiboNick", paramAnonymousAdapterView.GNX);
            paramAnonymousView.putExtra("Contact_KSnsIFlag", paramAnonymousAdapterView.GOa.jdn);
            paramAnonymousView.putExtra("Contact_KSnsBgId", paramAnonymousAdapterView.GOa.jdp);
            paramAnonymousView.putExtra("Contact_KSnsBgUrl", paramAnonymousAdapterView.GOa.jdo);
            paramAnonymousView.putExtra("Contact_Scene", 35);
            if (i != 0) {
              paramAnonymousView.putExtra("add_more_friend_search_scene", i);
            }
            if (paramAnonymousAdapterView.GOb != null) {}
            try
            {
              paramAnonymousView.putExtra("Contact_customInfo", paramAnonymousAdapterView.GOb.toByteArray());
              if ((paramAnonymousAdapterView.GNU & 0x8) > 0) {
                g.yhR.kvStat(10298, paramAnonymousAdapterView.GbY.HoB + ",35");
              }
              com.tencent.mm.bs.d.b(ContactSearchResultUI.this, "profile", ".ui.ContactInfoUI", paramAnonymousView);
            }
            catch (IOException localIOException)
            {
              for (;;)
              {
                ad.printErrStackTrace("MicroMsg.ContactSearchResultUI", localIOException, "", new Object[0]);
              }
            }
          }
        }
      });
      this.BkM.setOnScrollListener(new com.tencent.mm.ui.applet.a());
      AppMethodBeat.o(29211);
    }
    if ((this.hDb.size() == 0) && (this.BkO.isEmpty()))
    {
      AppMethodBeat.o(29211);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(29210);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(29210);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(29212);
    p.aEz().cancel();
    if (this.BkP != null) {
      this.BkP.clear();
    }
    super.onDestroy();
    AppMethodBeat.o(29212);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends BaseAdapter
  {
    private Context mContext;
    
    public a(Context paramContext)
    {
      this.mContext = paramContext;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(29207);
      int i = ContactSearchResultUI.b(ContactSearchResultUI.this).size();
      int j = ContactSearchResultUI.c(ContactSearchResultUI.this).size();
      AppMethodBeat.o(29207);
      return i + j;
    }
    
    public final Object getItem(int paramInt)
    {
      return null;
    }
    
    public final long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      int i = 8;
      AppMethodBeat.i(29208);
      View localView;
      if (paramView == null)
      {
        localView = View.inflate(this.mContext, 2131495325, null);
        paramViewGroup = new ContactSearchResultUI.c();
        paramViewGroup.fOf = ((ImageView)localView.findViewById(2131296997));
        paramViewGroup.fPC = ((TextView)localView.findViewById(2131302864));
        paramViewGroup.nXk = localView.findViewById(2131306278);
        paramViewGroup.nXl = ((TextView)localView.findViewById(2131301045));
        paramViewGroup.nXo = localView.findViewById(2131297275);
        localView.setTag(paramViewGroup);
      }
      for (;;)
      {
        if (paramInt >= ContactSearchResultUI.b(ContactSearchResultUI.this).size())
        {
          paramView = (cyp)ContactSearchResultUI.c(ContactSearchResultUI.this).get(paramInt - ContactSearchResultUI.b(ContactSearchResultUI.this).size());
          paramViewGroup.username = paramView.nDo;
          a.b.d(paramViewGroup.fOf, paramViewGroup.username);
          paramViewGroup.fOf.setTag(paramViewGroup.username);
          a.b.c(paramViewGroup.fOf, paramViewGroup.username);
          paramViewGroup.nXk.setVisibility(8);
          paramViewGroup.nXo.setVisibility(8);
          paramViewGroup.nXl.setText("");
          try
          {
            paramViewGroup.fPC.setText(k.b(this.mContext, paramView.nEt, paramViewGroup.fPC.getTextSize()));
            AppMethodBeat.o(29208);
            return localView;
            paramViewGroup = (ContactSearchResultUI.c)paramView.getTag();
            localView = paramView;
          }
          catch (Exception paramView)
          {
            for (;;)
            {
              paramViewGroup.fPC.setText("");
            }
          }
        }
      }
      cya localcya = (cya)ContactSearchResultUI.b(ContactSearchResultUI.this).get(paramInt);
      if (localcya == null)
      {
        ad.e("MicroMsg.ContactSearchResultAdapter", "shouldnot be empty");
        AppMethodBeat.o(29208);
        return localView;
      }
      paramViewGroup.username = localcya.GbY.HoB;
      a.b.d(paramViewGroup.fOf, paramViewGroup.username);
      paramViewGroup.fOf.setTag(paramViewGroup.username);
      a.b.c(paramViewGroup.fOf, paramViewGroup.username);
      String str = localcya.GbY.HoB;
      Object localObject1 = (ContactSearchResultUI.b)ContactSearchResultUI.d(ContactSearchResultUI.this).get(str);
      paramView = (View)localObject1;
      Object localObject2;
      if (localObject1 == null)
      {
        localObject1 = new ContactSearchResultUI.b((byte)0);
        ContactSearchResultUI.d(ContactSearchResultUI.this).put(str, localObject1);
        paramView = localcya.GOb;
        if (paramView != null)
        {
          localObject2 = new com.tencent.mm.api.c();
          ((com.tencent.mm.api.c)localObject2).field_username = str;
          ((com.tencent.mm.api.c)localObject2).field_brandFlag = paramView.jdq;
          ((com.tencent.mm.api.c)localObject2).field_brandIconURL = paramView.jdt;
          ((com.tencent.mm.api.c)localObject2).field_brandInfo = paramView.jds;
          ((com.tencent.mm.api.c)localObject2).field_extInfo = paramView.jdr;
          if (((com.tencent.mm.api.c)localObject2).bX(false) == null) {
            break label796;
          }
        }
      }
      label796:
      for (paramView = ((com.tencent.mm.api.c)localObject2).bX(false).KI();; paramView = null)
      {
        boolean bool;
        if (paramView != null)
        {
          if ((!((com.tencent.mm.api.c)localObject2).bX(false).KK()) || (bt.isNullOrNil(paramView.cRn))) {
            break label717;
          }
          bool = true;
        }
        for (;;)
        {
          ((ContactSearchResultUI.b)localObject1).nXi = bool;
          if (localcya.GNU != 0)
          {
            bool = true;
            label547:
            ((ContactSearchResultUI.b)localObject1).nXh = bool;
            paramView = (View)localObject1;
            localObject1 = paramViewGroup.nXk;
            if (!paramView.nXh) {
              break label729;
            }
            paramInt = 0;
            ((View)localObject1).setVisibility(paramInt);
            localObject1 = paramViewGroup.nXo;
            paramInt = i;
            if (paramView.nXi) {
              paramInt = 0;
            }
            ((View)localObject1).setVisibility(paramInt);
            ad.v("MicroMsg.ContactSearchResultAdapter", "verifyFlay : %d", new Object[] { Integer.valueOf(localcya.GNU) });
            paramView = bt.nullAsNil(localcya.jdf);
          }
          try
          {
            paramViewGroup.nXl.setText(k.b(this.mContext, paramView, paramViewGroup.nXl.getTextSize()));
            try
            {
              localObject1 = paramViewGroup.fPC;
              localObject2 = this.mContext;
              if (bt.isNullOrNil(localcya.GKC.HoB)) {
                break label748;
              }
              paramView = localcya.GKC.HoB;
              ((TextView)localObject1).setText(k.b((Context)localObject2, paramView, paramViewGroup.fPC.getTextSize()));
            }
            catch (Exception paramView)
            {
              for (;;)
              {
                paramViewGroup.fPC.setText("");
              }
            }
            AppMethodBeat.o(29208);
            return localView;
            label717:
            bool = false;
            continue;
            bool = false;
            break label547;
            label729:
            paramInt = 8;
          }
          catch (Exception paramView)
          {
            for (;;)
            {
              paramViewGroup.nXl.setText("");
              continue;
              label748:
              if (!bt.isNullOrNil(localcya.jdh)) {
                paramView = localcya.jdh;
              } else {
                paramView = bt.nullAsNil(localcya.GbY.HoB);
              }
            }
          }
        }
      }
    }
  }
  
  static final class b
  {
    protected boolean nXh;
    protected boolean nXi;
  }
  
  static final class c
  {
    public ImageView fOf;
    public TextView fPC;
    public View nXk;
    public TextView nXl;
    View nXo;
    public String username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.pluginapp.ContactSearchResultUI
 * JD-Core Version:    0.7.0.1
 */