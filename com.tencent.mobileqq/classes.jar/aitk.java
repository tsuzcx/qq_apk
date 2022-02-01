import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.stickerrecommended.BloomFilter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;

class aitk
  implements beuq
{
  aitk(aiti paramaiti, String paramString1, boolean paramBoolean, String paramString2) {}
  
  public void onResp(bevm parambevm)
  {
    if (QLog.isColorLevel()) {
      QLog.i("StickerRecManager", 2, "onResp resultcode: " + parambevm.c + " threadid=" + Thread.currentThread().getId());
    }
    long l1;
    if ((parambevm.c == 200) && (aiti.a(this.jdField_a_of_type_Aiti, aiti.a(this.jdField_a_of_type_Aiti), aiti.b(this.jdField_a_of_type_Aiti), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean)))
    {
      if (!aiti.b(this.jdField_a_of_type_Aiti).exists()) {
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
        Object localObject = new JSONObject(bhmi.b(aiti.b(this.jdField_a_of_type_Aiti)));
        l1 = l2;
        parambevm = ((JSONObject)localObject).optString("version", null);
        l1 = l2;
        localObject = ((JSONObject)localObject).optJSONArray("words");
        l1 = l2;
        BloomFilter localBloomFilter = new BloomFilter();
        l1 = l2;
        localBloomFilter.version = parambevm;
        i = 0;
        l1 = l2;
        if (i < ((JSONArray)localObject).length())
        {
          l1 = l2;
          parambevm = ((JSONArray)localObject).optString(i);
          l1 = l2;
          if (TextUtils.isEmpty(parambevm)) {
            break label438;
          }
          l1 = l2;
          localBloomFilter.add(parambevm);
          break label438;
        }
        l1 = l2;
        bhmi.d(aiti.c(this.jdField_a_of_type_Aiti).getAbsolutePath());
        l1 = l2;
        aiti.a(this.jdField_a_of_type_Aiti, aiti.c(this.jdField_a_of_type_Aiti).getAbsolutePath(), localBloomFilter);
        l1 = l2;
        bhmi.d(aiti.b(this.jdField_a_of_type_Aiti).getAbsolutePath());
        l1 = l2;
        bhsi.d(aiti.a(this.jdField_a_of_type_Aiti).getApp(), "words_version_key805_gray_one", aiti.a(this.jdField_a_of_type_Aiti).c(), this.b);
        l1 = l2;
        this.jdField_a_of_type_Aiti.b();
        l1 = l2;
        if (QLog.isColorLevel())
        {
          l1 = l2;
          QLog.d("StickerRecManager", 2, "generate encode table time cost : " + (SystemClock.elapsedRealtime() - l2));
        }
        return;
      }
      catch (Exception parambevm)
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
  
  public void onUpdateProgeress(bevl parambevl, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aitk
 * JD-Core Version:    0.7.0.1
 */