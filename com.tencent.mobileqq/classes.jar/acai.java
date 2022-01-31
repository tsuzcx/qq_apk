import android.os.Message;
import android.widget.TextView;
import com.tencent.mobileqq.app.NearFieldTroopObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendAnim;
import com.tencent.mobileqq.facetoface.Face2FaceFriendBubbleView;
import com.tencent.mobileqq.facetoface.Face2FaceGroupProfile;
import com.tencent.mobileqq.facetoface.Face2FaceTroopDetailView;
import com.tencent.mobileqq.facetoface.Face2FaceTroopFriendListAdapter;
import com.tencent.mobileqq.facetoface.Face2FaceUserData;
import com.tencent.mobileqq.facetoface.Face2FaceUserProfile;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import tencent.im.nearfield_group.nearfield_group.BusiRespHead;

public class acai
  extends NearFieldTroopObserver
{
  public acai(Face2FaceAddFriendActivity paramFace2FaceAddFriendActivity) {}
  
  public void a(Face2FaceGroupProfile paramFace2FaceGroupProfile)
  {
    Object localObject;
    boolean bool;
    if (QLog.isColorLevel())
    {
      localObject = Face2FaceAddFriendActivity.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder().append("onRecvTroopPush, from_type=").append(this.a.jdField_b_of_type_Int).append(",groupProfile isNull=");
      if (paramFace2FaceGroupProfile == null)
      {
        bool = true;
        QLog.d((String)localObject, 2, bool + ",show_type=");
      }
    }
    else if ((this.a.jdField_b_of_type_Int == 0) && (paramFace2FaceGroupProfile != null) && (!this.a.jdField_b_of_type_JavaUtilList.contains(paramFace2FaceGroupProfile)))
    {
      this.a.jdField_b_of_type_JavaUtilList.add(paramFace2FaceGroupProfile);
      if (this.a.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() != this.a.jdField_d_of_type_JavaUtilList.size()) {
        break label162;
      }
      Face2FaceAddFriendActivity.a(this.a, paramFace2FaceGroupProfile);
    }
    for (;;)
    {
      paramFace2FaceGroupProfile = this.a;
      paramFace2FaceGroupProfile.k += 1;
      return;
      bool = false;
      break;
      label162:
      localObject = Face2FaceAddFriendActivity.a(this.a).obtainMessage();
      ((Message)localObject).what = 10;
      ((Message)localObject).obj = paramFace2FaceGroupProfile;
      Face2FaceAddFriendActivity.a(this.a).sendEmptyMessageDelayed(10, 5000L);
    }
  }
  
  public void a(Face2FaceUserProfile paramFace2FaceUserProfile)
  {
    Object localObject;
    boolean bool;
    if (QLog.isColorLevel())
    {
      localObject = Face2FaceAddFriendActivity.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder().append("onRecvMemberPush, from_type=").append(this.a.jdField_b_of_type_Int).append(",fromTroopUin=").append(this.a.jdField_d_of_type_JavaLangString).append(",userProfile isNull=");
      if (paramFace2FaceUserProfile == null)
      {
        bool = true;
        QLog.d((String)localObject, 2, bool + "total:" + (this.a.jdField_a_of_type_JavaUtilList.size() + 1));
      }
    }
    else
    {
      if (paramFace2FaceUserProfile != null) {
        break label108;
      }
    }
    label108:
    do
    {
      long l1;
      long l2;
      long l3;
      do
      {
        return;
        bool = false;
        break;
        l1 = System.currentTimeMillis();
        l2 = l1 - this.a.jdField_f_of_type_Long;
        if ((this.a.jdField_f_of_type_Long == 0L) || (l2 >= 1000L) || (paramFace2FaceUserProfile.a != 0L)) {
          break label269;
        }
        localObject = Message.obtain();
        ((Message)localObject).what = 16;
        ((Message)localObject).obj = paramFace2FaceUserProfile;
        l3 = 1000L - l2;
        Face2FaceAddFriendActivity.a(this.a).sendMessageDelayed((Message)localObject, l3);
        paramFace2FaceUserProfile.a = l1;
        this.a.jdField_f_of_type_Long = (l1 + l3);
      } while (!QLog.isColorLevel());
      QLog.d(Face2FaceAddFriendActivity.jdField_b_of_type_JavaLangString, 2, "onRecvMemberPush, delay=" + l2 + ", delayed=" + l3 + ",mLastToopMemberPushStamp=" + this.a.jdField_f_of_type_Long);
      return;
      if (paramFace2FaceUserProfile.a == 0L) {
        this.a.jdField_f_of_type_Long = l1;
      }
    } while ((this.a.jdField_b_of_type_Int != 1) || (this.a.jdField_a_of_type_JavaUtilList.contains(paramFace2FaceUserProfile)));
    label269:
    this.a.jdField_a_of_type_JavaUtilList.add(paramFace2FaceUserProfile);
    if ((this.a.l) && (this.a.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceTroopFriendListAdapter != null))
    {
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(this.a.jdField_a_of_type_JavaUtilList.size()));
      this.a.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceTroopFriendListAdapter.a(paramFace2FaceUserProfile);
      return;
    }
    Face2FaceAddFriendActivity.a(this.a, paramFace2FaceUserProfile);
    this.a.e();
  }
  
  public void a(nearfield_group.BusiRespHead paramBusiRespHead)
  {
    boolean bool;
    if (QLog.isColorLevel())
    {
      String str = Face2FaceAddFriendActivity.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder().append("onCloseFace2faceTroop, respHead isNull=");
      if (paramBusiRespHead == null)
      {
        bool = true;
        QLog.d(str, 2, bool);
      }
    }
    else
    {
      if (paramBusiRespHead != null) {
        break label59;
      }
    }
    label59:
    int i;
    int j;
    int k;
    do
    {
      return;
      bool = false;
      break;
      i = paramBusiRespHead.int32_reply_code.get();
      j = paramBusiRespHead.int32_seq.get();
      k = paramBusiRespHead.int32_version.get();
      paramBusiRespHead = paramBusiRespHead.str_result.get();
    } while (!QLog.isColorLevel());
    QLog.d(Face2FaceAddFriendActivity.jdField_a_of_type_JavaLangString, 2, "onCloseFace2faceTroop, ret=" + i + ",seqNo=" + j + ",ver=" + k + ",errInfo=" + paramBusiRespHead + ",from_type=" + this.a.jdField_b_of_type_Int + ",fromTroopUin=" + this.a.jdField_d_of_type_JavaLangString);
  }
  
  public void a(nearfield_group.BusiRespHead paramBusiRespHead, String paramString)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    }
    if (paramBusiRespHead == null)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceTroopDetailView.a(-1, "", paramString, this.a.isFinishing());
      if (QLog.isColorLevel()) {
        QLog.d(Face2FaceAddFriendActivity.jdField_b_of_type_JavaLangString, 2, "onJoinTroop, respHead isNull=true, troopCode=" + paramString);
      }
    }
    int i;
    String str;
    do
    {
      return;
      i = paramBusiRespHead.int32_reply_code.get();
      int j = paramBusiRespHead.int32_seq.get();
      int k = paramBusiRespHead.int32_version.get();
      str = paramBusiRespHead.str_result.get();
      if (QLog.isColorLevel()) {
        QLog.d(Face2FaceAddFriendActivity.jdField_b_of_type_JavaLangString, 2, "onJoinTroop, ret=" + i + ", seqNo=" + j + ",ver=" + k + ",errInfo=" + str + ",troopCode=" + paramString + ",from_type=" + this.a.jdField_b_of_type_Int + ",fromTroopUin=" + this.a.jdField_d_of_type_JavaLangString);
      }
    } while (this.a.jdField_b_of_type_Int != 0);
    if (i == 0)
    {
      Iterator localIterator = this.a.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendAnim.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        paramBusiRespHead = (Face2FaceFriendBubbleView)localIterator.next();
        if ((paramBusiRespHead != null) && (paramBusiRespHead.a() == 2) && (paramString.equals(paramBusiRespHead.b())))
        {
          paramBusiRespHead.setStatusWithAnimation(2);
          paramBusiRespHead = paramBusiRespHead.a();
          if (!(paramBusiRespHead instanceof Face2FaceGroupProfile)) {
            break label477;
          }
        }
      }
    }
    label477:
    for (paramBusiRespHead = paramBusiRespHead.e + "_" + ((Face2FaceGroupProfile)paramBusiRespHead).jdField_b_of_type_JavaLangString;; paramBusiRespHead = paramString)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendAnim.a(paramBusiRespHead);
      paramBusiRespHead = Face2FaceAddFriendActivity.a(this.a).obtainMessage();
      paramBusiRespHead.what = 11;
      paramBusiRespHead.arg1 = 2;
      Face2FaceAddFriendActivity.a(this.a).sendMessageDelayed(paramBusiRespHead, this.a.a());
      break;
      ReportController.b(null, "P_CliOper", "Grp_set", "", "Radar_grp_guest", "suc_join", 0, 0, paramString, "7.6.0", "", this.a.app.getCurrentAccountUin());
      this.a.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceTroopDetailView.a(i, str, paramString, this.a.isFinishing());
      return;
    }
  }
  
  public void a(nearfield_group.BusiRespHead paramBusiRespHead, List paramList)
  {
    boolean bool2 = false;
    int i;
    boolean bool1;
    if (paramList == null)
    {
      i = 0;
      if (QLog.isColorLevel())
      {
        String str = Face2FaceAddFriendActivity.jdField_b_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder().append("onOpenFace2faceTroop, respHead isNull=");
        if (paramBusiRespHead != null) {
          break label176;
        }
        bool1 = true;
        label42:
        localStringBuilder = localStringBuilder.append(bool1).append(", troopList isNull=");
        bool1 = bool2;
        if (paramList == null) {
          bool1 = true;
        }
        QLog.d(str, 2, bool1 + ", troopList.size=" + i);
      }
      if (paramBusiRespHead != null) {
        break label182;
      }
      this.a.jdField_f_of_type_Int = 2;
      Face2FaceAddFriendActivity.d(this.a);
      if (this.a.jdField_b_of_type_Int == 1) {
        DialogUtil.b(this.a, 230, this.a.getString(2131434764), "分享失败，请稍后重试", 2131432998, 2131433502, new acaj(this), null).show();
      }
    }
    label176:
    label182:
    do
    {
      do
      {
        return;
        i = paramList.size();
        break;
        bool1 = false;
        break label42;
        i = paramBusiRespHead.int32_reply_code.get();
        int j = paramBusiRespHead.int32_seq.get();
        int k = paramBusiRespHead.int32_version.get();
        paramBusiRespHead = paramBusiRespHead.str_result.get();
        if (QLog.isColorLevel()) {
          QLog.d(Face2FaceAddFriendActivity.jdField_b_of_type_JavaLangString, 2, "onOpenFace2faceTroop, ret=" + i + ",seqNo=" + j + ",ver=" + k + ",errInfo=" + paramBusiRespHead + ",from_type=" + this.a.jdField_b_of_type_Int + ",fromTroopUin=" + this.a.jdField_d_of_type_JavaLangString);
        }
        if (i != 0) {
          break label418;
        }
        this.a.jdField_f_of_type_Int = 1;
      } while (this.a.jdField_b_of_type_Int != 0);
      if ((paramList != null) && (paramList.size() > 0)) {
        paramBusiRespHead = paramList.iterator();
      }
      for (;;)
      {
        if (paramBusiRespHead.hasNext())
        {
          paramList = (Face2FaceUserData)paramBusiRespHead.next();
          if (!this.a.jdField_b_of_type_JavaUtilList.contains(paramList)) {}
        }
        else
        {
          this.a.c = true;
          Face2FaceAddFriendActivity.d(this.a);
          return;
        }
        this.a.jdField_b_of_type_JavaUtilList.add(paramList);
      }
      this.a.jdField_f_of_type_Int = 2;
      Face2FaceAddFriendActivity.d(this.a);
    } while (this.a.jdField_b_of_type_Int != 1);
    label418:
    DialogUtil.b(this.a, 230, this.a.getString(2131434764), "分享失败，请稍后重试", 2131432998, 2131433502, new acak(this), null).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acai
 * JD-Core Version:    0.7.0.1
 */