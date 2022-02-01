package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class sz
  extends com.tencent.mm.bw.a
{
  public String GiX;
  public int GiY;
  public String GiZ;
  public ti Gja;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113956);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GiX != null) {
        paramVarArgs.d(1, this.GiX);
      }
      paramVarArgs.aS(2, this.GiY);
      if (this.GiZ != null) {
        paramVarArgs.d(3, this.GiZ);
      }
      if (this.Gja != null)
      {
        paramVarArgs.lJ(4, this.Gja.computeSize());
        this.Gja.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(113956);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GiX == null) {
        break label474;
      }
    }
    label474:
    for (paramInt = f.a.a.b.b.a.e(1, this.GiX) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.GiY);
      paramInt = i;
      if (this.GiZ != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.GiZ);
      }
      i = paramInt;
      if (this.Gja != null) {
        i = paramInt + f.a.a.a.lI(4, this.Gja.computeSize());
      }
      AppMethodBeat.o(113956);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(113956);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        sz localsz = (sz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113956);
          return -1;
        case 1: 
          localsz.GiX = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(113956);
          return 0;
        case 2: 
          localsz.GiY = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(113956);
          return 0;
        case 3: 
          localsz.GiZ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(113956);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ti();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((ti)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localsz.Gja = ((ti)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113956);
        return 0;
      }
      AppMethodBeat.o(113956);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sz
 * JD-Core Version:    0.7.0.1
 */