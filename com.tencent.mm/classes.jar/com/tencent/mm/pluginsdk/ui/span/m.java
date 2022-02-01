package com.tencent.mm.pluginsdk.ui.span;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mars.comm.PlatformComm.C2Java;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.bbom.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.protocal.protobuf.cai;
import com.tencent.mm.protocal.protobuf.cki;
import com.tencent.mm.protocal.protobuf.ckj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class m
{
  static String FhE;
  
  private static void a(Activity paramActivity, am paramam, String paramString, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(31941);
    cai localcai = new cai();
    localcai.GUK = paramString;
    ckj localckj = new ckj();
    localckj.HdV = new LinkedList();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (c.Wx(str))
      {
        cki localcki = new cki();
        localcki.HdU = str;
        localckj.HdV.add(localcki);
        localArrayList.add(str);
      }
    }
    localckj.nDi = localArrayList.size();
    localcai.GUC = localckj;
    ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azo().c(new k.a(60, localcai));
    com.tencent.mm.o.a.a(paramam, paramString, paramArrayList);
    Toast.makeText(paramActivity, paramActivity.getString(2131764321), 0).show();
    AppMethodBeat.o(31941);
  }
  
  public static void a(final Context paramContext, String paramString, final DialogInterface.OnDismissListener paramOnDismissListener, final Bundle paramBundle)
  {
    AppMethodBeat.i(31937);
    if (!(paramContext instanceof Activity)) {
      ad.w("MicroMsg.MailPhoneMenuHelper", "context should be Activity, %s", new Object[] { bt.flS() });
    }
    if (com.tencent.mm.kernel.g.ajA().aiK()) {}
    label400:
    label411:
    for (boolean bool = ((Boolean)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IsS, Boolean.FALSE)).booleanValue();; bool = false)
    {
      final int i;
      if (paramBundle != null)
      {
        i = paramBundle.getInt("fromScene");
        if (!feS()) {
          break label660;
        }
        if (paramBundle != null) {
          break label400;
        }
        localObject = "";
        label90:
        localObject = bt.nullAsNil((String)localObject);
        if ((localObject != null) && (localObject != "") && (!u.za((String)localObject)) && (!am.aSQ((String)localObject))) {
          break label462;
        }
        if (!bool) {
          break label411;
        }
        localObject = new String[4];
        localObject[0] = paramContext.getResources().getString(2131757270);
        localObject[1] = paramContext.getResources().getString(2131757271);
        localObject[2] = paramContext.getResources().getString(2131757264);
        localObject[3] = paramContext.getResources().getString(2131757262);
      }
      label193:
      for (Object localObject = bt.U((String[])localObject);; localObject = bt.U(new String[] { paramContext.getResources().getString(2131757270), paramContext.getResources().getString(2131757264) }))
      {
        com.tencent.mm.plugin.report.service.g.yhR.f(11621, new Object[] { Integer.valueOf(i), Integer.valueOf(2) });
        if (r.MW())
        {
          ((List)localObject).add(paramContext.getResources().getString(2131757266));
          com.tencent.mm.plugin.report.service.g.yhR.f(11621, new Object[] { Integer.valueOf(i), Integer.valueOf(3) });
          if (PlatformComm.C2Java.isNetworkConnected()) {
            r.feV();
          }
        }
        final com.tencent.mm.ui.base.k localk = new com.tencent.mm.ui.base.k(paramContext);
        localk.setTitle(paramString);
        a locala = new a((List)localObject, paramContext, paramOnDismissListener, paramBundle);
        locala.FhN = new m.a.a()
        {
          public final void nN(boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(31925);
            if (paramAnonymousBoolean)
            {
              this.FhI.dismiss();
              if (paramOnDismissListener != null) {
                paramOnDismissListener.onDismiss(null);
              }
            }
            AppMethodBeat.o(31925);
          }
        };
        localk.oDI = locala;
        h.a(paramContext, localk);
        localk.setOnCancelListener(new m.6(paramOnDismissListener));
        localk.Fjk = new AdapterView.OnItemClickListener()
        {
          public final void onItemClick(final AdapterView<?> paramAnonymousAdapterView, final View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            AppMethodBeat.i(31929);
            Object localObject = new b();
            ((b)localObject).bd(paramAnonymousAdapterView);
            ((b)localObject).bd(paramAnonymousView);
            ((b)localObject).mr(paramAnonymousInt);
            ((b)localObject).qY(paramAnonymousLong);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/span/MailPhoneMenuHelper$7", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((b)localObject).ahq());
            paramAnonymousView = this.uVf.replace(" ", "").replace("(", "").replace(")", "").replace("-", "");
            paramAnonymousAdapterView = paramAnonymousView.replaceAll("#", "%23");
            localObject = (String)this.rvN.get(paramAnonymousInt);
            ad.i("MicroMsg.MailPhoneMenuHelper", (String)localObject);
            if (paramContext.getString(2131757270).equals(localObject))
            {
              paramAnonymousView = new Intent("android.intent.action.DIAL", Uri.parse("tel:".concat(String.valueOf(paramAnonymousAdapterView))));
              paramAnonymousView.addFlags(268435456);
              if (bt.aj(paramContext, paramAnonymousView))
              {
                paramAnonymousAdapterView = paramContext;
                paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAdapterView, paramAnonymousView.ahp(), "com/tencent/mm/pluginsdk/ui/span/MailPhoneMenuHelper$7", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymousAdapterView.startActivity((Intent)paramAnonymousView.mq(0));
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAdapterView, "com/tencent/mm/pluginsdk/ui/span/MailPhoneMenuHelper$7", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              }
              com.tencent.mm.plugin.report.service.g.yhR.kvStat(10112, "1");
              localk.dismiss();
              if (paramOnDismissListener != null) {
                paramOnDismissListener.onDismiss(null);
              }
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/span/MailPhoneMenuHelper$7", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(31929);
              return;
              if (paramContext.getString(2131757271).equals(localObject))
              {
                com.tencent.mm.plugin.report.service.g.yhR.f(12059, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
                paramAnonymousAdapterView = new Intent();
                paramAnonymousAdapterView.putExtra("IPCallTalkUI_phoneNumber", paramAnonymousView);
                d.b(paramContext, "ipcall", ".ui.IPCallDialUI", paramAnonymousAdapterView);
                localk.dismiss();
                if (paramOnDismissListener != null) {
                  paramOnDismissListener.onDismiss(null);
                }
              }
              else
              {
                if (paramContext.getString(2131757262).equals(localObject))
                {
                  if ((m.feT()) && (m.feU())) {
                    paramAnonymousAdapterView = paramContext.getResources().getStringArray(2130903074);
                  }
                  for (;;)
                  {
                    paramContext.getResources().getString(2131757268);
                    localObject = new com.tencent.mm.ui.tools.l(paramContext);
                    ((com.tencent.mm.ui.tools.l)localObject).KJy = new n.d()
                    {
                      public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
                      {
                        AppMethodBeat.i(179832);
                        int i = 0;
                        while (i < paramAnonymousAdapterView.length)
                        {
                          paramAnonymous2l.c(i, paramAnonymousAdapterView[i]);
                          i += 1;
                        }
                        AppMethodBeat.o(179832);
                      }
                    };
                    ((com.tencent.mm.ui.tools.l)localObject).KJz = new n.e()
                    {
                      public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
                      {
                        AppMethodBeat.i(179833);
                        if (m.7.this.FhF != null) {
                          m.7.this.FhF.onDismiss(null);
                        }
                        switch (paramAnonymous2MenuItem.getItemId())
                        {
                        }
                        for (;;)
                        {
                          AppMethodBeat.o(179833);
                          return;
                          if (m.feT())
                          {
                            paramAnonymous2MenuItem = m.7.this.val$context;
                            Object localObject = paramAnonymousView;
                            Intent localIntent = new Intent("android.intent.action.INSERT");
                            localIntent.setType("vnd.android.cursor.dir/contact");
                            localIntent.putExtra("phone", (String)localObject);
                            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
                            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2MenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/pluginsdk/ui/span/MailPhoneMenuHelper", "phoneCreateContact", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            paramAnonymous2MenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
                            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2MenuItem, "com/tencent/mm/pluginsdk/ui/span/MailPhoneMenuHelper", "phoneCreateContact", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            com.tencent.mm.plugin.report.service.g.yhR.kvStat(10113, "1");
                            AppMethodBeat.o(179833);
                            return;
                          }
                          m.bU(m.7.this.val$context, paramAnonymousView);
                          com.tencent.mm.plugin.report.service.g.yhR.kvStat(10114, "1");
                          AppMethodBeat.o(179833);
                          return;
                          m.bU(m.7.this.val$context, paramAnonymousView);
                          com.tencent.mm.plugin.report.service.g.yhR.kvStat(10114, "1");
                        }
                      }
                    };
                    ((com.tencent.mm.ui.tools.l)localObject).a(new e.b()
                    {
                      public final void onDismiss()
                      {
                        AppMethodBeat.i(179834);
                        if (m.7.this.FhF != null) {
                          m.7.this.FhF.onDismiss(null);
                        }
                        AppMethodBeat.o(179834);
                      }
                    });
                    localk.dismiss();
                    ((com.tencent.mm.ui.tools.l)localObject).fKy();
                    break;
                    if (m.feT())
                    {
                      paramAnonymousAdapterView = new String[1];
                      paramAnonymousAdapterView[0] = paramContext.getResources().getString(2131757261);
                    }
                    else
                    {
                      paramAnonymousAdapterView = new String[1];
                      paramAnonymousAdapterView[0] = paramContext.getResources().getString(2131757269);
                    }
                  }
                }
                if (paramContext.getString(2131757264).equals(localObject))
                {
                  com.tencent.mm.pluginsdk.i.a.b(paramAnonymousView, paramAnonymousView);
                  com.tencent.mm.plugin.report.service.g.yhR.kvStat(10115, "1");
                  if (paramOnDismissListener != null) {
                    paramOnDismissListener.onDismiss(null);
                  }
                  localk.dismiss();
                  Toast.makeText(paramContext, paramContext.getString(2131755702), 1).show();
                }
                else if (paramContext.getString(2131757266).equals(localObject))
                {
                  ad.d("MicroMsg.MailPhoneMenuHelper", "hy: button should consume this action");
                }
                else if (m.FhE.equals(localObject))
                {
                  m.a((Activity)paramContext, this.uVf, paramBundle);
                  localk.dismiss();
                  if (paramOnDismissListener != null) {
                    paramOnDismissListener.onDismiss(null);
                  }
                }
                else
                {
                  ad.e("MicroMsg.MailPhoneMenuHelper", "hy: error phone item clicked. should not happen");
                  localk.dismiss();
                  if (paramOnDismissListener != null) {
                    paramOnDismissListener.onDismiss(null);
                  }
                }
              }
            }
          }
        };
        localk.show();
        AppMethodBeat.o(31937);
        return;
        i = 0;
        break;
        localObject = paramBundle.getString("Contact_User");
        break label90;
        localObject = new String[3];
        localObject[0] = paramContext.getResources().getString(2131757270);
        localObject[1] = paramContext.getResources().getString(2131757264);
        localObject[2] = paramContext.getResources().getString(2131757262);
        break label193;
        label462:
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf((String)localObject);
        if (localObject == null)
        {
          AppMethodBeat.o(31937);
          return;
        }
        localObject = ((am)localObject).adv();
        FhE = paramContext.getResources().getString(2131757263, new Object[] { localObject });
        if (bool)
        {
          localObject = new String[5];
          localObject[0] = paramContext.getResources().getString(2131757270);
          localObject[1] = paramContext.getResources().getString(2131757271);
          localObject[2] = FhE;
          localObject[3] = paramContext.getResources().getString(2131757264);
          localObject[4] = paramContext.getResources().getString(2131757262);
          break label193;
        }
        localObject = new String[4];
        localObject[0] = paramContext.getResources().getString(2131757270);
        localObject[1] = FhE;
        localObject[2] = paramContext.getResources().getString(2131757264);
        localObject[3] = paramContext.getResources().getString(2131757262);
        break label193;
      }
    }
  }
  
  public static void b(Context paramContext, String paramString, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    AppMethodBeat.i(31936);
    if ((u.aAy() & 0x1) == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      h.a(paramContext, paramString, paramContext.getResources().getStringArray(2130903046), "", new m.1(paramOnDismissListener, paramString, paramContext));
      AppMethodBeat.o(31936);
      return;
    }
    String str = paramContext.getResources().getString(2131757152);
    paramOnDismissListener = new m.2(paramOnDismissListener, paramString, paramContext);
    h.a(paramContext, paramString, new String[] { str }, "", paramOnDismissListener);
    AppMethodBeat.o(31936);
  }
  
  private static boolean feS()
  {
    AppMethodBeat.i(31938);
    if ((feT()) || (feU()))
    {
      AppMethodBeat.o(31938);
      return true;
    }
    AppMethodBeat.o(31938);
    return false;
  }
  
  static boolean feT()
  {
    AppMethodBeat.i(31939);
    Context localContext = aj.getContext();
    Intent localIntent = new Intent("android.intent.action.INSERT");
    localIntent.setType("vnd.android.cursor.dir/contact");
    localIntent.putExtra("phone", "10086");
    boolean bool = bt.aj(localContext, localIntent);
    AppMethodBeat.o(31939);
    return bool;
  }
  
  static boolean feU()
  {
    AppMethodBeat.i(31940);
    boolean bool = bt.aj(aj.getContext(), new Intent("android.intent.action.PICK", ContactsContract.Contacts.CONTENT_URI));
    AppMethodBeat.o(31940);
    return bool;
  }
  
  static final class a
    extends BaseAdapter
  {
    private DialogInterface.OnDismissListener FhM;
    a FhN;
    private Bundle GO;
    private List<String> cje;
    private Context mContext;
    
    public a(List<String> paramList, Context paramContext, DialogInterface.OnDismissListener paramOnDismissListener, Bundle paramBundle)
    {
      AppMethodBeat.i(31931);
      this.cje = null;
      this.mContext = null;
      this.FhM = null;
      this.GO = null;
      this.FhN = null;
      if (paramContext != null) {}
      for (boolean bool = true;; bool = false)
      {
        Assert.assertTrue(bool);
        this.cje = paramList;
        this.mContext = paramContext;
        this.FhM = paramOnDismissListener;
        this.GO = paramBundle;
        AppMethodBeat.o(31931);
        return;
      }
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(31932);
      if (this.cje == null)
      {
        AppMethodBeat.o(31932);
        return 0;
      }
      int i = this.cje.size();
      AppMethodBeat.o(31932);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(31933);
      Object localObject = this.cje.get(paramInt);
      AppMethodBeat.o(31933);
      return localObject;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(31934);
      String str = (String)this.cje.get(paramInt);
      if (this.mContext.getString(2131757266).equals(str))
      {
        AppMethodBeat.o(31934);
        return 1;
      }
      AppMethodBeat.o(31934);
      return 0;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(31935);
      String str = (String)getItem(paramInt);
      paramInt = getItemViewType(paramInt);
      if (paramView == null)
      {
        paramView = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
        if (paramInt == 1)
        {
          paramView = paramView.inflate(2131493471, paramViewGroup, false);
          paramViewGroup = new b((byte)0);
          ((b)paramViewGroup).gnM = ((TextView)paramView.findViewById(2131305902));
          ((b)paramViewGroup).rzR = ((Button)paramView.findViewById(2131299195));
          ((b)paramViewGroup).FhP = ((TextView)paramView.findViewById(2131305875));
          paramView.setTag(paramViewGroup);
          switch (paramInt)
          {
          default: 
            label116:
            ad.e("MicroMsg.MailPhoneMenuHelper", "hy: error tag");
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(31935);
        return paramView;
        paramView = paramView.inflate(2131493472, paramViewGroup, false);
        paramViewGroup = new c((byte)0);
        ((c)paramViewGroup).gnM = ((TextView)paramView.findViewById(2131305902));
        break;
        paramViewGroup = paramView.getTag();
        break label116;
        paramViewGroup = (c)paramViewGroup;
        paramViewGroup.gnM.setText(k.b(this.mContext, bt.nullAsNil(str), paramViewGroup.gnM.getTextSize()));
        continue;
        paramViewGroup = (b)paramViewGroup;
        paramViewGroup.gnM.setText(k.b(this.mContext, bt.nullAsNil(str), paramViewGroup.gnM.getTextSize()));
        paramViewGroup.FhP.setText(this.mContext.getString(2131757272));
        paramViewGroup.rzR.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(31930);
            b localb = new b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/span/MailPhoneMenuHelper$PhoneAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            if (!PlatformComm.C2Java.isNetworkConnected())
            {
              ad.w("MicroMsg.MailPhoneMenuHelper", "hy: no network. abort download");
              t.makeText(m.a.a(m.a.this), m.a.a(m.a.this).getString(2131759511), 0).show();
              if (m.a.b(m.a.this) != null) {
                m.a.b(m.a.this).nN(false);
              }
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/span/MailPhoneMenuHelper$PhoneAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(31930);
              return;
              r.h(m.a.a(m.a.this), m.a.c(m.a.this));
              if (m.a.b(m.a.this) != null) {
                m.a.b(m.a.this).nN(true);
              }
            }
          }
        });
      }
    }
    
    public final int getViewTypeCount()
    {
      return 2;
    }
    
    public static abstract interface a
    {
      public abstract void nN(boolean paramBoolean);
    }
    
    final class b
    {
      TextView FhP;
      TextView gnM;
      Button rzR;
      
      private b() {}
    }
    
    final class c
    {
      TextView gnM;
      
      private c() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.span.m
 * JD-Core Version:    0.7.0.1
 */