import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.stickerrecommended.BloomFilter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;

class aexf
  implements aysa
{
  aexf(aexd paramaexd, String paramString1, boolean paramBoolean, String paramString2) {}
  
  public void onResp(aysx paramaysx)
  {
    if (QLog.isColorLevel()) {
      QLog.i("StickerRecManager", 2, "onResp resultcode: " + paramaysx.c + " threadid=" + Thread.currentThread().getId());
    }
    long l1;
    if ((paramaysx.c == 200) && (aexd.a(this.jdField_a_of_type_Aexd, aexd.a(this.jdField_a_of_type_Aexd), aexd.b(this.jdField_a_of_type_Aexd), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean)))
    {
      if (!aexd.b(this.jdField_a_of_type_Aexd).exists()) {
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
        Object localObject = new JSONObject(bbdj.b(aexd.b(this.jdField_a_of_type_Aexd)));
        l1 = l2;
        paramaysx = ((JSONObject)localObject).optString("version", null);
        l1 = l2;
        localObject = ((JSONObject)localObject).optJSONArray("words");
        l1 = l2;
        BloomFilter localBloomFilter = new BloomFilter();
        l1 = l2;
        localBloomFilter.version = paramaysx;
        i = 0;
        l1 = l2;
        if (i < ((JSONArray)localObject).length())
        {
          l1 = l2;
          paramaysx = ((JSONArray)localObject).optString(i);
          l1 = l2;
          if (TextUtils.isEmpty(paramaysx)) {
            break label438;
          }
          l1 = l2;
          localBloomFilter.add(paramaysx);
          break label438;
        }
        l1 = l2;
        bbdj.d(aexd.c(this.jdField_a_of_type_Aexd).getAbsolutePath());
        l1 = l2;
        aexd.a(this.jdField_a_of_type_Aexd, aexd.c(this.jdField_a_of_type_Aexd).getAbsolutePath(), localBloomFilter);
        l1 = l2;
        bbdj.d(aexd.b(this.jdField_a_of_type_Aexd).getAbsolutePath());
        l1 = l2;
        bbjn.d(aexd.a(this.jdField_a_of_type_Aexd).getApp(), "words_version_key805_gray_one", aexd.a(this.jdField_a_of_type_Aexd).c(), this.b);
        l1 = l2;
        this.jdField_a_of_type_Aexd.b();
        l1 = l2;
        if (QLog.isColorLevel())
        {
          l1 = l2;
          QLog.d("StickerRecManager", 2, "generate encode table time cost : " + (SystemClock.elapsedRealtime() - l2));
        }
        return;
      }
      catch (Exception paramaysx)
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
  
  public void onUpdateProgeress(aysw paramaysw, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aexf
 * JD-Core Version:    0.7.0.1
 */