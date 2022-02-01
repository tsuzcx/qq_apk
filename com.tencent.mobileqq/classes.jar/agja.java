import android.graphics.Color;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.data.IntimateInfo.DNAInfo;
import com.tencent.qphone.base.util.QLog;

class agja
  extends ClickableSpan
{
  agja(agiq paramagiq, IntimateInfo.DNAInfo paramDNAInfo) {}
  
  public void onClick(View paramView)
  {
    bdll.b(null, "dc00898", "", "", "0X800A20A ", "0X800A20A ", 0, 0, "", "", "", "");
    QLog.d("Intimate report test", 2, "REPORT_TAG_0X800A20A");
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo$DNAInfo.linkUrl))
    {
      QLog.e("intimate_relationship", 2, "linkUrl is empty");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, String.format("click scheme: %s, scheme: %s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo$DNAInfo.linkWording, this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo$DNAInfo.linkUrl }));
    }
    paramView = bhni.a(this.jdField_a_of_type_Agiq.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Agiq.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo$DNAInfo.linkUrl);
    if (paramView != null)
    {
      paramView.a();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo$DNAInfo.linkUrl.toLowerCase().startsWith("mqzone://"))
    {
      bmtd.c(this.jdField_a_of_type_Agiq.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo$DNAInfo.linkUrl);
      return;
    }
    agxl.a(this.jdField_a_of_type_Agiq.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo$DNAInfo.linkUrl);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setUnderlineText(false);
    try
    {
      int j = Color.parseColor("#4D94FF");
      paramTextPaint.setColor(j);
      int i = j;
      if (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo$DNAInfo != null)
      {
        i = j;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo$DNAInfo.linkColor)) {
          i = Color.parseColor(this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo$DNAInfo.linkColor);
        }
      }
      paramTextPaint.setColor(i);
      return;
    }
    catch (IllegalArgumentException paramTextPaint)
    {
      QLog.e("intimate_relationship", 2, " color parse err");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agja
 * JD-Core Version:    0.7.0.1
 */