import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import com.tencent.mobileqq.musicgene.BitmapAlgorithms;
import com.tencent.mobileqq.musicgene.MusicGeneWebViewPlugin;
import java.io.File;

public class aekm
  implements Runnable
{
  public aekm(MusicGeneWebViewPlugin paramMusicGeneWebViewPlugin, String paramString, int paramInt, File paramFile) {}
  
  public void run()
  {
    Object localObject1 = MusicGeneWebViewPlugin.a(this.jdField_a_of_type_JavaLangString);
    if (localObject1 != null) {
      if (this.jdField_a_of_type_Int <= 0) {
        break label87;
      }
    }
    label87:
    for (int i = this.jdField_a_of_type_Int;; i = 5)
    {
      Object localObject2 = BitmapAlgorithms.a((Bitmap)localObject1, 3, i, i);
      MusicGeneWebViewPlugin.a(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicGeneWebViewPlugin, (Bitmap)localObject2);
      localObject1 = Message.obtain(MusicGeneWebViewPlugin.a(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicGeneWebViewPlugin));
      ((Message)localObject1).obj = localObject2;
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("BUNDLE_KEY_FILE_PATH", this.jdField_a_of_type_JavaIoFile.getPath());
      ((Message)localObject1).setData((Bundle)localObject2);
      ((Message)localObject1).sendToTarget();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aekm
 * JD-Core Version:    0.7.0.1
 */