package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aig
  extends dyl
{
  public int HlE;
  public long HlH;
  public int HmZ;
  public int Hna;
  public int SsZ;
  public int Sta;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127170);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.HlE);
      paramVarArgs.aY(3, this.HmZ);
      paramVarArgs.aY(4, this.Hna);
      paramVarArgs.aY(5, this.SsZ);
      paramVarArgs.aY(6, this.Sta);
      paramVarArgs.bm(7, this.HlH);
      AppMethodBeat.o(127170);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label568;
      }
    }
    label568:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.HlE);
      int j = g.a.a.b.b.a.bM(3, this.HmZ);
      int k = g.a.a.b.b.a.bM(4, this.Hna);
      int m = g.a.a.b.b.a.bM(5, this.SsZ);
      int n = g.a.a.b.b.a.bM(6, this.Sta);
      int i1 = g.a.a.b.b.a.p(7, this.HlH);
      AppMethodBeat.o(127170);
      return paramInt + i + j + k + m + n + i1;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(127170);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        aig localaig = (aig)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(127170);
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
            localaig.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(127170);
          return 0;
        case 2: 
          localaig.HlE = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(127170);
          return 0;
        case 3: 
          localaig.HmZ = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(127170);
          return 0;
        case 4: 
          localaig.Hna = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(127170);
          return 0;
        case 5: 
          localaig.SsZ = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(127170);
          return 0;
        case 6: 
          localaig.Sta = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(127170);
          return 0;
        }
        localaig.HlH = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(127170);
        return 0;
      }
      AppMethodBeat.o(127170);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aig
 * JD-Core Version:    0.7.0.1
 */