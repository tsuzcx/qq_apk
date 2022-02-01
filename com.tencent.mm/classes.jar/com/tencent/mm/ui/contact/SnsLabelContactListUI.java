package com.tencent.mm.ui.contact;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.app.WorkerProfile;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.lw;
import com.tencent.mm.autogen.a.lw.b;
import com.tencent.mm.autogen.a.vk;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.contact.d;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.sns.c.k;
import com.tencent.mm.plugin.sns.c.q;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class SnsLabelContactListUI
  extends MMActivity
{
  private ListView JVY;
  private SnsObject PJP;
  private String StT;
  private SnsLabelContactListUI.a afiL;
  private ArrayList<String> afiM;
  private int afiN;
  private ReturnSnsObjectDetailEventListener afiO;
  
  public SnsLabelContactListUI()
  {
    AppMethodBeat.i(38070);
    this.afiM = new ArrayList();
    AppMethodBeat.o(38070);
  }
  
  private void eBg()
  {
    AppMethodBeat.i(38072);
    if ((this.PJP.ExtFlag & 0x1) == 0)
    {
      AppMethodBeat.o(38072);
      return;
    }
    Iterator localIterator;
    if ((this.PJP.ExtFlag & 0x2) > 0)
    {
      this.StT = getString(R.l.sns_label_can_not_see);
      localIterator = this.PJP.BlackList.iterator();
      while (localIterator.hasNext()) {
        this.afiM.add(((etl)localIterator.next()).abwM);
      }
      AppMethodBeat.o(38072);
      return;
    }
    if ((this.PJP.ExtFlag & 0x4) > 0)
    {
      this.StT = getString(R.l.sns_label_can_see);
      localIterator = this.PJP.GroupUser.iterator();
      while (localIterator.hasNext()) {
        this.afiM.add(((etl)localIterator.next()).abwM);
      }
    }
    AppMethodBeat.o(38072);
  }
  
  public int getLayoutId()
  {
    return R.i.address;
  }
  
  public void initView()
  {
    AppMethodBeat.i(38073);
    setMMTitle(this.StT);
    findViewById(R.h.loading_tips_area).setVisibility(8);
    this.JVY = ((ListView)findViewById(R.h.address_contactlist));
    ((TextView)findViewById(R.h.fGB)).setVisibility(8);
    findViewById(R.h.fqN).setVisibility(8);
    this.JVY.setBackgroundColor(getResources().getColor(R.e.white));
    ((View)this.JVY.getParent()).setBackgroundColor(getResources().getColor(R.e.white));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(38062);
        SnsLabelContactListUI.this.finish();
        AppMethodBeat.o(38062);
        return true;
      }
    });
    showOptionMenu(false);
    if ((this.afiM != null) && (this.afiM.size() != 0))
    {
      this.afiL = new SnsLabelContactListUI.a(this, this.afiM);
      this.JVY.setAdapter(this.afiL);
      this.JVY.setVisibility(0);
      this.JVY.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(38063);
          Object localObject = new b();
          ((b)localObject).cH(paramAnonymousAdapterView);
          ((b)localObject).cH(paramAnonymousView);
          ((b)localObject).sc(paramAnonymousInt);
          ((b)localObject).hB(paramAnonymousLong);
          a.c("com/tencent/mm/ui/contact/SnsLabelContactListUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((b)localObject).aYj());
          paramAnonymousView = new Intent();
          paramAnonymousAdapterView = (d)SnsLabelContactListUI.a(SnsLabelContactListUI.this).getItem(paramAnonymousInt);
          localObject = q.Qkn;
          if (localObject == null)
          {
            SnsLabelContactListUI.this.finish();
            a.a(this, "com/tencent/mm/ui/contact/SnsLabelContactListUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(38063);
            return;
          }
          paramAnonymousView = ((k)localObject).h(paramAnonymousView, paramAnonymousAdapterView.field_username);
          if (paramAnonymousView == null)
          {
            SnsLabelContactListUI.this.finish();
            a.a(this, "com/tencent/mm/ui/contact/SnsLabelContactListUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(38063);
            return;
          }
          paramAnonymousView.putExtra("Contact_User", paramAnonymousAdapterView.field_username);
          WorkerProfile.aDF().hjU.c(paramAnonymousView, SnsLabelContactListUI.this);
          a.a(this, "com/tencent/mm/ui/contact/SnsLabelContactListUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(38063);
        }
      });
    }
    AppMethodBeat.o(38073);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(38071);
    super.onCreate(paramBundle);
    this.afiO = new ReturnSnsObjectDetailEventListener();
    this.afiO.alive();
    this.afiN = getIntent().getIntExtra("sns_label_sns_info", -1);
    if (this.afiN == -1)
    {
      finish();
      AppMethodBeat.o(38071);
      return;
    }
    paramBundle = new lw();
    paramBundle.hNL.hGM = this.afiN;
    paramBundle.publish();
    this.PJP = paramBundle.hNM.hNN;
    if ((this.PJP != null) && (((this.PJP.ExtFlag == 3) && (this.PJP.BlackList != null) && (this.PJP.BlackList.size() > 0)) || ((this.PJP.ExtFlag == 5) && (this.PJP.GroupUser != null) && (this.PJP.GroupUser.size() > 0))))
    {
      eBg();
      initView();
    }
    AppMethodBeat.o(38071);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(38075);
    this.afiO.dead();
    super.onDestroy();
    AppMethodBeat.o(38075);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(38074);
    super.onResume();
    if (this.afiL != null) {
      this.afiL.notifyDataSetChanged();
    }
    AppMethodBeat.o(38074);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  class ReturnSnsObjectDetailEventListener
    extends IListener<vk>
  {
    public ReturnSnsObjectDetailEventListener()
    {
      super();
      AppMethodBeat.i(161549);
      this.__eventId = vk.class.getName().hashCode();
      AppMethodBeat.o(161549);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SnsLabelContactListUI
 * JD-Core Version:    0.7.0.1
 */