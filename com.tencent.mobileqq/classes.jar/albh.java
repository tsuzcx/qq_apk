class albh
  extends alxx
{
  albh(albg paramalbg) {}
  
  public void onRotationUpdateQuaternion(float[] paramArrayOfFloat)
  {
    if (albg.a(this.a) != null) {
      albg.a(this.a).a(paramArrayOfFloat);
    }
  }
  
  public void updateAccelerometer(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    if (albg.a(this.a) != null) {
      albg.a(this.a).a(paramFloat1, paramFloat2, paramFloat3, paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     albh
 * JD-Core Version:    0.7.0.1
 */