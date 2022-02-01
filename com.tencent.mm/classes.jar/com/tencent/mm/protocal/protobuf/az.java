package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class az
  extends com.tencent.mm.cd.a
{
  public String RFG;
  public LinkedList<dgc> RFH;
  public LinkedList<dgb> fmW;
  
  public az()
  {
    AppMethodBeat.i(152476);
    this.RFH = new LinkedList();
    this.fmW = new LinkedList();
    AppMethodBeat.o(152476);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152477);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RFG != null) {
        paramVarArgs.f(1, this.RFG);
      }
      paramVarArgs.e(2, 8, this.RFH);
      paramVarArgs.e(3, 8, this.fmW);
      AppMethodBeat.o(152477);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RFG == null) {
        break label454;
      }
    }
    label454:
    for (paramInt = g.a.a.b.b.a.g(1, this.RFG) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(2, 8, this.RFH);
      int j = g.a.a.a.c(3, 8, this.fmW);
      AppMethodBeat.o(152477);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.RFH.clear();
        this.fmW.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(152477);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        az localaz = (az)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152477);
          return -1;
        case 1: 
          localaz.RFG = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152477);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dgc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dgc)localObject2).parseFrom((byte[])localObject1);
            }
            localaz.RFH.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152477);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dgb();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dgb)localObject2).parseFrom((byte[])localObject1);
          }
          localaz.fmW.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(152477);
        return 0;
      }
      AppMethodBeat.o(152477);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.az
 * JD-Core Version:    0.7.0.1
 */