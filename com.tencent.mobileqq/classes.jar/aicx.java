import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SignatureManager.TopicInfo;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;

public class aicx
  extends BaseAdapter
{
  private aicy jdField_a_of_type_Aicy;
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private List<SignatureManager.TopicInfo> jdField_a_of_type_JavaUtilList;
  private List<SignatureManager.TopicInfo> b;
  
  public aicx(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, aicy paramaicy)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_Aicy = paramaicy;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
  }
  
  private float a(int paramInt)
  {
    return Math.round(paramInt / 10000.0F * 100.0F) / 100.0F;
  }
  
  private String a(SignatureManager.TopicInfo paramTopicInfo)
  {
    if ((paramTopicInfo == null) || ((paramTopicInfo.totalNum <= 0) && (paramTopicInfo.friendNum <= 0))) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramTopicInfo.friendNum > 0)
    {
      if (paramTopicInfo.friendNum >= 10000)
      {
        localStringBuilder.append(a(paramTopicInfo.friendNum));
        localStringBuilder.append("万好友");
      }
    }
    else
    {
      if ((paramTopicInfo.friendNum > 0) && (paramTopicInfo.totalNum > 0)) {
        localStringBuilder.append("、");
      }
      if (paramTopicInfo.totalNum > 0)
      {
        if (paramTopicInfo.totalNum < 10000) {
          break label168;
        }
        localStringBuilder.append(a(paramTopicInfo.totalNum));
        localStringBuilder.append("万人添加该话题");
      }
    }
    for (;;)
    {
      if ((paramTopicInfo.totalNum <= 0) && (paramTopicInfo.friendNum > 0)) {
        localStringBuilder.append("添加该话题");
      }
      return localStringBuilder.toString();
      localStringBuilder.append(paramTopicInfo.friendNum);
      localStringBuilder.append("个好友");
      break;
      label168:
      localStringBuilder.append(paramTopicInfo.totalNum);
      localStringBuilder.append("人添加该话题");
    }
  }
  
  private String a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) && (paramString.length() <= 2)) {}
    String str;
    do
    {
      return paramString;
      str = paramString;
      if (paramString.charAt(0) == '#') {
        str = paramString.substring(1);
      }
      paramString = str;
    } while (str.charAt(str.length() - 1) != '#');
    return str.substring(0, str.length() - 1);
  }
  
  public SignatureManager.TopicInfo a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size())) {
      return null;
    }
    return (SignatureManager.TopicInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public List<SignatureManager.TopicInfo> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public boolean a(List<SignatureManager.TopicInfo> paramList, boolean paramBoolean)
  {
    if (paramList != this.jdField_a_of_type_JavaUtilList) {
      this.jdField_a_of_type_JavaUtilList = ((ArrayList)paramList);
    }
    for (boolean bool = true;; bool = false)
    {
      if ((paramBoolean) && (paramList != this.b)) {
        this.b = ((ArrayList)paramList);
      }
      return bool;
    }
  }
  
  public List<SignatureManager.TopicInfo> b()
  {
    return this.b;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    SignatureManager.TopicInfo localTopicInfo;
    String str;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131496054, this.jdField_a_of_type_ComTencentWidgetXListView, false);
      paramViewGroup = new aicz();
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131302869));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131312561));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131312562));
      paramView.setTag(paramViewGroup);
      localTopicInfo = a(paramInt);
      if (localTopicInfo != null)
      {
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localTopicInfo.topicStr);
        paramViewGroup.jdField_a_of_type_Int = localTopicInfo.topicId;
        str = a(localTopicInfo);
        if (!TextUtils.isEmpty(str)) {
          break label212;
        }
        paramViewGroup.b.setVisibility(8);
      }
    }
    for (;;)
    {
      paramView.setContentDescription(ajjy.a(2131649236) + a(localTopicInfo.topicStr) + ajjy.a(2131649235));
      if (!ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
        break label232;
      }
      paramView.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839096));
      return paramView;
      paramViewGroup = (aicz)paramView.getTag();
      break;
      label212:
      paramViewGroup.b.setVisibility(0);
      paramViewGroup.b.setText(str);
    }
    label232:
    paramView.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839095));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aicx
 * JD-Core Version:    0.7.0.1
 */