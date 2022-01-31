import android.content.Intent;
import com.tencent.component.media.image.ImageManager;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity.SendVideoInfo;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.util.WeakReference;

public class aguo
  extends agsj
{
  protected aguo(NewPhotoListActivity paramNewPhotoListActivity)
  {
    super(paramNewPhotoListActivity);
  }
  
  public static agsc b(NewPhotoListActivity paramNewPhotoListActivity)
  {
    if ((jdField_a_of_type_Agsc == null) || (jdField_a_of_type_Agsc.jdField_a_of_type_MqqUtilWeakReference.get() != paramNewPhotoListActivity)) {}
    try
    {
      if ((jdField_a_of_type_Agsc == null) || (jdField_a_of_type_Agsc.jdField_a_of_type_MqqUtilWeakReference.get() != paramNewPhotoListActivity)) {
        jdField_a_of_type_Agsc = new aguo(paramNewPhotoListActivity);
      }
      return jdField_a_of_type_Agsc;
    }
    finally {}
  }
  
  protected void a(Intent paramIntent, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    int i2 = PhotoUtils.b(this.jdField_a_of_type_Agsb.a);
    paramIntent = new HashMap();
    int i1 = 0;
    int k = 0;
    int j = 0;
    int i = 0;
    while (i1 < this.jdField_a_of_type_Agrz.a.size())
    {
      paramArrayList = (String)this.jdField_a_of_type_Agrz.a.get(i1);
      int m;
      if (ImageManager.isNetworkUrl(paramArrayList))
      {
        m = k;
        k = i;
        i = m;
        i1 += 1;
        m = k;
        k = i;
        i = m;
      }
      else
      {
        int n;
        if (((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(paramArrayList) == 1)
        {
          paramArrayList = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(paramArrayList);
          n = j;
          m = i;
          if (paramArrayList != null)
          {
            SendVideoActivity.SendVideoInfo localSendVideoInfo = new SendVideoActivity.SendVideoInfo();
            localSendVideoInfo.fileSize = paramArrayList.fileSize;
            localSendVideoInfo.duration = paramArrayList.mDuration;
            paramIntent.put(Integer.valueOf(k), localSendVideoInfo);
            m = i + 1;
            n = j;
          }
        }
        for (;;)
        {
          i = k + 1;
          j = n;
          k = m;
          break;
          n = j + 1;
          m = i;
        }
      }
    }
    axqy.b(null, "CliOper", "", "", "0X8009AB0", "0X8009AB0", i2, 0, String.valueOf(j), String.valueOf(i), "", "");
    i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aguo
 * JD-Core Version:    0.7.0.1
 */