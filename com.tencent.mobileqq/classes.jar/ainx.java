import android.text.TextUtils.EllipsizeCallback;
import android.widget.TextView;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.data.NearbyTroops.CustomViewHolder;

public final class ainx
  implements TextUtils.EllipsizeCallback
{
  public ainx(NearbyTroops.CustomViewHolder paramCustomViewHolder, String paramString) {}
  
  public void ellipsized(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroops$CustomViewHolder.c.setText(this.jdField_a_of_type_JavaLangString);
      return;
    }
    String str = this.jdField_a_of_type_JavaLangString.substring(0, paramInt1);
    this.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroops$CustomViewHolder.c.setText(new QQText(HttpUtil.b(HttpUtil.c(str + "...")), 3, 14));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ainx
 * JD-Core Version:    0.7.0.1
 */