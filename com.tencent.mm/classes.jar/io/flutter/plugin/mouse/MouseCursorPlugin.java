package io.flutter.plugin.mouse;

import android.view.PointerIcon;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.systemchannels.MouseCursorChannel;
import io.flutter.embedding.engine.systemchannels.MouseCursorChannel.MouseCursorMethodHandler;
import java.util.HashMap;

public class MouseCursorPlugin
{
  private static HashMap<String, Integer> systemCursorConstants;
  private final MouseCursorViewDelegate mView;
  private final MouseCursorChannel mouseCursorChannel;
  
  public MouseCursorPlugin(MouseCursorViewDelegate paramMouseCursorViewDelegate, MouseCursorChannel paramMouseCursorChannel)
  {
    AppMethodBeat.i(189727);
    this.mView = paramMouseCursorViewDelegate;
    this.mouseCursorChannel = paramMouseCursorChannel;
    paramMouseCursorChannel.setMethodHandler(new MouseCursorChannel.MouseCursorMethodHandler()
    {
      public void activateSystemCursor(String paramAnonymousString)
      {
        AppMethodBeat.i(189732);
        MouseCursorPlugin.this.mView.setPointerIcon(MouseCursorPlugin.access$000(MouseCursorPlugin.this, paramAnonymousString));
        AppMethodBeat.o(189732);
      }
    });
    AppMethodBeat.o(189727);
  }
  
  private PointerIcon resolveSystemCursor(String paramString)
  {
    AppMethodBeat.i(189736);
    if (systemCursorConstants == null) {
      systemCursorConstants = new HashMap()
      {
        private static final long serialVersionUID = 1L;
      };
    }
    int i = ((Integer)systemCursorConstants.getOrDefault(paramString, Integer.valueOf(1000))).intValue();
    paramString = this.mView.getSystemPointerIcon(i);
    AppMethodBeat.o(189736);
    return paramString;
  }
  
  public void destroy()
  {
    AppMethodBeat.i(189763);
    this.mouseCursorChannel.setMethodHandler(null);
    AppMethodBeat.o(189763);
  }
  
  public static abstract interface MouseCursorViewDelegate
  {
    public abstract PointerIcon getSystemPointerIcon(int paramInt);
    
    public abstract void setPointerIcon(PointerIcon paramPointerIcon);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.plugin.mouse.MouseCursorPlugin
 * JD-Core Version:    0.7.0.1
 */