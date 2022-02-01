package io.flutter.embedding.android;

import android.graphics.Matrix;
import android.os.Build.VERSION;
import android.view.InputDevice;
import android.view.InputDevice.MotionRange;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class AndroidTouchProcessor
{
  private static final int BYTES_PER_FIELD = 8;
  private static final Matrix IDENTITY_TRANSFORM;
  private static final int POINTER_DATA_FIELD_COUNT = 29;
  private static final int POINTER_DATA_FLAG_BATCHED = 1;
  private static final int _POINTER_BUTTON_PRIMARY = 1;
  private final MotionEventTracker motionEventTracker;
  private final FlutterRenderer renderer;
  private final boolean trackMotionEvents;
  
  static
  {
    AppMethodBeat.i(190461);
    IDENTITY_TRANSFORM = new Matrix();
    AppMethodBeat.o(190461);
  }
  
  public AndroidTouchProcessor(FlutterRenderer paramFlutterRenderer, boolean paramBoolean)
  {
    AppMethodBeat.i(190423);
    this.renderer = paramFlutterRenderer;
    this.motionEventTracker = MotionEventTracker.getInstance();
    this.trackMotionEvents = paramBoolean;
    AppMethodBeat.o(190423);
  }
  
  private void addPointerForIndex(MotionEvent paramMotionEvent, int paramInt1, int paramInt2, int paramInt3, Matrix paramMatrix, ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(190434);
    if (paramInt2 == -1)
    {
      AppMethodBeat.o(190434);
      return;
    }
    long l1 = 0L;
    if (this.trackMotionEvents) {
      l1 = this.motionEventTracker.track(paramMotionEvent).getId();
    }
    int j = getPointerDeviceTypeForToolType(paramMotionEvent.getToolType(paramInt1));
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
        break label533;
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
      label257:
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
        break label560;
      }
      paramByteBuffer.putDouble(paramMotionEvent.getAxisValue(24, paramInt1));
      paramByteBuffer.putDouble(0.0D);
      label394:
      paramByteBuffer.putDouble(paramMotionEvent.getSize(paramInt1));
      paramByteBuffer.putDouble(paramMotionEvent.getToolMajor(paramInt1));
      paramByteBuffer.putDouble(paramMotionEvent.getToolMinor(paramInt1));
      paramByteBuffer.putDouble(0.0D);
      paramByteBuffer.putDouble(0.0D);
      paramByteBuffer.putDouble(paramMotionEvent.getAxisValue(8, paramInt1));
      if (j != 2) {
        break label577;
      }
      paramByteBuffer.putDouble(paramMotionEvent.getAxisValue(25, paramInt1));
    }
    for (;;)
    {
      paramByteBuffer.putLong(paramInt3);
      if (i != 1) {
        break label587;
      }
      paramByteBuffer.putDouble(-paramMotionEvent.getAxisValue(10));
      paramByteBuffer.putDouble(-paramMotionEvent.getAxisValue(9));
      AppMethodBeat.o(190434);
      return;
      i = 0;
      break;
      label533:
      if (j == 2)
      {
        l1 = paramMotionEvent.getButtonState() >> 4 & 0xF;
        break label257;
      }
      l1 = 0L;
      break label257;
      label560:
      paramByteBuffer.putDouble(0.0D);
      paramByteBuffer.putDouble(0.0D);
      break label394;
      label577:
      paramByteBuffer.putDouble(0.0D);
    }
    label587:
    paramByteBuffer.putDouble(0.0D);
    paramByteBuffer.putDouble(0.0D);
    AppMethodBeat.o(190434);
  }
  
  private int getPointerChangeForAction(int paramInt)
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
  
  private int getPointerDeviceTypeForToolType(int paramInt)
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
  
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent)
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
    int i = getPointerChangeForAction(paramMotionEvent.getActionMasked());
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramMotionEvent.getPointerCount() * 29 * 8);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    addPointerForIndex(paramMotionEvent, paramMotionEvent.getActionIndex(), i, 0, IDENTITY_TRANSFORM, localByteBuffer);
    if (localByteBuffer.position() % 232 != 0)
    {
      paramMotionEvent = new AssertionError("Packet position is not on field boundary.");
      AppMethodBeat.o(9980);
      throw paramMotionEvent;
    }
    this.renderer.dispatchPointerDataPacket(localByteBuffer, localByteBuffer.position());
    AppMethodBeat.o(9980);
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(9979);
    boolean bool = onTouchEvent(paramMotionEvent, IDENTITY_TRANSFORM);
    AppMethodBeat.o(9979);
    return bool;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent, Matrix paramMatrix)
  {
    AppMethodBeat.i(190479);
    int k = paramMotionEvent.getPointerCount();
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(k * 29 * 8);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    int j = paramMotionEvent.getActionMasked();
    int m = getPointerChangeForAction(paramMotionEvent.getActionMasked());
    int i;
    if ((j == 0) || (j == 5))
    {
      i = 1;
      if ((i != 0) || ((j != 1) && (j != 6))) {
        break label135;
      }
      j = 1;
      label82:
      if (i == 0) {
        break label141;
      }
      addPointerForIndex(paramMotionEvent, paramMotionEvent.getActionIndex(), m, 0, paramMatrix, localByteBuffer);
    }
    for (;;)
    {
      if (localByteBuffer.position() % 232 == 0) {
        break label234;
      }
      paramMotionEvent = new AssertionError("Packet position is not on field boundary");
      AppMethodBeat.o(190479);
      throw paramMotionEvent;
      i = 0;
      break;
      label135:
      j = 0;
      break label82;
      label141:
      if (j != 0)
      {
        i = 0;
        while (i < k)
        {
          if ((i != paramMotionEvent.getActionIndex()) && (paramMotionEvent.getToolType(i) == 1)) {
            addPointerForIndex(paramMotionEvent, i, 5, 1, paramMatrix, localByteBuffer);
          }
          i += 1;
        }
        addPointerForIndex(paramMotionEvent, paramMotionEvent.getActionIndex(), m, 0, paramMatrix, localByteBuffer);
      }
      else
      {
        i = 0;
        while (i < k)
        {
          addPointerForIndex(paramMotionEvent, i, m, 0, paramMatrix, localByteBuffer);
          i += 1;
        }
      }
    }
    label234:
    this.renderer.dispatchPointerDataPacket(localByteBuffer, localByteBuffer.position());
    AppMethodBeat.o(190479);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     io.flutter.embedding.android.AndroidTouchProcessor
 * JD-Core Version:    0.7.0.1
 */