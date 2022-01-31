import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.ApolloActionPush;
import com.tencent.qphone.base.util.QLog;

class aiss
  implements aist
{
  aiss(aisr paramaisr) {}
  
  public void a(int paramInt, ApolloActionPush paramApolloActionPush)
  {
    if ((aisr.a(this.a) != null) && (paramApolloActionPush != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPushManager", 2, "[onActionPush], aioType:" + paramInt + ";pushData:" + paramApolloActionPush.toString());
      }
      if ((aisr.a(this.a).jdField_a_of_type_Int == paramInt) && (paramInt == aisr.a(this.a).jdField_a_of_type_Int) && (!TextUtils.isEmpty(aisr.a(this.a).jdField_a_of_type_JavaLangString)) && (aisr.a(this.a).jdField_a_of_type_JavaLangString.equals(String.valueOf(paramApolloActionPush.mSessionId)))) {
        this.a.a(paramApolloActionPush);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aiss
 * JD-Core Version:    0.7.0.1
 */