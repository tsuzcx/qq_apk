package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bpe
  extends com.tencent.mm.bw.a
{
  public int CZN;
  public int FZN;
  public String GSy;
  public String GoS;
  public long Gub;
  public String HcI;
  public ckx HcJ;
  public int HcK;
  public int HcL;
  public String HcM;
  public int oEe;
  public String oFF;
  public int state;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72505);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GSy != null) {
        paramVarArgs.d(1, this.GSy);
      }
      if (this.GoS != null) {
        paramVarArgs.d(2, this.GoS);
      }
      paramVarArgs.aZ(3, this.Gub);
      paramVarArgs.aS(4, this.state);
      if (this.HcI != null) {
        paramVarArgs.d(5, this.HcI);
      }
      paramVarArgs.aS(6, this.CZN);
      if (this.HcJ != null)
      {
        paramVarArgs.lJ(7, this.HcJ.computeSize());
        this.HcJ.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(8, this.FZN);
      paramVarArgs.aS(9, this.oEe);
      paramVarArgs.aS(10, this.HcK);
      paramVarArgs.aS(11, this.HcL);
      if (this.HcM != null) {
        paramVarArgs.d(12, this.HcM);
      }
      if (this.oFF != null) {
        paramVarArgs.d(13, this.oFF);
      }
      AppMethodBeat.o(72505);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GSy == null) {
        break label926;
      }
    }
    label926:
    for (paramInt = f.a.a.b.b.a.e(1, this.GSy) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GoS != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.GoS);
      }
      i = i + f.a.a.b.b.a.p(3, this.Gub) + f.a.a.b.b.a.bz(4, this.state);
      paramInt = i;
      if (this.HcI != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.HcI);
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.CZN);
      paramInt = i;
      if (this.HcJ != null) {
        paramInt = i + f.a.a.a.lI(7, this.HcJ.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(8, this.FZN) + f.a.a.b.b.a.bz(9, this.oEe) + f.a.a.b.b.a.bz(10, this.HcK) + f.a.a.b.b.a.bz(11, this.HcL);
      paramInt = i;
      if (this.HcM != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.HcM);
      }
      i = paramInt;
      if (this.oFF != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.oFF);
      }
      AppMethodBeat.o(72505);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(72505);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bpe localbpe = (bpe)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72505);
          return -1;
        case 1: 
          localbpe.GSy = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72505);
          return 0;
        case 2: 
          localbpe.GoS = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72505);
          return 0;
        case 3: 
          localbpe.Gub = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(72505);
          return 0;
        case 4: 
          localbpe.state = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(72505);
          return 0;
        case 5: 
          localbpe.HcI = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72505);
          return 0;
        case 6: 
          localbpe.CZN = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(72505);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ckx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ckx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbpe.HcJ = ((ckx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72505);
          return 0;
        case 8: 
          localbpe.FZN = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(72505);
          return 0;
        case 9: 
          localbpe.oEe = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(72505);
          return 0;
        case 10: 
          localbpe.HcK = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(72505);
          return 0;
        case 11: 
          localbpe.HcL = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(72505);
          return 0;
        case 12: 
          localbpe.HcM = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72505);
          return 0;
        }
        localbpe.oFF = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(72505);
        return 0;
      }
      AppMethodBeat.o(72505);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpe
 * JD-Core Version:    0.7.0.1
 */