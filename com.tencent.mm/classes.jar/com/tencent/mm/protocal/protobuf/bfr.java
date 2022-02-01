package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bfr
  extends com.tencent.mm.cd.a
{
  public bac SQs;
  public LinkedList<String> SQt;
  public LinkedList<String> SQu;
  public long object_id;
  
  public bfr()
  {
    AppMethodBeat.i(197037);
    this.SQt = new LinkedList();
    this.SQu = new LinkedList();
    AppMethodBeat.o(197037);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(197047);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.object_id);
      if (this.SQs != null)
      {
        paramVarArgs.oE(2, this.SQs.computeSize());
        this.SQs.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 1, this.SQt);
      paramVarArgs.e(4, 1, this.SQu);
      AppMethodBeat.o(197047);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.p(1, this.object_id) + 0;
      paramInt = i;
      if (this.SQs != null) {
        paramInt = i + g.a.a.a.oD(2, this.SQs.computeSize());
      }
      i = g.a.a.a.c(3, 1, this.SQt);
      int j = g.a.a.a.c(4, 1, this.SQu);
      AppMethodBeat.o(197047);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.SQt.clear();
      this.SQu.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(197047);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      bfr localbfr = (bfr)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(197047);
        return -1;
      case 1: 
        localbfr.object_id = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(197047);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          bac localbac = new bac();
          if ((localObject != null) && (localObject.length > 0)) {
            localbac.parseFrom((byte[])localObject);
          }
          localbfr.SQs = localbac;
          paramInt += 1;
        }
        AppMethodBeat.o(197047);
        return 0;
      case 3: 
        localbfr.SQt.add(((g.a.a.a.a)localObject).abFh.readString());
        AppMethodBeat.o(197047);
        return 0;
      }
      localbfr.SQu.add(((g.a.a.a.a)localObject).abFh.readString());
      AppMethodBeat.o(197047);
      return 0;
    }
    AppMethodBeat.o(197047);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfr
 * JD-Core Version:    0.7.0.1
 */