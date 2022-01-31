import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendSquareFragment;
import com.tencent.mobileqq.extendfriend.utils.ProfileGuideDialogUtils;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendFeedView;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendVoiceView;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.ImageUtil;

public class acrm
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  private acrr jdField_a_of_type_Acrr;
  public View a;
  public ImageView a;
  public TextView a;
  public ExtendFriendFeedView a;
  public ExtendFriendVoiceView a;
  public ImageView b;
  public TextView b;
  public ImageView c;
  public TextView c;
  public ImageView d;
  public TextView d;
  
  public acrm(ExtendFriendSquareFragment paramExtendFriendSquareFragment, View paramView, acrr paramacrr)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedView = ((ExtendFriendFeedView)paramView);
    this.jdField_a_of_type_Acrr = paramacrr;
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131370104);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363278));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363279));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131370105));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370107));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131370108));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131370109));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370110));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370111));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView = ((ExtendFriendVoiceView)paramView.findViewById(2131370095));
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(ProfileGuideDialogUtils.a);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setMode(1);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setActivity(ExtendFriendSquareFragment.a(paramExtendFriendSquareFragment));
  }
  
  private Drawable a(String paramString)
  {
    Drawable localDrawable = ImageUtil.b();
    return FaceDrawable.a(ExtendFriendSquareFragment.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment), 1, paramString, 3, localDrawable, localDrawable);
  }
  
  public void a(acrm paramacrm, acrq paramacrq)
  {
    int j = 8;
    int i;
    if (paramacrq.jdField_a_of_type_Boolean)
    {
      paramacrm.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      paramacrm.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      paramacrm.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      Object localObject = paramacrm.jdField_b_of_type_AndroidWidgetImageView;
      if ((paramacrq.jdField_b_of_type_Int != 1) && (paramacrq.jdField_b_of_type_Int != 2)) {
        break label300;
      }
      i = 0;
      label62:
      ((ImageView)localObject).setVisibility(i);
      localObject = paramacrm.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView;
      if (!TextUtils.isEmpty(paramacrq.jdField_d_of_type_JavaLangString)) {
        break label306;
      }
      i = j;
      label87:
      ((ExtendFriendVoiceView)localObject).setVisibility(i);
      paramacrm.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedView.setFeedBgParams(paramacrm.getPosition(), paramacrq.jdField_d_of_type_JavaLangString);
      paramacrm.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVoiceUrl(paramacrq.jdField_d_of_type_JavaLangString);
      paramacrm.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVoiceDuration(paramacrq.e);
      localObject = a(paramacrq.jdField_a_of_type_JavaLangString);
      paramacrm.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      paramacrm.jdField_a_of_type_AndroidWidgetTextView.setText(paramacrq.jdField_b_of_type_JavaLangString);
      paramacrm.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(paramacrq.jdField_d_of_type_Int));
      paramacrm.jdField_d_of_type_AndroidWidgetTextView.setText(paramacrq.jdField_c_of_type_JavaLangString);
      localObject = paramacrm.jdField_b_of_type_AndroidWidgetImageView;
      if (paramacrq.jdField_b_of_type_Int != 2) {
        break label311;
      }
      i = 2130842524;
      label203:
      ((ImageView)localObject).setImageResource(i);
      paramacrm = paramacrm.jdField_c_of_type_AndroidWidgetImageView;
      if (!paramacrq.jdField_b_of_type_Boolean) {
        break label323;
      }
      if (paramacrq.jdField_c_of_type_Int != 0) {
        break label317;
      }
      i = 2130842534;
    }
    for (;;)
    {
      paramacrm.setImageResource(i);
      return;
      paramacrm.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      paramacrm.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      if (paramacrq.jdField_c_of_type_Boolean)
      {
        paramacrm.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
        paramacrm.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        break;
      }
      paramacrm.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      paramacrm.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      break;
      label300:
      i = 8;
      break label62;
      label306:
      i = 0;
      break label87;
      label311:
      i = 2130842525;
      break label203;
      label317:
      i = 2130842533;
      continue;
      label323:
      i = 2130842530;
    }
  }
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if ((paramView.getId() != 2131370108) && (l - ExtendFriendSquareFragment.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment) < 500L)) {}
    do
    {
      return;
      ExtendFriendSquareFragment.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment, l);
    } while (this.jdField_a_of_type_Acrr == null);
    int i = getPosition();
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131363278: 
    case 2131370104: 
      this.jdField_a_of_type_Acrr.b(i);
      return;
    case 2131370112: 
      this.jdField_a_of_type_Acrr.c(i);
      return;
    case 2131370108: 
      this.jdField_a_of_type_Acrr.d(i);
      return;
    }
    this.jdField_a_of_type_Acrr.e(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acrm
 * JD-Core Version:    0.7.0.1
 */