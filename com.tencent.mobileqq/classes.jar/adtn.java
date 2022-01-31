import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

final class adtn
  implements moc
{
  public void loaded(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopSignItemBuilder", 2, "checkUpByBusinessId:2833|param:" + paramString + "|code:" + paramInt);
    }
    if ((paramInt == 0) && (paramString == null))
    {
      paramString = adtj.a.entrySet().iterator();
      while (paramString.hasNext()) {
        ((adto)((Map.Entry)paramString.next()).getValue()).a(paramInt);
      }
      adtj.a.clear();
    }
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adtn
 * JD-Core Version:    0.7.0.1
 */