package com.tencent.mm.plugin.readerapp.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bl;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;
import junit.framework.Assert;

final class ReaderItemListView$a
  extends BaseAdapter
{
  ReaderItemListView$a(ReaderItemListView paramReaderItemListView) {}
  
  public final int getCount()
  {
    AppMethodBeat.i(76859);
    int i = ReaderItemListView.a(this.pUB).size();
    AppMethodBeat.o(76859);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(76860);
    Object localObject = ReaderItemListView.a(this.pUB).get(paramInt);
    AppMethodBeat.o(76860);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(76861);
    if (((bl)ReaderItemListView.a(this.pUB).get(paramInt)).type == 20)
    {
      if (paramInt == 0)
      {
        String str1 = ((bl)ReaderItemListView.a(this.pUB).get(paramInt)).aaZ();
        String str2 = ((bl)ReaderItemListView.a(this.pUB).get(paramInt)).getDigest();
        if (bo.isNullOrNil(str1))
        {
          if (bo.isNullOrNil(str2))
          {
            AppMethodBeat.o(76861);
            return 1;
          }
          AppMethodBeat.o(76861);
          return 2;
        }
        if (bo.isNullOrNil(str2))
        {
          AppMethodBeat.o(76861);
          return 3;
        }
        AppMethodBeat.o(76861);
        return 0;
      }
      AppMethodBeat.o(76861);
      return 1;
    }
    if (paramInt == 0)
    {
      if (getCount() == 1)
      {
        AppMethodBeat.o(76861);
        return 8;
      }
      AppMethodBeat.o(76861);
      return 6;
    }
    if (paramInt == getCount() - 1)
    {
      AppMethodBeat.o(76861);
      return 7;
    }
    AppMethodBeat.o(76861);
    return 5;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = null;
    AppMethodBeat.i(76862);
    int i = getItemViewType(paramInt);
    boolean bool;
    if (paramView == null) {
      switch (i)
      {
      default: 
        if (paramViewGroup != null)
        {
          bool = true;
          label79:
          Assert.assertTrue(bool);
          if (paramViewGroup.gui == null) {
            break label1204;
          }
          bool = true;
          label94:
          Assert.assertTrue(bool);
          paramViewGroup.gui.setText(((bl)ReaderItemListView.a(this.pUB).get(paramInt)).getTitle().trim());
          if (paramViewGroup.pUE != null) {
            paramViewGroup.pUE.setText(((bl)ReaderItemListView.a(this.pUB).get(paramInt)).getDigest().trim());
          }
          if (paramViewGroup.nwS != null) {
            paramViewGroup.nwS.setText(((bl)ReaderItemListView.a(this.pUB).get(paramInt)).aaX().trim() + this.pUB.getContext().getString(2131302301));
          }
          Bitmap localBitmap;
          if (paramViewGroup.iTH != null)
          {
            localBitmap = x.a(new p(((bl)ReaderItemListView.a(this.pUB).get(paramInt)).aaY(), ((bl)ReaderItemListView.a(this.pUB).get(paramInt)).type, "@S"));
            if (localBitmap == null) {
              break label1210;
            }
            paramViewGroup.iTH.setImageBitmap(localBitmap);
            paramViewGroup.iTH.setVisibility(0);
            paramViewGroup.pUF.setVisibility(8);
          }
          label318:
          if (paramViewGroup.jXx != null)
          {
            localBitmap = x.a(new p(((bl)ReaderItemListView.a(this.pUB).get(paramInt)).aaZ(), ((bl)ReaderItemListView.a(this.pUB).get(paramInt)).type, "@T"));
            if (localBitmap == null) {
              break label1230;
            }
            paramViewGroup.jXx.setImageBitmap(localBitmap);
            paramViewGroup.jXx.setVisibility(0);
            paramViewGroup.progressBar.setVisibility(8);
          }
        }
        break;
      }
    }
    for (;;)
    {
      if ((paramViewGroup.jXW != null) && (ReaderItemListView.c(this.pUB) != null))
      {
        paramViewGroup.jXW.setTag(Integer.valueOf(ReaderItemListView.d(this.pUB)));
        paramViewGroup.jXW.setOnLongClickListener(new ReaderItemListView.a.1(this));
        paramViewGroup.jXW.setOnClickListener(new ReaderItemListView.a.2(this, paramInt));
      }
      AppMethodBeat.o(76862);
      return paramView;
      paramViewGroup = new ReaderItemListView.a.a(this);
      paramView = ReaderItemListView.b(this.pUB).inflate(2130970507, null);
      paramViewGroup.gui = ((TextView)paramView.findViewById(2131827030));
      paramView.setTag(paramViewGroup);
      break;
      paramViewGroup = new ReaderItemListView.a.a(this);
      paramView = ReaderItemListView.b(this.pUB).inflate(2130970504, null);
      paramViewGroup.gui = ((TextView)paramView.findViewById(2131827019));
      paramViewGroup.pUE = ((TextView)paramView.findViewById(2131827020));
      paramView.setTag(paramViewGroup);
      break;
      paramViewGroup = new ReaderItemListView.a.a(this);
      paramView = ReaderItemListView.b(this.pUB).inflate(2130970503, null);
      paramViewGroup.gui = ((TextView)paramView.findViewById(2131827019));
      paramViewGroup.jXx = ((ImageView)paramView.findViewById(2131827017));
      paramViewGroup.progressBar = ((ProgressBar)paramView.findViewById(2131827018));
      paramView.setTag(paramViewGroup);
      break;
      paramViewGroup = new ReaderItemListView.a.a(this);
      paramView = ReaderItemListView.b(this.pUB).inflate(2130970510, null);
      paramViewGroup.gui = ((TextView)paramView.findViewById(2131827019));
      paramViewGroup.jXx = ((ImageView)paramView.findViewById(2131827017));
      paramViewGroup.progressBar = ((ProgressBar)paramView.findViewById(2131827018));
      paramViewGroup.nwS = ((TextView)paramView.findViewById(2131827040));
      paramViewGroup.iTH = ((ImageView)paramView.findViewById(2131827038));
      paramViewGroup.pUF = ((ProgressBar)paramView.findViewById(2131827039));
      paramViewGroup.jXW = paramView.findViewById(2131827037);
      paramViewGroup.jXW.setBackgroundResource(2130838336);
      paramView.setTag(paramViewGroup);
      break;
      paramViewGroup = new ReaderItemListView.a.a(this);
      paramView = ReaderItemListView.b(this.pUB).inflate(2130970511, null);
      paramViewGroup.gui = ((TextView)paramView.findViewById(2131827019));
      paramViewGroup.nwS = ((TextView)paramView.findViewById(2131827040));
      paramViewGroup.iTH = ((ImageView)paramView.findViewById(2131827038));
      paramViewGroup.pUF = ((ProgressBar)paramView.findViewById(2131827039));
      paramViewGroup.jXW = paramView.findViewById(2131827037);
      paramViewGroup.jXW.setBackgroundResource(2130838335);
      paramView.setTag(paramViewGroup);
      break;
      paramViewGroup = new ReaderItemListView.a.a(this);
      paramView = ReaderItemListView.b(this.pUB).inflate(2130970513, null);
      paramViewGroup.gui = ((TextView)paramView.findViewById(2131827019));
      paramViewGroup.nwS = ((TextView)paramView.findViewById(2131827040));
      paramViewGroup.iTH = ((ImageView)paramView.findViewById(2131827038));
      paramViewGroup.pUF = ((ProgressBar)paramView.findViewById(2131827039));
      paramViewGroup.jXW = paramView.findViewById(2131827037);
      paramViewGroup.jXW.setBackgroundResource(2130838336);
      paramView.setTag(paramViewGroup);
      break;
      paramViewGroup = new ReaderItemListView.a.a(this);
      paramView = ReaderItemListView.b(this.pUB).inflate(2130970511, null);
      paramViewGroup.gui = ((TextView)paramView.findViewById(2131827019));
      paramViewGroup.nwS = ((TextView)paramView.findViewById(2131827040));
      paramViewGroup.iTH = ((ImageView)paramView.findViewById(2131827038));
      paramViewGroup.pUF = ((ProgressBar)paramView.findViewById(2131827039));
      paramViewGroup.jXW = paramView.findViewById(2131827037);
      paramViewGroup.jXW.setBackgroundResource(2130838337);
      paramView.setTag(paramViewGroup);
      break;
      paramViewGroup = new ReaderItemListView.a.a(this);
      paramView = ReaderItemListView.b(this.pUB).inflate(2130970512, null);
      paramViewGroup.gui = ((TextView)paramView.findViewById(2131827019));
      paramViewGroup.nwS = ((TextView)paramView.findViewById(2131827040));
      paramViewGroup.iTH = ((ImageView)paramView.findViewById(2131827038));
      paramViewGroup.pUF = ((ProgressBar)paramView.findViewById(2131827039));
      paramViewGroup.jXW = paramView.findViewById(2131827037);
      paramViewGroup.jXW.setBackgroundResource(2130838334);
      paramView.setTag(paramViewGroup);
      break;
      paramViewGroup = (ReaderItemListView.a.a)paramView.getTag();
      break;
      bool = false;
      break label79;
      label1204:
      bool = false;
      break label94;
      label1210:
      paramViewGroup.pUF.setVisibility(0);
      paramViewGroup.iTH.setVisibility(8);
      break label318;
      label1230:
      paramViewGroup.progressBar.setVisibility(0);
      paramViewGroup.jXx.setVisibility(8);
    }
  }
  
  public final int getViewTypeCount()
  {
    return 9;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.ui.ReaderItemListView.a
 * JD-Core Version:    0.7.0.1
 */