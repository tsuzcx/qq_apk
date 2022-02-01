package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class fcw
  extends dyl
{
  public int CPw;
  public eae Hnc;
  public int RYY;
  public int Sat;
  public int UCx;
  public LinkedList<eaf> UCy;
  public int UCz;
  public eaf UdT;
  public String UxY;
  public int Uya;
  public int lVs;
  
  public fcw()
  {
    AppMethodBeat.i(148668);
    this.UCy = new LinkedList();
    AppMethodBeat.o(148668);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(148669);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Hnc == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(148669);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Hnc != null)
      {
        paramVarArgs.oE(2, this.Hnc.computeSize());
        this.Hnc.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(3, this.Sat);
      if (this.UxY != null) {
        paramVarArgs.f(4, this.UxY);
      }
      paramVarArgs.aY(5, this.lVs);
      paramVarArgs.aY(6, this.Uya);
      paramVarArgs.aY(7, this.RYY);
      paramVarArgs.aY(8, this.UCx);
      paramVarArgs.e(9, 8, this.UCy);
      if (this.UdT != null)
      {
        paramVarArgs.oE(10, this.UdT.computeSize());
        this.UdT.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(11, this.UCz);
      paramVarArgs.aY(12, this.CPw);
      AppMethodBeat.o(148669);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1094;
      }
    }
    label1094:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Hnc != null) {
        i = paramInt + g.a.a.a.oD(2, this.Hnc.computeSize());
      }
      i += g.a.a.b.b.a.bM(3, this.Sat);
      paramInt = i;
      if (this.UxY != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.UxY);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.lVs) + g.a.a.b.b.a.bM(6, this.Uya) + g.a.a.b.b.a.bM(7, this.RYY) + g.a.a.b.b.a.bM(8, this.UCx) + g.a.a.a.c(9, 8, this.UCy);
      paramInt = i;
      if (this.UdT != null) {
        paramInt = i + g.a.a.a.oD(10, this.UdT.computeSize());
      }
      i = g.a.a.b.b.a.bM(11, this.UCz);
      int j = g.a.a.b.b.a.bM(12, this.CPw);
      AppMethodBeat.o(148669);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.UCy.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.Hnc == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(148669);
          throw paramVarArgs;
        }
        AppMethodBeat.o(148669);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        fcw localfcw = (fcw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(148669);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jg)localObject2).parseFrom((byte[])localObject1);
            }
            localfcw.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(148669);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eae();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eae)localObject2).dd((byte[])localObject1);
            }
            localfcw.Hnc = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(148669);
          return 0;
        case 3: 
          localfcw.Sat = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(148669);
          return 0;
        case 4: 
          localfcw.UxY = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(148669);
          return 0;
        case 5: 
          localfcw.lVs = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(148669);
          return 0;
        case 6: 
          localfcw.Uya = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(148669);
          return 0;
        case 7: 
          localfcw.RYY = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(148669);
          return 0;
        case 8: 
          localfcw.UCx = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(148669);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eaf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eaf)localObject2).de((byte[])localObject1);
            }
            localfcw.UCy.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(148669);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eaf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eaf)localObject2).de((byte[])localObject1);
            }
            localfcw.UdT = ((eaf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(148669);
          return 0;
        case 11: 
          localfcw.UCz = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(148669);
          return 0;
        }
        localfcw.CPw = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(148669);
        return 0;
      }
      AppMethodBeat.o(148669);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fcw
 * JD-Core Version:    0.7.0.1
 */