package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import org.json.JSONObject;

public class kc
  extends com.tencent.mm.bx.a
{
  public int IJG;
  public b YMp;
  public b YMq;
  public int YMr;
  public b YMs;
  public int yth;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(260086);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "SessionKey", this.YMp, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Uin", Integer.valueOf(this.yth), false);
      com.tencent.mm.bk.a.a(localJSONObject, "DeviceID", this.YMq, false);
      com.tencent.mm.bk.a.a(localJSONObject, "ClientVersion", Integer.valueOf(this.YMr), false);
      com.tencent.mm.bk.a.a(localJSONObject, "DeviceType", this.YMs, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Scene", Integer.valueOf(this.IJG), false);
      label88:
      AppMethodBeat.o(260086);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label88;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133156);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YMp != null) {
        paramVarArgs.d(1, this.YMp);
      }
      paramVarArgs.bS(2, this.yth);
      if (this.YMq != null) {
        paramVarArgs.d(3, this.YMq);
      }
      paramVarArgs.bS(4, this.YMr);
      if (this.YMs != null) {
        paramVarArgs.d(5, this.YMs);
      }
      paramVarArgs.bS(6, this.IJG);
      AppMethodBeat.o(133156);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YMp == null) {
        break label466;
      }
    }
    label466:
    for (paramInt = i.a.a.b.b.a.c(1, this.YMp) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.yth);
      paramInt = i;
      if (this.YMq != null) {
        paramInt = i + i.a.a.b.b.a.c(3, this.YMq);
      }
      i = paramInt + i.a.a.b.b.a.cJ(4, this.YMr);
      paramInt = i;
      if (this.YMs != null) {
        paramInt = i + i.a.a.b.b.a.c(5, this.YMs);
      }
      i = i.a.a.b.b.a.cJ(6, this.IJG);
      AppMethodBeat.o(133156);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(133156);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        kc localkc = (kc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(133156);
          return -1;
        case 1: 
          localkc.YMp = locala.ajGk.kFX();
          AppMethodBeat.o(133156);
          return 0;
        case 2: 
          localkc.yth = locala.ajGk.aar();
          AppMethodBeat.o(133156);
          return 0;
        case 3: 
          localkc.YMq = locala.ajGk.kFX();
          AppMethodBeat.o(133156);
          return 0;
        case 4: 
          localkc.YMr = locala.ajGk.aar();
          AppMethodBeat.o(133156);
          return 0;
        case 5: 
          localkc.YMs = locala.ajGk.kFX();
          AppMethodBeat.o(133156);
          return 0;
        }
        localkc.IJG = locala.ajGk.aar();
        AppMethodBeat.o(133156);
        return 0;
      }
      AppMethodBeat.o(133156);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.kc
 * JD-Core Version:    0.7.0.1
 */