package com.tencent.wework.api.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WWMediaConversation
  extends WWMediaMessage.WWMediaObject
{
  public byte[] BCJ;
  public WWMediaMessage.WWMediaObject BCK;
  public String mBI;
  public String name;
  public long qsy;
  
  public final boolean checkArgs()
  {
    AppMethodBeat.i(80497);
    if (!super.checkArgs())
    {
      AppMethodBeat.o(80497);
      return false;
    }
    if ((this.BCJ != null) && (this.BCJ.length > 10485760))
    {
      AppMethodBeat.o(80497);
      return false;
    }
    if ((this.mBI != null) && (this.mBI.length() > 10240))
    {
      AppMethodBeat.o(80497);
      return false;
    }
    if ((this.mBI != null) && (getFileSize(this.mBI) > 10485760))
    {
      AppMethodBeat.o(80497);
      return false;
    }
    if ((this.BCK != null) && (this.BCK.checkArgs()))
    {
      AppMethodBeat.o(80497);
      return true;
    }
    AppMethodBeat.o(80497);
    return false;
  }
  
  public final void toBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(80498);
    super.toBundle(paramBundle);
    paramBundle.putString("_wwconvobject_name", this.name);
    paramBundle.putLong("_wwconvobject_date", this.qsy);
    paramBundle.putByteArray("_wwconvobject_avatarData", this.BCJ);
    paramBundle.putString("_wwconvobject_avatarPath", this.mBI);
    paramBundle.putBundle("_wwconvobject_message", BaseMessage.b(this.BCK));
    AppMethodBeat.o(80498);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.wework.api.model.WWMediaConversation
 * JD-Core Version:    0.7.0.1
 */