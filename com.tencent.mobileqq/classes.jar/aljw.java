import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.armap.ConversationActivePendantHolderBase;
import com.tencent.mobileqq.armap.ConversationPullDownActiveBase;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ARMapHongBaoListView;
import com.tencent.widget.ARMapHongBaoListView.ConversationActiveListViewListener;

public class aljw
  implements Handler.Callback
{
  public aljw(ARMapHongBaoListView paramARMapHongBaoListView) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    int j;
    int k;
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1: 
      this.a.setIsShowingPreguide(true);
      boolean bool1 = paramMessage.getData().getBoolean("isFirstCall", false);
      boolean bool2 = paramMessage.getData().getBoolean("isListViewSpring", false);
      boolean bool3 = paramMessage.getData().getBoolean("isPendantBounce", false);
      j = paramMessage.getData().getInt("pendantBountCnt", 0);
      if (QLog.isColorLevel()) {
        QLog.d("SwipListView", 2, "ARMapHongBaoListView handleMessage MSG_WHAT_GUIDE_SHOW, " + bool1 + "," + bool2 + "," + bool3 + "," + j);
      }
      if ((bool1) && (bool2))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqArmapConversationPullDownActiveBase.c(-this.a.f);
        if ((ARMapHongBaoListView.a(this.a) != null) && (this.a.e)) {
          ARMapHongBaoListView.a(this.a).b(false);
        }
      }
      if ((bool3) && (j > 0))
      {
        float f = j * 1.0F / 6.0F;
        this.a.jdField_a_of_type_ComTencentMobileqqArmapConversationActivePendantHolderBase.a((int)(f * this.a.f), j * 300L);
        k = j - 1;
        i = k;
        if (k > 0)
        {
          paramMessage = Message.obtain(ARMapHongBaoListView.a(this.a), 1);
          paramMessage.getData().putBoolean("isFirstCall", false);
          paramMessage.getData().putBoolean("isListViewSpring", false);
          paramMessage.getData().putBoolean("isPendantBounce", bool3);
          paramMessage.getData().putInt("pendantBountCnt", k);
          ARMapHongBaoListView.a(this.a).sendMessageDelayed(paramMessage, j * 300L + 200L);
        }
      }
      break;
    }
    for (int i = k;; i = j)
    {
      if (i == 0)
      {
        paramMessage = Message.obtain(ARMapHongBaoListView.a(this.a), 2);
        ARMapHongBaoListView.a(this.a).sendMessageDelayed(paramMessage, 1200L);
      }
      this.a.invalidate();
      return false;
      if (QLog.isColorLevel()) {
        QLog.d("SwipListView", 2, "ARMapHongBaoListView handleMessage MSG_WHAT_GUIDE_HIDE");
      }
      if (ARMapHongBaoListView.a(this.a) != null) {
        ARMapHongBaoListView.a(this.a).a(false);
      }
      ARMapHongBaoListView.a(this.a, paramMessage.what);
      ARMapHongBaoListView.a(this.a).sendEmptyMessageDelayed(5, 300L);
      return false;
      this.a.setIsShowingPreguide(true);
      i = this.a.f;
      if (paramMessage.arg1 != 0) {
        i = paramMessage.arg1;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqArmapConversationPullDownActiveBase.c(-i);
      this.a.jdField_a_of_type_ComTencentMobileqqArmapConversationActivePendantHolderBase.a(this.a.f / 3, 300L);
      ARMapHongBaoListView.a(this.a).sendEmptyMessageDelayed(4, 2000L);
      if ((ARMapHongBaoListView.a(this.a) == null) || (!this.a.e)) {
        break;
      }
      ARMapHongBaoListView.a(this.a).b(false);
      return false;
      ARMapHongBaoListView.a(this.a, paramMessage.what);
      ARMapHongBaoListView.a(this.a).sendEmptyMessageDelayed(5, 300L);
      if (ARMapHongBaoListView.a(this.a) == null) {
        break;
      }
      ARMapHongBaoListView.a(this.a).a(false);
      return false;
      this.a.setIsShowingPreguide(false);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aljw
 * JD-Core Version:    0.7.0.1
 */