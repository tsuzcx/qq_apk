package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ebz
  extends com.tencent.mm.bw.a
{
  public int Eae;
  public int FDr;
  public int FDt;
  public int GhD;
  public boolean GhE;
  public String GhF;
  public int GhG;
  public ebw Ghr;
  public String Md5;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153341);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Ghr != null)
      {
        paramVarArgs.ln(1, this.Ghr.computeSize());
        this.Ghr.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.GhD);
      paramVarArgs.aR(3, this.FDr);
      paramVarArgs.aR(4, this.FDt);
      paramVarArgs.bl(5, this.GhE);
      paramVarArgs.aR(6, this.Eae);
      if (this.Md5 != null) {
        paramVarArgs.d(7, this.Md5);
      }
      if (this.GhF != null) {
        paramVarArgs.d(8, this.GhF);
      }
      paramVarArgs.aR(9, this.GhG);
      AppMethodBeat.o(153341);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Ghr == null) {
        break label694;
      }
    }
    label694:
    for (paramInt = f.a.a.a.lm(1, this.Ghr.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.GhD) + f.a.a.b.b.a.bx(3, this.FDr) + f.a.a.b.b.a.bx(4, this.FDt) + (f.a.a.b.b.a.fK(5) + 1) + f.a.a.b.b.a.bx(6, this.Eae);
      paramInt = i;
      if (this.Md5 != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Md5);
      }
      i = paramInt;
      if (this.GhF != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.GhF);
      }
      paramInt = f.a.a.b.b.a.bx(9, this.GhG);
      AppMethodBeat.o(153341);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(153341);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ebz localebz = (ebz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153341);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ebw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ebw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localebz.Ghr = ((ebw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153341);
          return 0;
        case 2: 
          localebz.GhD = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(153341);
          return 0;
        case 3: 
          localebz.FDr = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(153341);
          return 0;
        case 4: 
          localebz.FDt = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(153341);
          return 0;
        case 5: 
          localebz.GhE = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(153341);
          return 0;
        case 6: 
          localebz.Eae = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(153341);
          return 0;
        case 7: 
          localebz.Md5 = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(153341);
          return 0;
        case 8: 
          localebz.GhF = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(153341);
          return 0;
        }
        localebz.GhG = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(153341);
        return 0;
      }
      AppMethodBeat.o(153341);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ebz
 * JD-Core Version:    0.7.0.1
 */