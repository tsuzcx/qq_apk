import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.QQAppInterface;

class akus
  extends akvk
{
  public QQAppInterface a;
  
  akus(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    akuq.a(((aknx)this.a.getManager(153)).a(), paramInt);
  }
  
  public void b(String paramString, int paramInt1, int paramInt2)
  {
    QLog.i("CmGameTemp_CmGameAudioManager", 0, "[onQueryAudioRoomId] friUin:" + paramString + ",roomID:" + paramInt1);
    super.b(paramString, paramInt1, paramInt2);
    ((aknx)this.a.getManager(153)).a().a(paramString, String.valueOf(paramInt1), paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akus
 * JD-Core Version:    0.7.0.1
 */