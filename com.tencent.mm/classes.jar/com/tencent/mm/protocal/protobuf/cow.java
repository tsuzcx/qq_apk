package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cow
  extends com.tencent.mm.bw.a
{
  public int HAA;
  public boolean HAB;
  public String HAC;
  public int HAD;
  public int HAE;
  public LinkedList<cov> HAF;
  public String dJb;
  
  public cow()
  {
    AppMethodBeat.i(114057);
    this.HAF = new LinkedList();
    AppMethodBeat.o(114057);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114058);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dJb != null) {
        paramVarArgs.d(1, this.dJb);
      }
      paramVarArgs.aS(2, this.HAA);
      paramVarArgs.bC(3, this.HAB);
      if (this.HAC != null) {
        paramVarArgs.d(4, this.HAC);
      }
      paramVarArgs.aS(5, this.HAD);
      paramVarArgs.aS(6, this.HAE);
      paramVarArgs.e(7, 8, this.HAF);
      AppMethodBeat.o(114058);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dJb == null) {
        break label594;
      }
    }
    label594:
    for (paramInt = f.a.a.b.b.a.e(1, this.dJb) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.HAA) + f.a.a.b.b.a.amF(3);
      paramInt = i;
      if (this.HAC != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HAC);
      }
      i = f.a.a.b.b.a.bz(5, this.HAD);
      int j = f.a.a.b.b.a.bz(6, this.HAE);
      int k = f.a.a.a.c(7, 8, this.HAF);
      AppMethodBeat.o(114058);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HAF.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(114058);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cow localcow = (cow)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114058);
          return -1;
        case 1: 
          localcow.dJb = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(114058);
          return 0;
        case 2: 
          localcow.HAA = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(114058);
          return 0;
        case 3: 
          localcow.HAB = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(114058);
          return 0;
        case 4: 
          localcow.HAC = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(114058);
          return 0;
        case 5: 
          localcow.HAD = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(114058);
          return 0;
        case 6: 
          localcow.HAE = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(114058);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cov();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((cov)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcow.HAF.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(114058);
        return 0;
      }
      AppMethodBeat.o(114058);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cow
 * JD-Core Version:    0.7.0.1
 */