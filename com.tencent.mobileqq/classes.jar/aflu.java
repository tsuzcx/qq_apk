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

public class aflu
  extends aepl
{
  public aflu(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  protected aepm a()
  {
    return new aflv(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, aepm paramaepm, View paramView, LinearLayout paramLinearLayout, aetk paramaetk)
  {
    int j = 0;
    paramaetk = (aflv)paramaepm;
    paramaepm = paramView;
    Object localObject1;
    Object localObject2;
    if (paramView == null)
    {
      paramaepm = new LinearLayout(paramLinearLayout.getContext());
      paramaepm.setOrientation(1);
      paramView = new LinearLayout.LayoutParams(-1, -2);
      paramView.topMargin = aepi.a(9.0F, paramLinearLayout.getContext().getResources());
      paramaepm.setLayoutParams(paramView);
      localObject1 = new LinearLayout(paramaepm.getContext());
      ((LinearLayout)localObject1).setOrientation(0);
      ((LinearLayout)localObject1).setGravity(1);
      paramaetk.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localObject1);
      paramView = new LinearLayout(paramaepm.getContext());
      paramView.setOrientation(0);
      localObject2 = new LinearLayout.LayoutParams(-1, -2);
      ((LinearLayout.LayoutParams)localObject2).leftMargin = aepi.a(52.0F, paramLinearLayout.getContext().getResources());
      ((LinearLayout.LayoutParams)localObject2).rightMargin = aepi.a(52.0F, paramLinearLayout.getContext().getResources());
      ((LinearLayout.LayoutParams)localObject2).topMargin = aepi.a(4.0F, paramLinearLayout.getContext().getResources());
      paramaepm.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      paramaepm.addView(paramView, (ViewGroup.LayoutParams)localObject2);
      paramaetk.b = new TextView(paramView.getContext());
      localObject1 = new LinearLayout.LayoutParams(-1, -2);
      paramView.addView(paramaetk.b, (ViewGroup.LayoutParams)localObject1);
      paramaetk.b.setTextColor(-8355712);
      paramaetk.b.setGravity(1);
      paramaetk.b.setSingleLine();
      paramaetk.b.setEllipsize(TextUtils.TruncateAt.END);
      paramaetk.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    int i;
    if ((paramMessageRecord instanceof MessageForEnterTroop))
    {
      localObject1 = (MessageForEnterTroop)paramMessageRecord;
      paramMessageRecord = this.jdField_a_of_type_AndroidContentContext.getString(2131697657);
      localObject2 = ((MessageForEnterTroop)localObject1).mList.iterator();
      for (i = 1; ((Iterator)localObject2).hasNext(); i = 0)
      {
        apeq localapeq = (apeq)((Iterator)localObject2).next();
        paramView = paramMessageRecord;
        if (i == 0) {
          paramView = paramMessageRecord + ",";
        }
        paramMessageRecord = paramView + localapeq.b;
      }
      paramaetk.b.setText(paramMessageRecord);
      i = ((MessageForEnterTroop)localObject1).mList.size();
      if (i <= 5) {
        break label727;
      }
      i = 5;
    }
    label727:
    for (;;)
    {
      int k = paramaetk.jdField_a_of_type_JavaUtilList.size();
      if (k < i) {
        while (j < i - k)
        {
          paramMessageRecord = new ImageView(paramaetk.jdField_a_of_type_AndroidWidgetLinearLayout.getContext());
          paramMessageRecord.setScaleType(ImageView.ScaleType.FIT_XY);
          int m = aepi.a(26.0F, paramLinearLayout.getContext().getResources());
          paramView = new LinearLayout.LayoutParams(m, m);
          paramView.leftMargin = aepi.a(4.0F, paramLinearLayout.getContext().getResources());
          paramView.rightMargin = aepi.a(4.0F, paramLinearLayout.getContext().getResources());
          paramaetk.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramMessageRecord, paramView);
          paramaetk.jdField_a_of_type_JavaUtilList.add(paramMessageRecord);
          j += 1;
        }
      }
      if (k > i)
      {
        j = k;
        while (j > i)
        {
          paramaetk.jdField_a_of_type_AndroidWidgetLinearLayout.removeView((View)paramaetk.jdField_a_of_type_JavaUtilList.get(j - 1));
          paramaetk.jdField_a_of_type_JavaUtilList.remove(j - 1);
          j -= 1;
        }
      }
      paramMessageRecord = paramaetk.jdField_a_of_type_JavaUtilList.iterator();
      paramView = ((MessageForEnterTroop)localObject1).mList.iterator();
      while ((paramMessageRecord.hasNext()) && (paramView.hasNext()))
      {
        paramLinearLayout = (ImageView)paramMessageRecord.next();
        paramaetk = (apeq)paramView.next();
        paramLinearLayout.setImageDrawable(bdbk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramaetk.a));
      }
      return paramaepm;
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public bdpk[] a(View paramView)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aflu
 * JD-Core Version:    0.7.0.1
 */