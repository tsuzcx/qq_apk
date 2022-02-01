package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bxz
  extends com.tencent.mm.bx.a
{
  public String DUE;
  public String DUF;
  public String DUG;
  public int DUH;
  public String DUI;
  public rc DUJ;
  public String DUK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114049);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DUE != null) {
        paramVarArgs.d(1, this.DUE);
      }
      if (this.DUF != null) {
        paramVarArgs.d(2, this.DUF);
      }
      if (this.DUG != null) {
        paramVarArgs.d(3, this.DUG);
      }
      paramVarArgs.aR(4, this.DUH);
      if (this.DUI != null) {
        paramVarArgs.d(5, this.DUI);
      }
      if (this.DUJ != null)
      {
        paramVarArgs.kX(6, this.DUJ.computeSize());
        this.DUJ.writeFields(paramVarArgs);
      }
      if (this.DUK != null) {
        paramVarArgs.d(7, this.DUK);
      }
      AppMethodBeat.o(114049);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DUE == null) {
        break label658;
      }
    }
    label658:
    for (int i = f.a.a.b.b.a.e(1, this.DUE) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DUF != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DUF);
      }
      i = paramInt;
      if (this.DUG != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DUG);
      }
      i += f.a.a.b.b.a.bA(4, this.DUH);
      paramInt = i;
      if (this.DUI != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.DUI);
      }
      i = paramInt;
      if (this.DUJ != null) {
        i = paramInt + f.a.a.a.kW(6, this.DUJ.computeSize());
      }
      paramInt = i;
      if (this.DUK != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.DUK);
      }
      AppMethodBeat.o(114049);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(114049);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bxz localbxz = (bxz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114049);
          return -1;
        case 1: 
          localbxz.DUE = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(114049);
          return 0;
        case 2: 
          localbxz.DUF = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(114049);
          return 0;
        case 3: 
          localbxz.DUG = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(114049);
          return 0;
        case 4: 
          localbxz.DUH = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(114049);
          return 0;
        case 5: 
          localbxz.DUI = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(114049);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new rc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((rc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbxz.DUJ = ((rc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114049);
          return 0;
        }
        localbxz.DUK = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(114049);
        return 0;
      }
      AppMethodBeat.o(114049);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxz
 * JD-Core Version:    0.7.0.1
 */