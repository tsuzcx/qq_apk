package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bxy
  extends com.tencent.mm.bx.a
{
  public String CuA;
  public int DUA;
  public LinkedList<qp> DUB;
  public String DUC;
  public String DUD;
  public String DUx;
  public String DUy;
  public String DUz;
  
  public bxy()
  {
    AppMethodBeat.i(114047);
    this.DUB = new LinkedList();
    AppMethodBeat.o(114047);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114048);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CuA != null) {
        paramVarArgs.d(1, this.CuA);
      }
      if (this.DUx != null) {
        paramVarArgs.d(2, this.DUx);
      }
      if (this.DUy != null) {
        paramVarArgs.d(3, this.DUy);
      }
      if (this.DUz != null) {
        paramVarArgs.d(4, this.DUz);
      }
      paramVarArgs.aR(5, this.DUA);
      paramVarArgs.e(6, 8, this.DUB);
      if (this.DUC != null) {
        paramVarArgs.d(7, this.DUC);
      }
      if (this.DUD != null) {
        paramVarArgs.d(8, this.DUD);
      }
      AppMethodBeat.o(114048);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CuA == null) {
        break label706;
      }
    }
    label706:
    for (int i = f.a.a.b.b.a.e(1, this.CuA) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DUx != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DUx);
      }
      i = paramInt;
      if (this.DUy != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DUy);
      }
      paramInt = i;
      if (this.DUz != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DUz);
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.DUA) + f.a.a.a.c(6, 8, this.DUB);
      paramInt = i;
      if (this.DUC != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.DUC);
      }
      i = paramInt;
      if (this.DUD != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.DUD);
      }
      AppMethodBeat.o(114048);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DUB.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(114048);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bxy localbxy = (bxy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114048);
          return -1;
        case 1: 
          localbxy.CuA = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(114048);
          return 0;
        case 2: 
          localbxy.DUx = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(114048);
          return 0;
        case 3: 
          localbxy.DUy = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(114048);
          return 0;
        case 4: 
          localbxy.DUz = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(114048);
          return 0;
        case 5: 
          localbxy.DUA = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(114048);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new qp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((qp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbxy.DUB.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114048);
          return 0;
        case 7: 
          localbxy.DUC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(114048);
          return 0;
        }
        localbxy.DUD = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(114048);
        return 0;
      }
      AppMethodBeat.o(114048);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxy
 * JD-Core Version:    0.7.0.1
 */