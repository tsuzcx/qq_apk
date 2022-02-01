package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dlt
  extends com.tencent.mm.bx.a
{
  public dlo HAd;
  public LinkedList<String> HAe;
  public aig HAf;
  public int HAg;
  public crs HAh;
  public String HAi;
  public long Hki;
  public String dln;
  public long lastUpdateTime;
  public int pos;
  public int style;
  public int weight;
  
  public dlt()
  {
    AppMethodBeat.i(124563);
    this.HAe = new LinkedList();
    AppMethodBeat.o(124563);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124564);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HAd != null)
      {
        paramVarArgs.lC(1, this.HAd.computeSize());
        this.HAd.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.lastUpdateTime);
      paramVarArgs.aS(3, this.pos);
      paramVarArgs.aS(4, this.weight);
      paramVarArgs.aY(5, this.Hki);
      paramVarArgs.e(6, 1, this.HAe);
      paramVarArgs.aS(7, this.style);
      if (this.dln != null) {
        paramVarArgs.d(8, this.dln);
      }
      if (this.HAf != null)
      {
        paramVarArgs.lC(9, this.HAf.computeSize());
        this.HAf.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(10, this.HAg);
      if (this.HAh != null)
      {
        paramVarArgs.lC(11, this.HAh.computeSize());
        this.HAh.writeFields(paramVarArgs);
      }
      if (this.HAi != null) {
        paramVarArgs.d(12, this.HAi);
      }
      AppMethodBeat.o(124564);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HAd == null) {
        break label1066;
      }
    }
    label1066:
    for (paramInt = f.a.a.a.lB(1, this.HAd.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.lastUpdateTime) + f.a.a.b.b.a.bz(3, this.pos) + f.a.a.b.b.a.bz(4, this.weight) + f.a.a.b.b.a.p(5, this.Hki) + f.a.a.a.c(6, 1, this.HAe) + f.a.a.b.b.a.bz(7, this.style);
      paramInt = i;
      if (this.dln != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.dln);
      }
      i = paramInt;
      if (this.HAf != null) {
        i = paramInt + f.a.a.a.lB(9, this.HAf.computeSize());
      }
      i += f.a.a.b.b.a.bz(10, this.HAg);
      paramInt = i;
      if (this.HAh != null) {
        paramInt = i + f.a.a.a.lB(11, this.HAh.computeSize());
      }
      i = paramInt;
      if (this.HAi != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.HAi);
      }
      AppMethodBeat.o(124564);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HAe.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(124564);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dlt localdlt = (dlt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124564);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dlo();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dlo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdlt.HAd = ((dlo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124564);
          return 0;
        case 2: 
          localdlt.lastUpdateTime = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(124564);
          return 0;
        case 3: 
          localdlt.pos = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(124564);
          return 0;
        case 4: 
          localdlt.weight = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(124564);
          return 0;
        case 5: 
          localdlt.Hki = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(124564);
          return 0;
        case 6: 
          localdlt.HAe.add(((f.a.a.a.a)localObject1).NPN.readString());
          AppMethodBeat.o(124564);
          return 0;
        case 7: 
          localdlt.style = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(124564);
          return 0;
        case 8: 
          localdlt.dln = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(124564);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aig();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aig)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdlt.HAf = ((aig)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124564);
          return 0;
        case 10: 
          localdlt.HAg = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(124564);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crs();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crs)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdlt.HAh = ((crs)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124564);
          return 0;
        }
        localdlt.HAi = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(124564);
        return 0;
      }
      AppMethodBeat.o(124564);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dlt
 * JD-Core Version:    0.7.0.1
 */