package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class xr
  extends esc
{
  public int Zae;
  public com.tencent.mm.bx.b Zgx;
  public int Zgy;
  public int hAV;
  public String wYI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91409);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91409);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.hAV);
      if (this.wYI != null) {
        paramVarArgs.g(3, this.wYI);
      }
      if (this.Zgx != null) {
        paramVarArgs.d(4, this.Zgx);
      }
      paramVarArgs.bS(5, this.Zae);
      paramVarArgs.bS(6, this.Zgy);
      AppMethodBeat.o(91409);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label588;
      }
    }
    label588:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.hAV);
      paramInt = i;
      if (this.wYI != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wYI);
      }
      i = paramInt;
      if (this.Zgx != null) {
        i = paramInt + i.a.a.b.b.a.c(4, this.Zgx);
      }
      paramInt = i.a.a.b.b.a.cJ(5, this.Zae);
      int j = i.a.a.b.b.a.cJ(6, this.Zgy);
      AppMethodBeat.o(91409);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91409);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91409);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        xr localxr = (xr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91409);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kd localkd = new kd();
            if ((localObject != null) && (localObject.length > 0)) {
              localkd.parseFrom((byte[])localObject);
            }
            localxr.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(91409);
          return 0;
        case 2: 
          localxr.hAV = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91409);
          return 0;
        case 3: 
          localxr.wYI = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91409);
          return 0;
        case 4: 
          localxr.Zgx = ((i.a.a.a.a)localObject).ajGk.kFX();
          AppMethodBeat.o(91409);
          return 0;
        case 5: 
          localxr.Zae = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91409);
          return 0;
        }
        localxr.Zgy = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(91409);
        return 0;
      }
      AppMethodBeat.o(91409);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.xr
 * JD-Core Version:    0.7.0.1
 */