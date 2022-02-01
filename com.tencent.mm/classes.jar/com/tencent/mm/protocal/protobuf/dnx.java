package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dnx
  extends erp
{
  public long NIs;
  public dnf aaVc;
  public int aaVd;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258502);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.aaVc != null)
      {
        paramVarArgs.qD(2, this.aaVc.computeSize());
        this.aaVc.writeFields(paramVarArgs);
      }
      if (this.username != null) {
        paramVarArgs.g(3, this.username);
      }
      paramVarArgs.bv(4, this.NIs);
      paramVarArgs.bS(5, this.aaVd);
      AppMethodBeat.o(258502);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label566;
      }
    }
    label566:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aaVc != null) {
        paramInt = i + i.a.a.a.qC(2, this.aaVc.computeSize());
      }
      i = paramInt;
      if (this.username != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.username);
      }
      paramInt = i.a.a.b.b.a.q(4, this.NIs);
      int j = i.a.a.b.b.a.cJ(5, this.aaVd);
      AppMethodBeat.o(258502);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258502);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        dnx localdnx = (dnx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258502);
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
            localdnx.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258502);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dnf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dnf)localObject2).parseFrom((byte[])localObject1);
            }
            localdnx.aaVc = ((dnf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258502);
          return 0;
        case 3: 
          localdnx.username = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258502);
          return 0;
        case 4: 
          localdnx.NIs = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(258502);
          return 0;
        }
        localdnx.aaVd = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(258502);
        return 0;
      }
      AppMethodBeat.o(258502);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dnx
 * JD-Core Version:    0.7.0.1
 */