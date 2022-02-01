import android.os.SystemClock;
import android.text.Layout;
import android.view.MotionEvent;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.qphone.base.util.QLog;

public class agkl
{
  private agkm jdField_a_of_type_Agkm;
  private amcl jdField_a_of_type_Amcl;
  
  public agkl(@NonNull agkm paramagkm, @NonNull amcl paramamcl)
  {
    this.jdField_a_of_type_Agkm = paramagkm;
    this.jdField_a_of_type_Amcl = paramamcl;
  }
  
  private int a()
  {
    Object localObject = ambu.a().a();
    if ((localObject instanceof TextView))
    {
      localObject = (TextView)localObject;
      if (QLog.isColorLevel()) {
        QLog.d("BaseChatItemLayout", 2, "getOneCharWidth");
      }
      return (int)Layout.getDesiredWidth("大", ((TextView)localObject).getPaint());
    }
    if (QLog.isColorLevel()) {
      QLog.d("BaseChatItemLayout", 2, "getOneCharWidth default");
    }
    return BaseChatItemLayout.a * 3;
  }
  
  public static MotionEvent a(int paramInt, float paramFloat1, float paramFloat2)
  {
    return MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), paramInt, paramFloat1, paramFloat2, 0);
  }
  
  public int a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    int i = this.jdField_a_of_type_Amcl.a((int)paramFloat1, (int)paramFloat2);
    this.jdField_a_of_type_Amcl.a(false);
    Object localObject = a(0, this.jdField_a_of_type_Agkm.a(paramInt1), this.jdField_a_of_type_Agkm.b(paramInt1));
    ((MotionEvent)localObject).setSource(-1);
    this.jdField_a_of_type_Agkm.onTouchEvent((MotionEvent)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("BaseChatItemLayout", 2, new Object[] { "touchIndex=", Integer.valueOf(i), " cursorType=", Integer.valueOf(paramInt1) });
    }
    if (i == -1)
    {
      localObject = a(3, paramFloat1, paramFloat2);
      ((MotionEvent)localObject).setSource(-1);
      this.jdField_a_of_type_Agkm.onTouchEvent((MotionEvent)localObject);
      this.jdField_a_of_type_Amcl.a(true);
      return i;
    }
    if (paramInt1 == 1) {
      localObject = behh.a(this.jdField_a_of_type_Amcl.a(), i, paramInt2, true);
    }
    while (((String)localObject).length() < paramInt2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BaseChatItemLayout", 2, new Object[] { "cutString is small than request cutString=", localObject });
      }
      localObject = a(3, paramFloat1, paramFloat2);
      ((MotionEvent)localObject).setSource(-1);
      this.jdField_a_of_type_Agkm.onTouchEvent((MotionEvent)localObject);
      this.jdField_a_of_type_Amcl.a(true);
      if (paramInt1 == 1)
      {
        return a(a() + paramFloat1, paramFloat2, 2, paramInt2);
        localObject = behh.a(this.jdField_a_of_type_Amcl.a(), i, paramInt2);
      }
      else
      {
        return -1;
      }
    }
    this.jdField_a_of_type_Agkm.a(i, ((String)localObject).length(), paramInt1);
    localObject = a(2, paramFloat1, paramFloat2);
    ((MotionEvent)localObject).setSource(-1);
    this.jdField_a_of_type_Agkm.onTouchEvent((MotionEvent)localObject);
    localObject = a(1, paramFloat1, paramFloat2);
    ((MotionEvent)localObject).setSource(-1);
    this.jdField_a_of_type_Agkm.onTouchEvent((MotionEvent)localObject);
    this.jdField_a_of_type_Amcl.a(true);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agkl
 * JD-Core Version:    0.7.0.1
 */