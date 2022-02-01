package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class dbe
  extends dyy
{
  public b GdC;
  public int SHk;
  public LinkedList<dbj> TIE;
  
  public dbe()
  {
    AppMethodBeat.i(226567);
    this.TIE = new LinkedList();
    AppMethodBeat.o(226567);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(226571);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.GdC != null) {
        paramVarArgs.c(2, this.GdC);
      }
      paramVarArgs.e(3, 8, this.TIE);
      paramVarArgs.aY(4, this.SHk);
      AppMethodBeat.o(226571);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label514;
      }
    }
    label514:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GdC != null) {
        i = paramInt + g.a.a.b.b.a.b(2, this.GdC);
      }
      paramInt = g.a.a.a.c(3, 8, this.TIE);
      int j = g.a.a.b.b.a.bM(4, this.SHk);
      AppMethodBeat.o(226571);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TIE.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(226571);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dbe localdbe = (dbe)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(226571);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localdbe.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(226571);
          return 0;
        case 2: 
          localdbe.GdC = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(226571);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dbj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dbj)localObject2).parseFrom((byte[])localObject1);
            }
            localdbe.TIE.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(226571);
          return 0;
        }
        localdbe.SHk = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(226571);
        return 0;
      }
      AppMethodBeat.o(226571);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbe
 * JD-Core Version:    0.7.0.1
 */