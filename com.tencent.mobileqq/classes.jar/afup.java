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
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

public class afup
  extends BaseAdapter
  implements View.OnClickListener, azwh
{
  private long jdField_a_of_type_Long;
  private afur jdField_a_of_type_Afur = new afur();
  afux jdField_a_of_type_Afux;
  protected ahbe a;
  private Context jdField_a_of_type_AndroidContentContext;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected XListView a;
  protected final ArrayList<RecentBaseData> a;
  private Hashtable<String, Bitmap> jdField_a_of_type_JavaUtilHashtable = new Hashtable();
  
  public afup(QQAppInterface paramQQAppInterface, Context paramContext, XListView paramXListView, afux paramafux)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(99);
    this.jdField_a_of_type_Ahbe = new ahbe(paramQQAppInterface, this, false);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_Afux = paramafux;
  }
  
  protected View a()
  {
    return View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131493714, null);
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
    if (this.jdField_a_of_type_Ahbe != null) {
      this.jdField_a_of_type_Ahbe.a();
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Drawable paramDrawable)
  {
    if ((paramView == null) || (paramRecentBaseData == null)) {}
    Drawable localDrawable;
    do
    {
      return;
      localDrawable = paramDrawable;
      if (paramDrawable == null)
      {
        localDrawable = paramDrawable;
        if (this.jdField_a_of_type_Ahbe != null) {
          localDrawable = this.jdField_a_of_type_Ahbe.a(paramRecentBaseData.a(), paramRecentBaseData.a());
        }
      }
    } while (this.jdField_a_of_type_Afur == null);
    this.jdField_a_of_type_Afur.a(paramView, paramRecentBaseData, this.jdField_a_of_type_AndroidContentContext, localDrawable);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_Ahbe != null) {
      this.jdField_a_of_type_Ahbe.a(paramQQAppInterface);
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
    if ((localRecentBaseData != null) && (localRecentBaseData.a().equals(Integer.valueOf(0)))) {
      return 1;
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    try
    {
      Object localObject = getItem(paramInt);
      if ((localObject instanceof RecentBaseData))
      {
        localObject = (RecentBaseData)localObject;
        if (((RecentBaseData)localObject).a().equals("0"))
        {
          if (paramView == null)
          {
            paramView = a();
            paramView.setTag(-1, Integer.valueOf(paramInt));
            paramView.setOnClickListener(this);
            return paramView;
          }
        }
        else
        {
          paramView = this.jdField_a_of_type_Afur.a(paramInt, localObject, this.jdField_a_of_type_Ahbe, paramView, paramViewGroup, this.jdField_a_of_type_AndroidContentContext, this, null, null);
          return paramView;
        }
      }
    }
    catch (Throwable paramView)
    {
      ahca.a(this.jdField_a_of_type_AndroidContentContext, false, paramView);
      throw new RuntimeException(paramView);
    }
    return paramView;
  }
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag(-1);
    if (!(paramView instanceof Integer)) {
      if (QLog.isDevelopLevel()) {
        QLog.i("MiniMsgTabAdapter", 4, "RecentAdpater onClick tag is not int");
      }
    }
    do
    {
      do
      {
        return;
        paramView = getItem(((Integer)paramView).intValue());
      } while (!(paramView instanceof RecentBaseData));
      paramView = (RecentBaseData)paramView;
      if (QLog.isDevelopLevel()) {
        QLog.i("MiniMsgTabAdapter", 2, "mTitleName" + paramView.mTitleName + ", msgSummary " + paramView.mLastMsg);
      }
    } while (this.jdField_a_of_type_Afux == null);
    this.jdField_a_of_type_Afux.a(paramView);
    paramView.b();
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
        int i = localRecentBaseData.a();
        paramString = localRecentBaseData.a();
        i = ((Integer)ahbe.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, paramString).first).intValue();
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
          paramBitmap = BaseApplication.getContext().getResources().getDrawable(2130839769);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afup
 * JD-Core Version:    0.7.0.1
 */