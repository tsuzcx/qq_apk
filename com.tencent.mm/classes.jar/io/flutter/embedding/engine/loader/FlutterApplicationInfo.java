package io.flutter.embedding.engine.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class FlutterApplicationInfo
{
  private static final String DEFAULT_AOT_SHARED_LIBRARY_NAME = "libapp.so";
  private static final String DEFAULT_FLUTTER_ASSETS_DIR = "flutter_assets";
  private static final String DEFAULT_ISOLATE_SNAPSHOT_DATA = "isolate_snapshot_data";
  private static final String DEFAULT_VM_SNAPSHOT_DATA = "vm_snapshot_data";
  public final String aotSharedLibraryName;
  public final boolean clearTextPermitted;
  public final String domainNetworkPolicy;
  public final String flutterAssetsDir;
  public final String isolateSnapshotData;
  public final String nativeLibraryDir;
  public final String vmSnapshotData;
  
  public FlutterApplicationInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, boolean paramBoolean)
  {
    AppMethodBeat.i(190084);
    String str = paramString1;
    if (paramString1 == null) {
      str = "libapp.so";
    }
    this.aotSharedLibraryName = str;
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "vm_snapshot_data";
    }
    this.vmSnapshotData = paramString1;
    paramString1 = paramString3;
    if (paramString3 == null) {
      paramString1 = "isolate_snapshot_data";
    }
    this.isolateSnapshotData = paramString1;
    paramString1 = paramString4;
    if (paramString4 == null) {
      paramString1 = "flutter_assets";
    }
    this.flutterAssetsDir = paramString1;
    this.nativeLibraryDir = paramString6;
    paramString1 = paramString5;
    if (paramString5 == null) {
      paramString1 = "";
    }
    this.domainNetworkPolicy = paramString1;
    this.clearTextPermitted = paramBoolean;
    AppMethodBeat.o(190084);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.embedding.engine.loader.FlutterApplicationInfo
 * JD-Core Version:    0.7.0.1
 */