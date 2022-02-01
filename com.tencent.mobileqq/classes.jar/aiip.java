import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.stickerrecommended.BloomFilter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;

class aiip
  implements INetEngine.INetEngineListener
{
  aiip(aiin paramaiin, String paramString1, boolean paramBoolean, String paramString2) {}
  
  public void onResp(NetResp paramNetResp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("StickerRecManager", 2, "onResp resultcode: " + paramNetResp.mHttpCode + " threadid=" + Thread.currentThread().getId());
    }
    long l1;
    if ((paramNetResp.mHttpCode == 200) && (aiin.a(this.jdField_a_of_type_Aiin, aiin.a(this.jdField_a_of_type_Aiin), aiin.b(this.jdField_a_of_type_Aiin), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean)))
    {
      if (!aiin.b(this.jdField_a_of_type_Aiin).exists()) {
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
        Object localObject = new JSONObject(FileUtils.readFileToString(aiin.b(this.jdField_a_of_type_Aiin)));
        l1 = l2;
        paramNetResp = ((JSONObject)localObject).optString("version", null);
        l1 = l2;
        localObject = ((JSONObject)localObject).optJSONArray("words");
        l1 = l2;
        BloomFilter localBloomFilter = new BloomFilter();
        l1 = l2;
        localBloomFilter.version = paramNetResp;
        i = 0;
        l1 = l2;
        if (i < ((JSONArray)localObject).length())
        {
          l1 = l2;
          paramNetResp = ((JSONArray)localObject).optString(i);
          l1 = l2;
          if (TextUtils.isEmpty(paramNetResp)) {
            break label438;
          }
          l1 = l2;
          localBloomFilter.add(paramNetResp);
          break label438;
        }
        l1 = l2;
        FileUtils.deleteFile(aiin.c(this.jdField_a_of_type_Aiin).getAbsolutePath());
        l1 = l2;
        aiin.a(this.jdField_a_of_type_Aiin, aiin.c(this.jdField_a_of_type_Aiin).getAbsolutePath(), localBloomFilter);
        l1 = l2;
        FileUtils.deleteFile(aiin.b(this.jdField_a_of_type_Aiin).getAbsolutePath());
        l1 = l2;
        bhhr.d(aiin.a(this.jdField_a_of_type_Aiin).getApp(), "words_version_key805_gray_one", aiin.a(this.jdField_a_of_type_Aiin).getCurrentUin(), this.b);
        l1 = l2;
        this.jdField_a_of_type_Aiin.b();
        l1 = l2;
        if (QLog.isColorLevel())
        {
          l1 = l2;
          QLog.d("StickerRecManager", 2, "generate encode table time cost : " + (SystemClock.elapsedRealtime() - l2));
        }
        return;
      }
      catch (Exception paramNetResp)
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
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiip
 * JD-Core Version:    0.7.0.1
 */