import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.ark.ArkAiAppPanel;
import com.tencent.mobileqq.ark.ArkAiInfo;
import com.tencent.mobileqq.ark.ArkAppDataReport;
import com.tencent.widget.HorizontalListView;
import java.util.List;

public class aart
  implements AdapterView.OnItemClickListener
{
  public aart(ArkAiAppPanel paramArkAiAppPanel) {}
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = ArkAiAppPanel.a(this.a).getSelectedView();
    if (paramAdapterView != null) {
      paramAdapterView.setSelected(false);
    }
    ArkAiAppPanel.a(this.a).setSelection(paramInt);
    paramAdapterView = ArkAiAppPanel.a(this.a).getSelectedView();
    if (paramAdapterView != null) {
      paramAdapterView.setSelected(true);
    }
    ArkAiAppPanel.a(this.a, paramInt);
    ArkAiAppPanel.a(this.a, true);
    if ((ArkAiAppPanel.a(this.a) != null) && (ArkAiAppPanel.a(this.a).size() > 0) && (ArkAiAppPanel.a(this.a).size() > ArkAiAppPanel.a(this.a)))
    {
      paramAdapterView = (ArkAiInfo)ArkAiAppPanel.a(this.a).get(ArkAiAppPanel.a(this.a));
      if (paramAdapterView != null) {
        ArkAppDataReport.b(null, paramAdapterView.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aart
 * JD-Core Version:    0.7.0.1
 */