import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import com.tencent.mobileqq.addon.DiyPendantSticker;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class akmu
  extends aevp
  implements akmy
{
  double jdField_a_of_type_Double;
  akmx jdField_a_of_type_Akmx = akmx.a();
  String jdField_a_of_type_JavaLangString;
  List<akmw> jdField_a_of_type_JavaUtilList;
  Paint b = new Paint();
  int c;
  int d;
  
  public akmu(Resources paramResources)
  {
    super(paramResources);
  }
  
  public List<akmw> a()
  {
    int i = 0;
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_JavaUtilList != null)
        {
          localList1 = this.jdField_a_of_type_JavaUtilList;
          return localList1;
        }
        List localList1 = this.jdField_a_of_type_Akmx.a(this);
        if ((localList1 == null) || (localList1.isEmpty())) {
          break label188;
        }
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
        if (i < localList1.size())
        {
          DiyPendantSticker localDiyPendantSticker = (DiyPendantSticker)localList1.get(i);
          int j = -16777216;
          try
          {
            int k = Color.parseColor(localDiyPendantSticker.fontColor);
            j = k;
          }
          catch (Exception localException)
          {
            QLog.e("DiyPendantDrawable", 1, new Object[] { "parse sticker text color failed.", localException.getMessage() });
            continue;
          }
          this.jdField_a_of_type_JavaUtilList.add(new akmv(this, i, localDiyPendantSticker.angle, localDiyPendantSticker.text, localDiyPendantSticker.fontId, localDiyPendantSticker.fontType, j));
          i += 1;
          continue;
        }
        localList2 = this.jdField_a_of_type_JavaUtilList;
      }
      finally {}
      continue;
      label188:
      List localList2 = null;
    }
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    Object localObject = a();
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((akmw)((Iterator)localObject).next()).a(paramCanvas, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
    }
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    int i = paramRect.width();
    this.c = Math.abs(paramRect.height() - i);
    this.jdField_a_of_type_Double = (i / 250.0D);
    this.d = ((int)(100.0D * this.jdField_a_of_type_Double));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akmu
 * JD-Core Version:    0.7.0.1
 */