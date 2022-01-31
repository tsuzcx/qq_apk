import NS_MOBILE_MAIN_PAGE.mobile_sub_get_cover_rsp;
import NS_MOBILE_MAIN_PAGE.mobile_sub_get_photo_wall_rsp;
import android.os.Bundle;
import com.tencent.mobileqq.app.CardObserver.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.CardProfile;
import com.tencent.mobileqq.data.LikeRankingInfo;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearpeople.mytab.NearbyMyTabCard;
import com.tencent.qidian.data.BmqqAccountType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class ajfo
  implements ajfe
{
  protected void onAddPortrait(boolean paramBoolean, String paramString, int paramInt, Card paramCard) {}
  
  protected void onCardDownload(boolean paramBoolean, Object paramObject) {}
  
  protected void onCardInBlackList(boolean paramBoolean, String paramString) {}
  
  protected void onCardLabelUpdate(boolean paramBoolean, Object paramObject) {}
  
  protected void onCoverUpdate(boolean paramBoolean, Card paramCard) {}
  
  protected void onDelQZonePhotoWall(boolean paramBoolean, String paramString) {}
  
  protected void onDeletePortrait(boolean paramBoolean, Card paramCard, int paramInt, byte[] paramArrayOfByte) {}
  
  protected void onFavoritorsList(boolean paramBoolean, String paramString, ArrayList<CardProfile> paramArrayList, long paramLong1, long paramLong2, byte[] paramArrayOfByte, Card paramCard) {}
  
  protected void onForceUpdateNearbyProfile(boolean paramBoolean, NearbyPeopleCard paramNearbyPeopleCard) {}
  
  protected void onGetAccountType(boolean paramBoolean, BmqqAccountType paramBmqqAccountType) {}
  
  protected void onGetAllowActivateFriend(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onGetAllowSeeLoginDays(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onGetAllowStrangerInviteToGroupSwitch(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {}
  
  protected void onGetAutoReplyList(boolean paramBoolean, List<AutoReplyText> paramList, int paramInt) {}
  
  protected void onGetBabyQSwitch(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onGetCalReactiveDays(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onGetCardSwitch(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3) {}
  
  public void onGetCareBarEnable(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onGetCommonSwitchFromDetailInfo(boolean paramBoolean, short[] paramArrayOfShort, Map<Short, Short> paramMap) {}
  
  protected void onGetConnectionsSwitch(boolean paramBoolean, int paramInt1, int paramInt2) {}
  
  protected void onGetDetailInfo(boolean paramBoolean, String paramString, Card paramCard) {}
  
  protected void onGetEducationList(boolean paramBoolean, long paramLong, ArrayList<atxp> paramArrayList) {}
  
  protected void onGetHelloLiveMessageState(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onGetHiddenSession(boolean paramBoolean) {}
  
  protected void onGetKplCard(boolean paramBoolean, Object paramObject) {}
  
  protected void onGetLocationDescription(boolean paramBoolean, String paramString, Card paramCard) {}
  
  protected void onGetMedal(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onGetNearbyMyTabCard(boolean paramBoolean, NearbyMyTabCard paramNearbyMyTabCard) {}
  
  public void onGetNotDisturb(boolean paramBoolean, String paramString1, String paramString2) {}
  
  protected void onGetNotifyOnLikeRankingList(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onGetPCActiveState(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onGetPartakeLikeRankingList(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onGetPhoneNumSearchable(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onGetPrettyOwnerFlag(boolean paramBoolean, Object paramObject) {}
  
  protected void onGetQZoneCover(boolean paramBoolean, String paramString, mobile_sub_get_cover_rsp parammobile_sub_get_cover_rsp) {}
  
  protected void onGetQZonePhotoWall(boolean paramBoolean, String paramString1, mobile_sub_get_photo_wall_rsp parammobile_sub_get_photo_wall_rsp, String paramString2) {}
  
  protected void onGetSelfAddFriendSetting(boolean paramBoolean, int paramInt) {}
  
  protected void onGetShoppingInfo(boolean paramBoolean, String paramString, List<atxq> paramList, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected void onGetSignInInfo(boolean paramBoolean) {}
  
  protected void onGetWholePeopleVoteLebaSwitch(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {}
  
  protected void onGotGroupInfo(boolean paramBoolean, String paramString, Card paramCard) {}
  
  protected void onGotPagedAlbumKeys(boolean paramBoolean, String paramString, ArrayList<String> paramArrayList, long paramLong, byte[] paramArrayOfByte) {}
  
  protected void onGreetingRecv(boolean paramBoolean, String paramString) {}
  
  protected void onGreetingSent(boolean paramBoolean, String paramString) {}
  
  protected void onImpeach(boolean paramBoolean, String paramString) {}
  
  protected void onLabelLikeSet(boolean paramBoolean, Card paramCard, long paramLong) {}
  
  protected void onMedalChange(boolean paramBoolean, Card paramCard) {}
  
  protected void onNearByProfileSymbolGet(boolean paramBoolean, int paramInt) {}
  
  protected void onNewVotePush(boolean paramBoolean, String paramString, int paramInt, Card paramCard) {}
  
  protected void onPortraitVerifyCode(boolean paramBoolean, String paramString1, String paramString2) {}
  
  protected void onReqAlbum(boolean paramBoolean1, Card paramCard, boolean paramBoolean2) {}
  
  protected void onReqApplyUploadVoice(boolean paramBoolean, String paramString) {}
  
  protected void onReqDelVoteRecord(boolean paramBoolean, long paramLong1, long paramLong2, int paramInt) {}
  
  protected void onReqFavoriteResult(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2) {}
  
  protected void onReqFavoriteResultRank(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2) {}
  
  protected void onReqLikeRankingListResult(boolean paramBoolean1, String paramString, List<LikeRankingInfo> paramList, int paramInt, boolean paramBoolean2) {}
  
  protected void onSetAllowActivateFriend(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onSetAllowSeeLoginDays(boolean paramBoolean) {}
  
  protected void onSetAutoReplyList(boolean paramBoolean) {}
  
  protected void onSetBabyQSwitch(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onSetCalReactiveDays(boolean paramBoolean) {}
  
  protected void onSetCardSwitch(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3) {}
  
  public void onSetCardTemplateReturn(boolean paramBoolean, Object paramObject) {}
  
  protected void onSetCareBarEnable(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onSetCommonSwitchFromDetailInfo(boolean paramBoolean, short paramShort1, short paramShort2) {}
  
  protected void onSetConnectionsSwitch(boolean paramBoolean, int paramInt1, int paramInt2) {}
  
  protected void onSetDetailInfo(boolean paramBoolean, int paramInt, Card paramCard) {}
  
  protected void onSetEmotionRecSwitch(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onSetHelloLiveMessageState(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2) {}
  
  protected void onSetHiddenSession(boolean paramBoolean, int paramInt) {}
  
  protected void onSetMedal(boolean paramBoolean) {}
  
  protected void onSetNick(boolean paramBoolean, String paramString) {}
  
  protected void onSetNotDisturb(boolean paramBoolean, String paramString1, String paramString2) {}
  
  protected void onSetNotifyOnLikeRankingList(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onSetPCActiveState(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2) {}
  
  protected void onSetPartakeLikeRankingList(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onSetPhoneNumSearchable(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onSetPrettyOwnerFlag(boolean paramBoolean, Object paramObject) {}
  
  protected void onSetPttAutoToTxtSwitch(boolean paramBoolean, Object paramObject) {}
  
  protected void onSetShowPushNotice(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onSetSubaccountDisplayThirdQQ(boolean paramBoolean) {}
  
  protected void onSingleStatus(boolean paramBoolean, Card paramCard) {}
  
  protected void onTagsUpdate(boolean paramBoolean, Card paramCard) {}
  
  protected void onTransferVoice(boolean paramBoolean, String paramString1, String paramString2, int paramInt) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    }
    label1832:
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
                            Object localObject1;
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
                                                          do
                                                          {
                                                            do
                                                            {
                                                              do
                                                              {
                                                                do
                                                                {
                                                                  return;
                                                                  onCardDownload(paramBoolean, paramObject);
                                                                  return;
                                                                  onCardLabelUpdate(paramBoolean, paramObject);
                                                                  return;
                                                                  if (!paramBoolean) {
                                                                    break;
                                                                  }
                                                                } while (!(paramObject instanceof Object[]));
                                                                paramObject = (Object[])paramObject;
                                                                onLabelLikeSet(paramBoolean, (Card)paramObject[0], ((Long)paramObject[1]).longValue());
                                                                return;
                                                              } while (!(paramObject instanceof Card));
                                                              onLabelLikeSet(paramBoolean, (Card)paramObject, -1L);
                                                              return;
                                                            } while (!(paramObject instanceof Object[]));
                                                            paramObject = (Object[])paramObject;
                                                            onVoiceManager(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), (Card)paramObject[2]);
                                                            return;
                                                            onCardInBlackList(paramBoolean, ((Bundle)paramObject).getString("uin"));
                                                            return;
                                                            if (paramBoolean)
                                                            {
                                                              onUpdateCard(paramBoolean, (Card)paramObject);
                                                              return;
                                                            }
                                                            onUpdateCard(paramBoolean, null);
                                                            return;
                                                            onVoteResult(paramBoolean, ((Bundle)paramObject).getString("targetUin"));
                                                            return;
                                                          } while (!(paramObject instanceof Bundle));
                                                          paramObject = (Bundle)paramObject;
                                                          if (paramObject.getInt("favoriteSource") == 43)
                                                          {
                                                            onReqFavoriteResultRank(paramBoolean, paramObject.getString("selfUin"), paramObject.getString("targetUin"), paramObject.getInt("toplist_type"), paramObject.getInt("iCount", 0));
                                                            return;
                                                          }
                                                          onReqFavoriteResult(paramBoolean, paramObject.getString("selfUin"), paramObject.getString("targetUin"), paramObject.getInt("iCount", 0), paramObject.getInt("from", 0));
                                                          return;
                                                          Object localObject3;
                                                          if (paramBoolean)
                                                          {
                                                            Object localObject4 = (Object[])paramObject;
                                                            paramObject = (Card)localObject4[0];
                                                            localObject1 = (Bundle)localObject4[1];
                                                            localObject2 = (ArrayList)localObject4[2];
                                                            localObject3 = (ArrayList)localObject4[3];
                                                            paramInt = ((Integer)localObject4[4]).intValue();
                                                            int i = ((Integer)localObject4[5]).intValue();
                                                            int j = ((Integer)localObject4[6]).intValue();
                                                            int k = ((Integer)localObject4[7]).intValue();
                                                            int m = ((Integer)localObject4[8]).intValue();
                                                            localObject4 = ((Bundle)localObject1).getString("uin");
                                                            l1 = ((Bundle)localObject1).getLong("nextMid");
                                                            onVoterList(true, (String)localObject4, (ArrayList)localObject2, (ArrayList)localObject3, paramInt, i, j, k, m, ((Bundle)localObject1).getLong("startMid"), l1, ((Bundle)localObject1).getByteArray("strCookie"), paramObject);
                                                            return;
                                                          }
                                                          onVoterList(false, ((Bundle)((Object[])(Object[])paramObject)[1]).getString("uin"), null, null, -1, -1, -1, -1, -1, -1L, -1L, null, null);
                                                          return;
                                                          if (paramBoolean)
                                                          {
                                                            localObject2 = (Object[])paramObject;
                                                            paramObject = (Card)localObject2[0];
                                                            localObject1 = (Bundle)localObject2[1];
                                                            localObject2 = (ArrayList)localObject2[2];
                                                            localObject3 = ((Bundle)localObject1).getString("uin");
                                                            l1 = ((Bundle)localObject1).getLong("nextMid");
                                                            onFavoritorsList(true, (String)localObject3, (ArrayList)localObject2, ((Bundle)localObject1).getLong("startMid"), l1, ((Bundle)localObject1).getByteArray("strCookie"), paramObject);
                                                            return;
                                                          }
                                                          onFavoritorsList(false, ((Bundle)((Object[])(Object[])paramObject)[1]).getString("uin"), null, -1L, -1L, null, null);
                                                          return;
                                                          paramObject = (Object[])paramObject;
                                                          onReqDelVoteRecord(paramBoolean, ((Long)paramObject[0]).longValue(), ((Long)paramObject[1]).longValue(), ((Integer)paramObject[2]).intValue());
                                                          return;
                                                          if (paramBoolean)
                                                          {
                                                            paramObject = (Object[])paramObject;
                                                            localObject1 = (List)paramObject[0];
                                                            paramInt = ((Integer)paramObject[1]).intValue();
                                                            paramBoolean = ((Boolean)paramObject[2]).booleanValue();
                                                            onReqLikeRankingListResult(true, (String)paramObject[3], (List)localObject1, paramInt, paramBoolean);
                                                            return;
                                                          }
                                                          onReqLikeRankingListResult(false, (String)paramObject, null, 0, false);
                                                          return;
                                                          onUpdateAvatar(paramBoolean, ((Bundle)paramObject).getString("uin"));
                                                          return;
                                                          if (paramBoolean)
                                                          {
                                                            paramObject = (Object[])paramObject;
                                                            onReqAlbum(true, (Card)paramObject[0], ((Boolean)paramObject[1]).booleanValue());
                                                            return;
                                                          }
                                                          onReqAlbum(false, (Card)paramObject, false);
                                                          return;
                                                          if (paramBoolean)
                                                          {
                                                            paramObject = (Object[])paramObject;
                                                            localObject1 = (Card)paramObject[0];
                                                            onAddPortrait(paramBoolean, null, ((Bundle)paramObject[1]).getInt("retCode", -1), (Card)localObject1);
                                                            return;
                                                          }
                                                          paramInt = -1;
                                                          if ((paramObject instanceof Bundle)) {
                                                            paramInt = ((Bundle)paramObject).getInt("retCode", -1);
                                                          }
                                                          onAddPortrait(paramBoolean, null, paramInt, null);
                                                          return;
                                                        } while (!paramBoolean);
                                                        onUpdateSelfIntroduction(paramBoolean, (Card)paramObject);
                                                        return;
                                                        if (paramBoolean)
                                                        {
                                                          localObject1 = (Object[])paramObject;
                                                          paramObject = (Bundle)localObject1[0];
                                                          localObject1 = (Card)localObject1[1];
                                                          paramObject.getString("uin");
                                                          onDeletePortrait(paramBoolean, (Card)localObject1, paramObject.getInt("result", -1), paramObject.getByteArray("fileKey"));
                                                          return;
                                                        }
                                                        localObject1 = (Object[])paramObject;
                                                        paramObject = (Bundle)localObject1[0];
                                                        localObject1 = (Card)localObject1[1];
                                                        paramObject.getString("uin");
                                                        onDeletePortrait(paramBoolean, (Card)localObject1, paramObject.getInt("result", -1), paramObject.getByteArray("fileKey"));
                                                        return;
                                                        onGreetingSent(paramBoolean, ((Bundle)paramObject).getString("uin"));
                                                        return;
                                                        onGreetingRecv(paramBoolean, ((Bundle)paramObject).getString("uin"));
                                                        return;
                                                      } while (!paramBoolean);
                                                      paramObject = (Card)paramObject;
                                                      onGotGroupInfo(paramBoolean, paramObject.uin, paramObject);
                                                      return;
                                                    } while (!paramBoolean);
                                                    paramObject = (Card)paramObject;
                                                    onGetDetailInfo(paramBoolean, paramObject.uin, paramObject);
                                                    return;
                                                  } while ((!paramBoolean) || (paramObject == null));
                                                  paramObject = (Card)paramObject;
                                                  onGetLocationDescription(true, paramObject.uin, paramObject);
                                                  return;
                                                  paramObject = (Bundle)paramObject;
                                                  onPortraitVerifyCode(paramBoolean, paramObject.getString("uin"), paramObject.getString("filekey"));
                                                  return;
                                                  onImpeach(paramBoolean, ((Bundle)paramObject).getString("uin"));
                                                  return;
                                                  if (paramBoolean)
                                                  {
                                                    onSingleStatus(paramBoolean, (Card)paramObject);
                                                    return;
                                                  }
                                                  onSingleStatus(paramBoolean, null);
                                                  return;
                                                  paramObject = (Card)paramObject;
                                                  if (paramBoolean)
                                                  {
                                                    onCoverUpdate(paramBoolean, paramObject);
                                                    return;
                                                  }
                                                  onCoverUpdate(paramBoolean, paramObject);
                                                  return;
                                                  onSetCardTemplateReturn(paramBoolean, paramObject);
                                                  return;
                                                  paramObject = (Bundle)paramObject;
                                                  localObject1 = paramObject.getString("lUin");
                                                  l1 = paramObject.getLong("nextMid");
                                                  Object localObject2 = paramObject.getByteArray("strCookie");
                                                  onGotPagedAlbumKeys(paramBoolean, (String)localObject1, paramObject.getStringArrayList("hexFaceInfo"), l1, (byte[])localObject2);
                                                  return;
                                                } while (!paramBoolean);
                                                localObject1 = (Object[])paramObject;
                                                paramObject = (Card)localObject1[0];
                                                localObject1 = (Bundle)localObject1[1];
                                                ((Bundle)localObject1).getString("uin");
                                                paramInt = ((Bundle)localObject1).getInt("newVoteCount");
                                                onNewVotePush(paramBoolean, ((Bundle)localObject1).getString("voteeUin"), paramInt, paramObject);
                                                return;
                                                paramObject = (Object[])paramObject;
                                                onSetDetailInfo(paramBoolean, ((Integer)paramObject[0]).intValue(), (Card)paramObject[1]);
                                                return;
                                                paramObject = (Bundle)paramObject;
                                                onSetCardSwitch(paramBoolean, paramObject.getString("uin"), paramObject.getBoolean("modify_switch_for_near_people"), paramObject.getBoolean("target_switch"));
                                                return;
                                                paramObject = (Bundle)paramObject;
                                                localObject1 = paramObject.getString("uin");
                                                long l1 = paramObject.getLong("uCloseNeighborVote", 0L);
                                                long l2 = paramObject.getLong("uColseTimeEntityManager", 0L);
                                                boolean bool1;
                                                if (l1 == 0L)
                                                {
                                                  bool1 = true;
                                                  if (l2 != 0L) {
                                                    break label1832;
                                                  }
                                                }
                                                for (boolean bool2 = true;; bool2 = false)
                                                {
                                                  onGetCardSwitch(paramBoolean, (String)localObject1, bool1, bool2);
                                                  return;
                                                  bool1 = false;
                                                  break;
                                                }
                                                onReqApplyUploadVoice(paramBoolean, ((Bundle)paramObject).getString("pttcenter_selfuin"));
                                                return;
                                                paramObject = (Bundle)paramObject;
                                                localObject1 = paramObject.getString("pttcenter_selfuin");
                                                paramInt = paramObject.getInt("pttcenter_voice_optype");
                                                onTransferVoice(paramBoolean, (String)localObject1, paramObject.getString("pttcenter_filekey"), paramInt);
                                                return;
                                                onGetPhoneNumSearchable(paramBoolean, ((Boolean)paramObject).booleanValue());
                                                return;
                                                onSetPhoneNumSearchable(paramBoolean, ((Boolean)paramObject).booleanValue());
                                                return;
                                              } while (paramObject == null);
                                              paramObject = (Object[])paramObject;
                                              onGetQZoneCover(paramBoolean, (String)paramObject[0], (mobile_sub_get_cover_rsp)paramObject[1]);
                                              return;
                                            } while (paramObject == null);
                                            paramObject = (Object[])paramObject;
                                            onGetQZonePhotoWall(paramBoolean, (String)paramObject[0], (mobile_sub_get_photo_wall_rsp)paramObject[1], (String)paramObject[2]);
                                            return;
                                          } while (paramObject == null);
                                          onDelQZonePhotoWall(paramBoolean, (String)((Object[])(Object[])paramObject)[0]);
                                          return;
                                        } while (paramObject == null);
                                        onUploadQZonePhotoWall(paramBoolean, paramObject);
                                        return;
                                        onGetPCActiveState(paramBoolean, Boolean.parseBoolean(paramObject.toString()));
                                        return;
                                      } while (!(paramObject instanceof Object[]));
                                      paramObject = (Object[])paramObject;
                                      onSetPCActiveState(paramBoolean, Boolean.parseBoolean(paramObject[0].toString()), paramObject[1].toString(), paramObject[2].toString());
                                      return;
                                    } while (!(paramObject instanceof Object[]));
                                    paramObject = (Object[])paramObject;
                                    onSetHelloLiveMessageState(paramBoolean, Boolean.parseBoolean(paramObject[0].toString()), paramObject[1].toString(), paramObject[2].toString());
                                    return;
                                    onGetHelloLiveMessageState(paramBoolean, Boolean.parseBoolean(paramObject.toString()));
                                    return;
                                    onGetAllowSeeLoginDays(paramBoolean, ((Boolean)paramObject).booleanValue());
                                    return;
                                    onSetAllowSeeLoginDays(paramBoolean);
                                    return;
                                    onGetNotifyOnLikeRankingList(paramBoolean, ((Boolean)paramObject).booleanValue());
                                    return;
                                    onSetNotifyOnLikeRankingList(paramBoolean, ((Boolean)paramObject).booleanValue());
                                    return;
                                    onSetPartakeLikeRankingList(paramBoolean, ((Boolean)paramObject).booleanValue());
                                    return;
                                    onGetPartakeLikeRankingList(paramBoolean, ((Boolean)paramObject).booleanValue());
                                    return;
                                    onGetCalReactiveDays(paramBoolean, ((Boolean)paramObject).booleanValue());
                                    return;
                                    onSetCalReactiveDays(paramBoolean);
                                    return;
                                    paramObject = (Object[])paramObject;
                                    if ((paramObject != null) && (paramObject.length == 2))
                                    {
                                      onUploadQzonePhoto(paramBoolean, ((Integer)paramObject[0]).intValue(), (String)paramObject[1]);
                                      return;
                                    }
                                    onUploadQzonePhoto(false, 0, "");
                                    return;
                                    onNearByProfileSymbolGet(paramBoolean, ((Integer)paramObject).intValue());
                                    return;
                                    onGetAllowActivateFriend(paramBoolean, ((Boolean)paramObject).booleanValue());
                                    return;
                                    onSetAllowActivateFriend(paramBoolean, ((Boolean)paramObject).booleanValue());
                                    return;
                                    paramObject = (String[])paramObject;
                                  } while ((paramObject == null) || (paramObject.length != 2));
                                  onGetNotDisturb(paramBoolean, paramObject[0], paramObject[1]);
                                  return;
                                  paramObject = (String[])paramObject;
                                } while ((paramObject == null) || (paramObject.length != 2));
                                onSetNotDisturb(paramBoolean, paramObject[0], paramObject[1]);
                                return;
                                onGetHiddenSession(paramBoolean);
                                return;
                                if (paramObject == null) {}
                                for (paramInt = 0;; paramInt = ((Integer)paramObject).intValue())
                                {
                                  onSetHiddenSession(paramBoolean, paramInt);
                                  return;
                                }
                                onGetBabyQSwitch(paramBoolean, ((Boolean)paramObject).booleanValue());
                                return;
                                onSetBabyQSwitch(paramBoolean, ((Boolean)paramObject).booleanValue());
                                return;
                                onUpdateSetCallTabVisible(paramBoolean, ((Boolean)paramObject).booleanValue());
                                return;
                                onForceUpdateNearbyProfile(paramBoolean, (NearbyPeopleCard)paramObject);
                                return;
                              } while (paramObject == null);
                              localObject1 = (Object[])paramObject;
                              paramInt = ((Integer)localObject1[0]).intValue();
                              paramObject = (Long)localObject1[1];
                              localObject1 = (Long)localObject1[2];
                            } while ((paramObject == null) || (localObject1 == null));
                            reqShoppingInfo(paramBoolean, paramInt, paramObject.toString(), ((Long)localObject1).toString());
                            return;
                          } while (paramObject == null);
                          paramObject = (Object[])paramObject;
                        } while (paramObject == null);
                        onGetShoppingInfo(paramBoolean, paramObject[0].toString(), (ArrayList)paramObject[1], ((Integer)paramObject[2]).intValue(), ((Integer)paramObject[3]).intValue(), ((Integer)paramObject[4]).intValue());
                        return;
                        onSetMedal(paramBoolean);
                        return;
                        onGetMedal(paramBoolean, ((Boolean)paramObject).booleanValue());
                        return;
                        if ((paramBoolean) && ((paramObject instanceof Object[]))) {
                          onGetNearbyMyTabCard(paramBoolean, (NearbyMyTabCard)((Object[])(Object[])paramObject)[0]);
                        }
                        for (;;)
                        {
                          onGetAccountType(paramBoolean, (BmqqAccountType)paramObject);
                          return;
                          onGetNearbyMyTabCard(false, null);
                        }
                        onSetSubaccountDisplayThirdQQ(paramBoolean);
                        return;
                        onGetSignInInfo(paramBoolean);
                        return;
                        onGetAccountType(paramBoolean, (BmqqAccountType)paramObject);
                        return;
                        onGetKplCard(paramBoolean, paramObject);
                        return;
                      } while (!(paramObject instanceof Object[]));
                      paramObject = (Object[])paramObject;
                      onGetCommonSwitchFromDetailInfo(paramBoolean, (short[])paramObject[0], (Map)paramObject[1]);
                      return;
                    } while (!(paramObject instanceof Object[]));
                    paramObject = (Object[])paramObject;
                    onSetCommonSwitchFromDetailInfo(paramBoolean, ((Short)paramObject[0]).shortValue(), ((Short)paramObject[1]).shortValue());
                    return;
                  } while (!(paramObject instanceof Object[]));
                  paramObject = (Object[])paramObject;
                  onGetWholePeopleVoteLebaSwitch(paramBoolean, ((Boolean)paramObject[0]).booleanValue(), ((Boolean)paramObject[1]).booleanValue());
                  return;
                  onMedalChange(paramBoolean, (Card)paramObject);
                  return;
                  onSetShowPushNotice(paramBoolean, ((Boolean)paramObject).booleanValue());
                  return;
                  onSetNick(paramBoolean, (String)paramObject);
                  return;
                  if ((paramObject != null) && ((paramObject instanceof Object[])))
                  {
                    paramObject = (Object[])paramObject;
                    onGetAllowStrangerInviteToGroupSwitch(paramBoolean, ((Boolean)paramObject[0]).booleanValue(), ((Boolean)paramObject[1]).booleanValue());
                    return;
                  }
                  onGetAllowStrangerInviteToGroupSwitch(false, false, false);
                  return;
                } while (!(paramObject instanceof Object[]));
                paramObject = (Object[])paramObject;
                onGetAutoReplyList(paramBoolean, (List)paramObject[0], ((Integer)paramObject[1]).intValue());
                return;
                onSetAutoReplyList(paramBoolean);
                return;
              } while (!(paramObject instanceof Object[]));
              paramObject = (Object[])paramObject;
            } while (paramObject.length < 2);
            onGetEducationList(paramBoolean, ((Long)paramObject[0]).longValue(), (ArrayList)paramObject[1]);
            return;
            onSetCareBarEnable(paramBoolean, Boolean.parseBoolean(paramObject.toString()));
            return;
            paramObject = new CardObserver.1(this, paramBoolean, paramObject);
            ThreadManager.getUIHandler().post(paramObject);
            return;
            onSetEmotionRecSwitch(paramBoolean, Boolean.parseBoolean(paramObject.toString()));
            return;
            onGetSelfAddFriendSetting(paramBoolean, ((Integer)paramObject).intValue());
            return;
            onSetPttAutoToTxtSwitch(paramBoolean, paramObject);
            return;
            onGetPrettyOwnerFlag(paramBoolean, paramObject);
            return;
            onSetPrettyOwnerFlag(paramBoolean, paramObject);
            return;
          } while (!(paramObject instanceof Object[]));
          paramObject = (Object[])paramObject;
        } while (paramObject.length < 2);
        onGetConnectionsSwitch(paramBoolean, ((Integer)paramObject[0]).intValue(), ((Integer)paramObject[1]).intValue());
        return;
      } while (!(paramObject instanceof Object[]));
      paramObject = (Object[])paramObject;
    } while (paramObject.length < 2);
    onSetConnectionsSwitch(paramBoolean, ((Integer)paramObject[0]).intValue(), ((Integer)paramObject[1]).intValue());
  }
  
  protected void onUpdateAvatar(boolean paramBoolean, String paramString) {}
  
  protected void onUpdateCard(boolean paramBoolean, Card paramCard) {}
  
  protected void onUpdateSelfIntroduction(boolean paramBoolean, Card paramCard) {}
  
  protected void onUpdateSetCallTabVisible(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onUploadQZonePhotoWall(boolean paramBoolean, Object paramObject) {}
  
  protected void onUploadQzonePhoto(boolean paramBoolean, int paramInt, String paramString) {}
  
  protected void onVisitorList(boolean paramBoolean, String paramString, ArrayList<CardProfile> paramArrayList, long paramLong1, long paramLong2, byte[] paramArrayOfByte) {}
  
  protected void onVoiceManager(boolean paramBoolean, String paramString, int paramInt, Card paramCard) {}
  
  protected void onVoteResult(boolean paramBoolean, String paramString) {}
  
  protected void onVoterList(boolean paramBoolean, String paramString, ArrayList<CardProfile> paramArrayList, ArrayList<Long> paramArrayList1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong1, long paramLong2, byte[] paramArrayOfByte, Card paramCard) {}
  
  protected void reqShoppingInfo(boolean paramBoolean, int paramInt, String paramString1, String paramString2) {}
  
  protected void simpleUpdate(boolean paramBoolean, String paramString, Card paramCard) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajfo
 * JD-Core Version:    0.7.0.1
 */