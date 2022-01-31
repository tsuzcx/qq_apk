import QQService.DiscussMemberInfo;
import QQService.InteRemarkInfo;
import QQService.RespGetDiscussInfo;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.JoinDiscussionActivity;
import com.tencent.mobileqq.activity.JoinDiscussionActivity.MyDiscussionObserver.1;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class abjo
  extends ajvj
{
  private abjo(JoinDiscussionActivity paramJoinDiscussionActivity) {}
  
  protected void a(boolean paramBoolean, int paramInt, RespGetDiscussInfo paramRespGetDiscussInfo)
  {
    if (paramBoolean)
    {
      this.a.stopTitleProgress();
      this.a.d = String.valueOf(paramRespGetDiscussInfo.DiscussUin);
      this.a.c = paramRespGetDiscussInfo.Name;
      this.a.jdField_a_of_type_JavaUtilList = paramRespGetDiscussInfo.Members;
      this.a.jdField_a_of_type_Long = paramRespGetDiscussInfo.OwnerUin;
      this.a.jdField_b_of_type_Long = (paramRespGetDiscussInfo.CreateTime * 1000L);
      HashMap localHashMap = new HashMap();
      if (this.a.jdField_a_of_type_JavaUtilList != null)
      {
        Object localObject3 = this.a.jdField_a_of_type_JavaUtilList.iterator();
        Object localObject2;
        if (((Iterator)localObject3).hasNext())
        {
          localObject2 = (DiscussMemberInfo)((Iterator)localObject3).next();
          if (((DiscussMemberInfo)localObject2).Uin == this.a.jdField_a_of_type_Long) {
            this.a.e = ((DiscussMemberInfo)localObject2).StInteRemark.StrValue;
          }
          l = ((DiscussMemberInfo)localObject2).Uin;
          localObject1 = null;
          if (0 == 0)
          {
            localObject1 = new DiscussionMemberInfo();
            ((DiscussionMemberInfo)localObject1).discussionUin = this.a.d;
            ((DiscussionMemberInfo)localObject1).memberUin = String.valueOf(l);
          }
          ((DiscussionMemberInfo)localObject1).flag = ((DiscussMemberInfo)localObject2).Flag;
          if ((((DiscussMemberInfo)localObject2).StInteRemark != null) && (!TextUtils.isEmpty(((DiscussMemberInfo)localObject2).StInteRemark.StrValue)))
          {
            ((DiscussionMemberInfo)localObject1).inteRemark = ((DiscussMemberInfo)localObject2).StInteRemark.StrValue;
            ((DiscussionMemberInfo)localObject1).inteRemarkSource = ((DiscussMemberInfo)localObject2).StInteRemark.Source;
          }
          for (;;)
          {
            localHashMap.put(((DiscussionMemberInfo)localObject1).memberUin, localObject1);
            break;
            if (TextUtils.isEmpty(((DiscussionMemberInfo)localObject1).inteRemark))
            {
              localObject2 = ((ajxl)this.a.app.getManager(51)).b(((DiscussionMemberInfo)localObject1).memberUin);
              if ((localObject2 != null) && (((Friends)localObject2).isFriend()))
              {
                ((DiscussionMemberInfo)localObject1).memberName = ((Friends)localObject2).name;
                if (TextUtils.isEmpty(((Friends)localObject2).remark)) {}
                for (localObject2 = ((Friends)localObject2).name;; localObject2 = ((Friends)localObject2).remark)
                {
                  ((DiscussionMemberInfo)localObject1).inteRemark = ((String)localObject2);
                  ((DiscussionMemberInfo)localObject1).inteRemarkSource = 129L;
                  break;
                }
              }
              ((DiscussionMemberInfo)localObject1).inteRemarkSource = 0L;
            }
          }
        }
        Object localObject1 = new ArrayList();
        if (this.a.jdField_a_of_type_JavaUtilList != null)
        {
          l = Long.parseLong(this.a.app.getCurrentAccountUin());
          paramInt = 0;
          while (paramInt < this.a.jdField_a_of_type_JavaUtilList.size())
          {
            if (((DiscussMemberInfo)this.a.jdField_a_of_type_JavaUtilList.get(paramInt)).Uin != l) {
              ((ArrayList)localObject1).add(Long.valueOf(((DiscussMemberInfo)this.a.jdField_a_of_type_JavaUtilList.get(paramInt)).Uin));
            }
            paramInt += 1;
          }
        }
        this.a.jdField_b_of_type_Int = Math.min(((ArrayList)localObject1).size(), 4);
        this.a.jdField_a_of_type_JavaUtilArrayList.clear();
        this.a.f = "";
        paramInt = 0;
        while (paramInt < this.a.jdField_b_of_type_Int)
        {
          localObject2 = String.valueOf(((ArrayList)localObject1).get(paramInt));
          if (bayh.a(this.a.app, 1, (String)localObject2) != null)
          {
            this.a.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
            localObject2 = new StringBuilder();
            localObject3 = this.a;
            ((JoinDiscussionActivity)localObject3).f = (((JoinDiscussionActivity)localObject3).f + String.valueOf(((ArrayList)localObject1).get(paramInt)) + ";");
          }
          paramInt += 1;
        }
      }
      long l = paramRespGetDiscussInfo.DiscussFlag;
      this.a.c = bbcz.a(this.a.app, this.a.d, String.valueOf(this.a.jdField_a_of_type_Long), l | 0x20000000, paramRespGetDiscussInfo.Name, localHashMap);
      if (this.a.jdField_a_of_type_JavaUtilArrayList.size() == this.a.jdField_b_of_type_Int) {
        ThreadManager.post(new JoinDiscussionActivity.MyDiscussionObserver.1(this), 8, null, true);
      }
      JoinDiscussionActivity.a(this.a);
      if (TextUtils.isEmpty(this.a.e)) {
        ((FriendListHandler)this.a.app.a(1)).a(this.a.jdField_a_of_type_Long + "", false);
      }
      return;
    }
    this.a.a(0, paramInt);
  }
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt)
  {
    String str;
    if (paramBoolean)
    {
      axqy.b(this.a.app, "CliOper", "", this.a.app.getCurrentAccountUin(), "discuss", "discuss_QR_join", 0, 0, "", "", "", "");
      this.a.stopTitleProgress();
      str = String.valueOf(paramLong);
      if ((str != null) && (str.length() > 0))
      {
        if (this.a.jdField_a_of_type_JavaUtilList == null) {
          break label290;
        }
        paramLong = Long.parseLong(this.a.app.getCurrentAccountUin());
        paramInt = 0;
        if (paramInt >= this.a.jdField_a_of_type_JavaUtilList.size()) {
          break label290;
        }
        if (((DiscussMemberInfo)this.a.jdField_a_of_type_JavaUtilList.get(paramInt)).Uin != paramLong) {
          break label270;
        }
      }
    }
    label270:
    label290:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt != 0) {
        bcql.a(this.a, ajya.a(2131705883), 0).b(this.a.getTitleBarHeight());
      }
      Intent localIntent = actj.a(new Intent(this.a, SplashActivity.class), null);
      localIntent.putExtra("uin", str);
      localIntent.putExtra("uintype", 3000);
      localIntent.putExtra("uinname", this.a.c);
      localIntent.putExtra("isBack2Root", true);
      localIntent.putExtra("isFromDiscussionFlyTicket", true);
      this.a.startActivity(localIntent);
      this.a.finish();
      return;
      paramInt += 1;
      break;
      this.a.a(1, paramInt);
      return;
    }
  }
  
  protected void c(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      this.a.jdField_a_of_type_JavaLangString = paramString;
      this.a.jdField_a_of_type_Ajvg.c(this.a.jdField_a_of_type_JavaLangString);
      return;
    }
    this.a.a(0, -161);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abjo
 * JD-Core Version:    0.7.0.1
 */