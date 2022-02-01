package io.flutter.embedding.android;

import android.os.Build.VERSION;
import android.view.InputDevice;
import android.view.InputDevice.MotionRange;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.b.a;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class b
{
  private final a MYh;
  
  public b(a parama)
  {
    this.MYh = parama;
  }
  
  private static void a(MotionEvent paramMotionEvent, int paramInt1, int paramInt2, int paramInt3, ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(9981);
    if (paramInt2 == -1)
    {
      AppMethodBeat.o(9981);
      return;
    }
    int j = ajG(paramMotionEvent.getToolType(paramInt1));
    int i;
    long l1;
    if (paramMotionEvent.getActionMasked() == 8)
    {
      i = 1;
      paramByteBuffer.putLong(paramMotionEvent.getEventTime() * 1000L);
      paramByteBuffer.putLong(paramInt2);
      paramByteBuffer.putLong(j);
      paramByteBuffer.putLong(i);
      paramByteBuffer.putLong(paramMotionEvent.getPointerId(paramInt1));
      paramByteBuffer.putLong(0L);
      paramByteBuffer.putDouble(paramMotionEvent.getX(paramInt1));
      paramByteBuffer.putDouble(paramMotionEvent.getY(paramInt1));
      paramByteBuffer.putDouble(0.0D);
      paramByteBuffer.putDouble(0.0D);
      if (j != 1) {
        break label471;
      }
      long l2 = paramMotionEvent.getButtonState() & 0x1F;
      l1 = l2;
      if (l2 == 0L)
      {
        l1 = l2;
        if (paramMotionEvent.getSource() == 8194) {
          if (paramInt2 != 4)
          {
            l1 = l2;
            if (paramInt2 != 5) {}
          }
          else
          {
            l1 = 1L;
          }
        }
      }
      label195:
      paramByteBuffer.putLong(l1);
      paramByteBuffer.putLong(0L);
      paramByteBuffer.putLong(0L);
      paramByteBuffer.putDouble(paramMotionEvent.getPressure(paramInt1));
      double d3 = 0.0D;
      double d4 = 1.0D;
      double d2 = d4;
      double d1 = d3;
      if (paramMotionEvent.getDevice() != null)
      {
        InputDevice.MotionRange localMotionRange = paramMotionEvent.getDevice().getMotionRange(2);
        d2 = d4;
        d1 = d3;
        if (localMotionRange != null)
        {
          d1 = localMotionRange.getMin();
          d2 = localMotionRange.getMax();
        }
      }
      paramByteBuffer.putDouble(d1);
      paramByteBuffer.putDouble(d2);
      if (j != 2) {
        break label498;
      }
      paramByteBuffer.putDouble(paramMotionEvent.getAxisValue(24, paramInt1));
      paramByteBuffer.putDouble(0.0D);
      label332:
      paramByteBuffer.putDouble(paramMotionEvent.getSize(paramInt1));
      paramByteBuffer.putDouble(paramMotionEvent.getToolMajor(paramInt1));
      paramByteBuffer.putDouble(paramMotionEvent.getToolMinor(paramInt1));
      paramByteBuffer.putDouble(0.0D);
      paramByteBuffer.putDouble(0.0D);
      paramByteBuffer.putDouble(paramMotionEvent.getAxisValue(8, paramInt1));
      if (j != 2) {
        break label515;
      }
      paramByteBuffer.putDouble(paramMotionEvent.getAxisValue(25, paramInt1));
    }
    for (;;)
    {
      paramByteBuffer.putLong(paramInt3);
      if (i != 1) {
        break label525;
      }
      paramByteBuffer.putDouble(-paramMotionEvent.getAxisValue(10));
      paramByteBuffer.putDouble(-paramMotionEvent.getAxisValue(9));
      AppMethodBeat.o(9981);
      return;
      i = 0;
      break;
      label471:
      if (j == 2)
      {
        l1 = paramMotionEvent.getButtonState() >> 4 & 0xF;
        break label195;
      }
      l1 = 0L;
      break label195;
      label498:
      paramByteBuffer.putDouble(0.0D);
      paramByteBuffer.putDouble(0.0D);
      break label332;
      label515:
      paramByteBuffer.putDouble(0.0D);
    }
    label525:
    paramByteBuffer.putDouble(0.0D);
    paramByteBuffer.putDouble(0.0D);
    AppMethodBeat.o(9981);
  }
  
  private static int ajF(int paramInt)
  {
    if (paramInt == 0) {}
    do
    {
      return 4;
      if (paramInt == 1) {
        return 6;
      }
    } while (paramInt == 5);
    if (paramInt == 6) {
      return 6;
    }
    if (paramInt == 2) {
      return 5;
    }
    if (paramInt == 7) {
      return 3;
    }
    if (paramInt == 3) {
      return 0;
    }
    if (paramInt == 8) {
      return 3;
    }
    return -1;
  }
  
  private static int ajG(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 4;
    case 1: 
      return 0;
    case 2: 
      return 2;
    case 3: 
      return 1;
    }
    return 3;
  }
  
  public final boolean onGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(9980);
    if ((Build.VERSION.SDK_INT >= 18) && (paramMotionEvent.isFromSource(2)))
    {
      i = 1;
      if ((paramMotionEvent.getActionMasked() != 7) && (paramMotionEvent.getActionMasked() != 8)) {
        break label65;
      }
    }
    label65:
    for (int j = 1;; j = 0)
    {
      if ((i != 0) && (j != 0)) {
        break label70;
      }
      AppMethodBeat.o(9980);
      return false;
      i = 0;
      break;
    }
    label70:
    int i = ajF(paramMotionEvent.getActionMasked());
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramMotionEvent.getPointerCount() * 28 * 8);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    a(paramMotionEvent, paramMotionEvent.getActionIndex(), i, 0, localByteBuffer);
    if (localByteBuffer.position() % 224 != 0)
    {
      paramMotionEvent = new AssertionError("Packet position is not on field boundary.");
      AppMethodBeat.o(9980);
      throw paramMotionEvent;
    }
    this.MYh.dispatchPointerDataPacket(localByteBuffer, localByteBuffer.position());
    AppMethodBeat.o(9980);
    return true;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(9979);
    int k = paramMotionEvent.getPointerCount();
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(k * 28 * 8);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    int j = paramMotionEvent.getActionMasked();
    int m = ajF(paramMotionEvent.getActionMasked());
    int i;
    if ((j == 0) || (j == 5))
    {
      i = 1;
      if ((i != 0) || ((j != 1) && (j != 6))) {
        break label128;
      }
      j = 1;
      label76:
      if (i == 0) {
        break label133;
      }
      a(paramMotionEvent, paramMotionEvent.getActionIndex(), m, 0, localByteBuffer);
    }
    for (;;)
    {
      if (localByteBuffer.position() % 224 == 0) {
        break label219;
      }
      paramMotionEvent = new AssertionError("Packet position is not on field boundary");
      AppMethodBeat.o(9979);
      throw paramMotionEvent;
      i = 0;
      break;
      label128:
      j = 0;
      break label76;
      label133:
      if (j != 0)
      {
        i = 0;
        while (i < k)
        {
          if ((i != paramMotionEvent.getActionIndex()) && (paramMotionEvent.getToolType(i) == 1)) {
            a(paramMotionEvent, i, 5, 1, localByteBuffer);
          }
          i += 1;
        }
        a(paramMotionEvent, paramMotionEvent.getActionIndex(), m, 0, localByteBuffer);
      }
      else
      {
        i = 0;
        while (i < k)
        {
          a(paramMotionEvent, i, m, 0, localByteBuffer);
          i += 1;
        }
      }
    }
    label219:
    this.MYh.dispatchPointerDataPacket(localByteBuffer, localByteBuffer.position());
    AppMethodBeat.o(9979);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.embedding.android.b
 * JD-Core Version:    0.7.0.1
 */