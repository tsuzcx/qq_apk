import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.contact.addcontact.PublicView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PublicRecommendAccountInfo;
import com.tencent.widget.FormMultiLineItem;
import com.tencent.widget.MultiImageTextView;
import com.tencent.widget.XListView;
import java.util.ArrayList;

public class affr
  extends aims
{
  public affr(PublicView paramPublicView, Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView)
  {
    super(paramContext, paramQQAppInterface, paramXListView, 1, true);
    paramXListView.setAdapter(this);
  }
  
  public PublicRecommendAccountInfo a(int paramInt)
  {
    if ((PublicView.a(this.a) != null) && (paramInt >= 0) && (paramInt < PublicView.a(this.a).size())) {
      return (PublicRecommendAccountInfo)PublicView.a(this.a).get(paramInt);
    }
    return null;
  }
  
  public int getCount()
  {
    if ((PublicView.a(this.a) != null) && (PublicView.a(this.a).size() > 0)) {
      return PublicView.a(this.a).size();
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = new FormMultiLineItem(this.a.a);
      paramView.setId(2131372875);
      paramViewGroup = new afft();
      paramViewGroup.c = ((FormMultiLineItem)paramView).a();
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((FormMultiLineItem)paramView).a(0);
      paramViewGroup.b = ((FormMultiLineItem)paramView).a(1);
      paramView.setTag(paramViewGroup);
      paramView.setOnClickListener(this.a);
    }
    Object localObject;
    for (;;)
    {
      localObject = a(paramInt);
      if (localObject != null) {
        break;
      }
      return paramView;
      paramViewGroup = (afft)paramView.getTag();
    }
    if (((PublicRecommendAccountInfo)localObject).mSource == 1)
    {
      paramViewGroup.jdField_a_of_type_JavaLangString = ((PublicRecommendAccountInfo)localObject).mEqqNameAccount;
      label124:
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqDataPublicRecommendAccountInfo = ((PublicRecommendAccountInfo)localObject);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramViewGroup.b.setVisibility(0);
      paramViewGroup.c.setImageBitmap(a(1, paramViewGroup.jdField_a_of_type_JavaLangString));
      if (((PublicRecommendAccountInfo)localObject).mSource != 1) {
        break label367;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((PublicRecommendAccountInfo)localObject).mEqqCs);
      paramViewGroup.b.setText(((PublicRecommendAccountInfo)localObject).mEqqSi);
    }
    for (;;)
    {
      if ((((PublicRecommendAccountInfo)localObject).mIsVerified != null) && (((PublicRecommendAccountInfo)localObject).mIsVerified.equalsIgnoreCase("1")))
      {
        localObject = this.a.getResources().getDrawable(2130841310);
        paramInt = (int)bbdv.a(this.a.a, 15.0F);
        ((Drawable)localObject).setBounds(0, 0, paramInt, paramInt);
        ((MultiImageTextView)paramViewGroup.jdField_a_of_type_AndroidWidgetTextView).a(6.0F);
        ((MultiImageTextView)paramViewGroup.jdField_a_of_type_AndroidWidgetTextView).a((Drawable)localObject, paramInt, paramInt);
        ((MultiImageTextView)paramViewGroup.jdField_a_of_type_AndroidWidgetTextView).b();
      }
      if (!AppSetting.d) {
        break;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.getText().toString());
      ((StringBuilder)localObject).append(paramViewGroup.b.getText().toString());
      paramView.setContentDescription(((StringBuilder)localObject).toString());
      return paramView;
      paramViewGroup.jdField_a_of_type_JavaLangString = String.valueOf(((PublicRecommendAccountInfo)localObject).mPublicuin);
      break label124;
      label367:
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((PublicRecommendAccountInfo)localObject).mPublicname);
      paramViewGroup.b.setText(((PublicRecommendAccountInfo)localObject).mPublicdesc);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     affr
 * JD-Core Version:    0.7.0.1
 */