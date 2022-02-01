package com.tencent.wework.api.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WWMediaConversation
  extends WWMediaMessage.WWMediaObject
{
  public byte[] MLp;
  public WWMediaMessage.WWMediaObject MLq;
  public String name;
  public String rJY;
  public long riq;
  
  public final boolean checkArgs()
  {
    AppMethodBeat.i(106538);
    if (!super.checkArgs())
    {
      AppMethodBeat.o(106538);
      return false;
    }
    if ((this.MLp != null) && (this.MLp.length > 10485760))
    {
      AppMethodBeat.o(106538);
      return false;
    }
    if ((this.rJY != null) && (this.rJY.length() > 10240))
    {
      AppMethodBeat.o(106538);
      return false;
    }
    if ((this.rJY != null) && (getFileSize(this.rJY) > 10485760))
    {
      AppMethodBeat.o(106538);
      return false;
    }
    if ((this.MLq != null) && (this.MLq.checkArgs()))
    {
      AppMethodBeat.o(106538);
      return true;
    }
    AppMethodBeat.o(106538);
    return false;
  }
  
  public final void fromBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(193327);
    super.fromBundle(paramBundle);
    this.name = paramBundle.getString("_wwconvobject_name");
    this.riq = paramBundle.getLong("_wwconvobject_date");
    this.MLp = paramBundle.getByteArray("_wwconvobject_avatarData");
    this.rJY = paramBundle.getString("_wwconvobject_avatarPath");
    try
    {
      this.MLq = ((WWMediaMessage.WWMediaObject)BaseMessage.bo(paramBundle.getBundle("_wwconvobject_message")));
      AppMethodBeat.o(193327);
      return;
    }
    catch (Throwable paramBundle)
    {
      AppMethodBeat.o(193327);
    }
  }
  
  public final void toBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(106539);
    super.toBundle(paramBundle);
    paramBundle.putString("_wwconvobject_name", this.name);
    paramBundle.putLong("_wwconvobject_date", this.riq);
    paramBundle.putByteArray("_wwconvobject_avatarData", this.MLp);
    paramBundle.putString("_wwconvobject_avatarPath", this.rJY);
    paramBundle.putBundle("_wwconvobject_message", BaseMessage.b(this.MLq));
    AppMethodBeat.o(106539);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.wework.api.model.WWMediaConversation
 * JD-Core Version:    0.7.0.1
 */