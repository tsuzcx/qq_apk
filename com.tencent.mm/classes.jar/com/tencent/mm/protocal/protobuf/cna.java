package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cna
  extends erp
{
  public int IJG;
  public String MD5;
  public int aauC;
  public LinkedList<dow> aauD;
  public int aauE;
  public LinkedList<dkj> aauF;
  public int muC;
  
  public cna()
  {
    AppMethodBeat.i(155408);
    this.aauD = new LinkedList();
    this.aauF = new LinkedList();
    AppMethodBeat.o(155408);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155409);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.muC);
      if (this.MD5 != null) {
        paramVarArgs.g(3, this.MD5);
      }
      paramVarArgs.bS(4, this.aauC);
      paramVarArgs.e(5, 8, this.aauD);
      paramVarArgs.bS(6, this.aauE);
      paramVarArgs.e(7, 8, this.aauF);
      paramVarArgs.bS(8, this.IJG);
      AppMethodBeat.o(155409);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label772;
      }
    }
    label772:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.muC);
      paramInt = i;
      if (this.MD5 != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.MD5);
      }
      i = i.a.a.b.b.a.cJ(4, this.aauC);
      int j = i.a.a.a.c(5, 8, this.aauD);
      int k = i.a.a.b.b.a.cJ(6, this.aauE);
      int m = i.a.a.a.c(7, 8, this.aauF);
      int n = i.a.a.b.b.a.cJ(8, this.IJG);
      AppMethodBeat.o(155409);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aauD.clear();
        this.aauF.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(155409);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cna localcna = (cna)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155409);
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
            localcna.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(155409);
          return 0;
        case 2: 
          localcna.muC = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(155409);
          return 0;
        case 3: 
          localcna.MD5 = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(155409);
          return 0;
        case 4: 
          localcna.aauC = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(155409);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dow();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dow)localObject2).parseFrom((byte[])localObject1);
            }
            localcna.aauD.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(155409);
          return 0;
        case 6: 
          localcna.aauE = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(155409);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dkj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dkj)localObject2).parseFrom((byte[])localObject1);
            }
            localcna.aauF.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(155409);
          return 0;
        }
        localcna.IJG = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(155409);
        return 0;
      }
      AppMethodBeat.o(155409);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cna
 * JD-Core Version:    0.7.0.1
 */