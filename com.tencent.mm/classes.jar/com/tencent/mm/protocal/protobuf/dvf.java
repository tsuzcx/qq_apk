package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dvf
  extends cvw
{
  public int GOf;
  public bqc GOk;
  public bqd GOl;
  public int dDe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72622);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.GOf);
      paramVarArgs.aS(3, this.dDe);
      if (this.GOk != null)
      {
        paramVarArgs.lJ(4, this.GOk.computeSize());
        this.GOk.writeFields(paramVarArgs);
      }
      if (this.GOl != null)
      {
        paramVarArgs.lJ(5, this.GOl.computeSize());
        this.GOl.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72622);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label706;
      }
    }
    label706:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.GOf) + f.a.a.b.b.a.bz(3, this.dDe);
      paramInt = i;
      if (this.GOk != null) {
        paramInt = i + f.a.a.a.lI(4, this.GOk.computeSize());
      }
      i = paramInt;
      if (this.GOl != null) {
        i = paramInt + f.a.a.a.lI(5, this.GOl.computeSize());
      }
      AppMethodBeat.o(72622);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(72622);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dvf localdvf = (dvf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72622);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdvf.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72622);
          return 0;
        case 2: 
          localdvf.GOf = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(72622);
          return 0;
        case 3: 
          localdvf.dDe = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(72622);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bqc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bqc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdvf.GOk = ((bqc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72622);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bqd();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bqd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdvf.GOl = ((bqd)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72622);
        return 0;
      }
      AppMethodBeat.o(72622);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvf
 * JD-Core Version:    0.7.0.1
 */