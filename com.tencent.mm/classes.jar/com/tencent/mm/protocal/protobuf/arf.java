package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class arf
  extends cvp
{
  public int continueFlag;
  public String dwW;
  public int offset;
  public LinkedList<FinderObject> rtM;
  public b sbF;
  public LinkedList<ard> vHi;
  
  public arf()
  {
    AppMethodBeat.i(169049);
    this.vHi = new LinkedList();
    this.rtM = new LinkedList();
    AppMethodBeat.o(169049);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169050);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.vHi);
      paramVarArgs.aS(3, this.offset);
      paramVarArgs.aS(4, this.continueFlag);
      paramVarArgs.e(5, 8, this.rtM);
      if (this.sbF != null) {
        paramVarArgs.c(6, this.sbF);
      }
      if (this.dwW != null) {
        paramVarArgs.d(7, this.dwW);
      }
      AppMethodBeat.o(169050);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label798;
      }
    }
    label798:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.vHi) + f.a.a.b.b.a.bz(3, this.offset) + f.a.a.b.b.a.bz(4, this.continueFlag) + f.a.a.a.c(5, 8, this.rtM);
      paramInt = i;
      if (this.sbF != null) {
        paramInt = i + f.a.a.b.b.a.b(6, this.sbF);
      }
      i = paramInt;
      if (this.dwW != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.dwW);
      }
      AppMethodBeat.o(169050);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.vHi.clear();
        this.rtM.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(169050);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        arf localarf = (arf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169050);
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
            localarf.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169050);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ard();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ard)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localarf.vHi.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169050);
          return 0;
        case 3: 
          localarf.offset = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(169050);
          return 0;
        case 4: 
          localarf.continueFlag = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(169050);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderObject();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderObject)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localarf.rtM.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169050);
          return 0;
        case 6: 
          localarf.sbF = ((f.a.a.a.a)localObject1).NPN.gxI();
          AppMethodBeat.o(169050);
          return 0;
        }
        localarf.dwW = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(169050);
        return 0;
      }
      AppMethodBeat.o(169050);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.arf
 * JD-Core Version:    0.7.0.1
 */