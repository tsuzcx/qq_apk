import android.os.Bundle;
import com.tencent.mobileqq.activity.contact.connections.ConnectionsExplorationFragment;
import com.tencent.qphone.base.util.QLog;

public class aicy
  extends amsu
{
  public aicy(ConnectionsExplorationFragment paramConnectionsExplorationFragment) {}
  
  protected void onAddFriend(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConnectionsExplorationFragment", 2, "onAddFriend " + paramString);
    }
    ConnectionsExplorationFragment.a(this.a, false, true);
  }
  
  protected void onAddReqStatesChanged(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConnectionsExplorationFragment", 2, "onAddReqStatesChanged isSuccess=" + paramBoolean + " " + paramString);
    }
    ConnectionsExplorationFragment.a(this.a, false, true);
  }
  
  protected void onCancelMayKnowRecommend(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConnectionsExplorationFragment", 2, "onCancelMayKnowRecommend isSuccess=" + paramBoolean + " " + paramString);
    }
    ConnectionsExplorationFragment.a(this.a, false, true);
  }
  
  public void onGetConnectionsPerson(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConnectionsExplorationFragment", 2, "onCancelMayKnowRecommend isSuccess=" + paramBoolean);
    }
    if (paramBoolean) {
      ConnectionsExplorationFragment.a(this.a, false, true);
    }
    while (paramInt1 != 1205) {
      return;
    }
    ConnectionsExplorationFragment.a(this.a, false, false);
  }
  
  protected void onGetMayKnowRecommend(boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConnectionsExplorationFragment", 2, "onGetMayKnowRecommend isSuccess=" + paramBoolean);
    }
    if (paramBoolean) {
      ConnectionsExplorationFragment.a(this.a, false, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aicy
 * JD-Core Version:    0.7.0.1
 */