import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.apollo.FriendCardApolloViewController;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.profile.ProfileShoppingPhotoInfo;
import com.tencent.mobileqq.profile.view.ProfileHeaderView;
import com.tencent.mobileqq.qcall.QCallCardInfo;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.widget.ProfileCardMoreInfoView;
import com.tencent.mobileqq.widget.VoteView;
import com.tencent.mobileqq.widget.VoteViewV2;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class aave
  implements Handler.Callback
{
  public aave(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject2 = null;
    boolean bool2 = false;
    boolean bool1 = false;
    Object localObject1;
    if (paramMessage.what == 3) {
      if ((paramMessage.obj instanceof Card))
      {
        localObject1 = (Card)paramMessage.obj;
        String str = ((Card)localObject1).uin;
        localObject2 = localObject1;
        localObject1 = str;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.FrdProfileCard", 2, "MSG_SWITCH_TO_FRIEND, uin = " + (String)localObject1 + ", obj: " + paramMessage.obj + "");
      }
      if ((localObject1 != null) && (((String)localObject1).length() > 0)) {
        this.a.a(localObject2, (String)localObject1);
      }
      label325:
      label376:
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              do
                              {
                                do
                                {
                                  do
                                  {
                                    int i;
                                    do
                                    {
                                      return true;
                                      if (!(paramMessage.obj instanceof String)) {
                                        break label1406;
                                      }
                                      localObject1 = (String)paramMessage.obj;
                                      break;
                                      if (paramMessage.what != 5) {
                                        break label427;
                                      }
                                      if (this.a.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.isAnimating())
                                      {
                                        this.a.jdField_a_of_type_JavaUtilArrayDeque.addLast(Message.obtain(paramMessage));
                                        return true;
                                      }
                                      if (paramMessage.arg1 != 1) {
                                        break label325;
                                      }
                                      bool1 = true;
                                      i = paramMessage.arg2;
                                    } while (!(paramMessage.obj instanceof Card));
                                    localObject1 = (Card)paramMessage.obj;
                                    this.a.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard = ((Card)localObject1);
                                    if (QLog.isColorLevel()) {
                                      QLog.d("Q.profilecard.FrdProfileCard", 2, "UI_MSG_UPDATE_CARD: isNegRet = " + bool1 + " msgSource = " + i);
                                    }
                                    this.a.a((Card)localObject1, bool1);
                                    if (i == 1) {
                                      this.a.jdField_a_of_type_Baiv.a("updateCardByDbEnd", false);
                                    }
                                    for (;;)
                                    {
                                      if ((paramMessage.arg2 != 12) && (paramMessage.arg2 != 11)) {
                                        break label376;
                                      }
                                      this.a.u();
                                      return true;
                                      bool1 = false;
                                      break;
                                      if ((i == 7) || (i == 8) || (paramMessage.arg2 == 12) || (paramMessage.arg2 == 11)) {
                                        this.a.jdField_a_of_type_Baiv.a("updateCardBySSOEnd", false);
                                      }
                                    }
                                    if (paramMessage.arg2 == 17)
                                    {
                                      this.a.v();
                                      return true;
                                    }
                                  } while (paramMessage.arg2 != 18);
                                  this.a.jdField_c_of_type_Boolean = false;
                                  this.a.a(this.a.jdField_a_of_type_Atwx);
                                  return true;
                                  if (paramMessage.what != 4) {
                                    break label485;
                                  }
                                  if (paramMessage.arg1 == 1) {
                                    bool1 = true;
                                  }
                                } while (!(paramMessage.obj instanceof ContactCard));
                                paramMessage = (ContactCard)paramMessage.obj;
                                this.a.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataContactCard = paramMessage;
                                this.a.a(paramMessage, bool1);
                                return true;
                                if (paramMessage.what != 6) {
                                  break label547;
                                }
                                bool1 = bool2;
                                if (paramMessage.arg1 == 1) {
                                  bool1 = true;
                                }
                              } while (!(paramMessage.obj instanceof QCallCardInfo));
                              paramMessage = (QCallCardInfo)paramMessage.obj;
                              this.a.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqQcallQCallCardInfo = paramMessage;
                              this.a.a(paramMessage, bool1);
                              return true;
                              if (paramMessage.what != 10) {
                                break label724;
                              }
                              if (this.a.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard != null)
                              {
                                if (QLog.isColorLevel()) {
                                  QLog.i("Q.profilecard.FrdProfileCard", 2, "initHeaderView timeout");
                                }
                                this.a.jdField_a_of_type_Atwx.jdField_a_of_type_Boolean = true;
                                this.a.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId = atxe.a;
                                this.a.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard.templateRet = 0;
                                this.a.jdField_a_of_type_Atwx.jdField_a_of_type_Atxe = null;
                                this.a.a(this.a.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard, false);
                                return true;
                              }
                            } while (this.a.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqQcallQCallCardInfo == null);
                            if (QLog.isColorLevel()) {
                              QLog.i("Q.profilecard.FrdProfileCard", 2, "initHeaderView timeout");
                            }
                            this.a.jdField_a_of_type_Atwx.jdField_a_of_type_Boolean = true;
                            this.a.jdField_a_of_type_Atwx.jdField_a_of_type_Atxe = null;
                            this.a.a(this.a.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqQcallQCallCardInfo, false);
                            return true;
                            if (paramMessage.what != 13) {
                              break label856;
                            }
                            if (!((Boolean)paramMessage.obj).booleanValue()) {
                              break label838;
                            }
                            paramMessage = new ProfileActivity.AllInOne(this.a.app.getCurrentAccountUin(), 0);
                            paramMessage.jdField_h_of_type_JavaLangString = this.a.app.getCurrentNickname();
                            paramMessage.g = 1;
                            paramMessage.jdField_h_of_type_Int = 5;
                          } while ((this.a.jdField_a_of_type_Atwx == null) || (this.a.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a.equals(this.a.app.getCurrentAccountUin())));
                          ProfileActivity.a(this.a, paramMessage);
                          return true;
                          Toast.makeText(this.a.getApplicationContext(), 2131629798, 0).show();
                          return true;
                          if (paramMessage.what != 12) {
                            break label1088;
                          }
                        } while ((this.a.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard == null) || ((atxe.f != this.a.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId) && (atxe.h != this.a.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId)) || (!(paramMessage.obj instanceof Bitmap)));
                        paramMessage = (Bitmap)paramMessage.obj;
                        localObject1 = (FrameLayout)this.a.findViewById(16908290);
                      } while ((localObject1 == null) || (((FrameLayout)localObject1).getChildCount() <= 0));
                      localObject1 = ((FrameLayout)localObject1).getChildAt(0);
                    } while (localObject1 == null);
                    paramMessage = new BitmapDrawable(this.a.getResources(), paramMessage);
                    paramMessage.setAlpha(0);
                    ((View)localObject1).setBackgroundDrawable(paramMessage);
                  } while (this.a.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId != atxe.h);
                  if (QLog.isColorLevel()) {
                    QLog.i("setShoppingBgBlur", 2, "setShoppingBgBlur");
                  }
                } while (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileShoppingPhotoInfo == null);
                new ArrayList();
              } while (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileShoppingPhotoInfo.getPhotoFromRawData().size() <= 0);
              this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.setShoppingBgBlur(true);
              return true;
              if (paramMessage.what != 100) {
                break label1126;
              }
            } while (FriendProfileCardActivity.a(this.a) == null);
            FriendProfileCardActivity.a(this.a).a(this.a.jdField_a_of_type_Atwx);
            return true;
            if (paramMessage.what != 14) {
              break label1256;
            }
            if (this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null) {
              break label1199;
            }
            paramMessage = (View)this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a.get("map_key_like");
            if ((paramMessage instanceof VoteView))
            {
              ((VoteView)paramMessage).a(true);
              return true;
            }
          } while (!(paramMessage instanceof VoteViewV2));
          ((VoteViewV2)paramMessage).a(true);
          return true;
        } while (paramMessage.arg1 <= 0);
        localObject1 = this.a.jdField_b_of_type_Befq.obtainMessage();
        ((Message)localObject1).what = paramMessage.what;
        ((Message)localObject1).arg1 = (paramMessage.arg1 - 1);
        this.a.jdField_b_of_type_Befq.sendMessageDelayed((Message)localObject1, 1000L);
        return true;
        if (paramMessage.what == 102)
        {
          FriendProfileCardActivity.a(this.a, paramMessage);
          return true;
        }
        if (paramMessage.what == 103)
        {
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(this.a.jdField_a_of_type_Atwx, true, new String[] { "map_key_medal" });
          return true;
        }
      } while (paramMessage.what != 104);
      label427:
      label485:
      label1126:
      label1256:
      paramMessage = (BusinessInfoCheckUpdate.RedTypeInfo)paramMessage.obj;
      label547:
      label724:
      label856:
      if (this.a.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch == null)
      {
        localObject1 = FriendProfileCardActivity.a(this.a, this.a.jdField_c_of_type_AndroidWidgetTextView, 5, 0, 5, 0);
        this.a.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this.a, (View)localObject1).a(53).d(5).a();
      }
      label838:
      this.a.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch.a(paramMessage);
      label1088:
      return true;
      label1199:
      label1406:
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aave
 * JD-Core Version:    0.7.0.1
 */