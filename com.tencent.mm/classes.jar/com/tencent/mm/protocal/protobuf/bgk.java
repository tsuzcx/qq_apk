package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bgk
  extends com.tencent.mm.bx.a
{
  public int CJd;
  public String CWy;
  public String DEn;
  public cag DEo;
  public int DEp;
  public int DEq;
  public String DEr;
  public long Dbe;
  public String Duy;
  public int nrh;
  public String nsJ;
  public int state;
  public int zPz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72505);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Duy != null) {
        paramVarArgs.d(1, this.Duy);
      }
      if (this.CWy != null) {
        paramVarArgs.d(2, this.CWy);
      }
      paramVarArgs.aG(3, this.Dbe);
      paramVarArgs.aR(4, this.state);
      if (this.DEn != null) {
        paramVarArgs.d(5, this.DEn);
      }
      paramVarArgs.aR(6, this.zPz);
      if (this.DEo != null)
      {
        paramVarArgs.kX(7, this.DEo.computeSize());
        this.DEo.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(8, this.CJd);
      paramVarArgs.aR(9, this.nrh);
      paramVarArgs.aR(10, this.DEp);
      paramVarArgs.aR(11, this.DEq);
      if (this.DEr != null) {
        paramVarArgs.d(12, this.DEr);
      }
      if (this.nsJ != null) {
        paramVarArgs.d(13, this.nsJ);
      }
      AppMethodBeat.o(72505);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Duy == null) {
        break label926;
      }
    }
    label926:
    for (paramInt = f.a.a.b.b.a.e(1, this.Duy) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.CWy != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.CWy);
      }
      i = i + f.a.a.b.b.a.q(3, this.Dbe) + f.a.a.b.b.a.bA(4, this.state);
      paramInt = i;
      if (this.DEn != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.DEn);
      }
      i = paramInt + f.a.a.b.b.a.bA(6, this.zPz);
      paramInt = i;
      if (this.DEo != null) {
        paramInt = i + f.a.a.a.kW(7, this.DEo.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(8, this.CJd) + f.a.a.b.b.a.bA(9, this.nrh) + f.a.a.b.b.a.bA(10, this.DEp) + f.a.a.b.b.a.bA(11, this.DEq);
      paramInt = i;
      if (this.DEr != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.DEr);
      }
      i = paramInt;
      if (this.nsJ != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.nsJ);
      }
      AppMethodBeat.o(72505);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(72505);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bgk localbgk = (bgk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72505);
          return -1;
        case 1: 
          localbgk.Duy = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72505);
          return 0;
        case 2: 
          localbgk.CWy = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72505);
          return 0;
        case 3: 
          localbgk.Dbe = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(72505);
          return 0;
        case 4: 
          localbgk.state = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(72505);
          return 0;
        case 5: 
          localbgk.DEn = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72505);
          return 0;
        case 6: 
          localbgk.zPz = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(72505);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cag();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cag)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbgk.DEo = ((cag)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72505);
          return 0;
        case 8: 
          localbgk.CJd = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(72505);
          return 0;
        case 9: 
          localbgk.nrh = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(72505);
          return 0;
        case 10: 
          localbgk.DEp = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(72505);
          return 0;
        case 11: 
          localbgk.DEq = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(72505);
          return 0;
        case 12: 
          localbgk.DEr = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72505);
          return 0;
        }
        localbgk.nsJ = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(72505);
        return 0;
      }
      AppMethodBeat.o(72505);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgk
 * JD-Core Version:    0.7.0.1
 */