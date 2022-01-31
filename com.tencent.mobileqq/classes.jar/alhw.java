public class alhw
{
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("skuId:").append(this.c).append(",skuName:").append(this.d).append(",skuPrice:").append(this.e).append(",imageUrl:").append(this.b).append(",detailUrl:").append(this.a);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     alhw
 * JD-Core Version:    0.7.0.1
 */