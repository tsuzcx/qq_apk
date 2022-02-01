package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eif
  extends com.tencent.mm.bx.a
{
  public int FFN;
  public eic HSF;
  public int HSR;
  public boolean HSS;
  public String HST;
  public int HSU;
  public int HnE;
  public int HnG;
  public String Md5;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153341);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HSF != null)
      {
        paramVarArgs.lC(1, this.HSF.computeSize());
        this.HSF.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.HSR);
      paramVarArgs.aS(3, this.HnE);
      paramVarArgs.aS(4, this.HnG);
      paramVarArgs.bt(5, this.HSS);
      paramVarArgs.aS(6, this.FFN);
      if (this.Md5 != null) {
        paramVarArgs.d(7, this.Md5);
      }
      if (this.HST != null) {
        paramVarArgs.d(8, this.HST);
      }
      paramVarArgs.aS(9, this.HSU);
      AppMethodBeat.o(153341);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HSF == null) {
        break label690;
      }
    }
    label690:
    for (paramInt = f.a.a.a.lB(1, this.HSF.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.HSR) + f.a.a.b.b.a.bz(3, this.HnE) + f.a.a.b.b.a.bz(4, this.HnG) + f.a.a.b.b.a.alV(5) + f.a.a.b.b.a.bz(6, this.FFN);
      paramInt = i;
      if (this.Md5 != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Md5);
      }
      i = paramInt;
      if (this.HST != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.HST);
      }
      paramInt = f.a.a.b.b.a.bz(9, this.HSU);
      AppMethodBeat.o(153341);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(153341);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        eif localeif = (eif)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153341);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eic();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((eic)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localeif.HSF = ((eic)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153341);
          return 0;
        case 2: 
          localeif.HSR = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(153341);
          return 0;
        case 3: 
          localeif.HnE = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(153341);
          return 0;
        case 4: 
          localeif.HnG = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(153341);
          return 0;
        case 5: 
          localeif.HSS = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(153341);
          return 0;
        case 6: 
          localeif.FFN = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(153341);
          return 0;
        case 7: 
          localeif.Md5 = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(153341);
          return 0;
        case 8: 
          localeif.HST = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(153341);
          return 0;
        }
        localeif.HSU = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(153341);
        return 0;
      }
      AppMethodBeat.o(153341);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eif
 * JD-Core Version:    0.7.0.1
 */