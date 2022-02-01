package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class pv
  extends com.tencent.mm.cd.a
{
  public int RYe;
  public LinkedList<pw> RYf;
  public int type;
  public int uin;
  public int update_time;
  public int version;
  
  public pv()
  {
    AppMethodBeat.i(124455);
    this.RYf = new LinkedList();
    AppMethodBeat.o(124455);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124456);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.uin);
      paramVarArgs.aY(2, this.RYe);
      paramVarArgs.aY(3, this.update_time);
      paramVarArgs.e(4, 8, this.RYf);
      paramVarArgs.aY(5, this.version);
      paramVarArgs.aY(6, this.type);
      AppMethodBeat.o(124456);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.uin);
      i = g.a.a.b.b.a.bM(2, this.RYe);
      int j = g.a.a.b.b.a.bM(3, this.update_time);
      int k = g.a.a.a.c(4, 8, this.RYf);
      int m = g.a.a.b.b.a.bM(5, this.version);
      int n = g.a.a.b.b.a.bM(6, this.type);
      AppMethodBeat.o(124456);
      return paramInt + 0 + i + j + k + m + n;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.RYf.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(124456);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      pv localpv = (pv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(124456);
        return -1;
      case 1: 
        localpv.uin = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(124456);
        return 0;
      case 2: 
        localpv.RYe = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(124456);
        return 0;
      case 3: 
        localpv.update_time = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(124456);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          pw localpw = new pw();
          if ((localObject != null) && (localObject.length > 0)) {
            localpw.parseFrom((byte[])localObject);
          }
          localpv.RYf.add(localpw);
          paramInt += 1;
        }
        AppMethodBeat.o(124456);
        return 0;
      case 5: 
        localpv.version = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(124456);
        return 0;
      }
      localpv.type = ((g.a.a.a.a)localObject).abFh.AK();
      AppMethodBeat.o(124456);
      return 0;
    }
    AppMethodBeat.o(124456);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pv
 * JD-Core Version:    0.7.0.1
 */