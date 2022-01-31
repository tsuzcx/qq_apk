import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.remind.TimeHelper;
import com.tencent.mobileqq.remind.widget.IosTimepicker.FormatDataListener;
import com.tencent.mobileqq.remind.widget.WheelView;

public final class agry
  implements IosTimepicker.FormatDataListener
{
  public long a(WheelView[] paramArrayOfWheelView, int[] paramArrayOfInt)
  {
    Object localObject2 = null;
    if ((paramArrayOfInt.length != 3) || (paramArrayOfWheelView.length != 3)) {
      return -1L;
    }
    String str2;
    if (AppSetting.b)
    {
      str2 = TimeHelper.a(paramArrayOfInt[0]);
      if ((paramArrayOfInt[1] < 0) || (paramArrayOfInt[1] >= TimeHelper.a.length)) {
        break label197;
      }
    }
    label197:
    for (String str1 = TimeHelper.a[paramArrayOfInt[1]];; str1 = null)
    {
      Object localObject1 = localObject2;
      if (paramArrayOfInt[2] >= 0)
      {
        localObject1 = localObject2;
        if (paramArrayOfInt[2] < TimeHelper.b.length) {
          localObject1 = TimeHelper.b[paramArrayOfInt[2]];
        }
      }
      if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty((CharSequence)localObject1)))
      {
        str1 = "当前选中时间" + str2 + str1 + "时" + (String)localObject1 + "分";
        int j = paramArrayOfWheelView.length;
        int i = 0;
        while (i < j)
        {
          paramArrayOfWheelView[i].setContentDescription(str1);
          i += 1;
        }
      }
      return TimeHelper.a(paramArrayOfInt[0], paramArrayOfInt[1], paramArrayOfInt[2]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     agry
 * JD-Core Version:    0.7.0.1
 */