import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public final class alny
  extends alnx
{
  public boolean a;
  public int c;
  public String c = "";
  
  public alny()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public static alnx a(JSONObject paramJSONObject)
  {
    Object localObject = paramJSONObject.optString("type");
    if (("diy_chartlet".equalsIgnoreCase((String)localObject)) || ("static".equalsIgnoreCase((String)localObject)))
    {
      alny localalny = new alny();
      localalny.jdField_b_of_type_JavaLangString = ((String)localObject);
      localObject = BaseApplicationImpl.getApplication().getApplicationContext();
      localalny.jdField_a_of_type_JavaLangString = paramJSONObject.optString("align").toUpperCase();
      if (paramJSONObject.has("rect"))
      {
        JSONArray localJSONArray = paramJSONObject.optJSONArray("rect");
        localalny.jdField_a_of_type_ArrayOfInt = new int[4];
        int i = 0;
        while (i < localJSONArray.length())
        {
          localalny.jdField_a_of_type_ArrayOfInt[i] = azvv.a((Context)localObject, localJSONArray.optInt(i) / 2);
          i += 1;
        }
      }
      localalny.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("mirror", true);
      if (QLog.isColorLevel()) {
        QLog.d("DiyBubbleConfig", 2, "Resolve DiyBubblePasterConfig json->" + paramJSONObject);
      }
      return localalny;
    }
    QLog.e("DiyBubbleConfig", 1, "error! paster type: " + (String)localObject);
    return null;
  }
  
  @TargetApi(11)
  public Rect a(alok paramalok, Canvas paramCanvas)
  {
    int i1 = 0;
    paramCanvas = paramalok.getBounds();
    Resources localResources = BaseApplicationImpl.getContext().getResources();
    if (jdField_b_of_type_Int == -1) {
      jdField_b_of_type_Int = aciy.a(48.0F, localResources);
    }
    int j = this.jdField_a_of_type_ArrayOfInt[3];
    int i = this.jdField_a_of_type_ArrayOfInt[2];
    int m;
    int n;
    int k;
    if (paramCanvas.height() >= jdField_b_of_type_Int)
    {
      aciy.a(10.0F, localResources);
      aciy.a(9.0F, localResources);
      m = 0;
      n = 0;
      k = j;
      j = n;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_JavaLangString.startsWith("T")) {
        n = m + this.jdField_a_of_type_ArrayOfInt[1];
      }
      for (;;)
      {
        label111:
        if (this.jdField_a_of_type_JavaLangString.endsWith("L")) {
          m = this.jdField_a_of_type_ArrayOfInt[0] + j;
        }
        for (;;)
        {
          j = m;
          if (paramalok.b)
          {
            j = m;
            if (!this.jdField_a_of_type_Boolean) {
              j = paramCanvas.width() - m - i;
            }
          }
          return new Rect(j, n, i + j, k + n);
          n = aciy.a(10.0F, localResources);
          m = aciy.a(7.0F, localResources);
          if ("static".equalsIgnoreCase(this.jdField_b_of_type_JavaLangString))
          {
            m = -aciy.a(2.0F, localResources);
            k = j;
            j = 0;
            break;
          }
          k = j;
          if (j <= m * 2) {
            break label407;
          }
          m *= 2;
          j = this.jdField_a_of_type_ArrayOfInt[2] * m / this.jdField_a_of_type_ArrayOfInt[3];
          i = j;
          k = m;
          if (j >= n * 2) {
            break label407;
          }
          int i2 = j / 2;
          k = m;
          i = j;
          j = n - i2;
          m = 0;
          break;
          if (!this.jdField_a_of_type_JavaLangString.startsWith("B")) {
            break label401;
          }
          n = this.jdField_a_of_type_ArrayOfInt[1] + this.jdField_a_of_type_ArrayOfInt[3] + paramCanvas.height() - k - m;
          break label111;
          m = i1;
          if (this.jdField_a_of_type_JavaLangString.endsWith("R")) {
            m = this.jdField_a_of_type_ArrayOfInt[0] + this.jdField_a_of_type_ArrayOfInt[2] + paramCanvas.width() - i - j;
          }
        }
        label401:
        n = 0;
      }
      label407:
      m = 0;
      j = 0;
    }
  }
  
  public void a(alok paramalok, Canvas paramCanvas)
  {
    if ((paramCanvas == null) || (paramalok == null)) {}
    for (;;)
    {
      return;
      Bitmap localBitmap;
      if ("diy_chartlet".equalsIgnoreCase(this.jdField_b_of_type_JavaLangString)) {
        localBitmap = almr.a().b(paramalok, this);
      }
      while (localBitmap != null)
      {
        int i = paramCanvas.save();
        if ((paramalok.b) && (this.jdField_a_of_type_Boolean)) {
          paramCanvas.scale(-1.0F, 1.0F, paramalok.getBounds().centerX(), paramalok.getBounds().centerY());
        }
        Paint localPaint = new Paint();
        paramalok = a(paramalok, paramCanvas);
        if (paramCanvas.getHeight() < jdField_b_of_type_Int) {
          paramCanvas.drawBitmap(localBitmap, null, paramalok, localPaint);
        }
        for (;;)
        {
          paramCanvas.restoreToCount(i);
          return;
          if (!"static".equalsIgnoreCase(this.jdField_b_of_type_JavaLangString)) {
            break label166;
          }
          localBitmap = almr.a().a(paramalok, this);
          break;
          paramCanvas.drawBitmap(localBitmap, paramalok.left, paramalok.top, localPaint);
        }
        label166:
        localBitmap = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alny
 * JD-Core Version:    0.7.0.1
 */