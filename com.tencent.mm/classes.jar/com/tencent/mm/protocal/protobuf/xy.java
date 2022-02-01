package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class xy
  extends dyy
{
  public String Igm;
  public String Ign;
  public String Igo;
  public String RLA;
  public int fwx;
  public String tVo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72453);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72453);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.fwx);
      if (this.tVo != null) {
        paramVarArgs.f(3, this.tVo);
      }
      if (this.Igm != null) {
        paramVarArgs.f(4, this.Igm);
      }
      if (this.Ign != null) {
        paramVarArgs.f(5, this.Ign);
      }
      if (this.Igo != null) {
        paramVarArgs.f(6, this.Igo);
      }
      if (this.RLA != null) {
        paramVarArgs.f(7, this.RLA);
      }
      AppMethodBeat.o(72453);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label684;
      }
    }
    label684:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.fwx);
      paramInt = i;
      if (this.tVo != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.tVo);
      }
      i = paramInt;
      if (this.Igm != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.Igm);
      }
      paramInt = i;
      if (this.Ign != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.Ign);
      }
      i = paramInt;
      if (this.Igo != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.Igo);
      }
      paramInt = i;
      if (this.RLA != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.RLA);
      }
      AppMethodBeat.o(72453);
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
          AppMethodBeat.o(72453);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72453);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        xy localxy = (xy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72453);
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
            localxy.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(72453);
          return 0;
        case 2: 
          localxy.fwx = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(72453);
          return 0;
        case 3: 
          localxy.tVo = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72453);
          return 0;
        case 4: 
          localxy.Igm = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72453);
          return 0;
        case 5: 
          localxy.Ign = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72453);
          return 0;
        case 6: 
          localxy.Igo = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72453);
          return 0;
        }
        localxy.RLA = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(72453);
        return 0;
      }
      AppMethodBeat.o(72453);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.xy
 * JD-Core Version:    0.7.0.1
 */