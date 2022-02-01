package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class brq
  extends com.tencent.mm.bx.a
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
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(20, this.refObjectFlag);
      paramVarArgs.bv(21, this.refObjectId);
      if (this.refObjectContact != null)
      {
        paramVarArgs.qD(22, this.refObjectContact.computeSize());
        this.refObjectContact.writeFields(paramVarArgs);
      }
      if (this.refObjectNonceId != null) {
        paramVarArgs.g(23, this.refObjectNonceId);
      }
      AppMethodBeat.o(169027);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.q(20, this.refObjectFlag) + 0 + i.a.a.b.b.a.q(21, this.refObjectId);
      paramInt = i;
      if (this.refObjectContact != null) {
        paramInt = i + i.a.a.a.qC(22, this.refObjectContact.computeSize());
      }
      i = paramInt;
      if (this.refObjectNonceId != null) {
        i = paramInt + i.a.a.b.b.a.h(23, this.refObjectNonceId);
      }
      AppMethodBeat.o(169027);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(169027);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      brq localbrq = (brq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(169027);
        return -1;
      case 20: 
        localbrq.refObjectFlag = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(169027);
        return 0;
      case 21: 
        localbrq.refObjectId = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(169027);
        return 0;
      case 22: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          FinderContact localFinderContact = new FinderContact();
          if ((localObject != null) && (localObject.length > 0)) {
            localFinderContact.parseFrom((byte[])localObject);
          }
          localbrq.refObjectContact = localFinderContact;
          paramInt += 1;
        }
        AppMethodBeat.o(169027);
        return 0;
      }
      localbrq.refObjectNonceId = ((i.a.a.a.a)localObject).ajGk.readString();
      AppMethodBeat.o(169027);
      return 0;
    }
    AppMethodBeat.o(169027);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.brq
 * JD-Core Version:    0.7.0.1
 */