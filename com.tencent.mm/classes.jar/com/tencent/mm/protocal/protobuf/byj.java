package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class byj
  extends com.tencent.mm.bx.a
{
  public String CLI;
  public String CzY;
  public int DLD;
  public ble DLE;
  public String DVa;
  public String DVb;
  public int DVc;
  public int DVd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117889);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CLI != null) {
        paramVarArgs.d(1, this.CLI);
      }
      if (this.DLE != null)
      {
        paramVarArgs.kX(2, this.DLE.computeSize());
        this.DLE.writeFields(paramVarArgs);
      }
      if (this.CzY != null) {
        paramVarArgs.d(3, this.CzY);
      }
      if (this.DVb != null) {
        paramVarArgs.d(4, this.DVb);
      }
      if (this.DVa != null) {
        paramVarArgs.d(5, this.DVa);
      }
      paramVarArgs.aR(6, this.DVc);
      paramVarArgs.aR(7, this.DLD);
      paramVarArgs.aR(8, this.DVd);
      AppMethodBeat.o(117889);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CLI == null) {
        break label694;
      }
    }
    label694:
    for (int i = f.a.a.b.b.a.e(1, this.CLI) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DLE != null) {
        paramInt = i + f.a.a.a.kW(2, this.DLE.computeSize());
      }
      i = paramInt;
      if (this.CzY != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.CzY);
      }
      paramInt = i;
      if (this.DVb != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DVb);
      }
      i = paramInt;
      if (this.DVa != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.DVa);
      }
      paramInt = f.a.a.b.b.a.bA(6, this.DVc);
      int j = f.a.a.b.b.a.bA(7, this.DLD);
      int k = f.a.a.b.b.a.bA(8, this.DVd);
      AppMethodBeat.o(117889);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(117889);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        byj localbyj = (byj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117889);
          return -1;
        case 1: 
          localbyj.CLI = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(117889);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ble();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ble)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbyj.DLE = ((ble)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117889);
          return 0;
        case 3: 
          localbyj.CzY = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(117889);
          return 0;
        case 4: 
          localbyj.DVb = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(117889);
          return 0;
        case 5: 
          localbyj.DVa = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(117889);
          return 0;
        case 6: 
          localbyj.DVc = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(117889);
          return 0;
        case 7: 
          localbyj.DLD = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(117889);
          return 0;
        }
        localbyj.DVd = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(117889);
        return 0;
      }
      AppMethodBeat.o(117889);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byj
 * JD-Core Version:    0.7.0.1
 */