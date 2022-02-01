package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class ahs
  extends com.tencent.mm.cd.a
{
  public LinkedList<aht> RGi;
  public int cUP;
  public String qJq;
  
  public ahs()
  {
    AppMethodBeat.i(206245);
    this.RGi = new LinkedList();
    AppMethodBeat.o(206245);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(206246);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.RGi);
      if (this.qJq != null) {
        paramVarArgs.f(2, this.qJq);
      }
      paramVarArgs.aY(3, this.cUP);
      AppMethodBeat.o(206246);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.a.c(1, 8, this.RGi) + 0;
      paramInt = i;
      if (this.qJq != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.qJq);
      }
      i = g.a.a.b.b.a.bM(3, this.cUP);
      AppMethodBeat.o(206246);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.RGi.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(206246);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      ahs localahs = (ahs)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(206246);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          aht localaht = new aht();
          if ((localObject != null) && (localObject.length > 0)) {
            localaht.parseFrom((byte[])localObject);
          }
          localahs.RGi.add(localaht);
          paramInt += 1;
        }
        AppMethodBeat.o(206246);
        return 0;
      case 2: 
        localahs.qJq = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(206246);
        return 0;
      }
      localahs.cUP = ((g.a.a.a.a)localObject).abFh.AK();
      AppMethodBeat.o(206246);
      return 0;
    }
    AppMethodBeat.o(206246);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahs
 * JD-Core Version:    0.7.0.1
 */