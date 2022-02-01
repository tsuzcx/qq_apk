package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dss
  extends com.tencent.mm.bx.a
{
  public String aaXV;
  public boo aaXW;
  public String aaYp;
  public String aaYq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259617);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aaXV != null) {
        paramVarArgs.g(1, this.aaXV);
      }
      if (this.aaYp != null) {
        paramVarArgs.g(2, this.aaYp);
      }
      if (this.aaYq != null) {
        paramVarArgs.g(3, this.aaYq);
      }
      if (this.aaXW != null)
      {
        paramVarArgs.qD(4, this.aaXW.computeSize());
        this.aaXW.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(259617);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aaXV == null) {
        break label464;
      }
    }
    label464:
    for (int i = i.a.a.b.b.a.h(1, this.aaXV) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aaYp != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.aaYp);
      }
      i = paramInt;
      if (this.aaYq != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.aaYq);
      }
      paramInt = i;
      if (this.aaXW != null) {
        paramInt = i + i.a.a.a.qC(4, this.aaXW.computeSize());
      }
      AppMethodBeat.o(259617);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259617);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        dss localdss = (dss)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259617);
          return -1;
        case 1: 
          localdss.aaXV = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259617);
          return 0;
        case 2: 
          localdss.aaYp = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259617);
          return 0;
        case 3: 
          localdss.aaYq = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259617);
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
          localdss.aaXW = localboo;
          paramInt += 1;
        }
        AppMethodBeat.o(259617);
        return 0;
      }
      AppMethodBeat.o(259617);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dss
 * JD-Core Version:    0.7.0.1
 */