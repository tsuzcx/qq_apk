package com.tencent.mm.plugin.webview.luggage.permission;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.bv.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.j;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.protocal.protobuf.afg;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;

final class LuggageGetA8Key$RunCgiTask
  extends MainProcessTask
  implements f
{
  public static final Parcelable.Creator<RunCgiTask> CREATOR;
  int aXG;
  String appId;
  byte[] cKp;
  int cnU;
  int errCode;
  String errMsg;
  int errType;
  int scene;
  afg uUI;
  Runnable uUJ;
  j uUK;
  private byte[] uUL;
  String url;
  String username;
  
  static
  {
    AppMethodBeat.i(6466);
    CREATOR = new LuggageGetA8Key.RunCgiTask.1();
    AppMethodBeat.o(6466);
  }
  
  public LuggageGetA8Key$RunCgiTask() {}
  
  public LuggageGetA8Key$RunCgiTask(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(6460);
    this.url = paramString1;
    this.username = paramString2;
    this.scene = paramInt1;
    this.aXG = paramInt2;
    this.cnU = paramInt3;
    this.appId = paramString3;
    this.cKp = paramArrayOfByte;
    aBj();
    AppMethodBeat.o(6460);
  }
  
  public final void ata()
  {
    AppMethodBeat.i(6461);
    ab.i("MicroMsg.LuggageGetA8Key.RunCgiTask", "start, url: %s", new Object[] { this.url });
    this.uUK = new j(this.url, this.username, this.scene, this.aXG, 0, LuggageGetA8Key.access$200(), this.cnU, this.appId, "", 0, this.cKp);
    g.RK().eHt.a(233, this);
    g.RK().eHt.a(this.uUK, 0);
    AppMethodBeat.o(6461);
  }
  
  public final void atb()
  {
    AppMethodBeat.i(6463);
    ab.i("MicroMsg.LuggageGetA8Key.RunCgiTask", "runInClientProcess: %s", new Object[] { this.url });
    try
    {
      aBk();
      if (this.uUL != null)
      {
        this.uUI = new afg();
        this.uUI.parseFrom(this.uUL);
      }
      this.uUJ.run();
      AppMethodBeat.o(6463);
      return;
    }
    catch (IOException localIOException)
    {
      ab.printErrStackTrace("MicroMsg.LuggageGetA8Key.RunCgiTask", localIOException, "", new Object[0]);
      AppMethodBeat.o(6463);
    }
  }
  
  public final void f(Parcel paramParcel)
  {
    AppMethodBeat.i(6464);
    this.url = paramParcel.readString();
    this.username = paramParcel.readString();
    this.scene = paramParcel.readInt();
    this.aXG = paramParcel.readInt();
    this.cnU = paramParcel.readInt();
    this.appId = paramParcel.readString();
    this.cKp = paramParcel.createByteArray();
    this.uUL = paramParcel.createByteArray();
    this.errType = paramParcel.readInt();
    this.errCode = paramParcel.readInt();
    this.errMsg = paramParcel.readString();
    AppMethodBeat.o(6464);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(6462);
    if (paramm != this.uUK)
    {
      AppMethodBeat.o(6462);
      return;
    }
    ab.i("MicroMsg.LuggageGetA8Key.RunCgiTask", "onSceneEnd, url: %s", new Object[] { this.url });
    g.RK().eHt.b(233, this);
    this.errType = paramInt1;
    this.errCode = paramInt2;
    this.errMsg = paramString;
    try
    {
      this.uUL = ((j)paramm).rr.fsW.fta.toByteArray();
      label89:
      aBp();
      AppMethodBeat.o(6462);
      return;
    }
    catch (Exception paramString)
    {
      break label89;
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(6465);
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.username);
    paramParcel.writeInt(this.scene);
    paramParcel.writeInt(this.aXG);
    paramParcel.writeInt(this.cnU);
    paramParcel.writeString(this.appId);
    paramParcel.writeByteArray(this.cKp);
    paramParcel.writeByteArray(this.uUL);
    paramParcel.writeInt(this.errType);
    paramParcel.writeInt(this.errCode);
    paramParcel.writeString(this.errMsg);
    AppMethodBeat.o(6465);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.permission.LuggageGetA8Key.RunCgiTask
 * JD-Core Version:    0.7.0.1
 */