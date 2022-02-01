import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder.UploadTask;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.qphone.base.util.QLog;

public class ahrw
  implements amhc
{
  public ahrw(ShortVideoRealItemBuilder paramShortVideoRealItemBuilder) {}
  
  public void a(int paramInt)
  {
    ShortVideoRealItemBuilder localShortVideoRealItemBuilder = this.a;
    if (ShortVideoRealItemBuilder.a(this.a) != null) {}
    for (long l = ShortVideoRealItemBuilder.a(this.a).uniseq;; l = -1L)
    {
      ShortVideoRealItemBuilder.a(localShortVideoRealItemBuilder, l);
      return;
    }
  }
  
  public void a(String paramString1, byte[] paramArrayOfByte1, String paramString2, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
  {
    if (QLog.isColorLevel())
    {
      paramArrayOfByte2 = new StringBuilder().append("onEncodeSuccess curMsg:");
      if (ShortVideoRealItemBuilder.a(this.a) == null) {
        break label120;
      }
    }
    label120:
    for (paramString2 = Long.valueOf(ShortVideoRealItemBuilder.a(this.a).uniseq);; paramString2 = "")
    {
      QLog.i("ShortVideoRealItemBuilder", 2, paramString2);
      if (ShortVideoRealItemBuilder.a(this.a) == null) {
        break;
      }
      ShortVideoRealItemBuilder.a(this.a).md5 = HexUtil.bytes2HexStr(paramArrayOfByte1);
      new ShortVideoRealItemBuilder.UploadTask(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, ShortVideoRealItemBuilder.a(this.a), paramString1, this.a).run();
      return;
    }
    bbnk.a(new RuntimeException("onMediaMessageSend failed"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahrw
 * JD-Core Version:    0.7.0.1
 */