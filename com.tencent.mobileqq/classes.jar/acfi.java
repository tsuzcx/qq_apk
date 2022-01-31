import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.TextPreviewTranslateActivity;
import com.tencent.mobileqq.ocr.data.TranslateResult;

public class acfi
  extends atzv
{
  public acfi(TextPreviewTranslateActivity paramTextPreviewTranslateActivity) {}
  
  public void a(boolean paramBoolean, int paramInt, TranslateResult paramTranslateResult)
  {
    TextPreviewTranslateActivity.b(this.a);
    if ((paramBoolean) && (paramTranslateResult != null) && (paramTranslateResult.b()) && (!paramTranslateResult.a()))
    {
      TextPreviewTranslateActivity.a(this.a, paramTranslateResult);
      return;
    }
    String str2 = this.a.getResources().getString(2131699256);
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
      bcpw.a(this.a, 1, str1, 0).a();
      return;
      label92:
      str1 = str2;
      if (paramTranslateResult.a()) {
        str1 = this.a.getResources().getString(2131699235);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acfi
 * JD-Core Version:    0.7.0.1
 */