package com.tencent.wework.api.model;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WWMediaConversation
  extends WWMediaMessage.WWMediaObject
{
  public byte[] Sxt;
  public WWMediaMessage.WWMediaObject Sxu;
  public String name;
  public long sJT;
  public String tjJ;
  
  public final void brA(String paramString)
  {
    AppMethodBeat.i(199003);
    super.brA(paramString);
    try
    {
      this.Sxu.brA(paramString);
      AppMethodBeat.o(199003);
      return;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(199003);
    }
  }
  
  public final boolean checkArgs()
  {
    AppMethodBeat.i(106538);
    if (!super.checkArgs())
    {
      AppMethodBeat.o(106538);
      return false;
    }
    if ((this.Sxt != null) && (this.Sxt.length > 10485760))
    {
      AppMethodBeat.o(106538);
      return false;
    }
    if ((this.tjJ != null) && (this.tjJ.length() > 10240))
    {
      AppMethodBeat.o(106538);
      return false;
    }
    if ((this.tjJ != null) && (getFileSize(this.tjJ) > 10485760))
    {
      AppMethodBeat.o(106538);
      return false;
    }
    if ((this.Sxu != null) && (this.Sxu.checkArgs()))
    {
      AppMethodBeat.o(106538);
      return true;
    }
    AppMethodBeat.o(106538);
    return false;
  }
  
  public final void fromBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(199001);
    super.fromBundle(paramBundle);
    this.name = paramBundle.getString("_wwconvobject_name");
    this.sJT = paramBundle.getLong("_wwconvobject_date");
    this.Sxt = paramBundle.getByteArray("_wwconvobject_avatarData");
    this.tjJ = paramBundle.getString("_wwconvobject_avatarPath");
    try
    {
      this.Sxu = ((WWMediaMessage.WWMediaObject)BaseMessage.bB(paramBundle.getBundle("_wwconvobject_message")));
      AppMethodBeat.o(199001);
      return;
    }
    catch (Throwable paramBundle)
    {
      AppMethodBeat.o(199001);
    }
  }
  
  public final void setContext(Context paramContext)
  {
    AppMethodBeat.i(199004);
    super.setContext(paramContext);
    try
    {
      this.Sxu.setContext(paramContext);
      AppMethodBeat.o(199004);
      return;
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(199004);
    }
  }
  
  public final void toBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(106539);
    super.toBundle(paramBundle);
    paramBundle.putString("_wwconvobject_name", this.name);
    paramBundle.putLong("_wwconvobject_date", this.sJT);
    paramBundle.putByteArray("_wwconvobject_avatarData", this.Sxt);
    paramBundle.putString("_wwconvobject_avatarPath", this.tjJ);
    paramBundle.putBundle("_wwconvobject_message", BaseMessage.a(this.Sxu));
    AppMethodBeat.o(106539);
  }
  
  public final void v(Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(199002);
    try
    {
      this.Sxu.v(paramIntent, paramString);
      AppMethodBeat.o(199002);
      return;
    }
    catch (Throwable paramIntent)
    {
      AppMethodBeat.o(199002);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.wework.api.model.WWMediaConversation
 * JD-Core Version:    0.7.0.1
 */