package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cff
  extends erp
{
  public LinkedList<daw> aaoO;
  public day aaoQ;
  public long aaoR;
  
  public cff()
  {
    AppMethodBeat.i(82406);
    this.aaoO = new LinkedList();
    AppMethodBeat.o(82406);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82407);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.aaoO);
      if (this.aaoQ != null)
      {
        paramVarArgs.qD(4, this.aaoQ.computeSize());
        this.aaoQ.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(5, this.aaoR);
      AppMethodBeat.o(82407);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label584;
      }
    }
    label584:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.aaoO);
      paramInt = i;
      if (this.aaoQ != null) {
        paramInt = i + i.a.a.a.qC(4, this.aaoQ.computeSize());
      }
      i = i.a.a.b.b.a.q(5, this.aaoR);
      AppMethodBeat.o(82407);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aaoO.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(82407);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cff localcff = (cff)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 3: 
        default: 
          AppMethodBeat.o(82407);
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
            localcff.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(82407);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new daw();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((daw)localObject2).parseFrom((byte[])localObject1);
            }
            localcff.aaoO.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(82407);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new day();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((day)localObject2).parseFrom((byte[])localObject1);
            }
            localcff.aaoQ = ((day)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(82407);
          return 0;
        }
        localcff.aaoR = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(82407);
        return 0;
      }
      AppMethodBeat.o(82407);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cff
 * JD-Core Version:    0.7.0.1
 */