package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class fni
  extends dyy
{
  public int TWD;
  public int ULI;
  public int ULJ;
  public String fJj;
  public String md5;
  public String url;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123686);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123686);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.url != null) {
        paramVarArgs.f(2, this.url);
      }
      if (this.md5 != null) {
        paramVarArgs.f(3, this.md5);
      }
      paramVarArgs.aY(4, this.version);
      paramVarArgs.aY(5, this.ULI);
      paramVarArgs.aY(6, this.TWD);
      paramVarArgs.aY(7, this.ULJ);
      if (this.fJj != null) {
        paramVarArgs.f(8, this.fJj);
      }
      AppMethodBeat.o(123686);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label692;
      }
    }
    label692:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.url);
      }
      i = paramInt;
      if (this.md5 != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.md5);
      }
      i = i + g.a.a.b.b.a.bM(4, this.version) + g.a.a.b.b.a.bM(5, this.ULI) + g.a.a.b.b.a.bM(6, this.TWD) + g.a.a.b.b.a.bM(7, this.ULJ);
      paramInt = i;
      if (this.fJj != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.fJj);
      }
      AppMethodBeat.o(123686);
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
          AppMethodBeat.o(123686);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123686);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        fni localfni = (fni)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123686);
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
            localfni.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(123686);
          return 0;
        case 2: 
          localfni.url = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(123686);
          return 0;
        case 3: 
          localfni.md5 = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(123686);
          return 0;
        case 4: 
          localfni.version = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(123686);
          return 0;
        case 5: 
          localfni.ULI = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(123686);
          return 0;
        case 6: 
          localfni.TWD = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(123686);
          return 0;
        case 7: 
          localfni.ULJ = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(123686);
          return 0;
        }
        localfni.fJj = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(123686);
        return 0;
      }
      AppMethodBeat.o(123686);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fni
 * JD-Core Version:    0.7.0.1
 */