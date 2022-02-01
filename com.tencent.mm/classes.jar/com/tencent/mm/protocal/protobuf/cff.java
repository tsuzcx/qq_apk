package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cff
  extends com.tencent.mm.bw.a
{
  public dhb DNJ;
  public dhb DNK;
  public bld FtH;
  public LinkedList<rp> FtI;
  public bxn FtJ;
  
  public cff()
  {
    AppMethodBeat.i(91613);
    this.FtI = new LinkedList();
    AppMethodBeat.o(91613);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91614);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FtH != null)
      {
        paramVarArgs.ln(1, this.FtH.computeSize());
        this.FtH.writeFields(paramVarArgs);
      }
      if (this.DNJ != null)
      {
        paramVarArgs.ln(2, this.DNJ.computeSize());
        this.DNJ.writeFields(paramVarArgs);
      }
      if (this.DNK != null)
      {
        paramVarArgs.ln(3, this.DNK.computeSize());
        this.DNK.writeFields(paramVarArgs);
      }
      paramVarArgs.e(4, 8, this.FtI);
      if (this.FtJ != null)
      {
        paramVarArgs.ln(5, this.FtJ.computeSize());
        this.FtJ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91614);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FtH == null) {
        break label914;
      }
    }
    label914:
    for (int i = f.a.a.a.lm(1, this.FtH.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DNJ != null) {
        paramInt = i + f.a.a.a.lm(2, this.DNJ.computeSize());
      }
      i = paramInt;
      if (this.DNK != null) {
        i = paramInt + f.a.a.a.lm(3, this.DNK.computeSize());
      }
      i += f.a.a.a.c(4, 8, this.FtI);
      paramInt = i;
      if (this.FtJ != null) {
        paramInt = i + f.a.a.a.lm(5, this.FtJ.computeSize());
      }
      AppMethodBeat.o(91614);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FtI.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91614);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cff localcff = (cff)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91614);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bld();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bld)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcff.FtH = ((bld)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91614);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dhb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dhb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcff.DNJ = ((dhb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91614);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dhb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dhb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcff.DNK = ((dhb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91614);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new rp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((rp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcff.FtI.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91614);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bxn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcff.FtJ = ((bxn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91614);
        return 0;
      }
      AppMethodBeat.o(91614);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cff
 * JD-Core Version:    0.7.0.1
 */