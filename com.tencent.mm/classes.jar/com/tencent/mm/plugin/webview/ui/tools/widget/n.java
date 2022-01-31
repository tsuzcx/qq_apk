package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.graphics.drawable.d;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.g.a;
import com.tencent.mm.modelappbrand.a.f;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.protobuf.bwv;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.AuthorizeItemListView;
import com.tencent.mm.ui.base.i;
import java.util.ArrayList;
import java.util.LinkedList;

public final class n
{
  private Context context;
  private String hDB;
  AuthorizeItemListView jiY;
  private LinearLayout jja;
  private String mAppName = "";
  private n.b vtd;
  
  public n(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private boolean a(String paramString, final LinkedList<bwv> paramLinkedList, final n.a parama)
  {
    AppMethodBeat.i(79185);
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      ab.e("MicroMsg.AppBrandAuthorizeDialog", "scopeInfoList is empty or null");
      AppMethodBeat.o(79185);
      return false;
    }
    final i locali = new i(this.context, 2131493883);
    LinearLayout localLinearLayout = (LinearLayout)((LayoutInflater)this.context.getSystemService("layout_inflater")).inflate(2130968790, null);
    Object localObject = (TextView)localLinearLayout.findViewById(2131821154);
    if (!bo.isNullOrNil(paramString)) {
      ((TextView)localObject).setText(paramString);
    }
    paramString = (ImageView)localLinearLayout.findViewById(2131821155);
    localObject = a.decodeResource(ah.getResources(), 2131231207);
    localObject = d.a(ah.getResources(), (Bitmap)localObject);
    ((android.support.v4.graphics.drawable.b)localObject).cS();
    if (paramString != null) {
      com.tencent.mm.modelappbrand.a.b.acD().a(paramString, this.hDB, (Drawable)localObject, f.fqU);
    }
    paramString = (TextView)localLinearLayout.findViewById(2131821156);
    if (this.mAppName == null) {
      this.mAppName = "";
    }
    paramString.setText(j.b(this.context, this.context.getString(2131301119, new Object[] { this.mAppName }), paramString.getTextSize()));
    this.jiY = ((AuthorizeItemListView)localLinearLayout.findViewById(2131821158));
    this.vtd = new n.b(this, paramLinkedList);
    this.jiY.setAdapter(this.vtd);
    if (paramLinkedList.size() > 5)
    {
      this.jiY.ZY = paramLinkedList.size();
      this.jja = ((LinearLayout)localLinearLayout.findViewById(2131821157));
      paramString = (LinearLayout.LayoutParams)this.jja.getLayoutParams();
      paramString.height = this.context.getResources().getDimensionPixelSize(2131428498);
      this.jja.setLayoutParams(paramString);
    }
    ((Button)localLinearLayout.findViewById(2131821161)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(79174);
        paramAnonymousView = new ArrayList();
        int i = 0;
        while (i < paramLinkedList.size())
        {
          if ((((bwv)paramLinkedList.get(i)).xJY == 2) || (((bwv)paramLinkedList.get(i)).xJY == 3)) {
            paramAnonymousView.add(((bwv)paramLinkedList.get(i)).wAh);
          }
          i += 1;
        }
        ab.d("MicroMsg.AppBrandAuthorizeDialog", "stev acceptButton click!");
        Bundle localBundle = new Bundle();
        localBundle.putSerializable("key_scope", paramAnonymousView);
        parama.h(1, localBundle);
        locali.dismiss();
        AppMethodBeat.o(79174);
      }
    });
    ((Button)localLinearLayout.findViewById(2131821160)).setOnClickListener(new n.2(this, paramLinkedList, parama, locali));
    locali.setCanceledOnTouchOutside(false);
    locali.setOnDismissListener(new n.3(this));
    locali.setOnCancelListener(new n.4(this, parama));
    locali.setContentView(localLinearLayout);
    try
    {
      locali.show();
      AppMethodBeat.o(79185);
      return true;
    }
    catch (Exception paramString)
    {
      ab.e("MicroMsg.AppBrandAuthorizeDialog", "dialog show failed %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(79185);
    }
    return false;
  }
  
  public final boolean a(LinkedList<bwv> paramLinkedList, String paramString1, String paramString2, n.a parama)
  {
    AppMethodBeat.i(79184);
    boolean bool = a(paramLinkedList, paramString1, paramString2, null, parama);
    AppMethodBeat.o(79184);
    return bool;
  }
  
  public final boolean a(LinkedList<bwv> paramLinkedList, String paramString1, String paramString2, String paramString3, n.a parama)
  {
    AppMethodBeat.i(79183);
    ab.d("MicroMsg.AppBrandAuthorizeDialog", "stev AppBrandAuthorizeDialog showAlert!");
    this.mAppName = paramString1;
    this.hDB = paramString2;
    boolean bool = a(paramString3, paramLinkedList, parama);
    AppMethodBeat.o(79183);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.n
 * JD-Core Version:    0.7.0.1
 */