import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.selectmember.TroopAddFrdsInnerFrame;
import com.tencent.mobileqq.activity.selectmember.TroopAddFrdsInnerFrame.2.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;

public class akbf
  extends ameq
{
  public akbf(TroopAddFrdsInnerFrame paramTroopAddFrdsInnerFrame) {}
  
  protected void a(String paramString, boolean paramBoolean, List<TroopMemberInfo> paramList, int paramInt1, long paramLong, int paramInt2)
  {
    if ((!TextUtils.isEmpty(this.a.jdField_b_of_type_JavaLangString)) && (!this.a.jdField_b_of_type_JavaLangString.equals(paramString))) {
      return;
    }
    ThreadManager.post(new TroopAddFrdsInnerFrame.2.1(this, paramList), 5, null, true);
  }
  
  protected void a(boolean paramBoolean1, String paramString1, String paramString2, long paramLong, int paramInt, boolean paramBoolean2, boolean paramBoolean3, HashMap<String, Integer> paramHashMap, List<String> paramList)
  {
    if ((paramBoolean1) && (this.a.a != null) && (this.a.a.longValue() == paramLong) && (paramString1.equals(this.a.jdField_b_of_type_JavaLangString)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopAddFrdsInnerFrame", 2, String.format("onTroopBatchReqMemberCmnFrds suc. troopUin:%s, cmnfrds.size:%d", new Object[] { paramString1, Integer.valueOf(paramHashMap.size()) }));
      }
      if (paramHashMap.size() > 0)
      {
        paramString1 = this.a.jdField_b_of_type_AndroidOsHandler.obtainMessage(6);
        paramString1.obj = paramHashMap;
        this.a.jdField_b_of_type_AndroidOsHandler.sendMessage(paramString1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akbf
 * JD-Core Version:    0.7.0.1
 */