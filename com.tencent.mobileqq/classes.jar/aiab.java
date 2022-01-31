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

public abstract class aiab
  extends BaseAdapter
  implements azwh, begh
{
  private int jdField_a_of_type_Int = 0;
  protected azwg a;
  private begh jdField_a_of_type_Begh;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private Hashtable<String, Bitmap> jdField_a_of_type_JavaUtilHashtable = new Hashtable();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  
  public aiab(Context paramContext, QQAppInterface paramQQAppInterface, ListView paramListView, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentWidgetListView.setOnScrollListener(this);
    this.jdField_a_of_type_Azwg = new azwg(paramContext, paramQQAppInterface);
    this.jdField_a_of_type_Azwg.a(this);
  }
  
  protected Bitmap a()
  {
    return bacm.a();
  }
  
  protected Bitmap a(int paramInt, String paramString)
  {
    if (ajed.Y.equals(paramString)) {}
    try
    {
      paramString = BitmapFactory.decodeResource(BaseApplicationImpl.getApplication().getResources(), 2130846324);
      return paramString;
    }
    catch (OutOfMemoryError paramString) {}
    return a(paramString, paramInt, (byte)0);
    return null;
  }
  
  protected Bitmap a(String paramString, int paramInt, byte paramByte)
  {
    Bitmap localBitmap = this.jdField_a_of_type_Azwg.a(paramInt, paramString);
    if (localBitmap != null) {
      return localBitmap;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Azwg.a();
      this.jdField_a_of_type_Boolean = false;
    }
    if (!this.jdField_a_of_type_Azwg.a()) {
      this.jdField_a_of_type_Azwg.a(paramString, paramInt, true, paramByte);
    }
    return a();
  }
  
  protected void a(aidy paramaidy, Bitmap paramBitmap)
  {
    if (paramaidy.jdField_a_of_type_AndroidWidgetImageView == null) {}
    do
    {
      do
      {
        do
        {
          return;
          if (ajed.z.equals(paramaidy.jdField_a_of_type_JavaLangString))
          {
            paramaidy.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130843326);
            return;
          }
          if (ajed.A.equals(paramaidy.jdField_a_of_type_JavaLangString))
          {
            paramaidy.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130843324);
            return;
          }
          if (ajed.B.equals(paramaidy.jdField_a_of_type_JavaLangString))
          {
            paramaidy.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130843329);
            return;
          }
          if (ajed.y.equals(paramaidy.jdField_a_of_type_JavaLangString))
          {
            paramaidy.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130839271);
            return;
          }
          if ((!ajed.Z.equals(paramaidy.jdField_a_of_type_JavaLangString)) || (!(paramaidy instanceof aidu))) {
            break;
          }
          paramBitmap = (aidu)paramaidy;
        } while (!(paramBitmap.a instanceof Friends));
        paramBitmap = (Friends)paramBitmap.a;
      } while (paramBitmap == null);
      if (!DeviceHeadMgr.getInstance().isLostQfindDevice(paramBitmap.name)) {
        break;
      }
      paramBitmap = DeviceHeadMgr.getInstance().getDeviceHeadDrawableByDin(paramBitmap.name);
    } while (paramBitmap == null);
    paramaidy.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(paramBitmap);
    return;
    paramaidy.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(DeviceHeadMgr.getInstance().getDeviceHeadByDin(paramBitmap.name)));
    return;
    if (paramBitmap != null)
    {
      paramaidy.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(paramBitmap));
      return;
    }
    paramaidy.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(a(paramaidy.jdField_a_of_type_Int, paramaidy.jdField_a_of_type_JavaLangString)));
  }
  
  public void a(begh parambegh)
  {
    this.jdField_a_of_type_Begh = parambegh;
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
        aiac localaiac = (aiac)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i).getTag();
        if ((localaiac != null) && (localaiac.jdField_a_of_type_JavaLangString != null) && (localaiac.jdField_a_of_type_JavaLangString.length() > 0) && (localaiac.jdField_a_of_type_JavaLangString.equals(paramString))) {
          localaiac.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
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
    if (this.jdField_a_of_type_Azwg != null)
    {
      this.jdField_a_of_type_Azwg.d();
      this.jdField_a_of_type_Azwg = new azwg(null, paramQQAppInterface);
      this.jdField_a_of_type_Azwg.a(this);
    }
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetListView != null) && (this.jdField_a_of_type_ComTencentWidgetListView.getOnScrollListener() == this)) {
      this.jdField_a_of_type_ComTencentWidgetListView.setOnScrollListener(null);
    }
    if (this.jdField_a_of_type_Azwg != null) {
      this.jdField_a_of_type_Azwg.d();
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
      } while (this.jdField_a_of_type_Azwg.a());
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
        if ((paramBitmap != null) && ((paramBitmap instanceof aiac)))
        {
          paramString = (aiac)paramBitmap;
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
          else if ((paramBitmap != null) && ((paramBitmap instanceof aidy)))
          {
            paramString = (aidy)paramBitmap;
            a(paramString, (Bitmap)this.jdField_a_of_type_JavaUtilHashtable.get(paramString.jdField_a_of_type_JavaLangString));
          }
        }
      }
    }
    this.jdField_a_of_type_JavaUtilHashtable.clear();
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Begh != null) {
      this.jdField_a_of_type_Begh.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if ((paramInt == 0) || (paramInt == 1))
    {
      if (this.jdField_a_of_type_Azwg.a()) {
        this.jdField_a_of_type_Azwg.b();
      }
      if (this.jdField_a_of_type_ComTencentWidgetListView != null)
      {
        int j = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
        int i = 0;
        if (i < j)
        {
          Object localObject = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i).getTag();
          if ((localObject != null) && ((localObject instanceof aiac)))
          {
            localObject = (aiac)localObject;
            if ((localObject != null) && (((aiac)localObject).jdField_a_of_type_JavaLangString != null) && (((aiac)localObject).jdField_a_of_type_JavaLangString.length() > 0)) {
              ((aiac)localObject).jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(a(((aiac)localObject).jdField_c_of_type_Int, ((aiac)localObject).jdField_a_of_type_JavaLangString));
            }
          }
          for (;;)
          {
            i += 1;
            break;
            if ((localObject != null) && ((localObject instanceof aidy)))
            {
              localObject = (aidy)localObject;
              a((aidy)localObject, (Bitmap)this.jdField_a_of_type_JavaUtilHashtable.get(((aidy)localObject).jdField_a_of_type_JavaLangString));
            }
          }
        }
      }
    }
    else
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Azwg.a();
      this.jdField_a_of_type_Azwg.c();
    }
    if (this.jdField_a_of_type_Begh != null) {
      this.jdField_a_of_type_Begh.onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aiab
 * JD-Core Version:    0.7.0.1
 */