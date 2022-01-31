public class albe
  extends alag
{
  public aldy a;
  public alkg a;
  public boolean a;
  public long b;
  public String b;
  public int d;
  public int e = 1;
  
  public albe(String paramString1, int paramInt1, int paramInt2, int paramInt3, alkg paramalkg, aldy paramaldy, String paramString2, long paramLong, boolean paramBoolean, int paramInt4, int paramInt5, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    super(paramString1, paramInt1, paramInt2, paramInt5, paramFloat1, paramFloat2, paramFloat3);
    this.d = paramInt3;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_b_of_type_Long = paramLong;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.e = paramInt4;
    this.jdField_a_of_type_Alkg = paramalkg;
    this.jdField_a_of_type_Aldy = paramaldy;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("OnlineVideoARRenderableInfo{");
    localStringBuilder.append("key=").append(this.jdField_a_of_type_JavaLangString).append('\'');
    localStringBuilder.append(", arType=").append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", trackMode=").append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", mRealRenderType=").append(this.d);
    localStringBuilder.append(", mKeyingParams='").append(this.jdField_a_of_type_Alkg).append('\'');
    localStringBuilder.append(", mVideoUrl='").append(this.jdField_b_of_type_JavaLangString).append('\'');
    localStringBuilder.append(", mVideoSize='").append(this.jdField_b_of_type_Long).append('\'');
    localStringBuilder.append(", mLayout='").append(this.jdField_a_of_type_Aldy).append('\'');
    localStringBuilder.append(", isSoftPlay='").append(this.jdField_a_of_type_Boolean).append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     albe
 * JD-Core Version:    0.7.0.1
 */