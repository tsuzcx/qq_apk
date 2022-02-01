package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;
import org.json.JSONObject;

public final class evv
  extends com.tencent.mm.bx.a
{
  public long YYo;
  public dhb aaLr;
  public String aaqW;
  public int abyb;
  public LinkedList<fvd> abyc;
  
  public evv()
  {
    AppMethodBeat.i(117914);
    this.abyc = new LinkedList();
    AppMethodBeat.o(117914);
  }
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(260081);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "BusinessType", Long.valueOf(this.YYo), false);
      com.tencent.mm.bk.a.a(localJSONObject, "KeyWord", this.aaqW, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Location", this.aaLr, false);
      com.tencent.mm.bk.a.a(localJSONObject, "RequestSrc", Integer.valueOf(this.abyb), false);
      com.tencent.mm.bk.a.a(localJSONObject, "MatchUserList", this.abyc, false);
      label74:
      AppMethodBeat.o(260081);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label74;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117915);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aaqW == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyWord");
        AppMethodBeat.o(117915);
        throw paramVarArgs;
      }
      paramVarArgs.bv(1, this.YYo);
      if (this.aaqW != null) {
        paramVarArgs.g(2, this.aaqW);
      }
      if (this.aaLr != null)
      {
        paramVarArgs.qD(3, this.aaLr.computeSize());
        this.aaLr.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(4, this.abyb);
      paramVarArgs.e(5, 8, this.abyc);
      AppMethodBeat.o(117915);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.q(1, this.YYo) + 0;
      paramInt = i;
      if (this.aaqW != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.aaqW);
      }
      i = paramInt;
      if (this.aaLr != null) {
        i = paramInt + i.a.a.a.qC(3, this.aaLr.computeSize());
      }
      paramInt = i.a.a.b.b.a.cJ(4, this.abyb);
      int j = i.a.a.a.c(5, 8, this.abyc);
      AppMethodBeat.o(117915);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.abyc.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      if (this.aaqW == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyWord");
        AppMethodBeat.o(117915);
        throw paramVarArgs;
      }
      AppMethodBeat.o(117915);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      evv localevv = (evv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117915);
        return -1;
      case 1: 
        localevv.YYo = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(117915);
        return 0;
      case 2: 
        localevv.aaqW = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(117915);
        return 0;
      case 3: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dhb();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dhb)localObject2).parseFrom((byte[])localObject1);
          }
          localevv.aaLr = ((dhb)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(117915);
        return 0;
      case 4: 
        localevv.abyb = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(117915);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new fvd();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((fvd)localObject2).parseFrom((byte[])localObject1);
        }
        localevv.abyc.add(localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(117915);
      return 0;
    }
    AppMethodBeat.o(117915);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.evv
 * JD-Core Version:    0.7.0.1
 */