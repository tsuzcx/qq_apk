import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.activity.QQMapActivity.9.1;
import com.tencent.mobileqq.app.soso.LbsManagerService.OnLocationChangeListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;

public class aeaa
  extends LbsManagerService.OnLocationChangeListener
{
  public aeaa(QQMapActivity paramQQMapActivity, String paramString, boolean paramBoolean)
  {
    super(paramString, paramBoolean);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    String str;
    GeoPoint localGeoPoint;
    if ((paramSosoLbsInfo != null) && (paramSosoLbsInfo.mLocation != null) && (paramSosoLbsInfo.mLocation.address != null))
    {
      str = paramSosoLbsInfo.mLocation.address;
      if (QLog.isColorLevel()) {
        QLog.d("get_location", 2, "onLocationFinish errCode=" + paramInt);
      }
      if ((paramInt != 0) || (paramSosoLbsInfo == null) || (paramSosoLbsInfo.mLocation == null)) {
        break label546;
      }
      localGeoPoint = new GeoPoint((int)(paramSosoLbsInfo.mLocation.mLat02 * 1000000.0D), (int)(paramSosoLbsInfo.mLocation.mLon02 * 1000000.0D));
      if (this.a.s)
      {
        if (!this.a.k) {
          break label181;
        }
        label129:
        this.a.h();
        this.a.s = false;
      }
      if (this.a.k) {
        break label253;
      }
      this.a.a(localGeoPoint, str);
    }
    for (;;)
    {
      label181:
      label253:
      try
      {
        this.a.dismissDialog(0);
        return;
      }
      catch (IllegalArgumentException paramSosoLbsInfo) {}
      str = "";
      break;
      this.a.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(localGeoPoint.getLatitudeE6() / 1000000.0D, localGeoPoint.getLongitudeE6() / 1000000.0D)));
      this.a.g = str;
      this.a.c.setVisibility(0);
      this.a.a(localGeoPoint);
      break label129;
      this.a.z();
      long l = System.currentTimeMillis();
      if (l - this.a.jdField_a_of_type_Long > 5000L)
      {
        if ((this.a.e != null) && (this.a.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelPolyline == null))
        {
          double d = aaec.a(localGeoPoint.getLongitudeE6() / 1000000.0D, localGeoPoint.getLatitudeE6() / 1000000.0D, this.a.jdField_b_of_type_Double, this.a.jdField_a_of_type_Double);
          this.a.m();
          this.a.e.setText(aaec.a(d));
        }
        this.a.jdField_b_of_type_ComTencentMapLibBasemapDataGeoPoint = localGeoPoint;
        this.a.p = str;
        this.a.q = paramSosoLbsInfo.mLocation.name;
        if (this.a.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelMarker != null)
        {
          this.a.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelMarker.setPosition(new LatLng(this.a.jdField_b_of_type_ComTencentMapLibBasemapDataGeoPoint.getLatitudeE6() / 1000000.0D, this.a.jdField_b_of_type_ComTencentMapLibBasemapDataGeoPoint.getLongitudeE6() / 1000000.0D));
          this.a.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelMarker.setSnippet("");
          avgm.a(this.a.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelMarker);
        }
        if (QLog.isColorLevel()) {
          QLog.d("get_location", 2, "onLocationFinish, mSelfPoint=" + this.a.jdField_b_of_type_ComTencentMapLibBasemapDataGeoPoint + ",addr=" + str + ",poiName=" + this.a.q);
        }
        this.a.jdField_a_of_type_Long = l;
        continue;
        label546:
        this.a.y();
        new Handler().post(new QQMapActivity.9.1(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeaa
 * JD-Core Version:    0.7.0.1
 */