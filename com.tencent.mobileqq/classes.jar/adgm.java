import android.widget.ProgressBar;

class adgm
  implements Runnable
{
  adgm(adgl paramadgl, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    this.jdField_a_of_type_Adgl.a.a.setVisibility(0);
    float f = (float)this.jdField_a_of_type_Long / (float)this.b;
    this.jdField_a_of_type_Adgl.a.a.setProgress((int)(f * 100.0F));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adgm
 * JD-Core Version:    0.7.0.1
 */