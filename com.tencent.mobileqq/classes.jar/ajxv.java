import android.text.TextUtils;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask.2.1;
import com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask.2.2;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class ajxv
  implements ajxw
{
  ajxv(ajxt paramajxt) {}
  
  public void a(int paramInt)
  {
    if (ajxt.a(this.a) != null) {
      ajxt.a(this.a).a(paramInt);
    }
  }
  
  public void a(int paramInt, String paramString1, PublishVideoEntry paramPublishVideoEntry, String paramString2, long paramLong)
  {
    if ((paramInt == 0) && (paramPublishVideoEntry != null) && (paramString2 != null)) {
      ajxt.a(this.a).a(paramPublishVideoEntry, paramString2);
    }
    for (;;)
    {
      ThreadManager.excute(new EncodeVideoTask.2.2(this, paramInt, paramPublishVideoEntry, paramLong), 64, null, true);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("EncodeVideoTask", 2, new Object[] { "composite error, fakeVid:", ajxt.e(this.a), ", errorCode:", Integer.valueOf(paramInt), ", errorMsg:", paramString1 });
      }
      ajxt.a(this.a).a(paramInt);
    }
  }
  
  public void a(PublishVideoEntry paramPublishVideoEntry, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("EncodeVideoTask", 2, "generate files|onNext file: " + paramString);
    }
    if (ajxt.b(this.a))
    {
      b(paramPublishVideoEntry, paramString);
      return;
    }
    if ((paramPublishVideoEntry != null) && (!TextUtils.isEmpty(paramPublishVideoEntry.doodlePath)) && (bdcs.b(paramPublishVideoEntry.doodlePath)))
    {
      ajxt.a(paramString, paramPublishVideoEntry, ajxt.a(this.a));
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
 * Qualified Name:     ajxv
 * JD-Core Version:    0.7.0.1
 */