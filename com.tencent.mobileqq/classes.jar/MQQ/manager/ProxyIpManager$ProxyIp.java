package mqq.manager;

public class ProxyIpManager$ProxyIp
{
  public String ip;
  public int port;
  public int type;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.ip);
    localStringBuilder.append(":");
    localStringBuilder.append(this.port);
    localStringBuilder.append(":");
    localStringBuilder.append(this.type);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     mqq.manager.ProxyIpManager.ProxyIp
 * JD-Core Version:    0.7.0.1
 */