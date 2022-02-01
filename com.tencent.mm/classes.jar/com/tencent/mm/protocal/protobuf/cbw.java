package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cbw
  extends com.tencent.mm.bw.a
{
  public int Gaz;
  public int HFB;
  public String LWD;
  public String LjD;
  public long LpD;
  public String MhL;
  public dbf MhM;
  public int MhN;
  public int MhO;
  public String MhP;
  public int pRN;
  public String pTn;
  public int state;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72505);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LWD != null) {
        paramVarArgs.e(1, this.LWD);
      }
      if (this.LjD != null) {
        paramVarArgs.e(2, this.LjD);
      }
      paramVarArgs.bb(3, this.LpD);
      paramVarArgs.aM(4, this.state);
      if (this.MhL != null) {
        paramVarArgs.e(5, this.MhL);
      }
      paramVarArgs.aM(6, this.HFB);
      if (this.MhM != null)
      {
        paramVarArgs.ni(7, this.MhM.computeSize());
        this.MhM.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(8, this.Gaz);
      paramVarArgs.aM(9, this.pRN);
      paramVarArgs.aM(10, this.MhN);
      paramVarArgs.aM(11, this.MhO);
      if (this.MhP != null) {
        paramVarArgs.e(12, this.MhP);
      }
      if (this.pTn != null) {
        paramVarArgs.e(13, this.pTn);
      }
      AppMethodBeat.o(72505);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LWD == null) {
        break label926;
      }
    }
    label926:
    for (paramInt = g.a.a.b.b.a.f(1, this.LWD) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.LjD != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.LjD);
      }
      i = i + g.a.a.b.b.a.r(3, this.LpD) + g.a.a.b.b.a.bu(4, this.state);
      paramInt = i;
      if (this.MhL != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.MhL);
      }
      i = paramInt + g.a.a.b.b.a.bu(6, this.HFB);
      paramInt = i;
      if (this.MhM != null) {
        paramInt = i + g.a.a.a.nh(7, this.MhM.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(8, this.Gaz) + g.a.a.b.b.a.bu(9, this.pRN) + g.a.a.b.b.a.bu(10, this.MhN) + g.a.a.b.b.a.bu(11, this.MhO);
      paramInt = i;
      if (this.MhP != null) {
        paramInt = i + g.a.a.b.b.a.f(12, this.MhP);
      }
      i = paramInt;
      if (this.pTn != null) {
        i = paramInt + g.a.a.b.b.a.f(13, this.pTn);
      }
      AppMethodBeat.o(72505);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(72505);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cbw localcbw = (cbw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72505);
          return -1;
        case 1: 
          localcbw.LWD = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72505);
          return 0;
        case 2: 
          localcbw.LjD = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72505);
          return 0;
        case 3: 
          localcbw.LpD = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(72505);
          return 0;
        case 4: 
          localcbw.state = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(72505);
          return 0;
        case 5: 
          localcbw.MhL = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72505);
          return 0;
        case 6: 
          localcbw.HFB = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(72505);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dbf();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dbf)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcbw.MhM = ((dbf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72505);
          return 0;
        case 8: 
          localcbw.Gaz = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(72505);
          return 0;
        case 9: 
          localcbw.pRN = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(72505);
          return 0;
        case 10: 
          localcbw.MhN = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(72505);
          return 0;
        case 11: 
          localcbw.MhO = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(72505);
          return 0;
        case 12: 
          localcbw.MhP = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72505);
          return 0;
        }
        localcbw.pTn = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(72505);
        return 0;
      }
      AppMethodBeat.o(72505);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbw
 * JD-Core Version:    0.7.0.1
 */