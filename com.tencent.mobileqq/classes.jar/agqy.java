import com.tencent.qphone.base.util.QLog;

public class agqy
{
  public agqx a = new agqx();
  public agqx b = new agqx();
  public agqx c = new agqx();
  public agqx d = new agqx();
  
  public void a()
  {
    this.a.a(this.b);
    this.c.a(this.d);
    this.b.a(this.d);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    this.a.a(paramFloat1, paramFloat2, paramFloat3, paramLong);
    this.b.a(paramFloat1, paramFloat2, paramFloat3, paramLong);
    this.c.a(paramFloat1, paramFloat2, paramFloat3, paramLong);
    this.d.a(paramFloat1, paramFloat2, paramFloat3, paramLong);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.a.a(this.b);
      this.c.a(this.d);
      this.b.a((this.c.jdField_a_of_type_Float + paramFloat1) / 2.0F, (this.c.b + paramFloat2) / 2.0F, (this.c.c + paramFloat3) / 2.0F, (this.c.jdField_a_of_type_Long + paramLong) / 2L);
      this.d.a(paramFloat1, paramFloat2, paramFloat3, paramLong);
      return;
    }
    this.b.a((this.c.jdField_a_of_type_Float + paramFloat1) / 2.0F, (this.c.b + paramFloat2) / 2.0F, (this.c.c + paramFloat3) / 2.0F, (this.c.jdField_a_of_type_Long + paramLong) / 2L);
    this.d.a(paramFloat1, paramFloat2, paramFloat3, paramLong);
  }
  
  public void a(agqy paramagqy)
  {
    this.a.a(paramagqy.a);
    this.b.a(paramagqy.b);
    this.c.a(paramagqy.c);
    this.d.a(paramagqy.d);
  }
  
  public void b(agqy paramagqy)
  {
    if (paramagqy.d == this.c)
    {
      this.a = paramagqy.a;
      this.c = paramagqy.c;
      this.b.a((this.d.jdField_a_of_type_Float + this.c.jdField_a_of_type_Float) / 2.0F, (this.d.b + this.c.b) / 2.0F, (this.d.c + this.c.c) / 2.0F, (this.d.jdField_a_of_type_Long + this.c.jdField_a_of_type_Long) / 2L);
    }
    do
    {
      return;
      if (this.d == paramagqy.c)
      {
        this.d.a(paramagqy.d);
        this.b.a((this.d.jdField_a_of_type_Float + this.c.jdField_a_of_type_Float) / 2.0F, (this.d.b + this.c.b) / 2.0F, (this.d.c + this.c.c) / 2.0F, (this.d.jdField_a_of_type_Long + this.c.jdField_a_of_type_Long) / 2L);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("TransPathJob", 2, "TransPathJob merge point error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agqy
 * JD-Core Version:    0.7.0.1
 */