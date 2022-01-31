import android.content.Context;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForEnterTroop;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class adov
  extends actm
{
  public adov(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  protected actn a()
  {
    return new adow(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, actn paramactn, View paramView, LinearLayout paramLinearLayout, acxj paramacxj)
  {
    int j = 0;
    paramacxj = (adow)paramactn;
    paramactn = paramView;
    Object localObject1;
    Object localObject2;
    if (paramView == null)
    {
      paramactn = new LinearLayout(paramLinearLayout.getContext());
      paramactn.setOrientation(1);
      paramView = new LinearLayout.LayoutParams(-1, -2);
      paramView.topMargin = actj.a(9.0F, paramLinearLayout.getContext().getResources());
      paramactn.setLayoutParams(paramView);
      localObject1 = new LinearLayout(paramactn.getContext());
      ((LinearLayout)localObject1).setOrientation(0);
      ((LinearLayout)localObject1).setGravity(1);
      paramacxj.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localObject1);
      paramView = new LinearLayout(paramactn.getContext());
      paramView.setOrientation(0);
      localObject2 = new LinearLayout.LayoutParams(-1, -2);
      ((LinearLayout.LayoutParams)localObject2).leftMargin = actj.a(52.0F, paramLinearLayout.getContext().getResources());
      ((LinearLayout.LayoutParams)localObject2).rightMargin = actj.a(52.0F, paramLinearLayout.getContext().getResources());
      ((LinearLayout.LayoutParams)localObject2).topMargin = actj.a(4.0F, paramLinearLayout.getContext().getResources());
      paramactn.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      paramactn.addView(paramView, (ViewGroup.LayoutParams)localObject2);
      paramacxj.b = new TextView(paramView.getContext());
      localObject1 = new LinearLayout.LayoutParams(-1, -2);
      paramView.addView(paramacxj.b, (ViewGroup.LayoutParams)localObject1);
      paramacxj.b.setTextColor(-8355712);
      paramacxj.b.setGravity(1);
      paramacxj.b.setSingleLine();
      paramacxj.b.setEllipsize(TextUtils.TruncateAt.END);
      paramacxj.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    int i;
    if ((paramMessageRecord instanceof MessageForEnterTroop))
    {
      localObject1 = (MessageForEnterTroop)paramMessageRecord;
      paramMessageRecord = this.jdField_a_of_type_AndroidContentContext.getString(2131697480);
      localObject2 = ((MessageForEnterTroop)localObject1).mList.iterator();
      for (i = 1; ((Iterator)localObject2).hasNext(); i = 0)
      {
        anja localanja = (anja)((Iterator)localObject2).next();
        paramView = paramMessageRecord;
        if (i == 0) {
          paramView = paramMessageRecord + ",";
        }
        paramMessageRecord = paramView + localanja.b;
      }
      paramacxj.b.setText(paramMessageRecord);
      i = ((MessageForEnterTroop)localObject1).mList.size();
      if (i <= 5) {
        break label727;
      }
      i = 5;
    }
    label727:
    for (;;)
    {
      int k = paramacxj.jdField_a_of_type_JavaUtilList.size();
      if (k < i) {
        while (j < i - k)
        {
          paramMessageRecord = new ImageView(paramacxj.jdField_a_of_type_AndroidWidgetLinearLayout.getContext());
          paramMessageRecord.setScaleType(ImageView.ScaleType.FIT_XY);
          int m = actj.a(26.0F, paramLinearLayout.getContext().getResources());
          paramView = new LinearLayout.LayoutParams(m, m);
          paramView.leftMargin = actj.a(4.0F, paramLinearLayout.getContext().getResources());
          paramView.rightMargin = actj.a(4.0F, paramLinearLayout.getContext().getResources());
          paramacxj.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramMessageRecord, paramView);
          paramacxj.jdField_a_of_type_JavaUtilList.add(paramMessageRecord);
          j += 1;
        }
      }
      if (k > i)
      {
        j = k;
        while (j > i)
        {
          paramacxj.jdField_a_of_type_AndroidWidgetLinearLayout.removeView((View)paramacxj.jdField_a_of_type_JavaUtilList.get(j - 1));
          paramacxj.jdField_a_of_type_JavaUtilList.remove(j - 1);
          j -= 1;
        }
      }
      paramMessageRecord = paramacxj.jdField_a_of_type_JavaUtilList.iterator();
      paramView = ((MessageForEnterTroop)localObject1).mList.iterator();
      while ((paramMessageRecord.hasNext()) && (paramView.hasNext()))
      {
        paramLinearLayout = (ImageView)paramMessageRecord.next();
        paramacxj = (anja)paramView.next();
        paramLinearLayout.setImageDrawable(bayh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramacxj.a));
      }
      return paramactn;
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public bbmh[] a(View paramView)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adov
 * JD-Core Version:    0.7.0.1
 */