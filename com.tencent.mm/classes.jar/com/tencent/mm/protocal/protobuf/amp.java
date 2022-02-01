package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class amp
  extends dyy
{
  public String EvW;
  public String EvX;
  public int SwR;
  public int fwx;
  public String tVo;
  public String vhY;
  public String ybP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91455);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91455);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.fwx);
      if (this.tVo != null) {
        paramVarArgs.f(3, this.tVo);
      }
      if (this.ybP != null) {
        paramVarArgs.f(4, this.ybP);
      }
      if (this.vhY != null) {
        paramVarArgs.f(5, this.vhY);
      }
      paramVarArgs.aY(6, this.SwR);
      if (this.EvX != null) {
        paramVarArgs.f(7, this.EvX);
      }
      if (this.EvW != null) {
        paramVarArgs.f(8, this.EvW);
      }
      AppMethodBeat.o(91455);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label732;
      }
    }
    label732:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.fwx);
      paramInt = i;
      if (this.tVo != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.tVo);
      }
      i = paramInt;
      if (this.ybP != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.ybP);
      }
      paramInt = i;
      if (this.vhY != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.vhY);
      }
      i = paramInt + g.a.a.b.b.a.bM(6, this.SwR);
      paramInt = i;
      if (this.EvX != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.EvX);
      }
      i = paramInt;
      if (this.EvW != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.EvW);
      }
      AppMethodBeat.o(91455);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91455);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91455);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        amp localamp = (amp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91455);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jh localjh = new jh();
            if ((localObject != null) && (localObject.length > 0)) {
              localjh.parseFrom((byte[])localObject);
            }
            localamp.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(91455);
          return 0;
        case 2: 
          localamp.fwx = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91455);
          return 0;
        case 3: 
          localamp.tVo = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91455);
          return 0;
        case 4: 
          localamp.ybP = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91455);
          return 0;
        case 5: 
          localamp.vhY = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91455);
          return 0;
        case 6: 
          localamp.SwR = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91455);
          return 0;
        case 7: 
          localamp.EvX = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91455);
          return 0;
        }
        localamp.EvW = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(91455);
        return 0;
      }
      AppMethodBeat.o(91455);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amp
 * JD-Core Version:    0.7.0.1
 */