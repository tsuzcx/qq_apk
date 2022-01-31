import com.tencent.qphone.base.util.QLog;
import java.util.List;

class acxi
  implements ajzi
{
  acxi(acxh paramacxh) {}
  
  public void a(boolean paramBoolean, List<aelm> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("onGetIceBreakHotPic, success: ").append(paramBoolean).append(" hotPiceList size: ");
    int i;
    if (paramList == null)
    {
      i = 0;
      QLog.i("IceBreak.HotPic", 1, i);
      if (paramBoolean) {
        break label59;
      }
    }
    label59:
    while (this.a.a == null)
    {
      return;
      i = paramList.size();
      break;
    }
    this.a.a.a(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acxi
 * JD-Core Version:    0.7.0.1
 */