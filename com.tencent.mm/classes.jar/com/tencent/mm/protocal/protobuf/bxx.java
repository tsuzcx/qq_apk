package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bxx
  extends com.tencent.mm.bx.a
{
  public String aagM;
  public bxv hLt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258238);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.hLt != null)
      {
        paramVarArgs.qD(1, this.hLt.computeSize());
        this.hLt.writeFields(paramVarArgs);
      }
      if (this.aagM != null) {
        paramVarArgs.g(2, this.aagM);
      }
      AppMethodBeat.o(258238);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hLt == null) {
        break label344;
      }
    }
    label344:
    for (paramInt = i.a.a.a.qC(1, this.hLt.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.aagM != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.aagM);
      }
      AppMethodBeat.o(258238);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258238);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        bxx localbxx = (bxx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258238);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            bxv localbxv = new bxv();
            if ((localObject != null) && (localObject.length > 0)) {
              localbxv.parseFrom((byte[])localObject);
            }
            localbxx.hLt = localbxv;
            paramInt += 1;
          }
          AppMethodBeat.o(258238);
          return 0;
        }
        localbxx.aagM = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(258238);
        return 0;
      }
      AppMethodBeat.o(258238);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxx
 * JD-Core Version:    0.7.0.1
 */