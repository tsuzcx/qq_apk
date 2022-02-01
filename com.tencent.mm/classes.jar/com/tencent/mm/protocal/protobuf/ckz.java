package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ckz
  extends com.tencent.mm.cd.a
{
  public String TsB;
  public String TsC;
  public String TsD;
  public dho TsE;
  public String Tsx;
  public int fOY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72508);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Tsx == null)
      {
        paramVarArgs = new b("Not all required fields were included: session_data");
        AppMethodBeat.o(72508);
        throw paramVarArgs;
      }
      paramVarArgs.aY(1, this.fOY);
      if (this.Tsx != null) {
        paramVarArgs.f(2, this.Tsx);
      }
      if (this.TsB != null) {
        paramVarArgs.f(3, this.TsB);
      }
      if (this.TsC != null) {
        paramVarArgs.f(4, this.TsC);
      }
      if (this.TsD != null) {
        paramVarArgs.f(5, this.TsD);
      }
      if (this.TsE != null)
      {
        paramVarArgs.oE(6, this.TsE.computeSize());
        this.TsE.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72508);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.fOY) + 0;
      paramInt = i;
      if (this.Tsx != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.Tsx);
      }
      i = paramInt;
      if (this.TsB != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.TsB);
      }
      paramInt = i;
      if (this.TsC != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.TsC);
      }
      i = paramInt;
      if (this.TsD != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.TsD);
      }
      paramInt = i;
      if (this.TsE != null) {
        paramInt = i + g.a.a.a.oD(6, this.TsE.computeSize());
      }
      AppMethodBeat.o(72508);
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
      if (this.Tsx == null)
      {
        paramVarArgs = new b("Not all required fields were included: session_data");
        AppMethodBeat.o(72508);
        throw paramVarArgs;
      }
      AppMethodBeat.o(72508);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      ckz localckz = (ckz)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(72508);
        return -1;
      case 1: 
        localckz.fOY = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(72508);
        return 0;
      case 2: 
        localckz.Tsx = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(72508);
        return 0;
      case 3: 
        localckz.TsB = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(72508);
        return 0;
      case 4: 
        localckz.TsC = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(72508);
        return 0;
      case 5: 
        localckz.TsD = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(72508);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        dho localdho = new dho();
        if ((localObject != null) && (localObject.length > 0)) {
          localdho.parseFrom((byte[])localObject);
        }
        localckz.TsE = localdho;
        paramInt += 1;
      }
      AppMethodBeat.o(72508);
      return 0;
    }
    AppMethodBeat.o(72508);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ckz
 * JD-Core Version:    0.7.0.1
 */