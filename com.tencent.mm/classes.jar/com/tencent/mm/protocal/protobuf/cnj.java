package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class cnj
  extends dyy
{
  public String CQz;
  public String RGJ;
  public LinkedList<eax> Tau;
  public cmt TuR;
  public String TuU;
  public String TuV;
  public String TuW;
  public dy TuX;
  public com.tencent.mm.cd.b TuY;
  public String TuZ;
  
  public cnj()
  {
    AppMethodBeat.i(123609);
    this.Tau = new LinkedList();
    AppMethodBeat.o(123609);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123610);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123610);
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
      paramVarArgs.e(3, 8, this.Tau);
      if (this.CQz != null) {
        paramVarArgs.f(4, this.CQz);
      }
      if (this.RGJ != null) {
        paramVarArgs.f(5, this.RGJ);
      }
      if (this.TuU != null) {
        paramVarArgs.f(6, this.TuU);
      }
      if (this.TuV != null) {
        paramVarArgs.f(7, this.TuV);
      }
      if (this.TuW != null) {
        paramVarArgs.f(8, this.TuW);
      }
      if (this.TuX != null)
      {
        paramVarArgs.oE(9, this.TuX.computeSize());
        this.TuX.writeFields(paramVarArgs);
      }
      if (this.TuY != null) {
        paramVarArgs.c(10, this.TuY);
      }
      if (this.TuZ != null) {
        paramVarArgs.f(11, this.TuZ);
      }
      AppMethodBeat.o(123610);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1150;
      }
    }
    label1150:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.TuR != null) {
        i = paramInt + g.a.a.a.oD(2, this.TuR.computeSize());
      }
      i += g.a.a.a.c(3, 8, this.Tau);
      paramInt = i;
      if (this.CQz != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.CQz);
      }
      i = paramInt;
      if (this.RGJ != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.RGJ);
      }
      paramInt = i;
      if (this.TuU != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.TuU);
      }
      i = paramInt;
      if (this.TuV != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.TuV);
      }
      paramInt = i;
      if (this.TuW != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.TuW);
      }
      i = paramInt;
      if (this.TuX != null) {
        i = paramInt + g.a.a.a.oD(9, this.TuX.computeSize());
      }
      paramInt = i;
      if (this.TuY != null) {
        paramInt = i + g.a.a.b.b.a.b(10, this.TuY);
      }
      i = paramInt;
      if (this.TuZ != null) {
        i = paramInt + g.a.a.b.b.a.g(11, this.TuZ);
      }
      AppMethodBeat.o(123610);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Tau.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(123610);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123610);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cnj localcnj = (cnj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123610);
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
            localcnj.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123610);
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
            localcnj.TuR = ((cmt)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123610);
          return 0;
        case 3: 
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
            localcnj.Tau.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123610);
          return 0;
        case 4: 
          localcnj.CQz = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(123610);
          return 0;
        case 5: 
          localcnj.RGJ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(123610);
          return 0;
        case 6: 
          localcnj.TuU = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(123610);
          return 0;
        case 7: 
          localcnj.TuV = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(123610);
          return 0;
        case 8: 
          localcnj.TuW = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(123610);
          return 0;
        case 9: 
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
            localcnj.TuX = ((dy)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123610);
          return 0;
        case 10: 
          localcnj.TuY = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(123610);
          return 0;
        }
        localcnj.TuZ = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(123610);
        return 0;
      }
      AppMethodBeat.o(123610);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cnj
 * JD-Core Version:    0.7.0.1
 */