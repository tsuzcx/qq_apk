package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dek
  extends com.tencent.mm.cd.a
{
  public com.tencent.mm.cd.b RPd;
  public int RPe;
  public int TMc;
  public String TMd;
  public eae TMe;
  public int TMf;
  public int TMg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32359);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TMe == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: ClientKey");
        AppMethodBeat.o(32359);
        throw paramVarArgs;
      }
      paramVarArgs.aY(1, this.TMc);
      if (this.RPd != null) {
        paramVarArgs.c(2, this.RPd);
      }
      if (this.TMd != null) {
        paramVarArgs.f(3, this.TMd);
      }
      if (this.TMe != null)
      {
        paramVarArgs.oE(4, this.TMe.computeSize());
        this.TMe.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(5, this.TMf);
      paramVarArgs.aY(6, this.TMg);
      paramVarArgs.aY(7, this.RPe);
      AppMethodBeat.o(32359);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.TMc) + 0;
      paramInt = i;
      if (this.RPd != null) {
        paramInt = i + g.a.a.b.b.a.b(2, this.RPd);
      }
      i = paramInt;
      if (this.TMd != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.TMd);
      }
      paramInt = i;
      if (this.TMe != null) {
        paramInt = i + g.a.a.a.oD(4, this.TMe.computeSize());
      }
      i = g.a.a.b.b.a.bM(5, this.TMf);
      int j = g.a.a.b.b.a.bM(6, this.TMg);
      int k = g.a.a.b.b.a.bM(7, this.RPe);
      AppMethodBeat.o(32359);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      if (this.TMe == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: ClientKey");
        AppMethodBeat.o(32359);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32359);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      dek localdek = (dek)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32359);
        return -1;
      case 1: 
        localdek.TMc = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(32359);
        return 0;
      case 2: 
        localdek.RPd = ((g.a.a.a.a)localObject).abFh.iUw();
        AppMethodBeat.o(32359);
        return 0;
      case 3: 
        localdek.TMd = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(32359);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          eae localeae = new eae();
          if ((localObject != null) && (localObject.length > 0)) {
            localeae.dd((byte[])localObject);
          }
          localdek.TMe = localeae;
          paramInt += 1;
        }
        AppMethodBeat.o(32359);
        return 0;
      case 5: 
        localdek.TMf = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(32359);
        return 0;
      case 6: 
        localdek.TMg = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(32359);
        return 0;
      }
      localdek.RPe = ((g.a.a.a.a)localObject).abFh.AK();
      AppMethodBeat.o(32359);
      return 0;
    }
    AppMethodBeat.o(32359);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dek
 * JD-Core Version:    0.7.0.1
 */