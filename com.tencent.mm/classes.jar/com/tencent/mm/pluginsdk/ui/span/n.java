package com.tencent.mm.pluginsdk.ui.span;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.protocal.protobuf.cqe;
import com.tencent.mm.protocal.protobuf.dbk;
import com.tencent.mm.protocal.protobuf.dbl;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class n
{
  static String Kri;
  
  private static void a(Activity paramActivity, as paramas, String paramString, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(31941);
    cqe localcqe = new cqe();
    localcqe.MvG = paramString;
    dbl localdbl = new dbl();
    localdbl.MGv = new LinkedList();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (com.tencent.mm.plugin.bbom.c.ahc(str))
      {
        dbk localdbk = new dbk();
        localdbk.MGu = str;
        localdbl.MGv.add(localdbk);
        localArrayList.add(str);
      }
    }
    localdbl.oTz = localArrayList.size();
    localcqe.Mvx = localdbl;
    ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSM().d(new k.a(60, localcqe));
    com.tencent.mm.contact.a.a(paramas, paramString, paramArrayList);
    Toast.makeText(paramActivity, paramActivity.getString(2131766580), 0).show();
    AppMethodBeat.o(31941);
  }
  
  public static void a(final Context paramContext, String paramString, final DialogInterface.OnDismissListener paramOnDismissListener, final Bundle paramBundle)
  {
    AppMethodBeat.i(31937);
    if (!(paramContext instanceof Activity)) {
      Log.w("MicroMsg.MailPhoneMenuHelper", "context should be Activity, %s", new Object[] { Util.getStack() });
    }
    if (g.aAf().azp()) {}
    label401:
    for (boolean bool = ((Boolean)g.aAh().azQ().get(ar.a.NVr, Boolean.FALSE)).booleanValue();; bool = false)
    {
      final int i;
      if (paramBundle != null)
      {
        i = paramBundle.getInt("fromScene");
        if (!grU()) {
          break label599;
        }
        if (paramBundle != null) {
          break label339;
        }
        localObject = "";
        label90:
        localObject = Util.nullAsNil((String)localObject);
        if ((localObject != null) && (localObject != "") && (!z.Im((String)localObject)) && (!as.bjp((String)localObject))) {
          break label401;
        }
        if (!bool) {
          break label350;
        }
        localObject = new String[4];
        localObject[0] = paramContext.getResources().getString(2131757484);
        localObject[1] = paramContext.getResources().getString(2131757485);
        localObject[2] = paramContext.getResources().getString(2131757478);
        localObject[3] = paramContext.getResources().getString(2131757476);
      }
      label193:
      label339:
      label599:
      for (Object localObject = Util.stringsToList((String[])localObject);; localObject = Util.stringsToList(new String[] { paramContext.getResources().getString(2131757484), paramContext.getResources().getString(2131757478) }))
      {
        com.tencent.mm.plugin.report.service.h.CyF.a(11621, new Object[] { Integer.valueOf(i), Integer.valueOf(2) });
        final com.tencent.mm.ui.base.l locall = new com.tencent.mm.ui.base.l(paramContext);
        locall.setTitle(paramString);
        a locala = new a((List)localObject, paramContext, paramOnDismissListener, paramBundle);
        locala.Krr = new n.a.a()
        {
          public final void qA(boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(31925);
            if (paramAnonymousBoolean)
            {
              this.Krm.dismiss();
              if (paramOnDismissListener != null) {
                paramOnDismissListener.onDismiss(null);
              }
            }
            AppMethodBeat.o(31925);
          }
        };
        locall.pXY = locala;
        com.tencent.mm.ui.base.h.a(paramContext, locall);
        locall.setOnCancelListener(new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(31926);
            if (this.Krj != null) {
              this.Krj.onDismiss(null);
            }
            AppMethodBeat.o(31926);
          }
        });
        locall.Kth = new AdapterView.OnItemClickListener()
        {
          public final void onItemClick(final AdapterView<?> paramAnonymousAdapterView, final View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            AppMethodBeat.i(31929);
            Object localObject = new b();
            ((b)localObject).bm(paramAnonymousAdapterView);
            ((b)localObject).bm(paramAnonymousView);
            ((b)localObject).pH(paramAnonymousInt);
            ((b)localObject).zo(paramAnonymousLong);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/span/MailPhoneMenuHelper$7", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((b)localObject).axR());
            paramAnonymousView = this.yzr.replace(" ", "").replace("(", "").replace(")", "").replace("-", "");
            paramAnonymousAdapterView = paramAnonymousView.replaceAll("#", "%23");
            localObject = (String)this.tdE.get(paramAnonymousInt);
            Log.i("MicroMsg.MailPhoneMenuHelper", (String)localObject);
            if (paramContext.getString(2131757484).equals(localObject))
            {
              paramAnonymousView = new Intent("android.intent.action.DIAL", Uri.parse("tel:".concat(String.valueOf(paramAnonymousAdapterView))));
              paramAnonymousView.addFlags(268435456);
              if (Util.isIntentAvailable(paramContext, paramAnonymousView))
              {
                paramAnonymousAdapterView = paramContext;
                paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bl(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAdapterView, paramAnonymousView.axQ(), "com/tencent/mm/pluginsdk/ui/span/MailPhoneMenuHelper$7", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymousAdapterView.startActivity((Intent)paramAnonymousView.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAdapterView, "com/tencent/mm/pluginsdk/ui/span/MailPhoneMenuHelper$7", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              }
              com.tencent.mm.plugin.report.service.h.CyF.kvStat(10112, "1");
              locall.dismiss();
              if (paramOnDismissListener != null) {
                paramOnDismissListener.onDismiss(null);
              }
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/span/MailPhoneMenuHelper$7", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(31929);
              return;
              if (paramContext.getString(2131757485).equals(localObject))
              {
                com.tencent.mm.plugin.report.service.h.CyF.a(12059, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
                paramAnonymousAdapterView = new Intent();
                paramAnonymousAdapterView.putExtra("IPCallTalkUI_phoneNumber", paramAnonymousView);
                com.tencent.mm.br.c.b(paramContext, "ipcall", ".ui.IPCallDialUI", paramAnonymousAdapterView);
                locall.dismiss();
                if (paramOnDismissListener != null) {
                  paramOnDismissListener.onDismiss(null);
                }
              }
              else
              {
                if (paramContext.getString(2131757476).equals(localObject))
                {
                  if ((n.grV()) && (n.grW())) {
                    paramAnonymousAdapterView = paramContext.getResources().getStringArray(2130903075);
                  }
                  for (;;)
                  {
                    paramContext.getResources().getString(2131757482);
                    localObject = new com.tencent.mm.ui.tools.l(paramContext);
                    ((com.tencent.mm.ui.tools.l)localObject).HLX = new o.f()
                    {
                      public final void onCreateMMMenu(m paramAnonymous2m)
                      {
                        AppMethodBeat.i(179832);
                        int i = 0;
                        while (i < paramAnonymousAdapterView.length)
                        {
                          paramAnonymous2m.d(i, paramAnonymousAdapterView[i]);
                          i += 1;
                        }
                        AppMethodBeat.o(179832);
                      }
                    };
                    ((com.tencent.mm.ui.tools.l)localObject).HLY = new o.g()
                    {
                      public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
                      {
                        AppMethodBeat.i(179833);
                        if (n.7.this.Krj != null) {
                          n.7.this.Krj.onDismiss(null);
                        }
                        switch (paramAnonymous2MenuItem.getItemId())
                        {
                        }
                        for (;;)
                        {
                          AppMethodBeat.o(179833);
                          return;
                          if (n.grV())
                          {
                            paramAnonymous2MenuItem = n.7.this.val$context;
                            Object localObject = paramAnonymousView;
                            Intent localIntent = new Intent("android.intent.action.INSERT");
                            localIntent.setType("vnd.android.cursor.dir/contact");
                            localIntent.putExtra("phone", (String)localObject);
                            localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
                            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2MenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/pluginsdk/ui/span/MailPhoneMenuHelper", "phoneCreateContact", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            paramAnonymous2MenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2MenuItem, "com/tencent/mm/pluginsdk/ui/span/MailPhoneMenuHelper", "phoneCreateContact", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            com.tencent.mm.plugin.report.service.h.CyF.kvStat(10113, "1");
                            AppMethodBeat.o(179833);
                            return;
                          }
                          n.cp(n.7.this.val$context, paramAnonymousView);
                          com.tencent.mm.plugin.report.service.h.CyF.kvStat(10114, "1");
                          AppMethodBeat.o(179833);
                          return;
                          n.cp(n.7.this.val$context, paramAnonymousView);
                          com.tencent.mm.plugin.report.service.h.CyF.kvStat(10114, "1");
                        }
                      }
                    };
                    ((com.tencent.mm.ui.tools.l)localObject).a(new e.b()
                    {
                      public final void onDismiss()
                      {
                        AppMethodBeat.i(179834);
                        if (n.7.this.Krj != null) {
                          n.7.this.Krj.onDismiss(null);
                        }
                        AppMethodBeat.o(179834);
                      }
                    });
                    locall.dismiss();
                    ((com.tencent.mm.ui.tools.l)localObject).gXI();
                    break;
                    if (n.grV())
                    {
                      paramAnonymousAdapterView = new String[1];
                      paramAnonymousAdapterView[0] = paramContext.getResources().getString(2131757475);
                    }
                    else
                    {
                      paramAnonymousAdapterView = new String[1];
                      paramAnonymousAdapterView[0] = paramContext.getResources().getString(2131757483);
                    }
                  }
                }
                if (paramContext.getString(2131757478).equals(localObject))
                {
                  ClipboardHelper.setText(paramContext, paramAnonymousView, paramAnonymousView);
                  com.tencent.mm.plugin.report.service.h.CyF.kvStat(10115, "1");
                  if (paramOnDismissListener != null) {
                    paramOnDismissListener.onDismiss(null);
                  }
                  locall.dismiss();
                  Toast.makeText(paramContext, paramContext.getString(2131755773), 1).show();
                }
                else if (paramContext.getString(2131757480).equals(localObject))
                {
                  Log.d("MicroMsg.MailPhoneMenuHelper", "hy: button should consume this action");
                }
                else if (n.Kri.equals(localObject))
                {
                  n.a((Activity)paramContext, this.yzr, paramBundle);
                  locall.dismiss();
                  if (paramOnDismissListener != null) {
                    paramOnDismissListener.onDismiss(null);
                  }
                }
                else
                {
                  Log.e("MicroMsg.MailPhoneMenuHelper", "hy: error phone item clicked. should not happen");
                  locall.dismiss();
                  if (paramOnDismissListener != null) {
                    paramOnDismissListener.onDismiss(null);
                  }
                }
              }
            }
          }
        };
        locall.show();
        AppMethodBeat.o(31937);
        return;
        i = 0;
        break;
        localObject = paramBundle.getString("Contact_User");
        break label90;
        label350:
        localObject = new String[3];
        localObject[0] = paramContext.getResources().getString(2131757484);
        localObject[1] = paramContext.getResources().getString(2131757478);
        localObject[2] = paramContext.getResources().getString(2131757476);
        break label193;
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn((String)localObject);
        if (localObject == null)
        {
          AppMethodBeat.o(31937);
          return;
        }
        localObject = ((as)localObject).arJ();
        Kri = paramContext.getResources().getString(2131757477, new Object[] { localObject });
        if (bool)
        {
          localObject = new String[5];
          localObject[0] = paramContext.getResources().getString(2131757484);
          localObject[1] = paramContext.getResources().getString(2131757485);
          localObject[2] = Kri;
          localObject[3] = paramContext.getResources().getString(2131757478);
          localObject[4] = paramContext.getResources().getString(2131757476);
          break label193;
        }
        localObject = new String[4];
        localObject[0] = paramContext.getResources().getString(2131757484);
        localObject[1] = Kri;
        localObject[2] = paramContext.getResources().getString(2131757478);
        localObject[3] = paramContext.getResources().getString(2131757476);
        break label193;
      }
    }
  }
  
  public static void b(final Context paramContext, final String paramString, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    AppMethodBeat.i(31936);
    if ((z.aUl() & 0x1) == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      com.tencent.mm.ui.base.h.a(paramContext, paramString, paramContext.getResources().getStringArray(2130903046), "", new h.d()
      {
        public final void oj(int paramAnonymousInt)
        {
          AppMethodBeat.i(31921);
          if (this.Krj != null) {
            this.Krj.onDismiss(null);
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
            com.tencent.mm.br.c.b(localContext, "qqmail", ".ui.ComposeUI", localIntent);
            AppMethodBeat.o(31921);
            return;
            n.co(paramContext, str1);
          }
        }
      });
      AppMethodBeat.o(31936);
      return;
    }
    String str = paramContext.getResources().getString(2131757356);
    paramOnDismissListener = new h.d()
    {
      public final void oj(int paramAnonymousInt)
      {
        AppMethodBeat.i(31922);
        if (this.Krj != null) {
          this.Krj.onDismiss(null);
        }
        String str = paramString.replace(" ", "").replace("#", "@");
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(31922);
          return;
          n.co(paramContext, str);
        }
      }
    };
    com.tencent.mm.ui.base.h.a(paramContext, paramString, new String[] { str }, "", paramOnDismissListener);
    AppMethodBeat.o(31936);
  }
  
  private static boolean grU()
  {
    AppMethodBeat.i(31938);
    if ((grV()) || (grW()))
    {
      AppMethodBeat.o(31938);
      return true;
    }
    AppMethodBeat.o(31938);
    return false;
  }
  
  static boolean grV()
  {
    AppMethodBeat.i(31939);
    Context localContext = MMApplicationContext.getContext();
    Intent localIntent = new Intent("android.intent.action.INSERT");
    localIntent.setType("vnd.android.cursor.dir/contact");
    localIntent.putExtra("phone", "10086");
    boolean bool = Util.isIntentAvailable(localContext, localIntent);
    AppMethodBeat.o(31939);
    return bool;
  }
  
  static boolean grW()
  {
    AppMethodBeat.i(31940);
    boolean bool = Util.isIntentAvailable(MMApplicationContext.getContext(), new Intent("android.intent.action.PICK", ContactsContract.Contacts.CONTENT_URI));
    AppMethodBeat.o(31940);
    return bool;
  }
  
  static final class a
    extends BaseAdapter
  {
    private Bundle GY;
    private DialogInterface.OnDismissListener Krq;
    a Krr;
    private List<String> cvc;
    private Context mContext;
    
    public a(List<String> paramList, Context paramContext, DialogInterface.OnDismissListener paramOnDismissListener, Bundle paramBundle)
    {
      AppMethodBeat.i(31931);
      this.cvc = null;
      this.mContext = null;
      this.Krq = null;
      this.GY = null;
      this.Krr = null;
      if (paramContext != null) {}
      for (boolean bool = true;; bool = false)
      {
        Assert.assertTrue(bool);
        this.cvc = paramList;
        this.mContext = paramContext;
        this.Krq = paramOnDismissListener;
        this.GY = paramBundle;
        AppMethodBeat.o(31931);
        return;
      }
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(31932);
      if (this.cvc == null)
      {
        AppMethodBeat.o(31932);
        return 0;
      }
      int i = this.cvc.size();
      AppMethodBeat.o(31932);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(31933);
      Object localObject = this.cvc.get(paramInt);
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
      String str = (String)this.cvc.get(paramInt);
      if (this.mContext.getString(2131757480).equals(str))
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
          paramView = paramView.inflate(2131493573, paramViewGroup, false);
          paramViewGroup = new b((byte)0);
          ((b)paramViewGroup).hbb = ((TextView)paramView.findViewById(2131309195));
          ((b)paramViewGroup).thJ = ((Button)paramView.findViewById(2131299751));
          ((b)paramViewGroup).Krt = ((TextView)paramView.findViewById(2131309157));
          paramView.setTag(paramViewGroup);
          switch (paramInt)
          {
          default: 
            label116:
            Log.e("MicroMsg.MailPhoneMenuHelper", "hy: error tag");
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(31935);
        return paramView;
        paramView = paramView.inflate(2131493574, paramViewGroup, false);
        paramViewGroup = new c((byte)0);
        ((c)paramViewGroup).hbb = ((TextView)paramView.findViewById(2131309195));
        break;
        paramViewGroup = paramView.getTag();
        break label116;
        paramViewGroup = (c)paramViewGroup;
        paramViewGroup.hbb.setText(l.b(this.mContext, Util.nullAsNil(str), paramViewGroup.hbb.getTextSize()));
        continue;
        paramViewGroup = (b)paramViewGroup;
        paramViewGroup.hbb.setText(l.b(this.mContext, Util.nullAsNil(str), paramViewGroup.hbb.getTextSize()));
        paramViewGroup.Krt.setText(this.mContext.getString(2131757486));
        paramViewGroup.thJ.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(31930);
            b localb = new b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/span/MailPhoneMenuHelper$PhoneAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            if (!PlatformComm.C2Java.isNetworkConnected())
            {
              Log.w("MicroMsg.MailPhoneMenuHelper", "hy: no network. abort download");
              u.makeText(n.a.a(n.a.this), n.a.a(n.a.this).getString(2131760826), 0).show();
              if (n.a.b(n.a.this) != null) {
                n.a.b(n.a.this).qA(false);
              }
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/span/MailPhoneMenuHelper$PhoneAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(31930);
              return;
              s.i(n.a.a(n.a.this), n.a.c(n.a.this));
              if (n.a.b(n.a.this) != null) {
                n.a.b(n.a.this).qA(true);
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
      public abstract void qA(boolean paramBoolean);
    }
    
    final class b
    {
      TextView Krt;
      TextView hbb;
      Button thJ;
      
      private b() {}
    }
    
    final class c
    {
      TextView hbb;
      
      private c() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.span.n
 * JD-Core Version:    0.7.0.1
 */