import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.TextPreviewTranslateActivity;
import com.tencent.mobileqq.ocr.data.TranslateResult;

public class acfe
  extends atzx
{
  public acfe(TextPreviewTranslateActivity paramTextPreviewTranslateActivity) {}
  
  public void a(boolean paramBoolean, int paramInt, TranslateResult paramTranslateResult)
  {
    TextPreviewTranslateActivity.b(this.a);
    if ((paramBoolean) && (paramTranslateResult != null) && (paramTranslateResult.b()) && (!paramTranslateResult.a()))
    {
      TextPreviewTranslateActivity.a(this.a, paramTranslateResult);
      return;
    }
    String str2 = this.a.getResources().getString(2131699266);
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
      bcql.a(this.a, 1, str1, 0).a();
      return;
      label92:
      str1 = str2;
      if (paramTranslateResult.a()) {
        str1 = this.a.getResources().getString(2131699245);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acfe
 * JD-Core Version:    0.7.0.1
 */