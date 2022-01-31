import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.view.StructMsgItemCover;
import com.tencent.mobileqq.widget.PAHighLightImageView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.HashMap;

public class aink
  extends URLDrawableDownListener.Adapter
{
  public aink(StructMsgItemCover paramStructMsgItemCover) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable)
  {
    super.onLoadCancelled(paramView, paramURLDrawable);
    if (QLog.isColorLevel()) {
      QLog.d("StructMsgItemCover", 2, "onLoadCancelled");
    }
  }
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    super.onLoadFailed(paramView, paramURLDrawable, paramThrowable);
    if (QLog.isColorLevel()) {
      QLog.d("StructMsgItemCover", 2, "onLoadFailed ,cause = " + paramThrowable);
    }
    if ((paramURLDrawable != null) && (paramURLDrawable.getURL() != null))
    {
      paramThrowable = paramURLDrawable.getURL().toString();
      if (paramThrowable.startsWith("http://url.cn"))
      {
        paramThrowable = paramThrowable.replace("http://", "https://");
        try
        {
          paramThrowable = URLDrawable.getDrawable(new URL(paramThrowable), (URLDrawable.URLDrawableOptions)paramURLDrawable.getTag());
          paramThrowable.setAutoDownload(true);
          ((PAHighLightImageView)paramView).setImageDrawable(paramThrowable);
          return;
        }
        catch (Exception paramThrowable)
        {
          paramThrowable.printStackTrace();
        }
      }
    }
    try
    {
      paramThrowable = new HashMap();
      paramThrowable.put("param_Url", paramURLDrawable.getURL().toString());
      StatisticCollector.a(BaseApplication.getContext()).a(null, "StructMsgPicShow", false, 0L, 0L, paramThrowable, null);
      label152:
      this.a.a(paramView, 0, 1001);
      return;
    }
    catch (Exception paramURLDrawable)
    {
      break label152;
    }
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException)
  {
    super.onLoadInterrupted(paramView, paramURLDrawable, paramInterruptedException);
    if (QLog.isColorLevel()) {
      QLog.d("StructMsgItemCover", 2, "onLoadInterrupted");
    }
  }
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    if (paramView == null) {
      return;
    }
    paramView.setBackgroundDrawable(null);
    if ((paramView instanceof ImageView)) {
      ((ImageView)paramView).setScaleType(ImageView.ScaleType.CENTER_CROP);
    }
    try
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_Url", paramURLDrawable.getURL().toString());
      StatisticCollector.a(BaseApplication.getContext()).a(null, "StructMsgPicShow", true, 0L, 0L, localHashMap, null);
      label66:
      if (QLog.isColorLevel()) {
        QLog.d("StructMsgItemCover", 2, "onLoadSuccessed");
      }
      this.a.a(paramView, 1, 1001);
      return;
    }
    catch (Exception paramURLDrawable)
    {
      break label66;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aink
 * JD-Core Version:    0.7.0.1
 */