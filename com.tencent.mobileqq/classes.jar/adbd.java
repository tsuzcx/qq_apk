import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItemViewHolder;

public class adbd
  implements AdapterView.OnItemClickListener
{
  public adbd(FileBrowserActivity paramFileBrowserActivity) {}
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = paramView.getTag();
    if (paramAdapterView == null) {
      return;
    }
    FileBrowserActivity.a(this.a).b();
    ((ShareActionSheetBuilder.ActionSheetItemViewHolder)paramAdapterView).a.a.onClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adbd
 * JD-Core Version:    0.7.0.1
 */