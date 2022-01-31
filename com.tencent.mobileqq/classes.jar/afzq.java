import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.photo.CameraPreviewActivity;
import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;

public class afzq
  extends BaseAdapter
{
  public afzq(CameraPreviewActivity paramCameraPreviewActivity) {}
  
  public String a(int paramInt)
  {
    if ((CameraPreviewActivity.a(this.a) != null) && (paramInt < CameraPreviewActivity.a(this.a).size()) && (paramInt >= 0)) {
      return (String)CameraPreviewActivity.a(this.a).get(paramInt);
    }
    return null;
  }
  
  public int getCount()
  {
    if (CameraPreviewActivity.a(this.a) != null) {
      return CameraPreviewActivity.a(this.a).size();
    }
    return 0;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = this.a.getLayoutInflater().inflate(2131493815, null);
      paramViewGroup = new afzr();
      paramViewGroup.a = ((URLImageView)paramView.findViewById(2131306220));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      Object localObject = a(paramInt);
      if (localObject == null) {
        break;
      }
      localObject = new File((String)localObject);
      if (((File)localObject).exists()) {}
      try
      {
        paramViewGroup.a.setImageDrawable(URLDrawable.getDrawable(((File)localObject).toURL(), CameraPreviewActivity.a(this.a), CameraPreviewActivity.b(this.a), CameraPreviewActivity.a(this.a), null, true));
        return paramView;
      }
      catch (MalformedURLException paramViewGroup)
      {
        paramViewGroup.printStackTrace();
        return paramView;
      }
      paramViewGroup = (afzr)paramView.getTag();
    }
    paramViewGroup.a.setImageDrawable(null);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afzq
 * JD-Core Version:    0.7.0.1
 */