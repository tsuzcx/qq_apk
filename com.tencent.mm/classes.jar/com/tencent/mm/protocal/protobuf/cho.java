package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cho
  extends com.tencent.mm.bw.a
{
  public LinkedList<cho> DFl;
  public String HtK;
  public LinkedList<chn> HtL;
  public int HtM;
  public int HtN;
  public int phB;
  public String type;
  public String wTE;
  
  public cho()
  {
    AppMethodBeat.i(117537);
    this.HtL = new LinkedList();
    this.DFl = new LinkedList();
    AppMethodBeat.o(117537);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117538);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HtK != null) {
        paramVarArgs.d(1, this.HtK);
      }
      if (this.wTE != null) {
        paramVarArgs.d(2, this.wTE);
      }
      paramVarArgs.e(3, 8, this.HtL);
      paramVarArgs.aS(4, this.phB);
      if (this.type != null) {
        paramVarArgs.d(5, this.type);
      }
      paramVarArgs.e(6, 8, this.DFl);
      paramVarArgs.aS(7, this.HtM);
      paramVarArgs.aS(8, this.HtN);
      AppMethodBeat.o(117538);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HtK == null) {
        break label758;
      }
    }
    label758:
    for (paramInt = f.a.a.b.b.a.e(1, this.HtK) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wTE != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.wTE);
      }
      i = i + f.a.a.a.c(3, 8, this.HtL) + f.a.a.b.b.a.bz(4, this.phB);
      paramInt = i;
      if (this.type != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.type);
      }
      i = f.a.a.a.c(6, 8, this.DFl);
      int j = f.a.a.b.b.a.bz(7, this.HtM);
      int k = f.a.a.b.b.a.bz(8, this.HtN);
      AppMethodBeat.o(117538);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HtL.clear();
        this.DFl.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(117538);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cho localcho = (cho)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117538);
          return -1;
        case 1: 
          localcho.HtK = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(117538);
          return 0;
        case 2: 
          localcho.wTE = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(117538);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new chn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((chn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcho.HtL.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117538);
          return 0;
        case 4: 
          localcho.phB = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(117538);
          return 0;
        case 5: 
          localcho.type = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(117538);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cho();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cho)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcho.DFl.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117538);
          return 0;
        case 7: 
          localcho.HtM = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(117538);
          return 0;
        }
        localcho.HtN = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(117538);
        return 0;
      }
      AppMethodBeat.o(117538);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cho
 * JD-Core Version:    0.7.0.1
 */