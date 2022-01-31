import com.tencent.open.agent.OpenSdkFriendService;
import com.tencent.open.agent.OpenSdkFriendService.GetFriendListCallback;
import java.util.ArrayList;

public class akmo
  implements Runnable
{
  public akmo(OpenSdkFriendService.GetFriendListCallback paramGetFriendListCallback, ArrayList paramArrayList, String paramString) {}
  
  public void run()
  {
    if ("action_invite".equals(this.jdField_a_of_type_ComTencentOpenAgentOpenSdkFriendService$GetFriendListCallback.a.d))
    {
      this.jdField_a_of_type_ComTencentOpenAgentOpenSdkFriendService$GetFriendListCallback.a.a(this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_ComTencentOpenAgentOpenSdkFriendService$GetFriendListCallback.a.a(this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     akmo
 * JD-Core Version:    0.7.0.1
 */