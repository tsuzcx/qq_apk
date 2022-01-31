import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.activity.selectmember.TroopAddFrdsInnerFrame;
import com.tencent.mobileqq.activity.selectmember.TroopAddFrdsInnerFrame.1.1;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x777.cmd0x777.AddFrdInfo;

public class aiff
  extends ajxj
{
  public aiff(TroopAddFrdsInnerFrame paramTroopAddFrdsInnerFrame) {}
  
  public void onAddBatchTroopFrd(boolean paramBoolean, String paramString, ArrayList<cmd0x777.AddFrdInfo> paramArrayList)
  {
    int j = 0;
    if ((!TextUtils.isEmpty(this.a.b)) && (!this.a.b.equals(paramString))) {}
    label155:
    do
    {
      return;
      if (QLog.isColorLevel()) {
        if (!paramBoolean) {
          break label155;
        }
      }
      for (int i = 1;; i = 0)
      {
        QLog.i("TroopAddFrdsInnerFrame", 2, String.format("onAddBatchTroopFrd suc:%d troopUin:%s size:%d", new Object[] { Integer.valueOf(i), paramString, Integer.valueOf(paramArrayList.size()) }));
        this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.runOnUiThread(new TroopAddFrdsInnerFrame.1.1(this, paramArrayList));
        paramString = new ArrayList();
        i = j;
        while (i < paramArrayList.size())
        {
          paramString.add(Long.toString(((cmd0x777.AddFrdInfo)paramArrayList.get(i)).uint64_uin.get()));
          i += 1;
        }
      }
    } while (paramString.size() <= 0);
    paramArrayList = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(9);
    paramArrayList.obj = paramString;
    paramArrayList.sendToTarget();
  }
  
  protected void onAddFriend(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopAddFrdsInnerFrame", 2, String.format("onAddFriend %s", new Object[] { paramString }));
    }
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(paramString);
    paramString = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(9);
    paramString.obj = localArrayList;
    paramString.sendToTarget();
  }
  
  protected void onUpdateAddFriend(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle)
  {
    int k = 0;
    int i;
    if (QLog.isColorLevel())
    {
      if (!paramBoolean1) {
        break label125;
      }
      i = 1;
      if (!paramBoolean2) {
        break label131;
      }
    }
    label131:
    for (int j = 1;; j = 0)
    {
      if (paramBoolean3) {
        k = 1;
      }
      QLog.i("TroopAddFrdsInnerFrame", 2, String.format("onUpdateAddFriend isSuc:%d addSuc:%d addDirec:%d uin:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), paramString }));
      if (paramBoolean1)
      {
        paramBundle = new ArrayList(1);
        paramBundle.add(paramString);
        paramString = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(9);
        paramString.obj = paramBundle;
        paramString.sendToTarget();
      }
      return;
      label125:
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aiff
 * JD-Core Version:    0.7.0.1
 */