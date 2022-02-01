package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class drc
  extends dyy
{
  public String TSc;
  public String TSd;
  public st TfL;
  public cka TfN;
  public int tqa;
  public String tqb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72563);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72563);
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
      if (this.TfN != null)
      {
        paramVarArgs.oE(4, this.TfN.computeSize());
        this.TfN.writeFields(paramVarArgs);
      }
      if (this.TSc != null) {
        paramVarArgs.f(5, this.TSc);
      }
      if (this.TSd != null) {
        paramVarArgs.f(6, this.TSd);
      }
      if (this.TfL != null)
      {
        paramVarArgs.oE(7, this.TfL.computeSize());
        this.TfL.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72563);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label828;
      }
    }
    label828:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.tqa);
      paramInt = i;
      if (this.tqb != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.tqb);
      }
      i = paramInt;
      if (this.TfN != null) {
        i = paramInt + g.a.a.a.oD(4, this.TfN.computeSize());
      }
      paramInt = i;
      if (this.TSc != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.TSc);
      }
      i = paramInt;
      if (this.TSd != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.TSd);
      }
      paramInt = i;
      if (this.TfL != null) {
        paramInt = i + g.a.a.a.oD(7, this.TfL.computeSize());
      }
      AppMethodBeat.o(72563);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(72563);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72563);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        drc localdrc = (drc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72563);
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
            localdrc.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72563);
          return 0;
        case 2: 
          localdrc.tqa = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(72563);
          return 0;
        case 3: 
          localdrc.tqb = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72563);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cka();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cka)localObject2).parseFrom((byte[])localObject1);
            }
            localdrc.TfN = ((cka)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72563);
          return 0;
        case 5: 
          localdrc.TSc = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72563);
          return 0;
        case 6: 
          localdrc.TSd = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72563);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new st();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((st)localObject2).parseFrom((byte[])localObject1);
          }
          localdrc.TfL = ((st)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(72563);
        return 0;
      }
      AppMethodBeat.o(72563);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.drc
 * JD-Core Version:    0.7.0.1
 */