import android.text.TextUtils;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask.2.1;
import com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask.2.2;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class akck
  implements akcl
{
  akck(akci paramakci) {}
  
  public void a(int paramInt)
  {
    if (akci.a(this.a) != null) {
      akci.a(this.a).a(paramInt);
    }
  }
  
  public void a(int paramInt, String paramString1, PublishVideoEntry paramPublishVideoEntry, String paramString2, long paramLong)
  {
    if ((paramInt == 0) && (paramPublishVideoEntry != null) && (paramString2 != null)) {
      akci.a(this.a).a(paramPublishVideoEntry, paramString2);
    }
    for (;;)
    {
      ThreadManager.excute(new EncodeVideoTask.2.2(this, paramInt, paramPublishVideoEntry, paramLong), 64, null, true);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("EncodeVideoTask", 2, new Object[] { "composite error, fakeVid:", akci.e(this.a), ", errorCode:", Integer.valueOf(paramInt), ", errorMsg:", paramString1 });
      }
      akci.a(this.a).a(paramInt);
    }
  }
  
  public void a(PublishVideoEntry paramPublishVideoEntry, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("EncodeVideoTask", 2, "generate files|onNext file: " + paramString);
    }
    if (akci.b(this.a))
    {
      b(paramPublishVideoEntry, paramString);
      return;
    }
    if ((paramPublishVideoEntry != null) && (!TextUtils.isEmpty(paramPublishVideoEntry.doodlePath)) && (bdhb.b(paramPublishVideoEntry.doodlePath)))
    {
      akci.a(paramString, paramPublishVideoEntry, akci.a(this.a));
      return;
    }
    b(paramPublishVideoEntry, paramString);
  }
  
  public void b(PublishVideoEntry paramPublishVideoEntry, String paramString)
  {
    ThreadManager.excute(new EncodeVideoTask.2.1(this, paramString, paramPublishVideoEntry), 64, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akck
 * JD-Core Version:    0.7.0.1
 */