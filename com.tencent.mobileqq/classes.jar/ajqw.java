import com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack;
import com.tencent.mobileqq.pic.PicInfoInterface.ErrInfo;
import com.tencent.mobileqq.pic.PicResult;
import com.tencent.mobileqq.pic.UiCallBack.DownAdapter;
import java.lang.ref.WeakReference;

public final class ajqw
  extends UiCallBack.DownAdapter
{
  public ajqw(WeakReference paramWeakReference, long paramLong1, int paramInt1, int paramInt2, long paramLong2, String paramString) {}
  
  public void a(int paramInt, PicResult paramPicResult)
  {
    IAIOImageProviderCallBack localIAIOImageProviderCallBack = (IAIOImageProviderCallBack)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localIAIOImageProviderCallBack != null)
    {
      if (paramPicResult.jdField_a_of_type_Int == 0) {
        localIAIOImageProviderCallBack.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 1, this.jdField_a_of_type_JavaLangString, paramPicResult.jdField_a_of_type_Boolean);
      }
    }
    else {
      return;
    }
    localIAIOImageProviderCallBack.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 2, "step:" + paramPicResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo.jdField_a_of_type_JavaLangString + ", desc:" + paramPicResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo.b, paramPicResult.jdField_a_of_type_Boolean);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    IAIOImageProviderCallBack localIAIOImageProviderCallBack = (IAIOImageProviderCallBack)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localIAIOImageProviderCallBack != null) {
      localIAIOImageProviderCallBack.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, paramInt, this.jdField_b_of_type_Long, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajqw
 * JD-Core Version:    0.7.0.1
 */