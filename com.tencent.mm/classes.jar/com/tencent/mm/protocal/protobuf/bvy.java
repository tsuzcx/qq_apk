package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bvy
  extends com.tencent.mm.bx.a
{
  public String GPZ;
  public boolean GQa;
  public ih GQb;
  public String GQc;
  public boolean GQd;
  public int GQe;
  public String GQf;
  public int GQg;
  public dnd GQh;
  public LinkedList<ub> Gvi;
  
  public bvy()
  {
    AppMethodBeat.i(91533);
    this.Gvi = new LinkedList();
    AppMethodBeat.o(91533);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91534);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GPZ != null) {
        paramVarArgs.d(1, this.GPZ);
      }
      paramVarArgs.e(2, 8, this.Gvi);
      paramVarArgs.bt(3, this.GQa);
      if (this.GQb != null)
      {
        paramVarArgs.lC(4, this.GQb.computeSize());
        this.GQb.writeFields(paramVarArgs);
      }
      if (this.GQc != null) {
        paramVarArgs.d(5, this.GQc);
      }
      paramVarArgs.bt(6, this.GQd);
      paramVarArgs.aS(7, this.GQe);
      if (this.GQf != null) {
        paramVarArgs.d(8, this.GQf);
      }
      paramVarArgs.aS(9, this.GQg);
      if (this.GQh != null)
      {
        paramVarArgs.lC(10, this.GQh.computeSize());
        this.GQh.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91534);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GPZ == null) {
        break label958;
      }
    }
    label958:
    for (paramInt = f.a.a.b.b.a.e(1, this.GPZ) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.Gvi) + f.a.a.b.b.a.alV(3);
      paramInt = i;
      if (this.GQb != null) {
        paramInt = i + f.a.a.a.lB(4, this.GQb.computeSize());
      }
      i = paramInt;
      if (this.GQc != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.GQc);
      }
      i = i + f.a.a.b.b.a.alV(6) + f.a.a.b.b.a.bz(7, this.GQe);
      paramInt = i;
      if (this.GQf != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.GQf);
      }
      i = paramInt + f.a.a.b.b.a.bz(9, this.GQg);
      paramInt = i;
      if (this.GQh != null) {
        paramInt = i + f.a.a.a.lB(10, this.GQh.computeSize());
      }
      AppMethodBeat.o(91534);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Gvi.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91534);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bvy localbvy = (bvy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91534);
          return -1;
        case 1: 
          localbvy.GPZ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91534);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ub();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ub)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbvy.Gvi.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91534);
          return 0;
        case 3: 
          localbvy.GQa = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(91534);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ih();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ih)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbvy.GQb = ((ih)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91534);
          return 0;
        case 5: 
          localbvy.GQc = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91534);
          return 0;
        case 6: 
          localbvy.GQd = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(91534);
          return 0;
        case 7: 
          localbvy.GQe = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91534);
          return 0;
        case 8: 
          localbvy.GQf = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91534);
          return 0;
        case 9: 
          localbvy.GQg = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91534);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dnd();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dnd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbvy.GQh = ((dnd)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91534);
        return 0;
      }
      AppMethodBeat.o(91534);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvy
 * JD-Core Version:    0.7.0.1
 */