import android.os.AsyncTask;
import android.widget.TextView;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.qphone.base.util.QLog;
import org.apache.http.client.HttpClient;

public class abma
  extends AsyncTask<GeoPoint, Void, String>
{
  TextView jdField_a_of_type_AndroidWidgetTextView;
  protected GeoPoint a;
  protected HttpClient a;
  
  public abma(QQMapActivity paramQQMapActivity, GeoPoint paramGeoPoint, TextView paramTextView)
  {
    this.jdField_a_of_type_ComTencentMapLibBasemapDataGeoPoint = paramGeoPoint;
    this.jdField_a_of_type_AndroidWidgetTextView = paramTextView;
    this.jdField_a_of_type_AndroidWidgetTextView.setTag(this.jdField_a_of_type_ComTencentMapLibBasemapDataGeoPoint);
  }
  
  protected String a(GeoPoint... paramVarArgs)
  {
    int i = 0;
    if (i < 3)
    {
      if (isCancelled())
      {
        localObject = "";
        label17:
        return localObject;
      }
      paramVarArgs = bahp.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQMapActivity.getApplicationContext(), this.jdField_a_of_type_ComTencentMapLibBasemapDataGeoPoint.getLatitudeE6() / 1000000.0D, this.jdField_a_of_type_ComTencentMapLibBasemapDataGeoPoint.getLongitudeE6() / 1000000.0D, 3, this.jdField_a_of_type_OrgApacheHttpClientHttpClient);
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append(i).append(" time: ReverseGeocode.getFromLocation, address: ");
        if (paramVarArgs != null) {
          break label125;
        }
      }
      label125:
      for (Object localObject = "";; localObject = paramVarArgs)
      {
        QLog.i("fetch_address", 2, (String)localObject);
        if (paramVarArgs != null)
        {
          localObject = paramVarArgs;
          if (paramVarArgs.length() > 0) {
            break label17;
          }
        }
        i += 1;
        break;
      }
    }
    return "";
  }
  
  protected void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("fetch_address", 2, "get address finish, onPostExecute, result:" + paramString);
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      GeoPoint localGeoPoint = (GeoPoint)this.jdField_a_of_type_AndroidWidgetTextView.getTag();
      if ((localGeoPoint.getLatitudeE6() == this.jdField_a_of_type_ComTencentMapLibBasemapDataGeoPoint.getLatitudeE6()) && (localGeoPoint.getLongitudeE6() == this.jdField_a_of_type_ComTencentMapLibBasemapDataGeoPoint.getLongitudeE6()) && (paramString != null) && (paramString.length() > 0))
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityQQMapActivity.k) {
          break label115;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      }
    }
    return;
    label115:
    this.jdField_a_of_type_ComTencentMobileqqActivityQQMapActivity.g = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abma
 * JD-Core Version:    0.7.0.1
 */