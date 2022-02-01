import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.richframework.part.list.base.BaseListBlock.1;
import com.tencent.biz.richframework.part.list.base.PublicListInnerFragment;
import com.tencent.biz.subscribe.widget.StatusView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public abstract class aacr<E, T>
  extends aabp<E>
{
  private List<E> mAllListData;
  protected Serializable mInitBean;
  protected boolean mIsFinish;
  protected String mLastAttachInfo;
  
  public aacr(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  private VSBaseRequest getRequestWithLoadInfo(aabu paramaabu)
  {
    if (paramaabu.c())
    {
      paramaabu = getRequest(null);
      if (paramaabu != null)
      {
        paramaabu.setEnableCache(true);
        return paramaabu;
      }
    }
    else
    {
      if (paramaabu.d()) {
        return getRequest(null);
      }
      if (paramaabu.e()) {
        return getRequest(this.mLastAttachInfo);
      }
    }
    return null;
  }
  
  private void handleLoadMoreData()
  {
    int i;
    if ((this.mAllListData != null) && (this.mAllListData.size() > 0))
    {
      i = this.mAllListData.size() - getDataList().size();
      if (i > 0) {}
    }
    else
    {
      return;
    }
    if (i > getPageCount()) {
      i = getPageCount();
    }
    for (this.mIsFinish = false;; this.mIsFinish = true)
    {
      QLog.d(getLogTag(), 1, String.format(Locale.getDefault(), "MSG_LOAD_NEXT_PAGE totalCount: %s, loadCount: %s", new Object[] { Integer.valueOf(this.mAllListData.size()), Integer.valueOf(i) }));
      handleListData(this.mAllListData.subList(getDataList().size(), i + getDataList().size()), true, this.mIsFinish);
      return;
    }
  }
  
  private void handleRefreshData(List<E> paramList)
  {
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    this.mAllListData = ((List)localObject);
    int j = ((List)localObject).size();
    int i;
    if (j <= getPageCount())
    {
      i = j;
      if ((getDataList().size() <= i) || (getDataList().size() > j)) {
        break label164;
      }
      i = getDataList().size();
    }
    label164:
    for (;;)
    {
      if (i == j) {}
      for (boolean bool = true;; bool = false)
      {
        this.mIsFinish = bool;
        QLog.d(getLogTag(), 1, String.format(Locale.getDefault(), "MSG_REFRESH_LIST_GLOBAL totalCount: %s, loadCount: %s, curItemCount: %s", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(getDataList().size()) }));
        handleListData(((List)localObject).subList(0, i), false, this.mIsFinish);
        return;
        i = getPageCount();
        break;
      }
    }
  }
  
  private void showListView()
  {
    if ((getHostFragment() != null) && (getHostFragment().a() != null))
    {
      getHostFragment().a().a().setVisibility(8);
      getHostFragment().a().a().setVisibility(0);
    }
  }
  
  public abstract String getAttachInfoFromItemData(E paramE);
  
  public abstract String getAttachInfoFromRsp(T paramT);
  
  public int getContentLayoutId()
  {
    return 2131560784;
  }
  
  public abstract List<aabe> getCustomParts();
  
  public abstract String getDropFrameMonitorTag();
  
  public abstract String getEmptyHint();
  
  public PublicListInnerFragment getHostFragment()
  {
    if ((getParentFragment() instanceof PublicListInnerFragment)) {
      return (PublicListInnerFragment)getParentFragment();
    }
    return null;
  }
  
  public abstract boolean getIsFinishFromRsp(T paramT);
  
  public int getItemCount()
  {
    return this.mDataList.size();
  }
  
  public abstract void getListDataAsync(aacw<E> paramaacw, String paramString);
  
  public abstract List<E> getListDataFromRsp(T paramT);
  
  public abstract String getLogTag();
  
  public abstract int getPageCount();
  
  public abstract VSBaseRequest getRequest(String paramString);
  
  public abstract int getStatusBarColor();
  
  public abstract String getTitle();
  
  public abstract View getTitleTabView(ViewGroup paramViewGroup);
  
  public void handleListData(List<E> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    preHandleListData(paramList, paramBoolean1, paramBoolean2);
    ThreadManagerV2.getUIHandlerV2().post(new BaseListBlock.1(this, paramList, paramBoolean1, paramBoolean2));
  }
  
  protected void handleResponse(boolean paramBoolean1, boolean paramBoolean2, long paramLong, String paramString1, String paramString2, T paramT)
  {
    if ((!paramBoolean1) || (paramLong != 0L) || (paramT == null))
    {
      showErrorView(paramString2, paramLong);
      notifyLoadingComplete(true, false);
      return;
    }
    paramString2 = getListDataFromRsp(paramT);
    this.mIsFinish = getIsFinishFromRsp(paramT);
    this.mLastAttachInfo = getAttachInfoFromRsp(paramT);
    if (paramString2 != null) {
      QLog.d(getLogTag(), 1, paramString1 + "rspData size:" + paramString2.size() + " | isFinish:" + this.mIsFinish + " | attachInfo:" + getAttachInfoFromRsp(paramT));
    }
    handleListData(paramString2, paramBoolean2, this.mIsFinish);
  }
  
  public abstract void initTitleBar(View paramView);
  
  public void loadData(aabu paramaabu)
  {
    Object localObject1 = null;
    Object localObject2 = getRequestWithLoadInfo(paramaabu);
    if ((localObject2 != null) && (getParentFragment() != null))
    {
      boolean bool1 = paramaabu.e();
      boolean bool2 = ((VSBaseRequest)localObject2).isEnableCache();
      paramaabu = ((VSBaseRequest)localObject2).getCmdName();
      VSNetworkHelper.a().a(getParentFragment().hashCode(), (VSBaseRequest)localObject2, new aacs(this, paramaabu, (VSBaseRequest)localObject2, bool1, bool2));
    }
    do
    {
      return;
      if ((paramaabu.c()) || (paramaabu.d()))
      {
        getListDataAsync(new aact(this), null);
        return;
      }
    } while (!paramaabu.e());
    localObject2 = new aacu(this);
    paramaabu = localObject1;
    if (getDataList() != null)
    {
      paramaabu = localObject1;
      if (getDataList().size() > 0) {
        paramaabu = getAttachInfoFromItemData(getDataList().get(getDataList().size() - 1));
      }
    }
    if (paramaabu != null)
    {
      getListDataAsync((aacw)localObject2, paramaabu);
      return;
    }
    handleLoadMoreData();
  }
  
  public void notifyLoadingComplete(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = true;
    int i;
    aabj localaabj;
    if ((getBlockContainer() != null) && (getBlockMerger() != null))
    {
      getLoadInfo().a(4);
      getBlockContainer().setRefreshing(false);
      if (isLastPeerBlock())
      {
        if (getItemCount() != 0) {
          break label74;
        }
        i = 1;
        localaabj = getBlockMerger();
        if ((!paramBoolean2) || (i != 0)) {
          break label79;
        }
      }
    }
    label74:
    label79:
    for (paramBoolean2 = bool;; paramBoolean2 = false)
    {
      localaabj.a(paramBoolean1, paramBoolean2);
      return;
      i = 0;
      break;
    }
  }
  
  public void onDoubleClickTitle()
  {
    if ((getBlockContainer() != null) && (getBlockContainer().a() != null)) {
      getBlockContainer().a().scrollToPosition(0);
    }
  }
  
  public abstract void onTitleTabSelectedChanged(View paramView, boolean paramBoolean);
  
  protected void preHandleListData(List<E> paramList, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void setInitBean(Serializable paramSerializable)
  {
    this.mInitBean = paramSerializable;
  }
  
  public void setInitData(ArrayList<E> paramArrayList)
  {
    setDatas(paramArrayList);
  }
  
  public void showEmptyView()
  {
    if ((getHostFragment() != null) && (getHostFragment().a() != null)) {
      getHostFragment().a().a().d(getEmptyHint());
    }
  }
  
  protected void showErrorView(String paramString, long paramLong)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramString = anzj.a(2131718459);
      if (getItemCount() <= 0) {
        break label35;
      }
      vws.a(paramLong, BaseApplicationImpl.getContext(), 1, paramString, 1);
    }
    label35:
    while ((getHostFragment() == null) || (getHostFragment().a() == null))
    {
      return;
      break;
    }
    getHostFragment().a().a().d(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aacr
 * JD-Core Version:    0.7.0.1
 */