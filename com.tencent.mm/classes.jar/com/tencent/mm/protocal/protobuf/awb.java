package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class awb
  extends com.tencent.mm.cd.a
{
  public LinkedList<awr> SIu;
  public int SIv;
  public long object_id;
  public String title;
  
  public awb()
  {
    AppMethodBeat.i(200743);
    this.SIu = new LinkedList();
    AppMethodBeat.o(200743);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(200751);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.object_id);
      paramVarArgs.e(2, 8, this.SIu);
      if (this.title != null) {
        paramVarArgs.f(3, this.title);
      }
      paramVarArgs.aY(4, this.SIv);
      AppMethodBeat.o(200751);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.p(1, this.object_id) + 0 + g.a.a.a.c(2, 8, this.SIu);
      paramInt = i;
      if (this.title != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.title);
      }
      i = g.a.a.b.b.a.bM(4, this.SIv);
      AppMethodBeat.o(200751);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.SIu.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(200751);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      awb localawb = (awb)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(200751);
        return -1;
      case 1: 
        localawb.object_id = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(200751);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          awr localawr = new awr();
          if ((localObject != null) && (localObject.length > 0)) {
            localawr.parseFrom((byte[])localObject);
          }
          localawb.SIu.add(localawr);
          paramInt += 1;
        }
        AppMethodBeat.o(200751);
        return 0;
      case 3: 
        localawb.title = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(200751);
        return 0;
      }
      localawb.SIv = ((g.a.a.a.a)localObject).abFh.AK();
      AppMethodBeat.o(200751);
      return 0;
    }
    AppMethodBeat.o(200751);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awb
 * JD-Core Version:    0.7.0.1
 */