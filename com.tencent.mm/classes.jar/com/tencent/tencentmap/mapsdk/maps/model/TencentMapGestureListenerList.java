package com.tencent.tencentmap.mapsdk.maps.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class TencentMapGestureListenerList
  implements TencentMapGestureListener
{
  private ArrayList<TencentMapGestureListener> mListeners;
  
  public TencentMapGestureListenerList()
  {
    AppMethodBeat.i(173376);
    this.mListeners = new ArrayList();
    AppMethodBeat.o(173376);
  }
  
  public void addListener(TencentMapGestureListener paramTencentMapGestureListener)
  {
    try
    {
      AppMethodBeat.i(173377);
      if ((paramTencentMapGestureListener != null) && (!this.mListeners.contains(paramTencentMapGestureListener))) {
        this.mListeners.add(paramTencentMapGestureListener);
      }
      AppMethodBeat.o(173377);
      return;
    }
    finally {}
  }
  
  public boolean onDoubleTap(float paramFloat1, float paramFloat2)
  {
    try
    {
      AppMethodBeat.i(173379);
      int i = this.mListeners.size() - 1;
      while (i >= 0)
      {
        ((TencentMapGestureListener)this.mListeners.get(i)).onDoubleTap(paramFloat1, paramFloat2);
        i -= 1;
      }
      AppMethodBeat.o(173379);
      return false;
    }
    finally {}
  }
  
  public boolean onDown(float paramFloat1, float paramFloat2)
  {
    try
    {
      AppMethodBeat.i(173384);
      int i = this.mListeners.size() - 1;
      while (i >= 0)
      {
        ((TencentMapGestureListener)this.mListeners.get(i)).onDown(paramFloat1, paramFloat2);
        i -= 1;
      }
      AppMethodBeat.o(173384);
      return false;
    }
    finally {}
  }
  
  public boolean onFling(float paramFloat1, float paramFloat2)
  {
    try
    {
      AppMethodBeat.i(173381);
      int i = this.mListeners.size() - 1;
      while (i >= 0)
      {
        ((TencentMapGestureListener)this.mListeners.get(i)).onFling(paramFloat1, paramFloat2);
        i -= 1;
      }
      AppMethodBeat.o(173381);
      return false;
    }
    finally {}
  }
  
  public boolean onLongPress(float paramFloat1, float paramFloat2)
  {
    try
    {
      AppMethodBeat.i(173383);
      int i = this.mListeners.size() - 1;
      while (i >= 0)
      {
        ((TencentMapGestureListener)this.mListeners.get(i)).onLongPress(paramFloat1, paramFloat2);
        i -= 1;
      }
      AppMethodBeat.o(173383);
      return false;
    }
    finally {}
  }
  
  public void onMapStable()
  {
    try
    {
      AppMethodBeat.i(173386);
      int i = this.mListeners.size() - 1;
      while (i >= 0)
      {
        ((TencentMapGestureListener)this.mListeners.get(i)).onMapStable();
        i -= 1;
      }
      AppMethodBeat.o(173386);
      return;
    }
    finally {}
  }
  
  public boolean onScroll(float paramFloat1, float paramFloat2)
  {
    try
    {
      AppMethodBeat.i(173382);
      int i = this.mListeners.size() - 1;
      while (i >= 0)
      {
        ((TencentMapGestureListener)this.mListeners.get(i)).onScroll(paramFloat1, paramFloat2);
        i -= 1;
      }
      AppMethodBeat.o(173382);
      return false;
    }
    finally {}
  }
  
  public boolean onSingleTap(float paramFloat1, float paramFloat2)
  {
    try
    {
      AppMethodBeat.i(173380);
      int i = this.mListeners.size() - 1;
      while (i >= 0)
      {
        ((TencentMapGestureListener)this.mListeners.get(i)).onSingleTap(paramFloat1, paramFloat2);
        i -= 1;
      }
      AppMethodBeat.o(173380);
      return false;
    }
    finally {}
  }
  
  public boolean onUp(float paramFloat1, float paramFloat2)
  {
    try
    {
      AppMethodBeat.i(173385);
      int i = this.mListeners.size() - 1;
      while (i >= 0)
      {
        ((TencentMapGestureListener)this.mListeners.get(i)).onUp(paramFloat1, paramFloat2);
        i -= 1;
      }
      AppMethodBeat.o(173385);
      return false;
    }
    finally {}
  }
  
  public void removeListener(TencentMapGestureListener paramTencentMapGestureListener)
  {
    try
    {
      AppMethodBeat.i(173378);
      this.mListeners.remove(paramTencentMapGestureListener);
      AppMethodBeat.o(173378);
      return;
    }
    finally
    {
      paramTencentMapGestureListener = finally;
      throw paramTencentMapGestureListener;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListenerList
 * JD-Core Version:    0.7.0.1
 */