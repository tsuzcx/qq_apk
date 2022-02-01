import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.subscribe.beans.SubscribeDraftBean;
import com.tencent.biz.subscribe.event.SubDraftChangeEvent;
import com.tencent.biz.subscribe.widget.relativevideo.SubScribeDraftItemView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class aacm
  implements zzq
{
  aacm(aacl paramaacl) {}
  
  public void a(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      aanb.b(SubScribeDraftItemView.b(this.a.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoSubScribeDraftItemView), "auth_pubish", "delete_draft", 0, 0, new String[0]);
      paramString = new SubDraftChangeEvent();
      paramString.setDraftID(String.valueOf(this.a.jdField_a_of_type_ComTencentBizSubscribeBeansSubscribeDraftBean.getDraftId()));
      SimpleEventBus.getInstance().dispatchEvent(paramString);
      QLog.d(SubScribeDraftItemView.a(), 4, "delete draft success");
      return;
    }
    QQToast.a(this.a.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoSubScribeDraftItemView.getContext(), "delete failed", 1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aacm
 * JD-Core Version:    0.7.0.1
 */