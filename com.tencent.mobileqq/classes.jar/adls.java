import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.forward.ForwardSdkBaseOption;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgForAudioShare;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout2;
import com.tencent.mobileqq.structmsg.widget.HeightLimitedLinearLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class adls
{
  Context jdField_a_of_type_AndroidContentContext;
  View jdField_a_of_type_AndroidViewView;
  HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap(1);
  
  public adls(ForwardSdkBaseOption paramForwardSdkBaseOption, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public View a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqForwardForwardSdkBaseOption.a instanceof StructMsgForImageShare)) {
      return this.jdField_a_of_type_ComTencentMobileqqForwardForwardSdkBaseOption.a.getPreDialogView(this.jdField_a_of_type_AndroidContentContext, null);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqForwardForwardSdkBaseOption.a instanceof StructMsgForAudioShare)) {
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqForwardForwardSdkBaseOption.a.getPreDialogView(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidViewView);
    }
    for (;;)
    {
      return this.jdField_a_of_type_AndroidViewView;
      HeightLimitedLinearLayout localHeightLimitedLinearLayout = new HeightLimitedLinearLayout(this.jdField_a_of_type_AndroidContentContext);
      localHeightLimitedLinearLayout.setOrientation(1);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      localLayoutParams.gravity = 1;
      localHeightLimitedLinearLayout.setLayoutParams(localLayoutParams);
      localHeightLimitedLinearLayout.setMaxHeight(this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().heightPixels >> 1);
      this.jdField_a_of_type_AndroidViewView = localHeightLimitedLinearLayout;
      a();
    }
  }
  
  void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqForwardForwardSdkBaseOption.a == null) || (this.jdField_a_of_type_AndroidViewView == null)) {}
    label295:
    label296:
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqForwardForwardSdkBaseOption.a instanceof StructMsgForImageShare))
      {
        QLog.w("ForwardOption.ForwardSdkBaseOption", 1, "updateStructView|StructMsgForImageShare not supported！");
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqForwardForwardSdkBaseOption.a instanceof StructMsgForAudioShare))
      {
        this.jdField_a_of_type_ComTencentMobileqqForwardForwardSdkBaseOption.a.getPreDialogView(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidViewView);
        return;
      }
      Object localObject1 = new Bundle();
      ((Bundle)localObject1).putBoolean("pre_dialog", true);
      Object localObject2 = new ArrayList(1);
      Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqForwardForwardSdkBaseOption.a.getStructMsgItemLists().iterator();
      int i = 0;
      label116:
      if (localIterator.hasNext())
      {
        AbsStructMsgElement localAbsStructMsgElement = (AbsStructMsgElement)localIterator.next();
        View localView1 = (View)this.jdField_a_of_type_JavaUtilHashMap.get(localAbsStructMsgElement);
        View localView2 = localAbsStructMsgElement.a(this.jdField_a_of_type_AndroidContentContext, localView1, (Bundle)localObject1);
        if ((localView2 != null) && ((localAbsStructMsgElement instanceof StructMsgItemLayout2)))
        {
          TextView localTextView = (TextView)localView2.findViewById(2131361926);
          if (localTextView != null) {
            localTextView.setTextColor(-8355712);
          }
        }
        if ((localView2 == null) || (localView2 == localView1)) {
          break label295;
        }
        this.jdField_a_of_type_JavaUtilHashMap.put(localAbsStructMsgElement, localView2);
        ((List)localObject2).add(localView2);
        i = 1;
      }
      for (;;)
      {
        break label116;
        if (i == 0) {
          break label296;
        }
        ((ViewGroup)this.jdField_a_of_type_AndroidViewView).removeAllViewsInLayout();
        localObject1 = ((List)localObject2).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (View)((Iterator)localObject1).next();
          ((ViewGroup)this.jdField_a_of_type_AndroidViewView).addView((View)localObject2);
        }
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adls
 * JD-Core Version:    0.7.0.1
 */