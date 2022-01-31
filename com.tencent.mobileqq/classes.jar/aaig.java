import android.opengl.GLES20;
import com.tencent.mobileqq.ar.ARVideoUtil;
import com.tencent.mobileqq.ar.keying.KeyingBase.UserInterface;

class aaig
  implements KeyingBase.UserInterface
{
  aaig(aaif paramaaif) {}
  
  public void a()
  {
    GLES20.glUniform1i(aaif.a(this.a), aaif.b(this.a));
  }
  
  public void a(int paramInt)
  {
    aaif.a(this.a, GLES20.glGetUniformLocation(paramInt, "uDisplayType"));
    ARVideoUtil.a("glGetUniformLocation uDisplayType");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaig
 * JD-Core Version:    0.7.0.1
 */