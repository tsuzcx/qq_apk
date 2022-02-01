import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class aaap
  extends BroadcastReceiver
{
  public int a;
  public String a;
  public String b;
  
  private aaap(aaan paramaaan) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("bc_seq", -1);
    if (i < 0) {
      if (QLog.isColorLevel()) {
        QLog.d("PortalManager.HbEventPlugin", 2, "DataReceive | onReceive sequence = " + i + "| wrong seq");
      }
    }
    byte[] arrayOfByte;
    do
    {
      do
      {
        return;
        if (i == this.jdField_a_of_type_Int) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("PortalManager.HbEventPlugin", 2, "DataReceive | onReceive sequence != seq | miss hit");
      return;
      paramContext = paramIntent.getExtras();
      arrayOfByte = paramContext.getByteArray("bc_data");
      i = paramIntent.getIntExtra("portal_type_key", -1);
      if (arrayOfByte != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("PortalManager.HbEventPlugin", 2, "DataReceive | onReceive data = null");
    return;
    if (QLog.isColorLevel())
    {
      if (i != 1009) {
        break label286;
      }
      paramContext = "REQ_TYPE_GET_HEAD returned";
    }
    for (;;)
    {
      QLog.d("PortalManager.HbEventPlugin", 2, "DataReceiver.onReceive | " + i + "," + this.jdField_a_of_type_Int + "," + this.jdField_a_of_type_JavaLangString + "," + paramContext);
      switch (i)
      {
      default: 
        return;
      }
      this.jdField_a_of_type_Aaan.a(this.jdField_a_of_type_Int);
      paramIntent = ayja.b(arrayOfByte);
      paramContext = paramIntent;
      if (paramIntent == null) {
        paramContext = new JSONObject();
      }
      try
      {
        paramContext.put("errorCode", -1);
        paramContext = paramContext.toString();
        this.jdField_a_of_type_Aaan.a(this.jdField_a_of_type_JavaLangString, new String[] { paramContext });
        return;
        label286:
        paramContext = paramContext.toString();
      }
      catch (JSONException paramContext)
      {
        for (;;)
        {
          paramContext.printStackTrace();
          paramContext = paramIntent;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaap
 * JD-Core Version:    0.7.0.1
 */