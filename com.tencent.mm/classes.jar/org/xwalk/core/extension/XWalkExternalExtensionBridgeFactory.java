package org.xwalk.core.extension;

final class XWalkExternalExtensionBridgeFactory
{
  public static XWalkExternalExtensionBridge createInstance(XWalkExternalExtension paramXWalkExternalExtension)
  {
    return new XWalkCoreExtensionBridge(paramXWalkExternalExtension);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.xwalk.core.extension.XWalkExternalExtensionBridgeFactory
 * JD-Core Version:    0.7.0.1
 */