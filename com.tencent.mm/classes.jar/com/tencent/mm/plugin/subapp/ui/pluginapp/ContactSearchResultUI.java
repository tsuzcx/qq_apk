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
import com.tencent.mm.aj.p;
import com.tencent.mm.api.c.b;
import com.tencent.mm.api.c.b.e;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.aco;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.cyu;
import com.tencent.mm.protocal.protobuf.cyw;
import com.tencent.mm.protocal.protobuf.czj;
import com.tencent.mm.protocal.protobuf.dia;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.MMActivity;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ContactSearchResultUI
  extends MMActivity
{
  private static aq hAA;
  private ListView BCl;
  private a BCm;
  private LinkedList<czj> BCn;
  private Map<String, b> BCo;
  private LinkedList<cyu> hFT;
  
  static
  {
    AppMethodBeat.i(29214);
    hAA = new aq(Looper.getMainLooper());
    AppMethodBeat.o(29214);
  }
  
  public ContactSearchResultUI()
  {
    AppMethodBeat.i(29209);
    this.hFT = new LinkedList();
    this.BCn = new LinkedList();
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
    this.BCo = new HashMap();
    this.BCl = ((ListView)findViewById(2131304140));
    Object localObject = (TextView)findViewById(2131299457);
    this.BCl.setEmptyView((View)localObject);
    localObject = getIntent().getByteArrayExtra("result");
    final int i = getIntent().getIntExtra("add_more_friend_search_scene", 0);
    if (localObject != null) {}
    try
    {
      cyw localcyw = (cyw)new cyw().parseFrom((byte[])localObject);
      if (localcyw != null)
      {
        this.hFT = localcyw.GQv;
        this.BCn = localcyw.HIV;
      }
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.ContactSearchResultUI", localException2, "SearchContactResponse", new Object[0]);
        try
        {
          localObject = (czj)new czj().parseFrom((byte[])localObject);
          this.BCn.add(localObject);
        }
        catch (Exception localException1)
        {
          ae.printErrStackTrace("MicroMsg.ContactSearchResultUI", localException1, "SearchOpenIMContactItem", new Object[0]);
        }
      }
      this.BCm = new a(this);
      this.BCl.setAdapter(this.BCm);
      this.BCl.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(29206);
          Object localObject = new b();
          ((b)localObject).bd(paramAnonymousAdapterView);
          ((b)localObject).bd(paramAnonymousView);
          ((b)localObject).mu(paramAnonymousInt);
          ((b)localObject).rl(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/subapp/ui/pluginapp/ContactSearchResultUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((b)localObject).ahF());
          int i = paramAnonymousInt - ContactSearchResultUI.a(ContactSearchResultUI.this).getHeaderViewsCount();
          if ((i < 0) || (i >= ContactSearchResultUI.a(ContactSearchResultUI.this).getCount()))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/pluginapp/ContactSearchResultUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(29206);
            return;
          }
          if (i >= ContactSearchResultUI.b(ContactSearchResultUI.this).size())
          {
            paramAnonymousAdapterView = (czj)ContactSearchResultUI.c(ContactSearchResultUI.this).get(paramAnonymousInt - ContactSearchResultUI.b(ContactSearchResultUI.this).size());
            ContactSearchResultUI.a(ContactSearchResultUI.this, paramAnonymousAdapterView);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/pluginapp/ContactSearchResultUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(29206);
            return;
          }
          paramAnonymousAdapterView = (cyu)ContactSearchResultUI.b(ContactSearchResultUI.this).get(i);
          paramAnonymousView = paramAnonymousAdapterView.GuF.HId;
          bc.aCg();
          localObject = com.tencent.mm.model.c.azF().BH(paramAnonymousView);
          if (com.tencent.mm.contact.c.lO(((aw)localObject).field_type))
          {
            paramAnonymousAdapterView = new Intent();
            paramAnonymousAdapterView.putExtra("Contact_User", paramAnonymousView);
            paramAnonymousAdapterView.putExtra("Contact_Scene", 3);
            if ((paramAnonymousView != null) && (paramAnonymousView.length() > 0))
            {
              if (((an)localObject).fug())
              {
                g.yxI.kvStat(10298, paramAnonymousView + ",35");
                paramAnonymousAdapterView.putExtra("Contact_Scene", 35);
              }
              com.tencent.mm.br.d.b(ContactSearchResultUI.this, "profile", ".ui.ContactInfoUI", paramAnonymousAdapterView);
            }
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/pluginapp/ContactSearchResultUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(29206);
            return;
            if ((paramAnonymousAdapterView.Hhu & 0x8) > 0) {
              g.yxI.kvStat(10298, paramAnonymousAdapterView.GuF.HId + ",35");
            }
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("Contact_User", paramAnonymousAdapterView.GuF.HId);
            paramAnonymousView.putExtra("Contact_Alias", paramAnonymousAdapterView.jga);
            paramAnonymousView.putExtra("Contact_Nick", paramAnonymousAdapterView.Hed.HId);
            paramAnonymousView.putExtra("Contact_Signature", paramAnonymousAdapterView.jfY);
            paramAnonymousView.putExtra("Contact_RegionCode", RegionCodeDecoder.bg(paramAnonymousAdapterView.jge, paramAnonymousAdapterView.jfW, paramAnonymousAdapterView.jfX));
            paramAnonymousView.putExtra("Contact_Sex", paramAnonymousAdapterView.jfV);
            paramAnonymousView.putExtra("Contact_VUser_Info", paramAnonymousAdapterView.Hhv);
            paramAnonymousView.putExtra("Contact_VUser_Info_Flag", paramAnonymousAdapterView.Hhu);
            paramAnonymousView.putExtra("Contact_KWeibo_flag", paramAnonymousAdapterView.Hhy);
            paramAnonymousView.putExtra("Contact_KWeibo", paramAnonymousAdapterView.Hhw);
            paramAnonymousView.putExtra("Contact_KWeiboNick", paramAnonymousAdapterView.Hhx);
            paramAnonymousView.putExtra("Contact_KSnsIFlag", paramAnonymousAdapterView.HhA.jgg);
            paramAnonymousView.putExtra("Contact_KSnsBgId", paramAnonymousAdapterView.HhA.jgi);
            paramAnonymousView.putExtra("Contact_KSnsBgUrl", paramAnonymousAdapterView.HhA.jgh);
            paramAnonymousView.putExtra("Contact_Scene", 35);
            if (i != 0) {
              paramAnonymousView.putExtra("add_more_friend_search_scene", i);
            }
            if (paramAnonymousAdapterView.HhB != null) {}
            try
            {
              paramAnonymousView.putExtra("Contact_customInfo", paramAnonymousAdapterView.HhB.toByteArray());
              if ((paramAnonymousAdapterView.Hhu & 0x8) > 0) {
                g.yxI.kvStat(10298, paramAnonymousAdapterView.GuF.HId + ",35");
              }
              com.tencent.mm.br.d.b(ContactSearchResultUI.this, "profile", ".ui.ContactInfoUI", paramAnonymousView);
            }
            catch (IOException localIOException)
            {
              for (;;)
              {
                ae.printErrStackTrace("MicroMsg.ContactSearchResultUI", localIOException, "", new Object[0]);
              }
            }
          }
        }
      });
      this.BCl.setOnScrollListener(new com.tencent.mm.ui.applet.a());
      AppMethodBeat.o(29211);
    }
    if ((this.hFT.size() == 0) && (this.BCn.isEmpty()))
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
    p.aEP().cancel();
    if (this.BCo != null) {
      this.BCo.clear();
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
        paramViewGroup.fQl = ((ImageView)localView.findViewById(2131296997));
        paramViewGroup.fRI = ((TextView)localView.findViewById(2131302864));
        paramViewGroup.ocT = localView.findViewById(2131306278);
        paramViewGroup.ocU = ((TextView)localView.findViewById(2131301045));
        paramViewGroup.ocX = localView.findViewById(2131297275);
        localView.setTag(paramViewGroup);
      }
      for (;;)
      {
        if (paramInt >= ContactSearchResultUI.b(ContactSearchResultUI.this).size())
        {
          paramView = (czj)ContactSearchResultUI.c(ContactSearchResultUI.this).get(paramInt - ContactSearchResultUI.b(ContactSearchResultUI.this).size());
          paramViewGroup.username = paramView.nIJ;
          a.b.d(paramViewGroup.fQl, paramViewGroup.username);
          paramViewGroup.fQl.setTag(paramViewGroup.username);
          a.b.c(paramViewGroup.fQl, paramViewGroup.username);
          paramViewGroup.ocT.setVisibility(8);
          paramViewGroup.ocX.setVisibility(8);
          paramViewGroup.ocU.setText("");
          try
          {
            paramViewGroup.fRI.setText(k.b(this.mContext, paramView.nJO, paramViewGroup.fRI.getTextSize()));
            AppMethodBeat.o(29208);
            return localView;
            paramViewGroup = (ContactSearchResultUI.c)paramView.getTag();
            localView = paramView;
          }
          catch (Exception paramView)
          {
            for (;;)
            {
              paramViewGroup.fRI.setText("");
            }
          }
        }
      }
      cyu localcyu = (cyu)ContactSearchResultUI.b(ContactSearchResultUI.this).get(paramInt);
      if (localcyu == null)
      {
        ae.e("MicroMsg.ContactSearchResultAdapter", "shouldnot be empty");
        AppMethodBeat.o(29208);
        return localView;
      }
      paramViewGroup.username = localcyu.GuF.HId;
      a.b.d(paramViewGroup.fQl, paramViewGroup.username);
      paramViewGroup.fQl.setTag(paramViewGroup.username);
      a.b.c(paramViewGroup.fQl, paramViewGroup.username);
      String str = localcyu.GuF.HId;
      Object localObject1 = (ContactSearchResultUI.b)ContactSearchResultUI.d(ContactSearchResultUI.this).get(str);
      paramView = (View)localObject1;
      Object localObject2;
      if (localObject1 == null)
      {
        localObject1 = new ContactSearchResultUI.b((byte)0);
        ContactSearchResultUI.d(ContactSearchResultUI.this).put(str, localObject1);
        paramView = localcyu.HhB;
        if (paramView != null)
        {
          localObject2 = new com.tencent.mm.api.c();
          ((com.tencent.mm.api.c)localObject2).field_username = str;
          ((com.tencent.mm.api.c)localObject2).field_brandFlag = paramView.jgj;
          ((com.tencent.mm.api.c)localObject2).field_brandIconURL = paramView.jgm;
          ((com.tencent.mm.api.c)localObject2).field_brandInfo = paramView.jgl;
          ((com.tencent.mm.api.c)localObject2).field_extInfo = paramView.jgk;
          if (((com.tencent.mm.api.c)localObject2).bX(false) == null) {
            break label796;
          }
        }
      }
      label796:
      for (paramView = ((com.tencent.mm.api.c)localObject2).bX(false).KQ();; paramView = null)
      {
        boolean bool;
        if (paramView != null)
        {
          if ((!((com.tencent.mm.api.c)localObject2).bX(false).KS()) || (bu.isNullOrNil(paramView.cRX))) {
            break label717;
          }
          bool = true;
        }
        for (;;)
        {
          ((ContactSearchResultUI.b)localObject1).ocR = bool;
          if (localcyu.Hhu != 0)
          {
            bool = true;
            label547:
            ((ContactSearchResultUI.b)localObject1).ocQ = bool;
            paramView = (View)localObject1;
            localObject1 = paramViewGroup.ocT;
            if (!paramView.ocQ) {
              break label729;
            }
            paramInt = 0;
            ((View)localObject1).setVisibility(paramInt);
            localObject1 = paramViewGroup.ocX;
            paramInt = i;
            if (paramView.ocR) {
              paramInt = 0;
            }
            ((View)localObject1).setVisibility(paramInt);
            ae.v("MicroMsg.ContactSearchResultAdapter", "verifyFlay : %d", new Object[] { Integer.valueOf(localcyu.Hhu) });
            paramView = bu.nullAsNil(localcyu.jfY);
          }
          try
          {
            paramViewGroup.ocU.setText(k.b(this.mContext, paramView, paramViewGroup.ocU.getTextSize()));
            try
            {
              localObject1 = paramViewGroup.fRI;
              localObject2 = this.mContext;
              if (bu.isNullOrNil(localcyu.Hed.HId)) {
                break label748;
              }
              paramView = localcyu.Hed.HId;
              ((TextView)localObject1).setText(k.b((Context)localObject2, paramView, paramViewGroup.fRI.getTextSize()));
            }
            catch (Exception paramView)
            {
              for (;;)
              {
                paramViewGroup.fRI.setText("");
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
              paramViewGroup.ocU.setText("");
              continue;
              label748:
              if (!bu.isNullOrNil(localcyu.jga)) {
                paramView = localcyu.jga;
              } else {
                paramView = bu.nullAsNil(localcyu.GuF.HId);
              }
            }
          }
        }
      }
    }
  }
  
  static final class b
  {
    protected boolean ocQ;
    protected boolean ocR;
  }
  
  static final class c
  {
    public ImageView fQl;
    public TextView fRI;
    public View ocT;
    public TextView ocU;
    View ocX;
    public String username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.pluginapp.ContactSearchResultUI
 * JD-Core Version:    0.7.0.1
 */