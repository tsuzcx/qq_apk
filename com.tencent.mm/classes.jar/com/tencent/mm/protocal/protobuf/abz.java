package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class abz
  extends cvp
{
  public LinkedList<cet> Fvu;
  public String Gby;
  public String Gbz;
  public String iHB;
  
  public abz()
  {
    AppMethodBeat.i(152524);
    this.Fvu = new LinkedList();
    AppMethodBeat.o(152524);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152525);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.iHB != null) {
        paramVarArgs.d(2, this.iHB);
      }
      paramVarArgs.e(3, 8, this.Fvu);
      if (this.Gby != null) {
        paramVarArgs.d(4, this.Gby);
      }
      if (this.Gbz != null) {
        paramVarArgs.d(5, this.Gbz);
      }
      AppMethodBeat.o(152525);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label630;
      }
    }
    label630:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.iHB != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.iHB);
      }
      i += f.a.a.a.c(3, 8, this.Fvu);
      paramInt = i;
      if (this.Gby != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Gby);
      }
      i = paramInt;
      if (this.Gbz != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Gbz);
      }
      AppMethodBeat.o(152525);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Fvu.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(152525);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        abz localabz = (abz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152525);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localabz.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152525);
          return 0;
        case 2: 
          localabz.iHB = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152525);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cet();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cet)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localabz.Fvu.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152525);
          return 0;
        case 4: 
          localabz.Gby = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152525);
          return 0;
        }
        localabz.Gbz = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(152525);
        return 0;
      }
      AppMethodBeat.o(152525);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.abz
 * JD-Core Version:    0.7.0.1
 */