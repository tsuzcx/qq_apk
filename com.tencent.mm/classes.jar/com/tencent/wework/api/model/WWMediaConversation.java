package com.tencent.wework.api.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WWMediaConversation
  extends WWMediaMessage.WWMediaObject
{
  public byte[] Mot;
  public WWMediaMessage.WWMediaObject Mou;
  public String name;
  public String rBN;
  public long rak;
  
  public final boolean checkArgs()
  {
    AppMethodBeat.i(106538);
    if (!super.checkArgs())
    {
      AppMethodBeat.o(106538);
      return false;
    }
    if ((this.Mot != null) && (this.Mot.length > 10485760))
    {
      AppMethodBeat.o(106538);
      return false;
    }
    if ((this.rBN != null) && (this.rBN.length() > 10240))
    {
      AppMethodBeat.o(106538);
      return false;
    }
    if ((this.rBN != null) && (getFileSize(this.rBN) > 10485760))
    {
      AppMethodBeat.o(106538);
      return false;
    }
    if ((this.Mou != null) && (this.Mou.checkArgs()))
    {
      AppMethodBeat.o(106538);
      return true;
    }
    AppMethodBeat.o(106538);
    return false;
  }
  
  public final void fromBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(190355);
    super.fromBundle(paramBundle);
    this.name = paramBundle.getString("_wwconvobject_name");
    this.rak = paramBundle.getLong("_wwconvobject_date");
    this.Mot = paramBundle.getByteArray("_wwconvobject_avatarData");
    this.rBN = paramBundle.getString("_wwconvobject_avatarPath");
    try
    {
      this.Mou = ((WWMediaMessage.WWMediaObject)BaseMessage.bn(paramBundle.getBundle("_wwconvobject_message")));
      AppMethodBeat.o(190355);
      return;
    }
    catch (Throwable paramBundle)
    {
      AppMethodBeat.o(190355);
    }
  }
  
  public final void toBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(106539);
    super.toBundle(paramBundle);
    paramBundle.putString("_wwconvobject_name", this.name);
    paramBundle.putLong("_wwconvobject_date", this.rak);
    paramBundle.putByteArray("_wwconvobject_avatarData", this.Mot);
    paramBundle.putString("_wwconvobject_avatarPath", this.rBN);
    paramBundle.putBundle("_wwconvobject_message", BaseMessage.b(this.Mou));
    AppMethodBeat.o(106539);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.wework.api.model.WWMediaConversation
 * JD-Core Version:    0.7.0.1
 */