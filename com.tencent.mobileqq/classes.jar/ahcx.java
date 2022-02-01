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

public class ahcx
  extends agem
{
  public ahcx(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  protected agen a()
  {
    return new ahcy(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, agen paramagen, View paramView, LinearLayout paramLinearLayout, agjk paramagjk)
  {
    int j = 0;
    paramagjk = (ahcy)paramagen;
    paramagen = paramView;
    Object localObject1;
    Object localObject2;
    if (paramView == null)
    {
      paramagen = new LinearLayout(paramLinearLayout.getContext());
      paramagen.setOrientation(1);
      paramView = new LinearLayout.LayoutParams(-1, -2);
      paramView.topMargin = agej.a(9.0F, paramLinearLayout.getContext().getResources());
      paramagen.setLayoutParams(paramView);
      localObject1 = new LinearLayout(paramagen.getContext());
      ((LinearLayout)localObject1).setOrientation(0);
      ((LinearLayout)localObject1).setGravity(1);
      paramagjk.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localObject1);
      paramView = new LinearLayout(paramagen.getContext());
      paramView.setOrientation(0);
      localObject2 = new LinearLayout.LayoutParams(-1, -2);
      ((LinearLayout.LayoutParams)localObject2).leftMargin = agej.a(52.0F, paramLinearLayout.getContext().getResources());
      ((LinearLayout.LayoutParams)localObject2).rightMargin = agej.a(52.0F, paramLinearLayout.getContext().getResources());
      ((LinearLayout.LayoutParams)localObject2).topMargin = agej.a(4.0F, paramLinearLayout.getContext().getResources());
      paramagen.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      paramagen.addView(paramView, (ViewGroup.LayoutParams)localObject2);
      paramagjk.b = new TextView(paramView.getContext());
      localObject1 = new LinearLayout.LayoutParams(-1, -2);
      paramView.addView(paramagjk.b, (ViewGroup.LayoutParams)localObject1);
      paramagjk.b.setTextColor(-8355712);
      paramagjk.b.setGravity(1);
      paramagjk.b.setSingleLine();
      paramagjk.b.setEllipsize(TextUtils.TruncateAt.END);
      paramagjk.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    int i;
    if ((paramMessageRecord instanceof MessageForEnterTroop))
    {
      localObject1 = (MessageForEnterTroop)paramMessageRecord;
      paramMessageRecord = this.jdField_a_of_type_AndroidContentContext.getString(2131696542);
      localObject2 = ((MessageForEnterTroop)localObject1).mList.iterator();
      for (i = 1; ((Iterator)localObject2).hasNext(); i = 0)
      {
        arxc localarxc = (arxc)((Iterator)localObject2).next();
        paramView = paramMessageRecord;
        if (i == 0) {
          paramView = paramMessageRecord + ",";
        }
        paramMessageRecord = paramView + localarxc.b;
      }
      paramagjk.b.setText(paramMessageRecord);
      i = ((MessageForEnterTroop)localObject1).mList.size();
      if (i <= 5) {
        break label727;
      }
      i = 5;
    }
    label727:
    for (;;)
    {
      int k = paramagjk.jdField_a_of_type_JavaUtilList.size();
      if (k < i) {
        while (j < i - k)
        {
          paramMessageRecord = new ImageView(paramagjk.jdField_a_of_type_AndroidWidgetLinearLayout.getContext());
          paramMessageRecord.setScaleType(ImageView.ScaleType.FIT_XY);
          int m = agej.a(26.0F, paramLinearLayout.getContext().getResources());
          paramView = new LinearLayout.LayoutParams(m, m);
          paramView.leftMargin = agej.a(4.0F, paramLinearLayout.getContext().getResources());
          paramView.rightMargin = agej.a(4.0F, paramLinearLayout.getContext().getResources());
          paramagjk.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramMessageRecord, paramView);
          paramagjk.jdField_a_of_type_JavaUtilList.add(paramMessageRecord);
          j += 1;
        }
      }
      if (k > i)
      {
        j = k;
        while (j > i)
        {
          paramagjk.jdField_a_of_type_AndroidWidgetLinearLayout.removeView((View)paramagjk.jdField_a_of_type_JavaUtilList.get(j - 1));
          paramagjk.jdField_a_of_type_JavaUtilList.remove(j - 1);
          j -= 1;
        }
      }
      paramMessageRecord = paramagjk.jdField_a_of_type_JavaUtilList.iterator();
      paramView = ((MessageForEnterTroop)localObject1).mList.iterator();
      while ((paramMessageRecord.hasNext()) && (paramView.hasNext()))
      {
        paramLinearLayout = (ImageView)paramMessageRecord.next();
        paramagjk = (arxc)paramView.next();
        paramLinearLayout.setImageDrawable(aoot.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramagjk.a));
      }
      return paramagen;
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public bhum[] a(View paramView)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahcx
 * JD-Core Version:    0.7.0.1
 */