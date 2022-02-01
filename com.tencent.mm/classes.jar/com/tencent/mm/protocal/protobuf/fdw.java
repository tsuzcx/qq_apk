package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class fdw
  extends erp
{
  public fdq abCN;
  public etl abCO;
  public String abDB;
  public String nUv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125780);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abCN == null)
      {
        paramVarArgs = new b("Not all required fields were included: Action");
        AppMethodBeat.o(125780);
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
      if (this.abCO != null)
      {
        paramVarArgs.qD(4, this.abCO.computeSize());
        this.abCO.writeFields(paramVarArgs);
      }
      if (this.abDB != null) {
        paramVarArgs.g(5, this.abDB);
      }
      AppMethodBeat.o(125780);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label716;
      }
    }
    label716:
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
      if (this.abCO != null) {
        paramInt = i + i.a.a.a.qC(4, this.abCO.computeSize());
      }
      i = paramInt;
      if (this.abDB != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.abDB);
      }
      AppMethodBeat.o(125780);
      return i;
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
          AppMethodBeat.o(125780);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125780);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fdw localfdw = (fdw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125780);
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
            localfdw.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125780);
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
            localfdw.abCN = ((fdq)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125780);
          return 0;
        case 3: 
          localfdw.nUv = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(125780);
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
            localfdw.abCO = ((etl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125780);
          return 0;
        }
        localfdw.abDB = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(125780);
        return 0;
      }
      AppMethodBeat.o(125780);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fdw
 * JD-Core Version:    0.7.0.1
 */