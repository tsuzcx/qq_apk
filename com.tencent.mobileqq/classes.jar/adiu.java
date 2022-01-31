import android.content.Intent;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class adiu
  implements adih
{
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  Map<Integer, Intent> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  adiu(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
  }
  
  public Intent a(int paramInt)
  {
    return (Intent)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 2: 
      b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.hashCode());
      return;
    }
    b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.hashCode());
  }
  
  public void a(int paramInt, Intent paramIntent)
  {
    int j = 0;
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), paramIntent);
    if (QLog.isColorLevel())
    {
      if (paramIntent != null) {
        break label54;
      }
      QLog.d("PhotoListHelper", 2, "setSelectedPhotoData null, code=" + paramInt);
    }
    label54:
    while (!paramIntent.hasExtra("PhotoConst.SELECTED_PATHS")) {
      return;
    }
    Object localObject = paramIntent.getStringArrayListExtra("PhotoConst.SELECTED_PATHS");
    paramIntent = paramIntent.getIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS");
    StringBuilder localStringBuilder = new StringBuilder().append("setSelectedPhotoData checked size=");
    if (localObject == null)
    {
      i = 0;
      localObject = localStringBuilder.append(i).append(",checkedIndex size=");
      if (paramIntent != null) {
        break label153;
      }
    }
    label153:
    for (int i = j;; i = paramIntent.size())
    {
      QLog.d("PhotoListHelper", 2, i + ", code=" + paramInt);
      return;
      i = ((ArrayList)localObject).size();
      break;
    }
  }
  
  public int[] a()
  {
    return new int[] { 2, 11 };
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(paramInt));
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListHelper", 2, "removeSelectedPhotoData code=" + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adiu
 * JD-Core Version:    0.7.0.1
 */