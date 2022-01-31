import android.content.Context;
import android.opengl.GLES20;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite;
import com.tencent.mobileqq.surfaceviewaction.util.GLUtil;
import com.tencent.mobileqq.troop.widget.TroopSignVideoView;
import java.io.File;

public class akby
  extends VideoSprite
{
  private int k = GLES20.glGetUniformLocation(this.h, "v_isShowCover");
  
  public akby(TroopSignVideoView paramTroopSignVideoView, SpriteGLView paramSpriteGLView, Context paramContext, boolean paramBoolean)
  {
    super(paramSpriteGLView, paramContext, paramBoolean);
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    if (TroopSignVideoView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView) == 0) {
      TroopSignVideoView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView, paramInt2);
    }
    super.a(paramInt1, TroopSignVideoView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView));
  }
  
  public String b()
  {
    return GLUtil.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.getContext(), "troop" + File.separator + "shaders" + File.separator + "FragmentShaderVideoForTroopSign.glsl");
  }
  
  protected void b(int paramInt1, int paramInt2)
  {
    if (this.jdField_e_of_type_JavaNioFloatBuffer == null) {
      return;
    }
    a(paramInt1, paramInt2);
    GLES20.glEnableVertexAttribArray(this.jdField_e_of_type_Int);
    GLES20.glVertexAttribPointer(this.jdField_e_of_type_Int, 2, 5126, false, 0, this.jdField_e_of_type_JavaNioFloatBuffer);
    GLES20.glBindTexture(3553, this.jdField_a_of_type_ArrayOfInt[0]);
    GLES20.glUniform1i(this.jdField_a_of_type_Int, 0);
    GLES20.glEnableVertexAttribArray(this.jdField_c_of_type_Int);
    GLES20.glVertexAttribPointer(this.jdField_c_of_type_Int, 4, 5126, false, 0, this.jdField_c_of_type_JavaNioFloatBuffer);
    if (this.jdField_f_of_type_Boolean)
    {
      GLES20.glUniform1i(this.g, 1);
      GLES20.glEnableVertexAttribArray(this.jdField_d_of_type_Int);
      GLES20.glVertexAttribPointer(this.jdField_d_of_type_Int, 4, 5126, false, 0, this.jdField_d_of_type_JavaNioFloatBuffer);
      paramInt2 = this.k;
      if (!TroopSignVideoView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView)) {
        break label205;
      }
    }
    label205:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      GLES20.glUniform1i(paramInt2, paramInt1);
      GLES20.glUniformMatrix4fv(this.jdField_f_of_type_Int, 1, false, this.jdField_f_of_type_ArrayOfFloat, 0);
      GLES20.glDrawElements(4, jdField_b_of_type_ArrayOfShort.length, 5123, this.jdField_b_of_type_JavaNioShortBuffer);
      GLES20.glDisableVertexAttribArray(this.jdField_e_of_type_Int);
      GLES20.glDisableVertexAttribArray(this.jdField_c_of_type_Int);
      GLES20.glDisableVertexAttribArray(this.jdField_d_of_type_Int);
      return;
      GLES20.glUniform1i(this.g, 0);
      break;
    }
  }
  
  protected void i()
  {
    super.i();
    this.k = GLES20.glGetUniformLocation(this.h, "v_isShowCover");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akby
 * JD-Core Version:    0.7.0.1
 */