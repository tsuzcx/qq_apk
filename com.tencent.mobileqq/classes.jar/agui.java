import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.stickerrecommended.BloomFilter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;

class agui
  implements bapx
{
  agui(agug paramagug, String paramString1, boolean paramBoolean, String paramString2) {}
  
  public void onResp(baqw parambaqw)
  {
    if (QLog.isColorLevel()) {
      QLog.i("StickerRecManager", 2, "onResp resultcode: " + parambaqw.c + " threadid=" + Thread.currentThread().getId());
    }
    long l1;
    if ((parambaqw.c == 200) && (agug.a(this.jdField_a_of_type_Agug, agug.a(this.jdField_a_of_type_Agug), agug.b(this.jdField_a_of_type_Agug), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean)))
    {
      if (!agug.b(this.jdField_a_of_type_Agug).exists()) {
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
        Object localObject = new JSONObject(bdcs.b(agug.b(this.jdField_a_of_type_Agug)));
        l1 = l2;
        parambaqw = ((JSONObject)localObject).optString("version", null);
        l1 = l2;
        localObject = ((JSONObject)localObject).optJSONArray("words");
        l1 = l2;
        BloomFilter localBloomFilter = new BloomFilter();
        l1 = l2;
        localBloomFilter.version = parambaqw;
        i = 0;
        l1 = l2;
        if (i < ((JSONArray)localObject).length())
        {
          l1 = l2;
          parambaqw = ((JSONArray)localObject).optString(i);
          l1 = l2;
          if (TextUtils.isEmpty(parambaqw)) {
            break label438;
          }
          l1 = l2;
          localBloomFilter.add(parambaqw);
          break label438;
        }
        l1 = l2;
        bdcs.d(agug.c(this.jdField_a_of_type_Agug).getAbsolutePath());
        l1 = l2;
        agug.a(this.jdField_a_of_type_Agug, agug.c(this.jdField_a_of_type_Agug).getAbsolutePath(), localBloomFilter);
        l1 = l2;
        bdcs.d(agug.b(this.jdField_a_of_type_Agug).getAbsolutePath());
        l1 = l2;
        bdiv.d(agug.a(this.jdField_a_of_type_Agug).getApp(), "words_version_key805_gray_one", agug.a(this.jdField_a_of_type_Agug).c(), this.b);
        l1 = l2;
        this.jdField_a_of_type_Agug.b();
        l1 = l2;
        if (QLog.isColorLevel())
        {
          l1 = l2;
          QLog.d("StickerRecManager", 2, "generate encode table time cost : " + (SystemClock.elapsedRealtime() - l2));
        }
        return;
      }
      catch (Exception parambaqw)
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
  
  public void onUpdateProgeress(baqv parambaqv, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agui
 * JD-Core Version:    0.7.0.1
 */