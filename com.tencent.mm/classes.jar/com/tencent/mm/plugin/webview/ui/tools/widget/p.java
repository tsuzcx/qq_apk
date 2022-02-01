package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.core.graphics.drawable.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.e;
import com.tencent.mm.plugin.comm.c.c;
import com.tencent.mm.plugin.comm.c.e;
import com.tencent.mm.plugin.comm.c.f;
import com.tencent.mm.plugin.comm.c.g;
import com.tencent.mm.plugin.comm.c.h;
import com.tencent.mm.plugin.comm.c.i;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.eax;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.AuthorizeItemListView;
import com.tencent.mm.ui.base.i;
import java.util.ArrayList;
import java.util.LinkedList;

public final class p
{
  private b QyG;
  private Context context;
  private String mAppName = "";
  private String oBv;
  AuthorizeItemListView rrp;
  private LinearLayout rrr;
  
  public p(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private boolean a(String paramString, final LinkedList<eax> paramLinkedList, final a parama)
  {
    AppMethodBeat.i(151606);
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      Log.e("MicroMsg.AppBrandAuthorizeDialog", "scopeInfoList is empty or null");
      AppMethodBeat.o(151606);
      return false;
    }
    final i locali = new i(this.context, c.i.mmcustomdialog);
    LinearLayout localLinearLayout = (LinearLayout)((LayoutInflater)this.context.getSystemService("layout_inflater")).inflate(c.f.authorize_dialog_view, null);
    Object localObject = (TextView)localLinearLayout.findViewById(c.e.wechat_auth);
    if (!Util.isNullOrNil(paramString)) {
      ((TextView)localObject).setText(paramString);
    }
    paramString = (ImageView)localLinearLayout.findViewById(c.e.app_icon_iv);
    localObject = com.tencent.mm.compatible.f.a.decodeResource(MMApplicationContext.getResources(), c.g.default_avatar);
    localObject = d.a(MMApplicationContext.getResources(), (Bitmap)localObject);
    ((androidx.core.graphics.drawable.b)localObject).gB();
    if (paramString != null) {
      com.tencent.mm.modelappbrand.a.b.bhh().a(paramString, this.oBv, (Drawable)localObject, new e());
    }
    paramString = (TextView)localLinearLayout.findViewById(c.e.app_name_tv);
    if (this.mAppName == null) {
      this.mAppName = "";
    }
    paramString.setText(l.b(this.context, this.context.getString(c.h.login_auth_request_tips, new Object[] { this.mAppName }), paramString.getTextSize()));
    this.rrp = ((AuthorizeItemListView)localLinearLayout.findViewById(c.e.auth_content_list));
    this.QyG = new b(paramLinkedList);
    this.rrp.setAdapter(this.QyG);
    if (paramLinkedList.size() > 5)
    {
      this.rrp.afI = paramLinkedList.size();
      this.rrr = ((LinearLayout)localLinearLayout.findViewById(c.e.auth_scope_list_layout));
      paramString = (LinearLayout.LayoutParams)this.rrr.getLayoutParams();
      paramString.height = this.context.getResources().getDimensionPixelSize(c.c.login_desc_list_height);
      this.rrr.setLayoutParams(paramString);
    }
    ((Button)localLinearLayout.findViewById(c.e.login_accept)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(151595);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/widget/WebAuthorizeDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        paramAnonymousView = new ArrayList();
        int i = 0;
        while (i < paramLinkedList.size())
        {
          if ((((eax)paramLinkedList.get(i)).UfR == 2) || (((eax)paramLinkedList.get(i)).UfR == 3)) {
            paramAnonymousView.add(((eax)paramLinkedList.get(i)).RXY);
          }
          i += 1;
        }
        Log.d("MicroMsg.AppBrandAuthorizeDialog", "stev acceptButton click!");
        localObject = new Bundle();
        ((Bundle)localObject).putSerializable("key_scope", paramAnonymousView);
        parama.k(1, (Bundle)localObject);
        locali.dismiss();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/widget/WebAuthorizeDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(151595);
      }
    });
    ((Button)localLinearLayout.findViewById(c.e.login_reject)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(151596);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/widget/WebAuthorizeDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        paramAnonymousView = new ArrayList();
        int i = 0;
        while (i < paramLinkedList.size())
        {
          if ((((eax)paramLinkedList.get(i)).UfR == 2) || (((eax)paramLinkedList.get(i)).UfR == 3)) {
            paramAnonymousView.add(((eax)paramLinkedList.get(i)).RXY);
          }
          i += 1;
        }
        Log.d("MicroMsg.AppBrandAuthorizeDialog", "stev rejectButton click!");
        localObject = new Bundle();
        ((Bundle)localObject).putSerializable("key_scope", paramAnonymousView);
        parama.k(2, (Bundle)localObject);
        locali.dismiss();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/widget/WebAuthorizeDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(151596);
      }
    });
    locali.setCanceledOnTouchOutside(false);
    locali.setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(151597);
        if (p.this.rrp != null) {
          p.this.rrp.setAdapter(null);
        }
        AppMethodBeat.o(151597);
      }
    });
    locali.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(151598);
        Log.d("MicroMsg.AppBrandAuthorizeDialog", "stev dialog onCancel");
        parama.k(3, null);
        AppMethodBeat.o(151598);
      }
    });
    locali.setContentView(localLinearLayout);
    try
    {
      locali.show();
      AppMethodBeat.o(151606);
      return true;
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.AppBrandAuthorizeDialog", "dialog show failed %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(151606);
    }
    return false;
  }
  
  public final boolean a(LinkedList<eax> paramLinkedList, String paramString1, String paramString2, a parama)
  {
    AppMethodBeat.i(151605);
    boolean bool = a(paramLinkedList, paramString1, paramString2, null, parama);
    AppMethodBeat.o(151605);
    return bool;
  }
  
  public final boolean a(LinkedList<eax> paramLinkedList, String paramString1, String paramString2, String paramString3, a parama)
  {
    AppMethodBeat.i(151604);
    Log.d("MicroMsg.AppBrandAuthorizeDialog", "stev AppBrandAuthorizeDialog showAlert!");
    this.mAppName = paramString1;
    this.oBv = paramString2;
    boolean bool = a(paramString3, paramLinkedList, parama);
    AppMethodBeat.o(151604);
    return bool;
  }
  
  public static abstract interface a
  {
    public abstract void k(int paramInt, Bundle paramBundle);
  }
  
  final class b
    extends BaseAdapter
  {
    private LinkedList<eax> QyI;
    
    public b()
    {
      Object localObject;
      this.QyI = localObject;
    }
    
    private eax apc(int paramInt)
    {
      AppMethodBeat.i(151601);
      eax localeax = (eax)this.QyI.get(paramInt);
      AppMethodBeat.o(151601);
      return localeax;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(151600);
      if (this.QyI == null)
      {
        AppMethodBeat.o(151600);
        return 0;
      }
      int i = this.QyI.size();
      AppMethodBeat.o(151600);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(151602);
      if ((this.QyI == null) || (this.QyI.size() <= 0))
      {
        AppMethodBeat.o(151602);
        return null;
      }
      final eax localeax = apc(paramInt);
      Object localObject;
      if (paramView == null)
      {
        paramView = new a((byte)0);
        localObject = View.inflate(paramViewGroup.getContext(), c.f.authorize_scope_item, null);
        paramView.Qcb = ((ImageView)((View)localObject).findViewById(c.e.app_auth_state));
        paramView.rrB = ((TextView)((View)localObject).findViewById(c.e.app_auth_desc));
        ((View)localObject).setTag(paramView);
        paramViewGroup = paramView;
        paramView = (View)localObject;
        if (localeax.UfR != 1) {
          break label178;
        }
        paramViewGroup.Qcb.setImageResource(c.g.login_auth_state_not_selected);
      }
      for (;;)
      {
        paramViewGroup.rrB.setText(localeax.CMB);
        localObject = paramViewGroup.Qcb;
        paramViewGroup.Qcb.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(151599);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/widget/WebAuthorizeDialog$LoginAuthListAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            if (localeax.UfR == 2)
            {
              this.QbZ.setImageResource(c.g.login_auth_state_not_selected);
              localeax.UfR = 1;
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/widget/WebAuthorizeDialog$LoginAuthListAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(151599);
              return;
              if (localeax.UfR == 1)
              {
                this.QbZ.setImageResource(c.g.login_auth_state_default_select);
                localeax.UfR = 2;
              }
            }
          }
        });
        AppMethodBeat.o(151602);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label178:
        if (localeax.UfR == 3) {
          paramViewGroup.Qcb.setImageResource(c.g.login_auth_state_must_select);
        } else {
          paramViewGroup.Qcb.setImageResource(c.g.login_auth_state_default_select);
        }
      }
    }
    
    final class a
    {
      ImageView Qcb;
      TextView rrB;
      
      private a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.p
 * JD-Core Version:    0.7.0.1
 */