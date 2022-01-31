import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.stickerrecommended.BloomFilter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;

class aemk
  implements axrt
{
  aemk(aemi paramaemi, String paramString1, boolean paramBoolean, String paramString2) {}
  
  public void onResp(axsq paramaxsq)
  {
    if (QLog.isColorLevel()) {
      QLog.i("StickerRecManager", 2, "onResp resultcode: " + paramaxsq.c + " threadid=" + Thread.currentThread().getId());
    }
    long l1;
    if ((paramaxsq.c == 200) && (aemi.a(this.jdField_a_of_type_Aemi, aemi.a(this.jdField_a_of_type_Aemi), aemi.b(this.jdField_a_of_type_Aemi), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean)))
    {
      if (!aemi.b(this.jdField_a_of_type_Aemi).exists()) {
        break label423;
      }
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecManager", 2, "pull words success");
      }
      l1 = 0L;
    }
    for (;;)
    {
      int i;
      try
      {
        long l2 = SystemClock.elapsedRealtime();
        l1 = l2;
        Object localObject = new JSONObject(bace.b(aemi.b(this.jdField_a_of_type_Aemi)));
        l1 = l2;
        paramaxsq = ((JSONObject)localObject).optString("version", null);
        l1 = l2;
        localObject = ((JSONObject)localObject).optJSONArray("words");
        l1 = l2;
        BloomFilter localBloomFilter = new BloomFilter();
        l1 = l2;
        localBloomFilter.version = paramaxsq;
        i = 0;
        l1 = l2;
        if (i < ((JSONArray)localObject).length())
        {
          l1 = l2;
          paramaxsq = ((JSONArray)localObject).optString(i);
          l1 = l2;
          if (TextUtils.isEmpty(paramaxsq)) {
            break label438;
          }
          l1 = l2;
          localBloomFilter.add(paramaxsq);
          break label438;
        }
        l1 = l2;
        bace.d(aemi.c(this.jdField_a_of_type_Aemi).getAbsolutePath());
        l1 = l2;
        aemi.a(this.jdField_a_of_type_Aemi, aemi.c(this.jdField_a_of_type_Aemi).getAbsolutePath(), localBloomFilter);
        l1 = l2;
        bace.d(aemi.b(this.jdField_a_of_type_Aemi).getAbsolutePath());
        l1 = l2;
        baig.d(aemi.a(this.jdField_a_of_type_Aemi).getApp(), "words_version_key805_gray_one", aemi.a(this.jdField_a_of_type_Aemi).c(), this.b);
        l1 = l2;
        this.jdField_a_of_type_Aemi.b();
        l1 = l2;
        if (QLog.isColorLevel())
        {
          l1 = l2;
          QLog.d("StickerRecManager", 2, "generate encode table time cost : " + (SystemClock.elapsedRealtime() - l2));
        }
        return;
      }
      catch (Exception paramaxsq)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("StickerRecManager", 2, "generate encode table time error cost : " + (SystemClock.elapsedRealtime() - l1));
        QLog.d("StickerRecManager", 2, "build EncodeTable error !");
        return;
      }
      label423:
      if (QLog.isColorLevel())
      {
        QLog.d("StickerRecManager", 2, "updateWords fail: words file is not exist.");
        return;
        label438:
        i += 1;
      }
    }
  }
  
  public void onUpdateProgeress(axsp paramaxsp, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aemk
 * JD-Core Version:    0.7.0.1
 */