package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cco
  extends dyy
{
  public String CNP;
  public LinkedList<eih> TkH;
  public int TkI;
  public int TkJ;
  
  public cco()
  {
    AppMethodBeat.i(153277);
    this.TkH = new LinkedList();
    AppMethodBeat.o(153277);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153278);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(153278);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.TkH);
      if (this.CNP != null) {
        paramVarArgs.f(3, this.CNP);
      }
      paramVarArgs.aY(4, this.TkI);
      paramVarArgs.aY(5, this.TkJ);
      AppMethodBeat.o(153278);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label606;
      }
    }
    label606:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.TkH);
      paramInt = i;
      if (this.CNP != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.CNP);
      }
      i = g.a.a.b.b.a.bM(4, this.TkI);
      int j = g.a.a.b.b.a.bM(5, this.TkJ);
      AppMethodBeat.o(153278);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TkH.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(153278);
          throw paramVarArgs;
        }
        AppMethodBeat.o(153278);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cco localcco = (cco)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153278);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localcco.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153278);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eih();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eih)localObject2).parseFrom((byte[])localObject1);
            }
            localcco.TkH.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153278);
          return 0;
        case 3: 
          localcco.CNP = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(153278);
          return 0;
        case 4: 
          localcco.TkI = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(153278);
          return 0;
        }
        localcco.TkJ = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(153278);
        return 0;
      }
      AppMethodBeat.o(153278);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cco
 * JD-Core Version:    0.7.0.1
 */