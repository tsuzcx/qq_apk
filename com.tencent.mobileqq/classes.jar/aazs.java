import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import android.widget.TextView;
import com.qq.im.poi.LbsPackInfo;
import com.qq.im.poi.LbsPackManager;
import com.qq.im.poi.LbsPackMapInfo;
import com.qq.im.poi.LbsPackPoiInfo;
import com.qq.im.poi.LbsStrangerPoiDialog;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.armap.ARMapActivity;
import com.tencent.mobileqq.armap.ARMapManager;
import com.tencent.mobileqq.armap.ArMapInterface;
import com.tencent.mobileqq.armap.ArMapUtil;
import com.tencent.mobileqq.armap.config.ARMapConfig;
import com.tencent.mobileqq.armap.config.ARMapConfig.ResInfo;
import com.tencent.mobileqq.armap.config.OpenBoxCheckHander;
import com.tencent.mobileqq.armap.config.ShopScanCheckHandler;
import com.tencent.mobileqq.armap.config.ShopScanCheckHandler.Info;
import com.tencent.mobileqq.armap.map.ARGridMapViewDialog;
import com.tencent.mobileqq.armap.map.ARGridMapViewDialog.LbsRedBagExtraData;
import com.tencent.mobileqq.armap.map.ARGridMapViewDialog.POIExtarData;
import com.tencent.mobileqq.armap.map.ARMapPOIStarDialog;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import mqq.app.AppRuntime;

public class aazs
  implements Runnable
{
  public aazs(ARMapActivity paramARMapActivity, int paramInt1, int paramInt2, long paramLong1, long paramLong2, int paramInt3, String paramString1, String paramString2, String paramString3, int paramInt4, int paramInt5, double paramDouble1, double paramDouble2, Object paramObject) {}
  
  public void run()
  {
    if (!NetworkUtil.d(this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity)) {}
    label34:
    Object localObject1;
    label318:
    label323:
    label584:
    label599:
    label614:
    Object localObject3;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              QQToast.a(this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.getApplicationContext(), 2131437312, 1).b(this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.getTitleBarHeight());
                              break label34;
                              break label34;
                              break label34;
                              break label34;
                              break label34;
                              break label34;
                              break label34;
                              break label34;
                              break label34;
                              break label34;
                              break label34;
                              break label34;
                              do
                              {
                                return;
                              } while ((this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.app == null) || (this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.isFinishing()));
                              if ((this.jdField_a_of_type_Int == 6) && (this.jdField_b_of_type_Int == 1))
                              {
                                i = 1;
                                if (QLog.isDevelopLevel()) {
                                  QLog.i("ARMapActivity", 4, String.format(Locale.getDefault(), "onClickPOINode [taskType: %d, taskId: %d, poiId: %d, taskStatus: %d, distance: %d, jumpUrl: %s, busi:%s]", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), Long.valueOf(this.jdField_a_of_type_Long), Long.valueOf(this.jdField_b_of_type_Long), Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(this.jdField_c_of_type_Int), this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString }));
                                }
                                if (((this.jdField_c_of_type_Int <= ARMapActivity.jdField_a_of_type_Int) && (i == 0)) || (this.jdField_a_of_type_Int == 12)) {
                                  break label323;
                                }
                                if (this.jdField_a_of_type_Int != 11) {
                                  break label318;
                                }
                              }
                              for (int i = 3;; i = 0)
                              {
                                localObject1 = new ARGridMapViewDialog.POIExtarData(this.jdField_b_of_type_Long, this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.jdField_c_of_type_Int, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString);
                                ARMapActivity.a(this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity, new ARGridMapViewDialog(this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity, this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.app, ARMapActivity.a(this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity), this.d, this.e, i, localObject1, this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.jdField_e_of_type_Boolean));
                                ARMapActivity.a(this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity).setOnDismissListener(new aazt(this));
                                ARMapActivity.a(this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity).b();
                                return;
                                i = 0;
                                break;
                              }
                              if ((this.jdField_a_of_type_Int != 4) && (this.jdField_a_of_type_Int != 6) && (this.jdField_a_of_type_Int != 5) && (this.jdField_a_of_type_Int != 7)) {
                                break label614;
                              }
                              localObject1 = (ARMapManager)this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.app.getManager(209);
                              if (localObject1 == null) {
                                break label599;
                              }
                              localObject2 = ((ARMapManager)localObject1).a(true);
                              if (localObject2 == null) {
                                break label584;
                              }
                              localObject1 = ((ARMapConfig)localObject2).openBoxRes.url;
                              localObject2 = ((ARMapConfig)localObject2).openBoxRes.md5;
                              if ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty((CharSequence)localObject2))) {
                                break;
                              }
                            } while (this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.isFinishing());
                            if (this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.jdField_a_of_type_AndroidAppProgressDialog == null)
                            {
                              this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.jdField_a_of_type_AndroidAppProgressDialog = new ProgressDialog(this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity, 2131624516);
                              this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.jdField_a_of_type_AndroidAppProgressDialog.setCanceledOnTouchOutside(false);
                              this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.jdField_a_of_type_AndroidAppProgressDialog.show();
                              this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.jdField_a_of_type_AndroidAppProgressDialog.setContentView(2130969180);
                            }
                            ((TextView)this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131363399)).setText("正在加载...");
                            if (!this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.isFinishing()) {
                              this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.jdField_a_of_type_AndroidAppProgressDialog.show();
                            }
                            this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.jdField_a_of_type_ComTencentMobileqqArmapConfigOpenBoxCheckHander.a((String)localObject1, (String)localObject2, this.jdField_a_of_type_Int, this.jdField_a_of_type_Long, this.jdField_b_of_type_Long, this.jdField_c_of_type_Int, this.jdField_b_of_type_JavaLangString, true, this.jdField_a_of_type_JavaLangString);
                            return;
                          } while (!QLog.isColorLevel());
                          QLog.e("ARMapActivity", 2, "url or md5 is empty!");
                          return;
                        } while (!QLog.isColorLevel());
                        QLog.e("ARMapActivity", 2, "armapconfig is null!");
                        return;
                      } while (!QLog.isColorLevel());
                      QLog.e("ARMapActivity", 2, "armapmanager is null!");
                      return;
                      if (this.jdField_a_of_type_Int != 9) {
                        break;
                      }
                      localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity, QQBrowserActivity.class);
                      localObject2 = this.jdField_a_of_type_JavaLangString;
                      localObject3 = this.jdField_a_of_type_Double + "," + this.jdField_b_of_type_Double;
                      if (QLog.isColorLevel()) {
                        QLog.d("ARMapActivity", 2, "goto city eeg location: " + (String)localObject3);
                      }
                      localObject2 = URLUtil.a((String)localObject2, "slocation", new String(Base64.encode(((String)localObject3).getBytes(), 0)));
                      ((Intent)localObject1).putExtra("url", (String)localObject2);
                      this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.startActivity((Intent)localObject1);
                    } while (!QLog.isColorLevel());
                    QLog.d("ARMapActivity", 2, "goto city eeg url: " + (String)localObject2);
                    return;
                    if (this.jdField_a_of_type_Int != 11) {
                      break;
                    }
                    localObject1 = (ARMapManager)this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.app.getManager(209);
                  } while (localObject1 == null);
                  localObject1 = ((ARMapManager)localObject1).a(true);
                } while (localObject1 == null);
                ARMapActivity.a(this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity, new ARMapPOIStarDialog(this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity, this.jdField_a_of_type_Long, this.jdField_b_of_type_Long, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_Int, ((ARMapConfig)localObject1).starWebUrl, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.app));
                ARMapActivity.a(this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity).setOnDismissListener(new aazu(this));
                ARMapActivity.a(this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity).a(this.d, this.e);
                return;
                if (this.jdField_a_of_type_Int != 12) {
                  break;
                }
                localObject1 = (LbsPackManager)this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.getAppRuntime().getManager(214);
                localObject2 = ((LbsPackManager)localObject1).a();
              } while (localObject2 == null);
              localObject2 = (LbsPackPoiInfo)((LbsPackMapInfo)localObject2).a.get(Long.valueOf(this.jdField_b_of_type_Long));
            } while ((localObject2 == null) || (((LbsPackPoiInfo)localObject2).jdField_a_of_type_JavaUtilArrayList == null));
            if (QLog.isColorLevel()) {
              QLog.d("ARMapActivity", 2, "click node found poi=" + ((LbsPackPoiInfo)localObject2).jdField_a_of_type_Long + " num=" + ((LbsPackPoiInfo)localObject2).jdField_c_of_type_Int);
            }
          } while (((LbsPackPoiInfo)localObject2).jdField_a_of_type_JavaUtilArrayList.size() <= 0);
          localObject3 = (LbsPackInfo)((LbsPackPoiInfo)localObject2).jdField_a_of_type_JavaUtilArrayList.get(0);
        } while (localObject3 == null);
        if (((LbsPackInfo)localObject3).jdField_a_of_type_Int == 1)
        {
          ARMapActivity.a(this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity, new LbsStrangerPoiDialog(this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity, this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.app, this.jdField_b_of_type_Long, this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, ((LbsPackInfo)localObject3).jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.jdField_e_of_type_Long));
          ARMapActivity.a(this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity).a((LbsPackInfo)localObject3, ((LbsPackPoiInfo)localObject2).jdField_c_of_type_Int);
          ARMapActivity.a(this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity).setOnDismissListener(new aazv(this));
          ARMapActivity.a(this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity).a(this.d, this.e);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ARMapActivity", 2, "click node distance:" + this.jdField_c_of_type_Int + " lo2=" + this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.jdField_a_of_type_Double + " la2=" + this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.jdField_b_of_type_Double + " award=" + ((LbsPackManager)localObject1).a.g);
        }
        if (this.jdField_c_of_type_Int > ((LbsPackManager)localObject1).a.g)
        {
          localObject1 = new ARGridMapViewDialog.LbsRedBagExtraData(this.jdField_b_of_type_Long, this.jdField_a_of_type_Long, 12, this.jdField_c_of_type_Int, ((LbsPackInfo)localObject3).jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.jdField_e_of_type_Long);
          ARMapActivity.a(this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity, new ARGridMapViewDialog(this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity, this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.app, ARMapActivity.a(this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity), this.d, this.e, 2, localObject1, this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.jdField_e_of_type_Boolean));
          ARMapActivity.a(this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity).setOnDismissListener(new aazw(this));
          ARMapActivity.a(this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity).b();
          return;
        }
        localObject1 = ((LbsPackManager)localObject1).c();
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.jdField_a_of_type_AndroidAppProgressDialog == null)
          {
            this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.jdField_a_of_type_AndroidAppProgressDialog = new ProgressDialog(this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity, 2131624516);
            this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.jdField_a_of_type_AndroidAppProgressDialog.setCanceledOnTouchOutside(false);
            this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.jdField_a_of_type_AndroidAppProgressDialog.show();
            this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.jdField_a_of_type_AndroidAppProgressDialog.setContentView(2130969180);
          }
          ((TextView)this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131363399)).setText("正在加载资源...");
          if (!this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.isFinishing()) {
            this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.jdField_a_of_type_AndroidAppProgressDialog.show();
          }
          localObject1 = ((ARMapManager)this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.app.getManager(209)).a(true);
          this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.jdField_a_of_type_ComTencentMobileqqArmapConfigOpenBoxCheckHander.a(((ARMapConfig)localObject1).openBoxRes.url, ((ARMapConfig)localObject1).openBoxRes.md5, this.jdField_a_of_type_Int, this.jdField_a_of_type_Long, this.jdField_b_of_type_Long, this.jdField_c_of_type_Int, this.jdField_b_of_type_JavaLangString, true, "");
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.a("{}", this.jdField_a_of_type_Int, this.jdField_a_of_type_Long, this.jdField_b_of_type_Long, this.jdField_c_of_type_Int, this.jdField_b_of_type_JavaLangString, true, (String)localObject1, "");
        return;
      } while ((this.jdField_a_of_type_Int != 10) || (this.jdField_a_of_type_JavaLangObject == null) || (!(this.jdField_a_of_type_JavaLangObject instanceof Object[])) || (((Object[])this.jdField_a_of_type_JavaLangObject).length < 2));
      if (Math.abs(System.currentTimeMillis() - ARMapActivity.a(this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity)) >= 2000L) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ARMapActivity", 2, "onClickPoi, shop scan gap < 2000ms");
    return;
    ARMapActivity.a(this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity, System.currentTimeMillis());
    Object localObject2 = (Object[])this.jdField_a_of_type_JavaLangObject;
    if (localObject2[0] == null)
    {
      localObject1 = "";
      label1705:
      if (localObject2[1] != null) {
        break label1996;
      }
    }
    label1996:
    for (localObject2 = "";; localObject2 = localObject2[1].toString())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ARMapActivity", 2, "onClickPoi, taskType=10, xmlUrl=" + (String)localObject1 + ", imgrl=" + (String)localObject2);
      }
      if (ARMapActivity.a(this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity) == null) {
        ARMapActivity.a(this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity, new aazx(this));
      }
      if (ARMapActivity.a(this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity) == null)
      {
        ARMapActivity.a(this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity, new ShopScanCheckHandler(this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.app));
        ARMapActivity.a(this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity).a(ARMapActivity.a(this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity));
      }
      this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.jdField_a_of_type_AndroidOsHandler.removeMessages(8);
      this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.jdField_a_of_type_AndroidOsHandler.obtainMessage(8), 2000L);
      localObject3 = (ARMapManager)this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.app.getManager(209);
      if (localObject3 == null) {
        break;
      }
      ShopScanCheckHandler.Info localInfo = new ShopScanCheckHandler.Info();
      localInfo.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      localInfo.jdField_b_of_type_Long = this.jdField_a_of_type_Long;
      localInfo.jdField_a_of_type_Long = this.jdField_b_of_type_Long;
      localInfo.jdField_a_of_type_JavaLangString = ((String)localObject1);
      localInfo.jdField_b_of_type_JavaLangString = ArMapUtil.a((String)localObject1);
      localInfo.jdField_c_of_type_JavaLangString = ((String)localObject2);
      localInfo.d = ArMapUtil.a((String)localObject2);
      localInfo.i = ((ARMapManager)localObject3).a(true).shopScanTips;
      ARMapActivity.a(this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity).a(localInfo);
      return;
      localObject1 = localObject2[0].toString();
      break label1705;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aazs
 * JD-Core Version:    0.7.0.1
 */