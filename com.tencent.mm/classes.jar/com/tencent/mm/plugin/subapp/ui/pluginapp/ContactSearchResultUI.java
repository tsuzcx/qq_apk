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
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.am.e;
import com.tencent.mm.am.q;
import com.tencent.mm.api.c.b;
import com.tencent.mm.api.c.b.e;
import com.tencent.mm.contact.d;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.aez;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.ebn;
import com.tencent.mm.protocal.protobuf.ebp;
import com.tencent.mm.protocal.protobuf.ecg;
import com.tencent.mm.protocal.protobuf.elj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ContactSearchResultUI
  extends MMActivity
{
  private static MMHandler ljQ;
  private ListView MgZ;
  private a Mha;
  private LinkedList<ecg> Mhb;
  private Map<String, b> Mhc;
  private LinkedList<ebn> lpz;
  
  static
  {
    AppMethodBeat.i(29214);
    ljQ = new MMHandler(Looper.getMainLooper());
    AppMethodBeat.o(29214);
  }
  
  public ContactSearchResultUI()
  {
    AppMethodBeat.i(29209);
    this.lpz = new LinkedList();
    this.Mhb = new LinkedList();
    AppMethodBeat.o(29209);
  }
  
  public int getLayoutId()
  {
    return R.i.efE;
  }
  
  public void initView()
  {
    AppMethodBeat.i(29211);
    setMMTitle(R.l.efE);
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
    this.Mhc = new HashMap();
    this.MgZ = ((ListView)findViewById(R.h.dSP));
    Object localObject = (TextView)findViewById(R.h.empty);
    this.MgZ.setEmptyView((View)localObject);
    localObject = getIntent().getByteArrayExtra("result");
    final int i = getIntent().getIntExtra("add_more_friend_search_scene", 0);
    if (localObject != null) {}
    try
    {
      ebp localebp = (ebp)new ebp().parseFrom((byte[])localObject);
      if (localebp != null)
      {
        this.lpz = localebp.Tdk;
        this.Mhb = localebp.Ugz;
      }
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.ContactSearchResultUI", localException2, "SearchContactResponse", new Object[0]);
        try
        {
          localObject = (ecg)new ecg().parseFrom((byte[])localObject);
          this.Mhb.add(localObject);
        }
        catch (Exception localException1)
        {
          Log.printErrStackTrace("MicroMsg.ContactSearchResultUI", localException1, "SearchOpenIMContactItem", new Object[0]);
        }
      }
      this.Mha = new a(this);
      this.MgZ.setAdapter(this.Mha);
      this.MgZ.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(29206);
          Object localObject = new b();
          ((b)localObject).bn(paramAnonymousAdapterView);
          ((b)localObject).bn(paramAnonymousView);
          ((b)localObject).sg(paramAnonymousInt);
          ((b)localObject).Fs(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/subapp/ui/pluginapp/ContactSearchResultUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((b)localObject).aFi());
          int i = paramAnonymousInt - ContactSearchResultUI.a(ContactSearchResultUI.this).getHeaderViewsCount();
          if ((i < 0) || (i >= ContactSearchResultUI.a(ContactSearchResultUI.this).getCount()))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/pluginapp/ContactSearchResultUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(29206);
            return;
          }
          if (i >= ContactSearchResultUI.b(ContactSearchResultUI.this).size())
          {
            paramAnonymousAdapterView = (ecg)ContactSearchResultUI.c(ContactSearchResultUI.this).get(paramAnonymousInt - ContactSearchResultUI.b(ContactSearchResultUI.this).size());
            ContactSearchResultUI.a(ContactSearchResultUI.this, paramAnonymousAdapterView);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/pluginapp/ContactSearchResultUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(29206);
            return;
          }
          paramAnonymousAdapterView = (ebn)ContactSearchResultUI.b(ContactSearchResultUI.this).get(i);
          paramAnonymousView = paramAnonymousAdapterView.SrH.Ufy;
          bh.beI();
          localObject = com.tencent.mm.model.c.bbL().RG(paramAnonymousView);
          if (d.rk(((ax)localObject).field_type))
          {
            paramAnonymousAdapterView = new Intent();
            paramAnonymousAdapterView.putExtra("Contact_User", paramAnonymousView);
            paramAnonymousAdapterView.putExtra("Contact_Scene", 3);
            if ((paramAnonymousView != null) && (paramAnonymousView.length() > 0))
            {
              if (((as)localObject).hxX())
              {
                h.IzE.kvStat(10298, paramAnonymousView + ",35");
                paramAnonymousAdapterView.putExtra("Contact_Scene", 35);
              }
              com.tencent.mm.by.c.b(ContactSearchResultUI.this, "profile", ".ui.ContactInfoUI", paramAnonymousAdapterView);
            }
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/pluginapp/ContactSearchResultUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(29206);
            return;
            if ((paramAnonymousAdapterView.TxF & 0x8) > 0) {
              h.IzE.kvStat(10298, paramAnonymousAdapterView.SrH.Ufy + ",35");
            }
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("Contact_User", paramAnonymousAdapterView.SrH.Ufy);
            paramAnonymousView.putExtra("Contact_Alias", paramAnonymousAdapterView.mVD);
            paramAnonymousView.putExtra("Contact_Nick", paramAnonymousAdapterView.TtX.Ufy);
            paramAnonymousView.putExtra("Contact_Signature", paramAnonymousAdapterView.mVB);
            paramAnonymousView.putExtra("Contact_RegionCode", RegionCodeDecoder.bl(paramAnonymousAdapterView.mVH, paramAnonymousAdapterView.mVz, paramAnonymousAdapterView.mVA));
            paramAnonymousView.putExtra("Contact_Sex", paramAnonymousAdapterView.mVy);
            paramAnonymousView.putExtra("Contact_VUser_Info", paramAnonymousAdapterView.TxG);
            paramAnonymousView.putExtra("Contact_VUser_Info_Flag", paramAnonymousAdapterView.TxF);
            paramAnonymousView.putExtra("Contact_KWeibo_flag", paramAnonymousAdapterView.TxJ);
            paramAnonymousView.putExtra("Contact_KWeibo", paramAnonymousAdapterView.TxH);
            paramAnonymousView.putExtra("Contact_KWeiboNick", paramAnonymousAdapterView.TxI);
            paramAnonymousView.putExtra("Contact_KSnsIFlag", paramAnonymousAdapterView.TxL.mVJ);
            paramAnonymousView.putExtra("Contact_KSnsBgId", paramAnonymousAdapterView.TxL.mVL);
            paramAnonymousView.putExtra("Contact_KSnsBgUrl", paramAnonymousAdapterView.TxL.mVK);
            paramAnonymousView.putExtra("Contact_Scene", 35);
            if (i != 0) {
              paramAnonymousView.putExtra("add_more_friend_search_scene", i);
            }
            if (paramAnonymousAdapterView.TxM != null) {}
            try
            {
              paramAnonymousView.putExtra("Contact_customInfo", paramAnonymousAdapterView.TxM.toByteArray());
              if ((paramAnonymousAdapterView.TxF & 0x8) > 0) {
                h.IzE.kvStat(10298, paramAnonymousAdapterView.SrH.Ufy + ",35");
              }
              com.tencent.mm.by.c.b(ContactSearchResultUI.this, "profile", ".ui.ContactInfoUI", paramAnonymousView);
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
      this.MgZ.setOnScrollListener(new com.tencent.mm.ui.applet.a());
      AppMethodBeat.o(29211);
    }
    if ((this.lpz.size() == 0) && (this.Mhb.isEmpty()))
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
    q.bhR().cancel();
    if (this.Mhc != null) {
      this.Mhc.clear();
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
        localView = View.inflate(this.mContext, R.i.ekH, null);
        paramViewGroup = new ContactSearchResultUI.c();
        paramViewGroup.iZG = ((ImageView)localView.findViewById(R.h.dsd));
        paramViewGroup.jbe = ((TextView)localView.findViewById(R.h.dPq));
        paramViewGroup.swQ = localView.findViewById(R.h.dYC);
        paramViewGroup.swR = ((TextView)localView.findViewById(R.h.dJj));
        paramViewGroup.swU = localView.findViewById(R.h.dti);
        localView.setTag(paramViewGroup);
      }
      for (;;)
      {
        if (paramInt >= ContactSearchResultUI.b(ContactSearchResultUI.this).size())
        {
          paramView = (ecg)ContactSearchResultUI.c(ContactSearchResultUI.this).get(paramInt - ContactSearchResultUI.b(ContactSearchResultUI.this).size());
          paramViewGroup.username = paramView.UserName;
          a.b.d(paramViewGroup.iZG, paramViewGroup.username);
          paramViewGroup.iZG.setTag(paramViewGroup.username);
          a.b.c(paramViewGroup.iZG, paramViewGroup.username);
          paramViewGroup.swQ.setVisibility(8);
          paramViewGroup.swU.setVisibility(8);
          paramViewGroup.swR.setText("");
          try
          {
            paramViewGroup.jbe.setText(l.b(this.mContext, paramView.rWI, paramViewGroup.jbe.getTextSize()));
            AppMethodBeat.o(29208);
            return localView;
            paramViewGroup = (ContactSearchResultUI.c)paramView.getTag();
            localView = paramView;
          }
          catch (Exception paramView)
          {
            for (;;)
            {
              paramViewGroup.jbe.setText("");
            }
          }
        }
      }
      ebn localebn = (ebn)ContactSearchResultUI.b(ContactSearchResultUI.this).get(paramInt);
      if (localebn == null)
      {
        Log.e("MicroMsg.ContactSearchResultAdapter", "shouldnot be empty");
        AppMethodBeat.o(29208);
        return localView;
      }
      paramViewGroup.username = localebn.SrH.Ufy;
      a.b.d(paramViewGroup.iZG, paramViewGroup.username);
      paramViewGroup.iZG.setTag(paramViewGroup.username);
      a.b.c(paramViewGroup.iZG, paramViewGroup.username);
      String str = localebn.SrH.Ufy;
      Object localObject1 = (ContactSearchResultUI.b)ContactSearchResultUI.d(ContactSearchResultUI.this).get(str);
      paramView = (View)localObject1;
      Object localObject2;
      if (localObject1 == null)
      {
        localObject1 = new ContactSearchResultUI.b((byte)0);
        ContactSearchResultUI.d(ContactSearchResultUI.this).put(str, localObject1);
        paramView = localebn.TxM;
        if (paramView != null)
        {
          localObject2 = new com.tencent.mm.api.c();
          ((com.tencent.mm.api.c)localObject2).field_username = str;
          ((com.tencent.mm.api.c)localObject2).field_brandFlag = paramView.mVM;
          ((com.tencent.mm.api.c)localObject2).field_brandIconURL = paramView.mVP;
          ((com.tencent.mm.api.c)localObject2).field_brandInfo = paramView.mVO;
          ((com.tencent.mm.api.c)localObject2).field_extInfo = paramView.mVN;
          if (((com.tencent.mm.api.c)localObject2).dc(false) == null) {
            break label803;
          }
        }
      }
      label803:
      for (paramView = ((com.tencent.mm.api.c)localObject2).dc(false).Zs();; paramView = null)
      {
        boolean bool;
        if (paramView != null)
        {
          if ((!((com.tencent.mm.api.c)localObject2).dc(false).Zu()) || (Util.isNullOrNil(paramView.eZX))) {
            break label724;
          }
          bool = true;
        }
        for (;;)
        {
          ((ContactSearchResultUI.b)localObject1).swO = bool;
          if (localebn.TxF != 0)
          {
            bool = true;
            label553:
            ((ContactSearchResultUI.b)localObject1).swN = bool;
            paramView = (View)localObject1;
            localObject1 = paramViewGroup.swQ;
            if (!paramView.swN) {
              break label736;
            }
            paramInt = 0;
            ((View)localObject1).setVisibility(paramInt);
            localObject1 = paramViewGroup.swU;
            paramInt = i;
            if (paramView.swO) {
              paramInt = 0;
            }
            ((View)localObject1).setVisibility(paramInt);
            Log.v("MicroMsg.ContactSearchResultAdapter", "verifyFlay : %d", new Object[] { Integer.valueOf(localebn.TxF) });
            paramView = Util.nullAsNil(localebn.mVB);
          }
          try
          {
            paramViewGroup.swR.setText(l.b(this.mContext, paramView, paramViewGroup.swR.getTextSize()));
            try
            {
              localObject1 = paramViewGroup.jbe;
              localObject2 = this.mContext;
              if (Util.isNullOrNil(localebn.TtX.Ufy)) {
                break label755;
              }
              paramView = localebn.TtX.Ufy;
              ((TextView)localObject1).setText(l.b((Context)localObject2, paramView, paramViewGroup.jbe.getTextSize()));
            }
            catch (Exception paramView)
            {
              for (;;)
              {
                paramViewGroup.jbe.setText("");
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
              paramViewGroup.swR.setText("");
              continue;
              label755:
              if (!Util.isNullOrNil(localebn.mVD)) {
                paramView = localebn.mVD;
              } else {
                paramView = Util.nullAsNil(localebn.SrH.Ufy);
              }
            }
          }
        }
      }
    }
  }
  
  static final class b
  {
    protected boolean swN;
    protected boolean swO;
  }
  
  static final class c
  {
    public ImageView iZG;
    public TextView jbe;
    public View swQ;
    public TextView swR;
    View swU;
    public String username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.pluginapp.ContactSearchResultUI
 * JD-Core Version:    0.7.0.1
 */