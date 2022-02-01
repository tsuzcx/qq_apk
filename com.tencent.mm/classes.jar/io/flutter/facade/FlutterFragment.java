package io.flutter.facade;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class FlutterFragment
  extends Fragment
{
  private String MFH = "/";
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(159077);
    super.onCreate(paramBundle);
    if (getArguments() != null) {
      this.MFH = getArguments().getString("route");
    }
    AppMethodBeat.o(159077);
  }
  
  public void onInflate(Context paramContext, AttributeSet paramAttributeSet, Bundle paramBundle)
  {
    AppMethodBeat.i(159078);
    super.onInflate(paramContext, paramAttributeSet, paramBundle);
    AppMethodBeat.o(159078);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.facade.FlutterFragment
 * JD-Core Version:    0.7.0.1
 */