package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class byr
  extends com.tencent.mm.bx.a
{
  public String GTK;
  public String GTL;
  public String GTM;
  public int GTN;
  public String GTO;
  public tg GTP;
  public String GTQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(215422);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GTK != null) {
        paramVarArgs.d(1, this.GTK);
      }
      if (this.GTL != null) {
        paramVarArgs.d(2, this.GTL);
      }
      if (this.GTM != null) {
        paramVarArgs.d(3, this.GTM);
      }
      paramVarArgs.aS(4, this.GTN);
      if (this.GTO != null) {
        paramVarArgs.d(5, this.GTO);
      }
      if (this.GTP != null)
      {
        paramVarArgs.lC(6, this.GTP.computeSize());
        this.GTP.writeFields(paramVarArgs);
      }
      if (this.GTQ != null) {
        paramVarArgs.d(7, this.GTQ);
      }
      AppMethodBeat.o(215422);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GTK == null) {
        break label658;
      }
    }
    label658:
    for (int i = f.a.a.b.b.a.e(1, this.GTK) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GTL != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GTL);
      }
      i = paramInt;
      if (this.GTM != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GTM);
      }
      i += f.a.a.b.b.a.bz(4, this.GTN);
      paramInt = i;
      if (this.GTO != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.GTO);
      }
      i = paramInt;
      if (this.GTP != null) {
        i = paramInt + f.a.a.a.lB(6, this.GTP.computeSize());
      }
      paramInt = i;
      if (this.GTQ != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.GTQ);
      }
      AppMethodBeat.o(215422);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(215422);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        byr localbyr = (byr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(215422);
          return -1;
        case 1: 
          localbyr.GTK = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(215422);
          return 0;
        case 2: 
          localbyr.GTL = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(215422);
          return 0;
        case 3: 
          localbyr.GTM = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(215422);
          return 0;
        case 4: 
          localbyr.GTN = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(215422);
          return 0;
        case 5: 
          localbyr.GTO = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(215422);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new tg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((tg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbyr.GTP = ((tg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(215422);
          return 0;
        }
        localbyr.GTQ = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(215422);
        return 0;
      }
      AppMethodBeat.o(215422);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byr
 * JD-Core Version:    0.7.0.1
 */