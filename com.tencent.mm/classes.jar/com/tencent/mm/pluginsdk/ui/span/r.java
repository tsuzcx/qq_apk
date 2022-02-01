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
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
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
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.dqb;
import com.tencent.mm.protocal.protobuf.edj;
import com.tencent.mm.protocal.protobuf.edk;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.k.d;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.widget.a.f.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class r
{
  static String YoJ;
  
  private static void a(Activity paramActivity, au paramau, String paramString, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(31941);
    dqb localdqb = new dqb();
    localdqb.aaWl = paramString;
    edk localedk = new edk();
    localedk.abiF = new LinkedList();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (com.tencent.mm.plugin.bbom.c.aie(str))
      {
        edj localedj = new edj();
        localedj.abiE = str;
        localedk.abiF.add(localedj);
        localArrayList.add(str);
      }
    }
    localedk.vgN = localArrayList.size();
    localdqb.aaWb = localedk;
    ((n)com.tencent.mm.kernel.h.ax(n.class)).bzz().d(new k.a(60, localdqb));
    com.tencent.mm.contact.a.a(paramau, paramString, paramArrayList);
    Toast.makeText(paramActivity, paramActivity.getString(R.l.gWB), 0).show();
    AppMethodBeat.o(31941);
  }
  
  public static void a(final Context paramContext, String paramString, final DialogInterface.OnDismissListener paramOnDismissListener, final Bundle paramBundle)
  {
    AppMethodBeat.i(31937);
    if (!(paramContext instanceof Activity)) {
      Log.w("MicroMsg.MailPhoneMenuHelper", "context should be Activity, %s", new Object[] { Util.getStack() });
    }
    if (com.tencent.mm.kernel.h.baC().aZN()) {}
    label403:
    for (boolean bool = ((Boolean)com.tencent.mm.kernel.h.baE().ban().get(at.a.acKL, Boolean.FALSE)).booleanValue();; bool = false)
    {
      final int i;
      if (paramBundle != null)
      {
        i = paramBundle.getInt("fromScene");
        if (!iNK()) {
          break label601;
        }
        if (paramBundle != null) {
          break label341;
        }
        localObject = "";
        label92:
        localObject = Util.nullAsNil((String)localObject);
        if ((localObject != null) && (localObject != "") && (!z.Iy((String)localObject)) && (!au.bwO((String)localObject))) {
          break label403;
        }
        if (!bool) {
          break label352;
        }
        localObject = new String[4];
        localObject[0] = paramContext.getResources().getString(R.l.gzb);
        localObject[1] = paramContext.getResources().getString(R.l.gzc);
        localObject[2] = paramContext.getResources().getString(R.l.gyX);
        localObject[3] = paramContext.getResources().getString(R.l.gyV);
      }
      label195:
      label341:
      label601:
      for (Object localObject = Util.stringsToList((String[])localObject);; localObject = Util.stringsToList(new String[] { paramContext.getResources().getString(R.l.gzb), paramContext.getResources().getString(R.l.gyX) }))
      {
        com.tencent.mm.plugin.report.service.h.OAn.b(11621, new Object[] { Integer.valueOf(i), Integer.valueOf(2) });
        final com.tencent.mm.ui.base.r localr = new com.tencent.mm.ui.base.r(paramContext);
        localr.setTitle(paramString);
        a locala = new a((List)localObject, paramContext, paramOnDismissListener, paramBundle);
        locala.YoS = new r.a.a()
        {
          public final void sK(boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(31925);
            if (paramAnonymousBoolean)
            {
              r.this.dismiss();
              if (paramOnDismissListener != null) {
                paramOnDismissListener.onDismiss(null);
              }
            }
            AppMethodBeat.o(31925);
          }
        };
        localr.wyr = locala;
        k.a(paramContext, localr);
        localr.setOnCancelListener(new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(31926);
            if (r.this != null) {
              r.this.onDismiss(null);
            }
            AppMethodBeat.o(31926);
          }
        });
        localr.YqH = new AdapterView.OnItemClickListener()
        {
          public final void onItemClick(final AdapterView<?> paramAnonymousAdapterView, final View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            AppMethodBeat.i(31929);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousAdapterView);
            ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
            ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramAnonymousInt);
            ((com.tencent.mm.hellhoundlib.b.b)localObject).hB(paramAnonymousLong);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/span/MailPhoneMenuHelper$7", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
            paramAnonymousView = r.this.replace(" ", "").replace("(", "").replace(")", "").replace("-", "");
            paramAnonymousAdapterView = paramAnonymousView.replaceAll("#", "%23");
            localObject = (String)this.Agl.get(paramAnonymousInt);
            Log.i("MicroMsg.MailPhoneMenuHelper", (String)localObject);
            if (paramContext.getString(R.l.gzb).equals(localObject))
            {
              paramAnonymousView = new Intent("android.intent.action.DIAL", Uri.parse("tel:".concat(String.valueOf(paramAnonymousAdapterView))));
              paramAnonymousView.addFlags(268435456);
              if (Util.isIntentAvailable(paramContext, paramAnonymousView))
              {
                paramAnonymousAdapterView = paramContext;
                paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousAdapterView, paramAnonymousView.aYi(), "com/tencent/mm/pluginsdk/ui/span/MailPhoneMenuHelper$7", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymousAdapterView.startActivity((Intent)paramAnonymousView.sb(0));
                com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousAdapterView, "com/tencent/mm/pluginsdk/ui/span/MailPhoneMenuHelper$7", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              }
              com.tencent.mm.plugin.report.service.h.OAn.kvStat(10112, "1");
              localr.dismiss();
              if (paramOnDismissListener != null) {
                paramOnDismissListener.onDismiss(null);
              }
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/span/MailPhoneMenuHelper$7", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(31929);
              return;
              if (paramContext.getString(R.l.gzc).equals(localObject))
              {
                com.tencent.mm.plugin.report.service.h.OAn.b(12059, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
                paramAnonymousAdapterView = new Intent();
                paramAnonymousAdapterView.putExtra("IPCallTalkUI_phoneNumber", paramAnonymousView);
                com.tencent.mm.br.c.b(paramContext, "ipcall", ".ui.IPCallDialUI", paramAnonymousAdapterView);
                localr.dismiss();
                if (paramOnDismissListener != null) {
                  paramOnDismissListener.onDismiss(null);
                }
              }
              else
              {
                if (paramContext.getString(R.l.gyV).equals(localObject))
                {
                  if ((r.iNL()) && (r.iNM())) {
                    paramAnonymousAdapterView = paramContext.getResources().getStringArray(R.c.fjS);
                  }
                  for (;;)
                  {
                    paramContext.getResources().getString(R.l.gyZ);
                    localObject = new l(paramContext);
                    ((l)localObject).Vtg = new u.g()
                    {
                      public final void onCreateMMMenu(s paramAnonymous2s)
                      {
                        AppMethodBeat.i(179832);
                        int i = 0;
                        while (i < paramAnonymousAdapterView.length)
                        {
                          paramAnonymous2s.c(i, paramAnonymousAdapterView[i]);
                          i += 1;
                        }
                        AppMethodBeat.o(179832);
                      }
                    };
                    ((l)localObject).GAC = new u.i()
                    {
                      public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
                      {
                        AppMethodBeat.i(179833);
                        if (r.7.this.YoK != null) {
                          r.7.this.YoK.onDismiss(null);
                        }
                        switch (paramAnonymous2MenuItem.getItemId())
                        {
                        }
                        for (;;)
                        {
                          AppMethodBeat.o(179833);
                          return;
                          if (r.iNL())
                          {
                            paramAnonymous2MenuItem = r.7.this.val$context;
                            Object localObject = paramAnonymousView;
                            Intent localIntent = new Intent("android.intent.action.INSERT");
                            localIntent.setType("vnd.android.cursor.dir/contact");
                            localIntent.putExtra("phone", (String)localObject);
                            localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
                            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymous2MenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/pluginsdk/ui/span/MailPhoneMenuHelper", "phoneCreateContact", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            paramAnonymous2MenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
                            com.tencent.mm.hellhoundlib.a.a.c(paramAnonymous2MenuItem, "com/tencent/mm/pluginsdk/ui/span/MailPhoneMenuHelper", "phoneCreateContact", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            com.tencent.mm.plugin.report.service.h.OAn.kvStat(10113, "1");
                            AppMethodBeat.o(179833);
                            return;
                          }
                          r.cL(r.7.this.val$context, paramAnonymousView);
                          com.tencent.mm.plugin.report.service.h.OAn.kvStat(10114, "1");
                          AppMethodBeat.o(179833);
                          return;
                          r.cL(r.7.this.val$context, paramAnonymousView);
                          com.tencent.mm.plugin.report.service.h.OAn.kvStat(10114, "1");
                        }
                      }
                    };
                    ((l)localObject).a(new f.b()
                    {
                      public final void onDismiss()
                      {
                        AppMethodBeat.i(179834);
                        if (r.7.this.YoK != null) {
                          r.7.this.YoK.onDismiss(null);
                        }
                        AppMethodBeat.o(179834);
                      }
                    });
                    localr.dismiss();
                    ((l)localObject).jDd();
                    break;
                    if (r.iNL())
                    {
                      paramAnonymousAdapterView = new String[1];
                      paramAnonymousAdapterView[0] = paramContext.getResources().getString(R.l.gyU);
                    }
                    else
                    {
                      paramAnonymousAdapterView = new String[1];
                      paramAnonymousAdapterView[0] = paramContext.getResources().getString(R.l.gza);
                    }
                  }
                }
                if (paramContext.getString(R.l.gyX).equals(localObject))
                {
                  ClipboardHelper.setText(paramContext, paramAnonymousView, paramAnonymousView);
                  com.tencent.mm.plugin.report.service.h.OAn.kvStat(10115, "1");
                  if (paramOnDismissListener != null) {
                    paramOnDismissListener.onDismiss(null);
                  }
                  localr.dismiss();
                  Toast.makeText(paramContext, paramContext.getString(R.l.app_copy_ok), 1).show();
                }
                else if (paramContext.getString(R.l.gyY).equals(localObject))
                {
                  Log.d("MicroMsg.MailPhoneMenuHelper", "hy: button should consume this action");
                }
                else if (r.YoJ.equals(localObject))
                {
                  r.a((Activity)paramContext, r.this, paramBundle);
                  localr.dismiss();
                  if (paramOnDismissListener != null) {
                    paramOnDismissListener.onDismiss(null);
                  }
                }
                else
                {
                  Log.e("MicroMsg.MailPhoneMenuHelper", "hy: error phone item clicked. should not happen");
                  localr.dismiss();
                  if (paramOnDismissListener != null) {
                    paramOnDismissListener.onDismiss(null);
                  }
                }
              }
            }
          }
        };
        localr.show();
        AppMethodBeat.o(31937);
        return;
        i = 0;
        break;
        localObject = paramBundle.getString("Contact_User");
        break label92;
        label352:
        localObject = new String[3];
        localObject[0] = paramContext.getResources().getString(R.l.gzb);
        localObject[1] = paramContext.getResources().getString(R.l.gyX);
        localObject[2] = paramContext.getResources().getString(R.l.gyV);
        break label195;
        localObject = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE((String)localObject);
        if (localObject == null)
        {
          AppMethodBeat.o(31937);
          return;
        }
        localObject = ((au)localObject).aSV();
        YoJ = paramContext.getResources().getString(R.l.gyW, new Object[] { localObject });
        if (bool)
        {
          localObject = new String[5];
          localObject[0] = paramContext.getResources().getString(R.l.gzb);
          localObject[1] = paramContext.getResources().getString(R.l.gzc);
          localObject[2] = YoJ;
          localObject[3] = paramContext.getResources().getString(R.l.gyX);
          localObject[4] = paramContext.getResources().getString(R.l.gyV);
          break label195;
        }
        localObject = new String[4];
        localObject[0] = paramContext.getResources().getString(R.l.gzb);
        localObject[1] = YoJ;
        localObject[2] = paramContext.getResources().getString(R.l.gyX);
        localObject[3] = paramContext.getResources().getString(R.l.gyV);
        break label195;
      }
    }
  }
  
  public static void b(final Context paramContext, final String paramString, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    AppMethodBeat.i(31936);
    if ((z.bBf() & 0x1) == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      k.a(paramContext, paramString, paramContext.getResources().getStringArray(R.c.fjP), "", new k.d()
      {
        public final void qz(int paramAnonymousInt)
        {
          AppMethodBeat.i(31921);
          if (r.this != null) {
            r.this.onDismiss(null);
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
            r.X(paramContext, str1);
          }
        }
      });
      AppMethodBeat.o(31936);
      return;
    }
    String str = paramContext.getResources().getString(R.l.gxh);
    paramOnDismissListener = new k.d()
    {
      public final void qz(int paramAnonymousInt)
      {
        AppMethodBeat.i(31922);
        if (r.this != null) {
          r.this.onDismiss(null);
        }
        String str = paramString.replace(" ", "").replace("#", "@");
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(31922);
          return;
          r.X(paramContext, str);
        }
      }
    };
    k.a(paramContext, paramString, new String[] { str }, "", paramOnDismissListener);
    AppMethodBeat.o(31936);
  }
  
  private static boolean iNK()
  {
    AppMethodBeat.i(31938);
    if ((iNL()) || (iNM()))
    {
      AppMethodBeat.o(31938);
      return true;
    }
    AppMethodBeat.o(31938);
    return false;
  }
  
  static boolean iNL()
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
  
  static boolean iNM()
  {
    AppMethodBeat.i(31940);
    boolean bool = Util.isIntentAvailable(MMApplicationContext.getContext(), new Intent("android.intent.action.PICK", ContactsContract.Contacts.CONTENT_URI));
    AppMethodBeat.o(31940);
    return bool;
  }
  
  static final class a
    extends BaseAdapter
  {
    private DialogInterface.OnDismissListener YoR;
    a YoS;
    private Bundle bIB;
    private List<String> ell;
    private Context mContext;
    
    public a(List<String> paramList, Context paramContext, DialogInterface.OnDismissListener paramOnDismissListener, Bundle paramBundle)
    {
      AppMethodBeat.i(31931);
      this.ell = null;
      this.mContext = null;
      this.YoR = null;
      this.bIB = null;
      this.YoS = null;
      if (paramContext != null) {}
      for (boolean bool = true;; bool = false)
      {
        Assert.assertTrue(bool);
        this.ell = paramList;
        this.mContext = paramContext;
        this.YoR = paramOnDismissListener;
        this.bIB = paramBundle;
        AppMethodBeat.o(31931);
        return;
      }
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(31932);
      if (this.ell == null)
      {
        AppMethodBeat.o(31932);
        return 0;
      }
      int i = this.ell.size();
      AppMethodBeat.o(31932);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(31933);
      Object localObject = this.ell.get(paramInt);
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
      String str = (String)this.ell.get(paramInt);
      if (this.mContext.getString(R.l.gyY).equals(str))
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
          paramView = paramView.inflate(R.i.ggs, paramViewGroup, false);
          paramViewGroup = new b((byte)0);
          ((b)paramViewGroup).mll = ((TextView)paramView.findViewById(R.h.title));
          ((b)paramViewGroup).AkC = ((Button)paramView.findViewById(R.h.download_btn));
          ((b)paramViewGroup).YoU = ((TextView)paramView.findViewById(R.h.fZY));
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
        paramView = paramView.inflate(R.i.ggt, paramViewGroup, false);
        paramViewGroup = new c((byte)0);
        ((c)paramViewGroup).mll = ((TextView)paramView.findViewById(R.h.title));
        break;
        paramViewGroup = paramView.getTag();
        break label120;
        paramViewGroup = (c)paramViewGroup;
        paramViewGroup.mll.setText(p.b(this.mContext, Util.nullAsNil(str), paramViewGroup.mll.getTextSize()));
        continue;
        paramViewGroup = (b)paramViewGroup;
        paramViewGroup.mll.setText(p.b(this.mContext, Util.nullAsNil(str), paramViewGroup.mll.getTextSize()));
        paramViewGroup.YoU.setText(this.mContext.getString(R.l.gzd));
        paramViewGroup.AkC.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(31930);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/span/MailPhoneMenuHelper$PhoneAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            if (!PlatformComm.C2Java.isNetworkConnected())
            {
              Log.w("MicroMsg.MailPhoneMenuHelper", "hy: no network. abort download");
              aa.makeText(r.a.a(r.a.this), r.a.a(r.a.this).getString(R.l.fmt_iap_err), 0).show();
              if (r.a.b(r.a.this) != null) {
                r.a.b(r.a.this).sK(false);
              }
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/span/MailPhoneMenuHelper$PhoneAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(31930);
              return;
              w.k(r.a.a(r.a.this), r.a.c(r.a.this));
              if (r.a.b(r.a.this) != null) {
                r.a.b(r.a.this).sK(true);
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
      public abstract void sK(boolean paramBoolean);
    }
    
    final class b
    {
      Button AkC;
      TextView YoU;
      TextView mll;
      
      private b() {}
    }
    
    final class c
    {
      TextView mll;
      
      private c() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.span.r
 * JD-Core Version:    0.7.0.1
 */