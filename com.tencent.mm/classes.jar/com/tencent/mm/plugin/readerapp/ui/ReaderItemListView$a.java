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
import com.tencent.mm.model.bj;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.plugin.readerapp.a.c;
import com.tencent.mm.plugin.readerapp.a.d;
import com.tencent.mm.plugin.readerapp.a.e;
import com.tencent.mm.plugin.readerapp.a.g;
import com.tencent.mm.pluginsdk.model.q;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.List;
import junit.framework.Assert;

final class ReaderItemListView$a
  extends BaseAdapter
{
  ReaderItemListView$a(ReaderItemListView paramReaderItemListView) {}
  
  public final int getCount()
  {
    return ReaderItemListView.a(this.npn).size();
  }
  
  public final Object getItem(int paramInt)
  {
    return ReaderItemListView.a(this.npn).get(paramInt);
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final int getItemViewType(int paramInt)
  {
    if (((bj)ReaderItemListView.a(this.npn).get(paramInt)).type == 20)
    {
      if (paramInt == 0)
      {
        String str1 = ((bj)ReaderItemListView.a(this.npn).get(paramInt)).Ia();
        String str2 = ((bj)ReaderItemListView.a(this.npn).get(paramInt)).getDigest();
        if (bk.bl(str1))
        {
          if (bk.bl(str2)) {
            return 1;
          }
          return 2;
        }
        if (bk.bl(str2)) {
          return 3;
        }
        return 0;
      }
      return 1;
    }
    if (paramInt == 0)
    {
      if (getCount() == 1) {
        return 8;
      }
      return 6;
    }
    if (paramInt == getCount() - 1) {
      return 7;
    }
    return 5;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    boolean bool2 = true;
    paramViewGroup = null;
    int i = getItemViewType(paramInt);
    boolean bool1;
    if (paramView == null) {
      switch (i)
      {
      default: 
        if (paramViewGroup != null)
        {
          bool1 = true;
          label75:
          Assert.assertTrue(bool1);
          if (paramViewGroup.fcy == null) {
            break label1243;
          }
          bool1 = bool2;
          label91:
          Assert.assertTrue(bool1);
          paramViewGroup.fcy.setText(((bj)ReaderItemListView.a(this.npn).get(paramInt)).getTitle().trim());
          if (paramViewGroup.npq != null) {
            paramViewGroup.npq.setText(((bj)ReaderItemListView.a(this.npn).get(paramInt)).getDigest().trim());
          }
          if (paramViewGroup.kYV != null) {
            paramViewGroup.kYV.setText(((bj)ReaderItemListView.a(this.npn).get(paramInt)).HY().trim() + this.npn.getContext().getString(a.g.readerapp_share));
          }
          Bitmap localBitmap;
          if (paramViewGroup.hic != null)
          {
            localBitmap = x.a(new q(((bj)ReaderItemListView.a(this.npn).get(paramInt)).HZ(), ((bj)ReaderItemListView.a(this.npn).get(paramInt)).type, "@S"));
            if (localBitmap == null) {
              break label1249;
            }
            paramViewGroup.hic.setImageBitmap(localBitmap);
            paramViewGroup.hic.setVisibility(0);
            paramViewGroup.npr.setVisibility(8);
          }
          label316:
          if (paramViewGroup.ifG != null)
          {
            localBitmap = x.a(new q(((bj)ReaderItemListView.a(this.npn).get(paramInt)).Ia(), ((bj)ReaderItemListView.a(this.npn).get(paramInt)).type, "@T"));
            if (localBitmap == null) {
              break label1269;
            }
            paramViewGroup.ifG.setImageBitmap(localBitmap);
            paramViewGroup.ifG.setVisibility(0);
            paramViewGroup.frw.setVisibility(8);
          }
        }
        break;
      }
    }
    for (;;)
    {
      if ((paramViewGroup.ifK != null) && (ReaderItemListView.c(this.npn) != null))
      {
        paramViewGroup.ifK.setTag(Integer.valueOf(ReaderItemListView.d(this.npn)));
        paramViewGroup.ifK.setOnLongClickListener(new ReaderItemListView.a.1(this));
        paramViewGroup.ifK.setOnClickListener(new ReaderItemListView.a.2(this, paramInt));
      }
      return paramView;
      paramViewGroup = new a();
      paramView = ReaderItemListView.b(this.npn).inflate(a.e.reader_app_item, null);
      paramViewGroup.fcy = ((TextView)paramView.findViewById(a.d.reader_item_title_tv));
      paramView.setTag(paramViewGroup);
      break;
      paramViewGroup = new a();
      paramView = ReaderItemListView.b(this.npn).inflate(a.e.reader_app_first_item_d, null);
      paramViewGroup.fcy = ((TextView)paramView.findViewById(a.d.reader_first_item_title_tv));
      paramViewGroup.npq = ((TextView)paramView.findViewById(a.d.reader_first_item_digest_tv));
      paramView.setTag(paramViewGroup);
      break;
      paramViewGroup = new a();
      paramView = ReaderItemListView.b(this.npn).inflate(a.e.reader_app_first_item_c, null);
      paramViewGroup.fcy = ((TextView)paramView.findViewById(a.d.reader_first_item_title_tv));
      paramViewGroup.ifG = ((ImageView)paramView.findViewById(a.d.reader_first_item_cover_iv));
      paramViewGroup.frw = ((ProgressBar)paramView.findViewById(a.d.reader_first_item_cover_pb));
      paramView.setTag(paramViewGroup);
      break;
      paramViewGroup = new a();
      paramView = ReaderItemListView.b(this.npn).inflate(a.e.reader_app_weibo_first_item_c, null);
      paramViewGroup.fcy = ((TextView)paramView.findViewById(a.d.reader_first_item_title_tv));
      paramViewGroup.ifG = ((ImageView)paramView.findViewById(a.d.reader_first_item_cover_iv));
      paramViewGroup.frw = ((ProgressBar)paramView.findViewById(a.d.reader_first_item_cover_pb));
      paramViewGroup.kYV = ((TextView)paramView.findViewById(a.d.reader_first_item_name_tv));
      paramViewGroup.hic = ((ImageView)paramView.findViewById(a.d.reader_first_item_icon_iv));
      paramViewGroup.npr = ((ProgressBar)paramView.findViewById(a.d.reader_first_item_icon_pb));
      paramViewGroup.ifK = paramView.findViewById(a.d.reader_app_weibo_item_layout);
      paramViewGroup.ifK.setBackgroundResource(a.c.chatting_item_multi_top);
      paramView.setTag(paramViewGroup);
      break;
      paramViewGroup = new a();
      paramView = ReaderItemListView.b(this.npn).inflate(a.e.reader_app_weibo_item, null);
      paramViewGroup.fcy = ((TextView)paramView.findViewById(a.d.reader_first_item_title_tv));
      paramViewGroup.kYV = ((TextView)paramView.findViewById(a.d.reader_first_item_name_tv));
      paramViewGroup.hic = ((ImageView)paramView.findViewById(a.d.reader_first_item_icon_iv));
      paramViewGroup.npr = ((ProgressBar)paramView.findViewById(a.d.reader_first_item_icon_pb));
      paramViewGroup.ifK = paramView.findViewById(a.d.reader_app_weibo_item_layout);
      paramViewGroup.ifK.setBackgroundResource(a.c.chatting_item_multi_middle);
      paramView.setTag(paramViewGroup);
      break;
      paramViewGroup = new a();
      paramView = ReaderItemListView.b(this.npn).inflate(a.e.reader_app_weibo_item_top, null);
      paramViewGroup.fcy = ((TextView)paramView.findViewById(a.d.reader_first_item_title_tv));
      paramViewGroup.kYV = ((TextView)paramView.findViewById(a.d.reader_first_item_name_tv));
      paramViewGroup.hic = ((ImageView)paramView.findViewById(a.d.reader_first_item_icon_iv));
      paramViewGroup.npr = ((ProgressBar)paramView.findViewById(a.d.reader_first_item_icon_pb));
      paramViewGroup.ifK = paramView.findViewById(a.d.reader_app_weibo_item_layout);
      paramViewGroup.ifK.setBackgroundResource(a.c.chatting_item_multi_top);
      paramView.setTag(paramViewGroup);
      break;
      paramViewGroup = new a();
      paramView = ReaderItemListView.b(this.npn).inflate(a.e.reader_app_weibo_item, null);
      paramViewGroup.fcy = ((TextView)paramView.findViewById(a.d.reader_first_item_title_tv));
      paramViewGroup.kYV = ((TextView)paramView.findViewById(a.d.reader_first_item_name_tv));
      paramViewGroup.hic = ((ImageView)paramView.findViewById(a.d.reader_first_item_icon_iv));
      paramViewGroup.npr = ((ProgressBar)paramView.findViewById(a.d.reader_first_item_icon_pb));
      paramViewGroup.ifK = paramView.findViewById(a.d.reader_app_weibo_item_layout);
      paramViewGroup.ifK.setBackgroundResource(a.c.chatting_item_one_item);
      paramView.setTag(paramViewGroup);
      break;
      paramViewGroup = new a();
      paramView = ReaderItemListView.b(this.npn).inflate(a.e.reader_app_weibo_item_last, null);
      paramViewGroup.fcy = ((TextView)paramView.findViewById(a.d.reader_first_item_title_tv));
      paramViewGroup.kYV = ((TextView)paramView.findViewById(a.d.reader_first_item_name_tv));
      paramViewGroup.hic = ((ImageView)paramView.findViewById(a.d.reader_first_item_icon_iv));
      paramViewGroup.npr = ((ProgressBar)paramView.findViewById(a.d.reader_first_item_icon_pb));
      paramViewGroup.ifK = paramView.findViewById(a.d.reader_app_weibo_item_layout);
      paramViewGroup.ifK.setBackgroundResource(a.c.chatting_item_multi_bottom);
      paramView.setTag(paramViewGroup);
      break;
      paramViewGroup = (a)paramView.getTag();
      break;
      bool1 = false;
      break label75;
      label1243:
      bool1 = false;
      break label91;
      label1249:
      paramViewGroup.npr.setVisibility(0);
      paramViewGroup.hic.setVisibility(8);
      break label316;
      label1269:
      paramViewGroup.frw.setVisibility(0);
      paramViewGroup.ifG.setVisibility(8);
    }
  }
  
  public final int getViewTypeCount()
  {
    return 9;
  }
  
  final class a
  {
    TextView fcy;
    ProgressBar frw;
    ImageView hic;
    ImageView ifG;
    View ifK;
    TextView kYV;
    TextView npq;
    ProgressBar npr;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.ui.ReaderItemListView.a
 * JD-Core Version:    0.7.0.1
 */