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

public class aiqu
  extends aiqo
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2131693198 };
  private static final int[] jdField_b_of_type_ArrayOfInt = { 2130839240 };
  private static final int[] c = { 2131369931 };
  private ajvk jdField_a_of_type_Ajvk;
  private int jdField_b_of_type_Int;
  
  public aiqu(QQAppInterface paramQQAppInterface, Context paramContext, aukm paramaukm, int paramInt)
  {
    super(paramQQAppInterface, paramContext, paramaukm);
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_Bfvm = a(this.jdField_a_of_type_AndroidContentContext);
    if (paramInt == 2) {
      this.jdField_a_of_type_Ajvk = ((ajvk)paramQQAppInterface.getManager(53));
    }
    this.jdField_a_of_type_Int = 0;
  }
  
  public View a(int paramInt1, int paramInt2, View paramView, ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener)
  {
    Object localObject;
    if ((paramView == null) || (!(paramView.getTag() instanceof aiqv)))
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558990, null);
      paramViewGroup = new aiqv();
      paramView = this.jdField_a_of_type_Bfvm.a(this.jdField_a_of_type_AndroidContentContext, paramView, paramViewGroup, -1);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377031));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367679));
      ((RelativeLayout.LayoutParams)paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams()).leftMargin = actn.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramViewGroup.b = ((TextView)paramView.findViewById(2131377033));
      paramView.setTag(paramViewGroup);
      paramViewGroup.g.setBackgroundResource(2130839132);
      if (this.jdField_b_of_type_Int != 2) {
        break label279;
      }
      localObject = (DiscussionInfo)this.jdField_a_of_type_Aukm;
      paramViewGroup.jdField_a_of_type_JavaLangString = ((DiscussionInfo)localObject).uin;
      paramViewGroup.jdField_a_of_type_JavaLangObject = localObject;
      paramViewGroup.jdField_a_of_type_Int = 101;
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((DiscussionInfo)localObject).discussionName);
      paramViewGroup.b.setVisibility(0);
      paramViewGroup.b.setText(String.format("(%d)", new Object[] { Integer.valueOf(this.jdField_a_of_type_Ajvk.a(((DiscussionInfo)localObject).uin)) }));
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166861));
      a(paramView, paramInt2, paramViewGroup, paramOnClickListener);
      return paramView;
      paramViewGroup = (aiqv)paramView.getTag();
      break;
      label279:
      localObject = (TroopInfo)this.jdField_a_of_type_Aukm;
      paramViewGroup.jdField_a_of_type_JavaLangString = ((TroopInfo)localObject).troopuin;
      paramViewGroup.jdField_a_of_type_JavaLangObject = localObject;
      paramViewGroup.jdField_a_of_type_Int = 4;
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((TroopInfo)localObject).getTroopName());
      paramViewGroup.b.setVisibility(8);
    }
  }
  
  protected void a(int paramInt, bfvo[] paramArrayOfbfvo)
  {
    paramInt = 0;
    if ((paramArrayOfbfvo == null) || (paramArrayOfbfvo.length <= 0)) {}
    for (;;)
    {
      return;
      if (paramArrayOfbfvo.length < 0)
      {
        paramArrayOfbfvo[0].jdField_b_of_type_Int = 0;
        paramArrayOfbfvo[0].jdField_a_of_type_Int = 0;
        paramInt = 1;
      }
      while (paramInt < paramArrayOfbfvo.length)
      {
        paramArrayOfbfvo[paramInt].jdField_b_of_type_Int = -1;
        paramArrayOfbfvo[paramInt].jdField_a_of_type_Int = -1;
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
 * Qualified Name:     aiqu
 * JD-Core Version:    0.7.0.1
 */