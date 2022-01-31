import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.AbsListView;
import com.tencent.widget.XListView;
import java.util.Hashtable;

public abstract class aimb
  extends bcod
  implements baxl, bfob
{
  private int jdField_a_of_type_Int = 0;
  protected Bitmap a;
  protected baxk a;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private Hashtable<String, Bitmap> jdField_a_of_type_JavaUtilHashtable = new Hashtable();
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public aimb(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    if (this.jdField_a_of_type_ComTencentWidgetXListView != null) {
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this);
    }
    this.b = paramBoolean;
    this.jdField_a_of_type_Baxk = new baxk(paramContext, paramQQAppInterface);
    this.jdField_a_of_type_Baxk.a(this);
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      this.jdField_a_of_type_AndroidGraphicsBitmap = bbdr.a();
    }
  }
  
  protected Bitmap a(String paramString)
  {
    return a(paramString, 1, (byte)0);
  }
  
  protected Bitmap a(String paramString, int paramInt)
  {
    return a(paramString, 1, (byte)0, paramInt);
  }
  
  public Bitmap a(String paramString, int paramInt, byte paramByte)
  {
    return a(paramString, paramInt, paramByte, 0);
  }
  
  public Bitmap a(String paramString, int paramInt1, byte paramByte, int paramInt2)
  {
    Bitmap localBitmap = this.jdField_a_of_type_Baxk.b(paramInt1, paramString, paramInt2);
    if (localBitmap != null) {
      return localBitmap;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Baxk.a();
      this.jdField_a_of_type_Boolean = false;
    }
    if (!this.jdField_a_of_type_Baxk.a()) {
      this.jdField_a_of_type_Baxk.a(paramString, paramInt1, true, paramByte);
    }
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  protected boolean a(aimv paramaimv)
  {
    return (paramaimv != null) && (paramaimv.a != null) && (paramaimv.a.length() > 0);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Baxk != null) {
      this.jdField_a_of_type_Baxk.d();
    }
    this.jdField_a_of_type_ComTencentWidgetXListView = null;
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
      return;
      if (paramBitmap != null) {
        this.jdField_a_of_type_JavaUtilHashtable.put(paramString, paramBitmap);
      }
    } while (paramInt1 > 0);
    if ((this.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentWidgetXListView != null))
    {
      paramInt2 = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        paramString = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt1).getTag();
        if ((paramString != null) && ((paramString instanceof aimv)))
        {
          paramString = (aimv)paramString;
          if (a(paramString))
          {
            paramBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilHashtable.get(paramString.a);
            if (paramBitmap != null) {
              paramString.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
            }
          }
        }
        paramInt1 += 1;
      }
    }
    this.jdField_a_of_type_JavaUtilHashtable.clear();
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (paramInt != 0)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Baxk.a();
      this.jdField_a_of_type_Baxk.c();
    }
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_Baxk.a()) {
        this.jdField_a_of_type_Baxk.b();
      }
      if (this.jdField_a_of_type_ComTencentWidgetXListView != null)
      {
        int i = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
        paramInt = 0;
        while (paramInt < i)
        {
          paramAbsListView = (aimv)this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt).getTag();
          if (a(paramAbsListView)) {
            paramAbsListView.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(a(paramAbsListView.a, paramAbsListView.jdField_c_of_type_Int, (byte)0));
          }
          paramInt += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aimb
 * JD-Core Version:    0.7.0.1
 */