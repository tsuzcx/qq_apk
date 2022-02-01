package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cwp
  extends com.tencent.mm.bx.a
{
  public String FBS;
  public dmo Gav;
  public che Hor;
  public float Hos;
  public long Hot;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91675);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FBS != null) {
        paramVarArgs.d(1, this.FBS);
      }
      if (this.Gav != null)
      {
        paramVarArgs.lC(2, this.Gav.computeSize());
        this.Gav.writeFields(paramVarArgs);
      }
      if (this.Hor != null)
      {
        paramVarArgs.lC(3, this.Hor.computeSize());
        this.Hor.writeFields(paramVarArgs);
      }
      paramVarArgs.z(4, this.Hos);
      paramVarArgs.aY(5, this.Hot);
      AppMethodBeat.o(91675);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FBS == null) {
        break label613;
      }
    }
    label613:
    for (int i = f.a.a.b.b.a.e(1, this.FBS) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Gav != null) {
        paramInt = i + f.a.a.a.lB(2, this.Gav.computeSize());
      }
      i = paramInt;
      if (this.Hor != null) {
        i = paramInt + f.a.a.a.lB(3, this.Hor.computeSize());
      }
      paramInt = f.a.a.b.b.a.alU(4);
      int j = f.a.a.b.b.a.p(5, this.Hot);
      AppMethodBeat.o(91675);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91675);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cwp localcwp = (cwp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91675);
          return -1;
        case 1: 
          localcwp.FBS = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91675);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dmo();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dmo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcwp.Gav = ((dmo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91675);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new che();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((che)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcwp.Hor = ((che)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91675);
          return 0;
        case 4: 
          localcwp.Hos = Float.intBitsToFloat(((f.a.a.a.a)localObject1).NPN.grz());
          AppMethodBeat.o(91675);
          return 0;
        }
        localcwp.Hot = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(91675);
        return 0;
      }
      AppMethodBeat.o(91675);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cwp
 * JD-Core Version:    0.7.0.1
 */