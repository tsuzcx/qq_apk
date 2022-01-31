import android.graphics.Bitmap;
import android.os.Message;
import com.tencent.mobileqq.musicgene.MusicGeneWebViewPlugin;
import com.tencent.mobileqq.musicgene.MusicPlayerActivity;

class aekq
  implements Runnable
{
  aekq(aekp paramaekp, int paramInt) {}
  
  public void run()
  {
    Object localObject = MusicGeneWebViewPlugin.a(this.jdField_a_of_type_Aekp.jdField_a_of_type_Aeky.c);
    if (localObject != null)
    {
      int i = ((Bitmap)localObject).getWidth();
      int j = ((Bitmap)localObject).getHeight();
      if (i * j > 8000)
      {
        double d = Math.sqrt(8000.0D / (i * j));
        Bitmap localBitmap = Bitmap.createScaledBitmap((Bitmap)localObject, (int)(i * d), (int)(j * d), true);
        ((Bitmap)localObject).recycle();
        localObject = Message.obtain(MusicPlayerActivity.a(this.jdField_a_of_type_Aekp.jdField_a_of_type_Aeko.a), 55);
        ((Message)localObject).arg1 = this.jdField_a_of_type_Int;
        ((Message)localObject).obj = localBitmap;
        ((Message)localObject).sendToTarget();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aekq
 * JD-Core Version:    0.7.0.1
 */