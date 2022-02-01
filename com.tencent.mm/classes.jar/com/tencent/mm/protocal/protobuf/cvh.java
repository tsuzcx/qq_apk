package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cvh
  extends cld
{
  public int EmK;
  public LinkedList<Integer> EmM;
  public int EmN;
  public int EmO;
  public LinkedList<cwl> EmP;
  
  public cvh()
  {
    AppMethodBeat.i(125800);
    this.EmM = new LinkedList();
    this.EmP = new LinkedList();
    AppMethodBeat.o(125800);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125801);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(125801);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.EmK);
      paramVarArgs.f(3, 2, this.EmM);
      paramVarArgs.aR(4, this.EmN);
      paramVarArgs.aR(5, this.EmO);
      paramVarArgs.e(6, 8, this.EmP);
      AppMethodBeat.o(125801);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label713;
      }
    }
    label713:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bA(2, this.EmK);
      int j = f.a.a.a.d(3, 2, this.EmM);
      int k = f.a.a.b.b.a.bA(4, this.EmN);
      int m = f.a.a.b.b.a.bA(5, this.EmO);
      int n = f.a.a.a.c(6, 8, this.EmP);
      AppMethodBeat.o(125801);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EmM.clear();
        this.EmP.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(125801);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125801);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cvh localcvh = (cvh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125801);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcvh.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125801);
          return 0;
        case 2: 
          localcvh.EmK = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125801);
          return 0;
        case 3: 
          localcvh.EmM = new f.a.a.a.a(((f.a.a.a.a)localObject1).KhF.fMu().wA, unknownTagHandler).KhF.fMs();
          AppMethodBeat.o(125801);
          return 0;
        case 4: 
          localcvh.EmN = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125801);
          return 0;
        case 5: 
          localcvh.EmO = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125801);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cwl();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cwl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcvh.EmP.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125801);
        return 0;
      }
      AppMethodBeat.o(125801);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvh
 * JD-Core Version:    0.7.0.1
 */