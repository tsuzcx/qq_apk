import android.content.Context;
import com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.mobileqq.surfaceviewaction.gl.Texture;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;

public class ailc
  implements Runnable
{
  public ailc(FrameSprite paramFrameSprite, Context paramContext, SpriteGLView paramSpriteGLView) {}
  
  public void run()
  {
    int j = 0;
    for (;;)
    {
      int i;
      try
      {
        long l = System.currentTimeMillis();
        i = 0;
        Object localObject;
        if ((i < FrameSprite.a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite).length) && (!FrameSprite.a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite)))
        {
          localObject = new Texture(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView, FrameSprite.a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite)[i]);
          FrameSprite.a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite, i, (Texture)localObject);
          i += 1;
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("FrameSprite", 2, "FrameSprite: read time = " + (System.currentTimeMillis() - l));
        }
        l = System.currentTimeMillis();
        i = j;
        if ((i < FrameSprite.a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite).length) && (!FrameSprite.a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite)))
        {
          if ((!FrameSprite.b(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite)) || (i % 2 == 0))
          {
            if (QLog.isColorLevel()) {
              QLog.d("FrameSprite", 2, "FrameSprite: deode:" + i);
            }
            localObject = this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite;
            if (FrameSprite.b(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite))
            {
              j = i / 2;
              FrameSprite.a((FrameSprite)localObject, j);
              if ((!FrameSprite.c(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite)) && ((i == this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite.a - 1) || (i == FrameSprite.a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite).length - 1)))
              {
                if ((FrameSprite.a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite) == 20) && ((int)(System.currentTimeMillis() - l) / this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite.a > 50))
                {
                  this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite.a(10);
                  FrameSprite.a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite, true);
                  if (QLog.isColorLevel()) {
                    QLog.d("FrameSprite", 2, "mIsHalf = true");
                  }
                  this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.b(new aild(this));
                }
                this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite.a();
              }
              if (FrameSprite.a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite) != null)
              {
                j = FrameSprite.a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite).size();
                int k = this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite.a;
                if (j >= k)
                {
                  try
                  {
                    Thread.sleep(16L);
                  }
                  catch (InterruptedException localInterruptedException) {}
                  continue;
                }
              }
            }
            else
            {
              j = i;
              continue;
            }
          }
        }
        else {
          return;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FrameSprite", 2, "FrameSprite: " + QLog.getStackTraceString(localException));
        }
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ailc
 * JD-Core Version:    0.7.0.1
 */