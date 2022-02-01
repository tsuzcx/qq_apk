package io.flutter.plugin.platform;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

class PlatformViewRegistryImpl
  implements PlatformViewRegistry
{
  private final Map<String, PlatformViewFactory> viewFactories;
  
  PlatformViewRegistryImpl()
  {
    AppMethodBeat.i(9893);
    this.viewFactories = new HashMap();
    AppMethodBeat.o(9893);
  }
  
  PlatformViewFactory getFactory(String paramString)
  {
    AppMethodBeat.i(189944);
    paramString = (PlatformViewFactory)this.viewFactories.get(paramString);
    AppMethodBeat.o(189944);
    return paramString;
  }
  
  public boolean registerViewFactory(String paramString, PlatformViewFactory paramPlatformViewFactory)
  {
    AppMethodBeat.i(189940);
    if (this.viewFactories.containsKey(paramString))
    {
      AppMethodBeat.o(189940);
      return false;
    }
    this.viewFactories.put(paramString, paramPlatformViewFactory);
    AppMethodBeat.o(189940);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.plugin.platform.PlatformViewRegistryImpl
 * JD-Core Version:    0.7.0.1
 */