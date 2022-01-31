import android.opengl.GLES20;
import com.tencent.mobileqq.ar.ARVideoUtil;
import com.tencent.mobileqq.ar.keying.KeyingBase.UserInterface;

class aabu
  implements KeyingBase.UserInterface
{
  aabu(aabt paramaabt) {}
  
  public void a()
  {
    GLES20.glUniform1i(aabt.a(this.a), aabt.b(this.a));
  }
  
  public void a(int paramInt)
  {
    aabt.a(this.a, GLES20.glGetUniformLocation(paramInt, "uDisplayType"));
    ARVideoUtil.a("glGetUniformLocation uDisplayType");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aabu
 * JD-Core Version:    0.7.0.1
 */