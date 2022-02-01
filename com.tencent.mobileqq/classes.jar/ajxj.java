import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.persistence.Entity;

public class ajxj
  extends ajsm
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2131692805 };
  private static final int[] jdField_b_of_type_ArrayOfInt = { 2130839515 };
  private static final int[] c = { 2131370758 };
  private anws jdField_a_of_type_Anws;
  private int jdField_b_of_type_Int;
  
  public ajxj(QQAppInterface paramQQAppInterface, Context paramContext, Entity paramEntity, int paramInt)
  {
    super(paramQQAppInterface, paramContext, paramEntity);
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_Blpv = a(this.jdField_a_of_type_AndroidContentContext);
    if (paramInt == 2) {
      this.jdField_a_of_type_Anws = ((anws)paramQQAppInterface.getManager(53));
    }
    this.jdField_a_of_type_Int = 0;
  }
  
  public View a(int paramInt1, int paramInt2, View paramView, ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener)
  {
    Object localObject;
    if ((paramView == null) || (!(paramView.getTag() instanceof ajxk)))
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559096, null);
      paramViewGroup = new ajxk();
      paramView = this.jdField_a_of_type_Blpv.a(this.jdField_a_of_type_AndroidContentContext, paramView, paramViewGroup, -1);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378604));
      paramViewGroup.d = ((ImageView)paramView.findViewById(2131368212));
      ((RelativeLayout.LayoutParams)paramViewGroup.d.getLayoutParams()).leftMargin = agej.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378606));
      paramView.setTag(paramViewGroup);
      paramViewGroup.g.setBackgroundResource(2130839402);
      if (this.jdField_b_of_type_Int != 2) {
        break label279;
      }
      localObject = (DiscussionInfo)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntity;
      paramViewGroup.jdField_a_of_type_JavaLangString = ((DiscussionInfo)localObject).uin;
      paramViewGroup.jdField_a_of_type_JavaLangObject = localObject;
      paramViewGroup.jdField_b_of_type_Int = 101;
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((DiscussionInfo)localObject).discussionName);
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(String.format("(%d)", new Object[] { Integer.valueOf(this.jdField_a_of_type_Anws.a(((DiscussionInfo)localObject).uin)) }));
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166997));
      a(paramView, paramInt2, paramViewGroup, paramOnClickListener);
      return paramView;
      paramViewGroup = (ajxk)paramView.getTag();
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
  
  protected void a(int paramInt, blpx[] paramArrayOfblpx)
  {
    paramInt = 0;
    if ((paramArrayOfblpx == null) || (paramArrayOfblpx.length <= 0)) {}
    for (;;)
    {
      return;
      if (paramArrayOfblpx.length < 0)
      {
        paramArrayOfblpx[0].jdField_b_of_type_Int = 0;
        paramArrayOfblpx[0].jdField_a_of_type_Int = 0;
        paramInt = 1;
      }
      while (paramInt < paramArrayOfblpx.length)
      {
        paramArrayOfblpx[paramInt].jdField_b_of_type_Int = -1;
        paramArrayOfblpx[paramInt].jdField_a_of_type_Int = -1;
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
 * Qualified Name:     ajxj
 * JD-Core Version:    0.7.0.1
 */