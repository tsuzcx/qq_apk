import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.contact.addcontact.publicaccount.PublicView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PublicRecommendAccountInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.FormMultiLineItem;
import com.tencent.widget.MultiImageTextView;
import com.tencent.widget.XListView;
import java.util.ArrayList;

public class aicg
  extends aliy
{
  public aicg(PublicView paramPublicView, Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView)
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
    Object localObject1;
    if (paramView == null)
    {
      localObject1 = new FormMultiLineItem(this.a.a);
      ((View)localObject1).setId(2131373952);
      paramView = new aici();
      paramView.c = ((FormMultiLineItem)localObject1).a();
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((FormMultiLineItem)localObject1).a(0);
      paramView.b = ((FormMultiLineItem)localObject1).a(1);
      ((View)localObject1).setTag(paramView);
      ((View)localObject1).setOnClickListener(this.a);
    }
    Object localObject2;
    for (;;)
    {
      localObject2 = a(paramInt);
      if (localObject2 != null) {
        break;
      }
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
      return localObject1;
      localObject2 = (aici)paramView.getTag();
      localObject1 = paramView;
      paramView = (View)localObject2;
    }
    if (((PublicRecommendAccountInfo)localObject2).mSource == 1)
    {
      paramView.jdField_a_of_type_JavaLangString = ((PublicRecommendAccountInfo)localObject2).mEqqNameAccount;
      label154:
      paramView.jdField_a_of_type_ComTencentMobileqqDataPublicRecommendAccountInfo = ((PublicRecommendAccountInfo)localObject2);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramView.b.setVisibility(0);
      paramView.c.setImageBitmap(a(1, paramView.jdField_a_of_type_JavaLangString));
      if (((PublicRecommendAccountInfo)localObject2).mSource != 1) {
        break label404;
      }
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((PublicRecommendAccountInfo)localObject2).mEqqCs);
      paramView.b.setText(((PublicRecommendAccountInfo)localObject2).mEqqSi);
    }
    for (;;)
    {
      if ((((PublicRecommendAccountInfo)localObject2).mIsVerified != null) && (((PublicRecommendAccountInfo)localObject2).mIsVerified.equalsIgnoreCase("1")))
      {
        localObject2 = this.a.getResources().getDrawable(2130841793);
        int i = (int)bfvh.a(this.a.a, 15.0F);
        ((Drawable)localObject2).setBounds(0, 0, i, i);
        ((MultiImageTextView)paramView.jdField_a_of_type_AndroidWidgetTextView).a(6.0F);
        ((MultiImageTextView)paramView.jdField_a_of_type_AndroidWidgetTextView).a((Drawable)localObject2, i, i);
        ((MultiImageTextView)paramView.jdField_a_of_type_AndroidWidgetTextView).b();
      }
      if (AppSetting.c)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramView.jdField_a_of_type_AndroidWidgetTextView.getText().toString());
        ((StringBuilder)localObject2).append(paramView.b.getText().toString());
        ((View)localObject1).setContentDescription(((StringBuilder)localObject2).toString());
      }
      break;
      paramView.jdField_a_of_type_JavaLangString = String.valueOf(((PublicRecommendAccountInfo)localObject2).mPublicuin);
      break label154;
      label404:
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((PublicRecommendAccountInfo)localObject2).mPublicname);
      paramView.b.setText(((PublicRecommendAccountInfo)localObject2).mPublicdesc);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aicg
 * JD-Core Version:    0.7.0.1
 */