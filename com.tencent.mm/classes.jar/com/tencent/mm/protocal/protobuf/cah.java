package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cah
  extends com.tencent.mm.bx.a
{
  public fns aajj;
  public String aajk = "";
  public int aajl = 0;
  public String aajm = "";
  public boolean aajn = false;
  public boolean aajo = false;
  public long timestamp = 0L;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122493);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aajj != null)
      {
        paramVarArgs.qD(1, this.aajj.computeSize());
        this.aajj.writeFields(paramVarArgs);
      }
      if (this.aajm != null) {
        paramVarArgs.g(2, this.aajm);
      }
      paramVarArgs.di(3, this.aajn);
      if (this.aajk != null) {
        paramVarArgs.g(4, this.aajk);
      }
      paramVarArgs.di(5, this.aajo);
      paramVarArgs.bv(6, this.timestamp);
      paramVarArgs.bS(7, this.aajl);
      AppMethodBeat.o(122493);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aajj == null) {
        break label584;
      }
    }
    label584:
    for (paramInt = i.a.a.a.qC(1, this.aajj.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.aajm != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.aajm);
      }
      i += i.a.a.b.b.a.ko(3) + 1;
      paramInt = i;
      if (this.aajk != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aajk);
      }
      i = i.a.a.b.b.a.ko(5);
      int j = i.a.a.b.b.a.q(6, this.timestamp);
      int k = i.a.a.b.b.a.cJ(7, this.aajl);
      AppMethodBeat.o(122493);
      return paramInt + (i + 1) + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(122493);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        cah localcah = (cah)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122493);
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
            localcah.aajj = localfns;
            paramInt += 1;
          }
          AppMethodBeat.o(122493);
          return 0;
        case 2: 
          localcah.aajm = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(122493);
          return 0;
        case 3: 
          localcah.aajn = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(122493);
          return 0;
        case 4: 
          localcah.aajk = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(122493);
          return 0;
        case 5: 
          localcah.aajo = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(122493);
          return 0;
        case 6: 
          localcah.timestamp = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(122493);
          return 0;
        }
        localcah.aajl = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(122493);
        return 0;
      }
      AppMethodBeat.o(122493);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cah
 * JD-Core Version:    0.7.0.1
 */