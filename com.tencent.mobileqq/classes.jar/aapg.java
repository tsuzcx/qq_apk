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

class aapg
  implements ShareActionSheet.OnItemClickListener
{
  private final aapf jdField_a_of_type_Aapf;
  
  public aapg(aapa paramaapa, aapf paramaapf)
  {
    this.jdField_a_of_type_Aapf = paramaapf;
  }
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    this.jdField_a_of_type_Aapa.b();
    if ((aapa.a(this.jdField_a_of_type_Aapa) == null) || (this.jdField_a_of_type_Aapa.a == null)) {}
    for (;;)
    {
      return;
      int i = paramActionSheetItem.action;
      if (this.jdField_a_of_type_Aapf != null) {
        this.jdField_a_of_type_Aapf.a(i);
      }
      switch (i)
      {
      }
      while ((i != 11) && (i != 40) && (aapa.a(this.jdField_a_of_type_Aapa) != null))
      {
        aapa.a(this.jdField_a_of_type_Aapa, aapa.a(this.jdField_a_of_type_Aapa).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed, i - 1, aapa.a(this.jdField_a_of_type_Aapa).jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
        return;
        aapa.a(this.jdField_a_of_type_Aapa);
        continue;
        aapa.b(this.jdField_a_of_type_Aapa);
        continue;
        aapa.a(this.jdField_a_of_type_Aapa, i);
        continue;
        aapa.c(this.jdField_a_of_type_Aapa);
        continue;
        aapa.d(this.jdField_a_of_type_Aapa);
        continue;
        aapa.e(this.jdField_a_of_type_Aapa);
        continue;
        if ((aapa.a(this.jdField_a_of_type_Aapa) != null) && (aapa.a(this.jdField_a_of_type_Aapa).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null))
        {
          abbe.a(aapa.a(this.jdField_a_of_type_Aapa).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_share", "clk_shop", 0, 0, new String[0]);
          aaej.a(aaed.a(aapa.a(this.jdField_a_of_type_Aapa).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get()));
          continue;
          if ((aapa.a(this.jdField_a_of_type_Aapa) != null) && (aapa.a(this.jdField_a_of_type_Aapa).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null))
          {
            aaej.a(aapa.a(this.jdField_a_of_type_Aapa).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.yzOrderPage.get());
            abbe.b(aapa.a(this.jdField_a_of_type_Aapa).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_share", "clk_shoplist", 0, 0, new String[0]);
            continue;
            if ((aapa.a(this.jdField_a_of_type_Aapa) != null) && (aapa.a(this.jdField_a_of_type_Aapa).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null))
            {
              aaej.a(QzoneConfig.getInstance().getConfig("qqsubscribe", "showFansGroupConfigEntranceUrl", "https://h5.qzone.qq.com/subscription/fansqun/{uin}?_proxy=1&_wv=3").replace("{uin}", aapa.a(this.jdField_a_of_type_Aapa).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get()));
              abbe.a(aapa.a(this.jdField_a_of_type_Aapa).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_share", "clk_fan", 0, 0, new String[0]);
              continue;
              aapa.a(this.jdField_a_of_type_Aapa).a(aapa.a(this.jdField_a_of_type_Aapa));
              if ((aapa.a(this.jdField_a_of_type_Aapa) != null) && (aapa.a(this.jdField_a_of_type_Aapa).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null))
              {
                abbe.a(aapa.a(this.jdField_a_of_type_Aapa).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_share", "clk_pic", 0, 0, new String[] { null, null, aapa.a(this.jdField_a_of_type_Aapa).f(), aapa.a(this.jdField_a_of_type_Aapa).c() });
                continue;
                aaej.a("https://h5.qzone.qq.com/subscription/syncFeeds/{uin}?_proxy=1&_wv=3".replace("{uin}", aapa.a(this.jdField_a_of_type_Aapa).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get()));
                abbe.b(aapa.a(this.jdField_a_of_type_Aapa).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_share", "sync_qzone", 0, 0, new String[0]);
                continue;
                if (aapa.a(this.jdField_a_of_type_Aapa) != null) {
                  if (aapa.a(this.jdField_a_of_type_Aapa).b())
                  {
                    QLog.d("SubscribeShareHelper", 2, "mColorNoteController ：add colorNote");
                    aapa.a(this.jdField_a_of_type_Aapa).e();
                  }
                  else
                  {
                    aapa.a(this.jdField_a_of_type_Aapa).i();
                    continue;
                    if ((aapa.a(this.jdField_a_of_type_Aapa) != null) && (aapa.a(this.jdField_a_of_type_Aapa).c()))
                    {
                      QQToast.a(BaseApplicationImpl.getContext(), 2, BaseApplicationImpl.getContext().getResources().getString(2131690750), 5000).a();
                      aapa.a(this.jdField_a_of_type_Aapa).f();
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
 * Qualified Name:     aapg
 * JD-Core Version:    0.7.0.1
 */