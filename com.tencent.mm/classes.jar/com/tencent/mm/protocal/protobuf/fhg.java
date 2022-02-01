package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fhg
  extends com.tencent.mm.bx.a
{
  public fns aaEZ;
  public fns aaFa;
  public String aaFb;
  public String aaFc;
  public String aajk;
  public String aajm;
  public boolean aajn = false;
  public int flags;
  public long timestamp = 0L;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122550);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aaEZ != null)
      {
        paramVarArgs.qD(1, this.aaEZ.computeSize());
        this.aaEZ.writeFields(paramVarArgs);
      }
      if (this.aaFa != null)
      {
        paramVarArgs.qD(2, this.aaFa.computeSize());
        this.aaFa.writeFields(paramVarArgs);
      }
      paramVarArgs.di(3, this.aajn);
      if (this.aajk != null) {
        paramVarArgs.g(4, this.aajk);
      }
      paramVarArgs.bS(5, this.flags);
      if (this.aajm != null) {
        paramVarArgs.g(6, this.aajm);
      }
      if (this.aaFb != null) {
        paramVarArgs.g(7, this.aaFb);
      }
      if (this.aaFc != null) {
        paramVarArgs.g(8, this.aaFc);
      }
      paramVarArgs.bv(9, this.timestamp);
      AppMethodBeat.o(122550);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aaEZ == null) {
        break label794;
      }
    }
    label794:
    for (paramInt = i.a.a.a.qC(1, this.aaEZ.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.aaFa != null) {
        i = paramInt + i.a.a.a.qC(2, this.aaFa.computeSize());
      }
      i += i.a.a.b.b.a.ko(3) + 1;
      paramInt = i;
      if (this.aajk != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aajk);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.flags);
      paramInt = i;
      if (this.aajm != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.aajm);
      }
      i = paramInt;
      if (this.aaFb != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.aaFb);
      }
      paramInt = i;
      if (this.aaFc != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.aaFc);
      }
      i = i.a.a.b.b.a.q(9, this.timestamp);
      AppMethodBeat.o(122550);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(122550);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        fhg localfhg = (fhg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        fns localfns;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122550);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localfns = new fns();
            if ((localObject != null) && (localObject.length > 0)) {
              localfns.parseFrom((byte[])localObject);
            }
            localfhg.aaEZ = localfns;
            paramInt += 1;
          }
          AppMethodBeat.o(122550);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localfns = new fns();
            if ((localObject != null) && (localObject.length > 0)) {
              localfns.parseFrom((byte[])localObject);
            }
            localfhg.aaFa = localfns;
            paramInt += 1;
          }
          AppMethodBeat.o(122550);
          return 0;
        case 3: 
          localfhg.aajn = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(122550);
          return 0;
        case 4: 
          localfhg.aajk = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(122550);
          return 0;
        case 5: 
          localfhg.flags = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(122550);
          return 0;
        case 6: 
          localfhg.aajm = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(122550);
          return 0;
        case 7: 
          localfhg.aaFb = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(122550);
          return 0;
        case 8: 
          localfhg.aaFc = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(122550);
          return 0;
        }
        localfhg.timestamp = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(122550);
        return 0;
      }
      AppMethodBeat.o(122550);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fhg
 * JD-Core Version:    0.7.0.1
 */