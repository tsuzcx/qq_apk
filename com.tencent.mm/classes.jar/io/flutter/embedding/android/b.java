package io.flutter.embedding.android;

import android.graphics.Matrix;
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
  private static final Matrix SMt;
  private final a SMr;
  private final h SMs;
  private final boolean SMu;
  
  static
  {
    AppMethodBeat.i(215042);
    SMt = new Matrix();
    AppMethodBeat.o(215042);
  }
  
  public b(a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(215039);
    this.SMr = parama;
    this.SMs = h.hwD();
    this.SMu = paramBoolean;
    AppMethodBeat.o(215039);
  }
  
  private void a(MotionEvent paramMotionEvent, int paramInt1, int paramInt2, int paramInt3, Matrix paramMatrix, ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(215041);
    if (paramInt2 == -1)
    {
      AppMethodBeat.o(215041);
      return;
    }
    long l1 = 0L;
    if (this.SMu) {
      l1 = this.SMs.aD(paramMotionEvent).id;
    }
    int j = ato(paramMotionEvent.getToolType(paramInt1));
    int i;
    if (paramMotionEvent.getActionMasked() == 8)
    {
      i = 1;
      long l2 = paramMotionEvent.getEventTime();
      paramByteBuffer.putLong(l1);
      paramByteBuffer.putLong(l2 * 1000L);
      paramByteBuffer.putLong(paramInt2);
      paramByteBuffer.putLong(j);
      paramByteBuffer.putLong(i);
      paramByteBuffer.putLong(paramMotionEvent.getPointerId(paramInt1));
      paramByteBuffer.putLong(0L);
      float[] arrayOfFloat = new float[2];
      arrayOfFloat[0] = paramMotionEvent.getX(paramInt1);
      arrayOfFloat[1] = paramMotionEvent.getY(paramInt1);
      paramMatrix.mapPoints(arrayOfFloat);
      paramByteBuffer.putDouble(arrayOfFloat[0]);
      paramByteBuffer.putDouble(arrayOfFloat[1]);
      paramByteBuffer.putDouble(0.0D);
      paramByteBuffer.putDouble(0.0D);
      if (j != 1) {
        break label532;
      }
      l2 = paramMotionEvent.getButtonState() & 0x1F;
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
      label256:
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
        paramMatrix = paramMotionEvent.getDevice().getMotionRange(2);
        d2 = d4;
        d1 = d3;
        if (paramMatrix != null)
        {
          d1 = paramMatrix.getMin();
          d2 = paramMatrix.getMax();
        }
      }
      paramByteBuffer.putDouble(d1);
      paramByteBuffer.putDouble(d2);
      if (j != 2) {
        break label559;
      }
      paramByteBuffer.putDouble(paramMotionEvent.getAxisValue(24, paramInt1));
      paramByteBuffer.putDouble(0.0D);
      label393:
      paramByteBuffer.putDouble(paramMotionEvent.getSize(paramInt1));
      paramByteBuffer.putDouble(paramMotionEvent.getToolMajor(paramInt1));
      paramByteBuffer.putDouble(paramMotionEvent.getToolMinor(paramInt1));
      paramByteBuffer.putDouble(0.0D);
      paramByteBuffer.putDouble(0.0D);
      paramByteBuffer.putDouble(paramMotionEvent.getAxisValue(8, paramInt1));
      if (j != 2) {
        break label576;
      }
      paramByteBuffer.putDouble(paramMotionEvent.getAxisValue(25, paramInt1));
    }
    for (;;)
    {
      paramByteBuffer.putLong(paramInt3);
      if (i != 1) {
        break label586;
      }
      paramByteBuffer.putDouble(-paramMotionEvent.getAxisValue(10));
      paramByteBuffer.putDouble(-paramMotionEvent.getAxisValue(9));
      AppMethodBeat.o(215041);
      return;
      i = 0;
      break;
      label532:
      if (j == 2)
      {
        l1 = paramMotionEvent.getButtonState() >> 4 & 0xF;
        break label256;
      }
      l1 = 0L;
      break label256;
      label559:
      paramByteBuffer.putDouble(0.0D);
      paramByteBuffer.putDouble(0.0D);
      break label393;
      label576:
      paramByteBuffer.putDouble(0.0D);
    }
    label586:
    paramByteBuffer.putDouble(0.0D);
    paramByteBuffer.putDouble(0.0D);
    AppMethodBeat.o(215041);
  }
  
  private static int atn(int paramInt)
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
  
  private static int ato(int paramInt)
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
  
  public final boolean a(MotionEvent paramMotionEvent, Matrix paramMatrix)
  {
    AppMethodBeat.i(215040);
    int k = paramMotionEvent.getPointerCount();
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(k * 29 * 8);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    int j = paramMotionEvent.getActionMasked();
    int m = atn(paramMotionEvent.getActionMasked());
    int i;
    if ((j == 0) || (j == 5))
    {
      i = 1;
      if ((i != 0) || ((j != 1) && (j != 6))) {
        break label134;
      }
      j = 1;
      label81:
      if (i == 0) {
        break label140;
      }
      a(paramMotionEvent, paramMotionEvent.getActionIndex(), m, 0, paramMatrix, localByteBuffer);
    }
    for (;;)
    {
      if (localByteBuffer.position() % 232 == 0) {
        break label233;
      }
      paramMotionEvent = new AssertionError("Packet position is not on field boundary");
      AppMethodBeat.o(215040);
      throw paramMotionEvent;
      i = 0;
      break;
      label134:
      j = 0;
      break label81;
      label140:
      if (j != 0)
      {
        i = 0;
        while (i < k)
        {
          if ((i != paramMotionEvent.getActionIndex()) && (paramMotionEvent.getToolType(i) == 1)) {
            a(paramMotionEvent, i, 5, 1, paramMatrix, localByteBuffer);
          }
          i += 1;
        }
        a(paramMotionEvent, paramMotionEvent.getActionIndex(), m, 0, paramMatrix, localByteBuffer);
      }
      else
      {
        i = 0;
        while (i < k)
        {
          a(paramMotionEvent, i, m, 0, paramMatrix, localByteBuffer);
          i += 1;
        }
      }
    }
    label233:
    this.SMr.dispatchPointerDataPacket(localByteBuffer, localByteBuffer.position());
    AppMethodBeat.o(215040);
    return true;
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
    int i = atn(paramMotionEvent.getActionMasked());
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramMotionEvent.getPointerCount() * 29 * 8);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    a(paramMotionEvent, paramMotionEvent.getActionIndex(), i, 0, SMt, localByteBuffer);
    if (localByteBuffer.position() % 232 != 0)
    {
      paramMotionEvent = new AssertionError("Packet position is not on field boundary.");
      AppMethodBeat.o(9980);
      throw paramMotionEvent;
    }
    this.SMr.dispatchPointerDataPacket(localByteBuffer, localByteBuffer.position());
    AppMethodBeat.o(9980);
    return true;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(9979);
    boolean bool = a(paramMotionEvent, SMt);
    AppMethodBeat.o(9979);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.embedding.android.b
 * JD-Core Version:    0.7.0.1
 */