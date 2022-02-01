import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetRecommendUserListRsp;
import NS_COMM.COMM.StCommonExt;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.SubscribeGetRecommendUserListRequest;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class aafq
  implements aafo
{
  private static String jdField_a_of_type_JavaLangString = "TopPanelPresenter";
  private COMM.StCommonExt jdField_a_of_type_NS_COMMCOMM$StCommonExt;
  private aafp jdField_a_of_type_Aafp;
  
  public aafq(aafp paramaafp)
  {
    this.jdField_a_of_type_Aafp = paramaafp;
    this.jdField_a_of_type_Aafp.setPresenter(this);
  }
  
  private List<aagb> a(CertifiedAccountRead.StGetRecommendUserListRsp paramStGetRecommendUserListRsp)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramStGetRecommendUserListRsp.expType.get() == 0)
    {
      if (paramStGetRecommendUserListRsp.vecUser.has())
      {
        paramStGetRecommendUserListRsp = paramStGetRecommendUserListRsp.vecUser.get().iterator();
        while (paramStGetRecommendUserListRsp.hasNext()) {
          localArrayList.add(new aagb((CertifiedAccountMeta.StUser)paramStGetRecommendUserListRsp.next()));
        }
      }
    }
    else if ((paramStGetRecommendUserListRsp.expType.get() == 1) && (paramStGetRecommendUserListRsp.vecUserWithFeed.has()))
    {
      paramStGetRecommendUserListRsp = paramStGetRecommendUserListRsp.vecUserWithFeed.get().iterator();
      while (paramStGetRecommendUserListRsp.hasNext()) {
        localArrayList.add(new aagb((CertifiedAccountMeta.StFeed)paramStGetRecommendUserListRsp.next()));
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    long l = System.currentTimeMillis();
    localObject = new SubscribeGetRecommendUserListRequest((String)localObject, this.jdField_a_of_type_NS_COMMCOMM$StCommonExt, 100, 0);
    ((SubscribeGetRecommendUserListRequest)localObject).setEnableCache(false);
    VSNetworkHelper.a().a((VSBaseRequest)localObject, new aafr(this, l));
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Aafp != null)
    {
      this.jdField_a_of_type_Aafp.setPresenter(null);
      this.jdField_a_of_type_Aafp = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aafq
 * JD-Core Version:    0.7.0.1
 */