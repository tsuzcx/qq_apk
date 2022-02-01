package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bqn
  extends com.tencent.mm.bw.a
{
  public String HdT;
  public String HdU;
  public aet HdV;
  public aet HdW;
  public String HdX;
  public String HdY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72509);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HdT != null) {
        paramVarArgs.d(1, this.HdT);
      }
      if (this.HdU != null) {
        paramVarArgs.d(2, this.HdU);
      }
      if (this.HdV != null)
      {
        paramVarArgs.lJ(3, this.HdV.computeSize());
        this.HdV.writeFields(paramVarArgs);
      }
      if (this.HdW != null)
      {
        paramVarArgs.lJ(4, this.HdW.computeSize());
        this.HdW.writeFields(paramVarArgs);
      }
      if (this.HdX != null) {
        paramVarArgs.d(5, this.HdX);
      }
      if (this.HdY != null) {
        paramVarArgs.d(6, this.HdY);
      }
      AppMethodBeat.o(72509);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HdT == null) {
        break label706;
      }
    }
    label706:
    for (int i = f.a.a.b.b.a.e(1, this.HdT) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HdU != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HdU);
      }
      i = paramInt;
      if (this.HdV != null) {
        i = paramInt + f.a.a.a.lI(3, this.HdV.computeSize());
      }
      paramInt = i;
      if (this.HdW != null) {
        paramInt = i + f.a.a.a.lI(4, this.HdW.computeSize());
      }
      i = paramInt;
      if (this.HdX != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.HdX);
      }
      paramInt = i;
      if (this.HdY != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.HdY);
      }
      AppMethodBeat.o(72509);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(72509);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bqn localbqn = (bqn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72509);
          return -1;
        case 1: 
          localbqn.HdT = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72509);
          return 0;
        case 2: 
          localbqn.HdU = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72509);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aet();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aet)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbqn.HdV = ((aet)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72509);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aet();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aet)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbqn.HdW = ((aet)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72509);
          return 0;
        case 5: 
          localbqn.HdX = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72509);
          return 0;
        }
        localbqn.HdY = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(72509);
        return 0;
      }
      AppMethodBeat.o(72509);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bqn
 * JD-Core Version:    0.7.0.1
 */