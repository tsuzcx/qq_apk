import android.app.Activity;
import android.app.Dialog;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.nearby.NearbyLikeLimitManager;
import com.tencent.mobileqq.nearby.business.NearbyCardHandler;
import com.tencent.mobileqq.nearby.business.NearbyCardObserver;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayBasePanel;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditBasePanel;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.util.NearbyProfileUtil;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ProfilePerformanceReport;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x5ea.UpdatePhotoList.HeadInfo;

public class afhj
  extends NearbyCardObserver
{
  public afhj(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  protected void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, String paramString)
  {
    if ((NearbyPeopleProfileActivity.a(this.a) == null) || (NearbyPeopleProfileActivity.a(this.a) == null)) {}
    String str;
    do
    {
      return;
      NearbyPeopleProfileActivity.a(this.a).charm = paramInt3;
      NearbyPeopleProfileActivity.a(this.a).charmLevel = paramInt4;
      NearbyPeopleProfileActivity.a(this.a).curThreshold = paramInt5;
      NearbyPeopleProfileActivity.a(this.a).nextThreshold = paramInt6;
      NearbyPeopleProfileActivity.a(this.a).a(NearbyPeopleProfileActivity.a(this.a));
      if (QLog.isColorLevel()) {
        QLog.d("Charm", 2, "onGetCharmNotify() uin=" + this.a.app.getCurrentAccountUin());
      }
      str = StringUtil.a(paramString, "<head>", "</head>");
      paramString = StringUtil.a(paramString, "<body>", "</body>");
    } while (!this.a.isResume());
    QQUtils.a(this.a, str, paramString, paramInt3 - paramInt1).show();
  }
  
  protected void a(String paramString, int paramInt)
  {
    if (NearbyPeopleProfileActivity.a(this.a) != null) {
      NearbyPeopleProfileActivity.a(this.a).a(paramString, paramInt);
    }
    this.a.o = paramInt;
  }
  
  protected void a(boolean paramBoolean, int paramInt, List paramList1, List paramList2)
  {
    if (NearbyPeopleProfileActivity.a(this.a) != null) {
      NearbyPeopleProfileActivity.a(this.a).a(paramBoolean, paramInt, paramList1);
    }
  }
  
  public void a(boolean paramBoolean1, long paramLong, boolean paramBoolean2, boolean paramBoolean3, byte[] paramArrayOfByte, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ongetShowLove ").append("issuccess = ").append(paramBoolean1).append(" uin = ").append(paramLong).append(" canChat = ").append(paramBoolean2).append(" can ShowLove = ").append(paramBoolean3).append("sig:").append(paramArrayOfByte).append(paramString);
    DatingUtil.c("profileCard", new Object[] { ((StringBuilder)localObject).toString() });
    localObject = this.a;
    if (this.a.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.a.jdField_a_of_type_AndroidOsHandler.removeMessages(204);
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(205);
    }
    if (paramBoolean1) {
      if (paramBoolean2)
      {
        DatingUtil.c(NearbyPeopleProfileActivity.class.getSimpleName(), new Object[] { "onGetShowLoveLimit , can chat, someting is wrong" });
        NearbyPeopleProfileActivity.a(this.a).l();
      }
    }
    for (;;)
    {
      this.a.n = false;
      return;
      if (paramBoolean3)
      {
        if (NearbyPeopleProfileActivity.a(this.a) != null)
        {
          paramArrayOfByte = NearbyPeopleProfileActivity.a(this.a).uin;
          paramArrayOfByte = NearbyPeopleProfileActivity.a(this.a).nickname;
          int i = NearbyPeopleProfileActivity.a(this.a).gender;
          ProfileCardUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
          QLog.d("Q.nearby_people_card.", 1, "ShowLoveEditorActivity 已在725下架");
        }
      }
      else
      {
        DatingUtil.c(NearbyPeopleProfileActivity.class.getSimpleName(), new Object[] { "cant show love, wording is " + paramString });
        paramArrayOfByte = paramString;
        if (TextUtils.isEmpty(paramString)) {
          paramArrayOfByte = ((Activity)localObject).getResources().getString(2131437985);
        }
        DatingUtil.a(this.a, paramArrayOfByte);
        continue;
        DatingUtil.a((Activity)localObject, ((Activity)localObject).getString(2131437986));
      }
    }
  }
  
  protected void a(boolean paramBoolean1, NearbyPeopleCard paramNearbyPeopleCard, boolean paramBoolean2)
  {
    if ((paramNearbyPeopleCard != null) && ((paramNearbyPeopleCard.tinyId == 0L) || (paramNearbyPeopleCard.tinyId != this.a.jdField_a_of_type_Long)) && ((paramNearbyPeopleCard.uin == null) || (!paramNearbyPeopleCard.uin.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)))) {}
    label390:
    label430:
    label1079:
    label1097:
    do
    {
      Object localObject;
      do
      {
        return;
        this.a.a();
        localObject = ProfilePerformanceReport.b;
        if ((localObject != null) && (((ProfilePerformanceReport)localObject).a())) {
          ((ProfilePerformanceReport)localObject).b(6);
        }
        if ((paramNearbyPeopleCard != null) && (QLog.isColorLevel()))
        {
          StringBuilder localStringBuilder1 = new StringBuilder();
          StringBuilder localStringBuilder2 = localStringBuilder1.append("tinyid=").append(paramNearbyPeopleCard.tinyId).append(", uin=").append(paramNearbyPeopleCard.uin).append(", nickname=").append(paramNearbyPeopleCard.nickname).append(", gender=").append(paramNearbyPeopleCard.gender).append(", age=").append(paramNearbyPeopleCard.age).append(", birthday=").append(paramNearbyPeopleCard.birthday).append(", constellation=").append(paramNearbyPeopleCard.constellation).append(", distance=").append(paramNearbyPeopleCard.distance).append(", timeDiff=").append(paramNearbyPeopleCard.timeDiff).append(", photoInfoes=").append(paramNearbyPeopleCard.picInfo).append(", videoDetails=").append(paramNearbyPeopleCard.videoDetails).append(", commonLabelString=").append(paramNearbyPeopleCard.commonLabelString).append(", hiWanInfo=").append(paramNearbyPeopleCard.hiWanInfo).append(", videoInfo=").append(paramNearbyPeopleCard.videoInfo).append(", photoInfo_length=");
          if (paramNearbyPeopleCard.picList != null) {
            break;
          }
          localObject = "null";
          localStringBuilder2 = localStringBuilder2.append(localObject).append(", likeCount=").append(paramNearbyPeopleCard.likeCount).append(",likeCountInc=").append(paramNearbyPeopleCard.likeCountInc).append(", oldPhotoCount=").append(paramNearbyPeopleCard.oldPhotoCount).append(", dateInfo=").append(paramNearbyPeopleCard.dateInfo).append(", dateInfo_length=");
          if (paramNearbyPeopleCard.dateInfo != null) {
            break label1066;
          }
          localObject = "null";
          localStringBuilder2 = localStringBuilder2.append(localObject).append(", xuanYan=").append(paramNearbyPeopleCard.xuanYan).append(", xuanYan_length=");
          if (paramNearbyPeopleCard.xuanYan != null) {
            break label1079;
          }
          localObject = "null";
          localStringBuilder2.append(localObject).append(", maritalStatus=").append(paramNearbyPeopleCard.maritalStatus).append(", job=").append(paramNearbyPeopleCard.job).append(", charm=").append(paramNearbyPeopleCard.charm).append(",level=").append(paramNearbyPeopleCard.charmLevel).append(",next=").append(paramNearbyPeopleCard.nextThreshold).append(", company=").append(paramNearbyPeopleCard.company).append(", college=").append(paramNearbyPeopleCard.college).append(", hometownCountry=").append(paramNearbyPeopleCard.hometownCountry).append(", hometownProvice=").append(paramNearbyPeopleCard.hometownProvice).append(", hometownCity=").append(paramNearbyPeopleCard.hometownCity).append(", hometownDistrict=").append(paramNearbyPeopleCard.hometownDistrict).append(", bVoted=").append(paramNearbyPeopleCard.bVoted).append(", feedPreviewTime=").append(paramNearbyPeopleCard.feedPreviewTime).append(", qzoneFeed=").append(paramNearbyPeopleCard.qzoneFeed).append(", qzoneName=").append(paramNearbyPeopleCard.qzoneName).append(", qzonePicUrl_1=").append(paramNearbyPeopleCard.qzonePicUrl_1).append(", qzonePicUrl_2=").append(paramNearbyPeopleCard.qzonePicUrl_2).append(", qzonePicUrl_3=").append(paramNearbyPeopleCard.qzonePicUrl_3).append(", isPhotoUseCache=").append(paramNearbyPeopleCard.isPhotoUseCache).append(", switchQzone=").append(paramNearbyPeopleCard.switchQzone).append(", switchHobby=").append(paramNearbyPeopleCard.switchHobby).append(", uiShowControl=").append(paramNearbyPeopleCard.uiShowControl).append(", userFlag=").append(paramNearbyPeopleCard.userFlag).append(", strProfileUrl=").append(paramNearbyPeopleCard.strProfileUrl).append(", strVoteLimitedNotice=").append(paramNearbyPeopleCard.strVoteLimitedNotice).append(", bHaveVotedCnt=").append(paramNearbyPeopleCard.bHaveVotedCnt).append(", bAvailVoteCnt=").append(paramNearbyPeopleCard.bAvailVoteCnt).append(", hasStory=").append(paramNearbyPeopleCard.mHasStory);
          QLog.d("Q.nearby_people_card.", 2, "Q.nearby_people_card..onNearbyCardDownload(), isSuccess: " + paramBoolean1 + ", card = " + localStringBuilder1.toString());
        }
        if ((!paramBoolean1) || (paramNearbyPeopleCard == null)) {
          break label1097;
        }
        this.a.jdField_d_of_type_JavaLangString = paramNearbyPeopleCard.uin;
        this.a.b = true;
        NearbyPeopleProfileActivity.a(this.a, paramNearbyPeopleCard, false, paramBoolean2);
        this.a.g();
        if (QLog.isColorLevel()) {
          QLog.d("NearbyLikeLimitManager", 2, "onNearbyCardDownload: likeCount=" + paramNearbyPeopleCard.likeCount + ", bHaveVotedCnt=" + paramNearbyPeopleCard.bHaveVotedCnt + ", bAvailVoteCnt=" + paramNearbyPeopleCard.bAvailVoteCnt + ", bVoted=" + paramNearbyPeopleCard.bVoted);
        }
        ((NearbyLikeLimitManager)this.a.app.getManager(206)).a(paramNearbyPeopleCard.uin, false);
      } while (!paramNearbyPeopleCard.uin.equals(this.a.app.getCurrentAccountUin()));
      if ((paramNearbyPeopleCard.videoInfo != null) && (!TextUtils.isEmpty(paramNearbyPeopleCard.videoInfo.jdField_d_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramNearbyPeopleCard.videoInfo.jdField_a_of_type_JavaLangString))) {}
      for (paramBoolean1 = true;; paramBoolean1 = false)
      {
        SharedPreUtils.a(this.a, paramBoolean1);
        return;
        localObject = Integer.valueOf(paramNearbyPeopleCard.picList.size());
        break;
        localObject = Integer.valueOf(paramNearbyPeopleCard.dateInfo.length);
        break label390;
        localObject = Integer.valueOf(paramNearbyPeopleCard.xuanYan.length);
        break label430;
      }
    } while (paramBoolean2);
    label1066:
    this.a.b("加载失败");
  }
  
  public void a(boolean paramBoolean1, NearbyPeopleCard paramNearbyPeopleCard, boolean paramBoolean2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_people_card.update_profile", 2, "onEditNearbyProfileCard");
    }
    if (this.a.e != 1) {
      return;
    }
    if (paramBoolean1)
    {
      if (this.a.jdField_a_of_type_JavaUtilArrayList.size() > 1) {
        this.a.h = true;
      }
      NearbyPeopleProfileActivity.a(this.a);
      if (this.a.s)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardHandler.a(true);
        this.a.s = false;
      }
      this.a.getSharedPreferences("nearby_callback", 4).edit().putInt("nearby_now_edit_profile_code_int", 0);
    }
    this.a.a(paramBoolean1, paramNearbyPeopleCard, paramBoolean2, paramString);
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      paramString = (NearbyLikeLimitManager)this.a.app.getManager(206);
      if (NearbyPeopleProfileActivity.a(this.a) != null) {
        NearbyPeopleProfileActivity.a(this.a).h();
      }
      if ((this.a.e != 1) && (paramString.b()) && (!this.a.q))
      {
        this.a.q = true;
        paramString = new ImageView(this.a);
        paramString.setScaleType(ImageView.ScaleType.FIT_XY);
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        this.a.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable("http://pub.idqqimg.com/pc/misc/groupgift/zan.png", localURLDrawableOptions);
        if (this.a.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() != 1) {
          break label144;
        }
        this.a.a(paramString, this.a.jdField_a_of_type_ComTencentImageURLDrawable);
      }
    }
    return;
    label144:
    this.a.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(new afhk(this, paramString));
    this.a.jdField_a_of_type_ComTencentImageURLDrawable.startDownload();
  }
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if ((NearbyPeopleProfileActivity.a(this.a) == null) || (TextUtils.isEmpty(NearbyPeopleProfileActivity.a(this.a).uin)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1)) || (Utils.a(paramString2, paramString1))) {}
    do
    {
      do
      {
        return;
      } while ((!Utils.a(paramString2, NearbyPeopleProfileActivity.a(this.a).uin)) || (!Utils.a(paramString1, this.a.app.getCurrentAccountUin())));
      if (!paramBoolean)
      {
        this.a.b(this.a.getResources().getString(2131435803));
        paramString1 = NearbyPeopleProfileActivity.a(this.a);
        paramString1.likeCount -= 1;
        NearbyPeopleProfileActivity.a(this.a).bVoted = 0;
        paramString1 = NearbyPeopleProfileActivity.a(this.a);
        paramString1.bAvailVoteCnt = ((short)(paramString1.bAvailVoteCnt + paramInt1));
        NearbyPeopleProfileActivity.a(this.a).h();
        return;
      }
    } while (paramInt2 != 1);
    paramString1 = NearbyPeopleProfileActivity.a(this.a);
    paramString1.likeCount += paramInt1;
    NearbyPeopleProfileActivity.a(this.a).bVoted = 1;
    paramString1 = NearbyPeopleProfileActivity.a(this.a);
    paramString1.bAvailVoteCnt = ((short)(paramString1.bAvailVoteCnt - paramInt1));
    if (NearbyPeopleProfileActivity.a(this.a).bAvailVoteCnt < 0) {
      NearbyPeopleProfileActivity.a(this.a).bAvailVoteCnt = 0;
    }
    NearbyPeopleProfileActivity.a(this.a).h();
  }
  
  public void a(boolean paramBoolean, String paramString1, List paramList, String paramString2, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_people_card.update_profile", 2, "onSetPersonalInterestTags");
    }
    if (paramBoolean)
    {
      this.a.a();
      this.a.a(2, "添加成功。");
      return;
    }
    this.a.a();
    this.a.a(1, "添加失败," + paramString2);
  }
  
  protected void a(boolean paramBoolean, UpdatePhotoList.HeadInfo paramHeadInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_people_card.", 2, "onUpdateNearbyPeopleAuthVideo , uint32_headid = " + paramHeadInfo.uint32_headid.get() + ", str_headurl = " + paramHeadInfo.str_headurl.get() + ", str_video_url = " + paramHeadInfo.str_video_url.get());
    }
    byte[] arrayOfByte = NearbyPeopleProfileActivity.a(this.a).vSeed;
    long l = NearbyPeopleProfileActivity.a(this.a).feedPreviewTime;
    if (this.a.jdField_a_of_type_Long > 0L) {
      NearbyProfileUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardHandler, this.a.app, this.a.jdField_a_of_type_Long, null, this.a.jdField_d_of_type_Int, arrayOfByte, l, true, this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Long);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.nearby_people_card.update_profile", 2, "onUpdateNearbyPeopleAuthVideo + HeadInfo = " + paramHeadInfo.toString());
      }
      return;
      if (!StringUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) {
        NearbyProfileUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardHandler, this.a.app, 0L, this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.a.jdField_d_of_type_Int, arrayOfByte, l, true, this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Long);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afhj
 * JD-Core Version:    0.7.0.1
 */