import com.tencent.mobileqq.magicface.DecoderUtil;
import com.tencent.mobileqq.magicface.model.MagicFaceSuperBigDecoder;
import com.tencent.mobileqq.magicface.model.MagicfaceDecoder.MagicfaceRenderListener;
import com.tencent.qphone.base.util.QLog;

public class adqp
  implements Runnable
{
  public adqp(MagicFaceSuperBigDecoder paramMagicFaceSuperBigDecoder) {}
  
  public void run()
  {
    long l2;
    label665:
    int i;
    label692:
    long l1;
    for (;;)
    {
      long l3;
      Object localObject;
      try
      {
        if (!QLog.isColorLevel()) {
          break label692;
        }
        QLog.d("MagicFaceSuperBigDecoder", 2, "func mDecoder.run begins, isStartDecodr:" + this.a.jdField_a_of_type_Boolean);
      }
      catch (Exception localException)
      {
        int j;
        localException.printStackTrace();
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("MagicFaceSuperBigDecoder", 2, "func mDecoder.run ends, error is catched.msg:" + localException.getMessage());
        return;
        this.a.h = j;
        this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.decodeAlphaDecoderReturnYUV(this.a.jdField_e_of_type_ArrayOfByte, this.a.g, this.a.jdField_f_of_type_ArrayOfByte);
        if (this.a.i != -1) {
          continue;
        }
        this.a.i = this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.getWidthAlphaDecoder();
        this.a.j = this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.getHeightAlphaDecoder();
        if (this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder$MagicfaceRenderListener == null) {
          continue;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder$MagicfaceRenderListener.a(this.a.jdField_c_of_type_ArrayOfByte, this.a.jdField_f_of_type_ArrayOfByte, this.a.jdField_e_of_type_Int, this.a.jdField_f_of_type_Int, 0.0F);
        l3 = System.currentTimeMillis() - l2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("MagicFaceSuperBigDecoder", 2, "func mDecoder.run, 【useFrameTime】 " + l3);
        if (l3 >= this.a.jdField_b_of_type_Int) {
          break label665;
        }
        if (localObject <= 0L) {
          continue;
        }
        l2 = this.a.jdField_b_of_type_Int - l3;
        if (l2 <= localObject) {
          break label711;
        }
        Thread.sleep(l2 - localObject);
        break label700;
        Thread.sleep(this.a.jdField_b_of_type_Int - l3);
        l2 = localObject;
        break label703;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        localOutOfMemoryError.printStackTrace();
        return;
      }
      if (!this.a.jdField_a_of_type_Boolean) {
        break;
      }
      l2 = System.currentTimeMillis();
      j = this.a.a(this.a.jdField_a_of_type_ArrayOfByte, this.a.jdField_d_of_type_Int);
      this.a.jdField_c_of_type_Int = (j - this.a.jdField_d_of_type_Int);
      if (this.a.jdField_c_of_type_Int <= 0)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("MagicFaceSuperBigDecoder", 2, "func mDecoder.run ends, 【condition】 frame len <= 0, videoFrameLength:" + this.a.jdField_c_of_type_Int);
        return;
      }
      this.a.a(this.a.jdField_c_of_type_Int, this.a.jdField_d_of_type_Int, this.a.jdField_a_of_type_ArrayOfByte);
      this.a.jdField_d_of_type_Int = j;
      this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.decodeVideoDecoderReturnYUV(this.a.jdField_b_of_type_ArrayOfByte, this.a.jdField_c_of_type_Int, this.a.jdField_c_of_type_ArrayOfByte);
      if (this.a.jdField_e_of_type_Int == -1)
      {
        this.a.jdField_e_of_type_Int = this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.getWidthVideoDecoder();
        this.a.jdField_f_of_type_Int = this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.getHeightVideoDecoder();
      }
      j = this.a.a(this.a.jdField_d_of_type_ArrayOfByte, this.a.h);
      this.a.g = (j - this.a.h);
      this.a.b(this.a.g, this.a.h, this.a.jdField_d_of_type_ArrayOfByte);
      if (this.a.g <= 0)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("MagicFaceSuperBigDecoder", 2, "func mDecoder.run ends, 【condition】 frame len <= 0, alphaFrameLength:" + this.a.g);
        return;
      }
      l2 = localObject;
      if (i != 0) {
        break label703;
      }
      i = this.a.jdField_b_of_type_Int;
      l2 = localObject + (l3 - i);
      break label703;
      l1 = 0L;
      i = 1;
    }
    return;
    for (;;)
    {
      label700:
      l2 = l1;
      label703:
      i = 0;
      l1 = l2;
      break;
      label711:
      l1 -= l2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adqp
 * JD-Core Version:    0.7.0.1
 */