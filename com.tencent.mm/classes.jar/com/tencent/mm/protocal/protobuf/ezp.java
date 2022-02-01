package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ezp
  extends com.tencent.mm.cd.a
{
  public String CMB;
  public eae UzR;
  public eae UzS;
  public int ffF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32492);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UzR == null)
      {
        paramVarArgs = new b("Not all required fields were included: Icon");
        AppMethodBeat.o(32492);
        throw paramVarArgs;
      }
      if (this.UzS == null)
      {
        paramVarArgs = new b("Not all required fields were included: HDIcon");
        AppMethodBeat.o(32492);
        throw paramVarArgs;
      }
      paramVarArgs.aY(1, this.ffF);
      if (this.CMB != null) {
        paramVarArgs.f(2, this.CMB);
      }
      if (this.UzR != null)
      {
        paramVarArgs.oE(3, this.UzR.computeSize());
        this.UzR.writeFields(paramVarArgs);
      }
      if (this.UzS != null)
      {
        paramVarArgs.oE(4, this.UzS.computeSize());
        this.UzS.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32492);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.ffF) + 0;
      paramInt = i;
      if (this.CMB != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.CMB);
      }
      i = paramInt;
      if (this.UzR != null) {
        i = paramInt + g.a.a.a.oD(3, this.UzR.computeSize());
      }
      paramInt = i;
      if (this.UzS != null) {
        paramInt = i + g.a.a.a.oD(4, this.UzS.computeSize());
      }
      AppMethodBeat.o(32492);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      if (this.UzR == null)
      {
        paramVarArgs = new b("Not all required fields were included: Icon");
        AppMethodBeat.o(32492);
        throw paramVarArgs;
      }
      if (this.UzS == null)
      {
        paramVarArgs = new b("Not all required fields were included: HDIcon");
        AppMethodBeat.o(32492);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32492);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      ezp localezp = (ezp)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      eae localeae;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32492);
        return -1;
      case 1: 
        localezp.ffF = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(32492);
        return 0;
      case 2: 
        localezp.CMB = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(32492);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localeae = new eae();
          if ((localObject != null) && (localObject.length > 0)) {
            localeae.dd((byte[])localObject);
          }
          localezp.UzR = localeae;
          paramInt += 1;
        }
        AppMethodBeat.o(32492);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        localeae = new eae();
        if ((localObject != null) && (localObject.length > 0)) {
          localeae.dd((byte[])localObject);
        }
        localezp.UzS = localeae;
        paramInt += 1;
      }
      AppMethodBeat.o(32492);
      return 0;
    }
    AppMethodBeat.o(32492);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ezp
 * JD-Core Version:    0.7.0.1
 */