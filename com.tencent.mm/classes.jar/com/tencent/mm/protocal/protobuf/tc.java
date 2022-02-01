package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class tc
  extends com.tencent.mm.bw.a
{
  public int Lbi;
  public int Lbj;
  public int Lbk;
  public int Lbl;
  public LinkedList<dqi> Lbm;
  public String Lbn;
  public SKBuiltinBuffer_t Lbo;
  public int Lbp;
  public int Lbq;
  public LinkedList<dqi> Lbr;
  public LinkedList<td> Lbs;
  public LinkedList<td> Lbt;
  public int Lbu;
  public int Lbv;
  public int rBx;
  
  public tc()
  {
    AppMethodBeat.i(133162);
    this.Lbm = new LinkedList();
    this.Lbr = new LinkedList();
    this.Lbs = new LinkedList();
    this.Lbt = new LinkedList();
    AppMethodBeat.o(133162);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133163);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Lbo == null)
      {
        paramVarArgs = new b("Not all required fields were included: AuthKey");
        AppMethodBeat.o(133163);
        throw paramVarArgs;
      }
      paramVarArgs.aM(1, this.Lbi);
      paramVarArgs.aM(2, this.rBx);
      paramVarArgs.aM(3, this.Lbj);
      paramVarArgs.aM(4, this.Lbk);
      paramVarArgs.aM(5, this.Lbl);
      paramVarArgs.e(6, 8, this.Lbm);
      if (this.Lbn != null) {
        paramVarArgs.e(7, this.Lbn);
      }
      if (this.Lbo != null)
      {
        paramVarArgs.ni(8, this.Lbo.computeSize());
        this.Lbo.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(9, this.Lbp);
      paramVarArgs.aM(10, this.Lbq);
      paramVarArgs.e(11, 8, this.Lbr);
      paramVarArgs.e(12, 8, this.Lbs);
      paramVarArgs.e(13, 8, this.Lbt);
      paramVarArgs.aM(14, this.Lbu);
      paramVarArgs.aM(15, this.Lbv);
      AppMethodBeat.o(133163);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.Lbi) + 0 + g.a.a.b.b.a.bu(2, this.rBx) + g.a.a.b.b.a.bu(3, this.Lbj) + g.a.a.b.b.a.bu(4, this.Lbk) + g.a.a.b.b.a.bu(5, this.Lbl) + g.a.a.a.c(6, 8, this.Lbm);
      paramInt = i;
      if (this.Lbn != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.Lbn);
      }
      i = paramInt;
      if (this.Lbo != null) {
        i = paramInt + g.a.a.a.nh(8, this.Lbo.computeSize());
      }
      paramInt = g.a.a.b.b.a.bu(9, this.Lbp);
      int j = g.a.a.b.b.a.bu(10, this.Lbq);
      int k = g.a.a.a.c(11, 8, this.Lbr);
      int m = g.a.a.a.c(12, 8, this.Lbs);
      int n = g.a.a.a.c(13, 8, this.Lbt);
      int i1 = g.a.a.b.b.a.bu(14, this.Lbu);
      int i2 = g.a.a.b.b.a.bu(15, this.Lbv);
      AppMethodBeat.o(133163);
      return i + paramInt + j + k + m + n + i1 + i2;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Lbm.clear();
      this.Lbr.clear();
      this.Lbs.clear();
      this.Lbt.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      if (this.Lbo == null)
      {
        paramVarArgs = new b("Not all required fields were included: AuthKey");
        AppMethodBeat.o(133163);
        throw paramVarArgs;
      }
      AppMethodBeat.o(133163);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      tc localtc = (tc)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(133163);
        return -1;
      case 1: 
        localtc.Lbi = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(133163);
        return 0;
      case 2: 
        localtc.rBx = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(133163);
        return 0;
      case 3: 
        localtc.Lbj = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(133163);
        return 0;
      case 4: 
        localtc.Lbk = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(133163);
        return 0;
      case 5: 
        localtc.Lbl = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(133163);
        return 0;
      case 6: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dqi();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localtc.Lbm.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133163);
        return 0;
      case 7: 
        localtc.Lbn = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(133163);
        return 0;
      case 8: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localtc.Lbo = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133163);
        return 0;
      case 9: 
        localtc.Lbp = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(133163);
        return 0;
      case 10: 
        localtc.Lbq = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(133163);
        return 0;
      case 11: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dqi();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localtc.Lbr.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133163);
        return 0;
      case 12: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new td();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((td)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localtc.Lbs.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133163);
        return 0;
      case 13: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new td();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((td)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localtc.Lbt.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133163);
        return 0;
      case 14: 
        localtc.Lbu = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(133163);
        return 0;
      }
      localtc.Lbv = ((g.a.a.a.a)localObject1).UbS.zi();
      AppMethodBeat.o(133163);
      return 0;
    }
    AppMethodBeat.o(133163);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.tc
 * JD-Core Version:    0.7.0.1
 */