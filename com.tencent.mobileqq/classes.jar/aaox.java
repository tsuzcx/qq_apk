import NS_QQ_STORY_CLIENT.CLIENT.StSmartMatchMusicRsp;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.VSBaseRequest;

class aaox
  implements VSDispatchObserver.onVSRspCallBack<CLIENT.StSmartMatchMusicRsp>
{
  aaox(aaor paramaaor) {}
  
  public void a(VSBaseRequest paramVSBaseRequest, boolean paramBoolean, long paramLong, String paramString, CLIENT.StSmartMatchMusicRsp paramStSmartMatchMusicRsp)
  {
    long l = System.currentTimeMillis() - aaor.a(this.a);
    aanb.a("edit_smart_music", aanb.a(paramLong, l, "", 0L));
    this.a.a(anvx.a(2131703381) + l + "ms");
    aaor.a(this.a, paramBoolean, paramLong, paramString, paramStSmartMatchMusicRsp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaox
 * JD-Core Version:    0.7.0.1
 */