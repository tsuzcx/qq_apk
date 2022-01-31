package com.tencent.mm.plugin.readerapp.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.model.bk;
import com.tencent.mm.plugin.readerapp.a.b;
import com.tencent.mm.plugin.readerapp.a.c;
import com.tencent.mm.plugin.readerapp.a.d;
import com.tencent.mm.plugin.readerapp.a.e;
import com.tencent.mm.plugin.readerapp.c.g;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.pluginsdk.ui.e;
import com.tencent.mm.ui.base.n.d;

@Deprecated
final class ReaderAppUI$c
  extends a<String>
{
  private Context context;
  private int dsw;
  private int ieK;
  private int iwi;
  private int noX;
  
  public ReaderAppUI$c(ReaderAppUI paramReaderAppUI, Context paramContext, String paramString)
  {
    super(paramContext, paramString);
    this.context = paramContext;
    this.iwi = 3;
    this.dsw = this.iwi;
    this.noX = paramContext.getResources().getDimensionPixelSize(a.b.BasicPaddingSize);
    this.ieK = paramContext.getResources().getDimensionPixelSize(a.b.SmallPadding);
  }
  
  public final boolean aCc()
  {
    return this.iwi >= this.dsw;
  }
  
  public final int aCd()
  {
    if (aCc()) {
      return 0;
    }
    this.iwi += 3;
    if (this.iwi <= this.dsw) {
      return 3;
    }
    this.iwi = this.dsw;
    return this.dsw % 3;
  }
  
  public final int getShowCount()
  {
    return this.iwi;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramViewGroup = new ReaderAppUI.c.a(this);
      paramView = View.inflate(this.context, a.e.reader_app_root_item, null);
      paramViewGroup.nph = ((ReaderItemListView)paramView.findViewById(a.d.reader_root_item_list));
      paramViewGroup.kZl = ((TextView)paramView.findViewById(a.d.reader_app_item_time_tv));
      paramView.setTag(paramViewGroup);
      getItem(paramInt);
      paramViewGroup.kZl.setText(h.c(this.context, 0L, false));
      ReaderItemListView localReaderItemListView = paramViewGroup.nph;
      String str = (String)getItem(paramInt);
      View.OnCreateContextMenuListener localOnCreateContextMenuListener = ReaderAppUI.a(this.noS, false);
      n.d locald = ReaderAppUI.g(this.noS);
      localReaderItemListView.position = paramInt;
      localReaderItemListView.npl = localOnCreateContextMenuListener;
      localReaderItemListView.ifj = locald;
      localReaderItemListView.npj = g.buZ().J(str, localReaderItemListView.type);
      localReaderItemListView.npk.notifyDataSetChanged();
      if (ReaderAppUI.h(this.noS) != null)
      {
        paramViewGroup.kZl.setTextColor(ReaderAppUI.h(this.noS).rZj);
        if (!ReaderAppUI.h(this.noS).rZk) {
          break label282;
        }
        paramViewGroup.kZl.setShadowLayer(2.0F, 1.2F, 1.2F, ReaderAppUI.h(this.noS).rZl);
      }
    }
    for (;;)
    {
      if (!ReaderAppUI.h(this.noS).rZm) {
        break label296;
      }
      paramViewGroup.kZl.setBackgroundResource(a.c.chat_tips_bg);
      paramViewGroup.kZl.setPadding(this.ieK, this.noX, this.ieK, this.noX);
      return paramView;
      paramViewGroup = (ReaderAppUI.c.a)paramView.getTag();
      break;
      label282:
      paramViewGroup.kZl.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    }
    label296:
    paramViewGroup.kZl.setBackgroundColor(0);
    return paramView;
  }
  
  public final void yc()
  {
    this.dsw = g.buZ().hU(ReaderAppUI.a(this.noS));
    setCursor(g.buZ().bj(this.iwi, ReaderAppUI.a(this.noS)));
    super.notifyDataSetChanged();
  }
  
  protected final void yd()
  {
    yc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.ui.ReaderAppUI.c
 * JD-Core Version:    0.7.0.1
 */