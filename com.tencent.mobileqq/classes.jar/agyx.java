import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.stickerrecommended.BloomFilter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;

class agyx
  implements baug
{
  agyx(agyv paramagyv, String paramString1, boolean paramBoolean, String paramString2) {}
  
  public void onResp(bavf parambavf)
  {
    if (QLog.isColorLevel()) {
      QLog.i("StickerRecManager", 2, "onResp resultcode: " + parambavf.c + " threadid=" + Thread.currentThread().getId());
    }
    long l1;
    if ((parambavf.c == 200) && (agyv.a(this.jdField_a_of_type_Agyv, agyv.a(this.jdField_a_of_type_Agyv), agyv.b(this.jdField_a_of_type_Agyv), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean)))
    {
      if (!agyv.b(this.jdField_a_of_type_Agyv).exists()) {
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
        Object localObject = new JSONObject(bdhb.b(agyv.b(this.jdField_a_of_type_Agyv)));
        l1 = l2;
        parambavf = ((JSONObject)localObject).optString("version", null);
        l1 = l2;
        localObject = ((JSONObject)localObject).optJSONArray("words");
        l1 = l2;
        BloomFilter localBloomFilter = new BloomFilter();
        l1 = l2;
        localBloomFilter.version = parambavf;
        i = 0;
        l1 = l2;
        if (i < ((JSONArray)localObject).length())
        {
          l1 = l2;
          parambavf = ((JSONArray)localObject).optString(i);
          l1 = l2;
          if (TextUtils.isEmpty(parambavf)) {
            break label438;
          }
          l1 = l2;
          localBloomFilter.add(parambavf);
          break label438;
        }
        l1 = l2;
        bdhb.d(agyv.c(this.jdField_a_of_type_Agyv).getAbsolutePath());
        l1 = l2;
        agyv.a(this.jdField_a_of_type_Agyv, agyv.c(this.jdField_a_of_type_Agyv).getAbsolutePath(), localBloomFilter);
        l1 = l2;
        bdhb.d(agyv.b(this.jdField_a_of_type_Agyv).getAbsolutePath());
        l1 = l2;
        bdne.d(agyv.a(this.jdField_a_of_type_Agyv).getApp(), "words_version_key805_gray_one", agyv.a(this.jdField_a_of_type_Agyv).c(), this.b);
        l1 = l2;
        this.jdField_a_of_type_Agyv.b();
        l1 = l2;
        if (QLog.isColorLevel())
        {
          l1 = l2;
          QLog.d("StickerRecManager", 2, "generate encode table time cost : " + (SystemClock.elapsedRealtime() - l2));
        }
        return;
      }
      catch (Exception parambavf)
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
  
  public void onUpdateProgeress(bave parambave, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agyx
 * JD-Core Version:    0.7.0.1
 */