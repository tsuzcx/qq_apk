package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cma
  extends erp
{
  public int IJG;
  public int YKH;
  public dha Zqj;
  public String aakp;
  public gol aatT;
  public int aatU;
  public int aatV;
  public LinkedList<edl> aatW;
  public int aatX;
  
  public cma()
  {
    AppMethodBeat.i(32249);
    this.aatW = new LinkedList();
    AppMethodBeat.o(32249);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32250);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Zqj == null)
      {
        paramVarArgs = new b("Not all required fields were included: Loc");
        AppMethodBeat.o(32250);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.YKH);
      paramVarArgs.bS(3, this.IJG);
      if (this.aatT != null)
      {
        paramVarArgs.qD(4, this.aatT.computeSize());
        this.aatT.writeFields(paramVarArgs);
      }
      if (this.Zqj != null)
      {
        paramVarArgs.qD(5, this.Zqj.computeSize());
        this.Zqj.writeFields(paramVarArgs);
      }
      if (this.aakp != null) {
        paramVarArgs.g(6, this.aakp);
      }
      paramVarArgs.bS(7, this.aatU);
      paramVarArgs.bS(8, this.aatV);
      paramVarArgs.e(11, 8, this.aatW);
      paramVarArgs.bS(12, this.aatX);
      AppMethodBeat.o(32250);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1038;
      }
    }
    label1038:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.YKH) + i.a.a.b.b.a.cJ(3, this.IJG);
      paramInt = i;
      if (this.aatT != null) {
        paramInt = i + i.a.a.a.qC(4, this.aatT.computeSize());
      }
      i = paramInt;
      if (this.Zqj != null) {
        i = paramInt + i.a.a.a.qC(5, this.Zqj.computeSize());
      }
      paramInt = i;
      if (this.aakp != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.aakp);
      }
      i = i.a.a.b.b.a.cJ(7, this.aatU);
      int j = i.a.a.b.b.a.cJ(8, this.aatV);
      int k = i.a.a.a.c(11, 8, this.aatW);
      int m = i.a.a.b.b.a.cJ(12, this.aatX);
      AppMethodBeat.o(32250);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aatW.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.Zqj == null)
        {
          paramVarArgs = new b("Not all required fields were included: Loc");
          AppMethodBeat.o(32250);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32250);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cma localcma = (cma)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 9: 
        case 10: 
        default: 
          AppMethodBeat.o(32250);
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
            localcma.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32250);
          return 0;
        case 2: 
          localcma.YKH = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32250);
          return 0;
        case 3: 
          localcma.IJG = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32250);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gol)localObject2).dg((byte[])localObject1);
            }
            localcma.aatT = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32250);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dha();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dha)localObject2).parseFrom((byte[])localObject1);
            }
            localcma.Zqj = ((dha)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32250);
          return 0;
        case 6: 
          localcma.aakp = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32250);
          return 0;
        case 7: 
          localcma.aatU = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32250);
          return 0;
        case 8: 
          localcma.aatV = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32250);
          return 0;
        case 11: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new edl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((edl)localObject2).parseFrom((byte[])localObject1);
            }
            localcma.aatW.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32250);
          return 0;
        }
        localcma.aatX = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(32250);
        return 0;
      }
      AppMethodBeat.o(32250);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cma
 * JD-Core Version:    0.7.0.1
 */