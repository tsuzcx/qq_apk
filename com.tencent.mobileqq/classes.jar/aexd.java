import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.stickerrecommended.BloomFilter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;

class aexd
  implements aysc
{
  aexd(aexb paramaexb, String paramString1, boolean paramBoolean, String paramString2) {}
  
  public void onResp(aysz paramaysz)
  {
    if (QLog.isColorLevel()) {
      QLog.i("StickerRecManager", 2, "onResp resultcode: " + paramaysz.c + " threadid=" + Thread.currentThread().getId());
    }
    long l1;
    if ((paramaysz.c == 200) && (aexb.a(this.jdField_a_of_type_Aexb, aexb.a(this.jdField_a_of_type_Aexb), aexb.b(this.jdField_a_of_type_Aexb), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean)))
    {
      if (!aexb.b(this.jdField_a_of_type_Aexb).exists()) {
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
        Object localObject = new JSONObject(bbdx.b(aexb.b(this.jdField_a_of_type_Aexb)));
        l1 = l2;
        paramaysz = ((JSONObject)localObject).optString("version", null);
        l1 = l2;
        localObject = ((JSONObject)localObject).optJSONArray("words");
        l1 = l2;
        BloomFilter localBloomFilter = new BloomFilter();
        l1 = l2;
        localBloomFilter.version = paramaysz;
        i = 0;
        l1 = l2;
        if (i < ((JSONArray)localObject).length())
        {
          l1 = l2;
          paramaysz = ((JSONArray)localObject).optString(i);
          l1 = l2;
          if (TextUtils.isEmpty(paramaysz)) {
            break label438;
          }
          l1 = l2;
          localBloomFilter.add(paramaysz);
          break label438;
        }
        l1 = l2;
        bbdx.d(aexb.c(this.jdField_a_of_type_Aexb).getAbsolutePath());
        l1 = l2;
        aexb.a(this.jdField_a_of_type_Aexb, aexb.c(this.jdField_a_of_type_Aexb).getAbsolutePath(), localBloomFilter);
        l1 = l2;
        bbdx.d(aexb.b(this.jdField_a_of_type_Aexb).getAbsolutePath());
        l1 = l2;
        bbkb.d(aexb.a(this.jdField_a_of_type_Aexb).getApp(), "words_version_key805_gray_one", aexb.a(this.jdField_a_of_type_Aexb).c(), this.b);
        l1 = l2;
        this.jdField_a_of_type_Aexb.b();
        l1 = l2;
        if (QLog.isColorLevel())
        {
          l1 = l2;
          QLog.d("StickerRecManager", 2, "generate encode table time cost : " + (SystemClock.elapsedRealtime() - l2));
        }
        return;
      }
      catch (Exception paramaysz)
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
  
  public void onUpdateProgeress(aysy paramaysy, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aexd
 * JD-Core Version:    0.7.0.1
 */