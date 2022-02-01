package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bpu
  extends com.tencent.mm.bx.a
{
  public String GKs;
  public String GKt;
  public aek GKu;
  public aek GKv;
  public String GKw;
  public String GKx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72509);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GKs != null) {
        paramVarArgs.d(1, this.GKs);
      }
      if (this.GKt != null) {
        paramVarArgs.d(2, this.GKt);
      }
      if (this.GKu != null)
      {
        paramVarArgs.lC(3, this.GKu.computeSize());
        this.GKu.writeFields(paramVarArgs);
      }
      if (this.GKv != null)
      {
        paramVarArgs.lC(4, this.GKv.computeSize());
        this.GKv.writeFields(paramVarArgs);
      }
      if (this.GKw != null) {
        paramVarArgs.d(5, this.GKw);
      }
      if (this.GKx != null) {
        paramVarArgs.d(6, this.GKx);
      }
      AppMethodBeat.o(72509);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GKs == null) {
        break label706;
      }
    }
    label706:
    for (int i = f.a.a.b.b.a.e(1, this.GKs) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GKt != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GKt);
      }
      i = paramInt;
      if (this.GKu != null) {
        i = paramInt + f.a.a.a.lB(3, this.GKu.computeSize());
      }
      paramInt = i;
      if (this.GKv != null) {
        paramInt = i + f.a.a.a.lB(4, this.GKv.computeSize());
      }
      i = paramInt;
      if (this.GKw != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.GKw);
      }
      paramInt = i;
      if (this.GKx != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GKx);
      }
      AppMethodBeat.o(72509);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(72509);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bpu localbpu = (bpu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72509);
          return -1;
        case 1: 
          localbpu.GKs = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72509);
          return 0;
        case 2: 
          localbpu.GKt = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72509);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aek();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aek)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbpu.GKu = ((aek)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72509);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aek();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aek)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbpu.GKv = ((aek)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72509);
          return 0;
        case 5: 
          localbpu.GKw = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72509);
          return 0;
        }
        localbpu.GKx = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(72509);
        return 0;
      }
      AppMethodBeat.o(72509);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpu
 * JD-Core Version:    0.7.0.1
 */