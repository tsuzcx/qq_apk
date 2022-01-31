package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.as.a.a;
import com.tencent.mm.as.a.a.c;
import com.tencent.mm.as.a.a.c.a;
import com.tencent.mm.as.o;
import com.tencent.mm.kernel.e;
import com.tencent.mm.openim.a.b;
import com.tencent.mm.openim.a.b.a;
import com.tencent.mm.ui.base.MaskLayout;

public final class v
  extends LinearLayout
{
  private Context context;
  private String vMR;
  
  public v(Context paramContext, String paramString)
  {
    super(paramContext);
    this.context = paramContext;
    this.vMR = paramString;
    paramContext = View.inflate(getContext(), R.i.openim_item_in_addressui_header, this);
    paramString = findViewById(R.h.enterprise_biz_item_ll);
    paramContext.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        paramAnonymousView = paramAnonymousView.getContext();
        Intent localIntent = new Intent(paramAnonymousView, OpenIMAddressUI.class);
        localIntent.addFlags(67108864);
        localIntent.putExtra("key_openim_acctype_id", v.a(v.this));
        paramAnonymousView.startActivity(localIntent);
      }
    });
    paramString.setOnTouchListener(new v.2(this));
    paramString = (MaskLayout)paramString.findViewById(R.h.biz_contact_entrance_avatar_iv);
    paramContext = ((b)com.tencent.mm.kernel.g.r(b.class)).b(this.vMR, "openim_acct_type_icon", b.a.ePJ);
    if (paramContext != null)
    {
      paramString = (ImageView)paramString.getContentView();
      Object localObject = new c.a();
      ((c.a)localObject).erf = true;
      StringBuilder localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.g.DQ();
      ((c.a)localObject).erh = (com.tencent.mm.kernel.g.DP().dKt + "openim/" + com.tencent.mm.a.g.o(paramContext.getBytes()));
      localObject = ((c.a)localObject).OV();
      o.ON().a(paramContext, paramString, (c)localObject, null, null);
    }
    paramContext = ((b)com.tencent.mm.kernel.g.r(b.class)).b(this.vMR, "openim_acct_type_title", b.a.ePI);
    ((TextView)findViewById(R.h.enterprise_biz_title)).setText(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.contact.v
 * JD-Core Version:    0.7.0.1
 */