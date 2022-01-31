import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.data.ApolloActionRecentData;
import com.tencent.mobileqq.apollo.view.ApolloLinearLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import java.util.ArrayList;
import java.util.List;

public class alnj
  extends alnp
{
  public int a;
  public int b;
  
  public int a()
  {
    return 1;
  }
  
  public View a()
  {
    switch (this.c)
    {
    case 1: 
    default: 
      return new ApolloLinearLayout(this.jdField_b_of_type_AndroidContentContext, null, this.d, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    case 0: 
      return new ApolloLinearLayout(this.jdField_b_of_type_AndroidContentContext, null, this.d, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    }
    return LayoutInflater.from(this.jdField_b_of_type_AndroidContentContext).inflate(2131558642, null);
  }
  
  public void a()
  {
    this.jdField_b_of_type_AndroidContentContext = null;
  }
  
  public void a(View paramView, int paramInt)
  {
    for (;;)
    {
      int j;
      int i;
      int k;
      try
      {
        Object localObject;
        almb localalmb;
        int i1;
        if (this.c == 0)
        {
          int m = this.jdField_a_of_type_Int;
          int n = this.jdField_b_of_type_Int;
          j = 0;
          i = 0;
          if (j < this.jdField_b_of_type_Int)
          {
            LinearLayout localLinearLayout = (LinearLayout)((ApolloLinearLayout)paramView).getChildAt(j);
            k = 0;
            if (k >= this.jdField_a_of_type_Int) {
              break label266;
            }
            localObject = localLinearLayout.getChildAt(k);
            localalmb = (almb)((View)localObject).getTag();
            i1 = m * n * paramInt + i;
            List localList = this.jdField_a_of_type_JavaUtilList;
            if (localList != null) {
              continue;
            }
          }
        }
        return;
        if (i1 < this.jdField_a_of_type_JavaUtilList.size())
        {
          localObject = ((allz)this.jdField_a_of_type_JavaUtilList.get(i1)).a;
          localalmb.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          localalmb.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(((allz)this.jdField_a_of_type_JavaUtilList.get(i1)).a(this.jdField_b_of_type_AndroidContentContext, this.jdField_b_of_type_AndroidContentContext.getResources().getDisplayMetrics().density));
          if ((localObject != null) && (((ApolloActionData)localObject).actionName != null)) {
            localalmb.jdField_a_of_type_AndroidWidgetTextView.setText(((ApolloActionData)localObject).actionName);
          }
          localalmb.jdField_a_of_type_Allz = ((allz)this.jdField_a_of_type_JavaUtilList.get(i1));
          localalmb.jdField_a_of_type_Allz.c = 1;
        }
        else
        {
          ((View)localObject).setContentDescription(null);
          ((View)localObject).setOnClickListener(null);
        }
      }
      finally {}
      label266:
      j += 1;
      continue;
      k += 1;
      i += 1;
    }
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    boolean bool;
    if (paramQQAppInterface == null) {
      bool = false;
    }
    Object localObject1;
    label50:
    int i;
    for (;;)
    {
      return bool;
      try
      {
        localObject1 = (alkn)paramQQAppInterface.getManager(154);
        if (localObject1 == null)
        {
          bool = false;
        }
        else
        {
          if (paramSessionInfo.jdField_a_of_type_Int == 0) {}
          for (paramSessionInfo = ((alkn)localObject1).jdField_a_of_type_JavaUtilList;; paramSessionInfo = ((alkn)localObject1).b)
          {
            if (paramSessionInfo == null) {
              break label250;
            }
            if (paramSessionInfo.size() != 0) {
              break;
            }
            break label250;
            if ((paramSessionInfo.jdField_a_of_type_Int != 1) && (paramSessionInfo.jdField_a_of_type_Int != 3000)) {
              break label245;
            }
          }
          if (this.jdField_a_of_type_JavaUtilList != null) {
            this.jdField_a_of_type_JavaUtilList.clear();
          }
          for (;;)
          {
            i = paramSessionInfo.size() - 1;
            break;
            this.jdField_a_of_type_JavaUtilList = new ArrayList();
          }
          localObject1 = new ApolloActionData();
        }
      }
      finally {}
    }
    label140:
    Object localObject2 = (aliw)paramQQAppInterface.getManager(155);
    if (localObject2 != null)
    {
      localObject2 = ((aliw)localObject2).a(((ApolloActionRecentData)paramSessionInfo.get(i)).actionId);
      localObject1 = localObject2;
      if (localObject2 == null) {}
    }
    for (;;)
    {
      localObject2 = new almf(paramQQAppInterface.c());
      ((almf)localObject2).a = ((ApolloActionData)localObject1);
      ((almf)localObject2).c = 1;
      this.jdField_a_of_type_JavaUtilList.add(localObject2);
      label275:
      for (;;)
      {
        bool = true;
        break;
        label245:
        paramSessionInfo = null;
        break label50;
        label250:
        bool = false;
        break;
        for (;;)
        {
          if (i < 0) {
            break label275;
          }
          if (paramQQAppInterface != null) {
            break label140;
          }
          bool = false;
          break;
          i -= 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alnj
 * JD-Core Version:    0.7.0.1
 */