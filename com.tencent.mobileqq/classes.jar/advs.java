import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.richmedia.RichmediaService;
import java.util.ArrayList;
import java.util.Iterator;

public class advs
{
  private static advs jdField_a_of_type_Advs;
  private final ArrayList<advu> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public static advs a()
  {
    if (jdField_a_of_type_Advs == null) {}
    try
    {
      if (jdField_a_of_type_Advs == null) {
        jdField_a_of_type_Advs = new advs();
      }
      return jdField_a_of_type_Advs;
    }
    finally {}
  }
  
  public static void a(Activity paramActivity)
  {
    if (paramActivity != null) {}
    try
    {
      bafb localbafb = babr.a(paramActivity, 230).setMessage(ajjy.a(2131634248)).setPositiveButton(paramActivity.getString(2131628445), new advt(paramActivity));
      if ((localbafb != null) && (!paramActivity.isFinishing())) {
        localbafb.show();
      }
      return;
    }
    catch (Throwable paramActivity)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("AIOGalleryMsgRevokeMgr", 0, "showDialog exception: " + paramActivity.getMessage());
    }
  }
  
  public static void a(Activity paramActivity, RelativeLayout paramRelativeLayout)
  {
    if ((paramActivity != null) && (paramRelativeLayout != null))
    {
      ImageView localImageView = new ImageView(paramActivity);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localImageView.setImageResource(2130844319);
      localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      paramRelativeLayout.addView(localImageView, localLayoutParams);
      a(paramActivity);
      awqx.b(null, "dc00898", "", "", "0X8009EB8", "0X8009EB8", 0, 0, "", "", "", "");
    }
  }
  
  public static void a(MessageRecord paramMessageRecord)
  {
    if (((paramMessageRecord instanceof MessageForPic)) || ((paramMessageRecord instanceof MessageForShortVideo)) || ((paramMessageRecord instanceof MessageForMarketFace)) || ((paramMessageRecord instanceof MessageForFile)) || ((paramMessageRecord instanceof MessageForTroopFile)) || ((paramMessageRecord instanceof MessageForMixedMsg)) || ((paramMessageRecord instanceof MessageForStructing)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("AIOGalleryMsgRevokeMgr", 0, "sendMsgRevokeRequest:" + paramMessageRecord);
      }
      Object localObject2 = a();
      if (localObject2 != null) {
        synchronized (((advs)localObject2).jdField_a_of_type_JavaUtilArrayList)
        {
          localObject2 = ((advs)localObject2).jdField_a_of_type_JavaUtilArrayList.iterator();
          if (((Iterator)localObject2).hasNext()) {
            ((advu)((Iterator)localObject2).next()).a(paramMessageRecord.uniseq);
          }
        }
      }
      ??? = RichmediaService.a();
      if (??? != null)
      {
        localObject2 = new Bundle();
        ((Bundle)localObject2).putLong("msg_revoke_uniseq", paramMessageRecord.uniseq);
        boolean bool = ((RichmediaService)???).a(300, -1, (Bundle)localObject2);
        if (QLog.isColorLevel()) {
          QLog.i("AIOGalleryMsgRevokeMgr", 0, "sendMsgRevokeRequest result:" + bool);
        }
      }
    }
  }
  
  public void a(advu paramadvu)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramadvu)) {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramadvu);
      }
      return;
    }
  }
  
  public void a(Bundle arg1)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("notifyMsgRevoke, mScene:");
      if (??? == null) {
        break label51;
      }
    }
    label51:
    for (Object localObject1 = ???.toString();; localObject1 = "")
    {
      QLog.i("AIOGalleryMsgRevokeMgr", 0, (String)localObject1);
      if (??? != null) {
        break;
      }
      return;
    }
    long l = ???.getLong("msg_revoke_uniseq", 0L);
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      if (((Iterator)localObject1).hasNext()) {
        ((advu)((Iterator)localObject1).next()).a(l);
      }
    }
  }
  
  public void b(advu paramadvu)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramadvu);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     advs
 * JD-Core Version:    0.7.0.1
 */