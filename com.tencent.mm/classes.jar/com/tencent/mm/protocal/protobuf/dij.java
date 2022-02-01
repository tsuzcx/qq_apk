package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dij
  extends dyy
{
  public String AesKey;
  public String SAx;
  public String TPD;
  public int TPH;
  public String TPI;
  public int TPJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(240999);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(240999);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.TPD != null) {
        paramVarArgs.f(2, this.TPD);
      }
      if (this.SAx != null) {
        paramVarArgs.f(3, this.SAx);
      }
      if (this.AesKey != null) {
        paramVarArgs.f(4, this.AesKey);
      }
      paramVarArgs.aY(6, this.TPH);
      if (this.TPI != null) {
        paramVarArgs.f(8, this.TPI);
      }
      paramVarArgs.aY(9, this.TPJ);
      AppMethodBeat.o(240999);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label680;
      }
    }
    label680:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.TPD != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.TPD);
      }
      i = paramInt;
      if (this.SAx != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.SAx);
      }
      paramInt = i;
      if (this.AesKey != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.AesKey);
      }
      i = paramInt + g.a.a.b.b.a.bM(6, this.TPH);
      paramInt = i;
      if (this.TPI != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.TPI);
      }
      i = g.a.a.b.b.a.bM(9, this.TPJ);
      AppMethodBeat.o(240999);
      return paramInt + i;
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
          AppMethodBeat.o(240999);
          throw paramVarArgs;
        }
        AppMethodBeat.o(240999);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        dij localdij = (dij)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 5: 
        case 7: 
        default: 
          AppMethodBeat.o(240999);
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
            localdij.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(240999);
          return 0;
        case 2: 
          localdij.TPD = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(240999);
          return 0;
        case 3: 
          localdij.SAx = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(240999);
          return 0;
        case 4: 
          localdij.AesKey = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(240999);
          return 0;
        case 6: 
          localdij.TPH = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(240999);
          return 0;
        case 8: 
          localdij.TPI = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(240999);
          return 0;
        }
        localdij.TPJ = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(240999);
        return 0;
      }
      AppMethodBeat.o(240999);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dij
 * JD-Core Version:    0.7.0.1
 */