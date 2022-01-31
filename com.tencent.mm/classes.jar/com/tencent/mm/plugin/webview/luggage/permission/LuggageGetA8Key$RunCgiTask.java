package com.tencent.mm.plugin.webview.luggage.permission;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.bv.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.h;
import com.tencent.mm.plugin.webview.luggage.ipc.MainProcessTask;
import com.tencent.mm.protocal.c.aao;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;

final class LuggageGetA8Key$RunCgiTask
  extends MainProcessTask
  implements f
{
  public static final Parcelable.Creator<RunCgiTask> CREATOR = new LuggageGetA8Key.RunCgiTask.1();
  int aQw;
  String aox;
  String appId;
  byte[] cbM;
  int errCode;
  int errType;
  int igH;
  aao kMO;
  Runnable kMP;
  h kMQ;
  private byte[] kMR;
  int scene;
  String url;
  String username;
  
  public LuggageGetA8Key$RunCgiTask() {}
  
  public LuggageGetA8Key$RunCgiTask(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, byte[] paramArrayOfByte)
  {
    this.url = paramString1;
    this.username = paramString2;
    this.scene = paramInt1;
    this.aQw = paramInt2;
    this.igH = paramInt3;
    this.appId = paramString3;
    this.cbM = paramArrayOfByte;
    ahC();
  }
  
  public final void Zu()
  {
    this.kMQ = new h(this.url, this.username, this.scene, this.aQw, 0, LuggageGetA8Key.access$100(), this.igH, this.appId, "", 0, this.cbM);
    g.DO().dJT.a(233, this);
    g.DO().dJT.a(this.kMQ, 0);
  }
  
  public final void Zv()
  {
    try
    {
      ahD();
      this.kMO = new aao();
      this.kMO.aH(this.kMR);
      this.kMP.run();
      return;
    }
    catch (IOException localIOException)
    {
      y.printErrStackTrace("MicroMsg.LuggageGetA8Key", localIOException, "", new Object[0]);
    }
  }
  
  public final void e(Parcel paramParcel)
  {
    this.url = paramParcel.readString();
    this.username = paramParcel.readString();
    this.scene = paramParcel.readInt();
    this.aQw = paramParcel.readInt();
    this.igH = paramParcel.readInt();
    this.appId = paramParcel.readString();
    this.cbM = paramParcel.createByteArray();
    this.kMR = paramParcel.createByteArray();
    this.errType = paramParcel.readInt();
    this.errCode = paramParcel.readInt();
    this.aox = paramParcel.readString();
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if (paramm != this.kMQ) {
      return;
    }
    g.DO().dJT.b(233, this);
    this.errType = paramInt1;
    this.errCode = paramInt2;
    this.aox = paramString;
    try
    {
      this.kMR = ((h)paramm).dmK.ecF.ecN.toByteArray();
      label59:
      ahI();
      return;
    }
    catch (Exception paramString)
    {
      break label59;
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.username);
    paramParcel.writeInt(this.scene);
    paramParcel.writeInt(this.aQw);
    paramParcel.writeInt(this.igH);
    paramParcel.writeString(this.appId);
    paramParcel.writeByteArray(this.cbM);
    paramParcel.writeByteArray(this.kMR);
    paramParcel.writeInt(this.errType);
    paramParcel.writeInt(this.errCode);
    paramParcel.writeString(this.aox);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.permission.LuggageGetA8Key.RunCgiTask
 * JD-Core Version:    0.7.0.1
 */