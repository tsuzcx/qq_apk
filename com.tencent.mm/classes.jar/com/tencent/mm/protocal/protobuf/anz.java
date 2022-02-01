package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class anz
  extends esc
{
  public LinkedList<fly> YFm;
  public int YKK;
  public LinkedList<flx> YKL;
  public long ZvA;
  public int ZvB;
  public int ZvC;
  public int ZvD;
  public int Zvz;
  
  public anz()
  {
    AppMethodBeat.i(32191);
    this.YFm = new LinkedList();
    this.YKL = new LinkedList();
    AppMethodBeat.o(32191);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32192);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32192);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.Zvz);
      paramVarArgs.bv(3, this.ZvA);
      paramVarArgs.bS(4, this.ZvB);
      paramVarArgs.bS(5, this.ZvC);
      paramVarArgs.e(6, 8, this.YFm);
      paramVarArgs.bS(7, this.ZvD);
      paramVarArgs.bS(8, this.YKK);
      paramVarArgs.e(9, 8, this.YKL);
      AppMethodBeat.o(32192);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label871;
      }
    }
    label871:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.Zvz);
      int j = i.a.a.b.b.a.q(3, this.ZvA);
      int k = i.a.a.b.b.a.cJ(4, this.ZvB);
      int m = i.a.a.b.b.a.cJ(5, this.ZvC);
      int n = i.a.a.a.c(6, 8, this.YFm);
      int i1 = i.a.a.b.b.a.cJ(7, this.ZvD);
      int i2 = i.a.a.b.b.a.cJ(8, this.YKK);
      int i3 = i.a.a.a.c(9, 8, this.YKL);
      AppMethodBeat.o(32192);
      return paramInt + i + j + k + m + n + i1 + i2 + i3;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YFm.clear();
        this.YKL.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32192);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32192);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        anz localanz = (anz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32192);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localanz.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32192);
          return 0;
        case 2: 
          localanz.Zvz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32192);
          return 0;
        case 3: 
          localanz.ZvA = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(32192);
          return 0;
        case 4: 
          localanz.ZvB = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32192);
          return 0;
        case 5: 
          localanz.ZvC = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32192);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fly();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fly)localObject2).parseFrom((byte[])localObject1);
            }
            localanz.YFm.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32192);
          return 0;
        case 7: 
          localanz.ZvD = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32192);
          return 0;
        case 8: 
          localanz.YKK = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32192);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new flx();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((flx)localObject2).parseFrom((byte[])localObject1);
          }
          localanz.YKL.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(32192);
        return 0;
      }
      AppMethodBeat.o(32192);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.anz
 * JD-Core Version:    0.7.0.1
 */