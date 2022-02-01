package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class apo
  extends erp
{
  public int IJG;
  public int YIq;
  public long ZwN;
  public long ZwO;
  public long ZwP;
  public long ZwQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259478);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.YIq);
      paramVarArgs.bS(3, this.IJG);
      paramVarArgs.bv(4, this.ZwN);
      paramVarArgs.bv(5, this.ZwO);
      paramVarArgs.bv(6, this.ZwP);
      paramVarArgs.bv(7, this.ZwQ);
      AppMethodBeat.o(259478);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label564;
      }
    }
    label564:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.YIq);
      int j = i.a.a.b.b.a.cJ(3, this.IJG);
      int k = i.a.a.b.b.a.q(4, this.ZwN);
      int m = i.a.a.b.b.a.q(5, this.ZwO);
      int n = i.a.a.b.b.a.q(6, this.ZwP);
      int i1 = i.a.a.b.b.a.q(7, this.ZwQ);
      AppMethodBeat.o(259478);
      return paramInt + i + j + k + m + n + i1;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259478);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        apo localapo = (apo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259478);
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
            localapo.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(259478);
          return 0;
        case 2: 
          localapo.YIq = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259478);
          return 0;
        case 3: 
          localapo.IJG = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259478);
          return 0;
        case 4: 
          localapo.ZwN = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(259478);
          return 0;
        case 5: 
          localapo.ZwO = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(259478);
          return 0;
        case 6: 
          localapo.ZwP = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(259478);
          return 0;
        }
        localapo.ZwQ = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(259478);
        return 0;
      }
      AppMethodBeat.o(259478);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.apo
 * JD-Core Version:    0.7.0.1
 */