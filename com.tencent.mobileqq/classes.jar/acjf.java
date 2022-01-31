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

public class acjf
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  private acjk jdField_a_of_type_Acjk;
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
  
  public acjf(ExtendFriendSquareFragment paramExtendFriendSquareFragment, View paramView, acjk paramacjk)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedView = ((ExtendFriendFeedView)paramView);
    this.jdField_a_of_type_Acjk = paramacjk;
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131370095);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363261));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363262));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131370096));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370098));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131370099));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131370100));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370101));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370102));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView = ((ExtendFriendVoiceView)paramView.findViewById(2131370086));
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
  
  public void a(acjf paramacjf, acjj paramacjj)
  {
    int j = 8;
    int i;
    if (paramacjj.jdField_a_of_type_Boolean)
    {
      paramacjf.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      paramacjf.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      paramacjf.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      Object localObject = paramacjf.jdField_b_of_type_AndroidWidgetImageView;
      if ((paramacjj.jdField_b_of_type_Int != 1) && (paramacjj.jdField_b_of_type_Int != 2)) {
        break label300;
      }
      i = 0;
      label62:
      ((ImageView)localObject).setVisibility(i);
      localObject = paramacjf.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView;
      if (!TextUtils.isEmpty(paramacjj.jdField_d_of_type_JavaLangString)) {
        break label306;
      }
      i = j;
      label87:
      ((ExtendFriendVoiceView)localObject).setVisibility(i);
      paramacjf.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedView.setFeedBgParams(paramacjf.getPosition(), paramacjj.jdField_d_of_type_JavaLangString);
      paramacjf.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVoiceUrl(paramacjj.jdField_d_of_type_JavaLangString);
      paramacjf.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVoiceDuration(paramacjj.e);
      localObject = a(paramacjj.jdField_a_of_type_JavaLangString);
      paramacjf.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      paramacjf.jdField_a_of_type_AndroidWidgetTextView.setText(paramacjj.jdField_b_of_type_JavaLangString);
      paramacjf.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(paramacjj.jdField_d_of_type_Int));
      paramacjf.jdField_d_of_type_AndroidWidgetTextView.setText(paramacjj.jdField_c_of_type_JavaLangString);
      localObject = paramacjf.jdField_b_of_type_AndroidWidgetImageView;
      if (paramacjj.jdField_b_of_type_Int != 2) {
        break label311;
      }
      i = 2130842489;
      label203:
      ((ImageView)localObject).setImageResource(i);
      paramacjf = paramacjf.jdField_c_of_type_AndroidWidgetImageView;
      if (!paramacjj.jdField_b_of_type_Boolean) {
        break label323;
      }
      if (paramacjj.jdField_c_of_type_Int != 0) {
        break label317;
      }
      i = 2130842499;
    }
    for (;;)
    {
      paramacjf.setImageResource(i);
      return;
      paramacjf.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      paramacjf.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      if (paramacjj.jdField_c_of_type_Boolean)
      {
        paramacjf.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
        paramacjf.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        break;
      }
      paramacjf.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      paramacjf.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      break;
      label300:
      i = 8;
      break label62;
      label306:
      i = 0;
      break label87;
      label311:
      i = 2130842490;
      break label203;
      label317:
      i = 2130842498;
      continue;
      label323:
      i = 2130842495;
    }
  }
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (l - ExtendFriendSquareFragment.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment) < 500L) {}
    do
    {
      return;
      ExtendFriendSquareFragment.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment, l);
    } while (this.jdField_a_of_type_Acjk == null);
    int i = getPosition();
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131363261: 
    case 2131370095: 
      this.jdField_a_of_type_Acjk.b(i);
      return;
    case 2131370103: 
      this.jdField_a_of_type_Acjk.c(i);
      return;
    case 2131370099: 
      this.jdField_a_of_type_Acjk.d(i);
      return;
    }
    this.jdField_a_of_type_Acjk.e(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acjf
 * JD-Core Version:    0.7.0.1
 */