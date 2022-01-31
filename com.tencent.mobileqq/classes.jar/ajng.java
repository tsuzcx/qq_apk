import java.util.Comparator;

class ajng
  implements Comparator<atcu>
{
  ajng(ajnf paramajnf) {}
  
  public int a(atcu paramatcu1, atcu paramatcu2)
  {
    if ((!paramatcu1.a()) && (paramatcu2.a())) {
      return -1;
    }
    if ((paramatcu1.a()) && (!paramatcu2.a())) {
      return 1;
    }
    return (int)(paramatcu2.a - paramatcu1.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajng
 * JD-Core Version:    0.7.0.1
 */