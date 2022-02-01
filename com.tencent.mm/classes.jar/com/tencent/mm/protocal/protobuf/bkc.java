package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bkc
  extends com.tencent.mm.bw.a
{
  public int BhT;
  public String EPH;
  public String EZI;
  public cfe EZJ;
  public int EZK;
  public int EZL;
  public String EZM;
  public int EbF;
  public String Eph;
  public long Eub;
  public int nUh;
  public String nVJ;
  public int state;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72505);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EPH != null) {
        paramVarArgs.d(1, this.EPH);
      }
      if (this.Eph != null) {
        paramVarArgs.d(2, this.Eph);
      }
      paramVarArgs.aO(3, this.Eub);
      paramVarArgs.aR(4, this.state);
      if (this.EZI != null) {
        paramVarArgs.d(5, this.EZI);
      }
      paramVarArgs.aR(6, this.BhT);
      if (this.EZJ != null)
      {
        paramVarArgs.ln(7, this.EZJ.computeSize());
        this.EZJ.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(8, this.EbF);
      paramVarArgs.aR(9, this.nUh);
      paramVarArgs.aR(10, this.EZK);
      paramVarArgs.aR(11, this.EZL);
      if (this.EZM != null) {
        paramVarArgs.d(12, this.EZM);
      }
      if (this.nVJ != null) {
        paramVarArgs.d(13, this.nVJ);
      }
      AppMethodBeat.o(72505);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EPH == null) {
        break label926;
      }
    }
    label926:
    for (paramInt = f.a.a.b.b.a.e(1, this.EPH) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Eph != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Eph);
      }
      i = i + f.a.a.b.b.a.p(3, this.Eub) + f.a.a.b.b.a.bx(4, this.state);
      paramInt = i;
      if (this.EZI != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.EZI);
      }
      i = paramInt + f.a.a.b.b.a.bx(6, this.BhT);
      paramInt = i;
      if (this.EZJ != null) {
        paramInt = i + f.a.a.a.lm(7, this.EZJ.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(8, this.EbF) + f.a.a.b.b.a.bx(9, this.nUh) + f.a.a.b.b.a.bx(10, this.EZK) + f.a.a.b.b.a.bx(11, this.EZL);
      paramInt = i;
      if (this.EZM != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.EZM);
      }
      i = paramInt;
      if (this.nVJ != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.nVJ);
      }
      AppMethodBeat.o(72505);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(72505);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bkc localbkc = (bkc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72505);
          return -1;
        case 1: 
          localbkc.EPH = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72505);
          return 0;
        case 2: 
          localbkc.Eph = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72505);
          return 0;
        case 3: 
          localbkc.Eub = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(72505);
          return 0;
        case 4: 
          localbkc.state = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(72505);
          return 0;
        case 5: 
          localbkc.EZI = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72505);
          return 0;
        case 6: 
          localbkc.BhT = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(72505);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cfe();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cfe)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbkc.EZJ = ((cfe)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72505);
          return 0;
        case 8: 
          localbkc.EbF = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(72505);
          return 0;
        case 9: 
          localbkc.nUh = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(72505);
          return 0;
        case 10: 
          localbkc.EZK = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(72505);
          return 0;
        case 11: 
          localbkc.EZL = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(72505);
          return 0;
        case 12: 
          localbkc.EZM = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72505);
          return 0;
        }
        localbkc.nVJ = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(72505);
        return 0;
      }
      AppMethodBeat.o(72505);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bkc
 * JD-Core Version:    0.7.0.1
 */