package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ebo
  extends com.tencent.mm.bw.a
{
  public ebk Ihf;
  public eba Ihg;
  public String Ihh;
  public String Ihi;
  public String Ihj;
  public int Ihk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147809);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Ihf != null)
      {
        paramVarArgs.lJ(1, this.Ihf.computeSize());
        this.Ihf.writeFields(paramVarArgs);
      }
      if (this.Ihg != null)
      {
        paramVarArgs.lJ(2, this.Ihg.computeSize());
        this.Ihg.writeFields(paramVarArgs);
      }
      if (this.Ihh != null) {
        paramVarArgs.d(3, this.Ihh);
      }
      if (this.Ihi != null) {
        paramVarArgs.d(4, this.Ihi);
      }
      if (this.Ihj != null) {
        paramVarArgs.d(5, this.Ihj);
      }
      paramVarArgs.aS(6, this.Ihk);
      AppMethodBeat.o(147809);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Ihf == null) {
        break label690;
      }
    }
    label690:
    for (int i = f.a.a.a.lI(1, this.Ihf.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Ihg != null) {
        paramInt = i + f.a.a.a.lI(2, this.Ihg.computeSize());
      }
      i = paramInt;
      if (this.Ihh != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Ihh);
      }
      paramInt = i;
      if (this.Ihi != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Ihi);
      }
      i = paramInt;
      if (this.Ihj != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Ihj);
      }
      paramInt = f.a.a.b.b.a.bz(6, this.Ihk);
      AppMethodBeat.o(147809);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(147809);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ebo localebo = (ebo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(147809);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ebk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ebk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localebo.Ihf = ((ebk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(147809);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eba();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eba)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localebo.Ihg = ((eba)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(147809);
          return 0;
        case 3: 
          localebo.Ihh = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(147809);
          return 0;
        case 4: 
          localebo.Ihi = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(147809);
          return 0;
        case 5: 
          localebo.Ihj = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(147809);
          return 0;
        }
        localebo.Ihk = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(147809);
        return 0;
      }
      AppMethodBeat.o(147809);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ebo
 * JD-Core Version:    0.7.0.1
 */