package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class qr
  extends com.tencent.mm.cd.a
{
  public int RYW;
  public int RYX;
  public int RYY;
  public LinkedList<qq> RYZ;
  public LinkedList<qq> RZa;
  
  public qr()
  {
    AppMethodBeat.i(133159);
    this.RYZ = new LinkedList();
    this.RZa = new LinkedList();
    AppMethodBeat.o(133159);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133160);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.RYW);
      paramVarArgs.aY(2, this.RYX);
      paramVarArgs.aY(5, this.RYY);
      paramVarArgs.e(3, 8, this.RYZ);
      paramVarArgs.e(4, 8, this.RZa);
      AppMethodBeat.o(133160);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.RYW);
      i = g.a.a.b.b.a.bM(2, this.RYX);
      int j = g.a.a.b.b.a.bM(5, this.RYY);
      int k = g.a.a.a.c(3, 8, this.RYZ);
      int m = g.a.a.a.c(4, 8, this.RZa);
      AppMethodBeat.o(133160);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.RYZ.clear();
      this.RZa.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(133160);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      qr localqr = (qr)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      qq localqq;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(133160);
        return -1;
      case 1: 
        localqr.RYW = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(133160);
        return 0;
      case 2: 
        localqr.RYX = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(133160);
        return 0;
      case 5: 
        localqr.RYY = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(133160);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localqq = new qq();
          if ((localObject != null) && (localObject.length > 0)) {
            localqq.parseFrom((byte[])localObject);
          }
          localqr.RYZ.add(localqq);
          paramInt += 1;
        }
        AppMethodBeat.o(133160);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        localqq = new qq();
        if ((localObject != null) && (localObject.length > 0)) {
          localqq.parseFrom((byte[])localObject);
        }
        localqr.RZa.add(localqq);
        paramInt += 1;
      }
      AppMethodBeat.o(133160);
      return 0;
    }
    AppMethodBeat.o(133160);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qr
 * JD-Core Version:    0.7.0.1
 */