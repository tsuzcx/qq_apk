package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ama
  extends com.tencent.mm.bx.a
{
  public bxx Dne;
  public String Dnf;
  public bxx Dng;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122491);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Dne != null)
      {
        paramVarArgs.kX(1, this.Dne.computeSize());
        this.Dne.writeFields(paramVarArgs);
      }
      if (this.Dnf != null) {
        paramVarArgs.d(2, this.Dnf);
      }
      if (this.Dng != null)
      {
        paramVarArgs.kX(3, this.Dng.computeSize());
        this.Dng.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(122491);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Dne == null) {
        break label526;
      }
    }
    label526:
    for (int i = f.a.a.a.kW(1, this.Dne.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Dnf != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Dnf);
      }
      i = paramInt;
      if (this.Dng != null) {
        i = paramInt + f.a.a.a.kW(3, this.Dng.computeSize());
      }
      AppMethodBeat.o(122491);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(122491);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ama localama = (ama)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122491);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bxx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bxx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localama.Dne = ((bxx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122491);
          return 0;
        case 2: 
          localama.Dnf = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(122491);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bxx();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bxx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localama.Dng = ((bxx)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122491);
        return 0;
      }
      AppMethodBeat.o(122491);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ama
 * JD-Core Version:    0.7.0.1
 */