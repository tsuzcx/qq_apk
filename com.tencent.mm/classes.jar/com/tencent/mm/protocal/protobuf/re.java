package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class re
  extends com.tencent.mm.bx.a
{
  public int CQX;
  public String CQY;
  public String CQZ;
  public String CRa;
  public int CRb;
  public String CRc;
  public rc CRd;
  public String CRe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113967);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.CQX);
      if (this.CQY != null) {
        paramVarArgs.d(2, this.CQY);
      }
      if (this.CQZ != null) {
        paramVarArgs.d(3, this.CQZ);
      }
      if (this.CRa != null) {
        paramVarArgs.d(4, this.CRa);
      }
      paramVarArgs.aR(5, this.CRb);
      if (this.CRc != null) {
        paramVarArgs.d(6, this.CRc);
      }
      if (this.CRd != null)
      {
        paramVarArgs.kX(7, this.CRd.computeSize());
        this.CRd.writeFields(paramVarArgs);
      }
      if (this.CRe != null) {
        paramVarArgs.d(8, this.CRe);
      }
      AppMethodBeat.o(113967);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.CQX) + 0;
      paramInt = i;
      if (this.CQY != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.CQY);
      }
      i = paramInt;
      if (this.CQZ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.CQZ);
      }
      paramInt = i;
      if (this.CRa != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.CRa);
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.CRb);
      paramInt = i;
      if (this.CRc != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.CRc);
      }
      i = paramInt;
      if (this.CRd != null) {
        i = paramInt + f.a.a.a.kW(7, this.CRd.computeSize());
      }
      paramInt = i;
      if (this.CRe != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.CRe);
      }
      AppMethodBeat.o(113967);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(113967);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      re localre = (re)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(113967);
        return -1;
      case 1: 
        localre.CQX = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(113967);
        return 0;
      case 2: 
        localre.CQY = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(113967);
        return 0;
      case 3: 
        localre.CQZ = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(113967);
        return 0;
      case 4: 
        localre.CRa = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(113967);
        return 0;
      case 5: 
        localre.CRb = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(113967);
        return 0;
      case 6: 
        localre.CRc = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(113967);
        return 0;
      case 7: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new rc();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((rc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localre.CRd = ((rc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113967);
        return 0;
      }
      localre.CRe = ((f.a.a.a.a)localObject1).KhF.readString();
      AppMethodBeat.o(113967);
      return 0;
    }
    AppMethodBeat.o(113967);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.re
 * JD-Core Version:    0.7.0.1
 */