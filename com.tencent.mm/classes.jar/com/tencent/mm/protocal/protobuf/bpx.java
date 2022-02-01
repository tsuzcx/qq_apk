package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bpx
  extends erp
{
  public atz YIY;
  public LinkedList<Long> ZYb;
  public LinkedList<dpt> ZYc;
  public String finderUsername;
  public int hYl;
  
  public bpx()
  {
    AppMethodBeat.i(257894);
    this.ZYb = new LinkedList();
    this.ZYc = new LinkedList();
    AppMethodBeat.o(257894);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257903);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.hYl);
      if (this.finderUsername != null) {
        paramVarArgs.g(3, this.finderUsername);
      }
      paramVarArgs.e(4, 3, this.ZYb);
      if (this.YIY != null)
      {
        paramVarArgs.qD(5, this.YIY.computeSize());
        this.YIY.writeFields(paramVarArgs);
      }
      paramVarArgs.e(6, 8, this.ZYc);
      AppMethodBeat.o(257903);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label703;
      }
    }
    label703:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.hYl);
      paramInt = i;
      if (this.finderUsername != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.finderUsername);
      }
      i = paramInt + i.a.a.a.c(4, 3, this.ZYb);
      paramInt = i;
      if (this.YIY != null) {
        paramInt = i + i.a.a.a.qC(5, this.YIY.computeSize());
      }
      i = i.a.a.a.c(6, 8, this.ZYc);
      AppMethodBeat.o(257903);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZYb.clear();
        this.ZYc.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257903);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bpx localbpx = (bpx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257903);
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
            localbpx.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257903);
          return 0;
        case 2: 
          localbpx.hYl = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257903);
          return 0;
        case 3: 
          localbpx.finderUsername = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257903);
          return 0;
        case 4: 
          localbpx.ZYb.add(Long.valueOf(((i.a.a.a.a)localObject1).ajGk.aaw()));
          AppMethodBeat.o(257903);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new atz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((atz)localObject2).parseFrom((byte[])localObject1);
            }
            localbpx.YIY = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257903);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dpt();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dpt)localObject2).parseFrom((byte[])localObject1);
          }
          localbpx.ZYc.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257903);
        return 0;
      }
      AppMethodBeat.o(257903);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpx
 * JD-Core Version:    0.7.0.1
 */