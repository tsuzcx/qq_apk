package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class fdv
  extends dyl
{
  public String CRQ;
  public int Svu;
  public long Svv;
  public int TWa;
  public String TWw;
  public long UCJ;
  public ffd UDE;
  public int UDF;
  public int UDG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115868);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UDE == null)
      {
        paramVarArgs = new b("Not all required fields were included: ReportData");
        AppMethodBeat.o(115868);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.TWw != null) {
        paramVarArgs.f(2, this.TWw);
      }
      paramVarArgs.aY(3, this.Svu);
      paramVarArgs.bm(4, this.Svv);
      if (this.CRQ != null) {
        paramVarArgs.f(6, this.CRQ);
      }
      if (this.UDE != null)
      {
        paramVarArgs.oE(8, this.UDE.computeSize());
        this.UDE.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(9, this.UDF);
      paramVarArgs.bm(10, this.UCJ);
      paramVarArgs.aY(11, this.TWa);
      paramVarArgs.aY(12, this.UDG);
      AppMethodBeat.o(115868);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label878;
      }
    }
    label878:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.TWw != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.TWw);
      }
      i = i + g.a.a.b.b.a.bM(3, this.Svu) + g.a.a.b.b.a.p(4, this.Svv);
      paramInt = i;
      if (this.CRQ != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.CRQ);
      }
      i = paramInt;
      if (this.UDE != null) {
        i = paramInt + g.a.a.a.oD(8, this.UDE.computeSize());
      }
      paramInt = g.a.a.b.b.a.bM(9, this.UDF);
      int j = g.a.a.b.b.a.p(10, this.UCJ);
      int k = g.a.a.b.b.a.bM(11, this.TWa);
      int m = g.a.a.b.b.a.bM(12, this.UDG);
      AppMethodBeat.o(115868);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.UDE == null)
        {
          paramVarArgs = new b("Not all required fields were included: ReportData");
          AppMethodBeat.o(115868);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115868);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        fdv localfdv = (fdv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 5: 
        case 7: 
        default: 
          AppMethodBeat.o(115868);
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
            localfdv.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115868);
          return 0;
        case 2: 
          localfdv.TWw = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(115868);
          return 0;
        case 3: 
          localfdv.Svu = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115868);
          return 0;
        case 4: 
          localfdv.Svv = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(115868);
          return 0;
        case 6: 
          localfdv.CRQ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(115868);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ffd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ffd)localObject2).parseFrom((byte[])localObject1);
            }
            localfdv.UDE = ((ffd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115868);
          return 0;
        case 9: 
          localfdv.UDF = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115868);
          return 0;
        case 10: 
          localfdv.UCJ = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(115868);
          return 0;
        case 11: 
          localfdv.TWa = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115868);
          return 0;
        }
        localfdv.UDG = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(115868);
        return 0;
      }
      AppMethodBeat.o(115868);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fdv
 * JD-Core Version:    0.7.0.1
 */