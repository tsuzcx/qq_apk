package com.tencent.mm.plugin.subapp.ui.pluginapp;

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
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.api.c.b;
import com.tencent.mm.api.c.b.e;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.contact.d;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelavatar.e;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.protocal.protobuf.ahl;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.eve;
import com.tencent.mm.protocal.protobuf.evg;
import com.tencent.mm.protocal.protobuf.evx;
import com.tencent.mm.protocal.protobuf.ffs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.MMActivity;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ContactSearchResultUI
  extends MMActivity
{
  private static MMHandler nOB;
  private ListView SIw;
  private a SIx;
  private LinkedList<evx> SIy;
  private Map<String, b> SIz;
  private LinkedList<eve> nUC;
  
  static
  {
    AppMethodBeat.i(29214);
    nOB = new MMHandler(Looper.getMainLooper());
    AppMethodBeat.o(29214);
  }
  
  public ContactSearchResultUI()
  {
    AppMethodBeat.i(29209);
    this.nUC = new LinkedList();
    this.SIy = new LinkedList();
    AppMethodBeat.o(29209);
  }
  
  public int getLayoutId()
  {
    return R.i.giD;
  }
  
  public void initView()
  {
    AppMethodBeat.i(29211);
    setMMTitle(R.l.giD);
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
    this.SIz = new HashMap();
    this.SIw = ((ListView)findViewById(R.h.fUS));
    Object localObject = (TextView)findViewById(R.h.empty);
    this.SIw.setEmptyView((View)localObject);
    localObject = getIntent().getByteArrayExtra("result");
    final int i = getIntent().getIntExtra("add_more_friend_search_scene", 0);
    if (localObject != null) {}
    try
    {
      evg localevg = (evg)new evg().parseFrom((byte[])localObject);
      if (localevg != null)
      {
        this.nUC = localevg.aaqz;
        this.SIy = localevg.abya;
      }
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.ContactSearchResultUI", localException2, "SearchContactResponse", new Object[0]);
        try
        {
          localObject = (evx)new evx().parseFrom((byte[])localObject);
          this.SIy.add(localObject);
        }
        catch (Exception localException1)
        {
          Log.printErrStackTrace("MicroMsg.ContactSearchResultUI", localException1, "SearchOpenIMContactItem", new Object[0]);
        }
      }
      this.SIx = new a(this);
      this.SIw.setAdapter(this.SIx);
      this.SIw.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(29206);
          Object localObject = new b();
          ((b)localObject).cH(paramAnonymousAdapterView);
          ((b)localObject).cH(paramAnonymousView);
          ((b)localObject).sc(paramAnonymousInt);
          ((b)localObject).hB(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/subapp/ui/pluginapp/ContactSearchResultUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((b)localObject).aYj());
          int i = paramAnonymousInt - ContactSearchResultUI.a(ContactSearchResultUI.this).getHeaderViewsCount();
          if ((i < 0) || (i >= ContactSearchResultUI.a(ContactSearchResultUI.this).getCount()))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/pluginapp/ContactSearchResultUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(29206);
            return;
          }
          if (i >= ContactSearchResultUI.b(ContactSearchResultUI.this).size())
          {
            paramAnonymousAdapterView = (evx)ContactSearchResultUI.c(ContactSearchResultUI.this).get(paramAnonymousInt - ContactSearchResultUI.b(ContactSearchResultUI.this).size());
            ContactSearchResultUI.a(ContactSearchResultUI.this, paramAnonymousAdapterView);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/pluginapp/ContactSearchResultUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(29206);
            return;
          }
          paramAnonymousAdapterView = (eve)ContactSearchResultUI.b(ContactSearchResultUI.this).get(i);
          paramAnonymousView = paramAnonymousAdapterView.ZqL.abwM;
          bh.bCz();
          localObject = com.tencent.mm.model.c.bzA().JE(paramAnonymousView);
          if (d.rs(((az)localObject).field_type))
          {
            paramAnonymousAdapterView = new Intent();
            paramAnonymousAdapterView.putExtra("Contact_User", paramAnonymousView);
            paramAnonymousAdapterView.putExtra("Contact_Scene", 3);
            if ((paramAnonymousView != null) && (paramAnonymousView.length() > 0))
            {
              if (((au)localObject).iZC())
              {
                h.OAn.kvStat(10298, paramAnonymousView + ",35");
                paramAnonymousAdapterView.putExtra("Contact_Scene", 35);
              }
              com.tencent.mm.br.c.b(ContactSearchResultUI.this, "profile", ".ui.ContactInfoUI", paramAnonymousAdapterView);
            }
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/pluginapp/ContactSearchResultUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(29206);
            return;
            if ((paramAnonymousAdapterView.aaMm & 0x8) > 0) {
              h.OAn.kvStat(10298, paramAnonymousAdapterView.ZqL.abwM + ",35");
            }
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("Contact_User", paramAnonymousAdapterView.ZqL.abwM);
            paramAnonymousView.putExtra("Contact_Alias", paramAnonymousAdapterView.pSk);
            paramAnonymousView.putExtra("Contact_Nick", paramAnonymousAdapterView.aaIz.abwM);
            paramAnonymousView.putExtra("Contact_Signature", paramAnonymousAdapterView.pSi);
            paramAnonymousView.putExtra("Contact_RegionCode", RegionCodeDecoder.bI(paramAnonymousAdapterView.pSo, paramAnonymousAdapterView.pSg, paramAnonymousAdapterView.pSh));
            paramAnonymousView.putExtra("Contact_Sex", paramAnonymousAdapterView.pSf);
            paramAnonymousView.putExtra("Contact_VUser_Info", paramAnonymousAdapterView.aaMn);
            paramAnonymousView.putExtra("Contact_VUser_Info_Flag", paramAnonymousAdapterView.aaMm);
            paramAnonymousView.putExtra("Contact_KWeibo_flag", paramAnonymousAdapterView.aaMq);
            paramAnonymousView.putExtra("Contact_KWeibo", paramAnonymousAdapterView.aaMo);
            paramAnonymousView.putExtra("Contact_KWeiboNick", paramAnonymousAdapterView.aaMp);
            paramAnonymousView.putExtra("Contact_KSnsIFlag", paramAnonymousAdapterView.aaMs.pSq);
            paramAnonymousView.putExtra("Contact_KSnsBgId", paramAnonymousAdapterView.aaMs.pSs);
            paramAnonymousView.putExtra("Contact_KSnsBgUrl", paramAnonymousAdapterView.aaMs.pSr);
            paramAnonymousView.putExtra("Contact_Scene", 35);
            if (i != 0) {
              paramAnonymousView.putExtra("add_more_friend_search_scene", i);
            }
            if (paramAnonymousAdapterView.aaMt != null) {}
            try
            {
              paramAnonymousView.putExtra("Contact_customInfo", paramAnonymousAdapterView.aaMt.toByteArray());
              if ((paramAnonymousAdapterView.aaMm & 0x8) > 0) {
                h.OAn.kvStat(10298, paramAnonymousAdapterView.ZqL.abwM + ",35");
              }
              com.tencent.mm.br.c.b(ContactSearchResultUI.this, "profile", ".ui.ContactInfoUI", paramAnonymousView);
            }
            catch (IOException localIOException)
            {
              for (;;)
              {
                Log.printErrStackTrace("MicroMsg.ContactSearchResultUI", localIOException, "", new Object[0]);
              }
            }
          }
        }
      });
      this.SIw.setOnScrollListener(new com.tencent.mm.ui.applet.a());
      AppMethodBeat.o(29211);
    }
    if ((this.nUC.size() == 0) && (this.SIy.isEmpty()))
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
    q.bFG().cancel();
    if (this.SIz != null) {
      this.SIz.clear();
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
        localView = View.inflate(this.mContext, R.i.search_or_recommend_biz_item, null);
        paramViewGroup = new ContactSearchResultUI.c();
        paramViewGroup.lBC = ((ImageView)localView.findViewById(R.h.avatarIV));
        paramViewGroup.lDe = ((TextView)localView.findViewById(R.h.nicknameTV));
        paramViewGroup.vCx = localView.findViewById(R.h.verifyIV);
        paramViewGroup.vCy = ((TextView)localView.findViewById(R.h.introduceTV));
        paramViewGroup.vCB = localView.findViewById(R.h.bizTrademarkProtectionIV);
        localView.setTag(paramViewGroup);
      }
      for (;;)
      {
        if (paramInt >= ContactSearchResultUI.b(ContactSearchResultUI.this).size())
        {
          paramView = (evx)ContactSearchResultUI.c(ContactSearchResultUI.this).get(paramInt - ContactSearchResultUI.b(ContactSearchResultUI.this).size());
          paramViewGroup.username = paramView.UserName;
          a.b.h(paramViewGroup.lBC, paramViewGroup.username);
          paramViewGroup.lBC.setTag(paramViewGroup.username);
          a.b.g(paramViewGroup.lBC, paramViewGroup.username);
          paramViewGroup.vCx.setVisibility(8);
          paramViewGroup.vCB.setVisibility(8);
          paramViewGroup.vCy.setText("");
          try
          {
            paramViewGroup.lDe.setText(p.b(this.mContext, paramView.vhX, paramViewGroup.lDe.getTextSize()));
            AppMethodBeat.o(29208);
            return localView;
            paramViewGroup = (ContactSearchResultUI.c)paramView.getTag();
            localView = paramView;
          }
          catch (Exception paramView)
          {
            for (;;)
            {
              paramViewGroup.lDe.setText("");
            }
          }
        }
      }
      eve localeve = (eve)ContactSearchResultUI.b(ContactSearchResultUI.this).get(paramInt);
      if (localeve == null)
      {
        Log.e("MicroMsg.ContactSearchResultAdapter", "shouldnot be empty");
        AppMethodBeat.o(29208);
        return localView;
      }
      paramViewGroup.username = localeve.ZqL.abwM;
      a.b.h(paramViewGroup.lBC, paramViewGroup.username);
      paramViewGroup.lBC.setTag(paramViewGroup.username);
      a.b.g(paramViewGroup.lBC, paramViewGroup.username);
      String str = localeve.ZqL.abwM;
      Object localObject1 = (ContactSearchResultUI.b)ContactSearchResultUI.d(ContactSearchResultUI.this).get(str);
      paramView = (View)localObject1;
      Object localObject2;
      if (localObject1 == null)
      {
        localObject1 = new ContactSearchResultUI.b((byte)0);
        ContactSearchResultUI.d(ContactSearchResultUI.this).put(str, localObject1);
        paramView = localeve.aaMt;
        if (paramView != null)
        {
          localObject2 = new com.tencent.mm.api.c();
          ((com.tencent.mm.api.c)localObject2).field_username = str;
          ((com.tencent.mm.api.c)localObject2).field_brandFlag = paramView.pSt;
          ((com.tencent.mm.api.c)localObject2).field_brandIconURL = paramView.pSw;
          ((com.tencent.mm.api.c)localObject2).field_brandInfo = paramView.pSv;
          ((com.tencent.mm.api.c)localObject2).field_extInfo = paramView.pSu;
          if (((com.tencent.mm.api.c)localObject2).dO(false) == null) {
            break label803;
          }
        }
      }
      label803:
      for (paramView = ((com.tencent.mm.api.c)localObject2).dO(false).aBk();; paramView = null)
      {
        boolean bool;
        if (paramView != null)
        {
          if ((!((com.tencent.mm.api.c)localObject2).dO(false).aBm()) || (Util.isNullOrNil(paramView.hdy))) {
            break label724;
          }
          bool = true;
        }
        for (;;)
        {
          ((ContactSearchResultUI.b)localObject1).vCv = bool;
          if (localeve.aaMm != 0)
          {
            bool = true;
            label553:
            ((ContactSearchResultUI.b)localObject1).vCu = bool;
            paramView = (View)localObject1;
            localObject1 = paramViewGroup.vCx;
            if (!paramView.vCu) {
              break label736;
            }
            paramInt = 0;
            ((View)localObject1).setVisibility(paramInt);
            localObject1 = paramViewGroup.vCB;
            paramInt = i;
            if (paramView.vCv) {
              paramInt = 0;
            }
            ((View)localObject1).setVisibility(paramInt);
            Log.v("MicroMsg.ContactSearchResultAdapter", "verifyFlay : %d", new Object[] { Integer.valueOf(localeve.aaMm) });
            paramView = Util.nullAsNil(localeve.pSi);
          }
          try
          {
            paramViewGroup.vCy.setText(p.b(this.mContext, paramView, paramViewGroup.vCy.getTextSize()));
            try
            {
              localObject1 = paramViewGroup.lDe;
              localObject2 = this.mContext;
              if (Util.isNullOrNil(localeve.aaIz.abwM)) {
                break label755;
              }
              paramView = localeve.aaIz.abwM;
              ((TextView)localObject1).setText(p.b((Context)localObject2, paramView, paramViewGroup.lDe.getTextSize()));
            }
            catch (Exception paramView)
            {
              for (;;)
              {
                paramViewGroup.lDe.setText("");
              }
            }
            AppMethodBeat.o(29208);
            return localView;
            label724:
            bool = false;
            continue;
            bool = false;
            break label553;
            label736:
            paramInt = 8;
          }
          catch (Exception paramView)
          {
            for (;;)
            {
              paramViewGroup.vCy.setText("");
              continue;
              label755:
              if (!Util.isNullOrNil(localeve.pSk)) {
                paramView = localeve.pSk;
              } else {
                paramView = Util.nullAsNil(localeve.ZqL.abwM);
              }
            }
          }
        }
      }
    }
  }
  
  static final class b
  {
    protected boolean vCu;
    protected boolean vCv;
  }
  
  static final class c
  {
    public ImageView lBC;
    public TextView lDe;
    public String username;
    View vCB;
    public View vCx;
    public TextView vCy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.pluginapp.ContactSearchResultUI
 * JD-Core Version:    0.7.0.1
 */