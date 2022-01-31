import android.content.Context;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.favroaming.IPicDownloadListener;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

final class ajxr
  extends bbwf
{
  ajxr(String paramString, File paramFile, CustomEmotionData paramCustomEmotionData, boolean paramBoolean1, boolean paramBoolean2, ansr paramansr, IPicDownloadListener paramIPicDownloadListener, List paramList1, List paramList2, Context paramContext, AtomicInteger paramAtomicInteger1, AtomicInteger paramAtomicInteger2) {}
  
  public void onDone(bbwg parambbwg)
  {
    super.onDone(parambbwg);
    ajxq.a.remove(this.jdField_a_of_type_JavaLangString);
    if ((3 == parambbwg.a()) && (this.jdField_a_of_type_JavaIoFile.exists()))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.emoPath = this.jdField_a_of_type_JavaIoFile.getAbsolutePath();
      if ("needDownload".equals(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.RomaingType)) {
        this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.RomaingType = "isUpdate";
      }
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.eId = "";
      }
      if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.md5)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.emoPath)))
      {
        parambbwg = MD5.getFileMd5(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.emoPath);
        this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.md5 = HexUtil.bytes2HexStr(parambbwg);
      }
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_Ansr.b(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingIPicDownloadListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingIPicDownloadListener.onFileDone(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData, true);
      }
      this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData);
      if (QLog.isColorLevel()) {
        QLog.d("FunyPicHelper", 2, "update funnyPic eId->" + this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.eId + " emoPath->" + this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.emoPath + " download->sucess");
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
      if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()) && (this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingIPicDownloadListener != null)) {
        this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingIPicDownloadListener.onDone(this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList);
      }
      return;
      this.jdField_b_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData);
      if (this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingIPicDownloadListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingIPicDownloadListener.onFileDone(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData, false);
      }
      if (QLog.isColorLevel()) {
        QLog.d("FunyPicHelper", 2, "update funnyPic eId->" + this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.eId + " emoPath->" + this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.emoPath + " download->faile");
      }
      bbrj.a("emotionType", "emotionActionFav", "3", "", "", bbev.b(this.jdField_a_of_type_AndroidContentContext) + "", parambbwg.a + "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajxr
 * JD-Core Version:    0.7.0.1
 */