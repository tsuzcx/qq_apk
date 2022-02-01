package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class ftb
  extends erp
{
  public int NkN;
  public int NkO;
  public int NkP;
  public gol NkQ;
  public String ZqZ;
  public String nUv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(90777);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.NkQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(90777);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.nUv != null) {
        paramVarArgs.g(2, this.nUv);
      }
      paramVarArgs.bS(3, this.NkN);
      paramVarArgs.bS(4, this.NkO);
      paramVarArgs.bS(5, this.NkP);
      if (this.NkQ != null)
      {
        paramVarArgs.qD(6, this.NkQ.computeSize());
        this.NkQ.writeFields(paramVarArgs);
      }
      if (this.ZqZ != null) {
        paramVarArgs.g(7, this.ZqZ);
      }
      AppMethodBeat.o(90777);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label718;
      }
    }
    label718:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.nUv != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.nUv);
      }
      i = i + i.a.a.b.b.a.cJ(3, this.NkN) + i.a.a.b.b.a.cJ(4, this.NkO) + i.a.a.b.b.a.cJ(5, this.NkP);
      paramInt = i;
      if (this.NkQ != null) {
        paramInt = i + i.a.a.a.qC(6, this.NkQ.computeSize());
      }
      i = paramInt;
      if (this.ZqZ != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.ZqZ);
      }
      AppMethodBeat.o(90777);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.NkQ == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(90777);
          throw paramVarArgs;
        }
        AppMethodBeat.o(90777);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ftb localftb = (ftb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(90777);
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
            localftb.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(90777);
          return 0;
        case 2: 
          localftb.nUv = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(90777);
          return 0;
        case 3: 
          localftb.NkN = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(90777);
          return 0;
        case 4: 
          localftb.NkO = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(90777);
          return 0;
        case 5: 
          localftb.NkP = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(90777);
          return 0;
        case 6: 
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
            localftb.NkQ = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(90777);
          return 0;
        }
        localftb.ZqZ = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(90777);
        return 0;
      }
      AppMethodBeat.o(90777);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ftb
 * JD-Core Version:    0.7.0.1
 */