package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cdf
  extends com.tencent.mm.bw.a
{
  public String DSu;
  public String Eel;
  public int FhS;
  public bpa FhT;
  public String FrO;
  public String FrP;
  public int FrQ;
  public int FrR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117889);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Eel != null) {
        paramVarArgs.d(1, this.Eel);
      }
      if (this.FhT != null)
      {
        paramVarArgs.ln(2, this.FhT.computeSize());
        this.FhT.writeFields(paramVarArgs);
      }
      if (this.DSu != null) {
        paramVarArgs.d(3, this.DSu);
      }
      if (this.FrP != null) {
        paramVarArgs.d(4, this.FrP);
      }
      if (this.FrO != null) {
        paramVarArgs.d(5, this.FrO);
      }
      paramVarArgs.aR(6, this.FrQ);
      paramVarArgs.aR(7, this.FhS);
      paramVarArgs.aR(8, this.FrR);
      AppMethodBeat.o(117889);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Eel == null) {
        break label694;
      }
    }
    label694:
    for (int i = f.a.a.b.b.a.e(1, this.Eel) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FhT != null) {
        paramInt = i + f.a.a.a.lm(2, this.FhT.computeSize());
      }
      i = paramInt;
      if (this.DSu != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DSu);
      }
      paramInt = i;
      if (this.FrP != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FrP);
      }
      i = paramInt;
      if (this.FrO != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FrO);
      }
      paramInt = f.a.a.b.b.a.bx(6, this.FrQ);
      int j = f.a.a.b.b.a.bx(7, this.FhS);
      int k = f.a.a.b.b.a.bx(8, this.FrR);
      AppMethodBeat.o(117889);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(117889);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cdf localcdf = (cdf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117889);
          return -1;
        case 1: 
          localcdf.Eel = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(117889);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bpa();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((bpa)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcdf.FhT = ((bpa)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117889);
          return 0;
        case 3: 
          localcdf.DSu = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(117889);
          return 0;
        case 4: 
          localcdf.FrP = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(117889);
          return 0;
        case 5: 
          localcdf.FrO = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(117889);
          return 0;
        case 6: 
          localcdf.FrQ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(117889);
          return 0;
        case 7: 
          localcdf.FhS = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(117889);
          return 0;
        }
        localcdf.FrR = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(117889);
        return 0;
      }
      AppMethodBeat.o(117889);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdf
 * JD-Core Version:    0.7.0.1
 */