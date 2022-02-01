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
import com.tencent.mm.compatible.e.a;
import com.tencent.mm.modelappbrand.a.e;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.csf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.AuthorizeItemListView;
import com.tencent.mm.ui.base.i;
import java.util.ArrayList;
import java.util.LinkedList;

public final class r
{
  private b COr;
  private Context context;
  private String kdH;
  AuthorizeItemListView mAp;
  private String mAppName = "";
  private LinearLayout mAr;
  
  public r(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private boolean a(String paramString, final LinkedList<csf> paramLinkedList, final a parama)
  {
    AppMethodBeat.i(151606);
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      ac.e("MicroMsg.AppBrandAuthorizeDialog", "scopeInfoList is empty or null");
      AppMethodBeat.o(151606);
      return false;
    }
    final i locali = new i(this.context, 2131821725);
    LinearLayout localLinearLayout = (LinearLayout)((LayoutInflater)this.context.getSystemService("layout_inflater")).inflate(2131493119, null);
    Object localObject = (TextView)localLinearLayout.findViewById(2131306944);
    if (!bs.isNullOrNil(paramString)) {
      ((TextView)localObject).setText(paramString);
    }
    paramString = (ImageView)localLinearLayout.findViewById(2131296853);
    localObject = a.decodeResource(ai.getResources(), 2131690013);
    localObject = d.a(ai.getResources(), (Bitmap)localObject);
    ((android.support.v4.graphics.drawable.b)localObject).ei();
    if (paramString != null) {
      com.tencent.mm.modelappbrand.a.b.aAS().a(paramString, this.kdH, (Drawable)localObject, new e());
    }
    paramString = (TextView)localLinearLayout.findViewById(2131296866);
    if (this.mAppName == null) {
      this.mAppName = "";
    }
    paramString.setText(k.b(this.context, this.context.getString(2131760748, new Object[] { this.mAppName }), paramString.getTextSize()));
    this.mAp = ((AuthorizeItemListView)localLinearLayout.findViewById(2131296973));
    this.COr = new b(paramLinkedList);
    this.mAp.setAdapter(this.COr);
    if (paramLinkedList.size() > 5)
    {
      this.mAp.ahX = paramLinkedList.size();
      this.mAr = ((LinearLayout)localLinearLayout.findViewById(2131296983));
      paramString = (LinearLayout.LayoutParams)this.mAr.getLayoutParams();
      paramString.height = this.context.getResources().getDimensionPixelSize(2131166486);
      this.mAr.setLayoutParams(paramString);
    }
    ((Button)localLinearLayout.findViewById(2131301557)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(151595);
        paramAnonymousView = new ArrayList();
        int i = 0;
        while (i < paramLinkedList.size())
        {
          if ((((csf)paramLinkedList.get(i)).FEG == 2) || (((csf)paramLinkedList.get(i)).FEG == 3)) {
            paramAnonymousView.add(((csf)paramLinkedList.get(i)).EdG);
          }
          i += 1;
        }
        ac.d("MicroMsg.AppBrandAuthorizeDialog", "stev acceptButton click!");
        Bundle localBundle = new Bundle();
        localBundle.putSerializable("key_scope", paramAnonymousView);
        parama.j(1, localBundle);
        locali.dismiss();
        AppMethodBeat.o(151595);
      }
    });
    ((Button)localLinearLayout.findViewById(2131301580)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(151596);
        paramAnonymousView = new ArrayList();
        int i = 0;
        while (i < paramLinkedList.size())
        {
          if ((((csf)paramLinkedList.get(i)).FEG == 2) || (((csf)paramLinkedList.get(i)).FEG == 3)) {
            paramAnonymousView.add(((csf)paramLinkedList.get(i)).EdG);
          }
          i += 1;
        }
        ac.d("MicroMsg.AppBrandAuthorizeDialog", "stev rejectButton click!");
        Bundle localBundle = new Bundle();
        localBundle.putSerializable("key_scope", paramAnonymousView);
        parama.j(2, localBundle);
        locali.dismiss();
        AppMethodBeat.o(151596);
      }
    });
    locali.setCanceledOnTouchOutside(false);
    locali.setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(151597);
        if (r.this.mAp != null) {
          r.this.mAp.setAdapter(null);
        }
        AppMethodBeat.o(151597);
      }
    });
    locali.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(151598);
        ac.d("MicroMsg.AppBrandAuthorizeDialog", "stev dialog onCancel");
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
      ac.e("MicroMsg.AppBrandAuthorizeDialog", "dialog show failed %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(151606);
    }
    return false;
  }
  
  public final boolean a(LinkedList<csf> paramLinkedList, String paramString1, String paramString2, a parama)
  {
    AppMethodBeat.i(151605);
    boolean bool = a(paramLinkedList, paramString1, paramString2, null, parama);
    AppMethodBeat.o(151605);
    return bool;
  }
  
  public final boolean a(LinkedList<csf> paramLinkedList, String paramString1, String paramString2, String paramString3, a parama)
  {
    AppMethodBeat.i(151604);
    ac.d("MicroMsg.AppBrandAuthorizeDialog", "stev AppBrandAuthorizeDialog showAlert!");
    this.mAppName = paramString1;
    this.kdH = paramString2;
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
    private LinkedList<csf> COt;
    
    public b()
    {
      Object localObject;
      this.COt = localObject;
    }
    
    private csf Wd(int paramInt)
    {
      AppMethodBeat.i(151601);
      csf localcsf = (csf)this.COt.get(paramInt);
      AppMethodBeat.o(151601);
      return localcsf;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(151600);
      if (this.COt == null)
      {
        AppMethodBeat.o(151600);
        return 0;
      }
      int i = this.COt.size();
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
      if ((this.COt == null) || (this.COt.size() <= 0))
      {
        AppMethodBeat.o(151602);
        return null;
      }
      final csf localcsf = Wd(paramInt);
      Object localObject;
      if (paramView == null)
      {
        paramView = new a((byte)0);
        localObject = View.inflate(paramViewGroup.getContext(), 2131493120, null);
        paramView.Cwh = ((ImageView)((View)localObject).findViewById(2131296682));
        paramView.mAB = ((TextView)((View)localObject).findViewById(2131296681));
        ((View)localObject).setTag(paramView);
        paramViewGroup = paramView;
        paramView = (View)localObject;
        if (localcsf.FEG != 1) {
          break label174;
        }
        paramViewGroup.Cwh.setImageResource(2131690740);
      }
      for (;;)
      {
        paramViewGroup.mAB.setText(localcsf.Desc);
        localObject = paramViewGroup.Cwh;
        paramViewGroup.Cwh.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(151599);
            if (localcsf.FEG == 2)
            {
              this.Cwf.setImageResource(2131690740);
              localcsf.FEG = 1;
              AppMethodBeat.o(151599);
              return;
            }
            if (localcsf.FEG == 1)
            {
              this.Cwf.setImageResource(2131690738);
              localcsf.FEG = 2;
            }
            AppMethodBeat.o(151599);
          }
        });
        AppMethodBeat.o(151602);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label174:
        if (localcsf.FEG == 3) {
          paramViewGroup.Cwh.setImageResource(2131690739);
        } else {
          paramViewGroup.Cwh.setImageResource(2131690738);
        }
      }
    }
    
    final class a
    {
      ImageView Cwh;
      TextView mAB;
      
      private a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.r
 * JD-Core Version:    0.7.0.1
 */