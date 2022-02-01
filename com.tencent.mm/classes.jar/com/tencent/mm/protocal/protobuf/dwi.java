package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dwi
  extends com.tencent.mm.bx.a
{
  public boolean aaFd = false;
  public fns aajj;
  public String aajk;
  public boolean aajn = false;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122520);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aajj != null)
      {
        paramVarArgs.qD(1, this.aajj.computeSize());
        this.aajj.writeFields(paramVarArgs);
      }
      paramVarArgs.di(2, this.aajn);
      paramVarArgs.di(3, this.aaFd);
      if (this.aajk != null) {
        paramVarArgs.g(4, this.aajk);
      }
      AppMethodBeat.o(122520);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aajj == null) {
        break label428;
      }
    }
    label428:
    for (paramInt = i.a.a.a.qC(1, this.aajj.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + (i.a.a.b.b.a.ko(2) + 1) + (i.a.a.b.b.a.ko(3) + 1);
      paramInt = i;
      if (this.aajk != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aajk);
      }
      AppMethodBeat.o(122520);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(122520);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        dwi localdwi = (dwi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122520);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            fns localfns = new fns();
            if ((localObject != null) && (localObject.length > 0)) {
              localfns.parseFrom((byte[])localObject);
            }
            localdwi.aajj = localfns;
            paramInt += 1;
          }
          AppMethodBeat.o(122520);
          return 0;
        case 2: 
          localdwi.aajn = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(122520);
          return 0;
        case 3: 
          localdwi.aaFd = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(122520);
          return 0;
        }
        localdwi.aajk = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(122520);
        return 0;
      }
      AppMethodBeat.o(122520);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwi
 * JD-Core Version:    0.7.0.1
 */