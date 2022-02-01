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
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.drb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.AuthorizeItemListView;
import com.tencent.mm.ui.base.i;
import java.util.ArrayList;
import java.util.LinkedList;

public final class r
{
  private b JAw;
  private Context context;
  private String lFU;
  private String mAppName = "";
  AuthorizeItemListView opS;
  private LinearLayout opU;
  
  public r(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private boolean a(String paramString, final LinkedList<drb> paramLinkedList, final a parama)
  {
    AppMethodBeat.i(151606);
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      Log.e("MicroMsg.AppBrandAuthorizeDialog", "scopeInfoList is empty or null");
      AppMethodBeat.o(151606);
      return false;
    }
    final i locali = new i(this.context, 2131821774);
    LinearLayout localLinearLayout = (LinearLayout)((LayoutInflater)this.context.getSystemService("layout_inflater")).inflate(2131493161, null);
    Object localObject = (TextView)localLinearLayout.findViewById(2131310419);
    if (!Util.isNullOrNil(paramString)) {
      ((TextView)localObject).setText(paramString);
    }
    paramString = (ImageView)localLinearLayout.findViewById(2131296945);
    localObject = com.tencent.mm.compatible.f.a.decodeResource(MMApplicationContext.getResources(), 2131690042);
    localObject = d.a(MMApplicationContext.getResources(), (Bitmap)localObject);
    ((android.support.v4.graphics.drawable.b)localObject).eD();
    if (paramString != null) {
      com.tencent.mm.modelappbrand.a.b.aXY().a(paramString, this.lFU, (Drawable)localObject, new e());
    }
    paramString = (TextView)localLinearLayout.findViewById(2131296959);
    if (this.mAppName == null) {
      this.mAppName = "";
    }
    paramString.setText(l.b(this.context, this.context.getString(2131762494, new Object[] { this.mAppName }), paramString.getTextSize()));
    this.opS = ((AuthorizeItemListView)localLinearLayout.findViewById(2131297092));
    this.JAw = new b(paramLinkedList);
    this.opS.setAdapter(this.JAw);
    if (paramLinkedList.size() > 5)
    {
      this.opS.akb = paramLinkedList.size();
      this.opU = ((LinearLayout)localLinearLayout.findViewById(2131297101));
      paramString = (LinearLayout.LayoutParams)this.opU.getLayoutParams();
      paramString.height = this.context.getResources().getDimensionPixelSize(2131166595);
      this.opU.setLayoutParams(paramString);
    }
    ((Button)localLinearLayout.findViewById(2131303775)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(151595);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/widget/WebAuthorizeDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        paramAnonymousView = new ArrayList();
        int i = 0;
        while (i < paramLinkedList.size())
        {
          if ((((drb)paramLinkedList.get(i)).MTI == 2) || (((drb)paramLinkedList.get(i)).MTI == 3)) {
            paramAnonymousView.add(((drb)paramLinkedList.get(i)).KWK);
          }
          i += 1;
        }
        Log.d("MicroMsg.AppBrandAuthorizeDialog", "stev acceptButton click!");
        localObject = new Bundle();
        ((Bundle)localObject).putSerializable("key_scope", paramAnonymousView);
        parama.i(1, (Bundle)localObject);
        locali.dismiss();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/widget/WebAuthorizeDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(151595);
      }
    });
    ((Button)localLinearLayout.findViewById(2131303808)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(151596);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/widget/WebAuthorizeDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        paramAnonymousView = new ArrayList();
        int i = 0;
        while (i < paramLinkedList.size())
        {
          if ((((drb)paramLinkedList.get(i)).MTI == 2) || (((drb)paramLinkedList.get(i)).MTI == 3)) {
            paramAnonymousView.add(((drb)paramLinkedList.get(i)).KWK);
          }
          i += 1;
        }
        Log.d("MicroMsg.AppBrandAuthorizeDialog", "stev rejectButton click!");
        localObject = new Bundle();
        ((Bundle)localObject).putSerializable("key_scope", paramAnonymousView);
        parama.i(2, (Bundle)localObject);
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
        if (r.this.opS != null) {
          r.this.opS.setAdapter(null);
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
        parama.i(3, null);
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
  
  public final boolean a(LinkedList<drb> paramLinkedList, String paramString1, String paramString2, a parama)
  {
    AppMethodBeat.i(151605);
    boolean bool = a(paramLinkedList, paramString1, paramString2, null, parama);
    AppMethodBeat.o(151605);
    return bool;
  }
  
  public final boolean a(LinkedList<drb> paramLinkedList, String paramString1, String paramString2, String paramString3, a parama)
  {
    AppMethodBeat.i(151604);
    Log.d("MicroMsg.AppBrandAuthorizeDialog", "stev AppBrandAuthorizeDialog showAlert!");
    this.mAppName = paramString1;
    this.lFU = paramString2;
    boolean bool = a(paramString3, paramLinkedList, parama);
    AppMethodBeat.o(151604);
    return bool;
  }
  
  public static abstract interface a
  {
    public abstract void i(int paramInt, Bundle paramBundle);
  }
  
  final class b
    extends BaseAdapter
  {
    private LinkedList<drb> JAy;
    
    public b()
    {
      Object localObject;
      this.JAy = localObject;
    }
    
    private drb ahl(int paramInt)
    {
      AppMethodBeat.i(151601);
      drb localdrb = (drb)this.JAy.get(paramInt);
      AppMethodBeat.o(151601);
      return localdrb;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(151600);
      if (this.JAy == null)
      {
        AppMethodBeat.o(151600);
        return 0;
      }
      int i = this.JAy.size();
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
      if ((this.JAy == null) || (this.JAy.size() <= 0))
      {
        AppMethodBeat.o(151602);
        return null;
      }
      final drb localdrb = ahl(paramInt);
      Object localObject;
      if (paramView == null)
      {
        paramView = new a((byte)0);
        localObject = View.inflate(paramViewGroup.getContext(), 2131493162, null);
        paramView.JeY = ((ImageView)((View)localObject).findViewById(2131296771));
        paramView.oqe = ((TextView)((View)localObject).findViewById(2131296770));
        ((View)localObject).setTag(paramView);
        paramViewGroup = paramView;
        paramView = (View)localObject;
        if (localdrb.MTI != 1) {
          break label174;
        }
        paramViewGroup.JeY.setImageResource(2131691023);
      }
      for (;;)
      {
        paramViewGroup.oqe.setText(localdrb.Desc);
        localObject = paramViewGroup.JeY;
        paramViewGroup.JeY.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(151599);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/widget/WebAuthorizeDialog$LoginAuthListAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            if (localdrb.MTI == 2)
            {
              this.JeW.setImageResource(2131691023);
              localdrb.MTI = 1;
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/widget/WebAuthorizeDialog$LoginAuthListAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(151599);
              return;
              if (localdrb.MTI == 1)
              {
                this.JeW.setImageResource(2131691021);
                localdrb.MTI = 2;
              }
            }
          }
        });
        AppMethodBeat.o(151602);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label174:
        if (localdrb.MTI == 3) {
          paramViewGroup.JeY.setImageResource(2131691022);
        } else {
          paramViewGroup.JeY.setImageResource(2131691021);
        }
      }
    }
    
    final class a
    {
      ImageView JeY;
      TextView oqe;
      
      private a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.r
 * JD-Core Version:    0.7.0.1
 */