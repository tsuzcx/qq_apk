package com.tencent.mm.pluginsdk.ui.span;

import android.app.Activity;
import android.content.Context;
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
import com.tencent.mm.R.c;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.protocal.protobuf.cyv;
import com.tencent.mm.protocal.protobuf.dkz;
import com.tencent.mm.protocal.protobuf.dla;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.tools.m;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class n
{
  static String Rsp;
  
  private static void a(Activity paramActivity, as paramas, String paramString, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(31941);
    cyv localcyv = new cyv();
    localcyv.TGE = paramString;
    dla localdla = new dla();
    localdla.TSh = new LinkedList();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (com.tencent.mm.plugin.bbom.c.aoI(str))
      {
        dkz localdkz = new dkz();
        localdkz.TSg = str;
        localdla.TSh.add(localdkz);
        localArrayList.add(str);
      }
    }
    localdla.rVx = localArrayList.size();
    localcyv.TGv = localdla;
    ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbK().d(new k.a(60, localcyv));
    com.tencent.mm.contact.a.a(paramas, paramString, paramArrayList);
    Toast.makeText(paramActivity, paramActivity.getString(R.l.eTJ), 0).show();
    AppMethodBeat.o(31941);
  }
  
  public static void a(final Context paramContext, String paramString, final DialogInterface.OnDismissListener paramOnDismissListener, final Bundle paramBundle)
  {
    AppMethodBeat.i(31937);
    if (!(paramContext instanceof Activity)) {
      Log.w("MicroMsg.MailPhoneMenuHelper", "context should be Activity, %s", new Object[] { Util.getStack() });
    }
    if (com.tencent.mm.kernel.h.aHE().aGM()) {}
    label401:
    for (boolean bool = ((Boolean)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vjr, Boolean.FALSE)).booleanValue();; bool = false)
    {
      final int i;
      if (paramBundle != null)
      {
        i = paramBundle.getInt("fromScene");
        if (!hmU()) {
          break label599;
        }
        if (paramBundle != null) {
          break label339;
        }
        localObject = "";
        label90:
        localObject = Util.nullAsNil((String)localObject);
        if ((localObject != null) && (localObject != "") && (!z.PD((String)localObject)) && (!as.bvK((String)localObject))) {
          break label401;
        }
        if (!bool) {
          break label350;
        }
        localObject = new String[4];
        localObject[0] = paramContext.getResources().getString(R.l.ewA);
        localObject[1] = paramContext.getResources().getString(R.l.ewB);
        localObject[2] = paramContext.getResources().getString(R.l.eww);
        localObject[3] = paramContext.getResources().getString(R.l.ewu);
      }
      label193:
      label339:
      label599:
      for (Object localObject = Util.stringsToList((String[])localObject);; localObject = Util.stringsToList(new String[] { paramContext.getResources().getString(R.l.ewA), paramContext.getResources().getString(R.l.eww) }))
      {
        com.tencent.mm.plugin.report.service.h.IzE.a(11621, new Object[] { Integer.valueOf(i), Integer.valueOf(2) });
        final com.tencent.mm.ui.base.n localn = new com.tencent.mm.ui.base.n(paramContext);
        localn.setTitle(paramString);
        a locala = new a((List)localObject, paramContext, paramOnDismissListener, paramBundle);
        locala.Rsy = new n.a.a()
        {
          public final void tC(boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(31925);
            if (paramAnonymousBoolean)
            {
              this.Rst.dismiss();
              if (paramOnDismissListener != null) {
                paramOnDismissListener.onDismiss(null);
              }
            }
            AppMethodBeat.o(31925);
          }
        };
        localn.ttU = locala;
        com.tencent.mm.ui.base.h.a(paramContext, localn);
        localn.setOnCancelListener(new n.6(paramOnDismissListener));
        localn.Ruo = new AdapterView.OnItemClickListener()
        {
          public final void onItemClick(final AdapterView<?> paramAnonymousAdapterView, final View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            AppMethodBeat.i(31929);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousAdapterView);
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
            ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramAnonymousInt);
            ((com.tencent.mm.hellhoundlib.b.b)localObject).Fs(paramAnonymousLong);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/span/MailPhoneMenuHelper$7", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
            paramAnonymousView = this.DZj.replace(" ", "").replace("(", "").replace(")", "").replace("-", "");
            paramAnonymousAdapterView = paramAnonymousView.replaceAll("#", "%23");
            localObject = (String)this.wJP.get(paramAnonymousInt);
            Log.i("MicroMsg.MailPhoneMenuHelper", (String)localObject);
            if (paramContext.getString(R.l.ewA).equals(localObject))
            {
              paramAnonymousView = new Intent("android.intent.action.DIAL", Uri.parse("tel:".concat(String.valueOf(paramAnonymousAdapterView))));
              paramAnonymousView.addFlags(268435456);
              if (Util.isIntentAvailable(paramContext, paramAnonymousView))
              {
                paramAnonymousAdapterView = paramContext;
                paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bm(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousAdapterView, paramAnonymousView.aFh(), "com/tencent/mm/pluginsdk/ui/span/MailPhoneMenuHelper$7", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymousAdapterView.startActivity((Intent)paramAnonymousView.sf(0));
                com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousAdapterView, "com/tencent/mm/pluginsdk/ui/span/MailPhoneMenuHelper$7", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              }
              com.tencent.mm.plugin.report.service.h.IzE.kvStat(10112, "1");
              localn.dismiss();
              if (paramOnDismissListener != null) {
                paramOnDismissListener.onDismiss(null);
              }
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/span/MailPhoneMenuHelper$7", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(31929);
              return;
              if (paramContext.getString(R.l.ewB).equals(localObject))
              {
                com.tencent.mm.plugin.report.service.h.IzE.a(12059, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
                paramAnonymousAdapterView = new Intent();
                paramAnonymousAdapterView.putExtra("IPCallTalkUI_phoneNumber", paramAnonymousView);
                com.tencent.mm.by.c.b(paramContext, "ipcall", ".ui.IPCallDialUI", paramAnonymousAdapterView);
                localn.dismiss();
                if (paramOnDismissListener != null) {
                  paramOnDismissListener.onDismiss(null);
                }
              }
              else
              {
                if (paramContext.getString(R.l.ewu).equals(localObject))
                {
                  if ((n.hmV()) && (n.hmW())) {
                    paramAnonymousAdapterView = paramContext.getResources().getStringArray(R.c.djR);
                  }
                  for (;;)
                  {
                    paramContext.getResources().getString(R.l.ewy);
                    localObject = new m(paramContext);
                    ((m)localObject).ODT = new q.f()
                    {
                      public final void onCreateMMMenu(o paramAnonymous2o)
                      {
                        AppMethodBeat.i(179832);
                        int i = 0;
                        while (i < paramAnonymousAdapterView.length)
                        {
                          paramAnonymous2o.d(i, paramAnonymousAdapterView[i]);
                          i += 1;
                        }
                        AppMethodBeat.o(179832);
                      }
                    };
                    ((m)localObject).ODU = new q.g()
                    {
                      public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
                      {
                        AppMethodBeat.i(179833);
                        if (n.7.this.Rsq != null) {
                          n.7.this.Rsq.onDismiss(null);
                        }
                        switch (paramAnonymous2MenuItem.getItemId())
                        {
                        }
                        for (;;)
                        {
                          AppMethodBeat.o(179833);
                          return;
                          if (n.hmV())
                          {
                            paramAnonymous2MenuItem = n.7.this.val$context;
                            Object localObject = paramAnonymousView;
                            Intent localIntent = new Intent("android.intent.action.INSERT");
                            localIntent.setType("vnd.android.cursor.dir/contact");
                            localIntent.putExtra("phone", (String)localObject);
                            localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
                            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymous2MenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/pluginsdk/ui/span/MailPhoneMenuHelper", "phoneCreateContact", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            paramAnonymous2MenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
                            com.tencent.mm.hellhoundlib.a.a.c(paramAnonymous2MenuItem, "com/tencent/mm/pluginsdk/ui/span/MailPhoneMenuHelper", "phoneCreateContact", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            com.tencent.mm.plugin.report.service.h.IzE.kvStat(10113, "1");
                            AppMethodBeat.o(179833);
                            return;
                          }
                          n.ci(n.7.this.val$context, paramAnonymousView);
                          com.tencent.mm.plugin.report.service.h.IzE.kvStat(10114, "1");
                          AppMethodBeat.o(179833);
                          return;
                          n.ci(n.7.this.val$context, paramAnonymousView);
                          com.tencent.mm.plugin.report.service.h.IzE.kvStat(10114, "1");
                        }
                      }
                    };
                    ((m)localObject).a(new e.b()
                    {
                      public final void onDismiss()
                      {
                        AppMethodBeat.i(179834);
                        if (n.7.this.Rsq != null) {
                          n.7.this.Rsq.onDismiss(null);
                        }
                        AppMethodBeat.o(179834);
                      }
                    });
                    localn.dismiss();
                    ((m)localObject).hYu();
                    break;
                    if (n.hmV())
                    {
                      paramAnonymousAdapterView = new String[1];
                      paramAnonymousAdapterView[0] = paramContext.getResources().getString(R.l.ewt);
                    }
                    else
                    {
                      paramAnonymousAdapterView = new String[1];
                      paramAnonymousAdapterView[0] = paramContext.getResources().getString(R.l.ewz);
                    }
                  }
                }
                if (paramContext.getString(R.l.eww).equals(localObject))
                {
                  ClipboardHelper.setText(paramContext, paramAnonymousView, paramAnonymousView);
                  com.tencent.mm.plugin.report.service.h.IzE.kvStat(10115, "1");
                  if (paramOnDismissListener != null) {
                    paramOnDismissListener.onDismiss(null);
                  }
                  localn.dismiss();
                  Toast.makeText(paramContext, paramContext.getString(R.l.app_copy_ok), 1).show();
                }
                else if (paramContext.getString(R.l.ewx).equals(localObject))
                {
                  Log.d("MicroMsg.MailPhoneMenuHelper", "hy: button should consume this action");
                }
                else if (n.Rsp.equals(localObject))
                {
                  n.a((Activity)paramContext, this.DZj, paramBundle);
                  localn.dismiss();
                  if (paramOnDismissListener != null) {
                    paramOnDismissListener.onDismiss(null);
                  }
                }
                else
                {
                  Log.e("MicroMsg.MailPhoneMenuHelper", "hy: error phone item clicked. should not happen");
                  localn.dismiss();
                  if (paramOnDismissListener != null) {
                    paramOnDismissListener.onDismiss(null);
                  }
                }
              }
            }
          }
        };
        localn.show();
        AppMethodBeat.o(31937);
        return;
        i = 0;
        break;
        localObject = paramBundle.getString("Contact_User");
        break label90;
        label350:
        localObject = new String[3];
        localObject[0] = paramContext.getResources().getString(R.l.ewA);
        localObject[1] = paramContext.getResources().getString(R.l.eww);
        localObject[2] = paramContext.getResources().getString(R.l.ewu);
        break label193;
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().RG((String)localObject);
        if (localObject == null)
        {
          AppMethodBeat.o(31937);
          return;
        }
        localObject = ((as)localObject).ays();
        Rsp = paramContext.getResources().getString(R.l.ewv, new Object[] { localObject });
        if (bool)
        {
          localObject = new String[5];
          localObject[0] = paramContext.getResources().getString(R.l.ewA);
          localObject[1] = paramContext.getResources().getString(R.l.ewB);
          localObject[2] = Rsp;
          localObject[3] = paramContext.getResources().getString(R.l.eww);
          localObject[4] = paramContext.getResources().getString(R.l.ewu);
          break label193;
        }
        localObject = new String[4];
        localObject[0] = paramContext.getResources().getString(R.l.ewA);
        localObject[1] = Rsp;
        localObject[2] = paramContext.getResources().getString(R.l.eww);
        localObject[3] = paramContext.getResources().getString(R.l.ewu);
        break label193;
      }
    }
  }
  
  public static void b(Context paramContext, String paramString, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    AppMethodBeat.i(31936);
    if ((z.bdn() & 0x1) == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      com.tencent.mm.ui.base.h.a(paramContext, paramString, paramContext.getResources().getStringArray(R.c.djO), "", new n.1(paramOnDismissListener, paramString, paramContext));
      AppMethodBeat.o(31936);
      return;
    }
    String str = paramContext.getResources().getString(R.l.euJ);
    paramOnDismissListener = new n.2(paramOnDismissListener, paramString, paramContext);
    com.tencent.mm.ui.base.h.a(paramContext, paramString, new String[] { str }, "", paramOnDismissListener);
    AppMethodBeat.o(31936);
  }
  
  private static boolean hmU()
  {
    AppMethodBeat.i(31938);
    if ((hmV()) || (hmW()))
    {
      AppMethodBeat.o(31938);
      return true;
    }
    AppMethodBeat.o(31938);
    return false;
  }
  
  static boolean hmV()
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
  
  static boolean hmW()
  {
    AppMethodBeat.i(31940);
    boolean bool = Util.isIntentAvailable(MMApplicationContext.getContext(), new Intent("android.intent.action.PICK", ContactsContract.Contacts.CONTENT_URI));
    AppMethodBeat.o(31940);
    return bool;
  }
  
  static final class a
    extends BaseAdapter
  {
    private DialogInterface.OnDismissListener Rsx;
    a Rsy;
    private Bundle aaS;
    private List<String> ctq;
    private Context mContext;
    
    public a(List<String> paramList, Context paramContext, DialogInterface.OnDismissListener paramOnDismissListener, Bundle paramBundle)
    {
      AppMethodBeat.i(31931);
      this.ctq = null;
      this.mContext = null;
      this.Rsx = null;
      this.aaS = null;
      this.Rsy = null;
      if (paramContext != null) {}
      for (boolean bool = true;; bool = false)
      {
        Assert.assertTrue(bool);
        this.ctq = paramList;
        this.mContext = paramContext;
        this.Rsx = paramOnDismissListener;
        this.aaS = paramBundle;
        AppMethodBeat.o(31931);
        return;
      }
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(31932);
      if (this.ctq == null)
      {
        AppMethodBeat.o(31932);
        return 0;
      }
      int i = this.ctq.size();
      AppMethodBeat.o(31932);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(31933);
      Object localObject = this.ctq.get(paramInt);
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
      String str = (String)this.ctq.get(paramInt);
      if (this.mContext.getString(R.l.ewx).equals(str))
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
          paramView = paramView.inflate(R.i.edC, paramViewGroup, false);
          paramViewGroup = new b((byte)0);
          ((b)paramViewGroup).jMg = ((TextView)paramView.findViewById(R.h.title));
          ((b)paramViewGroup).wOa = ((Button)paramView.findViewById(R.h.download_btn));
          ((b)paramViewGroup).RsA = ((TextView)paramView.findViewById(R.h.dXt));
          paramView.setTag(paramViewGroup);
          switch (paramInt)
          {
          default: 
            label120:
            Log.e("MicroMsg.MailPhoneMenuHelper", "hy: error tag");
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(31935);
        return paramView;
        paramView = paramView.inflate(R.i.edD, paramViewGroup, false);
        paramViewGroup = new c((byte)0);
        ((c)paramViewGroup).jMg = ((TextView)paramView.findViewById(R.h.title));
        break;
        paramViewGroup = paramView.getTag();
        break label120;
        paramViewGroup = (c)paramViewGroup;
        paramViewGroup.jMg.setText(l.b(this.mContext, Util.nullAsNil(str), paramViewGroup.jMg.getTextSize()));
        continue;
        paramViewGroup = (b)paramViewGroup;
        paramViewGroup.jMg.setText(l.b(this.mContext, Util.nullAsNil(str), paramViewGroup.jMg.getTextSize()));
        paramViewGroup.RsA.setText(this.mContext.getString(R.l.ewC));
        paramViewGroup.wOa.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(31930);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/span/MailPhoneMenuHelper$PhoneAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            if (!PlatformComm.C2Java.isNetworkConnected())
            {
              Log.w("MicroMsg.MailPhoneMenuHelper", "hy: no network. abort download");
              w.makeText(n.a.a(n.a.this), n.a.a(n.a.this).getString(R.l.fmt_iap_err), 0).show();
              if (n.a.b(n.a.this) != null) {
                n.a.b(n.a.this).tC(false);
              }
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/span/MailPhoneMenuHelper$PhoneAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(31930);
              return;
              s.i(n.a.a(n.a.this), n.a.c(n.a.this));
              if (n.a.b(n.a.this) != null) {
                n.a.b(n.a.this).tC(true);
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
      public abstract void tC(boolean paramBoolean);
    }
    
    final class b
    {
      TextView RsA;
      TextView jMg;
      Button wOa;
      
      private b() {}
    }
    
    final class c
    {
      TextView jMg;
      
      private c() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.span.n
 * JD-Core Version:    0.7.0.1
 */