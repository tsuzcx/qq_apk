package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.t;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.ui.r;

final class SnsTagPartlyUI$a
  extends r<t>
{
  private Context context;
  public boolean pdW = false;
  
  public SnsTagPartlyUI$a(SnsTagPartlyUI paramSnsTagPartlyUI, Context paramContext)
  {
    super(paramContext, new t());
    this.context = paramContext;
  }
  
  protected final int bam()
  {
    return 1;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramView == null)
    {
      paramViewGroup = new SnsTagPartlyUI.a.a(this);
      paramView = View.inflate(this.context, i.g.partly_item_view, null);
      paramViewGroup.pdX = ((TextView)paramView.findViewById(i.f.tag_name));
      paramViewGroup.pdY = ((TextView)paramView.findViewById(i.f.sns_tag_count));
      paramViewGroup.fks = ((Button)paramView.findViewById(i.f.del_btn));
      paramView.setTag(paramViewGroup);
      if (sk(paramInt)) {
        break label223;
      }
      localObject = (t)getItem(paramInt);
      paramViewGroup.pdX.setText(((t)localObject).field_tagName);
      paramViewGroup.pdY.setVisibility(0);
      paramViewGroup.pdY.setText(" (" + ((t)localObject).field_count + ") ");
      localObject = paramViewGroup.fks;
      if (!this.pdW) {
        break label216;
      }
    }
    label216:
    for (int i = 0;; i = 8)
    {
      ((Button)localObject).setVisibility(i);
      paramViewGroup.fks.setOnClickListener(SnsTagPartlyUI.b(this.pdU));
      paramViewGroup.fks.setTag(Integer.valueOf(paramInt));
      return paramView;
      paramViewGroup = (SnsTagPartlyUI.a.a)paramView.getTag();
      break;
    }
    label223:
    paramViewGroup.pdX.setText(i.j.tag_add_friend);
    paramViewGroup.pdY.setVisibility(8);
    paramViewGroup.fks.setVisibility(8);
    return paramView;
  }
  
  public final void yc()
  {
    setCursor(af.bDL().getCursor());
    notifyDataSetChanged();
  }
  
  protected final void yd()
  {
    bcS();
    yc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTagPartlyUI.a
 * JD-Core Version:    0.7.0.1
 */