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

public class akms
  extends akmm
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2131693302 };
  private static final int[] jdField_b_of_type_ArrayOfInt = { 2130839330 };
  private static final int[] c = { 2131370214 };
  private alrk jdField_a_of_type_Alrk;
  private int jdField_b_of_type_Int;
  
  public akms(QQAppInterface paramQQAppInterface, Context paramContext, awge paramawge, int paramInt)
  {
    super(paramQQAppInterface, paramContext, paramawge);
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_Bibh = a(this.jdField_a_of_type_AndroidContentContext);
    if (paramInt == 2) {
      this.jdField_a_of_type_Alrk = ((alrk)paramQQAppInterface.getManager(53));
    }
    this.jdField_a_of_type_Int = 0;
  }
  
  public View a(int paramInt1, int paramInt2, View paramView, ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener)
  {
    Object localObject;
    if ((paramView == null) || (!(paramView.getTag() instanceof akmt)))
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559028, null);
      paramViewGroup = new akmt();
      paramView = this.jdField_a_of_type_Bibh.a(this.jdField_a_of_type_AndroidContentContext, paramView, paramViewGroup, -1);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377607));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367819));
      ((RelativeLayout.LayoutParams)paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams()).leftMargin = aepi.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramViewGroup.b = ((TextView)paramView.findViewById(2131377609));
      paramView.setTag(paramViewGroup);
      paramViewGroup.g.setBackgroundResource(2130839217);
      if (this.jdField_b_of_type_Int != 2) {
        break label279;
      }
      localObject = (DiscussionInfo)this.jdField_a_of_type_Awge;
      paramViewGroup.jdField_a_of_type_JavaLangString = ((DiscussionInfo)localObject).uin;
      paramViewGroup.jdField_a_of_type_JavaLangObject = localObject;
      paramViewGroup.jdField_a_of_type_Int = 101;
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((DiscussionInfo)localObject).discussionName);
      paramViewGroup.b.setVisibility(0);
      paramViewGroup.b.setText(String.format("(%d)", new Object[] { Integer.valueOf(this.jdField_a_of_type_Alrk.a(((DiscussionInfo)localObject).uin)) }));
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166910));
      a(paramView, paramInt2, paramViewGroup, paramOnClickListener);
      return paramView;
      paramViewGroup = (akmt)paramView.getTag();
      break;
      label279:
      localObject = (TroopInfo)this.jdField_a_of_type_Awge;
      paramViewGroup.jdField_a_of_type_JavaLangString = ((TroopInfo)localObject).troopuin;
      paramViewGroup.jdField_a_of_type_JavaLangObject = localObject;
      paramViewGroup.jdField_a_of_type_Int = 4;
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((TroopInfo)localObject).getTroopName());
      paramViewGroup.b.setVisibility(8);
    }
  }
  
  protected void a(int paramInt, bibj[] paramArrayOfbibj)
  {
    paramInt = 0;
    if ((paramArrayOfbibj == null) || (paramArrayOfbibj.length <= 0)) {}
    for (;;)
    {
      return;
      if (paramArrayOfbibj.length < 0)
      {
        paramArrayOfbibj[0].jdField_b_of_type_Int = 0;
        paramArrayOfbibj[0].jdField_a_of_type_Int = 0;
        paramInt = 1;
      }
      while (paramInt < paramArrayOfbibj.length)
      {
        paramArrayOfbibj[paramInt].jdField_b_of_type_Int = -1;
        paramArrayOfbibj[paramInt].jdField_a_of_type_Int = -1;
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
 * Qualified Name:     akms
 * JD-Core Version:    0.7.0.1
 */