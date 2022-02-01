package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class drm
  extends dyy
{
  public String Igo;
  public String Igp;
  public String TYA;
  public String TYv;
  public int TYw;
  public String TYx;
  public String TYy;
  public String TYz;
  public int amount;
  public int fwx;
  public String msn;
  public int state;
  public String tVo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72567);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72567);
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
      paramVarArgs.aY(4, this.state);
      if (this.TYv != null) {
        paramVarArgs.f(5, this.TYv);
      }
      paramVarArgs.aY(6, this.amount);
      paramVarArgs.aY(7, this.TYw);
      if (this.Igo != null) {
        paramVarArgs.f(8, this.Igo);
      }
      if (this.TYx != null) {
        paramVarArgs.f(9, this.TYx);
      }
      if (this.Igp != null) {
        paramVarArgs.f(10, this.Igp);
      }
      if (this.TYy != null) {
        paramVarArgs.f(11, this.TYy);
      }
      if (this.TYz != null) {
        paramVarArgs.f(12, this.TYz);
      }
      if (this.TYA != null) {
        paramVarArgs.f(14, this.TYA);
      }
      if (this.msn != null) {
        paramVarArgs.f(15, this.msn);
      }
      AppMethodBeat.o(72567);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1072;
      }
    }
    label1072:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.fwx);
      paramInt = i;
      if (this.tVo != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.tVo);
      }
      i = paramInt + g.a.a.b.b.a.bM(4, this.state);
      paramInt = i;
      if (this.TYv != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.TYv);
      }
      i = paramInt + g.a.a.b.b.a.bM(6, this.amount) + g.a.a.b.b.a.bM(7, this.TYw);
      paramInt = i;
      if (this.Igo != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.Igo);
      }
      i = paramInt;
      if (this.TYx != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.TYx);
      }
      paramInt = i;
      if (this.Igp != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.Igp);
      }
      i = paramInt;
      if (this.TYy != null) {
        i = paramInt + g.a.a.b.b.a.g(11, this.TYy);
      }
      paramInt = i;
      if (this.TYz != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.TYz);
      }
      i = paramInt;
      if (this.TYA != null) {
        i = paramInt + g.a.a.b.b.a.g(14, this.TYA);
      }
      paramInt = i;
      if (this.msn != null) {
        paramInt = i + g.a.a.b.b.a.g(15, this.msn);
      }
      AppMethodBeat.o(72567);
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
          AppMethodBeat.o(72567);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72567);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        drm localdrm = (drm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 13: 
        default: 
          AppMethodBeat.o(72567);
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
            localdrm.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(72567);
          return 0;
        case 2: 
          localdrm.fwx = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(72567);
          return 0;
        case 3: 
          localdrm.tVo = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72567);
          return 0;
        case 4: 
          localdrm.state = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(72567);
          return 0;
        case 5: 
          localdrm.TYv = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72567);
          return 0;
        case 6: 
          localdrm.amount = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(72567);
          return 0;
        case 7: 
          localdrm.TYw = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(72567);
          return 0;
        case 8: 
          localdrm.Igo = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72567);
          return 0;
        case 9: 
          localdrm.TYx = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72567);
          return 0;
        case 10: 
          localdrm.Igp = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72567);
          return 0;
        case 11: 
          localdrm.TYy = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72567);
          return 0;
        case 12: 
          localdrm.TYz = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72567);
          return 0;
        case 14: 
          localdrm.TYA = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72567);
          return 0;
        }
        localdrm.msn = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(72567);
        return 0;
      }
      AppMethodBeat.o(72567);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.drm
 * JD-Core Version:    0.7.0.1
 */