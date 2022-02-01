package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cxv
  extends com.tencent.mm.bw.a
{
  public String APx;
  public LinkedList<cxv> Iow;
  public String MCI;
  public LinkedList<cxu> MCJ;
  public int MCK;
  public int MCL;
  public int qwL;
  public String type;
  
  public cxv()
  {
    AppMethodBeat.i(117537);
    this.MCJ = new LinkedList();
    this.Iow = new LinkedList();
    AppMethodBeat.o(117537);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117538);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MCI != null) {
        paramVarArgs.e(1, this.MCI);
      }
      if (this.APx != null) {
        paramVarArgs.e(2, this.APx);
      }
      paramVarArgs.e(3, 8, this.MCJ);
      paramVarArgs.aM(4, this.qwL);
      if (this.type != null) {
        paramVarArgs.e(5, this.type);
      }
      paramVarArgs.e(6, 8, this.Iow);
      paramVarArgs.aM(7, this.MCK);
      paramVarArgs.aM(8, this.MCL);
      AppMethodBeat.o(117538);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MCI == null) {
        break label758;
      }
    }
    label758:
    for (paramInt = g.a.a.b.b.a.f(1, this.MCI) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.APx != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.APx);
      }
      i = i + g.a.a.a.c(3, 8, this.MCJ) + g.a.a.b.b.a.bu(4, this.qwL);
      paramInt = i;
      if (this.type != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.type);
      }
      i = g.a.a.a.c(6, 8, this.Iow);
      int j = g.a.a.b.b.a.bu(7, this.MCK);
      int k = g.a.a.b.b.a.bu(8, this.MCL);
      AppMethodBeat.o(117538);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.MCJ.clear();
        this.Iow.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(117538);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cxv localcxv = (cxv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117538);
          return -1;
        case 1: 
          localcxv.MCI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(117538);
          return 0;
        case 2: 
          localcxv.APx = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(117538);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxu();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxu)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcxv.MCJ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117538);
          return 0;
        case 4: 
          localcxv.qwL = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(117538);
          return 0;
        case 5: 
          localcxv.type = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(117538);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxv();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxv)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcxv.Iow.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117538);
          return 0;
        case 7: 
          localcxv.MCK = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(117538);
          return 0;
        }
        localcxv.MCL = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(117538);
        return 0;
      }
      AppMethodBeat.o(117538);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxv
 * JD-Core Version:    0.7.0.1
 */