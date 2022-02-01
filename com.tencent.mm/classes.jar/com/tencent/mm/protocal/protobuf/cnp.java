package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class cnp
  extends dyy
{
  public String CQz;
  public String RGJ;
  public cmt TuR;
  public String TuU;
  public String TuV;
  public String TuW;
  public dy TuX;
  public eax Tvi;
  public afd Tvj;
  public boolean Tvk;
  public eyy Tvl;
  public com.tencent.mm.cd.b rVk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123619);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123619);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.TuR != null)
      {
        paramVarArgs.oE(2, this.TuR.computeSize());
        this.TuR.writeFields(paramVarArgs);
      }
      if (this.rVk != null) {
        paramVarArgs.c(3, this.rVk);
      }
      if (this.Tvi != null)
      {
        paramVarArgs.oE(4, this.Tvi.computeSize());
        this.Tvi.writeFields(paramVarArgs);
      }
      if (this.CQz != null) {
        paramVarArgs.f(5, this.CQz);
      }
      if (this.RGJ != null) {
        paramVarArgs.f(6, this.RGJ);
      }
      if (this.Tvj != null)
      {
        paramVarArgs.oE(7, this.Tvj.computeSize());
        this.Tvj.writeFields(paramVarArgs);
      }
      paramVarArgs.co(8, this.Tvk);
      if (this.TuU != null) {
        paramVarArgs.f(9, this.TuU);
      }
      if (this.TuV != null) {
        paramVarArgs.f(10, this.TuV);
      }
      if (this.TuW != null) {
        paramVarArgs.f(11, this.TuW);
      }
      if (this.Tvl != null)
      {
        paramVarArgs.oE(12, this.Tvl.computeSize());
        this.Tvl.writeFields(paramVarArgs);
      }
      if (this.TuX != null)
      {
        paramVarArgs.oE(13, this.TuX.computeSize());
        this.TuX.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(123619);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1414;
      }
    }
    label1414:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.TuR != null) {
        paramInt = i + g.a.a.a.oD(2, this.TuR.computeSize());
      }
      i = paramInt;
      if (this.rVk != null) {
        i = paramInt + g.a.a.b.b.a.b(3, this.rVk);
      }
      paramInt = i;
      if (this.Tvi != null) {
        paramInt = i + g.a.a.a.oD(4, this.Tvi.computeSize());
      }
      i = paramInt;
      if (this.CQz != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.CQz);
      }
      paramInt = i;
      if (this.RGJ != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.RGJ);
      }
      i = paramInt;
      if (this.Tvj != null) {
        i = paramInt + g.a.a.a.oD(7, this.Tvj.computeSize());
      }
      i += g.a.a.b.b.a.gL(8) + 1;
      paramInt = i;
      if (this.TuU != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.TuU);
      }
      i = paramInt;
      if (this.TuV != null) {
        i = paramInt + g.a.a.b.b.a.g(10, this.TuV);
      }
      paramInt = i;
      if (this.TuW != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.TuW);
      }
      i = paramInt;
      if (this.Tvl != null) {
        i = paramInt + g.a.a.a.oD(12, this.Tvl.computeSize());
      }
      paramInt = i;
      if (this.TuX != null) {
        paramInt = i + g.a.a.a.oD(13, this.TuX.computeSize());
      }
      AppMethodBeat.o(123619);
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
          paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(123619);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123619);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cnp localcnp = (cnp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123619);
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
            localcnp.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123619);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cmt();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cmt)localObject2).parseFrom((byte[])localObject1);
            }
            localcnp.TuR = ((cmt)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123619);
          return 0;
        case 3: 
          localcnp.rVk = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(123619);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eax();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eax)localObject2).parseFrom((byte[])localObject1);
            }
            localcnp.Tvi = ((eax)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123619);
          return 0;
        case 5: 
          localcnp.CQz = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(123619);
          return 0;
        case 6: 
          localcnp.RGJ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(123619);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new afd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((afd)localObject2).parseFrom((byte[])localObject1);
            }
            localcnp.Tvj = ((afd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123619);
          return 0;
        case 8: 
          localcnp.Tvk = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(123619);
          return 0;
        case 9: 
          localcnp.TuU = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(123619);
          return 0;
        case 10: 
          localcnp.TuV = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(123619);
          return 0;
        case 11: 
          localcnp.TuW = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(123619);
          return 0;
        case 12: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eyy();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eyy)localObject2).parseFrom((byte[])localObject1);
            }
            localcnp.Tvl = ((eyy)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123619);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dy();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dy)localObject2).parseFrom((byte[])localObject1);
          }
          localcnp.TuX = ((dy)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(123619);
        return 0;
      }
      AppMethodBeat.o(123619);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cnp
 * JD-Core Version:    0.7.0.1
 */