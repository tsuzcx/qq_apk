import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.TextPreviewTranslateActivity;
import com.tencent.mobileqq.ocr.data.TranslateResult;
import com.tencent.mobileqq.widget.QQToast;

public class afho
  extends ayfc
{
  public afho(TextPreviewTranslateActivity paramTextPreviewTranslateActivity) {}
  
  public void a(boolean paramBoolean, int paramInt, TranslateResult paramTranslateResult)
  {
    TextPreviewTranslateActivity.b(this.a);
    if ((paramBoolean) && (paramTranslateResult != null) && (paramTranslateResult.b()) && (!paramTranslateResult.a()))
    {
      TextPreviewTranslateActivity.a(this.a, paramTranslateResult);
      return;
    }
    String str2 = this.a.getResources().getString(2131698145);
    String str1 = str2;
    if (paramTranslateResult != null)
    {
      if (TextUtils.isEmpty(paramTranslateResult.e)) {
        break label92;
      }
      str1 = paramTranslateResult.e;
    }
    for (;;)
    {
      QQToast.a(this.a, 1, str1, 0).a();
      return;
      label92:
      str1 = str2;
      if (paramTranslateResult.a()) {
        str1 = this.a.getResources().getString(2131698132);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afho
 * JD-Core Version:    0.7.0.1
 */