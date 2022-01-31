import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.webview.WebViewTitleStyle;

public final class akub
  implements Parcelable.Creator
{
  public WebViewTitleStyle a(Parcel paramParcel)
  {
    return new WebViewTitleStyle(paramParcel);
  }
  
  public WebViewTitleStyle[] a(int paramInt)
  {
    return new WebViewTitleStyle[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akub
 * JD-Core Version:    0.7.0.1
 */