package com.tencent.mm.pluginsdk.ui.span;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
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
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.bbom.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.protocal.protobuf.bvs;
import com.tencent.mm.protocal.protobuf.cfj;
import com.tencent.mm.protocal.protobuf.cfk;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class m
{
  static String DCx;
  
  private static void a(Activity paramActivity, com.tencent.mm.storage.ai paramai, String paramString, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(31941);
    bvs localbvs = new bvs();
    localbvs.Flc = paramString;
    cfk localcfk = new cfk();
    localcfk.FtQ = new LinkedList();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (c.Ta(str))
      {
        cfj localcfj = new cfj();
        localcfj.FtP = str;
        localcfk.FtQ.add(localcfj);
        localArrayList.add(str);
      }
    }
    localcfk.ncL = localArrayList.size();
    localbvs.FkU = localcfk;
    ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awA().c(new j.a(60, localbvs));
    com.tencent.mm.n.a.a(paramai, paramString, paramArrayList);
    Toast.makeText(paramActivity, paramActivity.getString(2131764321), 0).show();
    AppMethodBeat.o(31941);
  }
  
  public static void a(final Context paramContext, String paramString, final DialogInterface.OnDismissListener paramOnDismissListener, final Bundle paramBundle)
  {
    AppMethodBeat.i(31937);
    if (!(paramContext instanceof Activity)) {
      ac.w("MicroMsg.MailPhoneMenuHelper", "context should be Activity, %s", new Object[] { bs.eWi() });
    }
    if (g.agP().afY()) {}
    label400:
    label411:
    for (boolean bool = ((Boolean)g.agR().agA().get(ah.a.GGA, Boolean.FALSE)).booleanValue();; bool = false)
    {
      final int i;
      if (paramBundle != null)
      {
        i = paramBundle.getInt("fromScene");
        if (!ePQ()) {
          break label660;
        }
        if (paramBundle != null) {
          break label400;
        }
        localObject = "";
        label90:
        localObject = bs.nullAsNil((String)localObject);
        if ((localObject != null) && (localObject != "") && (!u.wh((String)localObject)) && (!com.tencent.mm.storage.ai.aNc((String)localObject))) {
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
      for (Object localObject = bs.S((String[])localObject);; localObject = bs.S(new String[] { paramContext.getResources().getString(2131757270), paramContext.getResources().getString(2131757264) }))
      {
        com.tencent.mm.plugin.report.service.h.wUl.f(11621, new Object[] { Integer.valueOf(i), Integer.valueOf(2) });
        if (r.Lo())
        {
          ((List)localObject).add(paramContext.getResources().getString(2131757266));
          com.tencent.mm.plugin.report.service.h.wUl.f(11621, new Object[] { Integer.valueOf(i), Integer.valueOf(3) });
          if (PlatformComm.C2Java.isNetworkConnected()) {
            r.ePT();
          }
        }
        final com.tencent.mm.ui.base.k localk = new com.tencent.mm.ui.base.k(paramContext);
        localk.setTitle(paramString);
        a locala = new a((List)localObject, paramContext, paramOnDismissListener, paramBundle);
        locala.DCG = new m.a.a()
        {
          public final void nt(boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(31925);
            if (paramAnonymousBoolean)
            {
              this.DCB.dismiss();
              if (paramOnDismissListener != null) {
                paramOnDismissListener.onDismiss(null);
              }
            }
            AppMethodBeat.o(31925);
          }
        };
        localk.oao = locala;
        com.tencent.mm.ui.base.h.a(paramContext, localk);
        localk.setOnCancelListener(new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(31926);
            if (this.DCy != null) {
              this.DCy.onDismiss(null);
            }
            AppMethodBeat.o(31926);
          }
        });
        localk.DEe = new AdapterView.OnItemClickListener()
        {
          public final void onItemClick(final AdapterView<?> paramAnonymousAdapterView, final View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            AppMethodBeat.i(31929);
            paramAnonymousView = this.tSs.replace(" ", "").replace("(", "").replace(")", "").replace("-", "");
            paramAnonymousAdapterView = paramAnonymousView.replaceAll("#", "%23");
            Object localObject = (String)this.qLL.get(paramAnonymousInt);
            ac.i("MicroMsg.MailPhoneMenuHelper", (String)localObject);
            if (paramContext.getString(2131757270).equals(localObject))
            {
              paramAnonymousView = new Intent("android.intent.action.DIAL", Uri.parse("tel:".concat(String.valueOf(paramAnonymousAdapterView))));
              paramAnonymousView.addFlags(268435456);
              if (bs.ah(paramContext, paramAnonymousView))
              {
                paramAnonymousAdapterView = paramContext;
                paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().ba(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAdapterView, paramAnonymousView.aeD(), "com/tencent/mm/pluginsdk/ui/span/MailPhoneMenuHelper$7", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymousAdapterView.startActivity((Intent)paramAnonymousView.lR(0));
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAdapterView, "com/tencent/mm/pluginsdk/ui/span/MailPhoneMenuHelper$7", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              }
              com.tencent.mm.plugin.report.service.h.wUl.kvStat(10112, "1");
              localk.dismiss();
              if (paramOnDismissListener != null) {
                paramOnDismissListener.onDismiss(null);
              }
              AppMethodBeat.o(31929);
              return;
            }
            if (paramContext.getString(2131757271).equals(localObject))
            {
              com.tencent.mm.plugin.report.service.h.wUl.f(12059, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
              paramAnonymousAdapterView = new Intent();
              paramAnonymousAdapterView.putExtra("IPCallTalkUI_phoneNumber", paramAnonymousView);
              d.b(paramContext, "ipcall", ".ui.IPCallDialUI", paramAnonymousAdapterView);
              localk.dismiss();
              if (paramOnDismissListener != null) {
                paramOnDismissListener.onDismiss(null);
              }
              AppMethodBeat.o(31929);
              return;
            }
            if (paramContext.getString(2131757262).equals(localObject))
            {
              if ((m.ePR()) && (m.ePS())) {
                paramAnonymousAdapterView = paramContext.getResources().getStringArray(2130903074);
              }
              for (;;)
              {
                paramContext.getResources().getString(2131757268);
                localObject = new com.tencent.mm.ui.tools.l(paramContext);
                ((com.tencent.mm.ui.tools.l)localObject).ISu = new n.c()
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
                ((com.tencent.mm.ui.tools.l)localObject).ISv = new n.d()
                {
                  public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(179833);
                    switch (paramAnonymous2MenuItem.getItemId())
                    {
                    }
                    for (;;)
                    {
                      AppMethodBeat.o(179833);
                      return;
                      if (m.ePR())
                      {
                        paramAnonymous2MenuItem = m.7.this.val$context;
                        Object localObject = paramAnonymousView;
                        Intent localIntent = new Intent("android.intent.action.INSERT");
                        localIntent.setType("vnd.android.cursor.dir/contact");
                        localIntent.putExtra("phone", (String)localObject);
                        localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
                        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2MenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/pluginsdk/ui/span/MailPhoneMenuHelper", "phoneCreateContact", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        paramAnonymous2MenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
                        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2MenuItem, "com/tencent/mm/pluginsdk/ui/span/MailPhoneMenuHelper", "phoneCreateContact", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        com.tencent.mm.plugin.report.service.h.wUl.kvStat(10113, "1");
                        AppMethodBeat.o(179833);
                        return;
                      }
                      m.bQ(m.7.this.val$context, paramAnonymousView);
                      com.tencent.mm.plugin.report.service.h.wUl.kvStat(10114, "1");
                      AppMethodBeat.o(179833);
                      return;
                      m.bQ(m.7.this.val$context, paramAnonymousView);
                      com.tencent.mm.plugin.report.service.h.wUl.kvStat(10114, "1");
                    }
                  }
                };
                ((com.tencent.mm.ui.tools.l)localObject).a(new e.b()
                {
                  public final void onDismiss()
                  {
                    AppMethodBeat.i(179834);
                    if (m.7.this.DCy != null) {
                      m.7.this.DCy.onDismiss(null);
                    }
                    AppMethodBeat.o(179834);
                  }
                });
                localk.dismiss();
                ((com.tencent.mm.ui.tools.l)localObject).ftL();
                AppMethodBeat.o(31929);
                return;
                if (m.ePR())
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
              com.tencent.mm.pluginsdk.g.a.b(paramAnonymousView, paramAnonymousView);
              com.tencent.mm.plugin.report.service.h.wUl.kvStat(10115, "1");
              if (paramOnDismissListener != null) {
                paramOnDismissListener.onDismiss(null);
              }
              localk.dismiss();
              Toast.makeText(paramContext, paramContext.getString(2131755702), 1).show();
              AppMethodBeat.o(31929);
              return;
            }
            if (paramContext.getString(2131757266).equals(localObject))
            {
              ac.d("MicroMsg.MailPhoneMenuHelper", "hy: button should consume this action");
              AppMethodBeat.o(31929);
              return;
            }
            if (m.DCx.equals(localObject))
            {
              m.a((Activity)paramContext, this.tSs, paramBundle);
              localk.dismiss();
              if (paramOnDismissListener != null)
              {
                paramOnDismissListener.onDismiss(null);
                AppMethodBeat.o(31929);
              }
            }
            else
            {
              ac.e("MicroMsg.MailPhoneMenuHelper", "hy: error phone item clicked. should not happen");
              localk.dismiss();
              if (paramOnDismissListener != null) {
                paramOnDismissListener.onDismiss(null);
              }
            }
            AppMethodBeat.o(31929);
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
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt((String)localObject);
        if (localObject == null)
        {
          AppMethodBeat.o(31937);
          return;
        }
        localObject = ((com.tencent.mm.storage.ai)localObject).aaS();
        DCx = paramContext.getResources().getString(2131757263, new Object[] { localObject });
        if (bool)
        {
          localObject = new String[5];
          localObject[0] = paramContext.getResources().getString(2131757270);
          localObject[1] = paramContext.getResources().getString(2131757271);
          localObject[2] = DCx;
          localObject[3] = paramContext.getResources().getString(2131757264);
          localObject[4] = paramContext.getResources().getString(2131757262);
          break label193;
        }
        localObject = new String[4];
        localObject[0] = paramContext.getResources().getString(2131757270);
        localObject[1] = DCx;
        localObject[2] = paramContext.getResources().getString(2131757264);
        localObject[3] = paramContext.getResources().getString(2131757262);
        break label193;
      }
    }
  }
  
  public static void b(final Context paramContext, final String paramString, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    AppMethodBeat.i(31936);
    if ((u.axI() & 0x1) == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      com.tencent.mm.ui.base.h.a(paramContext, paramString, paramContext.getResources().getStringArray(2130903046), "", new h.c()
      {
        public final void kG(int paramAnonymousInt)
        {
          AppMethodBeat.i(31921);
          if (this.DCy != null) {
            this.DCy.onDismiss(null);
          }
          String str1 = paramString.replace(" ", "").replace("#", "@");
          switch (paramAnonymousInt)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(31921);
            return;
            Context localContext = paramContext;
            Intent localIntent = new Intent();
            localIntent.putExtra("composeType", 4);
            String str2 = str1.substring(0, str1.indexOf('@'));
            localIntent.putExtra("toList", new String[] { str2 + " " + str1 });
            d.b(localContext, "qqmail", ".ui.ComposeUI", localIntent);
            AppMethodBeat.o(31921);
            return;
            m.bP(paramContext, str1);
          }
        }
      });
      AppMethodBeat.o(31936);
      return;
    }
    String str = paramContext.getResources().getString(2131757152);
    paramOnDismissListener = new h.c()
    {
      public final void kG(int paramAnonymousInt)
      {
        AppMethodBeat.i(31922);
        if (this.DCy != null) {
          this.DCy.onDismiss(null);
        }
        String str = paramString.replace(" ", "").replace("#", "@");
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(31922);
          return;
          m.bP(paramContext, str);
        }
      }
    };
    com.tencent.mm.ui.base.h.a(paramContext, paramString, new String[] { str }, "", paramOnDismissListener);
    AppMethodBeat.o(31936);
  }
  
  private static boolean ePQ()
  {
    AppMethodBeat.i(31938);
    if ((ePR()) || (ePS()))
    {
      AppMethodBeat.o(31938);
      return true;
    }
    AppMethodBeat.o(31938);
    return false;
  }
  
  static boolean ePR()
  {
    AppMethodBeat.i(31939);
    Context localContext = com.tencent.mm.sdk.platformtools.ai.getContext();
    Intent localIntent = new Intent("android.intent.action.INSERT");
    localIntent.setType("vnd.android.cursor.dir/contact");
    localIntent.putExtra("phone", "10086");
    boolean bool = bs.ah(localContext, localIntent);
    AppMethodBeat.o(31939);
    return bool;
  }
  
  static boolean ePS()
  {
    AppMethodBeat.i(31940);
    boolean bool = bs.ah(com.tencent.mm.sdk.platformtools.ai.getContext(), new Intent("android.intent.action.PICK", ContactsContract.Contacts.CONTENT_URI));
    AppMethodBeat.o(31940);
    return bool;
  }
  
  static final class a
    extends BaseAdapter
  {
    private DialogInterface.OnDismissListener DCF;
    a DCG;
    private Bundle EX;
    private List<String> bYM;
    private Context mContext;
    
    public a(List<String> paramList, Context paramContext, DialogInterface.OnDismissListener paramOnDismissListener, Bundle paramBundle)
    {
      AppMethodBeat.i(31931);
      this.bYM = null;
      this.mContext = null;
      this.DCF = null;
      this.EX = null;
      this.DCG = null;
      if (paramContext != null) {}
      for (boolean bool = true;; bool = false)
      {
        Assert.assertTrue(bool);
        this.bYM = paramList;
        this.mContext = paramContext;
        this.DCF = paramOnDismissListener;
        this.EX = paramBundle;
        AppMethodBeat.o(31931);
        return;
      }
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(31932);
      if (this.bYM == null)
      {
        AppMethodBeat.o(31932);
        return 0;
      }
      int i = this.bYM.size();
      AppMethodBeat.o(31932);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(31933);
      Object localObject = this.bYM.get(paramInt);
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
      String str = (String)this.bYM.get(paramInt);
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
          ((b)paramViewGroup).fUk = ((TextView)paramView.findViewById(2131305902));
          ((b)paramViewGroup).qPR = ((Button)paramView.findViewById(2131299195));
          ((b)paramViewGroup).DCI = ((TextView)paramView.findViewById(2131305875));
          paramView.setTag(paramViewGroup);
          switch (paramInt)
          {
          default: 
            label116:
            ac.e("MicroMsg.MailPhoneMenuHelper", "hy: error tag");
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(31935);
        return paramView;
        paramView = paramView.inflate(2131493472, paramViewGroup, false);
        paramViewGroup = new c((byte)0);
        ((c)paramViewGroup).fUk = ((TextView)paramView.findViewById(2131305902));
        break;
        paramViewGroup = paramView.getTag();
        break label116;
        paramViewGroup = (c)paramViewGroup;
        paramViewGroup.fUk.setText(k.b(this.mContext, bs.nullAsNil(str), paramViewGroup.fUk.getTextSize()));
        continue;
        paramViewGroup = (b)paramViewGroup;
        paramViewGroup.fUk.setText(k.b(this.mContext, bs.nullAsNil(str), paramViewGroup.fUk.getTextSize()));
        paramViewGroup.DCI.setText(this.mContext.getString(2131757272));
        paramViewGroup.qPR.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(31930);
            if (!PlatformComm.C2Java.isNetworkConnected())
            {
              ac.w("MicroMsg.MailPhoneMenuHelper", "hy: no network. abort download");
              t.makeText(m.a.a(m.a.this), m.a.a(m.a.this).getString(2131759511), 0).show();
              if (m.a.b(m.a.this) != null)
              {
                m.a.b(m.a.this).nt(false);
                AppMethodBeat.o(31930);
              }
            }
            else
            {
              r.h(m.a.a(m.a.this), m.a.c(m.a.this));
              if (m.a.b(m.a.this) != null) {
                m.a.b(m.a.this).nt(true);
              }
            }
            AppMethodBeat.o(31930);
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
      public abstract void nt(boolean paramBoolean);
    }
    
    final class b
    {
      TextView DCI;
      TextView fUk;
      Button qPR;
      
      private b() {}
    }
    
    final class c
    {
      TextView fUk;
      
      private c() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.span.m
 * JD-Core Version:    0.7.0.1
 */