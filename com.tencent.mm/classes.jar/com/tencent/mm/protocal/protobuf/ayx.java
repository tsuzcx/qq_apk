package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ayx
  extends com.tencent.mm.bx.a
{
  public String GvZ;
  public uv Gwf;
  public String Gwg;
  public boolean Gwh;
  public int Gwi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114024);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Gwf != null)
      {
        paramVarArgs.lC(1, this.Gwf.computeSize());
        this.Gwf.writeFields(paramVarArgs);
      }
      if (this.GvZ != null) {
        paramVarArgs.d(2, this.GvZ);
      }
      if (this.Gwg != null) {
        paramVarArgs.d(3, this.Gwg);
      }
      paramVarArgs.bt(4, this.Gwh);
      paramVarArgs.aS(5, this.Gwi);
      AppMethodBeat.o(114024);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Gwf == null) {
        break label518;
      }
    }
    label518:
    for (int i = f.a.a.a.lB(1, this.Gwf.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GvZ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GvZ);
      }
      i = paramInt;
      if (this.Gwg != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Gwg);
      }
      paramInt = f.a.a.b.b.a.alV(4);
      int j = f.a.a.b.b.a.bz(5, this.Gwi);
      AppMethodBeat.o(114024);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(114024);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ayx localayx = (ayx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114024);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new uv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((uv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localayx.Gwf = ((uv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114024);
          return 0;
        case 2: 
          localayx.GvZ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(114024);
          return 0;
        case 3: 
          localayx.Gwg = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(114024);
          return 0;
        case 4: 
          localayx.Gwh = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(114024);
          return 0;
        }
        localayx.Gwi = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(114024);
        return 0;
      }
      AppMethodBeat.o(114024);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ayx
 * JD-Core Version:    0.7.0.1
 */