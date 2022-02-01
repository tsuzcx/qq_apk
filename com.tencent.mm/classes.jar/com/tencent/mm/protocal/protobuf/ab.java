package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ab
  extends dyy
{
  public String RDX;
  public int RDY;
  public int RDZ;
  public String REa;
  public String REb;
  public LinkedList<n> fbZ;
  public int fwx;
  public String tVo;
  
  public ab()
  {
    AppMethodBeat.i(91337);
    this.fwx = 268513600;
    this.tVo = "请求不成功，请稍候再试";
    this.fbZ = new LinkedList();
    AppMethodBeat.o(91337);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91338);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91338);
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
      paramVarArgs.e(4, 8, this.fbZ);
      if (this.REb != null) {
        paramVarArgs.f(5, this.REb);
      }
      if (this.RDX != null) {
        paramVarArgs.f(6, this.RDX);
      }
      paramVarArgs.aY(7, this.RDY);
      paramVarArgs.aY(8, this.RDZ);
      if (this.REa != null) {
        paramVarArgs.f(9, this.REa);
      }
      AppMethodBeat.o(91338);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label834;
      }
    }
    label834:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.fwx);
      paramInt = i;
      if (this.tVo != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.tVo);
      }
      i = paramInt + g.a.a.a.c(4, 8, this.fbZ);
      paramInt = i;
      if (this.REb != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.REb);
      }
      i = paramInt;
      if (this.RDX != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.RDX);
      }
      i = i + g.a.a.b.b.a.bM(7, this.RDY) + g.a.a.b.b.a.bM(8, this.RDZ);
      paramInt = i;
      if (this.REa != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.REa);
      }
      AppMethodBeat.o(91338);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.fbZ.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91338);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91338);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ab localab = (ab)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91338);
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
            localab.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91338);
          return 0;
        case 2: 
          localab.fwx = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91338);
          return 0;
        case 3: 
          localab.tVo = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91338);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new n();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((n)localObject2).parseFrom((byte[])localObject1);
            }
            localab.fbZ.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91338);
          return 0;
        case 5: 
          localab.REb = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91338);
          return 0;
        case 6: 
          localab.RDX = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91338);
          return 0;
        case 7: 
          localab.RDY = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91338);
          return 0;
        case 8: 
          localab.RDZ = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91338);
          return 0;
        }
        localab.REa = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(91338);
        return 0;
      }
      AppMethodBeat.o(91338);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ab
 * JD-Core Version:    0.7.0.1
 */