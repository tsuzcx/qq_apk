package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dvd
  extends dyl
{
  public int Ubk;
  public int Ubl;
  public LinkedList<dvc> jmy;
  
  public dvd()
  {
    AppMethodBeat.i(210550);
    this.jmy = new LinkedList();
    AppMethodBeat.o(210550);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(210554);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.jmy);
      paramVarArgs.aY(3, this.Ubk);
      paramVarArgs.aY(4, this.Ubl);
      AppMethodBeat.o(210554);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label498;
      }
    }
    label498:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(2, 8, this.jmy);
      int j = g.a.a.b.b.a.bM(3, this.Ubk);
      int k = g.a.a.b.b.a.bM(4, this.Ubl);
      AppMethodBeat.o(210554);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.jmy.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(210554);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dvd localdvd = (dvd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(210554);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jg)localObject2).parseFrom((byte[])localObject1);
            }
            localdvd.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(210554);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dvc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dvc)localObject2).parseFrom((byte[])localObject1);
            }
            localdvd.jmy.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(210554);
          return 0;
        case 3: 
          localdvd.Ubk = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(210554);
          return 0;
        }
        localdvd.Ubl = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(210554);
        return 0;
      }
      AppMethodBeat.o(210554);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvd
 * JD-Core Version:    0.7.0.1
 */