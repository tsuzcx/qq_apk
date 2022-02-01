package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dml
  extends com.tencent.mm.cd.a
{
  public int CreateTime;
  public String RUd;
  public int TTM;
  public String TTP;
  public String TTQ;
  public int TTR;
  public LinkedList<dme> TTc;
  
  public dml()
  {
    AppMethodBeat.i(205450);
    this.TTc = new LinkedList();
    AppMethodBeat.o(205450);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(205451);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TTP != null) {
        paramVarArgs.f(1, this.TTP);
      }
      if (this.RUd != null) {
        paramVarArgs.f(2, this.RUd);
      }
      paramVarArgs.aY(3, this.CreateTime);
      paramVarArgs.e(4, 8, this.TTc);
      if (this.TTQ != null) {
        paramVarArgs.f(5, this.TTQ);
      }
      paramVarArgs.aY(6, this.TTM);
      paramVarArgs.aY(7, this.TTR);
      AppMethodBeat.o(205451);
      return 0;
    }
    if (paramInt == 1) {
      if (this.TTP == null) {
        break label592;
      }
    }
    label592:
    for (paramInt = g.a.a.b.b.a.g(1, this.TTP) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.RUd != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.RUd);
      }
      i = i + g.a.a.b.b.a.bM(3, this.CreateTime) + g.a.a.a.c(4, 8, this.TTc);
      paramInt = i;
      if (this.TTQ != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.TTQ);
      }
      i = g.a.a.b.b.a.bM(6, this.TTM);
      int j = g.a.a.b.b.a.bM(7, this.TTR);
      AppMethodBeat.o(205451);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TTc.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(205451);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        dml localdml = (dml)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(205451);
          return -1;
        case 1: 
          localdml.TTP = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(205451);
          return 0;
        case 2: 
          localdml.RUd = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(205451);
          return 0;
        case 3: 
          localdml.CreateTime = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(205451);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            dme localdme = new dme();
            if ((localObject != null) && (localObject.length > 0)) {
              localdme.parseFrom((byte[])localObject);
            }
            localdml.TTc.add(localdme);
            paramInt += 1;
          }
          AppMethodBeat.o(205451);
          return 0;
        case 5: 
          localdml.TTQ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(205451);
          return 0;
        case 6: 
          localdml.TTM = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(205451);
          return 0;
        }
        localdml.TTR = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(205451);
        return 0;
      }
      AppMethodBeat.o(205451);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dml
 * JD-Core Version:    0.7.0.1
 */