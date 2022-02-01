package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class azy
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
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(20, this.refObjectFlag);
      paramVarArgs.bb(21, this.refObjectId);
      if (this.refObjectContact != null)
      {
        paramVarArgs.ni(22, this.refObjectContact.computeSize());
        this.refObjectContact.writeFields(paramVarArgs);
      }
      if (this.refObjectNonceId != null) {
        paramVarArgs.e(23, this.refObjectNonceId);
      }
      AppMethodBeat.o(169027);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.r(20, this.refObjectFlag) + 0 + g.a.a.b.b.a.r(21, this.refObjectId);
      paramInt = i;
      if (this.refObjectContact != null) {
        paramInt = i + g.a.a.a.nh(22, this.refObjectContact.computeSize());
      }
      i = paramInt;
      if (this.refObjectNonceId != null) {
        i = paramInt + g.a.a.b.b.a.f(23, this.refObjectNonceId);
      }
      AppMethodBeat.o(169027);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(169027);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      azy localazy = (azy)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(169027);
        return -1;
      case 20: 
        localazy.refObjectFlag = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(169027);
        return 0;
      case 21: 
        localazy.refObjectId = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(169027);
        return 0;
      case 22: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new FinderContact();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((FinderContact)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localazy.refObjectContact = ((FinderContact)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169027);
        return 0;
      }
      localazy.refObjectNonceId = ((g.a.a.a.a)localObject1).UbS.readString();
      AppMethodBeat.o(169027);
      return 0;
    }
    AppMethodBeat.o(169027);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.azy
 * JD-Core Version:    0.7.0.1
 */