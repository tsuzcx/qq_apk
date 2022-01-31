import android.opengl.GLES20;
import com.tencent.mobileqq.ar.ARVideoUtil;
import com.tencent.mobileqq.ar.keying.KeyingBase.UserInterface;

class aabr
  implements KeyingBase.UserInterface
{
  aabr(aabq paramaabq) {}
  
  public void a()
  {
    GLES20.glUniform1i(aabq.a(this.a), aabq.b(this.a));
  }
  
  public void a(int paramInt)
  {
    aabq.a(this.a, GLES20.glGetUniformLocation(paramInt, "uDisplayType"));
    ARVideoUtil.a("glGetUniformLocation uDisplayType");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aabr
 * JD-Core Version:    0.7.0.1
 */