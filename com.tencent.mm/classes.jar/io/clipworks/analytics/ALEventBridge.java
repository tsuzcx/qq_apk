package io.clipworks.analytics;

import android.util.ArraySet;
import com.google.d.bv;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ALEventBridge
{
  private final Set<b> _eventSinks;
  
  public ALEventBridge()
  {
    AppMethodBeat.i(189498);
    this._eventSinks = new ArraySet();
    AppMethodBeat.o(189498);
  }
  
  public void addEventSink(b paramb)
  {
    AppMethodBeat.i(189507);
    this._eventSinks.add(paramb);
    AppMethodBeat.o(189507);
  }
  
  public boolean hasAnyEventSink()
  {
    AppMethodBeat.i(189523);
    if (!this._eventSinks.isEmpty())
    {
      AppMethodBeat.o(189523);
      return true;
    }
    AppMethodBeat.o(189523);
    return false;
  }
  
  public void removeEventSink(b paramb)
  {
    AppMethodBeat.i(189513);
    this._eventSinks.remove(paramb);
    AppMethodBeat.o(189513);
  }
  
  public void sinkEventS12(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(189538);
    if (paramByteBuffer == null)
    {
      AppMethodBeat.o(189538);
      return;
    }
    try
    {
      paramByteBuffer = c.a.L(paramByteBuffer);
      paramByteBuffer = new a(paramByteBuffer.aiut, paramByteBuffer.aiuu, paramByteBuffer.aiuq, paramByteBuffer.aiur, paramByteBuffer.getName(), paramByteBuffer.kkG().aiG());
      TreeMap localTreeMap = new TreeMap();
      if (paramByteBuffer.aiul != null) {
        localTreeMap.putAll(paramByteBuffer.aiul);
      }
      localTreeMap.put("GSN", String.valueOf(paramByteBuffer.aiug));
      localTreeMap.put("LSN", String.valueOf(paramByteBuffer.aiuh));
      paramByteBuffer.aiul = localTreeMap;
      paramByteBuffer = this._eventSinks.iterator();
      while (paramByteBuffer.hasNext()) {
        paramByteBuffer.next();
      }
      AppMethodBeat.o(189538);
    }
    catch (Exception paramByteBuffer)
    {
      AppMethodBeat.o(189538);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     io.clipworks.analytics.ALEventBridge
 * JD-Core Version:    0.7.0.1
 */