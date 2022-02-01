import android.text.TextUtils;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;

public class afzb
{
  public static boolean a(Object paramObject)
  {
    if (!(paramObject instanceof MessageForUniteGrayTip)) {}
    do
    {
      return false;
      paramObject = (MessageForUniteGrayTip)paramObject;
    } while (!TextUtils.equals(paramObject.getExtInfoFromExtStr("uint64_busi_type"), "12"));
    return TextUtils.equals(paramObject.getExtInfoFromExtStr("uint64_busi_id"), "1061");
  }
  
  public static boolean b(Object paramObject)
  {
    if (!(paramObject instanceof MessageForUniteGrayTip)) {}
    do
    {
      return false;
      paramObject = (MessageForUniteGrayTip)paramObject;
    } while ((paramObject.tipParam == null) || (paramObject.tipParam.b != 656396));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afzb
 * JD-Core Version:    0.7.0.1
 */