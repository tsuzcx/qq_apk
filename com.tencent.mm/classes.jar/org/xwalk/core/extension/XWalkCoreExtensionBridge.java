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
    AppMethodBeat.i(86161);
    this.mExtension = paramXWalkExternalExtension;
    AppMethodBeat.o(86161);
  }
  
  public void broadcastMessage(String paramString)
  {
    AppMethodBeat.i(86175);
    super.broadcastMessage(paramString);
    AppMethodBeat.o(86175);
  }
  
  public void onBinaryMessage(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(86163);
    this.mExtension.onBinaryMessage(paramInt, paramArrayOfByte);
    AppMethodBeat.o(86163);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(86167);
    this.mExtension.onDestroy();
    AppMethodBeat.o(86167);
  }
  
  public void onInstanceCreated(int paramInt)
  {
    AppMethodBeat.i(86165);
    this.mExtension.onInstanceCreated(paramInt);
    AppMethodBeat.o(86165);
  }
  
  public void onInstanceDestroyed(int paramInt)
  {
    AppMethodBeat.i(86166);
    this.mExtension.onInstanceDestroyed(paramInt);
    AppMethodBeat.o(86166);
  }
  
  public void onMessage(int paramInt, String paramString)
  {
    AppMethodBeat.i(86162);
    this.mExtension.onMessage(paramInt, paramString);
    AppMethodBeat.o(86162);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(86172);
    this.mExtension.onNewIntent(paramIntent);
    AppMethodBeat.o(86172);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(86169);
    this.mExtension.onPause();
    AppMethodBeat.o(86169);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(86168);
    this.mExtension.onResume();
    AppMethodBeat.o(86168);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(86170);
    this.mExtension.onStart();
    AppMethodBeat.o(86170);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(86171);
    this.mExtension.onStop();
    AppMethodBeat.o(86171);
  }
  
  public String onSyncMessage(int paramInt, String paramString)
  {
    AppMethodBeat.i(86164);
    paramString = this.mExtension.onSyncMessage(paramInt, paramString);
    AppMethodBeat.o(86164);
    return paramString;
  }
  
  public void postBinaryMessage(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(86174);
    super.postBinaryMessage(paramInt, paramArrayOfByte);
    AppMethodBeat.o(86174);
  }
  
  public void postMessage(int paramInt, String paramString)
  {
    AppMethodBeat.i(86173);
    super.postMessage(paramInt, paramString);
    AppMethodBeat.o(86173);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.xwalk.core.extension.XWalkCoreExtensionBridge
 * JD-Core Version:    0.7.0.1
 */