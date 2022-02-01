import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.photo.CameraPreviewActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;

public class akjn
  extends BaseAdapter
{
  public akjn(CameraPreviewActivity paramCameraPreviewActivity) {}
  
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
    akjo localakjo;
    Object localObject;
    if (paramView == null)
    {
      paramView = this.a.getLayoutInflater().inflate(2131559604, null);
      localakjo = new akjo();
      localakjo.a = ((URLImageView)paramView.findViewById(2131373139));
      paramView.setTag(localakjo);
      localObject = a(paramInt);
      if (localObject == null) {
        break label155;
      }
      localObject = new File((String)localObject);
      if (!((File)localObject).exists()) {}
    }
    for (;;)
    {
      try
      {
        localakjo.a.setImageDrawable(URLDrawable.getDrawable(((File)localObject).toURL(), CameraPreviewActivity.a(this.a), CameraPreviewActivity.b(this.a), CameraPreviewActivity.a(this.a), null, true));
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        localakjo = (akjo)paramView.getTag();
      }
      catch (MalformedURLException localMalformedURLException)
      {
        localMalformedURLException.printStackTrace();
        continue;
      }
      label155:
      localMalformedURLException.a.setImageDrawable(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akjn
 * JD-Core Version:    0.7.0.1
 */