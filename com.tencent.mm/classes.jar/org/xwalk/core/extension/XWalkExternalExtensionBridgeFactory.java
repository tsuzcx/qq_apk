package org.xwalk.core.extension;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class XWalkExternalExtensionBridgeFactory
{
  public static XWalkExternalExtensionBridge createInstance(XWalkExternalExtension paramXWalkExternalExtension)
  {
    AppMethodBeat.i(86190);
    paramXWalkExternalExtension = new XWalkCoreExtensionBridge(paramXWalkExternalExtension);
    AppMethodBeat.o(86190);
    return paramXWalkExternalExtension;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     org.xwalk.core.extension.XWalkExternalExtensionBridgeFactory
 * JD-Core Version:    0.7.0.1
 */