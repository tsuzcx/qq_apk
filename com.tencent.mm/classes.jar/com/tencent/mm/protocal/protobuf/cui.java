package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class cui
  extends dyl
{
  public long HLI;
  public int TBY;
  public LinkedList<b> TBZ;
  public long TCa;
  public long TCb;
  public float latitude;
  public float longitude;
  
  public cui()
  {
    AppMethodBeat.i(169918);
    this.TBZ = new LinkedList();
    AppMethodBeat.o(169918);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169919);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.TBY);
      paramVarArgs.i(3, this.latitude);
      paramVarArgs.i(4, this.longitude);
      paramVarArgs.e(5, 6, this.TBZ);
      paramVarArgs.bm(6, this.HLI);
      paramVarArgs.bm(7, this.TCa);
      paramVarArgs.bm(8, this.TCb);
      AppMethodBeat.o(169919);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label634;
      }
    }
    label634:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.TBY);
      int j = g.a.a.b.b.a.gL(3);
      int k = g.a.a.b.b.a.gL(4);
      int m = g.a.a.a.c(5, 6, this.TBZ);
      int n = g.a.a.b.b.a.p(6, this.HLI);
      int i1 = g.a.a.b.b.a.p(7, this.TCa);
      int i2 = g.a.a.b.b.a.p(8, this.TCb);
      AppMethodBeat.o(169919);
      return paramInt + i + (j + 4) + (k + 4) + m + n + i1 + i2;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TBZ.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(169919);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        cui localcui = (cui)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169919);
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
            localcui.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(169919);
          return 0;
        case 2: 
          localcui.TBY = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(169919);
          return 0;
        case 3: 
          localcui.latitude = Float.intBitsToFloat(((g.a.a.a.a)localObject).abFh.AO());
          AppMethodBeat.o(169919);
          return 0;
        case 4: 
          localcui.longitude = Float.intBitsToFloat(((g.a.a.a.a)localObject).abFh.AO());
          AppMethodBeat.o(169919);
          return 0;
        case 5: 
          localcui.TBZ.add(((g.a.a.a.a)localObject).abFh.iUw());
          AppMethodBeat.o(169919);
          return 0;
        case 6: 
          localcui.HLI = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(169919);
          return 0;
        case 7: 
          localcui.TCa = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(169919);
          return 0;
        }
        localcui.TCb = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(169919);
        return 0;
      }
      AppMethodBeat.o(169919);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cui
 * JD-Core Version:    0.7.0.1
 */