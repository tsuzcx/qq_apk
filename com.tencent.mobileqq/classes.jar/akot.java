import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.ApolloActionPush;
import com.tencent.qphone.base.util.QLog;

class akot
  implements akou
{
  akot(akos paramakos) {}
  
  public void a(int paramInt, ApolloActionPush paramApolloActionPush)
  {
    if ((akos.a(this.a) != null) && (paramApolloActionPush != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPushManager", 2, "[onActionPush], aioType:" + paramInt + ";pushData:" + paramApolloActionPush.toString());
      }
      if ((akos.a(this.a).jdField_a_of_type_Int == paramInt) && (paramInt == akos.a(this.a).jdField_a_of_type_Int) && (!TextUtils.isEmpty(akos.a(this.a).jdField_a_of_type_JavaLangString)) && (akos.a(this.a).jdField_a_of_type_JavaLangString.equals(String.valueOf(paramApolloActionPush.mSessionId)))) {
        this.a.a(paramApolloActionPush);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akot
 * JD-Core Version:    0.7.0.1
 */