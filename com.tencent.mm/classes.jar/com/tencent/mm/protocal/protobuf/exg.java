package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class exg
  extends erp
{
  public String abzh;
  public exf abzi;
  public String abzj;
  public String abzk;
  public int action;
  public String hHa;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259569);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.hHa != null) {
        paramVarArgs.g(2, this.hHa);
      }
      if (this.abzh != null) {
        paramVarArgs.g(3, this.abzh);
      }
      paramVarArgs.bS(4, this.action);
      if (this.abzi != null)
      {
        paramVarArgs.qD(5, this.abzi.computeSize());
        this.abzi.writeFields(paramVarArgs);
      }
      if (this.abzj != null) {
        paramVarArgs.g(6, this.abzj);
      }
      paramVarArgs.bS(7, this.version);
      if (this.abzk != null) {
        paramVarArgs.g(8, this.abzk);
      }
      AppMethodBeat.o(259569);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label750;
      }
    }
    label750:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hHa != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.hHa);
      }
      i = paramInt;
      if (this.abzh != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.abzh);
      }
      i += i.a.a.b.b.a.cJ(4, this.action);
      paramInt = i;
      if (this.abzi != null) {
        paramInt = i + i.a.a.a.qC(5, this.abzi.computeSize());
      }
      i = paramInt;
      if (this.abzj != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.abzj);
      }
      i += i.a.a.b.b.a.cJ(7, this.version);
      paramInt = i;
      if (this.abzk != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.abzk);
      }
      AppMethodBeat.o(259569);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259569);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        exg localexg = (exg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259569);
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
            localexg.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259569);
          return 0;
        case 2: 
          localexg.hHa = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259569);
          return 0;
        case 3: 
          localexg.abzh = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259569);
          return 0;
        case 4: 
          localexg.action = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259569);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new exf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((exf)localObject2).parseFrom((byte[])localObject1);
            }
            localexg.abzi = ((exf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259569);
          return 0;
        case 6: 
          localexg.abzj = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259569);
          return 0;
        case 7: 
          localexg.version = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259569);
          return 0;
        }
        localexg.abzk = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(259569);
        return 0;
      }
      AppMethodBeat.o(259569);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.exg
 * JD-Core Version:    0.7.0.1
 */