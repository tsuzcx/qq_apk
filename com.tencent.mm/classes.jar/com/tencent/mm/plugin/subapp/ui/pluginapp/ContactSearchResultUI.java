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
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.az;
import com.tencent.mm.n.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.aaf;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.csq;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.protocal.protobuf.ctf;
import com.tencent.mm.protocal.protobuf.dbt;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.a;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ContactSearchResultUI
  extends MMActivity
{
  private static ao hfE;
  private LinkedList<csq> hkS;
  private ListView zTh;
  private a zTi;
  private LinkedList<ctf> zTj;
  private Map<String, b> zTk;
  
  static
  {
    AppMethodBeat.i(29214);
    hfE = new ao(Looper.getMainLooper());
    AppMethodBeat.o(29214);
  }
  
  public ContactSearchResultUI()
  {
    AppMethodBeat.i(29209);
    this.hkS = new LinkedList();
    this.zTj = new LinkedList();
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
    this.zTk = new HashMap();
    this.zTh = ((ListView)findViewById(2131304140));
    Object localObject = (TextView)findViewById(2131299457);
    this.zTh.setEmptyView((View)localObject);
    localObject = getIntent().getByteArrayExtra("result");
    final int i = getIntent().getIntExtra("add_more_friend_search_scene", 0);
    if (localObject != null) {}
    try
    {
      css localcss = (css)new css().parseFrom((byte[])localObject);
      if (localcss != null)
      {
        this.hkS = localcss.ENR;
        this.zTj = localcss.FEU;
      }
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.ContactSearchResultUI", localException2, "SearchContactResponse", new Object[0]);
        try
        {
          localObject = (ctf)new ctf().parseFrom((byte[])localObject);
          this.zTj.add(localObject);
        }
        catch (Exception localException1)
        {
          ac.printErrStackTrace("MicroMsg.ContactSearchResultUI", localException1, "SearchOpenIMContactItem", new Object[0]);
        }
      }
      this.zTi = new a(this);
      this.zTh.setAdapter(this.zTi);
      this.zTh.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(29206);
          int i = paramAnonymousInt - ContactSearchResultUI.a(ContactSearchResultUI.this).getHeaderViewsCount();
          if ((i < 0) || (i >= ContactSearchResultUI.a(ContactSearchResultUI.this).getCount()))
          {
            AppMethodBeat.o(29206);
            return;
          }
          if (i >= ContactSearchResultUI.b(ContactSearchResultUI.this).size())
          {
            paramAnonymousAdapterView = (ctf)ContactSearchResultUI.c(ContactSearchResultUI.this).get(paramAnonymousInt - ContactSearchResultUI.b(ContactSearchResultUI.this).size());
            ContactSearchResultUI.a(ContactSearchResultUI.this, paramAnonymousAdapterView);
            AppMethodBeat.o(29206);
            return;
          }
          paramAnonymousAdapterView = (csq)ContactSearchResultUI.b(ContactSearchResultUI.this).get(i);
          paramAnonymousView = paramAnonymousAdapterView.EuE.FEm;
          az.ayM();
          ai localai = com.tencent.mm.model.c.awB().aNt(paramAnonymousView);
          if (b.ln(localai.field_type))
          {
            paramAnonymousAdapterView = new Intent();
            paramAnonymousAdapterView.putExtra("Contact_User", paramAnonymousView);
            paramAnonymousAdapterView.putExtra("Contact_Scene", 3);
            if ((paramAnonymousView != null) && (paramAnonymousView.length() > 0))
            {
              if (localai.fad())
              {
                h.wUl.kvStat(10298, paramAnonymousView + ",35");
                paramAnonymousAdapterView.putExtra("Contact_Scene", 35);
              }
              com.tencent.mm.br.d.b(ContactSearchResultUI.this, "profile", ".ui.ContactInfoUI", paramAnonymousAdapterView);
            }
            AppMethodBeat.o(29206);
            return;
          }
          if ((paramAnonymousAdapterView.Feq & 0x8) > 0) {
            h.wUl.kvStat(10298, paramAnonymousAdapterView.EuE.FEm + ",35");
          }
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("Contact_User", paramAnonymousAdapterView.EuE.FEm);
          paramAnonymousView.putExtra("Contact_Alias", paramAnonymousAdapterView.iJY);
          paramAnonymousView.putExtra("Contact_Nick", paramAnonymousAdapterView.Fbd.FEm);
          paramAnonymousView.putExtra("Contact_Signature", paramAnonymousAdapterView.iJW);
          paramAnonymousView.putExtra("Contact_RegionCode", RegionCodeDecoder.aW(paramAnonymousAdapterView.iKc, paramAnonymousAdapterView.iJU, paramAnonymousAdapterView.iJV));
          paramAnonymousView.putExtra("Contact_Sex", paramAnonymousAdapterView.iJT);
          paramAnonymousView.putExtra("Contact_VUser_Info", paramAnonymousAdapterView.Fer);
          paramAnonymousView.putExtra("Contact_VUser_Info_Flag", paramAnonymousAdapterView.Feq);
          paramAnonymousView.putExtra("Contact_KWeibo_flag", paramAnonymousAdapterView.Feu);
          paramAnonymousView.putExtra("Contact_KWeibo", paramAnonymousAdapterView.Fes);
          paramAnonymousView.putExtra("Contact_KWeiboNick", paramAnonymousAdapterView.Fet);
          paramAnonymousView.putExtra("Contact_KSnsIFlag", paramAnonymousAdapterView.Few.iKe);
          paramAnonymousView.putExtra("Contact_KSnsBgId", paramAnonymousAdapterView.Few.iKg);
          paramAnonymousView.putExtra("Contact_KSnsBgUrl", paramAnonymousAdapterView.Few.iKf);
          paramAnonymousView.putExtra("Contact_Scene", 35);
          if (i != 0) {
            paramAnonymousView.putExtra("add_more_friend_search_scene", i);
          }
          if (paramAnonymousAdapterView.Fex != null) {}
          try
          {
            paramAnonymousView.putExtra("Contact_customInfo", paramAnonymousAdapterView.Fex.toByteArray());
            if ((paramAnonymousAdapterView.Feq & 0x8) > 0) {
              h.wUl.kvStat(10298, paramAnonymousAdapterView.EuE.FEm + ",35");
            }
            com.tencent.mm.br.d.b(ContactSearchResultUI.this, "profile", ".ui.ContactInfoUI", paramAnonymousView);
            AppMethodBeat.o(29206);
            return;
          }
          catch (IOException localIOException)
          {
            for (;;)
            {
              ac.printErrStackTrace("MicroMsg.ContactSearchResultUI", localIOException, "", new Object[0]);
            }
          }
        }
      });
      this.zTh.setOnScrollListener(new a());
      AppMethodBeat.o(29211);
    }
    if ((this.hkS.size() == 0) && (this.zTj.isEmpty()))
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
    p.aBy().cancel();
    if (this.zTk != null) {
      this.zTk.clear();
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
        paramViewGroup.fuY = ((ImageView)localView.findViewById(2131296997));
        paramViewGroup.fwp = ((TextView)localView.findViewById(2131302864));
        paramViewGroup.nvM = localView.findViewById(2131306278);
        paramViewGroup.nvN = ((TextView)localView.findViewById(2131301045));
        paramViewGroup.nvQ = localView.findViewById(2131297275);
        localView.setTag(paramViewGroup);
      }
      for (;;)
      {
        if (paramInt >= ContactSearchResultUI.b(ContactSearchResultUI.this).size())
        {
          paramView = (ctf)ContactSearchResultUI.c(ContactSearchResultUI.this).get(paramInt - ContactSearchResultUI.b(ContactSearchResultUI.this).size());
          paramViewGroup.username = paramView.ncR;
          a.b.d(paramViewGroup.fuY, paramViewGroup.username);
          paramViewGroup.fuY.setTag(paramViewGroup.username);
          a.b.c(paramViewGroup.fuY, paramViewGroup.username);
          paramViewGroup.nvM.setVisibility(8);
          paramViewGroup.nvQ.setVisibility(8);
          paramViewGroup.nvN.setText("");
          try
          {
            paramViewGroup.fwp.setText(k.b(this.mContext, paramView.ndW, paramViewGroup.fwp.getTextSize()));
            AppMethodBeat.o(29208);
            return localView;
            paramViewGroup = (ContactSearchResultUI.c)paramView.getTag();
            localView = paramView;
          }
          catch (Exception paramView)
          {
            for (;;)
            {
              paramViewGroup.fwp.setText("");
            }
          }
        }
      }
      csq localcsq = (csq)ContactSearchResultUI.b(ContactSearchResultUI.this).get(paramInt);
      if (localcsq == null)
      {
        ac.e("MicroMsg.ContactSearchResultAdapter", "shouldnot be empty");
        AppMethodBeat.o(29208);
        return localView;
      }
      paramViewGroup.username = localcsq.EuE.FEm;
      a.b.d(paramViewGroup.fuY, paramViewGroup.username);
      paramViewGroup.fuY.setTag(paramViewGroup.username);
      a.b.c(paramViewGroup.fuY, paramViewGroup.username);
      String str = localcsq.EuE.FEm;
      Object localObject1 = (ContactSearchResultUI.b)ContactSearchResultUI.d(ContactSearchResultUI.this).get(str);
      paramView = (View)localObject1;
      Object localObject2;
      if (localObject1 == null)
      {
        localObject1 = new ContactSearchResultUI.b((byte)0);
        ContactSearchResultUI.d(ContactSearchResultUI.this).put(str, localObject1);
        paramView = localcsq.Fex;
        if (paramView != null)
        {
          localObject2 = new com.tencent.mm.api.c();
          ((com.tencent.mm.api.c)localObject2).field_username = str;
          ((com.tencent.mm.api.c)localObject2).field_brandFlag = paramView.iKh;
          ((com.tencent.mm.api.c)localObject2).field_brandIconURL = paramView.iKk;
          ((com.tencent.mm.api.c)localObject2).field_brandInfo = paramView.iKj;
          ((com.tencent.mm.api.c)localObject2).field_extInfo = paramView.iKi;
          if (((com.tencent.mm.api.c)localObject2).bV(false) == null) {
            break label796;
          }
        }
      }
      label796:
      for (paramView = ((com.tencent.mm.api.c)localObject2).bV(false).Ji();; paramView = null)
      {
        boolean bool;
        if (paramView != null)
        {
          if ((!((com.tencent.mm.api.c)localObject2).bV(false).Jl()) || (bs.isNullOrNil(paramView.cGj))) {
            break label717;
          }
          bool = true;
        }
        for (;;)
        {
          ((ContactSearchResultUI.b)localObject1).nvK = bool;
          if (localcsq.Feq != 0)
          {
            bool = true;
            label547:
            ((ContactSearchResultUI.b)localObject1).nvJ = bool;
            paramView = (View)localObject1;
            localObject1 = paramViewGroup.nvM;
            if (!paramView.nvJ) {
              break label729;
            }
            paramInt = 0;
            ((View)localObject1).setVisibility(paramInt);
            localObject1 = paramViewGroup.nvQ;
            paramInt = i;
            if (paramView.nvK) {
              paramInt = 0;
            }
            ((View)localObject1).setVisibility(paramInt);
            ac.v("MicroMsg.ContactSearchResultAdapter", "verifyFlay : %d", new Object[] { Integer.valueOf(localcsq.Feq) });
            paramView = bs.nullAsNil(localcsq.iJW);
          }
          try
          {
            paramViewGroup.nvN.setText(k.b(this.mContext, paramView, paramViewGroup.nvN.getTextSize()));
            try
            {
              localObject1 = paramViewGroup.fwp;
              localObject2 = this.mContext;
              if (bs.isNullOrNil(localcsq.Fbd.FEm)) {
                break label748;
              }
              paramView = localcsq.Fbd.FEm;
              ((TextView)localObject1).setText(k.b((Context)localObject2, paramView, paramViewGroup.fwp.getTextSize()));
            }
            catch (Exception paramView)
            {
              for (;;)
              {
                paramViewGroup.fwp.setText("");
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
              paramViewGroup.nvN.setText("");
              continue;
              label748:
              if (!bs.isNullOrNil(localcsq.iJY)) {
                paramView = localcsq.iJY;
              } else {
                paramView = bs.nullAsNil(localcsq.EuE.FEm);
              }
            }
          }
        }
      }
    }
  }
  
  static final class b
  {
    protected boolean nvJ;
    protected boolean nvK;
  }
  
  static final class c
  {
    public ImageView fuY;
    public TextView fwp;
    public View nvM;
    public TextView nvN;
    View nvQ;
    public String username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.pluginapp.ContactSearchResultUI
 * JD-Core Version:    0.7.0.1
 */