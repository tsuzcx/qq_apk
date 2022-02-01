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
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.az;
import com.tencent.mm.n.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.cnj;
import com.tencent.mm.protocal.protobuf.cnl;
import com.tencent.mm.protocal.protobuf.cny;
import com.tencent.mm.protocal.protobuf.cwh;
import com.tencent.mm.protocal.protobuf.zh;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.a;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ContactSearchResultUI
  extends MMActivity
{
  private static ap gFd;
  private LinkedList<cnj> gKs;
  private ListView yFT;
  private a yFU;
  private LinkedList<cny> yFV;
  private Map<String, b> yFW;
  
  static
  {
    AppMethodBeat.i(29214);
    gFd = new ap(Looper.getMainLooper());
    AppMethodBeat.o(29214);
  }
  
  public ContactSearchResultUI()
  {
    AppMethodBeat.i(29209);
    this.gKs = new LinkedList();
    this.yFV = new LinkedList();
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
    this.yFW = new HashMap();
    this.yFT = ((ListView)findViewById(2131304140));
    Object localObject = (TextView)findViewById(2131299457);
    this.yFT.setEmptyView((View)localObject);
    localObject = getIntent().getByteArrayExtra("result");
    final int i = getIntent().getIntExtra("add_more_friend_search_scene", 0);
    if (localObject != null) {}
    try
    {
      cnl localcnl = (cnl)new cnl().parseFrom((byte[])localObject);
      if (localcnl != null)
      {
        this.gKs = localcnl.DsN;
        this.yFV = localcnl.EhW;
      }
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.ContactSearchResultUI", localException2, "SearchContactResponse", new Object[0]);
        try
        {
          localObject = (cny)new cny().parseFrom((byte[])localObject);
          this.yFV.add(localObject);
        }
        catch (Exception localException1)
        {
          ad.printErrStackTrace("MicroMsg.ContactSearchResultUI", localException1, "SearchOpenIMContactItem", new Object[0]);
        }
      }
      this.yFU = new a(this);
      this.yFT.setAdapter(this.yFU);
      this.yFT.setOnItemClickListener(new AdapterView.OnItemClickListener()
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
            paramAnonymousAdapterView = (cny)ContactSearchResultUI.c(ContactSearchResultUI.this).get(paramAnonymousInt - ContactSearchResultUI.b(ContactSearchResultUI.this).size());
            ContactSearchResultUI.a(ContactSearchResultUI.this, paramAnonymousAdapterView);
            AppMethodBeat.o(29206);
            return;
          }
          paramAnonymousAdapterView = (cnj)ContactSearchResultUI.b(ContactSearchResultUI.this).get(i);
          paramAnonymousView = paramAnonymousAdapterView.Dby.Ehn;
          az.arV();
          af localaf = com.tencent.mm.model.c.apM().aHY(paramAnonymousView);
          if (b.ls(localaf.field_type))
          {
            paramAnonymousAdapterView = new Intent();
            paramAnonymousAdapterView.putExtra("Contact_User", paramAnonymousView);
            paramAnonymousAdapterView.putExtra("Contact_Scene", 3);
            if ((paramAnonymousView != null) && (paramAnonymousView.length() > 0))
            {
              if (localaf.eKB())
              {
                h.vKh.kvStat(10298, paramAnonymousView + ",35");
                paramAnonymousAdapterView.putExtra("Contact_Scene", 35);
              }
              com.tencent.mm.bs.d.b(ContactSearchResultUI.this, "profile", ".ui.ContactInfoUI", paramAnonymousAdapterView);
            }
            AppMethodBeat.o(29206);
            return;
          }
          if ((paramAnonymousAdapterView.DIV & 0x8) > 0) {
            h.vKh.kvStat(10298, paramAnonymousAdapterView.Dby.Ehn + ",35");
          }
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("Contact_User", paramAnonymousAdapterView.Dby.Ehn);
          paramAnonymousView.putExtra("Contact_Alias", paramAnonymousAdapterView.ijR);
          paramAnonymousView.putExtra("Contact_Nick", paramAnonymousAdapterView.DFJ.Ehn);
          paramAnonymousView.putExtra("Contact_Signature", paramAnonymousAdapterView.ijP);
          paramAnonymousView.putExtra("Contact_RegionCode", RegionCodeDecoder.aT(paramAnonymousAdapterView.ijV, paramAnonymousAdapterView.ijN, paramAnonymousAdapterView.ijO));
          paramAnonymousView.putExtra("Contact_Sex", paramAnonymousAdapterView.ijM);
          paramAnonymousView.putExtra("Contact_VUser_Info", paramAnonymousAdapterView.DIW);
          paramAnonymousView.putExtra("Contact_VUser_Info_Flag", paramAnonymousAdapterView.DIV);
          paramAnonymousView.putExtra("Contact_KWeibo_flag", paramAnonymousAdapterView.DIZ);
          paramAnonymousView.putExtra("Contact_KWeibo", paramAnonymousAdapterView.DIX);
          paramAnonymousView.putExtra("Contact_KWeiboNick", paramAnonymousAdapterView.DIY);
          paramAnonymousView.putExtra("Contact_KSnsIFlag", paramAnonymousAdapterView.DJb.ijX);
          paramAnonymousView.putExtra("Contact_KSnsBgId", paramAnonymousAdapterView.DJb.ijZ);
          paramAnonymousView.putExtra("Contact_KSnsBgUrl", paramAnonymousAdapterView.DJb.ijY);
          paramAnonymousView.putExtra("Contact_Scene", 35);
          if (i != 0) {
            paramAnonymousView.putExtra("add_more_friend_search_scene", i);
          }
          if (paramAnonymousAdapterView.DJc != null) {}
          try
          {
            paramAnonymousView.putExtra("Contact_customInfo", paramAnonymousAdapterView.DJc.toByteArray());
            if ((paramAnonymousAdapterView.DIV & 0x8) > 0) {
              h.vKh.kvStat(10298, paramAnonymousAdapterView.Dby.Ehn + ",35");
            }
            com.tencent.mm.bs.d.b(ContactSearchResultUI.this, "profile", ".ui.ContactInfoUI", paramAnonymousView);
            AppMethodBeat.o(29206);
            return;
          }
          catch (IOException localIOException)
          {
            for (;;)
            {
              ad.printErrStackTrace("MicroMsg.ContactSearchResultUI", localIOException, "", new Object[0]);
            }
          }
        }
      });
      this.yFT.setOnScrollListener(new a());
      AppMethodBeat.o(29211);
    }
    if ((this.gKs.size() == 0) && (this.yFV.isEmpty()))
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
    p.auH().cancel();
    if (this.yFW != null) {
      this.yFW.clear();
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
        paramViewGroup.frr = ((ImageView)localView.findViewById(2131296997));
        paramViewGroup.fsI = ((TextView)localView.findViewById(2131302864));
        paramViewGroup.mTu = localView.findViewById(2131306278);
        paramViewGroup.mTv = ((TextView)localView.findViewById(2131301045));
        paramViewGroup.mTy = localView.findViewById(2131297275);
        localView.setTag(paramViewGroup);
      }
      for (;;)
      {
        if (paramInt >= ContactSearchResultUI.b(ContactSearchResultUI.this).size())
        {
          paramView = (cny)ContactSearchResultUI.c(ContactSearchResultUI.this).get(paramInt - ContactSearchResultUI.b(ContactSearchResultUI.this).size());
          paramViewGroup.username = paramView.mAQ;
          a.b.d(paramViewGroup.frr, paramViewGroup.username);
          paramViewGroup.frr.setTag(paramViewGroup.username);
          a.b.c(paramViewGroup.frr, paramViewGroup.username);
          paramViewGroup.mTu.setVisibility(8);
          paramViewGroup.mTy.setVisibility(8);
          paramViewGroup.mTv.setText("");
          try
          {
            paramViewGroup.fsI.setText(k.b(this.mContext, paramView.mBV, paramViewGroup.fsI.getTextSize()));
            AppMethodBeat.o(29208);
            return localView;
            paramViewGroup = (ContactSearchResultUI.c)paramView.getTag();
            localView = paramView;
          }
          catch (Exception paramView)
          {
            for (;;)
            {
              paramViewGroup.fsI.setText("");
            }
          }
        }
      }
      cnj localcnj = (cnj)ContactSearchResultUI.b(ContactSearchResultUI.this).get(paramInt);
      if (localcnj == null)
      {
        ad.e("MicroMsg.ContactSearchResultAdapter", "shouldnot be empty");
        AppMethodBeat.o(29208);
        return localView;
      }
      paramViewGroup.username = localcnj.Dby.Ehn;
      a.b.d(paramViewGroup.frr, paramViewGroup.username);
      paramViewGroup.frr.setTag(paramViewGroup.username);
      a.b.c(paramViewGroup.frr, paramViewGroup.username);
      String str = localcnj.Dby.Ehn;
      Object localObject1 = (ContactSearchResultUI.b)ContactSearchResultUI.d(ContactSearchResultUI.this).get(str);
      paramView = (View)localObject1;
      Object localObject2;
      if (localObject1 == null)
      {
        localObject1 = new ContactSearchResultUI.b((byte)0);
        ContactSearchResultUI.d(ContactSearchResultUI.this).put(str, localObject1);
        paramView = localcnj.DJc;
        if (paramView != null)
        {
          localObject2 = new com.tencent.mm.api.c();
          ((com.tencent.mm.api.c)localObject2).field_username = str;
          ((com.tencent.mm.api.c)localObject2).field_brandFlag = paramView.ika;
          ((com.tencent.mm.api.c)localObject2).field_brandIconURL = paramView.ikd;
          ((com.tencent.mm.api.c)localObject2).field_brandInfo = paramView.ikc;
          ((com.tencent.mm.api.c)localObject2).field_extInfo = paramView.ikb;
          if (((com.tencent.mm.api.c)localObject2).bU(false) == null) {
            break label796;
          }
        }
      }
      label796:
      for (paramView = ((com.tencent.mm.api.c)localObject2).bU(false).Jz();; paramView = null)
      {
        boolean bool;
        if (paramView != null)
        {
          if ((!((com.tencent.mm.api.c)localObject2).bU(false).JC()) || (bt.isNullOrNil(paramView.cJc))) {
            break label717;
          }
          bool = true;
        }
        for (;;)
        {
          ((ContactSearchResultUI.b)localObject1).mTs = bool;
          if (localcnj.DIV != 0)
          {
            bool = true;
            label547:
            ((ContactSearchResultUI.b)localObject1).mTr = bool;
            paramView = (View)localObject1;
            localObject1 = paramViewGroup.mTu;
            if (!paramView.mTr) {
              break label729;
            }
            paramInt = 0;
            ((View)localObject1).setVisibility(paramInt);
            localObject1 = paramViewGroup.mTy;
            paramInt = i;
            if (paramView.mTs) {
              paramInt = 0;
            }
            ((View)localObject1).setVisibility(paramInt);
            ad.v("MicroMsg.ContactSearchResultAdapter", "verifyFlay : %d", new Object[] { Integer.valueOf(localcnj.DIV) });
            paramView = bt.nullAsNil(localcnj.ijP);
          }
          try
          {
            paramViewGroup.mTv.setText(k.b(this.mContext, paramView, paramViewGroup.mTv.getTextSize()));
            try
            {
              localObject1 = paramViewGroup.fsI;
              localObject2 = this.mContext;
              if (bt.isNullOrNil(localcnj.DFJ.Ehn)) {
                break label748;
              }
              paramView = localcnj.DFJ.Ehn;
              ((TextView)localObject1).setText(k.b((Context)localObject2, paramView, paramViewGroup.fsI.getTextSize()));
            }
            catch (Exception paramView)
            {
              for (;;)
              {
                paramViewGroup.fsI.setText("");
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
              paramViewGroup.mTv.setText("");
              continue;
              label748:
              if (!bt.isNullOrNil(localcnj.ijR)) {
                paramView = localcnj.ijR;
              } else {
                paramView = bt.nullAsNil(localcnj.Dby.Ehn);
              }
            }
          }
        }
      }
    }
  }
  
  static final class b
  {
    protected boolean mTr;
    protected boolean mTs;
  }
  
  static final class c
  {
    public ImageView frr;
    public TextView fsI;
    public View mTu;
    public TextView mTv;
    View mTy;
    public String username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.pluginapp.ContactSearchResultUI
 * JD-Core Version:    0.7.0.1
 */