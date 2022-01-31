import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mobileqq.ark.ArkAiAppPanel.ArkInputPanelTabAdapter;
import com.tencent.mobileqq.ark.ArkAiAppPanel.ArkInputPanelTabAdapter.ViewHolder;
import com.tencent.mobileqq.ark.ArkAppCenter.OnGetAppIcon;

public class aayo
  implements ArkAppCenter.OnGetAppIcon
{
  public aayo(ArkAiAppPanel.ArkInputPanelTabAdapter paramArkInputPanelTabAdapter, ArkAiAppPanel.ArkInputPanelTabAdapter.ViewHolder paramViewHolder) {}
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      this.jdField_a_of_type_ComTencentMobileqqArkArkAiAppPanel$ArkInputPanelTabAdapter$ViewHolder.a.setImageBitmap(paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aayo
 * JD-Core Version:    0.7.0.1
 */