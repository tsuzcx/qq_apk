package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bqh
  extends com.tencent.mm.bx.a
{
  public String FBS;
  public dmo GKF;
  public LinkedList<dlu> GKG;
  public dmo GKH;
  
  public bqh()
  {
    AppMethodBeat.i(91526);
    this.GKG = new LinkedList();
    AppMethodBeat.o(91526);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91527);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GKF != null)
      {
        paramVarArgs.lC(1, this.GKF.computeSize());
        this.GKF.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.GKG);
      if (this.GKH != null)
      {
        paramVarArgs.lC(3, this.GKH.computeSize());
        this.GKH.writeFields(paramVarArgs);
      }
      if (this.FBS != null) {
        paramVarArgs.d(4, this.FBS);
      }
      AppMethodBeat.o(91527);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GKF == null) {
        break label666;
      }
    }
    label666:
    for (paramInt = f.a.a.a.lB(1, this.GKF.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.GKG);
      paramInt = i;
      if (this.GKH != null) {
        paramInt = i + f.a.a.a.lB(3, this.GKH.computeSize());
      }
      i = paramInt;
      if (this.FBS != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.FBS);
      }
      AppMethodBeat.o(91527);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GKG.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91527);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bqh localbqh = (bqh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91527);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dmo();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dmo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbqh.GKF = ((dmo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91527);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dlu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dlu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbqh.GKG.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91527);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dmo();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dmo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbqh.GKH = ((dmo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91527);
          return 0;
        }
        localbqh.FBS = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91527);
        return 0;
      }
      AppMethodBeat.o(91527);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bqh
 * JD-Core Version:    0.7.0.1
 */