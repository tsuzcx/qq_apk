import android.view.View;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import java.util.ArrayList;

public class acvl
  implements AdapterView.OnItemClickListener
{
  public acvl(LocalFileBrowserActivity paramLocalFileBrowserActivity) {}
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (FileInfo)this.a.b.get(paramInt);
    if (paramAdapterView.a()) {
      LocalFileBrowserActivity.a(this.a, paramAdapterView.c(), true);
    }
    while (!this.a.f()) {
      return;
    }
    if (FMDataCache.a(paramAdapterView)) {
      FMDataCache.b(paramAdapterView);
    }
    for (;;)
    {
      this.a.k();
      LocalFileBrowserActivity.a(this.a);
      return;
      if (this.a.e) {
        FMDataCache.b();
      }
      FMDataCache.a(paramAdapterView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acvl
 * JD-Core Version:    0.7.0.1
 */