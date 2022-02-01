package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cii
  extends com.tencent.mm.bw.a
{
  public String FKu;
  public String HuA;
  public String HuB;
  public int HuC;
  public LinkedList<su> HuD;
  public String HuE;
  public String HuF;
  public String Huz;
  
  public cii()
  {
    AppMethodBeat.i(114047);
    this.HuD = new LinkedList();
    AppMethodBeat.o(114047);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114048);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FKu != null) {
        paramVarArgs.d(1, this.FKu);
      }
      if (this.Huz != null) {
        paramVarArgs.d(2, this.Huz);
      }
      if (this.HuA != null) {
        paramVarArgs.d(3, this.HuA);
      }
      if (this.HuB != null) {
        paramVarArgs.d(4, this.HuB);
      }
      paramVarArgs.aS(5, this.HuC);
      paramVarArgs.e(6, 8, this.HuD);
      if (this.HuE != null) {
        paramVarArgs.d(7, this.HuE);
      }
      if (this.HuF != null) {
        paramVarArgs.d(8, this.HuF);
      }
      AppMethodBeat.o(114048);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FKu == null) {
        break label706;
      }
    }
    label706:
    for (int i = f.a.a.b.b.a.e(1, this.FKu) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Huz != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Huz);
      }
      i = paramInt;
      if (this.HuA != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.HuA);
      }
      paramInt = i;
      if (this.HuB != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HuB);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.HuC) + f.a.a.a.c(6, 8, this.HuD);
      paramInt = i;
      if (this.HuE != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.HuE);
      }
      i = paramInt;
      if (this.HuF != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.HuF);
      }
      AppMethodBeat.o(114048);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HuD.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(114048);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cii localcii = (cii)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114048);
          return -1;
        case 1: 
          localcii.FKu = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(114048);
          return 0;
        case 2: 
          localcii.Huz = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(114048);
          return 0;
        case 3: 
          localcii.HuA = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(114048);
          return 0;
        case 4: 
          localcii.HuB = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(114048);
          return 0;
        case 5: 
          localcii.HuC = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(114048);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new su();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((su)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcii.HuD.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114048);
          return 0;
        case 7: 
          localcii.HuE = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(114048);
          return 0;
        }
        localcii.HuF = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(114048);
        return 0;
      }
      AppMethodBeat.o(114048);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cii
 * JD-Core Version:    0.7.0.1
 */