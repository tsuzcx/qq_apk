import android.content.Context;
import android.text.TextUtils;
import com.etrump.mixlayout.FontManager;
import com.tencent.biz.flatbuffers.FlatBuffersParser;
import com.tencent.mobileqq.activity.aio.item.PokeItemHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.IndividualRedPacketManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.avatar.dynamicavatar.VasFaceManager;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticon.VasEmojiManager;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.floatscr.ColorScreenManager;
import com.tencent.mobileqq.hiboom.HiBoomFont;
import com.tencent.mobileqq.profile.VipWZRYTemplateHelper;
import com.tencent.mobileqq.profile.diy.VipDiyCardConstants;
import com.tencent.mobileqq.profile.like.PraiseManager;
import com.tencent.mobileqq.theme.ThemeSwitchManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController;
import com.tencent.mobileqq.troop.utils.TroopGiftUtil;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.utils.VasUtils;
import com.tencent.mobileqq.vas.FlashCarGameManager;
import com.tencent.mobileqq.vas.VasExtensionManager;
import com.tencent.mobileqq.vas.VasQuickUpdateEngine;
import com.tencent.mobileqq.vas.VasQuickUpdateEngine.QuickUpdateBusinessCallback;
import com.tencent.mobileqq.vas.VasQuickUpdateEngine.TagItemInfo;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.comic.VipComicNavConfigHelper;
import cooperation.comic.VipComicSoHelper;
import java.io.File;
import mqq.app.MobileQQ;

public class ajty
  extends VasQuickUpdateEngine.QuickUpdateBusinessCallback
{
  public ajty(VasQuickUpdateManager paramVasQuickUpdateManager) {}
  
  public boolean canUpdate(long paramLong, String paramString1, String paramString2)
  {
    boolean bool2;
    if (paramLong == 5L)
    {
      if (!paramString1.startsWith("font.main.android.")) {
        break label227;
      }
      paramString1 = paramString1.substring("font.main.android.".length(), paramString1.length());
      if (TextUtils.isEmpty(paramString1))
      {
        if (QLog.isColorLevel()) {
          QLog.e("VasQuickUpdateManager", 2, "canUpdate error: font id is empty");
        }
        bool2 = false;
      }
    }
    boolean bool1;
    do
    {
      return bool2;
      int i = Integer.parseInt(paramString1);
      return !((FontManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(41)).a(i);
      if (paramLong != 3L) {
        break;
      }
      paramString2 = ThemeUtil.getIDFromSCID(paramString1);
      bool2 = ThemeUtil.isNeedUpdataById(paramString2);
      bool1 = bool2;
      if (bool2) {
        bool1 = ((ThemeSwitchManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(184)).a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2);
      }
      bool2 = bool1;
    } while (!QLog.isColorLevel());
    QLog.d("VasQuickUpdateManager", 2, "canUpdate: ifUpdate=" + bool1 + ", scid=" + paramString1 + ", themeid=" + paramString2 + ", engineId=" + null + ", usrId=" + null);
    return bool1;
    label227:
    return true;
  }
  
  public boolean deleteFiles(long paramLong, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasQuickUpdateManager", 2, "deleteFiles: bid = " + paramLong + " scid = " + paramString);
    }
    Object localObject;
    boolean bool2;
    boolean bool1;
    if ((paramLong == 1000L) || (paramLong == 1003L) || (paramLong == 21L) || (paramLong == 2L) || (paramLong == 16L) || (paramLong == 20L) || (paramLong == 4L) || (paramLong == 23L))
    {
      localObject = getItemInfo(paramLong, paramString);
      if (localObject == null) {
        break label1252;
      }
      bool2 = VasQuickUpdateEngine.safeDeleteFile(new File(((VasQuickUpdateEngine.TagItemInfo)localObject).strSavePath));
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("VasQuickUpdateManager", 2, "deleteFiles: bid=" + paramLong + " scid=" + paramString + ", result=" + bool2);
        bool1 = bool2;
      }
    }
    label1009:
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
                    String str;
                    do
                    {
                      return bool1;
                      if (paramLong != 3L) {
                        break;
                      }
                      localObject = ThemeUtil.getIDFromSCID(paramString);
                      if (!ThemeUtil.isNeedUpdataById((String)localObject)) {
                        break label1252;
                      }
                      str = ThemeUtil.getThemeDownloadFilePath(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), (String)localObject, "20000000");
                      bool2 = VasQuickUpdateEngine.safeDeleteFile(new File(str));
                      bool1 = bool2;
                    } while (!QLog.isColorLevel());
                    QLog.d("VasQuickUpdateManager", 2, "deleteFiles: scid=" + paramString + ", themeid=" + (String)localObject + ", zipPath=" + str);
                    return bool2;
                    if (paramLong == 1004L)
                    {
                      if (paramString.equals("libColorFont_760")) {
                        return VasQuickUpdateEngine.safeDeleteFile(new File(VasUtils.a() + "libfounderColorFont_760.so"));
                      }
                      if (paramString.equals("libFlatBuffersParser"))
                      {
                        FlatBuffersParser.g();
                        return true;
                      }
                      if (paramString.equals("libVipFont_735")) {
                        return VasQuickUpdateEngine.safeDeleteFile(new File(VasUtils.a() + "libvipfont.so"));
                      }
                      if (paramString.startsWith("bqmall.android.h5magic."))
                      {
                        VasEmojiManager.a(paramString);
                        return true;
                      }
                      if (!paramString.equals("libqgplayer_760")) {
                        break label1252;
                      }
                      return VasQuickUpdateEngine.safeDeleteFile(new File(VipComicSoHelper.a() + "libqgplayer-lib.so"));
                    }
                    if (paramLong != 5L) {
                      break label1009;
                    }
                    if (!paramString.startsWith("font.diycard.android.")) {
                      break;
                    }
                    paramString = paramString.substring("font.diycard.android.".length(), paramString.length());
                    paramString = VipDiyCardConstants.jdField_a_of_type_JavaLangString + paramString;
                    bool2 = VasQuickUpdateEngine.safeDeleteFile(new File(paramString));
                    bool1 = bool2;
                  } while (!QLog.isColorLevel());
                  QLog.d("VasQuickUpdateManager", 2, "deleteFiles: font diy card path = " + paramString + " result = " + bool2);
                  return bool2;
                  if (!paramString.startsWith("font.hifont.android.")) {
                    break;
                  }
                  paramString = paramString.substring("font.hifont.android.".length(), paramString.length());
                  paramString = HiBoomFont.jdField_a_of_type_JavaLangString + paramString;
                  bool2 = VasQuickUpdateEngine.safeDeleteFile(new File(paramString));
                  bool1 = bool2;
                } while (!QLog.isColorLevel());
                QLog.d("VasQuickUpdateManager", 2, "deleteFiles: font hiboom path = " + paramString + " result = " + bool2);
                return bool2;
                if (!paramString.startsWith("font.main.android.")) {
                  break;
                }
                paramString = paramString.substring("font.main.android.".length(), paramString.length());
                paramString = FontManager.jdField_a_of_type_JavaLangString + File.separatorChar + paramString + File.separatorChar + paramString + ".ttf";
                bool2 = VasQuickUpdateEngine.safeDeleteFile(new File(paramString));
                bool1 = bool2;
              } while (!QLog.isColorLevel());
              QLog.d("VasQuickUpdateManager", 2, "deleteFiles: font font path = " + paramString + " result = " + bool2);
              return bool2;
              if (!paramString.startsWith("font.fzfont.android.")) {
                break;
              }
              paramString = paramString.substring("font.fzfont.android.".length(), paramString.length());
              paramString = FontManager.b + paramString + File.separatorChar + paramString + ".ttf";
              bool2 = VasQuickUpdateEngine.safeDeleteFile(new File(paramString));
              bool1 = bool2;
            } while (!QLog.isColorLevel());
            QLog.d("VasQuickUpdateManager", 2, "deleteFiles: font font fz path = " + paramString + " result = " + bool2);
            return bool2;
            if (!paramString.equals("magicFontConfig.json")) {
              break label1252;
            }
            bool2 = VasQuickUpdateEngine.safeDeleteFile(new File(FontManager.g));
            bool1 = bool2;
          } while (!QLog.isColorLevel());
          QLog.d("VasQuickUpdateManager", 2, "deleteFiles: fontEffect json path = " + FontManager.g + " result = " + bool2);
          return bool2;
          if (paramLong != 9L) {
            break;
          }
          if (!paramString.startsWith("signature.sticker.")) {
            break label1252;
          }
          paramString = paramString.substring("signature.sticker.".length(), paramString.length());
          bool2 = VasQuickUpdateEngine.safeDeleteFile(new File(AppConstants.by + paramString));
          bool1 = bool2;
        } while (!QLog.isColorLevel());
        QLog.d("VasQuickUpdateManager", 2, "deleteFiles: signature sticker path = " + paramString + " result = " + bool2);
        return bool2;
        if (paramLong != 15L) {
          break;
        }
        paramString = VipWZRYTemplateHelper.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
        bool2 = VasQuickUpdateEngine.safeDeleteFile(new File(paramString));
        bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.d("VasQuickUpdateManager", 2, "deleteFiles: profile card path = " + paramString + " result = " + bool2);
      return bool2;
      if (paramLong == 22L)
      {
        localObject = ((VasExtensionManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(234)).jdField_a_of_type_ComTencentMobileqqFloatscrColorScreenManager;
        if (paramString.startsWith("colorScreen.android.")) {
          ((ColorScreenManager)localObject).a(paramString);
        }
      }
      do
      {
        QLog.e("VasQuickUpdateManager", 1, "deleteFiles error: bid = " + paramLong + " scid = " + paramString);
        return false;
        if (paramLong == 1999L)
        {
          paramString = VasQuickUpdateManager.jdField_a_of_type_JavaLangString + paramString;
          bool2 = VasQuickUpdateEngine.safeDeleteFile(new File(paramString));
          bool1 = bool2;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("VasQuickUpdateManager", 2, "deleteFiles: quickupdate test path = " + paramString + " result = " + bool2);
          return bool2;
        }
        if (paramLong == 1005L)
        {
          paramString = AppConstants.aJ + "/.apollo/game/2000/";
          bool2 = VasQuickUpdateEngine.safeDeleteFile(new File(paramString));
          bool1 = bool2;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("VasQuickUpdateManager", 2, "deleteFiles: FlashCar test path = " + paramString + " result = " + bool2);
          return bool2;
        }
      } while (paramLong != 25L);
      int i = TroopEnterEffectController.a(paramString);
      paramString = TroopEnterEffectController.jdField_a_of_type_JavaLangString + i;
      bool2 = VasQuickUpdateEngine.safeDeleteFile(new File(paramString));
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    label1252:
    QLog.d("VasQuickUpdateManager", 2, "deleteFiles: ENTER_EFFECT path = " + paramString + " result = " + bool2);
    return bool2;
  }
  
  public VasQuickUpdateEngine.TagItemInfo getItemInfo(long paramLong, String paramString)
  {
    VasQuickUpdateEngine.TagItemInfo localTagItemInfo = new VasQuickUpdateEngine.TagItemInfo();
    Object localObject1;
    Object localObject2;
    if ((paramLong == 1000L) || (paramLong == 1001L))
    {
      localTagItemInfo.bPreConfig = false;
      localTagItemInfo.bSaveInDir = false;
      String str = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getFilesDir() + File.separator;
      if (paramString.equals("pendant_market_json.android.v2"))
      {
        localObject1 = "pendant_market.json";
        localObject2 = str;
      }
      for (;;)
      {
        localTagItemInfo.strSavePath = ((String)localObject2 + (String)localObject1);
        return localTagItemInfo;
        localObject2 = str;
        localObject1 = paramString;
        if (paramString.startsWith("signature.item."))
        {
          localObject2 = str;
          localObject1 = paramString;
          if (paramString.endsWith(".json"))
          {
            paramString = paramString.substring("signature.item.".length(), paramString.length() - 5);
            if (QLog.isColorLevel()) {
              QLog.d("VasQuickUpdateManager", 2, "getItemInfo signature id = " + paramString);
            }
            localObject1 = "config.json";
            localObject2 = AppConstants.bx + File.separator + paramString + File.separator;
          }
        }
      }
    }
    if (paramLong == 1002L)
    {
      localObject1 = (FlashChatManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(216);
      localTagItemInfo.bPreConfig = false;
      localTagItemInfo.bSaveInDir = false;
      localTagItemInfo.strSavePath = ((FlashChatManager)localObject1).a(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("VasQuickUpdateManager", 2, "getItemInfo:  result.strSavePath = " + localTagItemInfo.strSavePath);
      }
      return localTagItemInfo;
    }
    if (paramLong == 5L)
    {
      if (paramString.startsWith("font.diycard.android."))
      {
        localTagItemInfo.bPreConfig = false;
        localTagItemInfo.bSaveInDir = true;
        localTagItemInfo.strSavePath = (VipDiyCardConstants.jdField_a_of_type_JavaLangString + paramString.substring("font.diycard.android.".length(), paramString.length()));
      }
      for (;;)
      {
        return localTagItemInfo;
        if (paramString.startsWith("font.hifont.android."))
        {
          localTagItemInfo.bPreConfig = false;
          localTagItemInfo.bSaveInDir = true;
          localTagItemInfo.strSavePath = (HiBoomFont.jdField_a_of_type_JavaLangString + paramString.substring("font.hifont.android.".length(), paramString.length()));
        }
        else if (paramString.startsWith("font.main.android."))
        {
          localTagItemInfo.bPreConfig = false;
          localTagItemInfo.bSaveInDir = true;
          localTagItemInfo.strSavePath = (FontManager.jdField_a_of_type_JavaLangString + File.separator + paramString.substring("font.main.android.".length(), paramString.length()));
        }
        else if (paramString.startsWith("font.fzfont.android."))
        {
          localTagItemInfo.bPreConfig = false;
          localTagItemInfo.bSaveInDir = true;
          localTagItemInfo.strSavePath = (FontManager.b + paramString.substring("font.fzfont.android.".length(), paramString.length()));
        }
        else if (paramString.equals("magicFontConfig.json"))
        {
          localTagItemInfo.bPreConfig = false;
          localTagItemInfo.bSaveInDir = false;
          localTagItemInfo.strSavePath = FontManager.g;
        }
      }
    }
    if (paramLong == 3L)
    {
      localObject1 = ThemeUtil.getIDFromSCID(paramString);
      if (ThemeUtil.isNeedUpdataById((String)localObject1))
      {
        localObject2 = ThemeUtil.getThemeDownloadFilePath(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), (String)localObject1, "20000000");
        localTagItemInfo.bPreConfig = true;
        localTagItemInfo.bSaveInDir = false;
        localTagItemInfo.strSavePath = ((String)localObject2);
        if (QLog.isColorLevel()) {
          QLog.d("VasQuickUpdateManager", 2, "getItemInfo: scid=" + paramString + ", themeid=" + (String)localObject1 + ", zipPath=" + (String)localObject2);
        }
        return localTagItemInfo;
      }
    }
    else
    {
      int i;
      if (paramLong == 22L)
      {
        localObject1 = ((VasExtensionManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(234)).jdField_a_of_type_ComTencentMobileqqFloatscrColorScreenManager;
        if (paramString.startsWith("colorScreen.android."))
        {
          i = ((ColorScreenManager)localObject1).a(paramString);
          if (i > 0)
          {
            localTagItemInfo.bPreConfig = false;
            localTagItemInfo.bSaveInDir = false;
            localTagItemInfo.strSavePath = (((ColorScreenManager)localObject1).a(i).getAbsolutePath() + File.separator + "config.zip");
            return localTagItemInfo;
          }
        }
      }
      else if (paramLong == 23L)
      {
        if (paramString.startsWith("face."))
        {
          paramString = VasFaceManager.a(paramString);
          if (paramString != null)
          {
            localTagItemInfo.bPreConfig = false;
            localTagItemInfo.bSaveInDir = false;
            localTagItemInfo.strSavePath = paramString;
            return localTagItemInfo;
          }
        }
      }
      else if (paramLong == 2L)
      {
        localObject1 = (BubbleManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(43);
        if (paramString.startsWith("bubble.android."))
        {
          i = ((BubbleManager)localObject1).a(paramString);
          if (i > 0)
          {
            localTagItemInfo.bPreConfig = false;
            if (paramString.endsWith("static.zip"))
            {
              localTagItemInfo.bSaveInDir = true;
              localTagItemInfo.strSavePath = (((BubbleManager)localObject1).a(i).getAbsolutePath() + File.separator + "static");
            }
            for (;;)
            {
              return localTagItemInfo;
              if (paramString.endsWith("other.zip"))
              {
                localTagItemInfo.bSaveInDir = true;
                localTagItemInfo.strSavePath = ((BubbleManager)localObject1).a(i).getAbsolutePath();
              }
              else if (paramString.endsWith("config.json"))
              {
                localTagItemInfo.bSaveInDir = false;
                localTagItemInfo.strSavePath = (((BubbleManager)localObject1).a(i).getAbsolutePath() + File.separator + "config.json");
              }
            }
          }
        }
        else if (paramString.startsWith("bubble.paster."))
        {
          localTagItemInfo.bSaveInDir = false;
          if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("bubble.paster.")))
          {
            paramString = paramString.replace("bubble.paster.", "");
            localTagItemInfo.strSavePath = (((BubbleManager)localObject1).b().getAbsolutePath() + File.separator + paramString);
            if (QLog.isColorLevel()) {
              QLog.i("VasQuickUpdateManager", 2, "download paster fileName: " + localTagItemInfo.strSavePath);
            }
          }
          localTagItemInfo.bPreConfig = false;
          return localTagItemInfo;
        }
      }
      else if (paramLong == 4L)
      {
        if (paramString.startsWith("faceAddon.stickerFont.android."))
        {
          localTagItemInfo.bPreConfig = false;
          localTagItemInfo.bSaveInDir = true;
          localTagItemInfo.strSavePath = AvatarPendantUtil.b(paramString.replace("faceAddon.stickerFont.android.", ""));
          return localTagItemInfo;
        }
        if (paramString.startsWith("faceAddon.sticker."))
        {
          localTagItemInfo.bPreConfig = false;
          localTagItemInfo.bSaveInDir = false;
          localTagItemInfo.strSavePath = (AppConstants.bv + "sticker_info/" + paramString.replace("faceAddon.sticker.", ""));
          return localTagItemInfo;
        }
        if ((paramString.startsWith("pendant.")) && (paramString.length() > "pendant.".length()))
        {
          paramString = paramString.substring("pendant.".length(), paramString.length());
          i = paramString.indexOf(".");
          if (i > 0)
          {
            localObject1 = paramString.substring(0, i);
            paramString.substring(i, paramString.length());
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(AppConstants.bv).append((String)localObject1).append(File.separator);
            localTagItemInfo.bPreConfig = false;
            localTagItemInfo.bSaveInDir = true;
            if (paramString.endsWith(".xydata.js"))
            {
              localTagItemInfo.bSaveInDir = false;
              ((StringBuilder)localObject2).append("config.json");
            }
            if (paramString.endsWith(".aio_50.png"))
            {
              localTagItemInfo.bSaveInDir = false;
              ((StringBuilder)localObject2).append("aio_50.png");
            }
            localTagItemInfo.strSavePath = ((StringBuilder)localObject2).toString();
            return localTagItemInfo;
          }
        }
      }
      else if (paramLong == 20L)
      {
        localObject1 = (PraiseManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(208);
        if ((localObject1 != null) && (paramString.startsWith("praise.android.")))
        {
          i = ((PraiseManager)localObject1).a(paramString);
          if (i > 0)
          {
            localTagItemInfo.bPreConfig = false;
            localTagItemInfo.bSaveInDir = true;
            localTagItemInfo.strSavePath = ((PraiseManager)localObject1).a(i).getAbsolutePath();
            return localTagItemInfo;
          }
        }
      }
      else
      {
        if (paramLong == 1003L)
        {
          localTagItemInfo.bPreConfig = false;
          localTagItemInfo.bSaveInDir = false;
          localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getFilesDir() + File.separator;
          localTagItemInfo.strSavePath = ((String)localObject1 + paramString);
          return localTagItemInfo;
        }
        if (paramLong == 16L)
        {
          localTagItemInfo.bPreConfig = false;
          if (("iRedPacket_v3.json".equals(paramString)) || ("iRedPacket_v3.char300.json".equals(paramString)))
          {
            localTagItemInfo.bSaveInDir = false;
            localTagItemInfo.strSavePath = (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext().getFilesDir() + File.separator + "pddata/vas/redpacket/" + paramString);
          }
          if ("iRedPacket_v3.font.zip".equals(paramString))
          {
            localTagItemInfo.bSaveInDir = true;
            localTagItemInfo.strSavePath = IndividualRedPacketManager.a(3);
          }
          for (;;)
          {
            return localTagItemInfo;
            if ("iRedPacket_v3.specialChar.zip".equals(paramString))
            {
              localTagItemInfo.bSaveInDir = true;
              localTagItemInfo.strSavePath = IndividualRedPacketManager.a(2);
            }
            else if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("luckyMoney.item.")))
            {
              localTagItemInfo.bSaveInDir = true;
              localObject1 = IndividualRedPacketManager.a(paramString);
              if (TextUtils.isEmpty((CharSequence)localObject1)) {
                QLog.d("VasQuickUpdateManager", 2, "getItemInfo bid = " + paramLong + " scid = " + paramString + " pid = " + (String)localObject1);
              }
              localTagItemInfo.strSavePath = (IndividualRedPacketManager.a(1) + (String)localObject1);
            }
          }
        }
        if (paramLong == 1004L)
        {
          localTagItemInfo.bPreConfig = false;
          localTagItemInfo.bSaveInDir = false;
          if (paramString.equals("emojiStickerGuideZip_v2")) {
            localTagItemInfo.strSavePath = (EmojiStickerManager.a() + "emojiStickerGuideZip_v2.zip");
          }
          for (;;)
          {
            return localTagItemInfo;
            if (paramString.equals("libFlatBuffersParser")) {
              localTagItemInfo.strSavePath = (FlatBuffersParser.a() + "libFlatBuffersParser.zip");
            } else if (paramString.equals("libColorFont_760")) {
              localTagItemInfo.strSavePath = (FontManager.jdField_a_of_type_JavaLangString + File.separator + "libColorFont.zip");
            } else if (paramString.equals("libVipFont_735")) {
              localTagItemInfo.strSavePath = (FontManager.jdField_a_of_type_JavaLangString + File.separator + "libVipFont.zip");
            } else if (paramString.startsWith("bqmall.android.h5magic.")) {
              localTagItemInfo.strSavePath = VasEmojiManager.b(paramString);
            } else if (paramString.equals("libqgplayer_760")) {
              localTagItemInfo.strSavePath = (VipComicSoHelper.a() + "libQGamePlayer.zip");
            }
          }
        }
        if (paramLong == 15L)
        {
          if ("cardWZ.zip".equals(paramString))
          {
            localTagItemInfo.bPreConfig = false;
            localTagItemInfo.bSaveInDir = true;
            localTagItemInfo.strSavePath = VipWZRYTemplateHelper.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
            return localTagItemInfo;
          }
        }
        else
        {
          if (paramLong == 21L)
          {
            localTagItemInfo.bPreConfig = false;
            localTagItemInfo.bSaveInDir = true;
            if (paramString.startsWith("poke.item.effect.")) {
              localTagItemInfo.strSavePath = (PokeItemHelper.e + paramString.substring("poke.item.effect.".length(), paramString.length()));
            }
            for (;;)
            {
              return localTagItemInfo;
              if (paramString.startsWith("poke.item.res."))
              {
                localTagItemInfo.strSavePath = (PokeItemHelper.e + paramString.substring("poke.item.res.".length(), paramString.length()));
              }
              else if ("poke.effectList".equals(paramString))
              {
                localTagItemInfo.bSaveInDir = false;
                localTagItemInfo.strSavePath = PokeItemHelper.f;
              }
            }
          }
          if (paramLong == 9L)
          {
            if (paramString.startsWith("signature.sticker."))
            {
              localTagItemInfo.bPreConfig = false;
              localTagItemInfo.bSaveInDir = false;
              localTagItemInfo.strSavePath = (AppConstants.by + paramString.substring("signature.sticker.".length(), paramString.length()));
              return localTagItemInfo;
            }
          }
          else
          {
            if (paramLong == 1999L)
            {
              localTagItemInfo.bPreConfig = false;
              if (paramString.endsWith("cfg")) {
                localTagItemInfo.bPreConfig = true;
              }
              localTagItemInfo.bSaveInDir = false;
              localTagItemInfo.strSavePath = (VasQuickUpdateManager.jdField_a_of_type_JavaLangString + paramString);
              return localTagItemInfo;
            }
            if (paramLong == 1005L)
            {
              localTagItemInfo.bPreConfig = false;
              localTagItemInfo.bSaveInDir = true;
              localTagItemInfo.strSavePath = FlashCarGameManager.jdField_a_of_type_JavaLangString;
              return localTagItemInfo;
            }
            if (paramLong == 100L)
            {
              localTagItemInfo.bPreConfig = false;
              if (paramString.equals("vipComic_nav_config.json"))
              {
                localTagItemInfo.bSaveInDir = false;
                localTagItemInfo.strSavePath = VipComicNavConfigHelper.b().getAbsolutePath();
              }
              for (;;)
              {
                return localTagItemInfo;
                if (paramString.equals("vipComic_nav_tabIcon.zip"))
                {
                  localTagItemInfo.bSaveInDir = true;
                  localTagItemInfo.strSavePath = VipComicNavConfigHelper.c().getAbsolutePath();
                }
              }
            }
            if (paramLong == 25L)
            {
              localTagItemInfo.bPreConfig = false;
              if (paramString.startsWith("groupeffect_item_"))
              {
                localTagItemInfo.bSaveInDir = false;
                i = TroopEnterEffectController.a(paramString);
                localTagItemInfo.strSavePath = (TroopEnterEffectController.jdField_a_of_type_JavaLangString + i + File.separator + i + ".zip");
                return localTagItemInfo;
              }
            }
          }
        }
      }
    }
    return null;
  }
  
  public boolean isFileExists(long paramLong, String paramString)
  {
    boolean bool3 = true;
    boolean bool4 = true;
    boolean bool5 = true;
    boolean bool1 = true;
    String str = null;
    Object localObject1 = null;
    Object localObject3 = null;
    Object localObject2 = null;
    boolean bool2 = false;
    if (paramLong == 1000L) {
      bool1 = new File(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getFilesDir(), paramString).exists();
    }
    int i;
    label246:
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
                          return bool1;
                          if (paramLong != 5L) {
                            break;
                          }
                          if (paramString.startsWith("font.diycard.android."))
                          {
                            paramString = paramString.substring("font.diycard.android.".length(), paramString.length());
                            str = VipDiyCardConstants.jdField_a_of_type_JavaLangString + paramString;
                            localObject1 = new File(str);
                            paramString = (String)localObject2;
                            if (((File)localObject1).exists()) {
                              paramString = ((File)localObject1).list();
                            }
                            if (QLog.isColorLevel())
                            {
                              localObject2 = new StringBuilder().append("isFileExists hiboomfont path = ").append(str).append(" exist = ").append(((File)localObject1).exists()).append(" file count = ");
                              if (paramString == null) {
                                break label246;
                              }
                            }
                            for (i = paramString.length;; i = 0)
                            {
                              QLog.d("VasQuickUpdateManager", 2, i);
                              bool1 = bool2;
                              if (!((File)localObject1).exists()) {
                                break;
                              }
                              bool1 = bool2;
                              if (paramString == null) {
                                break;
                              }
                              bool1 = bool2;
                              if (paramString.length <= 0) {
                                break;
                              }
                              return true;
                            }
                          }
                          if (paramString.startsWith("font.hifont.android."))
                          {
                            paramString = paramString.substring("font.hifont.android.".length(), paramString.length());
                            localObject2 = HiBoomFont.jdField_a_of_type_JavaLangString + paramString;
                            localObject1 = new File((String)localObject2);
                            paramString = str;
                            if (((File)localObject1).exists()) {
                              paramString = ((File)localObject1).list();
                            }
                            if (QLog.isColorLevel())
                            {
                              localObject2 = new StringBuilder().append("isFileExists hiboomfont path = ").append((String)localObject2).append(" exist = ").append(((File)localObject1).exists()).append(" file count = ");
                              if (paramString != null)
                              {
                                i = paramString.length;
                                QLog.d("VasQuickUpdateManager", 2, i);
                              }
                            }
                            else
                            {
                              if ((!((File)localObject1).exists()) || (paramString == null) || (paramString.length <= 0)) {
                                break label421;
                              }
                            }
                            for (;;)
                            {
                              return bool1;
                              i = 0;
                              break;
                              bool1 = false;
                            }
                          }
                          if (paramString.startsWith("font.main.android."))
                          {
                            paramString = paramString.substring("font.main.android.".length(), paramString.length());
                            paramString = FontManager.jdField_a_of_type_JavaLangString + File.separatorChar + paramString + File.separatorChar + paramString + ".ttf";
                            localObject1 = new File(paramString);
                            if (QLog.isColorLevel()) {
                              QLog.d("VasQuickUpdateManager", 2, "isFileExists font path = " + paramString + " result = " + ((File)localObject1).exists());
                            }
                            return ((File)localObject1).exists();
                          }
                          if (paramString.startsWith("font.fzfont.android."))
                          {
                            paramString = paramString.substring("font.fzfont.android.".length(), paramString.length());
                            paramString = FontManager.b + paramString + File.separatorChar + paramString + ".ttf";
                            localObject1 = new File(paramString);
                            if (QLog.isColorLevel()) {
                              QLog.d("VasQuickUpdateManager", 2, "isFileExists font path = " + paramString + " result = " + ((File)localObject1).exists());
                            }
                            return ((File)localObject1).exists();
                          }
                          bool1 = bool2;
                        } while (!paramString.equals("magicFontConfig.json"));
                        paramString = new File(FontManager.g);
                        if (QLog.isColorLevel()) {
                          QLog.d("VasQuickUpdateManager", 2, "isFileExists fontEffectJson path = " + FontManager.g + " result = " + paramString.exists());
                        }
                        return paramString.exists();
                        bool1 = bool2;
                      } while (paramLong == 3L);
                      if (paramLong != 2L) {
                        break;
                      }
                      localObject1 = (BubbleManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(43);
                      bool1 = bool2;
                    } while (localObject1 == null);
                    if (paramString.startsWith("bubble.android.")) {
                      return ((BubbleManager)localObject1).b(paramString);
                    }
                    bool1 = bool2;
                  } while (!paramString.startsWith("bubble.paster."));
                  return ((BubbleManager)localObject1).a(paramString);
                  if (paramLong != 22L) {
                    break;
                  }
                  localObject1 = ((VasExtensionManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(234)).jdField_a_of_type_ComTencentMobileqqFloatscrColorScreenManager;
                  bool1 = bool2;
                } while (!paramString.startsWith("colorScreen.android."));
                return ((ColorScreenManager)localObject1).a(paramString);
                if (paramLong != 23L) {
                  break;
                }
                localObject1 = ((VasExtensionManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(234)).jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVasFaceManager;
                bool1 = bool2;
              } while (!paramString.startsWith("face."));
              return ((VasFaceManager)localObject1).a(paramString);
              if (paramLong != 4L) {
                break;
              }
              if (paramString.startsWith("faceAddon.stickerFont.android.")) {
                return AvatarPendantUtil.a(paramString.replace("faceAddon.stickerFont.android.", ""));
              }
              if (paramString.startsWith("faceAddon.sticker.")) {
                return AvatarPendantUtil.b(paramString);
              }
              bool1 = bool2;
            } while (!paramString.startsWith("pendant."));
            bool1 = bool2;
          } while (paramString.length() <= "pendant.".length());
          paramString = paramString.substring("pendant.".length(), paramString.length());
          i = paramString.indexOf(".");
          bool1 = bool2;
        } while (i <= 0);
        localObject2 = paramString.substring(0, i);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(AppConstants.bv).append((String)localObject2).append(File.separator);
        if (!paramString.endsWith(".xydata.js")) {
          break;
        }
        ((StringBuilder)localObject1).append("config.json");
        localObject2 = new File(((StringBuilder)localObject1).toString());
        if (!((File)localObject2).exists()) {
          break label1318;
        }
        if (!((File)localObject2).isDirectory()) {
          break label1270;
        }
        bool1 = bool2;
      } while (((File)localObject2).listFiles() == null);
      i = ((File)localObject2).listFiles().length;
      if (QLog.isColorLevel()) {
        QLog.d("VasQuickUpdateManager", 2, "isFileExists scid = " + paramString + " listFile length = " + i + " filepath = " + ((StringBuilder)localObject1).toString());
      }
      if (i > 0) {}
      for (bool1 = bool3;; bool1 = false)
      {
        return bool1;
        if (paramString.endsWith(".aio_50.png"))
        {
          ((StringBuilder)localObject1).append("aio_50.png");
          break;
        }
        if (!paramString.endsWith(".other.zip")) {
          break;
        }
        ((StringBuilder)localObject1).append("aio_file");
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VasQuickUpdateManager", 2, "isFileExists scid = " + paramString + " exists filepath = " + ((StringBuilder)localObject1).toString());
      }
      return true;
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    label421:
    label1270:
    QLog.d("VasQuickUpdateManager", 2, "isFileExists scid = " + paramString + " not exists filepath = " + ((StringBuilder)localObject1).toString());
    label1318:
    return false;
    if (paramLong == 20L) {
      return ((PraiseManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(208)).a(paramString);
    }
    if (paramLong == 1003L) {
      return new File(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getFilesDir(), paramString).exists();
    }
    if (paramLong == 16L) {
      if (("iRedPacket_v3.json".equals(paramString)) || ("iRedPacket_v3.char300.json".equals(paramString))) {
        paramString = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext().getFilesDir() + File.separator + "pddata/vas/redpacket/" + paramString;
      }
    }
    for (;;)
    {
      for (;;)
      {
        for (;;)
        {
          if (TextUtils.isEmpty(paramString))
          {
            paramString = (String)localObject1;
            label1516:
            if ((paramString == null) || (!paramString.exists())) {
              break label1726;
            }
          }
          label1708:
          label1726:
          for (bool1 = bool4;; bool1 = false)
          {
            return bool1;
            if ("iRedPacket_v3.font.zip".equals(paramString))
            {
              paramString = IndividualRedPacketManager.a(null, null, 8, 0, 0);
              break;
            }
            if ("iRedPacket_v3.specialChar.zip".equals(paramString))
            {
              paramString = IndividualRedPacketManager.a(null, null, 25, 0, 0);
              break;
            }
            if ((TextUtils.isEmpty(paramString)) || (!paramString.startsWith("luckyMoney.item."))) {
              break label2391;
            }
            paramString = IndividualRedPacketManager.a(paramString);
            if (TextUtils.isEmpty(paramString)) {
              break label2391;
            }
            paramString = IndividualRedPacketManager.a(paramString, null, 24, 0, 0);
            if (TextUtils.isEmpty(paramString))
            {
              paramString = localObject3;
              if ((paramString == null) || (!paramString.exists()) || (!paramString.isDirectory()) || (paramString.list().length <= 1)) {
                break label1708;
              }
            }
            for (bool1 = bool5;; bool1 = false)
            {
              if (QLog.isColorLevel()) {
                QLog.d("VasQuickUpdateManager", 2, "isFileExists SCID_REDPACKET_PACKETS_ZIP result = " + bool1);
              }
              return bool1;
              paramString = new File(paramString);
              break;
            }
            paramString = new File(paramString);
            break label1516;
          }
          if (paramLong == 15L) {
            return VipWZRYTemplateHelper.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), paramString);
          }
          if (paramLong != 21L) {
            break label1941;
          }
          if (paramString.startsWith("poke.item.effect."))
          {
            paramString = paramString.substring("poke.item.effect.".length(), paramString.length());
            try
            {
              i = Integer.valueOf(paramString).intValue();
              bool1 = bool2;
              if (i == -1) {
                break;
              }
              return PokeItemHelper.a("effect.gif", i);
            }
            catch (Exception paramString)
            {
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("VasQuickUpdateManager", 2, "id error");
                }
                i = -1;
              }
            }
          }
        }
        if (paramString.startsWith("poke.item.res."))
        {
          paramString = paramString.substring("poke.item.res.".length(), paramString.length());
          try
          {
            i = Integer.valueOf(paramString).intValue();
            bool1 = bool2;
            if (i == -1) {
              break;
            }
            return PokeItemHelper.a("bubble", i);
          }
          catch (Exception paramString)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("VasQuickUpdateManager", 2, "id error");
              }
              i = -1;
            }
          }
        }
      }
      bool1 = bool2;
      if (!"poke.effectList".equals(paramString)) {
        break;
      }
      return new File(PokeItemHelper.f).exists();
      label1941:
      if (paramLong == 1004L)
      {
        if (paramString.startsWith("libColorFont_760")) {
          return new File(VasUtils.a() + "libfounderColorFont_760.so").exists();
        }
        if (paramString.startsWith("libFlatBuffersParser")) {
          return new File(FlatBuffersParser.a() + "libFlatBuffersParser.zip").exists();
        }
        if (paramString.equals("emojiStickerGuideZip_v2")) {
          return new File(EmojiStickerManager.a() + "emojiStickerGuideZip_v2.zip").exists();
        }
        if (paramString.startsWith("libVipFont_735")) {
          return new File(VasUtils.a() + "libvipfont.so").exists();
        }
        if (paramString.startsWith("bqmall.android.h5magic.")) {
          return new File(VasEmojiManager.b(paramString)).exists();
        }
        bool1 = bool2;
        if (!paramString.equals("libqgplayer_760")) {
          break;
        }
        return new File(VipComicSoHelper.a() + "libqgplayer-lib.so").exists();
      }
      if (paramLong == 9L)
      {
        bool1 = bool2;
        if (!paramString.startsWith("signature.sticker.")) {
          break;
        }
        paramString = paramString.substring("signature.sticker.".length(), paramString.length());
        return new File(AppConstants.by + paramString).exists();
      }
      if (paramLong == 1999L) {
        return new File(VasQuickUpdateManager.jdField_a_of_type_JavaLangString + paramString).exists();
      }
      if (paramLong == 100L)
      {
        if (paramString.equals("vipComic_nav_config.json")) {
          return VipComicNavConfigHelper.a();
        }
        bool1 = bool2;
        if (!paramString.equals("vipComic_nav_tabIcon.zip")) {
          break;
        }
        return VipComicNavConfigHelper.b();
      }
      bool1 = bool2;
      if (paramLong != 25L) {
        break;
      }
      i = TroopEnterEffectController.a(paramString);
      bool1 = bool2;
      if (i <= 0) {
        break;
      }
      return TroopGiftUtil.a(new File(TroopEnterEffectController.jdField_a_of_type_JavaLangString + i));
      label2391:
      paramString = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajty
 * JD-Core Version:    0.7.0.1
 */