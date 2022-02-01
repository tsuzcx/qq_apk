package com.tencent.mm.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.x;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.av.q;
import com.tencent.mm.modelappbrand.d;
import com.tencent.mm.modelappbrand.d.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.o;
import com.tencent.mm.protocal.protobuf.bmq;
import com.tencent.mm.protocal.protobuf.ddm;
import com.tencent.mm.protocal.protobuf.ejf;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import java.util.Iterator;
import java.util.LinkedList;

public class AppBrandNotifySettingsUI
  extends MMActivity
{
  private p BmD;
  private a Jnw;
  private DataSetObserver Tf;
  private String jGj;
  private com.tencent.mm.sdk.b.c<com.tencent.mm.g.a.n> mFa;
  private ListView mListView;
  private int qpM;
  
  public AppBrandNotifySettingsUI()
  {
    AppMethodBeat.i(186878);
    this.mFa = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(186878);
  }
  
  protected int getLayoutId()
  {
    return 2131493100;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(186879);
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    this.jGj = paramBundle.getStringExtra("report_session_id");
    paramBundle = paramBundle.getStringExtra("title");
    if (TextUtils.isEmpty(paramBundle)) {
      setMMTitle(2131757130);
    }
    for (;;)
    {
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(186864);
          AppBrandNotifySettingsUI.this.finish();
          AppMethodBeat.o(186864);
          return false;
        }
      });
      this.mListView = ((ListView)findViewById(2131301457));
      this.Jnw = new a(getLayoutInflater());
      this.mListView.setAdapter(this.Jnw);
      getString(2131755906);
      this.BmD = h.b(this, getString(2131755936), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(186865);
          AppBrandNotifySettingsUI.this.finish();
          AppMethodBeat.o(186865);
        }
      });
      this.Tf = new DataSetObserver()
      {
        public final void onChanged()
        {
          AppMethodBeat.i(186866);
          View localView = AppBrandNotifySettingsUI.this.findViewById(2131301445);
          if (AppBrandNotifySettingsUI.a(AppBrandNotifySettingsUI.this).isEmpty()) {}
          for (int i = 4;; i = 0)
          {
            localView.setVisibility(i);
            AppMethodBeat.o(186866);
            return;
          }
        }
      };
      this.Jnw.registerDataSetObserver(this.Tf);
      com.tencent.mm.kernel.g.ajP();
      this.qpM = com.tencent.mm.kernel.a.getUin();
      paramBundle = com.tencent.mm.modelappbrand.c.hNi;
      x.a(com.tencent.mm.modelappbrand.c.a.aDS(), new x.a()
      {
        public final int a(int paramAnonymousInt1, int paramAnonymousInt2, final String paramAnonymousString, b paramAnonymousb, com.tencent.mm.ak.n paramAnonymousn)
        {
          AppMethodBeat.i(186869);
          ae.d("MicroMsg.AppBrandNotifySettingsUI", "getNotifyMsgInfo errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          if (AppBrandNotifySettingsUI.b(AppBrandNotifySettingsUI.this) != null) {
            AppBrandNotifySettingsUI.b(AppBrandNotifySettingsUI.this).dismiss();
          }
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            t.makeText(AppBrandNotifySettingsUI.this, 2131761752, 0).show();
            AppMethodBeat.o(186869);
            return 0;
          }
          paramAnonymousString = (bmq)paramAnonymousb.hQE.hQJ;
          if (paramAnonymousString.GZZ == null)
          {
            ae.e("MicroMsg.AppBrandNotifySettingsUI", "wxa_msg_config_list not exist");
            AppMethodBeat.o(186869);
            return 0;
          }
          AppBrandNotifySettingsUI.this.runOnUiThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(186868);
              if (paramAnonymousString.GZZ == null)
              {
                ae.i("MicroMsg.AppBrandNotifySettingsUI", "getNotifyMsgInfo, configList is null");
                AppMethodBeat.o(186868);
                return;
              }
              AppBrandNotifySettingsUI.a(AppBrandNotifySettingsUI.this, paramAnonymousString.GZZ);
              AppBrandNotifySettingsUI.bp(paramAnonymousString.GZZ);
              AppMethodBeat.o(186868);
            }
          });
          AppMethodBeat.o(186869);
          return 0;
        }
      }, true, this);
      com.tencent.mm.sdk.b.a.IvT.c(this.mFa);
      AppMethodBeat.o(186879);
      return;
      setMMTitle(paramBundle);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(186880);
    Object localObject1 = (o)com.tencent.mm.kernel.g.ab(o.class);
    final LinkedList localLinkedList = new LinkedList();
    Object localObject2 = this.Jnw.JnC;
    if ((localObject2 != null) && (!((LinkedList)localObject2).isEmpty()))
    {
      localObject2 = ((LinkedList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        AppBrandNotifySettingsUI.a.a locala = (AppBrandNotifySettingsUI.a.a)((Iterator)localObject2).next();
        ejf localejf = new ejf();
        Object localObject3 = ((o)localObject1).Ob(locala.username);
        if (localObject3 == null)
        {
          ae.i("MicroMsg.AppBrandNotifySettingsUI", "get attribute fail, username: %s", new Object[] { locala.username });
        }
        else
        {
          localObject3 = ((WxaAttributes)localObject3).field_appId;
          if (locala.JnG) {}
          for (int i = 1;; i = 0)
          {
            localejf.dwb = ((String)localObject3);
            localejf.status = i;
            localLinkedList.add(localejf);
            ae.d("MicroMsg.AppBrandNotifySettingsUI", "stev report(%s), eventId : %d, appId %s, status %d", new Object[] { Integer.valueOf(19724), Integer.valueOf(5), localObject3, Integer.valueOf(i) });
            com.tencent.mm.plugin.report.service.g.yxI.f(19724, new Object[] { Integer.valueOf(1), Integer.valueOf(5), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localObject3, null, null, null, Integer.valueOf(0), null, null, Integer.valueOf(0), null, null, this.jGj });
            break;
          }
        }
      }
    }
    if (!localLinkedList.isEmpty())
    {
      localObject1 = new ddm();
      ((ddm)localObject1).GZZ = localLinkedList;
      ((ddm)localObject1).scene = 1;
      localObject2 = d.hNj;
      x.a(d.a.a((ddm)localObject1), new x.a()
      {
        public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, b paramAnonymousb, com.tencent.mm.ak.n paramAnonymousn)
        {
          AppMethodBeat.i(186867);
          ae.d("MicroMsg.AppBrandNotifySettingsUI", "setReceiveOff errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            t.makeText(AppBrandNotifySettingsUI.this, 2131761765, 0).show();
            AppMethodBeat.o(186867);
            return 0;
          }
          AppBrandNotifySettingsUI.bp(localLinkedList);
          AppMethodBeat.o(186867);
          return 0;
        }
      }, true);
    }
    this.Jnw.unregisterDataSetObserver(this.Tf);
    com.tencent.mm.sdk.b.a.IvT.d(this.mFa);
    super.onDestroy();
    AppMethodBeat.o(186880);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
    extends BaseAdapter
  {
    LinkedList<a> JnB;
    LinkedList<a> JnC;
    private AppBrandNotifySettingsUI.a.b.a JnD;
    private com.tencent.mm.av.a.a.c JnE;
    private LayoutInflater mLayoutInflater;
    
    public a(LayoutInflater paramLayoutInflater)
    {
      AppMethodBeat.i(186873);
      this.mLayoutInflater = paramLayoutInflater;
      this.JnB = new LinkedList();
      this.JnC = new LinkedList();
      this.JnD = new AppBrandNotifySettingsUI.a.b.a()
      {
        public final void a(AppBrandNotifySettingsUI.a.a paramAnonymousa, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(186870);
          if (paramAnonymousa == null)
          {
            AppMethodBeat.o(186870);
            return;
          }
          Iterator localIterator = AppBrandNotifySettingsUI.a.a(AppBrandNotifySettingsUI.a.this).iterator();
          while (localIterator.hasNext())
          {
            AppBrandNotifySettingsUI.a.a locala = (AppBrandNotifySettingsUI.a.a)localIterator.next();
            if ((locala != null) && (bu.nullAsNil(locala.username).equals(paramAnonymousa.username)))
            {
              if (paramAnonymousa.JnG != paramAnonymousBoolean)
              {
                AppBrandNotifySettingsUI.a.b(AppBrandNotifySettingsUI.a.this).add(locala);
                AppMethodBeat.o(186870);
                return;
              }
              AppBrandNotifySettingsUI.a.b(AppBrandNotifySettingsUI.a.this).remove(locala);
              AppMethodBeat.o(186870);
              return;
            }
          }
          AppMethodBeat.o(186870);
        }
      };
      paramLayoutInflater = new com.tencent.mm.av.a.a.c.a();
      paramLayoutInflater.hhW = true;
      paramLayoutInflater.igz = com.tencent.mm.modelappbrand.a.a.aEk();
      this.JnE = paramLayoutInflater.aJu();
      AppMethodBeat.o(186873);
    }
    
    public final a abZ(int paramInt)
    {
      AppMethodBeat.i(186875);
      a locala = (a)this.JnB.get(paramInt);
      AppMethodBeat.o(186875);
      return locala;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(186874);
      int i = this.JnB.size();
      AppMethodBeat.o(186874);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(186876);
      a locala = abZ(paramInt);
      if (paramView == null)
      {
        paramView = this.mLayoutInflater.inflate(2131493101, paramViewGroup, false);
        paramViewGroup = new c((byte)0);
        paramViewGroup.fTj = ((ImageView)paramView.findViewById(2131296998));
        paramViewGroup.titleTv = ((TextView)paramView.findViewById(2131305906));
        paramViewGroup.JnL = ((MMSwitchBtn)paramView.findViewById(2131296893));
        paramViewGroup.iYM = paramView.findViewById(2131296895);
        paramView.setTag(paramViewGroup);
        q.aJb().a(locala.url, paramViewGroup.fTj, this.JnE);
        paramViewGroup.titleTv.setText(locala.title);
        paramViewGroup.JnL.setCheck(locala.JnG);
        if (paramViewGroup.JnL.getTag() != null) {
          break label231;
        }
        b localb = new b((byte)0);
        localb.JnH = locala;
        localb.JnI = this.JnD;
        paramViewGroup.JnL.setSwitchListener(localb.JnJ);
        paramViewGroup.JnL.setTag(localb);
        label191:
        if (paramInt != this.JnB.size() - 1) {
          break label249;
        }
        paramViewGroup.iYM.setVisibility(8);
      }
      for (;;)
      {
        AppMethodBeat.o(186876);
        return paramView;
        paramViewGroup = (c)paramView.getTag();
        break;
        label231:
        ((b)paramViewGroup.JnL.getTag()).JnH = locala;
        break label191;
        label249:
        paramViewGroup.iYM.setVisibility(0);
      }
    }
    
    static final class a
    {
      boolean JnG;
      String title;
      String url;
      String username;
    }
    
    static final class b
    {
      AppBrandNotifySettingsUI.a.a JnH;
      a JnI;
      MMSwitchBtn.a JnJ;
      
      private b()
      {
        AppMethodBeat.i(186872);
        this.JnJ = new MMSwitchBtn.a()
        {
          public final void onStatusChange(boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(186871);
            if (AppBrandNotifySettingsUI.a.b.this.JnI != null) {
              AppBrandNotifySettingsUI.a.b.this.JnI.a(AppBrandNotifySettingsUI.a.b.this.JnH, paramAnonymousBoolean);
            }
            AppMethodBeat.o(186871);
          }
        };
        AppMethodBeat.o(186872);
      }
      
      public static abstract interface a
      {
        public abstract void a(AppBrandNotifySettingsUI.a.a parama, boolean paramBoolean);
      }
    }
    
    static final class c
    {
      MMSwitchBtn JnL;
      ImageView fTj;
      View iYM;
      TextView titleTv;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.AppBrandNotifySettingsUI
 * JD-Core Version:    0.7.0.1
 */