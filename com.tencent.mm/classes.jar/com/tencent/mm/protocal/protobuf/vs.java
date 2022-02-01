package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class vs
  extends com.tencent.mm.bw.a
{
  public bnn BND;
  public bnn BNE;
  public String Efd;
  public String Eqd;
  public int Eqe;
  public String dlQ;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(177332);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.dlQ != null) {
        paramVarArgs.d(2, this.dlQ);
      }
      if (this.BND != null)
      {
        paramVarArgs.ln(3, this.BND.computeSize());
        this.BND.writeFields(paramVarArgs);
      }
      if (this.BNE != null)
      {
        paramVarArgs.ln(4, this.BNE.computeSize());
        this.BNE.writeFields(paramVarArgs);
      }
      if (this.Eqd != null) {
        paramVarArgs.d(5, this.Eqd);
      }
      if (this.Efd != null) {
        paramVarArgs.d(6, this.Efd);
      }
      paramVarArgs.aR(7, this.Eqe);
      AppMethodBeat.o(177332);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label754;
      }
    }
    label754:
    for (int i = f.a.a.b.b.a.e(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dlQ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dlQ);
      }
      i = paramInt;
      if (this.BND != null) {
        i = paramInt + f.a.a.a.lm(3, this.BND.computeSize());
      }
      paramInt = i;
      if (this.BNE != null) {
        paramInt = i + f.a.a.a.lm(4, this.BNE.computeSize());
      }
      i = paramInt;
      if (this.Eqd != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Eqd);
      }
      paramInt = i;
      if (this.Efd != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Efd);
      }
      i = f.a.a.b.b.a.bx(7, this.Eqe);
      AppMethodBeat.o(177332);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(177332);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        vs localvs = (vs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(177332);
          return -1;
        case 1: 
          localvs.title = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(177332);
          return 0;
        case 2: 
          localvs.dlQ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(177332);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bnn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bnn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localvs.BND = ((bnn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(177332);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bnn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bnn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localvs.BNE = ((bnn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(177332);
          return 0;
        case 5: 
          localvs.Eqd = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(177332);
          return 0;
        case 6: 
          localvs.Efd = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(177332);
          return 0;
        }
        localvs.Eqe = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(177332);
        return 0;
      }
      AppMethodBeat.o(177332);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vs
 * JD-Core Version:    0.7.0.1
 */