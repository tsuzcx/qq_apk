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

class aabg
  implements ShareActionSheet.OnItemClickListener
{
  private final aabf jdField_a_of_type_Aabf;
  
  public aabg(aaba paramaaba, aabf paramaabf)
  {
    this.jdField_a_of_type_Aabf = paramaabf;
  }
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    this.jdField_a_of_type_Aaba.b();
    if ((aaba.a(this.jdField_a_of_type_Aaba) == null) || (this.jdField_a_of_type_Aaba.a == null)) {}
    for (;;)
    {
      return;
      int i = paramActionSheetItem.action;
      if (this.jdField_a_of_type_Aabf != null) {
        this.jdField_a_of_type_Aabf.a(i);
      }
      switch (i)
      {
      }
      while ((i != 11) && (i != 40) && (aaba.a(this.jdField_a_of_type_Aaba) != null))
      {
        aaba.a(this.jdField_a_of_type_Aaba, aaba.a(this.jdField_a_of_type_Aaba).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed, i - 1, aaba.a(this.jdField_a_of_type_Aaba).jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
        return;
        aaba.a(this.jdField_a_of_type_Aaba);
        continue;
        aaba.b(this.jdField_a_of_type_Aaba);
        continue;
        aaba.a(this.jdField_a_of_type_Aaba, i);
        continue;
        aaba.c(this.jdField_a_of_type_Aaba);
        continue;
        aaba.d(this.jdField_a_of_type_Aaba);
        continue;
        aaba.e(this.jdField_a_of_type_Aaba);
        continue;
        if ((aaba.a(this.jdField_a_of_type_Aaba) != null) && (aaba.a(this.jdField_a_of_type_Aaba).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null))
        {
          aanb.a(aaba.a(this.jdField_a_of_type_Aaba).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_share", "clk_shop", 0, 0, new String[0]);
          zqm.a(zqg.a(aaba.a(this.jdField_a_of_type_Aaba).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get()));
          continue;
          if ((aaba.a(this.jdField_a_of_type_Aaba) != null) && (aaba.a(this.jdField_a_of_type_Aaba).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null))
          {
            zqm.a(aaba.a(this.jdField_a_of_type_Aaba).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.yzOrderPage.get());
            aanb.b(aaba.a(this.jdField_a_of_type_Aaba).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_share", "clk_shoplist", 0, 0, new String[0]);
            continue;
            if ((aaba.a(this.jdField_a_of_type_Aaba) != null) && (aaba.a(this.jdField_a_of_type_Aaba).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null))
            {
              zqm.a(QzoneConfig.getInstance().getConfig("qqsubscribe", "showFansGroupConfigEntranceUrl", "https://h5.qzone.qq.com/subscription/fansqun/{uin}?_proxy=1&_wv=3").replace("{uin}", aaba.a(this.jdField_a_of_type_Aaba).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get()));
              aanb.a(aaba.a(this.jdField_a_of_type_Aaba).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_share", "clk_fan", 0, 0, new String[0]);
              continue;
              aaba.a(this.jdField_a_of_type_Aaba).a(aaba.a(this.jdField_a_of_type_Aaba));
              if ((aaba.a(this.jdField_a_of_type_Aaba) != null) && (aaba.a(this.jdField_a_of_type_Aaba).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null))
              {
                aanb.a(aaba.a(this.jdField_a_of_type_Aaba).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_share", "clk_pic", 0, 0, new String[] { null, null, aaba.a(this.jdField_a_of_type_Aaba).f(), aaba.a(this.jdField_a_of_type_Aaba).c() });
                continue;
                zqm.a("https://h5.qzone.qq.com/subscription/syncFeeds/{uin}?_proxy=1&_wv=3".replace("{uin}", aaba.a(this.jdField_a_of_type_Aaba).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get()));
                aanb.b(aaba.a(this.jdField_a_of_type_Aaba).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_share", "sync_qzone", 0, 0, new String[0]);
                continue;
                if (aaba.a(this.jdField_a_of_type_Aaba) != null) {
                  if (aaba.a(this.jdField_a_of_type_Aaba).b())
                  {
                    QLog.d("SubscribeShareHelper", 2, "mColorNoteController ：add colorNote");
                    aaba.a(this.jdField_a_of_type_Aaba).e();
                  }
                  else
                  {
                    aaba.a(this.jdField_a_of_type_Aaba).i();
                    continue;
                    if ((aaba.a(this.jdField_a_of_type_Aaba) != null) && (aaba.a(this.jdField_a_of_type_Aaba).c()))
                    {
                      QQToast.a(BaseApplicationImpl.getContext(), 2, BaseApplicationImpl.getContext().getResources().getString(2131690875), 5000).a();
                      aaba.a(this.jdField_a_of_type_Aaba).f();
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
 * Qualified Name:     aabg
 * JD-Core Version:    0.7.0.1
 */