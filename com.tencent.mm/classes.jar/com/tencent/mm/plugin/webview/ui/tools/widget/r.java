package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.graphics.drawable.d;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.e;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.cxm;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.AuthorizeItemListView;
import com.tencent.mm.ui.base.i;
import java.util.ArrayList;
import java.util.LinkedList;

public final class r
{
  private b Esr;
  private Context context;
  private String kyo;
  private String mAppName = "";
  AuthorizeItemListView naX;
  private LinearLayout naZ;
  
  public r(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private boolean a(String paramString, final LinkedList<cxm> paramLinkedList, final a parama)
  {
    AppMethodBeat.i(151606);
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      ad.e("MicroMsg.AppBrandAuthorizeDialog", "scopeInfoList is empty or null");
      AppMethodBeat.o(151606);
      return false;
    }
    final i locali = new i(this.context, 2131821725);
    LinearLayout localLinearLayout = (LinearLayout)((LayoutInflater)this.context.getSystemService("layout_inflater")).inflate(2131493119, null);
    Object localObject = (TextView)localLinearLayout.findViewById(2131306944);
    if (!bt.isNullOrNil(paramString)) {
      ((TextView)localObject).setText(paramString);
    }
    paramString = (ImageView)localLinearLayout.findViewById(2131296853);
    localObject = com.tencent.mm.compatible.e.a.decodeResource(aj.getResources(), 2131690013);
    localObject = d.a(aj.getResources(), (Bitmap)localObject);
    ((android.support.v4.graphics.drawable.b)localObject).ez();
    if (paramString != null) {
      com.tencent.mm.modelappbrand.a.b.aDV().a(paramString, this.kyo, (Drawable)localObject, new e());
    }
    paramString = (TextView)localLinearLayout.findViewById(2131296866);
    if (this.mAppName == null) {
      this.mAppName = "";
    }
    paramString.setText(k.b(this.context, this.context.getString(2131760748, new Object[] { this.mAppName }), paramString.getTextSize()));
    this.naX = ((AuthorizeItemListView)localLinearLayout.findViewById(2131296973));
    this.Esr = new b(paramLinkedList);
    this.naX.setAdapter(this.Esr);
    if (paramLinkedList.size() > 5)
    {
      this.naX.ajO = paramLinkedList.size();
      this.naZ = ((LinearLayout)localLinearLayout.findViewById(2131296983));
      paramString = (LinearLayout.LayoutParams)this.naZ.getLayoutParams();
      paramString.height = this.context.getResources().getDimensionPixelSize(2131166486);
      this.naZ.setLayoutParams(paramString);
    }
    ((Button)localLinearLayout.findViewById(2131301557)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(151595);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/widget/WebAuthorizeDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        paramAnonymousView = new ArrayList();
        int i = 0;
        while (i < paramLinkedList.size())
        {
          if ((((cxm)paramLinkedList.get(i)).HoV == 2) || (((cxm)paramLinkedList.get(i)).HoV == 3)) {
            paramAnonymousView.add(((cxm)paramLinkedList.get(i)).FKf);
          }
          i += 1;
        }
        ad.d("MicroMsg.AppBrandAuthorizeDialog", "stev acceptButton click!");
        localObject = new Bundle();
        ((Bundle)localObject).putSerializable("key_scope", paramAnonymousView);
        parama.j(1, (Bundle)localObject);
        locali.dismiss();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/widget/WebAuthorizeDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(151595);
      }
    });
    ((Button)localLinearLayout.findViewById(2131301580)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(151596);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/widget/WebAuthorizeDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        paramAnonymousView = new ArrayList();
        int i = 0;
        while (i < paramLinkedList.size())
        {
          if ((((cxm)paramLinkedList.get(i)).HoV == 2) || (((cxm)paramLinkedList.get(i)).HoV == 3)) {
            paramAnonymousView.add(((cxm)paramLinkedList.get(i)).FKf);
          }
          i += 1;
        }
        ad.d("MicroMsg.AppBrandAuthorizeDialog", "stev rejectButton click!");
        localObject = new Bundle();
        ((Bundle)localObject).putSerializable("key_scope", paramAnonymousView);
        parama.j(2, (Bundle)localObject);
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
        if (r.this.naX != null) {
          r.this.naX.setAdapter(null);
        }
        AppMethodBeat.o(151597);
      }
    });
    locali.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(151598);
        ad.d("MicroMsg.AppBrandAuthorizeDialog", "stev dialog onCancel");
        parama.j(3, null);
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
      ad.e("MicroMsg.AppBrandAuthorizeDialog", "dialog show failed %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(151606);
    }
    return false;
  }
  
  public final boolean a(LinkedList<cxm> paramLinkedList, String paramString1, String paramString2, a parama)
  {
    AppMethodBeat.i(151605);
    boolean bool = a(paramLinkedList, paramString1, paramString2, null, parama);
    AppMethodBeat.o(151605);
    return bool;
  }
  
  public final boolean a(LinkedList<cxm> paramLinkedList, String paramString1, String paramString2, String paramString3, a parama)
  {
    AppMethodBeat.i(151604);
    ad.d("MicroMsg.AppBrandAuthorizeDialog", "stev AppBrandAuthorizeDialog showAlert!");
    this.mAppName = paramString1;
    this.kyo = paramString2;
    boolean bool = a(paramString3, paramLinkedList, parama);
    AppMethodBeat.o(151604);
    return bool;
  }
  
  public static abstract interface a
  {
    public abstract void j(int paramInt, Bundle paramBundle);
  }
  
  final class b
    extends BaseAdapter
  {
    private LinkedList<cxm> Est;
    
    public b()
    {
      Object localObject;
      this.Est = localObject;
    }
    
    private cxm XU(int paramInt)
    {
      AppMethodBeat.i(151601);
      cxm localcxm = (cxm)this.Est.get(paramInt);
      AppMethodBeat.o(151601);
      return localcxm;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(151600);
      if (this.Est == null)
      {
        AppMethodBeat.o(151600);
        return 0;
      }
      int i = this.Est.size();
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
      if ((this.Est == null) || (this.Est.size() <= 0))
      {
        AppMethodBeat.o(151602);
        return null;
      }
      final cxm localcxm = XU(paramInt);
      Object localObject;
      if (paramView == null)
      {
        paramView = new a((byte)0);
        localObject = View.inflate(paramViewGroup.getContext(), 2131493120, null);
        paramView.DZP = ((ImageView)((View)localObject).findViewById(2131296682));
        paramView.nbj = ((TextView)((View)localObject).findViewById(2131296681));
        ((View)localObject).setTag(paramView);
        paramViewGroup = paramView;
        paramView = (View)localObject;
        if (localcxm.HoV != 1) {
          break label174;
        }
        paramViewGroup.DZP.setImageResource(2131690740);
      }
      for (;;)
      {
        paramViewGroup.nbj.setText(localcxm.Desc);
        localObject = paramViewGroup.DZP;
        paramViewGroup.DZP.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(151599);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/widget/WebAuthorizeDialog$LoginAuthListAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            if (localcxm.HoV == 2)
            {
              this.DZN.setImageResource(2131690740);
              localcxm.HoV = 1;
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/widget/WebAuthorizeDialog$LoginAuthListAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(151599);
              return;
              if (localcxm.HoV == 1)
              {
                this.DZN.setImageResource(2131690738);
                localcxm.HoV = 2;
              }
            }
          }
        });
        AppMethodBeat.o(151602);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label174:
        if (localcxm.HoV == 3) {
          paramViewGroup.DZP.setImageResource(2131690739);
        } else {
          paramViewGroup.DZP.setImageResource(2131690738);
        }
      }
    }
    
    final class a
    {
      ImageView DZP;
      TextView nbj;
      
      private a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.r
 * JD-Core Version:    0.7.0.1
 */