package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dgb
  extends com.tencent.mm.bw.a
{
  public String FPn;
  public dgd FPo;
  public String FPp;
  public LinkedList<dgc> FPq;
  public String FPr;
  public long FPs;
  public dgf FPt;
  
  public dgb()
  {
    AppMethodBeat.i(124556);
    this.FPq = new LinkedList();
    AppMethodBeat.o(124556);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124557);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FPn != null) {
        paramVarArgs.d(1, this.FPn);
      }
      if (this.FPo != null)
      {
        paramVarArgs.ln(2, this.FPo.computeSize());
        this.FPo.writeFields(paramVarArgs);
      }
      if (this.FPp != null) {
        paramVarArgs.d(3, this.FPp);
      }
      paramVarArgs.e(4, 8, this.FPq);
      if (this.FPr != null) {
        paramVarArgs.d(5, this.FPr);
      }
      paramVarArgs.aO(6, this.FPs);
      if (this.FPt != null)
      {
        paramVarArgs.ln(7, this.FPt.computeSize());
        this.FPt.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(124557);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FPn == null) {
        break label834;
      }
    }
    label834:
    for (int i = f.a.a.b.b.a.e(1, this.FPn) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FPo != null) {
        paramInt = i + f.a.a.a.lm(2, this.FPo.computeSize());
      }
      i = paramInt;
      if (this.FPp != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FPp);
      }
      i += f.a.a.a.c(4, 8, this.FPq);
      paramInt = i;
      if (this.FPr != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FPr);
      }
      i = paramInt + f.a.a.b.b.a.p(6, this.FPs);
      paramInt = i;
      if (this.FPt != null) {
        paramInt = i + f.a.a.a.lm(7, this.FPt.computeSize());
      }
      AppMethodBeat.o(124557);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FPq.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(124557);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dgb localdgb = (dgb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124557);
          return -1;
        case 1: 
          localdgb.FPn = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(124557);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dgd();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dgd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdgb.FPo = ((dgd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124557);
          return 0;
        case 3: 
          localdgb.FPp = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(124557);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dgc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dgc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdgb.FPq.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124557);
          return 0;
        case 5: 
          localdgb.FPr = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(124557);
          return 0;
        case 6: 
          localdgb.FPs = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(124557);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dgf();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dgf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdgb.FPt = ((dgf)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(124557);
        return 0;
      }
      AppMethodBeat.o(124557);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dgb
 * JD-Core Version:    0.7.0.1
 */