package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aqg
  extends com.tencent.mm.bw.a
{
  public LinkedList<cvw> EJe;
  public cvw EJf;
  public LinkedList<aqf> EJg;
  public boolean EJh;
  public String EJi;
  public long EJj;
  public String dnh;
  public boolean rAJ;
  
  public aqg()
  {
    AppMethodBeat.i(122501);
    this.EJe = new LinkedList();
    this.EJg = new LinkedList();
    this.EJh = false;
    this.rAJ = false;
    AppMethodBeat.o(122501);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122502);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dnh != null) {
        paramVarArgs.d(1, this.dnh);
      }
      paramVarArgs.e(2, 8, this.EJe);
      if (this.EJf != null)
      {
        paramVarArgs.ln(3, this.EJf.computeSize());
        this.EJf.writeFields(paramVarArgs);
      }
      paramVarArgs.e(4, 8, this.EJg);
      paramVarArgs.bl(5, this.EJh);
      paramVarArgs.bl(6, this.rAJ);
      if (this.EJi != null) {
        paramVarArgs.d(7, this.EJi);
      }
      paramVarArgs.aO(8, this.EJj);
      AppMethodBeat.o(122502);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dnh == null) {
        break label842;
      }
    }
    label842:
    for (paramInt = f.a.a.b.b.a.e(1, this.dnh) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.EJe);
      paramInt = i;
      if (this.EJf != null) {
        paramInt = i + f.a.a.a.lm(3, this.EJf.computeSize());
      }
      i = paramInt + f.a.a.a.c(4, 8, this.EJg) + (f.a.a.b.b.a.fK(5) + 1) + (f.a.a.b.b.a.fK(6) + 1);
      paramInt = i;
      if (this.EJi != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.EJi);
      }
      i = f.a.a.b.b.a.p(8, this.EJj);
      AppMethodBeat.o(122502);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EJe.clear();
        this.EJg.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(122502);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aqg localaqg = (aqg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122502);
          return -1;
        case 1: 
          localaqg.dnh = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(122502);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cvw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cvw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaqg.EJe.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122502);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cvw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cvw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaqg.EJf = ((cvw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122502);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aqf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aqf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaqg.EJg.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122502);
          return 0;
        case 5: 
          localaqg.EJh = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(122502);
          return 0;
        case 6: 
          localaqg.rAJ = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(122502);
          return 0;
        case 7: 
          localaqg.EJi = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(122502);
          return 0;
        }
        localaqg.EJj = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(122502);
        return 0;
      }
      AppMethodBeat.o(122502);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqg
 * JD-Core Version:    0.7.0.1
 */