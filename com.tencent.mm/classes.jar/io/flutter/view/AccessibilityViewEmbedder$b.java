package io.flutter.view;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AccessibilityViewEmbedder$b
{
  final int id;
  final View view;
  
  private AccessibilityViewEmbedder$b(View paramView, int paramInt)
  {
    this.view = paramView;
    this.id = paramInt;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(9826);
    if (this == paramObject)
    {
      AppMethodBeat.o(9826);
      return true;
    }
    if (!(paramObject instanceof b))
    {
      AppMethodBeat.o(9826);
      return false;
    }
    paramObject = (b)paramObject;
    if ((this.id == paramObject.id) && (this.view.equals(paramObject.view)))
    {
      AppMethodBeat.o(9826);
      return true;
    }
    AppMethodBeat.o(9826);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(9827);
    int i = this.view.hashCode();
    int j = this.id;
    AppMethodBeat.o(9827);
    return (i + 31) * 31 + j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     io.flutter.view.AccessibilityViewEmbedder.b
 * JD-Core Version:    0.7.0.1
 */