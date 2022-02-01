package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bxm
  extends com.tencent.mm.bx.a
{
  public LinkedList<bxl> DTV;
  public int DTW;
  public int DTX;
  public ckz DTY;
  public int DTZ;
  public LinkedList<bxk> DUa;
  public boolean DUb;
  public LinkedList<ckz> DUc;
  public int state;
  public String upD;
  
  public bxm()
  {
    AppMethodBeat.i(117544);
    this.DTV = new LinkedList();
    this.DUa = new LinkedList();
    this.DUc = new LinkedList();
    AppMethodBeat.o(117544);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117545);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.upD == null)
      {
        paramVarArgs = new b("Not all required fields were included: pid");
        AppMethodBeat.o(117545);
        throw paramVarArgs;
      }
      if (this.upD != null) {
        paramVarArgs.d(1, this.upD);
      }
      paramVarArgs.aR(2, this.state);
      paramVarArgs.e(3, 8, this.DTV);
      paramVarArgs.aR(4, this.DTW);
      paramVarArgs.aR(5, this.DTX);
      if (this.DTY != null)
      {
        paramVarArgs.kX(6, this.DTY.computeSize());
        this.DTY.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(7, this.DTZ);
      paramVarArgs.e(8, 8, this.DUa);
      paramVarArgs.bg(9, this.DUb);
      paramVarArgs.e(10, 8, this.DUc);
      AppMethodBeat.o(117545);
      return 0;
    }
    if (paramInt == 1) {
      if (this.upD == null) {
        break label1066;
      }
    }
    label1066:
    for (paramInt = f.a.a.b.b.a.e(1, this.upD) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.state) + f.a.a.a.c(3, 8, this.DTV) + f.a.a.b.b.a.bA(4, this.DTW) + f.a.a.b.b.a.bA(5, this.DTX);
      paramInt = i;
      if (this.DTY != null) {
        paramInt = i + f.a.a.a.kW(6, this.DTY.computeSize());
      }
      i = f.a.a.b.b.a.bA(7, this.DTZ);
      int j = f.a.a.a.c(8, 8, this.DUa);
      int k = f.a.a.b.b.a.fY(9);
      int m = f.a.a.a.c(10, 8, this.DUc);
      AppMethodBeat.o(117545);
      return paramInt + i + j + (k + 1) + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DTV.clear();
        this.DUa.clear();
        this.DUc.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.upD == null)
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
        bxm localbxm = (bxm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117545);
          return -1;
        case 1: 
          localbxm.upD = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(117545);
          return 0;
        case 2: 
          localbxm.state = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(117545);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bxl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bxl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbxm.DTV.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117545);
          return 0;
        case 4: 
          localbxm.DTW = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(117545);
          return 0;
        case 5: 
          localbxm.DTX = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(117545);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ckz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ckz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbxm.DTY = ((ckz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117545);
          return 0;
        case 7: 
          localbxm.DTZ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(117545);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bxk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bxk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbxm.DUa.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117545);
          return 0;
        case 9: 
          localbxm.DUb = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(117545);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ckz();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ckz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbxm.DUc.add(localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxm
 * JD-Core Version:    0.7.0.1
 */