package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dsb
  extends com.tencent.mm.bx.a
{
  public String aaXV;
  public boo aaXW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259847);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aaXV != null) {
        paramVarArgs.g(1, this.aaXV);
      }
      if (this.aaXW != null)
      {
        paramVarArgs.qD(2, this.aaXW.computeSize());
        this.aaXW.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(259847);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aaXV == null) {
        break label344;
      }
    }
    label344:
    for (paramInt = i.a.a.b.b.a.h(1, this.aaXV) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.aaXW != null) {
        i = paramInt + i.a.a.a.qC(2, this.aaXW.computeSize());
      }
      AppMethodBeat.o(259847);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259847);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        dsb localdsb = (dsb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259847);
          return -1;
        case 1: 
          localdsb.aaXV = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259847);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          boo localboo = new boo();
          if ((localObject != null) && (localObject.length > 0)) {
            localboo.parseFrom((byte[])localObject);
          }
          localdsb.aaXW = localboo;
          paramInt += 1;
        }
        AppMethodBeat.o(259847);
        return 0;
      }
      AppMethodBeat.o(259847);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dsb
 * JD-Core Version:    0.7.0.1
 */