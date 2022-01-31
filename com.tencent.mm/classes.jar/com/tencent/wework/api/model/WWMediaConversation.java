package com.tencent.wework.api.model;

import android.os.Bundle;

public class WWMediaConversation
  extends WWMediaMessage.WWMediaObject
{
  public String kgT;
  public long nFv;
  public String name;
  public byte[] xgc;
  public WWMediaMessage.WWMediaObject xgd;
  
  public final boolean checkArgs()
  {
    if (!super.checkArgs()) {}
    while (((this.xgc != null) && (this.xgc.length > 10485760)) || ((this.kgT != null) && (this.kgT.length() > 10240)) || ((this.kgT != null) && (getFileSize(this.kgT) > 10485760)) || (this.xgd == null) || (!this.xgd.checkArgs())) {
      return false;
    }
    return true;
  }
  
  public final void toBundle(Bundle paramBundle)
  {
    super.toBundle(paramBundle);
    paramBundle.putString("_wwconvobject_name", this.name);
    paramBundle.putLong("_wwconvobject_date", this.nFv);
    paramBundle.putByteArray("_wwconvobject_avatarData", this.xgc);
    paramBundle.putString("_wwconvobject_avatarPath", this.kgT);
    paramBundle.putBundle("_wwconvobject_message", BaseMessage.b(this.xgd));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.wework.api.model.WWMediaConversation
 * JD-Core Version:    0.7.0.1
 */