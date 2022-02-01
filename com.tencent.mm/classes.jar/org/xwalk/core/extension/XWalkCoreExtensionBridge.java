package org.xwalk.core.extension;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.XWalkExtension;

class XWalkCoreExtensionBridge
  extends XWalkExtension
  implements XWalkExternalExtensionBridge
{
  private XWalkExternalExtension mExtension;
  
  public XWalkCoreExtensionBridge(XWalkExternalExtension paramXWalkExternalExtension)
  {
    super(paramXWalkExternalExtension.getExtensionName(), paramXWalkExternalExtension.getJsApi(), paramXWalkExternalExtension.getEntryPoints());
    AppMethodBeat.i(155275);
    this.mExtension = paramXWalkExternalExtension;
    AppMethodBeat.o(155275);
  }
  
  public void broadcastMessage(String paramString)
  {
    AppMethodBeat.i(155289);
    super.broadcastMessage(paramString);
    AppMethodBeat.o(155289);
  }
  
  public void onBinaryMessage(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(155277);
    this.mExtension.onBinaryMessage(paramInt, paramArrayOfByte);
    AppMethodBeat.o(155277);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(155281);
    this.mExtension.onDestroy();
    AppMethodBeat.o(155281);
  }
  
  public void onInstanceCreated(int paramInt)
  {
    AppMethodBeat.i(155279);
    this.mExtension.onInstanceCreated(paramInt);
    AppMethodBeat.o(155279);
  }
  
  public void onInstanceDestroyed(int paramInt)
  {
    AppMethodBeat.i(155280);
    this.mExtension.onInstanceDestroyed(paramInt);
    AppMethodBeat.o(155280);
  }
  
  public void onMessage(int paramInt, String paramString)
  {
    AppMethodBeat.i(155276);
    this.mExtension.onMessage(paramInt, paramString);
    AppMethodBeat.o(155276);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(155286);
    this.mExtension.onNewIntent(paramIntent);
    AppMethodBeat.o(155286);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(155283);
    this.mExtension.onPause();
    AppMethodBeat.o(155283);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(155282);
    this.mExtension.onResume();
    AppMethodBeat.o(155282);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(155284);
    this.mExtension.onStart();
    AppMethodBeat.o(155284);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(155285);
    this.mExtension.onStop();
    AppMethodBeat.o(155285);
  }
  
  public String onSyncMessage(int paramInt, String paramString)
  {
    AppMethodBeat.i(155278);
    paramString = this.mExtension.onSyncMessage(paramInt, paramString);
    AppMethodBeat.o(155278);
    return paramString;
  }
  
  public void postBinaryMessage(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(155288);
    super.postBinaryMessage(paramInt, paramArrayOfByte);
    AppMethodBeat.o(155288);
  }
  
  public void postMessage(int paramInt, String paramString)
  {
    AppMethodBeat.i(155287);
    super.postMessage(paramInt, paramString);
    AppMethodBeat.o(155287);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.xwalk.core.extension.XWalkCoreExtensionBridge
 * JD-Core Version:    0.7.0.1
 */