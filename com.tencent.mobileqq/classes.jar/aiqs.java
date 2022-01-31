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

public class aiqs
  extends aiqm
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2131693199 };
  private static final int[] jdField_b_of_type_ArrayOfInt = { 2130839240 };
  private static final int[] c = { 2131369930 };
  private ajvi jdField_a_of_type_Ajvi;
  private int jdField_b_of_type_Int;
  
  public aiqs(QQAppInterface paramQQAppInterface, Context paramContext, auko paramauko, int paramInt)
  {
    super(paramQQAppInterface, paramContext, paramauko);
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_Bfwd = a(this.jdField_a_of_type_AndroidContentContext);
    if (paramInt == 2) {
      this.jdField_a_of_type_Ajvi = ((ajvi)paramQQAppInterface.getManager(53));
    }
    this.jdField_a_of_type_Int = 0;
  }
  
  public View a(int paramInt1, int paramInt2, View paramView, ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener)
  {
    Object localObject;
    if ((paramView == null) || (!(paramView.getTag() instanceof aiqt)))
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558990, null);
      paramViewGroup = new aiqt();
      paramView = this.jdField_a_of_type_Bfwd.a(this.jdField_a_of_type_AndroidContentContext, paramView, paramViewGroup, -1);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377033));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367679));
      ((RelativeLayout.LayoutParams)paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams()).leftMargin = actj.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramViewGroup.b = ((TextView)paramView.findViewById(2131377035));
      paramView.setTag(paramViewGroup);
      paramViewGroup.g.setBackgroundResource(2130839132);
      if (this.jdField_b_of_type_Int != 2) {
        break label279;
      }
      localObject = (DiscussionInfo)this.jdField_a_of_type_Auko;
      paramViewGroup.jdField_a_of_type_JavaLangString = ((DiscussionInfo)localObject).uin;
      paramViewGroup.jdField_a_of_type_JavaLangObject = localObject;
      paramViewGroup.jdField_a_of_type_Int = 101;
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((DiscussionInfo)localObject).discussionName);
      paramViewGroup.b.setVisibility(0);
      paramViewGroup.b.setText(String.format("(%d)", new Object[] { Integer.valueOf(this.jdField_a_of_type_Ajvi.a(((DiscussionInfo)localObject).uin)) }));
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166861));
      a(paramView, paramInt2, paramViewGroup, paramOnClickListener);
      return paramView;
      paramViewGroup = (aiqt)paramView.getTag();
      break;
      label279:
      localObject = (TroopInfo)this.jdField_a_of_type_Auko;
      paramViewGroup.jdField_a_of_type_JavaLangString = ((TroopInfo)localObject).troopuin;
      paramViewGroup.jdField_a_of_type_JavaLangObject = localObject;
      paramViewGroup.jdField_a_of_type_Int = 4;
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((TroopInfo)localObject).getTroopName());
      paramViewGroup.b.setVisibility(8);
    }
  }
  
  protected void a(int paramInt, bfwf[] paramArrayOfbfwf)
  {
    paramInt = 0;
    if ((paramArrayOfbfwf == null) || (paramArrayOfbfwf.length <= 0)) {}
    for (;;)
    {
      return;
      if (paramArrayOfbfwf.length < 0)
      {
        paramArrayOfbfwf[0].jdField_b_of_type_Int = 0;
        paramArrayOfbfwf[0].jdField_a_of_type_Int = 0;
        paramInt = 1;
      }
      while (paramInt < paramArrayOfbfwf.length)
      {
        paramArrayOfbfwf[paramInt].jdField_b_of_type_Int = -1;
        paramArrayOfbfwf[paramInt].jdField_a_of_type_Int = -1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aiqs
 * JD-Core Version:    0.7.0.1
 */