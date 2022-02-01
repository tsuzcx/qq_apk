import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.picload.Option;
import cooperation.qqcircle.picload.QCircleFeedPicLoader.QCirclePicStateListener;

class agkx
  extends QCircleFeedPicLoader.QCirclePicStateListener
{
  agkx(agkv paramagkv) {}
  
  public void onStateChang(int paramInt, Option paramOption)
  {
    super.onStateChang(paramInt, paramOption);
    QLog.d("QCircleFeedItemBuilder", 1, paramOption.getUrl() + ", \nstate callback:" + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agkx
 * JD-Core Version:    0.7.0.1
 */