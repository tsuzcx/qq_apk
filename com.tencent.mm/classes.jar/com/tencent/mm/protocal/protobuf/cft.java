package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cft
  extends dyy
{
  public int Teo;
  public LinkedList<fgs> Tep;
  public String TmV;
  public String TmX;
  public int TmY;
  public String TmZ;
  public String Tna;
  public String Tnb;
  
  public cft()
  {
    AppMethodBeat.i(32305);
    this.Tep = new LinkedList();
    AppMethodBeat.o(32305);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32306);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32306);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.Teo);
      paramVarArgs.e(3, 8, this.Tep);
      if (this.TmX != null) {
        paramVarArgs.f(4, this.TmX);
      }
      if (this.TmV != null) {
        paramVarArgs.f(5, this.TmV);
      }
      paramVarArgs.aY(6, this.TmY);
      if (this.TmZ != null) {
        paramVarArgs.f(7, this.TmZ);
      }
      if (this.Tna != null) {
        paramVarArgs.f(8, this.Tna);
      }
      if (this.Tnb != null) {
        paramVarArgs.f(9, this.Tnb);
      }
      AppMethodBeat.o(32306);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label865;
      }
    }
    label865:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.Teo) + g.a.a.a.c(3, 8, this.Tep);
      paramInt = i;
      if (this.TmX != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.TmX);
      }
      i = paramInt;
      if (this.TmV != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.TmV);
      }
      i += g.a.a.b.b.a.bM(6, this.TmY);
      paramInt = i;
      if (this.TmZ != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.TmZ);
      }
      i = paramInt;
      if (this.Tna != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.Tna);
      }
      paramInt = i;
      if (this.Tnb != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.Tnb);
      }
      AppMethodBeat.o(32306);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Tep.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32306);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32306);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cft localcft = (cft)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32306);
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
            localcft.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32306);
          return 0;
        case 2: 
          localcft.Teo = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32306);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fgs();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fgs)localObject2).parseFrom((byte[])localObject1);
            }
            localcft.Tep.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32306);
          return 0;
        case 4: 
          localcft.TmX = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32306);
          return 0;
        case 5: 
          localcft.TmV = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32306);
          return 0;
        case 6: 
          localcft.TmY = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32306);
          return 0;
        case 7: 
          localcft.TmZ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32306);
          return 0;
        case 8: 
          localcft.Tna = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32306);
          return 0;
        }
        localcft.Tnb = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(32306);
        return 0;
      }
      AppMethodBeat.o(32306);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cft
 * JD-Core Version:    0.7.0.1
 */