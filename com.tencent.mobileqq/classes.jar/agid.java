import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;
import java.util.Iterator;
import java.util.List;

public class agid
  extends agih
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new agie(this);
  private bcws jdField_a_of_type_Bcws;
  BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  
  public agid(QQAppInterface paramQQAppInterface, agia paramagia, QQWalletTransferMsgElem paramQQWalletTransferMsgElem, int paramInt, aemp paramaemp)
  {
    super(paramQQAppInterface, paramagia, paramQQWalletTransferMsgElem, paramInt, paramaemp);
  }
  
  public void a(bcws parambcws)
  {
    this.jdField_a_of_type_Bcws = parambcws;
  }
  
  public boolean b()
  {
    boolean bool = super.b();
    if (bool) {
      return bool;
    }
    this.jdField_a_of_type_Agia.b.setVisibility(0);
    this.jdField_a_of_type_Agia.b.setTextColor(-8947849);
    this.jdField_a_of_type_Agia.b.setText("QQ专属红包");
    return false;
  }
  
  public void c()
  {
    int j = 0;
    super.c();
    if ((this.jdField_a_of_type_Agia == null) || (this.jdField_a_of_type_Agia.g == null)) {}
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_Agia.g.getVisibility() != 0) {
        this.jdField_a_of_type_Agia.g.setVisibility(0);
      }
      LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      localLinearLayout.setOrientation(0);
      this.jdField_a_of_type_Agia.g.addView(localLinearLayout);
      Object localObject = (RelativeLayout.LayoutParams)localLinearLayout.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = -2;
      ((RelativeLayout.LayoutParams)localObject).height = -2;
      ((RelativeLayout.LayoutParams)localObject).addRule(14, -1);
      ((RelativeLayout.LayoutParams)localObject).addRule(12, -1);
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = bcwh.a(this.jdField_a_of_type_AndroidContentContext, 25.0F);
      int k = bcwh.a(this.jdField_a_of_type_AndroidContentContext, 1.0F);
      int i;
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.specifyUinList.size() <= 1) {
        i = 0;
      }
      while ((j < 5) && (j < this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.specifyUinList.size()))
      {
        long l = ((Long)this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.specifyUinList.get(j)).longValue();
        localObject = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        localLinearLayout.addView((View)localObject);
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
        localLayoutParams.width = bcwh.a(this.jdField_a_of_type_AndroidContentContext, 33.0F);
        localLayoutParams.height = bcwh.a(this.jdField_a_of_type_AndroidContentContext, 33.0F);
        ((ImageView)localObject).setScaleType(ImageView.ScaleType.FIT_XY);
        if (j > 0) {
          localLayoutParams.leftMargin = i;
        }
        ((ImageView)localObject).setImageDrawable(bcxb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(l), (byte)4));
        ((ImageView)localObject).setBackgroundResource(2130846821);
        ((ImageView)localObject).setPadding(k, k, k, k);
        j += 1;
        continue;
        if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.specifyUinList.size() == 2) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.specifyUinList.size() == 3)) {
          i = bcwh.a(this.jdField_a_of_type_AndroidContentContext, 10.0F);
        } else if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.specifyUinList.size() == 4) {
          i = 0;
        } else if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.specifyUinList.size() >= 5) {
          i = -bcwh.a(this.jdField_a_of_type_AndroidContentContext, 8.0F);
        } else {
          i = 0;
        }
      }
    }
  }
  
  public void h()
  {
    super.h();
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg == null) || (this.jdField_a_of_type_ComTencentMobileqqDataQQWalletRedPacketMsg == null) || (this.jdField_a_of_type_Agia == null) || (this.jdField_a_of_type_Agia.f == null)) {}
    while ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.isSender()) || (aizl.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg))) {
      return;
    }
    View localView = new View(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Agia.f.setVisibility(0);
    this.jdField_a_of_type_Agia.f.addView(localView);
    Object localObject = (RelativeLayout.LayoutParams)localView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = bcwh.a(this.jdField_a_of_type_AndroidContentContext, 33.5F);
    ((RelativeLayout.LayoutParams)localObject).height = bcwh.a(this.jdField_a_of_type_AndroidContentContext, 33.5F);
    ((RelativeLayout.LayoutParams)localObject).leftMargin = bcwh.a(this.jdField_a_of_type_AndroidContentContext, 10.0F);
    if (this.jdField_a_of_type_ComTencentMobileqqDataQQWalletRedPacketMsg.specifyUinList != null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqDataQQWalletRedPacketMsg.specifyUinList.iterator();
      Long localLong;
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localLong = (Long)((Iterator)localObject).next();
      } while (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c().equals(localLong + ""));
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localView.setBackgroundResource(2130846824);
        localView.setTag(Integer.valueOf(1));
      }
      for (;;)
      {
        if (((this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity)) && (((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment() != null)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a();
        }
        localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        ajaf.a(localView, 0.6F);
        return;
        localView.setBackgroundResource(2130846823);
        localView.setTag(Integer.valueOf(0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agid
 * JD-Core Version:    0.7.0.1
 */