package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class kq
  extends erp
{
  public LinkedList<String> YMG;
  public LinkedList<erl> YMH;
  public long YMI;
  public int YMJ;
  public int YMK;
  public LinkedList<abv> YML;
  public String vYk;
  
  public kq()
  {
    AppMethodBeat.i(6394);
    this.YMG = new LinkedList();
    this.YMH = new LinkedList();
    this.YML = new LinkedList();
    AppMethodBeat.o(6394);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6395);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 1, this.YMG);
      paramVarArgs.e(3, 8, this.YMH);
      if (this.vYk != null) {
        paramVarArgs.g(4, this.vYk);
      }
      paramVarArgs.bv(5, this.YMI);
      paramVarArgs.bS(6, this.YMJ);
      paramVarArgs.bS(7, this.YMK);
      paramVarArgs.e(8, 8, this.YML);
      AppMethodBeat.o(6395);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label794;
      }
    }
    label794:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 1, this.YMG) + i.a.a.a.c(3, 8, this.YMH);
      paramInt = i;
      if (this.vYk != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.vYk);
      }
      i = i.a.a.b.b.a.q(5, this.YMI);
      int j = i.a.a.b.b.a.cJ(6, this.YMJ);
      int k = i.a.a.b.b.a.cJ(7, this.YMK);
      int m = i.a.a.a.c(8, 8, this.YML);
      AppMethodBeat.o(6395);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YMG.clear();
        this.YMH.clear();
        this.YML.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(6395);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        kq localkq = (kq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(6395);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localkq.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(6395);
          return 0;
        case 2: 
          localkq.YMG.add(((i.a.a.a.a)localObject1).ajGk.readString());
          AppMethodBeat.o(6395);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new erl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((erl)localObject2).parseFrom((byte[])localObject1);
            }
            localkq.YMH.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(6395);
          return 0;
        case 4: 
          localkq.vYk = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(6395);
          return 0;
        case 5: 
          localkq.YMI = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(6395);
          return 0;
        case 6: 
          localkq.YMJ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(6395);
          return 0;
        case 7: 
          localkq.YMK = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(6395);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new abv();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((abv)localObject2).parseFrom((byte[])localObject1);
          }
          localkq.YML.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(6395);
        return 0;
      }
      AppMethodBeat.o(6395);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.kq
 * JD-Core Version:    0.7.0.1
 */