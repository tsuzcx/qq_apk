package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.a.a.d;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.R.m;
import com.tencent.mm.compatible.g.a;
import com.tencent.mm.modelappbrand.a.f;
import com.tencent.mm.protocal.c.bna;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.AuthorizeItemListView;
import com.tencent.mm.ui.base.i;
import java.util.ArrayList;
import java.util.LinkedList;

public final class n
{
  private Context context;
  private String fXS;
  AuthorizeItemListView fXT;
  private LinearLayout fXV;
  private String mAppName = "";
  private n.b rCR;
  
  public n(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private boolean a(String paramString, final LinkedList<bna> paramLinkedList, final n.a parama)
  {
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      y.e("MicroMsg.AppBrandAuthorizeDialog", "scopeInfoList is empty or null");
      return false;
    }
    final i locali = new i(this.context, R.m.mmcustomdialog);
    LinearLayout localLinearLayout = (LinearLayout)((LayoutInflater)this.context.getSystemService("layout_inflater")).inflate(R.i.authorize_dialog_view, null);
    Object localObject = (TextView)localLinearLayout.findViewById(R.h.wechat_auth);
    if (!bk.bl(paramString)) {
      ((TextView)localObject).setText(paramString);
    }
    paramString = (ImageView)localLinearLayout.findViewById(R.h.app_icon_iv);
    localObject = a.decodeResource(ae.getResources(), R.k.default_avatar);
    localObject = d.a(ae.getResources(), (Bitmap)localObject);
    ((android.support.v4.a.a.b)localObject).cp();
    if (paramString != null) {
      com.tencent.mm.modelappbrand.a.b.JD().a(paramString, this.fXS, (Drawable)localObject, f.eaL);
    }
    paramString = (TextView)localLinearLayout.findViewById(R.h.app_name_tv);
    if (this.mAppName == null) {
      this.mAppName = "";
    }
    paramString.setText(this.context.getString(R.l.login_auth_request_tips, new Object[] { this.mAppName }));
    this.fXT = ((AuthorizeItemListView)localLinearLayout.findViewById(R.h.auth_content_list));
    this.rCR = new n.b(this, paramLinkedList);
    this.fXT.setAdapter(this.rCR);
    if (paramLinkedList.size() > 5)
    {
      this.fXT.Zn = paramLinkedList.size();
      this.fXV = ((LinearLayout)localLinearLayout.findViewById(R.h.auth_scope_list_layout));
      paramString = (LinearLayout.LayoutParams)this.fXV.getLayoutParams();
      paramString.height = this.context.getResources().getDimensionPixelSize(R.f.login_desc_list_height);
      this.fXV.setLayoutParams(paramString);
    }
    ((Button)localLinearLayout.findViewById(R.h.login_accept)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new ArrayList();
        int i = 0;
        while (i < paramLinkedList.size())
        {
          if ((((bna)paramLinkedList.get(i)).tGf == 2) || (((bna)paramLinkedList.get(i)).tGf == 3)) {
            paramAnonymousView.add(((bna)paramLinkedList.get(i)).sEi);
          }
          i += 1;
        }
        y.d("MicroMsg.AppBrandAuthorizeDialog", "stev acceptButton click!");
        Bundle localBundle = new Bundle();
        localBundle.putSerializable("key_scope", paramAnonymousView);
        parama.e(1, localBundle);
        locali.dismiss();
      }
    });
    ((Button)localLinearLayout.findViewById(R.h.login_reject)).setOnClickListener(new n.2(this, paramLinkedList, parama, locali));
    locali.setCanceledOnTouchOutside(false);
    locali.setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        if (n.this.fXT != null) {
          n.this.fXT.setAdapter(null);
        }
      }
    });
    locali.setOnCancelListener(new n.4(this, parama));
    locali.setContentView(localLinearLayout);
    try
    {
      locali.show();
      return true;
    }
    catch (Exception paramString)
    {
      y.e("MicroMsg.AppBrandAuthorizeDialog", "dialog show failed %s", new Object[] { paramString.getMessage() });
    }
    return false;
  }
  
  public final boolean a(LinkedList<bna> paramLinkedList, String paramString1, String paramString2, n.a parama)
  {
    return a(paramLinkedList, paramString1, paramString2, null, parama);
  }
  
  public final boolean a(LinkedList<bna> paramLinkedList, String paramString1, String paramString2, String paramString3, n.a parama)
  {
    y.d("MicroMsg.AppBrandAuthorizeDialog", "stev AppBrandAuthorizeDialog showAlert!");
    this.mAppName = paramString1;
    this.fXS = paramString2;
    return a(paramString3, paramLinkedList, parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.n
 * JD-Core Version:    0.7.0.1
 */