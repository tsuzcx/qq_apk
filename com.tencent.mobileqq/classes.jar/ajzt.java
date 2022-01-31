import android.graphics.Bitmap;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.util.FaceDecoderImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;

public class ajzt
  extends TroopObserver
{
  private ajzt(FaceDecoderImpl paramFaceDecoderImpl) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (FaceDecoderImpl.a(this.a) == null) {}
    do
    {
      return;
      if (this.a.jdField_a_of_type_Ajzp != null)
      {
        Bitmap localBitmap = this.a.a(113, paramString, 0, (byte)1);
        if ((paramBoolean1) && (localBitmap != null))
        {
          this.a.jdField_a_of_type_Ajzp.onDecodeTaskCompleted(this.a.b + this.a.jdField_a_of_type_JavaUtilLinkedList.size(), 113, paramString, localBitmap);
          if (QLog.isColorLevel()) {
            QLog.i("Q.qqhead.FaceDecoderImpl", 2, "====faceDecoderImpl onUpdateNewTroopFaceIcon === isSuccess: " + paramBoolean1 + ", isComplete: " + paramBoolean2 + ",disUin: " + paramString + ",type: " + 113 + ",style: " + -1);
          }
        }
      }
    } while ((this.a.jdField_a_of_type_Boolean) || (this.a.jdField_a_of_type_JavaUtilLinkedList.isEmpty()) || (this.a.b >= this.a.jdField_a_of_type_Int));
    this.a.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajzt
 * JD-Core Version:    0.7.0.1
 */