package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bww
  extends dyy
{
  public int SWT;
  public String SWU;
  public String SWV;
  public int SWW;
  public String SWX;
  public String TgB;
  public String TgC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91490);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91490);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.TgB != null) {
        paramVarArgs.f(2, this.TgB);
      }
      paramVarArgs.aY(3, this.SWT);
      if (this.SWU != null) {
        paramVarArgs.f(4, this.SWU);
      }
      if (this.SWV != null) {
        paramVarArgs.f(5, this.SWV);
      }
      paramVarArgs.aY(6, this.SWW);
      if (this.SWX != null) {
        paramVarArgs.f(7, this.SWX);
      }
      if (this.TgC != null) {
        paramVarArgs.f(8, this.TgC);
      }
      AppMethodBeat.o(91490);
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
      int i = paramInt;
      if (this.TgB != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.TgB);
      }
      i += g.a.a.b.b.a.bM(3, this.SWT);
      paramInt = i;
      if (this.SWU != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.SWU);
      }
      i = paramInt;
      if (this.SWV != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.SWV);
      }
      i += g.a.a.b.b.a.bM(6, this.SWW);
      paramInt = i;
      if (this.SWX != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.SWX);
      }
      i = paramInt;
      if (this.TgC != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.TgC);
      }
      AppMethodBeat.o(91490);
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
          AppMethodBeat.o(91490);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91490);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        bww localbww = (bww)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91490);
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
            localbww.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(91490);
          return 0;
        case 2: 
          localbww.TgB = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91490);
          return 0;
        case 3: 
          localbww.SWT = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91490);
          return 0;
        case 4: 
          localbww.SWU = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91490);
          return 0;
        case 5: 
          localbww.SWV = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91490);
          return 0;
        case 6: 
          localbww.SWW = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91490);
          return 0;
        case 7: 
          localbww.SWX = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91490);
          return 0;
        }
        localbww.TgC = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(91490);
        return 0;
      }
      AppMethodBeat.o(91490);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bww
 * JD-Core Version:    0.7.0.1
 */