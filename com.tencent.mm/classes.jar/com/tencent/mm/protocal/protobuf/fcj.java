package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fcj
  extends dyl
{
  public String UBS;
  public String UBT;
  public fcn UCi;
  public LinkedList<fci> UCm;
  
  public fcj()
  {
    AppMethodBeat.i(203527);
    this.UCm = new LinkedList();
    AppMethodBeat.o(203527);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(203532);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.UBS != null) {
        paramVarArgs.f(2, this.UBS);
      }
      if (this.UBT != null) {
        paramVarArgs.f(3, this.UBT);
      }
      if (this.UCi != null)
      {
        paramVarArgs.oE(4, this.UCi.computeSize());
        this.UCi.writeFields(paramVarArgs);
      }
      paramVarArgs.e(5, 8, this.UCm);
      AppMethodBeat.o(203532);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label660;
      }
    }
    label660:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.UBS != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.UBS);
      }
      i = paramInt;
      if (this.UBT != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.UBT);
      }
      paramInt = i;
      if (this.UCi != null) {
        paramInt = i + g.a.a.a.oD(4, this.UCi.computeSize());
      }
      i = g.a.a.a.c(5, 8, this.UCm);
      AppMethodBeat.o(203532);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.UCm.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(203532);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        fcj localfcj = (fcj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(203532);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jg)localObject2).parseFrom((byte[])localObject1);
            }
            localfcj.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(203532);
          return 0;
        case 2: 
          localfcj.UBS = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(203532);
          return 0;
        case 3: 
          localfcj.UBT = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(203532);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fcn();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fcn)localObject2).parseFrom((byte[])localObject1);
            }
            localfcj.UCi = ((fcn)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(203532);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fci();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fci)localObject2).parseFrom((byte[])localObject1);
          }
          localfcj.UCm.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(203532);
        return 0;
      }
      AppMethodBeat.o(203532);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fcj
 * JD-Core Version:    0.7.0.1
 */