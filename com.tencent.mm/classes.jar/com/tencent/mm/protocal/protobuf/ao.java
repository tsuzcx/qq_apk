package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ao
  extends erp
{
  public String YBb;
  public String YBc;
  public int YBd;
  public LinkedList<wf> YBg;
  public int iaK;
  
  public ao()
  {
    AppMethodBeat.i(113924);
    this.YBg = new LinkedList();
    AppMethodBeat.o(113924);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113925);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.YBg);
      paramVarArgs.bS(3, this.iaK);
      if (this.YBb != null) {
        paramVarArgs.g(4, this.YBb);
      }
      if (this.YBc != null) {
        paramVarArgs.g(5, this.YBc);
      }
      paramVarArgs.bS(6, this.YBd);
      AppMethodBeat.o(113925);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label614;
      }
    }
    label614:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.YBg) + i.a.a.b.b.a.cJ(3, this.iaK);
      paramInt = i;
      if (this.YBb != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.YBb);
      }
      i = paramInt;
      if (this.YBc != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.YBc);
      }
      paramInt = i.a.a.b.b.a.cJ(6, this.YBd);
      AppMethodBeat.o(113925);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YBg.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(113925);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ao localao = (ao)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113925);
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
            localao.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(113925);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new wf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((wf)localObject2).parseFrom((byte[])localObject1);
            }
            localao.YBg.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(113925);
          return 0;
        case 3: 
          localao.iaK = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(113925);
          return 0;
        case 4: 
          localao.YBb = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(113925);
          return 0;
        case 5: 
          localao.YBc = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(113925);
          return 0;
        }
        localao.YBd = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(113925);
        return 0;
      }
      AppMethodBeat.o(113925);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ao
 * JD-Core Version:    0.7.0.1
 */