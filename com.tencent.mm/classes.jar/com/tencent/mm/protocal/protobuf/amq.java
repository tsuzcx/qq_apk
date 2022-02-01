package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class amq
  extends com.tencent.mm.bw.a
{
  public FinderContact refObjectContact;
  public long refObjectFlag;
  public long refObjectId;
  public String refObjectNonceId;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169027);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(20, this.refObjectFlag);
      paramVarArgs.aO(21, this.refObjectId);
      if (this.refObjectContact != null)
      {
        paramVarArgs.ln(22, this.refObjectContact.computeSize());
        this.refObjectContact.writeFields(paramVarArgs);
      }
      if (this.refObjectNonceId != null) {
        paramVarArgs.d(23, this.refObjectNonceId);
      }
      AppMethodBeat.o(169027);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(20, this.refObjectFlag) + 0 + f.a.a.b.b.a.p(21, this.refObjectId);
      paramInt = i;
      if (this.refObjectContact != null) {
        paramInt = i + f.a.a.a.lm(22, this.refObjectContact.computeSize());
      }
      i = paramInt;
      if (this.refObjectNonceId != null) {
        i = paramInt + f.a.a.b.b.a.e(23, this.refObjectNonceId);
      }
      AppMethodBeat.o(169027);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(169027);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      amq localamq = (amq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(169027);
        return -1;
      case 20: 
        localamq.refObjectFlag = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(169027);
        return 0;
      case 21: 
        localamq.refObjectId = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(169027);
        return 0;
      case 22: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new FinderContact();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((FinderContact)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localamq.refObjectContact = ((FinderContact)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169027);
        return 0;
      }
      localamq.refObjectNonceId = ((f.a.a.a.a)localObject1).LVo.readString();
      AppMethodBeat.o(169027);
      return 0;
    }
    AppMethodBeat.o(169027);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amq
 * JD-Core Version:    0.7.0.1
 */