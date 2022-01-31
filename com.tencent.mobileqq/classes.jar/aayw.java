import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.qq.im.poi.LbsPackInfo;
import com.qq.im.poi.LbsPackManager;
import com.qq.im.poi.LbsPackMapInfo;
import com.qq.im.poi.LbsPackObserver;
import com.qq.im.poi.LbsPackPoiInfo;
import com.tencent.mobileqq.armap.ARGLSurfaceView;
import com.tencent.mobileqq.armap.ARMapActivity;
import com.tencent.mobileqq.armap.ArMapInterface;
import com.tencent.mobileqq.armap.map.ARGridMapViewDialog;
import com.tencent.mobileqq.armap.map.ARGridMapViewDialog.LbsRedBagExtraData;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class aayw
  extends LbsPackObserver
{
  public aayw(ARMapActivity paramARMapActivity) {}
  
  public void changeMapViewAngle(double paramDouble1, double paramDouble2)
  {
    super.changeMapViewAngle(paramDouble1, paramDouble2);
    if ((this.a.jdField_a_of_type_ComTencentMobileqqArmapARGLSurfaceView != null) && (this.a.jdField_a_of_type_ComTencentMobileqqArmapMapARMapEngine != null) && (!this.a.isFinishing())) {
      this.a.jdField_a_of_type_ComTencentMobileqqArmapARGLSurfaceView.queueEvent(new aayz(this, paramDouble2, paramDouble1));
    }
  }
  
  public void onGetLBSPoiList(boolean paramBoolean, Bundle paramBundle)
  {
    super.onGetLBSPoiList(paramBoolean, paramBundle);
    LbsPackMapInfo localLbsPackMapInfo;
    Object localObject1;
    int i;
    if (paramBoolean)
    {
      paramBundle = (LbsPackManager)this.a.app.getManager(214);
      localLbsPackMapInfo = paramBundle.a;
      if (localLbsPackMapInfo != null)
      {
        this.a.d(localLbsPackMapInfo.f);
        if (localLbsPackMapInfo.f != paramBundle.b)
        {
          paramBundle.b = localLbsPackMapInfo.f;
          if (QLog.isColorLevel()) {
            QLog.d("LbsPack", 2, "updateLbsPackEntrance " + paramBundle.b);
          }
        }
      }
      if (localLbsPackMapInfo == null) {
        break label680;
      }
      paramBundle = localLbsPackMapInfo.c;
      if ((!TextUtils.isEmpty(paramBundle)) && (!TextUtils.equals(paramBundle, this.a.d)))
      {
        this.a.d = paramBundle;
        localObject1 = DialogUtil.a(this.a, 0);
        ((QQCustomDialog)localObject1).setMessage(paramBundle).setCancelable(true);
        ((QQCustomDialog)localObject1).setNegativeButton(2131433015, null);
        ((QQCustomDialog)localObject1).setPositiveButton(2131438017, new aayx(this, (QQCustomDialog)localObject1));
        if (!this.a.isFinishing()) {
          ((QQCustomDialog)localObject1).show();
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ARMapActivity", 2, "onGetLBSPoiList mLbsPid:" + this.a.i + " mNeedShowShareTooFar=" + this.a.k);
      }
      if (localLbsPackMapInfo != null)
      {
        i = localLbsPackMapInfo.d;
        if (QLog.isColorLevel()) {
          QLog.d("ARMapActivity", 2, "onGetLBSPoiList locationInterval:" + i);
        }
        this.a.g = i;
        ARMapActivity.a(this.a);
      }
      if ((StringUtil.a(this.a.i)) || (!this.a.k) || (localLbsPackMapInfo == null) || (localLbsPackMapInfo.a == null)) {
        break label840;
      }
      paramBundle = localLbsPackMapInfo.a.values().iterator();
    }
    label680:
    label838:
    for (;;)
    {
      if (!paramBundle.hasNext()) {
        break label840;
      }
      localObject1 = (LbsPackPoiInfo)paramBundle.next();
      if (((LbsPackPoiInfo)localObject1).jdField_a_of_type_JavaUtilArrayList != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ARMapActivity", 2, "onGetLBSPoiList pack size:" + ((LbsPackPoiInfo)localObject1).jdField_a_of_type_JavaUtilArrayList.size());
        }
        Iterator localIterator = ((LbsPackPoiInfo)localObject1).jdField_a_of_type_JavaUtilArrayList.iterator();
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label838;
          }
          Object localObject2 = (LbsPackInfo)localIterator.next();
          if (QLog.isColorLevel()) {
            QLog.d("ARMapActivity", 2, "onGetLBSPoiList pid:" + ((LbsPackInfo)localObject2).b);
          }
          if (this.a.i.equals(((LbsPackInfo)localObject2).b))
          {
            double d = LbsPackManager.a(((LbsPackPoiInfo)localObject1).b / 1000000.0D, ((LbsPackPoiInfo)localObject1).jdField_a_of_type_Int / 1000000.0D, this.a.jdField_a_of_type_Double, this.a.b);
            if (QLog.isColorLevel()) {
              QLog.d("ARMapActivity", 2, "onGetLBSPoiList distance:" + d + " lo1=" + ((LbsPackPoiInfo)localObject1).b + " la1=" + ((LbsPackPoiInfo)localObject1).jdField_a_of_type_Int + " lo2=" + this.a.jdField_a_of_type_Double + " la2=" + this.a.b + " award=" + localLbsPackMapInfo.g);
            }
            if (d > localLbsPackMapInfo.g)
            {
              if (ARMapActivity.a(this.a))
              {
                return;
                paramBundle = null;
                break;
              }
              int j = 10000001;
              i = j;
              if (((LbsPackPoiInfo)localObject1).jdField_a_of_type_JavaUtilArrayList != null)
              {
                i = j;
                if (((LbsPackPoiInfo)localObject1).jdField_a_of_type_JavaUtilArrayList.size() > 1) {
                  i = 10000000;
                }
              }
              localObject2 = new ARGridMapViewDialog.LbsRedBagExtraData(((LbsPackPoiInfo)localObject1).jdField_a_of_type_Long, i, 12, (int)d, ((LbsPackInfo)localObject2).b, this.a.jdField_e_of_type_Long);
              ARMapActivity.a(this.a, new ARGridMapViewDialog(this.a, this.a.app, ARMapActivity.a(this.a), ScreenUtil.jdField_a_of_type_Int / 2, ScreenUtil.b / 2, 2, localObject2, this.a.jdField_e_of_type_Boolean));
              ARMapActivity.a(this.a).setOnDismissListener(new aayy(this));
              ARMapActivity.a(this.a).show();
            }
          }
        }
      }
    }
    label840:
    this.a.i = "";
    this.a.k = false;
  }
  
  public void onGetRedPackPage(boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramBoolean) && (paramBundle != null) && (!StringUtil.a(this.a.j))) {}
    try
    {
      paramBundle = paramBundle.getParcelableArrayList("packInfoList").iterator();
      while (paramBundle.hasNext())
      {
        Object localObject = (Parcelable)paramBundle.next();
        if ((localObject instanceof LbsPackInfo))
        {
          localObject = (LbsPackInfo)localObject;
          if (this.a.j.equals(((LbsPackInfo)localObject).b))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ARMapActivity", 2, "onGetRedPackPage clear pid=" + this.a.j);
            }
            this.a.j = "";
          }
        }
      }
      return;
    }
    catch (Exception paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aayw
 * JD-Core Version:    0.7.0.1
 */