package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bjy
  extends com.tencent.mm.cd.a
{
  public long SUS;
  public String SUT;
  public LinkedList<String> SUU;
  public LinkedList<bjq> SUV;
  public LinkedList<String> SUW;
  public int style;
  
  public bjy()
  {
    AppMethodBeat.i(198206);
    this.SUU = new LinkedList();
    this.SUV = new LinkedList();
    this.SUW = new LinkedList();
    AppMethodBeat.o(198206);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(198219);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.SUS);
      paramVarArgs.aY(2, this.style);
      if (this.SUT != null) {
        paramVarArgs.f(3, this.SUT);
      }
      paramVarArgs.e(4, 1, this.SUU);
      paramVarArgs.e(5, 8, this.SUV);
      paramVarArgs.e(6, 1, this.SUW);
      AppMethodBeat.o(198219);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.p(1, this.SUS) + 0 + g.a.a.b.b.a.bM(2, this.style);
      paramInt = i;
      if (this.SUT != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.SUT);
      }
      i = g.a.a.a.c(4, 1, this.SUU);
      int j = g.a.a.a.c(5, 8, this.SUV);
      int k = g.a.a.a.c(6, 1, this.SUW);
      AppMethodBeat.o(198219);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.SUU.clear();
      this.SUV.clear();
      this.SUW.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(198219);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      bjy localbjy = (bjy)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(198219);
        return -1;
      case 1: 
        localbjy.SUS = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(198219);
        return 0;
      case 2: 
        localbjy.style = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(198219);
        return 0;
      case 3: 
        localbjy.SUT = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(198219);
        return 0;
      case 4: 
        localbjy.SUU.add(((g.a.a.a.a)localObject).abFh.readString());
        AppMethodBeat.o(198219);
        return 0;
      case 5: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          bjq localbjq = new bjq();
          if ((localObject != null) && (localObject.length > 0)) {
            localbjq.parseFrom((byte[])localObject);
          }
          localbjy.SUV.add(localbjq);
          paramInt += 1;
        }
        AppMethodBeat.o(198219);
        return 0;
      }
      localbjy.SUW.add(((g.a.a.a.a)localObject).abFh.readString());
      AppMethodBeat.o(198219);
      return 0;
    }
    AppMethodBeat.o(198219);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bjy
 * JD-Core Version:    0.7.0.1
 */