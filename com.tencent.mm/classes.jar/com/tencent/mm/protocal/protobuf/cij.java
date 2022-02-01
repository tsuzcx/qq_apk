package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cij
  extends com.tencent.mm.bw.a
{
  public int Hno;
  public String HuG;
  public String HuH;
  public String HuI;
  public String HuJ;
  public ti HuK;
  public String HuL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114049);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HuG != null) {
        paramVarArgs.d(1, this.HuG);
      }
      if (this.HuH != null) {
        paramVarArgs.d(2, this.HuH);
      }
      if (this.HuI != null) {
        paramVarArgs.d(3, this.HuI);
      }
      paramVarArgs.aS(4, this.Hno);
      if (this.HuJ != null) {
        paramVarArgs.d(5, this.HuJ);
      }
      if (this.HuK != null)
      {
        paramVarArgs.lJ(6, this.HuK.computeSize());
        this.HuK.writeFields(paramVarArgs);
      }
      if (this.HuL != null) {
        paramVarArgs.d(7, this.HuL);
      }
      AppMethodBeat.o(114049);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HuG == null) {
        break label658;
      }
    }
    label658:
    for (int i = f.a.a.b.b.a.e(1, this.HuG) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HuH != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HuH);
      }
      i = paramInt;
      if (this.HuI != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.HuI);
      }
      i += f.a.a.b.b.a.bz(4, this.Hno);
      paramInt = i;
      if (this.HuJ != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.HuJ);
      }
      i = paramInt;
      if (this.HuK != null) {
        i = paramInt + f.a.a.a.lI(6, this.HuK.computeSize());
      }
      paramInt = i;
      if (this.HuL != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.HuL);
      }
      AppMethodBeat.o(114049);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(114049);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cij localcij = (cij)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114049);
          return -1;
        case 1: 
          localcij.HuG = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(114049);
          return 0;
        case 2: 
          localcij.HuH = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(114049);
          return 0;
        case 3: 
          localcij.HuI = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(114049);
          return 0;
        case 4: 
          localcij.Hno = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(114049);
          return 0;
        case 5: 
          localcij.HuJ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(114049);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ti();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ti)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcij.HuK = ((ti)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114049);
          return 0;
        }
        localcij.HuL = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(114049);
        return 0;
      }
      AppMethodBeat.o(114049);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cij
 * JD-Core Version:    0.7.0.1
 */