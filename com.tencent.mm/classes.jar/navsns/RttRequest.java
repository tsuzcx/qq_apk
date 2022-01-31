package navsns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.i;
import com.tencent.tencentmap.mapsdk.maps.a.k;
import com.tencent.tencentmap.mapsdk.maps.a.l;
import com.tencent.tencentmap.mapsdk.maps.a.m;
import com.tencent.tencentmap.mapsdk.maps.a.n;
import java.util.ArrayList;

public final class RttRequest
  extends m
  implements Cloneable
{
  static ArrayList<Integer> a;
  public ArrayList<Integer> bounds = null;
  public short zip = 0;
  public short zoom = 0;
  
  static
  {
    AppMethodBeat.i(101135);
    if (!RttRequest.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      b = bool;
      a = new ArrayList();
      a.add(Integer.valueOf(0));
      AppMethodBeat.o(101135);
      return;
    }
  }
  
  public RttRequest() {}
  
  public RttRequest(ArrayList<Integer> paramArrayList, short paramShort1, short paramShort2)
  {
    this.bounds = paramArrayList;
    this.zoom = paramShort1;
    this.zip = paramShort2;
  }
  
  public final String className()
  {
    return "navsns.RttRequest";
  }
  
  public final Object clone()
  {
    AppMethodBeat.i(101130);
    localObject1 = null;
    try
    {
      Object localObject2 = super.clone();
      localObject1 = localObject2;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      while (b) {}
      localObject1 = new AssertionError();
      AppMethodBeat.o(101130);
      throw ((Throwable)localObject1);
    }
    AppMethodBeat.o(101130);
    return localObject1;
  }
  
  public final void display(StringBuilder paramStringBuilder, int paramInt)
  {
    AppMethodBeat.i(101133);
    paramStringBuilder = new i(paramStringBuilder, paramInt);
    paramStringBuilder.a(this.bounds, "bounds");
    paramStringBuilder.a(this.zoom, "zoom");
    paramStringBuilder.a(this.zip, "zip");
    AppMethodBeat.o(101133);
  }
  
  public final void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    AppMethodBeat.i(101134);
    paramStringBuilder = new i(paramStringBuilder, paramInt);
    paramStringBuilder.a(this.bounds, true);
    paramStringBuilder.a(this.zoom, true);
    paramStringBuilder.a(this.zip, false);
    AppMethodBeat.o(101134);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(101128);
    if (paramObject == null)
    {
      AppMethodBeat.o(101128);
      return false;
    }
    paramObject = (RttRequest)paramObject;
    if ((n.a(this.bounds, paramObject.bounds)) && (n.a(this.zoom, paramObject.zoom)) && (n.a(this.zip, paramObject.zip)))
    {
      AppMethodBeat.o(101128);
      return true;
    }
    AppMethodBeat.o(101128);
    return false;
  }
  
  public final String fullClassName()
  {
    return "navsns.RttRequest";
  }
  
  public final ArrayList<Integer> getBounds()
  {
    return this.bounds;
  }
  
  public final short getZip()
  {
    return this.zip;
  }
  
  public final short getZoom()
  {
    return this.zoom;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(101129);
    try
    {
      Exception localException1 = new Exception("Need define key first!");
      AppMethodBeat.o(101129);
      throw localException1;
    }
    catch (Exception localException2)
    {
      AppMethodBeat.o(101129);
    }
    return 0;
  }
  
  public final void readFrom(k paramk)
  {
    AppMethodBeat.i(101132);
    this.bounds = ((ArrayList)paramk.a(a, 0, true));
    this.zoom = paramk.a(this.zoom, 1, true);
    this.zip = paramk.a(this.zip, 2, true);
    AppMethodBeat.o(101132);
  }
  
  public final void setBounds(ArrayList<Integer> paramArrayList)
  {
    this.bounds = paramArrayList;
  }
  
  public final void setZip(short paramShort)
  {
    this.zip = paramShort;
  }
  
  public final void setZoom(short paramShort)
  {
    this.zoom = paramShort;
  }
  
  public final void writeTo(l paraml)
  {
    AppMethodBeat.i(101131);
    paraml.a(this.bounds, 0);
    paraml.a(this.zoom, 1);
    paraml.a(this.zip, 2);
    AppMethodBeat.o(101131);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     navsns.RttRequest
 * JD-Core Version:    0.7.0.1
 */