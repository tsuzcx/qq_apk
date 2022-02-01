package com.tencent.mm.plugin.qqmail.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.erp;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.protocal.protobuf.kc;
import i.a.a.b;
import java.util.LinkedList;

public final class ag
  extends erp
{
  public int NkN;
  public int NkO;
  public int NkP;
  public gol NkQ;
  public String nUv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122799);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.NkQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(122799);
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
      AppMethodBeat.o(122799);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label654;
      }
    }
    label654:
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
      AppMethodBeat.o(122799);
      return paramInt;
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
          AppMethodBeat.o(122799);
          throw paramVarArgs;
        }
        AppMethodBeat.o(122799);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ag localag = (ag)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122799);
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
            localag.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(122799);
          return 0;
        case 2: 
          localag.nUv = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(122799);
          return 0;
        case 3: 
          localag.NkN = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(122799);
          return 0;
        case 4: 
          localag.NkO = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(122799);
          return 0;
        case 5: 
          localag.NkP = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(122799);
          return 0;
        }
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
          localag.NkQ = ((gol)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(122799);
        return 0;
      }
      AppMethodBeat.o(122799);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.model.ag
 * JD-Core Version:    0.7.0.1
 */