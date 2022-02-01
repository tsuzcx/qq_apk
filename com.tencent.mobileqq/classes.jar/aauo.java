import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder.UploadTask;
import com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask.ResultListener;

class aauo
  implements EncodeVideoTask.ResultListener
{
  aauo(aaun paramaaun) {}
  
  public void onEncodeSuccess(String paramString1, byte[] paramArrayOfByte1, String paramString2, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
  {
    if (aaun.a(this.a) != null)
    {
      aaun.a(this.a).md5 = HexUtil.bytes2HexStr(paramArrayOfByte1);
      new ShortVideoRealItemBuilder.UploadTask(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, aaun.a(this.a), paramString1, this.a).run();
    }
  }
  
  public void onError(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aauo
 * JD-Core Version:    0.7.0.1
 */