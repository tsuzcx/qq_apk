package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class od
  extends dyl
{
  public LinkedList<String> RVr;
  public b RVs;
  public int RVt;
  public int scene;
  
  public od()
  {
    AppMethodBeat.i(207829);
    this.RVr = new LinkedList();
    AppMethodBeat.o(207829);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(207832);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 1, this.RVr);
      if (this.RVs != null) {
        paramVarArgs.c(3, this.RVs);
      }
      paramVarArgs.aY(4, this.RVt);
      paramVarArgs.aY(5, this.scene);
      AppMethodBeat.o(207832);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label496;
      }
    }
    label496:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 1, this.RVr);
      paramInt = i;
      if (this.RVs != null) {
        paramInt = i + g.a.a.b.b.a.b(3, this.RVs);
      }
      i = g.a.a.b.b.a.bM(4, this.RVt);
      int j = g.a.a.b.b.a.bM(5, this.scene);
      AppMethodBeat.o(207832);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.RVr.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(207832);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        od localod = (od)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(207832);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jg localjg = new jg();
            if ((localObject != null) && (localObject.length > 0)) {
              localjg.parseFrom((byte[])localObject);
            }
            localod.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(207832);
          return 0;
        case 2: 
          localod.RVr.add(((g.a.a.a.a)localObject).abFh.readString());
          AppMethodBeat.o(207832);
          return 0;
        case 3: 
          localod.RVs = ((g.a.a.a.a)localObject).abFh.iUw();
          AppMethodBeat.o(207832);
          return 0;
        case 4: 
          localod.RVt = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(207832);
          return 0;
        }
        localod.scene = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(207832);
        return 0;
      }
      AppMethodBeat.o(207832);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.od
 * JD-Core Version:    0.7.0.1
 */