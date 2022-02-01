import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.data.CardProfile;
import com.tencent.mobileqq.nearby.anim.NearbyZanAnimLayout;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SwipListView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class aetb
  extends Handler
{
  public aetb(VisitorsActivity paramVisitorsActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    int k = 2;
    int m = 1;
    Object localObject;
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      this.a.jdField_a_of_type_ComTencentWidgetSwipListView.springBackOverScrollHeaderView();
      return;
    case 4: 
      this.a.jdField_a_of_type_ComTencentWidgetSwipListView.springBackOverScrollHeaderView();
      return;
    case 2: 
      this.a.stopTitleProgress();
      this.a.jdField_a_of_type_ComTencentWidgetSwipListView.springBackOverScrollHeaderView();
      this.a.jdField_a_of_type_ComTencentWidgetSwipListView.springBackOverScrollHeaderView();
      this.a.a(1, this.a.getString(2131694064));
      return;
    case 3: 
      if (this.a.jdField_h_of_type_Int == 0) {
        this.a.jdField_a_of_type_Aetx.notifyDataSetChanged();
      }
      for (;;)
      {
        this.a.e = SystemClock.uptimeMillis();
        return;
        this.a.jdField_b_of_type_Aetx.notifyDataSetChanged();
      }
    case 5: 
      paramMessage = paramMessage.obj;
      if ((paramMessage instanceof Object[]))
      {
        localObject = (Object[])paramMessage;
        paramMessage = (ArrayList)localObject[0];
        localObject = (ArrayList)localObject[1];
        this.a.jdField_a_of_type_JavaUtilArrayList.addAll(paramMessage);
        this.a.jdField_b_of_type_JavaUtilArrayList.addAll((Collection)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("VisitorsActivity", 2, "setDataSet visitor UI_ONINIT");
        }
        this.a.jdField_a_of_type_Aetx.a(this.a.jdField_a_of_type_JavaUtilArrayList);
        if (QLog.isColorLevel()) {
          QLog.d("VisitorsActivity", 2, "setDataSet favor UI_ONINIT");
        }
        this.a.jdField_b_of_type_Aetx.a(this.a.jdField_b_of_type_JavaUtilArrayList);
        this.a.jdField_a_of_type_Aetx.notifyDataSetChanged();
        this.a.jdField_b_of_type_Aetx.notifyDataSetChanged();
      }
      this.a.jdField_h_of_type_Boolean = true;
      if (!NetworkUtil.isNetSupport(this.a))
      {
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 1000L);
        return;
      }
      this.a.a(true);
      return;
    case 6: 
      this.a.jdField_a_of_type_Ayro.b();
      return;
    case 7: 
      if (QLog.isColorLevel()) {
        QLog.d("VisitorsActivity", 2, "setDataSet fresh fav data");
      }
      this.a.jdField_b_of_type_Aetx.a(this.a.jdField_b_of_type_JavaUtilArrayList);
      this.a.jdField_b_of_type_Aetx.notifyDataSetChanged();
      return;
    case 8: 
      if (QLog.isColorLevel()) {
        QLog.d("VisitorsActivity", 2, "setDataSet fresh fav data");
      }
      this.a.jdField_a_of_type_Aetx.a(this.a.jdField_a_of_type_JavaUtilArrayList);
      this.a.jdField_a_of_type_Aetx.notifyDataSetChanged();
      return;
    case 9: 
      paramMessage = (CardProfile)paramMessage.obj;
      this.a.jdField_a_of_type_Ayro.a(paramMessage);
      return;
    case 10: 
      this.a.a(false, paramMessage.arg1, paramMessage.arg2, paramMessage.getData().getInt("totalVoteCount"));
      return;
    case 11: 
      int i = paramMessage.arg1;
      int n = paramMessage.arg2;
      int j;
      ayon localayon;
      float f1;
      float f2;
      if (i > 20)
      {
        i = 20;
        j = m;
        if (i > 0)
        {
          paramMessage = (Object[])paramMessage.obj;
          j = m;
          if (paramMessage != null)
          {
            j = m;
            if (paramMessage.length == 2)
            {
              int i1 = ((Integer)paramMessage[0]).intValue();
              localObject = this.a.jdField_a_of_type_ComTencentWidgetSwipListView;
              int i2 = ((XListView)localObject).getFirstVisiblePosition();
              int i3 = ((XListView)localObject).getLastVisiblePosition();
              j = m;
              if (i1 >= i2)
              {
                j = m;
                if (i1 <= i3)
                {
                  localObject = ((XListView)localObject).getChildAt(i1 - i2 + ((XListView)localObject).getHeaderViewsCount());
                  j = m;
                  if (localObject != null)
                  {
                    localObject = (TextView)((View)localObject).findViewById(2131379922);
                    j = m;
                    if (localObject != null)
                    {
                      int[] arrayOfInt = new int[2];
                      ((TextView)localObject).getLocationInWindow(arrayOfInt);
                      localayon = (ayon)paramMessage[1];
                      if (!TextUtils.isEmpty(localayon.jdField_b_of_type_JavaLangString)) {
                        break label929;
                      }
                      j = 1;
                      if (!TextUtils.isEmpty(((TextView)localObject).getText())) {
                        break label944;
                      }
                      m = arrayOfInt[0];
                      f1 = j * ((TextView)localObject).getWidth() / k + m;
                      j = arrayOfInt[1];
                      k = this.a.i;
                      f2 = ((TextView)localObject).getPaddingTop() + (j - k);
                      if ((n <= 0) || (localayon.c == null)) {
                        break label961;
                      }
                      this.a.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout.a(localayon, localayon.c, f1, f2);
                      i -= 1;
                      if (i <= 0) {
                        break label983;
                      }
                      paramMessage = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(11, i, n, paramMessage);
                      if (this.a.jdField_a_of_type_JavaUtilRandom == null) {
                        this.a.jdField_a_of_type_JavaUtilRandom = new Random();
                      }
                      i = aqvb.a[this.a.jdField_a_of_type_JavaUtilRandom.nextInt(aqvb.a.length)];
                      this.a.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramMessage, i * 5);
                    }
                  }
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        j = 0;
        if (j == 0) {
          break;
        }
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(12, 100L);
        return;
        break label542;
        label929:
        j = localayon.jdField_b_of_type_JavaLangString.length() + 1;
        break label718;
        k = ((TextView)localObject).getText().length() * 2;
        break label729;
        this.a.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout.a(localayon, localayon.jdField_b_of_type_AndroidGraphicsBitmap, f1, f2);
        break label811;
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(12, 2000L);
      }
    case 12: 
      label542:
      label718:
      label729:
      this.a.j = false;
      label811:
      label944:
      label961:
      label983:
      return;
    }
    this.a.b(paramMessage.arg1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aetb
 * JD-Core Version:    0.7.0.1
 */