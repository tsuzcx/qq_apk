package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class diy
  extends com.tencent.mm.cd.a
{
  public eae TQs;
  public int TQt;
  public eae TQu;
  public int uin;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(129972);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.uin);
      paramVarArgs.aY(2, this.version);
      if (this.TQs != null)
      {
        paramVarArgs.oE(3, this.TQs.computeSize());
        this.TQs.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(4, this.TQt);
      if (this.TQu != null)
      {
        paramVarArgs.oE(5, this.TQu.computeSize());
        this.TQu.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(129972);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.uin) + 0 + g.a.a.b.b.a.bM(2, this.version);
      paramInt = i;
      if (this.TQs != null) {
        paramInt = i + g.a.a.a.oD(3, this.TQs.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(4, this.TQt);
      paramInt = i;
      if (this.TQu != null) {
        paramInt = i + g.a.a.a.oD(5, this.TQu.computeSize());
      }
      AppMethodBeat.o(129972);
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
      AppMethodBeat.o(129972);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      diy localdiy = (diy)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      eae localeae;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(129972);
        return -1;
      case 1: 
        localdiy.uin = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(129972);
        return 0;
      case 2: 
        localdiy.version = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(129972);
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
          localdiy.TQs = localeae;
          paramInt += 1;
        }
        AppMethodBeat.o(129972);
        return 0;
      case 4: 
        localdiy.TQt = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(129972);
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
        localdiy.TQu = localeae;
        paramInt += 1;
      }
      AppMethodBeat.o(129972);
      return 0;
    }
    AppMethodBeat.o(129972);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.diy
 * JD-Core Version:    0.7.0.1
 */