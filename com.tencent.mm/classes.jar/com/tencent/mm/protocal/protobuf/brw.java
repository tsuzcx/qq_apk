package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class brw
  extends dyl
{
  public String SeA;
  public long SeN;
  public int SfD;
  public double latitude;
  public double longitude;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114015);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.SeA != null) {
        paramVarArgs.f(2, this.SeA);
      }
      paramVarArgs.e(3, this.latitude);
      paramVarArgs.e(4, this.longitude);
      paramVarArgs.bm(5, this.SeN);
      paramVarArgs.aY(6, this.SfD);
      paramVarArgs.aY(7, this.scene);
      AppMethodBeat.o(114015);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label586;
      }
    }
    label586:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.SeA != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.SeA);
      }
      paramInt = g.a.a.b.b.a.gL(3);
      int j = g.a.a.b.b.a.gL(4);
      int k = g.a.a.b.b.a.p(5, this.SeN);
      int m = g.a.a.b.b.a.bM(6, this.SfD);
      int n = g.a.a.b.b.a.bM(7, this.scene);
      AppMethodBeat.o(114015);
      return i + (paramInt + 8) + (j + 8) + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(114015);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        brw localbrw = (brw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114015);
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
            localbrw.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(114015);
          return 0;
        case 2: 
          localbrw.SeA = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(114015);
          return 0;
        case 3: 
          localbrw.latitude = Double.longBitsToDouble(((g.a.a.a.a)localObject).abFh.AP());
          AppMethodBeat.o(114015);
          return 0;
        case 4: 
          localbrw.longitude = Double.longBitsToDouble(((g.a.a.a.a)localObject).abFh.AP());
          AppMethodBeat.o(114015);
          return 0;
        case 5: 
          localbrw.SeN = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(114015);
          return 0;
        case 6: 
          localbrw.SfD = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(114015);
          return 0;
        }
        localbrw.scene = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(114015);
        return 0;
      }
      AppMethodBeat.o(114015);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.brw
 * JD-Core Version:    0.7.0.1
 */