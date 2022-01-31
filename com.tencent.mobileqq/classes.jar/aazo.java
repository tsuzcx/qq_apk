import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.armap.ARGLSurfaceView;
import com.tencent.mobileqq.armap.ARMapActivity;
import com.tencent.mobileqq.armap.ArMapHandler.RespWealthGodInfo;
import com.tencent.mobileqq.armap.ArMapObserver;
import com.tencent.mobileqq.armap.ItemInfo;
import com.tencent.mobileqq.armap.POIInfo;
import com.tencent.mobileqq.armap.config.ARMapConfigManager;
import com.tencent.mobileqq.armap.map.ARMapPOIStarDialog;
import com.tencent.mobileqq.armap.wealthgod.WealthGodInfo;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class aazo
  extends ArMapObserver
{
  public aazo(ARMapActivity paramARMapActivity) {}
  
  public void onGetArMapAnimationInfo(boolean paramBoolean, String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArMapObserver", 2, "onGetArMapAnimationInfo isSucess:" + paramBoolean + " ,fullScreenAnimationInfo:" + paramString1 + "bigInsertScreenAnimation: " + paramString2 + "fullScreenTaskId: " + paramLong1 + "bigInsertTaskId: " + paramLong2);
    }
    if ((!paramBoolean) || (!TextUtils.isEmpty(paramString1))) {}
    while (TextUtils.isEmpty(paramString2)) {
      return;
    }
  }
  
  public void onGetPOIList(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArMapObserver", 2, "onGetPOIList in armapactivity isSuccess:" + paramBoolean + " mReqRedPacketCountRunning:" + ARMapActivity.b(this.a));
    }
    if ((paramObject != null) && (paramBoolean))
    {
      paramObject = (Object[])paramObject;
      if (paramObject.length < 6) {}
    }
    try
    {
      ((Integer)paramObject[0]).intValue();
      byte[] arrayOfByte = (byte[])paramObject[1];
      ((Long)paramObject[2]).longValue();
      ((Long)paramObject[3]).longValue();
      paramBoolean = ((Boolean)paramObject[4]).booleanValue();
      int i = ((Integer)paramObject[5]).intValue();
      if (QLog.isColorLevel()) {
        QLog.d("ArMapObserver", 2, "onGetPOIList in armapactivity hasPoiList:" + paramBoolean + "  mAdcode:" + this.a.e + " location interval: " + i);
      }
      if (paramBoolean) {
        ARMapActivity.a(this.a, true);
      }
      if ((!ARMapActivity.b(this.a)) && (ARMapActivity.c(this.a)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ArMapObserver", 2, "onGetPOIList in armapactivity start query");
        }
        ARMapActivity.b(this.a);
      }
      this.a.h = i;
      ARMapActivity.a(this.a);
      return;
    }
    catch (Exception paramObject)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ArMapObserver", 2, "onGetPOIList exception", paramObject);
    }
  }
  
  public void onGetWealthGodInfo(boolean paramBoolean, ArMapHandler.RespWealthGodInfo paramRespWealthGodInfo)
  {
    if (paramRespWealthGodInfo == null) {}
    int i;
    do
    {
      return;
      i = paramRespWealthGodInfo.jdField_a_of_type_Int;
    } while (i != 2);
    Object localObject = paramRespWealthGodInfo.jdField_a_of_type_JavaUtilList;
    long l3 = paramRespWealthGodInfo.jdField_a_of_type_Long;
    List localList = paramRespWealthGodInfo.b;
    boolean bool2 = paramRespWealthGodInfo.jdField_a_of_type_Boolean;
    if (QLog.isColorLevel()) {
      QLog.d("ArMapObserver", 2, "onGetWealthGodInfo isSuc=" + paramBoolean + " interval=" + l3 + " status：" + i + " displayCloud：" + bool2 + " wealthGodInfoList:" + localObject);
    }
    boolean bool1 = true;
    long l2 = -1L;
    int m;
    int n;
    int j;
    long l1;
    int k;
    long l4;
    if (paramBoolean)
    {
      m = 1;
      paramRespWealthGodInfo = ARMapConfigManager.a((List)localObject);
      ARMapActivity.a(this.a, paramRespWealthGodInfo);
      this.a.m = true;
      ARMapActivity.b(this.a, bool2);
      n = 0;
      j = 0;
      i = n;
      paramBoolean = bool1;
      l1 = l2;
      k = m;
      if (paramRespWealthGodInfo != null)
      {
        l4 = MessageCache.a() * 1000L;
        if ((paramRespWealthGodInfo.c < l4) && (paramRespWealthGodInfo.d > l4))
        {
          ARMapActivity.a(this.a, paramRespWealthGodInfo);
          if (paramRespWealthGodInfo.jdField_b_of_type_Long <= 0L)
          {
            paramBoolean = false;
            ARMapActivity.c(this.a, true);
            l2 = paramRespWealthGodInfo.d;
            if (ARMapActivity.d(this.a)) {
              j = 1;
            }
            i = j;
            l1 = l2;
            k = m;
            if (!QLog.isColorLevel()) {
              break label766;
            }
            QLog.d("ArMapObserver", 2, "onGetWealthGodInfo count = 0 & not display cloud");
            i = 1;
            paramBoolean = false;
            l1 = l2;
            label290:
            if (j == 0)
            {
              i = 1;
              if (QLog.isColorLevel()) {
                QLog.d("ArMapObserver", 2, "onGetWealthGodInfo 情况3 info:" + paramRespWealthGodInfo);
              }
              this.a.runOnUiThread(new aazq(this));
            }
            if (!ARMapActivity.e(this.a))
            {
              localObject = this.a;
              if (paramRespWealthGodInfo == null) {
                break label694;
              }
              paramRespWealthGodInfo = "" + paramRespWealthGodInfo.jdField_a_of_type_Long;
              label386:
              ARMapActivity.a((ARMapActivity)localObject, i, paramRespWealthGodInfo);
            }
          }
        }
      }
    }
    for (;;)
    {
      if (1000L * l3 >= 1000L) {
        this.a.jdField_b_of_type_Long = (1000L * l3);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ArMapObserver", 2, "onGetWealthGodInfo mQueryRedPacketCountIntervalMills=" + this.a.jdField_b_of_type_Long + "  continueReq:" + paramBoolean);
      }
      this.a.jdField_b_of_type_AndroidOsHandler.removeMessages(100);
      if (paramBoolean)
      {
        this.a.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(100, this.a.jdField_b_of_type_Long);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("ArMapObserver", 2, "onGetWealthGodInfo 情况1 count=" + paramRespWealthGodInfo.jdField_b_of_type_Long);
        }
        i = 4;
        paramBoolean = true;
        j = 1;
        l1 = l2;
        break label290;
        i = n;
        paramBoolean = bool1;
        l1 = l2;
        k = m;
        if (paramRespWealthGodInfo.c <= l4) {
          break label766;
        }
        j = 1;
        if (QLog.isColorLevel()) {
          QLog.d("ArMapObserver", 2, "onGetWealthGodInfo 情况2 info:" + paramRespWealthGodInfo);
        }
        this.a.a(paramRespWealthGodInfo);
        ARMapActivity.d(this.a, false);
        m = 2;
        i = j;
        paramBoolean = bool1;
        l1 = l2;
        k = m;
        if (ARMapActivity.e(this.a)) {
          break label766;
        }
        i = j;
        paramBoolean = bool1;
        l1 = l2;
        k = m;
        if (paramRespWealthGodInfo.c - l4 > 60000L) {
          break label766;
        }
        i = 3;
        paramBoolean = true;
        j = 1;
        l1 = l2;
        break label290;
        label694:
        paramRespWealthGodInfo = "";
        break label386;
      }
      ARMapActivity.e(this.a, false);
      l2 = MessageCache.a() * 1000L;
      if (l1 <= l2) {
        break;
      }
      l3 = (Math.random() * 10.0D * 60.0D * 1000.0D);
      this.a.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(100, l1 - l2 + l3);
      return;
      label766:
      j = i;
      i = k;
      break label290;
      paramBoolean = true;
      l1 = -1L;
    }
  }
  
  public void onOpenPOI(boolean paramBoolean1, int paramInt1, ItemInfo paramItemInfo, boolean paramBoolean2, int paramInt2, int paramInt3, boolean paramBoolean3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ArMapObserver", 2, "onOpenPoi isSuccess: " + paramBoolean1 + ", resultCode: " + paramInt1 + ", mode: " + paramInt3 + ", holder: " + paramBoolean2 + ", bussiType: " + paramInt2 + ", isServerSuccess: " + paramBoolean3 + ", itemInfo: " + paramItemInfo);
    }
    if ((paramItemInfo != null) && (paramItemInfo.a != null) && (paramItemInfo.a.jdField_a_of_type_Int == 11) && (paramItemInfo.e > 0) && ((ARMapActivity.a(this.a) == null) || (!ARMapActivity.a(this.a).isShowing())))
    {
      QQToast.a(this.a, 2131438772, 1).b(this.a.getResources().getDimensionPixelSize(2131558448));
      this.a.a.queueEvent(new aazp(this, paramItemInfo));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aazo
 * JD-Core Version:    0.7.0.1
 */