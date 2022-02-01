package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public class aad
  extends dyy
{
  public String Smr;
  public String bhm;
  public String qBF;
  public String qBG;
  public int status;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123566);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123566);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.status);
      if (this.qBF != null) {
        paramVarArgs.f(3, this.qBF);
      }
      if (this.bhm != null) {
        paramVarArgs.f(4, this.bhm);
      }
      if (this.Smr != null) {
        paramVarArgs.f(5, this.Smr);
      }
      if (this.qBG != null) {
        paramVarArgs.f(6, this.qBG);
      }
      AppMethodBeat.o(123566);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label624;
      }
    }
    label624:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.status);
      paramInt = i;
      if (this.qBF != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.qBF);
      }
      i = paramInt;
      if (this.bhm != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.bhm);
      }
      paramInt = i;
      if (this.Smr != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.Smr);
      }
      i = paramInt;
      if (this.qBG != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.qBG);
      }
      AppMethodBeat.o(123566);
      return i;
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
          AppMethodBeat.o(123566);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123566);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        aad localaad = (aad)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123566);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jh localjh = new jh();
            if ((localObject != null) && (localObject.length > 0)) {
              localjh.parseFrom((byte[])localObject);
            }
            localaad.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(123566);
          return 0;
        case 2: 
          localaad.status = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(123566);
          return 0;
        case 3: 
          localaad.qBF = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(123566);
          return 0;
        case 4: 
          localaad.bhm = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(123566);
          return 0;
        case 5: 
          localaad.Smr = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(123566);
          return 0;
        }
        localaad.qBG = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(123566);
        return 0;
      }
      AppMethodBeat.o(123566);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aad
 * JD-Core Version:    0.7.0.1
 */