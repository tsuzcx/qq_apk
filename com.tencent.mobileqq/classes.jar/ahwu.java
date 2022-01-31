import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import com.tencent.common.app.AppInterface;
import com.tencent.component.media.utils.BitmapUtils;
import com.tencent.mobileqq.activity.aio.zhitu.GifImageWithText;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituPicData;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituTextManager;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituTextManager.DrawTextParam;
import com.tencent.mobileqq.pic.compress.Utils;
import com.tencent.mobileqq.search.util.SearchUtils.GenerateGifWithTextCallback;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;

public final class ahwu
  implements Runnable
{
  public ahwu(String paramString1, String paramString2, List paramList, String paramString3, Rect paramRect, AppInterface paramAppInterface, SearchUtils.GenerateGifWithTextCallback paramGenerateGifWithTextCallback) {}
  
  public void run()
  {
    try
    {
      Object localObject1 = MD5Utils.d(this.jdField_a_of_type_JavaLangString);
      if (Utils.a(this.jdField_a_of_type_JavaLangString))
      {
        localObject3 = new GifImageWithText(new File(this.jdField_a_of_type_JavaLangString), false, 0.0F);
        localObject2 = ZhituTextManager.a().a(((GifImageWithText)localObject3).getWidth(), ((GifImageWithText)localObject3).getHeight(), this.b, this.jdField_a_of_type_JavaUtilList, this.c, this.jdField_a_of_type_AndroidGraphicsRect, 1, MD5Utils.d(this.jdField_a_of_type_JavaLangString), 0, Typeface.DEFAULT);
        ((GifImageWithText)localObject3).a((ZhituTextManager.DrawTextParam)localObject2);
        localObject3 = new ZhituPicData();
        ((ZhituPicData)localObject3).jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituTextManager$DrawTextParam = ((ZhituTextManager.DrawTextParam)localObject2);
        ((ZhituPicData)localObject3).b = true;
        ((ZhituPicData)localObject3).c = this.jdField_a_of_type_JavaLangString;
        ((ZhituPicData)localObject3).jdField_a_of_type_Boolean = true;
        ((ZhituPicData)localObject3).d = ((String)localObject1);
        ((ZhituPicData)localObject3).jdField_a_of_type_Int = 0;
        ((ZhituPicData)localObject3).e = ((String)localObject1);
        localObject1 = ZhituManager.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface).a((ZhituPicData)localObject3);
        if (QLog.isColorLevel()) {
          QLog.d("Q.uniteSearch.SearchUtils", 2, "generateGiftWithText: " + (String)localObject1);
        }
        this.jdField_a_of_type_ComTencentMobileqqSearchUtilSearchUtils$GenerateGifWithTextCallback.a((String)localObject1);
        return;
      }
      localObject1 = BitmapFactory.decodeFile(this.jdField_a_of_type_JavaLangString).copy(Bitmap.Config.ARGB_8888, true);
      Object localObject2 = new Rect(0, 0, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight());
      Object localObject3 = ZhituTextManager.a().a(((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight(), this.b, this.jdField_a_of_type_JavaUtilList, this.c, this.jdField_a_of_type_AndroidGraphicsRect, 1, MD5Utils.d(this.jdField_a_of_type_JavaLangString), 0, Typeface.DEFAULT);
      Canvas localCanvas = new Canvas((Bitmap)localObject1);
      int i = 0;
      while (i < ((ZhituTextManager.DrawTextParam)localObject3).jdField_a_of_type_ArrayOfFloat.length)
      {
        float f = ((Rect)localObject2).top + localObject3.jdField_a_of_type_ArrayOfFloat[i];
        if (((ZhituTextManager.DrawTextParam)localObject3).b != null) {
          localCanvas.drawText(localObject3.jdField_a_of_type_ArrayOfJavaLangString[i], ((Rect)localObject2).exactCenterX(), f, ((ZhituTextManager.DrawTextParam)localObject3).b);
        }
        localCanvas.drawText(localObject3.jdField_a_of_type_ArrayOfJavaLangString[i], ((Rect)localObject2).exactCenterX(), f, ((ZhituTextManager.DrawTextParam)localObject3).jdField_a_of_type_AndroidGraphicsPaint);
        i += 1;
      }
      localObject2 = this.jdField_a_of_type_JavaLangString + "_" + System.currentTimeMillis();
      BitmapUtils.saveBitmapToFile((Bitmap)localObject1, (String)localObject2);
      this.jdField_a_of_type_ComTencentMobileqqSearchUtilSearchUtils$GenerateGifWithTextCallback.a((String)localObject2);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("Q.uniteSearch.SearchUtils", 2, "generateGiftWithText: " + localException);
      this.jdField_a_of_type_ComTencentMobileqqSearchUtilSearchUtils$GenerateGifWithTextCallback.a(null);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        QLog.e("Q.uniteSearch.SearchUtils", 2, "generateGiftWithText: " + localOutOfMemoryError);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahwu
 * JD-Core Version:    0.7.0.1
 */