package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class hc
  extends com.tencent.mm.bx.a
{
  public cxq FzA;
  public hj FzB;
  public hb Fzv;
  public avx Fzw;
  public String Fzx;
  public String Fzy;
  public String Fzz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123544);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Fzv != null)
      {
        paramVarArgs.lC(1, this.Fzv.computeSize());
        this.Fzv.writeFields(paramVarArgs);
      }
      if (this.Fzw != null)
      {
        paramVarArgs.lC(2, this.Fzw.computeSize());
        this.Fzw.writeFields(paramVarArgs);
      }
      if (this.Fzx != null) {
        paramVarArgs.d(3, this.Fzx);
      }
      if (this.Fzy != null) {
        paramVarArgs.d(4, this.Fzy);
      }
      if (this.Fzz != null) {
        paramVarArgs.d(5, this.Fzz);
      }
      if (this.FzA != null)
      {
        paramVarArgs.lC(6, this.FzA.computeSize());
        this.FzA.writeFields(paramVarArgs);
      }
      if (this.FzB != null)
      {
        paramVarArgs.lC(7, this.FzB.computeSize());
        this.FzB.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(123544);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Fzv == null) {
        break label958;
      }
    }
    label958:
    for (int i = f.a.a.a.lB(1, this.Fzv.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Fzw != null) {
        paramInt = i + f.a.a.a.lB(2, this.Fzw.computeSize());
      }
      i = paramInt;
      if (this.Fzx != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Fzx);
      }
      paramInt = i;
      if (this.Fzy != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Fzy);
      }
      i = paramInt;
      if (this.Fzz != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Fzz);
      }
      paramInt = i;
      if (this.FzA != null) {
        paramInt = i + f.a.a.a.lB(6, this.FzA.computeSize());
      }
      i = paramInt;
      if (this.FzB != null) {
        i = paramInt + f.a.a.a.lB(7, this.FzB.computeSize());
      }
      AppMethodBeat.o(123544);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(123544);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        hc localhc = (hc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123544);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((hb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localhc.Fzv = ((hb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123544);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new avx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((avx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localhc.Fzw = ((avx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123544);
          return 0;
        case 3: 
          localhc.Fzx = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123544);
          return 0;
        case 4: 
          localhc.Fzy = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123544);
          return 0;
        case 5: 
          localhc.Fzz = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123544);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localhc.FzA = ((cxq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123544);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new hj();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((hj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localhc.FzB = ((hj)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(123544);
        return 0;
      }
      AppMethodBeat.o(123544);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hc
 * JD-Core Version:    0.7.0.1
 */