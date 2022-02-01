package com.tencent.wework.api.model;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WWMediaConversation
  extends WWMediaMessage.WWMediaObject
{
  public String AmC;
  public byte[] aicW;
  public WWMediaMessage.WWMediaObject aicX;
  public String name;
  public long zLU;
  
  public final void bGY(String paramString)
  {
    AppMethodBeat.i(210659);
    super.bGY(paramString);
    try
    {
      this.aicX.bGY(paramString);
      return;
    }
    finally
    {
      AppMethodBeat.o(210659);
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
    if ((this.aicW != null) && (this.aicW.length > 10485760))
    {
      AppMethodBeat.o(106538);
      return false;
    }
    if ((this.AmC != null) && (this.AmC.length() > 10240))
    {
      AppMethodBeat.o(106538);
      return false;
    }
    if ((this.AmC != null) && (getFileSize(this.AmC) > 10485760))
    {
      AppMethodBeat.o(106538);
      return false;
    }
    if ((this.aicX != null) && (this.aicX.checkArgs()))
    {
      AppMethodBeat.o(106538);
      return true;
    }
    AppMethodBeat.o(106538);
    return false;
  }
  
  public final void fromBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(210645);
    super.fromBundle(paramBundle);
    this.name = paramBundle.getString("_wwconvobject_name");
    this.zLU = paramBundle.getLong("_wwconvobject_date");
    this.aicW = paramBundle.getByteArray("_wwconvobject_avatarData");
    this.AmC = paramBundle.getString("_wwconvobject_avatarPath");
    try
    {
      this.aicX = ((WWMediaMessage.WWMediaObject)BaseMessage.ch(paramBundle.getBundle("_wwconvobject_message")));
      return;
    }
    finally
    {
      AppMethodBeat.o(210645);
    }
  }
  
  public final void setContext(Context paramContext)
  {
    AppMethodBeat.i(210665);
    super.setContext(paramContext);
    try
    {
      this.aicX.setContext(paramContext);
      return;
    }
    finally
    {
      AppMethodBeat.o(210665);
    }
  }
  
  public final void toBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(106539);
    super.toBundle(paramBundle);
    paramBundle.putString("_wwconvobject_name", this.name);
    paramBundle.putLong("_wwconvobject_date", this.zLU);
    paramBundle.putByteArray("_wwconvobject_avatarData", this.aicW);
    paramBundle.putString("_wwconvobject_avatarPath", this.AmC);
    paramBundle.putBundle("_wwconvobject_message", BaseMessage.a(this.aicX));
    AppMethodBeat.o(106539);
  }
  
  public final void w(Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(210654);
    try
    {
      this.aicX.w(paramIntent, paramString);
      return;
    }
    finally
    {
      AppMethodBeat.o(210654);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.wework.api.model.WWMediaConversation
 * JD-Core Version:    0.7.0.1
 */