import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QIMNotifyAddFriend;
import com.tencent.mobileqq.data.QIMNotifyAddFriend.VideoInfo;
import java.util.ArrayList;
import java.util.List;

class aktu
  extends bfxe
{
  int jdField_a_of_type_Int = 0;
  Context jdField_a_of_type_AndroidContentContext;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  List<QIMNotifyAddFriend> jdField_a_of_type_JavaUtilList = new ArrayList();
  int b = 0;
  
  public aktu(aktr paramaktr, Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = paramContext.getResources().getDimensionPixelOffset(2131297906);
    this.b = paramContext.getResources().getDimensionPixelOffset(2131297905);
  }
  
  public void a(List<QIMNotifyAddFriend> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    QIMNotifyAddFriend localQIMNotifyAddFriend;
    Object localObject1;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560557, null);
      paramViewGroup = new aktw(this.jdField_a_of_type_Aktr);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368564));
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131363983));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378269));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131378357));
      paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131369371));
      paramView.setTag(paramViewGroup);
      localQIMNotifyAddFriend = (QIMNotifyAddFriend)getItem(paramInt);
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setTag(localQIMNotifyAddFriend);
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this.jdField_a_of_type_Aktr);
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(this.jdField_a_of_type_Aktr.b.contains(localQIMNotifyAddFriend));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(bayh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(localQIMNotifyAddFriend.uin), (byte)3));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localQIMNotifyAddFriend.nickName);
      paramViewGroup.b.setText(localQIMNotifyAddFriend.wording);
      localObject1 = this.jdField_a_of_type_Aktr.a.a(localQIMNotifyAddFriend.uin, localQIMNotifyAddFriend.qqUin);
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label462;
      }
      paramViewGroup.b.setText((CharSequence)localObject1);
    }
    for (;;)
    {
      if (localQIMNotifyAddFriend.videoInfos.size() <= 0) {
        break label474;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
      paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      localObject1 = new ArrayList();
      paramInt = 0;
      while (paramInt < localQIMNotifyAddFriend.videoInfos.size())
      {
        Object localObject2 = (QIMNotifyAddFriend.VideoInfo)localQIMNotifyAddFriend.videoInfos.get(paramInt);
        URLImageView localURLImageView = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
        localURLImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        ((ArrayList)localObject1).add(((QIMNotifyAddFriend.VideoInfo)localObject2).videoVid);
        localURLImageView.setOnClickListener(new aktv(this, (ArrayList)localObject1, ((QIMNotifyAddFriend.VideoInfo)localObject2).videoVid));
        vzl.a(localURLImageView, ((QIMNotifyAddFriend.VideoInfo)localObject2).coverUrl, this.jdField_a_of_type_Int, this.b, 8, new ColorDrawable(-1), "Qim_First_Login_Recommend");
        localObject2 = new LinearLayout.LayoutParams(this.jdField_a_of_type_Int, this.b);
        if (paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() != 0) {
          ((LinearLayout.LayoutParams)localObject2).setMargins(actj.a(5.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0, 0);
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localURLImageView, (ViewGroup.LayoutParams)localObject2);
        paramInt += 1;
      }
      paramViewGroup = (aktw)paramView.getTag();
      break;
      label462:
      paramViewGroup.b.setVisibility(8);
    }
    label474:
    paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    paramViewGroup.jdField_a_of_type_Long = localQIMNotifyAddFriend.uin;
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aktu
 * JD-Core Version:    0.7.0.1
 */