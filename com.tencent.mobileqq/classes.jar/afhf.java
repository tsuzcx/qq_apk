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

public class afhf
  extends aekw
{
  public afhf(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  protected aekx a()
  {
    return new afhg(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, aekx paramaekx, View paramView, LinearLayout paramLinearLayout, aeov paramaeov)
  {
    int j = 0;
    paramaeov = (afhg)paramaekx;
    paramaekx = paramView;
    Object localObject1;
    Object localObject2;
    if (paramView == null)
    {
      paramaekx = new LinearLayout(paramLinearLayout.getContext());
      paramaekx.setOrientation(1);
      paramView = new LinearLayout.LayoutParams(-1, -2);
      paramView.topMargin = aekt.a(9.0F, paramLinearLayout.getContext().getResources());
      paramaekx.setLayoutParams(paramView);
      localObject1 = new LinearLayout(paramaekx.getContext());
      ((LinearLayout)localObject1).setOrientation(0);
      ((LinearLayout)localObject1).setGravity(1);
      paramaeov.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localObject1);
      paramView = new LinearLayout(paramaekx.getContext());
      paramView.setOrientation(0);
      localObject2 = new LinearLayout.LayoutParams(-1, -2);
      ((LinearLayout.LayoutParams)localObject2).leftMargin = aekt.a(52.0F, paramLinearLayout.getContext().getResources());
      ((LinearLayout.LayoutParams)localObject2).rightMargin = aekt.a(52.0F, paramLinearLayout.getContext().getResources());
      ((LinearLayout.LayoutParams)localObject2).topMargin = aekt.a(4.0F, paramLinearLayout.getContext().getResources());
      paramaekx.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      paramaekx.addView(paramView, (ViewGroup.LayoutParams)localObject2);
      paramaeov.b = new TextView(paramView.getContext());
      localObject1 = new LinearLayout.LayoutParams(-1, -2);
      paramView.addView(paramaeov.b, (ViewGroup.LayoutParams)localObject1);
      paramaeov.b.setTextColor(-8355712);
      paramaeov.b.setGravity(1);
      paramaeov.b.setSingleLine();
      paramaeov.b.setEllipsize(TextUtils.TruncateAt.END);
      paramaeov.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    int i;
    if ((paramMessageRecord instanceof MessageForEnterTroop))
    {
      localObject1 = (MessageForEnterTroop)paramMessageRecord;
      paramMessageRecord = this.jdField_a_of_type_AndroidContentContext.getString(2131697655);
      localObject2 = ((MessageForEnterTroop)localObject1).mList.iterator();
      for (i = 1; ((Iterator)localObject2).hasNext(); i = 0)
      {
        apah localapah = (apah)((Iterator)localObject2).next();
        paramView = paramMessageRecord;
        if (i == 0) {
          paramView = paramMessageRecord + ",";
        }
        paramMessageRecord = paramView + localapah.b;
      }
      paramaeov.b.setText(paramMessageRecord);
      i = ((MessageForEnterTroop)localObject1).mList.size();
      if (i <= 5) {
        break label727;
      }
      i = 5;
    }
    label727:
    for (;;)
    {
      int k = paramaeov.jdField_a_of_type_JavaUtilList.size();
      if (k < i) {
        while (j < i - k)
        {
          paramMessageRecord = new ImageView(paramaeov.jdField_a_of_type_AndroidWidgetLinearLayout.getContext());
          paramMessageRecord.setScaleType(ImageView.ScaleType.FIT_XY);
          int m = aekt.a(26.0F, paramLinearLayout.getContext().getResources());
          paramView = new LinearLayout.LayoutParams(m, m);
          paramView.leftMargin = aekt.a(4.0F, paramLinearLayout.getContext().getResources());
          paramView.rightMargin = aekt.a(4.0F, paramLinearLayout.getContext().getResources());
          paramaeov.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramMessageRecord, paramView);
          paramaeov.jdField_a_of_type_JavaUtilList.add(paramMessageRecord);
          j += 1;
        }
      }
      if (k > i)
      {
        j = k;
        while (j > i)
        {
          paramaeov.jdField_a_of_type_AndroidWidgetLinearLayout.removeView((View)paramaeov.jdField_a_of_type_JavaUtilList.get(j - 1));
          paramaeov.jdField_a_of_type_JavaUtilList.remove(j - 1);
          j -= 1;
        }
      }
      paramMessageRecord = paramaeov.jdField_a_of_type_JavaUtilList.iterator();
      paramView = ((MessageForEnterTroop)localObject1).mList.iterator();
      while ((paramMessageRecord.hasNext()) && (paramView.hasNext()))
      {
        paramLinearLayout = (ImageView)paramMessageRecord.next();
        paramaeov = (apah)paramView.next();
        paramLinearLayout.setImageDrawable(bcxb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramaeov.a));
      }
      return paramaekx;
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public bdlb[] a(View paramView)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afhf
 * JD-Core Version:    0.7.0.1
 */