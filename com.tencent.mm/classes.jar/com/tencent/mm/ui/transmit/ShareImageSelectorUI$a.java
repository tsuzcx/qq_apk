package com.tencent.mm.ui.transmit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.s;

final class ShareImageSelectorUI$a
  extends BaseAdapter
{
  public ShareImageSelectorUI.a.a[] whU = { new ShareImageSelectorUI.a.a(this, R.l.cropimg_share_to_friend, R.k.share_to_friend_icon), new ShareImageSelectorUI.a.a(this, R.l.cropimg_share_to_sns, R.k.find_more_friend_photograph_icon), new ShareImageSelectorUI.a.a(this, R.l.cropimg_share_to_fav, R.k.more_my_favorite) };
  
  ShareImageSelectorUI$a(ShareImageSelectorUI paramShareImageSelectorUI) {}
  
  public final int getCount()
  {
    return 3;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramView == null) || (paramView.getTag() == null)) {
      paramView = LayoutInflater.from(this.whT.mController.uMN).inflate(R.i.share_image_selector_item, null);
    }
    for (paramViewGroup = new ShareImageSelectorUI.b(this.whT, paramView);; paramViewGroup = (ShareImageSelectorUI.b)paramView.getTag())
    {
      ShareImageSelectorUI.a.a locala = this.whU[paramInt];
      if (locala != null)
      {
        paramViewGroup.whY.setText(locala.whV);
        paramViewGroup.kff.setImageResource(locala.whW);
      }
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.ShareImageSelectorUI.a
 * JD-Core Version:    0.7.0.1
 */