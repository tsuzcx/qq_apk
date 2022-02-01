package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bsm
  extends dyy
{
  public int TcJ;
  public int TcK;
  public int TcL;
  public int TcM;
  public String TcN;
  public int TcO;
  public int rVU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101813);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(101813);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.rVU);
      paramVarArgs.aY(3, this.TcJ);
      paramVarArgs.aY(4, this.TcK);
      paramVarArgs.aY(5, this.TcL);
      paramVarArgs.aY(6, this.TcM);
      if (this.TcN != null) {
        paramVarArgs.f(7, this.TcN);
      }
      paramVarArgs.aY(8, this.TcO);
      AppMethodBeat.o(101813);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label660;
      }
    }
    label660:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.rVU) + g.a.a.b.b.a.bM(3, this.TcJ) + g.a.a.b.b.a.bM(4, this.TcK) + g.a.a.b.b.a.bM(5, this.TcL) + g.a.a.b.b.a.bM(6, this.TcM);
      paramInt = i;
      if (this.TcN != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.TcN);
      }
      i = g.a.a.b.b.a.bM(8, this.TcO);
      AppMethodBeat.o(101813);
      return paramInt + i;
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
          AppMethodBeat.o(101813);
          throw paramVarArgs;
        }
        AppMethodBeat.o(101813);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        bsm localbsm = (bsm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101813);
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
            localbsm.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(101813);
          return 0;
        case 2: 
          localbsm.rVU = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(101813);
          return 0;
        case 3: 
          localbsm.TcJ = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(101813);
          return 0;
        case 4: 
          localbsm.TcK = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(101813);
          return 0;
        case 5: 
          localbsm.TcL = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(101813);
          return 0;
        case 6: 
          localbsm.TcM = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(101813);
          return 0;
        case 7: 
          localbsm.TcN = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(101813);
          return 0;
        }
        localbsm.TcO = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(101813);
        return 0;
      }
      AppMethodBeat.o(101813);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bsm
 * JD-Core Version:    0.7.0.1
 */