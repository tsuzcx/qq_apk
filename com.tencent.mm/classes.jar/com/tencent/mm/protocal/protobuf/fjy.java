package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fjy
  extends erp
{
  public glh aaCt;
  public gli aaCu;
  public glj aaCv;
  public gnn abKt;
  public String oOI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50115);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.oOI != null) {
        paramVarArgs.g(2, this.oOI);
      }
      if (this.aaCt != null)
      {
        paramVarArgs.qD(3, this.aaCt.computeSize());
        this.aaCt.writeFields(paramVarArgs);
      }
      if (this.aaCu != null)
      {
        paramVarArgs.qD(6, this.aaCu.computeSize());
        this.aaCu.writeFields(paramVarArgs);
      }
      if (this.aaCv != null)
      {
        paramVarArgs.qD(7, this.aaCv.computeSize());
        this.aaCv.writeFields(paramVarArgs);
      }
      if (this.abKt != null)
      {
        paramVarArgs.qD(8, this.abKt.computeSize());
        this.abKt.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(50115);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label888;
      }
    }
    label888:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.oOI != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.oOI);
      }
      i = paramInt;
      if (this.aaCt != null) {
        i = paramInt + i.a.a.a.qC(3, this.aaCt.computeSize());
      }
      paramInt = i;
      if (this.aaCu != null) {
        paramInt = i + i.a.a.a.qC(6, this.aaCu.computeSize());
      }
      i = paramInt;
      if (this.aaCv != null) {
        i = paramInt + i.a.a.a.qC(7, this.aaCv.computeSize());
      }
      paramInt = i;
      if (this.abKt != null) {
        paramInt = i + i.a.a.a.qC(8, this.abKt.computeSize());
      }
      AppMethodBeat.o(50115);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(50115);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fjy localfjy = (fjy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 4: 
        case 5: 
        default: 
          AppMethodBeat.o(50115);
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
            localfjy.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(50115);
          return 0;
        case 2: 
          localfjy.oOI = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(50115);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new glh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((glh)localObject2).parseFrom((byte[])localObject1);
            }
            localfjy.aaCt = ((glh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(50115);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gli();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gli)localObject2).parseFrom((byte[])localObject1);
            }
            localfjy.aaCu = ((gli)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(50115);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new glj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((glj)localObject2).parseFrom((byte[])localObject1);
            }
            localfjy.aaCv = ((glj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(50115);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new gnn();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((gnn)localObject2).parseFrom((byte[])localObject1);
          }
          localfjy.abKt = ((gnn)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(50115);
        return 0;
      }
      AppMethodBeat.o(50115);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fjy
 * JD-Core Version:    0.7.0.1
 */