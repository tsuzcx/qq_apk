package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cbx
  extends com.tencent.mm.bx.a
{
  public bpn FNe;
  public dmo Gav;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91551);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FNe != null)
      {
        paramVarArgs.lC(1, this.FNe.computeSize());
        this.FNe.writeFields(paramVarArgs);
      }
      if (this.Gav != null)
      {
        paramVarArgs.lC(2, this.Gav.computeSize());
        this.Gav.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.type);
      AppMethodBeat.o(91551);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FNe == null) {
        break label510;
      }
    }
    label510:
    for (paramInt = f.a.a.a.lB(1, this.FNe.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Gav != null) {
        i = paramInt + f.a.a.a.lB(2, this.Gav.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(3, this.type);
      AppMethodBeat.o(91551);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91551);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cbx localcbx = (cbx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91551);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bpn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bpn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcbx.FNe = ((bpn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91551);
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
            localcbx.Gav = ((dmo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91551);
          return 0;
        }
        localcbx.type = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(91551);
        return 0;
      }
      AppMethodBeat.o(91551);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbx
 * JD-Core Version:    0.7.0.1
 */