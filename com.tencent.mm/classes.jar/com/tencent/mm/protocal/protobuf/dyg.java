package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dyg
  extends cwj
{
  public int HBX;
  public int Idh;
  public LinkedList<dyd> Idi;
  public int Idj;
  
  public dyg()
  {
    AppMethodBeat.i(148670);
    this.Idi = new LinkedList();
    AppMethodBeat.o(148670);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(148671);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(148671);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.Idh);
      paramVarArgs.e(3, 8, this.Idi);
      paramVarArgs.aS(4, this.HBX);
      paramVarArgs.aS(5, this.Idj);
      AppMethodBeat.o(148671);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label638;
      }
    }
    label638:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.Idh);
      int j = f.a.a.a.c(3, 8, this.Idi);
      int k = f.a.a.b.b.a.bz(4, this.HBX);
      int m = f.a.a.b.b.a.bz(5, this.Idj);
      AppMethodBeat.o(148671);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Idi.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(148671);
          throw paramVarArgs;
        }
        AppMethodBeat.o(148671);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dyg localdyg = (dyg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(148671);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdyg.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(148671);
          return 0;
        case 2: 
          localdyg.Idh = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(148671);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dyd();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dyd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdyg.Idi.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(148671);
          return 0;
        case 4: 
          localdyg.HBX = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(148671);
          return 0;
        }
        localdyg.Idj = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(148671);
        return 0;
      }
      AppMethodBeat.o(148671);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dyg
 * JD-Core Version:    0.7.0.1
 */