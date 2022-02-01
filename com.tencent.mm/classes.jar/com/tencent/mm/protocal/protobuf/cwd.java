package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cwd
  extends com.tencent.mm.bx.a
{
  public long EnS;
  public long EnT;
  public long EnU;
  public LinkedList<cuv> EnV;
  public String EnW;
  public String dnF;
  public String dpw;
  public String gPO;
  
  public cwd()
  {
    AppMethodBeat.i(122548);
    this.EnS = 0L;
    this.EnT = 0L;
    this.EnU = 0L;
    this.EnV = new LinkedList();
    AppMethodBeat.o(122548);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122549);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dpw != null) {
        paramVarArgs.d(1, this.dpw);
      }
      paramVarArgs.aG(2, this.EnS);
      paramVarArgs.aG(3, this.EnT);
      paramVarArgs.aG(4, this.EnU);
      paramVarArgs.e(5, 8, this.EnV);
      if (this.dnF != null) {
        paramVarArgs.d(6, this.dnF);
      }
      if (this.gPO != null) {
        paramVarArgs.d(7, this.gPO);
      }
      if (this.EnW != null) {
        paramVarArgs.d(8, this.EnW);
      }
      AppMethodBeat.o(122549);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dpw == null) {
        break label670;
      }
    }
    label670:
    for (paramInt = f.a.a.b.b.a.e(1, this.dpw) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.q(2, this.EnS) + f.a.a.b.b.a.q(3, this.EnT) + f.a.a.b.b.a.q(4, this.EnU) + f.a.a.a.c(5, 8, this.EnV);
      paramInt = i;
      if (this.dnF != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.dnF);
      }
      i = paramInt;
      if (this.gPO != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.gPO);
      }
      paramInt = i;
      if (this.EnW != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.EnW);
      }
      AppMethodBeat.o(122549);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EnV.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(122549);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cwd localcwd = (cwd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122549);
          return -1;
        case 1: 
          localcwd.dpw = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(122549);
          return 0;
        case 2: 
          localcwd.EnS = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(122549);
          return 0;
        case 3: 
          localcwd.EnT = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(122549);
          return 0;
        case 4: 
          localcwd.EnU = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(122549);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cuv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cuv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcwd.EnV.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122549);
          return 0;
        case 6: 
          localcwd.dnF = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(122549);
          return 0;
        case 7: 
          localcwd.gPO = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(122549);
          return 0;
        }
        localcwd.EnW = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(122549);
        return 0;
      }
      AppMethodBeat.o(122549);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cwd
 * JD-Core Version:    0.7.0.1
 */