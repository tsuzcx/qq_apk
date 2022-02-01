package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class drx
  extends dyy
{
  public String RLy;
  public LinkedList<eup> TYG;
  public LinkedList<eup> TYH;
  public int fwx;
  public String tVo;
  
  public drx()
  {
    AppMethodBeat.i(72572);
    this.TYG = new LinkedList();
    this.TYH = new LinkedList();
    AppMethodBeat.o(72572);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72573);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72573);
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
      paramVarArgs.e(4, 8, this.TYG);
      paramVarArgs.e(5, 8, this.TYH);
      if (this.RLy != null) {
        paramVarArgs.f(6, this.RLy);
      }
      AppMethodBeat.o(72573);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label736;
      }
    }
    label736:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.fwx);
      paramInt = i;
      if (this.tVo != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.tVo);
      }
      i = paramInt + g.a.a.a.c(4, 8, this.TYG) + g.a.a.a.c(5, 8, this.TYH);
      paramInt = i;
      if (this.RLy != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.RLy);
      }
      AppMethodBeat.o(72573);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TYG.clear();
        this.TYH.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(72573);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72573);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        drx localdrx = (drx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72573);
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
            localdrx.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72573);
          return 0;
        case 2: 
          localdrx.fwx = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(72573);
          return 0;
        case 3: 
          localdrx.tVo = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72573);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eup();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eup)localObject2).parseFrom((byte[])localObject1);
            }
            localdrx.TYG.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72573);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eup();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eup)localObject2).parseFrom((byte[])localObject1);
            }
            localdrx.TYH.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72573);
          return 0;
        }
        localdrx.RLy = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(72573);
        return 0;
      }
      AppMethodBeat.o(72573);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.drx
 * JD-Core Version:    0.7.0.1
 */