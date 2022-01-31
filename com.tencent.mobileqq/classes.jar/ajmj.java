public class ajmj
{
  public int a;
  public int b;
  public int c;
  public int d;
  public int e;
  public int f;
  public int g;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{").append("errCode:").append(this.a).append(",cost:").append(this.b);
    if (this.c > 0) {
      localStringBuilder.append(",mem:").append(this.c);
    }
    if (this.d > 0) {
      localStringBuilder.append(",cpu:").append(this.d);
    }
    if (this.f != 0) {
      localStringBuilder.append(",javaHeap:").append(this.f);
    }
    if (this.g != 0) {
      localStringBuilder.append(",nativeHeap:").append(this.g);
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajmj
 * JD-Core Version:    0.7.0.1
 */