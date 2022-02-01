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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForEnterTroop;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class agrz
  extends afor
{
  public agrz(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  protected afos a()
  {
    return new agsa(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, afos paramafos, View paramView, LinearLayout paramLinearLayout, aftk paramaftk)
  {
    int j = 0;
    paramaftk = (agsa)paramafos;
    paramafos = paramView;
    Object localObject1;
    Object localObject2;
    if (paramView == null)
    {
      paramafos = new LinearLayout(paramLinearLayout.getContext());
      paramafos.setOrientation(1);
      paramView = new LinearLayout.LayoutParams(-1, -2);
      paramView.topMargin = AIOUtils.dp2px(9.0F, paramLinearLayout.getContext().getResources());
      paramafos.setLayoutParams(paramView);
      localObject1 = new LinearLayout(paramafos.getContext());
      ((LinearLayout)localObject1).setOrientation(0);
      ((LinearLayout)localObject1).setGravity(1);
      paramaftk.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localObject1);
      paramView = new LinearLayout(paramafos.getContext());
      paramView.setOrientation(0);
      localObject2 = new LinearLayout.LayoutParams(-1, -2);
      ((LinearLayout.LayoutParams)localObject2).leftMargin = AIOUtils.dp2px(52.0F, paramLinearLayout.getContext().getResources());
      ((LinearLayout.LayoutParams)localObject2).rightMargin = AIOUtils.dp2px(52.0F, paramLinearLayout.getContext().getResources());
      ((LinearLayout.LayoutParams)localObject2).topMargin = AIOUtils.dp2px(4.0F, paramLinearLayout.getContext().getResources());
      paramafos.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      paramafos.addView(paramView, (ViewGroup.LayoutParams)localObject2);
      paramaftk.b = new TextView(paramView.getContext());
      localObject1 = new LinearLayout.LayoutParams(-1, -2);
      paramView.addView(paramaftk.b, (ViewGroup.LayoutParams)localObject1);
      paramaftk.b.setTextColor(-8355712);
      paramaftk.b.setGravity(1);
      paramaftk.b.setSingleLine();
      paramaftk.b.setEllipsize(TextUtils.TruncateAt.END);
      paramaftk.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    int i;
    if ((paramMessageRecord instanceof MessageForEnterTroop))
    {
      localObject1 = (MessageForEnterTroop)paramMessageRecord;
      paramMessageRecord = this.jdField_a_of_type_AndroidContentContext.getString(2131696950);
      localObject2 = ((MessageForEnterTroop)localObject1).mList.iterator();
      for (i = 1; ((Iterator)localObject2).hasNext(); i = 0)
      {
        aruj localaruj = (aruj)((Iterator)localObject2).next();
        paramView = paramMessageRecord;
        if (i == 0) {
          paramView = paramMessageRecord + ",";
        }
        paramMessageRecord = paramView + localaruj.b;
      }
      paramaftk.b.setText(paramMessageRecord);
      i = ((MessageForEnterTroop)localObject1).mList.size();
      if (i <= 5) {
        break label727;
      }
      i = 5;
    }
    label727:
    for (;;)
    {
      int k = paramaftk.jdField_a_of_type_JavaUtilList.size();
      if (k < i) {
        while (j < i - k)
        {
          paramMessageRecord = new ImageView(paramaftk.jdField_a_of_type_AndroidWidgetLinearLayout.getContext());
          paramMessageRecord.setScaleType(ImageView.ScaleType.FIT_XY);
          int m = AIOUtils.dp2px(26.0F, paramLinearLayout.getContext().getResources());
          paramView = new LinearLayout.LayoutParams(m, m);
          paramView.leftMargin = AIOUtils.dp2px(4.0F, paramLinearLayout.getContext().getResources());
          paramView.rightMargin = AIOUtils.dp2px(4.0F, paramLinearLayout.getContext().getResources());
          paramaftk.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramMessageRecord, paramView);
          paramaftk.jdField_a_of_type_JavaUtilList.add(paramMessageRecord);
          j += 1;
        }
      }
      if (k > i)
      {
        j = k;
        while (j > i)
        {
          paramaftk.jdField_a_of_type_AndroidWidgetLinearLayout.removeView((View)paramaftk.jdField_a_of_type_JavaUtilList.get(j - 1));
          paramaftk.jdField_a_of_type_JavaUtilList.remove(j - 1);
          j -= 1;
        }
      }
      paramMessageRecord = paramaftk.jdField_a_of_type_JavaUtilList.iterator();
      paramView = ((MessageForEnterTroop)localObject1).mList.iterator();
      while ((paramMessageRecord.hasNext()) && (paramView.hasNext()))
      {
        paramLinearLayout = (ImageView)paramMessageRecord.next();
        paramaftk = (aruj)paramView.next();
        paramLinearLayout.setImageDrawable(FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramaftk.a));
      }
      return paramafos;
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public bhjs[] a(View paramView)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agrz
 * JD-Core Version:    0.7.0.1
 */