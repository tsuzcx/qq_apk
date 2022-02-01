package com.tencent.mm.ui.chatting;

import android.annotation.TargetApi;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnHoverListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ag
{
  private static ag Gql;
  Object Gqk;
  
  public static ag eWa()
  {
    try
    {
      AppMethodBeat.i(34839);
      if (Gql == null) {
        Gql = new ag();
      }
      ag localag = Gql;
      AppMethodBeat.o(34839);
      return localag;
    }
    finally {}
  }
  
  @TargetApi(14)
  public static final class a
    implements View.OnHoverListener
  {
    private ag.b Gqm;
    
    public a(ag.b paramb)
    {
      this.Gqm = paramb;
    }
    
    public final boolean onHover(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(34838);
      if (this.Gqm != null)
      {
        boolean bool = this.Gqm.f(paramView, paramMotionEvent);
        AppMethodBeat.o(34838);
        return bool;
      }
      AppMethodBeat.o(34838);
      return false;
    }
  }
  
  public static abstract interface b
  {
    public abstract boolean f(View paramView, MotionEvent paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ag
 * JD-Core Version:    0.7.0.1
 */