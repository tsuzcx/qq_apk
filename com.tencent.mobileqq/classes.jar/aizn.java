import Wallet.SkinInfo;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketInfoBase;
import com.tencent.mobileqq.widget.AnimationView;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletPicHelper;
import cooperation.qwallet.plugin.QwAdapter.IViewHolder;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class aizn
  implements QwAdapter.IViewHolder<aize>
{
  private Resources jdField_a_of_type_AndroidContentResResources;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AnimationView jdField_a_of_type_ComTencentMobileqqWidgetAnimationView;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private View jdField_c_of_type_AndroidViewView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  
  public aizn(aizh paramaizh) {}
  
  public void a(int paramInt, View paramView, aize paramaize)
  {
    int i = 8;
    QLog.d("HbSkinLogic", 2, "setItemView info = " + paramaize);
    Object localObject;
    if (aize.c == paramaize.jdField_a_of_type_WalletSkinInfo.skin_id)
    {
      localObject = this.jdField_a_of_type_Aizh.a.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((aizo)((Iterator)localObject).next()).a(paramaize);
      }
    }
    paramView.setFocusable(true);
    paramView.setFocusableInTouchMode(true);
    aiuf.a(this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView, false);
    if (1 == paramaize.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase.isHideTitle)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText("");
      paramView = this.jdField_a_of_type_AndroidViewView;
      if (1 != paramaize.b) {
        break label372;
      }
      paramInt = 8;
      label139:
      paramView.setVisibility(paramInt);
      paramView = this.jdField_b_of_type_AndroidViewView;
      if (1 != paramaize.b) {
        break label377;
      }
      paramInt = 0;
      label159:
      paramView.setVisibility(paramInt);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramaize.jdField_a_of_type_JavaLangString);
      paramView = this.jdField_c_of_type_AndroidViewView;
      if (aize.c != paramaize.jdField_a_of_type_WalletSkinInfo.skin_id) {
        break label383;
      }
      paramInt = i;
      label196:
      paramView.setVisibility(paramInt);
      paramView = this.jdField_a_of_type_AndroidWidgetTextView;
      if (aize.c != paramaize.jdField_a_of_type_WalletSkinInfo.skin_id) {
        break label388;
      }
      paramInt = -16777216;
      label222:
      paramView.setTextColor(paramInt);
      localObject = this.jdField_c_of_type_AndroidWidgetImageView;
      if (paramaize.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase.icon != null) {
        break label394;
      }
      paramView = this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130846778);
      label253:
      ((ImageView)localObject).setBackgroundDrawable(paramView);
      if (-1 != paramaize.b) {
        break label412;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843123);
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130843117));
      label292:
      localObject = this.jdField_b_of_type_AndroidWidgetImageView;
      if (paramaize.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase.corner == null) {
        break label566;
      }
    }
    label388:
    label394:
    label412:
    label566:
    for (paramView = paramaize.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase.corner;; paramView = null)
    {
      for (;;)
      {
        ((ImageView)localObject).setImageBitmap(paramView);
        return;
        localObject = this.jdField_b_of_type_AndroidWidgetTextView;
        if (TextUtils.isEmpty(paramaize.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase.title)) {}
        for (paramView = paramView.getContext().getString(2131697275);; paramView = paramaize.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase.title)
        {
          ((TextView)localObject).setText(paramView);
          break;
        }
        label372:
        paramInt = 0;
        break label139;
        label377:
        paramInt = 8;
        break label159;
        label383:
        paramInt = 0;
        break label196;
        paramInt = -7829368;
        break label222;
        paramView = new BitmapDrawable(paramaize.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase.icon);
        break label253;
        if (-2 == paramaize.b)
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843123);
          this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130843117));
          this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView.setImageResource(2130843125);
          break label292;
        }
        if (!TextUtils.isEmpty(paramaize.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase.resPath))
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(null);
          paramView = QWalletPicHelper.getDrawableForAIO(new File(paramaize.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase.resPath, "base_bg.png").toString(), aizh.a(this.jdField_a_of_type_Aizh).getResources().getDrawable(2130843117));
          this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(paramView);
        }
        if (paramaize.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase.animInfo == null) {
          break label292;
        }
        try
        {
          new aiuf(this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView, 0, false, null).a(paramaize.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase.animInfo);
        }
        catch (OutOfMemoryError paramView) {}
      }
      break label292;
    }
  }
  
  public QwAdapter.IViewHolder clone()
  {
    return (QwAdapter.IViewHolder)super.clone();
  }
  
  public View initView(int paramInt, View paramView)
  {
    this.jdField_a_of_type_AndroidContentResResources = paramView.getContext().getResources();
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131370186);
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131376808);
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131376809);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367484));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367488));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367485));
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_START);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367486));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367489));
    this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView = ((AnimationView)paramView.findViewById(2131367487));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aizn
 * JD-Core Version:    0.7.0.1
 */