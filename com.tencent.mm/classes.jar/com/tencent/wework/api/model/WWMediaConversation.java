package com.tencent.wework.api.model;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WWMediaConversation
  extends WWMediaMessage.WWMediaObject
{
  public byte[] ZYt;
  public WWMediaMessage.WWMediaObject ZYu;
  public String name;
  public String wQa;
  public long wpR;
  
  public final void bEz(String paramString)
  {
    AppMethodBeat.i(233357);
    super.bEz(paramString);
    try
    {
      this.ZYu.bEz(paramString);
      AppMethodBeat.o(233357);
      return;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(233357);
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
    if ((this.ZYt != null) && (this.ZYt.length > 10485760))
    {
      AppMethodBeat.o(106538);
      return false;
    }
    if ((this.wQa != null) && (this.wQa.length() > 10240))
    {
      AppMethodBeat.o(106538);
      return false;
    }
    if ((this.wQa != null) && (getFileSize(this.wQa) > 10485760))
    {
      AppMethodBeat.o(106538);
      return false;
    }
    if ((this.ZYu != null) && (this.ZYu.checkArgs()))
    {
      AppMethodBeat.o(106538);
      return true;
    }
    AppMethodBeat.o(106538);
    return false;
  }
  
  public final void fromBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(233350);
    super.fromBundle(paramBundle);
    this.name = paramBundle.getString("_wwconvobject_name");
    this.wpR = paramBundle.getLong("_wwconvobject_date");
    this.ZYt = paramBundle.getByteArray("_wwconvobject_avatarData");
    this.wQa = paramBundle.getString("_wwconvobject_avatarPath");
    try
    {
      this.ZYu = ((WWMediaMessage.WWMediaObject)BaseMessage.by(paramBundle.getBundle("_wwconvobject_message")));
      AppMethodBeat.o(233350);
      return;
    }
    catch (Throwable paramBundle)
    {
      AppMethodBeat.o(233350);
    }
  }
  
  public final void setContext(Context paramContext)
  {
    AppMethodBeat.i(233359);
    super.setContext(paramContext);
    try
    {
      this.ZYu.setContext(paramContext);
      AppMethodBeat.o(233359);
      return;
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(233359);
    }
  }
  
  public final void toBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(106539);
    super.toBundle(paramBundle);
    paramBundle.putString("_wwconvobject_name", this.name);
    paramBundle.putLong("_wwconvobject_date", this.wpR);
    paramBundle.putByteArray("_wwconvobject_avatarData", this.ZYt);
    paramBundle.putString("_wwconvobject_avatarPath", this.wQa);
    paramBundle.putBundle("_wwconvobject_message", BaseMessage.a(this.ZYu));
    AppMethodBeat.o(106539);
  }
  
  public final void u(Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(233354);
    try
    {
      this.ZYu.u(paramIntent, paramString);
      AppMethodBeat.o(233354);
      return;
    }
    catch (Throwable paramIntent)
    {
      AppMethodBeat.o(233354);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.wework.api.model.WWMediaConversation
 * JD-Core Version:    0.7.0.1
 */