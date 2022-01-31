import android.text.TextUtils;
import com.etrump.mixlayout.FontManager;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.flatbuffers.FlatBuffersParser;
import com.tencent.mobileqq.addon.DiyPendantFetcher;
import com.tencent.mobileqq.app.EmoticonHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.avatar.dynamicavatar.VasFaceManager;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.earlydownload.handler.PokeResHandler;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticon.VasEmojiManager;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.floatscr.ColorScreenManager;
import com.tencent.mobileqq.hiboom.HiBoomFont;
import com.tencent.mobileqq.hiboom.HiBoomFontDrawer;
import com.tencent.mobileqq.hiboom.HiBoomManager;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.profile.ProfileCardManager;
import com.tencent.mobileqq.profile.VipWZRYTemplateHelper;
import com.tencent.mobileqq.profile.diy.VipProfileDiyCardConfig;
import com.tencent.mobileqq.profile.like.PraiseConfigHelper;
import com.tencent.mobileqq.profile.like.PraiseManager;
import com.tencent.mobileqq.theme.ThemeSwitchManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.ThemeUtil.ThemeInfo;
import com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController;
import com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.VasUtils;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.ClubContentJsonTask;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.PendantInfo;
import com.tencent.mobileqq.vas.SonicTemplateUpdateManager;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.vas.VasExtensionManager;
import com.tencent.mobileqq.vas.VasMonitorHandler;
import com.tencent.mobileqq.vas.VasQuickUpdateEngine.QuickUpdateListener;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VipGrayConfigHelper;
import com.tencent.mobileqq.vip.AioVipKeywordHelper;
import com.tencent.mobileqq.vip.TMSManager;
import com.tencent.mobileqq.voicechange.VoiceChangeManager;
import com.tencent.mobileqq.webview.WebViewTitleStyleHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.comic.VipComicNavConfigHelper;
import cooperation.comic.VipComicSoHelper;
import java.io.File;

public class akpv
  extends VasQuickUpdateEngine.QuickUpdateListener
{
  public akpv(VasQuickUpdateManager paramVasQuickUpdateManager) {}
  
  public void onCompleted(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    if ((QLog.isColorLevel()) || (paramInt1 != 0)) {
      QLog.d("VasQuickUpdateManager", 2, "onCompleted bid = " + paramLong + " scid = " + paramString1 + " from = " + paramString3 + " errorCode = " + paramInt1 + " httpCode = " + paramInt2);
    }
    Object localObject;
    if (paramLong == 1000L) {
      if (paramString1.equals("keywordList_2.json"))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VasQuickUpdateManager", 2, "onCompleted emoji keyword errorCode = " + paramInt1);
        }
        if (paramInt1 == 0)
        {
          localObject = (EmoticonManager)this.a.a.getManager(13);
          if (localObject != null) {
            ((EmoticonManager)localObject).d();
          }
        }
      }
    }
    label287:
    label1590:
    label1870:
    label1893:
    label2286:
    for (;;)
    {
      this.a.a(paramLong, paramString1, paramString2, paramString3, paramInt1, paramInt2);
      boolean bool;
      int i;
      label1660:
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
                String str;
                do
                {
                  return;
                  if (paramString1.startsWith("signature.item."))
                  {
                    if (paramInt1 != 0) {
                      break;
                    }
                    VasUtils.a(this.a.a);
                    break;
                  }
                  if ("vipData_individuation_url.android.json".equals(paramString1))
                  {
                    if (QLog.isColorLevel())
                    {
                      localObject = new StringBuilder().append("onCompleted url_configurable ,errorCode = ").append(paramInt1).append(", app=");
                      if (this.a.a == null) {
                        break label287;
                      }
                    }
                    for (bool = true;; bool = false)
                    {
                      QLog.d("VasQuickUpdateManager", 2, bool);
                      if (paramInt1 != 0) {
                        break;
                      }
                      IndividuationUrlHelper.a(this.a.a);
                      break;
                    }
                  }
                  if ("changeVoice_json".equals(paramString1))
                  {
                    if (paramInt1 != 0) {
                      break;
                    }
                    ((VoiceChangeManager)this.a.a.getManager(175)).a(null, null);
                    break;
                  }
                  if ("blessVoiceList.json".equals(paramString1))
                  {
                    if (!QLog.isColorLevel()) {
                      break;
                    }
                    QLog.d("VasQuickUpdateManager", 2, "onCompleted blessVoiceChange ,errorCode = " + paramInt1);
                    break;
                  }
                  if ("vip_personal_card.json".equals(paramString1))
                  {
                    if (paramInt1 != 0) {
                      break;
                    }
                    VipGrayConfigHelper.a().a(this.a.a, true);
                    ClubContentJsonTask.b(this.a.a);
                    AioVipKeywordHelper.a().a(this.a.a);
                    break;
                  }
                  if ("monitorAppid".equals(paramString1))
                  {
                    if (paramInt1 != 0) {
                      break;
                    }
                    ((VasMonitorHandler)this.a.a.a(103)).a(this.a.a, true);
                    break;
                  }
                  if ("praise.config.json".equals(paramString1))
                  {
                    if (paramInt1 != 0) {
                      break;
                    }
                    PraiseConfigHelper.a(this.a.a);
                    break;
                  }
                  if ("xydata.qq.hifont.recommend.json".equals(paramString1))
                  {
                    if (paramInt1 != 0) {
                      break;
                    }
                    ((HiBoomManager)this.a.a.getManager(218)).a(false, true);
                    break;
                  }
                  if ("card.diyFontConfig.json".equals(paramString1))
                  {
                    if (paramInt1 != 0) {
                      break;
                    }
                    VipProfileDiyCardConfig.a(this.a.a);
                    break;
                  }
                  if ("vipData_app_webviewNavStyle.json".equals(paramString1))
                  {
                    if (paramInt1 != 0) {
                      break;
                    }
                    WebViewTitleStyleHelper.a().a(this.a.a);
                    break;
                  }
                  if ("VASBiz_FuncDev_webview.json".equals(paramString1))
                  {
                    if (paramInt1 != 0) {
                      break;
                    }
                    AuthorizeConfig.a().h();
                    AuthorizeConfig.a().e();
                    AuthorizeConfig.a().c();
                    break;
                  }
                  if ("watch_focus.json".equals(paramString1))
                  {
                    if (paramInt1 != 0) {
                      break;
                    }
                    localObject = (EmoticonHandler)this.a.a.a(12);
                    if (localObject == null) {
                      break;
                    }
                    ((EmoticonHandler)localObject).d();
                    break;
                  }
                  if ((!"groupeffect_config.json".equals(paramString1)) || (paramInt1 != 0)) {
                    break;
                  }
                  ((TroopEnterEffectManager)this.a.a.getManager(230)).a(false);
                  break;
                  if (paramLong == 5L)
                  {
                    if (paramString1.startsWith("font.diycard.android."))
                    {
                      if (paramInt1 != 0) {
                        break;
                      }
                      localObject = paramString1.substring("font.diycard.android.".length(), paramString1.length());
                      if (!TextUtils.isDigitsOnly((CharSequence)localObject)) {
                        break;
                      }
                      i = Integer.parseInt((String)localObject);
                      HiBoomFont.a().a(i, 2, HiBoomManager.b).a(false);
                      break;
                    }
                    if (paramString1.startsWith("font.hifontQQ.android."))
                    {
                      localObject = paramString1.substring("font.hifontQQ.android.".length(), paramString1.length());
                      if (!TextUtils.isDigitsOnly((CharSequence)localObject)) {
                        break;
                      }
                      i = Integer.parseInt((String)localObject);
                      if (paramInt1 == 0)
                      {
                        HiBoomFont.a().a(i, 1, HiBoomManager.a).a(false);
                        break;
                      }
                      HiBoomFont.a().a(i, 1, HiBoomManager.a).a();
                      break;
                    }
                    if (paramString1.startsWith("font.main.android."))
                    {
                      i = Integer.parseInt(paramString1.substring("font.main.android.".length(), paramString1.length()));
                      ((FontManager)this.a.a.getManager(41)).a(i, paramInt1, paramString3);
                      break;
                    }
                    if (paramString1.startsWith("font.fzfont.android."))
                    {
                      i = Integer.parseInt(paramString1.substring("font.fzfont.android.".length(), paramString1.length()));
                      ((FontManager)this.a.a.getManager(41)).a(i, paramInt1, paramString3);
                      break;
                    }
                    if (!paramString1.equals("magicFontConfig.json")) {
                      break;
                    }
                    ((FontManager)this.a.a.getManager(41)).a(new File(FontManager.g));
                    break;
                  }
                  if (paramLong != 3L) {
                    break label1660;
                  }
                  if (TextUtils.isEmpty(paramString1)) {
                    break label1590;
                  }
                  if (paramString1.indexOf("theme.android.") < 0) {
                    break label1434;
                  }
                  str = ThemeUtil.getIDFromSCID(paramString1);
                  bool = ThemeUtil.isNeedUpdataById(str);
                  if ((paramInt1 != 0) || (!bool) || (QLog.isColorLevel())) {
                    QLog.d("VasQuickUpdateManager", 2, "onCompleted theme update theme ok. bid = " + paramLong + ", themeid=" + str + ", cfgScid=" + paramString2 + ",scid = " + paramString1 + " from = " + paramString3 + " errorCode = " + paramInt1 + ", isUpdate=" + bool);
                  }
                } while (!bool);
                if (paramInt1 != 0) {
                  break;
                }
                File localFile = new File(ThemeUtil.getThemeDownloadFilePath(this.a.a.getApplication(), str, "20000000"));
                if ((localFile.exists()) && (localFile.isFile()))
                {
                  ThemeUtil.ThemeInfo localThemeInfo = ThemeUtil.getThemeInfo(this.a.a.getApplication(), str);
                  localObject = localThemeInfo;
                  if (localThemeInfo == null)
                  {
                    localObject = new ThemeUtil.ThemeInfo();
                    ((ThemeUtil.ThemeInfo)localObject).themeId = str;
                  }
                  if (((ThemeUtil.ThemeInfo)localObject).zipVer >= 20000000) {}
                  for (i = ((ThemeUtil.ThemeInfo)localObject).zipVer + 1;; i = 20000000)
                  {
                    ((ThemeUtil.ThemeInfo)localObject).zipVer = i;
                    ((ThemeUtil.ThemeInfo)localObject).status = "3";
                    long l = localFile.length();
                    ((ThemeUtil.ThemeInfo)localObject).downsize = l;
                    ((ThemeUtil.ThemeInfo)localObject).size = l;
                    ThemeUtil.setThemeInfo(this.a.a.getApplication(), (ThemeUtil.ThemeInfo)localObject);
                    ((ThemeSwitchManager)this.a.a.getManager(184)).a(paramLong, paramString1, paramString2, paramString3, paramInt1, paramInt2);
                    break;
                  }
                }
                QLog.e("VasQuickUpdateManager", 2, "onCompleted theme file not exist, bid = " + paramLong + ", cfgScid=" + paramString2 + ",scid = " + paramString1 + " from = " + paramString3 + " errorCode = " + paramInt1);
                break;
                if (paramString1.indexOf("theme.") >= 0)
                {
                  if (!QLog.isColorLevel()) {
                    break;
                  }
                  QLog.d("VasQuickUpdateManager", 2, "onCompleted theme update cfgScid ok. bid = " + paramLong + ", cfgScid=" + paramString2 + ",scid = " + paramString1 + " from = " + paramString3 + " errorCode = " + paramInt1);
                  break;
                }
                QLog.e("VasQuickUpdateManager", 2, "onCompleted theme bid = " + paramLong + ", cfgScid=" + paramString2 + ",scid = " + paramString1 + " from = " + paramString3 + " errorCode = " + paramInt1);
                break;
                QLog.e("VasQuickUpdateManager", 2, "onCompleted theme out bid = " + paramLong + ", cfgScid=" + paramString2 + ",scid = " + paramString1 + " from = " + paramString3 + " errorCode = " + paramInt1);
                break;
                if (paramLong == 2L)
                {
                  localObject = (BubbleManager)this.a.a.getManager(43);
                  if (paramString1.startsWith("bubble.android."))
                  {
                    ((BubbleManager)localObject).b(paramString1, paramString2, paramString3, paramInt1, paramInt2);
                    break;
                  }
                  if (!paramString1.startsWith("bubble.paster.")) {
                    break;
                  }
                  ((BubbleManager)localObject).a(paramString1, paramString2, paramString3, paramInt1, paramInt2);
                  break;
                }
                if (paramLong == 22L)
                {
                  localObject = ((VasExtensionManager)this.a.a.getManager(234)).jdField_a_of_type_ComTencentMobileqqFloatscrColorScreenManager;
                  if (!paramString1.startsWith("colorScreen.android.")) {
                    break;
                  }
                  ((ColorScreenManager)localObject).a(paramString1, paramInt1);
                  break;
                }
                if (paramLong == 23L)
                {
                  localObject = ((VasExtensionManager)this.a.a.getManager(234)).jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVasFaceManager;
                  if (!paramString1.startsWith("face.")) {
                    break;
                  }
                  ((VasFaceManager)localObject).a(paramString1, paramInt1);
                  break;
                }
                if (paramLong != 4L) {
                  break label2041;
                }
                if (!paramString1.startsWith("faceAddon.stickerFont.android.")) {
                  break label1870;
                }
              } while (paramInt1 != 0);
              DiyPendantFetcher.a().b(paramString1);
              return;
              if (!paramString1.startsWith("faceAddon.sticker.")) {
                break label1893;
              }
            } while (paramInt1 != 0);
            DiyPendantFetcher.a().a(paramString1);
            return;
          } while ((!paramString1.startsWith("pendant.")) || (paramString1.length() <= "pendant.".length()));
          paramString1 = paramString1.substring("pendant.".length(), paramString1.length());
          paramInt1 = paramString1.indexOf(".");
        } while (paramInt1 <= 0);
        paramLong = Long.parseLong(paramString1.substring(0, paramInt1));
        paramString2 = (AvatarPendantManager)this.a.a.getManager(45);
        if (paramString1.endsWith(".xydata.js"))
        {
          paramString2.a(paramLong).a(PendantInfo.g);
          return;
        }
        if (paramString1.endsWith(".aio_50.png"))
        {
          paramString2.a(paramLong).b(paramLong, 1);
          return;
        }
      } while (!paramString1.endsWith(".other.zip"));
      paramString2.a(paramLong).b(paramLong, 2);
      return;
      label2041:
      if (paramLong == 1001L)
      {
        if ((paramInt1 == 0) && ("sonicTemplateUpdate.json".equals(paramString1)))
        {
          localObject = (SonicTemplateUpdateManager)this.a.a.getManager(191);
          if (localObject != null) {
            ((SonicTemplateUpdateManager)localObject).a();
          }
        }
      }
      else if (paramLong == 20L)
      {
        ((PraiseManager)this.a.a.getManager(208)).a(paramString1, paramString2, paramString3, paramInt1, paramInt2);
      }
      else if (paramLong == 1003L)
      {
        if ((paramInt1 != 0) || (!"emotionRecommendEffect".equals(paramString1))) {}
      }
      else if (paramLong == 1004L)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder().append("onCompleted sticker material ,errorCode = ").append(paramInt1).append(", app=");
          if (this.a.a != null)
          {
            bool = true;
            QLog.d("VasQuickUpdateManager", 2, bool);
          }
        }
        else if (paramInt1 == 0)
        {
          if (!paramString1.equals("emojiStickerGuideZip_v2")) {
            break label2286;
          }
          EmojiStickerManager.a();
        }
        for (;;)
        {
          if (!paramString1.equals("libColorFont_760")) {
            break label2302;
          }
          ((FontManager)this.a.a.getManager(41)).a(4, paramInt1);
          break;
          bool = false;
          break label2212;
          if (paramString1.equals("libFlatBuffersParser")) {
            FlatBuffersParser.e();
          }
        }
        label2302:
        if (paramString1.equals("libVipFont_765")) {
          ((FontManager)this.a.a.getManager(41)).a(1, paramInt1);
        } else if (paramString1.startsWith("bqmall.android.h5magic.")) {
          ((VasExtensionManager)this.a.a.getManager(234)).jdField_a_of_type_ComTencentMobileqqEmoticonVasEmojiManager.a(paramString1, paramInt1);
        } else if (paramString1.equals("libqgplayer_765")) {
          VipComicSoHelper.a(this.a.a, paramInt1);
        } else if (paramString1.startsWith("libtmsdualcore")) {
          TMSManager.a(this.a.a.getApp(), paramInt1);
        } else if (paramString1.equals("libAPNG_765")) {
          VasApngUtil.a(paramInt1);
        }
      }
      else if (paramLong == 1002L)
      {
        if (paramInt1 == 0)
        {
          localObject = (FlashChatManager)this.a.a.getManager(216);
          if (localObject != null) {
            ((FlashChatManager)localObject).b(paramString1);
          }
        }
      }
      else if (paramLong == 15L)
      {
        if ("cardWZ.zip".equals(paramString1)) {
          VipWZRYTemplateHelper.a(this.a.a, paramString1, paramString3, paramInt1);
        } else if (paramString1.startsWith("card.")) {
          ((VasExtensionManager)this.a.a.getManager(234)).jdField_a_of_type_ComTencentMobileqqProfileProfileCardManager.a(this.a.a, paramString1, paramString3, paramInt1);
        }
      }
      else if (paramLong == 21L)
      {
        if ("poke.effectList".equals(paramString1))
        {
          localObject = (EarlyDownloadManager)this.a.a.getManager(76);
          if (localObject != null)
          {
            localObject = (PokeResHandler)((EarlyDownloadManager)localObject).a("qq.android.poke.res_1228");
            if (localObject != null) {
              ((PokeResHandler)localObject).a();
            }
          }
        }
      }
      else if (paramLong == 9L)
      {
        if ((!paramString1.startsWith("signature.sticker.")) || (paramInt1 != 0)) {}
      }
      else if (paramLong == 100L)
      {
        if (paramInt1 == 0) {
          if (paramString1.equals("vipComic_nav_config.json")) {
            VipComicNavConfigHelper.a();
          } else if (paramString1.equals("vipComic_nav_tabIcon.zip")) {
            VipComicNavConfigHelper.b();
          }
        }
      }
      else if ((paramLong == 25L) && (paramString1.startsWith("groupeffect_item_")) && (paramInt1 == 0))
      {
        i = TroopEnterEffectController.a(paramString1);
        if (QLog.isColorLevel()) {
          QLog.d("TroopEnterEffect", 2, "download Res onCompleted success id = " + i);
        }
        if (i > 0)
        {
          localObject = TroopEnterEffectController.a(i);
          try
          {
            if (new File((String)localObject).exists()) {
              FileUtils.a((String)localObject, TroopEnterEffectController.a, false);
            }
          }
          catch (Exception localException)
          {
            QLog.e("TroopEnterEffect", 1, "Res Download unCompress error: " + localException.getLocalizedMessage());
          }
        }
      }
    }
  }
  
  public void onProgress(long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3)
  {
    if (paramLong1 == 2L) {
      ((BubbleManager)this.a.a.getManager(43)).a(paramString1, paramString2, paramLong2, paramLong3);
    }
    if ((paramLong1 == 5L) && (paramString1.startsWith("font.main.android.")))
    {
      int i = Integer.parseInt(paramString1.substring("font.main.android.".length(), paramString1.length()));
      ((FontManager)this.a.a.getManager(41)).a(i, (float)paramLong2 / (float)paramLong3);
    }
    if ((paramLong1 == 1004L) && (paramString1.startsWith("bqmall.android.h5magic."))) {
      ((VasExtensionManager)this.a.a.getManager(234)).jdField_a_of_type_ComTencentMobileqqEmoticonVasEmojiManager.a(paramString1, paramLong2, paramLong3);
    }
    if ((paramLong1 == 15L) && (paramString1.startsWith("card."))) {
      ((VasExtensionManager)this.a.a.getManager(234)).jdField_a_of_type_ComTencentMobileqqProfileProfileCardManager.a(Integer.parseInt(paramString1.substring("card.".length(), paramString1.length())), (int)(100L * paramLong2 / paramLong3));
    }
    this.a.a(paramLong1, paramString1, paramString2, paramLong2, paramLong3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akpv
 * JD-Core Version:    0.7.0.1
 */