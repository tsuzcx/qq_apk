import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StImage;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.subscribe.bizdapters.FakerFeedsAdapter.1;
import com.tencent.biz.subscribe.bizdapters.FakerFeedsAdapter.2;
import com.tencent.biz.subscribe.bizdapters.FakerFeedsAdapter.3;
import com.tencent.biz.subscribe.bizdapters.FakerFeedsAdapter.4;
import com.tencent.biz.subscribe.event.PublishBoxStatusEvent;
import com.tencent.biz.subscribe.event.SubscribeFeedsEvent;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class aagr
  extends aabp<CertifiedAccountMeta.StFeed>
  implements aaam, aapu
{
  protected RecyclerView.LayoutManager a;
  private boolean a;
  private boolean b;
  
  public aagr(Bundle paramBundle)
  {
    super(paramBundle);
    this.jdField_a_of_type_Boolean = true;
  }
  
  private int a(String paramString)
  {
    int i = 0;
    for (;;)
    {
      CertifiedAccountMeta.StFeed localStFeed;
      if (i < getDataList().size())
      {
        localStFeed = (CertifiedAccountMeta.StFeed)getDataList().get(i);
        if ((paramString.startsWith("fakeid_")) && (!localStFeed.id.get().startsWith("fakeid_"))) {
          QLog.d("FakerFeedsAdapter", 2, "has none fakeFeeds");
        }
      }
      else
      {
        return -1;
      }
      if (paramString.equals(localStFeed.id.get()))
      {
        QLog.d("FakerFeedsAdapter", 2, "find fakeid:" + paramString);
        return i;
      }
      i += 1;
    }
  }
  
  private void a(SubscribeFeedsEvent paramSubscribeFeedsEvent)
  {
    Object localObject = new StringBuilder().append("fakeFeed state:").append(paramSubscribeFeedsEvent.mState).append(",fakeId:").append(paramSubscribeFeedsEvent.mTargetId).append(",fake listSize:");
    int i;
    if (paramSubscribeFeedsEvent.mFakeFeedDataList == null)
    {
      i = 0;
      QLog.d("FakerFeedsAdapter", 2, i);
      if (getShareData("share_key_subscribe_user") != null) {
        break label83;
      }
    }
    label83:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            i = paramSubscribeFeedsEvent.mFakeFeedDataList.size();
            break;
            switch (paramSubscribeFeedsEvent.mState)
            {
            default: 
              return;
            case 1: 
              if (aaee.a() != null)
              {
                paramSubscribeFeedsEvent.mSingleFakeFeed.poster.icon.set(aaee.a().icon.get());
                paramSubscribeFeedsEvent.mSingleFakeFeed.poster.nick.set(aaee.a().nick.get());
              }
              getMainHandler().post(new FakerFeedsAdapter.1(this, paramSubscribeFeedsEvent));
              return;
            case 2: 
              i = a(paramSubscribeFeedsEvent.mTargetId);
            }
          } while (i == -1);
          localObject = aaek.a((CertifiedAccountMeta.StFeed)getDataList().get(i));
          ((CertifiedAccountMeta.StFeed)localObject).id.set(paramSubscribeFeedsEvent.mSingleFakeFeed.id.get());
          ((CertifiedAccountMeta.StFeed)localObject).createTime.set(paramSubscribeFeedsEvent.mSingleFakeFeed.createTime.get());
          ((CertifiedAccountMeta.StFeed)localObject).cover.url.set(paramSubscribeFeedsEvent.mSingleFakeFeed.cover.url.get());
          getMainHandler().post(new FakerFeedsAdapter.2(this, (CertifiedAccountMeta.StFeed)localObject, i));
          return;
          i = a(paramSubscribeFeedsEvent.mTargetId);
        } while (i == -1);
        getMainHandler().post(new FakerFeedsAdapter.3(this, i));
        return;
      } while (!this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_Boolean = false;
    } while ((paramSubscribeFeedsEvent.mFakeFeedDataList == null) || (paramSubscribeFeedsEvent.mFakeFeedDataList.size() <= 0));
    if (aaee.a() != null)
    {
      localObject = paramSubscribeFeedsEvent.mFakeFeedDataList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        CertifiedAccountMeta.StFeed localStFeed = (CertifiedAccountMeta.StFeed)((Iterator)localObject).next();
        if (localStFeed.poster != null)
        {
          localStFeed.poster.icon.set(aaee.a().icon.get());
          localStFeed.poster.nick.set(aaee.a().nick.get());
        }
      }
    }
    getMainHandler().post(new FakerFeedsAdapter.4(this, paramSubscribeFeedsEvent));
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager instanceof StaggeredGridLayoutManager)) {
      ((StaggeredGridLayoutManager)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager).invalidateSpanAssignments();
    }
  }
  
  public void a(int paramInt)
  {
    if (blgn.a(paramInt, getDataList())) {
      return;
    }
    getDataList().remove(paramInt);
    notifyItemRemoved(paramInt);
  }
  
  protected void a(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (getDataList() != null) {
      a(getDataList().indexOf(paramStFeed));
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public void b()
  {
    if (a())
    {
      this.jdField_a_of_type_Boolean = true;
      QzoneIPCModule.a().b();
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(SubscribeFeedsEvent.class);
    localArrayList.add(PublishBoxStatusEvent.class);
    return localArrayList;
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager = paramRecyclerView.getLayoutManager();
    if (this.b)
    {
      aaak.a().a(this);
      QzoneIPCModule.a().b();
    }
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    if (this.b) {
      aaak.a().b(this);
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof SubscribeFeedsEvent)) {
      a((SubscribeFeedsEvent)paramSimpleBaseEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aagr
 * JD-Core Version:    0.7.0.1
 */