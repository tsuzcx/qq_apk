package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class emt
  extends dyl
{
  public String CRQ;
  public String CRR;
  public String RJQ;
  public LinkedList<ems> UpA;
  public int Upv;
  public int Upw;
  public LinkedList<emv> Upx;
  public ems Upy;
  public int Upz;
  
  public emt()
  {
    AppMethodBeat.i(152697);
    this.Upx = new LinkedList();
    this.UpA = new LinkedList();
    AppMethodBeat.o(152697);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152698);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.Upv);
      if (this.CRR != null) {
        paramVarArgs.f(3, this.CRR);
      }
      if (this.CRQ != null) {
        paramVarArgs.f(4, this.CRQ);
      }
      if (this.RJQ != null) {
        paramVarArgs.f(5, this.RJQ);
      }
      paramVarArgs.aY(6, this.Upw);
      paramVarArgs.e(7, 8, this.Upx);
      if (this.Upy != null)
      {
        paramVarArgs.oE(8, this.Upy.computeSize());
        this.Upy.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(9, this.Upz);
      paramVarArgs.e(10, 8, this.UpA);
      AppMethodBeat.o(152698);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label978;
      }
    }
    label978:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.Upv);
      paramInt = i;
      if (this.CRR != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.CRR);
      }
      i = paramInt;
      if (this.CRQ != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.CRQ);
      }
      paramInt = i;
      if (this.RJQ != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.RJQ);
      }
      i = paramInt + g.a.a.b.b.a.bM(6, this.Upw) + g.a.a.a.c(7, 8, this.Upx);
      paramInt = i;
      if (this.Upy != null) {
        paramInt = i + g.a.a.a.oD(8, this.Upy.computeSize());
      }
      i = g.a.a.b.b.a.bM(9, this.Upz);
      int j = g.a.a.a.c(10, 8, this.UpA);
      AppMethodBeat.o(152698);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Upx.clear();
        this.UpA.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(152698);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        emt localemt = (emt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152698);
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
            localemt.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152698);
          return 0;
        case 2: 
          localemt.Upv = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152698);
          return 0;
        case 3: 
          localemt.CRR = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152698);
          return 0;
        case 4: 
          localemt.CRQ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152698);
          return 0;
        case 5: 
          localemt.RJQ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152698);
          return 0;
        case 6: 
          localemt.Upw = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152698);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new emv();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((emv)localObject2).parseFrom((byte[])localObject1);
            }
            localemt.Upx.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152698);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ems();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ems)localObject2).parseFrom((byte[])localObject1);
            }
            localemt.Upy = ((ems)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152698);
          return 0;
        case 9: 
          localemt.Upz = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152698);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ems();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ems)localObject2).parseFrom((byte[])localObject1);
          }
          localemt.UpA.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(152698);
        return 0;
      }
      AppMethodBeat.o(152698);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.emt
 * JD-Core Version:    0.7.0.1
 */