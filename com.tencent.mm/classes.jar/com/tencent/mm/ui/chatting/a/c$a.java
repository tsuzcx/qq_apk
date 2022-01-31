package com.tencent.mm.ui.chatting.a;

import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.sdk.platformtools.bk;

public class c$a
  extends RecyclerView.v
{
  public ImageView doU;
  public TextView dsz;
  public TextView eXO;
  public TextView fhD;
  public View kKz;
  
  public c$a(View paramView)
  {
    super(paramView);
    this.kKz = paramView;
    this.doU = ((ImageView)paramView.findViewById(R.h.fav_avatar));
    this.fhD = ((TextView)paramView.findViewById(R.h.fav_name));
    this.dsz = ((TextView)paramView.findViewById(R.h.fav_time));
    this.eXO = ((TextView)paramView.findViewById(R.h.fav_title));
    this.eXO.setSingleLine(false);
    this.eXO.setMaxLines(2);
    paramView.setOnClickListener(new c.a.1(this));
    paramView.setOnLongClickListener(new c.a.2(this));
  }
  
  public static void e(TextView paramTextView, String paramString)
  {
    if (!bk.bl(paramString))
    {
      paramTextView.getContext();
      paramTextView.setText(f.a(paramTextView.getText(), paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.a.c.a
 * JD-Core Version:    0.7.0.1
 */