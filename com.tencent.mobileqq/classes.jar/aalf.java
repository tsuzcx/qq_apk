import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.content.res.Resources;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;

class aalf
  implements ShareActionSheet.OnItemClickListener
{
  private final aale jdField_a_of_type_Aale;
  
  public aalf(aakz paramaakz, aale paramaale)
  {
    this.jdField_a_of_type_Aale = paramaale;
  }
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    this.jdField_a_of_type_Aakz.b();
    if ((aakz.a(this.jdField_a_of_type_Aakz) == null) || (this.jdField_a_of_type_Aakz.a == null)) {}
    for (;;)
    {
      return;
      int i = paramActionSheetItem.action;
      if (this.jdField_a_of_type_Aale != null) {
        this.jdField_a_of_type_Aale.a(i);
      }
      switch (i)
      {
      }
      while ((i != 11) && (i != 40) && (aakz.a(this.jdField_a_of_type_Aakz) != null))
      {
        aakz.a(this.jdField_a_of_type_Aakz, aakz.a(this.jdField_a_of_type_Aakz).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed, i - 1, aakz.a(this.jdField_a_of_type_Aakz).jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
        return;
        aakz.a(this.jdField_a_of_type_Aakz);
        continue;
        aakz.b(this.jdField_a_of_type_Aakz);
        continue;
        aakz.a(this.jdField_a_of_type_Aakz, i);
        continue;
        aakz.c(this.jdField_a_of_type_Aakz);
        continue;
        aakz.d(this.jdField_a_of_type_Aakz);
        continue;
        aakz.e(this.jdField_a_of_type_Aakz);
        continue;
        if ((aakz.a(this.jdField_a_of_type_Aakz) != null) && (aakz.a(this.jdField_a_of_type_Aakz).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null))
        {
          aaxb.a(aakz.a(this.jdField_a_of_type_Aakz).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_share", "clk_shop", 0, 0, new String[0]);
          aaae.a(zzy.a(aakz.a(this.jdField_a_of_type_Aakz).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get()));
          continue;
          if ((aakz.a(this.jdField_a_of_type_Aakz) != null) && (aakz.a(this.jdField_a_of_type_Aakz).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null))
          {
            aaae.a(aakz.a(this.jdField_a_of_type_Aakz).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.yzOrderPage.get());
            aaxb.b(aakz.a(this.jdField_a_of_type_Aakz).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_share", "clk_shoplist", 0, 0, new String[0]);
            continue;
            if ((aakz.a(this.jdField_a_of_type_Aakz) != null) && (aakz.a(this.jdField_a_of_type_Aakz).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null))
            {
              aaae.a(QzoneConfig.getInstance().getConfig("qqsubscribe", "showFansGroupConfigEntranceUrl", "https://h5.qzone.qq.com/subscription/fansqun/{uin}?_proxy=1&_wv=3").replace("{uin}", aakz.a(this.jdField_a_of_type_Aakz).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get()));
              aaxb.a(aakz.a(this.jdField_a_of_type_Aakz).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_share", "clk_fan", 0, 0, new String[0]);
              continue;
              aakz.a(this.jdField_a_of_type_Aakz).a(aakz.a(this.jdField_a_of_type_Aakz));
              if ((aakz.a(this.jdField_a_of_type_Aakz) != null) && (aakz.a(this.jdField_a_of_type_Aakz).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null))
              {
                aaxb.a(aakz.a(this.jdField_a_of_type_Aakz).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_share", "clk_pic", 0, 0, new String[] { null, null, aakz.a(this.jdField_a_of_type_Aakz).f(), aakz.a(this.jdField_a_of_type_Aakz).c() });
                continue;
                aaae.a("https://h5.qzone.qq.com/subscription/syncFeeds/{uin}?_proxy=1&_wv=3".replace("{uin}", aakz.a(this.jdField_a_of_type_Aakz).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get()));
                aaxb.b(aakz.a(this.jdField_a_of_type_Aakz).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_share", "sync_qzone", 0, 0, new String[0]);
                continue;
                if (aakz.a(this.jdField_a_of_type_Aakz) != null) {
                  if (aakz.a(this.jdField_a_of_type_Aakz).b())
                  {
                    QLog.d("SubscribeShareHelper", 2, "mColorNoteController ：add colorNote");
                    aakz.a(this.jdField_a_of_type_Aakz).e();
                  }
                  else
                  {
                    aakz.a(this.jdField_a_of_type_Aakz).i();
                    continue;
                    if ((aakz.a(this.jdField_a_of_type_Aakz) != null) && (aakz.a(this.jdField_a_of_type_Aakz).c()))
                    {
                      QQToast.a(BaseApplicationImpl.getContext(), 2, BaseApplicationImpl.getContext().getResources().getString(2131690750), 5000).a();
                      aakz.a(this.jdField_a_of_type_Aakz).f();
                      QLog.d("SubscribeShareHelper", 2, "mColorNoteController ： delete colorNote");
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aalf
 * JD-Core Version:    0.7.0.1
 */