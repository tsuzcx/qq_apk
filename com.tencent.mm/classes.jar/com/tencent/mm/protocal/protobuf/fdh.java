package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class fdh
  extends erp
{
  public int IJG;
  public int IcB;
  public etl abCM;
  public fdq abCN;
  public etl abCO;
  public String nUv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125762);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abCN == null)
      {
        paramVarArgs = new b("Not all required fields were included: Action");
        AppMethodBeat.o(125762);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.abCN != null)
      {
        paramVarArgs.qD(2, this.abCN.computeSize());
        this.abCN.writeFields(paramVarArgs);
      }
      if (this.nUv != null) {
        paramVarArgs.g(3, this.nUv);
      }
      if (this.abCM != null)
      {
        paramVarArgs.qD(4, this.abCM.computeSize());
        this.abCM.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(5, this.IcB);
      if (this.abCO != null)
      {
        paramVarArgs.qD(6, this.abCO.computeSize());
        this.abCO.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(7, this.IJG);
      AppMethodBeat.o(125762);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label882;
      }
    }
    label882:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.abCN != null) {
        paramInt = i + i.a.a.a.qC(2, this.abCN.computeSize());
      }
      i = paramInt;
      if (this.nUv != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.nUv);
      }
      paramInt = i;
      if (this.abCM != null) {
        paramInt = i + i.a.a.a.qC(4, this.abCM.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.IcB);
      paramInt = i;
      if (this.abCO != null) {
        paramInt = i + i.a.a.a.qC(6, this.abCO.computeSize());
      }
      i = i.a.a.b.b.a.cJ(7, this.IJG);
      AppMethodBeat.o(125762);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.abCN == null)
        {
          paramVarArgs = new b("Not all required fields were included: Action");
          AppMethodBeat.o(125762);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125762);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fdh localfdh = (fdh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125762);
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
            localfdh.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125762);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fdq();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fdq)localObject2).parseFrom((byte[])localObject1);
            }
            localfdh.abCN = ((fdq)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125762);
          return 0;
        case 3: 
          localfdh.nUv = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(125762);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new etl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((etl)localObject2).dh((byte[])localObject1);
            }
            localfdh.abCM = ((etl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125762);
          return 0;
        case 5: 
          localfdh.IcB = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125762);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new etl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((etl)localObject2).dh((byte[])localObject1);
            }
            localfdh.abCO = ((etl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125762);
          return 0;
        }
        localfdh.IJG = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(125762);
        return 0;
      }
      AppMethodBeat.o(125762);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fdh
 * JD-Core Version:    0.7.0.1
 */