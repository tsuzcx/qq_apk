package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bsg
  extends com.tencent.mm.bx.a
{
  public fes aaae;
  public String aaaf;
  public String aaag;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259997);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aaae != null)
      {
        paramVarArgs.qD(1, this.aaae.computeSize());
        this.aaae.writeFields(paramVarArgs);
      }
      if (this.aaaf != null) {
        paramVarArgs.g(2, this.aaaf);
      }
      if (this.aaag != null) {
        paramVarArgs.g(3, this.aaag);
      }
      AppMethodBeat.o(259997);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aaae == null) {
        break label404;
      }
    }
    label404:
    for (int i = i.a.a.a.qC(1, this.aaae.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aaaf != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.aaaf);
      }
      i = paramInt;
      if (this.aaag != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.aaag);
      }
      AppMethodBeat.o(259997);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259997);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        bsg localbsg = (bsg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259997);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            fes localfes = new fes();
            if ((localObject != null) && (localObject.length > 0)) {
              localfes.parseFrom((byte[])localObject);
            }
            localbsg.aaae = localfes;
            paramInt += 1;
          }
          AppMethodBeat.o(259997);
          return 0;
        case 2: 
          localbsg.aaaf = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259997);
          return 0;
        }
        localbsg.aaag = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(259997);
        return 0;
      }
      AppMethodBeat.o(259997);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bsg
 * JD-Core Version:    0.7.0.1
 */