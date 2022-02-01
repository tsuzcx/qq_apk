package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import org.json.JSONObject;

public final class fxg
  extends com.tencent.mm.bx.a
{
  public int abUT;
  public xa abUU;
  public xa abUV;
  public int abUW;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(258104);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "CdnScene", Integer.valueOf(this.abUT), false);
      com.tencent.mm.bk.a.a(localJSONObject, "CtnInfo", this.abUU, false);
      com.tencent.mm.bk.a.a(localJSONObject, "MpInfo", this.abUV, false);
      com.tencent.mm.bk.a.a(localJSONObject, "CdnSourceType", Integer.valueOf(this.abUW), false);
      label63:
      AppMethodBeat.o(258104);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label63;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117940);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.abUT);
      if (this.abUU != null)
      {
        paramVarArgs.qD(4, this.abUU.computeSize());
        this.abUU.writeFields(paramVarArgs);
      }
      if (this.abUV != null)
      {
        paramVarArgs.qD(5, this.abUV.computeSize());
        this.abUV.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(6, this.abUW);
      AppMethodBeat.o(117940);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.abUT) + 0;
      paramInt = i;
      if (this.abUU != null) {
        paramInt = i + i.a.a.a.qC(4, this.abUU.computeSize());
      }
      i = paramInt;
      if (this.abUV != null) {
        i = paramInt + i.a.a.a.qC(5, this.abUV.computeSize());
      }
      paramInt = i.a.a.b.b.a.cJ(6, this.abUW);
      AppMethodBeat.o(117940);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(117940);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      fxg localfxg = (fxg)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      xa localxa;
      switch (paramInt)
      {
      case 2: 
      case 3: 
      default: 
        AppMethodBeat.o(117940);
        return -1;
      case 1: 
        localfxg.abUT = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(117940);
        return 0;
      case 4: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localxa = new xa();
          if ((localObject != null) && (localObject.length > 0)) {
            localxa.parseFrom((byte[])localObject);
          }
          localfxg.abUU = localxa;
          paramInt += 1;
        }
        AppMethodBeat.o(117940);
        return 0;
      case 5: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localxa = new xa();
          if ((localObject != null) && (localObject.length > 0)) {
            localxa.parseFrom((byte[])localObject);
          }
          localfxg.abUV = localxa;
          paramInt += 1;
        }
        AppMethodBeat.o(117940);
        return 0;
      }
      localfxg.abUW = ((i.a.a.a.a)localObject).ajGk.aar();
      AppMethodBeat.o(117940);
      return 0;
    }
    AppMethodBeat.o(117940);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fxg
 * JD-Core Version:    0.7.0.1
 */