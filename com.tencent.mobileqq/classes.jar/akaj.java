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

public class akaj
  implements QwAdapter.IViewHolder<akaa>
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
  
  public akaj(akad paramakad) {}
  
  public void a(int paramInt, View paramView, akaa paramakaa)
  {
    int i = 8;
    if (QLog.isColorLevel()) {
      QLog.d("HbSkinLogic", 2, "setItemView info = " + paramakaa);
    }
    Object localObject;
    if (akaa.c == paramakaa.jdField_a_of_type_WalletSkinInfo.skin_id)
    {
      localObject = this.jdField_a_of_type_Akad.a.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((akak)((Iterator)localObject).next()).a(paramakaa);
      }
    }
    paramView.setFocusable(true);
    paramView.setFocusableInTouchMode(true);
    ajue.a(this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView, false);
    if ((1 == paramakaa.jdField_a_of_type_WalletSkinInfo.is_hide_title) || ((1 != paramakaa.jdField_a_of_type_WalletSkinInfo.is_hide_title) && (TextUtils.isEmpty(paramakaa.jdField_a_of_type_WalletSkinInfo.blessing))))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText("");
      paramView = this.jdField_a_of_type_AndroidViewView;
      if (1 != paramakaa.b) {
        break label370;
      }
      paramInt = 8;
      label169:
      paramView.setVisibility(paramInt);
      paramView = this.jdField_b_of_type_AndroidViewView;
      if (1 != paramakaa.b) {
        break label375;
      }
      paramInt = 0;
      label189:
      paramView.setVisibility(paramInt);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramakaa.jdField_a_of_type_JavaLangString);
      paramView = this.jdField_c_of_type_AndroidViewView;
      if (akaa.c != paramakaa.jdField_a_of_type_WalletSkinInfo.skin_id) {
        break label381;
      }
      paramInt = i;
      label226:
      paramView.setVisibility(paramInt);
      paramView = this.jdField_a_of_type_AndroidWidgetTextView;
      if (akaa.c != paramakaa.jdField_a_of_type_WalletSkinInfo.skin_id) {
        break label386;
      }
      paramInt = -16777216;
      label252:
      paramView.setTextColor(paramInt);
      localObject = this.jdField_c_of_type_AndroidWidgetImageView;
      if (paramakaa.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase.icon != null) {
        break label392;
      }
      paramView = this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130847153);
      label283:
      ((ImageView)localObject).setBackgroundDrawable(paramView);
      if (-1 != paramakaa.b) {
        break label410;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843550);
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130843544));
      label322:
      localObject = this.jdField_b_of_type_AndroidWidgetImageView;
      if (paramakaa.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase.corner == null) {
        break label564;
      }
    }
    label386:
    label392:
    label410:
    label564:
    for (paramView = paramakaa.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase.corner;; paramView = null)
    {
      for (;;)
      {
        ((ImageView)localObject).setImageBitmap(paramView);
        return;
        this.jdField_b_of_type_AndroidWidgetTextView.setText(paramakaa.jdField_a_of_type_WalletSkinInfo.blessing);
        break;
        label370:
        paramInt = 0;
        break label169;
        label375:
        paramInt = 8;
        break label189;
        label381:
        paramInt = 0;
        break label226;
        paramInt = -7829368;
        break label252;
        paramView = new BitmapDrawable(paramakaa.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase.icon);
        break label283;
        if (-2 == paramakaa.b)
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843550);
          this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130843544));
          this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView.setImageResource(2130843552);
          break label322;
        }
        if (!TextUtils.isEmpty(paramakaa.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase.resPath))
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(null);
          paramView = QWalletPicHelper.getDrawableForAIO(new File(paramakaa.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase.resPath, "base_bg.png").toString(), akad.a(this.jdField_a_of_type_Akad).getResources().getDrawable(2130843544));
          this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(paramView);
        }
        if (paramakaa.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase.animInfo == null) {
          break label322;
        }
        try
        {
          new ajue(this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView, 0, false, null).a(paramakaa.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase.animInfo);
        }
        catch (OutOfMemoryError paramView) {}
      }
      break label322;
    }
  }
  
  public QwAdapter.IViewHolder clone()
  {
    return (QwAdapter.IViewHolder)super.clone();
  }
  
  public View initView(int paramInt, View paramView)
  {
    this.jdField_a_of_type_AndroidContentResResources = paramView.getContext().getResources();
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131370699);
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131377542);
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131377543);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367895));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367899));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367896));
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_START);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367897));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367900));
    this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView = ((AnimationView)paramView.findViewById(2131367898));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akaj
 * JD-Core Version:    0.7.0.1
 */