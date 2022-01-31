package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class nd
  extends ListView
{
  private nd.a a;
  
  public nd(Context paramContext)
  {
    super(paramContext);
  }
  
  protected void handleDataChanged()
  {
    AppMethodBeat.i(149397);
    super.handleDataChanged();
    if (this.a != null) {
      this.a.c();
    }
    AppMethodBeat.o(149397);
  }
  
  public void setOnDataChangedListener(nd.a parama)
  {
    this.a = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.nd
 * JD-Core Version:    0.7.0.1
 */