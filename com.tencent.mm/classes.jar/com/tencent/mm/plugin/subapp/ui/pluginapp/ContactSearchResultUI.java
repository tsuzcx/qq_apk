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
import com.tencent.mm.aj.d;
import com.tencent.mm.aj.p;
import com.tencent.mm.api.c.b;
import com.tencent.mm.api.c.b.e;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.aeq;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.drr;
import com.tencent.mm.protocal.protobuf.drt;
import com.tencent.mm.protocal.protobuf.dsk;
import com.tencent.mm.protocal.protobuf.ebj;
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
  private static MMHandler iuH;
  private ListView FMX;
  private a FMY;
  private LinkedList<dsk> FMZ;
  private Map<String, b> FNa;
  private LinkedList<drr> iAd;
  
  static
  {
    AppMethodBeat.i(29214);
    iuH = new MMHandler(Looper.getMainLooper());
    AppMethodBeat.o(29214);
  }
  
  public ContactSearchResultUI()
  {
    AppMethodBeat.i(29209);
    this.iAd = new LinkedList();
    this.FMZ = new LinkedList();
    AppMethodBeat.o(29209);
  }
  
  public int getLayoutId()
  {
    return 2131493790;
  }
  
  public void initView()
  {
    AppMethodBeat.i(29211);
    setMMTitle(2131758163);
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
    this.FNa = new HashMap();
    this.FMX = ((ListView)findViewById(2131307036));
    Object localObject = (TextView)findViewById(2131300076);
    this.FMX.setEmptyView((View)localObject);
    localObject = getIntent().getByteArrayExtra("result");
    final int i = getIntent().getIntExtra("add_more_friend_search_scene", 0);
    if (localObject != null) {}
    try
    {
      drt localdrt = (drt)new drt().parseFrom((byte[])localObject);
      if (localdrt != null)
      {
        this.iAd = localdrt.LUC;
        this.FMZ = localdrt.MUq;
      }
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.ContactSearchResultUI", localException2, "SearchContactResponse", new Object[0]);
        try
        {
          localObject = (dsk)new dsk().parseFrom((byte[])localObject);
          this.FMZ.add(localObject);
        }
        catch (Exception localException1)
        {
          Log.printErrStackTrace("MicroMsg.ContactSearchResultUI", localException1, "SearchOpenIMContactItem", new Object[0]);
        }
      }
      this.FMY = new a(this);
      this.FMX.setAdapter(this.FMY);
      this.FMX.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(29206);
          Object localObject = new b();
          ((b)localObject).bm(paramAnonymousAdapterView);
          ((b)localObject).bm(paramAnonymousView);
          ((b)localObject).pH(paramAnonymousInt);
          ((b)localObject).zo(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/subapp/ui/pluginapp/ContactSearchResultUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((b)localObject).axR());
          int i = paramAnonymousInt - ContactSearchResultUI.a(ContactSearchResultUI.this).getHeaderViewsCount();
          if ((i < 0) || (i >= ContactSearchResultUI.a(ContactSearchResultUI.this).getCount()))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/pluginapp/ContactSearchResultUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(29206);
            return;
          }
          if (i >= ContactSearchResultUI.b(ContactSearchResultUI.this).size())
          {
            paramAnonymousAdapterView = (dsk)ContactSearchResultUI.c(ContactSearchResultUI.this).get(paramAnonymousInt - ContactSearchResultUI.b(ContactSearchResultUI.this).size());
            ContactSearchResultUI.a(ContactSearchResultUI.this, paramAnonymousAdapterView);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/pluginapp/ContactSearchResultUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(29206);
            return;
          }
          paramAnonymousAdapterView = (drr)ContactSearchResultUI.b(ContactSearchResultUI.this).get(i);
          paramAnonymousView = paramAnonymousAdapterView.Lqk.MTo;
          bg.aVF();
          localObject = com.tencent.mm.model.c.aSN().Kn(paramAnonymousView);
          if (com.tencent.mm.contact.c.oR(((ax)localObject).field_type))
          {
            paramAnonymousAdapterView = new Intent();
            paramAnonymousAdapterView.putExtra("Contact_User", paramAnonymousView);
            paramAnonymousAdapterView.putExtra("Contact_Scene", 3);
            if ((paramAnonymousView != null) && (paramAnonymousView.length() > 0))
            {
              if (((as)localObject).gBM())
              {
                h.CyF.kvStat(10298, paramAnonymousView + ",35");
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
            if ((paramAnonymousAdapterView.MmK & 0x8) > 0) {
              h.CyF.kvStat(10298, paramAnonymousAdapterView.Lqk.MTo + ",35");
            }
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("Contact_User", paramAnonymousAdapterView.Lqk.MTo);
            paramAnonymousView.putExtra("Contact_Alias", paramAnonymousAdapterView.ked);
            paramAnonymousView.putExtra("Contact_Nick", paramAnonymousAdapterView.Mjj.MTo);
            paramAnonymousView.putExtra("Contact_Signature", paramAnonymousAdapterView.keb);
            paramAnonymousView.putExtra("Contact_RegionCode", RegionCodeDecoder.bq(paramAnonymousAdapterView.keh, paramAnonymousAdapterView.kdZ, paramAnonymousAdapterView.kea));
            paramAnonymousView.putExtra("Contact_Sex", paramAnonymousAdapterView.kdY);
            paramAnonymousView.putExtra("Contact_VUser_Info", paramAnonymousAdapterView.MmL);
            paramAnonymousView.putExtra("Contact_VUser_Info_Flag", paramAnonymousAdapterView.MmK);
            paramAnonymousView.putExtra("Contact_KWeibo_flag", paramAnonymousAdapterView.MmO);
            paramAnonymousView.putExtra("Contact_KWeibo", paramAnonymousAdapterView.MmM);
            paramAnonymousView.putExtra("Contact_KWeiboNick", paramAnonymousAdapterView.MmN);
            paramAnonymousView.putExtra("Contact_KSnsIFlag", paramAnonymousAdapterView.MmQ.kej);
            paramAnonymousView.putExtra("Contact_KSnsBgId", paramAnonymousAdapterView.MmQ.kel);
            paramAnonymousView.putExtra("Contact_KSnsBgUrl", paramAnonymousAdapterView.MmQ.kek);
            paramAnonymousView.putExtra("Contact_Scene", 35);
            if (i != 0) {
              paramAnonymousView.putExtra("add_more_friend_search_scene", i);
            }
            if (paramAnonymousAdapterView.MmR != null) {}
            try
            {
              paramAnonymousView.putExtra("Contact_customInfo", paramAnonymousAdapterView.MmR.toByteArray());
              if ((paramAnonymousAdapterView.MmK & 0x8) > 0) {
                h.CyF.kvStat(10298, paramAnonymousAdapterView.Lqk.MTo + ",35");
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
      this.FMX.setOnScrollListener(new com.tencent.mm.ui.applet.a());
      AppMethodBeat.o(29211);
    }
    if ((this.iAd.size() == 0) && (this.FMZ.isEmpty()))
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
    p.aYD().cancel();
    if (this.FNa != null) {
      this.FNa.clear();
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
        localView = View.inflate(this.mContext, 2131496186, null);
        paramViewGroup = new ContactSearchResultUI.c();
        paramViewGroup.gvv = ((ImageView)localView.findViewById(2131297120));
        paramViewGroup.gwR = ((TextView)localView.findViewById(2131305437));
        paramViewGroup.pnQ = localView.findViewById(2131309689);
        paramViewGroup.pnR = ((TextView)localView.findViewById(2131302698));
        paramViewGroup.pnU = localView.findViewById(2131297432);
        localView.setTag(paramViewGroup);
      }
      for (;;)
      {
        if (paramInt >= ContactSearchResultUI.b(ContactSearchResultUI.this).size())
        {
          paramView = (dsk)ContactSearchResultUI.c(ContactSearchResultUI.this).get(paramInt - ContactSearchResultUI.b(ContactSearchResultUI.this).size());
          paramViewGroup.username = paramView.UserName;
          a.b.d(paramViewGroup.gvv, paramViewGroup.username);
          paramViewGroup.gvv.setTag(paramViewGroup.username);
          a.b.c(paramViewGroup.gvv, paramViewGroup.username);
          paramViewGroup.pnQ.setVisibility(8);
          paramViewGroup.pnU.setVisibility(8);
          paramViewGroup.pnR.setText("");
          try
          {
            paramViewGroup.gwR.setText(l.b(this.mContext, paramView.oUJ, paramViewGroup.gwR.getTextSize()));
            AppMethodBeat.o(29208);
            return localView;
            paramViewGroup = (ContactSearchResultUI.c)paramView.getTag();
            localView = paramView;
          }
          catch (Exception paramView)
          {
            for (;;)
            {
              paramViewGroup.gwR.setText("");
            }
          }
        }
      }
      drr localdrr = (drr)ContactSearchResultUI.b(ContactSearchResultUI.this).get(paramInt);
      if (localdrr == null)
      {
        Log.e("MicroMsg.ContactSearchResultAdapter", "shouldnot be empty");
        AppMethodBeat.o(29208);
        return localView;
      }
      paramViewGroup.username = localdrr.Lqk.MTo;
      a.b.d(paramViewGroup.gvv, paramViewGroup.username);
      paramViewGroup.gvv.setTag(paramViewGroup.username);
      a.b.c(paramViewGroup.gvv, paramViewGroup.username);
      String str = localdrr.Lqk.MTo;
      Object localObject1 = (ContactSearchResultUI.b)ContactSearchResultUI.d(ContactSearchResultUI.this).get(str);
      paramView = (View)localObject1;
      Object localObject2;
      if (localObject1 == null)
      {
        localObject1 = new ContactSearchResultUI.b((byte)0);
        ContactSearchResultUI.d(ContactSearchResultUI.this).put(str, localObject1);
        paramView = localdrr.MmR;
        if (paramView != null)
        {
          localObject2 = new com.tencent.mm.api.c();
          ((com.tencent.mm.api.c)localObject2).field_username = str;
          ((com.tencent.mm.api.c)localObject2).field_brandFlag = paramView.kem;
          ((com.tencent.mm.api.c)localObject2).field_brandIconURL = paramView.kep;
          ((com.tencent.mm.api.c)localObject2).field_brandInfo = paramView.keo;
          ((com.tencent.mm.api.c)localObject2).field_extInfo = paramView.ken;
          if (((com.tencent.mm.api.c)localObject2).cG(false) == null) {
            break label796;
          }
        }
      }
      label796:
      for (paramView = ((com.tencent.mm.api.c)localObject2).cG(false).Va();; paramView = null)
      {
        boolean bool;
        if (paramView != null)
        {
          if ((!((com.tencent.mm.api.c)localObject2).cG(false).Vc()) || (Util.isNullOrNil(paramView.diq))) {
            break label717;
          }
          bool = true;
        }
        for (;;)
        {
          ((ContactSearchResultUI.b)localObject1).pnO = bool;
          if (localdrr.MmK != 0)
          {
            bool = true;
            label547:
            ((ContactSearchResultUI.b)localObject1).pnN = bool;
            paramView = (View)localObject1;
            localObject1 = paramViewGroup.pnQ;
            if (!paramView.pnN) {
              break label729;
            }
            paramInt = 0;
            ((View)localObject1).setVisibility(paramInt);
            localObject1 = paramViewGroup.pnU;
            paramInt = i;
            if (paramView.pnO) {
              paramInt = 0;
            }
            ((View)localObject1).setVisibility(paramInt);
            Log.v("MicroMsg.ContactSearchResultAdapter", "verifyFlay : %d", new Object[] { Integer.valueOf(localdrr.MmK) });
            paramView = Util.nullAsNil(localdrr.keb);
          }
          try
          {
            paramViewGroup.pnR.setText(l.b(this.mContext, paramView, paramViewGroup.pnR.getTextSize()));
            try
            {
              localObject1 = paramViewGroup.gwR;
              localObject2 = this.mContext;
              if (Util.isNullOrNil(localdrr.Mjj.MTo)) {
                break label748;
              }
              paramView = localdrr.Mjj.MTo;
              ((TextView)localObject1).setText(l.b((Context)localObject2, paramView, paramViewGroup.gwR.getTextSize()));
            }
            catch (Exception paramView)
            {
              for (;;)
              {
                paramViewGroup.gwR.setText("");
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
              paramViewGroup.pnR.setText("");
              continue;
              label748:
              if (!Util.isNullOrNil(localdrr.ked)) {
                paramView = localdrr.ked;
              } else {
                paramView = Util.nullAsNil(localdrr.Lqk.MTo);
              }
            }
          }
        }
      }
    }
  }
  
  static final class b
  {
    protected boolean pnN;
    protected boolean pnO;
  }
  
  static final class c
  {
    public ImageView gvv;
    public TextView gwR;
    public View pnQ;
    public TextView pnR;
    View pnU;
    public String username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.pluginapp.ContactSearchResultUI
 * JD-Core Version:    0.7.0.1
 */