import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.widget.LinearLayout;
import com.tencent.image.URLImageView;
import java.lang.ref.WeakReference;

class aanv
  extends LinearLayout
{
  private aauk jdField_a_of_type_Aauk;
  private aaum jdField_a_of_type_Aaum = new aanw(this);
  
  public aanv(Context paramContext, String paramString)
  {
    super(paramContext);
    setGravity(17);
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setShape(0);
    localGradientDrawable.setStroke(1, Color.parseColor("#EFEFEF"));
    if (Build.VERSION.SDK_INT >= 16) {
      setBackground(localGradientDrawable);
    }
    if ((paramContext == null) || (TextUtils.isEmpty(paramString)))
    {
      aase.d("GdtBannerImageView", "constructor");
      return;
    }
    paramContext = new URLImageView(paramContext);
    addView(paramContext);
    this.jdField_a_of_type_Aauk = new aauk(paramString, new WeakReference(this.jdField_a_of_type_Aaum));
    this.jdField_a_of_type_Aauk.a();
    paramContext.setImageDrawable(this.jdField_a_of_type_Aauk.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aanv
 * JD-Core Version:    0.7.0.1
 */