package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class fdq
  extends com.tencent.mm.bx.a
{
  public long Id;
  public long abDo;
  public fdp abDp;
  public fdp abDq;
  public String nUv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125772);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abDp == null)
      {
        paramVarArgs = new b("Not all required fields were included: CurrentAction");
        AppMethodBeat.o(125772);
        throw paramVarArgs;
      }
      paramVarArgs.bv(1, this.Id);
      paramVarArgs.bv(2, this.abDo);
      if (this.abDp != null)
      {
        paramVarArgs.qD(3, this.abDp.computeSize());
        this.abDp.writeFields(paramVarArgs);
      }
      if (this.abDq != null)
      {
        paramVarArgs.qD(4, this.abDq.computeSize());
        this.abDq.writeFields(paramVarArgs);
      }
      if (this.nUv != null) {
        paramVarArgs.g(5, this.nUv);
      }
      AppMethodBeat.o(125772);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.q(1, this.Id) + 0 + i.a.a.b.b.a.q(2, this.abDo);
      paramInt = i;
      if (this.abDp != null) {
        paramInt = i + i.a.a.a.qC(3, this.abDp.computeSize());
      }
      i = paramInt;
      if (this.abDq != null) {
        i = paramInt + i.a.a.a.qC(4, this.abDq.computeSize());
      }
      paramInt = i;
      if (this.nUv != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.nUv);
      }
      AppMethodBeat.o(125772);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      if (this.abDp == null)
      {
        paramVarArgs = new b("Not all required fields were included: CurrentAction");
        AppMethodBeat.o(125772);
        throw paramVarArgs;
      }
      AppMethodBeat.o(125772);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      fdq localfdq = (fdq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      fdp localfdp;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(125772);
        return -1;
      case 1: 
        localfdq.Id = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(125772);
        return 0;
      case 2: 
        localfdq.abDo = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(125772);
        return 0;
      case 3: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localfdp = new fdp();
          if ((localObject != null) && (localObject.length > 0)) {
            localfdp.parseFrom((byte[])localObject);
          }
          localfdq.abDp = localfdp;
          paramInt += 1;
        }
        AppMethodBeat.o(125772);
        return 0;
      case 4: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localfdp = new fdp();
          if ((localObject != null) && (localObject.length > 0)) {
            localfdp.parseFrom((byte[])localObject);
          }
          localfdq.abDq = localfdp;
          paramInt += 1;
        }
        AppMethodBeat.o(125772);
        return 0;
      }
      localfdq.nUv = ((i.a.a.a.a)localObject).ajGk.readString();
      AppMethodBeat.o(125772);
      return 0;
    }
    AppMethodBeat.o(125772);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fdq
 * JD-Core Version:    0.7.0.1
 */