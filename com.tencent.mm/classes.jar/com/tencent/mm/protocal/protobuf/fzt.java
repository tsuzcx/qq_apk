package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fzt
  extends erp
{
  public int YKo;
  public long ZvA;
  public long abKe;
  public String abXB;
  public long abmO;
  public int abmP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125494);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.abmP);
      paramVarArgs.bv(3, this.abKe);
      paramVarArgs.bv(4, this.ZvA);
      if (this.abXB != null) {
        paramVarArgs.g(5, this.abXB);
      }
      paramVarArgs.bv(6, this.abmO);
      paramVarArgs.bS(7, this.YKo);
      AppMethodBeat.o(125494);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label568;
      }
    }
    label568:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.abmP) + i.a.a.b.b.a.q(3, this.abKe) + i.a.a.b.b.a.q(4, this.ZvA);
      paramInt = i;
      if (this.abXB != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.abXB);
      }
      i = i.a.a.b.b.a.q(6, this.abmO);
      int j = i.a.a.b.b.a.cJ(7, this.YKo);
      AppMethodBeat.o(125494);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(125494);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        fzt localfzt = (fzt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125494);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kc localkc = new kc();
            if ((localObject != null) && (localObject.length > 0)) {
              localkc.parseFrom((byte[])localObject);
            }
            localfzt.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(125494);
          return 0;
        case 2: 
          localfzt.abmP = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(125494);
          return 0;
        case 3: 
          localfzt.abKe = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(125494);
          return 0;
        case 4: 
          localfzt.ZvA = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(125494);
          return 0;
        case 5: 
          localfzt.abXB = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(125494);
          return 0;
        case 6: 
          localfzt.abmO = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(125494);
          return 0;
        }
        localfzt.YKo = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(125494);
        return 0;
      }
      AppMethodBeat.o(125494);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fzt
 * JD-Core Version:    0.7.0.1
 */