import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.tencent.mobileqq.ar.ARNativeBridge;
import com.tencent.mobileqq.ar.ARRenderModel.ARWorldCupGlobalSceneRenderable;
import com.tencent.mobileqq.worldcup.ARWorldCupVideoInfo.BigScreenShowInfo;

class aagg
  implements Runnable
{
  aagg(aagf paramaagf, Bitmap paramBitmap, ARWorldCupVideoInfo.BigScreenShowInfo paramBigScreenShowInfo) {}
  
  public void run()
  {
    if (ARWorldCupGlobalSceneRenderable.a(this.jdField_a_of_type_Aagf.a) != null)
    {
      int[] arrayOfInt = new int[1];
      GLES20.glGenTextures(1, arrayOfInt, 0);
      int i = arrayOfInt[0];
      GLES20.glBindTexture(3553, i);
      GLES20.glTexParameterf(3553, 10241, 9728.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLUtils.texImage2D(3553, 0, this.jdField_a_of_type_AndroidGraphicsBitmap, 0);
      ARWorldCupGlobalSceneRenderable.a(this.jdField_a_of_type_Aagf.a).native_setBigScreenImageTexture(i);
      ARWorldCupGlobalSceneRenderable.a(this.jdField_a_of_type_Aagf.a).native_setBigScreenInfo(this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupVideoInfo$BigScreenShowInfo.c * this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupVideoInfo$BigScreenShowInfo.b, this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupVideoInfo$BigScreenShowInfo.d * this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupVideoInfo$BigScreenShowInfo.b, this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupVideoInfo$BigScreenShowInfo.e * this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupVideoInfo$BigScreenShowInfo.b, this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupVideoInfo$BigScreenShowInfo.f * this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupVideoInfo$BigScreenShowInfo.b, this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupVideoInfo$BigScreenShowInfo.g * this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupVideoInfo$BigScreenShowInfo.b);
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aagg
 * JD-Core Version:    0.7.0.1
 */