import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.persistence.Entity;

public class ajnv
  extends ajiy
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2131692962 };
  private static final int[] jdField_b_of_type_ArrayOfInt = { 2130839571 };
  private static final int[] c = { 2131370911 };
  private antp jdField_a_of_type_Antp;
  private int jdField_b_of_type_Int;
  
  public ajnv(QQAppInterface paramQQAppInterface, Context paramContext, Entity paramEntity, int paramInt)
  {
    super(paramQQAppInterface, paramContext, paramEntity);
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_Blfk = a(this.jdField_a_of_type_AndroidContentContext);
    if (paramInt == 2) {
      this.jdField_a_of_type_Antp = ((antp)paramQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER));
    }
    this.jdField_a_of_type_Int = 0;
  }
  
  public View a(int paramInt1, int paramInt2, View paramView, ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener)
  {
    Object localObject;
    if ((paramView == null) || (!(paramView.getTag() instanceof ajnw)))
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559132, null);
      paramViewGroup = new ajnw();
      paramView = this.jdField_a_of_type_Blfk.a(this.jdField_a_of_type_AndroidContentContext, paramView, paramViewGroup, -1);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378659));
      paramViewGroup.d = ((ImageView)paramView.findViewById(2131368381));
      ((RelativeLayout.LayoutParams)paramViewGroup.d.getLayoutParams()).leftMargin = AIOUtils.dp2px(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378661));
      paramView.setTag(paramViewGroup);
      paramViewGroup.g.setBackgroundResource(2130839458);
      if (this.jdField_b_of_type_Int != 2) {
        break label279;
      }
      localObject = (DiscussionInfo)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntity;
      paramViewGroup.jdField_a_of_type_JavaLangString = ((DiscussionInfo)localObject).uin;
      paramViewGroup.jdField_a_of_type_JavaLangObject = localObject;
      paramViewGroup.jdField_b_of_type_Int = 101;
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((DiscussionInfo)localObject).discussionName);
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(String.format("(%d)", new Object[] { Integer.valueOf(this.jdField_a_of_type_Antp.a(((DiscussionInfo)localObject).uin)) }));
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167033));
      a(paramView, paramInt2, paramViewGroup, paramOnClickListener);
      return paramView;
      paramViewGroup = (ajnw)paramView.getTag();
      break;
      label279:
      localObject = (TroopInfo)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntity;
      paramViewGroup.jdField_a_of_type_JavaLangString = ((TroopInfo)localObject).troopuin;
      paramViewGroup.jdField_a_of_type_JavaLangObject = localObject;
      paramViewGroup.jdField_b_of_type_Int = 4;
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((TroopInfo)localObject).getTroopName());
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  protected void a(int paramInt, blfm[] paramArrayOfblfm)
  {
    paramInt = 0;
    if ((paramArrayOfblfm == null) || (paramArrayOfblfm.length <= 0)) {}
    for (;;)
    {
      return;
      if (paramArrayOfblfm.length < 0)
      {
        paramArrayOfblfm[0].jdField_b_of_type_Int = 0;
        paramArrayOfblfm[0].jdField_a_of_type_Int = 0;
        paramInt = 1;
      }
      while (paramInt < paramArrayOfblfm.length)
      {
        paramArrayOfblfm[paramInt].jdField_b_of_type_Int = -1;
        paramArrayOfblfm[paramInt].jdField_a_of_type_Int = -1;
        paramInt += 1;
      }
    }
  }
  
  protected int[] a()
  {
    return c;
  }
  
  protected int[] b()
  {
    return jdField_a_of_type_ArrayOfInt;
  }
  
  protected int[] c()
  {
    return jdField_b_of_type_ArrayOfInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajnv
 * JD-Core Version:    0.7.0.1
 */