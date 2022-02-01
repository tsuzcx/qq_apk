import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.stickerrecommended.BloomFilter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;

class aijr
  implements bdvw
{
  aijr(aijp paramaijp, String paramString1, boolean paramBoolean, String paramString2) {}
  
  public void onResp(bdwt parambdwt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("StickerRecManager", 2, "onResp resultcode: " + parambdwt.c + " threadid=" + Thread.currentThread().getId());
    }
    long l1;
    if ((parambdwt.c == 200) && (aijp.a(this.jdField_a_of_type_Aijp, aijp.a(this.jdField_a_of_type_Aijp), aijp.b(this.jdField_a_of_type_Aijp), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean)))
    {
      if (!aijp.b(this.jdField_a_of_type_Aijp).exists()) {
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
        Object localObject = new JSONObject(bgmg.b(aijp.b(this.jdField_a_of_type_Aijp)));
        l1 = l2;
        parambdwt = ((JSONObject)localObject).optString("version", null);
        l1 = l2;
        localObject = ((JSONObject)localObject).optJSONArray("words");
        l1 = l2;
        BloomFilter localBloomFilter = new BloomFilter();
        l1 = l2;
        localBloomFilter.version = parambdwt;
        i = 0;
        l1 = l2;
        if (i < ((JSONArray)localObject).length())
        {
          l1 = l2;
          parambdwt = ((JSONArray)localObject).optString(i);
          l1 = l2;
          if (TextUtils.isEmpty(parambdwt)) {
            break label438;
          }
          l1 = l2;
          localBloomFilter.add(parambdwt);
          break label438;
        }
        l1 = l2;
        bgmg.d(aijp.c(this.jdField_a_of_type_Aijp).getAbsolutePath());
        l1 = l2;
        aijp.a(this.jdField_a_of_type_Aijp, aijp.c(this.jdField_a_of_type_Aijp).getAbsolutePath(), localBloomFilter);
        l1 = l2;
        bgmg.d(aijp.b(this.jdField_a_of_type_Aijp).getAbsolutePath());
        l1 = l2;
        bgsg.d(aijp.a(this.jdField_a_of_type_Aijp).getApp(), "words_version_key805_gray_one", aijp.a(this.jdField_a_of_type_Aijp).c(), this.b);
        l1 = l2;
        this.jdField_a_of_type_Aijp.b();
        l1 = l2;
        if (QLog.isColorLevel())
        {
          l1 = l2;
          QLog.d("StickerRecManager", 2, "generate encode table time cost : " + (SystemClock.elapsedRealtime() - l2));
        }
        return;
      }
      catch (Exception parambdwt)
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
  
  public void onUpdateProgeress(bdws parambdws, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aijr
 * JD-Core Version:    0.7.0.1
 */