package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dqu
  extends dyy
{
  public String OMa;
  public dmr RQv;
  public String TXq;
  public LinkedList<it> TXr;
  public int tqa;
  public String tqb;
  
  public dqu()
  {
    AppMethodBeat.i(72553);
    this.TXr = new LinkedList();
    AppMethodBeat.o(72553);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72554);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72554);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.tqa);
      if (this.tqb != null) {
        paramVarArgs.f(3, this.tqb);
      }
      if (this.TXq != null) {
        paramVarArgs.f(4, this.TXq);
      }
      paramVarArgs.e(5, 8, this.TXr);
      if (this.RQv != null)
      {
        paramVarArgs.oE(6, this.RQv.computeSize());
        this.RQv.writeFields(paramVarArgs);
      }
      if (this.OMa != null) {
        paramVarArgs.f(7, this.OMa);
      }
      AppMethodBeat.o(72554);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label816;
      }
    }
    label816:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.tqa);
      paramInt = i;
      if (this.tqb != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.tqb);
      }
      i = paramInt;
      if (this.TXq != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.TXq);
      }
      i += g.a.a.a.c(5, 8, this.TXr);
      paramInt = i;
      if (this.RQv != null) {
        paramInt = i + g.a.a.a.oD(6, this.RQv.computeSize());
      }
      i = paramInt;
      if (this.OMa != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.OMa);
      }
      AppMethodBeat.o(72554);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TXr.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(72554);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72554);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dqu localdqu = (dqu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72554);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localdqu.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72554);
          return 0;
        case 2: 
          localdqu.tqa = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(72554);
          return 0;
        case 3: 
          localdqu.tqb = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72554);
          return 0;
        case 4: 
          localdqu.TXq = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72554);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new it();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((it)localObject2).parseFrom((byte[])localObject1);
            }
            localdqu.TXr.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72554);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dmr();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dmr)localObject2).parseFrom((byte[])localObject1);
            }
            localdqu.RQv = ((dmr)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72554);
          return 0;
        }
        localdqu.OMa = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(72554);
        return 0;
      }
      AppMethodBeat.o(72554);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dqu
 * JD-Core Version:    0.7.0.1
 */