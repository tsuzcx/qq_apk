import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentItemChatMsgData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

public class ajjj
  extends BaseAdapter
  implements View.OnClickListener, FaceDecoder.DecodeTaskCompletionListener
{
  private long jdField_a_of_type_Long;
  private ajjl jdField_a_of_type_Ajjl = new ajjl();
  ajjq jdField_a_of_type_Ajjq;
  protected aklg a;
  private Context jdField_a_of_type_AndroidContentContext;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected XListView a;
  protected final ArrayList<RecentBaseData> a;
  private Hashtable<String, Bitmap> jdField_a_of_type_JavaUtilHashtable = new Hashtable();
  
  public ajjj(QQAppInterface paramQQAppInterface, Context paramContext, XListView paramXListView, ajjq paramajjq)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(99);
    this.jdField_a_of_type_Aklg = new aklg(paramQQAppInterface, this, false);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_Ajjq = paramajjq;
  }
  
  protected View a()
  {
    return View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131559434, null);
  }
  
  public RecentBaseData a(View paramView)
  {
    if ((paramView != null) && ((paramView.getTag(-1) instanceof Integer)))
    {
      paramView = getItem(((Integer)paramView.getTag(-1)).intValue());
      if ((paramView instanceof RecentBaseData)) {
        return (RecentBaseData)paramView;
      }
    }
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Aklg != null) {
      this.jdField_a_of_type_Aklg.a();
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Drawable paramDrawable)
  {
    if ((paramView == null) || (paramRecentBaseData == null)) {}
    do
    {
      Drawable localDrawable;
      do
      {
        return;
        localDrawable = paramDrawable;
        if (paramDrawable == null)
        {
          localDrawable = paramDrawable;
          if (this.jdField_a_of_type_Aklg != null) {
            localDrawable = this.jdField_a_of_type_Aklg.a(paramRecentBaseData.getRecentUserType(), paramRecentBaseData.getRecentUserUin());
          }
        }
      } while (this.jdField_a_of_type_Ajjl == null);
      try
      {
        this.jdField_a_of_type_Ajjl.a(paramView, paramRecentBaseData, this.jdField_a_of_type_AndroidContentContext, localDrawable);
        return;
      }
      catch (Throwable paramView) {}
    } while (!akmb.b(this.jdField_a_of_type_AndroidContentContext));
    throw new RuntimeException(paramView);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_Aklg != null) {
      this.jdField_a_of_type_Aklg.a(paramQQAppInterface);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != paramQQAppInterface)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
      a(null);
    }
    if (QLog.isColorLevel()) {
      QLog.i("MiniMsgTabAdapter", 2, "onAccountChanged: invoked. Message: app: " + paramQQAppInterface);
    }
  }
  
  public void a(List<RecentBaseData> paramList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    int i;
    if (paramList != null) {
      i = -1;
    }
    for (;;)
    {
      try
      {
        paramList = paramList.iterator();
        if (paramList.hasNext())
        {
          RecentBaseData localRecentBaseData = (RecentBaseData)paramList.next();
          if (localRecentBaseData != null)
          {
            i += 1;
            if ((localRecentBaseData instanceof RecentItemChatMsgData)) {
              localRecentBaseData.mPosition = i;
            }
            this.jdField_a_of_type_JavaUtilArrayList.add(localRecentBaseData);
          }
          else if (QLog.isColorLevel())
          {
            QLog.i("MiniMsgTabAdapter", 2, "setDataList, [item is null]");
          }
        }
      }
      catch (Exception paramList)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MiniMsgTabAdapter", 2, paramList, new Object[0]);
        }
      }
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
        this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
      }
      for (;;)
      {
        notifyDataSetChanged();
        return;
        if (QLog.isColorLevel()) {
          QLog.i("MiniMsgTabAdapter", 2, "setDataList, size = 0");
        }
      }
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt >= 0) {
      localObject1 = localObject2;
    }
    try
    {
      if (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size()) {
        localObject1 = this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      }
      return localObject1;
    }
    catch (Exception localException)
    {
      do
      {
        localObject1 = localObject2;
      } while (!QLog.isColorLevel());
      QLog.i("MiniMsgTabAdapter", 2, localException.toString());
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    RecentBaseData localRecentBaseData = (RecentBaseData)getItem(paramInt);
    if ((localRecentBaseData != null) && (localRecentBaseData.getRecentUserUin().equals(Integer.valueOf(0)))) {
      return 1;
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    localObject2 = paramView;
    for (;;)
    {
      try
      {
        Object localObject3 = getItem(paramInt);
        localObject1 = paramView;
        localObject2 = paramView;
        if ((localObject3 instanceof RecentBaseData))
        {
          localObject2 = paramView;
          localObject1 = (RecentBaseData)localObject3;
          localObject2 = paramView;
          if (!((RecentBaseData)localObject1).getRecentUserUin().equals("0")) {
            continue;
          }
          localObject1 = paramView;
          if (paramView == null)
          {
            localObject2 = paramView;
            localObject1 = a();
            localObject2 = localObject1;
            ((View)localObject1).setTag(-1, Integer.valueOf(paramInt));
            localObject2 = localObject1;
            ((View)localObject1).setOnClickListener(this);
          }
        }
        paramView = (View)localObject1;
      }
      catch (Throwable localThrowable)
      {
        Object localObject1;
        paramView = (View)localObject2;
        akmb.a(this.jdField_a_of_type_AndroidContentContext, false, localThrowable);
        if (!akmb.b(this.jdField_a_of_type_AndroidContentContext)) {
          continue;
        }
        throw new RuntimeException(localThrowable);
      }
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localObject2 = paramView;
      localObject1 = this.jdField_a_of_type_Ajjl.a(paramInt, localObject1, this.jdField_a_of_type_Aklg, paramView, paramViewGroup, this.jdField_a_of_type_AndroidContentContext, this, null, null);
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag(-1);
    if (!(localObject instanceof Integer)) {
      if (QLog.isDevelopLevel()) {
        QLog.i("MiniMsgTabAdapter", 4, "RecentAdpater onClick tag is not int");
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject = getItem(((Integer)localObject).intValue());
      if ((localObject instanceof RecentBaseData))
      {
        localObject = (RecentBaseData)localObject;
        if (QLog.isDevelopLevel()) {
          QLog.i("MiniMsgTabAdapter", 2, "mTitleName" + ((RecentBaseData)localObject).mTitleName + ", msgSummary " + ((RecentBaseData)localObject).mLastMsg);
        }
        if (this.jdField_a_of_type_Ajjq != null)
        {
          this.jdField_a_of_type_Ajjq.a((RecentBaseData)localObject);
          ((RecentBaseData)localObject).clearUnReadNum();
        }
      }
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetXListView == null) || (TextUtils.isEmpty(paramString))) {}
    long l;
    boolean bool1;
    for (;;)
    {
      return;
      if ((paramBitmap != null) || (paramInt1 <= 0))
      {
        if (paramBitmap != null) {}
        try
        {
          this.jdField_a_of_type_JavaUtilHashtable.put(paramInt2 + ":" + paramString, paramBitmap);
          l = System.currentTimeMillis();
          if ((this.jdField_a_of_type_Long > 0L) && (l - this.jdField_a_of_type_Long > 300L))
          {
            bool1 = true;
            if (QLog.isColorLevel())
            {
              paramString = new StringBuilder().append("RecentAdapter.onDecodeTaskCompleted type=").append(paramInt2).append(", uin=").append(paramString).append(", remainingTasks=").append(paramInt1).append(", isdecodeFaceTimeout=").append(bool1).append(", avatar == null ? | ");
              if (paramBitmap != null) {
                break label265;
              }
              bool2 = true;
              QLog.d("MiniMsgTabAdapter", 2, bool2);
            }
            if ((paramInt1 > 0) && (!bool1)) {
              continue;
            }
            synchronized (this.jdField_a_of_type_JavaUtilHashtable)
            {
              if (this.jdField_a_of_type_JavaUtilHashtable.size() == 0) {
                return;
              }
            }
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          for (;;)
          {
            System.gc();
            localOutOfMemoryError.printStackTrace();
            QLog.i("MiniMsgTabAdapter", 1, "onDecodeTaskCompleted error:" + localOutOfMemoryError.getMessage());
            continue;
            bool1 = false;
            continue;
            label265:
            boolean bool2 = false;
          }
        }
      }
    }
    if (paramInt1 == 0)
    {
      this.jdField_a_of_type_Long = 0L;
      bool1 = false;
      paramInt2 = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
      paramInt1 = 0;
    }
    for (;;)
    {
      if (paramInt1 < paramInt2)
      {
        View localView = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt1);
        RecentBaseData localRecentBaseData = a(localView);
        if (localRecentBaseData == null)
        {
          break label667;
          this.jdField_a_of_type_Long = l;
          break;
        }
        int i = localRecentBaseData.getRecentUserType();
        paramString = localRecentBaseData.getRecentUserUin();
        i = ((Integer)aklg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, paramString).first).intValue();
        if (i == -2147483648) {
          break label667;
        }
        paramString = i + ":" + paramString;
        paramString = (Bitmap)this.jdField_a_of_type_JavaUtilHashtable.get(paramString);
        if (paramString == null) {
          break label667;
        }
        if (i == 103)
        {
          l = System.currentTimeMillis();
          paramBitmap = BaseApplication.getContext().getResources().getDrawable(2130840392);
          if ((paramBitmap instanceof SkinnableBitmapDrawable)) {
            ((SkinnableBitmapDrawable)paramBitmap).setGravity(81);
          }
          if ((paramBitmap instanceof BitmapDrawable)) {
            ((BitmapDrawable)paramBitmap).setGravity(81);
          }
          paramBitmap.setBounds(0, 0, paramBitmap.getIntrinsicWidth(), paramBitmap.getIntrinsicHeight());
          paramBitmap = new LayerDrawable(new Drawable[] { new BitmapDrawable(BaseApplication.getContext().getResources(), paramString), paramBitmap });
          paramString = paramBitmap;
          if (QLog.isDevelopLevel()) {
            QLog.i("MiniMsgTabAdapter", 4, "onDecodeTaskCompleted, subaccount cost = " + (System.currentTimeMillis() - l));
          }
        }
        for (paramString = paramBitmap;; paramString = new BitmapDrawable(BaseApplication.getContext().getResources(), paramString))
        {
          a(localView, localRecentBaseData, paramString);
          bool1 = true;
          break;
        }
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("MiniMsgTabAdapter", 4, "decodecomplete|faceCache size = " + this.jdField_a_of_type_JavaUtilHashtable.size() + ", isNeedUpdateAvatar=" + bool1);
      }
      this.jdField_a_of_type_JavaUtilHashtable.clear();
      return;
      label667:
      paramInt1 += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajjj
 * JD-Core Version:    0.7.0.1
 */