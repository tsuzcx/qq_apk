package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class gv
  extends com.tencent.mm.bw.a
{
  public gu DUb;
  public arz DUc;
  public String DUd;
  public String DUe;
  public String DUf;
  public csg DUg;
  public hc DUh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123544);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DUb != null)
      {
        paramVarArgs.ln(1, this.DUb.computeSize());
        this.DUb.writeFields(paramVarArgs);
      }
      if (this.DUc != null)
      {
        paramVarArgs.ln(2, this.DUc.computeSize());
        this.DUc.writeFields(paramVarArgs);
      }
      if (this.DUd != null) {
        paramVarArgs.d(3, this.DUd);
      }
      if (this.DUe != null) {
        paramVarArgs.d(4, this.DUe);
      }
      if (this.DUf != null) {
        paramVarArgs.d(5, this.DUf);
      }
      if (this.DUg != null)
      {
        paramVarArgs.ln(6, this.DUg.computeSize());
        this.DUg.writeFields(paramVarArgs);
      }
      if (this.DUh != null)
      {
        paramVarArgs.ln(7, this.DUh.computeSize());
        this.DUh.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(123544);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DUb == null) {
        break label958;
      }
    }
    label958:
    for (int i = f.a.a.a.lm(1, this.DUb.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DUc != null) {
        paramInt = i + f.a.a.a.lm(2, this.DUc.computeSize());
      }
      i = paramInt;
      if (this.DUd != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DUd);
      }
      paramInt = i;
      if (this.DUe != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DUe);
      }
      i = paramInt;
      if (this.DUf != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.DUf);
      }
      paramInt = i;
      if (this.DUg != null) {
        paramInt = i + f.a.a.a.lm(6, this.DUg.computeSize());
      }
      i = paramInt;
      if (this.DUh != null) {
        i = paramInt + f.a.a.a.lm(7, this.DUh.computeSize());
      }
      AppMethodBeat.o(123544);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(123544);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        gv localgv = (gv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123544);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((gu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localgv.DUb = ((gu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123544);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new arz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((arz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localgv.DUc = ((arz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123544);
          return 0;
        case 3: 
          localgv.DUd = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123544);
          return 0;
        case 4: 
          localgv.DUe = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123544);
          return 0;
        case 5: 
          localgv.DUf = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123544);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new csg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((csg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localgv.DUg = ((csg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123544);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new hc();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((hc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localgv.DUh = ((hc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(123544);
        return 0;
      }
      AppMethodBeat.o(123544);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gv
 * JD-Core Version:    0.7.0.1
 */