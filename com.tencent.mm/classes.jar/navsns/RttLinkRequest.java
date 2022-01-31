package navsns;

import com.tencent.tencentmap.mapsdk.a.nk;
import com.tencent.tencentmap.mapsdk.a.nl;
import com.tencent.tencentmap.mapsdk.a.nm;
import java.util.ArrayList;

public final class RttLinkRequest
  extends nm
{
  static ArrayList<Integer> a = new ArrayList();
  public ArrayList<Integer> bounds = null;
  public short zip = 0;
  public short zoom = 0;
  
  static
  {
    a.add(Integer.valueOf(0));
  }
  
  public RttLinkRequest() {}
  
  public RttLinkRequest(ArrayList<Integer> paramArrayList, short paramShort1, short paramShort2)
  {
    this.bounds = paramArrayList;
    this.zoom = paramShort1;
    this.zip = paramShort2;
  }
  
  public final void readFrom(nk paramnk)
  {
    this.bounds = ((ArrayList)paramnk.a(a, 0, true));
    this.zoom = paramnk.a(this.zoom, 1, true);
    this.zip = paramnk.a(this.zip, 2, true);
  }
  
  public final void writeTo(nl paramnl)
  {
    paramnl.a(this.bounds, 0);
    paramnl.a(this.zoom, 1);
    paramnl.a(this.zip, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     navsns.RttLinkRequest
 * JD-Core Version:    0.7.0.1
 */