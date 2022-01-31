package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Intent;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.ae.i;
import com.tencent.mm.as.a.a;
import com.tencent.mm.as.o;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b.b;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;

public final class NewBizInfoMessagePreference$a$a
  extends RecyclerView.v
  implements View.OnClickListener
{
  public TextView dqa;
  public ImageView heN;
  public ImageView mXR;
  public LinearLayout mZY;
  public b mZZ;
  
  public NewBizInfoMessagePreference$a$a(NewBizInfoMessagePreference.a parama, View paramView)
  {
    super(paramView);
    this.mXR = ((ImageView)paramView.findViewById(R.h.new_bizinfo_message_image));
    this.heN = ((ImageView)paramView.findViewById(R.h.new_bizinfo_message_icon));
    this.dqa = ((TextView)paramView.findViewById(R.h.new_bizinfo_message_text));
    this.mZY = ((LinearLayout)paramView.findViewById(R.h.new_bizinfo_message_container));
    paramView.setOnClickListener(this);
  }
  
  static void f(String paramString, ImageView paramImageView)
  {
    o.ON().a(paramString, paramImageView);
  }
  
  public final void onClick(View paramView)
  {
    y.i("MicroMsg.NewBizInfoMessagePreference", "onClick jump to url:%s", new Object[] { this.mZZ.nah });
    int i = NewBizInfoMessagePreference.a.a(this.naa).getIntent().getIntExtra("KOpenArticleSceneFromScene", -1);
    paramView = new Intent();
    paramView.putExtra("rawUrl", i.g(this.mZZ.nah.replaceAll("(scene=[\\d]*)", ""), 126, i));
    paramView.putExtra("useJs", true);
    paramView.putExtra("vertical_scroll", true);
    paramView.putExtra("geta8key_scene", 3);
    d.b(NewBizInfoMessagePreference.a.a(this.naa), "webview", ".ui.tools.WebViewUI", paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoMessagePreference.a.a
 * JD-Core Version:    0.7.0.1
 */