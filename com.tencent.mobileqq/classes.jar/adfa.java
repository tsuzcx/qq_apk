import android.graphics.Typeface;
import android.text.TextUtils;
import com.etrump.mixlayout.ETEngine;
import com.tencent.mobileqq.hiboom.HiBoomFont;
import com.tencent.mobileqq.hiboom.HiBoomFont.HiBoomFontDownloader;
import com.tencent.mobileqq.hiboom.HiBoomFontDrawer;
import com.tencent.mobileqq.hiboom.HiBoomInfo;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

public class adfa
  implements Runnable
{
  public adfa(HiBoomFontDrawer paramHiBoomFontDrawer, boolean paramBoolean) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFontDrawer.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFontDrawer.a();
    if (this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFontDrawer.jdField_a_of_type_Int == 1)
    {
      if (!HiBoomFont.a().jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        HiBoomFont.a().b();
      }
      if (HiBoomFont.a().jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
      {
        if (!new File(this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFontDrawer.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFont$HiBoomFontDownloader.a() + this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFontDrawer.jdField_b_of_type_Int + File.separator + this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFontDrawer.jdField_b_of_type_Int + ".hy").exists()) {
          break label274;
        }
        if (HiBoomFont.a().jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_isFontLoaded(this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFontDrawer.jdField_b_of_type_Int)) {
          break label260;
        }
        boolean bool = HiBoomFont.a().jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_loadFont(this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFontDrawer.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFont$HiBoomFontDownloader.a() + this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFontDrawer.jdField_b_of_type_Int + File.separator + this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFontDrawer.jdField_b_of_type_Int + ".hy", this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFontDrawer.jdField_b_of_type_Int, false);
        this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFontDrawer.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(bool);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFontDrawer.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        HiBoomFontDrawer.a(this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFontDrawer);
      }
      this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFontDrawer.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      return;
      label260:
      this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFontDrawer.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      continue;
      label274:
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFontDrawer.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFont$HiBoomFontDownloader.a(this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFontDrawer.jdField_b_of_type_Int);
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFontDrawer.jdField_a_of_type_Int == 2)
        {
          File localFile = new File(this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFontDrawer.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFont$HiBoomFontDownloader.a() + this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFontDrawer.jdField_b_of_type_Int + File.separator + this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFontDrawer.jdField_b_of_type_Int + ".hb");
          String str = FileUtils.a(localFile, -1);
          if (!TextUtils.isEmpty(str))
          {
            this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFontDrawer.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomInfo = HiBoomInfo.a(str);
            if (this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFontDrawer.jdField_a_of_type_AndroidGraphicsTypeface == null) {
              this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFontDrawer.jdField_a_of_type_AndroidGraphicsTypeface = Typeface.createFromFile(this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFontDrawer.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFont$HiBoomFontDownloader.a() + this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFontDrawer.jdField_b_of_type_Int + File.separator + this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFontDrawer.jdField_b_of_type_Int + ".fz");
            }
            this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFontDrawer.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
          }
          else if ((!localFile.exists()) && (this.jdField_a_of_type_Boolean))
          {
            this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFontDrawer.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFont$HiBoomFontDownloader.a(this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFontDrawer.jdField_b_of_type_Int);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adfa
 * JD-Core Version:    0.7.0.1
 */