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
import java.util.ArrayList;
import java.util.HashMap;
import mqq.util.WeakReference;

public class agtu
  extends agsj
{
  protected agtu(NewPhotoListActivity paramNewPhotoListActivity)
  {
    super(paramNewPhotoListActivity);
  }
  
  public static agsc b(NewPhotoListActivity paramNewPhotoListActivity)
  {
    if ((jdField_a_of_type_Agsc == null) || (jdField_a_of_type_Agsc.jdField_a_of_type_MqqUtilWeakReference.get() != paramNewPhotoListActivity)) {}
    try
    {
      if ((jdField_a_of_type_Agsc == null) || (jdField_a_of_type_Agsc.jdField_a_of_type_MqqUtilWeakReference.get() != paramNewPhotoListActivity)) {
        jdField_a_of_type_Agsc = new agtu(paramNewPhotoListActivity);
      }
      return jdField_a_of_type_Agsc;
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
    bbbx.a(paramActivity, false, false);
  }
  
  protected void a(Intent paramIntent, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    int i2 = PhotoUtils.b(this.jdField_a_of_type_Agsb.a);
    paramArrayList = new HashMap();
    int j = 0;
    int i = 0;
    int i1 = 0;
    int k = 0;
    while (i1 < this.jdField_a_of_type_Agrz.a.size())
    {
      localObject1 = (String)this.jdField_a_of_type_Agrz.a.get(i1);
      int m;
      if (ImageManager.isNetworkUrl((String)localObject1))
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
        if (((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a((String)localObject1) == 1)
        {
          localObject1 = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a((String)localObject1);
          n = j;
          m = i;
          if (localObject1 != null)
          {
            localObject2 = new SendVideoActivity.SendVideoInfo();
            ((SendVideoActivity.SendVideoInfo)localObject2).fileSize = ((LocalMediaInfo)localObject1).fileSize;
            ((SendVideoActivity.SendVideoInfo)localObject2).duration = ((LocalMediaInfo)localObject1).mDuration;
            paramArrayList.put(Integer.valueOf(k), localObject2);
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
    Object localObject1 = String.valueOf(j);
    Object localObject2 = String.valueOf(i);
    if (!paramArrayList.isEmpty()) {
      paramIntent.putExtra("PhotoConst.VIDEO_INFOS", paramArrayList);
    }
    for (i = 1;; i = 0)
    {
      if ((axdq.b != 0L) && (System.currentTimeMillis() - axdq.b < 300000L)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoListActivity", 2, "PhotoListLogicDataline isConfirmed=" + paramBoolean + " allowUploadInXGTime=" + axdq.b);
        }
        if ((!bbfj.b(BaseApplicationImpl.getContext())) || (paramBoolean) || (i == 0)) {
          break;
        }
        paramArrayList = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131719257);
        paramIntent = new PhotoListLogicDataline.1(this, paramIntent, i2, (String)localObject1, (String)localObject2);
        if (bcwb.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), 4, new agtv(this, paramIntent))) {
          bbdj.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), 232, null, paramArrayList, new agtw(this, paramIntent), new agtx(this)).show();
        }
        if (QLog.isColorLevel()) {
          QLog.i("PhotoListActivity", 2, "show datalinephoto_mobile_send_confirm dialog");
        }
        return;
      }
      a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), paramIntent, this.jdField_a_of_type_Agrz.a);
      axqy.b(null, "CliOper", "", "", "0X8009AB0", "0X8009AB0", i2, 0, (String)localObject1, (String)localObject2, "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agtu
 * JD-Core Version:    0.7.0.1
 */