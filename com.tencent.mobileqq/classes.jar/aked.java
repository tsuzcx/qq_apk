import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.DeviceHeadMgr;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import cooperation.qzone.widget.QzoneSearchResultView;
import java.util.Hashtable;

public abstract class aked
  extends BaseAdapter
  implements bcwt, bhpo
{
  private int jdField_a_of_type_Int = 0;
  protected bcws a;
  private bhpo jdField_a_of_type_Bhpo;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private Hashtable<String, Bitmap> jdField_a_of_type_JavaUtilHashtable = new Hashtable();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  
  public aked(Context paramContext, QQAppInterface paramQQAppInterface, ListView paramListView, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentWidgetListView.setOnScrollListener(this);
    this.jdField_a_of_type_Bcws = new bcws(paramContext, paramQQAppInterface);
    this.jdField_a_of_type_Bcws.a(this);
  }
  
  protected Bitmap a()
  {
    return bdda.a();
  }
  
  protected Bitmap a(int paramInt, String paramString)
  {
    if (aljq.Z.equals(paramString)) {}
    try
    {
      paramString = BitmapFactory.decodeResource(BaseApplicationImpl.getApplication().getResources(), 2130846892);
      return paramString;
    }
    catch (OutOfMemoryError paramString) {}
    return a(paramString, paramInt, (byte)0);
    return null;
  }
  
  protected Bitmap a(String paramString, int paramInt, byte paramByte)
  {
    Bitmap localBitmap = this.jdField_a_of_type_Bcws.a(paramInt, paramString);
    if (localBitmap != null) {
      return localBitmap;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Bcws.a();
      this.jdField_a_of_type_Boolean = false;
    }
    if (!this.jdField_a_of_type_Bcws.a()) {
      this.jdField_a_of_type_Bcws.a(paramString, paramInt, true, paramByte);
    }
    return a();
  }
  
  protected void a(akia paramakia, Bitmap paramBitmap)
  {
    if (paramakia.jdField_a_of_type_AndroidWidgetImageView == null) {}
    do
    {
      do
      {
        do
        {
          return;
          if (aljq.z.equals(paramakia.jdField_a_of_type_JavaLangString))
          {
            paramakia.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130843762);
            return;
          }
          if (aljq.A.equals(paramakia.jdField_a_of_type_JavaLangString))
          {
            paramakia.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130843760);
            return;
          }
          if (aljq.B.equals(paramakia.jdField_a_of_type_JavaLangString))
          {
            paramakia.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130843765);
            return;
          }
          if (aljq.y.equals(paramakia.jdField_a_of_type_JavaLangString))
          {
            paramakia.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130839384);
            return;
          }
          if ((!aljq.aa.equals(paramakia.jdField_a_of_type_JavaLangString)) || (!(paramakia instanceof akhw))) {
            break;
          }
          paramBitmap = (akhw)paramakia;
        } while (!(paramBitmap.a instanceof Friends));
        paramBitmap = (Friends)paramBitmap.a;
      } while (paramBitmap == null);
      if (!DeviceHeadMgr.getInstance().isLostQfindDevice(paramBitmap.name)) {
        break;
      }
      paramBitmap = DeviceHeadMgr.getInstance().getDeviceHeadDrawableByDin(paramBitmap.name);
    } while (paramBitmap == null);
    paramakia.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(paramBitmap);
    return;
    paramakia.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(DeviceHeadMgr.getInstance().getDeviceHeadByDin(paramBitmap.name)));
    return;
    if (paramBitmap != null)
    {
      paramakia.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(paramBitmap));
      return;
    }
    paramakia.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(a(paramakia.jdField_a_of_type_Int, paramakia.jdField_a_of_type_JavaLangString)));
  }
  
  public void a(bhpo parambhpo)
  {
    this.jdField_a_of_type_Bhpo = parambhpo;
  }
  
  protected void a(String paramString, Bitmap paramBitmap)
  {
    int j;
    int i;
    if ((this.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentWidgetListView != null))
    {
      j = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
      i = 0;
    }
    for (;;)
    {
      if (i < j)
      {
        akee localakee = (akee)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i).getTag();
        if ((localakee != null) && (localakee.jdField_a_of_type_JavaLangString != null) && (localakee.jdField_a_of_type_JavaLangString.length() > 0) && (localakee.jdField_a_of_type_JavaLangString.equals(paramString))) {
          localakee.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FacePreloadBaseAdapter", 2, "checkResetApp, need change app!");
    }
    if (this.jdField_a_of_type_Bcws != null)
    {
      this.jdField_a_of_type_Bcws.d();
      this.jdField_a_of_type_Bcws = new bcws(null, paramQQAppInterface);
      this.jdField_a_of_type_Bcws.a(this);
    }
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetListView != null) && (this.jdField_a_of_type_ComTencentWidgetListView.getOnScrollListener() == this)) {
      this.jdField_a_of_type_ComTencentWidgetListView.setOnScrollListener(null);
    }
    if (this.jdField_a_of_type_Bcws != null) {
      this.jdField_a_of_type_Bcws.d();
    }
    this.jdField_a_of_type_ComTencentWidgetListView = null;
  }
  
  public int getCount()
  {
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return null;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_Boolean) {
      if (paramInt1 == 0) {
        this.jdField_a_of_type_Boolean = false;
      }
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_Bcws.a());
      if (paramBitmap != null) {
        this.jdField_a_of_type_JavaUtilHashtable.put(paramString, paramBitmap);
      }
    } while (paramInt1 > 0);
    if ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 1))
    {
      paramInt2 = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
      paramInt1 = 0;
      if (paramInt1 < paramInt2)
      {
        paramString = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt1);
        paramBitmap = paramString.getTag();
        if ((paramBitmap != null) && ((paramBitmap instanceof akee)))
        {
          paramString = (akee)paramBitmap;
          if ((paramString != null) && (paramString.jdField_a_of_type_JavaLangString != null) && (paramString.jdField_a_of_type_JavaLangString.length() > 0))
          {
            paramBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilHashtable.get(paramString.jdField_a_of_type_JavaLangString);
            if (paramBitmap != null) {
              paramString.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
            }
          }
        }
        for (;;)
        {
          paramInt1 += 1;
          break;
          if ((paramString instanceof QzoneSearchResultView))
          {
            paramString = (QzoneSearchResultView)paramString;
            if ((paramString != null) && (!TextUtils.isEmpty(paramString.a())))
            {
              paramBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilHashtable.get(paramString.a());
              if (paramBitmap != null) {
                paramString.setAvartaView(paramBitmap);
              }
            }
          }
          else if ((paramBitmap != null) && ((paramBitmap instanceof akia)))
          {
            paramString = (akia)paramBitmap;
            a(paramString, (Bitmap)this.jdField_a_of_type_JavaUtilHashtable.get(paramString.jdField_a_of_type_JavaLangString));
          }
        }
      }
    }
    this.jdField_a_of_type_JavaUtilHashtable.clear();
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Bhpo != null) {
      this.jdField_a_of_type_Bhpo.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if ((paramInt == 0) || (paramInt == 1))
    {
      if (this.jdField_a_of_type_Bcws.a()) {
        this.jdField_a_of_type_Bcws.b();
      }
      if (this.jdField_a_of_type_ComTencentWidgetListView != null)
      {
        int j = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
        int i = 0;
        if (i < j)
        {
          Object localObject = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i).getTag();
          if ((localObject != null) && ((localObject instanceof akee)))
          {
            localObject = (akee)localObject;
            if ((localObject != null) && (((akee)localObject).jdField_a_of_type_JavaLangString != null) && (((akee)localObject).jdField_a_of_type_JavaLangString.length() > 0)) {
              ((akee)localObject).jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(a(((akee)localObject).jdField_c_of_type_Int, ((akee)localObject).jdField_a_of_type_JavaLangString));
            }
          }
          for (;;)
          {
            i += 1;
            break;
            if ((localObject != null) && ((localObject instanceof akia)))
            {
              localObject = (akia)localObject;
              a((akia)localObject, (Bitmap)this.jdField_a_of_type_JavaUtilHashtable.get(((akia)localObject).jdField_a_of_type_JavaLangString));
            }
          }
        }
      }
    }
    else
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Bcws.a();
      this.jdField_a_of_type_Bcws.c();
    }
    if (this.jdField_a_of_type_Bhpo != null) {
      this.jdField_a_of_type_Bhpo.onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aked
 * JD-Core Version:    0.7.0.1
 */