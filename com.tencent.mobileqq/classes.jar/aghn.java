import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.media.image.ImageManager;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.logicImp.PhotoListLogicDataline.1;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity.SendVideoInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.util.WeakReference;

public class aghn
  extends aggm
{
  protected aghn(NewPhotoListActivity paramNewPhotoListActivity)
  {
    super(paramNewPhotoListActivity);
  }
  
  public static aggh b(NewPhotoListActivity paramNewPhotoListActivity)
  {
    if ((jdField_a_of_type_Aggh == null) || (jdField_a_of_type_Aggh.jdField_a_of_type_MqqUtilWeakReference.get() != paramNewPhotoListActivity)) {}
    try
    {
      if ((jdField_a_of_type_Aggh == null) || (jdField_a_of_type_Aggh.jdField_a_of_type_MqqUtilWeakReference.get() != paramNewPhotoListActivity)) {
        jdField_a_of_type_Aggh = new aghn(paramNewPhotoListActivity);
      }
      return jdField_a_of_type_Aggh;
    }
    finally {}
  }
  
  public void a(Activity paramActivity, Intent paramIntent, ArrayList<String> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PhotoListActivity", 2, "sendPicAndVideoToDataline...");
    }
    paramIntent.setClassName("com.tencent.mobileqq", "com.dataline.activities.LiteActivity");
    paramIntent.addFlags(603979776);
    paramIntent.putExtra("param_compressInitTime", System.currentTimeMillis());
    paramIntent.putExtra("PhotoConst.PHOTO_PATHS", paramArrayList);
    paramActivity.startActivityForResult(paramIntent, 2);
    paramActivity.finish();
    baaf.a(paramActivity, false, false);
  }
  
  protected void a(Intent paramIntent, boolean paramBoolean)
  {
    int i2 = PhotoUtils.b(this.jdField_a_of_type_Aggg.a);
    Object localObject1 = new HashMap();
    int j = 0;
    int i = 0;
    int i1 = 0;
    int k = 0;
    while (i1 < this.jdField_a_of_type_Aggf.a.size())
    {
      localObject2 = (String)this.jdField_a_of_type_Aggf.a.get(i1);
      int m;
      if (ImageManager.isNetworkUrl((String)localObject2))
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
        if (((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a((String)localObject2) == 1)
        {
          localObject2 = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a((String)localObject2);
          n = j;
          m = i;
          if (localObject2 != null)
          {
            localObject3 = new SendVideoActivity.SendVideoInfo();
            ((SendVideoActivity.SendVideoInfo)localObject3).fileSize = ((LocalMediaInfo)localObject2).fileSize;
            ((SendVideoActivity.SendVideoInfo)localObject3).duration = ((LocalMediaInfo)localObject2).mDuration;
            ((HashMap)localObject1).put(Integer.valueOf(k), localObject3);
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
    Object localObject2 = String.valueOf(j);
    Object localObject3 = String.valueOf(i);
    if (!((HashMap)localObject1).isEmpty()) {
      paramIntent.putExtra("PhotoConst.VIDEO_INFOS", (Serializable)localObject1);
    }
    for (i = 1;; i = 0)
    {
      if ((aweg.b != 0L) && (System.currentTimeMillis() - aweg.b < 300000L)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoListActivity", 2, "PhotoListLogicDataline isConfirmed=" + paramBoolean + " allowUploadInXGTime=" + aweg.b);
        }
        if ((!badq.b(BaseApplicationImpl.getContext())) || (paramBoolean) || (i == 0)) {
          break;
        }
        localObject1 = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131653417);
        paramIntent = new PhotoListLogicDataline.1(this, paramIntent, i2, (String)localObject2, (String)localObject3);
        if (bbrm.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), 4, new agho(this, paramIntent))) {
          babr.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), 232, null, (String)localObject1, new aghp(this, paramIntent), new aghq(this)).show();
        }
        if (QLog.isColorLevel()) {
          QLog.i("PhotoListActivity", 2, "show datalinephoto_mobile_send_confirm dialog");
        }
        return;
      }
      a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), paramIntent, this.jdField_a_of_type_Aggf.a);
      awqx.b(null, "CliOper", "", "", "0X8009AB0", "0X8009AB0", i2, 0, (String)localObject2, (String)localObject3, "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aghn
 * JD-Core Version:    0.7.0.1
 */