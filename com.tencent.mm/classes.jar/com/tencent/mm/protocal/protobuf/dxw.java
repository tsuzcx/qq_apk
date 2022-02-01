package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dxw
  extends dyl
{
  public int CPw;
  public long TVZ;
  public int TxX;
  public long UdA;
  public String UdB;
  public int UdC;
  public int UdD;
  public int UdE;
  public long UdF;
  public String lVG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117902);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(2, this.UdA);
      if (this.UdB != null) {
        paramVarArgs.f(3, this.UdB);
      }
      paramVarArgs.aY(4, this.CPw);
      paramVarArgs.aY(5, this.UdC);
      paramVarArgs.aY(6, this.TxX);
      paramVarArgs.aY(7, this.UdD);
      paramVarArgs.bm(8, this.TVZ);
      paramVarArgs.aY(9, this.UdE);
      if (this.lVG != null) {
        paramVarArgs.f(10, this.lVG);
      }
      paramVarArgs.bm(11, this.UdF);
      AppMethodBeat.o(117902);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label764;
      }
    }
    label764:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.p(2, this.UdA);
      paramInt = i;
      if (this.UdB != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.UdB);
      }
      i = paramInt + g.a.a.b.b.a.bM(4, this.CPw) + g.a.a.b.b.a.bM(5, this.UdC) + g.a.a.b.b.a.bM(6, this.TxX) + g.a.a.b.b.a.bM(7, this.UdD) + g.a.a.b.b.a.p(8, this.TVZ) + g.a.a.b.b.a.bM(9, this.UdE);
      paramInt = i;
      if (this.lVG != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.lVG);
      }
      i = g.a.a.b.b.a.p(11, this.UdF);
      AppMethodBeat.o(117902);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(117902);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        dxw localdxw = (dxw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117902);
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
            localdxw.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(117902);
          return 0;
        case 2: 
          localdxw.UdA = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(117902);
          return 0;
        case 3: 
          localdxw.UdB = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(117902);
          return 0;
        case 4: 
          localdxw.CPw = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(117902);
          return 0;
        case 5: 
          localdxw.UdC = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(117902);
          return 0;
        case 6: 
          localdxw.TxX = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(117902);
          return 0;
        case 7: 
          localdxw.UdD = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(117902);
          return 0;
        case 8: 
          localdxw.TVZ = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(117902);
          return 0;
        case 9: 
          localdxw.UdE = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(117902);
          return 0;
        case 10: 
          localdxw.lVG = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(117902);
          return 0;
        }
        localdxw.UdF = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(117902);
        return 0;
      }
      AppMethodBeat.o(117902);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dxw
 * JD-Core Version:    0.7.0.1
 */