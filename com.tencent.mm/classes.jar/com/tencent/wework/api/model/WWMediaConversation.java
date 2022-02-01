package com.tencent.wework.api.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WWMediaConversation
  extends WWMediaMessage.WWMediaObject
{
  public byte[] Kyp;
  public WWMediaMessage.WWMediaObject Kyq;
  public String name;
  public String qRN;
  public long wTQ;
  
  public final boolean checkArgs()
  {
    AppMethodBeat.i(106538);
    if (!super.checkArgs())
    {
      AppMethodBeat.o(106538);
      return false;
    }
    if ((this.Kyp != null) && (this.Kyp.length > 10485760))
    {
      AppMethodBeat.o(106538);
      return false;
    }
    if ((this.qRN != null) && (this.qRN.length() > 10240))
    {
      AppMethodBeat.o(106538);
      return false;
    }
    if ((this.qRN != null) && (getFileSize(this.qRN) > 10485760))
    {
      AppMethodBeat.o(106538);
      return false;
    }
    if ((this.Kyq != null) && (this.Kyq.checkArgs()))
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
    paramBundle.putLong("_wwconvobject_date", this.wTQ);
    paramBundle.putByteArray("_wwconvobject_avatarData", this.Kyp);
    paramBundle.putString("_wwconvobject_avatarPath", this.qRN);
    paramBundle.putBundle("_wwconvobject_message", BaseMessage.b(this.Kyq));
    AppMethodBeat.o(106539);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.wework.api.model.WWMediaConversation
 * JD-Core Version:    0.7.0.1
 */