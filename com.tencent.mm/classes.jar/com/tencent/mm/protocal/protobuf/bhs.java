package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bhs
  extends com.tencent.mm.bx.a
{
  public String DFA;
  public abl DFB;
  public abl DFC;
  public String DFD;
  public String DFE;
  public String DFz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72509);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DFz != null) {
        paramVarArgs.d(1, this.DFz);
      }
      if (this.DFA != null) {
        paramVarArgs.d(2, this.DFA);
      }
      if (this.DFB != null)
      {
        paramVarArgs.kX(3, this.DFB.computeSize());
        this.DFB.writeFields(paramVarArgs);
      }
      if (this.DFC != null)
      {
        paramVarArgs.kX(4, this.DFC.computeSize());
        this.DFC.writeFields(paramVarArgs);
      }
      if (this.DFD != null) {
        paramVarArgs.d(5, this.DFD);
      }
      if (this.DFE != null) {
        paramVarArgs.d(6, this.DFE);
      }
      AppMethodBeat.o(72509);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DFz == null) {
        break label706;
      }
    }
    label706:
    for (int i = f.a.a.b.b.a.e(1, this.DFz) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DFA != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DFA);
      }
      i = paramInt;
      if (this.DFB != null) {
        i = paramInt + f.a.a.a.kW(3, this.DFB.computeSize());
      }
      paramInt = i;
      if (this.DFC != null) {
        paramInt = i + f.a.a.a.kW(4, this.DFC.computeSize());
      }
      i = paramInt;
      if (this.DFD != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.DFD);
      }
      paramInt = i;
      if (this.DFE != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DFE);
      }
      AppMethodBeat.o(72509);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(72509);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bhs localbhs = (bhs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72509);
          return -1;
        case 1: 
          localbhs.DFz = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72509);
          return 0;
        case 2: 
          localbhs.DFA = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72509);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new abl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((abl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbhs.DFB = ((abl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72509);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new abl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((abl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbhs.DFC = ((abl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72509);
          return 0;
        case 5: 
          localbhs.DFD = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72509);
          return 0;
        }
        localbhs.DFE = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(72509);
        return 0;
      }
      AppMethodBeat.o(72509);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bhs
 * JD-Core Version:    0.7.0.1
 */