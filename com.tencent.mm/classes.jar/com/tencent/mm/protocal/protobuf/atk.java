package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class atk
  extends com.tencent.mm.bx.a
{
  public dno Grv;
  public String Grw = "";
  public int Grx = 0;
  public long timestamp = 0L;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122492);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Grv != null)
      {
        paramVarArgs.lC(1, this.Grv.computeSize());
        this.Grv.writeFields(paramVarArgs);
      }
      if (this.Grw != null) {
        paramVarArgs.d(2, this.Grw);
      }
      paramVarArgs.aY(3, this.timestamp);
      paramVarArgs.aS(4, this.Grx);
      AppMethodBeat.o(122492);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Grv == null) {
        break label462;
      }
    }
    label462:
    for (paramInt = f.a.a.a.lB(1, this.Grv.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Grw != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Grw);
      }
      paramInt = f.a.a.b.b.a.p(3, this.timestamp);
      int j = f.a.a.b.b.a.bz(4, this.Grx);
      AppMethodBeat.o(122492);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(122492);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        atk localatk = (atk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122492);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dno();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dno)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localatk.Grv = ((dno)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122492);
          return 0;
        case 2: 
          localatk.Grw = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(122492);
          return 0;
        case 3: 
          localatk.timestamp = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(122492);
          return 0;
        }
        localatk.Grx = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(122492);
        return 0;
      }
      AppMethodBeat.o(122492);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.atk
 * JD-Core Version:    0.7.0.1
 */