package io.flutter.embedding.engine;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.loader.FlutterLoader;
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterAssets;

class FlutterEngineConnectionRegistry$DefaultFlutterAssets
  implements FlutterPlugin.FlutterAssets
{
  final FlutterLoader flutterLoader;
  
  private FlutterEngineConnectionRegistry$DefaultFlutterAssets(FlutterLoader paramFlutterLoader)
  {
    this.flutterLoader = paramFlutterLoader;
  }
  
  public String getAssetFilePathByName(String paramString)
  {
    AppMethodBeat.i(189992);
    paramString = this.flutterLoader.getLookupKeyForAsset(paramString);
    AppMethodBeat.o(189992);
    return paramString;
  }
  
  public String getAssetFilePathByName(String paramString1, String paramString2)
  {
    AppMethodBeat.i(190002);
    paramString1 = this.flutterLoader.getLookupKeyForAsset(paramString1, paramString2);
    AppMethodBeat.o(190002);
    return paramString1;
  }
  
  public String getAssetFilePathBySubpath(String paramString)
  {
    AppMethodBeat.i(190013);
    paramString = this.flutterLoader.getLookupKeyForAsset(paramString);
    AppMethodBeat.o(190013);
    return paramString;
  }
  
  public String getAssetFilePathBySubpath(String paramString1, String paramString2)
  {
    AppMethodBeat.i(190023);
    paramString1 = this.flutterLoader.getLookupKeyForAsset(paramString1, paramString2);
    AppMethodBeat.o(190023);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.embedding.engine.FlutterEngineConnectionRegistry.DefaultFlutterAssets
 * JD-Core Version:    0.7.0.1
 */