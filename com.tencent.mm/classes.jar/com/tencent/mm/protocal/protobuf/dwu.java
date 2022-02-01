package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dwu
  extends com.tencent.mm.bw.a
{
  public abn IbT;
  public boolean IbU = true;
  public dwi IbV;
  public String IbW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117943);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.IbT != null)
      {
        paramVarArgs.lJ(1, this.IbT.computeSize());
        this.IbT.writeFields(paramVarArgs);
      }
      paramVarArgs.bC(2, this.IbU);
      if (this.IbV != null)
      {
        paramVarArgs.lJ(3, this.IbV.computeSize());
        this.IbV.writeFields(paramVarArgs);
      }
      if (this.IbW != null) {
        paramVarArgs.d(4, this.IbW);
      }
      AppMethodBeat.o(117943);
      return 0;
    }
    if (paramInt == 1) {
      if (this.IbT == null) {
        break label566;
      }
    }
    label566:
    for (paramInt = f.a.a.a.lI(1, this.IbT.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.amF(2);
      paramInt = i;
      if (this.IbV != null) {
        paramInt = i + f.a.a.a.lI(3, this.IbV.computeSize());
      }
      i = paramInt;
      if (this.IbW != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.IbW);
      }
      AppMethodBeat.o(117943);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(117943);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dwu localdwu = (dwu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117943);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new abn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((abn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdwu.IbT = ((abn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117943);
          return 0;
        case 2: 
          localdwu.IbU = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(117943);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dwi();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dwi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdwu.IbV = ((dwi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117943);
          return 0;
        }
        localdwu.IbW = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(117943);
        return 0;
      }
      AppMethodBeat.o(117943);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwu
 * JD-Core Version:    0.7.0.1
 */