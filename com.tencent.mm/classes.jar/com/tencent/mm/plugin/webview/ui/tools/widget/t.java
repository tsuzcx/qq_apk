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
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.protocal.protobuf.eul;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.AuthorizeItemListView;
import com.tencent.mm.ui.widget.a.i;
import java.util.ArrayList;
import java.util.LinkedList;

public final class t
{
  private b Xry;
  private Context context;
  private String mAppName = "";
  private String rFh;
  AuthorizeItemListView uBA;
  private LinearLayout uBC;
  
  public t(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private boolean a(String paramString, final LinkedList<eul> paramLinkedList, final a parama)
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
    ((androidx.core.graphics.drawable.b)localObject).DL();
    if (paramString != null) {
      com.tencent.mm.modelappbrand.a.b.bEY().a(paramString, this.rFh, (Drawable)localObject, new e());
    }
    paramString = (TextView)localLinearLayout.findViewById(c.e.app_name_tv);
    if (this.mAppName == null) {
      this.mAppName = "";
    }
    paramString.setText(p.b(this.context, this.context.getString(c.h.login_auth_request_tips, new Object[] { this.mAppName }), paramString.getTextSize()));
    this.uBA = ((AuthorizeItemListView)localLinearLayout.findViewById(c.e.auth_content_list));
    this.Xry = new b(paramLinkedList);
    this.uBA.setAdapter(this.Xry);
    if (paramLinkedList.size() > 5)
    {
      this.uBA.bUo = paramLinkedList.size();
      this.uBC = ((LinearLayout)localLinearLayout.findViewById(c.e.auth_scope_list_layout));
      paramString = (LinearLayout.LayoutParams)this.uBC.getLayoutParams();
      paramString.height = this.context.getResources().getDimensionPixelSize(c.c.login_desc_list_height);
      this.uBC.setLayoutParams(paramString);
    }
    ((Button)localLinearLayout.findViewById(c.e.login_accept)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(151595);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/widget/WebAuthorizeDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        paramAnonymousView = new ArrayList();
        int i = 0;
        while (i < paramLinkedList.size())
        {
          if ((((eul)paramLinkedList.get(i)).abxm == 2) || (((eul)paramLinkedList.get(i)).abxm == 3)) {
            paramAnonymousView.add(((eul)paramLinkedList.get(i)).YVX);
          }
          i += 1;
        }
        Log.d("MicroMsg.AppBrandAuthorizeDialog", "stev acceptButton click!");
        localObject = new Bundle();
        ((Bundle)localObject).putSerializable("key_scope", paramAnonymousView);
        parama.l(1, (Bundle)localObject);
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
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/widget/WebAuthorizeDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        paramAnonymousView = new ArrayList();
        int i = 0;
        while (i < paramLinkedList.size())
        {
          if ((((eul)paramLinkedList.get(i)).abxm == 2) || (((eul)paramLinkedList.get(i)).abxm == 3)) {
            paramAnonymousView.add(((eul)paramLinkedList.get(i)).YVX);
          }
          i += 1;
        }
        Log.d("MicroMsg.AppBrandAuthorizeDialog", "stev rejectButton click!");
        localObject = new Bundle();
        ((Bundle)localObject).putSerializable("key_scope", paramAnonymousView);
        parama.l(2, (Bundle)localObject);
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
        if (t.this.uBA != null) {
          t.this.uBA.setAdapter(null);
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
        parama.l(3, null);
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
  
  public final boolean a(LinkedList<eul> paramLinkedList, String paramString1, String paramString2, a parama)
  {
    AppMethodBeat.i(151605);
    boolean bool = a(paramLinkedList, paramString1, paramString2, null, parama);
    AppMethodBeat.o(151605);
    return bool;
  }
  
  public final boolean a(LinkedList<eul> paramLinkedList, String paramString1, String paramString2, String paramString3, a parama)
  {
    AppMethodBeat.i(151604);
    Log.d("MicroMsg.AppBrandAuthorizeDialog", "stev AppBrandAuthorizeDialog showAlert!");
    this.mAppName = paramString1;
    this.rFh = paramString2;
    boolean bool = a(paramString3, paramLinkedList, parama);
    AppMethodBeat.o(151604);
    return bool;
  }
  
  public static abstract interface a
  {
    public abstract void l(int paramInt, Bundle paramBundle);
  }
  
  final class b
    extends BaseAdapter
  {
    private LinkedList<eul> XrA;
    
    public b()
    {
      Object localObject;
      this.XrA = localObject;
    }
    
    private eul ava(int paramInt)
    {
      AppMethodBeat.i(151601);
      eul localeul = (eul)this.XrA.get(paramInt);
      AppMethodBeat.o(151601);
      return localeul;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(151600);
      if (this.XrA == null)
      {
        AppMethodBeat.o(151600);
        return 0;
      }
      int i = this.XrA.size();
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
      if ((this.XrA == null) || (this.XrA.size() <= 0))
      {
        AppMethodBeat.o(151602);
        return null;
      }
      final eul localeul = ava(paramInt);
      Object localObject;
      if (paramView == null)
      {
        paramView = new a((byte)0);
        localObject = View.inflate(paramViewGroup.getContext(), c.f.authorize_scope_item, null);
        paramView.WTJ = ((ImageView)((View)localObject).findViewById(c.e.app_auth_state));
        paramView.uBM = ((TextView)((View)localObject).findViewById(c.e.app_auth_desc));
        ((View)localObject).setTag(paramView);
        paramViewGroup = paramView;
        paramView = (View)localObject;
        if (localeul.abxm != 1) {
          break label178;
        }
        paramViewGroup.WTJ.setImageResource(c.g.login_auth_state_not_selected);
      }
      for (;;)
      {
        paramViewGroup.uBM.setText(localeul.IGG);
        localObject = paramViewGroup.WTJ;
        paramViewGroup.WTJ.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(151599);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/widget/WebAuthorizeDialog$LoginAuthListAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            if (localeul.abxm == 2)
            {
              this.WTH.setImageResource(c.g.login_auth_state_not_selected);
              localeul.abxm = 1;
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/widget/WebAuthorizeDialog$LoginAuthListAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(151599);
              return;
              if (localeul.abxm == 1)
              {
                this.WTH.setImageResource(c.g.login_auth_state_default_select);
                localeul.abxm = 2;
              }
            }
          }
        });
        AppMethodBeat.o(151602);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label178:
        if (localeul.abxm == 3) {
          paramViewGroup.WTJ.setImageResource(c.g.login_auth_state_must_select);
        } else {
          paramViewGroup.WTJ.setImageResource(c.g.login_auth_state_default_select);
        }
      }
    }
    
    final class a
    {
      ImageView WTJ;
      TextView uBM;
      
      private a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.t
 * JD-Core Version:    0.7.0.1
 */