package com.tencent.wework.api.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WWMediaConversation
  extends WWMediaMessage.WWMediaObject
{
  public byte[] ILX;
  public WWMediaMessage.WWMediaObject ILY;
  public String name;
  public String qjl;
  public long vJM;
  
  public final boolean checkArgs()
  {
    AppMethodBeat.i(106538);
    if (!super.checkArgs())
    {
      AppMethodBeat.o(106538);
      return false;
    }
    if ((this.ILX != null) && (this.ILX.length > 10485760))
    {
      AppMethodBeat.o(106538);
      return false;
    }
    if ((this.qjl != null) && (this.qjl.length() > 10240))
    {
      AppMethodBeat.o(106538);
      return false;
    }
    if ((this.qjl != null) && (getFileSize(this.qjl) > 10485760))
    {
      AppMethodBeat.o(106538);
      return false;
    }
    if ((this.ILY != null) && (this.ILY.checkArgs()))
    {
      AppMethodBeat.o(106538);
      return true;
    }
    AppMethodBeat.o(106538);
    return false;
  }
  
  public final void toBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(106539);
    super.toBundle(paramBundle);
    paramBundle.putString("_wwconvobject_name", this.name);
    paramBundle.putLong("_wwconvobject_date", this.vJM);
    paramBundle.putByteArray("_wwconvobject_avatarData", this.ILX);
    paramBundle.putString("_wwconvobject_avatarPath", this.qjl);
    paramBundle.putBundle("_wwconvobject_message", BaseMessage.b(this.ILY));
    AppMethodBeat.o(106539);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.wework.api.model.WWMediaConversation
 * JD-Core Version:    0.7.0.1
 */