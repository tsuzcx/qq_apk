package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dvt
  extends dyy
{
  public String RPs;
  public int TwB;
  public LinkedList<ezh> UbJ;
  public eti UbK;
  public int rVx;
  
  public dvt()
  {
    AppMethodBeat.i(56260);
    this.UbJ = new LinkedList();
    AppMethodBeat.o(56260);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56261);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(56261);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.rVx);
      paramVarArgs.e(3, 8, this.UbJ);
      if (this.RPs != null) {
        paramVarArgs.f(4, this.RPs);
      }
      paramVarArgs.aY(5, this.TwB);
      if (this.UbK != null)
      {
        paramVarArgs.oE(6, this.UbK.computeSize());
        this.UbK.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(56261);
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
      int i = paramInt + g.a.a.b.b.a.bM(2, this.rVx) + g.a.a.a.c(3, 8, this.UbJ);
      paramInt = i;
      if (this.RPs != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.RPs);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.TwB);
      paramInt = i;
      if (this.UbK != null) {
        paramInt = i + g.a.a.a.oD(6, this.UbK.computeSize());
      }
      AppMethodBeat.o(56261);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.UbJ.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(56261);
          throw paramVarArgs;
        }
        AppMethodBeat.o(56261);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dvt localdvt = (dvt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56261);
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
            localdvt.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(56261);
          return 0;
        case 2: 
          localdvt.rVx = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(56261);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ezh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ezh)localObject2).parseFrom((byte[])localObject1);
            }
            localdvt.UbJ.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(56261);
          return 0;
        case 4: 
          localdvt.RPs = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(56261);
          return 0;
        case 5: 
          localdvt.TwB = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(56261);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eti();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eti)localObject2).parseFrom((byte[])localObject1);
          }
          localdvt.UbK = ((eti)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(56261);
        return 0;
      }
      AppMethodBeat.o(56261);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvt
 * JD-Core Version:    0.7.0.1
 */