package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class chs
  extends com.tencent.mm.bw.a
{
  public LinkedList<chr> HtS;
  public int HtT;
  public int HtU;
  public cwf HtV;
  public int HtW;
  public LinkedList<chq> HtX;
  public boolean HtY;
  public LinkedList<cwf> HtZ;
  public int state;
  public String wTE;
  
  public chs()
  {
    AppMethodBeat.i(117544);
    this.HtS = new LinkedList();
    this.HtX = new LinkedList();
    this.HtZ = new LinkedList();
    AppMethodBeat.o(117544);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117545);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.wTE == null)
      {
        paramVarArgs = new b("Not all required fields were included: pid");
        AppMethodBeat.o(117545);
        throw paramVarArgs;
      }
      if (this.wTE != null) {
        paramVarArgs.d(1, this.wTE);
      }
      paramVarArgs.aS(2, this.state);
      paramVarArgs.e(3, 8, this.HtS);
      paramVarArgs.aS(4, this.HtT);
      paramVarArgs.aS(5, this.HtU);
      if (this.HtV != null)
      {
        paramVarArgs.lJ(6, this.HtV.computeSize());
        this.HtV.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(7, this.HtW);
      paramVarArgs.e(8, 8, this.HtX);
      paramVarArgs.bC(9, this.HtY);
      paramVarArgs.e(10, 8, this.HtZ);
      AppMethodBeat.o(117545);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wTE == null) {
        break label1062;
      }
    }
    label1062:
    for (paramInt = f.a.a.b.b.a.e(1, this.wTE) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.state) + f.a.a.a.c(3, 8, this.HtS) + f.a.a.b.b.a.bz(4, this.HtT) + f.a.a.b.b.a.bz(5, this.HtU);
      paramInt = i;
      if (this.HtV != null) {
        paramInt = i + f.a.a.a.lI(6, this.HtV.computeSize());
      }
      i = f.a.a.b.b.a.bz(7, this.HtW);
      int j = f.a.a.a.c(8, 8, this.HtX);
      int k = f.a.a.b.b.a.amF(9);
      int m = f.a.a.a.c(10, 8, this.HtZ);
      AppMethodBeat.o(117545);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HtS.clear();
        this.HtX.clear();
        this.HtZ.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.wTE == null)
        {
          paramVarArgs = new b("Not all required fields were included: pid");
          AppMethodBeat.o(117545);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117545);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        chs localchs = (chs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117545);
          return -1;
        case 1: 
          localchs.wTE = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(117545);
          return 0;
        case 2: 
          localchs.state = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(117545);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new chr();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((chr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localchs.HtS.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117545);
          return 0;
        case 4: 
          localchs.HtT = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(117545);
          return 0;
        case 5: 
          localchs.HtU = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(117545);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localchs.HtV = ((cwf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117545);
          return 0;
        case 7: 
          localchs.HtW = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(117545);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new chq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((chq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localchs.HtX.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117545);
          return 0;
        case 9: 
          localchs.HtY = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(117545);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cwf();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cwf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localchs.HtZ.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117545);
        return 0;
      }
      AppMethodBeat.o(117545);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chs
 * JD-Core Version:    0.7.0.1
 */